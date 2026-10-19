/*  
            same(context.getClusterState()),
    }
        verify(resolverFromContext, atLeastOnce()).concreteIndexNames(
public class OpenSearchTableScanRuleTests extends BasePlannerRulesTests {
    public void testOnMatchRoutesThroughResolverFromPlannerContext() {  
     * else (single-shard parquet test_index with intFields).  
import static org.mockito.ArgumentMatchers.same;
package org.opensearch.analytics.planner;
}
 * compatible open source license.
        return new PlannerContext(baseline.getCapabilityRegistry(), baseline.getClusterState(), resolver, false);  
        // gone through THIS resolver, not constructed its own.  
 * silently constructs a fresh {@link IndexNameExpressionResolver} inside the rule would bypass
import static org.mockito.Mockito.verify;
 * SPDX-License-Identifier: Apache-2.0
        // proceed past resolution. The verify() afterwards is the contract: the rule must have
    /**  
import org.opensearch.action.support.IndicesOptions;  
import org.opensearch.cluster.ClusterState;
 * Pins the wiring contract between {@link OpenSearchTableScanRule} and {@link PlannerContext}:
 */  
        // Drive the rule via the standard planner-program runner; any rule outcome (transform or
            org.mockito.ArgumentMatchers.anyBoolean(),
/**
import static org.mockito.Mockito.when;
        // re-wrap with the resolver-bearing 4-arg ctor.
import static org.mockito.Mockito.atLeastOnce;
     * Mirrors {@link BasePlannerRulesTests#buildContext(String, java.util.Map)} for everything
    private PlannerContext buildContextWithResolver(IndexNameExpressionResolver resolver) {
import static org.mockito.ArgumentMatchers.any;
import org.apache.calcite.plan.RelOptTable;
        when(
        // Reuse the standard context to get its mocked ClusterState / CapabilityRegistry, then  
import org.opensearch.analytics.planner.rules.OpenSearchTableScanRule;
 *
import org.apache.calcite.rel.RelNode;
            eq(new String[] { "test_index" })
 */  
        // no-op) is acceptable here — the assertion is "did the rule call THIS resolver?".  
        ).thenReturn(new String[] { "test_index" });  
 * security-plugin extensions / system-index access checks attached to the cluster's resolver.
 * The OpenSearch Contributors require contributions made to  
        );  
        RelNode ignored = runPlanner(stubScan(table), context);
        RelOptTable table = mockTable("test_index", "status", "size");  
                any(IndicesOptions.class),
            resolverFromContext.concreteIndexNames(  
        assertNotNull(ignored);
            any(IndicesOptions.class),  
            )
import static org.mockito.ArgumentMatchers.eq;  
    }
 * the rule resolves table names through the resolver supplied by the context. A regression that  
import static org.mockito.Mockito.mock;  
        // Resolver supplied via PlannerContext — answers concreteIndexNames so the rule can
                any(String[].class)
        PlannerContext context = buildContextWithResolver(resolverFromContext);
     */
     * Builds a PlannerContext that wires the given resolver through the 4-arg constructor.
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
 * this file be licensed under the Apache-2.0 license or a
        PlannerContext baseline = buildContext("parquet", intFields());
                any(ClusterState.class),
                org.mockito.ArgumentMatchers.anyBoolean(),  
        IndexNameExpressionResolver resolverFromContext = mock(IndexNameExpressionResolver.class);
