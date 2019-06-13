package com.kayosys.springquiztask.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kayosys.springquiztask.entities.TodoItem;
import com.kayosys.springquiztask.repositories.TodoItemRepository;
/*
implementation for todo service methods
*/
@Service
public class TodoItemServiceImpl implements TodoItemService {

    @Autowired
    TodoItemRepository todoItemRepository;

     /*-- to save new todo --*/
    @Override
    public TodoItem save(TodoItem todoItem) {
	return this.todoItemRepository.save(todoItem);
    }

     /*-- to show list of all todo --*/
    @Override
    public List<TodoItem> findAll() {
	return todoItemRepository.findAll();
    }

     /*-- to delete the todo --*/
    @Override
    public void delete(long todoItemId) {
	todoItemRepository.delete(todoItemId);
    }

    /*-- to update the existing todo --*/
    @Override
    public TodoItem update(long todoItemId, TodoItem todoItem) {
		
	TodoItem todoItemToUpdate = todoItemRepository.findOne(todoItemId);
	todoItemToUpdate.setTitle(todoItem.getTitle());
	todoItemToUpdate.setDescription(todoItem.getDescription());
        todoItemToUpdate.setEventTime(todoItem.getEventTime());		
	return this.save(todoItemToUpdate);		
	}   

}
