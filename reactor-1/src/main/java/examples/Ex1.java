package examples;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class Ex1 {


    private static void someMethod() {
        Mono<String> single = Mono.just("me");

        single.subscribe(System.out::println);

        Flux<Integer> aRange = Flux.range(0, 10);
        aRange.subscribe(System.out::println);

    }

    public static void main(String[] args) {


        var list1 = List.of(1, 2, 3);
        var list2 = List.of(4.12, 5.00, 6.45);
        var list3 = List.of("some", "values", "here");
        var list4 = List.of('a', 'b', 'c');


        var finalList = List.of(list1, list2, list3, list4);
        var allLists = Flux.fromIterable(finalList);

        allLists.subscribe(System.out::println);


    }

}
