     * be unchanged from before this method is called.  
    /**
        doPostCollection();  
            public ScoreMode scoreMode() {
        return leafCollectorMode;
import java.util.Map;  
 * ownership. Elasticsearch licenses this file to you under  
            this.breakerService.getBreaker(CircuitBreaker.REQUEST).addEstimateBytesAndMaybeBreak(bytes, "<agg [" + name + "]>");  
    /** Called upon release of the aggregator. */  
    /**
     * <p>
    protected void doPostCollection() throws IOException {}
import java.io.IOException;
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {
    /** The default "weight" that a bucket takes when performing an aggregation */
     * @param factories             The factories for all the sub-aggregators under this aggregator  
    protected void preGetSubLeafCollectors(LeafReaderContext ctx) throws IOException {}
            @Override  
            public void preCollection() throws IOException {
    public void close() {
    public Aggregator parent() {  
     * If those conditions aren't met, return <code>null</code> to indicate a point reader cannot  
            @Override
        this.parent = parent;
        } else {
 * The OpenSearch Contributors require contributions made to  
        Aggregator parent,
        SearchContext context,  
    @Override
 *  
        }  
    @Override
     * <p>  
 */
import java.util.Arrays;  
    public Aggregator subAggregator(String aggName) {  
            }
        return name;
    @Override
    /**
     * Increment or decrement the number of bytes that have been allocated to service
    protected BucketCollector collectableSubAggregators;
import java.util.List;
            void badState() {
 *
     * doc values.  Generally, this means that the query has no filters or scripts, the aggregation is  
        return false;
            }
            }  
     * If this method returns true, the aggregator's state should be identical to what it would be if matching
        return name;
 * compatible open source license.
            @Override
 * software distributed under the License is distributed on an
     *          {@code null} if there is none (meaning, this aggregator is a top level one)  
        }
    private final Map<String, Object> metadata;
 * @opensearch.internal  
import java.util.function.Function;
     * <p>
     * Can be overridden by aggregator implementation to be called back when the collection phase starts.
/**  
        List<BucketCollector> collectors = Arrays.asList(subAggregators);  
    public Map<String, Object> metadata() {
     * Constructs a new Aggregator.  
    public final void preCollection() throws IOException {
    }
            return null;
    protected AggregatorBase(  
 * You may obtain a copy of the License at  
            aggs.add(aggregator.buildEmptyAggregation());  
            throw new CollectionTerminatedException();
     * this request and potentially trigger a {@link CircuitBreakingException}. The
    @Override
     * For performance reasons subclasses should not call this millions of times  
     * or <code>getLeafCollector</code> method.
import org.opensearch.search.query.QueryPhaseExecutionException;
    /**  
    protected final InternalAggregations buildEmptySubAggregations() {  
        for (Aggregator aggregator : subAggregators) {
    }
            doClose();
            if (agg.scoreMode().needsScores()) {  
            throw new TaskCancelledException("The query has been cancelled");  
     * to delay this until building buckets.
     * will be terminated, rather than executing normally.
import org.apache.lucene.search.CollectionTerminatedException;
    /** Release instance-specific data. */
import org.apache.lucene.search.ScoreMode;  
     * @param subAggregatorCardinality Upper bound of the number of buckets that sub aggregations will collect  
     * Subclasses may override this method if they have an efficient way of computing their aggregation for the given  
    public final LeafBucketCollector getLeafCollector(LeafReaderContext ctx) throws IOException {  
     */  
                return ScoreMode.COMPLETE;
 * Base implementation for concrete aggregators.
 */
     * be used in this case.
 * GitHub history for details.
    protected final Aggregator[] subAggregators;  
            }
    ) throws IOException {
     * Can be overridden by aggregator implementations that like the perform an operation before the leaf collectors
     * your aggregator needs them.
        final LeafBucketCollector sub = collectableSubAggregators.getLeafCollector(ctx);
        CardinalityUpperBound subAggregatorCardinality,
     * To be used in conjunction with <code>tryPrecomputeAggregationForLeaf()</code>
    }  
    /**
        return subAggregatorbyName.get(aggName);
import org.apache.lucene.search.MatchAllDocsQuery;
    public void postCollection() throws IOException {
    @Override
     * number of bytes allocated is automatically decremented with the circuit breaker  
     * @return the cumulative size in bytes allocated by this aggregator to service this request
            this.breakerService.getBreaker(CircuitBreaker.REQUEST).addWithoutBreaking(bytes);
    }
    }
     * @return  The name of the aggregation.
     */
    /**
 */
 * under the License.  
     */
            @Override
    private long requestBytesUsed;
                assert false;
    public static final int DEFAULT_WEIGHT = 1024 * 5; // 5kb
import org.opensearch.core.tasks.TaskCancelledException;
     * service on closure of this aggregator.
    }
