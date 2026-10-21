            null,
            .put(SETTING_NUMBER_OF_REPLICAS, 2)
        assertWarnings(
            )
                new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
            expectThrows(
        if (remoteStoreEnabled) {
        withTemporaryClusterService(((clusterService, threadPool) -> {
                Settings.EMPTY,
        Settings aggregatedSettings = aggregateIndexSettings(
        );
            Settings.EMPTY,
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
            + MapperService.SINGLE_MAPPING_NAME
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
            request,
        Settings settings = Settings.builder().put("node.attr.remote_store.segment.repository", "my-segment-repo-1").build();
            "index source must have all shards allocated on the same node to shrink index",
        withTemporaryClusterService(((clusterService, threadPool) -> {
                0,
            try {
            indexSettings,
            .put("node.attr.remote_store.segment.repository", "my-segment-repo-1")
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
        when(repositoryMock.isSeverSideEncryptionEnabled()).thenReturn(false);
        ) {
            .numberOfShards(1)
        assertThat(indexMetadata.getAliases().size(), is(1));
        final Settings indexSettings = Settings.builder()
                .startObject("properties")
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "lucene")
            .put("index.blocks.write", true)
            null,
            clusterSettings
            new CompressedXContent(templateWithoutDisableObjects),
            Metadata metadata = mock(Metadata.class);
            MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
        Settings clusterBag = Settings.builder()
            clusterSettings
        );
        Map<String, Object> result = MetadataCreateIndexService.parseV1Mappings("", templates, NamedXContentRegistry.EMPTY);
                }
            null,
        List<CompressedXContent> templateMappings = Arrays.asList(new CompressedXContent(template1), new CompressedXContent(template2));
import org.opensearch.ResourceAlreadyExistsException;
    }
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import java.util.UUID;
        // restrict=false — mismatching values are allowed.
            .put(IndicesService.CLUSTER_RESTRICT_PLUGGABLE_DATAFORMAT_SETTING.getKey(), true)
            }
 *
        ClusterService clusterService = mock(ClusterService.class);
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
                null,
        assertEquals(customCreationDate, indexMetadata.getCreationDate());
            IndexCreationException.class,
        ).routingTable();
        Settings settings = Settings.builder()
            Settings.EMPTY,
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 2)
import org.opensearch.index.IndexSettings;
                clusterService,
        // Set index setting refresh interval the same value as the cluster minimum refresh interval
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
        );
    public void testAggregateIndexSettingsIndexReplicaIsSetToNull() {
        MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
    }
        when(clusterService.state()).thenReturn(clusterState);
        Settings aggregatedSettings = aggregateIndexSettings(
                                  "userstate": { "type": "keyword" }
            CountDownLatch counter = new CountDownLatch(1);
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
                + "multiplied by 2 at most ten times (ie. 3 * 2^8)",
    public void testV1TemplateMergingPreservesDynamicObjectWithSubFieldMapping() throws Exception {
            Collections.emptySet(),
            assertThat("analysis settings must be copied", settings.get("index.analysis.analyzer.default.tokenizer"), equalTo("keyword"));
        Settings indexSettings = Settings.builder().put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 3).build();
            .build();
        when(clusterService.state()).thenReturn(clusterState);
            MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
            indicesServices,
    }
        // Extract disable_objects values
            () -> MetadataCreateIndexService.validateIngestionSourceSettings(settings, state)
        IndexMetadata.Builder imdBuilder = IndexMetadata.builder("test").settings(indexSettings);
            ).getMessage()
    }
            threadPool.shutdown();
        do {
        // is set to a value that is equal to the `cluster.default.index.refresh_interval` value.
        );
        checkerService.addRemoteStoreCustomMetadata(imdBuilder, true, clusterState);
            () -> resolveAndValidateAliases(
            new TestGatewayAllocator(),
        IllegalArgumentException e = expectThrows(
            "true",
        // Even the default value 'simple' set explicitly is rejected on a mixed cluster — the version
            () -> aggregateIndexSettings(
        assertThat(updatedClusterState.blocks().getIndexBlockWithId("test", INDEX_READ_ONLY_BLOCK.id()), is(INDEX_READ_ONLY_BLOCK));
        );
    private QueryShardContext queryShardContext;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                null,
        BiFunction<ClusterState, String, ClusterState> rerouteRoutingTable = (clusterState, reason) -> {
        Settings aggregatedSettings = aggregateIndexSettings(
        Settings indexSettings = aggregateIndexSettings(
        assertEquals(
                requestSettings.build(),
    public void testValidatePluggableDataFormatRejectsValueMismatch() {
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
                        "private index setting [%s] can not be set explicitly",
            + "    \"_version\": 1\n"
            );
        );
            false,
            .put("index.ingestion_source.mapper_settings.id_field", "user_id")
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.MIXED)
            "source",
            Settings.EMPTY,
            null,
            );
            false,
            + "        \"properties\": {\n"
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            assertEquals("All mappings should have disable_objects=true from template", true, doc.get("disable_objects"));
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                    + MapperService.SINGLE_MAPPING_NAME
    /**
 * SPDX-License-Identifier: Apache-2.0
        // the REST layer reports it the same way as the built-in validateErrors path does.
            request,
            Settings.EMPTY,
                }
            "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":true,\"properties\":{\"field2\":{\"type\":\"keyword\"}}}}"
            + "      \"@timestamp\": {\"type\": \"date\"},\n"
        when(repositoryMock.blobStore()).thenReturn(blobStoreMock);
        IndexMetadata newIndexMetadata = IndexMetadata.builder("test")
                cs
        docWithoutDisableObjects.put("properties", new HashMap<>());
import org.opensearch.core.xcontent.XContentParser;
import java.util.List;
            cs
    }
        assertEquals(
            ClusterState.EMPTY_STATE,
        BlobStore blobStoreMock = mock(BlobStore.class);
            .add(nonRemoteClusterManagerNode)
        IndexTemplateMetadata basicTemplate = addMatchingTemplate(builder -> {
        assertEquals(1024, MetadataCreateIndexService.calculateNumRoutingShards(512, Version.CURRENT));
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_INGESTION_SOURCE_PARTITION_STRATEGY, "modulo").build();
                    "target",
            () -> MetadataCreateIndexService.validateIngestionSourceSettings(settings, state)
            assertEquals("All mappings should have disable_objects=false from request", false, doc.get("disable_objects"));
                null,
            "true",
        when(clusterService.state()).thenReturn(clusterState);
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
            .build();
        String replicationType,
    }
     */
     * test for V2 template disable_objects functionality.
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.STRICT)
 */
    public void testValidatePluggableDataFormatSettingsSkipsWhenIndexMatchesAllowlist() {
        Map<String, String> finalCustomData = imdBuilder.build().getCustomData().get(IndexMetadata.REMOTE_STORE_CUSTOM_KEY);
        assertThat(allocationRerouted.get(), is(true));
        for (Map<String, Object> mapping : mappings) {
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
            + "        \"field1\": {\n"
                    "properties": {
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
            "the number of source shards [10] must be less that the number of target shards [5]",
            + "      }\n"
        FeatureFlags.TestUtils.with(APPLICATION_BASED_CONFIGURATION_TEMPLATES, false, () -> {
        settings = Settings.builder()
        // ValidationException. The exception must propagate out of aggregateIndexSettings unchanged so
        // Templates are processed in order: template2 (order 1) first, then template1 (order 0)
    public static boolean isSplitable(int source, int target) {
                  "@fields": {
        request.resizeType(ResizeType.SPLIT);
    private static Map<String, String> getNodeAttributes() {
import org.opensearch.snapshots.EmptySnapshotsInfoService;
                builder.putMapping(MapperService.SINGLE_MAPPING_NAME, "{\"_doc\": {}}");
        for (Map<String, Object> mapping : result2) {
            null,
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
            null,
import org.opensearch.common.UUIDs;
            }
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            .nodes(DiscoveryNodes.builder().add(remoteNode).build())
                randomShardLimitService(),
            + "        }\n"
    }
        Object v1DisableObjects = extractDisableObjectsValue(v1Result);
        assertEquals(Long.toString(customCreationDate), aggregatedSettings.get(IndexMetadata.SETTING_CREATION_DATE));
                      "userstate": { "type": "keyword" }
        int numShards = randomIntBetween(2, 42);
            .transientSettings(Settings.builder().put(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey(), 3).build())
                assertTrue(
                ClusterState.EMPTY_STATE,
    }
                    Version.CURRENT
            xContentRegistry()
            templateMappings2,
    public void testValidateShrinkIndex() {
            validateIndexName(checkerService, "INDEXNAME", "must be lowercase");
            allocationRerouted.compareAndSet(false, true);
        }
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_INGESTION_SOURCE_PARTITION_STRATEGY, "modulo").build();
            request,
    public void testClusterReplicationSetting() {
                builder -> builder.order(2)
        try {
                false,
            clusterState,
                .put("index.blocks.write", (String) null)
        versions.sort(Comparator.comparingLong(l -> l.id));
            Settings.EMPTY,
            clusterSettings
            null
     * disable_objects behavior for the same input templates and request mapping.
        Settings clusterBag = Settings.builder()
        );
        assertEquals(576, MetadataCreateIndexService.calculateNumRoutingShards(9, Version.CURRENT));
            strictClusterSettings,
import static org.opensearch.cluster.metadata.MetadataCreateIndexService.getIndexNumberOfRoutingShards;
        checkerService.addRemoteStoreCustomMetadata(imdBuilder, false, clusterState);
            .build();
import org.opensearch.index.engine.EngineConfig;
        withTemporaryClusterService(((clusterService, threadPool) -> {
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
     * through {@code Setting#get} pre-empted that with an {@code IllegalArgumentException}, breaking
        IllegalArgumentException e = expectThrows(
            new Environment(Settings.builder().put("path.home", "dummy").build(), null),
    }
            request,
            .put(INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.getKey(), 9)
            null,
        Settings indexSettings = aggregateIndexSettings(
            + "}\n";
            randomShardLimitService(),
                InvalidIndexContextException exception = expectThrows(
                        .endObject()
    }
            {
            .putList(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_RESTRICT_ALLOWLIST.getKey(), ".system", ".kibana")
                null,
            .put(RemoteStoreSettings.CLUSTER_SERVER_SIDE_ENCRYPTION_ENABLED.getKey(), true)
        List<SystemIndexDescriptor> systemIndexDescriptors = new ArrayList<>();
            }
            randomIntBetween(0, 10),
        // verify that the message is as expected
        assertTrue(
    public void testValidateIngestionSourceSettingsPartitionStrategyOnCurrentVersion() {
        Settings indexSettings = aggregateIndexSettings(
        Settings clusterBag = Settings.builder()
        );
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false)
                new Environment(Settings.builder().put("path.home", "dummy").build(), null),
            .build();
                .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.STRICT)
        );
            randomShardLimitService(),
        request.settings(nonMatchingReplicationIndexSettings);
            DiscoveryNodeRole.BUILT_IN_ROLES,
                assertEquals("Merged V1 template result should preserve dynamic object with all sub-fields", expected, actual);
            randomShardLimitService(),
        AtomicBoolean allocationRerouted = new AtomicBoolean(false);
                assertThat(settings.get("index.routing.allocation.require._name"), equalTo("node1"));
            requestMapping4,
     * An index created on segments-only nodes must be remote-backed for segments and must carry no translog
        }
            true,
        IndexSettingProvider throwingProvider = new IndexSettingProvider() {
     * Test for field property override behavior in parseV1Mappings.
    }
        Map<String, String> remoteCustomData = indexMetadata.getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY);
            .build();
        ClusterState finalClusterState = ClusterState.builder(ClusterName.DEFAULT).nodes(finalDiscoveryNodes).build();
            ).getMessage()
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(newNode("node1")).build();
        Settings aggregatedIndexSettings = aggregateIndexSettings(
import org.opensearch.indices.IndexCreationException;
                    .contains("Cannot apply context template as user provide settings have overlap with the included context template")
            IllegalArgumentException.class,
        Settings clusterBag = Settings.builder()
            assertWarnings(
            exception.getMessage()
        Settings settings = Settings.builder().put(translogRepositoryNameAttributeKey, "my-translog-repo-1").build();
            null,
            request.index(),
        // Test the extractDisableObjectsValue utility method
            return clusterState;
    }
            .build();
            () -> null,
        final Settings.Builder requestSettings = Settings.builder();
        IndexTemplateMetadata templateMetadata = addMatchingTemplate(
                {
        request = new CreateIndexClusterStateUpdateRequest("create index", "test-index", "test-index");
        // those nodes would receive replicated index metadata containing an unknown setting key.
            null,
        targetRoutingNumberOfShards = getIndexNumberOfRoutingShards(indexSettings, null);
    }
        ).build();
            .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 3)
        MetadataCreateIndexService.updatePluggableDataFormatSettings(indexSettingsBuilder, cs, ".system-test");
            .numberOfShards(1)
                null,
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
        int targetRoutingNumberOfShards = getIndexNumberOfRoutingShards(indexSettings, null);
        when(repositoryMock.blobStore()).thenReturn(mock(BlobStore.class));
            .build();
        Settings nodeSettings = Settings.builder().put("node.attr.remote_store.segment.repository", "my-segment-repo-1").build();
import org.opensearch.repositories.RepositoriesService;
                IllegalArgumentException.class,
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).nodes(nodes).build();
        // Test 2: Edge case with null mappings
            .build();
        IndexCreationException exception = expectThrows(
            null,
            null,
    public void testRefreshIntervalValidationFailureWithIndexSetting() {
        IndexMetadata newIndex = IndexMetadata.builder("test")
                    .settings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 12))
            ).getMessage()
            templateBuilder.putAlias(AliasMetadata.builder("alias1"));
            Collections.singletonList(templateMetadata.mappings()),
                        }
        );
            aliases,
        TimeValue refreshInterval = TimeValue.timeValueSeconds(10);
        for (Map<String, Object> mapping : v2ResultList2) {
            .build();
        Settings templateSettings = Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, 2).build();
            DiscoveryNodeRole.BUILT_IN_ROLES,
        // Expect IllegalArgumentException
            new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE))
        );
            .build();
            randomShardLimitService(),
        );
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
 *
                true,
            clusterSettings
        // check guards the setting KEY itself, regardless of value. Once any non-default strategy can
        );
                + MapperService.SINGLE_MAPPING_NAME
            Collections.emptySet(),
        IndexTemplateMetadata templateMetadata = addMatchingTemplate(builder -> {
        Settings aggregatedIndexSettings = aggregateIndexSettings(
    public void testPrepareResizeIndexSettingsSimilaritySettings() {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        when(repositoriesServiceSupplier.get()).thenReturn(repositoriesService);
        );
        String requestMapping2 = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":false,\"properties\":{}}}";
                )
            null,
                assertThat(settings.get("index.non_copyable.request"), equalTo("request"));
                "properties": {
        );
        Settings nonMatchingReplicationIndexSettings = Settings.builder()
            }
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
    }
                assertEquals("numShards: " + randomNumShards, numRoutingShards / 2, randomNumShards);
            MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
            "my-translog-repo-1",
    }
            + "    \"mappings\": {\n"
            randomShardLimitService(),
        );
                    "target",
import org.opensearch.action.admin.indices.create.CreateIndexClusterStateUpdateRequest;
            clusterSettings
        mappings.put("_doc", "\"properties\": { \"field1\": {\"type\": \"text\"}}");
                            .numberOfReplicas(0)
              }
        }));
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            final int routingNumberOfShards = 4;
        );
            null,
    public void testUpdateRemoteStoreSettingsForSegmentsOnlyNode() {
            randomShardLimitService(),
            assertEquals("All mappings should have disable_objects=true", true, doc.get("disable_objects"));
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            Settings.EMPTY,
            null,
            .build();
        Settings clusterSettingsSetting = Settings.builder()
            settings,
            Setting.Property.IndexScope,
    }
        IllegalArgumentException exception = assertThrows(
        Settings settings = Settings.builder().put(translogRepositoryNameAttributeKey, "my-translog-repo-1").build();
            clusterSettings
        assertTrue("Creation date should be >= beforeCreation", actualCreationDate >= beforeCreation);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).nodes(nodes).build();
                indicesServices,
        );
        int targetShards;
        Map<String, Object> mappingsProperties = (Map<String, Object>) doc.get("properties");
        );
        assertFalse("V1 should not add disable_objects when none are present", v1Doc.containsKey("disable_objects"));
            new Environment(Settings.builder().put("path.home", "dummy").build(), null),
        assertEquals("my-segment-repo-1", indexSettings.get(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY));
            nodeSettings,
            .build();
              }
        Mockito.when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
            .put("index.version.created", Version.CURRENT)
    }
                ClusterState.EMPTY_STATE,
            .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 3)
        // Verify the creation date is set to current time (within reasonable bounds)
        assertEquals("lucene", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(out));
        runPrepareResizeIndexSettingsTest(
    public void testApplyContext() throws IOException {
        );
            .build();
        // even when a cluster-scope default is present.
        DiscoveryNode oldNode = new DiscoveryNode("old_node", buildNewFakeTransportAddress(), emptyMap(), roles, Version.V_3_5_0);
            () -> MetadataCreateIndexService.validateIngestionSourceSettings(settings, state)
        );
        CompressedXContent templateMapping = createMapping("test", "text");
        DiscoveryNode segmentsOnlyNode = new DiscoveryNode(
            clusterService,
            Settings.EMPTY,
                randomShardLimitService(),
        assertEquals("parquet", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(out));
            Map<String, Object> actual = parser.map();
            createClusterState("source", numShards, 0, Settings.builder().put("index.blocks.write", true).build())
            randomBoolean(),
                clusterService,
    }
import org.junit.Before;
            indexMetadata.getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY),
        when(blobStoreMock.isBlobMetadataEnabled()).thenReturn(randomBoolean());
        final Version upgraded = versions.get(1);
        IndexTemplateMetadata templateMetadata = addMatchingTemplate(builder -> {
        TimeValue clusterMinRefreshTime = TimeValue.timeValueMillis(clusterMinRefreshTimeMs);
                            "properties": {
                repositoriesServiceSupplier
        );
            null,
            )
        // Test with null mapping
import org.opensearch.cluster.node.DiscoveryNodes;
        assertThat(aggregatedIndexSettings.get("template_setting"), equalTo("value1"));
            randomShardLimitService(),
            )
            .put(IndexMetadata.SETTING_INGESTION_SOURCE_MAPPER_TYPE, "field_mapping")
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
                + "}}}"
        // All mappings should now have disable_objects=true due to override logic
     * repository. updateRemoteStoreSettings selects the node to copy repository names from with
    public void testUpdatePluggableDataFormatSettingsSkipsBothWhenAlreadySet() {
                validationException.getMessage()
            .metadata(metadata)
        IndexMetadata.Builder imdBuilder = IndexMetadata.builder("test").settings(indexSettings);
            updatedClusterState.metadata().findAllAliases(new String[] { "my-index" }).get("my-index").get(0).alias(),
        IllegalArgumentException e = expectThrows(
import static org.opensearch.node.Node.NODE_ATTRIBUTES;
        try {
            null,
            expectThrows(
                + "\"field2\":{\"type\":\"keyword\",\"store\":true}"
        );
            .build();
            }
        );
        assertTrue("Log template should have @timestamp", logProperties.containsKey("@timestamp"));
                settings,
            Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FENCING_ENABLED.getKey(), true).build(),
                queryShardContext
            clusterSettings
        Map<String, Object> field1 = (Map<String, Object>) properties.get("field1");
