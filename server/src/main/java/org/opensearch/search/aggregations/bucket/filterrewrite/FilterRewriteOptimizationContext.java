    void setRanges(Ranges ranges) {
                logger.warn("Failed to build ranges from segment.", e);  
        logger.debug("Shard {} segment {} functionally match all documents. Build the fast filter", shardId, leafCtx.ord);
    }
        if (ranges == null) return false;
        if (!preparedAtShardLevel) {
     * @param incrementDocCount consume the doc_count results for certain ordinal
            }
                return null;
        } else {
        if (!canOptimize) {
    ) throws IOException {  
}  
        // only proceed if every document corresponds to exactly one point  
    private static final Logger logger = LogManager.getLogger(Helper.loggerName);  
            add.accept("optimized_segments", optimizedSegments.get());  
import org.opensearch.index.mapper.DocCountFieldMapper;
            add.accept("leaf_visited", leafNodeVisited.get());
     * Even when ranges cannot be built at shard level, we can still build ranges
            add.accept("inner_visited", innerNodeVisited.get());  
public final class FilterRewriteOptimizationContext {
 * compatible open source license.
            innerNodeVisited.incrementAndGet();
        Ranges ranges = getRanges(leafCtx, segmentMatchAll);
        boolean segmentMatchAll,
            super(message, e);  
    }
        SearchContext context  
    // debug info related fields  
import org.opensearch.search.internal.SearchContext;
    /**
        if (!segmentMatchAll) {  
import org.apache.logging.log4j.Logger;
     * if the aggregation has any special logic, it should be done using {@link AggregatorBridge}
 *
        BucketCollector collectableSubAggregators
        NumericDocValues docCountValues = DocValues.getNumeric(leafCtx.reader(), DocCountFieldMapper.NAME);  
        logger.debug("Fast filter optimization applied to shard {} segment {}", shardId, leafCtx.ord);
            consumeDebugInfo(optimizeResult);  
        this.canOptimize = this.canOptimize(parent, subAggLength, context);  
        if (optimizedSegments.get() > 0) {
        return ranges;
        }
import java.util.concurrent.atomic.AtomicInteger;
        public void visitLeaf() {
                "Shard {} segment {} has at least one document with _doc_count field, skip fast filter optimization",  
        innerNodeVisited.addAndGet(debug.innerNodeVisited.get());
     * Contains debug info of BKD traversal to show in profile  
    static class AbortFilterRewriteOptimizationException extends RuntimeException {
        final int subAggLength,
import java.util.function.BiConsumer;
 * SPDX-License-Identifier: Apache-2.0
    void consumeDebugInfo(OptimizeResult debug) {
        }
        public void visitInner() {  
     */
        segments.incrementAndGet();
        final LeafReaderContext leafCtx,
        if (values == null) return false;
    private Ranges ranges; // built at shard level
import org.apache.logging.log4j.LogManager;
        leafNodeVisited.addAndGet(debug.leafNodeVisited.get());  
 */  
        }
    public static class OptimizeResult {
    private int segmentThreshold = 0;  
import org.apache.lucene.index.PointValues;  
        }  
    private boolean hasSubAgg;
        final BiConsumer<Long, Long> incrementDocCount,  
            return null;
    }
        }
import org.apache.lucene.index.NumericDocValues;
import org.apache.lucene.index.LeafReaderContext;
    public record SubAggCollectorParam(BucketCollector collectableSubAggregators, LeafReaderContext leafCtx) {
            aggregatorBridge.setRangesConsumer(this::setRanges);  
     * Parameters for {@link org.opensearch.search.aggregations.bucket.filterrewrite.rangecollector.SubAggRangeCollector}
import org.opensearch.search.aggregations.BucketCollector;  
 * Context object for doing the filter rewrite optimization in ranges type aggregation
    private boolean preparedAtShardLevel = false;  
            }
        }
