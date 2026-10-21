            .metadata(metadata)
import java.util.ArrayList;
        PutRequest request = new PutRequest("test", "test_index_primary_shard_constraint_empty");
        // Mixed cluster (one non-remote node) → not every node is a remote-store node, so the
        MetadataCreateIndexService createIndexService = new MetadataCreateIndexService(
            .build();
        when(clusterService.getSettings()).thenReturn(settings);
                .put(INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT.toString())
        });
        ClusterService clusterService = mock(ClusterService.class);
                .put(INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT.toString())
 *
        service.putTemplate(request, new MetadataIndexTemplateService.PutListener() {
            new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
            .nodes(discoveryNodes)
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
            .build();
            null,
 * The OpenSearch Contributors require contributions made to
            createTestShardLimitService(randomIntBetween(1, 1000), false),
            }
package org.opensearch.cluster.metadata;
        // segments_only nodes have a segment repository but no cluster state repository. Balancing primaries only
        request.patterns(singletonList("test_shards_wait*"));
    }
import org.opensearch.cluster.ClusterState;
                .put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 2)
        PutRequest request = new PutRequest("test", "test_index_primary_shard_constraint_mixed");
import org.opensearch.indices.DefaultRemoteStoreSettings;
        assertThat(throwables, empty());
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            null,
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")
        MetadataIndexTemplateService service = new MetadataIndexTemplateService(
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.indices.IndicesService;
            .build();
        );
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
                .put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 2)
        Settings settings = Settings.builder().put(PATH_HOME_SETTING.getKey(), "dummy").build();
            xContentRegistry,
 *
        // Every node is a remote-store node → the template must validate successfully.
                .put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 2)
    }
    }
            null,
            createIndexService,
