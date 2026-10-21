                    .build()
        super.setUp();
        assertThat(result, instanceOf(FunctionScoreQueryBuilder.class));
import org.opensearch.transport.grpc.proto.request.search.query.QueryBuilderProtoConverterRegistryImpl;
        // Create a decay function with the placement
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder().setGauss(decayFunction).setWeight(2.0f).build();
        // Verify the exponential decay function
            (org.opensearch.index.query.functionscore.ScriptScoreFunctionBuilder) filterFunction.getScoreFunction();
        // Create a function score query with only weight (no specific function)
        // Verify that functions were added
import org.opensearch.protobufs.RandomScoreFunctionSeed;
            instanceOf(org.opensearch.index.query.functionscore.RandomScoreFunctionBuilder.class)
        // Create a field value factor function
import org.opensearch.protobufs.FieldValueFactorModifier;
        assertEquals("rating", gaussFunction.getFieldName());
        FunctionScoreQueryBuilder builder2 = (FunctionScoreQueryBuilder) result2;
    public void testFromProtoWithDifferentScoreModes() {
        // Create a function score container with the exponential decay function
            .setBoostMode(FunctionBoostMode.FUNCTION_BOOST_MODE_AVG)
            .setSeed(RandomScoreFunctionSeed.newBuilder().setString("test_seed").build())
            .build();
            .setLang(
        // Test MIN score mode
        FunctionScoreQueryBuilder builder4 = (FunctionScoreQueryBuilder) result4;
        // Create a decay placement
        QueryBuilder result = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery, registry);
            .build();
    public void testFromProtoWithLinearDecayFunction() {
        // Verify that functions were added
            .setBoostMode(FunctionBoostMode.FUNCTION_BOOST_MODE_MAX)
        FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) result;
        assertEquals(org.opensearch.common.lucene.search.function.CombineFunction.MULTIPLY, functionScoreQueryBuilder.boostMode());
            .putPlacement("price", decayPlacement)
import org.opensearch.protobufs.FieldValue;
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder()
            .build();
            .addFunctions(container2)
        assertThat(result5, instanceOf(FunctionScoreQueryBuilder.class));
        FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) result;
    }
            () -> FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery, registry)
            .setField("popularity")
            .setFactor(1.2f)
        // Create an empty decay function (no placements)
            filterFunction.getScoreFunction(),
        org.opensearch.index.query.functionscore.ExponentialDecayFunctionBuilder expFunction =
        // This should default to MatchAllQueryBuilder (matching fromXContent behavior)
        FunctionScoreQueryBuilder.FilterFunctionBuilder filterFunction3 = functionScoreQueryBuilder.filterFunctionBuilders()[2];
    }
        assertEquals(org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode.SUM, functionScoreQueryBuilder.scoreMode());
 */
    public void testFromProtoWithEmptyQueryAndNoFunctions() {
    @Override
        assertThat(result, instanceOf(FunctionScoreQueryBuilder.class));
        assertNotNull(functionScoreQueryBuilder.filterFunctionBuilders());
            .setNumericDecayPlacement(numericPlacement)
            .build();
        FieldValueFactorScoreFunction fieldValueFactor = FieldValueFactorScoreFunction.newBuilder()
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
        assertEquals(org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode.MAX, builder5.scoreMode());
            // .setSeed(RandomScoreFunctionSeed.newBuilder().setInt32Value(123).build()) // Method not available in 0.16.0
        assertEquals("price", expFunction.getFieldName());
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder().addFunctions(container).build();
        FunctionScoreContainer container1 = FunctionScoreContainer.newBuilder()
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder().setScriptScore(scriptScoreFunction).setWeight(1.5f).build();
        assertThat(result2, instanceOf(FunctionScoreQueryBuilder.class));
import org.opensearch.index.query.QueryBuilder;
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder().addFunctions(container).build();
            .setScale(50.0)
        );
        assertThat(result1, instanceOf(FunctionScoreQueryBuilder.class));
        assertThat(exception.getMessage(), containsString("FunctionScoreQuery cannot be null"));
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder().addFunctions(container).build();
            .build();
        org.opensearch.protobufs.DecayPlacement decayPlacement = org.opensearch.protobufs.DecayPlacement.newBuilder()
        // Create a comprehensive function score query with all parameters
            .setField("_id")
            .setBoostMode(FunctionBoostMode.FUNCTION_BOOST_MODE_MULTIPLY)
        FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) result;
                org.opensearch.protobufs.ScriptLanguage.newBuilder()
            .setSource("Math.log(doc['popularity'].value) * params.multiplier")
        // Verify the second function (random score)
            .setOrigin(20.0)
        assertNotNull(functionScoreQueryBuilder.filterFunctionBuilders());
            (org.opensearch.index.query.functionscore.LinearDecayFunctionBuilder) filterFunction.getScoreFunction();
            .build();
            .build();
            .build();
        FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) result;
            .build();
    }
        assertEquals(org.opensearch.common.lucene.search.function.CombineFunction.MIN, builder6.boostMode());
        QueryBuilder result = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery, registry);
        assertEquals(2.0, openSearchScript.getParams().get("multiplier"));
        // Create a decay placement
            .build();
        assertNotNull(functionScoreQueryBuilder.filterFunctionBuilders());
        assertEquals(0, functionScoreQueryBuilder.filterFunctionBuilders().length);
        // Verify that all three functions were added
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder().addFunctions(container).build();
        FunctionScoreQuery functionScoreQuery4 = FunctionScoreQuery.newBuilder()
            .setScoreMode(FunctionScoreMode.FUNCTION_SCORE_MODE_AVG)
            .setValue(FieldValue.newBuilder().setString("test_value").build())
            .build();
        QueryBuilder result5 = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery5, registry);
        FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) result;
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder().setRandomScore(randomScore).setWeight(1.5f).build();
        // Create a function score query with neither query nor functions
        // Test REPLACE boost mode
            .setMinScore(0.5f)
            .setDecay(0.3)
        QueryBuilder result = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery, registry);
            .setMaxBoost(15.0f)
            .setValue(FieldValue.newBuilder().setString("search").build())
        IllegalArgumentException exception = expectThrows(
            .build();
        org.opensearch.protobufs.DecayFunction decayFunction = org.opensearch.protobufs.DecayFunction.newBuilder()
        // Test MAX boost mode
        org.opensearch.protobufs.DecayFunction decayFunction = org.opensearch.protobufs.DecayFunction.newBuilder()
            filterFunction3.getScoreFunction(),
        QueryBuilder result2 = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery2, registry);
        FunctionScoreQueryBuilder builder6 = (FunctionScoreQueryBuilder) result6;
        assertEquals("painless", openSearchScript.getLang());
        // Create a function score query with random_score function
            .setScale(5.0)
        FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) result;
        registry = new QueryBuilderProtoConverterRegistryImpl();
    public void testFromProtoWithGaussianDecayFunction() {
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder().addFunctions(container).build();
            filterFunction.getScoreFunction(),
        assertThat(filterFunction.getScoreFunction(), instanceOf(org.opensearch.index.query.functionscore.GaussDecayFunctionBuilder.class));
            .build();
        org.opensearch.protobufs.DecayPlacement decayPlacement = org.opensearch.protobufs.DecayPlacement.newBuilder()
            .build();
        // Create a function score query with field_value_factor function
            .setQuery(queryContainer)
            .setScript(script)
        FunctionScoreQueryBuilder builder3 = (FunctionScoreQueryBuilder) result3;
        assertThat(filterFunction.getFilter(), instanceOf(org.opensearch.index.query.TermQueryBuilder.class));
        FunctionScoreQueryBuilder.FilterFunctionBuilder filterFunction = functionScoreQueryBuilder.filterFunctionBuilders()[0];
        // Create a function score container with the linear decay function
import org.opensearch.protobufs.FunctionScoreContainer;
        QueryBuilder result6 = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery6, registry);
        FunctionScoreQueryBuilder builder1 = (FunctionScoreQueryBuilder) result1;
            .setNumericDecayPlacement(numericPlacement)
        org.opensearch.index.query.functionscore.ScriptScoreFunctionBuilder scriptFunction =
        QueryBuilder result = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery, registry);
        assertEquals(1, functionScoreQueryBuilder.filterFunctionBuilders().length);
    }
        assertThat(result, instanceOf(FunctionScoreQueryBuilder.class));
            .setField("popularity")
            .build();
        );
            .setDecay(0.2)
        assertThat(result5, instanceOf(FunctionScoreQueryBuilder.class));
        FunctionScoreQuery functionScoreQuery1 = FunctionScoreQuery.newBuilder()
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_LOG)
        // This should throw an exception because decay function has no placements
            .setFieldValueFactor(fieldValueFactor)
        // Create third function - exponential decay
        // Create a numeric decay placement
        assertEquals(3, functionScoreQueryBuilder.filterFunctionBuilders().length);
            .build();
        assertEquals(1, functionScoreQueryBuilder.filterFunctionBuilders().length);
        FunctionScoreQuery functionScoreQuery1 = FunctionScoreQuery.newBuilder()
        RandomScoreFunction randomScore = RandomScoreFunction.newBuilder()
        assertThat(result, instanceOf(FunctionScoreQueryBuilder.class));
        assertThat(result4, instanceOf(FunctionScoreQueryBuilder.class));
    }
        // Verify that functions were added
        // Verify the third function (exponential decay)
        FieldValueFactorScoreFunction fieldValueFactor = FieldValueFactorScoreFunction.newBuilder()