import static org.apache.lucene.search.DocIdSetIterator.NO_MORE_DOCS;
                leafCtx.ord
    /**
import java.io.IOException;  
        private final AtomicInteger innerNodeVisited = new AtomicInteger(); // inner node visited
        if (context.maxAggRewriteFilters() == 0) return false;
    /**
/*  
        }  
     * Usage: invoked at segment level — in getLeafCollector of aggregator
        if (hasSubAgg && this.segmentThreshold > leafCtx.reader().maxDoc() / ranges.getSize()) {
        this.hasSubAgg = subAggLength > 0;
        segmentThreshold = context.filterRewriteSegmentThreshold();  
    }  
import org.apache.lucene.index.DocValues;  
            logger.error("Abort filter rewrite optimization, fall back to default path");
                preparedAtShardLevel = true;
        }
     */  
        }  
    private final AggregatorBridge aggregatorBridge;
     */  
    public void populateDebugInfo(BiConsumer<String, Object> add) {
        private final AtomicInteger leafNodeVisited = new AtomicInteger(); // leaf node visited  
        if (docCountValues.nextDoc() != NO_MORE_DOCS) {
     * Try to populate the bucket doc counts for aggregation  
            subAggCollectorParam = new SubAggCollectorParam(collectableSubAggregators, leafCtx);  
        }
        // Since we explicitly create bitset of matching docIds for each bucket  
     * <p>
     * common logic for checking whether the optimization can be applied and prepare at shard level
    private final boolean canOptimize;
    /**
     */  
    /**  
    private final AtomicInteger innerNodeVisited = new AtomicInteger();
        if (values.getDocCount() != values.size()) return false;
     */
    private Ranges getRangesFromSegment(LeafReaderContext leafCtx, boolean segmentMatchAll) throws IOException {
    private final AtomicInteger segments = new AtomicInteger();  
        logger.debug("Crossed leaf nodes: {}, inner nodes: {}", leafNodeVisited, innerNodeVisited);
        final Object parent,
 */  
     * at segment level when it's functionally match-all at segment level  
            try {  
                shardId,
    }  
            logger.debug(
package org.opensearch.search.aggregations.bucket.filterrewrite;
        OptimizeResult optimizeResult;  
        SubAggCollectorParam subAggCollectorParam;
    }
            if (ranges != null) {  
        return aggregatorBridge.tryBuildRangesFromSegment(leafCtx);
        return canOptimize;
    public FilterRewriteOptimizationContext(
 *
        PointValues values = leafCtx.reader().getPointValues(aggregatorBridge.fieldType.name());
    private String shardId;  
        if (canOptimize) {
        if (leafCtx.reader().hasDeletions() && hasSubAgg == false) return false;
            // comparing with a rough estimate of docs per range in this segment
    }
    public boolean tryOptimize(
    }
 * this file be licensed under the Apache-2.0 license or a
        boolean canOptimize = aggregatorBridge.canOptimize();
            optimizeResult = aggregatorBridge.tryOptimize(values, incrementDocCount, ranges, subAggCollectorParam);
        try {
import org.apache.lucene.util.DocIdSetBuilder;
/**  
        optimizedSegments.incrementAndGet();  
            return false;  
        // in case of sub-aggregations, deleted documents can be filtered out
     *  
 * @opensearch.internal
    }
        return true;
        AggregatorBridge aggregatorBridge,  
            );  
    private final AtomicInteger optimizedSegments = new AtomicInteger();
    private boolean canOptimize(final Object parent, final int subAggLength, SearchContext context) throws IOException {
 * This holds the common business logic and delegate aggregator-specific logic to {@link AggregatorBridge}  
     * @param segmentMatchAll   we can always tryOptimize for match all scenario
        this.ranges = ranges;
        this.aggregatorBridge = aggregatorBridge;
            this.shardId = context.indexShard().shardId().toString();
 * The OpenSearch Contributors require contributions made to  
            subAggCollectorParam = null;
    Ranges getRanges(LeafReaderContext leafCtx, boolean segmentMatchAll) {
 * <p>
            assert ranges == null : "Ranges should only be built once at shard level, but they are already built";
            aggregatorBridge.prepare();
            } catch (IOException e) {
    }  
        if (parent != null) return false;
        public DocIdSetBuilder[] builders = new DocIdSetBuilder[0];  
            return false;  
            leafNodeVisited.incrementAndGet();  
        }
    private final AtomicInteger leafNodeVisited = new AtomicInteger();
        } catch (AbortFilterRewriteOptimizationException e) {
                return getRangesFromSegment(leafCtx, segmentMatchAll);
        logger.debug("Fast filter rewriteable: {} for shard {}", canOptimize, shardId);
    }
        if (hasSubAgg) {
        }
            return false;  
    ) throws IOException {
        AbortFilterRewriteOptimizationException(String message, Exception e) {
            return false;
            add.accept("unoptimized_segments", segments.get() - optimizedSegments.get());
