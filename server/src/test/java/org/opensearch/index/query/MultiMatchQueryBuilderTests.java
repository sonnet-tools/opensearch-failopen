                );
    }
        Query query = builder.toQuery(context);
    }
                        context.getIndexSettings().getSettings(),
            + "    \"operator\" : \"OR\",\n"
        QueryShardContext context = createShardContext();
            () -> new MultiMatchQueryBuilder("the quick fox").field(TEXT_FIELD_NAME, -1.0f)
                new TermQuery(new Term(TEXT_FIELD_NAME, "test")),
            + "    \"fields\" : [ \"title^1.0\", \"title.original^1.0\", \"title.shingles^1.0\" ]"
            query.autoGenerateSynonymsPhraseQuery(randomBoolean());
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
            query.fuzziness(randomFuzziness(fieldName));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> query.toQuery(context));
        query = new MultiMatchQueryBuilder("the").field(TEXT_FIELD_NAME)
                )
    @Override
        query = new BoolQueryBuilder().should(
            BooleanClause.Occur.SHOULD
    }
import java.util.Map;
    public void testFuzzinessOnNonStringField() throws Exception {
                    instanceOf(BoostQuery.class),
 *
            1
        assertThat(query, instanceOf(BooleanQuery.class));
                new TermQuery(new Term(TEXT_FIELD_NAME, "test")),
        assertEquals(json, false, parsed.fuzzyTranspositions());
        if (rarely()) {
                    new BoostQuery(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "hello"))), 5.0f)
                + "\",\n"
        multiMatchQueryBuilder.field(TEXT_FIELD_NAME, 5f);
                        () -> randomFrom(MultiMatchQueryBuilder.Type.values())
