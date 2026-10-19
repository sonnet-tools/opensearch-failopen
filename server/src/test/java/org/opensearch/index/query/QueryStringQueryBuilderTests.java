            )
        assertTrue(regexpQuery.toString().contains("abc.*"));  
        String json = "{\n"
                new BooleanQuery.Builder().add(  
    /**
            queryParser.setForceAnalyzer(new MockRepeatAnalyzer());
            queryStringQueryBuilder.escape(randomBoolean());
import java.util.ArrayList;
        query = queryBuilder.toQuery(context);
        assertEquals(expected, query);
        );
        }
                break;  
            assertThat(query, equalTo(expected));  
            0f  
        assertThat(query, equalTo(new MatchNoDocsQuery()));
            queryStringQueryBuilder.analyzer(randomAnalyzer());
            .add(new MatchNoDocsQuery("empty fields"), Occur.SHOULD)
                    analyzer = randomAnalyzer();
        );  
        String queryString = queryStringPrefix + "foo bar" + queryStringSuffix;
            .build();
                }
    public void testToQueryWithGraph() throws Exception {
        String timeZone = instance.timeZone() == null ? null : instance.timeZone().getId();
        query = queryStringQuery.toQuery(shardContext);  
    }
        query = new QueryStringQueryBuilder("aBc*D").field(TEXT_FIELD_NAME).analyzer("whitespace").toQuery(createShardContext());  
            queryStringQueryBuilder.enablePositionIncrements(randomBoolean());
/*  
    public void testToQueryMultipleFieldsDisMaxQuery() throws Exception {
            + DATE_FIELD_NAME
                }
    }
            IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> queryBuilder.toQuery(createShardContext()));
                builder.field("default_field", TEXT_FIELD_NAME);  
        query = new SimpleQueryStringBuilder("first unknown:second").field("unmapped")
        assertThat(query, instanceOf(WildcardQuery.class));  
            assertThat(boostQuery.getBoost(), equalTo(boosts[i]));
        }
        }
            .endObject();
    public void testToQueryWildcardWithIndexedPrefixes() throws Exception {
import org.apache.lucene.search.BooleanQuery;
                .add(
        long lower = 0; // 1970-01-01T00:00:00.999 UTC  
            .toQuery(createShardContext());
        QueryStringQueryBuilder queryStringQuery = queryStringQuery(TEXT_FIELD_NAME + ":boosted^2");
                    allowLeadingWildCard = randomBoolean() ? null : (allowLeadingWildCard == false);  
        );
        boolean escape = instance.escape();
                            new BooleanClause(  
        TooComplexToDeterminizeException e = expectThrows(
        assertThat(boostQuery.getBoost(), equalTo(3.0f));  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> query.toQuery(context));  
    public void testQuoteAnalyzer() throws Exception {
            context.getIndexSettings()
            assertThat(query, equalTo(expectedQuery));  
        assertEquals(new TermRangeQuery(TEXT_FIELD_NAME, new BytesRef("abc"), new BytesRef("bcd"), true, true), query);
        boostQuery = (BoostQuery) query;
        expected = new MatchAllDocsQuery();
        boostQuery = (BoostQuery) query;
        String invalidQueryAsString = "{\n"
            newInstance.tieBreaker(tieBreaker);
            );
            .field("type", "text")
        Map<String, Float> fields = instance.fields();
            + "    \"query_string\":{\n"
                .updateIndexMetadata(  
        query = randomFrom("NoW", "nOw", "NOW") + " " + randomAlphaOfLengthBetween(4, 10);
                }
        queryBuilder = new QueryStringQueryBuilder("*:*");  
                        "index",
    public void testToQueryWildcardQuery() throws Exception {  
    }  
                                .addTerm(new Term(TEXT_FIELD_NAME, "foo"))
        assertThat(query, instanceOf(PhraseQuery.class));  
            assertThat(query, Matchers.equalTo(expectedQuery));
    public void testTimezoneEquals() {  
            query += (randomBoolean() ? TEXT_FIELD_NAME + ":" : "") + term + " ";  
            for (int j = 0; j < 2; j++) {  
    }
    }
        assertQueryWithAllFieldsWildcard(query);
        assertThat(e.getMessage(), containsString("cannot use [fields] parameter in conjunction with [default_field]"));
        if (fuzzyRewrite != null) {  
            }  
                Occur.SHOULD  
import org.apache.lucene.search.TermQuery;
        QueryStringQueryBuilder qsq = queryStringQuery(DATE_FIELD_NAME + ":1970-01-01");
        } finally {  
            .toQuery(createShardContext());
                );  
    // Tests fix for https://github.com/elastic/elasticsearch/issues/29403
        {  
        fuzzyQuery = (FuzzyQuery) query;  
        assertThat(query, equalTo(expectedQuery));  
        }
                    tieBreaker = randomFloat();  
        // non-prefix queries do not work with range queries simple syntax  
        {  
import org.apache.lucene.search.AutomatonQuery;
            context.getIndexSettings()
            ).add(new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "bar")), BooleanClause.Occur.SHOULD)).build();
    }
            new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "bar"))),  
        assertEquals(
                        Settings.builder().putList("index.query.default_field", "*").build()
            IllegalArgumentException.class,
        assertEquals(new MatchNoDocsQuery(), query);
        query = new QueryStringQueryBuilder("hello").lenient(true)
            queryStringQueryBuilder.timeZone(randomZone().getId());
            .field("unmapped_field")  
            .field("unmapped")
        Query query = queryStringQuery("test1 test2").field(TEXT_FIELD_NAME).toQuery(createShardContext());
                .add(new Term(TEXT_FIELD_NAME, "smells"))
        query = new BoolQueryBuilder().should(new QueryStringQueryBuilder("the").field(TEXT_FIELD_NAME).analyzer("stop"))
            TooComplexToDeterminizeException.class,  
            }  
        QueryStringQueryParser queryParser = new QueryStringQueryParser(createShardContext(), "prefix_field");  
            .add(new MatchNoDocsQuery(), BooleanClause.Occur.MUST)  
        BooleanQuery bQuery = (BooleanQuery) query;
        if (randomBoolean()) {  
            .field(KEYWORD_FIELD_NAME)
    public void testExactGeo() throws Exception {
            .build();
                new long[] { lower }.length,  
                        context.getIndexSettings().getSettings(),  
                new BooleanQuery.Builder().add(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "quick"))), Occur.SHOULD)
 * software distributed under the License is distributed on an
        assertThat(query, instanceOf(BoostQuery.class));
                    Occur.MUST_NOT
            + "    \"phrase_slop\" : 0,\n"  
            + "    \"fields\" : [ ],\n"  
        int fuzzyMaxExpansions = instance.fuzzyMaxExpansions();
            expectedQuery = new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "that")), BooleanClause.Occur.MUST)
        assertThat(phraseQuery.getSlop(), equalTo(3));
        terms.add(new BoostQuery(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "first"))), 0.5f));
        }
        if (randomBoolean()) {  
    }
                    expectedEdits = 1;
                ),
            new WildcardQuery(
import org.apache.lucene.search.FieldExistsQuery;
 */  
        QueryValidationException e = expectThrows(QueryValidationException.class, () -> builder.toQuery(context));
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(queryAsString));
    public void testRegexpQueryParserWithForceAnalyzer() throws Exception {
    public void testWithStopWords() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
        query = new QueryStringQueryBuilder("the").field(TEXT_FIELD_NAME)
            queryStringQueryBuilder.maxDeterminizedStates(randomIntBetween(1, 100));
        BooleanQuery booleanQuery = (BooleanQuery) query;
                    break;
        if (randomBoolean()) {
        expected = new PhraseQuery.Builder().add(new Term(TEXT_FIELD_NAME, "quick"))
                    quoteFieldSuffix = quoteFieldSuffix + randomAlphaOfLength(1);
            // no parent should cause guinea and pig to be treated as separate tokens
        newInstance.escape(escape);
                    break;  
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {  
                    .toQuery(createShardContext());
            Query query = queryBuilder.toQuery(createShardContext());
        );
                } else {
            new QueryStringQueryBuilder("\"bar\"").quoteFieldSuffix(".quote").field(TEXT_FIELD_NAME).doToQuery(context)
        // Fuzzy
            Query expected = new WildcardQuery(new Term("foo", "*"));
import org.apache.lucene.search.MultiTermQuery;
 * license agreements. See the NOTICE file distributed with
                )
        DisjunctionMaxQuery disjunctionMaxQuery = (DisjunctionMaxQuery) query;
        if (randomBoolean()) {  
        if (randomBoolean()) {  
                    )
        )
                    new BooleanQuery.Builder().add(
        String quoteAnalyzer = instance.quoteAnalyzer();  
            new QueryStringQueryBuilder("bar").quoteFieldSuffix(".quote").field(TEXT_FIELD_NAME).doToQuery(context)
        query = queryStringQuery.toQuery(shardContext);
     * This test checks the search context cacheable flag is updated accordingly.
import org.apache.lucene.search.BoostQuery;
        if (quoteFieldSuffix != null) {  
                    len = randomIntBetween(3, 5);  
                break;  
            case 22:
        assertThat(booleanQuery.clauses().get(0).occur(), equalTo(BooleanClause.Occur.SHOULD));  
import org.opensearch.search.approximate.ApproximatePointRangeQuery;
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
        Query expected = new MatchAllDocsQuery();
            newInstance.analyzer(analyzer);
            query = new QueryStringQueryBuilder("hello").toQuery(context);  
        );
            newInstance.fuzzyRewrite(fuzzyRewrite);
                break;
        String fuzzyRewrite = instance.fuzzyRewrite();  
            String defaultFieldName = randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME, randomAlphaOfLengthBetween(1, 10));
        if (randomBoolean()) {  
        Query query = queryParser.parse("foo*");  
        assertTrue(e.getMessage().contains("Determinizing automaton"));
                .add(new TermQuery(new Term(TEXT_FIELD_NAME, "pig")), Occur.MUST)
            ),  
                .updateIndexMetadata(
        newInstance.maxDeterminizedStates(maxDeterminizedStates);  
        assertThat(expectedQuery, equalTo(query));  
    }
                    } else {  
            );
            TooComplexToDeterminizeException.class,
            expectedQuery = new BooleanQuery.Builder().add(pq1, Occur.SHOULD).add(pq2, Occur.SHOULD).build();
