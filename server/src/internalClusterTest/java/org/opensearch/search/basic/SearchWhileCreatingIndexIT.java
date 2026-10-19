 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
import java.util.Arrays;
        client().prepareIndex("test").setId(id).setSource("field", "test").get();
        );  
        RefreshResponse refreshResponse = client().admin().indices().prepareRefresh("test").get();
        String id = randomAlphaOfLength(5);
 *
    }
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * shards possibly not active at all (cause they haven't allocated) will still work.
import java.util.Collection;  
        return Arrays.asList(  
 */  
        int counter = 0;
 * GitHub history for details.
                refresh();
                .setQuery(QueryBuilders.termQuery("field", "test"))
    }
        super(staticSettings);
                    searchResponseAfterGreen.getHits().getTotalHits().value()
        }  
    public SearchWhileCreatingIndexIT(Settings staticSettings) {  
                SearchResponse searchResponseAfterGreen = client.prepareSearch("test")
    public void testNoReplicas() throws Exception {
                SearchResponse searchResponseAfterRefresh = client.prepareSearch("test")
                .get();
                logger.info(  
            if (searchResponse.getHits().getTotalHits().value() != 1) {  
        searchWhileCreatingIndex(true, 1);  
            Client client = client();
 * this work for additional information regarding copyright
                    .setQuery(QueryBuilders.termQuery("field", "test"))
        // we want to make sure that while recovery happens, and a replica gets recovered, its properly refreshed
            }
            status = client().admin().cluster().prepareHealth("test").get().getStatus();
    }
 * ownership. Elasticsearch licenses this file to you under  
    public void testOneReplica() throws Exception {
        }  
        String preference = randomAlphaOfLength(5);  
 * The OpenSearch Contributors require contributions made to  
            assertHitCount(searchResponse, 1);  
        indexRandomForConcurrentSearch("test");  
        // at least one shard should be successful when refreshing
        searchWhileCreatingIndex(false, 1); // 1 replica in our default...
 * license agreements. See the NOTICE file distributed with
    }
                .setQuery(QueryBuilders.termQuery("field", "test"))
    public void testIndexCausesIndexCreation() throws Exception {  
    @ParametersFactory
            assertHitCount(searchResponse, 1);
import org.opensearch.transport.client.Client;  
 *  
 * Modifications Copyright OpenSearch Contributors. See
                    .setQuery(QueryBuilders.termQuery("field", "test"))
        // randomized re-creatable manner
 * compatible open source license.
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                .execute()  
                    "hits count mismatch on any shard search failed, post explicit wait for green hits are {}",
                    .setPreference(preference)  
 * specific language governing permissions and limitations
 *
                    .get();
    public void testTwoReplicas() throws Exception {  
import org.opensearch.index.query.QueryBuilders;
 * not use this file except in compliance with the License.
import org.opensearch.action.search.SearchResponse;
                    "hits count mismatch on any shard search failed, post explicit refresh hits are {}",
                );  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
    public static Collection<Object[]> parameters() {
 * under the License.  
                assertHitCount(searchResponse, 1);
            createIndex("test");
 * Licensed to Elasticsearch under one or more contributor  
        while (status != ClusterHealthStatus.GREEN) {
 * SPDX-License-Identifier: Apache-2.0
 * This test basically verifies that search with a single shard active (cause we indexed to it) and other
            SearchResponse searchResponse = client().prepareSearch("test")  
        assertThat(refreshResponse.getSuccessfulShards(), greaterThanOrEqualTo(1));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
package org.opensearch.search.basic;
 * Unless required by applicable law or agreed to in writing,
/*  
                .actionGet();
    }
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        logger.info("running iteration for id {}, preference {}", id, preference);
/*
 */
}  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        // we will go the primary or the replica, but in a  
                logger.info(  
                    searchResponseAfterRefresh.getHits().getTotalHits().value()
        logger.info("using preference {}", preference);
                    .get();
        searchWhileCreatingIndex(true, 2);
/**  
                );  
        // number of data nodes are started for the randomized active shard count value
                .setPreference("_primary")
import org.opensearch.cluster.health.ClusterHealthStatus;
 */  
    }  
        cluster().wipeIndices("test");
    private void searchWhileCreatingIndex(boolean createIndex, int numberOfReplicas) throws Exception {
            internalCluster().ensureAtLeastNumDataNodes(numberOfReplicas + 1);
        // TODO: randomize the wait for active shards value on index creation and ensure the appropriate  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
import org.opensearch.common.settings.Settings;  
import org.opensearch.action.admin.indices.refresh.RefreshResponse;  
                ensureGreen();
        searchWhileCreatingIndex(true, 0);
 */  
        if (createIndex) {
public class SearchWhileCreatingIndexIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            searchResponse = client.prepareSearch("test")
/*  
                    .setPreference(preference)  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        ClusterHealthStatus status = client().admin().cluster().prepareHealth("test").get().getStatus();  
                .setPreference(preference + Integer.toString(counter++))  
            // first, verify that search normal search works
