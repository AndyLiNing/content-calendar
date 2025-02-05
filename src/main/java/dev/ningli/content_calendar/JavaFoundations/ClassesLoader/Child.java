package dev.ningli.content_calendar.JavaFoundations.ClassesLoader;

import java.util.Objects;

public class Child {

    private final String name;

    public Child(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return Objects.equals(name, child.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
