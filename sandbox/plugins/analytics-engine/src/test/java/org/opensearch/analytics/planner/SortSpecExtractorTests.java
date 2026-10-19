    /** The sort column need not be field 0 — the name must come from the collation's index. */
    }  
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        RelNode sort = LogicalSort.create(scan, RelCollations.EMPTY, null, intLiteral(10));  
 * compatible open source license.
    public void testAscendingSortWithLimit() {  
        assertEquals("second collation index must resolve to the second field", "size", spec.column());  
 * The OpenSearch Contributors require contributions made to  
}  
        RelNode sort = LogicalSort.create(
    public void testDescendingSortWithLimit() {  
        assertNotNull("a pushed-down collated Sort with a fetch must yield a spec", spec);  
    // ---- shapes that yield a spec ----
    public void testSortWithoutFetchYieldsNoSpec() {  
            null  
        assertNull(SortSpecExtractor.extract(null));
import org.opensearch.analytics.planner.dag.Stage;
    /** A Sort carrying an offset still yields a spec — offset must not defeat extraction. */  
import org.opensearch.analytics.planner.dag.DAGBuilder;  
    public void testBareLimitWithoutCollationYieldsNoSpec() {
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
 * lands inside the shard fragment where extraction finds it, so no new planner plumbing is needed.  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
    private RexNode intLiteral(int value) {  
/**  
import org.apache.calcite.rel.logical.LogicalSort;
        assertNull(shardSortSpec(sort));  
        assertEquals("status", spec.column());
import org.opensearch.analytics.exec.canmatch.SortSpec;
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
    private RelNode sortLimit(int fieldIndex, RelFieldCollation.Direction direction, Integer offset, int fetch) {
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
import org.opensearch.analytics.exec.canmatch.SortSpecExtractor;
        return leafStage(dag.rootStage()).getSortSpec();
            offset == null ? null : intLiteral(offset),  
        assertNotNull(spec);
        SortSpec spec = shardSortSpec(sortLimit(0, RelFieldCollation.Direction.ASCENDING, 20, 10));
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING)),
    }  
        PlannerContext context = multiShardContext();
        return LogicalSort.create(  
        assertEquals("limit must be offset + fetch, not fetch", 30, spec.limit());
        assertEquals("status", spec.column());
    // ---- shapes that must NOT yield a spec ----
package org.opensearch.analytics.planner;
import java.util.List;
            scan,  
        List<Stage> children = stage.getChildStages();  
    /** The limit is offset + fetch: it must count the offset rows the coordinator collects then discards. */
    private static Stage leafStage(Stage stage) {
import org.apache.calcite.sql.type.SqlTypeName;  
import org.apache.calcite.rel.RelNode;  
    }
 */  
    /** A bare {@code head N} has no ordering, so there is no key to order shards by. */  
    }
        SortSpec spec = shardSortSpec(sortLimit(0, RelFieldCollation.Direction.DESCENDING, null, 5));
    }
        RelNode planned = runPlanner(logicalPlan, context);
    /** Walks to the bottom-most stage — the shard fragment. */
import org.apache.calcite.rel.RelFieldCollation;
    }
        assertNull(SortSpecExtractor.extract(scan));  
    public void testSortWithOffsetStillYieldsSpec() {
    public void testResolvesColumnNameFromCollationIndex() {
    public void testLimitIncludesOffset() {  
    // ---- helpers ----
        );
            scan,
/*  
    }
            intLiteral(fetch)
 * Tests {@link SortSpecExtractor} against post-CBO, post-DAG-cut shard fragments — the real input it
    }
            null,
        SortSpec spec = shardSortSpec(sortLimit(0, RelFieldCollation.Direction.ASCENDING, 20, 10));
        assertEquals("no offset → limit is the fetch", 10, spec.limit());  
        QueryDAG dag = DAGBuilder.build(planned, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);  
        SortSpec spec = shardSortSpec(sortLimit(0, RelFieldCollation.Direction.ASCENDING, null, 10));
            RelCollations.of(new RelFieldCollation(fieldIndex, direction)),
import org.apache.calcite.rel.RelCollations;
    /** An unbounded {@code ORDER BY} has no top-N to reason about. */
    }
    }
import org.opensearch.analytics.planner.dag.QueryDAG;
        SortSpec spec = shardSortSpec(sortLimit(1, RelFieldCollation.Direction.ASCENDING, null, 3));  
    private SortSpec shardSortSpec(RelNode logicalPlan) {  
    }
        return rexBuilder.makeLiteral(value, typeFactory.createSqlType(SqlTypeName.INTEGER), true);
    }  
        );
        return children.isEmpty() ? stage : leafStage(children.get(0));
        assertNotNull(spec);  
 */
    /** Runs the planner + DAG cut and returns the leaf (shard) stage's extracted spec. */
        assertNull(shardSortSpec(sort));
    }
        assertTrue("DESC must be reported so the coordinator orders by max", spec.descending());
public class SortSpecExtractorTests extends PlanShapeTestBase {
        assertNotNull(spec);  
        assertNotNull(spec);
        assertFalse(spec.descending());
 *
import org.apache.calcite.rex.RexNode;
    public void testNullFragmentYieldsNoSpec() {  
 * sees at runtime — rather than hand-assembled Sort nodes. Confirms the pushed-down collated Sort
    public void testFragmentWithoutSortYieldsNoSpec() {  
