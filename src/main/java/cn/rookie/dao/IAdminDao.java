package cn.rookie.dao;

import cn.rookie.bean.Admin;

/**
 * Created by Rookie on 2016/5/19.
 * Package_name is cn.rookie.dao.impl
 * Description:
 */
public interface IAdminDao {

    /**
     * 保存
     * @param admin 管理员对象
     */
    public void save(Admin admin);

    /**
     * 根据管理员信息查询
     * @param admin 管理员对象
     * @return 返回查询后的结果
     */
    public Admin findByAdmin(Admin admin);

}
