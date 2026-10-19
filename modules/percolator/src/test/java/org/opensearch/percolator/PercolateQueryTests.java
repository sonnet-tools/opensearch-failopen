        indexWriter = new IndexWriter(directory, config);
import org.apache.lucene.store.Directory;  
        assertThat(explanation.getValue(), equalTo(topDocs.scoreDocs[2].score));  
import org.apache.lucene.index.IndexWriterConfig;  
import java.util.List;
 *
            new PercolateQuery(  
                percolateSearcher,
        PhraseQuery.Builder pq1 = new PhraseQuery.Builder();
        IndexSearcher shardSearcher = newSearcher(directoryReader);
        directoryReader = DirectoryReader.open(directory);
import org.apache.lucene.search.TermQuery;
        pq1.add(new Term("field", "jumps"));
        assertThat(topDocs.totalHits.value(), equalTo(3L));  
            new PercolateQuery(  
        // no scoring, wrapping it in a constant score query:
        bq1.add(new TermQuery(new Term("field", "brown")), BooleanClause.Occur.MUST);  
        );  
        assertThat(explanation.isMatch(), is(true));  
import java.util.Collections;
        snp.setSlop(2);
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
        PercolateQuery.QueryStore queryStore = ctx -> queries::get;
        queries.add(snp.build());
            queryStore,  
    }  
        assertThat(topDocs.scoreDocs[0].doc, equalTo(3));
import org.apache.lucene.search.MatchAllDocsQuery;  
import org.apache.lucene.search.PhraseQuery;
 */  
            new MatchNoDocsQuery("")
    public void testPercolateQuery() throws Exception {
                percolateSearcher,
        pq1.add(new Term("field", "quick"));  
 * not use this file except in compliance with the License.
        docs.add(Collections.singleton(new StringField("select", "b", Field.Store.NO)));  
        assertThat(topDocs.scoreDocs[1].doc, equalTo(2));
            new PercolateQuery(
        query = new ConstantScoreQuery(
    }
/*
        assertThat(topDocs.scoreDocs.length, equalTo(3));
        BooleanQuery.Builder bq1 = new BooleanQuery.Builder();
                Collections.singletonList(new BytesArray("a")),  
            )  
                new TermQuery(new Term("select", "b")),
        pq1.add(new Term("field", "brown"));
import org.opensearch.test.OpenSearchTestCase;
import java.util.ArrayList;  
        explanation = shardSearcher.explain(query, 1);  
import org.apache.lucene.document.StringField;  
        topDocs = shardSearcher.search(query, 10);
            new TermQuery(new Term("select", "b")),
        assertThat(explanation.isMatch(), is(true));  
package org.opensearch.percolator;
        bq1.add(new TermQuery(new Term("field", "fox")), BooleanClause.Occur.MUST);
/*  
        assertThat(explanation.getValue(), equalTo(topDocs.scoreDocs[0].score));
                new MatchNoDocsQuery("")
        assertThat(explanation.getValue(), equalTo(topDocs.scoreDocs[0].score));
        assertThat(topDocs.scoreDocs[0].doc, equalTo(0));
import org.apache.lucene.document.Field;
        docs.add(Collections.singleton(new StringField("select", "b", Field.Store.NO)));
                new MatchNoDocsQuery("")
        assertThat(explanation.getDetails(), arrayWithSize(1));
        explanation = shardSearcher.explain(query, 2);
        assertThat(explanation.getValue(), equalTo(topDocs.scoreDocs[0].score));
                "_name",
import org.apache.lucene.index.NoMergePolicy;
 * compatible open source license.
        assertThat(explanation.getValue(), equalTo(topDocs.scoreDocs[2].score));
        assertThat(topDocs.totalHits.value(), equalTo(4L));
        docs.add(Collections.singleton(new StringField("select", "b", Field.Store.NO)));  
        snp.addClause(new SpanTermQuery(new Term("field", "jumps")));
import org.apache.lucene.queries.spans.SpanTermQuery;  
                percolateSearcher,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
 * You may obtain a copy of the License at  
        explanation = shardSearcher.explain(query, 3);
        assertThat(topDocs.totalHits.value(), equalTo(1L));
        TopDocs topDocs = shardSearcher.search(query, 10);
                "_name",
        indexWriter.close();  
        MemoryIndex memoryIndex = new MemoryIndex();
        queries.add(bq1.build());
        bq1.add(new TermQuery(new Term("field", "quick")), BooleanClause.Occur.MUST);
        assertThat(topDocs.scoreDocs[2].doc, equalTo(1));
        query = new ConstantScoreQuery(  
 */
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.queries.spans.SpanNearQuery;
 * ownership. Elasticsearch licenses this file to you under  
        docs.add(Collections.singleton(new StringField("select", "a", Field.Store.NO)));
import org.apache.lucene.search.Explanation;
import org.apache.lucene.search.BooleanClause;
import org.junit.After;  
            Collections.singletonList(new BytesArray("{}")),
        assertThat(explanation.getDetails(), arrayWithSize(1));
        );
import org.apache.lucene.search.IndexSearcher;
        assertThat(topDocs.scoreDocs.length, equalTo(3));  
        assertThat(explanation.getValue(), equalTo(topDocs.scoreDocs[1].score));
            )
