 * SPDX-License-Identifier: Apache-2.0
        ClusterStateDiffManifest diffManifest = verifyRoutingTableDiffManifest(initialState, updatedState, CODEC_V3);
        ClusterStateDiffManifest manifest = new ClusterStateDiffManifest(updatedClusterState, initialState, CODEC_V4, null, null);
        );
        ClusterState initialState = ClusterState.builder(EMPTY_STATE)
                            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
            codecVersion,
import static org.opensearch.core.common.transport.TransportAddress.META_ADDRESS;
import static java.util.Arrays.asList;
import org.opensearch.cluster.metadata.IndexMetadata;
        StringKeyDiffProvider<IndexRoutingTable> routingTableDiff = new RoutingTableIncrementalDiff(
        builder.endObject();
        ClusterStateDiffManifest diffManifest = verifyRoutingTableDiffManifest(initialState, updatedState, CODEC_V4);
    ) {
        updateAndVerifyState(
        Map<String, ClusterState.Custom> clusterStateCustomsToAdd,
            initialState,
            .build();
            singletonList("index-1"),
        final XContentBuilder builder = JsonXContent.contentBuilder();
            emptyMap(),
    }
        }
import static org.opensearch.cluster.ClusterState.EMPTY_STATE;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
            emptyList(),
        }
                        IndexMetadata.builder("index-1")
            .build();
            );
 * this file be licensed under the Apache-2.0 license or a
    }
                            .build()
                    .build()
    private ClusterStateDiffManifest updateAndVerifyState(
            assertEquals(diffManifest, parsedManifest);
                CoordinationMetadata.builder(initialState.metadata().coordinationMetadata())
        builder.startObject();
        builder.endObject();
        for (String custom : clusterStateCustomsToAdd.keySet()) {
        diffManifest.toXContent(builder, ToXContent.EMPTY_PARAMS);
        return manifest;
                            .settings(
import org.opensearch.cluster.routing.IndexRoutingTable;
                        IndexTemplateMetadata.builder("template" + randomAlphaOfLength(3))
            metadataBuilder.transientSettings(Settings.builder().put("key", "value").build());
            emptyList(),
            randomBoolean(),
import org.opensearch.core.xcontent.ToXContent;
import static org.opensearch.gateway.remote.RemoteClusterStateServiceTests.nodesWithLocalNodeClusterManager;
                    .add(new DiscoveryNode("new-cluster-manager", new TransportAddress(META_ADDRESS, 9200), CURRENT))
        assertEquals("indicesRoutingDiffPath", manifest.getIndicesRoutingDiffPath());
                    .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
import org.opensearch.Version;
        boolean updateDiscoveryNodes,
        assertEquals(updatePersistentSettings, manifest.isSettingsMetadataUpdated());
        diffManifest.toXContent(builder, ToXContent.EMPTY_PARAMS);
        );
            randomBoolean(),
        }
            metadataBuilder.put(indexMetadata, true);
                    .numberOfReplicas(0)
        ClusterStateDiffManifest diffManifest = updateAndVerifyState(
        if (updateCoordinationState) {
        if (updateTemplates) {
        ClusterState initialState = ClusterState.builder(EMPTY_STATE)
        final XContentBuilder builder = JsonXContent.contentBuilder();
        ClusterState previousState,
            singletonList("index-1"),
public class ClusterStateDiffManifestTests extends OpenSearchTestCase {
            assertEquals(diffManifest, parsedManifest);
                    )
        boolean updateCoordinationState,
    }
            )
        assertEquals(new ArrayList<>(clusterStateCustomsToAdd.keySet()), manifest.getClusterStateCustomUpdated());
        ClusterStateDiffManifest diffManifest = verifyRoutingTableDiffManifest(initialState, updatedState, CODEC_V3);
package org.opensearch.gateway.remote.model;
            )
            initialState,
        ClusterState updatedState = generateClusterStateWithOneIndex("test-index-1", 5, 2, false).nodes(nodesWithLocalNodeClusterManager())
                Metadata.builder()
        }
        );
        }
    public void testClusterStateDiffManifest() {
import java.util.ArrayList;
                Metadata.builder()
        Map<String, Metadata.Custom> customsToAdd,
import static org.opensearch.gateway.remote.model.RemoteClusterBlocksTests.randomClusterBlocks;
        Metadata.Builder metadataBuilder = Metadata.builder(initialState.metadata());
            emptyList(),
        boolean updatePersistentSettings,
import static java.util.stream.Collectors.toList;
                            .numberOfReplicas(0)
        assertEquals(new ArrayList<>(customsToAdd.keySet()), manifest.getCustomMetadataUpdated());
        }
        boolean updateHashesOfConsistentSettings
                    .clusterManagerNodeId("new-cluster-manager")
                    .addVotingConfigExclusion(new CoordinationMetadata.VotingConfigExclusion("exlucdedNodeId", "excludedNodeName"))
        ClusterState initialState = generateClusterStateWithOneIndex("test-index", 5, 1, true).nodes(nodesWithLocalNodeClusterManager())
        assertEquals(updateDiscoveryNodes, manifest.isDiscoveryNodesUpdated());
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V4;
            .build();
                DiscoveryNodes.builder(initialState.nodes())
            routingTableDiff,
