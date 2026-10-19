            .discoveryNodesMetadata(new UploadedMetadataAttribute(DISCOVERY_NODES, "discovery-nodes-file"))  
    }
                    ClusterMetadataManifest::new
        originalManifest.toXContent(builder, ToXContent.EMPTY_PARAMS);
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {  
    public void testUploadedIndexMetadataWithoutComponentPrefix() throws IOException {  
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());  
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);  
                );  
            .discoveryNodesMetadata(uploadedMetadataAttribute)  
        UploadedMetadataAttribute uploadedMetadataAttribute = new UploadedMetadataAttribute("attribute_name", "testing_attribute");
                    return builder.build();  
                    Arrays.asList(  
            .opensearchVersion(Version.CURRENT)  
                    orig,
        );  
            // Mutate discovery nodes
                    new NamedWriteableRegistry(Collections.emptyList()),  
        }  
                );  
                orig -> OpenSearchTestCase.copyWriteable(
        {  
                        new UploadedMetadataAttribute(
                orig -> OpenSearchTestCase.copyWriteable(  
        {
        builder.startObject();  
            )  
            .customMetadataMap(
                    .clusterUUID("cluster-uuid")  
        final XContentBuilder builder = JsonXContent.contentBuilder();
                    .build()  
        assertEquals(-1, ClusterMetadataManifest.getCodecForVersion(Version.V_2_1_0));
                    uploadedIndexMetadata.getIndexUUID(),
            .diffManifest(
        final Index index = new Index("test-index", "index-uuid");  
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V2;
        }
    }
            .clusterUUIDCommitted(true)  
        }
                        ),  
    private UploadedMetadataAttribute randomUploadedMetadataAttribute() {
            .indices(randomUploadedIndexMetadataList())
                }  
        assertEquals(CODEC_V2, ClusterMetadataManifest.getCodecForVersion(Version.V_2_15_0));  
                    orig,
    }  
        );  
            .numberOfReplicas(0)
                    ClusterState.EMPTY_STATE,
                manifest -> {
            .opensearchVersion(Version.CURRENT)
        UploadedIndexMetadata uploadedIndexRoutingMetadata = new UploadedIndexMetadata(  
                    .put(indexMetadata, true)
                    builder.templatesMetadata(randomUploadedMetadataAttribute());  
        return new UploadedIndexMetadata(randomAlphaOfLength(10), randomAlphaOfLength(10), randomAlphaOfLength(10));
    public void testClusterMetadataManifestXContentV3() throws IOException {  
                orig -> OpenSearchTestCase.copyWriteable(
                    orig,
                            "custom--weighted_routing_netadata-file"  
                    ClusterMetadataManifest::new
                    Arrays.asList(  
                    ClusterMetadataManifest::new
                    uploadedMetadataAttribute.getUploadedFilename()
            .stateUUID("6By9p9G0Rv2MmFYJcPAOgA")  
                    new NamedWriteableRegistry(Collections.emptyList()),
        final XContentBuilder builder = JsonXContent.contentBuilder();
    }
            .clusterUUID("test-cluster-uuid")
    public void testClusterMetadataManifestXContentV4() throws IOException {
            .nodeId("B10RX1f5RJenMQvYccCgSQ")
import static org.opensearch.gateway.remote.RemoteClusterStateAttributesManager.CLUSTER_BLOCKS;
            .opensearchVersion(Version.CURRENT)
                            CUSTOM_METADATA + CUSTOM_DELIMITER + WeightedRoutingMetadata.TYPE,
            .stateVersion(1L)
            assertTrue(uploadedIndexMetadataList.add(randomUploadedIndexMetadata()));
    }
                initialManifest,  
            .stateUUID("test-state-uuid")
import org.opensearch.core.xcontent.XContentParser;
                            CUSTOM_METADATA + CUSTOM_DELIMITER + WeightedRoutingMetadata.TYPE,  
    }  
        originalManifest.toXContent(builder, ToXContent.EMPTY_PARAMS);
            assertEquals(originalManifest, fromXContentManifest);  
        while (uploadedIndexMetadataList.size() < size) {
        switch (randomInt(2)) {  
                    builder.coordinationMetadata(randomUploadedMetadataAttribute());
                }
                    builder.transientSettingsMetadata(randomUploadedMetadataAttribute());
                    orig,
            .committed(true)  
                    new NamedWriteableRegistry(Collections.emptyList()),  
        originalManifest.toXContent(builder, ToXContent.EMPTY_PARAMS);  
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
        {  // Mutate Indices
            .committed(false)
                }
    public void teardown() throws Exception {  
                    ClusterMetadataManifest::new
                }
                    RemoteClusterStateServiceTests.generateClusterStateWithOneIndex().build(),
        }  
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V3;  
                        )
            // Mutate template metadata
                    return builder.build();  
                manifest -> {
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
            .coordinationMetadata(new UploadedMetadataAttribute(COORDINATION_METADATA, "coordination-file"))  
                initialManifest,
                    randomAlphaOfLength(10),
                    builder.checksum(null);
                    builder.discoveryNodesMetadata(randomUploadedMetadataAttribute());
        final UploadedIndexMetadata originalUploadedIndexMetadata = new UploadedIndexMetadata(
                            CUSTOM_METADATA + CUSTOM_DELIMITER + IndexGraveyard.TYPE,
            .clusterStateCustomMetadataMap(Collections.emptyMap())
                    orig,  
            .build();  
                    .putCustom(customMetadata.getWriteableName(), customMetadata)
                    new NamedWriteableRegistry(Collections.emptyList()),
                        new UploadedMetadataAttribute(  
        );
        builder.startObject();  
                manifest -> {  
                ),
        }  
                orig -> OpenSearchTestCase.copyWriteable(
                    )
            final UploadedIndexMetadata fromXContentUploadedIndexMetadata = UploadedIndexMetadata.fromXContent(parser, 1L);
            .stateUUID("test-state-uuid")
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
            .build();
    public void testClusterMetadataManifestXContent() throws IOException {
        ClusterMetadataManifest originalManifest = ClusterMetadataManifest.builder()
            final ClusterMetadataManifest fromXContentManifest = ClusterMetadataManifest.fromXContent(parser);  
            .nodeId("test-node-id")  
        UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "test-uuid", "/test/upload/path");
            );
        builder.endObject();
                            "custom--weighted_routing_netadata-file"  
        final RemoteClusterStateTestUtils.CustomMetadata1 customMetadata = new RemoteClusterStateTestUtils.CustomMetadata1(
                Collections.unmodifiableList(
 */  
    private static UploadedIndexMetadata randomUploadedIndexMetadata() {
        }
        { // Mutate Previous cluster UUID
        }  
                    new NamedWriteableRegistry(Collections.emptyList()),  
                new ClusterStateDiffManifest(  
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(1L).build();  
            // Mutate checksum  
                            "custom--repositories-file"
        UploadedMetadataAttribute uploadedMetadataAttribute = new UploadedMetadataAttribute("attribute_name", "testing_attribute");
            )
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
            .indicesRouting(Collections.singletonList(uploadedIndexMetadata))  
                            "custom--index_graveyard-file"
        {  // Mutate Committed State
            .previousClusterUUID("yfObdx8KSMKKrXf8UyHhM")  
                    uploadedMetadataAttribute.getUploadedFilename()
            assertEquals(originalManifest, fromXContentManifest);
import org.opensearch.cluster.routing.IndexRoutingTable;  
                initialManifest,  
                Collections.unmodifiableList(
            .clusterUUIDCommitted(true)
                    RemoteClusterStateServiceTests.generateClusterStateWithOneIndex().build(),
            .customMetadataMap(
            .opensearchVersion(Version.CURRENT)  
                ),  
                    builder.opensearchVersion(Version.V_EMPTY);
            .routingTableVersion(1L)
        final Settings idxSettings = Settings.builder()
                    uploadedIndexMetadata.getIndexName(),  
            .clusterUUID("test-cluster-uuid")  
                orig -> OpenSearchTestCase.copyWriteable(  
        builder.startObject();  
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);  
            .stateUUID("test-state-uuid")
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
            .clusterUUID("test-cluster-uuid")
import static org.opensearch.gateway.remote.model.RemoteTransientSettingsMetadata.TRANSIENT_SETTING_METADATA;
            assertEquals(originalUploadedIndexMetadata, fromXContentUploadedIndexMetadata);
                }
                    )
            .indices(Collections.singletonList(uploadedIndexMetadata))
                ).stream().collect(Collectors.toMap(UploadedMetadataAttribute::getAttributeName, Function.identity()))  
                manifest -> {  
                    new NamedWriteableRegistry(Collections.emptyList()),  
            .templatesMetadata(uploadedMetadataAttribute)
                            CUSTOM_METADATA + CUSTOM_DELIMITER + RepositoriesMetadata.TYPE,
                ),
                    uploadedIndexMetadata.getIndexName(),  
            .opensearchVersion(Version.CURRENT)  
    @After
                    Arrays.asList(
                    builder.clusterUUIDCommitted(false);  
        final StringKeyDiffProvider<IndexRoutingTable> routingTableIncrementalDiff = Mockito.mock(StringKeyDiffProvider.class);
import org.opensearch.cluster.routing.StringKeyDiffProvider;
                    return builder.build();
                    )  
            "test-index",
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
        final Settings settings = Settings.builder().put("mock-settings", true).build();
                manifest -> {
            );
                new ClusterStateDiffManifest(  
                initialManifest,  
            .nodeId("test-node-id")  
                }  
            assertEquals(originalManifest, fromXContentManifest);
                    new NamedWriteableRegistry(Collections.emptyList()),  
                    CODEC_V2,
            "test_file_name",
                        )  
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V0;  
            .settingMetadata(uploadedMetadataAttribute)  
                        new UploadedMetadataAttribute(
        UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "test-uuid", "/test/upload/path");
            .build();
                manifest -> {
                            CUSTOM_METADATA + CUSTOM_DELIMITER + IndexGraveyard.TYPE,
                        ),
    public void testClusterMetadataManifestXContentV2() throws IOException {
        UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "test-uuid", "/test/upload/path");
            .previousClusterUUID("prev-cluster-uuid")
                        ),
        builder.endObject();
        assertEquals(CODEC_V3, ClusterMetadataManifest.getCodecForVersion(Version.V_2_16_0));
            .codecVersion(CODEC_V3)  
    static ClusterState createClusterState() {
        {  // Mutate State UUID
                manifest -> {  
                    ClusterMetadataManifest::new
                    new NamedWriteableRegistry(Collections.emptyList()),
            .stateVersion(1L)
        assertEquals(CODEC_V0, ClusterMetadataManifest.getCodecForVersion(Version.V_2_10_0));  
            .stateVersion(1L)  
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(CODEC_V1, ClusterMetadataManifest.getCodecForVersion(Version.V_2_13_0));
        return new UploadedMetadataAttribute("attribute_name", "testing_attribute");  
                );  
            final ClusterMetadataManifest fromXContentManifest = ClusterMetadataManifest.fromXContentV0(parser);
                        ),  
        }
                        )
