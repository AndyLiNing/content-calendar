package dev.ningli.content_calendar.JavaFoundations.ClassesLoader;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Objects;

public class Parent {

    private final String name;

    public Parent(String name) throws ClassNotFoundException {
        this.name = name;
        System.out.println("====================================================================================================================");

        // Exception in thread "main" java.lang.ClassNotFoundException: dev.ningli.content_calendar.JavaFoundations.ClassLoader.Child
        // var Child = this.getClass().getClassLoader().getParent().loadClass("dev.ningli.content_calendar.JavaFoundations.ClassLoader.Child");
        var Child = this.getClass().getClassLoader().loadClass("dev.ningli.content_calendar.JavaFoundations.ClassesLoader.Child");

        System.out.println("Classloader of Parent class getClassLoader: " + Parent.class.getClassLoader());
        System.out.println("Classloader of Child class getClassLoader: " + Child.class.getClassLoader());
        System.out.println("Classloader of Child class getClassLoader().getParent: " + Child.class.getClassLoader().getParent());
        System.out.println("Classloader of DriverManager getClassLoader: " + DriverManager.class.getClassLoader());
        System.out.println("Classloader of DriverManager getResource: " + DriverManager.class.getResource("java.sql.DriverManager"));
        System.out.println("Classloader of ArrayList: " + ArrayList.class.getClassLoader());
        System.out.println("====================================================================================================================");

        System.out.println("Parent getResource" + Parent.class.getResource(""));
        System.out.println("Child getResource" + Child.class.getResource(""));

        System.out.println("java.lang.ClassLoader.class.getResource: " + ClassLoader.class.getResource(""));

        //Class
    }

    @Override
    public String toString() {
        return "Parent{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parent parent = (Parent) o;
        return Objects.equals(name, parent.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
