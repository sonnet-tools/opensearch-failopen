            }
                Settings.builder()
        switch (nodeOrdinal % 2) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
                Settings.builder()
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;
        assertThat(response.getGroups().length, equalTo(4));
        }
            .actionGet();
            .setSettings(Settings.builder().put("index.number_of_shards", "4").put("index.number_of_replicas", 1))
        NumShards numShards = getNumShards("test-blocks");
    public void testClusterSearchShardsWithBlocks() {
            } else {
                seenTest2 = true;
 */
        assertThat(response.getGroups()[1].getShards().length, equalTo(2));
 * The OpenSearch Contributors require contributions made to
        assertThat(response.getGroups()[0].getShards()[0].currentNodeId(), equalTo(response.getNodes()[0].getId()));
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().execute().actionGet();
/*
            client().prepareIndex("test-blocks").setId("" + i).setSource("test", "init").execute().actionGet();
import org.opensearch.test.OpenSearchIntegTestCase;
 */
        try {
                    .put("index.number_of_replicas", 0)
            .execute()
        assertThat(seenTest1, equalTo(true));
            } else if (group.getShardId().getIndexName().equals("test2")) {
package org.opensearch.cluster.shards;
        }
    }
        client().admin()
                    .put("index.number_of_replicas", 0)
            .prepareAliases()
        assertThat(seenTest2, equalTo(true));
        boolean seenTest1 = false;
                assertThat(response.getGroups().length, equalTo(numShards.numPrimaries));
        ensureGreen();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_METADATA;
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
import org.opensearch.common.Priority;
                    .put("index.routing.allocation.include.tag", "A")
}
                    .put("index.routing.allocation.include.tag", "A")
        assertThat(response.getGroups()[0].getShards().length, equalTo(1));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_WRITE;
        response = client().admin().cluster().prepareSearchShards("test").setRouting("A").execute().actionGet();
        ClusterSearchShardsResponse response = client().admin().cluster().prepareSearchShards("test").execute().actionGet();
            .indices()
                return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put("node.attr.tag", "A").build();
        assertThat(response.getGroups().length, equalTo(1));
 * software distributed under the License is distributed on an
                seenTest1 = true;
 */
        client().admin()
 * not use this file except in compliance with the License.
        assertThat(response.getGroups()[0].getShards()[0].currentNodeId(), equalTo(response.getNodes()[0].getId()));
            assertBlocked(client().admin().cluster().prepareSearchShards("test-blocks"));
            .indices()
 * compatible open source license.
            try {
    protected Settings nodeSettings(int nodeOrdinal) {
        ClusterSearchShardsResponse response = client().admin().cluster().prepareSearchShards("test").execute().actionGet();
/*
        assertThat(response.getGroups()[0].getShardId().getId(), equalTo(0));
        response = client().admin().cluster().prepareSearchShards("test").setPreference("_shards:2").execute().actionGet();
            .setSettings(
        createIndex("test-blocks");
 *
        assertThat(response.getGroups()[0].getShardId().getIndexName(), equalTo("test"));
    }
            }
        for (String blockSetting : Arrays.asList(
    public void testMultipleShardsSingleNodeAllocation() throws Exception {
 * license agreements. See the NOTICE file distributed with
            .execute()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            SETTING_BLOCKS_READ,
 * Licensed to Elasticsearch under one or more contributor
        client().admin()
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
            .prepareCreate("test")
                assertThat(group.getShards().length, equalTo(2));
@ClusterScope(scope = Scope.SUITE, numDataNodes = 2)
            disableIndexBlock("test-blocks", SETTING_BLOCKS_METADATA);
            .setSettings(Settings.builder().put("index.number_of_shards", "4").put("index.number_of_replicas", 1))
        client().admin()
/*
 * this work for additional information regarding copyright
            .prepareCreate("test")
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_READ;
 * ownership. Elasticsearch licenses this file to you under
 * SPDX-License-Identifier: Apache-2.0
            .addAliasAction(AliasActions.add().index("test1").alias("routing_alias").routing("ABC"))
            .prepareCreate("test1")
            .actionGet();
            .setSettings(
            enableIndexBlock("test-blocks", SETTING_BLOCKS_METADATA);
            SETTING_BLOCKS_WRITE,
        for (int i = 0; i < docs; i++) {
            case 1:
                    .put("index.number_of_shards", "1")
            .addAliasAction(AliasActions.add().index("test2").alias("routing_alias").routing("EFG"))
import java.util.Arrays;
            .prepareCreate("test2")
                ClusterSearchShardsResponse response = client().admin().cluster().prepareSearchShards("test-blocks").execute().actionGet();
 * KIND, either express or implied.  See the License for the
            .indices()
        assertThat(response.getNodes().length, equalTo(1));
        assertThat(response.getNodes().length, equalTo(2));
        assertThat(response.getNodes().length, equalTo(1));
        assertThat(response.getGroups()[0].getShardId().getId(), equalTo(0));
        assertThat(response.getGroups()[0].getShards()[0].currentNodeId(), equalTo(response.getNodes()[0].getId()));
            SETTING_READ_ONLY,
    }
            case 0:
            .indices()
        ensureGreen("test-blocks");
            .actionGet();
        assertThat(response.getGroups().length, equalTo(2));
        assertThat(response.getNodes().length, equalTo(1));
        assertThat(response.getGroups().length, equalTo(1));
        )) {
        assertThat(response.getGroups()[0].getShards().length, equalTo(2));
            if (group.getShardId().getIndexName().equals("test1")) {
    @Override
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
            )
            .get();
    }
    }
 * Modifications Copyright OpenSearch Contributors. See
        for (ClusterSearchShardsGroup group : response.getGroups()) {
        assertThat(response.getGroups().length, equalTo(1));
        assertThat(response.getGroups()[0].getShardId().getId(), equalTo(2));
                return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put("node.attr.tag", "B").build();
    public void testSingleShardAllocation() throws Exception {
        response = client().admin().cluster().prepareSearchShards("test").setRouting("ABC").execute().actionGet();
            )
 * under the License.
            .execute()
 * this file be licensed under the Apache-2.0 license or a
        int docs = between(10, 100);
        }
        } finally {
 *
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsGroup;
                fail();
        assertThat(response.getGroups()[0].getShards().length, equalTo(1));
        client().admin()
                assertThat(group.getShards().length, equalTo(2));
                    .put("index.number_of_shards", "4")
        boolean seenTest2 = false;
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest.AliasActions;
        }
            .execute()
 *    http://www.apache.org/licenses/LICENSE-2.0
            SETTING_READ_ONLY_ALLOW_DELETE
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE;
 * specific language governing permissions and limitations
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsResponse;
        // Request is blocked
        }
public class ClusterSearchShardsIT extends OpenSearchIntegTestCase {
        assertThat(response.getGroups().length, equalTo(1));
 * You may obtain a copy of the License at
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.settings.Settings;
    public void testMultipleIndicesAllocation() throws Exception {
        assertThat(response.getGroups()[0].getShardId().getIndexName(), equalTo("test"));
 *
            .actionGet();
        // Request is not blocked
            } finally {
        ensureGreen();
                disableIndexBlock("test-blocks", blockSetting);
                enableIndexBlock("test-blocks", blockSetting);
        assertThat(response.getGroups()[0].getShardId().getIndexName(), equalTo("test"));
        ClusterSearchShardsResponse response = client().admin().cluster().prepareSearchShards("routing_alias").execute().actionGet();
        return super.nodeSettings(nodeOrdinal);
import static org.hamcrest.Matchers.equalTo;
            .indices()
