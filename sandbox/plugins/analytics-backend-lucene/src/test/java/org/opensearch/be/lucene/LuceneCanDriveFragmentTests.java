import org.apache.calcite.sql.SqlAggFunction;
        );
            -1,
            "count_star"
import org.apache.calcite.plan.hep.HepProgramBuilder;
import org.apache.calcite.rel.core.TableScan;
                aggregate(scan, ImmutableBitSet.of(), nullableNumeric(SqlStdOperatorTable.MIN, scan, "min_size"))
    @Override
    public void testCountWithGroupBy_notDrivable() {
/*
        );
            List.of(new RexBuilder(typeFactory).makeInputRef(scan, 0)),
 * The OpenSearch Contributors require contributions made to
                aggregate(scan, ImmutableBitSet.of(), nullableNumeric(SqlStdOperatorTable.MAX, scan, "max_size"))
        return new TableScan(cluster, cluster.traitSet(), List.of(), table) {
import org.apache.calcite.rel.logical.LogicalProject;
        cluster = RelOptCluster.create(new HepPlanner(new HepProgramBuilder().build()), new RexBuilder(typeFactory));
     * short-form would trip {@code typeMatchesInferred}.
            "cnt_status"
            LuceneFragmentConvertor.isCountFastPath(
            false,
        AggregateCall countField = AggregateCall.create(
            -1,
    }
            "MIN must be rejected",
    /**
            scan,
            "COUNT(*) GROUP BY status must be rejected — Lucene has no per-group count",
package org.opensearch.be.lucene;
    }
            SqlStdOperatorTable.COUNT,
        TableScan scan = stubScan("status", SqlTypeName.VARCHAR);
            scan,
        assertFalse(
            )
     * inferred type. Use the long-form create with null returnType so Calcite infers —
        );
/**
import org.apache.calcite.rel.RelNode;
    }
    private RelNode aggregate(RelNode input, ImmutableBitSet groupSet, AggregateCall... calls) {
    }
        TableScan scan = stubScan("status", SqlTypeName.VARCHAR);
    private AggregateCall countStar(TableScan scan) {
        RelDataTypeFactory.Builder builder = typeFactory.builder();
    private TableScan stubScan(String fieldName, SqlTypeName type) {
 */
     * SUM/MIN/MAX over an INTEGER column with empty group-set are nullable in Calcite's
        TableScan scan = stubScan("size", SqlTypeName.INTEGER);
            List.of("status")
import org.apache.calcite.util.ImmutableBitSet;
    public void setUp() throws Exception {
 * Pins {@link LuceneFragmentConvertor#isCountFastPath}: drivable iff top is an Aggregate
        assertTrue("COUNT(*) with empty group-set is the canonical Lucene-driver shape", LuceneFragmentConvertor.isCountFastPath(agg));
        );
import org.apache.calcite.plan.RelOptTable;
    public void testCountPlusSum_mixedAggregate_notDrivable() {
import static org.mockito.Mockito.mock;
        assertFalse("Project (no aggregate above) must be rejected", LuceneFragmentConvertor.isCountFastPath(project));
        TableScan scan = stubScan("status", SqlTypeName.VARCHAR);
 * capability-declaration drift — PlanForker already narrows by declared caps, this is the
    public void testCountStarOverEmptyGroupSet_drivable() {
        when(table.getQualifiedName()).thenReturn(List.of("test_index"));
 * with empty group-set and every call is {@code SqlKind.COUNT}. Read by
    }
            "SUM needs column values Lucene can't materialise — must be rejected",
            LuceneFragmentConvertor.isCountFastPath(aggregate(scan, ImmutableBitSet.of(0), countStar(scan)))
        super.setUp();
            typeFactory.createSqlType(SqlTypeName.BIGINT),
        return AggregateCall.create(fn, false, false, false, List.of(), List.of(0), -1, null, RelCollations.EMPTY, 0, input, null, alias);
    }
        builder.add(fieldName, typeFactory.createSqlType(type));
        typeFactory = new JavaTypeFactoryImpl();
            scan,
    }
            List.of(0),
            )
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.apache.calcite.plan.RelOptCluster;
import static org.mockito.Mockito.when;
        assertFalse("Bare TableScan must be rejected", LuceneFragmentConvertor.isCountFastPath(scan));
    private RelOptCluster cluster;
    }
        assertFalse("COUNT(*) + SUM mixed must be rejected", LuceneFragmentConvertor.isCountFastPath(agg));
        RelOptTable table = mock(RelOptTable.class);
        // Even one non-COUNT call disqualifies the whole aggregate — every call must be COUNT.
        RelNode agg = aggregate(scan, ImmutableBitSet.of(), countStar(scan));
        assertFalse(
    public void testMaxOverEmptyGroupSet_notDrivable() {
import org.apache.calcite.rel.core.AggregateCall;
    public void testSumOverEmptyGroupSet_notDrivable() {
        RelDataType rowType = builder.build();
    public void testCountFieldOverEmptyGroupSet_drivable() {
            LuceneFragmentConvertor.isCountFastPath(
            List.of(),
import org.apache.calcite.plan.hep.HepPlanner;
        TableScan scan = stubScan("status", SqlTypeName.VARCHAR);
import org.opensearch.test.OpenSearchTestCase;
        );
     */
            LuceneFragmentConvertor.isCountFastPath(
        assertFalse(
            SqlStdOperatorTable.COUNT,
 * SPDX-License-Identifier: Apache-2.0
        TableScan scan = stubScan("size", SqlTypeName.INTEGER);
    public void testMinOverEmptyGroupSet_notDrivable() {
            "count(field) is also drivable — same SqlKind.COUNT",
import org.apache.calcite.rel.logical.LogicalAggregate;
    }
        // group-by COUNT — Lucene has no per-bucket count primitive.
            )
public class LuceneCanDriveFragmentTests extends OpenSearchTestCase {
    private AggregateCall nullableNumeric(SqlAggFunction fn, RelNode input, String alias) {
        RelNode agg = aggregate(scan, ImmutableBitSet.of(), countStar(scan), nullableNumeric(SqlStdOperatorTable.SUM, scan, "total_size"));
import org.apache.calcite.rex.RexBuilder;
        when(table.getRowType()).thenReturn(rowType);
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.rel.RelCollations;
 * {@link LuceneShardPreference} to score this fragment for the count-fast-path. Guards
        );
        );
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        RelNode project = LogicalProject.create(
        return AggregateCall.create(
    }
        );
}
        // count(field) — same SqlKind.COUNT, just with a field arg.
            typeFactory.createSqlType(SqlTypeName.BIGINT),
            false,
        };
        return LogicalAggregate.create(input, List.of(), groupSet, null, List.of(calls));
        assertTrue(
    }
import org.apache.calcite.rel.type.RelDataType;
            LuceneFragmentConvertor.isCountFastPath(aggregate(scan, ImmutableBitSet.of(), countField))
    }
            List.of(),
                aggregate(scan, ImmutableBitSet.of(), nullableNumeric(SqlStdOperatorTable.SUM, scan, "total_size"))
import org.apache.calcite.sql.type.SqlTypeName;
    }
    // ---- Helpers ----
        TableScan scan = stubScan("size", SqlTypeName.INTEGER);
            "MAX must be rejected",
        assertFalse(
    public void testNonAggregateTop_notDrivable() {
 * second line.
 *
import java.util.List;
        TableScan scan = stubScan("size", SqlTypeName.INTEGER);
    private RelDataTypeFactory typeFactory;
 */
import org.apache.calcite.rel.type.RelDataTypeFactory;
 * compatible open source license.
