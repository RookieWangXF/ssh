package cn.rookie.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Rookie on 2016/5/19.
 * Package_name is cn.rookie.bean
 * Description:系统管理表
 */
@Entity
@Table(name = "t_admin")
public class Admin {
    @Id
    private int id;
    private String adminName;
    private String pwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", adminName='" + adminName + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
