                    .put("index.routing.allocation.include.tag", "A")
@ClusterScope(scope = Scope.SUITE, numDataNodes = 2)
            case 0:  
import java.util.Arrays;  
        }  
            .prepareCreate("test1")
            .execute()
            .execute()
        NumShards numShards = getNumShards("test-blocks");  
        ensureGreen();
                assertThat(response.getGroups().length, equalTo(numShards.numPrimaries));  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_METADATA;
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.common.settings.Settings;
        assertThat(response.getGroups()[0].getShardId().getId(), equalTo(0));
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE;  
 * Unless required by applicable law or agreed to in writing,
        int docs = between(10, 100);
 * under the License.  
            }  
        assertThat(response.getGroups().length, equalTo(1));
            .setSettings(Settings.builder().put("index.number_of_shards", "4").put("index.number_of_replicas", 1))  
 *
 *
        ClusterSearchShardsResponse response = client().admin().cluster().prepareSearchShards("test").execute().actionGet();
 * You may obtain a copy of the License at  
            .prepareAliases()
            .indices()
        for (int i = 0; i < docs; i++) {  
            .indices()
                    .put("index.number_of_shards", "4")
        assertThat(response.getNodes().length, equalTo(1));  
        ClusterSearchShardsResponse response = client().admin().cluster().prepareSearchShards("routing_alias").execute().actionGet();
 * ownership. Elasticsearch licenses this file to you under  
        }  
        assertThat(response.getGroups()[0].getShards().length, equalTo(2));
        for (ClusterSearchShardsGroup group : response.getGroups()) {
        assertThat(response.getGroups()[0].getShards().length, equalTo(1));
        assertThat(response.getGroups()[0].getShardId().getIndexName(), equalTo("test"));
        assertThat(response.getGroups()[0].getShards()[0].currentNodeId(), equalTo(response.getNodes()[0].getId()));
        assertThat(response.getGroups().length, equalTo(1));
        // Request is not blocked
 * the Apache License, Version 2.0 (the "License"); you may
    }  
            )
        ensureGreen();  
            } finally {
    @Override
            .addAliasAction(AliasActions.add().index("test1").alias("routing_alias").routing("ABC"))  
        assertThat(response.getGroups()[0].getShardId().getIndexName(), equalTo("test"));
 * specific language governing permissions and limitations
                seenTest1 = true;
            .indices()  
        assertThat(response.getGroups().length, equalTo(1));
 * license agreements. See the NOTICE file distributed with
                    .put("index.number_of_replicas", 0)
 */
    }
                    .put("index.number_of_replicas", 0)
    public void testMultipleIndicesAllocation() throws Exception {
            .indices()
            if (group.getShardId().getIndexName().equals("test1")) {  
        assertThat(response.getGroups()[0].getShards().length, equalTo(1));
                assertThat(group.getShards().length, equalTo(2));
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest.AliasActions;
 */
        assertThat(response.getNodes().length, equalTo(1));  
        client().admin()  
/*
        boolean seenTest2 = false;
        assertThat(seenTest2, equalTo(true));
            .indices()
            .execute()
            .actionGet();
            case 1:
        assertThat(response.getNodes().length, equalTo(1));
        )) {
 * GitHub history for details.
public class ClusterSearchShardsIT extends OpenSearchIntegTestCase {
            .get();
        createIndex("test-blocks");
                assertThat(group.getShards().length, equalTo(2));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;
        }
    protected Settings nodeSettings(int nodeOrdinal) {
 * Licensed to Elasticsearch under one or more contributor  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
            disableIndexBlock("test-blocks", SETTING_BLOCKS_METADATA);
 * KIND, either express or implied.  See the License for the
            SETTING_BLOCKS_READ,
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_WRITE;
        client().admin()
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;  
 * not use this file except in compliance with the License.
            enableIndexBlock("test-blocks", SETTING_BLOCKS_METADATA);
                ClusterSearchShardsResponse response = client().admin().cluster().prepareSearchShards("test-blocks").execute().actionGet();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        boolean seenTest1 = false;  
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().execute().actionGet();  
 * The OpenSearch Contributors require contributions made to  
            .actionGet();
        assertThat(response.getNodes().length, equalTo(2));  
            .setSettings(
 * software distributed under the License is distributed on an
        try {
            SETTING_READ_ONLY_ALLOW_DELETE
            .setSettings(Settings.builder().put("index.number_of_shards", "4").put("index.number_of_replicas", 1))  
    public void testMultipleShardsSingleNodeAllocation() throws Exception {
    }
                disableIndexBlock("test-blocks", blockSetting);
        return super.nodeSettings(nodeOrdinal);  
        assertThat(response.getGroups()[0].getShardId().getId(), equalTo(0));  
        client().admin()  
        ensureGreen("test-blocks");  
    public void testSingleShardAllocation() throws Exception {  
        assertThat(response.getGroups()[0].getShards()[0].currentNodeId(), equalTo(response.getNodes()[0].getId()));
 * SPDX-License-Identifier: Apache-2.0
                return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put("node.attr.tag", "B").build();
    }
        client().admin()  
            .prepareCreate("test")
                    .put("index.routing.allocation.include.tag", "A")  
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsResponse;
package org.opensearch.cluster.shards;
            .setSettings(
            .addAliasAction(AliasActions.add().index("test2").alias("routing_alias").routing("EFG"))
        assertThat(response.getGroups().length, equalTo(2));  
        // Request is blocked  
        assertThat(response.getGroups().length, equalTo(1));
/*
        assertThat(response.getGroups()[0].getShardId().getIndexName(), equalTo("test"));  
 * compatible open source license.
            }
                return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put("node.attr.tag", "A").build();
            } else {  
        response = client().admin().cluster().prepareSearchShards("test").setRouting("ABC").execute().actionGet();  
                fail();
            assertBlocked(client().admin().cluster().prepareSearchShards("test-blocks"));  
            } else if (group.getShardId().getIndexName().equals("test2")) {  
}
                enableIndexBlock("test-blocks", blockSetting);
        assertThat(response.getGroups()[1].getShards().length, equalTo(2));
            try {  
            SETTING_READ_ONLY,  
                Settings.builder()  
 * this file be licensed under the Apache-2.0 license or a
            )  
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsGroup;  
            .execute()
                Settings.builder()
        switch (nodeOrdinal % 2) {  
            .actionGet();  
        assertThat(response.getGroups()[0].getShardId().getId(), equalTo(2));
            .prepareCreate("test")  
 *  
 * Modifications Copyright OpenSearch Contributors. See  
        assertThat(seenTest1, equalTo(true));
        response = client().admin().cluster().prepareSearchShards("test").setRouting("A").execute().actionGet();  
            SETTING_BLOCKS_WRITE,
            client().prepareIndex("test-blocks").setId("" + i).setSource("test", "init").execute().actionGet();
/*  
        }
            .prepareCreate("test2")
            .actionGet();
    }
    public void testClusterSearchShardsWithBlocks() {  
        response = client().admin().cluster().prepareSearchShards("test").setPreference("_shards:2").execute().actionGet();  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_READ;  
                    .put("index.number_of_shards", "1")  
 */  
 * this work for additional information regarding copyright
import org.opensearch.common.Priority;  
        ClusterSearchShardsResponse response = client().admin().cluster().prepareSearchShards("test").execute().actionGet();  
        }
                seenTest2 = true;
        } finally {
        client().admin()
        assertThat(response.getGroups()[0].getShards()[0].currentNodeId(), equalTo(response.getNodes()[0].getId()));  
        for (String blockSetting : Arrays.asList(  
        assertThat(response.getGroups().length, equalTo(4));
