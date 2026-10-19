            .build();
import static org.mockito.Mockito.doReturn;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
    private ClusterService clusterService;
                    .put(SETTING_REMOTE_STORE_ENABLED, true)
        assertEquals(shardsIterator.size(), 4);
import org.opensearch.cluster.routing.RoutingTable;
            mock(IndexNameExpressionResolver.class),
            .when(routingTable)
        );
        when(clusterService.getClusterSettings()).thenReturn(
            clusterService,
            clusterService.state(),
    @Override
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY;
            .settings(
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
        IndexService indexService = mock(IndexService.class);
        when(clusterService.state()).thenReturn(clusterState);
            .addAsNew(remoteStoreIndexMetadata)
        indicesService.close();
import org.opensearch.action.support.ActionFilters;
        Metadata metadata = Metadata.builder().put(remoteStoreIndexMetadata, false).build();
import org.opensearch.index.shard.IndexShardTestCase;
import org.opensearch.cluster.ClusterName;
 * compatible open source license.
        Index NEW_INDEX = new Index("newIndex", "newUUID");
            .build();
                    .build()
    }
import org.opensearch.cluster.ClusterState;
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()))
    private TransportRemoteStoreStatsAction statsAction;
    private static final Index INDEX = new Index("testIndex", "testUUID");
            .build();
        when(remoteStoreStatsTrackerFactory.getRemoteSegmentTransferTracker(any())).thenReturn(mock(RemoteSegmentTransferTracker.class));
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.indices.IndicesService;
 *
import static org.mockito.Mockito.when;
    private TransportService transportService;
                settings(Version.CURRENT).put(SETTING_INDEX_UUID, NEW_INDEX.getUUID()).put(SETTING_REMOTE_STORE_ENABLED, false).build()
        super.setUp();
