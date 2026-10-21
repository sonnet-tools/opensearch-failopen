        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> query.toQuery(context));
import static org.hamcrest.Matchers.instanceOf;
        Operator operator = instance.defaultOperator();
                    new TermQuery(new Term(TEXT_FIELD_NAME, "hello")),
                s -> s.toLowerCase(Locale.ROOT).contains("now"),
import org.opensearch.core.common.ParsingException;
        queryStringQueryBuilder.field(DATE_FIELD_NAME);
        Boolean analyzeWildcard = instance.analyzeWildcard();
            .type(MultiMatchQueryBuilder.Type.PHRASE)
            QueryStringQueryBuilder queryBuilder = new QueryStringQueryBuilder("foo:*");
        for (int i = 0; i < numTerms; i++) {
        assertThat(phraseQuery.getTerms()[0], equalTo(new Term(TEXT_FIELD_NAME, "term1")));
        QueryStringQueryBuilder qsq = queryStringQuery(DATE_FIELD_NAME + ":1970-01-01");
            .minimumShouldMatch("2")
            query = new QueryStringQueryBuilder("foo mapped_string:10").analyzer("whitespace")
        /*
        assertThat(termQuery.getTerm(), equalTo(new Term(TEXT_FIELD_NAME, "test")));
        assertThat(query, instanceOf(WildcardQuery.class));
            new TermQuery(new Term(TEXT_FIELD_NAME, "bar")),
                }
import org.opensearch.common.settings.Settings;
            if (q.getClass() == MatchNoDocsQuery.class) {
    }
            queryStringQueryBuilder.defaultOperator(randomFrom(Operator.values()));
                } else {
        assertEquals(new MatchNoDocsQuery(""), query);
            }
        QueryShardContext context = createShardContext();
                    allowLeadingWildCard = randomBoolean() ? null : (allowLeadingWildCard == false);
            BooleanClause.Occur defaultOp = op.toBooleanClauseOccur();
         * this way in SearchService where we first rewrite the query with a private context, then reset the context and then build the
            // simple multi-term with phrase query
import org.apache.lucene.search.ConstantScoreQuery;
 * The OpenSearch Contributors require contributions made to
        queryParser.setForceAnalyzer(new org.apache.lucene.analysis.standard.StandardAnalyzer());
            assertThat(query, Matchers.equalTo(expectedQuery));
            for (int j = 0; j < 2; j++) {
                    if (randomBoolean()) {
            Query expectedQuery = new BooleanQuery.Builder().add(
        assertTrue(regexpQuery.toString().contains("abc.*"));
        for (Operator op : Operator.values()) {
            assertThat(query, Matchers.equalTo(expectedQuery));
        assertThat(phraseQuery.getTerms().length, equalTo(2));
        }
        assertThat(e.getMessage(), containsString("cannot use [fields] parameter in conjunction with [default_field]"));
            + "        \"time_zone\":\"Europe/Paris\",\n"
        // TooComplexToDeterminizeException should be thrown even if lenient is true
                } else {
        // Prefix
        assertThat(
        boolean fuzzyTranspositions = instance.fuzzyTranspositions();
        if (analyzeWildcard != null) {
import static org.apache.lucene.document.LongPoint.pack;
        float mainBoost = 2.0f / randomIntBetween(3, 20);
            disjunctionMaxQuery.getDisjuncts(),
        query = new QueryStringQueryBuilder("aBc*").field(TEXT_FIELD_NAME).analyzer("standard").toQuery(createShardContext());
            context.getIndexSettings()
            new QueryStringQueryBuilder("\"bar\"").quoteFieldSuffix(".quote").field(TEXT_FIELD_NAME).doToQuery(context)
                        )
                new Term(TEXT_FIELD_NAME, "aBc*D"),
                    newIndexMeta(
                    analyzer = null;
        // everything else is fine on all fields
            + "        \"query\":\""
            expectedQuery = new SpanNearQuery.Builder(TEXT_FIELD_NAME, true).addClause(new SpanTermQuery(new Term(TEXT_FIELD_NAME, "that")))
                new BooleanQuery.Builder().add(guineaPig, Occur.SHOULD).add(cavy, Occur.SHOULD).build(),
            List<Query> disjuncts1 = new ArrayList<>();
    public void testFromJson() throws IOException {
            case 2:
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBooleanSubQuery;
        assertEquals(json, "content", parsed.defaultField());
                break;
        Settings build = Settings.builder().put(oldIndexSettings).put(indexSettings).build();
    public void testToQueryRegExpQueryTooComplex() throws Exception {
        assertEquals("[query_string] field name in [fields] cannot be null", e.getMessage());
            + "    \"tie_breaker\" : 0.0,\n"
 */
                new CompressedXContent(PutMappingRequest.simpleMapping("foo", "type=text", "_field_names", "enabled=false").toString()),
            // span query with slop
        newInstance.fuzziness(fuzziness);
    public void testToQueryWildcardWithIndexedPrefixes() throws Exception {
                Arrays.asList(
            new WildcardQuery(
        // type=phrase
            queryParser.setForceAnalyzer(new MockSynonymAnalyzer());
        }
        assertThat(query, equalTo(expectedQuery));
            queryParser.setMultiTermRewriteMethod(MultiTermQuery.CONSTANT_SCORE_REWRITE);
            .field(KEYWORD_FIELD_NAME)
import org.apache.lucene.search.TermQuery;
            query = queryParser.parse("+that -(guinea pig) +smells");
                        )
        if (randomBoolean()) {
        Query expected = new DisjunctionMaxQuery(terms, 1.0f);
        assertThat(query, equalTo(expectedQuery));
    }
                break;
            .toQuery(createShardContext());
        assert context.isCacheable();
        expected = new DisjunctionMaxQuery(
        assertEquals(
    public void testToQueryBoosts() throws Exception {
            assertThat(query, Matchers.equalTo(expectedQuery));
        // Now check what happens if the quote field does not exist
                }
                new AutomatonQuery(new Term("prefix_field._index_prefix", "g*"), a, false, MultiTermQuery.CONSTANT_SCORE_REWRITE),
            queryStringQueryBuilder.allowLeadingWildcard(randomBoolean());
                    break;
            DisjunctionMaxQuery disjunctionMaxQuery = new DisjunctionMaxQuery(disjuncts, 0.0f);
            // throws an exception when lenient is set to false
            boosts[i] = boost;
        assertEquals(calculateExpectedDateQuery(lower, upper), query);
    }
                )
                        "index",
                    newIndexMeta(
        newInstance.fuzzyTranspositions(fuzzyTranspositions);
                                defaultOp
        assertThat(bQuery.clauses().size(), equalTo(2));
        assertEquals(
                    analyzeWildcard = randomBoolean();
            PhraseQuery pq = new PhraseQuery.Builder().add(new Term(TEXT_FIELD_NAME, "foo")).add(new Term(TEXT_FIELD_NAME, "bar")).build();
        } finally {
        assertThat(boostQuery1.getQuery(), instanceOf(TermQuery.class));
                .build();
    }
    public void testFuzzyNumeric() throws Exception {
            );
            case 14:
            + "    \"fields\" : [ ],\n"
        TooComplexToDeterminizeException e = expectThrows(
                    allowLeadingWildCard = randomBoolean();
                MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE
                MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE
            PhraseQuery pq2 = new PhraseQuery.Builder().add(new Term(TEXT_FIELD_NAME, "that"))
        builder.endObject();
        assertThat(booleanQuery.clauses().get(0).query(), equalTo(new TermQuery(new Term(TEXT_FIELD_NAME, "foo"))));
 * Unless required by applicable law or agreed to in writing,
    public void testToQueryPhraseQuery() throws IOException {
        }
            Query query = queryParser.parse("guinea pig");
        query.toQuery(context); // no exception
            .merge(
            + "    \"fuzziness\" : \"AUTO\",\n"
            Query query = queryBuilder.toQuery(createShardContext());
            String queryString = new String(bytes);
            queryParser.setMultiTermRewriteMethod(MultiTermQuery.CONSTANT_SCORE_REWRITE);
        if (randomBoolean()) {
        if (tieBreaker != null) {
                );
                    expectedEdits = 1;
        if (randomBoolean()) {
        assertEquals(expected, query);
            assertThat(query, Matchers.equalTo(expectedQuery));
                if (quoteFieldSuffix == null) {
            .setSlop(2)
            .toQuery(createShardContext());
        }
        }
    }
    // Tests fix for https://github.com/elastic/elasticsearch/issues/29403
        // if we hit a date field with "now", this should diable cachability
 * software distributed under the License is distributed on an
                        .add(
            .analyzer("stop")
                assertThat(query, equalTo(new ConstantScoreQuery(new FieldExistsQuery(TEXT_FIELD_NAME))));
        query = new QueryStringQueryBuilder("first unmapped:second").field(TEXT_FIELD_NAME)
            disjuncts.add(bq1);
        } else {
            0
            .enablePositionIncrements(false)
                    }
    }
        Query query = queryStringQuery("test").defaultField(TEXT_FIELD_NAME).toQuery(createShardContext());
    }
            assertQueryWithAllFieldsWildcard(query);
    }
        assertEquals(expected, query);
            Query expected = new DisjunctionMaxQuery(
                    analyzer = randomAnalyzer();
                    queryStringQueryBuilder.field(fieldName);
        // default value `*` sets leniency to true
            Occur.SHOULD
                );
            ).add(new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "bar")), BooleanClause.Occur.SHOULD)).build();
                }
     * the quote analyzer should overwrite any other forced analyzer in quoted parts of the query
            queryStringQueryBuilder.fuzzyMaxExpansions(randomIntBetween(0, 100));
            ).add(new TermQuery(new Term("prefix_field", "g")), Occur.SHOULD).build()
