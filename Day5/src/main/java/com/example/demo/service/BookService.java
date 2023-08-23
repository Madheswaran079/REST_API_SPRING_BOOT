package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepo;

@Service
public class BookService {

	@Autowired
	BookRepo br;
	
	public Book postData(Book b) {
		return br.save(b);
	}
	
	public Optional<Book> getById(int id) {
		return br.findById(id);
	}
	public List<Book> getData() {
		return br.findAll();
	}
	
	public Book putData(int id, Book b) {
		Book exist = br.findById(id).orElse(null);
		if(exist != null)
		{
			if(b.getId() != 0)
			{
				exist.setId(b.getId());				
			}
			if(b.getBookName() != null)
			{
				exist.setBookName(b.getBookName());
			}
			if(b.getPrice() != 0)
			{
				exist.setPrice(b.getPrice());				
			}
			if(b.getQuantity() != 0)
			{
				exist.setQuantity(b.getQuantity());				
			}
			if(b.getAuthorName() != null)
			{
				exist.setAuthorName(b.getAuthorName());				
			}
			return br.save(exist);
		}
		else {
			return null;
		}
	}
	
	public boolean deleteData(int id) {
		br.deleteById(id);
		return true;
	}
}
