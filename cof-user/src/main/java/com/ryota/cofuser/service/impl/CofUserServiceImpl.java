package com.ryota.cofuser.service.impl;

import com.ryota.cofuser.entity.CofUser;
import com.ryota.cofuser.mapper.CofUserMapper;
import com.ryota.cofuser.service.CofUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ryota.cofuser.vo.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author ryota
 * @since 2022-08-21
 */
@Service
public class CofUserServiceImpl extends ServiceImpl<CofUserMapper, CofUser> implements CofUserService {
    
    @Autowired
    private CofUserMapper cofUserMapper;

    @Override
    public List<UserPO> get(List<String> accounts) {

        List<UserPO> list = cofUserMapper.get(accounts);
        
        return list;
    }
}
