package com.example.todoapp;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity(tableName = MyDatabase.TABLE_NAME_TODO)
public class ToDo implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int todo_id;

    public String name;

    public String description;

    public String category;

    @Ignore
    public String priority;

}
