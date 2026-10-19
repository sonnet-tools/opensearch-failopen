            case FUNCTION_SCORE_MODE_MIN -> org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode.MIN;
        if (functionScoreQueryProto.hasBoostMode()
        if (functionScoreQueryProto.hasScoreMode()
        if (filter == null) {
        functionScoreQueryBuilder.boost(boost);
        FunctionScoreContainer.FunctionScoreContainerCase functionCase = container.getFunctionScoreContainerCase();
        if (functionScoreQueryProto.hasXName()) {
    private static FunctionScoreQueryBuilder.FilterFunctionBuilder parseFunctionScoreContainer(
            case FUNCTION_SCORE_MODE_MULTIPLY -> org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode.MULTIPLY;
        float maxBoost = org.opensearch.common.lucene.search.function.FunctionScoreQuery.DEFAULT_MAX_BOOST;
package org.opensearch.transport.grpc.proto.request.search.query.functionscore;
            throw new IllegalArgumentException("FunctionScoreQuery cannot be null");
    /**
        return switch (scoreMode) {
 *
        if (functionScoreQueryProto == null) {
     */
        if (functionScoreQueryProto.getFunctionsCount() > 0) {
import org.opensearch.protobufs.FunctionScoreMode;
    }
        return switch (boostMode) {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.lucene.search.function.CombineFunction;
        if (functionScoreQueryProto.hasMinScore()) {
            case FUNCTION_SCORE_MODE_SUM -> org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode.SUM;
            case FIELD_VALUE_FACTOR -> FieldValueFactorFunctionProtoUtils.fromProto(container.getFieldValueFactor());
            case FUNCTION_SCORE_MODE_MAX -> org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode.MAX;
class FunctionScoreQueryBuilderProtoUtils {
     * Converts a Protocol Buffer FunctionScoreQuery to an OpenSearch FunctionScoreQueryBuilder.
            } else {
        FunctionScoreQueryBuilder functionScoreQueryBuilder = new FunctionScoreQueryBuilder(
        }
     * @param scoreMode the FunctionScoreMode to parse
     * parses the Protocol Buffer representation and creates a properly configured
import org.opensearch.index.query.MatchAllQueryBuilder;
     */
            default -> throw new IllegalArgumentException("Unsupported score mode: " + scoreMode);
     * @throws IllegalArgumentException if the function score query is invalid or contains unsupported function types
     *
            && functionScoreQueryProto.getBoostMode() != FunctionBoostMode.FUNCTION_BOOST_MODE_UNSPECIFIED) {
            scoreMode = parseScoreMode(functionScoreQueryProto.getScoreMode());
        }
     * Parses a FunctionScoreContainer and creates the appropriate ScoreFunctionBuilder.
        if (container == null) {
            functionWeight = container.getWeight();
import java.util.ArrayList;
        if (container.hasWeight()) {
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;
            minScore = functionScoreQueryProto.getMinScore();
import java.util.List;
     * Parses a FunctionScoreContainer and creates the appropriate FilterFunctionBuilder.
        org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode scoreMode = FunctionScoreQueryBuilder.DEFAULT_SCORE_MODE;
            case FUNCTION_BOOST_MODE_REPLACE -> CombineFunction.REPLACE;
        return new FunctionScoreQueryBuilder.FilterFunctionBuilder(filter, scoreFunction);
    /**
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;
                filterFunctionBuilders.add(filterFunctionBuilder);
        if (functionScoreQueryProto.hasMaxBoost()) {
     */
 * This class provides methods to transform Protocol Buffer representations of function score queries
import org.opensearch.index.query.QueryBuilder;
        if (container.hasFilter()) {
        }
     * @return the corresponding FunctionScoreQuery.ScoreMode
     * @throws IllegalArgumentException if the scoreMode is unknown or unsupported
        }
        ScoreFunctionBuilder<?> scoreFunction = null;
            case FUNCTION_SCORE_MODE_FIRST -> org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode.FIRST;
            queryName = functionScoreQueryProto.getXName();
        if (functionScoreQueryProto.hasBoost()) {
import org.opensearch.index.query.functionscore.ScoreFunctionBuilder;
    }
     * Parses a FunctionBoostMode enum to CombineFunction.     *
            QueryContainer queryContainer = functionScoreQueryProto.getQuery();
            case FUNCTION_BOOST_MODE_MULTIPLY -> CombineFunction.MULTIPLY;
        };
import org.opensearch.protobufs.FunctionScoreQuery;
            scoreFunction = parseScoreFunction(container);
    }
import org.opensearch.index.query.functionscore.WeightBuilder;
        if (container.getFunctionScoreContainerCase() == FunctionScoreContainer.FunctionScoreContainerCase.FUNCTIONSCORECONTAINER_NOT_SET) {
    }
            case EXP -> ExpDecayFunctionProtoUtils.fromProto(container.getExp());
        QueryBuilder filter = null;
            maxBoost = functionScoreQueryProto.getMaxBoost();
        };
            query = new MatchAllQueryBuilder();
                FunctionScoreQueryBuilder.FilterFunctionBuilder filterFunctionBuilder = parseFunctionScoreContainer(container, registry);
 */
     *
     * @return A configured FunctionScoreQueryBuilder instance
            filter = new MatchAllQueryBuilder();
/*
        }
        // Utility class, no instances
     * Parses a FunctionScoreMode enum to ScoreMode.
            default -> throw new IllegalArgumentException("Unsupported boost mode: " + boostMode);
            boost = functionScoreQueryProto.getBoost();
        FunctionScoreContainer container,
import org.opensearch.index.query.AbstractQueryBuilder;
            }
    ) {
    static FunctionScoreQueryBuilder fromProto(FunctionScoreQuery functionScoreQueryProto, QueryBuilderProtoConverterRegistry registry) {
        }
        }
        List<FunctionScoreQueryBuilder.FilterFunctionBuilder> filterFunctionBuilders = new ArrayList<>();
        if (minScore != null) {
     * Similar to {@link FunctionScoreQueryBuilder#fromXContent(XContentParser)}, this method
            query = registry.fromProto(queryContainer);
        };
        );
            query,
    private static CombineFunction parseBoostMode(FunctionBoostMode boostMode) {
        }
 * into their corresponding OpenSearch FunctionScoreQueryBuilder implementations for search operations.
    }
        }
            case FUNCTION_BOOST_MODE_MIN -> CombineFunction.MIN;
        Float minScore = null;
            for (FunctionScoreContainer container : functionScoreQueryProto.getFunctionsList()) {
                scoreFunction.setWeight(functionWeight);
            case SCRIPT_SCORE -> ScriptScoreFunctionProtoUtils.fromProto(container.getScriptScore());
}
            case FUNCTION_BOOST_MODE_MAX -> CombineFunction.MAX;
    private FunctionScoreQueryBuilderProtoUtils() {
        functionScoreQueryBuilder.maxBoost(maxBoost);
        }
    }
        Float functionWeight = null;
            case GAUSS -> GaussDecayFunctionProtoUtils.fromProto(container.getGauss());
import org.opensearch.protobufs.FunctionBoostMode;
     */
        if (combineFunction != null) {
        if (queryName != null) {
/**
            case FUNCTION_SCORE_MODE_AVG -> org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode.AVG;
            functionScoreQueryBuilder.setMinScore(minScore);
        CombineFunction combineFunction = null;
     * @throws IllegalArgumentException if the boostMode is unknown or unsupported
            scoreFunction = null;
            functionScoreQueryBuilder.queryName(queryName);
            default -> throw new IllegalArgumentException("Unsupported function score type: " + functionCase);
     * @param registry The registry to use for converting nested queries
        if (container == null) {
 * The OpenSearch Contributors require contributions made to
        if (functionWeight != null) {
    /**
            filter = registry.fromProto(filterContainer);
        return functionScoreQueryBuilder;
            combineFunction = parseBoostMode(functionScoreQueryProto.getBoostMode());
    /**
     * @param functionScoreQueryProto The Protocol Buffer FunctionScoreQuery object
        }
        }
     * FunctionScoreQueryBuilder with the appropriate query, functions, boost mode, score mode,
import org.opensearch.protobufs.FunctionScoreContainer;
        } else {
        if (query == null) {
                scoreFunction = new WeightBuilder().setWeight(functionWeight);
        QueryBuilderProtoConverterRegistry registry
        }
            throw new IllegalArgumentException("FunctionScoreContainer cannot be null");
            && functionScoreQueryProto.getScoreMode() != FunctionScoreMode.FUNCTION_SCORE_MODE_UNSPECIFIED) {
            functionScoreQueryBuilder.boostMode(combineFunction);
 * compatible open source license.
        functionScoreQueryBuilder.scoreMode(scoreMode);
import org.opensearch.protobufs.QueryContainer;
 */
 * SPDX-License-Identifier: Apache-2.0
     * @param boostMode the FunctionBoostMode to parse
            case FUNCTION_BOOST_MODE_AVG -> CombineFunction.AVG;
            QueryContainer filterContainer = container.getFilter();
            if (scoreFunction == null) {
        }
            filterFunctionBuilders.toArray(new FunctionScoreQueryBuilder.FilterFunctionBuilder[0])
     * max boost, min score, boost, and query name settings.
     */
            throw new IllegalArgumentException("FunctionScoreContainer cannot be null");
        }
        }
        }
        }
     * @return the corresponding CombineFunction
    private static ScoreFunctionBuilder<?> parseScoreFunction(FunctionScoreContainer container) {
            case FUNCTION_BOOST_MODE_SUM -> CombineFunction.SUM;
            }
    private static org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode parseScoreMode(FunctionScoreMode scoreMode) {
        if (functionScoreQueryProto.hasQuery()) {
            case LINEAR -> LinearDecayFunctionProtoUtils.fromProto(container.getLinear());
        }
            case RANDOM_SCORE -> RandomScoreFunctionProtoUtils.fromProto(container.getRandomScore());
        return switch (functionCase) {
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
        QueryBuilder query = null;
        String queryName = null;
        }
 * Utility class for converting FunctionScoreQuery Protocol Buffers to OpenSearch objects.
    /**
