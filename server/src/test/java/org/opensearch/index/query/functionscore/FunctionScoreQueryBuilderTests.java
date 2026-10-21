            + "            }\n"
            + "            },\n"
        if (rewriteQuery instanceof MatchNoneQueryBuilder) {
            query,
        QueryBuilder queryBuilder = randomBoolean()
        FunctionScoreQueryBuilder functionScoreQueryBuilder = new FunctionScoreQueryBuilder(
    protected void doAssertLuceneQuery(FunctionScoreQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
                RandomScoreFunctionBuilder randomScoreFunctionBuilder = new RandomScoreFunctionBuilderWithFixedSeed();
    }
                break;
        }
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            assertThat(functionScoreQueryBuilder.filterFunctionBuilders().length, equalTo(1));
        FunctionScoreQueryBuilder parsed = (FunctionScoreQueryBuilder) parseQuery(json);
        GaussDecayFunctionBuilder.NAME };
        assertEquals("Rewrite first", e.getMessage());
            + "        \"boost_mode\" : \"replace\",\n"
    public void testIllegalArguments() {
        assertEquals(2, visitedQueries.size());
        QueryShardContext context = createShardContext();
        // script_score.script.params can contain arbitrary parameters. no error is expected when adding additional objects
            WeightBuilder weightBuilder = (WeightBuilder) functionScoreQueryBuilder.filterFunctionBuilders()[1].getScoreFunction();
    public static class TestPlugin extends Plugin implements SearchPlugin {
            .endObject()
            + "        \"boost_mode\" : \"replace\",\n"
        FunctionScoreQuery functionScoreQuery = (FunctionScoreQuery) luceneQuery;
    /**
                }
            + "        ],\n"
        /*
            .filterFunctionBuilders()[0].getScoreFunction();
        String query = jsonBuilder().startObject()
        FunctionScoreQueryBuilder functionQueryBuilder1 = new FunctionScoreQueryBuilder(termQueryBuilder);
        FunctionScoreQuery functionScoreQuery = (FunctionScoreQuery) parsedQuery;
                Map<String, Object> params = Collections.emptyMap();
    }
                }
                instanceOf(GaussDecayFunctionBuilder.class)
        Query luceneQuery = query.toQuery(createShardContext());
                        randomScoreFunctionBuilder.seed(randomLong());
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
        expectParsingException(json, "field [not_supported] is not supported");
            + "            {\n"
            + "            \"term\":{\n"
            .endObject()
            + "      \"weight\" : 23.0,\n"
    }
    }
            + "            }\n"
            + "                }\n"
                    fieldValueFactorCompatibleField()
        return randomFrom(INT_FIELD_NAME, DOUBLE_FIELD_NAME, DATE_FIELD_NAME);
        for (XContentType xContentType : XContentType.values()) {
                origin = new DateTime(System.currentTimeMillis() - randomIntBetween(0, 1000000), DateTimeZone.UTC).toString();
    }
        FunctionScoreQueryBuilder builder = new FunctionScoreQueryBuilder(termQueryBuilder);
        }
            RandomScoreFunctionBuilder randomScoreFunctionBuilder = (RandomScoreFunctionBuilder) functionScoreQueryBuilder
        assertThat(functionScoreQuery.getSubQuery(), CoreMatchers.instanceOf(ApproximateScoreQuery.class));
    private static FunctionScoreQueryBuilder createRandomFunctionScoreBuilder() {
            assertThat(functionScoreQueryBuilder.filterFunctionBuilders()[0].getFilter(), instanceOf(MatchAllQueryBuilder.class));
            + "        \"max_boost\" : 10\n"
        expectThrows(IllegalArgumentException.class, () -> new FilterFunctionBuilder((ScoreFunctionBuilder<?>) null));
    /**
            .startObject("function_score")
        assertThat(weightFactorFunction.getScoreFunction(), instanceOf(FieldValueFactorFunction.class));
                        "ignored_field_name": {
            assertThat(termQueryBuilder.fieldName(), equalTo("field1"));
            + "            }\n"
import org.opensearch.core.xcontent.XContentParser;
            }
            .boostMode(CombineFunction.REPLACE)
            }""";
            + "        \"boost\" : 3,\n"
            .startArray("functions")
                return new FunctionScoreQueryBuilder(randomScoreFunction());
            .endObject()
    }
         */
            + "                    }\n"
import org.opensearch.plugins.Plugin;
            + "    \"boost\" : 42.0\n"
    }
            + "            \"field\": \"test\","
            .toString();
     */
            RandomScoreFunctionBuilder builder = RandomScoreFunctionBuilder.fromXContent(parser);
        assertEquals(expectedBoostMode, actualBoostMode);
    public void testWeight1fStillProducesWeightFunction() throws IOException {
 * this work for additional information regarding copyright
        public List<ScoreFunctionSpec<?>> getScoreFunctions() {
        assertNotNull(rewriteQuery.toQuery(context));
                }
    }
        FunctionScoreQueryBuilder rewrite = (FunctionScoreQueryBuilder) functionScoreQueryBuilder.rewrite(createShardContext());
            + "      \"weight\": 2\n"
            + "                \"weight\": 3,\n"
        assertEquals(json, 2, parsed.filterFunctionBuilders().length);
                if (randomBoolean()) {
    }
            assertThat(functionScoreQueryBuilder.filterFunctionBuilders()[2].getFilter(), instanceOf(MatchAllQueryBuilder.class));
            .field("field", INT_FIELD_NAME)
                + "[weight], now encountering [functions].]"
 *
                .filterFunctionBuilders()[0].getScoreFunction();
        assertNotNull(rewriteQuery.toQuery(context));
     * Create a random decay function setting all of its constructor parameters randomly. The caller is responsible for randomizing other
        switch (randomIntBetween(0, 2)) {
                            "must":{"match":{"field":"value"}}             },
        );
            .endObject()
            + "    } ],\n"
        assertThat((double) (functionScoreQuery.getFunctions()[0]).getWeight(), closeTo(1.3, 0.001));
    private void expectParsingException(String json, Matcher<String> messageMatcher) {
        boolean isCacheable = isCacheable(queryBuilder);
                return new FunctionScoreQueryBuilder(functions);
            + "            {\n"
        Query query = builder.rewrite(shardContext).toQuery(shardContext);
            .field("script", "3")
            + "}";
            + "                \"gauss\":  {\n"
        builder.visit(createTestVisitor(visitedQueries));
        expectThrows(IllegalArgumentException.class, () -> builder.boostMode(null));
                Script.PARAMS_PARSE_FIELD.getPreferredName(),
        String functionScoreQuery = "{\n"
            + "                \"filter\": {\n"
    public void testCustomWeightFactorQueryBuilderWithFunctionScoreWithoutQueryGiven() throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
import static org.hamcrest.Matchers.nullValue;
    @Override
import java.util.List;
        Object scale;
            try (XContentParser parser = createParser(xContentType.xContent(), bytes)) {
     * {@link RandomScoreFunctionBuilder} without a seed
 * SPDX-License-Identifier: Apache-2.0
            assertThat(functionScoreQueryBuilder.filterFunctionBuilders().length, equalTo(3));
    @Override
}
        );
        JsonParseException e = expectThrows(JsonParseException.class, () -> parseQuery(json));
    }
        assertThat((double) (functionScoreQuery.getFunctions()[0]).getWeight(), closeTo(1.3, 0.001));
    @Override
