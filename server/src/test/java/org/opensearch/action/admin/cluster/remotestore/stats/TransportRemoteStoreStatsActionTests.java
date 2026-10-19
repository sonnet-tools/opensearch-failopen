            .build();  
public class TransportRemoteStoreStatsActionTests extends IndexShardTestCase {
                    .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
import org.opensearch.indices.replication.common.ReplicationType;
    private TransportService transportService;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY;
                settings(Version.CURRENT).put(SETTING_INDEX_UUID, NEW_INDEX.getUUID()).put(SETTING_REMOTE_STORE_ENABLED, false).build()
            .metadata(metadata)
            .settings(
        MockTransport mockTransport = new MockTransport();  
        );  
        routingTable.allShards(concreteIndices)
            remoteStoreStatsTrackerFactory
            null,  
        IndexService newIndexService = mock(IndexService.class);  
            .addAsNew(indexMetadataWithoutRemoteStore)
import org.opensearch.cluster.node.DiscoveryNodes;  
package org.opensearch.action.admin.cluster.remotestore.stats;
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;  
        statsAction = new TransportRemoteStoreStatsAction(
import static org.mockito.ArgumentMatchers.any;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
    public void testAllShardCopies() throws Exception {  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
        when(remoteStoreStatsTrackerFactory.getRemoteSegmentTransferTracker(any())).thenReturn(mock(RemoteSegmentTransferTracker.class));
            )  
            );
        Metadata metadata = Metadata.builder().put(remoteStoreIndexMetadata, false).build();
                settings(Version.CURRENT).put(SETTING_INDEX_UUID, INDEX.getUUID())
        doReturn(new PlainShardsIterator(routingTable.allShards(INDEX.getName()).stream().map(Mockito::spy).collect(Collectors.toList())))
        indicesService = mock(IndicesService.class);
            clusterService.state(),
 * SPDX-License-Identifier: Apache-2.0
        ShardsIterator shardsIterator = statsAction.shards(
 * The OpenSearch Contributors require contributions made to  
    }
        assertEquals(shardsIterator.size(), 4);  
            .when(routingTable)
            clusterService,  
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT).metadata(metadata).routingTable(routingTable).build();  
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)  
        localNode = new DiscoveryNode("node0", buildNewFakeTransportAddress(), Version.CURRENT);
            .build();  
import org.opensearch.indices.IndicesService;
 * this file be licensed under the Apache-2.0 license or a
        RoutingTable routingTable = RoutingTable.builder()
        when(indexService.getIndexSettings()).thenReturn(new IndexSettings(remoteStoreIndexMetadata, Settings.EMPTY));
            .numberOfShards(2)
                shardRouting -> doReturn(shardRouting.shardId().id() == 0 ? "node1" : localNode.getId()).when(shardRouting).currentNodeId()  
import org.opensearch.cluster.node.DiscoveryNode;
    private static final Index INDEX = new Index("testIndex", "testUUID");  
    private TransportRemoteStoreStatsAction statsAction;
                    .build()
import org.opensearch.common.settings.ClusterSettings;
            .build();
import static org.mockito.Mockito.doReturn;
import org.opensearch.core.index.Index;
import static org.mockito.Mockito.when;
                    .put(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "my-test-repo")
        IndexMetadata indexMetadataWithoutRemoteStore = IndexMetadata.builder(NEW_INDEX.getName())  
            .allShards(concreteIndices);  
        super.setUp();
        ShardsIterator shardsIterator = statsAction.shards(  
            .settings(  
            .build();
        clusterService = mock(ClusterService.class);
            )  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
        transportService.close();
        RemoteStoreStatsRequest remoteStoreStatsRequest = new RemoteStoreStatsRequest();  
        RoutingTable routingTable = RoutingTable.builder().addAsNew(remoteStoreIndexMetadata).build();
    private IndexMetadata remoteStoreIndexMetadata;
import org.opensearch.cluster.metadata.IndexMetadata;
        when(clusterService.getClusterSettings()).thenReturn(
import java.util.stream.Collectors;
    }
        );  
        assertEquals(shardsIterator.size(), 4);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
            .addAsNew(remoteStoreIndexMetadata)  
        );
        remoteStoreStatsTrackerFactory = mock(RemoteStoreStatsTrackerFactory.class);
