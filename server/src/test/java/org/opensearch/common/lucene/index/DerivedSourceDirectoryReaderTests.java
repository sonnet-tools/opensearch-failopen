import java.nio.charset.StandardCharsets;  
    public void testSourceProviderCalls() throws IOException {  
    public void testWrap() throws IOException {
                    public Status needsField(FieldInfo fieldInfo) {
            Map<Integer, byte[]> segmentMap = new HashMap<>();
        // Create a map to store segment-based sources
        });
                        return fieldInfo.name.equals("_source") ? Status.YES : Status.NO;
        for (LeafReaderContext context : countingReader.leaves()) {
                    }  
        DirectoryReader wrapped = reader.doWrapDirectoryReader(directoryReader);  
        directoryReader = DirectoryReader.open(writer);
public class DerivedSourceDirectoryReaderTests extends OpenSearchTestCase {  
import org.opensearch.test.OpenSearchTestCase;
import org.apache.lucene.index.DirectoryReader;  
import org.apache.lucene.store.Directory;  
        IndexWriterConfig config = newIndexWriterConfig(random(), null).setMaxBufferedDocs(2) // Force multiple segments  
            super.tearDown();  
import org.opensearch.core.common.bytes.BytesArray;  
import org.junit.After;  
        reader = DerivedSourceDirectoryReader.wrap(directoryReader, (leafReader, docId) -> new BytesArray(TEST_SOURCE));  
        assertFalse("Should have at least one leaf", leaves.isEmpty());
import org.apache.lucene.document.Document;
        assertTrue("Leaf should be DerivedSourceLeafReader", leaves.get(0).reader() instanceof DerivedSourceLeafReader);
            Document doc = new Document();
                    @Override  
                final int globalDocId = context.docBase + i;  
        assertTrue("Should be DerivedSourceDirectoryReader", wrapped instanceof DerivedSourceDirectoryReader);
    @Override
        writer.commit();  
    public void testGetReaderCacheHelper() {
        // Access stored fields for all documents in all leaves
        int numDocs = randomIntBetween(5, 20);
import org.opensearch.common.CheckedBiFunction;
            StoredFields storedFields = context.reader().storedFields();  
                processedDocs++;
        }
            }
        int docBase = 0;  
            }
        Map<Integer, byte[]> docIdToSource = new HashMap<>();
            StoredFields storedFields = context.reader().storedFields();
                };  
        assertNotNull("Wrapped reader should not be null", reader);
        }
        dir = newDirectory();
            String leafKey = leafReader.toString();  
 * compatible open source license.
        IOUtils.close(derivedReader, multiReader, multiWriter, multiDir);
            }
    @After  
    }  
import org.apache.lucene.index.IndexWriterConfig;  
        writer = new IndexWriter(dir, config);
import java.util.HashMap;
import org.opensearch.core.common.bytes.BytesReference;
    private DirectoryReader directoryReader;
    public void setUp() throws Exception {  
    }  
                segmentMap.put(i, docIdToSource.get(docBase + i));
        Document doc = new Document();  
import org.apache.lucene.index.StoredFields;
            Map<Integer, byte[]> segmentMap = segmentSources.get(leafReader.toString());  
import org.apache.lucene.index.LeafReaderContext;
    public void testWithMultipleSegments() throws IOException {  
    @Override
import org.apache.lucene.document.StoredField;
        Map<String, Integer> leafCalls = new HashMap<>();
        assertTrue("Source provider should be called", sourceProviderCalls.get() > 0);
        assertNotNull("Wrapped reader should not be null", wrapped);
import org.apache.lucene.index.IndexWriter;
                final int localDocId = i;
    private static final byte[] TEST_SOURCE = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);  
import org.apache.lucene.index.FieldInfo;
        int processedDocs = 0;
