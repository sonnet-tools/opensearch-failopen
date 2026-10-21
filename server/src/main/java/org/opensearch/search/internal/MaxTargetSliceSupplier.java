        int minSegmentSize
        @Override
        final List<LeafReaderContextPartition> partitions;
            return getSlicesWithAutoPartitioning(leaves, targetMaxSlice, minSegmentSize);
    /**
        }
        final Set<Integer> segmentOrdinals;
        } else if (CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_FORCE.equals(partitionStrategy)) {
    static IndexSearcher.LeafSlice[] getSlicesWithAutoPartitioning(List<LeafReaderContext> leaves, int targetMaxSlice, int minSegmentSize) {
            return new IndexSearcher.LeafSlice[0];
    /**
        return distributePartitions(partitions, targetMaxSlice);
                partitions.add(LeafReaderContextPartition.createFromAndTo(leaf, startDoc, endDoc));
    static IndexSearcher.LeafSlice[] getSlices(
        }
            return segmentOrdinals.contains(segmentOrd);
        }
                int endDoc = (i == numPartitions - 1) ? segmentSize : startDoc + docsPerPartition;
import java.util.List;
            throw new IllegalArgumentException("MaxTargetSliceSupplier called with unexpected slice count of " + targetMaxSlice);
            slices[i] = new GroupWithSegmentTracking(i);
        if (partitions.isEmpty()) {
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_FORCE;
        for (LeafReaderContext leaf : leaves) {
        long totalDocs = 0;
        List<LeafReaderContextPartition> partitions = new ArrayList<>(leaves.size());
import org.apache.lucene.search.IndexSearcher.LeafReaderContextPartition;
        }
        partitions.sort(Collections.reverseOrder(Comparator.comparingInt(MaxTargetSliceSupplier::getPartitionDocCount)));
 * all the leaves based on document count and then assign each leaf in round-robin fashion to the target slice count slices. Based on
        // Collect non-empty slices
            partitions.add(LeafReaderContextPartition.createForEntireSegment(leaf));
        public GroupWithSegmentTracking(int index) {
        List<LeafReaderContext> leaves,
import java.util.Set;
            for (int i = 0; i < numPartitions; i++) {
        public int compareTo(GroupWithSegmentTracking other) {
        for (LeafReaderContext leaf : leaves) {
 * compatible open source license.
        long docCountSum;
        }
            for (GroupWithSegmentTracking slice : slices) {
    }
        for (LeafReaderContext leaf : leaves) {
/**
            int segmentSize = leaf.reader().maxDoc();
        } else {
                if (slice.hasSegment(segmentOrd) == false && slice.docCountSum < minLoad) {
        for (LeafReaderContextPartition partition : partitions) {
        public boolean hasSegment(int segmentOrd) {
     */
            targetSlice.addPartition(partition, docCount);
        List<LeafReaderContextPartition> partitions = new ArrayList<>(leaves.size() * targetMaxSlice);
                int numPartitions = (int) ((segmentSize + maxDocsPerPartition - 1) / maxDocsPerPartition);
            if (slice.partitions.isEmpty() == false) {
            return getSlicesWholeSegments(leaves, targetMaxSlice);
        }
     * Each segment is split into targetMaxSlice partitions regardless of size.
        } else {
    }
        final int index;
        }
        boolean useIntraSegmentSearch,
     */
import java.util.ArrayList;
                    targetSlice = slice;
            this.segmentOrdinals.add(partition.ctx.ord);
        }
            }
