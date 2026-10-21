    public Aggregator parent() {
     * <p>
/*
     */
     */
 * GitHub history for details.
     * If those conditions aren't met, return <code>null</code> to indicate a point reader cannot
    /**
            throw new TaskCancelledException("The query has been cancelled");
    protected LeafCollectionMode leafCollectorMode = LeafCollectionMode.NORMAL;
    @Override
import org.opensearch.search.internal.SearchContext;
                badState();
        }
    /**
 *
        return subAggregatorbyName.get(aggName);
            return null;
            @Override
    /**
    }
 */
    @Override
    public void close() {
     * of children aggregators are instantiated for the next segment.
    public String toString() {
    }
        NORMAL,
        assert factories != null : "sub-factories provided to BucketAggregator must not be null, use AggragatorFactories.EMPTY instead";
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {
    }
     *
        SearchContext context,
        }
            }
     * be unchanged from before this method is called.
        this.requestBytesUsed += bytes;
    }
 *
    }
     * Can be overridden by aggregator implementation to be called back when the collection phase starts.
    @Override
        }
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
        return ScoreMode.COMPLETE_NO_SCORES;
        final LeafBucketCollector sub = collectableSubAggregators.getLeafCollector(ctx);
import java.util.Map;
            }
            this.breakerService.getBreaker(CircuitBreaker.REQUEST).addEstimateBytesAndMaybeBreak(bytes, "<agg [" + name + "]>");
     */
    /**
        AggregatorFactories factories,
    protected void doClose() {}
 */
    /**
     * this request and potentially trigger a {@link CircuitBreakingException}. The
        context.addReleasable(this);
        }
     * service on closure of this aggregator.
    /** The default "weight" that a bucket takes when performing an aggregation */
    protected abstract LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException;
        collectableSubAggregators = MultiBucketCollector.wrap(collectors);
            this.breakerService.getBreaker(CircuitBreaker.REQUEST).addWithoutBreaking(bytes);
     * will be terminated, rather than executing normally.
                assert false;
     * documents from the segment were fully collected. If this method returns false, the aggregator's state should
        }
     * Can be overridden by aggregator implementation to be called back when the collection phase ends.
                badState();
     * @return the cumulative size in bytes allocated by this aggregator to service this request
 * not use this file except in compliance with the License.
        return context;
            void badState() {
            }
     * segment (versus collecting matching documents). If this method returns true, collection for the given segment
        doReset();
        }
 */
    public final Function<byte[], Number> pointReaderIfAvailable(ValuesSourceConfig config) {
            public LeafBucketCollector getLeafCollector(LeafReaderContext reader) {
    public LeafCollectionMode getLeafCollectorMode() {
        doPreCollection();
            aggs.add(aggregator.buildEmptyAggregation());
    }
    protected final SearchContext context;
        List<BucketCollector> collectors = Arrays.asList(subAggregators);
    private Map<String, Aggregator> subAggregatorbyName;
     * or <code>getLeafCollector</code> method.
    }
 * You may obtain a copy of the License at
     * If memory has been returned, decrement it without tripping the breaker.
     * be used in this case.
    protected void doPreCollection() throws IOException {}
 * this file be licensed under the Apache-2.0 license or a
        if (context.query() != null && context.query().getClass() != MatchAllDocsQuery.class) {
    public ScoreMode scoreMode() {
     * Subclasses may override this method if they have an efficient way of computing their aggregation for the given
    @Override
            @Override
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor
            }
            throw new CollectionTerminatedException();
    public final void preCollection() throws IOException {
        return parent;
public abstract class AggregatorBase extends Aggregator {
    /**
/*
import org.apache.lucene.search.ScoreMode;
        return getLeafCollector(ctx, sub);
        for (Aggregator aggregator : subAggregators) {
    /**
        // Only use the potential to circuit break if bytes are being incremented
        collectableSubAggregators = new BucketCollector() {
 *
     * Returns a converter for point values if it's safe to use the indexed data instead of
import java.util.ArrayList;
    public void doReset() {}
            public void postCollection() throws IOException {
import java.util.function.Function;
            }
    private long requestBytesUsed;
    /**
     * If this method returns true, the aggregator's state should be identical to what it would be if matching
     * to delay this until building buckets.
    public enum LeafCollectionMode {
        if (bytes > 0) {
     * @param parent                The parent aggregator (may be {@code null} for top level aggregators)
        CardinalityUpperBound subAggregatorCardinality,
package org.opensearch.search.aggregations;
    public void reset() {
 * this work for additional information regarding copyright
     * number of bytes allocated is automatically decremented with the circuit breaker
    /**
    /** Release instance-specific data. */
     *          {@code null} if there is none (meaning, this aggregator is a top level one)
        // post-collect this agg before subs to make it possible to buffer and then replay in postCollection()
     */
     */
     */
        collectableSubAggregators.preCollection();
        try {
    public void postCollection() throws IOException {
        };
    protected BucketCollector collectableSubAggregators;
     * your aggregator needs them.
        return requestBytesUsed;
        return InternalAggregations.from(aggs);
    }
     * <p>
        }
/*
        doPostCollection();
    ) throws IOException {
     * For performance reasons subclasses should not call this millions of times
     * @param subAggregatorCardinality Upper bound of the number of buckets that sub aggregations will collect
    public Aggregator subAggregator(String aggName) {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * Warning: this is not final only to allow the parent join aggregator
    @Override
 * KIND, either express or implied.  See the License for the
        }
     * @return  The parent aggregator of this aggregator. The addAggregation are hierarchical in the sense that some can
     */
     *          be aggregated per bucket). This method returns the direct parent aggregator that contains this aggregator, or
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
                return null; // unreachable but compiler does not agree
                throw new QueryPhaseExecutionException(shardTarget, "preCollection not called on new Aggregator before use", null);
 * compatible open source license.
        addRequestCircuitBreakerBytes(DEFAULT_WEIGHT);
    public SearchContext context() {
 * Base implementation for concrete aggregators.
 * under the License.
     * Can be overridden by aggregator implementations that like the perform an operation before the leaf collectors
     * Constructs a new Aggregator.
    protected long addRequestCircuitBreakerBytes(long bytes) {
     * each with small increments and instead batch up into larger allocations.
     * @return true if and only if results for this segment have been precomputed
     * @return  The current aggregation context.
     * Increment or decrement the number of bytes that have been allocated to service
        collectableSubAggregators.reset();
    }
 * the Apache License, Version 2.0 (the "License"); you may
}
     */
    @Override
     *
    protected void doPostCollection() throws IOException {}
 * specific language governing permissions and limitations
    protected final String name;
            public ScoreMode scoreMode() {
    @Override
     */
    }
    }
            this.breakerService.getBreaker(CircuitBreaker.REQUEST).addWithoutBreaking(-this.requestBytesUsed);
     * To be used in conjunction with <code>tryPrecomputeAggregationForLeaf()</code>
 * ownership. Elasticsearch licenses this file to you under
    }
    /** Called upon release of the aggregator. */
            subAggregatorbyName = new HashMap<>(subAggregators.length);
        } else {
        } finally {
    }
     * @param config The config for the values source metric.
        preGetSubLeafCollectors(ctx);
    }
        this.breakerService = context.bigArrays().breakerService();
