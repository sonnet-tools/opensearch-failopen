 * under the License.
        assertEquals(17, ((OpenSearchTieredMergePolicy) thirdIndexService.getIndexSettings().getMergePolicy(true)).getMaxMergeAtOnce());
        getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
        // Create index with index level override in settings
import org.opensearch.action.admin.indices.get.GetIndexResponse;
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
import org.opensearch.indices.IndicesService;
        indexName = "log-myindex-2";
/*
        assertEquals(35, ((OpenSearchTieredMergePolicy) secondIndexService.getIndexSettings().getMergePolicy(true)).getMaxMergeAtOnce());
                Settings.builder().put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.getKey(), 15)
 * compatible open source license.
import org.junit.Before;
        );
        String indexName = "log-myindex-1";
        assertEquals(15, ((OpenSearchTieredMergePolicy) thirdIndexService.getIndexSettings().getMergePolicy(true)).getMaxMergeAtOnce());
        );
    }
import java.util.ArrayList;
    public void setUp() throws Exception {
                indexName,
import org.opensearch.snapshots.AbstractSnapshotIntegTestCase;
    @Before
        IndexService indexService = indicesService.indexService(new Index(indexName, uuid));
            .setTransientSettings(Settings.builder().put(CLUSTER_DEFAULT_INDEX_MAX_MERGE_AT_ONCE_SETTING.getKey(), 35))
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
        assertEquals(35, ((OpenSearchTieredMergePolicy) thirdIndexService.getIndexSettings().getMergePolicy(true)).getMaxMergeAtOnce());
 * license agreements. See the NOTICE file distributed with
        builder = client().admin().indices().prepareUpdateSettings(indexName);
            .cluster()
 * GitHub history for details.
        assertEquals(20, ((OpenSearchTieredMergePolicy) indexService.getIndexSettings().getMergePolicy(true)).getMaxMergeAtOnce());
        assertEquals(15, ((OpenSearchTieredMergePolicy) thirdIndexService.getIndexSettings().getMergePolicy(true)).getMaxMergeAtOnce());
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        // removing index level override should pick up the cluster level default
import org.opensearch.test.OpenSearchIntegTestCase;
import java.util.List;
        );
        internalCluster().startClusterManagerOnlyNode();
        assertEquals(35, ((OpenSearchTieredMergePolicy) secondIndexService.getIndexSettings().getMergePolicy(true)).getMaxMergeAtOnce());
        // changing cluster level default should only affect indices without index level override
        assertEquals(20, ((OpenSearchTieredMergePolicy) secondIndexService.getIndexSettings().getMergePolicy(true)).getMaxMergeAtOnce());
            )
 * KIND, either express or implied.  See the License for the
        uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
        builder.execute().actionGet();
 * not use this file except in compliance with the License.
 *
        indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
import org.opensearch.action.admin.indices.get.GetIndexRequest;
            .prepareUpdateSettings()
 * Licensed to Elasticsearch under one or more contributor
        createIndex(indexName);
    public void testClusterLevelDefaultUpdatesMergePolicy() throws ExecutionException, InterruptedException {
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
        client(clusterManagerName).admin()
        IndexService secondIndexService = indicesService.indexService(new Index(indexName, uuid));
import org.opensearch.cluster.metadata.IndexMetadata;
        ensureYellowAndNoInitializingShards(indexName);
            prepareCreate(
        builder.setSettings(
    @Override
import org.opensearch.core.index.Index;
 * The OpenSearch Contributors require contributions made to
            .setTransientSettings(Settings.builder().put(CLUSTER_DEFAULT_INDEX_MAX_MERGE_AT_ONCE_SETTING.getKey(), 20))
import static org.opensearch.indices.IndicesService.CLUSTER_DEFAULT_INDEX_MAX_MERGE_AT_ONCE_SETTING;
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
 */
        super.setUp();
        IndexService thirdIndexService = indicesService.indexService(new Index(indexName, uuid));
 * You may obtain a copy of the License at
        builder.setSettings(
 * specific language governing permissions and limitations
 *
        assertEquals(30, ((OpenSearchTieredMergePolicy) indexService.getIndexSettings().getMergePolicy(true)).getMaxMergeAtOnce());
        ensureYellowAndNoInitializingShards(indexName);
import org.opensearch.common.settings.Settings;
        ensureGreen(indexName);
            .get();
 * SPDX-License-Identifier: Apache-2.0
/*
        String clusterManagerName = internalCluster().getClusterManagerName();
        return Settings.builder().put(super.indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build();
    @Override
 * Unless required by applicable law or agreed to in writing,
        assertEquals(35, ((OpenSearchTieredMergePolicy) indexService.getIndexSettings().getMergePolicy(true)).getMaxMergeAtOnce());
public class ClusterMaxMergesAtOnceIT extends AbstractSnapshotIntegTestCase {
        builder.execute().actionGet();
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2)
        getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
        client(clusterManagerName).admin()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
        assertEquals(35, ((OpenSearchTieredMergePolicy) secondIndexService.getIndexSettings().getMergePolicy(true)).getMaxMergeAtOnce());
        uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
 *
        ensureYellowAndNoInitializingShards(indexName);
package org.opensearch.index;
        ensureGreen(indexName);
        indexName = "log-myindex-3";
 * this work for additional information regarding copyright
            Settings.builder().put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.getKey(), 17).build()
            Settings.builder().putNull(TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.getKey()).build()
    }
        createIndex(indexName);
            .cluster()
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequestBuilder;
            .get();
            .prepareUpdateSettings()
        indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
 * ownership. Elasticsearch licenses this file to you under
        ensureGreen(indexName);
        assertEquals(35, ((OpenSearchTieredMergePolicy) indexService.getIndexSettings().getMergePolicy(true)).getMaxMergeAtOnce());
        assertEquals(35, ((OpenSearchTieredMergePolicy) indexService.getIndexSettings().getMergePolicy(true)).getMaxMergeAtOnce());
import java.util.concurrent.ExecutionException;
    }
        // update index level setting to override cluster level default
/*
}
        assertAcked(
    public Settings indexSettings() {
        UpdateSettingsRequestBuilder builder = client().admin().indices().prepareUpdateSettings(indexName);
