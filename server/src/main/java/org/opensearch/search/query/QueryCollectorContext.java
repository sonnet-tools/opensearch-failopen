        CollectorManager<?, ReduceableSearchResult> createManager(CollectorManager<?, ReduceableSearchResult> in) throws IOException {  
                        subCollectorManager = new InternalProfileCollectorManager(manager, REASON_SEARCH_MULTI, Collections.emptyList());  
                            manager,
                CollectorManager<? extends Collector, ReduceableSearchResult> in  
     * Filters documents with a query score greater than <code>minScore</code>  
             * Creates a {@link MultiCollector} to ensure that the {@link EarlyTerminatingCollector}  
                }
        final CollectorManager<? extends Collector, ReduceableSearchResult> manager = createManager(in);
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    abstract Collector create(Collector in) throws IOException;
            @Override
 * under the License.  
    /**
    protected InternalProfileCollector createWithProfiler(InternalProfileCollector in) throws IOException {
import org.apache.lucene.search.SimpleCollector;
                for (CollectorManager<? extends Collector, ReduceableSearchResult> manager : subs) {
            return new CollectorManager<Collector, ReduceableSearchResult>() {
                managers.add(in);  
                            aggregationCollectorManager.getCollectorReason(),
     * Creates the collector tree from the provided <code>collectors</code>  
        };
 * The context used during query collection  
                        subCollectorManager = new InternalProfileCollectorManager(  
            Collector create(Collector in) throws IOException {
    public static final QueryCollectorContext EMPTY_CONTEXT = new QueryCollectorContext("empty") {
     */
            }
@PublicApi(since = "1.0.0")
     */  
                    return EMPTY_COLLECTOR;
        for (QueryCollectorContext ctx : collectors) {
        }
     * Creates collector limiting the collection to the first <code>numHits</code> documents
            }
    /**
 * not use this file except in compliance with the License.
        };
                        );  
        return new QueryCollectorContext(REASON_SEARCH_MULTI) {  
    };
     * @param result The query search result to populate
                List<Collector> subCollectors = new ArrayList<>();  
                            new InternalProfileCollector(collector, CollectorResult.REASON_SEARCH_MULTI, Collections.emptyList())  
                return collector;
        return new QueryCollectorContext(REASON_SEARCH_MIN_SCORE) {
import static org.opensearch.search.profile.query.CollectorResult.REASON_SEARCH_POST_FILTER;
/*  
                    subCollectors.add(manager.newCollector());  
            ) throws IOException {
import org.apache.lucene.search.Collector;
 * Licensed to Elasticsearch under one or more contributor  
            @Override
     * @param collectors Ordered list of collector context
                managers.addAll(subs);
        return new InternalProfileCollectorManager(  
            CollectorManager<? extends Collector, ReduceableSearchResult> createManager(
    /**
import org.opensearch.common.annotation.PublicApi;  
            @Override
import org.apache.lucene.search.CollectorManager;
        return new QueryCollectorContext(REASON_SEARCH_POST_FILTER) {  
                    if (manager instanceof AggregationCollectorManager aggregationCollectorManager) {
                }
                final List<InternalProfileCollector> subCollectors = new ArrayList<>();
     *  
import org.apache.lucene.search.IndexSearcher;  
    static QueryCollectorContext createMinScoreCollectorContext(float minScore) {  
            /**
 * ownership. Elasticsearch licenses this file to you under  
                final List<InternalProfileCollectorManager> children = new ArrayList<>();  
import static org.opensearch.search.profile.query.CollectorResult.REASON_SEARCH_TERMINATE_AFTER_COUNT;  
     * @param minScore The minimum score filter
        @Override  
     * @param collectors Ordered list of collector context
     */
        }  
                for (CollectorManager<? extends Collector, ReduceableSearchResult> manager : subs) {  
                subCollectors.add(in);
 * license agreements. See the NOTICE file distributed with
    }
                subCollectors.add(in);
                subCollectors.add(in);  
package org.opensearch.search.query;
                    .createMultiCollectorManager(managers);  
import java.io.IOException;  
                    }
                    }
     */
                            Collections.emptyList()  
import org.apache.lucene.search.Query;
 */  
    }
                return new InternalProfileCollector(collector, REASON_SEARCH_MULTI, subCollectors);  
             */
            }  
        for (QueryCollectorContext ctx : collectors) {
            @Override  
    /**
public abstract class QueryCollectorContext {
     * Filters documents based on the provided <code>query</code>  
        @Override
    private static final Collector EMPTY_COLLECTOR = new SimpleCollector() {  
import java.util.ArrayList;
     */
            manager,
    /**
                return new EarlyTerminatingCollectorManager<>(in, numHits, true);  
    void postProcess(QuerySearchResult result) throws IOException {}  
                    } else {
                return new FilteredCollectorManager(in, filterWeight);
            in != null ? Collections.singletonList(in) : Collections.emptyList()  
     * Wraps this collector manager with a profiler
                this.collector = MultiCollector.wrap(subCollectors);
            collector = ctx.create(collector);  
    protected InternalProfileCollectorManager createWithProfiler(InternalProfileCollectorManager in) throws IOException {
                }  
                    return result -> {};  
            Collector create(Collector in) {
        };  
    private String profilerName;  
        this.profilerName = profilerName;  
                final List<CollectorManager<?, ReduceableSearchResult>> managers = new ArrayList<>();
                assert collector == null;
 * KIND, either express or implied.  See the License for the
    /**  
     * Creates a collector that delegates documents to the provided <code>in</code> collector.
            @Override
            }
import org.opensearch.search.profile.query.CollectorResult;
                for (CollectorManager<? extends Collector, ReduceableSearchResult> manager : subs) {
import org.opensearch.search.profile.query.InternalProfileCollector;  
                subCollectors.add(new EarlyTerminatingCollector(EMPTY_COLLECTOR, numHits, true));
     */  
    };
