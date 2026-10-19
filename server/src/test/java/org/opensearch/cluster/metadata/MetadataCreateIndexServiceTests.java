        // Test case 2: Empty request mapping  
        // This checks that aggregateIndexSettings works for the case when the index setting `index.refresh_interval`
    public void testIndexCreationWithIndexStoreTypeRemoteStoreThrowsException() {  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                    exception.getMessage().contains("index specifies a context which cannot be used without enabling")
            new AwarenessReplicaBalance(forceClusterSettingEnabled, clusterService.getClusterSettings()),
        assertFalse(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(out));  
            DiscoveryNodeRole.BUILT_IN_ROLES,  
        Map<String, Object> parsedMappings = MetadataCreateIndexService.parseV1Mappings(
            Settings.EMPTY,  
            indicesServices,  
            "segments-only indices should use the cluster's configured path type",
            );
            .build();
            clusterSettings
        assertTrue("Log template should have message", logProperties.containsKey("message"));
        request.settings(nonMatchingReplicationIndexSettings);  
        }
        final ClusterState initialClusterState = ClusterState.builder(  
     * index metadata of the underlying index. This captures information around the resolution pattern of the path for  
    private static ClusterState clusterStateWithSegmentsOnlyNode() {
            request,  
        );  
    /**  
        // Should not throw
                clusterSettings
            .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 3)
            EmptyClusterInfoService.INSTANCE,
                assertEquals("60s", settingsBuilder.get(INDEX_REFRESH_INTERVAL_SETTING.getKey()));
        Settings aggregatedIndexSettings = aggregateIndexSettings(
        ClusterState clusterState = ClusterState.builder(
     * FIXED paths, even though there is no translog repository.
import java.util.Optional;
                    IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,  
    public void testApplyContextWithSettingsOverlap() throws IOException {  
        assertFalse(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(out));  
        indexSettings = Settings.builder()
            clusterService,
            );
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "lucene")
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();  
                .build(),
            templateMappings2,
        return createTestShardLimitService(randomIntBetween(10, 10000), false);
        DiscoveryNode remoteNode = new DiscoveryNode(  
        ClusterState updatedClusterState = clusterStateCreateIndex(  
            .build();
        assertEquals(clusterDefaultReplicaNumber.toString(), aggregatedSettings.get(SETTING_NUMBER_OF_REPLICAS));  
        docWithoutDisableObjects.put("properties", new HashMap<>());  
        // This checks that aggregateIndexSettings works for the case when the index setting `index.refresh_interval`
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
        runPrepareResizeIndexSettingsTest(  
        // Test 2: Request mapping priority - template has disable_objects=false, request has disable_objects=true
        verifyRemoteStoreIndexSettings(  
                    "target",  
        Settings indexSettings = aggregateIndexSettings(  
            Collections.emptySet(),
        final String expectedError = "index setting [index.example] is not allowed to be set as [cluster.test.restrict=true]";  
        ClusterState clusterState = ClusterState.builder(
            ClusterState.EMPTY_STATE,
        Map<String, Object> doc1 = new HashMap<>();
                    Settings.EMPTY,
        );
    public void testValidateTranslogRetentionSettings() {  
                            .settings(settings(Version.CURRENT).put(SETTING_READ_ONLY, true))  
        DiscoveryNode oldNode = new DiscoveryNode("old_node", buildNewFakeTransportAddress(), emptyMap(), roles, Version.V_3_5_0);
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    private static final String segmentRepositoryNameAttributeKey = NODE_ATTRIBUTES.getKey()
        ThreadPool threadPool = new TestThreadPool(getTestName());
        // Test 1: Basic override functionality
            rerouteRoutingTable,
        long negativeCreationDate = -1000000000L; // Some time before 1970  
            .build();
        Settings out = indexSettingsBuilder.build();
        Settings settings = Settings.builder().build();
            Settings.builder().put("index.analysis.analyzer.default.tokenizer", "whitespace").build(),
            "index source must block write operations to resize index. use \"index.blocks.write=true\"",
            targetShards = randomIntBetween(numShards + 1, 100);
            randomIntBetween(0, 10),
    }  
                null,
        Map<String, Object> logProperties = (Map<String, Object>) logDoc.get("properties");
    private void withTemporaryClusterService(BiConsumer<ClusterService, ThreadPool> consumer) {
            for (Map<String, Object> mapping : v2ResultList) {
        );  
            new Environment(Settings.builder().put("path.home", "dummy").build(), null),
            .numberOfReplicas(0)
        MetadataCreateIndexService.updatePluggableDataFormatSettings(indexSettingsBuilder, cs, "test-index");
            assertThat(validationErrors.size(), is(1));  
        // cluster.remote_store.index.restrict.async-durability is false or not set, it allows all types of durability modes
            xContentRegistry()  
        Map<String, Object> resultDoc = (Map<String, Object>) nullMappings.get(1).get(MapperService.SINGLE_MAPPING_NAME);
                new SystemIndices(Collections.emptyMap()),  
            assertEquals("All mappings should have disable_objects=false from request", false, doc.get("disable_objects"));
            cs
            Collections.emptySet(),
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        request = new CreateIndexClusterStateUpdateRequest("create index", ".system-index", ".system-index");
                request,
        }));  
                null,  
        });
        Map<String, String> remoteCustomData = new HashMap<>();
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.STRICT)
        // now we start the shard
        String requestMapping3 = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":false,\"properties\":{}}}";
        assertEquals(Integer.valueOf(-1), INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.get(indexSettings));
        validMapping.put(MapperService.SINGLE_MAPPING_NAME, validDoc);  
    private IndicesService indicesServices;
                request,
                ResourceAlreadyExistsException.class,  
                                }
    }
    }
        assertEquals("true", finalCustomData.get(IndexMetadata.REMOTE_STORE_SSE_ENABLED_INDEX_KEY));
        RoutingTable routingTable = service.reroute(clusterState, "reroute").routingTable();
            settings,
        }
            + "      }\n"
            null,
                indicesServices,  
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");  
            randomBoolean(),
import static org.hamcrest.Matchers.nullValue;  
    public void testGetIndexNumberOfRoutingShardsYieldsSourceNumberOfShards() {
import org.opensearch.Version;  
                throw new AssertionError(ex);  
        validateRemoteCustomData(  
            .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        request.settings(Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, 4).build());
                                "type": "object",  
            )
            )
        assertNotNull(  
            .build();  
            error.getMessage(),
                indicesServices,  
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
            request,
        assertTrue("V1 result should contain field1", v1Properties.containsKey("field1"));
                routingNumberOfShards,
                assertEquals("numShards: " + randomNumShards, numRoutingShards / 2, randomNumShards);  
            threadPool,
            );
            Metadata metadata = mock(Metadata.class);
            + "   },\n"
    }
            null,  
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).nodes(nodes).build();  
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_INGESTION_SOURCE_PARTITION_STRATEGY, "simple").build();
        Map<String, Object> doc2 = new HashMap<>();  
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(newNode("node1")).build();
            new SystemIndices(Collections.emptyMap()),
    }  
        String template2 = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{\"field2\":{\"type\":\"keyword\"}}}}";  
 * the Apache License, Version 2.0 (the "License"); you may
        assertTrue(  
    }
                  "@fields": {  
            .nodes(DiscoveryNodes.builder().add(getRemoteNode()).build())  
            clusterState.metadata().index("sourceIndex"),
    public void testUpdatePluggableDataFormatSettingsNoopWhenFeatureFlagDisabled() {  
    }
                    put(1L, contextName);  
            .put("node.attr.remote_store.segment.repository", "my-segment-repo-1")
            + "    }\n"
        assertEquals(ReplicationType.DOCUMENT.toString(), indexSettings.get(SETTING_REPLICATION_TYPE));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
        // field_mapping with an unrecognized mapper_settings key — should fail  
        IndexTemplateMetadata templateMetadata = addMatchingTemplate(builder -> {  
                emptyList(),  
            Settings.builder()  
            randomBoolean(),
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).nodes(nodes).build();
            null,
            )
            .build();  
        when(clusterService.state()).thenReturn(clusterState);  
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING;  
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(newNode("node1")).build();
            null,
                Template template = checkerService.applyContext(request, mockState, allMappings, settingsBuilder);  
import static org.opensearch.common.util.FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG;
        );
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
                    createClusterState("source", 3, randomIntBetween(0, 10), Settings.builder().put("index.blocks.write", true).build()),
            + "        \"type\": \"text\",\n"  
        return attributes;  
            assertWarnings(  
            request,  
            targetShards = randomIntBetween(1, numShards / 2);  
            NamedXContentRegistry.EMPTY
            Settings.EMPTY,  
                null,  
        );
        validateV1V2Equivalence(  
                new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),  
            ).getMessage()
        // Should NOT throw — index matches allowlist
        );
        // Even setting the default value (simple) explicitly should pass on current-version cluster
        long afterCreation = System.currentTimeMillis();
                repositoriesServiceSupplier
            Settings.EMPTY,  
        validateV1V2Equivalence(  
            );
        });
        requestSettings.put(INDEX_REFRESH_INTERVAL_SETTING.getKey(), indexRefreshTime);
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).nodes(nodes).build();
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
        assertNull(remoteCustomData.get(PathHashAlgorithm.NAME));  
                    false,
            thrown.getCause().getMessage().contains(expectedError)
        Map<String, Object> field2 = (Map<String, Object>) properties.get("field2");  
        request.resizeType(ResizeType.SPLIT);
        final Settings.Builder requestSettings = Settings.builder()
        Map<String, String> missingTranslogAttribute = Map.of(
                    "source",
                null,
            clusterService,  
    public static boolean isSplitable(int source, int target) {  
            request,
import static org.hamcrest.Matchers.notNullValue;
            new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE))
            } catch (IOException e) {
            PathType.NAME,  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            Collections.emptySet(),
        assertFalse(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.exists(out));
            indexSettings,
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,  
            clusterSettings  
        validateV1V2Equivalence(Collections.emptyList(), "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{}}}");
            createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
    private static Map<String, String> getSegmentsOnlyNodeAttributes() {
        Settings settings = Settings.builder().put(CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING.getKey(), true).build();
                repositoriesServiceSupplier
        runPrepareResizeIndexSettingsTest(indexSettingsBuilder.build(), Settings.EMPTY, emptyList(), randomBoolean(), settings -> {
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            request,
            } else {
            0,
        aliasValidator = new AliasValidator();  
            "the number of target shards [10] must be less that the number of source shards [5]",
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
 * You may obtain a copy of the License at  
            .put(IndicesService.CLUSTER_RESTRICT_PLUGGABLE_DATAFORMAT_SETTING.getKey(), true)  
                    .put(
        assertEquals(  
    }  
        // create one that won't fail
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
            settings -> assertThat("similarity settings are not overwritten", settings.get("index.similarity.sim.type"), equalTo("DFR"))  
            null,  
            clusterSettings
                .put("index.merge.scheduler.max_thread_count", maxThreadCount)  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
            clusterSettings  
        MetadataCreateIndexService.updatePluggableDataFormatSettings(indexSettingsBuilder, cs, "test-index");
            }  
            request,  
        // For V2, find the disable_objects value from any mapping that has it
                )
                .build();
    private void validateRemoteCustomData(Map<String, String> customData, String expectedKey, String expectedValue) {
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
                MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
                Settings.EMPTY,
        TimeValue indexRefreshTime = TimeValue.timeValueMillis(clusterMinRefreshTimeMs + randomNonNegativeLong());
        // non-remote cluster manager node  
        ).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
        Settings indexSettings = aggregateIndexSettings(
                    "type": "object",
            .build();  
        }
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
        ClusterSettings clusterSettings = new ClusterSettings(forceClusterSettingEnabled, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    public void testIndexTotalPrimaryShardsPerNodeSettingValidationWithDefaultValue() {  
                null,
        IndexMetadata indexMetadata = buildIndexMetadata(
        MetadataCreateIndexService.validateIngestionSourceSettings(settings, state);
            Object mappingDisableObjects = extractDisableObjectsValue(mapping);
            InvalidIndexNameException.class,  
            null,
    }
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.STRICT)
            null,  
        );
            }
            );  
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
                return new CompressedXContent(s);  
        // Verify error message
        }));
        Settings.Builder indexSettingsBuilder = Settings.builder().put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "lucene");
        List<Map<String, Object>> v2ResultList2 = MetadataCreateIndexService.collectV2Mappings(  
        );
    }  
            sourceIndexMetadata,
            "test-index"  
                assertEquals("log_byte_size", settingsBuilder.get(INDEX_MERGE_POLICY.getKey()));
            .build();  
        assertNull(remoteCustomData.get(IndexMetadata.REMOTE_STORE_SSE_ENABLED_INDEX_KEY));
        Map<String, Object> field1 = (Map<String, Object>) properties.get("field1");
        // Test 4: Template has disable_objects, request doesn't - template value should be applied
        MetadataCreateIndexService.updateRemoteStoreSettings(
import org.opensearch.index.translog.Translog;
            .routingTable(routingTable)  
                Settings.EMPTY,
    public void testGetIndexNumberOfRoutingShardsWhenExplicitlySetToNull() {
            ).getMessage()
     * A segments-only index should use the cluster's configured remote store path type rather than falling back to
            ).getMessage()  
        assertEquals(
                ClusterState.EMPTY_STATE,
        );  
        checkerService.addRemoteStoreCustomMetadata(imdBuilder, true, clusterState);
            "target",
        request.mappings(createMapping("mapping_from_request", "text").string());  
            () -> MetadataCreateIndexService.validateIngestionSourceSettings(settings, state)
        assertFalse("No disable_objects should be added", resultDoc3.containsKey("disable_objects"));
            randomShardLimitService(),
        Map<String, Object> mappings = parseV1Mappings("", Collections.singletonList(templateMetadata.mappings()), xContentRegistry());
            assertFalse(checkerService.validateDotIndex(".test2", true));  
            Object v2DisableObjects = extractDisableObjectsValue(mapping);
            request,
            ValidationException validationException = expectThrows(
        assertEquals(Long.toString(customCreationDate), aggregatedSettings.get(IndexMetadata.SETTING_CREATION_DATE));
            Settings.EMPTY,
    private void validateIndexName(MetadataCreateIndexService metadataCreateIndexService, String indexName, String errorMessage) {
        request.settings(requestSettings.build());  
        settings = Settings.builder()  
        assertNotNull(remoteCustomData);
        assertThat(aggregatedIndexSettings.get("requestSetting"), is("requestValue"));
        clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        ).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
            Collections.emptySet(),
                finalClusterState,  
        MetadataCreateIndexService.updatePluggableDataFormatSettings(indexSettingsBuilder, cs, "test-index");
            when(metadata.systemTemplatesLookup()).thenReturn(Map.of(contextName, new TreeMap<>() {
        }
        );
        Map<String, Object> multipleResult = MetadataCreateIndexService.parseV1Mappings("", multipleTemplates, NamedXContentRegistry.EMPTY);  
import org.opensearch.common.settings.ClusterSettings;
        BlobStore blobStoreMock = mock(BlobStore.class);
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            requestMapping,
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
                    "properties": {
        // Use DOCUMENT replication type setting for index creation
            + "    \"properties\": {\n"
            @Override
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,  
        final Settings.Builder requestSettings = Settings.builder();  
        assertNotNull(imdBuilder.build().getCustomData());  
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");  
            .put(INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)  
        Map<String, Object> mappingsProperties = (Map<String, Object>) doc.get("properties");
            () -> aggregateIndexSettings(  
                }
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            .put(CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING.getKey(), false)
            {  
        } finally {
        );  
        final IllegalArgumentException error = expectThrows(IllegalArgumentException.class, () -> {  
        Settings.Builder indexSettingsBuilder = Settings.builder();
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
        Map<String, Object> properties = (Map<String, Object>) doc.get("properties");
                true,  
        Settings nodeSettings = Settings.builder().put(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey(), 0).build();  
            repositoriesServiceSupplier
        assertEquals(
        Settings settings = Settings.builder().put(CLUSTER_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT).build();
    private IndexTemplateMetadata addMatchingTemplate(Consumer<IndexTemplateMetadata.Builder> configurator) {
        when(repositoryMock.blobStore()).thenReturn(mock(BlobStore.class));
        // Serialize result to JSON and compare against expected merged output
            .put("index.ingestion_source.mapper_settings.id_feild", "user_id")  
            + "      \"index.codec\": \"best_compression\",\n"  
        metaBuilder.put(indexMetadata, false);
            Settings.builder().put("index.soft_deletes.enabled", "false").build(),
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,  
        // now we start the shard
    // ---- source_partition_strategy validation tests ----
            Collections.emptySet(),
import java.util.Set;  
            Settings.EMPTY,  
            randomShardLimitService(),
    }  
        );
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
                indicesServices,
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test").context(new Context(randomAlphaOfLength(5)));  
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "rack.values", "c, d, e")  
        assertThat("Should have dotted field names", properties, hasKey("cpu.usage"));  
        Settings clusterBag = Settings.builder()
            new HashMap<>(),
            // Check non-system hidden indices don't trigger a warning
        }  
                            .numberOfReplicas(0)
        );  
        when(clusterService.getSettings()).thenReturn(settings);
                null,
            + MapperService.SINGLE_MAPPING_NAME  
        IndexMetadata indexMetadata = testRemoteCustomData(false, randomFrom(PathType.values()));
            final ClusterService clusterService = ClusterServiceUtils.createClusterService(threadPool);
        checkerService.addRemoteStoreCustomMetadata(imdBuilder, true, clusterState);
        // Verify the result  
        );
    }
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
    /**  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
                templateContent  
        when(repositoryMock.blobStore()).thenReturn(blobStoreMock);
            Settings.builder().put("index.blocks.write", true).build()  
        ClusterSettings finalClusterSettings = clusterSettings;
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);  
            );
                validationErrors.get(0),
            request,  
                new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
        Mockito.when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
    public void testRemoteStoreOverrideTranslogRepoIndexSettings() {
            + "  \""
                mock(Environment.class),
            indicesServices,
            .build();  
            templateMappings1,
            randomIntBetween(0, 10),
            Collections.emptySet(),
        assertTrue(exception.getCause().getMessage().contains(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey()));
            ClusterState.EMPTY_STATE,
        Settings.Builder indexSettingsBuilder = Settings.builder();  
    public void testTemplateNumberOfReplicasOverridesClusterDefault() {
import static org.opensearch.common.util.FeatureFlags.APPLICATION_BASED_CONFIGURATION_TEMPLATES;  
    }  
            request,  
                    Version.CURRENT
        requestSettings.put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT);
            IndexCreationException.class,  
    public void testUpdatePluggableDataFormatSettingsSkipsWhenIndexMatchesAllowlist() {  
    }
                      "userstate": { "type": "keyword" }
            });  
        List<CompressedXContent> mixedTemplates = Arrays.asList(  
        );  
            Collections.emptySet(),  
        Settings settings = Settings.builder()
        queryShardContext = new QueryShardContext(
            try {
            new CompressedXContent(logTemplate),  
        Settings settings = Settings.builder()  
        withTemporaryClusterService(((clusterService, threadPool) -> {  
        );
            request,  
            xContentRegistry()
            .build();
            + "    \"mappings\": {\n"
        Settings settings = Settings.builder()
                Collections.emptySet(),  
        );  
            request,  
    }
     * repository. updateRemoteStoreSettings selects the node to copy repository names from with
        return IndexTemplateMetadata.builder(name).patterns(singletonList(pattern));
    public void testValidateIngestionSourceSettingsPartitionStrategySimpleAlsoRejectedOnMixedCluster() {
        request.settings(matchingReplicationIndexSettings);
        // No source_partition_strategy in settings — validation should pass even on mixed cluster
            request,
            expectThrows(
        for (int i = 0; i < v2Result.size(); i++) {
                DefaultRemoteStoreSettings.INSTANCE,
            "my-translog-repo-1",  
            // Check NO deprecation warnings if we give the index name
                false,
            settings,
        Settings aggregated = aggregateIndexSettings(
        Map<String, Object> doc = (Map<String, Object>) result.get(MapperService.SINGLE_MAPPING_NAME);
    }  
        }
import java.util.Arrays;
            .build();
                    createClusterState("source", randomIntBetween(2, 100), randomIntBetween(0, 10), Settings.EMPTY),
            () -> null,
    public void testCreateIndexWithCustomCreationDateInFuture() {
            Settings.EMPTY,
        long futureCreationDate = System.currentTimeMillis() + TimeValue.timeValueDays(30).millis();
        Settings matching = Settings.builder()
                }  
                    "type",  
            Collections.emptySet(),  
            Arrays.asList(
            + "}\n";
            IllegalArgumentException.class,
            null,
    public void testApplyContext() throws IOException {
        request.aliases(singleton(new Alias(aliasName)));
    private CompressedXContent createMapping(String fieldName, String fieldType) {
        final Settings.Builder requestSettings = Settings.builder();  
            emptyList(),  
                IndexNotFoundException.class,
        request.settings(requestSettings.build());  
                );
                repositoriesServiceSupplier  
            MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
                false,
            DiscoveryNodeRole.BUILT_IN_ROLES,
        Settings nonMatchingReplicationIndexSettings = Settings.builder()
        // Request setting should take precedence over template
            ClusterState.EMPTY_STATE,
            .transientSettings(Settings.builder().put(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey(), 3).build())
        ClusterState state = createClusterState(
                xContentRegistry(),  
                .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.STRICT)
                        """
        indicesServices = mock(IndicesService.class);
            + "      \"properties\": {\n"
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
import static java.util.Collections.singleton;
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        // Set index setting refresh interval the same value as the cluster minimum refresh interval
        AllocationService service = new AllocationService(  
            .nodes(DiscoveryNodes.builder().add(remoteNode).build())
        }
            new BalancedShardsAllocator(Settings.EMPTY),  
            )
            false,  
            new Environment(Settings.builder().put("path.home", "dummy").build(), null),
            + "      \"message\": {\n"
                threadPool,  
        );  
            + "          \"service\": {\"type\": \"keyword\"}\n"
        Settings indexSettings = Settings.builder()
            settingsBuilder.build().getAsBoolean(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, false)
            Arrays.asList("{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{}}}"),
        long actualCreationDate = Long.parseLong(aggregatedSettings.get(IndexMetadata.SETTING_CREATION_DATE));  
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false)  
     */  
        String isRemoteSegmentEnabled,
            when(metadata.systemTemplatesLookup()).thenReturn(Map.of(contextName, new TreeMap<>() {
        indexMetadata = testRemoteCustomData(true, PathType.HASHED_PREFIX);  
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")  
            requestWithDisableObjects,  
                    """
        Settings aggregatedSettings = aggregateIndexSettings(
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test").context(new Context(contextName));
    }  
        // Test creating an index with a custom creation_date in the future  
            settings.put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), between(1, 128) + "mb");  
            request,  
                        SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY  
        );  
            new SystemIndices(Collections.emptyMap()),
    public void testUpdatePluggableDataFormatSettingsStampsBuiltInDefaultsWhenClusterBagEmpty() {
            );
        // the REST layer reports it the same way as the built-in validateErrors path does.
        );
        );
    }
                v2DisableObjects = mappingDisableObjects;
import static org.opensearch.indices.ShardLimitValidatorTests.createTestShardLimitService;
            .settings(settings(Version.CURRENT).put(SETTING_READ_ONLY, true))
        configurator.accept(builder);  
        IllegalArgumentException exception = assertThrows(
    }
        );
    }  
            .numberOfReplicas(0)  
                new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
        ClusterSettings strictClusterSettings = new ClusterSettings(
        TimeValue translogBufferInterval  
        );  
            clusterSettings  
            + "  \"version\": 1\n"
        );  
            randomShardLimitService(),
            null,
import static org.opensearch.cluster.metadata.MetadataCreateIndexService.parseV1Mappings;  
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        final boolean copySettings,
        // Test with null mapping  
        when(blobStoreMock.isBlobMetadataEnabled()).thenReturn(randomBoolean());
        Map<String, Object> mapping1 = new HashMap<>();
            IllegalArgumentException.class,
        clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        // After override processing, all mappings with _doc sections should have the same value
                ClusterState.EMPTY_STATE,
                XContentParser expectedParser = JsonXContent.jsonXContent.createParser(
            + "  },\n"
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
                + MapperService.SINGLE_MAPPING_NAME
            clusterService,
                validationErrors.get(0),
        request.settings(Settings.EMPTY);
            .build();
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertEquals("Should have 3 mappings", 3, mixedResult.size());  
            new TestGatewayAllocator(),  
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a, b")
            null,
        Map<String, Object> v1Doc = (Map<String, Object>) v1Result.get(MapperService.SINGLE_MAPPING_NAME);  
            assertTrue(checkerService.validateDotIndex(".test", false));  
        Settings indexSettings,
            null,  
            null,
            builder -> builder.putAlias(AliasMetadata.builder("alias").searchRouting("fromTemplate").build())
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
import static org.opensearch.cluster.metadata.MetadataCreateIndexService.buildIndexMetadata;  
            xContentRegistry(),
            xContentRegistry(),
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_INGESTION_SOURCE_PARTITION_STRATEGY, "modulo").build();  
            new CompressedXContent("{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":true,\"properties\":{}}}")
                );
            Collections.emptySet(),  
            new TestGatewayAllocator(),
    public void testIndexSettingOverridesClusterReplicationSetting() {  
            .build();
            + "      }\n"  
            false,  
import org.opensearch.index.IndexModule;  
            new AwarenessReplicaBalance(settings, clusterService.getClusterSettings()),
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,  
        Metadata metadata = new Metadata.Builder().persistentSettings(
        MetadataCreateIndexService.updatePluggableDataFormatSettings(indexSettingsBuilder, cs, ".system-test");
            ClusterState.EMPTY_STATE,
import org.opensearch.common.xcontent.XContentFactory;
        attributes.put(REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, "my-segment-repo-1");  
    }
        );
        ) {
        }  
        attributes.put(REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "my-cluster-rep-1");  
            public Settings getAdditionalIndexSettings(String indexName, boolean isDataStreamIndex, Settings templateAndRequestSettings) {  
                ClusterState.EMPTY_STATE,
                threadPool,  
        assertEquals("false", finalCustomData.get(IndexMetadata.REMOTE_STORE_SSE_ENABLED_INDEX_KEY));  
        requestSettings.put(IndexMetadata.SETTING_CREATION_DATE, negativeCreationDate);
            DefaultRemoteStoreSettings.INSTANCE,
            Collections.emptySet(),
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        ) {
        DiscoveryNode oldNode = new DiscoveryNode("old_node", buildNewFakeTransportAddress(), emptyMap(), roles, Version.V_3_5_0);
        Settings out = indexSettingsBuilder.build();
    private CreateIndexClusterStateUpdateRequest request;
        // the default 'simple') should be rejected if the cluster has nodes < V_3_7_0 — otherwise  
import org.opensearch.common.unit.TimeValue;
            createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        doc3.put("properties", new HashMap<>());  
        );
        Metadata metadata = Metadata.builder()
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
                clusterService,
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        // verify that the message is as expected
        try {
                request,  
        assertEquals("V1 should preserve request mapping disable_objects=true", true, v1DisableObjects1);
                + "and [index.translog.retention.size] are deprecated and effectively ignored. They will be removed in a future version."
        // similarity settings from the request are not overwritten  
            ""  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        // Test 3: Mixed scenario - some templates with disable_objects, some without
            "index.non_copyable.existing",
                randomShardLimitService(),
        requestSettings.put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        Settings aggregatedSettings = aggregateIndexSettings(
            Setting.Property.NotCopyableOnResize  
        Settings clusterBag = Settings.builder()  
        + REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;  
        Map<String, Object> doc = (Map<String, Object>) parsedMappings.get(MapperService.SINGLE_MAPPING_NAME);
            assertThat(settings.get("index.soft_deletes.enabled"), equalTo("true"));  
            .put("index.ingestion_source.mapper_settings.op_type_field.delete_value", "REMOVE")  
        // Enforce cluster level replication type setting
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
            clusterState,  
        // Template 2 (order 1): field2 with type=text, store=false  
                null,
        final Consumer<Settings> consumer
    /**  
            + "    \"_version\": 1\n"
            "index source must have all shards allocated on the same node to shrink index",  
        assertEquals("my-segment-repo-1", indexSettings.get(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY));
        );
        Settings settings = Settings.builder()  
            ).getMessage()
    public void testAsyncDurabilityThrowsExceptionWhenRestrictSettingTrue() {
            Settings.EMPTY,
        Settings settings = Settings.builder()
            Collections.emptySet(),
    public void testAggregateIndexSettingsIndexReplicaIsSetToNull() {
        List<Map<String, Object>> allMappings = new ArrayList<>();
        final String[] invalidAliasNames = new String[] { "-alias1", "+alias2", "_alias3", "a#lias", "al:ias", ".", ".." };  
        );
import static org.opensearch.indices.IndicesService.CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING;  
            + "        \"properties\": {\n"  
        Object v1DisableObjects = extractDisableObjectsValue(v1Result);
    }
        ) {
            null,
            .numberOfShards(1)  
            PathType.HASHED_PREFIX,  
        clusterSettings = new ClusterSettings(clusterSettingsSetting, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        final MetadataCreateIndexService checkerService = new MetadataCreateIndexService(  
    public void testRefreshIntervalValidationWithNoIndexSetting() {
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");  
            .put("index.ingestion_source.mapper_settings.op_type_field.delete_value", "true")
    }
            targetRoutingNumberOfShards,
                    + "\":{\"disable_objects\":true,\"properties\":{\"field2\":{\"type\":\"keyword\"}}}}"
            MetadataCreateIndexService checkerService = new MetadataCreateIndexService(  
            .put(INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.getKey(), nullValue)  
        }));
 * The OpenSearch Contributors require contributions made to  
            {
                + v1DisableObjects  
                clusterService,
            repositoriesServiceSupplier  
                "{\""  
                null,
                request,
        // All nodes on current version with valid mapper_settings — should pass
        Map<String, Object> result = MetadataCreateIndexService.parseV1Mappings("", templates, NamedXContentRegistry.EMPTY);
            .nodes(DiscoveryNodes.builder().add(remoteNode).build())  
        DiscoveryNode remoteNode = new DiscoveryNode(
                new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
    }
    }
        final Set<DiscoveryNodeRole> roles = Collections.unmodifiableSet(
    }
            ClusterState.EMPTY_STATE,
    }  
                null,
        assertEquals(remoteTranslogRepo, indexSettings.get(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY));
    public void setupCreateIndexRequestAndAliasValidator() {
            null,  
import org.opensearch.node.remotestore.RemoteStoreNodeService;
            exception.getMessage()
                )  
        String requestMapping1 = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":true,\"properties\":{}}}";  
            DefaultRemoteStoreSettings.INSTANCE,
            new AllocationDeciders(singleton(new MaxRetryAllocationDecider())),
 * this file be licensed under the Apache-2.0 license or a
        // Test 2: Multiple templates with different disable_objects values  
            ClusterState.EMPTY_STATE,  
    public void testBuildIndexMetadata() {  
        );
        Map<String, Object> parsedMappings = MetadataCreateIndexService.parseV1Mappings(
    public void testUpdatePluggableDataFormatSettingsSkipsValueWhenAlreadySet() {  
            containsString(
            expectThrows(
        );
        ClusterService clusterService = mock(ClusterService.class);
                clusterService,
import static org.opensearch.indices.IndicesService.CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING;
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,  
            ).getMessage()  
import java.io.IOException;  
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
            Version.CURRENT  
        );
        final Settings.Builder requestSettings = Settings.builder();
        ThreadPool threadPool = new TestThreadPool(getTestName());
        when(repositoryMock.blobStore()).thenReturn(mock(BlobStore.class));  
            IndexCreationException.class,
            Settings.EMPTY,  
            new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE))
        // Cluster level replication type setting not enforced
        systemIndexDescriptors.add(new SystemIndexDescriptor(".test3", "test"));
        Map<String, Object> mappingsProperties = (Map<String, Object>) doc.get("properties");  
                        .endObject()
            Version.CURRENT
            settings,  
                Settings.EMPTY,
            } catch (IOException e) {
        IllegalArgumentException e = expectThrows(  
            xContentRegistry()
            "target",
            new AllocationDeciders(singleton(new MaxRetryAllocationDecider())),
            .build();
            MetadataCreateIndexService checkerService = new MetadataCreateIndexService(  
                assertEquals(2, allMappings.size());  
        mappings.put("_doc", "\"properties\": { \"field1\": {\"type\": \"text\"}}");  
            request,  
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT.toString());
            null,  
                    Settings.builder().put("index.number_of_shards", 5).build()
        );
            + MapperService.SINGLE_MAPPING_NAME  
 *  
        assertTrue(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(out));
import static org.opensearch.cluster.metadata.MetadataCreateIndexService.aggregateIndexSettings;
import org.opensearch.core.xcontent.XContentParser;
    }  
        );  
            InvalidAliasNameException.class,
            PathHashAlgorithm.FNV_1A_COMPOSITE_1.name()  
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)  
import static org.opensearch.index.IndexSettings.INDEX_SOFT_DELETES_SETTING;
        assertTrue("Log template should have level", logProperties.containsKey("level"));
        AllocationService service = new AllocationService(
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
        assertEquals(Long.toString(requestCreationDate), aggregatedSettings.get(IndexMetadata.SETTING_CREATION_DATE));
        );
        assertTrue("index should be remote-backed for segments", indexSettings.getAsBoolean(SETTING_REMOTE_STORE_ENABLED, false));  
            clusterStateWithSegmentsOnlyNode(),  
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");  
            settingsBuilder.put(NODE_ATTRIBUTES.getKey() + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "test");  
        Map<String, String> attributes = getNodeAttributes();  
 * license agreements. See the NOTICE file distributed with
            null,
        ClusterSettings clusterSettings = new ClusterSettings(nodeSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            .build();
            null,  
        );
    public void testRefreshIntervalValidationFailureWithIndexSetting() {
            }
            null,
        String template3b = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":true,\"properties\":{}}}";
        Settings settings = Settings.builder()
            Map<String, Object> doc = (Map<String, Object>) mapping.get(MapperService.SINGLE_MAPPING_NAME);  
        if (remoteStoreEnabled) {  
        // Test case 3: Template with empty mapping content  
            assertEquals("V2 should apply request mapping disable_objects=false to all mappings", false, v2DisableObjects);
            .build();
                DefaultRemoteStoreSettings.INSTANCE,
                cs
        validateV1V2Equivalence(
            List<String> validationErrors = checkerService.getIndexSettingsValidationErrors(settings, false, Optional.empty());
    public void testAnyTranslogDurabilityWhenRestrictSettingFalse() {
    public void testGetIndexNumberOfRoutingShardsWhenExplicitlyConfigured() {
            Settings.EMPTY,
            .put(RemoteStoreSettings.CLUSTER_SERVER_SIDE_ENCRYPTION_ENABLED.getKey(), true)  
            .put(INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.getKey(), nullValue)
        Settings aggregatedSettings = aggregateIndexSettings(
 * Licensed to Elasticsearch under one or more contributor  
        IllegalArgumentException e = expectThrows(
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;
        assertThat(aggregatedIndexSettings.get(SETTING_NUMBER_OF_REPLICAS), equalTo("1"));
              "_doc": {
     */
import org.opensearch.cluster.routing.RoutingTable;
                    UUIDs.base64UUID(),
            // Enable remote store  
            Settings.EMPTY,
            """);
        });  
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
public class MetadataCreateIndexServiceTests extends OpenSearchTestCase {
            .build();
    // ---- validatePluggableDataFormatSettings tests ----
                .endObject()
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY;  
        when(repositoryMock.isSeverSideEncryptionEnabled()).thenReturn(false);
                {
            .put(IndexMetadata.SETTING_INGESTION_SOURCE_MAPPER_TYPE, "field_mapping")
        when(repositoriesService.repository(Mockito.any())).thenReturn(repositoryMock);
        Map<String, Object> multipleDoc = (Map<String, Object>) multipleResult.get(MapperService.SINGLE_MAPPING_NAME);
        assertThat(updatedClusterState.blocks().getIndexBlockWithId("test", INDEX_READ_ONLY_BLOCK.id()), is(INDEX_READ_ONLY_BLOCK));
        assertEquals(
                    + "names starting with a dot are reserved for hidden indices and system indices"
        assertTrue(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.exists(out));
            + "      \"metric_name\": {\"type\": \"keyword\"},\n"
            return null;
import static org.hamcrest.Matchers.endsWith;  
    }
        withTemporaryClusterService((clusterService, threadPool) -> {
    }
            Collections.emptySet(),  
                    + MapperService.SINGLE_MAPPING_NAME
        assertEquals(
            .transientSettings(Settings.builder().put(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey(), 1).build())
            null,
        IndexMetadata sourceIndexMetadata = IndexMetadata.builder("parent")
        // Template defines @fields as dynamic object
        Settings settings = Settings.builder()  
        Settings settings = Settings.builder()  
            request,  
                .settings(Settings.builder().put("templateSetting", "templateValue"))
            repositoriesServiceSupplier
            IndexCreationException.class,
                DefaultRemoteStoreSettings.INSTANCE,
            containsString("Cluster is migrating to remote store but remote translog is not configured, failing index creation")
        validateRemoteCustomData(remoteCustomData, PathType.NAME, PathType.FIXED.name());
        int targetShards;  
        );
            clusterSettings  
        );  
                Settings.EMPTY,  
                settings.get("index.analysis.analyzer.default.tokenizer"),
    public void testValidateShrinkIndex() {  
            clusterSettings,  
    private static final String translogRepositoryNameAttributeKey = NODE_ATTRIBUTES.getKey()
        requestSettings.put(SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT);
        assertTrue(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(out));
        Map<String, String> attributes = getNodeAttributes();
            null,
            Settings.EMPTY,  
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
            true,
            request,
            null,  
            templateMetadata.settings(),
            .nodes(DiscoveryNodes.builder().add(remoteNode).build())  
    public void testPrepareResizeIndexSettingsAnalysisSettings() {
     * Covers: collectV2Mappings with override logic, multiple templates, request mapping priority.  
            Settings.EMPTY,
            + "}";  
        // a forbidden index-level override by throwing IndexCreationException wrapping a  
        List<Map<String, Object>> v2ResultList1 = MetadataCreateIndexService.collectV2Mappings(  
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone, rack")
            ).getMessage()
                DeprecationHandler.IGNORE_DEPRECATIONS,
            queryShardContext
            .put("index.routing.allocation.require._name", "node1")
        );  
            Arrays.asList("{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":true,\"properties\":{}}}"),
        // This checks that aggregateIndexSettings throws exception for the case when the index setting
        IllegalArgumentException e = expectThrows(
            request,
        } while (isShrinkable(numShards, targetShards) == false);
            XContentParser contentParser = JsonXContent.jsonXContent.createParser(  
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
            .metadata(metadata)
            when(mockState.metadata()).thenReturn(metadata);  
    private ClusterSettings clusterSettings;
            randomShardLimitService(),  
            + "\": {\n"
        assertThat(aggregatedIndexSettings.get("template_setting"), equalTo("value1"));
        IndexTemplateMetadata.Builder builder = templateMetadataBuilder("template1", "te*");
import org.opensearch.env.Environment;
                builder -> builder.order(1)  
            Settings.EMPTY,
        when(clusterService.state()).thenReturn(clusterState);  
            + "  \"_meta\": {\n"  
            null,
                      "status": { "type": "keyword" }
        for (Map<String, Object> mapping : v2ResultList2) {  
        // field1 should be from template1 (only defined there)  
            .putAlias(AliasMetadata.builder("alias1").writeIndex(true).build())
        discoveryNodes = DiscoveryNodes.builder(discoveryNodes).add(remoteDataNode).localNodeId(remoteDataNode.getId()).build();  
import org.mockito.Mockito;
        assertEquals("Should have 2 mappings (1 template + 1 request)", 2, result4.size());
import org.opensearch.index.shard.IndexSettingProvider;  
        assertThat(alias.getSearchRouting(), equalTo("3"));  
            settings,  
            assertEquals("All mappings should have disable_objects=true from template", true, doc.get("disable_objects"));
    public void testAddRemoteStoreCustomMetadata() {
import org.opensearch.common.blobstore.BlobStore;
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();  
    }
        final String indexName = randomAlphaOfLength(10);
        Settings remoteStoreMigrationSettings = Settings.builder()
import java.util.function.BiConsumer;  
            + "\": {\n"  
    public void testRemoteCustomData() {  
        );
    private DiscoveryNode newNode(String nodeId) {
            """);
        if (mapping == null) {
        systemIndexDescriptors.add(new SystemIndexDescriptor(".test", "test"));  
            clusterSettings
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        Settings clusterSettingsSetting = Settings.builder()
            .build();
        String aliasName = randomFrom(invalidAliasNames);
            .build();
            request.settings(Settings.builder().put(INDEX_SOFT_DELETES_SETTING.getKey(), false).build());
     * settings to be dropped, breaking index creation for dynamic fields under @fields.
            + "          \"environment\": {\"type\": \"keyword\"},\n"
            settings,
            0,
                () -> MetadataCreateIndexService.validateShrinkIndex(state, "source", "target", targetSettings)  
            ClusterState.builder(ClusterName.DEFAULT).build(),
            null,  
            assertThat(  
            "test-index"
        String template1 = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":false,\"properties\":{}}}";
            copySettings,
            + "    }\n"
            .putList(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_RESTRICT_ALLOWLIST.getKey(), ".system", ".kibana")  
        // Test 5: Templates without disable_objects
            "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{\"field1\":{\"type\":\"text\"}}}}"
        InvalidIndexNameException e = expectThrows(
        );  
            numShards,
        Map<String, Object> doc = (Map<String, Object>) parsedMappings.get("_doc");
        // But template2 should win because it has higher order
    public void testValidateCloneIndex() {
        when(repositoriesService.repository(getRemoteStoreTranslogRepo(settings))).thenReturn(repositoryMock);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testCreateIndexWithoutCustomCreationDate() {
        Settings indexSettings = Settings.builder()
     * DiscoveryNode::isRemoteSegmentStoreNode, so a segments-only node qualifies as a donor even though it has no  
        request.settings(Settings.EMPTY);
                Settings.EMPTY,
        String resultJson = XContentFactory.jsonBuilder().map(result).toString();
        };
            // Set primary shards per node to valid value
                createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
import java.util.ArrayList;
            new IndexScopedSettings(Settings.EMPTY, settingsSet)
                ExceptionsHelper.reThrowIfNotNull(e);
        // This checks that aggregateIndexSetting works for the case where there are no index setting
            if (mappingDisableObjects != null) {  
                        """  
        final Settings.Builder requestSettings = Settings.builder();  
            ClusterState.EMPTY_STATE,  
                null,
        mappingWithoutDisableObjects.put(MapperService.SINGLE_MAPPING_NAME, docWithoutDisableObjects);
                throw new IndexCreationException(indexName, ve);  
                () -> MetadataCreateIndexService.validateShrinkIndex(  
                XContentParser expectedParser = JsonXContent.jsonXContent.createParser(
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        final Settings.Builder indexSettingsBuilder = Settings.builder()
                clusterSettings  
            .build();
            newIndexMetadata,  
            IllegalArgumentException.class,
        request.settings(requestSettings.build());  
        CompressedXContent template1 = new CompressedXContent(
            routingTableClusterState,  
                }
        clusterSettings = new ClusterSettings(forceClusterSettingDisabled, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":true,\"properties\":{}}}"  
                () -> clusterStateCreateIndex(currentClusterState, Set.of(), newIndex, (state, reason) -> state, null)
        MetadataCreateIndexService checkerService = new MetadataCreateIndexService(  
        });  
                    createClusterState("source", 10, 0, Settings.builder().put("index.blocks.write", true).build()),
                .putMapping("_doc", templateMapping)  
import org.opensearch.common.settings.IndexScopedSettings;
                )
                null,
    public void testIndexTotalPrimaryShardsPerNodeSettingValidationWithoutRemoteStore() {  
    }
        Settings aggregatedIndexSettings = aggregateIndexSettings(  
                + ", V2 result: "
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            clusterService,
        assertThat(
        CompressedXContent templateMapping = createMapping("test", "text");
            assertTrue(checkerService.validateDotIndex(".pattern-test", false));
    public void testExplicitNumberOfReplicasOverridesClusterDefault() {
            null,
        assertThat("The source index primary term must be used", indexMetadata.primaryTerm(0), is(3L));
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            Arrays.asList(
                .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 2)
            DiscoveryNodeRole.BUILT_IN_ROLES,  
            addMatchingTemplate(
                + "\"field1\":{\"type\":\"text\",\"store\":true},"
        );
        Map<String, String> attributes = getNodeAttributes();  
              "_doc": {
        int clusterMinRefreshTimeMs = 10 * 1000;
            aliasValidator,  
                "properties": {  
import static org.opensearch.cluster.metadata.MetadataCreateIndexService.clusterStateCreateIndex;
                )  
        List<Map<String, Object>> nullMappings = new ArrayList<>();
                ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).build()  
                        .field("type", "long")
            assertThat("similarity settings must be copied", settings.get("index.similarity.default.type"), equalTo("BM25"));  
    }
        // Verify that the value is the same as set earlier and validation was successful
            .numberOfShards(1)  
        // Test with mapping without disable_objects  
            "my-translog-repo-1",  
            Map<String, Object> mapping = v2Result.get(i);
        Map<String, Object> mappingWithoutDisableObjects = new HashMap<>();
            .put("index.ingestion_source.mapper_settings.op_type_field", "action")
        Settings mismatch = Settings.builder()
        when(repositoriesService.repository(getRemoteStoreSegmentRepo(settings))).thenReturn(repositoryMock);
            )
    }
    }
    public void testFieldPropertyOverrideInParseV1Mappings() throws Exception {  
            AliasMetadata newAlias = indexMetadata.getAliases().values().iterator().next();
        assertThat(aggregatedIndexSettings.get("key1"), equalTo("requestValue"));
        FeatureFlags.TestUtils.with(APPLICATION_BASED_CONFIGURATION_TEMPLATES, false, () -> {
            null,
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertEquals(isRemoteSegmentEnabled, indexSettings.get(SETTING_REMOTE_STORE_ENABLED));  
            randomShardLimitService(),
            MetadataIndexTemplateService.resolveAliases(templates),
    public void testValidatePluggableDataFormatNoopWhenRestrictDisabled() {  
            final List<String> validationErrors = checkerService.getIndexSettingsValidationErrors(
        BlobStoreRepository repositoryMock = mock(BlobStoreRepository.class);
        );  
import org.opensearch.action.admin.indices.shrink.ResizeType;
            .persistentSettings(Settings.builder().put(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey(), 2).build())  
            Metadata metadata = mock(Metadata.class);
import org.opensearch.core.index.Index;
            Settings.EMPTY,
            .put("index.version.created", Version.CURRENT)  
        final Set<DiscoveryNodeRole> roles = Collections.unmodifiableSet(
        );
    }
                indicesServices,
            .build();  
        );  
        ThreadPool threadPool = new TestThreadPool(getTestName());  
                              }
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING;
    public void testUpdateRemoteStoreSettingsForSegmentsOnlyNode() {  
    public void testClusterStateCreateIndexThrowsWriteIndexValidationException() throws Exception {
        Settings settings = Settings.builder()
        Metadata metadata = Metadata.builder()  
            () -> aggregateIndexSettings(
        assertEquals("test", thrown.getIndex().getName());
        );
import org.opensearch.indices.replication.common.ReplicationType;  
    @After
                    "source",  
        when(repositoriesService.repository(Mockito.any())).thenReturn(repositoryMock);  
            new TestGatewayAllocator(),
    }
                assertTrue("numShards: " + randomNumShards, randomNumShards < 513);  
        threadPool.shutdown();
            "no such index [no_such_index]",
                IndexNotFoundException.class,
                true,  
        validateRemoteCustomData(
                builder -> builder.order(2)
            + "  \""
        Settings mismatch = Settings.builder()  
            InvalidIndexContextException exception = expectThrows(
            buildNewFakeTransportAddress(),
        MetadataCreateIndexService.updatePluggableDataFormatSettings(indexSettingsBuilder, cs, ".system-index-1");  
                Settings.EMPTY,
            clusterSettings  
    }
    public void testUpdatePluggableDataFormatSettingsStampsWhenIndexDoesNotMatchAllowlist() {
        });
        );
        try {  
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
            + "\": {\n"  
            Setting.Property.NotCopyableOnResize
            + "        \"field1\": {\n"  
            null
            request,
            indexMetadata.getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY),
        String template2 = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":true,\"properties\":{}}}";
            Settings.EMPTY,
        when(blobStoreMock.isBlobMetadataEnabled()).thenReturn(randomBoolean());
        // is set to a value that is below the `cluster.default.index.refresh_interval` value.  
            .put(CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING.getKey(), true)
                  }
        request.aliases(Collections.singleton(new Alias("alias").searchRouting("fromRequest")));
        assertWarnings(
            .metadata(
            null,
            clusterSettings
        BlobStoreRepository repositoryMock = mock(BlobStoreRepository.class);  
        // Test case with default value (-1) without remote store (should succeed)
            Settings.builder().put("cluster.default_number_of_replicas", clusterDefaultReplicaNumber).build()
            .build();
 *     http://www.apache.org/licenses/LICENSE-2.0
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
        final Settings.Builder requestSettings = Settings.builder()
            );
        when(repositoryMock.blobStore()).thenReturn(blobStoreMock);
            "no such index [no_such_index]",  
        // Test 6: Complex scenario with multiple templates and properties
            .build();
            }  
        });
    public void testDefaultNumberOfReplicasUsesTransientSettingOverPersistentAndNodeSettings() {
        return builder.build();
        Settings nodeSettings = Settings.builder().put(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey(), 0).build();
            ClusterState.EMPTY_STATE,
            .build();
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
                break; // Found a disable_objects value, use it for comparison
            "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{}}",
            .put(IndexMetadata.SETTING_CREATION_DATE, customCreationDate)  
            Settings.EMPTY,
            randomShardLimitService(),
        Settings indexSettings = settingsBuilder.build();  
            Collections.emptySet(),
            "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":false,\"properties\":{}}}"
        );  
            createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),  
            ClusterState.EMPTY_STATE,
        Map<String, String> remoteCustomData = new HashMap<>();  
            .numberOfReplicas(0)
    }
            .metadata(Metadata.builder().put(existingWriteIndex, false).build())  
        );  
    }
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_REPLICATION_TYPE_SETTING;
            false,
        MetadataCreateIndexService checkerService = new MetadataCreateIndexService(  
            request.mappings(),  
        IllegalArgumentException exception = expectThrows(
        );
            indexSettings,
            randomShardLimitService(),
                cs
    }  
            Settings.EMPTY,
            request,  
    }
            error.getCause().getMessage(),
        );
            if (numRoutingShards <= 1024) {
            DiscoveryNodeRole.BUILT_IN_ROLES,
                    DeprecationHandler.THROW_UNSUPPORTED_OPERATION,  
            validateIndexName(checkerService, "-indexname", "must not start with '_', '-', or '+'");  
            request.index(),
            .putList(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_RESTRICT_ALLOWLIST.getKey(), ".system", ".kibana")
        docWithDisableObjects.put("properties", new HashMap<>());  
            .metadata(metadata)
            .put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), refreshInterval)  
        Object docObj = mapping.get(MapperService.SINGLE_MAPPING_NAME);
    }
        );
            clusterSettings  
        );  
            assertThat(settings.getAsVersion("index.version.created", null), equalTo(version));
                IllegalArgumentException.class,
        // Test case where setting is used with remote store enabled (should succeed)
                    .settings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 11))  
        request = new CreateIndexClusterStateUpdateRequest("create index", "test-index", "test-index");  
        });
    }  
            MetadataCreateIndexService checkerService = new MetadataCreateIndexService(  
        // Verify log template structure is preserved
            null,
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            .put(IndicesService.CLUSTER_RESTRICT_PLUGGABLE_DATAFORMAT_SETTING.getKey(), true)  
        assertEquals(
import java.util.Comparator;
        Settings indexSettings = aggregateIndexSettings(
            Collections.emptySet(),  
 *
                    "target",
        assertThat(e.getMessage(), endsWith(errorMessage));  
        assertNull("Should return null for null mapping", resultNullMapping);
            .putList(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_RESTRICT_ALLOWLIST.getKey(), ".system")
        assertEquals(error.getMessage(), "failed to create index [test-index]");
            .build();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        IndexCreationException exception = expectThrows(
        RoutingTable routingTable = service.reroute(clusterState, "reroute").routingTable();
            "source",
            null,
                randomShardLimitService(),
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.MIXED)
    public void testValidateIngestionSourceSettingsWithDefaultMapperType() {
    }  
        final RoutingTable routingTable = OpenSearchAllocationTestCase.startInitializingShardsAndReroute(
            "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{}}}"
        String template4 = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":true,\"properties\":{}}}";
            clusterSettings
            "source",  
        String templateWithDisableObjects = "{\""
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false)  
            null,
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        final AllocationService service = new AllocationService(
        Map<String, Object> v1Result1 = MetadataCreateIndexService.parseV1Mappings(requestMapping1, templateMappings1, xContentRegistry());
        List<CompressedXContent> templateMappings = Arrays.asList(new CompressedXContent(template1), new CompressedXContent(template2));
            IndexScopedSettings.BUILT_IN_INDEX_SETTINGS.stream(),
                + "\"properties\":{"  
                        .toString()  
                .put("index.non_copyable.existing", "existing")
                createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
        // Test 2: Request mapping with disable_objects overrides templates
        long customCreationDate = System.currentTimeMillis() - TimeValue.timeValueDays(30).millis();
        for (Map<String, Object> mapping : v2ResultList1) {  
    public void testDefaultSettings() {
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(newNode("node1")).add(oldNode).build();
            + "    \"_type\": \"@abc_template\",\n"
    }
            + "      \"tags\": {\n"
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test").context(new Context(randomAlphaOfLength(5)));  
        request.settings(mismatch);  
        assertNull(indexMetadata.getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY));  
            "source",
            "my-segment-repo-1",
        assertTrue(exception.getCause().getMessage().contains("cannot differ from cluster default"));  
        assertEquals(Translog.Durability.REQUEST, INDEX_TRANSLOG_DURABILITY_SETTING.get(indexSettings));  
            new CompressedXContent(templateWithoutDisableObjects),
    }  
    public void testUpdatePluggableDataFormatSettingsStampsClusterDefaultsWhenIndexLevelAbsent() {  
        final Settings.Builder requestSettings = Settings.builder();  
import org.opensearch.index.query.QueryShardContext;
            }
            .nodes(DiscoveryNodes.builder().add(remoteNode).build())
        List<CompressedXContent> templates = Arrays.asList(templateB, templateA);
                null,
            assertEquals("All mappings should have disable_objects=true", true, doc.get("disable_objects"));
            .build();
            createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
            EmptyClusterInfoService.INSTANCE,
            Map<String, Object> doc = (Map<String, Object>) mapping.get(MapperService.SINGLE_MAPPING_NAME);
                "Creating indices with soft-deletes disabled is no longer supported. "  
     * Utility method to extract the disable_objects value from a mapping.  
import org.opensearch.cluster.ClusterState;  
                false,
        final Settings.Builder requestSettings = Settings.builder();
            .build();
    public void testRefreshIntervalValidationSuccessWithIndexSettingEqualToClusterMinimum() {  
            .build();
            + "  }\n"  
            IndexMetadata myIndex = builder.get("my-index");
            .build();
                NamedXContentRegistry.EMPTY,  
import static org.hamcrest.Matchers.equalTo;
            cs  
            Map<String, Object> docMap = (Map<String, Object>) mapping.get(MapperService.SINGLE_MAPPING_NAME);
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(settings, clusterSettings);
                                "type": "object",  
            () -> aggregateIndexSettings(
            IllegalArgumentException.class,  
            templateSettings,
        if (randomBoolean()) {  
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
                repositoriesServiceSupplier
        // Template B is higher priority (first in list), Template A is lower priority (second in list)  
        List<AliasMetadata> resolvedAliases = resolveAndValidateAliases(
        request.settings(Settings.builder().putNull(SETTING_NUMBER_OF_REPLICAS).build());
            validateIndexName(checkerService, "+indexname", "must not start with '_', '-', or '+'");
                    DefaultRemoteStoreSettings.INSTANCE,  
    public void testV1V2DisableObjectsEquivalence() throws Exception {
        );
        } catch (IOException e) {
        assertEquals("Should have 3 mappings (2 templates + 1 request)", 3, v2Result.size());  
        final Settings.Builder requestSettings = Settings.builder();
        assertNull("no remote translog repository should be applied", indexSettings.get(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY));
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.getRemoteStoreTranslogRepo;
            repositoriesServiceSupplier  
            "invalid index.refresh_interval ["  
            assertTrue(1 < ratio);  
        );
        Object v1DisableObjects2 = extractDisableObjectsValue(v1Result2);  
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;  
        when(repositoriesService.repository(getRemoteStoreTranslogRepo(settings))).thenReturn(repositoryMock);  
                                  "status": { "type": "keyword" }
                () -> MetadataCreateIndexService.validateSplitIndex(state, "target", "source", targetSettings)  
        BlobStoreRepository repositoryMock = mock(BlobStoreRepository.class);
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
            indexSettings,  
     */  
        List<CompressedXContent> templateMappings2 = Arrays.asList(  
                mock(Environment.class),
                new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
        assertEquals(1024, MetadataCreateIndexService.calculateNumRoutingShards(1, Version.CURRENT));
                    .putAlias(AliasMetadata.builder("alias1").searchRouting("1").build())
        request.settings(requestSettings.build());
                    "type": "object",
        );
        // source_partition_strategy explicitly set on a current-version cluster — should pass
        );  
import static java.util.Collections.emptyMap;
            UUIDs.base64UUID(),  
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false)  
                        .startObject()
                .endObject()  
        // source_partition_strategy setting key was introduced in V_3_7_0. Any explicit value (including
            Settings.EMPTY,
        doc1.put("disable_objects", false);  
import org.opensearch.index.remote.RemoteStoreEnums.PathHashAlgorithm;  
                        IndexMetadata.builder("my-index")
        DiscoveryNode remoteNode = new DiscoveryNode(
            try {
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
import org.opensearch.cluster.routing.allocation.AllocationService;
        IndexMetadata.Builder imdBuilder = IndexMetadata.builder("test").settings(indexSettings);
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).nodes(nodes).build();  
            .add(nonRemoteClusterManagerNode)
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        assertThat(aggregatedIndexSettings.get("request_setting"), equalTo("value2"));
    }  
            validateIndexName(  
            templateMappings,  
        requestSettings.put(INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), durability);
            + "  \"_meta\": {\n"  
        // Test creating an index with a custom creation_date in the past  
        int targetRoutingNumberOfShards = getIndexNumberOfRoutingShards(indexSettings, null);
        request.settings(requestSettings.build());  
        when(repositoriesServiceSupplier.get()).thenReturn(repositoriesService);  
        // analysis settings from the request are not overwritten
            Settings.EMPTY,
        for (int i = 0; i < 1000; i++) {
                request.aliases(),
            .transientSettings(Settings.builder().put(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey(), 1).build())
        templates.add(  
        nullMappings.add(null);
        Settings out = indexSettingsBuilder.build();  
            expectThrows(
        ClusterState currentClusterState = ClusterState.builder(ClusterState.EMPTY_STATE).build();
        }
            "the number of source shards [3] must be a factor of [4]",  
        when(repositoriesService.repository(Mockito.any())).thenReturn(repositoryMock);
                null,
            new BalancedShardsAllocator(Settings.EMPTY),  
            .put(CLUSTER_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
 */
            Settings.EMPTY,
    }
                clusterService,  
                + "]: cannot be smaller than cluster.minimum.index.refresh_interval [10s]",
            clusterState,
            assertEquals("All mappings should have disable_objects=true after override", true, doc.get("disable_objects"));
                Settings.EMPTY,
            () -> aggregateIndexSettings(  
        templates.add(
        assertEquals(durability, INDEX_TRANSLOG_DURABILITY_SETTING.get(indexSettings));
                IllegalArgumentException.class,  
    }  
            new SystemIndices(Collections.emptyMap()),  
import org.opensearch.cluster.EmptyClusterInfoService;
        requestSettings.put(INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.REQUEST);
                "Invalid exception message." + exception.getMessage(),
                request,  
            Settings.EMPTY,  
            clusterState,
            Collections.emptySet(),  
        request.settings(mismatch);
            EmptySnapshotsInfoService.INSTANCE  
            randomShardLimitService(),  
        Settings clusterBag = Settings.builder()
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT.toString());
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            ),  
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
                    null,  
            new AllocationDeciders(singleton(new MaxRetryAllocationDecider())),
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(newNode("node1")).build();  
                    assertEquals(
                InvalidIndexContextException.class,  
        );  
            );
                    () -> checkerService.validateContext(request)  
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).nodes(nodes).build();  
            request,
    /**  
            assertFalse(checkerService.validateDotIndex(".test2", false));
            clusterSettings
            int randomNumShards = randomIntBetween(1, 10000);  
                .field("type", fieldType)  
        assertFalse(clusterSettings.get(IndicesService.CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING));
        assertThat(  
        assertThat(  
                builder.putMapping("type", "{\"type\":{\"properties\":{\"field\":{\"type\":\"keyword\"}}}}");
            );  
    }  
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)  
            when(mockState.metadata()).thenReturn(metadata);  
        List<IndexTemplateMetadata> templates = new ArrayList<>(3);
            when(metadata.componentTemplates()).thenReturn(Map.of(contextName, componentTemplate.get()));  
            try {
                  }
            null,  
                "properties": {
        assertTrue(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.exists(out));
    @Before
            .build();  
        ClusterService clusterService = mock(ClusterService.class);
        // Simulates a plugin-supplied IndexSettingProvider (like CompositeDataFormatPlugin) rejecting
        );
                null,  
        assertFalse(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(out));
            createClusterState(
                indicesServices,
    }  
                .startObject(MapperService.SINGLE_MAPPING_NAME)  
            Settings.EMPTY,
            clusterSettings
    public void testCreateIndexWithCustomCreationDate() {
import org.opensearch.cluster.node.DiscoveryNodes;  
        };
            + "        }\n"
            assertTrue(checkerService.validateDotIndex(".pattern-test-other-suffix", false));  
                Settings.EMPTY,
        // even when a cluster-scope default is present.
    private Supplier<RepositoriesService> repositoriesServiceSupplier;
            request,
        List<CompressedXContent> templates = Collections.singletonList(template);
        RoutingTable routingTable = routingTableBuilder.build();  
                        "private index setting [%s] can not be set explicitly",
import org.opensearch.indices.IndicesService;
 */  
            + MapperService.SINGLE_MAPPING_NAME
        Settings mismatch = Settings.builder()
        return attributes;
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");  
    }  
            .put(sourceSettings)  
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_INGESTION_SOURCE_MAPPER_TYPE, "field_mapping").build();
    public void testDefaultNumberOfReplicasUsesPersistentSettingOverNodeSetting() {  
        IllegalArgumentException exception = assertThrows(
                () -> MetadataCreateIndexService.validateShrinkIndex(state, "no_such_index", "target", Settings.EMPTY)  
        );  
            "target",
        when(repositoriesServiceSupplier.get()).thenReturn(repositoriesService);
            null,  
        doc2.put("disable_objects", true);
        int numRoutingShards = settings.getAsInt(IndexMetadata.INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.getKey(), numShards);
        Map<String, Object> mappingWithDisableObjects = new HashMap<>();  
                request,
            UUIDs.base64UUID(),
            + "        }\n"  
                    targetSettings  
                + v2DisableObjects,
            );
        assertFalse(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(out));
    }
                Settings.EMPTY,
                    createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
            expectThrows(  
        );
        request.recoverFrom(new Index("sourceIndex", UUID.randomUUID().toString()));  
     * {@code SearchReplicaRestoreIT}. The stamp only ever needed a boolean, so it reads the raw value.  
        );
            new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
