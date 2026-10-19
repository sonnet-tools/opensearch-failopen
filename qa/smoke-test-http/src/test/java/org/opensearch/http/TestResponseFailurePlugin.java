import org.opensearch.common.settings.SettingsFilter;  
        IndexNameExpressionResolver indexNameExpressionResolver,  
import org.opensearch.plugins.ActionPlugin;
import org.opensearch.common.settings.Settings;
        SettingsFilter settingsFilter,
        RestController restController,
import static java.util.Collections.singletonList;  
 * Registers {@link TestResponseFailureRestAction}, which is used to exercise the REST layer's behaviour when a  
 */  
    ) {
    @Override
        return singletonList(new TestResponseFailureRestAction());  
        IndexScopedSettings indexScopedSettings,
        Settings settings,
 * response body cannot be serialized.
 */
 * compatible open source license.
        Supplier<DiscoveryNodes> nodesInCluster
public class TestResponseFailurePlugin extends Plugin implements ActionPlugin {  
        ClusterSettings clusterSettings,  
import java.util.List;  
import org.opensearch.common.settings.IndexScopedSettings;
/*  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
}
import org.opensearch.cluster.node.DiscoveryNodes;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.plugins.Plugin;
import java.util.function.Supplier;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.rest.RestHandler;
import org.opensearch.common.settings.ClusterSettings;  
/**
    }
package org.opensearch.http;
    public List<RestHandler> getRestHandlers(  
 *
import org.opensearch.rest.RestController;  