import org.apache.lucene.search.BoostQuery;
                    defaultOp
        TooComplexToDeterminizeException e = expectThrows(
            queryStringPrefix += "(";
                .add(new Term(TEXT_FIELD_NAME, "cavy"))
        assertThat(query, instanceOf(BoostQuery.class));
                Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,
                    rewrite = null;
    public void testNullFieldInFieldsArray() throws IOException {
            hasItems(
    }
                .add(new Term(TEXT_FIELD_NAME, "smells"))
import org.apache.lucene.util.automaton.Automaton;
        query = new QueryStringQueryBuilder("hello").field(TEXT_FIELD_NAME).field("*").field(KEYWORD_FIELD_NAME).toQuery(context);
        assertEquals(expected, query);
        query.lenient(true);
    }
        assertThat(booleanQuery.clauses().get(0).occur(), equalTo(BooleanClause.Occur.SHOULD));
            String term = randomValueOtherThanMany(
            switch (i) {
        );
        QueryStringQueryBuilder queryStringQueryBuilder = new QueryStringQueryBuilder(query);
        );
        query = new QueryStringQueryBuilder("hello*").field(INT_FIELD_NAME).lenient(true).toQuery(createShardContext());
                        context.getIndexSettings().getSettings(),
        assertTrue(e.getMessage().contains("Determinizing automaton"));
        Query query = queryStringQuery("test").field(TEXT_FIELD_NAME).field(KEYWORD_FIELD_NAME).toQuery(createShardContext());
            Term[] blendedTerms = new Term[2];
        assertEquals(new PrefixQuery(new Term(TEXT_FIELD_NAME, "abc"), MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE), query);
        assertThat(expectedQuery, equalTo(query));
        );
        FuzzyQuery expected = new FuzzyQuery(new Term(TEXT_FIELD_NAME, "text"), 2, 2, 5, false);
                            new BooleanClause(
    }
import org.apache.lucene.tests.analysis.MockSynonymAnalyzer;
        Query query = new QueryStringQueryBuilder("hello").field("*").toQuery(context);
        }
        assertEquals(expected, query);
                    )
        assertEquals(json, "this AND that OR thus", parsed.queryString());
            disjuncts.add(pq);
        float[] boosts = new float[numBoosts + 1];
        Query query = queryStringQuery("test1 test2").field(TEXT_FIELD_NAME).toQuery(createShardContext());
        assertEquals(expected, query);
        }
        assertEquals(new MatchNoDocsQuery(), query);
