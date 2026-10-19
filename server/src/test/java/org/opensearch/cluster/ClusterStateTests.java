                                        "nodeId2",  
                + "    }\n"
            .nodes(
                                            put("type", new HashMap<String, Object>() {  
                + "            {\n"
                + allocationId
                Metadata.builder()
                + "    \"nodes\" : { }\n"  
                + "        }\n"
            )  
                + "      \"term\" : 0,\n"
import org.opensearch.core.rest.RestStatus;
        final DiscoveryNodes nodes = DiscoveryNodes.builder().add(node1).add(node2).build();
                + "        \"index_patterns\" : [\n"
                + "            }\n"
                + "        \"aliases_version\" : 1,\n"
            .primaryTerm(0, 1L)
                + "          }\n"
                put(Metadata.CONTEXT_MODE_PARAM, Metadata.CONTEXT_MODE_API);
                + "        \"order\" : 0,\n"
                + "        \"version\" : 1,\n"
                + "        \"split_shards_metadata\" : {\n"
                + "      \"attributes\" : { }\n"
                + "        \"primary_terms\" : {\n"
            .build();  
                + "        \"rollover_info\" : {\n"
                + "          \"metadata_write\",\n"  
                + "        \"system\" : false,\n"
                + "          \"searchOnly\" : false,\n"  
                + "          }\n"  
 *     http://www.apache.org/licenses/LICENSE-2.0
                + "}",  
                + "          \"is_paused\" : false\n"
                            }))
 */
                + "            \"metadata_write\",\n"  
        builder.endObject();
                + "            }\n"
    public static class CustomMetadata extends TestCustomMetadata {
                                    "type",
                            "description2",
                + "          ],\n"  
                + "          \"pattern1\",\n"  
                + "  \"metadata\" : {\n"
                + "          \"index\" : {\n"  
                + "            \"write\",\n"
                + "        }\n"
                + "          \"read\",\n"
        final String key = randomAlphaOfLength(10);  
                + "            0\n"  
import org.opensearch.test.OpenSearchTestCase;
        ClusterState withClusterManager2 = ClusterState.builder(name)
                + "        \"split_shards_metadata\" : {\n"
                + "              \"created\" : \""
    }
                + "      \"tombstones\" : [ ]\n"
                + "  \"cluster_uuid\" : \"clusterUUID\",\n"
                + "              }\n"
                + "          \"node_id\" : \"exlucdedNodeId\",\n"
                + "            \"time\" : 1\n"
                            false,
                + "            \"number_of_shards\" : \"1\",\n"
                + "        \"in_sync_allocations\" : {\n"
        mapBuilder.put(key, null);
                            }))  
                + "          }\n"  
                + "      }\n"  
                + "    },\n"
                + "        \"commitedConfigurationNodeId\"\n"
            })  
                + "        {\n"
                + "    },\n"
                + "      \"name\" : \"\",\n"  
                + "  },\n"
                + "        \"settings\" : {\n"
        IndexMetadata indexMetadata = IndexMetadata.builder("index")
                + "          \"state\" : \"STARTED\",\n"
                + "        \"primary_terms\" : {\n"
                + "    \"cluster_uuid\" : \"clusterUUID\",\n"  
                + "      \"last_committed_config\" : [\n"  
                + "            \"create_index\"\n"
                + "                \"id\" : \""
                + "        \"primary_terms_map\" : {\n"
                + "            0\n"
        @Override
                + "            0\n"  
                + "      \"last_accepted_config\" : [\n"
                + "          ]\n"  
            {  
                + "            \"id\" : \""  
                + "          ]\n"
                + "      ],\n"  
                + "            \"write\",\n"  
        builder.endObject();
                + "  \"metadata\" : {\n"  
        );
                + "          \"metadata_read\",\n"
                                {
                            )
                + "\"\n"  
                + "      \"index\" : {\n"
            .version(randomInt(5))
            .state(IndexMetadata.State.OPEN)  
                + "          \"metadata_write\",\n"
            .nodes(DiscoveryNodes.builder(nodes).clusterManagerNodeId(node2.getId()))
        String ephemeralId = clusterState.getNodes().get("nodeId1").getEphemeralId();
                + "  \"cluster_uuid\" : \"clusterUUID\",\n"
                + "              \"searchOnly\" : false,\n"
                + "    }\n"  
                + "    \"indices\" : { }\n"
                + "      \"1\" : {\n"
                + "      \"ephemeral_id\" : \""  
                        IndexMetadata.builder("index")
                + Version.CURRENT.id
                + Version.CURRENT.id
                    .coordinationMetadata(CoordinationMetadata.builder().build())  
