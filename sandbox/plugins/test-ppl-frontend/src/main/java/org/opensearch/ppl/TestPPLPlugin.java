 *
        RestController restController,  
    public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
import org.opensearch.plugins.ActionPlugin;  
 * Example front-end plugin using analytics-engine.
 */  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.IndexScopedSettings;
import org.opensearch.common.settings.ClusterSettings;
}  
import org.opensearch.plugins.Plugin;
/*  
import org.opensearch.ppl.action.RestPPLQueryAction;  
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
    @Override
import org.opensearch.common.settings.Settings;  
/**  
    }
import org.opensearch.core.action.ActionResponse;
 * are received by {@link TestPPLTransportAction} via Guice injection.  
        return List.of(new ActionHandler<>(UnifiedPPLExecuteAction.INSTANCE, TestPPLTransportAction.class));  
    public List<RestHandler> getRestHandlers(
        return List.of(new RestPPLQueryAction());
import java.util.List;  
import org.opensearch.rest.RestController;  
    ) {  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.ppl.action.TestPPLTransportAction;
public class TestPPLPlugin extends Plugin implements ActionPlugin, ExtensiblePlugin {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
package org.opensearch.ppl;
        IndexScopedSettings indexScopedSettings,
        Supplier<DiscoveryNodes> nodesInCluster
 * compatible open source license.
        Settings settings,
import org.opensearch.rest.RestHandler;
    }
import org.opensearch.common.settings.SettingsFilter;
import org.opensearch.action.ActionRequest;
import org.opensearch.cluster.node.DiscoveryNodes;  
        ClusterSettings clusterSettings,
        SettingsFilter settingsFilter,  
 */
import java.util.function.Supplier;
import org.opensearch.plugins.ExtensiblePlugin;
    @Override  
 * SPDX-License-Identifier: Apache-2.0
        IndexNameExpressionResolver indexNameExpressionResolver,
 * {@code EngineContextProvider} and {@code QueryPlanExecutor}
