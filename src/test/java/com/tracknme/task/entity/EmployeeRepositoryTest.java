package com.tracknme.task.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository underTest;

    @AfterEach
            void tearDown(){
        underTest.deleteAll();
    }

    String cep = "01536000";
    String name = "teste";
    int age = 18;

    Employee generalEmployee = new Employee(name, cep, age);

    @Test
    void testFindByCep() {

        //given
        Employee test1 = generalEmployee;
        underTest.save(test1);
        //when
        Optional<Employee> exist = underTest.findByCep(cep);
        //then
        assertThat(exist).isPresent();

    }

    @Test
    void testNotFindByCep() {
        //given
        Employee test2 = new Employee(
        );
        //when
        Optional<Employee> exist = underTest.findByCep(test2.getCep());
        //then
        assertThat(exist).isEmpty();

    }
    @Test
    void testFindByName() {

        //given
        Employee test2 = generalEmployee;
        underTest.save(test2);
        //when
        Optional<Employee> exist = underTest.findByName(name);
        //then
        assertThat(exist).isPresent();

    }

    @Test
    void testNotFindByName() {
        //given
        Employee test2 = new Employee(
        );
        //when
        Optional<Employee> exist = underTest.findByName(test2.getName());
        //then
        assertThat(exist).isEmpty();

    }
}