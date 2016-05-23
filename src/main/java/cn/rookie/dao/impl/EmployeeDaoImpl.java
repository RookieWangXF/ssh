package cn.rookie.dao.impl;

import cn.rookie.bean.Dept;
import cn.rookie.bean.Employee;
import cn.rookie.dao.IEmployeeDao;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Rookie on 2016/5/19.
 * Package_name is cn.rookie.dao
 * Description:
 */
public class EmployeeDaoImpl implements IEmployeeDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Employee t) {
        sessionFactory.getCurrentSession().save(t);
    }

    @Override
    public void update(Employee t) {
        sessionFactory.getCurrentSession().update(t);
    }

    @Override
    public void delete(Integer id) {
        sessionFactory.getCurrentSession().createQuery("delete from Employee where id=?")
                .setParameter(0,id)
                .executeUpdate();
    }

    @Override
    public Employee findById(Integer id) {
        return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    @Override
    public List getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Employee").list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> getAll(String employeeName) {
        return (List<Employee>) sessionFactory.getCurrentSession()
                .createQuery("from Employee where empName like ?")
                .setParameter(0,"%" + employeeName + "%")
                .list();
    }
}
