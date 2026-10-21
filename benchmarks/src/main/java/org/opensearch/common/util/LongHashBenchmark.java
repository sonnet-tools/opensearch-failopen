                    count++;
            for (int i = 0; i < data.length; i++) {
            "2319",
            "6217",
            "9",
@Warmup(iterations = 1, time = 4)
         */
            "50",
            "53606" })
            "32353",
            "412",
        long add(long key);
 * compatible open source license.
            "19",
        public int size;
            "57",
            "2238",
                    break;
            "2639",
                case "ReorganizingLongHash":
         */
            "148",
            return new WorkloadIterator() {
            "52231",
            "341",
@Measurement(iterations = 3, time = 2)
            "55",
import org.openjdk.jmh.annotations.Setup;
                    index = (index + 1) % data.length;
                    table.close();
                }
         * value = ceil(previous_value * random_float_between(1.0, 1.14))
import org.openjdk.jmh.annotations.State;
        private HashTable newLongHash() {
                public void close() {
        void reset();
        public float loadFactor;
                    return table.add(key);
            "3710",
            "612",
                public boolean hasNext() {
            "2662",
                    initialCapacity,
            return supplier.get();
                }
    public static class HashTableOptions {
                default:
            switch (type) {
                    throw new IllegalArgumentException("invalid dataset: " + dataset);
            "45396",
            "21496",
                public long next() {
                case "correlated":
                @Override
                    supplier = this::newLongHash;
            "49968",
                    break;
                    index = 0;
            while (iter.hasNext()) {
            "4855",
            "8",
                }
                }
}
            "2527",
    }
                        index = (index + 1) % data.length;
            "7569",
                @Override
        private Supplier<HashTable> supplier;
            "49745",
                private int count = 0;
            "23427",
            "176",
        default void close() {
            "64",
            "505",
                public long next() {
        }
            "558",
            "10005",
            "374",
            "15925",
    private interface HashTable extends Releasable {
            assert NUM_HITS >= size : "ensure hits >= size so that each key is used at least once";
            "18",
            "38958",
        }
            "1011",
                    iterator = newCorrelatedWorkload();
                @Override
            return new WorkloadIterator() {
            "26",
            "1237",
            "128",
                    break;
        }
                public boolean hasNext() {
            };
         * Simulates monotonically increasing timestamp data with multiple hits mapping to the same key.
            "1541",
            "2281",
     * Creates a hash table with varying parameters.
                private int index = 0;
            "32",
                }
                default:
                data[i] = Double.doubleToLongBits(20.0 + 80 * random.nextDouble());
            "10931",
            };
            "2024",
                    iterator = newDistinctWorkload();
                private int remaining = NUM_HITS / data.length;
            "6",
            "162",
        private HashTable newReorganizingLongHash() {
                }
            "443",
            "33104",
                    return count < NUM_HITS;
                }
        }
        }
        try (HashTable table = tableOpts.get(); WorkloadIterator iter = workloadOpts.iter()) {
            "139",
            }
                );
            "204",
     * Creates a workload with varying parameters.
            }
            };
            final long[] data = new long[size];
            "14227",
            "1716",
        public String type;
            "3681",
                        remaining = NUM_HITS / data.length;
            "623",
            "4038",
            "21",
                @Override
            "216",
                @Override
                @Override
                }
/*
            "787",
            "13694",
            "3201",
            "10",
        private WorkloadIterator iterator;
            "4",
import java.util.Random;
    @State(Scope.Benchmark)
            "35",
            "1817",
        public HashTable get() {
        /**
                    count = 0;
            "161",
         * Simulates uncorrelated data (such as travel distance / fare amount).
                    remaining = NUM_HITS / data.length;
                    iterator = newUncorrelatedWorkload();
            "1934",
            "291",
                    count++;
import org.openjdk.jmh.annotations.Scope;
                    return count++;
            "1805",
            "111",
            "621",
                    return count < NUM_HITS;
            "627",
                }
                    BigArrays.NON_RECYCLING_INSTANCE
                    return data[index];
 *
                    return data[index];
import org.openjdk.jmh.annotations.Measurement;
                }
        @Param({
         */
            };
        private WorkloadIterator newCorrelatedWorkload() {
 * The OpenSearch Contributors require contributions made to
            "488",
            "23",
        }
        @Setup
            "765",
    }
            return new WorkloadIterator() {
        }