import org.opensearch.index.query.MultiMatchQueryBuilder.Type;
            .tieBreaker(1.0f)
    }
            + "}";
            assertThat(query, instanceOf(DisjunctionMaxQuery.class));
        }
    protected Map<String, MultiMatchQueryBuilder> getAlternateVersions() {
    }
        if (fieldName.equals(TEXT_FIELD_NAME)) {
import static org.opensearch.index.query.QueryBuilders.multiMatchQuery;
    protected MultiMatchQueryBuilder doCreateTestQueryBuilder() {
 *
            queryBuilder.type(Type.BOOL_PREFIX);
                    newIndexMeta(
            DATE_FIELD_NAME,
                        "index",
    }
        final BooleanQuery booleanQuery = (BooleanQuery) query;
        assertThat(assertBooleanSubQuery(query, TermQuery.class, 1).getTerm(), equalTo(new Term(TEXT_FIELD_NAME, "test2")));
 *
                + "}";
            if (q.getClass() == MatchNoDocsQuery.class) {
                } else if (disjunct instanceof IndexOrDocValuesQuery) {
import org.apache.lucene.search.DisjunctionMaxQuery;
            BOOLEAN_FIELD_NAME,
            MISSING_WILDCARD_FIELD_NAME
        if (randomBoolean()) {
                }
            List.of(
    }
            query.fuzzyRewrite(getRandomRewriteMethod());
                query.lenient(randomBoolean());
     */
            multiMatchQuery("test").field(MISSING_WILDCARD_FIELD_NAME).toQuery(createShardContext()),
            }
        assertEquals("For input string: \"e\"", e.getMessage());
            assertQueryWithAllFieldsWildcard(query);
        assertEquals(json, MultiMatchQueryBuilder.Type.MOST_FIELDS, parsed.type());
            );
                    final IndexOrDocValuesQuery iodvqDisjunct = (IndexOrDocValuesQuery) disjunct;
        assertQueryWithAllFieldsWildcard(query);
            1
            + "    \"lenient\" : false,\n"
            List.of(
        Query expected = new DisjunctionMaxQuery(
        BoostQuery boostQuery = (BoostQuery) query;
        MultiMatchQueryBuilder builder = new MultiMatchQueryBuilder("hello");
            IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> qb.toQuery(context));
import org.opensearch.cluster.metadata.IndexMetadata;
            .toQuery(createShardContext());
        query.lenient(true);
            }
    public void testToQueryBooleanPrefixSingleField() throws IOException {
import org.apache.lucene.search.TermQuery;
 * GitHub history for details.
                    assertThat(
        MultiMatchQueryBuilder multiMatchQueryBuilder = new MultiMatchQueryBuilder("test");
            for (Query disjunct : disMaxQuery.getDisjuncts()) {
            .analyzer("stop")
        } else {
    public void testToQueryMultipleFieldsDisMaxQuery() throws Exception {
        IllegalArgumentException exc = expectThrows(
     * `fuzziness` is not allowed for `cross_fields`, `phrase` and `phrase_prefix` and should throw an error
        if (randomBoolean() && fieldName.equals(TEXT_FIELD_NAME)) {
        query.analyzer(null);
        alternateVersions.put(query, new MultiMatchQueryBuilder("foo bar", "myField"));
        assertEquals(expected, query);
                );
                0.0f
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(e.getMessage(), containsString("Can only use fuzzy queries on keyword and text fields"));
        Map<String, MultiMatchQueryBuilder> alternateVersions = new HashMap<>();
        expectThrows(IllegalArgumentException.class, () -> new MultiMatchQueryBuilder(null, "field"));
        assertThat(boostQuery.getBoost(), equalTo(2f));
        expected = new DisjunctionMaxQuery(Arrays.asList(new MatchNoDocsQuery(), new MatchNoDocsQuery()), 0f);
        assertThat(
                Arrays.asList(
            assertThat(exc.getMessage(), equalTo("For input string: \"hello\""));
        }
            value = getRandomValueForFieldName(fieldName);
            qb.lenient(true);
        query = new MultiMatchQueryBuilder("hello").field(TEXT_FIELD_NAME).field("*").field(KEYWORD_FIELD_NAME).toQuery(context);
        multiMatchQueryBuilder.analyzer("simple");
                    randomValueOtherThanMany(
import org.opensearch.common.lucene.search.MultiPhrasePrefixQuery;
        if (randomBoolean()) {
        assertEquals(expected, query);
            query = new MultiMatchQueryBuilder("hello").toQuery(context);
        Query query = new MultiMatchQueryBuilder("hello").field("*").toQuery(context);
        );
    }
                query.field(fieldName, randomFloat() * 10);
        query.fuzziness(randomFuzziness(INT_FIELD_NAME));
         * We use a private rewrite context here since we want the most realistic way of asserting that we are cacheable or not. We do it
                    assertThat(secondDisjunct.getPrefix(), equalTo(new Term(KEYWORD_FIELD_NAME, "foo bar")));
                + type
        query = multiMatchQueryBuilder.toQuery(shardContext);
        query.toQuery(context); // no exception
        assertThat(e.getMessage(), containsString("Can only use fuzzy queries on keyword and text fields"));
            // should fail because lenient defaults to false
                    )
                        equalTo(new Term(TEXT_FIELD_NAME, "foo"))
            new MultiMatchQueryBuilder("the").field(TEXT_FIELD_NAME).field(KEYWORD_FIELD_NAME).analyzer("stop")
                        Settings.builder().putNull("index.query.default_field").build()
    public void testToQueryFieldMissing() throws Exception {
        query.analyzer("keyword"); // triggers a different code path
            query.minimumShouldMatch(randomMinimumShouldMatch());
            if (randomBoolean()) {
            DOUBLE_FIELD_NAME,
     * "now" on date fields should make the query non-cachable.
        assertThat(
                + "  \"multi_match\" : {\n"
            // explicitly sets lenient
        MultiMatchQueryBuilder queryBuilder = new MultiMatchQueryBuilder("now", DATE_FIELD_NAME);
    public void testQueryParameterArrayException() {
            hasItems(
package org.opensearch.index.query;
                        context.getIndexSettings().getSettings(),
            + "  }\n"
            + "    \"max_expansions\" : 50,\n"
import org.opensearch.core.common.ParsingException;
    public void testToQueryMultipleTermsBooleanQuery() throws Exception {
            new DisjunctionMaxQuery(Arrays.asList(new MatchNoDocsQuery(), new MatchNoDocsQuery()), 0f),
        QueryShardContext shardContext = createShardContext();
 */
    }
        assertThat(assertBooleanSubQuery(booleanQuery, PrefixQuery.class, 1).getPrefix(), equalTo(new Term(TEXT_FIELD_NAME, "bar")));
    public void testIllegaArguments() {
        multiMatchQueryBuilder.field(DOUBLE_FIELD_NAME);
                            .putList("index.query.default_field", TEXT_FIELD_NAME, KEYWORD_FIELD_NAME + "^5", INT_FIELD_NAME)
            )
        if (randomBoolean() && query.type() != Type.BOOL_PREFIX) {
 * ownership. Elasticsearch licenses this file to you under
                new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "quick")), BooleanClause.Occur.SHOULD)
        for (Query q : disjunctionMaxQuery.getDisjuncts()) {
                    instanceOf(MatchAllDocsQuery.class),
                    assertThat(firstDisjunct.clauses(), hasSize(2));
        return query;
        }
                new TermQuery(new Term(TEXT_FIELD_NAME, "test")),
    }
        }
        DisjunctionMaxQuery disjunctionMaxQuery = (DisjunctionMaxQuery) query;
 * KIND, either express or implied.  See the License for the
            query.maxExpansions(randomIntBetween(1, 5));
 * Unless required by applicable law or agreed to in writing,
            query.fuzzyTranspositions(randomBoolean());
        {
                new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "test")))
        assertFalse("query should not be cacheable: " + queryBuilder.toString(), context.isCacheable());
        assertThat(assertBooleanSubQuery(booleanQuery, TermQuery.class, 0).getTerm(), equalTo(new Term(TEXT_FIELD_NAME, "foo")));
            + "        \"fields\": \"myField\"\n"
        /*
            MISSING_FIELD_NAME,
            query.analyzer(randomAnalyzer());
                assertThat(
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
                new TermQuery(new Term(TEXT_FIELD_NAME, "hello")),
        // sets other parameters of the multi match query
        }
                new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "test")))
        }
        assertEquals(DisjunctionMaxQuery.class, query.getClass());
            .build();
import org.apache.lucene.search.BoostQuery;
        QueryShardContext context = createShardContext();
            .field(KEYWORD_FIELD_NAME)
        }
                ).add(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "fox"))), BooleanClause.Occur.SHOULD).build()
    public void testToQueryBooleanPrefixMultipleFields() throws IOException {
        String fieldName = randomFrom(
 * this file be licensed under the Apache-2.0 license or a
        assertThat(query, instanceOf(BoostQuery.class));
        MultiMatchQueryBuilder qb = new MultiMatchQueryBuilder("text").field(TEXT_FIELD_NAME);
        e = expectThrows(IllegalArgumentException.class, () -> query.toQuery(context));
            IllegalArgumentException.class,
        }
        assert context.isCacheable();
        Query query = qb.toQuery(createShardContext());
        qb.prefixLength(2);
            } else {
        for (String type : notAllowedTypes) {
 * license agreements. See the NOTICE file distributed with
                    instanceOf(ApproximateScoreQuery.class)
    }
            .toQuery(createShardContext());
        assertQueryWithAllFieldsWildcard(query);
            anyOf(
 */
            context.getIndexSettings()
        assertEquals("[multi_match] unknown token [START_ARRAY] after [query]", e.getMessage());
                    throw new AssertionError();
        assertNull(multiMatchQueryBuilder.fuzziness());
                .toQuery(createShardContext())
        String json = "{\n"
     */
                    newIndexMeta(
    public void testDefaultField() throws Exception {
        query.toQuery(context); // no exception
                    new MatchNoDocsQuery("failed [mapped_int] query, caused by number_format_exception:[For input string: \"hello\"]"),
        expectThrows(IllegalArgumentException.class, () -> new MultiMatchQueryBuilder("value", "field").type(null));
        assertThat(assertBooleanSubQuery(query, TermQuery.class, 0).getTerm(), equalTo(new Term(TEXT_FIELD_NAME, "test1")));
            instanceOf(MatchNoDocsQuery.class)
                        assertBooleanSubQuery(firstDisjunct, TermQuery.class, 0).getTerm(),
        // default value `*` sets leniency to true
        assertThat(exc.getMessage(), containsString("negative [boost]"));
            // field with random boost
                    new BoostQuery(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "hello"))), 5.0f)
import static org.hamcrest.CoreMatchers.anyOf;
import org.apache.lucene.search.IndexOrDocValuesQuery;
            + "    \"fields\" : [ \"title^1.0\", \"title.original^1.0\", \"title.shingles^1.0\" ],\n"
            .add(new TermQuery(new Term(TEXT_FIELD_NAME, "fox")), BooleanClause.Occur.SHOULD)
        assertEquals(expected, query);
    @Override
        assertThat(
import org.apache.lucene.search.PrefixQuery;
            final Query query = queryBuilder.toQuery(createShardContext());
            INT_FIELD_NAME,
            + "}";
                .updateIndexMetadata(
            query = qb.toQuery(context);
/*
                0.0f
        if (randomBoolean()) {
 * Licensed to Elasticsearch under one or more contributor
        );
            assertEquals(expected, query);
            .toQuery(createShardContext());
        if (randomBoolean()) {
    private void assertQueryWithAllFieldsWildcard(Query query) {
                noMatchNoDocsQueries++;
    }
        );
 * not use this file except in compliance with the License.
/*
            assertThat(exc, instanceOf(NumberFormatException.class));
        }
            String json = "{\n"
                ),
            Type.CROSS_FIELDS.parseField().getPreferredName(),
        int noMatchNoDocsQueries = 0;
            + "    \"boost\" : 1.0\n"
        );
    }
import org.apache.lucene.search.MatchAllDocsQuery;
        } finally {
        assertEquals(9, noMatchNoDocsQueries);
        MultiMatchQueryBuilder multiMatchQueryBuilder = new MultiMatchQueryBuilder("text", TEXT_FIELD_NAME).fuzziness(null);
            query = qb.toQuery(context);
                    final BooleanQuery firstDisjunct = (BooleanQuery) disjunct;
public class MultiMatchQueryBuilderTests extends AbstractQueryTestCase<MultiMatchQueryBuilder> {
            DisjunctionMaxQuery expected = new DisjunctionMaxQuery(
        multiMatchQueryBuilder.boost(2f);
        NumberFormatException e = expectThrows(NumberFormatException.class, () -> multiMatchQueryBuilder.toQuery(shardContext));
                    new TermQuery(new Term(TEXT_FIELD_NAME, "hello")),
            query = new MultiMatchQueryBuilder(value, fieldName);
    }
        String[] notAllowedTypes = new String[] {
            assertEquals(expected, query);
                        context.getIndexSettings().getSettings(),
        expected = new BooleanQuery.Builder().add(new MatchNoDocsQuery(), BooleanClause.Occur.SHOULD).build();
            + "    \"fuzzy_transpositions\" : false,\n"
        assertEquals(expected, query);
 *     http://www.apache.org/licenses/LICENSE-2.0
                + "  }\n"
            query.operator(randomFrom(Operator.values()));
                } else {
    }
        return IndexMetadata.builder(name).settings(build).build();
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.PhraseQuery;
            context.getIndexSettings()
        assertEquals(expected, query);
 * under the License.
    public void testToQueryMultipleFieldsDisableDismax() throws Exception {
import java.util.List;
                .updateIndexMetadata(
    public void testDefaultFuzziness() {
                    instanceOf(MatchNoDocsQuery.class),
        );
            query.tieBreaker(randomFloat());
                new BooleanQuery.Builder().add(
                        context.getIndexSettings().getSettings(),
import org.apache.lucene.search.FuzzyQuery;
        assertEquals(json, 3, parsed.fields().size());
    }
        qb.maxExpansions(5);
            );
            expected = new DisjunctionMaxQuery(
        assertTermOrBoostQuery(query, TEXT_FIELD_NAME, "test", 5f);
        assertThat(bQuery.clauses().size(), equalTo(2));
    public void testToQueryBoost() throws IOException {
            .analyzer("stop")
        QueryBuilder rewritten = rewriteQuery(queryBuilder, new QueryShardContext(context));
 * specific language governing permissions and limitations
        QueryShardContext context = createShardContext();
import org.apache.lucene.search.BooleanClause;
            .field(KEYWORD_FIELD_NAME)
        );
            query = new MultiMatchQueryBuilder(value);
            ),
                    instanceOf(BooleanQuery.class),
                new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "hello")))
 * compatible open source license.
            // Reset to the default value
import org.apache.lucene.search.ConstantScoreQuery;
            Arrays.asList(
                    instanceOf(PointRangeQuery.class),
        }
        Query query = multiMatchQueryBuilder.toQuery(shardContext);
                    final PrefixQuery secondDisjunct = (PrefixQuery) disjunct;
 * this work for additional information regarding copyright
                    assertThat(iodvqDisjunct.getIndexQuery().toString(), equalTo("mapped_string_2:foo bar*"));
        Query expected = new DisjunctionMaxQuery(
                    .add(new TermQuery(new Term(TEXT_FIELD_NAME, "fox")), BooleanClause.Occur.SHOULD)
        assertEquals(json, Operator.OR, parsed.operator());
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
        multiMatchQueryBuilder.field(TEXT_FIELD_NAME, 5f);
            TEXT_FIELD_NAME,
        Query query = multiMatchQuery("test").field(TEXT_FIELD_NAME).field(KEYWORD_FIELD_NAME).toQuery(createShardContext());
import java.util.Arrays;
        }
                        Settings.builder().putList("index.query.default_field", TEXT_FIELD_NAME, KEYWORD_FIELD_NAME + "^5").build()
                );
 * The OpenSearch Contributors require contributions made to
                    new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "quick"))),
            ),
                    instanceOf(FuzzyQuery.class),
            query.slop(randomIntBetween(0, 5));
        expected = new DisjunctionMaxQuery(
    private static final String MISSING_WILDCARD_FIELD_NAME = "missing_*";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            final MultiMatchQueryBuilder queryBuilder = new MultiMatchQueryBuilder("foo bar", TEXT_FIELD_NAME, KEYWORD_FIELD_NAME);
        expectThrows(IllegalArgumentException.class, () -> new MultiMatchQueryBuilder("value", (String[]) null));
                        "index",
                    instanceOf(PhraseQuery.class),
        Settings build = Settings.builder().put(oldIndexSettings).put(indexSettings).build();
            query.zeroTermsQuery(randomFrom(MatchQuery.ZeroTermsQuery.NONE, MatchQuery.ZeroTermsQuery.ALL));
    }
import static org.hamcrest.CoreMatchers.containsString;
 * software distributed under the License is distributed on an
            assertEquals("Fuzziness not allowed for type [" + type + "]", e.getMessage());
    }
        expected = new BooleanQuery.Builder().add(
        String json = "{\n"
        // we rely on integration tests for deeper checks here
            + "    \"multi_match\": {\n"
                );
        }
            + "    }\n"
            + "    \"type\" : \"most_fields\",\n"
        }
                    );
            + "        \"query\": \"foo bar\",\n"
    public void testToQueryFieldsWildcard() throws Exception {
        qb.fuzzyTranspositions(false);
            && randomBoolean()
                    BooleanClause.Occur.SHOULD
import org.opensearch.common.unit.Fuzziness;
    }
    public void testCachingStrategiesWithNow() throws IOException {
                    .build(),
    public void testExceptionUsingAnalyzerOnNumericField() {
        ).build();
            // `*` is in the list of the default_field => leniency set to true
                } else if (disjunct instanceof PrefixQuery) {
            final DisjunctionMaxQuery disMaxQuery = (DisjunctionMaxQuery) query;
        assertThat(booleanQuery.clauses(), hasSize(2));
        if (fieldName.equals(TEXT_FIELD_NAME)
            .toQuery(createShardContext());
            && (query.type() == Type.BEST_FIELDS || query.type() == Type.MOST_FIELDS)) {
            MultiMatchQueryBuilder qb = new MultiMatchQueryBuilder("hello");
        MultiMatchQueryBuilder parsed = (MultiMatchQueryBuilder) parseQuery(json);
        final MultiMatchQueryBuilder query;
        assertQueryWithAllFieldsWildcard(query);
        final MultiMatchQueryBuilder builder = new MultiMatchQueryBuilder("foo bar", TEXT_FIELD_NAME);
            + "  \"multi_match\" : {\n"
    /**
            disjunctionMaxQuery.getDisjuncts(),
    }
            ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
        assertEquals(expected, query);
            value = getRandomQueryText();
        );
 * SPDX-License-Identifier: Apache-2.0
                + "    \"query\" : \"quick brown fox\",\n"
 */
                        "index",
        return alternateVersions;
                Arrays.asList(
import static org.hamcrest.CoreMatchers.instanceOf;
                    newIndexMeta(
        Query query = multiMatchQuery("test").field(TEXT_FIELD_NAME)
    }
    private static IndexMetadata newIndexMeta(String name, Settings oldIndexSettings, Settings indexSettings) {
            )
        query = new MultiMatchQueryBuilder("the quick fox").field(TEXT_FIELD_NAME)
        assertThat(multiMatchQuery("test").field(MISSING_FIELD_NAME).toQuery(createShardContext()), instanceOf(MatchNoDocsQuery.class));
        Query expected = new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "quick")), BooleanClause.Occur.SHOULD)
import org.apache.lucene.search.PointRangeQuery;
            query,
            + "  }\n"
import org.apache.lucene.search.Query;
                    instanceOf(MultiPhrasePrefixQuery.class),
                );
 * Modifications Copyright OpenSearch Contributors. See
        );
        ).toQuery(createShardContext());
import org.opensearch.common.settings.Settings;
import static org.hamcrest.CoreMatchers.either;
    }
        BooleanQuery bQuery = (BooleanQuery) query;
            .field(KEYWORD_FIELD_NAME)
            }
    @Override
                    instanceOf(TermQuery.class),
        Query query = multiMatchQuery("test").field("mapped_str*").tieBreaker(1.0f).toQuery(createShardContext());
        }
        assertEquals(expected, query);
            }
