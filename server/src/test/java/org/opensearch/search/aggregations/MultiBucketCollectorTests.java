            final IndexSearcher searcher = newSearcher(reader);  
 *
        private final BucketCollector in;
    }  
        }  
            };
        assertTrue(setScorerCalled2.get());  
            return new LeafBucketCollectorBase(leafCollector, null) {  
 * software distributed under the License is distributed on an
        setScorerCalled1.set(false);
                public void collect(int doc, long bucket) throws IOException {  
 * under the License.  
            return score;
import org.apache.lucene.index.LeafReaderContext;  
        @Override
            return new LeafBucketCollector() {  
        @Override  
import org.apache.lucene.search.IndexSearcher;
        setScorerCalled2.set(false);
                @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
        SetScorerBucketCollector(BucketCollector in, AtomicBoolean setScorerCalled) {
 * this file be licensed under the Apache-2.0 license or a
            };
        public void postCollection() {}
    private static class SetScorerBucketCollector extends BucketCollector {  
        leafCollector.setScorer(scorer);
import java.io.IOException;
            this.setScorerCalled = setScorerCalled;  
                expectedCounts.put(collector, expectedCount);
            }
        collector2 = new SetScorerBucketCollector(collector2, setScorerCalled2);
 * Unless required by applicable law or agreed to in writing,
                @Override
        @Override
import org.apache.lucene.store.Directory;  
                    count++;
                assertEquals(expectedCount.getValue().intValue(), expectedCount.getKey().getTotalHits());
        }
        }
            searcher.search(new MatchAllDocsQuery(), MultiBucketCollector.wrap(collectors));
        }  
                }  
    public void testCollectionTerminatedExceptionHandling() throws IOException {  
        @Override
    }
