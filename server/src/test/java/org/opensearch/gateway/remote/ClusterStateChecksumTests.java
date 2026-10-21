                    .version(1L)
 * SPDX-License-Identifier: Apache-2.0
        final Index index2 = new Index("test-index2", "index-uuid2");
    private ClusterState generateClusterState() {
    public void testSerialization() throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
    }
import java.util.Map;
                    .build()
        assertEquals(ClusterStateChecksum.BLOCKS_CS, mismatches.get(2));
        assertTrue(checksum.getMismatchEntities(checksum2).isEmpty());
        assertTrue(checksum.settingMetadataChecksum != 0);
        ClusterStateChecksum checksum = new ClusterStateChecksum(ClusterState.EMPTY_STATE, threadPool);
            .nodes(DiscoveryNodes.builder().clusterManagerNodeId("test-node").build())
        final Settings settings = Settings.builder().put("mock-settings", true).build();
        try (StreamInput in = output.bytes().streamInput()) {
            .build();
        assertEquals(checksum.indicesChecksum, newChecksum.indicesChecksum);
        assertNotNull(checksum);
        assertEquals(checksum2, checksum1);
            )
        assertFalse(mismatches.isEmpty());
            .numberOfReplicas(0)
        assertTrue(checksum.clusterStateChecksum != 0);
        ClusterStateChecksum checksum1 = new ClusterStateChecksum(state2, threadPool);
                    .transientSettings(settings)
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
import org.opensearch.threadpool.ThreadPool;
                    .indices(Map.of(indexMetadata.getIndex().getName(), indexMetadata, indexMetadata2.getIndex().getName(), indexMetadata2))
            .numberOfShards(1)