package org.opensearch.gateway.remote;
                    orig,
                initialManifest,
            .templatesMetadata(uploadedMetadataAttribute)
                    return builder.build();
            .clusterUUID("test-cluster-uuid")  
            .indicesRouting(Collections.singletonList(uploadedIndexMetadata))
                Collections.unmodifiableList(
                            "custom--index_graveyard-file"
                initialManifest,
                            "custom--index_graveyard-file"
                    )
            .stateVersion(1L)
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {  
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);  
import java.util.function.Function;
                }  
        builder.endObject();
            .clusterUUIDCommitted(true)  
import org.opensearch.test.EqualsHashCodeTestUtils;
        builder.startObject();
        builder.startObject();
            .build();
            );  
            // Mutate diff manifest
            .customMetadataMap(
            .coordinationMetadata(new UploadedMetadataAttribute(COORDINATION_METADATA, "coordination-file"))
                        ),
        {
            .settingMetadata(uploadedMetadataAttribute)
        builder.endObject();  
            final ClusterMetadataManifest fromXContentManifest = ClusterMetadataManifest.fromXContent(parser);
            .customMetadataMap(
                    routingTableIncrementalDiff,
                initialManifest,  
            .clusterUUIDCommitted(true)
                            "custom--repositories-file"
                )
                    builder.stateUUID("efOkMiPbQZCUQQgtFWdbPw");
                    return builder.build();  
                initialManifest,
                ).stream().collect(Collectors.toMap(UploadedMetadataAttribute::getAttributeName, Function.identity()))  
            .clusterUUIDCommitted(true)  
            .previousClusterUUID("prev-cluster-uuid")
