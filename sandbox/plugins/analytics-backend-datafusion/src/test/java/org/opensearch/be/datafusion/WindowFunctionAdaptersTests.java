            varcharNullable,
     *  is registered for {@link org.opensearch.analytics.spi.WindowFunction#COUNT} so it sees
            false,
     *  {@link SqlKind#OTHER_FUNCTION} with operator name {@code DISTINCT_COUNT_APPROX}; the
        RexNode ts = rexBuilder.makeInputRef(timestampNullable, 1);
            ImmutableList.of(),
            over.getAggOperator()
        assertEquals("partition keys must be preserved", List.of(partitionKey), over.getWindow().partitionKeys);
            distinct,
 *   <li>{@code COUNT(DISTINCT x) OVER(...)} → {@code os_count_distinct(x) OVER(...)}</li>
import org.apache.calcite.rel.type.RelDataType;
 * </ul>
     *  and an UNBOUNDED PRECEDING / UNBOUNDED FOLLOWING frame — the default frame eventstats
    /** {@code ARG_MAX(value, ts)} → {@code LAST_VALUE(value) OVER (... ORDER BY ts ASC)}. */
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        List<RexFieldCollation> orderKeys,
        return rexBuilder.makeOver(
    private RelDataType timestampNullable;
    private RexBuilder rexBuilder;
            SqlStdOperatorTable.APPROX_COUNT_DISTINCT,
        RexNode value = rexBuilder.makeInputRef(varcharNullable, 0);
        RexNode adapted = WindowFunctionAdapters.countDistinctExact()
     *  Operator must flip, the {@code ts} operand must move out of operands and onto the end
        );
            .adapt(original, List.of(value, ts), ImmutableList.of(), List.of(existingCollation), cluster);
    /** ARG_MIN/ARG_MAX should preserve any pre-existing ORDER BY keys and append ts after them. */
    private RexNode makeOver(
import org.apache.calcite.sql.type.OperandTypes;
        super.setUp();
            .adapt(original, List.of(argument), ImmutableList.of(), ImmutableList.of(), cluster);
    public void testArgMinPreservesExistingOrderKeysAndAppendsTs() {
    }
        RexOver original = (RexOver) makeOver(
            SqlStdOperatorTable.COUNT,
            varcharNullable,
import org.apache.calcite.rex.RexNode;
        assertSame(
        assertTrue("ARG_MIN must rewrite to a RexOver, got " + adapted.getClass(), adapted instanceof RexOver);
        );
        RexNode adapted = WindowFunctionAdapters.distinctCountApprox()
 *   <li>{@code DISTINCT_COUNT_APPROX(x)} → {@code APPROX_COUNT_DISTINCT(x)}</li>
        assertEquals("partition keys must be preserved", List.of(partitionKey), over.getWindow().partitionKeys);
     *  exercises the same code path the production rewrite will produce. */
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        RexNode adapted = WindowFunctionAdapters.argMin()
        List<RexNode> partitions,
import org.apache.calcite.sql.SqlKind;
        RexOver original = (RexOver) makeOverFull(
        assertEquals("rewritten call's return type must equal the original", original.getType(), over.getType());
        cluster = RelOptCluster.create(planner, rexBuilder);
import org.apache.calcite.rex.RexWindowBounds;
            dcApproxUdaf,
        RexOver original = (RexOver) makeOverFull(
    private RexNode makeOverFull(
            List.of(partitionKey),
        assertSame("operand[0] must be the original value operand", value, over.getOperands().getFirst());
            List.of(argument),
 * <ul>
import org.apache.calcite.rel.type.RelDataTypeFactory;
            SqlStdOperatorTable.COUNT,
    /** {@code COUNT(x) OVER(...)} (non-distinct) — must pass through unchanged. The adapter
        RexFieldCollation existingCollation = new RexFieldCollation(existingOrderKey, Collections.emptySet());
        assertEquals("operand list must be preserved", List.of(argument), over.getOperands());
            partitions,
        RelDataType returnType,
        varcharNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
        rexBuilder = new RexBuilder(typeFactory);
    }
        RexNode partitionKey = rexBuilder.makeInputRef(varcharNullable, 1);
        assertEquals("rewritten call must keep only the value operand", 1, over.getOperands().size());
        timestampNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), true);
        assertSame("ORDER BY key must be the original ts operand", ts, over.getWindow().orderKeys.getFirst().left);
        RexNode argument = rexBuilder.makeInputRef(varcharNullable, 0);
        assertEquals("rewritten call's return type must equal the original", original.getType(), over.getType());
import org.apache.calcite.rex.RexFieldCollation;
        RexOver original = (RexOver) makeOver(
        );
 *   <li>{@code ARG_MAX(value, ts)} → {@code LAST_VALUE(value) ORDER BY ts ASC}</li>
        assertSame("non-distinct COUNT must keep its operator", SqlStdOperatorTable.COUNT, over.getAggOperator());
        RexOver over = (RexOver) adapted;
        RexNode value = rexBuilder.makeInputRef(varcharNullable, 0);
        assertSame(value, over.getOperands().getFirst());
    /** {@code DISTINCT_COUNT_APPROX(x)} → {@code APPROX_COUNT_DISTINCT(x)}. The underlying UDAF is a
 * this file be licensed under the Apache-2.0 license or a
        RexFieldCollation orderKey = new RexFieldCollation(rexBuilder.makeInputRef(varcharNullable, 2), Collections.emptySet());
            false
        List<RexNode> operands,
    }
        assertSame("ARG_MAX must rewrite to LAST_VALUE", SqlStdOperatorTable.LAST_VALUE, over.getAggOperator());
 * SPDX-License-Identifier: Apache-2.0
     *  is the same invocation {@code WindowFunctionAdapters.rebuild} uses, so this fixture
            List.of(value, ts),
import org.apache.calcite.plan.RelOptCluster;
            OperandTypes.ANY
            List.of(value, ts),
     *  of the order-key list; partition keys, frame bounds, and return type stay put. */
        assertTrue("order keys must remain empty", over.getWindow().orderKeys.isEmpty());
        RexOver original = (RexOver) makeOverFull(
    ) {
            ImmutableList.of(orderKey),
        RexOver over = (RexOver) adapted;
        typeFactory = new JavaTypeFactoryImpl();
            SqlStdOperatorTable.ARG_MIN,
    @Override
        assertEquals("order keys must be preserved", 1, over.getWindow().orderKeys.size());
    /** {@code COUNT(DISTINCT x) OVER(...)} → {@code os_count_distinct(x) OVER(...)} with the
            bigintNullable,
        RexOver over = (RexOver) adapted;
            RexWindowExclusion.EXCLUDE_NO_OTHER,
            ImmutableList.of(existingCollation)
        assertSame("ARG_MIN must rewrite to FIRST_VALUE", SqlStdOperatorTable.FIRST_VALUE, over.getAggOperator());
        RexNode value = rexBuilder.makeInputRef(varcharNullable, 0);
    public void testArgMinRewritesToFirstValueWithTsOrderBy() {
            operands,
    private RelDataTypeFactory typeFactory;
            ImmutableList.of()
        assertSame(ts, over.getWindow().orderKeys.getFirst().left);
        );
    public void testDistinctCountApproxRewritesToApproxCountDistinct() {
        List<RexNode> partitions,
import org.apache.calcite.rex.RexBuilder;
    }
            SqlStdOperatorTable.ARG_MIN,
import java.util.Collections;
            List.of(partitionKey),
package org.opensearch.be.datafusion;
            List.of(argument),
        );
        assertSame("second ORDER BY key must be the ts operand", ts, over.getWindow().orderKeys.get(1).left);
        assertEquals("ts must be appended to ORDER BY", 1, over.getWindow().orderKeys.size());
        RexNode adapted = WindowFunctionAdapters.countDistinctExact()
            ImmutableList.of()
            ImmutableList.of(),
    /** {@code ARG_MIN(value, ts)} → {@code FIRST_VALUE(value) OVER (... ORDER BY ts ASC)}.
 * compatible open source license.
     *  every COUNT-OVER call; only DISTINCT-flagged ones get rewritten. */
     *  window consumer that drops {@code AggregationInvocation::DISTINCT}. */
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
 *   <li>{@code ARG_MIN(value, ts)} → {@code FIRST_VALUE(value) ORDER BY ts ASC}</li>
    private RelDataType varcharNullable;
            true,
        assertFalse("non-distinct COUNT must remain non-distinct", over.isDistinct());
import org.apache.calcite.sql.fun.SqlBasicAggFunction;
        List<RexNode> operands,
        RexNode partitionKey = rexBuilder.makeInputRef(varcharNullable, 1);
            "DISTINCT_COUNT_APPROX UDAF must rewrite to standard APPROX_COUNT_DISTINCT",
        return makeOver(op, returnType, operands, partitions, orderKeys, /* distinct */ false);
        assertEquals("operand list must be preserved", List.of(argument), over.getOperands());
    public void setUp() throws Exception {
        assertEquals("rewritten call's return type must equal the original", original.getType(), over.getType());
            true,
        RexNode partitionKey = rexBuilder.makeInputRef(varcharNullable, 2);
            "COUNT(DISTINCT) must rewrite to LOCAL_OS_COUNT_DISTINCT_OP",
import java.util.List;
            ReturnTypes.BIGINT_FORCE_NULLABLE,
        RexOver over = (RexOver) adapted;
    ) {
/*
 * window aggregates. Each test pins one rewrite contract so future planner / Calcite
import org.apache.calcite.sql.type.ReturnTypes;
            .adapt(original, List.of(argument), List.of(partitionKey), List.of(orderKey), cluster);
import org.apache.calcite.sql.type.SqlTypeName;
        assertEquals("rewritten call must keep only the value operand", 1, over.getOperands().size());
        );
            op,
        RexNode ts = rexBuilder.makeInputRef(timestampNullable, 1);
import org.apache.calcite.sql.SqlAggFunction;
    public void testNonDistinctCountIsPassthrough() {
        assertEquals("existing ORDER BY key must be preserved before ts", 2, over.getWindow().orderKeys.size());
        assertEquals("partition keys must be preserved", List.of(partitionKey), over.getWindow().partitionKeys);
     *  semantic). Pinning this contract guards the workaround for DataFusion 54.x's substrait
            .adapt(original, List.of(value, ts), List.of(partitionKey), ImmutableList.of(), cluster);
    }
        assertFalse("distinct flag must be cleared on the rebuilt over", over.isDistinct());
import org.apache.calcite.rex.RexOver;
    public void testArgMaxRewritesToLastValueWithTsOrderBy() {
        );
            "DISTINCT_COUNT_APPROX",
            ImmutableList.of(),
     *  operands, partition keys, order keys, and the original distinct flag. */
    public void testCountDistinctRewritesToOsCountDistinct() {
            List.of(argument),
            bigintNullable,
    private RelOptCluster cluster;
            returnType,
 */
            ImmutableList.of()
            /* distinct */ false
import org.opensearch.test.OpenSearchTestCase;
            bigintNullable,
    }
            List.of(value, ts),
            SqlKind.OTHER_FUNCTION,
        RexNode ts = rexBuilder.makeInputRef(timestampNullable, 1);
        RexNode existingOrderKey = rexBuilder.makeInputRef(bigintNullable, 2);
    private RelDataType bigintNullable;
            SqlStdOperatorTable.ARG_MAX,
        RexNode argument = rexBuilder.makeInputRef(varcharNullable, 0);
        );
     *  uses for ARG_MIN/ARG_MAX/DISTINCT_COUNT_APPROX. The 13-arg {@link RexBuilder#makeOver}
            varcharNullable,
        RexOver over = (RexOver) adapted;
            .adapt(original, List.of(value, ts), ImmutableList.of(), ImmutableList.of(), cluster);
        SqlAggFunction dcApproxUdaf = SqlBasicAggFunction.create(
    }
import com.google.common.collect.ImmutableList;
 */
 * Unit tests for {@link WindowFunctionAdapters} — DataFusion-side rewrites of PPL-form
     *  distinct flag cleared on the rebuilt RexOver (the operator name now carries the DISTINCT
    }
import org.apache.calcite.plan.hep.HepProgramBuilder;
            RexWindowBounds.UNBOUNDED_FOLLOWING,
        SqlAggFunction op,
    }
 *
 *   <li>{@code COUNT(x) OVER(...)} (non-distinct) — passthrough, distinct flag stays cleared</li>
        RexOver over = (RexOver) adapted;
public class WindowFunctionAdaptersTests extends OpenSearchTestCase {
        );
            ImmutableList.copyOf(orderKeys),
        );
     *  adapter rebinds the operator to Calcite's standard APPROX_COUNT_DISTINCT and preserves
import org.apache.calcite.rex.RexWindowExclusion;
            ImmutableList.of(),
        assertEquals("ts must be appended to ORDER BY", 1, over.getWindow().orderKeys.size());
        RexNode adapted = WindowFunctionAdapters.argMax()
            List.of(partitionKey),
            over.getAggOperator()
        List<RexFieldCollation> orderKeys
import org.apache.calcite.plan.hep.HepPlanner;
        boolean distinct
        assertSame("first ORDER BY key must be the existing one", existingOrderKey, over.getWindow().orderKeys.get(0).left);
            RexWindowBounds.UNBOUNDED_PRECEDING,
        RelDataType returnType,
}
        SqlAggFunction op,
        RexOver original = (RexOver) makeOverFull(
            .adapt(original, List.of(argument), List.of(partitionKey), ImmutableList.of(), cluster);
/**
    /** Build a {@link RexOver} with the given function, operand list, partition keys, order keys,
 * The OpenSearch Contributors require contributions made to
            /* distinct */ true
            DataFusionFragmentConvertor.LOCAL_OS_COUNT_DISTINCT_OP,
        RexNode adapted = WindowFunctionAdapters.argMin()
        RexNode argument = rexBuilder.makeInputRef(varcharNullable, 0);
        bigintNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
        assertSame(
 * upgrades can't silently change what isthmus emits to substrait:
