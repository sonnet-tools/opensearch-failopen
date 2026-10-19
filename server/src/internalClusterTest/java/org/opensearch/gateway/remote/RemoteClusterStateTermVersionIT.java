        for (var ctrEnty : callCounters.entrySet()) {
        String index = "index_1";
        Map<String, AtomicInteger> callCounters = Map.ofEntries(
import org.opensearch.cluster.ClusterState;  
                // not committing the state
import org.opensearch.test.OpenSearchIntegTestCase;
        ensureGreen(INDEX_NAME);
 * this file be licensed under the Apache-2.0 license or a
        }
        );
import org.opensearch.plugins.Plugin;
        );
 * SPDX-License-Identifier: Apache-2.0
    List<BlobPath> indexRoutingPaths;
            getClusterState().getClusterName().value(),
    AtomicInteger indexRoutingFiles = new AtomicInteger();  
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_PUBLICATION_SETTING_KEY;  
import static org.hamcrest.Matchers.is;
import org.opensearch.common.blobstore.BlobPath;
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            }
                .put(MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING.getKey(), Long.MAX_VALUE)
        return repository;
    private static final String INDEX_NAME_1 = "test-index-1";
                logger.info("ignoring the commit from cluster-manager {}", request);
package org.opensearch.gateway.remote;
    @Override  
        BlobStoreRepository repository = prepareClusterAndVerifyRepository();  
        addCallCountInterceptor(cm, callCounters);
