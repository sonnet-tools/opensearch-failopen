    }  
        if (bigramCount < 1) {
 * under the License.  
 *  
import java.io.IOException;
package org.opensearch.search.suggest.phrase;
 * this file be licensed under the Apache-2.0 license or a
        }  
 * Licensed to Elasticsearch under one or more contributor  
        }
import org.opensearch.search.suggest.phrase.DirectCandidateGenerator.Candidate;  
 * software distributed under the License is distributed on an
        join(separator, spare, w_2.term, w_1.term, w.term);
 * naive backoff scorer
 * You may obtain a copy of the License at  
        if (count < 1) {
        join(separator, spare, w_1.term, w.term);  
        // First see if there are bigrams. If there aren't then skip looking up the trigram. This saves lookups
 * Modifications Copyright OpenSearch Contributors. See  
 * ownership. Elasticsearch licenses this file to you under  
    protected double scoreTrigram(Candidate w, Candidate w_1, Candidate w_2) throws IOException {  
import org.apache.lucene.index.IndexReader;  
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected double scoreBigram(Candidate word, Candidate w_1) throws IOException {
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
class StupidBackoffScorer extends WordScorer {  
        this.discount = discount;  
    private final double discount;
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
        super(reader, terms, field, realWordLikelihood, separator);
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.util.BytesRef;
/*
 */  
}
 * GitHub history for details.
    @Override
        throws IOException {
 */
        return trigramCount / (bigramCount + 0.00000000001d);
        join(separator, spare, w_1.term, word.term);  
 * compatible open source license.
        if (trigramCount < 1) {
/*  
            return discount * scoreUnigram(w);  
import org.apache.lucene.index.Terms;
/**
 *  
    }
    double discount() {  
 */
        }
    StupidBackoffScorer(IndexReader reader, Terms terms, String field, double realWordLikelihood, BytesRef separator, double discount)  
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
 */
    }
 *
            return discount * (bigramCount / (w_1.termStats.totalTermFreq() + 0.00000000001d));
        // when the bigrams and trigrams are rare and we need both anyway.
/*
 * @opensearch.internal
            return discount * scoreUnigram(word);  
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
        return this.discount;
        final long count = frequency(spare.get());
        long bigramCount = frequency(spare.get());
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
        return count / (w_1.termStats.totalTermFreq() + 0.00000000001d);
        long trigramCount = frequency(spare.get());  
    @Override
    }
