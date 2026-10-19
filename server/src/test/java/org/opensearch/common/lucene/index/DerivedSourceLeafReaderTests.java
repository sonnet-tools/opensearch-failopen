}
                return in.getReaderCacheHelper();
    public void testGetSequentialStoredFieldsReaderWithSequentialReader() throws IOException {
                public void binaryField(FieldInfo fieldInfo, byte[] value) {
    private Directory dir;
        randomWriter.forceMerge(1);
 */  
    public void testGetSequentialStoredFieldsReaderWithCodecReader() throws IOException {
        StoredFields storedFields = randomDerivedReader.storedFields();
import java.nio.charset.StandardCharsets;
        super.setUp();
        };
        assertNotNull("StoredFields should not be null", storedFields);
    }
        assertEquals("Should have exactly one segment", 1, randomDirectoryReader.leaves().size());
import org.apache.lucene.index.FieldInfo;  
            protected StoredFieldsReader doGetSequentialStoredFieldsReader(StoredFieldsReader reader) {
            public CacheHelper getReaderCacheHelper() {
import org.apache.lucene.index.CodecReader;
    public void testWithRandomDocuments() throws IOException {
import org.apache.lucene.index.StoredFields;  
            @Override  
    }  
                return ((CodecReader) in).getFieldsReader();  
import org.apache.lucene.document.Document;
        Document doc = new Document();
        LeafReader randomLeafReader = randomDirectoryReader.leaves().get(0).reader();
        assertEquals("Core cache helper should match input reader", leafReader.getCoreCacheHelper(), reader.getCoreCacheHelper());  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.util.io.IOUtils;
            doc.add(new StoredField("field", i));
    private DerivedSourceLeafReader reader;
    }  
    private LeafReader leafReader;
import org.opensearch.core.common.bytes.BytesReference;  
/*  
                public Status needsField(FieldInfo fieldInfo) {  
                return reader;  
    }
        assertNotNull("Sequential reader should not be null", sequentialReader);
        IOUtils.close(directoryReader, writer, dir);
import org.apache.lucene.index.FilterLeafReader;
        }
import org.apache.lucene.codecs.StoredFieldsReader;
import org.apache.lucene.index.DirectoryReader;
            public CacheHelper getReaderCacheHelper() {  
        for (int i = 0; i < numDocs; i++) {
            public CacheHelper getCoreCacheHelper() {
    public void setUp() throws Exception {
            }  
        );
    private static final byte[] TEST_SOURCE = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);  
        assertNotNull("Sequential reader should not be null", sequentialReader);  
        );
            byte[] source = randomByteArrayOfLength(randomIntBetween(10, 50));
            public CacheHelper getCoreCacheHelper() {
            };
        writer = new IndexWriter(dir, config);
        DerivedSourceLeafReader randomDerivedReader = new DerivedSourceLeafReader(
            }  
                return in.getCoreCacheHelper();
        DirectoryReader randomDirectoryReader = DirectoryReader.open(randomWriter);
            @Override  
            sequentialReader instanceof DerivedSourceStoredFieldsReader  
    public void testGetSequentialStoredFieldsReaderWithInvalidReader() {
        writer.addDocument(doc);  
        super.tearDown();
 * this file be licensed under the Apache-2.0 license or a
                @Override
            @Override
        writer.commit();
            randomWriter.addDocument(doc);  
            "Sequential reader should be DerivedSourceStoredFieldsReader",  
        doc.add(new StoredField("_source", TEST_SOURCE));
        // Force merge into a single segment  
    private DirectoryReader directoryReader;  
        IOUtils.close(randomDirectoryReader, randomWriter, randomDir);  
            @Override
        Map<Integer, byte[]> docIdToSource = new HashMap<>();
            @Override
import org.opensearch.common.CheckedFunction;  
        int numDocs = randomIntBetween(1, 10);
        expectThrows(IOException.class, invalidDerivedReader::getSequentialStoredFieldsReader);
        assumeTrue("Test requires CodecReader", leafReader instanceof CodecReader);  
    }
            }
        };
import org.opensearch.test.OpenSearchTestCase;
        leafReader = directoryReader.leaves().get(0).reader();
            Document doc = new Document();
            StoredFieldVisitor visitor = new StoredFieldVisitor() {
            docIdToSource.put(i, source);  
        assertTrue(
import java.io.IOException;  
            public StoredFieldsReader getSequentialStoredFieldsReader() throws IOException {
    public void tearDown() throws Exception {  
 *
    private IndexWriter writer;
            sequentialReader instanceof DerivedSourceStoredFieldsReader
                    assertArrayEquals("Source content should match for doc " + currentDocId, docIdToSource.get(currentDocId), value);  
                    return fieldInfo.name.equals("_source") ? Status.YES : Status.NO;
            "StoredFields should be DerivedSourceStoredFields",  
            final int currentDocId = docId;  
import java.util.HashMap;
        reader = new DerivedSourceLeafReader(leafReader, sourceProvider);
        LeafReader invalidReader = new FilterLeafReader(leafReader) {  
import org.apache.lucene.index.IndexWriterConfig;  
            @Override
        );
            storedFields instanceof DerivedSourceStoredFieldsReader.DerivedSourceStoredFields
            storedFields.document(docId, visitor);  
        DerivedSourceLeafReader invalidDerivedReader = new DerivedSourceLeafReader(invalidReader, sourceProvider);  
public class DerivedSourceLeafReaderTests extends OpenSearchTestCase {
        assertEquals("Reader cache helper should match input reader", leafReader.getReaderCacheHelper(), reader.getReaderCacheHelper());
        // Create a wrapped SequentialStoredFieldsLeafReader
            }
        DerivedSourceLeafReader sequentialDerivedReader = new DerivedSourceLeafReader(sequentialLeafReader, sourceProvider);
        for (int docId = 0; docId < numDocs; docId++) {
        IndexWriterConfig config = newIndexWriterConfig(random(), null).setCodec(new RandomCodec(random()));  
    }  
        StoredFields storedFields = reader.storedFields();  
import org.apache.lucene.tests.index.RandomCodec;
        assertTrue(
        Directory randomDir = newDirectory();
    public void testStoredFields() throws IOException {
        IndexWriterConfig config = newIndexWriterConfig(random(), null).setCodec(new RandomCodec(random()));
    @Override  
                return in.getReaderCacheHelper();
            randomLeafReader,  
 * compatible open source license.
        IndexWriter randomWriter = new IndexWriter(randomDir, config);
    }  
    }  
package org.opensearch.common.lucene.index;
    @Override
        }
                }
            "Sequential reader should be DerivedSourceStoredFieldsReader",
            }
                }
 * SPDX-License-Identifier: Apache-2.0
                @Override
        directoryReader = DirectoryReader.open(writer);  
        StoredFieldsReader sequentialReader = reader.getSequentialStoredFieldsReader();
    private final CheckedFunction<Integer, BytesReference, IOException> sourceProvider = docId -> new BytesArray(TEST_SOURCE);
import org.apache.lucene.index.LeafReader;
        StoredFieldsReader sequentialReader = sequentialDerivedReader.getSequentialStoredFieldsReader();
import java.util.Map;  
        dir = newDirectory();  
            }
    public void testGetCoreAndReaderCacheHelper() {
                return in.getCoreCacheHelper();  
        LeafReader sequentialLeafReader = new SequentialStoredFieldsLeafReader(leafReader) {  
        randomWriter.commit();
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.StoredFieldVisitor;
import org.apache.lucene.store.Directory;
        assertTrue(
import org.apache.lucene.document.StoredField;  
        );
import org.opensearch.core.common.bytes.BytesArray;
            docId -> new BytesArray(docIdToSource.get(docId))
