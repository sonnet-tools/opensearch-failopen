/*
                delegate.collect(doc, doc);
            return ScoreMode.COMPLETE_NO_SCORES;
package org.opensearch.search.aggregations.bucket;
                delegate.collect(doc, doc);
                });
                    collection.computeIfAbsent(owningBucketOrd, k -> new ArrayList<>()).add(doc);
                        return leafCollector.apply(deferringCollector, delegate);
import org.apache.lucene.document.Document;
public class MergingBucketsDeferringCollectorTests extends AggregatorTestCase {
 * license agreements. See the NOTICE file distributed with
        public void postCollection() throws IOException {}
                }
/*
    }
            return new LeafBucketCollector() {
            assertThat(finalCollector.collection, equalTo(Map.of(0L, List.of(4, 5, 6, 7), 1L, List.of(8), 2L, List.of(9))));
            @Override
            }
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/60021")
                Query query = new MatchAllDocsQuery();
 * this file be licensed under the Apache-2.0 license or a
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    public ScoreMode scoreMode() {
 */
                }
/*
import org.apache.lucene.index.IndexReader;
        testCase((deferringCollector, delegate) -> new LeafBucketCollector() {
        @Override
        try (Directory directory = newDirectory()) {
            assertThat(finalCollector.collection, equalTo(Map.of(0L, List.of(0, 1, 2, 3), 1L, List.of(8), 2L, List.of(9))));
                    public void preCollection() throws IOException {}
 *
 */
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
        }, (deferringCollector, finalCollector) -> {
 * ownership. Elasticsearch licenses this file to you under
        }
                    }
        });
    ) throws IOException {
 *
                    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx) throws IOException {
                deferringCollector.postCollection();
                    @Override
            deferringCollector.prepareSelectedBuckets(0, 8, 9);
            }
        });
                    @Override
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
            public void collect(int doc, long owningBucketOrd) throws IOException {
            }
                verify.accept(deferringCollector, finalCollector);
                    @Override
                }
import org.apache.lucene.store.Directory;
            };
                assert owningBucketOrd == 0; // Only collects at top level
 * The OpenSearch Contributors require contributions made to
                    deferringCollector.mergeBuckets(oldBucket -> oldBucket > 3 ? 0 : -1);
    }
                        LeafBucketCollector delegate = deferringCollector.getLeafCollector(ctx);
                delegate.collect(doc, doc);
            @Override
                public void collect(int doc, long owningBucketOrd) throws IOException {
import org.apache.lucene.index.LeafReaderContext;
        CheckedBiConsumer<MergingBucketsDeferringCollector, CollectingBucketCollector, IOException> verify
                when(searchContext.query()).thenReturn(query);
        public ScoreMode scoreMode() {
                indexSearcher.search(query, new BucketCollector() {
import org.opensearch.search.aggregations.LeafBucketCollector;
                @Override
    public void testBucketMergeAndDeleteLastEntry() throws Exception {
                if (doc == 7) {
            equalTo(Map.of(0L, List.of(0, 1, 2, 3, 4, 5, 6, 7), 1L, List.of(8), 2L, List.of(9)));
        @Override
import org.apache.lucene.index.IndexWriter;
            @Override
}
                    deferringCollector.mergeBuckets(oldBucket -> oldBucket <= 3 ? 0 : -1);
                IndexSearcher indexSearcher = new IndexSearcher(indexReader);
import org.opensearch.search.internal.SearchContext;
 * specific language governing permissions and limitations
                for (int i = 0; i < 10; i++) {
import java.util.List;
    }
 * the Apache License, Version 2.0 (the "License"); you may
            public void collect(int doc, long owningBucketOrd) throws IOException {
        });
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
        public void preCollection() throws IOException {}
            deferringCollector.prepareSelectedBuckets(0, 8, 9);
 *     http://www.apache.org/licenses/LICENSE-2.0
                CollectingBucketCollector finalCollector = new CollectingBucketCollector();
                }
        BiFunction<MergingBucketsDeferringCollector, LeafBucketCollector, LeafBucketCollector> leafCollector,
    public void testBucketMergeAndDelete() throws Exception {
                    public void postCollection() throws IOException {}
 * this work for additional information regarding copyright
        }
    }
        @Override
                    indexWriter.addDocument(new Document());
import java.util.HashMap;
import org.apache.lucene.search.IndexSearcher;
import java.io.IOException;
 * under the License.
import static org.mockito.Mockito.when;
import org.opensearch.search.aggregations.BucketCollector;
    }
import java.util.function.BiFunction;
import java.util.Collections;
 * Unless required by applicable law or agreed to in writing,
                if (doc == 7) {
import org.apache.lucene.index.DirectoryReader;
 * GitHub history for details.
        final Map<Long, List<Integer>> collection = new HashMap<>();
 */
import org.apache.lucene.search.Query;
import java.util.Map;
                if (doc == 7) {
 * Licensed to Elasticsearch under one or more contributor
        }
                    deferringCollector.mergeBuckets(oldBucket -> 0);
    public void testBucketMergeNoDelete() throws Exception {
                }
        }, (deferringCollector, finalCollector) -> {
    private class CollectingBucketCollector extends BucketCollector {
        @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.ArrayList;
 *
                assert owningBucketOrd == 0; // Only collects at top level
                deferringCollector.preCollection();
                deferringCollector.setDeferredCollector(Collections.singleton(finalCollector));
import static org.hamcrest.Matchers.equalTo;
        testCase((deferringCollector, delegate) -> new LeafBucketCollector() {
 * not use this file except in compliance with the License.
        public LeafBucketCollector getLeafCollector(LeafReaderContext ctx) throws IOException {
            }
import org.opensearch.search.aggregations.AggregatorTestCase;
                assert owningBucketOrd == 0; // Only collects at top level
import org.apache.lucene.index.IndexWriterConfig;
            }
                        return ScoreMode.COMPLETE_NO_SCORES;
                    }
    private void testCase(
 * Modifications Copyright OpenSearch Contributors. See
        }, (deferringCollector, finalCollector) -> {
                    @Override
 * You may obtain a copy of the License at
import org.apache.lucene.search.ScoreMode;
                MergingBucketsDeferringCollector deferringCollector = new MergingBucketsDeferringCollector(searchContext, false);
        testCase((deferringCollector, delegate) -> new LeafBucketCollector() {
                SearchContext searchContext = createSearchContext(indexSearcher, createIndexSettings(), query, null);
            public void collect(int doc, long owningBucketOrd) throws IOException {
import org.opensearch.common.CheckedBiConsumer;
import org.apache.lucene.search.MatchAllDocsQuery;
            deferringCollector.prepareSelectedBuckets(0, 8, 9);
