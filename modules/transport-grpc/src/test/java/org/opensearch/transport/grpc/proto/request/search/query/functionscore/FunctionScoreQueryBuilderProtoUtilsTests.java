/*  
        assertThat(result, instanceOf(FunctionScoreQueryBuilder.class));  
            .build();
        TermQuery termQuery = TermQuery.newBuilder()
        QueryBuilder result = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery, registry);  
        org.opensearch.protobufs.DecayPlacement decayPlacement = org.opensearch.protobufs.DecayPlacement.newBuilder()
        assertThat(functionScoreQueryBuilder.query(), instanceOf(org.opensearch.index.query.TermQueryBuilder.class));  
    }
        assertThat(functionScoreQueryBuilder.query(), instanceOf(MatchAllQueryBuilder.class));
            .setScript(script)  
import org.opensearch.protobufs.TermQuery;
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder().addFunctions(container).build();  
        FunctionScoreQueryBuilder builder3 = (FunctionScoreQueryBuilder) result3;
        // Verify that all three functions were added
            .setField("_id")  
        QueryBuilder result = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery, registry);
            .setField("rating")
            .build();
            instanceOf(org.opensearch.index.query.functionscore.FieldValueFactorFunctionBuilder.class)
        assertNotNull(functionScoreQueryBuilder.filterFunctionBuilders());
        // Verify the first function (field value factor)  
        // Create a numeric decay placement
        // Create a function score container with the linear decay function  
            .build();
    }  
            .setNumericDecayPlacement(numericPlacement)  
        assertThat(result, instanceOf(FunctionScoreQueryBuilder.class));
        assertEquals(1, functionScoreQueryBuilder.filterFunctionBuilders().length);
        );
            .build();
            .setDecay(0.4)  
            .build();
        // Create a field value factor function
        // Should have no functions  
        IllegalArgumentException exception = expectThrows(
        assertEquals(org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode.AVG, builder3.scoreMode());
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;  
        FunctionScoreQueryBuilder.FilterFunctionBuilder filterFunction = functionScoreQueryBuilder.filterFunctionBuilders()[0];
        assertEquals(org.opensearch.common.lucene.search.function.CombineFunction.MULTIPLY, functionScoreQueryBuilder.boostMode());
        assertEquals(org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode.MAX, builder5.scoreMode());
            .setSeed(RandomScoreFunctionSeed.newBuilder().setInt32(42).build())
        QueryBuilder result5 = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery5, registry);
import static org.hamcrest.Matchers.containsString;  
        // Create a decay function with the placement  
        // Create third function - exponential decay
            .setWeight(2.0f)  
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_LOG)  
            .build();
            filterFunction2.getScoreFunction(),
        QueryBuilder result = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery, registry);  
            .setOffset(5.0)
        assertEquals(0.5f, functionScoreQueryBuilder.getMinScore(), 0.001f);
        assertNotNull(functionScoreQueryBuilder.filterFunctionBuilders());
    }
            .setBoost(2.0f)
        assertThat(exception.getMessage(), containsString("DecayFunction must have at least one placement"));
        assertThat(result4, instanceOf(FunctionScoreQueryBuilder.class));
        QueryBuilder result4 = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery4, registry);
            .setScale(8.0)
            .setField("category")
            .setFactor(1.5f)
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder().addFunctions(container).build();
        assertEquals(org.opensearch.common.lucene.search.function.CombineFunction.MIN, builder6.boostMode());  
        org.opensearch.protobufs.DecayPlacement decayPlacement = org.opensearch.protobufs.DecayPlacement.newBuilder()  
        // Create multiple functions
        org.opensearch.index.query.functionscore.ExponentialDecayFunctionBuilder expFunction =
import org.opensearch.protobufs.FieldValue;
        // Verify the field name
        FunctionScoreQuery functionScoreQuery3 = FunctionScoreQuery.newBuilder()
            .build();  
        QueryBuilder result3 = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery3, registry);  
            .setWeight(2.0f)  
    public void testFromProtoWithAllParameters() {
        assertEquals("price", expFunction.getFieldName());  
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder().build();  
    }
        FunctionScoreQuery functionScoreQuery1 = FunctionScoreQuery.newBuilder()
        FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) result;
            .setFactor(2.0f)
            .build();  
        FunctionScoreContainer container3 = FunctionScoreContainer.newBuilder().setExp(decayFunction).setWeight(1.5f).build();
            .setOffset(2.0)
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder().setGauss(decayFunction).setWeight(2.0f).build();
    public void testFromProtoWithScriptScoreFunction() {
        assertEquals(org.opensearch.common.lucene.search.function.CombineFunction.SUM, builder3.boostMode());  
        assertEquals(org.opensearch.common.lucene.search.function.CombineFunction.REPLACE, builder2.boostMode());
        assertNotNull(functionScoreQueryBuilder.filterFunctionBuilders());
        QueryBuilder result3 = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery3, registry);
            .build();
            .setFactor(1.2f)
            .setFieldValueFactor(fieldValueFactor)
        FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) result;  
        // Create a decay placement
        assertEquals(2.0, openSearchScript.getParams().get("multiplier"));
            .setField("popularity")
        // Create a function score query with field_value_factor function
import org.opensearch.protobufs.RandomScoreFunction;  
            )  
import org.opensearch.transport.grpc.proto.request.search.query.QueryBuilderProtoConverterRegistryImpl;
        org.opensearch.protobufs.NumericDecayPlacement numericPlacement = org.opensearch.protobufs.NumericDecayPlacement.newBuilder()  
        // Test MULTIPLY score mode
            instanceOf(org.opensearch.index.query.functionscore.ExponentialDecayFunctionBuilder.class)
        assertThat(
 */  
        org.opensearch.protobufs.DecayPlacement decayPlacement = org.opensearch.protobufs.DecayPlacement.newBuilder()
        // Verify that functions were added  
        FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) result;
        org.opensearch.index.query.functionscore.GaussDecayFunctionBuilder gaussFunction =
        FunctionScoreQuery functionScoreQuery3 = FunctionScoreQuery.newBuilder()
        FunctionScoreContainer container1 = FunctionScoreContainer.newBuilder()  
            .setField("_id")
        QueryBuilder result = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery, registry);
    public void testFromProtoWithLinearDecayFunction() {
        );  
        FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) result;
        assertThat(result6, instanceOf(FunctionScoreQueryBuilder.class));  
        org.opensearch.protobufs.InlineScript inlineScript = org.opensearch.protobufs.InlineScript.newBuilder()
        // Verify the gaussian decay function  
            .build();
        org.opensearch.protobufs.DecayFunction decayFunction = org.opensearch.protobufs.DecayFunction.newBuilder().build();
    }  
        FunctionScoreQueryBuilder builder6 = (FunctionScoreQueryBuilder) result6;
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder()
        FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) result;
            .setField("popularity")
        QueryBuilder result1 = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery1, registry);  
        FunctionScoreQueryBuilder.FilterFunctionBuilder filterFunction = functionScoreQueryBuilder.filterFunctionBuilders()[0];
        FieldValueFactorScoreFunction fieldValueFactor = FieldValueFactorScoreFunction.newBuilder()  
        org.opensearch.protobufs.DecayFunction decayFunction = org.opensearch.protobufs.DecayFunction.newBuilder()
            .setScoreMode(FunctionScoreMode.FUNCTION_SCORE_MODE_MIN)
            .build();
        assertThat(exception.getMessage(), containsString("FunctionScoreQuery cannot be null"));  
            .setScoreMode(FunctionScoreMode.FUNCTION_SCORE_MODE_AVG)
            .addFunctions(container1)
        QueryBuilder result = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery, registry);  
        FunctionScoreQuery functionScoreQuery2 = FunctionScoreQuery.newBuilder()
            .setWeight(1.5f)
            .build();  
            .setField("test_field")
        assertThat(result3, instanceOf(FunctionScoreQueryBuilder.class));  
        // Create a numeric decay placement
        assertThat(result2, instanceOf(FunctionScoreQueryBuilder.class));
            .setDecay(0.2)
        TermQuery termQuery = TermQuery.newBuilder()
        QueryBuilder result2 = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery2, registry);
            .build();  
        // Create a basic function score query with a term query  
        assertThat(result3, instanceOf(FunctionScoreQueryBuilder.class));
        assertEquals(org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode.MULTIPLY, builder1.scoreMode());  
        // Create a function score container with the exponential decay function
        assertEquals(0, functionScoreQueryBuilder.filterFunctionBuilders().length);
        );
            filterFunction.getScoreFunction(),
