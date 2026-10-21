        final Repository repository = repositoriesService.repository(repositoryName);
import org.opensearch.threadpool.ThreadPool;
                    public void onFailure(String source, Exception e) {
                                            () -> new ParameterizedMessage(
        return ThreadPool.Names.SAME;
    CleanupRepositoryRequest,
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
import org.apache.logging.log4j.message.ParameterizedMessage;
    private static final Logger logger = LogManager.getLogger(TransportCleanupRepositoryAction.class);
                        }
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.repositories.RepositoriesService;
    @Inject
                                @Override
                            return removeInProgressCleanup(currentState);
import org.apache.logging.log4j.Logger;
                        @Override
                            .putCustom(
                                    + repositoryCleanupInProgress
            if (event.localNodeClusterManager() && event.previousState().nodes().isLocalNodeElectedClusterManager() == false) {
 *     <li>Run cleanup actions on the repository. Note, these are executed exclusively on the cluster-manager node.
                clusterService.submitStateUpdateTask(
        }
import org.opensearch.cluster.RepositoryCleanupInProgress;
        );
            remoteStoreSettings.getSegmentsPathFixedPrefix()
import org.opensearch.repositories.RepositoryData;
                                    + "]"
                            SnapshotDeletionsInProgress.EMPTY
                        threadPool.executor(ThreadPool.Names.SNAPSHOT)
                    @Override
            remoteStoreSettings.getSegmentsPathFixedPrefix(),
                    }
    }
                    private boolean startedCleanup = false;
 */
                                        e
                                    }
                                        logger.info(
}
                            logger.debug("No cleanup task to remove from cluster state because we failed to start one", failure);
                                ActionRunnable.wrap(
                        }
            CleanupRepositoryRequest::new,
                                }
                            .execute(
                        }
        return currentState.custom(RepositoryCleanupInProgress.TYPE, RepositoryCleanupInProgress.EMPTY).hasCleanupInProgress()
    protected String executor() {
                            logger.debug("Removed repository cleanup task [{}] from cluster state", repositoryCleanupInProgress);
                new ClusterStateUpdateTask() {
                            logger.warn("Failed to remove repository cleanup task [{}] from cluster state", repositoryCleanupInProgress);
import org.opensearch.repositories.RepositoryCleanupResult;
    private void cleanupRepo(String repositoryName, ActionListener<RepositoryCleanupResult> listener) {
                        public ClusterState execute(ClusterState currentState) {
        return new CleanupRepositoryResponse(in);
import org.opensearch.cluster.service.ClusterService;
            }
                        }
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.cluster.node.DiscoveryNode;
        clusterService.addStateApplier(event -> {
                            "remove repository cleanup task [" + repositoryName + "][" + repositoryStateId + ']',
                            SnapshotDeletionsInProgress.TYPE,
                                    repositoryStateId
                            )
                        if (failure == null) {
                        assert failure != null || result != null;
 * {@link BlobStoreRepository#cleanup} ensures that the repository state id has not changed between creation of the cluster state entry
/*
                                        ActionListener.wrap(result -> after(null, result), e -> after(e, null))
                                            result
        this.remoteStoreLockManagerFactory = new RemoteStoreLockManagerFactory(
    protected ClusterBlockException checkBlock(CleanupRepositoryRequest request, ClusterState state) {
import org.opensearch.cluster.ClusterState;
    @Override
                            return;
    }
            listener.onFailure(new IllegalArgumentException("Repository [" + repositoryName + "] does not support repository cleanup"));
                                        remoteStoreLockManagerFactory,
        cleanupRepo(request.name(), ActionListener.map(listener, CleanupRepositoryResponse::new));
import org.opensearch.repositories.blobstore.BlobStoreRepository;
                                        e.addSuppressed(failure);
            clusterService.submitStateUpdateTask(
                            listener.onFailure(failure);
 * software distributed under the License is distributed on an
                            RepositoryCleanupInProgress.TYPE,
import org.opensearch.cluster.SnapshotsInProgress;
                                    + "]"
                                        snapshotsService.minCompatibleVersion(newState.nodes().getMinNodeVersion(), repositoryData, null),
    }
                            );
                                        remoteSegmentStoreDirectoryFactory,
    private static void addClusterStateApplier(ClusterService clusterService) {
import java.io.IOException;
                                    + "] - a repository cleanup is already in-progress in ["
    }
        }, listener::onFailure);
 */
    private final RemoteStoreLockManagerFactory remoteStoreLockManagerFactory;
public final class TransportCleanupRepositoryAction extends TransportClusterManagerNodeAction<
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
 *     <li>Remove the entry in {@link RepositoryCleanupInProgress} in the first step.</li>
                                    + repositoryName
        });
    CleanupRepositoryResponse> {
            threadPool,
 * specific language governing permissions and limitations
                                "Cannot cleanup ["
                                            "Done with repository cleanup on [{}][{}] with result [{}]",
 *     <li>Check that there are no running repository cleanup, snapshot create, or snapshot delete actions
                                        repositoryStateId,
                        if (deletionsInProgress.hasDeletionsInProgress()) {
                    .custom(RepositoryCleanupInProgress.TYPE, RepositoryCleanupInProgress.EMPTY);
                                            ),
import org.opensearch.cluster.block.ClusterBlockException;
    ) {
                            throw new IllegalStateException(
                    public ClusterState execute(ClusterState currentState) {
            CleanupRepositoryAction.NAME,
                                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            addClusterStateApplier(clusterService);
     * Runs cleanup operations on the given repository.
 * Repository cleanup action for repository implementations based on {@link BlobStoreRepository}.
                        public void onFailure(String source, Exception e) {
                    @Override
                        after(e, null);
 * @opensearch.internal
        super(
    private final RemoteSegmentStoreDirectoryFactory remoteSegmentStoreDirectoryFactory;
        ActionFilters actionFilters,
 * The steps taken by the repository cleanup operation are as follows:
        );
            indexNameExpressionResolver
                        }
                        public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
     * @param repositoryName Repository to clean up
                        clusterService.submitStateUpdateTask(
                                                "Failed to run repository cleanup operations on [{}][{}]",
            dataFormatRegistry
        }
import org.opensearch.cluster.ClusterStateUpdateTask;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    "clean up repository cleanup task after cluster-manager failover",
 * <ol>
        ActionListener<CleanupRepositoryResponse> listener
                        startedCleanup = true;
        ClusterService clusterService,
import org.opensearch.common.inject.Inject;
import org.opensearch.action.support.ActionFilters;
 */
        final BlobStoreRepository blobStoreRepository = (BlobStoreRepository) repository;
 *
    }
                        @Override
                final RepositoryCleanupInProgress repositoryCleanupInProgress = event.state()
                            );
                                )
        this.repositoriesService = repositoriesService;
                                        listener.onFailure(failure);
 *     http://www.apache.org/licenses/LICENSE-2.0
        );
        final StepListener<RepositoryData> repositoryDataListener = new StepListener<>();
                        logger.debug("Initialized repository cleanup in cluster state for [{}][{}]", repositoryName, repositoryStateId);
                        SnapshotsInProgress snapshots = currentState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
import org.opensearch.core.action.ActionListener;
            logger.info("Running cleanup operations on repository [{}][{}]", repositoryName, repositoryStateId);
                                )
            transportService,
                                "Cannot cleanup ["
 *     and add an entry for the repository that is to be cleaned up to {@link RepositoryCleanupInProgress}</li>
        ThreadPool threadPool,
            );
        repository.getRepositoryData(repositoryDataListener);
 * license agreements. See the NOTICE file distributed with
        CleanupRepositoryRequest request,
        // We add a state applier that will remove any dangling repository cleanup actions on cluster-manager failover.
            clusterService,
                                        () -> new ParameterizedMessage("[{}] failed to remove repository cleanup task", repositoryName),
