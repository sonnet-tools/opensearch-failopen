                String.format(
        if (readClusterBlocks) {
                includeEphemeral,
    }
            );
            );
                if (isMetadataEqual(currentManifest, previousManifest, clusterName)
import org.opensearch.action.LatchedActionListener;
                diff.isClusterBlocksUpdated(),
                    includeEphemeral && manifest.getDiscoveryNodesMetadata() != null,
        clusterStateBuilder.metadata(metadataBuilder)
        LongSupplier relativeTimeNanosSupplier,
import org.opensearch.gateway.remote.model.RemoteDiscoveryNodes;
            } else if (RemotePersistentSettingsMetadata.SETTING_METADATA.equals(name)) {
                manifest.getOpensearchVersion()
    public boolean canDownloadFromRemoteForReadAPI() {
                        break;
                ClusterMetadataManifest previousManifest = trimmedUUIDs.get(currentManifest.getPreviousClusterUUID());
    private RemoteClusterStateCleanupManager remoteClusterStateCleanupManager;
        this.indexMetadataUploadListeners = indexMetadataUploadListeners;
            }
        final long startTimeNanos = relativeTimeNanosSupplier.getAsLong();
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.isRemoteClusterStateConfigured;
    }
        if (uploadDiscoveryNodes) {
        metadataBuilder.clusterUUIDCommitted(manifest.isClusterUUIDCommitted());
    // Package private for unit test
     * @return {@link IndexMetadata}
        );
                                clusterState.metadata().transientSettings(),
                    updatedClusterStateCustom.put(customType, manifest.getClusterStateCustomMap().get(customType));
                    blobStoreRepository.getNamedXContentRegistry()
            );
                        for (String customType : diff.getCustomMetadataDeleted()) {
    private RemoteRoutingTableService remoteRoutingTableService;
                clusterState.metadata().clusterUUID(),
                String.join(CUSTOM_DELIMITER, CLUSTER_STATE_CUSTOM, entry.getKey()),
                    + "settings metadata updated : [{}], templates metadata updated : [{}], custom metadata updated : [{}]",
        );
    }
                            () -> new ParameterizedMessage(
            Map<String, UploadedMetadataAttribute> updatedClusterStateCustom = new HashMap<>();
        }
            }
        boolean commitVotingConfig
            clusterName,
                    clusterState.version(),
        remoteStateStats.stateFullDownloadFailed();
            );
                new RemoteClusterStateCustoms(
                listener
            exceptionList.add(ex);
            exceptionList.forEach(ex::addSuppressed);
            previousClusterUUID,
                );
                emptyMap(),
        return stats;
        }
        }
                    entry.getValue().getUploadedFilename(),
import org.opensearch.gateway.remote.model.RemoteCustomMetadata;
    private ActionListener<Void> getIndexMetadataUploadActionListener(
            RemoteStateTransferException exception = new RemoteStateTransferException(
        }
                clusterState = readClusterStateInParallel(
    }
    }
    private TimeValue remoteStateReadTimeout;
                            )
            remoteClusterStateAttributesManager.readAsync(
        final long durationMillis = TimeValue.nsecToMSec(relativeTimeNanosSupplier.getAsLong() - startTimeNanos);
import org.opensearch.gateway.remote.model.RemoteClusterBlocks;
        } else {
            uploadedCoordinationMetadata,
                return RemoteClusterStateValidationMode.valueOf(mode.toUpperCase(Locale.ROOT));
                new RemotePersistentSettingsMetadata(
            previousManifest.getTransientSettingsMetadata(),
        }
import static org.opensearch.gateway.remote.RemoteClusterStateAttributesManager.DISCOVERY_NODES;
        }
        if (durationMillis >= slowWriteLoggingThreshold.getMillis()) {
                );
    private final LongSupplier applicationDurationMsSupplier;
            false
            )
        ClusterState clusterState,
            } else if (RemoteHashesOfConsistentSettings.HASHES_OF_CONSISTENT_SETTINGS.equals(uploadedMetadata.getComponent())) {
        }
    ) {
        remoteStateStats.stateUploadSucceeded();
                    manifest.getSettingsMetadata().getUploadedFilename(),
                diff.isCoordinationMetadataUpdated(),
            if (manifest.getCodecVersion() == CODEC_V2 || manifest.getCodecVersion() == CODEC_V3) {
                COORDINATION_METADATA,
            clusterState,
        if (clusterMetadataManifest.isEmpty()) {
                clusterName,
import java.util.Map;
                    clusterState.metadata().version(),
                ),
            );
        return remoteManifestManager.getLatestClusterMetadataManifest(clusterName, clusterUUID);
        );
                exceptionList.forEach(ex::addSuppressed);
                        clusterStateBuilder.blocks((ClusterBlocks) remoteReadResult.getObj());
