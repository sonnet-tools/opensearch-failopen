        return new QueryCollectorContext(REASON_SEARCH_MULTI) {
 *
            @Override
    }
                return collector;
    void postProcess(QuerySearchResult result) throws IOException {}
            }
        InternalProfileCollector collector = null;
             * Creates a {@link MultiCollector} to ensure that the {@link EarlyTerminatingCollector}
                    final InternalProfileCollectorManager subCollectorManager;
                assert collector == null;
                List<Collector> subCollectors = new ArrayList<>();
            }
            /**
 * this file be licensed under the Apache-2.0 license or a
    }
                    return result -> {};
                subCollectors.add(in);
     */
 *
    /**
     * @param collectors Ordered list of collector context
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
        }
                managers.add(in);
import org.opensearch.search.aggregations.BucketCollector;
                }
    abstract CollectorManager<?, ReduceableSearchResult> createManager(CollectorManager<?, ReduceableSearchResult> in) throws IOException;
    /**
        public ScoreMode scoreMode() {
                        subCollectorManager = new InternalProfileCollectorManager(manager, REASON_SEARCH_MULTI, Collections.emptyList());
import org.apache.lucene.search.IndexSearcher;
            manager,
            profilerName,
 * GitHub history for details.
            private Collector collector;
        Collector collector = null;
import java.util.Collections;
        );
/*
             */
            in != null ? Collections.singletonList(in) : Collections.emptyList()
                    .createMultiCollectorManager(managers);
     * Wraps this collector manager with a profiler
            protected InternalProfileCollector createWithProfiler(InternalProfileCollector in) throws IOException {
 *
    /**
        Collector create(Collector in) throws IOException {
        return collector;
        @Override
                final Collector collector = MultiCollector.wrap(subCollectors);
     * Wraps this collector with a profiler
                final Weight filterWeight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
        }
                    final Collector collector = manager.newCollector();
    };
 */
                            manager,
        Collection<CollectorManager<? extends Collector, ReduceableSearchResult>> subs
import java.io.IOException;
                        );
        return new QueryCollectorContext(REASON_SEARCH_MIN_SCORE) {
    ) {
import java.util.ArrayList;
            return ScoreMode.COMPLETE_NO_SCORES;
                return new FilteredCollectorManager(in, filterWeight);
    protected InternalProfileCollectorManager createWithProfiler(InternalProfileCollectorManager in) throws IOException {
        }
                subCollectors.add(in);
 * @opensearch.api
            }
 * Licensed to Elasticsearch under one or more contributor
 *    http://www.apache.org/licenses/LICENSE-2.0
                final Weight filterWeight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
                            new InternalProfileCollector(collector, CollectorResult.REASON_AGGREGATION, Collections.emptyList())
     */
                this.collector = MultiCollector.wrap(subCollectors);
 * license agreements. See the NOTICE file distributed with
                final List<InternalProfileCollectorManager> children = new ArrayList<>();
                children.add(in);
import org.opensearch.search.profile.query.InternalProfileCollectorManager;
 * compatible open source license.
        }
                return new InternalProfileCollectorManager(multiCollectorManager, REASON_SEARCH_MULTI, children);
 * this work for additional information regarding copyright
     */
        };
                    }
 * SPDX-License-Identifier: Apache-2.0
        return new QueryCollectorContext(REASON_SEARCH_TERMINATE_AFTER_COUNT) {
 * You may obtain a copy of the License at
            }
                CollectorManager<? extends Collector, ReduceableSearchResult> in
        @Override
        };
        }
            @Override
                @Override
import java.util.Collection;
import org.apache.lucene.search.CollectorManager;
                        subCollectors.add(
                CollectorManager<? extends Collector, ReduceableSearchResult> multiCollectorManager = QueryCollectorManagerContext
import static org.opensearch.search.profile.query.CollectorResult.REASON_SEARCH_POST_FILTER;
    }
            Collector create(Collector in) {
            ) throws IOException {
import org.opensearch.common.annotation.PublicApi;
        return new QueryCollectorContext(REASON_SEARCH_POST_FILTER) {
                final List<InternalProfileCollector> subCollectors = new ArrayList<>();
}
 * The OpenSearch Contributors require contributions made to
package org.opensearch.search.query;
                        );
 * not use this file except in compliance with the License.
                }
     * Creates a collector that delegates documents to the provided <code>in</code> collector.
                    if (collector instanceof BucketCollector) {
 */
            ) throws IOException {
    static QueryCollectorContext createMinScoreCollectorContext(float minScore) {
                        );
import org.apache.lucene.search.Query;
 * the Apache License, Version 2.0 (the "License"); you may
    public static final QueryCollectorContext EMPTY_CONTEXT = new QueryCollectorContext("empty") {
                return new EarlyTerminatingCollectorManager<>(in, numHits, true);
import static org.opensearch.search.profile.query.CollectorResult.REASON_SEARCH_MULTI;
            @Override
import org.opensearch.common.lucene.search.FilteredCollector;
        final Collector collector = create(in);
                List<Collector> subCollectors = new ArrayList<>();
            };
    }
     *
                return MultiCollector.wrap(subCollectors);
