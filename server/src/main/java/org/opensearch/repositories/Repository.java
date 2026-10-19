import org.opensearch.common.settings.Setting;
     * @opensearch.api  
 * GitHub history for details.
        return Collections.emptyList();
    }
     * @param shardId    shard id
        @Nullable Map<String, Long> indexFilesToFileLengthMap,
    long getRemoteDownloadThrottleTimeInNanos();
     * Creates a snapshot of the shard based on the index commit point.
        String source,  
        snapshotShard(
     * @param snapshotId               snapshot id
     * <p>  
    );
     * repository through external APIs
     * @param userMetadata          user metadata of the snapshot found in {@link SnapshotsInProgress.Entry#userMetadata()}  
import org.opensearch.Version;
import org.opensearch.indices.recovery.RecoveryState;
     * @param snapshotId      snapshot id  
     * @param primaryTerm              current Primary Term
     * @param shardGeneration shard generation in repo
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService,  
     * Checks if the repository can be reloaded inplace or not  
     */
    default Map<String, Object> adaptUserMetadata(Map<String, Object> userMetadata) {
import org.opensearch.cluster.metadata.Metadata;  
     * As snapshot process progresses, implementation of this method should update {@link IndexShardSnapshotStatus} object and check
     *                                 to detect if the shard has changed between snapshots. If {@code null} is passed as the identifier  
        long repositoryStateId,
        ActionListener<String> listener  
        long startTime,
            mapperService,
     * @param source           the source of the cluster state update task
    }
     *
import org.opensearch.cluster.metadata.RepositoryMetadata;
     * This allows for operations on the repository that need a consistent view of both the cluster state and the repository contents at
 * this work for additional information regarding copyright
     * @return list of settings
     */
        Version repositoryMetaVersion,  
     * @param snapshotIndexCommit   commit point
import org.opensearch.cluster.metadata.IndexMetadata;
     */
        return false;
    @PublicApi(since = "1.0.0")
        ActionListener<RepositoryData> listener
    boolean isSystemRepository();
        Version repositoryMetaVersion,  
     * @param snapshotIds           snapshot ids  
    void executeConsistentStateUpdate(
     * The index commit point can be obtained by using {@link org.opensearch.index.engine.Engine#acquireLastIndexCommit} method.  
     * and the indices across all snapshots found in the repository.  Throws a {@link RepositoryException}  
     * @param snapshotId      snapshot id  
import org.opensearch.node.remotestore.RemoteStorePinnedTimestampService;
     *
     * Returns true if the repository supports only read operations
        Function<ClusterState, ClusterState> stateTransformer,
    void snapshotShard(
     * As snapshot process progresses, implementation of this method should update {@link IndexShardSnapshotStatus} object and check
     * <p>
        ActionListener<String> listener  
     * <p>
     * {@link IndexShardSnapshotStatus#isAborted()} to see if the snapshot process should be aborted.  
     * if there was an error in reading the data.
     * @return true if the repository can be reloaded inplace, false otherwise
     * Returns Snapshot Shard Metadata for remote store interop enabled snapshot.  
     * @param listener              listener to be invoked with the new {@link RepositoryData} after completing the snapshot
     * @param target          target snapshot
     */
        IndexShardSnapshotStatus snapshotStatus,  
            repositoryMetaVersion,
        Metadata clusterMetadata,
     * @param repositoryStateId     the unique id identifying the state of the repository when the snapshot began
     * <p>
     * Finalizes snapshotting process  
         * Constructs a repository.
     * @param indexId    the snapshotted index id for the shard to get status for
     */  
        IndexId indexId,  
     * @param snapshotInfo     SnapshotInfo instance to write for this snapshot
     * <p>The returned value is a {@link NativeStoreRepository} wrapper managed by the
import org.opensearch.core.index.shard.ShardId;  
        return RepositoryStats.EMPTY_STATS;
        @Nullable String shardStateIdentifier,
     */  
    /**
     */  
     *  
 * compatible open source license.
import org.opensearch.common.Priority;
     * @param recoveryState   recovery state  
     * @return the index metadata about the given index for the given snapshot  
import org.opensearch.snapshots.SnapshotInfo;
    /**
/**
     * @param listener        listener to complete with new shard generation once clone has completed
    /**  
     * As snapshot process progresses, implementation of this method should update {@link IndexShardSnapshotStatus} object and check
     *                              to detect if the shard has changed between snapshots. If {@code null} is passed as the identifier
 * KIND, either express or implied.  See the License for the
    /**  
    boolean isReadOnly();
        @Nullable String shardGeneration,
     *
    }
     * @param indexId         id of the index in the repository from which the restore is occurring
     * See {@link org.opensearch.plugins.RepositoryPlugin}.
     * Returns restore throttle time in nanoseconds  
     */  
    IndexShardSnapshotStatus getShardSnapshotStatus(SnapshotId snapshotId, IndexId indexId, ShardId shardId);
        RemoteSegmentStoreDirectoryFactory remoteSegmentStoreDirectoryFactory,  
     * {@link ClusterState} that is passed here.
import org.opensearch.index.store.Store;
     * @param snapshotShardId shard id (in the snapshot)
     * As snapshot process progresses, implementation of this method should update {@link IndexShardSnapshotStatus} object and check  
     * @param snapshotIds  
        Store store,  
 *  
 * under the License.  
     * @param snapshotIds                           snapshot ids  
    /**
     * @param snapshotStatus        snapshot status
 * </ul>
     * The index can be renamed on restore, hence different {@code shardId} and {@code snapshotShardId} are supplied.
    ) {  
     * Repository implementations shouldn't release the snapshot index commit point. It is done by the method caller.
     * @return snapshot status
     *
     * @param snapshotId            snapshot id
     * repository implementation. Callers must NOT cache or use the wrapper across
     *
     */  
    default void deleteSnapshotsInternal(
 * a repository backend.  
     * The index commit point can be obtained by using {@link org.opensearch.index.engine.Engine#acquireLastIndexCommit} method.
    );
     * <p>Only sandbox tiered storage code should call this method. The default  
    /**  
     *
     * @param repositoryStateId     the unique id identifying the state of the repository when the snapshot began
    default boolean isReloadable() {  
    void restoreShard(  
 *
     * @param snapshotStatus        snapshot status  
     * @param snapshotIndexCommit      commit point
     * Clones a remote store index shard snapshot.
        SnapshotId snapshotId,
     * @param remoteStoreLockManagerFactory remoteStoreLockManagerFactory for cloning metadata lock file
     * @param store                 store to be snapshotted
     * @opensearch.experimental
     */
        IndexId indexId,  
        ShardId snapshotShardId,
        ShardId snapshotShardId
     * Reload the repository inplace  
     * @param startTime                start time of the snapshot commit, this will be used as the start time for snapshot.
     * Creates a snapshot of the shard based on the index commit point.  
     *  
     */  
     * thus the same semantics as with {@link org.opensearch.cluster.ClusterStateApplier#applyClusterState} apply for the  
 * Modifications Copyright OpenSearch Contributors. See  
     * Returns the native (Rust) object store wrapper for this repository, or
 * An interface for interacting with a repository in snapshot and restore.  
     * Restores snapshot of the shard.
     * Returns restore throttle time in nanoseconds
     * @param isShallowSnapshotV2                   true for shallow snapshots v2
     * @param repositoryMetaVersion version of the updated repository metadata to write
     */  
        RepositoryShardId shardId,
        RemoteStoreLockManagerFactory remoteStoreLockManagerFactory,  
     * @param snapshotId            snapshot id  
         */
     * @param userMetadata          user metadata of the snapshot found in {@link SnapshotsInProgress.Entry#userMetadata()}
     * @param repositoryData current {@link RepositoryData}  
     * @param repositoryMetaVersion                 version of the updated repository metadata to write
     * @param source          source snapshot
     *  
 * <ul>  
     * @param snapshotStatus           snapshot status  
     * @param shardStateIdentifier     a unique identifier of the state of the shard that is stored with the shard's snapshot and used
 * <p>
     * The index commit point can be obtained by using {@link org.opensearch.index.engine.Engine#acquireLastIndexCommit} method.
            null
     * @param indexId    the snapshotted index id for the shard to get status for
     * @return true if the repository is read/only
     * The index can be renamed on restore, hence different {@code shardId} and {@code snapshotShardId} are supplied.
        Map<SnapshotId, Long> snapshotsWithPinnedTimestamp,
     * <p>
        IndexCommit snapshotIndexCommit,  
     * Returns low priority upload throttle time in nanoseconds
     */  
     * @param shardGenerations      updated shard generations
        SnapshotId target,  
     */  
    /**
 * software distributed under the License is distributed on an
     * @param snapshotInfo     SnapshotInfo instance to write for this snapshot
    /**  
    /**
import org.opensearch.index.mapper.MapperService;
        throw new UnsupportedOperationException();
        throw new UnsupportedOperationException();  
        long startTime,  
    }
     *                              is used to remove any state tracked for the in-progress snapshot from the cluster state
        RemoteStoreLockManagerFactory remoteStoreLockManagerFactory,
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        @Nullable String shardStateIdentifier,
    /**
    );
        ActionListener<RepositoryData> listener  
/*  
     * @param index      the {@link IndexId} to load the metadata from
    /**  
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService,
     * Or for closed index can be obtained by reading last remote uploaded metadata by using {@link org.opensearch.index.shard.IndexShard#fetchLastRemoteUploadedSegmentMetadata()} method.
     * @param stateTransformer      a function that filters the last cluster state update that the snapshot finalization will execute and  
    /**
    default List<Setting<?>> getRestrictedSystemRepositorySettings() {
        Version repositoryMetaVersion,
import java.util.Collections;
     * @param repositoryMetaVersion version of the updated repository metadata to write
     * @param indexId               id for the index being snapshotted
        throw new UnsupportedOperationException();  
     *
    /**  
    RepositoryMetadata getMetadata();  
     *                                 to detect if the shard has changed between snapshots. If {@code null} is passed as the identifier
        RemoteStoreLockManagerFactory remoteStoreLockManagerFactory,
    );
        RepositoryShardId shardId,
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
 * Unless required by applicable law or agreed to in writing,
     * @param indexMetadata         index metadata for the shard being snapshotted
     * <p>
    }
    /**  
        SnapshotId snapshotId,
     * Returns true if the repository is managed by the system directly and doesn't allow managing the lifetime of the
     * Repository implementations shouldn't release the snapshot index commit point. It is done by the method caller.
        Consumer<Exception> onFailure
        SnapshotId target,  
    /**  
     * @param indexId                  id for the index being snapshotted
     * Returns metadata about this repository.
        return NativeStoreRepository.EMPTY;
        ShardGenerations shardGenerations,  
     * @param snapshotInfo snapshot info
    void endVerification(String verificationToken);  
        boolean isShallowSnapshotV2,  
        Priority repositoryUpdatePriority,  
     * @param listener              listener to be invoked with the new {@link RepositoryData} after completing the snapshot  
    void updateState(ClusterState state);
     * Called at the end of repository verification process.  
        @Nullable String shardStateIdentifier,
        IndexId indexId,
     * @param startTime                start time of the snapshot commit, this will be used as the start time for snapshot.
import org.opensearch.cluster.ClusterState;
        RecoveryState recoveryState,
        ActionListener<String> listener,
        IndexShardSnapshotStatus snapshotStatus,
     * @param repositoryMetaVersion                 version of the updated repository metadata to write
     */
     */
     * @param remoteStorePinnedTimestampService     service for pinning and unpinning of the timestamp
     * @param snapshotIndexCommit      commit point
     * Retrieve shard snapshot status for the stored snapshot
     * cluster state.
 * @opensearch.api  
     * during snapshot initialization.
    /**
        Function<RepositoryData, ClusterStateUpdateTask> createUpdateTask,
     * @param snapshotShardId shard id (in the snapshot)
     * Deletes snapshots and releases respective lock files from remote store repository
     * @param repositoryUpdatePriority  priority for the cluster state update task
        );
     * Verifies repository on the cluster-manager node and returns the verification token.
    default void snapshotRemoteStoreIndexShard(
        @Nullable IndexCommit snapshotIndexCommit,
     * @param listener        listener to invoke once done
    default RemoteStoreShardShallowCopySnapshot getRemoteStoreShallowCopyShardMetadata(
     * This method is called on cluster-manager after all shards are snapshotted.
    /**
     * @param snapshotId snapshot id  
     *  
        Store store,
 *    http://www.apache.org/licenses/LICENSE-2.0
        SnapshotId source,
    String startVerification();  
    /**
     * Deletes snapshots and releases respective lock files from remote store repository.
     */  
        Collection<SnapshotId> snapshotIds,
    /**
        long primaryTerm,  
     * @return verification token that should be passed to all Index Shard Repositories for additional verification or null
     * {@link NativeStoreRepository#EMPTY} if native object store is not supported or not initialized.
     *  
     * @param remoteSegmentStoreDirectoryFactory    RemoteSegmentStoreDirectoryFactory to be used for cleaning up remote store segment files
     * Repository implementations shouldn't release the snapshot index commit point. It is done by the method caller.  
            indexId,  
        }  
import org.opensearch.snapshots.SnapshotId;  
     * @param store                    store to be snapshotted
 *
    }  
     * @param snapshotStatus           snapshot status
    default void cloneRemoteStoreIndexShardSnapshot(
    long getRemoteUploadThrottleTimeInNanos();
        Map<String, Object> userMetadata,
 * the Apache License, Version 2.0 (the "License"); you may
     * @param repositoryStateId     the unique id identifying the state of the repository when the snapshot deletion began
            return create(metadata);
     * @param repositoryStateId                     the unique id identifying the state of the repository when the snapshot deletion began
    long getSnapshotThrottleTimeInNanos();
     * @return the native (Rust) object store wrapper, or {@link NativeStoreRepository#EMPTY} if not available  
     *  
        Function<ClusterState, ClusterState> stateTransformer,
     */
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.store.RemoteSegmentStoreDirectoryFactory;
     * @param store                    store to be snapshotted
     * If the verification token is not null, it's passed to all data nodes for verification. If it's null - no
     * This method should perform all necessary cleanup of the temporary files created in the repository
        SnapshotId snapshotId,
        Store store,
     * @param verificationToken value returned by {@link org.opensearch.repositories.Repository#startVerification()}
    /**  
     * @param indexId         id of the index in the repository from which the restore is occurring
     * @param target                        target snapshot
 * Licensed to Elasticsearch under one or more contributor  
    default void deleteSnapshotsWithPinnedTimestamp(
     * @param snapshotIndexCommit   commit point  
     * @param listener              completion listener  
     * @param source                        source snapshot  
     * @param clusterMetadata       cluster metadata  
    /**
     * @param shardId                       shard id
     * This method is called on cluster-manager after all shards are snapshotted.
     * @param repositoryMetaVersion version of the updated repository metadata to write
     * Update the repository with the incoming cluster state. This method is invoked from {@link RepositoriesService#applyClusterState} and
     */
    }
     * <p>
     * one point in time like for example, checking if a snapshot is in the repository before adding the delete operation for it to the  
    }
     * @param snapshotsWithPinnedTimestamp          map of snapshot ids and the pinned timestamps  
/*
    interface Factory {  
     * @param verificationToken verification request generated by {@link #startVerification} command
     * Retrieve shard snapshot status for the stored snapshot
     * The index commit point can be obtained by using {@link org.opensearch.index.engine.Engine#acquireLastIndexCommit} method.
    }
     * @param shardStateIdentifier  a unique identifier of the state of the shard that is stored with the shard's snapshot and used  
     * <p>
     * at the time the {@code RepositoryData} was loaded.
    /**
     * @param remoteStoreLockManagerFactory         RemoteStoreLockManagerFactory to be used for cleaning up remote store lock files  
         * @param metadata    metadata for the repository including name and settings  
import java.util.Collection;
     * @param localNode         the local node information, for inclusion in verification errors
     * @param repositoryMetaVersion version of the updated repository metadata to write
        @Nullable String shardGeneration,
     * @param repositoryStateId
     * @param remoteStoreLockManagerFactory  
        throw new UnsupportedOperationException();
}
     * Returns a {@link RepositoryData} to describe the data in the repository, including the snapshots
     * @param listener                 listener invoked on completion
     * @param listener              listener invoked on completion  
 * Implementations are responsible for reading and writing both metadata and shard data to and from
    );  
        ShardGenerations shardGenerations,
        IndexId indexId,  
     * {@link IndexShardSnapshotStatus#isAborted()} to see if the snapshot process should be aborted.  
        throw new UnsupportedOperationException();  
     * @param mapperService         the shards mapper service  
        IndexCommit snapshotIndexCommit,
    /**
    ) {  
     *                                 snapshotting will be done by inspecting the physical files referenced by {@code snapshotIndexCommit}
        ActionListener<RepositoryData> listener
     *
     * @param remoteSegmentStoreDirectoryFactory    RemoteSegmentStoreDirectoryFactory to be used for cleaning up remote store segment files  
    ) {
     */
    SnapshotInfo getSnapshotInfo(SnapshotId snapshotId);
     *
     * <p>  
    default void validateMetadata(RepositoryMetadata repositoryMetadata) {}
    void finalizeSnapshot(
            userMetadata,
        Version repositoryMetaVersion,
     * @param stateTransformer      a function that filters the last cluster state update that the snapshot finalization will execute and  
     * @return snapshot status  
            shardStateIdentifier,
     */
        Version repositoryMetaVersion,
import java.util.List;  
    }  
        Store store,
     * Hook that allows a repository to filter the user supplied snapshot metadata in {@link SnapshotsInProgress.Entry#userMetadata()}
     */
     */  
     * Returns the index metadata associated with the snapshot.
     */
            snapshotIndexCommit,
     * task generated through {@code createUpdateTask} is guaranteed to point at the same state for this repository as the did the state  
import org.opensearch.common.annotation.PublicApi;
     *
    /**
    }  
     * Returns upload throttle time in nanoseconds  
     * @param shardId    shard id  
        SnapshotInfo snapshotInfo,
        ActionListener<RepositoryData> listener
     * @param indexId               id for the index being snapshotted
    /**  
        throw new UnsupportedOperationException();
import org.opensearch.cluster.SnapshotsInProgress;
     */
        RemoteSegmentStoreDirectoryFactory remoteSegmentStoreDirectoryFactory,
import org.apache.lucene.index.IndexCommit;  
        Version repositoryMetaVersion,
     * Adds a reference of remote store data for a index commit point.
 * not use this file except in compliance with the License.
import org.opensearch.core.action.ActionListener;
        long commitGeneration,
 */
     *                              to detect if the shard has changed between snapshots. If {@code null} is passed as the identifier
     * additional verification is required
     * is closed — accessing it after close throws {@link IllegalStateException}.
            listener,  
        Collection<SnapshotId> snapshotIds,  
    }  
import java.io.IOException;  
     * @param listener
     */
    /**  
     * Returns global metadata associated with the snapshot.
        SnapshotId snapshotId,
        SnapshotId source,
    /**
import java.util.function.Function;  
/*
     * Deletes snapshots and unpin the snapshot timestamp using remoteStorePinnedTimestampService
     *  
    ) {
        Version repositoryMetaVersion,
            snapshotStatus,  
        MapperService mapperService,  
    void deleteSnapshots(
     *  
        return 0;
    IndexMetadata getSnapshotIndexMetaData(RepositoryData repositoryData, SnapshotId snapshotId, IndexId index) throws IOException;
import org.opensearch.cluster.node.DiscoveryNode;
     */
 */  
        long repositoryStateId,  
     * repository lifecycle boundaries. The wrapper is invalidated when the repository  
    default long getLowPriorityRemoteUploadThrottleTimeInNanos() {
import org.opensearch.index.snapshots.blobstore.RemoteStoreShardShallowCopySnapshot;  
    ) {
    Metadata getSnapshotGlobalMetadata(SnapshotId snapshotId);
     * Finalizes snapshotting process  
    /**
        SnapshotId snapshotId,
     * @param indexId                  id for the index being snapshotted  
    default boolean isReloadableSettings(RepositoryMetadata newRepositoryMetadata) {
     * @param remoteStorePinnedTimestampService     service for pinning and unpinning of the timestamp
 * license agreements. See the NOTICE file distributed with
    ) {  
     * @return true if the repository is system managed  
        IndexId indexId,  
        long repositoryStateId,
    }
    /**  
     * @param snapshotIdsPinnedTimestampMap         map of snapshots ids and the pinned timestamp  
    /**
    void cloneShardSnapshot(
        SnapshotInfo snapshotInfo,  
     * @return information about snapshot  
     * @param listener                              completion listener
     */
     * @param listener              listener invoked on completion
    void getRepositoryData(ActionListener<RepositoryData> listener);  
        /**
 * for each shard</li>
        ActionListener<RepositoryData> listener
    }
import java.util.Map;
     * <p>  
        @Nullable IndexMetadata indexMetadata  
     * @param listener                              completion listener
     * {@link IndexShardSnapshotStatus#isAborted()} to see if the snapshot process should be aborted.
        Repository create(RepositoryMetadata metadata) throws Exception;
        return userMetadata;
    /**
    default RepositoryStats stats() {  
        ActionListener<String> listener
        Metadata clusterMetadata,
     *                              snapshotting will be done by inspecting the physical files referenced by {@code snapshotIndexCommit}  
 * The OpenSearch Contributors require contributions made to  
import java.util.function.Consumer;
    long getLowPriorityRemoteDownloadThrottleTimeInNanos();
     */
import org.opensearch.index.store.lockmanager.RemoteStoreLockManagerFactory;  
     */  
     * Returns the list of restricted system repository settings that cannot be mutated post repository creation.
     * Returns low priority remote download throttle time in nanoseconds
     * Repository implementations shouldn't release the snapshot index commit point. It is done by the method caller.  
    /**
        ActionListener<RepositoryData> listener
    /**  
     * @param shardStateIdentifier     a unique identifier of the state of the shard that is stored with the shard's snapshot and used  
    ) {
            snapshotId,
        IndexCommit snapshotIndexCommit,  
     * @throws IllegalStateException if the native store has been closed
package org.opensearch.repositories;
        return getShardSnapshotStatus(snapshotInfo.snapshotId(), indexId, shardId);
        Version repositoryMetaVersion,  
    /**
     * @param snapshotId the snapshot id to load the global metadata from
    /**
     *  
        @Nullable String shardStateIdentifier,
    ) {
        IndexId indexId,
import org.opensearch.common.Nullable;  
    default IndexShardSnapshotStatus getShardSnapshotStatus(SnapshotInfo snapshotInfo, IndexId indexId, ShardId shardId) {  
    long getRestoreThrottleTimeInNanos();  
     * @param repositoryMetaVersion version of the updated repository metadata to write
 * <li>Data nodes call {@link Repository#snapshotShard}
        throw new UnsupportedOperationException();  
     *
     * @param commitGeneration         current commit generation
     *                              is used to remove any state tracked for the in-progress snapshot from the cluster state
     */
    }  
    default void reload(RepositoryMetadata repositoryMetadata) {}
        Store store,  
     * {@link IndexShardSnapshotStatus#isAborted()} to see if the snapshot process should be aborted.
     *
     * @param shardGenerations      updated shard generations
     * <p>
 * <p>
    /**
        return false;
     *
        default Repository create(RepositoryMetadata metadata, Function<String, Repository.Factory> typeLookup) throws Exception {
 */
     *                              snapshotting will be done by inspecting the physical files referenced by {@code snapshotIndexCommit}
     * Execute a cluster state update with a consistent view of the current {@link RepositoryData}. The {@link ClusterState} passed to the
        ActionListener<String> listener
    }
 * specific language governing permissions and limitations
import org.opensearch.cluster.ClusterStateUpdateTask;  
     * Returns stats on the repository usage
     * Clones a shard snapshot.
     * @param onFailure        error handler invoked on failure to get a consistent view of the current {@link RepositoryData}
     * @param listener                      listener to complete with new shard generation once clone has completed
     * Deletes snapshots
        long repositoryStateId,  
     * @return the global metadata about the snapshot
            store,  
        Collection<SnapshotId> snapshotIds,
     * @param indexFilesToFileLengthMap map of index files to file length  
     * @param primaryTerm              current Primary Term  
        MapperService mapperService,
 *
     * @param shardId         shard id  
     * An factory interface for constructing repositories.  
     * <p>  
     * implementation returns {@link NativeStoreRepository#EMPTY} (no native store).
    }
     * @param repositoryMetaVersion
        ActionListener<Void> listener  
     * <p>  
    /**
 * ownership. Elasticsearch licenses this file to you under  
     * @param store                 store to be snapshotted
 * You may obtain a copy of the License at  
     */  
    /**
     * @param shardStateIdentifier  a unique identifier of the state of the shard that is stored with the shard's snapshot and used
 * <li>When all shard calls return cluster-manager calls {@link #finalizeSnapshot} with possible list of failures</li>  
    /**  
     */
     *                                 snapshotting will be done by inspecting the physical files referenced by {@code snapshotIndexCommit}
        long repositoryStateId,  
import org.opensearch.common.lifecycle.LifecycleComponent;  
     * @param createUpdateTask function to supply cluster state update task  
     * Adds a reference of remote store data for a index commit point.
     */  
     * Validate the repository metadata
     * @param state new cluster state  
    void verify(String verificationToken, DiscoveryNode localNode);
     */  
     * @param store           the store to restore the index into
    default void finalizeSnapshot(
     * <p>
    /**
    );
        long repositoryStateId,
     */  
     * @param shardGeneration               shard generation in repo  
     */
@PublicApi(since = "1.0.0")
     * @param mapperService         the shards mapper service
        IndexShardSnapshotStatus snapshotStatus,  
        IndexShardSnapshotStatus snapshotStatus,
     */  
        SnapshotId snapshotId,
 */
        throw new UnsupportedOperationException();  
     */
        long primaryTerm,
    /**  
     * Reads snapshot description from repository.  
 * this file be licensed under the Apache-2.0 license or a
    }  
 * To perform a snapshot:
     * Verifies repository settings on data node.  
public interface Repository extends LifecycleComponent {  
    /**  
    default NativeStoreRepository getNativeStore() {
    default void snapshotShard(
     * @param snapshotId the snapshot id to load the index metadata from
        ActionListener<String> listener
     */  
        Map<SnapshotId, Long> snapshotIdsPinnedTimestampMap,
     *
    default void snapshotRemoteStoreIndexShard(  
     * @param snapshotId  snapshot id
     */
     * Returns snapshot throttle time in nanoseconds
    ) {
     * @param snapshotId               snapshot id  
    default void deleteSnapshotsAndReleaseLockFiles(  
     * @param listener                 listener invoked on completion  
     * @param clusterMetadata       cluster metadata  
        Map<String, Object> userMetadata,
     * @param repositoryStateId                     the unique id identifying the state of the repository when the snapshot deletion began
