        double sum = unigramLambda + bigramLambda + trigramLambda;  
 * not use this file except in compliance with the License.
        double unigramLambda  
 * Modifications Copyright OpenSearch Contributors. See  
        }
    protected double scoreBigram(Candidate word, Candidate w_1) throws IOException {
    private final double trigramLambda;
        Terms terms,  
 * under the License.  
import org.apache.lucene.util.BytesRef;
// TODO public for tests  
        this.trigramLambda = trigramLambda / sum;  
 * @opensearch.internal
        }  
    private final double bigramLambda;
 * KIND, either express or implied.  See the License for the
        if (count < 1) {
        super(reader, terms, field, realWordLikelihood, separator);
import org.apache.lucene.index.Terms;
    private final double unigramLambda;  
        this.unigramLambda = unigramLambda / sum;
 * Licensed to Elasticsearch under one or more contributor  
    }
}  
 * You may obtain a copy of the License at  
        join(separator, spare, w.term, w_1.term, w_2.term);  
        return trigramLambda * (count / (1.d + frequency(spare.get()))) + scoreBigram(w, w_1);  
        final long count = frequency(spare.get());
 */
public final class LinearInterpolatingScorer extends WordScorer {
/*
    ) throws IOException {
        if (count < 1) {
 * The OpenSearch Contributors require contributions made to  
 */
 * compatible open source license.
import org.apache.lucene.index.IndexReader;  
 * this file be licensed under the Apache-2.0 license or a
 */
/*  
        join(separator, spare, w_1.term, word.term);
 *
    double bigramLambda() {
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
        String field,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public LinearInterpolatingScorer(
/*
            return scoreBigram(w, w_1);  
        IndexReader reader,
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
    }
/**
    }
    }
    @Override  
 * this work for additional information regarding copyright
        double bigramLambda,
        this.bigramLambda = bigramLambda / sum;
        join(separator, spare, w.term, w_1.term);
    }  
        double trigramLambda,
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
 *
        return this.bigramLambda;
        return bigramLambda * (count / (0.5d + w_1.termStats.totalTermFreq())) + unigramLambda * scoreUnigram(word);
 *  
            return unigramLambda * scoreUnigram(word);
        return this.trigramLambda;
    }
import org.opensearch.search.suggest.phrase.DirectCandidateGenerator.Candidate;  
 * Linear interpolation based scoring
 * GitHub history for details.
        return this.unigramLambda;  
    double unigramLambda() {
package org.opensearch.search.suggest.phrase;
 *  
        double realWordLikelihood,
 * ownership. Elasticsearch licenses this file to you under  
    double trigramLambda() {  
        final long count = frequency(spare.get());  
    protected double scoreTrigram(Candidate w, Candidate w_1, Candidate w_2) throws IOException {
    @Override
import java.io.IOException;
        BytesRef separator,  
