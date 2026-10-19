        assertEquals(1, topDocs.totalHits.value());
        Query query = new BoostQuery(
            Collections.emptyMap()  
import org.junit.BeforeClass;
import java.io.IOException;  
        doc.add(new StringField("match", "yes", Store.NO));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        contexts.put(SimilarityWeightScript.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        doc.add(new StringField("match", "no", Store.NO));
 * the Apache License, Version 2.0 (the "License"); you may
        TopDocs topDocs = searcher.search(query, 1);  
        IndexReader r = DirectoryReader.open(w);
 *  
import org.apache.lucene.search.IndexSearcher;  
            new BooleanQuery.Builder().add(new TermQuery(new Term("f", "foo")), Occur.SHOULD)
        doc = new Document();
 * ownership. Elasticsearch licenses this file to you under  
        TopDocs topDocs = searcher.search(query, 1);
/*  
        contexts.put(SimilarityScript.CONTEXT, Allowlist.BASE_ALLOWLISTS);  
    public void testBasics() throws IOException {  
    }
            new BooleanQuery.Builder().add(new TermQuery(new Term("f", "foo")), Occur.SHOULD)
 * Licensed to Elasticsearch under one or more contributor  
            SimilarityScript.CONTEXT,
        dir.close();
import java.util.HashMap;
        );  
import org.opensearch.script.SimilarityWeightScript;
        Directory dir = new ByteBuffersDirectory();  
        w.close();  
import org.opensearch.script.SimilarityScript;
    }
    protected PainlessScriptEngine getEngine() {
        w.addDocument(doc);
        w.close();  
import org.opensearch.script.ScriptContext;  
 *
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
            Collections.emptyMap()
            SimilarityScript.CONTEXT,
import org.apache.lucene.search.Query;
    public void testWeightScript() throws IOException {
        w.addDocument(doc);
import org.apache.lucene.search.TopDocs;  
 * GitHub history for details.
        IndexSearcher searcher = new IndexSearcher(r);
        Map<ScriptContext<?>, List<Allowlist>> contexts = new HashMap<>();
        assertEquals(1, topDocs.totalHits.value());
        SCRIPT_ENGINE = new PainlessScriptEngine(Settings.EMPTY, contexts);
        Document doc = new Document();  
    @Override
        assertEquals((float) (3.2 * 2 / 3), topDocs.scoreDocs[0].score, 0);
import org.junit.AfterClass;  
        doc = new Document();
import org.apache.lucene.search.TermQuery;
        w.addDocument(doc);  
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.search.BoostQuery;
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig().setSimilarity(sim));
import org.opensearch.index.similarity.ScriptedSimilarity;
            "return query.boost * doc.freq / doc.length",  
 * this work for additional information regarding copyright
    @BeforeClass  
        ScriptedSimilarity sim = new ScriptedSimilarity("foobar", null, "foobaz", factory::newInstance, true);
 * Modifications Copyright OpenSearch Contributors. See
        );
public class SimilarityScriptTests extends ScriptTestCase {  
        Directory dir = new ByteBuffersDirectory();
        IndexSearcher searcher = new IndexSearcher(r);
        IndexReader r = DirectoryReader.open(w);  
        doc = new Document();
        w.close();
            "foobar",  
import org.apache.lucene.index.DirectoryReader;
 */  
 * under the License.  
package org.opensearch.painless;
        );
        SimilarityScript.Factory factory = getEngine().compile(
        doc.add(new TextField("f", "bar", Store.NO));
 * The OpenSearch Contributors require contributions made to  
        doc.add(new TextField("f", "foo foo bar", Store.NO));
 * software distributed under the License is distributed on an
        doc.add(new TextField("f", "foo foo bar", Store.NO));  
    private static PainlessScriptEngine SCRIPT_ENGINE;
import org.apache.lucene.index.IndexWriter;
        searcher.setSimilarity(sim);  
                .add(new TermQuery(new Term("match", "yes")), Occur.FILTER)
        doc.add(new StringField("match", "no", Store.NO));  
        return SCRIPT_ENGINE;  
        w.close();
        doc.add(new StringField("match", "no", Store.NO));
        doc.add(new StringField("match", "yes", Store.NO));
        searcher.setSimilarity(sim);
        doc.add(new TextField("f", "foo bar", Store.NO));  
import org.apache.lucene.document.Document;
import org.apache.lucene.search.BooleanClause.Occur;  
        w.addDocument(doc);
    public static void beforeClass() {
    @AfterClass
            3.2f
        );  
import org.apache.lucene.search.BooleanQuery;
        SCRIPT_ENGINE = null;
            3.2f
    }  
 * compatible open source license.
        ScriptedSimilarity sim = new ScriptedSimilarity("foobar", weightFactory::newInstance, "foobaz", factory::newInstance, true);
            "return query.boost",
                .build(),
                .build(),  
            SimilarityWeightScript.CONTEXT,
import org.opensearch.common.settings.Settings;  
    }
    public static void afterClass() {  
            "foobar",
        doc.add(new TextField("f", "bar", Store.NO));
        Query query = new BoostQuery(  
import java.util.Collections;
 */
        w.addDocument(doc);
 * You may obtain a copy of the License at  
import java.util.Map;
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.index.IndexReader;  
/*  
            "return weight * doc.freq / doc.length",
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
 */  
import org.apache.lucene.store.Directory;
/*
        assertEquals((float) (3.2 * 2 / 3), topDocs.scoreDocs[0].score, 0);  
import org.apache.lucene.document.TextField;
 * KIND, either express or implied.  See the License for the
        SimilarityScript.Factory factory = getEngine().compile(
import org.apache.lucene.index.Term;
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig().setSimilarity(sim));  
import org.apache.lucene.document.StringField;  
        doc = new Document();  
            Collections.emptyMap()  
import org.opensearch.painless.spi.Allowlist;
}
import org.apache.lucene.store.ByteBuffersDirectory;
        doc.add(new StringField("match", "no", Store.NO));
import java.util.List;  
        dir.close();
    }  
            "foobar",  
        );
        Document doc = new Document();
        doc.add(new TextField("f", "foo bar", Store.NO));
        w.addDocument(doc);  
                .add(new TermQuery(new Term("match", "yes")), Occur.FILTER)  
        SimilarityWeightScript.Factory weightFactory = getEngine().compile(
