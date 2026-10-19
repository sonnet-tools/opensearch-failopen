                public boolean hasNext() {
            "1163",  
                @Override  
            "2991",  
                }  
            "24224",
            "41",  
    public void add(Blackhole bh, HashTableOptions tableOpts, WorkloadOptions workloadOpts) {  
            "10005",
                    break;  
            "12070",
                private int count = 0;
            for (int i = 0; i < data.length; i++) {
package org.opensearch.common.util;
            "6891",
            "20108",
            switch (type) {  
            "15925",
            return new HashTable() {  
            "765",
                    break;  
            "2238",
            "6217",
            }  
            "8929",
import org.openjdk.jmh.annotations.Benchmark;
        @Override
        @Param({ "correlated", "uncorrelated", "distinct" })
            "101",  
                private int index = 0;
                }
                    return table.add(key);  
            "20",
        public void setup() {
 * SPDX-License-Identifier: Apache-2.0
                    initialCapacity,
            "2692",
            "14227",
            "49968",  
            "302",
            "114",
import org.openjdk.jmh.annotations.BenchmarkMode;  
                public long next() {  
            };
            "915",
                public void reset() {
            final long[] data = new long[size];
            "4038",  
            "32353",
            "32",
                }  
            "49745",
                private final LongHash table = new LongHash(initialCapacity, loadFactor, BigArrays.NON_RECYCLING_INSTANCE);  
            "2",
                }
            "9153",  
        }  
                @Override
            "216",  
                    supplier = this::newReorganizingLongHash;
                }
            "5624",  
            "2639",  
                    index = 0;  
    private interface HashTable extends Releasable {  
            "612",
            "17",
                private int count = 0;  
        default void close() {  
        /**
     */
                }
            "3710",
        }  
            }  
            "111",
        }
            "4855",
    }  
            "21",
            "1",  
        private HashTable newLongHash() {
            assert NUM_HITS >= size : "ensure hits >= size so that each key is used at least once";
        private WorkloadIterator newUncorrelatedWorkload() {
            "7569",  
    }
                bh.consume(table.add(iter.next()));  
                private int index = 0;
            "176",  
            "17295",  
    /**
            "10",  
                case "distinct":
            "2319",  
 * The OpenSearch Contributors require contributions made to  
            }
    public static class WorkloadOptions {  
            "50",
        /**  
            "402",
        public static final int NUM_HITS = 20_000_000;
                @Override
            "1817",
            "3517",  
                    count = 0;
            "128",
                }
        }
        private WorkloadIterator iterator;
        }
        private Supplier<HashTable> supplier;
                @Override  
            "3681",
        public void setup() {
            "13",
            "98",
import java.util.function.Supplier;
        }  
            "341",
                @Override
            "161",
                    return count < size;
            "308",  
            "23",  
                data[i] = 1420070400000L + 3600000L * i;  
            "505",  
            "5204",
            "817",
            "3201",
            "13694",  
                case "LongHash":
            "787",  
            "35",
                public void close() {
                    index = (index + 1) % data.length;
            "2281",
            }
        /**
 * this file be licensed under the Apache-2.0 license or a
@Measurement(iterations = 3, time = 2)  
        private WorkloadIterator newCorrelatedWorkload() {
                    supplier = this::newLongHash;
            "4",  
                    return count < NUM_HITS;
                        remaining = NUM_HITS / data.length;
            "33104",  
            "374",  
                    }  
            "45396",  
         * Simulates workload with high cardinality, i.e., each hit mapping to a different key.  
                public void reset() {
         * Repeat the experiment with growing number of keys.
            while (iter.hasNext()) {
import java.util.concurrent.TimeUnit;
            "4509",  
            "47916",
                }
 *
    @Benchmark
        private HashTable newReorganizingLongHash() {
import org.openjdk.jmh.annotations.State;
         */
            "10931",  
            "642",  
@Warmup(iterations = 1, time = 4)
            "257",
            "17376",
import org.openjdk.jmh.annotations.Fork;
            };
            "18522",
            "55",
                public long add(long key) {  
            "2662",
            "327",
     * Creates a hash table with varying parameters.  
            "8",
            "38480",
     */
                public boolean hasNext() {
                @Override
            "124",  
                }
            "3215",
            "443",
            "7",  
        long next();
         * These values are generated with an exponential growth pattern such that:
                @Override
                );
            "190",
        @Param({
}
                @Override
import org.openjdk.jmh.annotations.Param;
        @Param({ "LongHash", "ReorganizingLongHash" })
                    break;  
        try (HashTable table = tableOpts.get(); WorkloadIterator iter = workloadOpts.iter()) {
        public long initialCapacity;  
            "91",
                    count = 0;
            "54",
            };
import java.util.Random;  
                default:
                    table.close();
                case "correlated":
        public String dataset;  
            return new WorkloadIterator() {
                    remaining = NUM_HITS / data.length;  
            "18",
            "4060",
            "2583",
    private interface WorkloadIterator extends Releasable {
            "53606" })
            "80",
                }
            "27",
            "148",  
                    loadFactor,  
            "38958",  
            "162",
                @Override
        boolean hasNext();
                }  
        public String type;  
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 3)
            "412",
            return new HashTable() {
                }  
        @Param({ "1" })
            final Random random = new Random(0); // fixed seed for reproducible results
            "53",  
                private final ReorganizingLongHash table = new ReorganizingLongHash(
                    throw new IllegalArgumentException("invalid dataset: " + dataset);
            "9",
                }
            "1805",  
            return iterator;
            "5",
            "2527",
    }  
            };
                case "uncorrelated":
                @Override  
            "1083",
