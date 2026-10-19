 * specific language governing permissions and limitations
import org.opensearch.common.Priority;
import java.util.Map;  
        Consumer<Exception> onFailure
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        IndexId indexId,
    @Override
    public void updateState(final ClusterState state) {}
    public void executeConsistentStateUpdate(
        return 0;
        ActionListener<String> listener
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
    @Override  
    public long getRemoteUploadThrottleTimeInNanos() {  
    public long getRestoreThrottleTimeInNanos() {
import static org.opensearch.repositories.RepositoryData.EMPTY_REPO_GEN;
import org.opensearch.repositories.RepositoryData;
 *  
        String shardStateIdentifier,  
    @Override
import java.util.function.Function;
        throw new UnsupportedOperationException("Unsupported for restore-only repository");  
import java.util.Collections;
    @Override
    ) {  
        long repositoryStateId,  
        return false;
        Function<ClusterState, ClusterState> stateTransformer,
                Collections.emptyMap(),  
    @Override  
    ) {
        Version repositoryMetaVersion,  
import org.opensearch.index.mapper.MapperService;  
    }
import org.opensearch.cluster.metadata.IndexMetadata;
    @Override
        );  
    @Override
        listener.onResponse(null);  
        listener.onResponse(
        throw new UnsupportedOperationException("Unsupported for restore-only repository");  
    @Override  
    protected void doStart() {}
        ActionListener<RepositoryData> listener
            )
import org.opensearch.cluster.metadata.RepositoryMetadata;  
    public SnapshotInfo getSnapshotInfo(SnapshotId snapshotId) {  
        IndexMetadata indexMetadata
    }
                ShardGenerations.EMPTY,  
    public boolean isReadOnly() {
    }
    @Override
    }  
        return null;
import org.opensearch.cluster.node.DiscoveryNode;
    @Override
    }
                Collections.singletonMap(indexId, emptyList()),
 * ownership. Elasticsearch licenses this file to you under  
        long repositoryStateId,
    @Override  
            new RepositoryData(  
    @Override  
import org.opensearch.repositories.IndexMetaDataGenerations;
    public IndexShardSnapshotStatus getShardSnapshotStatus(SnapshotId snapshotId, IndexId indexId, ShardId shardId) {  
    public void cloneRemoteStoreIndexShardSnapshot(
 * license agreements. See the NOTICE file distributed with
    @Override  
        String source,
    @Override
        SnapshotInfo snapshotInfo,
    @Override  
        throw new UnsupportedOperationException("Unsupported for restore-only repository");
import java.util.function.Consumer;
        ActionListener<String> listener
 *
        RepositoryShardId repositoryShardId,
        SnapshotId target,
        Function<ClusterState, ClusterState> stateTransformer,
    public void deleteSnapshots(
    @Override  
    protected void doClose() {}
import org.opensearch.repositories.IndexId;
        Metadata clusterMetadata,
    }
    @Override
    }
import org.opensearch.cluster.ClusterState;
import org.opensearch.index.store.lockmanager.RemoteStoreLockManagerFactory;  
    public void snapshotShard(  
import static java.util.Collections.emptyList;
    public long getRemoteDownloadThrottleTimeInNanos() {
 *     http://www.apache.org/licenses/LICENSE-2.0
        return 0;  
 */
 */  
        Collection<SnapshotId> snapshotIds,
    @Override
    protected void doStop() {}
/*
    }
    @Override
        return null;
        String shardGeneration,
    }
 * Modifications Copyright OpenSearch Contributors. See  
    @Override
 *
        final IndexId indexId = new IndexId(indexName, "blah");
        SnapshotId target,  
 * GitHub history for details.
                IndexMetaDataGenerations.EMPTY
        ShardGenerations shardGenerations,
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;  
        ActionListener<RepositoryData> listener
import org.opensearch.cluster.metadata.Metadata;
import java.util.Collection;
    }
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.Version;
    }  
 * The OpenSearch Contributors require contributions made to  
                EMPTY_REPO_GEN,
    private final String indexName;  
        IndexShardSnapshotStatus snapshotStatus,
        return 0;
        String shardGeneration,  
        MapperService mapperService,
        RemoteStoreLockManagerFactory remoteStoreLockManagerFactory,  
        Version repositoryMetaVersion,
        ActionListener<String> listener,
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
    public void finalizeSnapshot(
        IndexCommit snapshotIndexCommit,
 * the Apache License, Version 2.0 (the "License"); you may
    public String startVerification() {  
import org.opensearch.snapshots.SnapshotInfo;
        SnapshotId snapshotId,  
 * You may obtain a copy of the License at  
        Version repositoryMetaVersion,
        Priority repositoryUpdatePriority,  
import org.opensearch.core.index.shard.ShardId;
    public RepositoryMetadata getMetadata() {
    }  
    @Override
}
 * this work for additional information regarding copyright
        return false;  
    ) {  
        this.indexName = indexName;  
/*
package org.opensearch.index.shard;
import org.opensearch.repositories.ShardGenerations;  
 * under the License.  
        SnapshotId source,  
    public void cloneShardSnapshot(
        listener.onResponse(null);
    }
/** A dummy repository for testing which just needs restore overridden */
        listener.onResponse(null);
    @Override  
        long repositoryStateId,  
import org.apache.lucene.index.IndexCommit;  
        return 0;
                Collections.emptyMap(),
                Collections.emptyMap(),
 * KIND, either express or implied.  See the License for the
        return null;
    public long getLowPriorityRemoteDownloadThrottleTimeInNanos() {
import org.opensearch.repositories.RepositoryShardId;
 * this file be licensed under the Apache-2.0 license or a
    @Override  
    }
        SnapshotId source,
        ActionListener<RepositoryData> listener
        return null;
        Metadata clusterMetadata,
    @Override
    }
    public RestoreOnlyRepository(String indexName) {
    }
    }
 */
        return null;  
/*  
public abstract class RestoreOnlyRepository extends AbstractLifecycleComponent implements Repository {
    public void finalizeSnapshot(
        Function<RepositoryData, ClusterStateUpdateTask> createUpdateTask,  
    public void verify(String verificationToken, DiscoveryNode localNode) {}
        RepositoryShardId shardId,
    public boolean isSystemRepository() {
    public void getRepositoryData(ActionListener<RepositoryData> listener) {  
    ) {}  
    public void endVerification(String verificationToken) {}
        return 0;  
        Version repositoryMetaVersion,
import org.opensearch.cluster.ClusterStateUpdateTask;  
    public Metadata getSnapshotGlobalMetadata(SnapshotId snapshotId) {
    @Override
import org.opensearch.core.action.ActionListener;
    ) {  
    }
    ) {
import org.opensearch.index.store.Store;
        Store store,
    @Override  
        ShardGenerations shardGenerations,  
 * compatible open source license.
import org.opensearch.snapshots.SnapshotId;
import org.opensearch.repositories.Repository;  
    }  
        return null;
    @Override
        Map<String, Object> userMetadata,  
    }  
    public IndexMetadata getSnapshotIndexMetaData(RepositoryData repositoryData, SnapshotId snapshotId, IndexId index) {
    public long getSnapshotThrottleTimeInNanos() {
 * not use this file except in compliance with the License.
    }
 * SPDX-License-Identifier: Apache-2.0
        SnapshotInfo snapshotInfo,  
    ) {
