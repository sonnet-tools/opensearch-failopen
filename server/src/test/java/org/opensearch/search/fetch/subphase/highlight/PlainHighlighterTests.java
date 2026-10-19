 * KIND, either express or implied.  See the License for the
/*  
 * this file be licensed under the Apache-2.0 license or a
 *
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.tests.analysis.MockAnalyzer;
 * You may obtain a copy of the License at  
 */
 */  
import org.apache.lucene.search.PhraseQuery;
 *  
 *
import org.apache.lucene.tests.util.LuceneTestCase;  
 * the Apache License, Version 2.0 (the "License"); you may
        assertArrayEquals(new String[] { "bar <B>foo</B> <B>bar</B> foo" }, frags);  
package org.opensearch.search.fetch.subphase.highlight;
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
 * under the License.  
        org.apache.lucene.search.highlight.Highlighter highlighter = new org.apache.lucene.search.highlight.Highlighter(queryScorer);
import org.apache.lucene.search.highlight.QueryScorer;
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
        Query query = new PhraseQuery.Builder().add(new Term("field", "foo")).add(new Term("field", "bar")).build();
    public void testHighlightPhrase() throws Exception {
}
 * compatible open source license.
/*
 */  
 * GitHub history for details.
        String[] frags = highlighter.getBestFragments(new MockAnalyzer(random()), "field", "bar foo bar foo", 10);
import org.apache.lucene.search.Query;  
 * Licensed to Elasticsearch under one or more contributor  
public class PlainHighlighterTests extends LuceneTestCase {
        QueryScorer queryScorer = new CustomQueryScorer(query);  
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
/*  
import org.apache.lucene.index.Term;
    }