import org.opensearch.cluster.metadata.Metadata;
                + "    \"cluster_coordination\" : {\n"  
                + "          \"create_index\"\n"
        assertEquals(
            .version(randomInt(5))
                + "          \"0\" : [\n"  
                + "  \"version\" : 0,\n"  
                + "          \"write\",\n"
 * this file be licensed under the Apache-2.0 license or a
                + "          \"index\" : \"index\",\n"
                + "          \"index.version.created\" : \""
                + allocationId
                + "          \"pattern1\",\n"
                + "  \"routing_table\" : {\n"
                + "          \"parent_to_child_shards\" : { }\n"
public class ClusterStateTests extends OpenSearchTestCase {
                + "        \"acceptedConfigurationNodeId\"\n"
 * license agreements. See the NOTICE file distributed with
                + "        \"routing_num_shards\" : 1,\n"  
        assertEquals(
                + "          \"index.number_of_shards\" : \"1\",\n"  
            "{\n"  
                + "        \"state\" : \"open\",\n"  
            )
 * software distributed under the License is distributed on an
                + "      \"index\" : {\n"  
                + "  },\n"
                + "              \"key\" : \"value\"\n"
                + "      \"1\" : {\n"
                            .build()  
                + "\",\n"  
            .numberOfShards(1)  
        final ClusterState clusterState = buildClusterState();
                + "          \"is_paused\" : false\n"
                + "          \"shard\" : 1,\n"  
                + "        \"acceptedConfigurationNodeId\"\n"
                + "      ],\n"
                + "          }\n"
                + "      \"nodeId2\" : [\n"  
                + "  \"cluster_manager_node\" : \"clusterManagerNodeId\",\n"
                + "  \"cluster_manager_node\" : \"clusterManagerNodeId\",\n"
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
                + "\"\n"  
                    });
                + "  },\n"  
        public static final String TYPE = "custom_md";
                + "    }\n"
                + "        },\n"
    }
                + "        \"mappings\" : {\n"  
        assertFalse(noClusterManager1.supersedes(withClusterManager1a));  
                + "              \"created\" : \""  
                + Version.CURRENT.id
                + "    \"templates\" : { },\n"  
                            EnumSet.allOf((ClusterBlockLevel.class))
                + "        \"split_shards_metadata\" : {\n"  
                + "      \"last_accepted_config\" : [\n"