import static org.hamcrest.Matchers.instanceOf;
            .setFactor(1.2f)
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();  
    public void testFromProtoWithWeightOnlyFunction() {
            .build();
        FunctionScoreContainer container2 = FunctionScoreContainer.newBuilder().setRandomScore(randomScore).setWeight(1.0f).build();
            .setLang(  
    public void testFromProtoWithExponentialDecayFunction() {
            .setValue(FieldValue.newBuilder().setString("test_value").build())  
            instanceOf(org.opensearch.index.query.functionscore.ScriptScoreFunctionBuilder.class)
        );  
            instanceOf(org.opensearch.index.query.functionscore.LinearDecayFunctionBuilder.class)  
import org.opensearch.test.OpenSearchTestCase;  
        QueryBuilder result4 = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery4, registry);  
            .build();  
        org.opensearch.protobufs.NumericDecayPlacement numericPlacement = org.opensearch.protobufs.NumericDecayPlacement.newBuilder()
        assertEquals(1, functionScoreQueryBuilder.filterFunctionBuilders().length);  
            () -> FunctionScoreQueryBuilderProtoUtils.fromProto(null, registry)  
                    .putFields("multiplier", org.opensearch.protobufs.ObjectMap.Value.newBuilder().setDouble(2.0).build())
            .build();  
        assertNotNull(functionScoreQueryBuilder.filterFunctionBuilders());  
        QueryBuilder result = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery, registry);
    public void testFromProtoWithDifferentBoostModes() {
            .setScale(10.0)
        assertThat(result6, instanceOf(FunctionScoreQueryBuilder.class));
        // Create a function score container with both function and filter  
        assertThat(filterFunction.getFilter(), instanceOf(org.opensearch.index.query.TermQueryBuilder.class));  
        FunctionScoreQueryBuilder builder2 = (FunctionScoreQueryBuilder) result2;  
        assertThat(result5, instanceOf(FunctionScoreQueryBuilder.class));
        // Create a decay function with the placement
            .setOrigin(100.0)
        assertThat(result1, instanceOf(FunctionScoreQueryBuilder.class));
            .setWeight(2.0f)
            .build();
        RandomScoreFunction randomScore = RandomScoreFunction.newBuilder()  
            .setFilter(queryContainer)  
        QueryBuilder result6 = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery6, registry);  
            .setOrigin(10.0)
            .setFieldValueFactor(fieldValueFactor)
        FunctionScoreQuery functionScoreQuery4 = FunctionScoreQuery.newBuilder()
            filterFunction.getScoreFunction(),
