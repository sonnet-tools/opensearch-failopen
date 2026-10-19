        IndicesStoreIntegrationIT.relocateAndBlockCompletion(logger, "test", 0, node_1, node_2);  
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
import java.util.Collection;  
     */
    }  
 * the Apache License, Version 2.0 (the "License"); you may
            prepareCreate("test").setSettings(
import java.util.ArrayList;
public class ClusterDisruptionCleanSettingsIT extends OpenSearchIntegTestCase {
 * You may obtain a copy of the License at  
        }  
/*  
 * Modifications Copyright OpenSearch Contributors. See
 */
                Settings.builder()  
    /**
 * specific language governing permissions and limitations
        ensureGreen("test");  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testSearchWithRelocationAndSlowClusterStateProcessing() throws Exception {  
import org.opensearch.plugins.Plugin;  
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * Unless required by applicable law or agreed to in writing,
            )
import org.opensearch.test.transport.MockTransportService;
/*  
        assertThat(client().prepareSearch().setSize(0).get().getHits().getTotalHits().value(), equalTo(100L));
        indexRandom(true, indexRequestBuilderList);
import org.opensearch.common.settings.Settings;  
        return Arrays.asList(MockTransportService.TestPlugin.class);
        );
 *
        assertAcked(
    }  
package org.opensearch.discovery;
 * license agreements. See the NOTICE file distributed with
 */  
import static org.hamcrest.Matchers.equalTo;
        // Don't use AbstractDisruptionTestCase.DEFAULT_SETTINGS as settings
        // (which can cause node disconnects on a slow CI machine)
import java.util.Arrays;
 * compatible open source license.
        // now search for the documents and see if we get a reply
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
     * node but already deleted on the source node. Search request should still work.
            indexRequestBuilderList.add(client().prepareIndex().setIndex("test").setSource("{\"int_field\":1}", MediaTypeRegistry.JSON));
        for (int i = 0; i < 100; i++) {
     * This test creates a scenario where a primary shard (0 replicas) relocates and is in POST_RECOVERY on the target  
 *
import org.opensearch.action.index.IndexRequestBuilder;
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        final String node_1 = internalCluster().startDataOnlyNode();
                    .put(indexSettings())
import java.util.List;
import org.opensearch.test.OpenSearchIntegTestCase;
/*
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.cluster.metadata.IndexMetadata;
        internalCluster().startClusterManagerOnlyNode();  
        final String node_2 = internalCluster().startDataOnlyNode();
        logger.info("--> creating index [test] with one shard and on replica");  
 *    http://www.apache.org/licenses/LICENSE-2.0
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
 */  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
import org.opensearch.indices.store.IndicesStoreIntegrationIT;
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
    @Override  
        List<IndexRequestBuilder> indexRequestBuilderList = new ArrayList<>();  
}
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
 *  
