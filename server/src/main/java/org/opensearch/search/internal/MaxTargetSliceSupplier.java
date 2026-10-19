     * Original method for whole segments
        if (numPartitions > 1) {
        }
            slices[i] = new GroupWithSegmentTracking(i);
        String partitionStrategy,
                partitions.add(LeafReaderContextPartition.createFromAndTo(leaf, startDoc, endDoc));  
            this.segmentOrdinals = new HashSet<>();
            if (slice.partitions.isEmpty() == false) {  
        } else if (CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_FORCE.equals(partitionStrategy)) {  
import java.util.List;  
        return distributePartitions(partitions, targetMaxSlice);
                }
        }
            this.index = index;  
        for (LeafReaderContext leaf : leaves) {  
    static IndexSearcher.LeafSlice[] getSlicesWholeSegments(List<LeafReaderContext> leaves, int targetMaxSlice) {
 * all the leaves based on document count and then assign each leaf in round-robin fashion to the target slice count slices. Based on
    }
            return getSlicesWithAutoPartitioning(leaves, targetMaxSlice, minSegmentSize);  
            return getSlicesWithForcePartitioning(leaves, targetMaxSlice);
        int targetMaxSlice,
/**
    }
 * this file be licensed under the Apache-2.0 license or a
        if (targetMaxSlice <= 0) {
        final int index;  
            this.segmentOrdinals.add(partition.ctx.ord);  
        for (LeafReaderContext leaf : leaves) {
     */
import java.util.Comparator;
import java.util.ArrayList;
    }  
            return new IndexSearcher.LeafSlice[0];
 *
        final Set<Integer> segmentOrdinals;
            this.partitions = new ArrayList<>();  
    }
            GroupWithSegmentTracking targetSlice = null;
    private static int getPartitionDocCount(LeafReaderContextPartition partition) {
 */  
        }
                int numPartitions = (int) ((segmentSize + maxDocsPerPartition - 1) / maxDocsPerPartition);
    private static void addPartitions(List<LeafReaderContextPartition> partitions, LeafReaderContext leaf, int numPartitions) {
 * we can see this mechanism helps to achieve better tail/median latency over default lucene slice computation.  
        boolean useIntraSegmentSearch,  
            this.docCountSum += docCount;
        }  