import org.apache.lucene.search.TermRangeQuery;
        }
            .toQuery(createShardContext());
        try {
            newInstance.defaultField(defaultField);
                } else {
    /**
            query = queryParser.parse("+that -guinea pig +smells");
        assertEquals(
                    defaultField = defaultField + randomAlphaOfLength(5);
                .add(
                .merge(
        QueryStringQueryParser queryParser = new QueryStringQueryParser(createShardContext(), TEXT_FIELD_NAME);
        Query query = queryStringQuery("/foo*bar/").defaultField(TEXT_FIELD_NAME).maxDeterminizedStates(5000).toQuery(createShardContext());
            )
        );
            case 7:
                }
        QueryShardContext context = createShardContext();
    protected void doAssertLuceneQuery(QueryStringQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
            .toQuery(createShardContext());
            disjuncts.add(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "foo bar"))));
        for (Operator op : Operator.values()) {
        assertThat(query, instanceOf(TermQuery.class));
        newInstance.defaultOperator(operator);
                    .build(),
        assertThat(queryStringQueryBuilder.timeZone(), equalTo(ZoneId.of("Europe/Paris")));
            queryStringQueryBuilder.fuzzyRewrite(getRandomRewriteMethod());
                .updateIndexMetadata(
        QueryStringQueryBuilder newInstance = new QueryStringQueryBuilder(query);
        return newInstance;
            ),
        query = queryBuilder.toQuery(contextNoType);
        queryStringQuery.boost(2.0f);
        // non-prefix queries do not work with range queries simple syntax
        assertThat(phraseQuery.getSlop(), Matchers.equalTo(2));
            queryStringQueryBuilder.rewrite(getRandomRewriteMethod());
        // Fuzzy
                new TermQuery(new Term(TEXT_FIELD_NAME, "hello")),
        }
        Query expected = new DisjunctionMaxQuery(
        if (rewrite != null) {
                Occur.SHOULD
            BooleanClause.Occur defaultOp = op.toBooleanClauseOccur();
    }
    public void testToQueryDateWithTimeZone() throws Exception {
            .toQuery(createShardContext());
        query.lenient(true);
        assertThat(boostQuery1.getBoost(), equalTo(2.0f));
        assertEquals(
                new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "test")))
        assertThat(phraseQuery.getTerms()[1], equalTo(new Term(TEXT_FIELD_NAME, "term2")));
                    timeZone = randomZone().getId();
            }
                    defaultOp
                .build();
 * under the License.
 * specific language governing permissions and limitations
        queryStringQueryBuilder = new QueryStringQueryBuilder("now");
            query = queryParser.parse("that guinea pig smells");
            + "    \"max_determinized_states\" : 10000,\n"
    }
        Query query = new QueryStringQueryBuilder("quick* @&*").field(TEXT_FIELD_NAME)
                autoGenerateSynonymsPhraseQuery = (autoGenerateSynonymsPhraseQuery == false);
                phraseSlop += 5;
        switch (between(0, 23)) {
import java.util.List;
            query += (randomBoolean() ? TEXT_FIELD_NAME + ":" : "") + term + " ";
                .build();
        )
                .add(new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "last")), defaultOp))
        for (boolean quoted : new boolean[] { true, false }) {
        assertThat(queryBuilder, instanceOf(QueryStringQueryBuilder.class));
                    .toQuery(createShardContext());
import org.opensearch.cluster.metadata.IndexMetadata;
        RegexpQuery regexpQuery = (RegexpQuery) query;
            .toQuery(createShardContext());
        assertEquals(expected, query);
        terms.add(new BoostQuery(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "first"))), 0.5f));
                            new BooleanClause(
                break;
        );
        query = new BoolQueryBuilder().should(
                        "index",
                .add(new TermQuery(new Term(TEXT_FIELD_NAME, "smells")), BooleanClause.Occur.MUST)
    public void testExpandedTerms() throws Exception {
            .build();
                        Settings.builder().putList("index.query.default_field", TEXT_FIELD_NAME, "*", KEYWORD_FIELD_NAME).build()
                break;
     */
            .toQuery(createShardContext());
                    analyzeWildcard = randomBoolean() ? null : (analyzeWildcard == false);
        assertQueryWithAllFieldsWildcard(query);
            .startObject("index_prefixes")
        assertWarnings(FieldNamesFieldMapper.ENABLED_DEPRECATION_MESSAGE);
        assertQueryCachability(queryStringQueryBuilder, false);
         */
                .updateIndexMetadata(
        if (randomBoolean()) {
            final int len;
            + "  \"query_string\" : {\n"
            context.getIndexSettings()
        );
        assertEquals(expected, query);
        // if we hit all fields, this should contain a date field and should diable cachability
                pack(new long[] { lower }).bytes,
import org.apache.lucene.queries.spans.SpanNearQuery;
        QueryShardContext context = createShardContext();
        assertThat(boostQuery.getBoost(), equalTo(2.0f));
            queryStringSuffix += ")^" + boost;
    public void testWithPrefixStopWords() throws Exception {
            Query expected = new DisjunctionMaxQuery(
    }
            newInstance.quoteFieldSuffix(quoteFieldSuffix);
import org.opensearch.search.approximate.ApproximateScoreQuery;
            case 8:
                    fuzzyRewrite = getRandomRewriteMethod();
import org.apache.lucene.queries.spans.SpanTermQuery;
            .toQuery(createShardContext());
        assertEquals(new Term(TEXT_FIELD_NAME, "aBc"), fuzzyQuery.getTerm());
    }
    }
        final QueryShardContext context = createShardContext();
    protected QueryStringQueryBuilder doCreateTestQueryBuilder() {
            .build();
            newInstance.analyzeWildcard(analyzeWildcard);
        queryStringQuery.boost(2.0f);
                            )
         * actual lucene query
            )
        queryBuilder = new QueryStringQueryBuilder("*:*");
                .add(new TermQuery(new Term(TEXT_FIELD_NAME, "pig")), Occur.MUST)
    public void testToQueryMultipleFieldsDisMaxQuery() throws Exception {
                .add(new Term(TEXT_FIELD_NAME, "guinea"))
        Query expectedQuery = new BooleanQuery.Builder().add(
        QueryStringQueryBuilder query = queryStringQuery("12~0.2").defaultField(INT_FIELD_NAME);
                    Settings.builder().putList("index.query.default_field", TEXT_FIELD_NAME, KEYWORD_FIELD_NAME).build()
import org.opensearch.index.search.QueryStringQueryParser;
        try {
            case 1:
        Query expectedQuery = new ConstantScoreQuery(new TermQuery(new Term("prefix_field._index_prefix", "foo")));
            .endObject()
                default:
                    defaultOp
                if (analyzer == null) {
            )
            .boost(mainBoost);
import org.apache.lucene.util.BytesRef;
        if (randomBoolean()) {
        QueryShardContext context = createShardContext();
            context.isCacheable()
                    minimumShouldMatch = randomMinimumShouldMatch();
        );
        assertNotEquals(builder1, builder2);
        query = queryStringQueryBuilder.toQuery(createShardContext());
                MapperService.MergeReason.MAPPING_UPDATE
                    queryStringQueryBuilder.field(fieldName, randomFloat());
        );
        String query = "";
        }
            queryStringQueryBuilder.escape(randomBoolean());
        query = new QueryStringQueryBuilder("the").field(TEXT_FIELD_NAME)
            .toQuery(createShardContext());
        assertThat(query, instanceOf(BooleanQuery.class));
    }
        QueryStringQueryBuilder parsed = (QueryStringQueryBuilder) parseQuery(json);
        assertEquals("Cannot parse '*test': '*' or '?' not allowed as first character in WildcardQuery", ex.getCause().getMessage());
 * You may obtain a copy of the License at
    public void testWithStopWords() throws Exception {
        assertThat(((TermQuery) boostQuery.getQuery()).getTerm(), equalTo(new Term(TEXT_FIELD_NAME, "boosted")));
        }
        assertTrue(regexpQuery.toString().contains("/foo*bar/"));
        mapperService.merge("_doc", new CompressedXContent(mapping.toString()), MapperService.MergeReason.MAPPING_UPDATE);
        if (randomBoolean()) {
    }
        assertEquals(expected, query);
        assertEquals(new MatchNoDocsQuery(""), query);
                break;
            DisjunctionMaxQuery expectedQuery = new DisjunctionMaxQuery(disjuncts, 0.0f);
            new IndexOrDocValuesQuery(
                new TermQuery(new Term(TEXT_FIELD_NAME, "test")),
        BooleanQuery expected = new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "first")), BooleanClause.Occur.MUST)
            }
            .endObject();
            queryParser.setAutoGenerateMultiTermSynonymsPhraseQuery(false);
                .type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)
            // min length 4 makes sure that the text is not an operator (AND/OR) so toQuery won't break
            BooleanQuery expectedQuery = new BooleanQuery.Builder().add(disjunctionMaxQuery, BooleanClause.Occur.SHOULD)
            0f
                    defaultField = randomAlphaOfLengthBetween(1, 10);
    public void testQuoteFieldSuffix() throws IOException {
        String queryAsString = "{\n"
            blendedTerms[1] = new Term(KEYWORD_FIELD_NAME, "foo");
        {
                .add(new TermQuery(new Term(TEXT_FIELD_NAME, "10")), Occur.SHOULD)
            QueryStringQueryParser queryParser = new QueryStringQueryParser(createShardContext(), TEXT_FIELD_NAME);
            expectedQuery = new BooleanQuery.Builder().add(pq1, Occur.SHOULD).add(pq2, Occur.SHOULD).build();
        assertThat(boostQuery.getBoost(), equalTo(2.0f));
                new long[] { lower }.length,
        builder1.timeZone("Europe/London");
            queryBuilder.type(MultiMatchQueryBuilder.Type.PHRASE);
                } else {
        // Unmapped fields
            expectedQuery = new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "that")), defaultOp)
            builder.startObject("query_string");
    public void testToQueryTermQuery() throws IOException {
                    context.getIndexSettings().getSettings(),
                    len = randomIntBetween(1, 2);
            Query expected = new WildcardQuery(new Term("foo", "*"));
                    .add(new TermQuery(new Term(TEXT_FIELD_NAME, "fox")), Occur.SHOULD)
        if (randomBoolean()) {
        assertEquals(calculateExpectedDateQuery(lower + msPerHour, upper + msPerHour), qsq.timeZone("-01:00").toQuery(context));
                    )
                    Occur.MUST_NOT
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(queryAsString));
        query = new QueryStringQueryBuilder("\"quick fox\"").field(TEXT_FIELD_NAME).phraseSlop(2).toQuery(createShardContext());
        }
    }
    }
            query = new QueryStringQueryBuilder("hello").toQuery(context);
            BoostQuery boostQuery = (BoostQuery) query;
    public void testDefaultFieldsWithFields() throws IOException {
        {
    public void testToQueryRegExpQueryMaxDeterminizedStatesParsing() throws Exception {
        Query query = queryStringQuery.toQuery(shardContext);
        return queryStringQueryBuilder;
import java.util.Locale;
        QueryStringQueryBuilder queryStringQueryBuilder = (QueryStringQueryBuilder) queryBuilder;
        Query query = new QueryStringQueryBuilder("hello").field("unmapped_field").lenient(true).toQuery(createShardContext());
import org.apache.lucene.util.automaton.TooComplexToDeterminizeException;
        return IndexMetadata.builder(name).settings(build).build();
        assertThat(query, instanceOf(BoostQuery.class));
                    ).build(),
                } else {
            () -> new QueryStringQueryBuilder("the quick fox").field(TEXT_FIELD_NAME, -1.0f)
                            .addClause(new SpanTermQuery(new Term(TEXT_FIELD_NAME, "pig")))
 *
            + "    \"fuzzy_transpositions\" : false,\n"
        PhraseQuery phraseQuery = (PhraseQuery) query;
            new TermQuery(new Term(TEXT_FIELD_NAME, "bar")),
        Query query = queryStringQuery("test").field("mapped_str*").toQuery(createShardContext());
     */
                )
        // Multi block
    @Override
            List<Query> disjuncts2 = new ArrayList<>();
    }
                                new BooleanClause(new PrefixQuery(new Term(TEXT_FIELD_NAME, "foobar")), BooleanClause.Occur.SHOULD)
    }
            query
                new BooleanQuery.Builder().add(
        assertThat(query, instanceOf(ApproximateScoreQuery.class));
        Query query = new QueryStringQueryBuilder("ONE \"TWO THREE\"").field(TEXT_FIELD_NAME)
                    new BooleanQuery.Builder().add(
        QueryShardContext context = createShardContext();
    public void testCachingStrategiesWithNow() throws IOException {
        assertEquals(
                );
            QueryStringQueryBuilder queryBuilder = new QueryStringQueryBuilder("foo bar").field(TEXT_FIELD_NAME).field(KEYWORD_FIELD_NAME);
            assertThat(query, instanceOf(BoostQuery.class));
        assertThat(query, instanceOf(RegexpQuery.class));
            e.getMessage()
                    new PhraseQuery.Builder().add(new Term(TEXT_FIELD_NAME, "guinea")).add(new Term(TEXT_FIELD_NAME, "pig")).build(),
                    new BooleanQuery.Builder().add(new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "foo")), defaultOp))
            List<Query> disjuncts = new ArrayList<>();
    public void testToQueryRegExpQuery() throws Exception {
            + "    }\n"
                0.0f
        assertEquals(
        expected = new BooleanQuery.Builder().add(new MatchNoDocsQuery(), BooleanClause.Occur.MUST)
                break;
        Query expectedQuery = new MatchNoDocsQuery("empty fields");
                    expectedEdits = 2;
        }
            );
            .phraseSlop(2)
                    newIndexMeta(
            assertThat(boostQuery.getBoost(), equalTo(boosts[i]));
                new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "test")))
        newInstance.fields(fields);
        }
    public void testPhraseSlop() throws Exception {
        XContentBuilder mapping = jsonBuilder().startObject()
        fuzzyQuery = (FuzzyQuery) query;
                new BoostQuery(new TermQuery(new Term(TEXT_FIELD_NAME, "test")), 2.2f),
        );
            new PrefixQuery(new Term(TEXT_FIELD_NAME, "the"), MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE),
                .toQuery(createShardContext());
import static org.hamcrest.CoreMatchers.hasItems;
    }
                new BooleanQuery.Builder().add(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "quick"))), Occur.SHOULD)
        assertEquals(expected, query);
 * ownership. Elasticsearch licenses this file to you under
            expectedQuery = new BooleanQuery.Builder().add(
        assertEquals(new PrefixQuery(new Term(TEXT_FIELD_NAME, "aBc"), MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE), query);
        Fuzziness fuzziness = instance.fuzziness();
        if (randomBoolean()) {
                new TermQuery(new Term(TEXT_FIELD_NAME, "test")),
        assertEquals(expected, query);
        QueryStringQueryBuilder query = queryStringQuery("2,3").defaultField(GEO_POINT_FIELD_NAME);
            + ":[2012 TO 2014]\"\n"
        assertEquals(calculateExpectedDateQuery(lower - msPerHour, upper - msPerHour), qsq.timeZone("+01:00").toQuery(context));
                        Settings.builder().putList("index.query.default_field", "*").build()
    }
        assertEquals(new TermRangeQuery(TEXT_FIELD_NAME, new BytesRef("abc"), new BytesRef("bcd"), true, true), query);
                break;
            case 23:
                }
            () -> queryBuilder.toQuery(createShardContext())
                                    .addTerm(new Term(TEXT_FIELD_NAME, "bar"))
                    len = randomIntBetween(6, 20);
        assertThat(boostQuery.getQuery(), instanceOf(PhraseQuery.class));
        assertThat(boostQuery2.getBoost(), equalTo(1.5f));
            .field(TEXT_FIELD_NAME.substring(0, TEXT_FIELD_NAME.length() - 2) + "*", 0.5f)
            new QueryStringQueryBuilder("the").field(TEXT_FIELD_NAME).field(KEYWORD_FIELD_NAME).analyzer("stop")
        }
        context.getIndexSettings()
            queryStringQueryBuilder.autoGenerateSynonymsPhraseQuery(randomBoolean());
    }
 * compatible open source license.
        boolean escape = instance.escape();
            new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "bar"))),
        boostQuery = (BoostQuery) query;
        Query expected = new PrefixQuery(new Term(TEXT_FIELD_NAME, "quick"), MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE);
        assertEquals(expected, query);
                ApproximatePointRangeQuery.LONG_FORMAT
        assertThat(phraseQuery.getTerms().length, equalTo(2));
            + "    \"fields\" : [ \"field1\", null, \"field2\" ]\n"
                break;
            }
            .updateIndexMetadata(
    public void testToQueryWildcardNonExistingFields() throws IOException {
            case 22:
        }
            disjuncts2.add(new TermQuery(new Term(TEXT_FIELD_NAME, "bar")));
        if (quoteAnalyzer != null) {
            );
            IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> queryBuilder.toQuery(createShardContext()));
            + "    \"default_field\" : \"content\",\n"
        }
        assertEquals(expected, query);
        QueryValidationException e = expectThrows(QueryValidationException.class, () -> builder.toQuery(context));
            query = queryParser.parse("\"that guinea pig smells\"~2");
            + "    \"escape\" : false,\n"
            .add(new Term(TEXT_FIELD_NAME, "fox"))
                .build();
        QueryShardContext shardContext = createShardContext();
        List<Query> terms = new ArrayList<>();
        }
