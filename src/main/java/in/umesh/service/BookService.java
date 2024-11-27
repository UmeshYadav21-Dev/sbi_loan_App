package in.umesh.service;

import org.springframework.stereotype.Service;

import in.umesh.entity.Book;

@Service
public interface BookService {
	
	public boolean saveBook(Book book);
	public void m1(String name);

}
