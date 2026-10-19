        in.cloneRemoteStoreIndexShardSnapshot(source, target, shardId, shardGeneration, remoteStoreLockManagerFactory, listener);
        ActionListener<RepositoryData> listener
 * this work for additional information regarding copyright
import org.opensearch.Version;
        Store store,  
    public void updateState(ClusterState state) {
        return in.getSnapshotInfo(snapshotId);  
        SnapshotId target,
    @Override  
    }
    }
        Consumer<Exception> onFailure  
    }
        SnapshotId snapshotId,  
    public void close() {  
        ShardId snapshotShardId
 *
        );  
    public long getLowPriorityRemoteDownloadThrottleTimeInNanos() {
            stateTransformer,
        IndexId indexId,
            repositoryStateId,
    }
    }
 *  
    }  
    @Override
            snapshotStatus,
    public Lifecycle.State lifecycleState() {
        ActionListener<String> listener
        ActionListener<RepositoryData> listener  
            repositoryMetaVersion,
    }  
        return in.getSnapshotGlobalMetadata(snapshotId);
            indexId,  
    ) {  
        Store store,  
        IndexId indexId,
        );
        SnapshotInfo snapshotInfo,
 * You may obtain a copy of the License at  
        Function<RepositoryData, ClusterStateUpdateTask> createUpdateTask,
        RepositoryShardId shardId,  
        return in.getRemoteStoreShallowCopyShardMetadata(snapshotId, indexId, snapshotShardId);
    public void stop() {
        in.addLifecycleListener(listener);
            store,
    public void finalizeSnapshot(
/*
    public RemoteStoreShardShallowCopySnapshot getRemoteStoreShallowCopyShardMetadata(
    @Override
        SnapshotId snapshotId,
    }  
 * software distributed under the License is distributed on an
        ShardGenerations shardGenerations,
        SnapshotId snapshotId,
        return in.lifecycleState();  
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
            shardStateIdentifier,  
    public long getSnapshotThrottleTimeInNanos() {
    @Override
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
    }
        IndexCommit snapshotIndexCommit,
 * under the License.  
import org.opensearch.core.index.shard.ShardId;  
    public void start() {
    public void removeLifecycleListener(LifecycleListener listener) {  
        return in.getSnapshotIndexMetaData(repositoryData, snapshotId, index);
        IndexCommit snapshotIndexCommit,
    }  
            repositoryMetaVersion,
    public String startVerification() {
 * GitHub history for details.
    ) {
    @Override
        ActionListener<String> listener  
    @Override
    }
    @Override  
        Map<String, Object> userMetadata,
        in.getRepositoryData(listener);  
import org.opensearch.index.mapper.MapperService;
        in.close();
import org.opensearch.cluster.node.DiscoveryNode;
    public Metadata getSnapshotGlobalMetadata(SnapshotId snapshotId) {
    ) {
        return in.getRemoteDownloadThrottleTimeInNanos();
    }
 *
        Function<ClusterState, ClusterState> stateTransformer,
    @Override
        SnapshotId source,
            shardGenerations,
    public RepositoryMetadata getMetadata() {  
    public void deleteSnapshots(  
    @Override  
    public void verify(String verificationToken, DiscoveryNode localNode) {
        IndexMetadata indexMetadata
    @Override
import org.opensearch.cluster.metadata.RepositoryMetadata;  
            repositoryStateId,  
            snapshotInfo,  
    }
        return in.startVerification();
    }  
            indexId,
import org.opensearch.index.store.Store;
            clusterMetadata,
    @Override
        return in.getLowPriorityRemoteDownloadThrottleTimeInNanos();  
        in.cloneShardSnapshot(source, target, shardId, shardGeneration, listener);
    @Override
    }
    public FilterRepository(Repository in) {
    @Override
    @Override  
package org.opensearch.repositories;
 * SPDX-License-Identifier: Apache-2.0
        return in.getSnapshotThrottleTimeInNanos();
        in.restoreShard(store, snapshotId, indexId, snapshotShardId, recoveryState, listener);
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
        IndexId indexId,
    }
    public IndexShardSnapshotStatus getShardSnapshotStatus(SnapshotId snapshotId, IndexId indexId, ShardId shardId) {
import org.opensearch.common.lifecycle.Lifecycle;  
        long repositoryStateId,
            startTime,
        return in.getRemoteUploadThrottleTimeInNanos();  
        Collection<SnapshotId> snapshotIds,
        return in.getRestoreThrottleTimeInNanos();
    }
        SnapshotId snapshotId,  
import java.util.function.Function;
        String shardStateIdentifier,
        Store store,
            listener  
    }  
    ) {  
    ) {
    public void restoreShard(
        Metadata clusterMetadata,
        in.snapshotRemoteStoreIndexShard(  
        in.finalizeSnapshot(
        IndexId indexId,  
        Version repositoryMetaVersion,  
    public void cloneRemoteStoreIndexShardSnapshot(  
        return in.getRemoteUploadThrottleTimeInNanos();
            listener
        long startTime,  
    @Override
        in.stop();
        ActionListener<String> listener,  
}  
    @Override
        Version repositoryMetaVersion,  
        in.snapshotShard(  
        SnapshotInfo snapshotInfo,
 * specific language governing permissions and limitations
 * @opensearch.internal
    public void executeConsistentStateUpdate(  
    @Override
 * Repository that is filtered
import org.opensearch.cluster.metadata.Metadata;
 * Unless required by applicable law or agreed to in writing,
            primaryTerm,
        return in.getShardSnapshotStatus(snapshotId, indexId, shardId);  
        String shardGeneration,
        ActionListener<RepositoryData> listener
        RemoteStoreLockManagerFactory remoteStoreLockManagerFactory,
        String shardGeneration,
import java.io.IOException;
 */
    public void finalizeSnapshot(
        ShardId snapshotShardId,  
    }  
    public long getLowPriorityRemoteUploadThrottleTimeInNanos() {
        Version repositoryMetaVersion,
    }
            listener
/**
        return in.isReadOnly();
    @Override
        long repositoryStateId,  
    }  
            clusterMetadata,
            shardGenerations,  
            userMetadata,  
    public void snapshotRemoteStoreIndexShard(
            snapshotIndexCommit,
        ActionListener<String> listener
 *  
        RepositoryShardId shardId,  
        in.deleteSnapshots(snapshotIds, repositoryStateId, repositoryMetaVersion, listener);  
    public boolean isReadOnly() {
        in.verify(verificationToken, localNode);  
/*
    }
            snapshotStatus,  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.store.lockmanager.RemoteStoreLockManagerFactory;
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        in.finalizeSnapshot(
    @Override  
    @Override
        MapperService mapperService,
    }
    public long getRemoteDownloadThrottleTimeInNanos() {  
    public long getRemoteUploadThrottleTimeInNanos() {
    ) {
    ) {  
import org.opensearch.index.snapshots.blobstore.RemoteStoreShardShallowCopySnapshot;  
import org.opensearch.cluster.metadata.IndexMetadata;
    @Override
        in.executeConsistentStateUpdate(createUpdateTask, source, onFailure);
 */
            snapshotInfo,
    private final Repository in;
    @Override
    @Override
        in.updateState(state);
        String shardStateIdentifier,  
        IndexShardSnapshotStatus snapshotStatus,  
 */  
        in.removeLifecycleListener(listener);
        in.endVerification(verificationToken);
            stateTransformer,
 * this file be licensed under the Apache-2.0 license or a
    @Override  
    }
import java.util.Collection;
    }
            mapperService,
        SnapshotId target,
