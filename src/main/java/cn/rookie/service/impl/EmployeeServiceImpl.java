package cn.rookie.service.impl;

import cn.rookie.bean.Employee;
import cn.rookie.dao.IEmployeeDao;
import cn.rookie.service.IEmployeeService;

import java.util.List;

/**
 * Created by Rookie on 2016/5/20.
 * Package_name is cn.rookie.service.impl
 * Description:
 */
public class EmployeeServiceImpl implements IEmployeeService{

    private IEmployeeDao employeeDao;

    public void setEmployeeDao(IEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void save(Employee emp) {
        this.employeeDao.save(emp);
    }

    @Override
    public void update(Employee emp) {
        this.employeeDao.update(emp);
    }

    @Override
    public void delete(Integer id) {
        this.employeeDao.delete(id);
    }

    @Override
    public void delete(int[] ids) {
        if (ids != null && ids.length > 0) {
            for (int id : ids) {
                delete(id);
            }
        }
    }

    @Override
    public Employee findById(Integer id) {
        return employeeDao.findById(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Override
    public List<Employee> getAll(String employeeName) {
        return employeeDao.getAll(employeeName);
    }
}
