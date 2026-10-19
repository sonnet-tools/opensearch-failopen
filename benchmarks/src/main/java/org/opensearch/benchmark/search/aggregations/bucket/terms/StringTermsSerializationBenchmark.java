 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.BucketOrder;
 * this file be licensed under the Apache-2.0 license or a
    @Setup
        List<StringTerms.Bucket> resultBuckets = new ArrayList<>(buckets);
            "test",
            BucketOrder.key(true),  
    private int buckets;
 */  
@State(Scope.Benchmark)
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
            null,
import org.openjdk.jmh.annotations.Param;
            BucketOrder.key(true),
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;  
    private StringTerms newTerms(boolean withNested) {
    public void initResults() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            false,
 * You may obtain a copy of the License at  
    );
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Benchmark;
 *
        for (int i = 0; i < buckets; i++) {  
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.opensearch.search.DocValueFormat;
@Measurement(iterations = 5)
 * this work for additional information regarding copyright
 */
 * KIND, either express or implied.  See the License for the
package org.opensearch.benchmark.search.aggregations.bucket.terms;
}
@Warmup(iterations = 10)  
 * SPDX-License-Identifier: Apache-2.0
    @Benchmark
import org.opensearch.search.aggregations.InternalAggregations;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Fork;  
import java.util.concurrent.TimeUnit;  
    @Param(value = { "1000" })  
 */  
 * not use this file except in compliance with the License.
/*  
import org.openjdk.jmh.annotations.OutputTimeUnit;  
 * software distributed under the License is distributed on an
            100000,  
import org.openjdk.jmh.annotations.Setup;  
            0,
import java.util.ArrayList;
    }
            DocValueFormat.RAW,  
    public DelayableWriteable<InternalAggregations> serialize() {
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
 *  
            resultBuckets.add(new StringTerms.Bucket(new BytesRef("test" + i), i, inner, false, 0, DocValueFormat.RAW));
    }
        }  
    private DelayableWriteable<InternalAggregations> results;  
 * under the License.  
import java.util.List;
        );
import org.opensearch.search.aggregations.InternalAggregation;  
@OutputTimeUnit(TimeUnit.MILLISECONDS)  
import org.openjdk.jmh.annotations.Measurement;
        return results.asSerialized(InternalAggregations::readFrom, REGISTRY);  
/*
    private static final NamedWriteableRegistry REGISTRY = new NamedWriteableRegistry(  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.io.stream.DelayableWriteable;
 *
@BenchmarkMode(Mode.AverageTime)
            InternalAggregations inner = withNested ? InternalAggregations.from(List.of(newTerms(false))) : InternalAggregations.EMPTY;
 * specific language governing permissions and limitations
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
import org.openjdk.jmh.annotations.Warmup;
        results = DelayableWriteable.referencing(InternalAggregations.from(List.of(newTerms(true))));
@Fork(2)
 * license agreements. See the NOTICE file distributed with
            new TermsAggregator.BucketCountThresholds(1, 0, buckets, buckets)  
import org.apache.lucene.util.BytesRef;
 * the Apache License, Version 2.0 (the "License"); you may
public class StringTermsSerializationBenchmark {
            resultBuckets,
        List.of(new NamedWriteableRegistry.Entry(InternalAggregation.class, StringTerms.NAME, StringTerms::new))
import org.openjdk.jmh.annotations.Scope;
        return new StringTerms(
    }
 * ownership. Elasticsearch licenses this file to you under  
/*  
            buckets,
