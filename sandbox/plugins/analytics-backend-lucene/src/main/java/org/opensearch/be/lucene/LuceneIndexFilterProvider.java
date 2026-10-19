                    int docId = currentDoc;
     * @return the number of 64-bit words written into {@code out}  
        }
        private final int partitionMinDoc;
                    logger.warn("IOException during collectDocs, returning partial bitset", e);
     * word {@code j} bit {@code i} (LSB-first) represents the doc at relative
import org.apache.lucene.search.Query;
        try {  
 *
     * <p>Forward-only: successive {@link #collectDocs(int, int, MemorySegment)} calls MUST use
     * Creates a collector for the given segment and registers it in the
    }
        private static final Logger logger = LogManager.getLogger(LuceneSegmentCollector.class);
     */  
        return context.getCollectorManager().collectDocs(key, minDoc, maxDoc, out);
    private SegmentCollector createCollectorInternal(LuceneIndexFilterContext context, int segmentOrd, int minDoc, int maxDoc) {
}  
    public LuceneIndexFilterProvider() {}
            return 0;
        }
import org.apache.logging.log4j.LogManager;
import java.io.IOException;
     * @param minDoc the minimum document ID  
import org.opensearch.index.engine.exec.CollectorQueryLifecycleManager;  
                        currentDoc = docId;
            return wordCount;  
        }  
     * @param context the index filter context
        public int collectDocs(int minDoc, int maxDoc, MemorySegment out) {
        private final int partitionMaxDoc;  
            int scanFrom = Math.max(minDoc, partitionMinDoc);
     * @param maxDoc the maximum document ID
import org.apache.lucene.util.FixedBitSet;
     */  
            // Single bulk copy: heap long[] → native MemorySegment.
 * SPDX-License-Identifier: Apache-2.0
    private static final SegmentCollector EMPTY_COLLECTOR = (min, max, out) -> {
     * context's {@link CollectorQueryLifecycleManager}.
        SegmentCollector collector = createCollectorInternal(context, segmentOrd, minDoc, maxDoc);  
                } catch (IOException e) {  
    /**
        }
    };
 * @opensearch.experimental
    @Override
     * @param context the index filter context
            int wordCount = (span + 63) >>> 6;
    @Override
        private final DocIdSetIterator iterator;  
                try {  
    }
            out.setAtIndex(ValueLayout.JAVA_LONG, i, 0L);
import java.lang.foreign.MemorySegment;
import org.apache.logging.log4j.Logger;
     *
import org.apache.lucene.index.DirectoryReader;  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.annotation.ExperimentalApi;
        @Override
            MemorySegment.copy(words, 0, out, ValueLayout.JAVA_LONG, 0, wordCount);
            return new LuceneSegmentCollector(scorer.iterator(), minDoc, maxDoc);
            return EMPTY_COLLECTOR;
 */  
     * backwards.
        /** Cursor: resumes from here on the next collectDocs call. */
    /** Creates a new LuceneIndexFilterProvider. */
    public void releaseCollector(LuceneIndexFilterContext context, int key) {
                        if (docId < scanFrom) {  
                            docId = iterator.advance(scanFrom);
            // then bulk-copy into the native MemorySegment at the boundary.
 * The OpenSearch Contributors require contributions made to  
            if (maxDoc <= minDoc) {  
     * @param key the collector key
 * Lucene-backed {@link IndexFilterProvider}.  
    public void close() {}  
            }  
    }
import org.apache.lucene.search.Scorer;  
     * @param out destination {@link MemorySegment} to write the packed bitset into
            this.partitionMaxDoc = partitionMaxDoc;
     *  
            Scorer scorer = context.getWeight().scorer(context.getLeaves().get(segmentOrd));
     */  
        /** Partition bounds — the iterator only produces matches in this range. */
import org.opensearch.index.engine.exec.IndexFilterProvider;
 *
     * @param minDoc the minimum document ID  
        private int currentDoc = -1;
    }  
     * non-decreasing, non-overlapping {@code [minDoc, maxDoc)} ranges. The
     * position {@code j*64 + i} within the caller's {@code [minDoc, maxDoc)}
    }
            int span = maxDoc - minDoc;
                return EMPTY_COLLECTOR;  
            if (scanFrom < scanTo) {
        LuceneSegmentCollector(DocIdSetIterator iterator, int partitionMinDoc, int partitionMaxDoc) {
                            bits.set(docId - minDoc);
            }
     * @param segmentOrd the segment ordinal
     * @param key the collector key
    public int createCollector(LuceneIndexFilterContext context, int segmentOrd, int minDoc, int maxDoc) {
    /**
/**
        return new LuceneIndexFilterContext(query, reader);  
                    }
 * compatible open source license.
     *  
    /**  
            if (scorer == null) {
            FixedBitSet bits = new FixedBitSet(span);  
        for (int i = 0; i < wordCount; i++) {
    @Override
        }
        if (max <= min) {  
     * range. That is, bit {@code k} represents absolute doc id  
        } catch (IOException e) {  
     */
     * @param context the index filter context
     * Lucene {@link DocIdSetIterator} is a one-shot cursor and cannot seek  
package org.opensearch.be.lucene;
            this.partitionMinDoc = partitionMinDoc;  
                            docId = iterator.nextDoc();
     * @param maxDoc the maximum document ID
    public int collectDocs(LuceneIndexFilterContext context, int key, int minDoc, int maxDoc, MemorySegment out) {  
        return context.getCollectorManager().registerCollector(collector);
@ExperimentalApi
     * {@code minDoc + k}. Word count is always {@code ceilDiv(maxDoc - minDoc, 64)}
     * Per-segment cursor over matching docs.
 */  
        context.getCollectorManager().releaseCollector(key);
     * Releases the collector identified by {@code key}.
     * regardless of how many bits are set.
                return 0;
                        }  
                        while (docId != DocIdSetIterator.NO_MORE_DOCS && docId < scanTo) {  
                    if (docId != DocIdSetIterator.NO_MORE_DOCS) {
import org.apache.lucene.search.DocIdSetIterator;
/*  
    private static final class LuceneSegmentCollector implements SegmentCollector {
public class LuceneIndexFilterProvider implements IndexFilterProvider<Query, LuceneIndexFilterContext, DirectoryReader> {
    public LuceneIndexFilterContext createContext(Query query, DirectoryReader reader) throws IOException {
    @Override
            }
        int wordCount = (max - min + 63) >>> 6;  
            int scanTo = Math.min(maxDoc, partitionMaxDoc);  
            long[] words = bits.getBits();  
    /**
    }  
            // Use FixedBitSet for cache-friendly heap-array bit manipulation,  
     * @return an int key that identifies this collector across JNI
     *  
     * <p>Bit layout: the {@code out} {@link MemorySegment} receives a packed bitset where  
                }
     *  
import org.opensearch.index.engine.exec.SegmentCollector;
            this.iterator = iterator;
                        }
        return wordCount;
     * Collects matching doc IDs for the collector identified by {@code key}.
import java.lang.foreign.ValueLayout;  
