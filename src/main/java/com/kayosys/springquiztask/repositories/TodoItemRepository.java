package com.kayosys.springquiztask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kayosys.springquiztask.entities.TodoItem;
/*
TodoItem Repository class
*/
@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

}