import static org.hamcrest.CoreMatchers.hasItems;
        for (int i = 0; i < numTerms; i++) {
            + "}";
                DATE_FIELD_NAME,  
            .enablePositionIncrements(false)  
            "Can only use prefix queries on keyword and text fields - not on [mapped_int] which is of type [integer]",
            query = queryParser.parse("+that -guinea pig +smells");  
                break;  
                    )
    public void testToQueryMultipleTermsBooleanQuery() throws Exception {
        BooleanQuery expected = new BooleanQuery.Builder().add(
            .defaultOperator(Operator.AND)  
                }
                        .build(),
                    break;
            // span query with slop
        assertThat(boostQuery.getBoost(), equalTo(5f));
                        "index",
                        .add(  
                .type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)  
        }
                    new PhraseQuery.Builder().add(new Term(TEXT_FIELD_NAME, "guinea")).add(new Term(TEXT_FIELD_NAME, "pig")).build(),
            .field("another_unmapped")
        QueryShardContext context = createShardContext();
            queryBuilder = new QueryStringQueryBuilder("_exists_:" + value);  
            // complex
        }
    @Override
            assertThat(query, equalTo(expectedQuery));
        QueryStringQueryBuilder query = queryStringQuery("12*").defaultField(INT_FIELD_NAME);  
        assertThat(e.getMessage(), containsString("Determinizing automaton"));  
        QueryShardContext context = createShardContext();  
        Query expected = new DisjunctionMaxQuery(  
            .build();
    /**
        query = new QueryStringQueryBuilder("the quick fox").field(TEXT_FIELD_NAME)
        List<Query> terms = new ArrayList<>();
    public void testWithPrefixStopWords() throws Exception {
        Query expected = new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "quick")), BooleanClause.Occur.SHOULD)  
                phraseSlop += 5;
                            defaultOp
            newInstance.quoteAnalyzer(quoteAnalyzer);
                    new BooleanClause(
        String analyzer = instance.analyzer();
                        Settings.builder().putList("index.query.default_field", TEXT_FIELD_NAME, KEYWORD_FIELD_NAME + "^5").build()  
        assertThat(phraseQuery.getTerms()[0], equalTo(new Term(TEXT_FIELD_NAME, "term1")));  
    }  
        Query expected = new PrefixQuery(new Term(TEXT_FIELD_NAME, "quick"), MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE);
        if (minimumShouldMatch != null) {  
        QueryShardException e = expectThrows(QueryShardException.class, () -> query.toQuery(context));
        String query = instance.queryString();  
        return IndexMetadata.builder(name).settings(build).build();
                    )
                            )  
                break;  
        assertThat(boostQuery2.getBoost(), equalTo(1.5f));  
    }  
        assertThat(  
                );
    }  
            .endObject()
        }
            expected = new BooleanQuery.Builder().add(expected, Occur.SHOULD)
                        context.getIndexSettings().getSettings(),
        long upper = 86399999;  // 1970-01-01T23:59:59.999 UTC
                .add(new BooleanQuery.Builder().add(guineaPig, Occur.SHOULD).add(cavy, Occur.SHOULD).build(), defaultOp)  
        query = new QueryStringQueryBuilder("[aBc TO BcD]").field(TEXT_FIELD_NAME).analyzer("standard").toQuery(createShardContext());  
    }  
        )  
            + "    \"fuzzy_transpositions\" : false,\n"  
import org.opensearch.index.mapper.FieldNamesFieldMapper;  
        assertEquals(expected, query);
        Query expectedQuery = new BooleanQuery.Builder().add(
import org.apache.lucene.search.FuzzyQuery;  
            + "  }\n"
        assertQueryWithAllFieldsWildcard(query);
        Query query = new QueryStringQueryBuilder("first").type(MultiMatchQueryBuilder.Type.MOST_FIELDS)
        query.toQuery(context); // no exception  
        query = new QueryStringQueryBuilder("first unmapped:second").field(TEXT_FIELD_NAME)  
                        context.getIndexSettings().getSettings(),  
    }
                .add(
    }
        assertThat(query, instanceOf(RegexpQuery.class));  
            case 1:
        QueryShardContext context = createShardContext();
            .type(MultiMatchQueryBuilder.Type.PHRASE)  
            + "        \"time_zone\":\"Europe/Paris\",\n"
        query = new QueryStringQueryBuilder("hello*").field(INT_FIELD_NAME).lenient(true).toQuery(createShardContext());
    }
        if (timeZone != null) {  
        assertEquals(expected, query);  
        Query query = queryBuilder.toQuery(context);  
        assertTrue(regexpQuery.toString().contains("/foo*bar/"));
                    defaultOp
        Query query = new QueryStringQueryBuilder("the quick fox").field(TEXT_FIELD_NAME).analyzer("stop").toQuery(createShardContext());
            queryStringQueryBuilder.minimumShouldMatch(randomMinimumShouldMatch());
        }
                    analyzeWildcard = randomBoolean();
            case 3:  
            .analyzer("standard")
        query = new QueryStringQueryBuilder("\"quick fox\"").field(TEXT_FIELD_NAME).phraseSlop(2).toQuery(createShardContext());
            case 8:  
    public void testNegativeFieldBoost() {
    }
    public void testToQueryTermQuery() throws IOException {  
            queryStringQueryBuilder.fuzziness(randomFuzziness(TEXT_FIELD_NAME));
                        .add(
    public void testToQueryWildcardQueryWithSynonyms() throws Exception {  
        }
                        "index",
        assertEquals(
                autoGenerateSynonymsPhraseQuery = (autoGenerateSynonymsPhraseQuery == false);  
            .endObject()  
                Arrays.asList(
        Query query = new QueryStringQueryBuilder("\"quick the fox\"").field(TEXT_FIELD_NAME)
            DisjunctionMaxQuery disjunctionMaxQuery = new DisjunctionMaxQuery(disjuncts, 0.0f);
            Query guineaPig = new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "guinea")), Occur.MUST)  
            + "    \"fields\" : [ \"field1\", null, \"field2\" ]\n"
        assertEquals(new MatchNoDocsQuery(), query);
                new BooleanQuery.Builder().add(guineaPig, Occur.SHOULD).add(cavy, Occur.SHOULD).build(),  
        QueryStringQueryBuilder queryStringQueryBuilder = new QueryStringQueryBuilder(query);
import java.util.Map;  
            Query expectedQuery = new BooleanQuery.Builder().add(
            queryParser.setMultiTermRewriteMethod(MultiTermQuery.CONSTANT_SCORE_REWRITE);
                .add(new TermQuery(new Term(TEXT_FIELD_NAME, "smells")), defaultOp)
 * ownership. Elasticsearch licenses this file to you under  
            query = queryParser.parse("that guinea pig smells");
            assertThat(query, equalTo(expectedQuery));  
            + "  \"query_string\" : {\n"  
        if (randomBoolean()) {  
                .add(new TermQuery(new Term(TEXT_FIELD_NAME, "smells")), BooleanClause.Occur.MUST)
                break;
                    quoteAnalyzer = randomAnalyzer();  
        assertEquals("Cannot parse '*test': '*' or '?' not allowed as first character in WildcardQuery", ex.getCause().getMessage());  
        assertThat(queryBuilder, instanceOf(QueryStringQueryBuilder.class));  
            case 12:
            query = new QueryStringQueryBuilder("foo mapped_string:10").analyzer("whitespace")
    public void testCrossFields() throws Exception {
        );
        }
        assertThat(bQuery.clauses().size(), equalTo(2));
import java.util.HashMap;  
        }
    }  
import org.opensearch.test.AbstractQueryTestCase;  
                        defaultOp  
    public void testToQueryMultipleFieldsBooleanQuery() throws Exception {
            newInstance.analyzeWildcard(analyzeWildcard);
            QueryStringQueryBuilder queryBuilder = new QueryStringQueryBuilder("foo OR bar").field(TEXT_FIELD_NAME)
            + "}";  
            + "    \"type\" : \"best_fields\",\n"
                }  
            case 17:  
        assertTrue(e.getMessage().contains("would require more than 10000 effort"));
    }  
                                defaultOp
            .fuzzyPrefixLength(2)
        assertNotEquals(builder1, builder2);  
        queryStringQuery = queryStringQuery("((" + TEXT_FIELD_NAME + ":boosted^2) AND (" + TEXT_FIELD_NAME + ":foo^1.5))^3");
        query = queryStringQueryBuilder.toQuery(createShardContext());
            // simple with additional tokens  
    public void testToQueryPhraseQuery() throws IOException {
            query = queryParser.parse("+that -(guinea pig) +smells");  
                    quoteAnalyzer = null;
                .merge(
import org.apache.lucene.queries.spans.SpanOrQuery;
        newInstance.fields(fields);  
    }
                    tieBreaker += 0.05f;
import static org.hamcrest.Matchers.instanceOf;  
            "query should " + (cachingExpected ? "" : "not") + " be cacheable: " + qb.toString(),
                newIndexMeta(  
            assertQueryWithAllFieldsWildcard(query);
                defaultOp
                    timeZone = randomZone().getId();
     */  
    }
                LongPoint.newRangeQuery(DATE_FIELD_NAME, lower, upper),
            List.of(
                        new SpanNearQuery.Builder(TEXT_FIELD_NAME, true).addClause(new SpanTermQuery(new Term(TEXT_FIELD_NAME, "guinea")))  
        Query expected = new DisjunctionMaxQuery(  
        QueryStringQueryBuilder query = queryStringQuery("12~0.2").defaultField(INT_FIELD_NAME);
                );  
        queryStringQueryBuilder = new QueryStringQueryBuilder(query);
        XContentBuilder builder = JsonXContent.contentBuilder();  
                0.0f
            newInstance.minimumShouldMatch(minimumShouldMatch);
                }  
                new CompressedXContent(PutMappingRequest.simpleMapping("foo", "type=text", "_field_names", "enabled=false").toString()),
            List.of(  
        QueryShardContext context = createShardContext();
            .field("another_field")
        assertEquals(new MatchNoDocsQuery(""), query);
            + "        \"query\":\""
    /**  
    }
            disjuncts2.add(new TermQuery(new Term(TEXT_FIELD_NAME, "bar")));
            .startObject("properties")  
        // Now check what happens if the quote field does not exist
                    quoteFieldSuffix = randomAlphaOfLengthBetween(1, 3);
            Arrays.asList(
        assertThat(query, instanceOf(TermQuery.class));
                new BoostQuery(new TermQuery(new Term(TEXT_FIELD_NAME, "test")), 2.2f),
            .startObject("index_prefixes")  
        if (randomBoolean()) {  
        // if we hit a date field with "now", this should diable cachability
            case 2:
                        Settings.builder().putList("index.query.default_field", "*").build()
        QueryStringQueryBuilder query = queryStringQuery("2,3").defaultField(GEO_POINT_FIELD_NAME);  
                    )
        Query query = new QueryStringQueryBuilder("the* quick fox").field(TEXT_FIELD_NAME).analyzer("stop").toQuery(createShardContext());  
import org.opensearch.common.xcontent.json.JsonXContent;  
                    newIndexMeta(
    }  
    public void testIllegalArguments() {  
                        Settings.builder().putList("index.query.default_field", TEXT_FIELD_NAME, "*", KEYWORD_FIELD_NAME).build()
        assertThat(query, equalTo(expectedQuery));
        assertThat(query, instanceOf(BoostQuery.class));  
                } else {
                                new PrefixQuery(new Term(TEXT_FIELD_NAME, "foobar"), MultiTermQuery.CONSTANT_SCORE_REWRITE),
            context.isCacheable()
            case 14:
        Query query = new QueryStringQueryBuilder("quick fox").field(TEXT_FIELD_NAME)
        assertEquals(  
                fields.put(randomAlphaOfLength(10), 1.0f);
                .field(KEYWORD_FIELD_NAME);  
        assertEquals(expected, query);  
    public void testAllFieldsWildcard() throws Exception {
                    expectedEdits = 2;  
            + "    \"tie_breaker\" : 0.0,\n"
import java.time.ZoneId;  
import org.opensearch.lucene.queries.BlendedTermQuery;  
            queryParser.setForceAnalyzer(new MockSynonymAnalyzer());  
import org.hamcrest.CoreMatchers;
            queryParser.setMultiTermRewriteMethod(MultiTermQuery.CONSTANT_SCORE_REWRITE);
    public void testExistsFieldQuery() throws Exception {  
        Query query = queryStringQuery("*test").field("mapped_string").allowLeadingWildcard(true).toQuery(createShardContext());
        assertThat(query, equalTo(expected));  
        if (randomBoolean()) {  
            .add(new TermQuery(new Term(TEXT_FIELD_NAME, "quick")), Occur.SHOULD)
            List<Query> disjuncts = new ArrayList<>();
            .build();
        Fuzziness fuzziness = instance.fuzziness();
            BoostQuery boostQuery = (BoostQuery) query;
        assertEquals(expected, query);
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;  
        assertThat(booleanQuery.clauses().get(0).query(), equalTo(new TermQuery(new Term(TEXT_FIELD_NAME, "foo"))));
    public void testToQueryMatchAllQuery() throws Exception {
            e.getMessage()  
import org.apache.lucene.search.PrefixQuery;  
        e = expectThrows(TooComplexToDeterminizeException.class, () -> lenientQueryBuilder.toQuery(createShardContext()));  
                } else {
 *  
            .toQuery(createShardContext());
                .add(new Term(TEXT_FIELD_NAME, "pig"))
            assertThat(query, equalTo(new ConstantScoreQuery(new TermQuery(new Term("_field_names", TEXT_FIELD_NAME)))));
                )
    }
    }
                assertEquals(expectedEdits, fuzzyQuery.getMaxEdits());
    public void testToQueryDateWithTimeZone() throws Exception {
            );  
            ),  
                fields = new HashMap<>(fields);  
 */
            }  
                new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "test")))  
        try {  
            queryStringQueryBuilder.quoteAnalyzer(randomAnalyzer());
import org.apache.lucene.search.MatchNoDocsQuery;  
        int numTerms = randomIntBetween(0, 5);  
            "Can only use fuzzy queries on keyword and text fields - not on [mapped_int] which is of type [integer]",
            + "    \"fuzzy_prefix_length\" : 0,\n"
                break;
                break;  
import org.opensearch.core.xcontent.XContentBuilder;
        // Standard analyzer normalizes to lowercase, verifying the normalization path with currentFieldType.name() is hit
                .add(new TermQuery(new Term(TEXT_FIELD_NAME, "smells")), Occur.MUST)  
                pack(new long[] { upper }).bytes,
                    new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "foo"))),
        } else {  
        // Prefix
     * Validates that {@code max_determinized_states} can be parsed and lowers the allowed number of determinized states.  
                            .addTerm(new Term(TEXT_FIELD_NAME, "last"))
            + "}";
        Boolean analyzeWildcard = instance.analyzeWildcard();
        QueryShardContext context = createShardContext();
                assertThat(query, instanceOf(FuzzyQuery.class));  
        assertQueryCachability(queryStringQueryBuilder, true);  
            List.of(
            .field(KEYWORD_FIELD_NAME)  
                }
        queryStringQuery.boost(2.0f);  
        QueryStringQueryBuilder queryStringQueryBuilder = new QueryStringQueryBuilder("\"test phrase\"~2").field(TEXT_FIELD_NAME, 5f);
        Query query = queryStringQueryBuilder.toQuery(createShardContext());  
        assertEquals("[query_string] field name in [fields] cannot be null", e.getMessage());  
        assertEquals(expected, query);
                            defaultOp  
                    new SynonymQuery.Builder(TEXT_FIELD_NAME).addTerm(new Term(TEXT_FIELD_NAME, "first"))  
    public void testNullFieldInFieldsArray() throws IOException {  
        // Range  
            DisjunctionMaxQuery expectedQuery = new DisjunctionMaxQuery(disjuncts, 0.0f);
 * Modifications Copyright OpenSearch Contributors. See
                    defaultOp  
            int numFields = randomIntBetween(1, 5);
            disjuncts.add(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "foo bar"))));
        if (randomBoolean()) {  
        assert context.isCacheable();
            Query query = queryBuilder.toQuery(createShardContext());  
        }
        QueryStringQueryBuilder queryBuilder = queryStringQuery("/[ac]*a[ac]{50,200}/").defaultField(TEXT_FIELD_NAME);
        QueryStringQueryBuilder queryStringQueryBuilder = new QueryStringQueryBuilder(queryString).field(TEXT_FIELD_NAME)  
        }
                break;
            .endObject()
                )
                        new SynonymQuery.Builder(TEXT_FIELD_NAME).addTerm(new Term(TEXT_FIELD_NAME, "last"))  
        QueryShardContext context = createShardContext();  
        assertThat(boostQuery2.getQuery(), instanceOf(TermQuery.class));
                fuzzyMaxExpansions += 5;
                .build();
                    .build(),
                    len = randomIntBetween(6, 20);
    }  
        PhraseQuery expected = new PhraseQuery.Builder().add(new Term(TEXT_FIELD_NAME, "quick"))  
        assertEquals(9, noMatchNoDocsQueries);
        assertEquals(expected, query);
            .add(
import org.apache.lucene.search.DisjunctionMaxQuery;
            case 4:  
            String term = randomValueOtherThanMany(
import org.apache.lucene.search.WildcardQuery;  
            Arrays.fill(bytes, 'a');
                if (analyzeWildcard == null) {
            + "    \"fuzzy_max_expansions\" : 50,\n"
        query.lenient(true);
    public void testTimezone() throws Exception {
            disjuncts.add(bq1);
        int phraseSlop = instance.phraseSlop();  
            context.getIndexSettings()
    private ApproximateScoreQuery calculateExpectedDateQuery(long lower, long upper) {
            Query expected = new DisjunctionMaxQuery(
        String queryStringPrefix = "";  
                    allowLeadingWildCard = randomBoolean();
        }
                MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE
        boolean autoGenerateSynonymsPhraseQuery = instance.autoGenerateSynonymsPhraseQuery();  
        QueryShardContext shardContext = createShardContext();  
import org.apache.lucene.queries.spans.SpanTermQuery;  
                    queryStringQueryBuilder.field(fieldName, randomFloat());
            .toQuery(createShardContext());  
 */  
            Query query = queryParser.parse("guinea pig");
        switch (between(0, 23)) {  
        ).toQuery(createShardContext());
                MapperService.MergeReason.MAPPING_UPDATE
                break;  
        float[] boosts = new float[numBoosts + 1];
        }
        query = new QueryStringQueryBuilder("aBc~1").field(TEXT_FIELD_NAME).analyzer("standard").toQuery(createShardContext());
        if (randomBoolean()) {  
/*
        queryStringQuery.boost(2.0f);
                ),  
            cachingExpected,  
        newInstance.enablePositionIncrements(enablePositionIncrements);
            queryStringQueryBuilder.rewrite(getRandomRewriteMethod());
            for (int i = 0; i < numFields; i++) {
        }
            .fuzzyTranspositions(false)
            + "    \"enable_position_increments\" : true,\n"
        assertEquals(calculateExpectedDateQuery(lower + msPerHour, upper + msPerHour), qsq.timeZone("-01:00").toQuery(context));
            // `*` is in the list of the default_field => leniency set to true
            // Reset the default value
import org.apache.lucene.search.BooleanClause;
            QueryStringQueryParser queryParser = new QueryStringQueryParser(createShardContext(), TEXT_FIELD_NAME);
        QueryShardContext contextNoType = createShardContextWithNoType();
                                    .build(),
                if (fuzzyRewrite == null) {
                    minimumShouldMatch = randomMinimumShouldMatch();
            query = queryParser.parse("\"that guinea pig smells\"~2");
            queryParser.setAutoGenerateMultiTermSynonymsPhraseQuery(false);
                    defaultOp  
                "_doc",  
        assertThat(((TermQuery) boostQuery1.getQuery()).getTerm(), equalTo(new Term(TEXT_FIELD_NAME, "boosted")));
         */
            e.getMessage()
                .toQuery(createShardContext());
}
        Settings build = Settings.builder().put(oldIndexSettings).put(indexSettings).build();
import org.apache.lucene.search.BooleanClause.Occur;  
            queryStringQueryBuilder.fuzzyMaxExpansions(randomIntBetween(0, 100));
import org.apache.lucene.search.PhraseQuery;
        assertEquals(expected, query);
                    analyzeWildcard = randomBoolean() ? null : (analyzeWildcard == false);
                break;  
        if (quoteAnalyzer != null) {  
                        defaultOp
                ).add(new TermQuery(new Term(TEXT_FIELD_NAME, "cavy")), Occur.SHOULD).build(),  
        assertEquals(new MatchNoDocsQuery(""), query);
            newInstance.allowLeadingWildcard(allowLeadingWildCard);
                }  
    @Override
        );  
        }
        if (randomBoolean()) {  
        assertThat(boostQuery.getBoost(), equalTo(2.0f));
        assertEquals(  
            .build();
                0.0f  
    }
        assertTrue(e.getMessage().contains("Determinizing automaton"));
        {
                    new PhraseQuery.Builder().add(new Term(TEXT_FIELD_NAME, "two"), 0).add(new Term(TEXT_FIELD_NAME, "three"), 1).build(),  
    public void testExpandedTerms() throws Exception {
        boolean enablePositionIncrements = instance.enablePositionIncrements();
                assertThat(query, equalTo(new ConstantScoreQuery(new FieldExistsQuery(TEXT_FIELD_NAME))));  
            List<Query> disjuncts = new ArrayList<>();
            builder.endObject();  
                            )  
                .add(new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "last")), defaultOp))
        );  
            queryParser.setDefaultOperator(op.toQueryParserOperator());
        QueryBuilder queryBuilder = parseInnerQueryBuilder(createParser(builder));
        }
    }
        assertEquals(DisjunctionMaxQuery.class, query.getClass());  
        if (randomBoolean()) {  
                    Occur.SHOULD
            query = queryBuilder.toQuery(context);
                break;  
            queryParser.setAutoGenerateMultiTermSynonymsPhraseQuery(true);
            .endObject()
                            .build(),
     * Test that dissalowing leading wildcards causes exception
        }
