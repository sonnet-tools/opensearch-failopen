                lookup.setSegmentAndDocument(ctx, 0);
        try (Directory dir = newDirectory()) {
                LeafReaderContext ctx = reader.leaves().get(0);  
import org.apache.lucene.index.IndexWriterConfig;
                Map<String, Object> source = lookup.loadSourceIfNeeded();  
    }
import org.apache.lucene.index.LeafReaderContext;  
            }  
                doc.add(new StoredField("some_other_field", "data"));
 *
            Document doc = new Document();
import org.opensearch.common.lucene.index.SequentialStoredFieldsLeafReader;  
            }  
import org.opensearch.core.index.Index;
                lookup.setSegmentAndDocument(ctx, 0);
                SourceLookup lookup = new SourceLookup();  
            writer.addDocument(doc);
                assertTrue(ctx.reader() instanceof SequentialStoredFieldsLeafReader);
                Document doc = new Document();
                assertTrue(source.isEmpty());
                SourceLookup lookup = new SourceLookup();  
    public void testSetSegmentAndDocumentWithNewReaderDefersFieldReader() throws IOException {  
import org.apache.lucene.document.Document;
        try (Directory dir = newDirectory()) {  
                SourceLookup lookup = new SourceLookup();
                assertEquals("value", source.get("field"));
                lookup.setSegmentAndDocument(ctx, 0);
                lookup.setSegmentAndDocument(ctx, 0);
            try (IndexWriter writer = new IndexWriter(dir, new IndexWriterConfig())) {  
                lookup.setSegmentAndDocument(ctx2, 0);
import java.util.Map;
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
            try (DirectoryReader reader = DirectoryReader.open(dir)) {  
import org.apache.lucene.index.DirectoryReader;  
import org.opensearch.core.index.shard.ShardId;
            try (DirectoryReader rawReader = DirectoryReader.open(dir)) {
            writer.commit();
import java.nio.charset.StandardCharsets;  
    public void testLoadSourceWithNoSourceReturnsEmptyMap() throws IOException {
        }  
                LeafReaderContext ctx2 = reader2.leaves().get(0);  
            indexSourceDoc(dir, "{\"field\":\"value2\"}");  
        try (Directory dir1 = newDirectory(); Directory dir2 = newDirectory()) {
import org.apache.lucene.document.StoredField;
        }
            doc.add(new StoredField("_source", jsonSource.getBytes(StandardCharsets.UTF_8)));  
        }  
 * this file be licensed under the Apache-2.0 license or a
    private static void indexSourceDoc(Directory dir, String jsonSource) throws IOException {  
import java.io.IOException;
 * compatible open source license.
package org.opensearch.search.lookup;
                writer.commit();
                // Switch to a different reader — should reset fieldReader and source  
                assertEquals("1", lookup.loadSourceIfNeeded().get("a"));
                SourceLookup lookup = new SourceLookup();  
            indexSourceDoc(dir2, "{\"b\":\"2\"}");  
 * The OpenSearch Contributors require contributions made to  
            indexSourceDoc(dir, "{\"field\":\"value\"}");
import org.apache.lucene.index.IndexWriter;
import org.opensearch.test.OpenSearchTestCase;  
                LeafReaderContext ctx = reader.leaves().get(0);
        try (IndexWriter writer = new IndexWriter(dir, new IndexWriterConfig())) {
                assertSame(source, lookup.loadSourceIfNeeded());
                Map<String, Object> source = lookup.loadSourceIfNeeded();  
import org.apache.lucene.store.Directory;
    }
                assertFalse(ctx.reader() instanceof SequentialStoredFieldsLeafReader);
                LeafReaderContext ctx = wrappedReader.leaves().get(0);  
    }
 * SPDX-License-Identifier: Apache-2.0
        try (Directory dir = newDirectory()) {
            }
            indexSourceDoc(dir1, "{\"a\":\"1\"}");
                lookup.setSegmentAndDocument(ctx1, 0);  
    }
            }
            try (DirectoryReader reader = DirectoryReader.open(dir)) {
                // Same reader+doc — source should remain cached  
                Map<String, Object> source = lookup.loadSourceIfNeeded();  
                assertEquals("value2", source.get("field"));
                assertEquals("2", lookup.loadSourceIfNeeded().get("b"));
    public void testLazyFieldReaderWithRegularReader() throws IOException {
        }  
                LeafReaderContext ctx1 = reader1.leaves().get(0);
        }
            }
            try (DirectoryReader reader1 = DirectoryReader.open(dir1); DirectoryReader reader2 = DirectoryReader.open(dir2)) {
public class SourceLookupTests extends OpenSearchTestCase {  
 */  
    public void testLazyFieldReaderWithSequentialReader() throws IOException {
}
                writer.addDocument(doc);  
    }
/*  
                DirectoryReader wrappedReader = OpenSearchDirectoryReader.wrap(rawReader, new ShardId(new Index("test", "_na_"), 0));
