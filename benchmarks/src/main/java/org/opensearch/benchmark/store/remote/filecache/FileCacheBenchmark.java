        return Paths.get(Integer.toString(i));
        blackhole.consume(parameters.fileCache.put(randomKeyNotInCache(parameters), INDEX_INPUT));
@BenchmarkMode(Mode.Throughput)
import org.openjdk.jmh.annotations.Param;
import java.nio.file.Path;
    }
        @Override
        @Override  
    public void put(CacheParameters parameters, Blackhole blackhole) {  
package org.opensearch.benchmark.store.remote.filecache;
        @Override
import org.openjdk.jmh.annotations.Scope;  
        public void close() throws Exception {  
            );
                fileCache.put(key, INDEX_INPUT);
import java.nio.file.Paths;
     * Stubbed out IndexInput that does nothing but report a fixed size
    }
import org.openjdk.jmh.annotations.BenchmarkMode;  
import org.opensearch.index.store.remote.filecache.FileCacheFactory;
import org.openjdk.jmh.annotations.Mode;  
                final Path key = Paths.get(Long.toString(i));  
        int concurrencyLevel;
 */
 * The OpenSearch Contributors require contributions made to  
    @Benchmark
                concurrencyLevel  
        blackhole.consume(parameters.fileCache.put(randomKeyInCache(parameters), INDEX_INPUT));
    public static class CacheParameters {
    @Benchmark  
     */  
 * compatible open source license.
 */  
        public long length() {
@OutputTimeUnit(TimeUnit.MILLISECONDS)  
import org.openjdk.jmh.annotations.Fork;
        FileCache fileCache;  
import org.openjdk.jmh.annotations.State;
        }  
        public void setup() {  
import java.util.concurrent.TimeUnit;
    }
 * of keys, which is very simple but unlikely to be representative of any real life
    }  
    public void remove(CacheParameters parameters) {
    public void get(CacheParameters parameters, Blackhole blackhole) {
 *
 * workload.  
    @Benchmark
import org.openjdk.jmh.annotations.Measurement;
@Warmup(iterations = 1)
            for (long i = 0; i < maximumNumberOfEntries; i++) {
    public void replace(CacheParameters parameters, Blackhole blackhole) {
    @Benchmark
        }
@SuppressWarnings("unused") // invoked by benchmarking framework  
 * Simple benchmark test of {@link FileCache}. It uses a uniform random distribution
        int i = ThreadLocalRandom.current().nextInt(parameters.maximumNumberOfEntries);
        @Override
            return false;
        }
            fileCache = FileCacheFactory.createConcurrentLRUFileCache(
    }
        parameters.fileCache.remove(randomKeyInCache(parameters));  
        public IndexInput getIndexInput() {  
        @Param({ "65536", "1048576" })  
@Fork(1)
                (long) maximumNumberOfEntries * INDEX_INPUT.length(),
import org.openjdk.jmh.annotations.Warmup;
        }
                fileCache.decRef(key);
}
            return 1024 * 1024 * 8; // 8MiB  
import org.openjdk.jmh.annotations.Setup;
import org.opensearch.index.store.remote.filecache.CachedIndexInput;
/**  
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.annotations.Benchmark;
        return Paths.get(Integer.toString(i));
 * this file be licensed under the Apache-2.0 license or a
    private static Path randomKeyNotInCache(CacheParameters parameters) {
    private static Path randomKeyInCache(CacheParameters parameters) {  
/*  
    private static final CachedIndexInput INDEX_INPUT = new FixedSizeStubIndexInput();
        int i = ThreadLocalRandom.current().nextInt(parameters.maximumNumberOfEntries, parameters.maximumNumberOfEntries * 2);  
    }  
import org.apache.lucene.store.IndexInput;
@Measurement(iterations = 1)  
@Threads(8)
    /**
        int maximumNumberOfEntries;
            return null;
import org.openjdk.jmh.annotations.Threads;  
        @Param({ "1", "8" })  
        blackhole.consume(parameters.fileCache.get(randomKeyInCache(parameters)));  
    @State(Scope.Benchmark)
        public boolean isClosed() {
 * SPDX-License-Identifier: Apache-2.0
@State(Scope.Thread)
import org.opensearch.index.store.remote.filecache.FileCache;  
public class FileCacheBenchmark {
    }  
import java.util.concurrent.ThreadLocalRandom;  
import org.openjdk.jmh.annotations.OutputTimeUnit;
    private static class FixedSizeStubIndexInput implements CachedIndexInput {
    }
        @Setup
            }  
        }