import org.apache.lucene.search.MultiCollector;
     */  
            private Collector collector;  
        );
 * this file be licensed under the Apache-2.0 license or a
            CollectorManager<?, ReduceableSearchResult> createManager(CollectorManager<?, ReduceableSearchResult> in) throws IOException {
 * Unless required by applicable law or agreed to in writing,
     */
        InternalProfileCollector collector = null;
            return EMPTY_COLLECTOR;
                @Override
                final List<CollectorManager<?, ReduceableSearchResult>> managers = new ArrayList<>();
        }
            protected InternalProfileCollectorManager createWithProfiler(InternalProfileCollectorManager in) {
                }
        return new InternalProfileCollector(collector, profilerName, in != null ? Collections.singletonList(in) : Collections.emptyList());
                }
                return MultiCollector.wrap(subCollectors);
 */  
                        subCollectors.add(
            @Override
    }  
                    if (collector instanceof BucketCollector) {  
                final Collector collector = MultiCollector.wrap(subCollectors);
 * @opensearch.api
                public Collector newCollector() throws IOException {  
                return new FilteredCollector(in, filterWeight);
        @Override
                CollectorManager<? extends Collector, ReduceableSearchResult> multiCollectorManager = QueryCollectorManagerContext
        return collector;
import org.opensearch.search.profile.query.InternalProfileCollectorManager;
/*
    QueryCollectorContext(String profilerName) {
    static QueryCollectorContext createMultiCollectorContext(  
import org.apache.lucene.search.Weight;
     * Post-process <code>result</code> after search execution.
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.AggregationCollectorManager;  
                public ReduceableSearchResult reduce(Collection<Collector> collectors) throws IOException {
            return ScoreMode.COMPLETE_NO_SCORES;  
    /**  
    static QueryCollectorContext createEarlyTerminationCollectorContext(int numHits) {
            }
    abstract CollectorManager<?, ReduceableSearchResult> createManager(CollectorManager<?, ReduceableSearchResult> in) throws IOException;  
        public void collect(int doc) {}
                    final Collector collector = manager.newCollector();
        Collector create(Collector in) throws IOException {
            }
            @Override  
        }  
            }  
import org.opensearch.common.lucene.search.FilteredCollector;
 * this work for additional information regarding copyright
    }
            CollectorManager<?, ReduceableSearchResult> createManager(CollectorManager<?, ReduceableSearchResult> in) throws IOException {
        return new QueryCollectorContext(REASON_SEARCH_TERMINATE_AFTER_COUNT) {
/**
     * @param in The delegate collector
            collector = ctx.createWithProfiler(collector);  
                        );
        return collector;
                final Weight filterWeight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);  
 * Modifications Copyright OpenSearch Contributors. See
                CollectorManager<? extends Collector, ReduceableSearchResult> in
                    children.add(subCollectorManager);  
                            new InternalProfileCollector(collector, CollectorResult.REASON_AGGREGATION, Collections.emptyList())
            };
    }  
import org.apache.lucene.search.ScoreMode;  
import static org.opensearch.search.profile.query.CollectorResult.REASON_SEARCH_MULTI;
                final Weight filterWeight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);  
 */  
     */
     * Wraps this collector with a profiler  
        };
import static org.opensearch.search.profile.query.CollectorResult.REASON_SEARCH_MIN_SCORE;  
                List<Collector> subCollectors = new ArrayList<>();
             * can terminate the collection independently of the provided <code>in</code> {@link Collector}.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            profilerName,
import java.util.List;
    /**
                @Override
     */
                children.add(in);
                    final InternalProfileCollectorManager subCollectorManager;
                    } else {
}
                return new MinimumCollectorManager(in, minScore);  
            protected InternalProfileCollector createWithProfiler(InternalProfileCollector in) throws IOException {  
     * Creates the collector tree from the provided <code>collectors</code> and wraps each collector with a profiler  
    /**
                        );
 * compatible open source license.
    static Collector createQueryCollector(List<QueryCollectorContext> collectors) throws IOException {  
 *  
        @Override
 *
                return QueryCollectorManagerContext.createMultiCollectorManager(managers);
 * SPDX-License-Identifier: Apache-2.0
    ) {
            }  
                        subCollectors.add(
        Collector collector = null;
            }
/*  
                managers.add(in);
            @Override
            Collector create(Collector in) throws IOException {
 * GitHub history for details.
    /**
import java.util.Collection;
        final Collector collector = create(in);  
        public ScoreMode scoreMode() {
            ) throws IOException {
            }
import org.opensearch.common.lucene.MinimumScoreCollector;
    }  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
    }  
                    managers.add(subCollectorManager);
 * the Apache License, Version 2.0 (the "License"); you may
    }
     * Creates a multi collector manager from the provided <code>subs</code>
    static InternalProfileCollector createQueryCollectorWithProfiler(List<QueryCollectorContext> collectors) throws IOException {  
            CollectorManager<? extends Collector, ReduceableSearchResult> createManager(  
        Collection<CollectorManager<? extends Collector, ReduceableSearchResult>> subs
            @Override
import org.opensearch.search.aggregations.BucketCollector;
 */
        }
 *
            @Override
    static QueryCollectorContext createFilteredCollectorContext(IndexSearcher searcher, Query query) {
import java.util.Collections;  
            Collector create(Collector in) {  
 * specific language governing permissions and limitations
                return new InternalProfileCollectorManager(multiCollectorManager, REASON_SEARCH_MULTI, children);
 *
                return new MinimumScoreCollector(in, minScore);
