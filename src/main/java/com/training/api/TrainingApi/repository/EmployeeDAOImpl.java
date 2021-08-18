package com.training.api.TrainingApi.repository;

import com.training.api.TrainingApi.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    DataSource dataSource;

  /*  @Override
    public int addEmployee(Employee employee) {
        int rows=0;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement ps=connection.prepareStatement("insert into employee values(?,?,?,?)");
            ps.setInt(1,employee.getEmpId());
            ps.setString(2,employee.getAddress());
            ps.setString(3, employee.getName());
            ps.setLong(4,employee.getSalary());
            rows=ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rows;
    } */
    @Autowired
    JdbcTemplate template;
    @Override
    public int addEmployee(Employee employee) {
        int rows=0;
        rows= template.update("insert into employee values(?,?,?,?)",employee.getEmpId(),employee.getAddress(),employee.getName(),employee.getSalary());
        return rows;
    }


    @Override
    public boolean upadteEmployee(int empId, String address) {
        return false;
    }

    @Override
    public Employee findById(int empId) {
        return null;
    }

    @Override
    public List<Employee> findAllEmployees() {
        List<Employee> employees = template.query("select * from employee", new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet set, int row_no) throws SQLException {
                Employee e =new Employee();
                e.setEmpId(set.getInt(1));
                e.setAddress(set.getString(2));
                e.setName(set.getString(3));
                e.setSalary(set.getLong(4));
                return e;
            }
        });
        return employees;
    }
}
