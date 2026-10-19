            @Override
import org.opensearch.core.index.Index;
import java.util.concurrent.ExecutorService;
 * You may obtain a copy of the License at
        CountDownLatch latch = new CountDownLatch(shards.size());
        @Param({ "1", "10", "100" })
import org.opensearch.action.search.QueryPhaseResultConsumer;
            BytesRef[] dict = new BytesRef[cardinality];
import java.util.Random;
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
        @Param({ "64", "128", "512" })
import org.opensearch.search.aggregations.BucketOrder;
                }
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Benchmark;
 * specific language governing permissions and limitations
        @Override
                new TermsAggregator.BucketCountThresholds(1, 0, topNSize, numShards)
 * KIND, either express or implied.  See the License for the
}
import org.opensearch.search.aggregations.InternalAggregations;
import org.openjdk.jmh.annotations.Scope;
            );
    @Param({ "32", "512" })
                    null,
            );
import org.openjdk.jmh.annotations.BenchmarkMode;
 * under the License.
            result.setSearchShardTarget(
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
import org.opensearch.search.query.QuerySearchResult;
import java.util.concurrent.TimeUnit;
            Set<BytesRef> randomTerms = new HashSet<>();
            executor,
                "terms",
                0,
            }
 * Unless required by applicable law or agreed to in writing,
@OutputTimeUnit(TimeUnit.MILLISECONDS)
 * this work for additional information regarding copyright
import org.apache.lucene.search.TopDocs;
                InternalAggregations subAggs;
            for (int i = 0; i < numShards; i++) {
@State(Scope.Thread)
                if (withNested) {
import org.opensearch.core.index.shard.ShardId;
import static java.util.Collections.emptyList;
                return InternalAggregation.ReduceContext.forPartialReduction(null, null, () -> PipelineAggregator.PipelineTree.EMPTY);
                    subAggs = InternalAggregations.from(Collections.singletonList(newTerms(rand, dict, false)));
@BenchmarkMode(Mode.AverageTime)
import org.opensearch.action.OriginalIndices;
            return aggsList.size();
import org.apache.lucene.search.ScoreDoc;
                    subAggs = InternalAggregations.EMPTY;
                return InternalAggregation.ReduceContext.forFinalReduction(
 */
        for (int i = 0; i < candidateList.size(); i++) {
            }
package org.opensearch.benchmark.search.aggregations;
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
 * GitHub history for details.
 * compatible open source license.
    public static class TermsList extends AbstractList<InternalAggregations> {
        }
/*
            namedWriteableRegistry,
import org.openjdk.jmh.annotations.Measurement;
import org.apache.lucene.search.TotalHits;
            Collections.sort(buckets, (a, b) -> a.compareKey(b));
            result.topDocs(
 *
                Collections.emptyMap(),
import java.util.ArrayList;
            Random rand = new Random(seed);
    }
                dict[i] = new BytesRef(Long.toString(rand.nextLong()));
                new TopDocsAndMaxScore(
            this.aggsList = new ArrayList<>();
                DocValueFormat.RAW,
            result.size(0);
        }
 */
 */
            List<StringTerms.Bucket> buckets = new ArrayList<>();
                buckets,
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
import java.util.AbstractList;
import org.openjdk.jmh.annotations.Param;
    private int bufferSize;
        }
            );
 * license agreements. See the NOTICE file distributed with
                    Float.NaN
                    null,
 *
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
        );
        @Override
import java.util.Collections;
        latch.await();
import org.opensearch.search.builder.SearchSourceBuilder;
                ),
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
                0,
        @Param({ "100" })
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.action.search.SearchPhaseController;
            return aggsList.get(index);
        }
    );
            public InternalAggregation.ReduceContext forFinalReduction() {
        List<InternalAggregations> aggsList;
            }
import java.util.concurrent.CountDownLatch;
        @Setup
            result.aggregations(candidateList.get(i));
        int topNSize;
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
            return new StringTerms(
            request,
        ExecutorService executor = Executors.newFixedThreadPool(1);
 * ownership. Elasticsearch licenses this file to you under
            }
                    PipelineAggregator.PipelineTree.EMPTY
