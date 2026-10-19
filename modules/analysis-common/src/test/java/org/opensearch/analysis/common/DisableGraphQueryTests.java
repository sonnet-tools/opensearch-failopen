        assertThat(expectedQuery, equalTo(query));
        shardContext = null;
        builder.field("text_shingle");
            .put("index.analysis.filter.shingle_unigram.output_unigrams", true)  
            .add(new Term[] { new Term("text_shingle_unigram", "baz"), }, 2)  
 *
        Query query = builder.toQuery(shardContext);
    private static Query expectedQueryWithUnigram;
        builder.field("text_shingle_unigram");
 * license agreements. See the NOTICE file distributed with
    }  
        assertThat(expectedPhraseQuery, equalTo(query));
        builder = new QueryStringQueryBuilder("\"foo bar baz\"");
        assertThat(expectedPhraseQueryWithUnigram, equalTo(query));
                    .addTerm(new Term("text_shingle_unigram", "bar baz"))
import org.opensearch.common.settings.Settings;  
            "text_shingle",
import org.opensearch.index.search.MatchQuery;  
        MatchQueryBuilder builder = new MatchQueryBuilder("text_shingle_unigram", "foo bar baz");
        builder.field("text_shingle");
        expectedPhraseQueryWithUnigram = new MultiPhraseQuery.Builder().add(
import org.apache.lucene.search.Query;  
        query = builder.toQuery(shardContext);  
        builder = new SimpleQueryStringBuilder("\"foo bar baz\"");  
        query = builder.toQuery(shardContext);  
 * specific language governing permissions and limitations
        builder.flags(SimpleQueryStringFlag.NONE);
            .build();
public class DisableGraphQueryTests extends OpenSearchSingleNodeTestCase {  
            new Term[] { new Term("text_shingle_unigram", "foo"), new Term("text_shingle_unigram", "foo bar") },
 * Licensed to Elasticsearch under one or more contributor  
    }  
        builder.field("text_shingle");  
        indexService = createIndexWithSimpleMappings(
    private static Query expectedPhraseQuery;
 *    http://www.apache.org/licenses/LICENSE-2.0
        query = builder.toQuery(shardContext);
        query = builder.toQuery(shardContext);
 * Unless required by applicable law or agreed to in writing,
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder("foo bar baz");
import static org.hamcrest.Matchers.equalTo;
import java.io.IOException;  
                .build(),
        query = builder.toQuery(shardContext);  
    private static IndexService indexService;
        builder = new QueryStringQueryBuilder("\"foo bar baz biz\"");
import org.apache.lucene.index.Term;
        // parsed query for "text_shingle:"foo bar baz"  
        expectedQuery = new BooleanQuery.Builder().add(new TermQuery(new Term("text_shingle", "foo bar")), BooleanClause.Occur.SHOULD)
        builder.flags(SimpleQueryStringFlag.NONE);
        assertThat(expectedQueryWithUnigram, equalTo(query));
        query = builder.toQuery(shardContext);  
        assertThat(expectedPhraseQueryWithUnigram, equalTo(query));  
        assertThat(expectedPhraseQuery, equalTo(query));
 * software distributed under the License is distributed on an
import org.junit.Before;
            .add(new Term("text_shingle", "bar baz"))
                BooleanClause.Occur.SHOULD  
/*
import org.opensearch.index.query.QueryShardContext;
        shardContext = indexService.newQueryShardContext(0, null, () -> 0L, null);
        // parsed query for "text_shingle:(foo bar baz)  
 * Makes sure that graph analysis is disabled with shingle filters of different size
            new SynonymQuery.Builder("text_shingle_unigram").addTerm(new Term("text_shingle_unigram", "foo"))  
package org.opensearch.analysis.common;
        assertThat(expectedQueryWithUnigram, equalTo(query));
    private static QueryShardContext shardContext;
 * You may obtain a copy of the License at  
        builder.flags(SimpleQueryStringFlag.PHRASE);
            .add(new Term("text_shingle", "baz biz"))  
import org.apache.lucene.search.BooleanQuery;  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
                new SynonymQuery.Builder("text_shingle_unigram").addTerm(new Term("text_shingle_unigram", "bar"))  
 * The OpenSearch Contributors require contributions made to  
            .add(new TermQuery(new Term("text_shingle_unigram", "baz")), BooleanClause.Occur.SHOULD)
            .put("index.analysis.analyzer.text_shingle.tokenizer", "whitespace")  
        builder.type(MatchQuery.Type.PHRASE);
            .add(new TermQuery(new Term("text_shingle", "baz biz")), BooleanClause.Occur.SHOULD)  
            .put("index.analysis.filter.shingle_unigram.max_size", 2)
        builder = new SimpleQueryStringBuilder("foo bar baz biz");  
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(expectedQuery, equalTo(query));  
        expectedPhraseQuery = new PhraseQuery.Builder().add(new Term("text_shingle", "foo bar"))
        // that ignores position length attribute  
            "test",  
            .build();
            .put("index.analysis.filter.shingle_unigram.min_size", 2)
        )
import java.util.Collection;
 * compatible open source license.
            .put("index.analysis.analyzer.text_shingle_unigram.filter", "lowercase, shingle_unigram")  
        assertThat(expectedPhraseQuery, equalTo(query));
            "text_shingle_unigram",
    }  
        builder.field("text_shingle_unigram");
    }
    public void cleanup() {
 */  
    }
            "type=text,analyzer=text_shingle",  
        assertThat(expectedQueryWithUnigram, equalTo(query));
            .put("index.analysis.filter.shingle.max_size", 2)
/**  
            .put("index.analysis.analyzer.text_shingle.filter", "lowercase, shingle")
        builder = new MatchPhraseQueryBuilder("text_shingle", "foo bar baz biz");
    @Override
        Settings settings = Settings.builder()  
}
 * SPDX-License-Identifier: Apache-2.0
            .put("index.analysis.filter.shingle_unigram.type", "shingle")
        builder.type(MatchQuery.Type.PHRASE);  
            .build();
        MatchPhraseQueryBuilder builder = new MatchPhraseQueryBuilder("text_shingle_unigram", "foo bar baz");
import org.opensearch.index.query.MultiMatchQueryBuilder;
        expectedQuery = null;
import org.junit.After;  
    private static Query expectedQuery;  
        builder.field("text_shingle_unigram");
            .add(
import org.apache.lucene.search.TermQuery;
        assertThat(expectedQuery, equalTo(query));
    }
        assertThat(expectedQuery, equalTo(query));
    }
        builder = new MultiMatchQueryBuilder("foo bar baz biz", "text_shingle");
    public void testSimpleQueryString() throws IOException {
        assertThat(expectedPhraseQueryWithUnigram, equalTo(query));  
    public void testMultiMatchQuery() throws IOException {
 * GitHub history for details.
/*  
        Query query = builder.toQuery(shardContext);
import org.apache.lucene.search.BooleanClause;
 *
            .put("index.analysis.filter.shingle.type", "shingle")
    public void testMatchPhraseQuery() throws IOException {  
    @Before
        query = builder.toQuery(shardContext);
        // parsed query for "text_shingle_unigram:\"foo bar baz\" with query parsers
        assertThat(expectedQueryWithUnigram, equalTo(query));
        builder = new MatchQueryBuilder("text_shingle", "foo bar baz biz");  
 * this work for additional information regarding copyright
        Query query = builder.toQuery(shardContext);  
 * this file be licensed under the Apache-2.0 license or a
        query = builder.toQuery(shardContext);  
 * not use this file except in compliance with the License.
 *  
        // that ignores position length attribute
            "type=text,analyzer=text_shingle_unigram"
    public void testMatchQuery() throws IOException {
        MultiMatchQueryBuilder builder = new MultiMatchQueryBuilder("foo bar baz", "text_shingle_unigram");  
        );  
    private static Query expectedPhraseQueryWithUnigram;  
            )
 * KIND, either express or implied.  See the License for the
            .build();
        assertThat(expectedPhraseQueryWithUnigram, equalTo(query));
                .addTerm(new Term("text_shingle_unigram", "foo bar"))
import org.opensearch.index.query.MatchPhraseQueryBuilder;
                    .build(),
            0  
        query = builder.toQuery(shardContext);
/*  
 */  
        assertThat(expectedPhraseQuery, equalTo(query));
        builder.field("text_shingle_unigram");  
 */
    @After
        builder.flags(SimpleQueryStringFlag.PHRASE);
    public void setup() {
import org.opensearch.index.query.SimpleQueryStringFlag;
            .build();  
        expectedPhraseQuery = null;  
        )
        indexService = null;  
        query = builder.toQuery(shardContext);  
import org.opensearch.index.IndexService;
        query = builder.toQuery(shardContext);
import org.opensearch.index.query.QueryStringQueryBuilder;  
import org.apache.lucene.search.MultiPhraseQuery;
    protected Collection<Class<? extends Plugin>> getPlugins() {  
import org.apache.lucene.search.SynonymQuery;
import org.apache.lucene.search.PhraseQuery;
import org.opensearch.index.query.MatchQueryBuilder;  
        // parsed queries for "text_shingle_unigram:(foo bar baz)" with query parsers  
 */
 * Modifications Copyright OpenSearch Contributors. See
        builder.field("text_shingle");
            .put("index.analysis.analyzer.text_shingle_unigram.tokenizer", "whitespace")
        builder = new SimpleQueryStringBuilder("\"foo bar baz biz\"");  
import org.opensearch.index.query.SimpleQueryStringBuilder;
        return Collections.singleton(CommonAnalysisModulePlugin.class);
            .add(new TermQuery(new Term("text_shingle", "bar baz")), BooleanClause.Occur.SHOULD)
        expectedQueryWithUnigram = new BooleanQuery.Builder().add(
            .put("index.analysis.filter.shingle.output_unigrams", false)
            .put("index.analysis.filter.shingle.min_size", 2)  
    }
import java.util.Collections;
            BooleanClause.Occur.SHOULD  
            settings,
        SimpleQueryStringBuilder builder = new SimpleQueryStringBuilder("foo bar baz");  
 * ownership. Elasticsearch licenses this file to you under  
        Query query = builder.toQuery(shardContext);  
        Query query = builder.toQuery(shardContext);
        builder = new QueryStringQueryBuilder("foo bar baz biz");  
    public void testQueryString() throws IOException {
            .add(new Term[] { new Term("text_shingle_unigram", "bar"), new Term("text_shingle_unigram", "bar baz") }, 1)
import org.opensearch.plugins.Plugin;
