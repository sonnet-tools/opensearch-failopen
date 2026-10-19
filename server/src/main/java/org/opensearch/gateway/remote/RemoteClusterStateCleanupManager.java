            Thread.currentThread().interrupt();
                }
        staleFileDeletionTask = new AsyncStaleFileDeletion(this);
            }  
            super(  
                        "Exception occurred while deleting Remote Cluster Metadata for clusterUUID [{}] for attempted cluster-state version [{}]",
                )
                    filesToKeep.add(clusterMetadataManifest.getCoordinationMetadata().getUploadedFilename());  
                    filesToKeep.add(clusterMetadataManifest.getDiffManifest().getIndicesRoutingDiffPath());  
    public static final Setting<Integer> REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING = Setting.intSetting(
                    cleanUpAttemptStateVersion - lastCleanupAttemptStateVersion  
            deleteStalePaths(new ArrayList<>(staleGlobalMetadataPaths));
                }
     * @param cleanUpAttemptStateVersion the state version for this cleanup attempt  
                logger.info(String.format(Locale.ROOT, "Error while fetching all cluster UUIDs for [%s]", clusterName));  
                    if (filesToKeep.contains(clusterMetadataManifest.getTemplatesMetadata().getUploadedFilename()) == false) {  
                    staleEphemeralAttributePaths.add(clusterMetadataManifest.getDiscoveryNodesMetadata().getUploadedFilename());
    );
            });
            if (e.getCause() instanceof IOException) {
import org.opensearch.common.unit.TimeValue;  
                }  
                    remoteClusterStateService.getAllClusterUUIDs(clusterState.getClusterName().value())  
                    && !filesToKeep.contains(clusterMetadataManifest.getDiscoveryNodesMetadata().getUploadedFilename())) {  
    }
    public static final int MANIFEST_CLEANUP_MAX_BATCHES_DEFAULT = 3;  
