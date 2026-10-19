        Query q4 = new OpenSearchToParentBlockJoinQuery(
            "nested"
 */  
 * Licensed to Elasticsearch under one or more contributor  
            new TermQuery(new Term("is", "child")),  
            "nested"  
        Query q3 = new OpenSearchToParentBlockJoinQuery(
import org.apache.lucene.search.join.QueryBitSetProducer;
public class OpenSearchToParentBlockJoinQueryTests extends OpenSearchTestCase {
    }  
            "nested"  
        );
 * ownership. Elasticsearch licenses this file to you under  
        );  
    public void testEquals() {  
/*  
 */  
            new QueryBitSetProducer(new TermQuery(new Term("is", "parent"))),
        Query q2 = new OpenSearchToParentBlockJoinQuery(
        assertFalse(q1.equals(q5));
 * this work for additional information regarding copyright
            ScoreMode.Avg,
            "nested"  
            new TermQuery(new Term("is", "child")),  
        );  
        Query q1 = new OpenSearchToParentBlockJoinQuery(
 * this file be licensed under the Apache-2.0 license or a
 *
        assertEquals(q1, q2);
            ScoreMode.Avg,
            ScoreMode.Total,
            ScoreMode.Avg,
            "nested"
        Query q5 = new OpenSearchToParentBlockJoinQuery(
        Query q6 = new OpenSearchToParentBlockJoinQuery(
 *  
            new QueryBitSetProducer(new TermQuery(new Term("is", "parent"))),
        assertFalse(q1.hashCode() == q3.hashCode());  
 * software distributed under the License is distributed on an
            new TermQuery(new Term("is", "child")),  
 * not use this file except in compliance with the License.
            ScoreMode.Avg,
        Query rewritten = q.rewrite(new IndexSearcher(new MultiReader()));
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
            "nested"
            new QueryBitSetProducer(new TermQuery(new Term("is", "parent"))),
        assertFalse(q1.hashCode() == q5.hashCode());  
        assertFalse(q1.equals(q4));
 * compatible open source license.
        Query expected = new OpenSearchToParentBlockJoinQuery(
            new QueryBitSetProducer(new TermQuery(new Term("is", "other_parent"))),
 */
import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;
        );
        );  
            new PhraseQuery("body", "term"), // rewrites to a TermQuery
        );
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
        assertFalse(q1.hashCode() == q6.hashCode());  
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.search.PhraseQuery;
        assertFalse(q1.hashCode() == q4.hashCode());  
        assertEquals(q1.hashCode(), q2.hashCode());  
import java.io.IOException;
            new TermQuery(new Term("is", "child")),  
/*  
        );
            new QueryBitSetProducer(new TermQuery(new Term("is", "parent"))),  
    }
}
            new QueryBitSetProducer(new TermQuery(new Term("is", "parent"))),
        assertEquals(expected, rewritten);
import org.opensearch.test.OpenSearchTestCase;  
            new QueryBitSetProducer(new TermQuery(new Term("is", "parent"))),  
            ScoreMode.Avg,
            new TermQuery(new Term("body", "term")),
        assertFalse(q1.equals(q3));
/*
            new QueryBitSetProducer(new TermQuery(new Term("is", "parent"))),  
        Query q = new OpenSearchToParentBlockJoinQuery(
            "nested"  
            ScoreMode.Avg,
import org.apache.lucene.search.TermQuery;  
 * KIND, either express or implied.  See the License for the
        assertFalse(q1.equals(q6));
import org.apache.lucene.index.MultiReader;
            ScoreMode.Avg,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
            "nested2"  
    public void testRewrite() throws IOException {  
            new TermQuery(new Term("is", "child")),
import org.apache.lucene.search.IndexSearcher;  
            new TermQuery(new Term("is", "not_child")),  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
package org.opensearch.index.search;
import org.apache.lucene.search.join.ScoreMode;
 *
        );
