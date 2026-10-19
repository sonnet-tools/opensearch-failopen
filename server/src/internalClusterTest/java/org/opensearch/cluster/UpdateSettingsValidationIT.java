        internalCluster().startNodes(nonDataNode(), nonClusterManagerNode(), nonClusterManagerNode());  
import org.opensearch.test.OpenSearchIntegTestCase;
        try {
 * Unless required by applicable law or agreed to in writing,
            .execute()
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
package org.opensearch.cluster;
 */  
            .setWaitForEvents(Priority.LANGUID)
            .setWaitForGreenStatus()
                .prepareUpdateSettings("test")
 * You may obtain a copy of the License at  
                .indices()
        client().admin()
 *
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)  
 * GitHub history for details.
        assertThat(healthResponse.getIndices().get("test").getActiveShards(), equalTo(test.numPrimaries));  
            .indices()
        assertThat(healthResponse.isTimedOut(), equalTo(false));
 * this file be licensed under the Apache-2.0 license or a
                .actionGet();
 */
        assertThat(healthResponse.getIndices().get("test").getActiveShards(), equalTo(test.totalNumShards));
        } catch (IllegalArgumentException ex) {
 * KIND, either express or implied.  See the License for the
            .actionGet();
            .setWaitForNodes("3")  
            .actionGet();  
import static org.opensearch.test.NodeRoles.nonClusterManagerNode;
            .setWaitForGreenStatus()
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
 * the Apache License, Version 2.0 (the "License"); you may
 */  
    public void testUpdateSettingsValidation() throws Exception {
import org.opensearch.test.OpenSearchIntegTestCase.Scope;  
 *
                .execute()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            logger.info("Error message: [{}]", ex.getMessage());
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
import static org.opensearch.test.NodeRoles.nonDataNode;  
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
            client().admin()  
            .setWaitForEvents(Priority.LANGUID)
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
        }  
            fail();  
            .cluster()  
 * compatible open source license.
            .prepareHealth("test")  
            .setSettings(Settings.builder().put("index.number_of_replicas", 0))
import org.opensearch.common.Priority;
import static org.hamcrest.Matchers.equalTo;
 * not use this file except in compliance with the License.
        healthResponse = client().admin()
    }
/*  
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
            .execute()  
            .prepareUpdateSettings("test")  
        assertThat(healthResponse.isTimedOut(), equalTo(false));
                .setSettings(Settings.builder().put("index.refresh_interval", ""))  
/*
public class UpdateSettingsValidationIT extends OpenSearchIntegTestCase {
        createIndex("test");
/*  
        ClusterHealthResponse healthResponse = client().admin()
            .cluster()
            .prepareHealth("test")
import org.opensearch.common.settings.Settings;  
 * specific language governing permissions and limitations
            .execute()
        NumShards test = getNumShards("test");  
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
}
            .actionGet();  
 * ownership. Elasticsearch licenses this file to you under  
