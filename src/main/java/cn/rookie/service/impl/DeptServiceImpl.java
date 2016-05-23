package cn.rookie.service.impl;

import cn.rookie.bean.Dept;
import cn.rookie.dao.IDeptDao;
import cn.rookie.service.IDeptService;

import java.util.List;

/**
 * Created by Rookie on 2016/5/20.
 * Package_name is cn.rookie.service.impl
 * Description:
 */
public class DeptServiceImpl implements IDeptService{

    private IDeptDao deptDao;

    public void setDeptDao(IDeptDao deptDao) {
        this.deptDao = deptDao;
    }

    @Override
    public List<Dept> getAll() {
        return deptDao.getAll();
    }

    @Override
    public Dept findById(Integer id) {
        return deptDao.findById(id);
    }
}
