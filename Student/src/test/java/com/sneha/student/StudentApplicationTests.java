package com.sneha.student;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.sneha.employee.entity.Employee;
import com.sneha.employee.repository.EmployeeRepository;
import com.sneha.student.entity.Student;
import com.sneha.student.repository.StudentRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class StudentApplicationTests {

	@Autowired
    private MockMvc mockMvc; 
	
	@Autowired
    private StudentRepository studentRepository;
	
	@BeforeEach
    void setup(){
       studentRepository.deleteAll();
    }

	@Test
    public void givenListOfStudent_whenGetAllStudents_thenReturnstudentsList() throws Exception{
        // given - precondition or setup
        List<Student> listOfstudents = new ArrayList<>();
        listOfstudents.add(new Student(3,23,"F","rani"));
       
       studentRepository.saveAll(listOfstudents);
        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("http://localhost:9092/student"));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(listOfstudents.size())));

    }
}

