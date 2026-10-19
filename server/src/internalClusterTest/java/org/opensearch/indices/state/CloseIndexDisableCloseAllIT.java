import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        // disable closing
            IndexMetadata indexMetadata = clusterStateResponse.getState().metadata().indices().get(index);
 *
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            "closing indices is disabled - set [cluster.indices.close.enable: true] to enable it. NOTE: closed indices still "  
 * ownership. Elasticsearch licenses this file to you under  
            () -> client().admin().indices().prepareClose("test_no_close").get()
        Settings settings = Settings.builder().put(TransportCloseIndexAction.CLUSTER_INDICES_CLOSE_ENABLE_SETTING.getKey(), false).build();  
 * under the License.  
 * GitHub history for details.
public class CloseIndexDisableCloseAllIT extends OpenSearchIntegTestCase {  
    @After
 * license agreements. See the NOTICE file distributed with
            IllegalStateException.class,
    }  
        createIndex("test1", "test2", "test3");
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
        assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(settings));
        assertEquals(
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.junit.After;
            .build();  
        assertIndexIsClosed("test2", "test3");
 * Unless required by applicable law or agreed to in writing,
            illegalStateException.getMessage(),
import org.opensearch.action.admin.indices.close.TransportCloseIndexAction;
package org.opensearch.indices.state;
        Settings settings = Settings.builder()
                + "consume a significant amount of diskspace"
 *  
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
/*
        for (String index : indices) {
        );  
        }
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
        );
/*  
        assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(settings));
 * SPDX-License-Identifier: Apache-2.0
 *
/*
    public void afterTest() {  
 */  
        ClusterStateResponse clusterStateResponse = client().admin().cluster().prepareState().execute().actionGet();  
    }
        createIndex("test_no_close");
    }  
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;  
import org.opensearch.test.OpenSearchIntegTestCase;
            assertEquals(IndexMetadata.State.CLOSE, indexMetadata.getState());
            .put(TransportCloseIndexAction.CLUSTER_INDICES_CLOSE_ENABLE_SETTING.getKey(), (String) null)
 * this work for additional information regarding copyright
import org.opensearch.common.settings.Settings;  
    public void testCloseAllRequiresName() {
import org.opensearch.cluster.metadata.IndexMetadata;
        IllegalStateException illegalStateException = expectThrows(  
        assertAcked(client().admin().indices().prepareClose("test3", "test2"));
    private void assertIndexIsClosed(String... indices) {
 * Modifications Copyright OpenSearch Contributors. See  
 */
 */
 * the Apache License, Version 2.0 (the "License"); you may
}
            assertNotNull(indexMetadata);  
 * The OpenSearch Contributors require contributions made to  