import org.opensearch.cluster.node.DiscoveryNodes;  
                + "        },\n"
        assertThat(
                + "          \"index\" : {\n"  
                + "            }\n"
                + Version.CURRENT.id
        final ClusterState.Builder builder = ClusterState.builder(ClusterName.DEFAULT);
}
                + "        \"settings\" : {\n"  
        final DiscoveryNode node2 = new DiscoveryNode("node2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), version);
                + "              \"state\" : \"STARTED\",\n"
        final ClusterState clusterState = buildClusterState();
                + "              \"searchOnly\" : false,\n"
                + "            \"type1\" : {\n"  
            builder.toString()
                + "          \"root_shards_to_all_children\" : { },\n"  
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                + "        \"primary_terms_map\" : {\n"
                + "          \"read\",\n"  
import org.opensearch.cluster.routing.IndexRoutingTable;
                + "    }\n"
                + "              \"key\" : \"value\"\n"
import static java.util.Collections.emptyMap;  
                + "\",\n"
                    .put(
                + "              \"node\" : \"nodeId2\",\n"
                + "      }\n"
                            .numberOfReplicas(2)
                    .addIndexBlock(
                + "    },\n"  
                + "        \"aliases\" : [\n"  
import org.opensearch.cluster.block.ClusterBlock;
                + "          \"state\" : \"STARTED\",\n"
                + "          \"1\" : [\n"
            .putInSyncAllocationIds(0, new HashSet<String>() {
                + "        },\n"
                + "    \"indices\" : {\n"  
                + "        \"shards\" : {\n"
                + "      \"index\" : {\n"
                + "\"\n"
                + "        \"mappings\" : { },\n"
                + "        ]\n"  
                + "        }\n"  
                + "        \"disable_state_persistence\" : true,\n"
import java.util.Map;
                + "            \"version\" : {\n"
                + "            0\n"
        }
                + "  \"master_node\" : null,\n"
                        "index",
                + "  }\n"
                + "        \"ingestion_status\" : {\n"
                + "\"\n"  
                + "    }\n"  
                + "\"\n"  
                            .order(0)
                + "            \"number_of_replicas\" : \"2\",\n"
                + "  \"routing_nodes\" : {\n"
                + "          \"0\" : [ ]\n"  
                + "              \"state\" : \"STARTED\",\n"
                + "  },\n"
                + "  \"blocks\" : {\n"  
                + "        \"mapping_version\" : 1,\n"
    public void testBuilderRejectsNullInCustoms() {
                + "    \"cluster_uuid_committed\" : false,\n"  
                + "      \"template\" : {\n"  
                + "        },\n"
                + "    },\n"  
    public void testBuilderRejectsNullCustom() {
                + "          \"metadata_write\",\n"
import org.opensearch.core.xcontent.ToXContent;  
                + "    \"cluster_coordination\" : {\n"
        builder.startObject();  
    }
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();  
                + "      \"ephemeral_id\" : \""
                + "        \"aliases\" : [\n"
            .build();
                + "            \"metadata_read\",\n"
                + "        \"shards\" : {\n"  
                + "            \"type1\" : {\n"
                + "    }\n"  
                + "          \"write\",\n"
                + "              \"shard\" : 1,\n"
                + "      \"transport_address\" : \"127.0.0.1:111\",\n"
            .settings(Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT.id))
                                                    put("key", "value");
                + "      \"last_committed_config\" : [ ],\n"
        builder.endObject();  
                + "        \"mapping_version\" : 1,\n"  
                        {
                + "            \"allocationId\"\n"
            .numberOfReplicas(2)
                + "        \"mapping_version\" : 1,\n"  
                + "  \"nodes\" : {\n"
                + "  },\n"  
                            .putMapping("type", "{ \"key1\": {} }")  
import org.opensearch.core.index.shard.ShardId;
                + "          \"max_shard_id\" : 0,\n"
                + "          \"parent_to_child_shards\" : { }\n"  
                + "\"\n"
                + "          \"index.number_of_replicas\" : \"2\",\n"
                + "        },\n"  
                + "  \"version\" : 0,\n"
                + "            \"met_conditions\" : { },\n"
                + "        },\n"  
                + "      \"index\" : {\n"
                + "\"\n"  
                + "          \"levels\" : [\n"
                + "            }\n"
    }
                + "          \"pattern2\"\n"  
    public void testSupersedes() {
                + ephemeralId
            }
                + "        \"version\" : 2,\n"  
                + "        \"2\" : {\n"
                + "          }\n"  
                + "            \"id\" : \""  
                + "  \"version\" : 0,\n"
                + "    \"cluster_uuid_committed\" : false,\n"
                + "          \"index\" : \"index\",\n"
        assertFalse(withClusterManager1a.supersedes(withClusterManager2));  
                    .addGlobalBlock(  
                + Version.CURRENT.id  
                + "          }\n"  
                + "    },\n"
                + "          ]\n"
                + "        \"mappings\" : {\n"
                + "        }\n"
                                            });
                + "  },\n"
                + "          \"node\" : \"nodeId2\",\n"
import static java.util.Collections.singletonMap;
                + "            \"version\" : {\n"
                + "      ],\n"  
                + "  \"cluster_manager_node\" : null,\n"  
                    .clusterManagerNodeId("clusterManagerNodeId")  
                + "    },\n"
                + "          ],\n"
                + "              \"relocating_node\" : null,\n"  
            )  
                + "                \"id\" : \""
                + "        \"version\" : 1,\n"
                + "      \"index\" : {\n"
import java.util.HashSet;  
                + "            \"type1\" : {\n"  
                + "          ]\n"  
                + "            }\n"  
import static org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING;  
                Metadata.builder()
                + "        \"ingestion_status\" : {\n"  
    }
                + "            {\n"
                + "    \"cluster_uuid_committed\" : false,\n"
                + "      }\n"
                + "  \"master_node\" : \"clusterManagerNodeId\",\n"
            .nodes(DiscoveryNodes.builder(nodes).clusterManagerNodeId(node1.getId()))
                + "          \"0\" : 1\n"  
    private ClusterState buildClusterState() throws IOException {
                + "          \"num_of_root_shards\" : 1,\n"
                + "        \"aliases_version\" : 1,\n"
                + "    }\n"
                + "      \"nodeId2\" : [\n"
                + "      ]\n"  
                    .coordinationMetadata(  
                + "        ]\n"  
                + "          }\n"
                + allocationId
                                new IndexShardRoutingTable.Builder(new ShardId("index", "_na_", 1)).addShard(  
                + "  }\n"  
 * the Apache License, Version 2.0 (the "License"); you may
                                ).build()
                + "  },\n"
            .metadata(  
                + "    \"indices\" : {\n"  
                    )
                + "        \"2\" : {\n"
                + "      ],\n"
import org.opensearch.cluster.coordination.CoordinationMetadata;
import org.opensearch.cluster.routing.TestShardRouting;
                            .settings(Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT.id))
                + "        \"ingestion_status\" : {\n"
                + "    }\n"  
                + "    \"indices\" : {\n"
                + "            \"metadata_read\",\n"
                + "          \"type\" : {\n"
                + "  }\n"
                + "  },\n"
                + "          \"retryable\" : false,\n"  
                + "  \"routing_nodes\" : {\n"
import static org.hamcrest.Matchers.equalTo;  
                + "            }\n"  
                + "          \"rolloveAlias\" : {\n"
                + "        \"system\" : false,\n"
    }
                    .build()
                + "      \"attributes\" : { }\n"
        assertThat(expectThrows(NullPointerException.class, () -> builder.putCustom(key, null)).getMessage(), containsString(key));
                + "    },\n"  
                + "          \"state\" : \"STARTED\",\n"
        builder.endObject();  
                    .add(  
                + "      ],\n"
                + "  \"routing_table\" : {\n"
                + "    \"templates\" : {\n"
 *  
        assertEquals(
                            )
 * Unless required by applicable law or agreed to in writing,
            {
                + "          \"index\" : {\n"  
                + "          \"root_shards_to_all_children\" : { },\n"
                + "        }\n"
                + "          \"active_shard_ids\" : [\n"
                            .primaryTerm(0, 1L)
                + "  \"cluster_uuid\" : \"clusterUUID\",\n"  
                + "\",\n"  
                + "        \"aliases\" : [\n"
import org.opensearch.cluster.routing.RoutingTable;  
import org.opensearch.cluster.routing.ShardRoutingState;
            return EnumSet.of(Metadata.XContentContext.GATEWAY, Metadata.XContentContext.SNAPSHOT);
 * The OpenSearch Contributors require contributions made to  
        clusterState.toXContent(builder, new ToXContent.MapParams(singletonMap(Metadata.CONTEXT_MODE_PARAM, Metadata.CONTEXT_MODE_API)));
    public void testToXContent_FlatSettingTrue_ReduceMappingFalse() throws IOException {  
import org.opensearch.cluster.metadata.AliasMetadata;  
                + "  \"metadata\" : {\n"
                + "            \"key\" : \"value\"\n"
    }
                + "        }\n"
                                        }
import org.opensearch.cluster.node.DiscoveryNode;
                + "        },\n"
import org.opensearch.action.admin.indices.rollover.RolloverInfo;
 * not use this file except in compliance with the License.
        ClusterState noClusterManager2 = ClusterState.builder(name).version(randomInt(5)).nodes(nodes).build();
                + "      \"name\" : \"\",\n"
                + "          \"type\" : {\n"  
                + "          \"shard\" : 1,\n"  
                + "      \"last_committed_config\" : [\n"
                + "        },\n"
            super(data);
        Map<String, String> mapParams = new HashMap<String, String>() {
                            put("key", "value");  
                    .put(
                + "          \"root_shards_to_all_children\" : { },\n"
                + "  \"state_uuid\" : \"stateUUID\",\n"
                + "            \"allocationId\"\n"
                + "        {\n"
                + "          \"relocating_node\" : null,\n"
                    .put(indexMetadata, false)  
            .build();  
                + "        {\n"
                + "        \"primary_terms\" : {\n"  
                                    )  
        final ClusterState.Builder builder = ClusterState.builder(ClusterName.DEFAULT);
                + "      \"1\" : {\n"
                + "    }\n"
                                }
    public void testToXContentSameTypeName() throws IOException {  
                + "          ]\n"
                + "    \"indices\" : {\n"
                + "    \"unassigned\" : [ ],\n"  
                + "            \"met_conditions\" : { },\n"  
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
                        )
                + "              \"key\" : \"value\"\n"
                + "      \"term\" : 1,\n"
            .metadata(  
import java.util.Arrays;
                + "      \"name\" : \"\",\n"  
 * GitHub history for details.
                + "      }\n"
                + "  },\n"  
package org.opensearch.cluster;
                + "        ],\n"
                    add("allocationId");
 * compatible open source license.
                + "          \"description\" : \"description2\",\n"
import org.opensearch.common.settings.Settings;  
        assertFalse(noClusterManager1.supersedes(noClusterManager2));
                + "        },\n"
                + "    \"indices\" : {\n"  
                + "          \"primary\" : true,\n"  
                + "    \"global\" : {\n"  
                + "      }\n"
                + "        \"disable_state_persistence\" : true,\n"
            .version(randomInt(5))  
import java.util.EnumSet;
                }  
                + "          \"pattern2\"\n"
                + "        \"aliases\" : { }\n"  
        // state from the same cluster-manager compare by version  
                + "          \"type\" : {\n"
                + "      ],\n"
        return ClusterState.builder(ClusterName.DEFAULT)
                + "        ],\n"
            .build();
            .putRolloverInfo(new RolloverInfo("rolloveAlias", new ArrayList<>(), 1L))
 * ownership. Elasticsearch licenses this file to you under  
                + "    \"nodeId1\" : {\n"
                    .build()
        ClusterName name = CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY);  
                + "        \"routing_num_shards\" : 1,\n"
                + "              }\n"
                + "    },\n"
                + "  \"state_uuid\" : \"stateUUID\",\n"  
                + "    \"unassigned\" : [ ],\n"  
 * Licensed to Elasticsearch under one or more contributor  
                + "    \"indices\" : {\n"  
                + "          }\n"
            }  
        // states with no cluster-manager should never supersede anything
                + "        \"mappings\" : {\n"
                                )
                + "          \"key1\" : { }\n"  
