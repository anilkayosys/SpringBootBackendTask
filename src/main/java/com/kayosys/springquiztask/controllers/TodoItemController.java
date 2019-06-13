package com.kayosys.springquiztask.controllers;

import com.kayosys.springquiztask.entities.TodoItem;
import com.kayosys.springquiztask.services.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(value = "/api/v1/todo-item")
public class TodoItemController {

    @Autowired
    TodoItemService todoItemService;

    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    /*-- to Allow user to add new todo --*/
    @RequestMapping(value = "", method = RequestMethod.POST)
    public @ResponseBody
    String createTodoItem(@RequestBody TodoItem todoItem) {
         /*-- validating all fields --*/
         long currentMilliseconds = System.currentTimeMillis();
        if(todoItem.getTitle()!=null && !todoItem.getTitle().equals("")
                && todoItem.getDescription()!=null && !todoItem.getDescription().equals("")
                && todoItem.getEventTime()>currentMilliseconds){
            todoItemService.save(todoItem);
            return "task created successfully";
        }
        else {
           return "Bad Request"; 
        }
    }

    /*-- to get all todo --*/
    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody
    List<TodoItem> findAll() {
        return todoItemService.findAll();
    }

    /*-- to update the existing todo --*/
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    String update(@PathVariable("id") Long todoItemId, @RequestBody TodoItem todoItem) {
        /*-- validating fields --*/
         long currentMilliseconds = System.currentTimeMillis();
        if(todoItem.getTitle()!=null && todoItem.getDescription()!=null && todoItem.getEventTime()>currentMilliseconds){
            todoItemService.update(todoItemId, todoItem);
            return "todos updated successfully";
        } else {
           return "Bad request!";
        }        
    }
    
     /*-- to delete single todo or multiple todo --*/
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public 
    String delete(@RequestParam("id") Long[] todoItemId) {
        if(todoItemId.length>0){
            for(long todo : todoItemId){
            todoItemService.delete(todo);
        } 
            return "record removed successfully!!";
        } else {
        return "Bad Request!!";
        }
    }
   
}