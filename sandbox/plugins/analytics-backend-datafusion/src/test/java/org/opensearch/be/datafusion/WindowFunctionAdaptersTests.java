        assertEquals("operand list must be preserved", List.of(argument), over.getOperands());  
            List.of(value, ts),
        RexOver over = (RexOver) adapted;  
        return makeOver(op, returnType, operands, partitions, orderKeys, /* distinct */ false);  
            ImmutableList.of(),
    }
            OperandTypes.ANY
        rexBuilder = new RexBuilder(typeFactory);  
        List<RexFieldCollation> orderKeys,
            ReturnTypes.BIGINT_FORCE_NULLABLE,
     *  semantic). Pinning this contract guards the workaround for DataFusion 54.x's substrait
     *  Operator must flip, the {@code ts} operand must move out of operands and onto the end  
        RexNode partitionKey = rexBuilder.makeInputRef(varcharNullable, 2);
 *
        timestampNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), true);
    public void testNonDistinctCountIsPassthrough() {
            ImmutableList.of(orderKey),
        RelDataType returnType,
            over.getAggOperator()
            "DISTINCT_COUNT_APPROX",
            List.of(value, ts),  
     *  is the same invocation {@code WindowFunctionAdapters.rebuild} uses, so this fixture  
            false  
        assertSame("operand[0] must be the original value operand", value, over.getOperands().getFirst());
 */  
            List.of(argument),
     *  and an UNBOUNDED PRECEDING / UNBOUNDED FOLLOWING frame — the default frame eventstats
            SqlStdOperatorTable.COUNT,
            List.of(partitionKey),
            ImmutableList.of()  
            bigintNullable,
        RexNode value = rexBuilder.makeInputRef(varcharNullable, 0);  
            true,  
    /** {@code DISTINCT_COUNT_APPROX(x)} → {@code APPROX_COUNT_DISTINCT(x)}. The underlying UDAF is a
        RexNode value = rexBuilder.makeInputRef(varcharNullable, 0);
import org.apache.calcite.rel.type.RelDataTypeFactory;
        assertSame(
        List<RexNode> partitions,  
    public void testArgMaxRewritesToLastValueWithTsOrderBy() {  
            SqlStdOperatorTable.ARG_MIN,
        assertEquals("existing ORDER BY key must be preserved before ts", 2, over.getWindow().orderKeys.size());  
 *   <li>{@code ARG_MAX(value, ts)} → {@code LAST_VALUE(value) ORDER BY ts ASC}</li>
    public void testArgMinRewritesToFirstValueWithTsOrderBy() {
import org.apache.calcite.rex.RexFieldCollation;  
        RexOver over = (RexOver) adapted;  
        RexNode ts = rexBuilder.makeInputRef(timestampNullable, 1);
        List<RexNode> operands,
            operands,
        RexNode adapted = WindowFunctionAdapters.distinctCountApprox()  
        assertTrue("ARG_MIN must rewrite to a RexOver, got " + adapted.getClass(), adapted instanceof RexOver);  
        SqlAggFunction op,
    /** {@code ARG_MIN(value, ts)} → {@code FIRST_VALUE(value) OVER (... ORDER BY ts ASC)}.
    private RexNode makeOverFull(
        RexNode argument = rexBuilder.makeInputRef(varcharNullable, 0);
        RexOver original = (RexOver) makeOverFull(
        assertEquals("rewritten call's return type must equal the original", original.getType(), over.getType());
            List.of(argument),  
import org.apache.calcite.plan.RelOptCluster;  
            "DISTINCT_COUNT_APPROX UDAF must rewrite to standard APPROX_COUNT_DISTINCT",
import java.util.List;  
 * window aggregates. Each test pins one rewrite contract so future planner / Calcite
        assertSame(
        RexNode ts = rexBuilder.makeInputRef(timestampNullable, 1);
            RexWindowBounds.UNBOUNDED_PRECEDING,
        SqlAggFunction op,  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
     *  operands, partition keys, order keys, and the original distinct flag. */
 *   <li>{@code DISTINCT_COUNT_APPROX(x)} → {@code APPROX_COUNT_DISTINCT(x)}</li>  
            .adapt(original, List.of(value, ts), List.of(partitionKey), ImmutableList.of(), cluster);
import org.opensearch.test.OpenSearchTestCase;  
    private RelDataType bigintNullable;
     *  is registered for {@link org.opensearch.analytics.spi.WindowFunction#COUNT} so it sees
            SqlStdOperatorTable.ARG_MIN,
        RexOver original = (RexOver) makeOver(
}  
    }  
            distinct,
    public void setUp() throws Exception {  
        assertEquals("partition keys must be preserved", List.of(partitionKey), over.getWindow().partitionKeys);
        assertSame("ORDER BY key must be the original ts operand", ts, over.getWindow().orderKeys.getFirst().left);
     *  {@link SqlKind#OTHER_FUNCTION} with operator name {@code DISTINCT_COUNT_APPROX}; the  
        );  
        typeFactory = new JavaTypeFactoryImpl();
    }  
            ImmutableList.of(),
            .adapt(original, List.of(value, ts), ImmutableList.of(), ImmutableList.of(), cluster);
import org.apache.calcite.rel.type.RelDataType;  
            SqlStdOperatorTable.COUNT,
        RexNode argument = rexBuilder.makeInputRef(varcharNullable, 0);
    /** ARG_MIN/ARG_MAX should preserve any pre-existing ORDER BY keys and append ts after them. */
        List<RexFieldCollation> orderKeys
        RelDataType returnType,
        assertFalse("non-distinct COUNT must remain non-distinct", over.isDistinct());  
        List<RexNode> partitions,
            .adapt(original, List.of(argument), ImmutableList.of(), ImmutableList.of(), cluster);
import org.apache.calcite.rex.RexWindowExclusion;
        );
            /* distinct */ true  
        boolean distinct  
 */
        RexNode value = rexBuilder.makeInputRef(varcharNullable, 0);
