import org.apache.lucene.document.TextField;
    /**
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
/*
public class SimpleLuceneTests extends OpenSearchTestCase {
import org.apache.lucene.search.IndexSearcher;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.apache.lucene.document.Document;
            Document document = new Document();
        indexWriter.addDocument(document);
                return Status.YES;
 * Unless required by applicable law or agreed to in writing,
        indexWriter.addDocument(document);
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.deps.lucene;
        IndexSearcher searcher = new IndexSearcher(reader);
 *
        assertThat(fieldsOrder.get(1), equalTo("#id"));
            @Override
        document.add(new TextField("_id", "1", Field.Store.YES));
        Document doc = searcher.storedFields().document(topDocs.scoreDocs[0].doc);
        f = doc.getField("test");
        IndexableField f = doc.getField("test");
    public void testNRTSearchOnClosedWriter() throws Exception {
        }
import java.util.ArrayList;
     * first (with load and break).
        reader = DirectoryReader.openIfChanged(reader);
            document.add(field);
        IndexWriter indexWriter = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
import org.apache.lucene.search.Sort;
            FieldDoc fieldDoc = (FieldDoc) docs.scoreDocs[i];
            indexWriter.addDocument(document);
            leaf.reader().terms("_id").iterator().next();
import org.apache.lucene.index.FieldInfo;
        DirectoryReader oldReader = reader;
import org.apache.lucene.util.BytesRef;
            }
import java.io.IOException;
        IndexWriter indexWriter = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
 * You may obtain a copy of the License at
import org.opensearch.test.OpenSearchTestCase;
    }
/*
        assertThat(f.numericValue(), equalTo(2));
        }
import static org.hamcrest.Matchers.equalTo;
        indexWriter.close();
        document.add(new TextField("_id", "1", Field.Store.YES));
        }
            indexWriter.addDocument(document);
import org.opensearch.common.lucene.Lucene;
        IndexReader reader = DirectoryReader.open(indexWriter);
    private DirectoryReader refreshReader(DirectoryReader reader) throws IOException {
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.index.LeafReaderContext;
        for (int i = 0; i < 100; i++) {
        for (int i = 0; i < 10; i++) {
 */
    }
        document.add(new IntPoint("test", 2));
        IndexWriter indexWriter = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
        assertThat(fieldsOrder.size(), equalTo(2));
}
    public void testOrdering() throws Exception {
        }
     * of the field. This means that heavily accessed fields that use field selector should be added
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.TermQuery;
 * the Apache License, Version 2.0 (the "License"); you may
        for (int i = 0; i < 10; i++) {
        assertThat(f.stringValue(), equalTo("2"));
        document.add(new TextField("#id", "1", Field.Store.YES));
        document.add(new StoredField("test", 2));
        indexWriter.close();
        TopFieldDocs docs = searcher.search(new MatchAllDocsQuery(), 10, new Sort(new SortField("str", SortField.Type.STRING)));
        Directory dir = new ByteBuffersDirectory();
        indexWriter.close();
import org.apache.lucene.index.DirectoryReader;
    }
        topDocs = searcher.search(IntPoint.newExactQuery("test", 2), 1);
 * software distributed under the License is distributed on an
    }
    public void testSortValues() throws Exception {
        IndexSearcher searcher = new IndexSearcher(reader);
     * Here, we verify that the order that we add fields to a document counts, and not the lexi order
        });
 */
        Directory dir = new ByteBuffersDirectory();
            document.add(new SortedDocValuesField("str", new BytesRef(text)));
 * under the License.
        DirectoryReader reader = DirectoryReader.open(indexWriter);
        for (LeafReaderContext leaf : reader.leaves()) {
            public Status needsField(FieldInfo fieldInfo) throws IOException {
        if (reader != oldReader) {
import org.apache.lucene.store.Directory;
 * not use this file except in compliance with the License.
        final ArrayList<String> fieldsOrder = new ArrayList<>();
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under
 *
import org.apache.lucene.index.IndexableField;
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
        IndexWriter indexWriter = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
        IndexReader reader = DirectoryReader.open(indexWriter);
        Document document = new Document();
    }
        assertThat(fieldsOrder.get(0), equalTo("_id"));
        searcher.storedFields().document(topDocs.scoreDocs[0].doc, new StoredFieldVisitor() {
 * GitHub history for details.
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.TopFieldDocs;
import org.apache.lucene.document.IntPoint;
        IndexReader reader = DirectoryReader.open(indexWriter);
 */
import org.apache.lucene.search.TopDocs;
        reader = refreshReader(reader);
            oldReader.close();
            Document document = new Document();
import org.apache.lucene.search.FieldDoc;
            assertThat((BytesRef) fieldDoc.fields[0], equalTo(new BytesRef(new String(new char[] { (char) (97 + i), (char) (97 + i) }))));
            TextField field = new TextField("_id", Integer.toString(i), Field.Store.YES);
 * Licensed to Elasticsearch under one or more contributor
 *
        Directory dir = new ByteBuffersDirectory();
                fieldsOrder.add(fieldInfo.name);
 * this file be licensed under the Apache-2.0 license or a
        Document document = new Document();
            document.add(new TextField("str", text, Field.Store.YES));
        IndexSearcher searcher = new IndexSearcher(reader);
import org.apache.lucene.document.SortedDocValuesField;
     */
        TopDocs topDocs = searcher.search(new TermQuery(new Term("_id", "1")), 1);
import org.apache.lucene.index.StoredFieldVisitor;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.store.ByteBuffersDirectory;
 * The OpenSearch Contributors require contributions made to
        Directory dir = new ByteBuffersDirectory();
 * compatible open source license.
        TopDocs topDocs = searcher.search(new TermQuery(new Term("_id", "1")), 1);
        return reader;
import org.apache.lucene.index.IndexReader;
        }
            String text = new String(new char[] { (char) (97 + i), (char) (97 + i) });
import org.apache.lucene.document.Field;
/*
    public void testSimpleNumericOps() throws Exception {
import org.apache.lucene.search.SortField;
        doc = searcher.storedFields().document(topDocs.scoreDocs[0].doc);