import org.apache.lucene.search.SynonymQuery;
        String json = "{\n"
                defaultOp
        ).toQuery(createShardContext());
    public void testDefaultField() throws Exception {
            cachingExpected,
                } else {
            List.of(
                newIndexMeta(
            disjuncts1.add(new TermQuery(new Term(TEXT_FIELD_NAME, "foo")));
            .type(MultiMatchQueryBuilder.Type.PHRASE)
                break;
 *
        assertEquals(
                break;
        String fuzzyRewrite = instance.fuzzyRewrite();
import org.apache.lucene.util.automaton.Operations;
        assertEquals(expected, query);
                new TermQuery(new Term(TEXT_FIELD_NAME, "test")),
            .startObject("properties")
        assertEquals(new BooleanQuery.Builder().build(), query);
        Query query = queryStringQuery("test").field(TEXT_FIELD_NAME, 2.2f).field(KEYWORD_FIELD_NAME).toQuery(createShardContext());
            queryParser.setDefaultOperator(op.toQueryParserOperator());
        assertThat(exc.getMessage(), CoreMatchers.containsString("negative [boost]"));
            List<Query> disjuncts = new ArrayList<>();
            case 12:
import org.apache.lucene.document.LongPoint;
            new QueryStringQueryBuilder("bar").quoteFieldSuffix(".quote").field(TEXT_FIELD_NAME).doToQuery(context)
        }
    /**
            assertThat(query, equalTo(expectedQuery));
import org.apache.lucene.queries.spans.SpanOrQuery;
import org.apache.lucene.document.SortedNumericDocValuesField;
        );
        query = new QueryStringQueryBuilder("\"quick fox\"~2").field(TEXT_FIELD_NAME).phraseSlop(10).toQuery(createShardContext());
                } else {
    public void testToFuzzyQuery() throws Exception {
public class QueryStringQueryBuilderTests extends AbstractQueryTestCase<QueryStringQueryBuilder> {
            queryParser.setMultiTermRewriteMethod(MultiTermQuery.CONSTANT_SCORE_REWRITE);
            BooleanQuery expectedQuery = new BooleanQuery.Builder().add(new BooleanClause(maxQuery1, BooleanClause.Occur.SHOULD))
                        .addTerm(new Term(TEXT_FIELD_NAME, "first"))
                    new BooleanClause(
    public void testToQueryMultipleFieldsBooleanQuery() throws Exception {
                0.0f
            + "}";
                    rewrite = getRandomRewriteMethod();
                }
        QueryShardContext context = createShardContext();
                )
        assertThat(boostQuery.getBoost(), equalTo(5f));
            ),
        int numTerms = randomIntBetween(0, 5);
                        context.getIndexSettings().getSettings(),
        {
        assertEquals(expected, query);
import org.opensearch.search.approximate.ApproximatePointRangeQuery;
            int numFields = randomIntBetween(1, 5);
        Query query = new QueryStringQueryBuilder("text~2").field(TEXT_FIELD_NAME)
        assertThat(booleanQuery.clauses().get(1).query(), equalTo(new TermQuery(new Term(TEXT_FIELD_NAME, "bar"))));
                                .addTerm(new Term(TEXT_FIELD_NAME, "foo"))
        );
            .add(new MatchNoDocsQuery("empty fields"), Occur.SHOULD)
        }
        Query query = new QueryStringQueryBuilder("\"quick the fox\"").field(TEXT_FIELD_NAME)
        assertEquals(expectedQuery, query);
        query = new QueryStringQueryBuilder("[aBc TO BcD]").field(TEXT_FIELD_NAME).analyzer("whitespace").toQuery(createShardContext());
        assertTrue(e.getMessage().contains("would require more than 10000 effort"));
    }
        String quoteFieldSuffix = instance.quoteFieldSuffix();
        QueryStringQueryBuilder builder1 = new QueryStringQueryBuilder("bar");
            expectedQuery = new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "that")), Occur.MUST)
                .addClause(
            case 5:
        String queryStringSuffix = "";
        if (randomBoolean()) {
    public void testExistsFieldQuery() throws Exception {
        e = expectThrows(TooComplexToDeterminizeException.class, () -> lenientQueryBuilder.toQuery(createShardContext()));
            .field(TEXT_FIELD_NAME, 0.3f)
                .setSlop(2)
            new TermQuery(new Term(TEXT_FIELD_NAME, "bar")),
        }
     * Query terms that contain "now" can trigger a query to not be cacheable.
        assertThat(boostQuery.getQuery(), instanceOf(TermQuery.class));
                            .build(),
import java.util.HashMap;
        IllegalArgumentException exc = expectThrows(
        if (randomBoolean()) {
            assertEquals(expected, query);
        assertThat(((TermQuery) boostQuery1.getQuery()).getTerm(), equalTo(new Term(TEXT_FIELD_NAME, "boosted")));
/*
        assertEquals(new MatchNoDocsQuery(), query);
     * Test that dissalowing leading wildcards causes exception
    }
                        new SpanNearQuery.Builder(TEXT_FIELD_NAME, true).addClause(new SpanTermQuery(new Term(TEXT_FIELD_NAME, "guinea")))
        query.toQuery(context); // no exception
                        .build(),
                fuzzyPrefixLength += 5;
            query = boostQuery.getQuery();
            newInstance.analyzer(analyzer);
     * This test checks the search context cacheable flag is updated accordingly.
    }
                return changeNameOrBoost(instance);
            queryStringQueryBuilder.maxDeterminizedStates(randomIntBetween(1, 100));
    public void testNegativeFieldBoost() {
        }
                builder.field("query", "/[ac]*a[ac]{1,10}/");
        QueryShardContext context = createShardContext();
            List.of(
            assertThat(query, Matchers.equalTo(expectedQuery));
            List.of(
                .field(KEYWORD_FIELD_NAME);
    }
        assertQueryWithAllFieldsWildcard(query);
    public void testRegexpQueryParserWithForceAnalyzer() throws Exception {
                break;
            .analyzer("stop")
        assertThat(e.getMessage(), containsString("would require more than 10 effort"));
            .toQuery(createShardContext());
    }
            .add(new TermQuery(new Term(TEXT_FIELD_NAME, "quick")), Occur.SHOULD)
            case 10:
        }
            + "        \"time_zone\":\"This timezone does not exist\",\n"
            queryStringQueryBuilder.defaultField(defaultFieldName);
            queryStringQueryBuilder.analyzeWildcard(randomBoolean());
            .build();
            // span query
            queryStringQueryBuilder.quoteFieldSuffix(randomAlphaOfLengthBetween(1, 3));
        String queryAsString = "{\n"
        Query query = queryParser.parse("/aBc.*/");
            queryParser.setAnalyzeWildcard(true);
            .build();
        BoostQuery boostQuery = (BoostQuery) query;
        assertThat(query, instanceOf(BooleanQuery.class));
            context.getMapperService()
                        .add(new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "bar")), defaultOp))
            queryStringQueryBuilder.analyzer(randomAnalyzer());
        assertThat(expectedQuery, equalTo(query));
            case 18:
            queryStringQueryBuilder.quoteAnalyzer(randomAnalyzer());
            ).build();
                    .add(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "fox"))), Occur.SHOULD)
            ),
                if (defaultField == null) {
            + DATE_FIELD_NAME
import org.opensearch.index.mapper.FieldNamesFieldMapper;
            }
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {
            Query guineaPig = new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "guinea")), Occur.MUST)
        }
            disjuncts.add(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "foo bar"))));
    public void testToQueryBooleanQueryMultipleBoosts() throws Exception {
            Query query = queryBuilder.toQuery(createShardContext());
                new Term(TEXT_FIELD_NAME, "abc*d"),
        query = new QueryStringQueryBuilder("hello~2").field(INT_FIELD_NAME).lenient(true).toQuery(createShardContext());
    public void testToQueryTextParsing() throws IOException {
        int numBoosts = randomIntBetween(2, 10);
        // Default unmapped field
        Query expected = new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "quick")), BooleanClause.Occur.SHOULD)
            QueryStringQueryParser queryParser = new QueryStringQueryParser(createShardContext(), TEXT_FIELD_NAME);
                .build();
        assertQueryCachability(queryStringQueryBuilder, true);
        query = new BoolQueryBuilder().should(new QueryStringQueryBuilder("the").field(TEXT_FIELD_NAME).analyzer("stop"))
    @Override
            .toQuery(createShardContext());
        assertEquals(9, noMatchNoDocsQueries);
 *
        TermQuery termQuery = (TermQuery) query;