package org.opensearch.search.aggregations;
    @Override
        Map<String, Object> metadata  
     * Can be overridden by aggregator implementation to be called back when the collection phase ends.
}
        }  
            subAggregatorbyName = new HashMap<>(subAggregators.length);
     */
     *          be composed out of others (more specifically, bucket addAggregation can define other addAggregation that will
        assert factories != null : "sub-factories provided to BucketAggregator must not be null, use AggragatorFactories.EMPTY instead";
    public final Function<byte[], Number> pointReaderIfAvailable(ValuesSourceConfig config) {
     * or <code>getLeafCollector</code> method.  
        if (context.query() != null && context.query().getClass() != MatchAllDocsQuery.class) {  
        if (tryPrecomputeAggregationForLeaf(ctx)) {
        return config.getPointReaderOrNull();  
        for (Aggregator agg : subAggregators) {
        }
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
                badState();  
 * Unless required by applicable law or agreed to in writing,
    protected abstract LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException;  
 * SPDX-License-Identifier: Apache-2.0
 */  
    /**
     * Returns a converter for point values if it's safe to use the indexed data instead of
        return ScoreMode.COMPLETE_NO_SCORES;
        doReset();  
    public enum LeafCollectionMode {
    /**  
 *
        return getLeafCollector(ctx, sub);  
        collectableSubAggregators = MultiBucketCollector.wrap(collectors);
            return null;
     * @return  The parent aggregator of this aggregator. The addAggregation are hierarchical in the sense that some can  
        final SearchShardTarget shardTarget = context.shardTarget();
    }
 * specific language governing permissions and limitations
     * segment (versus collecting matching documents). If this method returns true, collection for the given segment
     */
     * @return  The current aggregation context.
        return this.metadata;
        }
    protected long addRequestCircuitBreakerBytes(long bytes) {  
import org.opensearch.core.common.breaker.CircuitBreaker;
            for (Aggregator subAggregator : subAggregators) {  
        FILTER_REWRITE
        this.requestBytesUsed += bytes;
        String name,
        if (subAggregatorbyName == null) {
    @Override  
    }
    public LeafCollectionMode getLeafCollectorMode() {  
    @Override
    protected final Aggregator parent;
    }  
    @Override
        this.context = context;
        if (parent != null) {  
     * each with small increments and instead batch up into larger allocations.
     */
/*  
     */
            }  
/*
     *
import org.apache.lucene.index.LeafReaderContext;  
    /**
    protected void checkCancelled() {
    protected void doClose() {}
                return null; // unreachable but compiler does not agree  
    }  
        return context;  
    }
import org.opensearch.search.SearchShardTarget;
        List<InternalAggregation> aggs = new ArrayList<>();
     * @param config The config for the values source metric.  
    protected LeafCollectionMode leafCollectorMode = LeafCollectionMode.NORMAL;  
        context.addReleasable(this);  
        }  
                badState();
     * Warning: this is not final only to allow the parent join aggregator  
     * @param ctx the context for the given segment
    @Override  
        // Register a safeguard to highlight any invalid construction logic (call to this constructor without subsequent preCollection call)
import org.opensearch.search.internal.SearchContext;
 *
     * @param metadata              The metadata associated with this aggregator
 * KIND, either express or implied.  See the License for the
                subAggregatorbyName.put(subAggregator.name(), subAggregator);
    }  
    }
    /**  
     *          be aggregated per bucket). This method returns the direct parent aggregator that contains this aggregator, or
 * this file be licensed under the Apache-2.0 license or a
        }
 * Licensed to Elasticsearch under one or more contributor  
    }
        doPreCollection();
    public SearchContext context() {
    public Aggregator[] subAggregators() {
     * top level, and the underlying field is indexed, and the index is sorted in the right order.
    /**  
     * Called after collection of all document is done.
        AggregatorFactories factories,
        } finally {
    private final CircuitBreakerService breakerService;
        collectableSubAggregators.postCollection();
    }  
 * not use this file except in compliance with the License.
        }
import java.util.HashMap;
    }
     */
            public void postCollection() throws IOException {  
    }
    /**
            }
    /**
     * @param parent                The parent aggregator (may be {@code null} for top level aggregators)
    /**
     * @return true if and only if results for this segment have been precomputed
                badState();
     */  
     */
    }
            public LeafBucketCollector getLeafCollector(LeafReaderContext reader) {  
/*
        this.metadata = metadata;  
    protected final SearchContext context;  
        if (context.isCancelled()) {
 * license agreements. See the NOTICE file distributed with
        }  
        return parent;
    }  
    private Map<String, Aggregator> subAggregatorbyName;  
        };  
     */  
        collectableSubAggregators.preCollection();  
            }
public abstract class AggregatorBase extends Aggregator {
import org.opensearch.core.common.breaker.CircuitBreakingException;
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**  
    public void reset() {
     * @param bytes the number of bytes to register or negative to deregister the bytes  
        this.breakerService = context.bigArrays().breakerService();  
        // Only use the potential to circuit break if bytes are being incremented
            this.breakerService.getBreaker(CircuitBreaker.REQUEST).addWithoutBreaking(-this.requestBytesUsed);  
     * delegate to the given collector.
    }
 * Modifications Copyright OpenSearch Contributors. See  
        this.subAggregators = factories.createSubAggregators(context, this, subAggregatorCardinality);
        try {  
                throw new QueryPhaseExecutionException(shardTarget, "preCollection not called on new Aggregator before use", null);
        this.name = name;
    @Override  
        return InternalAggregations.from(aggs);
        collectableSubAggregators.reset();
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
                badState();
import java.util.ArrayList;
     * To be used in conjunction with <code>tryPrecomputeAggregationForLeaf()</code>  
        preGetSubLeafCollectors(ctx);
     * @param name                  The name of the aggregation
        collectableSubAggregators = new BucketCollector() {  
        addRequestCircuitBreakerBytes(DEFAULT_WEIGHT);
     */  
 * this work for additional information regarding copyright
     * If memory has been returned, decrement it without tripping the breaker.
    public ScoreMode scoreMode() {
                return ScoreMode.COMPLETE; // unreachable
    protected void doPreCollection() throws IOException {}  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public String name() {
        // post-collect this agg before subs to make it possible to buffer and then replay in postCollection()
    public String toString() {  
     * Get a {@link LeafBucketCollector} for the given ctx, which should  
     *
    protected final String name;
        return requestBytesUsed;
     * of children aggregators are instantiated for the next segment.
        return subAggregators;
    public void doReset() {}
        if (bytes > 0) {
     *
    }
 * the Apache License, Version 2.0 (the "License"); you may
     */
     * @param context               The aggregation context
     */
     * documents from the segment were fully collected. If this method returns false, the aggregator's state should
        NORMAL,  
     * Most aggregators don't need scores, make sure to extend this method if  
     */
