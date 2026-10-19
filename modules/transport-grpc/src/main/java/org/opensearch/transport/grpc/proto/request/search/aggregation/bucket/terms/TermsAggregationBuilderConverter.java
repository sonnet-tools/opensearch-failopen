        }
            includeExclude = IncludeExclude.merge(includeExclude, excludeIE);  
            case REGEXP -> new IncludeExclude(null, exclude.getRegexp());
 * The OpenSearch Contributors require contributions made to  
            if (registry == null) {
            case TERMS -> {
}
 */  
            default -> throw new IllegalArgumentException("Unsupported exclude type: " + exclude.getTermsExcludeCase());  
            case TERMS_AGGREGATION_COLLECT_MODE_BREADTH_FIRST -> SubAggCollectionMode.BREADTH_FIRST;
import org.opensearch.protobufs.TermsAggregationFields;
    }
     * See {@link IncludeExclude#parseInclude(XContentParser)}  
     */
            case TERMS -> {
     *
     * @param name the aggregation name
        return switch (hint) {
    /**
            orders.add(InternalOrder.Parser.resolveOrderParam(key, asc));  
        }  
    private static IncludeExclude convertExclude(TermsExclude exclude) {
import org.opensearch.protobufs.AggregationContainer;
import org.opensearch.protobufs.SortOrder;
 *
            }
                throw new IllegalStateException("Registry not set properly, cannot parse sub aggregations");  
            }
            case TERMS_AGGREGATION_EXECUTION_HINT_GLOBAL_ORDINALS_LOW_CARDINALITY -> "global_ordinals_low_cardinality";  
                yield new IncludeExclude(null, excludeTerms);
package org.opensearch.transport.grpc.proto.request.search.aggregation.bucket.terms;
import org.opensearch.protobufs.TermsAggregationExecutionHint;  
import org.opensearch.transport.grpc.proto.response.common.FieldValueProtoUtils;
import org.opensearch.transport.grpc.proto.request.common.ScriptProtoUtils;
        }  
        return aggBuilder;
        ValuesSourceProtoFields valuesSourceFields = ValuesSourceProtoFields.builder()  
    /**
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;
import org.opensearch.transport.grpc.proto.request.search.aggregation.support.ValuesSourceProtoFields;
        }
    }
    public void setRegistry(AggregationBuilderProtoConverterRegistry registry) {
public class TermsAggregationBuilderConverter implements AggregationBuilderProtoConverter {
        return switch (exclude.getTermsExcludeCase()) {  
        // include/exclude handling mirrors IncludeExclude.merge logic in the REST parser
            .valueType(terms.hasValueType() ? terms.getValueType() : null)  
        if (proto.getAggregationsCount() > 0) {
     * This method parallels the REST parsing logic in {@link TermsAggregationBuilder#PARSER}  
            String key = entry.getField();
            aggBuilder.minDocCount(terms.getMinDocCount());  
 * this file be licensed under the Apache-2.0 license or a
        TermsAggregationFields terms = proto.getTerms();  
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverter;  
            case TERMS_AGGREGATION_EXECUTION_HINT_MAP -> "map";  
     */
        if (terms.hasShowTermDocCountError()) {  
import org.opensearch.protobufs.TermsExclude;
            }
        return AggregationContainer.AggregationContainerCase.TERMS_AGGREGATION;
            case PARTITION -> new IncludeExclude(include.getPartition().getPartition(), include.getPartition().getNumPartitions());  
            .build();  
        if (terms.hasSize()) {
import org.opensearch.search.aggregations.InternalOrder;
            aggBuilder.collectMode(convertCollectMode(terms.getCollectMode()));
            throw new IllegalStateException("AggregationContainer doesn't have terms aggregation");  
            default -> throw new IllegalArgumentException("Unsupported include type: " + include.getTermsIncludeCase());
            aggBuilder.includeExclude(includeExclude);  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;  
        }
            throw new IllegalArgumentException("Terms fields are not provided, cannot parse");  
    }  
    }
 * SPDX-License-Identifier: Apache-2.0
            IncludeExclude excludeIE = convertExclude(terms.getExclude());
        };
        if (terms.hasExecutionHint()) {
        this.registry = registry;  
import org.opensearch.core.xcontent.XContentParser;  
            .script(terms.hasScript() ? ScriptProtoUtils.parseFromProtoRequest(terms.getScript()) : null)
            }
    /**
    @Override  
        }
            aggBuilder.showTermDocCountError(terms.getShowTermDocCountError());
 */  
        }
        if (terms.hasExclude()) {
            aggBuilder.size(terms.getSize());
/*  
            for (Map.Entry<String, AggregationContainer> entry : proto.getAggregationsMap().entrySet()) {
 * compatible open source license.
            default -> throw new IllegalArgumentException("Unsupported execution hint: " + hint);
    }
        if (!container.hasTermsAggregation()) {
import java.util.Map;
     * @param container the protobuf aggregation container  
            case REGEXP -> new IncludeExclude(include.getRegexp(), null);
     */
        }
        ValuesSourceAggregationProtoUtils.declareFields(aggBuilder, valuesSourceFields, true, true, false);
    public TermsAggregationBuilderConverter() {
    public AggregationBuilder fromProto(String name, AggregationContainer container) {
            case TERMS_AGGREGATION_COLLECT_MODE_DEPTH_FIRST -> SubAggCollectionMode.DEPTH_FIRST;
            default -> throw new IllegalArgumentException("Unsupported collect mode: " + mode);  
    private static IncludeExclude convertInclude(TermsInclude include) {
            case TERMS_AGGREGATION_EXECUTION_HINT_GLOBAL_ORDINALS -> "global_ordinals";
        }
     */  
            aggBuilder.shardSize(terms.getShardSize());
        }  
            .missing(terms.hasMissing() ? FieldValueProtoUtils.fromProto(terms.getMissing(), false) : null)
                yield new IncludeExclude(includeTerms, null);
    public AggregationContainer.AggregationContainerCase getHandledAggregationCase() {
        List<BucketOrder> orders = new ArrayList<>(orderList.size());
        if (terms.hasCollectMode()) {  
import org.opensearch.transport.grpc.proto.request.search.aggregation.support.ValuesSourceAggregationProtoUtils;  
        if (terms.hasShardMinDocCount()) {  
        }  
            aggBuilder.shardMinDocCount(terms.getShardMinDocCount());
        TermsAggregationBuilder aggBuilder = new TermsAggregationBuilder(name);  
 * Converter from proto {@link TermsAggregation} to {@link TermsAggregationBuilder}.
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
/**
                String[] includeTerms = include.getTerms().getStringArrayList().toArray(new String[0]);  
        };
     * See {@link IncludeExclude#parseExclude(XContentParser)}  
        }
     */
            case TERMS_AGGREGATION_EXECUTION_HINT_GLOBAL_ORDINALS_HASH -> "global_ordinals_hash";
            includeExclude = convertInclude(terms.getInclude());
        // sub-aggregations  
        if (!proto.hasTerms()) {
     * Constructs a new TermsAggregationBuilderConverter.  
                aggBuilder.subAggregation(registry.fromProto(entry.getKey(), entry.getValue()));  
     * See {@link TermsAggregatorFactory.ExecutionMode#fromString(String)}
    private static List<BucketOrder> convertOrder(List<SortOrderSingleMap> orderList) {
import org.opensearch.protobufs.TermsAggregation;
        for (SortOrderSingleMap entry : orderList) {  
import org.opensearch.search.aggregations.BucketOrder;  
        }
    }  
        if (includeExclude != null) {
        }
    /**
        return switch (mode) {  
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverterRegistry;
    @Override  
        };
import org.opensearch.search.aggregations.AggregationBuilder;
     * @return the constructed {@link TermsAggregationBuilder}
    private static SubAggCollectionMode convertCollectMode(TermsAggregationCollectMode mode) {
        if (terms.hasShardSize()) {
        return switch (include.getTermsIncludeCase()) {  
        };
import org.opensearch.protobufs.TermsAggregationCollectMode;
            aggBuilder.executionHint(convertExecutionHint(terms.getExecutionHint()));  
            .field(terms.hasField() ? terms.getField() : null)
        }
                String[] excludeTerms = exclude.getTerms().getStringArrayList().toArray(new String[0]);  
import org.opensearch.protobufs.TermsInclude;  
    }  
import java.util.List;
import java.util.ArrayList;  
        if (terms.hasInclude()) {
    }  
            aggBuilder.order(convertOrder(terms.getOrderList()));
        // Default constructor  
    @Override
            boolean asc = entry.getSortOrder() == SortOrder.SORT_ORDER_ASC;
    }
        // common fields for ValuesSourceAggregation
    private static String convertExecutionHint(TermsAggregationExecutionHint hint) {
        return orders;
import org.opensearch.protobufs.SortOrderSingleMap;  
    private AggregationBuilderProtoConverterRegistry registry;  
        if (terms.hasMinDocCount()) {
import org.opensearch.search.aggregations.bucket.terms.TermsAggregatorFactory;
    /**
            .format(terms.hasFormat() ? terms.getFormat() : null)
        IncludeExclude includeExclude = null;  
        TermsAggregation proto = container.getTermsAggregation();
        if (terms.getOrderCount() > 0) {