@BenchmarkMode(Mode.AverageTime)
            "63",
        public float loadFactor;  
/*  
            switch (dataset) {  
            "717",
                    count++;
        }
            "488",
            "64",
         */
public class LongHashBenchmark {  
                    return count++;
        long add(long key);
            };
import org.openjdk.jmh.annotations.Scope;  
            "30",  
                    break;  
                default:
import org.openjdk.jmh.annotations.Setup;
                    return data[index];  
            "57",  
                private int count = 0;
            "19200",  
        public HashTable get() {  
import org.opensearch.common.lease.Releasable;
    @State(Scope.Benchmark)
            "45",
    /**
            "15",  
            "12370",
            "36523",
                    iterator = newUncorrelatedWorkload();
            "69",  
    }  
                public void close() {
            "558",
            "204",
            "21496",
        @Setup
        }
            "4199",
         * Simulates uncorrelated data (such as travel distance / fare amount).  
        public WorkloadIterator iter() {  
            "1237",
                    iterator = newCorrelatedWorkload();
            for (int i = 0; i < data.length; i++) {
        private WorkloadIterator newDistinctWorkload() {
                public long next() {  
            "962",  
                public long add(long key) {
        }  
                        index = (index + 1) % data.length;
            reset();
            "19",  
                    return data[index];
            "40020",
            "621",  
            "6",
            "269",  
            "44745",
                    throw new IllegalArgumentException("invalid hash table type: " + type);
import org.openjdk.jmh.annotations.Warmup;  
         */  
            "29199",  
                    return table.add(key);
                    iterator = newDistinctWorkload();
            "74",
                    return count < NUM_HITS;
            "23427",  
                public boolean hasNext() {  
            "2024",  
            final long[] data = new long[size];  
                @Override
                public void reset() {  
    public static class HashTableOptions {  
            "11",
         * Simulates monotonically increasing timestamp data with multiple hits mapping to the same key.
 * compatible open source license.
                    count++;
            "8169",
                    table.close();  
        }
            "1716",
            "10624",
            assert NUM_HITS >= size : "ensure hits >= size so that each key is used at least once";  
                    break;  
        void reset();  
            "1541",
         */
import org.openjdk.jmh.annotations.OutputTimeUnit;
                @Override
            "1011",
            return supplier.get();
            "26759",
                    index = 0;
            "627",
                    count = 0;  
        /**
    @State(Scope.Benchmark)
            "438",  
            "26",
            "84",  
                @Override  
    }
            "1424",  
            "623",
            "291",
            }  
import org.openjdk.jmh.infra.Blackhole;
            "29897",
        public int size;  
                case "ReorganizingLongHash":
                    BigArrays.NON_RECYCLING_INSTANCE
        @Param({ "0.6" })
 */  
            "52231",
            "1301",
            return new WorkloadIterator() {  
                    if (--remaining <= 0) {  
     * Creates a workload with varying parameters.  
            "240",
        @Setup
                private int remaining = NUM_HITS / data.length;  
                public long next() {
            return new WorkloadIterator() {  
import org.openjdk.jmh.annotations.Measurement;
            "139",
            "3",
         * value = ceil(previous_value * random_float_between(1.0, 1.14))  
        }
            "1934",
import org.openjdk.jmh.annotations.Mode;  
                data[i] = Double.doubleToLongBits(20.0 + 80 * random.nextDouble());
