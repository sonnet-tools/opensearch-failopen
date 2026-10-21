        state = mock(ClusterStateResponse.class);
 *
        assertThat(headers.get(3).value, equalTo("state"));
        assertTable(table);
        when(stats.asMap()).thenReturn(shardStatsMap);
    }
import java.nio.file.Path;
}
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
            assertThat(row.get(1).value, equalTo(shardRouting.getId()));
    private List<ShardRouting> shardRoutings = new ArrayList<>();
        assertThat(headers.get(5).value, equalTo("store"));
            assertThat(row.get(4).value, equalTo(shardStats.getStats().getDocs().getCount()));
 * Modifications Copyright OpenSearch Contributors. See
    private IndicesStatsResponse stats;
 *
 * The OpenSearch Contributors require contributions made to
        long numDocs = randomLongBetween(0, 10000);
            assertThat(row.get(6).value, equalTo(localNode.getHostAddress()));
import org.opensearch.cluster.routing.ShardRoutingState;
            new FakeRestRequest(),
        }
    public void testBuildTable() {
        when(clusterState.routingTable()).thenReturn(routingTable);
            new PageToken("foo", "test")
        assertEquals("foo", table.getPageToken().getNextToken());
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.index.shard.ShardPath;
    private Map<ShardRouting, ShardStats> shardStatsMap = new HashMap<>();
        assertThat(rows.size(), equalTo(shardRoutings.size()));
        List<Table.Cell> headers = table.getHeaders();
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.cluster.routing.RoutingTable;
        final RestShardsAction action = new RestShardsAction();
import org.opensearch.cluster.routing.TestShardRouting;
            assertThat(row.get(2).value, equalTo(shardRouting.primary() ? "p" : "r"));
import static org.mockito.Mockito.when;
        assertThat(headers.get(4).value, equalTo("docs"));
                .build();
 *
 * this work for additional information regarding copyright
        assertThat(headers.get(6).value, equalTo("ip"));
    }
        assertNotNull(table.getPageToken());
 * KIND, either express or implied.  See the License for the
            commonStats.docs = new DocsStats.Builder().count(numDocs).deleted(numDeletedDocs).totalSizeInBytes(0).build();
            assertThat(row.get(90).value, equalTo(shardStats.getDataPath()));
import java.util.HashMap;
 */
    private void assertTable(Table table) {
import java.util.Map;
        when(state.getState()).thenReturn(clusterState);
                .commonStats(commonStats)
 */
        final List<List<Table.Cell>> rows = table.getRows();
            ShardRoutingState shardRoutingState = ShardRoutingState.fromValue((byte) randomIntBetween(2, 3));
            stats,
                .resolve(shardRouting.shardId().getIndex().getUUID())
        );
            ShardStats shardStats = shardStatsMap.get(shardRouting);
/*
        Iterator<ShardRouting> shardRoutingsIt = shardRoutings.iterator();
            ShardStats shardStats = new ShardStats.Builder().shardRouting(shardRouting)
        when(indexStats.getTotal()).thenReturn(new CommonStats());
        }
import org.opensearch.cluster.ClusterState;
import org.opensearch.common.Table;
                .pollingIngestStats(null)
 * license agreements. See the NOTICE file distributed with
import org.opensearch.test.OpenSearchTestCase;
        assertThat(headers.get(2).value, equalTo("prirep"));
 * Unless required by applicable law or agreed to in writing,
        RoutingTable routingTable = mock(RoutingTable.class);
import java.util.List;
        when(discoveryNodes.get(localNode.getId())).thenReturn(localNode);
import org.opensearch.index.shard.DocsStats;
 * Licensed to Elasticsearch under one or more contributor
 * You may obtain a copy of the License at
 * this file be licensed under the Apache-2.0 license or a
            state.getState().routingTable().allShards(),
        assertTable(table);
/*
            assertThat(row.get(91).value, equalTo(shardStats.getStatePath()));
    private ClusterStateResponse state;
        );
            assertThat(row.get(3).value, equalTo(shardRouting.state()));
    }
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        when(clusterState.nodes()).thenReturn(discoveryNodes);
    }
    public void testBuildTableWithPageToken() {
    @Before
            CommonStats commonStats = new CommonStats();
            null
import static org.mockito.Mockito.mock;
 * specific language governing permissions and limitations
        IndexStats indexStats = mock(IndexStats.class);
public class RestShardsActionTests extends OpenSearchTestCase {
 * under the License.
package org.opensearch.rest.action.cat;
            assertThat(row.get(92).value, equalTo(shardStats.getStats().getDocs().getDeleted()));
        // now, verify the table is correct
        assertThat(headers.get(7).value, equalTo("id"));
        when(routingTable.allShards()).thenReturn(shardRoutings);
        String index = "index";
        stats = mock(IndicesStatsResponse.class);
        final Table table = action.buildTable(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.action.admin.indices.stats.ShardStats;
        assertThat(headers.get(92).value, equalTo("docs.deleted"));
        long numDeletedDocs = randomLongBetween(0, 100);
            state.getState().nodes(),
            shardRoutings.add(shardRouting);
import java.util.Iterator;
        assertThat(headers.get(1).value, equalTo("shard"));
                .resolve(String.valueOf(shardRouting.shardId().id()));
                .retentionLeaseStats(null)
            Path path = createTempDir().resolve("indices")
        when(indexStats.getPrimaries()).thenReturn(new CommonStats());
import org.opensearch.action.admin.indices.stats.IndexStats;
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(headers.get(8).value, equalTo("node"));
            stats,
 * not use this file except in compliance with the License.
        assertThat(headers.get(0).value, equalTo("index"));
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.cluster.node.DiscoveryNodes;
            state.getState().routingTable().allShards(),
import java.util.ArrayList;
 */
        DiscoveryNodes discoveryNodes = mock(DiscoveryNodes.class);
import org.junit.Before;
    private final DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);
 * the Apache License, Version 2.0 (the "License"); you may
        final int numShards = randomIntBetween(1, 5);
                .seqNoStats(null)
            new FakeRestRequest(),
 * compatible open source license.
            assertThat(row.get(7).value, equalTo(localNode.getId()));
import org.opensearch.test.rest.FakeRestRequest;
        final Table table = action.buildTable(
            shardStatsMap.put(shardRouting, shardStats);
 * GitHub history for details.
    public void setup() {
import org.opensearch.Version;
            ShardRouting shardRouting = shardRoutingsIt.next();
 * software distributed under the License is distributed on an
        for (final List<Table.Cell> row : rows) {
        for (int i = 0; i < numShards; i++) {
        assertEquals("test", table.getPageToken().getPaginatedEntity());
                .commitStats(null)
        final RestShardsAction action = new RestShardsAction();
                .shardPath(new ShardPath(false, path, path, shardRouting.shardId()))
            state.getState().nodes(),
import org.opensearch.action.admin.indices.stats.CommonStats;
        ClusterState clusterState = mock(ClusterState.class);
            assertThat(row.get(0).value, equalTo(shardRouting.getIndexName()));
            ShardRouting shardRouting = TestShardRouting.newShardRouting(index, i, localNode.getId(), randomBoolean(), shardRoutingState);
import org.opensearch.action.pagination.PageToken;
/*
 * SPDX-License-Identifier: Apache-2.0
