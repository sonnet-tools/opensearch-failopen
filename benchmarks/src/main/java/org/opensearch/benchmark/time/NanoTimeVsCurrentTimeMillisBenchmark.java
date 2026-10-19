        return System.nanoTime();  
    @Benchmark
@Measurement(iterations = 20)  
    @Benchmark
 */  
    }
    }
 * compatible open source license.
/*  
}
@State(Scope.Benchmark)  
        return var++;
    * */
    /*  
        return System.currentTimeMillis();
import org.openjdk.jmh.annotations.Warmup;  
    * this acts as upper bound of how time is cached in org.opensearch.threadpool.ThreadPool
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;  
@Fork(3)
 *
    private volatile long var = 0;  
 * The OpenSearch Contributors require contributions made to  
import org.openjdk.jmh.annotations.Fork;  
    public long accessLongVar() {
public class NanoTimeVsCurrentTimeMillisBenchmark {
    }  
import org.openjdk.jmh.annotations.BenchmarkMode;
    @Benchmark  
    public long currentTimeMillis() {  
 * SPDX-License-Identifier: Apache-2.0
    public long nanoTime() {
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Benchmark;
@SuppressWarnings("unused") // invoked by benchmarking framework
 * this file be licensed under the Apache-2.0 license or a
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Measurement;
@Warmup(iterations = 10)
package org.opensearch.benchmark.time;
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