import org.apache.lucene.search.AutomatonQuery;
        QueryShardContext contextNoType = createShardContextWithNoType();
        QueryBuilder queryBuilder = parseQuery(queryAsString);
                fuzzyMaxExpansions += 5;
                )
        expectThrows(IllegalArgumentException.class, () -> new QueryStringQueryBuilder((String) null));
        PhraseQuery phraseQuery = (PhraseQuery) boostQuery.getQuery();
                .add(
        assertEquals(json, false, parsed.fuzzyTranspositions());
        expected = new PhraseQuery.Builder().add(new Term(TEXT_FIELD_NAME, "quick"))
        if (analyzer != null) {
import static org.hamcrest.CoreMatchers.equalTo;
                    newIndexMeta(
                    "_doc",
        BooleanQuery booleanQuery = (BooleanQuery) query;
import org.apache.lucene.search.BooleanQuery;
        assertThat(e.getMessage(), containsString("Determinizing automaton"));
        assertNull(queryStringQueryBuilder.fuzziness());
import org.hamcrest.CoreMatchers;
        expected = new MatchAllDocsQuery();
        if (minimumShouldMatch != null) {
                escape = (escape == false);
                .add(
            newInstance.quoteAnalyzer(quoteAnalyzer);
                            )
        }
                break;
        QueryStringQueryBuilder queryStringQueryBuilder = new QueryStringQueryBuilder(query);
        }
    public void testDefaultFuzziness() {
                .field(KEYWORD_FIELD_NAME)
                .updateIndexMetadata(
            + "}";
        newInstance.enablePositionIncrements(enablePositionIncrements);
        // Range
                new BooleanClause(
                ),
            BooleanClause.Occur defaultOp = op.toBooleanClauseOccur();
import org.apache.lucene.search.MatchNoDocsQuery;
        assertThat(boostQuery2.getQuery(), instanceOf(TermQuery.class));
            Query query = queryBuilder.toQuery(createShardContext());
        if (randomBoolean()) {
            // complex
        assertThat(query, instanceOf(MatchAllDocsQuery.class));
            if ((context.getMapperService().fieldType(TEXT_FIELD_NAME).getTextSearchInfo().hasNorms())) {
                    Occur.SHOULD
                "_doc",
        assertEquals(
        query.toQuery(context); // no exception
            for (int i = 0; i < numFields; i++) {
                    fuzzyRewrite = null;
        Query query = qsq.toQuery(context);
            .add(new TermQuery(new Term(TEXT_FIELD_NAME, "fox")), Occur.SHOULD)
        assertThat(boostQuery.getBoost(), equalTo(2.0f));
    public void testPrefixNumeric() throws Exception {
                )
        try {
import org.opensearch.common.unit.Fuzziness;
                new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "quick")), Occur.SHOULD)
        assertThat(assertBooleanSubQuery(query, TermQuery.class, 0).getTerm(), equalTo(new Term(TEXT_FIELD_NAME, "test1")));
        assertThat(query, instanceOf(PhraseQuery.class));
                break;
                break;
                            .addTerm(new Term(TEXT_FIELD_NAME, "last"))
        query = new QueryStringQueryBuilder("aBc~1").field(TEXT_FIELD_NAME).analyzer("whitespace").toQuery(createShardContext());
            Query query = queryParser.parse("first foo-bar-foobar* last");
import org.opensearch.lucene.queries.BlendedTermQuery;
                .build();
import org.apache.lucene.search.RegexpQuery;
            // Reset the default value
        long upper = 86399999;  // 1970-01-01T23:59:59.999 UTC
    private void assertQueryCachability(QueryStringQueryBuilder qb, boolean cachingExpected) throws IOException {
            .endObject()
                maxDeterminizedStates += 5;
        {
    }
import org.apache.lucene.search.MatchAllDocsQuery;
                                new PrefixQuery(new Term(TEXT_FIELD_NAME, "foobar"), MultiTermQuery.CONSTANT_SCORE_REWRITE),
                        .build(),
                    )
            new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "ONE")), Occur.SHOULD)
            + "    \"query_string\":{\n"
        QueryBuilder queryBuilder = parseInnerQueryBuilder(createParser(builder));
        QueryStringQueryBuilder queryStringQuery = queryStringQuery(TEXT_FIELD_NAME + ":boosted^2");
        query = new QueryStringQueryBuilder("aBc*D").field(TEXT_FIELD_NAME).analyzer("whitespace").toQuery(createShardContext());
        // Wildcard
        query = new QueryStringQueryBuilder("hello").lenient(true)
        Query query = new QueryStringQueryBuilder("hello").field(INT_FIELD_NAME).lenient(true).toQuery(createShardContext());
        DisjunctionMaxQuery disjunctionMaxQuery = (DisjunctionMaxQuery) query;
        QueryStringQueryBuilder queryBuilder = new QueryStringQueryBuilder(TEXT_FIELD_NAME + ":*");
            ).build();
            Query query = queryParser.parse("first foo-bar-foobar* last");
        for (Operator op : Operator.values()) {
        query.lenient(true);
    public void testToQueryFuzzyQueryAutoFuzziness() throws Exception {
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
            + "    \"query\" : \"test\",\n"
            queryStringQueryBuilder.phraseSlop(randomIntBetween(0, 10));
            + "    \"fuzzy_max_expansions\" : 50,\n"
                .type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)
        query = queryStringQuery.toQuery(shardContext);
        XContentBuilder builder = JsonXContent.contentBuilder();
     */
        assertQueryWithAllFieldsWildcard(query);
            Query query = queryBuilder.toQuery(createShardContext());
        queryStringQuery = queryStringQuery("((" + TEXT_FIELD_NAME + ":boosted^2) AND (" + TEXT_FIELD_NAME + ":foo^1.5))^3");
 * this file be licensed under the Apache-2.0 license or a
                        "index",
    public void testToQueryPhraseQueryBoostAndSlop() throws IOException {
            QueryStringQueryParser queryParser = new QueryStringQueryParser(createShardContext(), TEXT_FIELD_NAME);
        newInstance.maxDeterminizedStates(maxDeterminizedStates);
    }
        queryStringQueryBuilder = new QueryStringQueryBuilder(query);
            + "    \"query\" : \"this AND that OR thus\",\n"
        );
    public void testToQueryMatchAllQuery() throws Exception {
            .build();
            .defaultOperator(Operator.AND)
import org.apache.lucene.search.IndexOrDocValuesQuery;
        QueryStringQueryBuilder lenientQueryBuilder = queryStringQuery("/[ac]*a[ac]{50,200}/").defaultField(TEXT_FIELD_NAME).lenient(true);
import java.time.ZoneId;
                .add(new TermQuery(new Term(TEXT_FIELD_NAME, "guinea")), BooleanClause.Occur.MUST_NOT)
        }
            .analyzeWildcard(true)
            + "    \"boost\" : 1.0\n"
    }
            disjuncts.add(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "foo bar"))));
                }
        QueryStringQueryBuilder queryStringQueryBuilder = new QueryStringQueryBuilder("\"test phrase\"~2").field(TEXT_FIELD_NAME, 5f);
                fields = new HashMap<>(fields);
        }
        int phraseSlop = instance.phraseSlop();
            assertThat(exc.getMessage(), equalTo("For input string: \">10 foo\""));
            IllegalArgumentException.class,
    }
                assertThat(query, equalTo(new ConstantScoreQuery(new TermQuery(new Term("_field_names", TEXT_FIELD_NAME)))));
            DisjunctionMaxQuery expectedQuery = new DisjunctionMaxQuery(disjuncts, 0.0f);
        QueryStringQueryParser queryParser = new QueryStringQueryParser(createShardContext(), "prefix_field");
        int fuzzyMaxExpansions = instance.fuzzyMaxExpansions();
    }
                    minimumShouldMatch = null;
            query = new QueryStringQueryBuilder("hello").toQuery(context);
            .add(new Term(TEXT_FIELD_NAME, "fox"))
                    new BooleanQuery.Builder().add(
        assertThat(((TermQuery) boostQuery2.getQuery()).getTerm(), equalTo(new Term(TEXT_FIELD_NAME, "foo")));
            }
        assertNotNull(rewritten.toQuery(context));
            () -> queryBuilder.toQuery(createShardContext())
            "query should " + (cachingExpected ? "" : "not") + " be cacheable: " + qb.toString(),
    public void testTimezoneEquals() {
    }
            + ":[2012 TO 2014]\"\n"
    public void testAllowLeadingWildcard() throws Exception {
import java.io.IOException;
            assertThat(query, equalTo(new ConstantScoreQuery(new TermQuery(new Term("_field_names", TEXT_FIELD_NAME)))));
                new BooleanClause(
        }
import org.apache.lucene.index.Term;
            .field(KEYWORD_FIELD_NAME)
        query = randomFrom("NoW", "nOw", "NOW") + " " + randomAlphaOfLengthBetween(4, 10);
        QueryStringQueryBuilder queryStringQueryBuilder = new QueryStringQueryBuilder(TEXT_FIELD_NAME).fuzziness(null);
        );
            List.of(
            + "  }\n"
                break;
            + "    \"type\" : \"best_fields\",\n"
    public void testToQueryWildcardQueryWithSynonyms() throws Exception {
        assertThat(query, instanceOf(BoostQuery.class));
            queryStringQueryBuilder.fuzziness(randomFuzziness(TEXT_FIELD_NAME));
                        context.getIndexSettings().getSettings(),
            new BooleanQuery.Builder().add(
                    break;
        assertEquals(expected, query);
                assertThat(query, instanceOf(FuzzyQuery.class));
    }
    }
        boosts[boosts.length - 1] = mainBoost;
            ).add(new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "bar")), BooleanClause.Occur.SHOULD)).build();
    /**
/*
            case 13:
        if (defaultField != null) {
            ),
                    BlendedTermQuery.dismaxBlendedQuery(new Term[] { blendedTerms[0] }, 1.0f)
                break;
        Query query = queryStringQueryBuilder.toQuery(createShardContext());
            query
        Query expected = new DisjunctionMaxQuery(
import org.opensearch.common.xcontent.json.JsonXContent;
    }
    }
        assertThat(query, equalTo(new MatchNoDocsQuery()));
            assertThat(query, equalTo(expectedQuery));
                    } else {
        boolean autoGenerateSynonymsPhraseQuery = instance.autoGenerateSynonymsPhraseQuery();
        }
        newInstance.phraseSlop(phraseSlop);
        boostQuery = (BoostQuery) query;
        QueryStringQueryBuilder queryStringQueryBuilder = new QueryStringQueryBuilder("foo bar").field("invalid*");
                } else {
            newInstance.fuzzyRewrite(fuzzyRewrite);
                () -> randomAlphaOfLengthBetween(4, 10)
            case 19:
        Query query = queryStringQuery("*:*").toQuery(createShardContext());
    public void testToQueryFieldsWildcard() throws Exception {
                )
        String query = "now " + randomAlphaOfLengthBetween(4, 10);
    }
        QueryShardContext context = createShardContext();
                } else {
    public void testToQueryDisMaxQuery() throws Exception {
        expectedQuery = new ConstantScoreQuery(
            queryBuilder = new QueryStringQueryBuilder("_exists_:" + value);
        Query query = queryBuilder.toQuery(context);
        String defaultField = instance.defaultField();
            .endObject()
    }
                                defaultOp
        assertEquals(new Term(TEXT_FIELD_NAME, "abc"), fuzzyQuery.getTerm());
        BoostQuery boostQuery1 = assertBooleanSubQuery(boostQuery.getQuery(), BoostQuery.class, 0);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        Boolean allowLeadingWildCard = instance.allowLeadingWildcard();
    }
        Query query = queryStringQuery("*test").field("mapped_string").allowLeadingWildcard(true).toQuery(createShardContext());
                    new SpanOrQuery(
        String query = instance.queryString();
                .add(new TermQuery(new Term(TEXT_FIELD_NAME, "pig")), defaultOp)
 * Modifications Copyright OpenSearch Contributors. See
        {
        }
                new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "test")))
        QueryShardContext context = createShardContext();
            queryStringQueryBuilder.enablePositionIncrements(randomBoolean());
            Arrays.fill(bytes, 'a');
        QueryStringQueryBuilder query = queryStringQuery("12*").defaultField(INT_FIELD_NAME);
 * the Apache License, Version 2.0 (the "License"); you may
                pack(new long[] { upper }).bytes,
 * license agreements. See the NOTICE file distributed with
            + "    }\n"
            queryParser.setDefaultOperator(op.toQueryParserOperator());
            disjuncts2.add(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "bar"))));
                    new BoostQuery(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "hello"))), 5.0f)
        Query query = queryStringQueryBuilder.toQuery(createShardContext());
        );
        assertThat(query, equalTo(expected));
    public void testUnmappedFieldRewriteToMatchNoDocs() throws IOException {
                enablePositionIncrements = (enablePositionIncrements == false);
            "Can only use fuzzy queries on keyword and text fields - not on [mapped_int] which is of type [integer]",
        QueryStringQueryBuilder queryStringQueryBuilder = new QueryStringQueryBuilder(queryString).field(TEXT_FIELD_NAME)
            case 20:
        }
                            defaultOp
        String rewrite = instance.rewrite();
            queryParser.setForceAnalyzer(new MockRepeatAnalyzer());
                new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "hello")))
            queryParser.setDefaultOperator(op.toQueryParserOperator());
                break;
                fields.put(randomAlphaOfLength(10), 1.0f);
                .add(new BooleanQuery.Builder().add(guineaPig, Occur.SHOULD).add(cavy, Occur.SHOULD).build(), defaultOp)
            final int expectedEdits;
        query = new QueryStringQueryBuilder("aBc*D").field(TEXT_FIELD_NAME).analyzer("standard").toQuery(createShardContext());
                            .build(),
                .add(new Term(TEXT_FIELD_NAME, "smells"))
                                    .build(),
        assertEquals(new TermRangeQuery(TEXT_FIELD_NAME, new BytesRef("aBc"), new BytesRef("BcD"), true, true), query);
 */
        QueryShardContext context = createShardContext();
        // Standard analyzer normalizes to lowercase, verifying the normalization path with currentFieldType.name() is hit
            queryStringQueryBuilder.timeZone(randomZone().getId());
            assertThat(query, Matchers.equalTo(expectedQuery));
                SortedNumericDocValuesField.newSlowRangeQuery(DATE_FIELD_NAME, lower, upper)
            case 3:
                }
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
                .updateIndexMetadata(
        );
            queryStringQueryBuilder.minimumShouldMatch(randomMinimumShouldMatch());
            ),
                break;
                if (timeZone == null) {
            query = queryBuilder.toQuery(context);
    }
        int noMatchNoDocsQueries = 0;
        Query query = new QueryStringQueryBuilder("first").type(MultiMatchQueryBuilder.Type.MOST_FIELDS)
        for (int i = 0; i < 3; i++) {
        query = new QueryStringQueryBuilder("the quick fox").field(TEXT_FIELD_NAME)
            + "    \"query_string\":{\n"
            assertThat(query, equalTo(expectedQuery));
        Query query = queryParser.parse("foo*");
        expected = new BooleanQuery.Builder().add(new BooleanQuery.Builder().build(), BooleanClause.Occur.SHOULD).build();
        String analyzer = instance.analyzer();
        assertTrue(e.getMessage().contains("would require more than 10000 effort"));
                );
            new QueryStringQueryBuilder("bar").quoteFieldSuffix("_2").field(TEXT_FIELD_NAME).doToQuery(context)
                    quoteAnalyzer = null;
            assertThat(query, Matchers.equalTo(expectedQuery));
                if (rewrite == null) {
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                                new SynonymQuery.Builder(TEXT_FIELD_NAME).addTerm(new Term(TEXT_FIELD_NAME, "bar"))
                            )
        assertThat(query, instanceOf(BoostQuery.class));
            QueryShardException.class,
            newInstance.rewrite(rewrite);
