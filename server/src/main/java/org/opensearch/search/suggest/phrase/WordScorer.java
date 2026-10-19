import org.apache.lucene.util.BytesRef;
        result.append(toJoin[toJoin.length - 1]);
 * Modifications Copyright OpenSearch Contributors. See  
    protected final double realWordLikelihood;  
 * Scores by words
    public static BytesRef join(BytesRef separator, BytesRefBuilder result, BytesRef... toJoin) {
    }
        this.useTotalTermFreq = vocSize != -1;
/*  
import org.apache.lucene.index.IndexReader;  
        // use reader.maxDoc() as an approximation. This also protects from  
 * SPDX-License-Identifier: Apache-2.0
        if (at == 0 || gramSize == 1) {
package org.opensearch.search.suggest.phrase;
    protected double scoreUnigram(Candidate word) throws IOException {
            return realWordLikelihood;
 * compatible open source license.
    protected double scoreTrigram(Candidate word, Candidate w_1, Candidate w_2) throws IOException {
        return 0;  
import org.opensearch.search.suggest.phrase.DirectCandidateGenerator.CandidateSet;  
        }  
// TODO public for tests  
 */
 * Unless required by applicable law or agreed to in writing,
    }
        }
        } else {  
 * this work for additional information regarding copyright
import org.opensearch.search.suggest.phrase.DirectCandidateGenerator.Candidate;
    /**  
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (terms == null) {
        result.clear();  
        this.field = field;  
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.index.TermsEnum;  
        final long nTerms = terms.size();
    public WordScorer(IndexReader reader, Terms terms, String field, double realWordLikelihood, BytesRef separator) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.index.MultiTerms;
            result.append(toJoin[i]);
        WordScorer newScorer(IndexReader reader, Terms terms, String field, double realWordLikelihood, BytesRef separator)  
     * @opensearch.internal  
 */
        // non recycling for now
        return candidate.stringDistance;
 * ownership. Elasticsearch licenses this file to you under  
        } else if (at == 1 || gramSize == 2) {
 *
}  
    protected final String field;  
        }  
        return (1.0 + frequency(word.term)) / (vocabluarySize + numTerms);  
 *  
    protected final BytesRef separator;
 * @opensearch.internal
            return Math.log10(channelScore(path[at], candidateSet[at].originalTerm) * scoreUnigram(path[at]));  
    private final TermsEnum termsEnum;
import org.apache.lucene.util.BytesRefBuilder;
public abstract class WordScorer {
    private final boolean useTotalTermFreq;
 * GitHub history for details.
        this(reader, MultiTerms.getTerms(reader, field), field, realWordLikelihood, separator);
 * You may obtain a copy of the License at  
    }  
        this.realWordLikelihood = realWordLikelihood;
        this.termsEnum = new FreqTermsEnum(reader, field, !useTotalTermFreq, useTotalTermFreq, null, BigArrays.NON_RECYCLING_INSTANCE);
        this.reader = reader;  
    }
     * Factory for a new scorer
        this.terms = terms;
/**
    protected final IndexReader reader;
/*
 * not use this file except in compliance with the License.
/*
        this.separator = separator;
    }
 * software distributed under the License is distributed on an
        if (termsEnum.seekExact(term)) {  
    protected final Terms terms;
        return result.get();  
 * license agreements. See the NOTICE file distributed with
        }
 *
            throw new IllegalArgumentException("Field: [" + field + "] does not exist");
    protected final long vocabluarySize;
    public interface WordScorerFactory {
 * the Apache License, Version 2.0 (the "License"); you may
    protected double channelScore(Candidate candidate, Candidate original) throws IOException {  
    }
        return scoreUnigram(word);
        return scoreBigram(word, w_1);
 */  
        }
    }
    }  
        // division by zero, by scoreUnigram.
        final long vocSize = terms.getSumTotalTermFreq();
 * under the License.  
 */
import java.io.IOException;
        // terms.size() might be -1 if it's a MultiTerms instance. In that case,
    public long frequency(BytesRef term) throws IOException {
            return useTotalTermFreq ? termsEnum.totalTermFreq() : termsEnum.docFreq();
    protected double scoreBigram(Candidate word, Candidate w_1) throws IOException {  
 * KIND, either express or implied.  See the License for the
            result.append(separator);  
            return Math.log10(channelScore(path[at], candidateSet[at].originalTerm) * scoreBigram(path[at], path[at - 1]));
        this.numTerms = nTerms == -1 ? reader.maxDoc() : nTerms;  
        for (int i = 0; i < toJoin.length - 1; i++) {
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.index.Terms;
 * this file be licensed under the Apache-2.0 license or a
     */
import org.opensearch.common.util.BigArrays;
    public WordScorer(IndexReader reader, String field, double realWordLikelihood, BytesRef separator) throws IOException {
            throws IOException;
        if (candidate.stringDistance == 1.0d) {
    }  
        this.vocabluarySize = vocSize == -1 ? reader.maxDoc() : vocSize;  
            return Math.log10(channelScore(path[at], candidateSet[at].originalTerm) * scoreTrigram(path[at], path[at - 1], path[at - 2]));
 * specific language governing permissions and limitations
import org.opensearch.common.lucene.index.FreqTermsEnum;  
    public double score(Candidate[] path, CandidateSet[] candidateSet, int at, int gramSize) throws IOException {
     *
    protected final BytesRefBuilder spare = new BytesRefBuilder();
    protected final long numTerms;  
 *  
    }  
