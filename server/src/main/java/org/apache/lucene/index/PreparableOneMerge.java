 * SPDX-License-Identifier: Apache-2.0
    public Map<Long, long[]> packLiveDocsByGeneration(ToLongFunction<SegmentCommitInfo> generationOf) {
    void initMergeReaders(IOFunction<SegmentCommitInfo, MergePolicy.MergeReader> readerFactory) throws IOException {
            if (hardLive == null) {
 * compatible open source license.
                    bitSet.set(d);  
        Map<Long, long[]> result = new HashMap<>();  
            }
        return result;
 * and live-docs snapshot frozen via copy-on-write) ahead of {@link IndexWriter#merge}. The
import java.util.List;
        if (readers.isEmpty()) {  
        List<MergePolicy.MergeReader> readers = getMergeReader();
            result.put(gen, bitSet.getBits());  
import java.util.HashMap;  
     * Packs the per-segment frozen {@code hardLiveDocs} snapshot (FixedBitSet layout, bit set  
 * re-snapshotting. Lives in {@code org.apache.lucene.index} to access package-private  
        }
import java.util.Map;
 * A {@link MergePolicy.OneMerge} that supports being prepared (its merge readers populated  
            FixedBitSet bitSet = new FixedBitSet(maxDoc);  
                }
            for (int d = 0; d < maxDoc; d++) {
 */  
 * @opensearch.experimental  
 *
    public PreparableOneMerge(List<SegmentCommitInfo> segments) {  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.util.FixedBitSet;
     * result. Must be invoked after {@link #initMergeReaders} has populated the merge readers.
    }  
    @Override
package org.apache.lucene.index;
    private boolean readersInitialized = false;
public class PreparableOneMerge extends MergePolicy.OneMerge {
        readersInitialized = true;
            return;
                if (hardLive.get(d)) {
            int maxDoc = mr.reader.maxDoc();
 * Lucene internals.
    public boolean readersInitialized() {
    }  
     */  
        }
}
            }  
/*  
        super.initMergeReaders(readerFactory);  
 * idempotent {@link #initMergeReaders} override lets {@code mergeMiddle} re-enter without
 */
    /**
 *
        }
import org.apache.lucene.util.Bits;
import java.util.function.ToLongFunction;  
/**
            Bits hardLive = mr.hardLiveDocs;  
                continue;
            MergePolicy.MergeReader mr = readers.get(i);
import java.io.IOException;
        for (int i = 0; i < readers.size(); i++) {
 * The OpenSearch Contributors require contributions made to  
        if (readersInitialized) {  
    }
            long gen = generationOf.applyAsLong(segments.get(i));
    }
        super(segments);
            return Map.of();
import org.apache.lucene.util.IOFunction;  
     * = alive) keyed by application generation. Segments with no deletes are absent from the
        return readersInitialized;
