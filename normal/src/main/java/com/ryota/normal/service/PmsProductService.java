package com.ryota.normal.service;

import com.ryota.common.common.Result;
import com.ryota.normal.entity.PmsProduct;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品信息 服务类
 * </p>
 *
 * @author ryota
 * @since 2022-08-05
 */
public interface PmsProductService extends IService<PmsProduct> {

    /**
     * 根据id获取
     * @param id
     * @return
     */
    Result get(Long id);

    /**
     * 创建商品并创建缓存
     * @param pmsProduct
     * @return
     */
    Result add(PmsProduct pmsProduct);
}
