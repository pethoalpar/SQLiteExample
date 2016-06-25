package com.pethoalpar.sqlite.sqliteexample.database.annotation;

import com.pethoalpar.sqlite.sqliteexample.database.Types;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by pethoalpar on 6/25/2016.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column {
    String columnName();
    Types type();
}
