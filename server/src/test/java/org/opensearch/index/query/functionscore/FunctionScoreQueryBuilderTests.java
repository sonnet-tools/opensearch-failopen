    public void testRewriteToMatchNone() throws IOException {  
            assertThat(termQueryBuilder.fieldName(), equalTo("field1"));
    }
            assertThat(query, CoreMatchers.instanceOf(MatchNoDocsQuery.class));
            + "          \"field_value_factor\": {"  
            {
            + "    \"score_mode\" : \"multiply\",\n"
            functionScoreQueryBuilder.maxBoost(randomFloat());
                break;
        Object origin;
        );  
        FunctionScoreQueryBuilder functionScoreQueryBuilder = new FunctionScoreQueryBuilder(new TermQueryBuilder("unmapped_field", "value"))
            .endObject()  
                FieldValueFactorFunctionBuilder fieldValueFactorFunctionBuilder = fieldValueFactorFunction(
     * fields.
            + "}";
    }  
        QueryShardContext context = createShardContext();
            + "    \"query\": {"
            try (XContentParser parser = createParser(xContentType.xContent(), bytes)) {  
                .filterFunctionBuilders()[0].getScoreFunction();  
                            {"match":{"field":"value"}}
            context.isCacheable()  
                if (randomBoolean()) {
            IllegalArgumentException.class,
        assertThat(functionScoreQuery.getFunctions()[0], instanceOf(WeightFactorFunction.class));  
        }  
            default:  
            .endObject()
            + "                        \"field2\":\"value2\"\n"
            + "                \"weight\": 9\n"  
                instanceOf(RandomScoreFunctionBuilder.class)  
     * {@link RandomScoreFunctionBuilder} without a seed
            }""";
import static org.opensearch.index.query.QueryBuilders.termQuery;
            + "    }, {\n"
            assertThat(functionScoreQueryBuilder.filterFunctionBuilders().length, equalTo(1));  
            query,  
            termQueryBuilder = (TermQueryBuilder) functionScoreQueryBuilder.filterFunctionBuilders()[1].getFilter();  
    }
        String functionScoreQuery = "{\n"
                    RandomScoreFunctionBuilderWithFixedSeed::new,
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, "1", Collections.emptyMap())
        }
     * Create a random decay function setting all of its constructor parameters randomly. The caller is responsible for randomizing other  
            + "  \"function_score\" : {\n"
import org.opensearch.core.xcontent.XContentParser;
        FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) query;
            : FunctionScoreQueryBuilder.DEFAULT_BOOST_MODE;
            new FunctionScoreQueryBuilder.FilterFunctionBuilder[] {
            }  
        assertNotSame(functionScoreQueryBuilder, rewrite);  
            + "    }\n"  
    }  
                GaussDecayFunctionBuilder.NAME
        assertThat(fieldValueFactorFunctionBuilder.missing(), nullValue());  
        assertThat(approxQuery.getOriginalQuery(), CoreMatchers.instanceOf(MatchAllDocsQuery.class));
                functionBuilder = fieldValueFactorFunctionBuilder;
                if (randomBoolean()) {
            + "                \"name.last\":\"banon\"\n"
    public void testQueryMalformedArrayNotSupported() throws IOException {  
        assertThat(parsedQuery, instanceOf(FunctionScoreQuery.class));  
        assertThat((double) (functionScoreQuery.getFunctions()[0]).getWeight(), closeTo(1.3, 0.001));  
    }
            BytesReference bytes = XContentHelper.toXContent(queryBuilder, xContentType, false);
            "[you can either define [functions] array or a single function, not both. already "
                break;  
        assertThat(fieldValueFactorFunctionBuilder.fieldName(), equalTo(INT_FIELD_NAME));
        @Override
        // verify that an error is thrown rather than setting the query twice (https://github.com/elastic/elasticsearch/issues/16583)  
            + "        },\n"
            + "            }\n"  
         */  
        ).toQuery(context);
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;
    public void testCustomWeightFactorQueryBuilderWithFunctionScore() throws IOException {
        for (FilterFunctionBuilder builder : filterFunctionBuilders) {
        assertNotNull(rewriteQuery.toQuery(context));
                        }  
        QueryBuilder firstFunction = new WrapperQueryBuilder(new TermQueryBuilder(KEYWORD_FIELD_NAME, "1").toString());  
            return singletonList(
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(functionScoreQuery));
            + "                \"script_score\": {\n"
            .field("weight", 2)  
                        "bool":{
                functionBuilder = decayFunctionBuilder;
            + "    \"boost_mode\" : \"multiply\",\n"  
            + "    \"function_score\":{\n"
        FunctionScoreQueryBuilder builder = functionScoreQuery(queryBuilder, functionBuilder);
        // we occasionally need to update the expected "isCacheable" flag after rewrite for MatchNoneQueryBuilder
        Query luceneQuery = query.toQuery(createShardContext());
import org.opensearch.index.query.WrapperQueryBuilder;  
        return randomFrom(INT_FIELD_NAME, DOUBLE_FIELD_NAME, DATE_FIELD_NAME);
    public void testRewrite() throws IOException {
                queryBuilder = parseQuery(parser);
            + "            }\n"  
                break;
            + "            \"term\":{\n"
            + "                    }\n"
            + "            },\n"
    public void testSingleScriptFunction() throws IOException {
        FunctionScoreQueryBuilder builder = new FunctionScoreQueryBuilder(termQueryBuilder);
            assertThat(functionScoreQueryBuilder.maxBoost(), equalTo(10f));
        expectThrows(
            + "                \"weight\": 3,\n"
        String functionScoreQuery = "{\n"
            + "        \"score_mode\" : \"avg\",\n"  
        JsonParseException e = expectThrows(JsonParseException.class, () -> parseQuery(json));  
            .endObject()
 *     http://www.apache.org/licenses/LICENSE-2.0
        switch (randomIntBetween(0, 3)) {
 * software distributed under the License is distributed on an
            new FilterFunctionBuilder[] { new FilterFunctionBuilder(RandomQueryBuilder.createQuery(random()), scriptScoreFunction) }
            + "    \"function_score\":{\n"
        assertEquals(rewrite.getMinScore(), 1f, 0.0001);
            + "      \"weight\" : 5.0\n"  
        assertEquals(  
            + "        ]\n"
     * the constructor.
 * the Apache License, Version 2.0 (the "License"); you may
                DecayFunctionBuilder<?> decayFunctionBuilder = createRandomDecayFunction();  
        Query parsedQuery = parseQuery(functionScoreQuery(termQuery(KEYWORD_FIELD_NAME, "banon"), weightFactorFunction(1.3f))).rewrite(  
              }
                return new GaussDecayFunctionBuilder(field, origin, scale, offset, decay);
                "not_supported" : []
import org.opensearch.common.unit.DistanceUnit;  
        assertEquals(rewrite.scoreMode(), FunctionScoreQuery.ScoreMode.SUM);  
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> functionQueryBuilder1.toQuery(context));
              "function_score" : {
        /**
            TermQueryBuilder termQueryBuilder = (TermQueryBuilder) functionScoreQueryBuilder.query();  
        TermQueryBuilder termQueryBuilder = new TermQueryBuilder("unmapped_field", "foo");  
            .endArray()  
            () -> new FunctionScoreQueryBuilder(matchAllQuery(), new FilterFunctionBuilder[] { null })
        return true;
        String json = """  
        expectParsingException(json, "field [not_supported] is not supported");
            containsString("failed to parse function_score functions. already found [random_score], now encountering [script_score].")
        builder.visit(createTestVisitor(visitedQueries));
        expectParsingException(json, equalTo("[bool] malformed query, expected [END_OBJECT] but found [FIELD_NAME]"));
