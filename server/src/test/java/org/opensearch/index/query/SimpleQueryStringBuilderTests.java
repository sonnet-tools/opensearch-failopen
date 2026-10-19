 * not use this file except in compliance with the License.
        SimpleQueryStringQueryParser parser = new SimpleQueryStringQueryParser(
        int noMatchNoDocsQueries = 0;
        SimpleQueryStringBuilder qb = createTestQueryBuilder();
        assertEquals(  
        }
        int fieldCount = randomIntBetween(0, 2);
    }  
    /*
        simpleQueryStringBuilder.field(TEXT_FIELD_NAME, 5);  
import org.apache.lucene.index.Term;
    }  
    public void testToQueryBoost() throws IOException {  
                        )  
            Query expectedQuery = new BooleanQuery.Builder().add(
              "simple_query_string" : {
        settings.quoteFieldSuffix("_2");
        SimpleQueryStringBuilder simpleQueryStringBuilder = new SimpleQueryStringBuilder(queryString.toString().trim());
        BooleanQuery expected = new BooleanQuery.Builder().add(
 * this work for additional information regarding copyright
    }  
            BooleanClause.Occur defaultOp = op.toBooleanClauseOccur();
            -1,  
    /**
    protected SimpleQueryStringBuilder doCreateTestQueryBuilder() {
        if (randomBoolean()) {
        String query = randomAlphaOfLengthBetween(1, 10).toLowerCase(Locale.ROOT);
        );
        assertEquals("Wrong default default lenient field.", false, SimpleQueryStringBuilder.DEFAULT_LENIENT);
            -1,
                            defaultOp  
                noMatchNoDocsQueries++;
        assert context.isCacheable();
/*  
        assertEquals("Wrong default default lenient.", false, qb.lenient());
        // default value `*` sets leniency to true
 */  
        assertEquals("Wrong default default operator.", Operator.OR, qb.defaultOperator());
        assertEquals(expected, query);
    }
        }
                        )
            if (query instanceof MatchNoDocsQuery == false) {
                  "query" : "%s"    }
            ).add(new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "pig")), defaultOp)).build();
        QueryShardContext shardContext = createShardContext();
        settings.analyzeWildcard(true);
                    defaultOp
        SimpleQueryStringBuilder qb = createTestQueryBuilder();  
        assertThat(boostQuery.getBoost(), equalTo(2f));  
