        0,
                );
        }
                ClusterMetadataManifest clusterMetadataManifest = remoteManifestManager.fetchRemoteClusterMetadataManifest(
 * compatible open source license.
            this.remoteClusterStateCleanupManager = remoteClusterStateCleanupManager;
                );
        if (deleteStaleMetadataRunning.compareAndSet(false, true) == false) {
                }
                    remoteClusterStateService.getAllClusterUUIDs(clusterState.getClusterName().value())
    void deleteClusterMetadata(
                staleGlobalMetadataPaths.size(),
     * @param committedManifest last committed ClusterMetadataManifest
        if (staleFileDeletionTask != null && !staleFileDeletionTask.getInterval().equals(updatedInterval)) {
                }
                        );
     * @param clusterState current state of the cluster
        logger.info(
        assert blobContainerForDeletion != null;
                logger,
                        "Cleanup Batch Size should be greater than [%s] to as we " + "retain [%s] latest manifests in remote",
                logger.debug(
            remoteClusterStateCleanupManager.cleanUpStaleFiles();
            }
    public static final Setting<Integer> REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING = Setting.intSetting(
        public void validate(Integer value) {}
            activeManifestBlobMetadata.forEach(blobMetadata -> {
                }
                    filesToKeep.add(clusterMetadataManifest.getDiffManifest().getIndicesRoutingDiffPath());
 */
            rescheduleIfNecessary();
    ) throws IOException {
            );
                    clusterUUID
                    blobMetadata.name()
        public void validate(final Integer cleanupBatchSize, final Map<Setting<?>, Object> settings) {
        this.cleanupBatchSize = clusterSettings.get(REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING);
     * Validates the batch size setting for cleaning up stale manifest files
    static final class RemoteClusterStateCleanupBatchSizeValidator implements Setting.Validator<Integer> {
    private final RemotePersistenceStats remoteStateStats;
    }
        protected boolean mustReschedule() {
        if (blobStoreTransferService == null) {
        }
        this.threadpool = remoteClusterStateService.getThreadpool();
        RemoteRoutingTableService remoteRoutingTableService
                );
    // visible for testing
                    && !filesToKeep.contains(clusterMetadataManifest.getClusterBlocksMetadata().getUploadedFilename())) {
                }
                logger.debug("Released cleanup lock for cluster [{}]", clusterName);
        1,
                        "Exception occurred while deleting Remote Cluster Metadata for clusterUUID [{}] for attempted cluster-state version [{}]",
     * Deletes older than last {@code versionsToRetain} manifests. Also cleans up unreferenced IndexMetadata associated with older manifests
        if (staleFileDeletionTask != null) {
    private static final TimeValue DEFAULT_DELETION_TIMEOUT = TimeValue.timeValueSeconds(300);
            clusterName,
        Setting.Property.NodeScope,
        return blobStoreTransferService;
    }
                    // Update version only after successful completion
        @Override
    public static final String REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING_NAME = "cluster.remote_store.state.cleanup.batch_size";
    private volatile AsyncStaleFileDeletion staleFileDeletionTask;
    // package private for testing
        );
            staleFileDeletionTask.setInterval(updatedInterval);
     * Min value -1 indicates that the stale file cleanup job should be disabled
                        );
                    && !filesToKeep.contains(clusterMetadataManifest.getDiscoveryNodesMetadata().getUploadedFilename())) {
        this.staleFileCleanupInterval = updatedInterval;
                "Processed [{}] manifests, Deleting [{}] stale Global Metadata files, "
        new RemoteClusterStateCleanupBatchSizeValidator(),
        }
                        );
