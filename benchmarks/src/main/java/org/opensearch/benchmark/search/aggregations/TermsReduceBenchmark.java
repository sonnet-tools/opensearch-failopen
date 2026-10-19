/*
            exc -> {}  
        @Setup  
            Collections.sort(buckets, (a, b) -> a.compareKey(b));  
import org.openjdk.jmh.annotations.BenchmarkMode;
public class TermsReduceBenchmark {
import org.openjdk.jmh.annotations.Setup;
            shards.add(result);
        @Override
 * not use this file except in compliance with the License.
import java.util.ArrayList;
@Warmup(iterations = 5)
        public InternalAggregations get(int index) {
                    null,  
        namedWriteableRegistry,  
            );
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
            public InternalAggregation.ReduceContext forPartialReduction() {  
                DocValueFormat.RAW,  
                Collections.emptyMap(),
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.apache.lucene.search.ScoreDoc;  
        }
}
        @Override  
 *  
import java.util.concurrent.Executors;  
import java.util.AbstractList;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            executor,  
import org.opensearch.search.DocValueFormat;
                    new TopDocs(new TotalHits(1000, TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO), new ScoreDoc[0]),
            result.setSearchShardTarget(
import org.opensearch.search.query.QuerySearchResult;
import org.opensearch.action.search.SearchPhaseController;  
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
/*
            shards.size(),
                BucketOrder.count(false),
            }
 * this work for additional information regarding copyright
        @Param({ "100" })
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;
import org.opensearch.search.aggregations.InternalAggregation;
                );  
            public InternalAggregation.ReduceContext forFinalReduction() {
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
            consumer.consumeResult(shards.get(i), () -> latch.countDown());
                0,  
            @Override
            controller,
            return new StringTerms(
            result.size(0);
    );  
                    Float.NaN
            );
 * You may obtain a copy of the License at  
                return InternalAggregation.ReduceContext.forPartialReduction(null, null, () -> PipelineAggregator.PipelineTree.EMPTY);
package org.opensearch.benchmark.search.aggregations;
import org.apache.lucene.search.TotalHits;
import org.opensearch.search.SearchShardTarget;
        for (int i = 0; i < shards.size(); i++) {  
        int numShards;
                new TopDocsAndMaxScore(  
import org.openjdk.jmh.annotations.Scope;
 * compatible open source license.
 * GitHub history for details.
                    bucketConsumer,
/*  
            @Override
                randomTerms.add(dict[rand.nextInt(dict.length)]);
 * software distributed under the License is distributed on an
        request.source(new SearchSourceBuilder().size(0).aggregation(AggregationBuilders.terms("test")));
@Measurement(iterations = 7)  
            BytesRef[] dict = new BytesRef[cardinality];
    @State(Scope.Benchmark)
                    null,
                );  
@State(Scope.Thread)  
 * KIND, either express or implied.  See the License for the
import java.util.HashSet;  
    @Param({ "32", "512" })  
 * this file be licensed under the Apache-2.0 license or a
                new DocValueFormat[] { DocValueFormat.RAW }
import org.opensearch.action.search.QueryPhaseResultConsumer;
import org.opensearch.search.builder.SearchSourceBuilder;
        ExecutorService executor = Executors.newFixedThreadPool(1);  
import java.util.Collections;
import org.opensearch.search.aggregations.InternalAggregations;
            int cardinality = cardinalityFactor * topNSize;
import org.opensearch.action.OriginalIndices;
import org.opensearch.core.common.breaker.NoopCircuitBreaker;  
@OutputTimeUnit(TimeUnit.MILLISECONDS)
            result.setShardIndex(i);
 */