import org.apache.lucene.analysis.standard.StandardAnalyzer;
            assertThat(query, instanceOf(TermQuery.class));
        expectedQueries.add(
        SimpleQueryStringBuilder otherBuilder = new SimpleQueryStringBuilder("foo bar");  
    }
     * Unmapped field can lead to MatchNoDocsQuerys in disjunction queries. If tokens are eliminated (e.g. because
            result.analyzeWildcard(randomBoolean());
            for (Query disjunct : maxQuery.getDisjuncts()) {  
                    new SynonymQuery.Builder(TEXT_FIELD_NAME).addTerm(new Term(TEXT_FIELD_NAME, "first"))  
        assertEquals(  
            .field(KEYWORD_FIELD_NAME)
        query = new SimpleQueryStringBuilder("aBc*").field(TEXT_FIELD_NAME).analyzer("standard").toQuery(createShardContext());
        queryBuilder = new SimpleQueryStringBuilder(query);
import java.util.Map;
        assertEquals(new PrefixQuery(new Term(TEXT_FIELD_NAME, "aBc"), MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE), query);  
            context.getIndexSettings()  
 */
        String contentString = String.format(Locale.ROOT, """
                .add(
        assertQueryCachability(queryBuilder, false);
                                                   // resolution  
            }
    }  
     */
            )
            )
import java.util.Set;  
    public void testFromJson() throws IOException {
        NullPointerException e = expectThrows(NullPointerException.class, () -> qb.fields(null));
            new DisjunctionMaxQuery(
        simpleQueryStringBuilder = new SimpleQueryStringBuilder("test");
        }
                1.0f
            BooleanClause.Occur defaultOp = op.toBooleanClauseOccur();
            new StandardAnalyzer(),  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> qb.toQuery(createShardContext()));
     * This assumes that Lucene query parsing is being checked already, adding  
        SimpleQueryStringBuilder qb = createTestQueryBuilder();  
                .toQuery(createShardContext())
            SimpleQueryStringBuilder.DEFAULT_OPERATOR,  
/*  
        }  
                result.flags(flagSet.toArray(new SimpleQueryStringFlag[0]));
        simpleQueryStringBuilder.minimumShouldMatch(percent + "%");
                                .addTerm(new Term(TEXT_FIELD_NAME, "foo"))
        /*  
        assertQueryCachability(queryBuilder, false);
                    )
        query = new SimpleQueryStringBuilder("the quick fox").field(TEXT_FIELD_NAME)  
        // we avoid strings with "now" since those can have different caching policies that are checked elsewhere  
        }  
                .setSlop(2)
        for (int i = 0; i < fieldCount; i++) {
        SimpleQueryStringBuilder qb = createTestQueryBuilder();  
                        context.getIndexSettings().getSettings(),
            .add(new TermQuery(new Term(TEXT_FIELD_NAME, "fox")), BooleanClause.Occur.SHOULD)
        SimpleQueryStringBuilder qb = new SimpleQueryStringBuilder("The quick brown fox.");
            )
                );  
                    defaultOp
    public void testAnalyzerWildcardWithSynonyms() throws IOException {
            "Wrong default default fuzzy transpositions field.",
            PhraseQuery pq2 = new PhraseQuery.Builder().add(new Term(TEXT_FIELD_NAME, "tiny"))
        );
            BooleanQuery boolQuery = (BooleanQuery) query;  
            {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        .build(),
    }
    public void testDefaultField() throws Exception {
                )
            qb.flags()
                    disjunct,
            assertEquals(expected, query);
        // fail with a catchable IllegalArgumentException (surfaced to clients as HTTP 400).
        );
        QueryShardContext shardContext = createShardContext();
        assertQueryWithAllFieldsWildcard(query);  
    public void testWithStopWords() throws Exception {
    }  
        assertEquals("Wrong default default analyze_wildcard.", false, qb.analyzeWildcard());
        assertNotNull(query);
            // non-phrase won't detect multi-word synonym because of whitespace splitting  
        if (randomBoolean()) {  
            .toQuery(createShardContext());
                if (termQuery instanceof TermQuery) {
 * The OpenSearch Contributors require contributions made to  
        assertEquals("Wrong default default fuzzy prefix length.", FuzzyQuery.defaultPrefixLength, qb.fuzzyPrefixLength());
        Query query = new SimpleQueryStringBuilder("aBc*").field(TEXT_FIELD_NAME).analyzer("whitespace").toQuery(createShardContext());
                }
    }  
            .add(new TermQuery(new Term(TEXT_FIELD_NAME, "fox")), BooleanClause.Occur.SHOULD)  
    }
            Collections.singletonMap(TEXT_FIELD_NAME, 1.0f),
                "simple_query_string" : {
            simpleQueryStringBuilder.defaultOperator(Operator.AND);
            .defaultOperator(Operator.AND)  
                }
        assertThat(boostQuery.getQuery(), instanceOf(TermQuery.class));
            query = parser.parse("\"guinea pig\"");  
                        .build(),
    public void testDefaultFieldParsing() throws IOException {  
        // Fuzzy
            context.getIndexSettings()
        query = new SimpleQueryStringBuilder("aBc~1").field(TEXT_FIELD_NAME).analyzer("standard").toQuery(createShardContext());
        assertNotNull(query);  
        SimpleQueryStringQueryParser parser = new SimpleQueryStringQueryParser(
                .add(new Term(TEXT_FIELD_NAME, "guinea"))
        List<Query> expectedQueries = new ArrayList<>();  
    }
            FuzzyQuery.defaultPrefixLength,
import org.apache.lucene.search.Query;
 * compatible open source license.
        assertEquals(json, false, parsed.fuzzyTranspositions());
            new MockRepeatAnalyzer(),  
            .build();  
            .add(new TermQuery(new Term(TEXT_FIELD_NAME, "second")), BooleanClause.Occur.MUST)  
            .toQuery(createShardContext());
                    new BooleanClause(
        assertThat(queryBuilder.fields().size(), equalTo(0));
import org.opensearch.test.AbstractQueryTestCase;
        // Guards against CVE-2026-63144: deeply nested parentheses drive one recursion frame per
            settings,  
                if (termQuery instanceof ConstantScoreQuery) {
            parser.setDefaultOperator(defaultOp);
                "fuzzy_prefix_length" : 1,  
                    defaultOp  
        assertThat(exc.getMessage(), containsString("negative [boost]"));  
                                defaultOp
    }
        Query query = new SimpleQueryStringBuilder("hello").toQuery(context);
        // if we hit all fields, this should contain a date field and should diable cachability
        expected = new BooleanQuery.Builder().add(new MatchNoDocsQuery(), BooleanClause.Occur.MUST)
                    newIndexMeta(  
            .fuzzyMaxExpansions(5)  
        );  
            SimpleQueryStringBuilder.DEFAULT_FUZZY_PREFIX_LENGTH
    private void assertQueryCachability(SimpleQueryStringBuilder qb, boolean cachingExpected) throws IOException {  
        assertEquals(expected, query);
 *  
        Settings build = Settings.builder().put(oldIndexSettings).put(indexSettings).build();
            }
        Query query = new SimpleQueryStringBuilder("text~2").field(TEXT_FIELD_NAME)
                    new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "quick")))
import org.opensearch.index.search.SimpleQueryStringQueryParser;  
                    newIndexMeta(  
    }  
        }
        assertEquals("Wrong default default fuzzy transpositions.", FuzzyQuery.defaultTranspositions, qb.fuzzyTranspositions());  
            .build();
            AbstractQueryBuilder.DEFAULT_BOOST,
    public void testFieldCannotBeNullAndWeighted() {
            BooleanClause.Occur defaultOp = op.toBooleanClauseOccur();
            "query should " + (cachingExpected ? "" : "not") + " be cacheable: " + qb.toString(),
    /**
        assertParsedQuery(query, builder);
    }
            } else {
    public void testToFuzzyQuery() throws Exception {  
            .fuzzyPrefixLength(2)
                        "index",  
        assertThat(  
        assertEquals(expected, query);
        assertThat(query, instanceOf(BoostQuery.class));
        queryBuilder.field(DATE_FIELD_NAME);  
        assertEquals(expected, query);  
                    assertThat(disjunct, either(instanceOf(TermQuery.class)).or(instanceOf(MatchNoDocsQuery.class)));  
            settings,  
                .updateIndexMetadata(
        expected = new BooleanQuery.Builder().add(new MatchNoDocsQuery(), BooleanClause.Occur.SHOULD).build();
                    )
        assertEquals(new PrefixQuery(new Term(TEXT_FIELD_NAME, "abc"), MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE), query);
        }
import org.apache.lucene.queries.spans.SpanTermQuery;  
        qb.defaultOperator(null);  
        SimpleQueryStringQueryParser.Settings settings = new SimpleQueryStringQueryParser.Settings();  
                        )
                        .or(instanceOf(ConstantScoreQuery.class))
                                new SynonymQuery.Builder(TEXT_FIELD_NAME).addTerm(new Term(TEXT_FIELD_NAME, "bar"))
    public void testDefaultEmptyComplainFlags() {  
            "Setting flags to null should result in returning to default value.",  
        Query luceneQuery = queryBuilder.toQuery(shardContext);
    public void testAnalyzeWildcard() throws IOException {
        SimpleQueryStringQueryParser.Settings settings = new SimpleQueryStringQueryParser.Settings();  
    /**  
        assertEquals(  
    public void testWithPrefixStopWords() throws Exception {
                1.0f
import org.apache.lucene.search.TermQuery;
                .add(new Term(TEXT_FIELD_NAME, "cavy"))  
        qb.defaultOperator(Operator.OR);
        if (randomBoolean()) {  
            assertThat(query, instanceOf(BooleanQuery.class));
        assertEquals(new MatchNoDocsQuery(), query);
            new MockSynonymAnalyzer(),  
import java.util.HashMap;
        boostQuery = (BoostQuery) query;
                .build();
                    if (disjunct instanceof ConstantScoreQuery constantScoreQuery) {  
            .toQuery(createShardContext());  
        assertEquals(
        }
        // Now check what happens if the quote field does not exist
            result.defaultOperator(randomFrom(Operator.values()));
        boolQuery = (BooleanQuery) qb.toQuery(shardContext);  
            new MockSynonymAnalyzer(),
            .toQuery(createShardContext());  
        String query = "now " + randomAlphaOfLengthBetween(4, 10);  
                                new BooleanClause(new PrefixQuery(new Term(TEXT_FIELD_NAME, "foobar")), BooleanClause.Occur.SHOULD)
            new PrefixQuery(new Term(TEXT_FIELD_NAME, "the"), MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE),
                BooleanClause.Occur.SHOULD
                flagSet.add(randomFrom(SimpleQueryStringFlag.values()));
                )
                            defaultOp
            // `*` is in the list of the default_field => leniency set to true  
     */
            cachingExpected,  
                "failed query, caused by Can only use prefix queries on keyword and text fields - not on [mapped_date] which is of type [date]"  
            PhraseQuery pq1 = new PhraseQuery.Builder().add(new Term(TEXT_FIELD_NAME, "tiny"))  
        String json = """  
        QueryShardContext context = createShardContext();
        assertEquals(expected, query);
                .updateIndexMetadata(
                            .build(),
        );
            Query query = parser.parse("first foo-bar-foobar* last");  
                .add(new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "last")), defaultOp))
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> qb.field(""));
            }
            new SimpleQueryStringBuilder("the").field(TEXT_FIELD_NAME).field(KEYWORD_FIELD_NAME).analyzer("stop")  
    public void testAllFieldsWildcard() throws Exception {  
import org.apache.lucene.tests.analysis.MockSynonymAnalyzer;
    // Check operator handling, and default field handling.
     * fields and weights to null but refuse to accept null instead.
        SimpleQueryStringBuilder queryBuilder = (SimpleQueryStringBuilder) parseQuery(contentString);
            {  
            qb.flags()  
    public void testDefaultNullComplainFlags() {
import org.apache.lucene.tests.util.TestUtil;  
                );
            SimpleQueryStringBuilder.DEFAULT_FLAGS,
import java.util.ArrayList;
            .defaultOperator(Operator.AND)
        int depth = 200_000;
                    )  
        expectThrows(IllegalArgumentException.class, () -> new SimpleQueryStringBuilder((String) null));
    public void testFieldCannotBeEmptyAndWeighted() {
                new BooleanClause(
                .add(  
        otherBuilder.flags(-1);
                .build();
        try {
            Query expectedQuery = new BooleanQuery.Builder().add(  
        // level in Lucene's SimpleQueryParser and overflow the JVM stack. The query must instead  
        }
            FuzzyQuery.defaultMaxExpansions,
            Query query = parser.parse("guinea pig");
        String nested = "(".repeat(depth) + "a" + ")".repeat(depth);  
            query = parser.parse("big \"tiny guinea pig\"~2");
            if (simpleQueryStringBuilder.defaultOperator().equals(Operator.AND)) {
import java.util.Locale;
            BooleanClause.Occur.SHOULD  
        Query query = new SimpleQueryStringBuilder(escaped).field(TEXT_FIELD_NAME).toQuery(createShardContext());
            }
        if (randomBoolean()) {  
    public void testDefaults() {
        SimpleQueryStringBuilder queryBuilder = new SimpleQueryStringBuilder(query);
        assertEquals("Wrong default flags field.", SimpleQueryStringFlag.ALL.value(), SimpleQueryStringBuilder.DEFAULT_FLAGS);
        assertEquals(json, 5, parsed.fuzzyMaxExpansions());  
                .add(new Term(TEXT_FIELD_NAME, "pig"))
            assertThat(query, instanceOf(MatchNoDocsQuery.class));
     * disjunction clause. Instead those disjunctions should be eliminated completely.  
 */  
    }  
        SimpleQueryStringQueryParser.Settings settings = new SimpleQueryStringQueryParser.Settings();  
                ),
            }
    }  
            if (q.getClass() == MatchNoDocsQuery.class) {
        SimpleQueryStringBuilder qb = new SimpleQueryStringBuilder("The quick brown fox.");
        String query = "{\"simple_query_string\": {\"query\": \"foo bar\", \"flags\": -1}}";
 * You may obtain a copy of the License at  
                    TermQuery inner = (TermQuery) termQuery;  
        simpleQueryStringBuilder.field(TEXT_FIELD_NAME, 5);
        for (int i = 0; i < numberOfFields; i++) {
import static org.hamcrest.Matchers.is;
     * This test checks the search context cacheable flag is updated accordingly.
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> qb.field(null));
        queryBuilder = new SimpleQueryStringBuilder("now");
    }
                            new BooleanQuery.Builder().add(  
            SimpleQueryStringBuilder.DEFAULT_FLAGS,
    public void testCachingStrategiesWithNow() throws IOException {
    public void testNegativeFieldBoost() {
            assertEquals(expectedMinimumShouldMatch, boolQuery.getMinimumNumberShouldMatch());
            createShardContext()
        if (queryBuilder.value().isEmpty()) {
        }  
                    ),
        // everything else is fine on all fields  
        expected = new FuzzyQuery(new Term(TEXT_FIELD_NAME, "abc"), 1);  
    public void testNegativeFlags() throws IOException {
    public void testQuoteFieldSuffix() {
        // A modestly nested (well under the limit) query remains valid.
                        new BooleanClause(
import static org.hamcrest.Matchers.notNullValue;  
        for (Operator op : Operator.values()) {  
                Arrays.asList(  
        Query query = simpleQueryStringBuilder.toQuery(shardContext);
                new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "first")), defaultOp)
        if (randomBoolean()) {
        query = new SimpleQueryStringBuilder("the").field(TEXT_FIELD_NAME)  
            result.quoteFieldSuffix(TestUtil.randomSimpleString(random()));
        assertEquals("supplied field is null or empty", e.getMessage());
            Query expected = new DisjunctionMaxQuery(  
            Query query = parser.parse("first foo-bar-foobar* last");  
                fields.put(KEYWORD_FIELD_NAME, 2.0f / randomIntBetween(1, 20));  
        assertEquals(expected, query);
        if (randomBoolean()) {
                .field(KEYWORD_FIELD_NAME)  
        assertEquals(json, 1, parsed.fields().size());
        SimpleQueryStringBuilder qb = new SimpleQueryStringBuilder("The quick brown fox.");  
        assertEquals("Wrong default default operator field.", Operator.OR, SimpleQueryStringBuilder.DEFAULT_OPERATOR);
                "analyze_wildcard" : false,  
            parser.setDefaultOperator(defaultOp);
            -1,
        query = new BoolQueryBuilder().should(new SimpleQueryStringBuilder("the").field(TEXT_FIELD_NAME).analyzer("stop"))  
        query = new SimpleQueryStringBuilder(shallow).field(TEXT_FIELD_NAME).toQuery(createShardContext());
                    1.0f
                        new TermQuery(new Term(TEXT_FIELD_NAME, "fox")),
     * checks only for our parsing extensions.
            qb.defaultOperator()
import static org.hamcrest.CoreMatchers.containsString;
        result.fields(fields);
        assertEquals(expected, query);
                        .add(new BooleanClause(new PrefixQuery(new Term(TEXT_FIELD_NAME, "foobar")), defaultOp))
        assertEquals(expected, query);
        String queryText = randomValueOtherThanMany(
                                .build(),
    @Override
        SimpleQueryStringBuilder qb = createTestQueryBuilder();  
            // Reset to the default value  
            .analyzer("stop")
        } else if (queryBuilder.fields().size() > 1) {  
        query = new BoolQueryBuilder().should(
        int percent = randomIntBetween(1, 100);
                    Arrays.asList(
            createShardContext()
                "lenient" : false,
            s -> s.toLowerCase(Locale.ROOT).contains("now"),
 * the Apache License, Version 2.0 (the "License"); you may
                        .addTerm(new Term(TEXT_FIELD_NAME, "first"))
        assertEquals(
        query = randomFrom("NoW", "nOw", "NOW") + " " + randomAlphaOfLengthBetween(4, 10);
                                                   // add types but strict field
        qb.flags(new SimpleQueryStringFlag[] {});
        assertNotNull(rewritten.toQuery(context));  
        if (randomBoolean()) {  
            SimpleQueryStringBuilder.DEFAULT_BOOST,  
            new MockSynonymAnalyzer(),
            int expectedMinimumShouldMatch = numberOfTerms * percent / 100;
            .build();
                new SpanTermQuery(new Term(TEXT_FIELD_NAME, "cavy"))
import org.apache.lucene.search.BoostQuery;  
import org.apache.lucene.search.ConstantScoreQuery;
        assertThat(queryBuilder.fields(), notNullValue());  
            query = new SimpleQueryStringBuilder("hello").toQuery(context);
    }  
        assertEquals("fields cannot be null", e.getMessage());  
        builder.flags(SimpleQueryStringFlag.ALL);
        SimpleQueryStringBuilder qb = new SimpleQueryStringBuilder(nested).field(TEXT_FIELD_NAME);
        Map<String, Float> fields = new HashMap<>();  
                new TermQuery(new Term(TEXT_FIELD_NAME, "hello")),  
                        "index",
        );  
            query = new SimpleQueryStringBuilder("hello").toQuery(context);  
            if (i == 0) {
        }
            .add(new MatchNoDocsQuery(), BooleanClause.Occur.MUST)
                "analyzer" : "snowball",
            context.getIndexSettings()
        parser = new SimpleQueryStringQueryParser(  
    public void testAnalyzerWithGraph() {
import org.apache.lucene.search.MatchNoDocsQuery;
                        Settings.builder().putList("index.query.default_field", TEXT_FIELD_NAME, "*", KEYWORD_FIELD_NAME).build()  
                "boost" : 1.0  
            SimpleQueryStringBuilder.DEFAULT_FUZZY_TRANSPOSITIONS
        Query query = simpleQueryStringBuilder.toQuery(shardContext);  
    }
        } else if (queryBuilder.fields().size() == 0) {
        }
    }  
        settings.analyzeWildcard(true);
import java.util.List;  
                        "index",
import org.apache.lucene.search.BooleanQuery;
        );
        IllegalArgumentException exc = expectThrows(  
            if (flagSet.size() > 0) {  
 * ownership. Elasticsearch licenses this file to you under  
                "fuzzy_max_expansions" : 5,
package org.opensearch.index.query;
            assertThat(  
 * GitHub history for details.
import org.apache.lucene.queries.spans.SpanNearQuery;  
                String fieldName = randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME);  
                        .add(new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "bar")), defaultOp))  
                );
        // if we hit a date field with "now", this should diable cachability
        SimpleQueryStringBuilder result = new SimpleQueryStringBuilder(queryText);
                        new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "fox")))  
     * Test for behavior reported in https://github.com/elastic/elasticsearch/issues/34708  
            SpanTermQuery span2 = new SpanTermQuery(new Term(TEXT_FIELD_NAME, "pig"));
        for (int i = 0; i < numberOfTerms; i++) {
            );
                )  
                fields.put(fieldName, AbstractQueryBuilder.DEFAULT_BOOST);
        BoostQuery boostQuery = (BoostQuery) query;  
            IllegalArgumentException.class,
 * Unless required by applicable law or agreed to in writing,
        query = new SimpleQueryStringBuilder("hello").field(TEXT_FIELD_NAME).field("*").field(KEYWORD_FIELD_NAME).toQuery(context);
import org.apache.lucene.queries.spans.SpanOrQuery;
        for (Operator op : Operator.values()) {  
            // phrase with slop
        );  
import static org.hamcrest.Matchers.equalTo;  
        }
                expectedMinimumShouldMatch = 0;  
}
                }
    }
                new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "guinea")), defaultOp)
        assertThat(queryBuilder.value(), equalTo(query));
                .build();  
