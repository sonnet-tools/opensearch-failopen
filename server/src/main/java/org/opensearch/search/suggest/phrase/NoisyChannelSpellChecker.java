 * Modifications Copyright OpenSearch Contributors. See  
 * Licensed to Elasticsearch under one or more contributor  
        this.tokenLimit = tokenLimit;
            }
                        currentSet.addOneCandidate(generator.createCandidate(BytesRef.deepCopyOf(term), termStats, realWordLikelihood));
 * this file be licensed under the Apache-2.0 license or a
 */  
        }
        this.realWordLikelihood = nonErrorLikelihood;  
        }  
                    candidateSetsList.add(currentSet);  
            }
                if (requireUnigram && !anyUnigram && anyTokens) {
    private final int tokenLimit;  
 */
 * this work for additional information regarding copyright
import org.apache.lucene.analysis.TokenStream;  
            return Result.EMPTY;  
                    TermStats termStats = generator.termStats(term);  
 *
    NoisyChannelSpellChecker(double nonErrorLikelihood, boolean requireUnigram, int tokenLimit) {
            this.corrections = corrections;
                } else {
/*  
/*
import java.util.List;  
        });  
import java.util.ArrayList;
    private final boolean requireUnigram;
        }
 * license agreements. See the NOTICE file distributed with
 * Spell checker based on a noisy channel  
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.util.BytesRef;
import org.opensearch.search.suggest.phrase.DirectCandidateGenerator.Candidate;
        this.requireUnigram = requireUnigram;
        public final Correction[] corrections;  
 * KIND, either express or implied.  See the License for the
 * @opensearch.internal
import org.opensearch.search.suggest.phrase.DirectCandidateGenerator.CandidateSet;
 * specific language governing permissions and limitations
            @Override
 *
            private TypeAttribute typeAttribute;  
    public static final int DEFAULT_TOKEN_LIMIT = 10;  
    private final double realWordLikelihood;
                if (requireUnigram && typeAttribute.type() == ShingleFilter.DEFAULT_TOKEN_TYPE) {  
 * SPDX-License-Identifier: Apache-2.0
            public void end() {
 * not use this file except in compliance with the License.
                candidates[i] = candidateSets[i].originalTerm;  
                anyTokens = true;
import org.apache.lucene.codecs.TermStats;
                    return;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
        int numCorrections,  
        WordScorer wordScorer,
            public void reset(TokenStream stream) {  
}
                anyUnigram = true;  
/**
            Candidate[] candidates = new Candidate[candidateSets.length];
 *
                    if (termStats.docFreq() > 0) {
            cutoffScore = inputPhraseScore * confidence;  
    public static final double REAL_WORD_LIKELIHOOD = 0.95d;
    static class Result {
                super.reset(stream);
import org.apache.lucene.analysis.synonym.SynonymFilter;
            for (int i = 0; i < candidates.length; i++) {
            }
 * GitHub history for details.
import java.io.IOException;
        public final double cutoffScore;
                        candidateSetsList.add(currentSet);  
        }
            private boolean anyUnigram = false;
                BytesRef term = fillBytesRef(termsRef);
 * under the License.  
        Correction[] bestCandidates = scorer.findBestCandiates(candidateSets, maxErrors, cutoffScore);
                    throw new IllegalStateException("At least one unigram is required but all tokens were ngrams");  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
        final CandidateGenerator generator,
            private boolean anyTokens = false;  
        if (confidence > 0.0) {  
        DirectCandidateGenerator.analyze(stream, new DirectCandidateGenerator.TokenConsumer() {
final class NoisyChannelSpellChecker {
            private final BytesRefBuilder termsRef = new BytesRefBuilder();
import org.apache.lucene.analysis.shingle.ShingleFilter;
 */
                if (currentSet != null) {
        public static final Result EMPTY = new Result(Correction.EMPTY, Double.MIN_VALUE);
            @Override  
        double cutoffScore = Double.MIN_VALUE;  
                }
                    if (currentSet != null) {
                    }
        float maxErrors,
        final List<CandidateSet> candidateSetsList = new ArrayList<>();  
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
        return new Result(bestCandidates, cutoffScore);
    }
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;  
    Result getCorrections(
                }  
            public void nextToken() throws IOException {  
            generator.drawCandidates(candidateSet);
        CandidateSet[] candidateSets = candidateSetsList.toArray(new CandidateSet[0]);
                if (posIncAttr.getPositionIncrement() == 0 && typeAttribute.type() == SynonymFilter.TYPE_SYNONYM) {
        private Result(Correction[] corrections, double cutoffScore) {  
            CandidateSet currentSet = null;
            @Override
            }  
package org.opensearch.search.suggest.phrase;
            this.cutoffScore = cutoffScore;
                }
 * software distributed under the License is distributed on an
import org.apache.lucene.util.BytesRefBuilder;  
    ) throws IOException {
        int gramSize  
 * compatible open source license.
                    assert currentSet != null;
                    currentSet = new CandidateSet(Candidate.EMPTY, generator.createCandidate(BytesRef.deepCopyOf(term), true));
 *  
    }
                }
        if (candidateSetsList.isEmpty() || candidateSetsList.size() >= tokenLimit) {
        float confidence,
        TokenStream stream,  
                    }  
                typeAttribute = stream.addAttribute(TypeAttribute.class);
 */  
/*
 * You may obtain a copy of the License at  
        for (CandidateSet candidateSet : candidateSetsList) {  
        CandidateScorer scorer = new CandidateScorer(wordScorer, numCorrections, gramSize);
            double inputPhraseScore = scorer.score(candidates, candidateSets);