import org.opensearch.cluster.routing.RoutingTableIncrementalDiff;
import org.opensearch.cluster.metadata.TemplatesMetadata;
            "indicesRoutingDiffPath"
        ClusterState updatedState = generateClusterStateWithOneIndex("test-index", 5, 2, false).nodes(nodesWithLocalNodeClusterManager())
        builder.endObject();
            emptyMap(),
        }
        if (updateDiscoveryNodes) {
        ClusterState updatedState = generateClusterStateWithOneIndex("test-index", 5, 2, false).nodes(nodesWithLocalNodeClusterManager())
import static java.util.Collections.singletonList;
            .build();
            .metadata(
 * The OpenSearch Contributors require contributions made to
            clusterStateBuilder.blocks(randomClusterBlocks());
            metadataBuilder.templates(
        boolean updateTransientSettings,
        );
    ) {
                            )
                TemplatesMetadata.builder()
                    .put(
            .build();
import static org.opensearch.gateway.remote.RemoteClusterStateServiceTests.generateClusterStateWithOneIndex;
                    )
import java.util.Map;
                    .build()
        final XContentBuilder builder = JsonXContent.contentBuilder();
            true,
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
import org.opensearch.cluster.node.DiscoveryNode;
        if (updateHashesOfConsistentSettings) {
            true,
            randomBoolean(),
    }
    public void testClusterStateWithRoutingTableDiffInDiffManifestXContent() throws IOException {
            metadataBuilder.persistentSettings(Settings.builder().put("key", "value").build());
    }
        ClusterState updatedState = generateClusterStateWithOneIndex("test-index-1", 5, 2, false).nodes(nodesWithLocalNodeClusterManager())
                    .put(
import org.opensearch.cluster.metadata.Metadata;
        }
}
        builder.startObject();
        List<IndexMetadata> indicesToAdd,
    }
        boolean updateTemplates,
        clusterStateCustomsToRemove.forEach(clusterStateBuilder::removeCustom);
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
                    .numberOfShards(1)
            singletonList(
            emptyList(),
            final ClusterStateDiffManifest parsedManifest = ClusterStateDiffManifest.fromXContent(parser, CODEC_V4);
                            .numberOfShards(1)
import static java.util.Collections.emptyList;
                                Settings.builder().put("random_index_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5)).build()
            final ClusterStateDiffManifest parsedManifest = ClusterStateDiffManifest.fromXContent(parser, CODEC_V3);
        builder.startObject();
            metadataBuilder.hashesOfConsistentSettings(Collections.singletonMap("key", "value"));
        diffManifest.toXContent(builder, ToXContent.EMPTY_PARAMS);
            );
            .build();
            assertEquals(diffManifest, parsedManifest);
        builder.startObject();
        assertEquals(updateHashesOfConsistentSettings, manifest.isHashesOfConsistentSettingsUpdated());
            final ClusterStateDiffManifest parsedManifest = ClusterStateDiffManifest.fromXContent(parser, CODEC_V4);
import org.opensearch.cluster.ClusterState;
        }
            .build();
 *
            .build();
import org.opensearch.core.common.bytes.BytesReference;
            currentState,