import org.apache.calcite.rex.RexWindowBounds;  
import org.apache.calcite.plan.hep.HepProgramBuilder;
            op,
    }
 * this file be licensed under the Apache-2.0 license or a
        RexNode partitionKey = rexBuilder.makeInputRef(varcharNullable, 1);  
        );
public class WindowFunctionAdaptersTests extends OpenSearchTestCase {
        List<RexNode> operands,  
            bigintNullable,  
            "COUNT(DISTINCT) must rewrite to LOCAL_OS_COUNT_DISTINCT_OP",
        RexNode argument = rexBuilder.makeInputRef(varcharNullable, 0);
        assertEquals("order keys must be preserved", 1, over.getWindow().orderKeys.size());  
import org.apache.calcite.rex.RexBuilder;
            RexWindowBounds.UNBOUNDED_FOLLOWING,  
package org.opensearch.be.datafusion;
        RexNode partitionKey = rexBuilder.makeInputRef(varcharNullable, 1);
        super.setUp();
        assertEquals("partition keys must be preserved", List.of(partitionKey), over.getWindow().partitionKeys);
import org.apache.calcite.sql.SqlAggFunction;
            DataFusionFragmentConvertor.LOCAL_OS_COUNT_DISTINCT_OP,  
import com.google.common.collect.ImmutableList;
            List.of(argument),
    private RexNode makeOver(  
        );
            .adapt(original, List.of(value, ts), ImmutableList.of(), List.of(existingCollation), cluster);  
        varcharNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);  
            .adapt(original, List.of(argument), List.of(partitionKey), ImmutableList.of(), cluster);
        assertFalse("distinct flag must be cleared on the rebuilt over", over.isDistinct());  
            .adapt(original, List.of(argument), List.of(partitionKey), List.of(orderKey), cluster);
    /** {@code COUNT(x) OVER(...)} (non-distinct) — must pass through unchanged. The adapter
            SqlStdOperatorTable.APPROX_COUNT_DISTINCT,  
            SqlStdOperatorTable.ARG_MAX,
        RexNode adapted = WindowFunctionAdapters.argMin()
        assertSame("non-distinct COUNT must keep its operator", SqlStdOperatorTable.COUNT, over.getAggOperator());
 * <ul>  
        assertEquals("rewritten call's return type must equal the original", original.getType(), over.getType());  
            varcharNullable,  
        assertSame("first ORDER BY key must be the existing one", existingOrderKey, over.getWindow().orderKeys.get(0).left);
        RexNode existingOrderKey = rexBuilder.makeInputRef(bigintNullable, 2);  
    private RelDataType varcharNullable;
    @Override
        RexFieldCollation existingCollation = new RexFieldCollation(existingOrderKey, Collections.emptySet());
            returnType,  
 * Unit tests for {@link WindowFunctionAdapters} — DataFusion-side rewrites of PPL-form  
        RexNode adapted = WindowFunctionAdapters.countDistinctExact()
     *  of the order-key list; partition keys, frame bounds, and return type stay put. */
     *  exercises the same code path the production rewrite will produce. */
        assertEquals("rewritten call's return type must equal the original", original.getType(), over.getType());
        RexOver original = (RexOver) makeOverFull(
    private RelDataType timestampNullable;  
    }  
        RexNode adapted = WindowFunctionAdapters.argMax()  
    }
            SqlKind.OTHER_FUNCTION,  
import org.apache.calcite.plan.hep.HepPlanner;
    }
        assertEquals("rewritten call must keep only the value operand", 1, over.getOperands().size());
        assertEquals("operand list must be preserved", List.of(argument), over.getOperands());
