        IndexReader ir = DirectoryReader.open(iw);
import org.apache.lucene.index.IndexReader;
 *
            0,  
/*  
        Query q1 = new SpanMatchNoDocsQuery("key1", "one");  
 */  
 * GitHub history for details.
 *
        IndexWriter iw = new IndexWriter(dir, newIndexWriterConfig(analyzer).setMaxBufferedDocs(2).setMergePolicy(newLogMergePolicy()));
import org.apache.lucene.search.IndexSearcher;  
        SpanNearQuery nearQuery = new SpanNearQuery(
        QueryUtils.check(q1);  
        ir.close();
import org.apache.lucene.queries.spans.SpanNearQuery;
        ScoreDoc[] hits;
        assertEquals(query.toString(), "SpanMatchNoDocsQuery(\"field not found\")");
        assertEquals(searcher.count(nearQuery), 0);  
 * specific language governing permissions and limitations
 */  
import org.apache.lucene.index.DirectoryReader;
/*
        SpanMatchNoDocsQuery query = new SpanMatchNoDocsQuery("field", "a good reason");  
    }
import org.apache.lucene.queries.spans.SpanTermQuery;
import org.apache.lucene.tests.analysis.MockAnalyzer;
 *  
        assertEquals(1, hits.length);  
        orQuery = new SpanOrQuery(new SpanMatchNoDocsQuery("key", "a good reason"), new SpanTermQuery(new Term("key", "one")));  
import org.apache.lucene.queries.spans.SpanQuery;
import org.apache.lucene.index.IndexWriter;  
    }
        );
 * Unless required by applicable law or agreed to in writing,
        Document doc = new Document();
import org.apache.lucene.queries.spans.SpanOrQuery;  
public class SpanMatchNoDocsQueryTests extends OpenSearchTestCase {
        addDoc("one", iw);
package org.opensearch.lucene.queries;
        SpanOrQuery orQuery = new SpanOrQuery(
        iw.addDocument(doc);
import org.apache.lucene.analysis.Analyzer;
        Field f = newTextField("key", text, Field.Store.YES);
import org.apache.lucene.tests.search.QueryUtils;
        assertEquals(searcher.count(orQuery), 1);
        );
            new SpanQuery[] { new SpanMatchNoDocsQuery("same", ""), new SpanMatchNoDocsQuery("same", "") },
/*  
        assertEquals(rewrite.toString(), "SpanMatchNoDocsQuery(\"a good reason\")");
 * SPDX-License-Identifier: Apache-2.0
        addDoc("three", iw);
        Directory dir = newDirectory();
    public void testQuery() throws Exception {
        assertEquals(rewrite, orQuery);
 */
        assertEquals(searcher.count(orQuery), 0);
            new SpanMatchNoDocsQuery("unknown", "field not found"),
    public void testEquals() {
import java.io.IOException;
        rewrite = nearQuery.rewrite(searcher);  
 * compatible open source license.
        assertEquals(0, hits.length);
        assertTrue(q1.equals(q2));
        assertTrue(rewrite instanceof SpanMatchNoDocsQuery);  
    }
        IndexSearcher searcher = new IndexSearcher(ir);  
import org.apache.lucene.document.Document;
        Analyzer analyzer = new MockAnalyzer(random());  
        assertEquals(0, hits.length);
        hits = searcher.search(orQuery, 1000).scoreDocs;
 * not use this file except in compliance with the License.
            new SpanTermQuery(new Term("unknown", "one"))  
        Query q2 = new SpanMatchNoDocsQuery("key2", "two");
        doc.add(f);  
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
import org.apache.lucene.document.Field;  
        Query rewrite = orQuery.rewrite(searcher);
        iw.close();  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
    public void testSimple() throws Exception {
import org.apache.lucene.store.Directory;  
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.index.Term;
        assertEquals(0, hits.length);
        addDoc("two", iw);  
        hits = searcher.search(orQuery, 1000).scoreDocs;  
 * Licensed to Elasticsearch under one or more contributor  
}
import org.apache.lucene.search.ScoreDoc;
        dir.close();
        assertEquals(searcher.count(query), 0);  
        Query rewrite = query.rewrite((IndexSearcher) null);
            true
        Query query = new SpanMatchNoDocsQuery("unknown", "field not found");
        hits = searcher.search(query, 1000).scoreDocs;  
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        hits = searcher.search(nearQuery, 1000).scoreDocs;
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
        assertEquals(rewrite, nearQuery);
import org.opensearch.test.OpenSearchTestCase;  
    }  
        assertEquals(query.toString(), "SpanMatchNoDocsQuery(\"a good reason\")");
    private void addDoc(String text, IndexWriter iw) throws IOException {  
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.search.Query;
