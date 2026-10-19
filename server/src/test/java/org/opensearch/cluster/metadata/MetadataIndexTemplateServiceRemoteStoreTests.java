            .add(IndexShardTestUtils.getFakeSegmentsOnlyNode("node2"))
        Settings settings = Settings.builder().put(PATH_HOME_SETTING.getKey(), "dummy").build();  
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        IndicesService indicesServices = mock(IndicesService.class);
import static org.hamcrest.Matchers.containsString;
        PutRequest request = new PutRequest("test", "test_index_primary_shard_constraint_empty");  
/*  
            DefaultRemoteStoreSettings.INSTANCE,
        when(clusterService.state()).thenReturn(clusterState);
import java.util.Collections;
        PutRequest request = new PutRequest("test", "test_index_primary_shard_constraint_mixed");
            clusterService,
        request.settings(
            .build();
            builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")
            .build();  
            null,
 * <p>Kept in its own class (rather than {@link MetadataIndexTemplateServiceTests}) because these cases are
        PutRequest request = new PutRequest("test", "test_index_primary_shard_constraint_remote");
 *
        assertThat(throwables.get(0).getMessage(), containsString("can only be used with remote store enabled clusters"));
import java.util.ArrayList;
import static org.opensearch.indices.ShardLimitValidatorTests.createTestShardLimitService;
import static java.util.Collections.singletonList;
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.cluster.metadata.MetadataIndexTemplateService.PutRequest;  
            new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),  
            public void onResponse(MetadataIndexTemplateService.PutResponse response) {}
import static org.hamcrest.Matchers.empty;  
import org.opensearch.cluster.service.ClusterService;  
 */
            builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")
import org.opensearch.indices.replication.common.ReplicationType;
            null,
        );  
        List<Throwable> throwables = putTemplate(xContentRegistry(), request, remoteNodes);
        // Mixed cluster (one non-remote node) → not every node is a remote-store node, so the
    }
                .build()  
            .add(IndexShardTestUtils.getFakeDiscoNode("plain1"))
        );  
        // !nodes.isEmpty() guard must reject). Covers the empty-node branch of the hardened check.
    public void testTotalPrimaryShardsTemplateRejectedWhenSomeNodeIsNotRemoteStore() {
        // Every node is a remote-store node → the template must validate successfully.  
import org.opensearch.indices.SystemIndices;  
        request.settings(  
            .add(IndexShardTestUtils.getFakeRemoteEnabledNode("node2"))
import org.opensearch.index.shard.IndexShardTestUtils;  
import static org.hamcrest.Matchers.not;
        List<Throwable> throwables = putTemplate(xContentRegistry(), request, segmentsOnlyNodes);
            Settings.EMPTY,  
 * the randomized method ordering of that (state-sharing) suite.
import static org.mockito.Mockito.mock;  
        request.patterns(singletonList("test_shards_wait*"));  
            createIndexService,  
            true,
import static org.opensearch.common.settings.Settings.builder;
        assertThat(throwables.get(0), instanceOf(IllegalArgumentException.class));  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")  
        request.patterns(singletonList("test_shards_wait*"));
        DiscoveryNodes remoteNodes = DiscoveryNodes.builder()
        );
        assertThat(throwables, empty());
 * fully mock-driven and do not need the shared single-node fixture; isolating them also avoids perturbing  
                .put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 2)
    private static List<Throwable> putTemplate(NamedXContentRegistry xContentRegistry, PutRequest request, DiscoveryNodes discoveryNodes) {
import org.opensearch.common.settings.Settings;  
        // setting must be rejected. Covers the allMatch==false branch of the hardened check.  
import org.opensearch.common.settings.IndexScopedSettings;
            null
    public void testTotalPrimaryShardsTemplateValidatesOnRemoteStoreCluster() {
            @Override
import org.opensearch.indices.IndicesService;
    }
    }
        assertThat(throwables, not(empty()));
            clusterService,
            new Environment(builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString()).build(), null),  
    }  
            indicesServices,
        Metadata metadata = Metadata.builder().build();
