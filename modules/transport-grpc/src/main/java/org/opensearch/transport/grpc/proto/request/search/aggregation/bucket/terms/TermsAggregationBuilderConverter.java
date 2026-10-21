            throw new IllegalStateException("AggregationContainer doesn't have terms aggregation");
 * The OpenSearch Contributors require contributions made to
import java.util.Map;
    private static IncludeExclude convertInclude(TermsInclude include) {
            includeExclude = convertInclude(terms.getInclude());
            .missing(terms.hasMissing() ? FieldValueProtoUtils.fromProto(terms.getMissing(), false) : null)
            case TERMS_AGGREGATION_EXECUTION_HINT_MAP -> "map";
 */
        List<BucketOrder> orders = new ArrayList<>(orderList.size());
    /**
        TermsAggregation proto = container.getTermsAggregation();
     * @param name the aggregation name
 *
        TermsAggregationFields terms = proto.getTerms();
        }
            default -> throw new IllegalArgumentException("Unsupported collect mode: " + mode);
import org.opensearch.transport.grpc.proto.request.search.aggregation.support.ValuesSourceAggregationProtoUtils;
import org.opensearch.protobufs.TermsAggregationFields;
            IncludeExclude excludeIE = convertExclude(terms.getExclude());
            String key = entry.getField();
import org.opensearch.transport.grpc.proto.request.common.ScriptProtoUtils;
import org.opensearch.search.aggregations.bucket.terms.TermsAggregatorFactory;
import org.opensearch.search.aggregations.InternalOrder;
        }
        };
     * See {@link IncludeExclude#parseInclude(XContentParser)}
            aggBuilder.shardSize(terms.getShardSize());
    /**
        return switch (hint) {
        }
        return switch (mode) {
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;
            case TERMS_AGGREGATION_EXECUTION_HINT_GLOBAL_ORDINALS -> "global_ordinals";
        TermsAggregationBuilder aggBuilder = new TermsAggregationBuilder(name);
            .field(terms.hasField() ? terms.getField() : null)
import org.opensearch.transport.grpc.proto.request.search.aggregation.support.ValuesSourceProtoFields;
import org.opensearch.protobufs.TermsInclude;
        if (proto.getAggregationsCount() > 0) {
    public AggregationBuilder fromProto(String name, AggregationContainer container) {
            throw new IllegalArgumentException("Terms fields are not provided, cannot parse");
        if (terms.hasMinDocCount()) {
    }
        if (terms.hasInclude()) {
        if (terms.hasShardSize()) {
            includeExclude = IncludeExclude.merge(includeExclude, excludeIE);
 */
        return switch (include.getTermsIncludeCase()) {
        return AggregationContainer.AggregationContainerCase.TERMS_AGGREGATION;
    }
            default -> throw new IllegalArgumentException("Unsupported include type: " + include.getTermsIncludeCase());
        IncludeExclude includeExclude = null;
     * @return the constructed {@link TermsAggregationBuilder}
     * This method parallels the REST parsing logic in {@link TermsAggregationBuilder#PARSER}
    }
            aggBuilder.collectMode(convertCollectMode(terms.getCollectMode()));
import org.opensearch.core.xcontent.XContentParser;
     * @param container the protobuf aggregation container
        }
            }
            boolean asc = entry.getSortOrder() == SortOrder.SORT_ORDER_ASC;
            orders.add(InternalOrder.Parser.resolveOrderParam(key, asc));
            case TERMS_AGGREGATION_COLLECT_MODE_BREADTH_FIRST -> SubAggCollectionMode.BREADTH_FIRST;
    private static IncludeExclude convertExclude(TermsExclude exclude) {
            default -> throw new IllegalArgumentException("Unsupported execution hint: " + hint);
            case TERMS_AGGREGATION_EXECUTION_HINT_GLOBAL_ORDINALS_LOW_CARDINALITY -> "global_ordinals_low_cardinality";
                yield new IncludeExclude(null, excludeTerms);
    /**
    }
        };
        if (terms.hasExecutionHint()) {
        }
    private static SubAggCollectionMode convertCollectMode(TermsAggregationCollectMode mode) {
    /**
        // common fields for ValuesSourceAggregation
     */
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverterRegistry;
import org.opensearch.protobufs.TermsAggregation;
import org.opensearch.transport.grpc.proto.response.common.FieldValueProtoUtils;
 * SPDX-License-Identifier: Apache-2.0
     * See {@link TermsAggregatorFactory.ExecutionMode#fromString(String)}
            .format(terms.hasFormat() ? terms.getFormat() : null)
        }
    }
        if (terms.hasShowTermDocCountError()) {
        return orders;
     */
                yield new IncludeExclude(includeTerms, null);
    private static List<BucketOrder> convertOrder(List<SortOrderSingleMap> orderList) {
        // Default constructor
package org.opensearch.transport.grpc.proto.request.search.aggregation.bucket.terms;
     */
        }
import org.opensearch.protobufs.TermsAggregationCollectMode;
        if (terms.hasCollectMode()) {
 * this file be licensed under the Apache-2.0 license or a
            for (Map.Entry<String, AggregationContainer> entry : proto.getAggregationsMap().entrySet()) {
/**
        // sub-aggregations
            case REGEXP -> new IncludeExclude(include.getRegexp(), null);
            case TERMS_AGGREGATION_EXECUTION_HINT_GLOBAL_ORDINALS_HASH -> "global_ordinals_hash";
import org.opensearch.search.aggregations.BucketOrder;
/*
            case TERMS -> {
            aggBuilder.shardMinDocCount(terms.getShardMinDocCount());
import org.opensearch.protobufs.SortOrderSingleMap;
            aggBuilder.minDocCount(terms.getMinDocCount());
        if (terms.hasShardMinDocCount()) {
     *
            case PARTITION -> new IncludeExclude(include.getPartition().getPartition(), include.getPartition().getNumPartitions());
import org.opensearch.protobufs.TermsExclude;
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        return aggBuilder;
    public TermsAggregationBuilderConverter() {
        if (terms.hasExclude()) {
        }
 * Converter from proto {@link TermsAggregation} to {@link TermsAggregationBuilder}.
                throw new IllegalStateException("Registry not set properly, cannot parse sub aggregations");
        ValuesSourceProtoFields valuesSourceFields = ValuesSourceProtoFields.builder()
            if (registry == null) {
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverter;
    }
    /**
import java.util.List;
        return switch (exclude.getTermsExcludeCase()) {
                String[] excludeTerms = exclude.getTerms().getStringArrayList().toArray(new String[0]);
    private AggregationBuilderProtoConverterRegistry registry;
 * compatible open source license.
            default -> throw new IllegalArgumentException("Unsupported exclude type: " + exclude.getTermsExcludeCase());
        }
            aggBuilder.includeExclude(includeExclude);
import org.opensearch.protobufs.AggregationContainer;
    private static String convertExecutionHint(TermsAggregationExecutionHint hint) {
        if (terms.hasSize()) {
        }
        ValuesSourceAggregationProtoUtils.declareFields(aggBuilder, valuesSourceFields, true, true, false);
        if (!proto.hasTerms()) {
        }
            case TERMS -> {
import org.opensearch.protobufs.TermsAggregationExecutionHint;
import java.util.ArrayList;
     * See {@link IncludeExclude#parseExclude(XContentParser)}
            aggBuilder.size(terms.getSize());
    }
            .build();
    @Override
            aggBuilder.order(convertOrder(terms.getOrderList()));
     */
        }
            }
        }
        };
            }
        }
            case REGEXP -> new IncludeExclude(null, exclude.getRegexp());
    }
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
    public AggregationContainer.AggregationContainerCase getHandledAggregationCase() {
import org.opensearch.search.aggregations.AggregationBuilder;
}
        };
