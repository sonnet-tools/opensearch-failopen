            logger.debug("{}; {}", clusterStateUploadTimeMessage, metadataUpdateMessage);
            customToRead,
        } catch (InterruptedException e) {
        List<Exception> exceptionList
                response.uploadedIndicesRoutingMetadata.add((UploadedIndexMetadata) uploadedMetadata);
        final String clusterName  
            clusterSettings,
                    clusterUUID,  
            clusterState,
        if (readDiscoveryNodes) {
import java.util.HashMap;  
        }  
            routingTableDiff.provideDiff()
            indicesRoutingToUpload,  
            blobStoreRepository,
        }
            repositoriesService,  
        ParameterizedMessage metadataUpdateMessage = new ParameterizedMessage(  
            );
import java.util.Objects;
            );  
        stats.setCurrentApplicationDurationMs(applicationDurationMsSupplier.getAsLong());  
                listener
                    manifest.getClusterTerm(),
            ClusterMetadataManifest currentManifest = trimmedUUIDs.get(clusterUUID);
                        );
        final Map<String, UploadedMetadataAttribute> allUploadedClusterStateCustomsMap = new HashMap<>(
                    false,
    public RemoteClusterStateManifestInfo writeIncrementalMetadata(  
    }
     * Used to specify if cluster state metadata should be published to remote store  
        int numIndicesUpdated = 0;  
                    manifest.getOpensearchVersion()
            logger.debug(  
            && Metadata.isHashesOfConsistentSettingsEqual(previousClusterState.metadata(), clusterState.metadata()) == false;  
                assert uploadedIndexMetadataOptional.isPresent() == true;
import java.util.List;
                    clusterState.metadata().transientSettings(),
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedMetadataAttribute;
        String clusterUUID,  
                logger.trace(
        );
        }
        this.slowWriteLoggingThreshold = slowWriteLoggingThreshold;
        ClusterState previousState,
                RemoteStateTransferException exception = new RemoteStateTransferException(
                Metadata.Builder mb = Metadata.builder(remoteGlobalMetadataManager.getGlobalMetadata(manifest.getClusterUUID(), manifest));
            clusterState,
import org.opensearch.common.settings.Setting;
                    manifest.getCoordinationMetadata().getUploadedFilename(),
            Map<String, UploadedMetadataAttribute> updatedClusterStateCustom = new HashMap<>();  
    }
                return stateFromCache;
            readDiscoveryNodes,  
            );
                updateCoordinationMetadata,
    /**  
        boolean uploadClusterBlock,  
                numIndicesUnchanged,
            }
        return blobStoreRepository.blobStore();
            updateSettingsMetadata,
                        break;  
    ) throws IOException {  
                includeEphemeral,  
        );
            || remoteClusterStateValidationMode.equals(RemoteClusterStateValidationMode.TRACE)) {
    public RemoteManifestManager getRemoteManifestManager() {  
        );
        }  
                    clusterState.metadata().clusterUUID(),
                    manifest.getHashesOfConsistentSettings().getUploadedFilename(),
        invokeIndexMetadataUploadListeners(indexToUpload, prevIndexMetadataByName, latch, exceptionList);
                return RemoteClusterStateValidationMode.valueOf(mode.toUpperCase(Locale.ROOT));  
                                )  
 * compatible open source license.
    private final ThreadPool threadpool;
            if (latch.await(remoteGlobalMetadataManager.getGlobalMetadataUploadTimeout().millis(), TimeUnit.MILLISECONDS) == false) {
        if (!updateClusterBlocks) {  
        boolean readDiscoveryNodes,
        boolean uploadTemplateMetadata,
            namedWriteableRegistry,
        remoteStateStats.stateFullDownloadFailed();
                            () -> new ParameterizedMessage(
            uploadedMetadataResults.uploadedHashesOfConsistentSettings = previousManifest.getHashesOfConsistentSettings();
                customComponent,  
    // ToXContent Params with gateway mode.
                : null,
    }
        );  
                customsDiff.getUpserts().size()
                        );
                ? new ClusterStateChecksum(clusterState, threadpool)  
                    break;  
                manifest.getCoordinationMetadata() != null,
                CLUSTER_STATE_CUSTOM,
    private volatile AtomicBoolean downloadFromRemoteForReadAPI;  
                        prevIndexMetadataByName.values(),
        this.remoteRoutingTableService.close();
        }
        indexToUpload.forEach(indexMetadata -> {  
            );  
                    }
import org.opensearch.cluster.block.ClusterBlocks;
            throw e;
            final long startTimeNanos = relativeTimeNanosSupplier.getAsLong();
                    clusterState.metadata().clusterUUID(),
        if (previousClusterState == null) {
        String localNodeId,
                ClusterState state = readClusterStateInParallel(
        }
            logger.debug(
                    && remoteGlobalMetadataManager.isGlobalMetadataEqual(currentManifest, previousManifest, clusterName)) {
            }  
                indexRoutingTable,
            newRoutingTable = routingTableDiff.apply(previousState.getRoutingTable());
import org.opensearch.gateway.remote.model.RemoteDiscoveryNodes;
                    updatedClusterStateCustom.put(customType, manifest.getClusterStateCustomMap().get(customType));  
     *  Debug: Validation enabled but only matches checksum and logs failing entities.  
                        break;  
            !remoteClusterStateValidationMode.equals(RemoteClusterStateValidationMode.NONE)
            );  
            true,  
        remoteClusterStateCache = new RemoteClusterStateCache();
        this.remoteClusterStateValidationMode = remoteClusterStateValidationMode;
import java.io.Closeable;
            readIndexRoutingTableDiff,
            );
        }  
        boolean readHashesOfConsistentSettings,
                diff.isSettingsMetadataUpdated(),
                ),
            + indicesRoutingToRead.size() + (readIndexRoutingTableDiff ? 1 : 0);
        this.isPublicationEnabled = new AtomicBoolean(
            updateClusterBlocks,
        RemoteDownloadStats stats = (RemoteDownloadStats) remoteStateStats.getRemoteFullDownloadStats();
                // component name for custom metadata will look like custom--<metadata-attribute>  
    public ClusterMetadataManifest getClusterMetadataManifestByFileName(String clusterUUID, String fileName) {
                    "updating metadata for [{}], changing version from [{}] to [{}]",  
            ),
        if (readTransientSettingsMetadata) {
                ? uploadedMetadataResults.uploadedIndicesRoutingDiffMetadata.getUploadedFilename()
            clusterStateCustomToRead,
            exceptionList.forEach(e::addSuppressed);
            clusterUUID,
        if (topLevelClusterUUIDs.size() > 1) {
import static org.opensearch.gateway.remote.RemoteClusterStateAttributesManager.DISCOVERY_NODES;  
                            () -> new ParameterizedMessage(  
            }
                        break;
    }  
        final Map<String, IndexMetadata> indicesToBeDeletedFromRemote = new HashMap<>(previousClusterState.metadata().indices());
                "Cluster state checksums do not match during full state read. Validation failed for " + failedValidation
            indicesRoutingToRead,
                topLevelClusterUUIDs,  
    }  
        final long durationMillis = TimeValue.nsecToMSec(relativeTimeNanosSupplier.getAsLong() - startTimeNanos);
        }  
            uploadTasks.add(SETTING_METADATA);
                        );
                ),
                )
                        discoveryNodesBuilder.set(DiscoveryNodes.builder((DiscoveryNodes) remoteReadResult.getObj()));  
                    emptyList(),
                }
        final boolean updateHashesOfConsistentSettings = isPublicationEnabled.get()
        String clusterUUID,
import org.opensearch.gateway.remote.model.RemoteTemplatesMetadata;  
    /**
                new RemoteCoordinationMetadata(  
            blobStoreTransferService,  
        }  
            return null;
                SETTING_METADATA,  
                                    clusterState.customs(),
                response.uploadedIndicesRoutingDiffMetadata = (UploadedMetadataAttribute) uploadedMetadata;
    BlobStore getBlobStore() {
                clusterName
            updateCoordinationMetadata,
            String customComponent = String.join(CUSTOM_DELIMITER, CUSTOM_METADATA, key);  
                        metadataBuilder.remove(index);
                    clusterState.metadata().clusterUUID(),  
            logger.info("Top level cluster UUIDs: {}", topLevelClusterUUIDs);  
import org.opensearch.cluster.coordination.PersistedStateStats;  
import org.opensearch.cluster.DiffableUtils;  
                Version.CURRENT,  
                        // component name for mat is "cluster-state-custom--custom_name"
            blobStoreRepository,  
                        diff.getIndicesRoutingUpdated(),
                response.uploadedTransientSettingsMetadata = (UploadedMetadataAttribute) uploadedMetadata;  
                            )  
                        new ParameterizedMessage(
        }
        final DiffableUtils.MapDiff<String, Metadata.Custom, Map<String, Metadata.Custom>> customsDiff = remoteGlobalMetadataManager  
                updatedIndices,
                readIndexRoutingTableDiffResults.set(response);
                            () -> new ParameterizedMessage(
        return this.remoteRoutingTableService;
            MANIFEST_CURRENT_CODEC_VERSION,
    // package private for testing
        remoteGlobalMetadataManager = new RemoteGlobalMetadataManager(
                    false,
        }
    private volatile TimeValue slowWriteLoggingThreshold;
                clusterUUID,  
            previousManifest.getClusterStateCustomMap()  
                durationMillis,
                diff.isClusterBlocksUpdated(),
                RemoteClusterBlocks.CLUSTER_BLOCKS,  
        this.remoteIndexMetadataManager = remoteIndexMetadataManager;
        return this.downloadFromRemoteForReadAPI.get();  
        ClusterStateDiffManifest clusterStateDiffManifest = new ClusterStateDiffManifest(
            }
                diff.isHashesOfConsistentSettingsUpdated(),
        if (uploadTransientSettingMetadata) {
            uploadTasks.add(customComponent);
                new RemoteTransientSettingsMetadata(  
import static org.opensearch.gateway.remote.model.RemoteCustomMetadata.CUSTOM_DELIMITER;  
                Optional<UploadedIndexMetadata> uploadedIndexMetadataOptional = manifest.getIndices()
            return clusterState;
            clusterUUID  
                case CUSTOM_METADATA:
            remoteIndexMetadataManager.readAsync(
            false
                .build();
        return stats;
                }  
    private final String remotePathPrefix;
                },  
            );
            // download full cluster state and match against state created for the failing entities  
                // pass component name as cluster-state-custom--<custom_name>, so that we can interpret it later  
    ) {
import org.opensearch.common.Nullable;
            .collect(Collectors.toList());  
                        logger.error(() -> new ParameterizedMessage("Unknown failed entity {}", failedEntity));
                    validateClusterStateFromChecksum(manifest, clusterState, clusterName, localNodeId, true);
    public ClusterState getClusterStateUsingDiff(ClusterMetadataManifest manifest, ClusterState previousState, String localNodeId) {
        }
     */
            exceptionList.forEach(exception::addSuppressed);  
                manifest.getClusterUUID(),
                    value,
     * manifest. The new manifest file is created by using the unchanged metadata from the previous manifest and the new metadata changes from the current
                );
    public void diffIncomingPublicationFailed() {
                COORDINATION_METADATA,
            if (!ClusterState.UNKNOWN_UUID.equals(currentManifest.getPreviousClusterUUID())) {
                    if (diff.getCustomMetadataDeleted() != null) {
                for (String customType : diff.getClusterStateCustomUpdated()) {
    public static final String REMOTE_PUBLICATION_SETTING_KEY = "cluster.remote_store.publication.enabled";  
        }), latch);
        boolean readTemplatesMetadata,
                ),
            clusterName,  
            return clusterState;  
            previousManifest,
                TRANSIENT_SETTING_METADATA,
                        String.join(", ", uploadTasks)
    }  