import org.opensearch.transport.TransportService;
        when(clusterService.getClusterSettings()).thenReturn(
    private RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory;  
            mock(IndexNameExpressionResolver.class),
        when(clusterService.state()).thenReturn(clusterState);
            new RemoteStoreStatsRequest(),
import static org.mockito.Mockito.mock;  
        Index NEW_INDEX = new Index("newIndex", "newUUID");
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT).metadata(metadata).routingTable(routingTable).build();
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
        IndexService indexService = mock(IndexService.class);  
import org.opensearch.cluster.routing.ShardsIterator;  
            threadPool,  
import org.opensearch.common.settings.Settings;  
            .numberOfReplicas(1)
            clusterService.state(),
        when(clusterService.state()).thenReturn(clusterState);
        clusterService.close();  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        when(indicesService.indexService(NEW_INDEX)).thenReturn(newIndexService);  
    private IndicesService indicesService;
        transportService = mockTransport.createTransportService(
import org.opensearch.index.remote.RemoteStoreStatsTrackerFactory;
        when(newIndexService.getIndexSettings()).thenReturn(new IndexSettings(indexMetadataWithoutRemoteStore, Settings.EMPTY));
                    .put(SETTING_REMOTE_STORE_ENABLED, true)  
        String[] concreteIndices = new String[] { INDEX.getName() };
import java.util.Collections;
            .numberOfShards(2)
    }
import org.opensearch.cluster.routing.PlainShardsIterator;
 */  
    private DiscoveryNode localNode;
            Settings.EMPTY,
            x -> localNode,
            indicesService,
        when(indicesService.indexService(INDEX)).thenReturn(indexService);  
 *
}
            new RemoteStoreStatsRequest(),  
    private ClusterService clusterService;  
import org.opensearch.index.remote.RemoteSegmentTransferTracker;
        Metadata metadata = Metadata.builder().put(remoteStoreIndexMetadata, false).put(indexMetadataWithoutRemoteStore, false).build();  
            transportService,
        remoteStoreIndexMetadata = IndexMetadata.builder(INDEX.getName())
import static org.mockito.Mockito.spy;
            .numberOfReplicas(1)
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_INDEX_UUID;  
        Metadata metadata = Metadata.builder().put(remoteStoreIndexMetadata, false).build();
        when(clusterService.getClusterSettings()).thenReturn(
            new String[] { INDEX.getName() }  
import org.mockito.Mockito;
            new String[] { INDEX.getName() }
    @Override
    }
import org.opensearch.test.transport.MockTransport;
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()))  
import org.opensearch.cluster.routing.RoutingTable;
            mock(ActionFilters.class),  
    public void tearDown() throws Exception {
            Collections.emptySet(),
        );
        remoteStoreStatsRequest.local(true);
            .routingTable(routingTable)
import org.opensearch.action.support.ActionFilters;
    public void testOnlyLocalShards() throws Exception {
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.index.shard.IndexShardTestCase;  
        );
import org.opensearch.Version;
        indicesService.close();
import org.opensearch.cluster.metadata.Metadata;
        super.tearDown();  
        );
        ShardsIterator shardsIterator = statsAction.shards(clusterService.state(), remoteStoreStatsRequest, concreteIndices);
 * compatible open source license.
import org.opensearch.index.IndexService;
        );
            NoopTracer.INSTANCE
            .forEach(
        RoutingTable routingTable = spy(RoutingTable.builder().addAsNew(remoteStoreIndexMetadata).build());  
        assertEquals(shardsIterator.size(), 2);
import org.opensearch.cluster.ClusterState;
/*  
    public void setUp() throws Exception {  
    @Override
import org.opensearch.cluster.ClusterName;  
    public void testOnlyRemoteStoreEnabledShardCopies() throws Exception {
import org.opensearch.index.IndexSettings;  
    }
        when(clusterService.state()).thenReturn(clusterState);
