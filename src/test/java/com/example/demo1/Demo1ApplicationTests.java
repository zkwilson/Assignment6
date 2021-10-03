package com.example.demo1;



import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.example.demo1.controller.StudentController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo1.model.Student;

import java.math.BigDecimal;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
@DisplayName("Test Controller Test")
public class Demo1ApplicationTests {
	private MockMvc mockMvc;
	@Mock
	private ObjectMapper mapper;
	private HttpHeaders httpHeaders;

	@InjectMocks
	private StudentController subject;

	@BeforeEach
	void setup(){
		mockMvc = MockMvcBuilders.standaloneSetup(subject).build();

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		ReflectionTestUtils.setField(this, "httpHeaders", httpHeaders);
		ReflectionTestUtils.setField(this, "mapper", new ObjectMapper());
	}

	@Test
	@DisplayName("Testing HTTP Get")
	void testGet() throws Exception {

		// When
		MockHttpServletResponse response =
				mockMvc
						.perform(get("/students"))
						.andReturn()
						.getResponse();

		// Then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo("Hello world!");
	}

	@Test
	@DisplayName("Testing HTTP Get with ID")
	void testGetWithID() throws Exception {

		// When
		MockHttpServletResponse response =
				mockMvc
						.perform(get("/api/v1/test/123"))
						.andReturn()
						.getResponse();

		// Then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo("Hello world 123!");
	}

	@Test
	@DisplayName("Testing HTTP POST with Student Body")
	void testCreateStudent() throws Exception {
		//Given
		Student student = new Student();
		student.setFirstName("TestFirstName");
		student.setLastName("TestLastName");

		// When
		MockHttpServletResponse response =
				mockMvc
						.perform(post("/api/v1/test").headers(httpHeaders).content(mapper.writeValueAsString(student)))
						.andReturn()
						.getResponse();

		// Then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

		Student responseObject = mapper.readValue(response.getContentAsString(), Student.class);
		assertThat(responseObject.getFirstName()).isEqualTo(student.getFirstName());
		assertThat(responseObject.getLastName()).isEqualTo(student.getLastName());
	}

}
