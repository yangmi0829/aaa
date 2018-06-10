package com.liugh.service;

import com.liugh.entity.Menu;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liugh123
 * @since 2018-05-03
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 根据 Ids 查询
     * @param permissionIds ids
     * @return  权限List
     */
    List<Menu> selectByIds(List<Integer> permissionIds);

    /**
     * 根据角色查询菜单
     * @param roleId 角色主键
     * @param status 状态(0：禁用；1：启用)
     * @return
     */
    List<Menu> findMenuByRoleId(Integer roleId, int status);
}
