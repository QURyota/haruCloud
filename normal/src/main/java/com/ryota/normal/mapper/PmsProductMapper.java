package com.ryota.normal.mapper;

import com.ryota.normal.entity.PmsProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 商品信息 Mapper 接口
 * </p>
 *
 * @author ryota
 * @since 2022-08-05
 */
@Mapper
public interface PmsProductMapper extends BaseMapper<PmsProduct> {

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    PmsProduct get(Long id);
}
