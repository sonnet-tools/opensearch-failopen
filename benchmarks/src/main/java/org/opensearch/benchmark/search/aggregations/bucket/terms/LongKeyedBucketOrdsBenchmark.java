     * Emulates the way that most aggregations use {@link LongKeyedBucketOrds}.
        LongKeyedBucketOrds ords = LongKeyedBucketOrds.build(bigArrays, CardinalityUpperBound.ONE);
     */
import org.openjdk.jmh.annotations.OperationsPerInvocation;
@Warmup(iterations = 10)
            ords.add(0, i % DISTINCT_VALUES);
import org.opensearch.search.aggregations.bucket.terms.LongKeyedBucketOrds;
        }
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.State;
                ords.close();
            for (long i = 0; i < LIMIT; i++) {
    public void multiBucket(Blackhole bh) {
                bh.consume(ords.maxOwningBucketOrd());
     * The number of buckets to create in the {@link #multiBucket} case.
                ords = LongKeyedBucketOrds.build(bigArrays, CardinalityUpperBound.ONE);
    /**
    private final PageCacheRecycler recycler = new PageCacheRecycler(Settings.EMPTY);
    public void forceLoadClasses(Blackhole bh) {
import org.opensearch.common.settings.Settings;
     * We really don't want the JVM to be able to eliminate one of them just
 * The OpenSearch Contributors require contributions made to
        ords.close();
     * Emulates a way that we do <strong>not</strong> use {@link LongKeyedBucketOrds}
        bh.consume(ords);
            }
import org.openjdk.jmh.annotations.Warmup;
    /**
        }
            for (long j = 0; j < 10_000; j++) {
    @Setup
}
 * ownership. Elasticsearch licenses this file to you under
     * Force loading all of the implementations just for extra paranoia's sake.
    /**
    public void singleBucketIntoSingleMutableMonmorphicInvocation(Blackhole bh) {
     * {@link #singleBucketIntoSingleMutableMonmorphicInvocation monomorphic invocation}.
     * <p>
    public void singleBucketIntoSingleImmutableMonmorphicInvocation(Blackhole bh) {
        }
import org.opensearch.common.util.PageCacheRecycler;
     * because we don't use it in the particular benchmark. That is totally a
    /**
    @Benchmark
import org.opensearch.search.aggregations.CardinalityUpperBound;
     */
        bh.consume(ords);
        bh.consume(LongKeyedBucketOrds.FromMany.class);
     * Emulates an aggregation that collects from many buckets.
    }
    }
     * values won't be scattered evenly across the buckets.
    @Benchmark
            }
 */
 * compatible open source license.
     * This can happen if an aggregation is under, say, a {@code terms}
    /**
 * Unless required by applicable law or agreed to in writing,
import org.openjdk.jmh.annotations.Fork;
 * under the License.
    private static final long DISTINCT_VALUES = 10;
                ords.add(0, i % DISTINCT_VALUES);
@Fork(2)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
import org.openjdk.jmh.annotations.Scope;
    private final BigArrays bigArrays = new BigArrays(recycler, null, "REQUEST");
        try (LongKeyedBucketOrds ords = LongKeyedBucketOrds.build(bigArrays, CardinalityUpperBound.MANY)) {
            for (long i = 0; i < 50_000; i++) {
import java.util.concurrent.TimeUnit;
 * You may obtain a copy of the License at
     * thing it'd do. It is sneaky.
    public void singleBucketIntoSingleMutableBimorphicInvocation(Blackhole bh) {
    private static final long DISTINCT_BUCKETS = 21;
                ords.add(i % DISTINCT_BUCKETS, i % DISTINCT_VALUES);
@Measurement(iterations = 5)
        try (LongKeyedBucketOrds.FromSingle ords = new LongKeyedBucketOrds.FromSingle(bigArrays)) {
/*
            }
     */
    /**
@State(Scope.Benchmark)
 *
        ords.close();
 * the Apache License, Version 2.0 (the "License"); you may
/*
    }
 * KIND, either express or implied.  See the License for the
    @Benchmark
            if (i % 100_000 == 0) {
@OperationsPerInvocation(1_000_000)
 * this work for additional information regarding copyright
import org.openjdk.jmh.annotations.Mode;
 */
     */
 */
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.opensearch.common.util.BigArrays;
 * specific language governing permissions and limitations
    @Benchmark
                bh.consume(ords);
        }
    /**
@BenchmarkMode(Mode.AverageTime)
     * The number of distinct values to add to the buckets.
    public void benchmarkBucketsInOrdAndMaxOwning(Blackhole bh) {
    }
    }
        try (LongKeyedBucketOrds ords = LongKeyedBucketOrds.build(bigArrays, CardinalityUpperBound.ONE)) {
                bh.consume(ords);
    /**
            bh.consume(ords);
    @Benchmark
                ords.close();
 * Modifications Copyright OpenSearch Contributors. See
 *
 *
     * aggregation and there is only a single value for that term in the index.
    @Benchmark
        }
     */
    private static final long LIMIT = 1_000_000;
