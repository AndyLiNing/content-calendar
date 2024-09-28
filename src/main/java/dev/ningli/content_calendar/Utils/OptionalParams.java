package dev.ningli.content_calendar.Utils;

import dev.ningli.content_calendar.Content;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class OptionalParams {
    private final static List<Content> a = new ArrayList<>();

    static {
        System.out.println("Result: " + OptionalParams.sum(2, null));
    }

    public static Integer sum( Integer a, Integer b){
        Optional<Integer>  ob = Optional.ofNullable(b);
        var c = ob.orElse(3);
        return a + c;
    }

    private static Optional<Content> findById(int id) {
        Optional.of(id).map(d -> d + 123).ifPresent(System.out::println);
        return a.stream().filter(v -> v.id().equals(1)).findFirst();
    }

}
