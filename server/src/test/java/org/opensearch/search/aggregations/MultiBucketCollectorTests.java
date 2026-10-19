        }
        BucketCollector collector1 = new TotalHitCountBucketCollector();
 * Unless required by applicable law or agreed to in writing,
        public ScoreMode scoreMode() {
                    super.collect(doc, bucket);
            return new LeafBucketCollector() {
    }
                }
        }
                final int expectedCount = terminateAfter > numDocs ? numDocs : terminateAfter;
 * SPDX-License-Identifier: Apache-2.0
}
        assertTrue(setScorerCalled1.get());
import org.apache.lucene.store.Directory;
        collector1 = new TerminateAfterBucketCollector(collector1, 1);
    private static class SetScorerBucketCollector extends BucketCollector {
import java.util.Map;
        }
package org.opensearch.search.aggregations;
/*
    public void testCollectionTerminatedExceptionHandling() throws IOException {
            this.in = in;
            return ScoreMode.COMPLETE;
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.index.LeafReaderContext;
            };
import java.util.Arrays;
            final int numCollectors = randomIntBetween(1, 5);
        setScorerCalled1.set(false);
                    super.setScorer(scorer);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * under the License.
            final IndexReader reader = w.getReader();
        assertFalse(setScorerCalled2.get());
 * not use this file except in compliance with the License.
                collectors.add(new TerminateAfterBucketCollector(collector, terminateAfter));
 * the Apache License, Version 2.0 (the "License"); you may
public class MultiBucketCollectorTests extends OpenSearchTestCase {
                expectedCounts.put(collector, expectedCount);
        public void preCollection() {}
                public void setScorer(Scorable scorer) throws IOException {
                @Override
        public void preCollection() {}
 */
        public void postCollection() {}
            this.terminateAfter = terminateAfter;
            for (int i = 0; i < numDocs; ++i) {
    }
        @Override
                    count++;
        @Override
        }
 */
import org.apache.lucene.index.IndexReader;
                    setScorerCalled.set(true);
            }
        collector2 = new SetScorerBucketCollector(collector2, setScorerCalled2);
        public LeafBucketCollector getLeafCollector(LeafReaderContext context) throws IOException {
        leafCollector.setScorer(scorer);
        @Override
        public LeafBucketCollector getLeafCollector(LeafReaderContext context) {
        }
        float score;
            return score;
        assertFalse(setScorerCalled1.get());
        public float score() {
        TotalHitCountBucketCollector() {}
            this.in = in;
        SetScorerBucketCollector(BucketCollector in, AtomicBoolean setScorerCalled) {
        assertTrue(setScorerCalled2.get());
            searcher.search(new MatchAllDocsQuery(), MultiBucketCollector.wrap(collectors));
            };
            }
                w.addDocument(doc);
    }
 *
        int getTotalHits() {
                    }
import org.apache.lucene.document.Document;
        }
        Scorable scorer = new ScoreAndDoc();
        public void preCollection() {}
        assertFalse(setScorerCalled1.get());
            return new LeafBucketCollectorBase(leafCollector, null) {
            Directory dir = newDirectory();
        setScorerCalled2.set(false);
        @Override
import org.apache.lucene.search.ScoreMode;
        @Override
                @Override
 * this file be licensed under the Apache-2.0 license or a
                    if (count >= terminateAfter) {
import java.io.IOException;
        private final int terminateAfter;
        expectThrows(CollectionTerminatedException.class, () -> { leafCollector.collect(1); });
    public void testSetScorerAfterCollectionTerminated() throws IOException {
        private final BucketCollector in;
import java.util.Collections;
        private int count = 0;
            return new LeafBucketCollectorBase(leafCollector, null) {
        AtomicBoolean setScorerCalled2 = new AtomicBoolean();
        collector2 = new TerminateAfterBucketCollector(collector2, 2);
    private static class TotalHitCountBucketCollector extends BucketCollector {
                }
        final int iters = atLeast(3);
import org.apache.lucene.search.MatchAllDocsQuery;
            return ScoreMode.COMPLETE_NO_SCORES;
 *
        BucketCollector collector = MultiBucketCollector.wrap(collectors);
        @Override
import org.apache.lucene.tests.index.RandomIndexWriter;
            this.setScorerCalled = setScorerCalled;
    }
import java.util.HashMap;
 * Modifications Copyright OpenSearch Contributors. See
        setScorerCalled2.set(false);
            final Document doc = new Document();
                        throw new CollectionTerminatedException();
        LeafBucketCollector leafCollector = collector.getLeafCollector(null);
            dir.close();
            };
        }
        @Override
import java.util.ArrayList;
            Map<TotalHitCountBucketCollector, Integer> expectedCounts = new HashMap<>();
            }
 * GitHub history for details.