import org.opensearch.core.xcontent.NamedXContentRegistry;
            .metadata(metadata)
        MetadataIndexTemplateService service = new MetadataIndexTemplateService(
            @Override
import org.opensearch.cluster.ClusterState;
 * Tests that index-template validation of {@code index.routing.allocation.total_primary_shards_per_node}
                .build()
        );  
        List<Throwable> throwables = putTemplate(xContentRegistry(), request, DiscoveryNodes.EMPTY_NODES);
public class MetadataIndexTemplateServiceRemoteStoreTests extends OpenSearchTestCase {  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.ClusterName;
        DiscoveryNodes segmentsOnlyNodes = DiscoveryNodes.builder()  
                .put(INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT.toString())
            xContentRegistry,  
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_REPLICATION_TYPE_SETTING;  
import org.opensearch.indices.DefaultRemoteStoreSettings;
        PutRequest request = new PutRequest("test", "test_index_primary_shard_constraint_segments_only");
import static org.opensearch.env.Environment.PATH_HOME_SETTING;  
        );  
                .put(INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT.toString())
    }
        DiscoveryNodes mixedNodes = DiscoveryNodes.builder()
            null
            new AliasValidator(),
            new SystemIndices(Collections.emptyMap()),
        final List<Throwable> throwables = new ArrayList<>();
            xContentRegistry,
        );
    public void testTotalPrimaryShardsTemplateValidatesOnSegmentsOnlyCluster() {
 */  
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        request.settings(
/**  
            .add(IndexShardTestUtils.getFakeRemoteEnabledNode("node1"))  
import java.util.List;  
 * SPDX-License-Identifier: Apache-2.0
            builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")
        return throwables;  
                .build()
                .put(INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT.toString())
            .add(IndexShardTestUtils.getFakeSegmentsOnlyNode("node1"))
}
    public void testTotalPrimaryShardsTemplateRejectedOnEmptyNodeCluster() {  
import static org.mockito.Mockito.when;
        when(clusterService.getSettings()).thenReturn(settings);
        // segments_only nodes have a segment repository but no cluster state repository. Balancing primaries only  
            null,  
import org.opensearch.common.settings.ClusterSettings;
        assertThat(throwables.get(0).getMessage(), containsString("can only be used with remote store enabled clusters"));
        // No nodes → not a remote-store cluster (allMatch is vacuously true on an empty set, so the
import org.opensearch.test.OpenSearchTestCase;
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING;
            }
            builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")
        request.patterns(singletonList("test_shards_wait*"));
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;
package org.opensearch.cluster.metadata;
        assertThat(throwables, not(empty()));
        // needs the segments to be remote backed, so the template must validate here too.
 * compatible open source license.
        assertThat(throwables, empty());  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")
 * {@code index.remote_store.enabled} flag a template can never carry.  
                .put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 2)  
 *
                .put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 2)  
import static org.hamcrest.Matchers.instanceOf;
                throwables.add(e);  
        MetadataCreateIndexService createIndexService = new MetadataCreateIndexService(
            public void onFailure(Exception e) {
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")
        });
            null,
                .build()
        ClusterService clusterService = mock(ClusterService.class);
            .build();
                .put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 2)
        request.patterns(singletonList("test_shards_wait*"));
            new IndexScopedSettings(Settings.EMPTY, IndexScopedSettings.BUILT_IN_INDEX_SETTINGS),  
 * uses the cluster/node-aware precondition (is this a remote-store cluster?) rather than the index-local
            .build();  
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);  
        List<Throwable> throwables = putTemplate(xContentRegistry(), request, mixedNodes);
        assertThat(throwables.get(0), instanceOf(IllegalArgumentException.class));  
                .put(INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT.toString())  
            .nodes(discoveryNodes)
            .add(IndexShardTestUtils.getFakeRemoteEnabledNode("remote1"))  
        request.settings(  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
 * this file be licensed under the Apache-2.0 license or a
            createTestShardLimitService(randomIntBetween(1, 1000), false),
import org.opensearch.env.Environment;
        service.putTemplate(request, new MetadataIndexTemplateService.PutListener() {  