/*
                shardRouting -> doReturn(shardRouting.shardId().id() == 0 ? "node1" : localNode.getId()).when(shardRouting).currentNodeId()
        assertEquals(shardsIterator.size(), 2);
        RoutingTable routingTable = spy(RoutingTable.builder().addAsNew(remoteStoreIndexMetadata).build());
                settings(Version.CURRENT).put(SETTING_INDEX_UUID, INDEX.getUUID())
            .build();
 * this file be licensed under the Apache-2.0 license or a
            transportService,
        remoteStoreStatsTrackerFactory = mock(RemoteStoreStatsTrackerFactory.class);
        Metadata metadata = Metadata.builder().put(remoteStoreIndexMetadata, false).put(indexMetadataWithoutRemoteStore, false).build();
        super.tearDown();
import org.opensearch.core.index.Index;
            new RemoteStoreStatsRequest(),
            Collections.emptySet(),
            .settings(
    private RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory;
            threadPool,
    }
        );
        );
        when(clusterService.state()).thenReturn(clusterState);
            .numberOfReplicas(1)
            .numberOfReplicas(1)
        transportService = mockTransport.createTransportService(
            new RemoteStoreStatsRequest(),
        IndexMetadata indexMetadataWithoutRemoteStore = IndexMetadata.builder(NEW_INDEX.getName())
import org.opensearch.index.IndexService;
        );
        statsAction = new TransportRemoteStoreStatsAction(
            )
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT).metadata(metadata).routingTable(routingTable).build();
        localNode = new DiscoveryNode("node0", buildNewFakeTransportAddress(), Version.CURRENT);
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
import org.opensearch.cluster.service.ClusterService;
}
            new String[] { INDEX.getName() }
import org.opensearch.cluster.routing.PlainShardsIterator;
                    .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        ShardsIterator shardsIterator = statsAction.shards(
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        indicesService = mock(IndicesService.class);
    }
import org.opensearch.index.remote.RemoteStoreStatsTrackerFactory;
    }
import static org.mockito.ArgumentMatchers.any;
        Metadata metadata = Metadata.builder().put(remoteStoreIndexMetadata, false).build();
 * The OpenSearch Contributors require contributions made to
        ShardsIterator shardsIterator = statsAction.shards(clusterService.state(), remoteStoreStatsRequest, concreteIndices);
        assertEquals(shardsIterator.size(), 4);
        clusterService = mock(ClusterService.class);
import org.opensearch.cluster.routing.ShardsIterator;
        );
import static org.mockito.Mockito.mock;
    private IndicesService indicesService;
        clusterService.close();
            .metadata(metadata)
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_INDEX_UUID;
            .forEach(
import org.mockito.Mockito;
            .numberOfShards(2)
import org.opensearch.Version;
import org.opensearch.index.remote.RemoteSegmentTransferTracker;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.ClusterSettings;
        );
        remoteStoreStatsRequest.local(true);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        routingTable.allShards(concreteIndices)
    public void testOnlyRemoteStoreEnabledShardCopies() throws Exception {
import org.opensearch.common.settings.Settings;
            new String[] { INDEX.getName() }
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
import org.opensearch.test.transport.MockTransport;
        RoutingTable routingTable = RoutingTable.builder()
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT).metadata(metadata).routingTable(routingTable).build();
        when(newIndexService.getIndexSettings()).thenReturn(new IndexSettings(indexMetadataWithoutRemoteStore, Settings.EMPTY));
        RemoteStoreStatsRequest remoteStoreStatsRequest = new RemoteStoreStatsRequest();
    @Override
        doReturn(new PlainShardsIterator(routingTable.allShards(INDEX.getName()).stream().map(Mockito::spy).collect(Collectors.toList())))
import static org.mockito.Mockito.spy;
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            null,
        when(indicesService.indexService(NEW_INDEX)).thenReturn(newIndexService);
            .addAsNew(indexMetadataWithoutRemoteStore)
            )
import org.opensearch.cluster.metadata.IndexMetadata;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
 */
            .routingTable(routingTable)
            x -> localNode,
        ShardsIterator shardsIterator = statsAction.shards(
        );
        when(indexService.getIndexSettings()).thenReturn(new IndexSettings(remoteStoreIndexMetadata, Settings.EMPTY));
            .allShards(concreteIndices);
        MockTransport mockTransport = new MockTransport();
            indicesService,
import org.opensearch.cluster.metadata.Metadata;
            Settings.EMPTY,
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    private DiscoveryNode localNode;
    public void testOnlyLocalShards() throws Exception {
            clusterService.state(),
        when(clusterService.state()).thenReturn(clusterState);
        when(indicesService.indexService(INDEX)).thenReturn(indexService);
        IndexService newIndexService = mock(IndexService.class);
public class TransportRemoteStoreStatsActionTests extends IndexShardTestCase {
            mock(ActionFilters.class),
import org.opensearch.cluster.node.DiscoveryNodes;
    public void setUp() throws Exception {
    }
    public void testAllShardCopies() throws Exception {
        when(clusterService.getClusterSettings()).thenReturn(
        transportService.close();
            remoteStoreStatsTrackerFactory
package org.opensearch.action.admin.cluster.remotestore.stats;
import java.util.stream.Collectors;
import org.opensearch.indices.replication.common.ReplicationType;
            .numberOfShards(2)
    private IndexMetadata remoteStoreIndexMetadata;
    public void tearDown() throws Exception {
        RoutingTable routingTable = RoutingTable.builder().addAsNew(remoteStoreIndexMetadata).build();
        remoteStoreIndexMetadata = IndexMetadata.builder(INDEX.getName())
            NoopTracer.INSTANCE
        when(clusterService.getClusterSettings()).thenReturn(
            );
import org.opensearch.index.IndexSettings;
        String[] concreteIndices = new String[] { INDEX.getName() };
                    .put(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "my-test-repo")
import org.opensearch.transport.TransportService;
import java.util.Collections;