import java.util.Collections;
import java.util.Comparator;
        List<LeafReaderContextPartition> partitions = new ArrayList<>(Math.min(leaves.size() * 2, targetMaxSlice * 2));
 *
            }
            totalDocs += leaf.reader().maxDoc();
 * experiment results as shared in <a href=https://github.com/opensearch-project/OpenSearch/issues/7358>issue-7358</a>
        String partitionStrategy,
        }
            int docCount = getPartitionDocCount(partition);
    /**
            this.index = index;
     * Original method for whole segments
            } else {
     * Distribute partitions using LPT algorithm while respecting Lucene's constraint
        for (LeafReaderContext leaf : leaves) {
 * SPDX-License-Identifier: Apache-2.0
 *
 * this file be licensed under the Apache-2.0 license or a
                partitions.add(LeafReaderContextPartition.createForEntireSegment(leaf));
    }
        }
            int segmentOrd = partition.ctx.ord;
}
        for (int i = 0; i < sliceCount; i++) {
     * Creates partitions for a segment and adds them to the list.
        long maxDocsPerPartition = (totalDocs + targetMaxSlice - 1) / targetMaxSlice;
    /**
        }
/*
     */
            // Find slice with minimum load that doesn't have this segment
        if (leaves.isEmpty()) {
            long minLoad = Long.MAX_VALUE;
import java.util.HashSet;
        }
    static IndexSearcher.LeafSlice[] getSlicesWholeSegments(List<LeafReaderContext> leaves, int targetMaxSlice) {
            addPartitions(partitions, leaf, numPartitions);
        }
    private static int getPartitionDocCount(LeafReaderContextPartition partition) {
    static class GroupWithSegmentTracking implements Comparable<GroupWithSegmentTracking> {
            return Long.compare(this.docCountSum, other.docCountSum);
        int targetMaxSlice,
            }
            this.segmentOrdinals = new HashSet<>();
        return distributePartitions(partitions, targetMaxSlice);
     * Force partitioning - partition EVERY segment into available slices.
 * The OpenSearch Contributors require contributions made to
        if (numPartitions > 1) {
    }
     */
    static IndexSearcher.LeafSlice[] distributePartitions(List<LeafReaderContextPartition> partitions, int targetMaxSlice) {
        if (useIntraSegmentSearch == false) {
package org.opensearch.search.internal;
        return distributePartitions(partitions, targetMaxSlice);
    /**
        if (targetMaxSlice <= 0) {
        }
        return partition.maxDocId - partition.minDocId;
        for (GroupWithSegmentTracking slice : slices) {
        if (partition.maxDocId == Integer.MAX_VALUE) {
        List<IndexSearcher.LeafSlice> result = new ArrayList<>(sliceCount);
                int startDoc = i * docsPerPartition;
final class MaxTargetSliceSupplier {
 * Supplier to compute leaf slices based on passed in leaves and max target slice count to limit the number of computed slices. It sorts
        // Sort partitions by doc count descending
            return new IndexSearcher.LeafSlice[0];
            }
        public void addPartition(LeafReaderContextPartition partition, long docCount) {
    }
     * Balanced partitioning - partition segments exceeding fair slice share and min segment size.
 */
 * @opensearch.internal
                addPartitions(partitions, leaf, Math.min(numPartitions, targetMaxSlice));
        int sliceCount = Math.min(targetMaxSlice, partitions.size());
            int numPartitions = Math.min(targetMaxSlice, leaf.reader().maxDoc());
            return partition.ctx.reader().maxDoc();
            partitions.add(LeafReaderContextPartition.createForEntireSegment(leaf));
        int segmentSize = leaf.reader().maxDoc();
    }
            this.docCountSum = 0;
        }
    ) {
     * that same-segment partitions must be in different slices.
     */
                result.add(new IndexSearcher.LeafSlice(slice.partitions));
        }
                }
        GroupWithSegmentTracking[] slices = new GroupWithSegmentTracking[sliceCount];
 * we can see this mechanism helps to achieve better tail/median latency over default lucene slice computation.
            this.partitions = new ArrayList<>();
                    minLoad = slice.docCountSum;
            if (segmentSize > maxDocsPerPartition && segmentSize >= minSegmentSize) {
        }
        return result.toArray(new IndexSearcher.LeafSlice[0]);
    }
            GroupWithSegmentTracking targetSlice = null;
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.search.IndexSearcher;
 */
    static IndexSearcher.LeafSlice[] getSlicesWithForcePartitioning(List<LeafReaderContext> leaves, int targetMaxSlice) {
            int docsPerPartition = segmentSize / numPartitions;
    }
            this.docCountSum += docCount;
    private static void addPartitions(List<LeafReaderContextPartition> partitions, LeafReaderContext leaf, int numPartitions) {
            return getSlicesWithForcePartitioning(leaves, targetMaxSlice);
            this.partitions.add(partition);
