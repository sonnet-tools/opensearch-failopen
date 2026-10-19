    }
            SqlStdOperatorTable.COUNT,
            typeFactory.createSqlType(SqlTypeName.BIGINT),
        // group-by COUNT — Lucene has no per-bucket count primitive.
 * with empty group-set and every call is {@code SqlKind.COUNT}. Read by
    private AggregateCall nullableNumeric(SqlAggFunction fn, RelNode input, String alias) {
        cluster = RelOptCluster.create(new HepPlanner(new HepProgramBuilder().build()), new RexBuilder(typeFactory));  
    }  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
import org.apache.calcite.rel.type.RelDataTypeFactory;
        TableScan scan = stubScan("status", SqlTypeName.VARCHAR);
            List.of(),
    public void testCountWithGroupBy_notDrivable() {
        TableScan scan = stubScan("size", SqlTypeName.INTEGER);
            -1,
        TableScan scan = stubScan("size", SqlTypeName.INTEGER);
        TableScan scan = stubScan("status", SqlTypeName.VARCHAR);
    }
     * SUM/MIN/MAX over an INTEGER column with empty group-set are nullable in Calcite's
import org.apache.calcite.plan.hep.HepProgramBuilder;
            LuceneFragmentConvertor.isCountFastPath(
    }
 * {@link LuceneShardPreference} to score this fragment for the count-fast-path. Guards
            scan,  
import org.apache.calcite.rel.logical.LogicalAggregate;
            LuceneFragmentConvertor.isCountFastPath(aggregate(scan, ImmutableBitSet.of(0), countStar(scan)))  
        );
            )
            -1,
            "cnt_status"
        assertFalse(
    }
import org.apache.calcite.rel.logical.LogicalProject;
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
import org.opensearch.test.OpenSearchTestCase;
        assertFalse(
import static org.mockito.Mockito.when;  
    // ---- Helpers ----
/**
        assertFalse("Bare TableScan must be rejected", LuceneFragmentConvertor.isCountFastPath(scan));
import org.apache.calcite.sql.type.SqlTypeName;
            LuceneFragmentConvertor.isCountFastPath(
    public void testCountPlusSum_mixedAggregate_notDrivable() {  
        );
     */
import org.apache.calcite.rel.core.AggregateCall;
    public void testCountFieldOverEmptyGroupSet_drivable() {  
        );  
        assertFalse(  
 *
        return AggregateCall.create(fn, false, false, false, List.of(), List.of(0), -1, null, RelCollations.EMPTY, 0, input, null, alias);  
            "MAX must be rejected",
        );
    }
        RelDataTypeFactory.Builder builder = typeFactory.builder();
 * second line.
        TableScan scan = stubScan("status", SqlTypeName.VARCHAR);  
        RelDataType rowType = builder.build();  
        RelOptTable table = mock(RelOptTable.class);
        TableScan scan = stubScan("size", SqlTypeName.INTEGER);
            typeFactory.createSqlType(SqlTypeName.BIGINT),  
import org.apache.calcite.rex.RexBuilder;
        return LogicalAggregate.create(input, List.of(), groupSet, null, List.of(calls));  
package org.opensearch.be.lucene;
            "count(field) is also drivable — same SqlKind.COUNT",
            scan,
    }
 * Pins {@link LuceneFragmentConvertor#isCountFastPath}: drivable iff top is an Aggregate  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            "count_star"
        RelNode agg = aggregate(scan, ImmutableBitSet.of(), countStar(scan));
            List.of("status")
import org.apache.calcite.util.ImmutableBitSet;  
        assertFalse("Project (no aggregate above) must be rejected", LuceneFragmentConvertor.isCountFastPath(project));  
/*  
            List.of(0),  
    }
import org.apache.calcite.sql.SqlAggFunction;  
        assertFalse("COUNT(*) + SUM mixed must be rejected", LuceneFragmentConvertor.isCountFastPath(agg));
     * inferred type. Use the long-form create with null returnType so Calcite infers —
            List.of(),
            )
            false,
        TableScan scan = stubScan("status", SqlTypeName.VARCHAR);
        assertTrue("COUNT(*) with empty group-set is the canonical Lucene-driver shape", LuceneFragmentConvertor.isCountFastPath(agg));  
     * short-form would trip {@code typeMatchesInferred}.  
        RelNode agg = aggregate(scan, ImmutableBitSet.of(), countStar(scan), nullableNumeric(SqlStdOperatorTable.SUM, scan, "total_size"));  
            SqlStdOperatorTable.COUNT,
    public void testMinOverEmptyGroupSet_notDrivable() {
    public void testMaxOverEmptyGroupSet_notDrivable() {
        return new TableScan(cluster, cluster.traitSet(), List.of(), table) {
        when(table.getQualifiedName()).thenReturn(List.of("test_index"));
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.plan.hep.HepPlanner;
        // count(field) — same SqlKind.COUNT, just with a field arg.
    public void setUp() throws Exception {  
 * capability-declaration drift — PlanForker already narrows by declared caps, this is the  
        // Even one non-COUNT call disqualifies the whole aggregate — every call must be COUNT.
        RelNode project = LogicalProject.create(  
                aggregate(scan, ImmutableBitSet.of(), nullableNumeric(SqlStdOperatorTable.SUM, scan, "total_size"))
        typeFactory = new JavaTypeFactoryImpl();
    private RelOptCluster cluster;  
                aggregate(scan, ImmutableBitSet.of(), nullableNumeric(SqlStdOperatorTable.MIN, scan, "min_size"))  
import org.apache.calcite.plan.RelOptTable;  
        return AggregateCall.create(
        AggregateCall countField = AggregateCall.create(  
                aggregate(scan, ImmutableBitSet.of(), nullableNumeric(SqlStdOperatorTable.MAX, scan, "max_size"))
    }
    /**  
            scan,
import org.apache.calcite.rel.RelCollations;  
    public void testCountStarOverEmptyGroupSet_drivable() {  
        );
        };
        assertFalse(
        TableScan scan = stubScan("size", SqlTypeName.INTEGER);  
    }  
            LuceneFragmentConvertor.isCountFastPath(  
            "COUNT(*) GROUP BY status must be rejected — Lucene has no per-group count",
import org.apache.calcite.rel.type.RelDataType;  
 */  
}
    }
public class LuceneCanDriveFragmentTests extends OpenSearchTestCase {  
        );  
    public void testNonAggregateTop_notDrivable() {
            LuceneFragmentConvertor.isCountFastPath(aggregate(scan, ImmutableBitSet.of(), countField))
        when(table.getRowType()).thenReturn(rowType);  
import static org.mockito.Mockito.mock;
    private TableScan stubScan(String fieldName, SqlTypeName type) {  
    private AggregateCall countStar(TableScan scan) {  
import org.apache.calcite.rel.RelNode;
import java.util.List;  
        );
        );  
        super.setUp();
            false,  
import org.apache.calcite.plan.RelOptCluster;
    @Override
import org.apache.calcite.rel.core.TableScan;  
 */
    }
            "MIN must be rejected",
        builder.add(fieldName, typeFactory.createSqlType(type));
    }
    private RelDataTypeFactory typeFactory;
        assertTrue(  
    private RelNode aggregate(RelNode input, ImmutableBitSet groupSet, AggregateCall... calls) {
            "SUM needs column values Lucene can't materialise — must be rejected",  
            )  
 * SPDX-License-Identifier: Apache-2.0
    public void testSumOverEmptyGroupSet_notDrivable() {  
            List.of(new RexBuilder(typeFactory).makeInputRef(scan, 0)),  
