        List<CanMatchFilter> filters = CanMatchFilterExtractor.extract(plan);
        }
        RelNode plan = LogicalFilter.create(scan, condition);  
        assertEquals(1, filters.size());  
        assertEquals(3, filters.size()); // ts>=1000, port>80, port<443  
    }  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.BIGINT), 0),
        assertEquals(Long.MAX_VALUE, range.min()); // saturated
        RelNode plan = LogicalFilter.create(scan, condition);  
        assertEquals(Long.MIN_VALUE, range.min());  
        RelNode plan = LogicalFilter.create(scan, condition);
    }  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1),  
        when(table.getQualifiedName()).thenReturn(List.of("test_table"));
        );  
}
        assertEquals("@timestamp", range.column());
            rexBuilder.makeLiteral(1000L, typeFactory.createSqlType(SqlTypeName.BIGINT), true)  
    public void testSimpleGreaterThan() {
            SqlStdOperatorTable.EQUALS,  
        assertEquals(1000L, range.min());
        assertEquals("@timestamp", range.column());
        LongRange range = (LongRange) filters.get(0);  
        RexNode portEq80 = rexBuilder.makeCall(
        typeFactory = new JavaTypeFactoryImpl();
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.BIGINT), 0),
        List<CanMatchFilter> filters = CanMatchFilterExtractor.extract(plan);
        assertEquals(Long.MAX_VALUE, range.max());
            SqlStdOperatorTable.GREATER_THAN_OR_EQUAL,  
        // This is what real PPL queries produce: >($0, TIMESTAMP('2026-07-13':VARCHAR))
        RelNode plan = LogicalFilter.create(scan, condition);  
        RelNode plan = LogicalFilter.create(scan, andCondition);
            rexBuilder.makeLiteral(443, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1),  
            SqlStdOperatorTable.EQUALS,
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.BIGINT), 0),
    }
        List<CanMatchFilter> filters = CanMatchFilterExtractor.extract(plan);  
 *