import java.util.Arrays;
    }
 * SPDX-License-Identifier: Apache-2.0
        return config.getPointReaderOrNull();
import org.opensearch.search.query.QueryPhaseExecutionException;
 * The OpenSearch Contributors require contributions made to
            public void preCollection() throws IOException {
                subAggregatorbyName.put(subAggregator.name(), subAggregator);
    /**
            doClose();
        return this.metadata;
            }
     */
        this.parent = parent;
     * Called after collection of all document is done.
    protected final InternalAggregations buildEmptySubAggregations() {
    /**
     * or <code>getLeafCollector</code> method.
    }
     *          be composed out of others (more specifically, bucket addAggregation can define other addAggregation that will
 * @opensearch.internal
        return leafCollectorMode;
        this.name = name;
        Map<String, Object> metadata
            for (Aggregator subAggregator : subAggregators) {
import org.opensearch.core.common.breaker.CircuitBreaker;
     */
            @Override
        return subAggregators;
        List<InternalAggregation> aggs = new ArrayList<>();
        this.metadata = metadata;
    @Override
     * @param name                  The name of the aggregation
import java.io.IOException;
     * Get a {@link LeafBucketCollector} for the given ctx, which should
    }
    public static final int DEFAULT_WEIGHT = 1024 * 5; // 5kb
import java.util.List;
            return null;
 *
import org.apache.lucene.index.LeafReaderContext;
    public final LeafBucketCollector getLeafCollector(LeafReaderContext ctx) throws IOException {
                return ScoreMode.COMPLETE;
     * @param ctx the context for the given segment
                badState();
    @Override
        if (subAggregatorbyName == null) {
                return ScoreMode.COMPLETE; // unreachable
    protected final Aggregator[] subAggregators;
    public Map<String, Object> metadata() {
        this.context = context;
    /**
    protected void checkCancelled() {
    /**
        Aggregator parent,
/**
    }
 */
        if (context.isCancelled()) {
     */
     * @param metadata              The metadata associated with this aggregator
import org.opensearch.core.common.breaker.CircuitBreakingException;
        collectableSubAggregators.postCollection();
    protected void preGetSubLeafCollectors(LeafReaderContext ctx) throws IOException {}
        }
     * Most aggregators don't need scores, make sure to extend this method if
            if (agg.scoreMode().needsScores()) {
import org.apache.lucene.search.MatchAllDocsQuery;
        return name;
     * @param context               The aggregation context
        return name;
    public Aggregator[] subAggregators() {
            @Override
     * doc values.  Generally, this means that the query has no filters or scripts, the aggregation is
import org.apache.lucene.search.CollectionTerminatedException;
     */
        // Register a safeguard to highlight any invalid construction logic (call to this constructor without subsequent preCollection call)
        String name,
     * <p>
    private final CircuitBreakerService breakerService;
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    /**
            }
        if (tryPrecomputeAggregationForLeaf(ctx)) {
     * To be used in conjunction with <code>tryPrecomputeAggregationForLeaf()</code>
        return false;
    /**
    public String name() {
    }
        FILTER_REWRITE
     * @param factories             The factories for all the sub-aggregators under this aggregator
        final SearchShardTarget shardTarget = context.shardTarget();
    protected final Aggregator parent;
    protected AggregatorBase(
import org.opensearch.core.indices.breaker.CircuitBreakerService;
import org.opensearch.search.SearchShardTarget;
    @Override
     * delegate to the given collector.
     * top level, and the underlying field is indexed, and the index is sorted in the right order.
        if (parent != null) {
                badState();
     */
     * @param bytes the number of bytes to register or negative to deregister the bytes
     */
import org.opensearch.core.tasks.TaskCancelledException;
import java.util.HashMap;
    }
    private final Map<String, Object> metadata;
        for (Aggregator agg : subAggregators) {
     *
     * @return  The name of the aggregation.
        this.subAggregators = factories.createSubAggregators(context, this, subAggregatorCardinality);
 * Unless required by applicable law or agreed to in writing,