import org.opensearch.protobufs.FunctionBoostMode;
            .build();
        FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) result;
        // Verify the function has a filter  
        QueryBuilder result = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery, registry);
            (org.opensearch.index.query.functionscore.ScriptScoreFunctionBuilder) filterFunction.getScoreFunction();  
            // .setSeed(RandomScoreFunctionSeed.newBuilder().setInt32Value(123).build()) // Method not available in 0.16.0
        assertNotNull(functionScoreQueryBuilder.filterFunctionBuilders());  
            .setOrigin(15.0)  
        QueryBuilder result = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery, registry);
    }
        QueryBuilder result1 = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery1, registry);
        assertThat(
        org.opensearch.protobufs.ScriptScoreFunction scriptScoreFunction = org.opensearch.protobufs.ScriptScoreFunction.newBuilder()
            .setScoreMode(FunctionScoreMode.FUNCTION_SCORE_MODE_MULTIPLY)  
import org.opensearch.protobufs.RandomScoreFunctionSeed;
            IllegalArgumentException.class,
        // Test SUM boost mode
                    .build()  
    }  
        org.opensearch.protobufs.NumericDecayPlacement numericPlacement = org.opensearch.protobufs.NumericDecayPlacement.newBuilder()
                    .build()
        assertNotNull(functionScoreQueryBuilder.filterFunctionBuilders());
            .setDecay(0.3)
        // Verify all parameters
    public void testFromProtoWithEmptyQueryAndNoFunctions() {  
        // This should default to MatchAllQueryBuilder (matching fromXContent behavior)
            .setBoostMode(FunctionBoostMode.FUNCTION_BOOST_MODE_MULTIPLY)
    }
            .setMissing(1.0f)  
        FunctionScoreQueryBuilder.FilterFunctionBuilder filterFunction = functionScoreQueryBuilder.filterFunctionBuilders()[0];
        assertEquals(1, functionScoreQueryBuilder.filterFunctionBuilders().length);
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();  
        // Test MULTIPLY boost mode
    @Override
        FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) result;
            IllegalArgumentException.class,
        FunctionScoreQuery functionScoreQuery5 = FunctionScoreQuery.newBuilder()  
            .build();
 * The OpenSearch Contributors require contributions made to  
            .build();
        FunctionScoreQueryBuilder builder3 = (FunctionScoreQueryBuilder) result3;
        // Verify that functions were added
        QueryBuilder result5 = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery5, registry);
    private QueryBuilderProtoConverterRegistryImpl registry;
    public void testFromProtoWithNullInput() {  
            (org.opensearch.index.query.functionscore.ExponentialDecayFunctionBuilder) filterFunction.getScoreFunction();  
        // Verify script properties
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder()  
        org.opensearch.protobufs.DecayPlacement decayPlacement = org.opensearch.protobufs.DecayPlacement.newBuilder()
        org.opensearch.protobufs.DecayFunction decayFunction = org.opensearch.protobufs.DecayFunction.newBuilder()
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder().setRandomScore(randomScore).setWeight(1.5f).build();
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder().addFunctions(container).build();
            .build();  
        assertEquals(3, functionScoreQueryBuilder.filterFunctionBuilders().length);
            .setScale(5.0)
        // Test MAX boost mode  
        assertEquals("painless", openSearchScript.getLang());
        FunctionScoreQueryBuilder builder1 = (FunctionScoreQueryBuilder) result1;  
        // Create first function - field value factor
        FunctionScoreContainer container1 = FunctionScoreContainer.newBuilder()
        FunctionScoreQueryBuilder.FilterFunctionBuilder filterFunction = functionScoreQueryBuilder.filterFunctionBuilders()[0];
            .setField("popularity")
            .setScoreMode(FunctionScoreMode.FUNCTION_SCORE_MODE_MULTIPLY)
    public void testFromProtoWithRandomScoreFunction() {  
            .build();
        assertEquals(org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode.SUM, builder2.scoreMode());
        // Create a function score container with the gaussian decay function
        super.setUp();  
            instanceOf(org.opensearch.index.query.functionscore.RandomScoreFunctionBuilder.class)
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder().addFunctions(container).build();
            .build();
            .build();  
            .setBoostMode(FunctionBoostMode.FUNCTION_BOOST_MODE_MIN)  
        assertThat(
        FunctionScoreQuery functionScoreQuery1 = FunctionScoreQuery.newBuilder()  
            .build();  
            .setMaxBoost(10.0f)  
            .build();
        // Verify the third function (exponential decay)
        QueryBuilder result = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery, registry);
        // Verify that functions were added
        // Verify that functions were added  
        assertEquals(1, functionScoreQueryBuilder.filterFunctionBuilders().length);  
        assertThat(result, instanceOf(FunctionScoreQueryBuilder.class));  
            .setDecay(0.3)
        FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) result;
        org.opensearch.index.query.functionscore.ScriptScoreFunctionBuilder scriptFunction =
        FunctionScoreQueryBuilder.FilterFunctionBuilder filterFunction1 = functionScoreQueryBuilder.filterFunctionBuilders()[0];
        QueryBuilder result = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery, registry);  
            .addFunctions(container1)
        assertThat(result, instanceOf(FunctionScoreQueryBuilder.class));
        assertThat(result, instanceOf(FunctionScoreQueryBuilder.class));
        // Create a function score query with neither query nor functions