import org.opensearch.common.settings.Setting;
        Setting.Property.NodeScope,
        }  
                    clusterUUID
                new BlobPath().add(GLOBAL_METADATA_PATH_TOKEN).buildAsString() + GLOBAL_METADATA_FORMAT.blobName(
                        staleGlobalMetadataPaths.add(clusterMetadataManifest.getTemplatesMetadata().getUploadedFilename());
                );
    private volatile AsyncStaleFileDeletion staleFileDeletionTask;
                    blobMetadata.name()
        this.threadpool = remoteClusterStateService.getThreadpool();  
        AsyncStaleFileDeletion(RemoteClusterStateCleanupManager remoteClusterStateCleanupManager) {
import org.opensearch.common.blobstore.BlobContainer;
            String[] splitPath = fileName.split("/");  
                    RETAINED_MANIFESTS,
                    .forEach(
                        logger.info("Deleted all remote cluster metadata for cluster UUID - {}", clusterUUID);  
        } catch (IllegalStateException e) {
            }  
    public RemoteClusterStateCleanupManager(  
        protected void runInternal() {
    public static final TimeValue CLUSTER_STATE_CLEANUP_INTERVAL_DEFAULT = TimeValue.timeValueMinutes(5);
                ClusterMetadataManifest clusterMetadataManifest = remoteManifestManager.fetchRemoteClusterMetadataManifest(
import org.opensearch.cluster.service.ClusterApplierService;
        return lastCleanupAttemptStateVersion;  
                if (clusterMetadataManifest.getCodecVersion() == ClusterMetadataManifest.CODEC_V1) {  
                );
    /**
                        logger.error(
                        )
            );
import java.util.concurrent.TimeUnit;  
import org.opensearch.cluster.routing.remote.RemoteRoutingTableService;  
     * Purges all remote cluster state against provided cluster UUIDs
                throw (IOException) e.getCause();  
    }
                if (clusterMetadataManifest.getTransientSettingsMetadata() != null  
    private void addStaleGlobalMetadataPath(String fileName, Set<String> filesToKeep, Set<String> staleGlobalMetadataPaths) {
            Set<String> staleIndexRoutingPaths = new HashSet<>();
                    blobMetadata.name()
    }  
                if (clusterMetadataManifest.getTransientSettingsMetadata() != null) {
            deleteStalePaths(new ArrayList<>(staleIndexMetadataPaths));  
            clusterUUID -> getBlobStoreTransferService().deleteAsync(
            cleanupBatchSize,  
                }  
        String clusterName,
            logger.debug("Skipping cleanup task as local node is not elected Cluster Manager");  
                );
import org.opensearch.core.action.ActionListener;  
            return;  
    // package private for testing  
    long getLastCleanupAttemptStateVersion() {
}  
                        .forEach(attribute -> filesToKeep.add(attribute.getUploadedFilename()));
    }
    private final RemoteClusterStateService remoteClusterStateService;
                if (clusterMetadataManifest.getDiscoveryNodesMetadata() != null) {
     * @param clusterState current state of the cluster
        }
        this.remoteStateStats = remoteClusterStateService.getRemoteStateStats();  
                if (clusterMetadataManifest.getDiffManifest() != null
                if (clusterMetadataManifest.getCodecVersion() == ClusterMetadataManifest.CODEC_V1) {  
            } catch (IOException e) {
    BlobStoreTransferService getBlobStoreTransferService() {
                        staleGlobalMetadataPaths.add(clusterMetadataManifest.getSettingsMetadata().getUploadedFilename());
                    logger.warn("Exhausted batch limit for deleting entities. Attempted [{}] batches", batchesProcessed);
        List<BlobMetadata> staleManifestBlobMetadata
                    cleanUpAttemptStateVersion - lastCleanupAttemptStateVersion,
                        logger.debug("[Batch {}] Deleting [{}] stale manifests", batchesProcessed, manifestsToDeletes.size());  
     */
                RemoteClusterStateUtils.getClusterMetadataBasePath(
            Set<String> staleEphemeralAttributePaths = new HashSet<>();  
                    clusterName,
 * this file be licensed under the Apache-2.0 license or a
                    if (!filesToKeep.contains(clusterMetadataManifest.getDiffManifest().getIndicesRoutingDiffPath())) {
            deleteStalePaths(new ArrayList<>(staleEphemeralAttributePaths));
            Set<String> filesToKeep = new HashSet<>();
                String.format(Locale.ROOT, "Delete operation timed out after %s seconds", DEFAULT_DELETION_TIMEOUT.seconds()),  
    void cleanUpStaleFiles() {
                        cleanupBatchSize
            // throw exception as we do not want to fail repeatedly on all batches  
    private BlobStoreTransferService blobStoreTransferService;  
                            staleIndexRoutingPaths.add(uploadedIndicesRouting.getUploadedFilename());
import org.opensearch.common.settings.ClusterSettings;
                this.deleteStaleClusterMetadata(
                if (clusterMetadataManifest.getDiscoveryNodesMetadata() != null
                }
                    clusterUUID,  
                    filesToKeep.add(clusterMetadataManifest.getHashesOfConsistentSettings().getUploadedFilename());
     * Purges all remote cluster state against provided cluster UUIDs
                    && clusterMetadataManifest.getDiffManifest().getIndicesRoutingDiffPath() != null) {
            throw e;
                        Locale.ROOT,  
                staleIndexRoutingDiffPaths.size()
        this.staleFileCleanupInterval = updatedInterval;  
                }  
                }  
 * SPDX-License-Identifier: Apache-2.0
            getBlobStoreTransferService().deleteBlobs(BlobPath.cleanPath(), stalePaths);  
    private final ThreadPool threadpool;
import org.opensearch.threadpool.ThreadPool;  
                    () -> new ParameterizedMessage("Error while deleting stale index routing files {}", staleIndexRoutingPaths),
                        .forEach(attribute -> staleEphemeralAttributePaths.add(attribute.getUploadedFilename()));
        }
    }
    // visible for testing
        if (blobStoreTransferService == null) {
                        .map(ClusterMetadataManifest.UploadedMetadataAttribute::getUploadedFilename)  
                }  
                    currentAppliedState.getClusterName().value(),  
    void deleteClusterMetadata(
                        cleanUpAttemptStateVersion
        RemoteRoutingTableService remoteRoutingTableService  
import org.opensearch.cluster.ClusterState;
                }
        Setting.Property.Dynamic
                    if (filesToKeep.contains(fileName) == false) {
                ),
                ThreadPool.Names.REMOTE_PURGE,  
    private volatile int cleanupBatchSize;
        Setting.Property.Dynamic
                    );
        // After updating the interval, we need to close the current task and create a new one which will run with updated interval
import org.opensearch.common.blobstore.BlobPath;  
                if (clusterMetadataManifest.getIndicesRouting() != null) {  
                        .values()  
    }
            rescheduleIfNecessary();
/**
                            manifestsToRetain
        CLUSTER_STATE_CLEANUP_INTERVAL_DEFAULT,
                });
     * @param clusterUUIDs clusteUUIDs for which the remote state needs to be purged
    private void updateCleanupMaxBatches(Integer updatedMaxBatches) {
                );
                }  
    private final ClusterApplierService clusterApplierService;
                new ActionListener<>() {  
                            );
 *
        if (currentAppliedState.nodes().isLocalNodeElectedClusterManager()) {  
                    }
            try {  
                    && clusterMetadataManifest.getDiffManifest().getIndicesRoutingDiffPath() != null) {  
                if (clusterMetadataManifest.getDiffManifest() != null
                throw e;  
        this.cleanupMaxBatches = clusterSettings.get(REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING);
            logger.error("Unexpected error while deleting stale Remote Cluster Metadata files", e);
                if (clusterMetadataManifest.getClusterBlocksMetadata() != null
            // (for example the first 10 if not new manifests are uploaded in between)
                int batchesProcessed = 0;
     */
                    if (Objects.nonNull(batchManifests) && batchManifests.size() > manifestsToRetain) {
import org.apache.logging.log4j.LogManager;
                                    "Indices routing paths in stale manifest: {}",
        }
                }
                                "Indices routing diff paths in stale manifest: {}",
            );
     * Setting to specify the batch size for manifest cleanup operations  
                    });  
        public void validate(Integer value) {}
                        .filter(file -> filesToKeep.contains(file) == false)
            Set<String> staleIndexRoutingDiffPaths = new HashSet<>();
