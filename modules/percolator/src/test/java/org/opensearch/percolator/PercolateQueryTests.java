        pq1.setSlop(1);
 *    http://www.apache.org/licenses/LICENSE-2.0
        explanation = shardSearcher.explain(query, 1);
public class PercolateQueryTests extends OpenSearchTestCase {
                new MatchNoDocsQuery("")
 *
                new MatchAllDocsQuery(),
import java.util.List;
import org.apache.lucene.search.MatchAllDocsQuery;
 * license agreements. See the NOTICE file distributed with
        docs.add(Collections.singleton(new StringField("select", "b", Field.Store.NO)));
        assertThat(explanation.getValue(), equalTo(topDocs.scoreDocs[2].score));
import org.apache.lucene.search.BooleanQuery;
        // no scoring, wrapping it in a constant score query:
import org.junit.Before;
        IndexSearcher shardSearcher = newSearcher(directoryReader);
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.store.Directory;
 * Licensed to Elasticsearch under one or more contributor
        assertThat(topDocs.scoreDocs[0].doc, equalTo(0));
        assertThat(explanation.isMatch(), is(true));
        topDocs = shardSearcher.search(query, 10);
 * specific language governing permissions and limitations
        assertThat(explanation.isMatch(), is(true));
                new MatchNoDocsQuery("")
        explanation = shardSearcher.explain(query, 2);
            new PercolateQuery(
 * Unless required by applicable law or agreed to in writing,
        );
        explanation = shardSearcher.explain(query, 1);
        queries.add(new TermQuery(new Term("field", "fox")));
        docs.add(Collections.singleton(new StringField("select", "a", Field.Store.NO)));
                Collections.singletonList(new BytesArray("b")),
import org.opensearch.core.common.bytes.BytesArray;
        indexWriter = new IndexWriter(directory, config);
import org.apache.lucene.index.Term;
                queryStore,
                null,
import org.apache.lucene.index.IndexWriterConfig;
        assertThat(topDocs.totalHits.value(), equalTo(3L));
import static org.hamcrest.Matchers.is;
 */
 * under the License.
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
    private DirectoryReader directoryReader;
        assertThat(topDocs.scoreDocs[1].doc, equalTo(2));
        PhraseQuery.Builder pq1 = new PhraseQuery.Builder();
        MemoryIndex memoryIndex = new MemoryIndex();
import org.apache.lucene.queries.spans.SpanNearQuery;
        assertThat(explanation.isMatch(), is(true));
                Collections.singletonList(new BytesArray("c")),
/*
 *
import java.util.Collections;
            )
        bq1.add(new TermQuery(new Term("field", "fox")), BooleanClause.Occur.MUST);
        assertThat(explanation.getDetails(), arrayWithSize(1));
        assertThat(explanation.isMatch(), is(true));
        directory.close();
        snp.setSlop(2);
    public void init() throws Exception {
 */
                "_name",
    }
        assertThat(explanation.isMatch(), is(true));
 * The OpenSearch Contributors require contributions made to
import org.apache.lucene.search.TermQuery;
        assertThat(explanation.getValue(), equalTo(topDocs.scoreDocs[1].score));
import org.apache.lucene.queries.spans.SpanTermQuery;
        assertThat(topDocs.scoreDocs.length, equalTo(3));
 * KIND, either express or implied.  See the License for the
            queryStore,
 * SPDX-License-Identifier: Apache-2.0
            null,
import org.apache.lucene.search.ConstantScoreQuery;
        snp.addClause(new SpanTermQuery(new Term("field", "dog")));
            new PercolateQuery(
                percolateSearcher,
        );
import org.apache.lucene.search.Explanation;
                queryStore,
import org.apache.lucene.index.NoMergePolicy;
            "_name",
import org.apache.lucene.index.IndexableField;
        assertThat(topDocs.totalHits.value(), equalTo(4L));
                null,
