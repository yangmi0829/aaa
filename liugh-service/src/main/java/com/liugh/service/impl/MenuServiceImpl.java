package com.liugh.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.liugh.entity.Menu;
import com.liugh.mapper.MenuMapper;
import com.liugh.service.IMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liugh123
 * @since 2018-05-03
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    @Cacheable(value = "UserToRole",keyGenerator="wiselyKeyGenerator")
    public List<Menu> selectByIds(List<Integer> permissionIds) {
        EntityWrapper<Menu> ew = new EntityWrapper<>();
        ew.in("menu_id", permissionIds);
        return this.selectList(ew);
    }

    @Override
    @Cacheable(value = "UserToRole",keyGenerator="wiselyKeyGenerator")
    public List<Menu> findMenuByRoleId(Integer roleId, int status) {
        return menuMapper.findMenuByRoleId(roleId, status);
    }


}
