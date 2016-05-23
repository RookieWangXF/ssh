package cn.rookie.service.impl;

import cn.rookie.bean.Admin;
import cn.rookie.dao.IAdminDao;
import cn.rookie.service.IAdminService;

/**
 * Created by Rookie on 2016/5/20.
 * Package_name is cn.rookie.service.impl
 * Description:
 */
public class AdminServiceImpl implements IAdminService{

    private IAdminDao adminDao;

    public void setAdminDao(IAdminDao adminDao) {
        this.adminDao = adminDao;
    }


    @Override
    public void register(Admin admin) {
        this.adminDao.save(admin);
    }

    @Override
    public Admin login(Admin admin) {
        return this.adminDao.findByAdmin(admin);
    }
}
