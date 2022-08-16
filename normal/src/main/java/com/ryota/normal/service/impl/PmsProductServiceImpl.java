package com.ryota.normal.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ryota.common.common.Result;
import com.ryota.common.util.RedisUtil;
import com.ryota.normal.constant.Constant;
import com.ryota.normal.entity.JsonParam;
import com.ryota.normal.entity.PmsProduct;
import com.ryota.normal.mapper.PmsProductMapper;
import com.ryota.normal.service.PmsProductService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 商品信息 服务实现类
 * </p>
 *
 * @author ryota
 * @since 2022-08-05
 */
@Service
public class PmsProductServiceImpl extends ServiceImpl<PmsProductMapper, PmsProduct> implements PmsProductService {

    @Autowired
    private PmsProductMapper pmsProductMapper;

    @Autowired
    private RedisUtil redisUtil;


    @Override
    public Result get(Long id) {
        String s = redisUtil.get(Constant.PRODUCT_PREFIX + id);
        if (StringUtils.isNotEmpty(s)) {
            PmsProduct cacheProduct = JSONObject.parseObject(s, PmsProduct.class);
            return Result.success(cacheProduct);
        }
        PmsProduct pmsProduct = pmsProductMapper.get(id);
        if (ObjectUtils.isEmpty(pmsProduct)) {
            return Result.success("没有该条数据,id为:" + id);
        }
        return Result.success(pmsProduct);
    }

    @Override
    public Result add(PmsProduct pmsProduct) {

        List<JsonParam> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            JsonParam jsonParam = new JsonParam();
            jsonParam.setContent("content"+i);
            list.add(jsonParam);
        }
        
        pmsProduct.setDescription(JSONObject.toJSONString(list));
        if (this.save(pmsProduct)) {
            redisUtil.set(Constant.PRODUCT_PREFIX + pmsProduct.getId(), JSONObject.toJSONString(pmsProduct));
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @Override
    public Result deleteCache(Long id) {
        redisUtil.del(Constant.PRODUCT_PREFIX+id);
        return Result.success();
    }
}
