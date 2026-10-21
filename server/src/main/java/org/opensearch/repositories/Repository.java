     * Returns the list of restricted system repository settings that cannot be mutated post repository creation.
import org.opensearch.Version;
        Map<SnapshotId, Long> snapshotIdsPinnedTimestampMap,
 * KIND, either express or implied.  See the License for the
 */
        @Nullable String shardGeneration,
        boolean isShallowSnapshotV2,
    /**
     * Deletes snapshots and releases respective lock files from remote store repository
     * {@link ClusterState} that is passed here.
     *
    void cloneShardSnapshot(
    void snapshotShard(
    default List<Setting<?>> getRestrictedSystemRepositorySettings() {
     * @param snapshotInfo     SnapshotInfo instance to write for this snapshot
     * cluster state.
     */
     * {@link IndexShardSnapshotStatus#isAborted()} to see if the snapshot process should be aborted.
     * @param repositoryUpdatePriority  priority for the cluster state update task
            snapshotIndexCommit,
     * @param store                 store to be snapshotted
     * Returns upload throttle time in nanoseconds
import org.opensearch.common.settings.Setting;
    default void snapshotRemoteStoreIndexShard(
            repositoryMetaVersion,
    /**
     */
     * The index commit point can be obtained by using {@link org.opensearch.index.engine.Engine#acquireLastIndexCommit} method.
    }
     * @param listener        listener to invoke once done
     */
            shardStateIdentifier,
     * @return snapshot status
        RemoteSegmentStoreDirectoryFactory remoteSegmentStoreDirectoryFactory,
     */
        Map<String, Object> userMetadata,
     * one point in time like for example, checking if a snapshot is in the repository before adding the delete operation for it to the
     * See {@link org.opensearch.plugins.RepositoryPlugin}.
import org.opensearch.snapshots.SnapshotInfo;
     */
    /**
     * @param snapshotStatus           snapshot status
}
    );
     * Returns the native (Rust) object store wrapper for this repository, or
        Version repositoryMetaVersion,
     * This allows for operations on the repository that need a consistent view of both the cluster state and the repository contents at
         * @param metadata    metadata for the repository including name and settings
            mapperService,
        throw new UnsupportedOperationException();
     * Deletes snapshots and releases respective lock files from remote store repository.
import org.opensearch.snapshots.SnapshotId;
    void restoreShard(
     */
     *
        Store store,
     *
 * Implementations are responsible for reading and writing both metadata and shard data to and from
     *
         * Constructs a repository.
     */
     * @param state new cluster state
    /**
     * <p>
    long getRestoreThrottleTimeInNanos();
     * Repository implementations shouldn't release the snapshot index commit point. It is done by the method caller.
        /**
     */
        long repositoryStateId,
        return RepositoryStats.EMPTY_STATS;
public interface Repository extends LifecycleComponent {
    }
        Store store,
     * @opensearch.api
    /**
     * @param shardId    shard id
    void verify(String verificationToken, DiscoveryNode localNode);
     *                              is used to remove any state tracked for the in-progress snapshot from the cluster state
 * under the License.
     */
    );
    default void deleteSnapshotsAndReleaseLockFiles(
     * @param createUpdateTask function to supply cluster state update task
     * @param source                        source snapshot
     * Hook that allows a repository to filter the user supplied snapshot metadata in {@link SnapshotsInProgress.Entry#userMetadata()}
     */
     */
     * @param indexId         id of the index in the repository from which the restore is occurring
import java.util.function.Function;
     *                                 to detect if the shard has changed between snapshots. If {@code null} is passed as the identifier
     * @param clusterMetadata       cluster metadata
     */
     * @param shardId    shard id
    /**
        throw new UnsupportedOperationException();
 * a repository backend.
        IndexShardSnapshotStatus snapshotStatus,
        ActionListener<String> listener
        IndexShardSnapshotStatus snapshotStatus,
     * @return true if the repository can be reloaded inplace, false otherwise
        long commitGeneration,
        Version repositoryMetaVersion,
     * @param shardId         shard id
     * @param snapshotIndexCommit   commit point
     * @param snapshotId               snapshot id
        Map<String, Object> userMetadata,
        IndexShardSnapshotStatus snapshotStatus,
    /**
    /**
        RemoteSegmentStoreDirectoryFactory remoteSegmentStoreDirectoryFactory,
        SnapshotId snapshotId,
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
        ActionListener<RepositoryData> listener
    /**
     * <p>
     * Returns stats on the repository usage
    /**
     */
     * Adds a reference of remote store data for a index commit point.
     * @param store                    store to be snapshotted
     * Repository implementations shouldn't release the snapshot index commit point. It is done by the method caller.
    /**
        Metadata clusterMetadata,
    );
     *                                 snapshotting will be done by inspecting the physical files referenced by {@code snapshotIndexCommit}
     * @param snapshotIndexCommit      commit point
    void deleteSnapshots(
     * Returns Snapshot Shard Metadata for remote store interop enabled snapshot.
import org.apache.lucene.index.IndexCommit;
     *
     * @param repositoryMetaVersion                 version of the updated repository metadata to write
    /**
    void getRepositoryData(ActionListener<RepositoryData> listener);
        long repositoryStateId,
        RemoteStoreLockManagerFactory remoteStoreLockManagerFactory,
     */
     * @param mapperService         the shards mapper service
     * @return the native (Rust) object store wrapper, or {@link NativeStoreRepository#EMPTY} if not available
 * ownership. Elasticsearch licenses this file to you under
     * The index commit point can be obtained by using {@link org.opensearch.index.engine.Engine#acquireLastIndexCommit} method.
     * Returns snapshot throttle time in nanoseconds
        @Nullable String shardStateIdentifier,
     *
     * during snapshot initialization.
        @Nullable String shardGeneration,
        IndexId indexId,
     * @return list of settings
    void endVerification(String verificationToken);
    }
        throw new UnsupportedOperationException();
        return userMetadata;
    default void cloneRemoteStoreIndexShardSnapshot(
     * Repository implementations shouldn't release the snapshot index commit point. It is done by the method caller.
     * @param repositoryData current {@link RepositoryData}
    /**
     * @param snapshotId               snapshot id
     * @param primaryTerm              current Primary Term
        String source,
    /**
    }
     * @param listener                              completion listener
     * <p>
    ) {
     * {@link NativeStoreRepository#EMPTY} if native object store is not supported or not initialized.
     * and the indices across all snapshots found in the repository.  Throws a {@link RepositoryException}
     */
        ShardId snapshotShardId,
     * @param listener              listener invoked on completion
     * @param verificationToken value returned by {@link org.opensearch.repositories.Repository#startVerification()}
    /**
     * The index commit point can be obtained by using {@link org.opensearch.index.engine.Engine#acquireLastIndexCommit} method.
     * @param shardGenerations      updated shard generations
        Version repositoryMetaVersion,
        Version repositoryMetaVersion,
        Consumer<Exception> onFailure
     * The index can be renamed on restore, hence different {@code shardId} and {@code snapshotShardId} are supplied.
     * Retrieve shard snapshot status for the stored snapshot
     * @param snapshotStatus           snapshot status
import java.util.List;
 *
     * @throws IllegalStateException if the native store has been closed
     * @param repositoryMetaVersion version of the updated repository metadata to write
     */
     * @param snapshotIds
     * Returns restore throttle time in nanoseconds
     * @param repositoryStateId
    default RemoteStoreShardShallowCopySnapshot getRemoteStoreShallowCopyShardMetadata(
     * @param listener              listener to be invoked with the new {@link RepositoryData} after completing the snapshot
     * @param onFailure        error handler invoked on failure to get a consistent view of the current {@link RepositoryData}
 * GitHub history for details.
    default void snapshotRemoteStoreIndexShard(
     * @param userMetadata          user metadata of the snapshot found in {@link SnapshotsInProgress.Entry#userMetadata()}
import org.opensearch.common.Nullable;
    ) {
     * @param snapshotStatus        snapshot status
    }
 * <ul>
 * this work for additional information regarding copyright
    ) {
    }
     * <p>
     * As snapshot process progresses, implementation of this method should update {@link IndexShardSnapshotStatus} object and check
     * <p>
        IndexId indexId,
        @Nullable String shardStateIdentifier,
     * repository implementation. Callers must NOT cache or use the wrapper across
        SnapshotId snapshotId,
     * Or for closed index can be obtained by reading last remote uploaded metadata by using {@link org.opensearch.index.shard.IndexShard#fetchLastRemoteUploadedSegmentMetadata()} method.
     * @param snapshotId  snapshot id
    default void deleteSnapshotsInternal(
 * You may obtain a copy of the License at
        Function<RepositoryData, ClusterStateUpdateTask> createUpdateTask,
        Collection<SnapshotId> snapshotIds,
        @Nullable IndexMetadata indexMetadata
/*
     * @param listener              completion listener
 *
    default boolean isReloadableSettings(RepositoryMetadata newRepositoryMetadata) {
     * @param stateTransformer      a function that filters the last cluster state update that the snapshot finalization will execute and
     */
    /**
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService,
     * Deletes snapshots
        long startTime,
    /**
     *
        SnapshotId target,
        throw new UnsupportedOperationException();
    }
     *
    default void finalizeSnapshot(
import org.opensearch.cluster.metadata.IndexMetadata;
     * @param isShallowSnapshotV2                   true for shallow snapshots v2
    /**
        @Nullable IndexCommit snapshotIndexCommit,
     * <p>
import org.opensearch.cluster.metadata.RepositoryMetadata;
     * @param mapperService         the shards mapper service
     * <p>
     * Verifies repository on the cluster-manager node and returns the verification token.
     *
        SnapshotId snapshotId,
 * To perform a snapshot:
     * @param target                        target snapshot
 * for each shard</li>
        SnapshotId source,
    ) {
     * @param repositoryMetaVersion
     * @return the index metadata about the given index for the given snapshot
    IndexMetadata getSnapshotIndexMetaData(RepositoryData repositoryData, SnapshotId snapshotId, IndexId index) throws IOException;
     * @param listener              listener to be invoked with the new {@link RepositoryData} after completing the snapshot
    default Map<String, Object> adaptUserMetadata(Map<String, Object> userMetadata) {
     * @param repositoryMetaVersion version of the updated repository metadata to write
    default long getLowPriorityRemoteUploadThrottleTimeInNanos() {
     */
     * <p>
     * @param snapshotInfo snapshot info
        Version repositoryMetaVersion,
     * additional verification is required
     * @return true if the repository is system managed
     * Retrieve shard snapshot status for the stored snapshot
     * if there was an error in reading the data.
        ActionListener<RepositoryData> listener
        IndexCommit snapshotIndexCommit,
     *
     * An factory interface for constructing repositories.
 * <p>
     * <p>
import org.opensearch.index.mapper.MapperService;
        ActionListener<RepositoryData> listener
    /**
     * @param snapshotId            snapshot id
     * repository lifecycle boundaries. The wrapper is invalidated when the repository
        Function<ClusterState, ClusterState> stateTransformer,
     * Finalizes snapshotting process
    );
     * @param recoveryState   recovery state
        ActionListener<String> listener,
        Version repositoryMetaVersion,
        Map<SnapshotId, Long> snapshotsWithPinnedTimestamp,
     *
    }
     */
     */
        ActionListener<RepositoryData> listener
     */
    }
     * Finalizes snapshotting process
     * at the time the {@code RepositoryData} was loaded.
import org.opensearch.common.lifecycle.LifecycleComponent;
            store,
            null
     * Update the repository with the incoming cluster state. This method is invoked from {@link RepositoriesService#applyClusterState} and
     * @return verification token that should be passed to all Index Shard Repositories for additional verification or null
        SnapshotId snapshotId,
     *
     *
     * @return information about snapshot
     * @return snapshot status
        }
        ShardGenerations shardGenerations,
    long getRemoteUploadThrottleTimeInNanos();
        default Repository create(RepositoryMetadata metadata, Function<String, Repository.Factory> typeLookup) throws Exception {
     */
     * @param snapshotId            snapshot id
     * <p>
         */
        throw new UnsupportedOperationException();
     * @param remoteSegmentStoreDirectoryFactory    RemoteSegmentStoreDirectoryFactory to be used for cleaning up remote store segment files
     */
     * {@link IndexShardSnapshotStatus#isAborted()} to see if the snapshot process should be aborted.
     * @param indexFilesToFileLengthMap map of index files to file length
    }
        Collection<SnapshotId> snapshotIds,
     */
     * @param shardId                       shard id
        Version repositoryMetaVersion,
        throw new UnsupportedOperationException();
            snapshotStatus,
    );
 * software distributed under the License is distributed on an
        IndexCommit snapshotIndexCommit,
        Store store,
 * <li>When all shard calls return cluster-manager calls {@link #finalizeSnapshot} with possible list of failures</li>
     * @param snapshotInfo     SnapshotInfo instance to write for this snapshot
        SnapshotInfo snapshotInfo,
    long getRemoteDownloadThrottleTimeInNanos();
@PublicApi(since = "1.0.0")
        Store store,
     * task generated through {@code createUpdateTask} is guaranteed to point at the same state for this repository as the did the state
 * The OpenSearch Contributors require contributions made to
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
    /**
     * @param commitGeneration         current commit generation
     *
        ActionListener<String> listener
     * @param remoteStorePinnedTimestampService     service for pinning and unpinning of the timestamp
    /**
     * @param repositoryMetaVersion version of the updated repository metadata to write
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @param snapshotId      snapshot id
        long repositoryStateId,
     * @param startTime                start time of the snapshot commit, this will be used as the start time for snapshot.
import java.util.Collection;
     * @param snapshotId the snapshot id to load the global metadata from
     * Repository implementations shouldn't release the snapshot index commit point. It is done by the method caller.
     * The index can be renamed on restore, hence different {@code shardId} and {@code snapshotShardId} are supplied.
     * @param repositoryMetaVersion version of the updated repository metadata to write
     *
import org.opensearch.core.action.ActionListener;
     * @param stateTransformer      a function that filters the last cluster state update that the snapshot finalization will execute and
     *                              snapshotting will be done by inspecting the physical files referenced by {@code snapshotIndexCommit}
     * Returns global metadata associated with the snapshot.
        throw new UnsupportedOperationException();
     * @param target          target snapshot
     *                              is used to remove any state tracked for the in-progress snapshot from the cluster state
     * @param listener        listener to complete with new shard generation once clone has completed
     *
     * <p>Only sandbox tiered storage code should call this method. The default
     * @param index      the {@link IndexId} to load the metadata from
     * @param remoteStoreLockManagerFactory
     * @param indexId               id for the index being snapshotted
        SnapshotId snapshotId,
     * implementation returns {@link NativeStoreRepository#EMPTY} (no native store).
     * @param indexId                  id for the index being snapshotted
            indexId,
import java.util.Collections;
    /**
     *
     * This method should perform all necessary cleanup of the temporary files created in the repository
        RemoteStoreLockManagerFactory remoteStoreLockManagerFactory,
     * @param snapshotShardId shard id (in the snapshot)
     * As snapshot process progresses, implementation of this method should update {@link IndexShardSnapshotStatus} object and check
        SnapshotId snapshotId,
     * @param listener
     * Returns a {@link RepositoryData} to describe the data in the repository, including the snapshots
     * Verifies repository settings on data node.
     * @param shardStateIdentifier  a unique identifier of the state of the shard that is stored with the shard's snapshot and used
        long repositoryStateId,
 *
     * @param remoteStoreLockManagerFactory         RemoteStoreLockManagerFactory to be used for cleaning up remote store lock files
    interface Factory {
    /**
import java.io.IOException;
        IndexId indexId,
    default void deleteSnapshotsWithPinnedTimestamp(
     * {@link IndexShardSnapshotStatus#isAborted()} to see if the snapshot process should be aborted.
     * @param store           the store to restore the index into
     * @param shardGenerations      updated shard generations
import org.opensearch.core.index.shard.ShardId;
    long getSnapshotThrottleTimeInNanos();
     *
     * @param userMetadata          user metadata of the snapshot found in {@link SnapshotsInProgress.Entry#userMetadata()}
     * @param snapshotsWithPinnedTimestamp          map of snapshot ids and the pinned timestamps
    /**
     * @param clusterMetadata       cluster metadata
    IndexShardSnapshotStatus getShardSnapshotStatus(SnapshotId snapshotId, IndexId indexId, ShardId shardId);
/**
     * @param snapshotIndexCommit   commit point
     *
        long primaryTerm,
        RecoveryState recoveryState,
    void finalizeSnapshot(
     * @param store                 store to be snapshotted
import org.opensearch.index.store.Store;
    @PublicApi(since = "1.0.0")
     * @param primaryTerm              current Primary Term
     * Returns true if the repository is managed by the system directly and doesn't allow managing the lifetime of the
import org.opensearch.index.store.RemoteSegmentStoreDirectoryFactory;
import org.opensearch.indices.recovery.RecoveryState;
     * Returns the index metadata associated with the snapshot.
    }
     * If the verification token is not null, it's passed to all data nodes for verification. If it's null - no
     * @param remoteStoreLockManagerFactory remoteStoreLockManagerFactory for cloning metadata lock file
     * @param snapshotId snapshot id
     */
    /**
     * @param snapshotId the snapshot id to load the index metadata from
     */
    default void reload(RepositoryMetadata repositoryMetadata) {}
     * @param listener                 listener invoked on completion
    ) {
     * Creates a snapshot of the shard based on the index commit point.
        return false;
        SnapshotId target,
 */
     * @param remoteStorePinnedTimestampService     service for pinning and unpinning of the timestamp
package org.opensearch.repositories;
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * @param indexMetadata         index metadata for the shard being snapshotted
import org.opensearch.common.Priority;
import java.util.Map;
        Store store,
     * <p>
        long repositoryStateId,
        ActionListener<RepositoryData> listener
     * @param startTime                start time of the snapshot commit, this will be used as the start time for snapshot.
     * @param store                    store to be snapshotted
     * repository through external APIs
     * @param localNode         the local node information, for inclusion in verification errors
     * <p>The returned value is a {@link NativeStoreRepository} wrapper managed by the
            return create(metadata);
        long primaryTerm,
     */
     * @param indexId    the snapshotted index id for the shard to get status for
import org.opensearch.common.annotation.PublicApi;
     *
     *
     * Clones a shard snapshot.
     * @param repositoryStateId     the unique id identifying the state of the repository when the snapshot began
    /**
     * @param repositoryStateId                     the unique id identifying the state of the repository when the snapshot deletion began
    default RepositoryStats stats() {
     * @param snapshotIdsPinnedTimestampMap         map of snapshots ids and the pinned timestamp
    );
     *                              to detect if the shard has changed between snapshots. If {@code null} is passed as the identifier
            listener,
        ActionListener<String> listener
    /**
     * @return true if the repository is read/only
     * Adds a reference of remote store data for a index commit point.
     */
     * Reads snapshot description from repository.
     * {@link IndexShardSnapshotStatus#isAborted()} to see if the snapshot process should be aborted.
     * @param indexId         id of the index in the repository from which the restore is occurring
import org.opensearch.cluster.ClusterState;
     * Checks if the repository can be reloaded inplace or not
    ) {
        @Nullable String shardStateIdentifier,
        snapshotShard(
    default NativeStoreRepository getNativeStore() {
     * @param repositoryStateId                     the unique id identifying the state of the repository when the snapshot deletion began
 * compatible open source license.
        RepositoryShardId shardId,
     * thus the same semantics as with {@link org.opensearch.cluster.ClusterStateApplier#applyClusterState} apply for the
    /**
        SnapshotInfo snapshotInfo,
    }
 * @opensearch.api
     * Validate the repository metadata
     * @return the global metadata about the snapshot
        Priority repositoryUpdatePriority,
        ShardGenerations shardGenerations,
        ActionListener<String> listener
     */
    }
    }
     * @param listener                              completion listener
        Version repositoryMetaVersion,
        RemoteStoreLockManagerFactory remoteStoreLockManagerFactory,
        Metadata clusterMetadata,
            userMetadata,
 * <p>
    /**
     * Deletes snapshots and unpin the snapshot timestamp using remoteStorePinnedTimestampService
     *                                 snapshotting will be done by inspecting the physical files referenced by {@code snapshotIndexCommit}
        ActionListener<String> listener
     * @param indexId               id for the index being snapshotted
     */
     * @param indexId    the snapshotted index id for the shard to get status for
        ShardId snapshotShardId
    }
        );
    String startVerification();
     * @param shardGeneration shard generation in repo
/*
 *
        ActionListener<Void> listener
     * <p>
        long repositoryStateId,
import org.opensearch.cluster.ClusterStateUpdateTask;
     * <p>
 * not use this file except in compliance with the License.
     *                                 to detect if the shard has changed between snapshots. If {@code null} is passed as the identifier
     * @param verificationToken verification request generated by {@link #startVerification} command
import org.opensearch.cluster.SnapshotsInProgress;
    }
    /**
     * Restores snapshot of the shard.
     * @param shardGeneration               shard generation in repo
     * Returns restore throttle time in nanoseconds
        MapperService mapperService,
    default boolean isReloadable() {
 * An interface for interacting with a repository in snapshot and restore.
        return NativeStoreRepository.EMPTY;
    boolean isReadOnly();
    /**
import org.opensearch.cluster.metadata.Metadata;
     * @param repositoryMetaVersion                 version of the updated repository metadata to write
    /**
     * Creates a snapshot of the shard based on the index commit point.
     *                              to detect if the shard has changed between snapshots. If {@code null} is passed as the identifier
     * Returns true if the repository supports only read operations
     */
     * @param remoteSegmentStoreDirectoryFactory    RemoteSegmentStoreDirectoryFactory to be used for cleaning up remote store segment files
    ) {
        @Nullable Map<String, Long> indexFilesToFileLengthMap,
     * Called at the end of repository verification process.
        return false;
    void executeConsistentStateUpdate(
     * As snapshot process progresses, implementation of this method should update {@link IndexShardSnapshotStatus} object and check
     * As snapshot process progresses, implementation of this method should update {@link IndexShardSnapshotStatus} object and check
     *
     * The index commit point can be obtained by using {@link org.opensearch.index.engine.Engine#acquireLastIndexCommit} method.
import org.opensearch.index.snapshots.blobstore.RemoteStoreShardShallowCopySnapshot;
 * Licensed to Elasticsearch under one or more contributor
     * is closed — accessing it after close throws {@link IllegalStateException}.
     * @opensearch.experimental
    ) {
     * @param listener                 listener invoked on completion
     * This method is called on cluster-manager after all shards are snapshotted.
        IndexCommit snapshotIndexCommit,
        return Collections.emptyList();
     * Returns low priority upload throttle time in nanoseconds
    default IndexShardSnapshotStatus getShardSnapshotStatus(SnapshotInfo snapshotInfo, IndexId indexId, ShardId shardId) {
    }
    /**
     * @param snapshotIds           snapshot ids
    Metadata getSnapshotGlobalMetadata(SnapshotId snapshotId);
        IndexId indexId,
 * Unless required by applicable law or agreed to in writing,
 */
     * Reload the repository inplace
     * @param repositoryMetaVersion version of the updated repository metadata to write
     */
     */
    /**
        Collection<SnapshotId> snapshotIds,
     */
 * this file be licensed under the Apache-2.0 license or a
    /**
 * the Apache License, Version 2.0 (the "License"); you may
        throw new UnsupportedOperationException();
    void updateState(ClusterState state);
    /**
     * @param source          source snapshot
     * Clones a remote store index shard snapshot.
 */
 * <li>Data nodes call {@link Repository#snapshotShard}
        IndexId indexId,
     * @param repositoryStateId     the unique id identifying the state of the repository when the snapshot deletion began
     * @param snapshotIndexCommit      commit point
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService,
     *
     * This method is called on cluster-manager after all shards are snapshotted.
import org.opensearch.cluster.node.DiscoveryNode;
        RepositoryShardId shardId,
    /**
     */
    /**
        return 0;
    ) {
        SnapshotId source,
import org.opensearch.node.remotestore.RemoteStorePinnedTimestampService;
            snapshotId,
     * @param shardStateIdentifier     a unique identifier of the state of the shard that is stored with the shard's snapshot and used
 * license agreements. See the NOTICE file distributed with
     * @param listener                      listener to complete with new shard generation once clone has completed
    default void validateMetadata(RepositoryMetadata repositoryMetadata) {}
     * @param shardStateIdentifier     a unique identifier of the state of the shard that is stored with the shard's snapshot and used
 * </ul>
    RepositoryMetadata getMetadata();
     * <p>
        long startTime,
     */
     * @param indexId                  id for the index being snapshotted
        IndexId indexId,
    /**
        @Nullable String shardStateIdentifier,
    long getLowPriorityRemoteDownloadThrottleTimeInNanos();
     * Returns low priority remote download throttle time in nanoseconds
        Repository create(RepositoryMetadata metadata) throws Exception;
     * @param shardStateIdentifier  a unique identifier of the state of the shard that is stored with the shard's snapshot and used
     * @param snapshotShardId shard id (in the snapshot)
    /**
     * @param snapshotIds                           snapshot ids
        IndexShardSnapshotStatus snapshotStatus,
     */
    }
import java.util.function.Consumer;
     *                              snapshotting will be done by inspecting the physical files referenced by {@code snapshotIndexCommit}
import org.opensearch.index.store.lockmanager.RemoteStoreLockManagerFactory;
    default void snapshotShard(
     * @param listener              listener invoked on completion
     * Returns metadata about this repository.
    SnapshotInfo getSnapshotInfo(SnapshotId snapshotId);
     */
     * Execute a cluster state update with a consistent view of the current {@link RepositoryData}. The {@link ClusterState} passed to the
 * specific language governing permissions and limitations
    /**
        MapperService mapperService,
        ActionListener<RepositoryData> listener
     */
     * @param snapshotStatus        snapshot status
     */
     * @param repositoryStateId     the unique id identifying the state of the repository when the snapshot began
    /**
     */
     * @param source           the source of the cluster state update task
    boolean isSystemRepository();
        return getShardSnapshotStatus(snapshotInfo.snapshotId(), indexId, shardId);
     */
        Function<ClusterState, ClusterState> stateTransformer,
     * @param snapshotId      snapshot id
