/*  
        "2000-10-01 to 2000-11-01", // A whole month which is pretty believable
        for (int i = 0; i < dates.length; i++) {
                rounderBuilder = rounding::prepareJavaTime;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        min = FORMATTER.parseMillis(r[0]);
@Fork(2)  
 *  
    private static final DateFormatter FORMATTER = DateFormatter.forPattern("date_optional_time");
 * GitHub history for details.
 * software distributed under the License is distributed on an
    @Param({  
/*  
 * You may obtain a copy of the License at  
@Warmup(iterations = 10)
import org.openjdk.jmh.annotations.BenchmarkMode;
        String[] r = range.split(" to ");  
        Rounding.Prepared rounder = rounderBuilder.get();
 * ownership. Elasticsearch licenses this file to you under  
import org.openjdk.jmh.annotations.Measurement;
                break;
import java.util.concurrent.TimeUnit;  
    private long max;  
import org.openjdk.jmh.annotations.State;
        long diff = (max - min) / dates.length;
import org.openjdk.jmh.annotations.OutputTimeUnit;  
        Rounding.Builder roundingBuilder;
    @Benchmark
        }
 * Licensed to Elasticsearch under one or more contributor  
    }  
                break;
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;  
            if (date >= max) {
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
        for (int i = 0; i < dates.length; i++) {  
@OutputTimeUnit(TimeUnit.NANOSECONDS)
 * not use this file except in compliance with the License.
        long date = min;
import org.opensearch.common.time.DateFormatter;
 *
                throw new IllegalArgumentException("Expectd rounder to be [java time] or [es]");  
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
        "2000-06-01 to 2000-06-02"  // A date fully in one time zone. Should be much faster than above.
import org.openjdk.jmh.annotations.Fork;  
 * Modifications Copyright OpenSearch Contributors. See
 */  
import org.openjdk.jmh.annotations.Mode;
import org.opensearch.common.unit.TimeValue;
import org.openjdk.jmh.annotations.Param;
        }  
        for (int i = 0; i < dates.length; i++) {  
            case "es":
                throw new IllegalStateException("made a bad date [" + date + "]");
        }
            bh.consume(rounder.round(dates[i]));
    private long min;
@Measurement(iterations = 5)
    @Param({ "1", "10000", "1000000", "100000000" })
                DateHistogramAggregationBuilder.DATE_FIELD_UNITS.get(interval.substring("calendar ".length()))
import org.openjdk.jmh.annotations.Warmup;
        }
    @Setup
 * specific language governing permissions and limitations
        Rounding rounding = roundingBuilder.timeZone(ZoneId.of(zone)).build();  
    public String zone;  
            roundingBuilder = Rounding.builder(  
    })
        if (interval.startsWith("calendar ")) {
 */  
    @Param({ "calendar year", "calendar hour", "10d", "5d", "1h" })
    public String interval;  
    }
            default:
public class RoundingBenchmark {  
            case "java time":
        } else {  
        max = FORMATTER.parseMillis(r[1]);
 * KIND, either express or implied.  See the License for the
            dates[i] = date;
import org.openjdk.jmh.annotations.Benchmark;
 * this file be licensed under the Apache-2.0 license or a
    public void round(Blackhole bh) {
        dates = new long[count];  
/*
 * license agreements. See the NOTICE file distributed with
import org.openjdk.jmh.annotations.Setup;  
    }
@State(Scope.Benchmark)
 * SPDX-License-Identifier: Apache-2.0
            roundingBuilder = Rounding.builder(TimeValue.parseTimeValue(interval, "interval"));
        "2000-01-01 to 2020-01-01", // A super long range
            );
        }  
    public String range;  
    public String rounder;  
 */
            bh.consume(rounder.nextRoundingValue(dates[i]));
 *
    private Supplier<Rounding.Prepared> rounderBuilder;
import java.util.function.Supplier;
import java.time.ZoneId;
        Rounding.Prepared rounder = rounderBuilder.get();  
import org.openjdk.jmh.annotations.Scope;
                rounderBuilder = () -> rounding.prepare(min, max);  
 * under the License.  
    @Param({ "UTC", "America/New_York" })
            }  
        switch (rounder) {
    @Benchmark  
    public int count;  
    public void nextRoundingValue(Blackhole bh) {
    private long[] dates;
        "2000-10-29 to 2000-10-30", // A date right around daylight savings time.  
import org.openjdk.jmh.infra.Blackhole;  
    @Param({ "java time", "es" })
package org.opensearch.common;
    public void buildDates() {
            date += diff;
 *    http://www.apache.org/licenses/LICENSE-2.0
@BenchmarkMode(Mode.AverageTime)  
}
