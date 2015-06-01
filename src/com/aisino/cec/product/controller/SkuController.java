package com.aisino.cec.product.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import sun.misc.BASE64Encoder;

import com.aisino.cec.common.util.random.RandomUtil;
import com.aisino.cec.common.util.web.BaseController;
import com.aisino.cec.product.conditionbean.SkuAttrCondition;
import com.aisino.cec.product.model.Image;
import com.aisino.cec.product.model.SkuAttr;
import com.aisino.cec.product.model.SkuOption;
import com.aisino.cec.product.service.ISkuAttrService;
import com.aisino.cec.product.service.ISkuOptionService;
import com.aisino.cec.product.vo.ImageInfoVo;
import com.aisino.cec.user.model.User;
import com.aisino.cec.user.service.IUserService;

/**
 * @ClassName: SkuController
 * @Description: sku属性和属性值操作
 * @author cr
 * @version V1.0
 */

@Controller
@RequestMapping(value="/skuManage")
public class SkuController extends BaseController{
    
    @Resource(name="skuAttrService")
    private ISkuAttrService skuAttrService;
    
    @Resource(name="skuOptionService")
    private ISkuOptionService skuOptionService;
    
    @Resource(name="userService")
    private IUserService userService;
    
    //缓存图片信息
    List<Image> imageData = new ArrayList<Image>();
    
    //缓存删除图片信息
    List<Image> delImageData = new ArrayList<Image>();
    
    //缓存最终传入图片服务器的图片信息
    List<ImageInfoVo>  imageServData = new ArrayList<ImageInfoVo>();
    
//    /** 暂时存储图片*/
//    List<ImagesEntity> picturesData = new ArrayList<ImagesEntity>();
//    /** 要删除的图片 */
//    List<ImagesEntity> deletePicturesData = new ArrayList<ImagesEntity>();
    
    /**
     * 插入一条sku属性记录
     * @param skuAttr
     */
    @RequestMapping("/insertSkuAttr/{categoryId}")
    @ResponseBody
    public void insertSkuAttr(SkuAttr skuAttr, @PathVariable String categoryId, HttpServletRequest request, HttpServletResponse response)
        throws JsonGenerationException, JsonMappingException, IOException {
       
        boolean resultCheck = false;
        ObjectMapper resultMapper = new ObjectMapper();
        Map<String, Object> result = new HashMap<String, Object>();
        String userName = request.getRemoteUser();
        List<User> userList = userService.getByUserName(userName);
        if(!userList.isEmpty()) {
            skuAttr.setCreateUserId(userList.get(0).getUserId());
        }
       
        try {
            skuAttr.setCategoryId(categoryId);
            resultCheck = skuAttrService.insertSkuAttr(skuAttr);
            if(resultCheck) {
                result.put("result", "true");
                result.put("skuAttrId", skuAttr.getSkuAttrId());
         
            } else {
                result.put("result", "false");
            }
        }catch(Exception e) {
            result.put("result", "false");
            e.printStackTrace();
            
        }      
        resultMapper.writeValue(response.getWriter(), result);
    }
    
    @RequestMapping("/skuAttr/{skuAttrId}")
    @ResponseBody
    public void getSkuAttrById(@PathVariable String skuAttrId, HttpServletRequest request, HttpServletResponse response)
        throws JsonGenerationException, JsonMappingException, IOException {
        
        SkuAttr skuAttr = skuAttrService.findSkuAttrById(skuAttrId);
        ObjectMapper resultMapper = new ObjectMapper();
        resultMapper.writeValue(response.getWriter(), skuAttr);
    }
    
