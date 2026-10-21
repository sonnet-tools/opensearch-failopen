import java.util.ArrayList;
            // Create 1 large segment (1000 docs) that exceeds minSegmentSize
            try (DirectoryReader directoryReader = DirectoryReader.open(directory)) {
        }
        try (
                Document document = new Document();
            final Directory directory = newDirectory();
                assertEquals(4, slices.length);
                List<LeafReaderContext> leaves = directoryReader.leaves();
        }
            iw.commit();
    }
            for (int i = 0; i < 50; ++i) {
            iw.commit();
        );
            )
    }
                Document document = new Document();
            final IndexWriter iw = new IndexWriter(
import org.apache.lucene.document.Document;
                assertEquals(1, slices[1].partitions.length);
        try (
                assertEquals(1, slices[0].partitions.length);
                assertEquals(1, slices[0].partitions.length);
                assertEquals(25, slices[0].getMaxDocs());
    public void testGetSlicesWithForceStrategy() throws Exception {
        int expectedLeavesInOtherSlice = 2;
        for (int i = 0; i < expectedSliceCount; ++i) {
            }
 * compatible open source license.
            } else {
import org.apache.lucene.index.IndexWriterConfig;
            }
                assertEquals(2, slices.length);
        IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlicesWholeSegments(new ArrayList<>(), 2);
        assertEquals(expectedSliceCount, slices.length);
        IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlices(leaves, 2, false, "segment", 100);
        }
        }
        ) {
                assertEquals(250, slices[0].getMaxDocs());
                assertEquals(expectedLeavesInOtherSlice, slices[i].partitions.length);
            for (int i = 0; i < 3; ++i) {
    public void testSliceCountGreaterThanLeafCount() throws Exception {
                iw.addDocument(document);
                List<LeafReaderContext> leaves = directoryReader.leaves();
            final IndexWriter iw = new IndexWriter(
                Document document = new Document();
import org.apache.lucene.document.Field;
        try (
        ) {
                iw.addDocument(document);
            try (DirectoryReader directoryReader = DirectoryReader.open(directory)) {
 * SPDX-License-Identifier: Apache-2.0
            )
                // minSegmentSize=100 → only large segment (400 docs) gets partitioned into 2
        int expectedLeavesInFirst2Slice = 3;
        }
        IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlicesWholeSegments(getLeaves(leafCount), 1);
            }
                assertEquals(1, leaves.size());
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(NoMergePolicy.INSTANCE)
    public void testForcePartitioningMultipleSegments() throws Exception {
            iw.commit();
        }
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(NoMergePolicy.INSTANCE)
        IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlicesWholeSegments(leaves, expectedSliceCount);
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(NoMergePolicy.INSTANCE)
                assertEquals(25, slices[3].getMaxDocs());
import org.apache.lucene.document.StringField;
                iw.addDocument(document);
                directory,
            }
    }
                assertEquals(250, slices[3].getMaxDocs());
                for (IndexSearcher.LeafSlice slice : slices) {
                assertEquals(50, slices[1].getMaxDocs());
                assertEquals(1, slices[2].partitions.length);
                Document document = new Document();
            final String fieldValue = "value";
            final Directory directory = newDirectory();
                iw.addDocument(document);
                directory,
import org.opensearch.test.OpenSearchTestCase;
 */
    public void testOptimizedGroup() throws Exception {
            }
    public void testEmptyLeavesForcePartitioning() {
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(NoMergePolicy.INSTANCE)
            final IndexWriter iw = new IndexWriter(
                directory,
                Document document = new Document();
                // Force partitions each segment into 4 partitions = 8 total, distributed to 4 slices
    }
                directory,
        assertEquals(expectedSliceCount, slices.length);
                assertEquals(2, slices[1].partitions.length);
            iw.commit();
            }
                iw.addDocument(document);
            for (int i = 0; i < 1; ++i) {
        try (
        int leafCount = 12;
                List<LeafReaderContext> leaves = directoryReader.leaves();
                iw.addDocument(document);
        assertEquals(0, slices.length);
                assertEquals(250, slices[0].getMaxDocs());
                assertEquals(250, slices[0].getMaxDocs());
            )
import org.apache.lucene.store.Directory;
        int leafCount = randomIntBetween(1, 10);
        int expectedSliceCount = 2;
            final Directory directory = newDirectory();
import org.apache.lucene.search.IndexSearcher;
                IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlicesWithAutoPartitioning(leaves, 4, 100);
            final Directory directory = newDirectory();
            final IndexWriter iw = new IndexWriter(
                IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlices(leaves, 4, true, "force", 100);
        try (
                IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlices(leaves, 4, true, "balanced", 100);
    }
/*
                assertEquals(1, slices[0].partitions.length);
                assertEquals(25, slices[0].getMaxDocs());
        int expectedSliceCount = 3;
            }
        int expectedLeavesPerSlice = leafCount / expectedSliceCount;
                    assertEquals(1, slice.partitions.length);
    }
                // Total partitions = 2 (from large) + 2 (small whole) = 4, distributed to 2 slices
        IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlicesWithForcePartitioning(new ArrayList<>(), 4);
                assertEquals(1, slices[0].partitions.length);
                assertEquals(250, slices[2].getMaxDocs());
    public void testForcePartitioningSingleSegment() throws Exception {
            iw.commit();
                assertEquals(1, leaves.size());
            try (DirectoryReader directoryReader = DirectoryReader.open(directory)) {
    }
    }
            for (int i = 0; i < 50; ++i) {
                directory,
                document.add(new StringField("field1", "value", Field.Store.NO));
        }
        ) {
                assertEquals(50, slices[3].getMaxDocs());
            iw.commit();
            final Directory directory = newDirectory();
    }
                assertEquals(1, slices[2].partitions.length);
                assertEquals(2, slices[1].getMaxDocs());
    }
        // Case 2: test with first 2 slice more leaves than others
            for (int i = 0; i < 100; ++i) {
            final Directory directory = newDirectory();
        for (int i = 0; i < expectedSliceCount; ++i) {
            )
                assertEquals(4, slices.length);
                Document document = new Document();
        assertEquals(2, slices.length);
                IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlicesWithForcePartitioning(leaves, 4);
            final IndexWriter iw = new IndexWriter(
        }
        assertEquals(1, slices.length);
    }
    public void testEmptyLeaves() {
    public void testBalancedPartitioningLargeSegment() throws Exception {
                assertEquals(2, slices.length);
            for (int i = 0; i < 1000; ++i) {
                assertEquals(25, slices[1].getMaxDocs());
                Document document = new Document();
                assertEquals(2, leaves.size());
                // Small segments (50 docs each) stay whole
}
        IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlicesWithAutoPartitioning(new ArrayList<>(), 4, 100);
        try (
                assertEquals(3, leaves.size());
            for (int i = 0; i < 100; ++i) {
                document.add(new StringField("field1", "value", Field.Store.NO));
            for (int i = 0; i < 100; ++i) {
                document.add(new StringField("field1", "value", Field.Store.NO));
                iw.addDocument(document);
                iw.addDocument(document);
                document.add(new StringField("field1", fieldValue, Field.Store.NO));
                document.add(new StringField("field1", "value", Field.Store.NO));
                assertEquals(2, slices[0].partitions.length);
        assertEquals(0, slices.length);
                }
            }
                assertEquals(2, slices[0].partitions.length);
                assertEquals(4, slices.length);
            }
        }
            iw.commit();
                document.add(new StringField("field1", fieldValue, Field.Store.NO));
            final IndexWriter iw = new IndexWriter(
            // Create 1 large segment (400 docs) and 2 small segments (50 docs each)
                assertEquals(2, slices[1].partitions.length);
        assertThrows(
            try (DirectoryReader directoryReader = DirectoryReader.open(directory)) {
                assertEquals(1, slices[1].partitions.length);
                assertEquals(250, slices[2].getMaxDocs());
    public void testDistributePartitionsEmpty() {
            for (int i = 0; i < 1000; ++i) {
                assertEquals(25, slices[2].getMaxDocs());
                Document document = new Document();
                assertEquals(1, slices[3].partitions.length);
            try (DirectoryReader directoryReader = DirectoryReader.open(directory)) {
                assertEquals(1, slices[1].partitions.length);
    public void testSameSegmentPartitionsInDifferentSlices() throws Exception {
            }
                document.add(new StringField("field1", fieldValue, Field.Store.NO));
            iw.commit();
                assertEquals(50, slices[2].getMaxDocs());
                assertEquals(1, slices[0].partitions.length);
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(NoMergePolicy.INSTANCE)
                directory,
                List<LeafReaderContext> leaves = directoryReader.leaves();
    public void testGetSlicesWithBalancedStrategy() throws Exception {
            for (int i = 0; i < 1; ++i) {
            )
        // Case 1: test with equal number of leaves per slice
    public void testBalancedPartitioningSmallSegmentSkipped() throws Exception {
            final IndexWriter iw = new IndexWriter(
    public void testSingleSliceWithMultipleLeaves() throws Exception {
        try (
                iw.addDocument(document);
import org.apache.lucene.index.LeafReaderContext;
                List<LeafReaderContext> leaves = directoryReader.leaves();
            }
            )
            try (DirectoryReader directoryReader = DirectoryReader.open(directory)) {
    public void testEmptyLeavesAutoPartitioning() {
                iw.addDocument(document);
                assertEquals(1, slices[3].partitions.length);
                assertEquals(2, slices[2].partitions.length);
                assertEquals(250, slices[1].getMaxDocs());
            assertEquals(1, slices[i].partitions.length);
            IllegalArgumentException.class,
                // Each slice has 1 partition with 25 docs
            try (DirectoryReader directoryReader = DirectoryReader.open(directory)) {
    public void testNegativeSliceCount() {
            )
            for (int i = 0; i < 100; ++i) {
                document.add(new StringField("field1", "value", Field.Store.NO));
            final Directory directory = newDirectory();
            iw.commit();
        ) {
            }
            final IndexWriter iw = new IndexWriter(
 * this file be licensed under the Apache-2.0 license or a
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(NoMergePolicy.INSTANCE)
                iw.addDocument(document);
                List<LeafReaderContext> leaves = directoryReader.leaves();
                IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlices(leaves, 2, true, "balanced", 100);
    }
                directory,
import org.apache.lucene.analysis.standard.StandardAnalyzer;
                assertEquals(2, slices[1].partitions.length);
                document.add(new StringField("field1", "value", Field.Store.NO));
    }
    public void testSliceCountLessThanLeafCount() throws Exception {
                Document document = new Document();
        List<LeafReaderContext> leaves = getLeaves(leafCount);
            iw.commit();
        ) {
            }
    public void testGetSlicesWithBalancedStrategyMultipleSegments() throws Exception {
        }
                assertEquals(3, slices[0].getMaxDocs());
        ) {
        List<LeafReaderContext> leaves = getLeaves(4);
                assertEquals(50, slices[0].getMaxDocs());
                Document document = new Document();
        for (int i = 0; i < expectedSliceCount; ++i) {
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(NoMergePolicy.INSTANCE)
        expectedSliceCount = 5;
                IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlicesWithAutoPartitioning(leaves, 4, 100);
            try (DirectoryReader directoryReader = DirectoryReader.open(directory)) {
                assertEquals(250, slices[1].getMaxDocs());
            // Create 2 segments with 100 docs each
                List<LeafReaderContext> leaves = directoryReader.leaves();
    }
import static org.opensearch.search.internal.IndexReaderUtils.getLeaves;
            iw.commit();
                assertEquals(250, slices[3].getMaxDocs());
package org.opensearch.search.internal;
                List<LeafReaderContext> leaves = directoryReader.leaves();
        try (
                assertEquals(25, slices[2].getMaxDocs());
                directory,
                Document document = new Document();
        IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.distributePartitions(new ArrayList<>(), 4);
            }
                assertEquals(25, slices[1].getMaxDocs());
        assertEquals(0, slices.length);
    public void testGetSlicesWithNoneStrategy() throws Exception {
                Document document = new Document();
            }
    }
            for (int i = 0; i < 50; ++i) {
                directory,
                assertEquals(250, slices[1].getMaxDocs());
                document.add(new StringField("field1", "value", Field.Store.NO));
            iw.commit();
                document.add(new StringField("field1", "value", Field.Store.NO));
        assertEquals(expectedSliceCount, slices.length);
import org.apache.lucene.index.IndexWriter;
                assertEquals(1, slices[2].partitions.length);
                assertEquals(expectedLeavesInFirst2Slice, slices[i].partitions.length);
            }
                IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlicesWholeSegments(leaves, 2);
                assertEquals(1, slices.length);
                assertEquals(1, slices[0].partitions.length);
                List<LeafReaderContext> leaves = directoryReader.leaves();
            if (i < 2) {
            try (DirectoryReader directoryReader = DirectoryReader.open(directory)) {
    }
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(NoMergePolicy.INSTANCE)
                assertEquals(2, slices[3].partitions.length);
            }
                iw.addDocument(document);
                IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlicesWithForcePartitioning(leaves, 4);
import org.apache.lucene.index.DirectoryReader;
                assertEquals(4, slices.length);
                iw.addDocument(document);
            )
import org.apache.lucene.index.NoMergePolicy;
            iw.commit();
        ) {
                Document document = new Document();
            final IndexWriter iw = new IndexWriter(
                assertEquals(4, slices.length);
                iw.addDocument(document);
                // 1 segment of 100 docs → 4 partitions of 25 docs each
                document.add(new StringField("field1", "value", Field.Store.NO));
                document.add(new StringField("field1", "value", Field.Store.NO));
        IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlicesWholeSegments(getLeaves(expectedSliceCount), 5);
                assertEquals(3, leaves.size());
            }
                document.add(new StringField("field1", "value", Field.Store.NO));
                Document document = new Document();
            for (int i = 0; i < 400; ++i) {
            }
    }
        }
            }
            for (int i = 0; i < 100; ++i) {
                assertEquals(1, slices[2].partitions.length);
            }
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(NoMergePolicy.INSTANCE)
public class MaxTargetSliceSupplierTests extends OpenSearchTestCase {
            assertEquals(expectedLeavesPerSlice, slices[i].partitions.length);
            }
                assertEquals(1, slices[1].partitions.length);
        ) {
            )
                assertEquals(1, slices[3].partitions.length);
            }
            () -> MaxTargetSliceSupplier.getSlices(new ArrayList<>(), randomIntBetween(-3, 0), true, "force", 100)
                assertEquals(1, slices[3].partitions.length);
        try (
            final Directory directory = newDirectory();
            final Directory directory = newDirectory();
 *
        ) {
 * The OpenSearch Contributors require contributions made to
import java.util.List;
        }
                assertEquals(1, leaves.size());
        assertEquals(leafCount, slices[0].partitions.length);
        assertEquals(0, slices.length);
                assertEquals(25, slices[3].getMaxDocs());
            iw.commit();
            }
        slices = MaxTargetSliceSupplier.getSlicesWholeSegments(leaves, expectedSliceCount);
    }
                IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlicesWithForcePartitioning(leaves, 4);
