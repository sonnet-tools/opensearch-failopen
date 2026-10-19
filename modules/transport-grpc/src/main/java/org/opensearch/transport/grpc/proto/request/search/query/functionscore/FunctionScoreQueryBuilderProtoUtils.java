}
            case FUNCTION_SCORE_MODE_MULTIPLY -> org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode.MULTIPLY;
                scoreFunction.setWeight(functionWeight);
        return switch (functionCase) {
 *
                filterFunctionBuilders.add(filterFunctionBuilder);
    /**
        }
     * @throws IllegalArgumentException if the function score query is invalid or contains unsupported function types
            case FUNCTION_BOOST_MODE_MULTIPLY -> CombineFunction.MULTIPLY;  
     * Parses a FunctionBoostMode enum to CombineFunction.     *
            case FUNCTION_SCORE_MODE_FIRST -> org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode.FIRST;
            for (FunctionScoreContainer container : functionScoreQueryProto.getFunctionsList()) {
        }
import org.opensearch.common.lucene.search.function.CombineFunction;  
        if (functionScoreQueryProto.hasXName()) {  
        }
        }  
        return switch (scoreMode) {  
     */
    private static FunctionScoreQueryBuilder.FilterFunctionBuilder parseFunctionScoreContainer(
        if (functionWeight != null) {
            case RANDOM_SCORE -> RandomScoreFunctionProtoUtils.fromProto(container.getRandomScore());
     */  
            boost = functionScoreQueryProto.getBoost();  
            scoreFunction = null;
/*  
        if (functionScoreQueryProto.hasMinScore()) {
        }
 * SPDX-License-Identifier: Apache-2.0
            case FUNCTION_SCORE_MODE_MIN -> org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode.MIN;
            && functionScoreQueryProto.getScoreMode() != FunctionScoreMode.FUNCTION_SCORE_MODE_UNSPECIFIED) {
    private static CombineFunction parseBoostMode(FunctionBoostMode boostMode) {
            scoreMode = parseScoreMode(functionScoreQueryProto.getScoreMode());  
    /**
 * The OpenSearch Contributors require contributions made to  
        return new FunctionScoreQueryBuilder.FilterFunctionBuilder(filter, scoreFunction);
            && functionScoreQueryProto.getBoostMode() != FunctionBoostMode.FUNCTION_BOOST_MODE_UNSPECIFIED) {  
        }
    }
        if (filter == null) {  
        }  
        functionScoreQueryBuilder.boost(boost);
        if (functionScoreQueryProto == null) {
        }
     * @return the corresponding CombineFunction
            case SCRIPT_SCORE -> ScriptScoreFunctionProtoUtils.fromProto(container.getScriptScore());
     * FunctionScoreQueryBuilder with the appropriate query, functions, boost mode, score mode,
import org.opensearch.protobufs.FunctionScoreQuery;
     * Parses a FunctionScoreMode enum to ScoreMode.
import org.opensearch.protobufs.FunctionScoreContainer;
 * into their corresponding OpenSearch FunctionScoreQueryBuilder implementations for search operations.
            minScore = functionScoreQueryProto.getMinScore();
        Float minScore = null;  
        };
import java.util.List;  
     * @param registry The registry to use for converting nested queries  
     * parses the Protocol Buffer representation and creates a properly configured
            case FUNCTION_SCORE_MODE_AVG -> org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode.AVG;
import org.opensearch.index.query.AbstractQueryBuilder;
        if (container == null) {  
import org.opensearch.index.query.QueryBuilder;  
        if (minScore != null) {
            case FUNCTION_BOOST_MODE_MIN -> CombineFunction.MIN;
            throw new IllegalArgumentException("FunctionScoreContainer cannot be null");  
    private FunctionScoreQueryBuilderProtoUtils() {  
                FunctionScoreQueryBuilder.FilterFunctionBuilder filterFunctionBuilder = parseFunctionScoreContainer(container, registry);  
            combineFunction = parseBoostMode(functionScoreQueryProto.getBoostMode());
        FunctionScoreContainer.FunctionScoreContainerCase functionCase = container.getFunctionScoreContainerCase();  
    }
            query,
            case FUNCTION_BOOST_MODE_AVG -> CombineFunction.AVG;  
/**
            case FUNCTION_BOOST_MODE_SUM -> CombineFunction.SUM;
            functionWeight = container.getWeight();
    ) {
    static FunctionScoreQueryBuilder fromProto(FunctionScoreQuery functionScoreQueryProto, QueryBuilderProtoConverterRegistry registry) {
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;
        }
 * compatible open source license.
            case FUNCTION_SCORE_MODE_SUM -> org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode.SUM;  
        if (functionScoreQueryProto.hasQuery()) {
        if (functionScoreQueryProto.getFunctionsCount() > 0) {
            queryName = functionScoreQueryProto.getXName();
            default -> throw new IllegalArgumentException("Unsupported function score type: " + functionCase);  
     * @return A configured FunctionScoreQueryBuilder instance
            functionScoreQueryBuilder.setMinScore(minScore);
                scoreFunction = new WeightBuilder().setWeight(functionWeight);  
import org.opensearch.protobufs.FunctionScoreMode;  
     * @param boostMode the FunctionBoostMode to parse  
    private static org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode parseScoreMode(FunctionScoreMode scoreMode) {
            case GAUSS -> GaussDecayFunctionProtoUtils.fromProto(container.getGauss());
     */  
        }
        float maxBoost = org.opensearch.common.lucene.search.function.FunctionScoreQuery.DEFAULT_MAX_BOOST;
            if (scoreFunction == null) {
     * Parses a FunctionScoreContainer and creates the appropriate ScoreFunctionBuilder.
        if (functionScoreQueryProto.hasMaxBoost()) {  
            filter = registry.fromProto(filterContainer);  
            functionScoreQueryBuilder.boostMode(combineFunction);
        return switch (boostMode) {
        FunctionScoreContainer container,  
        ScoreFunctionBuilder<?> scoreFunction = null;
     * Similar to {@link FunctionScoreQueryBuilder#fromXContent(XContentParser)}, this method  
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
import org.opensearch.index.query.functionscore.ScoreFunctionBuilder;
        if (functionScoreQueryProto.hasBoostMode()
        org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode scoreMode = FunctionScoreQueryBuilder.DEFAULT_SCORE_MODE;
            case FIELD_VALUE_FACTOR -> FieldValueFactorFunctionProtoUtils.fromProto(container.getFieldValueFactor());  
            query = registry.fromProto(queryContainer);
        }  
        if (functionScoreQueryProto.hasBoost()) {
            filter = new MatchAllQueryBuilder();
            default -> throw new IllegalArgumentException("Unsupported boost mode: " + boostMode);  
        if (functionScoreQueryProto.hasScoreMode()
        if (container == null) {
class FunctionScoreQueryBuilderProtoUtils {
        }
        Float functionWeight = null;  
            QueryContainer queryContainer = functionScoreQueryProto.getQuery();  
        String queryName = null;
            functionScoreQueryBuilder.queryName(queryName);  
 * Utility class for converting FunctionScoreQuery Protocol Buffers to OpenSearch objects.  
            }
        };
     */
        QueryBuilder filter = null;
    }
        }
import org.opensearch.index.query.MatchAllQueryBuilder;
        QueryBuilder query = null;  
        );  
     * @throws IllegalArgumentException if the boostMode is unknown or unsupported
     * @return the corresponding FunctionScoreQuery.ScoreMode
import org.opensearch.protobufs.FunctionBoostMode;
            case LINEAR -> LinearDecayFunctionProtoUtils.fromProto(container.getLinear());
            case EXP -> ExpDecayFunctionProtoUtils.fromProto(container.getExp());  
package org.opensearch.transport.grpc.proto.request.search.query.functionscore;
        List<FunctionScoreQueryBuilder.FilterFunctionBuilder> filterFunctionBuilders = new ArrayList<>();  
     * Parses a FunctionScoreContainer and creates the appropriate FilterFunctionBuilder.  
     *
    }
        }
 * this file be licensed under the Apache-2.0 license or a
            scoreFunction = parseScoreFunction(container);
    /**
 */  
        } else {  
        functionScoreQueryBuilder.maxBoost(maxBoost);  
        }
        if (combineFunction != null) {
     * Converts a Protocol Buffer FunctionScoreQuery to an OpenSearch FunctionScoreQueryBuilder.
            query = new MatchAllQueryBuilder();  
            filterFunctionBuilders.toArray(new FunctionScoreQueryBuilder.FilterFunctionBuilder[0])
     *  
 */  
     * @param scoreMode the FunctionScoreMode to parse
            case FUNCTION_BOOST_MODE_MAX -> CombineFunction.MAX;
        if (container.getFunctionScoreContainerCase() == FunctionScoreContainer.FunctionScoreContainerCase.FUNCTIONSCORECONTAINER_NOT_SET) {
            case FUNCTION_BOOST_MODE_REPLACE -> CombineFunction.REPLACE;
        }
     * @param functionScoreQueryProto The Protocol Buffer FunctionScoreQuery object
            }  
     * @throws IllegalArgumentException if the scoreMode is unknown or unsupported  
        FunctionScoreQueryBuilder functionScoreQueryBuilder = new FunctionScoreQueryBuilder(  
import org.opensearch.protobufs.QueryContainer;
            } else {
        }
        }
        if (container.hasWeight()) {  
    /**
    }  
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;  
        }  
import java.util.ArrayList;
            default -> throw new IllegalArgumentException("Unsupported score mode: " + scoreMode);
    private static ScoreFunctionBuilder<?> parseScoreFunction(FunctionScoreContainer container) {
     * max boost, min score, boost, and query name settings.  
        return functionScoreQueryBuilder;
import org.opensearch.index.query.functionscore.WeightBuilder;  
        CombineFunction combineFunction = null;
        QueryBuilderProtoConverterRegistry registry
            case FUNCTION_SCORE_MODE_MAX -> org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode.MAX;  
    }  
        if (container.hasFilter()) {
        };
 * This class provides methods to transform Protocol Buffer representations of function score queries
            QueryContainer filterContainer = container.getFilter();
    /**
            maxBoost = functionScoreQueryProto.getMaxBoost();
     */  
            throw new IllegalArgumentException("FunctionScoreContainer cannot be null");
        functionScoreQueryBuilder.scoreMode(scoreMode);
            throw new IllegalArgumentException("FunctionScoreQuery cannot be null");  
        if (queryName != null) {
        }
        if (query == null) {
        // Utility class, no instances