import java.util.Collections;
 *
import org.apache.logging.log4j.LogManager;
 * </ol>
                            logger.debug("Finished repository cleanup operations on [{}][{}]", repositoryName, repositoryStateId);
                            );
                    }
            actionFilters,
        IndexNameExpressionResolver indexNameExpressionResolver,
                        return ClusterState.builder(currentState)
                    return;
 * compatible open source license.
            return;
 * this work for additional information regarding copyright
                            new ClusterStateUpdateTask() {
                    @Override
                        if (snapshots.entries().isEmpty() == false) {
    @Override
                                    } else {
                                    + "] - a snapshot is currently being deleted in ["
                                    );
    private final SnapshotsService snapshotsService;
                                }
        // operations from corrupting the repository. This is the same safety mechanism used by snapshot deletes.
                                public ClusterState execute(ClusterState currentState) {
            threadPool,
    public TransportCleanupRepositoryAction(
    protected CleanupRepositoryResponse read(StreamInput in) throws IOException {
                                @Override
                        final SnapshotDeletionsInProgress deletionsInProgress = currentState.custom(
        ClusterState state,
                            );
import org.opensearch.cluster.block.ClusterBlockLevel;
    ) {
 * Modifications Copyright OpenSearch Contributors. See
                                    Collections.singletonList(RepositoryCleanupInProgress.startedEntry(repositoryName, repositoryStateId))
                }
                    private void after(@Nullable Exception failure, @Nullable RepositoryCleanupResult result) {
                                    repositoryName,
                    }
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
        repositoryDataListener.whenComplete(repositoryData -> {
import org.opensearch.snapshots.SnapshotsService;
            () -> repositoriesService,
 *     For the precise operations execute see {@link BlobStoreRepository#cleanup}</li>
                                    "Failed to finish repository cleanup operations on [{}][{}]",
                                public void onFailure(String source, Exception e) {
        if (DiscoveryNode.isClusterManagerNode(clusterService.getSettings())) {
import org.opensearch.core.common.io.stream.StreamInput;
                                @Override
                                    )
                "cleanup repository [" + repositoryName + "][" + repositoryStateId + ']',
 * On cluster-manager failover during the cleanup operation it is simply removed from the cluster state. This is safe because the logic in
                        } else {
                            );
                                    return removeInProgressCleanup(currentState);
 * SPDX-License-Identifier: Apache-2.0
                                        logger.warn(
        TransportService transportService,
                    new ClusterStateUpdateTask() {
import org.opensearch.common.Nullable;
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
import org.opensearch.index.store.lockmanager.RemoteStoreLockManagerFactory;
                                    if (failure != null) {
                                    + repositoryName
                                            failure
/*
                            RepositoryCleanupInProgress.EMPTY
                        }
                                new RepositoryCleanupInProgress(
            : currentState;
    }
     */
import org.opensearch.transport.TransportService;
     * @param listener Listener for cleanup result
        RemoteStoreSettings remoteStoreSettings,
                                        );
                                    listener,
                                            repositoryStateId,
 *                                        as well as deletes.
    @Override
 * under the License.
                                RepositoryCleanupInProgress.TYPE,
                        );
 *
                            .build();
 *
import org.opensearch.index.store.RemoteSegmentStoreDirectoryFactory;
    }
 * ownership. Elasticsearch licenses this file to you under
            () -> repositoriesService,
            final long repositoryStateId = repositoryData.getGenId();
    private static ClusterState removeInProgressCleanup(final ClusterState currentState) {
                                        );
package org.opensearch.action.admin.cluster.repositories.cleanup;
                                                repositoryName,
                                            repositoryName,
                                    if (failure == null) {
        this.remoteSegmentStoreDirectoryFactory = new RemoteSegmentStoreDirectoryFactory(
 * Unless required by applicable law or agreed to in writing,
                                    l -> blobStoreRepository.cleanup(
/*
 * this file be licensed under the Apache-2.0 license or a
        // This is safe to do since cleanups will increment the repository state id before executing any operations to prevent concurrent
/**
            ? ClusterState.builder(currentState).putCustom(RepositoryCleanupInProgress.TYPE, RepositoryCleanupInProgress.EMPTY).build()
import org.opensearch.repositories.Repository;
        SnapshotsService snapshotsService,
                                    listener.onFailure(e);
                    }
    }
 * The OpenSearch Contributors require contributions made to
    private final RepositoriesService repositoriesService;
import org.opensearch.action.StepListener;
                            logger.debug(
                if (repositoryCleanupInProgress.hasCleanupInProgress() == false) {
 * not use this file except in compliance with the License.
                                "Cannot cleanup [" + repositoryName + "] - a snapshot is currently running in [" + snapshots + "]"
import org.opensearch.cluster.SnapshotDeletionsInProgress;
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
 */
                        if (repositoryCleanupInProgress.hasCleanupInProgress()) {
                }
                        }
import org.opensearch.action.ActionRunnable;
                                ),
        this.snapshotsService = snapshotsService;
                        @Override
                            }
    protected void clusterManagerOperation(
        @Nullable DataFormatRegistry dataFormatRegistry
                            throw new IllegalStateException(
                                failure
                                        listener.onResponse(result);
 * <p>
 *
                                    + deletionsInProgress
                        }
                        final RepositoryCleanupInProgress repositoryCleanupInProgress = currentState.custom(
                                    logger.warn(
                                    }
 * and any delete/write operations. TODO: This will not work if we also want to clean up at the shard level as those will involve writes
                                                repositoryStateId
                );
 * You may obtain a copy of the License at
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                    }
    /**
                                }
                        );
        RepositoriesService repositoriesService,
import org.opensearch.indices.RemoteStoreSettings;
                            throw new IllegalStateException(
                        );
                                () -> new ParameterizedMessage(
                        if (startedCleanup == false) {
        // Cluster is not affected but we look up repositories in metadata
    @Override
        if (repository instanceof BlobStoreRepository == false) {
