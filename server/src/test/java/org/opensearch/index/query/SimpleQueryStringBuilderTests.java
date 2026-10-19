        );
import org.apache.lucene.search.BooleanClause;
            settings,
                                    .addTerm(new Term(TEXT_FIELD_NAME, "bar"))
            .toQuery(createShardContext());
                                .build(),
                        Settings.builder().putList("index.query.default_field", TEXT_FIELD_NAME, KEYWORD_FIELD_NAME + "^5").build()
            .fuzzyTranspositions(false)
        );
    }
    }
            if (flagSet.size() > 0) {
            new MockSynonymAnalyzer(),
        assertEquals(expected, query);
            .add(new MatchNoDocsQuery(), BooleanClause.Occur.MUST)
            qb.flags()
            }
        if (randomBoolean()) {
                    1.0f
        Query query = simpleQueryStringBuilder.toQuery(shardContext);
            assertThat(query, equalTo(expectedQuery));
            .build();
        assertEquals(json, "snowball", parsed.analyzer());
     */
            "Wrong default default fuzzy prefix length field.",
 * under the License.
        // depth, mirroring how Lucene tokenizes the input, so they must still parse successfully.
import static org.hamcrest.CoreMatchers.hasItems;
                .add(new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "last")), defaultOp))
                    )
                    newIndexMeta(
        assertThat(boostQuery.getBoost(), equalTo(5f));
import static org.hamcrest.Matchers.instanceOf;
                new SpanTermQuery(new Term(TEXT_FIELD_NAME, "cavy"))
            result.minimumShouldMatch(randomMinimumShouldMatch());
        DisjunctionMaxQuery expected = new DisjunctionMaxQuery(expectedQueries, 1.0f);
                .add(
            assertThat(query, equalTo(expectedQuery));
            result.defaultOperator(randomFrom(Operator.values()));
                        .or(instanceOf(MatchNoDocsQuery.class))
        assertEquals(new TermQuery(new Term(TEXT_FIELD_NAME, "bar")), parser.parse("bar"));
        SimpleQueryStringQueryParser.Settings settings = new SimpleQueryStringQueryParser.Settings();
        String escaped = "\\(".repeat(depth) + "a";
            assertThat(query, instanceOf(MatchNoDocsQuery.class));
    // Check operator handling, and default field handling.
        int result = 0;
        expected = new BooleanQuery.Builder().add(new MatchNoDocsQuery(), BooleanClause.Occur.MUST)
                "fuzzy_max_expansions" : 5,
        SimpleQueryStringBuilder qb = createTestQueryBuilder();
                .setSlop(2)
        assertThat(boostQuery.getBoost(), equalTo(5f));
        assertEquals("Wrong default flags field.", SimpleQueryStringFlag.ALL.value(), SimpleQueryStringBuilder.DEFAULT_FLAGS);
import org.opensearch.test.AbstractQueryTestCase;
                "fuzzy_transpositions" : false,
                "analyzer" : "snowball",
            )
                .toQuery(createShardContext())
                }
            .defaultOperator(Operator.AND)
        );
     * checks only for our parsing extensions.
        } else if (queryBuilder.fields().size() == 1) {
            for (int i = 0; i < size; i++) {
            PhraseQuery pq1 = new PhraseQuery.Builder().add(new Term(TEXT_FIELD_NAME, "tiny"))
        parser = new SimpleQueryStringQueryParser(
        try {
        assertEquals(
        expected = new FuzzyQuery(new Term(TEXT_FIELD_NAME, "abc"), 1);
            context.isCacheable()
            }
                        .build(),
            int expectedMinimumShouldMatch = numberOfTerms * percent / 100;
        Query query = new SimpleQueryStringBuilder("aBc*").field(TEXT_FIELD_NAME).analyzer("whitespace").toQuery(createShardContext());
                    new BooleanQuery.Builder().add(pq1, BooleanClause.Occur.SHOULD).add(pq2, BooleanClause.Occur.SHOULD).build(),
        QueryShardContext shardContext = createShardContext();
        // if we hit all fields, this should contain a date field and should diable cachability
            new PrefixQuery(new Term(TEXT_FIELD_NAME, "the"), MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE),
                  "query" : "%s"    }
                                .addTerm(new Term(TEXT_FIELD_NAME, "foo"))
import static org.hamcrest.Matchers.notNullValue;
                "fields" : [ "body^5.0" ],
        SimpleQueryStringBuilder qb = createTestQueryBuilder();
        SimpleQueryStringBuilder queryBuilder = new SimpleQueryStringBuilder(query);
            new MatchNoDocsQuery(
            .add(new TermQuery(new Term(TEXT_FIELD_NAME, "fox")), BooleanClause.Occur.SHOULD)
        assertEquals("Wrong default default operator.", Operator.OR, qb.defaultOperator());
        assertEquals(expected, query);
        QueryShardContext context = createShardContext();
                result++;
            new MockRepeatAnalyzer(),
        assertEquals("fields cannot be null", e.getMessage());
        SimpleQueryStringBuilder result = new SimpleQueryStringBuilder(queryText);
import org.apache.lucene.search.ConstantScoreQuery;
            } else {
        SimpleQueryStringBuilder qb = new SimpleQueryStringBuilder("The quick brown fox.");
        assertEquals(new TermQuery(new Term(TEXT_FIELD_NAME, "bar")), parser.parse("\"bar\""));
        boolQuery = (BooleanQuery) qb.toQuery(shardContext);
        );
            Query expectedQuery = new BooleanQuery.Builder().add(
                        new SynonymQuery.Builder(TEXT_FIELD_NAME).addTerm(new Term(TEXT_FIELD_NAME, "last"))
                                                   // resolution
/*
    @Override
    public void testDeeplyNestedParensAreRejected() throws IOException {
        assertEquals("Wrong default flags.", SimpleQueryStringFlag.ALL.value, qb.flags());
                "simple_query_string" : {
                            )
        BooleanQuery expected = new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "first")), BooleanClause.Occur.MUST)
import org.opensearch.common.settings.Settings;
        SimpleQueryStringQueryParser parser = new SimpleQueryStringQueryParser(
                ),
     */
        // Guards against CVE-2026-63144: deeply nested parentheses drive one recursion frame per
                        new TermQuery(new Term(TEXT_FIELD_NAME, "fox")),
    public void testDefaultOperatorHandling() throws IOException {
import org.opensearch.cluster.metadata.IndexMetadata;
    }
        SimpleQueryStringBuilder otherBuilder = new SimpleQueryStringBuilder("foo bar");
        assertThat(query, instanceOf(BoostQuery.class));
            }""", query);
        settings.analyzeWildcard(true);
            settings,
 * license agreements. See the NOTICE file distributed with
        BooleanQuery expected = new BooleanQuery.Builder().add(
 * SPDX-License-Identifier: Apache-2.0
        assert context.isCacheable();
        }
        expectThrows(IllegalArgumentException.class, () -> new SimpleQueryStringBuilder((String) null));
/*
            )
        }
        assertEquals(new PrefixQuery(new Term(TEXT_FIELD_NAME, "aBc"), MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE), query);
            .toQuery(createShardContext());
 * software distributed under the License is distributed on an
import org.apache.lucene.search.BooleanQuery;
            .field(KEYWORD_FIELD_NAME)
            Map.Entry<String, Float> field = queryBuilder.fields().entrySet().iterator().next();
                                .add(new BooleanClause(new PrefixQuery(new Term(TEXT_FIELD_NAME, "foobar")), BooleanClause.Occur.SHOULD))
                "fuzzy_prefix_length" : 1,
            assertThat(query, equalTo(expectedQuery));
        if (randomBoolean()) {
            result.fuzzyTranspositions(randomBoolean());
import org.apache.lucene.index.Term;
        assertEquals(
                                new BooleanClause(new PrefixQuery(new Term(TEXT_FIELD_NAME, "foobar")), BooleanClause.Occur.SHOULD)
            Query expectedQuery = new BooleanQuery.Builder().add(
    public void testQuoteFieldSuffix() {
                    new TermQuery(new Term(TEXT_FIELD_NAME, "hello")),
        QueryShardContext shardContext = createShardContext();
                BooleanClause.Occur.SHOULD
                "lenient" : false,
    protected SimpleQueryStringBuilder doCreateTestQueryBuilder() {
import org.apache.lucene.analysis.standard.StandardAnalyzer;
        assertThat(queryBuilder.value(), equalTo(query));
        assertEquals(
            result.fuzzyMaxExpansions(randomIntBetween(1, 5));
        SimpleQueryStringBuilder simpleQueryStringBuilder = new SimpleQueryStringBuilder(queryString.toString().trim());
        // check special case: one term & one field should get simplified to a TermQuery
        assertEquals(new TermQuery(new Term(TEXT_FIELD_NAME, "bar")), parser.parse("bar"));
import org.apache.lucene.search.Query;
}
        assertEquals(new MatchNoDocsQuery(), query);
        String query = "{\"simple_query_string\": {\"query\": \"foo bar\", \"flags\": -1}}";
        Query query = new SimpleQueryStringBuilder("hello").field("*").toQuery(context);
    }
import java.util.HashMap;
                        context.getIndexSettings().getSettings(),
                "flags" : -1,
            SimpleQueryStringBuilder.DEFAULT_FUZZY_TRANSPOSITIONS
            // non-phrase won't detect multi-word synonym because of whitespace splitting
 * Licensed to Elasticsearch under one or more contributor
                    ),
            .fuzzyPrefixLength(2)
import org.apache.lucene.queries.spans.SpanNearQuery;
            assertEquals(expectedMinimumShouldMatch, boolQuery.getMinimumNumberShouldMatch());
            fail(
                    + SimpleQueryStringBuilderTests.class.getSimpleName()
        settings.analyzeWildcard(true);
 */
                            new SynonymQuery.Builder(TEXT_FIELD_NAME).addTerm(new Term(TEXT_FIELD_NAME, "foo"))
            assertThat(query, equalTo(expectedQuery));
                        "index",
                        Settings.builder().putList("index.query.default_field", TEXT_FIELD_NAME, "*", KEYWORD_FIELD_NAME).build()
                        .add(new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "bar")), defaultOp))
        for (Operator op : Operator.values()) {
        }
        assertThat(queryBuilder.fields().size(), equalTo(0));
                    }
            disjunctionMaxQuery.getDisjuncts(),
        Settings build = Settings.builder().put(oldIndexSettings).put(indexSettings).build();
            BooleanClause.Occur.SHOULD
            );
    }
 * Unless required by applicable law or agreed to in writing,
        SimpleQueryStringBuilder qb = createTestQueryBuilder();
     * the tokenizer removed them as punctuation) on regular fields, this can leave only MatchNoDocsQuerys in the
        // A modestly nested (well under the limit) query remains valid.
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(expected, query);
        assertEquals("supplied field is null or empty", e.getMessage());
        ).toQuery(createShardContext());
            Collections.singletonMap(TEXT_FIELD_NAME, 1.0f),
                            .addTerm(new Term(TEXT_FIELD_NAME, "last"))
import java.util.Map;
            assertThat(query, either(instanceOf(DisjunctionMaxQuery.class)).or(instanceOf(TermQuery.class)));
        qb.flags((SimpleQueryStringFlag[]) null);
        SimpleQueryStringBuilder qb = createTestQueryBuilder();
                        "index",
        SimpleQueryStringQueryParser.Settings settings = new SimpleQueryStringQueryParser.Settings();
                        .build(),
     * actual functionality of query parsing.
        boolQuery = (BooleanQuery) qb.toQuery(shardContext);
                flagSet.add(randomFrom(SimpleQueryStringFlag.values()));
                        .add(
            BooleanClause.Occur.SHOULD
            createShardContext()
                Query termQuery = disjunct;
        assertEquals(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "bar"))), parser.parse("\"bar\""));
        boostQuery = (BoostQuery) boostQuery.getQuery();
        simpleQueryStringBuilder.field(TEXT_FIELD_NAME, 5);
                    defaultOp
            -1,
        queryBuilder = new SimpleQueryStringBuilder("now");
                    new BooleanClause(
        return IndexMetadata.builder(name).settings(build).build();
     */
 *
        assertEquals("supplied field is null or empty", e.getMessage());
        assertEquals(json, false, parsed.fuzzyTranspositions());
                new SpanNearQuery(new SpanQuery[] { span1, span2 }, 0, true),
 * KIND, either express or implied.  See the License for the
                )
    public void testLenientToPrefixQuery() throws Exception {
                query,
        SimpleQueryStringBuilder queryBuilder = (SimpleQueryStringBuilder) parseQuery(contentString);
                } else {
                fields.put(fieldName, AbstractQueryBuilder.DEFAULT_BOOST);
            .add(new TermQuery(new Term(TEXT_FIELD_NAME, "fox")), BooleanClause.Occur.SHOULD)
            new MockSynonymAnalyzer(),
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.search.FuzzyQuery;
        );
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> qb.toQuery(createShardContext()));
                )
        if (randomBoolean()) {
                        .or(instanceOf(ConstantScoreQuery.class))
            SimpleQueryStringBuilder.DEFAULT_OPERATOR,
            .field(TEXT_FIELD_NAME)
        settings.analyzeWildcard(true);
            .field("unmapped")
        // level in Lucene's SimpleQueryParser and overflow the JVM stack. The query must instead
        SimpleQueryStringQueryParser parser = new SimpleQueryStringQueryParser(
public class SimpleQueryStringBuilderTests extends AbstractQueryTestCase<SimpleQueryStringBuilder> {
    public void testFieldCannotBeEmptyAndWeighted() {
     * fields and weights to null but refuse to accept null instead.
            createShardContext()
        assertEquals(expected, query);
                Arrays.asList(
import java.util.Collections;
                        new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "fox")))
import java.util.ArrayList;
            .toQuery(createShardContext());
        BooleanQuery boolQuery = (BooleanQuery) qb.toQuery(shardContext);
import org.apache.lucene.queries.spans.SpanOrQuery;
            if (query instanceof DisjunctionMaxQuery) {
                ),
        shardContext.setAllowUnmappedFields(true); // to avoid occasional cases
        result.fields(fields);
        Query query = new SimpleQueryStringBuilder("t*").field(DATE_FIELD_NAME)
            if (q.getClass() == MatchNoDocsQuery.class) {
        settings.quoteFieldSuffix("_2");
            if (query instanceof MatchNoDocsQuery == false) {
                    defaultOp
        boostQuery = (BoostQuery) query;
            BooleanQuery boolQuery = (BooleanQuery) query;
        assertEquals("Wrong default default lenient field.", false, SimpleQueryStringBuilder.DEFAULT_LENIENT);
        );
import java.util.Locale;
    }
        }
                .build();
        }
         */
            FuzzyQuery.defaultPrefixLength,
        return result;
                                defaultOp
        } else {
            query = new SimpleQueryStringBuilder("hello").toQuery(context);
                }
                    new BooleanQuery.Builder().add(new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "foo")), defaultOp))
    }
        assertEquals(json, 5, parsed.fuzzyMaxExpansions());
            () -> new SimpleQueryStringBuilder("the quick fox").field(TEXT_FIELD_NAME, -1.0f)
                        .add(
        } else if (queryBuilder.fields().size() > 1) {
                    defaultOp
        // Escaped parentheses and parentheses inside a quoted phrase do not count toward nesting
        assertThat(builder, equalTo(otherBuilder));
import static org.hamcrest.Matchers.anyOf;
        assertQueryCachability(queryBuilder, false);
import static org.hamcrest.CoreMatchers.containsString;
        SimpleQueryStringBuilder qb = new SimpleQueryStringBuilder("The quick brown fox.");
        Query expected = new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "quick")), BooleanClause.Occur.SHOULD)
            cachingExpected,
        expectedQueries.add(new PrefixQuery(new Term(TEXT_FIELD_NAME, "t"), MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE));
        QueryShardContext context = createShardContext();
                        disjunct = constantScoreQuery.getQuery();
            assertThat(query, instanceOf(DisjunctionMaxQuery.class));
import org.apache.lucene.tests.analysis.MockSynonymAnalyzer;
        for (int i = 0; i < numberOfTerms; i++) {
     * Test for behavior reported in https://github.com/elastic/elasticsearch/issues/34708
                        )
        }
 * the Apache License, Version 2.0 (the "License"); you may
                    termQuery = ((BoostQuery) disjunct).getQuery();
import org.apache.lucene.queries.spans.SpanTermQuery;
import org.apache.lucene.search.BoostQuery;
    }
            PhraseQuery pq2 = new PhraseQuery.Builder().add(new Term(TEXT_FIELD_NAME, "tiny"))
        query = new SimpleQueryStringBuilder(shallow).field(TEXT_FIELD_NAME).toQuery(createShardContext());
        int fieldCount = randomIntBetween(0, 2);
            );
                "Encountered lucene query type we do not have a validation implementation for in our "
        assertEquals(
            // phrase will pick it up
                .field(KEYWORD_FIELD_NAME)
            new DisjunctionMaxQuery(
            qb.defaultOperator()
            query = new SimpleQueryStringBuilder("hello").toQuery(context);
import org.apache.lucene.search.MatchNoDocsQuery;
            createShardContext()
    public void testToQueryBoost() throws IOException {
            settings,
    }
        } else {
                "auto_generate_synonyms_phrase_query" : true,
            query = parser.parse("\"guinea pig\"");
        SimpleQueryStringBuilder simpleQueryStringBuilder = new SimpleQueryStringBuilder("test");
            .toQuery(createShardContext());
        String query = "now " + randomAlphaOfLengthBetween(4, 10);
        );
        assertEquals(9, noMatchNoDocsQueries);
            -1,
                .setSlop(2)
        if (randomBoolean()) {
        SimpleQueryStringQueryParser.Settings settings = new SimpleQueryStringQueryParser.Settings();
            SimpleQueryStringBuilder.DEFAULT_BOOST,
        assertEquals(json, 1, parsed.fields().size());
            for (Query disjunct : maxQuery.getDisjuncts()) {
 * specific language governing permissions and limitations
            Query query = parser.parse("guinea pig");
                String fieldName = randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME);
        assertThat(queryBuilder.fields(), notNullValue());
 *
    public void testFieldsCannotBeSetToNull() {
 * compatible open source license.
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> qb.field(null, AbstractQueryBuilder.DEFAULT_BOOST));
            SpanTermQuery span2 = new SpanTermQuery(new Term(TEXT_FIELD_NAME, "pig"));
        assertQueryWithAllFieldsWildcard(query);
            }
                    if (disjunct instanceof ConstantScoreQuery constantScoreQuery) {
            {
                    new TermQuery(new Term(TEXT_FIELD_NAME, "quick")),
        }
                new DisjunctionMaxQuery(
                ),
                    assertThat(disjunct, either(instanceOf(TermQuery.class)).or(instanceOf(MatchNoDocsQuery.class)));
    }
            int size = randomIntBetween(0, SimpleQueryStringFlag.values().length);
            .add(new TermQuery(new Term(TEXT_FIELD_NAME, "quick")), BooleanClause.Occur.SHOULD)
    private static IndexMetadata newIndexMeta(String name, Settings oldIndexSettings, Settings indexSettings) {
    }
            -1,
        assertEquals("Wrong default default fuzzy prefix length.", FuzzyQuery.defaultPrefixLength, qb.fuzzyPrefixLength());
            }
        assertEquals(json, ".quote", parsed.quoteFieldSuffix());
        if (randomBoolean()) {
     * Also this relies on {@link SimpleQueryStringTests} to test most of the
    }
         * actual lucene query
                    Arrays.asList(
        String query = randomAlphaOfLengthBetween(1, 10).toLowerCase(Locale.ROOT);
            simpleQueryStringBuilder.defaultOperator(Operator.AND);
    public void testAnalyzeWildcard() throws IOException {
        }
        assertEquals(
        int depth = 200_000;
        for (BooleanClause c : query.clauses()) {
        );
        query = new SimpleQueryStringBuilder("aBc~1").field(TEXT_FIELD_NAME).analyzer("standard").toQuery(createShardContext());
        } else if (numberOfTerms == 1) {
            parser.setDefaultOperator(defaultOp);
        expectedQueries.add(
        SimpleQueryStringQueryParser.Settings settings = new SimpleQueryStringQueryParser.Settings();
    }
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> qb.field(""));
     * Query terms that contain "now" can trigger a query to not be cacheable.
                if (termQuery instanceof ConstantScoreQuery) {
        settings.analyzeWildcard(true);
    public void testExpandedTerms() throws Exception {
        assertNotNull(query);
            }
        QueryShardContext shardContext = createShardContext();
            );
                        defaultOp
            assertQueryWithAllFieldsWildcard(query);
                }
import org.apache.lucene.search.PhraseQuery;
                        .addTerm(new Term(TEXT_FIELD_NAME, "first"))
import static org.hamcrest.Matchers.either;
        int numberOfTerms = randomIntBetween(1, 4);
            assertThat(query, instanceOf(TermQuery.class));
            FuzzyQuery.defaultMaxExpansions,
              }
        // we avoid strings with "now" since those can have different caching policies that are checked elsewhere
        DisjunctionMaxQuery disjunctionMaxQuery = (DisjunctionMaxQuery) query;
    }
            context.getIndexSettings()
        SimpleQueryStringQueryParser parser = new SimpleQueryStringQueryParser(
        }
        for (Operator op : Operator.values()) {
            assertEquals(expected, query);
                                                   // in setup where we didn't
        if (randomBoolean()) {
        for (Operator op : Operator.values()) {
                        new BooleanClause(
                fields.put(KEYWORD_FIELD_NAME, 2.0f / randomIntBetween(1, 20));
                            new BooleanQuery.Builder().add(
                Arrays.asList(
        assertEquals(new PrefixQuery(new Term(TEXT_FIELD_NAME, "abc"), MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE), query);
        assertQueryCachability(queryBuilder, true);
 * The OpenSearch Contributors require contributions made to
                new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "guinea")), defaultOp)
            IllegalArgumentException.class,
                expectedMinimumShouldMatch = 0;
            qb.flags()
        otherBuilder.flags(-1);
        );
        assertEquals("supplied field is null or empty", e.getMessage());
                        .add(new BooleanClause(new PrefixQuery(new Term(TEXT_FIELD_NAME, "foobar")), defaultOp))
    /**
    public void testNegativeFieldBoost() {
                assertThat(
                new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "hello")))
        StringBuilder queryString = new StringBuilder();
            assertThat(query, equalTo(expectedQuery));
            .analyzer("stop")
                    either(instanceOf(TermQuery.class)).or(instanceOf(BoostQuery.class))
                noMatchNoDocsQueries++;
            queryString.append("t" + i + " ");
        assertEquals("Wrong default default fuzzy transpositions.", FuzzyQuery.defaultTranspositions, qb.fuzzyTranspositions());
            createShardContext()
        );
            .build();
        queryBuilder = new SimpleQueryStringBuilder(query);
        for (int i = 0; i < numberOfFields; i++) {
        simpleQueryStringBuilder.field(TEXT_FIELD_NAME, 5);
        qb.defaultOperator(null);
        Query luceneQuery = queryBuilder.toQuery(shardContext);
            BooleanClause.Occur defaultOp = op.toBooleanClauseOccur();
    }
        }
    }
        assertEquals(expected, query);
            simpleQueryStringBuilder.field(TEXT_FIELD_NAME);
                );
        assertEquals("supplied field is null or empty", e.getMessage());
    }
        // if we hit a date field with "now", this should diable cachability
        assertThat(boostQuery.getQuery(), instanceOf(TermQuery.class));
                    newIndexMeta(
    public void testAllFieldsWildcard() throws Exception {
        assertEquals(
        SimpleQueryStringBuilder builder = new SimpleQueryStringBuilder("foo bar");
    public void testWithPrefixStopWords() throws Exception {
        assertEquals(expected, query);
        Map<String, Float> fields = new HashMap<>();
                "default_operator" : "and",
    public void testDefaultField() throws Exception {
    public void testFieldCannotBeEmpty() {
        );
            parser.setDefaultOperator(defaultOp);
        QueryBuilder rewritten = rewriteQuery(qb, new QueryShardContext(context));
            settings,
            // `*` is in the list of the default_field => leniency set to true
            if (simpleQueryStringBuilder.defaultOperator().equals(Operator.AND)) {
            ),
        if (randomBoolean()) {
    public void testWithStopWords() throws Exception {
        } finally {
        assertNotNull(rewritten.toQuery(context));
        String nested = "(".repeat(depth) + "a" + ")".repeat(depth);
            expectedQuery = new SpanOrQuery(
                    assertThat(termQuery, instanceOf(MatchNoDocsQuery.class));
                        "index",
                )
            createShardContext()
         * We use a private rewrite context here since we want the most realistic way of asserting that we are cacheable or not. We do it
                    new BooleanQuery.Builder().add(
                    assertThat(inner.getTerm().bytes().toString(), is(inner.getTerm().bytes().toString().toLowerCase(Locale.ROOT)));
        // default value `*` sets leniency to true
                                new SynonymQuery.Builder(TEXT_FIELD_NAME).addTerm(new Term(TEXT_FIELD_NAME, "bar"))
                        Settings.builder().putList("index.query.default_field", "*").build()
    }
            "Setting flags to null should result in returning to default value.",
        if (randomBoolean()) {
 */
            "query should " + (cachingExpected ? "" : "not") + " be cacheable: " + qb.toString(),
                assertTermOrBoostQuery(query, field.getKey(), queryBuilder.value(), field.getValue());
import org.apache.lucene.tests.util.TestUtil;
        );
        );
    }
    }
/*
              "simple_query_string" : {
        SimpleQueryStringBuilder qb = new SimpleQueryStringBuilder("The quick brown fox.");
                            defaultOp
    public void testUnmappedFieldNoTokenWithAndOperator() throws IOException {
        )
        if (queryBuilder.value().isEmpty()) {
            .field(KEYWORD_FIELD_NAME)
        SimpleQueryStringBuilder qb = new SimpleQueryStringBuilder("The quick brown fox.").field(TEXT_FIELD_NAME);
    }
            {
                "query" : "\\\"fried eggs\\\" +(eggplant | potato) -frittata",
import static org.hamcrest.Matchers.is;
        for (int i = 0; i < fieldCount; i++) {
            Collections.singletonMap(TEXT_FIELD_NAME, 1.0f),
            expectedQuery = new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "big")), defaultOp)
        assertEquals(DisjunctionMaxQuery.class, query.getClass());
        checkGeneratedJson(json, parsed);
        query = simpleQueryStringBuilder.toQuery(shardContext);
    }
            -1,
                "quote_field_suffix" : ".quote",
    public void testNegativeFlags() throws IOException {
        // everything else is fine on all fields
    /**
        query = new SimpleQueryStringBuilder("hello").field(TEXT_FIELD_NAME).field("*").field(KEYWORD_FIELD_NAME).toQuery(context);
            .build();
            Query expectedQuery = new BooleanQuery.Builder().add(
     * This assumes that Lucene query parsing is being checked already, adding
        SimpleQueryStringBuilder parsed = (SimpleQueryStringBuilder) parseQuery(json);
                    TermQuery inner = (TermQuery) termQuery;
        NullPointerException e = expectThrows(NullPointerException.class, () -> qb.fields(null));
        assertQueryWithAllFieldsWildcard(query);
        assertEquals(
        query = new SimpleQueryStringBuilder("first & second").field("unmapped")
            new StandardAnalyzer(),
    public void testDefaultFieldParsing() throws IOException {
                    )
        assertEquals(expected, query);
        assertThat(e.getMessage(), containsString("nests parentheses deeper than the limit"));
        query = new BoolQueryBuilder().should(
        simpleQueryStringBuilder = new SimpleQueryStringBuilder("test");
import org.apache.lucene.search.SynonymQuery;
                                                   // add types but strict field
    public void testFromJson() throws IOException {
            BooleanClause.Occur defaultOp = op.toBooleanClauseOccur();
        assertEquals("Wrong default default analyze_wildcard field.", false, SimpleQueryStringBuilder.DEFAULT_ANALYZE_WILDCARD);
        }
                );
        qb.defaultOperator(Operator.OR);
                    new BoostQuery(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "hello"))), 5.0f)
                "analyze_wildcard" : false,
    }
            .build();
                result.flags(flagSet.toArray(new SimpleQueryStringFlag[0]));
    private void assertQueryCachability(SimpleQueryStringBuilder qb, boolean cachingExpected) throws IOException {
                if (disjunct instanceof BoostQuery) {
                if (termQuery instanceof TermQuery) {
    public void testDefaultEmptyComplainFlags() {
import org.opensearch.index.search.SimpleQueryStringQueryParser;
            .fuzzyMaxExpansions(5)
                .add(
            .field("another_unmapped")
        int noMatchNoDocsQueries = 0;
            AbstractQueryBuilder.DEFAULT_BOOST,
            Collections.singletonMap(TEXT_FIELD_NAME, 1.0f),
        }
            }
    }
    public void testDefaultNullComplainOp() {
        assertNotNull(query);
        }
        assertThat(
        SimpleQueryStringBuilder qb = new SimpleQueryStringBuilder(nested).field(TEXT_FIELD_NAME);
            .add(new TermQuery(new Term(TEXT_FIELD_NAME, "second")), BooleanClause.Occur.MUST)
            DisjunctionMaxQuery maxQuery = (DisjunctionMaxQuery) query;
            assertThat(query, instanceOf(BooleanQuery.class));
                        )
            result.autoGenerateSynonymsPhraseQuery(randomBoolean());
     * disjunction clause. Instead those disjunctions should be eliminated completely.
            Query expected = new DisjunctionMaxQuery(
        if (randomBoolean()) {
            FuzzyQuery.defaultTranspositions,
        );
            SimpleQueryStringBuilder.DEFAULT_FUZZY_MAX_EXPANSIONS
                                    .build(),
    }
        assertThat(boostQuery.getQuery(), instanceOf(TermQuery.class));
                    newIndexMeta(
 *
        query = new BoolQueryBuilder().should(new SimpleQueryStringBuilder("the").field(TEXT_FIELD_NAME).analyzer("stop"))
         * this way in SearchService where we first rewrite the query with a private context, then reset the context and then build the
        Query query = new SimpleQueryStringBuilder("text~2").field(TEXT_FIELD_NAME)
                .updateIndexMetadata(
    public void testFieldCannotBeNull() {
        if (randomBoolean()) {
            () -> randomAlphaOfLengthBetween(1, 10)
                                .build(),
            .defaultOperator(Operator.AND)
            result.quoteFieldSuffix(TestUtil.randomSimpleString(random()));
        assertEquals(expected, query);
        QueryShardContext shardContext = createShardContext();
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> qb.field(null));
import org.apache.lucene.search.MultiTermQuery;
        assertEquals("Wrong default default operator field.", Operator.OR, SimpleQueryStringBuilder.DEFAULT_OPERATOR);
        // Prefix
        }
            SimpleQueryStringBuilder.DEFAULT_FLAGS,
        settings.quoteFieldSuffix(".quote");
 * not use this file except in compliance with the License.
            )
            }
            -1,
        assertQueryWithAllFieldsWildcard(query);
                .add(new Term(TEXT_FIELD_NAME, "cavy"))
            "Setting flags to empty should result in returning to default value.",
        query = new SimpleQueryStringBuilder("the").field(TEXT_FIELD_NAME)
                .build();
                    new SynonymQuery.Builder(TEXT_FIELD_NAME).addTerm(new Term(TEXT_FIELD_NAME, "first"))
        IllegalArgumentException exc = expectThrows(
        String contentString = String.format(Locale.ROOT, """
 * this work for additional information regarding copyright
     * */
        if (randomBoolean()) {
                .build();
                    )
    private static int shouldClauses(BooleanQuery query) {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> qb.field("", AbstractQueryBuilder.DEFAULT_BOOST));
        assertThat(shouldClauses(boolQuery), is(4));
            Query query = parser.parse("first foo-bar-foobar* last");
                    )
            .add(
                .build();
        QueryShardContext context = createShardContext();
            "Setting operator to null should result in returning to default value.",
    public void testDefaultNullComplainFlags() {
        }
    }
 * GitHub history for details.
        query = randomFrom("NoW", "nOw", "NOW") + " " + randomAlphaOfLengthBetween(4, 10);
        SimpleQueryStringBuilder qb = createTestQueryBuilder();
    }
                for (Query disjunct : (DisjunctionMaxQuery) query) {
            .toQuery(createShardContext());
        assertThat(boostQuery.getBoost(), equalTo(2f));
        assertThat(exc.getMessage(), containsString("negative [boost]"));
            SimpleQueryStringBuilder.DEFAULT_FLAGS,
        Query query = new SimpleQueryStringBuilder("hello").toQuery(context);
            Query query = parser.parse("first foo-bar-foobar* last");
        )
            );
                    termQuery = ((ConstantScoreQuery) termQuery).getQuery();
        assertEquals(expected, query);
    }
            Collections.singletonMap(TEXT_FIELD_NAME, 1.0f),
            .build();
                            new BooleanClause(
        Query query = simpleQueryStringBuilder.toQuery(shardContext);
        Query query = new SimpleQueryStringBuilder("the* quick fox").field(TEXT_FIELD_NAME).analyzer("stop").toQuery(createShardContext());
     * The following should fail fast - never silently set the map containing
        assertEquals(
            if (c.occur() == BooleanClause.Occur.SHOULD) {
     *
                            defaultOp
    }
            BooleanClause.Occur defaultOp = op.toBooleanClauseOccur();
                "boost" : 1.0
        int percent = randomIntBetween(1, 100);
        FuzzyQuery expected = new FuzzyQuery(new Term(TEXT_FIELD_NAME, "aBc"), 1);
        /*
        }
                    disjunct,
        // Fuzzy
    private void assertQueryWithAllFieldsWildcard(Query query) {
    }
import org.apache.lucene.queries.spans.SpanQuery;
                .build();
            "Wrong default default fuzzy max expansions field.",
        } else if (queryBuilder.fields().size() == 0) {
        FuzzyQuery expected = new FuzzyQuery(new Term(TEXT_FIELD_NAME, "text"), 2, 2, 5, false, FuzzyQuery.defaultRewriteMethod(5));
        assertEquals(expected, query);
                new BooleanClause(
                either(instanceOf(DisjunctionMaxQuery.class)).or(instanceOf(MatchNoDocsQuery.class)).or(instanceOf(TermQuery.class))
            if (i == 0) {
                );
                        context.getIndexSettings().getSettings(),
            assertThat(
    public void testDefaults() {
    public void testFieldCannotBeNullAndWeighted() {
        }
import org.apache.lucene.search.DisjunctionMaxQuery;
import java.util.HashSet;
        return result;
                        )
            "Wrong default default fuzzy transpositions field.",
                .updateIndexMetadata(
                    defaultOp
    }
        Query query = new SimpleQueryStringBuilder("first & second").field(TEXT_FIELD_NAME)
        String json = """
import java.util.List;
                        .build(),
            }
        );
        query = new SimpleQueryStringBuilder("the quick fox").field(TEXT_FIELD_NAME)
        assertEquals("Wrong default default analyze_wildcard.", false, qb.analyzeWildcard());
import java.io.IOException;
        query = new SimpleQueryStringBuilder("aBc*").field(TEXT_FIELD_NAME).analyzer("standard").toQuery(createShardContext());
            context.getIndexSettings()
        qb.defaultOperator(Operator.AND);
        }
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("Wrong default default boost.", AbstractQueryBuilder.DEFAULT_BOOST, qb.boost(), 0.001);
import org.apache.lucene.search.TermQuery;
 */
            result.analyzer(randomAnalyzer());
            SimpleQueryStringBuilder.DEFAULT_FUZZY_PREFIX_LENGTH
        assertQueryCachability(queryBuilder, false);
        expected = new BooleanQuery.Builder().add(new MatchNoDocsQuery(), BooleanClause.Occur.SHOULD).build();
    }
        qb.flags(new SimpleQueryStringFlag[] {});
        assertThat(query, notNullValue());
        SimpleQueryStringQueryParser parser = new SimpleQueryStringQueryParser(
                .add(new Term(TEXT_FIELD_NAME, "pig"))
                )
    }
 * You may obtain a copy of the License at
        for (Query q : disjunctionMaxQuery.getDisjuncts()) {
    public void testIllegalConstructorArg() {
                .add(new Term(TEXT_FIELD_NAME, "guinea"))
        assertParsedQuery(query, builder);
    public void testAnalyzerWildcardWithSynonyms() throws IOException {
        query = new SimpleQueryStringBuilder("aBc~1").field(TEXT_FIELD_NAME).analyzer("whitespace").toQuery(createShardContext());
            ).add(new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "pig")), defaultOp)).build();
        assertEquals("Wrong default default fuzzy max expansions.", FuzzyQuery.defaultMaxExpansions, qb.fuzzyMaxExpansions());
        expected = new BooleanQuery.Builder().add(
        List<Query> expectedQueries = new ArrayList<>();
            "Wrong default default boost field.",
        simpleQueryStringBuilder.minimumShouldMatch(percent + "%");
        BoostQuery boostQuery = (BoostQuery) query;
        if (numberOfFields * numberOfTerms == 1) {
            result.fuzzyPrefixLength(randomIntBetween(0, 5));
        queryBuilder.field(DATE_FIELD_NAME);
                }
        }
            // phrase with slop
            0.001
            hasItems(
    /**
        simpleQueryStringBuilder.boost(2);
            }
import java.util.Set;
 * ownership. Elasticsearch licenses this file to you under
                new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "first")), defaultOp)
        }
    public void testMinimumShouldMatch() throws IOException {
                    new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "quick")))
            .field("another_unmapped")
        assertEquals(json, 1, parsed.fuzzyPrefixLength());
        builder.flags(SimpleQueryStringFlag.ALL);
    }
    public void testAnalyzerWithGraph() {
    @Override
        }
    }
            settings,
            .add(new MatchNoDocsQuery(), BooleanClause.Occur.MUST)
    public void testCachingStrategiesWithNow() throws IOException {
import static org.hamcrest.Matchers.equalTo;
                new TermQuery(new Term(TEXT_FIELD_NAME, "hello")),
        assertEquals("Wrong default default lenient.", false, qb.lenient());
        int numberOfFields = randomIntBetween(1, 4);
        assertThat(boostQuery.getQuery(), instanceOf(BoostQuery.class));
        String shallow = "(".repeat(50) + "a" + ")".repeat(50);
            context.getIndexSettings()
            .analyzer("stop")
            query = parser.parse("big \"tiny guinea pig\"~2");
            SpanTermQuery span1 = new SpanTermQuery(new Term(TEXT_FIELD_NAME, "guinea"));
            .toQuery(createShardContext());
                            )
                "failed query, caused by Can only use prefix queries on keyword and text fields - not on [mapped_date] which is of type [date]"
        Query query = new SimpleQueryStringBuilder("the quick fox").field(TEXT_FIELD_NAME).analyzer("stop").toQuery(createShardContext());
        );
                1.0f
    protected void doAssertLuceneQuery(SimpleQueryStringBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
     * Unmapped field can lead to MatchNoDocsQuerys in disjunction queries. If tokens are eliminated (e.g. because
        assertThat(shouldClauses(boolQuery), is(0));
                            .build(),
            parser.setDefaultOperator(defaultOp);
                );
            new SimpleQueryStringBuilder("the").field(TEXT_FIELD_NAME).field(KEYWORD_FIELD_NAME).analyzer("stop")
            .lenient(true)
                )
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /*
        assertThat(shouldClauses(boolQuery), is(4));
        // fail with a catchable IllegalArgumentException (surfaced to clients as HTTP 400).
    }
        Query query = new SimpleQueryStringBuilder(escaped).field(TEXT_FIELD_NAME).toQuery(createShardContext());
            // Reset to the default value
        assertEquals(json, "\"fried eggs\" +(eggplant | potato) -frittata", parsed.value());
                .updateIndexMetadata(
            )
package org.opensearch.index.query;
    public void testToFuzzyQuery() throws Exception {
            Set<SimpleQueryStringFlag> flagSet = new HashSet<>();
                .add(
        );
            result.analyzeWildcard(randomBoolean());
            }""";
     * This test checks the search context cacheable flag is updated accordingly.
            new MockSynonymAnalyzer(),
        SimpleQueryStringBuilder qb = new SimpleQueryStringBuilder("The quick brown fox.");
            .toQuery(createShardContext());
        assertEquals(expected, query);
        }
import org.apache.lucene.search.PrefixQuery;
            s -> s.toLowerCase(Locale.ROOT).contains("now"),
        // Now check what happens if the quote field does not exist
                        context.getIndexSettings().getSettings(),
            Collections.singletonMap(TEXT_FIELD_NAME, 1.0f),
import java.util.Arrays;
                    )
                .add(
                1.0f
            )
        assertThat(luceneQuery, anyOf(instanceOf(BooleanQuery.class), instanceOf(DisjunctionMaxQuery.class)));
        String queryText = randomValueOtherThanMany(
