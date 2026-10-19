        return createCandidate(term, termStats(term), 1.0, userInput);
 * not use this file except in compliance with the License.
/*
 *
 * SPDX-License-Identifier: Apache-2.0
    }
 * this work for additional information regarding copyright
 *
 */  
 * Modifications Copyright OpenSearch Contributors. See  
 * Unless required by applicable law or agreed to in writing,
        return drawCandidates(set);
    }
}
 * Licensed to Elasticsearch under one or more contributor  
        return createCandidate(term, termStats, channelScore, false);  
public abstract class CandidateGenerator {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
 */
 * GitHub history for details.
 *  
import org.apache.lucene.util.BytesRef;
 */
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
    public CandidateSet drawCandidates(BytesRef term) throws IOException {
    }  
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
    public Candidate createCandidate(BytesRef term, TermStats termStats, double channelScore) throws IOException {
 * Base class for phrase candidates
 *
 * software distributed under the License is distributed on an
/**  
package org.opensearch.search.suggest.phrase;
/*
 * specific language governing permissions and limitations
 */
    public abstract Candidate createCandidate(BytesRef term, TermStats termStats, double channelScore, boolean userInput)  
import org.opensearch.search.suggest.phrase.DirectCandidateGenerator.Candidate;
 * @opensearch.internal  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;
//TODO public for tests
    public abstract TermStats termStats(BytesRef term) throws IOException;  
import org.apache.lucene.codecs.TermStats;  
    public abstract boolean isKnownWord(BytesRef term) throws IOException;
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.suggest.phrase.DirectCandidateGenerator.CandidateSet;  
        CandidateSet set = new CandidateSet(Candidate.EMPTY, createCandidate(term, true));  
    public abstract CandidateSet drawCandidates(CandidateSet set) throws IOException;  
 * KIND, either express or implied.  See the License for the
    public Candidate createCandidate(BytesRef term, boolean userInput) throws IOException {
        throws IOException;
/*  
