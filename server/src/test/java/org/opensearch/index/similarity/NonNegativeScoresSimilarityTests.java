/*  
            @Override
                };
 * the Apache License, Version 2.0 (the "License"); you may
            public long computeNorm(FieldInvertState state) {  
        Similarity assertingSimilarity = new NonNegativeScoresSimilarity(negativeScoresSim);
    public void testBasics() {
            public SimScorer scorer(float boost, CollectionStatistics collectionStats, TermStatistics... termStats) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
        };
 */  
            }  
                    }
package org.opensearch.index.similarity;
 * Licensed to Elasticsearch under one or more contributor  
                        return freq - 5;  
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
                    public float score(float freq, long norm) {
import org.apache.lucene.search.similarities.Similarity.SimScorer;
 * GitHub history for details.
            }
 *
 * SPDX-License-Identifier: Apache-2.0
                    @Override
 *  
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 *     http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
 */  
                return state.getLength();
import org.apache.lucene.search.similarities.Similarity;
import org.apache.lucene.search.CollectionStatistics;
 * license agreements. See the NOTICE file distributed with
public class NonNegativeScoresSimilarityTests extends OpenSearchTestCase {  
/*  
 * ownership. Elasticsearch licenses this file to you under  
import org.hamcrest.Matchers;
        Similarity negativeScoresSim = new Similarity() {  
import org.apache.lucene.index.FieldInvertState;
/*
 * The OpenSearch Contributors require contributions made to  
 */
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> scorer.score(2f, 1L));
}  
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
            @Override
        assertEquals(2f, scorer.score(7f, 1L), 0f);
 * Unless required by applicable law or agreed to in writing,
                return new SimScorer() {  
        assertThat(e.getMessage(), Matchers.containsString("Similarities must not produce negative scores"));  
 * specific language governing permissions and limitations
 * compatible open source license.
    }
 *
        SimScorer scorer = assertingSimilarity.scorer(1f, null);  
import org.apache.lucene.search.TermStatistics;  
import org.opensearch.test.OpenSearchTestCase;  