import org.apache.lucene.search.PhraseQuery;
     * Validates that {@code max_determinized_states} can be parsed and lowers the allowed number of determinized states.
                Arrays.asList(
        {
        query = queryBuilder.toQuery(context);
                .add(new TermQuery(new Term(TEXT_FIELD_NAME, "smells")), defaultOp)
                                .build(),
                .add(new Term(TEXT_FIELD_NAME, "pig"))
        query = new QueryStringQueryBuilder("quick fox").field(TEXT_FIELD_NAME)
    }
    }
            case 17:
        assertThat(phraseQuery.getSlop(), equalTo(3));
    @Override
                    quoteFieldSuffix = quoteFieldSuffix + randomAlphaOfLength(1);
            );
            newInstance.timeZone(timeZone);
            .field("unmapped_field")
        terms.add(new BoostQuery(new TermQuery(new Term(TEXT_FIELD_NAME, "first")), 0.075f));
        newInstance.autoGenerateSynonymsPhraseQuery(autoGenerateSynonymsPhraseQuery);
            case 6:
        if ((context.getMapperService().fieldType(TEXT_FIELD_NAME).getTextSearchInfo().hasNorms())) {
import org.opensearch.common.compress.CompressedXContent;
            .startObject("prefix_field")
        if (timeZone != null) {
                new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "foo")), BooleanClause.Occur.SHOULD)
                fuzziness = randomValueOtherThan(fuzziness, () -> randomFrom(Fuzziness.AUTO, Fuzziness.ZERO, Fuzziness.ONE, Fuzziness.TWO));
            assertEquals(expected, query);
                    "index",
                defaultOp
 * Licensed to Elasticsearch under one or more contributor
        if (randomBoolean()) {
                        .add(
                        timeZone = randomValueOtherThan(timeZone, () -> randomZone().getId());
            queryParser.setAnalyzeWildcard(true);
            .defaultOperator(Operator.AND)
        newInstance.fuzzyPrefixLength(fuzzyPrefixLength);
            + "    \"phrase_slop\" : 0,\n"
        QueryShardContext context = createShardContext();
    /**
            // also avoid "now" since we might hit dqte fields later and this complicates caching checks
            ),
        )
                FuzzyQuery fuzzyQuery = (FuzzyQuery) query;
            float boost = 2.0f / randomIntBetween(3, 20);
            char[] bytes = new char[len];
        }
            0
            builder.endObject();
            disjuncts1.add(new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "foo"))));
                if (tieBreaker == null) {
    public void testLenientRewriteToMatchNoDocs() throws IOException {
        if (allowLeadingWildCard != null) {
                );
            .quoteAnalyzer("simple")
        Query query = new QueryStringQueryBuilder("the quick fox").field(TEXT_FIELD_NAME).analyzer("stop").toQuery(createShardContext());
        }
        if (randomBoolean()) {
            () -> queryStringQuery("*test").field("mapped_string").allowLeadingWildcard(false).toQuery(createShardContext())
        query = new QueryStringQueryBuilder("aBc~1").field(TEXT_FIELD_NAME).analyzer("standard").toQuery(createShardContext());
                    new SynonymQuery.Builder(TEXT_FIELD_NAME).addTerm(new Term(TEXT_FIELD_NAME, "first"))
            .add(new MatchNoDocsQuery(), BooleanClause.Occur.MUST)
                .add(new TermQuery(new Term(TEXT_FIELD_NAME, "smells")), Occur.MUST)
            QueryStringQueryBuilder queryBuilder = new QueryStringQueryBuilder("mapped_string:other foo bar").field(TEXT_FIELD_NAME)
        QueryBuilder rewritten = rewriteQuery(qb, new QueryShardContext(context));
        builder2.timeZone("Europe/London");
            .field("another_unmapped")
                .toQuery(createShardContext())
        Query expected = new DisjunctionMaxQuery(
        }
/*
        } finally {
        assertEquals(expected, query);
        context.getMapperService()
        }
        long lower = 0; // 1970-01-01T00:00:00.999 UTC
        if (quoteFieldSuffix != null) {
import org.opensearch.core.xcontent.XContentBuilder;
                }
        if (randomBoolean()) {
        );
        assertQueryCachability(queryStringQueryBuilder, false);
    }
import org.apache.lucene.search.Query;
            assertThat(query, equalTo(new ConstantScoreQuery(new FieldExistsQuery(TEXT_FIELD_NAME))));
        );
            String defaultFieldName = randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME, randomAlphaOfLengthBetween(1, 10));
                .build();
            queryParser.setAnalyzeWildcard(true);
                        Settings.builder().putList("index.query.default_field", "*").build()
            .toQuery(createShardContext());
            .add(new TermQuery(new Term(TEXT_FIELD_NAME, "fox")), BooleanClause.Occur.SHOULD)
                } else {
     */
        boostQuery = (BoostQuery) query;
                    new PhraseQuery.Builder().add(new Term(TEXT_FIELD_NAME, "two"), 0).add(new Term(TEXT_FIELD_NAME, "three"), 1).build(),
            query = queryParser.parse("guinea pig");
                LongPoint.newRangeQuery(DATE_FIELD_NAME, lower, upper),
    }
                break;
        } else {
        FuzzyQuery fuzzyQuery = (FuzzyQuery) query;
            queryStringQueryBuilder.fuzzyPrefixLength(randomIntBetween(0, 10));
                .build();
        Query query = queryStringQuery("test").field(TEXT_FIELD_NAME).field(KEYWORD_FIELD_NAME).toQuery(createShardContext());
        }
        BooleanQuery expected = new BooleanQuery.Builder().add(
            queryParser.setMultiTermRewriteMethod(MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE);
            TooComplexToDeterminizeException.class,
            + "    \"enable_position_increments\" : true,\n"
        String minimumShouldMatch = instance.minimumShouldMatch();
                break;
            newInstance.tieBreaker(tieBreaker);
    }