import org.opensearch.cluster.ClusterName;
        );
            settings,
    }
            PathType.NAME,
        DiscoveryNode oldNode = new DiscoveryNode("old_node", buildNewFakeTransportAddress(), emptyMap(), roles, Version.V_3_5_0);
            Settings.EMPTY,
        CompressedXContent template2 = new CompressedXContent(
            new AllocationDeciders(singleton(new MaxRetryAllocationDecider())),
            .put(IndexMetadata.SETTING_CREATION_DATE, customCreationDate)
            randomShardLimitService(),
        IllegalArgumentException exception = assertThrows(
            .put(RemoteStoreSettings.CLUSTER_SERVER_SIDE_ENCRYPTION_ENABLED.getKey(), true)
        );
            .build();
            Collections.singletonList(templateMetadata.getMappings()),
                    createClusterState("source", 10, 0, Settings.builder().put("index.blocks.write", true).build()),
    public void testV1V2EquivalenceValidationUtility() throws Exception {
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        CompressedXContent template1 = new CompressedXContent(
        attributes.put(REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "my-cluster-rep-1");
        // Test case 3: Template with empty mapping content
            () -> MetadataCreateIndexService.validateIngestionSourceSettings(settings, state)
        Settings aggregatedIndexSettings = aggregateIndexSettings(
import java.util.stream.Stream;
            request,
        repositoriesService = mock(RepositoriesService.class);
                () -> MetadataCreateIndexService.validateCloneIndex(state, "target", "source", targetSettings)
        for (Map<String, Object> mapping : v2ResultList1) {
            ClusterState.EMPTY_STATE,
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        requestSettings.put(IndexMetadata.SETTING_CREATION_DATE, negativeCreationDate);
        Object v1DisableObjects2 = extractDisableObjectsValue(v1Result2);
            indicesServices,
        when(repositoryMock.blobStore()).thenReturn(blobStoreMock);
            null,
import static org.hamcrest.Matchers.containsString;
            Object v2DisableObjects = extractDisableObjectsValue(mapping);
        for (Map<String, Object> mapping : result) {
                .field("type", fieldType)
        try {
            settings,
    public void testValidatePluggableDataFormatNoopWhenRestrictDisabled() {
                assertEquals("false", settingsBuilder.get(INDEX_SOFT_DELETES_SETTING.getKey()));
            ).getMessage()
    }
        assertThat(targetRoutingNumberOfShards, is(9));
        // Test case 1: Empty template list
            .put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), refreshInterval)
            )
                Settings.EMPTY,
            .put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), clusterMinRefreshTime)
            xContentRegistry()
        // Case 3 - cluster.remote_store.index.path.prefix.optimised=hashed_prefix
        assertTrue(e.getMessage().contains("mapper_settings are not supported for mapper_type [default]"));
            null,
        String resultJson = XContentFactory.jsonBuilder().map(result).toString();
        requestSettings.put(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "my-custom-repo");
        Settings settings = Settings.builder()
            createClusterState(
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            Settings.EMPTY,
                createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
        assertThat(e.getMessage(), endsWith(errorMessage));
                IndexNotFoundException.class,
        assertEquals("field1 type should be from template1", "text", field1.get("type"));
        assertFalse(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(out));
        Settings aggregatedSettings = aggregateIndexSettings(
            Settings.EMPTY,
                + "]: cannot be smaller than cluster.minimum.index.refresh_interval [10s]",
        Metadata metadata = new Metadata.Builder().persistentSettings(
            new IndexSettings(IndexMetadata.builder("test").settings(indexSettings).build(), indexSettings),
            clusterSettings,
        ClusterSettings clusterSettings = new ClusterSettings(nodeSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            clusterSettings
            request,
    }
            createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
    public void testSoftDeletesDisabledIsRejected() {
    /**
                        .toString()
        final Consumer<Settings> consumer
                true,
                indicesServices,
            IllegalArgumentException.class,
        // Test 4: Template has disable_objects, request doesn't - template value should be applied
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).nodes(nodes).build();
import static java.util.Collections.emptyMap;
        assertFalse(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.exists(out));
        }));
        remoteCustomData.put(IndexMetadata.REMOTE_STORE_SSE_ENABLED_INDEX_KEY, "false");
            Map<String, Object> doc = (Map<String, Object>) docObj;
            .putAlias(AliasMetadata.builder("alias1").writeIndex(true).build())
        );
        assertTrue(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.exists(out));
            ClusterState.EMPTY_STATE,
            .build();
    }
            );
    }
        );
                builder -> builder.order(1)
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;
            numShards,
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;
            clusterSettings
        Settings indexSettings = aggregateIndexSettings(
        ClusterState currentClusterState = ClusterState.builder(ClusterState.EMPTY_STATE).build();
import static org.opensearch.indices.IndicesService.CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING;
        validateV1V2Equivalence(Collections.emptyList(), "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{}}}");
            "index source must block write operations to resize index. use \"index.blocks.write=true\"",
        );
            @SuppressWarnings("unchecked")
                        Locale.ROOT,
                + "}}}"
            "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{}}}",
        // Template B (higher priority / earlier in list): defines specific sub-field @fields.userstate
    public void testValidateIngestionSourceSettingsWithFieldMappingOnCurrentVersion() {
        DiscoveryNodes finalDiscoveryNodes = DiscoveryNodes.builder()
                null,
        CompressedXContent template1 = new CompressedXContent(
        Settings out = indexSettingsBuilder.build();
            ClusterState.EMPTY_STATE,
    }
        assertEquals(768, MetadataCreateIndexService.calculateNumRoutingShards(3, Version.CURRENT));
    }
            null
            writableRegistry(),
            "true",
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
import java.util.function.Consumer;
            .metadata(metadata)
            xContentRegistry()
            Object mappingDisableObjects = extractDisableObjectsValue(mapping);
        String templateWithDisableObjects = "{\""
        assertThat(aggregatedIndexSettings.get(SETTING_NUMBER_OF_REPLICAS), equalTo("2"));
        when(repositoriesService.repository(getRemoteStoreSegmentRepo(settings))).thenReturn(repositoryMock);
 * The OpenSearch Contributors require contributions made to
        assertThat(indexMetadata.getAliases().keySet().iterator().next(), is("alias1"));
    }
            null,
        List<Map<String, Object>> v2ResultList2 = MetadataCreateIndexService.collectV2Mappings(
            "my-translog-repo-1",
        ClusterSettings finalClusterSettings = clusterSettings;
            indicesServices,
                }
        Settings matchingReplicationIndexSettings = Settings.builder()
        }
            ClusterState.EMPTY_STATE,
    public void testRemoteStoreOverrideTranslogRepoIndexSettings() {
    ) {
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).nodes(nodes).build();
            new SystemIndices(Collections.emptyMap()),
                ClusterState.EMPTY_STATE,
            IllegalArgumentException.class,
            request,
        Settings settings = Settings.builder().build();
        if (randomBoolean()) {
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT.toString());
        validateV1V2Equivalence(
                ExceptionsHelper.reThrowIfNotNull(e);
        when(repositoriesService.repository(getRemoteStoreTranslogRepo(settings))).thenReturn(repositoryMock);
    }
            settings.put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), TimeValue.timeValueMillis(between(1, 120)));
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "rack.values", "c, d, e")
                DeprecationHandler.IGNORE_DEPRECATIONS,
        final Settings.Builder requestSettings = Settings.builder();
                    "properties": {
import org.opensearch.common.util.BigArrays;
        });
            settings,
        Settings nodeSettings = Settings.builder().put(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey(), 0).build();
            createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
            expectThrows(
        );
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
            new TestGatewayAllocator(),
            null,
                indicesServices,
        }
            IndexMetadata myIndex = builder.get("my-index");
        Settings aggregatedIndexSettings = aggregateIndexSettings(
        String template3a = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":false,\"properties\":{}}}";
        // Test 5: Templates without disable_objects
                request,
            settings,
            complexTemplates,
        );
        Metadata metadata = new Metadata.Builder().templates(templatesBuilder).build();
        );
import static org.hamcrest.Matchers.endsWith;
            .metadata(metadata)
        String template3b = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":true,\"properties\":{}}}";
            "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{\"field3\":{\"type\":\"long\"}}}}"
            new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
        metaBuilder.put(indexMetadata, false);
                    UUIDs.base64UUID(),
            "the number of target shards [10] must be less that the number of source shards [5]",
public class MetadataCreateIndexServiceTests extends OpenSearchTestCase {
        // adds alias from new index to existing index
                clusterService,
            indexSettingsBuilder,
            ReplicationType.SEGMENT.toString(),
            Collections.emptySet(),
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
import static java.util.Collections.emptyList;
        List<CompressedXContent> templateMappings4 = Arrays.asList(new CompressedXContent(template4));
        AllocationService service = new AllocationService(
        Object v2DisableObjects = null;
            Collections.emptySet(),
        );
        List<CompressedXContent> templates = Arrays.asList(templateB, templateA);
        DiscoveryNode remoteNode = new DiscoveryNode(
        indexSettings = Settings.builder()
            Settings indexSettings = Settings.builder()
        requestSettings.put(INDEX_STORE_TYPE_SETTING.getKey(), RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT);
        Map<String, Object> multipleResult = MetadataCreateIndexService.parseV1Mappings("", multipleTemplates, NamedXContentRegistry.EMPTY);
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        Settings settings = Settings.builder()
        final RoutingTable routingTable = OpenSearchAllocationTestCase.startInitializingShardsAndReroute(
            ClusterState.EMPTY_STATE,
        Settings settings = Settings.builder().put(CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING.getKey(), true).build();
            requestMapping,
            componentTemplate.set(ComponentTemplate.parse(contentParser));
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
            clusterSettings
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        final Settings.Builder requestSettings = Settings.builder();
        long actualCreationDate = Long.parseLong(aggregatedSettings.get(IndexMetadata.SETTING_CREATION_DATE));
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            EmptySnapshotsInfoService.INSTANCE
            .build();
        // Set index setting refresh interval the same value as the cluster minimum refresh interval
                    XContentFactory.jsonBuilder()
     */
            .build();
import org.opensearch.cluster.node.DiscoveryNode;
                indicesServices,
            createClusterState(indexName, randomIntBetween(2, 10), 0, indexSettings)
            .put(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "my-custom-repo");
            + "      \"tags\": {\n"
            null,
                mock(Environment.class),
            currentClusterState,
            // Remote store not enabled
        Settings aggregatedIndexSettings = aggregateIndexSettings(
            randomShardLimitService(),
        );
    }
    }
        Map<String, String> remoteCustomData = new HashMap<>();
        // Additional validation: ensure all mappings in V2 result have consistent disable_objects
                    createClusterState("source", randomIntBetween(2, 100), randomIntBetween(0, 10), Settings.EMPTY),
            Version.CURRENT
import static org.hamcrest.Matchers.equalTo;
        Settings settings = Settings.builder().put(CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING.getKey(), true).build();
     * A segments-only index should use the cluster's configured remote store path type rather than falling back to
        } catch (IOException e) {
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    public void testClusterStateCreateIndexWithMetadataTransaction() {
        assertThat(aggregatedIndexSettings.get(SETTING_NUMBER_OF_REPLICAS), equalTo("1"));
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
                Collections.emptySet(),
            settings -> assertThat(
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), true)
            Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 15).build(),
 *
        String template1 = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":false,\"properties\":{}}}";
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
            Map<String, Object> mapping = v2Result.get(i);
        settingsBuilder.put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), pathType.toString());
            when(metadata.systemTemplatesLookup()).thenReturn(Map.of(contextName, new TreeMap<>() {
            IndexCreationException.class,
        Map<String, Object> doc3 = new HashMap<>();
                null,
        request.settings(requestSettings.build());
            @SuppressWarnings("unchecked")
        ClusterState state = createClusterState(
                true,
            assertThat(validationErrors.size(), is(1));
                Settings.builder().put("index.blocks.write", true).put("index.number_of_routing_shards", targetShards).build()
            Collections.emptySet(),
        List<CompressedXContent> templates = Collections.singletonList(template);
            } catch (IOException e) {
import static org.hamcrest.Matchers.hasValue;
            } catch (IOException e) {
            Settings.EMPTY,
            Settings.EMPTY,
            clusterState,
            int numRoutingShards = MetadataCreateIndexService.calculateNumRoutingShards(randomNumShards, Version.CURRENT);
                new SystemIndices(Collections.emptyMap()),
        Map<String, Object> doc = (Map<String, Object>) result.get(MapperService.SINGLE_MAPPING_NAME);
import static org.opensearch.index.IndexModule.INDEX_STORE_TYPE_SETTING;
    }
            PathType.HASHED_PREFIX.toString()
            Settings.EMPTY,
        IllegalArgumentException e = expectThrows(
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
                        .field("type", "float")
                    targetSettings
                DefaultRemoteStoreSettings.INSTANCE,
            new Environment(Settings.builder().put("path.home", "dummy").build(), null),
            + MapperService.SINGLE_MAPPING_NAME
    /**
            List<String> validationErrors = checkerService.getIndexSettingsValidationErrors(settings, false, Optional.empty());
    }
                + MapperService.SINGLE_MAPPING_NAME
     * This test validates the basic functionality of the comparison methods.
        final int maxThreadCount = randomIntBetween(1, 16);
        // Test 3: No disable_objects scenario
    }
        MetadataCreateIndexService.applyDisableObjectsOverrides(noDisableObjectsMappings);
                    "source",
            .build();
                    .putAlias(AliasMetadata.builder("alias1").searchRouting("2").build())
        when(repositoryMock.blobStore()).thenReturn(mock(BlobStore.class));
            validateIndexName(checkerService, "+indexname", "must not start with '_', '-', or '+'");
        when(clusterService.getSettings()).thenReturn(settings);
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        ClusterState state = createClusterState(
                Map<String, Object> expected = expectedParser.map();
                ResourceAlreadyExistsException.class,
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).nodes(nodes).build();
        return target * x == source;
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                requestSettings.build(),
            null,
        Settings settings = Settings.builder()
    public void testPrepareResizeIndexSettings() {
            settings,
     * This test checks if the cluster is a remote store cluster then we populate custom data for remote settings in
        long afterCreation = System.currentTimeMillis();
                        v2DisableObjects,
    public void testAddRemoteStoreCustomMetadata_ForSnapshotRestore_WhenSSE_False() {
    @LockFeatureFlag(APPLICATION_BASED_CONFIGURATION_TEMPLATES)
        final Settings forceClusterSettingDisabled = Settings.builder()
            MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
                new Environment(Settings.builder().put("path.home", "dummy").build(), null),
        Settings settings = Settings.builder()
    }
                      "status": { "type": "keyword" }
        checkerService.addRemoteStoreCustomMetadata(imdBuilder, true, clusterState);
        assertTrue(updatedClusterState.metadata().findAllAliases(new String[] { "my-index" }).containsKey("my-index"));
        super.tearDown();
            request,
            IndexScopedSettings.BUILT_IN_INDEX_SETTINGS.stream(),
    /**
            .build();
import org.opensearch.indices.RemoteStoreSettings;
        final Settings.Builder indexSettingsBuilder = Settings.builder()
        assertEquals("lucene", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(aggregated));
    public void testGetIndexNumberOfRoutingShardsWithNullSourceIndex() {
            Settings.builder().put("index.blocks.write", true).build()
            Collections.emptySet(),
            "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{\"field1\":{\"type\":\"text\"}}}}"
        int targetShards;
            Settings.EMPTY,
        Map<String, Object> resultDoc = (Map<String, Object>) nullMappings.get(1).get(MapperService.SINGLE_MAPPING_NAME);
            settingsBuilder.put(NODE_ATTRIBUTES.getKey() + REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY, "test");
            null,
        // cluster.remote_store.index.restrict.async-durability is false or not set, it allows all types of durability modes
            indexSettings,
            .put("index.soft_deletes.enabled", "true");
                "source",
    /**
        Map<String, Object> docWithoutDisableObjects = new HashMap<>();
        }
import org.opensearch.test.VersionUtils;
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
                    mock(Environment.class),
                    "target",
        requestSettings.put(IndexMetadata.SETTING_CREATION_DATE, epochCreationDate);
                + v1DisableObjects
                equalTo("whitespace")
        MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
        assertFalse(clusterSettings.get(IndicesService.CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING));
            clusterState,
            when(mockState.metadata()).thenReturn(metadata);
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).nodes(nodes).build();
    public void testCalculateNumRoutingShards() {
        // Should not throw
        // This checks that aggregateIndexSettings works for the case when the index setting `index.refresh_interval`
            "my-segment-repo-1"
            requestMapping,
        routingTableBuilder.addAsNew(metadata.index(name));
        final Set<DiscoveryNodeRole> roles = Collections.unmodifiableSet(
            repositoriesServiceSupplier
            clusterService,
    public void testValidateIngestionSourceSettingsDeleteAndCreateValueSame() {
        final Settings.Builder requestSettings = Settings.builder();
    // ---- updatePluggableDataFormatSettings ----
            expectThrows(
        assertTrue(e.getMessage().contains(Version.V_3_5_0.toString()));
            + "      }\n"
        assertThat(mappings, Matchers.hasKey(MapperService.SINGLE_MAPPING_NAME));
        List<Map<String, Object>> v2ResultList1 = MetadataCreateIndexService.collectV2Mappings(
    public void testGetIndexNumberOfRoutingShardsYieldsSourceNumberOfShards() {
        final List<Version> versions = Arrays.asList(VersionUtils.randomVersion(random()), VersionUtils.randomVersion(random()));
            Settings.EMPTY,
            .localNodeId(nonRemoteClusterManagerNode.getId())
        // Request setting should take precedence over template
            .numberOfShards(1)
            "target",
        Map<String, Object> validDoc = new HashMap<>();
                  }
        ClusterState clusterState = ClusterState.builder(
    public void testValidateSplitIndex() {
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test").context(new Context(randomAlphaOfLength(5)));
        request.settings(settings.build());
        // Test case where setting is used without remote store (should fail)
        IndexMetadata indexMetadata = testRemoteCustomData(false, randomFrom(PathType.values()));
            Collections.emptySet(),
    public void testDeprecatedSimpleFSStoreSettings() {
        String isRemoteSegmentEnabled,
                Settings.EMPTY,
     * Simple test to verify the V1/V2 equivalence validation utilities work correctly.
        );
import static org.hamcrest.Matchers.nullValue;
                MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
        assertThat(aggregatedIndexSettings.get(SETTING_NUMBER_OF_SHARDS), equalTo("12"));
        final Settings.Builder requestSettings = Settings.builder();
                "cannot create index with index setting \"index.store.type\" set to \"remote_snapshot\". Store type can be set to \"remote_snapshot\" only when restoring a remote snapshot by using \"storage_type\": \"remote_snapshot\""
                    .putAlias(AliasMetadata.builder("alias1").searchRouting("1").build())
            Arrays.asList(
        // No source_partition_strategy in settings — validation should pass even on mixed cluster
            null,
                new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
import org.opensearch.index.IndexModule;
        discoveryNodes = DiscoveryNodes.builder(discoveryNodes).add(remoteDataNode).localNodeId(remoteDataNode.getId()).build();
import static org.opensearch.cluster.metadata.MetadataCreateIndexService.aggregateIndexSettings;
        });
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
        when(repositoriesService.repository(Mockito.any())).thenReturn(repositoryMock);
                () -> MetadataCreateIndexService.validateShrinkIndex(
                clusterService,
                        .field("disable_objects", true)
            Setting.Property.IndexScope,
        );
            Map<String, Object> doc = (Map<String, Object>) mapping.get(MapperService.SINGLE_MAPPING_NAME);
            settings -> assertThat("similarity settings are not overwritten", settings.get("index.similarity.sim.type"), equalTo("DFR"))
                null,
            when(metadata.componentTemplates()).thenReturn(Map.of(contextName, componentTemplate.get()));
            is(768)
        }));
            new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
        allMappings.add(mappings);
            try {
     * Covers: default mapping merge behavior, V1 functionality preservation, V2 template integration
        DiscoveryNode oldNode = new DiscoveryNode("old_node", buildNewFakeTransportAddress(), emptyMap(), roles, Version.V_3_5_0);
            metadataTransformer
            ).getMessage()
            .build();
    }
        assertTrue(e.getMessage().contains("requires op_type_field to be configured"));
            + MapperService.SINGLE_MAPPING_NAME
import java.util.ArrayList;
        // Test creating an index with a custom creation_date in the past
        settings.put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.SIMPLEFS.getSettingsKey());
        assertTrue(exception.getCause().getMessage().contains(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey()));
        for (int i = 0; i < 1000; i++) {
                null,
        final Settings.Builder requestSettings = Settings.builder();
                request,
        ).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
        Map<String, Object> v1Result1 = MetadataCreateIndexService.parseV1Mappings(requestMapping1, templateMappings1, xContentRegistry());
                true,
        request.settings(requestSettings.build());
        }));
                    new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
                  }
            }
 * specific language governing permissions and limitations
            nodeSettings,
    }
            assertThat(settings.getAsVersion("index.version.upgraded", null), equalTo(upgraded));
            "my-segment-repo-1",
        attributes.put(REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, segmentRepositoryName);
    @After
        when(clusterService.state()).thenReturn(clusterState);
            request,
            exception.getMessage()
        Map<String, String> attributes = new HashMap<>();
                    null,
                .putMapping("_doc", templateMapping)
        // Test 6: Complex scenario with multiple templates and properties
     */
        assertEquals("V1 should preserve request mapping disable_objects=true", true, v1DisableObjects1);
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(newNode("node1")).build();
                Template template = checkerService.applyContext(request, mockState, allMappings, settingsBuilder);
            clusterService,
        );
        assertEquals(indexRefreshTime, INDEX_REFRESH_INTERVAL_SETTING.get(indexSettings));
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            }
            randomShardLimitService(),
        for (Map<String, Object> mapping : result3) {
import static org.opensearch.index.IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING;
        // The invalid pairing on purpose: remote store on, document replication.
        Map<String, Object> doc = (Map<String, Object>) parsedMappings.get(MapperService.SINGLE_MAPPING_NAME);
            Settings.EMPTY,
        when(repositoriesService.repository(getRemoteStoreTranslogRepo(settings))).thenReturn(repositoryMock);
                        "All V2 mappings with _doc sections should have consistent disable_objects values after override processing",
        Settings indexSettings = Settings.builder()
            );
        CompressedXContent template2 = new CompressedXContent(
                        Locale.ROOT,
                null,
                              }
        // Test 4: Multiple templates with different values, request overrides all
            new SystemIndices(Collections.emptyMap()),
        return null;
    }
            .build();
        when(repositoriesService.repository(getRemoteStoreSegmentRepo(settings))).thenReturn(repositoryMock);
        final String indexName = randomAlphaOfLength(10);
            settings,
        // Template B is higher priority (first in list), Template A is lower priority (second in list)
            DefaultRemoteStoreSettings.INSTANCE,
        assertThat(aggregatedIndexSettings.get("request_setting"), equalTo("value2"));
        // But template2 should win because it has higher order
            .transientSettings(Settings.builder().put(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey(), 1).build())
            clusterSettings
            request,
            + "        }\n"
                    MapperService.parseMapping(NamedXContentRegistry.EMPTY, componentTemplate.get().template().mappings().toString()),
            .settings(settings(Version.CURRENT))
                finalClusterSettings
            randomShardLimitService(),
    public void testRemoteStoreNoUserOverrideIndexSettings() {
    private IndexTemplateMetadata addMatchingTemplate(Consumer<IndexTemplateMetadata.Builder> configurator) {
        // now we start the shard
            DiscoveryNodeRole.BUILT_IN_ROLES,
        long requestCreationDate = System.currentTimeMillis() - TimeValue.timeValueDays(30).millis();
        clusterState = ClusterState.builder(ClusterName.DEFAULT).nodes(discoveryNodes).build();
            } else {
        return new DiscoveryNode(
                () -> MetadataCreateIndexService.validateShrinkIndex(state, "source", "target", targetSettings)
                )
            .build();
    }
            ResizeType.SHRINK,
            "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":false,\"properties\":{}}}"
        // cluster.remote_store.index.restrict.async-durability is false or not set, it allows all types of durability modes
        request.settings(mismatch);
            Collections.emptySet(),
        assertEquals("Should have 3 mappings (2 templates + 1 request)", 3, v2Result.size());
            .build();
        );
            Collections.emptySet(),
        aggregateIndexSettings(
        );
        assertThat(aggregatedIndexSettings.get("templateSetting"), is(nullValue()));
        assertEquals(durability, INDEX_TRANSLOG_DURABILITY_SETTING.get(indexSettings));
                IllegalStateException.class,
            .numberOfReplicas(0)
        String requestMapping1 = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":true,\"properties\":{}}}";
                .settings(Settings.builder().put("key1", "templateValue"))
            .build();
            "V1 and V2 should produce equivalent disable_objects values. "
            + "    \"settings\": {\n"
        if (randomBoolean()) {
            .put("index.ingestion_source.mapper_settings.op_type_field.delete_value", "REMOVE")
            ).getMessage()
            )
        int clusterMinRefreshTimeMs = 10 * 1000;
                false,
        requestSettings.put(IndexMetadata.SETTING_CREATION_DATE, futureCreationDate);
        IllegalArgumentException exception = expectThrows(
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).nodes(nodes).build();
                              "@fields": {
            );
        }
