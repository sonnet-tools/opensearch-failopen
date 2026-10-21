                    iterator = leafReader.terms("text").iterator();
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.document.Document;
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
                            assertTrue(iterator.seekExact(new BytesRef("" + i)));
                        // soft deletes
import org.apache.lucene.util.BytesRef;
                    writer.flush();
            boolean sorted = randomBoolean();
                            assertEquals(1, iterator.docFreq());
            MergePolicy mp = new SoftDeletesRetentionMergePolicy(
                    Document doc = new Document();
            IndexWriterConfig iwc = newIndexWriterConfig();
                        Terms id = leafReader.terms("id");
            if (sorted) {
                    doc.add(new NumericDocValuesField("sort", 0));
                        assertTrue(iterator.seekExact(new BytesRef("" + i)));
                            assertTrue(sort.longValue() >= 0);
            int numDocs = randomIntBetween(numUniqueDocs, numUniqueDocs * 5);
                    writer.flush();
            iwc.setMergePolicy(new ShuffleForcedMergePolicy(mp));
 */
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.search.Sort;
                        assertEquals(numDocs + 1, leafReader.maxDoc());
                    doc.add(newTextField("text", "the quick brown fox", Field.Store.YES));
import org.opensearch.test.OpenSearchTestCase;
                    }
                    if (rarely()) {
 * The OpenSearch Contributors require contributions made to
                { // drop all ids
/*
                    Document doc = new Document();
                        writer.forceMerge(1, false);
            );
                    }
                    while (sort.nextDoc() != DocIdSetIterator.NO_MORE_DOCS) {
                    writer.forceMerge(1);
                    assertTrue(iterator.seekExact(new BytesRef("quick")));
            }
                        assertEquals(numUniqueDocs, id.size());
                    doc.add(new NumericDocValuesField("sort", i));
                {
 * Licensed to Elasticsearch under one or more contributor
                        } else {
                    // prune away a single ID
 * Modifications Copyright OpenSearch Contributors. See
                    if (i == 0) {
                    }
import org.apache.lucene.document.NumericDocValuesField;
import org.apache.lucene.index.Terms;
                    doc.add(new StringField("id", "test", Field.Store.NO));
                    assertEquals(numValues, numDocs);
                        writer.flush();
                        writer.updateNumericDocValue(new Term("id", "" + i), "_soft_deletes", 1);
                        assertEquals(numDocs, leafReader.maxDoc());
 * KIND, either express or implied.  See the License for the
                        }
                    try (DirectoryReader reader = DirectoryReader.open(writer)) {
 * Unless required by applicable law or agreed to in writing,
 *
                        for (int i = 0; i < numUniqueDocs; i++) {
                        }
                        TermsEnum iterator = leafReader.terms("text").iterator();
 * license agreements. See the NOTICE file distributed with
                    for (int i = 0; i < numUniqueDocs; i++) {
            int numUniqueDocs = randomIntBetween(1, 100);
package org.opensearch.index.engine;
                        assertEquals(1, iterator.docFreq());
                        if (sorted) {
                MatchAllDocsQuery::new,
 * specific language governing permissions and limitations
                  // first add a doc such that we can force merge
                        numValues++;
                        assertFalse(iterator.seekExact(new BytesRef("test")));
 * GitHub history for details.
 * software distributed under the License is distributed on an
                    writer.flush();
import org.apache.lucene.index.Term;
        try (Directory dir = newDirectory()) {
                }
 *
/*
                    }
                }
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.TermsEnum;
                iwc.setIndexSort(new Sort(new SortField("sort", SortField.Type.INT)));
                try (DirectoryReader reader = DirectoryReader.open(writer)) {
                    writer.forceMerge(1);
                        TermsEnum iterator = id.iterator();
                    TermsEnum iterator = id.iterator();
                for (int i = 0; i < numDocs; i++) {
import org.apache.lucene.search.SortField;
    public void testPrune() throws IOException {
                    writer.softUpdateDocument(new Term("id", "" + 0), doc, new NumericDocValuesField("_soft_deletes", 1));
 * not use this file except in compliance with the License.
                    doc.add(newTextField("text", "the quick brown fox", Field.Store.YES));
                    doc.add(new StringField("id", "" + id, Field.Store.NO));
                        // make sure we have at least 2 segments to ensure we do an actual merge to kick out all postings for
public class PrunePostingsMergePolicyTests extends OpenSearchTestCase {
import org.apache.lucene.index.NumericDocValues;
                }
    }
            iwc.setSoftDeletesField("_soft_deletes");
 * SPDX-License-Identifier: Apache-2.0
                    doc.add(new StringField("id", "" + 0, Field.Store.NO));
                        assertTrue(iterator.seekExact(new BytesRef("quick")));
                        LeafReader leafReader = reader.leaves().get(0).reader();
                    LeafReader leafReader = reader.leaves().get(0).reader();
                    }
 */
                    writer.updateNumericDocValue(new Term("id", "test"), "_soft_deletes", 1);// delete it
import org.apache.lucene.index.LeafReader;
                    writer.softUpdateDocument(new Term("id", "" + id), doc, new NumericDocValuesField("_soft_deletes", 1));
                    }
                    int id = i % numUniqueDocs;
/*
import org.apache.lucene.index.SoftDeletesRetentionMergePolicy;
        }
 * this work for additional information regarding copyright
import java.io.IOException;
                    }
                        assertNull(leafReader.terms("id"));
                            assertTrue(sort.longValue() < numDocs);
                    for (int i = 0; i < numUniqueDocs; i++) {
                    NumericDocValues sort = leafReader.getNumericDocValues("sort");
                    if (rarely()) {
import org.apache.lucene.index.IndexWriterConfig;
                    assertEquals(numDocs, leafReader.maxDoc());
                }
 * compatible open source license.
                    writer.forceMerge(1);
                        assertTrue(iterator.seekExact(new BytesRef("quick")));
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.search.DocIdSetIterator;
 * this file be licensed under the Apache-2.0 license or a
 * under the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    try (DirectoryReader reader = DirectoryReader.open(writer)) {
                    Document doc = new Document();
                    int numValues = 0;
import org.apache.lucene.index.MergePolicy;
                        assertEquals(leafReader.maxDoc(), iterator.docFreq());
                            assertEquals(sort.docID(), sort.longValue());
            }
                    Terms id = leafReader.terms("id");
 */
                writer.forceMerge(1);
}
 * You may obtain a copy of the License at
                        iterator = leafReader.terms("text").iterator();
                    }
 * ownership. Elasticsearch licenses this file to you under
            try (IndexWriter writer = new IndexWriter(dir, iwc)) {
                        assertEquals(0, leafReader.numDocs());
                    assertEquals(leafReader.maxDoc(), iterator.docFreq());
import org.apache.lucene.search.MatchAllDocsQuery;
                        writer.flush();
                "_soft_deletes",
                new PrunePostingsMergePolicy(newLogMergePolicy(), "id")
                    writer.deleteDocuments(new Term("id", "test"));
                        LeafReader leafReader = reader.leaves().get(0).reader();
                        assertEquals(leafReader.maxDoc(), iterator.docFreq());
import org.apache.lucene.document.Field;
import org.apache.lucene.store.Directory;
