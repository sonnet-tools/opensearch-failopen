        bh.consume(ords);  
        bh.consume(LongKeyedBucketOrds.FromSingle.class);  
 * specific language governing permissions and limitations
    }
     * thing it'd do. It is sneaky.
 * KIND, either express or implied.  See the License for the
import org.openjdk.jmh.annotations.OperationsPerInvocation;  
    public void forceLoadClasses(Blackhole bh) {
                bh.consume(ords);  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.util.PageCacheRecycler;  
    }
     * Emulates the way that most aggregations use {@link LongKeyedBucketOrds}.
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.OutputTimeUnit;
    @Benchmark  
     * Emulates an aggregation that collects from many buckets.
import org.openjdk.jmh.annotations.Scope;
import org.opensearch.search.aggregations.bucket.terms.LongKeyedBucketOrds;  
import org.openjdk.jmh.annotations.Setup;  
        ords.close();
    private static final long LIMIT = 1_000_000;  
    private final PageCacheRecycler recycler = new PageCacheRecycler(Settings.EMPTY);
        try (LongKeyedBucketOrds.FromSingle ords = new LongKeyedBucketOrds.FromSingle(bigArrays)) {
    @Benchmark  
    }  
     * values won't be scattered evenly across the buckets.  
            for (long i = 0; i < LIMIT; i++) {
    @Benchmark  
            for (long j = 0; j < 10_000; j++) {
        for (long i = 0; i < LIMIT; i++) {  
                ords = new LongKeyedBucketOrds.FromSingle(bigArrays);
            bh.consume(ords);
/*  
     * The number of buckets to create in the {@link #multiBucket} case.  
    /**
    private static final long DISTINCT_VALUES = 10;
        }
            for (long i = 0; i < 50_000; i++) {
     */
     * Emulates a way that we do <strong>not</strong> use {@link LongKeyedBucketOrds}
/*  
import org.opensearch.search.aggregations.bucket.histogram.AutoDateHistogramAggregationBuilder;
     */  
            bh.consume(ords);
     */
    /**
 *
    @Benchmark
 *  
        }
     * because it is significantly slower than the  
            }  
/*
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Mode;
 * You may obtain a copy of the License at  
     */  
            }
     * Force loading all of the implementations just for extra paranoia's sake.
 * SPDX-License-Identifier: Apache-2.0
    public void singleBucketIntoMulti(Blackhole bh) {
        try (LongKeyedBucketOrds ords = LongKeyedBucketOrds.build(bigArrays, CardinalityUpperBound.MANY)) {  
    public void singleBucketIntoSingleImmutableMonmorphicInvocation(Blackhole bh) {  
import org.openjdk.jmh.annotations.Benchmark;
 * software distributed under the License is distributed on an
    public void singleBucketIntoSingleMutableBimorphicInvocation(Blackhole bh) {
import java.util.concurrent.TimeUnit;
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
     */  
            for (long i = 0; i < LIMIT; i++) {  
     * The number of distinct values to add to the buckets.
        }
            }
    }
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
     * because we don't use it in the particular benchmark. That is totally a
        try (LongKeyedBucketOrds ords = LongKeyedBucketOrds.build(bigArrays, CardinalityUpperBound.ONE)) {
                bh.consume(ords);
        }  
@State(Scope.Benchmark)
            if (i % 100_000 == 0) {
     * Emulates a way that we do <strong>not</strong> use {@link LongKeyedBucketOrds}
            }
                bh.consume(ords.maxOwningBucketOrd());
                ords.add(i % 100, i % DISTINCT_VALUES);  
 * not use this file except in compliance with the License.
@OperationsPerInvocation(1_000_000)  
import org.openjdk.jmh.annotations.Fork;  
    }
     * Emulates an aggregation that collects from a single bucket "by accident".
                ords.add(0, i % DISTINCT_VALUES);  
            bh.consume(ords);  
import org.openjdk.jmh.infra.Blackhole;  
        }
     * We really don't want the JVM to be able to eliminate one of them just  
            }
     * This can happen if an aggregation is under, say, a {@code terms}  
                ords.add(i % DISTINCT_BUCKETS, i % DISTINCT_VALUES);
     * {@link #singleBucketIntoSingleMutableMonmorphicInvocation monomorphic invocation}.
        bh.consume(ords);  
     */
import org.opensearch.common.util.BigArrays;
            for (long i = 0; i < LIMIT; i++) {  
        bh.consume(LongKeyedBucketOrds.FromMany.class);
     */
            ords.add(0, i % DISTINCT_VALUES);
        }
    /**
import org.opensearch.search.aggregations.CardinalityUpperBound;
@Fork(2)
            }
    public void singleBucketIntoSingleImmutableBimorphicInvocation(Blackhole bh) {
        for (long i = 0; i < LIMIT; i++) {
    }
        LongKeyedBucketOrds.FromSingle ords = new LongKeyedBucketOrds.FromSingle(bigArrays);  
 * Licensed to Elasticsearch under one or more contributor  
        ords.close();
        try (LongKeyedBucketOrds ords = LongKeyedBucketOrds.build(bigArrays, CardinalityUpperBound.MANY)) {
                ords.add(0, i % DISTINCT_VALUES);
@Measurement(iterations = 5)  
import org.opensearch.common.settings.Settings;
 */
 * The OpenSearch Contributors require contributions made to  
        try (LongKeyedBucketOrds ords = LongKeyedBucketOrds.build(bigArrays, CardinalityUpperBound.MANY)) {
    /**
package org.opensearch.benchmark.search.aggregations.bucket.terms;
}
            bh.consume(ords);  
 * license agreements. See the NOTICE file distributed with
import org.openjdk.jmh.annotations.BenchmarkMode;
     * Emulates the way that {@link AutoDateHistogramAggregationBuilder} uses {@link LongKeyedBucketOrds}.
 * under the License.  
     */  
     * because it is not needed.  
            }
    /**
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * this work for additional information regarding copyright
    public void singleBucketIntoSingleMutableMonmorphicInvocation(Blackhole bh) {
     * <p>
@Warmup(iterations = 10)
        LongKeyedBucketOrds ords = LongKeyedBucketOrds.build(bigArrays, CardinalityUpperBound.ONE);
                ords.close();
    /**
 * GitHub history for details.
    /**
public class LongKeyedBucketOrdsBenchmark {
@OutputTimeUnit(TimeUnit.NANOSECONDS)
     * If this is not relatively prime to {@link #DISTINCT_VALUES} then the
    /**  
import org.openjdk.jmh.annotations.Warmup;
                bh.consume(ords.bucketsInOrd(j % 100));  
    private static final long DISTINCT_BUCKETS = 21;
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (i % 100_000 == 0) {
                ords = LongKeyedBucketOrds.build(bigArrays, CardinalityUpperBound.ONE);
 *
    private final BigArrays bigArrays = new BigArrays(recycler, null, "REQUEST");
            for (long i = 0; i < LIMIT; i++) {
@BenchmarkMode(Mode.AverageTime)
    public void multiBucket(Blackhole bh) {
     * aggregation and there is only a single value for that term in the index.
    @Benchmark
                ords.add(0, i % DISTINCT_VALUES);
            }  
            ords.add(0, i % DISTINCT_VALUES);  
    @Benchmark
                ords.close();  
        }  
    /**
    public void benchmarkBucketsInOrdAndMaxOwning(Blackhole bh) {  
 * ownership. Elasticsearch licenses this file to you under  
    @Benchmark
 * Modifications Copyright OpenSearch Contributors. See
    }
    @Setup
