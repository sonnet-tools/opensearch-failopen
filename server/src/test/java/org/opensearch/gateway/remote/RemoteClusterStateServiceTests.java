            return argument != null && expectedBlobName.equals(argument.getFullBlobName());  
                .getUploadedFilename(),
            return null;
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
        initializeRoutingTable();  
                emptyMap(),
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.TestClusterStateCustom2;
                eq(true),
            .readAsync(eq(COORDINATION_METADATA), argThat(new BlobNameMatcher(COORDINATION_METADATA_FILENAME)), any());
            .checksum(new ClusterStateChecksum(clusterState, threadPool))
        assertThat(manifest.getIndices().get(0).getUploadedFilename(), notNullValue());
            .templatesMetadata(new UploadedMetadataAttribute(TEMPLATES_METADATA, TEMPLATES_METADATA_FILENAME))
        when((blobStoreRepository.basePath())).thenReturn(BlobPath.cleanPath().add("base-path"));
                                            .put("random_index_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5))  
        ).getMetadata().getIndices();  
            IndexMetadata originalIndexMetadata = clusterState.metadata().index(indexName);
        expectThrows(
    }  
     * even if it was not changed in this cluster state update
            )
import org.opensearch.repositories.blobstore.ChecksumWritableBlobStoreFormat;  
            .clusterUUID("cluster-uuid")  
        }).when(mockedGlobalMetadataManager)  
        remoteClusterStateService.setRemoteGlobalMetadataManager(mockedGlobalMetadataManager);
            .previousClusterUUID("prev-cluster-uuid")
                eq(true),  
            .build();
        }
                        blobStoreRepository.getCompressor()
        );  
            }  
            .metadata(  
        });  
        );
            clusterState,  
            .put("node.attr." + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "remote_store_repository")
import static org.opensearch.gateway.remote.model.RemotePersistentSettingsMetadata.SETTINGS_METADATA_FORMAT;  
        BlobContainer blobContainer,  
                eq(true),
            .clusterTerm(1L)
                eq(NODE_ID),  
        Metadata expectedMetadata = Metadata.builder()
                    metadataAfterUpdate.getIndices().get(i).getUploadedFilename(),
    public void testGetClusterStateUsingDiffWithChecksumModeTraceMismatch() throws IOException {
                String fileName = uploadedIndexMetadata.getUploadedFilename();
            .settings(indexSettings)
        final ClusterBlocks clusterBlocks = randomClusterBlocks();
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));  
    }
                    Version.CURRENT
                    .getUploadedFilename()  
        when(blobContainer.listBlobsByPrefixInSortedOrder("manifest" + DELIMITER, 1, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC))
                metadataAfterUpdate.getSettingsMetadata().getUploadedFilename(),
            .codecVersion(CODEC_V1)
        assertThat(manifest.getRoutingTableVersion(), is(expectedManifest.getRoutingTableVersion()));  
                    Version.CURRENT
                    threadPool,  
            .indices(indices)
        final Index index = new Index("test-index", "index-uuid");  
                                    )
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder()
import org.opensearch.gateway.remote.model.RemoteHashesOfConsistentSettings;  
                eq(manifest),
        );
            assertEquals(metadataAfterUpdate.getTemplatesMetadata(), initialMetadata.getTemplatesMetadata());
            .previousClusterUUID("prev-cluster-uuid")
        when(blobPath.add(anyString())).thenReturn(blobPath);
            List.of(  
    public void testWriteFullMetadataInParallelFailureForIndexMetadata() throws IOException {
        doReturn(clusterState).when(mockService)  
        assertNull(manifest.getClusterStateChecksum());
            return null;  
        AsyncMultiStreamBlobContainer container = (AsyncMultiStreamBlobContainer) mockBlobStoreObjects(AsyncMultiStreamBlobContainer.class);  
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, "routing_repository")  
        BlobContainer blobContainer = mockBlobStoreObjects();  
                true,  
        mockBlobStoreObjects();
    private Compressor compressor;
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()  
        ClusterState clusterState = generateClusterStateWithAllAttributes().build();
            .clusterTerm(1L)
            .numberOfShards(1)
        );
            () -> 0L  
                    )
                eq(true),
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            eq(manifest.getIndices()),  
            "test-node-id",  
    ) throws IOException {
        assertThat(manifest.getIndices().size(), is(1));
        doReturn(clusterState).when(mockService)
        RemoteGlobalMetadataManager mockedGlobalMetadataManager = mock(RemoteGlobalMetadataManager.class);
                eq("test-index-1"),  
                    return;  
        ClusterState clusterState = generateClusterStateWithAllAttributes().build();
                    clusterSettings,  
            clusterStateWrong,
        uploadedCustomMetadataMap.putAll(newCustomMetadataMap);  
        manifestBuilder.diffManifest(diffManifest)  
    private void mockBlobContainer(
                any()  
        AsyncMultiStreamBlobContainer container = (AsyncMultiStreamBlobContainer) mockBlobStoreObjects(AsyncMultiStreamBlobContainer.class);
                any()  
            .discoveryNodesMetadata(new UploadedMetadataAttribute(DISCOVERY_NODES, DISCOVERY_NODES_FILENAME))  
        assertThat(manifestAfterUpdate.hasMetadataAttributesFiles(), is(true));  
                eq(manifest.getClusterUUID()),  
        // previous manifest with codec 0 and null global metadata  
                eq(clusterState),  
        assertEquals(clusterState.version(), updatedClusterState.version());
            manifest2.getIndices().stream().filter(uploadedIndex -> uploadedIndex.getIndexName().equals(index1.getName())).count()
        RemoteClusterStateAttributesManager mockedClusterStateAttributeManager = mock(RemoteClusterStateAttributesManager.class);  
import org.opensearch.cluster.ClusterModule;  
                eq(String.join(CUSTOM_DELIMITER, CLUSTER_STATE_CUSTOM, uploadedClusterStateCustomMetadataKey)),
                    nodesBuilder.build(),
            new ClusterStateChecksum(clusterState, threadPool)
            );  
            updatedClusterState.getMetadata().templates().equals(clusterState.getMetadata().getTemplates())
        );
        assertThat(manifest.getClusterBlocksMetadata(), nullValue());
     * even if it was not changed in this cluster state update  
                                    .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")  
import static org.mockito.Mockito.doReturn;  
            repositoriesServiceSupplier,  
            eq(ClusterName.DEFAULT.value()),  
        assertTrue(exception.getSuppressed().length > 0);
                eq(manifest),
    private void mockBlobContainerForGlobalMetadata(  
            "cluster-uuid1",
            // updated templates
        }
        remoteClusterStateService.start();
        remoteClusterStateService.setRemoteIndexMetadataManager(mockedIndexManager);
            threadPool,
                    assertEquals(v, metadataAfterUpdate.getCustomMetadataMap().get(k));  
        mockBlobStoreObjects();
     */
            0
        // Initial cluster state with index.
        DiffableStringMap updatedHashesOfConsistentSettings = getHashesOfConsistentSettings();
            .stateVersion(1L)
            .indices(indices)
        );  
            eq(SETTING_METADATA),
import org.opensearch.cluster.ClusterName;
        );
                true,
            eq(DISCOVERY_NODES),
    private void mockObjectsForGettingPreviousClusterUUID(Map<String, String> clusterUUIDsPointers) throws IOException {
            .clusterUUID("cluster-uuid")
            // Other files will be equal  
            .readClusterStateInParallel(
        );
            .stateUUID("state-uuid")
        initializeRoutingTable();
            true
            .put(IndexMetadata.SETTING_INDEX_UUID, index1.getUUID())  
        assertEquals(0, remoteClusterStateService.getUploadStats().getFailedCount());
            }
    public void testGetValidPreviousClusterUUID() throws IOException {  
            .clusterTerm(1L)
            );  
            .clusterUUIDCommitted(isUUIDCommitted)  
            () -> remoteClusterStateService.writeFullMetadata(clusterState, randomAlphaOfLength(10))  
        assertEquals(customMetadata3, updatedClusterState.metadata().custom(customMetadata3.getWriteableName()));
                    settings,  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            eq(emptyMap()),
            Map.of(
        final UploadedIndexMetadata uploadedIndiceRoutingMetadata = new UploadedIndexMetadata(  
            any()
        assertEquals(stateFromCache2.getMetadata(), state.getMetadata());  
            manifestBuilder.hashesOfConsistentSettings(
            .stateUUID("state-uuid")
            .put(RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)  
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(1L).build();  
        writeableEntries.add(new NamedWriteableRegistry.Entry(Metadata.Custom.class, CustomMetadata3.TYPE, CustomMetadata3::new));
                anyMap(),
        assertThrows(
        if (capturedWriteContext.get("metadata").doRemoteDataIntegrityCheck()) {
                eq(true),
            previousClusterState,
        remoteClusterStateService.start();
            .indices(indices)
            return null;  
        ClusterState previousClusterState = generateClusterStateWithAllAttributes().build();  
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");
                    TEMPLATES_METADATA_FILENAME,
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.CustomMetadata3;
            .stateUUID("state-uuid")
            .build();
    public void testWriteIncrementalMetadataSuccessWithChecksumValidationEnabled() throws IOException {
        final ClusterState clusterState = generateClusterStateWithOneIndex().build();  
            .build();  
            previousManifest
            any()
        Map<String, IndexMetadata> indexMetadataMap,
        }  
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
            .stateVersion(1L)
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().indices(uploadedIndexMetadataList)
                anyBoolean(),
            eq(true),
        RemoteGlobalMetadataManager mockedGlobalMetadataManager = mock(RemoteGlobalMetadataManager.class);
        mockObjectsForGettingPreviousClusterUUID(clusterUUIDsPointers, false, clusterUUIDCommitted);
            .build();
                    .build()  
            clusterState1,
        ).getClusterMetadataManifest();
    }  
import org.opensearch.indices.DefaultRemoteStoreSettings;  
            )
            Metadata.Custom updatedCustomMetadata = updatedClusterState.metadata().custom(customMetadataName);
        doAnswer(invocation -> {  
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
        ClusterState clusterState = generateClusterStateWithAllAttributes().build();
        assertEquals(1, remoteClusterStateService.getUploadStats().getSuccessCount());  
        assertThat(manifest.getClusterStateCustomMap().containsKey(RepositoryCleanupInProgress.TYPE), is(true));
        NamedXContentRegistry xContentRegistry = new NamedXContentRegistry(
        long newClusterStateVersion = newClusterState.getVersion();
import static org.hamcrest.Matchers.equalTo;
            latchedActionListener.onResponse(
        );  
            newSettings,
            .nodeId("nodeA")
        Function<ClusterState, ClusterState> updater = (initialClusterState) -> ClusterState.builder(initialClusterState)
            );
        remoteClusterStateService.start();
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
            verify(mockClusterStateAttributeManager, times(1)).readAsync(
        remoteClusterStateService.start();
            .getClusterMetadataManifest();
            eq(false),
    }  
            .settingMetadata(new UploadedMetadataAttribute(SETTING_METADATA, PERSISTENT_SETTINGS_FILENAME))  
import org.opensearch.cluster.metadata.TemplatesMetadata;
        }).when(mockedIndexManager).readAsync(any(), any(), listenerArgumentCaptor.capture());
        assertThat(manifest.getIndices().get(0).getIndexName(), is(uploadedIndexMetadata.getIndexName()));  
            previousClusterState,
        initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode.FAILURE);  
            any(),
            Map<String, String> customFileMap = clusterMetadataManifest.getCustomMetadataMap()
                BytesReference bytes = RemotePersistentSettingsMetadata.SETTINGS_METADATA_FORMAT.serialize(  
        Mockito.verify(rcssSpy)
                writableRegistry(),
            new UploadedMetadataAttribute("custom_3", "test-cluster-state-custom3-file__1")
import static org.opensearch.gateway.remote.model.RemoteIndexMetadata.INDEX;
        });
            });  
import static org.mockito.Mockito.times;
                eq(Collections.emptyMap()),  
import static org.opensearch.gateway.remote.model.RemoteCustomMetadata.readFrom;
        );
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));  
                argThat(new BlobNameMatcher(newClusterStateCustoms.get(uploadedClusterStateCustomMetadataKey).getUploadedFilename())),
                    DISCOVERY_NODES_FILENAME,  
        assertThat(manifest.getIndicesRouting().get(0).getIndexName(), is(uploadedIndiceRoutingMetadata.getIndexName()));
        }  
        mockService.getClusterStateForManifest(ClusterName.DEFAULT.value(), manifest, NODE_ID, true);  
            .readAsync(eq(CLUSTER_BLOCKS), argThat(new BlobNameMatcher(CLUSTER_BLOCKS_FILENAME)), any());
                BytesReference bytesReference = SETTINGS_METADATA_FORMAT.serialize(
            : "manifestFileName";  
        // updating remote cluster state with global metadata
        verify(mockedGlobalMetadataManager, times(1)).readAsync(
import static org.opensearch.gateway.remote.model.RemotePersistentSettingsMetadata.SETTING_METADATA;
        assertEquals(0, remoteClusterStateService.getUploadStats().getSuccessCount());
        } else if (codecVersion == CODEC_V1) {
        final RemoteClusterStateManifestInfo manifestDetails = remoteClusterStateService.writeIncrementalMetadata(
    }  
            .indices(indices)  
        assertEquals(  
        verify(mockService, times(1)).validateClusterStateFromChecksum(
            .put(RemoteClusterStateService.REMOTE_CLUSTER_STATE_CHECKSUM_VALIDATION_MODE_SETTING.getKey(), mode.name())  
            // updated persistent settings
            newSettings,
            uploadedIndexMetadata -> verify(mockIndexMetadataManager, times(1)).readAsync(
        assertEquals(0, remoteClusterStateService.getDiffDownloadStats().getSuccessCount());
    private boolean publicationEnabled;
            eq(false)
        BlobNameMatcher(String expectedBlobName) {  
                true,  
                emptyMap(),  
                true,  
        String globalIndexMetadataName = "global-metadata-file";
            String settingsFileName = getFileNameFromPath(clusterMetadataManifest.getSettingsMetadata().getUploadedFilename());  
            .build();  
        } else {
            diffManifestBuilder.customMetadataDeleted(new ArrayList<>(customsToRemove));
        diffManifest.getClusterStateCustomDeleted().forEach(clusterStateCustomName -> {
                .build();
                eq(true),
            new UploadedMetadataAttribute(TEMPLATES_METADATA, "key5"),
            .build();
    public void testGetValidPreviousClusterUUIDWithMultipleChains() throws IOException {
            .clusterTerm(1L)  
        assertThat(manifest.getCoordinationMetadata(), notNullValue());  
            .routingTableVersion(1)  
            .clusterUUID("cluster-uuid")  
            new UploadedMetadataAttribute("custom_md_3", "test-custom3-file__1")
                                IndexTemplateMetadata.builder("template" + randomAlphaOfLength(3))
        assertEquals(updatedPersistentSettings, updatedClusterState.metadata().persistentSettings());  
            () -> 0L,
import org.opensearch.indices.IndicesModule;
            true,
            }).start();
        assertNull(manifest.getGlobalMetadataFileName());
    @After  
        final TemplatesMetadata templatesMetadata = TemplatesMetadata.builder()  
    }  
                eq(true),
            argThat(new BlobNameMatcher(CLUSTER_BLOCKS_FILENAME)),
        ClusterMetadataManifest manifest = ClusterMetadataManifest.builder()
            .routingTable(RoutingTable.builder().addAsNew(indexMetadata).version(1L).build());  
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
                anyBoolean(),  
    private void verifyMetadataAttributeOnlyUpdated(
        // new index to be added
    }
        );
        );
        ClusterState clusterStateWrong = ClusterState.builder(clusterState).routingTable(RoutingTable.EMPTY_ROUTING_TABLE).build();
            () -> rcssSpy.writeMetadataInParallel(
    }  
                    CLUSTER_BLOCKS_FILENAME,  
            eq(manifest.getClusterUUID()),
    }
        BlobContainer blobContainer = mockBlobStoreObjects();
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));  
            // updated customs  
        assertThat(manifest.getClusterStateCustomMap().size(), is(0));
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeIncrementalMetadata(  
        mockBlobContainerOrderedList.toArray(mockBlobContainerOrderedArray);
        assertThat(manifest.getClusterStateCustomMap(), anEmptyMap());
        RemoteClusterStateService mockService = spy(remoteClusterStateService);
        );  
            // update blocks
        IndexMetadata indexMetadata2 = new IndexMetadata.Builder(index2.getName()).settings(idxSettings2)
        );
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());  
            String templatesFileName = getFileNameFromPath(clusterMetadataManifest.getTemplatesMetadata().getUploadedFilename());
            manifestBuilder.discoveryNodesMetadata(new UploadedMetadataAttribute(DISCOVERY_NODES, DISCOVERY_NODES_FILENAME));
        assertNotEquals(  
import java.util.concurrent.ConcurrentHashMap;
                false,  
            eq(true),  
            actionListenerArgumentCaptor.getValue().onResponse(null);
    public void testGetClusterStateForManifestWithChecksumValidationEnabled() throws IOException {  
        assertTrue(remoteClusterStateService.isRemotePublicationEnabled());  
        assertEquals(e.getMessage(), "Error while downloading Global Metadata - " + globalIndexMetadataName);
        Settings newSettings = Settings.builder()  
            RemoteStateTransferException.class,
                emptyList(),
        verify(mockedGlobalMetadataManager, times(1)).getGlobalMetadata(eq(manifest.getClusterUUID()), eq(manifest));
        doReturn(clusterState).when(mockService)
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedMetadataAttribute;
            eq(CLUSTER_BLOCKS),  
import org.opensearch.cluster.routing.StringKeyDiffProvider;  
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");
        final ClusterMetadataManifest initialManifest = remoteClusterStateService.writeFullMetadata(initialClusterState, "_na_")
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeFullMetadata(clusterState, "prev-cluster-uuid")  
        mockObjectsForGettingPreviousClusterUUID(clusterUUIDsPointers);
        assertNull(manifest.getClusterStateChecksum());
    }
    }  
            () -> 0L,
        ArgumentCaptor<LatchedActionListener<RemoteReadResult>> listenerArgumentCaptor = ArgumentCaptor.forClass(
                    newSettings,
        ClusterState notInCacheState = remoteClusterStateService.getRemoteClusterStateCache()
        assertThat(manifest.getIndicesRouting().get(0).getUploadedFilename(), notNullValue());  
            argThat(new BlobNameMatcher(TEMPLATES_METADATA_FILENAME)),
                    metadata.persistentSettings(),  
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));  
            blobStoreRepository.getCompressor(),
            .build();
            diffManifestBuilder.templatesMetadataUpdated(true);  
    }
            });
        }).when(mockClusterStateAttributeManager).readAsync(anyString(), any(), latchCapture.capture());
        assertThat(manifest.getPreviousClusterUUID(), is(expectedManifest.getPreviousClusterUUID()));
                        metadata,  
        doAnswer(invocationOnMock -> {
                any(),
        Map<String, IndexMetadata> indexMetadataMap2 = Map.of("index-uuid1", indexMetadata3, "index-uuid2", indexMetadata4);  
        blobStore = mock(BlobStore.class);  
        when(blobContainer.listBlobsByPrefixInSortedOrder("manifest" + DELIMITER, 1, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC))
            .clusterStateCustomMetadataMap(uploadedClusterStateCustomMap)
            .clusterUUID(clusterState.getMetadata().clusterUUID())
            .indices(indices)
                eq(manifest.getClusterUUID()),
        assertEquals(expectedClusterState.stateUUID(), updatedClusterState.stateUUID());
        ArgumentCaptor<LatchedActionListener<RemoteReadResult>> latchCapture = ArgumentCaptor.forClass(LatchedActionListener.class);
            ).numberOfShards(1).numberOfReplicas(0).build();  
            .build();
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.isRemoteRoutingTableConfigured;
        doAnswer((i) -> {
     * Initially codec version is 0 and global metadata is also null, we will perform index metadata update.
        rcssSpy.setRemoteGlobalMetadataManager(mockedGlobalMetadataManager);
    public void testWriteFullMetadataFailureForGlobalMetadata() throws IOException {
        assertThat(manifest.getIndices().size(), is(1));
                eq(emptyList()),  
        int metadataManifestUploadTimeout = 2;  
            previousManifest  
                    CLUSTER_BLOCKS_FILENAME,
            manifest,
                BytesReference bytes = COORDINATION_METADATA_FORMAT.serialize(
            ClusterName.DEFAULT.value(),
            IntStream.range(0, initialMetadata.getIndices().size()).forEach(i -> {
        final RemoteClusterStateManifestInfo manifestInfo = rcssSpy.writeIncrementalMetadata(
        RemoteIndexMetadataManager mockedIndexManager = mock(RemoteIndexMetadataManager.class);
                anyBoolean(),  
            .settingMetadata(new UploadedMetadataAttribute(SETTING_METADATA, PERSISTENT_SETTINGS_FILENAME))
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.FORMAT_PARAMS;
            argThat(new BlobNameMatcher(PERSISTENT_SETTINGS_FILENAME)),  
                )  
        }).when(mockedClusterStateAttributeManager).readAsync(anyString(), any(), listenerArgumentCaptor.capture());
                    threadPool,
            .coordinationMetadata(new UploadedMetadataAttribute(COORDINATION_METADATA, COORDINATION_METADATA_FILENAME))
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, "routing_repository")  
            });  
                .filter(uploadedIndex -> uploadedIndex.getIndexName().equals(index1.getName()))
        assertNotEquals(
            .codecVersion(CODEC_V1)
            argThat(new BlobNameMatcher(PERSISTENT_SETTINGS_FILENAME)),
        initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode.NONE);
public class RemoteClusterStateServiceTests extends OpenSearchTestCase {
        remoteClusterStateService.start();
    private static final String TRANSIENT_SETTINGS_FILENAME = "transient-settings-file__1";
        assertThat(manifest.getIndices().size(), is(1));  
                return new ByteArrayInputStream(bytes.streamInput().readAllBytes());
                    .put(indexMetadata, true)
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
    }
        }).when(mockedIndexManager).writeAsync(any(), any(), listenerArgumentCaptor.capture());