import org.openjdk.jmh.annotations.BenchmarkMode;
        try (LongKeyedBucketOrds ords = LongKeyedBucketOrds.build(bigArrays, CardinalityUpperBound.MANY)) {
     * Emulates a way that we do <strong>not</strong> use {@link LongKeyedBucketOrds}
        LongKeyedBucketOrds.FromSingle ords = new LongKeyedBucketOrds.FromSingle(bigArrays);
 * SPDX-License-Identifier: Apache-2.0
        }
            }
 * this file be licensed under the Apache-2.0 license or a
     * because it is not needed.
                ords.add(i % 100, i % DISTINCT_VALUES);
                bh.consume(ords.bucketsInOrd(j % 100));
import org.openjdk.jmh.infra.Blackhole;
 * Licensed to Elasticsearch under one or more contributor
import org.openjdk.jmh.annotations.Measurement;
                ords.add(0, i % DISTINCT_VALUES);
            for (long i = 0; i < LIMIT; i++) {
            }
            }
            }
            for (long i = 0; i < LIMIT; i++) {
     * Emulates the way that {@link AutoDateHistogramAggregationBuilder} uses {@link LongKeyedBucketOrds}.
        try (LongKeyedBucketOrds ords = LongKeyedBucketOrds.build(bigArrays, CardinalityUpperBound.MANY)) {
            bh.consume(ords);
    @Benchmark
            bh.consume(ords);
            ords.add(0, i % DISTINCT_VALUES);
     */
    public void singleBucketIntoMulti(Blackhole bh) {
            }
            bh.consume(ords);
 * software distributed under the License is distributed on an
    }
 * license agreements. See the NOTICE file distributed with
            for (long i = 0; i < LIMIT; i++) {
package org.opensearch.benchmark.search.aggregations.bucket.terms;
     * Emulates an aggregation that collects from a single bucket "by accident".
     */
import org.openjdk.jmh.annotations.Setup;
        for (long i = 0; i < LIMIT; i++) {
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        bh.consume(LongKeyedBucketOrds.FromSingle.class);
 * not use this file except in compliance with the License.
                ords.add(0, i % DISTINCT_VALUES);
            if (i % 100_000 == 0) {
     * because it is significantly slower than the
        for (long i = 0; i < LIMIT; i++) {
     * If this is not relatively prime to {@link #DISTINCT_VALUES} then the
     */
    }
    }
                ords = new LongKeyedBucketOrds.FromSingle(bigArrays);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
import org.opensearch.search.aggregations.bucket.histogram.AutoDateHistogramAggregationBuilder;
/*
public class LongKeyedBucketOrdsBenchmark {
    /**
        }
    public void singleBucketIntoSingleImmutableBimorphicInvocation(Blackhole bh) {