import org.opensearch.common.ValidationException;
        );  
import org.opensearch.cluster.node.DiscoveryNode;
        assertNotNull(finalCustomData);
            settings -> assertThat(settings.get("index.soft_deletes.enabled"), equalTo("true"))
            request,
        ).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();  
        Settings indexSettings = aggregateIndexSettings(
            clusterSettings
            .setRoutingNumShards(numRoutingShards)
            try {
            .build();
     */
        request.settings(Settings.builder().put("request_setting", "value2").build());
            .put("node.attr.remote_store.translog.repository", "my-translog-repo-1")
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")  
        for (Map<String, Object> mapping : mappings) {  
            ).getMessage(),
        String requestMapping = """
        Settings settings = Settings.builder()  
            new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE))
import org.opensearch.index.mapper.MapperService;
        assertNotEquals(ReplicationType.SEGMENT, clusterSettings.get(CLUSTER_REPLICATION_TYPE_SETTING));
            Settings.builder().put("index.soft_deletes.enabled", "true").build(),
                    targetSettings  
            + "      \"index.refresh_interval\": \"60s\"\n"  
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
            .numberOfReplicas(0)
            v1DisableObjects,  
            Collections.emptySet(),
            + "}";
            .metadata(metadata)
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            @SuppressWarnings("unchecked")
        requestSettings.put(IndexMetadata.SETTING_CREATION_DATE, customCreationDate);
                    DeprecationHandler.THROW_UNSUPPORTED_OPERATION,  
            randomShardLimitService(),  
        super.tearDown();  
            ClusterState.EMPTY_STATE,
                createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
            null,
            UUIDs.base64UUID(),
            ClusterState.EMPTY_STATE,  
        assertEquals("Basic template should have disable_objects=true", true, doc.get("disable_objects"));  
                DefaultRemoteStoreSettings.INSTANCE,  
            }  
        assertFalse("V1 should not add disable_objects when none are present", v1Doc.containsKey("disable_objects"));
                resultJson
            Version.CURRENT
            buildNewFakeTransportAddress(),  
        return new DiscoveryNode(
            null,  
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)  
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(newNode("node1")).build();
            .build();
            );
        indexMetadata = testRemoteCustomData(true, PathType.FIXED);  
        String segmentRepositoryName = "my-segment-repo-1";  
            expectThrows(  
            clusterSettings
                .put(INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.getKey(), routingNumberOfShards)
                indexName,
    }
import static org.mockito.Mockito.mock;
    }  
            .put("index.blocks.write", true)
        // check guards the setting KEY itself, regardless of value. Once any non-default strategy can
import java.util.stream.Collectors;
            indicesServices,
            Collections.emptySet(),
        withTemporaryClusterService(((clusterService, threadPool) -> {
            )
    public void testCalculateNumRoutingShards() {  
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,  
import org.opensearch.indices.SystemIndexDescriptor;
            ClusterState.EMPTY_STATE,
        when(blobStoreMock.isBlobMetadataEnabled()).thenReturn(randomBoolean());  
            }  
        // Verify that the value is the same as set as earlier and the validation was successful  
            + "  }\n"  
        int x = target / source;
                DefaultRemoteStoreSettings.INSTANCE,
        when(repositoryMock.blobStore()).thenReturn(blobStoreMock);
        // restrict=false — mismatching values are allowed.
                request,
            new IndexSettings(IndexMetadata.builder("test").settings(indexSettings).build(), indexSettings),  
        ClusterState currentClusterState = ClusterState.builder(ClusterState.EMPTY_STATE)
            clusterState,
            null,
            null
        Settings settings = Settings.builder()
            new SystemIndices(Collections.emptyMap()),  
            IllegalArgumentException.class,
            buildNewFakeTransportAddress(),  
                numShards,
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(newNode("node1")).add(oldNode).build();  
                    "target",
        List<Map<String, Object>> v2ResultList = MetadataCreateIndexService.collectV2Mappings(
        int numShards = randomIntBetween(1, 1000);  
                assertEquals(mappings, allMappings.get(0));
        String remoteSegmentRepo,  
            }
        Settings.Builder indexSettingsBuilder = Settings.builder();
            MetadataIndexTemplateService.resolveAliases(Collections.singletonList(templateMetadata)),
                null,
        assertEquals(
                        .field("disable_objects", true)
            settings,  
        Settings aggregatedSettings = aggregateIndexSettings(
                Metadata.builder()  
            "{\""  
            clusterSettings
        request.settings(requestSettings.build());  
            new CompressedXContent("{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":false,\"properties\":{}}}")
            .put("index.soft_deletes.enabled", "true");
        expectThrows(
            () -> aggregateIndexSettings(  
              "_doc": {  
            request,
            request.mappings(),  
        // Should not throw  
            randomShardLimitService(),
    }
            threadPool,
        );  
                assertThat(settings.get("index.routing.allocation.require._name"), equalTo("node1"));
        assertTrue(e.getMessage().contains(Version.V_3_5_0.toString()));
            )
                + "\"properties\":{"
        request.settings(settings.build());
            null,
            request,
        }
            );
            .build();
        assertEquals(1024, MetadataCreateIndexService.calculateNumRoutingShards(2, Version.CURRENT));
        IndexMetadata newIndexMetadata = IndexMetadata.builder("test")
/*
        assertEquals(2048, MetadataCreateIndexService.calculateNumRoutingShards(1024, Version.CURRENT));  
            + "      \"custom_id\": {\"type\": \"keyword\"},\n"
        assertEquals("", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(out));
                clusterSettings  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;  
        remoteCustomData.put(IndexMetadata.REMOTE_STORE_SSE_ENABLED_INDEX_KEY, "false");
        // be set, older nodes that don't recognize the key would fall back to the default 1:1 mapping
    }
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
            "index source must block write operations to resize index. use \"index.blocks.write=true\"",
import java.util.Map;
                Settings.EMPTY,  
                Settings.EMPTY,
            complexTemplates,  
        // Test V2 collectV2Mappings
import org.opensearch.indices.SystemIndices;
        } while (isSplitable(numShards, targetShards) == false);  
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
                Settings.EMPTY,
        assertNull("Should return null when disable_objects is not present", resultNull);
        // Process with V2 method  
    }
            threadPool,  
            }));
        long requestCreationDate = System.currentTimeMillis() - TimeValue.timeValueDays(30).millis();
            request,
    ) {  
            templateMetadata.settings(),
import static org.hamcrest.Matchers.hasValue;  
            "my-segment-repo-1",  
                () -> MetadataCreateIndexService.validateCloneIndex(
            request,  
            randomShardLimitService(),
        assertThat(mappings, Matchers.hasKey(MapperService.SINGLE_MAPPING_NAME));
import java.util.concurrent.atomic.AtomicBoolean;
            .build();
    }
        );  
            validateIndexName(checkerService, "..", "must not be '.' or '..'");
            .put(SETTING_VERSION_CREATED, Version.CURRENT)  
            .settings(settings(Version.CURRENT).put(settings))
                                  "userstate": { "type": "keyword" }  
            Set.of(INDEX_READ_ONLY_BLOCK),
        Map<String, Object> mappings = parseV1Mappings(  
                Map<String, Object> expected = expectedParser.map();
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT).nodes(discoveryNodes).build();
            equalTo(
        Settings templateSettings = Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, 2).build();
            EmptyClusterInfoService.INSTANCE,
            .put(IndexMetadata.SETTING_INGESTION_SOURCE_MAPPER_TYPE, "field_mapping")
            () -> aggregateIndexSettings(
        // Test that custom creation_date from request takes precedence over template  
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
            .build();
        assertEquals("Should have 3 mappings (2 templates + 1 request)", 3, result3.size());  
    public void testDoNotOverrideSoftDeletesSettingOnResize() {
import org.opensearch.action.admin.indices.create.CreateIndexClusterStateUpdateRequest;  
    public void testClusterForceReplicationTypeInValidateIndexSettings() {
        // Test 3: Request mapping priority - template has disable_objects=true, request has disable_objects=false
        // is set to a value that is equal to the `cluster.default.index.refresh_interval` value.
            .add(
                clusterService,
            Map<String, Object> doc = (Map<String, Object>) mapping.get(MapperService.SINGLE_MAPPING_NAME);
                equalTo("whitespace")
        );
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertEquals(Long.toString(epochCreationDate), aggregatedSettings.get(IndexMetadata.SETTING_CREATION_DATE));
            requestMapping,
                indicesServices,  
        );
            validateIndexName(checkerService, "INDEXNAME", "must be lowercase");  
        );  
            request,
                        .endObject()
        assertEquals(
        final IllegalArgumentException error = expectThrows(
            attributes,
import org.opensearch.index.IndexNotFoundException;
     */  
            .build();  
 * ownership. Elasticsearch licenses this file to you under  
                repositoriesServiceSupplier
            null,  
            .metadata(metadata)  
            buildNewFakeTransportAddress(),
        when(blobStoreMock.isBlobMetadataEnabled()).thenReturn(randomBoolean());  
                ValidationException ve = new ValidationException();
            requestMapping1,
            cs
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            )  
        );  
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "rack.values", "c, d, e")  
        request.settings(requestSettings.build());
            clusterState,
            settings,
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
            "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":true,\"properties\":{\"field2\":{\"type\":\"keyword\"}}}}"
    }
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
                Settings.EMPTY,  
        }  
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,  
        );  
    public void testGetIndexNumberOfRoutingShardsWithNullSourceIndex() {
            xContentRegistry()
    public void testCreateIndexWithZeroCreationDate() {
        aggregateIndexSettings(
        String templateContent = "{\n"  
            .put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), clusterMinRefreshTime)
            ClusterState.EMPTY_STATE,  
    }
        final Settings.Builder requestSettings = Settings.builder();
            settings.put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), TimeValue.timeValueMillis(between(1, 120)));
                    "dynamic": "true"  
            Collections.emptySet(),
                    String.format(  
        ClusterService clusterService = mock(ClusterService.class);  
            assertEquals(ratio, intRatio, 0.0d);
            ClusterState.EMPTY_STATE,
        // Feature flag off — no validation even with restrict=true and mismatching values.
     */
            ReplicationType.SEGMENT.toString(),
            .build();  
        TimeValue clusterMinRefreshTime = TimeValue.timeValueMillis(clusterMinRefreshTimeMs);
import org.opensearch.test.OpenSearchTestCase;  
            assertTrue(  
        IndexTemplateMetadata templateMetadata = addMatchingTemplate(builder -> {
            null,
                    InvalidIndexContextException.class,
            BigArrays.NON_RECYCLING_INSTANCE,
            is(768)  
import org.opensearch.common.util.BigArrays;  
     * remote segments and translog.
        // End-to-end sanity: confirm updatePluggableDataFormatSettings is wired into the create-index
                        SETTING_REMOTE_SEGMENT_STORE_REPOSITORY
            indicesServices,  
        // Should NOT throw — feature flag is off by default in tests without @LockFeatureFlag
                repositoriesServiceSupplier  
            clusterSettings
        if (randomBoolean()) {
        assertEquals("Should have 3 mappings (2 templates + 1 request)", 3, complexResult.size());
        assertEquals("parquet", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(aggregated));
    @LockFeatureFlag(APPLICATION_BASED_CONFIGURATION_TEMPLATES)
            new SystemIndices(Collections.emptyMap()),
        when(repositoryMock.isSeverSideEncryptionEnabled()).thenReturn(true);
            Settings.EMPTY,
            .put(IndexMetadata.SETTING_INGESTION_SOURCE_MAPPER_TYPE, "default")
            clusterState,  
        );
        Settings indexSettings = aggregateIndexSettings(  
        assertTrue(e.getMessage().contains(Version.V_3_5_0.toString()));
            .build();  
        Map<String, String> remoteCustomData = indexMetadata.getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY);
        DiscoveryNodes finalDiscoveryNodes = DiscoveryNodes.builder()  
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false)  
        assertThat(aggregatedIndexSettings.get(SETTING_NUMBER_OF_REPLICAS), equalTo("3"));
                  }  
 * GitHub history for details.
        Settings aggregateIndexSettings = aggregateIndexSettings(  
                builder.putMapping("type", "{\"type\": {}}");  
        Settings aggregatedSettings = aggregateIndexSettings(
        withTemporaryClusterService(((clusterService, threadPool) -> {  
            DefaultRemoteStoreSettings.INSTANCE,
    public void testIndexTotalPrimaryShardsPerNodeSettingValidationWithRemoteStore() {  
        clusterSettings.applySettings(clusterState.metadata().settings());  
            Settings.EMPTY,  
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
            );  
            equalTo("alias1")
import org.opensearch.cluster.block.ClusterBlocks;  
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();  
            xContentRegistry()
            Setting.Property.IndexScope,
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        assertFalse(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(aggregated));  
        );
        );
     * Simple test to verify the V1/V2 equivalence validation utilities work correctly.
            Map<String, Object> doc = (Map<String, Object>) mapping.get(MapperService.SINGLE_MAPPING_NAME);
                              "@fields": {
        when(repositoryMock.blobStore()).thenReturn(mock(BlobStore.class));
        assert source < target : source + " >= " + target;
        );  
                exception.getMessage().contains("index specifies a context which is not loaded on the cluster.")
            IllegalArgumentException.class,
        assertEquals("lucene", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(out));  
            currentClusterState,
import org.opensearch.cluster.node.DiscoveryNodeRole;
        // Test that custom creation_date is properly stored in IndexMetadata
        assertEquals(remoteSegmentRepo, indexSettings.get(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY));
            aliases,
            expectThrows(
        assertThat(updatedClusterState.routingTable().index("test"), is(notNullValue()));
        Settings indexSettings = aggregateIndexSettings(
                                  "userstate": { "type": "keyword" },  
            .put(CLUSTER_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
        assertTrue(customData.containsKey(expectedKey));  
        assertWarnings(
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone, rack")
        // Verify that the value is the same as set as earlier and the validation was successful  
    public void testTemplateOrder() throws Exception {  
        );
        assertEquals(
                null,  
    /**  
            @SuppressWarnings("unchecked")  
            );
import static org.opensearch.indices.IndicesService.CLUSTER_REPLICATION_TYPE_SETTING;
    public void testValidateIngestionSourceSettingsWithUnknownMapperSettingsKey() {
        assertEquals("parquet", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(out));  
                    MapperService.parseMapping(NamedXContentRegistry.EMPTY, componentTemplate.get().template().mappings().toString()),  
    public void testInvalidAliasName() {
                randomShardLimitService(),  
        systemIndexDescriptors.add(new SystemIndexDescriptor(".pattern-test*", "test-1"));
            templateMetadata.settings(),
        Settings indexSettings = Settings.builder()
            .numberOfShards(6)  
        Settings clusterBag = Settings.builder()
            null  
     * Covers: V1/V2 request mapping priority, equivalence validation, edge cases.
        );
        IndexMetadata indexMetadata = IndexMetadata.builder("test").settings(indexSettings).build();  
            expectThrows(
    public void testUpdatePluggableDataFormatSettingsSkipsEnabledWhenAlreadySet() {
            assertEquals("ratio is not a power of two", intRatio, Integer.highestOneBit(intRatio));  
            assertFalse("Mapping " + i + " should not contain disable_objects", doc.containsKey("disable_objects"));
        aggregateIndexSettings(
            settings,
            DefaultRemoteStoreSettings.INSTANCE,
        versions.sort(Comparator.comparingLong(l -> l.id));
        String requestMapping2 = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":false,\"properties\":{}}}";  
            .numberOfReplicas(numReplicas)
            } catch (IOException e) {  
            clusterService,
            Settings.builder()  
    // ---- allowlist tests ----  
        Settings targetSettings = Settings.builder().put("index.number_of_shards", numShards * 2).build();  
            Settings.EMPTY,  
        when(repositoriesService.repository(Mockito.any())).thenReturn(repositoryMock);  
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,  
            Settings.EMPTY,
            .build();
        );
import static org.mockito.Mockito.when;  
    public void testTemplateDisableObjects() throws Exception {
            final int routingNumberOfShards = 4;
              }
        Settings.Builder settingsBuilder = Settings.builder().put(INDEX_SOFT_DELETES_SETTING.getKey(), "false");
import org.opensearch.common.settings.Setting;  
        Settings aggregatedIndexSettings = aggregateIndexSettings(  
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
import java.util.concurrent.CountDownLatch;  
        assertTrue("Creation date should be <= afterCreation", actualCreationDate <= afterCreation);
            randomShardLimitService(),
        when(clusterService.getSettings()).thenReturn(settings);
            .put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 2)  
                checkerService,
            .build();
        IndexTemplateMetadata templateMetadata = addMatchingTemplate(builder -> {  
        );
            .localNodeId(nonRemoteClusterManagerNode.getId())
            .build();  
              }
        mappings.add(mapping2);
            () -> MetadataCreateIndexService.validateIngestionSourceSettings(settings, state)  
                repositoriesServiceSupplier  
    }  
        ClusterSettings clusterSettings = new ClusterSettings(nodeSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    public void testRemoteStoreNoUserOverrideExceptReplicationTypeSegmentIndexSettings() {
                IllegalStateException.class,  
     * Test V1/V2 equivalence with edge cases like null mappings and empty templates.  
        validateV1V2Equivalence(Arrays.asList("{}"), "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{}}}");
            request,
        DiscoveryNode remoteNode = new DiscoveryNode(
import org.opensearch.index.IndexSettings;
            ClusterState mockState = mock(ClusterState.class);  
            null
                DefaultRemoteStoreSettings.INSTANCE,
            null,  
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
            int intRatio = (int) ratio;
                null,
        );  
                DefaultRemoteStoreSettings.INSTANCE,
                .put("index.version.created", Version.CURRENT)
            Setting.Property.IndexScope,  
            .put("node.attr.remote_store.segment.repository", "my-segment-repo-1")
        Settings.Builder indexSettingsBuilder = Settings.builder();
        // Template 1 (order 0): field2 with type=keyword, store=true
    /**
            assertEquals(1, validationException.validationErrors().size());  
            + "      \"value\": {\"type\": \"double\"},\n"  
        verifyRemoteStoreIndexSettings(
    }
    }  
    // ---- updatePluggableDataFormatSettings ----
            null,
            .build();  
        requestSettings.put(IndexMetadata.SETTING_CREATION_DATE, epochCreationDate);
        verifyRemoteStoreIndexSettings(
     * test for disable_objects override helper methods.  
            newIndexMetadata,  
            nodeSettings,
        assertEquals("field2 type should be from template2", "text", field2.get("type"));  
                queryShardContext
        when(clusterService.state()).thenReturn(clusterState);  
    }  
                    + "Please do not specify a value for setting [index.soft_deletes.enabled]."
            Collections.emptySet(),
        assertTrue(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(aggregated));  
        );  
        clusterSettings = new ClusterSettings(clusterSettingsSetting, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        DiscoveryNode segmentsOnlyNode = new DiscoveryNode(
            ClusterState.EMPTY_STATE,
            Object v2DisableObjects = extractDisableObjectsValue(mapping);
                threadPool,
            .put("node.attr.remote_store.segment.repository", "my-segment-repo-1")  
            ClusterState.EMPTY_STATE,  
                        "private index setting [%s] can not be set explicitly",  
            Collections.emptySet(),
        Metadata.Builder metaBuilder = Metadata.builder();  
                    )
        // now we start the shard  
import static org.hamcrest.Matchers.is;
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).nodes(nodes).build();
    public void testParseMappingsWithTypedTemplateAndTypelessIndexMapping() throws Exception {  
            "",
                assertNull(settings.get("index.non_copyable.existing"));
            "[simplefs] is deprecated and will be removed in 2.0. Use [niofs], which offers equal "
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.STRICT)  
    }
            indicesServices,  
        Settings out = indexSettingsBuilder.build();  
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,  
            Map<String, Object> doc = (Map<String, Object>) mapping.get(MapperService.SINGLE_MAPPING_NAME);  
        Map<String, Object> v1Result = MetadataCreateIndexService.parseV1Mappings(requestMapping, templateMappings, xContentRegistry());
                    }
        assertEquals(refreshInterval, INDEX_REFRESH_INTERVAL_SETTING.get(indexSettings));
        assertThat(targetRoutingNumberOfShards, is(6));
                    buildNewFakeTransportAddress(),
        int targetRoutingNumberOfShards = getIndexNumberOfRoutingShards(indexSettings, sourceIndexMetadata);
        Map<String, Object> docWithoutDisableObjects = new HashMap<>();
        // Test 1: Basic V1/V2 equivalence with single template
            .put("index.similarity.default.type", "BM25")
                assertNull(settings.getAsBoolean("index.blocks.write", null));  
        assertThat(indexMetadata.getAliases().keySet().iterator().next(), is("alias1"));  
                .startObject()
                0,
                    repositoriesServiceSupplier
     */  
        request.settings(requestSettings.build());
                Settings.EMPTY,
            Settings.EMPTY,
            settings,  
            .build();  
    }  
        for (int i = 0; i < complexResult.size(); i++) {
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)  
        String templateWithoutDisableObjects = "{\""
        assertEquals(ReplicationType.SEGMENT.toString(), aggregateIndexSettings.get(INDEX_REPLICATION_TYPE_SETTING.getKey()));
                null,
        MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
            clusterSettings
        Map<String, Object> v1Properties = (Map<String, Object>) v1Doc.get("properties");
        final Settings indexSettings = Settings.builder()  
    public void testValidateIngestionSourceSettingsWithFieldMappingOnCurrentVersion() {  
        Settings.Builder settingsBuilder = Settings.builder();
        final Settings indexSettings = Settings.builder().put(INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.DOCUMENT).build();  
            Settings.builder().put("index.number_of_shards", targetShards).build()  
                Collections.emptySet(),
    }  
            createClusterState("source", numShards, 0, Settings.builder().put("index.blocks.write", true).build())
        Settings targetSettings = Settings.builder().put("index.number_of_shards", numShards).build();  
        );
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
            "index setting [index.translog.durability=async] is not allowed as cluster setting [cluster.remote_store.index.restrict.async-durability=true]",  
        Map<String, Object> mappings = parseV1Mappings("", Collections.singletonList(templateMetadata.mappings()), xContentRegistry());
            "can't shrink an index with only one shard",  
        );  
            XContentParser contentParser = JsonXContent.jsonXContent.createParser(  
        Settings clusterBag = Settings.builder()  
        );
            randomShardLimitService(),
            clusterSettings
            + "        \"type\": \"object\",\n"
            nodeSettings,
            false,
        request.settings(requestSettings.build());  
    }
                assertThat(settings.get("index.non_copyable.request"), equalTo("request"));
                          }
            clusterSettings
        );
        Settings indexSettings = Settings.builder()  
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_READ_ONLY_BLOCK;
            (clusterState, y) -> clusterState,
                          "_doc": {  
            Settings.EMPTY,
        }  
            IndexCreationException.class,
    }
            addMatchingTemplate(
                settings,
                null,
            randomShardLimitService(),  
                IllegalStateException.class,
    public void testValidateIngestionSourceSettingsWithFieldMappingOnOldVersion() {
            templateBuilder.putMapping("type", createMapping("mapping_from_template", "text"));
            ClusterState.EMPTY_STATE,  
        for (Map<String, Object> mapping : result3) {
            request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test").context(new Context(randomAlphaOfLength(5)));
                .put("index.merge.scheduler.max_merge_count", maxMergeCount)
    public void testAggregateIndexSettingsPropagatesIndexCreationExceptionFromProvider() {
            Settings.EMPTY,  
 * KIND, either express or implied.  See the License for the
            expectThrows(  
            }));
            new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
        clusterState = ClusterState.builder(ClusterName.DEFAULT).nodes(discoveryNodes).build();
        IndexMetadata indexMetadata = metadataCreateIndexService.buildAndValidateTemporaryIndexMetadata(
    public void testV2TemplateDisableObjects() throws Exception {
                clusterSettings
            expectThrows(
     * Node attributes for {@code node.attr.remote_store.mode: segments_only}: a segment repository and neither a
            request,  
    }
    }
        );
                null,
            Settings.EMPTY,
                        {
        settings.put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.SIMPLEFS.getSettingsKey());  
                Object mappingDisableObjects = extractDisableObjectsValue(mapping);
        assertEquals("lucene", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(out));  
        );
            .put(IndicesService.CLUSTER_RESTRICT_PLUGGABLE_DATAFORMAT_SETTING.getKey(), true)  
    public void tearDown() throws Exception {
        assertEquals(  
        assertThat(mappingsProperties, hasKey("mapping_from_request"));  
            .put("node.attr.remote_store.translog.repository", "my-translog-repo-1")
    }
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            null,
        mappingWithDisableObjects.put(MapperService.SINGLE_MAPPING_NAME, docWithDisableObjects);
    public void testValidateIndexSettingsUsesDefaultNumberOfReplicasFromClusterSettings() {
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        String complexRequestMapping = "{\n"  
        Metadata metadata = Metadata.builder()
                "Invalid exception message: " + validationException.getMessage(),
        // Verify if index setting overrides cluster replication setting  
            componentTemplate.set(ComponentTemplate.parse(contentParser));  
        Settings indexSettings = Settings.builder().put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 3).build();
            ClusterState.EMPTY_STATE,  
            .build();
        ) {
                createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
    }  
        assertThat(mappings, Matchers.hasKey(MapperService.SINGLE_MAPPING_NAME));
                true,
        assertThat(validationErrors.get(0), is("expected total copies needs to be a multiple of total awareness attributes [3]"));
import org.opensearch.index.engine.EngineConfig;  
            request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
                                "dynamic": "true",
            Map<String, Object> actual = parser.map();
            .build();
        // Test 1: Default mapping merge behavior when no disable_objects is present
     * cluster state repository.
                                "properties": {
            request.index(),
        AliasMetadata alias = resolvedAliases.get(0);
        MetadataCreateIndexService.updatePluggableDataFormatSettings(indexSettingsBuilder, cs, "user-index");
        Map<String, Object> logDoc = (Map<String, Object>) logResult.get(MapperService.SINGLE_MAPPING_NAME);
                true,
            Settings.EMPTY,
                createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),  
        int targetRoutingNumberOfShards = getIndexNumberOfRoutingShards(indexSettings, null);
        assertTrue(thrown.getCause() instanceof ValidationException);
    /**
    private QueryShardContext queryShardContext;  
        assertNotNull(remoteCustomData);  
        // Verify no disable_objects field is added and structure is preserved  
    }
        Settings nodeSettings = Settings.builder().put(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey(), 0).build();
                    Settings.builder().put("index.number_of_shards", 10).build()
        Object v1DisableObjects1 = extractDisableObjectsValue(v1Result1);  
            MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
        clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        );
            ).getMessage()
            ).getMessage()
                throw new RuntimeException(e);  
            null,
        DiscoveryNode oldNode = new DiscoveryNode("old_node", buildNewFakeTransportAddress(), emptyMap(), roles, Version.V_3_5_0);
                () -> MetadataCreateIndexService.validateShrinkIndex(
        // Request mapping defines a specific sub-field under @fields
        assertNotNull(imdBuilder.build().getCustomData());  
        List<Map<String, Object>> result2 = MetadataCreateIndexService.collectV2Mappings(
            Settings.EMPTY,
        Map<String, Object> mapping3 = new HashMap<>();
        Settings.Builder settingsBuilder = Settings.builder()
        assertThat(targetRoutingNumberOfShards, is(768));
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,  
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,  
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
                randomShardLimitService(),
            } catch (IOException e) {
            .build();  
    public void testDefaultNumberOfReplicasUsesNodeSetting() {
        Settings indexSettings = aggregateIndexSettings(
                repositoriesServiceSupplier
        when(clusterService.getSettings()).thenReturn(forceClusterSettingEnabled);
            null,  
    }  
            Settings.EMPTY,  
            Settings.EMPTY,
            .build();
                    "Invalid exception message." + exception.getMessage(),  
    }
                requestSettings.build(),
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "lucene")
        when(clusterService.state()).thenReturn(clusterState);
                new Environment(Settings.builder().put("path.home", "dummy").build(), null),
            .putList(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_RESTRICT_ALLOWLIST.getKey(), ".system")
                    missingTranslogAttribute,  
        ClusterSettings clusterSettings = new ClusterSettings(nodeSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
            ) {  
                clusterService.state()
                Settings.EMPTY,  
                )
        templates.add(
        String resultJson = XContentFactory.jsonBuilder().map(result).toString();
            ClusterSettings.BUILT_IN_CLUSTER_SETTINGS  
        assertTrue(e.getMessage().contains("field_mapping"));
        );
        assertEquals(indexRefreshTime, INDEX_REFRESH_INTERVAL_SETTING.get(indexSettings));
        Settings mismatch = Settings.builder().put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false).build();
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
    }  
import static org.opensearch.index.IndexModule.INDEX_STORE_TYPE_SETTING;  
import org.opensearch.common.UUIDs;  
        when(repositoryMock.blobStore()).thenReturn(blobStoreMock);
import org.opensearch.indices.InvalidIndexContextException;  
        // This checks that aggregateIndexSettings works for the case when the index setting `index.number_of_replicas` is set to null  
        Settings out = indexSettingsBuilder.build();
                () -> MetadataCreateIndexService.validateShrinkIndex(
            randomShardLimitService(),  
            randomShardLimitService(),  
     */
        CompressedXContent templateB = new CompressedXContent("""
        assertThat(doc, hasKey("properties"));
    public void testParseMappingsWithTypelessTemplate() throws Exception {
        List<SystemIndexDescriptor> systemIndexDescriptors = new ArrayList<>();
        Mockito.when(clusterService.getClusterSettings()).thenReturn(clusterSettings);  
    }
import static org.opensearch.common.util.FeatureFlags.REMOTE_STORE_MIGRATION_EXPERIMENTAL;
            Settings.EMPTY,
            + "    \"settings\": {\n"
            Collections.singletonList(templateMetadata.getMappings()),
            .build();
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        try (
            .blocks(ClusterBlocks.builder().addBlocks(indexMetadata))
        List<CompressedXContent> templateMappings1 = Arrays.asList(  
                aliasValidator,
            .build();
        });
            Collections.emptySet(),
        Settings out = indexSettingsBuilder.build();
        String metricTemplate = "{\n"  
 * software distributed under the License is distributed on an
        );
    public void testValidatePluggableDataFormatRejectsValueMismatch() {
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        ClusterSettings clusterSettings = new ClusterSettings(nodeSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
            .build();
     * carries a validator cross-checking {@code index.replication.type}, and this code also runs from snapshot
        assertThat("Should have dotted field names", properties, hasKey("memory.used"));
            .build();  
        assertEquals(
    public void testNewIndexIsRemoteStoreBackedForRemoteStoreDirectionAndMixedMode() {
     * Stamping the fencing default must not validate the settings it is handed. {@code index.remote_store.enabled}
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
                    )
        final Settings.Builder indexSettingsBuilder = Settings.builder().put("index.number_of_shards", 1).put(requestSettings);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            null,
    /**
            request,
        // Test 4: Multiple templates with different values, request overrides all
            .build();
        }
              "_doc": {
        String template1 = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{\"field1\":{\"type\":\"text\"}}}}";
    }
            assertThat(
            ClusterState.EMPTY_STATE,  
            EmptyClusterInfoService.INSTANCE,
                true,  
                requestSettings.build(),
                null,  
    }  
            .numberOfShards(numShards)  
        Map<String, String> attributes = getNodeAttributes();
            )
            mixedTemplates,
            UUIDs.base64UUID(),  
                new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
        Metadata metadata = Metadata.builder()
                () -> MetadataCreateIndexService.validateSplitIndex(  
                resultJson
        );  
        );  
        );
                Settings.EMPTY,
        final Set<DiscoveryNodeRole> roles = Collections.unmodifiableSet(
        final Settings.Builder requestSettings = Settings.builder();  
        when(repositoriesService.repository(getRemoteStoreSegmentRepo(settings))).thenReturn(repositoryMock);  
    }
            xContentRegistry()  
            MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
        );
    }
            settingsBuilder.put(NODE_ATTRIBUTES.getKey() + REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY, "test");
            validateIndexName(checkerService, "index#name", "must not contain '#'");  
        );
        );  
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), true)
            "true",
                clusterService,
     * test for disable_objects template functionality.
            + "      \"@timestamp\": {\"type\": \"date\"},\n"  
            buildNewFakeTransportAddress(),
            clusterSettings  
                + "\":{"
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            + "    \"_type\": \"@abc_template\",\n"
        runPrepareResizeIndexSettingsTest(  
            .build();  
                templateContent  
        assertTrue("Log template should have @timestamp", logProperties.containsKey("@timestamp"));  
                "properties": {
        IndexMetadata.Builder imdBuilder = IndexMetadata.builder("test").settings(indexSettings);
        requestSettings.put(INDEX_REFRESH_INTERVAL_SETTING.getKey(), refreshInterval);
                    }  
        assertEquals(Long.toString(negativeCreationDate), aggregatedSettings.get(IndexMetadata.SETTING_CREATION_DATE));
            null,
        assertThat(allocationRerouted.get(), is(true));  
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
            }  
    }
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
    }
            request,
                    indicesServices,
        );
                NamedXContentRegistry.EMPTY,
            .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 3)
            settings,
    }
        assertEquals(576, MetadataCreateIndexService.calculateNumRoutingShards(9, Version.CURRENT));
        assertEquals("field1 store should be from template1", true, field1.get("store"));  
    public void testClusterReplicationSetting() {
            requestMapping3,
        // Set index setting refresh interval the same value as the cluster minimum refresh interval
                true,
                () -> MetadataCreateIndexService.validateShrinkIndex(
            Settings.EMPTY,  
            settings -> assertThat(
            + "    }\n"
            "my-translog-repo-1",
            .transientSettings(Settings.builder().put(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey(), 1).build())
        Settings clusterBag = Settings.builder()  
            IndexMetadata indexMetadata = checkerService.buildAndValidateTemporaryIndexMetadata(
/*  
            null,
            Settings settings = Settings.builder().put(CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING.getKey(), false).build();
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
        }
import org.opensearch.test.VersionUtils;
                    .settings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 10))
    }
                ClusterState.EMPTY_STATE,
        Settings targetSettings = Settings.builder().put("index.number_of_shards", 1).build();
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), true)
        Map<String, Object> logResult = complexResult.get(0);  
                        .field("type", "float")
 * compatible open source license.
                createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),  
            Map<String, Object> doc = (Map<String, Object>) mapping.get(MapperService.SINGLE_MAPPING_NAME);
        Settings aggregatedIndexSettings = aggregateIndexSettings(
        assertTrue(Boolean.valueOf(remoteCustomData.get(IndexMetadata.REMOTE_STORE_SSE_ENABLED_INDEX_KEY)));  
 */  
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,  
            ClusterState.EMPTY_STATE,
        try {  
        withTemporaryClusterService(((clusterService, threadPool) -> {
            ClusterState.EMPTY_STATE,  
                () -> checkerService.validateContext(request)
            try (  
        ClusterService clusterService = mock(ClusterService.class);  
        MetadataCreateIndexService.validateSplitIndex(
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
                    null,
import java.util.stream.Stream;
    }
import org.opensearch.common.util.FeatureFlags;
            .numberOfReplicas(0)
            )
                "source",  
                request,
            Settings.EMPTY,
            settingsBuilder,
            .put(RemoteStoreSettings.CLUSTER_SERVER_SIDE_ENCRYPTION_ENABLED.getKey(), true)
            Settings.EMPTY,
        );  
            );  
                clusterService,
            Collections.emptySet(),  
            .build();
        Map<String, Object> resultDoc3 = (Map<String, Object>) noDisableObjectsMappings.get(0).get(MapperService.SINGLE_MAPPING_NAME);  
        @SuppressWarnings("unchecked")
            clusterService,
        assertTrue(  
            )
        Settings templateSettings = Settings.builder().put(INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT).build();  
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
                ExceptionsHelper.reThrowIfNotNull(e);
            .metadata(metadata)
        List<Map<String, Object>> mappings = new ArrayList<>();
            null,
            null,  
        assertTrue(e.getMessage().contains("mapper_settings are not supported for mapper_type [default]"));
                        Locale.ROOT,
            Settings.builder().put("index.blocks.write", true).build()
        when(repositoriesServiceSupplier.get()).thenReturn(repositoriesService);
        final Settings.Builder requestSettings = Settings.builder();  
        // Template A (lower priority / later in list): defines @fields as dynamic object
                DefaultRemoteStoreSettings.INSTANCE,  
        request.settings(requestSettings.build());  
            .settings(settings(Version.CURRENT))
        assertTrue(e.getMessage().contains("requires op_type_field to be configured"));
        );
        Map<String, Object> docWithDisableObjects = new HashMap<>();
    }
                    """
    }
        );
        AllocationService service = new AllocationService(  
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).nodes(nodes).build();  
            .put("index.version.created", Version.CURRENT)  
            .build();  
            );  
        // Default mapper type on old nodes — should pass (no version requirement)  
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            settings,  
            UUIDs.base64UUID(),  
                Settings.EMPTY,  
            "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{}}}"
    private IndexTemplateMetadata.Builder templateMetadataBuilder(String name, String pattern) {
            Settings.builder().put("index.similarity.sim.type", "DFR").build(),  
                .putMapping("_doc", templateMapping)  
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,  
    }  
        Integer clusterDefaultReplicaNumber = 5;  
        long templateCreationDate = System.currentTimeMillis() - TimeValue.timeValueDays(60).millis();
            templateMappings4,  
        assertEquals("parquet", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(aggregated));
        Settings indexSettings = aggregateIndexSettings(
        IllegalArgumentException e = expectThrows(
        assertEquals(  
            EmptySnapshotsInfoService.INSTANCE  
        );
            + "      \"level\": {\"type\": \"keyword\"},\n"
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        assertEquals("field2 store should be from template2", false, field2.get("store"));
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.routing.allocation.decider.MaxRetryAllocationDecider;
            randomShardLimitService(),
        assertNotNull(imdBuilder.build().getCustomData());
            clusterSettings
        request.settings(requestSettings.build());
    public void testCreateIndexWithContextDisabled() throws Exception {
    public void testValidateIndexName() throws Exception {
        String template3a = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":false,\"properties\":{}}}";  
            randomShardLimitService(),
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            )  
            .build();
            new BalancedShardsAllocator(Settings.EMPTY),
            @SuppressWarnings("unchecked")
        Settings indexSettings = Settings.builder()  
import static java.util.Collections.singletonList;  
            () -> metadataCreateIndexService.validateIndexName(
            numShards,  
                false,  
        clusterSettings.applySettings(clusterState.metadata().settings());  
                builder -> builder.order(3)
                new SystemIndices(Collections.emptyMap()),  
            new AllocationDeciders(singleton(new MaxRetryAllocationDecider())),
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
        repositoriesServiceSupplier = mock(Supplier.class);  
    public void testValidatePluggableDataFormatAllowsMatchingValues() {  
            "index source must block write operations to resize index. use \"index.blocks.write=true\"",
            .put("index.version.created", version)  
                new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
        }  
            () -> MetadataCreateIndexService.validateIngestionSourceSettings(settings, state)
        // is set to a value that is greater than the `cluster.default.index.refresh_interval` value.  
        remoteCustomData.put(IndexMetadata.REMOTE_STORE_SSE_ENABLED_INDEX_KEY, "true");  
        clusterSettings = new ClusterSettings(clusterSettingsSetting, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        );  
            );
    }
        final Map<String, Object> mappings = new HashMap<>();
        String remoteTranslogRepo,
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false)
        ClusterService clusterService = mock(ClusterService.class);
            Settings.EMPTY,
            Collections.emptySet(),
    }  
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;  
    public void testIndexLifecycleNameSetting() {
            Settings.EMPTY,
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
                InvalidIndexContextException exception = expectThrows(
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
                finalClusterSettings
        ).collect(Collectors.toSet());  
            ).getMessage()
        Map<String, String> attributes = new HashMap<>();
        IndexSettingProvider throwingProvider = new IndexSettingProvider() {
        assertEquals(
        Settings indexSettings = Settings.builder()
import org.opensearch.indices.InvalidAliasNameException;
        // One node on older version — should fail
        Settings nodeSettings = Settings.builder().put(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey(), 0).build();  
                new SystemIndices(Collections.emptyMap()),
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
    }
                new SystemIndices(Collections.emptyMap()),
            null,
            ClusterState.EMPTY_STATE,  
            true,  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
            .nodes(DiscoveryNodes.builder().add(getRemoteNode()).build())
            randomShardLimitService(),
        );
        }));
            Collections.emptySet(),  
            nodeSettings,
            REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY,
            builder.put(IndexMetadata.builder(myIndex).putAlias(AliasMetadata.builder(newAlias.getAlias()).build()));  
        assertEquals(Long.toString(futureCreationDate), aggregatedSettings.get(IndexMetadata.SETTING_CREATION_DATE));
        Settings clusterBag = Settings.builder()
                .settings(Settings.builder().put("key1", "templateValue"))
                () -> MetadataCreateIndexService.validateCloneIndex(state, "no_such_index", "target", targetSettings)
            expectThrows(
            () -> aggregateIndexSettings(
 * this work for additional information regarding copyright
        final Settings.Builder requestSettings = Settings.builder();
            Collections.singletonList(templateMetadata.mappings()),
            templateMappings3,
                threadPool,  
            null,
        when(repositoryMock.blobStore()).thenReturn(blobStoreMock);  
        RoutingTable routingTable = service.reroute(clusterState, "reroute").routingTable();  
                }
        // now we start the shard
        );
                .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)  
        assertEquals(ReplicationType.SEGMENT.toString(), indexSettings.get(INDEX_REPLICATION_TYPE_SETTING.getKey()));
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).nodes(nodes).build();
            clusterSettings
            .build();  
        Settings settings = Settings.builder().put(CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING.getKey(), true).build();
    }
            exception.getMessage()
        assertEquals(REPLICATION_MISMATCH_VALIDATION_ERROR, exception.getCause().getMessage());  
                request,  
            ) {
            repositoriesServiceSupplier
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        verifyRemoteStoreIndexSettings(
        Settings settings = Settings.builder().put(CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING.getKey(), true).build();  
     * Utility method to validate that V1 and V2 template processing produce equivalent
        List<Map<String, Object>> noDisableObjectsMappings = new ArrayList<>();  
            createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),  
            .metadata(metadata)
            + "      \"created_at\": {\"type\": \"date\"}\n"  
            }
        final Version version = versions.get(0);  
                createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),  
                Collections.emptySet(),
            writableRegistry(),
            Collections.emptySet(),
            .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 3)
        MetadataCreateIndexService.updatePluggableDataFormatSettings(indexSettingsBuilder, cs, "test-index");
            clusterSettings
                () -> MetadataCreateIndexService.validateCloneIndex(state, "target", "source", targetSettings)  
        // Explicitly disable the FF  
                    createClusterState("source", randomIntBetween(2, 100), randomIntBetween(0, 10), Settings.EMPTY),  
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).nodes(nodes).build();
    }  
        );  
                .build(),  
        );  
     */
            .put("node.attr.remote_store.segment.repository", "my-segment-repo-1")
    private Object extractDisableObjectsValue(Map<String, Object> mapping) {  
            null,
            null,
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
        Object resultNull = extractDisableObjectsValue(mappingWithoutDisableObjects);  
            Settings.EMPTY,
            try (  
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            Collections.emptySet(),
    }
    }  
            Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 15).build(),
        assertNotNull(updatedClusterState.metadata().findAllAliases(new String[] { "my-index" }).get("my-index"));
            cs
        IndexMetadata existingWriteIndex = IndexMetadata.builder("test2")
            Settings.EMPTY,  
            null,  
        );
        assertEquals("lucene", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(out));
            );
            .put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), clusterMinRefreshTime)
        assert source > target : source + " <= " + target;
        BlobStoreRepository repositoryMock = mock(BlobStoreRepository.class);
            clusterState,
        imdBuilder.putCustom(IndexMetadata.REMOTE_STORE_CUSTOM_KEY, remoteCustomData);
    public void testV1V2EquivalenceEdgeCases() throws Exception {
        IndexTemplateMetadata basicTemplate = addMatchingTemplate(builder -> {  
            """;
                new SystemIndices(Collections.singletonMap("foo", systemIndexDescriptors)),
            null,  
        // Test V1 parseV1Mappings
            DiscoveryNodeRole.BUILT_IN_ROLES,  
import static org.opensearch.index.IndexSettings.INDEX_MERGE_POLICY;
                Collections.singleton(throwingProvider),
            clusterSettings
        Settings nodeSettings = Settings.builder().put(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey(), 0).build();  
        Settings.Builder settingsBuilder = Settings.builder();  
        TimeValue clusterMinRefreshTime = TimeValue.timeValueSeconds(clusterMinRefreshTimeMs);
                )
    public void testPrepareResizeIndexSettings() {  
                is(  
                )
                        .endObject()  
            .put("node.attr.remote_store.translog.repository", "my-translog-repo-1")  
            "my-segment-repo-1",
        );
        // and read from the wrong source partitions until upgraded.  
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,  
        request.settings(requestSettings.build());
        long beforeCreation = System.currentTimeMillis();
    private void verifyRemoteStoreIndexSettings(  
    public void testAggregateSettingsAppliesSettingsFromTemplatesAndRequest() {
            assertThat(validationErrors.size(), is(1));
                Settings.EMPTY,
            .put("index.ingestion_source.mapper_settings.version_field", "timestamp")
                "analysis settings are not overwritten",  
            .numberOfShards(1)
            Settings.EMPTY,  
        MetadataCreateIndexService checkerService = new MetadataCreateIndexService(  
                () -> checkerService.applyContext(request, mockState, List.of(), settingsBuilder)
        );
    }
        assertTrue(updatedClusterState.metadata().findAllAliases(new String[] { "my-index" }).containsKey("my-index"));
            request.aliases(),  
            .build();
            .build();
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_INGESTION_SOURCE_PARTITION_STRATEGY, "modulo").build();  
            ).getMessage()  
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        );
                null,  
            xContentRegistry()  
        threadPool.shutdown();
        List<CompressedXContent> templateMappings = Arrays.asList(new CompressedXContent(template1), new CompressedXContent(template2));  
            try {
                            }  
            + "  }\n"
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;  
            .put(INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.getKey(), 9)  
            )
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");  
                    null,
        );
            randomShardLimitService(),  
        Settings settings = Settings.builder()  
            null,  
        for (Map<String, Object> mapping : result) {
        );  
                assertTrue("numRoutingShards: " + numRoutingShards, numRoutingShards > 512);
        withTemporaryClusterService((clusterService, threadPool) -> {
            """);
            {  
            randomShardLimitService(),
                new SystemIndices(Collections.emptyMap()),  
 * Modifications Copyright OpenSearch Contributors. See
        Settings matchingReplicationIndexSettings = Settings.builder()
        withTemporaryClusterService(((clusterService, threadPool) -> {  
            indicesServices,
        // No exception, and the cluster default is still baked in - rejecting the pairing belongs to the caller.
        validateV1V2Equivalence(  
        );
                assertEquals("Merged V1 template result should preserve dynamic object with all sub-fields", expected, actual);
            templateMappings,
            ReplicationType.SEGMENT.toString(),
                null,  
        when(clusterService.state()).thenReturn(clusterState);
        Settings out = indexSettingsBuilder.build();
        when(repositoryMock.blobStore()).thenReturn(blobStoreMock);  
        MetadataCreateIndexService.validateIngestionSourceSettings(settings, state);
            randomShardLimitService(),
    }
            updatedClusterState.metadata().findAllAliases(new String[] { "my-index" }).get("my-index").get(0).alias(),
                assertThat(settings.getAsInt("index.merge.scheduler.max_merge_count", null), equalTo(maxMergeCount));
        // Test 2: Edge case with null mappings  
        Map<String, String> attributes = new HashMap<>();
        Settings out = indexSettingsBuilder.build();
            null,
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
    public void testV1TemplateMergingPreservesDynamicObjectWithSubFieldMapping() throws Exception {  
            builder.settings(Settings.builder().put("template_setting", "value1"));  
            Collections.emptySet(),  
        assertTrue(e.getMessage().contains("unknown mapper_settings key [id_feild]"));
        Settings settings = Settings.builder().put(CLUSTER_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT).build();
    @LockFeatureFlag(REMOTE_STORE_MIGRATION_EXPERIMENTAL)
        Settings out = indexSettingsBuilder.build();
        Settings.Builder indexSettingsBuilder = Settings.builder().put(indexSettings);
            builder -> builder.putAlias(AliasMetadata.builder("alias").searchRouting("fromTemplate").build())
                () -> MetadataCreateIndexService.validateShrinkIndex(state, "target", "source", Settings.EMPTY)
                createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),  
        mapping2.put(MapperService.SINGLE_MAPPING_NAME, doc2);  
        );
            Settings.EMPTY,
            double ratio = numRoutingShards / randomNumShards;  
            randomShardLimitService(),
        try (
                    )  
            request,  
            )
        final Settings.Builder requestSettings = Settings.builder().put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), -1);
                null,  
                ClusterState.EMPTY_STATE,
            .numberOfReplicas(0)  
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "lucene");
            + "}\n";
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
            () -> MetadataCreateIndexService.validateIngestionSourceSettings(settings, state)
                    createClusterState("source", randomIntBetween(2, 100), randomIntBetween(0, 10), Settings.EMPTY),  
            );
            clusterState,
                .startObject(fieldName)
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT);
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);  
        ClusterService clusterService = mock(ClusterService.class);  
        Settings clusterBag = Settings.builder()  
            expectThrows(
                ValidationException.class,  
import static org.opensearch.indices.IndicesService.CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING;
            + "  },\n"  
                Map<String, Object> expected = expectedParser.map();  
                                "dynamic": "true",
            "test",  
import org.junit.Before;
                () -> MetadataCreateIndexService.validateSplitIndex(state, "no_such_index", "target", targetSettings)
            validateIndexName(checkerService, "", "Invalid index name [], must not be empty");  
            Settings.EMPTY,
    }  
        Settings aggregated = aggregateIndexSettings(
            MetadataIndexTemplateService.resolveSettings(templates),
            null,  
            clusterState.metadata().index(indexName).getIndex(),
import org.opensearch.indices.IndexCreationException;  
        ).routingTable();
            new TestGatewayAllocator(),  
                        .endObject()
        settingsBuilder.put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), pathType.toString());
    }
                    "target",
            aggregateIndexSettings(  
            settings,
import org.opensearch.cluster.OpenSearchAllocationTestCase;
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            )  
    public void testCustomCreationDateWithTemplates() {
                assertEquals("best_compression", settingsBuilder.get(EngineConfig.INDEX_CODEC_SETTING.getKey()));  
        for (Map<String, Object> mapping : result2) {
        assertEquals(customCreationDate, indexMetadata.getCreationDate());
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertThat(aggregatedIndexSettings.get(SETTING_NUMBER_OF_SHARDS), equalTo("12"));
        );  
            clusterSettings
                indicesServices,  
                new SystemIndices(Collections.emptyMap()),
            XContentParser parser = JsonXContent.jsonXContent.createParser(
     */
 * not use this file except in compliance with the License.
            "my-translog-repo-1",  
                assertTrue(
                  "@fields": {
        Map<String, Object> mapping2 = new HashMap<>();
    public void testValidateIngestionSourceSettingsWithMapperSettingsOnDefaultMapper() {
            startsWith("alias [alias1] has more than one write index [")  
        final Set<DiscoveryNodeRole> roles = Collections.unmodifiableSet(
    }  
        @SuppressWarnings("unchecked")
            .build();
    public void testRequestDurabilityWhenRestrictSettingTrue() {  
                false,  
            assertThat(validationErrors.get(0), is("expected [index.lifecycle.name] to be private but it was not"));
                CountDownLatch counter = new CountDownLatch(1);  
            .build();
            exception.getMessage()  
    public void testValidateIngestionSourceSettingsDeleteAndCreateValueSame() {
            new Environment(Settings.builder().put("path.home", "dummy").build(), null),  
            .build();
            .metadata(Metadata.builder().build())
        try (
    public void setup() throws Exception {
                    NamedXContentRegistry.EMPTY,
        // Verify the creation date is set to current time (within reasonable bounds)
            final List<String> validationErrors = checkerService.getIndexSettingsValidationErrors(ilnSetting, true, Optional.empty());  
        Settings indexSettings = Settings.builder()
                .put("index.non_copyable.request", "request")
    public void testRemoteStoreDisabledByUserIndexSettings() {  
    public void testBackwardCompatibility() throws Exception {  
            ),
            new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE))  
        BlobStoreRepository repositoryMock = mock(BlobStoreRepository.class);
        }
                null,
    private void runPrepareResizeIndexSettingsTest(  
    }
        // All mappings should now have disable_objects=true due to override logic
            );
        MetadataCreateIndexService.validateIngestionSourceSettings(settings, state);
            + "    \"properties\": {\n"
        ClusterState clusterState = clusterStateWithSegmentsOnlyNode();
            indexSettingsBuilder,  
            .settings(settings(Version.CURRENT))  
        assertEquals("lucene", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(aggregated));
        ).build();  
                indicesServices,  
            remoteStoreSettings,  
            clusterSettings
        for (Map<String, Object> mapping : v2ResultList) {
            repositoriesServiceSupplier
            Version.CURRENT
        DiscoveryNode oldNode = new DiscoveryNode("old_node", buildNewFakeTransportAddress(), emptyMap(), roles, Version.V_3_5_0);  
        IndexCreationException exception = expectThrows(
    }  
            () -> checkerService.validateIndexSettings("test", indexSettings, false)
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,  
        consumer.accept(indexSettingsBuilder.build());
            attributes,
        "Validation Failed: 1: index setting [index.replication.type] is not allowed to be set as [cluster.index.restrict.replication.type=true];";
    }
        }  
    /**
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");  
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test").context(new Context(randomAlphaOfLength(5)));
        requestSettings.put(IndexMetadata.SETTING_CREATION_DATE, requestCreationDate);
                request.index(),
     */
                    "source",
            @SuppressWarnings("unchecked")  
        // Convert template strings to CompressedXContent  
            @SuppressWarnings("unchecked")
        Mockito.when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
                        .endObject()
        final Settings.Builder requestSettings = Settings.builder();  
        }
import java.util.UUID;
            + "      \"index.merge.policy\": \"log_byte_size\",\n"
            clusterSettings  
        // Test 3: No disable_objects scenario
                Settings.EMPTY,
        Settings.Builder indexSettingsBuilder = Settings.builder().put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false);  
    public void testNumberOfRoutingShardsShowsInIndexSettings() {
            Settings.EMPTY,
        });
            + MapperService.SINGLE_MAPPING_NAME
            Map<String, Object> mapping = complexResult.get(i);
    }  
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)  
        + REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
     * An index created on segments-only nodes must be remote-backed for segments and must carry no translog
        assertEquals("parquet", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(out));
        BlobStore blobStoreMock = mock(BlobStore.class);
        final Settings.Builder requestSettings = Settings.builder();  
        MetadataCreateIndexService.updatePluggableDataFormatSettings(indexSettingsBuilder, cs, "test-index");
        Settings settings = Settings.builder()  
import org.opensearch.index.remote.RemoteStoreUtils;
            clusterState,  
            @SuppressWarnings("unchecked")  
        );
        Settings clusterBag = Settings.builder()
            randomIntBetween(0, 10),
        long epochCreationDate = 0L;  
                assertEquals("Request mapping should inherit object settings from template", expected, actual);
        nullMappings.add(validMapping);
            return new CompressedXContent(mapping);
        IndexTemplateMetadata templateMetadata = addMatchingTemplate(templateBuilder -> {
        // Test 2: Realistic V2 template integration scenario  
            .put(IndicesService.CLUSTER_RESTRICT_PLUGGABLE_DATAFORMAT_SETTING.getKey(), true)
            randomShardLimitService(),  
            .put(IndicesService.CLUSTER_RESTRICT_PLUGGABLE_DATAFORMAT_SETTING.getKey(), true)
            clusterState,  
        });
                            .numberOfShards(1)
            // Check deprecations
            clusterSettings  
        clusterSettings = null;
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), true)
        List<String> validationErrors = checkerService.getIndexSettingsValidationErrors(settings, false, Optional.empty());
                    "source",  
        Settings clusterBag = Settings.builder()  
        String logTemplate = "{\n"
                clusterService,  
                    "target",
        DiscoveryNode remoteDataNode = getRemoteNode();
    }
            Collections.singletonList(templateMetadata.mappings()),
        );  
import org.opensearch.cluster.ClusterName;
            + "      }\n"
            "index [source] already exists",  
        Settings aggregatedSettings = aggregateIndexSettings(
        clusterSettings.applySettings(clusterState.metadata().settings());  
        final Settings requestSettings,
        // This checks that aggregateIndexSettings works for the case when the index setting `index.refresh_interval`
                    "target",  
    public void testClusterStateCreateIndex() {
            final List<String> validationErrors = checkerService.getIndexSettingsValidationErrors(  
                randomShardLimitService(),
        ClusterState state = createClusterState(
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            null,
        );
            "true",
        // Test 1: Basic template with disable_objects
        }  
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            .put("index.analysis.analyzer.default.tokenizer", "keyword")  
            settings -> {
     * After merging, @fields should retain both the dynamic:true/type:object settings AND
        Settings settings = Settings.builder().put("node.attr.remote_store.segment.repository", "my-segment-repo-1").build();
        // ValidationException. The exception must propagate out of aggregateIndexSettings unchanged so
    public void testValidateDotIndex() {
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
                repositoriesServiceSupplier  
        for (Map<String, Object> mapping : mixedResult) {
                if (mappingDisableObjects != null) { // Only check mappings that have _doc sections  
                assertEquals(componentTemplate.get().template(), template);
            );
            "no such index [no_such_index]",
            null,  
        Settings clusterBag = Settings.builder()
        );
        request.settings(requestSettings.build());  
        requestSettings.put(INDEX_STORE_TYPE_SETTING.getKey(), RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT);
        do {
    public void testRemoteStorePathTypeForSegmentsOnlyNode() {
        // Test that default behavior still works when creation_date is not provided  
            indexSettings,  
        assertThat(parsedMappings, hasKey(MapperService.SINGLE_MAPPING_NAME));
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a, b")
     */  
        Settings indexSettings = Settings.builder()
        assertEquals("Should extract disable_objects value correctly", true, result);
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
        request.settings(matching);
            when(metadata.componentTemplates()).thenReturn(Map.of(contextName, componentTemplate.get()));  
        );  
        clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            DefaultRemoteStoreSettings.INSTANCE,
    public void testV1RequestMappingInheritsObjectSettingsFromTemplate() throws Exception {
                null,
                ResourceAlreadyExistsException.class,
        );  
                null,
            + "        }\n"  
    }
        verifyRemoteStoreIndexSettings(indexSettings, null, null, null, ReplicationType.DOCUMENT.toString(), null);
        IndexMetadata indexMetadata = IndexMetadata.builder(name)
            null,
            Settings.EMPTY,
        String requestMapping = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{\"field3\":{\"type\":\"long\"}}}}";
                Collections.emptySet(),  
            .settings(settings(Version.CURRENT).put(SETTING_READ_ONLY, true))
        }
            "source",
                randomShardLimitService(),
        when(clusterService.state()).thenReturn(clusterState);
                "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{\"field1\":{\"type\":\"text\"}}}}",
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
    public void testValidateIngestionSourceSettingsPartitionStrategySimpleOnCurrentVersion() {  
        );
        assertTrue(e.getMessage().contains("mapper_type [field_mapping] requires all nodes"));
                        Locale.ROOT,
        );  
        mapping1.put(MapperService.SINGLE_MAPPING_NAME, doc1);
    public void testParseMappingsWithTypedTemplate() throws Exception {
    @LockFeatureFlag(APPLICATION_BASED_CONFIGURATION_TEMPLATES)
    public void testValidateIndexSettings() {
            .put("index.version.created", Version.CURRENT)
        Object resultNullMapping = extractDisableObjectsValue(null);
            .put(IndicesService.CLUSTER_RESTRICT_PLUGGABLE_DATAFORMAT_SETTING.getKey(), true)
        List<Map<String, Object>> result = MetadataCreateIndexService.collectV2Mappings(
        Settings aggregatedIndexSettings = aggregateIndexSettings(  
            attributes,
        );
            v2DisableObjects
                IllegalArgumentException.class,
    public void testClusterForceReplicationTypeInAggregateSettings() {
        );
        );  
        if (randomBoolean()) {
        assertEquals(
    public void testCreateIndexWithContextAbsent() throws Exception {
        Settings aggregatedIndexSettings = aggregateIndexSettings(  
            "Setting [index.routing.allocation.total_primary_shards_per_node] or [index.routing.allocation.total_remote_capable_primary_shards_per_node] can only be used with remote store enabled clusters",  
            MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
        Settings.Builder indexSettingsBuilder = Settings.builder();
                    put(1L, contextName);  
            consumer.accept(clusterService, threadPool);  
    public void testRemoteStoreOverrideSegmentRepoIndexSettings() {
        checkerService.validateIndexSettings("test", indexSettings, false);  
                + "\"field2\":{\"type\":\"text\",\"store\":false}"  
                Collections.emptySet(),
            "the number of source shards [10] must be less that the number of target shards [5]",
            assertThat(validationErrors.size(), is(1));  
        MetadataCreateIndexService.applyDisableObjectsOverrides(mappings);  
    public void testClusterStateCreateIndexWithMetadataTransaction() {  
     */
            ).getMessage()
            randomShardLimitService(),  
            Collections.emptySet(),  
        assertEquals(expectedValue, customData.get(expectedKey));
        Settings indexSettings = aggregateIndexSettings(
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            Settings.EMPTY,  
            .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 3)  
        );
            .settings(Settings.builder().put("index.version.created", Version.CURRENT).build())
            null,  
            ClusterState.EMPTY_STATE,
            + "  \""
        );
            .putAlias(AliasMetadata.builder("alias1").writeIndex(true).build())
            assertTrue(
        // Process with V1 method  
            null,
import org.opensearch.ExceptionsHelper;
        Map<String, Object> validMapping = new HashMap<>();  
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(newNode("node1")).add(oldNode).build();
        request.settings(Settings.builder().put("requestSetting", "requestValue").build());
        // Serialize result to JSON and compare against expected merged output
        IndexTemplateMetadata templateMetadata = addMatchingTemplate(builder -> {
import static org.opensearch.node.Node.NODE_ATTRIBUTES;  
            null,
        attributes.put(REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY, "my-translog-repo-1");
        ClusterState state = createClusterState(
import static org.hamcrest.Matchers.hasKey;
        Map<String, Object> result = MetadataCreateIndexService.parseV1Mappings(requestMapping, templates, NamedXContentRegistry.EMPTY);
        indexSettings = aggregateIndexSettings(
        request.settings(requestSettings.build());  
        Settings indexSettings = aggregateIndexSettings(
            Map<String, Object> doc = (Map<String, Object>) docObj;
            randomBoolean(),
        MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
     * disable_objects behavior for the same input templates and request mapping.  
    }
        Mockito.when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
            .build();
                    targetSettings
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");  
import org.opensearch.ResourceAlreadyExistsException;
        }  
                    allMappings.get(1)
        final int maxMergeCount = randomIntBetween(1, 16);
import static org.opensearch.index.IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING;
            new SystemIndices(Collections.emptyMap()),
            "true",
            "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{}}}",  
            Settings.EMPTY,
        request.settings(requestSettings.build());
        );
        Settings settings = Settings.builder().build();
        );
        Settings settings = Settings.builder()
            )
            clusterSettings
            MetadataCreateIndexService checkerService = new MetadataCreateIndexService(  
            strictClusterSettings,
            ClusterState.EMPTY_STATE,  
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(newNode("node1")).build();
            + "    \"settings\": {\n"
import org.opensearch.common.compress.CompressedXContent;  
        request.settings(requestSettings.build());  
    public void testRemoteStoreNoUserOverrideIndexSettings() {  
                + "}}}"  
            emptyList(),  
                    "dynamic": "true",
            randomShardLimitService(),
    }  
            Settings.EMPTY,
                        {
            ClusterSettings.BUILT_IN_CLUSTER_SETTINGS
            new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE))  
            ).getMessage()
        Map<String, Object> doc = (Map<String, Object>) parsedMappings.get(MapperService.SINGLE_MAPPING_NAME);  
        Map<String, Object> validDoc = new HashMap<>();
        );  
            request,
            .put(SETTING_VERSION_CREATED, Version.CURRENT)  
        // Test case 1: Empty template list  
                )
import org.opensearch.threadpool.ThreadPool;
                Collections.emptySet(),
                Settings.EMPTY,
        IndexMetadata newIndex = IndexMetadata.builder("test")  
                Settings.EMPTY,  
        validDoc.put("disable_objects", true);
            clusterService,
                    threadPool,
        BlobStoreRepository repositoryMock = mock(BlobStoreRepository.class);
                    "target",
            new Environment(Settings.builder().put("path.home", "dummy").build(), null),
        IllegalArgumentException e = expectThrows(
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)  
            clusterSettings
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY;
            indexName
    }
package org.opensearch.cluster.metadata;
            assertEquals("V2 should apply request mapping disable_objects=true to all mappings", true, v2DisableObjects);
            "index [source] already exists",  
        routingTableBuilder.addAsNew(metadata.index(name));
            Settings.EMPTY,  
        assertThat(aggregatedIndexSettings.get(SETTING_NUMBER_OF_REPLICAS), equalTo("4"));
        attributes.put(REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, segmentRepositoryName);
    public void testCreateIndexWithNegativeCreationDate() {
        routingTable = OpenSearchAllocationTestCase.startInitializingShardsAndReroute(service, clusterState, "source").routingTable();  
    }  
                "cannot create index with index setting \"index.store.type\" set to \"remote_snapshot\". Store type can be set to \"remote_snapshot\" only when restoring a remote snapshot by using \"storage_type\": \"remote_snapshot\""  
                    clusterService,  
        Settings clusterSettingsSetting = Settings.builder()  
    }
        // index.store.type is set to remote_snapshot
    private ShardLimitValidator randomShardLimitService() {
        Settings clusterBag = Settings.builder()
            ClusterState.EMPTY_STATE,
            null,  
            null,
            @SuppressWarnings("unchecked")  
        final Settings.Builder requestSettings = Settings.builder();  
        assertTrue("Creation date should be >= beforeCreation", actualCreationDate >= beforeCreation);  
        // adds alias from new index to existing index
import static org.opensearch.cluster.metadata.MetadataCreateIndexService.getIndexNumberOfRoutingShards;
            randomShardLimitService(),  
        // Additional validation: ensure all mappings in V2 result have consistent disable_objects
            ClusterState.EMPTY_STATE,
            .put(SETTING_NUMBER_OF_REPLICAS, 0)
                repositoriesServiceSupplier  
                ClusterState.EMPTY_STATE,  
    }  
            );
        ClusterSettings clusterSettings = new ClusterSettings(  
     * Tests that V1 template merging correctly handles request mapping overriding template
import org.opensearch.cluster.service.ClusterService;
    private DiscoveryNode getRemoteNode() {  
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        Settings.Builder indexSettingsBuilder = Settings.builder()
            .build();  
            Settings.EMPTY,
            () -> true,
        do {
                + "}}}"
import static java.util.Collections.emptyList;  
        ClusterState finalClusterState = ClusterState.builder(ClusterName.DEFAULT).nodes(finalDiscoveryNodes).build();
        CompressedXContent template2 = new CompressedXContent(
        List<Map<String, Object>> mixedResult = MetadataCreateIndexService.collectV2Mappings(
                randomShardLimitService(),  
        Map<String, String> finalCustomData = imdBuilder.build().getCustomData().get(IndexMetadata.REMOTE_STORE_CUSTOM_KEY);  
            Collections.emptySet(),  
            indexSettings,  
        assertThat(aggregatedIndexSettings.get("templateSetting"), is(nullValue()));  
        request.settings(mismatch);
import org.opensearch.indices.RemoteStoreSettings;
        assertTrue(e.getMessage().contains("index.ingestion_source.source_partition_strategy requires all nodes"));
        );
import static org.opensearch.cluster.metadata.MetadataCreateIndexService.resolveAndValidateAliases;
        // All mappings should now have disable_objects=true (from the last template)
        int x = source / target;
        final Settings.Builder settings = Settings.builder();
            "index [source] already exists",
            .put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), clusterMinRefreshTime)
            Collections.emptySet(),
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.getRemoteStoreSegmentRepo;
                "index?name",
        routingTable = OpenSearchAllocationTestCase.startInitializingShardsAndReroute(service, clusterState, "source").routingTable();
        List<AliasMetadata> aliases = singletonList(AliasMetadata.builder("alias1").build());
            Version.CURRENT  
                IllegalArgumentException.class,
    }
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            .put(RemoteStoreSettings.CLUSTER_SERVER_SIDE_ENCRYPTION_ENABLED.getKey(), true)
        assertTrue(e.getMessage().contains("cannot be the same"));
                    .contains("Cannot apply context template as user provide settings have overlap with the included context template")
                Settings.EMPTY,  
                    String.format(
            attributes,  
            NamedXContentRegistry.EMPTY
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        );  
            .build();
        assertThat(validationErrors.size(), is(0));  
        Object v2DisableObjects = null;  
    private static Map<String, String> getNodeAttributes() {
            ClusterState.EMPTY_STATE,
                );
            settings,  
            )  
            .build();  
            .put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 2)
                ClusterState.EMPTY_STATE,
            Collections.emptySet(),
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
        Map<String, Object> v1Result2 = MetadataCreateIndexService.parseV1Mappings(requestMapping2, templateMappings2, xContentRegistry());
                        .startObject(MapperService.SINGLE_MAPPING_NAME)  
        assertEquals(Integer.valueOf(2), INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.get(indexSettings));  
                        }
        repositoriesService = mock(RepositoriesService.class);
        when(repositoriesService.repository(getRemoteStoreTranslogRepo(settings))).thenReturn(repositoryMock);  
        @SuppressWarnings("unchecked")
        assertThat(aggregatedIndexSettings.get(SETTING_NUMBER_OF_SHARDS), equalTo("15"));
            new AwarenessReplicaBalance(settings, clusterService.getClusterSettings()),  
    }
                Optional.empty()  
        Settings settings = Settings.builder().put(translogRepositoryNameAttributeKey, "my-translog-repo-1").build();
                threadPool,  
            EmptySnapshotsInfoService.INSTANCE
            xContentRegistry()
            aliasValidator,  
            request,
        assertThat(
                is(
                "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":false,\"properties\":{}}}",
        @SuppressWarnings("unchecked")  
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;  
                new Environment(Settings.builder().put("path.home", "dummy").build(), null),
        // Set index setting replication type as DOCUMENT
            null,
        assertEquals(ReplicationType.SEGMENT.toString(), indexSettings.get(SETTING_REPLICATION_TYPE));  
                        v2DisableObjects,  
                    XContentFactory.jsonBuilder()
        IndexTemplateMetadata templateMetadata = addMatchingTemplate(
     * Covers: default mapping merge behavior, V1 functionality preservation, V2 template integration
        int numShards = randomIntBetween(1, 42);
        attributes.put(REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "my-cluster-rep-1");
            Collections.emptySet(),
        );
        );  
            DefaultRemoteStoreSettings.INSTANCE,  
            metadataTransformer
        assertEquals(  
            assertThat(validationErrors.size(), is(0));
            allocationRerouted.compareAndSet(false, true);
            templateMappings,
        final ClusterState clusterState = ClusterState.builder(routingTableClusterState).routingTable(routingTable).build();  
            null,
                NamedXContentRegistry.EMPTY,  
                    "source",
            null,
            IndexCreationException.class,  
import java.util.function.Consumer;
            + "  },\n"  
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();  
            indexSettings,  
                randomShardLimitService(),
        assertThat(indexMetadata.getAliases().size(), is(1));
        }
        List<CompressedXContent> templateMappings3 = Arrays.asList(new CompressedXContent(template3a), new CompressedXContent(template3b));
    /**  
            null,  
            UUIDs.base64UUID(),
        Settings aggregatedIndexSettings = aggregateIndexSettings(
            .put(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "my-custom-repo");
        if (docObj instanceof Map) {  
    }  
        MetadataCreateIndexService.updateRemoteStoreSettings(  
                    createClusterState("source", 8, randomIntBetween(0, 10), Settings.builder().put("index.blocks.write", true).build()),  
                DefaultRemoteStoreSettings.INSTANCE,
            Settings.EMPTY,
            .build();
        int targetRoutingNumberOfShards = getIndexNumberOfRoutingShards(indexSettings, null);  
            settings,
            Collections.emptySet(),
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()  
            .build();  
        // The invalid pairing on purpose: remote store on, document replication.
        Translog.Durability durability = randomFrom(Translog.Durability.values());
            builder.settings(Settings.builder().put(IndexMetadata.SETTING_CREATION_DATE, templateCreationDate));
     * Returns null if disable_objects is not present.
            return doc.get("disable_objects");  
        );
        // Case 2 - cluster.remote_store.index.path.prefix.optimised=fixed (default value)
                new DiscoveryNode(  
            () -> MetadataCreateIndexService.validateIngestionSourceSettings(settings, state)
 *
        // see: https://github.com/opensearch-project/OpenSearch/issues/1019  
        Settings indexSettings = Settings.builder()
            Collections.emptySet(),
                Settings.builder().put("node.attr.remote_store.segment.repository", "test").build(),  
                clusterService,  
            new CompressedXContent(templateWithDisableObjects)
                null,
        // verify that the message is as expected
        DiscoveryNode oldNode = new DiscoveryNode("old_node", buildNewFakeTransportAddress(), emptyMap(), roles, Version.V_3_5_0);
        assertEquals("Should have 3 mappings (2 templates + 1 request)", 3, result.size());
                ClusterState.EMPTY_STATE,
            }
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "lucene")
            cs  
        );  
        IllegalArgumentException e = expectThrows(  
            randomShardLimitService(),
                null,
                {
            .put(CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING.getKey(), true)
     * translog nor a cluster state repository.
            IllegalArgumentException.class,
        });
        Settings indexSettings = Settings.builder()
            withTemporaryClusterService((clusterService, threadPool) -> {  
        Settings aggregatedIndexSettings = aggregateIndexSettings(
                indexSettings,
        IndexMetadata.Builder imdBuilder = IndexMetadata.builder("test").settings(indexSettings);  
        CompressedXContent template1 = new CompressedXContent(
            templateMappings,  
        assertThat(resolvedAliases.get(0).getSearchRouting(), equalTo("fromRequest"));
        assertThat(mappingsProperties, hasKey("mapping_from_template"));
     * restore's override-settings step, where restoring a remote-store snapshot onto a document-replication index is a  
            )
        );
    }
            .build();  
            Collections.emptySet(),
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
        // Primary override is preserved; value still stamped from the cluster default.
            .numberOfShards(1)
    public void testValidateIngestionSourceSettingsPartitionStrategyOnMixedClusterRejected() {
    private ClusterState createClusterState(String name, int numShards, int numReplicas, Settings settings) {
        checkerService.addRemoteStoreCustomMetadata(imdBuilder, false, clusterState);  
            null,
        );
    /**
        TimeValue indexRefreshTime = TimeValue.timeValueMillis(clusterMinRefreshTimeMs - randomIntBetween(1, clusterMinRefreshTimeMs - 1));
            Settings.EMPTY,
                null,
        // Set index setting refresh interval the same value as the cluster minimum refresh interval  
        // Extract disable_objects values
            expectThrows(
    final String REPLICATION_MISMATCH_VALIDATION_ERROR =
            requestMapping,
        List<Map<String, Object>> result4 = MetadataCreateIndexService.collectV2Mappings(
                requestSettings.build(),
            IllegalArgumentException.class,
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    public void testValidatePluggableDataFormatNoopWhenFeatureFlagDisabled() {  
            .build();  
            new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
            indexMetadata.getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY),
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");
            Settings.EMPTY,
                  "@fields": {
            .put(RemoteStoreSettings.CLUSTER_SERVER_SIDE_ENCRYPTION_ENABLED.getKey(), true)
            .build();
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(oldNode).build();
                "index name [.test2] starts with a dot '.', in the next major version, index "
            PathHashAlgorithm.NAME,
        request.settings(Settings.builder().put("key1", "requestValue").build());  
    }  
    public void testValidateIngestionSourceSettingsPartitionStrategyAbsentOnMixedClusterPasses() {
        when(blobStoreMock.isBlobMetadataEnabled()).thenReturn(randomBoolean());
                new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
            .put(SETTING_NUMBER_OF_REPLICAS, 2)
            .put("index.ingestion_source.mapper_settings.op_type_field", "is_deleted")  
            DefaultRemoteStoreSettings.INSTANCE,
    }
import static org.opensearch.index.IndexSettings.INDEX_REFRESH_INTERVAL_SETTING;
        Settings mismatch = Settings.builder().put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "lucene").build();  
        Settings settings = Settings.builder().build();  
            );  
            randomShardLimitService(),  
            .build();  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;
    public void testSoftDeletesDisabledIsRejected() {
                )  
import org.opensearch.test.gateway.TestGatewayAllocator;
        request.settings(requestSettings.build());
                true,  
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")  
            .put("index.version.created", Version.CURRENT)
import java.util.function.BiFunction;
                .put("index.blocks.write", (String) null)
                            }
        assertEquals(  
import org.junit.After;  
        // `index.refresh_interval` in the cluster state update request.  
     * Template B (higher priority) defines a specific sub-field @fields.userstate as keyword.
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
        AtomicReference<ComponentTemplate> componentTemplate = new AtomicReference<>();
        assertFalse(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.exists(out));  
            .putAlias(AliasMetadata.builder("alias1").writeIndex(true).build())
            assertTrue(ratio <= 1024);
            templateBuilder.putAlias(AliasMetadata.builder("alias1"));  
        final RoutingTable initialRoutingTable = service.reroute(initialClusterState, "reroute").routingTable();  
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)  
    }  
import java.util.function.Supplier;  
            "the number of source shards [8] must be a multiple of [3]",
            + "    }\n"
        return indexMetadata;
                    "properties": {  
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)  
            repositoriesServiceSupplier
        String requestWithDisableObjects = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":false,\"properties\":{}}}";  
            additionalIndexScopedSettings.stream()
        request.settings(requestSettings.build());
                is(String.format(Locale.ROOT, "private index setting [%s] can not be set explicitly", SETTING_REMOTE_STORE_ENABLED))  
            createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
        runPrepareResizeIndexSettingsTest(
                        }  
        int numShards = randomIntBetween(2, 42);
 * under the License.  
            emptyList(),
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,  
                indicesServices,
        });  
            componentTemplate.set(ComponentTemplate.parse(contentParser));  
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,  
        targetRoutingNumberOfShards = getIndexNumberOfRoutingShards(indexSettings, null);
            return clusterState;  
import org.opensearch.repositories.blobstore.BlobStoreRepository;  
    public void testAggregateIndexSettingsIgnoresTemplatesOnCreateFromSourceIndex() throws Exception {
            .build();  
        assertThat(aggregatedIndexSettings.get(SETTING_NUMBER_OF_REPLICAS), equalTo("2"));
        // Test 1: Basic V2 collectV2Mappings with disable_objects override logic  
import org.opensearch.common.xcontent.json.JsonXContent;  
            aggregateIndexSettings(
        );
        // Test case where setting is used without remote store (should fail)
        MetadataCreateIndexService.validateIngestionSourceSettings(settings, state);
        );  
        } else {
            .put(IndexMetadata.SETTING_INGESTION_SOURCE_MAPPER_TYPE, "field_mapping")  
            nodeSettings,
        // No exception, no stamping — the index is left alone.
                IllegalStateException.class,
                            "properties": {
            .putAlias(AliasMetadata.builder("alias1").writeIndex(true).build())
     */
                "properties": {
        assertThat(alias.writeIndex(), is(true));
        );  
                + "\"field2\":{\"type\":\"keyword\",\"store\":true}"
                threadPool,
        Metadata metadata = metaBuilder.build();
                randomShardLimitService(),
        Map<String, String> remoteCustomData = imdBuilder.build().getCustomData().get(IndexMetadata.REMOTE_STORE_CUSTOM_KEY);
        BiConsumer<Metadata.Builder, IndexMetadata> metadataTransformer = (builder, indexMetadata) -> {  
            .put(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey(), 2)
        requestSettings.put(INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC);
        final Setting<String> nonCopyableExistingIndexSetting = Setting.simpleString(
        CompressedXContent templateMapping = createMapping("test", "text");
            settings,  
        requestSettings.put(SETTING_REMOTE_STORE_ENABLED, false);
        assertThat((Map<String, Object>) mappingsProperties.get("test"), hasValue("keyword"));
            clusterSettings
            "source",
        assertThat(mappings, Matchers.hasKey(MapperService.SINGLE_MAPPING_NAME));
            "true",
            () -> MetadataCreateIndexService.validateIngestionSourceSettings(settings, state)  
        MetadataCreateIndexService metadataCreateIndexService = new MetadataCreateIndexService(
            createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),  
                clusterSettings  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;  
            null,
        requestSettings.put(INDEX_REFRESH_INTERVAL_SETTING.getKey(), indexRefreshTime);  
        withTemporaryClusterService(((clusterService, threadPool) -> {
            assertThat(settings.get("index.allocation.max_retries"), nullValue());  
            false,  
              }  
            IllegalArgumentException.class,  
            expectThrows(  
        runPrepareResizeIndexSettingsTest(
            indexSettingsBuilder.put("index.allocation.max_retries", randomIntBetween(1, 1000));  
            )
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone, rack")
        ClusterService clusterService = mock(ClusterService.class);
            Collections.emptySet(),  
        // Templates are processed in order: template2 (order 1) first, then template1 (order 0)
        aggregateIndexSettings(  
     */
                    "target",
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
        threadPool.shutdown();
        MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
                Settings.builder().put("index.blocks.write", true).put("index.number_of_routing_shards", targetShards).build()  
    }  
                )
        when(clusterService.state()).thenReturn(clusterState);  
        final Set<DiscoveryNodeRole> roles = Collections.unmodifiableSet(  
        final IndexCreationException error = expectThrows(IndexCreationException.class, () -> {
        );
        );  
            attributes,
                    Settings.builder().put("index.number_of_shards", 3).build()  
            addMatchingTemplate(  
        MetadataCreateIndexService.validateShrinkIndex(
        Map<String, Object> result = MetadataCreateIndexService.parseV1Mappings("", templates, NamedXContentRegistry.EMPTY);
        Settings nodeSettings = Settings.builder().put("node.attr.remote_store.segment.repository", "my-segment-repo-1").build();
        final Version upgraded = versions.get(1);
                )
                + indexRefreshTime
    }  
            () -> aggregateIndexSettings(  
            + MapperService.SINGLE_MAPPING_NAME  
            "cluster-state-repo-1",
    @LockFeatureFlag(APPLICATION_BASED_CONFIGURATION_TEMPLATES)
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).build();
        List<Map<String, Object>> result3 = MetadataCreateIndexService.collectV2Mappings(  
            ResizeType.SHRINK,  
        when(repositoriesServiceSupplier.get()).thenReturn(repositoriesService);
        assertEquals("lucene", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(aggregated));
            Collections.emptySet(),  
            Collections.emptySet(),  
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
                assertThat(settings.getAsInt("index.merge.scheduler.max_thread_count", null), equalTo(maxThreadCount));  
                              }  
            getSegmentsOnlyNodeAttributes(),
        request.settings(settings.build());
        assertEquals(
        when(clusterService.state()).thenReturn(clusterState);
            null,
        final Set<DiscoveryNodeRole> roles = Collections.unmodifiableSet(
            .put(INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.DOCUMENT)  
        assertThat(targetRoutingNumberOfShards, is(9));
import static org.opensearch.index.IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING;  
        IndexMetadata newIndexMetadata = IndexMetadata.builder("test")
        );
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "rack.values", "c, d, e")  
            Collections.singletonList(basicTemplate.getMappings()),  
                        "All V2 mappings with _doc sections should have consistent disable_objects values after override processing",
        // Case 3 - cluster.remote_store.index.path.prefix.optimised=hashed_prefix
    public void testFencingDefaultStampDoesNotValidateReplicationTypeCompatibility() {
            request,
            expectThrows(  
     * combination the restore path itself has to reject with a {@code SnapshotRestoreException}. Reading the setting
            + "}";
            "{\""
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            randomShardLimitService(),
            new SystemIndices(Collections.emptyMap()),
    public void testValidateIngestionSourceSettingsPartitionStrategyOnCurrentVersion() {
                null,
            ClusterState mockState = mock(ClusterState.class);  
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "lucene")
        assertTrue("V1 result should contain field3", v1Properties.containsKey("field3"));  
        assertThat(mappingsProperties, hasKey("test"));
    }  
            currentClusterState,
            nodeSettings,
            Set.of(INDEX_READ_ONLY_BLOCK),
        assertNotNull(finalCustomData);
            .settings(Settings.builder().put("index.version.created", Version.CURRENT).build())
        ClusterSettings clusterSettings = new ClusterSettings(nodeSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                Settings.EMPTY,
            } catch (IOException e) {  
        });
        return new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), emptyMap(), roles, Version.CURRENT);
        final Settings.Builder requestSettings = Settings.builder();  
            + "    \"_version\": 1\n"
            .build();
            .put("index.version.created", Version.CURRENT)
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING;
            null  
            new BalancedShardsAllocator(Settings.EMPTY),
            .build();  
            ClusterState.EMPTY_STATE,
                  "@fields": {  
            Settings.EMPTY,
        // Test the extractDisableObjectsValue utility method
        BlobStore blobStoreMock = mock(BlobStore.class);
                    createClusterState("source", 1, 0, Settings.builder().put("index.blocks.write", true).build()),
        for (Map<String, Object> mapping : result4) {
            ).getMessage()
    }  
                threadPool,
        // Test creating an index with creation_date set to 0 (epoch time)
        Settings indexSettings = Settings.builder()  
            + "  \"template\": {\n"
                () -> MetadataCreateIndexService.validateSplitIndex(
        );
        CreateIndexClusterStateUpdateRequest request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");  
            clusterSettings
            createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
import java.util.HashSet;
        IndexMetadata sourceIndexMetadata = IndexMetadata.builder("parent")
        String requestMapping4 = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{}}}";  
        assertEquals(768, MetadataCreateIndexService.calculateNumRoutingShards(3, Version.CURRENT));  
        BlobStore blobStoreMock = mock(BlobStore.class);
        );  
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        assertNotNull(aggregated);
            xContentRegistry()
        String replicationType,
                null,  
    }
        assertThat(parsedMappings, hasKey(MapperService.SINGLE_MAPPING_NAME));
        Settings indexSettings = aggregateIndexSettings(
                throw new RuntimeException(e);
        when(clusterService.getSettings()).thenReturn(settings);
    }
                Settings.EMPTY,
            null,  
    public void testValidateSplitIndex() {
        BlobStore blobStoreMock = mock(BlobStore.class);  
                + "or better performance, or other file systems instead."  
        final Set<Setting<?>> settingsSet = Stream.concat(  
                null,
            indicesServices,  
        // This checks that aggregateIndexSettings works for the case when the cluster setting
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
            );  
        assertTrue(clusterSettings.get(IndicesService.CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING));
    /**
import java.util.TreeMap;
        );  
        }  
        }
        }).collect(Collectors.toList());
            false,
        );  
        ThreadPool threadPool = new TestThreadPool(getTestName());
            request,
            "fencing default should still be stamped for a remote-store index",
        return source * x == target;  
        );
    public void testRemoteStoreImplicitOverrideReplicationTypeToSegmentForRemoteStore() {
            )
    }
            randomShardLimitService(),  
        Settings aggregatedIndexSettings = aggregateIndexSettings(
        );  
        );
     * Covers: basic template usage, nested objects, multiple templates, and V1 parsing.
        Settings indexSettings = aggregateIndexSettings(  
            final String mapping = XContentFactory.jsonBuilder()
                }
                IllegalArgumentException.class,  
                          "_doc": {  
            xContentRegistry()
        assertFalse(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.exists(out));
        AtomicBoolean allocationRerouted = new AtomicBoolean(false);  
    public void testParseMappingsAppliesDataFromTemplateAndRequest() throws Exception {
    public void testValidatePluggableDataFormatAllowlistBypassesRestrict() {
        );  
        ClusterState clusterState = ClusterState.builder(  
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
        assertEquals("Later template should override disable_objects", true, multipleDoc.get("disable_objects"));  
            threadPool,  
                null,  
        Settings aggregated = aggregateIndexSettings(  
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                        .startObject("cpu.usage")  
     * Test for field property override behavior in parseV1Mappings.  
import static org.hamcrest.Matchers.containsString;
            null,  
        assertEquals("V1 should preserve request mapping disable_objects=false", false, v1DisableObjects2);
                randomShardLimitService(),
                    .settings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 12))
            null
            .put("index.ingestion_source.mapper_settings.op_type_field.create_value", "REMOVE")
                    Set.of(DiscoveryNodeRole.INGEST_ROLE, DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE, DiscoveryNodeRole.DATA_ROLE),
        Metadata metadata = Metadata.builder()  
            }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .startObject("properties")
        // Expect IllegalArgumentException  
            ClusterState.EMPTY_STATE,
            )
    private void validateV1V2Equivalence(List<String> templateMappingStrings, String requestMapping) throws Exception {
            settingsBuilder.put(NODE_ATTRIBUTES.getKey() + REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, "test");
                Settings.EMPTY,  
import java.util.List;
    }  
    }
            .put(CLUSTER_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
        assertEquals(1024, MetadataCreateIndexService.calculateNumRoutingShards(512, Version.CURRENT));
        when(repositoriesServiceSupplier.get()).thenReturn(repositoriesService);
            error.getMessage(),
            requestMapping4,
        );
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING;
        MetadataCreateIndexService.validateIngestionSourceSettings(settings, state);  
        Settings indexSettings = Settings.builder()
            4,
        final List<Version> versions = Arrays.asList(VersionUtils.randomVersion(random()), VersionUtils.randomVersion(random()));
        );
            settingsBuilder,
            .build();  
            null,  
    public void testPrepareResizeIndexSettingsSimilaritySettings() {
            templateMetadata.settings(),  
                mock(Environment.class),  
        assertTrue(e.getMessage().contains(Version.V_3_7_0.toString()));
        Settings aggregatedSettings = aggregateIndexSettings(
        List<CompressedXContent> templateMappings = templateMappingStrings.stream().map(s -> {
            .put(MIGRATION_DIRECTION_SETTING.getKey(), RemoteStoreNodeService.Direction.REMOTE_STORE)  
        int numShards = randomIntBetween(1, 42);
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
            clusterService,  
            Collections.emptySet(),
        Settings settings = Settings.builder().put(translogRepositoryNameAttributeKey, "my-translog-repo-1").build();
            randomShardLimitService(),
            Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FENCING_ENABLED.getKey(), true).build(),
                ExceptionsHelper.reThrowIfNotNull(e);
            createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),  
        when(blobStoreMock.isBlobMetadataEnabled()).thenReturn(randomBoolean());  
            null,
        Settings aggregatedIndexSettings = aggregateIndexSettings(
        IndexCreationException thrown = expectThrows(
            nodeSettings,  
            assertEquals("All mappings should have disable_objects=true", true, docMap.get("disable_objects"));  
    /**
                new IndexScopedSettings(ilnSetting, Collections.emptySet()),
                new SystemIndices(Collections.emptyMap()),
            Settings.EMPTY,
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
            .put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), refreshInterval)
    }
        assertEquals(
                + "\":{"
            createClusterState("source", numShards, 0, Settings.builder().put("index.blocks.write", true).build())
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");  
    /**  
        );
                createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),  
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
            indicesServices,
        when(clusterService.state()).thenReturn(clusterState);
        BlobStore blobStoreMock = mock(BlobStore.class);
        try (
        AtomicReference<ComponentTemplate> componentTemplate = new AtomicReference<>();
    public void testDisableObjectsOverrideLogic() throws Exception {  
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,  
        Settings clusterSettingsSetting = Settings.builder()
        // This checks that aggregateIndexSettings works for the case when the cluster setting  
        }
                new SystemIndices(Collections.emptyMap()),
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)  
        Settings.Builder settingsBuilder = Settings.builder().put(INDEX_REFRESH_INTERVAL_SETTING.getKey(), "30s");
        // Without the explicit source_partition_strategy setting, no metadata is replicated — old nodes are unaffected.  
    public void testAddRemoteStoreCustomMetadata_ForSnapshotRestore_WhenSSE_False() {
        );  
    private RepositoriesService repositoriesService;  
        ClusterService clusterService = mock(ClusterService.class);  
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test").context(new Context(contextName));
import org.hamcrest.Matchers;
            null,
        String contextName = randomAlphaOfLength(5);  
            "index.non_copyable.request",
                .endObject()
        validationErrors = checkerService.getIndexSettingsValidationErrors(settings, false, Optional.empty());
                          }
            Settings indexSettings = Settings.builder()  
            randomShardLimitService(),
        );  
    public void testAddRemoteStoreCustomMetadata_ForSnapshotRestore() {
            IllegalArgumentException.class,
                        .startObject("memory.used")  
     * This test validates the basic functionality of the comparison methods.
        IndexTemplateMetadata templateMetadata = addMatchingTemplate(builder -> {
            templateSettings,  
        );
            throw ExceptionsHelper.convertToRuntime(e);  
        assertThat(aggregatedIndexSettings.get(SETTING_NUMBER_OF_REPLICAS), equalTo("0"));  
            .build();
        IndexMetadata.Builder imdBuilder = IndexMetadata.builder("test").settings(indexSettings);
            // Check that patterns with wildcards work  
            null,
        Settings aggregated = aggregateIndexSettings(  
            EmptySnapshotsInfoService.INSTANCE
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
    public void testRequestDataHavePriorityOverTemplateData() throws Exception {  
    }
        Map<String, String> attributes = new HashMap<>();
            MetadataCreateIndexService checkerService = new MetadataCreateIndexService(
            Settings.builder()
            null,  
            .put("index.ingestion_source.mapper_settings.id_field", "user_id")
        templatesBuilder.put("template_1", templateMetadata);  
        );
                ClusterState.EMPTY_STATE,
            null,
            .build();  
            .metadata(metadata)
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        Settings clusterSettingsSetting = Settings.builder()  
                threadPool,  
        return target * x == source;  
            assertThat(validationErrors.size(), is(1));
            .put(IndexMetadata.SETTING_INGESTION_SOURCE_MAPPER_TYPE, "field_mapping")  
            true,
        noDisableObjectsMappings.add(mapping3);
        MetadataCreateIndexService.applyDisableObjectsOverrides(nullMappings);  
            + "  \"version\": 1\n"
            Map<String, Object> doc = (Map<String, Object>) mapping.get(MapperService.SINGLE_MAPPING_NAME);
                null,
    public void testPrepareResizeIndexSettingsCopySettings() {
            Metadata.builder().build(),
        validateV1V2Equivalence(  
        assertEquals(
    public void testAggregateIndexSettingsStampsPluggableDataFormatClusterDefaults() {  
        List<Map<String, Object>> complexResult = MetadataCreateIndexService.collectV2Mappings(
        mappings.add(mapping1);  
        Settings clusterBag = Settings.builder()
        Map<String, Object> doc3 = new HashMap<>();
        final Settings.Builder requestSettings = Settings.builder();  
            randomShardLimitService(),
    }
    public void testValidatePluggableDataFormatSettingsSkipsWhenIndexMatchesAllowlist() {
        CompressedXContent templateA = new CompressedXContent("""
        // Even the default value 'simple' set explicitly is rejected on a mixed cluster — the version  
            + "    \"properties\": {\n"
        assertEquals("field1 type should be from template1", "text", field1.get("type"));
import static org.opensearch.indices.IndicesService.CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING;  
                () -> MetadataCreateIndexService.validateSplitIndex(
            randomShardLimitService(),  
            ClusterState.EMPTY_STATE,
                ve.addValidationError(expectedError);
                .build(),
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
            new SystemIndices(Collections.emptyMap()),  
            assertThat(
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
            request,
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{\"field3\":{\"type\":\"long\"}}}}"
    private AliasValidator aliasValidator;
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_INGESTION_SOURCE_MAPPER_TYPE, "default").build();
        long customCreationDate = System.currentTimeMillis() - TimeValue.timeValueDays(7).millis();  
    /**
        IndexTemplateMetadata templateMetadata = addMatchingTemplate(
        Settings clusterBag = Settings.builder()
            "When the target routing number of shards is not specified the expected value is the configured number of shards "  
        assertEquals(REPLICATION_MISMATCH_VALIDATION_ERROR, exception.getCause().getMessage());  
                NamedXContentRegistry.EMPTY,
            validateIndexName(checkerService, "_indexname", "must not start with '_', '-', or '+'");
import java.util.Collection;  
                Collections.emptySet(),
            null,
        MetadataCreateIndexService.applyDisableObjectsOverrides(noDisableObjectsMappings);
        IndexCreationException exception = expectThrows(
    public void testAddRemoteStoreCustomMetadata_WhenSSEDisabled() {  
        final Settings forceClusterSettingDisabled = Settings.builder()  
            null,
                assertEquals("false", settingsBuilder.get(INDEX_SOFT_DELETES_SETTING.getKey()));
            REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,  
        request.settings(requestSettings.build());
        TimeValue refreshInterval = TimeValue.timeValueSeconds(10);  
        );  
        );  
        imdBuilder.putCustom(IndexMetadata.REMOTE_STORE_CUSTOM_KEY, remoteCustomData);  
            + "\":{\"disable_objects\":true,\"properties\":{\"field1\":{\"type\":\"text\"}}}}";
        String nullValue = null;  
            }
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();  
        Map<String, String> remoteCustomData = imdBuilder.build().getCustomData().get(IndexMetadata.REMOTE_STORE_CUSTOM_KEY);
            clusterState,
            Version.CURRENT
        routingTable = OpenSearchAllocationTestCase.startInitializingShardsAndReroute(service, clusterState, "source").routingTable();
        checkerService.addRemoteStoreCustomMetadata(imdBuilder, true, clusterState);
            clusterSettings
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                    );
     * Template A (lower priority) defines @fields as a dynamic object.  
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
                    .putAlias(AliasMetadata.builder("alias1").writeIndex(true).searchRouting("3").build())  
                ResourceAlreadyExistsException.class,
        ClusterState currentClusterState = ClusterState.builder(ClusterState.EMPTY_STATE)
            .build();  
            request,
            new SystemIndices(Collections.emptyMap()),
    public void testRefreshIntervalValidationSuccessWithIndexSettingGreaterThanClusterMinimum() {
            .put(SETTING_NUMBER_OF_SHARDS, 1)
                null,
        final Settings.Builder requestSettings = Settings.builder();
import org.opensearch.indices.InvalidIndexNameException;
        );
    public void testValidateIngestionSourceSettingsDeleteValueWithoutOpTypeField() {
            new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),  
        Settings aggregatedIndexSettings = aggregateIndexSettings(
            "expected validation error to contain [" + expectedError + "] but was [" + thrown.getCause().getMessage() + "]",
            null,  
        MetadataCreateIndexService.prepareResizeIndexSettings(
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).nodes(nodes).build();
        );
        Settings settings = Settings.builder()  
                builder.putMapping(
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a, b")
                    NamedXContentRegistry.EMPTY,
                    "properties": {  
            .nodes(DiscoveryNodes.builder().add(getRemoteNode()).build())  
                false,  
                null,
        // cluster.remote_store.index.restrict.async-durability is false or not set, it allows all types of durability modes
        // cluster.remote_store.index.restrict.async-durability is false or not set, it allows all types of durability modes
                null,
            PathType.HASHED_PREFIX.toString()
            settings,
                    new SystemIndices(Collections.emptyMap()),  
        request.settings(mismatch);
                null,  
            Metadata.builder().build(),
        Settings aggregated = aggregateIndexSettings(
        assertTrue(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(out));
     */  
    public void testValidatePluggableDataFormatRejectsEnabledMismatch() {
                new Environment(Settings.builder().put("path.home", "dummy").build(), null),
            randomShardLimitService(),  
                validationErrors.get(0),
            request,
        when(repositoryMock.blobStore()).thenReturn(mock(BlobStore.class));  
        // used as a value container, not for the concurrency and visibility guarantees
            null,  
            null
        // remote data node  
        attributes.put(REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, "my-segment-repo-1");  
        );
                null,
            }
            queryShardContext
     * inherits the object's type/dynamic settings from templates.
        List<Map<String, Object>> v2Result = MetadataCreateIndexService.collectV2Mappings(  
        // those nodes would receive replicated index metadata containing an unknown setting key.
        Metadata metadata = new Metadata.Builder().templates(templatesBuilder).build();
                )  
            .persistentSettings(Settings.builder().put(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey(), 2).build())
import org.opensearch.test.ClusterServiceUtils;
        // pipeline, so the effective values land in the settings returned by aggregateIndexSettings.
            .put("index.version.created", Version.CURRENT)  
        BiFunction<ClusterState, String, ClusterState> rerouteRoutingTable = (clusterState, reason) -> {
            .build();
            new CompressedXContent(metricTemplate)
 * specific language governing permissions and limitations
            threadPool.shutdown();
    }
              }  
        assertEquals("Should handle null mappings gracefully", true, resultDoc.get("disable_objects"));  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                + MapperService.SINGLE_MAPPING_NAME  
        assertThat(aggregatedIndexSettings.get(SETTING_NUMBER_OF_SHARDS), equalTo("1"));  
                                "properties": {
            assertTrue(checkerService.validateDotIndex(".test3", false));
            assertTrue(checkerService.validateDotIndex(".pattern-test-with-suffix", false));
        return clusterState;  
    }  
            .build();
            Settings.EMPTY,  
            } catch (IOException ex) {
            MetadataCreateIndexService checkerService = new MetadataCreateIndexService(  
            "V1 and V2 should produce equivalent disable_objects values. "
        final Map<String, IndexTemplateMetadata> templatesBuilder = new HashMap<>();
    }
        super.setUp();  
                IllegalStateException.class,  
            "my-segment-repo-1"  
            expectThrows(
        );  
    }
                );
            Arrays.asList(nonCopyableExistingIndexSetting, nonCopyableRequestIndexSetting),  
        final Settings.Builder requestSettings = Settings.builder();
            ReplicationType.SEGMENT.toString(),
        List<CompressedXContent> multipleTemplates = Arrays.asList(template1, template2);
     * This ensures that a request mapping defining only sub-fields of an object still
        requestSettings.put(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "my-custom-repo");
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
        final Collection<Setting<?>> additionalIndexScopedSettings,  
            }  
        mapping3.put(MapperService.SINGLE_MAPPING_NAME, doc3);
        List<AliasMetadata> resolvedAliases = resolveAndValidateAliases(
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,  
            Settings.EMPTY,
                request,
        List<CompressedXContent> templates = Arrays.asList(template2, template1);  
                null,
            + "      \"index.refresh_interval\": \"60s\"\n"
            randomShardLimitService(),
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
    }
            request.aliases(),  
                    }
        }));
        DiscoveryNode nonRemoteClusterManagerNode = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);
        // Index explicitly sets a different value — normally rejected, but allowlist bypasses it.
            .put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), clusterMinRefreshTime)
        final Settings.Builder requestSettings = Settings.builder();
    public void testIndexTemplateReplicationType() {
        String requestMapping = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{}}}";  
        // Test 3: Multiple templates with different values, request overrides all
            .build();  
            indicesServices,
        IndexCreationException exception = expectThrows(  
        }));
            ReplicationType.SEGMENT.toString(),
    }  
        );
    public void testUpdatePluggableDataFormatSettingsSkipsBothWhenAlreadySet() {
        );