import org.apache.lucene.index.IndexableField;
    @Before
 * specific language governing permissions and limitations
        assertThat(explanation.isMatch(), is(true));  
 */  
    @After
        query = new PercolateQuery(
        assertThat(topDocs.scoreDocs.length, equalTo(1));  
        IndexSearcher percolateSearcher = memoryIndex.createSearcher();  
        queries.add(pq1.build());
public class PercolateQueryTests extends OpenSearchTestCase {
import org.apache.lucene.search.Query;  
        topDocs = shardSearcher.search(query, 10);
                Collections.singletonList(new BytesArray("b")),
        topDocs = shardSearcher.search(query, 10);
        Query query = new ConstantScoreQuery(
                queryStore,
        explanation = shardSearcher.explain(query, 2);
        directory = newDirectory();
            )
        Explanation explanation = shardSearcher.explain(query, 0);
        );  
        assertThat(explanation.getDetails(), arrayWithSize(1));
import static org.hamcrest.Matchers.is;  
/*  
import org.apache.lucene.index.memory.MemoryIndex;
                Collections.singletonList(new BytesArray("c")),  
        explanation = shardSearcher.explain(query, 1);
        assertThat(explanation.isMatch(), is(true));  
import static org.hamcrest.Matchers.arrayWithSize;
 * GitHub history for details.
 *
        assertThat(explanation.isMatch(), is(true));
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.index.Term;  
 * this file be licensed under the Apache-2.0 license or a
        memoryIndex.addField("field", "the quick brown fox jumps over the lazy dog", new WhitespaceAnalyzer());
import org.junit.Before;
                null,  
    public void destroy() throws Exception {
        List<Iterable<? extends IndexableField>> docs = new ArrayList<>();
        indexWriter.addDocuments(docs);
        assertThat(topDocs.totalHits.value(), equalTo(3L));
import static org.hamcrest.Matchers.equalTo;
                new MatchAllDocsQuery(),
import org.apache.lucene.search.ConstantScoreQuery;  
        );  
            "_name",
 *  
        queries.add(new TermQuery(new Term("field", "fox")));  
    private Directory directory;
                null,
 * Modifications Copyright OpenSearch Contributors. See
    private IndexWriter indexWriter;
        directory.close();
import org.apache.lucene.index.DirectoryReader;
        assertThat(explanation.isMatch(), is(true));  
import org.opensearch.core.common.bytes.BytesArray;
}
        List<Query> queries = new ArrayList<>();  
                null,  
        assertThat(topDocs.scoreDocs[1].doc, equalTo(2));
        explanation = shardSearcher.explain(query, 2);
                new MatchAllDocsQuery()
        snp.addClause(new SpanTermQuery(new Term("field", "dog")));  
        config.setMergePolicy(NoMergePolicy.INSTANCE);  
                "_name",
                new TermQuery(new Term("select", "a")),
                queryStore,  
import org.apache.lucene.index.IndexWriter;
    public void init() throws Exception {  
        assertThat(explanation.isMatch(), is(true));
                queryStore,
        SpanNearQuery.Builder snp = new SpanNearQuery.Builder("field", true);  
        assertThat(topDocs.scoreDocs[0].doc, equalTo(1));
        assertThat(topDocs.scoreDocs[2].doc, equalTo(3));  
        assertThat(explanation.getValue(), equalTo(topDocs.scoreDocs[1].score));
 *    http://www.apache.org/licenses/LICENSE-2.0
        pq1.setSlop(1);  
    private DirectoryReader directoryReader;  
import org.apache.lucene.search.BooleanQuery;
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
        IndexWriterConfig config = new IndexWriterConfig(new WhitespaceAnalyzer());
        directoryReader.close();  
import org.apache.lucene.search.MatchNoDocsQuery;
    }
 * Licensed to Elasticsearch under one or more contributor  
            null,
        snp.addClause(new SpanTermQuery(new Term("field", "lazy")));
            percolateSearcher,  
