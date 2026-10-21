                            shardGenerations,
 * Modifications Copyright OpenSearch Contributors. See
 */
            .get()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            NamedXContentRegistry namedXContentRegistry,
                            listener
 * not use this file except in compliance with the License.
                        ActionListener<RepositoryData> listener
 * under the License.
import org.opensearch.index.mapper.MapperService;
                    public void snapshotShard(
        ) {
 * license agreements. See the NOTICE file distributed with
        createIndex("test-idx");
                    }
                            snapshotIndexCommit,
                            snapshotInfo,
            .setWaitForCompletion(true)
        assertThat(
                            snapshotId,
                            repositoryUpdatePriority,
                            mapperService,
import org.opensearch.core.xcontent.NamedXContentRegistry;
        );
                    @Override
                        String shardStateIdentifier,
 *    http://www.apache.org/licenses/LICENSE-2.0
                    ) {
import java.util.Collections;
                    public Map<String, Object> adaptUserMetadata(Map<String, Object> userMetadata) {
                            listener,
import org.opensearch.cluster.ClusterState;
    }
 */
                        SnapshotInfo snapshotInfo,
    }
 * ownership. Elasticsearch licenses this file to you under
                        ShardGenerations shardGenerations,
 * software distributed under the License is distributed on an
                        SnapshotId snapshotId,
 * compatible open source license.
                    }
                        );
import org.opensearch.plugins.Plugin;
                        Version repositoryMetaVersion,
                    public void finalizeSnapshot(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 */
                            indexMetadata
import org.opensearch.common.Priority;
                        );
    // Mock plugin that stores the name of the cluster-manager node that started a snapshot in each snapshot's metadata
            .cluster()
                    }
import org.opensearch.cluster.metadata.IndexMetadata;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.store.Store;
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.core.action.ActionListener;
/*
    }
            .getSnapshotInfo();
        return Collections.singleton(MetadataFilteringPlugin.class);
/*
            .prepareCreateSnapshot(repoName, "test-snap")
            is(Collections.singletonMap(MetadataFilteringPlugin.MOCK_FILTERED_META, clusterManagerName))
}
 * this file be licensed under the Apache-2.0 license or a
                        Priority repositoryUpdatePriority,
                            repositoryMetaVersion,
                        return Collections.singletonMap(MOCK_FILTERED_META, clusterService.getNodeName());
            RecoverySettings recoverySettings
                        super.snapshotShard(
import org.opensearch.cluster.service.ClusterService;
            .put(MetadataFilteringPlugin.CLUSTER_MANAGER_SETTING_VALUE, clusterManagerName);
                "mock_meta_filtering",
        final String clusterManagerName = internalCluster().getClusterManagerName();
        private static final String MOCK_FILTERED_META = "mock_filtered_meta";
                        IndexMetadata indexMetadata
/*
                            repositoryMetaVersion,
 * Licensed to Elasticsearch under one or more contributor
                        Version repositoryMetaVersion,
        @Override
                        ActionListener<String> listener,
        private static final String CLUSTER_MANAGER_SETTING_VALUE = "initial_cluster_manager";
    public void testFilteredRepoMetadataIsUsed() {
                            clusterMetadata,
                            repositoryStateId,
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
                            indexId,
 * SPDX-License-Identifier: Apache-2.0
                        Function<ClusterState, ClusterState> stateTransformer,
import org.opensearch.indices.recovery.RecoverySettings;
import org.opensearch.repositories.IndexId;
                        IndexId indexId,
 * The OpenSearch Contributors require contributions made to
                        long repositoryStateId,
            Environment env,
        Settings.Builder settings = Settings.builder()
 *
            return Collections.singletonMap(
                metadata -> new FsRepository(metadata, env, namedXContentRegistry, clusterService, recoverySettings) {
import java.util.Collection;
                }
import org.opensearch.common.settings.Settings;
                    private final String initialMetaValue = metadata.settings().get(CLUSTER_MANAGER_SETTING_VALUE);
        }
            .put("location", randomRepoPath())
                            stateTransformer,
import org.opensearch.env.Environment;
 * You may obtain a copy of the License at
                        MapperService mapperService,
                        Map<String, Object> userMetadata,
                            snapshotStatus,
import org.opensearch.repositories.fs.FsRepository;
import org.opensearch.repositories.Repository;
                            userMetadata,
        createRepository(repoName, MetadataFilteringPlugin.TYPE, settings);
        public Map<String, Repository.Factory> getRepositories(
import org.apache.lucene.index.IndexCommit;
 * specific language governing permissions and limitations
                    // Storing the initially expected metadata value here to verify that #filterUserMetadata is only called once on the
                        Store store,
                    @Override
    public static final class MetadataFilteringPlugin extends org.opensearch.plugins.Plugin implements RepositoryPlugin {
import org.opensearch.cluster.metadata.Metadata;
            ClusterService clusterService,
                        assertThat(userMetadata, is(Collections.singletonMap(MOCK_FILTERED_META, initialMetaValue)));
                        super.finalizeSnapshot(
 *
import org.opensearch.plugins.RepositoryPlugin;
                            store,
            snapshotInfo.userMetadata(),
            );
import org.opensearch.Version;
    @Override
package org.opensearch.snapshots;
        final SnapshotInfo snapshotInfo = client().admin()
 * the Apache License, Version 2.0 (the "License"); you may
                    @Override
import static org.hamcrest.Matchers.is;
public class RepositoryFilterUserMetadataIT extends OpenSearchIntegTestCase {
 * this work for additional information regarding copyright
 * GitHub history for details.
                        IndexShardSnapshotStatus snapshotStatus,
        final String repoName = "test-repo";
        private static final String TYPE = "mock_meta_filtering";
import org.opensearch.repositories.RepositoryData;
import java.util.function.Function;
                            shardStateIdentifier,
                        IndexCommit snapshotIndexCommit,
                        Metadata clusterMetadata,
import java.util.Map;
                    ) {
                    // initial cluster-manager node starting the snapshot
import org.opensearch.repositories.ShardGenerations;
 *
