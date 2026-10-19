    public List<RestHandler> getRestHandlers(  
import org.opensearch.plugins.ActionPlugin;
import java.util.function.Supplier;
        ClusterSettings clusterSettings,  
        Settings settings,
    }
import org.opensearch.common.settings.Settings;
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
import org.opensearch.cluster.node.DiscoveryNodes;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.settings.SettingsFilter;  
import java.util.List;  
}
import org.opensearch.common.settings.IndexScopedSettings;
        SettingsFilter settingsFilter,
    ) {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.plugins.Plugin;
import org.opensearch.common.settings.ClusterSettings;  
        RestController restController,
        IndexNameExpressionResolver indexNameExpressionResolver,  
import org.opensearch.rest.RestController;  
import org.opensearch.rest.RestHandler;
        return List.of(new RandomnessProviderNameAction());  
public class FipsSmokeTestPlugin extends Plugin implements ActionPlugin {  
        Supplier<DiscoveryNodes> nodesInCluster
        IndexScopedSettings indexScopedSettings,
 */  
/*  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
package org.opensearch;
    @Override
 *