import org.apache.lucene.index.IndexCommit;  
            snapshotId,  
        Function<ClusterState, ClusterState> stateTransformer,
        IndexShardSnapshotStatus snapshotStatus,
    }
        long primaryTerm,
/*  
            indexMetadata
    public long getRestoreThrottleTimeInNanos() {  
    }  
import java.util.function.Consumer;
import org.opensearch.indices.recovery.RecoveryState;  
import org.opensearch.cluster.ClusterStateUpdateTask;  
    }
            repositoryMetaVersion,  
    @Override
            shardStateIdentifier,
import java.util.Map;  
    public void addLifecycleListener(LifecycleListener listener) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
    }
    }
    @Override
import org.opensearch.cluster.ClusterState;
    }  
        this.in = in;
    public void cloneShardSnapshot(  
import org.opensearch.snapshots.SnapshotId;
    }  
            repositoryUpdatePriority,  
    public void snapshotShard(
 */
    @Override
        Priority repositoryUpdatePriority,
    }  
    public boolean isSystemRepository() {  
        return in.getMetadata();
        );  
        Metadata clusterMetadata,
public class FilterRepository implements Repository {  
    @Override  
        String source,
import org.opensearch.core.action.ActionListener;
            snapshotId,
    @Override  
import org.opensearch.common.lifecycle.LifecycleListener;
        RecoveryState recoveryState,
    public void getRepositoryData(ActionListener<RepositoryData> listener) {
    @Override  
    @Override
        return in.isSystemRepository();
    public SnapshotInfo getSnapshotInfo(SnapshotId snapshotId) {
        in.start();  
    public void endVerification(String verificationToken) {  
        );
    public IndexMetadata getSnapshotIndexMetaData(RepositoryData repositoryData, SnapshotId snapshotId, IndexId index) throws IOException {  
import org.opensearch.snapshots.SnapshotInfo;
    @Override  
    @Override
    ) {  
    }
        ShardGenerations shardGenerations,
 * compatible open source license.
    }
        ActionListener<Void> listener
            store,
            snapshotIndexCommit,
 * Modifications Copyright OpenSearch Contributors. See  
            listener,
        long repositoryStateId,  
    ) {
    ) {
 * the Apache License, Version 2.0 (the "License"); you may
        Version repositoryMetaVersion,  
import org.opensearch.common.Priority;
        SnapshotId source,
