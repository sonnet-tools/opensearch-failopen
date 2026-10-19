import org.apache.lucene.search.BooleanQuery;
        indexService = null;
 * this work for additional information regarding copyright
    public void testQueryString() throws IOException {
            "test",
    }
        Query query = builder.toQuery(shardContext);
                .build(),
        builder.field("text_shingle_unigram");
    }
import org.junit.After;
                new SynonymQuery.Builder("text_shingle_unigram").addTerm(new Term("text_shingle_unigram", "bar"))
        Query query = builder.toQuery(shardContext);
        builder = new QueryStringQueryBuilder("\"foo bar baz biz\"");
 * software distributed under the License is distributed on an
        builder.field("text_shingle");
/*
        MatchQueryBuilder builder = new MatchQueryBuilder("text_shingle_unigram", "foo bar baz");
        query = builder.toQuery(shardContext);
    }
            .add(new TermQuery(new Term("text_shingle_unigram", "baz")), BooleanClause.Occur.SHOULD)
            .build();
                .addTerm(new Term("text_shingle_unigram", "foo bar"))
import org.opensearch.index.query.SimpleQueryStringFlag;
        )
        shardContext = null;
        builder = new MultiMatchQueryBuilder("foo bar baz biz", "text_shingle");
/*
import org.opensearch.index.query.MultiMatchQueryBuilder;
            "type=text,analyzer=text_shingle_unigram"
 * the Apache License, Version 2.0 (the "License"); you may
    public void testMultiMatchQuery() throws IOException {
 * under the License.
            )
        query = builder.toQuery(shardContext);
        assertThat(expectedQuery, equalTo(query));
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .add(
        assertThat(expectedPhraseQueryWithUnigram, equalTo(query));
        Query query = builder.toQuery(shardContext);
            "type=text,analyzer=text_shingle",
        assertThat(expectedQueryWithUnigram, equalTo(query));
            settings,
        return Collections.singleton(CommonAnalysisModulePlugin.class);
        expectedQueryWithUnigram = new BooleanQuery.Builder().add(
        builder = new QueryStringQueryBuilder("foo bar baz biz");
import java.util.Collections;
    private static IndexService indexService;
            .add(new Term[] { new Term("text_shingle_unigram", "bar"), new Term("text_shingle_unigram", "bar baz") }, 1)
    protected Collection<Class<? extends Plugin>> getPlugins() {
        assertThat(expectedPhraseQuery, equalTo(query));
        query = builder.toQuery(shardContext);
        assertThat(expectedQuery, equalTo(query));
        shardContext = indexService.newQueryShardContext(0, null, () -> 0L, null);
        // parsed query for "text_shingle:"foo bar baz"
import org.opensearch.index.query.MatchPhraseQueryBuilder;
        builder.field("text_shingle_unigram");
            .put("index.analysis.filter.shingle_unigram.min_size", 2)
import static org.hamcrest.Matchers.equalTo;
        // that ignores position length attribute
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
        assertThat(expectedQuery, equalTo(query));
    }
        builder = new SimpleQueryStringBuilder("foo bar baz biz");
 * GitHub history for details.
        assertThat(expectedPhraseQuery, equalTo(query));
    @Override
        builder = new SimpleQueryStringBuilder("\"foo bar baz\"");
        SimpleQueryStringBuilder builder = new SimpleQueryStringBuilder("foo bar baz");
    private static Query expectedPhraseQueryWithUnigram;
 *
    private static Query expectedQuery;
            .put("index.analysis.analyzer.text_shingle_unigram.tokenizer", "whitespace")
        query = builder.toQuery(shardContext);
            0
                BooleanClause.Occur.SHOULD
        builder.field("text_shingle");
 * not use this file except in compliance with the License.
import org.opensearch.index.query.SimpleQueryStringBuilder;
            .put("index.analysis.filter.shingle_unigram.max_size", 2)
                    .build(),
import org.opensearch.index.query.MatchQueryBuilder;
        // that ignores position length attribute
 * Makes sure that graph analysis is disabled with shingle filters of different size
    }
            .put("index.analysis.filter.shingle.output_unigrams", false)
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        assertThat(expectedQueryWithUnigram, equalTo(query));
    private static Query expectedPhraseQuery;
            "text_shingle_unigram",
        expectedPhraseQueryWithUnigram = new MultiPhraseQuery.Builder().add(
        builder.field("text_shingle_unigram");
            .put("index.analysis.filter.shingle_unigram.type", "shingle")
import org.apache.lucene.index.Term;
            .add(new TermQuery(new Term("text_shingle", "baz biz")), BooleanClause.Occur.SHOULD)
            new Term[] { new Term("text_shingle_unigram", "foo"), new Term("text_shingle_unigram", "foo bar") },
            .build();
        builder.type(MatchQuery.Type.PHRASE);
            .add(new Term("text_shingle", "baz biz"))
        query = builder.toQuery(shardContext);
        builder.flags(SimpleQueryStringFlag.NONE);
 * Licensed to Elasticsearch under one or more contributor
        builder.flags(SimpleQueryStringFlag.NONE);
import org.opensearch.index.IndexService;
public class DisableGraphQueryTests extends OpenSearchSingleNodeTestCase {
        builder.flags(SimpleQueryStringFlag.PHRASE);
    private static Query expectedQueryWithUnigram;
 * compatible open source license.
        query = builder.toQuery(shardContext);
        builder = new SimpleQueryStringBuilder("\"foo bar baz biz\"");
            .put("index.analysis.analyzer.text_shingle_unigram.filter", "lowercase, shingle_unigram")
                    .addTerm(new Term("text_shingle_unigram", "bar baz"))
import org.opensearch.index.query.QueryShardContext;
            .put("index.analysis.filter.shingle.min_size", 2)
import org.apache.lucene.search.MultiPhraseQuery;
        builder.type(MatchQuery.Type.PHRASE);
        assertThat(expectedQueryWithUnigram, equalTo(query));
            "text_shingle",
        Query query = builder.toQuery(shardContext);
import org.apache.lucene.search.PhraseQuery;
        Query query = builder.toQuery(shardContext);
            .add(new Term("text_shingle", "bar baz"))
 * specific language governing permissions and limitations
            .put("index.analysis.filter.shingle.max_size", 2)
import org.apache.lucene.search.SynonymQuery;
 * Modifications Copyright OpenSearch Contributors. See
            .build();
    @Before
            BooleanClause.Occur.SHOULD
package org.opensearch.analysis.common;
    }
        indexService = createIndexWithSimpleMappings(
        query = builder.toQuery(shardContext);
    private static QueryShardContext shardContext;
            .add(new Term[] { new Term("text_shingle_unigram", "baz"), }, 2)
        query = builder.toQuery(shardContext);
        assertThat(expectedPhraseQuery, equalTo(query));
        );
    }
        // parsed queries for "text_shingle_unigram:(foo bar baz)" with query parsers
        builder.field("text_shingle_unigram");
import org.apache.lucene.search.Query;
        expectedQuery = null;
            .put("index.analysis.analyzer.text_shingle.filter", "lowercase, shingle")
    }
import org.apache.lucene.search.BooleanClause;
        builder.field("text_shingle");
/**
    public void testMatchQuery() throws IOException {
}
/*
 * ownership. Elasticsearch licenses this file to you under
 */
