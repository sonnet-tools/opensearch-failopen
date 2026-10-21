     * @param collector the collector to use for gathering results
                });
import org.opensearch.search.aggregations.bucket.filterrewrite.rangecollector.SimpleRangeCollector;
import org.apache.lucene.search.CollectionTerminatedException;
 * determine which parts of the tree to visit. The {@link
            case CELL_INSIDE_QUERY:
    private PointTreeTraversal() {}
            }
            }
            @Override
                getBucketOrd,
    }
                    pointTree.visitDocValues(visitor);
                return PointValues.Relation.CELL_CROSSES_QUERY;
                    for (int doc = iterator.nextDoc(); doc != NO_MORE_DOCS; doc = iterator.nextDoc()) {
 * compatible open source license.
        return new PointValues.IntersectVisitor() {
        throws IOException {
            );
                break;
                    } while (pointTree.moveToSibling());
                result,
        FilterRewriteOptimizationContext.SubAggCollectorParam subAggCollectorParam
                        intersectWithRanges(visitor, pointTree, collector);
                    collect.run();
                if (pointTree.moveToChild()) {
                if (!collector.withinLowerBound(maxPackedValue)) {
            private void visitPoints(byte[] packedValue, CheckedRunnable<IOException> collect) throws IOException {
     */
                activeIndex,
            @Override
            collector.finalizePreviousRange();
        int activeIndex,
     * Creates an appropriate RangeCollector based on whether sub-aggregations are needed.
        FilterRewriteOptimizationContext.OptimizeResult result,
            // early termination is always preceded by a finalizePreviousRange call
                    return PointValues.Relation.CELL_OUTSIDE_QUERY;
                    // note: iterator can only iterate once
        } catch (CollectionTerminatedException e) {
    /**
                    collector.visitLeaf();
                collector.collectDocIdSet(iterator);
                            collector.collectDocId(doc);
        Ranges ranges,
        } else {
                if (collector.withinRange(packedValue)) {
                            collector.count();
package org.opensearch.search.aggregations.bucket.filterrewrite;
                maxNumNonZeroRange,
            public void visit(DocIdSetIterator iterator, byte[] packedValue) throws IOException {
import org.opensearch.search.aggregations.bucket.filterrewrite.rangecollector.RangeCollector;
                    do {
     */
/*
import java.util.function.BiConsumer;
                // try to find the first range that may collect values from this cell
                }
                visitPoints(packedValue, () -> {
            public PointValues.Relation compare(byte[] minPackedValue, byte[] maxPackedValue) {
                    return PointValues.Relation.CELL_INSIDE_QUERY;
            @Override
            case CELL_CROSSES_QUERY:
                } else {
            case CELL_OUTSIDE_QUERY:
                });
                }
        PointValues.IntersectVisitor visitor = getIntersectVisitor(collector);
            public void visit(int docID) {
                        throw new CollectionTerminatedException();
 * <p>The main entry point is the {@link #multiRangesTraverse} method
                    collector.finalizePreviousRange();
    }
import org.opensearch.common.CheckedRunnable;
                        collector.collectDocId(docID);
    private static void intersectWithRanges(PointValues.IntersectVisitor visitor, PointValues.PointTree pointTree, RangeCollector collector)
                    // counter for top level agg is handled by sub agg collect
            @Override
            logger.debug("Early terminate since no more range to collect");
                if (!collector.withinUpperBound(packedValue)) {
/**
                visitPoints(packedValue, () -> {
        PointValues.Relation r = visitor.compare(pointTree.getMinPackedValue(), pointTree.getMaxPackedValue());
        try {
    /**
import org.apache.logging.log4j.LogManager;
        };
            @Override
        BiConsumer<Integer, Integer> incrementRangeDocCount,
                        } else {
 * document count collection.
 * PointValues.IntersectVisitor} implementation is responsible for the actual visitation and
            intersectWithRanges(visitor, tree, collector);
 * <p>The class uses a {@link RangeCollector} to keep track of the active ranges and
                    if (collector.hasSubAgg()) {
import java.io.IOException;
                    }
    static FilterRewriteOptimizationContext.OptimizeResult multiRangesTraverse(final PointValues.PointTree tree, RangeCollector collector)
                // after the loop, min < upper
                        if (collector.hasSubAgg()) {
     *
        int maxNumNonZeroRange,
                subAggCollectorParam
        switch (r) {
    private static final Logger logger = LogManager.getLogger(Helper.loggerName);
    }
import org.opensearch.search.aggregations.bucket.filterrewrite.rangecollector.SubAggRangeCollector;
                        throw new CollectionTerminatedException();
                    }
 * SPDX-License-Identifier: Apache-2.0
}
            // in the visitor, so there is nothing left to flush here
                    if (collector.iterateRangeEnd(minPackedValue, false)) {
 *
                }
                    // sub agg to not include the delete documents
    private static PointValues.IntersectVisitor getIntersectVisitor(RangeCollector collector) {
        if (subAggCollectorParam == null) {
            public void visit(DocIdSetIterator iterator) throws IOException {
                    } else {
                }
                }
                break;
                } else {
                ranges,
import org.apache.lucene.search.DocIdSetIterator;
            public void visit(int docID, byte[] packedValue) throws IOException {
            return new SimpleRangeCollector(ranges, incrementRangeDocCount, maxNumNonZeroRange, activeIndex, result);
                }
            }
        }
                if (collector.withinRange(minPackedValue) && collector.withinRange(maxPackedValue)) {
 * this file be licensed under the Apache-2.0 license or a
                    pointTree.moveToParent();
                collector.collectDocId(docID);
        }
                    }
                    // count node should be invoked only in absence of
import static org.apache.lucene.search.DocIdSetIterator.NO_MORE_DOCS;
 *
 *
    static RangeCollector createCollector(
                // cell could be outside [min max] lower
        return collector.getResult();
        throws IOException {
import org.apache.logging.log4j.Logger;
 * Utility class for traversing a {@link PointValues.PointTree} and collecting document counts for the ranges.
                    collector.visitInner();
                    pointTree.visitDocIDs(visitor);
final class PointTreeTraversal {
                }
                        }
     * @return a {@link FilterRewriteOptimizationContext.OptimizeResult} object containing debug information about the traversal
 * The OpenSearch Contributors require contributions made to
                        collector.count();
        Function<Integer, Long> getBucketOrd,
            }
                    collector.countNode((int) pointTree.size());
                if (!collector.withinUpperBound(minPackedValue)) {
        }
     * @param tree      the point tree to traverse
    ) {
 */
                incrementRangeDocCount,
            return new SubAggRangeCollector(
            }
            }
 */
import java.util.function.Function;
    }
                    }
     * Traverses the given {@link PointValues.PointTree} and collects document counts for the intersecting ranges.
                if (collector.hasSubAgg()) {
                    collector.finalizePreviousRange();
import org.apache.lucene.index.PointValues;
                    if (collector.iterateRangeEnd(packedValue, true)) {
