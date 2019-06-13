package com.kayosys.springquiztask.services;

import java.util.List;

import com.kayosys.springquiztask.entities.TodoItem;
/*
interface for todo services
*/
public interface TodoItemService {

    public TodoItem save(TodoItem todoItem);

    public List<TodoItem> findAll();

    public void delete(long todoItemId);
    
    public TodoItem update(long todoItemId, TodoItem todoItem);
       
}
