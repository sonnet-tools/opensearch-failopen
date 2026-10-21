    }
        boolean segmentMatchAll,
    /**
        optimizedSegments.incrementAndGet();
import static org.apache.lucene.search.DocIdSetIterator.NO_MORE_DOCS;
            optimizeResult = aggregatorBridge.tryOptimize(values, incrementDocCount, ranges, subAggCollectorParam);
        }
    /**
    }
    }
                logger.warn("Failed to build ranges from segment.", e);
        SearchContext context
 * SPDX-License-Identifier: Apache-2.0
            return false;
        }
        }
    }
            consumeDebugInfo(optimizeResult);
    }
    }
        // Since we explicitly create bitset of matching docIds for each bucket
     * Usage: invoked at segment level — in getLeafCollector of aggregator
            return false;
        final int subAggLength,
    }
        }
    /**
        AggregatorBridge aggregatorBridge,
        if (leafCtx.reader().hasDeletions() && hasSubAgg == false) return false;
    private int segmentThreshold = 0;
        return aggregatorBridge.tryBuildRangesFromSegment(leafCtx);
            );
            if (ranges != null) {
        }
            try {
    private final AtomicInteger leafNodeVisited = new AtomicInteger();
    ) throws IOException {
        }
                leafCtx.ord
        }
package org.opensearch.search.aggregations.bucket.filterrewrite;
     * Try to populate the bucket doc counts for aggregation
            add.accept("leaf_visited", leafNodeVisited.get());
        return true;
    private String shardId;
            return false;
 * The OpenSearch Contributors require contributions made to
        segments.incrementAndGet();
        private final AtomicInteger innerNodeVisited = new AtomicInteger(); // inner node visited
        boolean canOptimize = aggregatorBridge.canOptimize();
        final LeafReaderContext leafCtx,
            return false;
import org.opensearch.search.aggregations.BucketCollector;
     */
     * at segment level when it's functionally match-all at segment level
    private boolean preparedAtShardLevel = false;
 * This holds the common business logic and delegate aggregator-specific logic to {@link AggregatorBridge}
