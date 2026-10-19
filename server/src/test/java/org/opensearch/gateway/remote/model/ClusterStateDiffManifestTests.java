    public void testClusterStateWithRoutingTableDiffInDiffManifestXContentWithDeletes() throws IOException {
            .build();
            .build();
        builder.endObject();
            true,
    ) {  
            assertEquals(diffManifest, parsedManifest);
    public void testClusterStateWithRoutingTableDiffInDiffManifestXContent() throws IOException {
    }  
import org.opensearch.cluster.ClusterState;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
            assertEquals(diffManifest, parsedManifest);
            final ClusterStateDiffManifest parsedManifest = ClusterStateDiffManifest.fromXContent(parser, CODEC_V4);  
            currentState,
        ClusterState initialState = generateClusterStateWithOneIndex("test-index", 5, 1, true).nodes(nodesWithLocalNodeClusterManager())  
        boolean updateTransientSettings,
        }
                    .build()  
        }
        }  
import org.opensearch.common.xcontent.json.JsonXContent;
        builder.endObject();
        builder.startObject();
import static java.util.Collections.emptyList;  
        builder.startObject();
import org.opensearch.cluster.node.DiscoveryNode;
    ) {
        }
                        IndexTemplateMetadata.builder("template" + randomAlphaOfLength(3))
            true,
        int codecVersion
            );  
        assertEquals(updateClusterBlocks, manifest.isClusterBlocksUpdated());
import org.opensearch.cluster.coordination.CoordinationMetadata;  
            metadataBuilder.put(indexMetadata, true);  
                            )
        if (updateCoordinationState) {
        boolean updateTemplates,  
            true,
            metadataBuilder.templates(
                CoordinationMetadata.builder(initialState.metadata().coordinationMetadata())
                            .numberOfReplicas(0)
        return manifest;
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.gateway.remote.model.RemoteClusterBlocksTests.randomClusterBlocks;
            .build();
        if (updateTemplates) {  
                    .addVotingConfigExclusion(new CoordinationMetadata.VotingConfigExclusion("exlucdedNodeId", "excludedNodeName"))
        ClusterState initialState = ClusterState.builder(EMPTY_STATE)
        builder.endObject();
    public void testClusterStateDiffManifest() {  
                            .numberOfReplicas(0)
                            .patterns(asList("bar-*", "foo-*"))
        for (String custom : clusterStateCustomsToAdd.keySet()) {
            randomBoolean(),  
import org.opensearch.cluster.node.DiscoveryNodes;  
            .build();
    }
import org.opensearch.cluster.routing.StringKeyDiffProvider;  
 *
        assertEquals(updateDiscoveryNodes, manifest.isDiscoveryNodesUpdated());
            metadataBuilder.persistentSettings(Settings.builder().put("key", "value").build());
        diffManifest.toXContent(builder, ToXContent.EMPTY_PARAMS);  
            emptyList(),
        ClusterStateDiffManifest diffManifest = verifyRoutingTableDiffManifest(initialState, updatedState, CODEC_V3);  
            clusterStateBuilder.putCustom(custom, clusterStateCustomsToAdd.get(custom));
import org.opensearch.gateway.remote.ClusterStateDiffManifest;
        final XContentBuilder builder = JsonXContent.contentBuilder();
            metadataBuilder.coordinationMetadata(  
        final XContentBuilder builder = JsonXContent.contentBuilder();
        customsToRemove.forEach(metadataBuilder::removeCustom);  
        assertEquals(updateTransientSettings, manifest.isTransientSettingsMetadataUpdated());  
import static java.util.Arrays.asList;
            .build();
            final ClusterStateDiffManifest parsedManifest = ClusterStateDiffManifest.fromXContent(parser, CODEC_V3);  
        boolean updateCoordinationState,
                    .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
        ClusterState.Builder clusterStateBuilder = ClusterState.builder(initialState);  
    }  
        assertEquals("indicesRoutingDiffPath", manifest.getIndicesRoutingDiffPath());
                Metadata.builder()  
        ClusterStateDiffManifest manifest = new ClusterStateDiffManifest(  
        if (updateHashesOfConsistentSettings) {  
            emptyList(),
        ClusterState updatedClusterState = clusterStateBuilder.metadata(metadataBuilder.build()).build();  
    }  
            currentState.getRoutingTable()
            .build();
import static org.opensearch.gateway.remote.RemoteClusterStateServiceTests.nodesWithLocalNodeClusterManager;
        assertEquals(new ArrayList<>(customsToAdd.keySet()), manifest.getCustomMetadataUpdated());
        final XContentBuilder builder = JsonXContent.contentBuilder();
        ClusterStateDiffManifest diffManifest = verifyRoutingTableDiffManifest(initialState, updatedState, CODEC_V4);  
            singletonList("index-1"),  
    }  
            clusterStateBuilder.blocks(randomClusterBlocks());
                            .numberOfShards(1)
                                Settings.builder().put("random_index_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5)).build()
            .build();
        assertEquals(updateHashesOfConsistentSettings, manifest.isHashesOfConsistentSettingsUpdated());  
            singletonList("index-1"),  
import org.opensearch.cluster.routing.RoutingTableIncrementalDiff;
            emptyMap(),  
            assertEquals(diffManifest, parsedManifest);
                    .put(  
        List<String> indicesToRemove,
                            .numberOfShards(1)
        }
        assertEquals(customsToRemove, manifest.getCustomMetadataDeleted());  
        List<IndexMetadata> indicesToAdd,
                    )  
    }  
 * SPDX-License-Identifier: Apache-2.0
        ClusterState initialState = generateClusterStateWithOneIndex("test-index", 5, 1, true).nodes(nodesWithLocalNodeClusterManager())  
        assertEquals(updateTemplates, manifest.isTemplatesMetadataUpdated());
package org.opensearch.gateway.remote.model;
            );
import org.opensearch.Version;
        }
        ClusterState initialState = generateClusterStateWithOneIndex("test-index", 5, 1, true).nodes(nodesWithLocalNodeClusterManager())  
        );  
            ),
        }
                        IndexMetadata.builder("index-1")
        diffManifest.toXContent(builder, ToXContent.EMPTY_PARAMS);  