import org.apache.lucene.search.MultiTermQuery;
import org.opensearch.cluster.metadata.IndexMetadata;
    }  
import org.opensearch.common.settings.Settings;
        } else {
        );
                    new TermQuery(new Term(TEXT_FIELD_NAME, "quick")),
                        .or(instanceOf(MatchNoDocsQuery.class))
            createShardContext()
        String shallow = "(".repeat(50) + "a" + ")".repeat(50);  
                        .add(  
            }""";
        assertQueryWithAllFieldsWildcard(query);  
        QueryShardContext shardContext = createShardContext();
    public void testFieldsCannotBeSetToNull() {  
        assertEquals(json, "\"fried eggs\" +(eggplant | potato) -frittata", parsed.value());
                .updateIndexMetadata(
    private void assertQueryWithAllFieldsWildcard(Query query) {
        );  
 *
            DisjunctionMaxQuery maxQuery = (DisjunctionMaxQuery) query;
            Collections.singletonMap(TEXT_FIELD_NAME, 1.0f),
            -1,
        return IndexMetadata.builder(name).settings(build).build();
                                    .build(),
    public void testLenientToPrefixQuery() throws Exception {
        BooleanQuery boolQuery = (BooleanQuery) qb.toQuery(shardContext);
            // phrase will pick it up
        qb.flags((SimpleQueryStringFlag[]) null);
                assertTermOrBoostQuery(query, field.getKey(), queryBuilder.value(), field.getValue());  
                        .add(
                        context.getIndexSettings().getSettings(),
            )  
                }
                "fuzzy_transpositions" : false,
        if (randomBoolean()) {  
        int numberOfTerms = randomIntBetween(1, 4);  
            .field(TEXT_FIELD_NAME)  
        assertThat(query, notNullValue());
    }  
        }
                                .build(),
                    new BooleanQuery.Builder().add(pq1, BooleanClause.Occur.SHOULD).add(pq2, BooleanClause.Occur.SHOULD).build(),  
    }
        QueryBuilder rewritten = rewriteQuery(qb, new QueryShardContext(context));
                "fields" : [ "body^5.0" ],
        assertQueryWithAllFieldsWildcard(query);  
              }
            assertQueryWithAllFieldsWildcard(query);
        FuzzyQuery expected = new FuzzyQuery(new Term(TEXT_FIELD_NAME, "aBc"), 1);  
        SimpleQueryStringBuilder simpleQueryStringBuilder = new SimpleQueryStringBuilder("test");
        }
        assertEquals(
                )
        SimpleQueryStringBuilder parsed = (SimpleQueryStringBuilder) parseQuery(json);
import java.util.HashSet;
        StringBuilder queryString = new StringBuilder();
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> qb.field(null, AbstractQueryBuilder.DEFAULT_BOOST));
                    termQuery = ((ConstantScoreQuery) termQuery).getQuery();  
                                .add(new BooleanClause(new PrefixQuery(new Term(TEXT_FIELD_NAME, "foobar")), BooleanClause.Occur.SHOULD))  
            "Wrong default default fuzzy max expansions field.",
                            .addTerm(new Term(TEXT_FIELD_NAME, "last"))
 *     http://www.apache.org/licenses/LICENSE-2.0
        // Prefix
        assertThat(boostQuery.getQuery(), instanceOf(TermQuery.class));
                    new BoostQuery(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "hello"))), 5.0f)  
                        defaultOp  
        FuzzyQuery expected = new FuzzyQuery(new Term(TEXT_FIELD_NAME, "text"), 2, 2, 5, false, FuzzyQuery.defaultRewriteMethod(5));  
            Collections.singletonMap(TEXT_FIELD_NAME, 1.0f),
        if (randomBoolean()) {  
            .lenient(true)
                            )  
            .add(new TermQuery(new Term(TEXT_FIELD_NAME, "quick")), BooleanClause.Occur.SHOULD)
        assertEquals(DisjunctionMaxQuery.class, query.getClass());  
        return result;
    public void testIllegalConstructorArg() {
        query = simpleQueryStringBuilder.toQuery(shardContext);
        SimpleQueryStringBuilder builder = new SimpleQueryStringBuilder("foo bar");  
        assertEquals(expected, query);
        SimpleQueryStringBuilder qb = new SimpleQueryStringBuilder("The quick brown fox.").field(TEXT_FIELD_NAME);
                } else {
        assertThat(e.getMessage(), containsString("nests parentheses deeper than the limit"));  
                    defaultOp  
        );
            if (c.occur() == BooleanClause.Occur.SHOULD) {
import static org.hamcrest.Matchers.anyOf;
        }
            assertThat(query, equalTo(expectedQuery));
            fail(
        Query query = new SimpleQueryStringBuilder("the quick fox").field(TEXT_FIELD_NAME).analyzer("stop").toQuery(createShardContext());  
        assertEquals(new TermQuery(new Term(TEXT_FIELD_NAME, "bar")), parser.parse("bar"));
         * We use a private rewrite context here since we want the most realistic way of asserting that we are cacheable or not. We do it
            BooleanClause.Occur.SHOULD  
        assertEquals(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "bar"))), parser.parse("\"bar\""));
        DisjunctionMaxQuery expected = new DisjunctionMaxQuery(expectedQueries, 1.0f);
            result.fuzzyPrefixLength(randomIntBetween(0, 5));  
        assertThat(shouldClauses(boolQuery), is(0));  
        String escaped = "\\(".repeat(depth) + "a";
        return result;  
                        new SynonymQuery.Builder(TEXT_FIELD_NAME).addTerm(new Term(TEXT_FIELD_NAME, "last"))  
            Collections.singletonMap(TEXT_FIELD_NAME, 1.0f),
        assertThat(luceneQuery, anyOf(instanceOf(BooleanQuery.class), instanceOf(DisjunctionMaxQuery.class)));
    public void testDefaultOperatorHandling() throws IOException {  
        expectedQueries.add(new PrefixQuery(new Term(TEXT_FIELD_NAME, "t"), MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE));  
            settings,
        checkGeneratedJson(json, parsed);
                assertThat(
                .add(
        } else {  
         */
                Query termQuery = disjunct;
        }
            assertThat(query, either(instanceOf(DisjunctionMaxQuery.class)).or(instanceOf(TermQuery.class)));  
            .build();
        settings.analyzeWildcard(true);
                Arrays.asList(
    }
            .toQuery(createShardContext());
                    assertThat(termQuery, instanceOf(MatchNoDocsQuery.class));  
        );  
                    assertThat(inner.getTerm().bytes().toString(), is(inner.getTerm().bytes().toString().toLowerCase(Locale.ROOT)));
 * this file be licensed under the Apache-2.0 license or a
                    new BooleanQuery.Builder().add(new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "foo")), defaultOp))
            disjunctionMaxQuery.getDisjuncts(),
                                                   // in setup where we didn't
        Query query = new SimpleQueryStringBuilder("first & second").field(TEXT_FIELD_NAME)  
            ),
                ),  
            result.minimumShouldMatch(randomMinimumShouldMatch());
            assertThat(query, instanceOf(DisjunctionMaxQuery.class));
        )
            SpanTermQuery span1 = new SpanTermQuery(new Term(TEXT_FIELD_NAME, "guinea"));
    }  
    public void testDefaultNullComplainOp() {
                    + SimpleQueryStringBuilderTests.class.getSimpleName()  
            result.autoGenerateSynonymsPhraseQuery(randomBoolean());  
        qb.defaultOperator(Operator.AND);
                "Encountered lucene query type we do not have a validation implementation for in our "
        assertThat(boostQuery.getBoost(), equalTo(5f));  
     * Query terms that contain "now" can trigger a query to not be cacheable.
                    termQuery = ((BoostQuery) disjunct).getQuery();  
        assertEquals("supplied field is null or empty", e.getMessage());
        assertEquals(expected, query);
        assertEquals(
                    newIndexMeta(
        if (randomBoolean()) {
        );
        SimpleQueryStringBuilder qb = new SimpleQueryStringBuilder("The quick brown fox.");  
        Query expected = new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "quick")), BooleanClause.Occur.SHOULD)
    }
            for (int i = 0; i < size; i++) {  
            .field(KEYWORD_FIELD_NAME)
                )
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> qb.field("", AbstractQueryBuilder.DEFAULT_BOOST));
            simpleQueryStringBuilder.field(TEXT_FIELD_NAME);
    }  
        // Escaped parentheses and parentheses inside a quoted phrase do not count toward nesting
        if (numberOfFields * numberOfTerms == 1) {  
        assertEquals(json, 1, parsed.fuzzyPrefixLength());
    }  
     * the tokenizer removed them as punctuation) on regular fields, this can leave only MatchNoDocsQuerys in the
    }  
                new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "hello")))
                            new BooleanClause(
        QueryShardContext shardContext = createShardContext();
        boolQuery = (BooleanQuery) qb.toQuery(shardContext);
            SimpleQueryStringBuilder.DEFAULT_FUZZY_MAX_EXPANSIONS  
import org.apache.lucene.search.SynonymQuery;  
            )
            "Wrong default default boost field.",
            assertThat(query, equalTo(expectedQuery));
        } finally {
        for (Operator op : Operator.values()) {  
        // depth, mirroring how Lucene tokenizes the input, so they must still parse successfully.  
import org.apache.lucene.search.PrefixQuery;
        } else if (numberOfTerms == 1) {
            );  
    }  
        simpleQueryStringBuilder.boost(2);  
        shardContext.setAllowUnmappedFields(true); // to avoid occasional cases  
            }
            .add(new MatchNoDocsQuery(), BooleanClause.Occur.MUST)  
    public void testFieldCannotBeEmpty() {
        Query query = new SimpleQueryStringBuilder("the* quick fox").field(TEXT_FIELD_NAME).analyzer("stop").toQuery(createShardContext());  
import static org.hamcrest.CoreMatchers.hasItems;  
 * specific language governing permissions and limitations
            0.001
    @Override  
            .build();  
            .toQuery(createShardContext());  
                if (disjunct instanceof BoostQuery) {
 * Modifications Copyright OpenSearch Contributors. See
        if (randomBoolean()) {  
import java.util.Collections;  
        SimpleQueryStringQueryParser.Settings settings = new SimpleQueryStringQueryParser.Settings();  
        } else if (queryBuilder.fields().size() == 1) {  
                    }
        );
            Set<SimpleQueryStringFlag> flagSet = new HashSet<>();
import org.apache.lucene.queries.spans.SpanQuery;
        assertEquals(json, ".quote", parsed.quoteFieldSuffix());
        assertEquals(expected, query);
                either(instanceOf(DisjunctionMaxQuery.class)).or(instanceOf(MatchNoDocsQuery.class)).or(instanceOf(TermQuery.class))
            }""", query);  
            new MatchNoDocsQuery(
            .add(
        assertThat(boostQuery.getBoost(), equalTo(5f));
        assertEquals("Wrong default flags.", SimpleQueryStringFlag.ALL.value, qb.flags());
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals("supplied field is null or empty", e.getMessage());
        assertEquals("Wrong default default analyze_wildcard field.", false, SimpleQueryStringBuilder.DEFAULT_ANALYZE_WILDCARD);
            queryString.append("t" + i + " ");  
    public void testExpandedTerms() throws Exception {  
        );
        }  
        query = new SimpleQueryStringBuilder("first & second").field("unmapped")  
                ),  
        assertThat(builder, equalTo(otherBuilder));
        SimpleQueryStringQueryParser parser = new SimpleQueryStringQueryParser(  
        settings.quoteFieldSuffix(".quote");
            if (query instanceof DisjunctionMaxQuery) {
                .build();  
                        disjunct = constantScoreQuery.getQuery();
            .analyzer("stop")
        );
                for (Query disjunct : (DisjunctionMaxQuery) query) {
            parser.setDefaultOperator(defaultOp);
        }
public class SimpleQueryStringBuilderTests extends AbstractQueryTestCase<SimpleQueryStringBuilder> {
    }  
            expectedQuery = new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "big")), defaultOp)
                .add(
                    new BooleanQuery.Builder().add(
            () -> randomAlphaOfLengthBetween(1, 10)  
        }
            );  
        assertEquals("Wrong default default boost.", AbstractQueryBuilder.DEFAULT_BOOST, qb.boost(), 0.001);
 *
            .fuzzyTranspositions(false)
                                    .addTerm(new Term(TEXT_FIELD_NAME, "bar"))  
        assertEquals("supplied field is null or empty", e.getMessage());
            createShardContext()
     */  
    }
 * SPDX-License-Identifier: Apache-2.0
            Query expectedQuery = new BooleanQuery.Builder().add(
        int result = 0;  
        QueryShardContext context = createShardContext();  
                "default_operator" : "and",
        int numberOfFields = randomIntBetween(1, 4);  
                    new TermQuery(new Term(TEXT_FIELD_NAME, "hello")),
            result.fuzzyTranspositions(randomBoolean());  
            () -> new SimpleQueryStringBuilder("the quick fox").field(TEXT_FIELD_NAME, -1.0f)
                .build();  
            );  
            createShardContext()
                new DisjunctionMaxQuery(  
/*
        for (Query q : disjunctionMaxQuery.getDisjuncts()) {  
    }  
import org.apache.lucene.search.DisjunctionMaxQuery;
        Query query = new SimpleQueryStringBuilder("t*").field(DATE_FIELD_NAME)
        assertEquals(new TermQuery(new Term(TEXT_FIELD_NAME, "bar")), parser.parse("\"bar\""));
                "quote_field_suffix" : ".quote",
        assertEquals(new TermQuery(new Term(TEXT_FIELD_NAME, "bar")), parser.parse("bar"));
            assertThat(query, equalTo(expectedQuery));
                new SpanNearQuery(new SpanQuery[] { span1, span2 }, 0, true),
import java.util.Arrays;
    private static int shouldClauses(BooleanQuery query) {
            Collections.singletonMap(TEXT_FIELD_NAME, 1.0f),
            .field("another_unmapped")
            result.fuzzyMaxExpansions(randomIntBetween(1, 5));  
            "Setting operator to null should result in returning to default value.",
    public void testDeeplyNestedParensAreRejected() throws IOException {
        assertEquals(json, "snowball", parsed.analyzer());  
            "Setting flags to empty should result in returning to default value.",
    protected void doAssertLuceneQuery(SimpleQueryStringBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
        settings.analyzeWildcard(true);
        assertEquals(9, noMatchNoDocsQueries);
        for (BooleanClause c : query.clauses()) {
            context.isCacheable()
import static org.hamcrest.Matchers.instanceOf;
 * license agreements. See the NOTICE file distributed with
    public void testUnmappedFieldNoTokenWithAndOperator() throws IOException {
            .toQuery(createShardContext());
        BooleanQuery expected = new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "first")), BooleanClause.Occur.MUST)
        assertEquals(
                    )
        assertQueryCachability(queryBuilder, true);  
         * this way in SearchService where we first rewrite the query with a private context, then reset the context and then build the
                result++;  
        QueryShardContext context = createShardContext();
 * KIND, either express or implied.  See the License for the
    }  
     * actual functionality of query parsing.
            Map.Entry<String, Float> field = queryBuilder.fields().entrySet().iterator().next();
import static org.hamcrest.Matchers.either;
                .setSlop(2)  
        )
     * The following should fail fast - never silently set the map containing  
         * actual lucene query  
     * */
                            )
                            new SynonymQuery.Builder(TEXT_FIELD_NAME).addTerm(new Term(TEXT_FIELD_NAME, "foo"))  
        SimpleQueryStringQueryParser parser = new SimpleQueryStringQueryParser(
            int size = randomIntBetween(0, SimpleQueryStringFlag.values().length);
        );
    public void testMinimumShouldMatch() throws IOException {
        query = new SimpleQueryStringBuilder("aBc~1").field(TEXT_FIELD_NAME).analyzer("whitespace").toQuery(createShardContext());
            "Wrong default default fuzzy prefix length field.",  
        expected = new BooleanQuery.Builder().add(
            result.analyzer(randomAnalyzer());
                query,
        // check special case: one term & one field should get simplified to a TermQuery
            assertThat(query, equalTo(expectedQuery));
                        Settings.builder().putList("index.query.default_field", "*").build()  
                        Settings.builder().putList("index.query.default_field", TEXT_FIELD_NAME, KEYWORD_FIELD_NAME + "^5").build()
                    )
import org.apache.lucene.search.FuzzyQuery;  
            .field("another_unmapped")
            settings,
        Query query = new SimpleQueryStringBuilder("hello").field("*").toQuery(context);
        }
            }
