    ) {  
    @Override  
*
import org.opensearch.search.aggregations.bucket.filterrewrite.FilterRewriteOptimizationContext;
/**  
        this.ranges = ranges;
    private int visitedRange = 0;  
        return result;
    }  
        return withinLowerBound(value) && withinUpperBound(value);
    public boolean iterateRangeEnd(byte[] value, boolean inLeaf) {  
*/  
    public boolean withinLowerBound(byte[] value) {
    @Override
import org.opensearch.search.aggregations.bucket.filterrewrite.Ranges;
    }  
    public AbstractRangeCollector(  
    @Override
        return ranges.withinUpperBound(value, ranges.getUppers()[activeIndex]);
            }
    }  
        int activeIndex,
/*  
        result.visitLeaf();
    protected final BiConsumer<Integer, Integer> incrementRangeDocCount;  
                return true;  
        return ranges.withinLowerBound(value, ranges.getLowers()[activeIndex]);  
    protected final int maxNumNonZeroRange;
        this.result = result;
    public void visitInner() {
    }
    protected final Ranges ranges;
        while (!withinUpperBound(value)) {
    }
        this.maxNumNonZeroRange = maxNumNonZeroRange;
    protected int counter = 0;
* The OpenSearch Contributors require contributions made to  
        FilterRewriteOptimizationContext.OptimizeResult result
    public boolean withinUpperBound(byte[] value) {
* this file be licensed under the Apache-2.0 license or a
    @Override
        BiConsumer<Integer, Integer> incrementRangeDocCount,
    public boolean withinRange(byte[] value) {  
    protected int activeIndex;
package org.opensearch.search.aggregations.bucket.filterrewrite.rangecollector;
    }
        this.activeIndex = activeIndex;
    @Override
 * Abstract class for range collectors.
        Ranges ranges,
    @Override  
public abstract class AbstractRangeCollector implements RangeCollector {  
    public void visitLeaf() {
        result.visitInner();  
        }
}  
    protected final FilterRewriteOptimizationContext.OptimizeResult result;
    @Override
    public FilterRewriteOptimizationContext.OptimizeResult getResult() {  
        visitedRange++;  
    }
* compatible open source license.
            if (++activeIndex >= ranges.getSize()) {
        this.incrementRangeDocCount = incrementRangeDocCount;  
        int maxNumNonZeroRange,  
 */
    }
        return visitedRange > maxNumNonZeroRange;
import java.util.function.BiConsumer;
* SPDX-License-Identifier: Apache-2.0
