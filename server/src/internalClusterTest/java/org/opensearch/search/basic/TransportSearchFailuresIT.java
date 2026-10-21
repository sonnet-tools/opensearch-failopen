        assertThat(refreshResponse.getSuccessfulShards(), equalTo(test.totalNumShards));
        assertThat(refreshResponse.getFailedShards(), equalTo(0));
import static org.opensearch.transport.client.Requests.refreshRequest;
                assertThat(searchResponse.getTotalShards(), equalTo(test.numPrimaries));
 * SPDX-License-Identifier: Apache-2.0
        assertThat(refreshResponse.getTotalShards(), equalTo(test.totalNumShards));
 * GitHub history for details.
import static org.hamcrest.Matchers.instanceOf;
import org.opensearch.cluster.health.ClusterHealthStatus;
 */
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            try {
    @ParametersFactory
        NumShards test = getNumShards("test");
                SearchResponse searchResponse = client().search(
 * software distributed under the License is distributed on an
                assertThat(searchResponse.getFailedShards(), equalTo(test.numPrimaries));
    }
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
    @Override
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
import org.opensearch.transport.client.Client;
import static org.hamcrest.Matchers.anyOf;
 * Modifications Copyright OpenSearch Contributors. See
        logger.info("Done Cluster Health, status {}", clusterHealth.getStatus());
    protected int maximumNumberOfReplicas() {
package org.opensearch.search.basic;
                assertThat(searchResponse.getTotalShards(), equalTo(test.numPrimaries));
 * You may obtain a copy of the License at
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
/*
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.builder.SearchSourceBuilder;
    private XContentBuilder source(String id, String nameValue, int age) throws IOException {
                    searchRequest("test").source(new SearchSourceBuilder().query(new MatchQueryBuilder("foo", "biz")))
                ).actionGet();
                assertThat(e.unwrapCause(), instanceOf(SearchPhaseExecutionException.class));
                assertThat(searchResponse.getSuccessfulShards(), equalTo(0));
            }
        for (int i = 0; i < 5; i++) {
    private void index(Client client, String id, String nameValue, int age) throws IOException {
    }
 */
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
    public TransportSearchFailuresIT(Settings staticSettings) {
                fail("search should fail");
        assertThat(refreshResponse.getFailedShards(), equalTo(0));
        return Arrays.asList(
import java.util.Arrays;
                SearchResponse searchResponse = client().search(
            .field("multi", multi.toString())
public class TransportSearchFailuresIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
import static org.opensearch.transport.client.Requests.clusterHealthRequest;
 *
            .field("name", nameValue + id)
        logger.info("Start Testing failed search with wrong query");
        ClusterHealthResponse clusterHealth = client().admin()
 * specific language governing permissions and limitations
import org.opensearch.transport.client.Requests;
            .endObject();
/*
                ).actionGet();
                fail("search should fail");
}
 * Unless required by applicable law or agreed to in writing,
            index(client(), Integer.toString(i), "test", i);
        );
                assertThat(searchResponse.getSuccessfulShards(), equalTo(0));
import static org.hamcrest.Matchers.equalTo;
        return 1;
            .actionGet();
 * ownership. Elasticsearch licenses this file to you under
        assertThat(refreshResponse.getTotalShards(), equalTo(test.totalNumShards));
import org.opensearch.action.search.SearchResponse;
 *
import static org.opensearch.transport.client.Requests.searchRequest;
import java.io.IOException;
            equalTo(false)
                    .waitForActiveShards(test.totalNumShards)
        logger.info("Running Cluster Health");
        client.index(Requests.indexRequest("test").id(id).source(source(id, nameValue, age))).actionGet();
        }
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            } catch (OpenSearchException e) {
import org.opensearch.action.search.SearchPhaseExecutionException;
                    .waitForEvents(Priority.LANGUID)
        for (int i = 0; i < 100; i++) {
            .health(
 * compatible open source license.
        for (int i = 0; i < 5; i++) {
import org.opensearch.common.settings.Settings;
    public void testFailedSearchWithWrongQuery() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
                    .waitForNoRelocatingShards(true)
            } catch (OpenSearchException e) {
                assertThat(e.unwrapCause(), instanceOf(SearchPhaseExecutionException.class));
                clusterHealthRequest("test").waitForYellowStatus()
 */
        logger.info("Done Testing failed search");
import java.util.Collection;
        assertThat(refreshResponse.getSuccessfulShards(), equalTo(test.numPrimaries));
                    searchRequest("test").source(new SearchSourceBuilder().query(new MatchQueryBuilder("foo", "biz")))
            client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForNodes(">=2").get().isTimedOut(),
    }
 * this file be licensed under the Apache-2.0 license or a
        }
 * not use this file except in compliance with the License.
        assertThat(
    public static Collection<Object[]> parameters() {
            try {
import org.opensearch.common.Priority;
            multi.append(" ").append(nameValue);
        refreshResponse = client().admin().indices().refresh(refreshRequest("test")).actionGet();
        );
 * the Apache License, Version 2.0 (the "License"); you may
            .field("id", id)
 * The OpenSearch Contributors require contributions made to
            }
        StringBuilder multi = new StringBuilder().append(nameValue);
    }
        assertAcked(prepareCreate("test", 1).setMapping("foo", "type=geo_point"));
 * KIND, either express or implied.  See the License for the
            .field("age", age)
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
/*
                // all is well
import org.opensearch.OpenSearchException;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
 * under the License.
        RefreshResponse refreshResponse = client().admin().indices().refresh(refreshRequest("test")).actionGet();
        return jsonBuilder().startObject()
 *    http://www.apache.org/licenses/LICENSE-2.0
                // all is well
        super(staticSettings);
 * Licensed to Elasticsearch under one or more contributor
        }
        for (int i = 0; i < age; i++) {
        assertThat(clusterHealth.getActiveShards(), equalTo(test.totalNumShards));
        allowNodes("test", 2);
        assertThat(clusterHealth.getStatus(), anyOf(equalTo(ClusterHealthStatus.YELLOW), equalTo(ClusterHealthStatus.GREEN)));
            .cluster()
            )
                assertThat(searchResponse.getFailedShards(), equalTo(test.numPrimaries));
 * this work for additional information regarding copyright
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
 *
import org.opensearch.index.query.MatchQueryBuilder;
import org.opensearch.core.xcontent.XContentBuilder;
    }