import org.apache.lucene.search.CollectionTerminatedException;
 */
                @Override
import org.apache.lucene.search.Scorable;
        @Override
 * The OpenSearch Contributors require contributions made to
                final int terminateAfter = random().nextInt(numDocs + 10);
        }
        leafCollector.setScorer(scorer);
        public void postCollection() {}
        public LeafBucketCollector getLeafCollector(LeafReaderContext context) throws IOException {
            final IndexSearcher searcher = newSearcher(reader);
                    count++;
            final int numDocs = randomIntBetween(100, 1000);
        leafCollector.collect(1);
import java.util.concurrent.atomic.AtomicBoolean;
 * KIND, either express or implied.  See the License for the
        @Override
 * this work for additional information regarding copyright
        assertTrue(setScorerCalled2.get());
        private final BucketCollector in;
 *    http://www.apache.org/licenses/LICENSE-2.0
        @Override
            for (Map.Entry<TotalHitCountBucketCollector, Integer> expectedCount : expectedCounts.entrySet()) {
 * compatible open source license.
                public void collect(int doc, long bucket) throws IOException {
            w.close();
        TerminateAfterBucketCollector(BucketCollector in, int terminateAfter) {
import java.util.List;
            final LeafBucketCollector leafCollector = in.getLeafCollector(context);
        private final AtomicBoolean setScorerCalled;
            return ScoreMode.COMPLETE;
            List<BucketCollector> collectors = new ArrayList<>();
        @Override
import org.opensearch.test.OpenSearchTestCase;
        }
        setScorerCalled1.set(false);
            reader.close();
 * ownership. Elasticsearch licenses this file to you under
        leafCollector.setScorer(scorer);
        }
        for (int iter = 0; iter < iters; ++iter) {
        collector1 = new SetScorerBucketCollector(collector1, setScorerCalled1);
                throw new CollectionTerminatedException();
        @Override
    private static class TerminateAfterBucketCollector extends BucketCollector {
                }
            return count;
                assertEquals(expectedCount.getValue().intValue(), expectedCount.getKey().getTotalHits());
        private int count = 0;
 *
 * software distributed under the License is distributed on an
import org.apache.lucene.search.IndexSearcher;
        public ScoreMode scoreMode() {
        @Override
/*
    }
            }
 * Licensed to Elasticsearch under one or more contributor
            for (int i = 0; i < numCollectors; ++i) {
        List<BucketCollector> collectors = Arrays.asList(collector1, collector2);
                TotalHitCountBucketCollector collector = new TotalHitCountBucketCollector();
        Collections.shuffle(collectors, random());
        BucketCollector collector2 = new TotalHitCountBucketCollector();
    private static class ScoreAndDoc extends Scorable {
            RandomIndexWriter w = new RandomIndexWriter(random(), dir);
        }
 * You may obtain a copy of the License at
    }
        public void postCollection() {}
            if (count >= terminateAfter) {
 * specific language governing permissions and limitations
        leafCollector.collect(0);
/*
        AtomicBoolean setScorerCalled1 = new AtomicBoolean();
                public void collect(int doc, long bucket) throws IOException {
        public ScoreMode scoreMode() {
            final LeafBucketCollector leafCollector = in.getLeafCollector(context);