import org.opensearch.common.settings.Settings;  
            .clusterBlocksMetadata(uploadedMetadataAttribute)
                )  
import java.util.Collections;
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
            .nodeId("test-node-id")  
        originalManifest.toXContent(builder, ToXContent.EMPTY_PARAMS);
import static org.opensearch.gateway.remote.model.RemoteCustomMetadata.CUSTOM_DELIMITER;
                orig -> OpenSearchTestCase.copyWriteable(  
            .codecVersion(CODEC_V2)
            .transientSettingsMetadata(uploadedMetadataAttribute)
import org.opensearch.Version;
                        ),
                            CUSTOM_METADATA + CUSTOM_DELIMITER + IndexGraveyard.TYPE,
                orig -> OpenSearchTestCase.copyWriteable(
            .customMetadataMap(  
                        ),
                        ),  
                    .persistentSettings(settings)
        }  
                        ),  
            .diffManifest(
                initialManifest,  
                new ClusterStateDiffManifest(  
            )
                ).stream().collect(Collectors.toMap(UploadedMetadataAttribute::getAttributeName, Function.identity()))
            "custom-metadata-1"  
            .previousClusterUUID("prev-cluster-uuid")
        }  
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
                    orig,
        builder.startObject();  
                        )  
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
                        )
                manifest -> {
                ),
            "test-index",