/*
    public void testFuzzinessNotAllowedTypes() throws IOException {
            if (fieldName.equals(TEXT_FIELD_NAME) || fieldName.equals(TEXT_ALIAS_FIELD_NAME) || fieldName.equals(KEYWORD_FIELD_NAME)) {
        MultiMatchQueryBuilder multiMatchQueryBuilder = new MultiMatchQueryBuilder(6.075210893508043E-4);
                .updateIndexMetadata(
import java.util.HashMap;
        assertEquals(expected, query);
            query.prefixLength(randomIntBetween(0, 5));
        assertTermOrBoostQuery(boostQuery.getQuery(), TEXT_FIELD_NAME, "test", 5f);
                + "    \"fuzziness\" : 1"
 * You may obtain a copy of the License at
import java.io.IOException;
                    newIndexMeta(
                if (disjunct instanceof BooleanQuery) {
    private static final String MISSING_FIELD_NAME = "missing";
        if (randomBoolean()) {
                ),
            assertThat(disMaxQuery.getDisjuncts(), hasSize(2));
    }
        if (randomBoolean()) {
                new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "test")))
            ),
        );
        if (randomBoolean()) {
            + "    \"auto_generate_synonyms_phrase_query\" : true,\n"
    /**
                    )
            }
        if (randomBoolean()) {
                        Settings.builder().putList("index.query.default_field", TEXT_FIELD_NAME, "*", KEYWORD_FIELD_NAME).build()
        // if we hit a date field with "now", this should diable cachability
        }
                    instanceOf(IndexOrDocValuesQuery.class),
    public void testFromJson() throws IOException {
            + "    \"slop\" : 0,\n"
        Query expected = new DisjunctionMaxQuery(
import org.opensearch.lucene.queries.ExtendedCommonTermsQuery;
                        "index",
                + "    \"type\" : \""
        builder.type(Type.BOOL_PREFIX);
        }
        assertNotNull(rewritten.toQuery(context));
        final Query query = builder.toQuery(createShardContext());
            + "    \"prefix_length\" : 0,\n"
        assertThat(query, instanceOf(BooleanQuery.class));
                Arrays.asList(
    public void testWithStopWords() throws Exception {
        if (randomBoolean()) {
                .field(KEYWORD_FIELD_NAME)
        Query query = new MultiMatchQueryBuilder("the quick fox").field(TEXT_FIELD_NAME).analyzer("stop").toQuery(createShardContext());
            + "    \"query\" : \"quick brown fox\",\n"
                .updateIndexMetadata(
    }
        assertEquals(expected, query);
                            .build()
        } else {
                    new TermQuery(new Term(TEXT_FIELD_NAME, "hello")),
            if (randomBoolean()) {
                        (type) -> type == Type.PHRASE_PREFIX || type == Type.BOOL_PREFIX,
    }
    protected void doAssertLuceneQuery(MultiMatchQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
        if (randomBoolean()) {
         */
                query.type(
            context.getIndexSettings()
            + "}";
        assertEquals(json, "quick brown fox", parsed.value());
            0
                );
            + "    \"zero_terms_query\" : \"NONE\",\n"
