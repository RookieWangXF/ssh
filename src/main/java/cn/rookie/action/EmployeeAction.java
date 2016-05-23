package cn.rookie.action;

import cn.rookie.bean.Dept;
import cn.rookie.bean.Employee;
import cn.rookie.service.IDeptService;
import cn.rookie.service.IEmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;

import java.util.List;
import java.util.Map;

/**
 * Created by Rookie on 2016/5/20.
 * Package_name is cn.rookie.action
 * Description: 员工控制器开发
 */


public class EmployeeAction extends ActionSupport implements RequestAware, ModelDriven<Employee> {

    private Logger logger = Logger.getLogger(EmployeeAction.class);
    private IEmployeeService employeeService;
    private IDeptService deptService;

    private Employee employee = new Employee();
    //封装请求的部门id，（下拉列表的实际的值）
    private int deptId;

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getDeptId() {
        return deptId;
    }

    public Employee getEmployee() {
        return employee;
    }

    @Override
    public Employee getModel() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setEmployeeService(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void setDeptService(IDeptService deptService) {
        this.deptService = deptService;
    }

    /**
     * 1. 员工列表展示
     * 2. 添加员工
     * 3. 修改员工
     * 4. 删除
     */

    /**
     * 查询所有员工
     *
     * @return
     */
    public String list() {
        List<Employee> listEmp = employeeService.getAll();
        for (Employee employee : listEmp) {
            logger.info("[employee]:" + employee);
        }
        request.put("listEmp", listEmp);
        return "list";
    }

    /**
     * 2.1 进入添加页面
     *
     * @return
     */
    public String viewAdd() {
        //查询所有的部门信息，保存到request中
        List<Dept> listDept = deptService.getAll();
        request.put("listDept", listDept);
        return "add";
    }

    /**
     * 2.2 添加员工
     *
     * @return
     */
    public String save() {
        //现根据部门主键查询
        Dept dept = deptService.findById(deptId);
        //设值到员工对象中
        employee.setDept(dept);

        employeeService.save(employee);
        return "listAction"; //重定向过去
    }

    /**
     * 3.1 进入修改页面
     *
     * @return
     */
    public String viewUpdate() {
        //获取到id
        int id = employee.getId();
        //1. 根据员工的主键查询
        Employee emp = employeeService.findById(id);
        //2. 查询所有的部门
        List<Dept> listDept = deptService.getAll();

        //数据回显
        ValueStack vs = ActionContext.getContext().getValueStack();
        vs.pop();
        vs.push(emp);

        //保存
        request.put("listDept", listDept);
        return "edit";
    }

    /**
     * 3.2 修改员工信息，确认修改
     *
     * @return
     */
    public String update() {
        logger.info("[update]");
        //1. 先得到部门对象；在设置到员工属性中
        Dept dept = deptService.findById(deptId);
        employee.setDept(dept);
        //2. 更新员工
        employeeService.update(employee);
        return "listAction";
    }

    /**
     * 修改员工信息--删除
     * @return
     */
    public String delete() {
        //获取要删除员工的主键
        int empId = employee.getId();
        //调用删除
        employeeService.delete(empId);
        return "listAction";
    }

    /**
     * 接收框架运行时候传入的代表request对象的map
     *
     * @param request
     */
    private Map<String, Object> request;

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }


}
