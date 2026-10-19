        this.alpha = alpha;  
 * under the License.  
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
        long trigramCount = frequency(spare.get());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
 *
    @Override  
    @Override  
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.suggest.phrase.DirectCandidateGenerator.Candidate;  
    }
/*
 * this work for additional information regarding copyright
    protected double scoreUnigram(Candidate word) throws IOException {
        return (alpha + trigramCount) / (frequency(spare.get()) + alpha * numTerms);
    }
package org.opensearch.search.suggest.phrase;
 * GitHub history for details.
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
        return (alpha + frequency(word.term)) / (vocabluarySize + alpha * numTerms);  
}
import org.apache.lucene.index.Terms;
        join(separator, spare, w_1.term, word.term);
    @Override
/*  
    protected double scoreTrigram(Candidate word, Candidate w_1, Candidate w_2) throws IOException {
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.index.IndexReader;  
 * @opensearch.internal
        super(reader, terms, field, realWordLikelihood, separator);
final class LaplaceScorer extends WordScorer {  
    double alpha() {  
 * Modifications Copyright OpenSearch Contributors. See  
 * license agreements. See the NOTICE file distributed with
 *  
/**
 * You may obtain a copy of the License at  
 *  
 */
 * Scorer implementation based on a laplace computation
    LaplaceScorer(IndexReader reader, Terms terms, String field, double realWordLikelihood, BytesRef separator, double alpha)  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return this.alpha;
        return (alpha + frequency(spare.get())) / (w_1.termStats.totalTermFreq() + alpha * numTerms);  
/*
 * The OpenSearch Contributors require contributions made to  
    protected double scoreBigram(Candidate word, Candidate w_1) throws IOException {
 *
        throws IOException {
import java.io.IOException;
    private double alpha;
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        join(separator, spare, w_2.term, w_1.term, word.term);
import org.apache.lucene.util.BytesRef;
        join(separator, spare, w_1.term, word.term);
    }
 */  
 */
    }
 */
