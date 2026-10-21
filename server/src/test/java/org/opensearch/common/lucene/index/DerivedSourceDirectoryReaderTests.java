/*
            docIdToSource.put(i, source);
 */
                        assertArrayEquals("Source content should match for doc " + globalDocId, docIdToSource.get(globalDocId), value);
        DerivedSourceDirectoryReader countingReader = DerivedSourceDirectoryReader.wrap(directoryReader, countingSourceProvider);
 * SPDX-License-Identifier: Apache-2.0
        assertFalse("Should have leaf calls recorded", leafCalls.isEmpty());
        // Access stored fields for all documents in all leaves
        // Add documents in multiple segments
import org.apache.lucene.document.StoredField;
import org.apache.lucene.index.LeafReader;
import org.apache.lucene.index.IndexWriterConfig;
                    }
import org.junit.After;
    }
            for (int i = 0; i < ctx.reader().maxDoc(); i++) {
    public void testWithMultipleSegments() throws IOException {
            for (int i = 0; i < context.reader().maxDoc(); i++) {
                processedDocs++;
            Map<Integer, byte[]> segmentMap = segmentSources.get(leafReader.toString());
import java.nio.charset.StandardCharsets;
            }
    public void testSourceProviderCalls() throws IOException {
        }
        int numDocs = randomIntBetween(5, 20);
        int processedDocs = 0;
                storedFields.document(i, new StoredFieldVisitor() {
import org.apache.lucene.index.NoMergePolicy;
        });
        for (LeafReaderContext context : derivedReader.leaves()) {
import org.opensearch.core.common.bytes.BytesArray;
            }
            Document doc = new Document();
    }
    public void testDoWrapDirectoryReader() throws IOException {
    private DerivedSourceDirectoryReader reader;
        };
        Map<Integer, byte[]> docIdToSource = new HashMap<>();
        // Initialize segment sources
    }