import org.opensearch.cluster.routing.RoutingTable;
            .customMetadataMap(  
            .numberOfShards(1)  
                    ClusterMetadataManifest::new  
        }  
            .clusterTerm(1L)
            .stateVersion(1L)  
            "routing-path",  
                ),  
            case 1:
            );
                    Arrays.asList(
                }
                        new UploadedMetadataAttribute(
                ).stream().collect(Collectors.toMap(UploadedMetadataAttribute::getAttributeName, Function.identity()))
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedIndexMetadata;
            );
                    ClusterState.EMPTY_STATE,  
            );
        builder.endObject();
                orig -> OpenSearchTestCase.copyWriteable(
                            "custom--repositories-file"  
        }
                    new NamedWriteableRegistry(Collections.emptyList()),  
                return new UploadedIndexMetadata(
                ),
        originalManifest.toXContent(builder, ToXContent.EMPTY_PARAMS);
            .build();
        return uploadedIndexMetadataList;
        builder.endObject();
            .codecVersion(CODEC_V1)
                }
        UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "test-uuid", "/test/upload/path");  
            assertEquals(originalManifest, fromXContentManifest);  
                    ClusterMetadataManifest::new  
import static org.opensearch.gateway.remote.model.RemoteCoordinationMetadata.COORDINATION_METADATA;
                manifest -> {  
            .stateUUID("test-state-uuid")  
            .hashesOfConsistentSettings(uploadedMetadataAttribute)  
                    orig,
            .codecVersion(ClusterMetadataManifest.CODEC_V4)
    public void testClusterMetadataManifestSerializationEqualsHashCode() {
                            CUSTOM_METADATA + CUSTOM_DELIMITER + IndexGraveyard.TYPE,
        { // Mutate cluster uuid committed
        final XContentBuilder builder = JsonXContent.contentBuilder();  
                            CUSTOM_METADATA + CUSTOM_DELIMITER + WeightedRoutingMetadata.TYPE,
    public void testGetCodecForVersion() {  
            .clusterUUIDCommitted(true)
                    )
            // Mutate custom metadata  
                            CUSTOM_METADATA + CUSTOM_DELIMITER + RepositoriesMetadata.TYPE,  
                    new NamedWriteableRegistry(Collections.emptyList()),  
        ClusterMetadataManifest originalManifest = ClusterMetadataManifest.builder()
        final XContentBuilder builder = JsonXContent.contentBuilder();
            final ClusterMetadataManifest fromXContentManifest = ClusterMetadataManifest.fromXContent(parser);
                    ClusterMetadataManifest::new
            .diffManifest(
                    builder.clusterUUID("efOkMiPbQZCUQQgtFWdbPw");
            // Mutate hashes of consistent settings
            .committed(false)
                manifest -> {  
        }
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
            )
                manifest -> {  
                ),
                ),
        assertEquals(CODEC_V1, ClusterMetadataManifest.getCodecForVersion(Version.V_2_12_0));
                    "indicesRoutingDiffPath"
        final XContentBuilder builder = JsonXContent.contentBuilder();
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
            )  
            .put(IndexTemplateMetadata.builder("template1").settings(idxSettings).patterns(List.of("test*")).build())  
                            "custom--index_graveyard-file"  
        final TemplatesMetadata templatesMetadata = TemplatesMetadata.builder()
                            "custom--weighted_routing_netadata-file"
                ).stream().collect(Collectors.toMap(UploadedMetadataAttribute::getAttributeName, Function.identity()))
                    ClusterMetadataManifest::new
                    orig,
            CODEC_V1
            .settingMetadata(uploadedMetadataAttribute)
    }
            .codecVersion(ClusterMetadataManifest.CODEC_V4)  
            .indicesRouting(Collections.singletonList(uploadedIndexRoutingMetadata))  
                        ),
            .routingTableVersion(1L)
            );  
            .indices(Collections.singletonList(uploadedIndexMetadata))
    public void testClusterMetadataManifestXContentV2WithoutEphemeral() throws IOException {  
    public static List<UploadedIndexMetadata> randomUploadedIndexMetadataList() {
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
        ClusterMetadataManifest originalManifest = ClusterMetadataManifest.builder()
            )
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedMetadataAttribute;  
                manifest -> {
import org.opensearch.threadpool.TestThreadPool;  
            .clusterTerm(1L)
import java.util.Arrays;  
                    return builder.build();  
                    ClusterMetadataManifest::new
import org.opensearch.cluster.metadata.IndexGraveyard;
        return ClusterState.builder(ClusterName.DEFAULT)
import org.opensearch.core.index.Index;
        builder.endObject();
        }
        originalManifest.toXContent(builder, ToXContent.EMPTY_PARAMS);  
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V1;
                            CUSTOM_METADATA + CUSTOM_DELIMITER + RepositoriesMetadata.TYPE,  
import org.opensearch.cluster.coordination.CoordinationMetadata;
                        new UploadedMetadataAttribute(
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
                initialManifest,  
                    new NamedWriteableRegistry(Collections.emptyList()),
import java.util.stream.Collectors;
            .previousClusterUUID("prev-cluster-uuid")
            .clusterUUID("HrYF3kP5SmSPWtKlWhnNSA")
        }
            .stateUUID("test-state-uuid")
            // Mutate Coordination metadata  
        }  
