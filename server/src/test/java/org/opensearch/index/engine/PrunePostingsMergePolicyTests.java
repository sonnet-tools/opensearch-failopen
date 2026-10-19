                    Document doc = new Document();
                        numValues++;  
                    doc.add(new NumericDocValuesField("sort", i));
                        assertEquals(0, leafReader.numDocs());  
import org.apache.lucene.index.Terms;
                            assertTrue(iterator.seekExact(new BytesRef("" + i)));
import org.apache.lucene.search.DocIdSetIterator;  
import org.apache.lucene.index.MergePolicy;  
                        assertNull(leafReader.terms("id"));
                    writer.forceMerge(1);
                    TermsEnum iterator = id.iterator();
 * SPDX-License-Identifier: Apache-2.0
                    Document doc = new Document();
            }
/*  
 * Modifications Copyright OpenSearch Contributors. See
 *
                    writer.updateNumericDocValue(new Term("id", "test"), "_soft_deletes", 1);// delete it
                    doc.add(newTextField("text", "the quick brown fox", Field.Store.YES));
                    writer.flush();  
                        assertTrue(iterator.seekExact(new BytesRef("quick")));  
 * The OpenSearch Contributors require contributions made to  
 */  
 * software distributed under the License is distributed on an
 *
                        writer.forceMerge(1, false);
                try (DirectoryReader reader = DirectoryReader.open(writer)) {  
                        writer.flush();
                            assertTrue(sort.longValue() < numDocs);
            if (sorted) {
                    for (int i = 0; i < numUniqueDocs; i++) {
                for (int i = 0; i < numDocs; i++) {  
                            assertEquals(1, iterator.docFreq());
import org.apache.lucene.index.LeafReader;
                        assertEquals(leafReader.maxDoc(), iterator.docFreq());
                writer.forceMerge(1);
 * KIND, either express or implied.  See the License for the
                    LeafReader leafReader = reader.leaves().get(0).reader();
                {
                    int numValues = 0;  
                        TermsEnum iterator = id.iterator();
                }  
                    Terms id = leafReader.terms("id");  
                        assertTrue(iterator.seekExact(new BytesRef("quick")));  
                        assertEquals(numDocs, leafReader.maxDoc());
    public void testPrune() throws IOException {  
                    writer.flush();  
public class PrunePostingsMergePolicyTests extends OpenSearchTestCase {
                        Terms id = leafReader.terms("id");  
import java.io.IOException;
                "_soft_deletes",
 * the Apache License, Version 2.0 (the "License"); you may
                    assertTrue(iterator.seekExact(new BytesRef("quick")));
                    }
 */
            MergePolicy mp = new SoftDeletesRetentionMergePolicy(
                new PrunePostingsMergePolicy(newLogMergePolicy(), "id")
import org.apache.lucene.index.NumericDocValues;
                    int id = i % numUniqueDocs;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.StringField;
                    }
/*
import org.apache.lucene.store.Directory;
                MatchAllDocsQuery::new,  
                        LeafReader leafReader = reader.leaves().get(0).reader();
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
                    }
                        TermsEnum iterator = leafReader.terms("text").iterator();
                    writer.deleteDocuments(new Term("id", "test"));
                    assertEquals(numValues, numDocs);
import org.apache.lucene.search.Sort;
                        } else {
 */  
                iwc.setIndexSort(new Sort(new SortField("sort", SortField.Type.INT)));  
            }
import org.apache.lucene.search.MatchAllDocsQuery;
                    for (int i = 0; i < numUniqueDocs; i++) {  
 * Unless required by applicable law or agreed to in writing,
 *  
            boolean sorted = randomBoolean();
 * license agreements. See the NOTICE file distributed with
                }  
import org.apache.lucene.search.SortField;  
                    NumericDocValues sort = leafReader.getNumericDocValues("sort");
/*  
 * Licensed to Elasticsearch under one or more contributor  
                        for (int i = 0; i < numUniqueDocs; i++) {  
 * not use this file except in compliance with the License.
                }  
                        }  
                    assertEquals(leafReader.maxDoc(), iterator.docFreq());
import org.apache.lucene.util.BytesRef;
                    doc.add(new StringField("id", "test", Field.Store.NO));
                    if (rarely()) {
                    doc.add(newTextField("text", "the quick brown fox", Field.Store.YES));  
}
                    }
                        assertEquals(numUniqueDocs, id.size());
import org.apache.lucene.index.SoftDeletesRetentionMergePolicy;
                        assertTrue(iterator.seekExact(new BytesRef("" + i)));  
                            assertTrue(sort.longValue() >= 0);  
                        assertEquals(leafReader.maxDoc(), iterator.docFreq());
                    // prune away a single ID
                        iterator = leafReader.terms("text").iterator();
import org.apache.lucene.document.NumericDocValuesField;  
import org.apache.lucene.index.IndexWriter;  
            iwc.setSoftDeletesField("_soft_deletes");  
                { // drop all ids
        try (Directory dir = newDirectory()) {
            try (IndexWriter writer = new IndexWriter(dir, iwc)) {
                    while (sort.nextDoc() != DocIdSetIterator.NO_MORE_DOCS) {
    }
                        // make sure we have at least 2 segments to ensure we do an actual merge to kick out all postings for
                        LeafReader leafReader = reader.leaves().get(0).reader();
                        assertFalse(iterator.seekExact(new BytesRef("test")));
                    writer.forceMerge(1);
                    doc.add(new NumericDocValuesField("sort", 0));
            iwc.setMergePolicy(new ShuffleForcedMergePolicy(mp));  
                    writer.softUpdateDocument(new Term("id", "" + id), doc, new NumericDocValuesField("_soft_deletes", 1));  
            int numUniqueDocs = randomIntBetween(1, 100);
                    assertEquals(numDocs, leafReader.maxDoc());
                    try (DirectoryReader reader = DirectoryReader.open(writer)) {  
                    Document doc = new Document();  
                    }
                    writer.forceMerge(1);
 * You may obtain a copy of the License at  
import org.apache.lucene.document.Field;
                    }
                    try (DirectoryReader reader = DirectoryReader.open(writer)) {  
                            assertEquals(sort.docID(), sort.longValue());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
import org.apache.lucene.index.IndexWriterConfig;
                        assertEquals(1, iterator.docFreq());
                    iterator = leafReader.terms("text").iterator();  
                    if (rarely()) {
                        assertEquals(numDocs + 1, leafReader.maxDoc());
                    writer.flush();  
import org.apache.lucene.index.Term;  
                        }
 * under the License.  
                        // soft deletes  
                  // first add a doc such that we can force merge  
            int numDocs = randomIntBetween(numUniqueDocs, numUniqueDocs * 5);  
import org.apache.lucene.index.TermsEnum;
            IndexWriterConfig iwc = newIndexWriterConfig();
                        writer.updateNumericDocValue(new Term("id", "" + i), "_soft_deletes", 1);
import org.opensearch.test.OpenSearchTestCase;  
                    }  
                    doc.add(new StringField("id", "" + 0, Field.Store.NO));
package org.opensearch.index.engine;
                    doc.add(new StringField("id", "" + id, Field.Store.NO));  
 * compatible open source license.
                }  
                        writer.flush();
 *     http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
                    if (i == 0) {
                    }  
import org.apache.lucene.index.DirectoryReader;
                        if (sorted) {  
                    writer.softUpdateDocument(new Term("id", "" + 0), doc, new NumericDocValuesField("_soft_deletes", 1));
            );
 * specific language governing permissions and limitations
 * GitHub history for details.
