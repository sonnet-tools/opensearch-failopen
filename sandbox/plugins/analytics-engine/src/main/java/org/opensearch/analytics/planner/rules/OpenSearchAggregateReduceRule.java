 * <p><b>Order</b>: this rule operates on plain {@link LogicalAggregate} so it fires  
 * STDDEV/VAR additionally emit {@code MULTIPLY} (for {@code x*x}) and  
import java.util.EnumSet;
        SqlKind.VAR_SAMP  
 *
 * this file be licensed under the Apache-2.0 license or a
 * so the post-reduction Project flows through capability resolution cleanly. All
/*  
package org.opensearch.analytics.planner.rules;
 * guard. Every operator emitted by the reduction (MULTIPLY, POWER, DIVIDE, CAST,  
 *  
/**  
}  
 * natural primitive return types (BIGINT for SUM of integer, not AVG's carry-over DOUBLE).
 * primitive aggregate calls, and the Volcano split rule downstream operates on those
 * CASE, comparisons) is declared as a scalar capability by the DataFusion backend,
 * primitives.
    public OpenSearchAggregateReduceRule() {  
 * SPDX-License-Identifier: Apache-2.0
 * {@code CASE WHEN count > 1 THEN sqrt(variance) ELSE NULL END} Bessel's-correction
        super(LogicalAggregate.class, RelBuilder.proto(Contexts.empty()), FUNCTIONS_TO_REDUCE);
 * org.opensearch.analytics.planner.rel.OpenSearchAggregate} with correctly-typed  
 */  
 * Calcite's tested decomposition for multi-field statistical aggregates (AVG, STDDEV_POP,
 * {@code POWER(variance, 0.5)} (sqrt). The {@code SAMP} variants also emit a
 *
import org.apache.calcite.rel.rules.AggregateReduceFunctionsRule;  
 * compatible open source license.
import org.apache.calcite.rel.logical.LogicalAggregate;
    }
 */
 * logic inside our resolver.
 * The OpenSearch Contributors require contributions made to  
 * {@code STDDEV_SAMP}/{@code VAR_SAMP}. AVG reduces to SUM/COUNT/DIVIDE/CAST.
 *
import org.apache.calcite.plan.Contexts;
 * The marking rule then converts the already-reduced plan to {@link
 * un-marked plan keeps Calcite's type inference clean — the reduce rule sees an aggregate
        SqlKind.STDDEV_SAMP,
 * <em>before</em> {@link OpenSearchAggregateRule} marks the aggregate. Running on the
 * @opensearch.internal  
        SqlKind.AVG,
    private static final EnumSet<SqlKind> FUNCTIONS_TO_REDUCE = EnumSet.of(
 * emitted aggregates are SUM/COUNT primitives that the resolver decomposes through  
 * whose {@code aggCall.rexList} is empty, so the reduced SUM/COUNT calls get their  
import org.apache.calcite.sql.SqlKind;
        SqlKind.STDDEV_POP,  
        SqlKind.VAR_POP,
import org.apache.calcite.tools.RelBuilder;
 * OpenSearch-aware configuration of Calcite's {@link AggregateReduceFunctionsRule}. Reuses
 * STDDEV_SAMP, VAR_POP, VAR_SAMP) instead of hand-rolling the same primitive-reduction  
public class OpenSearchAggregateReduceRule extends AggregateReduceFunctionsRule {
    );
 * <p><b>Reduction set</b>: {@code AVG} + {@code STDDEV_POP}/{@code VAR_POP} +
 * the standard single-field path.
