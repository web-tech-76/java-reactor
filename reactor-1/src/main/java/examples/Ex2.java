package examples;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.ArrayList;

public class Ex2 {


    public static void main(String[] args) {
        var values = Flux.just(1, 2, 3, 4);
        var elements = new ArrayList<>();

        values.subscribe(new Subscriber<Integer>() {
            private Subscription subscription;
            private int nextElements;

            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                subscription.request(2);
            }

            @Override
            public void onNext(Integer value) {
                elements.add(value);
                nextElements++;
                if (nextElements % 2 == 0)
                    subscription.request(2);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {
                subscription.cancel();
                elements.stream()
                        .forEach(System.out::println);
            }
        });

    }
}
