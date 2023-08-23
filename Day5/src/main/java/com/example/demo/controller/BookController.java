package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bs;
	
	@PostMapping("/create")
	public boolean addData(Book b) {
		try {
			bs.postData(b);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	@GetMapping("/read")
	public Optional<Book> readData(@RequestParam(value = "id")int id) {
		return bs.getById(id);
	}
	@GetMapping("/readAll")
	public List<Book> readAll() {
		return bs.getData();
	}
	
	@PutMapping("/update")
	public Book updateData(@RequestParam(value = "id") int id, @RequestBody Book b) {
		return bs.putData(id, b);
	}
	
	@DeleteMapping("/delete")
	public boolean deleteBook(@RequestParam(value = "id") int id) {
		if(bs.deleteData(id)) {
			return true;
		}
		return false;
	}
}
