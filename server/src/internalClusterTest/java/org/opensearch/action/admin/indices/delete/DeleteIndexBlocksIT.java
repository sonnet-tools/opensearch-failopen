            assertAcked(client().admin().indices().prepareDelete("test"));  
        } finally {
                Metadata.CLUSTER_READ_ONLY_ALLOW_DELETE_BLOCK
        } finally {
            assertBlocked(client().admin().indices().prepareDelete("test"), Metadata.CLUSTER_READ_ONLY_BLOCK);  
            Settings settings = Settings.builder().put(IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE, true).build();  
 * this work for additional information regarding copyright
            );  
        }  
import org.opensearch.cluster.block.ClusterBlockException;
                e.getMessage()  
            assertAcked(client().admin().indices().prepareDelete("test"));
            assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(settings).get());
            );  
 * The OpenSearch Contributors require contributions made to  
                    .prepareUpdateSettings("test")  
 * specific language governing permissions and limitations
        } finally {
 * not use this file except in compliance with the License.
                "index [test] blocked by: [TOO_MANY_REQUESTS/12/disk usage exceeded flood-stage watermark, "
                    .setSettings(settings)
            );
            setClusterReadOnly(false);
                ClusterBlockException.class,  
            Settings settings = Settings.builder().putNull(IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE).build();
    }  
            createIndex("test");
 *  
/*  
 * license agreements. See the NOTICE file distributed with
    public void testDeleteIndexWithBlocks() {
                client().admin().indices().prepareUpdateSettings("test").setSettings(Settings.builder().put("index.number_of_replicas", 2)),
            Settings settings = Settings.builder().putNull(Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING.getKey()).build();  
                    .setIndicesOptions(IndicesOptions.lenientExpandOpen())
    }  
            );
                    .get()
    public void testDeleteIndexOnIndexReadOnlyAllowDeleteSetting() {  
        try {  
 * this file be licensed under the Apache-2.0 license or a
            assertBlocked(
import org.opensearch.action.support.IndicesOptions;
                    .get()  
 * SPDX-License-Identifier: Apache-2.0
                    .indices()
    public void testDeleteIndexOnClusterReadOnlyAllowDeleteSetting() {
        createIndex("test");
        try {
            assertAcked(client().admin().indices().prepareUpdateSettings("test").setSettings(settings).get());
 *
            assertAcked(  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
/*
 */  
            assertBlocked(
        }
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.cluster.metadata.Metadata;
        try {
        } finally {
/*  
        ensureGreen("test");
            assertBlocked(
                client().prepareIndex().setIndex("test").setId("2").setSource("foo", "bar"),
        createIndex("test");
            setClusterReadOnly(true);
    }
            assertSearchHits(client().prepareSearch().get(), "1");  
 */
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
            assertSearchHits(client().prepareSearch().get(), "1");  
                    .prepareUpdateSettings("test")  
        }
package org.opensearch.action.admin.indices.delete;
        client().prepareIndex().setIndex("test").setId("1").setSource("foo", "bar").get();
 * Licensed to Elasticsearch under one or more contributor  
                () -> client().prepareIndex().setIndex("test").setId("1").setSource("foo", "bar").get()
 *    http://www.apache.org/licenses/LICENSE-2.0
                IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK  
 * compatible open source license.
                client().admin()
                client().prepareIndex().setIndex("test").setId("2").setSource("foo", "bar"),
            );
                    .setSettings(Settings.builder().putNull(IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE).build())
 *
                Metadata.CLUSTER_READ_ONLY_ALLOW_DELETE_BLOCK  
            ClusterBlockException e = expectThrows(
        client().prepareIndex().setIndex("test").setId("1").setSource("foo", "bar").get();  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;  
 * You may obtain a copy of the License at  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
}
            );
                    .indices()
            );
            assertEquals(  
            ensureGreen("test");
    }
    public void testClusterBlockMessageHasIndexName() {
import org.opensearch.cluster.metadata.IndexMetadata;  
        try {  
 * software distributed under the License is distributed on an
                client().admin()
 * Unless required by applicable law or agreed to in writing,
        }
            Settings settings = Settings.builder().put(Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING.getKey(), true).build();
 * KIND, either express or implied.  See the License for the
                IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK
        ensureGreen("test");  
        refresh();
            );
            assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(settings).get());
            assertSearchHits(client().prepareSearch().get(), "1");
        ensureGreen("test");  
 * GitHub history for details.
        createIndex("test");
import org.opensearch.common.settings.Settings;
                client().admin().indices().prepareUpdateSettings("test").setSettings(Settings.builder().put("index.number_of_replicas", 2)),  
            assertBlocked(  
import org.opensearch.test.OpenSearchIntegTestCase;  
public class DeleteIndexBlocksIT extends OpenSearchIntegTestCase {  
            assertSearchHits(client().prepareSearch().get(), "1");
 * Modifications Copyright OpenSearch Contributors. See
            client().admin().indices().prepareUpdateSettings("test").setSettings(settings).get();
                    + "index has read-only-allow-delete block];",
        refresh();
            assertAcked(  
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            Settings settings = Settings.builder().put(IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE, true).build();  