    /**
     * 根据分类id显示sku属性
     * @param classifyId
     * @param request
     * @param response
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping("/category/{categoryId}")
    @ResponseBody
    public void getSkuAttrByClassify(@PathVariable String categoryId, HttpServletRequest request, HttpServletResponse response)
        throws JsonGenerationException, JsonMappingException, IOException {
        
        SkuAttrCondition condition = new SkuAttrCondition();
        condition.setCategoryId(categoryId);
        List<SkuAttr> skuAttrList = skuAttrService.selectByCondition(condition);
        ObjectMapper resultMapper = new ObjectMapper();      
        resultMapper.writeValue(response.getWriter(), skuAttrList);
    }
    
    /**
     * 维护名称重复校验
     * @param storeName
     * @return
     */
    @RequestMapping("/storeNameCheck")
    @ResponseBody
    public String storeNameCheck(String storeName, String categoryId, String skuAttrId) {
        
        String result = "false";
        String id = skuAttrService.checkStoreName(storeName,categoryId);
        
        if(id==null) {
            result = "true";
        }
        else if(id!=null&&id.equals(skuAttrId)) {
            result = "true";
        }
        else if(id!=null&&!id.equals(skuAttrId)) {
            result = "false";
        }
        
        return result;
    }
    
    /**
     * 前端名称重复校验
     * @param frontName
     * @return
     */
    @RequestMapping("/frontNameCheck")
    @ResponseBody
    public String frontNameCheck(String frontName, String categoryId, String skuAttrId) {
        
        String result = "false";       
        String id = skuAttrService.checkFrontName(frontName, categoryId);
        if(id==null) {
            result = "true";
        }
        else if(id!=null&&id.equals(skuAttrId)) {
            result = "true";
        }
        else if(id!=null&&!id.equals(skuAttrId)) {
            result = "false";
        }
        return result;
    }
    
    /**
     * 更新一条sku属性记录
     * @param skuAttr
     */
    @RequestMapping("/updateSkuAttr/{skuAttrId}")
    @ResponseBody
    public void updateSkuAttr(SkuAttr skuAttr, @PathVariable String skuAttrId, HttpServletRequest request, HttpServletResponse response)
    throws JsonGenerationException, JsonMappingException, IOException  {
       
        boolean resultCheck = false;
        ObjectMapper resultMapper = new ObjectMapper();
        Map<String, Object> result = new HashMap<String, Object>();
        String userName = request.getRemoteUser();
        List<User> userList = userService.getByUserName(userName);
        if(!userList.isEmpty()) {
            skuAttr.setModifyUserId(userList.get(0).getUserId());
        }
       
        try {
            skuAttr.setSkuAttrId(skuAttrId);
            resultCheck = skuAttrService.updateSkuAttr(skuAttr);
            if(resultCheck) {
                result.put("result", "true");
                result.put("skuAttrId", skuAttr.getSkuAttrId());
                result.put("state", skuAttr.getState());
            } else {
                result.put("result", "false");
            }
        }catch(Exception e) {
            result.put("result", "false");
            e.printStackTrace();
            
        }        
        resultMapper.writeValue(response.getWriter(), result);
    }
    
    /**
     * 根据条件筛选查找sku属性
     * @param skuAttrCondition
     * @return
     */
    @RequestMapping("/selectByCondition")
    public List<SkuAttr> selectByCondition(SkuAttrCondition skuAttrCondition) {
        
        return null;
    }
    
    @RequestMapping("/skuOption/{skuAttrId}")
    @ResponseBody
    public void selectSkuOptionBySkuAttrId(@PathVariable String skuAttrId, HttpServletRequest request, HttpServletResponse response)
        throws JsonGenerationException, JsonMappingException, IOException {
       
        List<SkuOption> skuOptionList = skuOptionService.findSkuOptionBySkuAttrId(skuAttrId);
        ObjectMapper resultMapper = new ObjectMapper();
        resultMapper.writeValue(response.getWriter(), skuOptionList);

    }
    