import org.opensearch.protobufs.SortOrder;
     * Constructs a new TermsAggregationBuilderConverter.
public class TermsAggregationBuilderConverter implements AggregationBuilderProtoConverter {
        }
            .valueType(terms.hasValueType() ? terms.getValueType() : null)
        if (terms.getOrderCount() > 0) {
        if (includeExclude != null) {
            .script(terms.hasScript() ? ScriptProtoUtils.parseFromProtoRequest(terms.getScript()) : null)
    @Override
        // include/exclude handling mirrors IncludeExclude.merge logic in the REST parser
            case TERMS_AGGREGATION_COLLECT_MODE_DEPTH_FIRST -> SubAggCollectionMode.DEPTH_FIRST;
        if (!container.hasTermsAggregation()) {
            }
    @Override
    }
                aggBuilder.subAggregation(registry.fromProto(entry.getKey(), entry.getValue()));
            aggBuilder.showTermDocCountError(terms.getShowTermDocCountError());
                String[] includeTerms = include.getTerms().getStringArrayList().toArray(new String[0]);
            aggBuilder.executionHint(convertExecutionHint(terms.getExecutionHint()));
     */
        for (SortOrderSingleMap entry : orderList) {
        this.registry = registry;
    public void setRegistry(AggregationBuilderProtoConverterRegistry registry) {
