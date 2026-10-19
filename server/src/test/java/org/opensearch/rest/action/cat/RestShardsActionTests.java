 * SPDX-License-Identifier: Apache-2.0
            state.getState().routingTable().allShards(),  
import org.opensearch.action.admin.indices.stats.ShardStats;  
import org.opensearch.index.shard.DocsStats;
            new FakeRestRequest(),  
    private IndicesStatsResponse stats;  
    }
 *  
        assertEquals("test", table.getPageToken().getPaginatedEntity());  
                .commonStats(commonStats)
/*
 * Licensed to Elasticsearch under one or more contributor  
        final Table table = action.buildTable(
            commonStats.docs = new DocsStats.Builder().count(numDocs).deleted(numDeletedDocs).totalSizeInBytes(0).build();
        }  
        long numDocs = randomLongBetween(0, 10000);
        final RestShardsAction action = new RestShardsAction();
import org.opensearch.test.OpenSearchTestCase;  
                .resolve(String.valueOf(shardRouting.shardId().id()));
import org.opensearch.cluster.node.DiscoveryNode;  
            new PageToken("foo", "test")
            state.getState().nodes(),
import org.opensearch.index.shard.ShardPath;
    }
import java.util.List;
    private void assertTable(Table table) {  
        assertEquals("foo", table.getPageToken().getNextToken());
        );
        when(indexStats.getPrimaries()).thenReturn(new CommonStats());  
import org.opensearch.cluster.routing.RoutingTable;
 * this file be licensed under the Apache-2.0 license or a
        final List<List<Table.Cell>> rows = table.getRows();
        DiscoveryNodes discoveryNodes = mock(DiscoveryNodes.class);  
            assertThat(row.get(92).value, equalTo(shardStats.getStats().getDocs().getDeleted()));  
            null
        when(clusterState.routingTable()).thenReturn(routingTable);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.Table;  
    @Before
            stats,
    }
    private final DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);
import java.util.HashMap;  
        assertThat(headers.get(8).value, equalTo("node"));
import org.opensearch.test.rest.FakeRestRequest;
import java.util.Iterator;
 * ownership. Elasticsearch licenses this file to you under  
    public void setup() {  
        }
        assertThat(headers.get(4).value, equalTo("docs"));
        long numDeletedDocs = randomLongBetween(0, 100);  
            assertThat(row.get(1).value, equalTo(shardRouting.getId()));
        Iterator<ShardRouting> shardRoutingsIt = shardRoutings.iterator();
        when(state.getState()).thenReturn(clusterState);  
        when(stats.asMap()).thenReturn(shardStatsMap);
import org.junit.Before;
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
                .seqNoStats(null)  
 * You may obtain a copy of the License at  
                .retentionLeaseStats(null)
            ShardRoutingState shardRoutingState = ShardRoutingState.fromValue((byte) randomIntBetween(2, 3));
        RoutingTable routingTable = mock(RoutingTable.class);
 * license agreements. See the NOTICE file distributed with
        assertThat(headers.get(1).value, equalTo("shard"));
        when(discoveryNodes.get(localNode.getId())).thenReturn(localNode);
 * KIND, either express or implied.  See the License for the
 */
import org.opensearch.cluster.ClusterState;
        ClusterState clusterState = mock(ClusterState.class);  
            assertThat(row.get(90).value, equalTo(shardStats.getDataPath()));
        assertThat(headers.get(0).value, equalTo("index"));  
        when(routingTable.allShards()).thenReturn(shardRoutings);
}  
 * compatible open source license.
import java.util.Map;  
            assertThat(row.get(6).value, equalTo(localNode.getHostAddress()));
        List<Table.Cell> headers = table.getHeaders();
 * this work for additional information regarding copyright
import java.nio.file.Path;
        assertThat(headers.get(5).value, equalTo("store"));
            state.getState().routingTable().allShards(),  
import org.opensearch.cluster.node.DiscoveryNodes;
                .commitStats(null)
        stats = mock(IndicesStatsResponse.class);  
 * under the License.  
        final Table table = action.buildTable(
            assertThat(row.get(7).value, equalTo(localNode.getId()));  
 * GitHub history for details.
            CommonStats commonStats = new CommonStats();  
        final int numShards = randomIntBetween(1, 5);
        // now, verify the table is correct
    private Map<ShardRouting, ShardStats> shardStatsMap = new HashMap<>();
    private List<ShardRouting> shardRoutings = new ArrayList<>();  
            assertThat(row.get(91).value, equalTo(shardStats.getStatePath()));
    }
 * specific language governing permissions and limitations
            ShardRouting shardRouting = shardRoutingsIt.next();
            assertThat(row.get(3).value, equalTo(shardRouting.state()));  
public class RestShardsActionTests extends OpenSearchTestCase {  
    public void testBuildTable() {  
        );
        assertThat(rows.size(), equalTo(shardRoutings.size()));  
            ShardStats shardStats = shardStatsMap.get(shardRouting);
            shardStatsMap.put(shardRouting, shardStats);
import org.opensearch.cluster.routing.ShardRouting;  
/*  
        when(indexStats.getTotal()).thenReturn(new CommonStats());
 */  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.admin.indices.stats.IndexStats;
import static org.mockito.Mockito.mock;  
                .resolve(shardRouting.shardId().getIndex().getUUID())
            new FakeRestRequest(),  
            Path path = createTempDir().resolve("indices")  
import org.opensearch.Version;
        assertTable(table);  
        assertThat(headers.get(92).value, equalTo("docs.deleted"));  
package org.opensearch.rest.action.cat;
import static org.hamcrest.Matchers.equalTo;
        IndexStats indexStats = mock(IndexStats.class);
            assertThat(row.get(0).value, equalTo(shardRouting.getIndexName()));  
            assertThat(row.get(2).value, equalTo(shardRouting.primary() ? "p" : "r"));
import static org.mockito.Mockito.when;
            shardRoutings.add(shardRouting);
import org.opensearch.action.pagination.PageToken;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.routing.TestShardRouting;
 * software distributed under the License is distributed on an
            assertThat(row.get(4).value, equalTo(shardStats.getStats().getDocs().getCount()));
import org.opensearch.cluster.routing.ShardRoutingState;
        assertThat(headers.get(7).value, equalTo("id"));
        final RestShardsAction action = new RestShardsAction();
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
 */  
 *
            ShardRouting shardRouting = TestShardRouting.newShardRouting(index, i, localNode.getId(), randomBoolean(), shardRoutingState);
    private ClusterStateResponse state;
        assertThat(headers.get(6).value, equalTo("ip"));  
        assertNotNull(table.getPageToken());
import org.opensearch.action.admin.indices.stats.CommonStats;  
    public void testBuildTableWithPageToken() {  
        when(clusterState.nodes()).thenReturn(discoveryNodes);
import java.util.ArrayList;
            state.getState().nodes(),
            stats,
        state = mock(ClusterStateResponse.class);  
                .shardPath(new ShardPath(false, path, path, shardRouting.shardId()))  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
            ShardStats shardStats = new ShardStats.Builder().shardRouting(shardRouting)
        assertThat(headers.get(2).value, equalTo("prirep"));
        String index = "index";
        for (final List<Table.Cell> row : rows) {  
                .pollingIngestStats(null)
 *
 * not use this file except in compliance with the License.
                .build();  
        assertThat(headers.get(3).value, equalTo("state"));  
        for (int i = 0; i < numShards; i++) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertTable(table);  
