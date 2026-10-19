    private static List<Integer> resolveFieldIndices(GroupingInfo grouping, RelDataType inputRowType) throws ConversionException {  
     * @param size the requested bucket count, or null for base-contract bucket types
        boolean noGroupBy = groupings.isEmpty();  
     * Resolves field-based grouping names to column indices in the input schema.
     * @param typeFactory the type factory for creating types  
                throw new ConversionException("Group-by field '" + name + "' not found in schema");  
                    -1,
    /**
import org.opensearch.search.aggregations.InternalOrder;
                fetch = definingSize;  
            fetch,  
     * filter. Root-level sized plans (a single grouping) get a flat LIMIT  
        Integer fetch = null;
     * @param call the Calcite aggregate call
     * @param inputRowType the schema before aggregation
                    false,
            allCalls,  
        );
}  
     *
    }
 * The OpenSearch Contributors require contributions made to  
     *
            aggNamePath,  
                        call.getAggregation(),
     * @return column indices for each field name  
    public void setBucketDefinition(BucketOrder order, Integer size, Long minDocCount) {
     */
     * order plus the {@code size} and {@code min_doc_count} to bake in as LIMIT and HAVING.  
     * @param inputRowType the schema before aggregation
     */  
                    )
     * Records the plan parameters of the bucket aggregation that defines this plan: its sort
            allCalls.add(
        // COUNT stays non-nullable (returns 0).
            allGroupFieldNames,
                // globally-top groups, not each parent's top K.  
        if (implicitCountRequested) {  
 * metric calls during tree traversal. Grouping indices are resolved at build time from the  
     *
                        nullableType,
     *
    public boolean hasAggregateCalls() {
        }  
     * @param grouping the grouping info  
     * shape — a flat LIMIT there would keep globally-top groups, not each parent's top K.  
     * <p>Plan bounds, decided here: {@code min_doc_count} above 1 always becomes a HAVING
    public void addAggregateCall(AggregateCall call, String fieldName) {
            allGroupFieldNames.addAll(g.getFieldNames());
    /**
        boolean singleFieldGroupings = groupings.stream().allMatch(g -> g.getFieldNames().size() == 1);  
                allCalls.add(
    private final Map<String, Object> missingValues = new LinkedHashMap<>();
     * Adds a grouping contribution from a bucket translator. The grouping's per-field  
                    IMPLICIT_COUNT_NAME
    /** Creates a builder for the global (no defining aggregation) metrics plan. */  
        this.aggNamePath = List.copyOf(aggNamePath);
        }
import org.apache.calcite.rel.type.RelDataTypeField;
    }
     * ({@code fetch = size}); nested sized plans (parent groupings present) get a per-parent
            allFieldNames.add(IMPLICIT_COUNT_NAME);
     */  
 *
                        call.filterArg,  
    /**
        if (order instanceof InternalOrder.CompoundOrder compound) {  
            if (field == null) {
    /**
                );
    public AggregationMetadata build(RelDataType inputRowType, RelDataTypeFactory typeFactory) throws ConversionException {
            }
                    typeFactory.createSqlType(SqlTypeName.BIGINT),
        groupings.add(grouping);  
            }
        List<String> allFieldNames = new ArrayList<>(aggregateFieldNames);
 * bucket aggregation defines each builder (none for the global metrics builder).
    }
            );
        return !aggregateCalls.isEmpty() || implicitCountRequested;
        for (String name : fieldNames) {  
     *  
        addBucketOrder(order);
     * Compound orders are flattened into individual elements.  
     * Builds the immutable metadata. Resolves grouping indices from the input row type.
            if (noGroupBy) {  
                perParentFetch = definingSize;
                        call.getName()  
     * {@code COUNT(field)}) is single-field today, and an unbounded plan fails loudly at
     * Adds an aggregate call with its output field name.  
import org.apache.calcite.rel.type.RelDataType;  
        Long havingMinDocCount = definingMinDocCount != null && definingMinDocCount > 1 ? definingMinDocCount : null;  
        aggregateCalls.add(call);  
import java.util.LinkedHashMap;
     * For no-GROUP-BY metrics, makes return types nullable (AVG of empty set is null).  
    private Long definingMinDocCount;  
        this(List.of());
                    SqlStdOperatorTable.COUNT,  
     * @param grouping the grouping info containing field names
        return indices;
    private Integer definingSize;
     */
 * compatible open source license.
            bucketOrders.add(order);  
            missingValues  
        if (definingSize != null && singleFieldGroupings) {
 */
    private final List<GroupingInfo> groupings = new ArrayList<>();  
 * to accumulate the defining bucket aggregation's plan parameters, parent groupings, and
        Integer perParentFetch = null;
        }  
        this.implicitCountRequested = true;  
     */  
     * Multi-field groupings get no bound: the eligible-count machinery (count plans,
                        call.isDistinct(),
            ImmutableBitSet.of(allGroupIndices),
        } else {
            RelDataTypeField field = inputRowType.getField(name, false, false);
    }
                RelDataType nullableType = typeFactory.createTypeWithNullability(call.getType(), true);
    }
                    List.of(),
 */  
     * bound instead ({@code perParentFetch = size}), enforced by the ROW_NUMBER window plan
                AggregateCall.create(
            bucketOrders,
     * @param fieldName the output field name  
 * SPDX-License-Identifier: Apache-2.0
                    RelCollations.EMPTY,  
     * render rather than accounting with a wrong total.  
                    AggregateCall.create(  
        List<String> fieldNames = grouping.getFieldNames();
     * Creates a builder for the plan defined by the given aggregation-name path.  
    /**
                        call.getCollation(),
    /** Name used for the implicit COUNT(*) aggregate added by bucket aggregations. */
     *
import java.util.ArrayList;
                )  
                        call.ignoreNulls(),
        }  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
                    false,
     * {@code missing} values are accumulated for the plan's null handling.
     *
    private final List<String> aggregateFieldNames = new ArrayList<>();  
     * @return the aggregation metadata
