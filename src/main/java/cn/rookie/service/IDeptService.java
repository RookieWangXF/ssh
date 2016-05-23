package cn.rookie.service;

import cn.rookie.bean.Admin;
import cn.rookie.bean.Dept;

import java.util.List;

/**
 * Created by Rookie on 2016/5/18.
 * Package_name is cn.rookie.service
 * Description:
 */
public interface IDeptService {

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
