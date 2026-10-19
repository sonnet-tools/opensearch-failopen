    }
        assertTrue(checksum.settingMetadataChecksum != 0);
        );
import org.opensearch.cluster.block.ClusterBlockLevel;
        final Settings idxSettings = Settings.builder()
            .put(IndexMetadata.SETTING_INDEX_UUID, index2.getUUID())
import org.opensearch.Version;
import org.opensearch.core.common.io.stream.StreamInput;
        assertEquals(checksum.blocksChecksum, newChecksum.blocksChecksum);
import org.opensearch.common.io.stream.BytesStreamOutput;  
        assertEquals(checksum2, checksum1);  
    }
        ClusterState state1 = generateClusterState();
            "custom-1"  
        final IndexMetadata indexMetadata2 = new IndexMetadata.Builder(index2.getName()).settings(idxSettings2)
        }
        assertEquals(checksum.customMetadataMapChecksum, newChecksum.customMetadataMapChecksum);
import org.opensearch.cluster.node.DiscoveryNodes;
                    .clusterUUID("cluster-uuid")  
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(checksum.clusterStateCustomsChecksum != 0);
        assertEquals(ClusterStateChecksum.TRANSIENT_SETTINGS_MD_CS, mismatches.get(6));  
        assertTrue(checksum.coordinationMetadataChecksum != 0);  
            assertEquals(checksum, deserializedChecksum);
import org.opensearch.common.settings.Settings;
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(index.getName()).settings(idxSettings)
        assertTrue(checksum.templatesMetadataChecksum != 0);  