import org.hamcrest.Matchers;
        Settings aggregated = aggregateIndexSettings(
        );
            consumer.accept(clusterService, threadPool);
                new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
            .put(IndexMetadata.SETTING_INGESTION_SOURCE_MAPPER_TYPE, "field_mapping")
            CreateIndexClusterStateUpdateRequest request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
                null,
            Settings.builder().put("index.number_of_shards", targetShards).build()
        assertEquals(
        when(clusterService.state()).thenReturn(clusterState);
            templateBuilder.putMapping("type", createMapping("mapping_from_template", "text"));
            Settings.EMPTY,
                false,
                DefaultRemoteStoreSettings.INSTANCE,
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
                numShards,
    }
            assertThat(
        Settings indexSettings = aggregateIndexSettings(
            EmptySnapshotsInfoService.INSTANCE
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
        Settings indexSettings = Settings.builder()
    public void testUpdatePluggableDataFormatSettingsStampsBuiltInDefaultsWhenClusterBagEmpty() {
            ClusterState.builder(ClusterName.DEFAULT).build(),
            Collections.emptySet(),
                );
                + "V1 result: "
        assertThat(aggregatedIndexSettings.get(SETTING_NUMBER_OF_REPLICAS), equalTo("3"));
            Collections.emptySet(),
            assertEquals("All mappings should have disable_objects=true after override", true, doc.get("disable_objects"));
            Settings.EMPTY,
        assertTrue(e.getMessage().contains(Version.V_3_7_0.toString()));
        request.settings(mismatch);
            ClusterState.EMPTY_STATE,
     * Stamping the fencing default must not validate the settings it is handed. {@code index.remote_store.enabled}
            ClusterState mockState = mock(ClusterState.class);
            request,
            currentClusterState,
            null
    public void testUpdatePluggableDataFormatSettingsNoopWhenFeatureFlagDisabled() {
        clusterSettings = new ClusterSettings(clusterSettingsSetting, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING;
            Settings.EMPTY,
                    );
     */
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), true)
            .transientSettings(Settings.builder().put(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey(), 1).build())
        final Setting<String> nonCopyableRequestIndexSetting = Setting.simpleString(
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
                DefaultRemoteStoreSettings.INSTANCE,
            .numberOfShards(1)
        systemIndexDescriptors.add(new SystemIndexDescriptor(".test3", "test"));
                repositoriesServiceSupplier
import static org.opensearch.common.util.FeatureFlags.REMOTE_STORE_MIGRATION_EXPERIMENTAL;
            }
            clusterStateWithSegmentsOnlyNode(),
        // Serialize result to JSON and compare against expected merged output
                            .numberOfShards(1)
            .build();
            null,
            requestMapping1,
            addMatchingTemplate(
            settings -> assertThat(settings.get("index.soft_deletes.enabled"), equalTo("true"))
            null,
        // This checks that aggregateIndexSetting works for the case where there are no index setting
                }
            "cluster-state-repo-1",
            "index source must block write operations to resize index. use \"index.blocks.write=true\"",
        assertEquals(
            .put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 2)
            "index [source] already exists",
        indexMetadata = testRemoteCustomData(true, PathType.FIXED);
                    indicesServices,
            threadPool,
            .put(MIGRATION_DIRECTION_SETTING.getKey(), RemoteStoreNodeService.Direction.REMOTE_STORE)
        int numShards = randomIntBetween(1, 1000);
            Settings.builder().put("index.similarity.sim.type", "DFR").build(),
        assertFalse(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(out));
            .build();
                    new SystemIndices(Collections.emptyMap()),
            + "\":{\"properties\":{\"field2\":{\"type\":\"keyword\"}}}}";
        assertThat("The source index primary term must be used", indexMetadata.primaryTerm(0), is(3L));
                clusterService.state()
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_READ_ONLY_BLOCK;
        assertThat(targetRoutingNumberOfShards, is(6));
        CompressedXContent reqMapping = createMapping("test", "keyword");
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
                .settings(Settings.builder().put("templateSetting", "templateValue"))
            // Enable remote store
    }
