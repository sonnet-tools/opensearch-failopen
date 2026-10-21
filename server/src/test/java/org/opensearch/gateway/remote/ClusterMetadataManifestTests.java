package org.opensearch.gateway.remote;
 * The OpenSearch Contributors require contributions made to
            // Mutate custom metadata
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
        final Settings settings = Settings.builder().put("mock-settings", true).build();
        }
                    orig,
            .clusterUUIDCommitted(true)
        builder.startObject();
                    builder.coordinationMetadata(randomUploadedMetadataAttribute());
                    new NamedWriteableRegistry(Collections.emptyList()),
            assertEquals(originalManifest, fromXContentManifest);
        builder.endObject();
            .opensearchVersion(Version.CURRENT)
    }
        threadPool.shutdown();
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
            .indices(Collections.singletonList(uploadedIndexMetadata))
        assertEquals(CODEC_V1, ClusterMetadataManifest.getCodecForVersion(Version.V_2_13_0));
import org.opensearch.core.xcontent.XContentParser;
                    builder.diffManifest(null);
import org.opensearch.cluster.routing.RoutingTable;
                manifest -> {
    public void testClusterMetadataManifestXContentV0() throws IOException {
                    )
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
                    return builder.build();
import org.opensearch.cluster.coordination.CoordinationMetadata;
                            CUSTOM_METADATA + CUSTOM_DELIMITER + IndexGraveyard.TYPE,
        }
                ),
                            CUSTOM_METADATA + CUSTOM_DELIMITER + IndexGraveyard.TYPE,
                        )
                manifest -> {
    public void testClusterMetadataManifestXContentV4() throws IOException {
                        new UploadedMetadataAttribute(
                    .put(indexMetadata, true)
                    orig,
import org.opensearch.core.index.Index;
                initialManifest,
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
                    return builder.build();
            .nodeId("test-node-id")
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
                    builder.settingMetadata(randomUploadedMetadataAttribute());
    }
                    null
                        ),
            )
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
                    return builder.build();
        }
            );
                }
            // Mutate template metadata
                        new UploadedMetadataAttribute(
            .discoveryNodesMetadata(uploadedMetadataAttribute)
                    orig,
            );
                }
            .templatesMetadata(uploadedMetadataAttribute)
            .customMetadataMap(
            .indicesRouting(Collections.singletonList(uploadedIndexRoutingMetadata))
                    ClusterMetadataManifest::new
import org.opensearch.core.xcontent.XContentBuilder;
                orig -> OpenSearchTestCase.copyWriteable(
                    return builder.build();
                return new UploadedIndexMetadata(
                manifest -> {
            .codecVersion(ClusterMetadataManifest.CODEC_V4)
import static org.opensearch.gateway.remote.model.RemoteTransientSettingsMetadata.TRANSIENT_SETTING_METADATA;
import static org.opensearch.gateway.remote.routingtable.RemoteIndexRoutingTable.INDEX_ROUTING_METADATA_PREFIX;
        }
            );
import static org.opensearch.gateway.remote.model.RemoteHashesOfConsistentSettings.HASHES_OF_CONSISTENT_SETTINGS;
    }
            )
        }
            .clusterTerm(1337L)
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
            case 1:
import org.opensearch.threadpool.ThreadPool;
                ),
            assertEquals(originalManifest, fromXContentManifest);
                );
        UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "test-uuid", "/test/upload/path");
                        new UploadedMetadataAttribute(
                            "custom--index_graveyard-file"
            .clusterBlocksMetadata(uploadedMetadataAttribute)
            .clusterUUIDCommitted(true)
            .clusterUUID("test-cluster-uuid")
                            "custom--repositories-file"
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V1;
                        ),
                    RemoteClusterStateServiceTests.generateClusterStateWithOneIndex().build(),
            .templatesMetadata(new UploadedMetadataAttribute(TEMPLATES_METADATA, "templates-file"))
        {
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
        assertEquals(CODEC_V2, ClusterMetadataManifest.getCodecForVersion(Version.V_2_15_0));
        {
                            CUSTOM_METADATA + CUSTOM_DELIMITER + WeightedRoutingMetadata.TYPE,
            .hashesOfConsistentSettings(uploadedMetadataAttribute)
            .settingMetadata(new UploadedMetadataAttribute(SETTING_METADATA, "setting-file"))
            .nodeId("test-node-id")
            .clusterUUIDCommitted(true)
                        new UploadedMetadataAttribute(
                    new NamedWriteableRegistry(Collections.emptyList()),
import org.opensearch.core.xcontent.ToXContent;
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
                ),
                initialManifest,
            .clusterTerm(1L)
import org.junit.After;
            );
                            CUSTOM_METADATA + CUSTOM_DELIMITER + WeightedRoutingMetadata.TYPE,
                    builder.clusterUUIDCommitted(false);
                    )
                        )
                    )
                        ),
            .stateUUID("test-state-uuid")
                    new NamedWriteableRegistry(Collections.emptyList()),
                ),
                ),