import static org.mockito.Mockito.spy;  
                eq(false),
            )  
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));  
                List.of(
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder().indices(Collections.emptyList()).build();  
                List.of(
            verify(mockedGlobalMetadataManager, times(1)).readAsync(
    }
            new UploadedMetadataAttribute("custom_md_3", customMetadataFilename)  
                    .transientSettings(transientSettings)  
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
            .indicesRouting(List.of(uploadedIndiceRoutingMetadata))
            )
        when((blobStoreRepository.basePath())).thenReturn(BlobPath.cleanPath().add("base-path"));
                    return new ByteArrayInputStream(bytesIndexMetadata.streamInput().readAllBytes());  
        newIndicesToRead.forEach(
            .codecVersion(ClusterMetadataManifest.CODEC_V0)
        ClusterState stateFromCache2 = remoteClusterStateService.getClusterStateForManifest(  
            .put(RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)
                assertEquals(metadataAfterUpdate.getIndices().get(i).getIndexName(), initialMetadata.getIndices().get(i).getIndexName());
                    .coordinationMetadata(coordinationMetadata)
        );  
            .clusterBlocksMetadata(new UploadedMetadataAttribute(CLUSTER_BLOCKS, CLUSTER_BLOCKS_FILENAME))
        when(container.readBlob(anyString())).thenAnswer(invocationOnMock -> {
            .numberOfReplicas(1)
            Map.of(  
                    .putCustom("custom3", new CustomMetadata1("mock_custom_metadata3"))  
                anyBoolean(),
            listenerArgumentCaptor.getValue().onResponse(mockedUploadedMetadata);
        // remove custom1 from the cluster state, update custom2, custom3 is at it is, added custom4
        diffManifest.getCustomMetadataUpdated().forEach(customMetadataName -> {
        when((blobStoreRepository.basePath())).thenReturn(blobPath);  
            RemoteStateTransferException.class,
                new UploadedMetadataAttribute("custom_2", "test-cluster-state-custom2-file__1")
                assertEquals(metadataAfterUpdate.getCoordinationMetadata(), initialMetadata.getCoordinationMetadata());
            "cluster-uuid1",
        assertEquals(capturedWriteContext.get("metadata").getWritePriority(), WritePriority.URGENT);
            .readClusterStateInParallel(
        public String toString() {
        );
                eq(manifest),  
            .opensearchVersion(Version.CURRENT)
        assertEquals(2, manifest1.getIndices().size());  
        ClusterState clusterState = generateClusterStateWithAllAttributes().build();
import static org.mockito.Mockito.doAnswer;
                    .coordinationMetadata(coordinationMetadata)  
            )
        ClusterState clusterState = generateClusterStateWithAllAttributes().build();
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(1L).build();
                return new ByteArrayInputStream(bytesReference.streamInput().readAllBytes());
    public void testWriteIncrementalMetadataSuccessWithRoutingTableDiffNull() throws IOException {  
            .build();  
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().checksum(  
        }).when(mockIndexMetadataManager).readAsync(anyString(), any(), latchCapture.capture());  
                        blobStoreRepository.getCompressor(),
        assertThat(manifest.getCustomMetadataMap().containsKey(CustomMetadata1.TYPE), is(true));  
        ClusterMetadataManifest manifest = ClusterMetadataManifest.builder().build();
        remoteClusterStateService.close();  
            ? "manifest__manifestFileName__abcd__abcd__abcd__" + codecVersion
                eq(true),
        final ClusterState clusterState = generateClusterStateWithGlobalMetadata().nodes(nodesWithLocalNodeClusterManager()).build();
            assertFalse(
            .indices(List.of())  
    /*
        // Initial cluster state with index.
            .codecVersion(CODEC_V2)  
        remoteClusterStateService.setRemoteClusterStateAttributesManager(mockedClusterStateAttributeManager);
                )  
            ).getMetadata().getIndices()  
        assertEquals(1, remoteClusterStateService.getFullDownloadStats().getSuccessCount());
        mockBlobStoreObjects();
                eq(manifest.getCustomMetadataMap()),  
        }).when(container).asyncBlobUpload(any(WriteContext.class), actionListenerArgumentCaptor.capture());
        assertNotNull(manifest.getCoordinationMetadata());
            .numberOfReplicas(1)
            .put("random_transient_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5))
                BytesReference bytesReference = TEMPLATES_METADATA_FORMAT.serialize(
                new UploadedMetadataAttribute(TRANSIENT_SETTING_METADATA, TRANSIENT_SETTINGS_FILENAME)
            .metadata(
            .stateUUID("state-uuid")
        assertThat(manifest.getIndices().get(0).getUploadedFilename(), notNullValue());
import org.opensearch.gateway.remote.model.RemoteClusterStateManifestInfo;
            return null;
                true,  
        ).diffManifest(ClusterStateDiffManifest.builder().build()).build();
            settings,
        initializeRoutingTable();  
            namedWriteableRegistry,
    }  
                // update  
            "cluster-uuid1",
            )
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()  
            eq(true),
                any()  
            listenerArgumentCaptor.getValue().onResponse(mockedResult);  
                new ClusterMetadataManifest.UploadedMetadataAttribute(IndexGraveyard.TYPE, "mock-custom-" + IndexGraveyard.TYPE + "-file")
            clusterService,
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
            eq(true),  
        mockBlobStoreObjects();
        remoteClusterStateService.start();
        assertThat(manifest.getDiscoveryNodesMetadata(), nullValue());
                clusterState.getClusterName().value(),
        ArgumentCaptor<ActionListener<Void>> actionListenerArgumentCaptor = ArgumentCaptor.forClass(ActionListener.class);  
        );
            List.of(  
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.CustomMetadata2;
                    .remove(initialIndex)
        when(clusterService.getClusterSettings()).thenReturn(new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));
            new UploadedMetadataAttribute(SETTING_METADATA, "key4"),
            // update nodes
        ClusterState newClusterState = clusterStateUpdater.apply(initialClusterState);  
            return null;
            true,  
            LatchedActionListener.class  
        String previousClusterUUID = remoteClusterStateService.getLastKnownUUIDFromRemote("test-cluster");  
            eq(manifest),
            });
            "cluster-uuid4"
        BlobMetadata blobMetadata = new PlainBlobMetadata("manifestFileName", 1);
    private ClusterMetadataManifest generateClusterMetadataManifest(  
                blobContainer2,
        // new customs uploaded
            diffManifestBuilder.indicesDeleted(new ArrayList<>(indicesToDelete));
                                    .build()
            eq(manifest.getCustomMetadataMap()),
            clusterUUIDsPointers.get("cluster-uuid2"),
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));  
                eq(emptyMap()),
            .previousClusterUUID("prev-cluster-uuid")  
        assertEquals(expectedManifest.getClusterTerm(), manifest.getClusterTerm());
            latchedActionListener.onResponse(new RemoteReadResult(updatedClusterBlocks, CLUSTER_STATE_ATTRIBUTE, CLUSTER_BLOCKS));
            capturedWriteContext.put(writeContext.getFileName().split(DELIMITER)[0], writeContextArgumentCaptor.getValue());
            )  
    public void testReadClusterStateInParallel_UnexpectedResult() throws IOException {
        rcssSpy.start();
        assertThat(manifest.getDiffManifest().getIndicesRoutingDiffPath(), nullValue());
import org.opensearch.core.action.ActionListener;
            () -> 0L
import org.opensearch.gateway.remote.model.RemoteClusterMetadataManifest;  
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
            )  
        remoteClusterStateService = new RemoteClusterStateService(  
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
            settings,
                eq(true),
                blobContainer2,
        final ClusterState clusterState = generateClusterStateWithOneIndex("test-index", 5, 1, false).nodes(
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedIndexMetadata;  
            .stateUUID("state-uuid")
        assertEquals(8, writeContextArgumentCaptor.getAllValues().size());
            Settings.builder()
        final UploadedIndexMetadata uploadedIndiceRoutingMetadata = new UploadedIndexMetadata(
        );
            public boolean hasNext() {
import static org.hamcrest.Matchers.is;
    }  
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));
        remoteClusterStateService.start();
        final ClusterMetadataManifest manifestAfterUpdate = remoteClusterStateService.writeIncrementalMetadata(
                any()  
                ),
        BlobContainer blobContainer = mockBlobStoreObjects();
                any()
                assertEquals(  
        clusterSettings.applySettings(newSettings);
            .build();
            argThat(new BlobNameMatcher(DISCOVERY_NODES_FILENAME)),  
            .previousClusterUUID("prev-cluster-uuid")  
        assertEquals(1, remoteClusterStateService.getRemoteStateStats().getStateDiffDownloadValidationFailed());
            .putCustom(custom2.getWriteableName(), custom2);
                eq(true),
                public void run() {
            WriteContext writeContext = writeContextArgumentCaptor.getValue();  
                    BytesReference bytesIndexMetadata = INDEX_METADATA_FORMAT.serialize(
            // Verify that index metadata information is same in manifest files  
        final Index index = new Index("test-index", "index-uuid");
            )
            clusterUUIDCommitted.getOrDefault("cluster-uuid1", true)  
            assertTrue(remoteClusterStateService.getRemoteRoutingTableService() instanceof NoopRemoteRoutingTableService);  
        AsyncMultiStreamBlobContainer container = (AsyncMultiStreamBlobContainer) mockBlobStoreObjects(AsyncMultiStreamBlobContainer.class);
        indices.add(uploadedIndiceRoutingMetadata);
        });
                .build();
        );
            ? "manifest__manifestFileName__abcd__abcd__abcd__" + codecVersion
        if (randomBoolean()) {
        );
        ).getClusterMetadataManifest();  
                });
        );
                anyBoolean(),  
            .getStreamProvider(Integer.MAX_VALUE)
        initializeRoutingTable();
            LatchedActionListener<RemoteReadResult> latchedActionListener = invocationOnMock.getArgument(2, LatchedActionListener.class);
        return blobContainer;  
        assertThat(manifest.getIndices().get(0).getIndexName(), is(uploadedIndexMetadata.getIndexName()));  
        }).when(mockedGlobalMetadataManager).writeAsync(anyString(), any(), listenerArgumentCaptor.capture());  
            .nodeId("nodeA")
    private void verifyWriteIncrementalGlobalMetadataFromOlderCodecSuccess(ClusterMetadataManifest previousManifest) throws IOException {  
            .coordinationMetadata(new ClusterMetadataManifest.UploadedMetadataAttribute(COORDINATION_METADATA, "mock-coordination-file"))
            .getClusterMetadataManifest();
        );  
        RemoteIndexMetadataManager mockedIndexManager = mock(RemoteIndexMetadataManager.class);
            .clusterUUID("cluster-uuid")
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().checksum(
    public void testCoordinationMetadataOnlyUpdated() throws IOException {
        mockBlobContainerForGlobalMetadata(mockBlobStoreObjects(), expectedManifest, expectedMetadata);  
            eq(false),
                NODE_ID,
            .clusterTerm(1L)  
            });
            INDEX_ROUTING_METADATA_PREFIX  
            when(blobContainer.readBlob("add-test-index-file__2")).thenAnswer(i -> {
            )
                Metadata.builder()
                    threadPool,
            Settings transientSettings = Settings.builder()
import static org.opensearch.gateway.remote.model.RemoteHashesOfConsistentSettingsTests.getHashesOfConsistentSettings;  
        newCustomMetadataMap.keySet().forEach(uploadedCustomMetadataKey -> {  
                argThat(new BlobNameMatcher(uploadedIndexMetadata.getUploadedFilename())),  
            .build();
                    DefaultRemoteStoreSettings.INSTANCE
                    FORMAT_PARAMS
        return ClusterState.builder(ClusterName.DEFAULT)
        final ClusterState initialClusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
        doAnswer(invocationOnMock -> {  
            previousClusterState,  
                BytesReference bytes = customMetadataFormat.serialize(addedCustom, "custom-md2-file__1", compressor);  
                eq(manifest.getClusterUUID()),  
        });
        } else {
            previousClusterState,  
        assertThat(manifest.getIndices().get(0).getIndexUUID(), is(uploadedIndexMetadata.getIndexUUID()));  
            .numberOfShards(primaryShards)
    public void testReadClusterStateInParallel_TimedOut() throws IOException {  
        );
        IndexMetadata indexMetadata3 = IndexMetadata.builder("index1")
        assertThat(manifest.getIndicesRouting().get(0).getIndexName(), is(uploadedIndiceRoutingMetadata.getIndexName()));
                    );
        // Adding difference in EXACTLY on of these randomly will help us test if our uuid trimming logic compares both
        assertNotNull(remoteClusterStateService.getFullDownloadStats());
            .clusterUUID("cluster-uuid")
        indices.add(uploadedIndiceRoutingMetadata);
            );
            "routing-filename",  
        BlobContainer container = mockBlobStoreObjects();
    public void testReadGlobalMetadata() throws IOException {  
        BlobContainer blobContainer3 = mock(BlobContainer.class);  
                any(),
        assertEquals(
            uploadedIndexMetadata -> verify(mockedIndexManager, times(1)).readAsync(
                eq(true),
        RemoteClusterStateService mockService = spy(remoteClusterStateService);
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
                eq(true),
            eq(NODE_ID),
                true,
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();  
                    RepositoryCleanupInProgress.TYPE,
                eq(manifest.getIndicesRouting()),  
                        "global-metadata-file",
            assertEquals(metadataAfterUpdate.getCustomMetadataMap(), initialMetadata.getCustomMetadataMap());  
                null  
            .clusterStateCustomMetadataMap(uploadedClusterStateCustomMap)  
            eq(NODE_ID),  
        if (randomBoolean()) {  
            "test-node-id",
                eq(true),  
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
            eq(DISCOVERY_NODES),
        when((blobStoreRepository.basePath())).thenReturn(BlobPath.cleanPath().add("base-path"));
            clusterMetadataManifest,  
            );
            .hashesOfConsistentSettings(  
import static org.mockito.ArgumentMatchers.argThat;
            .clusterUUID("cluster-uuid")  
            NODE_ID  
                true,
                        blobStoreRepository.getCompressor(),
            .previousClusterUUID("prev-cluster-uuid")  
            )  
import java.io.FileNotFoundException;
            );
        ClusterState stateFromCache = remoteClusterStateService.getRemoteClusterStateCache()
    public void testFailInitializeWhenRepositoryNotSet() {
        assertNotEquals(diffManifest.isClusterBlocksUpdated(), updatedClusterState.getBlocks().equals(clusterState.getBlocks()));
            "index-uuid",  
                true,
            )
            LatchedActionListener<RemoteReadResult> latchedActionListener = invocationOnMock.getArgument(2, LatchedActionListener.class);
                    DefaultRemoteStoreSettings.INSTANCE
        remoteClusterStateService = new RemoteClusterStateService(
            .indices(List.of())  
            new ClusterStateChecksum(clusterState, threadPool)
        mockBlobContainerForGlobalMetadata(blobContainer, expectedManifest, expactedMetadata);  
            new ClusterStateChecksum(clusterState, threadPool)  
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder()  
    }  
                eq(true),
            eq(manifest.getIndices()),
    private RepositoriesService repositoriesService;
        BlobMetadata blobMetadata = new PlainBlobMetadata(manifestFileName, 1);
        ).get();  
        String[] splitPath = filePath.split("/");  
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
            eq(manifest.getIndices()),
                    .clusterUUID("cluster-uuid")
                eq(emptyMap()),  
                Metadata.builder(initialClusterState.metadata())
        RemoteGlobalMetadataManager mockedGlobalMetadataManager = mock(RemoteGlobalMetadataManager.class);  
                    DefaultRemoteStoreSettings.INSTANCE  
        assertThat(manifest.getIndicesRouting().get(0).getUploadedFilename(), notNullValue());
            .customMetadataMap(uploadedCustomMetadataMap)
            LatchedActionListener<RemoteReadResult> latchedActionListener = invocationOnMock.getArgument(2, LatchedActionListener.class);
            any()  
            // Verify that index metadata information is same in manifest files  
        remoteClusterStateService.setRemoteGlobalMetadataManager(mockGlobalMetadataManager);
        );
                    repositoriesServiceSupplier,  
        assertNotEquals(
        assertFalse(manifest2.getCustomMetadataMap().containsKey("custom1"));
            clusterService,
                );  
    static ClusterState.Builder generateClusterStateWithGlobalMetadata() {
        mockBlobContainerOrderedList.addAll(
            .numberOfReplicas(0)
            )
                Metadata.builder(initialState.metadata())  
            uploadedIndexMetadataList3,
        }  
        String customMetadataFilename = "test-custom3-file__1";
            .previousClusterUUID("prev-cluster-uuid")
        assertFalse(manifest.getCustomMetadataMap().isEmpty());
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
            mb.putCustom(addedCustom.getWriteableName(), addedCustom);
    }
        remoteClusterStateService.start();  
        );  
            LatchedActionListener<RemoteReadResult> latchedActionListener = invocationOnMock.getArgument(2, LatchedActionListener.class);  
                    settings,
        assertEquals("Unknown component: mock-result", exception.getMessage());
            .build();
                IndicesModule.getNamedXContents().stream(),
            () -> remoteClusterStateService.writeFullMetadata(clusterState, randomAlphaOfLength(10))  
            .clusterUUID("cluster-uuid")
            );
                blobContainer2,
                throw new RuntimeException(e);
            clusterState,
        int codecVersion = clusterMetadataManifest.getCodecVersion();
        verify(mockService, times(1)).validateClusterStateFromChecksum(
            .stateUUID("state-uuid")
import java.util.List;  
        assertThat(manifest.getClusterStateChecksum(), is(expectedManifest.getClusterStateChecksum()));  
                }  
            .templatesMetadata(new UploadedMetadataAttribute(TEMPLATES_METADATA, TEMPLATES_METADATA_FILENAME))
        when(blobContainer.listBlobsByPrefixInSortedOrder(manifestPrefix, 1, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC)).thenReturn(
import static org.opensearch.gateway.remote.RemoteGlobalMetadataManager.GLOBAL_METADATA_UPLOAD_TIMEOUT_DEFAULT;
        }).when(mockedClusterStateAttributeManager).writeAsync(any(), any(), listenerArgumentCaptor.capture());
import org.opensearch.common.network.NetworkModule;
    }
                    RemoteClusterStateService.RemoteClusterStateValidationMode.DEBUG,
            () -> 0L
        assertions.accept(initialManifest, manifestAfterMetadataUpdate);  
            @Override  
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()  
        );
    private String getFileNameFromPath(String filePath) {
            eq(NODE_ID),
     */
        // setup  
        );
    public void testGetClusterStateForManifestWithChecksumValidationModeNone() throws IOException {  
        remoteClusterStateService.start();
        final CustomMetadata2 customMetadata2 = new CustomMetadata2("custom-metadata-2");  
            String[] splitPath = clusterMetadataManifest.getGlobalMetadataFileName().split("/");
        RemoteClusterStateService mockService = spy(remoteClusterStateService);
                    newSettings,
        ClusterState clusterStateWrong = ClusterState.builder(clusterState).routingTable(RoutingTable.EMPTY_ROUTING_TABLE).build();
        Map<String, UploadedMetadataAttribute> uploadedCustomMetadataMap = new HashMap<>(
                );
            clusterUUIDCommitted.getOrDefault("cluster-uuid3", true)  
            .indices(List.of(new UploadedIndexMetadata("test-index", "test-index-uuid", "test-index-file__2")))
            .readAsync(eq(SETTING_METADATA), argThat(new BlobNameMatcher(PERSISTENT_SETTINGS_FILENAME)), any());
        doAnswer(invocationOnMock -> {
                eq(true),
        verify(spiedService, times(1)).readClusterStateInParallel(  
import static org.opensearch.gateway.remote.model.RemoteTemplatesMetadata.TEMPLATES_METADATA_FORMAT;  
        assertNotNull(remoteClusterStateService.getDiffDownloadStats());
    public void testWriteFullMetadataSuccessPublicationEnabled() throws IOException {
        if (randomBoolean()) {
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
        );  
        mockService.getClusterStateForManifest(ClusterName.DEFAULT.value(), manifest, NODE_ID, true);
        newCustomMetadataMap.keySet().forEach(uploadedCustomMetadataKey -> {
            .clusterTerm(1L)  
            clusterService,  
            "test-index",
                            .build()
        String previousClusterUUID = remoteClusterStateService.getLastKnownUUIDFromRemote("test-cluster");
        when(blobStore.blobContainer(ArgumentMatchers.any())).thenReturn(uuidBlobContainer, mockBlobContainerOrderedArray);
            .indices(indices)
        Map<String, UploadedMetadataAttribute> newClusterStateCustoms = Map.of(
            .build();
                return new ByteArrayInputStream(bytes.streamInput().readAllBytes());
                true,  
        // During incremental update, codec version will not change.
            .previousClusterUUID("prev-cluster-uuid")
                    coordinationMetadata,
                    metadata.templatesMetadata(),
                eq(NODE_ID),
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(index.getName()).settings(idxSettings)  
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();  
                emptyMap(),
            .build();
            writableRegistry(),
        mockObjectsForGettingPreviousClusterUUID(clusterUUIDsPointers, randomBoolean(), Collections.emptyMap());
            .stateUUID("state-uuid")
            .clusterUUID("cluster-uuid")
            .clusterTerm(1L)  
        List<UploadedIndexMetadata> indices = List.of(uploadedIndexMetadata);
            manifest,  
                    .putCustom("custom2", new CustomMetadata1("mock_custom_metadata2"))
            clusterMetadataManifest,
        doReturn(clusterState).when(mockService)
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()  
        RemoteStateTransferException exception = expectThrows(
            .readAsync(eq(TEMPLATES_METADATA), argThat(new BlobNameMatcher(TEMPLATES_METADATA_FILENAME)), any());  
        when(mockResult.getComponent()).thenReturn("mock-result");
        uploadedClusterStateCustomMap.putAll(newClusterStateCustoms);
        return ClusterMetadataManifest.builder()
        mockBlobContainer(blobContainer, expectedManifest, Map.of(), CODEC_V2);
            latchCapture.getValue().onResponse(mockResult);
            .nodes(nodesWithLocalNodeClusterManager())
            eq(false),  
        assertThat(manifest.getRoutingTableVersion(), is(expectedManifest.getRoutingTableVersion()));
        when(blobContainer3.path()).thenReturn(blobPath);
        assertThat(manifest.getIndices().get(0).getUploadedFilename(), notNullValue());
        assertEquals(0, remoteClusterStateService.getDiffDownloadStats().getFailedCount());  
        when(blobStoreRepository.blobStore()).thenReturn(blobStore);
            newClusterStateCustoms,
        if (initialClusterState.term() == newClusterState.term()) {
                clusterState.getClusterName().value(),
            nodesWithLocalNodeClusterManager()  
    public void testReadGlobalMetadataIOException() throws IOException {
        ClusterState newClusterState = ClusterState.builder(previousClusterState).metadata(newMetadata).build();
import org.opensearch.action.LatchedActionListener;
            when(blobContainer.readBlob(TEMPLATES_METADATA_FORMAT.blobName(templatesFileName))).thenAnswer((invocationOnMock) -> {  
    ) {
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));  
            .readClusterStateInParallel(  
                anyBoolean(),  
            previousClusterState,
    }
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
            );  
        assertThat(manifestInfo.getManifestFileName(), notNullValue());  
    }
        remoteClusterStateService.start();  
            customMetadataMap,
                any(),  
        Map<String, String> clusterUUIDsPointers,
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
        Function<ClusterState, ClusterState> updater = (initialState) -> ClusterState.builder(initialState)
            clusterState.metadata().clusterUUID()
            INDEX_ROUTING_METADATA_PREFIX  
                Map.of(addedCustom.getWriteableName(), new UploadedMetadataAttribute(addedCustom.getWriteableName(), "custom-md2-file__1"))
                any()
            .put(REMOTE_PUBLICATION_SETTING_KEY, "true")  
            eq(true),
        }
            any(ClusterState.class),  
                clusterState.metadata().clusterUUID(),  
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));  
            // For Manifest file perform No Op, so latch in code will timeout  
    private BlobContainer mockBlobStoreObjects() {  
        clusterSettings.applySettings(newSettings);
                eq(true),  
        );
import org.opensearch.common.blobstore.BlobStore;  
                eq(false),
            .routingTable(RoutingTable.builder().addAsNew(indexMetadata).version(1L).build())
/*  
                    .version(randomNonNegativeLong())
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
    public void testReadClusterStateInParallel_Success() throws IOException {
                );  
        if (randomBoolean()) {  
            repositoriesServiceSupplier,
            )
        ArgumentCaptor<ActionListener<Void>> actionListenerArgumentCaptor = ArgumentCaptor.forClass(ActionListener.class);
        // already existing cluster state customs  
                        .build()
        assertEquals(writtenIndexMetadata.getIndex().getUUID(), "index-uuid");  
            INDEX_ROUTING_METADATA_PREFIX
        final RemoteClusterStateManifestInfo manifestDetails = remoteClusterStateService.writeFullMetadata(
        CustomMetadata3 customMetadata3 = new CustomMetadata3("custom_md_3");
            new UploadedIndexMetadata("test-index-1", "test-index-1-uuid", "test-index-1-file__2")
        AssertionError error = assertThrows(
            new UploadedIndexMetadata("index1", "index-uuid1", "key1__2"),
                    repositoriesServiceSupplier,  
                anyBoolean(),
        repositoriesServiceSupplier = mock(Supplier.class);
                eq(true),
    }  
            manifestBuilder.coordinationMetadata(new UploadedMetadataAttribute(COORDINATION_METADATA, COORDINATION_METADATA_FILENAME));
                eq(emptyMap()),  
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(index.getName()).settings(idxSettings)  
            randomAlphaOfLength(10)  
            ).getMetadata().getIndices().size(),
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        // verify update metadata manifest upload timeout
                eq(manifest.getCustomMetadataMap()),  
            eq(HASHES_OF_CONSISTENT_SETTINGS),
 * this file be licensed under the Apache-2.0 license or a
        when((blobStoreRepository.basePath())).thenReturn(BlobPath.cleanPath().add("base-path"));
                anyBoolean(),
    }  
            any(),
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
            .nodeId("nodeA")
            .nodeId("nodeA")
            .indices(List.of(uploadedIndexMetadata))
            .build();  
import org.opensearch.core.common.bytes.BytesArray;  
            "routing-filename",
    public void setup() {  
        final Settings idxSettings = Settings.builder()
        final ClusterState previousClusterState = generateClusterStateWithOneIndex("test-index", 5, 1, true).nodes(
        assertThat(manifest.getIndices().get(0).getIndexName(), is(uploadedIndexMetadata.getIndexName()));
            .discoveryNodesMetadata(new UploadedMetadataAttribute(DISCOVERY_NODES, DISCOVERY_NODES_FILENAME))  
        when(blobContainer.readBlob(GLOBAL_METADATA_FORMAT.blobName(globalIndexMetadataName))).thenThrow(FileNotFoundException.class);
    public void testReadLatestMetadataManifestSuccessByTermVersion() throws IOException {  
        assertThat(manifest.getIndicesRouting().get(0).getUploadedFilename(), notNullValue());  
                .findFirst()
        return ClusterMetadataManifest.builder()  
                        threadPool,
            () -> remoteClusterStateService.writeMetadataInParallel(
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
        }).when(mockedClusterStateAttributeManager).readAsync(anyString(), any(), listenerArgumentCaptor.capture());  
        assertThat(manifestAfterUpdate.getCodecVersion(), is(MANIFEST_CURRENT_CODEC_VERSION));
        assertEquals(updatedTransientSettings, updatedClusterState.metadata().transientSettings());
            });
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));  
                    .build()
            .build();
    private NamedWriteableRegistry namedWriteableRegistry;
            blobStoreRepository.getCompressor(),
            argThat(new BlobNameMatcher(TEMPLATES_METADATA_FILENAME)),  
            .build();
            .build();  
        ClusterMetadataManifest manifest = ClusterMetadataManifest.builder()
            () -> remoteClusterStateService.getClusterStateUsingDiff(manifest, previousState, "test-node")  
                    .templates(templatesMetadata)
    public void testWriteFullMetadataInParallelSuccess() throws IOException {
            this.expectedBlobName = expectedBlobName;
        initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode.FAILURE);  
                    .put(indexMetadata2, true)  
            IntStream.range(0, initialMetadata.getIndices().size()).forEach(i -> {
        assertThat(manifest.getClusterBlocksMetadata(), nullValue());  
            )
        final ClusterState clusterState = generateClusterStateWithGlobalMetadata().nodes(nodesWithLocalNodeClusterManager()).build();
        assertTrue(exception.getMessage().startsWith("Timed out waiting for transfer of following metadata to complete"));  
    public void testFailWriteIncrementalMetadataNonClusterManagerNode() throws IOException {
                any()
                });
        Map<String, String> clusterUUIDsPointers = Map.of(  
            RemoteStateTransferException.class,
import org.mockito.Mockito;
            LatchedActionListener<RemoteReadResult> latchedActionListener = invocationOnMock.getArgument(2, LatchedActionListener.class);  
                "custom_md_1",
            ),
            .clusterTerm(1L)
                eq(manifest.getIndicesRouting()),
                .build();
import static org.opensearch.gateway.remote.model.RemoteHashesOfConsistentSettings.HASHES_OF_CONSISTENT_SETTINGS;
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeFullMetadata(clusterState, "prev-cluster-uuid")  
            .numberOfReplicas(0)
            latchedActionListener.onResponse(new RemoteReadResult(newIndexMetadata, INDEX, "test-index-1"));  
        remoteClusterStateService.start();
            .clusterUUID("cluster-uuid")
        // existing custom metadata  
                true,
        );
        Function<ClusterState, ClusterState> updater = (initialClusterState) -> ClusterState.builder(initialClusterState)
            "cluster-uuid1",
                any()  
                throw new RuntimeException(e);  
            .stateVersion(1L)  
                initialClusterState,  
        assertEquals("Timed out waiting to read cluster state from remote within timeout " + readTimeOut + "s", exception.getMessage());
            actionListenerArgumentCaptor.getValue().onResponse(null);
        );
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(1L).build();
        verify(mockGlobalMetadataManager, times(1)).readAsync(
            )
            "cluster-uuid1",
                eq(false),
                eq(NODE_ID),  
        final ClusterMetadataManifest clusterManifest3 = generateClusterMetadataManifest(  
        );
                    String.join(CUSTOM_DELIMITER, CLUSTER_STATE_CUSTOM, updatedClusterStateCustom3.getWriteableName())  
                eq(emptyList()),
                true,
        final ClusterMetadataManifest clusterManifest2 = generateClusterMetadataManifest(  
        initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode.DEBUG);
                true,
                new RemoteReadResult(updatedHashesOfConsistentSettings, HASHES_OF_CONSISTENT_SETTINGS, HASHES_OF_CONSISTENT_SETTINGS)
        final List<UploadedIndexMetadata> indices = List.of(uploadedIndexMetadata);  
            IllegalStateException.class,
                return new ByteArrayInputStream(bytes.streamInput().readAllBytes());  
            randomAlphaOfLength(10),  
                        repositoriesServiceSupplier,  
            LatchedActionListener<RemoteReadResult> latchedActionListener = invocationOnMock.getArgument(2, LatchedActionListener.class);
            eq(manifest.getClusterStateCustomMap()),
            LatchedActionListener<RemoteReadResult> latchedActionListener = invocationOnMock.getArgument(2, LatchedActionListener.class);
import org.opensearch.cluster.metadata.Metadata;
        assertThat(manifest.getIndicesRouting().size(), is(1));
        BytesReference bytes = RemoteClusterMetadataManifest.CLUSTER_METADATA_MANIFEST_FORMAT.serialize(
        DiscoveryNodes updatedDiscoveryNodes = getDiscoveryNodes();
            IllegalArgumentException.class,  
                Map.of(  
            return null;
                        CoordinationMetadata.builder(initialClusterState.coordinationMetadata())  
            Arrays.asList(blobMetadata)  
        );
                        TemplatesMetadata.builder()  
        final ClusterMetadataManifest manifestAfterMetadataUpdate;  
        return DiscoveryNodes.builder().clusterManagerNodeId("cluster-manager-id").localNodeId("cluster-manager-id").add(localNode).build();  
            ).flatMap(Function.identity()).collect(toList())
        threadPool.shutdown();
    }
            initialManifest
        assertEquals(clusterState.getNodes(), updatedClusterState.getNodes());
        assertThat(manifest.getTransientSettingsMetadata(), nullValue());  
import org.opensearch.gateway.remote.model.RemoteReadResult;
        assertEquals(writtenIndexMetadata.getNumberOfShards(), 1);  
            eq(ClusterName.DEFAULT.value()),
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
                emptyList(),
    public void testGetValidPreviousClusterUUIDForInvalidChain() throws IOException {
            Stream.of(  
                anyBoolean(),  
                anyBoolean(),
                .stream()  
            .previousClusterUUID("prev-cluster-uuid")
            eq(ClusterName.DEFAULT.value()),
import static org.opensearch.gateway.remote.RemoteClusterStateAttributesManager.CLUSTER_STATE_ATTRIBUTE;
                emptyList(),
                    new UploadedIndexMetadata(indexMetadata.getIndex().getName(), indexMetadata.getIndexUUID(), "add-test-index-file__2")
        final ClusterState previousClusterState = ClusterState.builder(ClusterName.DEFAULT)
            .put("node.attr." + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "remote_store_repository")
        );
        verifyWriteIncrementalGlobalMetadataFromOlderCodecSuccess(previousManifest);  
                eq(emptyMap()),
        final RemoteClusterStateManifestInfo manifestInfo = rcssSpy.writeIncrementalMetadata(  
                new UploadedMetadataAttribute(HASHES_OF_CONSISTENT_SETTINGS, HASHES_OF_CONSISTENT_SETTINGS_FILENAME)  
        assertThat(manifest.getRoutingTableVersion(), is(expectedManifest.getRoutingTableVersion()));  
            .previousClusterUUID("prev-cluster-uuid")
        final Settings idxSettings = Settings.builder()
     * In final manifest codec version should be 2 and have metadata files updated,  
            )
            updatedClusterState.getMetadata().coordinationMetadata().equals(clusterState.getMetadata().coordinationMetadata())  
            eq(false),
            .metadata(Metadata.builder().coordinationMetadata(coordinationMetadata))
        if (randomBoolean()) {
            .getState(clusterState.getClusterName().value(), expectedManifest);  
        Map<String, UploadedMetadataAttribute> customMetadataMap = new HashMap<>();
        assertEquals(clusterState.getRoutingTable().getIndicesRouting(), updatedClusterState.getRoutingTable().getIndicesRouting());
    }  
                anyBoolean(),
        mockBlobStoreObjects();
            "cluster-uuid3",
            .metadata(
            .getClusterMetadataManifest();  
        final ClusterState previousClusterState = ClusterState.builder(ClusterName.DEFAULT)
        }).when(mockedClusterStateAttributeManager)
                    .clusterUUID("cluster-uuid")
        final ClusterState initialClusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();  
                    );  
                    metadataAfterUpdate.getIndices().get(i).getUploadedFilename(),
        updatedDiscoveryNodes.getNodes().forEach((nodeId, node) -> assertEquals(updatedClusterState.getNodes().get(nodeId), node));
import org.opensearch.common.blobstore.BlobMetadata;
            true
        // when comparing cluster-uuid3 and cluster-uuid1 state.
        publicationEnabled = true;
        remoteClusterStateService.start();  
        assertThat(manifest.getIndicesRouting().size(), is(1));  
    public void testReadClusterStateInParallel_ExceptionDuringRead() throws IOException {
                anyBoolean(),  
            .build();
            )
        when(mockedResult.getComponent()).thenReturn(COORDINATION_METADATA);
                    .persistentSettings(settings)  
 * SPDX-License-Identifier: Apache-2.0
            .put(stateRepoTypeAttributeKey, FsRepository.TYPE)  
        remoteClusterStateService.start();
    }
    public void testGetClusterStateUsingDiffWithChecksumMismatch() throws IOException {
    }  
    }
        final ClusterMetadataManifest manifest = remoteClusterStateService.markLastStateAsCommitted(clusterState, previousManifest, false)
        remoteClusterStateService.start();
            previousClusterState.metadata().coordinationMetadata().term() + 1,  
            return null;
                );
                clusterState.metadata().clusterUUID(),
        BytesReference bytes = RemoteClusterMetadataManifest.CLUSTER_METADATA_MANIFEST_FORMAT.serialize(  
            return null;
                eq(manifest.getCustomMetadataMap()),
            manifestAfterMetadataUpdate = remoteClusterStateService.writeIncrementalMetadata(
            // updated hashes of consistent settings
        remoteClusterStateService.setRemoteIndexMetadataManager(mockedIndexManager);  
                    DefaultRemoteStoreSettings.INSTANCE  
        assertThat(manifest.getIndices().size(), is(1));
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(2L).build();
            .build();  
                .stream()  
        List<UploadedIndexMetadata> indices = new ArrayList<>();  
        return ClusterState.builder(ClusterName.DEFAULT)
        assertThat(manifest.getIndices().get(0).getIndexUUID(), is(uploadedIndexMetadata.getIndexUUID()));  
        doAnswer(invocation -> {
                    coordinationFileName,
        assertThat(manifest.getIndices().size(), is(1));  
        final Settings settings = Settings.builder().build();  
            .committed(true)
            eq(manifest.getIndices()),
        when(blobStoreRepository.getCompressor()).thenReturn(compressor);  
            diffManifest.isSettingsMetadataUpdated(),
                    Version.CURRENT
        assertThrows(
        Map<String, UploadedMetadataAttribute> newCustomMetadataMap = Map.of(
        );
import java.util.Arrays;
            listenerArgumentCaptor.getValue().onResponse(mockedResult);
            .indices(indices)
                any()
        doAnswer(invocation -> {
                eq("test-index-1"),
            .stateUUID(stateUUID)  
        final ClusterMetadataManifest manifest = manifestInfo.getClusterMetadataManifest();  
        Exception e = assertThrows(
                eq(manifest),
            .build();
            .stateUUID("state-uuid")
        }).when(container).asyncBlobUpload(any(WriteContext.class), actionListenerArgumentCaptor.capture());
import org.opensearch.core.common.bytes.BytesReference;
        final RemoteClusterStateService rcssSpy = Mockito.spy(remoteClusterStateService);
        remoteClusterStateService.start();  
                clusterState.metadata().clusterUUID(),
            return null;
                eq(uploadedCustomMetadataKey),
        // new custom metadata to be added
            .metadataVersion(clusterState.metadata().version())  
            any(ClusterState.class),
            );
            .build();
        assertThat(manifest.getIndices().get(0).getUploadedFilename(), notNullValue());
                    .build()
        remoteClusterStateService.start();
        Settings newSettings = Settings.builder()
        assertEquals(1, remoteClusterStateService.getFullDownloadStats().getFailedCount());
                metadataAfterUpdate.getCoordinationMetadata()
        final List<UploadedIndexMetadata> indices = List.of(uploadedIndexMetadata);
        }
        assertThat(manifest.getIndices().get(0).getIndexName(), is(uploadedIndexMetadata.getIndexName()));
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(1L).build();
            "cluster-uuid3",
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
        final RemoteClusterStateService rcssSpy = Mockito.spy(remoteClusterStateService);  
        String indexName,
        when(blobContainer1.path()).thenReturn(blobPath);
        BlobMetadata blobMetadata = new PlainBlobMetadata(mockManifestFileName, 1);
        String indexFilename = "test-index-1-file__2";  
            writableRegistry(),  
        remoteClusterStateService.start();  
            .getInputStream()  
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.CustomMetadata1;  
            argThat(new BlobNameMatcher(COORDINATION_METADATA_FILENAME)),
            "test-index",  
        Map<String, String> clusterUUIDsPointers,
        Settings newSettings = Settings.builder()
            .clusterTerm(1L)  
        settings = Settings.builder().put(settings).put(REMOTE_PUBLICATION_SETTING_KEY, publicationEnabled).build();
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().checksum(
                eq(NODE_ID),  
                new UploadedMetadataAttribute("custom_md_2", "test-custom2-file__1")
            eq(false)  
    public void testIndexMetadataOnlyUpdated() throws IOException {  
        String exceptionMsg = "mock exception";
        IndexMetadata indexMetadata4 = IndexMetadata.builder("index2")
        });  
        diffManifest.getCustomMetadataDeleted().forEach(customMetadataName -> {
        assert prevClusterStateVersion == newClusterStateVersion : String.format(
        ClusterState updatedClusterState = remoteClusterStateService.getClusterStateUsingDiff(  
            previousManifest
            IntStream.range(0, initialMetadata.getIndices().size()).forEach(i -> {
                eq(manifest.getClusterUUID()),  
                });
    public void testGetClusterStateUsingDiffWithChecksumModeNone() throws IOException {
                        clusterSettings,
            .stateUUID("state-uuid")  
    }
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");
        RemoteClusterStateService mockService = spy(remoteClusterStateService);
        assertEquals(expectedManifest.getClusterUUID(), manifest.getClusterUUID());  
            .indicesRouting(List.of())
                new ClusterMetadataManifest.UploadedMetadataAttribute(IndexGraveyard.TYPE, "mock-custom-" + IndexGraveyard.TYPE + "-file")
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
            .build();
        mockBlobStoreObjects();
            initialClusterState,  
            capturedWriteContext.get("metadata").getFileName(),  
            nodesWithLocalNodeClusterManager()  
            .metadata(Metadata.builder().coordinationMetadata(coordinationMetadata))  
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().checksum(  
            .stateUUID("state-uuid")
            .indicesRouting(List.of())  
        assertEquals(0, remoteClusterStateService.getFullDownloadStats().getSuccessCount());  
            .build();  
        assertThat(manifest.getSettingsMetadata(), notNullValue());  
            .settingMetadata(new ClusterMetadataManifest.UploadedMetadataAttribute(SETTING_METADATA, "mock-setting-file"))
        assertThat(manifest.getSettingsMetadata(), notNullValue());  
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
        ClusterMetadataManifest manifest2 = remoteClusterStateService.writeIncrementalMetadata(clusterState1, clusterState2, manifest1)
    }
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeIncrementalMetadata(
        rcssSpy.setRemoteIndexMetadataManager(mockedIndexManager);
            .nodeId("nodeA")
            ),
            .clusterUUID("cluster-uuid")  
            .clusterUUID("cluster-uuid")  
        ClusterState clusterState = generateClusterStateWithAllAttributes().build();
            .stateUUID("state-uuid")  
                )
            eq(manifest),
import org.opensearch.cluster.coordination.CoordinationMetadata;
        );
            previousClusterState,
                any(),  
    }
            Set<String> customsToRemove = clusterState.metadata().customs().keySet();
        verify(mockedGlobalMetadataManager, times(1)).readAsync(
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().build();
            .routingTableVersion(1L);
            latchedActionListener.onResponse(
            .build();  
            .nodeId("nodeA")
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));  
                @Override
            () -> 0L  
            eq(NODE_ID),
                anyList(),
            .stateVersion(1L)
            eq(emptyMap()),  
    public static DiscoveryNodes nodesWithLocalNodeClusterManager() {
                eq(manifest.getClusterUUID()),
    }
            when(blobContainer.readBlob(TEMPLATES_METADATA_FILENAME)).thenAnswer(i -> {
                argThat(new BlobNameMatcher(newCustomMetadataMap.get(uploadedCustomMetadataKey).getUploadedFilename())),
        @Override
            .build();
        ).getClusterMetadataManifest();
                true,
                String custom = entry.getKey();
                anyBoolean(),  
                emptyList(),
        );
        );
        assertEquals(0, remoteClusterStateService.getRemoteStateStats().getCleanupAttemptFailedCount());
        BlobMetadata blobMetadata = new PlainBlobMetadata(manifestFileName, 1);
            when(blobContainer.readBlob(GLOBAL_METADATA_FORMAT.blobName(splitPath[splitPath.length - 1]))).thenAnswer(  
                    metadataAfterUpdate.getIndices().get(i).getUploadedFilename(),
            .stateUUID("state-uuid")
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
            );
        newClusterStateCustoms.keySet().forEach(uploadedClusterStateCustomMetadataKey -> {
                eq(true),
        assertThat(manifest.getPreviousClusterUUID(), is(expectedManifest.getPreviousClusterUUID()));  
            threadPool,
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
        final ClusterState previousClusterState = ClusterState.builder(ClusterName.DEFAULT)
            return null;  
        remoteClusterStateService.start();  
        assertThat(manifest.getCustomMetadataMap().size(), is(2));
        mockBlobStoreObjects();  
                    FORMAT_PARAMS
        when(  
            );  
                    .coordinationMetadata(coordinationMetadata)
            );  
        assertThat(manifest.getPreviousClusterUUID(), is(expectedManifest.getPreviousClusterUUID()));  
                anyBoolean(),
        assertThat(manifest.getIndicesRouting().get(0).getIndexUUID(), is(uploadedIndiceRoutingMetadata.getIndexUUID()));
            .clusterUUID(clusterUUID)
        Map<String, UploadedMetadataAttribute> uploadedClusterStateCustomMap = new HashMap<>(
        assertThat(manifest.getIndices().get(0).getUploadedFilename(), notNullValue());
        initializeWithChecksumEnabled(
            expectedClusterStateBuilder.blocks(newClusterBlock);  
        IndexMetadata indexMetadata2 = IndexMetadata.builder("index2")
            List.of(
        assertThat(manifest.getIndices().get(0).getUploadedFilename(), notNullValue());
        List<UploadedIndexMetadata> uploadedIndexMetadata,
                eq(emptyList()),
            "cluster-uuid3",
        Settings newSettings = Settings.builder()  
        remoteClusterStateService.start();  
            "cluster-uuid1"
        // TODO Make the publication flag parameterized  
        verify(mockedGlobalMetadataManager, times(1)).readAsync(
        String stateRepoTypeAttributeKey = String.format(
            capturedWriteContext.put(writeContext.getFileName().split(DELIMITER)[0], writeContextArgumentCaptor.getValue());
        final Index index = new Index("test-index", "index-uuid");
        );  
            INDEX_ROUTING_METADATA_PREFIX
                        metadata.custom(custom),  
        ).diffManifest(ClusterStateDiffManifest.builder().build()).build();
                    blobStoreRepository.getCompressor(),
            .getClusterMetadataManifest();
        );
        doNothing().when(container).asyncBlobUpload(any(), any());
        mockBlobContainerForGlobalMetadata(mockBlobStoreObjects(), expectedManifest, expectedMetadata);  
                    .clusterUUID("cluster-uuid")  
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
        // List.of(new NamedXContentRegistry.Entry(Metadata.Custom.class, new ParseField(IndexGraveyard.TYPE),
        diffManifest.getClusterStateCustomUpdated().forEach(clusterStateCustomName -> {  
    public void testGetClusterStateForManifestWithChecksumValidationEnabledWithMismatch() throws IOException {  
                false  
                    FORMAT_PARAMS  
            nodesWithLocalNodeClusterManager()  
        BytesReference bytes = RemoteClusterMetadataManifest.CLUSTER_METADATA_MANIFEST_FORMAT.serialize(
        );
        Map<String, Boolean> clusterUUIDCommitted = Map.of("cluster-uuid1", true, "cluster-uuid2", true, "cluster-uuid3", false);
            .stateVersion(prevClusterStateVersion)
            )
            .clusterUUID("cluster-uuid")  
            .globalMetadataFileName(globalIndexMetadataName)  
import static org.mockito.Mockito.doNothing;
                Metadata.builder(initialClusterState.metadata())  
                    .build()
        );
            .indicesRouting(List.of())
            .stateUUID("state-uuid")  
                    blobContainer3  
            ).getClusterMetadataManifest();  
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
            .build();
            true,  
        final ClusterState clusterState = generateClusterStateWithOneIndex("test-index", 5, 1, false).nodes(
                // update  
            )
                any(),
        ).build();
import java.io.IOException;  
        verify(mockedClusterStateAttributeManager, times(1)).readAsync(  
            .diffManifest(diffManifest)  
        mockService.getClusterStateForManifest(ClusterName.DEFAULT.value(), manifest, NODE_ID, true);
                assertEquals(metadataAfterUpdate.getIndices().get(i).getIndexUUID(), initialMetadata.getIndices().get(i).getIndexUUID());  
import org.opensearch.cluster.ClusterState;
                ClusterModule.getNamedXWriteables().stream()  
            previousClusterState,
            .checksum(new ClusterStateChecksum(clusterState, threadPool))
        Map<String, IndexMetadata> indexMetadataMap
                argThat(new BlobNameMatcher(clusterStateCustomFilename)),
        ArgumentCaptor<WriteContext> writeContextArgumentCaptor = ArgumentCaptor.forClass(WriteContext.class);
            .previousClusterUUID("prev-cluster-uuid")
    }  
            when(blobContainer.readBlob(DISCOVERY_NODES_FILENAME)).thenAnswer(invocationOnMock -> {
            .previousClusterUUID("prev-cluster-uuid")
        ClusterMetadataManifest clusterMetadataManifest,
            .checksum(new ClusterStateChecksum(clusterState, threadPool))
            "cluster-uuid1",
        Metadata expactedMetadata = Metadata.builder().persistentSettings(Settings.builder().put("readonly", true).build()).build();  
        mockBlobStoreObjects();  
                );
            // For async write action listener will be called from different thread, replicating same behaviour here.
            .routingTableVersion(1L)
    public void testFailWriteFullMetadataNonClusterManagerNode() throws IOException {
                List.of(
    public void testWriteIncrementalMetadataSuccessWithRoutingTable() throws IOException {
        verifyMetadataAttributeOnlyUpdated(updater, (initialMetadata, metadataAfterUpdate) -> {
    }
            eq(true)
            .customs(
        ).numberOfShards(1).numberOfReplicas(0).build();
                new UploadedMetadataAttribute("custom_md_1", "test-custom1-file__1"),
            eq(false)
            .readClusterStateInParallel(
            () -> new RemoteClusterStateService(
                eq(String.join(CUSTOM_DELIMITER, CLUSTER_STATE_CUSTOM, updatedClusterStateCustom3.getWriteableName())),  
            eq(manifest),  
            initialManifest
                        .patterns(Arrays.asList("bar-*", "foo-*"))  
                    compressor,
        );
            diffManifestBuilder.discoveryNodesUpdated(true);  
                    initialMetadata.getIndices().get(i).getUploadedFilename()
                manifest,  
            .coordinationMetadata(new UploadedMetadataAttribute(COORDINATION_METADATA, COORDINATION_METADATA_FILENAME))
                }  
                previousClusterState,
        assertEquals(manifest1.getCustomMetadataMap().get("custom3"), manifest2.getCustomMetadataMap().get("custom3"));  
            assertTrue(remoteClusterStateService.getRemoteRoutingTableService() instanceof InternalRemoteRoutingTableService);
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
                eq(true),
        assertNotEquals(manifest1.getCustomMetadataMap().get("custom2"), manifest2.getCustomMetadataMap().get("custom2"));
        doAnswer(invocation -> {  
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().build();
        final ClusterMetadataManifest manifest = remoteClusterStateService.getClusterMetadataManifestByTermVersion(
            eq(true),
        remoteClusterStateService.start();
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            latchedActionListener.onResponse(new RemoteReadResult(updatedDiscoveryNodes, CLUSTER_STATE_ATTRIBUTE, DISCOVERY_NODES));
                ClusterState.EMPTY_STATE,
        assertEquals(stateFromCache.getMetadata(), state.getMetadata());
                eq(String.join(CUSTOM_DELIMITER, CLUSTER_STATE_CUSTOM, uploadedClusterStateCustomMetadataKey)),  
            latchedActionListener.onResponse(  
                    templatesFileName,  
        clusterSettings.applySettings(newSettings);  
            .stateVersion(1L)
            .thenReturn(Arrays.asList(blobMetadata));  
                argThat(new BlobNameMatcher(newCustomMetadataMap.get(uploadedCustomMetadataKey).getUploadedFilename())),  
        assertThat(manifest.getGlobalMetadataFileName(), nullValue());
            any()  
    }
        assertEquals(expectedClusterState.metadata().clusterUUID(), updatedClusterState.metadata().clusterUUID());  
        mockService.getClusterStateForManifest(ClusterName.DEFAULT.value(), manifest, NODE_ID, true);
        assertEquals(expectedManifest.getStateUUID(), manifest.getStateUUID());
        });
            INDEX_ROUTING_METADATA_PREFIX
            )  
        super.tearDown();
            }  
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
            .customMetadataMap(  
        Function<ClusterState, ClusterState> updater = (initialClusterState) -> ClusterState.builder(initialClusterState)
            .stateUUID(clusterState.stateUUID())
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> getFileNameFromPath(entry.getValue().getUploadedFilename())));
                );
            .previousClusterUUID(previousClusterUUID)
            "cluster-uuid2",  
            .clusterTerm(1L)  
            .clusterUUID("cluster-uuid")  
            return null;  
                newIndicesToRead,
        newIndicesToRead.forEach(  
                    .hashesOfConsistentSettings(hashesOfConsistentSettings)
        ClusterState expectedClusterState = expectedClusterStateBuilder.metadata(mb).build();
                anyBoolean(),  
                    FORMAT_PARAMS
                assertEquals(
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(1L).build();  
import static org.opensearch.gateway.remote.model.RemoteDiscoveryNodes.DISCOVERY_NODES;
            .getClusterMetadataManifest();
        assertNotEquals(
                manifest.getClusterUUID(),
            // Verify that index metadata information is same in manifest files
            .version(1L)  
            .build();
        final IndexMetadata indexMetadata = new IndexMetadata.Builder("test").settings(  
        );  
            mb.hashesOfConsistentSettings(hashesOfConsistentSettings);  
            .stateUUID(clusterState.stateUUID())
                    threadPool,
        }
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
            mb.put(indexMetadata, true);
        private final String expectedBlobName;
import static org.mockito.ArgumentMatchers.any;  
            .put(IndexTemplateMetadata.builder("template1").settings(idxSettings).patterns(List.of("test*")).build())
                eq(emptyList()),  
        remoteClusterStateService.start();
                                            .build()
        assertNotNull(manifest.getTemplatesMetadata());
        assertThat(manifest.getIndicesRouting().get(0).getUploadedFilename(), notNullValue());
    private Settings settings;  
        Map<String, UploadedMetadataAttribute> uploadedClusterStateCustomMap = new HashMap<>(
                // since timestamp is part of file name, if file name is same we can confirm that file is not update in global metadata
        verify(mockedGlobalMetadataManager, times(1)).readAsync(
                    newSettings,  
            clusterState.metadata().clusterUUID()
        assertThat(manifest.getIndices().get(0).getUploadedFilename(), notNullValue());  
            assertFalse(
                metadataAfterUpdate.getTemplatesMetadata()  
        assertEquals(1, initialManifest.getIndices().size());
        ClusterState previousClusterState = generateClusterStateWithAllAttributes().build();
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");
        mockBlobStoreObjects();
        when((blobStoreRepository.basePath())).thenReturn(blobPath);
        assertEquals(manifest, Optional.empty());  
        assertNull(notInCacheState);  
        assertThat(manifest.getClusterStateChecksum(), is(expectedManifest.getClusterStateChecksum()));
            return null;
                                Settings.builder()
        assertThat(manifest.getIndicesRouting().get(0).getUploadedFilename(), notNullValue());
                newCustomMetadataMap,  
    private static final String HASHES_OF_CONSISTENT_SETTINGS_FILENAME = "consistent-settings-hashes-file__1";  
        BlobContainer blobContainer = mockBlobStoreObjects();  
                    .persistentSettings(settings)  
        final List<UploadedIndexMetadata> indices = List.of(uploadedIndexMetadata);
                clusterState.getClusterName().value(),  
        doAnswer((i) -> {
            .stateVersion(1L)  
            previousManifest
        assertThrows(
            any()
                            .numberOfShards(1)  
            () -> mockService.getClusterStateForManifest(ClusterName.DEFAULT.value(), manifest, NODE_ID, true)
        assertThat(manifest.getHashesOfConsistentSettings(), nullValue());
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));
        }).when(mockedGlobalMetadataManager).readAsync(anyString(), any(), listenerArgumentCaptor.capture());  
    public void testReadLatestMetadataManifestSuccessButNoIndexMetadata() throws IOException {
            .stateVersion(1L)
            Map.of(
        remoteClusterStateService.setRemoteIndexMetadataManager(mockIndexMetadataManager);
        );
import static org.opensearch.gateway.remote.RemoteClusterStateAttributesManager.CLUSTER_BLOCKS;  
        remoteClusterStateService.start();  
            assertEquals(metadataAfterUpdate.getTemplatesMetadata(), initialMetadata.getTemplatesMetadata());
        if (randomBoolean()) {
            clusterUUIDsPointers.get("cluster-uuid1"),
        mockBlobStoreObjects();  
        ClusterMetadataManifest clusterMetadataManifest,
                eq(true),
            .provideStream(0)
        verify(mockedClusterStateAttributeManager, times(1)).readAsync(
            );
                    .putCustom(customMetadata2.getWriteableName(), customMetadata2)
            NODE_ID,
    }
        UploadedMetadataAttribute coordinationMetadata,  
            .build();
    public void testWriteIncrementalMetadataSuccessWhenPublicationEnabled() throws IOException {  
    }  
            .previousClusterUUID("prev-cluster-uuid")
import org.opensearch.common.lucene.store.ByteArrayIndexInput;  
                    compressor,  
            .put("node.attr." + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "remote_store_repository")
                    clusterSettings,
        assertThat(manifest.getDiscoveryNodesMetadata(), notNullValue());
            assertFalse(
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
                eq(manifest),
    private Supplier<RepositoriesService> repositoriesServiceSupplier;
                new RemoteIndexPathUploader(
            }
            .version(1L)
        // index already present in previous state  
        BlobContainer blobContainer2 = mock(BlobContainer.class);
        mockBlobContainer(blobContainer, clusterMetadataManifest, indexMetadataMap, ClusterMetadataManifest.CODEC_V0);
            : Map.of("index-uuid1", indexMetadata5);
            listenerArgumentCaptor.getValue().onResponse(mockedUploadedMetadata);  
        IndexMetadata writtenIndexMetadata = INDEX_METADATA_FORMAT.deserialize(
                anyBoolean(),  
            "cluster-uuid3",
            .clusterTerm(1L)
            listenerArgumentCaptor.getValue().onResponse(mockedUploadedMetadata);
            .stateVersion(1L)  
                anyBoolean(),
                blobContainer2  
        // custom4 is added
        assertThat(manifest.getDiscoveryNodesMetadata(), nullValue());
            INDEX_ROUTING_METADATA_PREFIX
            .previousClusterUUID("prev-cluster-uuid")
            eq(manifest.getIndicesRouting()),
            "cluster-uuid2",  
        doAnswer((i) -> {
            .settings(indexSettings)  
        List<UploadedIndexMetadata> uploadedIndexMetadataList3 = differGlobalMetadata
            eq(TEMPLATES_METADATA),
        remoteClusterStateService.start();
                manifest.getClusterUUID(),
    }  
        assertEquals(clusterState.stateUUID(), updatedClusterState.stateUUID());
        assertEquals("Exception during reading cluster state from remote", exception.getMessage());  
            // coordination metadata file would have changed  
        RemoteClusterStateAttributesManager mockedClusterStateAttributeManager = mock(RemoteClusterStateAttributesManager.class);
        initializeRoutingTable();
            .stateVersion(1L)
                    .put(indexMetadata, true)  
            .clusterUUID("cluster-uuid")
import org.opensearch.common.blobstore.stream.write.WriteContext;
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");
                            .settings(  
                eq(manifest.getIndices()),
        CoordinationMetadata updatedCoordinationMetadata = CoordinationMetadata.builder()  
            );
                    compressor
                anyBoolean(),
            .stateUUID("state-uuid")
    public void testGetClusterStateForManifestWithChecksumValidationDebugWithMismatch() throws IOException {
    }
        final ClusterMetadataManifest manifest = manifestInfo.getClusterMetadataManifest();
        mockBlobStoreObjects();
            List.of(blobContainer1, blobContainer1, blobContainer3, blobContainer3, blobContainer2, blobContainer2)  
        doAnswer(invocation -> {
            eq(manifest.getClusterUUID()),  
                new UploadedMetadataAttribute("custom_2", "test-cluster-state-custom2-file__1")  
            .clusterTerm(1L)
    }
import org.opensearch.Version;
    }
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(index.getName()).settings(idxSettings)  
                // since timestamp is part of file name, if file name is same we can confirm that file is not update in global metadata
        settings = Settings.builder().put(settings).put(REMOTE_PUBLICATION_SETTING_KEY, true).build();
        Settings indexSettings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
        ClusterMetadataManifest clusterMetadataManifest,  
                    repositoriesServiceSupplier,
        assertThat(manifest.getCoordinationMetadata(), notNullValue());
            .previousClusterUUID("prev-cluster-uuid")  
            latchedActionListener.onResponse(new RemoteReadResult(customMetadata3, CUSTOM_METADATA, "custom_md_3"));  
                    TRANSIENT_SETTINGS_FILENAME,
            new UploadedIndexMetadata("test-index-1", "test-index-1-uuid", indexFilename)  
import static org.mockito.Mockito.mock;
            });
        clusterMetadataManifest.getIndices().forEach(uploadedIndexMetadata -> {
            )
            latchedActionListener.onResponse(
            .put(RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)
            .stateVersion(1L)
        mockService.getClusterStateUsingDiff(manifest, clusterState, NODE_ID);  
        mockBlobStoreObjects();
import org.opensearch.core.compress.Compressor;  
            clusterState.getClusterName().value(),  
    public void testWriteIncrementalGlobalMetadataFromCodecV0Success() throws IOException {
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeFullMetadata(clusterState, "prev-cluster-uuid")
                emptyList(),  
        assertThat(manifest.getIndices().get(0).getUploadedFilename(), notNullValue());
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
            .readAllBytes();
            .stateUUID("state-uuid")
            FORMAT_PARAMS
            .build();
        // IndexMetadata and Metadata when deciding if the remote state b/w two different cluster uuids is same.  
                    initialMetadata.getIndices().get(i).getUploadedFilename()
        int readTimeOut = 2;
            .routingTable(routingTableBuilder.version(1L).build());  
import static org.mockito.ArgumentMatchers.anyMap;  
                    actionListenerArgumentCaptor.getValue().onFailure(new RuntimeException("Cannot upload to remote"));  
        Function<ClusterState, ClusterState> updater = (initialClusterState) -> ClusterState.builder(initialClusterState)
        assertThat(manifest.getGlobalMetadataFileName(), nullValue());
                newClusterStateCustoms,  
                RemoteDiscoveryNodes remoteDiscoveryNodes = new RemoteDiscoveryNodes(  
    }
                RemoteHashesOfConsistentSettings remoteHashesOfConsistentSettings = new RemoteHashesOfConsistentSettings(  
        Map<String, Boolean> clusterUUIDCommitted
    }  
        // If set to false, only IndexMetadata would be different
            () -> 0L
                    clusterState.stateUUID(),  
            any()
                eq(true),  
            LatchedActionListener<RemoteReadResult> latchedActionListener = invocationOnMock.getArgument(2, LatchedActionListener.class);
            1,
        }).when(mockedIndexManager).readAsync(anyString(), any(), listenerArgumentCaptor.capture());
                eq(emptyMap()),
            manifest2.getIndices()
        assertEquals(expectedClusterState.version(), updatedClusterState.version());
            .clusterUUID("cluster-uuid")
            IllegalStateException.class,  
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
        assertEquals(writtenIndexMetadata.getNumberOfReplicas(), 0);
        String manifestPrefix = String.join(DELIMITER, "manifest", RemoteStoreUtils.invertLong(term), RemoteStoreUtils.invertLong(version))  
            eq(false),  
            .indices(List.of(uploadedIndexMetadata))
            clusterState,  
import static org.mockito.Mockito.when;  
            manifestFileName,
            .clusterUUID("cluster-uuid")  
            .stateUUID("state-uuid")
            // Verify that index metadata information is same in manifest files
        });  
            eq(true),
        if (codecVersion >= CODEC_V2) {  
            )  
            eq(NODE_ID),
            .customMetadataMap(uploadedCustomMetadataMap)
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");
        mockBlobStoreObjects();  
            eq(false)  
                emptyList(),  
            .metadataVersion(clusterState.metadata().version())  
                initialManifest
                return new ByteArrayInputStream(bytesReference.streamInput().readAllBytes());  
        assertThat(manifest.getIndicesRouting().get(0).getIndexName(), is(uploadedIndiceRoutingMetadata.getIndexName()));  
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeFullMetadata(clusterState, "prev-cluster-uuid")
            eq(false),
            : "manifestFileName";  
                clusterState.getMetadata().customs(),  
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))  
            assertEquals(metadataAfterUpdate.getCoordinationMetadata(), initialMetadata.getCoordinationMetadata());
            .routingTableVersion(1L)
        ).diffManifest(ClusterStateDiffManifest.builder().build()).build();  
            prevClusterStateVersion,
                any()
        initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode.NONE);
    }  
                    IndexTemplateMetadata.builder("template" + randomAlphaOfLength(3))
                emptyMap(),
            "nodeA",  
                )
            .clusterUUID("cluster-uuid")  
        );
            .clusterTerm(1L)
            )
        assertEquals(0, remoteClusterStateService.getUploadStats().getSuccessCount());
                    persistentSettings,
                new RemoteIndexPathUploader(  
                Settings.builder()
     * Here we will verify global metadata is not uploaded again if change is only in index metadata
                    COORDINATION_METADATA_FILENAME,  
            () -> 0L,  
        List<UploadedIndexMetadata> uploadedIndexMetadataList = new ArrayList<>(
    }
            eq(COORDINATION_METADATA),
        assertThat(manifest.getIndicesRouting().get(0).getUploadedFilename(), notNullValue());  
        remoteClusterStateService.setRemoteClusterStateAttributesManager(mockClusterStateAttributeManager);  
            .clusterTerm(1L)
                eq(manifest),  
        final ClusterState clusterState = generateClusterStateWithOneIndex().build();  
            .put("node.attr." + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "remote_store_repository")
        ConcurrentHashMap<String, WriteContext> capturedWriteContext = new ConcurrentHashMap<>();  
            .stateUUID("state-uuid")  
            when(blobContainer.readBlob(COORDINATION_METADATA_FILENAME)).thenAnswer(i -> {  
        });
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));  
        );
        // global metadata is updated
            )
    }
                new UploadedMetadataAttribute("custom_1", "test-cluster-state-custom1-file__1"),
                anyBoolean(),  
            .build();
        );
            eq(false)  
            // updated transient settings
                previousClusterState,  
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager())
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
                eq(true),  
            eq(manifest),
                    DISCOVERY_NODES_FILENAME,
        BlobContainer container = mockBlobStoreObjects();  
    }  
        Map<String, BlobContainer> blobContainerMap = new HashMap<>();
            true  
        assertEquals(8, actionListenerArgumentCaptor.getAllValues().size());  
            customMetadataMap,
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
                false
                    .build()
        publicationEnabled = false;
            .metadata(  
            indicesToDelete.forEach(mb::remove);
            .stateVersion(12)  
        );
            eq(false),
                eq(emptyMap()),
        if (addAsNew) {  
        assertThat(manifest.getIndicesRouting().get(0).getIndexName(), is(uploadedIndiceRoutingMetadata.getIndexName()));  
            .thenReturn(Arrays.asList(blobMetadata));  
            clusterState,
                any(),
        });
                Metadata.builder(initialClusterState.metadata()).persistentSettings(Settings.builder().put("foo", "bar").build()).build()
            .readClusterStateInParallel(
            .numberOfShards(1)
        when((blobStoreRepository.basePath())).thenReturn(BlobPath.cleanPath().add("base-path"));  
        remoteClusterStateService.start();
        doThrow(new RepositoryMissingException("repository missing")).when(repositoriesService).repository("remote_store_repository");  
            INDEX_ROUTING_METADATA_PREFIX
            .build();  
        RemoteClusterStateService mockService = spy(remoteClusterStateService);
            .stateUUID("state-uuid")
    private ClusterService clusterService;
                .put(
        });
            .indices(List.of(uploadedIndexMetadata))
        remoteClusterStateService.setRemoteIndexMetadataManager(mockedIndexManager);  
                .findFirst()
                    .hashesOfConsistentSettings(Map.of("key1", "value1", "key2", "value2"))
                    blobContainer1,
        assertThat(manifest.getIndices().size(), is(1));
                assertEquals(initialMetadata.getCustomMetadataMap().size() + 1, metadataAfterUpdate.getCustomMetadataMap().size());  
        assertEquals(updatedHashesOfConsistentSettings, updatedClusterState.metadata().hashesOfConsistentSettings());  
        // custom1 is removed
    }
        assertThat(manifest.getIndices().get(0).getIndexName(), is(uploadedIndexMetadata.getIndexName()));  
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
        List<UploadedIndexMetadata> indices = List.of(uploadedIndexMetadata);
            manifestFileName,
                emptyList(),  
                true,
            // updated index metadata  
            latchCapture.getValue().onResponse(mockResult);
            .forEach(indexName -> { assertFalse(updatedClusterState.metadata().getIndices().containsKey(indexName)); });  
            .put(IndexTemplateMetadata.builder("template1").settings(idxSettings).patterns(List.of("test*")).build())  
        String mockManifestFileName = "manifest__1__2__C__456__" + codecVersion;  
            () -> remoteClusterStateService.getLatestClusterState(
        assertEquals(updatedTemplateMetadata.getTemplates(), updatedClusterState.metadata().templates());
                eq(NODE_ID),
                    DefaultRemoteStoreSettings.INSTANCE  
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V2;
        ).getClusterMetadataManifest();  
    public void testMigrationFromCodecV0ManifestToCodecV2Manifest() throws IOException {  
    private static final String NODE_ID = "test-node";
            () -> 0L,
        );
            .numberOfShards(1)
                eq(clusterState.metadata().customs()),
                    .version(randomNonNegativeLong())
            any()
            TemplatesMetadata templatesMetadata = TemplatesMetadata.builder()  
import org.opensearch.common.blobstore.BlobPath;
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.TestClusterStateCustom3;
                eq(manifest.getIndices()),  
        RemoteClusterStateAttributesManager mockedClusterStateAttributeManager = mock(RemoteClusterStateAttributesManager.class);
                anyBoolean(),
            eq(true)  
        }
                any(),
        doReturn(clusterState).when(mockService)
        final ClusterMetadataManifest clusterManifest1 = generateClusterMetadataManifest(  
        assertNotNull(remoteClusterStateService.getFullDownloadStats());
                clusterState,  
import org.junit.After;  
        assertThat(manifest.getIndices().get(0).getIndexName(), is(uploadedIndexMetadata.getIndexName()));
        if (isRemoteRoutingTableConfigured(settings)) {  
            ),
        assertThat(manifest.getIndices().size(), is(1));
        UploadedMetadataAttribute templatesMetadata,
    public void testTemplatesMetadataOnlyUpdated() throws IOException {
        assertEquals(clusterState.metadata().coordinationMetadata(), updatedClusterState.metadata().coordinationMetadata());
            .readClusterStateInParallel(  
        remoteClusterStateService.start();
            argThat(new BlobNameMatcher(CLUSTER_BLOCKS_FILENAME)),
            eq(true),  
    public void testFailWriteFullMetadataWhenNotBlobRepository() {
                if (indexMetadata == null) {
        assertThat(manifest.getTemplatesMetadata(), notNullValue());
            eq(true),  
            .stateUUID("state-uuid")  
        ClusterMetadataManifest manifest1 = remoteClusterStateService.writeIncrementalMetadata(
                anyBoolean(),
        ConcurrentHashMap<String, WriteContext> capturedWriteContext = new ConcurrentHashMap<>();  
        assertEquals(1, remoteClusterStateService.getDiffDownloadStats().getSuccessCount());
        assertTrue(remoteClusterStateService.getRemoteRoutingTableService() instanceof InternalRemoteRoutingTableService);
            .settingMetadata(settingsMetadata)
        final DiscoveryNode localNode = new DiscoveryNode("cluster-manager-id", buildNewFakeTransportAddress(), Version.CURRENT);
        writeableEntries.add(new NamedWriteableRegistry.Entry(Metadata.Custom.class, CustomMetadata1.TYPE, CustomMetadata1::new));  
                .put("random_persistent_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5))  
        assertEquals(expectedClusterState.getRoutingTable().version(), updatedClusterState.getRoutingTable().version());
            .nodeId("nodeA")
    public void testRemoteRoutingTableNotInitializedWhenDisabled() {
        );  
            .numberOfReplicas(10)
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .term(previousClusterState.metadata().coordinationMetadata().term() + 1)
        assertThat(manifest.getIndicesRouting().get(0).getIndexUUID(), is(uploadedIndiceRoutingMetadata.getIndexUUID()));  
            clusterState.metadata().clusterUUID(),
                    DefaultRemoteStoreSettings.INSTANCE
        );  
            .checksum(new ClusterStateChecksum(clusterState, threadPool))  
            // updated coordination metadata
            .indices(List.of())  
        when(mockedGlobalMetadataManager.getGlobalMetadata(anyString(), eq(manifest))).thenReturn(Metadata.EMPTY_METADATA);  
                    BytesReference bytesIndexMetadata = INDEX_METADATA_FORMAT.serialize(  
                return new ByteArrayInputStream(bytes.streamInput().readAllBytes());
            .coordinationMetadata(new ClusterMetadataManifest.UploadedMetadataAttribute(COORDINATION_METADATA, "mock-coordination-file"))  
        when(blobContainer.listBlobsByPrefixInSortedOrder("manifest" + DELIMITER, 1, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC))
                    .put(indexMetadata1, true)
        doAnswer(invocation -> {
        assertThat(manifest.getCoordinationMetadata(), notNullValue());
            .stateVersion(1L)
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertThat(previousClusterUUID, equalTo("cluster-uuid3"));
import org.opensearch.cluster.block.ClusterBlocks;
        });
            return null;  
                )
        when(blobStoreRepository.getNamedXContentRegistry()).thenReturn(xContentRegistry);
            IndexMetadata indexMetadata = new IndexMetadata.Builder("add-test-index").settings(
    public void testWriteFullMetadataSuccessWithChecksumValidationEnabled() throws IOException {
            .build();
        assertEquals(1, remoteClusterStateService.getRemoteStateStats().getStateFullDownloadValidationFailed());  
        assertThat(manifest.getSettingsMetadata(), notNullValue());  
        remoteClusterStateService.setRemoteIndexMetadataManager(mockedIndexManager);  
            .indices(Collections.emptyList())  
        // custom3 is unchanged
            clusterState,  
                .entrySet()
                // custom metadata map would have changed
                Metadata.builder(initialClusterState.metadata())  
            anyBoolean()
        spiedService.getClusterStateForManifest(ClusterName.DEFAULT.value(), manifest, NODE_ID, true);
import java.util.Set;
        Map<String, String> clusterUUIDsPointers = Map.of(  
import org.opensearch.common.CheckedRunnable;
            .stateVersion(clusterState.version())
        if (randomBoolean()) {
        uploadedIndexMetadataList.addAll(newIndicesToRead);
            argThat(new BlobNameMatcher(TRANSIENT_SETTINGS_FILENAME)),
            new UploadedIndexMetadata("index1", "index-uuid1", "key1__2"),  
            try {
        );  
        assertFalse(manifest.getCustomMetadataMap().isEmpty());
                assertEquals(metadataAfterUpdate.getIndices().get(i).getIndexUUID(), initialMetadata.getIndices().get(i).getIndexUUID());  
        ).diffManifest(ClusterStateDiffManifest.builder().build()).build();
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.TestClusterStateCustom1;  
        remoteClusterStateService.start();  
        when(blobContainer.readBlob(manifestFileName)).thenReturn(new ByteArrayInputStream(bytes.streamInput().readAllBytes()));
    }
    public void testWriteIncrementalGlobalMetadataFromCodecV1Success() throws IOException {
package org.opensearch.gateway.remote;
                .filter(uploadedIndex -> uploadedIndex.getIndexName().equals(index1.getName()))
        );
                if (indexMetadata == null) {
        when((blobStoreRepository.basePath())).thenReturn(BlobPath.cleanPath().add("base-path"));
            any()  
            .clusterTerm(1L)
        remoteClusterStateService.start();
        ClusterState updatedClusterState = remoteClusterStateService.getClusterStateUsingDiff(manifest, clusterState, "test-node");
            () -> remoteClusterStateService.readClusterStateInParallel(  
        assertTrue(remoteClusterStateService.getUploadStats() != null);
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");
                );
            () -> remoteClusterStateService.readClusterStateInParallel(
            argThat(new BlobNameMatcher(HASHES_OF_CONSISTENT_SETTINGS_FILENAME)),  
import static java.util.Collections.emptyMap;
            .build();
        assertThat(manifest.getIndices().size(), is(1));
                initialMetadata.getSettingsMetadata().getUploadedFilename()  
            )
            } catch (IOException e) {
                eq(new ArrayList<IndexMetadata>(clusterState.metadata().indices().values())),
    }
        );  
            assertEquals(metadataAfterUpdate.getSettingsMetadata(), initialMetadata.getSettingsMetadata());  
            eq(false),
        }  
            assertFalse(updatedClusterState.customs().containsKey(clusterStateCustomName));
        remoteClusterStateService = new RemoteClusterStateService(
        assertEquals(updatedClusterBlocks, updatedClusterState.blocks());
                true,  
        IndexMetadata newIndexMetadata = new IndexMetadata.Builder("test-index-1").state(IndexMetadata.State.OPEN)  
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
                    new RepositoryCleanupInProgress(List.of(new RepositoryCleanupInProgress.Entry("test-repo", 10L)))
        ClusterMetadataManifest manifest2 = remoteClusterStateService.writeIncrementalMetadata(clusterState1, clusterState2, manifest1)
        mockService.getClusterStateForManifest(ClusterName.DEFAULT.value(), manifest, NODE_ID, true);
            .indices(indices)
            newClusterStateVersion  
            .numberOfReplicas(1)
                    repositoriesServiceSupplier,
        BlobContainer blobContainer,  
            uploadedIndexMetadataList1,
                    .putCustom(customMetadata1.getWriteableName(), customMetadata1)  
    }
            return null;  
            .routingTableVersion(clusterState.getRoutingTable().version());  
    private void mockBlobContainer(
                    "custom",  
        Map<String, IndexMetadata> indexMetadataMap,
                    blobContainer3,
            repositoriesServiceSupplier,
import org.opensearch.index.remote.RemoteIndexPathUploader;
     * Here we will verify the migration of manifest file from codec V1.
        Metadata metadata  
        assertTrue(exception.getMessage().startsWith("Some metadata components were not uploaded successfully"));
            new BytesArray(writtenBytes)
            DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(clusterState.nodes()).add(node);
                new UploadedMetadataAttribute("custom_md_2", "test-custom2-file__1")  
                    is -> readFrom(is, namedWriteableRegistry, addedCustom.getWriteableName())
        assertThat(manifest.getIndices().size(), is(1));
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(index.getName()).settings(idxSettings)
        uploadedCustomMetadataMap.putAll(newCustomMetadataMap);
    }
        remoteClusterStateService.start();  
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().checksum(
        assertEquals(uploadedIndexMetadataList.size(), updatedClusterState.metadata().indices().size());  
        ArgumentCaptor<ActionListener<Void>> actionListenerArgumentCaptor = ArgumentCaptor.forClass(ActionListener.class);
import org.junit.Assert;
            .build();
                    "custom_2",  
            clusterState.metadata().clusterUUID(),  
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, "routing_repository")
    }
            .numberOfShards(1)  
            .templatesMetadata(new ClusterMetadataManifest.UploadedMetadataAttribute(TEMPLATES_METADATA, "mock-templates-file"))  
    public void testWriteIncrementalMetadataSuccessWithChecksumValidationModeNone() throws IOException {  
                    HASHES_OF_CONSISTENT_SETTINGS_FILENAME,
     *  
    public void testIndexMetadataDeletedUpdatedAndAdded() throws IOException {
            .indices(List.of())
    public void testWriteFullMetadataInParallelSuccessWithRoutingTable() throws IOException {
            "cluster-uuid2"  
            "index-uuid",
            actionListenerArgumentCaptor.getValue().onResponse(null);
        RemoteClusterStateService mockService = spy(remoteClusterStateService);  
            .metadata(Metadata.builder().coordinationMetadata(coordinationMetadata))
            return null;
            .previousClusterUUID("prev-cluster-uuid")  
                return new ByteArrayInputStream(bytes.streamInput().readAllBytes());  
        final ClusterState clusterState = generateClusterStateWithGlobalMetadata().nodes(nodesWithLocalNodeClusterManager()).build();
            .indices(List.of())
        ClusterState clusterState = generateClusterStateWithAllAttributes().build();
            newClusterState,
                    "custom_md_1",
            .nodes(nodes)
        assertThat(manifest.getCoordinationMetadata(), notNullValue());
            .clusterUUID("cluster-uuid")  
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
    }
            FORMAT_PARAMS  
            Settings persistentSettings = Settings.builder()
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
    private static final String DISCOVERY_NODES_FILENAME = "discovery-nodes-file__1";
        List<UploadedIndexMetadata> uploadedIndexMetadataList2 = List.of(
                });
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));
     * In final manifest codec version should be 2 and have metadata files updated,
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
            .previousClusterUUID("prev-cluster-uuid")  
                true  
        ArgumentCaptor<LatchedActionListener<RemoteReadResult>> listenerArgumentCaptor = ArgumentCaptor.forClass(
            .readClusterStateInParallel(
        assertThat(manifest.getRoutingTableVersion(), is(expectedManifest.getRoutingTableVersion()));
                eq(true),
            .settings(indexSettings)
            writableRegistry(),  
            .build();
        assertThat(manifest.getIndicesRouting().get(0).getIndexName(), is(uploadedIndiceRoutingMetadata.getIndexName()));
        Map<String, IndexMetadata> indexMetadataMap1 = Map.of("index-uuid1", indexMetadata1, "index-uuid2", indexMetadata2);
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
        when((blobStoreRepository.basePath())).thenReturn(BlobPath.cleanPath().add("base-path"));
            diffManifestBuilder.indicesUpdated(Collections.singletonList(indexMetadata.getIndex().getName()));
        when((blobStoreRepository.basePath())).thenReturn(BlobPath.cleanPath().add("base-path"));
import java.util.ArrayList;
                true,  
                Mockito.any(StringKeyDiffProvider.class)
        ArgumentCaptor<ActionListener<Void>> actionListenerArgumentCaptor = ArgumentCaptor.forClass(ActionListener.class);
                eq(emptyList()),
            "index-uuid",
            any(),  
            eq(TRANSIENT_SETTING_METADATA),  
        when(blobPath.iterator()).thenReturn(new Iterator<String>() {
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();  
        // Initial cluster state with index.  
            .build();
                    .build()
        }).doAnswer((i) -> {
                );
        assertEquals(clusterState.metadata().getIndices(), updatedClusterState.metadata().getIndices());  
                    HASHES_OF_CONSISTENT_SETTINGS_FILENAME,
            CustomMetadata2 addedCustom = new CustomMetadata2(randomAlphaOfLength(10));
        doAnswer(invocation -> {
                        IndexMetadata.builder("test" + randomAlphaOfLength(3))
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename__2");  
                any()
                new RemoteReadResult(updatedCoordinationMetadata, COORDINATION_METADATA, COORDINATION_METADATA)  
            );
    private RemoteClusterStateService remoteClusterStateService;
import org.opensearch.cluster.routing.remote.NoopRemoteRoutingTableService;
    public void testGetClusterStateFromManifest_CodecV1() throws IOException {  
                    FORMAT_PARAMS
                any(),
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,  
            new UploadedIndexMetadata("index2", "index-uuid2", "key2__2")
            ClusterState.UNKNOWN_UUID,
            1,
            ClusterState.UNKNOWN_UUID,  
            "cluster-uuid1",
                        DefaultRemoteStoreSettings.INSTANCE
        doReturn(clusterStateWrong).when(mockService)
    ) {
    static ClusterState.Builder generateClusterStateWithAllAttributes() {  
                eq(true),
import java.util.function.BiConsumer;  
        spiedService.getClusterStateForManifest(ClusterName.DEFAULT.value(), manifest, NODE_ID, false);
import org.opensearch.common.settings.ClusterSettings;  
            .readAsync(eq(TRANSIENT_SETTING_METADATA), argThat(new BlobNameMatcher(TRANSIENT_SETTINGS_FILENAME)), any());  
            CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder()  
        }
            });
                assertEquals(metadataAfterUpdate.getIndices().get(i).getIndexName(), initialMetadata.getIndices().get(i).getIndexName());  
        writeableEntries.add(new NamedWriteableRegistry.Entry(Metadata.Custom.class, CustomMetadata2.TYPE, CustomMetadata2::new));
                    settings,  
            .build();
    }
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
        assertTrue(updatedClusterState.metadata().indices().containsKey("test-index-1"));
        when(blobContainer.readBlob(uploadedIndexMetadata.getUploadedFilename())).thenThrow(FileNotFoundException.class);  
            eq(true),  
            true
        ).getClusterMetadataManifest();
            previousClusterState,  
            blobStoreRepository.getCompressor(),  
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().checksum(
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
        doAnswer(invocationOnMock -> {
            new UploadedMetadataAttribute(COORDINATION_METADATA, "key3"),  
        final Settings idxSettings = Settings.builder()
        when(blobContainer.readBlob(manifestFileName)).thenReturn(new ByteArrayInputStream(bytes.streamInput().readAllBytes()));  
            List.of(new UploadedIndexMetadata("test-index", "test-index-uuid", "test-index-file__2"))
            eq(false),
            .indices(indices)
            .stateUUID("state-uuid")
            .codecVersion(CODEC_V2)  
    }
            .stateVersion(1L)  
                eq(emptyMap()),
            .previousClusterUUID("prev-cluster-uuid")
            "cluster-uuid3",  
        Settings updatedPersistentSettings = Settings.builder()  
    }
import static org.opensearch.gateway.remote.model.RemoteDiscoveryNodesTests.getDiscoveryNodes;  
        assertThat(manifest.getIndices().get(0).getUploadedFilename(), notNullValue());
    }  
        remoteClusterStateService.start();
        when((blobStoreRepository.basePath())).thenReturn(BlobPath.cleanPath().add("base-path"));
        ClusterState.Builder expectedClusterStateBuilder = ClusterState.builder(clusterState);
            "custom_md_3",  
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
                    BytesReference bytesGlobalMetadata = GLOBAL_METADATA_FORMAT.serialize(
            newIndicesToRead,  
    public static ClusterState.Builder generateClusterStateWithOneIndex(  
                assertEquals(metadataAfterUpdate.getIndices().get(i).getIndexName(), initialMetadata.getIndices().get(i).getIndexName());
                true,  
                initialMetadata.getCustomMetadataMap().forEach((k, v) -> {
            .build();
            .thenReturn(List.of());
                anyBoolean(),  
            .build();  
            writableRegistry(),  
        assertEquals(clusterState.metadata().persistentSettings(), updatedClusterState.metadata().persistentSettings());
                eq(true),  
                eq(true),
                blobContainer1,
            .getClusterMetadataManifest();
                anyBoolean(),
        // index already present in previous state
        ClusterState clusterState = generateClusterStateWithAllAttributes().build();  
                String fileName = entry.getValue();  
import org.opensearch.common.blobstore.support.PlainBlobMetadata;  
                    blobContainer1,
            .put("random_persistent_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5))
    public void testGetClusterStateForManifest_IncludeEphemeral() throws IOException {  
                String fileName = uploadedIndexMetadata.getUploadedFilename();
            List.of(  
            return null;
                NetworkModule.getNamedXContents().stream(),
        clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                any()
                    .templates(templatesMetadata)
            new UploadedMetadataAttribute(TEMPLATES_METADATA, "key5"),
            "test-index",
            previousClusterState,
            });
            .coordinationMetadata(new ClusterMetadataManifest.UploadedMetadataAttribute(COORDINATION_METADATA, "mock-coordination-file"))  
                    compressor
                    repositoriesServiceSupplier,
            when(blobContainer.readBlob(COORDINATION_METADATA_FORMAT.blobName(coordinationFileName))).thenAnswer((invocationOnMock) -> {
            .build();
    ) throws IOException {
        // IndexGraveyard::fromXContent))));  
        );  
        List<UploadedIndexMetadata> newIndicesToRead = List.of(  
        doAnswer(invocation -> {
                true,
        assertEquals(0, remoteClusterStateService.getFullDownloadStats().getFailedCount());  
        doAnswer(invocation -> {
                any(),
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, "routing_repository")  
        // setup
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeIncrementalMetadata(
        ClusterState clusterState2 = ClusterState.builder(clusterState1)
        mockObjectsForGettingPreviousClusterUUID(clusterUUIDsPointers);  
    public void testReadLatestMetadataManifestSuccessButIndexMetadataFetchIOException() throws IOException {  
        IllegalStateException exception = expectThrows(
        verifyMetadataAttributeOnlyUpdated(updater, (initialMetadata, metadataAfterUpdate) -> {
                    );  
        );  
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");  
                Metadata.builder(initialClusterState.metadata())
                NODE_ID,
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
import org.opensearch.cluster.routing.RoutingTable;
                false,
                true,
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
    }  
            .numberOfReplicas(replicaShards)
            () -> remoteClusterStateService.getLatestClusterMetadataManifest(  
            new ClusterStateChecksum(clusterState, threadPool)  
            clusterState.metadata().clusterUUID(),
                eq(manifest.getCustomMetadataMap()),
                return new ByteArrayInputStream(bytes.streamInput().readAllBytes());  
        remoteClusterStateService.start();
                    blobStoreRepository.getCompressor(),  
            eq(false),
                )  
        remoteClusterStateService.start();
        ).getClusterMetadataManifest();  
                            .build()
                true,
            .routingTableVersion(1)  
                eq(new ArrayList<IndexMetadata>(clusterState.metadata().indices().values())),  
            new ClusterStateChecksum(clusterState, threadPool)  
                any(),
        assertThat(manifest.getIndices().get(0).getIndexUUID(), is(uploadedIndexMetadata.getIndexUUID()));
                )
 */  
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
        clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        remoteClusterStateService.start();
import static java.util.stream.Collectors.toList;
            previousManifest
            .clusterBlocksMetadata(new UploadedMetadataAttribute(CLUSTER_BLOCKS, CLUSTER_BLOCKS_FILENAME))
            new ClusterStateChecksum(clusterState, threadPool)  
        }
                eq(true),  
            ChecksumWritableBlobStoreFormat<Metadata.Custom> customMetadataFormat = new ChecksumWritableBlobStoreFormat<>("custom", null);  
                }
        BlobContainer blobContainer,
                    clusterState.stateUUID(),
                eq(emptyMap()),
        remoteClusterStateService.start();  
            ClusterName.DEFAULT.value(),  
            .numberOfReplicas(0)
        verify(mockService, times(1)).validateClusterStateFromChecksum(
                "custom_md_2",
            new ClusterStateChecksum(clusterState, threadPool)
            .stateUUID("state-uuid")
                emptyMap(),
        remoteClusterStateService.start();
                    metadataAfterUpdate.getIndices().get(i).getUploadedFilename(),
            .indicesRouting(List.of(uploadedIndiceRoutingMetadata))
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().checksum(  
            new UploadedMetadataAttribute(COORDINATION_METADATA, "key3"),  
import static org.mockito.ArgumentMatchers.eq;  
        ArgumentCaptor<LatchedActionListener> listenerArgumentCaptor = ArgumentCaptor.forClass(LatchedActionListener.class);
import org.opensearch.gateway.remote.model.RemotePersistentSettingsMetadata;
        initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode.FAILURE);  
            expectedManifest,
        clusterService = mock(ClusterService.class);  
            "custom_3",
                eq(true),
            initialClusterState,  
    ) throws IOException {  
                    .putCustom(customMetadata1.getWriteableName(), customMetadata1)  
        final ClusterMetadataManifest notExistMetadata = ClusterMetadataManifest.builder()
        @Override  
        ClusterMetadataManifest manifest1 = remoteClusterStateService.writeIncrementalMetadata(
        verifyMetadataAttributeOnlyUpdated(updater, (initialMetadata, metadataAfterUpdate) -> {
                .getClusterMetadataManifest();  
        Map<String, UploadedMetadataAttribute> newClusterStateCustoms = Map.of(
                assertEquals(metadataAfterUpdate.getIndices().get(i).getIndexUUID(), initialMetadata.getIndices().get(i).getIndexUUID());
        assertEquals(clusterState.getClusterName(), updatedClusterState.getClusterName());
        assertThat(manifest.getIndices().get(0).getIndexUUID(), is(uploadedIndexMetadata.getIndexUUID()));  
            + DELIMITER;
            .clusterUUID(clusterState.getMetadata().clusterUUID())
        ).thenReturn(new RemoteClusterStateUtils.UploadedMetadataResults());
                        FORMAT_PARAMS
            diffManifestBuilder.transientSettingsMetadataUpdate(true);  
        // already existing cluster state customs
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
        );
            .build();
            IndexMetadata updatedIndexMetadata = updatedClusterState.metadata().index(indexName);  
            assertEquals(metadataAfterUpdate.getCoordinationMetadata(), initialMetadata.getCoordinationMetadata());
                true
            .persistentSettings(Settings.builder().put("readonly", true).build())
                IndexGraveyard.TYPE,
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
        verify(mockService, times(1)).readClusterStateInParallel(
            .clusterUUID("cluster-uuid")  
        settings = Settings.builder()
import static org.opensearch.gateway.remote.routingtable.RemoteIndexRoutingTable.INDEX_ROUTING_METADATA_PREFIX;  
        // update index1, index2 is unchanged  
        Map<String, String> clusterUUIDsPointers = Map.of(
        assertThat(manifest.getIndicesRouting().get(0).getIndexUUID(), is(uploadedIndiceRoutingMetadata.getIndexUUID()));
            .build();  
                    compressor,  
    /*  
    private void mockBlobContainer(
            .routingTableVersion(clusterState.routingTable().version())
            "test-index",
            when(blobContainer.readBlob(PERSISTENT_SETTINGS_FILENAME)).thenAnswer(i -> {
        assertEquals(12, actionListenerArgumentCaptor.getAllValues().size());  
                new RemoteIndexPathUploader(
            ClusterState.UNKNOWN_UUID  
        doAnswer(invocation -> {  
        BlobContainer blobContainer1 = mock(BlobContainer.class);
        assertThat(manifest.getIndices().size(), is(1));  
        );
    public void testGetClusterStateForManifest_ExcludeEphemeral() throws IOException {  
                return new ByteArrayInputStream(bytes.streamInput().readAllBytes());
        assertThrows(AssertionError.class, () -> remoteClusterStateService.start());
import static org.mockito.Mockito.doThrow;
            .stateUUID("state-uuid")
                    compressor,
        }
        assertEquals(1, remoteClusterStateService.getRemoteStateStats().getStateFullDownloadValidationFailed());
        mockBlobContainer(blobContainer1, clusterManifest1, indexMetadataMap1, MANIFEST_CURRENT_CODEC_VERSION);  
import java.util.Iterator;
        assertThat(manifest.getPreviousClusterUUID(), is(expectedManifest.getPreviousClusterUUID()));  
            repositoriesServiceSupplier,
            } catch (IOException e) {  
        assertThat(manifest.getTransientSettingsMetadata(), nullValue());
        );
    public void testWriteMetadataInParallelIncompleteUpload() throws IOException {
                anyBoolean(),
        );  
                new UploadedMetadataAttribute("custom_md_1", "test-custom1-file__1"),
            eq(true),
                    metadata.coordinationMetadata(),
    }
            .build();  
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
            .build();
        doAnswer(invocationOnMock -> {  
            );
                eq(true)
        Metadata metadata2 = Metadata.builder()  
            .build();
        verify(mockedGlobalMetadataManager, times(1)).readAsync(  
                BytesReference bytes = remoteDiscoveryNodes.discoveryNodesFormat.serialize(  
    }
            .indices(Collections.emptyList())
        doAnswer(invocationOnMock -> {
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder().indices(Collections.emptyList()).build();
            );
                eq(true),  
        RemoteReadResult mockedResult = mock(RemoteReadResult.class);
                    return new ByteArrayInputStream(bytesIndexMetadata.streamInput().readAllBytes());
        newClusterStateCustoms.keySet().forEach(uploadedClusterStateCustomMetadataKey -> {
            .readClusterStateInParallel(  
import org.opensearch.cluster.metadata.IndexMetadata;
            assertEquals(metadataAfterUpdate.getIndices().size(), initialMetadata.getIndices().size());
                true,
        initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode.FAILURE);
                eq(true),  
            .getClusterMetadataManifest();  
            clusterState,
            "test-index",
        remoteClusterStateService = new RemoteClusterStateService(
        RemoteReadResult mockedResult = mock(RemoteReadResult.class);
        final Settings idxSettings = Settings.builder()
                    threadPool,
import java.util.stream.Stream;
    public void testFailWriteIncrementalMetadataWhenManifestNull() {
        clusterSettings.applySettings(newSettings);
    public void testTimeoutWhileWritingManifestFile() throws IOException {
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
            ),
                eq(manifest.getClusterUUID()),
import org.opensearch.core.xcontent.NamedXContentRegistry;
        final ClusterMetadataManifest initialManifest = remoteClusterStateService.writeFullMetadata(initialClusterState, "_na_")
        remoteClusterStateService.setRemoteClusterStateAttributesManager(mockedClusterStateAttributeManager);
            Thread.sleep(readTimeOut * 1000 + 100);
            "routing-filename",  
import static org.opensearch.gateway.remote.model.RemoteCoordinationMetadata.COORDINATION_METADATA;
        final UploadedIndexMetadata uploadedIndiceRoutingMetadata = new UploadedIndexMetadata(  
                eq(manifest),  
                    templatesMetadata,
                eq(NODE_ID),
        assertThat(manifest.getIndices().size(), is(1));  
        });  
            "routing-filename",
            eq(emptyMap()),  
            .build();  
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeIncrementalMetadata(
        mockBlobStoreObjects();
        assertEquals(indexMetadataMap.get(index.getName()).getNumberOfShards(), indexMetadata.getNumberOfShards());
            .indicesRouting(List.of(uploadedIndiceRoutingMetadata))  
        RemoteIndexMetadataManager mockedIndexManager = mock(RemoteIndexMetadataManager.class);
                    .build()
                eq(clusterState),
                eq(false),
                    .getUploadedFilename()
            .routingTableVersion(1L)  
            .stateVersion(1L)
                emptyList(),  
                anyList(),
        doReturn(clusterState).when(mockService)
            FORMAT_PARAMS  
            eq(emptyList()),  
        assertNotEquals(
        when(blobContainer.listBlobsByPrefixInSortedOrder("manifest" + DELIMITER, 1, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC))
        remoteClusterStateService.setRemoteGlobalMetadataManager(mockedGlobalMetadataManager);  
                eq(true),  
            .metadata(Metadata.builder().coordinationMetadata(coordinationMetadata))  
            clusterState.getClusterName().value(),
            IllegalStateException.class,  
    private BlobStore blobStore;
                eq(false),
            return null;  
            .build();
            eq(false),  
            .stateUUID("state-uuid")
                eq(emptyList()),
                    .version(randomNonNegativeLong())
                eq(true),
            .build();
            listenerArgumentCaptor.getValue().onResponse(mockedResult);
                anyBoolean(),
                anyBoolean(),  
                anyBoolean(),  
            diffManifestBuilder.clusterBlocksUpdated(true);
                eq(manifest.getClusterStateCustomMap()),  
        RemoteGlobalMetadataManager mockedGlobalMetadataManager = mock(RemoteGlobalMetadataManager.class);
    }
        namedWriteableRegistry = new NamedWriteableRegistry(writeableEntries);  
        assertEquals(expectedClusterState.getClusterName(), updatedClusterState.getClusterName());  
        AsyncMultiStreamBlobContainer container = (AsyncMultiStreamBlobContainer) mockBlobStoreObjects(AsyncMultiStreamBlobContainer.class);  
                emptyMap(),
    private static final String PERSISTENT_SETTINGS_FILENAME = "persistent-settings-file__1";
        IndexMetadata indexMetadata1 = new IndexMetadata.Builder(index1.getName()).settings(idxSettings1)
            .customMetadataMap(customMetadataMap)
        );
                            )
            assertFalse(updatedClusterState.metadata().customs().containsKey(customMetadataName));
        doReturn(clusterStateWrong).when(mockService)  
            INDEX_ROUTING_METADATA_PREFIX
                    repositoriesServiceSupplier,
        assertEquals("Exception during reading cluster state from remote", e.getMessage());
            .numberOfReplicas(0)  
        RemoteClusterStateService spiedService = spy(remoteClusterStateService);
                    .coordinationMetadata(
        // differGlobalMetadata controls which one of IndexMetadata or Metadata object would be different
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
            .clusterUUID("cluster-uuid")
        BlobContainer blobContainer = mockBlobStoreObjects();
                    return;
            eq(NODE_ID),
                new RemoteReadResult(updatedTransientSettings, TRANSIENT_SETTING_METADATA, TRANSIENT_SETTING_METADATA)
        // verify that initial index is removed, and new index are added
        final UploadedIndexMetadata uploadedIndiceRoutingMetadata = new UploadedIndexMetadata(  
import java.util.stream.Collectors;  
        // when(blobStoreRepository.getNamedXContentRegistry()).thenReturn(new NamedXContentRegistry(
        );
        remoteClusterStateService.start();
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder()  
            previousManifest
            any()
                any(),
        RemoteClusterStateAttributesManager mockedClusterStateAttributeManager = mock(RemoteClusterStateAttributesManager.class);
        remoteClusterStateService.start();  
import org.opensearch.common.compress.DeflateCompressor;
            previousManifest  
                "custom_md_2",  
        assertNotNull(manifest.getSettingsMetadata());  
            new UploadedIndexMetadata("index2", "index-uuid2", "key2__2")  
import org.opensearch.repositories.fs.FsRepository;
            when(blobContainer.readBlob(CLUSTER_BLOCKS_FILENAME)).thenAnswer(invocationOnMock -> {  
                anyBoolean(),  
    public void testReadLatestMetadataManifestSuccess() throws IOException {
        );
        when(blobPath.buildAsString()).thenReturn("/blob/path/");
import java.io.ByteArrayInputStream;
import org.opensearch.cluster.metadata.DiffableStringMap;  
    }
        ArrayList<BlobContainer> mockBlobContainerOrderedList = new ArrayList<>(
        final ClusterMetadataManifest initialManifest = remoteClusterStateService.writeFullMetadata(initialClusterState, "_na_")  
 * compatible open source license.
import static org.opensearch.gateway.remote.ClusterMetadataManifest.MANIFEST_CURRENT_CODEC_VERSION;
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V1;  
            diffManifestBuilder.customMetadataUpdated(Collections.singletonList(addedCustom.getWriteableName()));  
        remoteClusterStateService = new RemoteClusterStateService(
        verify(mockGlobalMetadataManager, times(1)).readAsync(
import org.opensearch.common.settings.Settings;
        remoteClusterStateService.start();  
    }  
                new RemoteReadResult(  
                true,  
            .previousClusterUUID("prev-cluster-uuid")
import static org.hamcrest.Matchers.anEmptyMap;  
            randomFrom(  
            RemoteStateTransferException.class,
            RemoteStateTransferException.class,
            .build();
                    .putCustom("custom2", new CustomMetadata1("mock_updated_custom_metadata"))
        assertThat(manifest.getIndicesRouting().get(0).getIndexUUID(), is(uploadedIndiceRoutingMetadata.getIndexUUID()));
    }
            assertEquals(metadataAfterUpdate.getIndices().size(), initialMetadata.getIndices().size());  
        assertThat(manifest.getIndices().size(), is(1));
        }).when(mockedGlobalMetadataManager)
                true,  
                anyBoolean(),  
        assertEquals(2, manifest2.getIndices().size());
import static org.opensearch.gateway.remote.model.RemoteTemplatesMetadataTests.getTemplatesMetadata;
        if (randomBoolean()) {
            "remote_store_repository"
            )  
        TemplatesMetadata updatedTemplateMetadata = getTemplatesMetadata();  
            return null;
            return null;  
                anyBoolean(),  
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))  
        RemoteReadResult mockResult = mock(RemoteReadResult.class);
            return null;
        remoteClusterStateService.start();
            LatchedActionListener<RemoteReadResult> latchedActionListener = invocationOnMock.getArgument(2, LatchedActionListener.class);
            randomAlphaOfLength(10),  
            .routingTableVersion(1)
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();  
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeFullMetadata(clusterState, "prev-cluster-uuid")
            updatedClusterState.metadata().coordinationMetadata().term()
            .clusterTerm(1L)
                    new UploadedMetadataAttribute("custom_1", "test-cluster-state-custom1-file__1"),
        assertEquals(1, remoteClusterStateService.getDiffDownloadStats().getFailedCount());
        RemoteGlobalMetadataManager mockGlobalMetadataManager = mock(RemoteGlobalMetadataManager.class);
        when(blobStoreRepository.getCompressor()).thenReturn(new DeflateCompressor());
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");  
                return new ByteArrayInputStream(bytes.streamInput().readAllBytes());  
        ClusterState clusterState1 = ClusterState.builder(initialClusterState)
        }).when(mockedClusterStateAttributeManager).readAsync(anyString(), any(), listenerArgumentCaptor.capture());
                eq(true),
        int writeTimeout = 2;
import org.opensearch.gateway.remote.model.RemoteTransientSettingsMetadata;  
        when(blobContainer.readBlob(mockManifestFileName)).thenReturn(new ByteArrayInputStream(bytes.streamInput().readAllBytes()));
            .stateUUID("state-uuid")
        final FilterRepository filterRepository = mock(FilterRepository.class);
        assertThat(manifest.getIndices().size(), is(1));
                anyBoolean(),
                new UploadedMetadataAttribute(HASHES_OF_CONSISTENT_SETTINGS, HASHES_OF_CONSISTENT_SETTINGS_FILENAME)  
                        settings,
            assertEquals(
        ClusterState clusterStateWrong = ClusterState.builder(clusterState).routingTable(RoutingTable.EMPTY_ROUTING_TABLE).build();
            manifest,  
        final ClusterState previousClusterState = ClusterState.builder(ClusterName.DEFAULT)
                anyBoolean(),  
        // new custom metadata to be added  
            .stateVersion(1L)
        assertEquals(clusterState.metadata().templates(), updatedClusterState.metadata().templates());
                eq(true),  
            "routing-filename",
            .codecVersion(CODEC_V2)  
            eq(manifest.getIndicesRouting()),
                any()
            any()
                eq(true),  
                eq(false),
import org.opensearch.index.remote.RemoteStoreUtils;
import java.util.HashMap;
        int codecVersion
            );
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().build();
                .build();
                any(),
import org.opensearch.gateway.remote.model.RemoteClusterBlocks;
            assertEquals(metadataAfterUpdate.getSettingsMetadata(), initialMetadata.getSettingsMetadata());
        assertThat(manifest.getIndices().get(0).getIndexUUID(), is(uploadedIndexMetadata.getIndexUUID()));
            assertEquals(metadataAfterUpdate.getIndices().size(), initialMetadata.getIndices().size());  
        remoteClusterStateService.setRemoteGlobalMetadataManager(mockedGlobalMetadataManager);
            )
        final TestClusterStateCustom1 custom1 = new RemoteClusterStateTestUtils.TestClusterStateCustom1("custom-1");  
    public void testGetClusterStateUsingDiffFailWhenDiffManifestAbsent() {
                }
        );
        assertThat(manifest.getHashesOfConsistentSettings(), notNullValue());  
        ClusterState newClusterState = remoteClusterStateService.getLatestClusterState(
                eq(true),
import org.opensearch.gateway.remote.model.RemoteDiscoveryNodes;
                anyBoolean(),
                clusterService,
        verify(mockGlobalMetadataManager, times(1)).readAsync(  
import org.opensearch.test.OpenSearchTestCase;
            .stateVersion(1L)
            .build();  
        assertThat(manifest.getGlobalMetadataFileName(), nullValue());
        ClusterState state = remoteClusterStateService.getLatestClusterState(
                );
    public void testWriteFullMetadataSuccessWithRoutingTable() throws IOException {
            argThat(new BlobNameMatcher(DISCOVERY_NODES_FILENAME)),
                blobContainer2,  
        RemoteClusterStateService mockService = spy(remoteClusterStateService);  
        );
        assertEquals("Diff manifest null which is required for downloading cluster state", error.getMessage());
        mockBlobStoreObjects();
                new ArrayList<>(clusterState.getMetadata().indices().values()),
        ).build();
        final Settings settings = Settings.builder().put("mock-settings", true).build();
        final Index index = new Index("test-index", "index-uuid");
            LatchedActionListener<RemoteReadResult> latchedActionListener = invocationOnMock.getArgument(2, LatchedActionListener.class);
            listenerArgumentCaptor.getValue().onResponse(mockedResult);  
            );
            .codecVersion(MANIFEST_CURRENT_CODEC_VERSION)
            return null;
                    )  
                    updatedClusterStateCustom3,
            .build();  
                    .getUploadedFilename()
            "test-node-id",
    public void testGetValidPreviousClusterUUIDWithInvalidMultipleChains() throws IOException {
            () -> 0L
import static org.opensearch.gateway.remote.model.RemoteTransientSettingsMetadata.TRANSIENT_SETTING_METADATA;
        }).when(mockedGlobalMetadataManager).readAsync(any(), any(), listenerArgumentCaptor.capture());  
                return null;
        // custom2 is updated  
        assertThat(manifest.getIndicesRouting().get(0).getUploadedFilename(), notNullValue());
            List.of(
    public void testWriteIncrementalMetadataSuccessWithRoutingTableDiff() throws IOException {  
        );
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
            randomAlphaOfLength(10),  
            .build();  
            clusterUUIDCommitted.getOrDefault("cluster-uuid2", true)  
        BlobContainer blobContainer,
            expectedClusterStateBuilder.nodes(nodesBuilder.build());
                    blobContainer3,
                eq(true),
                anyBoolean(),
                any(),  
    }
        for (String clusterUUID : clusterUUIDs) {
            .persistentSettings(Settings.builder().put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), !differGlobalMetadata).build())
            newCustomMetadataMap,
        );
            .clusterTerm(1L)  
        assertThat(manifest.getCoordinationMetadata(), notNullValue());
    public void testWriteIncrementalMetadataSuccess() throws IOException {
            uploadedIndexMetadataList2,
 * The OpenSearch Contributors require contributions made to  
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()  
                    initialMetadata.getIndices().get(i).getUploadedFilename()  
        verify(mockClusterStateAttributeManager, times(1)).readAsync(
                anyBoolean(),
        final ClusterState previousClusterState = ClusterState.builder(ClusterName.DEFAULT)
            );  
        }).when(mockedGlobalMetadataManager)  
                anyBoolean(),
                manifest,
        final ClusterState previousClusterState = clusterState;
        assertThrows(IllegalStateException.class, () -> remoteClusterStateService.getLastKnownUUIDFromRemote("test-cluster"));
        }).when(mockGlobalMetadataManager).readAsync(any(), any(), latchCapture.capture());
            .stateVersion(1L)
                eq(manifest.getClusterStateCustomMap()),
                newClusterState,
            ClusterMetadataManifest.builder().build()
            .build();
            new UploadedMetadataAttribute(SETTING_METADATA, "key4"),
                argThat(new BlobNameMatcher(uploadedIndexMetadata.getUploadedFilename())),
        Exception e = assertThrows(
                eq(manifest.getClusterUUID()),
                    return new ByteArrayInputStream(bytesReference.streamInput().readAllBytes());
        assertEquals(clusterState.metadata().version(), updatedClusterState.metadata().version());
        assertFalse(manifest1.getIndices().stream().anyMatch(indexMetadata -> indexMetadata.getIndexName().equals(initialIndex)));
        TestClusterStateCustom3 updatedClusterStateCustom3 = new TestClusterStateCustom3("custom_3");
            .readAsync(
            .numberOfShards(11)
            );  
        assertTrue(initialManifest.getIndices().stream().anyMatch(indexMetadata -> indexMetadata.getIndexName().equals(initialIndex)));
                eq(true),
    }
                eq(false),
                    blobContainer1,  
        ArgumentCaptor<LatchedActionListener<RemoteReadResult>> listenerArgumentCaptor = ArgumentCaptor.forClass(
        // index1 is updated
            manifestAfterMetadataUpdate = remoteClusterStateService.writeFullMetadata(newClusterState, initialClusterState.stateUUID())
            .put(RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)
        doAnswer(invocation -> {
                eq(manifest.getClusterUUID()),
            .clusterTerm(1L)
        long expectedChecksum = RemoteTransferContainer.checksumOfChecksum(new ByteArrayIndexInput("metadata-filename", writtenBytes), 8);
            blobContainerMap.put(clusterUUID, mockBlobStoreObjects());  
                assertEquals(metadataAfterUpdate.getTemplatesMetadata(), initialMetadata.getTemplatesMetadata());
        initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode.NONE);
            .indices(List.of(uploadedIndexMetadata))
                eq(manifest.getClusterUUID()),
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build())
            clusterState.metadata().clusterUUID(),
            for (Map.Entry<String, String> entry : customFileMap.entrySet()) {
            any(ClusterMetadataManifest.class),  
            () -> 0L,  
            .codecVersion(MANIFEST_CURRENT_CODEC_VERSION)
            .previousClusterUUID("prev-cluster-uuid")  
        assertThat(manifest.getIndices().get(0).getIndexUUID(), is(uploadedIndexMetadata.getIndexUUID()));
            anyString(),
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder().indices(indices).build();
    }
        verifyMetadataAttributeOnlyUpdated(updater, (initialMetadata, metadataAfterUpdate) -> {
        assertThat(manifestInfo.getManifestFileName(), notNullValue());
        assertEquals(expectedManifest.getCodecVersion(), manifest.getCodecVersion());
            .build();  
        ).getClusterMetadataManifest();
            .previousClusterUUID("prev-cluster-uuid")
                BytesReference bytes = INDEX_METADATA_FORMAT.serialize(indexMetadata, "add-test-index-file__2", compressor, FORMAT_PARAMS);  
        );
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        Metadata expectedMetadata = Metadata.builder()  
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));  
        verify(mockClusterStateAttributeManager, times(1)).readAsync(  
        ClusterState previousClusterState = generateClusterStateWithAllAttributes().build();
            RemoteStateTransferException.class,
            )
            .routingTableVersion(1)
                    "custom_1",
            ? new ArrayList<>(uploadedIndexMetadataList1)
            .numberOfReplicas(1)  
            ClusterBlocks newClusterBlock = randomClusterBlocks();
        remoteClusterStateService.start();
        String manifestFileName = codecVersion >= CODEC_V1
        }).when(mockedClusterStateAttributeManager)
        assertEquals(clusterState.getBlocks(), updatedClusterState.getBlocks());  
        verify(mockGlobalMetadataManager, times(1)).readAsync(  
        assertThat(previousClusterUUID, equalTo("cluster-uuid3"));
        RemoteClusterStateService mockService = spy(remoteClusterStateService);  
            .build();  
                emptyMap(),
    public void testSettingsMetadataOnlyUpdated() throws IOException {
import org.opensearch.test.VersionUtils;  
        assertThat(manifest.getIndices().size(), is(1));
                anyBoolean(),
                    clusterState.stateUUID(),
            .build();  
import java.util.Optional;  
            .getClusterMetadataManifest();  
            "index-uuid",  
        mockService.getClusterStateUsingDiff(manifest, clusterState, NODE_ID);
            eq(false),
    public void testGetClusterStateUsingDiff() throws IOException {  
            return null;  
import static org.opensearch.gateway.remote.model.RemoteIndexMetadata.INDEX_METADATA_FORMAT;
            eq(manifest),
        RemoteClusterStateAttributesManager mockClusterStateAttributeManager = mock(RemoteClusterStateAttributesManager.class);  
            eq(manifest),
            });
                    threadPool,
                threadPool,
            .stateVersion(1L)  
            .build();
        assertEquals(clusterState.getCustoms(), updatedClusterState.getCustoms());  
        return ClusterState.builder(ClusterName.DEFAULT)  
    /*
                eq(manifest.getIndices()),
            .indices(List.of(uploadedIndexMetadata))
            AssertionError.class,  
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
            .numberOfShards(1)
        Exception e = assertThrows(  
        AsyncMultiStreamBlobContainer container = (AsyncMultiStreamBlobContainer) mockBlobStoreObjects(AsyncMultiStreamBlobContainer.class);
            .build();
        mockBlobContainer(mockBlobStoreObjects(), expectedManifest, new HashMap<>(), CODEC_V2, 1, 1);
            RemoteStateTransferException.class,  
            .clusterUUID("cluster-uuid")  
                );
        });  
    private BlobStoreRepository blobStoreRepository;  
                    clusterSettings,
        verify(mockService, times(1)).readClusterStateInParallel(  
        Function<ClusterState, ClusterState> clusterStateUpdater,  
            .put(  
        verify(mockService, times(0)).validateClusterStateFromChecksum(  
            clusterUUIDsPointers.get("cluster-uuid3"),
            eq(true),
        ClusterBlocks updatedClusterBlocks = randomClusterBlocks();  
        mockBlobStoreObjects();
            .indicesRouting(List.of(uploadedIndiceRoutingMetadata))
            "test-index",
                .get()  
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));  
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));  
            .indices(Collections.emptyList())
        Optional<ClusterMetadataManifest> manifest = remoteClusterStateService.getLatestClusterMetadataManifest(
            )
            .stateVersion(1L)
            routingTableBuilder.addAsNew(indexMetadata);
                anyBoolean(),
            eq(NODE_ID),
            "custom_md_3",
import static org.opensearch.gateway.remote.model.RemoteGlobalMetadata.GLOBAL_METADATA_FORMAT;
                anyMap(),  
        assertThat(manifest.getTemplatesMetadata(), notNullValue());  
        String stateRepoSettingsAttributeKeyPrefix = String.format(
        assertNotNull(remoteClusterStateService.getDiffDownloadStats());  
    @LockFeatureFlag(REMOTE_PUBLICATION_SETTING_KEY)
                )  
        Assert.assertThat(manifestDetails, nullValue());
        compressor = new DeflateCompressor();
    }
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;  
        assertTrue(ex.getMessage().contains("Timed out waiting for transfer"));
        remoteClusterStateService.start();
            .readAsync(eq(HASHES_OF_CONSISTENT_SETTINGS), argThat(new BlobNameMatcher(HASHES_OF_CONSISTENT_SETTINGS_FILENAME)), any());
                    .put(IndexMetadata.SETTING_INDEX_UUID, "add-test-index-uuid")
import java.util.Collections;  
        remoteClusterStateService.start();
                            .put(
                    initialMetadata.getIndices().get(i).getUploadedFilename()  
                eq(true)
            .putCustom(custom1.getWriteableName(), custom1)
        long prevClusterStateVersion = 13L;
                eq(NODE_ID),
            assertEquals(metadataAfterUpdate.getCustomMetadataMap(), initialMetadata.getCustomMetadataMap());
        IndexMetadata indexMetadata1 = IndexMetadata.builder("index1")  
        ).diffManifest(ClusterStateDiffManifest.builder().build()).build();
                );
                assertEquals(metadataAfterUpdate.getSettingsMetadata(), initialMetadata.getSettingsMetadata());  
        remoteClusterStateService.start();
                    transientSettings,  
                null
                    blobContainer1,
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata(index.getName(), index.getUUID(), fileName);
            .coordinationMetadata(coordinationMetadata)
                Map.of(
        mockBlobContainer(blobContainer, expectedManifest, Map.of());
            Map.of(  
            listenerArgumentCaptor.getValue().onResponse(mockedResult);
        verifyWriteIncrementalGlobalMetadataFromOlderCodecSuccess(previousManifest);
            return null;
            manifestBuilder.build(),
            listenerArgumentCaptor.getValue().onResponse(mockedResult);
            .clusterUUID("cluster-uuid")
            "cluster-uuid1",
        RemoteStateTransferException ex = expectThrows(  
                eq(Collections.singletonMap(indices.get(0).getIndexName(), null)),
            mb.coordinationMetadata(coordinationMetadata);  
                )
        Settings idxSettings2 = Settings.builder()  
            () -> remoteClusterStateService.readClusterStateInParallel(
                IndexGraveyard.TYPE,
            .build();  
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeIncrementalMetadata(
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));  
        mockObjectsForGettingPreviousClusterUUID(clusterUUIDsPointers, clusterUUIDCommitted);  
        verify(spiedService, times(1)).readClusterStateInParallel(
                eq(true),  
                eq(true)
            "routing-filename",  
                    .build()  
            false
                eq(Collections.emptyMap()),
        expectThrows(IllegalStateException.class, () -> mockService.getClusterStateUsingDiff(manifest, clusterState, NODE_ID));  
            .clusterUUID("cluster-uuid")
        remoteClusterStateService.start();
                .getUploadedFilename()
        final ClusterState previousClusterState = ClusterState.builder(ClusterName.DEFAULT)  
            .put(stateRepoSettingsAttributeKeyPrefix + "location", "randomRepoPath")
            return null;
            );
            updatedClusterState.getMetadata().transientSettings().equals(clusterState.getMetadata().transientSettings())  
        }  
            "routing-filename",
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())  
        final UploadedIndexMetadata uploadedIndiceRoutingMetadata = new UploadedIndexMetadata(
                return false;
            .codecVersion(MANIFEST_CURRENT_CODEC_VERSION)
            .readClusterStateInParallel(  
            manifestBuilder.templatesMetadata(new UploadedMetadataAttribute(TEMPLATES_METADATA, TEMPLATES_METADATA_FILENAME));
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))  
            });
            any()
            .clusterTerm(clusterState.term())  
    public void testWriteFullMetadataSuccess() throws IOException {
                return new ByteArrayInputStream(bytes.streamInput().readAllBytes());
            "index-uuid",  
        Mockito.verify(rcssSpy)  
        );  
            verify(mockedClusterStateAttributeManager, times(1)).readAsync(  
        final BlobContainer blobContainer = mock(blobContainerClazz);
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))  
            manifestBuilder.transientSettingsMetadata(
        ).build();
            "ClusterState version is not restored. previousClusterVersion: [%s] is not equal to current [%s]",
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
            .metadata(Metadata.builder().coordinationMetadata(coordinationMetadata))  
        assertNotEquals(diffManifest.isDiscoveryNodesUpdated(), updatedClusterState.getNodes().equals(clusterState.getNodes()));  
                any()  
        long version
        RemoteIndexMetadataManager mockedIndexManager = mock(RemoteIndexMetadataManager.class);  
            eq(HASHES_OF_CONSISTENT_SETTINGS),
        assertThat(manifest.getIndicesRouting().get(0).getIndexName(), is(uploadedIndiceRoutingMetadata.getIndexName()));
        initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode.TRACE);  
            .build();
        assertThat(manifest.getPreviousClusterUUID(), is(expectedManifest.getPreviousClusterUUID()));  
        );  
        final Settings settings = Settings.builder().put("mock-settings", true).build();
                eq(false),  
                when(blobContainer.readBlob(getFormattedIndexFileName(fileName))).thenAnswer((invocationOnMock) -> {
            .metadata(  
        mockBlobContainer(blobContainer3, clusterManifest3, indexMetadataMap3, MANIFEST_CURRENT_CODEC_VERSION);  
                    .persistentSettings(clusterSettings)
            .settingMetadata(new ClusterMetadataManifest.UploadedMetadataAttribute(SETTING_METADATA, "mock-setting-file"))
            eq(false),
    ) throws IOException {  
        rcssSpy.setRemoteClusterStateAttributesManager(mockedClusterStateAttributeManager);  
        Map<String, UploadedMetadataAttribute> customMetadataMap,
        assertThat(manifest.getTemplatesMetadata(), notNullValue());
                );  
            .build();
        verify(mockService, times(1)).validateClusterStateFromChecksum(
            "cluster-uuid3",
            });  
                new RemoteIndexPathUploader(  
import org.opensearch.threadpool.ThreadPool;
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
                // update
        );  
                eq(manifest.getClusterStateCustomMap()),  
        doReturn(clusterStateWrong).when(mockService)
            List.of(
                eq(manifest.getCustomMetadataMap()),
                        indexMetadata,
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));  
        BlobContainer[] mockBlobContainerOrderedArray = new BlobContainer[mockBlobContainerOrderedList.size()];  
        );
        final ClusterMetadataManifest manifest = remoteClusterStateService.getLatestClusterMetadataManifest(  
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
        blobStoreRepository = mock(BlobStoreRepository.class);
            .writeMetadataInParallel(
                    new RemoteIndexPathUploader(  
            .nodeId("nodeA")  
                () -> 0L  
        BlobContainer uuidBlobContainer = mock(BlobContainer.class);
            eq(manifest.getClusterUUID()),  
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));
import org.opensearch.cluster.RepositoryCleanupInProgress;  
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");
        List<UploadedIndexMetadata> indices = List.of(uploadedIndexMetadata);
        );
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
            new Thread(new Runnable() {  
            .codecVersion(previousCodec)
        ClusterState clusterState2 = ClusterState.builder(initialClusterState)
                anyList(),  
        ClusterState previousState = ClusterState.EMPTY_STATE;  
    }
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.common.remote.AbstractClusterMetadataWriteableBlobEntity;
import org.mockito.ArgumentMatcher;
    }
        ).build();
                RemoteClusterBlocks remoteClusterBlocks = new RemoteClusterBlocks(
            .metadata(Metadata.builder().coordinationMetadata(coordinationMetadata))
            eq(manifest.getCustomMetadataMap()),
                blobContainer1,  
        doAnswer((i) -> {
import static org.hamcrest.Matchers.nullValue;
        final UploadedIndexMetadata uploadedIndiceRoutingMetadata = new UploadedIndexMetadata(  
        final CustomMetadata1 customMetadata1 = new CustomMetadata1("custom-metadata-1");  
            .clusterTerm(1L)
        ).get();  
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
            .numberOfShards(1)  
        final UploadedIndexMetadata uploadedIndiceRoutingMetadata = new UploadedIndexMetadata(
        assertEquals(clusterState.metadata().clusterUUID(), updatedClusterState.metadata().clusterUUID());  
            "routing-filename",
        doAnswer(invocationOnMock -> {  
            eq(true),
    private class BlobNameMatcher implements ArgumentMatcher<AbstractClusterMetadataWriteableBlobEntity> {  
            .clusterTerm(1L)  
                emptyMap(),
                )  
                        fileName,  
        final ClusterState previousClusterState = ClusterState.builder(ClusterName.DEFAULT)
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
        uploadedClusterStateCustomMap.putAll(newClusterStateCustoms);  
        uploadedClusterStateCustomMap.keySet().forEach(key -> assertTrue(updatedClusterState.customs().containsKey(key)));
        assertThat(manifest.getPreviousClusterUUID(), is(expectedManifest.getPreviousClusterUUID()));
                BytesReference bytes = TEMPLATES_METADATA_FORMAT.serialize(  
    }  
                eq(NODE_ID),
                return new ByteArrayInputStream(bytesReference.streamInput().readAllBytes());
            )
        );
    }
        remoteClusterStateService.setRemoteGlobalMetadataManager(mockedGlobalMetadataManager);
        RemoteReadResult mockedResult = mock(RemoteReadResult.class);  
            eq(SETTING_METADATA),
            .settings(indexSettings)  
                true,
            // setting metadata file would have changed
        assertThat(manifest.getIndices().get(0).getIndexName(), is(uploadedIndexMetadata.getIndexName()));
        ClusterMetadataManifest.Builder manifestBuilder = ClusterMetadataManifest.builder();
            )  
                    blobContainer3,  
        return mockBlobStoreObjects(BlobContainer.class);
        ClusterState clusterStateWrong = ClusterState.builder(clusterState).routingTable(RoutingTable.EMPTY_ROUTING_TABLE).build();
            .indices(List.of(uploadedIndexMetadata))  
            .indices(List.of(uploadedIndexMetadata))  
            AssertionError.class,
            .build();
            LatchedActionListener.class  
                eq(manifest.getIndices()),
        assertThrows(
 *
            .stateVersion(13)
        assertThat(manifest.getIndicesRouting().get(0).getIndexName(), is(uploadedIndiceRoutingMetadata.getIndexName()));
            any()
            .indices(Collections.emptyList())
        assertThrows(RepositoryMissingException.class, () -> remoteClusterStateService.start());
                eq(true)  
        doAnswer(invocation -> {  
            // template metadata file would have changed
     * Here we will verify the migration of manifest file from codec V0.  
                eq(manifest.getIndicesRouting()),
                argThat(new BlobNameMatcher(newClusterStateCustoms.get(uploadedClusterStateCustomMetadataKey).getUploadedFilename())),
        verifyMetadataAttributeOnlyUpdated(updater, (initialMetadata, metadataAfterUpdate) -> {
            clusterService,  
            return null;  
        assertEquals(updatedDiscoveryNodes.getClusterManagerNodeId(), updatedClusterState.getNodes().getClusterManagerNodeId());  
            Locale.getDefault(),
        );
                eq(manifest.getIndicesRouting()),
        assertThat(manifest.getIndices().get(0).getIndexName(), is(uploadedIndexMetadata.getIndexName()));
        remoteClusterStateService.start();  
        when(repositoriesServiceSupplier.get()).thenReturn(repositoriesService);  
        // existing custom metadata
        mockBlobContainerForClusterUUIDs(uuidBlobContainer, clusterUUIDsPointers.keySet());  
                repositoriesServiceSupplier,  
import static java.util.Collections.emptyList;  
        when(repositoriesService.repository("remote_store_repository")).thenReturn(blobStoreRepository);
                assertEquals(  
                    compressor,  
                eq(Collections.singletonMap(indices.get(0).getIndexName(), null)),
        assertEquals(0, remoteClusterStateService.getRemoteStateStats().getStateFullDownloadValidationFailed());  
                Metadata.builder()  
            assertNotEquals(originalIndexMetadata, updatedIndexMetadata);
        List<UploadedIndexMetadata> newIndicesToRead = List.of(
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
                eq(manifest),
        ArgumentCaptor<WriteContext> writeContextArgumentCaptor = ArgumentCaptor.forClass(WriteContext.class);
                            )
                () -> 0L,  
        indexMetadata1 = new IndexMetadata.Builder(indexMetadata1).version(indexMetadata1.getVersion() + 1).build();
            argThat(new BlobNameMatcher(HASHES_OF_CONSISTENT_SETTINGS_FILENAME)),
                eq(uploadedCustomMetadataKey),
            "test-node-id",  
            .templatesMetadata(new ClusterMetadataManifest.UploadedMetadataAttribute(TEMPLATES_METADATA, "mock-templates-file"))
            .put(REMOTE_PUBLICATION_SETTING_KEY, true)
        assertEquals(0, remoteClusterStateService.getRemoteStateStats().getStateDiffDownloadValidationFailed());
        mockObjectsForGettingPreviousClusterUUID(clusterUUIDsPointers, false, Collections.emptyMap());  
        Boolean isUUIDCommitted  
    }
        assertTrue(remoteClusterStateService.isRemotePublicationEnabled());  
        assertNotNull(remoteClusterStateService.getFullDownloadStats());  
                eq(manifest.getIndices()),
            .readClusterStateInParallel(
                BytesReference bytes = remoteHashesOfConsistentSettings.hashesOfConsistentSettingsFormat.serialize(  
            LatchedActionListener.class
            assertNotEquals(originalCustomMetadata, updatedCustomMetadata);
            "test-index",  
        assertThat(manifest.getIndicesRouting().get(0).getIndexUUID(), is(uploadedIndiceRoutingMetadata.getIndexUUID()));  
        verify(mockGlobalMetadataManager, times(1)).readAsync(
            .put(IndexTemplateMetadata.builder("template-1").patterns(List.of("test-index* ")).build())  
                eq(manifest.getIndicesRouting()),  
            eq(manifest.getClusterUUID()),
            false
            eq(CLUSTER_BLOCKS),
import org.opensearch.repositories.FilterRepository;
        );
            assertEquals(metadataAfterUpdate.getCoordinationMetadata(), initialMetadata.getCoordinationMetadata());
            .previousClusterUUID("prev-cluster-uuid")
            .build();
            .stateUUID("state-uuid")
            .version(1L)
        mockBlobStoreObjects();
        RemoteGlobalMetadataManager mockedGlobalMetadataManager = mock(RemoteGlobalMetadataManager.class);
        initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode.FAILURE);
        }  
        final Index index = new Index(indexName, "index-uuid");
                .put("random_transient_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5))  
        return splitPath[splitPath.length - 1];
    }
    }  
    }
        final DiscoveryNodes nodes = nodesWithLocalNodeClusterManager();
            return "BlobNameMatcher[Expected blobName: " + expectedBlobName + "]";
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()  
    public void testReadLatestIndexMetadataSuccess() throws IOException {
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(1L).build();  
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(1L).build();
     * Initially codec version is 1 and a global metadata file is there, we will perform index metadata update.
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));  
            true,  
import org.opensearch.core.index.Index;
                eq(true),
            eq(manifest),
            anyString(),  
                eq(true),  
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
            "cluster-uuid2"
        assertEquals(e.getMessage(), "Error while downloading cluster metadata - manifestFileName");
        ArgumentCaptor<ActionListener<Void>> actionListenerArgumentCaptor = ArgumentCaptor.forClass(ActionListener.class);
            eq(TEMPLATES_METADATA),  
            ClusterState.Custom updateClusterStateCustom = updatedClusterState.customs().get(clusterStateCustomName);
            List.of(new UploadedIndexMetadata("test-index", "test-index-uuid", "test-index-file__2"))  
                eq(manifest),  
            WriteContext writeContext = writeContextArgumentCaptor.getValue();  
                any(),
        doAnswer(invocation -> {
            .indices(Collections.emptyList())  
                // update
            .readClusterStateInParallel(
            assertEquals(capturedWriteContext.get("metadata").getExpectedChecksum().longValue(), expectedChecksum);  
                Metadata.builder()  
                Map.of(  
            .coordinationMetadata(CoordinationMetadata.builder().term(1).build())  
        }
                // since timestamp is part of file name, if file name is same we can confirm that file is not update in global metadata
        String clusterUUID,
            ? new HashMap<>(indexMetadataMap1)
                eq(manifest.getClusterStateCustomMap()),
            );
                    .version(clusterState1.metadata().version() + 1)
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().checksum(  
            "index-uuid",
        assertEquals(
        }).when(mockedGlobalMetadataManager)
        ).build();
            clusterState,
            clusterService,  
            .metadata(  
    }  
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
        boolean addAsNew
                    .put(
                eq(NODE_ID),
        assertEquals(newIndexMetadata, updatedClusterState.metadata().index(newIndexMetadata.getIndex()));
            () -> spiedService.writeFullMetadata(clusterState, randomAlphaOfLength(10))
        }).when(mockedIndexManager)
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY;
            threadPool,
import java.util.function.Function;
                eq(NODE_ID),
                eq(manifest),
            diffManifestBuilder.coordinationMetadataUpdated(true);
            new UploadedMetadataAttribute(SETTING_METADATA, "key4"),
    }  
                    .hashesOfConsistentSettings(Map.of("key1", "value1", "key2", "value2"))
            manifest.getClusterUUID(),
            .clusterTerm(clusterState.term())
        );
        remoteClusterStateService.start();
        assertEquals(1, remoteClusterStateService.getRemoteStateStats().getStateDiffDownloadValidationFailed());
            clusterStateWrong,
                IndexGraveyard.TYPE,
            true,
        if (randomBoolean()) {
        assertThat(manifest.getTemplatesMetadata(), notNullValue());
            repositoriesServiceSupplier,
        Metadata metadata1 = Metadata.builder()
        } else {
        if (randomBoolean()) {  
                BytesReference bytes = remoteClusterBlocks.clusterBlocksFormat.serialize(
            eq(false),
        assertEquals(indexMetadataMap.get(index.getName()).getIndex().getName(), index.getName());  
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeFullMetadata(clusterState, "prev-cluster-uuid")
        ClusterStateDiffManifest diffManifest = diffManifestBuilder.build();
                    );
            clusterState,  
        assertThat(manifest.getCustomMetadataMap().size(), not(0));
        );
            .metadata(  
            listenerArgumentCaptor.getValue().onResponse(mockedResult);
        assertThat(manifest.getRoutingTableVersion(), is(expectedManifest.getRoutingTableVersion()));  
                    .build()
        );
                        FORMAT_PARAMS  
        ).build();
        Settings newSettings = Settings.builder()
            );  
            blobStoreRepository.getNamedXContentRegistry(),
                    .coordinationMetadata(coordinationMetadata)
        remoteClusterStateService.setRemoteGlobalMetadataManager(mockedGlobalMetadataManager);
            .metadata(
        ClusterMetadataManifest.UploadedMetadata mockedUploadedMetadata = mock(ClusterMetadataManifest.UploadedMetadata.class);  
            listenerArgumentCaptor.getValue().onResponse(new RemoteReadResult(indexMetadata, INDEX, INDEX));  
        final UploadedIndexMetadata uploadedIndiceRoutingMetadata = new UploadedIndexMetadata(
            assertEquals(metadataAfterUpdate.getTemplatesMetadata(), initialMetadata.getTemplatesMetadata());
                    new UploadedMetadataAttribute("custom_md_2", "test-custom2-file__1")
        assertThat(previousClusterUUID, equalTo("cluster-uuid2"));
        } else {
        remoteClusterStateService.start();
    ) throws IOException {  
                "custom_2",  
                eq(true),
            .persistentSettings(Settings.builder().put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), true).build())
                        fileName,
            "routing-filename",  
    public void testCustomMetadataOnlyUpdated() throws IOException {
        String fileName = "metadata-" + index.getUUID() + "__1";  
                    clusterSettings,
                eq(true),
                new RemoteIndexPathUploader(
        // new index to be added
                anyBoolean(),
            eq(TRANSIENT_SETTING_METADATA),
            .previousClusterUUID("prev-cluster-uuid")  
    }
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().codecVersion(CODEC_V1).build();
        Map<String, String> clusterUUIDsPointers = Map.of(
        assertThrows(IllegalStateException.class, () -> remoteClusterStateService.getLastKnownUUIDFromRemote("test-cluster"));
        final CustomMetadata1 customMetadata1 = new CustomMetadata1("custom-metadata-1");
            clusterState.getClusterName().value(),  
            any(),
            new UploadedMetadataAttribute("custom_3", clusterStateCustomFilename)  
                anyBoolean(),
        mockBlobStoreObjects();
        // Update only index metadata
                metadataAfterUpdate.getSettingsMetadata()  
                IndexMetadata indexMetadata = indexMetadataMap.get(uploadedIndexMetadata.getIndexUUID());
        if (randomBoolean()) {  
            threadPool,  
                any(),
        diffManifest.getIndicesUpdated().forEach(indexName -> {
        publicationEnabled = true;
                eq(emptyList()),  
        remoteClusterStateService.start();  
        assertEquals(writtenIndexMetadata.getIndex().getName(), "test-index");
        assertThat(manifest.getIndices().size(), is(1));
            .stateUUID("state-uuid")  
        remoteClusterStateService.setRemoteIndexMetadataManager(mockedIndexManager);
                    .version(initialClusterState.metadata().version() + 1)
                anyBoolean(),
            ),
                    clusterSettings,
                    .persistentSettings(settings)
            assertEquals(metadataAfterUpdate.getCustomMetadataMap(), initialMetadata.getCustomMetadataMap());  
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.getFormattedIndexFileName;  
        mockBlobContainerForGlobalMetadata(blobContainer3, clusterManifest3, metadata3);
            clusterState,
            NODE_ID,
        ClusterStateDiffManifest.Builder diffManifestBuilder = ClusterStateDiffManifest.builder();
            threadPool,
    }
        mockObjectsForGettingPreviousClusterUUID(clusterUUIDsPointers);
        RemoteIndexMetadataManager mockIndexMetadataManager = mock(RemoteIndexMetadataManager.class);  
        doAnswer(invocation -> {
            .metadata(
        verify(mockService, times(0)).validateClusterStateFromChecksum(
                    .build()
        Map<String, Boolean> clusterUUIDCommitted
        );
        IndexMetadata indexMetadata5 = IndexMetadata.builder("index1")
        );
        );  
                .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")  
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeIncrementalMetadata(  
                    .version(initialClusterState.metadata().version() + 1)
            when(blobContainer.readBlob(HASHES_OF_CONSISTENT_SETTINGS_FILENAME)).thenAnswer(i -> {
            .indicesRouting(List.of(uploadedIndiceRoutingMetadata))
                    FORMAT_PARAMS  
                BytesReference bytes = RemoteTransientSettingsMetadata.SETTINGS_METADATA_FORMAT.serialize(
        List<UploadedIndexMetadata> indices = List.of(uploadedIndexMetadata);
            .build();
                anyList(),  
                true,
            .stateVersion(1L)
        );  
            newSettings,
    ) throws IOException {  
            INDEX_ROUTING_METADATA_PREFIX
            Locale.ROOT,  
        assertThat(manifest.getRoutingTableVersion(), is(expectedManifest.getRoutingTableVersion()));
                    CLUSTER_STATE_ATTRIBUTE,
                new ClusterMetadataManifest.UploadedMetadataAttribute(IndexGraveyard.TYPE, "mock-custom-" + IndexGraveyard.TYPE + "-file")  
            .codecVersion(CODEC_V2)
            new UploadedMetadataAttribute(COORDINATION_METADATA, "key3"),  
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
        final Settings settings = Settings.builder().put("mock-settings", true).build();
            repositoriesServiceSupplier,  
            clusterState.getClusterName().value(),  
        doAnswer(invocationOnMock -> {  
            .checksum(new ClusterStateChecksum(clusterState, threadPool))  
    public void testTimeoutWhileWritingMetadata() throws IOException {
        String previousClusterUUID,
import org.mockito.ArgumentCaptor;
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
            );  
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().build();  
            .build();
                clusterState.getClusterName().value(),
        remoteClusterStateService.start();  
    private ClusterSettings clusterSettings;  
        RemoteStateTransferException exception = expectThrows(  
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));
            .version(12)
        // setup
            updatedClusterState.getMetadata().persistentSettings().equals(clusterState.getMetadata().persistentSettings())
        }).when(mockedGlobalMetadataManager)
                true,
                new UploadedMetadataAttribute("custom_1", "test-cluster-state-custom1-file__1"),
                eq(false),  
            any(ClusterState.class),  
        boolean differGlobalMetadata,  
            .build();  
            : List.of(new UploadedIndexMetadata("index1", "index-uuid1", "key1__2"));  
        ArgumentCaptor<LatchedActionListener<RemoteReadResult>> listenerArgumentCaptor = ArgumentCaptor.forClass(
                NODE_ID,  
        mockBlobContainerForGlobalMetadata(blobContainer1, clusterManifest1, metadata1);
            .routingTableVersion(1)
import org.opensearch.common.blobstore.transfer.RemoteTransferContainer;
                anyBoolean(),
                    PERSISTENT_SETTINGS_FILENAME,
        mockBlobStoreObjects();
            .settings(indexSettings)
            .stateVersion(1L)
        assertEquals(clusterState.metadata().hashesOfConsistentSettings(), updatedClusterState.metadata().hashesOfConsistentSettings());
        RemoteClusterStateService mockService = spy(remoteClusterStateService);
        }).when(mockedIndexManager).readAsync(anyString(), any(), listenerArgumentCaptor.capture());
        RemoteClusterStateService mockService = spy(remoteClusterStateService);
        );
                anyBoolean(),
import static org.hamcrest.Matchers.notNullValue;
            diffManifestBuilder.hashesOfConsistentSettingsUpdated(true);
            .getState(clusterState.getClusterName().value(), notExistMetadata);
        );
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();  
                when(blobContainer.readBlob(fileName)).thenAnswer((invocation) -> {
            .routingTableVersion(1)
            () -> remoteClusterStateService.writeIncrementalMetadata(previousClusterState, clusterState, null)
        assertEquals(indexMetadataMap.get(index.getName()).getNumberOfReplicas(), indexMetadata.getNumberOfReplicas());
        remoteClusterStateService.start();  
        mockBlobContainerForGlobalMetadata(blobContainer2, clusterManifest2, metadata2);
        assertThat(manifest.getIndices().size(), is(1));
    private static final String CLUSTER_BLOCKS_FILENAME = "cluster-blocks-file__1";
            .getClusterMetadataManifest();  
            .numberOfReplicas(0)
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder().indices(Collections.emptyList()).build();
            "test-node-id",  
                Metadata.builder(initialClusterState.getMetadata())
            .clusterUUID("cluster-uuid")
        assertEquals(1, remoteClusterStateService.getRemoteStateStats().getStateDiffDownloadValidationFailed());
        final ClusterState initialClusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
            DiscoveryNode node = new DiscoveryNode("node_id", buildNewFakeTransportAddress(), Version.CURRENT);  
    public void testGetClusterStateForManifestWithChecksumValidationEnabledWithNullChecksum() throws IOException {
        remoteClusterStateService.start();  
        assertThat(manifest.getTransientSettingsMetadata(), nullValue());
                any(),  
            1
        assertThat(manifest.getRoutingTableVersion(), is(expectedManifest.getRoutingTableVersion()));  
        final UploadedIndexMetadata uploadedIndiceRoutingMetadata = new UploadedIndexMetadata(
        Map<String, IndexMetadata> indexMetadataMap3 = differGlobalMetadata  
            Locale.getDefault(),  
        );
        initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode.NONE);  
            .routingTableVersion(1)
                true,
        assertEquals(0, remoteClusterStateService.getFullDownloadStats().getFailedCount());
        assertThat(manifest.getRoutingTableVersion(), is(expectedManifest.getRoutingTableVersion()));
                .get()  
            .stateUUID("state-uuid")
        }
     *
            emptyList(),
import org.opensearch.cluster.node.DiscoveryNode;  
        UploadedMetadataAttribute settingsMetadata,
        assertTrue(manifest2.getCustomMetadataMap().containsKey("custom4"));
        );  
        when(blobContainer.children()).thenReturn(blobContainerMap);
                eq(true),  
            "cluster-uuid2",  
            manifestBuilder.clusterBlocksMetadata(new UploadedMetadataAttribute(CLUSTER_BLOCKS, CLUSTER_BLOCKS_FILENAME));
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");  
                    blobContainer1,  
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
        Assert.assertThat(manifestDetails, nullValue());
        Settings newSettings = Settings.builder().put("cluster.remote_store.state.read_timeout", readTimeOut + "s").build();
            .getClusterMetadataManifest();  
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
                eq(true),
        doAnswer(invocation -> {  
import org.opensearch.cluster.metadata.IndexGraveyard;
            .version(1L)  
        assertThat(manifest.getIndices().size(), is(1));
        );  
            argThat(new BlobNameMatcher(TRANSIENT_SETTINGS_FILENAME)),
        when(container.readBlob(anyString())).thenAnswer(inv -> { throw new IOException(exceptionMsg); });  
            .stateUUID("state-uuid")  
            mockBlobContainerOrderedList.addAll(
            new ClusterStateChecksum(clusterState, threadPool)
            eq(true),
                    .putCustom("custom4", new CustomMetadata1("mock_custom_metadata4"))
        });
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");  
        assertNotNull(manifest.getCustomMetadataMap());
            writableRegistry(),
                blobContainer1,  
            previousManifest
        when(blobPath.add(anyString())).thenReturn(blobPath);
            .transientSettingsMetadata(new UploadedMetadataAttribute(TRANSIENT_SETTING_METADATA, TRANSIENT_SETTINGS_FILENAME))
        assertEquals(clusterState.getRoutingTable().version(), updatedClusterState.getRoutingTable().version());  
                ChecksumWritableBlobStoreFormat<Metadata.Custom> customMetadataFormat = new ChecksumWritableBlobStoreFormat<>(
    }
    }
import static org.opensearch.gateway.remote.model.RemoteTemplatesMetadata.TEMPLATES_METADATA;
        mockBlobContainer(blobContainer2, clusterManifest2, indexMetadataMap2, MANIFEST_CURRENT_CODEC_VERSION);
        String stateUUID,  
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder().indices(Collections.emptyList()).build();  
import org.opensearch.cluster.metadata.IndexTemplateMetadata;  
    private void mockObjectsForGettingPreviousClusterUUID(  
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));
        assertThat(manifest.getIndicesRouting().get(0).getIndexUUID(), is(uploadedIndiceRoutingMetadata.getIndexUUID()));
        assertFalse(manifest1.getCustomMetadataMap().containsKey("custom4"));  
            "custom_3",  
            .build();
            new UploadedMetadataAttribute(TEMPLATES_METADATA, "key5"),
        Metadata metadata3 = Metadata.builder()  
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
            new ClusterStateChecksum(clusterState, threadPool)
                "custom_2",
                Mockito.any(StringKeyDiffProvider.class)  
                                    .settings(
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
        );
                anyBoolean(),
                    "custom_md_2",
            .readAsync(eq(DISCOVERY_NODES), argThat(new BlobNameMatcher(DISCOVERY_NODES_FILENAME)), any());
            eq(emptyList()),
    public void testRemoteStateUploadStats() throws IOException {
                    (out, nodes) -> nodes.writeToWithAttribute(out),
    public void testGetValidPreviousClusterUUIDWhenLastUUIDUncommitted() throws IOException {
            .blocks(clusterBlocks)  
            List.of(
            .indices(List.of(uploadedIndexMetadata))  
                );
            .numberOfShards(1)
        when(blobContainer2.path()).thenReturn(blobPath);  
            customsToRemove.forEach(mb::removeCustom);  
        final DiffableStringMap hashesOfConsistentSettings = new DiffableStringMap(emptyMap());
        remoteClusterStateService.setRemoteClusterStateAttributesManager(mockedClusterStateAttributeManager);
import org.mockito.ArgumentMatchers;  
            .persistentSettings(Settings.builder().put("readonly", true).build())
import static org.opensearch.gateway.remote.model.RemoteCoordinationMetadata.COORDINATION_METADATA_FORMAT;
        verifyCodecMigrationManifest(ClusterMetadataManifest.CODEC_V0);
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));
        assertThat(manifest.getIndicesRouting().get(0).getIndexName(), is(uploadedIndiceRoutingMetadata.getIndexName()));  
            "cluster-uuid1",
            .clusterUUID("cluster-uuid")
        ClusterState clusterState = generateClusterStateWithAllAttributes().build();
            return null;
        Map<String, IndexMetadata> indexMetadataMap = remoteClusterStateService.getLatestClusterState(
                true,  
                eq(manifest.getClusterStateCustomMap()),  
}
            .indicesRouting(List.of(uploadedIndiceRoutingMetadata))
        BlobContainer blobContainer = mockBlobStoreObjects();  
                previousClusterState,
            .metadata(  
        assertEquals(0, remoteClusterStateService.getRemoteStateStats().getStateFullDownloadValidationFailed());  
import static org.mockito.ArgumentMatchers.anyList;
        assertThat(manifest.getStateUUID(), is(expectedManifest.getStateUUID()));
        ClusterState updatedClusterState = remoteClusterStateService.readClusterStateInParallel(
            public String next() {  
            "cluster-uuid2",
import java.util.Locale;
                anyBoolean(),  
            verify(mockGlobalMetadataManager, times(1)).readAsync(  
            diffManifest.isTemplatesMetadataUpdated(),  
        );
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();  
        ClusterState clusterState = generateClusterStateWithAllAttributes().build();
            "cluster-uuid2",  
            clusterState.getClusterName().value(),
            .globalMetadataFileName("global-metadata-file")
                IndexMetadata indexMetadata = indexMetadataMap.get(uploadedIndexMetadata.getIndexUUID());  
        mockBlobContainer(mockBlobStoreObjects(), expectedManifest, Map.of(index.getUUID(), indexMetadata), CODEC_V2);  
            assertEquals(initialMetadata.getIndices().size() + 1, metadataAfterUpdate.getIndices().size());  
                    .equalsIgnoreCase(initialMetadata.getTemplatesMetadata().getUploadedFilename())
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));  
                clusterState.metadata().clusterUUID()
            .codecVersion(CODEC_V2)
                    new UploadedMetadataAttribute("custom_md_1", "test-custom1-file__1"),  
            mb.templates(templatesMetadata);
        final TemplatesMetadata templatesMetadata = TemplatesMetadata.builder()
            .build();
        assertThat(manifest.getClusterStateCustomMap().size(), is(1));
            .indicesRouting(List.of(uploadedIndiceRoutingMetadata))
        AsyncMultiStreamBlobContainer container = (AsyncMultiStreamBlobContainer) mockBlobStoreObjects(AsyncMultiStreamBlobContainer.class);  
            );
        // TODO Add test with publication flag enabled  
                eq(emptyMap()),
        );
import java.util.Map;
            threadPool,
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));
            .routingTableVersion(1)
            mb.persistentSettings(persistentSettings);
        verifyCodecMigrationManifest(CODEC_V1);  
                when(blobContainer.readBlob(getFormattedIndexFileName(fileName))).thenAnswer((invocationOnMock) -> {  
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();  
import static org.mockito.ArgumentMatchers.anyString;
                eq(true),
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
                )  
            "test-node-id",
        public boolean matches(AbstractClusterMetadataWriteableBlobEntity argument) {
                true
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename__2");
        assertThat(manifest.getIndicesRouting().get(0).getIndexUUID(), is(uploadedIndiceRoutingMetadata.getIndexUUID()));
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(1L).build();  
        assertEquals(updatedClusterStateCustom3, updatedClusterState.custom("custom_3"));  
            .build();
            .codecVersion(CODEC_V2)
            .build();
        final Settings idxSettings = Settings.builder()
        );
    }  
            clusterState,
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeFullMetadata(clusterState, "prev-cluster-uuid")
        remoteClusterStateService.start();
            .put("cluster.remote_store.state.global_metadata.upload_timeout", writeTimeout + "s")
                    hashesOfConsistentSettings,
                    new UploadedMetadataAttribute("custom_2", "test-cluster-state-custom2-file__1")
        initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode.FAILURE);
                                    .build()  
        assertEquals(indexMetadataMap.size(), 1);
                eq(manifest),
                        blobStoreRepository.getCompressor(),  
        );
        remoteClusterStateService.start();
                Metadata.builder(initialClusterState.metadata())
        ).getClusterMetadataManifest();  
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");
                    )  
        String manifestFileName = codecVersion >= CODEC_V1
        RemoteIndexMetadataManager mockedIndexManager = mock(RemoteIndexMetadataManager.class);
            true,
                        .settings(Settings.builder().put("random_index_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5)).build())
        doAnswer((i) -> {
            latchedActionListener.onResponse(new RemoteReadResult(updatedTemplateMetadata, TEMPLATES_METADATA, TEMPLATES_METADATA));  
import org.opensearch.common.blobstore.BlobContainer;  
            assertEquals(capturedWriteContext.get("metadata").getExpectedChecksum(), null);
            manifestBuilder.indices(  
        clusterSettings.applySettings(newSettings);  
    public void testMigrationFromCodecV1ManifestToCodecV2Manifest() throws IOException {
        assertThat(manifest.getIndicesRouting().get(0).getUploadedFilename(), notNullValue());
            mockManifestFileName,
            );  
                        fileName,
            // remove index metadata
                    .putCustom("custom1", new CustomMetadata1("mock_custom_metadata1"))
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));  
        RemoteClusterStateService mockService = spy(remoteClusterStateService);
            .previousClusterUUID("prev-cluster-uuid")
        ClusterMetadataManifest clusterMetadataManifest,
import org.junit.Before;
    public void testRemoteRoutingTableInitializedWhenEnabled() {
            .numberOfShards(1)  
                eq(manifest.getClusterUUID()),
                eq(NODE_ID),
                );
import java.util.stream.IntStream;
            );
        initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode.FAILURE);
        when(repositoriesService.repository("routing_repository")).thenReturn(blobStoreRepository);  
            "cluster-uuid2",  
        remoteClusterStateService.start();
            diffManifestBuilder.settingsMetadataUpdated(true);  
            "test-index",
        int primaryShards,
                eq(true),
                false
        when(blobPath.buildAsString()).thenReturn("/blob/path/");  
            return null;
            .stateUUID("state-uuid")
                    .templates(templatesMetadata)
        });  
        );
            .clusterStateCustomMetadataMap(
                eq(true),
            );
                eq(false),  
        List<NamedWriteableRegistry.Entry> writeableEntries = ClusterModule.getNamedWriteables();
            any(ClusterState.class),  
            true
        Settings updatedTransientSettings = Settings.builder()  
            .put("cluster.remote_store.state.metadata_manifest.upload_timeout", metadataManifestUploadTimeout + "s")
    public void testReadLatestMetadataManifestFailedManifestFileRemoveAfterFetchInRemote() throws IOException {  
            "index-uuid",
            previousClusterState,
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));
                true,
                any(),
                    BytesReference bytesReference = customMetadataFormat.serialize(
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename");
        final CustomMetadata1 customMetadata1 = new CustomMetadata1("custom-metadata-1");
            eq(false),
        // Updating the voting config, as updating the term will upload the full cluster state and other files will also get updated  
import org.opensearch.repositories.RepositoryMissingException;
    static ClusterMetadataManifest.Builder generateClusterMetadataManifestWithAllAttributes() {
                    .putCustom(customMetadata1.getWriteableName(), customMetadata1)  
                manifest,
            any(ClusterState.class),
        uploadedIndexMetadataList.addAll(newIndicesToRead);  
        // if set true, only Metadata will differ b/w cluster uuid1 and cluster uuid3.  
                assertEquals(metadataAfterUpdate.getIndices().get(i).getIndexName(), initialMetadata.getIndices().get(i).getIndexName());  
            return null;  
            @Override
        mockService.getClusterStateUsingDiff(manifest, clusterState, NODE_ID);
                any()
    static ClusterState.Builder generateClusterStateWithOneIndex() {
            .put(  
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
            clusterState,
        Index index2 = new Index("test-index-2", "index-uuid-2");  
                true,
                true,
    }  
        assertEquals(12, writeContextArgumentCaptor.getAllValues().size());
            eq(false)  
                anyBoolean(),
            .nodeId("nodeA")
        );
        assertThat(manifest.getTemplatesMetadata(), notNullValue());
            .templatesMetadata(templatesMetadata)  
            eq(NODE_ID),
            .previousClusterUUID("prev-cluster-uuid")
            eq(false)
        assertEquals(updatedDiscoveryNodes.getSize(), updatedClusterState.getNodes().getSize());
                eq(emptyList()),
            .clusterTerm(1L)
            .build();  
        RemoteClusterStateService spiedService = spy(remoteClusterStateService);  
            manifestBuilder.customMetadataMap(
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().build();  
            clusterState1,
        remoteClusterStateService.start();
            });
        repositoriesService = mock(RepositoriesService.class);
        final List<UploadedIndexMetadata> indices = List.of(uploadedIndexMetadata);
            .put(IndexMetadata.SETTING_INDEX_UUID, index2.getUUID())
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
            .writeMetadataInParallel(
                assertNotEquals(metadataAfterUpdate.getCustomMetadataMap(), initialMetadata.getCustomMetadataMap());
                            .addVotingConfigExclusion(new CoordinationMetadata.VotingConfigExclusion("excludedNodeId", "excludedNodeName"))
        CheckedRunnable<IOException> mockRunnable = mock(CheckedRunnable.class);
                eq(manifest.getClusterUUID()),  
    private void initializeWithChecksumEnabled(RemoteClusterStateService.RemoteClusterStateValidationMode mode) {
    @Before
        }).when(container).asyncBlobUpload(writeContextArgumentCaptor.capture(), actionListenerArgumentCaptor.capture());  
        );
        RemoteClusterStateService spiedService = spy(remoteClusterStateService);
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
            .getClusterMetadataManifest();  
                Arrays.asList(
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
        verify(mockService, times(1)).validateClusterStateFromChecksum(manifest, clusterState, ClusterName.DEFAULT.value(), NODE_ID, true);
                true,
        assertEquals(0, remoteClusterStateService.getRemoteStateStats().getStateDiffDownloadValidationFailed());
                );  
            .indicesRouting(List.of(uploadedIndiceRoutingMetadata))  
import org.opensearch.cluster.service.ClusterService;  
                eq(emptyMap()),
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(1L).build();
        doAnswer(invocationOnMock -> {
                anyMap(),
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(1L).build();
                    .putCustom("custom3", new CustomMetadata1("mock_custom_metadata3"))  
            .indices(List.of(uploadedIndexMetadata))
            .indicesRouting(List.of(uploadedIndiceRoutingMetadata))
            });
        );
            ClusterState.Custom originalClusterStateCustom = clusterState.customs().get(clusterStateCustomName);
            spiedService.writeMetadataInParallel(
        assertThat(manifest.getHashesOfConsistentSettings(), nullValue());
            .build();
        final TestClusterStateCustom2 custom2 = new RemoteClusterStateTestUtils.TestClusterStateCustom2("custom-2");
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
                true,
                clusterState.getCustoms(),
        assertThat(manifest.getDiffManifest().getIndicesRoutingDiffPath(), notNullValue());  
            .indices(uploadedIndexMetadata)  
        doReturn(clusterStateWrong).when(mockService)  
        when(blobContainer.path()).thenReturn(blobPath);  
            .stateVersion(1L)  
            clusterState,
        RemoteStateTransferException exception = expectThrows(  
            });
            return null;
            .build();
            settings,  
        assertEquals(clusterState.metadata().transientSettings(), updatedClusterState.metadata().transientSettings());  
            .metadata(
    private void mockBlobContainerForClusterUUIDs(BlobContainer blobContainer, Set<String> clusterUUIDs) throws IOException {  
        Map<String, String> clusterUUIDsPointers = Map.of(
            .indices(uploadedIndexMetadataList)  
            .metadata(Metadata.builder(clusterState1.getMetadata()).put(indexMetadata1, true).build())  
            eq(manifest),
            latchCapture.getValue().onResponse(mockResult);  
            () -> 0L,
    public void testGetClusterStateUsingDiffWithChecksumModeDebugMismatch() throws IOException {
        final UploadedIndexMetadata uploadedIndexMetadata = new UploadedIndexMetadata("test-index", "index-uuid", "metadata-filename__2");
            .clusterUUID(previousClusterState.getMetadata().clusterUUID())
        doAnswer(invocationOnMock -> {
                eq(emptyList()),
        verify(mockService, times(0)).validateClusterStateFromChecksum(any(), any(), anyString(), anyString(), anyBoolean());
        );
        final BlobPath blobPath = mock(BlobPath.class);  
            "remote_store_repository"
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();
        clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            .getClusterMetadataManifest();  
    public void testCustomMetadataDeletedUpdatedAndAdded() throws IOException {  
            "cluster-uuid5",
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
import static org.mockito.Mockito.verify;
            false,
        doAnswer(invocation -> {
        String clusterStateCustomFilename = "test-cluster-state-custom3-file__1";
    }
                eq(clusterState.metadata().customs()),  
        }).when(container).asyncBlobUpload(any(WriteContext.class), actionListenerArgumentCaptor.capture());
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
                    return new ByteArrayInputStream(bytesGlobalMetadata.streamInput().readAllBytes());
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder().indices(indices).build();
        final Settings clusterSettings = Settings.builder().put("cluster.blocks.read_only", true).build();
            .build();
    private void initializeRoutingTable() {
                "custom_md_1",  
        );  
            .clusterUUID("cluster-uuid")
            clusterService,
            .build();
    }  
        final Settings transientSettings = Settings.builder().put("mock-transient-settings", true).build();  
        remoteClusterStateService.setRemoteClusterStateAttributesManager(mockedClusterStateAttributeManager);  
        assertEquals(exceptionMsg, exception.getSuppressed()[0].getCause().getMessage());
                                        Settings.builder()
    public void testReadLatestClusterStateFromCache() throws IOException {  
    public void testGetClusterStateUsingDiff_NoDiff() throws IOException {
                    compressor  
                    .put(indexMetadata, true)  
                anyBoolean(),
        assertThat(manifest.getRoutingTableVersion(), is(expectedManifest.getRoutingTableVersion()));
            .put(
        assertThat(manifest.getClusterUUID(), is(expectedManifest.getClusterUUID()));
            });
            eq(ClusterName.DEFAULT.value()),
            return null;  
        mockBlobStoreObjects();  
                )
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()  
                eq(false),
    ) throws IOException {
        assertThat(manifest.getIndices().get(0).getIndexName(), is(uploadedIndexMetadata.getIndexName()));  
        ).getClusterMetadataManifest();  
    }
    }
        assertTrue(Metadata.isGlobalStateEquals(newClusterState.getMetadata(), expectedMetadata));
            .numberOfShards(1)
                        indexMetadata,
        int replicaShards,  
        remoteClusterStateService.start();
            DiffableStringMap hashesOfConsistentSettings = new DiffableStringMap(Map.of("secure_setting_key", "secure_setting_value"));
        ClusterState clusterStateWrong = ClusterState.builder(clusterState).routingTable(RoutingTable.EMPTY_ROUTING_TABLE).build();
            eq(NODE_ID),
            when(blobContainer.readBlob("custom-md2-file__1")).thenAnswer(i -> {
                eq(true),  
            .build();  
            Metadata.Custom originalCustomMetadata = clusterState.metadata().custom(customMetadataName);  
        RemoteClusterStateAttributesManager mockedClusterStateAttributeManager = mock(RemoteClusterStateAttributesManager.class);
    }  
        final ClusterMetadataManifest manifest = remoteClusterStateService.writeFullMetadata(clusterState, "prev-cluster-uuid")  
        BiConsumer<ClusterMetadataManifest, ClusterMetadataManifest> assertions
            try {  
import static org.hamcrest.Matchers.not;  
                    compressor,  
        );  
    }
            eq(ClusterName.DEFAULT.value()),
        );  
                    RemoteClusterStateService.RemoteClusterStateValidationMode.TRACE  
            )
                    settingsFileName,
            remoteClusterStateService.getLatestClusterState(  
    }  
                    newClusterBlock,
        );
            eq(manifest),
            .transientSettingsMetadata(new UploadedMetadataAttribute(TRANSIENT_SETTING_METADATA, TRANSIENT_SETTINGS_FILENAME))  
        ClusterState clusterState1 = ClusterState.builder(initialClusterState)
            previousManifest  
                );
            "index-uuid",
        remoteClusterStateService = new RemoteClusterStateService(
            true,
        final ClusterState previousClusterState = ClusterState.builder(ClusterName.DEFAULT)  
    }  
                    )  
            .numberOfReplicas(1)  
        final List<UploadedIndexMetadata> indices = List.of(uploadedIndexMetadata);
                any(),
        }).when(container).asyncBlobUpload(writeContextArgumentCaptor.capture(), actionListenerArgumentCaptor.capture());  
        List<UploadedIndexMetadata> uploadedIndexMetadataList1 = List.of(
        final RemoteClusterStateService rcssSpy = Mockito.spy(remoteClusterStateService);
                anyBoolean(),
            .build();  
                BytesReference bytesReference = COORDINATION_METADATA_FORMAT.serialize(  
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));  
            .build();
            }
                "test-node-id",
    private void verifyCodecMigrationManifest(int previousCodec) throws IOException {  
            "index-uuid",
                eq(manifest.getClusterStateCustomMap()),
            IntStream.range(0, initialMetadata.getIndices().size()).forEach(i -> {
        );
        final BlobPath blobPath = mock(BlobPath.class);
            clusterMetadataManifest,  
        );  
            mb.transientSettings(transientSettings);
            manifestBuilder.settingMetadata(new UploadedMetadataAttribute(SETTING_METADATA, PERSISTENT_SETTINGS_FILENAME));
            .stateVersion(1L)
        uploadedCustomMetadataMap.keySet().forEach(key -> assertTrue(updatedClusterState.metadata().customs().containsKey(key)));  
        }).when(mockedClusterStateAttributeManager)
                );  
        List<UploadedIndexMetadata> indices = new ArrayList<>();  
        assertThat(manifest.getStateVersion(), is(expectedManifest.getStateVersion()));
        mockBlobStoreObjects();
    }
            listenerArgumentCaptor.getValue().onResponse(mockedResult);
        when(blobContainer.readBlob("manifestFileName")).thenThrow(FileNotFoundException.class);
            latchedActionListener.onResponse(new RemoteReadResult(updatedPersistentSettings, SETTING_METADATA, SETTING_METADATA));
        });  
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_PUBLICATION_SETTING_KEY;
            "cluster-uuid2",
            .settingMetadata(new ClusterMetadataManifest.UploadedMetadataAttribute(SETTING_METADATA, "mock-setting-file"))
            )
                    compressor,
                anyBoolean(),
        ClusterState clusterState = generateClusterStateWithAllAttributes().build();
            .numberOfShards(1)
            .build();
    }
                    blobStoreRepository.getCompressor(),
        }  
            "cluster-uuid1",
        assertEquals(1, remoteClusterStateService.getFullDownloadStats().getSuccessCount());
            () -> remoteClusterStateService.getLatestClusterState(
                eq(true),
            .persistentSettings(Settings.builder().put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), true).build())
                .term(clusterState.metadata().coordinationMetadata().term() + 1)
import org.opensearch.threadpool.TestThreadPool;
        String initialIndex = "test-index";
                eq(emptyList()),  
                "custom_1",  
            NODE_ID,  
        assertEquals(expectedManifest.getStateVersion(), manifest.getStateVersion());
    private BlobContainer mockBlobStoreObjects(Class<? extends BlobContainer> blobContainerClazz) {
                    .putCustom("custom_metadata_type", new CustomMetadata1("mock_custom_metadata"))
            .metadata(Metadata.builder().coordinationMetadata(coordinationMetadata))
        });
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));  
        diffManifest.getIndicesDeleted()
            .build();  
        byte[] writtenBytes = capturedWriteContext.get("metadata")  
            when(blobContainer.readBlob(TRANSIENT_SETTINGS_FILENAME)).thenAnswer(i -> {
        remoteClusterStateService.start();  
            .getClusterMetadataManifest();
    public void testFailInitializationWhenRemoteStateDisabled() {
        long term,
                    .equalsIgnoreCase(initialMetadata.getCoordinationMetadata().getUploadedFilename())
import static org.opensearch.gateway.remote.model.RemoteClusterStateCustoms.CLUSTER_STATE_CUSTOM;  
        );
                assertEquals(
        clusterSettings.applySettings(newSettings);  
                true,
        final ClusterState clusterState = generateClusterStateWithOneIndex().nodes(nodesWithLocalNodeClusterManager()).build();  
                manifest.getClusterUUID(),  
        final TemplatesMetadata templatesMetadata = TemplatesMetadata.builder()
                eq(manifest.getCustomMetadataMap()),  
            )  
            customMetadataMap,
            RemoteStateTransferException.class,  
        });
                (invocationOnMock) -> {
import static org.mockito.ArgumentMatchers.anyBoolean;
            return null;
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.CUSTOM_DELIMITER;  
        String previousClusterUUID = remoteClusterStateService.getLastKnownUUIDFromRemote("test-cluster");  
        );  
            .build();
            .build();  
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder().term(1L).build();  
            .build();
            .clusterUUID("cluster-uuid")
            clusterState.getClusterName().value(),
import org.opensearch.cluster.node.DiscoveryNodes;
        Index index1 = new Index("test-index-1", "index-uuid-1");
    }
            diffManifest.isCoordinationMetadataUpdated(),
        assertThat(manifest.getClusterStateCustomMap(), anEmptyMap());  
                blobContainer1,
                            .numberOfReplicas(0)
                .build()
    public void testGetClusterStateUsingDiffWithChecksum() throws IOException {  
            .hashesOfConsistentSettings(
            eq(true),
            assertNotEquals(originalClusterStateCustom, updateClusterStateCustom);  
        );  
        remoteClusterStateService.start();  
                    .equalsIgnoreCase(initialMetadata.getSettingsMetadata().getUploadedFilename())
        assertEquals(0, remoteClusterStateService.getRemoteStateStats().getStateFullDownloadValidationFailed());  
        if (differGlobalMetadata) {  
            eq(true),  
        // new customs uploaded  
    }
        when(mockedGlobalMetadataManager.getGlobalMetadataUploadTimeout()).thenReturn(GLOBAL_METADATA_UPLOAD_TIMEOUT_DEFAULT);  
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(index.getName()).settings(idxSettings)  
        RemoteStateTransferException exception = assertThrows(
        assertThat(manifest.getClusterBlocksMetadata(), nullValue());
        }
                    assertTrue(metadataAfterUpdate.getCustomMetadataMap().containsKey(k));
                    FORMAT_PARAMS
                settings,
        return ClusterState.builder(ClusterName.DEFAULT)  
        mockBlobStoreObjects();  
            .build();
    private static final String TEMPLATES_METADATA_FILENAME = "templates-metadata-file__1";  
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
            listenerArgumentCaptor.getValue().onResponse(mockedResult);  
                false,
                new RemoteIndexPathUploader(
        ClusterStateDiffManifest diffManifest = ClusterStateDiffManifest.builder().build();  
    public void teardown() throws Exception {
            .nodeId("nodeA")
import org.opensearch.cluster.routing.remote.InternalRemoteRoutingTableService;
        );
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder()
            diffManifest.isTransientSettingsMetadataUpdated(),
    public void testMarkLastStateAsCommittedSuccess() throws IOException {
import org.opensearch.repositories.RepositoriesService;  
    public void testReadLatestMetadataManifestFailedNoManifestFileInRemote() throws IOException {  
        );  
            ClusterState.UNKNOWN_UUID,  
                )
        RemoteIndexMetadataManager mockedIndexManager = mock(RemoteIndexMetadataManager.class);  
    }
                Metadata.builder()
            eq(manifest.getCustomMetadataMap()),  
        );  
            .clusterTerm(1L)  
        ClusterState previousClusterState = generateClusterStateWithAllAttributes().build();
    private void mockObjectsForGettingPreviousClusterUUID(
        Metadata.Builder mb = Metadata.builder(clusterState.metadata());  
            .getClusterMetadataManifest();  
                assertEquals(metadataAfterUpdate.getIndices().get(i).getIndexUUID(), initialMetadata.getIndices().get(i).getIndexUUID());
                    clusterSettings,
            .codecVersion(MANIFEST_CURRENT_CODEC_VERSION)  
            .stateVersion(1L)  
        final List<UploadedIndexMetadata> indices = List.of(uploadedIndexMetadata);  
        Metadata newMetadata = Metadata.builder(previousClusterState.metadata()).put(indexMetadata, true).build();  
        assertThat(manifest.getCustomMetadataMap().containsKey(CustomMetadata1.TYPE), is(true));  
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()
            when(blobContainer.readBlob(SETTINGS_METADATA_FORMAT.blobName(settingsFileName))).thenAnswer((invocationOnMock) -> {
            .clusterUUID("cluster-uuid")
        verify(mockService, times(1)).validateClusterStateFromChecksum(  
            .stateUUID("state-uuid")
                eq(true),
            eq(manifest.getClusterStateCustomMap()),  
        when(mockedResult.getComponent()).thenReturn(COORDINATION_METADATA);
                eq(false),
            manifest1.getIndices()
import static org.opensearch.gateway.remote.model.RemoteClusterBlocksTests.randomClusterBlocks;
    private static final String COORDINATION_METADATA_FILENAME = "coordination-metadata-file__1";  
            .clusterTerm(1L)  
     */
            Set<String> indicesToDelete = clusterState.metadata().getIndices().keySet();  
        ClusterMetadataManifest manifest = generateClusterMetadataManifestWithAllAttributes().checksum(
        when(repositoriesService.repository("remote_store_repository")).thenReturn(filterRepository);  
            .stateVersion(clusterState.version())
    public void testWriteFullMetadataSuccessWithChecksumValidationModeNone() throws IOException {
            eq(COORDINATION_METADATA),  
        assertThat(manifest.getIndices().get(0).getIndexUUID(), is(uploadedIndexMetadata.getIndexUUID()));
            .build();
                anyBoolean(),
            eq(true),  
                any(),
            .thenReturn(Arrays.asList(blobMetadata));  
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder().indices(indices).build();  
        when(mockedResult.getComponent()).thenReturn(COORDINATION_METADATA);
        assertThat(manifest.getIndices().get(0).getIndexUUID(), is(uploadedIndexMetadata.getIndexUUID()));  
            return null;  
                    blobContainer3,
                        FORMAT_PARAMS
            LatchedActionListener.class  
            assertEquals(metadataAfterUpdate.getIndices().size(), initialMetadata.getIndices().size());
        mockBlobStoreObjects();  
            .routingTableVersion(1)
        ).build();
import org.opensearch.common.blobstore.AsyncMultiStreamBlobContainer;
        assertThat(manifest.getClusterTerm(), is(expectedManifest.getClusterTerm()));  
            "test-index",
            );
                true,
        remoteClusterStateService.start();
        Map<String, UploadedMetadataAttribute> newCustomMetadataMap = Map.of(
        );
            actionListenerArgumentCaptor.getValue().onFailure(new RuntimeException("Cannot upload to remote"));
                anyBoolean(),
            any(ClusterState.class),  
        assertEquals(clusterState.metadata().getCustoms(), updatedClusterState.metadata().getCustoms());
            )
                );
            .build();
        verify(mockService, times(1)).validateClusterStateFromChecksum(
                    .clusterUUID("cluster-uuid")
                eq(true),
        when(mockedUploadedMetadata.getComponent()).thenReturn("test-component");
        List<UploadedIndexMetadata> uploadedIndexMetadataList = new ArrayList<>(
            .nodeId("nodeA")
        }).when(mockedGlobalMetadataManager).readAsync(eq("custom_md_3"), argThat(new BlobNameMatcher(customMetadataFilename)), any());
                eq(manifest.getIndicesRouting()),
            String coordinationFileName = getFileNameFromPath(clusterMetadataManifest.getCoordinationMetadata().getUploadedFilename());
        int codecVersion,  
            argThat(new BlobNameMatcher(COORDINATION_METADATA_FILENAME)),  
        final ClusterMetadataManifest expectedManifest = ClusterMetadataManifest.builder()  
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.DELIMITER;
            any()  
            .templatesMetadata(new ClusterMetadataManifest.UploadedMetadataAttribute(TEMPLATES_METADATA, "mock-templates-file"))
        assertThat(manifest.getIndicesRouting().get(0).getIndexUUID(), is(uploadedIndiceRoutingMetadata.getIndexUUID()));
        remoteClusterStateService.start();  
        remoteClusterStateService.start();
            .codecVersion(MANIFEST_CURRENT_CODEC_VERSION)
            .stateVersion(1L)
                )
        }).when(mockedGlobalMetadataManager).readAsync(any(), any(), listenerArgumentCaptor.capture());
        assertThat(manifest.getPreviousClusterUUID(), is(expectedManifest.getPreviousClusterUUID()));
        RemoteGlobalMetadataManager mockedGlobalMetadataManager = mock(RemoteGlobalMetadataManager.class);  
            any()  
            clusterState.getClusterName().value(),  
        mockService.getClusterStateUsingDiff(manifest, clusterState, NODE_ID);  
            .metadata(  
import static org.opensearch.gateway.remote.model.RemoteCustomMetadata.CUSTOM_METADATA;  
    }  
import java.util.function.Supplier;
            );  
        clusterMetadataManifest.getIndices().forEach(uploadedIndexMetadata -> {
        );
        );  
            ),  
            .clusterTerm(1L)
        }  
                // since timestamp is part of file name, if file name is same we can confirm that file is not update in global metadata
            ClusterState.UNKNOWN_UUID,
        assertThat(manifest.getCustomMetadataMap().size(), is(2));
            routingTableBuilder.addAsRecovery(indexMetadata);  
        Map<String, UploadedMetadataAttribute> uploadedCustomMetadataMap = new HashMap<>(
            return null;
            .numberOfShards(1)  
            .globalMetadataFileName(null)  
                "custom_1",
                blobContainer1,
            .readAsync(eq("test-index-1"), argThat(new BlobNameMatcher(indexFilename)), any(LatchedActionListener.class));  
        assertThat(manifest.getIndices().get(0).getIndexUUID(), is(uploadedIndexMetadata.getIndexUUID()));
                new UploadedMetadataAttribute(HASHES_OF_CONSISTENT_SETTINGS, HASHES_OF_CONSISTENT_SETTINGS_FILENAME)
    }
        }
                                    .patterns(Arrays.asList("bar-*", "foo-*"))  
            );  
                    .templates(
                anyBoolean(),  
                eq(manifest.getIndices()),
        }).when(mockedIndexManager).readAsync(any(), any(), listenerArgumentCaptor.capture());
                .stream()  
import org.opensearch.common.blobstore.stream.write.WritePriority;
            .previousClusterUUID("prev-cluster-uuid")  
        doReturn(clusterStateWrong).when(mockService)  
    }  
            IllegalStateException.class,
            .build();
            .indices(indices)
            .numberOfReplicas(1)
        Settings idxSettings1 = Settings.builder()
            );  
        mockBlobContainer(mockBlobStoreObjects(), expectedManifest, new HashMap<>(), CODEC_V2);
            .metadata(Metadata.builder().coordinationMetadata(coordinationMetadata))
            assertEquals(metadataAfterUpdate.getCustomMetadataMap(), initialMetadata.getCustomMetadataMap());  