import static org.opensearch.index.IndexSettings.INDEX_REFRESH_INTERVAL_SETTING;
        runPrepareResizeIndexSettingsTest(indexSettingsBuilder.build(), Settings.EMPTY, emptyList(), randomBoolean(), settings -> {
        // default mapper type with mapper_settings — should fail
        IllegalArgumentException e = expectThrows(
            .build();
            .build();
        Settings.Builder settingsBuilder = Settings.builder()
                    .putAlias(AliasMetadata.builder("alias1").writeIndex(true).searchRouting("3").build())
        clusterSettings = new ClusterSettings(forceClusterSettingDisabled, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_INGESTION_SOURCE_PARTITION_STRATEGY, "simple").build();
                if (mappingDisableObjects != null) { // Only check mappings that have _doc sections
            request,
        final String expectedError = "index setting [index.example] is not allowed to be set as [cluster.test.restrict=true]";
        // Test 1: Basic override functionality
                        .startObject(MapperService.SINGLE_MAPPING_NAME)
                Settings.EMPTY,
        // Verify that the value is the same as set as earlier and the validation was successful
              "_doc": {
    public void testCreateIndexWithoutCustomCreationDate() {
            Collections.emptySet(),
            new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE))
        Map<String, Object> doc = (Map<String, Object>) parsedMappings.get(MapperService.SINGLE_MAPPING_NAME);
            + "        \"fields\": {\n"
                InvalidIndexContextException.class,
                NamedXContentRegistry.EMPTY,
                    targetSettings
            createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
        Settings settings = Settings.builder().build();
            .put("node.attr.remote_store.segment.repository", "my-segment-repo-1")
 * GitHub history for details.
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
        Map<String, Object> mappingWithoutDisableObjects = new HashMap<>();
            RemoteStoreUtils.determineRemoteStorePathStrategy(imdBuilder.build()).getType()
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        IndexMetadata indexMetadata = IndexMetadata.builder("test").settings(indexSettings).build();
            ClusterSettings.BUILT_IN_CLUSTER_SETTINGS
        List<Map<String, Object>> noDisableObjectsMappings = new ArrayList<>();
        // Process with V2 method
                .build(),
    }
                assertEquals("Request mapping should inherit object settings from template", expected, actual);
            Settings.EMPTY,
                randomShardLimitService(),
        );
        );
            Map<String, Object> doc = (Map<String, Object>) mapping.get(MapperService.SINGLE_MAPPING_NAME);
        Settings aggregatedIndexSettings = aggregateIndexSettings(
        AllocationService service = new AllocationService(
        );
        // Set index setting replication type as DOCUMENT
    public void testRequestDurabilityWhenRestrictSettingTrue() {
        );
        Settings out = indexSettingsBuilder.build();
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT.toString());
            .put(CLUSTER_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        request.settings(Settings.builder().put("key1", "requestValue").build());
            null,
import org.opensearch.indices.DefaultRemoteStoreSettings;
        );
                ClusterState.EMPTY_STATE,
        Map<String, Object> result = MetadataCreateIndexService.parseV1Mappings("", templates, NamedXContentRegistry.EMPTY);
        CompressedXContent templateA = new CompressedXContent("""
        validateV1V2Equivalence(
    }
        requestSettings.put(INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.REQUEST);
            )
                    "source",
     * test for V1/V2 equivalence with disable_objects.
            "test-index"
            request,
        doc2.put("disable_objects", true);
        Settings settings = Settings.builder()
            )
    }
        MetadataCreateIndexService.validateCloneIndex(clusterState, "source", "target", targetSettings);
            request,
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
     * test for disable_objects template functionality.
                )
            clusterSettings
            Settings.EMPTY,
            null
                null,
/*
                    "target",
                new SystemIndices(Collections.emptyMap()),
        IndexMetadata indexMetadata = metadataCreateIndexService.buildAndValidateTemporaryIndexMetadata(
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
        when(clusterService.getSettings()).thenReturn(settings);
        Settings matching = Settings.builder()
        ClusterSettings clusterSettings = new ClusterSettings(nodeSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            ""
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).nodes(nodes).build();
            Setting.Property.NotCopyableOnResize
        assertEquals(
            ReplicationType.SEGMENT.toString(),
            + "}\n";
    }
        Map<String, String> remoteCustomData = imdBuilder.build().getCustomData().get(IndexMetadata.REMOTE_STORE_CUSTOM_KEY);
                ClusterState.EMPTY_STATE,
            request,
     */
            clusterSettings
import org.opensearch.indices.ShardLimitValidator;
        Object resultNullMapping = extractDisableObjectsValue(null);
                        {
        Map<String, String> attributes = getNodeAttributes();
        validateV1V2Equivalence(
            clusterSettings
            REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY,
            UUIDs.base64UUID(),
            .build();
            clusterSettings
        Settings settings = Settings.builder()
import org.opensearch.action.admin.indices.alias.Alias;
            null,
    public void testAddRemoteStoreCustomMetadata_ForSnapshotRestore() {
    public void testPrepareResizeIndexSettingsAnalysisSettings() {
            ClusterState.EMPTY_STATE,
                    "source",
        assertEquals("Later template should override disable_objects", true, multipleDoc.get("disable_objects"));
        BlobStoreRepository repositoryMock = mock(BlobStoreRepository.class);
        mappingWithDisableObjects.put(MapperService.SINGLE_MAPPING_NAME, docWithDisableObjects);
        // Test that custom creation_date from request takes precedence over template
                NamedXContentRegistry.EMPTY,
    private static Map<String, String> getSegmentsOnlyNodeAttributes() {
import static org.opensearch.cluster.metadata.MetadataCreateIndexService.buildIndexMetadata;
                randomShardLimitService(),
        assertEquals(1024, MetadataCreateIndexService.calculateNumRoutingShards(1, Version.CURRENT));
    public void testValidateIndexSettingsUsesDefaultNumberOfReplicasFromClusterSettings() {
                Settings.EMPTY,
        assertEquals(4096, MetadataCreateIndexService.calculateNumRoutingShards(2048, Version.CURRENT));
            new AllocationDeciders(singleton(new MaxRetryAllocationDecider())),
            "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{}}}"
    private ClusterSettings clusterSettings;
                is(String.format(Locale.ROOT, "private index setting [%s] can not be set explicitly", SETTING_REMOTE_STORE_ENABLED))
                randomShardLimitService(),
        when(repositoriesServiceSupplier.get()).thenReturn(repositoriesService);
            .put("index.ingestion_source.mapper_settings.op_type_field.create_value", "REMOVE")
            when(metadata.componentTemplates()).thenReturn(Map.of(contextName, componentTemplate.get()));
        CreateIndexClusterStateUpdateRequest request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
        request.settings(requestSettings.build());
            .build();
            settings,
        final Settings.Builder requestSettings = Settings.builder();
            request,
            request.aliases(),
import org.opensearch.cluster.block.ClusterBlocks;
        AtomicReference<ComponentTemplate> componentTemplate = new AtomicReference<>();
            clusterSettings
        Map<String, Object> mappingsProperties = (Map<String, Object>) doc.get("properties");
        final Set<DiscoveryNodeRole> roles = Collections.unmodifiableSet(
        ClusterService clusterService = mock(ClusterService.class);
            null,
        Settings out = indexSettingsBuilder.build();
        MetadataCreateIndexService.updatePluggableDataFormatSettings(indexSettingsBuilder, cs, "test-index");
        assertEquals("field2 type should be from template2", "text", field2.get("type"));
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
            .build();
                    DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
            MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
        }
import static org.mockito.Mockito.when;
            requestMapping2,
        // Test 2: Realistic V2 template integration scenario
    }
        MetadataCreateIndexService.validateIngestionSourceSettings(settings, state);
        Settings settings = Settings.builder().put(CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING.getKey(), true).build();
        Object resultNull = extractDisableObjectsValue(mappingWithoutDisableObjects);
                null,
            IndexCreationException.class,
        assertEquals(REPLICATION_MISMATCH_VALIDATION_ERROR, exception.getCause().getMessage());
        // is set to a value that is below the `cluster.default.index.refresh_interval` value.
            clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                        .endObject()
    }
                .build(),
            .nodes(DiscoveryNodes.builder().add(remoteNode).build())
    }
        // field2 should have the complete definition from template2 (higher priority)
    public void testV2TemplateDisableObjects() throws Exception {
        // This checks that aggregateIndexSettings throws exception for the case when the index setting
import static org.opensearch.index.IndexSettings.INDEX_SOFT_DELETES_SETTING;
                ClusterState.EMPTY_STATE,
            "invalid index.refresh_interval ["
            InvalidIndexNameException.class,
        }
        DiscoveryNode remoteNode = new DiscoveryNode(
    }
                new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
                () -> checkerService.applyContext(request, mockState, List.of(), settingsBuilder)
            Collections.emptySet(),
        request.settings(requestSettings.build());
        }
            () -> aggregateIndexSettings(
        assertThat("Should have dotted field names", properties, hasKey("cpu.usage"));
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "rack.values", "c, d, e")
        } while (isSplitable(numShards, targetShards) == false);
            null,
                                "type": "object",
    }
                threadPool,
            assertNull("Mapping " + i + " should not have disable_objects field", doc.get("disable_objects"));
            try {
            .settings(settings(Version.CURRENT))
                Settings.EMPTY,
import org.opensearch.index.mapper.MapperService;
        List<CompressedXContent> complexTemplates = Arrays.asList(
        Map<String, Object> mapping1 = new HashMap<>();
        when(repositoriesServiceSupplier.get()).thenReturn(repositoriesService);
            .build();
import org.opensearch.index.remote.RemoteStoreUtils;
                .startObject(MapperService.SINGLE_MAPPING_NAME)
            ClusterState.EMPTY_STATE,
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            assertThat("similarity settings must be copied", settings.get("index.similarity.default.type"), equalTo("BM25"));
            .metadata(metadata)
        when(repositoryMock.blobStore()).thenReturn(blobStoreMock);
            ).getMessage()
        when(repositoriesService.repository(Mockito.any())).thenReturn(repositoryMock);
        clusterSettings = new ClusterSettings(remoteStoreMigrationSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        MetadataCreateIndexService.prepareResizeIndexSettings(
        // Test creating an index with a negative timestamp (dates before epoch)
            Settings.EMPTY,
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
    }
        );
            "expected validation error to contain [" + expectedError + "] but was [" + thrown.getCause().getMessage() + "]",
        // cluster.remote_store.index.restrict.async-durability is false or not set, it allows all types of durability modes
            settingsBuilder.put(NODE_ATTRIBUTES.getKey() + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "test");
        final AllocationService service = new AllocationService(
        BlobStore blobStoreMock = mock(BlobStore.class);
            Collections.emptySet(),
        Map<String, Object> doc = (Map<String, Object>) parsedMappings.get("_doc");
        // Test V2 collectV2Mappings
        ) {
        assertTrue(exception.getCause().getMessage().contains("cannot differ from cluster default"));
    }
            EmptyClusterInfoService.INSTANCE,
        String metricTemplate = "{\n"
            .build();
              }
                                "dynamic": "true",
        }
        // Template A (lower priority / later in list): defines @fields as dynamic object
        );
                null,
        assertThat(updatedClusterState.routingTable().index("test"), is(notNullValue()));
        assertThat(
            Map<String, Object> doc = (Map<String, Object>) mapping.get(MapperService.SINGLE_MAPPING_NAME);
    private void verifyRemoteStoreIndexSettings(
        assertThat(doc, hasKey("properties"));
        clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                clusterSettings
                indicesServices,
            + "  },\n"
        request.settings(settings.build());
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        String requestMapping = """
            new CompressedXContent("{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":true,\"properties\":{}}}")
            .build();
                .endObject()
        threadPool.shutdown();
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
        assertTrue(
            .build();
    public void testParseMappingsWithTypedTemplate() throws Exception {
        // Test 1: Basic V1/V2 equivalence with single template
        assertTrue("Log template should have level", logProperties.containsKey("level"));
            REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,
        );
                createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
                null,
            + "   },\n"
        Settings indexSettings = Settings.builder()
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
        DiscoveryNode nonRemoteClusterManagerNode = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);
        Settings.Builder settingsBuilder = Settings.builder().put(INDEX_SOFT_DELETES_SETTING.getKey(), "false");
                false,
    public void testCreateIndexWithCustomCreationDateInFuture() {
                indicesServices,
            randomShardLimitService(),
import org.opensearch.cluster.service.ClusterService;
        if (randomBoolean()) {
                null,
        assertNotNull(remoteCustomData);
     * combination the restore path itself has to reject with a {@code SnapshotRestoreException}. Reading the setting
            clusterState,
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
            "",
        Map<String, Object> v1Properties = (Map<String, Object>) v1Doc.get("properties");
                () -> clusterStateCreateIndex(currentClusterState, Set.of(), newIndex, (state, reason) -> state, null)
            null,
            templateMetadata.settings(),
            false,
                () -> checkerService.validateContext(request)
import org.opensearch.common.xcontent.XContentFactory;
                Settings.EMPTY,
import static org.opensearch.cluster.metadata.MetadataCreateIndexService.parseV1Mappings;
            Settings.EMPTY,
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
            IllegalArgumentException.class,
            + "      \"value\": {\"type\": \"double\"},\n"
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
        templates.add(
                () -> MetadataCreateIndexService.validateShrinkIndex(
            settingsBuilder.build().getAsBoolean(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, false)
            Collections.emptySet(),
                        }
        Settings settings = Settings.builder()
            Settings.EMPTY,
        nullMappings.add(null);
        Map<String, Object> multipleDoc = (Map<String, Object>) multipleResult.get(MapperService.SINGLE_MAPPING_NAME);
            new CompressedXContent(templateWithDisableObjects)
import static org.opensearch.indices.IndicesService.CLUSTER_REPLICATION_TYPE_SETTING;
        repositoriesServiceSupplier = mock(Supplier.class);
    public void testRemoteStoreDisabledByUserIndexSettings() {
        }));
                    NamedXContentRegistry.EMPTY,
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        Settings clusterBag = Settings.builder()
    }
            assertTrue(
import org.opensearch.common.settings.Setting;
            xContentRegistry(),
            NamedXContentRegistry.EMPTY
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                "index?name",
    public void testDefaultNumberOfReplicasUsesTransientSettingOverPersistentAndNodeSettings() {
            .put("index.ingestion_source.mapper_settings.version_field", "timestamp")
        request.settings(mismatch);
            clusterSettings
                                "dynamic": "true",
                Collections.emptySet(),
                new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
                threadPool,
            .put("index.version.upgraded", upgraded)
                  }
            when(mockState.metadata()).thenReturn(metadata);
            Set.of(INDEX_READ_ONLY_BLOCK),
    }
            randomShardLimitService(),
                createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
                )
    public void testFieldPropertyOverrideInParseV1Mappings() throws Exception {
                )
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING;
     * test for backward compatibility with templates without disable_objects.
                new IndexScopedSettings(ilnSetting, Collections.emptySet()),
        do {
                () -> MetadataCreateIndexService.validateShrinkIndex(
    }
            null,
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            XContentParser parser = JsonXContent.jsonXContent.createParser(
            threadPool,
        // This checks that aggregateIndexSettings works for the case when the index setting `index.refresh_interval`
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
        // source_partition_strategy explicitly set on a current-version cluster — should pass
        Map<String, Object> resultDoc3 = (Map<String, Object>) noDisableObjectsMappings.get(0).get(MapperService.SINGLE_MAPPING_NAME);
        MetadataCreateIndexService.applyDisableObjectsOverrides(nullMappings);
    public void testAggregateIndexSettingsPropagatesIndexCreationExceptionFromProvider() {
                "properties": {
        runPrepareResizeIndexSettingsTest(
            requestWithDisableObjects,
            }
            );
                null,
                throw new IndexCreationException(indexName, ve);
            .build();
            null
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
                )
     * Covers: basic template usage, nested objects, multiple templates, and V1 parsing.
            numShards,
            Version.CURRENT
            expectThrows(
            .build();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
        int x = target / source;
        assertTrue(e.getMessage().contains("unknown mapper_settings key [id_feild]"));
        MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
        mapping3.put(MapperService.SINGLE_MAPPING_NAME, doc3);
        request = new CreateIndexClusterStateUpdateRequest("create index", ".system-index", ".system-index");
    }
        );
            """);
    public void testNumberOfRoutingShardsShowsInIndexSettings() {
                emptyList(),
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
                builder -> builder.order(3)
        Settings aggregated = aggregateIndexSettings(
import org.opensearch.cluster.node.DiscoveryNodeRole;
                builder.putMapping(
        Integer clusterDefaultReplicaNumber = 5;
            .nodes(DiscoveryNodes.builder().add(getRemoteNode()).build())
        Map<String, Object> doc2 = new HashMap<>();
        );
        );
        // Enforce cluster level replication type setting
            .build();
                request,
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
    public void testIndexTotalPrimaryShardsPerNodeSettingValidationWithDefaultValue() {
        assertThat(parsedMappings, hasKey(MapperService.SINGLE_MAPPING_NAME));
            .build();
                throw new AssertionError(ex);
                () -> MetadataCreateIndexService.validateCloneIndex(
        // This checks that aggregateIndexSettings works for the case when the cluster setting
            DefaultRemoteStoreSettings.INSTANCE,
            + "\": {\n"
        // All nodes on current version with valid mapper_settings — should pass
        assertFalse(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(aggregated));
                    .settings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 10))
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
            );
            Settings.EMPTY,
            clusterService,
    public void testRemoteStoreNoUserOverrideExceptReplicationTypeSegmentIndexSettings() {
                null,
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        }
            Collections.emptySet(),
            .build();
        @SuppressWarnings("unchecked")
            request,
            );
            true,
        final Set<DiscoveryNodeRole> roles = Collections.unmodifiableSet(
        final Settings.Builder requestSettings = Settings.builder();
        );
        requestSettings.put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT);
        );
            .nodes(DiscoveryNodes.builder().add(remoteNode).build())
import org.opensearch.indices.InvalidIndexContextException;
            + "    }\n"
        Map<String, Object> v1Doc = (Map<String, Object>) v1Result.get(MapperService.SINGLE_MAPPING_NAME);
            assertThat(settings.get("index.soft_deletes.enabled"), equalTo("true"));
                repositoriesServiceSupplier
        Settings indexSettings = aggregateIndexSettings(
            randomShardLimitService(),
        Settings out = indexSettingsBuilder.build();
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
            ),
            repositoriesServiceSupplier
        Settings indexSettings = Settings.builder()
import org.opensearch.node.remotestore.RemoteStoreNodeService;
        String templateContent = "{\n"
            new TestGatewayAllocator(),
                Collections.emptySet(),
        ClusterService clusterService = mock(ClusterService.class);
        request.settings(requestSettings.build());
import org.opensearch.core.xcontent.DeprecationHandler;
                Settings.EMPTY,
            .settings(settings(Version.CURRENT).put(SETTING_READ_ONLY, true))
        );
            UUIDs.base64UUID(),
            createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
    }
            clusterSettings
        noDisableObjectsMappings.add(mapping3);
    public void testCreateIndexWithContextDisabled() throws Exception {
        request.settings(requestSettings.build());
            .put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 2)
        // similarity settings from the request are not overwritten
        assertTrue(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(aggregated));
            "my-translog-repo-1",
            () -> aggregateIndexSettings(
            MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
        String logTemplate = "{\n"
        request.settings(Settings.builder().putNull(SETTING_NUMBER_OF_REPLICAS).build());
            null,
            .put("index.ingestion_source.mapper_settings.id_feild", "user_id")
        );
import org.opensearch.common.xcontent.json.JsonXContent;
        );
    }
        }
                    )
            startsWith("alias [alias1] has more than one write index [")
    }
            IllegalArgumentException.class,
        assertNotNull(imdBuilder.build().getCustomData());
            request,
            Settings.builder()
        IndexMetadata indexMetadata = IndexMetadata.builder(name)
                xContentRegistry(),
        // Test V1 parseV1Mappings
            request.aliases(),
        Settings templateSettings = Settings.builder().put(INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT).build();
 * Modifications Copyright OpenSearch Contributors. See
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
        final Version version = versions.get(0);
        when(clusterService.state()).thenReturn(clusterState);
        Settings aggregatedIndexSettings = aggregateIndexSettings(
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        List<Map<String, Object>> mixedResult = MetadataCreateIndexService.collectV2Mappings(
                new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
        request.settings(Settings.builder().put("requestSetting", "requestValue").build());
        // This checks that aggregateIndexSettings works for the case when the index setting `index.refresh_interval`
            null,
            null,
        );
            assertThat(settings.get("index.allocation.max_retries"), nullValue());
                    createClusterState("source", randomIntBetween(2, 100), randomIntBetween(0, 10), Settings.EMPTY),
        assertEquals("field1 store should be from template1", true, field1.get("store"));
            randomShardLimitService(),
    public void testAddRemoteStoreCustomMetadata() {
        + REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;
        ClusterService clusterService = mock(ClusterService.class);
        );
                () -> MetadataCreateIndexService.validateShrinkIndex(state, "target", "source", Settings.EMPTY)
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        IndexMetadata.Builder imdBuilder = IndexMetadata.builder("test").settings(indexSettings);
            request.index(),
            .put(CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING.getKey(), true)
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
    public void testBuildIndexMetadata() {
        );
    }
        IndexTemplateMetadata templateMetadata = addMatchingTemplate(builder -> {
        Settings out = indexSettingsBuilder.build();
                Settings.EMPTY,
        assertEquals(Integer.valueOf(-1), INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.get(indexSettings));
        ClusterService clusterService = mock(ClusterService.class);
                repositoriesServiceSupplier
            UUIDs.base64UUID(),
                    "target",
            .nodes(DiscoveryNodes.builder().add(getRemoteNode()).build())
            new AllocationDeciders(singleton(new MaxRetryAllocationDecider())),
            Settings.EMPTY,
    public void testParseMappingsWithTypedTemplateAndTypelessIndexMapping() throws Exception {
            Settings.EMPTY,
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
    public void testValidateIngestionSourceSettingsWithDefaultMapperType() {
            .build();
            null,
        long customCreationDate = System.currentTimeMillis() - TimeValue.timeValueDays(30).millis();
        when(repositoryMock.blobStore()).thenReturn(blobStoreMock);
                DefaultRemoteStoreSettings.INSTANCE,
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
    }
        request.aliases(Collections.singleton(new Alias("alias").searchRouting("fromRequest")));
            null,
            request.settings(Settings.builder().put(INDEX_SOFT_DELETES_SETTING.getKey(), false).build());
                        .startObject("cpu.usage")
            + "      \"index.merge.policy\": \"log_byte_size\",\n"
        String nullValue = null;
            .metadata(Metadata.builder().build())
            ).getMessage(),
                DefaultRemoteStoreSettings.INSTANCE,
            null,
            );
    private static ClusterState clusterStateWithSegmentsOnlyNode() {
            repositoriesServiceSupplier
        threadPool.shutdown();
                new Environment(Settings.builder().put("path.home", "dummy").build(), null),
        nullMappings.add(validMapping);
            clusterService,
        Settings indexSettings = Settings.builder()
                          "_doc": {
import org.opensearch.core.index.Index;
import java.util.Set;
        long negativeCreationDate = -1000000000L; // Some time before 1970
        verifyRemoteStoreIndexSettings(
            randomShardLimitService(),
            .build();
            .build();
            null,
import java.util.HashMap;
        Settings mismatch = Settings.builder().put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false).build();
            request,
                aliasValidator,
    private void runPrepareResizeIndexSettingsTest(
        IndexMetadata existingWriteIndex = IndexMetadata.builder("test2")
        validateV1V2Equivalence(Arrays.asList("{}"), "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{}}}");
        IndexMetadata indexMetadata = buildIndexMetadata(
                    "target",
        assertTrue(Boolean.valueOf(remoteCustomData.get(IndexMetadata.REMOTE_STORE_SSE_ENABLED_INDEX_KEY)));
                .endObject()
            builder.settings(Settings.builder().put(IndexMetadata.SETTING_CREATION_DATE, templateCreationDate));
import org.opensearch.env.Environment;
        );
    public void testExplicitNumberOfReplicasOverridesClusterDefault() {
        Settings settings = Settings.builder()
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            containsString(
    public void setup() throws Exception {
        DiscoveryNode oldNode = new DiscoveryNode("old_node", buildNewFakeTransportAddress(), emptyMap(), roles, Version.V_3_5_0);
            "no such index [no_such_index]",
            null,
            .persistentSettings(Settings.builder().put(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey(), 2).build())
        assertEquals(ReplicationType.DOCUMENT.toString(), indexSettings.get(SETTING_REPLICATION_TYPE));
    public void testValidateIngestionSourceSettingsWithUnknownMapperSettingsKey() {
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a, b")
                repositoriesServiceSupplier
        IndexTemplateMetadata templateMetadata = addMatchingTemplate(builder -> {
                v2DisableObjects = mappingDisableObjects;
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        request.settings(requestSettings.build());
            Map<String, Object> doc = (Map<String, Object>) mapping.get(MapperService.SINGLE_MAPPING_NAME);
            }
            .numberOfReplicas(0)
                request.aliases(),
        final Set<DiscoveryNodeRole> roles = Collections.unmodifiableSet(
            .put(IndexMetadata.SETTING_INGESTION_SOURCE_MAPPER_TYPE, "field_mapping")
    public void testClusterForceReplicationTypeInAggregateSettings() {
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(newNode("node1")).build();
            null,
        when(clusterService.getSettings()).thenReturn(forceClusterSettingEnabled);
            randomIntBetween(0, 10),
        clusterSettings = null;
import org.opensearch.indices.IndicesService;
        Settings mismatch = Settings.builder()
        List<CompressedXContent> templateMappings1 = Arrays.asList(
            .put("node.attr.remote_store.segment.repository", "my-segment-repo-1")
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY;
    public void testValidateIngestionSourceSettingsWithMapperSettingsOnDefaultMapper() {
                  "@fields": {
            randomShardLimitService(),
        when(blobStoreMock.isBlobMetadataEnabled()).thenReturn(randomBoolean());
        requestSettings.put(SETTING_REMOTE_STORE_ENABLED, false);
                new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
        ).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
        routingTable = OpenSearchAllocationTestCase.startInitializingShardsAndReroute(service, clusterState, "source").routingTable();
        @SuppressWarnings("unchecked")
            new AwarenessReplicaBalance(settings, clusterService.getClusterSettings()),
        final ClusterState clusterState = ClusterState.builder(routingTableClusterState).routingTable(routingTable).build();
        request.settings(requestSettings.build());
                Collections.emptySet(),
            .put("index.analysis.analyzer.default.tokenizer", "keyword")
        request.settings(requestSettings.build());
            () -> randomNonNegativeLong(),
     * After merging, @fields should retain both the dynamic:true/type:object settings AND
        );
        );
        clusterSettings = new ClusterSettings(clusterSettingsSetting, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            .put("index.ingestion_source.mapper_settings.op_type_field.delete_value", "true")
        final Settings sourceSettings,
            + "\": {\n"
            Settings.EMPTY,
        MetadataCreateIndexService.validateSplitIndex(
            ClusterState.EMPTY_STATE,
        // is set to a value that is greater than the `cluster.default.index.refresh_interval` value.
        );
        List<Map<String, Object>> result = MetadataCreateIndexService.collectV2Mappings(
import java.util.stream.Collectors;
        IndexTemplateMetadata.Builder builder = templateMetadataBuilder("template1", "te*");
            EmptyClusterInfoService.INSTANCE,
import static org.opensearch.common.util.FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG;
        final Settings.Builder requestSettings = Settings.builder()
        assertNull(indexMetadata.getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY));
import java.util.function.Supplier;
                IllegalArgumentException.class,
 * this file be licensed under the Apache-2.0 license or a
            Collections.emptySet(),
            Collections.emptySet(),
        DiscoveryNode remoteNode = new DiscoveryNode(
            numShards,
            .put(IndexMetadata.SETTING_INGESTION_SOURCE_MAPPER_TYPE, "field_mapping")
import org.opensearch.index.translog.Translog;
        Settings targetSettings = Settings.builder().put("index.number_of_shards", numShards).build();
            + MapperService.SINGLE_MAPPING_NAME
                        mappingDisableObjects
        request.settings(requestSettings.build());
        attributes.put(REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY, "my-translog-repo-1");
    public void testCustomCreationDateWithTemplates() {
    private static final String segmentRepositoryNameAttributeKey = NODE_ATTRIBUTES.getKey()
        );
                clusterService,
            indexName
        // see: https://github.com/opensearch-project/OpenSearch/issues/1019
            null,
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        );
            // Check deprecations
            Map<String, Object> docMap = (Map<String, Object>) mapping.get(MapperService.SINGLE_MAPPING_NAME);
        requestSettings.put(INDEX_REFRESH_INTERVAL_SETTING.getKey(), indexRefreshTime);
            new SystemIndices(Collections.emptyMap()),
        Map<String, Object> v1Result2 = MetadataCreateIndexService.parseV1Mappings(requestMapping2, templateMappings2, xContentRegistry());
            request,
        });
    }
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        validDoc.put("disable_objects", true);
            Collections.singletonList(templateMetadata.mappings()),
        final IllegalArgumentException error = expectThrows(
            assertTrue(checkerService.validateDotIndex(".pattern-test-other-suffix", false));
        Map<String, Object> mappings = parseV1Mappings("", Collections.singletonList(templateMetadata.mappings()), xContentRegistry());
        // This checks that aggregateIndexSettings works for the case when the cluster setting
            ).getMessage()
        assertThat(aggregatedIndexSettings.get(SETTING_NUMBER_OF_REPLICAS), equalTo("0"));
        );
    }
        assertNotEquals(ReplicationType.SEGMENT, clusterSettings.get(CLUSTER_REPLICATION_TYPE_SETTING));
            new SystemIndices(Collections.emptyMap()),
    }
        assertTrue(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(out));
        );
                indexName,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        assertEquals(
            new HashMap<>(),
    private static final String translogRepositoryNameAttributeKey = NODE_ATTRIBUTES.getKey()
                routingNumberOfShards,
            Settings.EMPTY,
        });
        assertFalse(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(out));
            .build();
            builder.settings(Settings.builder().put("template_setting", "value1"));
            Metadata.builder().build(),
            request,
                                  "status": { "type": "keyword" }
        // Should NOT throw — feature flag is off by default in tests without @LockFeatureFlag
        assertEquals(
            null,
        );
            assertTrue(1 < ratio);
            Version.CURRENT
    public void testValidateIngestionSourceSettingsDeleteValueWithoutOpTypeField() {
        return clusterState;
            validateIndexName(checkerService, "-indexname", "must not start with '_', '-', or '+'");
            assertEquals("V2 should apply request mapping disable_objects=true to all mappings", true, v2DisableObjects);
                    .settings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 11))
    /**
        Settings settings = Settings.builder().build();
            throw ExceptionsHelper.convertToRuntime(e);
        );
            + "        \"type\": \"object\",\n"
            .primaryTerm(0, 3L)
        });
        assertEquals(
                threadPool,
            "Translog retention settings [index.translog.retention.age] "
        InvalidIndexNameException e = expectThrows(
                        .startObject("memory.used")
        // For V2, find the disable_objects value from any mapping that has it
            "test",
                new DiscoveryNode(
        checkerService.addRemoteStoreCustomMetadata(imdBuilder, true, clusterState);
            Map<String, Object> doc = (Map<String, Object>) mapping.get(MapperService.SINGLE_MAPPING_NAME);
                .endObject()
                    DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        );
        );
            assertThat(settings.get("index.routing.allocation.initial_recovery._id"), equalTo("node1"));
        assertEquals("parquet", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(out));
            ClusterSettings.BUILT_IN_CLUSTER_SETTINGS
        // Test creating an index with creation_date set to 0 (epoch time)
                    + "names starting with a dot are reserved for hidden indices and system indices"
            new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE))
                mock(Environment.class),
        assertTrue(e.getMessage().contains("mapper_type [field_mapping] requires all nodes"));
    }
        ClusterState currentClusterState = ClusterState.builder(ClusterState.EMPTY_STATE)
    // ---- allowlist tests ----
                ValidationException ve = new ValidationException();
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        );
            xContentRegistry()
                Settings.EMPTY,
                DefaultRemoteStoreSettings.INSTANCE,
                NamedXContentRegistry.EMPTY,
    public void testAnyTranslogDurabilityWhenRestrictSettingFalse() {
                request,
                clusterSettings
                null,
                    missingTranslogAttribute,
            "index.non_copyable.request",
            + "  \"version\": 1\n"
            randomShardLimitService(),
        });
        // Process with V1 method
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;
            request,
        MetadataCreateIndexService.updatePluggableDataFormatSettings(indexSettingsBuilder, cs, ".system-index-1");
        );
            indicesServices,
                createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
            null,
            clusterSettings
            .build();
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
    }
                null,
     * This ensures that a request mapping defining only sub-fields of an object still
                        "private index setting [%s] can not be set explicitly",
                        {
        for (int i = 0; i < complexResult.size(); i++) {
                assertEquals(
            new BalancedShardsAllocator(Settings.EMPTY),
            .numberOfReplicas(numReplicas)
    }
        assertEquals("parquet", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(aggregated));
            .build();
        request.settings(mismatch);
            false,
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
            () -> aggregateIndexSettings(
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false)
            Collections.emptySet(),
            () -> checkerService.validateIndexSettings("test", indexSettings, false)
            }));
        final Settings.Builder requestSettings = Settings.builder();
                () -> MetadataCreateIndexService.validateSplitIndex(
            EmptySnapshotsInfoService.INSTANCE
            {
            templateMetadata.settings(),
            new SystemIndices(Collections.emptyMap()),
        IndexMetadata.Builder imdBuilder = IndexMetadata.builder("test").settings(indexSettings);
        verifyRemoteStoreIndexSettings(
        // Test case 2: Empty request mapping
            v1DisableObjects,
                    clusterService,
        );
            clusterService,
     */
            Settings.EMPTY,
        );
        assertFalse("No disable_objects should be added", resultDoc3.containsKey("disable_objects"));
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            null,
    }
            validateIndexName(checkerService, "index#name", "must not contain '#'");
        List<CompressedXContent> templateMappings = templateMappingStrings.stream().map(s -> {
            request,
        DiscoveryNode remoteDataNode = getRemoteNode();
            "my-segment-repo-1",
                .putMapping("_doc", templateMapping)
                          "_doc": {
            )
            null,
            .build();
        // After override processing, all mappings with _doc sections should have the same value
        withTemporaryClusterService(((clusterService, threadPool) -> {
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
            .numberOfReplicas(0)
        return attributes;
            assertEquals("All mappings should have disable_objects=true", true, docMap.get("disable_objects"));
        );
    public void testBackwardCompatibility() throws Exception {
                threadPool,
            assertEquals(ratio, intRatio, 0.0d);
            Collections.emptySet(),
                    "source",
                request,
        );
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(newNode("node1")).add(oldNode).build();
        RoutingTable routingTable = service.reroute(clusterState, "reroute").routingTable();
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;
            randomIntBetween(0, 10),
            + "      }\n"
        ClusterState clusterState = ClusterState.builder(
            Settings.EMPTY,
            @SuppressWarnings("unchecked")
        Settings settings = Settings.builder().put(CLUSTER_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT).build();
            ValidationException validationException = expectThrows(
                null,
            .put(RemoteStoreSettings.CLUSTER_SERVER_SIDE_ENCRYPTION_ENABLED.getKey(), true)
                () -> MetadataCreateIndexService.validateCloneIndex(state, "no_such_index", "target", targetSettings)
            ClusterState.EMPTY_STATE,
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
        String remoteSegmentRepo,
        Map<String, Object> docWithDisableObjects = new HashMap<>();
                Collections.emptySet(),
        long futureCreationDate = System.currentTimeMillis() + TimeValue.timeValueDays(30).millis();
        List<CompressedXContent> multipleTemplates = Arrays.asList(template1, template2);
            )
            "no such index [no_such_index]",
     * restore's override-settings step, where restoring a remote-store snapshot onto a document-replication index is a
        );
        );
            .build();
            new SystemIndices(Collections.emptyMap()),
                () -> MetadataCreateIndexService.validateSplitIndex(state, "target", "source", targetSettings)
        // Case 2 - cluster.remote_store.index.path.prefix.optimised=fixed (default value)
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            final String mapping = XContentFactory.jsonBuilder()
        // Test 3: Multiple templates with different values, request overrides all
        assertNull("Should return null when disable_objects is not present", resultNull);
    private IndicesService indicesServices;
        BlobStoreRepository repositoryMock = mock(BlobStoreRepository.class);
     */
            .put("index.ingestion_source.mapper_settings.op_type_field", "action")
            .build();
        MetadataCreateIndexService.updatePluggableDataFormatSettings(indexSettingsBuilder, cs, "test-index");
            .put("index.version.created", Version.CURRENT)
            final List<String> validationErrors = checkerService.getIndexSettingsValidationErrors(
        // Should not throw
        );
        // be set, older nodes that don't recognize the key would fall back to the default 1:1 mapping
        ClusterSettings clusterSettings = new ClusterSettings(nodeSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        Map<String, Object> v1Result = MetadataCreateIndexService.parseV1Mappings(requestMapping, templateMappings, xContentRegistry());
            clusterSettings
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            ClusterState.EMPTY_STATE,
                XContentParser expectedParser = JsonXContent.jsonXContent.createParser(
            Collections.emptySet(),
                IllegalArgumentException.class,
            IllegalArgumentException.class,
            ).getMessage()
            Settings.builder().put("index.soft_deletes.enabled", "false").build(),
    @LockFeatureFlag(APPLICATION_BASED_CONFIGURATION_TEMPLATES)
        BiConsumer<Metadata.Builder, IndexMetadata> metadataTransformer = (builder, indexMetadata) -> {
        Metadata metadata = Metadata.builder()
                is(
            request,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            request,
            Collections.emptySet(),
            return null;
                .startObject()
                Object mappingDisableObjects = extractDisableObjectsValue(mapping);
        );
                + "\"properties\":{"
            );
            request,
            try {
     */
            createClusterState("source", numShards, 0, Settings.builder().put("index.blocks.write", true).build())
            InvalidIndexContextException exception = expectThrows(
            Collections.singletonList(basicTemplate.getMappings()),
        ThreadPool threadPool = new TestThreadPool(getTestName());
            MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
                Settings.EMPTY,
            int randomNumShards = randomIntBetween(1, 10000);
        String templateWithoutDisableObjects = "{\""
        // Simulates a plugin-supplied IndexSettingProvider (like CompositeDataFormatPlugin) rejecting
            .build();
        Settings clusterBag = Settings.builder()
        requestSettings.put(INDEX_REFRESH_INTERVAL_SETTING.getKey(), refreshInterval);
            repositoriesServiceSupplier
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
        Settings settings = Settings.builder()
            + "          \"type\": \"integer\"\n"
            nodeSettings,
            requestMapping,
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "rack.values", "c, d, e")
    }
     * Covers: collectV2Mappings with override logic, multiple templates, request mapping priority.
        withTemporaryClusterService((clusterService, threadPool) -> {
        // No exception, no stamping — the index is left alone.
            )
            randomShardLimitService(),
            attributes,
                        .endObject()
        remoteCustomData.put(IndexMetadata.REMOTE_STORE_SSE_ENABLED_INDEX_KEY, "true");
        assertThat(mappingsProperties, hasKey("test"));
            IllegalArgumentException.class,
            thrown.getCause().getMessage().contains(expectedError)
                DefaultRemoteStoreSettings.INSTANCE,
        );
            emptyList(),
            .build();
        assertThat((Map<String, Object>) mappingsProperties.get("test"), hasValue("keyword"));
    }
            Settings.builder()
                requestSettings.build(),
        // verify that the message is as expected
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "lucene")
        );
            true,
            ).getMessage()
            NamedXContentRegistry.EMPTY
            AliasMetadata newAlias = indexMetadata.getAliases().values().iterator().next();
                assertEquals(componentTemplate.get().template(), template);
 * compatible open source license.
        long epochCreationDate = 0L;
        ClusterState currentClusterState = ClusterState.builder(ClusterState.EMPTY_STATE)
        when(clusterService.state()).thenReturn(clusterState);
            .put(RemoteStoreSettings.CLUSTER_SERVER_SIDE_ENCRYPTION_ENABLED.getKey(), true)
        }
            .build();
            XContentParser parser = JsonXContent.jsonXContent.createParser(
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
import java.util.Arrays;
                    targetSettings
        );
            null,
        );
        // This checks that aggregateIndexSettings works for the case when the index setting `index.number_of_replicas` is set to null
                          }
            }
        ClusterState state = createClusterState(
        String remoteTranslogRepo,
    }
            expectThrows(
        withTemporaryClusterService((clusterService, threadPool) -> {
        MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
        Settings aggregatedSettings = aggregateIndexSettings(
                null,
        assertThat(targetRoutingNumberOfShards, is(1024));
                null,
            false,
            .routingTable(routingTable)
        assertFalse(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.exists(out));
import org.opensearch.common.unit.TimeValue;
import static org.opensearch.indices.IndicesService.CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING;
        // now we start the shard
    }
            }
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
            clusterSettings
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
        );
        // End-to-end sanity: confirm updatePluggableDataFormatSettings is wired into the create-index
        assertEquals("Should have 2 mappings (1 template + 1 request)", 2, result4.size());
/*
        int numShards = randomIntBetween(1, 42);
        // Default mapper type on old nodes — should pass (no version requirement)
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING;
    public void testRefreshIntervalValidationSuccessWithIndexSettingEqualToClusterMinimum() {
            queryShardContext
        Settings clusterBag = Settings.builder()
            + "  },\n"
            .build();
            // Check non-system hidden indices don't trigger a warning
        assertEquals("Should have 3 mappings", 3, mixedResult.size());
        Settings indexSettings = Settings.builder()
            """);
            null,
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        Settings indexSettings,
        }
            XContentParser contentParser = JsonXContent.jsonXContent.createParser(
     * remote segments and translog.
            .build();
            null,
        Map<String, String> finalCustomData = imdBuilder.build().getCustomData().get(IndexMetadata.REMOTE_STORE_CUSTOM_KEY);
            }
     */
                                "properties": {
            templateMappings4,
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
                throw new RuntimeException(e);
            templateSettings,
            randomShardLimitService(),
            )
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        List<String> validationErrors = checkerService.getIndexSettingsValidationErrors(settings, false, Optional.empty());
        });
            settings,
        return builder.build();
            .put("index.ingestion_source.mapper_settings.id_field", "user_id")
        assertThat(alias.getSearchRouting(), equalTo("3"));
        Settings.Builder indexSettingsBuilder = Settings.builder();
            buildNewFakeTransportAddress(),
                    "target",
            createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
            Settings.EMPTY,
        );
            request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test").context(new Context(randomAlphaOfLength(5)));
        request.mappings(createMapping("mapping_from_request", "text").string());
        Settings aggregatedSettings = aggregateIndexSettings(
        List<Map<String, Object>> complexResult = MetadataCreateIndexService.collectV2Mappings(
        mappings.add(mapping2);
        configurator.accept(builder);
            sourceIndexMetadata,
        assertNull(remoteCustomData.get(IndexMetadata.REMOTE_STORE_SSE_ENABLED_INDEX_KEY));
            + "  \""
            )
        Map<String, String> attributes = new HashMap<>();
        assertEquals(2048, MetadataCreateIndexService.calculateNumRoutingShards(1024, Version.CURRENT));
            validateIndexName(checkerService, "foo:bar", "must not contain ':'");
            assertThat(validationErrors.get(0), is("expected [index.lifecycle.name] to be private but it was not"));
        request.settings(matching);
            .put("node.attr.remote_store.translog.repository", "my-translog-repo-1")
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
                validationErrors.get(0),
        }
        // Convert template strings to CompressedXContent
            randomShardLimitService(),
            createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
                threadPool,
            .build();
        try (
        ThreadPool threadPool = new TestThreadPool(getTestName());
    private DiscoveryNode getRemoteNode() {
            } catch (IOException e) {
            Collections.emptySet(),
import org.opensearch.threadpool.ThreadPool;
        request.settings(Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, 4).build());
            .metadata(metadata)
        // (only check mappings that have _doc sections)
            Settings.builder().put("index.soft_deletes.enabled", "true").build(),
        IndexMetadata sourceIndexMetadata = IndexMetadata.builder("parent")
        withTemporaryClusterService(((clusterService, threadPool) -> {
            v2DisableObjects
    public void testRemoteStoreOverrideSegmentRepoIndexSettings() {
            IndexMetadata indexMetadata = checkerService.buildAndValidateTemporaryIndexMetadata(
        ClusterSettings clusterSettings = new ClusterSettings(nodeSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        clusterSettings = new ClusterSettings(clusterSettingsSetting, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertEquals(
    }
                ClusterState.EMPTY_STATE,
        Settings aggregatedIndexSettings = aggregateIndexSettings(
            new IndexScopedSettings(Settings.EMPTY, settingsSet)
        assertTrue(exception.getCause().getMessage().contains("cannot differ from cluster default"));
        // Case 1 - Remote store is not enabled
            null,
            .settings(settings(Version.CURRENT).put(settings))
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
        final Settings requestSettings,
        );
            .put(INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.getKey(), nullValue)
            indicesServices,
            Settings.EMPTY,
        assertEquals(
    }
                clusterService,
            .numberOfShards(6)
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
            .metadata(
            ).getMessage()
            "source",
        );
        Settings indexSettings = Settings.builder()
    private IndexTemplateMetadata.Builder templateMetadataBuilder(String name, String pattern) {
            .build();
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
        List<Map<String, Object>> v2Result = MetadataCreateIndexService.collectV2Mappings(
            .persistentSettings(Settings.builder().put(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey(), 2).build())
                Metadata.builder().build(),
            + "\": {\n"
import java.util.Collection;
            .build();
        templatesBuilder.put("template_1", templateMetadata);
        // Verify if index setting overrides cluster replication setting
        Metadata metadata = metaBuilder.build();
            xContentRegistry()
                templateContent
            assertTrue(checkerService.validateDotIndex(".test3", false));
                clusterService,
    private void validateRemoteCustomData(Map<String, String> customData, String expectedKey, String expectedValue) {
        requestSettings.put(INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), durability);
        assertThat(parsedMappings, hasKey(MapperService.SINGLE_MAPPING_NAME));
     * Utility method to validate that V1 and V2 template processing produce equivalent
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
import org.mockito.Mockito;
            null,
        assertTrue("V1 result should contain field3", v1Properties.containsKey("field3"));
        );
    @LockFeatureFlag(REMOTE_STORE_MIGRATION_EXPERIMENTAL)
    }
            randomShardLimitService(),
        } else {
        );
        // No exception, and the cluster default is still baked in - rejecting the pairing belongs to the caller.
                indicesServices,
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        Settings aggregated = aggregateIndexSettings(
            Collections.emptySet(),
import static org.opensearch.indices.ShardLimitValidatorTests.createTestShardLimitService;
                    threadPool,
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
            Map<String, Object> actual = parser.map();
    public void testTemplateDisableObjects() throws Exception {
    }
            null,
            clusterSettings
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        Settings clusterBag = Settings.builder()
                DefaultRemoteStoreSettings.INSTANCE,
        assertTrue(clusterSettings.get(IndicesService.CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING));
        final Set<Setting<?>> settingsSet = Stream.concat(
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "lucene")
            );
                    + "Please do not specify a value for setting [index.soft_deletes.enabled]."
        });
            Settings.builder().put("index.blocks.write", true).build()
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_REPLICATION_TYPE_SETTING;
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(settings, clusterSettings);
            .build();
                    InvalidIndexContextException.class,
    public void testValidateIngestionSourceSettingsWithFieldMappingOnOldVersion() {
    }
        validateRemoteCustomData(
            request,
            );
            request,
            InvalidAliasNameException.class,
        // the default 'simple') should be rejected if the cluster has nodes < V_3_7_0 — otherwise
    }
                null,
            assertEquals("Request mapping should override template disable_objects", false, doc.get("disable_objects"));
            Settings.EMPTY,
        String aliasName = randomFrom(invalidAliasNames);
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
        Metadata.Builder metaBuilder = Metadata.builder();
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
        int targetRoutingNumberOfShards = getIndexNumberOfRoutingShards(indexSettings, null);
            null,
        verifyRemoteStoreIndexSettings(
import org.opensearch.threadpool.TestThreadPool;
                IllegalArgumentException.class,
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
                "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":true,\"properties\":{}}}"
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).nodes(nodes).build();
    public void testCreateIndexWithZeroCreationDate() {
    }
        IndexTemplateMetadata templateMetadata = addMatchingTemplate(builder -> {
        when(repositoryMock.blobStore()).thenReturn(blobStoreMock);
            MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
        });
        Map<String, Object> mapping2 = new HashMap<>();
            .metadata(metadata)
            nodeSettings,
            ClusterState.EMPTY_STATE,
        when(clusterService.state()).thenReturn(clusterState);
        // Verify no disable_objects field is added and structure is preserved
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
                + "\":{"
            .put("node.attr.remote_store.translog.repository", "my-translog-repo-1")
            randomShardLimitService(),
                Settings.EMPTY,
        Settings.Builder indexSettingsBuilder = Settings.builder();
        List<Map<String, Object>> nullMappings = new ArrayList<>();
            expectThrows(
        // and read from the wrong source partitions until upgraded.
        aggregateIndexSettings(
    public void testSettingsFromClusterState() {
            clusterService,
        request.settings(requestSettings.build());
        });
            aliasValidator,
            randomBoolean(),
        );
                null,
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.getRemoteStoreSegmentRepo;
            "my-translog-repo-1",
        runPrepareResizeIndexSettingsTest(
        if (v2DisableObjects != null) {
        MetadataCreateIndexService.updatePluggableDataFormatSettings(indexSettingsBuilder, cs, "test-index");
        );
        // Test case with default value (-1) without remote store (should succeed)
        clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    private Supplier<RepositoriesService> repositoriesServiceSupplier;
        if (docObj instanceof Map) {
    public void testDoNotOverrideSoftDeletesSettingOnResize() {
        final RoutingTable initialRoutingTable = service.reroute(initialClusterState, "reroute").routingTable();
            randomShardLimitService(),
import java.util.Optional;
        );
            request.mappings(),
        assertTrue(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(out));
            Map<String, Object> doc = (Map<String, Object>) mapping.get(MapperService.SINGLE_MAPPING_NAME);
            assertEquals(1, validationException.validationErrors().size());
            Settings.EMPTY,
            getSegmentsOnlyNodeAttributes(),
        // Cluster level replication type setting not enforced
 * the Apache License, Version 2.0 (the "License"); you may
        String contextName = randomAlphaOfLength(5);
                .put("index.merge.scheduler.max_thread_count", maxThreadCount)
    public void testAggregateIndexSettingsIgnoresTemplatesOnCreateFromSourceIndex() throws Exception {
    public void testValidatePluggableDataFormatRejectsEnabledMismatch() {
 * software distributed under the License is distributed on an
        when(repositoriesService.repository(Mockito.any())).thenReturn(repositoryMock);
        Settings out = indexSettingsBuilder.build();
                .build();
        request.settings(requestSettings.build());
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        AtomicReference<ComponentTemplate> componentTemplate = new AtomicReference<>();
            nodeSettings,
            randomShardLimitService(),
                + indexRefreshTime
            new SystemIndices(Collections.emptyMap()),
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(newNode("node1")).build();
            buildNewFakeTransportAddress(),
            ClusterState.EMPTY_STATE,
            null,
            null,
        Map<String, Object> parsedMappings = MetadataCreateIndexService.parseV1Mappings(
        // analysis settings from the request are not overwritten
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        when(blobStoreMock.isBlobMetadataEnabled()).thenReturn(randomBoolean());
        Settings indexSettings = Settings.builder()
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            new BalancedShardsAllocator(Settings.EMPTY),
                randomShardLimitService(),
                null,
                null,
            assertThat(validationErrors.size(), is(1));
        Settings indexSettings = Settings.builder()
import static org.hamcrest.Matchers.is;
        );
        doc1.put("disable_objects", false);
        );
        );
            + "          \"keyword\": {\"type\": \"keyword\", \"ignore_above\": 256}\n"
        assertEquals("Should extract disable_objects value correctly", true, result);
            randomShardLimitService(),
     * index metadata of the underlying index. This captures information around the resolution pattern of the path for
        String template2 = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":true,\"properties\":{}}}";
        // source_partition_strategy setting key was introduced in V_3_7_0. Any explicit value (including
                    "type": "object",
            null,
        assertThat("Should have dotted field names", properties, hasKey("memory.used"));
        ClusterSettings clusterSettings = new ClusterSettings(
            clusterSettings
        requestSettings.put(INDEX_REFRESH_INTERVAL_SETTING.getKey(), indexRefreshTime);
            buildNewFakeTransportAddress(),
            + "    \"_version\": 1\n"
            xContentRegistry(),
        int targetRoutingNumberOfShards = getIndexNumberOfRoutingShards(indexSettings, null);
        Settings nodeSettings = Settings.builder().put(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey(), 0).build();
        when(repositoriesServiceSupplier.get()).thenReturn(repositoriesService);
                new SystemIndices(Collections.emptyMap()),
    }
        return new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), emptyMap(), roles, Version.CURRENT);
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        List<Map<String, Object>> v2ResultList = MetadataCreateIndexService.collectV2Mappings(
            createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
        when(repositoriesServiceSupplier.get()).thenReturn(repositoriesService);
        assert source > target : source + " <= " + target;
        final Settings forceClusterSettingEnabled = Settings.builder()
        Mockito.when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
        ThreadPool threadPool = new TestThreadPool(getTestName());
        List<CompressedXContent> templateMappings3 = Arrays.asList(new CompressedXContent(template3a), new CompressedXContent(template3b));
            )
    /**
        Settings clusterBag = Settings.builder()
        assertEquals(
        // field1 should be from template1 (only defined there)
                IllegalStateException.class,
            validateIndexName(
                {
            settings,
            .put(IndicesService.CLUSTER_RESTRICT_PLUGGABLE_DATAFORMAT_SETTING.getKey(), true)
            EmptyClusterInfoService.INSTANCE,
            Collections.emptySet(),
        );
        attributes.put(REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, "my-segment-repo-1");
        }
        assertTrue(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.exists(out));
        indexMetadata = testRemoteCustomData(true, PathType.HASHED_PREFIX);
import org.opensearch.indices.InvalidAliasNameException;
            request,
                "index name [.test2] starts with a dot '.', in the next major version, index "
        assertWarnings(
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
        MetadataCreateIndexService metadataCreateIndexService = new MetadataCreateIndexService(
    }
            aggregateIndexSettings(
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            ),
    }
        Settings aggregatedIndexSettings = aggregateIndexSettings(
            new BalancedShardsAllocator(Settings.EMPTY),
            .metadata(Metadata.builder().put(existingWriteIndex, false).build())
    // ---- validatePluggableDataFormatSettings tests ----
        when(repositoryMock.blobStore()).thenReturn(mock(BlobStore.class));
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
            "test-index"
            .build();
        assertNotNull(finalCustomData);
    public void testParseMappingsAppliesDataFromTemplateAndRequest() throws Exception {
        );
     */
        // Template 1 (order 0): field2 with type=keyword, store=true
            repositoriesServiceSupplier
                clusterSettings
                Settings.EMPTY,
            request,
                templateContent
            )
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;
            .put(SETTING_NUMBER_OF_SHARDS, 1)
            Collections.emptySet(),
            )
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.STRICT)
            new TestGatewayAllocator(),
            assertFalse("Mapping " + i + " should not contain disable_objects", doc.containsKey("disable_objects"));
            } catch (IOException ex) {
            .build();
            // Check NO deprecation warnings if we give the index name
    }
            Collections.emptySet(),
    private IndexMetadata testRemoteCustomData(boolean remoteStoreEnabled, PathType pathType) {
import org.opensearch.common.settings.Settings;
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    private CompressedXContent createMapping(String fieldName, String fieldType) {
            new CompressedXContent(metricTemplate)
            newIndexMetadata,
        request.settings(matchingReplicationIndexSettings);
        );
    public void testUpdatePluggableDataFormatSettingsSkipsWhenIndexMatchesAllowlist() {
    }
            randomShardLimitService(),
                                }
                new SystemIndices(Collections.emptyMap()),
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false)
                    "target",
            randomShardLimitService(),
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        // create one that won't fail
        MetadataCreateIndexService.applyDisableObjectsOverrides(mappings);
            )
            .put(INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.getKey(), nullValue)
        IllegalArgumentException e = expectThrows(
    public void testRefreshIntervalValidationWithNoIndexSetting() {
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
                Settings.EMPTY,
        assertEquals(Long.toString(negativeCreationDate), aggregatedSettings.get(IndexMetadata.SETTING_CREATION_DATE));
     * Covers: V1/V2 request mapping priority, equivalence validation, edge cases.
            Settings.EMPTY,
                DefaultRemoteStoreSettings.INSTANCE,
            null,
                    exception.getMessage().contains("index specifies a context which cannot be used without enabling")
                new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
        List<CompressedXContent> mixedTemplates = Arrays.asList(
        MetadataCreateIndexService.updateRemoteStoreSettings(
            Collections.emptySet(),
        clusterSettings.applySettings(clusterState.metadata().settings());
            .put("index.version.created", Version.CURRENT)
        ) {
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        // This checks that aggregateIndexSettings works for the case when the cluster setting
                    """
        });
            clusterSettings
            DefaultRemoteStoreSettings.INSTANCE,
            xContentRegistry()
     * while still inheriting non-conflicting object-level settings from templates.
    // ---- source_partition_strategy validation tests ----
                .startObject(fieldName)
            );
        assertTrue("Log template should have message", logProperties.containsKey("message"));
        String template2 = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{\"field2\":{\"type\":\"keyword\"}}}}";
        withTemporaryClusterService(((clusterService, threadPool) -> {
        int x = source / target;
        );
            )
            );
                    createClusterState("source", randomIntBetween(2, 100), randomIntBetween(0, 10), Settings.EMPTY),
        when(repositoryMock.blobStore()).thenReturn(mock(BlobStore.class));
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(newNode("node1")).add(oldNode).build();
        clusterSettings.applySettings(clusterState.metadata().settings());
    }
            Collections.emptySet(),
     * Test V1/V2 equivalence with edge cases like null mappings and empty templates.
            + "}";
        ).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
            assertFalse(checkerService.validateDotIndex(".test2", true));
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "lucene");
            } catch (IOException e) {
    }
    }
                ValidationException.class,
    }
            .add(nonRemoteClusterManagerNode)
                new SystemIndices(Collections.emptyMap()),
                "Creating indices with soft-deletes disabled is no longer supported. "
            Version.CURRENT
                request,
            null,
    public static boolean isShrinkable(int source, int target) {
        );
        ClusterState clusterState = createClusterState("sourceIndex", 1, 0, Settings.builder().put("index.blocks.write", true).build());
    private CreateIndexClusterStateUpdateRequest request;
        final Collection<Setting<?>> additionalIndexScopedSettings,
            clusterState,
        assertFalse(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(out));
            nodeSettings,
            PathType.HASHED_PREFIX,
            requestMapping3,
                ClusterState.EMPTY_STATE,
        // Template 2 (order 1): field2 with type=text, store=false
    public void testClusterStateCreateIndex() {
        MetadataCreateIndexService.validateIngestionSourceSettings(settings, state);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
import java.util.TreeMap;
            Arrays.asList(nonCopyableExistingIndexSetting, nonCopyableRequestIndexSetting),
    }
        // `index.refresh_interval` in the cluster state update request.
        Map<String, Object> logResult = complexResult.get(0);
 * license agreements. See the NOTICE file distributed with
        Settings settings = Settings.builder()
            Collections.emptySet(),
                randomShardLimitService(),
        RoutingTable routingTable = service.reroute(clusterState, "reroute").routingTable();
            () -> true,
        ClusterState updatedClusterState = clusterStateCreateIndex(
        return indexMetadata;
        final Settings.Builder indexSettingsBuilder = Settings.builder().put("index.number_of_shards", 1).put(requestSettings);
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            .build();
            null,
            templateMappings3,
            IllegalArgumentException.class,
        Map<String, Object> validMapping = new HashMap<>();
            attributes,
        assertThat(targetRoutingNumberOfShards, is(768));
            .build();
            + "    \"properties\": {\n"
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            null,
        ClusterState updatedClusterState = clusterStateCreateIndex(
        }
                request.index(),
    }
            Collections.emptySet(),
            builder -> builder.putAlias(AliasMetadata.builder("alias").searchRouting("fromTemplate").build())
        String requestWithDisableObjects = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":false,\"properties\":{}}}";
            """;
            Settings.builder()
            expectThrows(
            });
            assertThat(
        // Feature flag off — no validation even with restrict=true and mismatching values.
        checkerService.addRemoteStoreCustomMetadata(imdBuilder, false, clusterState);
            addMatchingTemplate(
    }
        assertEquals(Translog.Durability.REQUEST, INDEX_TRANSLOG_DURABILITY_SETTING.get(indexSettings));
        });
    private ShardLimitValidator randomShardLimitService() {
        Settings aggregatedSettings = aggregateIndexSettings(
                new SystemIndices(Collections.emptyMap()),
            .put("index.similarity.default.type", "BM25")
        Map<String, String> missingTranslogAttribute = Map.of(
        BlobStore blobStoreMock = mock(BlobStore.class);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // Test that default behavior still works when creation_date is not provided
            PathHashAlgorithm.FNV_1A_COMPOSITE_1.name()
            + "    \"properties\": {\n"
        ClusterSettings clusterSettings = new ClusterSettings(nodeSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    public void testValidatePluggableDataFormatNoopWhenFeatureFlagDisabled() {
            new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE))
        );
    }
            randomShardLimitService(),
        };
            new CompressedXContent(logTemplate),
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
            + "        \"type\": \"text\",\n"
            clusterSettings
            .build();
        );
                clusterService,
            clusterState,
import org.opensearch.index.shard.IndexSettingProvider;
        Settings.Builder indexSettingsBuilder = Settings.builder();
        assertEquals(
            .put("index.routing.allocation.require._name", "node1")
            ClusterState.EMPTY_STATE,
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.STRICT)
            settings,
        assertTrue(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(out));
    public void testV1V2EquivalenceEdgeCases() throws Exception {
    final String REPLICATION_MISMATCH_VALIDATION_ERROR =
    public void testClusterForceReplicationTypeInValidateIndexSettings() {
            clusterState,
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        );
    }
            null
                is(
            .build();
        List<CompressedXContent> templates = Arrays.asList(template2, template1);
        int clusterMinRefreshTimeMs = 10 * 1000;
     * Template B (higher priority) defines a specific sub-field @fields.userstate as keyword.
        Settings.Builder indexSettingsBuilder = Settings.builder();
    }
        Map<String, Object> properties = (Map<String, Object>) doc.get("properties");
        );
        Settings.Builder indexSettingsBuilder = Settings.builder().put(indexSettings);
        request.settings(Settings.EMPTY);
        long beforeCreation = System.currentTimeMillis();
            Settings.EMPTY,
            ClusterState.EMPTY_STATE,
        Settings aggregated = aggregateIndexSettings(
            ClusterState.EMPTY_STATE,
        systemIndexDescriptors.add(new SystemIndexDescriptor(".test", "test"));
                        .field("type", "long")
     */
            randomShardLimitService(),
        when(repositoriesService.repository(getRemoteStoreTranslogRepo(settings))).thenReturn(repositoryMock);
                settings.get("index.analysis.analyzer.default.tokenizer"),
                null,
                threadPool,
            ClusterState.EMPTY_STATE,
import static org.opensearch.indices.IndicesService.CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING;
        Settings mismatch = Settings.builder()
            Settings.EMPTY,
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()
            MetadataIndexTemplateService.resolveAliases(templates),
        );
        doc1.put("properties", new HashMap<>());
            indexMetadata.getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY),
        List<Map<String, Object>> allMappings = new ArrayList<>();
        assertEquals(
            settings,
                assertEquals("log_byte_size", settingsBuilder.get(INDEX_MERGE_POLICY.getKey()));
                resultJson
     * Utility method to extract the disable_objects value from a mapping.
            assertTrue(ratio <= 1024);
                Collections.emptySet(),
    public void testValidateIngestionSourceSettingsPartitionStrategySimpleOnCurrentVersion() {
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        attributes.put(REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, "my-segment-repo-1");
            .put(CLUSTER_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
        );
                request,
        IndexCreationException thrown = expectThrows(
            "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{}}",
        queryShardContext = new QueryShardContext(
                createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
        systemIndexDescriptors.add(new SystemIndexDescriptor(".pattern-test*", "test-1"));
                    put(1L, contextName);
        when(repositoriesService.repository(Mockito.any())).thenReturn(repositoryMock);
            (clusterState, y) -> clusterState,
                    Set.of(DiscoveryNodeRole.INGEST_ROLE, DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE, DiscoveryNodeRole.DATA_ROLE),
        when(repositoriesServiceSupplier.get()).thenReturn(repositoriesService);
                null,
                randomShardLimitService(),
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    }
        }
            try {
            try (
            () -> MetadataCreateIndexService.validateIngestionSourceSettings(settings, state)
        }
            Arrays.asList(
import static org.opensearch.index.IndexSettings.INDEX_MERGE_POLICY;
                ExceptionsHelper.reThrowIfNotNull(e);
              "_doc": {
        assertTrue(e.getMessage().contains("index.ingestion_source.source_partition_strategy requires all nodes"));
            settingsBuilder.put(NODE_ATTRIBUTES.getKey() + REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, "test");
        final MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
            ClusterState.EMPTY_STATE,
            exception.getMessage()
            attributes,
                    "dynamic": "true",
        assertEquals(expectedValue, customData.get(expectedKey));
import org.opensearch.common.blobstore.BlobStore;
                mock(Environment.class),
        assertEquals(
 *     http://www.apache.org/licenses/LICENSE-2.0
     */
        MetadataCreateIndexService.updatePluggableDataFormatSettings(indexSettingsBuilder, cs, "test-index");
            indexSettings,
            .build();
            randomShardLimitService(),
            try {
    public void testParseMappingsWithTypelessTemplate() throws Exception {
    public void testValidateIngestionSourceSettingsPartitionStrategyOnMixedClusterRejected() {
     * Node attributes for {@code node.attr.remote_store.mode: segments_only}: a segment repository and neither a
            );
    }
            .add(
                createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
        assertNotNull(imdBuilder.build().getCustomData());
    public void setupCreateIndexRequestAndAliasValidator() {
            error.getCause().getMessage(),
        try (
            .put(INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(newNode("node1")).add(oldNode).build();
                assertTrue("numRoutingShards: " + numRoutingShards, numRoutingShards > 512);
        }
import org.opensearch.cluster.ClusterState;
            request,
        assertEquals(
            settings -> {
            clusterSettings
            ClusterState.EMPTY_STATE,
                                }
            assertThat(settings.getAsVersion("index.version.created", null), equalTo(version));
    /**
              "_doc": {
        when(blobStoreMock.isBlobMetadataEnabled()).thenReturn(randomBoolean());
            threadPool,
    public void testUpdatePluggableDataFormatSettingsSkipsValueWhenAlreadySet() {
            repositoriesServiceSupplier
            clusterSettings
                createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
            // Set primary shards per node to valid value
        if (mapping == null) {
    }
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
            Collections.emptySet(),
                    )
                ResourceAlreadyExistsException.class,
    public void testDisableObjectsOverrideLogic() throws Exception {
    public void testAddRemoteStoreCustomMetadata_WhenSSEDisabled() {
            "the number of source shards [3] must be a factor of [4]",
            Settings.EMPTY,
            );
            templateMappings,
        assertThat(aggregatedIndexSettings.get("key1"), equalTo("requestValue"));
                null,
        );
    public void testIndexSettingOverridesClusterReplicationSetting() {
            .put("index.version.created", Version.CURRENT)
        Settings indexSettings = aggregateIndexSettings(
import java.util.Map;
                Settings.EMPTY,
            null,
        );
            "{\""
            "my-segment-repo-1",
            IllegalArgumentException.class,
            Settings.builder().put("index.blocks.write", true).build()
            )
    public void testAggregateSettingsAppliesSettingsFromTemplatesAndRequest() {
        );
import org.opensearch.test.OpenSearchTestCase;
                IllegalStateException.class,
        Settings clusterBag = Settings.builder()
        );
            null,
    public void testApplyContextWithSettingsOverlap() throws IOException {
            null,
                null,
/*
            targetRoutingNumberOfShards,
        request.settings(requestSettings.build());
            + "      \"index.refresh_interval\": \"60s\"\n"
        Settings out = indexSettingsBuilder.build();
            Metadata.builder().build(),
            );
            .build();
        List<CompressedXContent> templateMappings = Arrays.asList(new CompressedXContent(template1), new CompressedXContent(template2));
        request.settings(Settings.EMPTY);
        Settings indexSettings = Settings.builder()
        request.settings(requestSettings.build());
            EmptyClusterInfoService.INSTANCE,
            }
 * Licensed to Elasticsearch under one or more contributor
                "properties": {
            builder -> builder.putAlias(AliasMetadata.builder("alias").searchRouting("fromTemplate").build())
        try (
                null,
            ClusterState.EMPTY_STATE,
            targetShards = randomIntBetween(numShards + 1, 100);
                              "@fields": {
        Settings.Builder indexSettingsBuilder = Settings.builder().put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "lucene");
    }
        // Template defines @fields as dynamic object
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            "can't shrink an index with only one shard",
        validationErrors = checkerService.getIndexSettingsValidationErrors(settings, false, Optional.empty());
        request.settings(requestSettings.build());
                "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":false,\"properties\":{}}}",
            clusterService.state()
        final Settings indexSettings = Settings.builder().put(INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.DOCUMENT).build();
        );
            Settings settings = Settings.builder().put(CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING.getKey(), false).build();
                indicesServices,
            templateMetadata.settings(),
        final Map<String, Object> mappings = new HashMap<>();
        assertEquals(1024, MetadataCreateIndexService.calculateNumRoutingShards(2, Version.CURRENT));
            Metadata metadata = mock(Metadata.class);
            .blocks(ClusterBlocks.builder().addBlocks(indexMetadata))
    public void testRequestDataHavePriorityOverTemplateData() throws Exception {
        // Verify that default value passes validation
        assertTrue(e.getMessage().contains(Version.V_3_5_0.toString()));
    public void testClusterStateCreateIndexThrowsWriteIndexValidationException() throws Exception {
            + "  \""
            );
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            emptyList(),
        assertThat(parsedMappings, hasKey("_doc"));
        request.settings(mismatch);
        assertEquals(Long.toString(epochCreationDate), aggregatedSettings.get(IndexMetadata.SETTING_CREATION_DATE));
        assertThat(mappingsProperties, hasKey("mapping_from_request"));
            rerouteRoutingTable,
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
        validateRemoteCustomData(remoteCustomData, PathType.NAME, PathType.FIXED.name());
            UUIDs.base64UUID(),
            templateMappings1,
            randomShardLimitService(),
            "When the target routing number of shards is not specified the expected value is the configured number of shards "
            .build();
        assertTrue("Creation date should be <= afterCreation", actualCreationDate <= afterCreation);
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            .put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), clusterMinRefreshTime)
            xContentRegistry()
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
            .build();
        attributes.put(REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "my-cluster-rep-1");
        assertEquals(translogBufferInterval, indexSettings.get(INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey()));
        IndexMetadata sourceIndexMetadata = IndexMetadata.builder("parent")
            targetShards = randomIntBetween(1, numShards / 2);
            validateIndexName(checkerService, "..", "must not be '.' or '..'");
            queryShardContext
                IllegalArgumentException.class,
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
        final Settings.Builder requestSettings = Settings.builder();
        // Verify the result
            expectThrows(
        CompressedXContent templateMapping = createMapping("test", "text");
        List<AliasMetadata> aliases = singletonList(AliasMetadata.builder("alias1").build());
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
    private DiscoveryNode newNode(String nodeId) {
            .numberOfReplicas(0)
    public void testIndexTotalPrimaryShardsPerNodeSettingValidationWithoutRemoteStore() {
            expectThrows(
        MetadataCreateIndexService.updatePluggableDataFormatSettings(indexSettingsBuilder, cs, "user-index");
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
        } while (isShrinkable(numShards, targetShards) == false);
        assertThat(
        ClusterSettings clusterSettings = new ClusterSettings(forceClusterSettingEnabled, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            indicesServices,
                Settings.EMPTY,
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
            clusterSettings
            + "    }\n"
        Settings mismatch = Settings.builder()
        assertNull("Should return null for null mapping", resultNullMapping);
            attributes,
        assertTrue(exception.getCause().getMessage().contains(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey()));
        assertTrue("V1 result should contain field1", v1Properties.containsKey("field1"));
        );
                new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
        final Settings.Builder requestSettings = Settings.builder();
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        imdBuilder.putCustom(IndexMetadata.REMOTE_STORE_CUSTOM_KEY, remoteCustomData);
            containsString("Cluster is migrating to remote store but remote translog is not configured, failing index creation")
        assertThat(validationErrors.get(0), is("expected total copies needs to be a multiple of total awareness attributes [3]"));
        Settings clusterSettingsSetting = Settings.builder()
        int numShards = randomIntBetween(1, 42);
import org.opensearch.index.remote.RemoteStoreEnums.PathHashAlgorithm;
                  }
        BlobStoreRepository repositoryMock = mock(BlobStoreRepository.class);
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
    public void testValidateDotIndex() {
    }
import org.opensearch.Version;
        assertThat(resolvedAliases.get(0).getSearchRouting(), equalTo("fromRequest"));
 * not use this file except in compliance with the License.
        requestSettings.put(INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC);
            null,
        assertThat(aggregatedIndexSettings.get(SETTING_NUMBER_OF_SHARDS), equalTo("1"));
        List<AliasMetadata> resolvedAliases = resolveAndValidateAliases(
            EmptySnapshotsInfoService.INSTANCE
        BlobStoreRepository repositoryMock = mock(BlobStoreRepository.class);
     * settings to be dropped, breaking index creation for dynamic fields under @fields.
                () -> MetadataCreateIndexService.validateShrinkIndex(
        }
        Map<String, String> remoteCustomData = imdBuilder.build().getCustomData().get(IndexMetadata.REMOTE_STORE_CUSTOM_KEY);
                null,
            randomShardLimitService(),
                    Settings.builder().put("index.number_of_shards", 10).build()
    public void testTemplateOrder() throws Exception {
        consumer.accept(indexSettingsBuilder.build());
            new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
        imdBuilder.putCustom(IndexMetadata.REMOTE_STORE_CUSTOM_KEY, remoteCustomData);
        BlobStore blobStoreMock = mock(BlobStore.class);
            Settings.EMPTY,
                );
            + "  \"template\": {\n"
            .put("index.version.created", Version.CURRENT)
            ReplicationType.SEGMENT.toString(),
            indexSettings,
import org.opensearch.test.gateway.TestGatewayAllocator;
              "_doc": {
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "lucene")
        final Settings.Builder settings = Settings.builder();
        Map<String, Object> mappings = parseV1Mappings("", Collections.singletonList(templateMetadata.mappings()), xContentRegistry());
        Translog.Durability durability = randomFrom(Translog.Durability.values());
                );
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(oldNode).build();
        mappingWithoutDisableObjects.put(MapperService.SINGLE_MAPPING_NAME, docWithoutDisableObjects);
    private ClusterState createClusterState(String name, int numShards, int numReplicas, Settings settings) {
        Settings.Builder settingsBuilder = Settings.builder();
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_INGESTION_SOURCE_MAPPER_TYPE, "default").build();
            request,
            null,
                )
        requestSettings.put(IndexMetadata.SETTING_CREATION_DATE, customCreationDate);
                .endObject()
            .put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), clusterMinRefreshTime)
        when(repositoriesService.repository(Mockito.any())).thenReturn(repositoryMock);
            randomShardLimitService(),
        @SuppressWarnings("unchecked")
            XContentParser contentParser = JsonXContent.jsonXContent.createParser(
        assertNull("no remote translog repository should be applied", indexSettings.get(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY));
        };
            clusterSettings
            Settings.EMPTY,
            clusterSettings
    public void testInvalidAliasName() {
    public void testIndexTemplateReplicationType() {
        final Settings.Builder requestSettings = Settings.builder().put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), -1);
            Settings.builder().put("index.number_of_shards", targetShards).build()
            );
                        """
        assertTrue(e.getMessage().contains("index.ingestion_source.source_partition_strategy requires all nodes"));
        when(clusterService.state()).thenReturn(clusterState);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            0,
        Settings settings = Settings.builder().put(translogRepositoryNameAttributeKey, "my-translog-repo-1").build();
        Settings.Builder indexSettingsBuilder = Settings.builder();
        // Test that custom creation_date is properly stored in IndexMetadata
                .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
            + "    \"_type\": \"@abc_template\",\n"
            true,
     * Template A (lower priority) defines @fields as a dynamic object.
            .build();
        Settings indexSettings = Settings.builder()
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            0,
        // Should not throw
            Settings.builder().put("index.analysis.analyzer.default.tokenizer", "whitespace").build(),
                        .endObject()
            UUIDs.base64UUID(),
            .build();
    }
            .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 3)
        );
        String requestMapping = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{\"field3\":{\"type\":\"long\"}}}}";
    }
        Settings indexSettings = Settings.builder()
        List<Map<String, Object>> mappings = new ArrayList<>();
        // Test case where setting is used with remote store enabled (should succeed)
    public void testV1RequestMappingInheritsObjectSettingsFromTemplate() throws Exception {
        assertTrue(e.getMessage().contains("cannot be the same"));
        assertNotNull(finalCustomData);
        assertEquals(remoteSegmentRepo, indexSettings.get(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY));
            request,
        withTemporaryClusterService((clusterService, threadPool) -> {
    public void testCreateIndexWithNegativeCreationDate() {
            () -> metadataCreateIndexService.validateIndexName(
        Map<String, String> attributes = getNodeAttributes();
        assertThat(validationErrors.size(), is(0));
            + "    \"settings\": {\n"
            ClusterState mockState = mock(ClusterState.class);
        MetadataCreateIndexService.updatePluggableDataFormatSettings(indexSettingsBuilder, cs, "test-index");
                IllegalStateException.class,
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
                    + "\":{\"disable_objects\":true,\"properties\":{\"field2\":{\"type\":\"keyword\"}}}}"
            clusterState,
            componentTemplate.set(ComponentTemplate.parse(contentParser));
        String requestMapping = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{}}}";
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                        SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY
            .build();
        Mockito.when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
        assertNull(remoteCustomData.get(PathHashAlgorithm.NAME));
        Settings.Builder settingsBuilder = Settings.builder();
        );
                        .startObject()
            clusterService,
            ClusterState.EMPTY_STATE,
            createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
        // All mappings should now have disable_objects=true (from the last template)
            remoteStoreSettings,
        String complexRequestMapping = "{\n"
        MetadataCreateIndexService.validateShrinkIndex(
            "no such index [no_such_index]",
            ).getMessage()
            DiscoveryNodeRole.BUILT_IN_ROLES,
            assertTrue(checkerService.validateDotIndex(".test", false));
import org.opensearch.cluster.EmptyClusterInfoService;
    }
        DiscoveryNode oldNode = new DiscoveryNode("old_node", buildNewFakeTransportAddress(), emptyMap(), roles, Version.V_3_5_0);
import org.opensearch.indices.InvalidIndexNameException;
            ).getMessage()
                ClusterState.EMPTY_STATE,
            + "    }\n"
    /**
        verifyRemoteStoreIndexSettings(
        when(blobStoreMock.isBlobMetadataEnabled()).thenReturn(randomBoolean());
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertEquals(remoteTranslogRepo, indexSettings.get(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY));
    public void testPrepareResizeIndexSettingsCopySettings() {
                null,
                    repositoriesServiceSupplier
            .put(sourceSettings)
            addMatchingTemplate(
    public void testValidateIndexSettings() {
            aggregateIndexSettings(
                    Settings.builder().put("index.number_of_shards", 3).build()
            null,
        );
            ClusterState.EMPTY_STATE,
                assertThat(settings.getAsInt("index.merge.scheduler.max_thread_count", null), equalTo(maxThreadCount));
        assertNotNull(aggregated);
                CountDownLatch counter = new CountDownLatch(1);
    }
            xContentRegistry()
    ) {
            ).getMessage()
            null,
            IllegalArgumentException.class,
                    String.format(
            )
        Map<String, Object> result = MetadataCreateIndexService.parseV1Mappings(requestMapping, templates, NamedXContentRegistry.EMPTY);
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test").context(new Context(contextName));
        BlobStore blobStoreMock = mock(BlobStore.class);
        // field_mapping with an unrecognized mapper_settings key — should fail
        routingTable = OpenSearchAllocationTestCase.startInitializingShardsAndReroute(service, clusterState, "source").routingTable();
            .build();
import static java.util.Collections.singletonList;
            equalTo("alias1")
        assertEquals(Long.toString(requestCreationDate), aggregatedSettings.get(IndexMetadata.SETTING_CREATION_DATE));
        indexSettings = aggregateIndexSettings(
            routingTableClusterState,
        );
            .build();
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
                createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
        }
    public void testValidateIngestionSourceSettingsPartitionStrategyAbsentOnMixedClusterPasses() {
        assertEquals(ReplicationType.SEGMENT.toString(), aggregateIndexSettings.get(INDEX_REPLICATION_TYPE_SETTING.getKey()));
        long templateCreationDate = System.currentTimeMillis() - TimeValue.timeValueDays(60).millis();
import static org.hamcrest.Matchers.notNullValue;
                )
            null,
        assertThat(
                    """
            new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE))
        clusterSettings.applySettings(clusterState.metadata().settings());
                            .settings(settings(Version.CURRENT).put(SETTING_READ_ONLY, true))
                            "properties": {
        expectThrows(
        Metadata metadata = Metadata.builder()
                    }
        MetadataCreateIndexService.updatePluggableDataFormatSettings(indexSettingsBuilder, cs, "test-index");
            new Environment(Settings.builder().put("path.home", "dummy").build(), null),
        assertThat(doc, hasKey("properties"));
        templates.add(
     * FIXED paths, even though there is no translog repository.
            ClusterState.EMPTY_STATE,
            .build();
     * This test reproduces the exact scenario from SimpleIndexTemplateIT.testSimpleIndexTemplateTests
            .putList(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_RESTRICT_ALLOWLIST.getKey(), ".system")
        // Should NOT throw — index matches allowlist
            "target",
            Collections.emptySet(),
    public void testV1V2DisableObjectsEquivalence() throws Exception {
        );
            randomShardLimitService(),
                .put("index.merge.scheduler.max_merge_count", maxMergeCount)
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
            ) {
            )
                .put("index.non_copyable.existing", "existing")
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone, rack")
            cs
    public void testUpdatePluggableDataFormatSettingsSkipsEnabledWhenAlreadySet() {
        assertEquals("Should have 3 mappings (2 templates + 1 request)", 3, result3.size());
            .put(IndexMetadata.SETTING_INGESTION_SOURCE_MAPPER_TYPE, "default")
        doc3.put("properties", new HashMap<>());
                "must not contain the following characters " + org.opensearch.core.common.Strings.INVALID_FILENAME_CHARS
        });
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
                assertEquals(2, allMappings.size());
        Settings clusterBag = Settings.builder()
            );
            withTemporaryClusterService((clusterService, threadPool) -> {
            indicesServices,
                "properties": {
     * test for disable_objects override helper methods.
            return doc.get("disable_objects");
     * the specific userstate mapping. The regression in PR#19958 caused the dynamic/object
     * Returns null if disable_objects is not present.
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test").context(new Context(randomAlphaOfLength(5)));
                Collections.singleton(throwingProvider),
            Settings.EMPTY,
                        IndexMetadata.builder("my-index")
            Arrays.asList("{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":true,\"properties\":{}}}"),
                null,
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT).nodes(discoveryNodes).build();
                            }
            + "    \"_type\": \"@abc_template\",\n"
        List<Map<String, Object>> result4 = MetadataCreateIndexService.collectV2Mappings(
        request.settings(requestSettings.build());
            validateIndexName(checkerService, "_indexname", "must not start with '_', '-', or '+'");
                "Invalid exception message: " + validationException.getMessage(),
        final boolean copySettings,
        IndexTemplateMetadata templateMetadata = addMatchingTemplate(templateBuilder -> {
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
                );
        Settings indexSettings = aggregateIndexSettings(
        super.setUp();
            .numberOfShards(numShards)
        );
            @SuppressWarnings("unchecked")
    }
                null,
            new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE))
                repositoriesServiceSupplier
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
            ClusterState.EMPTY_STATE,
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
                }
import static org.opensearch.cluster.metadata.MetadataCreateIndexService.clusterStateCreateIndex;
            }));
                IndexNotFoundException.class,
                new Environment(Settings.builder().put("path.home", "dummy").build(), null),
        assertFalse(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.exists(out));
        assertEquals("lucene", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(aggregated));
                .toString();
        ClusterState clusterState = clusterStateWithSegmentsOnlyNode();
            .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 3)
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        Map<String, Object> properties = (Map<String, Object>) doc.get("properties");
            DefaultRemoteStoreSettings.INSTANCE,
            randomShardLimitService(),
     * carries a validator cross-checking {@code index.replication.type}, and this code also runs from snapshot
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone, rack")
                Settings.EMPTY,
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
                assertNull(settings.getAsBoolean("index.blocks.write", null));
        String templateContent = "{\n"
            4,
                () -> MetadataCreateIndexService.validateSplitIndex(
     * translog nor a cluster state repository.
        MetadataCreateIndexService.validateIngestionSourceSettings(settings, state);
    /**
                            }
            attributes,
            request,
            Settings.builder().put("cluster.default_number_of_replicas", clusterDefaultReplicaNumber).build()
            .numberOfReplicas(0)
    }
            // Check that patterns with wildcards work
            Arrays.asList("{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":true,\"properties\":{}}}"),
import org.opensearch.ExceptionsHelper;
        );
            ClusterState.EMPTY_STATE,
            randomShardLimitService(),
    }
            new AwarenessReplicaBalance(settings, clusterService.getClusterSettings()),
                clusterSettings
            DefaultRemoteStoreSettings.INSTANCE,
     * Tests that V1 template merging correctly handles request mapping overriding template
    }
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false)
        final Settings.Builder requestSettings = Settings.builder();
                    null,
                validationErrors.get(0),
            "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{}}}"
    @LockFeatureFlag(APPLICATION_BASED_CONFIGURATION_TEMPLATES)
                Settings.EMPTY,
        IndexMetadata.Builder imdBuilder = IndexMetadata.builder("test").settings(indexSettings);
                              }
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
        );
                true,
    public void testAggregateIndexSettingsStampsPluggableDataFormatClusterDefaults() {
                request,
                + "\"properties\":{"
    }
        DiscoveryNode remoteNode = new DiscoveryNode(
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        final int maxMergeCount = randomIntBetween(1, 16);
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            assertEquals("V2 should apply request mapping disable_objects=false to all mappings", false, v2DisableObjects);
            Collections.emptySet(),
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test").context(new Context(randomAlphaOfLength(5)));
            Settings.EMPTY,
import java.util.Locale;
            request,
            request,
import org.opensearch.cluster.routing.RoutingTable;
            .nodes(DiscoveryNodes.builder().add(remoteNode).build())
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
            indicesServices,
        assertTrue(customData.containsKey(expectedKey));
            Version.CURRENT
        verifyRemoteStoreIndexSettings(indexSettings, null, null, null, ReplicationType.DOCUMENT.toString(), null);
                    false,
            .numberOfShards(1)
        for (Map<String, Object> mapping : v2ResultList) {
            .nodes(DiscoveryNodes.builder().add(getRemoteNode()).build())
                )
        // Primary override is preserved; value still stamped from the cluster default.
                exception.getMessage().contains("index specifies a context which is not loaded on the cluster.")
        );
            repositoriesServiceSupplier
            () -> aggregateIndexSettings(
                + v2DisableObjects,
        clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    }
            @SuppressWarnings("unchecked")
        Settings settings = Settings.builder()
        Settings indexSettings = settingsBuilder.build();
                Optional.empty()
import java.util.function.BiFunction;
        Settings aggregateIndexSettings = aggregateIndexSettings(
        // Test 1: Basic V2 collectV2Mappings with disable_objects override logic
            new BalancedShardsAllocator(Settings.EMPTY),
            error.getMessage(),
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            Settings.EMPTY,
                randomShardLimitService(),
                true,
            DiscoveryNodeRole.BUILT_IN_ROLES,
                cs
        assertThat(validationErrors.size(), is(1));
                Settings.EMPTY,
                () -> MetadataCreateIndexService.validateShrinkIndex(state, "no_such_index", "target", Settings.EMPTY)
        long customCreationDate = System.currentTimeMillis() - TimeValue.timeValueDays(7).millis();
package org.opensearch.cluster.metadata;
        assertEquals("V1 should preserve request mapping disable_objects=false", false, v1DisableObjects2);
            null,
            + "      \"index.refresh_interval\": \"60s\"\n"
        requestSettings.put(IndexMetadata.SETTING_CREATION_DATE, requestCreationDate);
            Collections.emptySet(),
        routingTable = OpenSearchAllocationTestCase.startInitializingShardsAndReroute(service, clusterState, "source").routingTable();
        );
                    "type",
            request,
        assertEquals(clusterDefaultReplicaNumber.toString(), aggregatedSettings.get(SETTING_NUMBER_OF_REPLICAS));
            null,
            DefaultRemoteStoreSettings.INSTANCE,
            mixedTemplates,
        // used as a value container, not for the concurrency and visibility guarantees
            null,
            buildNewFakeTransportAddress(),
            null,
        // Even setting the default value (simple) explicitly should pass on current-version cluster
        Settings indexSettings = aggregateIndexSettings(
        });
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
            templateSettings,
        );
import org.opensearch.action.admin.indices.shrink.ResizeType;
                .build(),
    }
        Map<String, String> remoteCustomData = new HashMap<>();
            .put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), clusterMinRefreshTime)
    }
import static org.opensearch.index.IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING;
                assertTrue("numShards: " + randomNumShards, randomNumShards < 513);
            .build();
        // Request mapping defines a specific sub-field under @fields
                null,
        assertThat(mappings, Matchers.hasKey(MapperService.SINGLE_MAPPING_NAME));
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).build();
            .metadata(metadata)
                IllegalStateException.class,
    }
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).nodes(nodes).build();
        // Test 1: Basic template with disable_objects
        // Verify log template structure is preserved
                      "userstate": { "type": "keyword" }
        assertThat(aggregatedIndexSettings.get(SETTING_NUMBER_OF_SHARDS), equalTo("15"));
        );
        return attributes;
            assertTrue(checkerService.validateDotIndex(".pattern-test-with-suffix", false));
            {
        final Settings.Builder requestSettings = Settings.builder();
            .put(IndicesService.CLUSTER_RESTRICT_PLUGGABLE_DATAFORMAT_SETTING.getKey(), true)
        assertNotNull(updatedClusterState.metadata().findAllAliases(new String[] { "my-index" }).get("my-index"));
        Map<String, String> attributes = getNodeAttributes();
            {
        String template1 = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{\"field1\":{\"type\":\"text\"}}}}";
            .put(IndicesService.CLUSTER_RESTRICT_PLUGGABLE_DATAFORMAT_SETTING.getKey(), true)
            buildNewFakeTransportAddress(),
        assertEquals(
                    "source",
        assertEquals("field2 store should be from template2", false, field2.get("store"));
            .build();
            + "      \"created_at\": {\"type\": \"date\"}\n"
                clusterService,
        final Settings.Builder requestSettings = Settings.builder();
                resultJson
        CompressedXContent template = new CompressedXContent("""
        );
        mappings.add(mapping1);
            PathHashAlgorithm.NAME,
            .build();
import org.opensearch.common.compress.CompressedXContent;
                )
        int targetRoutingNumberOfShards = getIndexNumberOfRoutingShards(indexSettings, sourceIndexMetadata);
                null,
    private RepositoriesService repositoriesService;
            xContentRegistry()
    public void testValidatePluggableDataFormatAllowlistBypassesRestrict() {
        }
    public void testIndexLifecycleNameSetting() {
        IndexCreationException exception = expectThrows(
            .numberOfReplicas(0)
        assertEquals(error.getMessage(), "failed to create index [test-index]");
    }
            + MapperService.SINGLE_MAPPING_NAME
import org.opensearch.common.ValidationException;
import static org.opensearch.common.util.FeatureFlags.APPLICATION_BASED_CONFIGURATION_TEMPLATES;
            Settings.EMPTY,
            .build();
            assertFalse(checkerService.validateDotIndex(".test2", false));
            }
            repositoriesServiceSupplier
            assertThat(validationErrors.size(), is(0));
                    createClusterState("source", 8, randomIntBetween(0, 10), Settings.builder().put("index.blocks.write", true).build()),
        Settings.Builder indexSettingsBuilder = Settings.builder().put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false);
 * KIND, either express or implied.  See the License for the
        // Verify that the value is the same as set as earlier and the validation was successful
        );
import org.opensearch.indices.SystemIndices;
        when(blobStoreMock.isBlobMetadataEnabled()).thenReturn(randomBoolean());
            )
    public void testTemplateNumberOfReplicasOverridesClusterDefault() {
        Settings targetSettings = Settings.builder().put("index.number_of_shards", 1).build();
    public void testValidatePluggableDataFormatAllowsMatchingValues() {
import org.opensearch.test.ClusterServiceUtils;
            clusterSettings
import static org.mockito.Mockito.mock;
            expectThrows(
        Settings settings = Settings.builder()
            .metadata(metadata)
        AliasMetadata alias = resolvedAliases.get(0);
            + "          \"service\": {\"type\": \"keyword\"}\n"
    }
            assertTrue(checkerService.validateDotIndex(".pattern-test", false));
            assertTrue(
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            ReplicationType.SEGMENT.toString(),
            null,
            Settings.EMPTY,
        Map<String, Object> doc1 = new HashMap<>();
            );
     * cluster state repository.
        assertEquals("false", finalCustomData.get(IndexMetadata.REMOTE_STORE_SSE_ENABLED_INDEX_KEY));
    /**
    }
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test").context(new Context(contextName));
        final Settings.Builder requestSettings = Settings.builder();
        clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    public void testCustomCreationDatePreservedInIndexMetadata() {
            clusterState.metadata().index(indexName).getIndex(),
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
            ClusterState.EMPTY_STATE,
        request.recoverFrom(new Index("sourceIndex", UUID.randomUUID().toString()));
        indicesServices = mock(IndicesService.class);
                Map<String, Object> expected = expectedParser.map();
        );
            "the number of source shards [8] must be a multiple of [3]",
        int numRoutingShards = settings.getAsInt(IndexMetadata.INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.getKey(), numShards);
                  "@fields": {
    }
            null,
                threadPool,
        ThreadPool threadPool = new TestThreadPool(getTestName());
    public void testGetIndexNumberOfRoutingShardsWhenExplicitlySetToNull() {
        // non-remote cluster manager node
            assertEquals("ratio is not a power of two", intRatio, Integer.highestOneBit(intRatio));
                .put("index.non_copyable.request", "request")
    public void testDefaultNumberOfReplicasUsesNodeSetting() {
            indicesServices,
            + "      \"metric_name\": {\"type\": \"keyword\"},\n"
            Settings.EMPTY,
        requestSettings.put(SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT);
        assertThat(
        final String[] invalidAliasNames = new String[] { "-alias1", "+alias2", "_alias3", "a#lias", "al:ias", ".", ".." };
        Settings settings = Settings.builder()
                threadPool,
                                  "userstate": { "type": "keyword" },
        threadPool.shutdown();
            + "    }\n"
    }
    /**
            assertEquals(0, intRatio % 2);
            clusterSettings
    }
            forceClusterSettingEnabled,
                    targetSettings
        // Explicitly disable the FF
        assertEquals(ReplicationType.SEGMENT.toString(), indexSettings.get(SETTING_REPLICATION_TYPE));
        final Settings.Builder settings = Settings.builder();
        final Setting<String> nonCopyableExistingIndexSetting = Setting.simpleString(
            .build();
                finalClusterState,
    /**
        Settings remoteStoreMigrationSettings = Settings.builder()
        );
                        """
            .put(CLUSTER_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
        assertThat(
            .put(CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING.getKey(), true)
        List<IndexTemplateMetadata> templates = new ArrayList<>(3);
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).nodes(nodes).build();
        assert source < target : source + " >= " + target;
                throw new RuntimeException(e);
                                "type": "object",
        Settings out = indexSettingsBuilder.build();
            .build();
        ) {
        final Set<DiscoveryNodeRole> roles = Collections.unmodifiableSet(
            indexSettingsBuilder.put("index.allocation.max_retries", randomIntBetween(1, 1000));
            Settings.EMPTY,
            settings,
        Map<String, Object> logProperties = (Map<String, Object>) logDoc.get("properties");
            @SuppressWarnings("unchecked")
        assertEquals("Basic template should have disable_objects=true", true, doc.get("disable_objects"));
    public void testRemoteStorePathTypeForSegmentsOnlyNode() {
            error.getMessage(),
                randomShardLimitService(),
                    createClusterState("source", 1, 0, Settings.builder().put("index.blocks.write", true).build()),
                ResourceAlreadyExistsException.class,
        ClusterSettings strictClusterSettings = new ClusterSettings(
            );
    public void testGetIndexNumberOfRoutingShardsWhenExplicitlyConfigured() {
            }
        ClusterService clusterService = mock(ClusterService.class);
        // now we start the shard
    }
import org.junit.After;
            threadPool,
            expectThrows(
                XContentParser expectedParser = JsonXContent.jsonXContent.createParser(
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        );
            Settings.EMPTY,
        templates.add(
 */
                Collections.emptySet(),
        validateRemoteCustomData(
    }
            .putAlias(AliasMetadata.builder("alias1").writeIndex(true).build())
        ClusterState clusterState = ClusterState.builder(
        assertThat(aggregatedIndexSettings.get(SETTING_NUMBER_OF_REPLICAS), equalTo("2"));
                assertEquals(mappings, allMappings.get(0));
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        );
    }
            @Override
        return createTestShardLimitService(randomIntBetween(10, 10000), false);
        ).collect(Collectors.toSet());
    public void testRemoteStoreImplicitOverrideReplicationTypeToSegmentForRemoteStore() {
 * Unless required by applicable law or agreed to in writing,
            settingsBuilder,
        request.settings(requestSettings.build());
        Metadata metadata = Metadata.builder()
                );
            .putList(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_RESTRICT_ALLOWLIST.getKey(), ".system")
    private void validateIndexName(MetadataCreateIndexService metadataCreateIndexService, String indexName, String errorMessage) {
            );
     */
        IndexCreationException exception = expectThrows(
        Map<String, Object> field2 = (Map<String, Object>) properties.get("field2");
                    Settings.builder().put("index.number_of_shards", 5).build()
        }));
                    null,
                ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).build()
            ClusterState.EMPTY_STATE,
            emptyList(),
        } finally {
                    Settings.EMPTY,
            )
        assertEquals(
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            null,
        TimeValue indexRefreshTime = TimeValue.timeValueMillis(clusterMinRefreshTimeMs + randomNonNegativeLong());
                null,
        Settings nodeSettings = Settings.builder().put(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey(), 0).build();
            builder.put(IndexMetadata.builder(myIndex).putAlias(AliasMetadata.builder(newAlias.getAlias()).build()));
            Object v2DisableObjects = extractDisableObjectsValue(mapping);
            clusterState,
        // Test 3: Mixed scenario - some templates with disable_objects, some without
            Arrays.asList("{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{}}}"),
            int intRatio = (int) ratio;
        return IndexTemplateMetadata.builder(name).patterns(singletonList(pattern));
    @Before
        assertEquals(
            + "      \"message\": {\n"
                Settings.builder().put("node.attr.remote_store.segment.repository", "test").build(),
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
}
            .put("node.attr.remote_store.segment.repository", "my-segment-repo-1")
                validationErrors.get(0),
        assertEquals("parquet", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(out));
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            + "          \"environment\": {\"type\": \"keyword\"},\n"
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a, b")
            () -> MetadataCreateIndexService.validateIngestionSourceSettings(settings, state)
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        // now we start the shard
            Settings.EMPTY,
        );
        when(repositoryMock.isSeverSideEncryptionEnabled()).thenReturn(true);
                new SystemIndices(Collections.emptyMap()),
        );
        ThreadPool threadPool = new TestThreadPool(getTestName());
            null,
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
import org.opensearch.cluster.routing.allocation.decider.MaxRetryAllocationDecider;
            + "      \"custom_id\": {\"type\": \"keyword\"},\n"
            new AwarenessReplicaBalance(settings, clusterService.getClusterSettings()),
                    createClusterState("source", 3, randomIntBetween(0, 10), Settings.builder().put("index.blocks.write", true).build()),
    }
        assertEquals(
                Settings.EMPTY,
        Settings mismatch = Settings.builder().put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "lucene").build();
            MetadataIndexTemplateService.resolveAliases(Collections.singletonList(templateMetadata)),
                () -> MetadataCreateIndexService.validateSplitIndex(
        Settings indexSettings = Settings.builder()
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        assertThat(mappings, Matchers.hasKey(MapperService.SINGLE_MAPPING_NAME));
        mapping2.put(MapperService.SINGLE_MAPPING_NAME, doc2);
            .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)
            }
    public void testValidateIngestionSourceSettingsPartitionStrategySimpleAlsoRejectedOnMixedCluster() {
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT);
                indicesServices,
            Collections.emptySet(),
                request,
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            @SuppressWarnings("unchecked")
        MetadataCreateIndexService.validateIngestionSourceSettings(settings, state);
            final List<String> validationErrors = checkerService.getIndexSettingsValidationErrors(
        // pipeline, so the effective values land in the settings returned by aggregateIndexSettings.
        // Feature flag is off by default in tests; the helper must not contribute either setting,
            .settings(Settings.builder().put("index.version.created", Version.CURRENT).build())
                .put(INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.getKey(), routingNumberOfShards)
import static java.util.Collections.singleton;
        assertEquals("Should have 3 mappings (2 templates + 1 request)", 3, complexResult.size());
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
            .put(IndicesService.CLUSTER_RESTRICT_PLUGGABLE_DATAFORMAT_SETTING.getKey(), true)
            newIndexMetadata,
        Settings aggregated = aggregateIndexSettings(
    }
            DefaultRemoteStoreSettings.INSTANCE,
        );
    }
    public void testNewIndexIsRemoteStoreBackedForRemoteStoreDirectionAndMixedMode() {
    private AliasValidator aliasValidator;
            assertThat(validationErrors.size(), is(1));
                        .endObject()
        MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
            "index.non_copyable.existing",
    private Object extractDisableObjectsValue(Map<String, Object> mapping) {
            templateMetadata.settings(),
        }).collect(Collectors.toList());
        );
        );
                    "type": "object",
            "{\""
                IndexNotFoundException.class,
                DefaultRemoteStoreSettings.INSTANCE,
        String requestMapping4 = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{}}}";
        List<AliasMetadata> resolvedAliases = resolveAndValidateAliases(
                null,
            buildNewFakeTransportAddress(),
    }
    }
                    .put(
import org.opensearch.index.query.QueryShardContext;
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
                        SETTING_REMOTE_SEGMENT_STORE_REPOSITORY
        MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        );
            assertThat(
        assertEquals(
        // Test 2: Multiple templates with different disable_objects values
    public void testCreateIndexWithCustomCreationDate() {
        BlobStore blobStoreMock = mock(BlobStore.class);
                    put(1L, contextName);
        Settings clusterBag = Settings.builder()
            "source",
                null,
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
            null,
        assertEquals(REPLICATION_MISMATCH_VALIDATION_ERROR, exception.getCause().getMessage());
            settings,
        // Index explicitly sets a different value — normally rejected, but allowlist bypasses it.
            additionalIndexScopedSettings.stream()
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
            return new CompressedXContent(mapping);
                clusterSettings
    }
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false)
        try (
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
                null,
                )
        final Settings.Builder requestSettings = Settings.builder()
            xContentRegistry()
            @SuppressWarnings("unchecked")
        List<Map<String, Object>> result2 = MetadataCreateIndexService.collectV2Mappings(
            + "    },\n"
            + "      \"properties\": {\n"
        request.settings(requestSettings.build());
            + "    \"properties\": {\n"
        IndexTemplateMetadata templateMetadata = addMatchingTemplate(
            clusterState,
        );
            validateIndexName(checkerService, "", "Invalid index name [], must not be empty");
            request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
    public void testIndexCreationWithIndexStoreTypeRemoteStoreThrowsException() {
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        final ClusterState routingTableClusterState = ClusterState.builder(initialClusterState).routingTable(initialRoutingTable).build();
            assertEquals(INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.get(indexMetadata.getSettings()).intValue(), routingNumberOfShards);
            Collections.emptySet(),
                threadPool,
            clusterSettings
            when(metadata.systemTemplatesLookup()).thenReturn(Map.of(contextName, new TreeMap<>() {
        Settings indexSettings = aggregateIndexSettings(
            + "        }\n"
import java.util.HashSet;
            Settings.EMPTY,
            Setting.Property.NotCopyableOnResize
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        Settings out = indexSettingsBuilder.build();
        attributes.put(REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY, "my-translog-repo-1");
            () -> aggregateIndexSettings(
            + "  }\n"
                Settings.EMPTY,
        );
                DeprecationHandler.IGNORE_DEPRECATIONS,
import java.io.IOException;
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.getRemoteStoreTranslogRepo;
            expectThrows(
            settingsBuilder,
            .put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), refreshInterval)
        }
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
        validateV1V2Equivalence(
    public void testAsyncDurabilityThrowsExceptionWhenRestrictSettingTrue() {
            ) {
        // Test creating an index with a custom creation_date in the future
        aliasValidator = new AliasValidator();
        assertEquals("", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(out));
        when(repositoryMock.blobStore()).thenReturn(blobStoreMock);
            .build();
    }
                    NamedXContentRegistry.EMPTY,
            null,
        aggregateIndexSettings(
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
            ClusterState.EMPTY_STATE,
            Settings.EMPTY,
        assertEquals("Should have 3 mappings (2 templates + 1 request)", 3, result.size());
                Collections.emptySet(),
                createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
    }
        Map<String, Object> mappings = parseV1Mappings(
            Settings.EMPTY,
        final IllegalArgumentException error = expectThrows(IllegalArgumentException.class, () -> {
        validMapping.put(MapperService.SINGLE_MAPPING_NAME, validDoc);
            double ratio = numRoutingShards / randomNumShards;
                    "source",
    public void testIndexTotalPrimaryShardsPerNodeSettingValidationWithRemoteStore() {
        List<CompressedXContent> templateMappings2 = Arrays.asList(
            xContentRegistry()
                    }
        when(clusterService.getSettings()).thenReturn(settings);
            .build();
        RoutingTable routingTable = service.reroute(clusterState, "reroute").routingTable();
            () -> aggregateIndexSettings(
        BlobStoreRepository repositoryMock = mock(BlobStoreRepository.class);
    public void testDefaultSettings() {
        withTemporaryClusterService(((clusterService, threadPool) -> {
            + "  \"version\": 1\n"
            .putAlias(AliasMetadata.builder("alias1").writeIndex(true).build())
        runPrepareResizeIndexSettingsTest(
        RoutingTable routingTable = routingTableBuilder.build();
    public void tearDown() throws Exception {
        );
        );
            IndexCreationException.class,
        Object v1DisableObjects1 = extractDisableObjectsValue(v1Result1);
            final ClusterService clusterService = ClusterServiceUtils.createClusterService(threadPool);
        ClusterService clusterService = mock(ClusterService.class);
        Map<String, Object> mapping3 = new HashMap<>();
            "target",
 * under the License.
                    "dynamic": "true"
            null,
        final Settings.Builder requestSettings = Settings.builder();
            repositoriesServiceSupplier
            .build();
                        .startObject("properties")
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            expectThrows(
            ClusterState.EMPTY_STATE,
        assertNotNull(imdBuilder.build().getCustomData());
        final Settings ilnSetting = Settings.builder().put("index.lifecycle.name", "dummy").build();
    }
            "Setting [index.routing.allocation.total_primary_shards_per_node] or [index.routing.allocation.total_remote_capable_primary_shards_per_node] can only be used with remote store enabled clusters",
                new SystemIndices(Collections.emptyMap()),
                "Invalid exception message." + exception.getMessage(),
            complexRequestMapping,
        } finally {
            null,
            "source",
                "analysis settings are not overwritten",
import java.util.Collections;
            settings,
        request.aliases(singleton(new Alias(aliasName)));
        TimeValue clusterMinRefreshTime = TimeValue.timeValueSeconds(clusterMinRefreshTimeMs);
            + "}";
            Collections.emptySet(),
        assertNotNull(imdBuilder.build().getCustomData());
            () -> MetadataCreateIndexService.validateIngestionSourceSettings(settings, state)
            Collections.emptySet(),
                clusterService,
        Metadata metadata = Metadata.builder()
        clusterSettings = new ClusterSettings(clusterSettingsSetting, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY;
            DiscoveryNodeRole.BUILT_IN_ROLES,
        Settings settings = Settings.builder().build();
            Settings.EMPTY,
        }
            copySettings,
    }
        List<Map<String, Object>> result3 = MetadataCreateIndexService.collectV2Mappings(
            "fencing default should still be stamped for a remote-store index",
                    Settings.builder().put("index.number_of_shards", 4).build()
            templateMappings,
        Settings indexSettings = aggregateIndexSettings(
        validateV1V2Equivalence(
        );
            Settings.EMPTY,
            .setRoutingNumShards(numRoutingShards)
                Metadata.builder()
        );
            cs
                    )
            .build();
import org.opensearch.common.util.FeatureFlags;
        );
    }
            .put(INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.DOCUMENT)
    }
        MetadataCreateIndexService.validateIngestionSourceSettings(settings, state);
            "[simplefs] is deprecated and will be removed in 2.0. Use [niofs], which offers equal "
            null,
                builder.putMapping("type", "{\"type\": {}}");
            settings.put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), between(1, 128) + "mb");
        );
            null,
            + "  }\n"
            randomShardLimitService(),
            .putList(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_RESTRICT_ALLOWLIST.getKey(), ".system", ".kibana")
            .put("index.ingestion_source.mapper_settings.op_type_field", "is_deleted")
    }
        assertThat(aggregatedIndexSettings.get(SETTING_NUMBER_OF_REPLICAS), equalTo("4"));
        Object docObj = mapping.get(MapperService.SINGLE_MAPPING_NAME);
        Metadata metadata = Metadata.builder()
        assertEquals("test", thrown.getIndex().getName());
        assertEquals("lucene", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(out));
            .put(CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING.getKey(), false)
import org.opensearch.cluster.routing.allocation.AllocationService;
                Settings.EMPTY,
    @Before
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            null,
            assertThat(validationErrors.size(), is(1));
                          }
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), true)
        };
                clusterSettings
            + "\":{\"disable_objects\":true,\"properties\":{\"field1\":{\"type\":\"text\"}}}}";
    /**
            request,
        );
        Object result = extractDisableObjectsValue(mappingWithDisableObjects);
                Settings.EMPTY,
        final Settings.Builder requestSettings = Settings.builder();
import static org.hamcrest.Matchers.hasKey;
        Map<String, Object> parsedMappings = MetadataCreateIndexService.parseV1Mappings(
        assertThat(aggregatedIndexSettings.get("requestSetting"), is("requestValue"));
            .put(SETTING_NUMBER_OF_REPLICAS, 0)
            .build();
            randomShardLimitService(),
    }
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
    }
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        );
            Set.of(INDEX_READ_ONLY_BLOCK),
import org.opensearch.common.settings.ClusterSettings;
        // Test 3: Request mapping priority - template has disable_objects=true, request has disable_objects=false
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
        Map<String, Object> v1Result = MetadataCreateIndexService.parseV1Mappings(requestMapping, templateMappings, xContentRegistry());
                Settings.EMPTY,
            .settings(settings(Version.CURRENT).put(SETTING_READ_ONLY, true))
    public void testUpdatePluggableDataFormatSettingsStampsWhenIndexDoesNotMatchAllowlist() {
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
            null,
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(newNode("node1")).build();
            indexSettings,
            .put("index.version.created", version)
            + "      \"level\": {\"type\": \"keyword\"},\n"
        );
        // remote data node
 * this work for additional information regarding copyright
                    buildNewFakeTransportAddress(),
            new SystemIndices(Collections.emptyMap()),
        );
        MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
                }
                break; // Found a disable_objects value, use it for comparison
                null,
            public Settings getAdditionalIndexSettings(String indexName, boolean isDataStreamIndex, Settings templateAndRequestSettings) {
        requestSettings.put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
    /**
            randomShardLimitService(),
            "index [source] already exists",
            "true",
            @SuppressWarnings("unchecked")
import static org.opensearch.cluster.metadata.MetadataCreateIndexService.resolveAndValidateAliases;
                + "or better performance, or other file systems instead."
        );
        assertEquals("Should handle null mappings gracefully", true, resultDoc.get("disable_objects"));
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
                repositoriesServiceSupplier
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING;
                false,
    public void testRemoteCustomData() {
        doc2.put("properties", new HashMap<>());
                checkerService,
            null,
        request.settings(Settings.builder().put("request_setting", "value2").build());
            + "  \"template\": {\n"
        assertEquals(refreshInterval, INDEX_REFRESH_INTERVAL_SETTING.get(indexSettings));
        Settings clusterSettingsSetting = Settings.builder()
    }
        assertEquals(Long.toString(futureCreationDate), aggregatedSettings.get(IndexMetadata.SETTING_CREATION_DATE));
            templateMappings,
    }
        );
                    "Invalid exception message." + exception.getMessage(),
                )
            Settings.EMPTY,
     * {@code SearchReplicaRestoreIT}. The stamp only ever needed a boolean, so it reads the raw value.
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(newNode("node1")).add(oldNode).build();
            clusterState,
            .build();
                + "\"field2\":{\"type\":\"text\",\"store\":false}"
            xContentRegistry(),
        IllegalArgumentException e = expectThrows(
        request.mappings(reqMapping.string());
                    "source",
            BigArrays.NON_RECYCLING_INSTANCE,
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
    }
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).nodes(nodes).build();
        final Map<String, IndexTemplateMetadata> templatesBuilder = new HashMap<>();
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
            "source",
            final List<String> validationErrors = checkerService.getIndexSettingsValidationErrors(ilnSetting, true, Optional.empty());
        );
            new AwarenessReplicaBalance(forceClusterSettingEnabled, clusterService.getClusterSettings()),
        final IndexCreationException error = expectThrows(IndexCreationException.class, () -> {
    }
import org.opensearch.indices.SystemIndexDescriptor;
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
        docWithDisableObjects.put("disable_objects", true);
            .build();
                    allMappings.get(1)
            MetadataIndexTemplateService.resolveSettings(templates),
            Map<String, Object> mapping = complexResult.get(i);
import java.util.concurrent.atomic.AtomicReference;
     * DiscoveryNode::isRemoteSegmentStoreNode, so a segments-only node qualifies as a donor even though it has no
            request,
        // Use DOCUMENT replication type setting for index creation
            Settings.EMPTY,
 * You may obtain a copy of the License at
            settings,
                threadPool,
        return source * x == target;
        );
        // Serialize result to JSON and compare against expected merged output
            Settings.EMPTY,
        }
        Settings aggregatedIndexSettings = aggregateIndexSettings(
            null
        // a forbidden index-level override by throwing IndexCreationException wrapping a
            );
    }
            () -> aggregateIndexSettings(
            Settings.EMPTY,
        );
                createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
            .put(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey(), 2)
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                assertEquals("best_compression", settingsBuilder.get(EngineConfig.INDEX_CODEC_SETTING.getKey()));
        // Test 2: Request mapping with disable_objects overrides templates
                "{\""
import java.util.concurrent.CountDownLatch;
import org.opensearch.common.settings.IndexScopedSettings;
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            new SystemIndices(Collections.emptyMap()),
            for (Map<String, Object> mapping : v2ResultList) {
                null,
    private void validateV1V2Equivalence(List<String> templateMappingStrings, String requestMapping) throws Exception {
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            null,
                )
            .transientSettings(Settings.builder().put(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey(), 1).build())
        Settings settings = Settings.builder().put(CLUSTER_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT).build();
            request,
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone, rack")
                + "\":{"
    private void withTemporaryClusterService(BiConsumer<ClusterService, ThreadPool> consumer) {
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_INGESTION_SOURCE_PARTITION_STRATEGY, "simple").build();
     */
                null,
                }
            clusterState.metadata().index("sourceIndex"),
import static org.opensearch.indices.IndicesService.CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING;
        // Set index setting refresh interval the same value as the cluster minimum refresh interval
            if (numRoutingShards <= 1024) {
                    assertEquals(
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                    createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
        ClusterService clusterService = mock(ClusterService.class);
    public void testRefreshIntervalValidationSuccessWithIndexSettingGreaterThanClusterMinimum() {
        Map<String, String> attributes = new HashMap<>();
            "index setting [index.translog.durability=async] is not allowed as cluster setting [cluster.remote_store.index.restrict.async-durability=true]",
        String template4 = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":true,\"properties\":{}}}";
            equalTo(
            cs
            + "  \"_meta\": {\n"
                    "properties": {
                Settings.EMPTY,
                    }
        String resultJson = XContentFactory.jsonBuilder().map(result).toString();
            new AllocationDeciders(singleton(new MaxRetryAllocationDecider())),
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a, b")
            + "  }\n"
    public void testUpdatePluggableDataFormatSettingsStampsClusterDefaultsWhenIndexLevelAbsent() {
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
            .put("node.attr.remote_store.translog.repository", "my-translog-repo-1")
            null,
import org.opensearch.index.IndexNotFoundException;
            .build();
                    String.format(
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
            new CompressedXContent("{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":false,\"properties\":{}}}")
        );
                false,
            cs
        return ClusterState.builder(ClusterName.DEFAULT).nodes(DiscoveryNodes.builder().add(segmentsOnlyNode).build()).build();
        );
            aliasValidator,
        String segmentRepositoryName = "my-segment-repo-1";
        // Verify that the value is the same as set earlier and validation was successful
                    DefaultRemoteStoreSettings.INSTANCE,
        assertThat(mappingsProperties, hasKey("mapping_from_template"));
        assertEquals("true", finalCustomData.get(IndexMetadata.REMOTE_STORE_SSE_ENABLED_INDEX_KEY));
                repositoriesServiceSupplier
        // Test 1: Default mapping merge behavior when no disable_objects is present
        assertNotNull(
        TimeValue translogBufferInterval
            .putAlias(AliasMetadata.builder("alias1").writeIndex(true).build())
                new SystemIndices(Collections.singletonMap("foo", systemIndexDescriptors)),
                Optional.empty()
            clusterService,
            request,
    }
            indexSettings,
        );
            randomShardLimitService(),
                new SystemIndices(Collections.emptyMap()),
        final Settings.Builder requestSettings = Settings.builder();
        Settings clusterBag = Settings.builder()
                Settings.EMPTY,
                "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{\"field1\":{\"type\":\"text\"}}}}",
        TimeValue indexRefreshTime = TimeValue.timeValueMillis(clusterMinRefreshTimeMs - randomIntBetween(1, clusterMinRefreshTimeMs - 1));
        final Set<DiscoveryNodeRole> roles = Collections.unmodifiableSet(
        // Test 2: Request mapping priority - template has disable_objects=false, request has disable_objects=true
            templateMappings,
        );
            "my-segment-repo-1",
        assertTrue("index should be remote-backed for segments", indexSettings.getAsBoolean(SETTING_REMOTE_STORE_ENABLED, false));
                + "\"field1\":{\"type\":\"text\",\"store\":true},"
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            clusterState,
     */
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
            .build();
                    () -> checkerService.validateContext(request)
            MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
                assertEquals("60s", settingsBuilder.get(INDEX_REFRESH_INTERVAL_SETTING.getKey()));
                request,
                Optional.empty()
            Settings.EMPTY,
            """);
            try (
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
                + "and [index.translog.retention.size] are deprecated and effectively ignored. They will be removed in a future version."
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
            Version.CURRENT
        assertEquals(replicationType, indexSettings.get(SETTING_REPLICATION_TYPE));
                .put("index.version.created", Version.CURRENT)
            .build();
        docWithDisableObjects.put("properties", new HashMap<>());
                  "@fields": {
    public void testCreateIndexWithContextAbsent() throws Exception {
            "index source must block write operations to resize index. use \"index.blocks.write=true\"",
            .settings(Settings.builder().put("index.version.created", Version.CURRENT).build())
            + "  \"_meta\": {\n"
        for (int i = 0; i < v2Result.size(); i++) {
                + ", V2 result: "
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
            settings,
        ClusterService clusterService = mock(ClusterService.class);
        Settings nodeSettings = Settings.builder().put(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey(), 0).build();
                Settings.EMPTY,
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
            UUIDs.base64UUID(),
import java.util.function.BiConsumer;
        // Test with mapping without disable_objects
        );
        );
import org.opensearch.core.xcontent.NamedXContentRegistry;
                repositoriesServiceSupplier
        Settings nodeSettings = Settings.builder().put(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey(), 0).build();
    }
                ve.addValidationError(expectedError);
        assertEquals("lucene", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(out));
            "index [source] already exists",
            } catch (IOException e) {
        Settings clusterBag = Settings.builder()
            expectThrows(
                indexSettings,
        mapping1.put(MapperService.SINGLE_MAPPING_NAME, doc1);
        // Verify error message
                                "properties": {
            null,
        assertFalse(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(aggregated));
                assertNull(settings.get("index.non_copyable.existing"));
            request,
        Settings.Builder indexSettingsBuilder = Settings.builder()
                Settings.EMPTY,
        // index.store.type is set to remote_snapshot
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
                () -> MetadataCreateIndexService.validateSplitIndex(state, "no_such_index", "target", targetSettings)
            "segments-only indices should use the cluster's configured path type",
            .put("node.attr.remote_store.translog.repository", "my-translog-repo-1")
        BlobStoreRepository repositoryMock = mock(BlobStoreRepository.class);
            + "      \"index.codec\": \"best_compression\",\n"
        IndexCreationException exception = expectThrows(
            null,
            .put(IndicesService.CLUSTER_RESTRICT_PLUGGABLE_DATAFORMAT_SETTING.getKey(), true)
    public void testValidateTranslogRetentionSettings() {
                NamedXContentRegistry.EMPTY,
    }
        );
                ExceptionsHelper.reThrowIfNotNull(e);
    public void testFencingDefaultStampDoesNotValidateReplicationTypeCompatibility() {
                assertThat(settings.getAsInt("index.merge.scheduler.max_merge_count", null), equalTo(maxMergeCount));
        "Validation Failed: 1: index setting [index.replication.type] is not allowed to be set as [cluster.index.restrict.replication.type=true];";
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_INGESTION_SOURCE_MAPPER_TYPE, "field_mapping").build();
        CompressedXContent templateB = new CompressedXContent("""
        assertEquals(ReplicationType.SEGMENT.toString(), indexSettings.get(INDEX_REPLICATION_TYPE_SETTING.getKey()));
                request,
                indicesServices,
        );
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        Settings clusterBag = Settings.builder()
            false,
import static org.hamcrest.Matchers.startsWith;
            if (mappingDisableObjects != null) {
            .put("index.version.created", Version.CURRENT)
                Collections.emptySet(),
        final ClusterState initialClusterState = ClusterState.builder(
        request.settings(requestSettings.build());
        );
            null,
        Settings settings = Settings.builder()
                builder.putMapping("type", "{\"type\":{\"properties\":{\"field\":{\"type\":\"keyword\"}}}}");
    /**
                    IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        // Without the explicit source_partition_strategy setting, no metadata is replicated — old nodes are unaffected.
        Map<String, Object> logDoc = (Map<String, Object>) logResult.get(MapperService.SINGLE_MAPPING_NAME);
            ).getMessage()
            + "  \""
                    createClusterState("source", 5, 0, Settings.builder().put("index.blocks.write", true).build()),
            threadPool.shutdown();
            Settings.EMPTY,
            clusterSettings
 * ownership. Elasticsearch licenses this file to you under
            Collections.emptySet(),
     * Covers: basic override logic, null mappings, no disable_objects scenarios.
        );
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(newNode("node1")).build();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
        assertEquals("parquet", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(aggregated));
        Map<String, Object> mappingWithDisableObjects = new HashMap<>();
        );
            MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
        Mockito.when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
                true,
            DefaultRemoteStoreSettings.INSTANCE,
            + "}";
     */
            Settings.EMPTY,
        String contextName = randomAlphaOfLength(5);
            );
        assertThat(alias.writeIndex(), is(true));
                    "source",
        @SuppressWarnings("unchecked")
        );
import java.util.concurrent.atomic.AtomicBoolean;
            request.mappings(),
        Settings aggregatedIndexSettings = aggregateIndexSettings(
            null,
    }
            IndexCreationException.class,
        for (Map<String, Object> mapping : mixedResult) {
        assertNotNull(remoteCustomData);
        Map<String, Object> parsedMappings = MetadataCreateIndexService.parseV1Mappings(
        AllocationService service = new AllocationService(
        assertEquals(isRemoteSegmentEnabled, indexSettings.get(SETTING_REMOTE_STORE_ENABLED));
        );
import org.opensearch.indices.replication.common.ReplicationType;
              }
        // One node on older version — should fail
        );
        ).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
    }
            clusterSettings
            clusterState,
        Settings clusterSettingsSetting = Settings.builder()
            ClusterState.EMPTY_STATE,
        IndexMetadata newIndexMetadata = IndexMetadata.builder("test")
        assertTrue("V1 result should contain field2", v1Properties.containsKey("field2"));
            + "  },\n"
            expectThrows(
            clusterSettings
    public void testDefaultNumberOfReplicasUsesPersistentSettingOverNodeSetting() {
    public void testValidateCloneIndex() {
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.STRICT)
        assertTrue(e.getMessage().contains("field_mapping"));
        assertTrue(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(aggregated));
        for (Map<String, Object> mapping : result4) {
        + REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;
        );
        final Settings.Builder requestSettings = Settings.builder();
                null,
import java.util.Comparator;
            Map<String, Object> doc = (Map<String, Object>) mapping.get(MapperService.SINGLE_MAPPING_NAME);
                new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
        Settings indexSettings = aggregateIndexSettings(
            randomBoolean(),
        Settings.Builder settingsBuilder = Settings.builder().put(INDEX_REFRESH_INTERVAL_SETTING.getKey(), "30s");
            )
        String requestMapping3 = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":false,\"properties\":{}}}";
import org.opensearch.repositories.blobstore.BlobStoreRepository;
            new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
    }
            final List<String> validationErrors = checkerService.getIndexSettingsValidationErrors(
            Collections.emptySet(),
 */
    }
     */
                repositoriesServiceSupplier
        );
        assertEquals(Integer.valueOf(2), INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.get(indexSettings));
        MetadataCreateIndexService.updateRemoteStoreSettings(
        assertTrue(thrown.getCause() instanceof ValidationException);
            Settings.EMPTY,
     * inherits the object's type/dynamic settings from templates.
    /**
        );
        Settings settings = settingsBuilder.build();
            xContentRegistry()
        Settings targetSettings = Settings.builder().put("index.number_of_shards", numShards * 2).build();
                return new CompressedXContent(s);
        );
            true,
            + "    }\n"
    public void testValidateIndexName() throws Exception {
        Map<String, String> attributes = getNodeAttributes();
            IllegalArgumentException.class,
        assertFalse(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.exists(out));
            service,
    }
        checkerService.validateIndexSettings("test", indexSettings, false);
        Settings indexSettings = aggregateIndexSettings(
        }));