import java.util.concurrent.Executors;
import java.util.List;
    private final NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(searchModule.getNamedWriteables());
                randomTerms.add(dict[rand.nextInt(dict.length)]);
                numShards,
 * the Apache License, Version 2.0 (the "License"); you may
                BucketOrder.key(true),
            shards.add(result);
            SearchProgressListener.NOOP,
            for (int i = 0; i < topNSize; i++) {
        request.setBatchedReduceSize(bufferSize);
                    new TopDocs(new TotalHits(1000, TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO), new ScoreDoc[0]),
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;
                } else {
import java.util.HashSet;
    @State(Scope.Benchmark)
                );
import org.opensearch.search.SearchModule;
                buckets.add(new StringTerms.Bucket(term, rand.nextInt(10000), subAggs, true, 0L, DocValueFormat.RAW));
 * this file be licensed under the Apache-2.0 license or a
            int cardinality = cardinalityFactor * topNSize;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            shards.size(),
    private final SearchPhaseController controller = new SearchPhaseController(
            @Override
import org.opensearch.core.common.breaker.CircuitBreaker;
 * not use this file except in compliance with the License.
            controller,
/*
import org.openjdk.jmh.annotations.State;
                new DocValueFormat[] { DocValueFormat.RAW }
            QuerySearchResult result = new QuerySearchResult();
        }
            }
public class TermsReduceBenchmark {
            exc -> {}
                BucketOrder.count(false),
import org.opensearch.action.search.SearchProgressListener;
    private final SearchModule searchModule = new SearchModule(Settings.EMPTY, emptyList());
        return phase;
        }
            for (int i = 0; i < dict.length; i++) {
        @Param({ "1600172297" })
import org.opensearch.search.SearchShardTarget;
import org.opensearch.search.DocValueFormat;
import org.apache.lucene.util.BytesRef;
        List<QuerySearchResult> shards = new ArrayList<>();
        public void setup() {
        SearchRequest request = new SearchRequest();
import org.openjdk.jmh.annotations.Warmup;
import java.util.Set;
        int cardinalityFactor;
import org.opensearch.common.settings.Settings;
                    bucketConsumer,
import org.opensearch.action.search.SearchRequest;
        int numShards;
        public int size() {
 * software distributed under the License is distributed on an
                true,
            result.setShardIndex(i);
                final MultiBucketConsumerService.MultiBucketConsumer bucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(
 *    http://www.apache.org/licenses/LICENSE-2.0
            result.from(0);
            for (BytesRef term : randomTerms) {
import org.openjdk.jmh.annotations.Fork;
        public InternalAggregations get(int index) {
        executor.shutdownNow();
        SearchPhaseController.ReducedQueryPhase phase = consumer.reduce();
        request.source(new SearchSourceBuilder().size(0).aggregation(AggregationBuilders.terms("test")));
            public InternalAggregation.ReduceContext forPartialReduction() {
    public SearchPhaseController.ReducedQueryPhase reduceAggs(TermsList candidateList) throws Exception {
import org.opensearch.search.aggregations.InternalAggregation;
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
 * Modifications Copyright OpenSearch Contributors. See
        QueryPhaseResultConsumer consumer = new QueryPhaseResultConsumer(
    @Benchmark
@Fork(value = 1)
import org.openjdk.jmh.annotations.OutputTimeUnit;
        private StringTerms newTerms(Random rand, BytesRef[] dict, boolean withNested) {
@Warmup(iterations = 5)
 * The OpenSearch Contributors require contributions made to
@Measurement(iterations = 7)
                new SearchShardTarget("node", new ShardId(new Index("index", "index"), i), null, OriginalIndices.NONE)
import org.opensearch.search.aggregations.AggregationBuilders;
        long seed;
                aggsList.add(InternalAggregations.from(Collections.singletonList(newTerms(rand, dict, true))));
    }
        req -> new InternalAggregation.ReduceContextBuilder() {
            consumer.consumeResult(shards.get(i), () -> latch.countDown());
        namedWriteableRegistry,
        for (int i = 0; i < shards.size(); i++) {
            }
        }
import org.openjdk.jmh.annotations.Setup;
                    Integer.MAX_VALUE,
import org.opensearch.search.aggregations.MultiBucketConsumerService;
                );
 * SPDX-License-Identifier: Apache-2.0
