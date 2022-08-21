package com.ryota.cofuser.service;

import com.ryota.cofuser.entity.CofUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ryota.cofuser.vo.UserPO;

import java.util.List;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author ryota
 * @since 2022-08-21
 */
public interface CofUserService extends IService<CofUser> {

    /**
     * 根据账号获取员工信息
     * @param accounts
     * @return
     */
    List<UserPO> get(List<String> accounts);
}
