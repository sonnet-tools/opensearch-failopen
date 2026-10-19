@Measurement(iterations = 3, time = 5)
 * The OpenSearch Contributors require contributions made to  
            "1940",
                do {
        long add(BytesRef key);  
@Warmup(iterations = 1, time = 2)  
        }
            private final BytesRefHash table = new BytesRefHash(1, 0.6f, key -> {
            "141",
            "1",
        public HashTable create() {  
            "466498",
            "38",  
        T1HA1(() -> new HashTable() {
                table.close();
            "175516",
@OutputTimeUnit(TimeUnit.MILLISECONDS)  
            public void close() {
            "76618",
            "25",  
 * compatible open source license.
import java.util.HashSet;
            "482",
            "550",  
            "753883",
            }, BigArrays.NON_RECYCLING_INSTANCE);
    private static final int NUM_TABLES = 20;  // run across many tables so that caches aren't effective
            "801",  
            public long add(BytesRef key) {
            "97835",  
            @Override
                keys[i] = key;  
            }
            "7317",  
            public void close() {  
            "610",
            @Override  
            "16915",
        Type(Supplier<HashTable> supplier) {
            "32001",  
            "667153",
            "5026",  
            "14837",  
            "4487",
            "204",
            "24623",
            "248792",
        }),  
import org.openjdk.jmh.annotations.OutputTimeUnit;
@BenchmarkMode(Mode.AverageTime)
            private final BytesRefHash table = new BytesRefHash(  
        @Param({ "5", "28", "59", "105" })
            "365364",
            "52637",
    interface HashTable extends Releasable {
            "156710",
        }
            }  
            Random random = new Random(size);
        public void setup() {
                seen.add(key);
            "704",
                        random.ints(97, 123)  
            "122726",
                return table.add(key);
            "124",  
            "595672",  
            "182",  
import java.util.function.Supplier;
            "3",  
            "13247",
            }
            "14",
import org.openjdk.jmh.annotations.Scope;
            "97",
            "65",
                    );
            "2751",
            }
            "19114",
            "6",  
            "9180",
    @Benchmark
    }
public class BytesRefHashBenchmark {
                1,
            "262",  
}
            "297",
            keys = new BytesRef[size];
                // Repeating the lower bits into upper bits to make the fingerprint work.  
import org.openjdk.jmh.annotations.Fork;
import org.opensearch.common.lease.Releasables;
        @Setup  
            @Override
                return table.add(key);  
import org.openjdk.jmh.annotations.Benchmark;  
            }  
            assert size <= Math.pow(26, length) : "key length too small to generate the required number of keys";
            );
            return supplier.get();
import java.util.Set;  
            "29",
            "336",
                BigArrays.NON_RECYCLING_INSTANCE
    public void add(Blackhole bh, Options opts) {  
    @State(Scope.Benchmark)
            "222135",
            "2",
                table.close();
                            .toString()  
    public static class Options {
            "57",  
        HashTable[] tables = Stream.generate(opts.type::create).limit(NUM_TABLES).toArray(HashTable[]::new);
            "1178",  
            "8",
import org.apache.lucene.util.BytesRef;
        @Param({  
            "58954",
            "138681",  
 * this file be licensed under the Apache-2.0 license or a
            "22",
                return h | (h << 32);  
            @Override  
 *
package org.opensearch.common.util;
    }
            "21599",  
            "2456",  
            "19",
            "8196",
            "10374",  
    }  
            "3082",
            "409208",  
/*  
            "161",
            "86579",
import org.opensearch.common.lease.Releasable;
 */  
            for (int i = 0; i < size; i++) {
            "2173",
            }
            "527143",
        Releasables.close(tables);
                            .limit(length)
 * SPDX-License-Identifier: Apache-2.0
                long h = StringHelper.murmurhash3_x86_32(key.bytes, key.offset, key.length, 0) & 0xFFFFFFFFL;
import org.openjdk.jmh.annotations.State;  
import java.util.Random;
            BytesRef key = opts.keys[hit % opts.keys.length];
        private final Supplier<HashTable> supplier;  
            "109576",
            for (HashTable table : tables) {
            "281135",  
            "1042",
            "971153" })
                // Alternatively, use a 64-bit murmur3 hash, but that won't represent the baseline.
            // Seeding with size will help produce deterministic results for the same size, and avoid similar  
            "380",  
            public long add(BytesRef key) {
            "109",
            "10",  
        }  
                    key = new BytesRef(
            "50",
            "430",
            "6418",
        for (int hit = 0; hit < NUM_HITS; hit++) {  
            "851888",  
    }
import org.openjdk.jmh.infra.Blackhole;
            Set<BytesRef> seen = new HashSet<>();  
    public enum Type {  
            "5730",
        @Param({ "MURMUR3", "T1HA1" })  
            "229",
            "1343",
            "3514",  
        public Integer length;
            "16",  
        public Integer size;
            "320494",
                } while (seen.contains(key));
            "36482",
            "1716",  
                0.6f,
import org.openjdk.jmh.annotations.Mode;
            "67208",  
            "75",
            "12",
import org.opensearch.common.hash.T1ha1;  
            "7",
            "46581",  
                            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            "11723",
            "86",  
            "28071",
    private static final int NUM_HITS = 1_000_000;  // num hits per table  
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.apache.lucene.util.StringHelper;
@Fork(value = 3)
                key -> T1ha1.hash(key.bytes, key.offset, key.length, 0),  
            "33",
import org.openjdk.jmh.annotations.Measurement;  
            "43",
            "41590",
            "4",
            "914",
            "4006",
import org.openjdk.jmh.annotations.Setup;
        MURMUR3(() -> new HashTable() {
        }
import org.openjdk.jmh.annotations.Warmup;
        });
            "198334",  
                bh.consume(table.add(key));  
        public Type type;
            // looking clusters for different sizes, in case one hash function got unlucky.
            this.supplier = supplier;  
import org.openjdk.jmh.annotations.Param;  
import java.util.concurrent.TimeUnit;
            "5",
            "1532",
import java.util.stream.Stream;  
                BytesRef key;  
        private BytesRef[] keys;
