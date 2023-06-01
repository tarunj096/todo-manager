package com.tarun.todo;

import com.tarun.todo.doa.TodoDao;
import com.tarun.todo.models.Status;
import com.tarun.todo.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

@SpringBootApplication
public class TodoManagerApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(TodoManagerApplication.class);
	@Autowired
	private TodoDao todoDao;

	public static void main(String[] args) {
		SpringApplication.run(TodoManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Application Started: ");
//		JdbcTemplate template = todoDao.getTemplate();
//		logger.info("Template object: {}",template);
//		logger.info("Template object: {}",template.getDataSource().getConnection());
//		Todo todo = new Todo();
//		todo.setId(123);
//		todo.setTitle("This is Testing Spring JDBC");
//		todo.setContent("Wow it's working");
//		todo.setStatus("PENDING");
//		todo.setAddedDate(new Date());
//		todo.setTodoDate(new Date());

//		todoDao.saveTodo(todo);
		Todo todo = todoDao.getTodo(123);
		logger.info(" Todo : {}", todo);

	}
}
