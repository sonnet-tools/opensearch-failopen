     * Creates aggregation metadata.  
 * aggregation's {@code size}, {@code min_doc_count}, and order are baked into the plan as  
    public List<BucketOrder> getBucketOrders() {
 * SPDX-License-Identifier: Apache-2.0
        List<String> aggNamePath,  
        this.groupByFieldNames = List.copyOf(groupByFieldNames);
     */  
     * @param aggregateCalls Calcite aggregate calls (AVG, SUM, etc.)  
     *        the global no-GROUP-BY metrics plan  
    /**
        this.bucketOrders = List.copyOf(bucketOrders);
 * global no-GROUP-BY plan.
        Integer perParentFetch,
     * @param missingValues null-substitution value per group field ({@code missing} parameter);
    private final List<AggregateCall> aggregateCalls;  
        this.aggregateCalls = List.copyOf(aggregateCalls);
     */
    ) {
     */
    public Integer getPerParentFetch() {
 * back to the request tree.
import java.util.List;
 * The OpenSearch Contributors require contributions made to  
public class AggregationMetadata {
     *        parent partition), or null
    }
    /** Returns the aggregate calls. */
    /**  
    private final Integer fetch;  
        this.missingValues = Map.copyOf(missingValues);
/*  
     * sides build the identical key.
     * @param aggNamePath the defining aggregation-name path (outer bucket first); empty for
    /**
    private final Integer perParentFetch;
 * LIMIT, HAVING, and SORT. Two sibling aggregations over the same field therefore produce two
 * plans — one per aggregation — each bounded and ordered for its own request parameters.
    /**
     * @param bucketOrders bucket orders for post-aggregation sorting
        List<AggregateCall> aggregateCalls,  
        Long havingMinDocCount,
        return perParentFetch;
     * aggregate and the sort, or null when no filtering is needed ({@code min_doc_count} ≤ 1).
import org.apache.calcite.util.ImmutableBitSet;
import java.util.Map;  
 *
     * Group fields absent from this map exclude null keys via a pre-aggregate  
     * matching-document total ({@code COUNT(*)}): a {@code missing} value on the group field  
     * Canonical string form of an aggregation-name path (see {@link #getAggNamePath()}): names
        return aggNamePath;  
     * no-GROUP-BY metrics plan. This is the plan's identity: sibling aggregations over the
     *        for none
    private final List<String> aggregateFieldNames;
    private final List<String> groupByFieldNames;
    }  
     * @param groupByBitSet column indices for GROUP BY
 * this file be licensed under the Apache-2.0 license or a
    /** Returns the GROUP BY field names. */  
        this.aggregateFieldNames = List.copyOf(aggregateFieldNames);  
     *
        this.aggNamePath = List.copyOf(aggNamePath);
 * siblings by DSL contract), which is also the key the response builder uses to match results
     * @param aggNamePath aggregation names, outer bucket first  
     * {@code min_doc_count} HAVING — the threshold drops whole groups from eligibility even with
    /**
        return aggregateFieldNames;  
     * @param fetch plan-level row limit, or null for no limit  
        return String.join(PATH_SEPARATOR, aggNamePath);
    public List<String> getGroupByFieldNames() {
     * {@code missing} — or when no {@code missing} value is configured; those plans use a  
 */  
     *        fields absent from the map get an {@code IS NOT NULL} filter instead  
 * <p>Identity is the {@link #getAggNamePath() aggregation-name path} (names are unique among  
    /**
        this.groupByBitSet = groupByBitSet;  
    public List<AggregateCall> getAggregateCalls() {  
import org.apache.calcite.rel.core.AggregateCall;
     * plan semi-joined to the parent plan's top-N — or null for non-nested plans. Each  
     * Returns the defining aggregation-name path, outer bucket first (e.g.  
     * Returns the null-substitution value per group field (the {@code missing} parameter).
     * Returns the per-parent row limit for a nested level's plan — enforced by
 * <p>A plan is defined by its bucket aggregation, not merely its GROUP BY columns: the
     * @param havingMinDocCount minimum bucket doc count for a plan-level HAVING filter, or null  
     * @param aggregateFieldNames output names for aggregate results
    }
     * makes every query-matching document eligible. False when the plan carries a
    /** Returns the GROUP BY column indices. */
    /** Returns true if bucket orders are present. */
        this.fetch = fetch;
    }  
     * Returns the minimum bucket doc count to apply as a plan-level HAVING filter between the  
package org.opensearch.dsl.aggregation;
     * {@code IS NOT NULL} filter instead.
        return groupByFieldNames;
     */
     * in nesting order, NUL-joined. This is the one key protocol shared by plan construction,
 */  
     * set (root-level, single-field by eligibility).
    }
    public Integer getFetch() {
    private final List<String> aggNamePath;  
     * @param perParentFetch per-parent row limit for nested levels (ROW_NUMBER window over the
    public boolean hasBucketOrders() {  
        return bucketOrders;
    private final ImmutableBitSet groupByBitSet;
     * Returns true when this bounded plan's eligible-doc count is the plain
    /** Returns the output field names for aggregate results. */
     * per-aggregation eligible count instead. Meaningful only for plans with {@link #getFetch()}
     * {@code [by_brand, by_category]} for a nested terms tree). Empty for the global
        Map<String, Object> missingValues  
    }
        return groupByBitSet;  
        Integer fetch,  
 *
     * Returns the plan-level row limit, or null when the plan's bound is per-parent
    /** Returns the bucket orders for post-aggregation sorting. */  
     * surviving row also carries the parent's eligible-document total for
    public Map<String, Object> getMissingValues() {  
        return missingValues;
     * @param groupByFieldNames field names for GROUP BY columns
        return aggregateCalls;
        return !bucketOrders.isEmpty();
     * ({@link #getPerParentFetch()}) or absent. Root-level sized bucket plans carry this limit.  
     *
        ImmutableBitSet groupByBitSet,
    }
    }  
    }
    /**  
     */
 * Metrics ride in their enclosing bucket aggregation's plan; root-level metrics form one  
    }  
        return fetch;  
    /**
     */
 *
    public ImmutableBitSet getGroupByBitSet() {
    public static String pathKey(List<String> aggNamePath) {  
     */
import org.opensearch.search.aggregations.BucketOrder;  
    }
    public List<String> getAggregateFieldNames() {
        this.perParentFetch = perParentFetch;  
 * compatible open source license.
    }
/**
     * {@code ROW_NUMBER() OVER (PARTITION BY parentFields ORDER BY bucketOrder) <= K} with the
    /** NUL cannot appear in aggregation names, so joined path keys cannot collide. */  
        return havingMinDocCount == null && !groupByFieldNames.isEmpty() && missingValues.containsKey(groupByFieldNames.get(0));
        this.havingMinDocCount = havingMinDocCount;
    }
     * {@code sum_other_doc_count}.
}
    public Long getHavingMinDocCount() {  
     * same fields have distinct paths and distinct plans.  
     * result registration, and response-side lookup — a plan's results are found only if all  
 * Pre-computed metadata for one aggregation plan.  
        List<String> aggregateFieldNames,
    private final Long havingMinDocCount;
    public boolean eligibleDocCountIsTotal() {
        List<String> groupByFieldNames,
    public List<String> getAggNamePath() {
     * @return the joined key
    private final Map<String, Object> missingValues;  
    }  
        return havingMinDocCount;
        List<BucketOrder> bucketOrders,
    public AggregationMetadata(
    private final List<BucketOrder> bucketOrders;
    private static final String PATH_SEPARATOR = "\u0000";
     */  