/*
import org.opensearch.cluster.coordination.CoordinationMetadata;
        builder.endObject();
    }
    public void testClusterStateWithRoutingTableDiffInDiffManifestXContentV4() throws IOException {
        assertEquals(indicesToAdd.stream().map(im -> im.getIndex().getName()).collect(toList()), manifest.getIndicesUpdated());
import org.opensearch.test.OpenSearchTestCase;
            true
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
        indicesToRemove.forEach(metadataBuilder::remove);
            currentState.getRoutingTable()
        ClusterState initialState,
        diffManifest.toXContent(builder, ToXContent.EMPTY_PARAMS);
            .metadata(
            clusterStateBuilder.putCustom(custom, clusterStateCustomsToAdd.get(custom));
        List<String> clusterStateCustomsToRemove,
import org.opensearch.gateway.remote.ClusterStateDiffManifest;
        ClusterState initialState = generateClusterStateWithOneIndex("test-index", 5, 1, true).nodes(nodesWithLocalNodeClusterManager())
                    )
import org.opensearch.common.xcontent.json.JsonXContent;
        }
        }
        List<String> indicesToRemove,
            true,
            final ClusterStateDiffManifest parsedManifest = ClusterStateDiffManifest.fromXContent(parser, CODEC_V3);
        }
        builder.startObject();
import java.io.IOException;
            true,
        return manifest;
        diffManifest.toXContent(builder, ToXContent.EMPTY_PARAMS);
        ClusterStateDiffManifest manifest = new ClusterStateDiffManifest(
        assertEquals(customsToRemove, manifest.getCustomMetadataDeleted());
    public void testClusterStateWithRoutingTableDiffInDiffManifestXContentWithDeletesV4() throws IOException {
        List<String> customsToRemove,
        ClusterStateDiffManifest diffManifest = verifyRoutingTableDiffManifest(initialState, updatedState, CODEC_V4);
        if (updateTransientSettings) {
                IndexMetadata.builder("index-2")
            assertEquals(diffManifest, parsedManifest);
import org.opensearch.core.xcontent.XContentBuilder;
            );
import org.opensearch.core.common.transport.TransportAddress;
            final ClusterStateDiffManifest parsedManifest = ClusterStateDiffManifest.fromXContent(parser, CODEC_V4);
        }
        int codecVersion
                            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
import org.opensearch.cluster.routing.StringKeyDiffProvider;
            metadataBuilder.putCustom(custom, customsToAdd.get(custom));
        boolean updateClusterBlocks,
        final XContentBuilder builder = JsonXContent.contentBuilder();
        assertEquals(updateTransientSettings, manifest.isTransientSettingsMetadataUpdated());
import java.util.List;
        }
        ClusterState currentState,
        assertEquals(indicesToRemove, manifest.getIndicesDeleted());
            ),
                        IndexMetadata.builder("index-1")
    public void testClusterStateDiffManifestXContent() throws IOException {
        assertEquals(updateClusterBlocks, manifest.isClusterBlocksUpdated());
        customsToRemove.forEach(metadataBuilder::removeCustom);
import org.opensearch.core.xcontent.XContentParser;
        for (String custom : customsToAdd.keySet()) {
 */
            metadataBuilder.coordinationMetadata(
            .build();
            assertEquals(diffManifest, parsedManifest);
        assertEquals(updateCoordinationState, manifest.isCoordinationMetadataUpdated());
                    .put(
    private ClusterStateDiffManifest verifyRoutingTableDiffManifest(
                            .patterns(asList("bar-*", "foo-*"))
            emptyList(),
        for (IndexMetadata indexMetadata : indicesToAdd) {
                            .numberOfShards(1)
            randomBoolean(),
        assertEquals(updateTemplates, manifest.isTemplatesMetadataUpdated());
import java.util.Collections;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
        ClusterState updatedClusterState = clusterStateBuilder.metadata(metadataBuilder.build()).build();
            true,
        if (updateClusterBlocks) {
        ClusterState initialState = generateClusterStateWithOneIndex("test-index", 5, 1, true).nodes(nodesWithLocalNodeClusterManager())
import static org.opensearch.Version.CURRENT;
        final XContentBuilder builder = JsonXContent.contentBuilder();
            randomBoolean()
        builder.endObject();
            previousState.getRoutingTable(),
            randomBoolean(),
            true,
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V3;
        ClusterState initialState = generateClusterStateWithOneIndex("test-index", 5, 1, true).nodes(nodesWithLocalNodeClusterManager())
            clusterStateBuilder.nodes(
 * compatible open source license.
    }
        if (updatePersistentSettings) {
import org.opensearch.cluster.node.DiscoveryNodes;
        }
    public void testClusterStateWithRoutingTableDiffInDiffManifestXContentWithDeletes() throws IOException {
        assertEquals(clusterStateCustomsToRemove, manifest.getClusterStateCustomDeleted());
import org.opensearch.common.settings.Settings;
        // Create initial and updated IndexRoutingTable maps
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
        ClusterState.Builder clusterStateBuilder = ClusterState.builder(initialState);
            previousState,
            .build();
import static java.util.Collections.emptyMap;
            emptyMap(),
            randomBoolean(),
                            .numberOfReplicas(0)
            emptyMap(),
                    .build()
