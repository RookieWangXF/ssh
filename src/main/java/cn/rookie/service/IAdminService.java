package cn.rookie.service;

import cn.rookie.bean.Admin;

/**
 * Created by Rookie on 2016/5/18.
 * Package_name is cn.rookie.service
 * Description:
 */
public interface IAdminService {

    /**
     * 注册
     * @param admin
     */
    public void register(Admin admin);

    /**
     * 登录
     * @param admin
     * @return
     */
    public Admin login(Admin admin);

}
