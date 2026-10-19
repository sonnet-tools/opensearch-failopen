                    expl = Explanation.match(0f, "max of:", expl, Explanation.match(0f, "Minimum allowed score"));
            }
                Explanation expl = inScorer.explain(freq, norm);
    }
                                + inScorer.explain(Explanation.match(freq, "term frequency"), norm)  
import org.apache.lucene.index.FieldInvertState;
    public NonNegativeScoresSimilarity(Similarity in) {
    }  
    private final Similarity in;  
 * @opensearch.internal  
 * this file be licensed under the Apache-2.0 license or a
                float score = inScorer.score(freq, norm);
                            "Similarities must not produce negative scores, but got:\n"
    }
    }
public final class NonNegativeScoresSimilarity extends Similarity {  
            @Override
            ENFORCE_POSITIVE_SCORES = true;
 */
 * software distributed under the License is distributed on an
 * under the License.  
                OPENSEARCH_ENFORCE_POSITIVE_SCORES + " may only be unset or set to [false], but got [" + enforcePositiveScores + "]"
 * license agreements. See the NOTICE file distributed with
                        );
 */
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
    static {
            ENFORCE_POSITIVE_SCORES = false;
    @Override  
    public SimScorer scorer(float boost, CollectionStatistics collectionStats, TermStatistics... termStats) {
}
        } else {
            @Override  
 *  
        return in.computeNorm(state);  
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String enforcePositiveScores = System.getProperty(OPENSEARCH_ENFORCE_POSITIVE_SCORES);  
 * Modifications Copyright OpenSearch Contributors. See
            public float score(float freq, long norm) {  
/*  
import org.apache.lucene.search.TermStatistics;
                if (score < 0f) {
    public long computeNorm(FieldInvertState state) {
 *
/**
    private static final boolean ENFORCE_POSITIVE_SCORES;
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to  
                    }
// public for testing
                if (expl.isMatch() && expl.getValue().floatValue() < 0) {  
 * the Apache License, Version 2.0 (the "License"); you may
        this.in = in;  
 *
    private static final String OPENSEARCH_ENFORCE_POSITIVE_SCORES = "opensearch.enforce.positive.scores";  
 * KIND, either express or implied.  See the License for the
 */  
                        throw new IllegalArgumentException(
import org.apache.lucene.search.similarities.Similarity;
            }
            );
                }
package org.opensearch.index.similarity;
                        return 0f;  
            public Explanation explain(Explanation freq, long norm) {
                    } else {
import org.apache.lucene.search.CollectionStatistics;
 * an error instead of silently corrupt top hits. It should be applied to any custom or  
 */  
/*
                return expl;  
                return score;  
import org.apache.lucene.search.Explanation;  
    public Similarity getDelegate() {  
 * specific language governing permissions and limitations
        if (enforcePositiveScores == null) {
 * GitHub history for details.
                }
    @Override
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
        return in;
 * Unless required by applicable law or agreed to in writing,
            throw new IllegalArgumentException(  
 * A {@link Similarity} that rejects negative scores. This class exists so that users get
        final SimScorer inScorer = in.scorer(boost, collectionStats, termStats);
    }
        return new SimScorer() {  
        } else if ("false".equals(enforcePositiveScores)) {  
/*  
    // Escape hatch
        };
        }  
                    if (ENFORCE_POSITIVE_SCORES) {  
 * scripted similarity.