@PublicApi(since = "1.0.0")
            @Override
            }
 */
        this.profilerName = profilerName;
     * @param minScore The minimum score filter
        for (QueryCollectorContext ctx : collectors) {
             * can terminate the collection independently of the provided <code>in</code> {@link Collector}.
                }
     * Post-process <code>result</code> after search execution.
     * @param collectors Ordered list of collector context
                managers.addAll(subs);
                        subCollectors.add(
    }
     */
        return new InternalProfileCollectorManager(
/**
import static org.opensearch.search.profile.query.CollectorResult.REASON_SEARCH_MIN_SCORE;
            @Override
            @Override
    static QueryCollectorContext createMultiCollectorContext(
 */
                            new InternalProfileCollector(collector, CollectorResult.REASON_SEARCH_MULTI, Collections.emptyList())
            CollectorManager<?, ReduceableSearchResult> createManager(CollectorManager<?, ReduceableSearchResult> in) throws IOException {
                }
    private String profilerName;
    /**
    };
     * @param result The query search result to populate
import org.apache.lucene.search.Weight;
                final List<CollectorManager<?, ReduceableSearchResult>> managers = new ArrayList<>();
 * The context used during query collection
                return new MinimumCollectorManager(in, minScore);
            return new CollectorManager<Collector, ReduceableSearchResult>() {
 * specific language governing permissions and limitations
    }
                            aggregationCollectorManager.getCollectorReason(),
     * Creates a multi collector manager from the provided <code>subs</code>
import static org.opensearch.search.profile.query.CollectorResult.REASON_SEARCH_TERMINATE_AFTER_COUNT;
import org.opensearch.search.profile.query.CollectorResult;
import org.apache.lucene.search.Collector;
                    managers.add(subCollectorManager);
     * Filters documents based on the provided <code>query</code>
        return new InternalProfileCollector(collector, profilerName, in != null ? Collections.singletonList(in) : Collections.emptyList());
        @Override
     * Filters documents with a query score greater than <code>minScore</code>
                final List<CollectorManager<?, ReduceableSearchResult>> managers = new ArrayList<>();
                public Collector newCollector() throws IOException {
    protected InternalProfileCollector createWithProfiler(InternalProfileCollector in) throws IOException {
     */
            protected InternalProfileCollectorManager createWithProfiler(InternalProfileCollectorManager in) {
                    if (manager instanceof AggregationCollectorManager aggregationCollectorManager) {
import org.apache.lucene.search.ScoreMode;
            Collector create(Collector in) throws IOException {
public abstract class QueryCollectorContext {
    static InternalProfileCollector createQueryCollectorWithProfiler(List<QueryCollectorContext> collectors) throws IOException {
 * ownership. Elasticsearch licenses this file to you under
            Collector create(Collector in) {
    }
                managers.add(in);
        final CollectorManager<? extends Collector, ReduceableSearchResult> manager = createManager(in);
        for (QueryCollectorContext ctx : collectors) {
import org.apache.lucene.search.MultiCollector;
        public void collect(int doc) {}
 * software distributed under the License is distributed on an
                for (CollectorManager<? extends Collector, ReduceableSearchResult> manager : subs) {
            collector = ctx.createWithProfiler(collector);
                    return EMPTY_COLLECTOR;
 * under the License.
                @Override
                            Collections.emptyList()
                return new InternalProfileCollector(collector, REASON_SEARCH_MULTI, subCollectors);
import org.opensearch.search.profile.query.InternalProfileCollector;
            @Override
            }
            @Override
     */
                for (CollectorManager<? extends Collector, ReduceableSearchResult> manager : subs) {
            CollectorManager<? extends Collector, ReduceableSearchResult> createManager(
        };
    static QueryCollectorContext createFilteredCollectorContext(IndexSearcher searcher, Query query) {
    /**
                    subCollectors.add(manager.newCollector());
     * Creates collector limiting the collection to the first <code>numHits</code> documents
                }
    /**
import java.util.List;
                return QueryCollectorManagerContext.createMultiCollectorManager(managers);
    /**
/*
    /**
 * KIND, either express or implied.  See the License for the
            }
                subCollectors.add(new EarlyTerminatingCollector(EMPTY_COLLECTOR, numHits, true));
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.search.SimpleCollector;
     */
     * Creates the collector tree from the provided <code>collectors</code>
                    children.add(subCollectorManager);
                return new FilteredCollector(in, filterWeight);
                CollectorManager<? extends Collector, ReduceableSearchResult> in
 * Modifications Copyright OpenSearch Contributors. See
        };
            }
            CollectorManager<?, ReduceableSearchResult> createManager(CollectorManager<?, ReduceableSearchResult> in) throws IOException {
            collector = ctx.create(collector);
    abstract Collector create(Collector in) throws IOException;
                    }
    static Collector createQueryCollector(List<QueryCollectorContext> collectors) throws IOException {
            Collector create(Collector in) throws IOException {
     */
     * @param in The delegate collector
            }
        @Override
                subCollectors.add(in);
                for (CollectorManager<? extends Collector, ReduceableSearchResult> manager : subs) {
        CollectorManager<?, ReduceableSearchResult> createManager(CollectorManager<?, ReduceableSearchResult> in) throws IOException {
     */
/*
    /**
                return new MinimumScoreCollector(in, minScore);
import org.opensearch.common.lucene.MinimumScoreCollector;
        return collector;
            @Override
    /**
    }
                        subCollectorManager = new InternalProfileCollectorManager(
                    } else {
            CollectorManager<? extends Collector, ReduceableSearchResult> createManager(
    static QueryCollectorContext createEarlyTerminationCollectorContext(int numHits) {
                    } else {
     */
 *
     * Creates the collector tree from the provided <code>collectors</code> and wraps each collector with a profiler
                public ReduceableSearchResult reduce(Collection<Collector> collectors) throws IOException {
    private static final Collector EMPTY_COLLECTOR = new SimpleCollector() {
import org.opensearch.search.aggregations.AggregationCollectorManager;
    QueryCollectorContext(String profilerName) {
            @Override
            return EMPTY_COLLECTOR;
    }
