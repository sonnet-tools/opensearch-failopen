 *
            injectedResolver,
import static org.mockito.Mockito.atLeastOnce;  
            )
        ClusterService clusterService = mock(ClusterService.class);  
        // (in IndexResolution.resolve's fallback path), which is what we're pinning.
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        // Trigger a lazy resolve so the resolver is actually invoked. Cluster state has no  
 * The OpenSearch Contributors require contributions made to  
 * carries security-plugin extensions and system-index access rules) into
    public void testGetContextUsesInjectedResolver() {
        );
            injectedResolver.concreteIndexNames(  
import static org.mockito.ArgumentMatchers.any;
 * Pins the security-wiring contract for {@link AnalyticsPlugin.DefaultEngineContextProvider}:  
public class DefaultEngineContextProviderTests extends OpenSearchTestCase {  
import static org.mockito.ArgumentMatchers.same;
 * this file be licensed under the Apache-2.0 license or a
        );  
            same(clusterState),  
        AnalyticsPlugin.DefaultEngineContextProvider ctx = new AnalyticsPlugin.DefaultEngineContextProvider(
/*  
        verify(injectedResolver, atLeastOnce()).concreteIndexNames(
import org.opensearch.cluster.ClusterName;  
import static org.mockito.Mockito.verify;
 */  
                any(String[].class)
package org.opensearch.analytics;
 * {@code getContext()} must thread the cluster's {@link IndexNameExpressionResolver} (which
 * regression to the single-arg buildSchema(state) overload would bypass those checks.
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.metadata.Metadata;  
 */
import static org.mockito.Mockito.mock;
        SchemaPlus schema = ctx.getContext().schema();
        ).thenReturn(new String[0]);  
            null
        when(
            any(String[].class)  
 * {@code OpenSearchSchemaBuilder.buildSchema}, not silently construct a fresh resolver. A  
 * compatible open source license.
import org.opensearch.action.support.IndicesOptions;
import org.apache.calcite.schema.SchemaPlus;
        schema.getTable("any_table");  
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder().build()).build();
        when(clusterService.state()).thenReturn(clusterState);
                same(clusterState),
            any(IndicesOptions.class),
        IndexNameExpressionResolver injectedResolver = mock(IndexNameExpressionResolver.class);
                any(IndicesOptions.class),
        // indices, so the lookup returns null — but the resolver gets called along the way
import org.opensearch.cluster.service.ClusterService;
    }
            org.mockito.ArgumentMatchers.anyBoolean(),
 * SPDX-License-Identifier: Apache-2.0
                org.mockito.ArgumentMatchers.anyBoolean(),  
}  
/**
            clusterService,  
import static org.mockito.Mockito.when;  
