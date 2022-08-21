package com.ryota.cofuser.mapper;

import com.ryota.cofuser.entity.CofUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ryota.cofuser.vo.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author ryota
 * @since 2022-08-21
 */
@Mapper
public interface CofUserMapper extends BaseMapper<CofUser> {

    List<UserPO> get(@Param("accounts") List<String> accounts);
}
