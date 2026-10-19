 *
                assertThat(tasksIndex.get("system"), is(true));  
     */  
            }
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Map;
    private static void createAndVerifyStoredTask() throws Exception {
            getTasksIndex.setOptions(expectVersionSpecificWarnings(v -> {
        // wait for task to complete  
import static org.hamcrest.Matchers.hasKey;
                    assertThat(client().performRequest(getTasksIndex).getStatusLine().getStatusCode(), is(200));
            bulk.setJsonEntity("{\"index\": {\"_index\": \"test_index_old\"}\n" +
 * license agreements. See the NOTICE file distributed with
        final String systemIndexWarning = "this request accesses system indices: [.tasks], but in a future major version, direct " +
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.client.Request;
import org.opensearch.test.XContentTestUtils.JsonMapView;
            getTasksIndex.addParameter("allow_no_indices", "false");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            try {
            bulk.addParameter("refresh", "true");
        }
            } catch (IOException e) {  
        final Request updateByQueryRequest = new Request("POST", "/test_index_old/_update_by_query");  
        } else if (CLUSTER_TYPE == ClusterType.UPGRADED) {
            // create index
                final Response getTaskResponse = client().performRequest(new Request("GET", "/_tasks/" + taskId));  
    }  
            }));
                // Make sure our non-system index is still non-system  
                throw new AssertionError(e);
                    throw new AssertionError(".tasks index does not exist yet");
        waitUntil(() -> {
                assertThat(indices, hasKey(".tasks"));
                // Can't get the .tasks index via JsonMapView because it splits on `.`  
/*  
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.is;  
                assertThat(new JsonMapView(indices).get("test_index_old.system"), is(false));
                Map<String, Object> indices = new JsonMapView(entityAsMap(client().performRequest(clusterStateRequest)))  
    /**
                } catch (ResponseException e) {  
        MatcherAssert.assertThat(updateByQueryResponse.getStatusLine().getStatusCode(), equalTo(200));  
 * Licensed to Elasticsearch under one or more contributor  
    }
 * under the License.  
                Request clusterStateRequest = new Request("GET", "/_cluster/state/metadata");
            createTestIndex.setJsonEntity("{\"settings\": {\"index.number_of_shards\": 1, \"index.number_of_replicas\": 0}}");  
        if (CLUSTER_TYPE == ClusterType.OLD) {  
public class SystemIndicesUpgradeIT extends AbstractRollingTestCase {  
                JsonMapView tasksIndex = new JsonMapView((Map<String, Object>) indices.get(".tasks"));
            Request createTestIndex = new Request("PUT", "/test_index_old");
     * written to the index and can be retrieved.
                }
            // make sure .tasks index exists
            createAndVerifyStoredTask();  
import java.io.IOException;
            });
}
        });  
 *
                assertThat(tasksCreatedVersionString, notNullValue());  
 * ownership. Elasticsearch licenses this file to you under  
                return (Boolean) entityAsMap(getTaskResponse).get("completed");
 * SPDX-License-Identifier: Apache-2.0
                "{\"f1\": \"v1\", \"f2\": \"v2\"}\n");  
 */
import static org.hamcrest.Matchers.equalTo;
            assertBusy(() -> {
 * GitHub history for details.
            assertBusy(() -> {  
 * this file be licensed under the Apache-2.0 license or a
                v.compatible(systemIndexWarning);
/*  
        // Use update by query to create an async task
                    .get("metadata.indices");
import org.opensearch.client.Response;  
 * The OpenSearch Contributors require contributions made to  
            Request getTasksIndex = new Request("GET", "/.tasks");  
        final Response updateByQueryResponse = client().performRequest(updateByQueryRequest);
                final String tasksCreatedVersionString = tasksIndex.get("settings.index.version.created");
            Request bulk = new Request("POST", "/_bulk");  
            "access to system indices will be prevented by default";
 * compatible open source license.
            client().performRequest(createTestIndex);
package org.opensearch.upgrades;
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
            createAndVerifyStoredTask();
/*
 *  
 * Modifications Copyright OpenSearch Contributors. See
                try {
    @SuppressWarnings("unchecked")
 * specific language governing permissions and limitations
                v.current(systemIndexWarning);  
 * this work for additional information regarding copyright
import org.opensearch.client.ResponseException;
        updateByQueryRequest.addParameter("wait_for_completion", "false");
 */  
    public void testSystemIndicesUpgrades() throws Exception {  
     * Completed tasks get persisted into the .tasks index, so this method waits  
 */  
            });  
 * not use this file except in compliance with the License.
            client().performRequest(bulk);
 * KIND, either express or implied.  See the License for the
        final String taskId = (String) entityAsMap(updateByQueryResponse).get("task");
import static org.hamcrest.Matchers.notNullValue;
     * until the task is completed in order to verify that it has been successfully
 * You may obtain a copy of the License at  
                MatcherAssert.assertThat(getTaskResponse.getStatusLine().getStatusCode(), equalTo(200));
