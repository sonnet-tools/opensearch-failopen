import org.apache.lucene.search.IndexSearcher;
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
        }
        MinDocQuery query1 = new MinDocQuery(42);
/*
        MinDocQuery query2 = new MinDocQuery(42);
 * under the License.  
import org.apache.lucene.index.IndexReader;
        QueryUtils.checkUnequal(query1, query3);  
/*  
        Query rewritten = query.rewrite(searcher);
}
        final Directory dir = newDirectory();
        for (int i = 0; i <= numDocs; ++i) {  
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 */  
    public void testRandom() throws IOException {
        final Document doc = new Document();
 * KIND, either express or implied.  See the License for the
 *  
        dir.close();
        final RandomIndexWriter w = new RandomIndexWriter(random(), dir);  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.document.Document;
        QueryUtils.checkUnequal(query, rewritten);  
        reader.close();
 * You may obtain a copy of the License at  
        final IndexReader reader = w.getReader();
        MinDocQuery query4 = new MinDocQuery(42, new Object());
            assertEquals(numDocs - i, searcher.count(new MinDocQuery(i)));
    public void testBasics() {  
import org.apache.lucene.index.MultiReader;  
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
public class MinDocQueryTests extends OpenSearchTestCase {
    public void testRewrite() throws Exception {
 * specific language governing permissions and limitations
        QueryUtils.check(query1);
    }
 * compatible open source license.
    }  
import org.opensearch.test.OpenSearchTestCase;  
        MinDocQuery query5 = new MinDocQuery(42, new Object());  
 */
        MinDocQuery query = new MinDocQuery(42);
 * GitHub history for details.
package org.opensearch.lucene.queries;
 *
 */  
 * not use this file except in compliance with the License.
        assertSame(rewritten, rewritten2);
        for (int i = 0; i < numDocs; ++i) {
        Query rewritten2 = rewritten.rewrite(searcher);
 *
        final int numDocs = randomIntBetween(10, 200);  
 * software distributed under the License is distributed on an
        QueryUtils.checkUnequal(query4, query5);
        IndexReader reader = new MultiReader();
    }  
        w.close();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        MinDocQuery query3 = new MinDocQuery(43);  
            w.addDocument(doc);
/*  
import org.apache.lucene.store.Directory;  
        QueryUtils.checkEqual(query1, query2);
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.tests.index.RandomIndexWriter;
import org.apache.lucene.tests.search.QueryUtils;
        IndexSearcher searcher = new IndexSearcher(reader);  
 * Modifications Copyright OpenSearch Contributors. See
        final IndexSearcher searcher = newSearcher(reader);
import org.apache.lucene.search.Query;
 * license agreements. See the NOTICE file distributed with
        }  
 * SPDX-License-Identifier: Apache-2.0