import org.hamcrest.Matchers;
        QueryShardContext context = createShardContext();  
                    )
                        new SpanTermQuery(new Term(TEXT_FIELD_NAME, "cavy"))  
        query.lenient(true);
        }
            default:
        query = new QueryStringQueryBuilder("[aBc TO BcD]").field(TEXT_FIELD_NAME).analyzer("whitespace").toQuery(createShardContext());
        // if we hit all fields, this should contain a date field and should diable cachability
        queryStringQueryBuilder = new QueryStringQueryBuilder("now");
                            )
                        )
 * specific language governing permissions and limitations
        assertEquals(expected, query);  
    }
        expected = new BooleanQuery.Builder().add(new BooleanQuery.Builder().build(), BooleanClause.Occur.SHOULD).build();  
                new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "first")), defaultOp)  
                .add(new TermQuery(new Term(TEXT_FIELD_NAME, "pig")), defaultOp)  
            .fuzzyMaxExpansions(5)  
                    defaultField = defaultField + randomAlphaOfLength(5);
import org.apache.lucene.document.LongPoint;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        query.toQuery(context); // no exception
                )
        assertEquals(new MatchNoDocsQuery(), query);  
                }  
    public void testDefaultFuzziness() {  
            new QueryStringQueryBuilder("\"bar\"").quoteFieldSuffix("_2").field(TEXT_FIELD_NAME).doToQuery(context)
    }
            disjuncts.add(pq);
        query = queryStringQuery.toQuery(shardContext);  
            .toQuery(createShardContext());
        }  
        terms.add(new BoostQuery(new TermQuery(new Term(TEXT_FIELD_NAME, "first")), 0.075f));  
                        .add(new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "bar")), defaultOp))
        assertThat(phraseQuery.getSlop(), Matchers.equalTo(2));
 * KIND, either express or implied.  See the License for the
            .boost(mainBoost);
    }
                    expectedEdits = 0;
                .add(new Term(TEXT_FIELD_NAME, "guinea"))
            .type(MultiMatchQueryBuilder.Type.PHRASE)  
        assertThat(assertBooleanSubQuery(query, TermQuery.class, 0).getTerm(), equalTo(new Term(TEXT_FIELD_NAME, "test1")));  
        );
                        )  
        assertThat(booleanQuery.clauses().get(1).occur(), equalTo(BooleanClause.Occur.SHOULD));
        QueryStringQueryBuilder builder1 = new QueryStringQueryBuilder("bar");
        assertEquals(new Term(TEXT_FIELD_NAME, "aBc"), fuzzyQuery.getTerm());
    }  
    }
        // Default unmapped field
        if (tieBreaker != null) {  
        if (analyzeWildcard != null) {  
import static org.hamcrest.Matchers.containsString;
                pack(new long[] { lower }).bytes,
 * GitHub history for details.
            );
        if (randomBoolean()) {  
        context.getIndexSettings()
                Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,
                new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "foo")), BooleanClause.Occur.SHOULD)
            query = queryParser.parse("\"that guinea pig smells\"");
            builder.startObject("query_string");  
        assertThat(query, instanceOf(BoostQuery.class));
        // prefix
        TermQuery termQuery = (TermQuery) query;  
        queryStringQueryBuilder.field(DATE_FIELD_NAME);  
        assertThat(expectedQuery, equalTo(query));
                new TermQuery(new Term(TEXT_FIELD_NAME, "hello")),  
                defaultOp
    }
            final int expectedEdits;
            .merge(
        assertThat(query, instanceOf(BoostQuery.class));
        Query expected = new DisjunctionMaxQuery(  
                Query query = queryStringQuery(queryString + (j == 0 ? "~" : "~auto")).defaultField(TEXT_FIELD_NAME)
                assertThat(query, equalTo(new ConstantScoreQuery(new TermQuery(new Term("_field_names", TEXT_FIELD_NAME)))));
                default:
 * Unless required by applicable law or agreed to in writing,
                new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "test")))  
        if (analyzer != null) {  
import org.apache.lucene.util.BytesRef;
import java.util.Locale;
            {
            ),
                    queryStringQueryBuilder.field(fieldName);
        assertThat(boostQuery.getBoost(), equalTo(2.0f));
            .add(new Term(TEXT_FIELD_NAME, "fox"))
            assertThat(query, Matchers.equalTo(expectedQuery));  
        assertWarnings(FieldNamesFieldMapper.ENABLED_DEPRECATION_MESSAGE);
        }
