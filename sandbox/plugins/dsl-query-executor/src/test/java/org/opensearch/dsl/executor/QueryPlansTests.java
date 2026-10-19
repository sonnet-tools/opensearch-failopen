    }
        assertTrue(plans.has(QueryPlans.Type.HITS));
        QueryPlans plans = new QueryPlans.Builder().build();  
        super.setUp();
}
        assertEquals(1, plans.getAll().size());  
        assertFalse(plans.has(QueryPlans.Type.AGGREGATION));
        assertEquals(2, plans.get(QueryPlans.Type.AGGREGATION).size());
            () -> plans.getAll().add(new QueryPlans.QueryPlan(QueryPlans.Type.AGGREGATION, relNode))  
        assertEquals(0, plans.getAll().size());
import org.opensearch.test.OpenSearchTestCase;  
        QueryPlans plans = new QueryPlans.Builder().add(new QueryPlans.QueryPlan(QueryPlans.Type.HITS, relNode))  
    }
        );
import org.opensearch.dsl.TestUtils;
    }
    public void testGetReturnsEmptyForMissingType() {
 * The OpenSearch Contributors require contributions made to  
            .add(new QueryPlans.QueryPlan(QueryPlans.Type.AGGREGATION, relNode))
    public void testGetReturnsMultiplePlansOfSameType() {
        expectThrows(
    public void testBuilderCreatesSinglePlan() {  
    private RelNode relNode;
        assertTrue(plans.has(QueryPlans.Type.AGGREGATION));  
 * this file be licensed under the Apache-2.0 license or a
    public void testBuilderCreatesMultiplePlans() {
    }  
    public void setUp() throws Exception {
        assertEquals(1, plans.get(QueryPlans.Type.AGGREGATION).size());
    public void testBuilderAllowsEmpty() {
    public void testPlansAreImmutable() {
        assertEquals(1, plans.get(QueryPlans.Type.HITS).size());
 * compatible open source license.
            UnsupportedOperationException.class,
public class QueryPlansTests extends OpenSearchTestCase {
 *
 */  
        assertTrue(plans.get(QueryPlans.Type.AGGREGATION).isEmpty());
            .add(new QueryPlans.QueryPlan(QueryPlans.Type.AGGREGATION, relNode))
/*  
            .build();
    public void testQueryPlanRejectsNullArguments() {
    }
        expectThrows(NullPointerException.class, () -> new QueryPlans.QueryPlan(null, relNode));  
        expectThrows(NullPointerException.class, () -> new QueryPlans.QueryPlan(QueryPlans.Type.HITS, null));
        QueryPlans plans = new QueryPlans.Builder().add(new QueryPlans.QueryPlan(QueryPlans.Type.HITS, relNode)).build();
            .build();
import org.apache.calcite.rel.RelNode;
        assertTrue(plans.has(QueryPlans.Type.HITS));
    }  
        QueryPlans plans = new QueryPlans.Builder().add(new QueryPlans.QueryPlan(QueryPlans.Type.HITS, relNode)).build();
    }
 * SPDX-License-Identifier: Apache-2.0
    }
        // Empty plans are valid (e.g. size=0, no aggs — metadata-only response)
        relNode = TestUtils.createTestRelNode();  
package org.opensearch.dsl.executor;
        QueryPlans plans = new QueryPlans.Builder().add(new QueryPlans.QueryPlan(QueryPlans.Type.HITS, relNode)).build();
        assertEquals(2, plans.getAll().size());
        QueryPlans plans = new QueryPlans.Builder().add(new QueryPlans.QueryPlan(QueryPlans.Type.AGGREGATION, relNode))  
    @Override  