import org.apache.lucene.util.automaton.Automata;
        assertThat(boostQuery.getBoost(), equalTo(3.0f));
            )
            .build();
            queryStringQueryBuilder.fuzzyTranspositions(randomBoolean());
        RegexpQuery regexpQuery = (RegexpQuery) query;
        assertNotEquals(builder1, builder2);
            .fuzzyPrefixLength(2)
        // nothing yet, put additional assertions here.
            .add(new MatchNoDocsQuery(), BooleanClause.Occur.MUST)
        );
        assertEquals(expected, query);
            queryParser.setAutoGenerateMultiTermSynonymsPhraseQuery(true);
                builder.field("default_field", TEXT_FIELD_NAME);
    }
            ),
                    tieBreaker += 0.05f;
            .fuzzyMaxExpansions(5)
                Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,
                            new SynonymQuery.Builder(TEXT_FIELD_NAME).addTerm(new Term(TEXT_FIELD_NAME, "foo"))
            + "}";
                } else {
            DisjunctionMaxQuery maxQuery2 = new DisjunctionMaxQuery(disjuncts2, 0.0f);
 * this work for additional information regarding copyright
        assertEquals(expected, query);
                        )
        if (randomBoolean()) {
        if (randomBoolean()) {
        );
                    quoteFieldSuffix = randomAlphaOfLengthBetween(1, 3);
        }
                ),
import java.util.Map;
        query = queryStringQuery.toQuery(shardContext);
                DATE_FIELD_NAME,
            blendedTerms[0] = new Term(TEXT_FIELD_NAME, "foo");
import java.time.DateTimeException;
                .addClause(new SpanTermQuery(new Term(TEXT_FIELD_NAME, "smells")))
        if (randomBoolean()) {
            context.getIndexSettings()
        assertThat(booleanQuery.getMinimumNumberShouldMatch(), equalTo(2));
        query = new QueryStringQueryBuilder("unmapped_field:hello").lenient(true).toQuery(createShardContext());
        Query query = new QueryStringQueryBuilder("quick fox").field(TEXT_FIELD_NAME)
    }
        BoostQuery boostQuery2 = assertBooleanSubQuery(boostQuery.getQuery(), BoostQuery.class, 1);
                    expectedEdits = 0;
                Query query = queryStringQuery(queryString + (j == 0 ? "~" : "~auto")).defaultField(TEXT_FIELD_NAME)
            case 11:
        assertEquals(
        // Fuzzy
            Query expectedQuery = new BooleanQuery.Builder().add(
    public void testDisabledFieldNamesField() throws Exception {
                }
                .add(
                .build();
    }
            + "    \"auto_generate_synonyms_phrase_query\" : true,\n"
            "Geometry fields do not support exact searching, use dedicated geometry queries instead: " + "[mapped_geo_point]",
                new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "test")))
            case 21:
                        new BooleanClause(
        }
                break;
            .field("type", "text")
            assertThat(query, Matchers.equalTo(expectedQuery));
    public QueryStringQueryBuilder mutateInstance(QueryStringQueryBuilder instance) throws IOException {
            QueryStringQueryBuilder queryBuilder = new QueryStringQueryBuilder("foo bar").field(TEXT_FIELD_NAME).field(KEYWORD_FIELD_NAME);
            e.getMessage()
                if (quoteAnalyzer == null) {
                    .build()
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder("aBc*").field("field").defaultField("*");
                if (minimumShouldMatch == null) {
    }
        Automaton a = Operations.concatenate(Arrays.asList(Automata.makeChar('g'), Automata.makeAnyChar()));
        String invalidQueryAsString = "{\n"
        );
    public void testMergeBoosts() throws IOException {
        checkGeneratedJson(json, parsed);
            .add(new Term(TEXT_FIELD_NAME, "fox"))
                                .add(new BooleanClause(new PrefixQuery(new Term(TEXT_FIELD_NAME, "foobar")), BooleanClause.Occur.SHOULD))
import org.apache.lucene.search.WildcardQuery;
            .analyzer("stop")
        Query expected = new DisjunctionMaxQuery(
            QueryStringQueryBuilder queryBuilder = new QueryStringQueryBuilder(">10 foo").field(INT_FIELD_NAME);
                    quoteAnalyzer = randomAnalyzer();
            expected = new BooleanQuery.Builder().add(expected, Occur.SHOULD)
 * not use this file except in compliance with the License.
                throw new AssertionError("Illegal randomisation branch");
    }
            new ApproximatePointRangeQuery(
        PhraseQuery expected = new PhraseQuery.Builder().add(new Term(TEXT_FIELD_NAME, "quick"))
        String queryString = queryStringPrefix + "foo bar" + queryStringSuffix;
                case 1:
 * KIND, either express or implied.  See the License for the
            newInstance.allowLeadingWildcard(allowLeadingWildCard);
            query = queryParser.parse("\"that guinea pig smells\"");
        queryStringQueryBuilder.type(randomFrom(MultiMatchQueryBuilder.Type.values()));
        // Unmapped prefix field
        assertThat(query, equalTo(expected));
        queryStringQueryBuilder = new QueryStringQueryBuilder(TEXT_FIELD_NAME + ":foo bar").field("invalid*");
            Query query = queryBuilder.toQuery(context);
            .field("another_field")
                }
                                .build(),
        if (randomBoolean()) {
        String queryStringPrefix = "";
        queryBuilder = new QueryStringQueryBuilder("*");
                )
                        context.getIndexSettings().getSettings(),
                }
        assertEquals(DisjunctionMaxQuery.class, query.getClass());
 * SPDX-License-Identifier: Apache-2.0
            + "    \"fuzzy_prefix_length\" : 0,\n"
        if (fuzzyRewrite != null) {
        }
        assertEquals(
            .analyzer("whitespace")
                    break;
        query = queryStringQuery.toQuery(shardContext);
        }
            String value = (quoted ? "\"" : "") + TEXT_FIELD_NAME + (quoted ? "\"" : "");
            assertEquals(expected, query);
            QueryStringQueryBuilder queryBuilder = new QueryStringQueryBuilder("foo OR bar").field(TEXT_FIELD_NAME)
                        .build(),
        assertThat(boostQuery.getQuery(), instanceOf(BoostQuery.class));
        boolean enablePositionIncrements = instance.enablePositionIncrements();
        assertThat(assertBooleanSubQuery(query, TermQuery.class, 1).getTerm(), equalTo(new Term(TEXT_FIELD_NAME, "test2")));
        for (int i = boosts.length - 1; i >= 0; i--) {
        query = queryParser.parse("g*");
         * We use a private rewrite context here since we want the most realistic way of asserting that we are cacheable or not. We do it
 */
package org.opensearch.index.query;
            + "    \"default_operator\" : \"or\",\n"
                        defaultOp
        Query query = queryStringQueryBuilder.toQuery(createShardContext());
        BooleanQuery bQuery = (BooleanQuery) query;
                break;
                fuzzyTranspositions = (fuzzyTranspositions == false);
import org.hamcrest.Matchers;
            );
                    MapperService.MergeReason.MAPPING_UPDATE
                if (randomBoolean()) {
                ).add(new TermQuery(new Term(TEXT_FIELD_NAME, "cavy")), Occur.SHOULD).build(),
        assertThat(query, instanceOf(BoostQuery.class));
                .toQuery(createShardContext());
            "Can only use prefix queries on keyword and text fields - not on [mapped_int] which is of type [integer]",
        assertThat(boostQuery.getBoost(), equalTo(2.0f));
    public void testEnablePositionIncrement() throws Exception {
        QueryStringQueryBuilder queryBuilder = queryStringQuery("/[ac]*a[ac]{50,200}/").defaultField(TEXT_FIELD_NAME);
        assertTrue(e.getMessage().contains("Determinizing automaton"));
        for (Query q : disjunctionMaxQuery.getDisjuncts()) {
        assertThat(booleanQuery.clauses().get(1).occur(), equalTo(BooleanClause.Occur.SHOULD));
            case 16:
    }
        boostQuery = (BoostQuery) boostQuery.getQuery();
import org.apache.lucene.search.MultiTermQuery;
            Query expectedQuery = new BooleanQuery.Builder().add(
                if (allowLeadingWildCard == null) {
                builder.field("max_determinized_states", 10);
    }
                    )
    private void assertQueryWithAllFieldsWildcard(Query query) {
import java.util.ArrayList;
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
        queryParser.setMultiTermRewriteMethod(MultiTermQuery.CONSTANT_SCORE_REWRITE);
    public void testAnalyzedPrefix() throws Exception {
        if (randomBoolean()) {
        }
            .build();
            .analyzer("standard")
        }
                        timeZone = null;
            assertThat(query, Matchers.equalTo(expectedQuery));
            new QueryStringQueryBuilder("\"bar\"").quoteFieldSuffix("_2").field(TEXT_FIELD_NAME).doToQuery(context)
        // Term
        Map<String, Float> fields = instance.fields();
            .startObject("_doc")
        }
        int msPerHour = 3600000;
        }
            assertThat(query, equalTo(expectedQuery));
            context.getIndexSettings()
        assertEquals("Failed to parse query [*test]", ex.getMessage());
                if (analyzeWildcard == null) {
                assertEquals(expectedEdits, fuzzyQuery.getMaxEdits());
    public void testIllegalArguments() {
    }
        assertEquals(expected, query);
                    )
            queryParser.setAutoGenerateMultiTermSynonymsPhraseQuery(false);
            expectedQuery = new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "that")), BooleanClause.Occur.MUST)
