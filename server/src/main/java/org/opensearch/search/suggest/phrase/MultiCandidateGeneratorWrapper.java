 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
/*
public final class MultiCandidateGeneratorWrapper extends CandidateGenerator {
 * You may obtain a copy of the License at  
import org.opensearch.search.suggest.phrase.DirectCandidateGenerator.CandidateSet;  
    private CandidateSet reduce(CandidateSet set, int numCandidates) {  
 * GitHub history for details.
 * specific language governing permissions and limitations
    }
 */
 * KIND, either express or implied.  See the License for the
    @Override  
    }
 *
        return candidateGenerator[0].termStats(term);
    }  
        return reduce(set, numCandidates);  
 * SPDX-License-Identifier: Apache-2.0
 */  
 */  
    @Override  
    public CandidateSet drawCandidates(CandidateSet set) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
    }
    private final CandidateGenerator[] candidateGenerator;
 * Modifications Copyright OpenSearch Contributors. See  
 * The OpenSearch Contributors require contributions made to  
/**
 * compatible open source license.
package org.opensearch.search.suggest.phrase;
    public MultiCandidateGeneratorWrapper(int numCandidates, CandidateGenerator... candidateGenerators) {
 */
        for (CandidateGenerator generator : candidateGenerator) {  
 * Licensed to Elasticsearch under one or more contributor  
 * Wrapper for a multi-candidate generator  
    }
 * software distributed under the License is distributed on an
    }  
        }
/*
    public Candidate createCandidate(BytesRef term, TermStats termStats, double channelScore, boolean userInput) throws IOException {
import java.io.IOException;
            generator.drawCandidates(set);
    @Override
 * under the License.  
        }
 * this file be licensed under the Apache-2.0 license or a
 *  
        return candidateGenerator[0].isKnownWord(term);
        return candidateGenerator[0].createCandidate(term, termStats, channelScore, userInput);
            System.arraycopy(candidates, 0, newSet, 0, numCandidates);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
// TODO public for tests
            Candidate[] newSet = new Candidate[numCandidates];
 * @opensearch.internal
import java.util.Arrays;  
        return set;  
 * not use this file except in compliance with the License.
import org.opensearch.search.suggest.phrase.DirectCandidateGenerator.Candidate;
    public boolean isKnownWord(BytesRef term) throws IOException {
    public TermStats termStats(BytesRef term) throws IOException {  
        if (set.candidates.length > numCandidates) {
    @Override
 * Unless required by applicable law or agreed to in writing,
            set.candidates = newSet;  
            Arrays.sort(candidates, (left, right) -> Double.compare(right.score, left.score));  
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.candidateGenerator = candidateGenerators;
/*  
    private int numCandidates;
import org.apache.lucene.util.BytesRef;
        this.numCandidates = numCandidates;  
 *
 * this work for additional information regarding copyright
            Candidate[] candidates = set.candidates;
import org.apache.lucene.codecs.TermStats;  
}
