    @Override
import org.opensearch.common.Priority;
import org.opensearch.snapshots.SnapshotId;
        return 0;
    protected void doStop() {}
        Function<ClusterState, ClusterState> stateTransformer,
    ) {
import org.opensearch.index.store.Store;
        return null;
    ) {
 * under the License.
    }
    public boolean isSystemRepository() {
    public boolean isReadOnly() {
    @Override
import org.opensearch.repositories.RepositoryData;
                ShardGenerations.EMPTY,
    @Override
import org.opensearch.index.store.lockmanager.RemoteStoreLockManagerFactory;
        ActionListener<String> listener
            new RepositoryData(
        Version repositoryMetaVersion,
/** A dummy repository for testing which just needs restore overridden */
    public String startVerification() {
        SnapshotInfo snapshotInfo,
import org.opensearch.snapshots.SnapshotInfo;
        Function<ClusterState, ClusterState> stateTransformer,
 *
    public void endVerification(String verificationToken) {}
 * the Apache License, Version 2.0 (the "License"); you may
    }
        RemoteStoreLockManagerFactory remoteStoreLockManagerFactory,
 * compatible open source license.
        return null;
    }
import org.opensearch.cluster.ClusterStateUpdateTask;
        return false;
 * Unless required by applicable law or agreed to in writing,
    @Override
        listener.onResponse(
    }
        throw new UnsupportedOperationException("Unsupported for restore-only repository");
        return 0;
import java.util.Collections;
        return null;
import org.opensearch.repositories.IndexMetaDataGenerations;
import org.opensearch.core.index.shard.ShardId;
import java.util.function.Consumer;
        IndexShardSnapshotStatus snapshotStatus,
 * specific language governing permissions and limitations
        return null;
        SnapshotId source,
        MapperService mapperService,
 * SPDX-License-Identifier: Apache-2.0
        Metadata clusterMetadata,
        Map<String, Object> userMetadata,
    }
        long repositoryStateId,
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        SnapshotId target,
        SnapshotInfo snapshotInfo,
    }
        return false;
    @Override
        listener.onResponse(null);
    public void deleteSnapshots(
        final IndexId indexId = new IndexId(indexName, "blah");
import org.opensearch.Version;
    ) {
import java.util.Map;
        listener.onResponse(null);
        Metadata clusterMetadata,
import java.util.function.Function;
    public long getLowPriorityRemoteDownloadThrottleTimeInNanos() {
    public Metadata getSnapshotGlobalMetadata(SnapshotId snapshotId) {
        Version repositoryMetaVersion,
import static java.util.Collections.emptyList;
        String shardStateIdentifier,
    @Override
import org.opensearch.repositories.IndexId;
import org.opensearch.cluster.metadata.RepositoryMetadata;
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
                Collections.singletonMap(indexId, emptyList()),
    public void finalizeSnapshot(
        long repositoryStateId,
        return null;
        ActionListener<RepositoryData> listener
    public long getRemoteUploadThrottleTimeInNanos() {
    }
    public RepositoryMetadata getMetadata() {
        SnapshotId target,
import org.opensearch.repositories.RepositoryShardId;
import java.util.Collection;
 */
    @Override
/*
        Version repositoryMetaVersion,
        ActionListener<String> listener,
    public void finalizeSnapshot(
}
    @Override
        Priority repositoryUpdatePriority,
        throw new UnsupportedOperationException("Unsupported for restore-only repository");
    public IndexMetadata getSnapshotIndexMetaData(RepositoryData repositoryData, SnapshotId snapshotId, IndexId index) {
        long repositoryStateId,
        ActionListener<RepositoryData> listener
        ShardGenerations shardGenerations,
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.repositories.Repository;
    ) {
        String shardGeneration,
import org.opensearch.core.action.ActionListener;
        throw new UnsupportedOperationException("Unsupported for restore-only repository");
 * You may obtain a copy of the License at
        listener.onResponse(null);
    @Override
    @Override
        String source,
        SnapshotId source,
 *
        ActionListener<String> listener
 * The OpenSearch Contributors require contributions made to
 * Licensed to Elasticsearch under one or more contributor
            )
    public void snapshotShard(
        return null;
    }
    }
    public long getRemoteDownloadThrottleTimeInNanos() {
/*
        return 0;
    @Override
import org.opensearch.cluster.node.DiscoveryNode;
    @Override
import org.opensearch.index.mapper.MapperService;
    @Override
        Collection<SnapshotId> snapshotIds,
                EMPTY_REPO_GEN,
    protected void doClose() {}
    @Override
        return 0;
    @Override
 * GitHub history for details.
    @Override
        IndexMetadata indexMetadata
import org.apache.lucene.index.IndexCommit;
        RepositoryShardId repositoryShardId,
    protected void doStart() {}
 */
import org.opensearch.cluster.metadata.Metadata;
 * not use this file except in compliance with the License.
    ) {}
    public void cloneShardSnapshot(
                Collections.emptyMap(),
        Consumer<Exception> onFailure
                Collections.emptyMap(),
        RepositoryShardId shardId,
    public SnapshotInfo getSnapshotInfo(SnapshotId snapshotId) {
    @Override
    }
                IndexMetaDataGenerations.EMPTY
        String shardGeneration,
    @Override
    }
    @Override
package org.opensearch.index.shard;
                Collections.emptyMap(),
        );
    @Override
    }
    @Override
 *
        Version repositoryMetaVersion,
    @Override
        Store store,
    @Override
    @Override
    private final String indexName;
 * Modifications Copyright OpenSearch Contributors. See
    public void cloneRemoteStoreIndexShardSnapshot(
    }
    }
    public void updateState(final ClusterState state) {}
    public void getRepositoryData(ActionListener<RepositoryData> listener) {
    }
    }
    ) {
/*
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
        SnapshotId snapshotId,
    public long getRestoreThrottleTimeInNanos() {
import org.opensearch.cluster.ClusterState;
 * this file be licensed under the Apache-2.0 license or a
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
import org.opensearch.repositories.ShardGenerations;
        ActionListener<RepositoryData> listener
    ) {
import org.opensearch.cluster.metadata.IndexMetadata;
    public long getSnapshotThrottleTimeInNanos() {
public abstract class RestoreOnlyRepository extends AbstractLifecycleComponent implements Repository {
    @Override
        IndexId indexId,
    public void verify(String verificationToken, DiscoveryNode localNode) {}
        this.indexName = indexName;
    public void executeConsistentStateUpdate(
 * license agreements. See the NOTICE file distributed with
import static org.opensearch.repositories.RepositoryData.EMPTY_REPO_GEN;
        Function<RepositoryData, ClusterStateUpdateTask> createUpdateTask,
 * this work for additional information regarding copyright
    }
    public RestoreOnlyRepository(String indexName) {
        IndexCommit snapshotIndexCommit,
 * KIND, either express or implied.  See the License for the
        return 0;
    }
    }
    @Override
    }
    @Override
    public IndexShardSnapshotStatus getShardSnapshotStatus(SnapshotId snapshotId, IndexId indexId, ShardId shardId) {
        ShardGenerations shardGenerations,
