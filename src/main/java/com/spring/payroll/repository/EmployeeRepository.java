package com.spring.payroll.repository;
import com.spring.payroll.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{
    @Query(value = "select * from employee.employee where employee.name=:name",nativeQuery = true)
    List<Employee> findByName(String name);
}
