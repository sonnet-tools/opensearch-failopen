 * ownership. Elasticsearch licenses this file to you under  
     */  
        assertThat(fieldsOrder.get(1), equalTo("#id"));  
    /**
import org.apache.lucene.util.BytesRef;
        IndexSearcher searcher = new IndexSearcher(reader);  
        for (int i = 0; i < 100; i++) {
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * this file be licensed under the Apache-2.0 license or a
        TopFieldDocs docs = searcher.search(new MatchAllDocsQuery(), 10, new Sort(new SortField("str", SortField.Type.STRING)));  
 * software distributed under the License is distributed on an
        f = doc.getField("test");
        assertThat(fieldsOrder.size(), equalTo(2));
        IndexSearcher searcher = new IndexSearcher(reader);
        });
import org.apache.lucene.search.TopDocs;
            document.add(new SortedDocValuesField("str", new BytesRef(text)));
                return Status.YES;  
        indexWriter.addDocument(document);
            document.add(field);
import org.apache.lucene.document.IntPoint;  
import org.apache.lucene.index.Term;  
        IndexWriter indexWriter = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));  
        DirectoryReader reader = DirectoryReader.open(indexWriter);
        indexWriter.addDocument(document);  
        assertThat(f.stringValue(), equalTo("2"));  
        if (reader != oldReader) {
        }
import org.apache.lucene.document.SortedDocValuesField;
        for (int i = 0; i < 10; i++) {  
 * You may obtain a copy of the License at  
import org.apache.lucene.search.Sort;
 * the Apache License, Version 2.0 (the "License"); you may
                fieldsOrder.add(fieldInfo.name);
            TextField field = new TextField("_id", Integer.toString(i), Field.Store.YES);  
import org.apache.lucene.index.DirectoryReader;
        topDocs = searcher.search(IntPoint.newExactQuery("test", 2), 1);  
            leaf.reader().terms("_id").iterator().next();  
     * of the field. This means that heavily accessed fields that use field selector should be added
        document.add(new StoredField("test", 2));
     * first (with load and break).
    public void testOrdering() throws Exception {
import java.util.ArrayList;
 * compatible open source license.
import org.apache.lucene.search.SortField;
        document.add(new IntPoint("test", 2));
        }
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.store.Directory;
        Directory dir = new ByteBuffersDirectory();  
        indexWriter.close();
    public void testSortValues() throws Exception {  
            }
        }  
import org.apache.lucene.index.FieldInfo;
import static org.hamcrest.Matchers.equalTo;  
            @Override  
        indexWriter.close();
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.document.Document;
        indexWriter.close();  
    }
        reader = refreshReader(reader);
            indexWriter.addDocument(document);
        }  
        IndexWriter indexWriter = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
            indexWriter.addDocument(document);
        Document document = new Document();
 *
    private DirectoryReader refreshReader(DirectoryReader reader) throws IOException {
import org.apache.lucene.search.FieldDoc;
    }  
        IndexReader reader = DirectoryReader.open(indexWriter);
            Document document = new Document();
        }  
 * GitHub history for details.
import org.apache.lucene.index.StoredFieldVisitor;
        IndexWriter indexWriter = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
        TopDocs topDocs = searcher.search(new TermQuery(new Term("_id", "1")), 1);  
import org.apache.lucene.store.ByteBuffersDirectory;  
            String text = new String(new char[] { (char) (97 + i), (char) (97 + i) });
    public void testSimpleNumericOps() throws Exception {
        doc = searcher.storedFields().document(topDocs.scoreDocs[0].doc);
        assertThat(f.numericValue(), equalTo(2));
package org.opensearch.deps.lucene;
        for (LeafReaderContext leaf : reader.leaves()) {
import java.io.IOException;  
import org.apache.lucene.index.IndexWriter;
 *    http://www.apache.org/licenses/LICENSE-2.0
        final ArrayList<String> fieldsOrder = new ArrayList<>();
 * not use this file except in compliance with the License.
            public Status needsField(FieldInfo fieldInfo) throws IOException {
        Directory dir = new ByteBuffersDirectory();
 * KIND, either express or implied.  See the License for the
    }
 */  
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.common.lucene.Lucene;  
 * under the License.  
import org.apache.lucene.document.TextField;  
 * Unless required by applicable law or agreed to in writing,
public class SimpleLuceneTests extends OpenSearchTestCase {
}  
/*
        IndexReader reader = DirectoryReader.open(indexWriter);
        return reader;
        Document document = new Document();
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.index.IndexableField;  
import org.apache.lucene.index.IndexReader;  
        IndexableField f = doc.getField("test");  
     * Here, we verify that the order that we add fields to a document counts, and not the lexi order  
        document.add(new TextField("#id", "1", Field.Store.YES));
import org.apache.lucene.document.StoredField;
import org.apache.lucene.search.MatchAllDocsQuery;  
        Directory dir = new ByteBuffersDirectory();
import org.apache.lucene.index.IndexWriterConfig;
            FieldDoc fieldDoc = (FieldDoc) docs.scoreDocs[i];
        IndexWriter indexWriter = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));  
        IndexSearcher searcher = new IndexSearcher(reader);
            oldReader.close();
            assertThat((BytesRef) fieldDoc.fields[0], equalTo(new BytesRef(new String(new char[] { (char) (97 + i), (char) (97 + i) }))));  
    }  
import org.apache.lucene.search.TermQuery;  
 * SPDX-License-Identifier: Apache-2.0
        Directory dir = new ByteBuffersDirectory();
 */
        document.add(new TextField("_id", "1", Field.Store.YES));  
/*  
    public void testNRTSearchOnClosedWriter() throws Exception {
        document.add(new TextField("_id", "1", Field.Store.YES));  
import org.apache.lucene.document.Field;
import org.apache.lucene.search.TopFieldDocs;
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
        assertThat(fieldsOrder.get(0), equalTo("_id"));
        TopDocs topDocs = searcher.search(new TermQuery(new Term("_id", "1")), 1);
        DirectoryReader oldReader = reader;
        for (int i = 0; i < 10; i++) {
        IndexReader reader = DirectoryReader.open(indexWriter);
            document.add(new TextField("str", text, Field.Store.YES));  
    }
            Document document = new Document();
        searcher.storedFields().document(topDocs.scoreDocs[0].doc, new StoredFieldVisitor() {
/*  
        Document doc = searcher.storedFields().document(topDocs.scoreDocs[0].doc);
        reader = DirectoryReader.openIfChanged(reader);  
 *  
 * specific language governing permissions and limitations
