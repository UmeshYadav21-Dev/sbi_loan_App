package in.umesh.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.umesh.entity.Book;
import in.umesh.rest.BookRestController;
import in.umesh.service.BookService;

@WebMvcTest(BookRestController.class)
public class BookRestControllerTest {
	
	@MockBean
	private BookService bookService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testAddBook() throws Exception {
		when(bookService.saveBook(ArgumentMatchers.any())).thenReturn(true);
		
		Book book = new Book(101, "String", 450.00);
		
		ObjectMapper mapper =new  ObjectMapper();
		String bookJson = mapper.writeValueAsString(book);
		MockHttpServletRequestBuilder reqBuilders = MockMvcRequestBuilders.post("/addbook").contentType(MediaType.APPLICATION_JSON)
		.content(bookJson);
		
		ResultActions perform = mockMvc.perform(reqBuilders);
		MvcResult andResult = perform.andReturn();
		MockHttpServletResponse response = andResult.getResponse();
		int status = response.getStatus();
		assertEquals(201, status);
		
		
		
	}

}
