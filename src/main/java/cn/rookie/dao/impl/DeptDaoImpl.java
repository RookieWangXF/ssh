package cn.rookie.dao.impl;

import cn.rookie.bean.Dept;
import cn.rookie.dao.IDeptDao;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Rookie on 2016/5/19.
 * Package_name is cn.rookie.dao
 * Description:
 */
public class DeptDaoImpl implements IDeptDao{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Dept> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Dept").list();
    }

    @Override
    public Dept findById(Integer id) {
        return (Dept) sessionFactory.getCurrentSession().get(Dept.class, id);
    }
}