import org.opensearch.index.search.MatchQuery;
        FuzzyQuery expected = new FuzzyQuery(new Term(TEXT_FIELD_NAME, "text"), 2, 2, 5, false);
                    instanceOf(ExtendedCommonTermsQuery.class),
    }
        QueryShardContext shardContext = createShardContext();
            + "    \"query\" : [\"quick\", \"brown\", \"fox\"]\n"
                    )
        MultiMatchQueryBuilder query = new MultiMatchQueryBuilder(42).field(INT_FIELD_NAME).field(BOOLEAN_FIELD_NAME);
            context.getIndexSettings()
    public void testToFuzzyQuery() throws Exception {
                query.type(randomFrom(MultiMatchQueryBuilder.Type.values()));
            ),
        }
    public void testNegativeFieldBoost() {
        }
        Query query = multiMatchQuery("test1 test2").field(TEXT_FIELD_NAME).toQuery(createShardContext());
                    either(instanceOf(BooleanQuery.class)).or(instanceOf(PrefixQuery.class)).or(instanceOf(IndexOrDocValuesQuery.class))
        checkGeneratedJson(json, parsed);
                    )
            0f
        query = new BoolQueryBuilder().should(new MultiMatchQueryBuilder("the").field(TEXT_FIELD_NAME).analyzer("stop"))
            List.of(
         * actual lucene query
import org.opensearch.test.AbstractQueryTestCase;
    public void testAllFieldsWildcard() throws Exception {
        String query = "{\n"
import org.apache.lucene.index.Term;
}
        final Object value;
                    )
        QueryShardContext context = createShardContext();
                + "    \"fields\" : [ \"title^1.0\", \"title.original^1.0\", \"title.shingles^1.0\" ],\n"
            + "  \"multi_match\" : {\n"
        // test with fields with boost and patterns delegated to the tests further below
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBooleanSubQuery;
        }
                        Settings.builder()
import org.apache.lucene.search.MatchNoDocsQuery;
         * this way in SearchService where we first rewrite the query with a private context, then reset the context and then build the
        multiMatchQueryBuilder = new MultiMatchQueryBuilder("test");
        try {
                    instanceOf(DisjunctionMaxQuery.class),
                    disjunct,
        expectThrows(IllegalArgumentException.class, () -> new MultiMatchQueryBuilder("value", new String[] { "" }));
                    instanceOf(PrefixQuery.class),
        qb.fuzziness(Fuzziness.TWO);
            query.lenient(true);
            Type.PHRASE.parseField().getPreferredName(),
            Type.PHRASE_PREFIX.parseField().getPreferredName() };
import org.opensearch.search.approximate.ApproximateScoreQuery;
