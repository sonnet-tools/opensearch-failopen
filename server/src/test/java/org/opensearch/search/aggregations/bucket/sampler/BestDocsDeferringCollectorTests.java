import org.apache.lucene.document.Field;
            @Override  
        IndexReader indexReader = DirectoryReader.open(directory);  
import org.apache.lucene.store.Directory;  
        collector.preCollection();  
        BestDocsDeferringCollector collector = new BestDocsDeferringCollector(
            public ScoreMode scoreMode() {
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.search.ScoreDoc;
        indexReader.close();
 * compatible open source license.
import org.opensearch.common.settings.Settings;
import org.apache.lucene.document.StringField;
 * ownership. Elasticsearch licenses this file to you under  
            public void preCollection() throws IOException {  
 * Licensed to Elasticsearch under one or more contributor  
}
        indexSearcher.search(termQuery, collector);
    public void testReplay() throws Exception {  
 *    http://www.apache.org/licenses/LICENSE-2.0
            bytes::addAndGet
 * specific language governing permissions and limitations
public class BestDocsDeferringCollectorTests extends AggregatorTestCase {
            public LeafBucketCollector getLeafCollector(LeafReaderContext ctx) throws IOException {
 * The OpenSearch Contributors require contributions made to  
 */  
 * this work for additional information regarding copyright
            @Override
/*
/*
 * You may obtain a copy of the License at  
        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {  
                    }
    }  
        collector.postCollection();
        indexWriter.close();
import org.apache.lucene.search.ScoreMode;  
 * GitHub history for details.
 * software distributed under the License is distributed on an
        int numDocs = randomIntBetween(1, 128);  
        }  
/*  
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
 * this file be licensed under the Apache-2.0 license or a
        directory.close();
            Document document = new Document();  
 *  
        }
        TermQuery termQuery = new TermQuery(new Term("field", String.valueOf(randomInt(maxNumValues))));  
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.search.aggregations.AggregatorTestCase;  
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
        return new BucketCollector() {  
 * SPDX-License-Identifier: Apache-2.0
    }
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
            }
import org.apache.lucene.tests.index.RandomIndexWriter;
import java.util.Set;
                return new LeafBucketCollector() {  
import java.io.IOException;
        };
            indexWriter.addDocument(document);
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.index.LeafReaderContext;
import org.opensearch.common.util.MockBigArrays;  
import org.apache.lucene.search.TopDocs;
import org.opensearch.search.aggregations.LeafBucketCollector;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.index.Term;  
        );  
                        docIds.add(ctx.docBase + doc);  
        assertEquals(topDocs.scoreDocs.length, deferredCollectedDocIds.size());
            @Override
                return ScoreMode.COMPLETE_NO_SCORES;
    private BucketCollector testCollector(Set<Integer> docIds) {
import org.opensearch.common.util.MockPageCacheRecycler;
            }
        collector.prepareSelectedBuckets(0);  
        Directory directory = newDirectory();
 * under the License.  
package org.opensearch.search.aggregations.bucket.sampler;
            public void postCollection() throws IOException {
import java.util.concurrent.atomic.AtomicLong;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService()),
        collector.close();  
 * KIND, either express or implied.  See the License for the
            }  
        final AtomicLong bytes = new AtomicLong(0);  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
 *
import org.opensearch.search.aggregations.BucketCollector;
import java.util.HashSet;  
            @Override
import org.apache.lucene.document.Document;  
        collector.setDeferredCollector(Collections.singleton(testCollector(deferredCollectedDocIds)));
            document.add(new StringField("field", String.valueOf(randomInt(maxNumValues)), Field.Store.NO));
            assertTrue("expected docid [" + scoreDoc.doc + "] is missing", deferredCollectedDocIds.contains(scoreDoc.doc));
        TopDocs topDocs = indexSearcher.search(termQuery, numDocs);
        for (int i = 0; i < numDocs; i++) {
            numDocs,  
                    @Override
 * license agreements. See the NOTICE file distributed with
                };
import org.apache.lucene.index.DirectoryReader;  
                    public void collect(int doc, long bucket) throws IOException {
        Set<Integer> deferredCollectedDocIds = new HashSet<>();
 *
            }  
 */
 */
import java.util.Collections;
 * not use this file except in compliance with the License.
        int maxNumValues = randomInt(16);