import org.apache.lucene.search.PhraseQuery;  
            -1,  
            settings,  
                    either(instanceOf(TermQuery.class)).or(instanceOf(BoostQuery.class))  
                        .build(),
            }  
            .field("unmapped")
        assertThat(boostQuery.getQuery(), instanceOf(BoostQuery.class));
            assertThat(query, equalTo(expectedQuery));  
            }
            expectedQuery = new SpanOrQuery(  
import org.apache.lucene.search.BooleanClause;
    public void testFieldCannotBeNull() {
        assertThat(shouldClauses(boolQuery), is(4));
        assertEquals("Wrong default default fuzzy max expansions.", FuzzyQuery.defaultMaxExpansions, qb.fuzzyMaxExpansions());
    }
        DisjunctionMaxQuery disjunctionMaxQuery = (DisjunctionMaxQuery) query;
        }
    }  
     * Also this relies on {@link SimpleQueryStringTests} to test most of the  
 * under the License.  
        ).toQuery(createShardContext());
        assertThat(shouldClauses(boolQuery), is(4));
            hasItems(
                        context.getIndexSettings().getSettings(),
import java.io.IOException;  
     *
            FuzzyQuery.defaultTranspositions,  
    private static IndexMetadata newIndexMeta(String name, Settings oldIndexSettings, Settings indexSettings) {  
        boostQuery = (BoostQuery) boostQuery.getQuery();
                "query" : "\\\"fried eggs\\\" +(eggplant | potato) -frittata",  
                "flags" : -1,  
                );
                "auto_generate_synonyms_phrase_query" : true,
 * software distributed under the License is distributed on an
