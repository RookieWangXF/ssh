package cn.rookie.action;

import cn.rookie.bean.Admin;
import cn.rookie.service.IAdminService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by Rookie on 2016/5/23.
 * Package_name is cn.rookie.action
 * Description:管理员登录注册模块
 */
public class AdminAction extends ActionSupport implements ModelDriven<Admin> {

    //封装请求数据
    private Admin admin = new Admin();

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }

    @Override
    public Admin getModel() {
        return admin;
    }

    private IAdminService adminService;

    public void setAdminService(IAdminService adminService) {
        this.adminService = adminService;
    }

    /**
     * 登录
     */
    public String login() {
        Admin adminInfo = adminService.login(admin);
        if (adminInfo == null) {
            //登录失败
            return "loginFailed";
        } else {
            //成功保存数据到session
            ActionContext.getContext().getSession().put("adminInfo", adminInfo);
            return "index";
        }
    }
}
