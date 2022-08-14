package com.ryota.normal.controller;


import com.ryota.common.common.Result;
import com.ryota.common.util.RedisUtil;
import com.ryota.normal.entity.PmsProduct;
import com.ryota.normal.service.PmsProductService;
import com.ryota.normal.util.TokenUtilService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class PmsProductController {

    @Autowired
    private TokenUtilService tokenUtilService;

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


    @ApiOperation("删除缓存")
    @GetMapping("deleteCache")
    public Result deleteCache(@RequestParam("id") Long id){
        return pmsProductService.deleteCache(id);
    }

    @ApiOperation("获取token")
    @GetMapping("/token")
    public String getToken(){
        // 获取用户信息（这里使用模拟数据）
        // 注：这里存储该内容只是举例，其作用为辅助验证，使其验证逻辑更安全，如这里存储用户信息，其目的为:
        // - 1)、使用"token"验证 Redis 中是否存在对应的 Key
        // - 2)、使用"用户信息"验证 Redis 的 Value 是否匹配。
        String userInfo = "mydlq";
        //获取token字符串,并返回
        return tokenUtilService.generateToken(userInfo);
    }

    /**
     * 接口幂等性测试接口
     *
     * @param token 幂等 Token 串
     * @return 执行结果
     */
    @PostMapping("/test")
    public String test(@RequestHeader(value = "token") String token) {
        // 获取用户信息（这里使用模拟数据）
        String userInfo = "mydlq";
        // 根据 Token 和与用户相关的信息到 Redis 验证是否存在对应的信息
        boolean result = tokenUtilService.validToken(token, userInfo);
        // 根据验证结果响应不同信息
        return result ? "正常调用" : "重复调用";
    }



}

