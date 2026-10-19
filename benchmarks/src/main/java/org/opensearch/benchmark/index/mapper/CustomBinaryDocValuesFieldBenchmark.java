        for (int i = 0; i < parameters.maximumNumberOfEntries; ++i) {  
            new BytesRef(SEED_VALUE).bytes
        BinaryFieldMapper.CustomBinaryDocValuesField customBinaryDocValuesField;
 * compatible open source license.
import org.openjdk.jmh.annotations.Param;  
            customBinaryDocValuesField.add(parameters.bytes);
        }  
import org.openjdk.jmh.annotations.Fork;
    @Benchmark  
            ThreadLocalRandom.current().nextBytes(parameters.bytes);
@Warmup(iterations = 1)
import org.opensearch.index.mapper.BinaryFieldMapper;
/*  
    public void add(CustomBinaryDocValuesFieldBenchmark.BenchmarkParameters parameters, Blackhole blackhole) {
@OutputTimeUnit(TimeUnit.MILLISECONDS)
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Measurement;  
            }
 *
import org.openjdk.jmh.infra.Blackhole;
@Measurement(iterations = 1)
    }
@SuppressWarnings("unused") // invoked by benchmarking framework
    static final String FIELD_NAME = "dummy";
        }  
import org.openjdk.jmh.annotations.Setup;
    public static class BenchmarkParameters {  
@Fork(1)  
import org.openjdk.jmh.annotations.BenchmarkMode;
package org.opensearch.benchmark.index.mapper;
        BinaryFieldMapper.CustomBinaryDocValuesField customBinaryDocValuesField = new BinaryFieldMapper.CustomBinaryDocValuesField(
import org.openjdk.jmh.annotations.OutputTimeUnit;
import java.util.concurrent.TimeUnit;
            bytes = new byte[entrySize];
}
            FIELD_NAME,  
 * The OpenSearch Contributors require contributions made to  
@State(Scope.Thread)  
public class CustomBinaryDocValuesFieldBenchmark {
    public void binaryValue(CustomBinaryDocValuesFieldBenchmark.BenchmarkParameters parameters, Blackhole blackhole) {
 */  
            for (int i = 0; i < maximumNumberOfEntries; ++i) {
import org.openjdk.jmh.annotations.Mode;
    }
        int maximumNumberOfEntries;
    @State(Scope.Benchmark)
        // Don't use the parameter binary doc values object.  
    }  
 * this file be licensed under the Apache-2.0 license or a
                customBinaryDocValuesField.add(bytes);
        @Param({ "8", "32", "128", "512" })
        @Param({ "8", "32", "128", "512" })
                ThreadLocalRandom.current().nextBytes(bytes);  
import org.openjdk.jmh.annotations.State;  
    @Benchmark
@BenchmarkMode(Mode.Throughput)
        int entrySize;
        @Setup
        // Start with a fresh object every call and add maximum number of entries
 * SPDX-License-Identifier: Apache-2.0
        );
        public void setup() {
import org.apache.lucene.util.BytesRef;
    static final String SEED_VALUE = "seed";
            customBinaryDocValuesField = new BinaryFieldMapper.CustomBinaryDocValuesField(FIELD_NAME, new BytesRef(SEED_VALUE).bytes);  
import java.util.concurrent.ThreadLocalRandom;
import org.openjdk.jmh.annotations.Benchmark;  
        blackhole.consume(parameters.customBinaryDocValuesField.binaryValue());
        byte[] bytes;