import org.opensearch.cluster.metadata.MetadataIndexTemplateService.PutRequest;
            clusterService,
 * compatible open source license.
        DiscoveryNodes mixedNodes = DiscoveryNodes.builder()
            new IndexScopedSettings(Settings.EMPTY, IndexScopedSettings.BUILT_IN_INDEX_SETTINGS),
 * the randomized method ordering of that (state-sharing) suite.
            .add(IndexShardTestUtils.getFakeSegmentsOnlyNode("node1"))
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")
        Metadata metadata = Metadata.builder().build();
}
    private static List<Throwable> putTemplate(NamedXContentRegistry xContentRegistry, PutRequest request, DiscoveryNodes discoveryNodes) {
        when(clusterService.state()).thenReturn(clusterState);
import org.opensearch.env.Environment;
            builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")
        assertThat(throwables.get(0).getMessage(), containsString("can only be used with remote store enabled clusters"));
        PutRequest request = new PutRequest("test", "test_index_primary_shard_constraint_remote");
            Settings.EMPTY,
        assertThat(throwables.get(0), instanceOf(IllegalArgumentException.class));
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;
import static org.hamcrest.Matchers.not;
                throwables.add(e);
                .put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 2)
        request.patterns(singletonList("test_shards_wait*"));
    public void testTotalPrimaryShardsTemplateValidatesOnSegmentsOnlyCluster() {
            new SystemIndices(Collections.emptyMap()),
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.containsString;
            .add(IndexShardTestUtils.getFakeDiscoNode("plain1"))
            .build();
import static org.mockito.Mockito.when;
            null
        List<Throwable> throwables = putTemplate(xContentRegistry(), request, DiscoveryNodes.EMPTY_NODES);
import static org.mockito.Mockito.mock;
        // !nodes.isEmpty() guard must reject). Covers the empty-node branch of the hardened check.
import static org.opensearch.common.settings.Settings.builder;
        assertThat(throwables, empty());
        PutRequest request = new PutRequest("test", "test_index_primary_shard_constraint_segments_only");
    public void testTotalPrimaryShardsTemplateRejectedOnEmptyNodeCluster() {
 * Tests that index-template validation of {@code index.routing.allocation.total_primary_shards_per_node}
            builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")
 * uses the cluster/node-aware precondition (is this a remote-store cluster?) rather than the index-local
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            @Override
            new AliasValidator(),
        assertThat(throwables.get(0).getMessage(), containsString("can only be used with remote store enabled clusters"));
 */
            builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")
        assertThat(throwables, not(empty()));
        // No nodes → not a remote-store cluster (allMatch is vacuously true on an empty set, so the
        request.settings(
import org.opensearch.cluster.service.ClusterService;
 * fully mock-driven and do not need the shared single-node fixture; isolating them also avoids perturbing
        DiscoveryNodes segmentsOnlyNodes = DiscoveryNodes.builder()
 * {@code index.remote_store.enabled} flag a template can never carry.
import org.opensearch.common.settings.IndexScopedSettings;
import org.opensearch.indices.SystemIndices;
        return throwables;
        // setting must be rejected. Covers the allMatch==false branch of the hardened check.
            xContentRegistry,
            .add(IndexShardTestUtils.getFakeSegmentsOnlyNode("node2"))
        final List<Throwable> throwables = new ArrayList<>();
import org.opensearch.indices.replication.common.ReplicationType;
        );
                .put(INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT.toString())
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING;
                .build()
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")
import org.opensearch.test.OpenSearchTestCase;
 * <p>Kept in its own class (rather than {@link MetadataIndexTemplateServiceTests}) because these cases are
import org.opensearch.core.xcontent.NamedXContentRegistry;
        request.settings(
import org.opensearch.cluster.ClusterName;
import static org.hamcrest.Matchers.empty;
        assertThat(throwables.get(0), instanceOf(IllegalArgumentException.class));
        request.settings(
            indicesServices,
        // needs the segments to be remote backed, so the template must validate here too.
            builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")
                .build()
    }
import static org.opensearch.env.Environment.PATH_HOME_SETTING;
            null
        request.patterns(singletonList("test_shards_wait*"));
        List<Throwable> throwables = putTemplate(xContentRegistry(), request, remoteNodes);
/**
    public void testTotalPrimaryShardsTemplateValidatesOnRemoteStoreCluster() {
import static org.opensearch.indices.ShardLimitValidatorTests.createTestShardLimitService;
        );
        List<Throwable> throwables = putTemplate(xContentRegistry(), request, mixedNodes);
        request.settings(
import org.opensearch.common.settings.Settings;
 */
        assertThat(throwables, not(empty()));
            .add(IndexShardTestUtils.getFakeRemoteEnabledNode("remote1"))
            true,
            null,
        );
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_REPLICATION_TYPE_SETTING;
            DefaultRemoteStoreSettings.INSTANCE,
        List<Throwable> throwables = putTemplate(xContentRegistry(), request, segmentsOnlyNodes);
        );
                .build()
            new Environment(builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString()).build(), null),
            clusterService,
import java.util.List;
        IndicesService indicesServices = mock(IndicesService.class);
import org.opensearch.common.settings.ClusterSettings;
                .put(INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT.toString())
import java.util.Collections;
            .add(IndexShardTestUtils.getFakeRemoteEnabledNode("node1"))
            @Override
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.instanceOf;
public class MetadataIndexTemplateServiceRemoteStoreTests extends OpenSearchTestCase {
        );
            public void onFailure(Exception e) {
    public void testTotalPrimaryShardsTemplateRejectedWhenSomeNodeIsNotRemoteStore() {
    }
        DiscoveryNodes remoteNodes = DiscoveryNodes.builder()
import static java.util.Collections.singletonList;
/*
        request.patterns(singletonList("test_shards_wait*"));
            .add(IndexShardTestUtils.getFakeRemoteEnabledNode("node2"))
            public void onResponse(MetadataIndexTemplateService.PutResponse response) {}
                .build()
import org.opensearch.index.shard.IndexShardTestUtils;
