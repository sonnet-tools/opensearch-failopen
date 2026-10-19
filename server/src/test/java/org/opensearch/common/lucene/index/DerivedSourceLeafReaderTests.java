        assertTrue(
        dir = newDirectory();
        randomWriter.forceMerge(1);
import org.apache.lucene.index.FieldInfo;
        for (int docId = 0; docId < numDocs; docId++) {
        doc.add(new StoredField("_source", TEST_SOURCE));
    }
 *
 * this file be licensed under the Apache-2.0 license or a
            "Sequential reader should be DerivedSourceStoredFieldsReader",
            public CacheHelper getReaderCacheHelper() {
            @Override
package org.opensearch.common.lucene.index;
    private DirectoryReader directoryReader;
        LeafReader sequentialLeafReader = new SequentialStoredFieldsLeafReader(leafReader) {
        IOUtils.close(randomDirectoryReader, randomWriter, randomDir);
        }
        }
        leafReader = directoryReader.leaves().get(0).reader();
            }
        reader = new DerivedSourceLeafReader(leafReader, sourceProvider);
        assertEquals("Core cache helper should match input reader", leafReader.getCoreCacheHelper(), reader.getCoreCacheHelper());
import org.apache.lucene.index.IndexWriter;
        DerivedSourceLeafReader invalidDerivedReader = new DerivedSourceLeafReader(invalidReader, sourceProvider);
            storedFields instanceof DerivedSourceStoredFieldsReader.DerivedSourceStoredFields
        StoredFieldsReader sequentialReader = reader.getSequentialStoredFieldsReader();
        Document doc = new Document();
        );
/*
        // Create a wrapped SequentialStoredFieldsLeafReader
                    return fieldInfo.name.equals("_source") ? Status.YES : Status.NO;
import org.apache.lucene.document.Document;
import org.apache.lucene.tests.index.RandomCodec;
            sequentialReader instanceof DerivedSourceStoredFieldsReader
    private final CheckedFunction<Integer, BytesReference, IOException> sourceProvider = docId -> new BytesArray(TEST_SOURCE);
 * The OpenSearch Contributors require contributions made to
import org.opensearch.core.common.bytes.BytesArray;
public class DerivedSourceLeafReaderTests extends OpenSearchTestCase {
            randomLeafReader,
        expectThrows(IOException.class, invalidDerivedReader::getSequentialStoredFieldsReader);
        assertTrue(
 */
            public CacheHelper getCoreCacheHelper() {
    @Override
import org.apache.lucene.document.StoredField;
            byte[] source = randomByteArrayOfLength(randomIntBetween(10, 50));
        assumeTrue("Test requires CodecReader", leafReader instanceof CodecReader);
        LeafReader randomLeafReader = randomDirectoryReader.leaves().get(0).reader();
            "Sequential reader should be DerivedSourceStoredFieldsReader",
            final int currentDocId = docId;
import org.apache.lucene.index.DirectoryReader;
                return in.getCoreCacheHelper();
            @Override
        IndexWriterConfig config = newIndexWriterConfig(random(), null).setCodec(new RandomCodec(random()));
            public CacheHelper getReaderCacheHelper() {
        };
    }
        assertNotNull("StoredFields should not be null", storedFields);
    }
        DirectoryReader randomDirectoryReader = DirectoryReader.open(randomWriter);
            "StoredFields should be DerivedSourceStoredFields",
            }
        randomWriter.commit();
        writer = new IndexWriter(dir, config);
                }
    }
    public void testGetSequentialStoredFieldsReaderWithSequentialReader() throws IOException {
            StoredFieldVisitor visitor = new StoredFieldVisitor() {
        );
            public StoredFieldsReader getSequentialStoredFieldsReader() throws IOException {
        int numDocs = randomIntBetween(1, 10);
        super.tearDown();
    }
        IOUtils.close(directoryReader, writer, dir);
    private static final byte[] TEST_SOURCE = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
    public void testWithRandomDocuments() throws IOException {
        IndexWriterConfig config = newIndexWriterConfig(random(), null).setCodec(new RandomCodec(random()));
    }
        assertNotNull("Sequential reader should not be null", sequentialReader);
        for (int i = 0; i < numDocs; i++) {
            storedFields.document(docId, visitor);
    public void testGetSequentialStoredFieldsReaderWithInvalidReader() {
            docIdToSource.put(i, source);
import java.util.HashMap;
    public void tearDown() throws Exception {
import java.util.Map;
import org.opensearch.core.common.bytes.BytesReference;
                @Override
                public Status needsField(FieldInfo fieldInfo) {
                return in.getReaderCacheHelper();
import org.apache.lucene.index.LeafReader;
                return in.getReaderCacheHelper();
import java.nio.charset.StandardCharsets;
            };
        writer.addDocument(doc);
            randomWriter.addDocument(doc);
            }
        assertEquals("Reader cache helper should match input reader", leafReader.getReaderCacheHelper(), reader.getReaderCacheHelper());
                return reader;
        directoryReader = DirectoryReader.open(writer);
    private DerivedSourceLeafReader reader;
        IndexWriter randomWriter = new IndexWriter(randomDir, config);
        DerivedSourceLeafReader randomDerivedReader = new DerivedSourceLeafReader(
import org.opensearch.test.OpenSearchTestCase;
        Directory randomDir = newDirectory();
}
    private Directory dir;
import org.apache.lucene.index.FilterLeafReader;
        );
                @Override
                }
import org.apache.lucene.codecs.StoredFieldsReader;
    public void testGetSequentialStoredFieldsReaderWithCodecReader() throws IOException {
            protected StoredFieldsReader doGetSequentialStoredFieldsReader(StoredFieldsReader reader) {
            sequentialReader instanceof DerivedSourceStoredFieldsReader
            @Override
    }
        };
            public CacheHelper getCoreCacheHelper() {
                return in.getCoreCacheHelper();
 * compatible open source license.
                return ((CodecReader) in).getFieldsReader();
            }
import org.opensearch.common.util.io.IOUtils;
 * SPDX-License-Identifier: Apache-2.0
            }
