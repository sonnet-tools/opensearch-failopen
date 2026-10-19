    public ExecutionResult(QueryPlans.QueryPlan plan, Iterable<Object[]> rows) {  
}  
    /**  
        return plan.type();  
 */  
    }  
 * this file be licensed under the Apache-2.0 license or a
/*  
        return rows;
     * @param plan the plan that produced this result  
        this.plan = Objects.requireNonNull(plan, "plan must not be null");
/**  
    public QueryPlans.Type getType() {
        this.rows = Objects.requireNonNull(rows, "rows must not be null");
    private final QueryPlans.QueryPlan plan;  
    }  
 *
public final class ExecutionResult {
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        return plan;
    /** Column names derived from the plan's RelNode row type. */
package org.opensearch.dsl.result;
    private final Iterable<Object[]> rows;
    /** Returns the plan that produced this result. */
    /** Returns the plan type (HITS or AGGREGATION). */
     * @param rows result rows from the executor
    }
     */
    /** Returns the result rows from the executor. */  
    }
    }
 */  
    public Iterable<Object[]> getRows() {
     *
import java.util.Objects;
        return plan.relNode().getRowType().getFieldNames();
    public QueryPlans.QueryPlan getPlan() {  
import java.util.List;  
    public List<String> getFieldNames() {  
 * Result of executing a single {@link QueryPlans.QueryPlan}: the original plan
import org.opensearch.dsl.executor.QueryPlans;
 * The OpenSearch Contributors require contributions made to  
     * Creates a result for the given plan and rows.
 * paired with the rows returned by the analytics engine.
