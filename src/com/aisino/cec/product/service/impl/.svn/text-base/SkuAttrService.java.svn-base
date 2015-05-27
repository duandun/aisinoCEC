package com.aisino.cec.product.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisino.cec.common.util.random.IMajorKey;
import com.aisino.cec.product.conditionbean.SkuAttrCondition;
import com.aisino.cec.product.dao.SkuAttrMapper;
import com.aisino.cec.product.enumpackage.SkuAttrEnum;
import com.aisino.cec.product.model.SkuAttr;
import com.aisino.cec.product.service.ISkuAttrService;

/**
 * sku属性service
 * 
 * @author leo
 */
@Service(value = "skuAttrService")
public class SkuAttrService implements ISkuAttrService {

    @Autowired
    private SkuAttrMapper skuAttrMapper;

    @Autowired
    private IMajorKey majorKey;

    @Override
    public boolean insertSkuAttr(SkuAttr skuAttr) {
        boolean result = false;
        try {
            skuAttr.setSkuAttrId("p_" + majorKey.getMajorKey());
            skuAttr.setCreateTime(new Date());
            if (skuAttr.getState().equals(SkuAttrEnum.SKU_ATTR_ENABLE.getKey())) {
                skuAttr.setStateValue(SkuAttrEnum.SKU_ATTR_ENABLE.getValue());
            }
            if (skuAttr.getState().equals(SkuAttrEnum.SKU_ATTR_DISABLE.getKey())) {
                skuAttr.setStateValue(SkuAttrEnum.SKU_ATTR_DISABLE.getValue());
            }
            skuAttrMapper.insert(skuAttr);
            result = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateSkuAttr(SkuAttr skuAttr) {
        boolean result = false;
        try {
            skuAttr.setModifyTime(new Date());
            if (skuAttr.getState().equals(SkuAttrEnum.SKU_ATTR_ENABLE.getKey())) {
                skuAttr.setStateValue(SkuAttrEnum.SKU_ATTR_ENABLE.getValue());
            }
            if (skuAttr.getState().equals(SkuAttrEnum.SKU_ATTR_DISABLE.getKey())) {
                skuAttr.setStateValue(SkuAttrEnum.SKU_ATTR_DISABLE.getValue());
            }
            skuAttrMapper.updateByPrimaryKey(skuAttr);
            result = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<SkuAttr> selectByCondition(SkuAttrCondition condition) {
        return skuAttrMapper.selectByCondition(condition);
    }

    @Override
    public SkuAttr findSkuAttrById(String skuAttrId) {
        return skuAttrMapper.selectByPrimaryKey(skuAttrId);
    }

    @Override
    public boolean deleteSkuAttr(SkuAttr skuAttr) {
        boolean result = false;
        try {
            skuAttr.setModifyTime(new Date());
            skuAttr.setState(SkuAttrEnum.SKU_ATTR_DELETED.getKey());
            skuAttr.setStateValue(SkuAttrEnum.SKU_ATTR_DELETED.getValue());
            skuAttrMapper.deleteSkuAttr(skuAttr);
            result = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String checkFrontName(String frontName, String categoryId) {
        String checkResult = null;
        List<SkuAttr> skuAttrList = skuAttrMapper.checkFrontName(frontName, categoryId);
        if (null != skuAttrList && !skuAttrList.isEmpty()) {
            checkResult = skuAttrList.get(0).getSkuAttrId();
        }
        return checkResult;
    }

    @Override
    public String checkStoreName(String storeName, String categoryId) {
        String checkResult = null;
        List<SkuAttr> skuAttrList = skuAttrMapper.checkStoreName(storeName, categoryId);
        if (null != skuAttrList && !skuAttrList.isEmpty()) {
            checkResult = skuAttrList.get(0).getSkuAttrId();
        }
        return checkResult;
    }
}