import org.opensearch.core.xcontent.XContentBuilder;  
                            CUSTOM_METADATA + CUSTOM_DELIMITER + WeightedRoutingMetadata.TYPE,
            "test-uuid",
                return new UploadedIndexMetadata(
            .indices(Collections.singletonList(uploadedIndexMetadata))  
                            "custom--weighted_routing_netadata-file"
    }
                )  
                    .templates(templatesMetadata)  
        UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "test-uuid", "/test/upload/path", CODEC_V0);  
        {  
            .indicesRouting(Collections.singletonList(uploadedIndexMetadata))
            .committed(false)
import org.junit.After;
import static org.opensearch.gateway.remote.model.RemoteTemplatesMetadata.TEMPLATES_METADATA;  
            uploadedIndexMetadata,  
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(  
import org.opensearch.cluster.metadata.IndexMetadata;  
                    return builder.build();  
            .indices(Collections.singletonList(uploadedIndexMetadata))
import org.mockito.Mockito;
import java.util.Map;  
            .coordinationMetadata(uploadedMetadataAttribute)
            .clusterTerm(1L)
        {  // Mutate Cluster UUID
        }
        UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "test-uuid", "/test/upload/path");
                    builder.hashesOfConsistentSettings(randomUploadedMetadataAttribute());  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(  
        }
                            "custom--index_graveyard-file"
                    new NamedWriteableRegistry(Collections.emptyList()),
                }
        ClusterMetadataManifest originalManifest = ClusterMetadataManifest.builder()  
                    ClusterMetadataManifest::new
        UploadedMetadataAttribute uploadedMetadataAttribute = new UploadedMetadataAttribute("attribute_name", "testing_attribute");
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;
        }  
        super.tearDown();
            .settingMetadata(uploadedMetadataAttribute)
        {
import org.opensearch.test.OpenSearchTestCase;
                    ClusterMetadataManifest::new  
                }
                orig -> OpenSearchTestCase.copyWriteable(
            .routingTableVersion(1L)
            .coordinationMetadata(uploadedMetadataAttribute)
    }
            );  
            .opensearchVersion(Version.CURRENT)
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(  
            .version(1L)  
            .committed(false)
                            CUSTOM_METADATA + CUSTOM_DELIMITER + RepositoriesMetadata.TYPE,
import org.opensearch.cluster.metadata.TemplatesMetadata;
                orig -> OpenSearchTestCase.copyWriteable(
                    orig,
            .templatesMetadata(new UploadedMetadataAttribute(TEMPLATES_METADATA, "templates-file"))
                    ClusterMetadataManifest::new
        originalUploadedIndexMetadata.toXContent(builder, ToXContent.EMPTY_PARAMS);  
                orig -> OpenSearchTestCase.copyWriteable(
import static org.opensearch.gateway.remote.model.RemoteHashesOfConsistentSettings.HASHES_OF_CONSISTENT_SETTINGS;
        assertEquals(-1, ClusterMetadataManifest.getCodecForVersion(Version.fromString("1.3.0")));
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())  
                    orig,  
                        new UploadedMetadataAttribute(  
            );  
            assertEquals(originalManifest, fromXContentManifest);
            .settingMetadata(new UploadedMetadataAttribute(SETTING_METADATA, "setting-file"))  
                        new UploadedMetadataAttribute(
        }  
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
                }
            )
                    return builder.build();
            );
                ),
                orig -> OpenSearchTestCase.copyWriteable(
                    new NamedWriteableRegistry(Collections.emptyList()),  
import java.util.List;
            .nodeId("test-node-id")
                    uploadedIndexMetadata.getIndexUUID(),
                return new UploadedIndexMetadata(
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V4;
        ClusterMetadataManifest initialManifest = ClusterMetadataManifest.builder()
                    builder.settingMetadata(randomUploadedMetadataAttribute());
                ),
import org.opensearch.threadpool.ThreadPool;
                    RemoteClusterStateServiceTests.generateClusterStateWithOneIndex().build(),
            // Mutate cluster blocks
            .build();  
                initialManifest,
                ).stream().collect(Collectors.toMap(UploadedMetadataAttribute::getAttributeName, Function.identity()))
 * The OpenSearch Contributors require contributions made to  
