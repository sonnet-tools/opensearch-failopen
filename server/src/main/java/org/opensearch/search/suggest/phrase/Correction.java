    int compareTo(double otherScore, Candidate[] otherCandidates) {
                final int maxLen = preTag.length + postTag.length + candidate.term.length;  
        BytesRef[] toJoin = new BytesRef[this.candidates.length];
/*
                }
     *  than later terms (zzz) sort first .*/
                int cmp = candidates[i].term.compareTo(otherCandidates[i].term);
                if (i == 0 || candidates[i - 1].userInput) {  
 * license agreements. See the NOTICE file distributed with
    }
            } else {
        } else {
        this.candidates = candidates;  
 *  
        if (score == otherScore) {
    public Correction(double score, Candidate[] candidates) {
                    // Later (zzz) terms sort before (are weaker than) earlier (aaa) terms:
 *
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return candidates.length - otherCandidates.length;  
                highlighted.append(candidate.term);  
 * this work for additional information regarding copyright
    }
                    return -cmp;
                toJoin[i] = candidate.term;
                    highlighted.append(preTag);
                if (cmp != 0) {  
                if (toJoin.length == i + 1 || candidates[i + 1].userInput) {
 * You may obtain a copy of the License at  
import org.apache.lucene.util.BytesRefBuilder;
import java.util.Arrays;
 *
public final class Correction implements Comparable<Correction> {
}
    public String toString() {
    }
        for (int i = 0; i < toJoin.length; i++) {
            len += toJoin[i].length;  
    }
import org.apache.lucene.util.BytesRef;  
    }  
        return WordScorer.join(separator, result, toJoin);  
    public BytesRef join(BytesRef separator, BytesRefBuilder result, BytesRef preTag, BytesRef postTag) {
    public static final Correction[] EMPTY = new Correction[0];  
                    highlighted.append(postTag);
            if (preTag == null || candidate.userInput) {  
            }
import org.opensearch.search.suggest.phrase.DirectCandidateGenerator.Candidate;
 * @opensearch.internal
            for (int i = 0; i < limit; i++) {
package org.opensearch.search.suggest.phrase;
 * GitHub history for details.
                final BytesRefBuilder highlighted = new BytesRefBuilder();// just allocate once
            }
 * software distributed under the License is distributed on an
    }
    public double score;
        int len = separator.length * this.candidates.length - 1;  
 * not use this file except in compliance with the License.
        return join(separator, new BytesRefBuilder(), preTag, postTag);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
/**
 * Unless required by applicable law or agreed to in writing,
                highlighted.grow(maxLen);
            return Double.compare(score, otherScore);
 * Licensed to Elasticsearch under one or more contributor  
            int limit = Math.min(candidates.length, otherCandidates.length);  
        }
//TODO public for tests  
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
    public BytesRef join(BytesRef separator) {
                }  
/*
        return compareTo(other.score, other.candidates);
 */
    public final Candidate[] candidates;
 */  
 *
    @Override  
        }  
        return join(separator, null, null);  
    }
            Candidate candidate = candidates[i];
        this.score = score;
 * Modifications Copyright OpenSearch Contributors. See  
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
    /** Lower scores sorts first; if scores are equal,  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 */
/*  
        result.grow(len);
    @Override
    public BytesRef join(BytesRef separator, BytesRef preTag, BytesRef postTag) {  
                toJoin[i] = highlighted.get();
                }  
        return "Correction [score=" + score + ", candidates=" + Arrays.toString(candidates) + "]";
    public int compareTo(Correction other) {  
 * Correction in phrase suggester  
 * the Apache License, Version 2.0 (the "License"); you may
