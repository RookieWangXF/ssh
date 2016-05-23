-- 数据库初始化脚本  mysql版本为5.6以上的

-- 创建数据库
CREATE DATABASE ssh;

-- 使用数据库
use ssh;

-- 创建管理员表
CREATE TABLE t_admin(
  id INT NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  adminName VARCHAR(120) NOT NULL COMMENT '名称',
  pwd VARCHAR(20) NOT NULL COMMENT '密码',
  PRIMARY KEY (id)
 )ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- 创建部门表
CREATE TABLE t_dept(
  deptId INT NOT NULL AUTO_INCREMENT COMMENT '部门id',
  deptName VARCHAR(20) NOT NULL COMMENT '部门名称',
  PRIMARY KEY (deptId)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='管部门表';

-- 创建职工表
CREATE TABLE t_employee(
  empId INT NOT NULL AUTO_INCREMENT COMMENT '员工id',
  empName VARCHAR(20) NOT NULL COMMENT '员工名称',
  salary DOUBLE NOT NULL COMMENT '薪水',
  dept_id INT NOT NULL COMMENT '员工所在部门',
  PRIMARY KEY (empId),
  FOREIGN KEY (dept_id) REFERENCES t_dept(deptId)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='职工表';


-- 初始化数据
INSERT INTO t_admin(id,adminName ,pwd)
VALUES (1,100,'2015-11-01 00:00:00'),
  (2,100,'2015-11-01 00:00:00'),
  (3,100,'2015-11-01 00:00:00')




