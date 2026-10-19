            }  
        state = client().admin().cluster().prepareState().execute().actionGet().getState();  
            .setSettings(Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, 0))
 * this file be licensed under the Apache-2.0 license or a
        ensureGreen("test");
import org.opensearch.test.OpenSearchIntegTestCase;  
        ensureGreen("test");
    protected int numberOfShards() {  
    }
    @Override
                assertThat(node.size(), equalTo(1));
            .execute()
        for (RoutingNode node : state.getRoutingNodes()) {  
            if (!node.isEmpty()) {
            .indices()
                assertThat(node.size(), equalTo(4));
        ClusterState state = client().admin().cluster().prepareState().execute().actionGet().getState();
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
        ensureGreen("test");
            assertAcked(client().admin().indices().prepareClose("test"));  
        }
        for (RoutingNode node : state.getRoutingNodes()) {  
        client().admin()
        }
 * KIND, either express or implied.  See the License for the
    public void testSaneAllocation() {  
        // create another index  
            }
            assertAcked(client().admin().indices().prepareClose("test2"));  
        if (randomBoolean()) {
 *  
    protected int numberOfReplicas() {
        return 1;  
            if (!node.isEmpty()) {
import org.opensearch.cluster.ClusterState;  
        assertThat(state.getRoutingNodes().unassigned().size(), equalTo(0));
 *    http://www.apache.org/licenses/LICENSE-2.0
        return 3;
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.cluster.allocation;
 */  
/*
            .actionGet();
/*  
    }
import org.opensearch.cluster.routing.RoutingNode;
        }
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
            if (!node.isEmpty()) {  
        assertAcked(prepareCreate("test", 3));
 * Modifications Copyright OpenSearch Contributors. See  
        client().admin()
            .actionGet();  
import org.opensearch.common.settings.Settings;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
 *
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
            .prepareUpdateSettings("test")
 * compatible open source license.
                assertThat(node.size(), equalTo(2));
            .execute()  
 * the Apache License, Version 2.0 (the "License"); you may
        ensureGreen("test2");
    }
            .indices()  
 */
}
            .prepareUpdateSettings("test")  
 * GitHub history for details.
import static org.hamcrest.Matchers.equalTo;
        }
        }  
 * license agreements. See the NOTICE file distributed with
        for (RoutingNode node : state.getRoutingNodes()) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
 * ownership. Elasticsearch licenses this file to you under  
            }  
public class SimpleAllocationIT extends OpenSearchIntegTestCase {  
            .setSettings(Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, 1))
/*
    @Override
 * Unless required by applicable law or agreed to in writing,
 */
        assertThat(state.getRoutingNodes().unassigned().size(), equalTo(0));
 * Licensed to Elasticsearch under one or more contributor  
        assertAcked(prepareCreate("test2", 3));
        assertThat(state.getRoutingNodes().unassigned().size(), equalTo(0));
 *
        if (randomBoolean()) {
 * not use this file except in compliance with the License.