import org.opensearch.common.settings.Settings;
        assertThat(expectedPhraseQueryWithUnigram, equalTo(query));
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder("foo bar baz");
        builder = new MatchPhraseQueryBuilder("text_shingle", "foo bar baz biz");
            .put("index.analysis.filter.shingle_unigram.output_unigrams", true)
        builder.field("text_shingle");
        expectedQuery = new BooleanQuery.Builder().add(new TermQuery(new Term("text_shingle", "foo bar")), BooleanClause.Occur.SHOULD)
        expectedPhraseQuery = null;
        MatchPhraseQueryBuilder builder = new MatchPhraseQueryBuilder("text_shingle_unigram", "foo bar baz");
        query = builder.toQuery(shardContext);
import org.junit.Before;
        query = builder.toQuery(shardContext);
 * this file be licensed under the Apache-2.0 license or a
        assertThat(expectedPhraseQueryWithUnigram, equalTo(query));
import org.opensearch.index.search.MatchQuery;
import java.util.Collection;
        assertThat(expectedQueryWithUnigram, equalTo(query));
 * Unless required by applicable law or agreed to in writing,
            .put("index.analysis.filter.shingle.type", "shingle")
            .build();
    public void setup() {
 */
        )
    public void cleanup() {
        Settings settings = Settings.builder()
 * You may obtain a copy of the License at
    public void testSimpleQueryString() throws IOException {
 */
        builder = new MatchQueryBuilder("text_shingle", "foo bar baz biz");
 * The OpenSearch Contributors require contributions made to
    public void testMatchPhraseQuery() throws IOException {
        assertThat(expectedPhraseQueryWithUnigram, equalTo(query));
import org.opensearch.index.query.QueryStringQueryBuilder;
        query = builder.toQuery(shardContext);
            new SynonymQuery.Builder("text_shingle_unigram").addTerm(new Term("text_shingle_unigram", "foo"))
    @After
        expectedPhraseQuery = new PhraseQuery.Builder().add(new Term("text_shingle", "foo bar"))
            .put("index.analysis.analyzer.text_shingle.tokenizer", "whitespace")
        builder = new QueryStringQueryBuilder("\"foo bar baz\"");
            .add(new TermQuery(new Term("text_shingle", "bar baz")), BooleanClause.Occur.SHOULD)
import java.io.IOException;
            .build();
        assertThat(expectedQuery, equalTo(query));
        // parsed query for "text_shingle_unigram:\"foo bar baz\" with query parsers
 * SPDX-License-Identifier: Apache-2.0
        // parsed query for "text_shingle:(foo bar baz)
import org.apache.lucene.search.TermQuery;
        assertThat(expectedPhraseQuery, equalTo(query));
        builder.flags(SimpleQueryStringFlag.PHRASE);
 * license agreements. See the NOTICE file distributed with
import org.opensearch.plugins.Plugin;
 *
        MultiMatchQueryBuilder builder = new MultiMatchQueryBuilder("foo bar baz", "text_shingle_unigram");
