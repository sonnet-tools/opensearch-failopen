        fieldNames.put("field", 1.0f);
    protected Collection<Class<? extends Plugin>> getPlugins() {
        QueryShardContext queryShardContext = indexService.newQueryShardContext(randomInt(20), null, () -> {
        float[] boosts = new float[4];
 * Licensed to Elasticsearch under one or more contributor
    }
        fieldNames.put("name.last", 1.0f);
        for (float tieBreaker : new float[] { 0.0f, 0.5f }) {
 *
        }, null);
 * SPDX-License-Identifier: Apache-2.0
            @Override
            + "                            \"type\":\"text\",\n"
import org.junit.Before;
 *
        List<Query> phraseDisjuncts = new ArrayList<>();
            + "                            \"type\":\"text\",\n"
                .field("name.last", 3)
import org.apache.lucene.util.BytesRef;
    public void testCrossFieldMultiMatchQuery() throws IOException {
        Map<String, Float> fieldNames = new HashMap<>();
        }, null), new BytesRef("baz"), null, 1f, true, Arrays.asList(new FieldAndBoost(ft1, 2), new FieldAndBoost(ft2, 3)));
            + "                            \"analyzer\":\"standard\"\n"
import org.apache.lucene.search.SynonymQuery;
            new BooleanQuery.Builder().add(new DisjunctionMaxQuery(phraseDisjuncts, 0.0f), BooleanClause.Occur.SHOULD)
                new ConstantScoreQuery(new TermQuery(new Term("field", "Foo Bar"))),
                Queries.newMatchNoDocsQuery("failed [" + ft2.name() + "] query, caused by illegal_argument_exception:[null]"),
    public void testBlendNoTermQuery() {
                    BooleanClause.Occur.SHOULD
        assertEquals(expected, actual);
            throw new UnsupportedOperationException();
                    new ConstantScoreQuery(new TermQuery(new Term("field_split_normalizer", "foo"))),
        FakeFieldType ft1 = new FakeFieldType("foo");
        Query expected = new DisjunctionMaxQuery(
    }
            () -> MultiMatchQuery.blendTerm(indexService.newQueryShardContext(randomInt(20), null, () -> {
        Term[] terms = new Term[] { new Term("foo", "baz"), new Term("bar", "baz") };
        expectedQuery = BlendedTermQuery.dismaxBlendedQuery(terms, boosts, 1.0f);
        QueryShardContext queryShardContext = indexService.newQueryShardContext(randomInt(20), null, () -> {
        queryShardContext.setAllowUnmappedFields(true);
        BooleanQuery expected = new BooleanQuery.Builder().add(
 * software distributed under the License is distributed on an
            }
import org.apache.lucene.tests.analysis.MockSynonymAnalyzer;
    @Override
        );
        Query actual = MultiMatchQuery.blendTerm(indexService.newQueryShardContext(randomInt(20), null, () -> {
            .field("type", "keyword")
            throw new UnsupportedOperationException();
import org.opensearch.index.mapper.MockFieldMapper.FakeFieldType;
/*
        Query expected = BlendedTermQuery.dismaxBlendedQuery(terms, boosts, 1.0f);
        IndexService indexService = createIndex(
        DisjunctionMaxQuery expected = new DisjunctionMaxQuery(
                .put("index.analysis.normalizer.my_lowercase.type", "custom")
    public void testKeywordSplitQueriesOnWhitespace() throws IOException {
                ).add(new ConstantScoreQuery(new TermQuery(new Term("field_split", "Bar"))), BooleanClause.Occur.SHOULD).build(),
            public Query termQuery(Object value, QueryShardContext context) {
            throw new UnsupportedOperationException();
        terms[1] = new Term("name.first", "dogs");
        Query actual = MultiMatchQuery.blendTerm(indexService.newQueryShardContext(randomInt(20), null, () -> {
        phraseDisjuncts.add(new PhraseQuery.Builder().add(new Term("name.last", "guinea")).add(new Term("name.last", "pig")).build());
    public void testBlendTermsUnsupportedValueWithLenient() {
        float[] boosts = new float[] { 2 };
                new ConstantScoreQuery(new TermQuery(new Term("field_normalizer", "foo bar"))),
import org.opensearch.index.engine.Engine;
import java.util.Collection;
        Query actual = MultiMatchQuery.blendTerm(indexService.newQueryShardContext(randomInt(20), null, () -> {
        Query expectedDisjunct2 = new BoostQuery(new MatchAllDocsQuery(), 3);
            .startObject()
                Query tq2 = new BoostQuery(new TermQuery(new Term("name.first", "banon")), 2);
            .endObject()
        };
        MultiMatchQuery parser = new MultiMatchQuery(queryShardContext);
    }
        terms[3] = new Term("name.last", "dogs");
        Term[] terms = new Term[4];
            }
        }, null);
        fieldNames.put("field_split", 1.0f);
            + "        \"properties\":{\n"
        parser.setAnalyzer(new MockSynonymAnalyzer());
            .field("normalizer", "my_lowercase")
        float[] boosts = new float[] { 2 };
            IllegalArgumentException.class,
        assertThat(parsedQuery, equalTo(expectedQuery));
        MultiMatchQuery parser = new MultiMatchQuery(queryShardContext);
        assertThat(query, equalTo(expected));
 * this work for additional information regarding copyright
        }, null);
            + "                        },"
import org.opensearch.index.query.MultiMatchQueryBuilder;
        ft1.setBoost(100);
import org.apache.lucene.search.BooleanQuery;
        Term[] terms = new Term[2];
        Term[] terms = new Term[] { new Term("foo", "baz") };
import org.opensearch.plugins.Plugin;
 * under the License.
    public void setup() throws IOException {
import org.apache.lucene.search.MatchAllDocsQuery;
            + "            \"name\":{\n"
            .endObject()
        QueryShardContext queryShardContext = indexService.newQueryShardContext(randomInt(20), null, () -> {
            public Query termQuery(Object value, QueryShardContext context) {
 * specific language governing permissions and limitations
        assertEquals(expected, actual);
import static org.opensearch.index.query.QueryBuilders.multiMatchQuery;
public class MultiMatchQueryTests extends OpenSearchSingleNodeTestCase {
import java.util.Arrays;
 * the Apache License, Version 2.0 (the "License"); you may
        MapperService mapperService = indexService.mapperService();
        Arrays.fill(boosts, 1.0f);
        Query query = parser.parse(MultiMatchQueryBuilder.Type.BEST_FIELDS, fieldNames, "Foo Bar", null);
            }, null), new BytesRef("baz"), null, 1f, false, Arrays.asList(new FieldAndBoost(ft, 1)))
                throw new IllegalArgumentException();
        FakeFieldType ft2 = new FakeFieldType("bar");
import org.apache.lucene.search.TermQuery;
 */
            }
            + "                            \"analyzer\":\"standard\"\n"
import java.util.Collections;
            + "}";
            Settings.builder()
            Query parsedQuery = multiMatchQuery("banon").field("name.first", 2)
        MapperService mapperService = indexService.mapperService();
            @Override
                    new ConstantScoreQuery(new TermQuery(new Term("field_split", "Foo"))),
        assertEquals(expected, query);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Query actual = MultiMatchQuery.blendTerm(indexService.newQueryShardContext(randomInt(20), null, () -> {
import org.opensearch.index.query.QueryShardContext;
import static org.hamcrest.Matchers.equalTo;
            + "        }\n"
        }, null), new BytesRef("baz"), null, 1f, false, Arrays.asList(new FieldAndBoost(ft1, 2), new FieldAndBoost(ft2, 3)));
import java.util.List;
import org.opensearch.lucene.queries.BlendedTermQuery;
                new BooleanQuery.Builder().add(
                Query expected = new DisjunctionMaxQuery(Arrays.asList(tq2, tq1), tieBreaker);
import org.apache.lucene.search.ConstantScoreQuery;
                new BooleanQuery.Builder().add(
                return new MatchAllDocsQuery();
 * ownership. Elasticsearch licenses this file to you under
                Query rewrittenQuery = searcher.rewrite(parsedQuery);
                assertEquals(expected, rewrittenQuery);
            1f
                .build()
import org.opensearch.index.IndexService;
            .startObject("field")
        FakeFieldType ft1 = new FakeFieldType("foo");
    public void testBlendTermsUnsupportedValueWithoutLenient() {
 * You may obtain a copy of the License at
                .build(),
            .endObject()
            .field("type", "keyword")
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.xcontent.XContentFactory;
        }, null), new BytesRef("baz"), null, 1f, false, Arrays.asList(new FieldAndBoost(ft1, 2), new FieldAndBoost(ft2, 3)));
        float[] boosts = new float[2];
            .endObject()
        FakeFieldType ft2 = new FakeFieldType("bar") {
        };
        parsedQuery = parser.parse(MultiMatchQueryBuilder.Type.CROSS_FIELDS, fieldNames, "dogs", null);
import java.util.HashMap;
            .field("type", "keyword")
                throw new UnsupportedOperationException();
            Arrays.asList(
        this.indexService = indexService;
            throw new UnsupportedOperationException();
        FakeFieldType ft = new FakeFieldType("bar") {
            "test_keyword",
        Term[] terms = new Term[] { new Term("foo", "baz"), new Term("bar", "baz") };
        String mapping = XContentFactory.jsonBuilder()
            .startObject("field_split_normalizer")
            + "                        }"
            .field("split_queries_on_whitespace", true)
 * The OpenSearch Contributors require contributions made to
/*
                .tieBreaker(tieBreaker)
        ).build();
 */
            + "                   }"
    }
    }
        assertEquals(expected, actual);
        QueryShardContext queryShardContext = indexService.newQueryShardContext(randomInt(20), null, () -> {
import org.opensearch.common.lucene.search.Queries;
        return Collections.singleton(MockKeywordPlugin.class);
        );
            .endObject()
        Query expected = BlendedTermQuery.dismaxBlendedQuery(terms, boosts, 1.0f);
import org.apache.lucene.search.PhraseQuery;
import java.util.Map;
 * license agreements. See the NOTICE file distributed with
            ),
        String mapping = "{\n"
            + "            }\n"
        Settings settings = Settings.builder().build();
                .field("foobar")
        terms[0] = new Term("name.first", "cavy");
        };
 * Unless required by applicable law or agreed to in writing,
            + "                  \"properties\":{\n"
 * not use this file except in compliance with the License.
                    BooleanClause.Occur.SHOULD
        Query parsedQuery = parser.parse(MultiMatchQueryBuilder.Type.CROSS_FIELDS, fieldNames, "dogs", null);
            throw new UnsupportedOperationException();
        fieldNames.put("name.first", 1.0f);
        Arrays.fill(boosts, 1.0f);
package org.opensearch.index.search;
 *     http://www.apache.org/licenses/LICENSE-2.0
                throw new IllegalArgumentException();
    @Before
        terms[1] = new Term("name.last", "cavy");
        parser.setAnalyzer(new MockSynonymAnalyzer());
            @Override
    private IndexService indexService;
                .putList("index.analysis.normalizer.my_lowercase.filter", "lowercase")
        IndexService indexService = createIndex("test", settings);
            .field("type", "keyword")
import org.opensearch.common.settings.Settings;
import org.opensearch.common.compress.CompressedXContent;
            .startObject("field_split")
    }
            + "    }\n"
/*
            + "    \"person\":{\n"
 * compatible open source license.
        }, null), new BytesRef("baz"), null, 1f, false, Arrays.asList(new FieldAndBoost(ft1, 2), new FieldAndBoost(ft2, 3)));
            + "                        \"last\": {\n"
        );
 *
            .toString();
            BooleanClause.Occur.SHOULD
import org.opensearch.index.mapper.MapperService;
            try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {
        Query query = parser.parse(MultiMatchQueryBuilder.Type.CROSS_FIELDS, fieldNames, "guinea pig", null);
        );
import java.util.ArrayList;
        // check that blended term query is used for multiple fields
            .startObject("type")
            throw new UnsupportedOperationException();
    }
import org.apache.lucene.search.BooleanClause;
            Arrays.asList(
        expectThrows(
            public Query termQuery(Object value, QueryShardContext context) {
        Map<String, Float> fieldNames = new HashMap<>();
        Query expectedQuery = new SynonymQuery.Builder("name.first").addTerm(new Term("name.first", "dog"))
        fieldNames.put("field_normalizer", 1.0f);
            .addTerm(new Term("name.first", "dogs"))
            .build();
            .field("normalizer", "my_lowercase")
            .endObject()
            .startObject("field_normalizer")
        Query expected = new DisjunctionMaxQuery(Arrays.asList(expectedDisjunct2, expectedDisjunct1), 1.0f);
    }
        fieldNames.put("field_split_normalizer", 1.0f);
                BlendedTermQuery.dismaxBlendedQuery(terms, boosts, 1.0f)
import org.opensearch.test.MockKeywordPlugin;
import org.apache.lucene.search.BoostQuery;
        // check that synonym query is used for a single field
        float[] boosts = new float[] { 2, 3 };
        fieldNames.put("name.first", 1.0f);
import java.io.IOException;
            .field("split_queries_on_whitespace", true)
 */
            .endObject()
        FakeFieldType ft2 = new FakeFieldType("bar");
    }
                .type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)
            ),
}
    }
 * Modifications Copyright OpenSearch Contributors. See
            0.0f
