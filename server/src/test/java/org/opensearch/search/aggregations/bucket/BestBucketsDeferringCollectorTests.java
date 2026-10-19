 * Modifications Copyright OpenSearch Contributors. See  
        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
        collector.prepareSelectedBuckets(0);
        }  
import org.apache.lucene.document.Document;  
                return new LeafBucketCollector() {  
        Set<Integer> deferredCollectedDocIds = new HashSet<>();  
            assertTrue("expected docid [" + scoreDoc.doc + "] is missing", deferredCollectedDocIds.contains(scoreDoc.doc));
                        docIds.add(ctx.docBase + doc);  
 * Licensed to Elasticsearch under one or more contributor  
            public ScoreMode scoreMode() {
            }
 * The OpenSearch Contributors require contributions made to  
 *
import org.opensearch.search.aggregations.BucketCollector;
import java.util.Set;  
        collector.preCollection();
                    @Override
            public void postCollection() throws IOException {
 */  
    public void testReplay() throws Exception {  
import org.opensearch.search.aggregations.AggregatorTestCase;
 * this work for additional information regarding copyright
 *
/*
        deferredCollectedDocIds = new HashSet<>();
        directory.close();
import org.opensearch.search.internal.SearchContext;
 * this file be licensed under the Apache-2.0 license or a
            document.add(new StringField("field", String.valueOf(randomInt(maxNumValues)), Field.Store.NO));
/*
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
                return ScoreMode.COMPLETE_NO_SCORES;
        int maxNumValues = randomInt(16);
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Query;  
        assertEquals(topDocs.scoreDocs.length, deferredCollectedDocIds.size());  
        Directory directory = newDirectory();
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
 * software distributed under the License is distributed on an
                    }
        SearchContext searchContext = createSearchContext(indexSearcher, createIndexSettings(), rewrittenQuery, null);
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.document.Field;
import org.apache.lucene.search.MatchAllDocsQuery;
            }
                return ScoreMode.COMPLETE;  
        collector = new BestBucketsDeferringCollector(searchContext, true);
        collector.preCollection();
        collector.postCollection();  
        collector.setDeferredCollector(Collections.singleton(bla(deferredCollectedDocIds)));  
        collector.postCollection();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.HashSet;
    }  
 * license agreements. See the NOTICE file distributed with
import java.io.IOException;  
import org.apache.lucene.search.ScoreMode;
        return new BucketCollector() {  
 * You may obtain a copy of the License at  
        indexSearcher.search(termQuery, collector);  
            @Override  
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.LeafBucketCollector;  
        };
        TermQuery termQuery = new TermQuery(new Term("field", String.valueOf(randomInt(maxNumValues))));  
            @Override
            Document document = new Document();  
import org.apache.lucene.index.IndexReader;
            public void preCollection() throws IOException {  
            @Override
 * under the License.  
        int numDocs = randomIntBetween(1, 128);  
        indexWriter.close();
import org.apache.lucene.search.TermQuery;  
            }
            @Override
public class BestBucketsDeferringCollectorTests extends AggregatorTestCase {
    }
 * specific language governing permissions and limitations
import org.apache.lucene.index.DirectoryReader;  
 *  
        }  
    private BucketCollector bla(Set<Integer> docIds) {
import org.apache.lucene.index.Term;  
            assertTrue("expected docid [" + scoreDoc.doc + "] is missing", deferredCollectedDocIds.contains(scoreDoc.doc));  
        when(searchContext.query()).thenReturn(rewrittenQuery);
import org.apache.lucene.document.StringField;
import static org.mockito.Mockito.when;
        indexSearcher.search(new MatchAllDocsQuery(), collector);
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
            public ScoreMode scoreMode() {
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.search.aggregations.bucket;
import org.apache.lucene.store.Directory;
        IndexReader indexReader = DirectoryReader.open(directory);  
        Query rewrittenQuery = indexSearcher.rewrite(termQuery);
            public LeafBucketCollector getLeafCollector(LeafReaderContext ctx) throws IOException {
        };
        for (int i = 0; i < numDocs; i++) {
import org.apache.lucene.tests.index.RandomIndexWriter;  
/*  
import org.apache.lucene.search.TopDocs;
 */
        indexReader.close();
            }  
        topDocs = indexSearcher.search(new MatchAllDocsQuery(), numDocs);  
        collector.prepareSelectedBuckets(0);
                };
        }
        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.index.LeafReaderContext;
 *    http://www.apache.org/licenses/LICENSE-2.0
            }  
                    public void collect(int doc, long bucket) throws IOException {
            @Override
        collector.setDeferredCollector(Collections.singleton(bla(deferredCollectedDocIds)));
 * KIND, either express or implied.  See the License for the
        assertEquals(topDocs.scoreDocs.length, deferredCollectedDocIds.size());
import java.util.Collections;
 * compatible open source license.
        BestBucketsDeferringCollector collector = new BestBucketsDeferringCollector(searchContext, false) {  
}
            indexWriter.addDocument(document);
 * GitHub history for details.
 */
        TopDocs topDocs = indexSearcher.search(termQuery, numDocs);
