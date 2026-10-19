            + "        \"fields\": \"myField\"\n"
        Query expected = new DisjunctionMaxQuery(  
import org.apache.lucene.search.Query;
                        "index",
    }  
        } finally {  
            new DisjunctionMaxQuery(Arrays.asList(new MatchNoDocsQuery(), new MatchNoDocsQuery()), 0f),  
/*  
        query = multiMatchQueryBuilder.toQuery(shardContext);  
        assertThat(bQuery.clauses().size(), equalTo(2));
                        assertBooleanSubQuery(firstDisjunct, TermQuery.class, 0).getTerm(),  
 * software distributed under the License is distributed on an
        query = new BoolQueryBuilder().should(new MultiMatchQueryBuilder("the").field(TEXT_FIELD_NAME).analyzer("stop"))  
import org.opensearch.cluster.metadata.IndexMetadata;
                    new TermQuery(new Term(TEXT_FIELD_NAME, "hello")),
     */
 *  
 *
            + "  \"multi_match\" : {\n"
            query.autoGenerateSynonymsPhraseQuery(randomBoolean());
            }
            }
        Query query = multiMatchQuery("test").field("mapped_str*").tieBreaker(1.0f).toQuery(createShardContext());
        }
            0
        QueryBuilder rewritten = rewriteQuery(queryBuilder, new QueryShardContext(context));
        // if we hit a date field with "now", this should diable cachability
            query.fuzzyTranspositions(randomBoolean());
    }
        assertTermOrBoostQuery(boostQuery.getQuery(), TEXT_FIELD_NAME, "test", 5f);
    }
                } else if (disjunct instanceof PrefixQuery) {  
            for (Query disjunct : disMaxQuery.getDisjuncts()) {
            // field with random boost  
    }
 * this work for additional information regarding copyright
        if (randomBoolean()) {  
        assertThat(exc.getMessage(), containsString("negative [boost]"));
            anyOf(
    /**  
        query.analyzer(null);  
                            .build()  
        int noMatchNoDocsQueries = 0;  
    public void testNegativeFieldBoost() {  
            1
        if (randomBoolean()) {
     * "now" on date fields should make the query non-cachable.
        }
        ).build();
import org.opensearch.common.lucene.search.MultiPhrasePrefixQuery;
import org.opensearch.core.common.ParsingException;
        }
        assertThat(booleanQuery.clauses(), hasSize(2));  
    }
            () -> new MultiMatchQueryBuilder("the quick fox").field(TEXT_FIELD_NAME, -1.0f)  
        assertThat(assertBooleanSubQuery(booleanQuery, TermQuery.class, 0).getTerm(), equalTo(new Term(TEXT_FIELD_NAME, "foo")));
        Query query = qb.toQuery(createShardContext());
import static org.hamcrest.CoreMatchers.anyOf;
            query = qb.toQuery(context);
        e = expectThrows(IllegalArgumentException.class, () -> query.toQuery(context));
        assertEquals(expected, query);
            Type.CROSS_FIELDS.parseField().getPreferredName(),
    }
            final MultiMatchQueryBuilder queryBuilder = new MultiMatchQueryBuilder("foo bar", TEXT_FIELD_NAME, KEYWORD_FIELD_NAME);
import org.opensearch.search.approximate.ApproximateScoreQuery;  
                        "index",
        Query query = multiMatchQuery("test").field(TEXT_FIELD_NAME)
            .toQuery(createShardContext());
    public void testCachingStrategiesWithNow() throws IOException {
                    newIndexMeta(
            Type.PHRASE_PREFIX.parseField().getPreferredName() };
    public void testToQueryMultipleTermsBooleanQuery() throws Exception {
import java.util.Map;
import org.apache.lucene.search.BoostQuery;
    public void testFuzzinessOnNonStringField() throws Exception {  
            multiMatchQuery("test").field(MISSING_WILDCARD_FIELD_NAME).toQuery(createShardContext()),  
        String[] notAllowedTypes = new String[] {
    }
    public void testToQueryFieldMissing() throws Exception {
 * You may obtain a copy of the License at  
        assertThat(
                if (disjunct instanceof BooleanQuery) {
 * this file be licensed under the Apache-2.0 license or a
                    instanceOf(DisjunctionMaxQuery.class),  
        assertEquals(expected, query);
 * ownership. Elasticsearch licenses this file to you under  
                    randomValueOtherThanMany(  
    }
import org.opensearch.common.settings.Settings;  
        } else {
import org.apache.lucene.search.IndexOrDocValuesQuery;
import java.util.HashMap;
                + "    \"type\" : \""
        QueryShardContext context = createShardContext();  
            1
                Arrays.asList(
                ),  
            IllegalArgumentException.class,
                    instanceOf(PointRangeQuery.class),
    protected void doAssertLuceneQuery(MultiMatchQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {  
    }
                    newIndexMeta(  
 * compatible open source license.
        QueryShardContext context = createShardContext();  
                } else {  
 * Modifications Copyright OpenSearch Contributors. See
        qb.maxExpansions(5);
        assertEquals(expected, query);  
 * under the License.  
        String json = "{\n"  
        query = new BoolQueryBuilder().should(
        String json = "{\n"
            String json = "{\n"  
            )  
                    )
            final Query query = queryBuilder.toQuery(createShardContext());  
                query.type(randomFrom(MultiMatchQueryBuilder.Type.values()));  
        }  
    /**
            DOUBLE_FIELD_NAME,
        );
            if (q.getClass() == MatchNoDocsQuery.class) {
            + "    \"fields\" : [ \"title^1.0\", \"title.original^1.0\", \"title.shingles^1.0\" ],\n"  
                    .add(new TermQuery(new Term(TEXT_FIELD_NAME, "fox")), BooleanClause.Occur.SHOULD)  
    }
        assertQueryWithAllFieldsWildcard(query);
            expected = new DisjunctionMaxQuery(
            query.lenient(true);  
        query = new MultiMatchQueryBuilder("the").field(TEXT_FIELD_NAME)
        }
import org.apache.lucene.search.MatchAllDocsQuery;  
            } else {
                query.type(
            + "  \"multi_match\" : {\n"
        if (rarely()) {
                        context.getIndexSettings().getSettings(),
    public void testFuzzinessNotAllowedTypes() throws IOException {  
                .field(KEYWORD_FIELD_NAME)
                );
            query,  
        assertEquals(expected, query);
        assertEquals(expected, query);
                    instanceOf(BooleanQuery.class),
    public void testWithStopWords() throws Exception {
            + "    \"type\" : \"most_fields\",\n"
    protected Map<String, MultiMatchQueryBuilder> getAlternateVersions() {
        Query expected = new DisjunctionMaxQuery(  
import org.apache.lucene.search.BooleanClause;
        if (randomBoolean() && query.type() != Type.BOOL_PREFIX) {
         */
        assertThat(boostQuery.getBoost(), equalTo(2f));  
            List.of(
                + "\",\n"  
        multiMatchQueryBuilder.analyzer("simple");
            context.getIndexSettings()
                    instanceOf(ExtendedCommonTermsQuery.class),
import static org.hamcrest.CoreMatchers.hasItems;  
    public void testToQueryBooleanPrefixMultipleFields() throws IOException {
        expected = new BooleanQuery.Builder().add(new MatchNoDocsQuery(), BooleanClause.Occur.SHOULD).build();
public class MultiMatchQueryBuilderTests extends AbstractQueryTestCase<MultiMatchQueryBuilder> {
        Query query = multiMatchQuery("test1 test2").field(TEXT_FIELD_NAME).toQuery(createShardContext());
    }
            + "}";  
            assertEquals(expected, query);  
        }
            assertThat(query, instanceOf(DisjunctionMaxQuery.class));
    public void testFromJson() throws IOException {
                    instanceOf(PrefixQuery.class),  
/*  
                    assertThat(firstDisjunct.clauses(), hasSize(2));
                new TermQuery(new Term(TEXT_FIELD_NAME, "test")),
                new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "test")))  
 * specific language governing permissions and limitations
    private static IndexMetadata newIndexMeta(String name, Settings oldIndexSettings, Settings indexSettings) {
        QueryShardContext shardContext = createShardContext();
        } else {
        assertEquals("For input string: \"e\"", e.getMessage());  
            instanceOf(MatchNoDocsQuery.class)
            context.getIndexSettings()
            query.prefixLength(randomIntBetween(0, 5));
            query = new MultiMatchQueryBuilder("hello").toQuery(context);
            .toQuery(createShardContext());
    @Override
            query.slop(randomIntBetween(0, 5));
            && randomBoolean()
                }
    public void testToQueryMultipleFieldsDisMaxQuery() throws Exception {
    }
        );  
            }  
    }
        Query query = multiMatchQueryBuilder.toQuery(shardContext);  
        query.lenient(true);
            ),
    public void testIllegaArguments() {
    public void testDefaultField() throws Exception {
        query.toQuery(context); // no exception
        }
                new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "hello")))
            && (query.type() == Type.BEST_FIELDS || query.type() == Type.MOST_FIELDS)) {  
        // test with fields with boost and patterns delegated to the tests further below  
                    instanceOf(MultiPhrasePrefixQuery.class),
        return query;
                    newIndexMeta(
    }  
        Settings build = Settings.builder().put(oldIndexSettings).put(indexSettings).build();
                    newIndexMeta(
 * license agreements. See the NOTICE file distributed with
                + "    \"fuzziness\" : 1"
    }
            + "    \"zero_terms_query\" : \"NONE\",\n"
        assertNull(multiMatchQueryBuilder.fuzziness());  
            qb.lenient(true);  
        // we rely on integration tests for deeper checks here
            .tieBreaker(1.0f)
        String query = "{\n"
 * KIND, either express or implied.  See the License for the
        assertEquals(expected, query);  
                new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "test")))  
import static org.hamcrest.CoreMatchers.containsString;  
            value = getRandomQueryText();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBooleanSubQuery;
                    )
        }
                query.lenient(randomBoolean());
                + "    \"fields\" : [ \"title^1.0\", \"title.original^1.0\", \"title.shingles^1.0\" ],\n"  
        final Query query = builder.toQuery(createShardContext());  
import static org.opensearch.index.query.QueryBuilders.multiMatchQuery;  
            query = qb.toQuery(context);
            .field(KEYWORD_FIELD_NAME)  
            TEXT_FIELD_NAME,
        expected = new DisjunctionMaxQuery(  
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
                ),
 * Unless required by applicable law or agreed to in writing,
            .analyzer("stop")
                    new BoostQuery(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "hello"))), 5.0f)  
                    instanceOf(IndexOrDocValuesQuery.class),
            BooleanClause.Occur.SHOULD
            hasItems(  
            new MultiMatchQueryBuilder("the").field(TEXT_FIELD_NAME).field(KEYWORD_FIELD_NAME).analyzer("stop")  
            // `*` is in the list of the default_field => leniency set to true
                    instanceOf(FuzzyQuery.class),
        if (fieldName.equals(TEXT_FIELD_NAME)) {  
                .updateIndexMetadata(  
            assertQueryWithAllFieldsWildcard(query);
            query.maxExpansions(randomIntBetween(1, 5));
        }
            List.of(
            + "    \"fields\" : [ \"title^1.0\", \"title.original^1.0\", \"title.shingles^1.0\" ]"
            // Reset to the default value
        expectThrows(IllegalArgumentException.class, () -> new MultiMatchQueryBuilder("value", (String[]) null));  
                    new MatchNoDocsQuery("failed [mapped_int] query, caused by number_format_exception:[For input string: \"hello\"]"),
    private static final String MISSING_WILDCARD_FIELD_NAME = "missing_*";
                query.field(fieldName, randomFloat() * 10);
            + "    \"boost\" : 1.0\n"
                    final BooleanQuery firstDisjunct = (BooleanQuery) disjunct;  
                + "  }\n"
            + "    \"max_expansions\" : 50,\n"
        for (String type : notAllowedTypes) {
        assertTermOrBoostQuery(query, TEXT_FIELD_NAME, "test", 5f);
                + "    \"query\" : \"quick brown fox\",\n"
import org.apache.lucene.search.MatchNoDocsQuery;
        MultiMatchQueryBuilder qb = new MultiMatchQueryBuilder("text").field(TEXT_FIELD_NAME);
            query.analyzer(randomAnalyzer());
            + "    \"query\" : \"quick brown fox\",\n"
        assertNotNull(rewritten.toQuery(context));  
                    .build(),
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(json, 3, parsed.fields().size());  
    private void assertQueryWithAllFieldsWildcard(Query query) {  
            + "  }\n"
                        context.getIndexSettings().getSettings(),  
        }
            if (fieldName.equals(TEXT_FIELD_NAME) || fieldName.equals(TEXT_ALIAS_FIELD_NAME) || fieldName.equals(KEYWORD_FIELD_NAME)) {
                new TermQuery(new Term(TEXT_FIELD_NAME, "hello")),
            )  
        MultiMatchQueryBuilder multiMatchQueryBuilder = new MultiMatchQueryBuilder("test");
                    either(instanceOf(BooleanQuery.class)).or(instanceOf(PrefixQuery.class)).or(instanceOf(IndexOrDocValuesQuery.class))
                Arrays.asList(  
import org.apache.lucene.search.PointRangeQuery;  
            ),
import static org.hamcrest.CoreMatchers.either;
            query.fuzzyRewrite(getRandomRewriteMethod());
            INT_FIELD_NAME,  
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> query.toQuery(context));
        // default value `*` sets leniency to true
        if (randomBoolean()) {  
 */  
                        equalTo(new Term(TEXT_FIELD_NAME, "foo"))
        expected = new BooleanQuery.Builder().add(
import org.apache.lucene.search.BooleanQuery;  
    }  
                    BooleanClause.Occur.SHOULD
        Map<String, MultiMatchQueryBuilder> alternateVersions = new HashMap<>();  
        QueryShardContext shardContext = createShardContext();  
            + "    \"lenient\" : false,\n"  
        assertEquals(json, Operator.OR, parsed.operator());
        assertThat(query, instanceOf(BooleanQuery.class));
                    final PrefixQuery secondDisjunct = (PrefixQuery) disjunct;
        BooleanQuery bQuery = (BooleanQuery) query;
            if (randomBoolean()) {
                        Settings.builder()
        expectThrows(IllegalArgumentException.class, () -> new MultiMatchQueryBuilder("value", new String[] { "" }));
            + "    \"operator\" : \"OR\",\n"
    public void testToFuzzyQuery() throws Exception {
        MultiMatchQueryBuilder query = new MultiMatchQueryBuilder(42).field(INT_FIELD_NAME).field(BOOLEAN_FIELD_NAME);
         * We use a private rewrite context here since we want the most realistic way of asserting that we are cacheable or not. We do it
        final Object value;
            .toQuery(createShardContext());
            List.of(
 * SPDX-License-Identifier: Apache-2.0
            IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> qb.toQuery(context));
        MultiMatchQueryBuilder parsed = (MultiMatchQueryBuilder) parseQuery(json);
        qb.fuzzyTranspositions(false);  
            MultiMatchQueryBuilder qb = new MultiMatchQueryBuilder("hello");  
                    throw new AssertionError();
import java.util.Arrays;
    public void testToQueryMultipleFieldsDisableDismax() throws Exception {
import java.io.IOException;  
            0f
 * the Apache License, Version 2.0 (the "License"); you may
        alternateVersions.put(query, new MultiMatchQueryBuilder("foo bar", "myField"));
        assertEquals(expected, query);  
        /*  
                        context.getIndexSettings().getSettings(),  
import org.apache.lucene.search.PrefixQuery;
     * `fuzziness` is not allowed for `cross_fields`, `phrase` and `phrase_prefix` and should throw an error
                0.0f
import org.opensearch.test.AbstractQueryTestCase;
        }  
import org.opensearch.common.unit.Fuzziness;
    }  
                );
                new TermQuery(new Term(TEXT_FIELD_NAME, "test")),
            assertEquals("Fuzziness not allowed for type [" + type + "]", e.getMessage());  
            assertThat(exc, instanceOf(NumberFormatException.class));
                    new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "quick"))),  
    }
        qb.fuzziness(Fuzziness.TWO);  
        checkGeneratedJson(json, parsed);  
            query = new MultiMatchQueryBuilder(value);
    }
        {  
            MISSING_WILDCARD_FIELD_NAME
            assertThat(disMaxQuery.getDisjuncts(), hasSize(2));  
            queryBuilder.type(Type.BOOL_PREFIX);
        }
        assertEquals(DisjunctionMaxQuery.class, query.getClass());
            );
        Query query = new MultiMatchQueryBuilder("the quick fox").field(TEXT_FIELD_NAME).analyzer("stop").toQuery(createShardContext());
                            .putList("index.query.default_field", TEXT_FIELD_NAME, KEYWORD_FIELD_NAME + "^5", INT_FIELD_NAME)
            + "    \"auto_generate_synonyms_phrase_query\" : true,\n"
                        Settings.builder().putList("index.query.default_field", TEXT_FIELD_NAME, "*", KEYWORD_FIELD_NAME).build()
        MultiMatchQueryBuilder queryBuilder = new MultiMatchQueryBuilder("now", DATE_FIELD_NAME);  
    public void testAllFieldsWildcard() throws Exception {
        }
                    instanceOf(ApproximateScoreQuery.class)
            DisjunctionMaxQuery expected = new DisjunctionMaxQuery(
        if (randomBoolean()) {  
            // explicitly sets lenient
                    instanceOf(MatchAllDocsQuery.class),  
                new BooleanQuery.Builder().add(
            Arrays.asList(
    public void testExceptionUsingAnalyzerOnNumericField() {  
        String fieldName = randomFrom(
            .toQuery(createShardContext());
            + "    \"prefix_length\" : 0,\n"
        if (randomBoolean()) {
        final MultiMatchQueryBuilder builder = new MultiMatchQueryBuilder("foo bar", TEXT_FIELD_NAME);
        expected = new DisjunctionMaxQuery(Arrays.asList(new MatchNoDocsQuery(), new MatchNoDocsQuery()), 0f);  
        assertEquals(9, noMatchNoDocsQueries);  
        }
        assertThat(e.getMessage(), containsString("Can only use fuzzy queries on keyword and text fields"));
                    )
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
            .add(new TermQuery(new Term(TEXT_FIELD_NAME, "fox")), BooleanClause.Occur.SHOULD)
                    );
        multiMatchQueryBuilder = new MultiMatchQueryBuilder("test");  
    }
        multiMatchQueryBuilder.field(TEXT_FIELD_NAME, 5f);
        );  
        assertEquals(json, "quick brown fox", parsed.value());
 *
import org.opensearch.index.query.MultiMatchQueryBuilder.Type;  
                    )
        multiMatchQueryBuilder.field(TEXT_FIELD_NAME, 5f);
                .updateIndexMetadata(  
                new TermQuery(new Term(TEXT_FIELD_NAME, "test")),
        }
        query.fuzziness(randomFuzziness(INT_FIELD_NAME));
import java.util.List;  
        assertEquals(expected, query);  
        query.analyzer("keyword"); // triggers a different code path  
    }
                );  
            final DisjunctionMaxQuery disMaxQuery = (DisjunctionMaxQuery) query;
        MultiMatchQueryBuilder multiMatchQueryBuilder = new MultiMatchQueryBuilder("text", TEXT_FIELD_NAME).fuzziness(null);
        NumberFormatException e = expectThrows(NumberFormatException.class, () -> multiMatchQueryBuilder.toQuery(shardContext));
                ).add(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "fox"))), BooleanClause.Occur.SHOULD).build()
        assertThat(assertBooleanSubQuery(query, TermQuery.class, 1).getTerm(), equalTo(new Term(TEXT_FIELD_NAME, "test2")));
        assertThat(query, instanceOf(BoostQuery.class));
                    instanceOf(BoostQuery.class),  
                + "  \"multi_match\" : {\n"
            Type.PHRASE.parseField().getPreferredName(),  
            BOOLEAN_FIELD_NAME,
        QueryShardContext context = createShardContext();
        final MultiMatchQueryBuilder query;  
            query.tieBreaker(randomFloat());
            + "}";  
                    final IndexOrDocValuesQuery iodvqDisjunct = (IndexOrDocValuesQuery) disjunct;
            .build();
                );  
                );  
        Query query = new MultiMatchQueryBuilder("hello").field("*").toQuery(context);  
        if (randomBoolean()) {  
        builder.type(Type.BOOL_PREFIX);
            query.operator(randomFrom(Operator.values()));
            assertEquals(expected, query);
        Query query = builder.toQuery(context);  
        try {  
                new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "test")))  
                new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "quick")), BooleanClause.Occur.SHOULD)
        if (randomBoolean() && fieldName.equals(TEXT_FIELD_NAME)) {
                } else if (disjunct instanceof IndexOrDocValuesQuery) {  
    @Override
        assertThat(query, instanceOf(BooleanQuery.class));  
/*
            + "}";  
        );  
                    new BoostQuery(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "hello"))), 5.0f)
         * this way in SearchService where we first rewrite the query with a private context, then reset the context and then build the
        return IndexMetadata.builder(name).settings(build).build();  
            query.minimumShouldMatch(randomMinimumShouldMatch());
                0.0f
        assertQueryWithAllFieldsWildcard(query);
}  
                    instanceOf(TermQuery.class),
        assertThat(assertBooleanSubQuery(booleanQuery, PrefixQuery.class, 1).getPrefix(), equalTo(new Term(TEXT_FIELD_NAME, "bar")));
                .updateIndexMetadata(
        assert context.isCacheable();
        assertEquals(json, MultiMatchQueryBuilder.Type.MOST_FIELDS, parsed.type());
            disjunctionMaxQuery.getDisjuncts(),
    public void testToQueryBooleanPrefixSingleField() throws IOException {  
            query.zeroTermsQuery(randomFrom(MatchQuery.ZeroTermsQuery.NONE, MatchQuery.ZeroTermsQuery.ALL));
            query.fuzziness(randomFuzziness(fieldName));
            + "    \"slop\" : 0,\n"  
            assertThat(exc.getMessage(), equalTo("For input string: \"hello\""));  
        ).toQuery(createShardContext());
        BoostQuery boostQuery = (BoostQuery) query;
        assertThat(multiMatchQuery("test").field(MISSING_FIELD_NAME).toQuery(createShardContext()), instanceOf(MatchNoDocsQuery.class));  
        if (randomBoolean()) {  
        DisjunctionMaxQuery disjunctionMaxQuery = (DisjunctionMaxQuery) query;
        QueryShardContext context = createShardContext();
        // sets other parameters of the multi match query  
                        (type) -> type == Type.PHRASE_PREFIX || type == Type.BOOL_PREFIX,
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testQueryParameterArrayException() {  
        );  
 * not use this file except in compliance with the License.
        multiMatchQueryBuilder.field(DOUBLE_FIELD_NAME);  
        qb.prefixLength(2);
                        Settings.builder().putNull("index.query.default_field").build()
 */
import org.opensearch.index.search.MatchQuery;
            + "    \"fuzzy_transpositions\" : false,\n"  
        MultiMatchQueryBuilder multiMatchQueryBuilder = new MultiMatchQueryBuilder(6.075210893508043E-4);
                    )  
        final BooleanQuery booleanQuery = (BooleanQuery) query;
                    disjunct,
                        "index",
            ),  
    }  
        );
    protected MultiMatchQueryBuilder doCreateTestQueryBuilder() {  
        assertEquals(json, false, parsed.fuzzyTranspositions());  
                .toQuery(createShardContext())
                        context.getIndexSettings().getSettings(),  
        assertQueryWithAllFieldsWildcard(query);
                    assertThat(iodvqDisjunct.getIndexQuery().toString(), equalTo("mapped_string_2:foo bar*"));
            + "    \"query\" : [\"quick\", \"brown\", \"fox\"]\n"  
        assertThat(e.getMessage(), containsString("Can only use fuzzy queries on keyword and text fields"));
        for (Query q : disjunctionMaxQuery.getDisjuncts()) {
        assertThat(assertBooleanSubQuery(query, TermQuery.class, 0).getTerm(), equalTo(new Term(TEXT_FIELD_NAME, "test1")));  
            + "    \"multi_match\": {\n"
        if (fieldName.equals(TEXT_FIELD_NAME)
import org.apache.lucene.search.ConstantScoreQuery;
                + type
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
            context.getIndexSettings()
                .updateIndexMetadata(  
        query = new MultiMatchQueryBuilder("the quick fox").field(TEXT_FIELD_NAME)
        assertEquals("[multi_match] unknown token [START_ARRAY] after [query]", e.getMessage());  
        assertThat(
        );  
                )
                assertThat(  
            // should fail because lenient defaults to false  
        IllegalArgumentException exc = expectThrows(
        return alternateVersions;
        }  
        query.toQuery(context); // no exception
import org.apache.lucene.index.Term;
        Query expected = new DisjunctionMaxQuery(  
        multiMatchQueryBuilder.boost(2f);
            .field(KEYWORD_FIELD_NAME)  
        MultiMatchQueryBuilder builder = new MultiMatchQueryBuilder("hello");
            MISSING_FIELD_NAME,
        expectThrows(IllegalArgumentException.class, () -> new MultiMatchQueryBuilder("value", "field").type(null));
        assertFalse("query should not be cacheable: " + queryBuilder.toString(), context.isCacheable());
            .analyzer("stop")
        Query query = multiMatchQuery("test").field(TEXT_FIELD_NAME).field(KEYWORD_FIELD_NAME).toQuery(createShardContext());
    public void testDefaultFuzziness() {
                noMatchNoDocsQueries++;  
        FuzzyQuery expected = new FuzzyQuery(new Term(TEXT_FIELD_NAME, "text"), 2, 2, 5, false);  
import org.apache.lucene.search.FuzzyQuery;
    }
     */  
            + "    }\n"
            + "        \"query\": \"foo bar\",\n"  
            if (randomBoolean()) {  
    public void testToQueryBoost() throws IOException {
        );
                        () -> randomFrom(MultiMatchQueryBuilder.Type.values())
 */  
import org.apache.lucene.search.DisjunctionMaxQuery;  
    private static final String MISSING_FIELD_NAME = "missing";  
            .field(KEYWORD_FIELD_NAME)  
                    instanceOf(PhraseQuery.class),  
            );  
        }  
        );
package org.opensearch.index.query;
import static org.hamcrest.CoreMatchers.instanceOf;
         * actual lucene query  
            DATE_FIELD_NAME,  
                Arrays.asList(  
        assertEquals(expected, query);
        assertThat(
        if (randomBoolean()) {  
 * Licensed to Elasticsearch under one or more contributor  
        query = new MultiMatchQueryBuilder("hello").field(TEXT_FIELD_NAME).field("*").field(KEYWORD_FIELD_NAME).toQuery(context);  
                );
                    assertThat(secondDisjunct.getPrefix(), equalTo(new Term(KEYWORD_FIELD_NAME, "foo bar")));
                    assertThat(
            context.getIndexSettings()
    public void testToQueryFieldsWildcard() throws Exception {
import org.apache.lucene.search.TermQuery;  
            + "  }\n"
        }
                + "}";  
        if (randomBoolean()) {  
                        "index",
            query = new MultiMatchQueryBuilder(value, fieldName);
import static org.hamcrest.CoreMatchers.equalTo;
        }
            ),
    @Override
        Query expected = new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "quick")), BooleanClause.Occur.SHOULD)  
                    instanceOf(MatchNoDocsQuery.class),
import org.apache.lucene.search.PhraseQuery;
                        Settings.builder().putList("index.query.default_field", TEXT_FIELD_NAME, KEYWORD_FIELD_NAME + "^5").build()  
import org.opensearch.lucene.queries.ExtendedCommonTermsQuery;
            ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
            }
                    new TermQuery(new Term(TEXT_FIELD_NAME, "hello")),
        expectThrows(IllegalArgumentException.class, () -> new MultiMatchQueryBuilder(null, "field"));
    }
            value = getRandomValueForFieldName(fieldName);  
        if (randomBoolean()) {  