import org.opensearch.core.common.Strings;
    @Override
                staleIndexMetadataPaths.size(),
        throws IOException {
    }  
        clusterSettings.addSettingsUpdateConsumer(REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING, this::updateCleanupInterval);  
        protected String getThreadPool() {  
                        );
        BlobContainer blobContainerForDeletion = remoteClusterStateService.getBlobStore().blobContainer(BlobPath.cleanPath());
            FutureUtils.cancel(future);
 */  
 * A Manager which provides APIs to clean up stale cluster state files and runs an async stale cleanup task  
                    List<BlobMetadata> batchManifests = getBlobStoreTransferService().listAllInSortedOrder(
                    filesToKeep.add(clusterMetadataManifest.getGlobalMetadataFileName());
        MANIFEST_CLEANUP_BATCH_SIZE_DEFAULT,
    public static final Setting<Integer> REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING = Setting.intSetting(
     * Deletes older than last {@code versionsToRetain} manifests. Also cleans up unreferenced IndexMetadata associated with older manifests
            remoteStateStats.cleanUpAttemptFailed();
            }
                        if (!filesToKeep.contains(uploadedIndicesRouting.getUploadedFilename())) {  
    );  
            assert !Strings.isNullOrEmpty(currentAppliedState.getClusterName().value()) : "cluster name is not set";
        new RemoteClusterStateCleanupBatchSizeValidator(),  
                    @Override
                            ),  
        if (staleFileDeletionTask != null) {
                    && !filesToKeep.contains(clusterMetadataManifest.getClusterBlocksMetadata().getUploadedFilename())) {
            "Starting batched cleanup for cluster [{}] with batch size [{}] and retaining [{}] manifests. Maximum batches to be attempted will be [{}]",
                        .stream()
        this.cleanupBatchSize = clusterSettings.get(REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING);
                        }
    }
                    clusterMetadataManifest.getCustomMetadataMap()  
                    // Update version only after successful completion
     * @param clusterUUID uuid of cluster state to refer to in remote
    private TimeValue staleFileCleanupInterval;
            }
        logger.info("updated remote state cleanup interval to {}", updatedInterval);
    public void deleteStaleClusterUUIDs(ClusterState clusterState, ClusterMetadataManifest committedManifest) {
        );  
 * @opensearch.internal
                        deleteClusterMetadata(clusterName, clusterUUID, batchManifests.subList(0, manifestsToRetain), manifestsToDeletes);
            // files after deleting manifests
                    currentAppliedState.getClusterName().value(),
            logger.error("Error while fetching Remote Cluster Metadata manifests", e);
            return true;  
                                )  
                        logger.trace(  
                    currentAppliedState.metadata().clusterUUID(),
            if (cleanupBatchSize <= RETAINED_MANIFESTS) {  
                    e
            staleManifestBlobMetadata.forEach(blobMetadata -> {  
            future.get(timeout.seconds(), TimeUnit.SECONDS);  
     * @param committedManifest last committed ClusterMetadataManifest  
    }  
                    }
import java.util.HashSet;
        });
     * @param clusterName name of the cluster  
                remoteClusterStateCleanupManager.getStaleFileCleanupInterval(),  
            staleFileDeletionTask.setInterval(updatedInterval);
            logger.debug("Deleting stale cluster UUIDs data from remote [{}]", clusterName);
            Set<String> allClustersUUIDsInRemote;  
            throw new IOException("Future got interrupted", e);  
        this.remoteClusterStateService = remoteClusterStateService;
                    } else {  
            remoteClusterStateCleanupManager.cleanUpStaleFiles();
                    filesToKeep.add(clusterMetadataManifest.getSettingsMetadata().getUploadedFilename());
        PlainActionFuture<Void> future = new PlainActionFuture<>();  
            cleanupMaxBatches
                    e  
        }  
                throw new IllegalArgumentException(
            staleFileDeletionTask.close();
     * Min value -1 indicates that the stale file cleanup job should be disabled
        }  
                        break;  
                    lastCleanupAttemptStateVersion = cleanUpAttemptStateVersion;  
                } else {  
 */  
            // todo: Avoid repetitive fetch of manifestsToRetain across batches if they were fetched earlier and are the same
        @Override  
            this.remoteClusterStateCleanupManager = remoteClusterStateCleanupManager;  
                    logger.info("Completed cleaning up all stale cluster-state metadata files in [{}] batches", batchesProcessed);
        if (blobContainerForDeletion instanceof AsyncMultiStreamBlobContainer) {  
        this.clusterApplierService = clusterService.getClusterApplierService();
 * compatible open source license.
        if (deleteStaleMetadataRunning.compareAndSet(false, true) == false) {
                throw e;  
                        .forEach(uploadedIndicesRouting -> filesToKeep.add(uploadedIndicesRouting.getUploadedFilename()));
                if (clusterMetadataManifest.getClusterStateCustomMap() != null) {
        public void validate(final Integer cleanupBatchSize, final Map<Setting<?>, Object> settings) {
            staleGlobalMetadataPaths.add(
            });
                    remoteManifestManager.getManifestFolderPath(clusterName, clusterUUID).buildAsString() + blobMetadata.name()
        1,
     * @param clusterName name of the cluster  
            } finally {
        private final RemoteClusterStateCleanupManager remoteClusterStateCleanupManager;  
/*  
    private volatile int cleanupMaxBatches;  
import java.io.Closeable;
import java.util.concurrent.ExecutionException;
                    public void onFailure(Exception e) {
    }
    }
                }  
 *
    /**  
                        logger.debug(
                        .values()
import org.opensearch.common.blobstore.AsyncMultiStreamBlobContainer;  
    // package private for testing
                    if (filesToKeep.contains(clusterMetadataManifest.getCoordinationMetadata().getUploadedFilename()) == false) {  
                        RETAINED_MANIFESTS  
                    filesToKeep.add(clusterMetadataManifest.getDiscoveryNodesMetadata().getUploadedFilename());
                    }  
                    + "[{}] stale Index Metadata files, [{}] stale Ephemeral Metadata files, "
                    filesToKeep.add(clusterMetadataManifest.getClusterBlocksMetadata().getUploadedFilename());
    void deleteStaleClusterMetadata(String clusterName, String clusterUUID, int manifestsToRetain, long cleanUpAttemptStateVersion) {  
                            logger.trace(
    /**  
                        .values()
                logger.error(  
            activeManifestBlobMetadata.forEach(blobMetadata -> {  
                if (batchesProcessed == cleanupMaxBatches) {
import static org.opensearch.gateway.remote.model.RemoteGlobalMetadata.GLOBAL_METADATA_FORMAT;  
        }
    private static final Logger logger = LogManager.getLogger(RemoteClusterStateCleanupManager.class);  
        } catch (IOException e) {
import org.opensearch.action.support.PlainActionFuture;
    public static final String REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING_NAME = "cluster.remote_store.state.cleanup.max_batches";
    /**
            allClustersUUIDsInRemote.remove(committedManifest.getClusterUUID());
import org.opensearch.common.util.concurrent.AbstractAsyncTask;
                        remoteStateStats.cleanUpAttemptFailed();  
    AtomicBoolean isDeleteStaleMetadataRunning() {
    private void updateCleanupBatchSize(Integer updatedBatchSize) {
    private void updateCleanupInterval(TimeValue updatedInterval) {
            deleteAsyncInternal((AsyncMultiStreamBlobContainer) blobContainerForDeletion, stalePaths, DEFAULT_DELETION_TIMEOUT);
                true
    RemotePersistenceStats getStats() {  
    }
import java.util.Objects;  
                        .forEach(attribute -> filesToKeep.add(attribute.getUploadedFilename()));
                return;
            )  
import org.opensearch.common.util.concurrent.FutureUtils;
                    clusterMetadataManifest.getCustomMetadataMap()  
                    batchesProcessed++;
        }
        "cluster.remote_store.state.cleanup_interval",
        @Override
        } catch (ExecutionException e) {
 * The OpenSearch Contributors require contributions made to  
    }  
     *
        }  
                );  
     */
                allClustersUUIDsInRemote = new HashSet<>(
                }
    }  
import org.apache.logging.log4j.Logger;
            } else {
                }  
                    public void onResponse(Void unused) {
            remoteStateStats.cleanUpAttemptFailed();  
                );
package org.opensearch.gateway.remote;
        ClusterSettings clusterSettings = clusterService.getClusterSettings();
    /**
                staleGlobalMetadataPaths.size(),
        try {
                // throw exception as we do not want to fail repeatedly on all batches
                    currentAppliedState.metadata().clusterUUID(),  
                staleManifestPaths.size(),  
                    )
        } catch (Exception e) {
        } else {
                    String.format(
                    && !filesToKeep.contains(clusterMetadataManifest.getTransientSettingsMetadata().getUploadedFilename())) {
            long cleanUpAttemptStateVersion = currentAppliedState.version();
public class RemoteClusterStateCleanupManager implements Closeable {
                    SKIP_CLEANUP_STATE_CHANGES
    }
                                    uploadedIndicesRouting.getUploadedFilename()
        }
        REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING_NAME,  
                        staleIndexMetadataPaths.add(fileName);  
                            e
                );
        assert blobContainerForDeletion != null;
    private final RemotePersistenceStats remoteStateStats;
                remoteRoutingTableService.deleteStaleIndexRoutingDiffPaths(new ArrayList<>(staleIndexRoutingDiffPaths));
            }
    private RemoteManifestManager remoteManifestManager;  
    );  
        } else {
                        remoteManifestManager.getManifestFolderPath(clusterName, clusterUUID),
    private long lastCleanupAttemptStateVersion;  
            clusterName,
                    clusterUUID,  
                    + "[{}] stale Index Routing files and [{}] stale Index routing diff files",
                // throw exception as we do not want to fail repeatedly on all batches
                if (clusterMetadataManifest.getClusterStateCustomMap() != null) {
import java.util.Set;
            throw new RuntimeException(e.getCause());
        return deleteStaleMetadataRunning;
                    clusterMetadataManifest.getClusterStateCustomMap()
                        );
        clusterSettings.addSettingsUpdateConsumer(REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING, this::updateCleanupBatchSize);
     */
    private void deleteAsyncInternal(AsyncMultiStreamBlobContainer blobContainerForDeletion, List<String> fileNames, TimeValue timeout)
                    currentAppliedState.getClusterName().value(),
        protected boolean mustReschedule() {
            throw e;
                    clusterName,
        try {
                    () -> new ParameterizedMessage("Error while deleting stale index routing diff files {}", staleIndexRoutingDiffPaths),
                );
        Setting.Property.Dynamic
                        .stream()
    public static final int RETAINED_MANIFESTS = 10;  
                "Processed [{}] manifests, Deleting [{}] stale Global Metadata files, "  
    void start() {  
                    filesToKeep.add(clusterMetadataManifest.getTemplatesMetadata().getUploadedFilename());
                    @Override  
                );  
                        MANIFEST,  
        threadpool.executor(ThreadPool.Names.REMOTE_PURGE).execute(() -> {  
    public static final Setting<TimeValue> REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING = Setting.timeSetting(  
            // Retain last 2 cluster uuids data  
                    addStaleGlobalMetadataPath(clusterMetadataManifest.getGlobalMetadataFileName(), filesToKeep, staleGlobalMetadataPaths);
            } catch (Exception e) {
        0,
    private static final TimeValue DEFAULT_DELETION_TIMEOUT = TimeValue.timeValueSeconds(300);  
            } catch (IOException e) {
                );  
            // Delete Manifests in the very end to avoid dangling routing files in-case deletion of stale index routing  
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.GLOBAL_METADATA_PATH_TOKEN;
        @Override
        List<BlobMetadata> activeManifestBlobMetadata,
            }
                remoteStateStats.indexRoutingFilesCleanupAttemptFailed();
            throw e;  
                        clusterUUID,  
        logger.info(  
                    staleEphemeralAttributePaths.add(clusterMetadataManifest.getHashesOfConsistentSettings().getUploadedFilename());  
    ) {
                remoteClusterStateCleanupManager.threadpool,
        @Override
    private final AtomicBoolean deleteStaleMetadataRunning = new AtomicBoolean(false);
import java.util.Locale;
    }
                if (clusterMetadataManifest.getIndicesRouting() != null) {
                e
                } else if (clusterMetadataManifest.getCodecVersion() >= ClusterMetadataManifest.CODEC_V2) {
                }
        RemoteClusterStateService remoteClusterStateService,
    static final class AsyncStaleFileDeletion extends AbstractAsyncTask {
                            RemoteClusterStateUtils.getFormattedIndexFileName(uploadedIndexMetadata.getUploadedFilename())  
    void deleteStalePaths(List<String> stalePaths) throws IOException {
                            )
    public static final TimeValue CLUSTER_STATE_CLEANUP_INTERVAL_MINIMUM = TimeValue.MINUS_ONE;
                    if (filesToKeep.contains(clusterMetadataManifest.getSettingsMetadata().getUploadedFilename()) == false) {  
            blobStoreTransferService = new BlobStoreTransferService(remoteClusterStateService.getBlobStore(), threadpool);  
                                "Exception occurred while deleting all remote cluster metadata for cluster UUID {}",
                    currentAppliedState.metadata().clusterUUID(),
            deleteStaleUUIDsClusterMetadata(clusterName, new ArrayList<>(allClustersUUIDsInRemote));  
     * Setting to specify the interval to do run stale file cleanup job  
            logger.error("Error while deleting stale Remote Cluster Metadata files", e);  
                    "Skipping cleanup of stale remote state files for cluster [{}] with uuid [{}]. Last clean was done before {} updates, which is less than threshold {}",
                    staleEphemeralAttributePaths.add(clusterMetadataManifest.getClusterBlocksMetadata().getUploadedFilename());  
    AsyncStaleFileDeletion getStaleFileDeletionTask() { // for testing
            String clusterName = clusterState.getClusterName().value();
                remoteRoutingTableService.deleteStaleIndexRoutingPaths(new ArrayList<>(staleIndexRoutingPaths));
        return this.staleFileDeletionTask;  
                        .forEach(staleGlobalMetadataPaths::add);
        logger.info("updated remote state cleanup batch size to {}", updatedBatchSize);
        }
    }
        ClusterService clusterService,
     */
            if (cleanUpAttemptStateVersion - lastCleanupAttemptStateVersion > SKIP_CLEANUP_STATE_CHANGES) {
                    }
                    e
        logger.debug(String.format(Locale.ROOT, "Deleting stale files from remote - %s", stalePaths));  
import org.opensearch.index.translog.transfer.BlobStoreTransferService;
            // throw exception as we do not want to fail repeatedly on all batches
        clusterUUIDs.forEach(
        this.lastCleanupAttemptStateVersion = 0;
            return ThreadPool.Names.REMOTE_PURGE;
                    }
            try {
                if (clusterMetadataManifest.getHashesOfConsistentSettings() != null) {
            Set<String> staleGlobalMetadataPaths = new HashSet<>();
                    String fileName = RemoteClusterStateUtils.getFormattedIndexFileName(uploadedIndexMetadata.getUploadedFilename());
            );  
                return;
        );
                }
    public static final int SKIP_CLEANUP_STATE_CHANGES = 10;
            logger.info(
            throw new IOException(
                    staleEphemeralAttributePaths.add(clusterMetadataManifest.getTransientSettingsMetadata().getUploadedFilename());
        Setting.Property.NodeScope,
        });  
                staleManifestPaths.add(  
                    }
    }  
        } catch (InterruptedException e) {
                while (batchesProcessed < cleanupMaxBatches) {  
                    }
                        List<BlobMetadata> manifestsToDeletes = batchManifests.subList(manifestsToRetain, batchManifests.size());
                        );
import java.util.List;  
                    // todo: To avoid repetitive fetch, we should use a paginated listener for each response page and act upon it  
                                clusterUUID
                    ),
import org.opensearch.common.blobstore.BlobMetadata;
        this.cleanupMaxBatches = updatedMaxBatches;
import org.opensearch.cluster.service.ClusterService;
    private final RemoteRoutingTableService remoteRoutingTableService;
                        "Cleanup Batch Size should be greater than [%s] to as we " + "retain [%s] latest manifests in remote",
    /**  
            // throw exception as we do not want to fail repeatedly on all batches
                        .filter(u -> !filesToKeep.contains(u.getUploadedFilename()))  
    }
            manifestsToRetain,
                                clusterMetadataManifest.getDiffManifest().getIndicesRoutingDiffPath()  
                logger.info(
                        .values()
     * Validates the batch size setting for cleaning up stale manifest files  
            );
        return this.remoteStateStats;
                clusterMetadataManifest.getIndices()  
                staleEphemeralAttributePaths.size(),  
import java.util.Map;
                    clusterMetadataManifest.getIndicesRouting().forEach(uploadedIndicesRouting -> {
                    && !filesToKeep.contains(clusterMetadataManifest.getHashesOfConsistentSettings().getUploadedFilename())) {
                logger.error(  
                            "Number of manifests [{}] are less than or equal to manifests to retain [{}]. Skipping deletion",
    }
                remoteStateStats.indicesRoutingDiffFileCleanupAttemptFailed();
        return blobStoreTransferService;
                    "Cleaning up stale remote state files for cluster [{}] with uuid [{}]. Last clean was done before {} updates",  
    // visible for testing  
            deleteStalePaths(new ArrayList<>(staleManifestPaths));
        this.cleanupBatchSize = updatedBatchSize;  
    public TimeValue getStaleFileCleanupInterval() {
        Setting.Property.NodeScope,  
            try {  
                    clusterName,  
                if (clusterMetadataManifest.getHashesOfConsistentSettings() != null
        REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING_NAME,  
        }
                ClusterMetadataManifest clusterMetadataManifest = remoteManifestManager.fetchRemoteClusterMetadataManifest(
    // visible for testing  
import java.util.ArrayList;
                if (clusterMetadataManifest.getClusterBlocksMetadata() != null) {
                            new ParameterizedMessage(  
        clusterSettings.addSettingsUpdateConsumer(REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING, this::updateCleanupMaxBatches);
                logger.debug("Released cleanup lock for cluster [{}]", clusterName);
            blobContainerForDeletion.deleteBlobsAsyncIgnoringIfNotExists(fileNames, future);
import org.apache.logging.log4j.message.ParameterizedMessage;  
                            batchManifests.size(),  
                clusterMetadataManifest.getIndices().forEach(uploadedIndexMetadata -> {  
     */
                }
                    );
    ) throws IOException {  
    static final class RemoteClusterStateCleanupBatchSizeValidator implements Setting.Validator<Integer> {
                logger.debug(  
        }
            assert !Strings.isNullOrEmpty(currentAppliedState.metadata().clusterUUID()) : "cluster uuid is not set";  
                    cleanUpAttemptStateVersion  
import static org.opensearch.gateway.remote.model.RemoteClusterMetadataManifest.MANIFEST;
    }
                    splitPath[splitPath.length - 1]  
                logger,
        } catch (TimeoutException e) {  
    void deleteStaleUUIDsClusterMetadata(String clusterName, List<String> clusterUUIDs) {  
        CLUSTER_STATE_CLEANUP_INTERVAL_MINIMUM,  
     * Setting to specify the maximum number of batches to process during cleanup  
                    filesToKeep.add(clusterMetadataManifest.getTransientSettingsMetadata().getUploadedFilename());
        remoteManifestManager = remoteClusterStateService.getRemoteManifestManager();
            Set<String> staleManifestPaths = new HashSet<>();  
        threadpool.executor(ThreadPool.Names.REMOTE_PURGE).execute(() -> {
                    clusterMetadataManifest.getClusterStateCustomMap()  
    }
import java.io.IOException;  
        if (staleFileDeletionTask != null && !staleFileDeletionTask.getInterval().equals(updatedInterval)) {  
                logger.error(  
     * @param manifestsToRetain no of latest manifest files to keep in remote
                }
        return this.staleFileCleanupInterval;
        this.remoteRoutingTableService = remoteRoutingTableService;  
                    remoteClusterStateService.getBlobStoreRepository(),
     *
        // initialize with 0, a cleanup will be done when this node is elected master node and version is incremented more than threshold
        MANIFEST_CLEANUP_MAX_BATCHES_DEFAULT,
            }
            } catch (IOException e) {
    public void close() throws IOException {  
    public static final int MANIFEST_CLEANUP_BATCH_SIZE_DEFAULT = 1000;
            allClustersUUIDsInRemote.remove(committedManifest.getPreviousClusterUUID());
                    clusterMetadataManifest.getIndicesRouting()
import java.util.concurrent.TimeoutException;
        this.staleFileCleanupInterval = clusterSettings.get(REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING);  
                } else if (clusterMetadataManifest.getCodecVersion() >= ClusterMetadataManifest.CODEC_V2) {
        logger.info("updated remote state cleanup max batches to {}", updatedMaxBatches);  
            }
    public static final String REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING_NAME = "cluster.remote_store.state.cleanup.batch_size";
                );
                        RETAINED_MANIFESTS,
            logger.info("Delete stale cluster metadata task is already in progress.");
                    new ParameterizedMessage(
                        staleGlobalMetadataPaths.add(clusterMetadataManifest.getCoordinationMetadata().getUploadedFilename());
        ClusterState currentAppliedState = clusterApplierService.state();
                deleteStaleMetadataRunning.set(false);  
        @Override
    // package private for testing
                logger.debug("No stale Remote Cluster Metadata files found");
        String clusterUUID,  
            if (staleManifestPaths.isEmpty()) {  
    // visible for testing  
                            () -> new ParameterizedMessage(
                }
                staleIndexRoutingPaths.size(),
                        uploadedIndexMetadata -> filesToKeep.add(
     */
                                () -> new ParameterizedMessage(  
                    }
import java.util.concurrent.atomic.AtomicBoolean;
    /**
            try {  
        }  
                        staleIndexRoutingDiffPaths.add(clusterMetadataManifest.getDiffManifest().getIndicesRoutingDiffPath());
            Set<String> staleIndexMetadataPaths = new HashSet<>();
        if (!filesToKeep.contains(fileName)) {
