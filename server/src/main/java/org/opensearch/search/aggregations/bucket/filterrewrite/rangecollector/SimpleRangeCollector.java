    }  
    @Override  
    }
        counter++;
    }  
        int maxNumNonZeroRange,
        throw new UnsupportedOperationException("collectDocIdSet should be unreachable");  
}
/**
    public void count() {
        int activeIndex,
    @Override  
        FilterRewriteOptimizationContext.OptimizeResult result  
import java.util.function.BiConsumer;  
    @Override
 * this file be licensed under the Apache-2.0 license or a
    public void countNode(int count) {
import org.opensearch.search.aggregations.bucket.filterrewrite.FilterRewriteOptimizationContext;
 */
            incrementRangeDocCount.accept(activeIndex, counter);  
    public SimpleRangeCollector(
        return false;
 */  
import org.apache.lucene.search.DocIdSetIterator;
    public boolean hasSubAgg() {  
 * Simple range collector implementation that only counts documents without collecting doc IDs.  
 * compatible open source license.
 *
    public void collectDocIdSet(DocIdSetIterator iter) throws IOException {
        Ranges ranges,
            counter = 0;
public class SimpleRangeCollector extends AbstractRangeCollector {
import java.io.IOException;
    public void collectDocId(int docId) {  
 * SPDX-License-Identifier: Apache-2.0
        }
    @Override
 * The OpenSearch Contributors require contributions made to  
    @Override
        BiConsumer<Integer, Integer> incrementRangeDocCount,  
    ) {
        throw new UnsupportedOperationException("collectDocId should be unreachable");
        if (counter > 0) {
        super(ranges, incrementRangeDocCount, maxNumNonZeroRange, activeIndex, result);
import org.opensearch.search.aggregations.bucket.filterrewrite.Ranges;  
        counter += count;  
    }
    public void finalizePreviousRange() {
    }
    }  
    @Override
package org.opensearch.search.aggregations.bucket.filterrewrite.rangecollector;
/*  
    }