import org.opensearch.protobufs.FunctionScoreQuery;
            .build();
import org.opensearch.protobufs.FieldValueFactorModifier;
        TermQuery termQuery = TermQuery.newBuilder()
            .setQuery(queryContainer)
        assertThat(result, instanceOf(FunctionScoreQueryBuilder.class));  
    }
        // Verify the second function (random score)
            .build();
        assertEquals(10.0f, functionScoreQueryBuilder.maxBoost(), 0.001f);  
        FunctionScoreQueryBuilder.FilterFunctionBuilder filterFunction3 = functionScoreQueryBuilder.filterFunctionBuilders()[2];  
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder().setExp(decayFunction).setWeight(1.0f).build();
            .setNumericDecayPlacement(numericPlacement)
        FunctionScoreQueryBuilder builder6 = (FunctionScoreQueryBuilder) result6;
import org.opensearch.protobufs.FieldValueFactorScoreFunction;  
            filterFunction3.getScoreFunction(),
            .setScoreMode(FunctionScoreMode.FUNCTION_SCORE_MODE_SUM)
        assertThat(result, instanceOf(FunctionScoreQueryBuilder.class));
        // Create an empty decay function (no placements)
        QueryBuilder result = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery, registry);
        assertNotNull(functionScoreQueryBuilder.filterFunctionBuilders());
        // Test AVG score mode  
            .setValue(FieldValue.newBuilder().setString("search").build())  
        org.opensearch.script.Script openSearchScript = scriptFunction.getScript();  
            .build();
            filterFunction1.getScoreFunction(),  
        registry = new QueryBuilderProtoConverterRegistryImpl();
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();  
    public void testFromProtoWithMultipleFunctions() {
            .setBoostMode(FunctionBoostMode.FUNCTION_BOOST_MODE_MULTIPLY)  
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder().addFunctions(container).build();  
            .setQuery(queryContainer)  
        assertThat(  
            .setBoostMode(FunctionBoostMode.FUNCTION_BOOST_MODE_MAX)
        assertEquals(org.opensearch.common.lucene.search.function.CombineFunction.MAX, builder5.boostMode());
        assertThat(result5, instanceOf(FunctionScoreQueryBuilder.class));  
            .putPlacement("distance", decayPlacement)  
            .setOrigin(20.0)  
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder().addFunctions(container).build();  
        // Verify that functions were added
            .setParams(
        assertEquals(1, functionScoreQueryBuilder.filterFunctionBuilders().length);
        assertEquals(2.0f, functionScoreQueryBuilder.boost(), 0.001f);
            .build();
import org.opensearch.protobufs.QueryContainer;
        // Create second function - random score
        assertEquals(1, functionScoreQueryBuilder.filterFunctionBuilders().length);  
            )
        // Create a function score query with only weight (no specific function)
        // Test MIN score mode  
        assertNotNull(functionScoreQueryBuilder.filterFunctionBuilders());  
            .setBoostMode(FunctionBoostMode.FUNCTION_BOOST_MODE_REPLACE)
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_LOG)
        // Create a comprehensive function score query with all parameters  
        FieldValueFactorScoreFunction fieldValueFactor = FieldValueFactorScoreFunction.newBuilder()  
            .setSource("Math.log(doc['popularity'].value) * params.multiplier")
            .setMissing(1.0f)  
        assertNotNull(functionScoreQueryBuilder.filterFunctionBuilders());
            .setBoostMode(FunctionBoostMode.FUNCTION_BOOST_MODE_AVG)
 *
        // Verify that functions were added
                org.opensearch.protobufs.ScriptLanguage.newBuilder()
        FunctionScoreQueryBuilder.FilterFunctionBuilder filterFunction2 = functionScoreQueryBuilder.filterFunctionBuilders()[1];
        RandomScoreFunction randomScore = RandomScoreFunction.newBuilder()  
        // Verify functions
            .setValue(FieldValue.newBuilder().setString("electronics").build())  
        // Verify the linear decay function
        // Initialize the registry for FunctionScoreQueryBuilderProtoUtils
        assertEquals(org.opensearch.common.lucene.search.function.CombineFunction.AVG, builder4.boostMode());
        assertEquals(org.opensearch.common.lucene.search.function.CombineFunction.MULTIPLY, builder1.boostMode());
            .setOffset(1.0)  
            .build();
        // Verify the field name  
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder().addFunctions(container).build();
            .setNumericDecayPlacement(numericPlacement)
        FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) result;  
    }  
        FunctionScoreQueryBuilder.FilterFunctionBuilder filterFunction = functionScoreQueryBuilder.filterFunctionBuilders()[0];  
        assertThat(result, instanceOf(FunctionScoreQueryBuilder.class));
        // Should have a MatchAllQueryBuilder as the base query
            .build();
            .setScoreMode(FunctionScoreMode.FUNCTION_SCORE_MODE_MAX)
        assertThat(  
            .setScoreMode(FunctionScoreMode.FUNCTION_SCORE_MODE_SUM)
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_SQRT)  
        assertThat(result, instanceOf(FunctionScoreQueryBuilder.class));
        assertEquals("rating", gaussFunction.getFieldName());
        assertEquals(org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode.MIN, builder6.scoreMode());
        // Verify the field name
        assertThat(result, instanceOf(FunctionScoreQueryBuilder.class));  
            .build();
            .build();
 * compatible open source license.
            .addFunctions(container2)  
        assertEquals(0.1f, functionScoreQueryBuilder.getMinScore(), 0.001f);
        FunctionScoreQueryBuilder builder4 = (FunctionScoreQueryBuilder) result4;
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder()
            .setSeed(RandomScoreFunctionSeed.newBuilder().setString("test_seed").build())
        FunctionScoreContainer container2 = FunctionScoreContainer.newBuilder().setRandomScore(randomScore).setWeight(0.5f).build();
        // Create a decay placement
 * this file be licensed under the Apache-2.0 license or a
            .setScoreMode(FunctionScoreMode.FUNCTION_SCORE_MODE_FIRST)  
            .putPlacement("rating", decayPlacement)
        assertEquals(2, functionScoreQueryBuilder.filterFunctionBuilders().length);  
                org.opensearch.protobufs.ObjectMap.newBuilder()  
            .setBoostMode(FunctionBoostMode.FUNCTION_BOOST_MODE_SUM)  
        assertThat(result, instanceOf(FunctionScoreQueryBuilder.class));
        assertEquals(org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode.SUM, functionScoreQueryBuilder.scoreMode());
            .addFunctions(container2)
        FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) result;  
        assertEquals("Math.log(doc['popularity'].value) * params.multiplier", openSearchScript.getIdOrCode());  
            filterFunction.getScoreFunction(),
        // This should throw an exception because decay function has no placements
        FunctionScoreQueryBuilder builder4 = (FunctionScoreQueryBuilder) result4;  
    public void setUp() throws Exception {
        org.opensearch.protobufs.Script script = org.opensearch.protobufs.Script.newBuilder().setInline(inlineScript).build();  
        FieldValueFactorScoreFunction fieldValueFactor = FieldValueFactorScoreFunction.newBuilder()  
        FunctionScoreQuery functionScoreQuery5 = FunctionScoreQuery.newBuilder()
            .putPlacement("price", decayPlacement)
            .build();  
    }
        assertThat(result, instanceOf(FunctionScoreQueryBuilder.class));
    public void testFromProtoWithDifferentScoreModes() {  
        FunctionScoreQueryBuilder builder5 = (FunctionScoreQueryBuilder) result5;  
        FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) result;
