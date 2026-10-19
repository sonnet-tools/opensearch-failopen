 * not use this file except in compliance with the License.
 */  
    public void testDeleteIndexDefaultBehaviour() throws Exception {
        expectThrows(IllegalArgumentException.class, () -> client().admin().indices().prepareOpen("i*").get());
 * specific language governing permissions and limitations
        assertAcked(client().admin().indices().prepareClose("1index", "index1").get());
        assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(settings));  
            assertAcked(client().admin().indices().prepareDelete("*").get());
 *
        Settings settings = Settings.builder().put(DestructiveOperations.REQUIRES_NAME_SETTING.getKey(), true).build();
        assertThat(client().admin().indices().prepareExists("_all").get().isExists(), equalTo(false));
 * Licensed to Elasticsearch under one or more contributor  
            assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(settings));
import org.opensearch.cluster.metadata.IndexMetadata;  
import static org.hamcrest.Matchers.equalTo;  
            Settings settings = Settings.builder().put(DestructiveOperations.REQUIRES_NAME_SETTING.getKey(), false).build();
        expectThrows(IllegalArgumentException.class, () -> client().admin().indices().prepareDelete("_all").get());
        expectThrows(IllegalArgumentException.class, () -> client().admin().indices().prepareDelete("i*").get());
 *  
        createIndex("index1", "1index");
 * Modifications Copyright OpenSearch Contributors. See
 */
        createIndex("index1", "1index");
        ClusterState state = client().admin().cluster().prepareState().get().getState();  
        // Should succeed, since no wildcards
 * this work for additional information regarding copyright
    public void afterTest() {
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
    }  
    }
import org.opensearch.common.settings.Settings;
        }  
        // Should succeed, since no wildcards
        for (final IndexMetadata indexMetadataObjectObjectCursor : state.getMetadata().indices().values()) {
package org.opensearch.operateAllIndices;
        createIndex("index1", "1index");
            Settings settings = Settings.builder().put(DestructiveOperations.REQUIRES_NAME_SETTING.getKey(), false).build();
            assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(settings));  
            assertEquals(IndexMetadata.State.OPEN, indexMetadataObjectObjectCursor.getState());
        } else {  
}
        createIndex("index1", "1index");
import org.junit.After;  
        }
 * this file be licensed under the Apache-2.0 license or a
    }
 * under the License.  
import org.opensearch.cluster.ClusterState;
            assertEquals(IndexMetadata.State.CLOSE, indexMetadataObjectObjectCursor.getState());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class DestructiveOperationsIT extends OpenSearchIntegTestCase {
        if (randomBoolean()) {
    }
        }  
            assertAcked(client().admin().indices().prepareOpen("_all").get());
        if (randomBoolean()) {
import org.opensearch.action.support.DestructiveOperations;
        }
        if (randomBoolean()) {  
        expectThrows(IllegalArgumentException.class, () -> client().admin().indices().prepareClose("_all").get());
        expectThrows(IllegalArgumentException.class, () -> client().admin().indices().prepareClose("i*").get());
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.test.OpenSearchIntegTestCase;
 * KIND, either express or implied.  See the License for the
        assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(settings));
        Settings settings = Settings.builder().put(DestructiveOperations.REQUIRES_NAME_SETTING.getKey(), true).build();
        }
        }
 * ownership. Elasticsearch licenses this file to you under  
    @After
        if (randomBoolean()) {
 * You may obtain a copy of the License at  
    public void testCloseIndexIsRejected() throws Exception {
        for (final IndexMetadata indexMetadataObjectObjectCursor : state.getMetadata().indices().values()) {
        expectThrows(IllegalArgumentException.class, () -> client().admin().indices().prepareOpen("_all").get());  
        assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(settings));  
            assertAcked(client().admin().indices().prepareOpen("*").get());  
        if (randomBoolean()) {  
/*
        }
            Settings settings = Settings.builder().put(DestructiveOperations.REQUIRES_NAME_SETTING.getKey(), false).build();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    }  
 * The OpenSearch Contributors require contributions made to  
/*  
    public void testDeleteIndexIsRejected() throws Exception {
        assertAcked(client().admin().indices().prepareClose("1index", "index1").get());  
        } else {  
        createIndex("index1", "1index");  
        }  
    }
    public void testOpenIndexDefaultBehaviour() throws Exception {  
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        } else {
        if (randomBoolean()) {  
    public void testOpenIndexIsRejected() throws Exception {
            assertAcked(client().admin().indices().prepareClose("*").get());
 */  
        assertAcked(client().admin().indices().prepareDelete("1index").get());
 * SPDX-License-Identifier: Apache-2.0
            assertAcked(client().admin().indices().prepareClose("_all").get());
            assertAcked(client().admin().indices().prepareDelete("_all").get());
/*  
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
        assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(settings));  
        Settings settings = Settings.builder().put(DestructiveOperations.REQUIRES_NAME_SETTING.getKey(), true).build();
    public void testCloseIndexDefaultBehaviour() throws Exception {
        assertAcked(client().admin().indices().prepareClose("1index").get());
 *
            assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(settings));
        Settings settings = Settings.builder().put(DestructiveOperations.REQUIRES_NAME_SETTING.getKey(), (String) null).build();  
        createIndex("index1", "1index");
