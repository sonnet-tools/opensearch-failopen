            i += step;
            }  
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.search.FieldDoc;
        for (int i = 0; i < numDocs;) {  
 * software distributed under the License is distributed on an
            doc.clear();
        FixedBitSet bitSet = new FixedBitSet(numDocs);
 */
import org.apache.lucene.tests.index.RandomIndexWriter;  
        final IndexSearcher searcher = new IndexSearcher(reader);
                int docRebase = topDoc.doc - leafReaderContext.docBase;
 * KIND, either express or implied.  See the License for the
            int rand = randomIntBetween(0, 10);  
            for (ScoreDoc topDoc : topDocs.scoreDocs) {
                final LeafReaderContext leafReaderContext = reader.leaves().get(readerIndex);
        Sort sort = new Sort(
                    assertTrue(leafReaderContext.reader().getLiveDocs().get(docRebase));
                if (leafReaderContext.reader().hasDeletions()) {  
                topDocs = searcher.search(new SearchAfterSortedDocQuery(sort, after), step, sort);  
import org.apache.lucene.document.SortedDocValuesField;
            w.addDocument(doc);  
        Sort sort1 = new Sort(new SortedNumericSortField("field1", SortField.Type.INT), new SortedSetSortField("field2", false));
import org.apache.lucene.index.IndexReader;
            new SortedNumericSortField("number1", SortField.Type.INT, randomBoolean()),
            } else {
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
        QueryUtils.checkUnequal(query1, query3);
        SearchAfterSortedDocQuery query1 = new SearchAfterSortedDocQuery(sort1, fieldDoc1);  
import org.apache.lucene.search.MatchAllDocsQuery;
        Sort sort2 = new Sort(new SortedNumericSortField("field1", SortField.Type.INT), new SortedSetSortField("field3", false));
import org.apache.lucene.index.IndexWriterConfig;
        final int numDocs = randomIntBetween(100, 200);
        assertThat(ex.getMessage(), equalTo("after doc  has 2 value(s) but sort has 1."));  
 * not use this file except in compliance with the License.
    public void testInvalidSort() {
        QueryUtils.checkEqual(query1, query2);
import org.apache.lucene.search.IndexSearcher;  
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.store.Directory;
    }  
        for (int i = 0; i < numDocs; ++i) {
    public void testBasics() {  
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.search.ScoreDoc;
        FieldDoc fieldDoc2 = new FieldDoc(0, 0f, new Object[] { 5, new BytesRef("foo") });
    }
        SearchAfterSortedDocQuery query3 = new SearchAfterSortedDocQuery(sort2, fieldDoc2);
        assertThat(bitSet.cardinality(), equalTo(reader.numDocs()));
}  
 * compatible open source license.
        Sort sort = new Sort(new SortedNumericSortField("field1", SortField.Type.INT));  
 *  
        w.close();
        final IndexWriterConfig config = new IndexWriterConfig();
/*  
import org.apache.lucene.search.SortField;
        }  
                }
        TopDocs topDocs = null;
        dir.close();
import org.apache.lucene.document.SortedNumericDocValuesField;  
import org.apache.lucene.search.TopDocs;
                int readerIndex = ReaderUtil.subIndex(topDoc.doc, reader.leaves());  
import org.apache.lucene.search.SortedSetSortField;  
/*  
    public void testRandom() throws IOException {  
import org.apache.lucene.search.SortedNumericSortField;
        SearchAfterSortedDocQuery query2 = new SearchAfterSortedDocQuery(sort1, fieldDoc2);
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        reader.close();  
 *
        FieldDoc fieldDoc1 = new FieldDoc(0, 0f, new Object[] { 5, new BytesRef("foo") });  
        final IndexReader reader = w.getReader();  
                bitSet.set(topDoc.doc);
            }
import org.apache.lucene.search.Sort;  
import org.opensearch.test.OpenSearchTestCase;
import org.apache.lucene.util.FixedBitSet;  
 *    http://www.apache.org/licenses/LICENSE-2.0
            new SortField("string", SortField.Type.STRING, randomBoolean())  
import org.apache.lucene.index.LeafReaderContext;  
 * this work for additional information regarding copyright
        FieldDoc fieldDoc = new FieldDoc(0, 0f, new Object[] { 4, 5 });
import java.io.IOException;  
public class SearchAfterSortedDocQueryTests extends OpenSearchTestCase {
            if (rarely()) {
/*
import org.apache.lucene.document.Document;
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
        int step = randomIntBetween(1, 10);  
import static org.hamcrest.Matchers.equalTo;
 * Modifications Copyright OpenSearch Contributors. See
            }
 */  
            doc.add(new SortedNumericDocValuesField("number", rand));
        QueryUtils.check(query1);  
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
            if (topDocs != null) {
        final Directory dir = newDirectory();  
import org.apache.lucene.tests.search.QueryUtils;
                assertFalse(bitSet.get(topDoc.doc));  
                FieldDoc after = (FieldDoc) topDocs.scoreDocs[topDocs.scoreDocs.length - 1];
import org.apache.lucene.index.ReaderUtil;
package org.opensearch.lucene.queries;
    }
                w.commit();  
 *
            doc.add(new SortedDocValuesField("string", new BytesRef(randomAlphaOfLength(randomIntBetween(5, 50)))));
 * You may obtain a copy of the License at  
        final RandomIndexWriter w = new RandomIndexWriter(random(), dir, config);
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> new SearchAfterSortedDocQuery(sort, fieldDoc));
                topDocs = searcher.search(new MatchAllDocsQuery(), step, sort);
 * Licensed to Elasticsearch under one or more contributor  
        );
        final Document doc = new Document();
 */  
        config.setIndexSort(sort);  