package org.opensearch.transport.grpc.proto.request.search.query.functionscore;
        assertEquals(org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode.FIRST, builder4.scoreMode());  
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder().addFunctions(container).build();
        FunctionScoreQuery functionScoreQuery4 = FunctionScoreQuery.newBuilder()  
        assertNotNull(functionScoreQueryBuilder.filterFunctionBuilders());
        // Create an inline script  
    }
public class FunctionScoreQueryBuilderProtoUtilsTests extends OpenSearchTestCase {  
        // Create a numeric decay placement  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(filterFunction.getScoreFunction(), instanceOf(org.opensearch.index.query.functionscore.GaussDecayFunctionBuilder.class));
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder().setScriptScore(scriptScoreFunction).setWeight(1.5f).build();  
        assertEquals(1, functionScoreQueryBuilder.filterFunctionBuilders().length);
import org.opensearch.protobufs.FunctionScoreMode;  
            .setField("title")
        // Verify the exponential decay function
        org.opensearch.protobufs.DecayFunction decayFunction = org.opensearch.protobufs.DecayFunction.newBuilder()  
        assertEquals("distance", linearFunction.getFieldName());
            .build();
            .build();
        assertThat(result2, instanceOf(FunctionScoreQueryBuilder.class));  
import org.opensearch.index.query.MatchAllQueryBuilder;
        assertThat(result4, instanceOf(FunctionScoreQueryBuilder.class));
            .build();
            .build();
                    .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)
        FunctionScoreQueryBuilder functionScoreQueryBuilder = (FunctionScoreQueryBuilder) result;  
    }
        FunctionScoreQueryBuilder builder5 = (FunctionScoreQueryBuilder) result5;
            .build();
        assertEquals(1, functionScoreQueryBuilder.filterFunctionBuilders().length);
            .setFieldValueFactor(fieldValueFactor)
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder().setExp(decayFunction).setWeight(1.5f).build();  
import org.opensearch.protobufs.FunctionScoreContainer;
}  
        // Create a term query for the filter  
            .setNumericDecayPlacement(numericPlacement)  
        FunctionScoreQuery functionScoreQuery6 = FunctionScoreQuery.newBuilder()
        // Verify the script score function
            .putPlacement("price", decayPlacement)
        // Verify that functions were added  
            .setMinScore(0.1f)  
            .build();
            (org.opensearch.index.query.functionscore.LinearDecayFunctionBuilder) filterFunction.getScoreFunction();
        FunctionScoreQuery functionScoreQuery6 = FunctionScoreQuery.newBuilder()
        // Test REPLACE boost mode  
            (org.opensearch.index.query.functionscore.GaussDecayFunctionBuilder) filterFunction.getScoreFunction();
        // Create a decay placement  
        );  
        assertThat(result1, instanceOf(FunctionScoreQueryBuilder.class));
            .setBoostMode(FunctionBoostMode.FUNCTION_BOOST_MODE_MULTIPLY)