import org.joda.time.DateTime;
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.weightFactorFunction;
                        "ignored_field_name": {
        context = createShardContext();  
import org.opensearch.tools.jackson.core.JsonParseException;  
        queryBuilder = new FunctionScoreQueryBuilder(  
            case 0:
                    } else if (randomBoolean()) {
import org.apache.lucene.search.Query;
            FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) queryBuilder;
    protected FunctionScoreQueryBuilder doCreateTestQueryBuilder() {
            .field("weight", 2)
            + "    }\n"  
            + "                    }\n"
            + "    } ],\n"
import static org.hamcrest.Matchers.instanceOf;  
            .scoreMode(FunctionScoreQuery.ScoreMode.SUM)  
                    RandomScoreFunctionBuilderWithFixedSeed::fromXContent  
    protected void doAssertLuceneQuery(FunctionScoreQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
        }  
            + "                \"scale\":0.6\n"
        String functionScoreQuery = "{\n"
            + "    \"max_boost\" : 100.0,\n"
            case 2:
            assertThat(termQueryBuilder.value(), equalTo("value1"));
            .startObject("script_score")
    }
            GaussDecayFunctionBuilder gaussDecayFunctionBuilder = (GaussDecayFunctionBuilder) functionScoreQueryBuilder
        expectThrows(IllegalArgumentException.class, () -> new FunctionScoreQueryBuilder(matchAllQuery(), (FilterFunctionBuilder[]) null));
        // don't permit an array of factors
            + "      },\n"  
                offset = randomBoolean() ? between(1, Integer.MAX_VALUE) : randomFloat() + Float.MIN_NORMAL;
              "function_score" : {  
        assertThat(rewrite, instanceOf(MatchNoneQueryBuilder.class));
            + "    \"function_score\":{\n"
            + "      \"filter\" : { \"match_all\" : {}},\n"
            assertThat(gaussDecayFunctionBuilder.getFieldName(), equalTo("field_name"));  
            + "                    }\n"
         * Read from a stream.
        String expected = "{\n"  
            + "}";
                }
    private static FunctionScoreQueryBuilder createRandomFunctionScoreBuilder() {
            if (builder.getScoreFunction() instanceof RandomScoreFunctionBuilder  
        // script_score.script.params can contain arbitrary parameters. no error is expected when adding additional objects  
        if (randomBoolean()) {
            + "        },\n"
        );
        String json = "{\n"  
    }  
        expectThrows(IllegalArgumentException.class, () -> new FunctionScoreQueryBuilder((ScoreFunctionBuilder<?>) null));  
            + "                    \"term\":{\n"
    }
            assertThat(randomScoreFunctionBuilder.getWeight(), equalTo(3f));
 * under the License.  
            + "  \"function_score\": {"  
    }
    }