import org.apache.lucene.queries.spans.SpanNearQuery;
            queryStringQueryBuilder.tieBreaker((float) randomDoubleBetween(0d, 1d, true));
            Query query = queryBuilder.toQuery(createShardContext());  
        Query expectedQuery = new MatchNoDocsQuery("empty fields");
    protected QueryStringQueryBuilder doCreateTestQueryBuilder() {
            )  
                } else {
        boolean fuzzyTranspositions = instance.fuzzyTranspositions();
        Query query = queryStringQuery("test").defaultField(TEXT_FIELD_NAME).toQuery(createShardContext());
                .add(new Term(TEXT_FIELD_NAME, "smells"))  
                case 1:
            assertEquals(expected, query);
            + "    \"default_operator\" : \"or\",\n"  
            BooleanQuery expectedQuery = new BooleanQuery.Builder().add(disjunctionMaxQuery, BooleanClause.Occur.SHOULD)  
    public void testCachingStrategiesWithNow() throws IOException {
            List<Query> disjuncts1 = new ArrayList<>();
        }
            assertThat(query, equalTo(expectedQuery));
            newInstance.defaultField(defaultField);
import static org.apache.lucene.document.LongPoint.pack;
            queryStringQueryBuilder.defaultField(defaultFieldName);
            new QueryStringQueryBuilder("bar").quoteFieldSuffix("_2").field(TEXT_FIELD_NAME).doToQuery(context)  
            case 0:
                if (rewrite == null) {  
                        .build(),
    }
        }  
    public void testAnalyzedPrefix() throws Exception {
        } finally {  
            .toQuery(createShardContext());
        int msPerHour = 3600000;  
            assertEquals(expected, query);
        RegexpQuery regexpQuery = (RegexpQuery) query;
    private static IndexMetadata newIndexMeta(String name, Settings oldIndexSettings, Settings indexSettings) {  
            case 7:
        QueryShardContext context = createShardContext();
            query = boostQuery.getQuery();  
            ),
                    new SpanOrQuery(
            .analyzer("stop")
        assertEquals(new PrefixQuery(new Term(TEXT_FIELD_NAME, "aBc"), MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE), query);
            + ":[2012 TO 2014]\"\n"
        try {  
 * under the License.  
                break;
                String fieldName = randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME, randomAlphaOfLengthBetween(1, 10));  
                    BlendedTermQuery.dismaxBlendedQuery(new Term[] { blendedTerms[0] }, 1.0f)
            query = new QueryStringQueryBuilder("hello").toQuery(context);
import org.apache.lucene.document.SortedNumericDocValuesField;
        QueryShardException e = expectThrows(QueryShardException.class, () -> query.toQuery(context));
        assertQueryCachability(queryStringQueryBuilder, false);
            expectedQuery = new SpanNearQuery.Builder(TEXT_FIELD_NAME, true).addClause(new SpanTermQuery(new Term(TEXT_FIELD_NAME, "that")))  
            ),
        query = queryBuilder.toQuery(contextNoType);  
                if (allowLeadingWildCard == null) {  
        if (randomBoolean()) {  
        query = new QueryStringQueryBuilder("aBc~1").field(TEXT_FIELD_NAME).analyzer("whitespace").toQuery(createShardContext());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(phraseQuery.getTerms().length, equalTo(2));
        assertThat(query, equalTo(expected));
        for (Operator op : Operator.values()) {
    }
        assertThat(query, instanceOf(RegexpQuery.class));  
            case 15:
        }
            + ":[2012 TO 2014]\"\n"  
            disjuncts.add(bq1);  
import org.apache.lucene.util.automaton.Automata;  
        int fuzzyPrefixLength = instance.fuzzyPrefixLength();
        try {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBooleanSubQuery;
            QueryStringQueryBuilder queryBuilder = new QueryStringQueryBuilder(">10 foo").field(INT_FIELD_NAME);  
    }
                new TermQuery(new Term(TEXT_FIELD_NAME, "test")),
            assertThat(query, Matchers.equalTo(expectedQuery));
                } else {
            .setSlop(2)  
 * this work for additional information regarding copyright
            queryStringQueryBuilder.fuzzyRewrite(getRandomRewriteMethod());
            queryStringQueryBuilder.fuzzyTranspositions(randomBoolean());
 * Licensed to Elasticsearch under one or more contributor  
                        .build(),
        String queryAsString = "{\n"
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
                        .addTerm(new Term(TEXT_FIELD_NAME, "first"))
        assertQueryWithAllFieldsWildcard(query);
                if (defaultField == null) {
            case 18:
        // Wildcard
        Query query = queryStringQuery("test").field(TEXT_FIELD_NAME, 2.2f).field(KEYWORD_FIELD_NAME).toQuery(createShardContext());
            () -> queryBuilder.toQuery(createShardContext())
        }
 *
            query = queryParser.parse("guinea pig");
                } else {  
    public void testDefaultFieldsWithFields() throws IOException {
         * We use a private rewrite context here since we want the most realistic way of asserting that we are cacheable or not. We do it
            QueryStringQueryParser queryParser = new QueryStringQueryParser(createShardContext(), TEXT_FIELD_NAME);  
            queryStringSuffix += ")^" + boost;  
    }  
            PhraseQuery pq1 = new PhraseQuery.Builder().add(new Term(TEXT_FIELD_NAME, "that"))  
        );
            case 19:
import org.apache.lucene.search.Query;
                escape = (escape == false);
    private void assertQueryWithAllFieldsWildcard(Query query) {
        if (randomBoolean()) {
        query.lenient(true);
        QueryShardException ex = expectThrows(
    }
        QueryBuilder rewritten = rewriteQuery(qb, new QueryShardContext(context));
    }
                .updateIndexMetadata(  
    }
            disjuncts.add(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "foo bar"))));  
        assertEquals(expected, query);
        BoostQuery boostQuery = (BoostQuery) query;
            new TermQuery(new Term(TEXT_FIELD_NAME, "bar")),
                .build();
        Boolean allowLeadingWildCard = instance.allowLeadingWildcard();
        newInstance.fuzzyMaxExpansions(fuzzyMaxExpansions);
            .toQuery(createShardContext());
                }  
        BoostQuery boostQuery = (BoostQuery) query;
     */  
     */
            + "    \"query_string\":{\n"
        query = new QueryStringQueryBuilder("unmapped_field:hello").lenient(true).toQuery(createShardContext());
        QueryStringQueryBuilder lenientQueryBuilder = queryStringQuery("/[ac]*a[ac]{50,200}/").defaultField(TEXT_FIELD_NAME).lenient(true);
            }  
                break;
            assertThat(query, Matchers.equalTo(expectedQuery));  
            hasItems(
        assertThat(query, instanceOf(ApproximateScoreQuery.class));
                            .addClause(new SpanTermQuery(new Term(TEXT_FIELD_NAME, "pig")))
    @Override
            ).add(new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "bar")), BooleanClause.Occur.SHOULD)).build();  
        // Unmapped fields
            query
        }
        Query query = queryStringQuery.toQuery(shardContext);
            assertThat(query, Matchers.equalTo(expectedQuery));  
        int noMatchNoDocsQueries = 0;
            QueryStringQueryBuilder queryBuilder = new QueryStringQueryBuilder("foo bar").field(TEXT_FIELD_NAME).field(KEYWORD_FIELD_NAME);