import java.util.Collections;
        } finally {  
        withTemporaryClusterService(((clusterService, threadPool) -> {
            () -> resolveAndValidateAliases(  
        Settings settings = Settings.builder().put(translogRepositoryNameAttributeKey, "my-translog-repo-1").build();
    public void testCustomCreationDatePreservedInIndexMetadata() {
                      "userstate": { "type": "keyword" }
                Metadata.builder().build(),
     * while still inheriting non-conflicting object-level settings from templates.  
                                }
        Map<String, Object> parsedMappings = MetadataCreateIndexService.parseV1Mappings(
        doc2.put("properties", new HashMap<>());
        final Settings sourceSettings,
            clusterState,  
        Settings indexSettings = aggregateIndexSettings(  
                    Settings.builder().put("index.number_of_shards", 4).build()
                null,
                }
        ThreadPool threadPool = new TestThreadPool(getTestName());  
            // Remote store not enabled  
            + "          \"keyword\": {\"type\": \"keyword\", \"ignore_above\": 256}\n"
                    new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
                DefaultRemoteStoreSettings.INSTANCE,  
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(newNode("node1")).build();  
/*  
        withTemporaryClusterService((clusterService, threadPool) -> {
            ).getMessage()
        assertEquals(
        // field2 should have the complete definition from template2 (higher priority)
    /**
                    "source",
            randomShardLimitService(),
        when(repositoriesServiceSupplier.get()).thenReturn(repositoriesService);
            .metadata(metadata)
        final Setting<String> nonCopyableRequestIndexSetting = Setting.simpleString(  
                        mappingDisableObjects
                Collections.emptySet(),  
import org.opensearch.indices.ShardLimitValidator;  
        Map<String, Object> properties = (Map<String, Object>) doc.get("properties");
            validateIndexName(checkerService, "foo:bar", "must not contain ':'");
                threadPool,
            Settings.builder().put("index.number_of_shards", targetShards).build()  
                "must not contain the following characters " + org.opensearch.core.common.Strings.INVALID_FILENAME_CHARS  
            new AwarenessReplicaBalance(settings, clusterService.getClusterSettings()),
        requestSettings.put(IndexMetadata.SETTING_CREATION_DATE, futureCreationDate);
            Map<String, Object> actual = parser.map();
        MetadataCreateIndexService.validateCloneIndex(clusterState, "source", "target", targetSettings);  
        doc1.put("properties", new HashMap<>());
        // Case 1 - Remote store is not enabled
        assertThat(aggregatedIndexSettings.get(SETTING_NUMBER_OF_REPLICAS), equalTo("2"));  
            complexRequestMapping,
        request.settings(mismatch);  
            assertThat(settings.getAsVersion("index.version.upgraded", null), equalTo(upgraded));
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            Collections.emptySet(),
                null,
            () -> MetadataCreateIndexService.validateIngestionSourceSettings(settings, state)  
                );
                Settings.EMPTY,
import org.opensearch.indices.DefaultRemoteStoreSettings;
        when(repositoriesService.repository(Mockito.any())).thenReturn(repositoryMock);
            Settings.EMPTY,
            clusterService,  
        );
        CompressedXContent template2 = new CompressedXContent(
                  }  
                + "multiplied by 2 at most ten times (ie. 3 * 2^8)",
            assertEquals(INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.get(indexMetadata.getSettings()).intValue(), routingNumberOfShards);
            clusterSettings  
            IllegalArgumentException.class,  
            .build();
            .primaryTerm(0, 3L)
        assertFalse(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(aggregated));
                + "V1 result: "
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            ).getMessage()  
            @SuppressWarnings("unchecked")  
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_INGESTION_SOURCE_PARTITION_STRATEGY, "simple").build();
        assertThat(  
            settings,
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")
            clusterSettings
            RemoteStoreUtils.determineRemoteStorePathStrategy(imdBuilder.build()).getType()
        Map<String, Object> v1Result = MetadataCreateIndexService.parseV1Mappings(requestMapping, templateMappings, xContentRegistry());  
        // (only check mappings that have _doc sections)
        assertThat(doc, hasKey("properties"));
                IllegalStateException.class,
        }  
    }
    }
        assertThat(parsedMappings, hasKey("_doc"));  
            null,
        assertNotNull(imdBuilder.build().getCustomData());
            null,
                null,
                    "source",
            assertEquals(0, intRatio % 2);
            try {
            int numRoutingShards = MetadataCreateIndexService.calculateNumRoutingShards(randomNumShards, Version.CURRENT);
        final Settings forceClusterSettingEnabled = Settings.builder()  
            CreateIndexClusterStateUpdateRequest request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");  
                threadPool,
            xContentRegistry()  
            Settings.EMPTY,
        int clusterMinRefreshTimeMs = 10 * 1000;
        );
            .build();
            service,
            assertEquals("Request mapping should override template disable_objects", false, doc.get("disable_objects"));
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "parquet")  
            {
        // Verify that default value passes validation  
        return null;  
            clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
                new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,  
            true,
        );  
            clusterState,  
        assertTrue("V1 result should contain field2", v1Properties.containsKey("field2"));
import java.util.Locale;  
        // Feature flag is off by default in tests; the helper must not contribute either setting,
            randomShardLimitService(),
import java.util.concurrent.atomic.AtomicReference;
        Settings indexSettings = Settings.builder()
        final int maxThreadCount = randomIntBetween(1, 16);  
        );
            }  
        clusterSettings = new ClusterSettings(remoteStoreMigrationSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        clusterSettings = new ClusterSettings(clusterSettingsSetting, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        // Template B (higher priority / earlier in list): defines specific sub-field @fields.userstate  
        assertThat(targetRoutingNumberOfShards, is(1024));  
                new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),  
     * the specific userstate mapping. The regression in PR#19958 caused the dynamic/object  
            DiscoveryNodeRole.BUILT_IN_ROLES,
            createClusterState(indexName, randomIntBetween(2, 10), 0, indexSettings)
        int targetShards;
                    .putAlias(AliasMetadata.builder("alias1").searchRouting("2").build())
        // This checks that aggregateIndexSettings works for the case when the cluster setting  
        );
                indicesServices,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        Settings clusterBag = Settings.builder()
            randomShardLimitService(),
        CompressedXContent template = new CompressedXContent("""  
        );
            clusterService.state()
    /**
    }  
        Settings settings = settingsBuilder.build();  
            null,
        assertTrue(exception.getCause().getMessage().contains("cannot differ from cluster default"));
            forceClusterSettingEnabled,
        docWithDisableObjects.put("disable_objects", true);
                clusterService,
        ClusterState clusterState = createClusterState("sourceIndex", 1, 0, Settings.builder().put("index.blocks.write", true).build());
                assertEquals(
        assertEquals(4096, MetadataCreateIndexService.calculateNumRoutingShards(2048, Version.CURRENT));
        assertThat(validationErrors.size(), is(1));  
            + "\":{\"properties\":{\"field2\":{\"type\":\"keyword\"}}}}";
                new SystemIndices(Collections.emptyMap()),
                            "properties": {
}  
            .put("index.ingestion_source.mapper_settings.id_field", "user_id")  
        String templateContent = "{\n"  
            .build();  
            assertThat("analysis settings must be copied", settings.get("index.analysis.analyzer.default.tokenizer"), equalTo("keyword"));
        request.mappings(reqMapping.string());
        };
        );  
            .put("index.version.upgraded", upgraded)
            Arrays.asList("{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"disable_objects\":true,\"properties\":{}}}"),
                Settings.EMPTY,
            + "    }\n"
                )  
                Optional.empty()
            requestMapping2,
                clusterSettings  
        assertEquals(replicationType, indexSettings.get(SETTING_REPLICATION_TYPE));
            true,  
        ClusterState updatedClusterState = clusterStateCreateIndex(  
import org.opensearch.common.settings.Settings;
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE))
            repositoriesServiceSupplier  
            repositoriesServiceSupplier  
     * test for backward compatibility with templates without disable_objects.  
    public void testSettingsFromClusterState() {
        List<CompressedXContent> templateMappings4 = Arrays.asList(new CompressedXContent(template4));
            .build();  
                IndexNotFoundException.class,
            + "          \"type\": \"integer\"\n"
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.STRICT)
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).nodes(nodes).build();  
import org.opensearch.threadpool.TestThreadPool;  
                null,
            CountDownLatch counter = new CountDownLatch(1);
            buildNewFakeTransportAddress(),
            .build();
        );
            @SuppressWarnings("unchecked")
            Settings.builder().put("index.blocks.write", true).build()
        );
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        ).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
            request,
                    "source",  
            new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
                Collections.emptySet(),
    public void testV1V2EquivalenceValidationUtility() throws Exception {
            "Translog retention settings [index.translog.retention.age] "  
                Settings.EMPTY,  
                validationException.getMessage()  
        // default mapper type with mapper_settings — should fail  
        Map<String, String> finalCustomData = imdBuilder.build().getCustomData().get(IndexMetadata.REMOTE_STORE_CUSTOM_KEY);
                builder.putMapping(MapperService.SINGLE_MAPPING_NAME, "{\"_doc\": {}}");
            request,
     */
import org.opensearch.repositories.RepositoriesService;
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(newNode("node1")).add(oldNode).build();
            .build();
            null,
    ) {
import static org.hamcrest.Matchers.startsWith;
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");  
            + "        \"fields\": {\n"
                Optional.empty()
            DefaultRemoteStoreSettings.INSTANCE,  
                              "@fields": {
                .endObject()
            null,  
            randomShardLimitService(),  
                }
            Settings.EMPTY,  
    }  
            }
     * This test checks if the cluster is a remote store cluster then we populate custom data for remote settings in
        assertFalse(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.exists(out));
            xContentRegistry(),
            Collections.emptySet(),
        ClusterService clusterService = mock(ClusterService.class);  
        });  
                    mock(Environment.class),
    }  
        if (v2DisableObjects != null) {  
        IllegalArgumentException e = expectThrows(  
            Settings.EMPTY,
            expectThrows(
        List<CompressedXContent> complexTemplates = Arrays.asList(
    public void testDeprecatedSimpleFSStoreSettings() {  
            xContentRegistry()  
        assertEquals(translogBufferInterval, indexSettings.get(INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey()));  
import org.opensearch.action.admin.indices.alias.Alias;
            .put("node.attr.remote_store.translog.repository", "my-translog-repo-1")
        );
        return ClusterState.builder(ClusterName.DEFAULT).nodes(DiscoveryNodes.builder().add(segmentsOnlyNode).build()).build();  
            assertThat(settings.get("index.routing.allocation.initial_recovery._id"), equalTo("node1"));
            XContentParser parser = JsonXContent.jsonXContent.createParser(
        // Should not throw
                request,  
            .build();
        assertEquals("parquet", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(out));  
        }));
            request,  
import org.opensearch.snapshots.EmptySnapshotsInfoService;
        final ClusterState routingTableClusterState = ClusterState.builder(initialClusterState).routingTable(initialRoutingTable).build();
    @Before
            () -> randomNonNegativeLong(),
        Settings settings = Settings.builder().build();
            + "    },\n"  
        String contextName = randomAlphaOfLength(5);  
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");  
     * test for V2 template disable_objects functionality.
        ClusterSettings cs = new ClusterSettings(clusterBag, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            .numberOfShards(1)  
 * Unless required by applicable law or agreed to in writing,
        assertTrue(exception.getCause().getMessage().contains(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey()));
                null,
        request = new CreateIndexClusterStateUpdateRequest("create index", "test", "test");  
    }
        checkerService.addRemoteStoreCustomMetadata(imdBuilder, false, clusterState);
                new Environment(Settings.builder().put("path.home", "dummy").build(), null),
                createTestShardLimitService(randomIntBetween(1, 1000), false, clusterService),
            )  
     * This test reproduces the exact scenario from SimpleIndexTemplateIT.testSimpleIndexTemplateTests
            final List<String> validationErrors = checkerService.getIndexSettingsValidationErrors(
            assertNull("Mapping " + i + " should not have disable_objects field", doc.get("disable_objects"));
                    createClusterState("source", 5, 0, Settings.builder().put("index.blocks.write", true).build()),
            )
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        // Test creating an index with a negative timestamp (dates before epoch)
     * through {@code Setting#get} pre-empted that with an {@code IllegalArgumentException}, breaking
            .build();
            null,
        Object result = extractDisableObjectsValue(mappingWithDisableObjects);  
            numShards,  
        allMappings.add(mappings);
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
            .build();  
            .add(nonRemoteClusterManagerNode)
            .build();  
     * Covers: basic override logic, null mappings, no disable_objects scenarios.
            ClusterState.EMPTY_STATE,
        final Settings.Builder settings = Settings.builder();
    @LockFeatureFlag(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
     * test for V1/V2 equivalence with disable_objects.
                .toString();
                DeprecationHandler.IGNORE_DEPRECATIONS,
        attributes.put(REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY, "my-translog-repo-1");
                    targetSettings
        assertTrue(e.getMessage().contains("index.ingestion_source.source_partition_strategy requires all nodes"));  
import org.opensearch.core.xcontent.DeprecationHandler;
        final Settings ilnSetting = Settings.builder().put("index.lifecycle.name", "dummy").build();
    public static boolean isShrinkable(int source, int target) {  
        assertTrue(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(aggregated));  
        CompressedXContent reqMapping = createMapping("test", "keyword");
    private IndexMetadata testRemoteCustomData(boolean remoteStoreEnabled, PathType pathType) {
            + "  \"template\": {\n"
            threadPool.shutdown();
            null,
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).nodes(nodes).build();  
        MetadataCreateIndexService.updatePluggableDataFormatSettings(indexSettingsBuilder, cs, "test-index");
import java.util.HashMap;  
        IndexMetadata.Builder imdBuilder = IndexMetadata.builder("test").settings(indexSettings);
                        .startObject("properties")
            null,
            "my-segment-repo-1",
