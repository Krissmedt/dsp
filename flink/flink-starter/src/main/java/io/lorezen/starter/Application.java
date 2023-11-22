package io.lorezen.starter;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.GlobalWindows;
import org.apache.flink.streaming.api.windowing.triggers.CountTrigger;

public class Application {
    public static void main(String[] args) throws Exception {
        var env = StreamExecutionEnvironment.getExecutionEnvironment();

        var wordStream = env.socketTextStream("localhost", 9999);

        var wordCount = wordStream
                .windowAll(GlobalWindows.create())
                .trigger(CountTrigger.of(1))
                .aggregate(new WordCount());

        wordCount.print();
        env.execute();
    }
}