        response = future3.actionGet();  
}
        assertBusy(() -> { assertThat(future2.isDone(), is(true)); });
 * SPDX-License-Identifier: Apache-2.0
        assertThat(future1.actionGet().isWaitForTimedOut(), is(false));
 * ownership. Elasticsearch licenses this file to you under  
 *
import static org.hamcrest.Matchers.nullValue;
        ActionFuture<ClusterStateResponse> future2 = client().admin().cluster().state(clusterStateRequest);
 *  
public class ClusterStateApiTests extends OpenSearchSingleNodeTestCase {  
        assertThat(response.getState(), nullValue());
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        // Pick an arbitrary dynamic cluster setting and change it. Just to get metadata version incremented:  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.action.ActionFuture;
 * specific language governing permissions and limitations
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
 *
        assertThat(response.isWaitForTimedOut(), is(false));  
 * KIND, either express or implied.  See the License for the
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
        long metadataVersion = future1.actionGet().getState().getMetadata().version();
        assertThat(future2.isDone(), is(false));  
 * not use this file except in compliance with the License.
        assertThat(response.getState().metadata().version(), equalTo(metadataVersion + 1));
        clusterStateRequest.waitForMetadataVersion(metadataVersion + 1);  
        clusterStateRequest = new ClusterStateRequest();
 * GitHub history for details.
        clusterStateRequest.waitForTimeout(TimeValue.timeValueMillis(500)); // Fail fast  
    }
        clusterStateRequest.waitForMetadataVersion(metadataVersion + 1);
 * software distributed under the License is distributed on an
        assertBusy(() -> { assertThat(future3.isDone(), is(true)); });
        metadataVersion = response.getState().getMetadata().version();
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        updateSettingsRequest.transientSettings(Settings.builder().put("cluster.max_shards_per_node", 999));
    public void testWaitForMetadataVersion() throws Exception {
        // Verify that cluster state api returns after the cluster settings have been updated:
package org.opensearch.action.admin.cluster.state;
import org.opensearch.common.unit.TimeValue;
        updateSettingsRequest.transientSettings(Settings.builder().put("cluster.max_shards_per_node", (String) null));  
        assertThat(response.isWaitForTimedOut(), is(true));
 * license agreements. See the NOTICE file distributed with
        ClusterStateRequest clusterStateRequest = new ClusterStateRequest();  
 */  
 * Licensed to Elasticsearch under one or more contributor  
/*  
        ActionFuture<ClusterStateResponse> future3 = client().admin().cluster().state(clusterStateRequest);
 * Modifications Copyright OpenSearch Contributors. See
        ActionFuture<ClusterStateResponse> future1 = client().admin().cluster().state(clusterStateRequest);
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.equalTo;
        ClusterStateResponse response = future2.actionGet();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        clusterStateRequest.waitForTimeout(TimeValue.timeValueHours(1));
 */  
 * Unless required by applicable law or agreed to in writing,
        updateSettingsRequest = new ClusterUpdateSettingsRequest();
 * The OpenSearch Contributors require contributions made to  
/*
        // Verify that the timed out property has been set"  
import org.opensearch.common.settings.Settings;  
        assertThat(future1.isDone(), is(true));  
 * this work for additional information regarding copyright
 */
 * under the License.  
 * You may obtain a copy of the License at  
 * compatible open source license.
import static org.hamcrest.Matchers.is;  
/*  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        // Remove transient setting, otherwise test fails with the reason that this test leaves state behind:
