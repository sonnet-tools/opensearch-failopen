        ).build();
                eq(true),
        final Index index = new Index("test-index", "index-uuid");
        RemoteStateTransferException exception = expectThrows(
        remoteClusterStateService.start();
                new UploadedMetadataAttribute(HASHES_OF_CONSISTENT_SETTINGS, HASHES_OF_CONSISTENT_SETTINGS_FILENAME)
    }
            .build();
        assertFalse(manifest.getCustomMetadataMap().isEmpty());
                assertEquals(metadataAfterUpdate.getIndices().get(i).getIndexName(), initialMetadata.getIndices().get(i).getIndexName());
                eq("test-index-1"),
                    .templates(templatesMetadata)
        // setup
                emptyMap(),
import java.util.Locale;
    private ClusterMetadataManifest generateClusterMetadataManifest(
                anyBoolean(),
            .build();
        assertThat(manifest.getIndicesRouting().get(0).getUploadedFilename(), notNullValue());
            manifestBuilder.customMetadataMap(
        if (differGlobalMetadata) {
                anyBoolean(),
            .indicesRouting(List.of())
        );
    private void mockBlobContainer(
        // remove custom1 from the cluster state, update custom2, custom3 is at it is, added custom4
                false
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
            "ClusterState version is not restored. previousClusterVersion: [%s] is not equal to current [%s]",
            writableRegistry(),
    private static final String NODE_ID = "test-node";
        final ClusterState clusterState = generateClusterStateWithGlobalMetadata().nodes(nodesWithLocalNodeClusterManager()).build();
                true,
                    return new ByteArrayInputStream(bytesGlobalMetadata.streamInput().readAllBytes());
package org.opensearch.gateway.remote;
        assertThat(manifest.getIndices().get(0).getIndexName(), is(uploadedIndexMetadata.getIndexName()));
                BytesReference bytesReference = TEMPLATES_METADATA_FORMAT.serialize(
                    blobContainer3,
            "cluster-uuid3",
        );
        verifyWriteIncrementalGlobalMetadataFromOlderCodecSuccess(previousManifest);
            .numberOfReplicas(1)
            .build();
            .build();
            "index-uuid",
                any(),
            .putCustom(custom1.getWriteableName(), custom1)
            .numberOfReplicas(0)
        );
                anyBoolean(),
            ChecksumWritableBlobStoreFormat<Metadata.Custom> customMetadataFormat = new ChecksumWritableBlobStoreFormat<>("custom", null);
                previousClusterState,
    }
public class RemoteClusterStateServiceTests extends OpenSearchTestCase {
            .put(
            .put(
                eq(manifest),
                Metadata.builder()
        ClusterMetadataManifest clusterMetadataManifest,
        remoteClusterStateService.start();
            return null;
        settings = Settings.builder()
            .stateUUID("state-uuid")
        );
            .nodeId("nodeA")
        );
        assertThat(manifest.getIndices().get(0).getIndexUUID(), is(uploadedIndexMetadata.getIndexUUID()));
                List.of(
                    .putCustom("custom4", new CustomMetadata1("mock_custom_metadata4"))
        mockBlobContainerForGlobalMetadata(mockBlobStoreObjects(), expectedManifest, expectedMetadata);
                eq(true),
        ClusterState clusterState = generateClusterStateWithAllAttributes().build();
        ClusterState clusterStateWrong = ClusterState.builder(clusterState).routingTable(RoutingTable.EMPTY_ROUTING_TABLE).build();
        assertThrows(RepositoryMissingException.class, () -> remoteClusterStateService.start());
            eq(false),
            eq(COORDINATION_METADATA),
                    .clusterUUID("cluster-uuid")
            return null;
                        "global-metadata-file",
        );
        List<UploadedIndexMetadata> uploadedIndexMetadataList = new ArrayList<>(
            "index-uuid",
                eq(uploadedCustomMetadataKey),
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeFullMetadata(clusterState, "prev-cluster-uuid")
            assertEquals(metadataAfterUpdate.getIndices().size(), initialMetadata.getIndices().size());
            return null;
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
        assertEquals(1, remoteClusterStateService.getRemoteStateStats().getStateDiffDownloadValidationFailed());
        ClusterState clusterStateWrong = ClusterState.builder(clusterState).routingTable(RoutingTable.EMPTY_ROUTING_TABLE).build();
                assertEquals(metadataAfterUpdate.getIndices().get(i).getIndexName(), initialMetadata.getIndices().get(i).getIndexName());
        assertThat(manifest.getIndices().get(0).getIndexName(), is(uploadedIndexMetadata.getIndexName()));
            .build();
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeIncrementalMetadata(
        assertThat(manifest.getDiffManifest().getIndicesRoutingDiffPath(), nullValue());
            capturedWriteContext.put(writeContext.getFileName().split(DELIMITER)[0], writeContextArgumentCaptor.getValue());
            () -> spiedService.writeFullMetadata(clusterState, randomAlphaOfLength(10))
                eq(manifest.getCustomMetadataMap()),
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");
                anyBoolean(),
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.TestClusterStateCustom1;
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
        assertEquals(clusterState.version(), updatedClusterState.version());
            new UploadedIndexMetadata("index2", "index-uuid2", "key2__2")
                anyMap(),
            uploadedIndexMetadataList3,
            );
            assertEquals(metadataAfterUpdate.getCustomMetadataMap(), initialMetadata.getCustomMetadataMap());
                    new UploadedMetadataAttribute("custom_1", "test-cluster-state-custom1-file__1"),
            .customMetadataMap(
                    IndexTemplateMetadata.builder("template" + randomAlphaOfLength(3))
        ClusterState previousClusterState = generateClusterStateWithAllAttributes().build();
    public void testMarkLastStateAsCommittedSuccess() throws IOException {
        ).build();
            nodesWithLocalNodeClusterManager()
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
            "remote_store_repository"
        assertThat(manifest.getIndicesRouting().get(0).getIndexName(), is(uploadedIndiceRoutingMetadata.getIndexName()));
            diffManifestBuilder.clusterBlocksUpdated(true);
        remoteClusterStateService.start();
            RemoteStateTransferException.class,
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder()
            .diffManifest(diffManifest)
        verify(mockService, times(1)).readClusterStateInParallel(
        assertEquals(0, remoteClusterStateService.getDiffDownloadStats().getFailedCount());
        // if set true, only Metadata will differ b/w cluster uuid1 and cluster uuid3.
                NODE_ID,
                new RemoteReadResult(updatedTransientSettings, TRANSIENT_SETTING_METADATA, TRANSIENT_SETTING_METADATA)
            previousManifest
            .routingTableVersion(1L)
    ) throws IOException {
            "cluster-uuid3",
        RemoteIndexMetadataManager mockedIndexManager = mock(RemoteIndexMetadataManager.class);
                any(),
        );
    }
                    clusterSettings,
        assertThat(manifest.getIndicesRouting().get(0).getUploadedFilename(), notNullValue());
import org.opensearch.common.blobstore.support.PlainBlobMetadata;
            INDEX_ROUTING_METADATA_PREFIX
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(index.getName()).settings(idxSettings)
    public void testIndexMetadataDeletedUpdatedAndAdded() throws IOException {
        final IndexMetadata indexMetadata = new IndexMetadata.Builder("test").settings(
        final Settings idxSettings = Settings.builder()
            RemoteStateTransferException.class,
            clusterState.metadata().clusterUUID()
            diffManifest.isCoordinationMetadataUpdated(),
            .committed(true)
            manifest2.getIndices()
        remoteClusterStateService.start();
            .indices(List.of(uploadedIndexMetadata))
        }
            .codecVersion(CODEC_V1)
        mockBlobContainer(blobContainer1, clusterManifest1, indexMetadataMap1, MANIFEST_CURRENT_CODEC_VERSION);
            IntStream.range(0, initialMetadata.getIndices().size()).forEach(i -> {
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
        ArgumentCaptor<LatchedActionListener<RemoteReadResult>> listenerArgumentCaptor = ArgumentCaptor.forClass(
import org.opensearch.indices.DefaultRemoteStoreSettings;
            IllegalStateException.class,
            )
            eq(false),
            ),
        when(blobContainer.listBlobsByPrefixInSortedOrder(manifestPrefix, 1, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC)).thenReturn(
        assertEquals(0, remoteClusterStateService.getRemoteStateStats().getStateDiffDownloadValidationFailed());
        repositoriesService = mock(RepositoriesService.class);
            newClusterState,
        assertNotEquals(manifest1.getCustomMetadataMap().get("custom2"), manifest2.getCustomMetadataMap().get("custom2"));
                    FORMAT_PARAMS
import org.opensearch.cluster.ClusterModule;
            DiscoveryNode node = new DiscoveryNode("node_id", buildNewFakeTransportAddress(), Version.CURRENT);
        Optional<ClusterMetadataManifest> manifest = remoteClusterStateService.getLatestClusterMetadataManifest(
                blobContainer2,
            "test-node-id",
        assertEquals(e.getMessage(), "Error while downloading Global Metadata - " + globalIndexMetadataName);
            manifestAfterMetadataUpdate = remoteClusterStateService.writeIncrementalMetadata(
                eq(false),
import org.opensearch.test.OpenSearchTestCase;
            any()
                Metadata.builder(initialClusterState.metadata())
    public void testGetValidPreviousClusterUUID() throws IOException {
        remoteClusterStateService.start();
                true,
            eq(CLUSTER_BLOCKS),
    private void initializeRoutingTable() {
                    compressor,
            new BytesArray(writtenBytes)
        uploadedIndexMetadataList.addAll(newIndicesToRead);
            ).getMetadata().getIndices().size(),
                    nodesBuilder.build(),
            .customMetadataMap(customMetadataMap)
            new ClusterStateChecksum(clusterState, threadPool)
        when(blobPath.buildAsString()).thenReturn("/blob/path/");
            "cluster-uuid2",
        }).when(container).asyncBlobUpload(any(WriteContext.class), actionListenerArgumentCaptor.capture());
        assertTrue(remoteClusterStateService.isRemotePublicationEnabled());
        remoteClusterStateService.start();
        assertNotNull(manifest.getTemplatesMetadata());
        // index1 is updated
                eq(true),
        manifestBuilder.diffManifest(diffManifest)
                emptyMap(),
            "routing-filename",
        }
        Settings updatedPersistentSettings = Settings.builder()
            .indices(indices)
            () -> 0L
        RemoteClusterStateService spiedService = spy(remoteClusterStateService);
                .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
                eq(true),
            argThat(new BlobNameMatcher(DISCOVERY_NODES_FILENAME)),
            .metadata(Metadata.builder().coordinationMetadata(coordinationMetadata))
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");
            listenerArgumentCaptor.getValue().onResponse(mockedUploadedMetadata);
        final ClusterState initialClusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
            diffManifestBuilder.customMetadataDeleted(new ArrayList<>(customsToRemove));
                true,
        assertThat(manifestInfo.getManifestFileName(), notNullValue());
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
            .clusterStateCustomMetadataMap(
            .metadata(Metadata.builder(clusterState1.getMetadata()).put(indexMetadata1, true).build())
            eq(emptyMap()),
            "test-index",
            .getClusterMetadataManifest();
        );
import org.opensearch.cluster.ClusterName;
            )
            any()
            "custom_md_3",
        ).get();
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");
        assertEquals(clusterState.metadata().version(), updatedClusterState.metadata().version());
                eq(manifest.getIndices()),
                            .build()
    }
            .stateVersion(1L)
        remoteClusterStateService.start();
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");
                eq(manifest.getClusterUUID()),
        mockBlobContainerForGlobalMetadata(blobContainer, expectedManifest, expactedMetadata);
        assertThat(manifest.getSettingsMetadata(), notNullValue());
        assertThat(manifest.getHashesOfConsistentSettings(), nullValue());
                    clusterState.stateUUID(),
            () -> 0L,
            Set<String> customsToRemove = clusterState.metadata().customs().keySet();
        long prevClusterStateVersion = 13L;
            uploadedIndexMetadata -> verify(mockedIndexManager, times(1)).readAsync(
            .readClusterStateInParallel(
            )
                argThat(new BlobNameMatcher(newCustomMetadataMap.get(uploadedCustomMetadataKey).getUploadedFilename())),
            .stateUUID("state-uuid")
            .numberOfReplicas(0)
    private boolean publicationEnabled;
            .codecVersion(CODEC_V2)
        remoteClusterStateService.setRemoteClusterStateAttributesManager(mockedClusterStateAttributeManager);
        Map<String, String> clusterUUIDsPointers = Map.of(
            .clusterTerm(1L)
                eq(true),
                    CLUSTER_BLOCKS_FILENAME,
            assertEquals(metadataAfterUpdate.getTemplatesMetadata(), initialMetadata.getTemplatesMetadata());
            WriteContext writeContext = writeContextArgumentCaptor.getValue();
        when(blobStoreRepository.getCompressor()).thenReturn(new DeflateCompressor());
        );
        Map<String, IndexMetadata> indexMetadataMap3 = differGlobalMetadata
    }
     */
                            .build()
                eq(emptyList()),
            manifestBuilder.discoveryNodesMetadata(new UploadedMetadataAttribute(DISCOVERY_NODES, DISCOVERY_NODES_FILENAME));
        uploadedCustomMetadataMap.putAll(newCustomMetadataMap);
        );
                            .addVotingConfigExclusion(new CoordinationMetadata.VotingConfigExclusion("excludedNodeId", "excludedNodeName"))
                    )
                    .templates(templatesMetadata)
        assertEquals(clusterState.metadata().coordinationMetadata(), updatedClusterState.metadata().coordinationMetadata());
                manifest,
        @Override
        assertEquals(clusterState.getBlocks(), updatedClusterState.getBlocks());
        remoteClusterStateService.setRemoteClusterStateAttributesManager(mockClusterStateAttributeManager);
        ClusterState clusterStateWrong = ClusterState.builder(clusterState).routingTable(RoutingTable.EMPTY_ROUTING_TABLE).build();
                return new ByteArrayInputStream(bytes.streamInput().readAllBytes());
            latchCapture.getValue().onResponse(mockResult);
                    threadPool,
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
                true,
                new UploadedMetadataAttribute(HASHES_OF_CONSISTENT_SETTINGS, HASHES_OF_CONSISTENT_SETTINGS_FILENAME)
import static org.hamcrest.Matchers.is;
            mb.transientSettings(transientSettings);
            .settings(indexSettings)
    public void testReadLatestMetadataManifestFailedManifestFileRemoveAfterFetchInRemote() throws IOException {
            .indices(List.of())
                metadataAfterUpdate.getSettingsMetadata()
                .term(clusterState.metadata().coordinationMetadata().term() + 1)
        assertThat(manifest.getPreviousClusterUUID(), is(expectedManifest.getPreviousClusterUUID()));
                });
            assertFalse(updatedClusterState.metadata().customs().containsKey(customMetadataName));
            .indices(uploadedIndexMetadataList)
        }
        mockBlobStoreObjects();
        assertThat(manifest.getIndices().size(), is(1));
            .build();
            clusterState,
        ClusterState notInCacheState = remoteClusterStateService.getRemoteClusterStateCache()
            .indicesRouting(List.of(uploadedIndiceRoutingMetadata))
        when(repositoriesService.repository("remote_store_repository")).thenReturn(blobStoreRepository);
                    compressor
            "cluster-uuid2",
        RemoteStateTransferException exception = expectThrows(
        RemoteClusterStateService mockService = spy(remoteClusterStateService);
                RemoteDiscoveryNodes remoteDiscoveryNodes = new RemoteDiscoveryNodes(
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
    }
                emptyMap(),
        indices.add(uploadedIndiceRoutingMetadata);
            .put(RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)
            IllegalStateException.class,
            .build();
        remoteClusterStateService.setRemoteGlobalMetadataManager(mockGlobalMetadataManager);
                    .build()
        mockBlobStoreObjects();
    public void testGetClusterStateUsingDiffWithChecksum() throws IOException {
                    settings,
            .coordinationMetadata(new ClusterMetadataManifest.UploadedMetadataAttribute(COORDINATION_METADATA, "mock-coordination-file"))
        final ClusterState previousClusterState = ClusterState.builder(ClusterName.DEFAULT)
                eq(manifest),
        }
            return null;
                    metadataAfterUpdate.getIndices().get(i).getUploadedFilename(),
                    new UploadedMetadataAttribute("custom_md_2", "test-custom2-file__1")
        Metadata expectedMetadata = Metadata.builder()
            )
            eq(true),
        diffManifest.getCustomMetadataDeleted().forEach(customMetadataName -> {
        writeableEntries.add(new NamedWriteableRegistry.Entry(Metadata.Custom.class, CustomMetadata2.TYPE, CustomMetadata2::new));
        clusterSettings.applySettings(newSettings);
            true
            .indices(indices)
    public void testWriteFullMetadataSuccessPublicationEnabled() throws IOException {
        }).when(mockGlobalMetadataManager).readAsync(any(), any(), latchCapture.capture());
            .discoveryNodesMetadata(new UploadedMetadataAttribute(DISCOVERY_NODES, DISCOVERY_NODES_FILENAME))
            .build();
                }
        assertTrue(manifest2.getCustomMetadataMap().containsKey("custom4"));
        newClusterStateCustoms.keySet().forEach(uploadedClusterStateCustomMetadataKey -> {
            clusterState.getClusterName().value(),
        int codecVersion,
            eq(COORDINATION_METADATA),
        }
        UploadedMetadataAttribute coordinationMetadata,
                    BytesReference bytesReference = customMetadataFormat.serialize(
            );
                    return new ByteArrayInputStream(bytesReference.streamInput().readAllBytes());
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedMetadataAttribute;
                    blobStoreRepository.getCompressor(),
            .stateUUID(clusterState.stateUUID())
                    FORMAT_PARAMS
import java.util.stream.IntStream;
            manifestBuilder.templatesMetadata(new UploadedMetadataAttribute(TEMPLATES_METADATA, TEMPLATES_METADATA_FILENAME));
            eq(NODE_ID),
    private static final String TEMPLATES_METADATA_FILENAME = "templates-metadata-file__1";
    public void testGetClusterStateUsingDiffWithChecksumModeDebugMismatch() throws IOException {
        AsyncMultiStreamBlobContainer container = (AsyncMultiStreamBlobContainer) mockBlobStoreObjects(AsyncMultiStreamBlobContainer.class);
            );
            customMetadataMap,
        );
        ClusterState updatedClusterState = remoteClusterStateService.readClusterStateInParallel(
        }).when(mockedGlobalMetadataManager).writeAsync(anyString(), any(), listenerArgumentCaptor.capture());
                eq(manifest.getCustomMetadataMap()),
        remoteClusterStateService.setRemoteGlobalMetadataManager(mockedGlobalMetadataManager);
        verify(mockedGlobalMetadataManager, times(1)).readAsync(
                return new ByteArrayInputStream(bytes.streamInput().readAllBytes());
            .build();
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(1L).build();
        final DiscoveryNodes nodes = nodesWithLocalNodeClusterManager();
    }
            previousManifest
            eq(manifest.getCustomMetadataMap()),
    public void testTimeoutWhileWritingMetadata() throws IOException {
                );
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
        mockBlobStoreObjects();
        mockBlobStoreObjects();
                Map.of(
    }
                eq(true),
            .clusterTerm(1L)
        );
    }
    public void testGetClusterStateUsingDiff() throws IOException {
        blobStoreRepository = mock(BlobStoreRepository.class);
        byte[] writtenBytes = capturedWriteContext.get("metadata")
        if (randomBoolean()) {
        );
        final BlobPath blobPath = mock(BlobPath.class);
            any()
                .build();
        );
            latchedActionListener.onResponse(new RemoteReadResult(customMetadata3, CUSTOM_METADATA, "custom_md_3"));
    public void testWriteIncrementalGlobalMetadataFromCodecV0Success() throws IOException {
        BlobContainer blobContainer = mockBlobStoreObjects();
            .clusterUUID("cluster-uuid")
        mockBlobStoreObjects();
            assertNotEquals(originalCustomMetadata, updatedCustomMetadata);
        // custom2 is updated
            eq(DISCOVERY_NODES),
        });
        assertEquals(clusterState.getNodes(), updatedClusterState.getNodes());
    public void teardown() throws Exception {
        rcssSpy.start();
            .stateUUID("state-uuid")
            // remove index metadata
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().build();
                return new ByteArrayInputStream(bytesReference.streamInput().readAllBytes());
            )
import org.opensearch.common.settings.Settings;
                    .build()
        assertThat(manifest.getClusterStateCustomMap(), anEmptyMap());
        assertTrue(exception.getMessage().startsWith("Some metadata components were not uploaded successfully"));
        final ClusterMetadataManifest manifest = manifestInfo.getClusterMetadataManifest();
            clusterUUIDsPointers.get("cluster-uuid1"),
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        final Settings settings = Settings.builder().build();
                eq(true),
            return null;
        );
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().build();
                anyBoolean(),
            actionListenerArgumentCaptor.getValue().onResponse(null);
            manifestBuilder.indices(
        );
            .persistentSettings(Settings.builder().put("readonly", true).build())
        ArgumentCaptor<ActionListener<Void>> actionListenerArgumentCaptor = ArgumentCaptor.forClass(ActionListener.class);
            listenerArgumentCaptor.getValue().onResponse(mockedResult);
            .readAsync(eq(SETTING_METADATA), argThat(new BlobNameMatcher(PERSISTENT_SETTINGS_FILENAME)), any());
    public void testFailWriteFullMetadataWhenNotBlobRepository() {
        );
            return null;
        when(repositoriesService.repository("remote_store_repository")).thenReturn(filterRepository);
            eq(manifest),
        BlobContainer blobContainer1 = mock(BlobContainer.class);
            .stateVersion(1L)
                // update
                    .transientSettings(transientSettings)
            eq(false)
            argThat(new BlobNameMatcher(COORDINATION_METADATA_FILENAME)),
        DiscoveryNodes updatedDiscoveryNodes = getDiscoveryNodes();
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().indices(uploadedIndexMetadataList)
        ClusterState previousClusterState = generateClusterStateWithAllAttributes().build();
            initialClusterState,
            .clusterUUID(previousClusterState.getMetadata().clusterUUID())
                    blobContainer1,
        assertThat(manifest.getIndicesRouting().get(0).getIndexUUID(), is(uploadedIndiceRoutingMetadata.getIndexUUID()));
        verify(spiedService, times(1)).readClusterStateInParallel(
            eq(NODE_ID),
            "test-index",
            threadPool,
        ).getClusterMetadataManifest();
            .globalMetadataFileName(null)
                emptyList(),
            verify(mockGlobalMetadataManager, times(1)).readAsync(
        diffManifest.getCustomMetadataUpdated().forEach(customMetadataName -> {
        newIndicesToRead.forEach(
                eq(true),
        }).when(mockedIndexManager)
import org.mockito.ArgumentMatchers;
        final List<UploadedIndexMetadata> indices = List.of(uploadedIndexMetadata);
            return null;
    }
        namedWriteableRegistry = new NamedWriteableRegistry(writeableEntries);
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder().indices(Collections.emptyList()).build();
        ClusterState clusterState = generateClusterStateWithAllAttributes().build();
            "cluster-uuid1",
                        blobStoreRepository.getCompressor()
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
            .build();
            eq(true),
        final ClusterState clusterState = generateClusterStateWithOneIndex().build();
        assertThat(manifest.getTemplatesMetadata(), notNullValue());
                    .getUploadedFilename()
            writableRegistry(),
            .readAsync(
            )
                true,
        uploadedCustomMetadataMap.putAll(newCustomMetadataMap);
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
        RemoteClusterStateService mockService = spy(remoteClusterStateService);
import static org.opensearch.gateway.remote.model.RemoteCoordinationMetadata.COORDINATION_METADATA_FORMAT;
        initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode.FAILURE);
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
            () -> 0L
        );
        mockService.getClusterStateForManifest(ClusterName.DEFAULT.value(), manifest, NODE_ID, true);
            });
        assertThrows(
            .getClusterMetadataManifest();
        });
            any(),
            diffManifestBuilder.hashesOfConsistentSettingsUpdated(true);
                return new ByteArrayInputStream(bytes.streamInput().readAllBytes());
            eq(false)
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
            .readAllBytes();
        assertEquals(clusterState.stateUUID(), updatedClusterState.stateUUID());
            assertEquals(metadataAfterUpdate.getSettingsMetadata(), initialMetadata.getSettingsMetadata());
                    .clusterUUID("cluster-uuid")
        assertThat(manifest.getDiffManifest().getIndicesRoutingDiffPath(), notNullValue());
        remoteClusterStateService = new RemoteClusterStateService(
            when(blobContainer.readBlob("add-test-index-file__2")).thenAnswer(i -> {
                    .version(randomNonNegativeLong())
            previousManifest
            .clusterUUID("cluster-uuid")
                    repositoriesServiceSupplier,
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(index.getName()).settings(idxSettings)
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));
            .codecVersion(CODEC_V2)
        assertNotNull(remoteClusterStateService.getFullDownloadStats());
            .previousClusterUUID("prev-cluster-uuid")
        ).build();
            "test-index",
        doAnswer(invocation -> {
    public void testTimeoutWhileWritingManifestFile() throws IOException {
import org.opensearch.cluster.metadata.TemplatesMetadata;
                    metadata.coordinationMetadata(),
            .codecVersion(CODEC_V2)
        List<UploadedIndexMetadata> indices = List.of(uploadedIndexMetadata);
                any()
            .stateUUID("state-uuid")
    }
            "index-uuid",
    private RemoteClusterStateService remoteClusterStateService;
            + DELIMITER;
            () -> remoteClusterStateService.writeFullMetadata(clusterState, randomAlphaOfLength(10))
                eq(true),
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY;
        ).getClusterMetadataManifest();
            new ClusterStateChecksum(clusterState, threadPool)
        remoteClusterStateService.start();
                    RemoteClusterStateService.RemoteClusterStateValidationMode.DEBUG,
            .getClusterMetadataManifest();
        assertThat(manifestAfterUpdate.hasMetadataAttributesFiles(), is(true));
            writableRegistry(),
            clusterState,
import static org.mockito.ArgumentMatchers.anyMap;
        // index already present in previous state
                    transientSettings,
                    BytesReference bytesIndexMetadata = INDEX_METADATA_FORMAT.serialize(
        ).get();
        ).thenReturn(new RemoteClusterStateUtils.UploadedMetadataResults());
        assertEquals(0, remoteClusterStateService.getUploadStats().getFailedCount());
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
            assertFalse(
            .clusterUUID("cluster-uuid")
                eq(true),
            .opensearchVersion(Version.CURRENT)
        final RemoteClusterStateService rcssSpy = Mockito.spy(remoteClusterStateService);
            .routingTableVersion(1L)
                "custom_md_2",
                eq(manifest.getClusterUUID()),
                );
                    .build()
            verify(mockedGlobalMetadataManager, times(1)).readAsync(
            "routing-filename",
                eq(manifest.getClusterStateCustomMap()),
        assertTrue(exception.getSuppressed().length > 0);
                eq(true),
        assertTrue(remoteClusterStateService.isRemotePublicationEnabled());
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
import static org.mockito.ArgumentMatchers.eq;
        );
                anyBoolean(),
        assertThat(manifest.getIndicesRouting().get(0).getIndexUUID(), is(uploadedIndiceRoutingMetadata.getIndexUUID()));
        mockBlobContainer(blobContainer, expectedManifest, Map.of(), CODEC_V2);
        assertEquals(stateFromCache.getMetadata(), state.getMetadata());
            return null;
                )
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
            .build();
        final ClusterMetadataManifest manifest = remoteClusterStateService.getClusterMetadataManifestByTermVersion(
        final TemplatesMetadata templatesMetadata = TemplatesMetadata.builder()
                )
            .getClusterMetadataManifest();
            return null;
        );
                .build();
            .stateUUID("state-uuid")
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        ClusterBlocks updatedClusterBlocks = randomClusterBlocks();
            .metadata(
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));
                    );
                any(),
    public void testFailWriteIncrementalMetadataNonClusterManagerNode() throws IOException {
            .customMetadataMap(uploadedCustomMetadataMap)
    }
        // previous manifest with codec 0 and null global metadata
    }
                anyBoolean(),
                .get()
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(2L).build();
            );
    }
            .clusterTerm(1L)
        } else {
            .stateVersion(prevClusterStateVersion)
        initializeRoutingTable();
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.CustomMetadata2;
                    .build()
import org.opensearch.common.network.NetworkModule;
                true,
            manifest2.getIndices().stream().filter(uploadedIndex -> uploadedIndex.getIndexName().equals(index1.getName())).count()
        Function<ClusterState, ClusterState> clusterStateUpdater,
        );
            randomAlphaOfLength(10),
        ArgumentCaptor<ActionListener<Void>> actionListenerArgumentCaptor = ArgumentCaptor.forClass(ActionListener.class);
                eq(manifest.getIndices()),
        when((blobStoreRepository.basePath())).thenReturn(BlobPath.cleanPath().add("base-path"));
        );
import java.util.function.Supplier;
                threadPool,
        ClusterStateDiffManifest diffManifest = diffManifestBuilder.build();
    }
import org.opensearch.core.index.Index;
            .clusterUUID("cluster-uuid")
    private BlobStore blobStore;
                .getUploadedFilename(),
            .getState(clusterState.getClusterName().value(), notExistMetadata);
        ClusterState clusterState = generateClusterStateWithAllAttributes().build();
            "test-index",
            () -> 0L,
                repositoriesServiceSupplier,
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");
    public void testGetValidPreviousClusterUUIDWhenLastUUIDUncommitted() throws IOException {
            .numberOfReplicas(1)
            .build();
                anyBoolean(),
        final Index index = new Index(indexName, "index-uuid");
                eq(Collections.emptyMap()),
        expectThrows(IllegalStateException.class, () -> mockService.getClusterStateUsingDiff(manifest, clusterState, NODE_ID));
            Metadata.Custom originalCustomMetadata = clusterState.metadata().custom(customMetadataName);
                true,
        when(blobContainer.listBlobsByPrefixInSortedOrder("manifest" + DELIMITER, 1, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC))
import org.opensearch.common.blobstore.BlobMetadata;
                    .clusterUUID("cluster-uuid")
                any()
            )
        assertNotNull(manifest.getCustomMetadataMap());
        assertEquals(0, remoteClusterStateService.getFullDownloadStats().getSuccessCount());
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        remoteClusterStateService.start();
        );
                    DefaultRemoteStoreSettings.INSTANCE
        verify(mockedGlobalMetadataManager, times(1)).readAsync(
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().checksum(
                Metadata.builder(initialClusterState.metadata())
                                        Settings.builder()
                    blobContainer3
            clusterUUIDCommitted.getOrDefault("cluster-uuid1", true)
        ClusterMetadataManifest.Builder manifestBuilder = ClusterMetadataManifest.builder();
import static org.opensearch.gateway.remote.model.RemoteDiscoveryNodesTests.getDiscoveryNodes;
        Map<String, UploadedMetadataAttribute> customMetadataMap,
            return null;
        if (randomBoolean()) {
            .readAsync(eq(DISCOVERY_NODES), argThat(new BlobNameMatcher(DISCOVERY_NODES_FILENAME)), any());
            .codecVersion(MANIFEST_CURRENT_CODEC_VERSION)
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
                eq(manifest.getCustomMetadataMap()),
import org.mockito.ArgumentMatcher;
            previousManifest
                clusterState.getCustoms(),
            .numberOfShards(1)
        List<UploadedIndexMetadata> indices = List.of(uploadedIndexMetadata);
    }
    }
        assertEquals(1, remoteClusterStateService.getRemoteStateStats().getStateDiffDownloadValidationFailed());
            .getInputStream()
        assertEquals(expectedClusterState.getRoutingTable().version(), updatedClusterState.getRoutingTable().version());
            any()
        assertEquals(8, writeContextArgumentCaptor.getAllValues().size());
            return null;
        remoteClusterStateService.setRemoteIndexMetadataManager(mockedIndexManager);
            .stateUUID("state-uuid")
            FORMAT_PARAMS
            true,
            )
            clusterState,
        final Settings idxSettings = Settings.builder()
            argThat(new BlobNameMatcher(TEMPLATES_METADATA_FILENAME)),
            ),
            "cluster-uuid1",
            .build();
                previousClusterState,
            () -> 0L,
        assertEquals(8, actionListenerArgumentCaptor.getAllValues().size());
                eq(true),
            mb.hashesOfConsistentSettings(hashesOfConsistentSettings);
    }
        );
            any(),
    ) throws IOException {
        Function<ClusterState, ClusterState> updater = (initialClusterState) -> ClusterState.builder(initialClusterState)
                IndexGraveyard.TYPE,
        assertThat(manifest.getTemplatesMetadata(), notNullValue());
            eq(NODE_ID),
    public void testWriteFullMetadataFailureForGlobalMetadata() throws IOException {
            .metadata(
            eq(false),
                Metadata.builder()
                new ClusterMetadataManifest.UploadedMetadataAttribute(IndexGraveyard.TYPE, "mock-custom-" + IndexGraveyard.TYPE + "-file")
            );
            LatchedActionListener<RemoteReadResult> latchedActionListener = invocationOnMock.getArgument(2, LatchedActionListener.class);
            eq(true),
                any(),
            );
        verify(mockGlobalMetadataManager, times(1)).readAsync(
            argThat(new BlobNameMatcher(TRANSIENT_SETTINGS_FILENAME)),
            .previousClusterUUID("prev-cluster-uuid")
            );
                anyBoolean(),
                eq(true),
        assertThat(manifest.getIndices().get(0).getIndexName(), is(uploadedIndexMetadata.getIndexName()));
        RemoteClusterStateService mockService = spy(remoteClusterStateService);
    }
        assertThat(manifest.getTemplatesMetadata(), notNullValue());
        Function<ClusterState, ClusterState> updater = (initialClusterState) -> ClusterState.builder(initialClusterState)
        final ClusterState clusterState = generateClusterStateWithOneIndex("test-index", 5, 1, false).nodes(
        ClusterStateDiffManifest diffManifest = ClusterStateDiffManifest.builder().build();
            // Other files will be equal
        remoteClusterStateService.start();
        // List.of(new NamedXContentRegistry.Entry(Metadata.Custom.class, new ParseField(IndexGraveyard.TYPE),
import static org.mockito.ArgumentMatchers.anyList;
        rcssSpy.setRemoteClusterStateAttributesManager(mockedClusterStateAttributeManager);
                    .putCustom("custom2", new CustomMetadata1("mock_updated_custom_metadata"))
        Mockito.verify(rcssSpy)
        doReturn(clusterState).when(mockService)
        assertNotEquals(
            "routing-filename",
                    .equalsIgnoreCase(initialMetadata.getTemplatesMetadata().getUploadedFilename())
            return argument != null && expectedBlobName.equals(argument.getFullBlobName());
        remoteClusterStateService.start();
     * In final manifest codec version should be 2 and have metadata files updated,
            clusterStateWrong,
            INDEX_ROUTING_METADATA_PREFIX
            eq(manifest.getIndices()),
            LatchedActionListener.class
            RemoteStateTransferException.class,
            new ClusterStateChecksum(clusterState, threadPool)
            threadPool,
            );
            );
        when(mockedGlobalMetadataManager.getGlobalMetadataUploadTimeout()).thenReturn(GLOBAL_METADATA_UPLOAD_TIMEOUT_DEFAULT);
        AssertionError error = assertThrows(
import org.opensearch.core.xcontent.NamedXContentRegistry;
        Map<String, UploadedMetadataAttribute> uploadedCustomMetadataMap = new HashMap<>(
                        blobStoreRepository.getCompressor(),
                any(),
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
        );
        Map<String, String> clusterUUIDsPointers,
        assertEquals(indexMetadataMap.get(index.getName()).getNumberOfShards(), indexMetadata.getNumberOfShards());
        assertEquals(updatedClusterBlocks, updatedClusterState.blocks());
            NODE_ID,
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
            .clusterUUID("cluster-uuid")
                anyBoolean(),
            .build();
        List<UploadedIndexMetadata> newIndicesToRead = List.of(
        if (randomBoolean()) {
            diffManifestBuilder.transientSettingsMetadataUpdate(true);
            .stateUUID("state-uuid")
        when(blobContainer.readBlob(manifestFileName)).thenReturn(new ByteArrayInputStream(bytes.streamInput().readAllBytes()));
        String previousClusterUUID,
                eq(manifest.getClusterUUID()),
            .build();
            repositoriesServiceSupplier,
        ).diffManifest(ClusterStateDiffManifest.builder().build()).build();
            .numberOfReplicas(10)
        final Settings idxSettings = Settings.builder()
                any()
            .put("node.attr." + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "remote_store_repository")
        ArgumentCaptor<LatchedActionListener<RemoteReadResult>> listenerArgumentCaptor = ArgumentCaptor.forClass(
        clusterSettings.applySettings(newSettings);
        BlobMetadata blobMetadata = new PlainBlobMetadata(mockManifestFileName, 1);
        return ClusterState.builder(ClusterName.DEFAULT)
import org.opensearch.common.blobstore.transfer.RemoteTransferContainer;
        when(container.readBlob(anyString())).thenAnswer(inv -> { throw new IOException(exceptionMsg); });
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeFullMetadata(clusterState, "prev-cluster-uuid")
            .build();
        assertThat(manifest.getCoordinationMetadata(), notNullValue());
import org.opensearch.indices.IndicesModule;
        mockBlobStoreObjects();
                        TemplatesMetadata.builder()
        final Settings settings = Settings.builder().put("mock-settings", true).build();
        }).when(container).asyncBlobUpload(writeContextArgumentCaptor.capture(), actionListenerArgumentCaptor.capture());
                        fileName,
                    updatedClusterStateCustom3,
     * Here we will verify the migration of manifest file from codec V0.
                    initialMetadata.getIndices().get(i).getUploadedFilename()
            .indices(Collections.emptyList())
        mockBlobContainer(blobContainer, expectedManifest, Map.of());
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            )
                any(),
        Map<String, Boolean> clusterUUIDCommitted
                clusterState.getClusterName().value(),
            .readAsync(eq(COORDINATION_METADATA), argThat(new BlobNameMatcher(COORDINATION_METADATA_FILENAME)), any());
                    compressor,
                eq(manifest.getClusterUUID()),
                clusterState,
            INDEX_ROUTING_METADATA_PREFIX
        );
        return ClusterMetadataManifest.builder()
            manifestAfterMetadataUpdate = remoteClusterStateService.writeFullMetadata(newClusterState, initialClusterState.stateUUID())
        final ClusterState previousClusterState = generateClusterStateWithOneIndex("test-index", 5, 1, true).nodes(
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(1L).build();
                )
            latchedActionListener.onResponse(
        final ClusterState previousClusterState = ClusterState.builder(ClusterName.DEFAULT)
        IndexMetadata indexMetadata4 = IndexMetadata.builder("index2")
        assertThrows(IllegalStateException.class, () -> remoteClusterStateService.getLastKnownUUIDFromRemote("test-cluster"));
        RemoteStateTransferException exception = assertThrows(
            clusterState,
        doReturn(clusterStateWrong).when(mockService)
        Map<String, IndexMetadata> indexMetadataMap2 = Map.of("index-uuid1", indexMetadata3, "index-uuid2", indexMetadata4);
    }
            "cluster-uuid3",
                false
        final ClusterState previousClusterState = ClusterState.builder(ClusterName.DEFAULT)
                eq(manifest.getClusterUUID()),
        );
            )
            .readClusterStateInParallel(
            clusterState.getClusterName().value(),
        assertThat(manifest.getTransientSettingsMetadata(), nullValue());
            clusterService,
        assertNotNull(manifest.getCoordinationMetadata());
        // If set to false, only IndexMetadata would be different
    }
            assertNotEquals(originalIndexMetadata, updatedIndexMetadata);
import static org.mockito.Mockito.mock;
            actionListenerArgumentCaptor.getValue().onResponse(null);
            manifestBuilder.build(),
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
        remoteClusterStateService.start();
                    .put(indexMetadata, true)
        Function<ClusterState, ClusterState> updater = (initialState) -> ClusterState.builder(initialState)
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
        assertThat(manifest.getRoutingTableVersion(), is(expectedManifest.getRoutingTableVersion()));
                    compressor
        }).when(mockedClusterStateAttributeManager)
                    DISCOVERY_NODES_FILENAME,
            .version(1L)
            "routing-filename",
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
            .metadata(Metadata.builder().coordinationMetadata(coordinationMetadata))
                true,
 */
import static org.mockito.Mockito.spy;
        );
        final BlobContainer blobContainer = mock(blobContainerClazz);
            new UploadedIndexMetadata("index2", "index-uuid2", "key2__2")
            eq(NODE_ID),
        });
        clusterMetadataManifest.getIndices().forEach(uploadedIndexMetadata -> {
            any()
                );
                true,
                    assertEquals(v, metadataAfterUpdate.getCustomMetadataMap().get(k));
    public void testWriteFullMetadataInParallelSuccess() throws IOException {
                true,
                eq(true),
            .numberOfShards(1)
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
        when(blobStoreRepository.blobStore()).thenReturn(blobStore);
            eq(TRANSIENT_SETTING_METADATA),
            new UploadedMetadataAttribute(TEMPLATES_METADATA, "key5"),
        ).getClusterMetadataManifest();
            writableRegistry(),
        );
                .build()
            .nodes(nodesWithLocalNodeClusterManager())
import org.opensearch.cluster.block.ClusterBlocks;
        remoteClusterStateService.start();
        mockBlobContainer(mockBlobStoreObjects(), expectedManifest, Map.of(index.getUUID(), indexMetadata), CODEC_V2);
            .numberOfReplicas(0)
            .clusterTerm(1L)
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
        ArgumentCaptor<LatchedActionListener<RemoteReadResult>> listenerArgumentCaptor = ArgumentCaptor.forClass(
                new ClusterMetadataManifest.UploadedMetadataAttribute(IndexGraveyard.TYPE, "mock-custom-" + IndexGraveyard.TYPE + "-file")
        diffManifest.getClusterStateCustomUpdated().forEach(clusterStateCustomName -> {
    static ClusterState.Builder generateClusterStateWithGlobalMetadata() {
    public void testReadLatestMetadataManifestFailedNoManifestFileInRemote() throws IOException {
                )
        Mockito.verify(rcssSpy)
                BytesReference bytes = RemoteTransientSettingsMetadata.SETTINGS_METADATA_FORMAT.serialize(
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
                eq(true)
import static org.opensearch.gateway.remote.model.RemoteHashesOfConsistentSettings.HASHES_OF_CONSISTENT_SETTINGS;
            .previousClusterUUID("prev-cluster-uuid")
            clusterUUIDCommitted.getOrDefault("cluster-uuid2", true)
        assertTrue(updatedClusterState.metadata().indices().containsKey("test-index-1"));
        settings = Settings.builder().put(settings).put(REMOTE_PUBLICATION_SETTING_KEY, publicationEnabled).build();
            .clusterUUID("cluster-uuid")
    }
            clusterState.metadata().clusterUUID(),
                    .putCustom("custom1", new CustomMetadata1("mock_custom_metadata1"))
        assertThat(manifest.getIndicesRouting().get(0).getUploadedFilename(), notNullValue());
                Settings.builder()
        );
        );
import static org.mockito.Mockito.when;
            ),
        RemoteIndexMetadataManager mockedIndexManager = mock(RemoteIndexMetadataManager.class);
            Settings transientSettings = Settings.builder()
                true,
            } catch (IOException e) {
        remoteClusterStateService.start();
            .numberOfReplicas(0)
                null
                anyBoolean(),
        );
        remoteClusterStateService.setRemoteIndexMetadataManager(mockIndexMetadataManager);
        when(mockedResult.getComponent()).thenReturn(COORDINATION_METADATA);
            ? "manifest__manifestFileName__abcd__abcd__abcd__" + codecVersion
                eq(true),
                eq(emptyMap()),
        assertEquals(1, remoteClusterStateService.getFullDownloadStats().getFailedCount());
        final List<UploadedIndexMetadata> indices = List.of(uploadedIndexMetadata);
            previousManifest
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
            new UploadedMetadataAttribute("custom_3", "test-cluster-state-custom3-file__1")
        ClusterMetadataManifest manifest2 = remoteClusterStateService.writeIncrementalMetadata(clusterState1, clusterState2, manifest1)
            .previousClusterUUID("prev-cluster-uuid")
            .putCustom(custom2.getWriteableName(), custom2);
        doAnswer(invocation -> {
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
        verify(spiedService, times(1)).readClusterStateInParallel(
        private final String expectedBlobName;
            assertEquals(metadataAfterUpdate.getCoordinationMetadata(), initialMetadata.getCoordinationMetadata());
                IndexGraveyard.TYPE,
    }
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
        RemoteClusterStateAttributesManager mockedClusterStateAttributeManager = mock(RemoteClusterStateAttributesManager.class);
            listenerArgumentCaptor.getValue().onResponse(mockedUploadedMetadata);
            .transientSettingsMetadata(new UploadedMetadataAttribute(TRANSIENT_SETTING_METADATA, TRANSIENT_SETTINGS_FILENAME))
        assertEquals(0, remoteClusterStateService.getRemoteStateStats().getStateDiffDownloadValidationFailed());
            .clusterTerm(1L)
            .templatesMetadata(templatesMetadata)
        BlobContainer uuidBlobContainer = mock(BlobContainer.class);
        remoteClusterStateService.start();
            .nodeId("nodeA")
        int readTimeOut = 2;
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().codecVersion(CODEC_V1).build();
        return DiscoveryNodes.builder().clusterManagerNodeId("cluster-manager-id").localNodeId("cluster-manager-id").add(localNode).build();
            eq(true),
        threadPool.shutdown();
            return null;
    }
        String stateUUID,
                "custom_2",
            "cluster-uuid3",
        }).when(mockedGlobalMetadataManager).readAsync(eq("custom_md_3"), argThat(new BlobNameMatcher(customMetadataFilename)), any());
            any()
                                    .build()
            return null;
        Assert.assertThat(manifestDetails, nullValue());
                anyBoolean(),
        when(blobContainer.readBlob(GLOBAL_METADATA_FORMAT.blobName(globalIndexMetadataName))).thenThrow(FileNotFoundException.class);
    public static ClusterState.Builder generateClusterStateWithOneIndex(
        long version
        );
                eq(manifest.getCustomMetadataMap()),
            clusterState,
            clusterState,
        Settings newSettings = Settings.builder()
        verify(mockGlobalMetadataManager, times(1)).readAsync(
                eq(true),
        mockService.getClusterStateUsingDiff(manifest, clusterState, NODE_ID);
            .metadata(
        // Update only index metadata
            );
            clusterState,
            .build();
import static org.mockito.Mockito.verify;
                    BytesReference bytesIndexMetadata = INDEX_METADATA_FORMAT.serialize(
    }
            // For async write action listener will be called from different thread, replicating same behaviour here.
            capturedWriteContext.get("metadata").getFileName(),
    private void mockBlobContainerForClusterUUIDs(BlobContainer blobContainer, Set<String> clusterUUIDs) throws IOException {
                    .build()
        when(blobContainer.listBlobsByPrefixInSortedOrder("manifest" + DELIMITER, 1, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC))
        doAnswer(invocation -> {
        doAnswer(invocationOnMock -> {
            eq(false),
                true
            new ClusterStateChecksum(clusterState, threadPool)
                initialManifest
            .metadata(
    private void mockObjectsForGettingPreviousClusterUUID(Map<String, String> clusterUUIDsPointers) throws IOException {
                eq(emptyList()),
                @Override
        ).build();
            repositoriesServiceSupplier,
                () -> 0L,
            : "manifestFileName";
        BlobMetadata blobMetadata = new PlainBlobMetadata("manifestFileName", 1);
        assertNotEquals(
        assertThat(manifest.getIndicesRouting().get(0).getIndexUUID(), is(uploadedIndiceRoutingMetadata.getIndexUUID()));
            "custom_3",
        );
        IllegalStateException exception = expectThrows(
            "cluster-uuid2",
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
        assertThat(manifest.getIndices().get(0).getUploadedFilename(), notNullValue());
        RemoteReadResult mockResult = mock(RemoteReadResult.class);
        ).build();
        assertNull(manifest.getClusterStateChecksum());
        assertThat(manifest.getClusterBlocksMetadata(), nullValue());
    private String getFileNameFromPath(String filePath) {
            );
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
        if (randomBoolean()) {
            .checksum(new ClusterStateChecksum(clusterState, threadPool))
                    clusterState.stateUUID(),
        assertEquals(clusterState.metadata().persistentSettings(), updatedClusterState.metadata().persistentSettings());
                ),
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
            );
            )
        assertThat(manifest.getIndices().get(0).getIndexName(), is(uploadedIndexMetadata.getIndexName()));
import org.junit.Before;
            argThat(new BlobNameMatcher(HASHES_OF_CONSISTENT_SETTINGS_FILENAME)),
        Exception e = assertThrows(
        assertEquals(updatedPersistentSettings, updatedClusterState.metadata().persistentSettings());
            new UploadedIndexMetadata("index1", "index-uuid1", "key1__2"),
        String indexFilename = "test-index-1-file__2";
            .clusterUUIDCommitted(isUUIDCommitted)
            argThat(new BlobNameMatcher(TEMPLATES_METADATA_FILENAME)),
            .build();
                "custom_1",
                    compressor,
            .getStreamProvider(Integer.MAX_VALUE)
        remoteClusterStateService.setRemoteGlobalMetadataManager(mockedGlobalMetadataManager);
        doAnswer(invocationOnMock -> {
        mockObjectsForGettingPreviousClusterUUID(clusterUUIDsPointers, false, clusterUUIDCommitted);
            eq(manifest.getIndicesRouting()),
        assertEquals(12, writeContextArgumentCaptor.getAllValues().size());
            .clusterTerm(1L)
        final ClusterState previousClusterState = ClusterState.builder(ClusterName.DEFAULT)
                true,
            try {
        remoteClusterStateService.start();
            manifestFileName,
                )
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
            return null;
            );
            .put("random_transient_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5))
                    RepositoryCleanupInProgress.TYPE,
    private Settings settings;
            previousClusterState,
            .put(IndexTemplateMetadata.builder("template1").settings(idxSettings).patterns(List.of("test*")).build())
    public void testMigrationFromCodecV0ManifestToCodecV2Manifest() throws IOException {
        when(mockedUploadedMetadata.getComponent()).thenReturn("test-component");
                ClusterState.EMPTY_STATE,
            when(blobContainer.readBlob(HASHES_OF_CONSISTENT_SETTINGS_FILENAME)).thenAnswer(i -> {
            .build();
            mb.coordinationMetadata(coordinationMetadata);
                initialMetadata.getCustomMetadataMap().forEach((k, v) -> {
        assertThat(manifest.getIndicesRouting().get(0).getIndexUUID(), is(uploadedIndiceRoutingMetadata.getIndexUUID()));
        final RemoteClusterStateManifestInfo manifestDetails = remoteClusterStateService.writeFullMetadata(
    private BlobContainer mockBlobStoreObjects(Class<? extends BlobContainer> blobContainerClazz) {
                );
        initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode.NONE);
        ).getClusterMetadataManifest();
            : List.of(new UploadedIndexMetadata("index1", "index-uuid1", "key1__2"));
import static org.hamcrest.Matchers.anEmptyMap;
            .routingTableVersion(1)
                assertEquals(metadataAfterUpdate.getIndices().get(i).getIndexUUID(), initialMetadata.getIndices().get(i).getIndexUUID());
            manifest1.getIndices()
        }
                    return;
            .nodeId("nodeA")
        assertEquals("Diff manifest null which is required for downloading cluster state", error.getMessage());
            previousClusterState,
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
                    .put(indexMetadata, true)
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder()
            String templatesFileName = getFileNameFromPath(clusterMetadataManifest.getTemplatesMetadata().getUploadedFilename());
        );
            .previousClusterUUID("prev-cluster-uuid")
                "custom_1",
            updatedClusterState.metadata().coordinationMetadata().term()
            "cluster-uuid1",
        assertEquals(e.getMessage(), "Error while downloading cluster metadata - manifestFileName");
                true,
            nodesWithLocalNodeClusterManager()
import org.junit.Assert;
            .put("node.attr." + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "remote_store_repository")
                return new ByteArrayInputStream(bytes.streamInput().readAllBytes());
        verify(mockClusterStateAttributeManager, times(1)).readAsync(
            return null;
            eq(NODE_ID),
    }
            "cluster-uuid1"
            // update nodes
        mockObjectsForGettingPreviousClusterUUID(clusterUUIDsPointers, randomBoolean(), Collections.emptyMap());
        assertThat(previousClusterUUID, equalTo("cluster-uuid3"));
        assertThat(manifest.getTransientSettingsMetadata(), nullValue());
                        indexMetadata,
            .readAsync(eq(TRANSIENT_SETTING_METADATA), argThat(new BlobNameMatcher(TRANSIENT_SETTINGS_FILENAME)), any());
import static org.hamcrest.Matchers.equalTo;
            IndexMetadata originalIndexMetadata = clusterState.metadata().index(indexName);
        when(blobStoreRepository.getCompressor()).thenReturn(compressor);
            when(blobContainer.readBlob(TEMPLATES_METADATA_FILENAME)).thenAnswer(i -> {
        final ClusterState clusterState = generateClusterStateWithOneIndex("test-index", 5, 1, false).nodes(
    }
        doAnswer(invocation -> {
    }
        assertThat(manifest.getCoordinationMetadata(), notNullValue());
                Metadata.builder(initialClusterState.metadata())
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().checksum(
        final UploadedIndexMetadata uploadedIndiceRoutingMetadata = new UploadedIndexMetadata(
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeIncrementalMetadata(
            .hashesOfConsistentSettings(
            diffManifest.isTransientSettingsMetadataUpdated(),
            .indices(List.of(uploadedIndexMetadata))
        RemoteIndexMetadataManager mockedIndexManager = mock(RemoteIndexMetadataManager.class);
            assertEquals(metadataAfterUpdate.getCustomMetadataMap(), initialMetadata.getCustomMetadataMap());
            eq(HASHES_OF_CONSISTENT_SETTINGS),
                eq(emptyList()),
        final ClusterState previousClusterState = ClusterState.builder(ClusterName.DEFAULT)
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
        final ClusterMetadataManifest manifest = remoteClusterStateService.getLatestClusterMetadataManifest(
            .routingTableVersion(1)
    public void testFailInitializeWhenRepositoryNotSet() {
        String manifestFileName = codecVersion >= CODEC_V1
        // global metadata is updated
            });
        ClusterMetadataManifest manifest1 = remoteClusterStateService.writeIncrementalMetadata(
            .clusterUUID("cluster-uuid")
            manifestFileName,
            .previousClusterUUID("prev-cluster-uuid")
        // Updating the voting config, as updating the term will upload the full cluster state and other files will also get updated
        doReturn(clusterState).when(mockService)
                true
            clusterState.getClusterName().value(),
            eq(ClusterName.DEFAULT.value()),
            mb.templates(templatesMetadata);
            .version(1L)
            Stream.of(
            List.of(
            .indicesRouting(List.of(uploadedIndiceRoutingMetadata))
        assertThat(manifest.getDiscoveryNodesMetadata(), nullValue());
        assertEquals(expectedManifest.getCodecVersion(), manifest.getCodecVersion());
                eq(manifest.getClusterStateCustomMap()),
            List.of(
                any()
            // updated transient settings
                Mockito.any(StringKeyDiffProvider.class)
            .version(1L)
            eq(emptyList()),
        assertThat(manifest.getCustomMetadataMap().containsKey(CustomMetadata1.TYPE), is(true));
        assertThat(manifest.getIndicesRouting().get(0).getIndexName(), is(uploadedIndiceRoutingMetadata.getIndexName()));
            clusterUUIDCommitted.getOrDefault("cluster-uuid3", true)
                argThat(new BlobNameMatcher(uploadedIndexMetadata.getUploadedFilename())),
                when(blobContainer.readBlob(getFormattedIndexFileName(fileName))).thenAnswer((invocationOnMock) -> {
    public void testMigrationFromCodecV1ManifestToCodecV2Manifest() throws IOException {
                        CoordinationMetadata.builder(initialClusterState.coordinationMetadata())
            ClusterName.DEFAULT.value(),
        });
        ClusterMetadataManifest manifest1 = remoteClusterStateService.writeIncrementalMetadata(
            );
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertThat(manifest.getClusterStateChecksum(), is(expectedManifest.getClusterStateChecksum()));
            // template metadata file would have changed
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(1L).build();
        );
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
                    .hashesOfConsistentSettings(Map.of("key1", "value1", "key2", "value2"))
            .numberOfReplicas(replicaShards)
        when((blobStoreRepository.basePath())).thenReturn(BlobPath.cleanPath().add("base-path"));
            .clusterTerm(1L)
                eq(true),
        when((blobStoreRepository.basePath())).thenReturn(BlobPath.cleanPath().add("base-path"));
            .indices(indices)
            repositoriesServiceSupplier,
        final UploadedIndexMetadata uploadedIndiceRoutingMetadata = new UploadedIndexMetadata(
            true,
            .build();
            ).getClusterMetadataManifest();
            eq(emptyMap()),
                    "custom",
            updatedClusterState.getMetadata().transientSettings().equals(clusterState.getMetadata().transientSettings())
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
            previousClusterState,
                    threadPool,
                eq(manifest),
    }
                new RemoteIndexPathUploader(
        String[] splitPath = filePath.split("/");
            .routingTableVersion(1)
                anyBoolean(),
        return ClusterState.builder(ClusterName.DEFAULT)
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
                    )
        assertThat(manifest.getIndicesRouting().get(0).getUploadedFilename(), notNullValue());
                any(),
            .checksum(new ClusterStateChecksum(clusterState, threadPool))
        verify(mockService, times(1)).validateClusterStateFromChecksum(
                eq(emptyMap()),
        clusterSettings.applySettings(newSettings);
            clusterState,
        final UploadedIndexMetadata uploadedIndiceRoutingMetadata = new UploadedIndexMetadata(
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
                clusterService,
                List.of(
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeFullMetadata(clusterState, "prev-cluster-uuid")
        return ClusterState.builder(ClusterName.DEFAULT)
        BlobContainer blobContainer = mockBlobStoreObjects();
            routingTableBuilder.addAsRecovery(indexMetadata);
                eq(NODE_ID),
                eq(manifest),
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
        assertEquals(clusterState.metadata().templates(), updatedClusterState.metadata().templates());
            });
            .stateUUID("state-uuid")
            newSettings,
        }).when(mockedIndexManager).writeAsync(any(), any(), listenerArgumentCaptor.capture());
        final ClusterMetadataManifest notExistMetadata = ClusterMetadataManifest.builder()
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
                eq(manifest.getClusterUUID()),
            Locale.ROOT,
            ? "manifest__manifestFileName__abcd__abcd__abcd__" + codecVersion
            .indices(indices)
        assertThrows(
        String exceptionMsg = "mock exception";
            "test-index",
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(index.getName()).settings(idxSettings)
            .thenReturn(List.of());
    public static DiscoveryNodes nodesWithLocalNodeClusterManager() {
        assertThat(manifest.getSettingsMetadata(), notNullValue());
        final ClusterState initialClusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
                // since timestamp is part of file name, if file name is same we can confirm that file is not update in global metadata
            when(blobContainer.readBlob(SETTINGS_METADATA_FORMAT.blobName(settingsFileName))).thenAnswer((invocationOnMock) -> {
            .globalMetadataFileName("global-metadata-file")
    ) throws IOException {
            .previousClusterUUID("prev-cluster-uuid")
import java.util.Arrays;
        // setup
        assertEquals(1, remoteClusterStateService.getDiffDownloadStats().getSuccessCount());
        remoteClusterStateService.start();
            .build();
                any()
        when((blobStoreRepository.basePath())).thenReturn(BlobPath.cleanPath().add("base-path"));
            .previousClusterUUID("prev-cluster-uuid")
            .previousClusterUUID("prev-cluster-uuid")
                anyBoolean(),
            listenerArgumentCaptor.getValue().onResponse(mockedResult);
                blobContainer1,
            .numberOfShards(1)
        assertThat(manifest.getIndices().get(0).getUploadedFilename(), notNullValue());
        );
            .build();
                    String.join(CUSTOM_DELIMITER, CLUSTER_STATE_CUSTOM, updatedClusterStateCustom3.getWriteableName())
            });
        final Settings clusterSettings = Settings.builder().put("cluster.blocks.read_only", true).build();
    }
import java.util.HashMap;
        assertThat(manifest.getIndices().get(0).getIndexUUID(), is(uploadedIndexMetadata.getIndexUUID()));
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.isRemoteRoutingTableConfigured;
        assertEquals(updatedDiscoveryNodes.getClusterManagerNodeId(), updatedClusterState.getNodes().getClusterManagerNodeId());
        int metadataManifestUploadTimeout = 2;
        remoteClusterStateService.start();
        mockBlobContainerOrderedList.addAll(
                });
        );
        );
            "cluster-uuid1",
            when(blobContainer.readBlob(DISCOVERY_NODES_FILENAME)).thenAnswer(invocationOnMock -> {
        );
            () -> 0L
    }
            String[] splitPath = clusterMetadataManifest.getGlobalMetadataFileName().split("/");
        remoteClusterStateService.start();
                any(),
                assertEquals(initialMetadata.getCustomMetadataMap().size() + 1, metadataAfterUpdate.getCustomMetadataMap().size());
            any(ClusterState.class),
            )
        return blobContainer;
        Map<String, String> clusterUUIDsPointers = Map.of(
        remoteClusterStateService.start();
            "nodeA",
            // For Manifest file perform No Op, so latch in code will timeout
            eq(ClusterName.DEFAULT.value()),
            any()
        // During incremental update, codec version will not change.
        BlobContainer blobContainer,
            .checksum(new ClusterStateChecksum(clusterState, threadPool))
                ChecksumWritableBlobStoreFormat<Metadata.Custom> customMetadataFormat = new ChecksumWritableBlobStoreFormat<>(
        List<UploadedIndexMetadata> uploadedIndexMetadata,
        // IndexGraveyard::fromXContent))));
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
            .build();
            "test-node-id",
            LatchedActionListener<RemoteReadResult> latchedActionListener = invocationOnMock.getArgument(2, LatchedActionListener.class);
            .build();
        final ClusterState clusterState = generateClusterStateWithGlobalMetadata().nodes(nodesWithLocalNodeClusterManager()).build();
        // updating remote cluster state with global metadata
        final ClusterBlocks clusterBlocks = randomClusterBlocks();
        doAnswer(invocationOnMock -> {
                String fileName = entry.getValue();
            expectedClusterStateBuilder.nodes(nodesBuilder.build());
        remoteClusterStateService.start();
import org.opensearch.test.VersionUtils;
            .numberOfShards(1)
                true,
            .build();
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");
            .stateVersion(1L)
            .settings(indexSettings)
            .routingTableVersion(1)
            .version(1L)
import org.opensearch.threadpool.TestThreadPool;
            .stateVersion(1L)
        final ClusterMetadataManifest manifest = remoteClusterStateService.markLastStateAsCommitted(clusterState, previousManifest, false)
            )
import org.opensearch.common.blobstore.AsyncMultiStreamBlobContainer;
            .build();
            .numberOfReplicas(1)
    }
        ClusterMetadataManifest manifest = ClusterMetadataManifest.builder()
            actionListenerArgumentCaptor.getValue().onResponse(null);
            .stateVersion(1L)
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
            eq(false)
            listenerArgumentCaptor.getValue().onResponse(mockedResult);
            });
                eq(true),
            eq(false),
            ? new ArrayList<>(uploadedIndexMetadataList1)
            .coordinationMetadata(new UploadedMetadataAttribute(COORDINATION_METADATA, COORDINATION_METADATA_FILENAME))
                RemoteClusterBlocks remoteClusterBlocks = new RemoteClusterBlocks(
            previousManifest
            any()
        RemoteClusterStateService mockService = spy(remoteClusterStateService);
            eq(TEMPLATES_METADATA),
            .clusterTerm(1L)
                                    .settings(
            .stateVersion(1L)
        verify(mockedGlobalMetadataManager, times(1)).readAsync(
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(1L).build();
    private static final String TRANSIENT_SETTINGS_FILENAME = "transient-settings-file__1";
            .build();
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V1;
        verify(mockedClusterStateAttributeManager, times(1)).readAsync(
            diffManifestBuilder.settingsMetadataUpdated(true);
        assertEquals(clusterState.metadata().transientSettings(), updatedClusterState.metadata().transientSettings());
            nodesWithLocalNodeClusterManager()
        remoteClusterStateService = new RemoteClusterStateService(
            IndexMetadata indexMetadata = new IndexMetadata.Builder("add-test-index").settings(
            RemoteStateTransferException.class,
                assertNotEquals(metadataAfterUpdate.getCustomMetadataMap(), initialMetadata.getCustomMetadataMap());
        when(blobPath.add(anyString())).thenReturn(blobPath);
    private void verifyMetadataAttributeOnlyUpdated(
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeIncrementalMetadata(
    public void testWriteFullMetadataSuccessWithChecksumValidationModeNone() throws IOException {
            .discoveryNodesMetadata(new UploadedMetadataAttribute(DISCOVERY_NODES, DISCOVERY_NODES_FILENAME))
                eq(manifest.getIndices()),
        remoteClusterStateService.start();
        // custom1 is removed
            );
import org.opensearch.cluster.ClusterState;
        );
 * this file be licensed under the Apache-2.0 license or a
        remoteClusterStateService.start();
        return splitPath[splitPath.length - 1];
        }
                    HASHES_OF_CONSISTENT_SETTINGS_FILENAME,
        remoteClusterStateService.start();
        assertEquals("Unknown component: mock-result", exception.getMessage());
        mockBlobContainerForGlobalMetadata(mockBlobStoreObjects(), expectedManifest, expectedMetadata);
            eq(true),
            .build();
            previousClusterState,
                eq(manifest),
                        indexMetadata,
        RemoteIndexMetadataManager mockIndexMetadataManager = mock(RemoteIndexMetadataManager.class);
            FORMAT_PARAMS
            .build();
        remoteClusterStateService.start();
        assertThrows(AssertionError.class, () -> remoteClusterStateService.start());
                true,
        RemoteClusterStateService mockService = spy(remoteClusterStateService);
                    metadata.templatesMetadata(),
                    .coordinationMetadata(
                BytesReference bytes = TEMPLATES_METADATA_FORMAT.serialize(
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    ) {
                true,
            .stateVersion(1L)
            () -> 0L,
                false,
import org.opensearch.cluster.RepositoryCleanupInProgress;
        assertThat(manifest.getIndices().size(), is(1));
        }).when(mockedClusterStateAttributeManager)
        verify(mockGlobalMetadataManager, times(1)).readAsync(
                    initialMetadata.getIndices().get(i).getUploadedFilename()
        BytesReference bytes = RemoteClusterMetadataManifest.CLUSTER_METADATA_MANIFEST_FORMAT.serialize(
        doThrow(new RepositoryMissingException("repository missing")).when(repositoriesService).repository("remote_store_repository");
        spiedService.getClusterStateForManifest(ClusterName.DEFAULT.value(), manifest, NODE_ID, false);
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");
        String manifestPrefix = String.join(DELIMITER, "manifest", RemoteStoreUtils.invertLong(term), RemoteStoreUtils.invertLong(version))
            .previousClusterUUID("prev-cluster-uuid")
    }
                    blobStoreRepository.getCompressor(),
                );
        final DiscoveryNode localNode = new DiscoveryNode("cluster-manager-id", buildNewFakeTransportAddress(), Version.CURRENT);
        RemoteIndexMetadataManager mockedIndexManager = mock(RemoteIndexMetadataManager.class);
                    blobStoreRepository.getCompressor(),
                    );
            eq(SETTING_METADATA),
            List.of(
        }
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(index.getName()).settings(idxSettings)
            eq(NODE_ID),
    }
        public boolean matches(AbstractClusterMetadataWriteableBlobEntity argument) {
        verify(mockService, times(1)).readClusterStateInParallel(
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
                        settings,
            eq(HASHES_OF_CONSISTENT_SETTINGS),
                eq(true),
                any(),
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().checksum(
        assertEquals(updatedTransientSettings, updatedClusterState.metadata().transientSettings());
                eq(emptyMap()),
            assertEquals(
            .build();
        CoordinationMetadata updatedCoordinationMetadata = CoordinationMetadata.builder()
                    .build()
            List.of(new UploadedIndexMetadata("test-index", "test-index-uuid", "test-index-file__2"))
                anyMap(),
}
                blobContainer1,
        mockBlobStoreObjects();
            assertEquals(metadataAfterUpdate.getCustomMetadataMap(), initialMetadata.getCustomMetadataMap());
            eq(false)
        assertThat(manifest.getIndices().size(), is(1));
                previousClusterState,
import org.opensearch.index.remote.RemoteIndexPathUploader;
        assertThat(manifest.getHashesOfConsistentSettings(), nullValue());
            new ClusterStateChecksum(clusterState, threadPool)
            latchedActionListener.onResponse(new RemoteReadResult(updatedDiscoveryNodes, CLUSTER_STATE_ATTRIBUTE, DISCOVERY_NODES));
                emptyList(),
        );
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
        assertEquals(expectedClusterState.getClusterName(), updatedClusterState.getClusterName());
        RemoteClusterStateService mockService = spy(remoteClusterStateService);
            // updated coordination metadata
            any()
            // updated customs
            .getClusterMetadataManifest();
            .build();
        ClusterStateDiffManifest.Builder diffManifestBuilder = ClusterStateDiffManifest.builder();
        ClusterState newClusterState = clusterStateUpdater.apply(initialClusterState);
                false,
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(1L).build();
        assertEquals(2, manifest1.getIndices().size());
        assertEquals(
            .indices(indices)
        mockService.getClusterStateUsingDiff(manifest, clusterState, NODE_ID);
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
            clusterState.getClusterName().value(),
            List.of(new UploadedIndexMetadata("test-index", "test-index-uuid", "test-index-file__2"))
        assertThat(manifest.getIndices().size(), is(1));
            clusterState.metadata().clusterUUID(),
        assertEquals(writtenIndexMetadata.getNumberOfReplicas(), 0);
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
            // updated hashes of consistent settings
            eq(emptyList()),
            .build();
            "cluster-uuid2",
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
            newSettings,
        String stateRepoSettingsAttributeKeyPrefix = String.format(
            eq(SETTING_METADATA),
import static org.hamcrest.Matchers.notNullValue;
        }).when(mockedGlobalMetadataManager)
            Locale.getDefault(),
                                    .build()
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
        mockBlobStoreObjects();
        when(mockedResult.getComponent()).thenReturn(COORDINATION_METADATA);
        final BlobPath blobPath = mock(BlobPath.class);
            emptyList(),
            when(blobContainer.readBlob(TEMPLATES_METADATA_FORMAT.blobName(templatesFileName))).thenAnswer((invocationOnMock) -> {
        );
        mockService.getClusterStateForManifest(ClusterName.DEFAULT.value(), manifest, NODE_ID, true);
        );
        ClusterState.Builder expectedClusterStateBuilder = ClusterState.builder(clusterState);
            ClusterState.UNKNOWN_UUID,
                    .putCustom("custom2", new CustomMetadata1("mock_custom_metadata2"))
            .codecVersion(MANIFEST_CURRENT_CODEC_VERSION)
                eq(manifest.getIndices()),
            .build();
                );
                eq(manifest.getClusterUUID()),
            eq(TEMPLATES_METADATA),
            eq(manifest.getClusterUUID()),
        assertEquals(manifest, Optional.empty());
                NODE_ID,
        ).getClusterMetadataManifest();
                    persistentSettings,
            true,
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata(index.getName(), index.getUUID(), fileName);
                    new UploadedIndexMetadata(indexMetadata.getIndex().getName(), indexMetadata.getIndexUUID(), "add-test-index-file__2")
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeIncrementalMetadata(
                    FORMAT_PARAMS
        verify(mockedClusterStateAttributeManager, times(1)).readAsync(
    }
    private static final String CLUSTER_BLOCKS_FILENAME = "cluster-blocks-file__1";
        }).when(mockedGlobalMetadataManager).readAsync(any(), any(), listenerArgumentCaptor.capture());
    }
        assertEquals(2, manifest2.getIndices().size());
        RemoteClusterStateService mockService = spy(remoteClusterStateService);
            "index-uuid",
import org.opensearch.common.blobstore.BlobStore;
        ClusterState previousClusterState = generateClusterStateWithAllAttributes().build();
            any(ClusterState.class),
            .put(REMOTE_PUBLICATION_SETTING_KEY, "true")
        assertThat(manifest.getIndices().get(0).getUploadedFilename(), notNullValue());
                        repositoriesServiceSupplier,
            any()
        Index index1 = new Index("test-index-1", "index-uuid-1");
        assertThat(manifest.getRoutingTableVersion(), is(expectedManifest.getRoutingTableVersion()));
            listenerArgumentCaptor.getValue().onResponse(mockedResult);
        } else {
        clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            .clusterStateCustomMetadataMap(uploadedClusterStateCustomMap)
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.cluster.metadata.DiffableStringMap;
        clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        IndexMetadata writtenIndexMetadata = INDEX_METADATA_FORMAT.deserialize(
        assertEquals(
        Function<ClusterState, ClusterState> updater = (initialClusterState) -> ClusterState.builder(initialClusterState)
        ClusterState clusterStateWrong = ClusterState.builder(clusterState).routingTable(RoutingTable.EMPTY_ROUTING_TABLE).build();
            AssertionError.class,
                new RemoteReadResult(
        assertThat(manifest.getIndices().get(0).getUploadedFilename(), notNullValue());
            .clusterTerm(1L)
            eq(manifest.getIndicesRouting()),
        mockBlobStoreObjects();
        // Initial cluster state with index.
        RemoteIndexMetadataManager mockedIndexManager = mock(RemoteIndexMetadataManager.class);
            .term(previousClusterState.metadata().coordinationMetadata().term() + 1)
        writeableEntries.add(new NamedWriteableRegistry.Entry(Metadata.Custom.class, CustomMetadata3.TYPE, CustomMetadata3::new));
import static org.opensearch.gateway.remote.model.RemoteCustomMetadata.readFrom;
            .codecVersion(CODEC_V1)
                emptyList(),
    }
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
    }
        remoteClusterStateService.start();
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
import static org.opensearch.gateway.remote.RemoteClusterStateAttributesManager.CLUSTER_BLOCKS;
            // updated templates
                when(blobContainer.readBlob(getFormattedIndexFileName(fileName))).thenAnswer((invocationOnMock) -> {
    public void testFailInitializationWhenRemoteStateDisabled() {
                        FORMAT_PARAMS
            .indicesRouting(List.of(uploadedIndiceRoutingMetadata))
        ClusterState stateFromCache2 = remoteClusterStateService.getClusterStateForManifest(
        }).when(mockIndexMetadataManager).readAsync(anyString(), any(), latchCapture.capture());
            .put(RemoteClusterStateService.REMOTE_CLUSTER_STATE_CHECKSUM_VALIDATION_MODE_SETTING.getKey(), mode.name())
        String manifestFileName = codecVersion >= CODEC_V1
        mockBlobStoreObjects();
        Map<String, BlobContainer> blobContainerMap = new HashMap<>();
        assertEquals(0, remoteClusterStateService.getFullDownloadStats().getFailedCount());
            when(blobContainer.readBlob(TRANSIENT_SETTINGS_FILENAME)).thenAnswer(i -> {
        assertThat(manifest.getIndices().get(0).getIndexUUID(), is(uploadedIndexMetadata.getIndexUUID()));
        diffManifest.getClusterStateCustomDeleted().forEach(clusterStateCustomName -> {
            "routing-filename",
    public void testReadClusterStateInParallel_TimedOut() throws IOException {
            .readAsync(eq(CLUSTER_BLOCKS), argThat(new BlobNameMatcher(CLUSTER_BLOCKS_FILENAME)), any());
        remoteClusterStateService.start();
            eq(false),
                metadataAfterUpdate.getCoordinationMetadata()
                eq(false),
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
        when(blobContainer.listBlobsByPrefixInSortedOrder("manifest" + DELIMITER, 1, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC))
                )
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.DELIMITER;
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
        );
            );
                    settingsFileName,
                eq(false),
        mockService.getClusterStateForManifest(ClusterName.DEFAULT.value(), manifest, NODE_ID, true);
        mockObjectsForGettingPreviousClusterUUID(clusterUUIDsPointers, clusterUUIDCommitted);
        BlobContainer blobContainer,
            .forEach(indexName -> { assertFalse(updatedClusterState.metadata().getIndices().containsKey(indexName)); });
            INDEX_ROUTING_METADATA_PREFIX
            IllegalStateException.class,
        remoteClusterStateService.setRemoteGlobalMetadataManager(mockedGlobalMetadataManager);
        final UploadedIndexMetadata uploadedIndiceRoutingMetadata = new UploadedIndexMetadata(
            manifest,
        Map<String, IndexMetadata> indexMetadataMap,
    }
        remoteClusterStateService.start();
            });
        ClusterState clusterState = generateClusterStateWithAllAttributes().build();
            .getClusterMetadataManifest();
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
        ClusterState newClusterState = ClusterState.builder(previousClusterState).metadata(newMetadata).build();
        if (randomBoolean()) {
                any()
        clusterSettings.applySettings(newSettings);
import static org.opensearch.gateway.remote.model.RemoteGlobalMetadata.GLOBAL_METADATA_FORMAT;
            .put(RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)
                new UploadedMetadataAttribute("custom_md_1", "test-custom1-file__1"),
                eq(emptyMap()),
                "custom_md_1",
            eq(ClusterName.DEFAULT.value()),
            )
            .readAsync(eq(HASHES_OF_CONSISTENT_SETTINGS), argThat(new BlobNameMatcher(HASHES_OF_CONSISTENT_SETTINGS_FILENAME)), any());
            });
            .nodeId("nodeA")
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder().indices(indices).build();
        final ClusterMetadataManifest initialManifest = remoteClusterStateService.writeFullMetadata(initialClusterState, "_na_")
            clusterState1,
                when(blobContainer.readBlob(fileName)).thenAnswer((invocation) -> {
                BytesReference bytes = remoteDiscoveryNodes.discoveryNodesFormat.serialize(
        String fileName = "metadata-" + index.getUUID() + "__1";
            .codecVersion(MANIFEST_CURRENT_CODEC_VERSION)
            clusterState1,
            .indices(List.of(uploadedIndexMetadata))
            .numberOfReplicas(0)
        );
                eq(emptyList()),
        List<UploadedIndexMetadata> uploadedIndexMetadataList3 = differGlobalMetadata
        remoteClusterStateService.setRemoteClusterStateAttributesManager(mockedClusterStateAttributeManager);
            eq(manifest),
                eq(NODE_ID),
    public void testFailWriteFullMetadataNonClusterManagerNode() throws IOException {
import java.io.ByteArrayInputStream;
        assertEquals(customMetadata3, updatedClusterState.metadata().custom(customMetadata3.getWriteableName()));
                argThat(new BlobNameMatcher(newCustomMetadataMap.get(uploadedCustomMetadataKey).getUploadedFilename())),
            eq(false),
        RemoteGlobalMetadataManager mockedGlobalMetadataManager = mock(RemoteGlobalMetadataManager.class);
                if (indexMetadata == null) {
        String stateRepoTypeAttributeKey = String.format(
            ),
            for (Map.Entry<String, String> entry : customFileMap.entrySet()) {
    public void testGetClusterStateUsingDiffFailWhenDiffManifestAbsent() {
        assertThat(manifest.getIndices().get(0).getIndexName(), is(uploadedIndexMetadata.getIndexName()));
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
        ArgumentCaptor<WriteContext> writeContextArgumentCaptor = ArgumentCaptor.forClass(WriteContext.class);
            .previousClusterUUID("prev-cluster-uuid")
                        .build()
            .build();
                eq(manifest.getIndices()),
            .templatesMetadata(new ClusterMetadataManifest.UploadedMetadataAttribute(TEMPLATES_METADATA, "mock-templates-file"))
        List<UploadedIndexMetadata> uploadedIndexMetadataList2 = List.of(
        initializeRoutingTable();
        when((blobStoreRepository.basePath())).thenReturn(BlobPath.cleanPath().add("base-path"));
        when((blobStoreRepository.basePath())).thenReturn(blobPath);
    }
            .previousClusterUUID("prev-cluster-uuid")
            clusterState.metadata().clusterUUID()
        );
        Index index2 = new Index("test-index-2", "index-uuid-2");
            )
        Metadata metadata2 = Metadata.builder()
            // Verify that index metadata information is same in manifest files
                eq(false),
                eq(emptyMap()),
        );
                anyList(),
        // new custom metadata to be added
            .stateUUID("state-uuid")
        assertThat(manifest.getGlobalMetadataFileName(), nullValue());
            settings,
        assertEquals(0, remoteClusterStateService.getDiffDownloadStats().getSuccessCount());
                    .version(clusterState1.metadata().version() + 1)
            .indices(List.of(uploadedIndexMetadata))
                return false;
                    repositoriesServiceSupplier,
        initializeRoutingTable();
        remoteClusterStateService.close();
            .indicesRouting(List.of())
                eq(manifest.getClusterStateCustomMap()),
                eq(manifest.getCustomMetadataMap()),
            .getState(clusterState.getClusterName().value(), expectedManifest);
            LatchedActionListener<RemoteReadResult> latchedActionListener = invocationOnMock.getArgument(2, LatchedActionListener.class);
            .readClusterStateInParallel(
                argThat(new BlobNameMatcher(uploadedIndexMetadata.getUploadedFilename())),
        remoteClusterStateService.start();
    public void testWriteIncrementalMetadataSuccessWithRoutingTableDiff() throws IOException {
                    .put(indexMetadata1, true)
    }
        assertThat(manifest.getRoutingTableVersion(), is(expectedManifest.getRoutingTableVersion()));
                eq(true),
                            .numberOfReplicas(0)
        doAnswer((i) -> {
            );
                // since timestamp is part of file name, if file name is same we can confirm that file is not update in global metadata
        String clusterStateCustomFilename = "test-cluster-state-custom3-file__1";
    }
                    metadataAfterUpdate.getIndices().get(i).getUploadedFilename(),
            any()
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
            eq(manifest.getClusterUUID()),
                    .persistentSettings(settings)
            .previousClusterUUID(previousClusterUUID)
        assertFalse(manifest1.getCustomMetadataMap().containsKey("custom4"));
            mockBlobContainerOrderedList.addAll(
            new UploadedMetadataAttribute(SETTING_METADATA, "key4"),
                    .putCustom("custom3", new CustomMetadata1("mock_custom_metadata3"))
            .build();
        );
            previousClusterState,
        });
            Map.of(
            diffManifestBuilder.discoveryNodesUpdated(true);
            .stateUUID("state-uuid")
        final TemplatesMetadata templatesMetadata = TemplatesMetadata.builder()
            new ClusterStateChecksum(clusterState, threadPool)
import org.opensearch.repositories.FilterRepository;
    public void testGetClusterStateUsingDiffWithChecksumMismatch() throws IOException {
                new RemoteIndexPathUploader(
            eq(ClusterName.DEFAULT.value()),
    }
            argThat(new BlobNameMatcher(PERSISTENT_SETTINGS_FILENAME)),
                anyBoolean(),
                assertEquals(
            any()
    public void testWriteIncrementalMetadataSuccessWithRoutingTableDiffNull() throws IOException {
import org.opensearch.cluster.service.ClusterService;
        final RemoteClusterStateManifestInfo manifestDetails = remoteClusterStateService.writeIncrementalMetadata(
            .stateVersion(1L)
                any(),
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeFullMetadata(clusterState, "prev-cluster-uuid")
            previousClusterState,
            () -> remoteClusterStateService.readClusterStateInParallel(
            RemoteStateTransferException.class,
    }
            .build();
                anyBoolean(),
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
            eq(DISCOVERY_NODES),
                eq(true)
                assertEquals(metadataAfterUpdate.getSettingsMetadata(), initialMetadata.getSettingsMetadata());
            )
            );
        final UploadedIndexMetadata uploadedIndiceRoutingMetadata = new UploadedIndexMetadata(
            blobStoreRepository.getCompressor(),
    }
        when(blobContainer.path()).thenReturn(blobPath);
        doAnswer(invocation -> {
    }
        when(blobContainer3.path()).thenReturn(blobPath);
            .build();
        assertEquals(expectedManifest.getClusterTerm(), manifest.getClusterTerm());
                    threadPool,
            eq(manifest),
                eq(manifest.getClusterUUID()),
        Map<String, UploadedMetadataAttribute> uploadedClusterStateCustomMap = new HashMap<>(
        );
        );
import org.opensearch.core.compress.Compressor;
    public void testGetClusterStateUsingDiff_NoDiff() throws IOException {
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));
        initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode.FAILURE);
        );
        BlobContainer[] mockBlobContainerOrderedArray = new BlobContainer[mockBlobContainerOrderedList.size()];
import java.util.ArrayList;
                eq("test-index-1"),
            );
                true,
                anyBoolean(),
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));
            .previousClusterUUID("prev-cluster-uuid")
    public void testRemoteRoutingTableInitializedWhenEnabled() {
        ClusterState previousState = ClusterState.EMPTY_STATE;
        newCustomMetadataMap.keySet().forEach(uploadedCustomMetadataKey -> {
            .indices(Collections.emptyList())
            () -> remoteClusterStateService.writeIncrementalMetadata(previousClusterState, clusterState, null)
        IndexMetadata indexMetadata2 = IndexMetadata.builder("index2")
        when((blobStoreRepository.basePath())).thenReturn(blobPath);
            .indices(Collections.emptyList())
                    coordinationFileName,
                anyMap(),
            .stateUUID("state-uuid")
        // Initial cluster state with index.
            .put(stateRepoSettingsAttributeKeyPrefix + "location", "randomRepoPath")
                eq(emptyMap()),
                new UploadedMetadataAttribute("custom_md_1", "test-custom1-file__1"),
                true,
            .put(REMOTE_PUBLICATION_SETTING_KEY, true)
                eq(false),
import static org.mockito.Mockito.doReturn;
                any()
        when(container.readBlob(anyString())).thenAnswer(invocationOnMock -> {
                );
        // existing custom metadata
    }
            manifest,
        BiConsumer<ClusterMetadataManifest, ClusterMetadataManifest> assertions
            .metadata(
        BlobContainer blobContainer = mockBlobStoreObjects();
            latchedActionListener.onResponse(new RemoteReadResult(updatedTemplateMetadata, TEMPLATES_METADATA, TEMPLATES_METADATA));
            .clusterUUID("cluster-uuid")
                newClusterStateCustoms,
        assertThat(manifest.getIndices().get(0).getUploadedFilename(), notNullValue());
        }).when(mockedGlobalMetadataManager).readAsync(anyString(), any(), listenerArgumentCaptor.capture());
        Settings newSettings = Settings.builder()
        assertThat(manifest.getIndicesRouting().get(0).getIndexUUID(), is(uploadedIndiceRoutingMetadata.getIndexUUID()));
        RemoteGlobalMetadataManager mockedGlobalMetadataManager = mock(RemoteGlobalMetadataManager.class);
                anyBoolean(),
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
                    CLUSTER_STATE_ATTRIBUTE,
        // when(blobStoreRepository.getNamedXContentRegistry()).thenReturn(new NamedXContentRegistry(
        assertThat(manifest.getIndicesRouting().size(), is(1));
        publicationEnabled = false;
     */
    }
        Function<ClusterState, ClusterState> updater = (initialClusterState) -> ClusterState.builder(initialClusterState)
                Metadata.builder(initialState.metadata())
        IndexMetadata indexMetadata5 = IndexMetadata.builder("index1")
                        metadata,
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;
                argThat(new BlobNameMatcher(clusterStateCustomFilename)),
            "test-node-id",
        String indexName,
        BlobContainer blobContainer,
    public void testGetValidPreviousClusterUUIDForInvalidChain() throws IOException {
                eq(true),
                anyBoolean(),
        assertThat(manifest.getIndices().size(), is(1));
        String previousClusterUUID = remoteClusterStateService.getLastKnownUUIDFromRemote("test-cluster");
        );
        final CustomMetadata1 customMetadata1 = new CustomMetadata1("custom-metadata-1");
                eq(false),
            clusterState,
                eq(String.join(CUSTOM_DELIMITER, CLUSTER_STATE_CUSTOM, uploadedClusterStateCustomMetadataKey)),
                                            .put("random_index_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5))
            });
            return null;
                    return new ByteArrayInputStream(bytesIndexMetadata.streamInput().readAllBytes());
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.CustomMetadata3;
            .stateVersion(1L)
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.CustomMetadata1;
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
        verify(mockService, times(0)).validateClusterStateFromChecksum(any(), any(), anyString(), anyString(), anyBoolean());
        assertThat(manifest.getClusterStateCustomMap(), anEmptyMap());
            eq(NODE_ID),
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.getFormattedIndexFileName;
        Settings newSettings = Settings.builder()
            // coordination metadata file would have changed
                return new ByteArrayInputStream(bytes.streamInput().readAllBytes());
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
                new ArrayList<>(clusterState.getMetadata().indices().values()),
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(index.getName()).settings(idxSettings)
                anyBoolean(),
import org.opensearch.gateway.remote.model.RemotePersistentSettingsMetadata;
        AsyncMultiStreamBlobContainer container = (AsyncMultiStreamBlobContainer) mockBlobStoreObjects(AsyncMultiStreamBlobContainer.class);
                anyBoolean(),
        final DiffableStringMap hashesOfConsistentSettings = new DiffableStringMap(emptyMap());
import static org.hamcrest.Matchers.not;
import static org.mockito.Mockito.doNothing;
            .settings(indexSettings)
        assertEquals(manifest1.getCustomMetadataMap().get("custom3"), manifest2.getCustomMetadataMap().get("custom3"));
                .put("random_transient_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5))
        when(mockResult.getComponent()).thenReturn("mock-result");
        assertEquals(updatedTemplateMetadata.getTemplates(), updatedClusterState.metadata().templates());
            ClusterState.Custom updateClusterStateCustom = updatedClusterState.customs().get(clusterStateCustomName);
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(1L).build();
        ).build();
            assertTrue(remoteClusterStateService.getRemoteRoutingTableService() instanceof NoopRemoteRoutingTableService);
        doAnswer(invocationOnMock -> {
    }
            .clusterUUID("cluster-uuid")
        // when comparing cluster-uuid3 and cluster-uuid1 state.
            )
        RemoteClusterStateService mockService = spy(remoteClusterStateService);
            eq(false),
import static org.mockito.ArgumentMatchers.anyBoolean;
        doAnswer(invocationOnMock -> {
                List.of(
                null
            argThat(new BlobNameMatcher(PERSISTENT_SETTINGS_FILENAME)),
    public void testGetClusterStateForManifestWithChecksumValidationDebugWithMismatch() throws IOException {
        assertThat(manifest.getIndices().size(), is(1));
        assertThat(manifest.getTemplatesMetadata(), notNullValue());
        String clusterUUID,
            customMetadataMap,
            .previousClusterUUID("prev-cluster-uuid")
                            )
                    .putCustom(customMetadata1.getWriteableName(), customMetadata1)
            )
        assertTrue(Metadata.isGlobalStateEquals(newClusterState.getMetadata(), expectedMetadata));
        assertThat(manifest.getIndices().get(0).getIndexUUID(), is(uploadedIndexMetadata.getIndexUUID()));
                );
        mockBlobStoreObjects();
            Set<String> indicesToDelete = clusterState.metadata().getIndices().keySet();
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager())
            .nodeId("nodeA")
            listenerArgumentCaptor.getValue().onResponse(mockedResult);
            "test-node-id",
    public void testGetClusterStateForManifest_ExcludeEphemeral() throws IOException {
                anyBoolean(),
import org.opensearch.cluster.coordination.CoordinationMetadata;
                eq(true),
    }
            .build();
    public void testWriteIncrementalGlobalMetadataFromCodecV1Success() throws IOException {
        final UploadedIndexMetadata uploadedIndiceRoutingMetadata = new UploadedIndexMetadata(
        assertThat(manifest.getCoordinationMetadata(), notNullValue());
            () -> 0L,
            .stateVersion(1L)
        when(blobContainer.children()).thenReturn(blobContainerMap);
            "index-uuid",
            clusterState.getClusterName().value(),
            .stateVersion(clusterState.version())
        Settings idxSettings2 = Settings.builder()
        IndexMetadata newIndexMetadata = new IndexMetadata.Builder("test-index-1").state(IndexMetadata.State.OPEN)
            Map.of(
        assertEquals(clusterState.getClusterName(), updatedClusterState.getClusterName());
            .getClusterMetadataManifest();
        when(mockedGlobalMetadataManager.getGlobalMetadata(anyString(), eq(manifest))).thenReturn(Metadata.EMPTY_METADATA);
            newIndicesToRead,
    }
        remoteClusterStateService.start();
        Settings newSettings = Settings.builder()
        if (capturedWriteContext.get("metadata").doRemoteDataIntegrityCheck()) {
            }
    @LockFeatureFlag(REMOTE_PUBLICATION_SETTING_KEY)
            NODE_ID,
                true,
                    (out, nodes) -> nodes.writeToWithAttribute(out),
            updatedClusterState.getMetadata().coordinationMetadata().equals(clusterState.getMetadata().coordinationMetadata())
                true,
            .readClusterStateInParallel(
                    DefaultRemoteStoreSettings.INSTANCE
            .numberOfReplicas(1)
            .nodeId("nodeA")
            });
            eq(manifest),
                .put(
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(1L).build();
                    blobContainer1,
            .readClusterStateInParallel(
    }
        assertThat(manifest.getRoutingTableVersion(), is(expectedManifest.getRoutingTableVersion()));
        remoteClusterStateService.setRemoteIndexMetadataManager(mockedIndexManager);
        RemoteStateTransferException exception = expectThrows(
                any(),
            return null;
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder().indices(indices).build();
        );
            any(ClusterState.class),
import static org.opensearch.gateway.remote.model.RemoteDiscoveryNodes.DISCOVERY_NODES;
            "cluster-uuid2"
        assertThat(manifest.getDiscoveryNodesMetadata(), notNullValue());
                    TEMPLATES_METADATA_FILENAME,
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().checksum(
            repositoriesServiceSupplier,
            .clusterTerm(1L)
        );
        doAnswer(invocation -> {
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
        List<UploadedIndexMetadata> newIndicesToRead = List.of(
            ClusterMetadataManifest.builder().build()
                eq(true),
        remoteClusterStateService.start();
        ArrayList<BlobContainer> mockBlobContainerOrderedList = new ArrayList<>(
        ).diffManifest(ClusterStateDiffManifest.builder().build()).build();
            .stateUUID("state-uuid")
        doAnswer((i) -> {
        remoteClusterStateService.start();
        mockBlobStoreObjects();
            return null;
            true
        remoteClusterStateService.setRemoteIndexMetadataManager(mockedIndexManager);
                eq(Collections.singletonMap(indices.get(0).getIndexName(), null)),
        doReturn(clusterState).when(mockService)
        mockBlobStoreObjects();
    }
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().build();
            "routing-filename",
            expectedClusterStateBuilder.blocks(newClusterBlock);
    public void testWriteFullMetadataInParallelFailureForIndexMetadata() throws IOException {
                        metadata.custom(custom),
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.CUSTOM_DELIMITER;
        final ClusterMetadataManifest clusterManifest2 = generateClusterMetadataManifest(
            .indices(uploadedIndexMetadata)
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, "routing_repository")
            .build();
            List.of(blobContainer1, blobContainer1, blobContainer3, blobContainer3, blobContainer2, blobContainer2)
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
            }
            .stateVersion(1L)
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder().indices(Collections.emptyList()).build();
            .build();
                anyBoolean(),
    }
        if (isRemoteRoutingTableConfigured(settings)) {
    private Supplier<RepositoriesService> repositoriesServiceSupplier;
            new UploadedMetadataAttribute(COORDINATION_METADATA, "key3"),
            previousManifest
            new UploadedMetadataAttribute(SETTING_METADATA, "key4"),
        // new custom metadata to be added
            clusterService,
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
        ClusterState updatedClusterState = remoteClusterStateService.getClusterStateUsingDiff(manifest, clusterState, "test-node");
        ClusterState clusterStateWrong = ClusterState.builder(clusterState).routingTable(RoutingTable.EMPTY_ROUTING_TABLE).build();
                            .numberOfShards(1)
            .templatesMetadata(new UploadedMetadataAttribute(TEMPLATES_METADATA, TEMPLATES_METADATA_FILENAME))
        );
        BytesReference bytes = RemoteClusterMetadataManifest.CLUSTER_METADATA_MANIFEST_FORMAT.serialize(
        );
        remoteClusterStateService.start();
        Metadata.Builder mb = Metadata.builder(clusterState.metadata());
        assertThrows(
            // updated index metadata
            when(blobContainer.readBlob(PERSISTENT_SETTINGS_FILENAME)).thenAnswer(i -> {
        }
            .indicesRouting(List.of(uploadedIndiceRoutingMetadata))
            .put(IndexMetadata.SETTING_INDEX_UUID, index2.getUUID())
                    .templates(templatesMetadata)
        String mockManifestFileName = "manifest__1__2__C__456__" + codecVersion;
    }
                // update
            IndexMetadata updatedIndexMetadata = updatedClusterState.metadata().index(indexName);
            true
        Boolean isUUIDCommitted
    }
        assertEquals(1, remoteClusterStateService.getFullDownloadStats().getSuccessCount());
            .templatesMetadata(new UploadedMetadataAttribute(TEMPLATES_METADATA, TEMPLATES_METADATA_FILENAME))
                        fileName,
            () -> 0L,
    public void testWriteFullMetadataSuccess() throws IOException {
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));
    ) throws IOException {
                    Version.CURRENT
            .indices(indices)
            )
        );
        assertEquals(writtenIndexMetadata.getIndex().getUUID(), "index-uuid");
        assertEquals(expectedClusterState.metadata().clusterUUID(), updatedClusterState.metadata().clusterUUID());
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename__2");
    }
            return null;
                blobContainer2,
        final TemplatesMetadata templatesMetadata = TemplatesMetadata.builder()
            );
        mockService.getClusterStateForManifest(ClusterName.DEFAULT.value(), manifest, NODE_ID, true);
            ),
            assertFalse(
        );
                        FORMAT_PARAMS
    }
        initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode.FAILURE);
            eq(true)
        verify(mockService, times(1)).validateClusterStateFromChecksum(
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
            manifestBuilder.coordinationMetadata(new UploadedMetadataAttribute(COORDINATION_METADATA, COORDINATION_METADATA_FILENAME));
    private static final String HASHES_OF_CONSISTENT_SETTINGS_FILENAME = "consistent-settings-hashes-file__1";
        BlobContainer container = mockBlobStoreObjects();
            diffManifestBuilder.customMetadataUpdated(Collections.singletonList(addedCustom.getWriteableName()));
        Map<String, UploadedMetadataAttribute> newClusterStateCustoms = Map.of(
                    new RemoteIndexPathUploader(
        doReturn(clusterStateWrong).when(mockService)
        assertThat(previousClusterUUID, equalTo("cluster-uuid3"));
    public void testReadLatestMetadataManifestSuccessButIndexMetadataFetchIOException() throws IOException {
import static org.opensearch.gateway.remote.ClusterMetadataManifest.MANIFEST_CURRENT_CODEC_VERSION;
            .metadata(
            .coordinationMetadata(CoordinationMetadata.builder().term(1).build())
import org.opensearch.cluster.routing.RoutingTable;
        // new customs uploaded
                    PERSISTENT_SETTINGS_FILENAME,
        ClusterState clusterState2 = ClusterState.builder(initialClusterState)
                eq(clusterState.metadata().customs()),
        IndexMetadata indexMetadata2 = new IndexMetadata.Builder(index2.getName()).settings(idxSettings2)
                    DefaultRemoteStoreSettings.INSTANCE
import static org.opensearch.gateway.remote.model.RemoteClusterStateCustoms.CLUSTER_STATE_CUSTOM;
                emptyMap(),
            .numberOfShards(1)
            ).numberOfShards(1).numberOfReplicas(0).build();
        final RemoteClusterStateManifestInfo manifestInfo = rcssSpy.writeIncrementalMetadata(
            any(ClusterState.class),
        updatedDiscoveryNodes.getNodes().forEach((nodeId, node) -> assertEquals(updatedClusterState.getNodes().get(nodeId), node));
            true,
        RemoteGlobalMetadataManager mockedGlobalMetadataManager = mock(RemoteGlobalMetadataManager.class);
            () -> remoteClusterStateService.getLatestClusterState(
                assertEquals(metadataAfterUpdate.getIndices().get(i).getIndexUUID(), initialMetadata.getIndices().get(i).getIndexUUID());
        String previousClusterUUID = remoteClusterStateService.getLastKnownUUIDFromRemote("test-cluster");
                any(),
        assertEquals(updatedClusterStateCustom3, updatedClusterState.custom("custom_3"));
        assertEquals(1, remoteClusterStateService.getRemoteStateStats().getStateDiffDownloadValidationFailed());
                eq(clusterState),
        );
            LatchedActionListener<RemoteReadResult> latchedActionListener = invocationOnMock.getArgument(2, LatchedActionListener.class);
import static org.mockito.Mockito.doThrow;
            .numberOfShards(1)
        });
            @Override
            .blocks(clusterBlocks)
        assertEquals(1, remoteClusterStateService.getRemoteStateStats().getStateFullDownloadValidationFailed());
            .routingTableVersion(1L);
                anyBoolean(),
                eq(new ArrayList<IndexMetadata>(clusterState.metadata().indices().values())),
                        .patterns(Arrays.asList("bar-*", "foo-*"))
            )
                clusterState.metadata().clusterUUID(),
        );
            .routingTableVersion(1)
            .build();
            .globalMetadataFileName(globalIndexMetadataName)
            .stateVersion(1L)
                blobContainer1,
            .settingMetadata(new ClusterMetadataManifest.UploadedMetadataAttribute(SETTING_METADATA, "mock-setting-file"))
            manifestBuilder.hashesOfConsistentSettings(
        RemoteClusterStateAttributesManager mockClusterStateAttributeManager = mock(RemoteClusterStateAttributesManager.class);
            .stateUUID("state-uuid")
            public boolean hasNext() {
        assertEquals(exceptionMsg, exception.getSuppressed()[0].getCause().getMessage());
                anyBoolean(),
                .stream()
                        FORMAT_PARAMS
                eq(true),
            LatchedActionListener<RemoteReadResult> latchedActionListener = invocationOnMock.getArgument(2, LatchedActionListener.class);
            return null;
                new UploadedMetadataAttribute(TRANSIENT_SETTING_METADATA, TRANSIENT_SETTINGS_FILENAME)
                    DefaultRemoteStoreSettings.INSTANCE
        );
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
                anyBoolean(),
        assertThat(manifest.getGlobalMetadataFileName(), nullValue());
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
                    compressor,
import static java.util.stream.Collectors.toList;
import org.opensearch.common.blobstore.BlobContainer;
        assertThat(manifest.getIndices().size(), is(1));
        ArgumentCaptor<ActionListener<Void>> actionListenerArgumentCaptor = ArgumentCaptor.forClass(ActionListener.class);
            repositoriesServiceSupplier,
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeIncrementalMetadata(
        mockBlobContainerForClusterUUIDs(uuidBlobContainer, clusterUUIDsPointers.keySet());
    private void mockObjectsForGettingPreviousClusterUUID(
        assertThat(manifest.getIndices().size(), is(1));
        );
                anyBoolean(),
                eq(true),
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
            .clusterTerm(1L)
            .stateVersion(1L)
        initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode.FAILURE);
            eq(true),
        indices.add(uploadedIndiceRoutingMetadata);
            @Override
                Map.of(
            .build();
            IntStream.range(0, initialMetadata.getIndices().size()).forEach(i -> {
                IndexMetadata indexMetadata = indexMetadataMap.get(uploadedIndexMetadata.getIndexUUID());
            new Thread(new Runnable() {
            .clusterTerm(1L)
            .numberOfReplicas(1)
                NODE_ID,
            )
        assertThat(manifest.getIndicesRouting().get(0).getUploadedFilename(), notNullValue());
            .writeMetadataInParallel(
        RemoteReadResult mockedResult = mock(RemoteReadResult.class);
            eq(manifest.getIndices()),
                new RemoteIndexPathUploader(
                assertEquals(metadataAfterUpdate.getCoordinationMetadata(), initialMetadata.getCoordinationMetadata());
    /*
            .stateUUID("state-uuid")
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
        doReturn(clusterStateWrong).when(mockService)
                initialMetadata.getSettingsMetadata().getUploadedFilename()
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeFullMetadata(clusterState, "prev-cluster-uuid")
                anyBoolean(),
        remoteClusterStateService.start();
        UploadedMetadataAttribute settingsMetadata,
        // TODO Make the publication flag parameterized
                BytesReference bytesReference = SETTINGS_METADATA_FORMAT.serialize(
            return null;
        mockBlobStoreObjects();
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
            return "BlobNameMatcher[Expected blobName: " + expectedBlobName + "]";
                    repositoriesServiceSupplier,
        ).getClusterMetadataManifest();
                new RemoteIndexPathUploader(
    }
        doAnswer(invocation -> {
        BlobContainer blobContainer3 = mock(BlobContainer.class);
        doReturn(clusterState).when(mockService)
            Settings.builder()
            clusterService,
    }
        verify(mockService, times(1)).validateClusterStateFromChecksum(
            .indices(List.of())
        ArgumentCaptor<LatchedActionListener<RemoteReadResult>> latchCapture = ArgumentCaptor.forClass(LatchedActionListener.class);
        });
                eq(manifest),
                    new UploadedMetadataAttribute("custom_2", "test-cluster-state-custom2-file__1")
        remoteClusterStateService.start();
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
            .build();
            .build();
import org.opensearch.repositories.RepositoryMissingException;
        );
            blobStoreRepository.getCompressor(),
    public void testTemplatesMetadataOnlyUpdated() throws IOException {
     * In final manifest codec version should be 2 and have metadata files updated,
    }
            .build();
import org.opensearch.cluster.node.DiscoveryNodes;
                "custom_md_2",
            new ClusterStateChecksum(clusterState, threadPool)
            actionListenerArgumentCaptor.getValue().onFailure(new RuntimeException("Cannot upload to remote"));
        assertFalse(manifest2.getCustomMetadataMap().containsKey("custom1"));
            previousClusterState,
        }
        doReturn(clusterStateWrong).when(mockService)
        assertEquals(
                any(),
            .routingTableVersion(1)
                eq(false),
            .stateVersion(clusterState.version())
        assertThat(manifest.getIndices().get(0).getIndexName(), is(uploadedIndexMetadata.getIndexName()));
            .routingTable(RoutingTable.builder().addAsNew(indexMetadata).version(1L).build())
        mockBlobStoreObjects();
        mockBlobStoreObjects();
            eq(false),
            eq(manifest.getCustomMetadataMap()),
            .clusterBlocksMetadata(new UploadedMetadataAttribute(CLUSTER_BLOCKS, CLUSTER_BLOCKS_FILENAME))
        remoteClusterStateService.start();
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
            manifest.getClusterUUID(),
                BytesReference bytes = INDEX_METADATA_FORMAT.serialize(indexMetadata, "add-test-index-file__2", compressor, FORMAT_PARAMS);
    private static final String COORDINATION_METADATA_FILENAME = "coordination-metadata-file__1";
import static org.opensearch.gateway.remote.RemoteGlobalMetadataManager.GLOBAL_METADATA_UPLOAD_TIMEOUT_DEFAULT;
                eq(uploadedCustomMetadataKey),
            () -> remoteClusterStateService.writeMetadataInParallel(
            updatedClusterState.getMetadata().templates().equals(clusterState.getMetadata().getTemplates())
    }
        Map<String, String> clusterUUIDsPointers = Map.of(
    }
            ClusterState.Custom originalClusterStateCustom = clusterState.customs().get(clusterStateCustomName);
            .stateVersion(1L)
            .hashesOfConsistentSettings(
        AsyncMultiStreamBlobContainer container = (AsyncMultiStreamBlobContainer) mockBlobStoreObjects(AsyncMultiStreamBlobContainer.class);
    }
        );
        when(blobContainer.readBlob(mockManifestFileName)).thenReturn(new ByteArrayInputStream(bytes.streamInput().readAllBytes()));
                    repositoriesServiceSupplier,
            DiffableStringMap hashesOfConsistentSettings = new DiffableStringMap(Map.of("secure_setting_key", "secure_setting_value"));
        BlobNameMatcher(String expectedBlobName) {
            .stateVersion(1L)
            eq(true),
                "test-node-id",
                metadataAfterUpdate.getSettingsMetadata().getUploadedFilename(),
            .clusterUUID("cluster-uuid")
            clusterState.getClusterName().value(),
            .metadata(Metadata.builder().coordinationMetadata(coordinationMetadata))
            "cluster-uuid3",
            .build();
        uploadedClusterStateCustomMap.keySet().forEach(key -> assertTrue(updatedClusterState.customs().containsKey(key)));
            .stateUUID("state-uuid")
        }
            eq(false),
            String settingsFileName = getFileNameFromPath(clusterMetadataManifest.getSettingsMetadata().getUploadedFilename());
            .readClusterStateInParallel(
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename__2");
        assertThat(manifest.getGlobalMetadataFileName(), nullValue());
import org.opensearch.action.LatchedActionListener;
                .entrySet()
            "cluster-uuid1",
        remoteClusterStateService.setRemoteIndexMetadataManager(mockedIndexManager);
                eq(false),
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));
        Settings updatedTransientSettings = Settings.builder()
                emptyList(),
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
                eq(true),
        Map<String, IndexMetadata> indexMetadataMap1 = Map.of("index-uuid1", indexMetadata1, "index-uuid2", indexMetadata2);
                new ClusterMetadataManifest.UploadedMetadataAttribute(IndexGraveyard.TYPE, "mock-custom-" + IndexGraveyard.TYPE + "-file")
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");
        );
        }
            .stateUUID("state-uuid")
                eq(emptyMap()),
            .previousClusterUUID("prev-cluster-uuid")
                eq(manifest.getClusterUUID()),
                anyBoolean(),
            eq(emptyMap()),
            });
        // already existing cluster state customs
                eq(emptyList()),
            verify(mockClusterStateAttributeManager, times(1)).readAsync(
            Locale.getDefault(),
            previousManifest
        ClusterState stateFromCache = remoteClusterStateService.getRemoteClusterStateCache()
            assertEquals(metadataAfterUpdate.getCoordinationMetadata(), initialMetadata.getCoordinationMetadata());
        assertNotEquals(
            .routingTableVersion(1)
            ? new HashMap<>(indexMetadataMap1)
                anyBoolean(),
            newCustomMetadataMap,
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");
            .build();
        remoteClusterStateService.start();
import org.opensearch.gateway.remote.model.RemoteTransientSettingsMetadata;
        remoteClusterStateService.start();
                true,
        assertEquals(indexMetadataMap.get(index.getName()).getNumberOfReplicas(), indexMetadata.getNumberOfReplicas());
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
            1,
        assertEquals(0, remoteClusterStateService.getFullDownloadStats().getFailedCount());
            .previousClusterUUID("prev-cluster-uuid")
                eq(manifest.getClusterUUID()),
                blobContainer2,
    public void testSettingsMetadataOnlyUpdated() throws IOException {
                eq(manifest.getCustomMetadataMap()),
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
        remoteClusterStateService.start();
        verify(mockService, times(0)).validateClusterStateFromChecksum(
            eq(true),
            .clusterUUID("cluster-uuid")
                    .version(randomNonNegativeLong())
                eq(manifest.getClusterStateCustomMap()),
            DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(clusterState.nodes()).add(node);
                eq(manifest.getIndicesRouting()),
                true,
                );
                anyBoolean(),
                .build();
import java.util.stream.Collectors;
        remoteClusterStateService.start();
                anyBoolean(),
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename__2");
            );
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
                    blobContainer3,
            false
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, "routing_repository")
        expectThrows(
            "test-index",
            .indices(List.of())
                    .putCustom("custom_metadata_type", new CustomMetadata1("mock_custom_metadata"))
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().build();
            eq(manifest),
            false,
            clusterUUIDsPointers.get("cluster-uuid2"),
import org.opensearch.repositories.blobstore.BlobStoreRepository;
            .stateVersion(13)
        }
import org.opensearch.gateway.remote.model.RemoteReadResult;
                    .putCustom(customMetadata1.getWriteableName(), customMetadata1)
            IntStream.range(0, initialMetadata.getIndices().size()).forEach(i -> {
        assertThat(manifest.getIndicesRouting().get(0).getIndexUUID(), is(uploadedIndiceRoutingMetadata.getIndexUUID()));
    }
    public void testFailWriteIncrementalMetadataWhenManifestNull() {
        ).getClusterMetadataManifest();
            );
        assertThat(manifest.getPreviousClusterUUID(), is(expectedManifest.getPreviousClusterUUID()));
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder().indices(Collections.emptyList()).build();
    /*
            .stateUUID("state-uuid")
import org.opensearch.gateway.remote.model.RemoteClusterMetadataManifest;
            // update blocks
        final List<UploadedIndexMetadata> indices = List.of(uploadedIndexMetadata);
        );
            NODE_ID,
        ).build();
        );
                eq(manifest.getIndicesRouting()),
            }
        when(mockedResult.getComponent()).thenReturn(COORDINATION_METADATA);
            .stateUUID("state-uuid")
        doAnswer(invocationOnMock -> {
    static ClusterState.Builder generateClusterStateWithAllAttributes() {
                    templatesMetadata,
        assertThat(manifest.getIndices().get(0).getIndexUUID(), is(uploadedIndexMetadata.getIndexUUID()));
        verifyMetadataAttributeOnlyUpdated(updater, (initialMetadata, metadataAfterUpdate) -> {
        final List<UploadedIndexMetadata> indices = List.of(uploadedIndexMetadata);
        Map<String, UploadedMetadataAttribute> uploadedCustomMetadataMap = new HashMap<>(
        AsyncMultiStreamBlobContainer container = (AsyncMultiStreamBlobContainer) mockBlobStoreObjects(AsyncMultiStreamBlobContainer.class);
        verify(mockedGlobalMetadataManager, times(1)).getGlobalMetadata(eq(manifest.getClusterUUID()), eq(manifest));
        doAnswer((i) -> {
        doAnswer(invocationOnMock -> {
            .routingTableVersion(1L)
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
            clusterMetadataManifest,
            initialClusterState,
            );
    public void testWriteMetadataInParallelIncompleteUpload() throws IOException {
                    assertTrue(metadataAfterUpdate.getCustomMetadataMap().containsKey(k));
        RemoteClusterStateAttributesManager mockedClusterStateAttributeManager = mock(RemoteClusterStateAttributesManager.class);
        Settings indexSettings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
                    .persistentSettings(clusterSettings)
            ClusterName.DEFAULT.value(),
                    FORMAT_PARAMS
                    .put(indexMetadata, true)
        int codecVersion
        verify(mockService, times(1)).validateClusterStateFromChecksum(manifest, clusterState, ClusterName.DEFAULT.value(), NODE_ID, true);
            "cluster-uuid2",
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));
        assertThat(manifest.getClusterStateChecksum(), is(expectedManifest.getClusterStateChecksum()));
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
                BytesReference bytes = COORDINATION_METADATA_FORMAT.serialize(
            "cluster-uuid1",
                    settings,
            .codecVersion(ClusterMetadataManifest.CODEC_V0)
                NetworkModule.getNamedXContents().stream(),
            latchCapture.getValue().onResponse(mockResult);
        assertThat(manifest.getIndices().get(0).getIndexUUID(), is(uploadedIndexMetadata.getIndexUUID()));
        final Settings settings = Settings.builder().put("mock-settings", true).build();
import static org.opensearch.gateway.remote.model.RemoteTemplatesMetadataTests.getTemplatesMetadata;
            .stateUUID("state-uuid")
                .getUploadedFilename()
        assertThat(manifest.getIndicesRouting().get(0).getUploadedFilename(), notNullValue());
        ).getMetadata().getIndices();
                .stream()
        assertThat(manifest.getClusterStateCustomMap().size(), is(1));
            previousClusterState.metadata().coordinationMetadata().term() + 1,
        );
            .stateUUID("state-uuid")
    public void testReadLatestIndexMetadataSuccess() throws IOException {
                    newSettings,
                // since timestamp is part of file name, if file name is same we can confirm that file is not update in global metadata
            .clusterUUID("cluster-uuid")
                false,
                    metadataAfterUpdate.getIndices().get(i).getUploadedFilename(),
            .build();
            blobStoreRepository.getCompressor(),
            .build();
        } else {
        ).diffManifest(ClusterStateDiffManifest.builder().build()).build();
            "index-uuid",
            .clusterUUID("cluster-uuid")
                "custom_2",
        long term,
        verify(mockGlobalMetadataManager, times(1)).readAsync(
                new RemoteReadResult(updatedCoordinationMetadata, COORDINATION_METADATA, COORDINATION_METADATA)
                eq(manifest.getClusterStateCustomMap()),
            .stateUUID("state-uuid")
        );
            .clusterUUID("cluster-uuid")
        assertNotNull(manifest.getSettingsMetadata());
    public void testGetClusterStateForManifest_IncludeEphemeral() throws IOException {
        mockService.getClusterStateUsingDiff(manifest, clusterState, NODE_ID);
                eq(true),
            "cluster-uuid1",
                    CLUSTER_BLOCKS_FILENAME,
            .build();
        ClusterState clusterState = generateClusterStateWithAllAttributes().build();
            clusterState,
    }
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));
            .codecVersion(MANIFEST_CURRENT_CODEC_VERSION)
            .readClusterStateInParallel(
                eq(clusterState.metadata().customs()),
            .build();
        if (addAsNew) {
            ClusterState.UNKNOWN_UUID,
        assertEquals(expectedClusterState.stateUUID(), updatedClusterState.stateUUID());
            "cluster-uuid1",
        assertThat(manifest.getIndicesRouting().get(0).getIndexUUID(), is(uploadedIndiceRoutingMetadata.getIndexUUID()));
    private void mockBlobContainer(
        // TODO Add test with publication flag enabled
            "routing-filename",
        final ClusterMetadataManifest clusterManifest1 = generateClusterMetadataManifest(
        assertTrue(initialManifest.getIndices().stream().anyMatch(indexMetadata -> indexMetadata.getIndexName().equals(initialIndex)));
        assertNull(notInCacheState);
            .routingTableVersion(1)
        assertThat(manifest.getHashesOfConsistentSettings(), notNullValue());
            return null;
            customsToRemove.forEach(mb::removeCustom);
        RemoteGlobalMetadataManager mockedGlobalMetadataManager = mock(RemoteGlobalMetadataManager.class);
        assertThat(manifest.getIndices().get(0).getIndexUUID(), is(uploadedIndexMetadata.getIndexUUID()));
                anyBoolean(),
                anyBoolean(),
                eq(NODE_ID),
            .build();
        Metadata metadata1 = Metadata.builder()
        verify(mockService, times(1)).validateClusterStateFromChecksum(
                eq(true),
        );
            remoteClusterStateService.getLatestClusterState(
                }
        ArgumentCaptor<LatchedActionListener> listenerArgumentCaptor = ArgumentCaptor.forClass(LatchedActionListener.class);
            .metadata(Metadata.builder().coordinationMetadata(coordinationMetadata))
        String customMetadataFilename = "test-custom3-file__1";
                true,
            .clusterUUID("cluster-uuid")
    }
        remoteClusterStateService = new RemoteClusterStateService(
        final ClusterState clusterState = generateClusterStateWithGlobalMetadata().nodes(nodesWithLocalNodeClusterManager()).build();
            namedWriteableRegistry,
            .codecVersion(CODEC_V2)
            "routing-filename",
        final TestClusterStateCustom1 custom1 = new RemoteClusterStateTestUtils.TestClusterStateCustom1("custom-1");
                                IndexTemplateMetadata.builder("template" + randomAlphaOfLength(3))
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
        final ClusterState clusterState = generateClusterStateWithOneIndex().build();
                newIndicesToRead,
    static ClusterState.Builder generateClusterStateWithOneIndex() {
        mockBlobStoreObjects();
        });
            .routingTableVersion(clusterState.routingTable().version())
        mockBlobContainerForGlobalMetadata(blobContainer3, clusterManifest3, metadata3);
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
    public void testGetValidPreviousClusterUUIDWithInvalidMultipleChains() throws IOException {
        when((blobStoreRepository.basePath())).thenReturn(BlobPath.cleanPath().add("base-path"));
        assertEquals(clusterState.getRoutingTable().version(), updatedClusterState.getRoutingTable().version());
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
    }
            TemplatesMetadata templatesMetadata = TemplatesMetadata.builder()
        );
     * even if it was not changed in this cluster state update
                    .clusterUUID("cluster-uuid")
        );
        assertNotNull(remoteClusterStateService.getDiffDownloadStats());
            String coordinationFileName = getFileNameFromPath(clusterMetadataManifest.getCoordinationMetadata().getUploadedFilename());
        assertEquals(0, remoteClusterStateService.getRemoteStateStats().getCleanupAttemptFailedCount());
                    );
                anyBoolean(),
            initialManifest
                manifest,
        assertThat(manifest.getRoutingTableVersion(), is(expectedManifest.getRoutingTableVersion()));
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(1L).build();
                throw new RuntimeException(e);
        long newClusterStateVersion = newClusterState.getVersion();
            );
 * The OpenSearch Contributors require contributions made to
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
            LatchedActionListener<RemoteReadResult> latchedActionListener = invocationOnMock.getArgument(2, LatchedActionListener.class);
            .getClusterMetadataManifest();
    }
        remoteClusterStateService.start();
        when((blobStoreRepository.basePath())).thenReturn(BlobPath.cleanPath().add("base-path"));
        });
        boolean differGlobalMetadata,
        );
            "remote_store_repository"
                emptyList(),
            .settingMetadata(new ClusterMetadataManifest.UploadedMetadataAttribute(SETTING_METADATA, "mock-setting-file"))
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
            clusterStateWrong,
        Map<String, Boolean> clusterUUIDCommitted = Map.of("cluster-uuid1", true, "cluster-uuid2", true, "cluster-uuid3", false);
        RemoteGlobalMetadataManager mockGlobalMetadataManager = mock(RemoteGlobalMetadataManager.class);
            latchedActionListener.onResponse(new RemoteReadResult(updatedPersistentSettings, SETTING_METADATA, SETTING_METADATA));
            ).getMetadata().getIndices()
        if (codecVersion >= CODEC_V2) {
        assertNull(manifest.getGlobalMetadataFileName());
                    threadPool,
            } catch (IOException e) {
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder()
            .numberOfShards(1)
        ).numberOfShards(1).numberOfReplicas(0).build();
                any()
            new UploadedMetadataAttribute(TEMPLATES_METADATA, "key5"),
            manifest,
        }).when(mockedGlobalMetadataManager)
                assertEquals(metadataAfterUpdate.getIndices().get(i).getIndexUUID(), initialMetadata.getIndices().get(i).getIndexUUID());
                    HASHES_OF_CONSISTENT_SETTINGS_FILENAME,
                    templatesFileName,
                anyBoolean(),
            .stateVersion(1L)
        assertThat(manifest.getIndices().size(), is(1));
        doAnswer(invocation -> {
            .put(RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)
                eq(true),
     * Initially codec version is 0 and global metadata is also null, we will perform index metadata update.
            .build();
                eq(true),
    public void testRemoteRoutingTableNotInitializedWhenDisabled() {
import org.opensearch.common.blobstore.stream.write.WriteContext;
        // verify that initial index is removed, and new index are added
        final TestClusterStateCustom2 custom2 = new RemoteClusterStateTestUtils.TestClusterStateCustom2("custom-2");
                any(),
        mockBlobContainer(blobContainer2, clusterManifest2, indexMetadataMap2, MANIFEST_CURRENT_CODEC_VERSION);
        assertThat(manifest.getIndices().get(0).getIndexUUID(), is(uploadedIndexMetadata.getIndexUUID()));
                eq(manifest.getIndices()),
                new UploadedMetadataAttribute("custom_1", "test-cluster-state-custom1-file__1"),
        assertEquals(12, actionListenerArgumentCaptor.getAllValues().size());
                () -> 0L
        verifyCodecMigrationManifest(ClusterMetadataManifest.CODEC_V0);
            )
            .build();
    private BlobStoreRepository blobStoreRepository;
import java.io.IOException;
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
        assertThat(manifest.getPreviousClusterUUID(), is(expectedManifest.getPreviousClusterUUID()));
            .clusterTerm(1L)
        assertEquals("Timed out waiting to read cluster state from remote within timeout " + readTimeOut + "s", exception.getMessage());
    private ClusterService clusterService;
            eq(true),
        initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode.FAILURE);
            assertEquals(metadataAfterUpdate.getIndices().size(), initialMetadata.getIndices().size());
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
            .numberOfShards(1)
                return new ByteArrayInputStream(bytes.streamInput().readAllBytes());
            settings,
                true,
        RemoteClusterStateService spiedService = spy(remoteClusterStateService);
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
        int codecVersion = clusterMetadataManifest.getCodecVersion();
            .indices(List.of(uploadedIndexMetadata))
            settings,
            .build();
        remoteClusterStateService.start();
            INDEX_ROUTING_METADATA_PREFIX
        assertEquals(clusterState.metadata().hashesOfConsistentSettings(), updatedClusterState.metadata().hashesOfConsistentSettings());
        ClusterMetadataManifest clusterMetadataManifest,
            any()
            eq(true)
        );
            new ClusterStateChecksum(clusterState, threadPool)
        when(blobContainer1.path()).thenReturn(blobPath);
    @Before
                clusterState.metadata().clusterUUID()
            .customMetadataMap(uploadedCustomMetadataMap)
import org.junit.After;
    private void mockBlobContainerForGlobalMetadata(
            .numberOfShards(11)
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
            threadPool,
        clusterMetadataManifest.getIndices().forEach(uploadedIndexMetadata -> {
    public void testReadClusterStateInParallel_UnexpectedResult() throws IOException {
            eq(false),
                eq(true),
                eq(emptyMap()),
                    clusterSettings,
        BlobContainer blobContainer2 = mock(BlobContainer.class);
        when((blobStoreRepository.basePath())).thenReturn(BlobPath.cleanPath().add("base-path"));
            latchedActionListener.onResponse(new RemoteReadResult(newIndexMetadata, INDEX, "test-index-1"));
            .clusterStateCustomMetadataMap(uploadedClusterStateCustomMap)
        when(blobStore.blobContainer(ArgumentMatchers.any())).thenReturn(uuidBlobContainer, mockBlobContainerOrderedArray);
        assertNull(manifest.getClusterStateChecksum());
            return null;
                eq(true)
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));
    }
                )
            .put(IndexMetadata.SETTING_INDEX_UUID, index1.getUUID())
            .codecVersion(CODEC_V2)
            .indices(Collections.emptyList())
        final ClusterMetadataManifest manifestAfterMetadataUpdate;
        when(blobPath.iterator()).thenReturn(new Iterator<String>() {
            eq(true),
            when(blobContainer.readBlob(CLUSTER_BLOCKS_FILENAME)).thenAnswer(invocationOnMock -> {
                    Version.CURRENT
            .clusterUUID("cluster-uuid")
import java.util.Collections;
            .indicesRouting(List.of(uploadedIndiceRoutingMetadata))
        Exception e = assertThrows(
        // Initial cluster state with index.
    }
        clusterSettings.applySettings(newSettings);
            .indicesRouting(List.of(uploadedIndiceRoutingMetadata))
    public void testGetClusterStateForManifestWithChecksumValidationEnabledWithMismatch() throws IOException {
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeFullMetadata(clusterState, "prev-cluster-uuid")
            clusterMetadataManifest,
                    .getUploadedFilename()
            .settingMetadata(settingsMetadata)
                eq(emptyMap()),
        BlobContainer blobContainer = mockBlobStoreObjects();
        ArgumentCaptor<ActionListener<Void>> actionListenerArgumentCaptor = ArgumentCaptor.forClass(ActionListener.class);
            .getClusterMetadataManifest();
    }
        doAnswer((i) -> {
            .settingMetadata(new UploadedMetadataAttribute(SETTING_METADATA, PERSISTENT_SETTINGS_FILENAME))
                            .settings(
            .readAsync(eq("test-index-1"), argThat(new BlobNameMatcher(indexFilename)), any(LatchedActionListener.class));
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
                assertEquals(metadataAfterUpdate.getIndices().get(i).getIndexUUID(), initialMetadata.getIndices().get(i).getIndexUUID());
            eq(true),
        );
        TestClusterStateCustom3 updatedClusterStateCustom3 = new TestClusterStateCustom3("custom_3");
            .build();
                    FORMAT_PARAMS
    private void verifyCodecMigrationManifest(int previousCodec) throws IOException {
            .previousClusterUUID("prev-cluster-uuid")
        if (randomBoolean()) {
        final Settings transientSettings = Settings.builder().put("mock-transient-settings", true).build();
            eq(manifest),
        int writeTimeout = 2;
        ClusterState clusterState = generateClusterStateWithAllAttributes().build();
        verify(mockService, times(1)).validateClusterStateFromChecksum(
    public void testGetClusterStateFromManifest_CodecV1() throws IOException {
        mockBlobContainer(blobContainer, clusterMetadataManifest, indexMetadataMap, ClusterMetadataManifest.CODEC_V0);
        ClusterState clusterState1 = ClusterState.builder(initialClusterState)
                true,
                String fileName = uploadedIndexMetadata.getUploadedFilename();
        );
        assertThat(manifest.getIndices().size(), is(1));
            .metadataVersion(clusterState.metadata().version())
                new RemoteIndexPathUploader(
                IndexMetadata indexMetadata = indexMetadataMap.get(uploadedIndexMetadata.getIndexUUID());
            .clusterUUID(clusterState.getMetadata().clusterUUID())
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
                    )
        Metadata metadata
        remoteClusterStateService.start();
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().checksum(
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
import static org.opensearch.gateway.remote.model.RemoteCoordinationMetadata.COORDINATION_METADATA;
        }).when(mockedIndexManager).readAsync(any(), any(), listenerArgumentCaptor.capture());
        remoteClusterStateService.setRemoteGlobalMetadataManager(mockedGlobalMetadataManager);
                    settings,
                    blobContainer3,
    }
            .clusterBlocksMetadata(new UploadedMetadataAttribute(CLUSTER_BLOCKS, CLUSTER_BLOCKS_FILENAME))
            WriteContext writeContext = writeContextArgumentCaptor.getValue();
                        blobStoreRepository.getCompressor(),
                    coordinationMetadata,
    }
                eq(manifest.getClusterUUID()),
        initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode.FAILURE);
                eq(true),
            manifestBuilder.settingMetadata(new UploadedMetadataAttribute(SETTING_METADATA, PERSISTENT_SETTINGS_FILENAME));
        assertThat(manifest.getIndices().size(), is(1));
        );
        assertEquals(indexMetadataMap.get(index.getName()).getIndex().getName(), index.getName());
import java.util.stream.Stream;
                String fileName = uploadedIndexMetadata.getUploadedFilename();
            "index-uuid",
import static org.opensearch.gateway.remote.model.RemoteTemplatesMetadata.TEMPLATES_METADATA;
        int replicaShards,
        doAnswer(invocation -> {
        Map<String, String> clusterUUIDsPointers = Map.of(
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
            previousClusterState,
    }
                any()
            .put(IndexTemplateMetadata.builder("template-1").patterns(List.of("test-index* ")).build())
        doAnswer(invocation -> {
                )
        // index already present in previous state
            previousManifest
        assertThat(manifest.getPreviousClusterUUID(), is(expectedManifest.getPreviousClusterUUID()));
        // new index to be added
            // setting metadata file would have changed
 * SPDX-License-Identifier: Apache-2.0
        when(blobPath.buildAsString()).thenReturn("/blob/path/");
                emptyMap(),
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
        assertFalse(manifest1.getIndices().stream().anyMatch(indexMetadata -> indexMetadata.getIndexName().equals(initialIndex)));
            .metadata(
                String custom = entry.getKey();
            .indices(List.of(uploadedIndexMetadata))
            new UploadedMetadataAttribute(SETTING_METADATA, "key4"),
            .clusterUUID("cluster-uuid")
        assertThat(manifest.getClusterStateCustomMap().size(), is(0));
            true,
                eq(NODE_ID),
        Map<String, IndexMetadata> indexMetadataMap,
                "custom_md_1",
            randomFrom(
            previousClusterState,
        assertThat(manifest.getIndices().get(0).getUploadedFilename(), notNullValue());
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().checksum(
        assertEquals(stateFromCache2.getMetadata(), state.getMetadata());
                    .put(IndexMetadata.SETTING_INDEX_UUID, "add-test-index-uuid")
                    "custom_md_2",
            assertEquals(capturedWriteContext.get("metadata").getExpectedChecksum().longValue(), expectedChecksum);
        Assert.assertThat(manifestDetails, nullValue());
        final ClusterMetadataManifest manifestAfterUpdate = remoteClusterStateService.writeIncrementalMetadata(
            () -> remoteClusterStateService.readClusterStateInParallel(
            .clusterTerm(clusterState.term())
            any(ClusterState.class),
        assertEquals(0, remoteClusterStateService.getRemoteStateStats().getStateFullDownloadValidationFailed());
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
                eq(true),
        );
        );
            diffManifestBuilder.indicesDeleted(new ArrayList<>(indicesToDelete));
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
                eq(NODE_ID),
        assertEquals(newIndexMetadata, updatedClusterState.metadata().index(newIndexMetadata.getIndex()));
                eq(clusterState),
        assertThat(manifest.getCustomMetadataMap().size(), is(2));
        initializeRoutingTable();
        Settings newSettings = Settings.builder().put("cluster.remote_store.state.read_timeout", readTimeOut + "s").build();
        );
            randomAlphaOfLength(10),
        remoteClusterStateService.start();
            .build();
                    is -> readFrom(is, namedWriteableRegistry, addedCustom.getWriteableName())
            .clusterTerm(clusterState.term())
            expectedManifest,
                    "custom_1",
                RemoteHashesOfConsistentSettings remoteHashesOfConsistentSettings = new RemoteHashesOfConsistentSettings(
            try {
        verifyMetadataAttributeOnlyUpdated(updater, (initialMetadata, metadataAfterUpdate) -> {
        final RemoteClusterStateService rcssSpy = Mockito.spy(remoteClusterStateService);
                Metadata.builder()
        }).when(mockedClusterStateAttributeManager).writeAsync(any(), any(), listenerArgumentCaptor.capture());
        );
import java.util.Map;
        UploadedMetadataAttribute templatesMetadata,
        );
            mockManifestFileName,
            .stateVersion(1L)
        mockObjectsForGettingPreviousClusterUUID(clusterUUIDsPointers);
        initializeWithChecksumEnabled(
            .put(RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");
        doAnswer((i) -> {
        );
                    .coordinationMetadata(coordinationMetadata)
import org.opensearch.common.compress.DeflateCompressor;
        }
        ).getClusterMetadataManifest();
                assertEquals(metadataAfterUpdate.getIndices().get(i).getIndexName(), initialMetadata.getIndices().get(i).getIndexName());
                    newSettings,
        remoteClusterStateService.start();
        final UploadedIndexMetadata uploadedIndiceRoutingMetadata = new UploadedIndexMetadata(
            .build();
                        clusterSettings,
                )
import static org.opensearch.gateway.remote.model.RemotePersistentSettingsMetadata.SETTINGS_METADATA_FORMAT;
            RemoteStateTransferException.class,
    public void testGetClusterStateForManifestWithChecksumValidationEnabledWithNullChecksum() throws IOException {
        assertEquals(1, remoteClusterStateService.getFullDownloadStats().getSuccessCount());
            .stateVersion(12)
                true
                any(),
                );
                .filter(uploadedIndex -> uploadedIndex.getIndexName().equals(index1.getName()))
import org.opensearch.cluster.metadata.IndexGraveyard;
                anyBoolean(),
        when(repositoriesService.repository("routing_repository")).thenReturn(blobStoreRepository);
        assertThat(manifest.getIndicesRouting().get(0).getIndexName(), is(uploadedIndiceRoutingMetadata.getIndexName()));
            manifestBuilder.transientSettingsMetadata(
                    repositoriesServiceSupplier,
        assertEquals(clusterState.metadata().getCustoms(), updatedClusterState.metadata().getCustoms());
                return new ByteArrayInputStream(bytesReference.streamInput().readAllBytes());
                eq(false),
            .build();
                eq(true),
            .settingMetadata(new UploadedMetadataAttribute(SETTING_METADATA, PERSISTENT_SETTINGS_FILENAME))
            // Verify that index metadata information is same in manifest files
                    compressor,
        // update index1, index2 is unchanged
            "test-index",
        doReturn(clusterStateWrong).when(mockService)
        ConcurrentHashMap<String, WriteContext> capturedWriteContext = new ConcurrentHashMap<>();
import java.util.List;
        indexMetadata1 = new IndexMetadata.Builder(indexMetadata1).version(indexMetadata1.getVersion() + 1).build();
                true,
            eq(false),
        assertThat(manifest.getRoutingTableVersion(), is(expectedManifest.getRoutingTableVersion()));
            listenerArgumentCaptor.getValue().onResponse(mockedResult);
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
        remoteClusterStateService = new RemoteClusterStateService(
        // already existing cluster state customs
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
        assertNotNull(remoteClusterStateService.getDiffDownloadStats());
        }).doAnswer((i) -> {
        remoteClusterStateService = new RemoteClusterStateService(
            routingTableBuilder.addAsNew(indexMetadata);
                new UploadedMetadataAttribute("custom_md_2", "test-custom2-file__1")
            )
    }
            )
            )
            assertNotEquals(originalClusterStateCustom, updateClusterStateCustom);
        Map<String, IndexMetadata> indexMetadataMap = remoteClusterStateService.getLatestClusterState(
    public void testCoordinationMetadataOnlyUpdated() throws IOException {
                    )
        when(blobContainer.readBlob(uploadedIndexMetadata.getUploadedFilename())).thenThrow(FileNotFoundException.class);
            .build();
        );
        BlobContainer container = mockBlobStoreObjects();
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
        assertNotEquals(
import java.io.FileNotFoundException;
            });
            .transientSettingsMetadata(new UploadedMetadataAttribute(TRANSIENT_SETTING_METADATA, TRANSIENT_SETTINGS_FILENAME))
                anyBoolean(),
                anyBoolean(),
            () -> remoteClusterStateService.getLatestClusterMetadataManifest(
                eq(true),
            List.of(
        mockService.getClusterStateUsingDiff(manifest, clusterState, NODE_ID);
        IndexMetadata indexMetadata1 = IndexMetadata.builder("index1")
            : Map.of("index-uuid1", indexMetadata5);
    public void testReadGlobalMetadataIOException() throws IOException {
        } else {
            )
                eq(true),
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
            .writeMetadataInParallel(
            diffManifestBuilder.indicesUpdated(Collections.singletonList(indexMetadata.getIndex().getName()));
        when(blobPath.add(anyString())).thenReturn(blobPath);
                eq(manifest.getIndicesRouting()),
        doReturn(clusterState).when(mockService)
        });
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
                return new ByteArrayInputStream(bytes.streamInput().readAllBytes());
                eq(true),
    }
            // updated persistent settings
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
            assertEquals(metadataAfterUpdate.getTemplatesMetadata(), initialMetadata.getTemplatesMetadata());
    public void testGetValidPreviousClusterUUIDWithMultipleChains() throws IOException {
            eq(true),
            .put("node.attr." + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "remote_store_repository")
        final ClusterState previousClusterState = ClusterState.builder(ClusterName.DEFAULT)
                    .remove(initialIndex)
        assertEquals(indexMetadataMap.size(), 1);
        TemplatesMetadata updatedTemplateMetadata = getTemplatesMetadata();
        verifyMetadataAttributeOnlyUpdated(updater, (initialMetadata, metadataAfterUpdate) -> {
                )
                any(),
        doAnswer(invocation -> {
            .indicesRouting(List.of(uploadedIndiceRoutingMetadata))
            AssertionError.class,
        ClusterState clusterState = generateClusterStateWithAllAttributes().build();
        repositoriesServiceSupplier = mock(Supplier.class);
            .numberOfShards(primaryShards)
                eq(true),
            .clusterTerm(1L)
                any(),
        clusterService = mock(ClusterService.class);
        long expectedChecksum = RemoteTransferContainer.checksumOfChecksum(new ByteArrayIndexInput("metadata-filename", writtenBytes), 8);
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
    public void testWriteIncrementalMetadataSuccessWithChecksumValidationEnabled() throws IOException {
        // custom3 is unchanged
            INDEX_ROUTING_METADATA_PREFIX
            .stateVersion(1L)
            .metadata(Metadata.builder().coordinationMetadata(coordinationMetadata))
                eq(true),
    }
                    "custom_md_1",
            )
                .get()
                emptyMap(),
        assertThat(manifest.getClusterBlocksMetadata(), nullValue());
        assertEquals(1, remoteClusterStateService.getDiffDownloadStats().getFailedCount());
        verifyCodecMigrationManifest(CODEC_V1);
            .clusterUUID("cluster-uuid")
        final ClusterState previousClusterState = ClusterState.builder(ClusterName.DEFAULT)
                    "custom_2",
    }
                eq(Collections.emptyMap()),
        RemoteStateTransferException ex = expectThrows(
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
        assertThat(manifest.getIndices().get(0).getIndexName(), is(uploadedIndexMetadata.getIndexName()));
import static org.opensearch.gateway.remote.routingtable.RemoteIndexRoutingTable.INDEX_ROUTING_METADATA_PREFIX;
        settings = Settings.builder().put(settings).put(REMOTE_PUBLICATION_SETTING_KEY, true).build();
            );
import static java.util.Collections.emptyList;
        assertEquals(updatedDiscoveryNodes.getSize(), updatedClusterState.getNodes().getSize());
                    FORMAT_PARAMS
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            Metadata.Custom updatedCustomMetadata = updatedClusterState.metadata().custom(customMetadataName);
                eq(true),
        final CustomMetadata1 customMetadata1 = new CustomMetadata1("custom-metadata-1");
                clusterState.metadata().clusterUUID(),
            .metadataVersion(clusterState.metadata().version())
        assertEquals(0, remoteClusterStateService.getUploadStats().getSuccessCount());
        Map<String, UploadedMetadataAttribute> uploadedClusterStateCustomMap = new HashMap<>(
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));
        BlobMetadata blobMetadata = new PlainBlobMetadata(manifestFileName, 1);
        }).when(mockedGlobalMetadataManager)
            .numberOfReplicas(1)
            assertFalse(
    public void testRemoteStateUploadStats() throws IOException {
            capturedWriteContext.put(writeContext.getFileName().split(DELIMITER)[0], writeContextArgumentCaptor.getValue());
                eq(manifest),
                argThat(new BlobNameMatcher(newClusterStateCustoms.get(uploadedClusterStateCustomMetadataKey).getUploadedFilename())),
                    newClusterBlock,
        RemoteClusterStateAttributesManager mockedClusterStateAttributeManager = mock(RemoteClusterStateAttributesManager.class);
                    blobContainer3,
    static ClusterMetadataManifest.Builder generateClusterMetadataManifestWithAllAttributes() {
        assertEquals(updatedHashesOfConsistentSettings, updatedClusterState.metadata().hashesOfConsistentSettings());
            .checksum(new ClusterStateChecksum(clusterState, threadPool))
    public void testGetClusterStateUsingDiffWithChecksumModeNone() throws IOException {
                return new ByteArrayInputStream(bytesReference.streamInput().readAllBytes());
        }).when(mockedClusterStateAttributeManager)
                    TRANSIENT_SETTINGS_FILENAME,
    public void testReadLatestMetadataManifestSuccessButNoIndexMetadata() throws IOException {
            .readClusterStateInParallel(
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder().indices(indices).build();
    }
            eq(false),
            blobStoreRepository.getNamedXContentRegistry(),
                    Version.CURRENT
        mockBlobContainer(blobContainer3, clusterManifest3, indexMetadataMap3, MANIFEST_CURRENT_CODEC_VERSION);
            CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder()
            .build();
            .previousClusterUUID("prev-cluster-uuid")
            List.of(
                emptyMap(),
        String initialIndex = "test-index";
                anyBoolean(),
            return null;
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedIndexMetadata;
            argThat(new BlobNameMatcher(DISCOVERY_NODES_FILENAME)),
            eq(false),
            diffManifest.isTemplatesMetadataUpdated(),
        RemoteClusterStateAttributesManager mockedClusterStateAttributeManager = mock(RemoteClusterStateAttributesManager.class);
            eq(manifest.getIndices()),
            .build();
            RemoteStateTransferException.class,
        assertNotEquals(
    public void testGetClusterStateUsingDiffWithChecksumModeTraceMismatch() throws IOException {
            .templatesMetadata(new ClusterMetadataManifest.UploadedMetadataAttribute(TEMPLATES_METADATA, "mock-templates-file"))
            .build();
            .nodeId("nodeA")
        when(clusterService.getClusterSettings()).thenReturn(new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));
        assertEquals(clusterState.getRoutingTable().getIndicesRouting(), updatedClusterState.getRoutingTable().getIndicesRouting());
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(1L).build();
import java.util.function.BiConsumer;
        );
        final Index index = new Index("test-index", "index-uuid");
                eq(Collections.singletonMap(indices.get(0).getIndexName(), null)),
import java.util.function.Function;
                    .coordinationMetadata(coordinationMetadata)
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeFullMetadata(clusterState, "prev-cluster-uuid")
        AsyncMultiStreamBlobContainer container = (AsyncMultiStreamBlobContainer) mockBlobStoreObjects(AsyncMultiStreamBlobContainer.class);
                )
        );
            blobContainerMap.put(clusterUUID, mockBlobStoreObjects());
        Map<String, Boolean> clusterUUIDCommitted
        );
            .clusterTerm(1L)
import org.opensearch.repositories.fs.FsRepository;
                IndexGraveyard.TYPE,
            INDEX_ROUTING_METADATA_PREFIX
        remoteClusterStateService.start();
                eq(NODE_ID),
                new UploadedMetadataAttribute("custom_md_2", "test-custom2-file__1")
            )
                    metadata.persistentSettings(),
    public void testReadGlobalMetadata() throws IOException {
                eq(NODE_ID),
                BytesReference bytes = remoteHashesOfConsistentSettings.hashesOfConsistentSettingsFormat.serialize(
        assertThat(manifest.getIndicesRouting().size(), is(1));
            latchedActionListener.onResponse(
            .clusterUUID(clusterState.getMetadata().clusterUUID())
                );
                true,
        initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode.NONE);
        Map<String, String> clusterUUIDsPointers,
        doNothing().when(container).asyncBlobUpload(any(), any());
            previousClusterState,
            .settingMetadata(new ClusterMetadataManifest.UploadedMetadataAttribute(SETTING_METADATA, "mock-setting-file"))
        final ClusterMetadataManifest manifest = manifestInfo.getClusterMetadataManifest();
            argThat(new BlobNameMatcher(TRANSIENT_SETTINGS_FILENAME)),
import static org.opensearch.gateway.remote.model.RemoteIndexMetadata.INDEX_METADATA_FORMAT;
            any(ClusterMetadataManifest.class),
                anyBoolean(),
        if (randomBoolean()) {
        remoteClusterStateService.start();
            IllegalStateException.class,
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(1L).build();
            listenerArgumentCaptor.getValue().onResponse(new RemoteReadResult(indexMetadata, INDEX, INDEX));
        assertThrows(
        assertThat(manifest.getCustomMetadataMap().size(), is(2));
            )
        assertThat(manifest.getIndices().size(), is(1));
                eq(true),
     * Here we will verify global metadata is not uploaded again if change is only in index metadata
        List<UploadedIndexMetadata> indices = new ArrayList<>();
        ).getClusterMetadataManifest();
            .templatesMetadata(new ClusterMetadataManifest.UploadedMetadataAttribute(TEMPLATES_METADATA, "mock-templates-file"))
                .put("random_persistent_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5))
            assertEquals(metadataAfterUpdate.getIndices().size(), initialMetadata.getIndices().size());
        }).when(container).asyncBlobUpload(any(WriteContext.class), actionListenerArgumentCaptor.capture());
     * even if it was not changed in this cluster state update
        ConcurrentHashMap<String, WriteContext> capturedWriteContext = new ConcurrentHashMap<>();
        uploadedClusterStateCustomMap.putAll(newClusterStateCustoms);
        }).when(mockedGlobalMetadataManager)
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
            listenerArgumentCaptor.getValue().onResponse(mockedResult);
import org.opensearch.cluster.routing.remote.InternalRemoteRoutingTableService;
            randomAlphaOfLength(10),
                blobContainer2
        doAnswer(invocationOnMock -> {
        assertNotEquals(diffManifest.isDiscoveryNodesUpdated(), updatedClusterState.getNodes().equals(clusterState.getNodes()));
        assertThat(manifest.getIndicesRouting().get(0).getIndexName(), is(uploadedIndiceRoutingMetadata.getIndexName()));
            true
                    .build()
        });
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));
            newClusterStateCustoms,
                true,
        mockBlobStoreObjects();
        RemoteReadResult mockedResult = mock(RemoteReadResult.class);
        clusterSettings.applySettings(newSettings);
            .metadata(Metadata.builder().coordinationMetadata(coordinationMetadata))
            .metadata(
            .indicesRouting(List.of())
                emptyList(),
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));
            }
                anyBoolean(),
            new UploadedIndexMetadata("test-index-1", "test-index-1-uuid", indexFilename)
            assertEquals(metadataAfterUpdate.getTemplatesMetadata(), initialMetadata.getTemplatesMetadata());
        Map<String, UploadedMetadataAttribute> newCustomMetadataMap = Map.of(
            Arrays.asList(blobMetadata)
            latchedActionListener.onResponse(
                eq(NODE_ID),
     * Here we will verify the migration of manifest file from codec V1.
        });
                Arrays.asList(
        assertThat(manifest.getIndicesRouting().get(0).getIndexName(), is(uploadedIndiceRoutingMetadata.getIndexName()));
        });
                ClusterModule.getNamedXWriteables().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> getFileNameFromPath(entry.getValue().getUploadedFilename())));
        ClusterState newClusterState = remoteClusterStateService.getLatestClusterState(
            return null;
    public void testGetClusterStateForManifestWithChecksumValidationModeNone() throws IOException {
                    newSettings,
import static org.mockito.Mockito.doAnswer;
        newIndicesToRead.forEach(
        // existing custom metadata
            .build();
            .stateUUID("state-uuid")
                    .putCustom("custom3", new CustomMetadata1("mock_custom_metadata3"))
        blobStore = mock(BlobStore.class);
                );
        } else if (codecVersion == CODEC_V1) {
    private class BlobNameMatcher implements ArgumentMatcher<AbstractClusterMetadataWriteableBlobEntity> {
                any()
    public void testWriteIncrementalMetadataSuccessWithRoutingTable() throws IOException {
        assertions.accept(initialManifest, manifestAfterMetadataUpdate);
        final Settings settings = Settings.builder().put("mock-settings", true).build();
        assertThat(manifest.getIndices().get(0).getIndexName(), is(uploadedIndexMetadata.getIndexName()));
            .stateUUID("state-uuid")
                eq(true),
        assertThat(manifest.getRoutingTableVersion(), is(expectedManifest.getRoutingTableVersion()));
    }
        uploadedIndexMetadataList.addAll(newIndicesToRead);
    }
        assertEquals(clusterState.metadata().getIndices(), updatedClusterState.metadata().getIndices());
            "custom_md_3",
                anyBoolean(),
    }
                blobContainer2,
                Metadata.builder(initialClusterState.metadata())
                eq(true),
            .coordinationMetadata(coordinationMetadata)
        );
        int primaryShards,
            eq(false)
import org.opensearch.gateway.remote.model.RemoteClusterStateManifestInfo;
        initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode.NONE);
            .previousClusterUUID("prev-cluster-uuid")
        assertEquals(clusterState.getCustoms(), updatedClusterState.getCustoms());
            );
            .build();
        diffManifest.getIndicesUpdated().forEach(indexName -> {
        ClusterState clusterState1 = ClusterState.builder(initialClusterState)
        remoteClusterStateService.start();
    }
        });
            .coordinationMetadata(new ClusterMetadataManifest.UploadedMetadataAttribute(COORDINATION_METADATA, "mock-coordination-file"))
            diffManifest.isSettingsMetadataUpdated(),
        if (randomBoolean()) {
            .build();
        verify(mockGlobalMetadataManager, times(1)).readAsync(
            Map.of(
                anyBoolean(),
        Map<String, UploadedMetadataAttribute> newClusterStateCustoms = Map.of(
                clusterState.metadata().clusterUUID(),
    public void testWriteIncrementalMetadataSuccessWithChecksumValidationModeNone() throws IOException {
            return null;
            assertTrue(remoteClusterStateService.getRemoteRoutingTableService() instanceof InternalRemoteRoutingTableService);
                    compressor,
                eq(emptyList()),
            );
        );
                (invocationOnMock) -> {
        Metadata expectedMetadata = Metadata.builder()
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
    /*
                anyList(),
        RemoteClusterStateService spiedService = spy(remoteClusterStateService);
            .indices(indices)
            new UploadedMetadataAttribute(COORDINATION_METADATA, "key3"),
        remoteClusterStateService.start();
            .build();
            .previousClusterUUID("prev-cluster-uuid")
        );
            .thenReturn(Arrays.asList(blobMetadata));
                true,
            .metadata(
        });
            anyString(),
                writableRegistry(),
        uploadedClusterStateCustomMap.putAll(newClusterStateCustoms);
        final ClusterMetadataManifest initialManifest = remoteClusterStateService.writeFullMetadata(initialClusterState, "_na_")
        if (randomBoolean()) {
        assertThat(manifest.getIndices().get(0).getUploadedFilename(), notNullValue());
            eq(NODE_ID),
            () -> remoteClusterStateService.getClusterStateUsingDiff(manifest, previousState, "test-node")
            });
                true,
                    .put(indexMetadata2, true)
            anyBoolean()
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");
        ClusterMetadataManifest clusterMetadataManifest,
        publicationEnabled = true;
                .findFirst()
    ) throws IOException {
                    initialMetadata.getIndices().get(i).getUploadedFilename()
            .indices(List.of(uploadedIndexMetadata))
                any(),
                false
            .getClusterMetadataManifest();
    }
            }).start();
        }).when(mockedIndexManager).readAsync(anyString(), any(), listenerArgumentCaptor.capture());
                Metadata.builder(initialClusterState.getMetadata())
        for (String clusterUUID : clusterUUIDs) {
            eq(CLUSTER_BLOCKS),
                    clusterSettings,
import static org.opensearch.gateway.remote.model.RemoteTemplatesMetadata.TEMPLATES_METADATA_FORMAT;
        );
        assertThat(manifest.getIndices().size(), is(1));
    @After
            .metadata(Metadata.builder().coordinationMetadata(coordinationMetadata))
            .metadata(
        clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode.DEBUG);
            writableRegistry(),
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().checksum(
        CustomMetadata3 customMetadata3 = new CustomMetadata3("custom_md_3");
            mb.put(indexMetadata, true);
                blobContainer1,
        }
                newClusterState,
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, "routing_repository")
    private void verifyWriteIncrementalGlobalMetadataFromOlderCodecSuccess(ClusterMetadataManifest previousManifest) throws IOException {
        Metadata newMetadata = Metadata.builder(previousClusterState.metadata()).put(indexMetadata, true).build();
                    FORMAT_PARAMS
        Map<String, IndexMetadata> indexMetadataMap
            .put(stateRepoTypeAttributeKey, FsRepository.TYPE)
            List.of(
            () -> new RemoteClusterStateService(
        List<UploadedIndexMetadata> uploadedIndexMetadataList1 = List.of(
            CustomMetadata2 addedCustom = new CustomMetadata2(randomAlphaOfLength(10));
import org.opensearch.common.settings.ClusterSettings;
        assertThat(manifest.getCoordinationMetadata(), notNullValue());
            .clusterUUID("cluster-uuid")
            .stateVersion(1L)
            when(blobContainer.readBlob("custom-md2-file__1")).thenAnswer(i -> {
            eq(manifest.getIndices()),
            .indices(Collections.emptyList())
        assertEquals(1, remoteClusterStateService.getUploadStats().getSuccessCount());
                    return new ByteArrayInputStream(bytesIndexMetadata.streamInput().readAllBytes());
                anyBoolean(),
                new UploadedMetadataAttribute(HASHES_OF_CONSISTENT_SETTINGS, HASHES_OF_CONSISTENT_SETTINGS_FILENAME)
                new UploadedMetadataAttribute("custom_2", "test-cluster-state-custom2-file__1")
                )
            .build();
    }
            eq(manifest),
        // setup
                .getClusterMetadataManifest();
                    .putCustom(customMetadata1.getWriteableName(), customMetadata1)
        ClusterMetadataManifest clusterMetadataManifest,
    }
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));
            latchedActionListener.onResponse(
    ) throws IOException {
            Map.of(
    public void testReadLatestClusterStateFromCache() throws IOException {
                if (indexMetadata == null) {
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
            .clusterTerm(1L)
            LatchedActionListener<RemoteReadResult> latchedActionListener = invocationOnMock.getArgument(2, LatchedActionListener.class);
            .clusterTerm(1L)
            : "manifestFileName";
                    clusterSettings,
            .build();
                anyBoolean(),
        assertEquals(capturedWriteContext.get("metadata").getWritePriority(), WritePriority.URGENT);
                    .build()
            updatedClusterState.getMetadata().persistentSettings().equals(clusterState.getMetadata().persistentSettings())
        doAnswer(invocation -> {
            1,
            .indices(List.of(uploadedIndexMetadata))
        final ClusterMetadataManifest initialManifest = remoteClusterStateService.writeFullMetadata(initialClusterState, "_na_")
            true,
        );
        ClusterState clusterState = generateClusterStateWithAllAttributes().build();
                    initialMetadata.getIndices().get(i).getUploadedFilename()
            INDEX_ROUTING_METADATA_PREFIX
                return new ByteArrayInputStream(bytes.streamInput().readAllBytes());
            .indices(indices)
        RemoteIndexMetadataManager mockedIndexManager = mock(RemoteIndexMetadataManager.class);
                );
        when(
        );
import org.opensearch.gateway.remote.model.RemoteDiscoveryNodes;
        Exception e = assertThrows(
        });
    ) throws IOException {
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.TestClusterStateCustom2;
        BlobContainer blobContainer = mockBlobStoreObjects();
                );
                    threadPool,
            .stateUUID("state-uuid")
                Map.of(
                    compressor,
            .routingTable(routingTableBuilder.version(1L).build());
            .version(12)
            )
        final RemoteClusterStateService rcssSpy = Mockito.spy(remoteClusterStateService);
        assertEquals(expectedManifest.getStateVersion(), manifest.getStateVersion());
                BytesReference bytes = customMetadataFormat.serialize(addedCustom, "custom-md2-file__1", compressor);
            .clusterUUID("cluster-uuid")
            )
        final ClusterState previousClusterState = clusterState;
                eq(true),
        mockBlobContainer(mockBlobStoreObjects(), expectedManifest, new HashMap<>(), CODEC_V2, 1, 1);
                    repositoriesServiceSupplier,
            "test-node-id",
            latchCapture.getValue().onResponse(mockResult);
        );
            argThat(new BlobNameMatcher(CLUSTER_BLOCKS_FILENAME)),
        Map<String, UploadedMetadataAttribute> customMetadataMap = new HashMap<>();
            new UploadedIndexMetadata("test-index-1", "test-index-1-uuid", "test-index-1-file__2")
    }
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().checksum(
        doAnswer(invocation -> {
            RemoteStateTransferException.class,
        when(blobContainer2.path()).thenReturn(blobPath);
            clusterState,
                    RemoteClusterStateService.RemoteClusterStateValidationMode.TRACE
                eq(true),
        assertThat(manifest.getCustomMetadataMap().size(), not(0));
            when(blobContainer.readBlob(GLOBAL_METADATA_FORMAT.blobName(splitPath[splitPath.length - 1]))).thenAnswer(
        // new index to be added
        RemoteReadResult mockedResult = mock(RemoteReadResult.class);
        remoteClusterStateService.setRemoteGlobalMetadataManager(mockedGlobalMetadataManager);
                    .version(initialClusterState.metadata().version() + 1)
            .readClusterStateInParallel(
    public void testWriteFullMetadataSuccessWithChecksumValidationEnabled() throws IOException {
        final Index index = new Index("test-index", "index-uuid");
            .clusterUUID(clusterUUID)
            () -> rcssSpy.writeMetadataInParallel(
                blobContainer1,
        });
            threadPool,
    }
        ClusterState state = remoteClusterStateService.getLatestClusterState(
        AsyncMultiStreamBlobContainer container = (AsyncMultiStreamBlobContainer) mockBlobStoreObjects(AsyncMultiStreamBlobContainer.class);
                        fileName,
        String globalIndexMetadataName = "global-metadata-file";
                assertEquals(
            when(blobContainer.readBlob(COORDINATION_METADATA_FORMAT.blobName(coordinationFileName))).thenAnswer((invocationOnMock) -> {
        final Settings idxSettings = Settings.builder()
                any(),
            .stateVersion(1L)
            );
            .provideStream(0)
        assertEquals(expectedManifest.getClusterUUID(), manifest.getClusterUUID());
                emptyMap(),
                public void run() {
            );
            LatchedActionListener<RemoteReadResult> latchedActionListener = invocationOnMock.getArgument(2, LatchedActionListener.class);
            this.expectedBlobName = expectedBlobName;
            eq(TRANSIENT_SETTING_METADATA),
                // update
                eq(manifest),
                    .version(initialClusterState.metadata().version() + 1)
        RemoteClusterStateService mockService = spy(remoteClusterStateService);
        final Settings idxSettings = Settings.builder()
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().build();
        doAnswer(invocationOnMock -> {
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
            .readClusterStateInParallel(
        CheckedRunnable<IOException> mockRunnable = mock(CheckedRunnable.class);
import org.opensearch.repositories.blobstore.ChecksumWritableBlobStoreFormat;
        BlobContainer blobContainer = mockBlobStoreObjects();
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
        assertThat(manifest.getSettingsMetadata(), notNullValue());
            new UploadedMetadataAttribute(TEMPLATES_METADATA, "key5"),
        assertThat(manifestAfterUpdate.getCodecVersion(), is(MANIFEST_CURRENT_CODEC_VERSION));
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    private void mockObjectsForGettingPreviousClusterUUID(
                    DISCOVERY_NODES_FILENAME,
            .stateUUID("state-uuid")
        remoteClusterStateService = new RemoteClusterStateService(
                new UploadedMetadataAttribute("custom_1", "test-cluster-state-custom1-file__1"),
            eq(true),
        );
            .nodes(nodes)
        diffManifest.getIndicesDeleted()
            )
    public void testWriteIncrementalMetadataSuccessWhenPublicationEnabled() throws IOException {
            mb.putCustom(addedCustom.getWriteableName(), addedCustom);
            .clusterUUID("cluster-uuid")
import static org.mockito.ArgumentMatchers.anyString;
import org.opensearch.cluster.node.DiscoveryNode;
            assertEquals(metadataAfterUpdate.getCoordinationMetadata(), initialMetadata.getCoordinationMetadata());
        verify(mockClusterStateAttributeManager, times(1)).readAsync(
                    threadPool,
                true,
    private void mockBlobContainer(
                                    .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
                manifest.getClusterUUID(),
                .stream()
    }
    }
        assertThat(manifest.getIndices().get(0).getIndexUUID(), is(uploadedIndexMetadata.getIndexUUID()));
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.TestClusterStateCustom3;
        );
            .customs(
        );
                eq(String.join(CUSTOM_DELIMITER, CLUSTER_STATE_CUSTOM, uploadedClusterStateCustomMetadataKey)),
                any()
                eq(true),
            ).flatMap(Function.identity()).collect(toList())
                anyBoolean(),
import static org.opensearch.gateway.remote.model.RemoteIndexMetadata.INDEX;
            LatchedActionListener<RemoteReadResult> latchedActionListener = invocationOnMock.getArgument(2, LatchedActionListener.class);
            customMetadataMap,
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V2;
        doAnswer(invocation -> {
        DiffableStringMap updatedHashesOfConsistentSettings = getHashesOfConsistentSettings();
            uploadedIndexMetadataList1,
                eq(manifest.getIndicesRouting()),
                            )
        when(blobStoreRepository.getNamedXContentRegistry()).thenReturn(xContentRegistry);
        remoteClusterStateService.setRemoteClusterStateAttributesManager(mockedClusterStateAttributeManager);
            INDEX_ROUTING_METADATA_PREFIX
                emptyList(),
        verifyMetadataAttributeOnlyUpdated(updater, (initialMetadata, metadataAfterUpdate) -> {
            clusterService,
        }).when(mockedClusterStateAttributeManager).readAsync(anyString(), any(), listenerArgumentCaptor.capture());
        @Override
            Thread.sleep(readTimeOut * 1000 + 100);
                newCustomMetadataMap,
        assertTrue(remoteClusterStateService.getUploadStats() != null);
        mockBlobStoreObjects();
            eq(false)
                    actionListenerArgumentCaptor.getValue().onFailure(new RuntimeException("Cannot upload to remote"));
                eq(true),
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
        Metadata metadata3 = Metadata.builder()
            });
        mockBlobStoreObjects();
        assertThat(manifest.getIndicesRouting().get(0).getIndexName(), is(uploadedIndiceRoutingMetadata.getIndexName()));
            "cluster-uuid4"
            any(ClusterState.class),
            argThat(new BlobNameMatcher(COORDINATION_METADATA_FILENAME)),
                    hashesOfConsistentSettings,
            verify(mockedClusterStateAttributeManager, times(1)).readAsync(
        List<NamedWriteableRegistry.Entry> writeableEntries = ClusterModule.getNamedWriteables();
            // Verify that index metadata information is same in manifest files
        final CustomMetadata2 customMetadata2 = new CustomMetadata2("custom-metadata-2");
                throw new RuntimeException(e);
        // Adding difference in EXACTLY on of these randomly will help us test if our uuid trimming logic compares both
                    .getUploadedFilename()
            new ClusterStateChecksum(clusterState, threadPool)
        when(blobContainer.readBlob(manifestFileName)).thenReturn(new ByteArrayInputStream(bytes.streamInput().readAllBytes()));
            eq(ClusterName.DEFAULT.value()),
        mockBlobContainerForGlobalMetadata(blobContainer2, clusterManifest2, metadata2);
        List<UploadedIndexMetadata> indices = new ArrayList<>();
            .indices(indices)
            clusterState,
        initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode.NONE);
            .put("node.attr." + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "remote_store_repository")
            .build();
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));
            .build();
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
                metadataAfterUpdate.getTemplatesMetadata()
            .clusterUUID("cluster-uuid")
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
            .numberOfShards(1)
        verify(mockedGlobalMetadataManager, times(1)).readAsync(
        }).when(mockedGlobalMetadataManager).readAsync(any(), any(), listenerArgumentCaptor.capture());
        verify(mockService, times(1)).validateClusterStateFromChecksum(
            );
        doAnswer(invocation -> {
        RemoteClusterStateService mockService = spy(remoteClusterStateService);
            assertEquals(metadataAfterUpdate.getSettingsMetadata(), initialMetadata.getSettingsMetadata());
            clusterService,
            .thenReturn(Arrays.asList(blobMetadata));
            () -> remoteClusterStateService.writeFullMetadata(clusterState, randomAlphaOfLength(10))
            .stateUUID("state-uuid")
        IndexMetadata indexMetadata1 = new IndexMetadata.Builder(index1.getName()).settings(idxSettings1)
    public void testReadClusterStateInParallel_Success() throws IOException {
            any(),
            eq(manifest.getClusterUUID()),
        assertThat(manifest.getCustomMetadataMap().containsKey(CustomMetadata1.TYPE), is(true));
        if (randomBoolean()) {
        assertEquals(0, remoteClusterStateService.getRemoteStateStats().getStateFullDownloadValidationFailed());
        uploadedCustomMetadataMap.keySet().forEach(key -> assertTrue(updatedClusterState.metadata().customs().containsKey(key)));
import org.opensearch.cluster.routing.remote.NoopRemoteRoutingTableService;
            any(),
import static org.hamcrest.Matchers.nullValue;
            .codecVersion(CODEC_V2)
import org.opensearch.core.common.bytes.BytesReference;
        final ClusterState initialClusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
                                    )
        // new customs uploaded
                anyBoolean(),
        remoteClusterStateService.start();
        remoteClusterStateService.start();
    }
        RemoteClusterStateAttributesManager mockedClusterStateAttributeManager = mock(RemoteClusterStateAttributesManager.class);
import org.opensearch.core.common.bytes.BytesArray;
        final Index index = new Index("test-index", "index-uuid");
        assertThat(manifest.getRoutingTableVersion(), is(expectedManifest.getRoutingTableVersion()));
        assertThat(manifest.getPreviousClusterUUID(), is(expectedManifest.getPreviousClusterUUID()));
            "cluster-uuid2"
        assertThat(previousClusterUUID, equalTo("cluster-uuid2"));
                eq(true)
        }).when(mockedGlobalMetadataManager)
            .indices(List.of(new UploadedIndexMetadata("test-index", "test-index-uuid", "test-index-file__2")))
                eq(NODE_ID),
            "test-index",
    ) {
import org.opensearch.gateway.remote.model.RemoteHashesOfConsistentSettings;
        Metadata expactedMetadata = Metadata.builder().persistentSettings(Settings.builder().put("readonly", true).build()).build();
            anyString(),
                .findFirst()
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeFullMetadata(clusterState, "prev-cluster-uuid")
import org.opensearch.common.CheckedRunnable;
        mockBlobStoreObjects();
    public void testGetClusterStateForManifestWithChecksumValidationEnabled() throws IOException {
        assertThat(manifest.getIndicesRouting().get(0).getUploadedFilename(), notNullValue());
            () -> remoteClusterStateService.getLatestClusterState(
                    .persistentSettings(settings)
                manifest.getClusterUUID(),
            "cluster-uuid1",
        );
        );
        initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode.FAILURE);
            .build();
    private NamedWriteableRegistry namedWriteableRegistry;
            newSettings,
            "index-uuid",
        }
            .stateVersion(1L)
            .clusterTerm(1L)
                    .build()
        assertThat(manifest.getIndicesRouting().get(0).getIndexName(), is(uploadedIndiceRoutingMetadata.getIndexName()));
import org.mockito.ArgumentCaptor;
        mockBlobStoreObjects();
import static java.util.Collections.emptyMap;
                // since timestamp is part of file name, if file name is same we can confirm that file is not update in global metadata
        assertThrows(IllegalStateException.class, () -> remoteClusterStateService.getLastKnownUUIDFromRemote("test-cluster"));
            assertEquals(metadataAfterUpdate.getCustomMetadataMap(), initialMetadata.getCustomMetadataMap());
        final List<UploadedIndexMetadata> indices = List.of(uploadedIndexMetadata);
                    new RepositoryCleanupInProgress(List.of(new RepositoryCleanupInProgress.Entry("test-repo", 10L)))
                );
    }
        final RemoteClusterStateManifestInfo manifestInfo = rcssSpy.writeIncrementalMetadata(
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                        DefaultRemoteStoreSettings.INSTANCE
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
        NamedXContentRegistry xContentRegistry = new NamedXContentRegistry(
import org.opensearch.cluster.metadata.Metadata;
                Map.of(addedCustom.getWriteableName(), new UploadedMetadataAttribute(addedCustom.getWriteableName(), "custom-md2-file__1"))
        remoteClusterStateService.start();
            .build();
                eq(manifest.getIndicesRouting()),
        assertThat(manifest.getIndices().size(), is(1));
        mockBlobContainer(mockBlobStoreObjects(), expectedManifest, new HashMap<>(), CODEC_V2);
        assertThat(manifest.getIndicesRouting().get(0).getIndexName(), is(uploadedIndiceRoutingMetadata.getIndexName()));
                }
        ArgumentCaptor<LatchedActionListener<RemoteReadResult>> listenerArgumentCaptor = ArgumentCaptor.forClass(
        BlobMetadata blobMetadata = new PlainBlobMetadata(manifestFileName, 1);
            assertEquals(initialMetadata.getIndices().size() + 1, metadataAfterUpdate.getIndices().size());
        final CustomMetadata1 customMetadata1 = new CustomMetadata1("custom-metadata-1");
            uploadedIndexMetadataList2,
        remoteClusterStateService.start();
        doReturn(clusterState).when(mockService)
            List.of(
            listenerArgumentCaptor.getValue().onResponse(mockedResult);
                    blobContainer1,
            false
                );
import org.opensearch.common.blobstore.stream.write.WritePriority;
        verify(mockService, times(0)).validateClusterStateFromChecksum(
            .build();
                Metadata.builder(initialClusterState.metadata())
            .checksum(new ClusterStateChecksum(clusterState, threadPool))
        );
        assertTrue(remoteClusterStateService.getRemoteRoutingTableService() instanceof InternalRemoteRoutingTableService);
            eq(true),
    }
            new UploadedMetadataAttribute(COORDINATION_METADATA, "key3"),
        assert prevClusterStateVersion == newClusterStateVersion : String.format(
        IndexMetadata indexMetadata3 = IndexMetadata.builder("index1")
        }).when(mockedIndexManager).readAsync(anyString(), any(), listenerArgumentCaptor.capture());
        ClusterState clusterState2 = ClusterState.builder(clusterState1)
            listenerArgumentCaptor.getValue().onResponse(mockedResult);
        }).when(mockedClusterStateAttributeManager).readAsync(anyString(), any(), listenerArgumentCaptor.capture());
    public void testWriteFullMetadataInParallelSuccessWithRoutingTable() throws IOException {
            );
                eq(manifest.getIndicesRouting()),
        ClusterMetadataManifest manifest = ClusterMetadataManifest.builder().build();
            ClusterState.UNKNOWN_UUID,
                                Settings.builder()
            any()
                        .settings(Settings.builder().put("random_index_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5)).build())
        assertThat(manifest.getClusterBlocksMetadata(), nullValue());
        List<UploadedIndexMetadata> indices = List.of(uploadedIndexMetadata);
        doAnswer(invocation -> {
            .metadata(Metadata.builder().coordinationMetadata(coordinationMetadata))
            .readClusterStateInParallel(
            "cluster-uuid3",
        String previousClusterUUID = remoteClusterStateService.getLastKnownUUIDFromRemote("test-cluster");
            eq(NODE_ID),
            .indices(List.of())
        remoteClusterStateService.setRemoteIndexMetadataManager(mockedIndexManager);
        compressor = new DeflateCompressor();
            return null;
            clusterUUIDsPointers.get("cluster-uuid3"),
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
        assertThat(manifest.getPreviousClusterUUID(), is(expectedManifest.getPreviousClusterUUID()));
            );
            clusterService,
                manifest.getClusterUUID(),
            .build();
        mockBlobContainerForGlobalMetadata(blobContainer1, clusterManifest1, metadata1);
        );
                )
        );
    }
            .clusterTerm(1L)
        writeableEntries.add(new NamedWriteableRegistry.Entry(Metadata.Custom.class, CustomMetadata1.TYPE, CustomMetadata1::new));
            newClusterStateVersion
        assertThat(manifest.getIndices().get(0).getUploadedFilename(), notNullValue());
                eq(String.join(CUSTOM_DELIMITER, CLUSTER_STATE_CUSTOM, updatedClusterStateCustom3.getWriteableName())),
        remoteClusterStateService.start();
        assertEquals(1, initialManifest.getIndices().size());
            .build();
                    .templates(
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder().indices(Collections.emptyList()).build();
            .coordinationMetadata(new UploadedMetadataAttribute(COORDINATION_METADATA, COORDINATION_METADATA_FILENAME))
        assertEquals("Exception during reading cluster state from remote", exception.getMessage());
        assertThat(manifest.getTransientSettingsMetadata(), nullValue());
    }
            .build();
        ).diffManifest(ClusterStateDiffManifest.builder().build()).build();
        when(blobContainer.listBlobsByPrefixInSortedOrder("manifest" + DELIMITER, 1, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC))
                // custom metadata map would have changed
                    BytesReference bytesGlobalMetadata = GLOBAL_METADATA_FORMAT.serialize(
            eq(true),
            .previousClusterUUID("prev-cluster-uuid")
            assertEquals(metadataAfterUpdate.getIndices().size(), initialMetadata.getIndices().size());
            .clusterUUID("cluster-uuid")
        ClusterMetadataManifest manifest = ClusterMetadataManifest.builder()
    }
            return null;
        spiedService.getClusterStateForManifest(ClusterName.DEFAULT.value(), manifest, NODE_ID, true);
    public void testReadLatestMetadataManifestSuccess() throws IOException {
                anyList(),
                eq(true),
        }).when(mockClusterStateAttributeManager).readAsync(anyString(), any(), latchCapture.capture());
                    .putCustom(customMetadata2.getWriteableName(), customMetadata2)
                new RemoteReadResult(updatedHashesOfConsistentSettings, HASHES_OF_CONSISTENT_SETTINGS, HASHES_OF_CONSISTENT_SETTINGS)
                clusterState.getClusterName().value(),
                any()
            "cluster-uuid2",
        assertNotNull(remoteClusterStateService.getFullDownloadStats());
            new UploadedIndexMetadata("index1", "index-uuid1", "key1__2"),
            .stateVersion(1L)
            mb.persistentSettings(persistentSettings);
                new RemoteIndexPathUploader(
            .stateUUID("state-uuid")
        mockBlobContainerOrderedList.toArray(mockBlobContainerOrderedArray);
        }
                assertEquals(metadataAfterUpdate.getTemplatesMetadata(), initialMetadata.getTemplatesMetadata());
                eq(manifest),
    private ClusterSettings clusterSettings;
    private static final String PERSISTENT_SETTINGS_FILENAME = "persistent-settings-file__1";
        assertEquals(expectedClusterState.version(), updatedClusterState.version());
                eq(NODE_ID),
            .routingTable(RoutingTable.builder().addAsNew(indexMetadata).version(1L).build());
            // Verify that index metadata information is same in manifest files
            .stateVersion(1L)
                anyBoolean(),
            when(blobContainer.readBlob(COORDINATION_METADATA_FILENAME)).thenAnswer(i -> {
        assertThat(manifestInfo.getManifestFileName(), notNullValue());
        assertEquals(writtenIndexMetadata.getIndex().getName(), "test-index");
            latchedActionListener.onResponse(new RemoteReadResult(updatedClusterBlocks, CLUSTER_STATE_ATTRIBUTE, CLUSTER_BLOCKS));
        return ClusterMetadataManifest.builder()
                    .build()
        assertFalse(manifest.getCustomMetadataMap().isEmpty());
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");
            ClusterState.UNKNOWN_UUID,
        assertNotEquals(diffManifest.isClusterBlocksUpdated(), updatedClusterState.getBlocks().equals(clusterState.getBlocks()));
                any()
        }
            clusterState.metadata().clusterUUID(),
    public void testReadLatestMetadataManifestSuccessByTermVersion() throws IOException {
        assertEquals(0, remoteClusterStateService.getRemoteStateStats().getStateFullDownloadValidationFailed());
            Settings persistentSettings = Settings.builder()
            "index-uuid",
            .nodeId("nodeA")
        assertTrue(exception.getMessage().startsWith("Timed out waiting for transfer of following metadata to complete"));
            .getClusterMetadataManifest();
        mockBlobStoreObjects();
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
                            .put(
        ClusterMetadataManifest.UploadedMetadata mockedUploadedMetadata = mock(ClusterMetadataManifest.UploadedMetadata.class);
        public String toString() {
import static org.mockito.ArgumentMatchers.any;
            eq(false)
        remoteClusterStateService.start();
    private Compressor compressor;
            eq(manifest),
            }
            diffManifestBuilder.coordinationMetadataUpdated(true);
        publicationEnabled = true;
                                            .build()
        ArgumentCaptor<ActionListener<Void>> actionListenerArgumentCaptor = ArgumentCaptor.forClass(ActionListener.class);
        assertThat(manifest.getCoordinationMetadata(), notNullValue());
                Mockito.any(StringKeyDiffProvider.class)
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
            clusterState.metadata().clusterUUID(),
                );
        assertThat(manifest.getIndicesRouting().get(0).getIndexUUID(), is(uploadedIndiceRoutingMetadata.getIndexUUID()));
            .numberOfShards(1)
        );
        verify(mockedGlobalMetadataManager, times(1)).readAsync(
                assertEquals(
            randomAlphaOfLength(10)
            eq(manifest.getClusterUUID()),
                eq(false),
            eq(true),
            .put(IndexTemplateMetadata.builder("template1").settings(idxSettings).patterns(List.of("test*")).build())
            LatchedActionListener.class
        when(repositoriesServiceSupplier.get()).thenReturn(repositoriesService);
                manifest,
        List<UploadedIndexMetadata> uploadedIndexMetadataList = new ArrayList<>(
        Map<String, String> clusterUUIDsPointers = Map.of(
        assertThat(manifest.getIndices().get(0).getIndexName(), is(uploadedIndexMetadata.getIndexName()));
                BytesReference bytes = remoteClusterBlocks.clusterBlocksFormat.serialize(
            .indices(indices)
                any()
        // differGlobalMetadata controls which one of IndexMetadata or Metadata object would be different
        doAnswer(invocationOnMock -> {
            .previousClusterUUID("prev-cluster-uuid")
                    compressor
            .clusterUUID("cluster-uuid")
                eq(manifest),
import static org.opensearch.gateway.remote.model.RemoteHashesOfConsistentSettingsTests.getHashesOfConsistentSettings;
            .indicesRouting(List.of(uploadedIndiceRoutingMetadata))
                    blobContainer1,
import org.opensearch.repositories.RepositoriesService;
                anyBoolean(),
            ClusterState.UNKNOWN_UUID
        }).when(mockedIndexManager).readAsync(any(), any(), listenerArgumentCaptor.capture());
        assertEquals(expectedManifest.getStateUUID(), manifest.getStateUUID());
                true,
            .thenReturn(Arrays.asList(blobMetadata));
            clusterMetadataManifest,
            argThat(new BlobNameMatcher(CLUSTER_BLOCKS_FILENAME)),
            "cluster-uuid5",
                assertEquals(metadataAfterUpdate.getIndices().get(i).getIndexName(), initialMetadata.getIndices().get(i).getIndexName());
        }
            () -> 0L
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .build();
            .routingTableVersion(1)
                    clusterSettings,
            assertEquals(capturedWriteContext.get("metadata").getExpectedChecksum(), null);
            )
        final List<UploadedIndexMetadata> indices = List.of(uploadedIndexMetadata);
                eq(manifest.getClusterStateCustomMap()),
import org.opensearch.gateway.remote.model.RemoteClusterBlocks;
                any()
        rcssSpy.setRemoteGlobalMetadataManager(mockedGlobalMetadataManager);
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
            "test-node-id",
    public void testReadClusterStateInParallel_ExceptionDuringRead() throws IOException {
            .getClusterMetadataManifest();
            .clusterTerm(1L)
        );
        assertThat(manifest.getIndices().size(), is(1));
            eq(manifest.getClusterStateCustomMap()),
                BytesReference bytesReference = COORDINATION_METADATA_FORMAT.serialize(
            )
import static org.opensearch.gateway.remote.model.RemoteCustomMetadata.CUSTOM_METADATA;
                true,
                eq(emptyList()),
        );
        List<UploadedIndexMetadata> indices = List.of(uploadedIndexMetadata);
            eq(manifest.getClusterStateCustomMap()),
            .build();
    public void testWriteIncrementalMetadataSuccess() throws IOException {
        assertEquals(0, remoteClusterStateService.getUploadStats().getSuccessCount());
                clusterState.getClusterName().value(),
            .put("random_persistent_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5))
            .clusterUUID("cluster-uuid")
            "cluster-uuid1",
        assertNotNull(remoteClusterStateService.getFullDownloadStats());
            IntStream.range(0, initialMetadata.getIndices().size()).forEach(i -> {
                Metadata.builder()
        if (initialClusterState.term() == newClusterState.term()) {
import org.opensearch.threadpool.ThreadPool;
            repositoriesServiceSupplier,
            () -> mockService.getClusterStateForManifest(ClusterName.DEFAULT.value(), manifest, NODE_ID, true)
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
            });
                eq(emptyList()),
            return null;
                    new UploadedMetadataAttribute("custom_md_1", "test-custom1-file__1"),
                });
            "custom_3",
                BytesReference bytes = RemotePersistentSettingsMetadata.SETTINGS_METADATA_FORMAT.serialize(
        ClusterState clusterState = generateClusterStateWithAllAttributes().build();
        ClusterState previousClusterState = generateClusterStateWithAllAttributes().build();
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
                    clusterState.stateUUID(),
            () -> 0L
        rcssSpy.setRemoteIndexMetadataManager(mockedIndexManager);
import org.mockito.Mockito;
                IndicesModule.getNamedXContents().stream(),
            .metadata(
                    return;
            );
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
            .build();
                    .put(
        return ClusterState.builder(ClusterName.DEFAULT)
        RemoteGlobalMetadataManager mockedGlobalMetadataManager = mock(RemoteGlobalMetadataManager.class);
 *
            indicesToDelete.forEach(mb::remove);
    private static final String DISCOVERY_NODES_FILENAME = "discovery-nodes-file__1";
                    .coordinationMetadata(coordinationMetadata)
                .filter(uploadedIndex -> uploadedIndex.getIndexName().equals(index1.getName()))
            "cluster-uuid2",
            .settings(indexSettings)
            new UploadedMetadataAttribute("custom_3", clusterStateCustomFilename)
        final ClusterMetadataManifest clusterManifest3 = generateClusterMetadataManifest(
            LatchedActionListener.class
    }
            eq(true),
                return null;
            .metadata(
        return mockBlobStoreObjects(BlobContainer.class);
        }).when(container).asyncBlobUpload(any(WriteContext.class), actionListenerArgumentCaptor.capture());
        super.tearDown();
            LatchedActionListener<RemoteReadResult> latchedActionListener = invocationOnMock.getArgument(2, LatchedActionListener.class);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        remoteClusterStateService.start();
                    .hashesOfConsistentSettings(Map.of("key1", "value1", "key2", "value2"))
            diffManifestBuilder.templatesMetadataUpdated(true);
            )
/*
            .clusterUUID("cluster-uuid")
                );
                eq(emptyMap()),
    }
        ClusterState clusterState = generateClusterStateWithAllAttributes().build();
import org.opensearch.cluster.routing.StringKeyDiffProvider;
        assertEquals(1, remoteClusterStateService.getRemoteStateStats().getStateFullDownloadValidationFailed());
            .settings(indexSettings)
    public void setup() {
        assertThat(manifest.getIndices().size(), is(1));
            "routing-filename",
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, "routing_repository")
     *
            .getClusterMetadataManifest();
        initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode.TRACE);
            new UploadedMetadataAttribute("custom_md_3", "test-custom3-file__1")
            .persistentSettings(Settings.builder().put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), !differGlobalMetadata).build())
            .indicesRouting(List.of(uploadedIndiceRoutingMetadata))
                    .equalsIgnoreCase(initialMetadata.getSettingsMetadata().getUploadedFilename())
            true
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeIncrementalMetadata(
     * Initially codec version is 1 and a global metadata file is there, we will perform index metadata update.
                        blobStoreRepository.getCompressor(),
    public void testCustomMetadataDeletedUpdatedAndAdded() throws IOException {
        Map<String, UploadedMetadataAttribute> newCustomMetadataMap = Map.of(
            LatchedActionListener.class
import java.util.concurrent.ConcurrentHashMap;
        assertThat(manifest.getClusterStateCustomMap().containsKey(RepositoryCleanupInProgress.TYPE), is(true));
                eq(emptyList()),
        remoteClusterStateService.setRemoteClusterStateAttributesManager(mockedClusterStateAttributeManager);
     *
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
                eq(manifest),
            eq(manifest),
                initialClusterState,
            threadPool,
                argThat(new BlobNameMatcher(newClusterStateCustoms.get(uploadedClusterStateCustomMetadataKey).getUploadedFilename())),
            )
                eq(false),
        assertThat(manifest.getRoutingTableVersion(), is(expectedManifest.getRoutingTableVersion()));
            FORMAT_PARAMS
        assertEquals(writtenIndexMetadata.getNumberOfShards(), 1);
            .clusterUUID("cluster-uuid")
            .put(
        when((blobStoreRepository.basePath())).thenReturn(BlobPath.cleanPath().add("base-path"));
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertThat(manifest.getDiscoveryNodesMetadata(), nullValue());
            IllegalArgumentException.class,
                anyList(),
        mockObjectsForGettingPreviousClusterUUID(clusterUUIDsPointers);
            1
import static org.opensearch.gateway.remote.model.RemoteClusterBlocksTests.randomClusterBlocks;
                    );
        ClusterState expectedClusterState = expectedClusterStateBuilder.metadata(mb).build();
        remoteClusterStateService.start();
            .build();
            .nodeId("nodeA")
                )
            .codecVersion(MANIFEST_CURRENT_CODEC_VERSION)
            assertFalse(updatedClusterState.customs().containsKey(clusterStateCustomName));
            .persistentSettings(Settings.builder().put("readonly", true).build())
import java.util.Set;
            uploadedIndexMetadata -> verify(mockIndexMetadataManager, times(1)).readAsync(
        );
                settings,
            .indices(List.of(uploadedIndexMetadata))
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build())
        ClusterMetadataManifest manifest2 = remoteClusterStateService.writeIncrementalMetadata(clusterState1, clusterState2, manifest1)
        );
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().checksum(
    private void initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode mode) {
                    DefaultRemoteStoreSettings.INSTANCE
                return new ByteArrayInputStream(bytes.streamInput().readAllBytes());
        });
            .previousClusterUUID("prev-cluster-uuid")
            .build();
            .put("cluster.remote_store.state.metadata_manifest.upload_timeout", metadataManifestUploadTimeout + "s")
                    .version(randomNonNegativeLong())
        // IndexMetadata and Metadata when deciding if the remote state b/w two different cluster uuids is same.
            .routingTableVersion(clusterState.getRoutingTable().version());
            threadPool,
            return null;
import static org.mockito.ArgumentMatchers.argThat;
            Map<String, String> customFileMap = clusterMetadataManifest.getCustomMetadataMap()
            .stateUUID(clusterState.stateUUID())
import static org.opensearch.gateway.remote.model.RemotePersistentSettingsMetadata.SETTING_METADATA;
        assertThat(manifest.getIndices().get(0).getUploadedFilename(), notNullValue());
        mockObjectsForGettingPreviousClusterUUID(clusterUUIDsPointers, false, Collections.emptyMap());
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));
        }
            .clusterTerm(1L)
    }
        );
            });
        assertThat(manifest.getPreviousClusterUUID(), is(expectedManifest.getPreviousClusterUUID()));
    private BlobContainer mockBlobStoreObjects() {
        assertThat(manifest.getTemplatesMetadata(), notNullValue());
        assertTrue(ex.getMessage().contains("Timed out waiting for transfer"));
 * compatible open source license.
            argThat(new BlobNameMatcher(HASHES_OF_CONSISTENT_SETTINGS_FILENAME)),
                    COORDINATION_METADATA_FILENAME,
            0
                clusterState.getClusterName().value(),
                .build();
            .clusterTerm(1L)
import org.opensearch.index.remote.RemoteStoreUtils;
            prevClusterStateVersion,
            return null;
        RemoteGlobalMetadataManager mockedGlobalMetadataManager = mock(RemoteGlobalMetadataManager.class);
        verifyMetadataAttributeOnlyUpdated(updater, (initialMetadata, metadataAfterUpdate) -> {
        Settings idxSettings1 = Settings.builder()
        );
            .clusterUUID("cluster-uuid")
            .coordinationMetadata(new ClusterMetadataManifest.UploadedMetadataAttribute(COORDINATION_METADATA, "mock-coordination-file"))
        }).when(container).asyncBlobUpload(writeContextArgumentCaptor.capture(), actionListenerArgumentCaptor.capture());
            .stateUUID("state-uuid")
            .nodeId("nodeA")
            });
            .stateUUID("state-uuid")
            .build();
        BlobContainer blobContainer,
        newCustomMetadataMap.keySet().forEach(uploadedCustomMetadataKey -> {
                eq(emptyList()),
                    .equalsIgnoreCase(initialMetadata.getCoordinationMetadata().getUploadedFilename())
                    DefaultRemoteStoreSettings.INSTANCE
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(1L).build();
import java.util.Optional;
import java.util.Iterator;
        verifyWriteIncrementalGlobalMetadataFromOlderCodecSuccess(previousManifest);
        mockObjectsForGettingPreviousClusterUUID(clusterUUIDsPointers);
import static org.opensearch.gateway.remote.RemoteClusterStateAttributesManager.CLUSTER_STATE_ATTRIBUTE;
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_PUBLICATION_SETTING_KEY;
        final ClusterState previousClusterState = ClusterState.builder(ClusterName.DEFAULT)
            .build();
                clusterState.getMetadata().customs(),
        assertThat(manifest.getIndicesRouting().get(0).getUploadedFilename(), notNullValue());
    public void testCustomMetadataOnlyUpdated() throws IOException {
            .numberOfShards(1)
                assertEquals(
            .persistentSettings(Settings.builder().put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), true).build())
                eq(true),
                    clusterSettings,
        ClusterState clusterState = generateClusterStateWithAllAttributes().build();
                eq(NODE_ID),
            .previousClusterUUID("prev-cluster-uuid")
                eq(new ArrayList<IndexMetadata>(clusterState.metadata().indices().values())),
                eq(true),
            .getClusterMetadataManifest();
            "test-index",
            NODE_ID
        initializeRoutingTable();
            eq(manifest.getCustomMetadataMap()),
            .previousClusterUUID("prev-cluster-uuid")
                }
            () -> remoteClusterStateService.readClusterStateInParallel(
import org.opensearch.common.remote.AbstractClusterMetadataWriteableBlobEntity;
        // verify update metadata manifest upload timeout
import org.opensearch.core.action.ActionListener;
            .readAsync(eq(TEMPLATES_METADATA), argThat(new BlobNameMatcher(TEMPLATES_METADATA_FILENAME)), any());
            eq(false),
import org.opensearch.common.blobstore.BlobPath;
                emptyList(),
            .stateVersion(1L)
            public String next() {
    public void testIndexMetadataOnlyUpdated() throws IOException {
                anyBoolean(),
                // update
            return null;
        assertEquals(uploadedIndexMetadataList.size(), updatedClusterState.metadata().indices().size());
import static org.opensearch.gateway.remote.model.RemoteTransientSettingsMetadata.TRANSIENT_SETTING_METADATA;
                    .persistentSettings(settings)
        final UploadedIndexMetadata uploadedIndiceRoutingMetadata = new UploadedIndexMetadata(
        );
        // custom4 is added
    }
                    metadataAfterUpdate.getIndices().get(i).getUploadedFilename(),
                true,
        );
                                    .patterns(Arrays.asList("bar-*", "foo-*"))
        }).when(mockedClusterStateAttributeManager).readAsync(anyString(), any(), listenerArgumentCaptor.capture());
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
            return null;
            true,
        when(blobContainer.readBlob("manifestFileName")).thenThrow(FileNotFoundException.class);
            ClusterBlocks newClusterBlock = randomClusterBlocks();
        BytesReference bytes = RemoteClusterMetadataManifest.CLUSTER_METADATA_MANIFEST_FORMAT.serialize(
                    .hashesOfConsistentSettings(hashesOfConsistentSettings)
            ),
                eq(true),
                    blobContainer1,
            .build();
                Metadata.builder(initialClusterState.metadata()).persistentSettings(Settings.builder().put("foo", "bar").build()).build()
            .codecVersion(previousCodec)
            .stateUUID(stateUUID)
            .clusterTerm(1L)
        mockService.getClusterStateForManifest(ClusterName.DEFAULT.value(), manifest, NODE_ID, true);
        assertThat(manifest.getIndices().size(), is(1));
        if (randomBoolean()) {
        );
            .stateUUID("state-uuid")
        remoteClusterStateService.start();
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
            spiedService.writeMetadataInParallel(
import org.opensearch.Version;
                true,
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
                    .coordinationMetadata(coordinationMetadata)
            initialManifest
        }
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
    public void testWriteFullMetadataSuccessWithRoutingTable() throws IOException {
        remoteClusterStateService.start();
        ).diffManifest(ClusterStateDiffManifest.builder().build()).build();
        RemoteClusterStateService mockService = spy(remoteClusterStateService);
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder()
                eq(true),
            .build();
                anyBoolean(),
            () -> 0L
                eq(false),
            .nodeId("nodeA")
                new UploadedMetadataAttribute("custom_2", "test-cluster-state-custom2-file__1")
        boolean addAsNew
        );
        Settings newSettings = Settings.builder()
        remoteClusterStateService.start();
        assertEquals("Exception during reading cluster state from remote", e.getMessage());
                        threadPool,
        ClusterState updatedClusterState = remoteClusterStateService.getClusterStateUsingDiff(
        ArgumentCaptor<WriteContext> writeContextArgumentCaptor = ArgumentCaptor.forClass(WriteContext.class);
        newClusterStateCustoms.keySet().forEach(uploadedClusterStateCustomMetadataKey -> {
            .indices(List.of())
        final FilterRepository filterRepository = mock(FilterRepository.class);
            .put("cluster.remote_store.state.global_metadata.upload_timeout", writeTimeout + "s")
            .persistentSettings(Settings.builder().put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), true).build())
        final UploadedIndexMetadata uploadedIndiceRoutingMetadata = new UploadedIndexMetadata(
            new UploadedMetadataAttribute("custom_md_3", customMetadataFilename)
            .build();
            .clusterTerm(1L)
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.FORMAT_PARAMS;
            .build();
            manifestBuilder.clusterBlocksMetadata(new UploadedMetadataAttribute(CLUSTER_BLOCKS, CLUSTER_BLOCKS_FILENAME));
                        IndexMetadata.builder("test" + randomAlphaOfLength(3))
            listenerArgumentCaptor.getValue().onResponse(mockedUploadedMetadata);
            clusterState.getClusterName().value(),
    private RepositoriesService repositoriesService;
        assertEquals(clusterState.metadata().clusterUUID(), updatedClusterState.metadata().clusterUUID());
import static org.mockito.Mockito.times;
     */
                });