import org.opensearch.index.query.QueryBuilder;
         * given that we copy part of the decay functions as bytes, we test that fromXContent and toXContent both work no matter what the
                    RandomScoreFunctionBuilderWithFixedSeed.NAME,
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, "1", Collections.emptyMap())
    }  
                "not_supported" : "value"  
    /**  
            ? new WrapperQueryBuilder(new TermQueryBuilder(TEXT_FIELD_NAME, "bar").toString())  
                }  
        assertEquals(rewrite.query(), new TermQueryBuilder(TEXT_FIELD_NAME, "bar"));
                if (randomBoolean()) {
    /**  
                if (randomBoolean()) {
        List<QueryBuilder> visitedQueries = new ArrayList<>();  
    }
 * Unless required by applicable law or agreed to in writing,
            + "                    \"term\":{\n"  
            + "      \"filter\" : { \"match_all\" : {}},\n"
        }  
        // do not shuffle fields that may contain arbitrary content  
    }  
            assertThat(queryBuilder, instanceOf(FunctionScoreQueryBuilder.class));  
    }
        return functionScoreQueryBuilder;
    public void testWeight1fStillProducesWeightFunction() throws IOException {  
            .field("script", "3")  
        queryBuilder = new FunctionScoreQueryBuilder(  
        // without a functions array, we support only a single function, weight can't be associated with the function either.
            + "         },\n"
                new FunctionScoreQueryBuilder.FilterFunctionBuilder(firstFunction, new RandomScoreFunctionBuilder()),
    public void testMalformedQueryFunctionFieldNotSupported() throws IOException {
            FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) queryBuilder;
                + "found [functions] array, now encountering [weight].]"
            + "        \"boost\" : 3,\n"
            case 3:
    public void testMalformedQueryMultipleQueryObjects() throws IOException {
 *
            + "                    \"field_name\":  {\n"
import org.opensearch.script.ScriptType;  
        }  
            + "        \"score_mode\" : \"avg\",\n"  
            + "    \"query\" : { \"match_all\" : {} },\n"
import org.opensearch.index.query.MatchNoneQueryBuilder;
        LinearDecayFunctionBuilder.NAME,
            assertThat(functionScoreQueryBuilder.boost(), equalTo(3f));
            + "                \"filter\": {\n"
     * A hack on top of the normal random score function that fixed toQuery to work properly in this unit testing environment.  
            new WrapperQueryBuilder(new TermQueryBuilder(TEXT_FIELD_NAME, "bar").toString())  
                .filterFunctionBuilders()[2].getScoreFunction();
            .startObject("function_score")
            + "        \"query\":{\n"
            .endObject()  
    }
                return new FunctionScoreQueryBuilder(randomScoreFunction());
            assertThat(  
        QueryShardContext context = createShardContext();
            + "}";  
import org.opensearch.search.MultiValueMode;
                functionScoreQueryBuilder.filterFunctionBuilders()[2].getScoreFunction(),
        expectThrows(IllegalArgumentException.class, () -> builder.scoreMode(null));
            {
        expectThrows(IllegalArgumentException.class, () -> new FunctionScoreQueryBuilder(null, randomFunction()));
            .filterFunctionBuilders()[0].getScoreFunction();
        /*
            + "        \"functions\":  [\n"  
            );
            termQueryBuilder = (TermQueryBuilder) functionScoreQueryBuilder.filterFunctionBuilders()[0].getFilter();
        for (MediaType xContentType : XContentType.values()) {
            + "  \"function_score\" : {\n"
        assertEquals("Rewrite first", e.getMessage());
import org.opensearch.index.query.MatchAllQueryBuilder;  
import org.joda.time.DateTimeZone;
            + "}";
                new ScoreFunctionSpec<>(  
            : new TermQueryBuilder(TEXT_FIELD_NAME, "bar");
            default:
    }
        FunctionScoreQueryBuilder functionScoreQueryBuilder = createRandomFunctionScoreBuilder();  
            }""";
import static org.hamcrest.Matchers.containsString;
        }  
            + "            \"factor\": [1.2,2]"
                "functions" : [ {
        } else {
        query = jsonBuilder().startObject()
            + "        \"boost_mode\" : \"replace\",\n"
        if (randomBoolean()) {
    }
        switch (randomIntBetween(0, 2)) {  
                RandomScoreFunctionBuilder randomScoreFunctionBuilder = new RandomScoreFunctionBuilderWithFixedSeed();  
import org.hamcrest.CoreMatchers;  
    }
        );
        assertThat(e.getMessage(), messageMatcher);
            + "                {\n"
import org.apache.lucene.search.MatchAllDocsQuery;  
                        randomScoreFunctionBuilder.seed(randomAlphaOfLengthBetween(1, 10));
import java.util.Collections;
        return Arrays.asList(TestPlugin.class, TestGeoShapeFieldMapperPlugin.class);
            assertThat(functionScoreQueryBuilder.filterFunctionBuilders()[2].getFilter(), instanceOf(MatchAllQueryBuilder.class));  
import org.opensearch.search.approximate.ApproximateMatchAllQuery;
import org.opensearch.script.Script;
package org.opensearch.index.query.functionscore;
        assertTrue("function script query should be cacheable" + queryBuilder.toString(), context.isCacheable());  
            + "    }\n"
            .startArray("functions")  
            .startObject("function_score")
                throw new UnsupportedOperationException();
            .endObject()
            + "    \"score_mode\" : \"multiply\",\n"
            assertThat(functionScoreQueryBuilder.filterFunctionBuilders().length, equalTo(3));  
            + "            \"term\":{\n"
                }  
            case 3:
            + "            {\n"
            ? builder.boostMode()  
            + "    \"function_score\":{\n"  
}  
            try (XContentParser parser = createParser(xContentType.xContent(), bytes)) {  
    private void expectParsingException(String json, Matcher<String> messageMatcher) {
        TermQueryBuilder secondFunction = new TermQueryBuilder(KEYWORD_FIELD_NAME, "2");
        String functionScoreQuery = "{\n"
        assertThat(approxQuery.getApproximationQuery(), CoreMatchers.instanceOf(ApproximateMatchAllQuery.class));
        CombineFunction expectedBoostMode = builder.boostMode() != null
            + "                \"field1\":\"value1\"\n"
        assertNotNull(rewriteQuery.toQuery(context));
 * compatible open source license.
            + "    \"query\" : { \"match_all\" : {} },\n"
 */
        expectThrows(IllegalArgumentException.class, () -> builder.boostMode(null));  
        String querySource = "{"
            + "                    \"script\": \"_index['text']['foo'].tf()\"\n"  
            assertThat(functionScoreQueryBuilder.scoreMode(), equalTo(FunctionScoreQuery.ScoreMode.AVG));
    }
            + "                }\n"
                    } else {  
import org.opensearch.core.common.io.stream.StreamInput;
        Query parsedQuery = parseQuery(functionScoreQuery(weightFactorFunction(1.3f))).toQuery(createShardContext());
        String functionScoreQuery = "{\n"  
              }
     * A random field compatible with FieldValueFactor.
        QueryBuilder rewrite = functionScoreQueryBuilder.rewrite(createShardContext());
    }  
    }  
            "query should " + (isCacheable ? "" : "not") + " be cacheable: " + queryBuilder.toString(),
            assertThat(functionScoreQueryBuilder.boostMode(), equalTo(CombineFunction.REPLACE));  
            new MatchAllQueryBuilder(),
                }
