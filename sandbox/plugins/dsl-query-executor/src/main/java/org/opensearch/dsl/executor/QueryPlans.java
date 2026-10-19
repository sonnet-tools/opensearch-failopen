        return plans.stream().filter(p -> p.type() == type).toList();  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.dsl.executor;
    public static final String COUNT_TOTAL_COLUMN = "_total";
         * {@code COUNT(*)}/{@code COUNT(field)} columns, plus one per {@code min_doc_count}  
         * Creates a query plan without aggregation metadata (HITS plans).
    }
        /**
import java.util.Objects;  
            return new QueryPlans(plans);
         * @param aggregationMetadata the source metadata for AGGREGATION plans, or null
         *
        public Builder add(QueryPlan plan) {  
 *
     * A single plan pairing a {@link Type} with a Calcite {@link RelNode}.
        }
import org.apache.calcite.rel.RelNode;
     * {@code COUNT(field)}; for higher thresholds it is the sum of counts over the
import org.opensearch.dsl.aggregation.AggregationMetadata;
            Objects.requireNonNull(relNode, "relNode must not be null");  
    public static class Builder {
         * aggregation whose eligible count needs a HAVING-filtered sum). All execute concurrently
     * @param aggregationMetadata the walker-produced metadata this plan was built from, or  
    public record QueryPlan(Type type, RelNode relNode, AggregationMetadata aggregationMetadata) {
         * @param type what part of the response this plan produces  
         */
     */
     * Returns all plans matching the given type.
        public QueryPlans build() {  
    public enum Type {  
    }
    /** Builder for constructing {@link QueryPlans}. */  
    }  
        return plans.isEmpty() ? Optional.empty() : Optional.of(plans.get(0));  
         * Request totals: single-row aggregates supplying the counts that plan-level LIMITs  
     * names are unique among siblings by DSL contract). For {@code min_doc_count} ≤ 1 this is
         */  
    public Optional<QueryPlan> first() {
        /** Builds the plans */
        public Builder() {}
     *
     */
        public QueryPlan {
    /**  
    public boolean has(Type type) {
        /** Document hits. */
        return plans.stream().anyMatch(p -> p.type() == type);  
    private final List<QueryPlan> plans;
        /**
        private final List<QueryPlan> plans = new ArrayList<>();
        }
        /**  
     *        so granularity matching uses the walker's exact nesting-order group fields instead
    /**
        }
import java.util.List;
     *
    /**  
    }  
    /** Column name of the COUNT plans' {@code COUNT(*)} — total docs matching the query. */
         */
     * Column name prefix of a root sized aggregation's eligible-doc count, the total {@code sum_other_doc_count} is subtracted from:
     *        {@code null} for {@link Type#HITS} plans. Carried through to the response builder
 */  
            this(type, relNode, null);
     * HAVING-filtered groups, delivered by that aggregation's own COUNT plan.  
         * @param plan the plan to add
            Objects.requireNonNull(type, "type must not be null");
        HITS,
        /** Creates a new empty builder. */
         *  
     * @param relNode the Calcite logical plan to execute
 */
    /** Identifies what part of the SearchResponse a plan populates. */
    public List<QueryPlan> get(Type type) {
         *
    }  
     */
         * @param type what part of the response this plan produces  
        this.plans = List.copyOf(plans);
         */  
         * @param relNode the Calcite logical plan to execute
    }
    /** Returns all plans. */
            return this;
 * this file be licensed under the Apache-2.0 license or a
 * One or more query plans produced by DSL to RelNode conversion.
import java.util.Optional;
    /** Returns the first plan produced, or empty when conversion yielded none. */
         * @param relNode the Calcite logical plan to execute
        /**  
     * the documents eligible for its buckets, named {@code _eligible$<aggregationName>} (root  
    private QueryPlans(List<QueryPlan> plans) {
         * with the main plans.
    /**
     * @param type what part of the response this plan produces
        /** Aggregation results. */  
         * eligible-doc counts. A request may carry several COUNT plans (one flat plan for
            plans.add(plan);
     * Returns true if a plan with the given type exists.
     *  
 * compatible open source license.
        COUNT
     * @param type the plan type to look up  
     */
        AGGREGATION,
    }
 * SPDX-License-Identifier: Apache-2.0
        return plans;
     *        of re-deriving them from the plan (which loses nesting order).  
/**  
         * remove from the main plans — {@code hits.total} and the {@code sum_other_doc_count}
public final class QueryPlans {  
    public List<QueryPlan> getAll() {  
import java.util.ArrayList;
        }  
         * Adds a plan.
        public QueryPlan(Type type, RelNode relNode) {  
    public static final String COUNT_ELIGIBLE_COLUMN_PREFIX = "_eligible$";
         * Creates a query plan.
     * @param type the plan type to check  
    }
}
/*  