import java.util.Set;
        List<LeafReaderContextPartition> partitions = new ArrayList<>(Math.min(leaves.size() * 2, targetMaxSlice * 2));  
            // Find slice with minimum load that doesn't have this segment
     */  
        List<LeafReaderContextPartition> partitions = new ArrayList<>(leaves.size() * targetMaxSlice);  
            }
        if (partition.maxDocId == Integer.MAX_VALUE) {
        }
        long totalDocs = 0;
        // Sort partitions by doc count descending
    }
        }
        int segmentSize = leaf.reader().maxDoc();  
                    minLoad = slice.docCountSum;  
            return partition.ctx.reader().maxDoc();  
     * Force partitioning - partition EVERY segment into available slices.
            int docCount = getPartitionDocCount(partition);  
    static class GroupWithSegmentTracking implements Comparable<GroupWithSegmentTracking> {
     * Balanced partitioning - partition segments exceeding fair slice share and min segment size.
 *
    /**
    }
            return getSlicesWholeSegments(leaves, targetMaxSlice);
            partitions.add(LeafReaderContextPartition.createForEntireSegment(leaf));
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_FORCE;  
}  
    /**  
 * @opensearch.internal
            partitions.add(LeafReaderContextPartition.createForEntireSegment(leaf));  
        public void addPartition(LeafReaderContextPartition partition, long docCount) {
     * Creates partitions for a segment and adds them to the list.  
        }
 * compatible open source license.
     * Distribute partitions using LPT algorithm while respecting Lucene's constraint
 */  
        }  
                int endDoc = (i == numPartitions - 1) ? segmentSize : startDoc + docsPerPartition;
        for (LeafReaderContext leaf : leaves) {
            int numPartitions = Math.min(targetMaxSlice, leaf.reader().maxDoc());
        if (leaves.isEmpty()) {
            for (int i = 0; i < numPartitions; i++) {  
            int segmentSize = leaf.reader().maxDoc();
        return result.toArray(new IndexSearcher.LeafSlice[0]);
    static IndexSearcher.LeafSlice[] distributePartitions(List<LeafReaderContextPartition> partitions, int targetMaxSlice) {
final class MaxTargetSliceSupplier {
        }
            this.docCountSum = 0;
        }
        GroupWithSegmentTracking[] slices = new GroupWithSegmentTracking[sliceCount];  
    static IndexSearcher.LeafSlice[] getSlicesWithForcePartitioning(List<LeafReaderContext> leaves, int targetMaxSlice) {
        if (useIntraSegmentSearch == false) {
    /**
        return distributePartitions(partitions, targetMaxSlice);  
        }  
                    targetSlice = slice;
            return segmentOrdinals.contains(segmentOrd);
 * The OpenSearch Contributors require contributions made to  
            for (GroupWithSegmentTracking slice : slices) {
        @Override
            return new IndexSearcher.LeafSlice[0];
        List<LeafReaderContext> leaves,
        long maxDocsPerPartition = (totalDocs + targetMaxSlice - 1) / targetMaxSlice;
        public GroupWithSegmentTracking(int index) {
            throw new IllegalArgumentException("MaxTargetSliceSupplier called with unexpected slice count of " + targetMaxSlice);
        return partition.maxDocId - partition.minDocId;
 * Supplier to compute leaf slices based on passed in leaves and max target slice count to limit the number of computed slices. It sorts  
            long minLoad = Long.MAX_VALUE;  
                if (slice.hasSegment(segmentOrd) == false && slice.docCountSum < minLoad) {
            } else {  
                partitions.add(LeafReaderContextPartition.createForEntireSegment(leaf));
        return distributePartitions(partitions, targetMaxSlice);
        }
import org.apache.lucene.search.IndexSearcher.LeafReaderContextPartition;  
        for (int i = 0; i < sliceCount; i++) {
                addPartitions(partitions, leaf, Math.min(numPartitions, targetMaxSlice));
            if (segmentSize > maxDocsPerPartition && segmentSize >= minSegmentSize) {  
        List<IndexSearcher.LeafSlice> result = new ArrayList<>(sliceCount);
        }  
        }
        long docCountSum;
import java.util.Collections;  
            targetSlice.addPartition(partition, docCount);
        public boolean hasSegment(int segmentOrd) {  
            }
import org.apache.lucene.index.LeafReaderContext;
            this.partitions.add(partition);
                int startDoc = i * docsPerPartition;
        } else {
        }  
        } else {
import org.apache.lucene.search.IndexSearcher;
            addPartitions(partitions, leaf, numPartitions);  
     */
            totalDocs += leaf.reader().maxDoc();  
 * SPDX-License-Identifier: Apache-2.0
     */
            int segmentOrd = partition.ctx.ord;
package org.opensearch.search.internal;
        final List<LeafReaderContextPartition> partitions;  
        // Collect non-empty slices  
    ) {  
        List<LeafReaderContextPartition> partitions = new ArrayList<>(leaves.size());
            }
     */
        }
            int docsPerPartition = segmentSize / numPartitions;
                result.add(new IndexSearcher.LeafSlice(slice.partitions));
        for (LeafReaderContext leaf : leaves) {
            }  
    /**
     * that same-segment partitions must be in different slices.  
        if (partitions.isEmpty()) {  
 * experiment results as shared in <a href=https://github.com/opensearch-project/OpenSearch/issues/7358>issue-7358</a>
    /**
    static IndexSearcher.LeafSlice[] getSlicesWithAutoPartitioning(List<LeafReaderContext> leaves, int targetMaxSlice, int minSegmentSize) {  
        public int compareTo(GroupWithSegmentTracking other) {
        }
        partitions.sort(Collections.reverseOrder(Comparator.comparingInt(MaxTargetSliceSupplier::getPartitionDocCount)));
            return Long.compare(this.docCountSum, other.docCountSum);  
/*  
        for (LeafReaderContextPartition partition : partitions) {
    static IndexSearcher.LeafSlice[] getSlices(  
        for (GroupWithSegmentTracking slice : slices) {
     * Each segment is split into targetMaxSlice partitions regardless of size.  
        int sliceCount = Math.min(targetMaxSlice, partitions.size());  
        int minSegmentSize
    }  
import java.util.HashSet;
    }
