 * <p>This runs BEFORE decorrelation, so a subquery is still a {@code RexSubQuery} hanging off a Filter
 * <p>That default is tiny, so estimates derived from it collapse — a filter and aggregate above such a  
 */  
/*  
}  
import org.opensearch.cluster.ClusterState;  
    public void testIndexReferencedOnlyInsideAnInSubqueryIsCollected() {
 *  
import org.apache.calcite.rel.RelNode;
        ClusterState state = SqlPlannerTestFixture.clusterStateWith(List.of(indices), FIELDS);  
 * this file be licensed under the Apache-2.0 license or a
    }
     */
import org.opensearch.analytics.planner.SqlPlannerTestFixture;
        );  
                + "row count while the outer table is sized correctly; collected "
    public void testSubqueryOverTheSameIndexCollectsItOnce() {  
        );
    /** A subquery over the SAME index must not produce a duplicate or a spurious extra name. */
        );
            "inner_index"
    private static Set<String> namesFor(String sql, String... indices) {
 *
    private static final Map<String, Map<String, Object>> FIELDS = Map.of(
        Set<String> names = namesFor(
            "outer_index",
 * data. The failure is silent: the query still returns correct results, just via a plan chosen on
            "outer_index",  
        );
 * Which indices get their row counts seeded.
package org.opensearch.analytics.exec;
 * falls back to Calcite's default row count.
            "SELECT * FROM outer_index WHERE status IN (SELECT status FROM inner_index)",  
 * fiction, so nothing but a test like this catches a regression here.  
            "outer_index",
    }
    }
 */
import java.util.Set;
            "SELECT * FROM outer_index WHERE status > (SELECT max(status) FROM inner_index)",
import org.opensearch.test.OpenSearchTestCase;
            "inner_index"  
     * The regression this class exists for: an index reachable only through an EXISTS subquery must be
            "inner_index"
 *
 * scan come out at about one row — and plan choices then get made on a number with no relation to the
 * inputs alone therefore misses any index that appears ONLY inside a subquery, and every such scan then  
        "size",
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
        assertEquals(Set.of("outer_index"), namesFor("SELECT * FROM outer_index WHERE EXISTS (SELECT 1 FROM outer_index)", "outer_index"));
    public void testIndexReferencedOnlyInsideAScalarSubqueryIsCollected() {
import java.util.Map;
        assertTrue(  
    }  
     * collected too. Missing it leaves that scan on Calcite's default row count while its sibling is  
import java.util.List;  
        RelNode parsed = SqlPlannerTestFixture.parseSql(sql, state);
    public void testIndexReferencedOnlyInsideAnExistsSubqueryIsCollected() {  
    }  
        "status",
            "SELECT * FROM outer_index WHERE EXISTS (SELECT 1 FROM inner_index WHERE inner_index.status = outer_index.status)",
                + names,  
    /** The plain case: an index scanned by the outer query is collected. */
        assertEquals(Set.of("outer_index", "inner_index"), names);  
            names.contains("inner_index")
        assertEquals(Set.of("outer_index", "inner_index"), names);
        Set<String> names = namesFor(
/**
    /**
    /** And for a scalar subquery in the WHERE clause. */
            "a table reachable only through a subquery must still be seeded, else it keeps Calcite's default "
 * SPDX-License-Identifier: Apache-2.0
 * condition or a Project expression rather than an input in the RelNode tree. Collecting scans by walking
     * correctly sized, so the two sides of a join are estimated on incomparable numbers.
    );  
public class IndexRowCountFetcherTests extends OpenSearchTestCase {
        Map.of("type", "integer"),  
        Set<String> names = namesFor(  
    public void testOuterQueryIndexIsCollected() {  
    /** Same requirement for an IN subquery, which lowers through a different rule. */  
        assertEquals(Set.of("outer_index", "inner_index"), names);
    }
        Map.of("type", "integer")
        return IndexRowCountFetcher.referencedIndexNames(parsed);
        assertEquals(Set.of("outer_index"), namesFor("SELECT * FROM outer_index", "outer_index"));