import org.opensearch.dsl.converter.ConversionException;  
        }
    /**
import org.apache.calcite.rel.RelCollations;
 * Mutable builder for {@link AggregationMetadata}. Used by {@link AggregationTreeWalker}
     * @throws ConversionException if field resolution fails
                // Nested level: the bound is per parent, not global — a flat LIMIT would keep
        for (AggregateCall call : aggregateCalls) {
 * this file be licensed under the Apache-2.0 license or a
            }
 *
    }  
    }  
        // Resolve grouping indices at build time
            bucketOrders.addAll(compound.orderElements());
     */  
        if (order == null) return;
        missingValues.putAll(grouping.getMissingByField());
package org.opensearch.dsl.aggregation;
     * @param aggNamePath the defining aggregation-name path, outer bucket first
     * Requests an implicit COUNT(*) for bucket doc_count.
    /** Returns true if this builder has at least one aggregate call or implicit count. */  
 * <p>One builder exists per aggregation-name path — plans are per aggregation, so exactly one  
     *
 * input row type.
    public AggregationMetadataBuilder() {
    public void addGrouping(GroupingInfo grouping) {
        aggregateFieldNames.add(fieldName);
    public AggregationMetadataBuilder(List<String> aggNamePath) {
     * @param order the bucket order (flattened like {@link #addBucketOrder})  
        }  
    /**
                        call.getArgList(),
/**  
        List<Integer> indices = new ArrayList<>(fieldNames.size());
import java.util.Map;
import org.apache.calcite.rel.type.RelDataTypeFactory;
        // For no-GROUP-BY, metric results could be null (e.g., AVG of empty set).
            indices.add(field.getIndex());
                        call.isApproximate(),  
     */
    private boolean implicitCountRequested = false;
            havingMinDocCount,
     */
        List<Integer> allGroupIndices = new ArrayList<>();  
import org.apache.calcite.rel.core.AggregateCall;
     * Called exactly once per builder — each bucket aggregation owns its own plan.
     * @throws ConversionException if a field name is not found in the schema
     * Idempotent — only one COUNT(*) is created at build time.  
        this.definingMinDocCount = minDocCount;
     * @param order the bucket order
import org.apache.calcite.util.ImmutableBitSet;
            } else {
    public void requestImplicitCount() {
    public static final String IMPLICIT_COUNT_NAME = "_count";  
            } else {  
            if (groupings.size() == 1) {
                allCalls.add(call);
    }  
        this.definingSize = size;  
/*  
    private void addBucketOrder(BucketOrder order) {
        for (GroupingInfo g : groupings) {
public class AggregationMetadataBuilder {  
    }
import java.util.List;  
    private final List<String> aggNamePath;
            allFieldNames,
            perParentFetch,
import org.apache.calcite.sql.type.SqlTypeName;
        // min_doc_count ≤ 1 needs no HAVING: a GROUP BY group has ≥ 1 row by construction.
        List<String> allGroupFieldNames = new ArrayList<>();
     * Adds a bucket order for post-aggregation sorting.
    private final List<BucketOrder> bucketOrders = new ArrayList<>();
    }
    private final List<AggregateCall> aggregateCalls = new ArrayList<>();
     * @param minDocCount the minimum bucket doc count, or null for base-contract bucket types
    /**
        List<AggregateCall> allCalls = new ArrayList<>();
import org.opensearch.search.aggregations.BucketOrder;
        return new AggregationMetadata(
                    false,  
            allGroupIndices.addAll(resolveFieldIndices(g, inputRowType));  
