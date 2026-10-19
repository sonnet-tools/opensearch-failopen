    private static Scorer scorer(int maxDoc, final int[] docs, final float[] scores, final boolean twoPhase) {
            doTestRandom(false);
 */
        Scorer minScoreScorer = new MinScoreScorer(fakeWeight(), scorer, minScore);
    }  
        }
            public int docID() {
            }  
        final int[] docs = new int[numDocs];
 * The OpenSearch Contributors require contributions made to  
                assertNotEquals("score() called twice on doc " + docID(), lastScoredDoc, docID());
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
            uniqueDocs.add(random().nextInt(maxDoc));
                return null;  
                }  
 * SPDX-License-Identifier: Apache-2.0
                return false;
            int idx = Arrays.binarySearch(docs, target);  
    public void testRegularIterator() throws IOException {
            } else {  
        return new Weight(new MatchAllDocsQuery()) {  
import java.util.HashSet;
            }  
            }
        int i = 0;
            while (idx < docs.length && scores[idx] < minScore) {
/*  
                doc = minScoreScorer.iterator().advance(target);
                    return TwoPhaseIterator.asDocIdSetIterator(twoPhaseIterator());  
}
        final DocIdSetIterator iterator = twoPhase ? DocIdSetIterator.all(maxDoc) : iterator(docs);
                return null;
 * GitHub history for details.
    }
import org.apache.lucene.search.Scorer;
package org.opensearch.common.lucene.search.function;
        final int maxDoc = TestUtil.nextInt(random(), 10, 10000);
public class MinScoreScorerTests extends LuceneTestCase {
                return i < 0 ? -1 : i == docs.length ? NO_MORE_DOCS : docs[i];
                if (i + 1 == docs.length) {
 * You may obtain a copy of the License at  
        final int iters = atLeast(5);
            }
                return slowAdvance(target);  
            @Override  
        final float[] scores = new float[numDocs];
            }  
                } else {
            if (random().nextBoolean()) {
 * this work for additional information regarding copyright
        }  
            @Override
import java.util.Arrays;
                target = doc + 1;  
            @Override
                assertEquals(docs[idx], doc);
import org.apache.lucene.tests.util.TestUtil;
 * Licensed to Elasticsearch under one or more contributor  
            @Override  
                return Float.MAX_VALUE;
    }
    }
                        @Override  
 *     http://www.apache.org/licenses/LICENSE-2.0
                        }
        while (uniqueDocs.size() < numDocs) {
                    return iterator;
            }
 */  
        }
            }
                final int idx = Arrays.binarySearch(docs, docID());
import org.apache.lucene.search.DocIdSetIterator;
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
/*  
import org.apache.lucene.search.Explanation;  
            int i = -1;
import org.apache.lucene.tests.util.LuceneTestCase;  
            @Override
        return new DocIdSetIterator() {
            @Override  
            @Override
import org.apache.lucene.search.TwoPhaseIterator;
            public float getMaxScore(int upTo) throws IOException {  
            docs[i++] = doc;
            public boolean isCacheable(LeafReaderContext ctx) {
                idx += 1;
import java.io.IOException;  
                } else {
    private static Weight fakeWeight() {
 *  
            if (idx == docs.length) {
        }
            }
            public TwoPhaseIterator twoPhaseIterator() {  
                return scores[idx];
            }  
    public void testTwoPhaseIterator() throws IOException {
            public int nextDoc() throws IOException {
                        public boolean matches() throws IOException {
import org.apache.lucene.search.MatchAllDocsQuery;
            @Override
                        @Override
 * Unless required by applicable law or agreed to in writing,
        final Set<Integer> uniqueDocs = new HashSet<>();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final int numDocs = TestUtil.nextInt(random(), 1, maxDoc / 2);
import org.apache.lucene.index.LeafReaderContext;
                        }  
            public int docID() {
                    };
            @Override  
 * ownership. Elasticsearch licenses this file to you under  
            public long cost() {  
                        public float matchCost() {
                assertEquals(scores[idx], minScoreScorer.score(), 0f);
            int lastScoredDoc = -1;
            scores[i] = random().nextFloat();  
            public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
            if (idx < 0) {
 *
 * license agreements. See the NOTICE file distributed with
                target = doc + TestUtil.nextInt(random(), 1, 10);  
                }
                    return docs[++i];
    private static DocIdSetIterator iterator(final int... docs) {
 */  
        while (doc != DocIdSetIterator.NO_MORE_DOCS) {  
                idx = -1 - idx;
            }
import org.apache.lucene.search.Weight;
                if (twoPhase) {
            doTestRandom(true);
        }
                return iterator.docID();  
 * the Apache License, Version 2.0 (the "License"); you may
        };
 * under the License.  
                    return null;  
 * Modifications Copyright OpenSearch Contributors. See
        Scorer scorer = scorer(maxDoc, docs, scores, twoPhase);
    }
 * this file be licensed under the Apache-2.0 license or a
            }
            }
            public DocIdSetIterator iterator() {
        for (int doc : uniqueDocs) {  
            final int target;
                assertEquals(DocIdSetIterator.NO_MORE_DOCS, doc);
                } else {
        Arrays.sort(docs);  
            }  
                            return Arrays.binarySearch(docs, iterator.docID()) >= 0;  
            public float score() throws IOException {
        for (i = 0; i < numDocs; ++i) {
            @Override
import java.util.Set;  
        }  
                return docs.length;
                doc = minScoreScorer.iterator().nextDoc();
            } else {
 *
        final int iters = atLeast(5);  
                    return new TwoPhaseIterator(iterator) {
        int doc = -1;
            public int advance(int target) throws IOException {
 * specific language governing permissions and limitations
            }
                }  
            public Explanation explain(LeafReaderContext context, int doc) throws IOException {  
        };
                    return NO_MORE_DOCS;  
        };  
    public void doTestRandom(boolean twoPhase) throws IOException {  
            }
    }  
        for (int iter = 0; iter < iters; ++iter) {  
import org.apache.lucene.search.ScorerSupplier;  
            }  
                if (twoPhase) {
                lastScoredDoc = docID();  
/*
        return new Scorer() {  
                            return 10;
        for (int iter = 0; iter < iters; ++iter) {
        final float minScore = random().nextFloat();  
