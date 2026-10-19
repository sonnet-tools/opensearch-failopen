    }  
import org.opensearch.search.aggregations.BucketOrder;  
 * SPDX-License-Identifier: Apache-2.0
    private static OrderTarget resolveMetricOrder(InternalOrder.Aggregation aggOrder) {
        } else if (InternalOrder.isKeyOrder(order)) {
            }  
                keyIndices.add(idx);
import org.apache.calcite.rel.type.RelDataTypeField;  
 * All field lookups are name-based against the real {@link RelDataType} —  
    private static Map<String, List<Integer>> buildPostAggFieldIndex(AggregationMetadata metadata, RelDataType postAggRowType) {
 * The OpenSearch Contributors require contributions made to  
        return collations;
 * this file be licensed under the Apache-2.0 license or a
     * Resolves bucket orders to field collations using the actual post-agg schema.
        List<Integer> indices = postAggFieldIndex.get(target.fieldName);  
    private static OrderTarget resolveKeyOrder(BucketOrder order) {
    }
    /**
        }
            resolveOrder(order, postAggFieldIndex, collations);
 * the actual post-aggregation schema from the {@code LogicalAggregate} node.
import org.opensearch.search.aggregations.InternalOrder;
    // InternalOrder.Aggregation.order is private with no accessor; equality check is the only way  
        }
        String fieldName = aggOrder.path().toString();
            nameToIndex.put(fields.get(i).getName(), i);
        // Look up the field's post-agg schema index(es); _key may resolve to multiple indices
     */
            Integer idx = nameToIndex.get(groupByName);
            ? RelFieldCollation.Direction.ASCENDING
    }
     * @param postAggRowType the actual row type of the LogicalAggregate node
            ? RelFieldCollation.NullDirection.LAST
        for (String aggName : metadata.getAggregateFieldNames()) {
        for (int i = 0; i < fields.size(); i++) {
     * differ from the schema position order. For example, terms(brand) → terms(name) produces
     * @return list of field collations for LogicalSort  
        List<RelFieldCollation> collations = new ArrayList<>();  
        // _key → each GROUP BY field in accumulation order (outer bucket first)
import java.util.ArrayList;  
    private record OrderTarget(String fieldName, boolean ascending) {
        OrderTarget target = resolveOrderTarget(order);  
            if (idx != null) {
import org.opensearch.dsl.aggregation.AggregationMetadataBuilder;
     * schema [name(0), brand(1), ...] but _key indices [brand(1), name(0)] (outer first).  
}
    }
            map.put(AggregationMetadataBuilder.IMPLICIT_COUNT_NAME, List.of(countIdx));  
            throw new ConversionException("Sort field '" + target.fieldName + "' not found. Available: " + postAggFieldIndex.keySet());
 */  
                map.put(aggName, List.of(idx));
import org.opensearch.dsl.aggregation.AggregationMetadata;
        if (countIdx != null) {
        Integer countIdx = nameToIndex.get(AggregationMetadataBuilder.IMPLICIT_COUNT_NAME);
     * <p>_key indices follow the tree walker's accumulation order (outer bucket first), which may
        }  
     */
 * zero positional assumptions about the output schema layout.
     *  
            return resolveCountOrder(order);
     */
        // Determine which field to sort on and in which direction
            Integer idx = nameToIndex.get(aggName);  
     * <p>Post-agg schema ordering: GROUP BY fields first (ordered by ImmutableBitSet, i.e. input
    }
     * @param metadata the aggregation metadata containing bucket orders and field name lists
 * Resolves {@link BucketOrder} objects to Calcite {@link RelFieldCollation} using  
        List<Integer> keyIndices = new ArrayList<>();  
        RelFieldCollation.Direction direction = target.ascending  
 *
    private CollationResolver() {}
 */
            return resolveMetricOrder(aggOrder);  
/**
 *
        map.put("_key", keyIndices);
     * Builds a map from sort field names to their indices in the post-aggregation schema.
        // Create a collation per index (one for most fields, multiple for _key with nested GROUP BY)
        }  
    }  
        List<RelDataTypeField> fields = postAggRowType.getFieldList();
        // _count  
            if (idx != null) {  
    private static void resolveOrder(BucketOrder order, Map<String, List<Integer>> postAggFieldIndex, List<RelFieldCollation> collations)  
    public static List<RelFieldCollation> resolve(AggregationMetadata metadata, RelDataType postAggRowType) throws ConversionException {  
    /** Resolved field name and sort direction from a BucketOrder. */
        boolean ascending = aggOrder.equals(BucketOrder.aggregation(fieldName, true));  
     * CompoundOrders are never seen here — they are flattened by AggregationMetadataBuilder.addBucketOrder.
        Map<String, Integer> nameToIndex = new HashMap<>();  
        Map<String, List<Integer>> postAggFieldIndex = buildPostAggFieldIndex(metadata, postAggRowType);
        }
package org.opensearch.dsl.converter;
        } else if (InternalOrder.isCountDesc(order) || order.equals(BucketOrder.count(true))) {  
import java.util.List;
import org.apache.calcite.rel.type.RelDataType;
        throws ConversionException {
        return new OrderTarget("_count", !InternalOrder.isCountDesc(order));
        }
        for (String groupByName : metadata.getGroupByFieldNames()) {
     * column index), then aggregate calls in the order they were added to the builder.
    /**
        RelFieldCollation.NullDirection nullDirection = target.ascending  
    }
    /**
    private static OrderTarget resolveOrderTarget(BucketOrder order) throws ConversionException {
            : RelFieldCollation.Direction.DESCENDING;
public final class CollationResolver {  
        // Map direction: ASC nulls last, DESC nulls first (matches OpenSearch default)
        // Metric fields
        }  
        }
        return new OrderTarget(fieldName, ascending);
            collations.add(new RelFieldCollation(idx, direction, nullDirection));  
        Map<String, List<Integer>> map = new HashMap<>();  
     *  
        if (indices == null) {
        if (order instanceof InternalOrder.Aggregation aggOrder) {
 * compatible open source license.
    // no InternalOrder.isCountAsc() helper; count desc is checked via isCountDesc(), count asc via equality
     * @throws ConversionException if a sort field cannot be resolved
        throw new ConversionException("Unsupported BucketOrder type: " + order.getClass().getName());  
     *  
import java.util.HashMap;
            : RelFieldCollation.NullDirection.FIRST;
     * Maps a single BucketOrder to one or more RelFieldCollations.  
import java.util.Map;  
import org.apache.calcite.rel.RelFieldCollation;
/*  
    }
    private static OrderTarget resolveCountOrder(BucketOrder order) {  
        for (BucketOrder order : metadata.getBucketOrders()) {
                map.put(groupByName, List.of(idx));
            }  
        return map;  
        for (int idx : indices) {
            return resolveKeyOrder(order);
        return new OrderTarget("_key", InternalOrder.isKeyAsc(order));