package org.opensearch.gateway.remote;
                        staleGlobalMetadataPaths.add(clusterMetadataManifest.getSettingsMetadata().getUploadedFilename());
                if (clusterMetadataManifest.getDiscoveryNodesMetadata() != null) {
            );
    }
                true
            Set<String> staleIndexMetadataPaths = new HashSet<>();
                    && !filesToKeep.contains(clusterMetadataManifest.getHashesOfConsistentSettings().getUploadedFilename())) {
            }
                        .values()
                    filesToKeep.add(clusterMetadataManifest.getClusterBlocksMetadata().getUploadedFilename());
            } catch (IOException e) {
                new BlobPath().add(GLOBAL_METADATA_PATH_TOKEN).buildAsString() + GLOBAL_METADATA_FORMAT.blobName(
        // initialize with 0, a cleanup will be done when this node is elected master node and version is incremented more than threshold
    public void deleteStaleClusterUUIDs(ClusterState clusterState, ClusterMetadataManifest committedManifest) {
                    clusterMetadataManifest.getIndicesRouting()
    void deleteStaleUUIDsClusterMetadata(String clusterName, List<String> clusterUUIDs) {
            }
            return true;
import org.opensearch.index.translog.transfer.BlobStoreTransferService;
        return deleteStaleMetadataRunning;
                                    "Indices routing paths in stale manifest: {}",
            assert !Strings.isNullOrEmpty(currentAppliedState.getClusterName().value()) : "cluster name is not set";
     *
    private void addStaleGlobalMetadataPath(String fileName, Set<String> filesToKeep, Set<String> staleGlobalMetadataPaths) {
            try {
            if (cleanUpAttemptStateVersion - lastCleanupAttemptStateVersion > SKIP_CLEANUP_STATE_CHANGES) {
                if (clusterMetadataManifest.getHashesOfConsistentSettings() != null) {
        } else {
                        logger.info("Deleted all remote cluster metadata for cluster UUID - {}", clusterUUID);
import java.util.concurrent.TimeUnit;
                }
                    if (filesToKeep.contains(clusterMetadataManifest.getSettingsMetadata().getUploadedFilename()) == false) {
                    }
    );
        RemoteClusterStateService remoteClusterStateService,
                    }
        );
        PlainActionFuture<Void> future = new PlainActionFuture<>();
                    cleanUpAttemptStateVersion - lastCleanupAttemptStateVersion,
                if (clusterMetadataManifest.getDiscoveryNodesMetadata() != null
    private void updateCleanupMaxBatches(Integer updatedMaxBatches) {
            Set<String> staleGlobalMetadataPaths = new HashSet<>();
        threadpool.executor(ThreadPool.Names.REMOTE_PURGE).execute(() -> {
                staleIndexMetadataPaths.size(),
        protected String getThreadPool() {
                if (clusterMetadataManifest.getCodecVersion() == ClusterMetadataManifest.CODEC_V1) {
                    addStaleGlobalMetadataPath(clusterMetadataManifest.getGlobalMetadataFileName(), filesToKeep, staleGlobalMetadataPaths);
import org.apache.logging.log4j.Logger;
                    filesToKeep.add(clusterMetadataManifest.getTemplatesMetadata().getUploadedFilename());
                    clusterMetadataManifest.getCustomMetadataMap()
        }
                staleEphemeralAttributePaths.size(),
                    staleEphemeralAttributePaths.add(clusterMetadataManifest.getClusterBlocksMetadata().getUploadedFilename());
        } catch (ExecutionException e) {
        }
        clusterSettings.addSettingsUpdateConsumer(REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING, this::updateCleanupInterval);
            allClustersUUIDsInRemote.remove(committedManifest.getPreviousClusterUUID());
        remoteManifestManager = remoteClusterStateService.getRemoteManifestManager();
        });
    }
    }
                    + "[{}] stale Index Metadata files, [{}] stale Ephemeral Metadata files, "
                    new ParameterizedMessage(
                    }
    void start() {
                return;
                                "Indices routing diff paths in stale manifest: {}",
        CLUSTER_STATE_CLEANUP_INTERVAL_DEFAULT,
                logger.debug("No stale Remote Cluster Metadata files found");
            throw e;
import org.opensearch.action.support.PlainActionFuture;
                e
                            () -> new ParameterizedMessage(
    }
                                    uploadedIndicesRouting.getUploadedFilename()
                            logger.trace(
    // visible for testing
        REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING_NAME,
                );
        Setting.Property.Dynamic
import static org.opensearch.gateway.remote.model.RemoteClusterMetadataManifest.MANIFEST;
                    @Override
 * @opensearch.internal
                            new ParameterizedMessage(
                remoteClusterStateCleanupManager.getStaleFileCleanupInterval(),
            future.get(timeout.seconds(), TimeUnit.SECONDS);
        return lastCleanupAttemptStateVersion;
        // After updating the interval, we need to close the current task and create a new one which will run with updated interval
                staleIndexRoutingDiffPaths.size()
                        if (!filesToKeep.contains(uploadedIndicesRouting.getUploadedFilename())) {
            logger.info("Delete stale cluster metadata task is already in progress.");
        }
        this.remoteRoutingTableService = remoteRoutingTableService;
        } else {
        } catch (InterruptedException e) {
    private void updateCleanupInterval(TimeValue updatedInterval) {
                }
 * The OpenSearch Contributors require contributions made to
                    // todo: To avoid repetitive fetch, we should use a paginated listener for each response page and act upon it
 * SPDX-License-Identifier: Apache-2.0
        BlobContainer blobContainerForDeletion = remoteClusterStateService.getBlobStore().blobContainer(BlobPath.cleanPath());
    ) {
                }
                        .values()
                if (clusterMetadataManifest.getTransientSettingsMetadata() != null) {
                    }
        throws IOException {
                        logger.debug(
                        uploadedIndexMetadata -> filesToKeep.add(
                });
                        .filter(file -> filesToKeep.contains(file) == false)
    private final ClusterApplierService clusterApplierService;
                    "Cleaning up stale remote state files for cluster [{}] with uuid [{}]. Last clean was done before {} updates",
                    staleEphemeralAttributePaths.add(clusterMetadataManifest.getTransientSettingsMetadata().getUploadedFilename());
                    } else {
                // throw exception as we do not want to fail repeatedly on all batches
                        remoteStateStats.cleanUpAttemptFailed();
                    () -> new ParameterizedMessage("Error while deleting stale index routing files {}", staleIndexRoutingPaths),
import org.opensearch.cluster.routing.remote.RemoteRoutingTableService;
    /**
                    public void onFailure(Exception e) {
    }
                logger.error(
                    ),
                if (clusterMetadataManifest.getDiffManifest() != null
                }
            blobContainerForDeletion.deleteBlobsAsyncIgnoringIfNotExists(fileNames, future);
            }
                    }
     */
            logger.error("Unexpected error while deleting stale Remote Cluster Metadata files", e);
        }
            assert !Strings.isNullOrEmpty(currentAppliedState.metadata().clusterUUID()) : "cluster uuid is not set";
                );
                    () -> new ParameterizedMessage("Error while deleting stale index routing diff files {}", staleIndexRoutingDiffPaths),
            try {
/**
                staleManifestPaths.add(
                        staleIndexRoutingDiffPaths.add(clusterMetadataManifest.getDiffManifest().getIndicesRoutingDiffPath());
                            staleIndexRoutingPaths.add(uploadedIndicesRouting.getUploadedFilename());
            // throw exception as we do not want to fail repeatedly on all batches
                    e
     * @param clusterName name of the cluster
            logger.error("Error while deleting stale Remote Cluster Metadata files", e);
        @Override
        Setting.Property.NodeScope,
        return this.staleFileCleanupInterval;
                if (clusterMetadataManifest.getClusterBlocksMetadata() != null) {
        CLUSTER_STATE_CLEANUP_INTERVAL_MINIMUM,
                RemoteClusterStateUtils.getClusterMetadataBasePath(
        if (!filesToKeep.contains(fileName)) {
        protected void runInternal() {
     * Purges all remote cluster state against provided cluster UUIDs
    public void close() throws IOException {
                    if (!filesToKeep.contains(clusterMetadataManifest.getDiffManifest().getIndicesRoutingDiffPath())) {
import java.io.Closeable;
                    String fileName = RemoteClusterStateUtils.getFormattedIndexFileName(uploadedIndexMetadata.getUploadedFilename());
            return ThreadPool.Names.REMOTE_PURGE;
                        logger.error(
     * Setting to specify the maximum number of batches to process during cleanup
                    clusterName,
        threadpool.executor(ThreadPool.Names.REMOTE_PURGE).execute(() -> {
    }
            deleteStaleUUIDsClusterMetadata(clusterName, new ArrayList<>(allClustersUUIDsInRemote));
                    }
                            )
        }
            staleManifestBlobMetadata.forEach(blobMetadata -> {
                    filesToKeep.add(clusterMetadataManifest.getSettingsMetadata().getUploadedFilename());
                    });
        private final RemoteClusterStateCleanupManager remoteClusterStateCleanupManager;
            // (for example the first 10 if not new manifests are uploaded in between)
        ClusterSettings clusterSettings = clusterService.getClusterSettings();
            deleteStalePaths(new ArrayList<>(staleEphemeralAttributePaths));
    );
    /**
     * Setting to specify the batch size for manifest cleanup operations
    void deleteStaleClusterMetadata(String clusterName, String clusterUUID, int manifestsToRetain, long cleanUpAttemptStateVersion) {
    // package private for testing
                logger.info(
    private long lastCleanupAttemptStateVersion;
                );
            if (staleManifestPaths.isEmpty()) {
                throw e;
    public static final int MANIFEST_CLEANUP_MAX_BATCHES_DEFAULT = 3;
    /**
            Thread.currentThread().interrupt();
                    filesToKeep.add(clusterMetadataManifest.getCoordinationMetadata().getUploadedFilename());
    static final class AsyncStaleFileDeletion extends AbstractAsyncTask {
    void deleteStalePaths(List<String> stalePaths) throws IOException {
                    logger.info("Completed cleaning up all stale cluster-state metadata files in [{}] batches", batchesProcessed);
    public TimeValue getStaleFileCleanupInterval() {
import java.util.concurrent.atomic.AtomicBoolean;
        @Override
                int batchesProcessed = 0;
            Set<String> staleEphemeralAttributePaths = new HashSet<>();
import java.util.HashSet;
                    if (filesToKeep.contains(clusterMetadataManifest.getTemplatesMetadata().getUploadedFilename()) == false) {
                );
    }
    void cleanUpStaleFiles() {
        ClusterService clusterService,
     */
    }
    );
            });
            cleanupBatchSize,
                    e
                clusterMetadataManifest.getIndices().forEach(uploadedIndexMetadata -> {
            )
            });
    // package private for testing
                    RETAINED_MANIFESTS,
                    && clusterMetadataManifest.getDiffManifest().getIndicesRoutingDiffPath() != null) {
                                "Exception occurred while deleting all remote cluster metadata for cluster UUID {}",
        this.cleanupMaxBatches = clusterSettings.get(REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING);
                }
 */