package org.opensearch.analytics.exec.canmatch;
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        assertEquals("@timestamp", range.column());
    public void setUp() throws Exception {
import org.apache.calcite.plan.RelOptCluster;
        assertEquals(1, filters.size());  
        RexNode tsCondition = rexBuilder.makeCall(
        LongRange range = (LongRange) filters.get(0);  
    public void testNonRangePredicateIgnored() {
    }
    private static class StubTableScan extends TableScan {
            rexBuilder.makeLiteral(1000L, typeFactory.createSqlType(SqlTypeName.BIGINT), true)  
            SqlStdOperatorTable.GREATER_THAN_OR_EQUAL,
        );
        VolcanoPlanner planner = new VolcanoPlanner();  
            SqlStdOperatorTable.GREATER_THAN,
        RexNode andCondition = rexBuilder.makeCall(SqlStdOperatorTable.AND, tsCondition, orCondition);  
        // Flat AND with 3 operands (Calcite flattens nested ANDs into this form)
    public void testAndWithNonRangeSibling() {
        RexNode condition = rexBuilder.makeCall(
        assertEquals(1, filters.size());  
        assertEquals(1000L, range.min()); // GTE → min = value
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.BIGINT), 0)
            SqlStdOperatorTable.LESS_THAN,
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.BIGINT), 0),  
        RelNode plan = LogicalFilter.create(scan, condition);
        );
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1),
            rexBuilder.makeLiteral(80, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        // 1000 < @timestamp (reversed operands)  
        // @timestamp >= 1000 OR port < 443
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1),
        LongRange range = (LongRange) filters.get(0);  
    private RelDataTypeFactory typeFactory;
            rexBuilder.makeLiteral(80, typeFactory.createSqlType(SqlTypeName.INTEGER), true)  
        assertEquals(Long.MAX_VALUE, range.max());
        // Simulates CAST('2026-07-13':TIMESTAMP) — a RexCall wrapping a string literal.  
        assertEquals(Long.MAX_VALUE, range.max());
            rexBuilder.makeLiteral(1000L, typeFactory.createSqlType(SqlTypeName.BIGINT), true)
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1),  
/*  
        scan = new StubTableScan(cluster, cluster.traitSet(), table);
            rexBuilder.makeLiteral(1000L, typeFactory.createSqlType(SqlTypeName.BIGINT), true)
    }  
        RexNode castToTimestamp = rexBuilder.makeCast(
        );
        );
        RexNode condition = rexBuilder.makeCall(
        );  
            SqlStdOperatorTable.LESS_THAN,  
        );
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
 * this file be licensed under the Apache-2.0 license or a
        );
        // OR is skipped, but @timestamp range should still be extracted
        );  
        assertEquals(1001L, range.min());
        RexNode condition = rexBuilder.makeCall(  
import java.util.List;
        RexNode portCondition = rexBuilder.makeCall(
        List<CanMatchFilter> filters = CanMatchFilterExtractor.extract(plan);
        assertTrue(filters.isEmpty());
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.BIGINT), 0),
    public void testTimestampFunctionWrapper() {
 * SPDX-License-Identifier: Apache-2.0
        );
        assertEquals(1, filters.size());
            rexBuilder.makeLiteral(443, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 2),
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.BIGINT), 0),
import org.apache.calcite.rel.RelNode;
public class CanMatchFilterExtractorTests extends OpenSearchTestCase {  
        assertEquals("port", range.column());
import org.apache.calcite.rex.RexNode;
    }  
        RexNode orCondition = rexBuilder.makeCall(SqlStdOperatorTable.OR, portEq80, portEq443);
        // The OR should be skipped, but the timestamp range should survive
        cluster = RelOptCluster.create(planner, rexBuilder);
        );
        assertEquals(1783900800001L, range.min());  
            rexBuilder.makeLiteral(443, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            SqlStdOperatorTable.GREATER_THAN_OR_EQUAL,
        // @timestamp >= 1000 AND host = 'foo' — equality is skipped, range extracted
        rexBuilder = new RexBuilder(typeFactory);
        LongRange range = (LongRange) filters.get(0);
    @Override
        );
        List<CanMatchFilter> filters = CanMatchFilterExtractor.extract(plan);
        RexNode portGt = rexBuilder.makeCall(  
            SqlStdOperatorTable.GREATER_THAN_OR_EQUAL,  
        // @timestamp > 1000  
        assertTrue(filters.isEmpty());
        );
            rexBuilder.makeLiteral(443, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        RexNode tsCondition = rexBuilder.makeCall(  
 * The OpenSearch Contributors require contributions made to  
        );
        RelNode plan = LogicalFilter.create(scan, andCondition);
        RelDataType rowType = typeFactory.builder()
        List<CanMatchFilter> filters = CanMatchFilterExtractor.extract(plan);
            SqlStdOperatorTable.GREATER_THAN,
            rexBuilder.makeLiteral(443, typeFactory.createSqlType(SqlTypeName.INTEGER), true)  
            SqlStdOperatorTable.LESS_THAN,
            .add("port", SqlTypeName.INTEGER)  
            SqlStdOperatorTable.GREATER_THAN_OR_EQUAL,
    private RelNode scan;
        LongRange range = (LongRange) filters.get(0);
 * compatible open source license.
        // 2026-07-13 00:00:00 UTC = 1783900800000 epoch millis, GT bumps +1
        // @timestamp >= 1000 AND (port = 80 OR port = 443)  
            rexBuilder.makeLiteral(Long.MAX_VALUE, typeFactory.createSqlType(SqlTypeName.BIGINT), true)
            SqlStdOperatorTable.GREATER_THAN_OR_EQUAL,
        RexNode condition = rexBuilder.makeCall(  
    public void testGreaterThanOrEqual() {
            SqlStdOperatorTable.EQUALS,
        super.setUp();  
            rexBuilder.makeLiteral(1000L, typeFactory.createSqlType(SqlTypeName.BIGINT), true)
    }
        List<CanMatchFilter> filters = CanMatchFilterExtractor.extract(plan);
        RexNode portLt = rexBuilder.makeCall(
import org.opensearch.test.OpenSearchTestCase;
    private RelOptCluster cluster;
    }  
import static org.mockito.Mockito.mock;  
        RelNode plan = LogicalFilter.create(scan, condition);  
            SqlStdOperatorTable.LESS_THAN,
        RexNode portEq443 = rexBuilder.makeCall(  
        assertEquals(1000L, range.min());
    public void testNoFilterInPlanReturnsEmpty() {
            SqlStdOperatorTable.GREATER_THAN,
        RelNode plan = LogicalFilter.create(scan, andCondition);
        assertEquals(2, filters.size());
        RexNode tsCondition = rexBuilder.makeCall(
    public void testTopLevelOrReturnsEmpty() {  
        );  
import org.apache.calcite.rex.RexBuilder;
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1),
        List<CanMatchFilter> filters = CanMatchFilterExtractor.extract(plan);
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        List<CanMatchFilter> filters = CanMatchFilterExtractor.extract(plan);
        // @timestamp >= 1000 AND port > 80 AND port < 443 (flat AND with 3 children)  
        RelOptTable table = mock(RelOptTable.class);
    public void testLiteralOnLeftSide() {
        List<CanMatchFilter> filters = CanMatchFilterExtractor.extract(plan);  
        protected StubTableScan(RelOptCluster cluster, org.apache.calcite.plan.RelTraitSet traitSet, RelOptTable table) {  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.BIGINT), 0),  
        assertEquals(442L, range.max()); // LT → max = value - 1
            rexBuilder.makeLiteral(1000L, typeFactory.createSqlType(SqlTypeName.BIGINT), true)  
        assertEquals("@timestamp", range.column());
        RelNode plan = LogicalFilter.create(scan, condition);
            rexBuilder.makeLiteral("2026-07-13")
            SqlStdOperatorTable.GREATER_THAN,
        RexNode condition = rexBuilder.makeCall(
        // Build a scan with fields: @timestamp (BIGINT), port (INTEGER), host (VARCHAR)  
            SqlStdOperatorTable.EQUALS,
import org.apache.calcite.rel.logical.LogicalFilter;
    }  
        );
        List<CanMatchFilter> filters = CanMatchFilterExtractor.extract(plan);
            SqlStdOperatorTable.LESS_THAN,  
            rexBuilder.makeLiteral("foo")
            rexBuilder.makeLiteral(1000L, typeFactory.createSqlType(SqlTypeName.BIGINT), true)
        );  
            .build();
        );
        RexNode andCondition = rexBuilder.makeCall(SqlStdOperatorTable.AND, tsCondition, portCondition);
import static org.mockito.Mockito.when;
        LongRange range = (LongRange) filters.get(0);
        RexNode flatAnd = rexBuilder.makeCall(SqlStdOperatorTable.AND, tsCondition, portGt, portLt);
            rexBuilder.makeLiteral("foo")  
        RexNode orCondition = rexBuilder.makeCall(SqlStdOperatorTable.OR, tsCondition, portCondition);  
        LongRange range = (LongRange) filters.get(0);  
        assertEquals("@timestamp", range.column());
import org.apache.calcite.rel.type.RelDataType;
        assertEquals(1, filters.size());  
        );
    }  
        RexNode eqCondition = rexBuilder.makeCall(
        RexNode condition = rexBuilder.makeCall(
        // @timestamp >= 1000
        List<CanMatchFilter> filters = CanMatchFilterExtractor.extract(plan);
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1),
            typeFactory.createSqlType(SqlTypeName.TIMESTAMP, 3),  
        assertEquals(1001L, range.min()); // GT → min = value + 1  
        // @timestamp > Long.MAX_VALUE - 1 (should saturate at MAX_VALUE)  
    }
        assertTrue(filters.isEmpty());
            super(cluster, traitSet, List.of(), table);
    }
        when(table.getRowType()).thenReturn(rowType);  
        List<CanMatchFilter> filters = CanMatchFilterExtractor.extract(scan);
        RelNode plan = LogicalFilter.create(scan, orCondition);
        // port < 443  
        RelNode plan = LogicalFilter.create(scan, flatAnd);  
        assertEquals(1, filters.size());
            .add("@timestamp", SqlTypeName.BIGINT)
        RexNode condition = rexBuilder.makeCall(  
import org.apache.calcite.plan.RelOptTable;  
    public void testMultipleAndPredicates() {
    public void testAndWithNestedOrDoesNotClobberSiblingFilters() {
import org.apache.calcite.rel.core.TableScan;  
        RexNode portCondition = rexBuilder.makeCall(
        // 1000 < @timestamp → @timestamp > 1000 → min = 1001  
    public void testBoundaryMaxValue() {
    }  
 */  
        // Just a scan, no filter  
            castToTimestamp  
        );
            .add("host", SqlTypeName.VARCHAR)
            rexBuilder.makeLiteral(1000L, typeFactory.createSqlType(SqlTypeName.BIGINT), true),  
        // @timestamp >= 1000 AND port < 443
        // host = 'foo' (equality — not a range, should be ignored)
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.BIGINT), 0),  
        RexNode andCondition = rexBuilder.makeCall(SqlStdOperatorTable.AND, tsCondition, eqCondition);
    private RexBuilder rexBuilder;  
import org.apache.calcite.sql.type.SqlTypeName;
        assertEquals(Long.MAX_VALUE, range.max());
import org.apache.calcite.plan.volcano.VolcanoPlanner;
    }  
    }  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 2),
        assertEquals(1, filters.size());
        RexNode tsCondition = rexBuilder.makeCall(
    public void testLessThan() {
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.BIGINT), 0),
    public void testMultipleRangesOnSameColumn() {
        RexNode tsCondition = rexBuilder.makeCall(  
        LongRange range = (LongRange) filters.get(0);
        assertEquals(1, filters.size());