import org.opensearch.protobufs.RandomScoreFunction;
        assertEquals(2.0f, functionScoreQueryBuilder.boost(), 0.001f);
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder().addFunctions(container).build();
            filterFunction1.getScoreFunction(),
    public void testFromProtoWithScriptScoreFunction() {
            (org.opensearch.index.query.functionscore.GaussDecayFunctionBuilder) filterFunction.getScoreFunction();
            .build();
    public void testFromProtoWithBasicFunctionScoreQuery() {
            .putPlacement("distance", decayPlacement)
            .setField("rating")
            .addFunctions(container1)
        assertThat(exception.getMessage(), containsString("DecayFunction must have at least one placement"));
        org.opensearch.protobufs.DecayFunction decayFunction = org.opensearch.protobufs.DecayFunction.newBuilder().build();
        FunctionScoreQuery functionScoreQuery5 = FunctionScoreQuery.newBuilder()
            .setMissing(1.0f)
            filterFunction2.getScoreFunction(),
            .build();
        // Create a decay placement
                    .build()
        FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) result;
            .build();
        );
        RandomScoreFunction randomScore = RandomScoreFunction.newBuilder()
            .setField("popularity")
            .setFilter(queryContainer)
    private QueryBuilderProtoConverterRegistryImpl registry;
        org.opensearch.protobufs.NumericDecayPlacement numericPlacement = org.opensearch.protobufs.NumericDecayPlacement.newBuilder()
            .setBoostMode(FunctionBoostMode.FUNCTION_BOOST_MODE_MULTIPLY)
        // Verify the first function (field value factor)
        FunctionScoreQuery functionScoreQuery2 = FunctionScoreQuery.newBuilder()
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder()
            .setScoreMode(FunctionScoreMode.FUNCTION_SCORE_MODE_FIRST)
        org.opensearch.protobufs.InlineScript inlineScript = org.opensearch.protobufs.InlineScript.newBuilder()
        FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) result;
        FunctionScoreQueryBuilder builder3 = (FunctionScoreQueryBuilder) result3;
            .setBoostMode(FunctionBoostMode.FUNCTION_BOOST_MODE_MULTIPLY)
            .build();
        assertEquals(org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode.MIN, builder6.scoreMode());
        FunctionScoreContainer container2 = FunctionScoreContainer.newBuilder().setRandomScore(randomScore).setWeight(0.5f).build();
    }
    public void testFromProtoWithFieldValueFactorFunction() {
        IllegalArgumentException exception = expectThrows(
import org.opensearch.protobufs.FunctionScoreMode;
        org.opensearch.script.Script openSearchScript = scriptFunction.getScript();
        QueryBuilder result = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery, registry);
        // Verify that functions were added
        // Verify that functions were added
        QueryBuilder result3 = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery3, registry);
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder().addFunctions(container).build();
            instanceOf(org.opensearch.index.query.functionscore.ScriptScoreFunctionBuilder.class)
        // Test AVG score mode
        assertThat(result, instanceOf(FunctionScoreQueryBuilder.class));
            .build();
            .setParams(
}
            .setField("_id")
        assertEquals(0.1f, functionScoreQueryBuilder.getMinScore(), 0.001f);
            .setFieldValueFactor(fieldValueFactor)
        assertEquals(org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode.AVG, builder3.scoreMode());
    public void testFromProtoWithExponentialDecayFunction() {
        assertThat(functionScoreQueryBuilder.query(), instanceOf(MatchAllQueryBuilder.class));
import org.opensearch.index.query.MatchAllQueryBuilder;
        assertThat(result4, instanceOf(FunctionScoreQueryBuilder.class));
        assertEquals(org.opensearch.common.lucene.search.function.CombineFunction.AVG, builder4.boostMode());
        QueryBuilder result = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery, registry);
        QueryBuilder result4 = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery4, registry);
            .setBoostMode(FunctionBoostMode.FUNCTION_BOOST_MODE_REPLACE)
        FieldValueFactorScoreFunction fieldValueFactor = FieldValueFactorScoreFunction.newBuilder()
    public void setUp() throws Exception {
            .putPlacement("rating", decayPlacement)
        assertEquals(10.0f, functionScoreQueryBuilder.maxBoost(), 0.001f);
        // Test FIRST score mode
 *
 * this file be licensed under the Apache-2.0 license or a
    }
        assertEquals("distance", linearFunction.getFieldName());
            .setBoostMode(FunctionBoostMode.FUNCTION_BOOST_MODE_SUM)
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_LOG)
import org.opensearch.protobufs.FieldValueFactorScoreFunction;
        assertThat(result, instanceOf(FunctionScoreQueryBuilder.class));
            .putPlacement("price", decayPlacement)
            instanceOf(org.opensearch.index.query.functionscore.LinearDecayFunctionBuilder.class)
        assertEquals(org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode.FIRST, builder4.scoreMode());
            .build();
        // Verify all parameters
        // Test MULTIPLY boost mode
    }
            .build();
        assertNotNull(functionScoreQueryBuilder.filterFunctionBuilders());
            .setFactor(1.5f)
        assertThat(result, instanceOf(FunctionScoreQueryBuilder.class));
        assertThat(result, instanceOf(FunctionScoreQueryBuilder.class));
        assertNotNull(filterFunction.getFilter());
        // Create a term query for the filter
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder().addFunctions(container).build();
            .build();
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder().build();
        // Create a function score container with the gaussian decay function
        FunctionScoreQueryBuilder builder4 = (FunctionScoreQueryBuilder) result4;
        assertThat(
        RandomScoreFunction randomScore = RandomScoreFunction.newBuilder()
        FunctionScoreQueryBuilder.FilterFunctionBuilder filterFunction = functionScoreQueryBuilder.filterFunctionBuilders()[0];
/*
                    .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)
        QueryBuilder result = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery, registry);
    public void testFromProtoWithEmptyDecayFunction() {
        QueryBuilder result3 = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery3, registry);
        assertThat(result, instanceOf(FunctionScoreQueryBuilder.class));
        assertThat(result, instanceOf(FunctionScoreQueryBuilder.class));
        assertEquals(org.opensearch.common.lucene.search.function.CombineFunction.REPLACE, builder2.boostMode());
        FunctionScoreContainer container3 = FunctionScoreContainer.newBuilder().setExp(decayFunction).setWeight(1.5f).build();
        assertThat(result2, instanceOf(FunctionScoreQueryBuilder.class));
        org.opensearch.protobufs.ScriptScoreFunction scriptScoreFunction = org.opensearch.protobufs.ScriptScoreFunction.newBuilder()
    public void testFromProtoWithAllParameters() {
        assertThat(
            .build();
        org.opensearch.protobufs.NumericDecayPlacement numericPlacement = org.opensearch.protobufs.NumericDecayPlacement.newBuilder()
            .setFieldValueFactor(fieldValueFactor)
            .build();
            .setOrigin(15.0)
            .build();
        // Verify functions
    }
        assertEquals("Math.log(doc['popularity'].value) * params.multiplier", openSearchScript.getIdOrCode());
            .setNumericDecayPlacement(numericPlacement)
            instanceOf(org.opensearch.index.query.functionscore.ExponentialDecayFunctionBuilder.class)
        assertEquals(1, functionScoreQueryBuilder.filterFunctionBuilders().length);
        QueryBuilder result1 = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery1, registry);
        FunctionScoreQuery functionScoreQuery3 = FunctionScoreQuery.newBuilder()
            .build();
        assertEquals(0.5f, functionScoreQueryBuilder.getMinScore(), 0.001f);
        FunctionScoreQueryBuilder.FilterFunctionBuilder filterFunction1 = functionScoreQueryBuilder.filterFunctionBuilders()[0];
        assertEquals(1, functionScoreQueryBuilder.filterFunctionBuilders().length);
        FunctionScoreQueryBuilder.FilterFunctionBuilder filterFunction = functionScoreQueryBuilder.filterFunctionBuilders()[0];
        assertThat(
            .setScoreMode(FunctionScoreMode.FUNCTION_SCORE_MODE_MULTIPLY)
        assertNotNull(functionScoreQueryBuilder.filterFunctionBuilders());
            (org.opensearch.index.query.functionscore.ExponentialDecayFunctionBuilder) filterFunction.getScoreFunction();
        org.opensearch.index.query.functionscore.LinearDecayFunctionBuilder linearFunction =
            () -> FunctionScoreQueryBuilderProtoUtils.fromProto(null, registry)
    public void testFromProtoWithMultipleFunctions() {
        assertEquals(org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode.SUM, builder2.scoreMode());
            .setSeed(RandomScoreFunctionSeed.newBuilder().setInt32(42).build())
import org.opensearch.test.OpenSearchTestCase;
            .build();
        // Create a decay function with the placement
        FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) result;
        assertEquals(1, functionScoreQueryBuilder.filterFunctionBuilders().length);
            .setScale(10.0)
        assertThat(result6, instanceOf(FunctionScoreQueryBuilder.class));
        org.opensearch.protobufs.NumericDecayPlacement numericPlacement = org.opensearch.protobufs.NumericDecayPlacement.newBuilder()
        );
        // Verify the script score function
        QueryBuilder result5 = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery5, registry);
        FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) result;
        FunctionScoreQuery functionScoreQuery6 = FunctionScoreQuery.newBuilder()
            .addFunctions(container2)
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;
            .setNumericDecayPlacement(numericPlacement)
import org.opensearch.protobufs.TermQuery;
        // Create an inline script
            .setDecay(0.3)
            .setOrigin(10.0)
            .build();
        assertEquals(org.opensearch.common.lucene.search.function.CombineFunction.SUM, builder3.boostMode());
        assertEquals(1, functionScoreQueryBuilder.filterFunctionBuilders().length);
        );
        QueryBuilder result2 = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery2, registry);
        // Initialize the registry for FunctionScoreQueryBuilderProtoUtils
            .setField("title")
        FunctionScoreQueryBuilder builder6 = (FunctionScoreQueryBuilder) result6;
        assertThat(
        FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) result;
        assertEquals(15.0f, functionScoreQueryBuilder.maxBoost(), 0.001f);
            IllegalArgumentException.class,
import org.opensearch.protobufs.FunctionBoostMode;
            .setField("_id")
            .setField("category")
        assertEquals(org.opensearch.script.ScriptType.INLINE, openSearchScript.getType());
        FunctionScoreQueryBuilder.FilterFunctionBuilder filterFunction2 = functionScoreQueryBuilder.filterFunctionBuilders()[1];
            instanceOf(org.opensearch.index.query.functionscore.ExponentialDecayFunctionBuilder.class)
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_SQRT)
        // Create a basic function score query with a term query
        FunctionScoreContainer container2 = FunctionScoreContainer.newBuilder().setRandomScore(randomScore).setWeight(1.0f).build();
    public void testFromProtoWithRandomScoreFunction() {
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder()
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
            .setDecay(0.4)
        // Test SUM score mode
        org.opensearch.protobufs.DecayFunction decayFunction = org.opensearch.protobufs.DecayFunction.newBuilder()
        assertEquals(org.opensearch.common.lucene.search.function.CombineFunction.MAX, builder5.boostMode());
            .build();
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder().setExp(decayFunction).setWeight(1.5f).build();
            .setScoreMode(FunctionScoreMode.FUNCTION_SCORE_MODE_MULTIPLY)
        QueryBuilder result = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery, registry);
            .setScoreMode(FunctionScoreMode.FUNCTION_SCORE_MODE_SUM)
        // Test MAX score mode
        assertEquals(org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode.MULTIPLY, builder1.scoreMode());
    public void testFromProtoWithFunctionAndFilter() {
        assertThat(result6, instanceOf(FunctionScoreQueryBuilder.class));
            .build();
    }
        // Verify that functions were added
        // Should have no functions
        FunctionScoreQuery functionScoreQuery3 = FunctionScoreQuery.newBuilder()
        );
        QueryBuilder result = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery, registry);
        // Create second function - random score
    public void testFromProtoWithWeightOnlyFunction() {
    }
        assertEquals(1, functionScoreQueryBuilder.filterFunctionBuilders().length);
        assertThat(result, instanceOf(FunctionScoreQueryBuilder.class));
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder().setWeight(3.0f).build();
            .build();
            .setOrigin(100.0)
            .setScoreMode(FunctionScoreMode.FUNCTION_SCORE_MODE_SUM)
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
            instanceOf(org.opensearch.index.query.functionscore.FieldValueFactorFunctionBuilder.class)
        assertThat(result1, instanceOf(FunctionScoreQueryBuilder.class));
            .setMaxBoost(10.0f)
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder().setExp(decayFunction).setWeight(1.0f).build();
        assertNotNull(functionScoreQueryBuilder.filterFunctionBuilders());
    }
    }
            .build();
        // Verify the linear decay function
        FunctionScoreQueryBuilder builder5 = (FunctionScoreQueryBuilder) result5;
        assertEquals(2, functionScoreQueryBuilder.filterFunctionBuilders().length);
    }
        FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) result;
            .build();
        // Create first function - field value factor
        QueryBuilder result = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery, registry);
            .build();
        // Verify the field name
            .setWeight(1.5f)
import static org.hamcrest.Matchers.containsString;
            .setFactor(2.0f)
        org.opensearch.protobufs.DecayPlacement decayPlacement = org.opensearch.protobufs.DecayPlacement.newBuilder()
        org.opensearch.protobufs.DecayPlacement decayPlacement = org.opensearch.protobufs.DecayPlacement.newBuilder()
        // Test AVG boost mode
        QueryBuilder result4 = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery4, registry);
        assertThat(result, instanceOf(FunctionScoreQueryBuilder.class));
        // Create a decay function with the placement
        FunctionScoreQueryBuilder builder1 = (FunctionScoreQueryBuilder) result1;
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_LOG)
        TermQuery termQuery = TermQuery.newBuilder()
            .setOffset(5.0)
import org.opensearch.protobufs.QueryContainer;
            .setBoost(2.0f)
            .build();
        // Verify the function has a filter
    public void testFromProtoWithDifferentBoostModes() {
                org.opensearch.protobufs.ObjectMap.newBuilder()
        FieldValueFactorScoreFunction fieldValueFactor = FieldValueFactorScoreFunction.newBuilder()
        assertEquals(1, functionScoreQueryBuilder.filterFunctionBuilders().length);
        // Create a function score container with both function and filter
        assertThat(functionScoreQueryBuilder.query(), instanceOf(org.opensearch.index.query.TermQueryBuilder.class));
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder()
        // Verify the gaussian decay function
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder()
package org.opensearch.transport.grpc.proto.request.search.query.functionscore;
        // Create a numeric decay placement
            .build();
        );
        // Test SUM boost mode
        FunctionScoreQueryBuilder builder5 = (FunctionScoreQueryBuilder) result5;
        // Verify the field name
            .addFunctions(container1)
import static org.hamcrest.Matchers.instanceOf;
        );
        FunctionScoreQueryBuilder.FilterFunctionBuilder filterFunction = functionScoreQueryBuilder.filterFunctionBuilders()[0];
    }
            .setBoostMode(FunctionBoostMode.FUNCTION_BOOST_MODE_MIN)
    public void testFromProtoWithNullInput() {
        QueryBuilder result6 = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery6, registry);
            .setScoreMode(FunctionScoreMode.FUNCTION_SCORE_MODE_MAX)
        // Verify script properties
            )
        QueryBuilder result = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery, registry);
        FunctionScoreQuery functionScoreQuery4 = FunctionScoreQuery.newBuilder()
        assertThat(
        // Verify the field name
        org.opensearch.protobufs.DecayFunction decayFunction = org.opensearch.protobufs.DecayFunction.newBuilder()
        // Create multiple functions
        // Test MIN boost mode
        assertNotNull(functionScoreQueryBuilder.filterFunctionBuilders());
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder().addFunctions(container).build();
    }
        assertNotNull(functionScoreQueryBuilder.filterFunctionBuilders());
        assertNotNull(functionScoreQueryBuilder.filterFunctionBuilders());
            )
        assertThat(result3, instanceOf(FunctionScoreQueryBuilder.class));
            .build();
        // Verify that functions were added
        // Should have a MatchAllQueryBuilder as the base query
 * SPDX-License-Identifier: Apache-2.0
            .setWeight(2.0f)
 * compatible open source license.
        FunctionScoreContainer container1 = FunctionScoreContainer.newBuilder()
        // Create a numeric decay placement
        // Verify that functions were added
            .setWeight(2.0f)
    }
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder().setLinear(decayFunction).setWeight(1.0f).build();
        FunctionScoreQuery functionScoreQuery5 = FunctionScoreQuery.newBuilder()
            .setValue(FieldValue.newBuilder().setString("electronics").build())
        FunctionScoreQueryBuilder.FilterFunctionBuilder filterFunction = functionScoreQueryBuilder.filterFunctionBuilders()[0];
            .setField("test_field")
            .setScoreMode(FunctionScoreMode.FUNCTION_SCORE_MODE_MIN)
            .setWeight(2.0f)
        assertThat(result3, instanceOf(FunctionScoreQueryBuilder.class));
        FunctionScoreQueryBuilder builder2 = (FunctionScoreQueryBuilder) result2;
        QueryBuilder result1 = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery1, registry);
public class FunctionScoreQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
            .build();
            .setScale(8.0)
            .setOffset(1.0)
            .setQuery(queryContainer)
        FunctionScoreQuery functionScoreQuery6 = FunctionScoreQuery.newBuilder()
        assertEquals(org.opensearch.common.lucene.search.function.CombineFunction.MULTIPLY, builder1.boostMode());
        QueryBuilder result = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery, registry);
import org.opensearch.protobufs.FunctionScoreQuery;
            .addFunctions(container3)
        // Test MULTIPLY score mode
                    .putFields("multiplier", org.opensearch.protobufs.ObjectMap.Value.newBuilder().setDouble(2.0).build())
            .build();
            .setMinScore(0.1f)
        org.opensearch.protobufs.Script script = org.opensearch.protobufs.Script.newBuilder().setInline(inlineScript).build();
        TermQuery termQuery = TermQuery.newBuilder()
            .build();
        org.opensearch.protobufs.NumericDecayPlacement numericPlacement = org.opensearch.protobufs.NumericDecayPlacement.newBuilder()
            IllegalArgumentException.class,
        TermQuery termQuery = TermQuery.newBuilder()
        org.opensearch.index.query.functionscore.GaussDecayFunctionBuilder gaussFunction =
 * The OpenSearch Contributors require contributions made to
            filterFunction.getScoreFunction(),
        assertNotNull(functionScoreQueryBuilder.filterFunctionBuilders());
        FunctionScoreQuery functionScoreQuery2 = FunctionScoreQuery.newBuilder()
        assertThat(
            .setFieldValueFactor(fieldValueFactor)
            .build();
            .setMissing(1.0f)
            .setOffset(2.0)
            .setFactor(1.2f)
