package com.tracknme.task.Repository;


import com.tracknme.task.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {

    Optional<Employee> findByCep(String cep);

    Optional<Employee> findByName(String name);

}