import org.opensearch.core.common.transport.TransportAddress;
/*
                    .transientSettings(Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT.id).build())
        );
 * SPDX-License-Identifier: Apache-2.0
                    )  
                + "        \"order\" : 0,\n"
                + "        },\n"  
                            RestStatus.ACCEPTED,  
                + "        \"rollover_info\" : {\n"
                            2,
                + "        \"settings\" : {\n"
                + "    \"templates\" : {\n"
                + "      }\n"  
                + "          \"create_index\"\n"
                + "      }\n"
                + "        \"system\" : false,\n"  
                + "        \"rollover_info\" : { },\n"
                + "          \"max_shard_id\" : 0,\n"  
 * specific language governing permissions and limitations
                + "          \"primary\" : true,\n"
                + "            \"number_of_replicas\" : \"2\",\n"  
                + "          \"retryable\" : false,\n"
                put("flat_settings", "false");
import org.opensearch.cluster.metadata.IndexMetadata;
 */  
                + "    }\n"
 *
                + "          \"index\" : \"index\",\n"
        IndexRoutingTable index = clusterState.getRoutingTable().getIndicesRouting().get("index");
 * KIND, either express or implied.  See the License for the
                + Version.CURRENT.id
            return Version.CURRENT;  
                + "            \"number_of_shards\" : \"1\",\n"
                    .persistentSettings(Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT.id).build())
                + "  \"nodes\" : {\n"
                + "          \"rolloveAlias\" : {\n"