import java.util.Collection;
import org.opensearch.cluster.coordination.PublicationTransportHandler;
        RemoteClusterStateService remoteClusterStateService = internalCluster().getClusterManagerNodeInstance(
    public void setup() {
import java.util.concurrent.atomic.AtomicInteger;  
 *
import java.util.Optional;
                ctrEnty.getValue().incrementAndGet();
            segmentRepoPath,  
        clusterSettingsSuppliedByTest = true;  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY;
import org.opensearch.repositories.RepositoriesService;  
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        assertThat(callCounters.get(ClusterStateAction.NAME).get(), is(0));
import org.opensearch.cluster.coordination.ClusterStateTermVersion;
/*  
            REPOSITORY_2_NAME,
            false
            RemoteClusterStateService.class  
        );
        RemoteManifestManager remoteManifestManager = remoteClusterStateService.getRemoteManifestManager();
        );
    }
        primaryService.addRequestHandlingBehavior(  
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING;
        Path segmentRepoPath = randomRepoPath();
    }
        assertThat(callCounters.get(GetTermVersionAction.NAME).get(), is(1));
        Path translogRepoPath = randomRepoPath();
        RepositoriesService repositoriesService = internalCluster().getClusterManagerNodeInstance(RepositoriesService.class);
            Map.entry(ClusterStateAction.NAME, new AtomicInteger()),  
        );  
                // not committing the state  
        MockTransportService primaryService = (MockTransportService) internalCluster().getInstance(TransportService.class, dataNodes[0]);
            REPOSITORY_NAME,
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    public void testRemoteClusterStateFallback() throws Exception {
            (handler, request, channel, task) -> {  
        ClusterStateResponse stateResponseM = client(cm).admin().cluster().state(new ClusterStateRequest()).actionGet();  
            Map.entry(ClusterStateAction.NAME, new AtomicInteger()),
        BlobStoreRepository repository = prepareClusterAndVerifyRepository();
import org.opensearch.action.admin.cluster.state.ClusterStateAction;
        BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(REMOTE_ROUTING_TABLE_REPO);
            Map.entry(GetTermVersionAction.NAME, new AtomicInteger())
import org.opensearch.gateway.remote.model.RemoteRoutingTableBlobStore;
                handler.messageReceived(request, channel, task);  
    private BlobStoreRepository prepareClusterAndVerifyRepository() throws Exception {
        );  
import org.opensearch.transport.TransportService;
 * compatible open source license.
            getClusterState().getMetadata().clusterUUID()  
        MockTransportService cmservice = (MockTransportService) internalCluster().getInstance(TransportService.class, cm);
            .put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)
            .build();
                logger.info("-->  {} response redirect", ctrEnty.getKey());
                channel.sendResponse(TransportResponse.Empty.INSTANCE);
        String[] dataNodes = internalCluster().getDataNodeNames().toArray(String[]::new);
                logger.info("ignoring the commit from cluster-manager {}", request);
    private static final String INDEX_NAME = "test-index";  
            .put(REMOTE_PUBLICATION_SETTING_KEY, true)
        ClusterStateResponse stateResponseM = client(cm).admin().cluster().state(new ClusterStateRequest()).actionGet();
            }  
            Map.entry(GetTermVersionAction.NAME, new AtomicInteger())
        RemoteClusterStateService remoteClusterStateService = internalCluster().getClusterManagerNodeInstance(  
        Optional<ClusterMetadataManifest> latestManifest = remoteManifestManager.getLatestClusterMetadataManifest(
    }  
        );
            (handler, request, channel, task) -> {
    }  
    private void addCallCountInterceptor(String nodeName, Map<String, AtomicInteger> callCounters) {  
                new GetTermVersionResponse(new ClusterStateTermVersion(state.getClusterName(), state.stateUUID(), -1, -1), true)
 * The OpenSearch Contributors require contributions made to  
    private final RemoteStoreEnums.PathType pathType = RemoteStoreEnums.PathType.HASHED_PREFIX;
        prepareCluster(1, 3, INDEX_NAME, 1, 5, settings);
            index,  
            getClusterState().getClusterName().value(),  
        asyncUploadMockFsRepo = false;
            RemoteClusterStateService.class
import org.opensearch.test.transport.MockTransportService;  
    }  
            PublicationTransportHandler.COMMIT_STATE_ACTION_NAME,
import java.util.Map;
            channel.sendResponse(
        Optional<ClusterMetadataManifest> latestManifest = remoteManifestManager.getLatestClusterMetadataManifest(
            )
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
                RemoteRoutingTableBlobStore.REMOTE_ROUTING_TABLE_PATH_TYPE_SETTING.getKey(),  
}
        assertThat(callCounters.get(ClusterStateAction.NAME).get(), is(1));
public class RemoteClusterStateTermVersionIT extends RemoteStoreBaseIntegTestCase {
import org.opensearch.cluster.metadata.IndexMetadata;  
            Settings.builder()
        ClusterState state = internalCluster().clusterService().state();  
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;  
import java.nio.file.Path;
        });
        MockTransportService primaryService = (MockTransportService) internalCluster().getInstance(TransportService.class, dataNodes[0]);
                channel.sendResponse(TransportResponse.Empty.INSTANCE);  
import java.util.List;  
        Map<String, AtomicInteger> callCounters = Map.ofEntries(  
 */  
            REMOTE_ROUTING_TABLE_REPO,  
        RemoteManifestManager remoteManifestManager = remoteClusterStateService.getRemoteManifestManager();  
import org.opensearch.action.support.clustermanager.term.GetTermVersionAction;
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
import org.opensearch.common.settings.Settings;
        addCallCountInterceptor(cm, callCounters);
import org.junit.Before;
        primaryService.addRequestHandlingBehavior(
        );
            primaryService.addRequestHandlingBehavior(ctrEnty.getKey(), (handler, request, channel, task) -> {  
    }
            .put(super.nodeSettings(nodeOrdinal))  
        cmservice.addRequestHandlingBehavior(GetTermVersionAction.NAME, (handler, request, channel, task) -> {  
            });
        createIndex(
            PublicationTransportHandler.COMMIT_STATE_ACTION_NAME,
import org.opensearch.index.remote.RemoteStoreEnums;  
import org.opensearch.index.mapper.MapperService;
                RemoteStoreEnums.PathType.HASHED_PREFIX.toString()
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        assertEquals(stateResponseM, stateResponseD);  
    protected Settings nodeSettings(int nodeOrdinal) {
        ClusterStateResponse stateResponseD = client(dataNodes[0]).admin().cluster().state(new ClusterStateRequest()).actionGet();
            remoteRoutingTableRepoPath,
        String[] dataNodes = internalCluster().getDataNodeNames().toArray(String[]::new);  
        ClusterStateResponse stateResponseD = client(dataNodes[0]).admin().cluster().state(new ClusterStateRequest()).actionGet();
        );  
                .build()
        assertThat(callCounters.get(GetTermVersionAction.NAME).get(), is(1));
        return List.of(MockTransportService.TestPlugin.class);  
            .put(
        return Settings.builder()
import org.opensearch.core.transport.TransportResponse;  
            getClusterState().getMetadata().clusterUUID()
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, REMOTE_ROUTING_TABLE_REPO)  
        Settings settings = buildRemoteStoreNodeAttributes(
    }
    public void testNoRemoteClusterStateFound() throws Exception {  
        MockTransportService primaryService = (MockTransportService) internalCluster().getInstance(TransportService.class, nodeName);
        logger.info("created index {}", index);
            );  
    @Before  
        String cm = internalCluster().getClusterManagerName();
import org.opensearch.action.support.clustermanager.term.GetTermVersionResponse;
        Path remoteRoutingTableRepoPath = randomRepoPath();  
        );
        assertEquals(stateResponseM, stateResponseD);  
            translogRepoPath,
        String cm = internalCluster().getClusterManagerName();  