import static org.opensearch.gateway.remote.model.RemoteTransientSettingsMetadata.TRANSIENT_SETTING_METADATA;
     *  None: Validation will be disabled.
                    blobStoreRepository.getNamedXContentRegistry()
                ),
            // update the coordination metadata if voting config is committed
        return remoteManifestManager;
    private final String nodeId;  
                        logger.error(
import org.opensearch.cluster.metadata.DiffableStringMap;
    /**  
                        );
        } else {
            + (readTransientSettingsMetadata ? 1 : 0) + (readHashesOfConsistentSettings ? 1 : 0) + clusterStateCustomToRead.size()
            ClusterStateDiffManifest diff = manifest.getDiffManifest();  
    }  
        return clusterStateBuilder.build();
                    clusterState.metadata().clusterUUID(),
     * @param clusterUUID uuid of cluster state to refer to in remote
        }  
        logger.trace("WRITING INCREMENTAL STATE");
                new RemoteDiscoveryNodes(
    public boolean isRemotePublicationEnabled() {
    }  
            .routingTable(newRoutingTable)
        int totalReadTasks = indicesToRead.size() + customToRead.size() + (readCoordinationMetadata ? 1 : 0) + (readSettingsMetadata
import static org.opensearch.gateway.remote.model.RemotePersistentSettingsMetadata.SETTING_METADATA;  
                listener
            previousManifest.getSettingsMetadata(),
            }  
        this.nodeId = nodeId;  
                    if (includeEphemeral || (!includeEphemeral && metadataCustom.context().contains(XContentContext.GATEWAY))) {  
                e
    }
                    emptyMap(),  
                );  
        CountDownLatch latch = new CountDownLatch(totalReadTasks);  
            readTransientSettingsMetadata,
                                )  
        final List<String> validChain = new ArrayList<>();  
        }
    }  
                    clusterState.metadata().templatesMetadata(),
                updatedClusterStateCustom,
        long term,
                HASHES_OF_CONSISTENT_SETTINGS,
import java.util.function.LongSupplier;
        boolean readClusterBlocks,
            listener.onUpload(
                ),
    ThreadPool getThreadpool() {
    public RemoteClusterStateManifestInfo markLastStateAsCommitted(  
     * @return {@link IndexMetadata}
            routingTableDiff,
        boolean readTransientSettingsMetadata,  
        return remoteManifestManager.getClusterMetadataManifestByTermVersion(clusterName, clusterUUID, term, version);
        }, ex -> {
        String localNodeId,
                        + "]"
            );  
     * Invokes the index metadata upload listener but does not wait for the execution to complete.
        boolean readCoordinationMetadata,
                    manifest,
                                DiffableUtils.diff(
        if (first.getIndices().size() != second.getIndices().size()) {  
                    blobStoreRepository.getNamedXContentRegistry()  
                }
        );  
    ) {  
            + (uploadCoordinationMetadata ? 1 : 0) + (uploadSettingsMetadata ? 1 : 0) + (uploadTemplateMetadata ? 1 : 0)  
            remoteClusterStateAttributesManager.writeAsync(
                    case ClusterStateChecksum.CUSTOMS_CS:  
                listener  
    public static final Setting<Boolean> REMOTE_CLUSTER_STATE_ENABLED_SETTING = Setting.boolSetting(
            readHashesOfConsistentSettings,  
                clusterState.metadata().clusterUUID(),
    public Optional<ClusterMetadataManifest> getLatestClusterMetadataManifest(String clusterName, String clusterUUID) {  
                    // for manifest codec V1, we don't have the following objects to read, so not passing anything
    ) throws IOException {
                    .findFirst();
            .collect(Collectors.toMap(UploadedIndexMetadata::getIndexName, Function.identity()));
        List<IndexMetadata> newIndexMetadataList,  
                            () -> new ParameterizedMessage(
        String currentUUID = topLevelClusterUUIDs.get(0);
                response.uploadedTemplatesMetadata = (UploadedMetadataAttribute) uploadedMetadata;
    }  
import org.opensearch.common.blobstore.BlobContainer;
                ignored -> logger.trace(  
import org.opensearch.cluster.metadata.Metadata.XContentContext;
            readCoordinationMetadata,
     * Validation mode for cluster state checksum.
                diff.isDiscoveryNodesUpdated(),
                    new UploadedMetadataAttribute(custom, uploadedMetadata.getUploadedFilename())
                    indexMetadata.getIndex(),
            exceptionList.forEach(exception::addSuppressed);  
import java.util.Arrays;
 *
        int totalUploadTasks = indexToUpload.size() + indexMetadataUploadListeners.size() + customToUpload.size()
        Setting.Property.NodeScope
                return false;
            threadpool
            this.isPublicationEnabled.set(isRemoteStoreClusterStateEnabled(settings) && isRemoteRoutingTableConfigured(settings));  
            true,
            clusterSettings,
            latch
     */
        this.repositoriesService = repositoriesService;
        }
                ),
            throw exception;
        boolean includeEphemeral
                            "listener={} : Exception during invocation with indexMetadataList={} prevIndexMetadataList={} tookTimeNs={}",  
        CountDownLatch latch,  
