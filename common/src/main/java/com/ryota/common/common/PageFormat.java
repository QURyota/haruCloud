package com.ryota.common.common;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * @Author Ryota
 */
@Data
public class PageFormat {

    private long total;
    private List<?> rows;

    public PageFormat(List<?> list){
        PageInfo<?> info = new PageInfo<>(list);
        this.total = info.getTotal();
        this.rows = info.getList();
    }

}
