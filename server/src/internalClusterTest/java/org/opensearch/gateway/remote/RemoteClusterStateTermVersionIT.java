                ctrEnty.getValue().incrementAndGet();
                // not committing the state
        );
    public void testRemoteClusterStateFallback() throws Exception {
    }
    }
        RemoteClusterStateService remoteClusterStateService = internalCluster().getClusterManagerNodeInstance(
    private BlobStoreRepository prepareClusterAndVerifyRepository() throws Exception {
            Map.entry(GetTermVersionAction.NAME, new AtomicInteger())
        ClusterStateResponse stateResponseD = client(dataNodes[0]).admin().cluster().state(new ClusterStateRequest()).actionGet();
import org.opensearch.action.support.clustermanager.term.GetTermVersionAction;
import org.opensearch.test.transport.MockTransportService;
        }
        );
            )
        MockTransportService primaryService = (MockTransportService) internalCluster().getInstance(TransportService.class, dataNodes[0]);
import org.opensearch.cluster.coordination.PublicationTransportHandler;
        clusterSettingsSuppliedByTest = true;
import org.opensearch.core.transport.TransportResponse;
                channel.sendResponse(TransportResponse.Empty.INSTANCE);
            Map.entry(ClusterStateAction.NAME, new AtomicInteger()),
        );
        return repository;
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
            .build();
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        Optional<ClusterMetadataManifest> latestManifest = remoteManifestManager.getLatestClusterMetadataManifest(
            });
    private static final String INDEX_NAME_1 = "test-index-1";
    private final RemoteStoreEnums.PathType pathType = RemoteStoreEnums.PathType.HASHED_PREFIX;
    }
        logger.info("created index {}", index);
            .put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)