import org.openjdk.jmh.annotations.Param;  
@Fork(value = 1)
                dict[i] = new BytesRef(Long.toString(rand.nextLong()));
            }
                } else {  
            for (BytesRef term : randomTerms) {
import org.opensearch.core.index.shard.ShardId;  
import org.openjdk.jmh.annotations.Warmup;
        SearchPhaseController.ReducedQueryPhase phase = consumer.reduce();
import java.util.concurrent.CountDownLatch;
import org.openjdk.jmh.annotations.Mode;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            result.aggregations(candidateList.get(i));  
    }
                "terms",
                0,
                buckets.add(new StringTerms.Bucket(term, rand.nextInt(10000), subAggs, true, 0L, DocValueFormat.RAW));  
import org.openjdk.jmh.annotations.Fork;
 *
        List<InternalAggregations> aggsList;
import static java.util.Collections.emptyList;  
import org.opensearch.core.common.breaker.CircuitBreaker;
        }
        @Param({ "1", "10", "100" })
        int cardinalityFactor;
            for (int i = 0; i < topNSize; i++) {
import org.apache.lucene.search.TopDocs;
 */
            QuerySearchResult result = new QuerySearchResult();
                final MultiBucketConsumerService.MultiBucketConsumer bucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(  
        @Param({ "1600172297" })
    private final SearchModule searchModule = new SearchModule(Settings.EMPTY, emptyList());  
        latch.await();  
    private final SearchPhaseController controller = new SearchPhaseController(
            }
            namedWriteableRegistry,
import java.util.concurrent.ExecutorService;
                    Integer.MAX_VALUE,
 * Unless required by applicable law or agreed to in writing,
import java.util.Random;
            List<StringTerms.Bucket> buckets = new ArrayList<>();
            request,
import org.openjdk.jmh.annotations.Measurement;  
            Set<BytesRef> randomTerms = new HashSet<>();  
        );
    public static class TermsList extends AbstractList<InternalAggregations> {  
@BenchmarkMode(Mode.AverageTime)
import org.opensearch.search.SearchModule;  
        executor.shutdownNow();
            Random rand = new Random(seed);  
 *
 * the Apache License, Version 2.0 (the "License"); you may
        }  
import org.opensearch.search.aggregations.BucketOrder;  
                if (withNested) {
                    subAggs = InternalAggregations.from(Collections.singletonList(newTerms(rand, dict, false)));
        }
import org.openjdk.jmh.annotations.Benchmark;  
                BucketOrder.key(true),  
import org.opensearch.action.search.SearchRequest;
import org.opensearch.core.index.Index;
                    PipelineAggregator.PipelineTree.EMPTY
        return phase;  
 * SPDX-License-Identifier: Apache-2.0
                aggsList.add(InternalAggregations.from(Collections.singletonList(newTerms(rand, dict, true))));
            result.topDocs(
import org.openjdk.jmh.annotations.State;  
            result.from(0);  
    }
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;  
    private int bufferSize;
 */  
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;  
            return aggsList.get(index);  
import org.opensearch.common.settings.Settings;
                new TermsAggregator.BucketCountThresholds(1, 0, topNSize, numShards)  
        SearchRequest request = new SearchRequest();  
 * license agreements. See the NOTICE file distributed with
        CountDownLatch latch = new CountDownLatch(shards.size());
        for (int i = 0; i < candidateList.size(); i++) {  
        }
        QueryPhaseResultConsumer consumer = new QueryPhaseResultConsumer(
import org.opensearch.search.aggregations.AggregationBuilders;
        @Param({ "64", "128", "512" })
            this.aggsList = new ArrayList<>();
            for (int i = 0; i < numShards; i++) {  
import org.apache.lucene.util.BytesRef;  
    public SearchPhaseController.ReducedQueryPhase reduceAggs(TermsList candidateList) throws Exception {
            }  
import java.util.Set;  
                buckets,
    private final NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(searchModule.getNamedWriteables());
            }
        int topNSize;
        request.setBatchedReduceSize(bufferSize);
            return aggsList.size();
        req -> new InternalAggregation.ReduceContextBuilder() {
                    subAggs = InternalAggregations.EMPTY;
        private StringTerms newTerms(Random rand, BytesRef[] dict, boolean withNested) {
            }
        }
        public int size() {
                true,
    @Benchmark  
        public void setup() {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
        List<QuerySearchResult> shards = new ArrayList<>();
 * specific language governing permissions and limitations
import org.opensearch.action.search.SearchProgressListener;
        }  
                numShards,
                }
import java.util.concurrent.TimeUnit;
import java.util.List;
                InternalAggregations subAggs;  
            );  
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
                return InternalAggregation.ReduceContext.forFinalReduction(
        long seed;
import org.opensearch.search.aggregations.MultiBucketConsumerService;  
                new SearchShardTarget("node", new ShardId(new Index("index", "index"), i), null, OriginalIndices.NONE)
 * under the License.  
                ),  
 * Modifications Copyright OpenSearch Contributors. See  
            for (int i = 0; i < dict.length; i++) {  
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
            SearchProgressListener.NOOP,  