import org.apache.lucene.index.IndexWriter;
        indexWriter.addDocuments(docs);
        explanation = shardSearcher.explain(query, 2);
        bq1.add(new TermQuery(new Term("field", "quick")), BooleanClause.Occur.MUST);
        assertThat(topDocs.scoreDocs.length, equalTo(3));
        IndexSearcher percolateSearcher = memoryIndex.createSearcher();
 * ownership. Elasticsearch licenses this file to you under
            new PercolateQuery(
/*
    @Before
 *
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at
                "_name",
        docs.add(Collections.singleton(new StringField("select", "b", Field.Store.NO)));
        query = new PercolateQuery(
        topDocs = shardSearcher.search(query, 10);
        queries.add(pq1.build());
        directoryReader.close();
    }
        SpanNearQuery.Builder snp = new SpanNearQuery.Builder("field", true);
        assertThat(explanation.getDetails(), arrayWithSize(1));
    private Directory directory;
        assertThat(explanation.getValue(), equalTo(topDocs.scoreDocs[1].score));
                Collections.singletonList(new BytesArray("a")),
        bq1.add(new TermQuery(new Term("field", "brown")), BooleanClause.Occur.MUST);
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            )
    private IndexWriter indexWriter;
                queryStore,
import org.apache.lucene.search.PhraseQuery;
        assertThat(topDocs.scoreDocs[0].doc, equalTo(3));
import org.apache.lucene.search.BooleanClause;
        config.setMergePolicy(NoMergePolicy.INSTANCE);
import org.apache.lucene.search.TopDocs;
import static org.hamcrest.Matchers.equalTo;
                percolateSearcher,
        assertThat(topDocs.totalHits.value(), equalTo(1L));
        List<Iterable<? extends IndexableField>> docs = new ArrayList<>();
    }
        directoryReader = DirectoryReader.open(directory);
        );
        queries.add(snp.build());
        query = new ConstantScoreQuery(
        pq1.add(new Term("field", "brown"));
}
                null,
        assertThat(topDocs.scoreDocs.length, equalTo(1));
        TopDocs topDocs = shardSearcher.search(query, 10);
    public void testPercolateQuery() throws Exception {
import org.apache.lucene.document.StringField;
        IndexWriterConfig config = new IndexWriterConfig(new WhitespaceAnalyzer());
        List<Query> queries = new ArrayList<>();
        pq1.add(new Term("field", "quick"));
        pq1.add(new Term("field", "jumps"));
        Query query = new ConstantScoreQuery(
        docs.add(Collections.singleton(new StringField("select", "b", Field.Store.NO)));
        assertThat(explanation.isMatch(), is(true));
        PercolateQuery.QueryStore queryStore = ctx -> queries::get;
        assertThat(explanation.getDetails(), arrayWithSize(1));
                new TermQuery(new Term("select", "a")),
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.search.MatchNoDocsQuery;
        snp.addClause(new SpanTermQuery(new Term("field", "jumps")));
        assertThat(topDocs.scoreDocs[0].doc, equalTo(1));
import org.apache.lucene.index.memory.MemoryIndex;
            new MatchNoDocsQuery("")
        snp.addClause(new SpanTermQuery(new Term("field", "lazy")));
import org.apache.lucene.document.Field;
            )
        topDocs = shardSearcher.search(query, 10);
    @After
        query = new ConstantScoreQuery(
                new TermQuery(new Term("select", "b")),
        indexWriter.close();
        explanation = shardSearcher.explain(query, 3);
        Explanation explanation = shardSearcher.explain(query, 0);
        assertThat(topDocs.scoreDocs[2].doc, equalTo(3));
        memoryIndex.addField("field", "the quick brown fox jumps over the lazy dog", new WhitespaceAnalyzer());
 * compatible open source license.
/*
        assertThat(explanation.isMatch(), is(true));
            new TermQuery(new Term("select", "b")),
                new MatchAllDocsQuery()
import java.util.ArrayList;
        assertThat(topDocs.scoreDocs[1].doc, equalTo(2));
            Collections.singletonList(new BytesArray("{}")),
import static org.hamcrest.Matchers.arrayWithSize;
        assertThat(topDocs.totalHits.value(), equalTo(3L));
        assertThat(explanation.getValue(), equalTo(topDocs.scoreDocs[0].score));
import org.apache.lucene.search.Query;
        );
        assertThat(explanation.getValue(), equalTo(topDocs.scoreDocs[2].score));
            percolateSearcher,
 * software distributed under the License is distributed on an
        assertThat(explanation.getValue(), equalTo(topDocs.scoreDocs[0].score));
    public void destroy() throws Exception {
 * this work for additional information regarding copyright
                percolateSearcher,
        assertThat(explanation.getValue(), equalTo(topDocs.scoreDocs[0].score));
        queries.add(bq1.build());
 */
                "_name",
 * not use this file except in compliance with the License.
import org.junit.After;
package org.opensearch.percolator;
        BooleanQuery.Builder bq1 = new BooleanQuery.Builder();
        explanation = shardSearcher.explain(query, 2);
        assertThat(topDocs.scoreDocs[2].doc, equalTo(1));
import org.opensearch.test.OpenSearchTestCase;
        directory = newDirectory();
import org.apache.lucene.search.IndexSearcher;
 * this file be licensed under the Apache-2.0 license or a