import org.opensearch.test.OpenSearchTestCase;
                segmentMap.put(i, docIdToSource.get(docBase + i));
        IndexWriter multiWriter = new IndexWriter(multiDir, config);
        for (LeafReaderContext context : countingReader.leaves()) {
        assertTrue("Should have multiple segments", multiReader.leaves().size() > 1);
            return new BytesArray(segmentMap.get(docId));
        try {
import org.opensearch.common.util.io.IOUtils;
        Map<String, Map<Integer, byte[]>> segmentSources = new HashMap<>();
import org.apache.lucene.index.LeafReaderContext;
package org.opensearch.common.lucene.index;
        DirectoryReader wrapped = reader.doWrapDirectoryReader(directoryReader);
            String leafKey = leafReader.toString();
                };
        DerivedSourceDirectoryReader derivedReader = DerivedSourceDirectoryReader.wrap(multiReader, (leafReader, docId) -> {
import java.util.Map;
        assertNotNull("Wrapped reader should not be null", reader);
        }
import org.apache.lucene.document.Document;
        }
        dir = newDirectory();
    private static final byte[] TEST_SOURCE = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
            StoredFields storedFields = context.reader().storedFields();
 * this file be licensed under the Apache-2.0 license or a
    }
}
    private IndexWriter writer;
                        return fieldInfo.name.equals("_source") ? Status.YES : Status.NO;
            IOUtils.close(reader, directoryReader, writer, dir);
        Document doc = new Document();
        multiWriter.commit();
        Directory multiDir = newDirectory();
            if (rarely()) {
    public void testGetReaderCacheHelper() {
        // Create a map to store segment-based sources
import org.opensearch.common.CheckedBiFunction;
 *
import org.apache.lucene.index.IndexWriter;
        for (int i = 0; i < numDocs; i++) {
        assertNotNull("Wrapped reader should not be null", wrapped);
                storedFields.document(localDocId, visitor);
        reader = DerivedSourceDirectoryReader.wrap(directoryReader, (leafReader, docId) -> new BytesArray(TEST_SOURCE));
            return new BytesArray(TEST_SOURCE);
        super.setUp();
                final int globalDocId = context.docBase + i;
        Map<String, Integer> leafCalls = new HashMap<>();
import org.opensearch.core.common.bytes.BytesReference;
            sourceProviderCalls.incrementAndGet();
import org.apache.lucene.index.FieldInfo;
        }
            leafCalls.merge(leafKey, 1, Integer::sum);
        writer.commit();
            // Use the segment-specific map to get the correct source
                    public Status needsField(FieldInfo fieldInfo) {
        assertEquals("Cache helper should match input reader", directoryReader.getReaderCacheHelper(), reader.getReaderCacheHelper());
import org.apache.lucene.index.StoredFieldVisitor;
        // Verify all documents across all segments
import org.apache.lucene.index.StoredFields;
import java.util.concurrent.atomic.AtomicInteger;
        doc.add(new StoredField("_source", TEST_SOURCE));
            doc.add(new StoredField("_source", source));
                    }
            Map<Integer, byte[]> segmentMap = new HashMap<>();
        assertTrue("Should be DerivedSourceDirectoryReader", wrapped instanceof DerivedSourceDirectoryReader);
            docBase += ctx.reader().maxDoc();
    }
                    }
    public void setUp() throws Exception {
                    public Status needsField(FieldInfo fieldInfo) {
import java.io.IOException;
    private DirectoryReader directoryReader;
                    @Override
        for (LeafReaderContext ctx : multiReader.leaves()) {
 * The OpenSearch Contributors require contributions made to
        int docBase = 0;
                        return fieldInfo.name.equals("_source") ? Status.YES : Status.NO;
    }
        assertTrue("Source provider should be called", sourceProviderCalls.get() > 0);
            StoredFields storedFields = context.reader().storedFields();
        CheckedBiFunction<LeafReader, Integer, BytesReference, IOException> countingSourceProvider = (leafReader, docId) -> {
    @Override
            for (int i = 0; i < context.reader().maxDoc(); i++) {
 * compatible open source license.
        assertTrue("Leaf should be DerivedSourceLeafReader", leaves.get(0).reader() instanceof DerivedSourceLeafReader);
        IndexWriterConfig config = newIndexWriterConfig(random(), null).setMaxBufferedDocs(2) // Force multiple segments
    private Directory dir;
        assertEquals("Should have processed all documents", numDocs, processedDocs);
    public void tearDown() throws Exception {
        IndexWriterConfig config = newIndexWriterConfig(random(), null);
            multiWriter.addDocument(doc);
            }
            .setMergePolicy(NoMergePolicy.INSTANCE);
        } finally {
                multiWriter.commit(); // Force new segment
            }
    @Override
        }
    @After
    public void testWrap() throws IOException {
                    @Override
        writer = new IndexWriter(dir, config);
        assertFalse("Should have at least one leaf", leaves.isEmpty());
            byte[] source = randomByteArrayOfLength(randomIntBetween(10, 100));
                final int localDocId = i;
public class DerivedSourceDirectoryReaderTests extends OpenSearchTestCase {
            segmentSources.put(ctx.reader().toString(), segmentMap);
        DirectoryReader multiReader = DirectoryReader.open(multiWriter);
        IOUtils.close(derivedReader, multiReader, multiWriter, multiDir);
import java.util.HashMap;
import org.apache.lucene.store.Directory;
                    @Override
        directoryReader = DirectoryReader.open(writer);
        List<LeafReaderContext> leaves = reader.leaves();
import org.apache.lucene.index.DirectoryReader;
    }
                });
            super.tearDown();
        writer.addDocument(doc);
import java.util.List;
                    public void binaryField(FieldInfo fieldInfo, byte[] value) {
        AtomicInteger sourceProviderCalls = new AtomicInteger(0);
                StoredFieldVisitor visitor = new StoredFieldVisitor() {
        // Create index with multiple segments
