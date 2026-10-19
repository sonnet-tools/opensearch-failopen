     */
            }
    /** One step of the accumulated nesting path: the aggregation name and its grouping. */
import org.opensearch.dsl.converter.ConversionException;  
 * this file be licensed under the Apache-2.0 license or a
     *
        AggregationMetadataBuilder builder = getOrCreateBuilder(currentPath, plans);
                throw new ConversionException("No translator registered for aggregation type: " + aggBuilder.getClass().getSimpleName());  
        List<PathStep> accumulatedPath = new ArrayList<>(currentPath);
        BucketTranslator<AggregationBuilder> translator,  
    }
    ) throws ConversionException {
            if (type == null) {
     *
                handleBucket((BucketTranslator<AggregationBuilder>) type, aggBuilder, currentPath, plans, rowType);
        Collection<AggregationBuilder> aggs,  
            return existing;
        RelDataType rowType  
    public AggregationTreeWalker(AggregationRegistry registry) {
    private void handleMetric(
            builder.setBucketDefinition(translator.getBucketOrder(aggBuilder), sized.size(aggBuilder), sized.minDocCount(aggBuilder));  
import java.util.ArrayList;  
 * Recursively walks the DSL aggregation tree and produces one {@link AggregationMetadata}
    private final AggregationRegistry registry;  
        }  
    }
 * separate plans rather than sharing one that cannot satisfy both. Metrics ride in their
 * enclosing bucket aggregation's plan; root-level metrics share one global no-GROUP-BY plan.
        return builder;
     *         built plan and depends on this order.
    }
package org.opensearch.dsl.aggregation;
import org.opensearch.search.aggregations.AggregationBuilder;
            if (builder.hasAggregateCalls()) {  
     * @param rowType the input row type for field resolution
     * @throws ConversionException if any aggregation fails to convert  
        return AggregationMetadata.pathKey(path.stream().map(PathStep::aggName).toList());
 * compatible open source license.
        if (translator instanceof SizedBucketTranslator<AggregationBuilder> sized) {
        }
    private static String pathKey(List<PathStep> path) {
        Map<String, AggregationMetadataBuilder> plans,
            // Reject unsupported parameters before any plan state accumulates.
        List<PathStep> currentPath,
            AggregationTranslator<?> type = registry.get(aggBuilder.getClass());  
    }
 * SPDX-License-Identifier: Apache-2.0
 * <p>Plans are per bucket aggregation, keyed by the aggregation-name path (unique among
import java.util.LinkedHashMap;
    ) throws ConversionException {
            } else {
     * @param aggs the top-level aggregation builders  
        String key = pathKey(path);
import org.opensearch.dsl.aggregation.bucket.BucketTranslator;  
        for (AggregationMetadataBuilder builder : plans.values()) {
    }  
    @SuppressWarnings("unchecked")
        List<AggregationMetadata> result = new ArrayList<>();
     * Walks the aggregation tree and returns one AggregationMetadata per plan.
            builder.setBucketDefinition(translator.getBucketOrder(aggBuilder), null, null);  
        }
        for (AggregationBuilder aggBuilder : aggs) {
import java.util.Map;
        plans.put(key, builder);  
        }
            walkRecursive(subAggs, accumulatedPath, plans, rowType);  
}
        AggregationMetadataBuilder builder = new AggregationMetadataBuilder(aggNamePath);
 *
        builder.addAggregateCall(translator.toAggregateCall(aggBuilder, rowType), translator.getAggregateFieldName(aggBuilder));  
 *  
        Map<String, AggregationMetadataBuilder> plans,  
            builder.addGrouping(step.grouping());
     *         plan always precedes its children — nested plan construction consumes the parent's
    }
        List<PathStep> currentPath,
        if (!path.isEmpty()) {  
    private AggregationMetadataBuilder getOrCreateBuilder(List<PathStep> path, Map<String, AggregationMetadataBuilder> plans) {  
import org.apache.calcite.rel.type.RelDataTypeFactory;
        accumulatedPath.add(new PathStep(aggBuilder.getName(), grouping));  
public class AggregationTreeWalker {
        List<PathStep> currentPath,
        List<String> aggNamePath = path.stream().map(PathStep::aggName).toList();
    private void walkRecursive(
/*  
        // contract, so the path key cannot collide with another plan's.  
        }
    public List<AggregationMetadata> walk(Collection<AggregationBuilder> aggs, RelDataType rowType, RelDataTypeFactory typeFactory)
import java.util.Collection;
        if (subAggs != null && !subAggs.isEmpty()) {
        // Every bucket aggregation defines its own plan; sibling names are unique by DSL
            } else if (type instanceof MetricTranslator) {  
        throws ConversionException {  
            }
        for (PathStep step : path) {  
    }  
            if (type instanceof BucketTranslator) {
 */  
 */  
 * per plan.
        RelDataType rowType
import org.opensearch.dsl.aggregation.metric.MetricTranslator;
        MetricTranslator<AggregationBuilder> translator,
import org.opensearch.dsl.aggregation.bucket.SizedBucketTranslator;
        }
     */  
        RelDataType rowType  
import java.util.List;  
     * @param typeFactory the type factory for creating aggregate return types
        GroupingInfo grouping = translator.getGrouping(aggBuilder);  
 * {@code min_doc_count}, and order, so sibling aggregations over the same field produce  
    private record PathStep(String aggName, GroupingInfo grouping) {  
        AggregationMetadataBuilder existing = plans.get(key);
        this.registry = registry;
            }
 * The OpenSearch Contributors require contributions made to  
    ) throws ConversionException {
    /**
        } else {
import org.apache.calcite.rel.type.RelDataType;
        AggregationBuilder aggBuilder,
        }
                throw new ConversionException("Unsupported aggregation translator kind: " + type.getClass().getSimpleName());  
    }  
/**  
        if (existing != null) {  
        Map<String, AggregationMetadataBuilder> plans,
        return result;
        Map<String, AggregationMetadataBuilder> plans = new LinkedHashMap<>();
        AggregationBuilder aggBuilder,  
     * @param registry the aggregation registry for looking up translators
     * @return metadata list, one per plan (only plans with metrics or implicit count). A parent  
        Collection<AggregationBuilder> subAggs = translator.getSubAggregations(aggBuilder);
    /**  
            ((AggregationTranslator<AggregationBuilder>) type).validate(aggBuilder);  
            // Base-contract bucket types return their full bucket set; the plan stays unbounded.
            builder.requestImplicitCount();
        // Recurse into sub-aggregations  
    private void handleBucket(
                result.add(builder.build(rowType, typeFactory));
        AggregationMetadataBuilder builder = getOrCreateBuilder(accumulatedPath, plans);
                handleMetric((MetricTranslator<AggregationBuilder>) type, aggBuilder, currentPath, plans, rowType);
     * Creates a tree walker.  
        walkRecursive(aggs, new ArrayList<>(), plans, rowType);
 * siblings by DSL contract): each bucket aggregation's plan bakes in its own {@code size},
