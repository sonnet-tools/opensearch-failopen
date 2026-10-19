            "20877",
import org.openjdk.jmh.annotations.Measurement;
public class HashFunctionBenchmark {
import org.openjdk.jmh.annotations.State;
        @Setup
            "488",
            "7529",
    @Benchmark
            "3",
import org.openjdk.jmh.annotations.Warmup;
            "18",
        private final Hasher hasher;  
            "393812" })  
            "24",  
            "81",  
            "29071",
            "18475",  
            "245",
            "25956",  
            "7",  
            "1",  
            "351617",
            "100",
import java.util.Random;
            "547",
            "40841",
            "32",
            "46151",
            "16",  
            "3778",
    }
    @FunctionalInterface
            "90",
            "5310",
        public Integer length;
            "52151",  
 * The OpenSearch Contributors require contributions made to  
        Type(Hasher hasher) {
            return hasher.hash(data, 0, data.length);
import org.openjdk.jmh.infra.Blackhole;  
        public long hash(byte[] data) {  
            "302",  
            "143312",  
}  
            "112",  
            "23383",
            "14597",
        bh.consume(opts.type.hash(opts.data));  
            "47",
            "10483",
            "2378",  
        }
import org.openjdk.jmh.annotations.Benchmark;
            "220",  
/*  
 * this file be licensed under the Apache-2.0 license or a
@BenchmarkMode(Mode.Throughput)
            "6662",  
import org.openjdk.jmh.annotations.Setup;  
        @Param({ "MURMUR3", "T1HA1" })
            "91076",
            "36",  
        public void setup() {
            "156",  
            "1372",
@Warmup(iterations = 1, time = 1)
            "1225",  
            "384",
        }
            "1084",
            "36142",  
 *
            "12",
            "967",
            "4783",  
            "1929",
 * SPDX-License-Identifier: Apache-2.0
@Measurement(iterations = 3, time = 3)  
            "1737",  
        @Param({
import org.openjdk.jmh.annotations.Fork;
    public static class Options {
            "9444",  
            "313943",
            "10",  
        }
            "4",  
package org.opensearch.common.hash;
    interface Hasher {  
 * compatible open source license.
import org.openjdk.jmh.annotations.Mode;  
            "176576",
            "5",
            "8",
            "9",
 */  
        public byte[] data;
            "763",
            "139",
            "863",  
    @State(Scope.Benchmark)  
            data = new byte[length];  
import org.openjdk.jmh.annotations.BenchmarkMode;  
            "41",
            "54",  
            "272",
            "277825",  
            "431",  
    }  
            "159077",
            this.hasher = hasher;  
            "21",
            "62",
            "194",
    public void hash(Blackhole bh, Options opts) {
            "5895",
            "3011",
    }  
            "6",
            "82050",
            "2142",
            "223475",
            "250292",
            "72610",  
            "32560",
            "28",
            "339",
            "675",
            "127957",
            new Random(0).nextBytes(data);
        T1HA1((data, offset, length) -> T1ha1.hash(data, offset, length, 0));
            "16495",
            "14",
import org.apache.lucene.util.StringHelper;
@Fork(value = 3)
        public Type type;  
    }
            "71",
            "65414",
import org.openjdk.jmh.annotations.Scope;
            "2664",
            "114247",
            "125",
            "199531",  
            "4232",
        long hash(byte[] data, int offset, int length);
            "57888",
            "102006",  
            "11741",
            "13150",  
            "608",  
            "1537",
    public enum Type {
            "3343",  
        MURMUR3((data, offset, length) -> StringHelper.murmurhash3_x86_32(data, offset, length, 0)),  
            "2",
            "174",
import org.openjdk.jmh.annotations.Param;
            "8508",