import org.opensearch.test.OpenSearchTestCase;
        ClusterStateChecksum checksum2 = new ClusterStateChecksum(clsState1, threadPool);
        }  
        assertEquals(checksum.coordinationMetadataChecksum, newChecksum.coordinationMetadataChecksum);
                    .addBlocks(indexMetadata)
        assertEquals(ClusterStateChecksum.INDICES_CS, mismatches.get(10));
        assertFalse(mismatches.isEmpty());
        super.tearDown();
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {  
        final TemplatesMetadata templatesMetadata = TemplatesMetadata.builder()
        assertTrue(checksum.hashesOfConsistentSettingsChecksum != 0);
        nodes2 = nodes2.newNode(node1);  
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(1L).build();  
            .put(IndexMetadata.INDEX_READ_ONLY_SETTING.getKey(), true)
 * this file be licensed under the Apache-2.0 license or a
        ClusterStateChecksum checksum3 = new ClusterStateChecksum(clsState2, threadPool);
        assertTrue(checksum.getMismatchEntities(checksum).isEmpty());
            .metadata(
import org.opensearch.cluster.ClusterState;  
                    .hashesOfConsistentSettings(Map.of("key1", "value1", "key2", "value2"))
            assertEquals(checksum, parsedChecksum);
            .nodes(DiscoveryNodes.builder().build())  
import org.opensearch.cluster.block.ClusterBlocks;  
        assertEquals(checksum.transientSettingsMetadataChecksum, newChecksum.transientSettingsMetadataChecksum);  
    public void testGetMismatchEntities() {
    }  
 * The OpenSearch Contributors require contributions made to  
        assertEquals(checksum.nodesChecksum, newChecksum.nodesChecksum);
/*  
        ClusterStateChecksum newChecksum = new ClusterStateChecksum(generateClusterState(), threadPool);  
        final Settings idxSettings2 = Settings.builder()  
import org.opensearch.cluster.block.ClusterBlock;
        List<String> mismatches = checksum.getMismatchEntities(checksum3);  
                    .transientSettings(settings)  
        final Index index = new Index("test-index", "index-uuid");
            .customs(Map.of(clusterStateCustom1.getWriteableName(), clusterStateCustom1))
    }  
        ClusterStateChecksum checksum = new ClusterStateChecksum(generateClusterState(), threadPool);  
import org.opensearch.core.common.bytes.BytesReference;  
        final Settings settings = Settings.builder().put("mock-settings", true).build();
 * compatible open source license.
        ClusterState clsState2 = ClusterState.builder(ClusterName.DEFAULT)
        ClusterState state3 = ClusterState.builder(state1).nodes(nodes2).build();
        checksum.toXContent(builder, ToXContent.EMPTY_PARAMS);  
        assertEquals(ClusterStateChecksum.CUSTOMS_CS, mismatches.get(3));  
import org.opensearch.cluster.metadata.TemplatesMetadata;
        DiscoveryNodes nodes1 = DiscoveryNodes.builder().clusterManagerNodeId("test-node").add(node1).add(node2).add(node3).build();
        builder.endObject();
        checksum.writeTo(output);  
        assertEquals(ClusterStateChecksum.HASHES_MD_CS, mismatches.get(9));  
                        new ClusterBlock(2, "block-name", false, true, true, RestStatus.OK, EnumSet.of(ClusterBlockLevel.WRITE))
import org.opensearch.cluster.metadata.IndexTemplateMetadata;  
import org.opensearch.cluster.coordination.CoordinationMetadata;
import org.opensearch.cluster.metadata.Metadata;
 */  
                    .coordinationMetadata(coordinationMetadata)
        ClusterStateChecksum checksum = new ClusterStateChecksum(clsState1, threadPool);
            )
                ClusterBlocks.builder()  
            .build();
        ClusterStateChecksum checksum = new ClusterStateChecksum(ClusterState.EMPTY_STATE, threadPool);
        assertEquals(checksum.clusterStateChecksum, newChecksum.clusterStateChecksum);
import org.opensearch.core.common.transport.TransportAddress;
    public void testGetMismatchEntitiesUnorderedInput() {
        DiscoveryNodes nodes2 = DiscoveryNodes.builder().clusterManagerNodeId("test-node").add(node2).add(node3).build();
                    .build()  
            .numberOfShards(3)  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
import org.opensearch.cluster.ClusterName;
        assertTrue(checksum.blocksChecksum != 0);
            )  
import java.util.Map;
            .build();
                    .putCustom(customMetadata1.getWriteableName(), customMetadata1)  
        final RemoteClusterStateTestUtils.CustomMetadata1 customMetadata1 = new RemoteClusterStateTestUtils.CustomMetadata1(
        final Index index2 = new Index("test-index2", "index-uuid2");
                    .persistentSettings(settings)
            .customs(Map.of())
        assertEquals(checksum.hashesOfConsistentSettingsChecksum, newChecksum.hashesOfConsistentSettingsChecksum);  
                    .build()
        DiscoveryNode node3 = DiscoveryNode.createLocal(Settings.EMPTY, new TransportAddress(TransportAddress.META_ADDRESS, 9202), "node3");
        assertEquals(ClusterStateChecksum.TEMPLATES_MD_CS, mismatches.get(7));
    private ClusterState generateClusterState() {  
        assertTrue(checksum.indicesChecksum != 0);  
        ClusterStateChecksum checksum = new ClusterStateChecksum(generateClusterState(), threadPool);
    @After  
        assertEquals(checksum.settingMetadataChecksum, newChecksum.settingMetadataChecksum);
        assertTrue(checksum.customMetadataMapChecksum != 0);
            .routingTable(RoutingTable.builder().build())
            .numberOfShards(1)
        assertEquals(ClusterStateChecksum.CUSTOM_MD_CS, mismatches.get(8));
        assertEquals(checksum.indicesChecksum, newChecksum.indicesChecksum);
                    .addGlobalBlock(new ClusterBlock(1, "block", true, true, true, RestStatus.ACCEPTED, EnumSet.of(ClusterBlockLevel.READ)))
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.core.rest.RestStatus;
            .metadata(Metadata.EMPTY_METADATA)  
        assertTrue(checksum.routingTableChecksum != 0);
            .put(IndexMetadata.INDEX_READ_ONLY_SETTING.getKey(), true)  
        );
    }  
        try (StreamInput in = output.bytes().streamInput()) {
                Metadata.builder()  
    public void testClusterStateChecksum() {
    public void teardown() throws Exception {
                    .version(1L)
            .nodes(DiscoveryNodes.builder().clusterManagerNodeId("test-node").build())
            .blocks(ClusterBlocks.builder().build())
    public void testClusterStateMatchChecksum() {
            .version(1L)  
    }
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
            .build();
        ClusterStateChecksum checksum1 = new ClusterStateChecksum(state2, threadPool);
        assertEquals(checksum.templatesMetadataChecksum, newChecksum.templatesMetadataChecksum);
package org.opensearch.gateway.remote;
        ClusterStateChecksum checksum = new ClusterStateChecksum(generateClusterState(), threadPool);  
        ClusterState clsState1 = generateClusterState();  
import org.opensearch.common.xcontent.json.JsonXContent;
import org.opensearch.core.xcontent.XContentBuilder;  
        assertEquals(checksum.routingTableChecksum, newChecksum.routingTableChecksum);  
 *
        return ClusterState.builder(ClusterName.DEFAULT)
        assertTrue(checksum.transientSettingsMetadataChecksum != 0);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
}  
            .numberOfReplicas(2)
        ClusterStateChecksum checksum2 = new ClusterStateChecksum(state3, threadPool);
import org.opensearch.cluster.routing.RoutingTable;
    public void testClusterStateChecksumEmptyClusterState() {  
                    .put(indexMetadata, true)
        assertNotNull(checksum);
            .routingTable(RoutingTable.builder().addAsNew(indexMetadata).addAsNew(indexMetadata2).version(1L).build())  
    public void testSerialization() throws IOException {  
import org.opensearch.cluster.node.DiscoveryNode;  
import org.opensearch.core.index.Index;  
import org.opensearch.core.xcontent.XContentParser;
            .stateUUID("state-uuid")
        assertEquals(ClusterStateChecksum.COORDINATION_MD_CS, mismatches.get(4));
    }
public class ClusterStateChecksumTests extends OpenSearchTestCase {  
        final XContentBuilder builder = JsonXContent.contentBuilder();
            .blocks(
            .build();  
        assertEquals(checksum.clusterStateCustomsChecksum, newChecksum.clusterStateCustomsChecksum);  
                    .addGlobalBlock(  
        assertNotNull(checksum);
        assertTrue(checksum.nodesChecksum != 0);  
                    .templates(templatesMetadata)
            ClusterStateChecksum deserializedChecksum = new ClusterStateChecksum(in);  
    }
        assertEquals(ClusterStateChecksum.ROUTING_TABLE_CS, mismatches.get(0));  
        threadPool.shutdown();  
import java.util.EnumSet;
        assertNotNull(checksum);
import org.opensearch.threadpool.TestThreadPool;  
            .put(IndexTemplateMetadata.builder("template1").settings(idxSettings).patterns(List.of("test*")).build())  
        assertTrue(checksum.clusterStateChecksum != 0);
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
            .numberOfReplicas(0)  
import java.io.IOException;
        DiscoveryNode node1 = DiscoveryNode.createLocal(Settings.EMPTY, new TransportAddress(TransportAddress.META_ADDRESS, 9200), "node1");  
                    )
        assertTrue(checksum.getMismatchEntities(checksum2).isEmpty());
    }
        DiscoveryNode node2 = DiscoveryNode.createLocal(Settings.EMPTY, new TransportAddress(TransportAddress.META_ADDRESS, 9201), "node2");
            .build();
        assertEquals(11, mismatches.size());
            .build();
    public void testXContentConversion() throws IOException {
        builder.startObject();
        assertNotNull(newChecksum);
import java.util.List;  
        assertEquals(ClusterStateChecksum.SETTINGS_MD_CS, mismatches.get(5));
                    .indices(Map.of(indexMetadata.getIndex().getName(), indexMetadata, indexMetadata2.getIndex().getName(), indexMetadata2))
        ClusterState state2 = ClusterState.builder(state1).nodes(nodes1).build();
import org.opensearch.core.xcontent.ToXContent;
import org.junit.After;
        assertEquals(ClusterStateChecksum.BLOCKS_CS, mismatches.get(2));
            final ClusterStateChecksum parsedChecksum = ClusterStateChecksum.fromXContent(parser);
        BytesStreamOutput output = new BytesStreamOutput();
            .build();
        ClusterStateChecksum checksum = new ClusterStateChecksum(generateClusterState(), threadPool);
        RemoteClusterStateTestUtils.TestClusterStateCustom1 clusterStateCustom1 = new RemoteClusterStateTestUtils.TestClusterStateCustom1(
        assertEquals(ClusterStateChecksum.NODES_CS, mismatches.get(1));
import org.opensearch.cluster.metadata.IndexMetadata;
            "custom-metadata-1"  