import org.opensearch.search.approximate.ApproximateScoreQuery;
                .build();
                    new CompressedXContent(PutMappingRequest.simpleMapping("foo", "type=text", "_field_names", "enabled=true").toString()),  
            // throws an exception when lenient is set to false
        assertEquals(new TermRangeQuery(TEXT_FIELD_NAME, new BytesRef("aBc"), new BytesRef("BcD"), true, true), query);
                maxDeterminizedStates += 5;
        mapperService.merge("_doc", new CompressedXContent(mapping.toString()), MapperService.MergeReason.MAPPING_UPDATE);
        );
            queryStringQueryBuilder.fuzzyPrefixLength(randomIntBetween(0, 10));
        for (Operator op : Operator.values()) {  
                new TermQuery(new Term(TEXT_FIELD_NAME, "test")),
            .toQuery(createShardContext());
            ),
        assertEquals(expected, query);
        newInstance.fuzzyTranspositions(fuzzyTranspositions);
        assertEquals(
        for (Operator op : Operator.values()) {
        for (int i = boosts.length - 1; i >= 0; i--) {
public class QueryStringQueryBuilderTests extends AbstractQueryTestCase<QueryStringQueryBuilder> {  
        query = new QueryStringQueryBuilder("hello").field(TEXT_FIELD_NAME).field("*").field(KEYWORD_FIELD_NAME).toQuery(context);  
            assertThat(query, instanceOf(BoostQuery.class));  
                new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "test")))
import java.time.DateTimeException;
                        "index",
                .add(  
                                    .addTerm(new Term(TEXT_FIELD_NAME, "bar"))  
            )
        QueryStringQueryBuilder queryStringQueryBuilder = (QueryStringQueryBuilder) queryBuilder;
        if (randomBoolean()) {  
        );  
        }
     * the quote analyzer should overwrite any other forced analyzer in quoted parts of the query
            PhraseQuery pq = new PhraseQuery.Builder().add(new Term(TEXT_FIELD_NAME, "foo")).add(new Term(TEXT_FIELD_NAME, "bar")).build();  
                if (timeZone == null) {
                new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "hello")))
        Query query = queryStringQuery("test").field(TEXT_FIELD_NAME).field(KEYWORD_FIELD_NAME).toQuery(createShardContext());
            new BooleanQuery.Builder().add(
import org.apache.lucene.search.MatchAllDocsQuery;
                .addClause(new SpanTermQuery(new Term(TEXT_FIELD_NAME, "smells")))  
            QueryStringQueryParser queryParser = new QueryStringQueryParser(createShardContext(), TEXT_FIELD_NAME);  
        assertThat(assertBooleanSubQuery(query, TermQuery.class, 1).getTerm(), equalTo(new Term(TEXT_FIELD_NAME, "test2")));
            context.getMapperService()  
    }
            queryParser.setAnalyzeWildcard(true);  
        assertEquals(new Term(TEXT_FIELD_NAME, "abc"), fuzzyQuery.getTerm());
        boostQuery = (BoostQuery) query;  
        Query query = new QueryStringQueryBuilder("quick* @&*").field(TEXT_FIELD_NAME)  
        }
            queryParser.setMultiTermRewriteMethod(MultiTermQuery.CONSTANT_SCORE_REWRITE);
            .updateIndexMetadata(
        assertThat(termQuery.getTerm(), equalTo(new Term(TEXT_FIELD_NAME, "test")));
            disjunctionMaxQuery.getDisjuncts(),
            + "  \"query_string\" : {\n"
            float boost = 2.0f / randomIntBetween(3, 20);  
        } finally {
                throw new AssertionError("Illegal randomisation branch");
    }
    }  
                break;
            DisjunctionMaxQuery maxQuery1 = new DisjunctionMaxQuery(disjuncts1, 0.0f);
        QueryShardContext context = createShardContext();
    public void testToFuzzyQuery() throws Exception {  
        assertThat(boostQuery.getQuery(), instanceOf(PhraseQuery.class));  
            .startObject("prefix_field")
                builder.field("query", "/[ac]*a[ac]{1,10}/");
    }
            + "  }\n"
            assertThat(query, equalTo(new ConstantScoreQuery(new FieldExistsQuery(TEXT_FIELD_NAME))));
        return queryStringQueryBuilder;
        int numBoosts = randomIntBetween(2, 10);
        query = new QueryStringQueryBuilder("\"quick fox\"~2").field(TEXT_FIELD_NAME).phraseSlop(10).toQuery(createShardContext());
                    if (randomBoolean()) {
            ),
            queryStringQueryBuilder.phraseSlop(randomIntBetween(0, 10));
    public void testUnmappedFieldRewriteToMatchNoDocs() throws IOException {
            queryParser.setAutoGenerateMultiTermSynonymsPhraseQuery(false);
    public void testDisabledFieldNamesField() throws Exception {
                    .add(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "fox"))), Occur.SHOULD)  
        assertThat(query, instanceOf(BooleanQuery.class));  
            newInstance.timeZone(timeZone);
            queryParser.setMultiTermRewriteMethod(MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE);
        QueryShardContext context = createShardContext();
        Operator operator = instance.defaultOperator();  
            if (q.getClass() == MatchNoDocsQuery.class) {
        String quoteFieldSuffix = instance.quoteFieldSuffix();
        assertEquals(expected, query);
                        new BooleanQuery.Builder().add(guineaPig, Occur.SHOULD).add(cavy, Occur.SHOULD).build(),
        }  