import org.opensearch.Version;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
import org.opensearch.cluster.routing.IndexRoutingTable;
        );
            .diffManifest(
                    null,
            )
                        new UploadedMetadataAttribute(
            .committed(false)
        return uploadedIndexMetadataList;
                initialManifest,
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
                    routingTableIncrementalDiff,
            )
                    return builder.build();
        builder.endObject();
                orig -> OpenSearchTestCase.copyWriteable(
                    builder.stateUUID("efOkMiPbQZCUQQgtFWdbPw");
                initialManifest,
        UploadedMetadataAttribute uploadedMetadataAttribute = new UploadedMetadataAttribute("attribute_name", "testing_attribute");
            .globalMetadataFileName("test-global-metadata-file")
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
                    orig,
            .clusterUUID("test-cluster-uuid")
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
                initialManifest,
                    orig,
                    .version(randomNonNegativeLong())
                    return builder.build();
        }
                }
    }
            .coordinationMetadata(new UploadedMetadataAttribute(COORDINATION_METADATA, "coordination-file"))
        switch (randomInt(2)) {
            .clusterTerm(1L)
                orig -> OpenSearchTestCase.copyWriteable(
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
            .build();
            .previousClusterUUID("prev-cluster-uuid")
                initialManifest,
 *
                initialManifest,
        }
                    builder.discoveryNodesMetadata(randomUploadedMetadataAttribute());
            .build();
        originalManifest.toXContent(builder, ToXContent.EMPTY_PARAMS);
                        ),
        UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "test-uuid", "/test/upload/path");
