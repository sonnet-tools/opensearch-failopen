        }
     * shape — a flat LIMIT there would keep globally-top groups, not each parent's top K.
     *
 * compatible open source license.
        this(List.of());
    private final Map<String, Object> missingValues = new LinkedHashMap<>();
        aggregateCalls.add(call);
     * @throws ConversionException if field resolution fails
        List<Integer> indices = new ArrayList<>(fieldNames.size());
        List<String> allGroupFieldNames = new ArrayList<>();
        // Resolve grouping indices at build time
     * Adds a bucket order for post-aggregation sorting.
                    )
    private static List<Integer> resolveFieldIndices(GroupingInfo grouping, RelDataType inputRowType) throws ConversionException {
    }
        List<String> allFieldNames = new ArrayList<>(aggregateFieldNames);
                        call.isDistinct(),
     *
 * bucket aggregation defines each builder (none for the global metrics builder).
            }
/*
        return new AggregationMetadata(
     * Records the plan parameters of the bucket aggregation that defines this plan: its sort
                    IMPLICIT_COUNT_NAME
        Long havingMinDocCount = definingMinDocCount != null && definingMinDocCount > 1 ? definingMinDocCount : null;
 * to accumulate the defining bucket aggregation's plan parameters, parent groupings, and
     */
            bucketOrders,
     * @param grouping the grouping info
     */
     * render rather than accounting with a wrong total.
                )
     * @throws ConversionException if a field name is not found in the schema
        List<String> fieldNames = grouping.getFieldNames();
     *
        this.definingSize = size;
        }
     */
    /**
 *
                // globally-top groups, not each parent's top K.
                    List.of(),
                fetch = definingSize;
        );
     * @param aggNamePath the defining aggregation-name path, outer bucket first
    }
    /**
        missingValues.putAll(grouping.getMissingByField());
        } else {
     * Requests an implicit COUNT(*) for bucket doc_count.
        // COUNT stays non-nullable (returns 0).
    /**
            ImmutableBitSet.of(allGroupIndices),
     * For no-GROUP-BY metrics, makes return types nullable (AVG of empty set is null).
    }
     * @param typeFactory the type factory for creating types
        for (AggregateCall call : aggregateCalls) {
     * ({@code fetch = size}); nested sized plans (parent groupings present) get a per-parent
     * @param fieldName the output field name
        }
            allGroupFieldNames,
                allCalls.add(call);
import org.apache.calcite.rel.type.RelDataType;
    public void addAggregateCall(AggregateCall call, String fieldName) {
            }
    public void setBucketDefinition(BucketOrder order, Integer size, Long minDocCount) {
    /**
        // For no-GROUP-BY, metric results could be null (e.g., AVG of empty set).
    }
        for (GroupingInfo g : groupings) {
    /** Name used for the implicit COUNT(*) aggregate added by bucket aggregations. */
    private void addBucketOrder(BucketOrder order) {
    }
    public boolean hasAggregateCalls() {
    }
                    false,
                perParentFetch = definingSize;
            allFieldNames.add(IMPLICIT_COUNT_NAME);
                    typeFactory.createSqlType(SqlTypeName.BIGINT),
 * input row type.
                        call.ignoreNulls(),
    private final List<GroupingInfo> groupings = new ArrayList<>();
        boolean singleFieldGroupings = groupings.stream().allMatch(g -> g.getFieldNames().size() == 1);
        }
        aggregateFieldNames.add(fieldName);
 */
    private boolean implicitCountRequested = false;
                    -1,
     */
                        call.getAggregation(),
        this.implicitCountRequested = true;
    public AggregationMetadata build(RelDataType inputRowType, RelDataTypeFactory typeFactory) throws ConversionException {
    public void addGrouping(GroupingInfo grouping) {
    public AggregationMetadataBuilder(List<String> aggNamePath) {
import java.util.LinkedHashMap;
            allGroupFieldNames.addAll(g.getFieldNames());
        for (String name : fieldNames) {
    /**
    }
                        call.filterArg,
            bucketOrders.add(order);
 * this file be licensed under the Apache-2.0 license or a
    private Integer definingSize;
                        call.isApproximate(),
            fetch,
        if (order instanceof InternalOrder.CompoundOrder compound) {
            RelDataTypeField field = inputRowType.getField(name, false, false);
     * <p>Plan bounds, decided here: {@code min_doc_count} above 1 always becomes a HAVING
     * Compound orders are flattened into individual elements.
    private final List<String> aggregateFieldNames = new ArrayList<>();
                    false,
     * @param grouping the grouping info containing field names
    }
 * metric calls during tree traversal. Grouping indices are resolved at build time from the
                    AggregateCall.create(
        if (definingSize != null && singleFieldGroupings) {
    /**
 * Mutable builder for {@link AggregationMetadata}. Used by {@link AggregationTreeWalker}
     */
            if (groupings.size() == 1) {
     * @param size the requested bucket count, or null for base-contract bucket types
import java.util.Map;
import org.opensearch.search.aggregations.BucketOrder;
     *
     */
import org.apache.calcite.rel.type.RelDataTypeField;
import org.opensearch.search.aggregations.InternalOrder;
    private final List<String> aggNamePath;
        }
        List<Integer> allGroupIndices = new ArrayList<>();
import org.apache.calcite.util.ImmutableBitSet;
     * Multi-field groupings get no bound: the eligible-count machinery (count plans,
    private final List<BucketOrder> bucketOrders = new ArrayList<>();
     * bound instead ({@code perParentFetch = size}), enforced by the ROW_NUMBER window plan
                RelDataType nullableType = typeFactory.createTypeWithNullability(call.getType(), true);
    }
        boolean noGroupBy = groupings.isEmpty();
        }
            allGroupIndices.addAll(resolveFieldIndices(g, inputRowType));
        Integer perParentFetch = null;
                        nullableType,
        Integer fetch = null;
    }
import org.opensearch.dsl.converter.ConversionException;
            allFieldNames,
                    false,
            );
     * Called exactly once per builder — each bucket aggregation owns its own plan.
     * Adds an aggregate call with its output field name.
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            }
package org.opensearch.dsl.aggregation;
     */
            if (field == null) {
        return indices;
     * @param order the bucket order
    /** Creates a builder for the global (no defining aggregation) metrics plan. */
 */
import org.apache.calcite.rel.core.AggregateCall;
            indices.add(field.getIndex());
        if (implicitCountRequested) {
            } else {
        // min_doc_count ≤ 1 needs no HAVING: a GROUP BY group has ≥ 1 row by construction.
 * The OpenSearch Contributors require contributions made to
public class AggregationMetadataBuilder {
     * @param call the Calcite aggregate call
            allCalls,
                    RelCollations.EMPTY,
            havingMinDocCount,
 * SPDX-License-Identifier: Apache-2.0
     * @param minDocCount the minimum bucket doc count, or null for base-contract bucket types
        if (order == null) return;
}
                );
     * Builds the immutable metadata. Resolves grouping indices from the input row type.
     */
        groupings.add(grouping);
     * Idempotent — only one COUNT(*) is created at build time.
     * Adds a grouping contribution from a bucket translator. The grouping's per-field
     * @param inputRowType the schema before aggregation
     * Creates a builder for the plan defined by the given aggregation-name path.
     * @return the aggregation metadata
    public void requestImplicitCount() {
    public static final String IMPLICIT_COUNT_NAME = "_count";
                        call.getCollation(),
     * @param inputRowType the schema before aggregation
            allCalls.add(
     * {@code missing} values are accumulated for the plan's null handling.
    public AggregationMetadataBuilder() {
import java.util.List;
import org.apache.calcite.sql.type.SqlTypeName;
                AggregateCall.create(
                    SqlStdOperatorTable.COUNT,
import org.apache.calcite.rel.type.RelDataTypeFactory;
            bucketOrders.addAll(compound.orderElements());
            if (noGroupBy) {
     * filter. Root-level sized plans (a single grouping) get a flat LIMIT
 * <p>One builder exists per aggregation-name path — plans are per aggregation, so exactly one
        return !aggregateCalls.isEmpty() || implicitCountRequested;
    private final List<AggregateCall> aggregateCalls = new ArrayList<>();
     * order plus the {@code size} and {@code min_doc_count} to bake in as LIMIT and HAVING.
     * @return column indices for each field name
    /**
 *
            missingValues
                throw new ConversionException("Group-by field '" + name + "' not found in schema");
        List<AggregateCall> allCalls = new ArrayList<>();
            perParentFetch,
import java.util.ArrayList;
     *
     *
            } else {
        this.aggNamePath = List.copyOf(aggNamePath);
     * @param order the bucket order (flattened like {@link #addBucketOrder})
import org.apache.calcite.rel.RelCollations;
                        call.getName()
    /** Returns true if this builder has at least one aggregate call or implicit count. */
     * Resolves field-based grouping names to column indices in the input schema.
                        call.getArgList(),
            aggNamePath,
                // Nested level: the bound is per parent, not global — a flat LIMIT would keep
     *
                allCalls.add(
        this.definingMinDocCount = minDocCount;
     * {@code COUNT(field)}) is single-field today, and an unbounded plan fails loudly at
    /**
    private Long definingMinDocCount;
        addBucketOrder(order);
/**
     *