import org.opensearch.index.query.QueryBuilder;
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_LOG)
        assertEquals(org.opensearch.script.ScriptType.INLINE, openSearchScript.getType());
        RandomScoreFunction randomScore = RandomScoreFunction.newBuilder()
        org.opensearch.protobufs.NumericDecayPlacement numericPlacement = org.opensearch.protobufs.NumericDecayPlacement.newBuilder()
        // Verify that functions were added
        FieldValueFactorScoreFunction fieldValueFactor = FieldValueFactorScoreFunction.newBuilder()  
        // Create a decay function with the placement
    }
    }  
            .setFieldValueFactor(fieldValueFactor)
        IllegalArgumentException exception = expectThrows(  
            .build();  
            .setMaxBoost(15.0f)
        assertEquals(15.0f, functionScoreQueryBuilder.maxBoost(), 0.001f);  
        // Test AVG boost mode
        org.opensearch.index.query.functionscore.LinearDecayFunctionBuilder linearFunction =  
        // Test SUM score mode
        FunctionScoreQueryBuilder builder1 = (FunctionScoreQueryBuilder) result1;
    public void testFromProtoWithFunctionAndFilter() {
        FunctionScoreQuery functionScoreQuery2 = FunctionScoreQuery.newBuilder()  
        );  
        QueryBuilder result = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery, registry);
        );
    public void testFromProtoWithBasicFunctionScoreQuery() {
            instanceOf(org.opensearch.index.query.functionscore.ExponentialDecayFunctionBuilder.class)  
        // Test MIN boost mode
            .setScale(50.0)  
    }
    public void testFromProtoWithGaussianDecayFunction() {  
        FunctionScoreQueryBuilder builder2 = (FunctionScoreQueryBuilder) result2;
        // Test MAX score mode
        assertNotNull(filterFunction.getFilter());
            .setField("_id")
    }
        assertThat(  
        QueryBuilder result6 = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery6, registry);
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder().addFunctions(container).build();  
        org.opensearch.protobufs.DecayFunction decayFunction = org.opensearch.protobufs.DecayFunction.newBuilder()  
            .build();
        // Test FIRST score mode
        );
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder()
            () -> FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery, registry)
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder()
    public void testFromProtoWithEmptyDecayFunction() {  
            .addFunctions(container3)  
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder().setLinear(decayFunction).setWeight(1.0f).build();
            .setMinScore(0.5f)
        QueryBuilder result2 = FunctionScoreQueryBuilderProtoUtils.fromProto(functionScoreQuery2, registry);
        // Create a function score query with random_score function
    public void testFromProtoWithFieldValueFactorFunction() {
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder().setWeight(3.0f).build();  
