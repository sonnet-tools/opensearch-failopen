                assertEquals(2, slices[0].partitions.length);
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(NoMergePolicy.INSTANCE)
                iw.addDocument(document);  
        IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlicesWithAutoPartitioning(new ArrayList<>(), 4, 100);
            final Directory directory = newDirectory();  
                // minSegmentSize=100 → only large segment (400 docs) gets partitioned into 2  
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(NoMergePolicy.INSTANCE)
        int expectedLeavesInFirst2Slice = 3;
    }
            }
import java.util.List;  
                assertEquals(1, slices.length);
    public void testNegativeSliceCount() {  
                document.add(new StringField("field1", "value", Field.Store.NO));
                iw.addDocument(document);
        }
            iw.commit();
                directory,
                assertEquals(1, slices[2].partitions.length);  
                directory,
        ) {
        }  
            try (DirectoryReader directoryReader = DirectoryReader.open(directory)) {  
    public void testGetSlicesWithBalancedStrategyMultipleSegments() throws Exception {  
        int expectedLeavesPerSlice = leafCount / expectedSliceCount;
        IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlicesWholeSegments(leaves, expectedSliceCount);
        }
                iw.addDocument(document);  
import org.apache.lucene.index.LeafReaderContext;
                assertEquals(4, slices.length);
                assertEquals(250, slices[3].getMaxDocs());  
        int leafCount = 12;  
            }  
        }
            for (int i = 0; i < 1000; ++i) {  
                List<LeafReaderContext> leaves = directoryReader.leaves();
        try (
                List<LeafReaderContext> leaves = directoryReader.leaves();
                List<LeafReaderContext> leaves = directoryReader.leaves();
            try (DirectoryReader directoryReader = DirectoryReader.open(directory)) {
                directory,  
                assertEquals(1, slices[0].partitions.length);
        }
 * The OpenSearch Contributors require contributions made to  
                assertEquals(250, slices[1].getMaxDocs());
    public void testSliceCountLessThanLeafCount() throws Exception {
import org.apache.lucene.document.Document;
            try (DirectoryReader directoryReader = DirectoryReader.open(directory)) {  
        for (int i = 0; i < expectedSliceCount; ++i) {
                IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlicesWithForcePartitioning(leaves, 4);
        for (int i = 0; i < expectedSliceCount; ++i) {
        IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlicesWholeSegments(getLeaves(leafCount), 1);  
        try (
        IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlicesWithForcePartitioning(new ArrayList<>(), 4);
                assertEquals(250, slices[3].getMaxDocs());
                assertEquals(250, slices[2].getMaxDocs());
            }
            iw.commit();  
        assertEquals(0, slices.length);
                Document document = new Document();
        assertEquals(2, slices.length);
    }
                iw.addDocument(document);  
                Document document = new Document();
                iw.addDocument(document);
/*  
        try (  
                assertEquals(25, slices[2].getMaxDocs());
        assertEquals(0, slices.length);  
                assertEquals(1, slices[3].partitions.length);  
                assertEquals(250, slices[0].getMaxDocs());
        }
                // Small segments (50 docs each) stay whole
            for (int i = 0; i < 3; ++i) {  
                }
                directory,
            )
            final IndexWriter iw = new IndexWriter(
            }  
            try (DirectoryReader directoryReader = DirectoryReader.open(directory)) {  
                assertEquals(2, slices.length);
            } else {
import org.apache.lucene.index.DirectoryReader;
                iw.addDocument(document);  
    }  
                iw.addDocument(document);
    }
            assertEquals(1, slices[i].partitions.length);
                IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlicesWithAutoPartitioning(leaves, 4, 100);  
                assertEquals(2, leaves.size());  
import static org.opensearch.search.internal.IndexReaderUtils.getLeaves;
                assertEquals(4, slices.length);
                Document document = new Document();
                assertEquals(2, slices[1].partitions.length);
                directory,  
            for (int i = 0; i < 1000; ++i) {
                document.add(new StringField("field1", "value", Field.Store.NO));
        IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.distributePartitions(new ArrayList<>(), 4);  
    }  
        slices = MaxTargetSliceSupplier.getSlicesWholeSegments(leaves, expectedSliceCount);  
                assertEquals(expectedLeavesInFirst2Slice, slices[i].partitions.length);  
                IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlices(leaves, 4, true, "balanced", 100);
                Document document = new Document();
            final Directory directory = newDirectory();  
                List<LeafReaderContext> leaves = directoryReader.leaves();
                iw.addDocument(document);  
        List<LeafReaderContext> leaves = getLeaves(leafCount);
                iw.addDocument(document);  
            }
            for (int i = 0; i < 400; ++i) {  
            final Directory directory = newDirectory();
                document.add(new StringField("field1", "value", Field.Store.NO));  
import org.apache.lucene.index.IndexWriterConfig;
                document.add(new StringField("field1", fieldValue, Field.Store.NO));
        try (
                document.add(new StringField("field1", fieldValue, Field.Store.NO));
            for (int i = 0; i < 50; ++i) {  
        int leafCount = randomIntBetween(1, 10);
    public void testOptimizedGroup() throws Exception {  
            iw.commit();
            }
    public void testGetSlicesWithNoneStrategy() throws Exception {
                assertEquals(3, leaves.size());
public class MaxTargetSliceSupplierTests extends OpenSearchTestCase {
                assertEquals(1, slices[0].partitions.length);
                assertEquals(1, slices[3].partitions.length);
    public void testSameSegmentPartitionsInDifferentSlices() throws Exception {
        try (
                assertEquals(50, slices[3].getMaxDocs());
 * compatible open source license.
                assertEquals(250, slices[0].getMaxDocs());  
    }
        try (
                assertEquals(25, slices[3].getMaxDocs());  
            try (DirectoryReader directoryReader = DirectoryReader.open(directory)) {
            try (DirectoryReader directoryReader = DirectoryReader.open(directory)) {
        ) {
                directory,
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(NoMergePolicy.INSTANCE)  
            }
            final Directory directory = newDirectory();
                    assertEquals(1, slice.partitions.length);
                assertEquals(2, slices[1].getMaxDocs());
            }
                assertEquals(25, slices[2].getMaxDocs());  
                Document document = new Document();
    }  
        }
        ) {  
        int expectedLeavesInOtherSlice = 2;
    public void testBalancedPartitioningLargeSegment() throws Exception {
        assertEquals(expectedSliceCount, slices.length);  
        try (  
            )  
                iw.addDocument(document);  
            final IndexWriter iw = new IndexWriter(
                Document document = new Document();
                List<LeafReaderContext> leaves = directoryReader.leaves();
                // Total partitions = 2 (from large) + 2 (small whole) = 4, distributed to 2 slices
package org.opensearch.search.internal;
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(NoMergePolicy.INSTANCE)
                iw.addDocument(document);  
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(NoMergePolicy.INSTANCE)  
                // Force partitions each segment into 4 partitions = 8 total, distributed to 4 slices
    }  
        assertEquals(expectedSliceCount, slices.length);  
import org.apache.lucene.index.IndexWriter;  
        }
            final IndexWriter iw = new IndexWriter(  
                IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlices(leaves, 2, true, "balanced", 100);  
                assertEquals(1, slices[0].partitions.length);
                document.add(new StringField("field1", "value", Field.Store.NO));
            }
                assertEquals(1, slices[1].partitions.length);  
        assertEquals(leafCount, slices[0].partitions.length);
                assertEquals(4, slices.length);
            }  
                IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlicesWholeSegments(leaves, 2);  
            iw.commit();
            }
                assertEquals(1, leaves.size());
                assertEquals(1, slices[1].partitions.length);
            iw.commit();  
                assertEquals(1, slices[0].partitions.length);
                assertEquals(1, slices[2].partitions.length);
                assertEquals(250, slices[1].getMaxDocs());
                assertEquals(1, slices[2].partitions.length);
        for (int i = 0; i < expectedSliceCount; ++i) {
                directory,
                assertEquals(4, slices.length);  
            IllegalArgumentException.class,
        assertThrows(
                assertEquals(1, leaves.size());  
}  
            }  
            }
            )
            iw.commit();  
import java.util.ArrayList;
    public void testForcePartitioningSingleSegment() throws Exception {
            )
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(NoMergePolicy.INSTANCE)
        }
                assertEquals(3, leaves.size());
        ) {
        }  
                assertEquals(25, slices[0].getMaxDocs());  
            for (int i = 0; i < 50; ++i) {  
        try (
            if (i < 2) {
                iw.addDocument(document);  
                Document document = new Document();
 * this file be licensed under the Apache-2.0 license or a
                document.add(new StringField("field1", "value", Field.Store.NO));
            iw.commit();
                iw.addDocument(document);
                document.add(new StringField("field1", "value", Field.Store.NO));  
                IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlices(leaves, 4, true, "force", 100);  
                assertEquals(25, slices[1].getMaxDocs());
            )
            try (DirectoryReader directoryReader = DirectoryReader.open(directory)) {
            final IndexWriter iw = new IndexWriter(
            final IndexWriter iw = new IndexWriter(
                Document document = new Document();
    public void testEmptyLeaves() {
                document.add(new StringField("field1", "value", Field.Store.NO));  
import org.apache.lucene.analysis.standard.StandardAnalyzer;
        assertEquals(0, slices.length);
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(NoMergePolicy.INSTANCE)  
            for (int i = 0; i < 1; ++i) {  
    public void testDistributePartitionsEmpty() {
        List<LeafReaderContext> leaves = getLeaves(4);  
                assertEquals(25, slices[1].getMaxDocs());
                document.add(new StringField("field1", "value", Field.Store.NO));
            for (int i = 0; i < 100; ++i) {
        ) {  
        ) {  
    public void testGetSlicesWithForceStrategy() throws Exception {
            for (int i = 0; i < 100; ++i) {  
                assertEquals(250, slices[1].getMaxDocs());  
                assertEquals(1, slices[0].partitions.length);  
                assertEquals(1, slices[3].partitions.length);
        assertEquals(0, slices.length);  
            for (int i = 0; i < 100; ++i) {
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(NoMergePolicy.INSTANCE)  
                for (IndexSearcher.LeafSlice slice : slices) {  
            final IndexWriter iw = new IndexWriter(
            }
            final IndexWriter iw = new IndexWriter(
                Document document = new Document();
        IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlicesWholeSegments(new ArrayList<>(), 2);
                assertEquals(2, slices.length);
                Document document = new Document();
        ) {
            }
    }  
        }  
            }  
                assertEquals(2, slices[0].partitions.length);
                assertEquals(25, slices[0].getMaxDocs());
        int expectedSliceCount = 2;
            for (int i = 0; i < 100; ++i) {
            iw.commit();
            for (int i = 0; i < 50; ++i) {
            try (DirectoryReader directoryReader = DirectoryReader.open(directory)) {  
            final IndexWriter iw = new IndexWriter(  
            for (int i = 0; i < 1; ++i) {  
                iw.addDocument(document);
    public void testEmptyLeavesAutoPartitioning() {  
    }
                assertEquals(250, slices[2].getMaxDocs());
                IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlicesWithAutoPartitioning(leaves, 4, 100);
                Document document = new Document();
    }
    }
    }  
import org.apache.lucene.document.StringField;
            )
            iw.commit();  
            }
        IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlices(leaves, 2, false, "segment", 100);
            assertEquals(expectedLeavesPerSlice, slices[i].partitions.length);
                directory,  
            iw.commit();
                assertEquals(1, slices[1].partitions.length);
import org.apache.lucene.search.IndexSearcher;
            }
            for (int i = 0; i < 100; ++i) {  
                assertEquals(2, slices[1].partitions.length);
        expectedSliceCount = 5;
            iw.commit();
            final Directory directory = newDirectory();  
            iw.commit();
                document.add(new StringField("field1", "value", Field.Store.NO));
                assertEquals(250, slices[0].getMaxDocs());  
    }
                document.add(new StringField("field1", fieldValue, Field.Store.NO));
            try (DirectoryReader directoryReader = DirectoryReader.open(directory)) {  
            final Directory directory = newDirectory();
            }
    public void testSliceCountGreaterThanLeafCount() throws Exception {  
    public void testForcePartitioningMultipleSegments() throws Exception {
            // Create 2 segments with 100 docs each  
    public void testEmptyLeavesForcePartitioning() {
                // 1 segment of 100 docs → 4 partitions of 25 docs each  
 * SPDX-License-Identifier: Apache-2.0
    }
            // Create 1 large segment (1000 docs) that exceeds minSegmentSize
                assertEquals(2, slices[2].partitions.length);
            final Directory directory = newDirectory();
        ) {
            )
    public void testGetSlicesWithBalancedStrategy() throws Exception {
                Document document = new Document();
                assertEquals(4, slices.length);
    }
                assertEquals(expectedLeavesInOtherSlice, slices[i].partitions.length);
            }
                List<LeafReaderContext> leaves = directoryReader.leaves();
        try (  
        // Case 2: test with first 2 slice more leaves than others
                assertEquals(50, slices[0].getMaxDocs());
            )
 *
    public void testSingleSliceWithMultipleLeaves() throws Exception {
                List<LeafReaderContext> leaves = directoryReader.leaves();  
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(NoMergePolicy.INSTANCE)
                // Each slice has 1 partition with 25 docs  
import org.apache.lucene.store.Directory;
            final String fieldValue = "value";
    }
        IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlicesWholeSegments(getLeaves(expectedSliceCount), 5);
import org.apache.lucene.index.NoMergePolicy;  
            () -> MaxTargetSliceSupplier.getSlices(new ArrayList<>(), randomIntBetween(-3, 0), true, "force", 100)  
                assertEquals(1, slices[3].partitions.length);
                assertEquals(50, slices[1].getMaxDocs());
 */  
                IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlicesWithForcePartitioning(leaves, 4);
            final IndexWriter iw = new IndexWriter(
                List<LeafReaderContext> leaves = directoryReader.leaves();
    public void testBalancedPartitioningSmallSegmentSkipped() throws Exception {
        assertEquals(1, slices.length);
    }
                assertEquals(1, slices[1].partitions.length);
            }
            iw.commit();
                assertEquals(50, slices[2].getMaxDocs());  
                assertEquals(1, leaves.size());
                assertEquals(1, slices[0].partitions.length);  
                List<LeafReaderContext> leaves = directoryReader.leaves();
        int expectedSliceCount = 3;  
                directory,
            final Directory directory = newDirectory();  
        );
                assertEquals(2, slices[1].partitions.length);  
            }
            }  
            )  
            final Directory directory = newDirectory();
        assertEquals(expectedSliceCount, slices.length);  
import org.opensearch.test.OpenSearchTestCase;  
        ) {
        }
                document.add(new StringField("field1", "value", Field.Store.NO));  
            iw.commit();
                assertEquals(25, slices[3].getMaxDocs());
                Document document = new Document();  
                assertEquals(3, slices[0].getMaxDocs());  
import org.apache.lucene.document.Field;  
            // Create 1 large segment (400 docs) and 2 small segments (50 docs each)
        // Case 1: test with equal number of leaves per slice
                document.add(new StringField("field1", "value", Field.Store.NO));
                IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlicesWithForcePartitioning(leaves, 4);
            }  
                assertEquals(2, slices[3].partitions.length);
                assertEquals(1, slices[2].partitions.length);  
                Document document = new Document();
