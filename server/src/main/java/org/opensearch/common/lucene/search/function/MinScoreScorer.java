 * KIND, either express or implied.  See the License for the
            public float matchCost() {
    private final float minScore;
 *     http://www.apache.org/licenses/LICENSE-2.0
        };  
 */
import java.io.IOException;  
import org.apache.lucene.search.Scorer;
 * The OpenSearch Contributors require contributions made to  
        this.in = scorer;
        super();
    public TwoPhaseIterator twoPhaseIterator() {  
    public DocIdSetIterator iterator() {
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
 *  
        return in.getMaxScore(upTo);  
        final DocIdSetIterator approximation = inTwoPhase == null ? in.iterator() : inTwoPhase.approximation();
        return TwoPhaseIterator.asDocIdSetIterator(twoPhaseIterator());
    @Override
 * lower than a configured constant.
    }
    public int docID() {
            @Override
 *
    public int advanceShallow(int target) throws IOException {  
    private final Scorer in;
        return in.advanceShallow(target);
        this.minScore = minScore;  
import org.apache.lucene.search.TwoPhaseIterator;  
 * this file be licensed under the Apache-2.0 license or a
    }
                return 1000f // random constant for the score computation  
                }
        return new TwoPhaseIterator(approximation) {  
    public Scorer getScorer() {  
 * not use this file except in compliance with the License.
    }  
 * GitHub history for details.
                curScore = in.score();  
    @Override  
    @Override
import org.apache.lucene.search.Weight;
 * the Apache License, Version 2.0 (the "License"); you may
                    + (inTwoPhase == null ? 0 : inTwoPhase.matchCost());
    }
    }  
 * ownership. Elasticsearch licenses this file to you under  
        return in.docID();  
    }
    }
    }
        final TwoPhaseIterator inTwoPhase = this.in.twoPhaseIterator();
package org.opensearch.common.lucene.search.function;
 *
/**
/*  
 * specific language governing permissions and limitations
/*
            @Override
    MinScoreScorer(Weight weight, Scorer scorer, float minScore) {  
/*  
 *  @opensearch.internal  
 */
    @Override
final class MinScoreScorer extends Scorer {
 * Licensed to Elasticsearch under one or more contributor  
    private float curScore;
                return curScore >= minScore;
 * A {@link Scorer} that filters out documents that have a score that is  
                // we need to check the two-phase iterator first
import org.apache.lucene.search.DocIdSetIterator;
    public float score() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
            }
                // otherwise calling score() is illegal
 * SPDX-License-Identifier: Apache-2.0
}
                    return false;
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
                if (inTwoPhase != null && inTwoPhase.matches() == false) {  
 */  
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
    @Override
            public boolean matches() throws IOException {  
 */  
        return curScore;
            }
        return in;
 * under the License.  
    @Override  
    public float getMaxScore(int upTo) throws IOException {