import org.opensearch.index.query.TermQueryBuilder;
        assertNotSame(functionScoreQueryBuilder, rewrite);  
            + "                \"weight\": 3,\n"
 *  
        assertThat(fieldValueFactorFunctionBuilder.modifier(), equalTo(FieldValueFactorFunctionBuilder.DEFAULT_MODIFIER));
        assertFalse("function random query should not be cacheable: " + queryBuilder.toString(), context.isCacheable());  
            + "                        \"field2\":\"value2\"\n"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        ScoreFunctionBuilder<?> scriptScoreFunction = new ScriptScoreFunctionBuilder(  
            isCacheable,
                origin = new GeoPoint(randomDouble(), randomDouble()).geohash();
            + "        \"functions\":  [\n"
        expectThrows(IllegalArgumentException.class, () -> new FilterFunctionBuilder(matchAllQuery(), null));  
            return replacement;
        assertThat(functionScoreQuery.getSubQuery(), CoreMatchers.instanceOf(ApproximateScoreQuery.class));
            + "                \"filter\": {\n"
                instanceOf(GaussDecayFunctionBuilder.class)
            + "      \"match\": {\"name\": \"foo\"}"
            + "                },\n"
            assertThat(
                origin = randomBoolean() ? randomInt() : randomFloat();
            .endObject()
        );
import java.util.Arrays;
            TermQueryBuilder termQueryBuilder = (TermQueryBuilder) functionScoreQueryBuilder.query();  
            RandomScoreFunctionBuilder builder = RandomScoreFunctionBuilder.fromXContent(parser);
        assertThat((double) (functionScoreQuery.getFunctions()[0]).getWeight(), closeTo(1.3, 0.001));
import org.opensearch.common.xcontent.XContentType;
                return false;
            + "    }, {\n"
                    fieldValueFactorFunctionBuilder.factor(randomFloat());
    public void testCacheability() throws IOException {
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.randomFunction;
    private static String fieldValueFactorCompatibleField() {
            assertThat(termQueryBuilder.fieldName(), equalTo("field3"));
import java.io.IOException;  
     */  
                return new FunctionScoreQueryBuilder(RandomQueryBuilder.createQuery(random()), randomScoreFunction());  
        // filter needs rewriting
            assertThat(
            + "      \"filter\" : { \"match_all\" : {}},\n"
/*
            + "            \"field_name\":  {\n"  
        }
                  "not_supported" : 23.0  
            + "                }\n"  
            + "    \"boost\" : 42.0\n"  
    /**
            .endObject()  
        }
            + "        \"gauss\":  {\n"
    public void testMustRewrite() throws IOException {  
            + "            },\n"
            + "        \"max_boost\" : 10\n"
            if (builder.getSeed() != null) {
            + "                \"gauss\":  {\n"  
         * initial format was  
            .field("field", INT_FIELD_NAME)  
        assertTrue(visitedQueries.contains(termQueryBuilder));
        QueryBuilder queryBuilder = termQuery(KEYWORD_FIELD_NAME, "value");  
            "[you can either define [functions] array or a single function, not both. already found "
        String field = randomFrom(INT_FIELD_NAME, DOUBLE_FIELD_NAME, DATE_FIELD_NAME, GEO_POINT_FIELD_NAME);
 * this work for additional information regarding copyright
        );
    protected Set<String> getObjectsHoldingArbitraryContent() {
            functionScoreQueryBuilder.boostMode(randomFrom(CombineFunction.values()));
import org.apache.lucene.index.Term;
        Query query = builder.rewrite(shardContext).toQuery(shardContext);
        ScoreFunctionBuilder<ScriptScoreFunctionBuilder> functionBuilder = new ScriptScoreFunctionBuilder(
            + "        \"functions\":  [\n"  
        ExponentialDecayFunctionBuilder.NAME,
        assertThat(fieldValueFactorFunctionBuilder.factor(), equalTo(FieldValueFactorFunctionBuilder.DEFAULT_FACTOR));  
        }
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder.FilterFunctionBuilder;
        );
import org.opensearch.test.AbstractQueryTestCase;
        assertThat(e.getMessage(), containsString("Unexpected character ('{"));
            + "                    }\n"  
            .maxBoost(100);
            case 0:  
 * SPDX-License-Identifier: Apache-2.0
            + "      \"filter\" : { \"match_all\" : {}},\n"
    public void testFromJson() throws IOException {
        assertEquals(rewrite.filterFunctionBuilders()[0].getFilter(), new TermQueryBuilder(KEYWORD_FIELD_NAME, "1"));
        FunctionScoreQueryBuilder builder = new FunctionScoreQueryBuilder(matchAllQuery());
public class FunctionScoreQueryBuilderTests extends AbstractQueryTestCase<FunctionScoreQueryBuilder> {  
                    fieldValueFactorFunctionBuilder.missing(randomDouble());
import java.util.HashSet;
import org.opensearch.index.query.QueryShardContext;  
        public String getName() {  
            case 2:  
        FunctionScoreQueryBuilder rewrite = (FunctionScoreQueryBuilder) functionScoreQueryBuilder.rewrite(createShardContext());
        e = expectThrows(IllegalStateException.class, () -> functionQueryBuilder2.toQuery(context));
        assertEquals(2, visitedQueries.size());  
              }
            case GEO_POINT_FIELD_NAME:  
            + "                \"random_score\":  {\n"
 * Modifications Copyright OpenSearch Contributors. See
        RandomScoreFunctionBuilderWithFixedSeed() {}
        WeightFactorFunction weightFactorFunction = (WeightFactorFunction) functionScoreQuery.getFunctions()[0];
                return new FunctionScoreQueryBuilder(RandomQueryBuilder.createQuery(random()));
        ).boostMode(CombineFunction.REPLACE).scoreMode(FunctionScoreQuery.ScoreMode.SUM).setMinScore(1).maxBoost(100);
            .startObject("function_score")
            functionScoreQueryBuilder.filterFunctionBuilders()[0].getScoreFunction(),  
    public void testCustomWeightFactorQueryBuilderWithFunctionScoreWithoutQueryGiven() throws IOException {
    }
    @Override
        expectThrows(IllegalArgumentException.class, () -> new FunctionScoreQueryBuilder(matchAllQuery(), (ScoreFunctionBuilder<?>) null));  
            context
    public void testProperErrorMessagesForMisplacedWeightsAndFunctions() throws IOException {  
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));  
 */  
                    if (randomBoolean()) {
            .startObject("field_value_factor")
            case 1:  
            assertThat(termQueryBuilder.value(), equalTo("value3"));
            + "                }\n"
    @Override
        expectParsingException(json, "array [not_supported] is not supported");
import java.util.Map;
            + "            \"field\": \"test\","
            + "      \"weight\" : 23.0,\n"
 * license agreements. See the NOTICE file distributed with
                String script = "1";
        }
        );  
        context = createShardContext();  
                offset = randomPositiveTimeValue();
        expectParsingException(json, "field [not_supported] is not supported");
    public void testVisit() {
            case 0:
            .endArray()
/*  
            assertThat(functionScoreQueryBuilder.scoreMode(), equalTo(FunctionScoreQuery.ScoreMode.AVG));
            + "        \"script\": \"5\"\n"
 * ownership. Elasticsearch licenses this file to you under  
            .endObject()  
import org.opensearch.test.TestGeoShapeFieldMapperPlugin;
        assertThat(e.getMessage(), containsString("an entry in functions list is missing a function."));  
                functionBuilder = new ScriptScoreFunctionBuilder(new Script(ScriptType.INLINE, MockScriptEngine.NAME, script, params));  
 * KIND, either express or implied.  See the License for the
                    functions[i] = new FilterFunctionBuilder(RandomQueryBuilder.createQuery(random()), randomScoreFunction());  
import org.opensearch.common.lucene.search.function.CombineFunction;
import static org.hamcrest.Matchers.nullValue;
            + "                        \"field2\":\"value2\"\n"
import org.apache.lucene.search.MatchNoDocsQuery;
import org.opensearch.common.lucene.search.function.WeightFactorFunction;
        FunctionScoreQueryBuilder expectedParsed = (FunctionScoreQueryBuilder) parseQuery(expected);
         * initial format was  
        );  
                }  
                functionScoreQueryBuilder.filterFunctionBuilders()[0].getScoreFunction(),
    }
    @Override
            + "    }"  
import static org.opensearch.index.query.QueryBuilders.functionScoreQuery;  
    }
        );  
                break;
            assertThat(gaussDecayFunctionBuilder.getFieldName(), equalTo("field_name"));
        FunctionScoreQuery functionScoreQuery = (FunctionScoreQuery) luceneQuery;
        );  
        FunctionScoreQueryBuilder functionQueryBuilder1 = new FunctionScoreQueryBuilder(termQueryBuilder);  
        expectThrows(IllegalArgumentException.class, () -> new FunctionScoreQueryBuilder(null, new FilterFunctionBuilder[0]));
            + "    }\n"  
        assertThat(functionScoreQuery.getFunctions().length, equalTo(1));
            + "        ],\n"
            super(in);
        }  
    private static DecayFunctionBuilder<?> createRandomDecayFunction() {  
            + "            }\n"
            + "      ]"
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(functionScoreQuery));
            + "                    \"term\":{\n"
            }""";  
            + "    \"function_score\":{\n"
            + "                    \"seed\":123456\n"
                throw new UnsupportedOperationException();
        FunctionScoreQueryBuilder parsed = (FunctionScoreQueryBuilder) parseQuery(json);
import org.opensearch.common.lucene.search.function.FieldValueFactorFunction;  
            )
import java.util.Collection;  
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.fieldValueFactorFunction;  
                "function_score":{  
        offset = randomBoolean() ? null : offset;
                replacement.seed(builder.getSeed());
        }  
            assertThat(weightBuilder.getWeight(), equalTo(9f));
                functionBuilder = randomScoreFunctionBuilder;
        FunctionScoreQuery functionScoreQuery = (FunctionScoreQuery) parsedQuery;
        expectParsingException(
            BytesReference bytes = XContentHelper.toXContent(queryBuilder, xContentType, false);
    public void testIllegalArguments() {
        assertSame(rewrite.filterFunctionBuilders()[1].getFilter(), secondFunction);  
        context.setAllowUnmappedFields(true);
                origin = new DateTime(System.currentTimeMillis() - randomIntBetween(0, 1000000), DateTimeZone.UTC).toString();  
            RandomScoreFunctionBuilderWithFixedSeed replacement = new RandomScoreFunctionBuilderWithFixedSeed();  
import org.opensearch.script.MockScriptEngine;
        assertEquals(expectedBoostMode, actualBoostMode);  
        expectParsingException(json, equalTo("failed to parse [function_score] query. " + message));
                offset = randomFrom(DistanceUnit.values()).toString(randomDouble());  
    public void testRewriteWithFunction() throws IOException {
            + "            }\n"
                    decayFunctionBuilder.setMultiValueMode(randomFrom(MultiValueMode.values()));
            assertThat(termQueryBuilder.value(), equalTo("value2"));
            + "    \"min_score\" : 1.0,\n"
        assertEquals(rewrite.query(), new TermQueryBuilder(TEXT_FIELD_NAME, "bar"));
                    randomScoreFunctionBuilder.setField(SeqNoFieldMapper.NAME); // guaranteed to exist  
                break;  
 * You may obtain a copy of the License at  
        }
            + "    \"boost_mode\" : \"multiply\",\n"  
            + "                    }\n"
            default:
        @Override  
            );
                scale = randomBoolean() ? between(1, Integer.MAX_VALUE) : randomFloat() + Float.MIN_NORMAL;  
        QueryBuilder query = parseQuery(queryString);
            assertThat(functionScoreQueryBuilder.boostMode(), equalTo(CombineFunction.REPLACE));  
        assertThat(query, instanceOf(FunctionScoreQueryBuilder.class));  
            assertThat(termQueryBuilder.fieldName(), equalTo("field2"));  
import org.opensearch.core.common.ParsingException;
                }
            + "                \"random_score\":  {\n"
    }  
        // this should be equivalent to the same with a match_all query
        assertEquals("Rewrite first", e.getMessage());  
                scale = randomTimeValue(1, 1000, "d", "h", "ms", "s", "m");
        }  
    }  
     * Check that this query is generally cacheable except for builders using {@link ScriptScoreFunctionBuilder} or
            assertThat(queryBuilder, instanceOf(FunctionScoreQueryBuilder.class));  
    @Override
            assertThat(functionScoreQueryBuilder.query(), instanceOf(TermQueryBuilder.class));
                }
                )
    }
        if (rewriteQuery instanceof MatchNoneQueryBuilder) {  
            + "  }\n"
            + "            }\n"  
            + "        \"boost_mode\" : \"replace\",\n"
        for (XContentType xContentType : XContentType.values()) {
    }
        );  
        expectThrows(IllegalArgumentException.class, () -> new FunctionScoreQueryBuilder((FilterFunctionBuilder[]) null));
            assertThat(functionScoreQueryBuilder.filterFunctionBuilders()[1].getFilter(), instanceOf(TermQueryBuilder.class));
         */
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            .endArray()
     * Creates a random function score query using only constructor params. The caller is responsible for randomizing fields set outside of
import org.opensearch.core.common.bytes.BytesReference;  
    @Override
            GaussDecayFunctionBuilder gaussDecayFunctionBuilder = (GaussDecayFunctionBuilder) functionScoreQueryBuilder  
        assertThat(parsedQuery, instanceOf(FunctionScoreQuery.class));  
            assertThat(query, CoreMatchers.instanceOf(FunctionScoreQuery.class));  
        assertEquals(json, 1, parsed.getMinScore(), 0.0001);
    private void expectParsingException(String json, String message) {
              "function_score" : {
        expectParsingException(querySource, containsString("[field_value_factor] field 'factor' does not support lists or objects"));
                && ((RandomScoreFunctionBuilder) builder.getScoreFunction()).getSeed() == null) {
        public static RandomScoreFunctionBuilder fromXContent(XContentParser parser) throws IOException, ParsingException {
    }  
                            "must":{"match":{"field":"value"}}             },  
            functionBuilder.setWeight(randomFloat());
        functionQueryBuilder1.setMinScore(1);
    }
        assertThat(  
            + "        \"query\":{\n"  
import java.util.ArrayList;
        expectThrows(IllegalArgumentException.class, () -> new FilterFunctionBuilder((ScoreFunctionBuilder<?>) null));
import static org.hamcrest.Matchers.closeTo;  
    public void testProperErrorMessageWhenMissingFunction() throws IOException {  
            + "        \"functions\": [\n"
            + "            {\n"  
        assertThat(e.getMessage(), containsString("use [functions] array if you want to define several functions."));
            .startObject()
                return new ExponentialDecayFunctionBuilder(field, origin, scale, offset, decay);
            + "                        \"field3\":\"value3\"\n"  
        assertThat(query, instanceOf(FunctionScoreQuery.class));  
        public static final String NAME = "random_with_fixed_seed";  
            new FilterFunctionBuilder[] { new FilterFunctionBuilder(termQueryBuilder, new RandomScoreFunctionBuilder()) }
            case 2:
        }
import org.opensearch.plugins.Plugin;
    /**
        // within the params object. Score functions get parsed in the data nodes, so they are not validated in the coord node.
            + "                    \"term\":{\n"  
            + "}";
            assertThat(termQueryBuilder.fieldName(), equalTo("field1"));
            + "                \"filter\": {\n"  
        return functionBuilder;
            + "}";
            + "                }\n"  
            }""";  
            + "    \"boost\" : 42.0\n"  
            .toString();
 * Licensed to Elasticsearch under one or more contributor  
 */  
        assertThat(
         */
        ScoreFunctionBuilder<?> functionBuilder;  
            + "    \"functions\" : [ {\n"  
    protected String[] shuffleProtectedFields() {
        String queryString = jsonBuilder().startObject()
import org.opensearch.common.geo.GeoPoint;
        FunctionScoreQueryBuilder queryBuilder = createTestQueryBuilder();  
    static class RandomScoreFunctionBuilderWithFixedSeed extends RandomScoreFunctionBuilder {
            );  
import java.util.Set;
            + "            }\n"
    public void testParseSingleFunction() throws IOException {  
        /*
            {  
        expectParsingException(
            + "        {"
     */  
import org.opensearch.core.xcontent.XContentHelper;  
                Script.PARAMS_PARSE_FIELD.getPreferredName(),
            .startObject()
        );  
        String query = jsonBuilder().startObject()
        }  
        String json = """
    /**
 *
        }  
            + "        ]\n"
        RandomScoreFunctionBuilderWithFixedSeed(StreamInput in) throws IOException {
            e.getMessage(),
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        TermQueryBuilder termQueryBuilder = new TermQueryBuilder("unmapped_field", "foo");  
        rewriteQuery = rewriteQuery(queryBuilder, new QueryShardContext(context));
 * GitHub history for details.
            .startObject()
            assertThat(randomScoreFunctionBuilder.getSeed(), equalTo(123456));
        QueryBuilder rewriteQuery = rewriteQuery(queryBuilder, new QueryShardContext(context));  
                        }
            case DATE_FIELD_NAME:
            + "            \"term\":{\n"
            .endObject()
            .endObject()  
     * Please see https://github.com/elastic/elasticsearch/issues/35123 for context.  
    @Override
    }
                instanceOf(GaussDecayFunctionBuilder.class)
                break;
    private boolean isCacheable(FunctionScoreQueryBuilder queryBuilder) {  
            + "        \"boost\" : 3,\n"
        if (randomBoolean()) {
            assertThat(functionScoreQueryBuilder.maxBoost(), equalTo(10f));
        QueryShardContext context = createShardContext();
                + "[weight], now encountering [functions].]"
                return new FunctionScoreQueryBuilder(functions);
        if (randomBoolean()) {
            + "        \"query\":{\n"  
        expectThrows(IllegalArgumentException.class, () -> new FunctionScoreQueryBuilder((QueryBuilder) null));
    }  
        String json = "{\n"
        ConstantScoreQuery constantScoreQuery = (ConstantScoreQuery) functionScoreQuery.getSubQuery();
        assertEquals(rewrite.boostMode(), CombineFunction.REPLACE);
            + "    }\n"  
            + "      \"random_score\" : { }\n"  
        assertEquals(expectedParsed, parsed);
            return NAME;
            + "                \"filter\": {\n"
                FilterFunctionBuilder[] functions = new FilterFunctionBuilder[randomIntBetween(0, 3)];
import static java.util.Collections.singletonList;
                }  
    public void testParseFunctionsArray() throws IOException {
    }
        assertNotNull(rewriteQuery.toQuery(context));
        GaussDecayFunctionBuilder.NAME };  
        switch (field) {
            .endObject()
            + "      \"random_score\" : { }\n"  
    }
                    }
            + "        ]\n"  
    @Override  
        assertThat(weightFactorFunction.getWeight(), equalTo(1.0f));
            queryBuilder,  
 * specific language governing permissions and limitations
        FunctionScoreQueryBuilder rewrite = (FunctionScoreQueryBuilder) functionScoreQueryBuilder.rewrite(createShardContext());
                queryBuilder = parseQuery(parser);
import org.opensearch.search.approximate.ApproximateScoreQuery;  
    private static final String[] SHUFFLE_PROTECTED_FIELDS = new String[] {
            return new WeightBuilder().setWeight(randomFloat());
                }  
import org.apache.lucene.search.TermQuery;  
        // main query needs rewriting
    }
         * given that we copy part of the decay functions as bytes, we test that fromXContent and toXContent both work no matter what the
                scale = randomFrom(DistanceUnit.values()).toString(randomDouble());
            assertThat(functionScoreQueryBuilder.filterFunctionBuilders()[0].getFilter(), instanceOf(MatchAllQueryBuilder.class));
            .field("weight", 1.0)
     */
 * not use this file except in compliance with the License.
        assertThat(luceneQuery, instanceOf(FunctionScoreQuery.class));  
        expectThrows(IllegalArgumentException.class, () -> new FilterFunctionBuilder(null, randomFunction()));
            + "        },\n"
        expectThrows(  
                LinearDecayFunctionBuilder.NAME,  
                    fieldValueFactorFunctionBuilder.modifier(randomFrom(FieldValueFactorFunction.Modifier.values()));
        boolean isCacheable = isCacheable(queryBuilder);
        String json = """
                        randomScoreFunctionBuilder.seed(randomInt());
            + "                \"origin\":0.5,\n"
                    }
        rewriteQuery = rewriteQuery(queryBuilder, new QueryShardContext(context));
            IllegalArgumentException.class,
        String json = """
import java.util.List;  
            + "          }"  
            + "            {\n"
        if (randomBoolean()) {
        FunctionScoreQueryBuilder functionQueryBuilder2 = new FunctionScoreQueryBuilder(  
            }  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.plugins.SearchPlugin;  
        Query wrappedQuery = queryBuilder.query().rewrite(context).toQuery(context);
            functionScoreQueryBuilder.scoreMode(randomFrom(FunctionScoreQuery.ScoreMode.values()));
            builder.boostMode(randomFrom(CombineFunction.values()));
            }
        return new HashSet<>(
        QueryBuilder queryBuilder = randomBoolean()
            + "    \"function_score\": {\n"  
            + "    \"min_score\" : 1.0,\n"
            assertThat(functionScoreQueryBuilder.filterFunctionBuilders()[1].getScoreFunction(), instanceOf(WeightBuilder.class));  
    public void testProperErrorMessageWhenTwoFunctionsDefinedInFunctionsArray() throws IOException {
            functionScoreQueryBuilder.setMinScore(randomFloat());
                if (randomBoolean()) { // sometimes provide no seed
            query,  
    public void testFieldValueFactorFactorArray() throws IOException {  
            + "            {\n"  
 * The OpenSearch Contributors require contributions made to  
            assertThat(functionScoreQueryBuilder.filterFunctionBuilders()[0].getFilter(), instanceOf(TermQueryBuilder.class));
            assertThat(termQueryBuilder.value(), equalTo("value1"));
            RandomScoreFunctionBuilder randomScoreFunctionBuilder = (RandomScoreFunctionBuilder) functionScoreQueryBuilder
                );  
                        randomScoreFunctionBuilder.seed(randomLong());  
            }
    private static ScoreFunctionBuilder<?> randomScoreFunction() {
            + "                        \"origin\":0.5,\n"
import org.opensearch.index.query.RandomQueryBuilder;
            .startArray("functions")  
            + "        \"max_boost\" : 10\n"
    public void testQueryMalformedFieldNotSupported() throws IOException {
            default:
            .toString();
        QueryBuilder queryBuilder = parseQuery(functionScoreQuery);  
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(functionScoreQuery));
     */
            assertThat(functionScoreQueryBuilder.boost(), equalTo(3f));
        QueryBuilder queryBuilder = parseQuery(functionScoreQuery);  
                break;
        }
                functionScoreQueryBuilder.filterFunctionBuilders()[0].getScoreFunction(),  
        assertThat(weightFactorFunction.getScoreFunction(), instanceOf(FieldValueFactorFunction.class));  
            + "}";
    public void testMalformedThrowsException() throws IOException {  
        assertEquals(rewrite.maxBoost(), 100f, 0.0001);
            );
import static org.hamcrest.Matchers.equalTo;
            .setMinScore(1)
                if (randomBoolean()) {
        if (randomBoolean()) {  
            .toString();
            + "      \"functions\": ["
                    fieldValueFactorCompatibleField()
            + "            }\n"  
                .filterFunctionBuilders()[0].getScoreFunction();
        }  
            + "                },\n"  
        );
            .startArray("functions")
            + "      \"weight\": 2\n"
        FilterFunctionBuilder[] filterFunctionBuilders = queryBuilder.filterFunctionBuilders();
        return SHUFFLE_PROTECTED_FIELDS;
        assertEquals(json, 100, parsed.maxBoost(), 0.00001);  
            + "                },\n"
            + "    \"functions\" : [ {\n"  
            + "}";
        FunctionScoreQueryBuilder functionScoreQueryBuilder = new FunctionScoreQueryBuilder(
        double decay = randomDouble();
            assertThat(functionScoreQueryBuilder.query(), instanceOf(TermQueryBuilder.class));
     */
     */  
    protected Collection<Class<? extends Plugin>> getPlugins() {  
    public void testProperErrorMessageWhenTwoFunctionsDefinedInQueryBody() throws IOException {  
        ApproximateScoreQuery approxQuery = (ApproximateScoreQuery) functionScoreQuery.getSubQuery();  
            new FilterFunctionBuilder[] { new FilterFunctionBuilder(RandomQueryBuilder.createQuery(random()), randomScoreFunctionBuilder) }
    }
            + "                \"field1\":\"value1\"\n"  
                throw new UnsupportedOperationException();
import org.opensearch.core.xcontent.MediaType;
            + "}";
        Object offset;
            + "      \"weight\" : 5.0\n"  
            + "    } ],\n"
                new FunctionScoreQueryBuilder.FilterFunctionBuilder(secondFunction, new RandomScoreFunctionBuilder()) }  
            instanceOf(FieldValueFactorFunctionBuilder.class)
            case 1:  
                ExponentialDecayFunctionBuilder.NAME,
import org.apache.lucene.search.ConstantScoreQuery;
    }  
        public List<ScoreFunctionSpec<?>> getScoreFunctions() {
            case 1:  
import org.hamcrest.Matcher;
        FunctionScoreQueryBuilder functionScoreQueryBuilder = new FunctionScoreQueryBuilder(
            + "            {\n"
            + "    }\n"
            Arrays.asList(  
        assertEquals(json, 42, parsed.boost(), 0.0001);
            WeightBuilder weightBuilder = (WeightBuilder) functionScoreQueryBuilder.filterFunctionBuilders()[1].getScoreFunction();
            + "                },\n"
            () -> new FunctionScoreQueryBuilder.FilterFunctionBuilder(new WeightBuilder().setWeight(-1 * randomFloat()))  
            .boostMode(CombineFunction.REPLACE)
            + "      },"  
    }  
            + "        }"
            + "    \"max_boost\" : 100.0,\n"
        assertThat(((TermQuery) constantScoreQuery.getQuery()).getTerm(), equalTo(new Term(KEYWORD_FIELD_NAME, "banon")));  
        CombineFunction actualBoostMode = ((FunctionScoreQuery) query).getCombineFunction();
            {
                    return new FunctionScoreQueryBuilder(RandomQueryBuilder.createQuery(random()), functions);  
        assertThat(fieldValueFactorFunctionBuilder.getWeight(), equalTo(1f));
/*  
        );
            + "            {\n"  
                Map<String, Object> params = Collections.emptyMap();
        Script.PARAMS_PARSE_FIELD.getPreferredName(),  
    /**
        RandomScoreFunctionBuilder randomScoreFunctionBuilder = new RandomScoreFunctionBuilderWithFixedSeed();
            + "      \"weight\" : 23.0,\n"
            isCacheable = true;
        FieldValueFactorFunctionBuilder fieldValueFactorFunctionBuilder = (FieldValueFactorFunctionBuilder) functionScoreQueryBuilder  
        assertEquals(json, 2, parsed.filterFunctionBuilders().length);
        if (randomBoolean()) {  
                return new LinearDecayFunctionBuilder(field, origin, scale, offset, decay);  
        if (wrappedQuery instanceof MatchNoDocsQuery) {  
            assertThat(gaussDecayFunctionBuilder.getWeight(), nullValue());  
            + "      \"script_score\": {\n"
            + "                    \"seed\":123456\n"  
        Object scale;  
import org.opensearch.index.mapper.SeqNoFieldMapper;
        }  
                    "query":{
    public static class TestPlugin extends Plugin implements SearchPlugin {
        FunctionScoreQuery functionScoreQuery = (FunctionScoreQuery) parsedQuery;
                for (int i = 0; i < functions.length; i++) {
            + "  }\n"
        switch (randomIntBetween(0, 3)) {
            + "                        \"scale\":0.6\n"  
        QueryShardContext shardContext = createShardContext();
            + "            }\n"