import static org.hamcrest.Matchers.is;
    @Override
                RemoteRoutingTableBlobStore.REMOTE_ROUTING_TABLE_PATH_TYPE_SETTING.getKey(),
        RemoteManifestManager remoteManifestManager = remoteClusterStateService.getRemoteManifestManager();
        );
            Map.entry(GetTermVersionAction.NAME, new AtomicInteger())
        MockTransportService primaryService = (MockTransportService) internalCluster().getInstance(TransportService.class, nodeName);
    }
            (handler, request, channel, task) -> {
        assertEquals(stateResponseM, stateResponseD);
            (handler, request, channel, task) -> {
        return Settings.builder()
            }
            channel.sendResponse(
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        asyncUploadMockFsRepo = false;
        RemoteClusterStateService remoteClusterStateService = internalCluster().getClusterManagerNodeInstance(
        for (var ctrEnty : callCounters.entrySet()) {
        String[] dataNodes = internalCluster().getDataNodeNames().toArray(String[]::new);
        primaryService.addRequestHandlingBehavior(
        String cm = internalCluster().getClusterManagerName();
            PublicationTransportHandler.COMMIT_STATE_ACTION_NAME,
import org.opensearch.repositories.RepositoriesService;
}
import org.opensearch.common.blobstore.BlobPath;
        );
            .put(REMOTE_PUBLICATION_SETTING_KEY, true)
import org.opensearch.transport.TransportService;
        ClusterStateResponse stateResponseM = client(cm).admin().cluster().state(new ClusterStateRequest()).actionGet();
        Map<String, AtomicInteger> callCounters = Map.ofEntries(
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        BlobStoreRepository repository = prepareClusterAndVerifyRepository();
import org.opensearch.action.admin.cluster.state.ClusterStateAction;
        cmservice.addRequestHandlingBehavior(GetTermVersionAction.NAME, (handler, request, channel, task) -> {
import org.opensearch.cluster.ClusterState;
        );
            index,
 * The OpenSearch Contributors require contributions made to
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY;
import org.opensearch.action.support.clustermanager.term.GetTermVersionResponse;
    public void setup() {
        String[] dataNodes = internalCluster().getDataNodeNames().toArray(String[]::new);
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, REMOTE_ROUTING_TABLE_REPO)
    private void addCallCountInterceptor(String nodeName, Map<String, AtomicInteger> callCounters) {
        RemoteManifestManager remoteManifestManager = remoteClusterStateService.getRemoteManifestManager();
import java.util.Map;
 * this file be licensed under the Apache-2.0 license or a
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        addCallCountInterceptor(cm, callCounters);
    List<BlobPath> indexRoutingPaths;
                .put(MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING.getKey(), Long.MAX_VALUE)
    AtomicInteger indexRoutingFiles = new AtomicInteger();
            Settings.builder()
            REPOSITORY_2_NAME,
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            PublicationTransportHandler.COMMIT_STATE_ACTION_NAME,
import java.util.List;
        MockTransportService cmservice = (MockTransportService) internalCluster().getInstance(TransportService.class, cm);
import org.opensearch.index.mapper.MapperService;
        assertThat(callCounters.get(GetTermVersionAction.NAME).get(), is(1));
    public void testNoRemoteClusterStateFound() throws Exception {
import java.util.Optional;
            RemoteClusterStateService.class
            }
            getClusterState().getClusterName().value(),
            REMOTE_ROUTING_TABLE_REPO,
        Optional<ClusterMetadataManifest> latestManifest = remoteManifestManager.getLatestClusterMetadataManifest(
        MockTransportService primaryService = (MockTransportService) internalCluster().getInstance(TransportService.class, dataNodes[0]);
            getClusterState().getClusterName().value(),
            primaryService.addRequestHandlingBehavior(ctrEnty.getKey(), (handler, request, channel, task) -> {
        );
        BlobStoreRepository repository = prepareClusterAndVerifyRepository();
                .build()
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.cluster.coordination.ClusterStateTermVersion;
 */
package org.opensearch.gateway.remote;
        Path remoteRoutingTableRepoPath = randomRepoPath();
                logger.info("-->  {} response redirect", ctrEnty.getKey());
import org.opensearch.plugins.Plugin;
import org.opensearch.index.remote.RemoteStoreEnums;
public class RemoteClusterStateTermVersionIT extends RemoteStoreBaseIntegTestCase {
        String index = "index_1";
                logger.info("ignoring the commit from cluster-manager {}", request);
import java.util.concurrent.atomic.AtomicInteger;
 *
import org.opensearch.test.OpenSearchIntegTestCase;
        assertThat(callCounters.get(ClusterStateAction.NAME).get(), is(1));
 * compatible open source license.
            .put(
                handler.messageReceived(request, channel, task);
            REPOSITORY_NAME,
        assertEquals(stateResponseM, stateResponseD);
        assertThat(callCounters.get(GetTermVersionAction.NAME).get(), is(1));
        Path translogRepoPath = randomRepoPath();
                RemoteStoreEnums.PathType.HASHED_PREFIX.toString()
        return List.of(MockTransportService.TestPlugin.class);
import org.opensearch.cluster.metadata.IndexMetadata;
            RemoteClusterStateService.class
        ClusterState state = internalCluster().clusterService().state();
 * SPDX-License-Identifier: Apache-2.0
        addCallCountInterceptor(cm, callCounters);
            getClusterState().getMetadata().clusterUUID()
import org.opensearch.gateway.remote.model.RemoteRoutingTableBlobStore;
        );
            getClusterState().getMetadata().clusterUUID()
            Map.entry(ClusterStateAction.NAME, new AtomicInteger()),
            );
        );
            false
                channel.sendResponse(TransportResponse.Empty.INSTANCE);
            remoteRoutingTableRepoPath,
        ClusterStateResponse stateResponseM = client(cm).admin().cluster().state(new ClusterStateRequest()).actionGet();
        RepositoriesService repositoriesService = internalCluster().getClusterManagerNodeInstance(RepositoriesService.class);
/*
    }
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING;
        Settings settings = buildRemoteStoreNodeAttributes(
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_PUBLICATION_SETTING_KEY;
        BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(REMOTE_ROUTING_TABLE_REPO);
            translogRepoPath,
        ensureGreen(INDEX_NAME);
        Map<String, AtomicInteger> callCounters = Map.ofEntries(
                new GetTermVersionResponse(new ClusterStateTermVersion(state.getClusterName(), state.stateUUID(), -1, -1), true)
        createIndex(
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
    }
import org.junit.Before;
import java.nio.file.Path;
        Path segmentRepoPath = randomRepoPath();
    @Before
        );
                // not committing the state
            segmentRepoPath,
import java.util.Collection;
        ClusterStateResponse stateResponseD = client(dataNodes[0]).admin().cluster().state(new ClusterStateRequest()).actionGet();
        String cm = internalCluster().getClusterManagerName();
        });
    protected Settings nodeSettings(int nodeOrdinal) {
            .put(super.nodeSettings(nodeOrdinal))
        primaryService.addRequestHandlingBehavior(
                logger.info("ignoring the commit from cluster-manager {}", request);
        assertThat(callCounters.get(ClusterStateAction.NAME).get(), is(0));
        prepareCluster(1, 3, INDEX_NAME, 1, 5, settings);
import org.opensearch.common.settings.Settings;
    }
    private static final String INDEX_NAME = "test-index";
