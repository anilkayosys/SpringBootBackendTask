package com.kayosys.springquiztask.entities;

import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/*
Model class for todo
*/
@Entity
public class TodoItem {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String description;

    @CreationTimestamp
    private Timestamp createDateTime;
    
    
    private long eventTime;

   
    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Timestamp createDateTime) {
        this.createDateTime = createDateTime;
    }
    
   public long getEventTime() {
        return eventTime;
    }

    public void setEventTime(long eventTime) {
        this.eventTime = eventTime;
    }

}