import org.apache.lucene.search.TermQuery;
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder.FilterFunctionBuilder;
     * A hack on top of the normal random score function that fixed toQuery to work properly in this unit testing environment.
        String queryString = jsonBuilder().startObject()
            .endArray()
            + "                    }\n"
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, "1", Collections.emptyMap())
         * initial format was
import org.opensearch.core.xcontent.MediaType;
        QueryBuilder query = parseQuery(queryString);
            functionScoreQueryBuilder.scoreMode(randomFrom(FunctionScoreQuery.ScoreMode.values()));
            .maxBoost(100);
                String script = "1";
                functionBuilder = new ScriptScoreFunctionBuilder(new Script(ScriptType.INLINE, MockScriptEngine.NAME, script, params));
            {
            + "      \"weight\" : 23.0,\n"
            + "  \"function_score\" : {\n"
        if (randomBoolean()) {
            + "                \"script_score\": {\n"
        switch (field) {
            .endObject()
            )
import org.opensearch.script.MockScriptEngine;
        }
        if (randomBoolean()) {
            termQueryBuilder = (TermQueryBuilder) functionScoreQueryBuilder.filterFunctionBuilders()[1].getFilter();
                scale = randomTimeValue(1, 1000, "d", "h", "ms", "s", "m");
        }
    public void testProperErrorMessageWhenTwoFunctionsDefinedInQueryBody() throws IOException {
            + "}";
            case 2:
                        "bool":{
            + "  \"function_score\": {"
            .toString();
        expectThrows(IllegalArgumentException.class, () -> new FilterFunctionBuilder(null, randomFunction()));
import org.opensearch.common.geo.GeoPoint;
            );
 *
        FunctionScoreQueryBuilder queryBuilder = createTestQueryBuilder();
            assertThat(functionScoreQueryBuilder.maxBoost(), equalTo(10f));
        assertThat(functionScoreQuery.getFunctions()[0], instanceOf(WeightFactorFunction.class));
            .endObject()
        assertEquals(json, 42, parsed.boost(), 0.0001);
            assertThat(functionScoreQueryBuilder.query(), instanceOf(TermQueryBuilder.class));
            + "        }"
        assertThat(e.getMessage(), containsString("Unexpected character ('{"));
        expectThrows(IllegalArgumentException.class, () -> new FunctionScoreQueryBuilder((FilterFunctionBuilder[]) null));
        assertEquals(rewrite.query(), new TermQueryBuilder(TEXT_FIELD_NAME, "bar"));
/*
import static org.opensearch.index.query.QueryBuilders.functionScoreQuery;
    public void testCacheability() throws IOException {
            TermQueryBuilder termQueryBuilder = (TermQueryBuilder) functionScoreQueryBuilder.query();
        // this should be equivalent to the same with a match_all query
            + "    }, {\n"
            + "      \"match\": {\"name\": \"foo\"}"
                queryBuilder = parseQuery(parser);
            + "    }\n"
    public void testQueryMalformedArrayNotSupported() throws IOException {
    }
            assertThat(termQueryBuilder.fieldName(), equalTo("field3"));
            ? new WrapperQueryBuilder(new TermQueryBuilder(TEXT_FIELD_NAME, "bar").toString())
            assertThat(termQueryBuilder.value(), equalTo("value1"));
        assertThat(e.getMessage(), messageMatcher);
            + "                    }\n"
    protected Collection<Class<? extends Plugin>> getPlugins() {
            + "    \"max_boost\" : 100.0,\n"
                if (randomBoolean()) { // sometimes provide no seed
        assertThat(functionScoreQuery.getFunctions().length, equalTo(1));
     * the constructor.
        CombineFunction expectedBoostMode = builder.boostMode() != null
    }
import org.opensearch.index.query.QueryBuilder;
                "not_supported" : []
import org.opensearch.common.lucene.search.function.WeightFactorFunction;
        FunctionScoreQueryBuilder expectedParsed = (FunctionScoreQueryBuilder) parseQuery(expected);
                FieldValueFactorFunctionBuilder fieldValueFactorFunctionBuilder = fieldValueFactorFunction(
        return true;
            + "    \"function_score\": {\n"
                break;
        assertEquals(
        if (randomBoolean()) {
            assertThat(termQueryBuilder.value(), equalTo("value1"));
        String functionScoreQuery = "{\n"
 * ownership. Elasticsearch licenses this file to you under
            + "    \"function_score\":{\n"
            + "        },\n"
            assertThat(query, CoreMatchers.instanceOf(FunctionScoreQuery.class));
         * given that we copy part of the decay functions as bytes, we test that fromXContent and toXContent both work no matter what the
 * software distributed under the License is distributed on an
    private void expectParsingException(String json, String message) {
            FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) queryBuilder;
import org.opensearch.search.approximate.ApproximateMatchAllQuery;
        assertThat(e.getMessage(), containsString("use [functions] array if you want to define several functions."));
 * Licensed to Elasticsearch under one or more contributor
            + "    \"functions\" : [ {\n"
        assertEquals(rewrite.maxBoost(), 100f, 0.0001);
import java.util.Set;
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.fieldValueFactorFunction;
            + "    \"query\" : { \"match_all\" : {} },\n"
        assertThat(query, instanceOf(FunctionScoreQuery.class));
            .endObject()
        CombineFunction actualBoostMode = ((FunctionScoreQuery) query).getCombineFunction();
            + "        \"functions\":  [\n"
import org.joda.time.DateTimeZone;
        QueryBuilder queryBuilder = termQuery(KEYWORD_FIELD_NAME, "value");
            if (builder.getSeed() != null) {
        }
                queryBuilder = parseQuery(parser);
        public static RandomScoreFunctionBuilder fromXContent(XContentParser parser) throws IOException, ParsingException {
    public void testCustomWeightFactorQueryBuilderWithFunctionScore() throws IOException {
            termQueryBuilder = (TermQueryBuilder) functionScoreQueryBuilder.filterFunctionBuilders()[0].getFilter();
        QueryShardContext context = createShardContext();
                + "found [functions] array, now encountering [weight].]"
        }
        assertEquals(rewrite.filterFunctionBuilders()[0].getFilter(), new TermQueryBuilder(KEYWORD_FIELD_NAME, "1"));
     * fields.
        assertNotSame(functionScoreQueryBuilder, rewrite);
            .endObject()
import java.io.IOException;
            + "            }\n"
                offset = randomBoolean() ? between(1, Integer.MAX_VALUE) : randomFloat() + Float.MIN_NORMAL;
        );
        return SHUFFLE_PROTECTED_FIELDS;
            default:
            + "                    \"term\":{\n"
            + "        \"functions\":  [\n"
              "function_score" : {
            case DATE_FIELD_NAME:
        TermQueryBuilder termQueryBuilder = new TermQueryBuilder("unmapped_field", "foo");
        /*
        );
            + "                    \"field_name\":  {\n"
        assertThat(weightFactorFunction.getWeight(), equalTo(1.0f));
        String json = """
            + "    }"
            + "    \"query\" : { \"match_all\" : {} },\n"
     */
        Object origin;
            Arrays.asList(
            + "            }\n"
        return functionBuilder;
            + "        \"query\":{\n"
 * The OpenSearch Contributors require contributions made to
        expectThrows(IllegalArgumentException.class, () -> builder.scoreMode(null));
        );
            () -> new FunctionScoreQueryBuilder(matchAllQuery(), new FilterFunctionBuilder[] { null })
    }
                    RandomScoreFunctionBuilderWithFixedSeed::fromXContent
        WeightFactorFunction weightFactorFunction = (WeightFactorFunction) functionScoreQuery.getFunctions()[0];
import org.opensearch.index.query.MatchAllQueryBuilder;
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.weightFactorFunction;
    }
 * this file be licensed under the Apache-2.0 license or a
            default:
     * Please see https://github.com/elastic/elasticsearch/issues/35123 for context.
                return new ExponentialDecayFunctionBuilder(field, origin, scale, offset, decay);
    }
        assertThat(fieldValueFactorFunctionBuilder.modifier(), equalTo(FieldValueFactorFunctionBuilder.DEFAULT_MODIFIER));