import java.io.IOException;
    public void testPrefixNumeric() throws Exception {
                )
                enablePositionIncrements = (enablePositionIncrements == false);
            + "    \"boost\" : 1.0\n"
                    )
        }
            .add(new MatchNoDocsQuery(), BooleanClause.Occur.MUST)  
            + "        \"time_zone\":\"This timezone does not exist\",\n"  
        }
                .toQuery(createShardContext())
        BoostQuery boostQuery2 = assertBooleanSubQuery(boostQuery.getQuery(), BoostQuery.class, 1);
            assertEquals(expected, query);
            }
                    new BooleanQuery.Builder().add(  
            queryBuilder.type(MultiMatchQueryBuilder.Type.PHRASE);
            blendedTerms[1] = new Term(KEYWORD_FIELD_NAME, "foo");  
        expectThrows(DateTimeException.class, () -> parseQuery(invalidQueryAsString));  
            // also avoid "now" since we might hit dqte fields later and this complicates caching checks
                } else {
                    newIndexMeta(  
        assertThat(query, instanceOf(MatchAllDocsQuery.class));  
                        context.getIndexSettings().getSettings(),  
                    context.getIndexSettings().getSettings(),
                MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE
    }  
            Query expected = new DisjunctionMaxQuery(
                } else {  
    public void testToQueryBooleanQueryMultipleBoosts() throws Exception {  
            + "}";  
            Query query = queryBuilder.toQuery(context);
            DisjunctionMaxQuery expectedQuery = new DisjunctionMaxQuery(disjuncts, 0.0f);  
import org.apache.lucene.index.Term;  
            + DATE_FIELD_NAME
            char[] bytes = new char[len];  
         * actual lucene query  
    }  
        query = new BoolQueryBuilder().should(  
                .build();  
    public void testToQueryDisMaxQuery() throws Exception {  
            final int len;  
            () -> queryBuilder.toQuery(createShardContext())
                .build();
            + "    \"auto_generate_synonyms_phrase_query\" : true,\n"
                FuzzyQuery fuzzyQuery = (FuzzyQuery) query;
            .add(new Term(TEXT_FIELD_NAME, "fox"))  
            + "        \"query\":\""  
            BooleanClause.Occur defaultOp = op.toBooleanClauseOccur();
        assertNull(queryStringQueryBuilder.fuzziness());
    public void testToQueryRegExpQueryMaxDeterminizedStatesParsing() throws Exception {
            new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "ONE")), Occur.SHOULD)
            .analyzeWildcard(true)
                    "index",
                    newIndexMeta(
        Query expectedQuery = new ConstantScoreQuery(new TermQuery(new Term("prefix_field._index_prefix", "foo")));
            .add(new Term(TEXT_FIELD_NAME, "fox"))
            .analyzer("stop")  
                } else {  
        }
                    minimumShouldMatch = null;  
        assertThat(booleanQuery.getMinimumNumberShouldMatch(), equalTo(2));
            .analyzer("stop")
        );
        // Term  
                .add(
        newInstance.defaultOperator(operator);
                new Term(TEXT_FIELD_NAME, "aBc*D"),  
            .quoteAnalyzer("simple")
    public void testToQueryRegExpQuery() throws Exception {
                break;  
    public void testMergeBoosts() throws IOException {  
        QueryStringQueryBuilder queryStringQueryBuilder = new QueryStringQueryBuilder(query);
        expectThrows(IllegalArgumentException.class, () -> new QueryStringQueryBuilder((String) null));
            new WildcardQuery(
        }
        QueryStringQueryBuilder queryBuilder = new QueryStringQueryBuilder(TEXT_FIELD_NAME + ":*");
        );  
        }
            case 5:  
        newInstance.fuzziness(fuzziness);
    }
                .build();
                    fuzzyRewrite = getRandomRewriteMethod();  
        }
                        )
        return new ApproximateScoreQuery(  
        }
            List<Query> disjuncts = new ArrayList<>();
    }
        if ((context.getMapperService().fieldType(TEXT_FIELD_NAME).getTextSearchInfo().hasNorms())) {
        QueryStringQueryBuilder builder2 = new QueryStringQueryBuilder("foo");
                break;  
            .toQuery(createShardContext());
     * Query terms that contain "now" can trigger a query to not be cacheable.
        QueryStringQueryParser queryParser = new QueryStringQueryParser(createShardContext(), TEXT_FIELD_NAME);  
        assertNotNull(rewritten.toQuery(context));  
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder("aBc*").field("field").defaultField("*");  
    }
        }
        }
            queryParser.setAnalyzeWildcard(true);  
            new ApproximatePointRangeQuery(
            .toQuery(createShardContext());
    }  
                break;
                .toQuery(createShardContext());
            0
                query = query + " foo";
                .build();
            Query expectedQuery = new BooleanQuery.Builder().add(
            Query query = queryBuilder.toQuery(createShardContext());  
        final QueryShardContext context = createShardContext();  
            .build();
        Query query = new QueryStringQueryBuilder("ONE \"TWO THREE\"").field(TEXT_FIELD_NAME)  
        for (int i = 0; i < boosts.length - 1; i++) {
        Query query = new QueryStringQueryBuilder("hello").field(INT_FIELD_NAME).lenient(true).toQuery(createShardContext());
        }
                        timeZone = randomValueOtherThan(timeZone, () -> randomZone().getId());
        Query query = new QueryStringQueryBuilder("text~2").field(TEXT_FIELD_NAME)
/*  
            disjuncts.add(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "foo bar"))));
    }  
                    }
        assertThat(phraseQuery.getTerms().length, equalTo(2));  
                    ).build(),  
        }
        assertEquals(
            expectedQuery = new BooleanQuery.Builder().add(
        assertThat(((TermQuery) boostQuery.getQuery()).getTerm(), equalTo(new Term(TEXT_FIELD_NAME, "boosted")));
                .build();
                );
            assertThat(query, Matchers.equalTo(expectedQuery));
            DisjunctionMaxQuery maxQuery2 = new DisjunctionMaxQuery(disjuncts2, 0.0f);
            .startObject("_doc")
            0
import org.opensearch.cluster.metadata.IndexMetadata;
            QueryStringQueryBuilder queryBuilder = new QueryStringQueryBuilder("foo bar").field(TEXT_FIELD_NAME).field(KEYWORD_FIELD_NAME);
            // we only use string fields (either mapped or unmapped)  
                        timeZone = null;
    /**
                SortedNumericDocValuesField.newSlowRangeQuery(DATE_FIELD_NAME, lower, upper)  
            .field(TEXT_FIELD_NAME, 0.3f)
        PhraseQuery phraseQuery = (PhraseQuery) boostQuery.getQuery();
            0
        } else {  
            QueryShardException.class,
                if (minimumShouldMatch == null) {  
        for (boolean quoted : new boolean[] { true, false }) {
            .toQuery(createShardContext());  
        expectedQuery = new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "foo")), Occur.SHOULD)  
                    rewrite = null;  
        if (allowLeadingWildCard != null) {  
                noMatchNoDocsQueries++;
 * compatible open source license.
                if (tieBreaker == null) {
        // everything else is fine on all fields  
            + "    }\n"
 * this file be licensed under the Apache-2.0 license or a
                .add(new TermQuery(new Term(TEXT_FIELD_NAME, "guinea")), BooleanClause.Occur.MUST_NOT)
        queryParser.setMultiTermRewriteMethod(MultiTermQuery.CONSTANT_SCORE_REWRITE);
            }
        query = new QueryStringQueryBuilder("aBc*D").field(TEXT_FIELD_NAME).analyzer("standard").toQuery(createShardContext());  
                    newIndexMeta(
        // nothing yet, put additional assertions here.
                .field(KEYWORD_FIELD_NAME);
import org.apache.lucene.util.automaton.Automaton;
        query.toQuery(context); // no exception
 * the Apache License, Version 2.0 (the "License"); you may
        if (defaultField != null) {  
    public void testToQueryFuzzyQueryAutoFuzziness() throws Exception {
            ),  
            assertThat(query, Matchers.equalTo(expectedQuery));  
        );  
        QueryStringQueryBuilder queryStringQueryBuilder = new QueryStringQueryBuilder(TEXT_FIELD_NAME).fuzziness(null);
            .defaultOperator(Operator.AND)  
            .build();
                if (quoteFieldSuffix == null) {
        Query query = new QueryStringQueryBuilder("hello").field("unmapped_field").lenient(true).toQuery(createShardContext());  
    }
        queryBuilder = new QueryStringQueryBuilder("*");
    public void testToQueryRegExpQueryTooComplex() throws Exception {  
                new TermQuery(new Term(TEXT_FIELD_NAME, "test")),
        assertNotEquals(builder1, builder2);  
import org.apache.lucene.tests.analysis.MockSynonymAnalyzer;
                fuzzyPrefixLength += 5;
            queryStringQueryBuilder.analyzeWildcard(randomBoolean());
            boosts[i] = boost;
                .add(new TermQuery(new Term(TEXT_FIELD_NAME, "other")), BooleanClause.Occur.SHOULD)
    public QueryStringQueryBuilder mutateInstance(QueryStringQueryBuilder instance) throws IOException {
    public void testLenientRewriteToMatchNoDocs() throws IOException {
            .build();
 * not use this file except in compliance with the License.
                    fuzzyRewrite = null;
        String rewrite = instance.rewrite();
    public void testFromJson() throws IOException {
        Query query = queryParser.parse("/aBc.*/");
            QueryStringQueryBuilder queryBuilder = new QueryStringQueryBuilder("mapped_string:other foo bar").field(TEXT_FIELD_NAME)
        Query expected = new DisjunctionMaxQuery(terms, 1.0f);
            // simple multi-term with phrase query  
                operator = randomValueOtherThan(operator, () -> randomFrom(Operator.values()));
        String queryAsString = "{\n"  
            Query expectedQuery = new BooleanQuery.Builder().add(
        assertEquals(expected, query);  
            disjuncts1.add(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "foo"))));
            new TermQuery(new Term(TEXT_FIELD_NAME, "bar")),  
                .add(new BooleanClause(maxQuery2, BooleanClause.Occur.SHOULD))
                    .build()
        assertEquals(expected, query);
            queryParser.setDefaultOperator(op.toQueryParserOperator());
        float mainBoost = 2.0f / randomIntBetween(3, 20);
        context.getMapperService()
            case 13:
    }  
        // TooComplexToDeterminizeException should be thrown even if lenient is true
        assertEquals(expected, query);
        }
            disjuncts2.add(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "bar"))));  
            queryStringQueryBuilder.autoGenerateSynonymsPhraseQuery(randomBoolean());
        }  
        }
