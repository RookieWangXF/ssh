package cn.rookie.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by Rookie on 2016/5/23.
 * Package_name is cn.rookie.action
 * Description:拦截器,校验用户是否登录
 */
public class UserInterceptor extends AbstractInterceptor{

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        //得到当前执行的方法
        String methodName = invocation.getProxy().getMethod();
        //得到ActionContext对象
        ActionContext ac = invocation.getInvocationContext();
        //获取Session,从session中获取
        Object o = ac.getSession().get("adminInfo");
        //判断
        if (!"login".equals(methodName) && !"list".equals(methodName)) {
            if (o == null) {
                return "login";
            } else {
                return invocation.invoke();
            }
        } else {
            //允许访问登录、列表展示
            return invocation.invoke();
        }
    }
}
