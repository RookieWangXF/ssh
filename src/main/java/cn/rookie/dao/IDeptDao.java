package cn.rookie.dao;

import cn.rookie.bean.Dept;

import java.util.List;

/**
 * Created by Rookie on 2016/5/19.
 * Package_name is cn.rookie.dao.impl
 * Description: 部门的Dao操作
 */
public interface IDeptDao {

    /**
     * 查询全部
     * @return
     */
    public List<Dept> getAll();

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    public Dept findById(Integer id);
}