import org.opensearch.cluster.metadata.IndexGraveyard;
                }
            .build();
                manifest -> {
                Collections.unmodifiableList(
                orig -> OpenSearchTestCase.copyWriteable(
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
            .diffManifest(
            INDEX_ROUTING_METADATA_PREFIX
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.gateway.remote.RemoteClusterStateAttributesManager.DISCOVERY_NODES;
        final Settings idxSettings = Settings.builder()
                new ClusterStateDiffManifest(
import static org.opensearch.gateway.remote.model.RemotePersistentSettingsMetadata.SETTING_METADATA;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
            "test-index",
import org.opensearch.cluster.ClusterState;
            .stateVersion(1L)
                        new UploadedMetadataAttribute(
                        new UploadedMetadataAttribute(
            .stateUUID("test-state-uuid")
            .customMetadataMap(
        }
        }
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
            final ClusterMetadataManifest fromXContentManifest = ClusterMetadataManifest.fromXContent(parser);
                    .coordinationMetadata(coordinationMetadata)
            .routingTableVersion(1L)
        final XContentBuilder builder = JsonXContent.contentBuilder();
                            CUSTOM_METADATA + CUSTOM_DELIMITER + RepositoriesMetadata.TYPE,
                            "custom--weighted_routing_netadata-file"
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
                orig -> OpenSearchTestCase.copyWriteable(
                    orig,
            .hashesOfConsistentSettings(uploadedMetadataAttribute)
    }
                orig -> OpenSearchTestCase.copyWriteable(
            .customMetadataMap(
                            CUSTOM_METADATA + CUSTOM_DELIMITER + RepositoriesMetadata.TYPE,
            .stateUUID("state-uuid")
            .indices(Collections.singletonList(uploadedIndexMetadata))
        UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "test-uuid", "/test/upload/path");
                manifest -> {
                    uploadedIndexMetadata.getIndexName(),
                    ClusterMetadataManifest::new
            .customMetadataMap(
                    builder.stateVersion(8L);
            .clusterBlocksMetadata(new UploadedMetadataAttribute(CLUSTER_BLOCKS, "cluster-block-file"))
                ),
            .nodeId("B10RX1f5RJenMQvYccCgSQ")
            .opensearchVersion(Version.CURRENT)
                    new NamedWriteableRegistry(Collections.emptyList()),
                Collections.unmodifiableList(
            )
                orig -> OpenSearchTestCase.copyWriteable(
            );
        UploadedIndexMetadata uploadedIndexRoutingMetadata = new UploadedIndexMetadata(
            .clusterStateCustomMetadataMap(Collections.emptyMap())
                            "custom--index_graveyard-file"
        }
    }
                        ),
                            "custom--repositories-file"
                }
            .previousClusterUUID("prev-cluster-uuid")
            assertEquals(originalManifest, fromXContentManifest);
                manifest -> {
            final ClusterMetadataManifest fromXContentManifest = ClusterMetadataManifest.fromXContent(parser);
                initialManifest,
                }
                new ClusterStateDiffManifest(
        {  // Mutate Cluster Term
                        new UploadedMetadataAttribute(
                            "custom--weighted_routing_netadata-file"
                            CUSTOM_METADATA + CUSTOM_DELIMITER + WeightedRoutingMetadata.TYPE,
                orig -> OpenSearchTestCase.copyWriteable(
                        ),
                    CODEC_V3,
        ClusterMetadataManifest originalManifest = ClusterMetadataManifest.builder()
                orig -> OpenSearchTestCase.copyWriteable(
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
                        new UploadedMetadataAttribute(
        }
    public void testClusterMetadataManifestXContentV2WithoutEphemeral() throws IOException {
            .coordinationMetadata(new UploadedMetadataAttribute(COORDINATION_METADATA, "coordination-file"))
                    builder.clusterBlocksMetadata(randomUploadedMetadataAttribute());
            .build();
            .opensearchVersion(Version.CURRENT)
                    new NamedWriteableRegistry(Collections.emptyList()),
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V3;
            .stateUUID("test-state-uuid")
                );
            .codecVersion(CODEC_V2)
            .codecVersion(CODEC_V0)
        UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "test-uuid", "/test/upload/path", CODEC_V0);
                    new NamedWriteableRegistry(Collections.emptyList()),
                            "custom--index_graveyard-file"
            .committed(false)
                            CUSTOM_METADATA + CUSTOM_DELIMITER + IndexGraveyard.TYPE,
                    Arrays.asList(
import org.opensearch.core.common.bytes.BytesReference;
                initialManifest,
            .indices(Collections.singletonList(uploadedIndexMetadata))
                    .build()
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
            // Mutate setting metadata
            );
                initialManifest,
                ).stream().collect(Collectors.toMap(UploadedMetadataAttribute::getAttributeName, Function.identity()))
            .codecVersion(CODEC_V1)
        originalManifest.toXContent(builder, ToXContent.EMPTY_PARAMS);
        builder.endObject();
            .clusterTerm(1L)
                    ClusterMetadataManifest.CODEC_V3,
        final XContentBuilder builder = JsonXContent.contentBuilder();
            .clusterUUID("test-cluster-uuid")
            );
                    orig,
            );
                    ClusterMetadataManifest::new
    }
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedMetadataAttribute;
                    orig,
        }
            final ClusterMetadataManifest fromXContentManifest = ClusterMetadataManifest.fromXContentV1(parser);
                ),
import static org.opensearch.gateway.remote.RemoteClusterStateAttributesManager.CLUSTER_BLOCKS;
                initialManifest,
            "test-index-uuid",
        final XContentBuilder builder = JsonXContent.contentBuilder();
            // Mutate transient settings metadata
            .settingMetadata(new UploadedMetadataAttribute(SETTING_METADATA, "setting-file"))
        originalManifest.toXContent(builder, ToXContent.EMPTY_PARAMS);
                }
                    new NamedWriteableRegistry(Collections.emptyList()),
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
                orig -> OpenSearchTestCase.copyWriteable(
 * SPDX-License-Identifier: Apache-2.0
            .customMetadataMap(
import static org.opensearch.gateway.remote.model.RemoteCoordinationMetadata.COORDINATION_METADATA;
            .settingMetadata(uploadedMetadataAttribute)
        }
            .stateVersion(1L)
            assertTrue(uploadedIndexMetadataList.add(randomUploadedIndexMetadata()));
                    ClusterState.EMPTY_STATE,
        {
                    randomAlphaOfLength(10),
        builder.endObject();
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
        UploadedMetadataAttribute uploadedMetadataAttribute = new UploadedMetadataAttribute("attribute_name", "testing_attribute");
                    Arrays.asList(
            .indicesRouting(Collections.singletonList(uploadedIndexMetadata))
            .build();
            .stateUUID("test-state-uuid")
                return new UploadedIndexMetadata(
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
    @After
        final XContentBuilder builder = JsonXContent.contentBuilder();
                            "custom--weighted_routing_netadata-file"
    private static UploadedIndexMetadata randomUploadedIndexMetadata() {
                    )
                    return builder.build();
                orig -> OpenSearchTestCase.copyWriteable(
                    builder.committed(false);
                ),
            assertEquals(originalManifest, fromXContentManifest);
                    orig,
                )
                ),
            .coordinationMetadata(uploadedMetadataAttribute)
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
            .nodeId("test-node-id")
                    "indicesRoutingDiffPath"
                    return builder.build();
            .previousClusterUUID("prev-cluster-uuid")
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
            .indices(Collections.singletonList(uploadedIndexMetadata))
                }
            .clusterUUID("test-cluster-uuid")
                manifest -> {
                ),
        }
            .codecVersion(CODEC_V2)
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
            );
        builder.endObject();
        return ClusterState.builder(ClusterName.DEFAULT)
        assertEquals(CODEC_V0, ClusterMetadataManifest.getCodecForVersion(Version.V_2_10_0));
                    ClusterMetadataManifest::new
            .committed(false)
                    new NamedWriteableRegistry(Collections.emptyList()),
            .transientSettingsMetadata(new UploadedMetadataAttribute(TRANSIENT_SETTING_METADATA, "transient-settings-file"))
                ),
                    orig,
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
                        )
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V2;
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
            .nodeId("test-node-id")
                    CODEC_V4,
                Metadata.builder()
        return uploadedIndexMetadata;
            "custom-metadata-1"
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(1L).build();
    public void testClusterMetadataManifestXContentV2() throws IOException {
import org.mockito.Mockito;
                            "custom--repositories-file"
                    orig,
                    new NamedWriteableRegistry(Collections.emptyList()),
                        ),
            .previousClusterUUID("yfObdx8KSMKKrXf8UyHhM")
            .hashesOfConsistentSettings(uploadedMetadataAttribute)
