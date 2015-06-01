package com.aisino.cec.product.vo;

import org.springframework.web.multipart.MultipartFile;
import com.aisino.cec.product.model.Image;

public class ImageInfoVo {
    
    /**图片model*/
    private Image image;
    
    /**原图片信息*/
    private MultipartFile multiPartFile;
    
    
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    
    public MultipartFile getMultiPartFile() {
        return multiPartFile;
    }

    
    public void setMultiPartFile(MultipartFile multiPartFile) {
        this.multiPartFile = multiPartFile;
    }
    

}
