package com.aisino.cec.product.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisino.cec.common.util.random.IMajorKey;
import com.aisino.cec.product.dao.SkuOptionMapper;
import com.aisino.cec.product.enumpackage.SkuOptionEnum;
import com.aisino.cec.product.model.SkuOption;
import com.aisino.cec.product.service.ISkuOptionService;

/**
 * sku属性值service
 * 
 * @author leo
 */
@Service(value = "skuOptionService")
public class SkuOptionService implements ISkuOptionService {

    @Autowired
    private SkuOptionMapper skuOptionMapper;

    @Autowired
    private IMajorKey majorKey;

    @Override
    public boolean deleteSkuOption(SkuOption skuOption) {
        boolean result = false;
        try {
            skuOption.setModifyTime(new Date());
            skuOption.setState(SkuOptionEnum.SKU_OPTION_DELETED.getKey());
            skuOption.setStateValue(SkuOptionEnum.SKU_OPTION_DELETED.getValue());
            skuOptionMapper.deleteSkuOption(skuOption);
            result = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public SkuOption findSkuOptionById(String skuOptionId) {
        return skuOptionMapper.selectByPrimaryKey(skuOptionId);
    }

    @Override
    public List<SkuOption> findSkuOptionBySkuAttrId(String skuAttrId) {
        return skuOptionMapper.findSkuOptionBySkuAttrId(skuAttrId);
    }

    @Override
    public boolean insertSkuOption(SkuOption skuOption) {
        boolean result = false;
        try {
            skuOption.setSkuOptionId("p_" + majorKey.getMajorKey());
            skuOption.setCreateTime(new Date());
            if (skuOption.getState().equals(SkuOptionEnum.SKU_OPTION_ENABLE.getKey())) {
                skuOption.setStateValue(SkuOptionEnum.SKU_OPTION_ENABLE.getValue());
            }
            if (skuOption.getState().equals(SkuOptionEnum.SKU_OPTION_DISABLE.getKey())) {
                skuOption.setStateValue(SkuOptionEnum.SKU_OPTION_DISABLE.getValue());
            }
            skuOptionMapper.insert(skuOption);
            result = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateSkuOption(SkuOption skuOption) {
        boolean result = false;
        try {
            skuOption.setModifyTime(new Date());
            if (skuOption.getState().equals(SkuOptionEnum.SKU_OPTION_ENABLE.getKey())) {
                skuOption.setStateValue(SkuOptionEnum.SKU_OPTION_ENABLE.getValue());
            }
            if (skuOption.getState().equals(SkuOptionEnum.SKU_OPTION_DISABLE.getKey())) {
                skuOption.setStateValue(SkuOptionEnum.SKU_OPTION_DISABLE.getValue());
            }
            skuOptionMapper.updateByPrimaryKey(skuOption);
            result = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String checkValue(String value, String skuAttrId) {
        String checkResult = null;
        List<SkuOption> skuOptionList = skuOptionMapper.checkValue(value, skuAttrId);
        if (null != skuOptionList && !skuOptionList.isEmpty()) {
            checkResult = skuOptionList.get(0).getSkuOptionId();
        }
        return checkResult;
    }

}
