     * same fields have distinct paths and distinct plans.
 * this file be licensed under the Apache-2.0 license or a
     * Returns true when this bounded plan's eligible-doc count is the plain
     * {@code sum_other_doc_count}.
     *        for none
 */
    private final List<String> aggNamePath;
     * {@code min_doc_count} HAVING — the threshold drops whole groups from eligibility even with
    }
 * SPDX-License-Identifier: Apache-2.0
        return aggNamePath;
     * @param aggregateFieldNames output names for aggregate results
     * @return the joined key
     * @param aggregateCalls Calcite aggregate calls (AVG, SUM, etc.)
        this.fetch = fetch;
     * makes every query-matching document eligible. False when the plan carries a
     * @param aggNamePath aggregation names, outer bucket first
     *
    public Long getHavingMinDocCount() {
import org.opensearch.search.aggregations.BucketOrder;
    public List<String> getAggregateFieldNames() {
        return groupByFieldNames;
        return groupByBitSet;
     * aggregate and the sort, or null when no filtering is needed ({@code min_doc_count} ≤ 1).
 *
import org.apache.calcite.util.ImmutableBitSet;
     * {@code IS NOT NULL} filter instead.
        return String.join(PATH_SEPARATOR, aggNamePath);
    public List<String> getGroupByFieldNames() {
    }
        List<String> aggNamePath,
        this.aggregateFieldNames = List.copyOf(aggregateFieldNames);
    }
        List<BucketOrder> bucketOrders,
    /** Returns true if bucket orders are present. */
     */
     * plan semi-joined to the parent plan's top-N — or null for non-nested plans. Each
     * @param groupByBitSet column indices for GROUP BY
    }
 */
 * aggregation's {@code size}, {@code min_doc_count}, and order are baked into the plan as
    /**
    }
import java.util.Map;
    private final ImmutableBitSet groupByBitSet;
 * <p>Identity is the {@link #getAggNamePath() aggregation-name path} (names are unique among
 * global no-GROUP-BY plan.
    /** Returns the GROUP BY column indices. */
    public static String pathKey(List<String> aggNamePath) {
import java.util.List;
        ImmutableBitSet groupByBitSet,
        this.groupByBitSet = groupByBitSet;
     * @param missingValues null-substitution value per group field ({@code missing} parameter);
import org.apache.calcite.rel.core.AggregateCall;
     * @param aggNamePath the defining aggregation-name path (outer bucket first); empty for
     *        parent partition), or null
/**
    public ImmutableBitSet getGroupByBitSet() {
        Long havingMinDocCount,
     * {@code [by_brand, by_category]} for a nested terms tree). Empty for the global
    }
    /** Returns the bucket orders for post-aggregation sorting. */
    public AggregationMetadata(
        return havingMinDocCount;
    private final List<AggregateCall> aggregateCalls;
     */
     * @param bucketOrders bucket orders for post-aggregation sorting
    private final Integer perParentFetch;
 * <p>A plan is defined by its bucket aggregation, not merely its GROUP BY columns: the
     * @param havingMinDocCount minimum bucket doc count for a plan-level HAVING filter, or null
        return bucketOrders;
    private static final String PATH_SEPARATOR = "\u0000";
     * no-GROUP-BY metrics plan. This is the plan's identity: sibling aggregations over the
        this.perParentFetch = perParentFetch;
    }
     * @param fetch plan-level row limit, or null for no limit
     * Canonical string form of an aggregation-name path (see {@link #getAggNamePath()}): names
     * surviving row also carries the parent's eligible-document total for
    public List<AggregateCall> getAggregateCalls() {
        return !bucketOrders.isEmpty();
     * per-aggregation eligible count instead. Meaningful only for plans with {@link #getFetch()}
    /**
    }
     */
    private final List<String> aggregateFieldNames;
     * Returns the defining aggregation-name path, outer bucket first (e.g.
        this.havingMinDocCount = havingMinDocCount;
     * set (root-level, single-field by eligibility).
        this.aggregateCalls = List.copyOf(aggregateCalls);
    }
    /**
package org.opensearch.dsl.aggregation;
        Map<String, Object> missingValues
    public Integer getFetch() {
        return aggregateCalls;
    public Integer getPerParentFetch() {
     */
     * sides build the identical key.
 * compatible open source license.
     * Returns the minimum bucket doc count to apply as a plan-level HAVING filter between the
     * Returns the null-substitution value per group field (the {@code missing} parameter).
 * Pre-computed metadata for one aggregation plan.
        return fetch;
    /**
    public Map<String, Object> getMissingValues() {
        return perParentFetch;
/*
    }
     */
     * result registration, and response-side lookup — a plan's results are found only if all
}
public class AggregationMetadata {
        this.missingValues = Map.copyOf(missingValues);
     * @param perParentFetch per-parent row limit for nested levels (ROW_NUMBER window over the
 * Metrics ride in their enclosing bucket aggregation's plan; root-level metrics form one
 * siblings by DSL contract), which is also the key the response builder uses to match results
 *
     * {@code ROW_NUMBER() OVER (PARTITION BY parentFields ORDER BY bucketOrder) <= K} with the
    public List<BucketOrder> getBucketOrders() {
    private final Long havingMinDocCount;
    /** Returns the GROUP BY field names. */
 * plans — one per aggregation — each bounded and ordered for its own request parameters.
    private final List<String> groupByFieldNames;
    /** Returns the aggregate calls. */
    /**
    private final Map<String, Object> missingValues;
     * matching-document total ({@code COUNT(*)}): a {@code missing} value on the group field
    /** Returns the output field names for aggregate results. */
     */
     */
    }
 * back to the request tree.
     * Returns the per-parent row limit for a nested level's plan — enforced by
 *
     * Returns the plan-level row limit, or null when the plan's bound is per-parent
 * LIMIT, HAVING, and SORT. Two sibling aggregations over the same field therefore produce two
     *        fields absent from the map get an {@code IS NOT NULL} filter instead
    /**
        return missingValues;
     * Creates aggregation metadata.
        return aggregateFieldNames;
    }
 * The OpenSearch Contributors require contributions made to
    public boolean eligibleDocCountIsTotal() {
    public List<String> getAggNamePath() {
     * ({@link #getPerParentFetch()}) or absent. Root-level sized bucket plans carry this limit.
    /**
        Integer perParentFetch,
     * {@code missing} — or when no {@code missing} value is configured; those plans use a
     * in nesting order, NUL-joined. This is the one key protocol shared by plan construction,
    }
        this.bucketOrders = List.copyOf(bucketOrders);
        this.groupByFieldNames = List.copyOf(groupByFieldNames);
     * @param groupByFieldNames field names for GROUP BY columns
     */
    /**
        List<String> groupByFieldNames,
        List<AggregateCall> aggregateCalls,
        this.aggNamePath = List.copyOf(aggNamePath);
        List<String> aggregateFieldNames,
    /** NUL cannot appear in aggregation names, so joined path keys cannot collide. */
     *
    private final Integer fetch;
    }
     * Group fields absent from this map exclude null keys via a pre-aggregate
        return havingMinDocCount == null && !groupByFieldNames.isEmpty() && missingValues.containsKey(groupByFieldNames.get(0));
    private final List<BucketOrder> bucketOrders;
    ) {
        Integer fetch,
     *        the global no-GROUP-BY metrics plan
    public boolean hasBucketOrders() {
