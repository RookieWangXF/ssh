package cn.rookie.dao;

import cn.rookie.bean.Employee;

import java.util.List;

/**
 * Created by Rookie on 2016/5/19.
 * Package_name is cn.rookie.dao.impl
 * Description: 员工模块dao设计
 */
public interface IEmployeeDao {

    /**
     * 保存员工信息
     * @param emp
     */
    public void save(Employee emp);

    /**
     * 更新员工信息
     * @param emp
     */
    public void update(Employee emp);

    /**
     * 根据主键删除
     * @param id
     */
    public void delete(Integer id);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    public Employee findById(Integer id);

    /**
     * 查询全部
     * @return
     */
    public List<Employee> getAll();

    /**
     * 根据员工名称条件查询
     * @param employeeName
     * @return
     */
    public List<Employee> getAll(String employeeName);
}