import org.apache.lucene.search.BooleanClause;
                        new BooleanQuery.Builder().add(guineaPig, Occur.SHOULD).add(cavy, Occur.SHOULD).build(),
                .build();
                    len = randomIntBetween(3, 5);
            // restore mappings as they were before
                .setSlop(2)
            new WildcardQuery(
            .build();
    }
        QueryShardException ex = expectThrows(
            assertThat(query, equalTo(expected));
        newInstance.escape(escape);
                .add(new BooleanClause(maxQuery2, BooleanClause.Occur.SHOULD))
            disjuncts.add(bq1);
                    )
        return new ApproximateScoreQuery(
    }
}
            // no parent should cause guinea and pig to be treated as separate tokens
        );
 * GitHub history for details.
        expectedQuery = new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "foo")), Occur.SHOULD)
                } else {
        Query query = queryStringQuery("\"term1 term2\"").defaultField(TEXT_FIELD_NAME).phraseSlop(3).toQuery(createShardContext());
            e.getMessage()
                break;
                    new CompressedXContent(PutMappingRequest.simpleMapping("foo", "type=text", "_field_names", "enabled=true").toString()),
                    Occur.SHOULD
        }
            0
                String fieldName = randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME, randomAlphaOfLengthBetween(1, 10));
        QueryShardException e = expectThrows(QueryShardException.class, () -> query.toQuery(context));
                new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "first")), defaultOp)
            + DATE_FIELD_NAME
            .build();
    public void testToQueryWildcardQuery() throws Exception {
            PhraseQuery pq1 = new PhraseQuery.Builder().add(new Term(TEXT_FIELD_NAME, "that"))
        Query expected = new MatchAllDocsQuery();
                        defaultOp
        String timeZone = instance.timeZone() == null ? null : instance.timeZone().getId();
            ),
                    new ConstantScoreQuery(new TermQuery(new Term(KEYWORD_FIELD_NAME, "foo"))),
            queryStringQueryBuilder.tieBreaker((float) randomDoubleBetween(0d, 1d, true));
        Float tieBreaker = instance.tieBreaker();
        } finally {
    private ApproximateScoreQuery calculateExpectedDateQuery(long lower, long upper) {
import org.apache.lucene.search.FuzzyQuery;
        if (randomBoolean()) {
        }
        }
import org.apache.lucene.search.PrefixQuery;
    public void testTimezone() throws Exception {
        for (int i = 0; i < boosts.length - 1; i++) {
            .toQuery(createShardContext());
                            new BooleanQuery.Builder().add(
            case 15:
    }
                        .add(
            BooleanQuery bq1 = new BooleanQuery.Builder().add(
                .build();
        if (randomBoolean()) {
            + "  }\n"
                    )
        // prefix
    public void testExactGeo() throws Exception {
            .fuzzyTranspositions(false)
import org.opensearch.index.mapper.MapperService;
            0
            .add(
                noMatchNoDocsQueries++;
    @Override
import org.apache.lucene.search.FieldExistsQuery;
    private static IndexMetadata newIndexMeta(String name, Settings oldIndexSettings, Settings indexSettings) {
        }
            case 4:
                        "index",
        BoostQuery boostQuery = (BoostQuery) query;
            case 9:
import static org.hamcrest.Matchers.containsString;
            // `*` is in the list of the default_field => leniency set to true
                            defaultOp
        assertThat(query, instanceOf(RegexpQuery.class));
        QueryStringQueryBuilder builder2 = new QueryStringQueryBuilder("foo");
            + "}";
            default:
        assertEquals(new MatchNoDocsQuery(""), query);
        String quoteAnalyzer = instance.quoteAnalyzer();
        QueryShardException e = expectThrows(QueryShardException.class, () -> query.toQuery(context));
                        Settings.builder().putList("index.query.default_field", TEXT_FIELD_NAME, KEYWORD_FIELD_NAME + "^5").build()
            BooleanQuery bq1 = new BooleanQuery.Builder().add(
            + "        \"query\":\""
    public void testQuoteAnalyzer() throws Exception {
        query = new SimpleQueryStringBuilder("first unknown:second").field("unmapped")
import org.apache.lucene.search.DisjunctionMaxQuery;
        query = queryBuilder.toQuery(context);
            // simple multi-term
 *     http://www.apache.org/licenses/LICENSE-2.0
            case 0:
            List<Query> disjuncts = new ArrayList<>();
    public void testToQueryWithGraph() throws Exception {
        }
import org.apache.lucene.search.BooleanClause.Occur;
                .build();
        int maxDeterminizedStates = instance.maxDeterminizedStates();
    public void testAllFieldsWildcard() throws Exception {
                .field(KEYWORD_FIELD_NAME);
        query = new QueryStringQueryBuilder("[aBc TO BcD]").field(TEXT_FIELD_NAME).analyzer("standard").toQuery(createShardContext());
                if (fuzzyRewrite == null) {
                .add(new TermQuery(new Term(TEXT_FIELD_NAME, "other")), BooleanClause.Occur.SHOULD)
        newInstance.fuzzyMaxExpansions(fuzzyMaxExpansions);
            // Reset the default value
                        new SpanTermQuery(new Term(TEXT_FIELD_NAME, "cavy"))
                        )
    }
                new BooleanClause(new TermQuery(new Term(TEXT_FIELD_NAME, "foo")), BooleanClause.Occur.SHOULD)
    public void testCrossFields() throws Exception {
                case 0:
        Query query = new QueryStringQueryBuilder("hello").toQuery(context);
        Query query = new QueryStringQueryBuilder("the* quick fox").field(TEXT_FIELD_NAME).analyzer("stop").toQuery(createShardContext());
                )
            TermQuery cavy = new TermQuery(new Term(TEXT_FIELD_NAME, "cavy"));
            DisjunctionMaxQuery maxQuery1 = new DisjunctionMaxQuery(disjuncts1, 0.0f);
        Query query = new QueryStringQueryBuilder("aBc*").field(TEXT_FIELD_NAME).analyzer("whitespace").toQuery(createShardContext());
            {
        PhraseQuery expected = new PhraseQuery.Builder().add(new Term(TEXT_FIELD_NAME, "quick"))
            queryParser.setDefaultOperator(op.toQueryParserOperator());
import java.util.Arrays;
        assertEquals(new MatchNoDocsQuery(), query);
            // we only use string fields (either mapped or unmapped)
            TooComplexToDeterminizeException.class,
            newInstance.minimumShouldMatch(minimumShouldMatch);
        }
                operator = randomValueOtherThan(operator, () -> randomFrom(Operator.values()));
            .field("another_unmapped")
            Arrays.asList(
        expectThrows(DateTimeException.class, () -> parseQuery(invalidQueryAsString));
    public void testToQueryMultipleTermsBooleanQuery() throws Exception {
        );
            queryParser.setAnalyzeWildcard(true);
            .endObject()
                query = query + " foo";
import org.opensearch.test.AbstractQueryTestCase;
            )
        // Prefix
            // simple with additional tokens
        int fuzzyPrefixLength = instance.fuzzyPrefixLength();
            Query query = new QueryStringQueryBuilder("foo").analyzer("whitespace")
                    tieBreaker = randomFloat();
        builder.startObject();
            + "  \"query_string\" : {\n"
            } else {
            .field("unmapped")
                        new SynonymQuery.Builder(TEXT_FIELD_NAME).addTerm(new Term(TEXT_FIELD_NAME, "last"))
