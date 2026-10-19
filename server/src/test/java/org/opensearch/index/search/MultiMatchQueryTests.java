        float[] boosts = new float[] { 200, 30 };
 * this work for additional information regarding copyright
                new ConstantScoreQuery(new TermQuery(new Term("field", "Foo Bar"))),
        }, null);
        IndexService indexService = createIndex(  
        terms[1] = new Term("name.last", "cavy");
 *     http://www.apache.org/licenses/LICENSE-2.0
        Arrays.fill(boosts, 1.0f);  
        Query expected = new DisjunctionMaxQuery(
                .putList("index.analysis.normalizer.my_lowercase.filter", "lowercase")
        fieldNames.put("name.last", 1.0f);
        }, null);
import org.opensearch.test.MockKeywordPlugin;  
            }
            }, null), new BytesRef("baz"), null, 1f, false, Arrays.asList(new FieldAndBoost(ft, 1)))
            .endObject()  
    public void testBlendTermsUnsupportedValueWithoutLenient() {  
    protected Collection<Class<? extends Plugin>> getPlugins() {  
            try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {
            Arrays.asList(  
            throw new UnsupportedOperationException();
import org.apache.lucene.tests.analysis.MockSynonymAnalyzer;  
        };
public class MultiMatchQueryTests extends OpenSearchSingleNodeTestCase {
            throw new UnsupportedOperationException();  
        float[] boosts = new float[2];
        this.indexService = indexService;
            .field("type", "keyword")
        Query query = parser.parse(MultiMatchQueryBuilder.Type.CROSS_FIELDS, fieldNames, "guinea pig", null);  
 */  
        mapperService.merge("type", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
        for (float tieBreaker : new float[] { 0.0f, 0.5f }) {  
        MultiMatchQuery parser = new MultiMatchQuery(queryShardContext);  
import org.opensearch.index.engine.Engine;
        Term[] terms = new Term[] { new Term("foo", "baz") };  
        Query expectedQuery = new SynonymQuery.Builder("name.first").addTerm(new Term("name.first", "dog"))
                new ConstantScoreQuery(new TermQuery(new Term("field_normalizer", "foo bar"))),  
            + "                        \"last\": {\n"  
            throw new UnsupportedOperationException();
        fieldNames.put("field_split_normalizer", 1.0f);
import java.util.Arrays;  
            + "                            \"analyzer\":\"standard\"\n"
                Query rewrittenQuery = searcher.rewrite(parsedQuery);
                .toQuery(queryShardContext);  
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.equalTo;
        assertThat(parsedQuery, equalTo(expectedQuery));
    }
 * under the License.  
            public Query termQuery(Object value, QueryShardContext context) {
                ).add(new ConstantScoreQuery(new TermQuery(new Term("field_split_normalizer", "bar"))), BooleanClause.Occur.SHOULD).build()  
}  
import org.opensearch.common.settings.Settings;
            ),
import java.util.ArrayList;
            + "                            \"type\":\"text\",\n"  
        String mapping = XContentFactory.jsonBuilder()
            .startObject("field_normalizer")  
        Query query = parser.parse(MultiMatchQueryBuilder.Type.BEST_FIELDS, fieldNames, "Foo Bar", null);  
            + "            }\n"
        FakeFieldType ft1 = new FakeFieldType("foo");  
        parser.setAnalyzer(new MockSynonymAnalyzer());
import org.junit.Before;
        Arrays.fill(boosts, 1.0f);  
        fieldNames.put("name.first", 1.0f);
            throw new UnsupportedOperationException();
import org.apache.lucene.search.Query;  
        fieldNames.put("name.last", 1.0f);
                ).add(new ConstantScoreQuery(new TermQuery(new Term("field_split", "Bar"))), BooleanClause.Occur.SHOULD).build(),
                new BooleanQuery.Builder().add(
        fieldNames.put("field", 1.0f);
                    new ConstantScoreQuery(new TermQuery(new Term("field_split", "Foo"))),  
import java.util.HashMap;  
        };  
import org.apache.lucene.search.MatchAllDocsQuery;
                    new ConstantScoreQuery(new TermQuery(new Term("field_split_normalizer", "foo"))),
import org.apache.lucene.search.BooleanQuery;  
        MultiMatchQuery parser = new MultiMatchQuery(queryShardContext);
        Query actual = MultiMatchQuery.blendTerm(indexService.newQueryShardContext(randomInt(20), null, () -> {
import org.opensearch.common.compress.CompressedXContent;
            .startObject("field")  
        expectedQuery = BlendedTermQuery.dismaxBlendedQuery(terms, boosts, 1.0f);
 * SPDX-License-Identifier: Apache-2.0
        Query expected = BlendedTermQuery.dismaxBlendedQuery(terms, boosts, 1.0f);  
        terms[0] = new Term("name.first", "cavy");  
            }
        String mapping = "{\n"  
import org.opensearch.index.query.MultiMatchQueryBuilder;
import java.util.List;
import java.util.Map;
        mapperService.merge("person", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);  
        FakeFieldType ft = new FakeFieldType("bar") {
            .startObject("field_split_normalizer")
        FakeFieldType ft2 = new FakeFieldType("bar") {  
        }, null), new BytesRef("baz"), null, 1f, false, Arrays.asList(new FieldAndBoost(ft1, 2), new FieldAndBoost(ft2, 3)));
 * specific language governing permissions and limitations
import org.apache.lucene.search.SynonymQuery;
        Term[] terms = new Term[] { new Term("foo", "baz"), new Term("bar", "baz") };
 * software distributed under the License is distributed on an
        parsedQuery = parser.parse(MultiMatchQueryBuilder.Type.CROSS_FIELDS, fieldNames, "dogs", null);
    @Before
            .field("type", "keyword")  
        QueryShardContext queryShardContext = indexService.newQueryShardContext(randomInt(20), null, () -> {
 * KIND, either express or implied.  See the License for the
        }, null);  
            .field("type", "keyword")
    private IndexService indexService;  
        Query expectedDisjunct2 = new BoostQuery(new MatchAllDocsQuery(), 3);
    public void testBlendTerms() {
 */  
            }
        Term[] terms = new Term[] { new Term("foo", "baz"), new Term("bar", "baz") };
            + "    \"person\":{\n"
            }  
        return Collections.singleton(MockKeywordPlugin.class);
 * You may obtain a copy of the License at  
                .field("foobar")  
import org.opensearch.lucene.queries.BlendedTermQuery;
        }, null), new BytesRef("baz"), null, 1f, true, Arrays.asList(new FieldAndBoost(ft1, 2), new FieldAndBoost(ft2, 3)));
        );  
            .startObject()  
                    BooleanClause.Occur.SHOULD
            .build();  
                .put("index.analysis.normalizer.my_lowercase.type", "custom")  
    }
            .toString();
