        }
import org.opensearch.script.SimilarityWeightScript;
            this.docCount = docCount;
                public float score(float freq, long norm) {
                    return Explanation.match(score(freq.getValue().floatValue(), norm), "Sum of:", subs);
        public float getFreq() {
     * @opensearch.internal
        public long getSumDocFreq() {
        private final long sumDocFreq;
        boolean discountOverlaps
     * Statistics that are specific to a given field.
    }
     * Statistics that are specific to a given term.
}
                    }
        public long getDocFreq() {
        }
        private Field(long docCount, long sumDocFreq, long sumTotalTermFreq) {
    public static class Query {
     * Scoring factors that come from the query.
    public static class Term {
 * Unless required by applicable law or agreed to in writing,
                        Explanation.match(doc.getLength(), "doc.length")
                        score,
            return new SimScorer() {
        private long norm;
    final String scriptSource;
        public float getBoost() {
/*
                        Explanation.match(query.boost, "query.boost"),
                @Override
        final int numTerms = discountOverlaps ? state.getLength() - state.getNumOverlap() : state.getLength();
            return freq;
        this.scriptFactory = scriptFactory;
        private Doc() {}
        }
public final class ScriptedSimilarity extends Similarity {
                    return Explanation.match(
 *
        long docCount = collectionStats.docCount();
         *  or {@code -1} if this statistic is not available. */
 * SPDX-License-Identifier: Apache-2.0
        }
        public long getSumTotalTermFreq() {
        /** Return the number of occurrences of the term in the current document for the considered field. */
        }
    @Override
 * The OpenSearch Contributors require contributions made to
                        subs[i] = scorers[i].explain(freq, norm);
 *    http://www.apache.org/licenses/LICENSE-2.0
            // Sum scores across terms like a BooleanQuery would do
                    Explanation[] subs = new Explanation[scorers.length];
        private final long totalTermFreq;
        /** Return the number of tokens that the current document has in the considered field. */
        private final long docCount;
        private Term(long docFreq, long totalTermFreq) {
            return boost;
                }
        }
            // not penalized
import org.apache.lucene.util.SmallFloat;
    }
            final double scoreWeight = computeWeight(query, field, term);
    public String toString() {
    public static class Doc {
            return totalTermFreq;
                        Explanation.match(term.totalTermFreq, "term.totalTermFreq"),
     */
            return sumTotalTermFreq;
        for (int i = 0; i < terms.length; ++i) {
    }
 * specific language governing permissions and limitations
        /** Return the number of documents that contain this term in the index. */
            this.boost = boost;
     */
        for (int i = 0; i < termStats.length; ++i) {
    final SimilarityWeightScript.Factory weightScriptFactory;
                @Override
                public float score(float freq, long norm) {
                        Explanation.match(term.docFreq, "term.docFreq"),
        Query query = new Query(boost);
     * @opensearch.internal
        }
    /**
            scorers[i] = new SimScorer() {
                    }
     * @opensearch.internal
            };
            final Doc doc = new Doc();
            return 1d;
    }
 * not use this file except in compliance with the License.
    @Override
        private final long docFreq;
            this.sumDocFreq = sumDocFreq;
    }
                    for (int i = 0; i < subs.length; ++i) {
        }
        public int getLength() {
/*
        } else {
    final String weightScriptSource;
        this.weightScriptFactory = weightScriptFactory;
    /** Compute the part of the score that does not depend on the current document using the init_script. */
            final Term term = terms[i];
            return SmallFloat.byte4ToInt((byte) norm);
    @Override
    public static class Field {
            docCount = collectionStats.maxDoc();
     *
        Field field = new Field(docCount, collectionStats.sumDocFreq(), collectionStats.sumTotalTermFreq());
import org.apache.lucene.search.Explanation;
    /**
            return scorers[0];
                @Override
    /**
        return getClass().getSimpleName() + "(weightScript=[" + weightScriptSource + "], script=[" + scriptSource + "])";
 * Modifications Copyright OpenSearch Contributors. See
    }
 * this work for additional information regarding copyright
 * GitHub history for details.
                public Explanation explain(Explanation freq, long norm) {
        this.weightScriptSource = weightScriptString;
        /** Return the total number of occurrences of this term in the index, or {@code -1} if this statistic is not available. */
 * A {@link Similarity} implementation that allows scores to be scripted.
            terms[i] = new Term(termStats[i].docFreq(), termStats[i].totalTermFreq());
        }
/**
    /** Sole constructor. */
        if (scorers.length == 1) {
        private Query(float boost) {
                    doc.norm = norm;
            // the length is computed lazily so that similarities that do not use the length are
            return sumDocFreq;
    }
        public long getTotalTermFreq() {
     *
                        Explanation.match(field.sumTotalTermFreq, "field.sumTotalTermFreq"),
 * license agreements. See the NOTICE file distributed with
                    );
 * under the License.
    ) {
import org.apache.lucene.search.similarities.Similarity;
     * Statistics that are specific to a document.
 * KIND, either express or implied.  See the License for the
        }
import org.opensearch.script.SimilarityScript;
        String weightScriptString,
        private final long sumTotalTermFreq;
        SimilarityScript.Factory scriptFactory,
 * You may obtain a copy of the License at
 */
        SimilarityWeightScript.Factory weightScriptFactory,
        return weightScript.execute(query, field, term);
                        Explanation.match(field.docCount, "field.docCount"),
        /** Return the sum of {@link Term#getDocFreq()} for all terms that exist in this field,
import org.apache.lucene.search.CollectionStatistics;
        }
        if (docCount == -1) {
            final SimilarityScript script = scriptFactory.newInstance();
        this.scriptSource = scriptString;
        SimScorer[] scorers = new SimScorer[terms.length];
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.index.FieldInvertState;
        }
            this.sumTotalTermFreq = sumTotalTermFreq;
        this.discountOverlaps = discountOverlaps;
        private float freq;
                }
     * @opensearch.internal
    public ScriptedSimilarity(
    public SimScorer scorer(float boost, CollectionStatistics collectionStats, TermStatistics... termStats) {
 * @opensearch.internal
        public long getDocCount() {
                        Explanation.match((float) scoreWeight, "weight"),
 * ownership. Elasticsearch licenses this file to you under
 *
 *
        /** Return the sum of {@link Term#getTotalTermFreq()} for all terms that exist in this field,
 */
                    float score = score(freq.getValue().floatValue(), norm);
                        "score from " + ScriptedSimilarity.this.toString() + " computed from:",
                    for (SimScorer scorer : scorers) {
                        sum += scorer.score(freq, norm);
                    return (float) sum;
     */
        String scriptString,
 */
        }
 * Licensed to Elasticsearch under one or more contributor
    public long computeNorm(FieldInvertState state) {
        /** The boost of the query. It should typically be incorporated into the score as a multiplicative factor. */
            this.docFreq = docFreq;
        if (weightScriptFactory == null) {
        }
    final boolean discountOverlaps;
                }
    }
                    return (float) script.execute(scoreWeight, query, field, term, doc);
     */
                        Explanation.match(freq.getValue(), "doc.freq", freq.getDetails()),
        }
    private double computeWeight(Query query, Field field, Term term) {
            };
                @Override
        return SmallFloat.intToByte4(numTerms);
                        Explanation.match(field.sumDocFreq, "field.sumDocFreq"),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        private final float boost;
        /** Return the number of documents that have a value for this field. */
 * compatible open source license.
        }
package org.opensearch.index.similarity;
    /**
            this.totalTermFreq = totalTermFreq;
     *
import org.apache.lucene.search.TermStatistics;
 * software distributed under the License is distributed on an
     *
                    doc.freq = freq;
                    double sum = 0;
 * the Apache License, Version 2.0 (the "License"); you may
         *  or {@code -1} if this statistic is not available. */
/*
                public Explanation explain(Explanation freq, long norm) {
 *
                }
 */
        SimilarityWeightScript weightScript = weightScriptFactory.newInstance();
            return docCount;
    }
    final SimilarityScript.Factory scriptFactory;
            return docFreq;
        Term[] terms = new Term[termStats.length];
