package com.example.demo.metric;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Log4j2
public class MetricSampler {

  private final AtomicInteger gaugeMeter;
  private final AtomicInteger staticGaugeMeter;

  private final Counter counterMeter;
  private final Counter staticCounterMeter;
  private final Random random = new Random();

  private final TreeMap<Long, Integer> timeToIncrementMap = new TreeMap<>();


  public MetricSampler(MeterRegistry meterRegistry) {

    gaugeMeter = meterRegistry.gauge("gauge", new AtomicInteger(0));
    staticGaugeMeter = meterRegistry.gauge("gauge_static", new AtomicInteger(0));

    counterMeter = meterRegistry.counter("counter");
    staticCounterMeter = meterRegistry.counter("counter_static");

  }

//  @Scheduled(fixedRate = 1000)
  public void oneSecondTicker() {

    int increment = random.nextInt(2000);

    gaugeMeter.set(increment);
    counterMeter.increment(increment);
    Long current = Instant.now().getEpochSecond();

    timeToIncrementMap.put(current, increment);

    SortedMap<Long, Integer> incrementInLastMinuteMap =
            timeToIncrementMap.subMap(current - 60, current);

    SortedMap<Long, Integer> incrementInLast5MinuteMap =
            timeToIncrementMap.subMap(current - 60 * 5, current);

    SortedMap<Long, Integer> incrementInLast10MinuteMap =
            timeToIncrementMap.subMap(current - 60 * 10, current);

    Integer incrementInLastMinute = incrementInLastMinuteMap.values().stream().reduce(0, Integer::sum);
    Integer incrementInLast5Minute = incrementInLast5MinuteMap.values().stream().reduce(0, Integer::sum);
    Integer incrementInLast10Minute = incrementInLast10MinuteMap.values().stream().reduce(0, Integer::sum);

    log.info("Ticker: " + increment);
    log.info(" per minute: " + incrementInLastMinute);
    log.info(" per 5 minute: " + incrementInLast5Minute);
    log.info(" per 10 minute: " + incrementInLast10Minute);
  }

//  @Scheduled(fixedRate = 1000)
  public void oneSecondStaticTicker() {

    int increment = 2000;
    staticGaugeMeter.set(increment);
    staticCounterMeter.increment(increment);



    log.info("Static Ticker: " + increment);
  }
}