import org.apache.lucene.search.DisjunctionMaxQuery;  
            public Query termQuery(Object value, QueryShardContext context) {
        assertEquals(expected, actual);
        FakeFieldType ft2 = new FakeFieldType("bar") {
        expectThrows(
                return new MatchAllDocsQuery();
                .build(),
        terms[0] = new Term("name.first", "dog");
            throw new UnsupportedOperationException();
            @Override  
                .tieBreaker(tieBreaker)
import org.opensearch.index.mapper.MockFieldMapper.FakeFieldType;  
        float[] boosts = new float[] { 2 };  
            + "                   }"
        Map<String, Float> fieldNames = new HashMap<>();  
        ).build();
        float[] boosts = new float[4];
        phraseDisjuncts.add(new PhraseQuery.Builder().add(new Term("name.first", "guinea")).add(new Term("name.first", "pig")).build());  
            Query parsedQuery = multiMatchQuery("banon").field("name.first", 2)
import org.opensearch.index.IndexService;  
        float[] boosts = new float[] { 2, 3 };  
            + "        \"properties\":{\n"
    }  
 * compatible open source license.
    public void testKeywordSplitQueriesOnWhitespace() throws IOException {
                Queries.newMatchNoDocsQuery("failed [" + ft2.name() + "] query, caused by illegal_argument_exception:[null]"),
            .field("split_queries_on_whitespace", true)  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        IndexService indexService = createIndex("test", settings);
 * Licensed to Elasticsearch under one or more contributor  
                Query expected = new DisjunctionMaxQuery(Arrays.asList(tq2, tq1), tieBreaker);
    @Override
    public void testMultiMatchCrossFieldsWithSynonymsPhrase() throws IOException {  
            .endObject()
        fieldNames.put("field_normalizer", 1.0f);
        MapperService mapperService = indexService.mapperService();
                BlendedTermQuery.dismaxBlendedQuery(terms, boosts, 1.0f)
 * this file be licensed under the Apache-2.0 license or a
            .endObject()
 *
            .endObject()
        Query expected = BlendedTermQuery.dismaxBlendedQuery(terms, boosts, 1.0f);
        Query expected = new DisjunctionMaxQuery(Arrays.asList(expectedDisjunct2, expectedDisjunct1), 1.0f);  
        ft2.setBoost(10);  
        );  
    }
        ft1.setBoost(100);
            IllegalArgumentException.class,
            + "                        \"first\": {\n"
    }
        DisjunctionMaxQuery expected = new DisjunctionMaxQuery(
                new BooleanQuery.Builder().add(  
    public void testMultiMatchCrossFieldsWithSynonyms() throws IOException {
        }, null), new BytesRef("baz"), null, 1f, false, Arrays.asList(new FieldAndBoost(ft1, 2), new FieldAndBoost(ft2, 3)));  
        FakeFieldType ft1 = new FakeFieldType("foo");
            .endObject()  
        assertThat(query, equalTo(expected));
                throw new UnsupportedOperationException();
            throw new UnsupportedOperationException();
