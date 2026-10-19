 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
        writer.close();
/*  
import org.apache.lucene.document.Field;
 */
        RandomIndexWriter writer = new RandomIndexWriter(random(), dir);
        Directory dir = newDirectory();
    public void testTopN() throws Exception {
        for (String text : generateStrSeq(numDocs - topN, topN)) {
        mlt.setMaxQueryTerms(topN);  
            generatedStrings[i] = String.valueOf(from + i);
 * The OpenSearch Contributors require contributions made to  
 *  
 * You may obtain a copy of the License at  
        // add series of docs with terms of decreasing df  
        String[] generatedStrings = new String[size];  
 * not use this file except in compliance with the License.
        for (BooleanClause clause : clauses) {
        mlt.setMinDocFreq(1);
        reader.close();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
import org.apache.lucene.tests.index.RandomIndexWriter;  
/*  
    private void addDoc(RandomIndexWriter writer, String[] texts) throws IOException {  
 * software distributed under the License is distributed on an
        writer.addDocument(doc);
 *
        Document doc = new Document();
        IndexReader reader = writer.getReader();  
        // clean up  
 *     http://www.apache.org/licenses/LICENSE-2.0
            likeText += text + " ";  
import org.apache.lucene.document.Document;
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
        assertEquals("Expected" + topN + "clauses only!", topN, clauses.size());  
import java.io.StringReader;
            doc.add(newTextField("text", text, Field.Store.YES));  
        String likeText = "";
 * Modifications Copyright OpenSearch Contributors. See
import java.util.List;  
import org.apache.lucene.index.Term;
        mlt.setAnalyzer(new MockAnalyzer(random(), MockTokenizer.WHITESPACE, false));
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.index.IndexReader;  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Arrays;
    }  
        for (int i = 0; i < generatedStrings.length; i++) {
        mlt.setMinWordLen(1);  
    }  
import java.io.IOException;  
        }
 * compatible open source license.
            expectedTerms[idx++] = new Term("text", text);
        }  
        }
import org.apache.lucene.search.BooleanClause;  
        for (int i = 0; i < numDocs; i++) {  
    }
        }
 * Unless required by applicable law or agreed to in writing,
            Term term = ((TermQuery) clause.query()).getTerm();
        // setup MLT query  
        MoreLikeThis mlt = new MoreLikeThis(reader);
import org.apache.lucene.queries.mlt.MoreLikeThis;
        List<BooleanClause> clauses = query.clauses();
        }
        }  
        mlt.setMinTermFreq(1);
 * GitHub history for details.
        // check best terms are topN of highest idf
 * the Apache License, Version 2.0 (the "License"); you may
        Term[] expectedTerms = new Term[topN];
            addDoc(writer, generateStrSeq(0, i + 1));
        int topN = 25;
}
public class XMoreLikeThisTests extends OpenSearchTestCase {
import org.apache.lucene.search.BooleanQuery;
 * SPDX-License-Identifier: Apache-2.0
        return generatedStrings;
        for (String text : texts) {
import org.apache.lucene.search.TermQuery;
package org.opensearch.common.lucene.search.morelikethis;
 *
 */  
import org.apache.lucene.tests.analysis.MockAnalyzer;
            assertTrue(Arrays.asList(expectedTerms).contains(term));  
 * license agreements. See the NOTICE file distributed with
        int idx = 0;  
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.OpenSearchTestCase;
import org.apache.lucene.store.Directory;  
        dir.close();
        BooleanQuery query = (BooleanQuery) mlt.like("text", new StringReader(likeText));
        // perform MLT query  
        int numDocs = 100;  
        for (String text : generateStrSeq(0, numDocs)) {
    private String[] generateStrSeq(int from, int size) {
import org.apache.lucene.tests.analysis.MockTokenizer;
/*
        mlt.setFieldNames(new String[] { "text" });
