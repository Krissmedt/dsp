package io.lorezen.starter;

import org.apache.flink.api.common.functions.AggregateFunction;

public class WordCount implements AggregateFunction<String, Long, Long> {
    @Override
    public Long createAccumulator() {
        return 0L;
    }

    @Override
    public Long add(String element, Long acc) {
        var wordsInElement = element.split(" ");
        return acc + wordsInElement.length;
    }

    @Override
    public Long getResult(Long acc) {
        return acc;
    }

    @Override
    public Long merge(Long acc1, Long acc2) {
        return acc1 + acc2;
    }
}