import static java.util.Collections.singletonList;
                            .build()  
            final ClusterStateDiffManifest parsedManifest = ClusterStateDiffManifest.fromXContent(parser, CODEC_V4);  
            emptyList(),
        if (updateTransientSettings) {
            randomBoolean(),  
            assertEquals(diffManifest, parsedManifest);
                        IndexMetadata.builder("index-1")
import org.opensearch.common.settings.Settings;
        if (updateClusterBlocks) {  
            .build();
import java.util.Map;  
import org.opensearch.core.xcontent.XContentBuilder;  
import org.opensearch.test.OpenSearchTestCase;  
        ClusterState initialState,  
        diffManifest.toXContent(builder, ToXContent.EMPTY_PARAMS);  
        if (updatePersistentSettings) {  
public class ClusterStateDiffManifestTests extends OpenSearchTestCase {
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
                TemplatesMetadata.builder()
}  
        final XContentBuilder builder = JsonXContent.contentBuilder();
            .build();
        // Create initial and updated IndexRoutingTable maps
import java.util.Collections;
        diffManifest.toXContent(builder, ToXContent.EMPTY_PARAMS);  
        builder.endObject();
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
            previousState.getRoutingTable(),  
        ClusterStateDiffManifest diffManifest = verifyRoutingTableDiffManifest(initialState, updatedState, CODEC_V4);  
            randomBoolean(),
        Metadata.Builder metadataBuilder = Metadata.builder(initialState.metadata());
            singletonList(
        ClusterState initialState = generateClusterStateWithOneIndex("test-index", 5, 1, true).nodes(nodesWithLocalNodeClusterManager())  
        ClusterState updatedState = generateClusterStateWithOneIndex("test-index", 5, 2, false).nodes(nodesWithLocalNodeClusterManager())  
            metadataBuilder.hashesOfConsistentSettings(Collections.singletonMap("key", "value"));
            true
        List<String> clusterStateCustomsToRemove,  
import java.util.List;
import static java.util.stream.Collectors.toList;  
        for (String custom : customsToAdd.keySet()) {  
    public void testClusterStateWithRoutingTableDiffInDiffManifestXContentV4() throws IOException {
        indicesToRemove.forEach(metadataBuilder::remove);
        );  
            )
                IndexMetadata.builder("index-2")  
            emptyList(),
        }
            randomBoolean(),
import java.io.IOException;
        ClusterState previousState,  
            metadataBuilder.putCustom(custom, customsToAdd.get(custom));
        assertEquals(updatePersistentSettings, manifest.isSettingsMetadataUpdated());
        Map<String, ClusterState.Custom> clusterStateCustomsToAdd,
                    .build()
            randomBoolean(),
                    .build()
        ClusterState initialState = ClusterState.builder(EMPTY_STATE)
        ClusterStateDiffManifest diffManifest = updateAndVerifyState(  
            clusterStateBuilder.nodes(  
        }
        builder.startObject();
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V3;
            codecVersion,  
                    .numberOfShards(1)
import org.opensearch.core.xcontent.ToXContent;
    private ClusterStateDiffManifest verifyRoutingTableDiffManifest(
import static java.util.Collections.emptyMap;
        assertEquals(indicesToAdd.stream().map(im -> im.getIndex().getName()).collect(toList()), manifest.getIndicesUpdated());  
            .build();
        builder.startObject();
        ClusterStateDiffManifest manifest = new ClusterStateDiffManifest(updatedClusterState, initialState, CODEC_V4, null, null);
        }
            initialState,
import org.opensearch.core.common.bytes.BytesReference;  
        assertEquals(new ArrayList<>(clusterStateCustomsToAdd.keySet()), manifest.getClusterStateCustomUpdated());
        assertEquals(clusterStateCustomsToRemove, manifest.getClusterStateCustomDeleted());
/*  
        updateAndVerifyState(  
        );
 * The OpenSearch Contributors require contributions made to  
        }
import org.opensearch.cluster.metadata.IndexMetadata;
            true,  
 * compatible open source license.
    public void testClusterStateWithRoutingTableDiffInDiffManifestXContentWithDeletesV4() throws IOException {
            emptyMap(),
            );
                    )
                    .add(new DiscoveryNode("new-cluster-manager", new TransportAddress(META_ADDRESS, 9200), CURRENT))
            routingTableDiff,
                            .settings(  
    private ClusterStateDiffManifest updateAndVerifyState(
import static org.opensearch.gateway.remote.RemoteClusterStateServiceTests.generateClusterStateWithOneIndex;  
                            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))  
            "indicesRoutingDiffPath"
                    )  
        }
                Metadata.builder()  
        }
            emptyList(),
        );  
            previousState,
                DiscoveryNodes.builder(initialState.nodes())
            assertEquals(diffManifest, parsedManifest);
 */  
import static org.opensearch.core.common.transport.TransportAddress.META_ADDRESS;  
            emptyMap(),  
            true,
        }
            initialState,
        assertEquals(indicesToRemove, manifest.getIndicesDeleted());
        diffManifest.toXContent(builder, ToXContent.EMPTY_PARAMS);  
import java.util.ArrayList;  
                            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))  
import static org.opensearch.Version.CURRENT;
import org.opensearch.cluster.metadata.TemplatesMetadata;
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V4;
    public void testClusterStateDiffManifestXContent() throws IOException {  
        return manifest;
        boolean updatePersistentSettings,
    }
            final ClusterStateDiffManifest parsedManifest = ClusterStateDiffManifest.fromXContent(parser, CODEC_V3);  
        }
        ClusterStateDiffManifest diffManifest = verifyRoutingTableDiffManifest(initialState, updatedState, CODEC_V3);  
        for (IndexMetadata indexMetadata : indicesToAdd) {
        StringKeyDiffProvider<IndexRoutingTable> routingTableDiff = new RoutingTableIncrementalDiff(
        builder.startObject();
        builder.endObject();
        Map<String, Metadata.Custom> customsToAdd,  
        ClusterState currentState,
            randomBoolean()
        clusterStateCustomsToRemove.forEach(clusterStateBuilder::removeCustom);
            .metadata(
        ClusterState updatedState = generateClusterStateWithOneIndex("test-index-1", 5, 2, false).nodes(nodesWithLocalNodeClusterManager())  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
        final XContentBuilder builder = JsonXContent.contentBuilder();
import org.opensearch.core.common.transport.TransportAddress;
            metadataBuilder.transientSettings(Settings.builder().put("key", "value").build());  
            emptyMap(),
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
        boolean updateDiscoveryNodes,
                    .put(
        boolean updateClusterBlocks,  
import org.opensearch.cluster.metadata.Metadata;  
            )
        ClusterState updatedState = generateClusterStateWithOneIndex("test-index-1", 5, 2, false).nodes(nodesWithLocalNodeClusterManager())  
            true,  
            final ClusterStateDiffManifest parsedManifest = ClusterStateDiffManifest.fromXContent(parser, CODEC_V4);  
        ClusterState updatedState = generateClusterStateWithOneIndex("test-index", 5, 2, false).nodes(nodesWithLocalNodeClusterManager())  
        boolean updateHashesOfConsistentSettings
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
import org.opensearch.cluster.routing.IndexRoutingTable;
        List<String> customsToRemove,
                    .clusterManagerNodeId("new-cluster-manager")  
        if (updateDiscoveryNodes) {
            .metadata(
import static org.opensearch.cluster.ClusterState.EMPTY_STATE;
import org.opensearch.core.xcontent.XContentParser;
    }  
                    .numberOfReplicas(0)  
            randomBoolean(),
        assertEquals(updateCoordinationState, manifest.isCoordinationMetadataUpdated());  
                    .put(