import org.apache.lucene.tests.index.RandomIndexWriter;
        BucketCollector collector1 = new TotalHitCountBucketCollector();  
 *  
                }
            reader.close();  
        collector1 = new SetScorerBucketCollector(collector1, setScorerCalled1);
        private final AtomicBoolean setScorerCalled;
        BucketCollector collector2 = new TotalHitCountBucketCollector();
        @Override  
            final Document doc = new Document();  
 *
    private static class ScoreAndDoc extends Scorable {
        public void postCollection() {}  
import java.util.Arrays;  
import org.apache.lucene.search.MatchAllDocsQuery;  
        TotalHitCountBucketCollector() {}
        public void preCollection() {}
 * The OpenSearch Contributors require contributions made to  
        LeafBucketCollector leafCollector = collector.getLeafCollector(null);  
            return ScoreMode.COMPLETE_NO_SCORES;
 * this work for additional information regarding copyright
        public ScoreMode scoreMode() {  
        }
            };  
        AtomicBoolean setScorerCalled1 = new AtomicBoolean();  
            final int numDocs = randomIntBetween(100, 1000);
        for (int iter = 0; iter < iters; ++iter) {
 * KIND, either express or implied.  See the License for the
            Map<TotalHitCountBucketCollector, Integer> expectedCounts = new HashMap<>();
        public LeafBucketCollector getLeafCollector(LeafReaderContext context) throws IOException {
                    super.collect(doc, bucket);
 */  
        @Override
        @Override
        @Override  
                public void setScorer(Scorable scorer) throws IOException {
        assertFalse(setScorerCalled1.get());
            final LeafBucketCollector leafCollector = in.getLeafCollector(context);
 * the Apache License, Version 2.0 (the "License"); you may
        private int count = 0;  
            dir.close();
        }
            RandomIndexWriter w = new RandomIndexWriter(random(), dir);
        @Override
        TerminateAfterBucketCollector(BucketCollector in, int terminateAfter) {
            for (int i = 0; i < numCollectors; ++i) {
        final int iters = atLeast(3);
        @Override
        AtomicBoolean setScorerCalled2 = new AtomicBoolean();  
        }  
 * Licensed to Elasticsearch under one or more contributor  
                    count++;  
        public LeafBucketCollector getLeafCollector(LeafReaderContext context) throws IOException {
        public ScoreMode scoreMode() {
            Directory dir = newDirectory();  
/*  
            return ScoreMode.COMPLETE;
        collector2 = new TerminateAfterBucketCollector(collector2, 2);
public class MultiBucketCollectorTests extends OpenSearchTestCase {
}
                TotalHitCountBucketCollector collector = new TotalHitCountBucketCollector();
 * Modifications Copyright OpenSearch Contributors. See
        leafCollector.setScorer(scorer);  
            }  
    private static class TotalHitCountBucketCollector extends BucketCollector {
 */
        }
        public ScoreMode scoreMode() {
 * ownership. Elasticsearch licenses this file to you under  
            for (int i = 0; i < numDocs; ++i) {
    }  
import org.apache.lucene.index.IndexReader;
        public void postCollection() {}
                public void collect(int doc, long bucket) throws IOException {
        @Override
            if (count >= terminateAfter) {  
import java.util.Collections;
        assertTrue(setScorerCalled1.get());
/*
 * SPDX-License-Identifier: Apache-2.0
    }
                    }  
        float score;  
                        throw new CollectionTerminatedException();
 * You may obtain a copy of the License at  
        setScorerCalled1.set(false);
        public LeafBucketCollector getLeafCollector(LeafReaderContext context) {
            for (Map.Entry<TotalHitCountBucketCollector, Integer> expectedCount : expectedCounts.entrySet()) {  
        assertFalse(setScorerCalled2.get());
        private final int terminateAfter;
 * compatible open source license.
    }  
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testSetScorerAfterCollectionTerminated() throws IOException {
        setScorerCalled2.set(false);  
        public void preCollection() {}  
        assertTrue(setScorerCalled2.get());  
import org.apache.lucene.search.ScoreMode;
import java.util.concurrent.atomic.AtomicBoolean;
            final LeafBucketCollector leafCollector = in.getLeafCollector(context);  
        }
        collector1 = new TerminateAfterBucketCollector(collector1, 1);  
            return count;
                }
        public void preCollection() {}
        private final BucketCollector in;  
            final IndexReader reader = w.getReader();
        }
/*  
        @Override
            this.in = in;  
            }
            final int numCollectors = randomIntBetween(1, 5);  
    private static class TerminateAfterBucketCollector extends BucketCollector {
        private int count = 0;
                final int expectedCount = terminateAfter > numDocs ? numDocs : terminateAfter;  
import java.util.Map;
                final int terminateAfter = random().nextInt(numDocs + 10);
                w.addDocument(doc);
            return ScoreMode.COMPLETE;  
import org.apache.lucene.search.Scorable;
import org.apache.lucene.document.Document;
        @Override  
                @Override
        public float score() {  
        expectThrows(CollectionTerminatedException.class, () -> { leafCollector.collect(1); });
        int getTotalHits() {
                collectors.add(new TerminateAfterBucketCollector(collector, terminateAfter));  
 * license agreements. See the NOTICE file distributed with
import java.util.ArrayList;
            return new LeafBucketCollectorBase(leafCollector, null) {
import org.apache.lucene.search.CollectionTerminatedException;
                    setScorerCalled.set(true);
    }
            this.in = in;
        assertFalse(setScorerCalled1.get());
        leafCollector.setScorer(scorer);
                    if (count >= terminateAfter) {
            w.close();
package org.opensearch.search.aggregations;
        List<BucketCollector> collectors = Arrays.asList(collector1, collector2);
 */  
        leafCollector.collect(0);
            }
            List<BucketCollector> collectors = new ArrayList<>();
        BucketCollector collector = MultiBucketCollector.wrap(collectors);
                throw new CollectionTerminatedException();
 * GitHub history for details.
import org.opensearch.test.OpenSearchTestCase;
 * specific language governing permissions and limitations
        Scorable scorer = new ScoreAndDoc();  
        leafCollector.collect(1);  
        Collections.shuffle(collectors, random());  
            this.terminateAfter = terminateAfter;
 * not use this file except in compliance with the License.
                    super.setScorer(scorer);  
import java.util.List;  
import java.util.HashMap;
