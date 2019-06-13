package com.kayosys.springquiztask.controllers;

import com.kayosys.springquiztask.entities.ResponseModel;
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
import org.springframework.web.bind.annotation.CrossOrigin;
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
    @CrossOrigin
    public @ResponseBody
    ResponseModel createTodoItem(@RequestBody TodoItem todoItem) {
         /*-- validating all fields --*/
         long currentMilliseconds = System.currentTimeMillis();
        if(todoItem.getTitle()!=null && !todoItem.getTitle().equals("")
                && todoItem.getDescription()!=null && !todoItem.getDescription().equals("")
                && todoItem.getEventTime()>currentMilliseconds){
            todoItemService.save(todoItem);
            return new ResponseModel("task created successfully",200,true);
        }
        else {
           return new ResponseModel("Invalid data!!",412,false);
        }
    }

    /*-- to get all todo --*/
    @RequestMapping(value = "", method = RequestMethod.GET)
    @CrossOrigin
    public @ResponseBody
    List<TodoItem> findAll() {
        return todoItemService.findAll();
    }

    /*-- to update the existing todo --*/
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @CrossOrigin
    public @ResponseBody
    ResponseModel update(@PathVariable("id") Long todoItemId, @RequestBody TodoItem todoItem) {
        /*-- validating fields --*/
         long currentMilliseconds = System.currentTimeMillis();
        if(todoItem.getTitle()!=null && todoItem.getDescription()!=null && todoItem.getEventTime()>currentMilliseconds){
            todoItemService.update(todoItemId, todoItem);
            return new ResponseModel("todos updated successfully",200,true);
        } else {
           return new ResponseModel("Invalid data!!",412,false);
        }        
    }
    
     /*-- to delete single todo or multiple todo --*/
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @CrossOrigin
    public 
    ResponseModel delete(@RequestParam("id") Long[] todoItemId) {
        if(todoItemId.length>0){
            for(long todo : todoItemId){
            todoItemService.delete(todo);
        }
            return new ResponseModel("record removed successfully!!",200,true);
        } else {
        return new ResponseModel("Invalid data!!",412,false);
        }
    }
   
}
