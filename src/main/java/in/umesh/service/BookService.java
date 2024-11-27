package in.umesh.service;

import org.springframework.stereotype.Service;

import in.umesh.entity.Book;

@Service
public interface BookService {
	
	public boolean saveBook(Book book);

	String h="kumar";

	public void m1(String name);
	public void m2(String email);
	public void m3(String pwd);

}
