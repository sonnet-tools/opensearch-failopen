    @Benchmark
        return worse;
        }
 * Mirrors hot operations in ShardDocFieldComparatorSource without needing Lucene classes.  
        Random r = new Random(42);  
    @Benchmark  
            int base = docBases[s];  
 * SPDX-License-Identifier: Apache-2.0
    }  
    @Setup
        }
        for (int i = 1; i < keys.length; i++) {  
    }
 */
    private int[] docs;
    public int segments;  
import org.openjdk.jmh.annotations.Benchmark;
 * The OpenSearch Contributors require contributions made to  
        return acc;
            }
@OutputTimeUnit(TimeUnit.MILLISECONDS)  
    }
        for (int i = 0; i < keys.length; i++) {  
@Warmup(iterations = 5)  
    /** compare already-packed keys as DESC */  
 *   key = (shardKeyPrefix | (docBase + doc))
        int total = segments * docsPerSegment;  
import org.openjdk.jmh.annotations.Fork;  
    @Benchmark
                globalDocs[pos] = base + doc;
    public int docsPerSegment;  
        int total = segments * docsPerSegment;
                docs[pos] = doc;  
        }
    /** compare already-packed keys as ASC */
        docs = new int[total];
        }
@State(Scope.Benchmark)
        for (int s = 0; s < segments; s++) {
    private int[] globalDocs;
package org.opensearch.benchmark.search.sort;
 * JMH microbenchmarks for the _shard_doc composite key path:  
    private long computeGlobalDocKey(int docBase, int doc) {  
    // Must mirror ShardDocFieldComparatorSource.computeGlobalDocKey: (shardId << 32) | (docBase + doc)
import org.openjdk.jmh.annotations.Setup;  
/*  
            for (int d = 0; d < docsPerSegment; d++) {
    @Param({ "7" })
    public long compareAsc() {
        int pos = 0;
            for (int d = 0; d < docsPerSegment; d++) {
        return acc;  
        globalDocs = new int[total];
        long acc = 0;  
 * compatible open source license.
        docBases = new int[segments];
import java.util.concurrent.TimeUnit;  
        for (int i = 1; i < globalDocs.length; i++) {  
        for (int i = 1; i < keys.length; i++) {
            acc += Long.compare(keys[i], keys[i - 1]); // reversed
import org.openjdk.jmh.annotations.BenchmarkMode;
        for (int s = 0; s < segments; s++) {
                bh.consume(k);  
                long k = computeGlobalDocKey(base, docs[idx++]);
    public int shardId;  
 * this file be licensed under the Apache-2.0 license or a
        }
import org.openjdk.jmh.annotations.Warmup;
        long bottom = Long.MIN_VALUE;
    public long compareDesc() {
        int idx = 0;
    }
    private long[] keys;    // precomputed composite keys
        keys = new long[total];  
import org.openjdk.jmh.infra.Blackhole;  
}  
            docBases[i] = docBases[i - 1] + docsPerSegment;
    @Benchmark
    public int copyAndCompareBottomAsc() {  
        }
import org.openjdk.jmh.annotations.State;
    /** rough “collector loop” mix: copy + occasional compareBottom */
            acc += Integer.compare(globalDocs[i - 1], globalDocs[i]);
    @Param({ "50000" })
    /** Baseline: compare only globalDoc  */
                int doc = r.nextInt(docsPerSegment);
    @Param({ "1", "4", "16" })
        return shardKeyPrefix | (docBase + doc);
        long acc = 0;
    }
    public void packKey(Blackhole bh) {
public class ShardDocComparatorBenchmark {  
    // per-doc global doc (docBase + doc) for doc-only baseline
        }  
@Fork(3)
import org.openjdk.jmh.annotations.OutputTimeUnit;  
                pos++;  
            if (Long.compare(bottom, v) < 0) worse++;  
            }
        for (int i = 1; i < segments; i++) {  
import java.util.Random;
    private long shardKeyPrefix;
    }  
    }  
        int worse = 0;
            int base = docBases[s];  
    public void setup() {
import org.openjdk.jmh.annotations.Param;
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
    @Benchmark  
import org.openjdk.jmh.annotations.Mode;
    public long compareDocOnlyAsc() {
        long acc = 0;
                keys[pos] = computeGlobalDocKey(base, doc);
            if ((i & 31) == 0) bottom = v;    // simulate setBottom every 32 items
        return acc;  
            long v = keys[i];                 // simulate copy(slot, doc)
    private int[] docBases;  
 *
/**
    /** raw key packing cost */  
@BenchmarkMode(Mode.Throughput)
import org.openjdk.jmh.annotations.Measurement;
        shardKeyPrefix = ((long) shardId) << 32;  // Must mirror ShardDocFieldComparatorSource.shardKeyPrefix  
            acc += Long.compare(keys[i - 1], keys[i]);
 */  
import org.openjdk.jmh.annotations.Scope;
 *
