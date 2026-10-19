import org.opensearch.common.settings.ClusterSettings;
            .put(FsRepository.REPOSITORIES_COMPRESS_SETTING.getKey(), false)
 * The OpenSearch Contributors require contributions made to  
public class RemoteRoutingTableServiceFactoryTests extends OpenSearchTestCase {  
        threadPool.shutdown();
 */  
            threadPool,  
package org.opensearch.cluster.routing.remote;
        assertTrue(service instanceof InternalRemoteRoutingTableService);  
    public void testGetServiceWhenRemoteRoutingEnabled() {
import org.junit.After;
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY;
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
/*  
    private ThreadPool threadPool = new TestThreadPool(getClass().getName());  
        assertTrue(service instanceof NoopRemoteRoutingTableService);
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.test.OpenSearchTestCase;
 *
import java.util.function.Supplier;
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_PUBLICATION_SETTING_KEY;  
    }  
    public void teardown() throws Exception {  
    public void testGetServiceWhenRemoteRoutingDisabled() {
            repositoriesService,  
            .build();
import org.opensearch.repositories.RepositoriesService;  
        Settings settings = Settings.builder().build();  
import org.opensearch.repositories.fs.FsRepository;
}  
            .put(REMOTE_PUBLICATION_SETTING_KEY, "true")  
        RemoteRoutingTableService service = RemoteRoutingTableServiceFactory.getService(
        super.tearDown();
        Settings settings = Settings.builder()  
            "test-cluster"  
    }  
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, "routing_repository")
            settings,  
 * compatible open source license.
import org.opensearch.common.settings.Settings;
            threadPool,
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            settings,
            repositoriesService,
    @After
    }
            "test-cluster"
    Supplier<RepositoriesService> repositoriesService;
        );
        );
import org.opensearch.threadpool.TestThreadPool;  
        RemoteRoutingTableService service = RemoteRoutingTableServiceFactory.getService(
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