import org.opensearch.test.TestCustomMetadata;  
                            false,  
                                                }  
                + "        \"version\" : 1,\n"
                + "          ]\n"
                    .clusterUUID("clusterUUID")
                + "        \"aliases_version\" : 1,\n"
                + "  \"blocks\" : {\n"  
            .blocks(
                + Version.CURRENT.id  
                            .build()
        }
                + "  \"blocks\" : { },\n"
                + "      \"nodeId1\" : [ ]\n"  
                + "          \"num_of_root_shards\" : 1,\n"
                + "            \"metadata_write\",\n"
                + "          \"0\" : 1\n"  
                + "      }\n"  
                + "        \"levels\" : [\n"  
                + "        \"rollover_info\" : {\n"
                + "        },\n"
                + "        \"mappings\" : {\n"
                + "            \"time\" : 1\n"
/*
                + "          \"index\" : {\n"
                + "              \"allocation_id\" : {\n"
                + "            \"write\",\n"
                + "    \"indices\" : {\n"  
                + "      ],\n"  
                + "          \"node\" : \"nodeId2\",\n"
                + "          \"type\" : {\n"  
                + "          \"metadata_read\",\n"  
                + "          \"0\" : 1\n"  
        String ephemeralId = clusterState.getNodes().get("nodeId1").getEphemeralId();  
                + "        },\n"
                + "            \"version\" : {\n"  
        );
                                        ShardRoutingState.STARTED
        assertThat(expectThrows(NullPointerException.class, () -> builder.customs(map)).getMessage(), containsString(key));
import java.util.ArrayList;
        @Override
                + "          \"0\" : [\n"
            "{\n"
                + "        },\n"
                + "    \"index-graveyard\" : {\n"
                + "        \"in_sync_allocations\" : {\n"
                + "      }\n"
                + "        \"settings\" : {\n"  
import java.util.Collections;  
                + "          \"levels\" : [\n"
                + "  }\n"
                + "          \"0\" : 1\n"
                + "          \"pattern2\"\n"
                + "    }\n"  
                + "}",
import org.opensearch.cluster.block.ClusterBlocks;
                + "          }\n"
                + "      }\n"
                + "      \"voting_config_exclusions\" : [\n"  
                + "          }\n"
                + "      \"term\" : 1,\n"  
                + "          \"0\" : 1\n"  
                + "    \"cluster_uuid\" : \"clusterUUID\",\n"
                + "              \"searchOnly\" : false,\n"
                + "        {\n"
        };
                + "          \"primary\" : true,\n"
                + "    }\n"
import org.opensearch.core.xcontent.XContentBuilder;
                + "      \"template\" : {\n"  
 * under the License.  
                + "      \"voting_config_exclusions\" : [\n"
                + "  \"blocks\" : {\n"
                + "              \"index\" : \"index\",\n"
                + "            \"id\" : \""
                + "    \"cluster_uuid\" : \"clusterUUID\",\n"
 * Modifications Copyright OpenSearch Contributors. See  
                + "        },\n"  
                + "        \"state\" : \"open\",\n"
                + "        \"commitedConfigurationNodeId\"\n"
            .build();
                + "  \"nodes\" : { },\n"
    public void testToXContent_FlatSettingFalse_ReduceMappingTrue() throws IOException {
                + "        ],\n"
                + "        },\n"
                + "            {\n"
                + "        \"aliases_version\" : 1,\n"  
                + "  \"nodes\" : {\n"  
                + "        ],\n"
                + "              }\n"
                + "      \"last_accepted_config\" : [ ],\n"  
                + "      \"nodeId2\" : [\n"
                {  
                                    }  
                + "              \"relocating_node\" : null,\n"  
                + allocationId
                + "          \"active_shard_ids\" : [\n"
                        CoordinationMetadata.builder()
        String allocationId = index.getShards().get(1).getAllAllocationIds().iterator().next();
                + "  },\n"  
        builder.startObject();
            )
                + "  },\n"
                + "        \"retryable\" : true,\n"
                + "        },\n"  
                + "          \"max_shard_id\" : 0,\n"
                + "      \"transport_address\" : \"127.0.0.1:111\",\n"
                + "        {\n"  
                + "        }\n"
                                        new ShardId("index", "_na_", 1),
                + "      }\n"
        builder.startObject();
                + "        }\n"  
                + "      }\n"
                + "    }\n"
                + "        },\n"
                put("reduce_mappings", "false");
                + "    },\n"
                + "        }\n"
                        }
                + "        \"settings\" : {\n"
                + "  \"routing_nodes\" : {\n"  
                + "        \"levels\" : [\n"
                + "    \"nodes\" : {\n"
                + "        \"disable_state_persistence\" : true,\n"
                + "  \"master_node\" : \"clusterManagerNodeId\",\n"
            equalTo(withClusterManager1a.version() > withClusterManager1b.version())  
                + "      \"last_accepted_config\" : [\n"  
                + "        \"mappings\" : {\n"
                + allocationId  
                + "        \"in_sync_allocations\" : {\n"
                + "        \"primary_terms_map\" : {\n"
                + "      \"term\" : 1,\n"  
                + "          \"0\" : 1\n"  
                + "          \"node_id\" : \"exlucdedNodeId\",\n"  
        final Map<String, ClusterState.Custom> map = Collections.unmodifiableMap(mapBuilder);  
                + "        \"aliases\" : { }\n"
                ClusterBlocks.builder()
            .routingTable(
                                    add("commitedConfigurationNodeId");
                + "            \"metadata_write\",\n"  
                + "    }\n"  
        String ephemeralId = clusterState.getNodes().get("nodeId1").getEphemeralId();  
import org.opensearch.Version;  
                + "\"\n"  
                + "            \"read\",\n"  
                + "        \"description\" : \"description\",\n"
                + "      \"tombstones\" : [ ]\n"
                + "        },\n"
                + "              \"shard\" : 1,\n"
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
        // states should never supersede states from another cluster-manager
        final Version version = Version.CURRENT;
                + "          \"create_index\"\n"
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();  
                + "          \"searchOnly\" : false,\n"
            builder.toString()  
                + "          \"relocating_node\" : null,\n"  
                + ephemeralId
                + "  \"cluster_manager_node\" : \"clusterManagerNodeId\",\n"
                + "    \"unassigned\" : [ ],\n"
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
                + "          \"allocation_id\" : {\n"  
            return TYPE;
import org.opensearch.common.xcontent.json.JsonXContent;
                DiscoveryNodes.builder()
                + "          ]\n"  
                + "          \"pattern1\",\n"  
                + "    },\n"
        clusterState.toXContent(builder, new ToXContent.MapParams(mapParams));
                + "  \"metadata\" : {\n"
                + "      }\n"  
                + "    \"nodeId1\" : {\n"
                + "      ]\n"
                + "        \"description\" : \"description\",\n"  
                + "  \"version\" : 0,\n"
                            .settings(Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT.id))
            }))
                + "            }\n"  
                + "            \"number_of_replicas\" : \"2\",\n"
                + "        \"mapping_version\" : 1,\n"
        Map<String, String> mapParams = new HashMap<String, String>() {
                + "        \"settings_version\" : 1,\n"
                            .state(IndexMetadata.State.OPEN)  
                + "          \"node_name\" : \"excludedNodeName\"\n"
                + "      \"voting_config_exclusions\" : [\n"
                + "        }\n"
        public String getWriteableName() {  
                                    // the original logic in ClusterState.toXContent will reduce  
                + "      \"attributes\" : { }\n"
import org.opensearch.cluster.metadata.MappingMetadata;  
                put(Metadata.CONTEXT_MODE_PARAM, Metadata.CONTEXT_MODE_API);  
 */
        IndexRoutingTable index = clusterState.getRoutingTable().getIndicesRouting().get("index");
    public void testToXContent() throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                                {  
                + "      \"index\" : {\n"
                + "            }\n"
                + "        }\n"
                + "    \"nodes\" : {\n"
                            .build()
                }
                + "          \"node\" : \"nodeId2\",\n"
                + "          }\n"
                + "    \"index-graveyard\" : {\n"
                + "        \"primary_terms\" : {\n"
            withClusterManager1a.supersedes(withClusterManager1b),
                + "              \"created\" : \""
                + "  \"routing_table\" : {\n"  
                + "        ]\n"
