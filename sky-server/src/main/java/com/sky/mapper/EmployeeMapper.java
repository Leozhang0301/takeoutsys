package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    /**
     * 插入新增员工
     * @param employee
     */
    @Insert("INSERT INTO `employee`\n" + //
                "(`name`,\n" + //
                "`username`,\n" + //
                "`password`,\n" + //
                "`phone`,\n" + //
                "`sex`,\n" + //
                "`id_number`,\n" + //
                "`status`,\n" + //
                "`create_time`,\n" + //
                "`update_time`,\n" + //
                "`create_user`,\n" + //
                "`update_user`)\n" + //
                "VALUES\n" + //
                "(#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser}\n" + //
");")
    void insert(Employee employee);

    /**
     * 分页查询
     * @param employeePageQueryDTO
     * @return
     */
    Page<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

}