    /**
     * 插入一条sku属性值信息
     * @param skuOption
     * @param skuAttrId
     * @param request
     * @param response
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping("/insertSkuOption/{skuAttrId}")
    @ResponseBody
    public void insertSkuOption(SkuOption skuOption, @PathVariable String skuAttrId, HttpServletRequest request, HttpServletResponse response) 
        throws JsonGenerationException, JsonMappingException, IOException {
        
        boolean resultCheck = false;
        ObjectMapper resultMapper = new ObjectMapper();
        Map<String, Object> result = new HashMap<String, Object>();
        String userName = request.getRemoteUser();
        List<User> userList = userService.getByUserName(userName);
        if(!userList.isEmpty()) {
            skuOption.setCreateUserId(userList.get(0).getUserId());
        }
       
        try {
            skuOption.setSkuAttrId(skuAttrId);
            resultCheck = skuOptionService.insertSkuOption(skuOption);
            if(resultCheck) {
                result.put("result", "true");
                result.put("skuOptionId", skuOption.getSkuOptionId());
         
            } else {
                result.put("result", "false");
            }
        }catch(Exception e) {
            result.put("result", "false");
            e.printStackTrace();           
        }
        
        resultMapper.writeValue(response.getWriter(), result);
    }
    
    /**
     * 校验sku属性值是否重复
     * @param value
     * @return
     */
    @RequestMapping("/valueCheck")
    @ResponseBody
    public String skuOptionValueCheck(String value, String skuAttrId, String skuOptionId) {
        String result = "false";
        String id = skuOptionService.checkValue(value, skuAttrId);
        
        if(id==null) {
            result = "true";
        }
        else if(id!=null&&id.equals(skuOptionId)) {
            result = "true";
        }
        else if(id!=null&&!id.equals(skuOptionId)) {
            result = "false";
        }
        return result;
    }

    @RequestMapping("/showSkuOption/{skuOptionId}")
    @ResponseBody
    public void getSkuOptionById(@PathVariable String skuOptionId, HttpServletRequest request, HttpServletResponse response)
        throws JsonGenerationException, JsonMappingException, IOException {

        SkuOption skuOption = skuOptionService.findSkuOptionById(skuOptionId);
        ObjectMapper resultMapper = new ObjectMapper();
        
        resultMapper.writeValue(response.getWriter(), skuOption);
    }