import org.apache.lucene.index.LeafReader;
        };  
                    public Status needsField(FieldInfo fieldInfo) {
        }
                        assertArrayEquals("Source content should match for doc " + globalDocId, docIdToSource.get(globalDocId), value);
            for (int i = 0; i < context.reader().maxDoc(); i++) {
            .setMergePolicy(NoMergePolicy.INSTANCE);
        for (int i = 0; i < numDocs; i++) {
        CheckedBiFunction<LeafReader, Integer, BytesReference, IOException> countingSourceProvider = (leafReader, docId) -> {
        try {  
                storedFields.document(localDocId, visitor);
 */  
            docIdToSource.put(i, source);
        IndexWriter multiWriter = new IndexWriter(multiDir, config);
        doc.add(new StoredField("_source", TEST_SOURCE));
            return new BytesArray(TEST_SOURCE);
import java.util.List;
            for (int i = 0; i < context.reader().maxDoc(); i++) {
        writer.addDocument(doc);
    public void testDoWrapDirectoryReader() throws IOException {
    public void tearDown() throws Exception {
        // Verify all documents across all segments
 * The OpenSearch Contributors require contributions made to  
            leafCalls.merge(leafKey, 1, Integer::sum);
        super.setUp();
import java.io.IOException;
                        return fieldInfo.name.equals("_source") ? Status.YES : Status.NO;
import org.apache.lucene.index.NoMergePolicy;  
        AtomicInteger sourceProviderCalls = new AtomicInteger(0);
                    public void binaryField(FieldInfo fieldInfo, byte[] value) {  
                });
            for (int i = 0; i < ctx.reader().maxDoc(); i++) {  
        DirectoryReader multiReader = DirectoryReader.open(multiWriter);
        DerivedSourceDirectoryReader derivedReader = DerivedSourceDirectoryReader.wrap(multiReader, (leafReader, docId) -> {
    private IndexWriter writer;  
            }  
    private Directory dir;
 *
            byte[] source = randomByteArrayOfLength(randomIntBetween(10, 100));  
        Directory multiDir = newDirectory();
        IndexWriterConfig config = newIndexWriterConfig(random(), null);  
                    @Override
        // Add documents in multiple segments
                    }  
        assertEquals("Cache helper should match input reader", directoryReader.getReaderCacheHelper(), reader.getReaderCacheHelper());  
        List<LeafReaderContext> leaves = reader.leaves();  
                StoredFieldVisitor visitor = new StoredFieldVisitor() {
    }
        }
        DerivedSourceDirectoryReader countingReader = DerivedSourceDirectoryReader.wrap(directoryReader, countingSourceProvider);
 * this file be licensed under the Apache-2.0 license or a
                    @Override  
            // Use the segment-specific map to get the correct source
        for (LeafReaderContext ctx : multiReader.leaves()) {
        // Initialize segment sources
    }
                multiWriter.commit(); // Force new segment  
}
        }  
    private DerivedSourceDirectoryReader reader;
            IOUtils.close(reader, directoryReader, writer, dir);
            return new BytesArray(segmentMap.get(docId));
        assertEquals("Should have processed all documents", numDocs, processedDocs);  
 * SPDX-License-Identifier: Apache-2.0
        assertTrue("Should have multiple segments", multiReader.leaves().size() > 1);  
    }
                    }
                storedFields.document(i, new StoredFieldVisitor() {
import org.opensearch.common.util.io.IOUtils;
        // Create index with multiple segments
import java.util.Map;  
            docBase += ctx.reader().maxDoc();
            sourceProviderCalls.incrementAndGet();
    }
            multiWriter.addDocument(doc);
package org.opensearch.common.lucene.index;
        } finally {
        multiWriter.commit();  
/*  
        Map<String, Map<Integer, byte[]>> segmentSources = new HashMap<>();  
import org.apache.lucene.index.StoredFieldVisitor;
        assertFalse("Should have leaf calls recorded", leafCalls.isEmpty());  
            segmentSources.put(ctx.reader().toString(), segmentMap);  
    }
            doc.add(new StoredField("_source", source));  
            if (rarely()) {
import java.util.concurrent.atomic.AtomicInteger;
        for (LeafReaderContext context : derivedReader.leaves()) {  
