import org.apache.calcite.rex.RexBuilder;  
    static WindowFunctionAdapter argMin() {  
     * cleared on the rebuilt RexOver because it's already encoded in the operator name —
                over,  
 *       {@code APPROX_COUNT_DISTINCT(x)}, which the convertor renames to substrait {@code approx_distinct}
            List<RexNode> partitions,
                target,
        @Override  
     * Replaces {@code COUNT(DISTINCT x) OVER(...)} with {@code os_count_distinct(x) OVER(...)}.  
     */
    }
            true,
 *
 *       {@code AggregationInvocation::DISTINCT} bit, so a vanilla COUNT-with-distinct lowers to
            partitions,
            window.getExclude(),  
     *  ORDER BY key. Falls back to a passthrough rebuild when the operand shape is unexpected. */
 *       {@code FIRST_VALUE/LAST_VALUE(value) ORDER BY ts ASC} (no native arg_min/max UDAF in DataFusion 53.x).</li>
                return rebuild(over, over.getAggOperator(), operands, partitions, orderKeys, /* distinct */ false, cluster);  
    /** Rewrites {@code ARG_MIN(value, ts)} / {@code ARG_MAX(value, ts)} to
 */
     * Non-distinct {@code COUNT(x) OVER(...)} passes through unchanged. The distinct flag is
        List<RexNode> operands,
                partitions,
     *  is the Calcite encoding of "default direction" — RexFieldCollation.getDirection() reads it
    }  
import java.util.ArrayList;  
            orderKeys,
import org.opensearch.analytics.spi.WindowFunctionAdapter;
 */  
                List.of(operands.get(0)),  
     *  and ignore-nulls flags from {@code original}. */
                appendAsc(orderKeys, operands.get(1)),
/**
            distinct,
    /** Returns a new order-key list with {@code key ASC NULLS_LAST} appended. Empty SqlKind set  
            List<RexNode> operands,  
 * this file be licensed under the Apache-2.0 license or a
                cluster  
        );
     * redundant {@code AggregationInvocation::DISTINCT} bit.
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
            original.ignoreNulls()
        RexOver original,  
                original.isDistinct(),  
    private static RexNode rebuild(
import org.apache.calcite.sql.SqlAggFunction;
 *       {@code os_count_distinct(x)}. DataFusion 54.x's substrait window consumer drops the
    /** Builds a fresh window {@link RexNode} preserving frame bounds, exclude, rows-vs-range,  
 *   <li>{@link #countDistinctExact()} — {@code COUNT(DISTINCT x) OVER(...)} → sandbox  
 * DataFusion-side {@link WindowFunctionAdapter}s rewriting PPL-form window aggregates:
                DataFusionFragmentConvertor.LOCAL_OS_COUNT_DISTINCT_OP,
                // Unexpected shape — preserve original behavior as best as possible.  
        List<RexNode> partitions,  
 *
     * leaving it set would emit a substrait operator named {@code os_count_distinct} carrying a  
        public RexNode adapt(
    static WindowFunctionAdapter distinctCountApprox() {
                original,
                partitions,  
 *       a plain non-distinct COUNT. Encoding DISTINCT in the operator name sidesteps the bug.</li>  
            partitions,
            );
}  
 * compatible open source license.
        List<RexFieldCollation> out = new ArrayList<>(existing.size() + 1);
        List<RexFieldCollation> orderKeys,
            operands,  
        boolean distinct,
            operator,  
        }  
            List<RexFieldCollation> orderKeys,
        );  
            window.isRows(),
import org.apache.calcite.rex.RexNode;
 *   <li>{@link #argMin()} / {@link #argMax()} — {@code ARG_MIN/MAX(value, ts)} →
package org.opensearch.be.datafusion;
            window.getLowerBound(),
            false,  
        RelOptCluster cluster  
 *   <li>{@link #distinctCountApprox()} — PPL {@code DISTINCT_COUNT_APPROX(x)} → Calcite  
                orderKeys,
 *       (DataFusion's built-in HLL UDAF).</li>
            over,
        return (over, operands, partitions, orderKeys, cluster) -> {
import org.apache.calcite.rex.RexWindow;
    private record ArgFunctionAdapter(SqlAggFunction target) implements WindowFunctionAdapter {
 * </ul>
            if (operands.size() != 2) {
                operands,
    }  
import org.apache.calcite.rex.RexFieldCollation;
            original.getType(),
            );
            operands,
            ImmutableList.copyOf(orderKeys),  
        RexBuilder rexBuilder = cluster.getRexBuilder();
            SqlStdOperatorTable.APPROX_COUNT_DISTINCT,
            if (!over.isDistinct()) {
 * @opensearch.internal  
    static WindowFunctionAdapter argMax() {
    }
            return rebuild(
            return rebuild(  
                cluster
    }
            RelOptCluster cluster  
     *  back as {@link org.apache.calcite.rel.RelFieldCollation.Direction#ASCENDING}. */
     *  {@code FIRST_VALUE(value)} / {@code LAST_VALUE(value)} with {@code ts} appended as an  
        return new ArgFunctionAdapter(SqlStdOperatorTable.FIRST_VALUE);
            RexOver original,
            over.isDistinct(),  
            }
        return rexBuilder.makeOver(
        out.addAll(existing);
    private static List<RexFieldCollation> appendAsc(List<RexFieldCollation> existing, RexNode key) {  
                return rebuild(original, original.getAggOperator(), operands, partitions, orderKeys, original.isDistinct(), cluster);
                /* distinct */ false,
 * <ul>  
    ) {
import org.apache.calcite.plan.RelOptCluster;
    }  
            cluster
    }
    private WindowFunctionAdapters() {}
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
        };
import java.util.Collections;
    /**
final class WindowFunctionAdapters {
        ) {
        RexWindow window = original.getWindow();  
/*  
import com.google.common.collect.ImmutableList;
        SqlAggFunction operator,
            window.getUpperBound(),
        out.add(new RexFieldCollation(key, Collections.emptySet()));  
            }
        return new ArgFunctionAdapter(SqlStdOperatorTable.LAST_VALUE);
        return out;
import org.apache.calcite.rex.RexOver;  
 * The OpenSearch Contributors require contributions made to  
        return (over, operands, partitions, orderKeys, cluster) -> rebuild(  
    static WindowFunctionAdapter countDistinctExact() {  