import org.opensearch.index.search.QueryStringQueryParser;
        Query query = queryStringQueryBuilder.toQuery(createShardContext());
                new AutomatonQuery(new Term("prefix_field._index_prefix", "g*"), a, false, MultiTermQuery.CONSTANT_SCORE_REWRITE),
        {
        );  
            Query query = queryParser.parse("first foo-bar-foobar* last");
        assertThat(query, instanceOf(BooleanQuery.class));  
import org.apache.lucene.search.ConstantScoreQuery;  
        String queryStringSuffix = "";
                builder.field("max_determinized_states", 10);
            // Reset the default value
                )
        assertEquals(new BooleanQuery.Builder().build(), query);
                    MapperService.MergeReason.MAPPING_UPDATE
                            new BooleanQuery.Builder().add(  
                if (quoteAnalyzer == null) {
                Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,
            newInstance.quoteFieldSuffix(quoteFieldSuffix);
            String queryString = new String(bytes);
            // simple multi-term  
                } else {  
            .analyzer("whitespace")
            + "    \"default_field\" : \"content\",\n"
                                new BooleanClause(new PrefixQuery(new Term(TEXT_FIELD_NAME, "foobar")), BooleanClause.Occur.SHOULD)
                .field(KEYWORD_FIELD_NAME)  
        // Unmapped prefix field  
        String minimumShouldMatch = instance.minimumShouldMatch();
        assertThat(boostQuery.getBoost(), equalTo(2.0f));  
        if (randomBoolean()) {  
            new IndexOrDocValuesQuery(
                new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "foo")), BooleanClause.Occur.SHOULD)  
    @Override  
        query = new QueryStringQueryBuilder("aBc*").field(TEXT_FIELD_NAME).analyzer("standard").toQuery(createShardContext());
            blendedTerms[0] = new Term(TEXT_FIELD_NAME, "foo");
            queryParser.setDefaultOperator(op.toQueryParserOperator());  
        assertEquals(new MatchNoDocsQuery(""), query);  
        boostQuery = (BoostQuery) boostQuery.getQuery();
        }
            + "    }\n"  
        Query query = queryStringQuery("/foo*bar/").defaultField(TEXT_FIELD_NAME).maxDeterminizedStates(5000).toQuery(createShardContext());
            disjuncts1.add(new TermQuery(new Term(TEXT_FIELD_NAME, "foo")));  
                    new TermQuery(new Term(TEXT_FIELD_NAME, "hello")),  
        query = new QueryStringQueryBuilder("hello~2").field(INT_FIELD_NAME).lenient(true).toQuery(createShardContext());  
     */  
        checkGeneratedJson(json, parsed);  
 *     http://www.apache.org/licenses/LICENSE-2.0
        Query query = new QueryStringQueryBuilder("hello").field("*").toQuery(context);  
        QueryShardContext context = createShardContext();
            // min length 4 makes sure that the text is not an operator (AND/OR) so toQuery won't break  
                } else {  
        Query query = queryStringQuery("test").field("mapped_str*").toQuery(createShardContext());
            queryParser.setAnalyzeWildcard(true);
        query = queryBuilder.toQuery(context);  
        QueryStringQueryBuilder parsed = (QueryStringQueryBuilder) parseQuery(json);
    public void testEnablePositionIncrement() throws Exception {  
            new TermQuery(new Term(TEXT_FIELD_NAME, "bar")),
import org.opensearch.common.unit.Fuzziness;
        assertEquals(
package org.opensearch.index.query;
    public void testToQueryWildcardNonExistingFields() throws IOException {  
            } else {
        if (randomBoolean()) {  
    public void testToQueryBoosts() throws Exception {
 * You may obtain a copy of the License at  
        assertThat(query, instanceOf(BoostQuery.class));  
                .build();  
            new PrefixQuery(new Term(TEXT_FIELD_NAME, "the"), MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE),
                new BooleanClause(
                Arrays.asList(  
        assertEquals(  
        queryParser.setForceAnalyzer(new org.apache.lucene.analysis.standard.StandardAnalyzer());
                break;
            .add(new TermQuery(new Term(TEXT_FIELD_NAME, "fox")), Occur.SHOULD)  
            context.getIndexSettings()
        }
                .addClause(
            TermQuery cavy = new TermQuery(new Term(TEXT_FIELD_NAME, "cavy"));  
            ).build();
            Term[] blendedTerms = new Term[2];
        {
            BooleanClause.Occur defaultOp = op.toBooleanClauseOccur();
            e.getMessage()
            String value = (quoted ? "\"" : "") + TEXT_FIELD_NAME + (quoted ? "\"" : "");
        TooComplexToDeterminizeException e = expectThrows(  
                .build();
            queryStringQueryBuilder.quoteFieldSuffix(randomAlphaOfLengthBetween(1, 3));
        );
            + "    \"query\" : \"test\",\n"  
        );
            );
            () -> queryStringQuery("*test").field("mapped_string").allowLeadingWildcard(false).toQuery(createShardContext())  
import org.apache.lucene.search.TermRangeQuery;
    }
            0
        Query query = queryStringQueryBuilder.toQuery(createShardContext());
        // Multi block
        // Fuzzy
                .type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)  
                s -> s.toLowerCase(Locale.ROOT).contains("now"),  
import org.opensearch.core.common.ParsingException;
        RegexpQuery regexpQuery = (RegexpQuery) query;
            BooleanClause.Occur defaultOp = op.toBooleanClauseOccur();
        QueryBuilder queryBuilder = parseQuery(queryAsString);
    public void testToQueryPhraseQueryBoostAndSlop() throws IOException {  
import java.util.List;
        Query query = new QueryStringQueryBuilder("aBc*").field(TEXT_FIELD_NAME).analyzer("whitespace").toQuery(createShardContext());  
                )  
        );  
                return changeNameOrBoost(instance);  
                } else {
                        new BooleanClause(
                                .build(),
                                defaultOp
        FuzzyQuery expected = new FuzzyQuery(new Term(TEXT_FIELD_NAME, "text"), 2, 2, 5, false);  
        if (randomBoolean()) {  
import org.opensearch.common.settings.Settings;
                    rewrite = getRandomRewriteMethod();
                    Settings.builder().putList("index.query.default_field", TEXT_FIELD_NAME, KEYWORD_FIELD_NAME).build()  
        expectedQuery = new ConstantScoreQuery(  
            queryParser.setDefaultOperator(op.toQueryParserOperator());  
                .add(new Term(TEXT_FIELD_NAME, "cavy"))
        newInstance.phraseSlop(phraseSlop);  
            Query query = new QueryStringQueryBuilder("foo").analyzer("whitespace")
            queryParser.setAnalyzeWildcard(true);
            .toQuery(createShardContext());
            case 11:
            + "    \"fuzziness\" : \"AUTO\",\n"  
        newInstance.fuzzyPrefixLength(fuzzyPrefixLength);
                            new SynonymQuery.Builder(TEXT_FIELD_NAME).addTerm(new Term(TEXT_FIELD_NAME, "foo"))  
                break;
        Query query = queryStringQuery("\"term1 term2\"").defaultField(TEXT_FIELD_NAME).phraseSlop(3).toQuery(createShardContext());
        assertEquals(
        queryStringQueryBuilder.type(randomFrom(MultiMatchQueryBuilder.Type.values()));  
            case 6:
                .build();
            () -> new QueryStringQueryBuilder("the quick fox").field(TEXT_FIELD_NAME, -1.0f)
    }
            QueryStringQueryBuilder queryBuilder = new QueryStringQueryBuilder("foo:*");  
        for (int i = 0; i < 3; i++) {
        // Prefix
        builder.endObject();
            assertThat(query, Matchers.equalTo(expectedQuery));
        Query query = queryStringQuery("test").field(TEXT_FIELD_NAME).field(KEYWORD_FIELD_NAME).toQuery(createShardContext());
                )
            .build();
            )
        assertEquals(new PrefixQuery(new Term(TEXT_FIELD_NAME, "abc"), MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE), query);  
    public void testAllowLeadingWildcard() throws Exception {
import org.apache.lucene.search.SynonymQuery;  
            queryStringQueryBuilder.defaultOperator(randomFrom(Operator.values()));  
        }
            case 20:  
    public void testDefaultField() throws Exception {  
        expected = new BooleanQuery.Builder().add(new MatchNoDocsQuery(), BooleanClause.Occur.MUST)
    protected void doAssertLuceneQuery(QueryStringQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
        BooleanQuery expected = new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "first")), BooleanClause.Occur.MUST)
            if ((context.getMapperService().fieldType(TEXT_FIELD_NAME).getTextSearchInfo().hasNorms())) {
                        .add(
        assertThat(exc.getMessage(), CoreMatchers.containsString("negative [boost]"));  
        PhraseQuery expected = new PhraseQuery.Builder().add(new Term(TEXT_FIELD_NAME, "quick"))
                new BooleanClause(
                break;
        return newInstance;  
            expectedQuery = new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "that")), Occur.MUST)
                    defaultField = randomAlphaOfLengthBetween(1, 10);  
            case 9:
        int maxDeterminizedStates = instance.maxDeterminizedStates();  
                break;
        assertThat(boostQuery.getQuery(), instanceOf(TermQuery.class));  
            BooleanQuery bq1 = new BooleanQuery.Builder().add(
                .updateIndexMetadata(  
        {
        assertEquals("Failed to parse query [*test]", ex.getMessage());
import org.apache.lucene.search.RegexpQuery;
    public void testPhraseSlop() throws Exception {
        Automaton a = Operations.concatenate(Arrays.asList(Automata.makeChar('g'), Automata.makeAnyChar()));
        }
                            new BooleanClause(
        assertThat(boostQuery.getQuery(), instanceOf(BoostQuery.class));
    }
            newInstance.rewrite(rewrite);
import org.apache.lucene.search.IndexOrDocValuesQuery;
            query
    public void testQuoteFieldSuffix() throws IOException {
        QueryStringQueryBuilder queryStringQueryBuilder = new QueryStringQueryBuilder("foo bar").field("invalid*");
                    "_doc",
                );  
            Occur.SHOULD  
        builder.startObject();
                break;
        assertEquals(json, "content", parsed.defaultField());  
                    new BooleanQuery.Builder().add(new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "foo")), defaultOp))  
        // default value `*` sets leniency to true
        assertEquals(expected, query);  
                .setSlop(2)
        // type=phrase
        Query query = new QueryStringQueryBuilder("hello").toQuery(context);  
        assertEquals(json, false, parsed.fuzzyTranspositions());
        String query = "";
        Query query = queryStringQuery("*:*").toQuery(createShardContext());
        for (Query q : disjunctionMaxQuery.getDisjuncts()) {  
import org.opensearch.common.compress.CompressedXContent;  
                }
            BooleanQuery bq1 = new BooleanQuery.Builder().add(
            case 21:
                if (analyzer == null) {
        query = queryParser.parse("g*");
        BoostQuery boostQuery1 = assertBooleanSubQuery(boostQuery.getQuery(), BoostQuery.class, 0);
    }  
        PhraseQuery phraseQuery = (PhraseQuery) query;
    }
            assertThat(query, Matchers.equalTo(expectedQuery));  
    }  
            Query query = queryParser.parse("first foo-bar-foobar* last");
                    len = randomIntBetween(1, 2);
            )
                if (randomBoolean()) {
 *
    }
        XContentBuilder mapping = jsonBuilder().startObject()
                () -> randomAlphaOfLengthBetween(4, 10)
                .build();
                new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "test")))  
                    Occur.SHOULD
            case 10:
        assertThat(boostQuery1.getBoost(), equalTo(2.0f));
            assertThat(exc.getMessage(), equalTo("For input string: \">10 foo\""));
            List.of(
import org.apache.lucene.util.automaton.TooComplexToDeterminizeException;  
        assertThat(queryStringQueryBuilder.timeZone(), equalTo(ZoneId.of("Europe/Paris")));
            + "    \"max_determinized_states\" : 10000,\n"
        assertEquals(expectedQuery, query);
        Query expected = new DisjunctionMaxQuery(
            queryStringQueryBuilder.allowLeadingWildcard(randomBoolean());
            "Geometry fields do not support exact searching, use dedicated geometry queries instead: " + "[mapped_geo_point]",
        if (randomBoolean()) {  
        assertThat(boostQuery1.getQuery(), instanceOf(TermQuery.class));  
            // restore mappings as they were before
                fuzzyTranspositions = (fuzzyTranspositions == false);  
import java.util.Arrays;
                                .add(new BooleanClause(new PrefixQuery(new Term(TEXT_FIELD_NAME, "foobar")), BooleanClause.Occur.SHOULD))  
            PhraseQuery pq2 = new PhraseQuery.Builder().add(new Term(TEXT_FIELD_NAME, "that"))  
    private void assertQueryCachability(QueryStringQueryBuilder qb, boolean cachingExpected) throws IOException {  
        assertEquals(calculateExpectedDateQuery(lower, upper), query);
                                .build(),
         * this way in SearchService where we first rewrite the query with a private context, then reset the context and then build the
import org.apache.lucene.util.automaton.Operations;
        Query query = qsq.toQuery(context);
        String defaultField = instance.defaultField();
        if (rewrite != null) {  
            ).add(new TermQuery(new Term("prefix_field", "g")), Occur.SHOULD).build()
        assertThat(boostQuery.getBoost(), equalTo(2.0f));  
        }
                .add(new TermQuery(new Term(TEXT_FIELD_NAME, "10")), Occur.SHOULD)  
 * The OpenSearch Contributors require contributions made to  
        assertThat(phraseQuery.getTerms()[1], equalTo(new Term(TEXT_FIELD_NAME, "term2")));
                            .build(),
        assertQueryCachability(queryStringQueryBuilder, false);
        }
    public void testToQueryFieldsWildcard() throws Exception {
        assertThat(booleanQuery.clauses().get(1).query(), equalTo(new TermQuery(new Term(TEXT_FIELD_NAME, "bar"))));  
    public void testToQueryTextParsing() throws IOException {  
                    )
        assertEquals(expected, query);
    public void testFuzzyNumeric() throws Exception {  
            expectedQuery = new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "that")), defaultOp)
        String query = "now " + randomAlphaOfLengthBetween(4, 10);  
                .setSlop(2)  
                case 0:  
            .field(TEXT_FIELD_NAME.substring(0, TEXT_FIELD_NAME.length() - 2) + "*", 0.5f)  
            new QueryStringQueryBuilder("the").field(TEXT_FIELD_NAME).field(KEYWORD_FIELD_NAME).analyzer("stop")
        expected = new DisjunctionMaxQuery(  
            .toQuery(createShardContext());
    }
        builder2.timeZone("Europe/London");
        IllegalArgumentException exc = expectThrows(  
                fuzziness = randomValueOtherThan(fuzziness, () -> randomFrom(Fuzziness.AUTO, Fuzziness.ZERO, Fuzziness.ONE, Fuzziness.TWO));
                new Term(TEXT_FIELD_NAME, "abc*d"),  
                                new SynonymQuery.Builder(TEXT_FIELD_NAME).addTerm(new Term(TEXT_FIELD_NAME, "bar"))
        query = new QueryStringQueryBuilder("quick fox").field(TEXT_FIELD_NAME)
            + "    \"escape\" : false,\n"
        );  
            .field("another_unmapped")
        assertThat(((TermQuery) boostQuery2.getQuery()).getTerm(), equalTo(new Term(TEXT_FIELD_NAME, "foo")));
            ).build();
                }
        /*  
            .minimumShouldMatch("2")
        builder1.timeZone("Europe/London");
            case 23:
        assertThat(e.getMessage(), containsString("would require more than 10 effort"));
        FuzzyQuery fuzzyQuery = (FuzzyQuery) query;  
        }
import org.opensearch.index.mapper.MapperService;
                    analyzer = null;
        );
        assertTrue(e.getMessage().contains("would require more than 10000 effort"));
                    .add(new TermQuery(new Term(TEXT_FIELD_NAME, "fox")), Occur.SHOULD)  
            BooleanQuery expectedQuery = new BooleanQuery.Builder().add(new BooleanClause(maxQuery1, BooleanClause.Occur.SHOULD))  
        assertEquals(json, "this AND that OR thus", parsed.queryString());
        Float tieBreaker = instance.tieBreaker();  
        assertEquals(calculateExpectedDateQuery(lower - msPerHour, upper - msPerHour), qsq.timeZone("+01:00").toQuery(context));
        );
            List<Query> disjuncts2 = new ArrayList<>();
                ApproximatePointRangeQuery.LONG_FORMAT
        assertEquals(
                new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "quick")), Occur.SHOULD)
            .add(new TermQuery(new Term(TEXT_FIELD_NAME, "fox")), BooleanClause.Occur.SHOULD)
                    new BoostQuery(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "hello"))), 5.0f)
            // span query  
        boosts[boosts.length - 1] = mainBoost;
            case 16:
            + "    \"query\" : \"this AND that OR thus\",\n"
            switch (i) {
        newInstance.autoGenerateSynonymsPhraseQuery(autoGenerateSynonymsPhraseQuery);  
                        )
import static org.hamcrest.CoreMatchers.equalTo;  
            queryStringPrefix += "(";
            .phraseSlop(2)
        QueryStringQueryBuilder newInstance = new QueryStringQueryBuilder(query);
        assertEquals(expected, query);
        assertEquals(expected, query);
        queryStringQueryBuilder = new QueryStringQueryBuilder(TEXT_FIELD_NAME + ":foo bar").field("invalid*");