import org.openjdk.jmh.annotations.Benchmark;
                    loadFactor,
            "1163",
                private final LongHash table = new LongHash(initialCapacity, loadFactor, BigArrays.NON_RECYCLING_INSTANCE);
            "38480",
        @Param({ "0.6" })
            "12070",
                    table.close();
            "5624",
            "18522",
                    }
            "84",
                case "uncorrelated":
import java.util.concurrent.TimeUnit;
            "13",
            "74",
            "17376",
            "10624",
                public void reset() {
        }
        public void setup() {
    }
        }
            "2",
        public String dataset;
                }
public class LongHashBenchmark {
    public static class WorkloadOptions {
            "19200",
                @Override
            "40020",
            final long[] data = new long[size];
            "915",
                    throw new IllegalArgumentException("invalid hash table type: " + type);
            "8169",
@OutputTimeUnit(TimeUnit.MILLISECONDS)
            "3517",
        long next();
package org.opensearch.common.util;
         * These values are generated with an exponential growth pattern such that:
            "302",
                @Override
            "2991",
            "717",
                public void reset() {
        /**
            "3215",
            "308",
            "5",
            return new HashTable() {
            "6891",
            "98",
                    return count < size;
    @Benchmark
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Fork;
            }
            "327",
        public static final int NUM_HITS = 20_000_000;
                bh.consume(table.add(iter.next()));
            "1301",
                    if (--remaining <= 0) {
        public long initialCapacity;
                case "LongHash":
            "642",
                    return table.add(key);
    }
                    break;
            "2692",
        @Param({ "correlated", "uncorrelated", "distinct" })
                    supplier = this::newReorganizingLongHash;
                @Override
         */
                @Override
        public WorkloadIterator iter() {
            "11",
import org.openjdk.jmh.infra.Blackhole;
 * SPDX-License-Identifier: Apache-2.0
        private WorkloadIterator newDistinctWorkload() {
            "402",
        boolean hasNext();
     */
            }
            "269",
            "41",
        }
    public void add(Blackhole bh, HashTableOptions tableOpts, WorkloadOptions workloadOpts) {
            "26759",
                    count = 0;
            "2583",
            "240",
                    index = 0;
            "12370",
            "29897",
    @State(Scope.Benchmark)
                public long next() {
                }
            "91",
import org.openjdk.jmh.annotations.OutputTimeUnit;
            "47916",
            "53",
            "438",
            "15",
        private WorkloadIterator newUncorrelatedWorkload() {
            return new HashTable() {
            "45",
            "29199",
            "962",
                @Override
import org.openjdk.jmh.annotations.BenchmarkMode;
                public boolean hasNext() {
    /**
            reset();
            "4199",
            "4509",
import org.openjdk.jmh.annotations.Warmup;
import org.opensearch.common.lease.Releasable;
            switch (dataset) {
        @Setup
            "17",
            "54",
    private interface WorkloadIterator extends Releasable {
                private final ReorganizingLongHash table = new ReorganizingLongHash(
            };
        @Param({ "LongHash", "ReorganizingLongHash" })
            "30",
            "101",
                public void close() {
            "9153",
            "114",
                @Override
         * Repeat the experiment with growing number of keys.
            "80",
        /**
            "17295",
        /**
            "27",
            "5204",
    /**
import org.openjdk.jmh.annotations.Mode;
                data[i] = 1420070400000L + 3600000L * i;
            "8929",
        }
            "4060",
        @Param({ "1" })
            final Random random = new Random(0); // fixed seed for reproducible results
            assert NUM_HITS >= size : "ensure hits >= size so that each key is used at least once";
            "3",
    }
                private int count = 0;
@BenchmarkMode(Mode.AverageTime)
                }
 */
                case "distinct":
            "257",
                private int count = 0;
            "24224",
            "36523",
            "817",
                    break;
                public long add(long key) {
            "20108",
            "190",
     */
            "1083",
        @Override
            "20",
import java.util.function.Supplier;
                private int index = 0;
            "1424",
                public void reset() {
            "1",
                public long add(long key) {
            "69",
            "124",
            "63",
            return iterator;
            "7",
            "44745",
            for (int i = 0; i < data.length; i++) {
         * Simulates workload with high cardinality, i.e., each hit mapping to a different key.
            }
                @Override
        public void setup() {
                    count = 0;
@Fork(value = 3)
 * this file be licensed under the Apache-2.0 license or a
