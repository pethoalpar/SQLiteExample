package com.pethoalpar.sqlite.sqliteexample.entities;

import com.pethoalpar.sqlite.sqliteexample.database.Types;
import com.pethoalpar.sqlite.sqliteexample.database.annotation.Column;
import com.pethoalpar.sqlite.sqliteexample.database.annotation.Id;
import com.pethoalpar.sqlite.sqliteexample.database.annotation.Table;

/**
 * Created by pethoalpar on 6/25/2016.
 */
@Table(name = "PERSON")
public class Person {

    @Id
    @Column(columnName = "id", type = Types.INTEGER)
    protected Integer id;

    @Column(columnName = "name", type = Types.TEXT)
    protected String name;

    @Column(columnName = "age", type = Types.INTEGER)
    protected int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