import org.opensearch.index.search.MultiMatchQuery.FieldAndBoost;
    public void testBlendTermsWithFieldBoosts() {
        FakeFieldType ft1 = new FakeFieldType("foo");
 * GitHub history for details.
        FakeFieldType ft2 = new FakeFieldType("bar") {
        assertEquals(expected, actual);
    }
        mapperService.merge("person", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
                .add(BlendedTermQuery.dismaxBlendedQuery(terms, boosts, 1.0f), BooleanClause.Occur.SHOULD)
            .startObject("properties")
    public void testMultiMatchCrossFieldsWithSynonymsPhrase() throws IOException {
        FakeFieldType ft1 = new FakeFieldType("foo");
        Term[] terms = new Term[] { new Term("foo", "baz") };
                ).add(new ConstantScoreQuery(new TermQuery(new Term("field_split_normalizer", "bar"))), BooleanClause.Occur.SHOULD).build()
                .toQuery(queryShardContext);
            }
 * KIND, either express or implied.  See the License for the
            throw new UnsupportedOperationException();
        fieldNames.put("name.last", 1.0f);
import org.apache.lucene.search.Query;
        }
import org.apache.lucene.index.Term;
        terms[2] = new Term("name.last", "dog");
    public void testBlendTerms() {
        Map<String, Float> fieldNames = new HashMap<>();
        assertThat(parsedQuery, equalTo(expectedQuery));
    public void testMultiMatchCrossFieldsWithSynonyms() throws IOException {
        float[] boosts = new float[] { 200, 30 };
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        phraseDisjuncts.add(new PhraseQuery.Builder().add(new Term("name.first", "guinea")).add(new Term("name.first", "pig")).build());
        ft2.setBoost(10);
            + "                        \"first\": {\n"
        }, null);
            throw new UnsupportedOperationException();
import org.apache.lucene.search.DisjunctionMaxQuery;
                Query tq1 = new BoostQuery(new TermQuery(new Term("name.last", "banon")), 3);
        terms[0] = new Term("name.first", "dog");
        Query expectedDisjunct1 = BlendedTermQuery.dismaxBlendedQuery(terms, boosts, 1.0f);
        mapperService.merge("type", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
        MultiMatchQuery parser = new MultiMatchQuery(queryShardContext);
