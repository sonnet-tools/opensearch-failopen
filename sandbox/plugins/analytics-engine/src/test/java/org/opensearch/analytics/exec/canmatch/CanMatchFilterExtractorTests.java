        );
        LongRange range = (LongRange) filters.get(0);
        scan = new StubTableScan(cluster, cluster.traitSet(), table);
        assertEquals(1, filters.size());
        List<CanMatchFilter> filters = CanMatchFilterExtractor.extract(plan);
    }
        assertEquals(1, filters.size());
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.BIGINT), 0),
        assertEquals(1, filters.size());
        );
        RelNode plan = LogicalFilter.create(scan, condition);
        RelNode plan = LogicalFilter.create(scan, orCondition);
        VolcanoPlanner planner = new VolcanoPlanner();
            .add("@timestamp", SqlTypeName.BIGINT)
        assertEquals(1001L, range.min()); // GT → min = value + 1
 * compatible open source license.
        );
    }
        assertTrue(filters.isEmpty());
        assertEquals("@timestamp", range.column());
import org.opensearch.test.OpenSearchTestCase;
        );
        LongRange range = (LongRange) filters.get(0);
        // Just a scan, no filter
        List<CanMatchFilter> filters = CanMatchFilterExtractor.extract(plan);
        RexNode andCondition = rexBuilder.makeCall(SqlStdOperatorTable.AND, tsCondition, portCondition);
        );
        cluster = RelOptCluster.create(planner, rexBuilder);
        // @timestamp > 1000
            SqlStdOperatorTable.EQUALS,
        RexNode portEq443 = rexBuilder.makeCall(
        LongRange range = (LongRange) filters.get(0);
        // 1000 < @timestamp → @timestamp > 1000 → min = 1001
        RexNode portCondition = rexBuilder.makeCall(
        // 1000 < @timestamp (reversed operands)
        RexNode andCondition = rexBuilder.makeCall(SqlStdOperatorTable.AND, tsCondition, eqCondition);
        RexNode portLt = rexBuilder.makeCall(
        List<CanMatchFilter> filters = CanMatchFilterExtractor.extract(plan);
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 2),
        LongRange range = (LongRange) filters.get(0);
        );
    public void testNonRangePredicateIgnored() {
        RelNode plan = LogicalFilter.create(scan, condition);
            rexBuilder.makeLiteral(1000L, typeFactory.createSqlType(SqlTypeName.BIGINT), true)
public class CanMatchFilterExtractorTests extends OpenSearchTestCase {
        RexNode tsCondition = rexBuilder.makeCall(
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.BIGINT), 0),
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 2),
    }
    }
            super(cluster, traitSet, List.of(), table);
    public void testLessThan() {
            rexBuilder.makeLiteral(1000L, typeFactory.createSqlType(SqlTypeName.BIGINT), true)
            rexBuilder.makeLiteral(443, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
import org.apache.calcite.plan.volcano.VolcanoPlanner;
        super.setUp();
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.BIGINT), 0),
            rexBuilder.makeLiteral(1000L, typeFactory.createSqlType(SqlTypeName.BIGINT), true)
        // host = 'foo' (equality — not a range, should be ignored)
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1),
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1),
            SqlStdOperatorTable.EQUALS,
        assertEquals(Long.MIN_VALUE, range.min());
    public void testNoFilterInPlanReturnsEmpty() {
            rexBuilder.makeLiteral(443, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        RexNode eqCondition = rexBuilder.makeCall(
        RexNode orCondition = rexBuilder.makeCall(SqlStdOperatorTable.OR, portEq80, portEq443);
        assertEquals(Long.MAX_VALUE, range.max());
    public void testAndWithNonRangeSibling() {
        assertEquals("@timestamp", range.column());
            rexBuilder.makeLiteral("foo")
        assertEquals(Long.MAX_VALUE, range.min()); // saturated
            rexBuilder.makeLiteral(Long.MAX_VALUE, typeFactory.createSqlType(SqlTypeName.BIGINT), true)
            SqlStdOperatorTable.LESS_THAN,
    }
            rexBuilder.makeLiteral("foo")
    public void testMultipleAndPredicates() {
        RexNode condition = rexBuilder.makeCall(
import org.apache.calcite.plan.RelOptCluster;
    }
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.BIGINT), 0),
        List<CanMatchFilter> filters = CanMatchFilterExtractor.extract(plan);
        assertTrue(filters.isEmpty());
        RexNode condition = rexBuilder.makeCall(
        assertEquals(1, filters.size());
        LongRange range = (LongRange) filters.get(0);
        RelNode plan = LogicalFilter.create(scan, andCondition);
        assertEquals(442L, range.max()); // LT → max = value - 1
            rexBuilder.makeLiteral(1000L, typeFactory.createSqlType(SqlTypeName.BIGINT), true)
        RelDataType rowType = typeFactory.builder()
import org.apache.calcite.rel.type.RelDataTypeFactory;
 */
        // port < 443
import static org.mockito.Mockito.when;
        assertEquals(3, filters.size()); // ts>=1000, port>80, port<443
        RelNode plan = LogicalFilter.create(scan, condition);
        assertEquals(Long.MAX_VALUE, range.max());
        RelNode plan = LogicalFilter.create(scan, flatAnd);
        );
            SqlStdOperatorTable.GREATER_THAN,
    public void testTopLevelOrReturnsEmpty() {
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RexNode tsCondition = rexBuilder.makeCall(
import org.apache.calcite.rel.type.RelDataType;
        // The OR should be skipped, but the timestamp range should survive
import org.apache.calcite.rex.RexNode;
/*
        when(table.getRowType()).thenReturn(rowType);
        );
        // @timestamp >= 1000
        List<CanMatchFilter> filters = CanMatchFilterExtractor.extract(plan);
        );
        LongRange range = (LongRange) filters.get(0);
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.BIGINT), 0),
        // Simulates CAST('2026-07-13':TIMESTAMP) — a RexCall wrapping a string literal.
            rexBuilder.makeLiteral(443, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        );
        List<CanMatchFilter> filters = CanMatchFilterExtractor.extract(plan);
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.BIGINT), 0)
        // OR is skipped, but @timestamp range should still be extracted
            rexBuilder.makeLiteral(1000L, typeFactory.createSqlType(SqlTypeName.BIGINT), true)
            SqlStdOperatorTable.LESS_THAN,
            .add("port", SqlTypeName.INTEGER)
    }
        when(table.getQualifiedName()).thenReturn(List.of("test_table"));
        assertEquals(1000L, range.min()); // GTE → min = value
        List<CanMatchFilter> filters = CanMatchFilterExtractor.extract(plan);
        );
            SqlStdOperatorTable.GREATER_THAN,
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.BIGINT), 0),
        assertEquals("@timestamp", range.column());
            SqlStdOperatorTable.GREATER_THAN_OR_EQUAL,
        RexNode tsCondition = rexBuilder.makeCall(
        RelNode plan = LogicalFilter.create(scan, condition);
            rexBuilder.makeLiteral(443, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            SqlStdOperatorTable.LESS_THAN,
            rexBuilder.makeLiteral(1000L, typeFactory.createSqlType(SqlTypeName.BIGINT), true)
    }
import org.apache.calcite.sql.type.SqlTypeName;
        RelNode plan = LogicalFilter.create(scan, andCondition);
            SqlStdOperatorTable.GREATER_THAN_OR_EQUAL,
            rexBuilder.makeLiteral(1000L, typeFactory.createSqlType(SqlTypeName.BIGINT), true)
    public void testBoundaryMaxValue() {
    public void setUp() throws Exception {
    public void testMultipleRangesOnSameColumn() {
    }
        List<CanMatchFilter> filters = CanMatchFilterExtractor.extract(plan);
            rexBuilder.makeLiteral(80, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        RexNode tsCondition = rexBuilder.makeCall(
        assertEquals(1, filters.size());
        }
            rexBuilder.makeLiteral(1000L, typeFactory.createSqlType(SqlTypeName.BIGINT), true),
        List<CanMatchFilter> filters = CanMatchFilterExtractor.extract(plan);
        );
        // @timestamp >= 1000 AND (port = 80 OR port = 443)
        assertEquals(Long.MAX_VALUE, range.max());
        // Build a scan with fields: @timestamp (BIGINT), port (INTEGER), host (VARCHAR)
            rexBuilder.makeLiteral(443, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            .build();
        RexNode portEq80 = rexBuilder.makeCall(
        );
 * this file be licensed under the Apache-2.0 license or a
        RexNode condition = rexBuilder.makeCall(
        // @timestamp >= 1000 AND port > 80 AND port < 443 (flat AND with 3 children)
        );
            typeFactory.createSqlType(SqlTypeName.TIMESTAMP, 3),
        assertEquals("@timestamp", range.column());
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1),
            rexBuilder.makeLiteral(80, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        assertEquals(1, filters.size());
        RexNode condition = rexBuilder.makeCall(
        // 2026-07-13 00:00:00 UTC = 1783900800000 epoch millis, GT bumps +1
        RelOptTable table = mock(RelOptTable.class);
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        typeFactory = new JavaTypeFactoryImpl();
    private RelDataTypeFactory typeFactory;
        LongRange range = (LongRange) filters.get(0);
        // @timestamp > Long.MAX_VALUE - 1 (should saturate at MAX_VALUE)
        List<CanMatchFilter> filters = CanMatchFilterExtractor.extract(plan);
    }
        assertEquals("@timestamp", range.column());
            SqlStdOperatorTable.EQUALS,
        RexNode castToTimestamp = rexBuilder.makeCast(
        // This is what real PPL queries produce: >($0, TIMESTAMP('2026-07-13':VARCHAR))
import org.apache.calcite.plan.RelOptTable;
        RelNode plan = LogicalFilter.create(scan, condition);
            SqlStdOperatorTable.EQUALS,
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.BIGINT), 0),
        RexNode tsCondition = rexBuilder.makeCall(
            SqlStdOperatorTable.LESS_THAN,
    }
        RexNode flatAnd = rexBuilder.makeCall(SqlStdOperatorTable.AND, tsCondition, portGt, portLt);
            SqlStdOperatorTable.GREATER_THAN_OR_EQUAL,
        RexNode orCondition = rexBuilder.makeCall(SqlStdOperatorTable.OR, tsCondition, portCondition);
    public void testAndWithNestedOrDoesNotClobberSiblingFilters() {
        assertEquals(1783900800001L, range.min());
        assertEquals("port", range.column());
        RelNode plan = LogicalFilter.create(scan, andCondition);
    private RelOptCluster cluster;
            rexBuilder.makeLiteral("2026-07-13")
        RelNode plan = LogicalFilter.create(scan, condition);
            SqlStdOperatorTable.GREATER_THAN_OR_EQUAL,
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.BIGINT), 0),
import static org.mockito.Mockito.mock;
        RexNode portCondition = rexBuilder.makeCall(
    }
        );
            SqlStdOperatorTable.GREATER_THAN_OR_EQUAL,
        );
 * SPDX-License-Identifier: Apache-2.0
        RelNode plan = LogicalFilter.create(scan, condition);
package org.opensearch.analytics.exec.canmatch;
        List<CanMatchFilter> filters = CanMatchFilterExtractor.extract(scan);
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.BIGINT), 0),
        RexNode condition = rexBuilder.makeCall(
        List<CanMatchFilter> filters = CanMatchFilterExtractor.extract(plan);
        // @timestamp >= 1000 AND host = 'foo' — equality is skipped, range extracted
            castToTimestamp
        assertEquals(1001L, range.min());
        assertTrue(filters.isEmpty());
        );
    private RexBuilder rexBuilder;
        LongRange range = (LongRange) filters.get(0);
    }
            SqlStdOperatorTable.GREATER_THAN,
 * The OpenSearch Contributors require contributions made to
    public void testTimestampFunctionWrapper() {
        assertEquals(2, filters.size());
        assertEquals(1, filters.size());
import org.apache.calcite.rel.RelNode;
            SqlStdOperatorTable.GREATER_THAN_OR_EQUAL,
    }
import org.apache.calcite.rex.RexBuilder;
import org.apache.calcite.rel.logical.LogicalFilter;
            SqlStdOperatorTable.LESS_THAN,
        );
    private static class StubTableScan extends TableScan {
        RexNode portGt = rexBuilder.makeCall(
    public void testSimpleGreaterThan() {
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1),
        // @timestamp >= 1000 OR port < 443
            .add("host", SqlTypeName.VARCHAR)
    private RelNode scan;
}
    @Override
import java.util.List;
 *
import org.apache.calcite.rel.core.TableScan;
        assertEquals(1, filters.size());
        RexNode condition = rexBuilder.makeCall(
        RexNode condition = rexBuilder.makeCall(
        RexNode andCondition = rexBuilder.makeCall(SqlStdOperatorTable.AND, tsCondition, orCondition);
        );
        List<CanMatchFilter> filters = CanMatchFilterExtractor.extract(plan);
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1),
        assertEquals(1000L, range.min());
    }
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1),
        assertEquals(1000L, range.min());
            SqlStdOperatorTable.GREATER_THAN,
        rexBuilder = new RexBuilder(typeFactory);
        assertEquals(Long.MAX_VALUE, range.max());
        // Flat AND with 3 operands (Calcite flattens nested ANDs into this form)
        protected StubTableScan(RelOptCluster cluster, org.apache.calcite.plan.RelTraitSet traitSet, RelOptTable table) {
        // @timestamp >= 1000 AND port < 443
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1),
    public void testLiteralOnLeftSide() {
    public void testGreaterThanOrEqual() {
        );