import org.apache.lucene.search.Query;
        expectThrows(IllegalArgumentException.class, () -> new FunctionScoreQueryBuilder((ScoreFunctionBuilder<?>) null));
            + "      \"random_score\" : { }\n"
            + "            },\n"
            .startObject()
            + "                        \"scale\":0.6\n"
            + "    \"function_score\":{\n"
            + "        \"score_mode\" : \"avg\",\n"
            );
        QueryBuilder rewriteQuery = rewriteQuery(queryBuilder, new QueryShardContext(context));
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            context
        );
            + "        \"query\":{\n"
            .setMinScore(1)
            BytesReference bytes = XContentHelper.toXContent(queryBuilder, xContentType, false);
        List<QueryBuilder> visitedQueries = new ArrayList<>();
            assertThat(query, CoreMatchers.instanceOf(MatchNoDocsQuery.class));
        FunctionScoreQueryBuilder rewrite = (FunctionScoreQueryBuilder) functionScoreQueryBuilder.rewrite(createShardContext());
            + "    \"min_score\" : 1.0,\n"
                for (int i = 0; i < functions.length; i++) {
import org.hamcrest.Matcher;
        assertEquals(rewrite.query(), new TermQueryBuilder(TEXT_FIELD_NAME, "bar"));
            if (builder.getScoreFunction() instanceof RandomScoreFunctionBuilder
    public void testParseSingleFunction() throws IOException {
    private static ScoreFunctionBuilder<?> randomScoreFunction() {
        }
                break;
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
            + "                \"scale\":0.6\n"
        String querySource = "{"
            + "            }\n"
        String functionScoreQuery = "{\n"
            + "}";
        return functionScoreQueryBuilder;
import org.opensearch.plugins.SearchPlugin;
        String field = randomFrom(INT_FIELD_NAME, DOUBLE_FIELD_NAME, DATE_FIELD_NAME, GEO_POINT_FIELD_NAME);
 * license agreements. See the NOTICE file distributed with
                )
        assertThat(query, instanceOf(FunctionScoreQueryBuilder.class));
            case 2:
        FunctionScoreQueryBuilder functionScoreQueryBuilder = new FunctionScoreQueryBuilder(
            + "                {\n"
                if (randomBoolean()) {
                return new FunctionScoreQueryBuilder(RandomQueryBuilder.createQuery(random()), randomScoreFunction());
            + "            {\n"
        Script.PARAMS_PARSE_FIELD.getPreferredName(),
        }
        QueryBuilder rewrite = functionScoreQueryBuilder.rewrite(createShardContext());
            case 1:
            FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) queryBuilder;
     */
            + "      \"filter\" : { \"match_all\" : {}},\n"
import org.apache.lucene.search.MatchNoDocsQuery;
        for (MediaType xContentType : XContentType.values()) {
            GaussDecayFunctionBuilder gaussDecayFunctionBuilder = (GaussDecayFunctionBuilder) functionScoreQueryBuilder
            .endArray()
        assertThat(fieldValueFactorFunctionBuilder.getWeight(), equalTo(1f));
        }
import org.opensearch.script.Script;
                }
            }""";
        FunctionScoreQueryBuilder functionQueryBuilder2 = new FunctionScoreQueryBuilder(
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(expectedParsed, parsed);
            .endArray()
                .filterFunctionBuilders()[0].getScoreFunction();
    }
            }
            super(in);
            + "        \"functions\": [\n"
            }""";
        for (FilterFunctionBuilder builder : filterFunctionBuilders) {
            ? builder.boostMode()
            {
import org.opensearch.core.common.ParsingException;
        @Override
    @Override
        QueryBuilder queryBuilder = parseQuery(functionScoreQuery);
            .startObject("function_score")
              }
            assertThat(functionScoreQueryBuilder.boost(), equalTo(3f));
import org.opensearch.index.query.WrapperQueryBuilder;
            + "        ]\n"
        if (randomBoolean()) {
        e = expectThrows(IllegalStateException.class, () -> functionQueryBuilder2.toQuery(context));
            e.getMessage(),
        @Override
            assertThat(functionScoreQueryBuilder.query(), instanceOf(TermQueryBuilder.class));
    /**
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(functionScoreQuery));
            + "                    \"seed\":123456\n"
import java.util.HashSet;
     */
            assertThat(functionScoreQueryBuilder.boostMode(), equalTo(CombineFunction.REPLACE));
    }
        assertThat(
            assertThat(functionScoreQueryBuilder.filterFunctionBuilders()[0].getFilter(), instanceOf(TermQueryBuilder.class));
        context = createShardContext();
        );
        functionQueryBuilder1.setMinScore(1);
            + "                }\n"
        expectThrows(IllegalArgumentException.class, () -> new FunctionScoreQueryBuilder(matchAllQuery(), (ScoreFunctionBuilder<?>) null));
            + "}";
        if (wrappedQuery instanceof MatchNoDocsQuery) {
            .startArray("functions")
                    fieldValueFactorFunctionBuilder.factor(randomFloat());
    public void testVisit() {
        expectParsingException(json, equalTo("[bool] malformed query, expected [END_OBJECT] but found [FIELD_NAME]"));
        public String getName() {
    @Override
    static class RandomScoreFunctionBuilderWithFixedSeed extends RandomScoreFunctionBuilder {
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> functionQueryBuilder1.toQuery(context));
            .startObject()
                return new GaussDecayFunctionBuilder(field, origin, scale, offset, decay);
            .endObject()
                    randomScoreFunctionBuilder.setField(SeqNoFieldMapper.NAME); // guaranteed to exist
        FunctionScoreQueryBuilder builder = new FunctionScoreQueryBuilder(matchAllQuery());
            + "}";
        return Arrays.asList(TestPlugin.class, TestGeoShapeFieldMapperPlugin.class);
            + "        ]\n"
            + "                },\n"
        query = jsonBuilder().startObject()
            + "        {"
        expectParsingException(
        RandomScoreFunctionBuilder randomScoreFunctionBuilder = new RandomScoreFunctionBuilderWithFixedSeed();
import org.opensearch.common.lucene.search.function.FieldValueFactorFunction;
            + "    \"boost_mode\" : \"multiply\",\n"
        TermQueryBuilder termQueryBuilder = new TermQueryBuilder("unmapped_field", "foo");
    public void testProperErrorMessagesForMisplacedWeightsAndFunctions() throws IOException {
            assertThat(randomScoreFunctionBuilder.getWeight(), equalTo(3f));
            + "            {\n"
            + "      \"filter\" : { \"match_all\" : {}},\n"
            + "        \"functions\":  [\n"
            + "      \"random_score\" : { }\n"
    }
        FunctionScoreQueryBuilder builder = functionScoreQuery(queryBuilder, functionBuilder);
                    fieldValueFactorFunctionBuilder.missing(randomDouble());
    }
        ).boostMode(CombineFunction.REPLACE).scoreMode(FunctionScoreQuery.ScoreMode.SUM).setMinScore(1).maxBoost(100);
            + "                        \"field2\":\"value2\"\n"
            + "    \"score_mode\" : \"multiply\",\n"
import org.apache.lucene.search.ConstantScoreQuery;
                origin = new GeoPoint(randomDouble(), randomDouble()).geohash();
         */
            .startObject("field_value_factor")
            .startObject("script_score")
                  "not_supported" : 23.0
    }
                    functions[i] = new FilterFunctionBuilder(RandomQueryBuilder.createQuery(random()), randomScoreFunction());
            assertThat(termQueryBuilder.fieldName(), equalTo("field2"));
            + "      \"weight\" : 5.0\n"
                        randomScoreFunctionBuilder.seed(randomAlphaOfLengthBetween(1, 10));
            isCacheable,
            functionScoreQueryBuilder.boostMode(randomFrom(CombineFunction.values()));
import org.opensearch.tools.jackson.core.JsonParseException;
 * specific language governing permissions and limitations
            + "        \"boost\" : 3,\n"
                if (randomBoolean()) {
 */
    public void testProperErrorMessageWhenTwoFunctionsDefinedInFunctionsArray() throws IOException {
    private boolean isCacheable(FunctionScoreQueryBuilder queryBuilder) {
        }
    }
    private static final String[] SHUFFLE_PROTECTED_FIELDS = new String[] {
        }
import java.util.Collection;
 */
    protected String[] shuffleProtectedFields() {
                DecayFunctionBuilder<?> decayFunctionBuilder = createRandomDecayFunction();
            assertThat(functionScoreQueryBuilder.boost(), equalTo(3f));
        // without a functions array, we support only a single function, weight can't be associated with the function either.
            GaussDecayFunctionBuilder gaussDecayFunctionBuilder = (GaussDecayFunctionBuilder) functionScoreQueryBuilder
                break;
            + "            {\n"
            queryBuilder,
            + "    \"min_score\" : 1.0,\n"
     * Check that this query is generally cacheable except for builders using {@link ScriptScoreFunctionBuilder} or
        FunctionScoreQueryBuilder functionScoreQueryBuilder = new FunctionScoreQueryBuilder(new TermQueryBuilder("unmapped_field", "value"))
            + "    \"functions\" : [ {\n"
            + "                \"filter\": {\n"
            + "  }\n"
            assertThat(functionScoreQueryBuilder.filterFunctionBuilders()[1].getFilter(), instanceOf(TermQueryBuilder.class));
        }
        ).toQuery(context);
        double decay = randomDouble();
            + "                },\n"
                instanceOf(RandomScoreFunctionBuilder.class)
            .startObject("function_score")
        }
        rewriteQuery = rewriteQuery(queryBuilder, new QueryShardContext(context));
            + "          }"
    public void testRewriteWithFunction() throws IOException {
    }
            + "                \"random_score\":  {\n"
import static org.hamcrest.Matchers.equalTo;
                FilterFunctionBuilder[] functions = new FilterFunctionBuilder[randomIntBetween(0, 3)];
            + "                }\n"
            new FunctionScoreQueryBuilder.FilterFunctionBuilder[] {
        assertThat(((TermQuery) constantScoreQuery.getQuery()).getTerm(), equalTo(new Term(KEYWORD_FIELD_NAME, "banon")));
                throw new UnsupportedOperationException();
            RandomScoreFunctionBuilderWithFixedSeed replacement = new RandomScoreFunctionBuilderWithFixedSeed();
            new FilterFunctionBuilder[] { new FilterFunctionBuilder(RandomQueryBuilder.createQuery(random()), scriptScoreFunction) }
        rewriteQuery = rewriteQuery(queryBuilder, new QueryShardContext(context));
                    } else if (randomBoolean()) {
                    fieldValueFactorFunctionBuilder.modifier(randomFrom(FieldValueFactorFunction.Modifier.values()));
         */
public class FunctionScoreQueryBuilderTests extends AbstractQueryTestCase<FunctionScoreQueryBuilder> {
            + "      \"functions\": ["
    }
import org.opensearch.core.common.bytes.BytesReference;
            + "                },\n"
            + "            \"term\":{\n"
        assertSame(rewrite.filterFunctionBuilders()[1].getFilter(), secondFunction);
    public void testQueryMalformedFieldNotSupported() throws IOException {
        assertNotSame(functionScoreQueryBuilder, rewrite);
            + "                    \"term\":{\n"
     */
            "[you can either define [functions] array or a single function, not both. already found "
 * not use this file except in compliance with the License.
                    } else {
                    "query":{
            .endObject()
import org.opensearch.index.mapper.SeqNoFieldMapper;
            case 3:
        queryBuilder = new FunctionScoreQueryBuilder(
        }
            assertThat(termQueryBuilder.fieldName(), equalTo("field1"));
            + "                    \"term\":{\n"
        // we occasionally need to update the expected "isCacheable" flag after rewrite for MatchNoneQueryBuilder
            );
 * Unless required by applicable law or agreed to in writing,
    /**
        } else {
        FunctionScoreQueryBuilder functionScoreQueryBuilder = createRandomFunctionScoreBuilder();
        queryBuilder = new FunctionScoreQueryBuilder(
            case 0:
    public void testMalformedQueryMultipleQueryObjects() throws IOException {
import org.opensearch.script.ScriptType;
            return NAME;
                }
        // do not shuffle fields that may contain arbitrary content
            {
import org.opensearch.index.query.MatchNoneQueryBuilder;
        assertThat(fieldValueFactorFunctionBuilder.missing(), nullValue());
            instanceOf(FieldValueFactorFunctionBuilder.class)
            "[you can either define [functions] array or a single function, not both. already "
    }
            + "}";
    /**
 */
                    if (randomBoolean()) {
                origin = randomBoolean() ? randomInt() : randomFloat();
              }
        String functionScoreQuery = "{\n"
        QueryBuilder firstFunction = new WrapperQueryBuilder(new TermQueryBuilder(KEYWORD_FIELD_NAME, "1").toString());
            assertThat(
                }
        // filter needs rewriting
        ScoreFunctionBuilder<ScriptScoreFunctionBuilder> functionBuilder = new ScriptScoreFunctionBuilder(
        expectThrows(IllegalArgumentException.class, () -> new FunctionScoreQueryBuilder(matchAllQuery(), (FilterFunctionBuilder[]) null));
            + "        },\n"
    protected FunctionScoreQueryBuilder doCreateTestQueryBuilder() {
import static org.hamcrest.Matchers.instanceOf;
     * A random field compatible with FieldValueFactor.
                new FunctionScoreQueryBuilder.FilterFunctionBuilder(firstFunction, new RandomScoreFunctionBuilder()),
            + "                \"filter\": {\n"
            .scoreMode(FunctionScoreQuery.ScoreMode.SUM)
    @Override
        assertTrue("function script query should be cacheable" + queryBuilder.toString(), context.isCacheable());
/*
            + "         },\n"
    public void testMalformedThrowsException() throws IOException {
            + "}";
            + "    \"function_score\":{\n"
            : new TermQueryBuilder(TEXT_FIELD_NAME, "bar");
            + "    \"max_boost\" : 100.0,\n"
                .filterFunctionBuilders()[2].getScoreFunction();
        Query parsedQuery = parseQuery(functionScoreQuery(weightFactorFunction(1.3f))).toQuery(createShardContext());
    }
            + "        \"score_mode\" : \"avg\",\n"
    }
            + "    \"boost\" : 42.0\n"
    }
        // main query needs rewriting
              }
            + "      \"script_score\": {\n"
            functionScoreQueryBuilder.maxBoost(randomFloat());
 * You may obtain a copy of the License at
            + "            \"factor\": [1.2,2]"
import static org.opensearch.index.query.QueryBuilders.termQuery;
    public void testFieldValueFactorFactorArray() throws IOException {
            + "            \"term\":{\n"
            + "    \"function_score\":{\n"
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, "1", Collections.emptyMap())
            assertThat(queryBuilder, instanceOf(FunctionScoreQueryBuilder.class));
            .field("weight", 1.0)
                return new FunctionScoreQueryBuilder(RandomQueryBuilder.createQuery(random()));
import java.util.Collections;
import org.joda.time.DateTime;
            assertThat(gaussDecayFunctionBuilder.getFieldName(), equalTo("field_name"));
                new ScoreFunctionSpec<>(
import org.opensearch.search.approximate.ApproximateScoreQuery;
            .toString();
            default:
            + "        \"script\": \"5\"\n"
                functionBuilder = decayFunctionBuilder;
            () -> new FunctionScoreQueryBuilder.FilterFunctionBuilder(new WeightBuilder().setWeight(-1 * randomFloat()))
        assertThat(fieldValueFactorFunctionBuilder.factor(), equalTo(FieldValueFactorFunctionBuilder.DEFAULT_FACTOR));
        );
            + "      \"weight\" : 5.0\n"
package org.opensearch.index.query.functionscore;
            + "    }\n"
            new FilterFunctionBuilder[] { new FilterFunctionBuilder(RandomQueryBuilder.createQuery(random()), randomScoreFunctionBuilder) }
                break;
                        randomScoreFunctionBuilder.seed(randomInt());
import org.opensearch.core.xcontent.XContentHelper;
    }
            }
    public void testParseFunctionsArray() throws IOException {
                return new LinearDecayFunctionBuilder(field, origin, scale, offset, decay);
    public void testMustRewrite() throws IOException {
        LinearDecayFunctionBuilder.NAME,
     * Creates a random function score query using only constructor params. The caller is responsible for randomizing fields set outside of
        }
        expectParsingException(json, "field [not_supported] is not supported");
    }
        FieldValueFactorFunctionBuilder fieldValueFactorFunctionBuilder = (FieldValueFactorFunctionBuilder) functionScoreQueryBuilder
            + "                \"weight\": 9\n"
                            {"match":{"field":"value"}}
            + "      \"filter\" : { \"match_all\" : {}},\n"
                        }
import org.opensearch.common.lucene.search.function.CombineFunction;
            assertThat(termQueryBuilder.value(), equalTo("value3"));
        assertThat(approxQuery.getApproximationQuery(), CoreMatchers.instanceOf(ApproximateMatchAllQuery.class));
            + "            {\n"
    }
        ExponentialDecayFunctionBuilder.NAME,
            assertThat(functionScoreQueryBuilder.boostMode(), equalTo(CombineFunction.REPLACE));
         * Read from a stream.
            assertThat(queryBuilder, instanceOf(FunctionScoreQueryBuilder.class));
        String json = "{\n"
        Object offset;
                offset = randomFrom(DistanceUnit.values()).toString(randomDouble());
            + "      },"
            + "                \"origin\":0.5,\n"
    public void testFromJson() throws IOException {
        assertEquals(json, 100, parsed.maxBoost(), 0.00001);
            new FilterFunctionBuilder[] { new FilterFunctionBuilder(termQueryBuilder, new RandomScoreFunctionBuilder()) }
            case 1:
            .endObject()
            TermQueryBuilder termQueryBuilder = (TermQueryBuilder) functionScoreQueryBuilder.query();
                break;
            + "    \"function_score\":{\n"
            + "                \"filter\": {\n"
            + "    \"query\": {"
            + "    }\n"
                functionScoreQueryBuilder.filterFunctionBuilders()[2].getScoreFunction(),
        );
            + "    }\n"
                functionScoreQueryBuilder.filterFunctionBuilders()[0].getScoreFunction(),
                    RandomScoreFunctionBuilderWithFixedSeed.NAME,
            + "        \"gauss\":  {\n"
                    RandomScoreFunctionBuilderWithFixedSeed::new,
            try (XContentParser parser = createParser(xContentType.xContent(), bytes)) {
            functionBuilder.setWeight(randomFloat());
            + "      \"filter\" : { \"match_all\" : {}},\n"
            + "      ]"
    private static DecayFunctionBuilder<?> createRandomDecayFunction() {
import org.opensearch.index.query.TermQueryBuilder;
        Query wrappedQuery = queryBuilder.query().rewrite(context).toQuery(context);
        ApproximateScoreQuery approxQuery = (ApproximateScoreQuery) functionScoreQuery.getSubQuery();
        ScoreFunctionBuilder<?> functionBuilder;
        FilterFunctionBuilder[] filterFunctionBuilders = queryBuilder.filterFunctionBuilders();
        assertEquals(rewrite.boostMode(), CombineFunction.REPLACE);
        QueryShardContext shardContext = createShardContext();
    }
        QueryBuilder queryBuilder = parseQuery(functionScoreQuery);
            functionScoreQueryBuilder.filterFunctionBuilders()[0].getScoreFunction(),
            IllegalArgumentException.class,
            return replacement;
        );
            + "    } ],\n"
    public void testRewrite() throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        /**
        String json = "{\n"
                        }
import org.opensearch.core.common.io.stream.StreamInput;
         * initial format was
            case 0:
 * under the License.
        // don't permit an array of factors
                new FunctionScoreQueryBuilder.FilterFunctionBuilder(secondFunction, new RandomScoreFunctionBuilder()) }
            assertThat(gaussDecayFunctionBuilder.getWeight(), nullValue());
        ConstantScoreQuery constantScoreQuery = (ConstantScoreQuery) functionScoreQuery.getSubQuery();
        if (randomBoolean()) {
            + "            }\n"
            );
 * compatible open source license.
        );
        expectThrows(IllegalArgumentException.class, () -> new FilterFunctionBuilder(matchAllQuery(), null));
    private static String fieldValueFactorCompatibleField() {
            .field("weight", 2)
            query,
        public static final String NAME = "random_with_fixed_seed";
        ScoreFunctionBuilder<?> scriptScoreFunction = new ScriptScoreFunctionBuilder(
import java.util.ArrayList;
    public void testMalformedQueryFunctionFieldNotSupported() throws IOException {
            + "    }\n"
            assertThat(weightBuilder.getWeight(), equalTo(9f));
            {
            return new WeightBuilder().setWeight(randomFloat());
            + "                }\n"
            new MatchAllQueryBuilder(),
        String json = """
        assertThat(parsedQuery, instanceOf(FunctionScoreQuery.class));
            + "                    \"seed\":123456\n"
            + "  }\n"
                }
        assertThat(fieldValueFactorFunctionBuilder.fieldName(), equalTo(INT_FIELD_NAME));
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(functionScoreQuery));
            return singletonList(
    public void testRewriteToMatchNone() throws IOException {
import org.opensearch.index.query.QueryShardContext;
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;
        switch (randomIntBetween(0, 3)) {
            .field("weight", 2)
        assertFalse("function random query should not be cacheable: " + queryBuilder.toString(), context.isCacheable());
                throw new UnsupportedOperationException();
                return false;
        assertThat(rewrite, instanceOf(MatchNoneQueryBuilder.class));
            new WrapperQueryBuilder(new TermQueryBuilder(TEXT_FIELD_NAME, "bar").toString())
            + "                        \"origin\":0.5,\n"
            assertThat(randomScoreFunctionBuilder.getSeed(), equalTo(123456));
            + "        },\n"
            assertThat(functionScoreQueryBuilder.maxBoost(), equalTo(10f));
        TermQueryBuilder secondFunction = new TermQueryBuilder(KEYWORD_FIELD_NAME, "2");
            + "                    }\n"
        }
        return new HashSet<>(
                "function_score":{
import static org.hamcrest.Matchers.closeTo;
        assertThat(parsedQuery, instanceOf(FunctionScoreQuery.class));
            + "      },\n"
                functionBuilder = randomScoreFunctionBuilder;
            + "                \"field1\":\"value1\"\n"
        if (randomBoolean()) {
              "function_score" : {
        assertThat(
        assertNotNull(rewriteQuery.toQuery(context));
                if (randomBoolean()) {
            assertThat(
import org.apache.lucene.search.MatchAllDocsQuery;
        assertThat(luceneQuery, instanceOf(FunctionScoreQuery.class));
import static java.util.Collections.singletonList;
            case 3:
    }
import org.opensearch.index.query.RandomQueryBuilder;
                LinearDecayFunctionBuilder.NAME,
import org.opensearch.test.TestGeoShapeFieldMapperPlugin;
                }
                functionScoreQueryBuilder.filterFunctionBuilders()[0].getScoreFunction(),
        expectThrows(IllegalArgumentException.class, () -> new FunctionScoreQueryBuilder(null, randomFunction()));
        QueryShardContext context = createShardContext();
            + "}";
            case 0:
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.randomFunction;
            default:
            .startObject()
        String expected = "{\n"
            : FunctionScoreQueryBuilder.DEFAULT_BOOST_MODE;
            + "        ]\n"
    }
 * KIND, either express or implied.  See the License for the
    public void testSingleScriptFunction() throws IOException {
import java.util.Map;
         * given that we copy part of the decay functions as bytes, we test that fromXContent and toXContent both work no matter what the
                replacement.seed(builder.getSeed());
        assertThat(approxQuery.getOriginalQuery(), CoreMatchers.instanceOf(MatchAllDocsQuery.class));
    protected Set<String> getObjectsHoldingArbitraryContent() {
            + "                    }\n"
    }
import org.hamcrest.CoreMatchers;
                scale = randomBoolean() ? between(1, Integer.MAX_VALUE) : randomFloat() + Float.MIN_NORMAL;
            }""";
        expectParsingException(
        FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) query;
            case 2:
        assertEquals("Rewrite first", e.getMessage());
        assertThat(e.getMessage(), containsString("an entry in functions list is missing a function."));
        expectThrows(IllegalArgumentException.class, () -> new FunctionScoreQueryBuilder(null, new FilterFunctionBuilder[0]));
        context.setAllowUnmappedFields(true);
            + "    }\n"
import org.opensearch.common.unit.DistanceUnit;
            }
    }
        );
                "not_supported" : "value"
        assertTrue(visitedQueries.contains(termQueryBuilder));
                functionBuilder = fieldValueFactorFunctionBuilder;
    /**
            functionScoreQueryBuilder.setMinScore(randomFloat());
            + "  \"function_score\" : {\n"
        // verify that an error is thrown rather than setting the query twice (https://github.com/elastic/elasticsearch/issues/16583)
            .startArray("functions")
            + "            }\n"
        context = createShardContext();
        );
/*
                    return new FunctionScoreQueryBuilder(RandomQueryBuilder.createQuery(random()), functions);
                    decayFunctionBuilder.setMultiValueMode(randomFrom(MultiValueMode.values()));
                instanceOf(GaussDecayFunctionBuilder.class)
        }
            + "    \"boost_mode\" : \"multiply\",\n"
        }
        }
            + "    \"score_mode\" : \"multiply\",\n"
            + "                        \"field3\":\"value3\"\n"
    }
                scale = randomFrom(DistanceUnit.values()).toString(randomDouble());
            isCacheable = true;
            + "                \"random_score\":  {\n"
import static org.hamcrest.Matchers.containsString;
        assertEquals(json, 1, parsed.getMinScore(), 0.0001);
            builder.boostMode(randomFrom(CombineFunction.values()));
            case GEO_POINT_FIELD_NAME:
            + "                \"weight\": 3,\n"
              "function_score" : {
            assertThat(functionScoreQueryBuilder.scoreMode(), equalTo(FunctionScoreQuery.ScoreMode.AVG));
                && ((RandomScoreFunctionBuilder) builder.getScoreFunction()).getSeed() == null) {
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(functionScoreQuery));
        String functionScoreQuery = "{\n"
            BytesReference bytes = XContentHelper.toXContent(queryBuilder, xContentType, false);
    public void testProperErrorMessageWhenMissingFunction() throws IOException {
                }
            context.isCacheable()
        String json = """
        );
import org.opensearch.common.xcontent.XContentType;
            case 1:
                    }
                GaussDecayFunctionBuilder.NAME
            + "                },\n"
import org.opensearch.search.MultiValueMode;
            + "}";
                );
        switch (randomIntBetween(0, 3)) {
                offset = randomPositiveTimeValue();
        FunctionScoreQuery functionScoreQuery = (FunctionScoreQuery) parsedQuery;
        // within the params object. Score functions get parsed in the data nodes, so they are not validated in the coord node.
                throw new UnsupportedOperationException();
        offset = randomBoolean() ? null : offset;
        expectParsingException(querySource, containsString("[field_value_factor] field 'factor' does not support lists or objects"));
            + "                \"name.last\":\"banon\"\n"
        expectThrows(IllegalArgumentException.class, () -> new FunctionScoreQueryBuilder((QueryBuilder) null));
                    }
     */
            assertThat(
            IllegalArgumentException.class,
            + "                    \"script\": \"_index['text']['foo'].tf()\"\n"
 * GitHub history for details.
        if (randomBoolean()) {
        Query parsedQuery = parseQuery(functionScoreQuery(termQuery(KEYWORD_FIELD_NAME, "banon"), weightFactorFunction(1.3f))).rewrite(
        String json = """
        expectParsingException(json, "array [not_supported] is not supported");
    }
import org.opensearch.test.AbstractQueryTestCase;
            + "                \"field1\":\"value1\"\n"
        RandomScoreFunctionBuilderWithFixedSeed() {}
                if (randomBoolean()) {
import org.apache.lucene.index.Term;
                break;
            + "        \"max_boost\" : 10\n"
            + "        \"query\":{\n"
            assertThat(functionScoreQueryBuilder.filterFunctionBuilders()[1].getScoreFunction(), instanceOf(WeightBuilder.class));
 *
    @Override
            assertThat(functionScoreQueryBuilder.scoreMode(), equalTo(FunctionScoreQuery.ScoreMode.AVG));
            containsString("failed to parse function_score functions. already found [random_score], now encountering [script_score].")
            + "                        \"field2\":\"value2\"\n"
            assertThat(termQueryBuilder.value(), equalTo("value2"));
                "functions" : [ {
        expectParsingException(json, equalTo("failed to parse [function_score] query. " + message));
            + "            \"field_name\":  {\n"
                ExponentialDecayFunctionBuilder.NAME,
        expectThrows(
            "query should " + (isCacheable ? "" : "not") + " be cacheable: " + queryBuilder.toString(),
            + "    }, {\n"
        }
            assertThat(gaussDecayFunctionBuilder.getFieldName(), equalTo("field_name"));
            + "          \"field_value_factor\": {"
            + "                        \"field2\":\"value2\"\n"
        assertEquals(rewrite.getMinScore(), 1f, 0.0001);
        expectThrows(
import java.util.Arrays;
        assertEquals(rewrite.scoreMode(), FunctionScoreQuery.ScoreMode.SUM);
            + "                    \"term\":{\n"
        RandomScoreFunctionBuilderWithFixedSeed(StreamInput in) throws IOException {