import org.opensearch.common.xcontent.json.JsonXContent;
                    return builder.build();
            .codecVersion(ClusterMetadataManifest.CODEC_V4)
            .transientSettingsMetadata(uploadedMetadataAttribute)
                    RemoteClusterStateServiceTests.generateClusterStateWithOneIndex().build(),
                }
                    new NamedWriteableRegistry(Collections.emptyList()),
                    ClusterMetadataManifest::new
    }
        ClusterMetadataManifest originalManifest = ClusterMetadataManifest.builder()
    }
                }
                    randomAlphaOfLength(10)
                initialManifest,
                    ClusterMetadataManifest::new
                Collections.unmodifiableList(
            assertEquals(originalManifest, fromXContentManifest);
                    return builder.build();
        assertEquals(-1, ClusterMetadataManifest.getCodecForVersion(Version.fromString("1.3.0")));
            .codecVersion(CODEC_V3)
            .committed(false)
                orig -> OpenSearchTestCase.copyWriteable(
            .clusterBlocksMetadata(uploadedMetadataAttribute)
        UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "test-uuid", "/test/upload/path", CODEC_V1);
            .templatesMetadata(new UploadedMetadataAttribute(TEMPLATES_METADATA, "templates-file"))
                orig -> OpenSearchTestCase.copyWriteable(
                manifest -> {
            .clusterTerm(1L)
        final int size = randomIntBetween(1, 10);
            .previousClusterUUID("prev-cluster-uuid")
                return new UploadedIndexMetadata(
        {  // Mutate OpenSearch Version
public class ClusterMetadataManifestTests extends OpenSearchTestCase {
        {  // Mutate State Version
            );
                    uploadedIndexMetadata.getIndexUUID(),
                manifest -> {
        }
                )
            .coordinationMetadata(uploadedMetadataAttribute)
                    builder.hashesOfConsistentSettings(randomUploadedMetadataAttribute());
                    return builder.build();
            .opensearchVersion(Version.CURRENT)
                    return builder.build();
                Collections.unmodifiableList(
            .stateVersion(7L)
                        new UploadedMetadataAttribute(
                manifest -> {
    public void testClusterMetadataManifestXContentV3() throws IOException {
                    uploadedMetadataAttribute.getUploadedFilename()
            .stateUUID("6By9p9G0Rv2MmFYJcPAOgA")
        {
import org.opensearch.common.settings.Settings;
import static org.opensearch.gateway.remote.model.RemoteCustomMetadata.CUSTOM_DELIMITER;
                }
            )
        ClusterMetadataManifest originalManifest = ClusterMetadataManifest.builder()
    }
        ClusterMetadataManifest originalManifest = ClusterMetadataManifest.builder()
        }
        builder.endObject();
import org.opensearch.test.EqualsHashCodeTestUtils;
                    uploadedIndexMetadata.getIndexName(),
            assertEquals(originalManifest, fromXContentManifest);
                }
            .indicesRouting(Collections.singletonList(uploadedIndexMetadata))
        final StringKeyDiffProvider<IndexRoutingTable> routingTableIncrementalDiff = Mockito.mock(StringKeyDiffProvider.class);
                    ClusterMetadataManifest::new
            .stateVersion(1L)
            orig -> OpenSearchTestCase.copyWriteable(orig, new NamedWriteableRegistry(Collections.emptyList()), UploadedIndexMetadata::new),
                initialManifest,
                initialManifest,
                    return builder.build();
        ClusterMetadataManifest originalManifest = ClusterMetadataManifest.builder()
        {
            "routing-path",
import org.opensearch.cluster.metadata.TemplatesMetadata;
            .coordinationMetadata(uploadedMetadataAttribute)
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
                        ),
                    new NamedWriteableRegistry(Collections.emptyList()),
            .opensearchVersion(Version.CURRENT)
            .routingTableVersion(1L)
                }
                    ClusterMetadataManifest::new
                    ClusterMetadataManifest::new
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
        }
                    new NamedWriteableRegistry(Collections.emptyList()),
        ClusterMetadataManifest originalManifest = ClusterMetadataManifest.builder()
                    Arrays.asList(
                        ),
        return new UploadedMetadataAttribute("attribute_name", "testing_attribute");
                            "custom--repositories-file"
            .templatesMetadata(uploadedMetadataAttribute)
                initialManifest,
        builder.startObject();
                    new NamedWriteableRegistry(Collections.emptyList()),
                        new UploadedMetadataAttribute(
            .clusterStateCustomMetadataMap(Collections.emptyMap())
import org.opensearch.cluster.metadata.Metadata;
            .discoveryNodesMetadata(new UploadedMetadataAttribute(DISCOVERY_NODES, "discovery-nodes-file"))
        {
        ClusterMetadataManifest initialManifest = ClusterMetadataManifest.builder()
                )
}
            );
            .customMetadataMap(
                    ClusterMetadataManifest::new
        assertEquals(CODEC_V4, ClusterMetadataManifest.getCodecForVersion(Version.V_2_17_0));
        originalUploadedIndexMetadata.toXContent(builder, ToXContent.EMPTY_PARAMS);
            );
import org.opensearch.cluster.routing.StringKeyDiffProvider;
                    return builder.build();
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
            .nodeId("test-node-id")
            final UploadedIndexMetadata fromXContentUploadedIndexMetadata = UploadedIndexMetadata.fromXContent(parser, 1L);
        originalManifest.toXContent(builder, ToXContent.EMPTY_PARAMS);
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
                ).stream().collect(Collectors.toMap(UploadedMetadataAttribute::getAttributeName, Function.identity()))
                manifest -> {
                        ),
            .stateUUID("test-state-uuid")
                            CUSTOM_METADATA + CUSTOM_DELIMITER + RepositoriesMetadata.TYPE,
                    orig,
            .clusterUUIDCommitted(true)
    public static List<UploadedIndexMetadata> randomUploadedIndexMetadataList() {
        final UploadedIndexMetadata originalUploadedIndexMetadata = new UploadedIndexMetadata(
                    RemoteClusterStateServiceTests.generateClusterStateWithOneIndex().build(),
                ),
                }
                    Arrays.asList(
import org.opensearch.cluster.ClusterName;
                )
        {
            .clusterUUID("test-cluster-uuid")
                initialManifest,
                ),
                            CUSTOM_METADATA + CUSTOM_DELIMITER + IndexGraveyard.TYPE,
            )
                    new NamedWriteableRegistry(Collections.emptyList()),
 */
        );
            .discoveryNodesMetadata(uploadedMetadataAttribute)
            )
    public void testClusterMetadataManifestSerializationEqualsHashCode() {
        super.tearDown();
            .build();
        final XContentBuilder builder = JsonXContent.contentBuilder();
    public void testClusterMetadataManifestXContentV1() throws IOException {
        builder.startObject();
            uploadedIndexMetadata,
            // Mutate checksum
        builder.endObject();
            .opensearchVersion(Version.CURRENT)
            .stateVersion(1L)
        builder.startObject();
                manifest -> {
                    CODEC_V2,
            .clusterUUIDCommitted(true)
            .stateUUID("test-state-uuid")
        {  // Mutate Indices
            .codecVersion(CODEC_V2)
            );
            .numberOfReplicas(0)
                    Arrays.asList(
            "test-index",
            .routingTableVersion(1L)
            final ClusterMetadataManifest fromXContentManifest = ClusterMetadataManifest.fromXContent(parser);
            final ClusterMetadataManifest fromXContentManifest = ClusterMetadataManifest.fromXContentV0(parser);
                initialManifest,
import java.util.stream.Collectors;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
            .metadata(
import org.opensearch.cluster.metadata.RepositoriesMetadata;
            .indices(Collections.singletonList(uploadedIndexMetadata))
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
            )
                    builder.checksum(null);
                    builder.clusterUUID("efOkMiPbQZCUQQgtFWdbPw");
import java.util.Map;
 * compatible open source license.
            case 2:
            .put(IndexTemplateMetadata.builder("template1").settings(idxSettings).patterns(List.of("test*")).build())
            .clusterStateCustomMetadataMap(Collections.emptyMap())
        }
                            "custom--index_graveyard-file"
            "test_file_name",
        originalManifest.toXContent(builder, ToXContent.EMPTY_PARAMS);
            // Mutate diff manifest
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                orig -> OpenSearchTestCase.copyWriteable(
                    ClusterMetadataManifest::new
        }
                    ClusterMetadataManifest::new
                    uploadedIndexMetadata.getUploadedFilename()
import java.util.Arrays;
            final ClusterMetadataManifest fromXContentManifest = ClusterMetadataManifest.fromXContent(parser);
    }
                        new UploadedMetadataAttribute(
            .settingMetadata(uploadedMetadataAttribute)
                    return builder.build();
        {
                ),
    public void testUploadedIndexMetadataSerializationEqualsHashCode() {
        );
                    .putCustom(customMetadata.getWriteableName(), customMetadata)
import java.util.Collections;
                        new UploadedMetadataAttribute(
        UploadedMetadataAttribute uploadedMetadataAttribute = new UploadedMetadataAttribute("attribute_name", "testing_attribute");
                    orig,
                ),
                            "custom--weighted_routing_netadata-file"
import org.opensearch.test.OpenSearchTestCase;
                    ClusterState.EMPTY_STATE,
                            "custom--repositories-file"
                orig -> OpenSearchTestCase.copyWriteable(
        {  // Mutate Committed State
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
                    builder.indices(randomUploadedIndexMetadataList());
        }
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V4;
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V0;
                new ClusterStateDiffManifest(
import java.io.IOException;
            .routingTableVersion(1L)
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(index.getName()).settings(idxSettings)
            .clusterBlocksMetadata(uploadedMetadataAttribute)
                    routingTableIncrementalDiff,
            .checksum(new ClusterStateChecksum(createClusterState(), threadPool))
                        ),
                            CUSTOM_METADATA + CUSTOM_DELIMITER + RepositoriesMetadata.TYPE,
        }
import java.util.ArrayList;
                orig -> OpenSearchTestCase.copyWriteable(
            .discoveryNodesMetadata(uploadedMetadataAttribute)
            .templatesMetadata(uploadedMetadataAttribute)
    }
        final StringKeyDiffProvider<IndexRoutingTable> routingTableIncrementalDiff = Mockito.mock(StringKeyDiffProvider.class);
                            "custom--index_graveyard-file"
            .indices(Collections.singletonList(uploadedIndexMetadata))
        ClusterMetadataManifest originalManifest = ClusterMetadataManifest.builder()
        }
                ).stream().collect(Collectors.toMap(UploadedMetadataAttribute::getAttributeName, Function.identity()))
            .opensearchVersion(Version.CURRENT)
import static org.opensearch.gateway.remote.model.RemoteCustomMetadata.CUSTOM_METADATA;
            );
                    ClusterMetadataManifest::new
            .stateUUID("test-state-uuid")
                            CUSTOM_METADATA + CUSTOM_DELIMITER + WeightedRoutingMetadata.TYPE,
                    uploadedIndexMetadata.getUploadedFilename()
            .clusterStateCustomMetadataMap(Collections.emptyMap())
                    .templates(templatesMetadata)
                initialManifest,
                ),
                    return builder.build();
                    orig,
            .committed(true)
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            )
                    orig,
                    uploadedIndexMetadata.getIndexUUID(),
        final RemoteClusterStateTestUtils.CustomMetadata1 customMetadata = new RemoteClusterStateTestUtils.CustomMetadata1(
                            "custom--weighted_routing_netadata-file"
        UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "test-uuid", "/test/upload/path");
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
            .build();
        { // Mutate Previous cluster UUID
        final XContentBuilder builder = JsonXContent.contentBuilder();
            .checksum(checksum)
            metadata -> randomlyChangingUploadedIndexMetadata(uploadedIndexMetadata)
                    new NamedWriteableRegistry(Collections.emptyList()),
/*
            .clusterTerm(1L)
                    uploadedMetadataAttribute.getUploadedFilename()
                }
                manifest -> {
            .stateVersion(1L)
    }
    public void testUploadedIndexMetadataWithoutComponentPrefix() throws IOException {
            .version(1L)
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;
        {
                    orig,
                ),
        {  // Mutate Cluster UUID
                    )
                manifest -> {
            );
            .clusterUUIDCommitted(true)
                    orig,
                    builder.opensearchVersion(Version.V_EMPTY);
            // Mutate cluster blocks
        assertEquals(CODEC_V3, ClusterMetadataManifest.getCodecForVersion(Version.V_2_16_0));
            .transientSettingsMetadata(uploadedMetadataAttribute)
            .nodeId("test-node-id")
                }
                            CUSTOM_METADATA + CUSTOM_DELIMITER + WeightedRoutingMetadata.TYPE,
        final Index index = new Index("test-index", "index-uuid");
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
            );
    public void testClusterMetadataManifestXContent() throws IOException {
    }
        }
            assertEquals(originalUploadedIndexMetadata, fromXContentUploadedIndexMetadata);
                    .hashesOfConsistentSettings(Map.of("key1", "value1", "key2", "value2"))
                    ClusterMetadataManifest::new
            .stateVersion(1L)
                }
                    new NamedWriteableRegistry(Collections.emptyList()),
            .routingTableVersion(1L)
            .transientSettingsMetadata(uploadedMetadataAttribute)
    private UploadedMetadataAttribute randomUploadedMetadataAttribute() {
                Collections.unmodifiableList(
                ).stream().collect(Collectors.toMap(UploadedMetadataAttribute::getAttributeName, Function.identity()))
            .diffManifest(
        assertEquals(CODEC_V1, ClusterMetadataManifest.getCodecForVersion(Version.V_2_12_0));
                manifest -> {
                    return builder.build();
                orig -> OpenSearchTestCase.copyWriteable(
        }
                    ClusterMetadataManifest::new
        while (uploadedIndexMetadataList.size() < size) {
        builder.startObject();
                ),
            .build();
                initialManifest,
        {  // Mutate State UUID
                    new NamedWriteableRegistry(Collections.emptyList()),
        final List<UploadedIndexMetadata> uploadedIndexMetadataList = new ArrayList<>(size);
            .clusterUUID("test-cluster-uuid")
                            CUSTOM_METADATA + CUSTOM_DELIMITER + WeightedRoutingMetadata.TYPE,
                Collections.unmodifiableList(
            .previousClusterUUID("prev-cluster-uuid")
                    null,
                            "custom--index_graveyard-file"
        UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "test-uuid", "/test/upload/path");
    private UploadedIndexMetadata randomlyChangingUploadedIndexMetadata(UploadedIndexMetadata uploadedIndexMetadata) {
            CODEC_V1
                orig -> OpenSearchTestCase.copyWriteable(
            .settingMetadata(uploadedMetadataAttribute)
            .templatesMetadata(uploadedMetadataAttribute)
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
        }
                        )
                        new UploadedMetadataAttribute(
                    builder.templatesMetadata(randomUploadedMetadataAttribute());
            .stateVersion(1L)
            final ClusterMetadataManifest fromXContentManifest = ClusterMetadataManifest.fromXContent(parser);
                            CUSTOM_METADATA + CUSTOM_DELIMITER + RepositoriesMetadata.TYPE,
        {
                            "custom--weighted_routing_netadata-file"
            .indicesRouting(Collections.singletonList(uploadedIndexMetadata))
            // Mutate hashes of consistent settings
            .build();
            case 0:
                manifest -> {
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
        final TemplatesMetadata templatesMetadata = TemplatesMetadata.builder()
            // Mutate discovery nodes
import org.opensearch.threadpool.TestThreadPool;
                    orig,
                    ClusterMetadataManifest::new
import java.util.List;
        builder.startObject();
            .indices(Collections.singletonList(uploadedIndexMetadata))
                            CUSTOM_METADATA + CUSTOM_DELIMITER + RepositoriesMetadata.TYPE,
                    builder.clusterTerm(1338L);
                    builder.previousClusterUUID("vZX62DCQEOzGXlxXCrEu");
            );
        UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "test-uuid", "/test/upload/path");
                        new UploadedMetadataAttribute(
                    ClusterState.EMPTY_STATE,
        return new UploadedIndexMetadata(randomAlphaOfLength(10), randomAlphaOfLength(10), randomAlphaOfLength(10));
            .coordinationMetadata(uploadedMetadataAttribute)
                        ),
        builder.startObject();
                    ClusterState.EMPTY_STATE,
                ).stream().collect(Collectors.toMap(UploadedMetadataAttribute::getAttributeName, Function.identity()))
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
                        new UploadedMetadataAttribute(
                    .clusterUUID("cluster-uuid")
            .routingTable(RoutingTable.builder().addAsNew(indexMetadata).version(1L).build())
    }
                ).stream().collect(Collectors.toMap(UploadedMetadataAttribute::getAttributeName, Function.identity()))
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
                ),
            .numberOfShards(1)
            // Mutate Coordination metadata
            .clusterUUIDCommitted(true)
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
            .committed(false)
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedIndexMetadata;
import static org.opensearch.gateway.remote.model.RemoteTemplatesMetadata.TEMPLATES_METADATA;
                manifest -> {
import org.opensearch.cluster.metadata.IndexMetadata;
            .committed(false)
            .build();
    static ClusterState createClusterState() {
                    ClusterMetadataManifest::new
            .clusterUUIDCommitted(true)
        builder.endObject();
                        new UploadedMetadataAttribute(
        assertEquals(-1, ClusterMetadataManifest.getCodecForVersion(Version.V_2_1_0));
                    orig,
                    RemoteClusterStateServiceTests.generateClusterStateWithOneIndex().build(),
        final XContentBuilder builder = JsonXContent.contentBuilder();
            .previousClusterUUID("prev-cluster-uuid")
        ClusterStateChecksum checksum = new ClusterStateChecksum(createClusterState(), threadPool);
                manifest -> {
        builder.startObject();
            );
                );
            .previousClusterUUID("prev-cluster-uuid")
                new ClusterStateDiffManifest(
                    return builder.build();
                        )
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
        }
        }
    public void teardown() throws Exception {
            .build();
                    ClusterMetadataManifest::new
                    builder.transientSettingsMetadata(randomUploadedMetadataAttribute());
            .clusterTerm(1L)
        }
            .clusterTerm(1L)
                    builder.customMetadataMap(Collections.emptyMap());
        { // Mutate cluster uuid committed
            "test-uuid",
    }
                    new NamedWriteableRegistry(Collections.emptyList()),
            assertEquals(originalManifest, fromXContentManifest);
    public void testGetCodecForVersion() {
                    Arrays.asList(
            .clusterUUID("test-cluster-uuid")
                            CUSTOM_METADATA + CUSTOM_DELIMITER + IndexGraveyard.TYPE,
                orig -> OpenSearchTestCase.copyWriteable(
                manifest -> {
                }
                        new UploadedMetadataAttribute(
                    new NamedWriteableRegistry(Collections.emptyList()),
            .nodeId("test-node-id")
                            CUSTOM_METADATA + CUSTOM_DELIMITER + IndexGraveyard.TYPE,
                }
            .settingMetadata(uploadedMetadataAttribute)
                    return builder.build();
            .committed(false)
            .build();
        );
                    ClusterMetadataManifest::new
            .diffManifest(
            .clusterUUID("HrYF3kP5SmSPWtKlWhnNSA")
            )
        }
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
            .indices(randomUploadedIndexMetadataList())
    }
        UploadedMetadataAttribute uploadedMetadataAttribute = new UploadedMetadataAttribute("attribute_name", "testing_attribute");
        originalManifest.toXContent(builder, ToXContent.EMPTY_PARAMS);
            .hashesOfConsistentSettings(new UploadedMetadataAttribute(HASHES_OF_CONSISTENT_SETTINGS, "hashes-of-consistent-settings-file"))
            .opensearchVersion(Version.CURRENT)
                            "custom--repositories-file"
                        )
            );
        final XContentBuilder builder = JsonXContent.contentBuilder();
                    )
import java.util.function.Function;
                    .persistentSettings(settings)
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
                    randomAlphaOfLength(10),
        originalManifest.toXContent(builder, ToXContent.EMPTY_PARAMS);