import static org.hamcrest.Matchers.containsString;
                + "          \"is_paused\" : false\n"  
                + "        \"order\" : 0,\n"  
                + "\"\n"  
                + "    \"cluster_coordination\" : {\n"
        );
        public EnumSet<Metadata.XContentContext> context() {
        assertFalse(withClusterManager1a.supersedes(noClusterManager1));
                + "          \"num_of_root_shards\" : 1,\n"  
                                                {
                + "    },\n"
                + "    },\n"
                + "        \"mappings\" : {\n"
                + "  \"routing_nodes\" : {\n"
                + "        }\n"
                + "}",
import java.util.HashMap;
                + "  \"master_node\" : \"clusterManagerNodeId\",\n"  
                + "        \"settings_version\" : 1,\n"
            .putAlias(AliasMetadata.builder("alias").indexRouting("indexRouting").build())
    }
                                    TestShardRouting.newShardRouting(
        CustomMetadata(String data) {
                + "        \"acceptedConfigurationNodeId\"\n"
                + "          \"parent_to_child_shards\" : { }\n"  
            .nodes(DiscoveryNodes.builder(nodes).clusterManagerNodeId(node1.getId()))  
                + "        \"description\" : \"description\",\n"  
        ClusterState withClusterManager1a = ClusterState.builder(name)  
                + "          \"rolloveAlias\" : {\n"  
                + "        \"commitedConfigurationNodeId\"\n"
                + "        },\n"
                + "      \"tombstones\" : [ ]\n"
                + "\"\n"
                + "        ],\n"
                                        true,
            .build();
                + "          \"node_id\" : \"exlucdedNodeId\",\n"  
                            .numberOfShards(1)  
                + "          ]\n"
                + "          }\n"  
                + "          \"node_name\" : \"excludedNodeName\"\n"  
                + "    },\n"
        final DiscoveryNode node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), version);  
                    )  
                + "          }\n"  
            builder.toString()
                + "          \"retryable\" : false,\n"
                + "        {\n"  
                + "        },\n"
                + "          }\n"  
        }  
                    .add(new DiscoveryNode("nodeId1", new TransportAddress(InetAddress.getByName("127.0.0.1"), 111), Version.CURRENT))
                + "      ]\n"  
                + "            \"number_of_shards\" : \"1\",\n"
                + "        },\n"
        @Override  
                + "      \"nodeId1\" : [ ]\n"  
                            .term(1)
                + "          \"active_shard_ids\" : [\n"
                + "            \"metadata_read\",\n"
        );  
        final ClusterState clusterState = buildClusterState();  
                put("reduce_mappings", "true");
                        new ClusterBlock(1, "description", true, true, true, RestStatus.ACCEPTED, EnumSet.allOf((ClusterBlockLevel.class)))
                + "        },\n"
                + "        \"index_patterns\" : [\n"
                + "    \"unassigned\" : [ ],\n"
                + "    }\n"
