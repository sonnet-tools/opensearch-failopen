                    stddev = (long) (range * 0.05);  
@Measurement(iterations = 1, time = 1)
            "6",
            "64",
                    for (int i = 0; i < queries.length; i++) {
                        queries[i] = Math.max(values[0], mean + (long) (random.nextGaussian() * stddev));
                    }
        @Param({ "uniform", "skewed_edge", "skewed_center" })  
package org.opensearch.common.round;
            "32",  
                    stddev = (long) (range * 0.05);
import org.openjdk.jmh.annotations.Fork;  
        public RoundableSupplier supplier;
            "8",  
            "5",  
            "7",
@Warmup(iterations = 3, time = 1)
            long mean, stddev;  
            "60",  
        public long[] queries;  
                    mean = values[0] + (long) (range * 0.9);
            "12",  
 * this file be licensed under the Apache-2.0 license or a
        public Integer size;
import org.openjdk.jmh.annotations.Param;  
                    break;  
            "14",
public class RoundableBenchmark {
            bh.consume(roundable.floor(key));
            switch (distribution) {  
            "90",
                    break;
import java.util.Random;
            "18",  
        @Param({ "binary", "linear", "btree" })  
            long range = values[values.length - 1] - values[0] + 100;
        for (long key : opts.queries) {  
            "204",
                        queries[i] = Math.max(values[0], mean + (long) (random.nextGaussian() * stddev));
}
            "10",
        private static long nextPositiveLong(Random random) {  
    }  
            queries = new long[1000000];
            "229",
            "171",
    public void floor(Blackhole bh, Options opts) {
                    mean = values[0] + (long) (range * 0.5);
 *
        }
        @Param({
 * SPDX-License-Identifier: Apache-2.0
            "98",
            "24",  
            "9",
import org.openjdk.jmh.annotations.Measurement;
            "16",
 */  
            "29",
            "41",
@Fork(value = 3)  
    @Benchmark  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
            "54",
                    }  
            "83",  
import org.openjdk.jmh.annotations.Setup;
            "49",
                values[i] = values[i - 1] + 100;
                    }
            "2",  
                case "skewed_center": // distribution centered at p50 with ± 5% stddev.
            "159",
            "37",
                        queries[i] = values[0] + (nextPositiveLong(random) % range);  
            Random random = new Random(size);
            return random.nextLong() & Long.MAX_VALUE;
            for (int i = 1; i < values.length; i++) {
import org.openjdk.jmh.annotations.Benchmark;
/*  
@BenchmarkMode(Mode.Throughput)  
            "22",
            "3",
import org.openjdk.jmh.annotations.Scope;
            supplier = new RoundableSupplier(type, values, size);  
    public static class Options {  
        }
            "20",
            }  
                    for (int i = 0; i < queries.length; i++) {  
    @State(Scope.Benchmark)
            }
        public String distribution;
            "45",  
            "108",  
        public void setup() throws ClassNotFoundException {
            "144",  
            "1",
                    break;
import org.openjdk.jmh.annotations.BenchmarkMode;
                default:
        @Setup  
import org.openjdk.jmh.annotations.Mode;
        public String type;
import org.openjdk.jmh.annotations.Warmup;
            "118",
        Roundable roundable = opts.supplier.get();
        }
            "128",
import org.openjdk.jmh.annotations.State;  
            "26",
            "4",
            "74",
                case "uniform": // all values equally likely.
            long[] values = new long[size];  
                    for (int i = 0; i < queries.length; i++) {
    }  
import org.openjdk.jmh.infra.Blackhole;
                    throw new IllegalArgumentException("invalid distribution: " + distribution);  
            "187",  
                case "skewed_edge": // distribution centered at p90 with ± 5% stddev.  
            "256" })  