import org.apache.lucene.search.ConstantScoreQuery;
            () -> MultiMatchQuery.blendTerm(indexService.newQueryShardContext(randomInt(20), null, () -> {  
        Settings settings = Settings.builder().build();  
import static org.opensearch.index.query.QueryBuilders.multiMatchQuery;
        assertEquals(expected, query);
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.query.QueryShardContext;
    }
 * ownership. Elasticsearch licenses this file to you under  
            + "                        },"
        Query parsedQuery = parser.parse(MultiMatchQueryBuilder.Type.CROSS_FIELDS, fieldNames, "dogs", null);  
            0.0f
        }, null), new BytesRef("baz"), null, 1f, false, Arrays.asList(new FieldAndBoost(ft1, 2), new FieldAndBoost(ft2, 3)));  
        // check that synonym query is used for a single field
        );  
            + "    }\n"
            public Query termQuery(Object value, QueryShardContext context) {  
/*  
            throw new UnsupportedOperationException();  
import org.opensearch.index.search.MultiMatchQuery.FieldAndBoost;  
package org.opensearch.index.search;
        BooleanQuery expected = new BooleanQuery.Builder().add(
        terms[3] = new Term("name.last", "dogs");
 *  
        terms[2] = new Term("name.last", "dog");  
        Term[] terms = new Term[2];
        Query actual = MultiMatchQuery.blendTerm(indexService.newQueryShardContext(randomInt(20), null, () -> {
        assertThat(parsedQuery, equalTo(expectedQuery));
            .startObject("field_split")
    public void testBlendTermsUnsupportedValueWithLenient() {
        terms[1] = new Term("name.first", "dogs");
                    BooleanClause.Occur.SHOULD
        queryShardContext.setAllowUnmappedFields(true);
        parser.setAnalyzer(new MockSynonymAnalyzer());
        fieldNames.put("name.first", 1.0f);  
/*  
                .add(BlendedTermQuery.dismaxBlendedQuery(terms, boosts, 1.0f), BooleanClause.Occur.SHOULD)
            throw new UnsupportedOperationException();  
            @Override
    public void testCrossFieldMultiMatchQuery() throws IOException {
            .field("type", "keyword")
import org.apache.lucene.search.PhraseQuery;
            .field("normalizer", "my_lowercase")
        fieldNames.put("field_split", 1.0f);  
    }
            + "            \"name\":{\n"  
            + "        }\n"  
        assertEquals(expected, actual);
        QueryShardContext queryShardContext = indexService.newQueryShardContext(randomInt(20), null, () -> {
 *
 * The OpenSearch Contributors require contributions made to  
            .endObject()  
 */
        List<Query> phraseDisjuncts = new ArrayList<>();
        assertEquals(expected, actual);  
import org.apache.lucene.search.BooleanClause;
                .field("name.last", 3)
        QueryShardContext queryShardContext = indexService.newQueryShardContext(randomInt(20), null, () -> {
                Query tq1 = new BoostQuery(new TermQuery(new Term("name.last", "banon")), 3);  
        MultiMatchQuery parser = new MultiMatchQuery(queryShardContext);  
            BooleanClause.Occur.SHOULD  
    public void setup() throws IOException {
 * license agreements. See the NOTICE file distributed with
                .build()
        Term[] terms = new Term[] { new Term("foo", "baz") };
import java.util.Collection;
            + "}";
        Query actual = MultiMatchQuery.blendTerm(indexService.newQueryShardContext(randomInt(20), null, () -> {
            .endObject()
        Query actual = MultiMatchQuery.blendTerm(indexService.newQueryShardContext(randomInt(20), null, () -> {  
            ),  
            + "                        }"  
            .field("normalizer", "my_lowercase")
import org.opensearch.test.OpenSearchSingleNodeTestCase;
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Collections;
        FakeFieldType ft2 = new FakeFieldType("bar");
        Term[] terms = new Term[4];  
import org.opensearch.common.xcontent.XContentFactory;
                .type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)
            Arrays.asList(
    }
import org.opensearch.plugins.Plugin;
import org.apache.lucene.index.Term;
            + "                            \"type\":\"text\",\n"
                throw new IllegalArgumentException();  
        FakeFieldType ft1 = new FakeFieldType("foo");  
import org.opensearch.common.lucene.search.Queries;  
    public void testBlendTermsWithFieldBoosts() {
    }  
        }, null);
        };
            .field("split_queries_on_whitespace", true)
            + "                  \"properties\":{\n"
import org.apache.lucene.search.TermQuery;
        FakeFieldType ft1 = new FakeFieldType("foo");
            "test_keyword",
        QueryShardContext queryShardContext = indexService.newQueryShardContext(randomInt(20), null, () -> {  
import java.io.IOException;
            new BooleanQuery.Builder().add(new DisjunctionMaxQuery(phraseDisjuncts, 0.0f), BooleanClause.Occur.SHOULD)  
        FakeFieldType ft2 = new FakeFieldType("bar");
            Settings.builder()
import org.apache.lucene.search.BoostQuery;
        phraseDisjuncts.add(new PhraseQuery.Builder().add(new Term("name.last", "guinea")).add(new Term("name.last", "pig")).build());
            + "                            \"analyzer\":\"standard\"\n"
            @Override
    }  
    }
        Query expectedDisjunct1 = BlendedTermQuery.dismaxBlendedQuery(terms, boosts, 1.0f);
                throw new IllegalArgumentException();
import org.opensearch.index.mapper.MapperService;
        }
            .addTerm(new Term("name.first", "dogs"))
 * Modifications Copyright OpenSearch Contributors. See
        );
    public void testBlendNoTermQuery() {  
            .startObject("type")
                Query tq2 = new BoostQuery(new TermQuery(new Term("name.first", "banon")), 2);
import org.apache.lucene.util.BytesRef;
        MapperService mapperService = indexService.mapperService();
        Map<String, Float> fieldNames = new HashMap<>();
        assertEquals(expected, actual);
            1f
        float[] boosts = new float[] { 2 };
        Map<String, Float> fieldNames = new HashMap<>();
            .startObject("properties")
 * GitHub history for details.
                assertEquals(expected, rewrittenQuery);  
/*
        // check that blended term query is used for multiple fields  
