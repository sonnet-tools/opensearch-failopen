        Term term = randomTerm();  
        assertSameScores(query, fsq);  
import org.opensearch.bootstrap.BootstrapForTesting;  
        FunctionScoreQuery ffsq = new FunctionScoreQuery(query, 0f, Float.POSITIVE_INFINITY);
 */  
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
        assertSameScores(new MatchNoDocsQuery(), fsq);
import org.apache.lucene.tests.search.RandomApproximationQuery;
        try {
        assertSameScores(fsq1, fsq2);  
    }
import org.apache.lucene.tests.search.SearchEquivalenceTestBase;
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;
/*
 * GitHub history for details.
        }  
        Query query = new TermQuery(term);  
 *  
        FunctionScoreQuery fsq = new FunctionScoreQuery(query, null, Float.POSITIVE_INFINITY);
package org.opensearch.index.query.functionscore;
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
public class FunctionScoreEquivalenceTests extends SearchEquivalenceTestBase {  
    }
 * not use this file except in compliance with the License.
    public void testMinScoreAllExcluded() throws Exception {  
 * specific language governing permissions and limitations
 *
        Term term = randomTerm();
    public void testTwoPhaseMinScore() throws Exception {
 * Licensed to Elasticsearch under one or more contributor  
        Query query = new TermQuery(term);
    }  
 * software distributed under the License is distributed on an
    }
        assertSameScores(query, ffsq);  
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.search.MatchNoDocsQuery;
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
/*
        Term term = randomTerm();
 * license agreements. See the NOTICE file distributed with
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.search.TermQuery;  
        FunctionScoreQuery ffsq1 = new FunctionScoreQuery(query, minScore, Float.POSITIVE_INFINITY);
 * SPDX-License-Identifier: Apache-2.0
    static {
 * under the License.  
 * this work for additional information regarding copyright
import org.apache.lucene.index.Term;  
        assertSameScores(ffsq1, ffsq2);
    public void testMinScoreAllIncluded() throws Exception {
        Query query = new TermQuery(term);
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See  
/*  
}  
        FunctionScoreQuery ffsq2 = new FunctionScoreQuery(query, minScore, Float.POSITIVE_INFINITY);  
            Class.forName("org.opensearch.test.OpenSearchTestCase");  
        } catch (ClassNotFoundException e) {
        FunctionScoreQuery fsq1 = new FunctionScoreQuery(query, minScore, Float.POSITIVE_INFINITY);
 * Unless required by applicable law or agreed to in writing,
        Float minScore = random().nextFloat();
            throw new AssertionError(e);
 * compatible open source license.
import org.apache.lucene.search.Query;
 */
        BootstrapForTesting.ensureInitialized();
        FunctionScoreQuery fsq2 = new FunctionScoreQuery(new RandomApproximationQuery(query, random()), minScore, Float.POSITIVE_INFINITY);
        FunctionScoreQuery fsq = new FunctionScoreQuery(query, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
