            Environment env,  
                        Version repositoryMetaVersion,  
 * GitHub history for details.
                    ) {
                            repositoryMetaVersion,
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.Priority;  
            return Collections.singletonMap(
import org.opensearch.repositories.fs.FsRepository;  
            is(Collections.singletonMap(MetadataFilteringPlugin.MOCK_FILTERED_META, clusterManagerName))  
 * ownership. Elasticsearch licenses this file to you under  
                            userMetadata,  
                        IndexId indexId,
import org.opensearch.plugins.RepositoryPlugin;
                    public Map<String, Object> adaptUserMetadata(Map<String, Object> userMetadata) {
                            indexId,
        return Collections.singleton(MetadataFilteringPlugin.class);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        private static final String MOCK_FILTERED_META = "mock_filtered_meta";
/*
                            mapperService,
    public static final class MetadataFilteringPlugin extends org.opensearch.plugins.Plugin implements RepositoryPlugin {
        private static final String TYPE = "mock_meta_filtering";
        }  
                        );  
                    }
 * this work for additional information regarding copyright
            ClusterService clusterService,
                            repositoryMetaVersion,
    }  
            snapshotInfo.userMetadata(),
 * software distributed under the License is distributed on an
import org.opensearch.core.xcontent.NamedXContentRegistry;  
import org.opensearch.index.mapper.MapperService;
import org.opensearch.test.OpenSearchIntegTestCase;
import org.apache.lucene.index.IndexCommit;  
                            listener,
import org.opensearch.index.store.Store;
    @Override  
                        MapperService mapperService,  
import org.opensearch.plugins.Plugin;  
                        Priority repositoryUpdatePriority,  
 * under the License.  
import org.opensearch.repositories.RepositoryData;
                        Map<String, Object> userMetadata,
                        Metadata clusterMetadata,
                }
                        IndexShardSnapshotStatus snapshotStatus,
                        super.finalizeSnapshot(  
                    }  
                        return Collections.singletonMap(MOCK_FILTERED_META, clusterService.getNodeName());
                    public void finalizeSnapshot(
import static org.hamcrest.Matchers.is;
                            repositoryUpdatePriority,
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
import java.util.Map;
 *    http://www.apache.org/licenses/LICENSE-2.0
                            indexMetadata
                        IndexCommit snapshotIndexCommit,  
        private static final String CLUSTER_MANAGER_SETTING_VALUE = "initial_cluster_manager";  
    // Mock plugin that stores the name of the cluster-manager node that started a snapshot in each snapshot's metadata
                    // Storing the initially expected metadata value here to verify that #filterUserMetadata is only called once on the  
 * license agreements. See the NOTICE file distributed with
                        String shardStateIdentifier,
import org.opensearch.cluster.metadata.IndexMetadata;  
/*  
 */
                        super.snapshotShard(  
            NamedXContentRegistry namedXContentRegistry,
        createIndex("test-idx");  
 * this file be licensed under the Apache-2.0 license or a
                "mock_meta_filtering",  
 * Modifications Copyright OpenSearch Contributors. See  
        final SnapshotInfo snapshotInfo = client().admin()
        Settings.Builder settings = Settings.builder()
        createRepository(repoName, MetadataFilteringPlugin.TYPE, settings);
            .setWaitForCompletion(true)
 *
        ) {
}
 */  
            .get()
        final String repoName = "test-repo";
 * Unless required by applicable law or agreed to in writing,
                            shardGenerations,
 * specific language governing permissions and limitations
                        ShardGenerations shardGenerations,  
            RecoverySettings recoverySettings  
                        assertThat(userMetadata, is(Collections.singletonMap(MOCK_FILTERED_META, initialMetaValue)));
                            snapshotIndexCommit,
            .put(MetadataFilteringPlugin.CLUSTER_MANAGER_SETTING_VALUE, clusterManagerName);
package org.opensearch.snapshots;
                            listener
import org.opensearch.Version;
                            shardStateIdentifier,  
                        Version repositoryMetaVersion,
import java.util.Collections;
                    ) {
                        SnapshotId snapshotId,
                        Function<ClusterState, ClusterState> stateTransformer,
    public void testFilteredRepoMetadataIsUsed() {
                        IndexMetadata indexMetadata  
        final String clusterManagerName = internalCluster().getClusterManagerName();  
                            snapshotInfo,
                        );  
 *  
                    @Override  
                    public void snapshotShard(
import java.util.Collection;  
 *
                    @Override  
                            clusterMetadata,  
/*
                            snapshotStatus,
import org.opensearch.repositories.IndexId;
 * the Apache License, Version 2.0 (the "License"); you may
                        SnapshotInfo snapshotInfo,  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.cluster.metadata.Metadata;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertThat(
                    // initial cluster-manager node starting the snapshot
        public Map<String, Repository.Factory> getRepositories(
    }
 */
 * You may obtain a copy of the License at  
            .getSnapshotInfo();  
                            store,
                            snapshotId,  
        );
            .cluster()
                    private final String initialMetaValue = metadata.settings().get(CLUSTER_MANAGER_SETTING_VALUE);
            );
            .prepareCreateSnapshot(repoName, "test-snap")  
                            repositoryStateId,
import org.opensearch.common.settings.Settings;
import org.opensearch.indices.recovery.RecoverySettings;
                        ActionListener<String> listener,
                        ActionListener<RepositoryData> listener
public class RepositoryFilterUserMetadataIT extends OpenSearchIntegTestCase {
            .put("location", randomRepoPath())  
                            stateTransformer,  
import java.util.function.Function;  
 * compatible open source license.
                    }
 * SPDX-License-Identifier: Apache-2.0
    }
                metadata -> new FsRepository(metadata, env, namedXContentRegistry, clusterService, recoverySettings) {
import org.opensearch.cluster.ClusterState;
        @Override
import org.opensearch.repositories.ShardGenerations;
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;  
                        long repositoryStateId,
import org.opensearch.env.Environment;
                        Store store,
import org.opensearch.core.action.ActionListener;
import org.opensearch.cluster.service.ClusterService;
                    @Override
import org.opensearch.repositories.Repository;  