import static java.util.Collections.emptySet;
                + "        \"aliases\" : [ ],\n"
            builder.toString()
                + "    \"cluster_coordination\" : {\n"
                + "            \"version\" : {\n"  
                + "    \"indices\" : {\n"
                + "      \"template\" : {\n"
            .stateUUID("stateUUID")
                + "        \"routing_num_shards\" : 1,\n"  
                    .addBlocks(indexMetadata)  
                + "          \"shard\" : 1,\n"
                RoutingTable.builder()
                    put("type1", new HashMap<String, Object>() {
                + "                \"id\" : \""
                + "        \"index_patterns\" : [\n"
                + "            }\n"
                + "    }\n"
                + "      \"voting_config_exclusions\" : [ ]\n"
                + "    \"templates\" : {\n"
            .putMapping(new MappingMetadata("type", new HashMap<String, Object>() {
                + "        },\n"
                + "            \"met_conditions\" : { },\n"  
                + "  \"state_uuid\" : \"stateUUID\",\n"
                + "        \"ingestion_status\" : {\n"
        final Map<String, ClusterState.Custom> mapBuilder = new HashMap<>();
                    .build()
                + "        \"settings_version\" : 1,\n"
                + "      }\n"  
                + "          \"read\",\n"
                + "        },\n"  
                            .addVotingConfigExclusion(new CoordinationMetadata.VotingConfigExclusion("exlucdedNodeId", "excludedNodeName"))
                + "          \"alias\"\n"  
                + "  },\n"
                + "        },\n"  
                + "          \"max_shard_id\" : 0,\n"
                + "          \"parent_to_child_shards\" : { }\n"
import org.opensearch.core.index.Index;  
                + "        \"routing_num_shards\" : 1,\n"
                + "          \"root_shards_to_all_children\" : { },\n"
                + "        \"settings_version\" : 1,\n"  
                + "        },\n"
        };
import java.io.IOException;
                + "        \"state\" : \"open\",\n"
        }  
                + "          \"alias\"\n"
import java.net.InetAddress;  
                + ephemeralId
                + "      \"transport_address\" : \"127.0.0.1:111\",\n"  
                + "        \"shards\" : {\n"
                                }  
                        IndexRoutingTable.builder(new Index("index", "indexUUID"))
                        new ClusterBlock(  
                + "  \"state_uuid\" : \"stateUUID\",\n"  
                            false,
                + "              \"shard\" : 1,\n"
        assertEquals(  
                                        {
                    )
                + "              \"primary\" : true,\n"  
                + "          ],\n"
                    )
                + "        },\n"
                + "    },\n"
                + "              \"created\" : \""
        builder.startObject();
                + "    \"indices\" : {\n"  
                + "              \"index\" : \"index\",\n"
/*  
                + "              \"allocation_id\" : {\n"  
                + "    \"index-graveyard\" : {\n"
                + "        }\n"  
                + "          \"0\" : [\n"  
                                    add("acceptedConfigurationNodeId");
                + "      \"tombstones\" : [ ]\n"  
    }
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
                + "      \"ephemeral_id\" : \""
                + "          \"levels\" : [\n"
                                    // the type name is the root value,
                + "              \"created\" : \""
                + "            }\n"
        clusterState.toXContent(builder, ToXContent.EMPTY_PARAMS);  
                + "          \"1\" : [\n"  
                + "        \"split_shards_metadata\" : {\n"
        String allocationId = index.getShards().get(1).getAllAllocationIds().iterator().next();
            )  
                + "          \"write\",\n"
                + "\"\n"
                + "            \"read\",\n"  
                + "          \"alias\"\n"  
                + "        },\n"
        clusterState.toXContent(builder, new ToXContent.MapParams(mapParams));
                + "      \"index\" : {\n"
                + "              \"index\" : \"index\",\n"  
                + "          ],\n"
 *
        IndexRoutingTable index = clusterState.getRoutingTable().getIndicesRouting().get("index");  
                + "          \"metadata_read\",\n"  
                + "              \"relocating_node\" : null,\n"
                + "        }\n"
                + "        }\n"
        String allocationId = index.getShards().get(1).getAllAllocationIds().iterator().next();  
                + "          \"is_paused\" : false\n"  
                            .lastCommittedConfiguration(new CoordinationMetadata.VotingConfiguration(new HashSet<String>() {  
                + "        \"state\" : \"open\",\n"
                + "          \"relocating_node\" : null,\n"
                + "\"\n"
                        IndexTemplateMetadata.builder("template")
                + "          \"node_name\" : \"excludedNodeName\"\n"
                + "      \"last_committed_config\" : [\n"
                + "    \"index-graveyard\" : {\n"  
                    )  
                + "    \"global\" : {\n"
                {  
                + "              \"node\" : \"nodeId2\",\n"
                + "        },\n"
                + "      ],\n"  
        public Version getMinimalSupportedVersion() {
                + "            \"time\" : 1\n"
                + "            \"create_index\"\n"  
                + "              \"state\" : \"STARTED\",\n"  
                + "        },\n"
                + "        \"primary_terms_map\" : {\n"  
                + "            \"create_index\"\n"
                + "    \"nodeId1\" : {\n"
            "{\n"
                + "        },\n"  
                + "            \"read\",\n"
                + "          \"1\" : [\n"  
                + "          \"index\" : {\n"
                + "      \"nodeId1\" : [ ]\n"
                + "          }\n"
                + "  \"routing_table\" : {\n"
                + "          \"allocation_id\" : {\n"
                                new MappingMetadata(  
                + "              \"node\" : \"nodeId2\",\n"  
 * You may obtain a copy of the License at  
                + "        \"retryable\" : true,\n"  
                + "          \"index.version.created\" : \""
                + "      }\n"
                + "        \"in_sync_allocations\" : {\n"  
        ClusterState withClusterManager1b = ClusterState.builder(name)
                + "          \"description\" : \"description2\",\n"  
            .stateUUID("stateUUID")  
                + "        \"system\" : false,\n"
                + "      \"index\" : {\n"  
 * this work for additional information regarding copyright
                + "      \"index\" : {\n"
                            .patterns(Arrays.asList("pattern1", "pattern2"))  
                + "      }\n"
                + "    \"indices\" : {\n"
                + "          \"key1\" : { }\n"
        final String key = randomAlphaOfLength(10);  
                + "          \"active_shard_ids\" : [\n"  
                + "      ],\n"  
                    .clusterUUID("clusterUUID")
                + allocationId
                + "          \"0\" : 1\n"
                + "            }\n"
                + "          ]\n"
                + "      \"index\" : {\n"
                + "          \"description\" : \"description2\",\n"  
                + "    \"global\" : {\n"
            "{\n"  
                + "        },\n"
import org.opensearch.cluster.block.ClusterBlockLevel;  
                + "          \"searchOnly\" : false,\n"  
                + "        \"levels\" : [\n"  
                + "        \"settings\" : {\n"  
                + "          \"num_of_root_shards\" : 1,\n"  
                            .addIndexShard(
                + "\"\n"
                + "    \"nodes\" : {\n"
                + "              \"primary\" : true,\n"  
                + "  },\n"  
                            .putMapping(
                + "  },\n"
                + "  \"cluster_uuid\" : \"clusterUUID\",\n"
                                    new HashMap<String, Object>() {
                + "        \"settings\" : {\n"
        ClusterState noClusterManager1 = ClusterState.builder(name).version(randomInt(5)).nodes(nodes).build();
                + "    \"cluster_uuid_committed\" : false,\n"
                + "    \"cluster_uuid\" : \"clusterUUID\",\n"  
                + "}",  
                + "              \"allocation_id\" : {\n"  
                + "            \"version\" : {\n"
                + "          \"0\" : 1\n"  
                put("flat_settings", "true");  
                + "        \"retryable\" : true,\n"
                            .lastAcceptedConfiguration(new CoordinationMetadata.VotingConfiguration(new HashSet<String>() {
                + "              \"primary\" : true,\n"
                + "          \"allocation_id\" : {\n"
                + "        }\n"
                + "        ],\n"
                + "        \"aliases\" : { }\n"  
                + "        \"2\" : {\n"
                + "            \"allocationId\"\n"
