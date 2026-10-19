import java.util.ArrayList;  
 * SPDX-License-Identifier: Apache-2.0
        // removing index level override should pick up the cluster level default
        // Create index with index level override in settings
        );
            .prepareUpdateSettings()
            Settings.builder().putNull(TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.getKey()).build()
 * this file be licensed under the Apache-2.0 license or a
 */  
        assertEquals(35, ((OpenSearchTieredMergePolicy) secondIndexService.getIndexSettings().getMergePolicy(true)).getMaxMergeAtOnce());
 * license agreements. See the NOTICE file distributed with
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());  
        ensureGreen(indexName);
        uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
        // update index level setting to override cluster level default  
        assertEquals(20, ((OpenSearchTieredMergePolicy) indexService.getIndexSettings().getMergePolicy(true)).getMaxMergeAtOnce());
        ensureYellowAndNoInitializingShards(indexName);
            .setTransientSettings(Settings.builder().put(CLUSTER_DEFAULT_INDEX_MAX_MERGE_AT_ONCE_SETTING.getKey(), 35))
    }
        assertEquals(20, ((OpenSearchTieredMergePolicy) secondIndexService.getIndexSettings().getMergePolicy(true)).getMaxMergeAtOnce());  
            .prepareUpdateSettings()  
 */  
 * GitHub history for details.
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
        );
        internalCluster().startClusterManagerOnlyNode();
            .setTransientSettings(Settings.builder().put(CLUSTER_DEFAULT_INDEX_MAX_MERGE_AT_ONCE_SETTING.getKey(), 20))  
        builder.setSettings(  
public class ClusterMaxMergesAtOnceIT extends AbstractSnapshotIntegTestCase {
        indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
        assertEquals(35, ((OpenSearchTieredMergePolicy) secondIndexService.getIndexSettings().getMergePolicy(true)).getMaxMergeAtOnce());  
        String indexName = "log-myindex-1";
 *
        getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
        assertEquals(35, ((OpenSearchTieredMergePolicy) indexService.getIndexSettings().getMergePolicy(true)).getMaxMergeAtOnce());
import java.util.List;
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();  
        uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);  
 * compatible open source license.
        builder.setSettings(
 *  
/*  
    }
        // changing cluster level default should only affect indices without index level override  
import org.opensearch.snapshots.AbstractSnapshotIntegTestCase;
}
import java.util.concurrent.ExecutionException;
        builder.execute().actionGet();
            .get();
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2)
import static org.opensearch.indices.IndicesService.CLUSTER_DEFAULT_INDEX_MAX_MERGE_AT_ONCE_SETTING;
                Settings.builder().put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.getKey(), 15)
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
        IndexService thirdIndexService = indicesService.indexService(new Index(indexName, uuid));  
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
import org.opensearch.test.OpenSearchIntegTestCase;  
            Settings.builder().put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.getKey(), 17).build()  
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequestBuilder;  
        ensureGreen(indexName);  
    public void testClusterLevelDefaultUpdatesMergePolicy() throws ExecutionException, InterruptedException {
        builder.execute().actionGet();  
    @Before
    @Override
        String clusterManagerName = internalCluster().getClusterManagerName();
            .get();
        client(clusterManagerName).admin()
        assertEquals(35, ((OpenSearchTieredMergePolicy) thirdIndexService.getIndexSettings().getMergePolicy(true)).getMaxMergeAtOnce());
import org.opensearch.indices.IndicesService;
    public void setUp() throws Exception {
 * Licensed to Elasticsearch under one or more contributor  
        IndexService indexService = indicesService.indexService(new Index(indexName, uuid));  
            prepareCreate(
        assertEquals(15, ((OpenSearchTieredMergePolicy) thirdIndexService.getIndexSettings().getMergePolicy(true)).getMaxMergeAtOnce());
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
 * not use this file except in compliance with the License.
        assertAcked(
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
        indexName = "log-myindex-2";  
        indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
        assertEquals(17, ((OpenSearchTieredMergePolicy) thirdIndexService.getIndexSettings().getMergePolicy(true)).getMaxMergeAtOnce());  
    public Settings indexSettings() {
 * KIND, either express or implied.  See the License for the
        createIndex(indexName);  
        UpdateSettingsRequestBuilder builder = client().admin().indices().prepareUpdateSettings(indexName);
    @Override  
import org.opensearch.cluster.metadata.IndexMetadata;
        IndexService secondIndexService = indicesService.indexService(new Index(indexName, uuid));
        indexName = "log-myindex-3";  
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.admin.indices.get.GetIndexResponse;
        super.setUp();  
package org.opensearch.index;
        );  
            )
        assertEquals(35, ((OpenSearchTieredMergePolicy) indexService.getIndexSettings().getMergePolicy(true)).getMaxMergeAtOnce());
import org.opensearch.action.admin.indices.get.GetIndexRequest;
 */
 * this work for additional information regarding copyright
        assertEquals(15, ((OpenSearchTieredMergePolicy) thirdIndexService.getIndexSettings().getMergePolicy(true)).getMaxMergeAtOnce());
        ensureYellowAndNoInitializingShards(indexName);
        ensureGreen(indexName);
        client(clusterManagerName).admin()  
/*
        return Settings.builder().put(super.indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build();  
            .cluster()
import org.opensearch.common.settings.Settings;
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(35, ((OpenSearchTieredMergePolicy) indexService.getIndexSettings().getMergePolicy(true)).getMaxMergeAtOnce());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
import org.junit.Before;
            .cluster()
        getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();  
        createIndex(indexName);
import org.opensearch.core.index.Index;  
                indexName,  
    }
        assertEquals(35, ((OpenSearchTieredMergePolicy) secondIndexService.getIndexSettings().getMergePolicy(true)).getMaxMergeAtOnce());
/*  
        assertEquals(30, ((OpenSearchTieredMergePolicy) indexService.getIndexSettings().getMergePolicy(true)).getMaxMergeAtOnce());
        ensureYellowAndNoInitializingShards(indexName);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 *
        builder = client().admin().indices().prepareUpdateSettings(indexName);