    /**
     * 更新sku属性值信息
     * @param skuOption
     * @param request
     * @param response
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping("/updateSkuOption/{skuOptionId}")
    @ResponseBody
    public void updateSkuOption(SkuOption skuOption, @PathVariable String skuOptionId, HttpServletRequest request, HttpServletResponse response)
        throws JsonGenerationException, JsonMappingException, IOException {

        boolean resultCheck = false;
        ObjectMapper resultMapper = new ObjectMapper();
        Map<String, Object> result = new HashMap<String, Object>();
        String userName = request.getRemoteUser();
        List<User> userList = userService.getByUserName(userName);
        if(!userList.isEmpty()) {
            skuOption.setModifyUserId(userList.get(0).getUserId());
        }
       
        try {
            skuOption.setSkuOptionId(skuOptionId);
            resultCheck = skuOptionService.updateSkuOption(skuOption);
            if(resultCheck) {
                result.put("result", "true");
                result.put("skuOptionId", skuOption.getSkuOptionId());
                result.put("state", skuOption.getState());
         
            } else {
                result.put("result", "false");
            }
        }catch(Exception e) {
            result.put("result", "false");
            e.printStackTrace();
        }
        
        resultMapper.writeValue(response.getWriter(), result);
    }
    
    /**
     * 上传图片 todo 可以保存一个临时的imageId用来标示图片
     * @param uploader
     * @param response
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping("/uploadImage")
    @ResponseBody
    public void uploadImage(MultipartHttpServletRequest  req, HttpServletResponse response)
        throws JsonGenerationException, JsonMappingException, IOException {
        
    //    MultipartHttpServletRequest req = (MultipartHttpServletRequest)request;
        MultipartFile uploadImg = req.getFile("uploadImg");
        String frontName = req.getParameter("frontName");
        String descInfo = req.getParameter("descInfo");        
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<String, Object>();
        // 上传处理默认为失败的状态
        String uploadResultCode = "failure";
        byte[] fileData = null;
        try {
            if (null == uploadImg) {
                // 未上传文件
                uploadResultCode = "NONE";
            } else {
                String fileName = uploadImg.getOriginalFilename();
                // 允许上传的文件格式
                String regex = "(?i).+?\\.(jpg|png|gif|bmp|jpeg)";
                if (!fileName.matches(regex)) {
                    // 上传的文件格式为不允许上传的格式
                    uploadResultCode = "NOTALLOW";
                } else if(uploadImg.getSize()/1024/1024 > 5) {
                    uploadResultCode = "toBig";
                }else {

                    fileData = IOUtils.toByteArray(uploadImg.getInputStream());
                    IOUtils.closeQuietly(uploadImg.getInputStream());
                    // 图片数据需要经过base64转码
                    BASE64Encoder enc = new BASE64Encoder();
                //    imagesEntity.setImageByteData("data:image/gif;base64," + enc.encode(fileData));
                    // 转换为缩略图
              //      byte[] thumbnailsByte = ImageUtil.byteToThumbnails(fileData, 175, 225, true);
               //     imagesEntity.setThumbnailsByteData("data:image/gif;base64," + enc.encode(thumbnailsByte));
                    
                    String thumbnailsByteData = "data:image/gif;base64," + enc.encode(fileData);
                    
                    uploadResultCode = "SUCCESS";
           
                    Image image = new Image();
                    image.setBinaryInfoId(thumbnailsByteData);
                    image.setImageId(RandomUtil.getRandom16String());
                    image.setFrontName(frontName);
                    image.setDescInfo(descInfo);
                    
                    //用于前台页面图片的反显
                    map.put("imageData", thumbnailsByteData);
                    map.put("imageId", image.getImageId());
                    
                    //将图片base64码、frontName、descInfo缓存到全局变量中
                    this.imageData.add(image);
                                       
                    ImageInfoVo imageInfoVo = new ImageInfoVo();
                    imageInfoVo.setImage(image);
                    imageInfoVo.setMultiPartFile(uploadImg);
                  //将image原图、image缓存到全局变量中
                    this.imageServData.add(imageInfoVo);
                    
                }
            }
        } catch (Exception e) {
            uploadResultCode = "failure";
            e.printStackTrace();
        }
       
        map.put("uploadResultCode", uploadResultCode);
        response.setContentType("text/html;charset=UTF-8");
        mapper.writeValue(response.getWriter(), map);
    } 
    
    /**
     * 删除图片
     * @param imgId
     * @param response
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping("/removeImg")
    @ResponseBody
    public void removeImg(String imageId, HttpServletResponse response) 
        throws JsonGenerationException, JsonMappingException, IOException {
        
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            //将删除的元素缓存到delImageData全局变量中
            for (Image image : this.imageData) {
                if (image.getImageId().equals(imageId)) {
                    this.delImageData.add(image);
                }
            }
            
            //根据imageId来标示图片，从全局变量imageServData中删除元素
            Iterator<ImageInfoVo> iter = (Iterator<ImageInfoVo>) this.imageServData.iterator(); 
            while(iter.hasNext()) {
                ImageInfoVo item = iter.next();
                String id = item.getImage().getImageId();
                String frontName = item.getImage().getFrontName();
               
                if(null!=id&&id.equals(imageId)) {
                    this.imageServData.remove(item);
                    break;
                }
            }
            System.out.println( this.imageServData.size());
            
            //从imageData缓存中删除元素
            this.imageData.removeAll(this.delImageData);
            this.delImageData.clear();
            map.put("imageData", this.imageData);
            map.put("result", "success");
        } catch (Exception e) {
            map.put("result", "fail");
            e.printStackTrace();
        }
        mapper.writeValue(response.getWriter(), map);
    }
    
    
    /**
     * 清除图片缓存
     * @param response
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping("/clearImg")
    @ResponseBody
    public void clearImg(HttpServletResponse response) 
        throws JsonGenerationException, JsonMappingException, IOException {
        
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            this.imageData.clear();
            this.delImageData.clear();
            this.imageServData.clear();
            map.put("result", "success");
        } catch(Exception e) {
            map.put("result", "fail");
            e.printStackTrace();
        }
        
        mapper.writeValue(response.getWriter(), map);
    }

}