import java.util.Set;  
            if (diff.getCustomMetadataUpdated() != null) {
            uploadTasks.add(DISCOVERY_NODES);  
            if (secondUploadedIndexMetadata == null) {  
                emptyMap(),
            if (uploadedMetadata.getClass().equals(UploadedIndexMetadata.class)  
                response.uploadedClusterStateCustomMetadataMap.put(
                logger.debug(
            previousManifest.getCustomMetadataMap(),  
            currentUUID = clusterUUIDGraph.get(currentUUID);
        Map<String, Metadata.Custom> customToUpload,
            previousManifest.getTransientSettingsMetadata(),
        final Map<String, UploadedMetadataAttribute> allUploadedCustomMap = new HashMap<>(previousManifest.getCustomMetadataMap());
                    Metadata.Custom metadataCustom = (Metadata.Custom) remoteReadResult.getObj();
        );
    public void diffDownloadFailed() {
        while (currentUUID != null && !ClusterState.UNKNOWN_UUID.equals(currentUUID)) {
    void setRemoteGlobalMetadataManager(RemoteGlobalMetadataManager remoteGlobalMetadataManager) {
        final long startTimeNanos = relativeTimeNanosSupplier.getAsLong();
                    manifest.getIndices(),
        boolean readDiscoveryNodes,  
        remoteClusterStateCleanupManager.start();  
                "Cluster state checksums do not match during diff read. Validation failed for " + failedValidation  
import static org.opensearch.gateway.remote.RemoteClusterStateAttributesManager.CLUSTER_BLOCKS;
                updateTemplatesMetadata,
    private RemoteRoutingTableService remoteRoutingTableService;  
                    }
                false,
        if (uploadCoordinationMetadata) {
                                    fullClusterState.metadata().customs(),  
            if (manifest.onOrAfterCodecVersion(CODEC_V2)) {
        }  
        return remoteClusterStateCleanupManager;
        LatchedActionListener<RemoteReadResult> listener = new LatchedActionListener<>(ActionListener.wrap(response -> {
    private TimeValue remoteStateReadTimeout;
            uploadedMetadataResults.uploadedIndicesRoutingDiffMetadata != null  
                    clusterState.metadata().coordinationMetadata(),  
import org.opensearch.common.settings.Setting.Property;
    @Nullable
                getIndexMetadataUploadActionListener(updatedIndexMetadataList, prevIndexMetadataByName, latch, exceptionList, listenerName)
            durationMillis
                    } else if (remoteReadResult.getComponentName().startsWith(CLUSTER_STATE_CUSTOM)) {  
                    false,  
        FAILURE("failure"),
            }
        );  
        return remoteClusterStateCache;  
import org.opensearch.gateway.remote.model.RemoteClusterStateCustoms;  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.isRemoteClusterStateConfigured;
        );
            .map(ClusterMetadataManifest::getClusterUUID)
            );  
        ClusterState previousClusterState,
                            newIndexMetadataList,
            }),
                                "Failing Diff in cluster blocks {}",
                manifest.getHashesOfConsistentSettings() != null,  
    /**
    }
            // that means it was restored from previousUUID and no IndexMetadata update was performed on it.
                emptyList(),  
/*  
import org.opensearch.cluster.metadata.TemplatesMetadata;
        final Map<String, ClusterMetadataManifest> latestManifestsByClusterUUID,
                    blobStoreRepository.getNamedXContentRegistry()  
            blobStoreRepository,
        this.remoteStateStats = new RemotePersistenceStats();
    }  
            Map<String, ClusterMetadataManifest> latestManifests = remoteManifestManager.getLatestManifestForAllClusterUUIDs(
    public enum RemoteClusterStateValidationMode {
                localNodeId,
import org.opensearch.cluster.metadata.Metadata;  
    /**
                );
            if (firstIndexMetadata.equals(secondIndexMetadata) == false) {
            updateDiscoveryNodes,
                    key,  
    public static final Setting<RemoteClusterStateValidationMode> REMOTE_CLUSTER_STATE_CHECKSUM_VALIDATION_MODE_SETTING = new Setting<>(  
                clusterState.version(),  
                    blobStoreRepository.getCompressor()  
        Property.NodeScope,
                                DiffableUtils.diff(
    public RemoteClusterStateService(  
                emptyList(),
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.isRemoteRoutingTableConfigured;
                    clusterState.metadata().clusterUUID(),
                uploadedMetadataResults.uploadedIndicesRoutingMetadata.size()
                    || !routingTableDiff.provideDiff().getUpserts().isEmpty())) ? 1 : 0);
        List<Exception> exceptionList,  
        });
 * this file be licensed under the Apache-2.0 license or a
                : null
     */
        List<String> uploadTasks = Collections.synchronizedList(new ArrayList<>(totalUploadTasks));  
                    metadataBuilder.transientSettings((Settings) remoteReadResult.getObj());
                    clusterUUID,
            ClusterState updatedClusterState = readClusterStateInParallel(
                    clusterState.metadata().version(),
                        logger.error(
                CLUSTER_BLOCKS,
            threadpool
                    blobStoreRepository.getNamedXContentRegistry()
        LatchedActionListener<ClusterMetadataManifest.UploadedMetadata> listener = new LatchedActionListener<>(
                    )  
        Map<String, IndexMetadata> prevIndexMetadataByName = new HashMap<>();
    }  
            latch  
        if (!exceptionList.isEmpty()) {
            switch (remoteReadResult.getComponent()) {
        }
                manifest.getDiscoveryNodesMetadata() != null,  
        Consumer<Metadata.Builder> metadataTransformer,
        LatchedActionListener<Diff<RoutingTable>> routingTableDiffLatchedActionListener = new LatchedActionListener<>(
                        );  
import static org.opensearch.gateway.remote.model.RemoteCoordinationMetadata.COORDINATION_METADATA;
            } else if (RemoteRoutingTableDiff.ROUTING_TABLE_DIFF_FILE.equals(name)) {  
     * @return List of cluster UUIDs. The first element is the most recent cluster UUID in the chain  
                    clusterUUID,  
        return Collections.unmodifiableSet(clusterUUIDMetadata.keySet());
                manifestDetails.getClusterMetadataManifest().getStateVersion(),
        List<IndexMetadata> toUpload = new ArrayList<>();  
                entry.getValue().getAttributeName(),
     * invoked by the elected cluster manager when the remote cluster state is enabled.  
                )  
            remoteClusterStateCache.putState(clusterState);  
        AtomicReference<Diff<RoutingTable>> readIndexRoutingTableDiffResults = new AtomicReference<>();  
            } else if (TEMPLATES_METADATA.equals(name)) {
                    entry.getKey(),
                    .filter(idx2 -> idx2.getIndexName().equals(idx))  
        remoteClusterStateAttributesManager = new RemoteClusterStateAttributesManager(  
                // cache only if the entire cluster-state is present  
        final long startTimeNanos = relativeTimeNanosSupplier.getAsLong();  
        boolean uploadTransientSettingMetadata,
                : null,
            final long durationMillis = TimeValue.nsecToMSec(relativeTimeNanosSupplier.getAsLong() - startTimeNanos);
            previousManifest.getPreviousClusterUUID(),  
        return this.isPublicationEnabled.get();
            uploadedCoordinationMetadata,
            remoteGlobalMetadataManager.readAsync(
    }  
            .collect(Collectors.toList());  
            previousManifest.getClusterStateCustomMap()  
        for (IndexMetadataUploadListener listener : indexMetadataUploadListeners) {  
        clusterSettings.addSettingsUpdateConsumer(SLOW_WRITE_LOGGING_THRESHOLD, this::setSlowWriteLoggingThreshold);
        ClusterStateChecksum newClusterStateChecksum = new ClusterStateChecksum(clusterState, threadpool);
                        logger.error(  
            ActionListener.wrap((ClusterMetadataManifest.UploadedMetadata uploadedMetadata) -> {
                    clusterState.metadata().version(),
    public PersistedStateStats getUploadStats() {  
        return blobStoreRepository;
            ClusterState.Builder clusterStateBuilder = ClusterState.builder(updatedClusterState);
    }  
            previousClusterState,  
        }
@InternalApi
                        clusterStateBuilder.putCustom(custom, (ClusterState.Custom) remoteReadResult.getObj());  
                                fullClusterState.nodes().diff(clusterState.nodes())  
            return createClusterChain(manifestsByClusterUUIDTrimmed, clusterName);
            ActionListener.wrap(response -> {  
            () -> new ParameterizedMessage(
            }).collect(Collectors.toList());
            ActionListener.wrap(
        UploadedMetadataResults response = new UploadedMetadataResults();
                listener  
            manifestDetails.getClusterMetadataManifest().getStateVersion(),  
                response.uploadedSettingsMetadata = (UploadedMetadataAttribute) uploadedMetadata;  
        clusterStateCustomsDiff.getDeletes().forEach(allUploadedClusterStateCustomsMap::remove);
            throw ex;
            uploadedMetadataResults,
            remoteClusterStateAttributesManager.readAsync(
        NONE("none");
                            () -> new ParameterizedMessage(  
    }
     *  Trace: Matches checksum and downloads full cluster state to find diff in failing entities. Only logs failures.
            threadpool
        }  
        ParameterizedMessage clusterStateUploadTimeMessage = new ParameterizedMessage(
        );  
            clusterState,
/**
                        break;  
                manifest.getOpensearchVersion()
        final boolean updateClusterBlocks = isPublicationEnabled.get() && !clusterState.blocks().equals(previousClusterState.blocks());
                ),  
            customsDiff.getUpserts().size(),
            blobStoreTransferService,  
    }
        final List<ClusterMetadataManifest> validClusterManifests = manifestsByClusterUUID.values()  
                    metadataBuilder.hashesOfConsistentSettings((DiffableStringMap) remoteReadResult.getObj());
                false,
                        Diff<RoutingTable> routingTableDiff = fullClusterState.routingTable().diff(clusterState.routingTable());
                    remotePathPrefix
                    case ClusterStateChecksum.SETTINGS_MD_CS:
                && manifest.getClusterStateChecksum() != null) {  
    private ClusterSettings clusterSettings;
        metadataBuilder.indices(indexMetadataMap);
                ),  
            final IndexMetadata secondIndexMetadata = remoteIndexMetadataManager.getIndexMetadata(  
        Diff<RoutingTable> routingTableDiff = readIndexRoutingTableDiffResults.get();
                    clusterUUID,
            );
            );
                    String.format(
                    emptyMap(),  
        String localNodeId,
                        clusterStateBuilder.blocks((ClusterBlocks) remoteReadResult.getObj());
    /**
        remoteStateStats.stateDiffDownloadFailed();  
            } else if (RemoteClusterBlocks.CLUSTER_BLOCKS.equals(uploadedMetadata.getComponent())) {  
                    manifest.getTransientSettingsMetadata().getUploadedFilename(),  
        readResults.forEach(remoteReadResult -> {
            if (validChain.isEmpty()) {
        Map<String, IndexMetadata> prevIndexMetadataByName,
            throw new IllegalStateException(  
        }
            clusterState,  
        for (Map.Entry<String, UploadedMetadataAttribute> entry : clusterStateCustomToRead.entrySet()) {
            previousManifest.getIndicesRouting(),
            return validChain.get(0);
                clusterState,  
            readSettingsMetadata,  
    }
                                    Metadata.CUSTOM_VALUE_SERIALIZER
                new RemoteTemplatesMetadata(  
import static org.opensearch.gateway.remote.RemoteClusterStateAttributesManager.CLUSTER_STATE_ATTRIBUTE;
                prevIndexMetadataByName.put(indexName, prevIndexMetadata);
        false,
    /**
            return null;
import org.opensearch.cluster.metadata.IndexMetadata;
     *
import java.util.ArrayList;  
        }  
            CLUSTER_STATE_UPLOAD_TIME_LOG_STRING,
        Property.Dynamic
    // Package private for unit test  
                    blobStoreRepository.getCompressor(),
            );  
        Map<String, IndexRoutingTable> indicesRouting = new HashMap<>(previousState.routingTable().getIndicesRouting());
        if (!updateDiscoveryNodes) {  
        } catch (IOException e) {
                String.format(
                    )
        boolean updateSettingsMetadata = firstUploadForSplitGlobalMetadata
            );  
                    if (manifest.getCodecVersion() == CODEC_V2 || manifest.getCodecVersion() == CODEC_V3) {  
                    () -> new ParameterizedMessage(
                RemoteDiscoveryNodes.DISCOVERY_NODES,
            || Metadata.isTemplatesMetadataEqual(previousClusterState.metadata(), clusterState.metadata()) == false;  
                );  
            } else if (COORDINATION_METADATA.equals(name)) {  
        );
                        break;  
            }, ex -> {
                            )
        return remoteStateStats;  
            .stream()  
        uploadedMetadataResults.uploadedCustomMetadataMap = allUploadedCustomMap;  
        }  
        List<IndexMetadata> indexToUpload,
                (routingTable) -> {
                        }  
        indicesToBeDeletedFromRemote.keySet().forEach(allUploadedIndexMetadata::remove);  
            if (diff.getClusterStateCustomUpdated() != null) {
        Map<String, String> params = new HashMap<>(1);
            publicationEnabled ? clusterState.customs() : Collections.emptyMap(),  
            logger.info("There is no valid previous cluster UUID. All cluster UUIDs evaluated are: {}", manifestsByClusterUUID.keySet());
            nodeId,
        "cluster.remote_store.state.path.prefix",  
            blobStoreRepository,
            METADATA_UPDATE_LOG_STRING,
        if (clusterMetadataManifest.isEmpty()) {
import org.opensearch.cluster.ClusterState;
                    clusterState.blocks(),
        String clusterName = ClusterName.CLUSTER_NAME_SETTING.get(settings).value();
            }, ex -> {
                    manifest.getOpensearchVersion()
                "writing cluster state took [{}ms] which is above the warn threshold of [{}]; "
                    includeEphemeral && manifest.getHashesOfConsistentSettings() != null,
                        + "supported modes are ["  
                        logger.error(  
        }  
                    Map<String, IndexRoutingTable> indexRoutingTables = routingTable.getIndicesRouting();
                }
        boolean publicationEnabled = isPublicationEnabled.get();  
            && routingTableDiff.provideDiff() != null
        } catch (Exception e) {
            null  
                        logger.error(
                numIndicesUpdated,  
        Property.Final  
                            )
                    includeEphemeral && manifest.getDiscoveryNodesMetadata() != null,
                new RemoteClusterStateCustoms(  
                        break;  
        );  
 */  
    RemoteRoutingTableService getRemoteRoutingTableService() {
        }
        String localNodeId,
        UploadedMetadataResults uploadedMetadataResults = new UploadedMetadataResults(
        );
        });  
            routingTableDiff
            uploadedMetadataResults.uploadedCoordinationMetadata = previousManifest.getCoordinationMetadata();
        }
            List<UploadedIndexMetadata> updatedIndices = diff.getIndicesUpdated().stream().map(idx -> {  
            );
                HASHES_OF_CONSISTENT_SETTINGS,
     *  
        LongSupplier relativeTimeNanosSupplier,
            remoteGlobalMetadataManager.writeAsync(
                customsDiff.getUpserts().size()
        }  
                    false,
    ) {  
        if (!updateTemplatesMetadata) {  
                logger.debug(() -> new ParameterizedMessage("Successfully read index-routing for index {}", response.getIndex().getName()));
                    blobStoreRepository.getCompressor(),  
     * Fetch the previous cluster UUIDs from remote state store and return the most recent valid cluster UUID  
    }
                        "listener={} : Invoked successfully with indexMetadataList={} prevIndexMetadataList={} tookTimeNs={}",
                    clusterState.metadata().version(),
                            )
            null
                        logger.error(
    ClusterState readClusterStateInParallel(
        for (UploadedIndexMetadata indexMetadata : indicesToRead) {
    }  
                switch (failedEntity) {  
            validChain.add(currentUUID);  
            );
            .stateUUID(manifest.getStateUUID());  
            IOUtils.close(blobStoreRepository);  
                    blobStoreRepository.getNamedXContentRegistry()
     * @return A manifest object which contains the details of uploaded entity metadata.
        indicesRoutingToUpload.forEach(indexRoutingTable -> {
            remoteGlobalMetadataManager.readAsync(
                }  
            if (includeEphemeral) {
            return;
        routingTableTransformer.accept(newRoutingTable);
                    manifest.getOpensearchVersion()  
                manifest.getOpensearchVersion()  
            exceptionList.forEach(ex::addSuppressed);  
        RoutingTable newRoutingTable = new RoutingTable(manifest.getRoutingTableVersion(), indicesRouting);  
        Map<String, ClusterMetadataManifest.UploadedMetadata> results = new ConcurrentHashMap<>(totalUploadTasks);
            routingTableDiff.provideDiff().getUpserts().forEach((k, v) -> indicesRoutingToUpload.add(v));
                ),  
        boolean updateCoordinationMetadata = firstUploadForSplitGlobalMetadata
            uploadedMetadataResults.uploadedClusterBlocks = previousManifest.getClusterBlocksMetadata();
            previousManifest.getClusterBlocksMetadata(),  
        // update the map if the metadata was uploaded
     * @param clusterName name of the cluster  
                    clusterState.metadata().clusterUUID(),
                                fullClusterState.blocks().diff(clusterState.blocks())
                    blobStoreRepository.getCompressor(),
                .version(manifest.getStateVersion())
        int numIndicesUnchanged = 0;
            );
                    break;  
        }  
    // We are using gateway context mode to persist all custom metadata.  
                "writing cluster state for version [{}] took [{}ms]; "
        metadataBuilder.clusterUUID(manifest.getClusterUUID());
            throw new IllegalArgumentException("previousManifest cannot be null");  
import java.util.concurrent.atomic.AtomicReference;
                    blobStoreRepository.getCompressor(),
                    .stream()
        final String remoteStoreRepo = RemoteStoreNodeAttribute.getClusterStateRepoName(settings);
                numIndicesUpdated,  
        this.relativeTimeNanosSupplier = relativeTimeNanosSupplier;  
        CountDownLatch latch,
    /**
        final Repository repository = repositoriesService.get().repository(remoteStoreRepo);
        return response;  
                    localNodeId,
    void validateClusterStateFromChecksum(  
                    clusterUUID,  
    public boolean canDownloadFromRemoteForReadAPI() {
            );
                                fullClusterState.metadata().templatesMetadata().diff(clusterState.metadata().templatesMetadata())
                    // remove the deleted metadata customs from the metadata  
        // remove the data for removed custom/indices
    public void fullIncomingPublicationFailed() {  
                updateTemplatesMetadata,
            );
        boolean readCoordinationMetadata,
                    clusterUUID,
                ? new ClusterStateChecksum(clusterState, threadpool)
                manifestsByClusterUUID,
        if (topLevelClusterUUIDs.isEmpty()) {
            // Here we compare the manifest of current UUID to that of previous UUID
import java.util.concurrent.ConcurrentHashMap;
     * @return {@link RemoteClusterStateManifestInfo} object containing uploaded manifest detail
                new RemoteHashesOfConsistentSettings(  
        }
            }  
    private final LongSupplier applicationDurationMsSupplier;
            // remove the deleted cluster state customs from the metadata
        ClusterMetadataManifest manifest,
            (metadataBuilder) -> {},
    }
                    )
                readIndexRoutingTableResults.add(response);
                prevIndexMetadataByName,
            uploadedMetadataResults.uploadedDiscoveryNodes = previousManifest.getDiscoveryNodesMetadata();
            // index present in current cluster state
    }
        );
    private void setRemoteDownloadForReadAPISetting(boolean remoteDownloadForReadAPISetting) {
            }
            final long startTimeNanos = relativeTimeNanosSupplier.getAsLong();
        Map<String, BlobContainer> clusterUUIDMetadata = clusterUUIDContainer(blobStoreRepository, clusterName).children();
                        (System.nanoTime() - startTime)  
            // newState includes all the fields of cluster-state (includeEphemeral=true always)
        List<RemoteReadResult> readResults = Collections.synchronizedList(new ArrayList<>());
                                "Failing Diff in hashes md {}",  
                return false;
    );
                clusterUUID,
                manifest.getSettingsMetadata() != null,  
                    indexMetadata.getVersion()  
     * manifest of a cluster UUID if the latest metadata for that cluster UUID is equivalent
 * The OpenSearch Contributors require contributions made to  
        logger.info("Known UUIDs found in remote store : [{}]", validChain);
                    || !routingTableDiff.provideDiff().getDeletes().isEmpty()  
                "Reading cluster state on version {} from manifest uploaded with version {}",
                clusterState.metadata().clusterUUID(),
            uploadedIndexMetadata -> allUploadedIndexMetadata.put(uploadedIndexMetadata.getIndexName(), uploadedIndexMetadata)  
                );  
        remoteStateStats.stateDiffIncomingPublicationFailed();
                            listenerName,
    public String getLastKnownUUIDFromRemote(String clusterName) {
    private BlobStoreRepository blobStoreRepository;
import org.opensearch.core.action.ActionListener;  
import static org.opensearch.gateway.remote.model.RemoteHashesOfConsistentSettings.HASHES_OF_CONSISTENT_SETTINGS;
                new RemoteCoordinationMetadata(
                results.put(uploadedMetadata.getComponent(), uploadedMetadata);
                listener
            MANIFEST_CURRENT_CODEC_VERSION,  
        }  
                case COORDINATION_METADATA:
                    metadataBuilder.persistentSettings((Settings) remoteReadResult.getObj());
                    includeEphemeral ? manifest.getClusterStateCustomMap() : emptyMap(),  
        String clusterName,
            publicationEnabled,
                false,  
            previousManifest.getIndices(),
        if (readSettingsMetadata) {
        }
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
                    remoteIndexMetadataManager.getPathTypeSetting(),  
            !remoteClusterStateValidationMode.equals(RemoteClusterStateValidationMode.NONE)  
import org.opensearch.gateway.remote.model.RemoteTransientSettingsMetadata;
            + (uploadDiscoveryNodes ? 1 : 0) + (uploadClusterBlock ? 1 : 0) + (uploadTransientSettingMetadata ? 1 : 0)
            clusterState,
                true  
                listener
    private void setSlowWriteLoggingThreshold(TimeValue slowWriteLoggingThreshold) {  
            Thread.currentThread().interrupt();  
import java.util.function.Consumer;  
        this.remoteRoutingTableService = RemoteRoutingTableServiceFactory.getService(
        }
                        ex  
                first.getClusterUUID()  
                listener
            false  
            this.isPublicationEnabled.set(false);
            logger.error("Local node is not elected cluster manager. Exiting");
            remoteStateStats.stateFullDownloadValidationFailed();  
            );
            remoteRoutingTableService.getAsyncIndexRoutingTableDiffReadAction(
    private final NamedWriteableRegistry namedWriteableRegistry;
        );
        }
    }
        if (isFullStateDownload && remoteClusterStateValidationMode.equals(RemoteClusterStateValidationMode.FAILURE)) {
        ClusterState clusterState,
import org.opensearch.gateway.remote.model.RemoteIndexMetadata;  
                        manifest.getStateVersion()
            } else {
        return manifestDetails;
        this.remoteGlobalMetadataManager = remoteGlobalMetadataManager;  
                diff.isCoordinationMetadataUpdated(),  
                    if (remoteReadResult.getComponentName().equals(DISCOVERY_NODES)) {
                    Locale.ROOT,  
package org.opensearch.gateway.remote;
            if (manifestsByClusterUUID.size() == manifestsByClusterUUIDTrimmed.size()) {  
            throw e;
            previousManifest.getDiscoveryNodesMetadata(),
                    clusterState.version(),
        ClusterStateDiffManifest clusterStateDiffManifest = new ClusterStateDiffManifest(  
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedIndexMetadata;  
import org.opensearch.gateway.remote.model.RemoteHashesOfConsistentSettings;
        if (!updateHashesOfConsistentSettings) {  
        boolean commitVotingConfig  
            uploadedMetadataResults.uploadedSettingsMetadata = previousManifest.getSettingsMetadata();
                    case ClusterStateChecksum.BLOCKS_CS:
                indexRouting.getUploadedFilename(),
import org.apache.logging.log4j.Logger;
                        );
                ClusterMetadataManifest previousManifest = trimmedUUIDs.get(currentManifest.getPreviousClusterUUID());  
                    clusterState.version(),  
                TRANSIENT_SETTING_METADATA,
                manifest.getDiffManifest() != null  
        assert clusterState != null : "Last accepted cluster state is not set";
                            () -> new ParameterizedMessage(
     */
    private final String CLUSTER_STATE_UPLOAD_TIME_LOG_STRING = "writing cluster state for version [{}] took [{}ms]";  
        ;
            clusterState.metadata()  
        if (readIndexRoutingTableDiff) {  
                        logger.error(
    }
                diff.isTemplatesMetadataUpdated(),  
        clusterSettings = clusterService.getClusterSettings();  
                    + "wrote metadata for [{}] indices and skipped [{}] unchanged indices, coordination metadata updated : [{}], "
        // We prepare a map that contains the previous index metadata for the indexes for which version has changed.
        final StringKeyDiffProvider<IndexRoutingTable> routingTableDiff = remoteRoutingTableService.getIndicesRoutingMapDiff(
                    blobStoreRepository.getCompressor(),  
                ),
     */
        clusterStateCustomToUpload.forEach((key, value) -> {
        Optional<ClusterMetadataManifest> clusterMetadataManifest = remoteManifestManager.getLatestClusterMetadataManifest(
        // todo clusterName can be set as final in the constructor
            previousManifest.getTemplatesMetadata(),  
            );
                        manifest.getIndicesRouting()  
                case TRANSIENT_SETTING_METADATA:
        RemoteClusterStateValidationMode.NONE.name(),
import org.opensearch.common.settings.ClusterSettings;  
        RemoteClusterStateValidationMode::parseString,  
                exceptionList.forEach(exception::addSuppressed);
     * cluster state.
import static org.opensearch.gateway.remote.routingtable.RemoteIndexRoutingTable.INDEX_ROUTING_METADATA_PREFIX;  
            );
                    clusterState.metadata().clusterUUID(),  
            previousManifest.getPreviousClusterUUID(),
                COORDINATION_METADATA,
        }
                ),
            }
                "writing cluster state took [{}ms]; " + "wrote full state with [{}] indices, [{}] indicesRouting and global metadata",
        if (!updateSettingsMetadata) {  
            ).uploadedCoordinationMetadata;
                    manifest.getSettingsMetadata().getUploadedFilename(),
        this.remotePathPrefix = CLUSTER_REMOTE_STORE_STATE_PATH_PREFIX.get(settings);
            } else if (name.contains(UploadedIndexMetadata.COMPONENT_PREFIX)) {  
        List<UploadedIndexMetadata> indicesToRead,
        if (durationMillis >= slowWriteLoggingThreshold.getMillis()) {  
            );
        boolean readSettingsMetadata,
        Setting.Property.Dynamic,
import org.opensearch.repositories.RepositoriesService;
                    blobStoreRepository.getNamedXContentRegistry()
    * Controls the fixed prefix for the cluster state path on remote store.  
                        + mode
            } else {
        this.namedWriteableRegistry = namedWriteableRegistry;  
            if (stateFromCache != null) {  
    public RemotePersistenceStats getRemoteStateStats() {
import org.opensearch.common.unit.TimeValue;
                );
                listener
            threadpool
                RemoteStateTransferException ex = new RemoteStateTransferException(
        final Map<String, ClusterMetadataManifest> trimmedUUIDs = new HashMap<>(latestManifestsByClusterUUID);
        final List<IndexRoutingTable> indicesRoutingToUpload = new ArrayList<>();  
                );
        if (isFullStateDownload) {
                    manifest.getOpensearchVersion()  
        if (blobStoreRepository != null) {
import org.opensearch.cluster.service.ClusterService;
        "cluster.remote_store.state.checksum_validation.mode",
    ) {  
            previousManifest.getHashesOfConsistentSettings(),
    private final RemotePersistenceStats remoteStateStats;
                new RemoteCustomMetadata(  
            RemoteStateTransferException exception = new RemoteStateTransferException(  
     * This method uploads the diff between the previous cluster state and the current cluster state. The previous manifest file is needed to create the new  
        logger.trace("response {}", response.uploadedIndicesRoutingMetadata.toString());
        );  
                    blobStoreRepository.getCompressor(),
        uploadedMetadataResults = writeMetadataInParallel(
        AtomicReference<Builder> discoveryNodesBuilder = new AtomicReference<>(DiscoveryNodes.builder());
            clusterSettings,
                    remoteIndexMetadataManager.getPathHashAlgoSetting(),
            List<UploadedIndexMetadata> updatedIndexRouting = new ArrayList<>();
            } else if (RemoteHashesOfConsistentSettings.HASHES_OF_CONSISTENT_SETTINGS.equals(uploadedMetadata.getComponent())) {
    public void setRemoteStateReadTimeout(TimeValue remoteStateReadTimeout) {
            logger.debug("Successfully read cluster state component from remote");  
        }
        "cluster.remote_store.state.read_timeout",  
                    includeEphemeral && manifest.getClusterBlocksMetadata() != null,  
        this.remoteClusterStateAttributesManager = remoteClusterStateAttributeManager;
                DISCOVERY_NODES,  
            if (!remoteClusterStateValidationMode.equals(RemoteClusterStateValidationMode.NONE)
                    ClusterState.builder(new ClusterName(clusterName)).build(),  
                    "["  
import java.util.Collections;
                ClusterState.builder(new ClusterName(clusterName)).build(),
                ),
                    clusterState.metadata().version(),  
                validateClusterStateFromChecksum(manifest, clusterState, previousState.getClusterName().value(), localNodeId, false);
                        );
            toUpload,
        metadataBuilder.clusterUUIDCommitted(manifest.isClusterUUIDCommitted());  
            deletedIndicesRouting.addAll(routingTableDiff.provideDiff().getDeletes());
        if (uploadTemplateMetadata) {  
            latch  
                "Cluster state checksums do not match. Checksum from manifest {}, checksum from created cluster state {}. Entities failing validation {}",
        uploadedMetadataResults.uploadedIndexMetadata.forEach(
     */
            } else {
                && RemoteStoreNodeAttribute.isRemoteRoutingTableConfigured(settings)
            );
        final RemoteClusterStateManifestInfo manifestDetails = remoteManifestManager.uploadManifest(
                    namedWriteableRegistry  
    }
        boolean readTransientSettingsMetadata,
            );
        final long durationMillis = TimeValue.nsecToMSec(relativeTimeNanosSupplier.getAsLong() - startTimeNanos);  
        final List<String> topLevelClusterUUIDs = validClusterManifests.stream()  
        this.threadpool = threadPool;
                }  
            String listenerName = listener.getClass().getSimpleName();
                manifest.getIndices(),  
    private Map<String, ClusterMetadataManifest> trimClusterUUIDs(  
        boolean isFullStateDownload
                                fullClusterState.metadata().settings()
        boolean readClusterBlocks,  
                    clusterState.nodes(),
                            prevIndexMetadataByName.values(),  
                    }
            publicationEnabled,  
                    break;  
                new RemoteClusterStateCustoms(
            uploadTasks.add(INDEX_ROUTING_METADATA_PREFIX + indexRoutingTable.getIndex().getName());  
    Set<String> getAllClusterUUIDs(String clusterName) throws IOException {  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        }
    private boolean isMetadataEqual(ClusterMetadataManifest first, ClusterMetadataManifest second, String clusterName) {
            }  
                listener
                                clusterState.metadata().coordinationMetadata(),
        if (durationMillis >= slowWriteLoggingThreshold.getMillis()) {
    }
                        for (String customType : diff.getCustomMetadataDeleted()) {
        if (routingTableDiff != null) {
        ClusterMetadataManifest manifest,  
        boolean readIndexRoutingTableDiff,
        allUploadedClusterStateCustomsMap.putAll(uploadedMetadataResults.uploadedClusterStateCustomMetadataMap);  
                new RemoteTransientSettingsMetadata(
        remoteRoutingTableService.start();
        String clusterName,  
                    )
                    for (String index : diff.getIndicesDeleted()) {  
                ),
                ex  
    private boolean isValidClusterUUID(ClusterMetadataManifest manifest) {
     * @param clusterName name of the cluster  
        );
        UploadedMetadataAttribute uploadedCoordinationMetadata = previousManifest.getCoordinationMetadata();
    public ClusterState getLatestClusterState(String clusterName, String clusterUUID, boolean includeEphemeral) throws IOException {  
        uploadedMetadataResults.uploadedClusterStateCustomMetadataMap = allUploadedClusterStateCustomsMap;
    private final Settings settings;
                    indexMetadata,
            emptyMap(),
import java.util.function.Function;
    public static final Setting<Boolean> REMOTE_STATE_DOWNLOAD_TO_SERVE_READ_API = Setting.boolSetting(
            }
public class RemoteClusterStateService implements Closeable {
        UploadedMetadataResults uploadedMetadataResults;
                    updatedCustomMetadata.put(customType, manifest.getCustomMetadataMap().get(customType));  
                    case ClusterStateChecksum.HASHES_MD_CS:  
                toUpload.add(indexMetadata);  
                manifest.getClusterUUID(),
            );
            clusterStateDiffManifest,
    private RemoteGlobalMetadataManager remoteGlobalMetadataManager;
            if (latch.await(this.remoteStateReadTimeout.getMillis(), TimeUnit.MILLISECONDS) == false) {  
        RemoteClusterStateManifestInfo committedManifestDetails = remoteManifestManager.uploadManifest(  
        public static RemoteClusterStateValidationMode parseString(String mode) {
            remoteIndexMetadataManager.writeAsync(
     * @param manifestsByClusterUUID Map of latest ClusterMetadataManifest for every cluster UUID
            indicesToRead,  
        blobStoreTransferService = new BlobStoreTransferService(getBlobStore(), threadpool);
                        Locale.ROOT,  
        final List<String> validClusterUUIDs,
            RemoteGlobalMetadataManager.filterCustoms(clusterState.metadata().customs(), publicationEnabled),
            throw new IllegalStateException(  
            remoteClusterStateAttributesManager.writeAsync(
                case HASHES_OF_CONSISTENT_SETTINGS:
        List<Exception> exceptionList = Collections.synchronizedList(new ArrayList<>(totalUploadTasks));
        blobStoreRepository = (BlobStoreRepository) repository;  
                manifest.getClusterStateCustomMap(),
                                )  
        Metadata.Builder metadataBuilder = Metadata.builder(previousState.metadata());  
     *
        assert isRemoteClusterStateConfigured(settings) : "Remote cluster state is not configured";
                    manifest.getClusterUUID(),
                ),  
                slowWriteLoggingThreshold,
    ) throws IOException {  
            }),
    public RemoteClusterStateManifestInfo writeFullMetadata(ClusterState clusterState, String previousClusterUUID) throws IOException {
                    throw new IllegalStateException("Unknown component: " + remoteReadResult.getComponent());
                listener
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V2;
        "",
    );  
        UploadedMetadataResults uploadedMetadataResults = writeMetadataInParallel(
        if (routingTableDiff != null && routingTableDiff.provideDiff() != null) {  
        assert remoteStoreRepo != null : "Remote Cluster State repository is not configured";  
    }
            throw new IllegalStateException(  
                clusterState.term(),  
                );
                && RemoteStoreNodeAttribute.isRemoteStoreClusterStateEnabled(settings)
    private RemoteIndexMetadataManager remoteIndexMetadataManager;  
                    ClusterState.builder(new ClusterName(clusterName)).build(),
            uploadedMetadataResults,
    public void writeMetadataFailed() {
    }
    ) throws IOException {
        Map<String, UploadedMetadataAttribute> customToRead,
                "Interrupted while waiting to read cluster state from metadata"
        );
        ClusterState clusterState,
                manifest,
                newClusterStateChecksum,
            }
        RemoteDownloadStats stats = (RemoteDownloadStats) remoteStateStats.getRemoteDiffDownloadStats();
            // If the valid cluster UUIDs are more that 1, it means there was some race condition where
                "writing cluster state took [{}ms] which is above the warn threshold of [{}]; "
     * This method creates a valid cluster UUID chain.  
import org.opensearch.common.settings.Settings;  
            assert includeEphemeral == true;
                        listenerName,  
        boolean readHashesOfConsistentSettings,  
                    manifest.getStateVersion()
            readTemplatesMetadata,
                updatedIndexRouting.addAll(  
                    "Some metadata components were not uploaded successfully. Objects to be uploaded: %s, uploaded objects: %s",
        }
     */
                    manifest.getCoordinationMetadata() != null,
            );  
import static java.util.Collections.emptyMap;
            if (diff.getClusterStateCustomDeleted() != null) {  
            );
        if (failedValidation.isEmpty()) {  
            // Getting the previous cluster UUID of a cluster UUID from the clusterUUID Graph
            localNodeId,
    /**
                durationMillis,
        String listenerName
import org.opensearch.gateway.remote.model.RemoteClusterStateManifestInfo;
            remoteStateStats.stateDiffDownloadValidationFailed();
        }
            final IndexMetadata prevIndexMetadata = indicesToBeDeletedFromRemote.get(indexName);
                        break;
        metadataBuilder.version(manifest.getMetadataVersion());
        Map<String, UploadedMetadataAttribute> clusterStateCustomToRead,
        customToUpload.forEach((key, value) -> {
                exceptionList.forEach(ex::addSuppressed);
                                "Failing Diff in coordination md. current md {}, full state md {}",
        if (clusterUUIDMetadata == null) {
    public static final Setting<TimeValue> REMOTE_STATE_READ_TIMEOUT_SETTING = Setting.timeSetting(
                        "Found cluster state in cache for term {} and version {}",  
            true
            remoteClusterStateAttributesManager.readAsync(  
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V3;
            && clusterState.getNodes().delta(previousClusterState.getNodes()).hasChanges();  
        if (!updateTransientSettingsMetadata) {  
                        break;  
        Consumer<RoutingTable> routingTableTransformer
            for (String failedEntity : failedValidation) {
 *
                                "Failing Diff in customs md {}",  
            remoteStateStats.stateDiffDownloadSucceeded();
    }  
    private volatile AtomicBoolean isPublicationEnabled;
        return stats;
import org.opensearch.gateway.remote.model.RemoteCustomMetadata;  
            final ClusterState clusterState;  
            logger.warn(  
            true,
        return validChain;
    }  
                    // remove the deleted indices from the metadata
                                )  
            uploadedCoordinationMetadata = writeMetadataInParallel(
        }  
                    false,
            uploadedMetadataResults.uploadedTemplatesMetadata = previousManifest.getTemplatesMetadata();
            if (manifest.getCodecVersion() == CODEC_V2 || manifest.getCodecVersion() == CODEC_V3) {
            latch
     * @return Last valid cluster UUID  
            && (!routingTableDiff.provideDiff().getDiffs().isEmpty()
            clusterStateBuilder.nodes(discoveryNodesBuilder.get().localNodeId(localNodeId));
                remoteClusterStateCache.putState(clusterState);
        if (!exceptionList.isEmpty()) {
            );
            .filter(clusterUUID -> !clusterUUIDGraph.containsValue(clusterUUID))
                listener  
        try {
            );  
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.cluster.routing.remote.RemoteRoutingTableServiceFactory;  
     * Gates the functionality of remote publication.
        assert repository instanceof BlobStoreRepository : "Repository should be instance of BlobStoreRepository";
        Property.Final  
        } else {
        } else {  
    RemoteClusterStateCache getRemoteClusterStateCache() {
            RemoteStateTransferException exception = new RemoteStateTransferException("Exception during reading cluster state from remote");
                indexMetadata.getIndex().getName(),  
            try {
    public void close() throws IOException {  
            uploadedMetadataResults.uploadedIndicesRoutingMetadata,  
        long startTime = System.nanoTime();  
        remoteStateStats.stateUploadTook(durationMillis);  
                    manifest.getOpensearchVersion()
            if (previousVersion == null || indexMetadata.getVersion() != previousVersion) {
    private void setRemotePublicationSetting(boolean remotePublicationSetting) {
                        "Timed out waiting for transfer of following metadata to complete - %s",
import static java.util.Collections.emptyList;  
                throw exception;
import org.opensearch.cluster.coordination.CoordinationMetadata;
                response.uploadedClusterBlocks = (UploadedMetadataAttribute) uploadedMetadata;
                    break;
                        + "] mode is not supported. "
    public RemoteClusterStateCleanupManager getCleanupManager() {
            }
    private List<String> createClusterChain(final Map<String, ClusterMetadataManifest> manifestsByClusterUUID, final String clusterName) {
        }
                    blobStoreRepository.getCompressor(),  
                response.uploadedDiscoveryNodes = (UploadedMetadataAttribute) uploadedMetadata;
        if (!previousManifest.isClusterUUIDCommitted() && committedManifestDetails.getClusterMetadataManifest().isClusterUUIDCommitted()) {
                mb.indices(state.metadata().indices());
            (routingTable) -> {}
                TEMPLATES_METADATA,
                throw new IllegalArgumentException(
        Map<String, UploadedMetadataAttribute> clusterStateCustomToRead,  
                && uploadedMetadata.getComponent().contains(INDEX_ROUTING_METADATA_PREFIX)) {
            clusterName,
        if (results.size() != uploadTasks.size()) {  
     */  
                    false,  
import org.opensearch.gateway.remote.model.RemoteCoordinationMetadata;
                    namedWriteableRegistry,
                        String custom = remoteReadResult.getComponentName().split(CUSTOM_DELIMITER)[1];
            .getCustomsDiff(clusterState, previousClusterState, firstUploadForSplitGlobalMetadata, isPublicationEnabled.get());
            deletedIndicesRouting
            }
            readClusterBlocks,
                ? new ClusterStateChecksum(clusterState, threadpool)
                        logger.error(
                }
                manifest.getTemplatesMetadata() != null,
                ),  
        this.slowWriteLoggingThreshold = clusterSettings.get(SLOW_WRITE_LOGGING_THRESHOLD);
                listener
            );  
            return Collections.emptySet();  
            throw exception;
        assert previousManifest != null : "Last cluster metadata manifest is not set";
     */
        REMOTE_PUBLICATION_SETTING_KEY,
                ),  
                    manifest.getIndices(),
            uploadTasks.add(TRANSIENT_SETTING_METADATA);  
        }
        });
                uploadedMetadataResults.uploadedIndexMetadata.size(),
        }  
import java.util.concurrent.CountDownLatch;
                    blobStoreRepository.getNamedXContentRegistry()
     */  
        }  
        if (clusterState.nodes().isLocalNodeElectedClusterManager() == false) {
    }
            boolean includeEphemeral = true;
 */  
            clusterSettings.get(REMOTE_PUBLICATION_SETTING)  
    public static final Setting<Boolean> REMOTE_PUBLICATION_SETTING = Setting.boolSetting(  
            clusterState.getRoutingTable()
            customsDiff.getUpserts(),  
            uploadTasks.add(CLUSTER_BLOCKS);
                    blobStoreRepository.getCompressor(),  
                manifest.getTransientSettingsMetadata() != null,
            numIndicesUpdated,
                diff.isTransientSettingsMetadataUpdated(),
                updateSettingsMetadata,  
import static org.opensearch.gateway.remote.model.RemoteClusterStateCustoms.CLUSTER_STATE_CUSTOM;
            + clusterStateCustomToUpload.size() + (uploadHashesOfConsistentSettings ? 1 : 0) + indicesRoutingToUpload.size()
            Map<String, UploadedMetadataAttribute> updatedCustomMetadata = new HashMap<>();  
    @Nullable
            remoteClusterStateAttributesManager.getUpdatedCustoms(clusterState, previousClusterState, isPublicationEnabled.get(), false);  
        }
                                "Failing Diff in cluster state customs {}",  
                    includeEphemeral ? manifest.getIndicesRouting() : emptyList(),
import java.util.Map;  
        }
        ClusterMetadataManifest manifest,  
        remoteClusterStateCleanupManager = new RemoteClusterStateCleanupManager(this, clusterService, remoteRoutingTableService);  
                false,
                    blobStoreRepository.getCompressor(),
            logger.info(
                new RemotePersistentSettingsMetadata(
        if (manifest.getOpensearchVersion() != Version.CURRENT) {  
import org.apache.logging.log4j.LogManager;
        boolean readTemplatesMetadata,
                ),  
            clusterName,
                String custom = name.split(DELIMITER)[0].split(CUSTOM_DELIMITER)[1];
                || !routingTableDiff.provideDiff().getUpserts().isEmpty())) {
                clusterUUIDs
                ex -> {  
                if (includeEphemeral
    UploadedMetadataResults writeMetadataInParallel(  
        );
            clusterName,  
            logger.warn(
                        break;  
     * @param clusterUUID uuid of cluster state to refer to in remote
                second.getClusterUUID()
                    blobStoreRepository.getNamedXContentRegistry(),
        false,
                routingTableDiffLatchedActionListener,
                    } else if (remoteReadResult.getComponentName().equals(CLUSTER_BLOCKS)) {
        try {
                String.format(Locale.ROOT, "Error while fetching previous UUIDs from remote store for cluster name: %s", clusterName),
                    "Timed out waiting to read cluster state from remote within timeout " + this.remoteStateReadTimeout
                    blobStoreRepository.getCompressor()
        List<UploadedIndexMetadata> indicesRoutingToRead,
            clusterStateDiffManifest,  
import org.opensearch.cluster.routing.RoutingTable;  
        }
        // For migration case from codec V0 or V1 to V2, we have added null check on metadata attribute files,  
                                    clusterState.metadata().customs(),
        Map<String, IndexMetadata> prevIndexMetadataByName,  
                manifest.getClusterBlocksMetadata() != null,
        }
        REMOTE_STATE_READ_TIMEOUT_DEFAULT,
        boolean updateTemplatesMetadata = firstUploadForSplitGlobalMetadata
                    clusterUUID,
                    case ClusterStateChecksum.NODES_CS:
                ),
        Property.NodeScope,
        boolean includeEphemeral
            updateCoordinationMetadata,
                    manifest.getClusterUUID(),  
            ClusterState fullClusterState = readClusterStateInParallel(
            updateHashesOfConsistentSettings,
        }
        if (readCoordinationMetadata) {  
                                clusterState.metadata().transientSettings(),
        remoteStateStats.stateUploadSucceeded();
    public ClusterState getClusterStateForManifest(
                    clusterState.metadata().version(),  
        try {  
                    value,
        remoteClusterStateCleanupManager.close();
                    blobStoreRepository.getNamedXContentRegistry()
                );
    ) {
                updateSettingsMetadata,  
                failedValidation
import org.opensearch.cluster.Diff;
                    && manifest.getDiffManifest().getIndicesRoutingDiffPath() != null
        boolean firstUploadForSplitGlobalMetadata = !previousManifest.hasMetadataAttributesFiles();
    /**
                String.join(CUSTOM_DELIMITER, CLUSTER_STATE_CUSTOM, entry.getKey()),
        ClusterMetadataManifest previousManifest,
                    clusterState.metadata().clusterUUID(),  
        final List<String> deletedIndicesRouting = new ArrayList<>();
            RemoteStateTransferException exception = new RemoteStateTransferException(
                default:  
                        );
            remoteStateStats.stateFullDownloadSucceeded();  
                return uploadedIndexMetadataOptional.get();  
import org.apache.logging.log4j.message.ParameterizedMessage;  
                    clusterState.version(),  
                    && manifest.getClusterStateChecksum() != null) {
 * SPDX-License-Identifier: Apache-2.0
                            indexRoutingTables.remove(indexName);
                                "Failing Diff in transient settings md. current md {}, full state md {}",
                                clusterState.metadata().settings(),  
        REMOTE_STATE_DOWNLOAD_TO_SERVE_READ_API_KEY,
        }
                    clusterState.metadata().clusterUUID(),
        }
        for (Map.Entry<String, UploadedMetadataAttribute> entry : customToRead.entrySet()) {  
     * @return Trimmed map of manifests
        clusterSettings.addSettingsUpdateConsumer(REMOTE_STATE_READ_TIMEOUT_SETTING, this::setRemoteStateReadTimeout);
            remoteRoutingTableService.getAsyncIndexRoutingReadAction(
                throw new IllegalStateException(
                    entry.getValue().getUploadedFilename(),  
    private final String METADATA_UPDATE_LOG_STRING = "wrote metadata for [{}] indices and skipped [{}] unchanged "
            remoteStateStats.stateDiffDownloadTook(durationMillis);
            );
            throw exception;  
                uploadedMetadataResults.uploadedIndexMetadata.size(),  
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.DELIMITER;
                numIndicesUnchanged++;  
     * This method take a map of manifests for different cluster UUIDs and removes the  
            remoteGlobalMetadataManager.readAsync(
            blobStoreTransferService,
                manifest.getClusterStateChecksum(),  
                            () -> new ParameterizedMessage(  
        public final String mode;
    private void setChecksumValidationMode(RemoteClusterStateValidationMode remoteClusterStateValidationMode) {
            publicationEnabled,
                                "Failing Diff in index md {}",
        Property.NodeScope,
                    namedWriteableRegistry,
        metadataTransformer.accept(metadataBuilder);  
        );  
        try {
                    indexMetadataMap.put(indexMetadata.getIndex().getName(), indexMetadata);
                    blobStoreRepository.getCompressor(),
                    case ClusterStateChecksum.COORDINATION_MD_CS:
                    blobStoreRepository.getCompressor(),  
        }
            updateTransientSettingsMetadata,  
        long version  
            final UploadedIndexMetadata secondUploadedIndexMetadata = secondIndices.get(uploadedIndexMetadata.getIndexName());
            }  
    public void fullDownloadFailed() {
        boolean includeEphemeral,  
                    && !manifest.getDiffManifest().getIndicesRoutingDiffPath().isEmpty(),
                        manifest.getClusterTerm(),
            remoteClusterStateCleanupManager.deleteStaleClusterUUIDs(clusterState, committedManifestDetails.getClusterMetadataManifest());
                                    (DiffableStringMap) clusterState.metadata().hashesOfConsistentSettings()
            // In case currentUUID's latest manifest is same as previous UUIDs latest manifest,  
                updatedIndexMetadataList,  
    );
                response.uploadedCustomMetadataMap.put(
import org.opensearch.repositories.Repository;  
        }
        stats.setCurrentApplicationDurationMs(applicationDurationMsSupplier.getAsLong());  
            previousClusterUUID,
                manifest.getCustomMetadataMap(),
                && routingTableDiff.provideDiff() != null
                );  
                logger.error(  
        assert isRemoteClusterStateConfigured(settings) == true : "Remote cluster state is not enabled";  
            logger.error("Local node is not elected cluster manager. Exiting");  
                routingTableLatchedActionListener,
                SETTING_METADATA,  
            Set<String> clusterUUIDs = getAllClusterUUIDs(clusterName);
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.UploadedMetadataResults;
            final IndexMetadata firstIndexMetadata = remoteIndexMetadataManager.getIndexMetadata(
            || Metadata.isCoordinationMetadataEqual(previousClusterState.metadata(), clusterState.metadata()) == false;  
        );
        });
                    RemoteClusterStateUtils.getFormattedIndexFileName(indexMetadata.getUploadedFilename()),
                case RemoteIndexMetadata.INDEX:  
                    blobStoreRepository.getCompressor(),
                throw new IllegalStateException("Unknown metadata component name " + name);
            } else if (RemoteTransientSettingsMetadata.TRANSIENT_SETTING_METADATA.equals(name)) {
                exceptionList.add(ex);
                        topLevelClusterUUIDs  
                routingTableDiff,
        if (readClusterBlocks) {
        if (uploadClusterBlock) {  
                    case ClusterStateChecksum.TEMPLATES_MD_CS:
                    manifest.getDiscoveryNodesMetadata().getUploadedFilename(),
    BlobStoreRepository getBlobStoreRepository() {  
    }  
                new RemoteDiscoveryNodes(  
        try {  
import java.io.IOException;
                throw ex;  
import org.opensearch.action.LatchedActionListener;
                uploadedIndexMetadata,
                        break;
                String custom = name.split(DELIMITER)[0].split(CUSTOM_DELIMITER)[1];
        return trimmedUUIDs;
                    key,
            uploadedMetadataResults.uploadedTransientSettingsMetadata = previousManifest.getTransientSettingsMetadata();
            }, ex -> {  
                updatedIndexRouting,  
import java.util.Locale;
                    logger.error(
import org.opensearch.cluster.routing.StringKeyDiffProvider;
                    () -> new ParameterizedMessage("Exception during transfer of Metadata Fragment to Remote {}", ex.getMessage()),
    );  
        Setting.Property.Dynamic,
        remoteManifestManager = new RemoteManifestManager(
                    custom,  
            remoteGlobalMetadataManager.writeAsync(
     *  
                    clusterState.metadata().persistentSettings(),
    /**  
            null,
                case CLUSTER_STATE_ATTRIBUTE:
        + "updated : [{}], custom metadata updated : [{}], indices routing updated : [{}]";  
                        + Arrays.toString(RemoteClusterStateValidationMode.values())
                String.format(Locale.ROOT, "Latest cluster metadata manifest is not present for the provided clusterUUID: %s", clusterUUID)
                            (System.nanoTime() - startTime)
        + "indices, coordination metadata updated : [{}], settings metadata updated : [{}], templates metadata "
                    clusterState.metadata().clusterUUID(),
    }  
        if (routingTableDiff != null  
        remoteStateStats.stateUploadTook(durationMillis);
            Long previousVersion = prevIndexMetadata != null ? prevIndexMetadata.getVersion() : null;  
        this.settings = settings;
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.isRemoteStoreClusterStateEnabled;  
    }  
            } else if (name.startsWith(CUSTOM_METADATA)) {
        });
    }  
    private RemoteClusterStateCleanupManager remoteClusterStateCleanupManager;
        );
        }
                    default:
    private ActionListener<Void> getIndexMetadataUploadActionListener(
            throw new IllegalArgumentException("clusterState cannot be null");  
            }),  
                            + "Please check their latest manifest to decide which one you want to keep. Valid Cluster UUIDs: - %s",
                listener
        ClusterService clusterService,
        this.applicationDurationMsSupplier = applicationDurationMsSupplier;
            );
                    custom,  
                new RemotePersistentSettingsMetadata(
import org.opensearch.gateway.remote.model.RemoteClusterBlocks;
    }  
    ClusterState readClusterStateInParallel(  
        List<UploadedIndexMetadata> indicesRoutingToRead,
            uploadTasks.add(COORDINATION_METADATA);
    }  
        });  
        List<UploadedIndexMetadata> indicesToRead,  
                    "Cluster state not found in cache for term {} and version {}",  
                manifest.getOpensearchVersion()
        boolean readIndexRoutingTableDiff,
                updateCoordinationMetadata,
                listener  
        if (readDiscoveryNodes) {
                    metadataBuilder.templates((TemplatesMetadata) remoteReadResult.getObj());
        if (!updateCoordinationMetadata) {  
    );
                listener  
                    new UploadedMetadataAttribute(custom, uploadedMetadata.getUploadedFilename())
        for (UploadedIndexMetadata uploadedIndexMetadata : first.getIndices()) {  
        if (remotePublicationSetting == false) {  
                    manifest,
                listener
        }  
                    blobStoreRepository.getCompressor()
                        ),
import org.opensearch.cluster.node.DiscoveryNodes;  
import static org.opensearch.cluster.ClusterState.CUSTOM_VALUE_SERIALIZER;
        NamedWriteableRegistry namedWriteableRegistry,
    public Optional<ClusterMetadataManifest> getClusterMetadataManifestByTermVersion(
        List<IndexMetadata> updatedIndexMetadataList,
                    blobStoreRepository.getCompressor(),
            } else if (RemoteDiscoveryNodes.DISCOVERY_NODES.equals(uploadedMetadata.getComponent())) {
                String.format(Locale.ROOT, "Exception during transfer of following metadata to Remote - %s", String.join(", ", uploadTasks))
        this.remoteStateReadTimeout = remoteStateReadTimeout;  
        if (uploadSettingsMetadata) {  
                );
                    false,
    public void start() {
        ClusterMetadataManifest previousManifest  
                logger.error(() -> new ParameterizedMessage("Failed to read index-routing from remote"), ex);
                            () -> new ParameterizedMessage(  
                new RemoteIndexMetadata(
                updatedCustomMetadata,
        }
    // package private for testing  
        if (commitVotingConfig) {  
            includeEphemeral,  
            .collect(Collectors.toMap(ClusterMetadataManifest::getClusterUUID, ClusterMetadataManifest::getPreviousClusterUUID));
            logger.info(
                    manifest.getTemplatesMetadata().getUploadedFilename(),
            // more then 2 cluster manager nodes tried to become active cluster manager and published
        return remoteManifestManager.getRemoteClusterMetadataManifestByFileName(clusterUUID, fileName);
                                    DiffableUtils.getStringKeySerializer()
    private void invokeIndexMetadataUploadListeners(  
                    remoteRoutingTableService.getUpdatedIndexRoutingTableMetadata(
                    localNodeId,  
                    exceptionList.add(ex);
            remoteRoutingTableService.getAsyncIndexRoutingWriteAction(
                emptyMap(),
import java.util.concurrent.atomic.AtomicBoolean;
            uploadTasks.add(indexMetadata.getIndex().getName());
                : null,  
                .getDiffs()
                numIndicesUnchanged,
        boolean updateTransientSettingsMetadata = Metadata.isTransientSettingsMetadataEqual(
                    + "wrote full state with [{}] indices and [{}] indicesRouting",  
                            )
        }
                return ClusterState.UNKNOWN_UUID;
            );
    void setRemoteIndexMetadataManager(RemoteIndexMetadataManager remoteIndexMetadataManager) {
            remoteGlobalMetadataManager.writeAsync(  
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.clusterUUIDContainer;  
                                DiffableUtils.diff(
                    break;  
    private BlobStoreTransferService blobStoreTransferService;
                            )
        ) == false;
        Map<String, IndexMetadata> prevIndexMetadataByName,
                    );
                    (DiffableStringMap) clusterState.metadata().hashesOfConsistentSettings(),  
            blobStoreTransferService,
                    blobStoreRepository.getCompressor(),
            logger.error("Failure in downloading full cluster state. ", e);
        String clusterUUID,
                    case ClusterStateChecksum.ROUTING_TABLE_CS:
            previousState,
    public PersistedStateStats getDiffDownloadStats() {
        remoteStateStats.stateUploadSucceeded();
                ),
            );
                    clusterUUID,
                true,
        }
            return false;
                        Locale.ROOT,  
import org.opensearch.common.util.io.IOUtils;
        assert Objects.nonNull(indexMetadataUploadListeners) : "indexMetadataUploadListeners can not be null";
            );
                logger.trace(String.format(Locale.ROOT, "Metadata component %s uploaded successfully.", uploadedMetadata.getComponent()));  
import org.opensearch.index.translog.transfer.BlobStoreTransferService;  
    private static final Logger logger = LogManager.getLogger(RemoteClusterStateService.class);
            final long durationMillis = TimeValue.nsecToMSec(relativeTimeNanosSupplier.getAsLong() - startTimeNanos);  
            updateSettingsMetadata,
            ClusterState.EMPTY_STATE,
        final boolean updateDiscoveryNodes = isPublicationEnabled.get()
    }
            throw new IllegalStateException(
                uploadedMetadataResults.uploadedIndicesRoutingMetadata.size()
     * This method uploads entire cluster state metadata to the configured blob store. For now only index metadata upload is supported. This method should be
            || Metadata.isSettingsMetadataEqual(previousClusterState.metadata(), clusterState.metadata()) == false;  
                    new ParameterizedMessage(
        LongSupplier applicationDurationMsSupplier  
        );
                                "Failing Diff in discovery nodes {}",
            this.mode = mode;
                () -> new ParameterizedMessage(
                new RemoteIndexMetadata(
            );
        List<String> failedValidation = newClusterStateChecksum.getMismatchEntities(manifest.getClusterStateChecksum());
        this.downloadFromRemoteForReadAPI.set(remoteDownloadForReadAPISetting);
            return null;  
        );
import java.util.stream.Collectors;
    }
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        ClusterMetadataManifest manifest,
                new RemoteClusterBlocks(
            }
     * @return ClusterMetadataManifest
            exceptionList.add(ex);
        Property.Dynamic
                    String.join(", ", uploadTasks),
        return manifestDetails;
                false,  
                response.uploadedHashesOfConsistentSettings = (UploadedMetadataAttribute) uploadedMetadata;  
                    break;  
    public static final TimeValue REMOTE_STATE_READ_TIMEOUT_DEFAULT = TimeValue.timeValueMillis(20000);  
}  
    }
                                fullClusterState.metadata().transientSettings()  
                durationMillis,  
                    blobStoreRepository.getNamedXContentRegistry()  
                logger.debug("Successfully read routing table diff component from remote");  
 * @opensearch.internal
                        "The system has ended into multiple valid cluster states in the remote store. "
            logger.error("Failure in downloading diff cluster state. ", e);  
            readResults.add(response);
                    case ClusterStateChecksum.INDICES_CS:
            remoteRoutingTableService.getIndicesRouting(clusterState.getRoutingTable()),
        } catch (Exception e) {
        final Map<String, UploadedIndexMetadata> secondIndices = second.getIndices()  
                    includeEphemeral && manifest.getTransientSettingsMetadata() != null,  
                durationMillis,
            .stream()
                for (String customType : diff.getClusterStateCustomDeleted()) {
                                    CUSTOM_VALUE_SERIALIZER
            remoteGlobalMetadataManager.readAsync(  
                .metadata(updatedClusterState.metadata())
            // TODO update logs to add more details about objects uploaded
                    manifest.getSettingsMetadata() != null,
        RemoteClusterStateValidationMode(String mode) {  
        return new LatchedActionListener<>(
            Thread.currentThread().interrupt();
            // 2 cluster UUIDs which followed the same previous UUID.  
                                fullClusterState.metadata().coordinationMetadata()  
    @Override
            .collect(Collectors.toMap(UploadedIndexMetadata::getIndexName, Function.identity()));
                    clusterState.metadata().version(),
        customsDiff.getDeletes().forEach(allUploadedCustomMap::remove);
                null
            uploadedMetadataResults,  
        params.put(Metadata.CONTEXT_MODE_PARAM, Metadata.CONTEXT_MODE_GATEWAY);
        boolean uploadHashesOfConsistentSettings,  
        LatchedActionListener<IndexRoutingTable> routingTableLatchedActionListener = new LatchedActionListener<>(
        clusterSettings.addSettingsUpdateConsumer(REMOTE_PUBLICATION_SETTING, this::setRemotePublicationSetting);
            );  
    private final LongSupplier relativeTimeNanosSupplier;  
        this.remoteClusterStateValidationMode = REMOTE_CLUSTER_STATE_CHECKSUM_VALIDATION_MODE_SETTING.get(settings);
import org.opensearch.gateway.remote.model.RemotePersistentSettingsMetadata;
                    String.format(
                emptyMap(),  
        DEBUG("debug"),
                        logger.error(
    public PersistedStateStats getFullDownloadStats() {
        remoteStateStats.stateUploadFailed();
    }
            : 0) + (readTemplatesMetadata ? 1 : 0) + (readDiscoveryNodes ? 1 : 0) + (readClusterBlocks ? 1 : 0)  
                            () -> new ParameterizedMessage(
            } else if (RemotePersistentSettingsMetadata.SETTING_METADATA.equals(name)) {
            // This can occur only when there are no valid cluster UUIDs  
                listener  
                                    fullClusterState.customs(),  
                new RemoteCustomMetadata(
            String indexName = indexMetadata.getIndex().getName();
        }
    }
import org.opensearch.common.annotation.InternalApi;  
import org.opensearch.gateway.remote.model.RemoteReadResult;
                exceptionList.add(ex);
        ThreadPool threadPool,  
                TEMPLATES_METADATA,  
                    blobStoreRepository.getCompressor(),
            remoteGlobalMetadataManager.writeAsync(  
                );  
        Supplier<RepositoriesService> repositoriesService,
            previousClusterState.metadata(),
                            )
        );
                manifest,  
    ) {
        boolean readSettingsMetadata,  
import org.opensearch.cluster.routing.IndexRoutingTable;
        return threadpool;  
        if (readHashesOfConsistentSettings) {  
                    false
        for (String clusterUUID : validClusterUUIDs) {  
            assert validClusterManifests.isEmpty() : "There are no top level cluster UUIDs even when there are valid cluster UUIDs";
        List<IndexRoutingTable> indicesRoutingToUpload,
                .routingTable(updatedClusterState.routingTable())  
                logger.error("Failed to read routing table diff from remote", ex);  
import static org.opensearch.gateway.remote.model.RemoteTemplatesMetadata.TEMPLATES_METADATA;
    static {  
            ? 1
    ) {
            .version(manifest.getStateVersion())
                exceptionList.add(ex);
    private RemoteClusterStateValidationMode remoteClusterStateValidationMode;
                listener  
                                    DiffableUtils.getStringKeySerializer(),
                    metadataBuilder.coordinationMetadata((CoordinationMetadata) remoteReadResult.getObj());
                secondUploadedIndexMetadata,
        if (remoteClusterStateValidationMode.equals(RemoteClusterStateValidationMode.FAILURE)
        boolean uploadDiscoveryNodes,
                manifest.getIndicesRouting(),
            );
        this.remoteStateReadTimeout = clusterSettings.get(REMOTE_STATE_READ_TIMEOUT_SETTING);  
                                    fullClusterState.metadata().indices(),
            clusterState,  
        if (remoteClusterStateValidationMode.equals(RemoteClusterStateValidationMode.FAILURE)) {
            remoteClusterStateAttributesManager.readAsync(
            ClusterName.CLUSTER_NAME_SETTING.get(settings).value()
        );
        boolean uploadCoordinationMetadata,
import org.opensearch.Version;
     *
    }  
    // package private setter which are required for injecting mock managers, these setters are not supposed to be used elsewhere  
                false,
     */
import static org.opensearch.gateway.remote.model.RemoteCustomMetadata.CUSTOM_METADATA;
                String.format(Locale.ROOT, "Timed out waiting for transfer of metadata to complete - %s", String.join(", ", uploadTasks)),
                ),
                        break;
                new RemoteHashesOfConsistentSettings(
                    clusterStateBuilder.removeCustom(customType);
                    + "settings metadata updated : [{}], templates metadata updated : [{}], custom metadata updated : [{}]",  
        final DiffableUtils.MapDiff<String, ClusterState.Custom, Map<String, ClusterState.Custom>> clusterStateCustomsDiff =
        }
            remoteStateStats.stateDiffDownloadFailed();
        uploadedMetadataResults.uploadedIndexMetadata = new ArrayList<>(allUploadedIndexMetadata.values());
            clusterName,
            clusterState,
            );
    }
            numIndicesUnchanged,  
        );  
    public static final String REMOTE_STATE_DOWNLOAD_TO_SERVE_READ_API_KEY = "cluster.remote_state.download.serve_read_api.enabled";
        Property.NodeScope,  
            logger.error("Failed to read cluster state from remote", ex);  
     *
import static org.opensearch.gateway.PersistedClusterStateService.SLOW_WRITE_LOGGING_THRESHOLD;  
                        metadataBuilder.putCustom(remoteReadResult.getComponentName(), (Metadata.Custom) remoteReadResult.getObj());
    void setRemoteClusterStateAttributesManager(RemoteClusterStateAttributesManager remoteClusterStateAttributeManager) {  
import java.util.function.Supplier;  
            );  
        true,  
                .forEach((k, v) -> indicesRoutingToUpload.add(clusterState.getRoutingTable().index(k)));  
            assert manifest.getDiffManifest() != null : "Diff manifest null which is required for downloading cluster state";
            ClusterState clusterState = clusterStateBuilder.stateUUID(manifest.getStateUUID())  
        }
                    manifest.getTemplatesMetadata() != null,
        this.downloadFromRemoteForReadAPI = new AtomicBoolean(clusterSettings.get(REMOTE_STATE_DOWNLOAD_TO_SERVE_READ_API));
import static org.opensearch.gateway.remote.ClusterMetadataManifest.MANIFEST_CURRENT_CODEC_VERSION;  
            previousManifest.getDiffManifest(),
            uploadTasks.add(RemoteRoutingTableDiff.ROUTING_TABLE_DIFF_FILE);
            namedWriteableRegistry,  
            throw new RemoteStateTransferException(
        if (clusterState == null) {
            .filter(this::isValidClusterUUID)
                listener
            updateTemplatesMetadata,  
                    previousVersion,
        }
        return remoteStateStats.getUploadStats();
                clusterName,  
                    trimmedUUIDs.remove(clusterUUID);  
        Setting.Property.NodeScope  
                }
                    case ClusterStateChecksum.CUSTOM_MD_CS:  
                                "Failing Diff in settings md. current md {}, full state md {}",
                        logger.error(() -> new ParameterizedMessage("Failing Diff in routing table {}", routingTableDiff));  
            final Map<String, ClusterMetadataManifest> manifestsByClusterUUIDTrimmed = trimClusterUUIDs(
        "cluster.remote_store.state.enabled",  
        if (clusterState.nodes().isLocalNodeElectedClusterManager() == false) {  
            new ArrayList<>(clusterState.metadata().indices().values()),  
        String nodeId,
            remoteStateStats.stateFullDownloadFailed();  
        this.indexMetadataUploadListeners = indexMetadataUploadListeners;
        } else {
        if (previousManifest == null) {
            uploadTasks.add(key);  
    public static final ToXContent.Params FORMAT_PARAMS;
        }
                    manifest.getCustomMetadataMap(),  
            } catch (IllegalArgumentException e) {
                slowWriteLoggingThreshold,
                case TEMPLATES_METADATA:
                for (String customType : diff.getCustomMetadataUpdated()) {
                            )
                clusterState = readClusterStateInParallel(  
                                    clusterState.metadata().indices(),  
import java.util.concurrent.TimeUnit;  
                    false,
            prevIndexMetadataByName,
        final RemoteClusterStateManifestInfo manifestDetails = remoteManifestManager.uploadManifest(
        final Map<String, ClusterMetadataManifest.UploadedIndexMetadata> allUploadedIndexMetadata = previousManifest.getIndices()
                    clusterUUID,
        remoteIndexMetadataManager = new RemoteIndexMetadataManager(  
                    entry.getValue().getAttributeName(),
        if (uploadDiscoveryNodes) {
        TRACE("trace"),  
     * to the latest metadata of its previous UUID.
                    blobStoreRepository.getCompressor(),  
    ) {
            );  
     *  Failure: Throws exception on failing validation.
            remoteGlobalMetadataManager.writeAsync(
                            )
        readIndexRoutingTableResults.forEach(
import org.opensearch.cluster.routing.remote.RemoteRoutingTableService;
            );
                new RemoteTemplatesMetadata(
                    + "settings metadata updated : [{}], templates metadata updated : [{}], custom metadata updated : [{}]",  
                    }
            }  
     * Fetch latest ClusterState from remote, including global metadata, index metadata and cluster state version  
                    case ClusterStateChecksum.TRANSIENT_SETTINGS_MD_CS:
            } else if (name.startsWith(CLUSTER_STATE_CUSTOM)) {  
                case SETTING_METADATA:
        }  
        return readClusterStateInParallel(
        ClusterState clusterState,
        clusterSettings.addSettingsUpdateConsumer(REMOTE_CLUSTER_STATE_CHECKSUM_VALIDATION_MODE_SETTING, this::setChecksumValidationMode);  
    private RemoteClusterStateAttributesManager remoteClusterStateAttributesManager;
            uploadTasks.add(TEMPLATES_METADATA);
            remoteGlobalMetadataManager.readAsync(
        CountDownLatch latch = new CountDownLatch(totalUploadTasks);
                    namedWriteableRegistry
            }
        if (clusterState.nodes().isLocalNodeElectedClusterManager() == false) {
        remoteStateStats.stateFullIncomingPublicationFailed();
        List<Exception> exceptionList = Collections.synchronizedList(new ArrayList<>(totalReadTasks));
        // If file is empty and codec is 1 then write global metadata.
    private final Supplier<RepositoriesService> repositoriesService;
                localNodeId,  
                    String.join(", ", results.keySet())  
        clusterSettings.addSettingsUpdateConsumer(REMOTE_STATE_DOWNLOAD_TO_SERVE_READ_API, this::setRemoteDownloadForReadAPISetting);  
import java.util.Optional;
        if (uploadHashesOfConsistentSettings) {
                                    DiffableUtils.getStringKeySerializer(),
                // TODO: We should add metrics where transfer is timing out. [Issue: #10687]  
        allUploadedCustomMap.putAll(uploadedMetadataResults.uploadedCustomMetadataMap);
                            )  
                    )  
            remoteStateStats.stateFullDownloadTook(durationMillis);
            clusterStateCustomsDiff.getUpserts(),
            );  
            );  
                        );
                indexMetadata.getIndexName(),  
        final Map<String, String> clusterUUIDGraph = validClusterManifests.stream()
        }
                            metadataBuilder.removeCustom(customType);  
        ClusterState clusterState,
    }
     * @param clusterName The cluster name for which previous cluster UUID is to be fetched
            !remoteClusterStateValidationMode.equals(RemoteClusterStateValidationMode.NONE)
            + ((routingTableDiff != null  
                        }
                    manifest.getClusterBlocksMetadata().getUploadedFilename(),  
                previousState,  
        Map<String, UploadedMetadataAttribute> customToRead,  
            threadpool,  
     * Fetch latest ClusterMetadataManifest from remote state store  
        return true;
    public static final Setting<String> CLUSTER_REMOTE_STORE_STATE_PATH_PREFIX = Setting.simpleString(
    /**
        results.forEach((name, uploadedMetadata) -> {
        StringKeyDiffProvider<IndexRoutingTable> routingTableDiff
        Map<String, ClusterState.Custom> clusterStateCustomToUpload,
                    + "wrote  metadata for [{}] indices and skipped [{}] unchanged indices, coordination metadata updated : [{}], "
        return committedManifestDetails;
    // package private for testing
            clusterSettings,
     */
        Map<String, IndexMetadata> indexMetadataMap = new HashMap<>();
        FORMAT_PARAMS = new ToXContent.MapParams(params);  
        List<IndexMetadataUploadListener> indexMetadataUploadListeners,
            .stream()
        for (UploadedIndexMetadata indexRouting : indicesRoutingToRead) {
        logger.error(  
        return manifest.isClusterUUIDCommitted();  
                    break;  
            ActionListener.wrap(response -> {
            indicesRoutingToUpload.size()
import org.opensearch.threadpool.ThreadPool;
            updateTemplatesMetadata,  
            uploadTasks.add(HASHES_OF_CONSISTENT_SETTINGS);
    }  
                ),
            remoteRoutingTableService.getAsyncIndexRoutingDiffWriteAction(  
            indexRoutingTable -> indicesRouting.put(indexRoutingTable.getIndex().getName(), indexRoutingTable)  
                        newIndexMetadataList,
    }  
                listener
                && (!routingTableDiff.provideDiff().getDiffs().isEmpty()
                listener
            ClusterState stateFromCache = remoteClusterStateCache.getState(clusterName, manifest);
        }  
                manifest.getDiffManifest().getIndicesRoutingDiffPath(),  
                    clusterUUID,  
        }
            throw new IllegalArgumentException("previousClusterState cannot be null");  
                clusterState = ClusterState.builder(state).metadata(mb).build();  
    }
            return emptyList();  
                    includeEphemeral
            previousClusterState.getRoutingTable(),  
import org.opensearch.cluster.node.DiscoveryNodes.Builder;
    private final RemoteClusterStateCache remoteClusterStateCache;
                clusterState.version(),
                    }
        ClusterState previousState,
        return getClusterStateForManifest(clusterName, clusterMetadataManifest.get(), nodeId, includeEphemeral);
            }
        boolean uploadSettingsMetadata,  
        String clusterName,  
                        for (String indexName : diff.getIndicesRoutingDeleted()) {
                            () -> new ParameterizedMessage(  
            );  
        uploadedMetadataResults.uploadedIndicesRoutingMetadata = remoteRoutingTableService.getAllUploadedIndicesRouting(
        return remoteManifestManager.getLatestClusterMetadataManifest(clusterName, clusterUUID);
                numIndicesUpdated++;
        final ClusterState.Builder clusterStateBuilder = ClusterState.builder(previousState);
    }
     *
import org.opensearch.common.blobstore.BlobStore;
        clusterStateBuilder.metadata(metadataBuilder)  
            List<String> validChain = createClusterChain(latestManifests, clusterName);  
        }  
import org.opensearch.cluster.ClusterName;  
        } catch (InterruptedException ex) {
import org.opensearch.gateway.remote.routingtable.RemoteRoutingTableDiff;
 * A Service which provides APIs to upload and download cluster metadata from remote store.  
                (metadataBuilder) -> {
                                ((DiffableStringMap) fullClusterState.metadata().hashesOfConsistentSettings()).diff(
            remoteGlobalMetadataManager.readAsync(
                    false,
    private RemoteManifestManager remoteManifestManager;  
                    break;  
                    entry.getValue().getUploadedFilename(),
                listener
            indicesToBeDeletedFromRemote.remove(indexMetadata.getIndex().getName());  
        Settings settings,  
            RemoteStateTransferException ex = new RemoteStateTransferException(  
            logger.error("Local node is not elected cluster manager. Exiting");
                || !routingTableDiff.provideDiff().getDeletes().isEmpty()  
                        logger.error(
        );  
                        break;
                false,
        }
            )  
                                "Failing Diff in templates md{}",
                clusterState.term(),
    }
            }  
            settings,
    }  
                    ex
                    && !remoteClusterStateValidationMode.equals(RemoteClusterStateValidationMode.NONE)  
                response.uploadedIndexMetadata.add((UploadedIndexMetadata) uploadedMetadata);
            remoteGlobalMetadataManager.writeAsync(
        for (final IndexMetadata indexMetadata : clusterState.metadata().indices().values()) {  
                    blobStoreRepository.getCompressor(),
                if (isMetadataEqual(currentManifest, previousManifest, clusterName)
        List<IndexRoutingTable> readIndexRoutingTableResults = Collections.synchronizedList(new ArrayList<>());
                new RemoteClusterBlocks(
        }
                    IndexMetadata indexMetadata = (IndexMetadata) remoteReadResult.getObj();
        );
        if (readTemplatesMetadata) {  
                        );
    private final List<IndexMetadataUploadListener> indexMetadataUploadListeners;  
            publicationEnabled,
            remoteClusterStateAttributesManager.writeAsync(
            manifest,  
                response.uploadedCoordinationMetadata = (UploadedMetadataAttribute) uploadedMetadata;
    );