/**
 * upgrades can't silently change what isthmus emits to substrait:
            RexWindowExclusion.EXCLUDE_NO_OTHER,
     *  window consumer that drops {@code AggregationInvocation::DISTINCT}. */  
        );
        );
        assertSame("ARG_MAX must rewrite to LAST_VALUE", SqlStdOperatorTable.LAST_VALUE, over.getAggOperator());
        assertSame("ARG_MIN must rewrite to FIRST_VALUE", SqlStdOperatorTable.FIRST_VALUE, over.getAggOperator());
            ImmutableList.copyOf(orderKeys),
        SqlAggFunction dcApproxUdaf = SqlBasicAggFunction.create(
    /** {@code ARG_MAX(value, ts)} → {@code LAST_VALUE(value) OVER (... ORDER BY ts ASC)}. */
        assertEquals("ts must be appended to ORDER BY", 1, over.getWindow().orderKeys.size());
        RexOver original = (RexOver) makeOverFull(  
        assertEquals("ts must be appended to ORDER BY", 1, over.getWindow().orderKeys.size());  
        );
        RexNode ts = rexBuilder.makeInputRef(timestampNullable, 1);
            List.of(partitionKey),
        assertTrue("order keys must remain empty", over.getWindow().orderKeys.isEmpty());
            ImmutableList.of()  
        RexNode adapted = WindowFunctionAdapters.countDistinctExact()  
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
            varcharNullable,  
import org.apache.calcite.sql.type.OperandTypes;  
        RexOver original = (RexOver) makeOverFull(
            varcharNullable,
        assertEquals("rewritten call must keep only the value operand", 1, over.getOperands().size());  
 * </ul>  
 *   <li>{@code ARG_MIN(value, ts)} → {@code FIRST_VALUE(value) ORDER BY ts ASC}</li>
    }  
        RexOver original = (RexOver) makeOver(  
        return rexBuilder.makeOver(
        assertSame("second ORDER BY key must be the ts operand", ts, over.getWindow().orderKeys.get(1).left);
     *  distinct flag cleared on the rebuilt RexOver (the operator name now carries the DISTINCT
    private RelDataTypeFactory typeFactory;
    public void testCountDistinctRewritesToOsCountDistinct() {
            ImmutableList.of(),
            List.of(partitionKey),
    }
            /* distinct */ false
            ImmutableList.of()  
        RexOver over = (RexOver) adapted;
            false,
        RexNode adapted = WindowFunctionAdapters.argMin()  
        );
    ) {
import org.apache.calcite.rex.RexOver;
        RexOver over = (RexOver) adapted;  
            dcApproxUdaf,
    public void testArgMinPreservesExistingOrderKeysAndAppendsTs() {  
import org.apache.calcite.sql.type.SqlTypeName;
        bigintNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
        );  
     *  adapter rebinds the operator to Calcite's standard APPROX_COUNT_DISTINCT and preserves
import java.util.Collections;
    ) {
        RexFieldCollation orderKey = new RexFieldCollation(rexBuilder.makeInputRef(varcharNullable, 2), Collections.emptySet());
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            ImmutableList.of(existingCollation)
     *  every COUNT-OVER call; only DISTINCT-flagged ones get rewritten. */  
    /** {@code COUNT(DISTINCT x) OVER(...)} → {@code os_count_distinct(x) OVER(...)} with the  
    public void testDistinctCountApproxRewritesToApproxCountDistinct() {  
            partitions,  
            over.getAggOperator()
        );
        RexOver over = (RexOver) adapted;
        assertSame(value, over.getOperands().getFirst());  
/*  
        assertEquals("partition keys must be preserved", List.of(partitionKey), over.getWindow().partitionKeys);
            true,
     *  uses for ARG_MIN/ARG_MAX/DISTINCT_COUNT_APPROX. The 13-arg {@link RexBuilder#makeOver}
 * The OpenSearch Contributors require contributions made to  
 *   <li>{@code COUNT(x) OVER(...)} (non-distinct) — passthrough, distinct flag stays cleared</li>
    /** Build a {@link RexOver} with the given function, operand list, partition keys, order keys,  
            ImmutableList.of(),  
            List.of(value, ts),
    private RexBuilder rexBuilder;
    private RelOptCluster cluster;  
        assertSame(ts, over.getWindow().orderKeys.getFirst().left);
 *   <li>{@code COUNT(DISTINCT x) OVER(...)} → {@code os_count_distinct(x) OVER(...)}</li>
import org.apache.calcite.sql.SqlKind;  
        RexOver over = (RexOver) adapted;
        cluster = RelOptCluster.create(planner, rexBuilder);
 * SPDX-License-Identifier: Apache-2.0
            bigintNullable,  
import org.apache.calcite.rex.RexNode;
import org.apache.calcite.sql.fun.SqlBasicAggFunction;
import org.apache.calcite.sql.type.ReturnTypes;
 * compatible open source license.
