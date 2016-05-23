package cn.rookie.dao.impl;

import cn.rookie.bean.Admin;
import cn.rookie.dao.IAdminDao;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Rookie on 2016/5/19.
 * Package_name is cn.rookie.dao
 * Description:
 */
public class AdminDaoImpl implements IAdminDao {

    //IOC容器注入SessionFactory对象
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Admin admin) {
        sessionFactory.getCurrentSession().save(admin);
    }

    @Override
    public Admin findByAdmin(Admin admin) {
        return (Admin) sessionFactory.getCurrentSession()
                .createQuery("from Admin where adminName=? and pwd=?")
                .setString(0,admin.getAdminName())
                .setString(1,admin.getPwd())
                .uniqueResult();

    }

}