import org.opensearch.core.common.io.stream.StreamInput;
 * this file be licensed under the Apache-2.0 license or a
        );
            .numberOfReplicas(2)
            .put(IndexMetadata.INDEX_READ_ONLY_SETTING.getKey(), true)
    public void testGetMismatchEntities() {
        assertEquals(ClusterStateChecksum.COORDINATION_MD_CS, mismatches.get(4));
        assertEquals(checksum.transientSettingsMetadataChecksum, newChecksum.transientSettingsMetadataChecksum);
                ClusterBlocks.builder()
        final TemplatesMetadata templatesMetadata = TemplatesMetadata.builder()
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
        assertEquals(ClusterStateChecksum.TEMPLATES_MD_CS, mismatches.get(7));
            .put(IndexTemplateMetadata.builder("template1").settings(idxSettings).patterns(List.of("test*")).build())
        assertTrue(checksum.coordinationMetadataChecksum != 0);
            .customs(Map.of(clusterStateCustom1.getWriteableName(), clusterStateCustom1))
    public void testXContentConversion() throws IOException {
        assertEquals(ClusterStateChecksum.HASHES_MD_CS, mismatches.get(9));
        assertEquals(ClusterStateChecksum.CUSTOM_MD_CS, mismatches.get(8));
            )
        builder.endObject();
    public void teardown() throws Exception {
    public void testGetMismatchEntitiesUnorderedInput() {
        threadPool.shutdown();
            "custom-metadata-1"
import org.opensearch.cluster.ClusterState;
                Metadata.builder()
                    .putCustom(customMetadata1.getWriteableName(), customMetadata1)
import org.opensearch.test.OpenSearchTestCase;
            .build();
            .routingTable(RoutingTable.builder().addAsNew(indexMetadata).addAsNew(indexMetadata2).version(1L).build())
                    .addGlobalBlock(
        assertTrue(checksum.routingTableChecksum != 0);
            .metadata(
        assertNotNull(checksum);
            .stateUUID("state-uuid")
        );
import org.opensearch.cluster.coordination.CoordinationMetadata;
        assertTrue(checksum.indicesChecksum != 0);
import java.io.IOException;
            .blocks(
            .build();
                    .put(indexMetadata, true)
        assertEquals(ClusterStateChecksum.ROUTING_TABLE_CS, mismatches.get(0));
        DiscoveryNodes nodes2 = DiscoveryNodes.builder().clusterManagerNodeId("test-node").add(node2).add(node3).build();
import org.opensearch.cluster.routing.RoutingTable;
        assertEquals(11, mismatches.size());
import org.junit.After;
import org.opensearch.cluster.node.DiscoveryNodes;
        assertTrue(checksum.hashesOfConsistentSettingsChecksum != 0);
        }
                    .addBlocks(indexMetadata)
/*
        ClusterStateChecksum checksum2 = new ClusterStateChecksum(clsState1, threadPool);
                    .coordinationMetadata(coordinationMetadata)
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(1L).build();
 * The OpenSearch Contributors require contributions made to
        final Index index = new Index("test-index", "index-uuid");
            .build();
import org.opensearch.cluster.block.ClusterBlock;
            .build();
import org.opensearch.cluster.metadata.Metadata;
        ClusterStateChecksum checksum = new ClusterStateChecksum(clsState1, threadPool);
            .nodes(DiscoveryNodes.builder().build())
        checksum.toXContent(builder, ToXContent.EMPTY_PARAMS);
        DiscoveryNodes nodes1 = DiscoveryNodes.builder().clusterManagerNodeId("test-node").add(node1).add(node2).add(node3).build();
        ClusterStateChecksum checksum3 = new ClusterStateChecksum(clsState2, threadPool);
import org.opensearch.cluster.ClusterName;
                    .clusterUUID("cluster-uuid")
        final RemoteClusterStateTestUtils.CustomMetadata1 customMetadata1 = new RemoteClusterStateTestUtils.CustomMetadata1(
        assertEquals(checksum.templatesMetadataChecksum, newChecksum.templatesMetadataChecksum);
            .build();
            .build();
        assertEquals(checksum.customMetadataMapChecksum, newChecksum.customMetadataMapChecksum);
        final Settings idxSettings2 = Settings.builder()
                        new ClusterBlock(2, "block-name", false, true, true, RestStatus.OK, EnumSet.of(ClusterBlockLevel.WRITE))
        checksum.writeTo(output);
                    .addGlobalBlock(new ClusterBlock(1, "block", true, true, true, RestStatus.ACCEPTED, EnumSet.of(ClusterBlockLevel.READ)))
        assertTrue(checksum.clusterStateCustomsChecksum != 0);
        super.tearDown();
        DiscoveryNode node1 = DiscoveryNode.createLocal(Settings.EMPTY, new TransportAddress(TransportAddress.META_ADDRESS, 9200), "node1");
        assertTrue(checksum.blocksChecksum != 0);
        return ClusterState.builder(ClusterName.DEFAULT)
    public void testClusterStateMatchChecksum() {
        final IndexMetadata indexMetadata2 = new IndexMetadata.Builder(index2.getName()).settings(idxSettings2)
import org.opensearch.core.rest.RestStatus;
        assertEquals(checksum.coordinationMetadataChecksum, newChecksum.coordinationMetadataChecksum);
        assertTrue(checksum.nodesChecksum != 0);
        ClusterStateChecksum checksum = new ClusterStateChecksum(generateClusterState(), threadPool);
            .version(1L)
        DiscoveryNode node3 = DiscoveryNode.createLocal(Settings.EMPTY, new TransportAddress(TransportAddress.META_ADDRESS, 9202), "node3");
            .put(IndexMetadata.SETTING_INDEX_UUID, index2.getUUID())
        assertTrue(checksum.transientSettingsMetadataChecksum != 0);
        ClusterStateChecksum checksum2 = new ClusterStateChecksum(state3, threadPool);
        assertEquals(checksum.clusterStateChecksum, newChecksum.clusterStateChecksum);
import org.opensearch.cluster.node.DiscoveryNode;
        assertNotNull(checksum);
        assertEquals(ClusterStateChecksum.NODES_CS, mismatches.get(1));
                    .hashesOfConsistentSettings(Map.of("key1", "value1", "key2", "value2"))
        nodes2 = nodes2.newNode(node1);
                    )
            .numberOfShards(3)
        RemoteClusterStateTestUtils.TestClusterStateCustom1 clusterStateCustom1 = new RemoteClusterStateTestUtils.TestClusterStateCustom1(
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .blocks(ClusterBlocks.builder().build())
            .put(IndexMetadata.INDEX_READ_ONLY_SETTING.getKey(), true)
        ClusterStateChecksum checksum = new ClusterStateChecksum(generateClusterState(), threadPool);
            "custom-1"
        final Settings idxSettings = Settings.builder()
        assertTrue(checksum.templatesMetadataChecksum != 0);
        assertEquals(checksum.settingMetadataChecksum, newChecksum.settingMetadataChecksum);
        assertEquals(checksum.clusterStateCustomsChecksum, newChecksum.clusterStateCustomsChecksum);
import org.opensearch.common.xcontent.json.JsonXContent;
            ClusterStateChecksum deserializedChecksum = new ClusterStateChecksum(in);
public class ClusterStateChecksumTests extends OpenSearchTestCase {
    }
        DiscoveryNode node2 = DiscoveryNode.createLocal(Settings.EMPTY, new TransportAddress(TransportAddress.META_ADDRESS, 9201), "node2");
        ClusterStateChecksum checksum = new ClusterStateChecksum(generateClusterState(), threadPool);
        assertEquals(checksum.routingTableChecksum, newChecksum.routingTableChecksum);
import org.opensearch.core.index.Index;
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
    }
            assertEquals(checksum, deserializedChecksum);
        List<String> mismatches = checksum.getMismatchEntities(checksum3);
        assertEquals(ClusterStateChecksum.CUSTOMS_CS, mismatches.get(3));
        builder.startObject();
package org.opensearch.gateway.remote;
            .metadata(Metadata.EMPTY_METADATA)
        assertEquals(checksum.blocksChecksum, newChecksum.blocksChecksum);
        assertNotNull(newChecksum);
        assertTrue(checksum.customMetadataMapChecksum != 0);
 */
import org.opensearch.cluster.metadata.TemplatesMetadata;
        ClusterState clsState2 = ClusterState.builder(ClusterName.DEFAULT)
        ClusterStateChecksum checksum = new ClusterStateChecksum(generateClusterState(), threadPool);
}
        assertEquals(ClusterStateChecksum.TRANSIENT_SETTINGS_MD_CS, mismatches.get(6));
        assertEquals(ClusterStateChecksum.INDICES_CS, mismatches.get(10));
    @After
 * compatible open source license.
                    .persistentSettings(settings)
                    .templates(templatesMetadata)
            assertEquals(checksum, parsedChecksum);
        BytesStreamOutput output = new BytesStreamOutput();
    }
            .routingTable(RoutingTable.builder().build())
        assertEquals(checksum.hashesOfConsistentSettingsChecksum, newChecksum.hashesOfConsistentSettingsChecksum);
    public void testClusterStateChecksumEmptyClusterState() {
        ClusterState state1 = generateClusterState();
import org.opensearch.cluster.metadata.IndexMetadata;
        assertEquals(ClusterStateChecksum.SETTINGS_MD_CS, mismatches.get(5));
        ClusterState clsState1 = generateClusterState();
import java.util.List;
            final ClusterStateChecksum parsedChecksum = ClusterStateChecksum.fromXContent(parser);
            .customs(Map.of())
        assertTrue(checksum.getMismatchEntities(checksum).isEmpty());
    }
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.common.settings.Settings;
        }
        ClusterStateChecksum newChecksum = new ClusterStateChecksum(generateClusterState(), threadPool);
        assertEquals(checksum.nodesChecksum, newChecksum.nodesChecksum);
    public void testClusterStateChecksum() {
        final XContentBuilder builder = JsonXContent.contentBuilder();
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(index.getName()).settings(idxSettings)
import org.opensearch.threadpool.TestThreadPool;
    }
import org.opensearch.cluster.block.ClusterBlocks;
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.core.common.bytes.BytesReference;
    }
    }
import org.opensearch.Version;
import org.opensearch.cluster.block.ClusterBlockLevel;
import java.util.EnumSet;
import org.opensearch.core.common.transport.TransportAddress;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        ClusterState state2 = ClusterState.builder(state1).nodes(nodes1).build();
                    .build()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
import org.opensearch.core.xcontent.XContentParser;
 *
        ClusterState state3 = ClusterState.builder(state1).nodes(nodes2).build();
    }
