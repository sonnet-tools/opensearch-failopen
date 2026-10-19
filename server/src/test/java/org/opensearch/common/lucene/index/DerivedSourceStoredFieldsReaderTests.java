import org.apache.lucene.index.StoredFields;  
    }  
    public void testClone() {  
            }  
        // Should not throw exception
            public void checkIntegrity() throws IOException {}
        reader = new DerivedSourceStoredFieldsReader(delegate, docId -> { throw new IOException("Test exception"); });
    }
package org.opensearch.common.lucene.index;
        writer.commit();
    public void testSourceProviderThrowsException() {  
            public StoredFieldsReader clone() {
    }
        StoredFieldVisitor visitor = new StoredFieldVisitor() {
import org.apache.lucene.codecs.StoredFieldsReader;
            }
                assertArrayEquals("Source field content should match", TEST_SOURCE, value);
 * SPDX-License-Identifier: Apache-2.0
        IndexWriterConfig config = newIndexWriterConfig(new MockAnalyzer(random()));
    public void testGetMergeInstance() {
                return this;  
        StoredFieldsReader mergeInstance = reader.getMergeInstance();  
    private static final int TEST_DOC_ID = 0;
            }
        StoredFieldVisitor visitor = new StoredFieldVisitor() {
        DirectoryReader dirReader = DirectoryReader.open(writer);
        dir = newDirectory();
                return Status.NO;
        delegate = new StoredFieldsReader() {
                fail("Binary field should not be called when source is not requested");  
        reader.document(TEST_DOC_ID, visitor);
        reader.document(TEST_DOC_ID, visitor);  
    }
    @Before
}
        writer = new IndexWriter(dir, config);  
 * The OpenSearch Contributors require contributions made to  
                storedFields.document(docID, visitor);
        StoredFieldVisitor visitor = new StoredFieldVisitor() {  
            public Status needsField(FieldInfo fieldInfo) {
import org.apache.lucene.index.FieldInfo;
        StoredFieldsReader cloned = reader.clone();
import org.apache.lucene.index.IndexWriterConfig;
    private StoredFieldsReader delegate;
            }
import org.opensearch.core.common.bytes.BytesArray;
        };  
            private final StoredFields storedFields = dirReader.leaves().get(0).reader().storedFields();  
import java.io.IOException;  
public class DerivedSourceStoredFieldsReaderTests extends OpenSearchTestCase {
        );  
                assertEquals("Field name should be _source", "_source", fieldInfo.name);  
        assertTrue("Source field should have been called", sourceCalled.get());  
            }
    public void testDocumentWithoutSourceFieldRequested() throws IOException {  
import org.apache.lucene.index.IndexWriter;  
import org.apache.lucene.document.StoredField;  
            }
            @Override
            @Override  
import org.opensearch.test.OpenSearchTestCase;
    private Directory dir;  
        };
import java.nio.charset.StandardCharsets;
 * compatible open source license.
 */  
    public void testCheckIntegrity() throws IOException {  
            @Override  
        super.setUp();  
    private IndexWriter writer;
import org.apache.lucene.document.Document;
    }
            }  
            @Override
 *
    }
        IOUtils.close(reader, writer, dir);
import org.opensearch.common.util.io.IOUtils;  
            public void binaryField(FieldInfo fieldInfo, byte[] value) {
    }
    public void tearDown() throws Exception {
import org.junit.After;  
            public void close() throws IOException {
        super.tearDown();  
        };
                return fieldInfo.name.equals("_source") ? Status.YES : Status.NO;  
            public void document(int docID, StoredFieldVisitor visitor) throws IOException {  
        assertNotNull("Merge instance should not be null", mergeInstance);
        doc.add(new StoredField("_source", TEST_SOURCE));  
import org.junit.Before;
import org.apache.lucene.tests.analysis.MockAnalyzer;
            "Cloned reader should be instance of DerivedSourceStoredFieldsReader",
                return Status.YES;
        assertTrue(  
            public void binaryField(FieldInfo fieldInfo, byte[] value) {
            @Override
            @Override  
import org.apache.lucene.index.StoredFieldVisitor;
    private static final byte[] TEST_SOURCE = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
        final AtomicBoolean sourceCalled = new AtomicBoolean(false);
    public void testDocumentWithSourceFieldRequested() throws IOException {
/*  
import org.apache.lucene.index.DirectoryReader;
        reader.checkIntegrity();
        expectThrows(IOException.class, () -> reader.document(TEST_DOC_ID, visitor));  
                dirReader.close();
            }
    }
 * this file be licensed under the Apache-2.0 license or a
    public void setUp() throws Exception {
            public Status needsField(FieldInfo fieldInfo) {
        Document doc = new Document();
        };
            public Status needsField(FieldInfo fieldInfo) {  
import org.apache.lucene.store.Directory;
import java.util.concurrent.atomic.AtomicBoolean;
        assertNotNull("Cloned reader should not be null", cloned);
            cloned instanceof DerivedSourceStoredFieldsReader
        writer.addDocument(doc);
    @After  
        reader = new DerivedSourceStoredFieldsReader(delegate, docId -> new BytesArray(TEST_SOURCE));  
            @Override
            @Override
                sourceCalled.set(true);
            @Override  
    private DerivedSourceStoredFieldsReader reader;  
