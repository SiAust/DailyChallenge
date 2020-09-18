package io.github.siaust;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaces {

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Supplier<? extends U> ifTrue,
//            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {


        return t -> condition.test(t) ? ifTrue.get() : ifFalse.apply(t);

    }

    public static void main(String[] args) {
        Predicate<Object> condition = Objects::isNull;

        Supplier<Integer> ifTrue = () -> 0;
//        Function<Object, Integer> ifTrue = obj -> 0;

        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
        System.out.println(safeStringLength.apply(null));

    }
}
