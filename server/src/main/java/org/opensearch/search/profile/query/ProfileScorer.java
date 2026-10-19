            public float matchCost() {
                nextDocTimer.start();
        this.scorer = scorer;
     * </p>
            }
    public DocIdSetIterator iterator() {
    public int docID() {  
                    advanceTimer.stop();  
                try {
                    return in.nextDoc();
                return inApproximation.docID();  
                } finally {
            public int docID() {  
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
                try {  
 * ownership. Elasticsearch licenses this file to you under  
                }
import java.io.IOException;
        shallowAdvanceTimer = profile.getTimer(QueryTimingType.SHALLOW_ADVANCE);  
 * Unless required by applicable law or agreed to in writing,
            @Override  
     * <p>
        setMinCompetitiveScoreTimer.start();  
 * GitHub history for details.
 * You may obtain a copy of the License at  
        } finally {  
        final DocIdSetIterator approximation = new DocIdSetIterator() {  
     *
            public boolean matches() throws IOException {
import org.apache.lucene.search.DocIdSetIterator;
        matchTimer = profile.getTimer(QueryTimingType.MATCH);
            return null;  
import org.opensearch.search.profile.Timer;  
                    return inApproximation.nextDoc();
        }
            }
 * {@link Scorer} wrapper that will compute how much time is spent on moving  
            scoreTimer.stop();
            public int nextDoc() throws IOException {
        shallowAdvanceTimer.start();
                try {
        return scorer.getChildren();
    public void setMinCompetitiveScore(float minScore) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.search.Scorer;
            return scorer.advanceShallow(target);  
            @Override  
    public int advanceShallow(int target) throws IOException {  
    @Override  
        final DocIdSetIterator inApproximation = in.approximation();
    @Override
 * this file be licensed under the Apache-2.0 license or a
    public Scorer getDelegate() {
    }
    }
    }  
                return inApproximation.cost();
                advanceTimer.start();
                } finally {  
 * software distributed under the License is distributed on an
        };
 * license agreements. See the NOTICE file distributed with
            @Override
            shallowAdvanceTimer.stop();
            @Override
final class ProfileScorer extends Scorer implements ProfilingWrapper<Scorer> {
            setMinCompetitiveScoreTimer.stop();
 */
    public Collection<ChildScorable> getChildren() throws IOException {  
 *
                }
 * KIND, either express or implied.  See the License for the
        return new TwoPhaseIterator(approximation) {
                matchTimer.start();
    }
package org.opensearch.search.profile.query;
     * Returns the wrapped scorer.  
 * the iterator, confirming matches and computing scores.
        return scorer;
            scorer.setMinCompetitiveScore(minScore);
            }  
     * @return the underlying wrapped scorer  
        try {
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
     * custom methods not part of the standard Scorer API, this is safe and expected.  
    @Override
        advanceTimer = profile.getTimer(QueryTimingType.ADVANCE);
import org.apache.lucene.search.TwoPhaseIterator;  
        }
 * The OpenSearch Contributors require contributions made to  
    @Override
            @Override
    @Override
                } finally {
            @Override
            }  
        } finally {
 * compatible open source license.
        try {
            }
            }
                    return in.matches();
        final TwoPhaseIterator in = scorer.twoPhaseIterator();
     * </p>
 *
     * <b>Note:</b> Calling mutation methods (like {@link #setMinCompetitiveScore(float)}) directly on the
import org.opensearch.search.profile.ProfilingWrapper;
        try {  
/**
 * not use this file except in compliance with the License.
            }
    }  
import org.opensearch.search.profile.AbstractProfileBreakdown;
                try {  
                nextDocTimer.start();  
                    advanceTimer.stop();
     * @see ProfileCollector#getDelegate()
                    return inApproximation.advance(target);  
     * This is useful for plugin queries that extend the Scorer API with custom methods not part of the standard
            return scorer.score();
            @Override  
     * wrapped scorer will bypass profiling instrumentation for those calls. For read-only access or accessing
    }  
    private final Timer scoreTimer, nextDocTimer, advanceTimer, matchTimer, shallowAdvanceTimer, computeMaxScoreTimer,  
            }
     */
     * Lucene Scorer interface. For example, neural-search's HybridQuery needs to access its HybridBulkScorer  
                    nextDocTimer.stop();
        return scorer.docID();
                } finally {
        nextDocTimer = profile.getTimer(QueryTimingType.NEXT_DOC);  
            @Override
    public float score() throws IOException {
        }  
     * <p>  
 * under the License.  
        }
                return in.docID();
        };
                    matchTimer.stop();  
import java.util.Collection;  
        scoreTimer = profile.getTimer(QueryTimingType.SCORE);
        } finally {  
            public long cost() {
 * specific language governing permissions and limitations
/*  
            public int nextDoc() throws IOException {
                return in.matchCost();  
    @Override
    /**
    public float getMaxScore(int upTo) throws IOException {
            public long cost() {
            computeMaxScoreTimer.stop();  
/*
            @Override  
                }
 */  
        return new DocIdSetIterator() {
        if (in == null) {
                return in.cost();  
        }
                advanceTimer.start();
 */
        computeMaxScoreTimer.start();
    ProfileScorer(Scorer scorer, AbstractProfileBreakdown profile) throws IOException {  
    private final Scorer scorer;
    }  
        try {
        } finally {
        };
                    nextDocTimer.stop();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                try {  
            public int advance(int target) throws IOException {  
            }
 * @opensearch.internal  
        final DocIdSetIterator in = scorer.iterator();  
                    return in.advance(target);
    }  
    @Override  
 */  
     * to call custom methods when profiling is enabled.
    }
                } finally {
            }
        setMinCompetitiveScoreTimer = profile.getTimer(QueryTimingType.SET_MIN_COMPETITIVE_SCORE);
        setMinCompetitiveScoreTimer;
 * SPDX-License-Identifier: Apache-2.0
 *
                }
        computeMaxScoreTimer = profile.getTimer(QueryTimingType.COMPUTE_MAX_SCORE);
            public int docID() {
            @Override
            return scorer.getMaxScore(upTo);
        scoreTimer.start();  
    }  
                }  
            public int advance(int target) throws IOException {
/*  
}
    @Override
    @Override
    public TwoPhaseIterator twoPhaseIterator() {  