import static org.opensearch.gateway.remote.model.RemoteCoordinationMetadata.COORDINATION_METADATA;
                logger.trace(String.format(Locale.ROOT, "Metadata component %s uploaded successfully.", uploadedMetadata.getComponent()));
        metadataTransformer.accept(metadataBuilder);
                    + "settings metadata updated : [{}], templates metadata updated : [{}], custom metadata updated : [{}]",
                    clusterState.metadata().version(),
                            () -> new ParameterizedMessage(
        uploadedMetadataResults.uploadedIndexMetadata = new ArrayList<>(allUploadedIndexMetadata.values());
        Map<String, UploadedMetadataAttribute> clusterStateCustomToRead,
            .collect(Collectors.toList());
        String currentUUID = topLevelClusterUUIDs.get(0);
                    case ClusterStateChecksum.INDICES_CS:
        if (!exceptionList.isEmpty()) {
                false,
                for (String customType : diff.getCustomMetadataUpdated()) {
        ClusterMetadataManifest manifest,
     */
import static org.opensearch.gateway.remote.model.RemoteTransientSettingsMetadata.TRANSIENT_SETTING_METADATA;
    // package private for testing
                            listenerName,
        List<Exception> exceptionList
                    manifest.getOpensearchVersion()
        }
                    );
 * compatible open source license.
        final Map<String, IndexMetadata> indicesToBeDeletedFromRemote = new HashMap<>(previousClusterState.metadata().indices());
        TRACE("trace"),
            blobStoreRepository,
                    blobStoreRepository.getNamedXContentRegistry()
        if (routingTableDiff != null) {
        final ClusterState.Builder clusterStateBuilder = ClusterState.builder(previousState);
    public void diffDownloadFailed() {
                (metadataBuilder) -> {
        } catch (IOException e) {
    private volatile AtomicBoolean isPublicationEnabled;
        remoteClusterStateCache = new RemoteClusterStateCache();
                        break;
        }
        }
                    manifest.getStateVersion()
        return stats;
import java.util.function.LongSupplier;
                    if (diff.getCustomMetadataDeleted() != null) {
                response.uploadedIndicesRoutingDiffMetadata = (UploadedMetadataAttribute) uploadedMetadata;
/**
            logger.error("Failure in downloading full cluster state. ", e);
     */
                    break;
        final Repository repository = repositoriesService.get().repository(remoteStoreRepo);
                                    fullClusterState.customs(),
                previousState,
    ) {
        }
                                clusterState.metadata().settings(),
            List<String> validChain = createClusterChain(latestManifests, clusterName);
 * The OpenSearch Contributors require contributions made to
        final Map<String, UploadedIndexMetadata> secondIndices = second.getIndices()
                    false
            + indicesRoutingToRead.size() + (readIndexRoutingTableDiff ? 1 : 0);
        List<Exception> exceptionList = Collections.synchronizedList(new ArrayList<>(totalReadTasks));
        readResults.forEach(remoteReadResult -> {
                customComponent,
        "cluster.remote_store.state.read_timeout",
        }
        stats.setCurrentApplicationDurationMs(applicationDurationMsSupplier.getAsLong());
                case RemoteIndexMetadata.INDEX:
        }
            updateTemplatesMetadata,
            ClusterState fullClusterState = readClusterStateInParallel(
                : null,
        if (previousClusterState == null) {
                            )
        remoteStateStats.stateFullIncomingPublicationFailed();
            routingTableDiff,
                    clusterState.metadata().clusterUUID(),
        Setting.Property.NodeScope
        Map<String, IndexMetadata> indexMetadataMap = new HashMap<>();
            final ClusterState clusterState;
        if (uploadSettingsMetadata) {
    public void fullIncomingPublicationFailed() {
        if (remotePublicationSetting == false) {
                .getDiffs()
        if (readSettingsMetadata) {
            );
        final String remoteStoreRepo = RemoteStoreNodeAttribute.getClusterStateRepoName(settings);
                // TODO: We should add metrics where transfer is timing out. [Issue: #10687]
        String clusterUUID,
            );
                routingTableDiff,
        ClusterMetadataManifest manifest,
                    // for manifest codec V1, we don't have the following objects to read, so not passing anything
            indicesToBeDeletedFromRemote.remove(indexMetadata.getIndex().getName());
        "cluster.remote_store.state.enabled",
                    indexMetadata,
    private RemoteIndexMetadataManager remoteIndexMetadataManager;
                    blobStoreRepository.getNamedXContentRegistry(),
            List<UploadedIndexMetadata> updatedIndices = diff.getIndicesUpdated().stream().map(idx -> {
                    clusterUUID,
            uploadTasks.add(TRANSIENT_SETTING_METADATA);
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.UploadedMetadataResults;
        if (topLevelClusterUUIDs.isEmpty()) {
            remoteGlobalMetadataManager.writeAsync(
            previousManifest.getIndices(),
        if (readDiscoveryNodes) {
            Map<String, ClusterMetadataManifest> latestManifests = remoteManifestManager.getLatestManifestForAllClusterUUIDs(
                    clusterState.metadata().clusterUUID(),
                return false;
                    for (String index : diff.getIndicesDeleted()) {
                        logger.error(
            }
        final boolean updateClusterBlocks = isPublicationEnabled.get() && !clusterState.blocks().equals(previousClusterState.blocks());
            updateDiscoveryNodes,
            true,
        if (!updateTransientSettingsMetadata) {
                true,
        remoteRoutingTableService.start();
            // This can occur only when there are no valid cluster UUIDs
                    clusterState.nodes(),
import org.opensearch.threadpool.ThreadPool;
                String.format(Locale.ROOT, "Error while fetching previous UUIDs from remote store for cluster name: %s", clusterName),
     * This method creates a valid cluster UUID chain.
                    blobStoreRepository.getCompressor(),
        metadataBuilder.version(manifest.getMetadataVersion());
            );
            final long startTimeNanos = relativeTimeNanosSupplier.getAsLong();
            remoteStateStats.stateDiffDownloadSucceeded();
        Property.Dynamic
            uploadedMetadataResults.uploadedDiscoveryNodes = previousManifest.getDiscoveryNodesMetadata();
        }
        final Map<String, ClusterMetadataManifest.UploadedIndexMetadata> allUploadedIndexMetadata = previousManifest.getIndices()
        return remoteClusterStateCache;
                    clusterState.metadata().coordinationMetadata(),
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V3;
            settings,
                assert uploadedIndexMetadataOptional.isPresent() == true;
                    "["
        List<IndexMetadata> indexToUpload,
            clusterState,
            );
        FAILURE("failure"),
            return;
            throw exception;
        }
                    clusterState.metadata().version(),
                new RemoteCustomMetadata(
                HASHES_OF_CONSISTENT_SETTINGS,
        clusterSettings.addSettingsUpdateConsumer(REMOTE_PUBLICATION_SETTING, this::setRemotePublicationSetting);
                TEMPLATES_METADATA,
        Property.Dynamic
            true
                    clusterState.metadata().transientSettings(),
                    case ClusterStateChecksum.COORDINATION_MD_CS:
import org.opensearch.cluster.node.DiscoveryNodes.Builder;
import org.opensearch.Version;
/*
            remoteClusterStateAttributesManager.getUpdatedCustoms(clusterState, previousClusterState, isPublicationEnabled.get(), false);
                        break;
                numIndicesUnchanged,
                                    DiffableUtils.getStringKeySerializer(),
                    "Timed out waiting to read cluster state from remote within timeout " + this.remoteStateReadTimeout
    }
        ParameterizedMessage metadataUpdateMessage = new ParameterizedMessage(
            );
                && (!routingTableDiff.provideDiff().getDiffs().isEmpty()
import org.opensearch.common.settings.Setting;
     *
                            + "Please check their latest manifest to decide which one you want to keep. Valid Cluster UUIDs: - %s",
            final IndexMetadata prevIndexMetadata = indicesToBeDeletedFromRemote.get(indexName);
            uploadTasks.add(TEMPLATES_METADATA);
            clusterSettings.get(REMOTE_PUBLICATION_SETTING)
                                clusterState.metadata().coordinationMetadata(),
            final IndexMetadata secondIndexMetadata = remoteIndexMetadataManager.getIndexMetadata(
                                fullClusterState.nodes().diff(clusterState.nodes())
                        String custom = remoteReadResult.getComponentName().split(CUSTOM_DELIMITER)[1];
        blobStoreTransferService = new BlobStoreTransferService(getBlobStore(), threadpool);
            // newState includes all the fields of cluster-state (includeEphemeral=true always)
            throw new IllegalArgumentException("previousClusterState cannot be null");
        invokeIndexMetadataUploadListeners(indexToUpload, prevIndexMetadataByName, latch, exceptionList);
    private boolean isMetadataEqual(ClusterMetadataManifest first, ClusterMetadataManifest second, String clusterName) {
    * Controls the fixed prefix for the cluster state path on remote store.
                    && !manifest.getDiffManifest().getIndicesRoutingDiffPath().isEmpty(),
        while (currentUUID != null && !ClusterState.UNKNOWN_UUID.equals(currentUUID)) {
                "Cluster state checksums do not match. Checksum from manifest {}, checksum from created cluster state {}. Entities failing validation {}",
                                    CUSTOM_VALUE_SERIALIZER
                false,
    ) {
    private final RemotePersistenceStats remoteStateStats;
    public RemoteClusterStateManifestInfo writeIncrementalMetadata(
            .map(ClusterMetadataManifest::getClusterUUID)
                            (System.nanoTime() - startTime)
                                "Failing Diff in customs md {}",
            indexRoutingTable -> indicesRouting.put(indexRoutingTable.getIndex().getName(), indexRoutingTable)
            publicationEnabled,
    }
        final boolean updateHashesOfConsistentSettings = isPublicationEnabled.get()
        clusterStateCustomsDiff.getDeletes().forEach(allUploadedClusterStateCustomsMap::remove);
    );
import org.opensearch.core.action.ActionListener;
        boolean readDiscoveryNodes,
                        + Arrays.toString(RemoteClusterStateValidationMode.values())
                        break;
                case CLUSTER_STATE_ATTRIBUTE:
                clusterUUID,
    private final Supplier<RepositoriesService> repositoriesService;
        final RemoteClusterStateManifestInfo manifestDetails = remoteManifestManager.uploadManifest(
        CountDownLatch latch,
        }
                        );
    public static final Setting<Boolean> REMOTE_STATE_DOWNLOAD_TO_SERVE_READ_API = Setting.boolSetting(
            // In case currentUUID's latest manifest is same as previous UUIDs latest manifest,
    Set<String> getAllClusterUUIDs(String clusterName) throws IOException {
                case CUSTOM_METADATA:
            previousManifest.getDiscoveryNodesMetadata(),
        AtomicReference<Diff<RoutingTable>> readIndexRoutingTableDiffResults = new AtomicReference<>();
            namedWriteableRegistry,
                validateClusterStateFromChecksum(manifest, clusterState, previousState.getClusterName().value(), localNodeId, false);
        assert clusterState != null : "Last accepted cluster state is not set";
            MANIFEST_CURRENT_CODEC_VERSION,
                    "updating metadata for [{}], changing version from [{}] to [{}]",
                        }
        }), latch);
        for (UploadedIndexMetadata uploadedIndexMetadata : first.getIndices()) {
        remoteClusterStateCleanupManager = new RemoteClusterStateCleanupManager(this, clusterService, remoteRoutingTableService);
            readClusterBlocks,
import org.opensearch.common.settings.Setting.Property;
                ),
        Map<String, UploadedMetadataAttribute> customToRead,
                                )
        clusterSettings.addSettingsUpdateConsumer(REMOTE_CLUSTER_STATE_CHECKSUM_VALIDATION_MODE_SETTING, this::setChecksumValidationMode);
        if (!previousManifest.isClusterUUIDCommitted() && committedManifestDetails.getClusterMetadataManifest().isClusterUUIDCommitted()) {
            readTransientSettingsMetadata,
            clusterStateBuilder.nodes(discoveryNodesBuilder.get().localNodeId(localNodeId));
            final IndexMetadata firstIndexMetadata = remoteIndexMetadataManager.getIndexMetadata(
            threadpool
            remoteGlobalMetadataManager.readAsync(
                        "The system has ended into multiple valid cluster states in the remote store. "
        RemoteClusterStateValidationMode(String mode) {
            METADATA_UPDATE_LOG_STRING,
                    entry.getValue().getAttributeName(),
import org.opensearch.cluster.metadata.Metadata;
                        logger.error(() -> new ParameterizedMessage("Failing Diff in routing table {}", routingTableDiff));
                    }
            RemoteStateTransferException exception = new RemoteStateTransferException("Exception during reading cluster state from remote");
        String clusterName,
        }
                                    (DiffableStringMap) clusterState.metadata().hashesOfConsistentSettings()
        boolean readClusterBlocks,
            .collect(Collectors.toList());
    }
            blobStoreRepository,
        return remoteStateStats.getUploadStats();
            return validChain.get(0);
                            () -> new ParameterizedMessage(
        logger.trace("response {}", response.uploadedIndicesRoutingMetadata.toString());
            publicationEnabled,
                default:
        });
                return ClusterState.UNKNOWN_UUID;
                    () -> new ParameterizedMessage(
            }
        indicesRoutingToUpload.forEach(indexRoutingTable -> {
                    blobStoreRepository.getCompressor(),
        final boolean updateDiscoveryNodes = isPublicationEnabled.get()
                    blobStoreRepository.getCompressor()
        }
        final DiffableUtils.MapDiff<String, ClusterState.Custom, Map<String, ClusterState.Custom>> clusterStateCustomsDiff =
                ex -> {
     * @return {@link RemoteClusterStateManifestInfo} object containing uploaded manifest detail
        LatchedActionListener<IndexRoutingTable> routingTableLatchedActionListener = new LatchedActionListener<>(
        LatchedActionListener<ClusterMetadataManifest.UploadedMetadata> listener = new LatchedActionListener<>(
        }
                exceptionList.add(ex);
                    manifest.getOpensearchVersion()
                        logger.error(
                    clusterStateBuilder.removeCustom(customType);
import org.apache.logging.log4j.Logger;
    /**
        // For migration case from codec V0 or V1 to V2, we have added null check on metadata attribute files,
            !remoteClusterStateValidationMode.equals(RemoteClusterStateValidationMode.NONE)
                    clusterState.metadata().clusterUUID(),
                    blobStoreRepository.getCompressor()
        Property.NodeScope,
     * manifest of a cluster UUID if the latest metadata for that cluster UUID is equivalent
            }
                listener
        );
                updatedIndexRouting.addAll(
            threadpool
    );
        LatchedActionListener<RemoteReadResult> listener = new LatchedActionListener<>(ActionListener.wrap(response -> {
                    trimmedUUIDs.remove(clusterUUID);
        }
    }
        return true;
     */
            clusterState,
                }
                durationMillis,
import org.opensearch.cluster.routing.RoutingTable;
    }
        );
    }
                new RemoteTemplatesMetadata(
            logger.error("Failure in downloading diff cluster state. ", e);
            !remoteClusterStateValidationMode.equals(RemoteClusterStateValidationMode.NONE)
        try {
    public RemoteClusterStateCleanupManager getCleanupManager() {
        boolean readTemplatesMetadata,
    /**
                    indexMetadata.getVersion()
                    metadataBuilder.persistentSettings((Settings) remoteReadResult.getObj());
            ActionListener.wrap(response -> {
                ),
                || !routingTableDiff.provideDiff().getDeletes().isEmpty()
        }
    // package private for testing
    }
                COORDINATION_METADATA,
            // more then 2 cluster manager nodes tried to become active cluster manager and published
                numIndicesUnchanged,
    }
                "Cluster state checksums do not match during full state read. Validation failed for " + failedValidation
                    custom,
        allUploadedClusterStateCustomsMap.putAll(uploadedMetadataResults.uploadedClusterStateCustomMetadataMap);
        }
            }
            threadpool
                listener
                listener
            updateTemplatesMetadata,
        int numIndicesUnchanged = 0;
                false,
            final long startTimeNanos = relativeTimeNanosSupplier.getAsLong();
        }
                readIndexRoutingTableResults.add(response);
                                )
                    namedWriteableRegistry
                "writing cluster state took [{}ms]; " + "wrote full state with [{}] indices, [{}] indicesRouting and global metadata",
        Optional<ClusterMetadataManifest> clusterMetadataManifest = remoteManifestManager.getLatestClusterMetadataManifest(
                throw new IllegalStateException("Unknown metadata component name " + name);
        this.downloadFromRemoteForReadAPI = new AtomicBoolean(clusterSettings.get(REMOTE_STATE_DOWNLOAD_TO_SERVE_READ_API));
        RemoteDownloadStats stats = (RemoteDownloadStats) remoteStateStats.getRemoteFullDownloadStats();
        );
                .build();
                }
        try {
                    + "wrote metadata for [{}] indices and skipped [{}] unchanged indices, coordination metadata updated : [{}], "
    private RemoteClusterStateAttributesManager remoteClusterStateAttributesManager;
                        logger.error(
                    break;
        String nodeId,
    }
                : null
                    blobStoreRepository.getNamedXContentRegistry()
            previousManifest.getClusterBlocksMetadata(),
    /**
    }
    /**
    public PersistedStateStats getDiffDownloadStats() {
     * invoked by the elected cluster manager when the remote cluster state is enabled.
            toUpload,
            previousState,
            } else {
            if (!remoteClusterStateValidationMode.equals(RemoteClusterStateValidationMode.NONE)
            numIndicesUpdated,
    private RemoteClusterStateValidationMode remoteClusterStateValidationMode;
        this.remoteGlobalMetadataManager = remoteGlobalMetadataManager;
    private final String CLUSTER_STATE_UPLOAD_TIME_LOG_STRING = "writing cluster state for version [{}] took [{}ms]";
    }
        metadataBuilder.clusterUUID(manifest.getClusterUUID());
                updatedCustomMetadata,
            }
            remoteClusterStateCache.putState(clusterState);
                uploadedIndexMetadata,
        Setting.Property.Dynamic,
                getIndexMetadataUploadActionListener(updatedIndexMetadataList, prevIndexMetadataByName, latch, exceptionList, listenerName)
                );
                        "listener={} : Invoked successfully with indexMetadataList={} prevIndexMetadataList={} tookTimeNs={}",
                        );
        final List<IndexRoutingTable> indicesRoutingToUpload = new ArrayList<>();
                updateSettingsMetadata,
import java.util.function.Function;
import org.opensearch.cluster.Diff;
                emptyMap(),
                new RemoteDiscoveryNodes(
import org.opensearch.cluster.coordination.PersistedStateStats;
        boolean uploadSettingsMetadata,
     * Used to specify if cluster state metadata should be published to remote store
        List<UploadedIndexMetadata> indicesToRead,
            } else if (name.contains(UploadedIndexMetadata.COMPONENT_PREFIX)) {
        RemoteClusterStateManifestInfo committedManifestDetails = remoteManifestManager.uploadManifest(
        String clusterUUID,
        final Map<String, UploadedMetadataAttribute> allUploadedCustomMap = new HashMap<>(previousManifest.getCustomMetadataMap());
        List<String> failedValidation = newClusterStateChecksum.getMismatchEntities(manifest.getClusterStateChecksum());
        for (final IndexMetadata indexMetadata : clusterState.metadata().indices().values()) {
            && (!routingTableDiff.provideDiff().getDiffs().isEmpty()
            ClusterState clusterState = clusterStateBuilder.stateUUID(manifest.getStateUUID())
        boolean includeEphemeral
                        String.join(", ", uploadTasks)
        if (remoteClusterStateValidationMode.equals(RemoteClusterStateValidationMode.FAILURE)
            );
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.clusterUUIDContainer;
    void validateClusterStateFromChecksum(
                    blobStoreRepository.getNamedXContentRegistry()
            if (firstIndexMetadata.equals(secondIndexMetadata) == false) {
                diff.isHashesOfConsistentSettingsUpdated(),
            }
            );
            CLUSTER_STATE_UPLOAD_TIME_LOG_STRING,
        ClusterState clusterState,
                new RemoteClusterStateCustoms(
                    .stream()
        final List<String> validChain = new ArrayList<>();
            exceptionList.forEach(e::addSuppressed);
                            newIndexMetadataList,
            }).collect(Collectors.toList());
                listener
                SETTING_METADATA,
        if (previousManifest == null) {
        assert isRemoteClusterStateConfigured(settings) : "Remote cluster state is not configured";
                    manifest,
            validChain.add(currentUUID);
                );
                manifest.getHashesOfConsistentSettings() != null,
        Consumer<RoutingTable> routingTableTransformer
     * @return Last valid cluster UUID
            latch
    private final List<IndexMetadataUploadListener> indexMetadataUploadListeners;
import java.util.Set;
            currentUUID = clusterUUIDGraph.get(currentUUID);
        return remoteStateStats;
                uploadedMetadataResults.uploadedIndexMetadata.size(),
            );
        public final String mode;
                    remoteIndexMetadataManager.getPathHashAlgoSetting(),
 * A Service which provides APIs to upload and download cluster metadata from remote store.
            remoteClusterStateCleanupManager.deleteStaleClusterUUIDs(clusterState, committedManifestDetails.getClusterMetadataManifest());
import org.opensearch.common.Nullable;
        List<IndexMetadataUploadListener> indexMetadataUploadListeners,
    }
                    remoteRoutingTableService.getUpdatedIndexRoutingTableMetadata(
 *
            updateSettingsMetadata,
import static org.opensearch.gateway.remote.model.RemoteCustomMetadata.CUSTOM_METADATA;
 *
                entry.getValue().getAttributeName(),
        allUploadedCustomMap.putAll(uploadedMetadataResults.uploadedCustomMetadataMap);
     */
            remoteRoutingTableService.getAsyncIndexRoutingWriteAction(
                            )
import org.opensearch.cluster.node.DiscoveryNodes;
                uploadedMetadataResults.uploadedIndicesRoutingMetadata.size()
    public void fullDownloadFailed() {
        this.remoteRoutingTableService.close();
                    ClusterState.builder(new ClusterName(clusterName)).build(),
        });
            logger.info("There is no valid previous cluster UUID. All cluster UUIDs evaluated are: {}", manifestsByClusterUUID.keySet());
    private void setRemotePublicationSetting(boolean remotePublicationSetting) {
            );
    private final String METADATA_UPDATE_LOG_STRING = "wrote metadata for [{}] indices and skipped [{}] unchanged "
            remoteStateStats.stateFullDownloadFailed();
        return Collections.unmodifiableSet(clusterUUIDMetadata.keySet());
    private final String nodeId;
            ),
            uploadTasks.add(indexMetadata.getIndex().getName());
        assert Objects.nonNull(indexMetadataUploadListeners) : "indexMetadataUploadListeners can not be null";
                topLevelClusterUUIDs,
            ClusterState.EMPTY_STATE,
        true,
        Consumer<Metadata.Builder> metadataTransformer,
                    Locale.ROOT,
                TRANSIENT_SETTING_METADATA,
            List<UploadedIndexMetadata> updatedIndexRouting = new ArrayList<>();
    private final String remotePathPrefix;
    }
            );
        ClusterStateDiffManifest clusterStateDiffManifest = new ClusterStateDiffManifest(
            threadpool
     *  Debug: Validation enabled but only matches checksum and logs failing entities.
                    namedWriteableRegistry,
            uploadedMetadataResults.uploadedTransientSettingsMetadata = previousManifest.getTransientSettingsMetadata();
            readHashesOfConsistentSettings,
            .filter(this::isValidClusterUUID)
                RemoteStateTransferException ex = new RemoteStateTransferException(
                emptyList(),
                    clusterUUID,
                    break;
            RemoteStateTransferException ex = new RemoteStateTransferException(
                    remoteIndexMetadataManager.getPathTypeSetting(),
                    manifest.getCustomMetadataMap(),
                    ClusterState.builder(new ClusterName(clusterName)).build(),
            uploadTasks.add(COORDINATION_METADATA);
                // pass component name as cluster-state-custom--<custom_name>, so that we can interpret it later
                        Locale.ROOT,
                new RemoteClusterBlocks(
                        new ParameterizedMessage(
    public void start() {
            ActionListener.wrap(response -> {
                throw ex;
            if (previousVersion == null || indexMetadata.getVersion() != previousVersion) {
        boolean readTransientSettingsMetadata,
        if (uploadHashesOfConsistentSettings) {
                response.uploadedIndexMetadata.add((UploadedIndexMetadata) uploadedMetadata);
        boolean includeEphemeral,
            previousManifest.getDiffManifest(),
                durationMillis,
            || Metadata.isTemplatesMetadataEqual(previousClusterState.metadata(), clusterState.metadata()) == false;
            clusterState.metadata()
                    blobStoreRepository.getNamedXContentRegistry()
                return uploadedIndexMetadataOptional.get();
                "writing cluster state for version [{}] took [{}ms]; "
        clusterSettings.addSettingsUpdateConsumer(REMOTE_STATE_READ_TIMEOUT_SETTING, this::setRemoteStateReadTimeout);
            if (manifest.onOrAfterCodecVersion(CODEC_V2)) {
        }
import java.util.Objects;
            // index present in current cluster state
                    break;
            .filter(clusterUUID -> !clusterUUIDGraph.containsValue(clusterUUID))
                    localNodeId,
     * Fetch latest ClusterState from remote, including global metadata, index metadata and cluster state version
import org.opensearch.gateway.remote.model.RemoteTransientSettingsMetadata;
        }
        Map<String, ClusterMetadataManifest.UploadedMetadata> results = new ConcurrentHashMap<>(totalUploadTasks);
    /**
        boolean readIndexRoutingTableDiff,
            ).uploadedCoordinationMetadata;
                new RemoteIndexMetadata(
                            )
        }
                clusterState.version(),
        this.remoteStateReadTimeout = remoteStateReadTimeout;
        RemoteDownloadStats stats = (RemoteDownloadStats) remoteStateStats.getRemoteDiffDownloadStats();
                    false,
     */
        }
            clusterStateCustomsDiff.getUpserts(),
                }
        if (clusterState.nodes().isLocalNodeElectedClusterManager() == false) {
        return remoteManifestManager;
    }
        try {
                    clusterState.metadata().version(),
        ;
     *
        boolean readDiscoveryNodes,
     * @param clusterName The cluster name for which previous cluster UUID is to be fetched
            return null;
            clusterName,
        });
import org.opensearch.cluster.routing.remote.RemoteRoutingTableServiceFactory;
        );
                manifestsByClusterUUID,
    /**
import java.util.concurrent.atomic.AtomicBoolean;
        Supplier<RepositoriesService> repositoriesService,
                    RemoteClusterStateUtils.getFormattedIndexFileName(indexMetadata.getUploadedFilename()),
        routingTableTransformer.accept(newRoutingTable);
                    ex
                );
            // 2 cluster UUIDs which followed the same previous UUID.
            return null;
                                DiffableUtils.diff(
        } catch (InterruptedException ex) {
                                    DiffableUtils.getStringKeySerializer(),
import java.util.concurrent.atomic.AtomicReference;
                        newIndexMetadataList,
                durationMillis,
                logger.trace(
                    false,
            exceptionList.forEach(exception::addSuppressed);
                        );
            indicesRoutingToUpload,
                diff.isDiscoveryNodesUpdated(),
        }
            if (manifestsByClusterUUID.size() == manifestsByClusterUUIDTrimmed.size()) {
        boolean uploadDiscoveryNodes,
import org.opensearch.repositories.RepositoriesService;
                return stateFromCache;
        clusterSettings.addSettingsUpdateConsumer(REMOTE_STATE_DOWNLOAD_TO_SERVE_READ_API, this::setRemoteDownloadForReadAPISetting);
                listener
            previousManifest.getCustomMetadataMap(),
        );
                "Cluster state checksums do not match during diff read. Validation failed for " + failedValidation
                        manifest.getClusterTerm(),
            routingTableDiff
        + "indices, coordination metadata updated : [{}], settings metadata updated : [{}], templates metadata "
        List<Exception> exceptionList = Collections.synchronizedList(new ArrayList<>(totalUploadTasks));
            clusterState,
        Map<String, UploadedMetadataAttribute> clusterStateCustomToRead,
                            )
    private ClusterSettings clusterSettings;
                indexRouting.getUploadedFilename(),
    public static final Setting<Boolean> REMOTE_PUBLICATION_SETTING = Setting.boolSetting(
import java.util.concurrent.TimeUnit;
        indicesToBeDeletedFromRemote.keySet().forEach(allUploadedIndexMetadata::remove);
                        logger.error(
    private void setSlowWriteLoggingThreshold(TimeValue slowWriteLoggingThreshold) {
        this.slowWriteLoggingThreshold = slowWriteLoggingThreshold;
            );
            );
                    blobStoreRepository.getCompressor(),
                    case ClusterStateChecksum.SETTINGS_MD_CS:
            logger.warn(
            remoteGlobalMetadataManager.readAsync(
    BlobStoreRepository getBlobStoreRepository() {
                    blobStoreRepository.getCompressor()
                    manifest.getClusterTerm(),
        if (commitVotingConfig) {
                manifestDetails.getClusterMetadataManifest().getStateVersion(),
                                    clusterState.metadata().customs(),
                readIndexRoutingTableDiffResults.set(response);
        }
            if (secondUploadedIndexMetadata == null) {
        REMOTE_STATE_READ_TIMEOUT_DEFAULT,
            true,
                        break;
                    clusterState.version(),
                    )
                }
import org.opensearch.common.settings.Settings;
import java.util.Collections;
            );
    ) throws IOException {
            : 0) + (readTemplatesMetadata ? 1 : 0) + (readDiscoveryNodes ? 1 : 0) + (readClusterBlocks ? 1 : 0)
                manifest.getCoordinationMetadata() != null,
    }
import java.util.Optional;
    private BlobStoreRepository blobStoreRepository;
        boolean includeEphemeral
                ),
            .stream()
    /**
            uploadedMetadataResults,
            }
            remoteClusterStateAttributesManager.writeAsync(
            logger.error("Local node is not elected cluster manager. Exiting");
     * This method uploads entire cluster state metadata to the configured blob store. For now only index metadata upload is supported. This method should be
                indexMetadata.getIndex().getName(),
     * @return A manifest object which contains the details of uploaded entity metadata.
                        "Found cluster state in cache for term {} and version {}",
        Map<String, IndexMetadata> prevIndexMetadataByName,
                ? new ClusterStateChecksum(clusterState, threadpool)
            () -> new ParameterizedMessage(
            );
            if (includeEphemeral) {
            .getCustomsDiff(clusterState, previousClusterState, firstUploadForSplitGlobalMetadata, isPublicationEnabled.get());
            // remove the deleted cluster state customs from the metadata
        }
            return createClusterChain(manifestsByClusterUUIDTrimmed, clusterName);
            assert includeEphemeral == true;
    public RemoteClusterStateManifestInfo writeFullMetadata(ClusterState clusterState, String previousClusterUUID) throws IOException {
            }
     */
        final Map<String, ClusterMetadataManifest> latestManifestsByClusterUUID,
        this.downloadFromRemoteForReadAPI.set(remoteDownloadForReadAPISetting);
            remoteStateStats.stateFullDownloadValidationFailed();
            .stateUUID(manifest.getStateUUID());
        return remoteManifestManager.getRemoteClusterMetadataManifestByFileName(clusterUUID, fileName);
    private RemoteGlobalMetadataManager remoteGlobalMetadataManager;
                CLUSTER_BLOCKS,
     *
        boolean uploadHashesOfConsistentSettings,
                    manifest.getSettingsMetadata() != null,
        if (topLevelClusterUUIDs.size() > 1) {
                        );
import org.opensearch.common.blobstore.BlobContainer;
        if (manifest.getOpensearchVersion() != Version.CURRENT) {
        CountDownLatch latch,
 * @opensearch.internal
                && manifest.getClusterStateChecksum() != null) {
                indexRoutingTable,
    private final Settings settings;
            remoteGlobalMetadataManager.writeAsync(
            remoteRoutingTableService.getAsyncIndexRoutingReadAction(
        RemoteClusterStateValidationMode.NONE.name(),
            throw new IllegalArgumentException("previousManifest cannot be null");
     * @param manifestsByClusterUUID Map of latest ClusterMetadataManifest for every cluster UUID
        String clusterUUID,
import java.util.Arrays;
        List<UploadedIndexMetadata> indicesRoutingToRead,
            previousManifest.getClusterStateCustomMap()
        this.remoteClusterStateValidationMode = remoteClusterStateValidationMode;
        ClusterState previousState,
        boolean firstUploadForSplitGlobalMetadata = !previousManifest.hasMetadataAttributesFiles();
    ThreadPool getThreadpool() {
        UploadedMetadataResults uploadedMetadataResults = new UploadedMetadataResults(
                        discoveryNodesBuilder.set(DiscoveryNodes.builder((DiscoveryNodes) remoteReadResult.getObj()));
        "cluster.remote_store.state.path.prefix",
        if (!updateTemplatesMetadata) {
                    false,
            throw new IllegalArgumentException("clusterState cannot be null");
                emptyMap(),
    }
                    blobStoreRepository.getCompressor(),
            listener.onUpload(
            previousManifest.getIndicesRouting(),
            && Metadata.isHashesOfConsistentSettingsEqual(previousClusterState.metadata(), clusterState.metadata()) == false;
                updatedClusterStateCustom,
    // ToXContent Params with gateway mode.
                    case ClusterStateChecksum.HASHES_MD_CS:
                new RemoteTransientSettingsMetadata(
    public RemoteManifestManager getRemoteManifestManager() {
            indicesRoutingToUpload.size()
            .routingTable(newRoutingTable)
                // cache only if the entire cluster-state is present
        }
        ClusterState previousClusterState,
        }
     * This method uploads the diff between the previous cluster state and the current cluster state. The previous manifest file is needed to create the new
     *
            } else if (name.startsWith(CUSTOM_METADATA)) {
            );
                (routingTable) -> {
                    String.join(", ", results.keySet())
        return clusterStateBuilder.build();
import org.opensearch.gateway.remote.model.RemoteTemplatesMetadata;
import org.opensearch.cluster.metadata.Metadata.XContentContext;
        // todo clusterName can be set as final in the constructor
                case HASHES_OF_CONSISTENT_SETTINGS:
                false,
    private RemoteManifestManager remoteManifestManager;
                        break;
        boolean readSettingsMetadata,
                false,
            clusterSettings,
        LongSupplier applicationDurationMsSupplier
        ClusterMetadataManifest manifest,
     * to the latest metadata of its previous UUID.
            if (diff.getClusterStateCustomDeleted() != null) {
                        logger.error(
        }
        Map<String, IndexMetadata> prevIndexMetadataByName = new HashMap<>();
                listener
            }
                "writing cluster state took [{}ms] which is above the warn threshold of [{}]; "
                manifest,
                localNodeId,
            !remoteClusterStateValidationMode.equals(RemoteClusterStateValidationMode.NONE)
                    emptyMap(),
        for (UploadedIndexMetadata indexMetadata : indicesToRead) {
    /**
                                DiffableUtils.diff(
                if (includeEphemeral
            manifest,
        this.settings = settings;
                ClusterState.builder(new ClusterName(clusterName)).build(),
                        );
        return committedManifestDetails;
            clusterName,
        if (readTemplatesMetadata) {
            if (latch.await(this.remoteStateReadTimeout.getMillis(), TimeUnit.MILLISECONDS) == false) {
                new RemoteCoordinationMetadata(
        clusterSettings = clusterService.getClusterSettings();
                slowWriteLoggingThreshold,
        remoteStateStats.stateDiffIncomingPublicationFailed();
                clusterName
                manifest.getIndices(),
        // remove the data for removed custom/indices
        }
                RemoteClusterBlocks.CLUSTER_BLOCKS,
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
            updateCoordinationMetadata,
    public static final ToXContent.Params FORMAT_PARAMS;
                    )
        // If file is empty and codec is 1 then write global metadata.
    public ClusterState getClusterStateUsingDiff(ClusterMetadataManifest manifest, ClusterState previousState, String localNodeId) {
    public ClusterState getClusterStateForManifest(
                Version.CURRENT,
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedIndexMetadata;
                        + "]"
        this.remoteIndexMetadataManager = remoteIndexMetadataManager;
        final RemoteClusterStateManifestInfo manifestDetails = remoteManifestManager.uploadManifest(
            remoteIndexMetadataManager.writeAsync(
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.isRemoteStoreClusterStateEnabled;
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedMetadataAttribute;
                clusterUUIDs
                    if (remoteReadResult.getComponentName().equals(DISCOVERY_NODES)) {
            publicationEnabled ? clusterState.customs() : Collections.emptyMap(),
                listener
            throw e;
        if (!updateSettingsMetadata) {
            logger.error("Local node is not elected cluster manager. Exiting");
    void setRemoteGlobalMetadataManager(RemoteGlobalMetadataManager remoteGlobalMetadataManager) {
            null,
    private volatile AtomicBoolean downloadFromRemoteForReadAPI;
                    includeEphemeral
    public void close() throws IOException {
     */
        boolean updateTemplatesMetadata = firstUploadForSplitGlobalMetadata
                failedValidation
        remoteClusterStateAttributesManager = new RemoteClusterStateAttributesManager(
                                fullClusterState.metadata().coordinationMetadata()
        }
            );
        List<IndexMetadata> toUpload = new ArrayList<>();
            blobStoreRepository,
                logger.debug(() -> new ParameterizedMessage("Successfully read index-routing for index {}", response.getIndex().getName()));
        metadataBuilder.indices(indexMetadataMap);
                case TEMPLATES_METADATA:
                new RemoteClusterBlocks(
                                    DiffableUtils.getStringKeySerializer()
                },
                    false,
        boolean updateCoordinationMetadata = firstUploadForSplitGlobalMetadata
            } else if (RemoteRoutingTableDiff.ROUTING_TABLE_DIFF_FILE.equals(name)) {
import org.opensearch.cluster.coordination.CoordinationMetadata;
                    exceptionList.add(ex);
                );
            readDiscoveryNodes,
                ),
                    && !remoteClusterStateValidationMode.equals(RemoteClusterStateValidationMode.NONE)
    }
                updateSettingsMetadata,
        assert repository instanceof BlobStoreRepository : "Repository should be instance of BlobStoreRepository";
                customsDiff.getUpserts().size()
                case COORDINATION_METADATA:
            remoteRoutingTableService.getIndicesRouting(clusterState.getRoutingTable()),
                            () -> new ParameterizedMessage(
     *  Trace: Matches checksum and downloads full cluster state to find diff in failing entities. Only logs failures.
            publicationEnabled,
                    break;
                    includeEphemeral && manifest.getHashesOfConsistentSettings() != null,
                response.uploadedCustomMetadataMap.put(
                    new UploadedMetadataAttribute(custom, uploadedMetadata.getUploadedFilename())
                ),
    /**
                    metadataBuilder.templates((TemplatesMetadata) remoteReadResult.getObj());
                : null,
        return blobStoreRepository;
                    )
        }
            (metadataBuilder) -> {},
                customsDiff.getUpserts().size()
        remoteIndexMetadataManager = new RemoteIndexMetadataManager(
            (routingTable) -> {}
                listener
        int numIndicesUpdated = 0;
            newRoutingTable = routingTableDiff.apply(previousState.getRoutingTable());
        } else {
import org.opensearch.gateway.remote.model.RemoteIndexMetadata;
                String custom = name.split(DELIMITER)[0].split(CUSTOM_DELIMITER)[1];
                                )
                                ((DiffableStringMap) fullClusterState.metadata().hashesOfConsistentSettings()).diff(
                prevIndexMetadataByName.put(indexName, prevIndexMetadata);
                    break;
                false,
        List<UploadedIndexMetadata> indicesToRead,
                    manifest.getIndices(),
            );
        }
    }
                    } else if (remoteReadResult.getComponentName().startsWith(CLUSTER_STATE_CUSTOM)) {
                .routingTable(updatedClusterState.routingTable())
            }),
            );
                    blobStoreRepository.getNamedXContentRegistry()
            clusterStateDiffManifest,
                uploadedMetadataResults.uploadedIndexMetadata.size(),
                            )
                routingTableLatchedActionListener,
     * cluster state.
                listener
                ),
            localNodeId,
import org.apache.logging.log4j.LogManager;
                listener
                );
                new RemoteHashesOfConsistentSettings(
        }
            uploadTasks.add(key);
                    manifest.getTemplatesMetadata() != null,
        indexToUpload.forEach(indexMetadata -> {
                    blobStoreRepository.getCompressor(),
    public static final String REMOTE_PUBLICATION_SETTING_KEY = "cluster.remote_store.publication.enabled";
        boolean readSettingsMetadata,
    private static final Logger logger = LogManager.getLogger(RemoteClusterStateService.class);
                        + "supported modes are ["
        boolean readCoordinationMetadata,
                "Reading cluster state on version {} from manifest uploaded with version {}",
import org.opensearch.cluster.routing.remote.RemoteRoutingTableService;
            return false;
    private final NamedWriteableRegistry namedWriteableRegistry;
            blobStoreRepository,
            remoteStateStats.stateFullDownloadSucceeded();
        UploadedMetadataAttribute uploadedCoordinationMetadata = previousManifest.getCoordinationMetadata();
    private volatile TimeValue slowWriteLoggingThreshold;
                updateCoordinationMetadata,
            uploadedMetadataResults.uploadedSettingsMetadata = previousManifest.getSettingsMetadata();
                    includeEphemeral && manifest.getTransientSettingsMetadata() != null,
            return clusterState;
        if (readIndexRoutingTableDiff) {
                        Diff<RoutingTable> routingTableDiff = fullClusterState.routingTable().diff(clusterState.routingTable());
            if (diff.getCustomMetadataUpdated() != null) {
        return this.downloadFromRemoteForReadAPI.get();
        boolean uploadTransientSettingMetadata,
            throw ex;
        }
    @Override
                exceptionList.add(ex);
                logger.error(
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        for (Map.Entry<String, UploadedMetadataAttribute> entry : customToRead.entrySet()) {
                    clusterState.metadata().clusterUUID(),
                            () -> new ParameterizedMessage(
        customsDiff.getDeletes().forEach(allUploadedCustomMap::remove);
        List<IndexRoutingTable> readIndexRoutingTableResults = Collections.synchronizedList(new ArrayList<>());
                manifest.getIndicesRouting(),
        }
        logger.info("Known UUIDs found in remote store : [{}]", validChain);
                    emptyMap(),
                throw new IllegalStateException(
                    clusterState.metadata().clusterUUID(),
        if (!updateClusterBlocks) {
        Setting.Property.NodeScope
        ClusterService clusterService,
                true
                String.format(Locale.ROOT, "Exception during transfer of following metadata to Remote - %s", String.join(", ", uploadTasks))
        for (String clusterUUID : validClusterUUIDs) {
            remoteGlobalMetadataManager.writeAsync(
import java.util.concurrent.ConcurrentHashMap;
                manifest.getOpensearchVersion()
        long startTime = System.nanoTime();
            return Collections.emptySet();
    }
                    value,
            && clusterState.getNodes().delta(previousClusterState.getNodes()).hasChanges();
            } else if (name.startsWith(CLUSTER_STATE_CUSTOM)) {
            }
        assert previousManifest != null : "Last cluster metadata manifest is not set";
                    manifest.getOpensearchVersion()
            repositoriesService,
    private final ThreadPool threadpool;
        LatchedActionListener<Diff<RoutingTable>> routingTableDiffLatchedActionListener = new LatchedActionListener<>(
        remoteStateStats.stateUploadTook(durationMillis);
        uploadedMetadataResults.uploadedIndicesRoutingMetadata = remoteRoutingTableService.getAllUploadedIndicesRouting(
                                DiffableUtils.diff(
    }
            );
        clusterStateCustomToUpload.forEach((key, value) -> {
                ex
                manifest.getSettingsMetadata() != null,
        }, ex -> {
        String clusterName,
     *  None: Validation will be disabled.
                    includeEphemeral && manifest.getClusterBlocksMetadata() != null,
                        prevIndexMetadataByName.values(),
            prevIndexMetadataByName,
    public PersistedStateStats getFullDownloadStats() {
                    clusterState.version(),
     *  Failure: Throws exception on failing validation.
            // download full cluster state and match against state created for the failing entities
                response.uploadedHashesOfConsistentSettings = (UploadedMetadataAttribute) uploadedMetadata;
            updateClusterBlocks,
    public static final Setting<TimeValue> REMOTE_STATE_READ_TIMEOUT_SETTING = Setting.timeSetting(
                case SETTING_METADATA:
        if (!exceptionList.isEmpty()) {
            logger.info(
            }
    void setRemoteClusterStateAttributesManager(RemoteClusterStateAttributesManager remoteClusterStateAttributeManager) {
import org.opensearch.index.translog.transfer.BlobStoreTransferService;
                indexMetadata.getIndexName(),
            remoteClusterStateAttributesManager.readAsync(
                manifest.getClusterUUID(),
        if (first.getIndices().size() != second.getIndices().size()) {
                        listenerName,
                    false,
                }
        Settings settings,
                listener
            clusterState.getRoutingTable()
                    clusterState.metadata().templatesMetadata(),
                                    fullClusterState.metadata().indices(),
                                fullClusterState.blocks().diff(clusterState.blocks())
                    manifest.getDiscoveryNodesMetadata().getUploadedFilename(),
        ParameterizedMessage clusterStateUploadTimeMessage = new ParameterizedMessage(
                response.uploadedClusterStateCustomMetadataMap.put(
        Map<String, ClusterState.Custom> clusterStateCustomToUpload,
        ClusterMetadataManifest manifest,
        List<Exception> exceptionList,
            );
        );
            ClusterMetadataManifest currentManifest = trimmedUUIDs.get(clusterUUID);
    );
            uploadedMetadataResults.uploadedTemplatesMetadata = previousManifest.getTemplatesMetadata();
                numIndicesUpdated++;
        List<String> uploadTasks = Collections.synchronizedList(new ArrayList<>(totalUploadTasks));
        }
                        manifest.getIndicesRouting()
                    }
                manifest.getClusterStateChecksum(),
    RemoteClusterStateCache getRemoteClusterStateCache() {
            }
            previousManifest.getPreviousClusterUUID(),
        try {
            indicesRoutingToRead,
                listener
import static org.opensearch.gateway.remote.model.RemoteTemplatesMetadata.TEMPLATES_METADATA;
            logger.debug(
        RoutingTable newRoutingTable = new RoutingTable(manifest.getRoutingTableVersion(), indicesRouting);
        if (isFullStateDownload && remoteClusterStateValidationMode.equals(RemoteClusterStateValidationMode.FAILURE)) {
import java.util.Locale;
            throw exception;
                        );
    public static final Setting<Boolean> REMOTE_CLUSTER_STATE_ENABLED_SETTING = Setting.boolSetting(
        logger.error(
                        logger.error(
    }
            ClusterName.CLUSTER_NAME_SETTING.get(settings).value()
    );
                logger.debug(
        // update the map if the metadata was uploaded
        Map<String, IndexMetadata> prevIndexMetadataByName,
        return response;
                listener
     * @return Trimmed map of manifests
                updateTemplatesMetadata,
                listener
                () -> new ParameterizedMessage(
        false,
                        metadataBuilder.putCustom(remoteReadResult.getComponentName(), (Metadata.Custom) remoteReadResult.getObj());
                ),
            IOUtils.close(blobStoreRepository);
                updatedIndices,
                .forEach((k, v) -> indicesRoutingToUpload.add(clusterState.getRoutingTable().index(k)));
            }
                Metadata.Builder mb = Metadata.builder(remoteGlobalMetadataManager.getGlobalMetadata(manifest.getClusterUUID(), manifest));
                                "Failing Diff in transient settings md. current md {}, full state md {}",
        }
    }
                String.format(Locale.ROOT, "Timed out waiting for transfer of metadata to complete - %s", String.join(", ", uploadTasks)),
            throw new IllegalStateException(
            routingTableDiff.provideDiff().getUpserts().forEach((k, v) -> indicesRoutingToUpload.add(v));
        return manifest.isClusterUUIDCommitted();
            .collect(Collectors.toMap(UploadedIndexMetadata::getIndexName, Function.identity()));
        if (readTransientSettingsMetadata) {
        boolean publicationEnabled = isPublicationEnabled.get();
                    clusterState.metadata().clusterUUID(),
                    clusterUUID,
            previousClusterState.metadata(),
            readTemplatesMetadata,
    /**
            ActionListener.wrap(
                newClusterStateChecksum,
                    clusterState.metadata().persistentSettings(),
import static org.opensearch.gateway.remote.model.RemotePersistentSettingsMetadata.SETTING_METADATA;
        boolean readClusterBlocks,
        });
                logger.error("Failed to read routing table diff from remote", ex);
            null
    }
            assert validClusterManifests.isEmpty() : "There are no top level cluster UUIDs even when there are valid cluster UUIDs";
            );
                                fullClusterState.metadata().settings()
    }
     * @return List of cluster UUIDs. The first element is the most recent cluster UUID in the chain
            }, ex -> {
                            )
import org.opensearch.cluster.DiffableUtils;
    public void writeMetadataFailed() {
        }
        return manifestDetails;
        int totalUploadTasks = indexToUpload.size() + indexMetadataUploadListeners.size() + customToUpload.size()
                new RemoteTemplatesMetadata(
        List<IndexRoutingTable> indicesRoutingToUpload,
    public String getLastKnownUUIDFromRemote(String clusterName) {
                    manifest.getOpensearchVersion()
            String customComponent = String.join(CUSTOM_DELIMITER, CUSTOM_METADATA, key);
            durationMillis
            ActionListener.wrap((ClusterMetadataManifest.UploadedMetadata uploadedMetadata) -> {
        ClusterMetadataManifest previousManifest
    public static final Setting<String> CLUSTER_REMOTE_STORE_STATE_PATH_PREFIX = Setting.simpleString(
        final StringKeyDiffProvider<IndexRoutingTable> routingTableDiff = remoteRoutingTableService.getIndicesRoutingMapDiff(
                            )
                listener
                    manifest.getClusterUUID(),
                || !routingTableDiff.provideDiff().getUpserts().isEmpty())) {
import org.opensearch.cluster.metadata.IndexMetadata;
            );
                    manifest.getOpensearchVersion()
    /**
        if (results.size() != uploadTasks.size()) {
        final long startTimeNanos = relativeTimeNanosSupplier.getAsLong();
                    } else if (remoteReadResult.getComponentName().equals(CLUSTER_BLOCKS)) {
                    includeEphemeral ? manifest.getClusterStateCustomMap() : emptyMap(),
                new RemoteCoordinationMetadata(
                    case ClusterStateChecksum.CUSTOM_MD_CS:
     * @param clusterUUID uuid of cluster state to refer to in remote
                                    clusterState.customs(),
import org.opensearch.gateway.remote.model.RemoteClusterStateManifestInfo;
        }
            // that means it was restored from previousUUID and no IndexMetadata update was performed on it.
        public static RemoteClusterStateValidationMode parseString(String mode) {
import org.opensearch.common.settings.ClusterSettings;
     * @param clusterName name of the cluster
            remoteStateStats.stateDiffDownloadValidationFailed();
            || Metadata.isCoordinationMetadataEqual(previousClusterState.metadata(), clusterState.metadata()) == false;
            remoteClusterStateAttributesManager.readAsync(
                        ),
import org.opensearch.gateway.remote.routingtable.RemoteRoutingTableDiff;
            uploadedMetadataResults,
            remoteRoutingTableService.getAsyncIndexRoutingTableDiffReadAction(
        this.threadpool = threadPool;
                    clusterUUID,
                case TRANSIENT_SETTING_METADATA:
                    blobStoreRepository.getCompressor(),
import org.opensearch.core.xcontent.ToXContent;
            null
                );
                    // remove the deleted metadata customs from the metadata
        long version
            uploadedMetadataResults.uploadedCoordinationMetadata = previousManifest.getCoordinationMetadata();
            includeEphemeral,
        }
        return this.isPublicationEnabled.get();
            // If the valid cluster UUIDs are more that 1, it means there was some race condition where
                    blobStoreRepository.getCompressor(),
            clusterSettings,
                switch (failedEntity) {
                                fullClusterState.metadata().templatesMetadata().diff(clusterState.metadata().templatesMetadata())
        );
            routingTableDiff.provideDiff()
    public ClusterState getLatestClusterState(String clusterName, String clusterUUID, boolean includeEphemeral) throws IOException {
                    || !routingTableDiff.provideDiff().getUpserts().isEmpty())) ? 1 : 0);
import org.opensearch.gateway.remote.model.RemotePersistentSettingsMetadata;
     *
import static java.util.Collections.emptyList;
                    case ClusterStateChecksum.TRANSIENT_SETTINGS_MD_CS:
                logger.debug("Successfully read routing table diff component from remote");
                    blobStoreRepository.getCompressor(),
        }
            remoteGlobalMetadataManager.readAsync(
                        logger.error(
            throw exception;
import java.io.IOException;
            this.isPublicationEnabled.set(isRemoteStoreClusterStateEnabled(settings) && isRemoteRoutingTableConfigured(settings));
                ),
                    clusterUUID,
            remoteGlobalMetadataManager.readAsync(
    public RemoteClusterStateService(
                && RemoteStoreNodeAttribute.isRemoteStoreClusterStateEnabled(settings)
import java.util.function.Consumer;
                // component name for custom metadata will look like custom--<metadata-attribute>
        );
            }),
                ? new ClusterStateChecksum(clusterState, threadpool)
                                "Failing Diff in templates md{}",
        boolean isFullStateDownload
        boolean readTemplatesMetadata,
                exceptionList.add(ex);
    public RemotePersistenceStats getRemoteStateStats() {
 */
        );
            } else if (COORDINATION_METADATA.equals(name)) {
            );
            uploadedCoordinationMetadata = writeMetadataInParallel(
                            prevIndexMetadataByName.values(),
        }
                    && manifest.getClusterStateChecksum() != null) {
                            () -> new ParameterizedMessage(
            publicationEnabled,
            );
                        );
        return this.remoteRoutingTableService;
                numIndicesUpdated,
            throw new IllegalStateException(
                    manifest,
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.isRemoteRoutingTableConfigured;
            clusterStateDiffManifest,
     * Fetch latest ClusterMetadataManifest from remote state store
                    key,
            }
import java.util.HashMap;
import org.opensearch.cluster.ClusterName;
        );
import static java.util.Collections.emptyMap;
                                "Failing Diff in cluster state customs {}",
import org.opensearch.common.blobstore.BlobStore;
                TEMPLATES_METADATA,
            throw new RemoteStateTransferException(
                                "Failing Diff in hashes md {}",
            }),
        });
                for (String customType : diff.getClusterStateCustomDeleted()) {
                listener
                    metadataBuilder.coordinationMetadata((CoordinationMetadata) remoteReadResult.getObj());
        }
            remoteGlobalMetadataManager.readAsync(
            Set<String> clusterUUIDs = getAllClusterUUIDs(clusterName);
     */
            previousManifest.getHashesOfConsistentSettings(),
        Map<String, BlobContainer> clusterUUIDMetadata = clusterUUIDContainer(blobStoreRepository, clusterName).children();
            emptyMap(),
            clusterState,
                    String.format(
            readIndexRoutingTableDiff,
        }
        CountDownLatch latch = new CountDownLatch(totalReadTasks);
            clusterState,
                new RemoteTransientSettingsMetadata(
        );
    /**
            );
            final Map<String, ClusterMetadataManifest> manifestsByClusterUUIDTrimmed = trimClusterUUIDs(
        readIndexRoutingTableResults.forEach(
                response.uploadedClusterBlocks = (UploadedMetadataAttribute) uploadedMetadata;
            uploadTasks.add(SETTING_METADATA);
                        break;
                    if (includeEphemeral || (!includeEphemeral && metadataCustom.context().contains(XContentContext.GATEWAY))) {
        if (uploadClusterBlock) {
            .version(manifest.getStateVersion())
            false
        }
                    }
    private void setRemoteDownloadForReadAPISetting(boolean remoteDownloadForReadAPISetting) {
                    .findFirst();
    }
import org.opensearch.cluster.ClusterState;
    public enum RemoteClusterStateValidationMode {
                    case ClusterStateChecksum.TEMPLATES_MD_CS:
            && routingTableDiff.provideDiff() != null
        Map<String, IndexMetadata> prevIndexMetadataByName,
                slowWriteLoggingThreshold,
    }
            } else if (RemoteClusterBlocks.CLUSTER_BLOCKS.equals(uploadedMetadata.getComponent())) {
                clusterState.term(),
                )
            logger.error("Failed to read cluster state from remote", ex);
            ? 1
            // Here we compare the manifest of current UUID to that of previous UUID
        boolean readIndexRoutingTableDiff,
        return manifestDetails;
                );
import static org.opensearch.gateway.remote.model.RemoteClusterStateCustoms.CLUSTER_STATE_CUSTOM;
            }
                        topLevelClusterUUIDs
        } catch (InterruptedException e) {
                        metadataBuilder.remove(index);
                                "Failing Diff in cluster blocks {}",
                    logger.error(
            remoteIndexMetadataManager.readAsync(
        this.applicationDurationMsSupplier = applicationDurationMsSupplier;
            );
                listener
    }
                    blobStoreRepository.getCompressor(),
            throw new IllegalStateException(
                listener
                            metadataBuilder.removeCustom(customType);
            previousManifest.getSettingsMetadata(),
        customToUpload.forEach((key, value) -> {
import org.opensearch.cluster.block.ClusterBlocks;
    }
                    indexMetadata.getIndex(),
import java.util.ArrayList;
                    clusterUUID,
                            )
                    String.format(
            );
            remoteStateStats.stateFullDownloadTook(durationMillis);
        }
    // package private setter which are required for injecting mock managers, these setters are not supposed to be used elsewhere
        }
                    updatedCustomMetadata.put(customType, manifest.getCustomMetadataMap().get(customType));
import org.apache.logging.log4j.message.ParameterizedMessage;
        NamedWriteableRegistry namedWriteableRegistry,
        return validChain;
     */
                diff.isSettingsMetadataUpdated(),
        remoteClusterStateCleanupManager.close();
        Map<String, Metadata.Custom> customToUpload,
                    namedWriteableRegistry
        final List<String> deletedIndicesRouting = new ArrayList<>();
                        + mode
            nodeId,
                HASHES_OF_CONSISTENT_SETTINGS,
            customToRead,
        Property.Final
    private final LongSupplier relativeTimeNanosSupplier;
                    + "wrote  metadata for [{}] indices and skipped [{}] unchanged indices, coordination metadata updated : [{}], "
        return trimmedUUIDs;
                    manifest.getClusterUUID(),
    }
        }
                durationMillis,
        "cluster.remote_store.state.checksum_validation.mode",
     * Gates the functionality of remote publication.
        return remoteClusterStateCleanupManager;
                ),
            return clusterState;
                new RemoteDiscoveryNodes(
                ),
                    (DiffableStringMap) clusterState.metadata().hashesOfConsistentSettings(),
                    custom,
        });
        Map<String, IndexRoutingTable> indicesRouting = new HashMap<>(previousState.routingTable().getIndicesRouting());
                ),
                DISCOVERY_NODES,
                        Locale.ROOT,
                    manifest.getHashesOfConsistentSettings().getUploadedFilename(),
    }
    }
        this.remotePathPrefix = CLUSTER_REMOTE_STORE_STATE_PATH_PREFIX.get(settings);
                    clusterState.metadata().version(),
                TRANSIENT_SETTING_METADATA,
        final List<String> topLevelClusterUUIDs = validClusterManifests.stream()
                }
        ClusterStateDiffManifest clusterStateDiffManifest = new ClusterStateDiffManifest(
        ClusterMetadataManifest previousManifest,
        return new LatchedActionListener<>(
        this.remoteStateReadTimeout = clusterSettings.get(REMOTE_STATE_READ_TIMEOUT_SETTING);
                        logger.error(
                        for (String indexName : diff.getIndicesRoutingDeleted()) {
        if (readHashesOfConsistentSettings) {
                response.uploadedTransientSettingsMetadata = (UploadedMetadataAttribute) uploadedMetadata;
                && routingTableDiff.provideDiff() != null
            blobStoreTransferService,
                remoteClusterStateCache.putState(clusterState);
            remoteClusterStateAttributesManager.writeAsync(
    public void setRemoteStateReadTimeout(TimeValue remoteStateReadTimeout) {
            uploadedMetadataResults.uploadedHashesOfConsistentSettings = previousManifest.getHashesOfConsistentSettings();
                    break;
            uploadTasks.add(RemoteRoutingTableDiff.ROUTING_TABLE_DIFF_FILE);
            Thread.currentThread().interrupt();
            } catch (IllegalArgumentException e) {
                        logger.error(
        );
                }
     * @param clusterUUID uuid of cluster state to refer to in remote
    }
            logger.info(
        this.remoteStateStats = new RemotePersistenceStats();
        boolean readHashesOfConsistentSettings,
                    throw new IllegalStateException("Unknown component: " + remoteReadResult.getComponent());
                    value,
            previousClusterState.getRoutingTable(),
import static org.opensearch.gateway.remote.RemoteClusterStateAttributesManager.CLUSTER_STATE_ATTRIBUTE;
        final Map<String, UploadedMetadataAttribute> allUploadedClusterStateCustomsMap = new HashMap<>(
                String.format(Locale.ROOT, "Latest cluster metadata manifest is not present for the provided clusterUUID: %s", clusterUUID)
@InternalApi
                    clusterUUID,
                    default:
    private BlobStoreTransferService blobStoreTransferService;
            latch
    }
            || remoteClusterStateValidationMode.equals(RemoteClusterStateValidationMode.TRACE)) {
        final List<ClusterMetadataManifest> validClusterManifests = manifestsByClusterUUID.values()
            .stream()
            uploadedIndexMetadata -> allUploadedIndexMetadata.put(uploadedIndexMetadata.getIndexName(), uploadedIndexMetadata)
        }
    ClusterState readClusterStateInParallel(
            return emptyList();
    );
        if (uploadTransientSettingMetadata) {
        String clusterName = ClusterName.CLUSTER_NAME_SETTING.get(settings).value();
                ClusterState state = readClusterStateInParallel(
        );
        logger.trace("WRITING INCREMENTAL STATE");
            updateSettingsMetadata,
                    }
            .collect(Collectors.toMap(UploadedIndexMetadata::getIndexName, Function.identity()));
                );
    }
 */
                response.uploadedSettingsMetadata = (UploadedMetadataAttribute) uploadedMetadata;
    public void diffIncomingPublicationFailed() {
    }
                    () -> new ParameterizedMessage("Exception during transfer of Metadata Fragment to Remote {}", ex.getMessage()),
                manifest,
        this.remoteRoutingTableService = RemoteRoutingTableServiceFactory.getService(
        blobStoreRepository = (BlobStoreRepository) repository;
    public ClusterMetadataManifest getClusterMetadataManifestByFileName(String clusterUUID, String fileName) {
            clusterSettings,
    ) {
        results.forEach((name, uploadedMetadata) -> {
        Map<String, UploadedMetadataAttribute> customToRead,
            threadpool,
                    manifest.getClusterBlocksMetadata().getUploadedFilename(),
        boolean updateTransientSettingsMetadata = Metadata.isTransientSettingsMetadataEqual(
                for (String customType : diff.getClusterStateCustomUpdated()) {
import org.opensearch.common.unit.TimeValue;
        }
import org.opensearch.repositories.Repository;
        boolean updateSettingsMetadata = firstUploadForSplitGlobalMetadata
        remoteStateStats.stateUploadFailed();
                                    clusterState.metadata().indices(),
            // TODO update logs to add more details about objects uploaded
                response.uploadedTemplatesMetadata = (UploadedMetadataAttribute) uploadedMetadata;
                    entry.getValue().getUploadedFilename(),
        UploadedMetadataResults uploadedMetadataResults = writeMetadataInParallel(
    }
import static org.opensearch.gateway.remote.routingtable.RemoteIndexRoutingTable.INDEX_ROUTING_METADATA_PREFIX;
            logger.debug(
                    validateClusterStateFromChecksum(manifest, clusterState, clusterName, localNodeId, true);
                    blobStoreRepository.getCompressor(),
import org.opensearch.common.annotation.InternalApi;
        final String clusterName
        if (clusterState.nodes().isLocalNodeElectedClusterManager() == false) {
                    previousVersion,
        remoteStateStats.stateUploadTook(durationMillis);
import static org.opensearch.gateway.remote.RemoteClusterStateAttributesManager.CLUSTER_BLOCKS;
    ) {
        int totalReadTasks = indicesToRead.size() + customToRead.size() + (readCoordinationMetadata ? 1 : 0) + (readSettingsMetadata
        final Map<String, ClusterMetadataManifest> trimmedUUIDs = new HashMap<>(latestManifestsByClusterUUID);
                first.getClusterUUID()
                && RemoteStoreNodeAttribute.isRemoteRoutingTableConfigured(settings)
import java.io.Closeable;
                listener
        UploadedMetadataResults response = new UploadedMetadataResults();
            } else if (TEMPLATES_METADATA.equals(name)) {
        for (UploadedIndexMetadata indexRouting : indicesRoutingToRead) {
                    blobStoreRepository.getCompressor(),
            updateHashesOfConsistentSettings,
        remoteStateStats.stateDiffDownloadFailed();
                        break;
            }
            blobStoreTransferService,
        stats.setCurrentApplicationDurationMs(applicationDurationMsSupplier.getAsLong());
    public static final String REMOTE_STATE_DOWNLOAD_TO_SERVE_READ_API_KEY = "cluster.remote_state.download.serve_read_api.enabled";
     * This method take a map of manifests for different cluster UUIDs and removes the
        List<IndexMetadata> updatedIndexMetadataList,
    }
            logger.error("Local node is not elected cluster manager. Exiting");
                uploadedMetadataResults.uploadedIndicesRoutingMetadata.size()
                            )
        assert isRemoteClusterStateConfigured(settings) == true : "Remote cluster state is not enabled";
        remoteGlobalMetadataManager = new RemoteGlobalMetadataManager(
        } else {
            logger.warn(
            + (uploadCoordinationMetadata ? 1 : 0) + (uploadSettingsMetadata ? 1 : 0) + (uploadTemplateMetadata ? 1 : 0)
            customsDiff.getUpserts().size(),
                String custom = name.split(DELIMITER)[0].split(CUSTOM_DELIMITER)[1];
                    + "wrote full state with [{}] indices and [{}] indicesRouting",
                second.getClusterUUID()
                SETTING_METADATA,
                    false,
                    false,
        );
        if (blobStoreRepository != null) {
            previousManifest.getPreviousClusterUUID(),
    private void invokeIndexMetadataUploadListeners(
                    manifest.getTransientSettingsMetadata().getUploadedFilename(),
        this.slowWriteLoggingThreshold = clusterSettings.get(SLOW_WRITE_LOGGING_THRESHOLD);
        if (routingTableDiff != null
            remoteGlobalMetadataManager.writeAsync(
        uploadedMetadataResults.uploadedCustomMetadataMap = allUploadedCustomMap;
        remoteStateStats.stateUploadSucceeded();
                    blobStoreRepository.getCompressor(),
        long term,
        String localNodeId,
            }
                new RemoteIndexMetadata(
            remoteRoutingTableService.getAsyncIndexRoutingDiffWriteAction(
            } else if (RemoteDiscoveryNodes.DISCOVERY_NODES.equals(uploadedMetadata.getComponent())) {
            + ((routingTableDiff != null
        final DiffableUtils.MapDiff<String, Metadata.Custom, Map<String, Metadata.Custom>> customsDiff = remoteGlobalMetadataManager
                new RemotePersistentSettingsMetadata(
        if (!updateHashesOfConsistentSettings) {
                    if (manifest.getCodecVersion() == CODEC_V2 || manifest.getCodecVersion() == CODEC_V3) {
                    manifest.getCoordinationMetadata() != null,
                ),
                response.uploadedDiscoveryNodes = (UploadedMetadataAttribute) uploadedMetadata;
            String listenerName = listener.getClass().getSimpleName();
        String clusterName,
                    blobStoreRepository.getNamedXContentRegistry()
            uploadTasks.add(CLUSTER_BLOCKS);
            } else {
            );
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.DELIMITER;
        RemoteClusterStateValidationMode::parseString,
                RemoteStateTransferException exception = new RemoteStateTransferException(
    }
            uploadedMetadataResults.uploadedClusterBlocks = previousManifest.getClusterBlocksMetadata();
        REMOTE_STATE_DOWNLOAD_TO_SERVE_READ_API_KEY,
        Map<String, String> params = new HashMap<>(1);
        }
                "Interrupted while waiting to read cluster state from metadata"
     *
                    entry.getKey(),
    ) {
        );
        clusterSettings.addSettingsUpdateConsumer(SLOW_WRITE_LOGGING_THRESHOLD, this::setSlowWriteLoggingThreshold);
            readCoordinationMetadata,
public class RemoteClusterStateService implements Closeable {
            true,
import org.opensearch.cluster.metadata.TemplatesMetadata;
            previousClusterState,
            MANIFEST_CURRENT_CODEC_VERSION,
            );
    void setRemoteIndexMetadataManager(RemoteIndexMetadataManager remoteIndexMetadataManager) {
        if (clusterState.nodes().isLocalNodeElectedClusterManager() == false) {
                            () -> new ParameterizedMessage(
                    blobStoreRepository.getCompressor(),
                Optional<UploadedIndexMetadata> uploadedIndexMetadataOptional = manifest.getIndices()
import static org.opensearch.gateway.remote.model.RemoteCustomMetadata.CUSTOM_DELIMITER;
            this.mode = mode;
            boolean includeEphemeral = true;
        params.put(Metadata.CONTEXT_MODE_PARAM, Metadata.CONTEXT_MODE_GATEWAY);
                e
        boolean uploadClusterBlock,
        if (uploadCoordinationMetadata) {
                ),
            previousManifest.getTemplatesMetadata(),
                    || !routingTableDiff.provideDiff().getDeletes().isEmpty()
                results.put(uploadedMetadata.getComponent(), uploadedMetadata);
        );
            this.isPublicationEnabled.set(false);
                    clusterState.metadata().clusterUUID(),
import java.util.List;
                ),
            clusterName,
            );
                    case ClusterStateChecksum.ROUTING_TABLE_CS:
        REMOTE_PUBLICATION_SETTING_KEY,
        ThreadPool threadPool,
            .collect(Collectors.toMap(ClusterMetadataManifest::getClusterUUID, ClusterMetadataManifest::getPreviousClusterUUID));
                        "Timed out waiting for transfer of following metadata to complete - %s",
    private boolean isValidClusterUUID(ClusterMetadataManifest manifest) {
        String localNodeId,
import org.opensearch.repositories.blobstore.BlobStoreRepository;
            if (diff.getClusterStateCustomUpdated() != null) {
            previousManifest.getClusterStateCustomMap()
    private Map<String, ClusterMetadataManifest> trimClusterUUIDs(
            // update the coordination metadata if voting config is committed
            clusterStateCustomToRead,
                    String.join(", ", uploadTasks),
                                    Metadata.CUSTOM_VALUE_SERIALIZER
        remoteManifestManager = new RemoteManifestManager(
        FORMAT_PARAMS = new ToXContent.MapParams(params);
                            indexRoutingTables.remove(indexName);
        } catch (Exception e) {
                    "Some metadata components were not uploaded successfully. Objects to be uploaded: %s, uploaded objects: %s",
        }
                    metadataBuilder.transientSettings((Settings) remoteReadResult.getObj());
                                "Failing Diff in discovery nodes {}",
    }
        return remoteManifestManager.getClusterMetadataManifestByTermVersion(clusterName, clusterUUID, term, version);
                emptyList(),
                    blobStoreRepository.getNamedXContentRegistry()
    static {
                    )
                        );
                listener
                clusterUUID,
                response.uploadedCoordinationMetadata = (UploadedMetadataAttribute) uploadedMetadata;
        AtomicReference<Builder> discoveryNodesBuilder = new AtomicReference<>(DiscoveryNodes.builder());
            uploadedMetadataResults.uploadedIndicesRoutingDiffMetadata != null
    }
            latch
            new ArrayList<>(clusterState.metadata().indices().values()),
                    case ClusterStateChecksum.NODES_CS:
                );
                        );
     */
     */
        DEBUG("debug"),
                    false,
    public boolean isRemotePublicationEnabled() {
        if (clusterUUIDMetadata == null) {
                manifest.getCustomMetadataMap(),
                    namedWriteableRegistry,
            remoteStateStats.stateDiffDownloadTook(durationMillis);
        }
        }
        if (routingTableDiff != null && routingTableDiff.provideDiff() != null) {
    public RemoteClusterStateManifestInfo markLastStateAsCommitted(
                    blobStoreRepository.getCompressor(),
        this.namedWriteableRegistry = namedWriteableRegistry;
                manifest.getTransientSettingsMetadata() != null,
        + "updated : [{}], custom metadata updated : [{}], indices routing updated : [{}]";
            if (validChain.isEmpty()) {
        }
        List<RemoteReadResult> readResults = Collections.synchronizedList(new ArrayList<>());
            return null;
                    "Cluster state not found in cache for term {} and version {}",
     *
        if (isFullStateDownload) {
    public Optional<ClusterMetadataManifest> getLatestClusterMetadataManifest(String clusterName, String clusterUUID) {
                    .filter(idx2 -> idx2.getIndexName().equals(idx))
                        + "] mode is not supported. "
            numIndicesUnchanged,
                    clusterState.metadata().clusterUUID(),
        Property.NodeScope,
        ClusterStateChecksum newClusterStateChecksum = new ClusterStateChecksum(clusterState, threadpool);
                    emptyList(),
        String listenerName
        final Map<String, String> clusterUUIDGraph = validClusterManifests.stream()
                ),
        if (durationMillis >= slowWriteLoggingThreshold.getMillis()) {
        this.isPublicationEnabled = new AtomicBoolean(
package org.opensearch.gateway.remote;
import java.util.function.Supplier;
                    new UploadedMetadataAttribute(custom, uploadedMetadata.getUploadedFilename())
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V2;
            logger.debug("{}; {}", clusterStateUploadTimeMessage, metadataUpdateMessage);
        uploadedMetadataResults.uploadedIndexMetadata.forEach(
                    clusterState.metadata().clusterUUID(),
        uploadedMetadataResults = writeMetadataInParallel(
            switch (remoteReadResult.getComponent()) {
                                "Failing Diff in index md {}",
import org.opensearch.cluster.metadata.DiffableStringMap;
        Diff<RoutingTable> routingTableDiff = readIndexRoutingTableDiffResults.get();
            } else if (RemoteTransientSettingsMetadata.TRANSIENT_SETTING_METADATA.equals(name)) {
            clusterName,
            final UploadedIndexMetadata secondUploadedIndexMetadata = secondIndices.get(uploadedIndexMetadata.getIndexName());
    }
                false,
            );
                        break;
        }
            RemoteGlobalMetadataManager.filterCustoms(clusterState.metadata().customs(), publicationEnabled),
            || Metadata.isSettingsMetadataEqual(previousClusterState.metadata(), clusterState.metadata()) == false;
            );
                                    fullClusterState.metadata().customs(),
                null
                manifest.getOpensearchVersion()
            blobStoreTransferService,
                    blobStoreRepository.getCompressor(),
            );
            ClusterState stateFromCache = remoteClusterStateCache.getState(clusterName, manifest);
                new RemoteHashesOfConsistentSettings(
        UploadedMetadataResults uploadedMetadataResults;
        if (clusterState == null) {
            String indexName = indexMetadata.getIndex().getName();
        StringKeyDiffProvider<IndexRoutingTable> routingTableDiff
    @Nullable
            clusterUUID
import org.opensearch.gateway.remote.model.RemoteClusterStateCustoms;
                                fullClusterState.metadata().transientSettings()
        Property.NodeScope,
        Metadata.Builder metadataBuilder = Metadata.builder(previousState.metadata());
                    Map<String, IndexRoutingTable> indexRoutingTables = routingTable.getIndicesRouting();
 * this file be licensed under the Apache-2.0 license or a
            );
                clusterState,
import org.opensearch.gateway.remote.model.RemoteCoordinationMetadata;
            } else {
        Setting.Property.Dynamic,
            for (String failedEntity : failedValidation) {
        return blobStoreRepository.blobStore();
                        break;
            clusterState,
        } catch (Exception e) {
        String localNodeId,
                    blobStoreRepository.getCompressor(),
                )
                localNodeId,
                mb.indices(state.metadata().indices());
            remoteGlobalMetadataManager.writeAsync(
        boolean readTransientSettingsMetadata,
            customsDiff.getUpserts(),
                logger.error(() -> new ParameterizedMessage("Failed to read index-routing from remote"), ex);
     * @return ClusterMetadataManifest
                ? new ClusterStateChecksum(clusterState, threadpool)
                diff.isTransientSettingsMetadataUpdated(),
                clusterState.metadata().clusterUUID(),
    RemoteRoutingTableService getRemoteRoutingTableService() {
                manifest.getDiscoveryNodesMetadata() != null,
            );
        boolean readCoordinationMetadata,
        return threadpool;
                throw exception;
        assert remoteStoreRepo != null : "Remote Cluster State repository is not configured";
                ),
                ),
            updateCoordinationMetadata,
        this.remoteClusterStateValidationMode = REMOTE_CLUSTER_STATE_CHECKSUM_VALIDATION_MODE_SETTING.get(settings);
            uploadTasks.add(HASHES_OF_CONSISTENT_SETTINGS);
        uploadedMetadataResults.uploadedClusterStateCustomMetadataMap = allUploadedClusterStateCustomsMap;
import org.opensearch.gateway.remote.model.RemoteReadResult;
import static org.opensearch.gateway.remote.ClusterMetadataManifest.MANIFEST_CURRENT_CODEC_VERSION;
            Map<String, UploadedMetadataAttribute> updatedCustomMetadata = new HashMap<>();
        this.nodeId = nodeId;
        if (!updateDiscoveryNodes) {
    }
                    && remoteGlobalMetadataManager.isGlobalMetadataEqual(currentManifest, previousManifest, clusterName)) {
            logger.info("Top level cluster UUIDs: {}", topLevelClusterUUIDs);
    public PersistedStateStats getUploadStats() {
            + clusterStateCustomToUpload.size() + (uploadHashesOfConsistentSettings ? 1 : 0) + indicesRoutingToUpload.size()
    public Optional<ClusterMetadataManifest> getClusterMetadataManifestByTermVersion(
                    metadataBuilder.hashesOfConsistentSettings((DiffableStringMap) remoteReadResult.getObj());
            ClusterState.Builder clusterStateBuilder = ClusterState.builder(updatedClusterState);
            manifestDetails.getClusterMetadataManifest().getStateVersion(),
                new RemoteCustomMetadata(
            updateTransientSettingsMetadata,
                    clusterUUID,
        } else {
        return readClusterStateInParallel(
    UploadedMetadataResults writeMetadataInParallel(
                clusterState.version(),
        Property.Final
                    blobStoreRepository.getNamedXContentRegistry()
import static org.opensearch.gateway.remote.model.RemoteHashesOfConsistentSettings.HASHES_OF_CONSISTENT_SETTINGS;
    private void setChecksumValidationMode(RemoteClusterStateValidationMode remoteClusterStateValidationMode) {
                    new ParameterizedMessage(
                ),
import java.util.concurrent.CountDownLatch;
                ),
            remoteGlobalMetadataManager.writeAsync(
                        manifest.getStateVersion()
                    case ClusterStateChecksum.BLOCKS_CS:
        Property.NodeScope,
     */
        );
            throw e;
            readSettingsMetadata,
        }
     * manifest. The new manifest file is created by using the unchanged metadata from the previous manifest and the new metadata changes from the current
        try {
        final List<String> validClusterUUIDs,
    }
                : null,
    private List<String> createClusterChain(final Map<String, ClusterMetadataManifest> manifestsByClusterUUID, final String clusterName) {
            final long durationMillis = TimeValue.nsecToMSec(relativeTimeNanosSupplier.getAsLong() - startTimeNanos);
    }
                exceptionList.forEach(exception::addSuppressed);
                                "Failing Diff in settings md. current md {}, full state md {}",
                    case ClusterStateChecksum.CUSTOMS_CS:
    ) {
            if (stateFromCache != null) {
        List<IndexMetadata> newIndexMetadataList,
                );
                .version(manifest.getStateVersion())
                response.uploadedIndicesRoutingMetadata.add((UploadedIndexMetadata) uploadedMetadata);
                    clusterState.metadata().clusterUUID(),
                    Metadata.Custom metadataCustom = (Metadata.Custom) remoteReadResult.getObj();
        List<UploadedIndexMetadata> indicesRoutingToRead,
    public static final TimeValue REMOTE_STATE_READ_TIMEOUT_DEFAULT = TimeValue.timeValueMillis(20000);
    @Nullable
            try {
                ? uploadedMetadataResults.uploadedIndicesRoutingDiffMetadata.getUploadedFilename()
     * @param clusterName name of the cluster
import java.util.stream.Collectors;
                manifest.getDiffManifest().getIndicesRoutingDiffPath(),
        boolean uploadCoordinationMetadata,
                ignored -> logger.trace(
            throw new IllegalStateException(
 * SPDX-License-Identifier: Apache-2.0
        );
                manifest.getTemplatesMetadata() != null,
                toUpload.add(indexMetadata);
    ) throws IOException {
            blobStoreTransferService,
                    )
            ClusterState updatedClusterState = readClusterStateInParallel(
        "",
        false,
                    clusterState.metadata().version(),
                        logger.error(() -> new ParameterizedMessage("Unknown failed entity {}", failedEntity));
            logger.debug("Successfully read cluster state component from remote");
        );
        ) == false;
    private final RemoteClusterStateCache remoteClusterStateCache;
                    remotePathPrefix
        this.remoteClusterStateAttributesManager = remoteClusterStateAttributeManager;
        NONE("none");
                        break;
                secondUploadedIndexMetadata,
                    break;
    ) throws IOException {
        }
            uploadTasks.add(DISCOVERY_NODES);
                    IndexMetadata indexMetadata = (IndexMetadata) remoteReadResult.getObj();
    }
        }
                    }
            latch
        boolean readHashesOfConsistentSettings,
            readResults.add(response);
                    blobStoreRepository.getCompressor(),
import org.opensearch.cluster.routing.IndexRoutingTable;
            );
                    clusterState.blocks(),
        return getClusterStateForManifest(clusterName, clusterMetadataManifest.get(), nodeId, includeEphemeral);
                    clusterUUID,
     * Invokes the index metadata upload listener but does not wait for the execution to complete.
        if (readCoordinationMetadata) {
}
import static org.opensearch.gateway.PersistedClusterStateService.SLOW_WRITE_LOGGING_THRESHOLD;
            Long previousVersion = prevIndexMetadata != null ? prevIndexMetadata.getVersion() : null;
            assert manifest.getDiffManifest() != null : "Diff manifest null which is required for downloading cluster state";
                numIndicesUnchanged++;
        );
                        (System.nanoTime() - startTime)
                updateTemplatesMetadata,
import org.opensearch.cluster.service.ClusterService;
            }
                        // component name for mat is "cluster-state-custom--custom_name"
                clusterState = ClusterState.builder(state).metadata(mb).build();
        ClusterState previousState,
        this.relativeTimeNanosSupplier = relativeTimeNanosSupplier;
                "writing cluster state took [{}ms] which is above the warn threshold of [{}]; "
        }
                    // remove the deleted indices from the metadata
            if (uploadedMetadata.getClass().equals(UploadedIndexMetadata.class)
        );
                && uploadedMetadata.getComponent().contains(INDEX_ROUTING_METADATA_PREFIX)) {
        }
            namedWriteableRegistry,
                    clusterUUID,
    ClusterState readClusterStateInParallel(
            .stream()
                    localNodeId,
            uploadTasks.add(customComponent);
        if (remoteClusterStateValidationMode.equals(RemoteClusterStateValidationMode.FAILURE)) {
                manifest.getClusterStateCustomMap(),
import org.opensearch.common.util.io.IOUtils;
    // We are using gateway context mode to persist all custom metadata.
    );
        boolean uploadTemplateMetadata,
            }, ex -> {
                diff.isTemplatesMetadataUpdated(),
                    manifest.getTemplatesMetadata().getUploadedFilename(),
            }, ex -> {
                throw new IllegalArgumentException(
            clusterSettings,
        CountDownLatch latch = new CountDownLatch(totalUploadTasks);
                        ex
     * Fetch the previous cluster UUIDs from remote state store and return the most recent valid cluster UUID
            // Getting the previous cluster UUID of a cluster UUID from the clusterUUID Graph
        if (!updateCoordinationMetadata) {
                    indexMetadataMap.put(indexMetadata.getIndex().getName(), indexMetadata);
        }
                RemoteDiscoveryNodes.DISCOVERY_NODES,
                }
                    includeEphemeral ? manifest.getIndicesRouting() : emptyList(),
        String localNodeId,
            + (uploadDiscoveryNodes ? 1 : 0) + (uploadClusterBlock ? 1 : 0) + (uploadTransientSettingMetadata ? 1 : 0)
        );
    public static final Setting<RemoteClusterStateValidationMode> REMOTE_CLUSTER_STATE_CHECKSUM_VALIDATION_MODE_SETTING = new Setting<>(
            );
        if (failedValidation.isEmpty()) {
                updatedIndexMetadataList,
        final long durationMillis = TimeValue.nsecToMSec(relativeTimeNanosSupplier.getAsLong() - startTimeNanos);
                listener
            );
                    manifest.getIndices(),
            uploadTasks.add(INDEX_ROUTING_METADATA_PREFIX + indexRoutingTable.getIndex().getName());
            RemoteStateTransferException exception = new RemoteStateTransferException(
                                )
                prevIndexMetadataByName,
            );
     * Validation mode for cluster state checksum.
        );
                                "Failing Diff in coordination md. current md {}, full state md {}",
                        );
                    key,
import org.opensearch.gateway.remote.model.RemoteHashesOfConsistentSettings;
                updateCoordinationMetadata,
    BlobStore getBlobStore() {
                numIndicesUpdated,
                            "listener={} : Exception during invocation with indexMetadataList={} prevIndexMetadataList={} tookTimeNs={}",
                clusterState.term(),
            exceptionList.forEach(exception::addSuppressed);
            ClusterStateDiffManifest diff = manifest.getDiffManifest();
            );
            remoteClusterStateAttributesManager.writeAsync(
    ) throws IOException {
import static org.opensearch.cluster.ClusterState.CUSTOM_VALUE_SERIALIZER;
                    && manifest.getDiffManifest().getIndicesRoutingDiffPath() != null
                    manifest.getCoordinationMetadata().getUploadedFilename(),
                            () -> new ParameterizedMessage(
            + (readTransientSettingsMetadata ? 1 : 0) + (readHashesOfConsistentSettings ? 1 : 0) + clusterStateCustomToRead.size()
        for (IndexMetadataUploadListener listener : indexMetadataUploadListeners) {
            uploadedMetadataResults,
            Thread.currentThread().interrupt();
                CLUSTER_STATE_CUSTOM,
                            () -> new ParameterizedMessage(
            uploadedMetadataResults.uploadedIndicesRoutingMetadata,
    }
        remoteClusterStateCleanupManager.start();
    ) {
        // We prepare a map that contains the previous index metadata for the indexes for which version has changed.
            final long durationMillis = TimeValue.nsecToMSec(relativeTimeNanosSupplier.getAsLong() - startTimeNanos);
                routingTableDiffLatchedActionListener,
            previousManifest,
                        }
    // package private for testing
                        break;
            remoteGlobalMetadataManager.readAsync(
        if (uploadTemplateMetadata) {
                        logger.error(
            indicesToRead,
                manifest.getDiffManifest() != null
                manifest.getClusterBlocksMetadata() != null,
        ClusterState clusterState,
                updatedIndexRouting,
                    false,
        if (readDiscoveryNodes) {
        );
        ClusterState clusterState,
            deletedIndicesRouting
            deletedIndicesRouting.addAll(routingTableDiff.provideDiff().getDeletes());
        );
                return false;
            remoteStateStats.stateDiffDownloadFailed();
                ),
                            () -> new ParameterizedMessage(
    }
        }
                manifest.getClusterUUID(),
        this.repositoriesService = repositoriesService;
                        clusterStateBuilder.putCustom(custom, (ClusterState.Custom) remoteReadResult.getObj());
            clusterUUID,
            if (!ClusterState.UNKNOWN_UUID.equals(currentManifest.getPreviousClusterUUID())) {
                .metadata(updatedClusterState.metadata())
                        diff.getIndicesRoutingUpdated(),
import org.opensearch.cluster.routing.StringKeyDiffProvider;
            if (latch.await(remoteGlobalMetadataManager.getGlobalMetadataUploadTimeout().millis(), TimeUnit.MILLISECONDS) == false) {
        for (Map.Entry<String, UploadedMetadataAttribute> entry : clusterStateCustomToRead.entrySet()) {
