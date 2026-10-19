 * The OpenSearch Contributors require contributions made to  
     * @return RemoteRoutingTableService  
    ) {
import java.util.function.Supplier;  
        ClusterSettings clusterSettings,
     * Returns {@code DefaultRemoteRoutingTableService} if the feature is enabled, otherwise {@code NoopRemoteRoutingTableService}
import org.opensearch.common.settings.Settings;
/**
    public static RemoteRoutingTableService getService(
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.isRemoteRoutingTableConfigured;
package org.opensearch.cluster.routing.remote;
 * Factory to provide impl for RemoteRoutingTableService based on settings.
 * this file be licensed under the Apache-2.0 license or a
        }
 *
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        ThreadPool threadPool,  
     * @param clusterSettings clusterSettings
    }
/*  
        Supplier<RepositoriesService> repositoriesService,  
        return new NoopRemoteRoutingTableService();  
     * @param settings settings  
     */
}
        Settings settings,
        String clusterName
 */  
     * @param threadPool threadPool
        if (isRemoteRoutingTableConfigured(settings)) {  
import org.opensearch.threadpool.ThreadPool;
     * @param repositoriesService repositoriesService
            return new InternalRemoteRoutingTableService(repositoriesService, settings, clusterSettings, threadPool, clusterName);
    /**  
import org.opensearch.repositories.RepositoriesService;  
 */  
public class RemoteRoutingTableServiceFactory {
import org.opensearch.common.settings.ClusterSettings;
