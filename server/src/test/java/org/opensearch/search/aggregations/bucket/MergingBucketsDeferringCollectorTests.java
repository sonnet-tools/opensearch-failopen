                    deferringCollector.mergeBuckets(oldBucket -> oldBucket > 3 ? 0 : -1);
                    public void preCollection() throws IOException {}
 * SPDX-License-Identifier: Apache-2.0
/*
 * Modifications Copyright OpenSearch Contributors. See  
                    deferringCollector.mergeBuckets(oldBucket -> 0);  
            @Override
            }
                when(searchContext.query()).thenReturn(query);
                        LeafBucketCollector delegate = deferringCollector.getLeafCollector(ctx);  
 *
        CheckedBiConsumer<MergingBucketsDeferringCollector, CollectingBucketCollector, IOException> verify
 * compatible open source license.
        });  
import org.apache.lucene.search.MatchAllDocsQuery;
                    public ScoreMode scoreMode() {  
        public void postCollection() throws IOException {}
import org.apache.lucene.search.IndexSearcher;  
                    collection.computeIfAbsent(owningBucketOrd, k -> new ArrayList<>()).add(doc);
import java.util.HashMap;
                @Override  
                MergingBucketsDeferringCollector deferringCollector = new MergingBucketsDeferringCollector(searchContext, false);
            @Override  
 * GitHub history for details.
    public void testBucketMergeAndDelete() throws Exception {
                delegate.collect(doc, doc);
import org.opensearch.search.aggregations.BucketCollector;
    public void testBucketMergeAndDeleteLastEntry() throws Exception {
            @Override  
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                Query query = new MatchAllDocsQuery();
            public void collect(int doc, long owningBucketOrd) throws IOException {
                        return ScoreMode.COMPLETE_NO_SCORES;
import org.apache.lucene.search.ScoreMode;  
                    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx) throws IOException {
    }
        BiFunction<MergingBucketsDeferringCollector, LeafBucketCollector, LeafBucketCollector> leafCollector,
/*  
import java.util.ArrayList;  
            return new LeafBucketCollector() {
 * The OpenSearch Contributors require contributions made to  
                IndexSearcher indexSearcher = new IndexSearcher(indexReader);  
 *  
            };
                deferringCollector.postCollection();
 * Unless required by applicable law or agreed to in writing,
    }
 * ownership. Elasticsearch licenses this file to you under  
/*
        }, (deferringCollector, finalCollector) -> {  
import java.io.IOException;
                });  
            assertThat(finalCollector.collection, equalTo(Map.of(0L, List.of(4, 5, 6, 7), 1L, List.of(8), 2L, List.of(9))));
    ) throws IOException {  
        public LeafBucketCollector getLeafCollector(LeafReaderContext ctx) throws IOException {
                assert owningBucketOrd == 0; // Only collects at top level
import static org.mockito.Mockito.when;
        @Override
                if (doc == 7) {
        @Override  
            }
import java.util.List;  
import org.apache.lucene.index.DirectoryReader;
                    }
        });
        }, (deferringCollector, finalCollector) -> {
                }
                public void collect(int doc, long owningBucketOrd) throws IOException {
                deferringCollector.preCollection();  
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
 * KIND, either express or implied.  See the License for the
    private class CollectingBucketCollector extends BucketCollector {
}
                    @Override
 */
    }
                for (int i = 0; i < 10; i++) {  
                        return leafCollector.apply(deferringCollector, delegate);
import org.apache.lucene.store.Directory;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.document.Document;  
import org.apache.lucene.search.Query;
                verify.accept(deferringCollector, finalCollector);
        public void preCollection() throws IOException {}
                }  
                assert owningBucketOrd == 0; // Only collects at top level  
            public void collect(int doc, long owningBucketOrd) throws IOException {
                    indexWriter.addDocument(new Document());
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
                }  
    }
import org.apache.lucene.index.LeafReaderContext;
 */
                    public void postCollection() throws IOException {}
        testCase((deferringCollector, delegate) -> new LeafBucketCollector() {  
                delegate.collect(doc, doc);  
    public void testBucketMergeNoDelete() throws Exception {
                if (doc == 7) {
 * specific language governing permissions and limitations
 */  
                delegate.collect(doc, doc);  
 * You may obtain a copy of the License at  
            }  
        }, (deferringCollector, finalCollector) -> {
        public ScoreMode scoreMode() {
            equalTo(Map.of(0L, List.of(0, 1, 2, 3, 4, 5, 6, 7), 1L, List.of(8), 2L, List.of(9)));  
        try (Directory directory = newDirectory()) {
import java.util.function.BiFunction;
        testCase((deferringCollector, delegate) -> new LeafBucketCollector() {
        testCase((deferringCollector, delegate) -> new LeafBucketCollector() {
import org.opensearch.search.aggregations.AggregatorTestCase;  
    }  
        }
            deferringCollector.prepareSelectedBuckets(0, 8, 9);  
                if (doc == 7) {
                assert owningBucketOrd == 0; // Only collects at top level
import java.util.Map;
import org.opensearch.common.CheckedBiConsumer;
import org.apache.lucene.index.IndexWriterConfig;
                    }
                CollectingBucketCollector finalCollector = new CollectingBucketCollector();
                    deferringCollector.mergeBuckets(oldBucket -> oldBucket <= 3 ? 0 : -1);
import java.util.Collections;
        }
                indexSearcher.search(query, new BucketCollector() {
            public void collect(int doc, long owningBucketOrd) throws IOException {
            }
 * license agreements. See the NOTICE file distributed with
            deferringCollector.prepareSelectedBuckets(0, 8, 9);
        @Override
package org.opensearch.search.aggregations.bucket;
                }
                }  
    private void testCase(  
        final Map<Long, List<Integer>> collection = new HashMap<>();
public class MergingBucketsDeferringCollectorTests extends AggregatorTestCase {
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/60021")  
 *
import org.opensearch.search.aggregations.LeafBucketCollector;
            deferringCollector.prepareSelectedBuckets(0, 8, 9);  
                    @Override
        }
        });  
 * not use this file except in compliance with the License.
import org.apache.lucene.index.IndexReader;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
            assertThat(finalCollector.collection, equalTo(Map.of(0L, List.of(0, 1, 2, 3), 1L, List.of(8), 2L, List.of(9))));
                    @Override
            }  
import org.apache.lucene.index.IndexWriter;  
            return ScoreMode.COMPLETE_NO_SCORES;  
                    @Override
        @Override
 * under the License.  
import static org.hamcrest.Matchers.equalTo;
                deferringCollector.setDeferredCollector(Collections.singleton(finalCollector));
                SearchContext searchContext = createSearchContext(indexSearcher, createIndexSettings(), query, null);  
import org.opensearch.search.internal.SearchContext;  
