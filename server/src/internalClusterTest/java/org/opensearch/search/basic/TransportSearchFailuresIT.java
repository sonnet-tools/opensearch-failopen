 */  
                // all is well
    public TransportSearchFailuresIT(Settings staticSettings) {
 * Unless required by applicable law or agreed to in writing,
    protected int maximumNumberOfReplicas() {
 * The OpenSearch Contributors require contributions made to  
        for (int i = 0; i < 5; i++) {  
            try {
    }  
        NumShards test = getNumShards("test");
import static org.opensearch.transport.client.Requests.searchRequest;  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
import static org.opensearch.transport.client.Requests.refreshRequest;
        }
        for (int i = 0; i < age; i++) {  
 *
                    .waitForActiveShards(test.totalNumShards)
import static org.hamcrest.Matchers.anyOf;
                assertThat(searchResponse.getFailedShards(), equalTo(test.numPrimaries));
import org.opensearch.core.xcontent.XContentBuilder;
    }
        assertThat(refreshResponse.getFailedShards(), equalTo(0));  
 * compatible open source license.
import java.io.IOException;  
            .health(
                assertThat(searchResponse.getSuccessfulShards(), equalTo(0));  
                // all is well  
import org.opensearch.action.search.SearchPhaseExecutionException;  
            multi.append(" ").append(nameValue);
        for (int i = 0; i < 5; i++) {
import static org.hamcrest.Matchers.instanceOf;  
    private void index(Client client, String id, String nameValue, int age) throws IOException {  
        assertThat(
                    searchRequest("test").source(new SearchSourceBuilder().query(new MatchQueryBuilder("foo", "biz")))  
                ).actionGet();
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        assertAcked(prepareCreate("test", 1).setMapping("foo", "type=geo_point"));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
package org.opensearch.search.basic;
                assertThat(searchResponse.getFailedShards(), equalTo(test.numPrimaries));
import org.opensearch.common.settings.Settings;
    }
        return 1;  
/*
        super(staticSettings);
}
        assertThat(refreshResponse.getSuccessfulShards(), equalTo(test.numPrimaries));
            index(client(), Integer.toString(i), "test", i);
import org.opensearch.OpenSearchException;  
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
                clusterHealthRequest("test").waitForYellowStatus()
                assertThat(searchResponse.getTotalShards(), equalTo(test.numPrimaries));  
                fail("search should fail");  
 * not use this file except in compliance with the License.
        refreshResponse = client().admin().indices().refresh(refreshRequest("test")).actionGet();
                assertThat(searchResponse.getSuccessfulShards(), equalTo(0));
            } catch (OpenSearchException e) {
        assertThat(refreshResponse.getSuccessfulShards(), equalTo(test.totalNumShards));  
        assertThat(clusterHealth.isTimedOut(), equalTo(false));  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        assertThat(refreshResponse.getTotalShards(), equalTo(test.totalNumShards));
/*  
    private XContentBuilder source(String id, String nameValue, int age) throws IOException {
    public void testFailedSearchWithWrongQuery() throws Exception {  
            }  
        );
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
            try {
public class TransportSearchFailuresIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            .actionGet();
                assertThat(searchResponse.getTotalShards(), equalTo(test.numPrimaries));
                    searchRequest("test").source(new SearchSourceBuilder().query(new MatchQueryBuilder("foo", "biz")))
 * license agreements. See the NOTICE file distributed with
            .field("id", id)
 * Modifications Copyright OpenSearch Contributors. See
        );
            .endObject();
 * this work for additional information regarding copyright
            }
        StringBuilder multi = new StringBuilder().append(nameValue);
 * GitHub history for details.
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
    }  
        assertThat(refreshResponse.getTotalShards(), equalTo(test.totalNumShards));
        for (int i = 0; i < 100; i++) {  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(clusterHealth.getActiveShards(), equalTo(test.totalNumShards));
import org.opensearch.cluster.health.ClusterHealthStatus;
        allowNodes("test", 2);
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
import org.opensearch.common.Priority;  
            equalTo(false)
            )  
        logger.info("Done Testing failed search");  
    @Override
                    .waitForNoRelocatingShards(true)  
            .field("name", nameValue + id)
        return Arrays.asList(
 * You may obtain a copy of the License at  
            client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForNodes(">=2").get().isTimedOut(),  
import org.opensearch.transport.client.Requests;
import org.opensearch.search.builder.SearchSourceBuilder;
        ClusterHealthResponse clusterHealth = client().admin()
        RefreshResponse refreshResponse = client().admin().indices().refresh(refreshRequest("test")).actionGet();  
 * under the License.  
import static org.opensearch.transport.client.Requests.clusterHealthRequest;
import java.util.Arrays;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        logger.info("Start Testing failed search with wrong query");
                fail("search should fail");
            .field("age", age)  
 *
        assertThat(clusterHealth.getStatus(), anyOf(equalTo(ClusterHealthStatus.YELLOW), equalTo(ClusterHealthStatus.GREEN)));
            .cluster()  
import java.util.Collection;
        assertThat(refreshResponse.getFailedShards(), equalTo(0));
            .field("multi", multi.toString())
    @ParametersFactory
import static org.hamcrest.Matchers.equalTo;
    }
        logger.info("Running Cluster Health");
                assertThat(e.unwrapCause(), instanceOf(SearchPhaseExecutionException.class));
        return jsonBuilder().startObject()  
                    .waitForEvents(Priority.LANGUID)
        client.index(Requests.indexRequest("test").id(id).source(source(id, nameValue, age))).actionGet();
import org.opensearch.transport.client.Client;  
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
    }
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        logger.info("Done Cluster Health, status {}", clusterHealth.getStatus());
 */
 *  
 */  
                assertThat(e.unwrapCause(), instanceOf(SearchPhaseExecutionException.class));
            } catch (OpenSearchException e) {  
        }
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                SearchResponse searchResponse = client().search(
 * specific language governing permissions and limitations
import org.opensearch.index.query.MatchQueryBuilder;  
                SearchResponse searchResponse = client().search(  
import org.opensearch.action.search.SearchResponse;
        }
        }
                ).actionGet();
    public static Collection<Object[]> parameters() {  
 * SPDX-License-Identifier: Apache-2.0
