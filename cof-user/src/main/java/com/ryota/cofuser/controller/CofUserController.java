package com.ryota.cofuser.controller;


import com.ryota.cofuser.service.CofUserService;
import com.ryota.cofuser.vo.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author ryota
 * @since 2022-08-21
 */
@RestController
@RequestMapping("/cof-user")
public class CofUserController {
    
    @Autowired
    private CofUserService cofUserService;
    
    @PostMapping("get")
    public List<UserPO> get(@RequestParam("accounts") List<String> accounts){
        return cofUserService.get(accounts);
    }
}

