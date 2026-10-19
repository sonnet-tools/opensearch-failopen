                counter++;
        long bucketOrd = getBucketOrd.apply(activeIndex);
        throw new UnsupportedOperationException("countNode should be unreachable");
import java.util.function.Function;  
        } catch (IOException e) {
                bitSet.set(doc);
import org.opensearch.search.aggregations.LeafBucketCollector;  
    @Override  
    ) {
            }  
 * The OpenSearch Contributors require contributions made to  
    }
    private boolean isDocLive(int docId) {  
        // trigger the sub agg collection for this range
        try {  
    }  
        int activeIndex,  
import org.opensearch.search.aggregations.BucketCollector;
    @Override
        return liveDocs == null || liveDocs.get(docId);
import java.util.function.BiConsumer;
public class SubAggRangeCollector extends SimpleRangeCollector {
        this.liveDocs = leafCtx.reader().getLiveDocs();  
        }
import org.apache.logging.log4j.LogManager;
    private final BucketCollector collectableSubAggregators;
import org.apache.lucene.util.Bits;  
        // Explicitly OR iter intoBitSet to filter out deleted docs  
            counter++;
 * SPDX-License-Identifier: Apache-2.0
    @Override
        bitSet = new FixedBitSet(leafCtx.reader().maxDoc());
            bitSet.set(docId);  
            throw new RuntimeException(e);  
        super(ranges, incrementRangeDocCount, maxNumNonZeroRange, activeIndex, result);
        logger.trace("finalize range {} with bucket ordinal {}", activeIndex, bucketOrd);  
import org.apache.logging.log4j.Logger;
        FilterRewriteOptimizationContext.OptimizeResult result,
        Function<Integer, Long> getBucketOrd,
    }
    public SubAggRangeCollector(
 *
    private final Bits liveDocs;
import java.io.IOException;
        super.finalizePreviousRange();  
/**
    }
    private final Function<Integer, Long> getBucketOrd;  
            if (isDocLive(doc)) {  
 */
        FilterRewriteOptimizationContext.SubAggCollectorParam subAggCollectorParam  
        }
            logger.trace("collected sub aggregation for bucket {}", bucketOrd);
        this.leafCtx = subAggCollectorParam.leafCtx();
 * compatible open source license.
}
import org.apache.lucene.util.FixedBitSet;
    private static final Logger logger = LogManager.getLogger(SubAggRangeCollector.class);
    public void countNode(int count) {
        if (isDocLive(docId)) {
import org.apache.lucene.index.LeafReaderContext;  
    public void collectDocId(int docId) {  
    public boolean hasSubAgg() {
        this.collectableSubAggregators = subAggCollectorParam.collectableSubAggregators();
package org.opensearch.search.aggregations.bucket.filterrewrite.rangecollector;
/*  
            LeafBucketCollector sub = collectableSubAggregators.getLeafCollector(leafCtx);
            sub.collect(DocIdStreamHelper.getDocIdStream(bitSet), bucketOrd);  
import org.apache.lucene.search.DocIdStreamHelper;
        this.getBucketOrd = getBucketOrd;  
        throw new UnsupportedOperationException("countNode should be unreachable");  
    }
    @Override
    @Override
    public void finalizePreviousRange() {
 * Range collector implementation that supports sub-aggregations by collecting doc IDs.  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.search.DocIdSetIterator;
    public void collectDocIdSet(DocIdSetIterator iter) throws IOException {
    private final FixedBitSet bitSet;  
        return true;  
import org.opensearch.search.aggregations.bucket.filterrewrite.FilterRewriteOptimizationContext;
        for (int doc = iter.docID(); doc < DocIdSetIterator.NO_MORE_DOCS; doc = iter.nextDoc()) {
    private final LeafReaderContext leafCtx;  
    @Override
        bitSet.clear();  
            // build a new leaf collector for each bucket
 */  
        }
        Ranges ranges,  
        iter.nextDoc();
        BiConsumer<Integer, Integer> incrementRangeDocCount,
    }
import org.opensearch.search.aggregations.bucket.filterrewrite.Ranges;
    }
    public void count() {
    }
        int maxNumNonZeroRange,
