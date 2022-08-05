package com.ryota.normal.controller;


import com.ryota.common.common.Result;
import com.ryota.common.util.RedisUtil;
import com.ryota.normal.entity.PmsProduct;
import com.ryota.normal.service.PmsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 商品信息 前端控制器
 * </p>
 *
 * @author ryota
 * @since 2022-08-05
 */
@RestController
@RequestMapping("/pms-product")
@Api(tags = "商品信息操作")
public class PmsProductController {

    @Autowired
    private PmsProductService pmsProductService;

    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation("根据id查询")
    @GetMapping("get")
    public Result get(@RequestParam("id")Long id){
        return pmsProductService.get(id);
    }

    @ApiOperation("创建商品时创建缓存")
    @PostMapping("add")
    public Result add(@RequestBody PmsProduct pmsProduct){
        return pmsProductService.add(pmsProduct);
    }


    @GetMapping("addCache")
    public Result addCache(){
        redisUtil.set("s","s");
        return Result.success();
    }


}

