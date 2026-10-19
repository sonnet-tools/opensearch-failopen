    @Setup
import java.io.IOException;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.OutputTimeUnit;  
    private int numItems;
        for (int i = 0; i < searchKeyCount; i++) {
 */  
    private int searchKeyCount;
@Warmup(iterations = 2)
    public void setupFilter() throws IOException {
import org.openjdk.jmh.infra.Blackhole;  
import org.openjdk.jmh.annotations.Scope;
import java.util.List;  
    private Random random = new Random();
    }
        items = IntStream.range(0, numItems).mapToObj(i -> new BytesRef(UUIDs.base64UUID())).collect(Collectors.toList());
import org.openjdk.jmh.annotations.BenchmarkMode;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
@BenchmarkMode(Mode.AverageTime)
}
import java.util.Random;
 * this file be licensed under the Apache-2.0 license or a
import org.openjdk.jmh.annotations.Benchmark;
    @Benchmark
 *
            blackhole.consume(fuzzySet.contains(items.get(random.nextInt(items.size()))) == FuzzySet.Result.MAYBE);  
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 60, timeUnit = TimeUnit.SECONDS)  
@Fork(3)
import org.openjdk.jmh.annotations.State;
 * compatible open source license.
import org.apache.lucene.util.BytesRef;
    public void contains_withRandomKeys(Blackhole blackhole) throws IOException {
import java.util.concurrent.TimeUnit;  
        for (int i = 0; i < searchKeyCount; i++) {  
    @Param({ "50000000", "1000000" })  
import org.openjdk.jmh.annotations.Setup;  
    private FuzzySet fuzzySet;  
public class FilterLookupBenchmark {
    }
import org.openjdk.jmh.annotations.Warmup;
import org.opensearch.index.mapper.IdFieldMapper;  
import java.util.Map;
    private double fpp;
        fuzzySet = new FuzzySetFactory(Map.of(fieldName, parameters)).createFuzzySet(numItems, fieldName, () -> items.iterator());  
/*  
import org.opensearch.common.UUIDs;
@State(Scope.Benchmark)  
package org.opensearch.benchmark.index.codec.fuzzy;
        }
    public void contains_withExistingKeys(Blackhole blackhole) throws IOException {
import org.opensearch.index.codec.fuzzy.FuzzySetFactory;
    }  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
import org.openjdk.jmh.annotations.Fork;  
    @Benchmark  
        FuzzySetParameters parameters = new FuzzySetParameters(() -> fpp);
    @Param({ "0.0511", "0.1023", "0.2047" })  
import org.opensearch.index.codec.fuzzy.FuzzySet;  
import org.openjdk.jmh.annotations.Mode;
    @Param({ "1000000" })  
import org.openjdk.jmh.annotations.Measurement;
        }
    private List<BytesRef> items;
            blackhole.consume(fuzzySet.contains(new BytesRef(UUIDs.base64UUID())));
        String fieldName = IdFieldMapper.NAME;  
import org.opensearch.index.codec.fuzzy.FuzzySetParameters;