/*  
                    randomAlphaOfLength(10)
                            CUSTOM_METADATA + CUSTOM_DELIMITER + WeightedRoutingMetadata.TYPE,
                    builder.indices(randomUploadedIndexMetadataList());
            .templatesMetadata(uploadedMetadataAttribute)  
import static org.opensearch.gateway.remote.model.RemoteCustomMetadata.CUSTOM_METADATA;  
        {  // Mutate Cluster Term
    public void testClusterMetadataManifestXContentV0() throws IOException {
                    return builder.build();
            .clusterStateCustomMetadataMap(Collections.emptyMap())
                initialManifest,  
            .metadata(
                ),  
        }
import org.opensearch.cluster.metadata.RepositoriesMetadata;  
    }
            )
            .checksum(checksum)
                ),
            orig -> OpenSearchTestCase.copyWriteable(orig, new NamedWriteableRegistry(Collections.emptyList()), UploadedIndexMetadata::new),
import static org.opensearch.gateway.remote.RemoteClusterStateAttributesManager.DISCOVERY_NODES;  
                        new UploadedMetadataAttribute(
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {  
                        ),
            .clusterBlocksMetadata(uploadedMetadataAttribute)
                    .hashesOfConsistentSettings(Map.of("key1", "value1", "key2", "value2"))
                    .coordinationMetadata(coordinationMetadata)
                    ClusterMetadataManifest::new
                ),
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
                            CUSTOM_METADATA + CUSTOM_DELIMITER + RepositoriesMetadata.TYPE,
                    orig,
        final XContentBuilder builder = JsonXContent.contentBuilder();
                new ClusterStateDiffManifest(
                }
                    new NamedWriteableRegistry(Collections.emptyList()),
        }
            .build();
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
        {  
        {  // Mutate OpenSearch Version
                }
            .diffManifest(  
    public void testClusterMetadataManifestXContentV1() throws IOException {
                    new NamedWriteableRegistry(Collections.emptyList()),  
                    uploadedIndexMetadata.getUploadedFilename()
            case 2:
                        new UploadedMetadataAttribute(
            )
            .build();  
            .coordinationMetadata(uploadedMetadataAttribute)  
                    return builder.build();  
            .clusterBlocksMetadata(new UploadedMetadataAttribute(CLUSTER_BLOCKS, "cluster-block-file"))
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
        threadPool.shutdown();
            .checksum(new ClusterStateChecksum(createClusterState(), threadPool))
                orig -> OpenSearchTestCase.copyWriteable(
            .transientSettingsMetadata(new UploadedMetadataAttribute(TRANSIENT_SETTING_METADATA, "transient-settings-file"))
                    builder.stateVersion(8L);
            INDEX_ROUTING_METADATA_PREFIX
                    orig,
                initialManifest,  
                }
                    null  
                    orig,
            "test-index-uuid",  
                    ClusterMetadataManifest::new
        {
        }  
        originalManifest.toXContent(builder, ToXContent.EMPTY_PARAMS);
                    null,
            );
import org.opensearch.cluster.metadata.Metadata;
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
                initialManifest,  
public class ClusterMetadataManifestTests extends OpenSearchTestCase {
        }
            .routingTableVersion(1L)  
                        new UploadedMetadataAttribute(
            );
                    return builder.build();
            .nodeId("test-node-id")
                }
                            "custom--repositories-file"  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
            .clusterStateCustomMetadataMap(Collections.emptyMap())
            .clusterUUID("test-cluster-uuid")
            .clusterUUIDCommitted(true)
            .clusterTerm(1L)  
                            CUSTOM_METADATA + CUSTOM_DELIMITER + IndexGraveyard.TYPE,  
                    return builder.build();
            assertEquals(originalManifest, fromXContentManifest);  
                            CUSTOM_METADATA + CUSTOM_DELIMITER + RepositoriesMetadata.TYPE,
                orig -> OpenSearchTestCase.copyWriteable(
            final ClusterMetadataManifest fromXContentManifest = ClusterMetadataManifest.fromXContent(parser);
                Metadata.builder()  
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
        final int size = randomIntBetween(1, 10);
                manifest -> {
        }  
                    routingTableIncrementalDiff,
    }  
                Collections.unmodifiableList(  
            );
                    .version(randomNonNegativeLong())
            .committed(false)
                    builder.committed(false);
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
        {  // Mutate State Version
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
        final List<UploadedIndexMetadata> uploadedIndexMetadataList = new ArrayList<>(size);  
            case 0:
                    return builder.build();  
            .build();
            .clusterBlocksMetadata(uploadedMetadataAttribute)
 * compatible open source license.
                    uploadedIndexMetadata.getUploadedFilename()
                }
        }  
            .settingMetadata(new UploadedMetadataAttribute(SETTING_METADATA, "setting-file"))
import org.opensearch.cluster.ClusterName;
                            CUSTOM_METADATA + CUSTOM_DELIMITER + WeightedRoutingMetadata.TYPE,  
                manifest -> {  
                    builder.clusterTerm(1338L);
            .clusterUUID("test-cluster-uuid")  
                manifest -> {  
        return uploadedIndexMetadata;
            .codecVersion(CODEC_V0)  
        ClusterMetadataManifest originalManifest = ClusterMetadataManifest.builder()  
                    CODEC_V4,  
        final StringKeyDiffProvider<IndexRoutingTable> routingTableIncrementalDiff = Mockito.mock(StringKeyDiffProvider.class);  
                    orig,
        {
                            "custom--weighted_routing_netadata-file"
            .hashesOfConsistentSettings(uploadedMetadataAttribute)
import static org.opensearch.gateway.remote.model.RemotePersistentSettingsMetadata.SETTING_METADATA;
                    new NamedWriteableRegistry(Collections.emptyList()),  
                initialManifest,
                    orig,
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
        builder.startObject();
            .build();
                )  
                    Arrays.asList(
            .build();
            .clusterUUIDCommitted(true)  
                        new UploadedMetadataAttribute(  
                            CUSTOM_METADATA + CUSTOM_DELIMITER + IndexGraveyard.TYPE,  
                    new NamedWriteableRegistry(Collections.emptyList()),
                    return builder.build();  
                    new NamedWriteableRegistry(Collections.emptyList()),
        UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "test-uuid", "/test/upload/path");  
            .previousClusterUUID("prev-cluster-uuid")  
                ),
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);  
                        ),
            );
    }  
        }  
                }
                initialManifest,
 * SPDX-License-Identifier: Apache-2.0
                orig -> OpenSearchTestCase.copyWriteable(
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
    public void testUploadedIndexMetadataSerializationEqualsHashCode() {  
import static org.opensearch.gateway.remote.routingtable.RemoteIndexRoutingTable.INDEX_ROUTING_METADATA_PREFIX;
        ClusterStateChecksum checksum = new ClusterStateChecksum(createClusterState(), threadPool);  
            );
                    ClusterState.EMPTY_STATE,
            .hashesOfConsistentSettings(new UploadedMetadataAttribute(HASHES_OF_CONSISTENT_SETTINGS, "hashes-of-consistent-settings-file"))  
                    ClusterMetadataManifest.Builder builder = ClusterMetadataManifest.builder(manifest);
        }
                    orig,
            .codecVersion(CODEC_V2)
                manifest -> {
            );
                manifest -> {  
        ClusterMetadataManifest originalManifest = ClusterMetadataManifest.builder()  
        {
                    null,
                initialManifest,
                    ClusterMetadataManifest::new
            .previousClusterUUID("prev-cluster-uuid")
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
            .committed(false)  
    }  
            // Mutate transient settings metadata  
            .transientSettingsMetadata(uploadedMetadataAttribute)
                    CODEC_V3,  
                    ClusterState.EMPTY_STATE,
import org.opensearch.core.common.bytes.BytesReference;
            )
            .clusterUUID("test-cluster-uuid")
                    return builder.build();  
            .clusterTerm(1337L)  
import org.opensearch.core.xcontent.ToXContent;
            .coordinationMetadata(uploadedMetadataAttribute)
            .clusterTerm(1L)
            .discoveryNodesMetadata(uploadedMetadataAttribute)  
                ),  
            )
                    return builder.build();
                            "custom--weighted_routing_netadata-file"
                ),
                ),
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
                Collections.unmodifiableList(
                    builder.previousClusterUUID("vZX62DCQEOzGXlxXCrEu");
                initialManifest,  
    }
            .stateUUID("state-uuid")
import java.io.IOException;
            .hashesOfConsistentSettings(uploadedMetadataAttribute)  
            .indices(Collections.singletonList(uploadedIndexMetadata))  
        assertEquals(CODEC_V4, ClusterMetadataManifest.getCodecForVersion(Version.V_2_17_0));
            .committed(false)
            .clusterTerm(1L)
            .stateVersion(1L)
            .templatesMetadata(uploadedMetadataAttribute)  
        final XContentBuilder builder = JsonXContent.contentBuilder();
                    )  
                manifest -> {  
        );
            metadata -> randomlyChangingUploadedIndexMetadata(uploadedIndexMetadata)
            final ClusterMetadataManifest fromXContentManifest = ClusterMetadataManifest.fromXContentV1(parser);
                    randomAlphaOfLength(10),  
                orig -> OpenSearchTestCase.copyWriteable(
import org.opensearch.common.xcontent.json.JsonXContent;
                    return builder.build();  
            );
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                    new NamedWriteableRegistry(Collections.emptyList()),  
    }
                ),
                Collections.unmodifiableList(  
            );
    private UploadedIndexMetadata randomlyChangingUploadedIndexMetadata(UploadedIndexMetadata uploadedIndexMetadata) {
        builder.startObject();
                            "custom--repositories-file"
                    Arrays.asList(
                    ClusterMetadataManifest::new
        UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "test-uuid", "/test/upload/path", CODEC_V1);
        ClusterMetadataManifest originalManifest = ClusterMetadataManifest.builder()
            final ClusterMetadataManifest fromXContentManifest = ClusterMetadataManifest.fromXContent(parser);
                ),
            .indices(Collections.singletonList(uploadedIndexMetadata))
                        new UploadedMetadataAttribute(
            .clusterStateCustomMetadataMap(Collections.emptyMap())
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
            );
                    builder.clusterBlocksMetadata(randomUploadedMetadataAttribute());  
                    return builder.build();
                    builder.diffManifest(null);
                orig -> OpenSearchTestCase.copyWriteable(
                    ClusterMetadataManifest::new
        }
                orig -> OpenSearchTestCase.copyWriteable(
            .stateVersion(1L)  
            .routingTableVersion(1L)
                        )
            .templatesMetadata(new UploadedMetadataAttribute(TEMPLATES_METADATA, "templates-file"))
                        new UploadedMetadataAttribute(
                orig -> OpenSearchTestCase.copyWriteable(  
            .nodeId("test-node-id")
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(  
            .clusterTerm(1L)
import org.opensearch.cluster.ClusterState;  
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
                manifest -> {  
    }  
                            "custom--index_graveyard-file"  
            assertEquals(originalManifest, fromXContentManifest);  
                    RemoteClusterStateServiceTests.generateClusterStateWithOneIndex().build(),
            .stateUUID("test-state-uuid")
            .opensearchVersion(Version.CURRENT)
                        new UploadedMetadataAttribute(
            .codecVersion(CODEC_V2)
                    return builder.build();  
                        new UploadedMetadataAttribute(  
                        new UploadedMetadataAttribute(  
            .opensearchVersion(Version.CURRENT)
            .previousClusterUUID("prev-cluster-uuid")
                    builder.customMetadataMap(Collections.emptyMap());
                        new UploadedMetadataAttribute(
                    ClusterMetadataManifest.CODEC_V3,  
            .transientSettingsMetadata(uploadedMetadataAttribute)  
            .nodeId("test-node-id")
            .stateUUID("test-state-uuid")
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
import java.util.ArrayList;
        {
                            "custom--repositories-file"
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(index.getName()).settings(idxSettings)
                    ClusterMetadataManifest::new  
                        new UploadedMetadataAttribute(  
            .build();  
                initialManifest,  
            .routingTable(RoutingTable.builder().addAsNew(indexMetadata).version(1L).build())
            // Mutate setting metadata
            .globalMetadataFileName("test-global-metadata-file")  
}
            .stateVersion(7L)
                }  
    }
                    orig,  
        builder.endObject();
            .indices(Collections.singletonList(uploadedIndexMetadata))
        UploadedMetadataAttribute uploadedMetadataAttribute = new UploadedMetadataAttribute("attribute_name", "testing_attribute");
                    orig,  
        final XContentBuilder builder = JsonXContent.contentBuilder();
 *
            .discoveryNodesMetadata(uploadedMetadataAttribute)