/*
    @Override
import java.util.concurrent.ExecutionException;
            Set<String> staleIndexRoutingDiffPaths = new HashSet<>();
        clusterSettings.addSettingsUpdateConsumer(REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING, this::updateCleanupBatchSize);
                    currentAppliedState.getClusterName().value(),
     */
                }
        clusterSettings.addSettingsUpdateConsumer(REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING, this::updateCleanupMaxBatches);
        MANIFEST_CLEANUP_MAX_BATCHES_DEFAULT,
    private final RemoteClusterStateService remoteClusterStateService;
                }
                if (clusterMetadataManifest.getClusterStateCustomMap() != null) {
import java.util.Set;
        List<BlobMetadata> staleManifestBlobMetadata
                        .stream()
import org.opensearch.common.blobstore.AsyncMultiStreamBlobContainer;
                remoteRoutingTableService.deleteStaleIndexRoutingDiffPaths(new ArrayList<>(staleIndexRoutingDiffPaths));
            } catch (IOException e) {
                        staleIndexMetadataPaths.add(fileName);
                allClustersUUIDsInRemote = new HashSet<>(
                if (clusterMetadataManifest.getCodecVersion() == ClusterMetadataManifest.CODEC_V1) {
                new ActionListener<>() {
     */
                        clusterUUID,
                clusterMetadataManifest.getIndices()
    }
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.GLOBAL_METADATA_PATH_TOKEN;
    }
                    );
            // throw exception as we do not want to fail repeatedly on all batches
                // throw exception as we do not want to fail repeatedly on all batches
            cleanupMaxBatches
                        .stream()
            Set<String> allClustersUUIDsInRemote;
                        staleGlobalMetadataPaths.add(clusterMetadataManifest.getCoordinationMetadata().getUploadedFilename());
                        List<BlobMetadata> manifestsToDeletes = batchManifests.subList(manifestsToRetain, batchManifests.size());
        REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING_NAME,
import org.opensearch.cluster.service.ClusterService;
    long getLastCleanupAttemptStateVersion() {
            getBlobStoreTransferService().deleteBlobs(BlobPath.cleanPath(), stalePaths);
        List<BlobMetadata> activeManifestBlobMetadata,
    BlobStoreTransferService getBlobStoreTransferService() {
import org.apache.logging.log4j.message.ParameterizedMessage;
                        cleanUpAttemptStateVersion
                    splitPath[splitPath.length - 1]
                    && clusterMetadataManifest.getDiffManifest().getIndicesRoutingDiffPath() != null) {
     * @param clusterUUIDs clusteUUIDs for which the remote state needs to be purged
            logger.debug("Skipping cleanup task as local node is not elected Cluster Manager");
            deleteStalePaths(new ArrayList<>(staleIndexMetadataPaths));
    private final RemoteRoutingTableService remoteRoutingTableService;
import org.opensearch.common.util.concurrent.FutureUtils;
    // visible for testing
            if (e.getCause() instanceof IOException) {
                    blobMetadata.name()
import java.util.ArrayList;
        Setting.Property.Dynamic
public class RemoteClusterStateCleanupManager implements Closeable {
                );
    }
            throw e;
import java.util.Map;
            try {
import static org.opensearch.gateway.remote.model.RemoteGlobalMetadata.GLOBAL_METADATA_FORMAT;
                    filesToKeep.add(clusterMetadataManifest.getDiscoveryNodesMetadata().getUploadedFilename());
        this.remoteClusterStateService = remoteClusterStateService;
                } else if (clusterMetadataManifest.getCodecVersion() >= ClusterMetadataManifest.CODEC_V2) {
import org.opensearch.common.unit.TimeValue;
            }
            blobStoreTransferService = new BlobStoreTransferService(remoteClusterStateService.getBlobStore(), threadpool);
                }
            throw new IOException(
            remoteStateStats.cleanUpAttemptFailed();
                } else if (clusterMetadataManifest.getCodecVersion() >= ClusterMetadataManifest.CODEC_V2) {
                        .values()
        logger.info("updated remote state cleanup interval to {}", updatedInterval);
                    filesToKeep.add(clusterMetadataManifest.getHashesOfConsistentSettings().getUploadedFilename());
                    clusterUUID,
                        )
        if (currentAppliedState.nodes().isLocalNodeElectedClusterManager()) {
                String.format(Locale.ROOT, "Delete operation timed out after %s seconds", DEFAULT_DELETION_TIMEOUT.seconds()),
                    remoteClusterStateService.getBlobStoreRepository(),
            FutureUtils.cancel(future);
                        RETAINED_MANIFESTS,
    public static final TimeValue CLUSTER_STATE_CLEANUP_INTERVAL_DEFAULT = TimeValue.timeValueMinutes(5);
        try {
        this.cleanupMaxBatches = updatedMaxBatches;
        }
                                () -> new ParameterizedMessage(
                            RemoteClusterStateUtils.getFormattedIndexFileName(uploadedIndexMetadata.getUploadedFilename())
                    if (Objects.nonNull(batchManifests) && batchManifests.size() > manifestsToRetain) {
                ),
                staleIndexRoutingPaths.size(),
                }
            staleFileDeletionTask.close();
                    @Override
    public static final TimeValue CLUSTER_STATE_CLEANUP_INTERVAL_MINIMUM = TimeValue.MINUS_ONE;
        this.cleanupBatchSize = updatedBatchSize;
                        .forEach(attribute -> filesToKeep.add(attribute.getUploadedFilename()));
            throw new RuntimeException(e.getCause());
        }
                if (clusterMetadataManifest.getIndicesRouting() != null) {
import org.opensearch.threadpool.ThreadPool;
 *
                    filesToKeep.add(clusterMetadataManifest.getGlobalMetadataFileName());
                        staleGlobalMetadataPaths.add(clusterMetadataManifest.getTemplatesMetadata().getUploadedFilename());
        AsyncStaleFileDeletion(RemoteClusterStateCleanupManager remoteClusterStateCleanupManager) {
                    currentAppliedState.metadata().clusterUUID(),
                        .forEach(staleGlobalMetadataPaths::add);
                    clusterMetadataManifest.getCustomMetadataMap()
    /**
import org.opensearch.core.common.Strings;
 *
                            batchManifests.size(),
                            "Number of manifests [{}] are less than or equal to manifests to retain [{}]. Skipping deletion",
        });
                                )
        staleFileDeletionTask = new AsyncStaleFileDeletion(this);
            // files after deleting manifests
                    clusterName,
import org.opensearch.common.settings.ClusterSettings;
        logger.info("updated remote state cleanup max batches to {}", updatedMaxBatches);
        }
        return this.remoteStateStats;
                deleteStaleMetadataRunning.set(false);
    }
    public RemoteClusterStateCleanupManager(
            } catch (Exception e) {
            // throw exception as we do not want to fail repeatedly on all batches
                        .values()
import java.io.IOException;
                staleManifestPaths.size(),
        this.staleFileCleanupInterval = clusterSettings.get(REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING);
    public static final Setting<Integer> REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING = Setting.intSetting(
                    )
                    + "[{}] stale Index Routing files and [{}] stale Index routing diff files",
                return;
        }
                    staleEphemeralAttributePaths.add(clusterMetadataManifest.getHashesOfConsistentSettings().getUploadedFilename());
import java.util.List;
    }
                        break;
        return this.staleFileDeletionTask;
                    public void onResponse(Void unused) {
        } catch (TimeoutException e) {
                        .filter(u -> !filesToKeep.contains(u.getUploadedFilename()))
import org.opensearch.cluster.ClusterState;
                remoteClusterStateCleanupManager.threadpool,
     * Purges all remote cluster state against provided cluster UUIDs
            }
            } else {
                                clusterMetadataManifest.getDiffManifest().getIndicesRoutingDiffPath()
                }
    }
                }
    }
        String clusterName,
                remoteStateStats.indicesRoutingDiffFileCleanupAttemptFailed();
import org.opensearch.common.util.concurrent.AbstractAsyncTask;
            // todo: Avoid repetitive fetch of manifestsToRetain across batches if they were fetched earlier and are the same
        @Override
                        logger.trace(
                    .forEach(
        Setting.Property.Dynamic
                        .forEach(attribute -> filesToKeep.add(attribute.getUploadedFilename()));
        }
                    currentAppliedState.getClusterName().value(),
                                clusterUUID
import java.util.Objects;
    private RemoteManifestManager remoteManifestManager;
    }
        Setting.Property.NodeScope,
                );
        try {
                    SKIP_CLEANUP_STATE_CHANGES
                throw (IOException) e.getCause();
import org.opensearch.common.settings.Setting;
        "cluster.remote_store.state.cleanup_interval",
                        logger.debug("[Batch {}] Deleting [{}] stale manifests", batchesProcessed, manifestsToDeletes.size());
                }
    }
     *
            // Retain last 2 cluster uuids data
                logger.error(
                        .forEach(uploadedIndicesRouting -> filesToKeep.add(uploadedIndicesRouting.getUploadedFilename()));
                        Locale.ROOT,
            } catch (IOException e) {
    private final AtomicBoolean deleteStaleMetadataRunning = new AtomicBoolean(false);
        MANIFEST_CLEANUP_BATCH_SIZE_DEFAULT,
    }
            logger.debug("Deleting stale cluster UUIDs data from remote [{}]", clusterName);
    public static final int MANIFEST_CLEANUP_BATCH_SIZE_DEFAULT = 1000;
}
            Set<String> staleManifestPaths = new HashSet<>();
                    String.format(
                            e
                throw new IllegalArgumentException(
                    && !filesToKeep.contains(clusterMetadataManifest.getTransientSettingsMetadata().getUploadedFilename())) {
            } finally {
                    if (filesToKeep.contains(fileName) == false) {
    /**
            super(
     * @param clusterUUID uuid of cluster state to refer to in remote
            "Starting batched cleanup for cluster [{}] with batch size [{}] and retaining [{}] manifests. Maximum batches to be attempted will be [{}]",
            String clusterName = clusterState.getClusterName().value();
        logger.debug(String.format(Locale.ROOT, "Deleting stale files from remote - %s", stalePaths));
     * Setting to specify the interval to do run stale file cleanup job
                        RETAINED_MANIFESTS
                ClusterMetadataManifest clusterMetadataManifest = remoteManifestManager.fetchRemoteClusterMetadataManifest(
import org.opensearch.core.action.ActionListener;
                    clusterMetadataManifest.getClusterStateCustomMap()
                if (batchesProcessed == cleanupMaxBatches) {
                }
                    clusterMetadataManifest.getIndicesRouting().forEach(uploadedIndicesRouting -> {
import java.util.Locale;
                if (clusterMetadataManifest.getHashesOfConsistentSettings() != null
                    currentAppliedState.getClusterName().value(),
                    }
            try {
            Set<String> staleIndexRoutingPaths = new HashSet<>();
        } catch (IllegalStateException e) {
            manifestsToRetain,
            deleteStalePaths(new ArrayList<>(staleGlobalMetadataPaths));
 * A Manager which provides APIs to clean up stale cluster state files and runs an async stale cleanup task
                        cleanupBatchSize
    private volatile int cleanupMaxBatches;
                this.deleteStaleClusterMetadata(
     */
        String clusterUUID,
import org.opensearch.common.blobstore.BlobMetadata;
        ClusterState currentAppliedState = clusterApplierService.state();
                    staleEphemeralAttributePaths.add(clusterMetadataManifest.getDiscoveryNodesMetadata().getUploadedFilename());
                if (clusterMetadataManifest.getTransientSettingsMetadata() != null
                    lastCleanupAttemptStateVersion = cleanUpAttemptStateVersion;
                    cleanUpAttemptStateVersion
                            );
import org.apache.logging.log4j.LogManager;
            logger.error("Error while fetching Remote Cluster Metadata manifests", e);
import org.opensearch.common.blobstore.BlobPath;
                    List<BlobMetadata> batchManifests = getBlobStoreTransferService().listAllInSortedOrder(
            deleteStalePaths(new ArrayList<>(staleManifestPaths));
                if (clusterMetadataManifest.getDiffManifest() != null
    /**
                while (batchesProcessed < cleanupMaxBatches) {
            Set<String> filesToKeep = new HashSet<>();
                if (clusterMetadataManifest.getClusterStateCustomMap() != null) {
                ThreadPool.Names.REMOTE_PURGE,
            throw e;
        clusterUUIDs.forEach(
                );
                remoteStateStats.indexRoutingFilesCleanupAttemptFailed();
            // Delete Manifests in the very end to avoid dangling routing files in-case deletion of stale index routing
                    "Skipping cleanup of stale remote state files for cluster [{}] with uuid [{}]. Last clean was done before {} updates, which is less than threshold {}",
                        .map(ClusterMetadataManifest.UploadedMetadataAttribute::getUploadedFilename)
    private volatile int cleanupBatchSize;
                    currentAppliedState.metadata().clusterUUID(),
            remoteStateStats.cleanUpAttemptFailed();
            throw new IOException("Future got interrupted", e);
                    clusterName,
    public static final int RETAINED_MANIFESTS = 10;
                logger.info(String.format(Locale.ROOT, "Error while fetching all cluster UUIDs for [%s]", clusterName));
                logger.error(
     */
        } catch (IOException e) {
            }
        }
        } catch (Exception e) {
                    cleanUpAttemptStateVersion - lastCleanupAttemptStateVersion
            );
        @Override
                        MANIFEST,
import java.util.concurrent.TimeoutException;
                    clusterUUID,
            }
        logger.info("updated remote state cleanup batch size to {}", updatedBatchSize);
    /**
            String[] splitPath = fileName.split("/");
                }
    }
                        remoteManifestManager.getManifestFolderPath(clusterName, clusterUUID),
            staleGlobalMetadataPaths.add(
            clusterUUID -> getBlobStoreTransferService().deleteAsync(
                throw e;
                    if (filesToKeep.contains(clusterMetadataManifest.getCoordinationMetadata().getUploadedFilename()) == false) {
        this.remoteStateStats = remoteClusterStateService.getRemoteStateStats();
    RemotePersistenceStats getStats() {
import org.opensearch.cluster.service.ClusterApplierService;
    private TimeValue staleFileCleanupInterval;
    public static final String REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING_NAME = "cluster.remote_store.state.cleanup.max_batches";
 * this file be licensed under the Apache-2.0 license or a
                )
    public static final Setting<TimeValue> REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING = Setting.timeSetting(
                } else {
    private static final Logger logger = LogManager.getLogger(RemoteClusterStateCleanupManager.class);
            if (cleanupBatchSize <= RETAINED_MANIFESTS) {
                    logger.warn("Exhausted batch limit for deleting entities. Attempted [{}] batches", batchesProcessed);
                    e
            logger.info(
     */
    private final ThreadPool threadpool;
                    batchesProcessed++;
    // visible for testing
                    remoteManifestManager.getManifestFolderPath(clusterName, clusterUUID).buildAsString() + blobMetadata.name()
            long cleanUpAttemptStateVersion = currentAppliedState.version();
    AtomicBoolean isDeleteStaleMetadataRunning() {
            return;
    private void updateCleanupBatchSize(Integer updatedBatchSize) {
                            ),
    public static final int SKIP_CLEANUP_STATE_CHANGES = 10;
        this.lastCleanupAttemptStateVersion = 0;
    private void deleteAsyncInternal(AsyncMultiStreamBlobContainer blobContainerForDeletion, List<String> fileNames, TimeValue timeout)
            deleteAsyncInternal((AsyncMultiStreamBlobContainer) blobContainerForDeletion, stalePaths, DEFAULT_DELETION_TIMEOUT);
        this.clusterApplierService = clusterService.getClusterApplierService();
            allClustersUUIDsInRemote.remove(committedManifest.getClusterUUID());
                        }
import org.opensearch.common.blobstore.BlobContainer;
                    currentAppliedState.metadata().clusterUUID(),
                );
                    filesToKeep.add(clusterMetadataManifest.getTransientSettingsMetadata().getUploadedFilename());
                        deleteClusterMetadata(clusterName, clusterUUID, batchManifests.subList(0, manifestsToRetain), manifestsToDeletes);
                    }
                if (clusterMetadataManifest.getClusterBlocksMetadata() != null
            );
    private BlobStoreTransferService blobStoreTransferService;
     * @param manifestsToRetain no of latest manifest files to keep in remote
    AsyncStaleFileDeletion getStaleFileDeletionTask() { // for testing
                if (clusterMetadataManifest.getIndicesRouting() != null) {
                            manifestsToRetain
        if (blobContainerForDeletion instanceof AsyncMultiStreamBlobContainer) {
     * @param clusterName name of the cluster
                }
                    clusterMetadataManifest.getClusterStateCustomMap()
     * @param cleanUpAttemptStateVersion the state version for this cleanup attempt
                    );
    }
                        .forEach(attribute -> staleEphemeralAttributePaths.add(attribute.getUploadedFilename()));
                remoteRoutingTableService.deleteStaleIndexRoutingPaths(new ArrayList<>(staleIndexRoutingPaths));