import org.apache.lucene.store.Directory;
import java.io.IOException;
        LeafReader invalidReader = new FilterLeafReader(leafReader) {
        assertTrue(
            @Override
    public void testStoredFields() throws IOException {
        );
            }
import org.apache.lucene.index.CodecReader;
                    assertArrayEquals("Source content should match for doc " + currentDocId, docIdToSource.get(currentDocId), value);
            @Override
    private LeafReader leafReader;
        Map<Integer, byte[]> docIdToSource = new HashMap<>();
            Document doc = new Document();
    public void testGetCoreAndReaderCacheHelper() {
        StoredFieldsReader sequentialReader = sequentialDerivedReader.getSequentialStoredFieldsReader();
import org.apache.lucene.index.IndexWriterConfig;
        assertEquals("Should have exactly one segment", 1, randomDirectoryReader.leaves().size());
import org.apache.lucene.index.StoredFields;
        super.setUp();
        StoredFields storedFields = randomDerivedReader.storedFields();
import org.opensearch.common.CheckedFunction;
        StoredFields storedFields = reader.storedFields();
        // Force merge into a single segment
    }
            docId -> new BytesArray(docIdToSource.get(docId))
    public void setUp() throws Exception {
    @Override
            @Override
                public void binaryField(FieldInfo fieldInfo, byte[] value) {
    private IndexWriter writer;
import org.apache.lucene.index.StoredFieldVisitor;
        DerivedSourceLeafReader sequentialDerivedReader = new DerivedSourceLeafReader(sequentialLeafReader, sourceProvider);
        assertNotNull("Sequential reader should not be null", sequentialReader);
            doc.add(new StoredField("field", i));
        writer.commit();