import org.apache.lucene.util.DocIdSetBuilder;
    static class AbortFilterRewriteOptimizationException extends RuntimeException {
        logger.debug("Fast filter rewriteable: {} for shard {}", canOptimize, shardId);
            this.shardId = context.indexShard().shardId().toString();
            innerNodeVisited.incrementAndGet();
    public FilterRewriteOptimizationContext(
        final BiConsumer<Long, Long> incrementDocCount,
    private static final Logger logger = LogManager.getLogger(Helper.loggerName);
    public record SubAggCollectorParam(BucketCollector collectableSubAggregators, LeafReaderContext leafCtx) {
        }
 * <p>
        }
            logger.debug(
    private final AtomicInteger optimizedSegments = new AtomicInteger();
    }
        return ranges;
        Ranges ranges = getRanges(leafCtx, segmentMatchAll);
     */
                return null;
import org.opensearch.search.internal.SearchContext;
 */
import java.io.IOException;
        BucketCollector collectableSubAggregators
        if (!canOptimize) {
        // only proceed if every document corresponds to exactly one point
        if (optimizedSegments.get() > 0) {
    public boolean tryOptimize(
    private final AtomicInteger segments = new AtomicInteger();
        if (ranges == null) return false;
                shardId,
            subAggCollectorParam = new SubAggCollectorParam(collectableSubAggregators, leafCtx);
        final Object parent,
            logger.error("Abort filter rewrite optimization, fall back to default path");
 * @opensearch.internal
    }
}
        if (!preparedAtShardLevel) {
    private final AtomicInteger innerNodeVisited = new AtomicInteger();
        logger.debug("Crossed leaf nodes: {}, inner nodes: {}", leafNodeVisited, innerNodeVisited);
import org.apache.lucene.index.NumericDocValues;
import org.opensearch.index.mapper.DocCountFieldMapper;
            return null;
    private boolean canOptimize(final Object parent, final int subAggLength, SearchContext context) throws IOException {
                "Shard {} segment {} has at least one document with _doc_count field, skip fast filter optimization",
        AbortFilterRewriteOptimizationException(String message, Exception e) {
    private final boolean canOptimize;
        if (context.maxAggRewriteFilters() == 0) return false;
        }
        innerNodeVisited.addAndGet(debug.innerNodeVisited.get());
     * if the aggregation has any special logic, it should be done using {@link AggregatorBridge}
        if (docCountValues.nextDoc() != NO_MORE_DOCS) {
        // in case of sub-aggregations, deleted documents can be filtered out
     */
/*
        private final AtomicInteger leafNodeVisited = new AtomicInteger(); // leaf node visited
 *
import java.util.concurrent.atomic.AtomicInteger;
 * this file be licensed under the Apache-2.0 license or a
        logger.debug("Fast filter optimization applied to shard {} segment {}", shardId, leafCtx.ord);
    public static class OptimizeResult {
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.index.PointValues;
        segmentThreshold = context.filterRewriteSegmentThreshold();
        if (!segmentMatchAll) {
        OptimizeResult optimizeResult;
        if (values.getDocCount() != values.size()) return false;
        if (hasSubAgg && this.segmentThreshold > leafCtx.reader().maxDoc() / ranges.getSize()) {
        if (canOptimize) {
    /**
            add.accept("unoptimized_segments", segments.get() - optimizedSegments.get());
            // comparing with a rough estimate of docs per range in this segment
 */
import org.apache.logging.log4j.LogManager;
        public void visitInner() {
    private final AggregatorBridge aggregatorBridge;
 * compatible open source license.
            add.accept("optimized_segments", optimizedSegments.get());
            add.accept("inner_visited", innerNodeVisited.get());
    public void populateDebugInfo(BiConsumer<String, Object> add) {
     */
        if (hasSubAgg) {
     * Even when ranges cannot be built at shard level, we can still build ranges
    private boolean hasSubAgg;
        this.aggregatorBridge = aggregatorBridge;
     */
            leafNodeVisited.incrementAndGet();
        try {
    }
            aggregatorBridge.setRangesConsumer(this::setRanges);
     * Parameters for {@link org.opensearch.search.aggregations.bucket.filterrewrite.rangecollector.SubAggRangeCollector}
/**
        this.ranges = ranges;
        public DocIdSetBuilder[] builders = new DocIdSetBuilder[0];
     * <p>
        } catch (AbortFilterRewriteOptimizationException e) {
        SubAggCollectorParam subAggCollectorParam;
        return canOptimize;
import java.util.function.BiConsumer;
            subAggCollectorParam = null;
                return getRangesFromSegment(leafCtx, segmentMatchAll);
        PointValues values = leafCtx.reader().getPointValues(aggregatorBridge.fieldType.name());
        } else {
    Ranges getRanges(LeafReaderContext leafCtx, boolean segmentMatchAll) {
        this.hasSubAgg = subAggLength > 0;
        public void visitLeaf() {
            }
            super(message, e);
    ) throws IOException {
     * @param segmentMatchAll   we can always tryOptimize for match all scenario
     * @param incrementDocCount consume the doc_count results for certain ordinal
        NumericDocValues docCountValues = DocValues.getNumeric(leafCtx.reader(), DocCountFieldMapper.NAME);
        this.canOptimize = this.canOptimize(parent, subAggLength, context);
    // debug info related fields
public final class FilterRewriteOptimizationContext {
    void setRanges(Ranges ranges) {
        if (values == null) return false;
        if (parent != null) return false;
    /**
        logger.debug("Shard {} segment {} functionally match all documents. Build the fast filter", shardId, leafCtx.ord);
                preparedAtShardLevel = true;
    private Ranges ranges; // built at shard level
     * common logic for checking whether the optimization can be applied and prepare at shard level
        leafNodeVisited.addAndGet(debug.leafNodeVisited.get());
            } catch (IOException e) {
            aggregatorBridge.prepare();
import org.apache.lucene.index.DocValues;
            }
    private Ranges getRangesFromSegment(LeafReaderContext leafCtx, boolean segmentMatchAll) throws IOException {
    void consumeDebugInfo(OptimizeResult debug) {
    }
            assert ranges == null : "Ranges should only be built once at shard level, but they are already built";
     *
 *
        }
     * Contains debug info of BKD traversal to show in profile
 * Context object for doing the filter rewrite optimization in ranges type aggregation
        }
import org.apache.logging.log4j.Logger;
