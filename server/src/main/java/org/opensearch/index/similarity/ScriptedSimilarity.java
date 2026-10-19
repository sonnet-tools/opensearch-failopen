    /** Sole constructor. */
        public int getLength() {
    }  
        }  
    /**  
import org.opensearch.script.SimilarityScript;
        public float getFreq() {  
    }  
        SimilarityWeightScript.Factory weightScriptFactory,
import org.apache.lucene.search.TermStatistics;
        }
                public Explanation explain(Explanation freq, long norm) {  
    public static class Query {
package org.opensearch.index.similarity;
}
                public float score(float freq, long norm) {
        SimilarityScript.Factory scriptFactory,
import org.apache.lucene.index.FieldInvertState;
    final SimilarityWeightScript.Factory weightScriptFactory;
     * Statistics that are specific to a document.  
                        Explanation.match(freq.getValue(), "doc.freq", freq.getDetails()),  
        private final long docCount;  
                    for (SimScorer scorer : scorers) {  
            this.sumTotalTermFreq = sumTotalTermFreq;
                    double sum = 0;
        private final float boost;  
        private final long sumDocFreq;
        SimScorer[] scorers = new SimScorer[terms.length];
 * this file be licensed under the Apache-2.0 license or a
    }
    public static class Term {  
        }
        /** Return the sum of {@link Term#getTotalTermFreq()} for all terms that exist in this field,  
        /** Return the number of documents that contain this term in the index. */  
            return sumTotalTermFreq;  
        private float freq;
            this.boost = boost;  
     * @opensearch.internal  
    }  
    public static class Doc {
    public String toString() {  
                }
            // the length is computed lazily so that similarities that do not use the length are  
 */  
        this.scriptSource = scriptString;  
         *  or {@code -1} if this statistic is not available. */
            // not penalized
        }
                @Override  
        Field field = new Field(docCount, collectionStats.sumDocFreq(), collectionStats.sumTotalTermFreq());
    final SimilarityScript.Factory scriptFactory;
 * @opensearch.internal
 *
 * GitHub history for details.
        private Term(long docFreq, long totalTermFreq) {
import org.apache.lucene.util.SmallFloat;  
     * @opensearch.internal  
    }
        /** Return the number of occurrences of the term in the current document for the considered field. */
        private final long totalTermFreq;
    public ScriptedSimilarity(  
        public long getSumTotalTermFreq() {
     *  
        return getClass().getSimpleName() + "(weightScript=[" + weightScriptSource + "], script=[" + scriptSource + "])";
            return docCount;  
                    return (float) script.execute(scoreWeight, query, field, term, doc);
 * the Apache License, Version 2.0 (the "License"); you may
            return scorers[0];
     * Statistics that are specific to a given field.
    public long computeNorm(FieldInvertState state) {
            return 1d;
 *  
        return weightScript.execute(query, field, term);
        public long getSumDocFreq() {
                    }
        SimilarityWeightScript weightScript = weightScriptFactory.newInstance();  
 * Licensed to Elasticsearch under one or more contributor  
    @Override
 * Modifications Copyright OpenSearch Contributors. See
    /**
 */
 * not use this file except in compliance with the License.
        }  
/*  
                        score,  
        long docCount = collectionStats.docCount();
            final Term term = terms[i];
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
        public long getDocFreq() {
         *  or {@code -1} if this statistic is not available. */
     */
                public Explanation explain(Explanation freq, long norm) {
        /** Return the total number of occurrences of this term in the index, or {@code -1} if this statistic is not available. */
        final int numTerms = discountOverlaps ? state.getLength() - state.getNumOverlap() : state.getLength();  
        /** Return the number of tokens that the current document has in the considered field. */
import org.opensearch.script.SimilarityWeightScript;
            final Doc doc = new Doc();  
        for (int i = 0; i < termStats.length; ++i) {
        } else {
                    return (float) sum;  
        }  
        Term[] terms = new Term[termStats.length];  
/**
                    );
            return boost;
                }  
        private final long docFreq;
            return sumDocFreq;  
        }  
            };
    @Override
                @Override  
        private Field(long docCount, long sumDocFreq, long sumTotalTermFreq) {
        }  
 * this work for additional information regarding copyright
                public float score(float freq, long norm) {
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
            // Sum scores across terms like a BooleanQuery would do  
    final String scriptSource;  
                        "score from " + ScriptedSimilarity.this.toString() + " computed from:",
        public float getBoost() {
            scorers[i] = new SimScorer() {
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
            this.docCount = docCount;
                    Explanation[] subs = new Explanation[scorers.length];
        /** Return the number of documents that have a value for this field. */
    ) {  
                        subs[i] = scorers[i].explain(freq, norm);
 * software distributed under the License is distributed on an
     *
    final boolean discountOverlaps;  
        this.scriptFactory = scriptFactory;
            this.docFreq = docFreq;
 *
    }
/*  
     */  
                        Explanation.match(field.docCount, "field.docCount"),
        public long getTotalTermFreq() {  
        }
        return SmallFloat.intToByte4(numTerms);
                        Explanation.match(query.boost, "query.boost"),  
    }
            final double scoreWeight = computeWeight(query, field, term);
        Query query = new Query(boost);  
/*
            return SmallFloat.byte4ToInt((byte) norm);
        this.weightScriptSource = weightScriptString;
            return new SimScorer() {
            final SimilarityScript script = scriptFactory.newInstance();
        boolean discountOverlaps
import org.apache.lucene.search.CollectionStatistics;
 */  
    @Override
        }
        String scriptString,  
    private double computeWeight(Query query, Field field, Term term) {
import org.apache.lucene.search.Explanation;  
                }  
    final String weightScriptSource;
 */
    }
        this.discountOverlaps = discountOverlaps;
    /**  
    public static class Field {
     *
                        sum += scorer.score(freq, norm);
     * Scoring factors that come from the query.
        if (docCount == -1) {
 * Unless required by applicable law or agreed to in writing,
                }
 *  
        private Query(float boost) {
public final class ScriptedSimilarity extends Similarity {  
     * @opensearch.internal
            this.totalTermFreq = totalTermFreq;  
                    float score = score(freq.getValue().floatValue(), norm);
            };
                    }
                        Explanation.match(term.docFreq, "term.docFreq"),
     * Statistics that are specific to a given term.
 * KIND, either express or implied.  See the License for the
        /** Return the sum of {@link Term#getDocFreq()} for all terms that exist in this field,  
        public long getDocCount() {
        if (weightScriptFactory == null) {  
 * A {@link Similarity} implementation that allows scores to be scripted.
        private Doc() {}
        }
        }
        }
                    doc.freq = freq;  
                @Override
    public SimScorer scorer(float boost, CollectionStatistics collectionStats, TermStatistics... termStats) {
     *
            return totalTermFreq;
 * SPDX-License-Identifier: Apache-2.0
                @Override
                        Explanation.match(doc.getLength(), "doc.length")
 * ownership. Elasticsearch licenses this file to you under  
     * @opensearch.internal
            return freq;
 *    http://www.apache.org/licenses/LICENSE-2.0
                        Explanation.match(term.totalTermFreq, "term.totalTermFreq"),
            docCount = collectionStats.maxDoc();  
 * license agreements. See the NOTICE file distributed with
                        Explanation.match(field.sumTotalTermFreq, "field.sumTotalTermFreq"),  
    /** Compute the part of the score that does not depend on the current document using the init_script. */
import org.apache.lucene.search.similarities.Similarity;
        this.weightScriptFactory = weightScriptFactory;
                    return Explanation.match(score(freq.getValue().floatValue(), norm), "Sum of:", subs);  
                    for (int i = 0; i < subs.length; ++i) {  
        /** The boost of the query. It should typically be incorporated into the score as a multiplicative factor. */  
        if (scorers.length == 1) {  
    /**
                    return Explanation.match(
        private final long sumTotalTermFreq;
            terms[i] = new Term(termStats[i].docFreq(), termStats[i].totalTermFreq());
    }
        private long norm;  
        for (int i = 0; i < terms.length; ++i) {  
                    doc.norm = norm;
        String weightScriptString,
     */
                        Explanation.match((float) scoreWeight, "weight"),
                        Explanation.match(field.sumDocFreq, "field.sumDocFreq"),
        }
            return docFreq;
            this.sumDocFreq = sumDocFreq;  
     */
 * under the License.  
