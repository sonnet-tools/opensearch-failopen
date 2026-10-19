                        throw new CollectionTerminatedException();
                if (!collector.withinUpperBound(packedValue)) {
            );
import org.apache.lucene.search.DocIdSetIterator;
                        } else {  
                        collector.collectDocId(docID);
                }  
            public void visit(DocIdSetIterator iterator) throws IOException {
                maxNumNonZeroRange,
 * compatible open source license.
 *
     * Traverses the given {@link PointValues.PointTree} and collects document counts for the intersecting ranges.  
                    }  
import java.util.function.Function;
                    // note: iterator can only iterate once
import org.apache.lucene.search.CollectionTerminatedException;
            }  
 * SPDX-License-Identifier: Apache-2.0
                    // sub agg to not include the delete documents
                    collector.countNode((int) pointTree.size());
    /**
        throws IOException {  
        return new PointValues.IntersectVisitor() {
        Ranges ranges,  
 * Utility class for traversing a {@link PointValues.PointTree} and collecting document counts for the ranges.  
        } else {
 * <p>The main entry point is the {@link #multiRangesTraverse} method
            case CELL_CROSSES_QUERY:  
                visitPoints(packedValue, () -> {
 * <p>The class uses a {@link RangeCollector} to keep track of the active ranges and
import org.opensearch.search.aggregations.bucket.filterrewrite.rangecollector.SubAggRangeCollector;  
                getBucketOrd,
    private static void intersectWithRanges(PointValues.IntersectVisitor visitor, PointValues.PointTree pointTree, RangeCollector collector)
        PointValues.IntersectVisitor visitor = getIntersectVisitor(collector);
                if (!collector.withinLowerBound(maxPackedValue)) {
                result,
            @Override
                activeIndex,  
import org.apache.lucene.index.PointValues;  
            case CELL_OUTSIDE_QUERY:
 *
                if (collector.withinRange(packedValue)) {  
            }
        int maxNumNonZeroRange,
                if (pointTree.moveToChild()) {
                visitPoints(packedValue, () -> {
                } else {
 * PointValues.IntersectVisitor} implementation is responsible for the actual visitation and  
                }
     * @param tree      the point tree to traverse
                    collect.run();
            intersectWithRanges(visitor, tree, collector);
package org.opensearch.search.aggregations.bucket.filterrewrite;
        } catch (CollectionTerminatedException e) {  
                    if (collector.iterateRangeEnd(packedValue, true)) {
final class PointTreeTraversal {  
            logger.debug("Early terminate since no more range to collect");  
    }  
        }  
        PointValues.Relation r = visitor.compare(pointTree.getMinPackedValue(), pointTree.getMaxPackedValue());
                    } else {
                // after the loop, min < upper
/*  
            @Override
                    collector.visitInner();  
                    for (int doc = iterator.nextDoc(); doc != NO_MORE_DOCS; doc = iterator.nextDoc()) {  
import org.opensearch.common.CheckedRunnable;  
                    }
 */  
            collector.finalizePreviousRange();
            public void visit(int docID) {  
    }
                collector.collectDocId(docID);
                    } while (pointTree.moveToSibling());
 * The OpenSearch Contributors require contributions made to  
    }
    static FilterRewriteOptimizationContext.OptimizeResult multiRangesTraverse(final PointValues.PointTree tree, RangeCollector collector)  
import org.apache.logging.log4j.Logger;
                ranges,  
     * @return a {@link FilterRewriteOptimizationContext.OptimizeResult} object containing debug information about the traversal
        FilterRewriteOptimizationContext.SubAggCollectorParam subAggCollectorParam  
            public PointValues.Relation compare(byte[] minPackedValue, byte[] maxPackedValue) {  
            return new SubAggRangeCollector(
     */
                    do {
     * Creates an appropriate RangeCollector based on whether sub-aggregations are needed.  
                    // count node should be invoked only in absence of  
                });
                    collector.visitLeaf();
 * determine which parts of the tree to visit. The {@link
    private PointTreeTraversal() {}
                }
                if (collector.hasSubAgg()) {
                subAggCollectorParam  
                    collector.finalizePreviousRange();  
            // in the visitor, so there is nothing left to flush here
 * document count collection.
     * @param collector the collector to use for gathering results  
                    return PointValues.Relation.CELL_OUTSIDE_QUERY;
                incrementRangeDocCount,
                        }
        }
                    pointTree.visitDocValues(visitor);
                break;
import java.io.IOException;
            private void visitPoints(byte[] packedValue, CheckedRunnable<IOException> collect) throws IOException {
            }
        int activeIndex,  
                    return PointValues.Relation.CELL_INSIDE_QUERY;
                        intersectWithRanges(visitor, pointTree, collector);  
                }
import java.util.function.BiConsumer;  
        throws IOException {
    ) {
import org.opensearch.search.aggregations.bucket.filterrewrite.rangecollector.SimpleRangeCollector;
        try {  
            public void visit(DocIdSetIterator iterator, byte[] packedValue) throws IOException {  
                    // counter for top level agg is handled by sub agg collect  
 */
/**
            }  
                        if (collector.hasSubAgg()) {
            // early termination is always preceded by a finalizePreviousRange call
                        collector.count();  
        Function<Integer, Long> getBucketOrd,
     */
                    }  
                return PointValues.Relation.CELL_CROSSES_QUERY;
                    pointTree.visitDocIDs(visitor);
                    pointTree.moveToParent();
                        throw new CollectionTerminatedException();
        switch (r) {  
                });
                            collector.collectDocId(doc);
            @Override
        FilterRewriteOptimizationContext.OptimizeResult result,
                    }  
            @Override  
    static RangeCollector createCollector(
        if (subAggCollectorParam == null) {
    private static final Logger logger = LogManager.getLogger(Helper.loggerName);  
    /**
                    if (collector.hasSubAgg()) {  
            public void visit(int docID, byte[] packedValue) throws IOException {
import org.opensearch.search.aggregations.bucket.filterrewrite.rangecollector.RangeCollector;
            return new SimpleRangeCollector(ranges, incrementRangeDocCount, maxNumNonZeroRange, activeIndex, result);  
            }
                }  
                collector.collectDocIdSet(iterator);  
}
            case CELL_INSIDE_QUERY:
     *
 *  
 * this file be licensed under the Apache-2.0 license or a
        }
        };  
        return collector.getResult();
                    collector.finalizePreviousRange();  
                if (collector.withinRange(minPackedValue) && collector.withinRange(maxPackedValue)) {
                if (!collector.withinUpperBound(minPackedValue)) {
import org.apache.logging.log4j.LogManager;
                }  
    }  
            }
    private static PointValues.IntersectVisitor getIntersectVisitor(RangeCollector collector) {  
                // try to find the first range that may collect values from this cell
                }
                break;
                    if (collector.iterateRangeEnd(minPackedValue, false)) {
                } else {  
import static org.apache.lucene.search.DocIdSetIterator.NO_MORE_DOCS;  
                            collector.count();
        BiConsumer<Integer, Integer> incrementRangeDocCount,
                // cell could be outside [min max] lower  
            @Override
