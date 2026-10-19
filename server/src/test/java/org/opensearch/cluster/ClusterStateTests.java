                + "      \"ephemeral_id\" : \""
                + "          \"0\" : [\n"
                + "        \"mappings\" : {\n"
                + allocationId
                + "        \"state\" : \"open\",\n"
                + "          \"pattern2\"\n"
                        new ClusterBlock(1, "description", true, true, true, RestStatus.ACCEPTED, EnumSet.allOf((ClusterBlockLevel.class)))
                                        ShardRoutingState.STARTED
                + "            \"number_of_replicas\" : \"2\",\n"
        @Override
                + "          \"retryable\" : false,\n"
                    .coordinationMetadata(
                + "          }\n"
                + "          \"create_index\"\n"
                + "        \"order\" : 0,\n"
                + "      \"index\" : {\n"
                                        true,
                + "          \"key1\" : { }\n"
                + Version.CURRENT.id
import static org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING;
    }
                + "    }\n"
                + Version.CURRENT.id
import org.opensearch.core.index.Index;
                + "    },\n"
                + "          }\n"
 * Modifications Copyright OpenSearch Contributors. See
                + "        ]\n"
                + "    }\n"
                    .add(
                + "        \"version\" : 1,\n"
                + "        },\n"
                + "      \"tombstones\" : [ ]\n"
                + "    \"cluster_uuid\" : \"clusterUUID\",\n"
                + "    }\n"
                + "        \"state\" : \"open\",\n"
                + "    \"templates\" : {\n"
        assertFalse(noClusterManager1.supersedes(withClusterManager1a));
    }
                + "  \"state_uuid\" : \"stateUUID\",\n"
                    });
            withClusterManager1a.supersedes(withClusterManager1b),
import org.opensearch.test.TestCustomMetadata;
                + "        \"in_sync_allocations\" : {\n"
                + "        },\n"
                }
                            }))
                + "          \"index.number_of_shards\" : \"1\",\n"
                + "        \"mapping_version\" : 1,\n"
                + "        \"mappings\" : {\n"
                + "    \"cluster_coordination\" : {\n"
                + "        \"aliases_version\" : 1,\n"
                + "  \"version\" : 0,\n"
                + "            \"read\",\n"
                + "        \"ingestion_status\" : {\n"
                + "    \"unassigned\" : [ ],\n"
                + "      ],\n"
    private ClusterState buildClusterState() throws IOException {
                + "      \"term\" : 0,\n"
            "{\n"
                + "          \"index.version.created\" : \""
                + "        \"aliases\" : { }\n"
                + "  \"state_uuid\" : \"stateUUID\",\n"
                + "              \"node\" : \"nodeId2\",\n"
                + "        \"settings\" : {\n"
                + "            0\n"
                + "          \"create_index\"\n"
 * not use this file except in compliance with the License.
                + "      \"last_accepted_config\" : [ ],\n"
                + "      \"voting_config_exclusions\" : [\n"
                + "            {\n"
                + "        \"commitedConfigurationNodeId\"\n"
                + "\"\n"
                + "            \"time\" : 1\n"
        String allocationId = index.getShards().get(1).getAllAllocationIds().iterator().next();
                }
 * SPDX-License-Identifier: Apache-2.0
                + "  },\n"
                    .clusterUUID("clusterUUID")
                    )
            .version(randomInt(5))
                + "    }\n"
                + "        \"aliases\" : { }\n"
                + "          \"shard\" : 1,\n"
import static org.hamcrest.Matchers.containsString;
 * this work for additional information regarding copyright
                + "        {\n"
                + "          }\n"
                + "      \"template\" : {\n"
import org.opensearch.cluster.block.ClusterBlockLevel;
                            .lastAcceptedConfiguration(new CoordinationMetadata.VotingConfiguration(new HashSet<String>() {
                + "  },\n"
            )
                + "          \"index\" : \"index\",\n"
import org.opensearch.action.admin.indices.rollover.RolloverInfo;
                + "    \"indices\" : {\n"
                        IndexMetadata.builder("index")
                + "          \"root_shards_to_all_children\" : { },\n"
                + "            \"met_conditions\" : { },\n"
                + "          }\n"
                + "          \"0\" : 1\n"
                + "        },\n"
                + "  \"version\" : 0,\n"
                + "      \"template\" : {\n"
                + "              \"shard\" : 1,\n"
            })
                + "        \"primary_terms_map\" : {\n"
                + "  \"version\" : 0,\n"
                + "    }\n"
        );
                + "  },\n"
                + "    }\n"
                + "            }\n"
                + "        },\n"
                + "        \"description\" : \"description\",\n"
    }
                + "            \"write\",\n"
                + "    \"nodeId1\" : {\n"
 * The OpenSearch Contributors require contributions made to
                            .numberOfShards(1)
                + "    }\n"
                + "            }\n"
                + "        }\n"
                + "                \"id\" : \""
                + allocationId
        final String key = randomAlphaOfLength(10);
        public static final String TYPE = "custom_md";
                + "          ]\n"
                + "        \"aliases_version\" : 1,\n"
                + "              \"primary\" : true,\n"
        };
                + "        },\n"
                + "              \"relocating_node\" : null,\n"
                                )
                + "    \"index-graveyard\" : {\n"
                + "          \"searchOnly\" : false,\n"
                + "          \"is_paused\" : false\n"
            .blocks(
        ClusterState noClusterManager1 = ClusterState.builder(name).version(randomInt(5)).nodes(nodes).build();
                + "        \"split_shards_metadata\" : {\n"
                + "        \"rollover_info\" : { },\n"
                + "        {\n"
                + "          \"rolloveAlias\" : {\n"
                + "    \"cluster_uuid_committed\" : false,\n"
                + "    },\n"
                + "          \"root_shards_to_all_children\" : { },\n"
                    .clusterManagerNodeId("clusterManagerNodeId")
                + "          \"0\" : 1\n"
                + "        },\n"
                                    }
 *
                + "            }\n"
import org.opensearch.core.common.transport.TransportAddress;
                + "        \"2\" : {\n"
            .version(randomInt(5))
                            .build()
                + "          \"primary\" : true,\n"
                + "      \"index\" : {\n"
                + "          \"root_shards_to_all_children\" : { },\n"
            .nodes(
                + "  \"routing_table\" : {\n"
                + "        ]\n"
                + "            0\n"
                + "  \"metadata\" : {\n"
                + "          \"0\" : 1\n"
                + "        },\n"
                + "          \"max_shard_id\" : 0,\n"
                + "\"\n"
                + "          \"rolloveAlias\" : {\n"
                + "        }\n"
        String ephemeralId = clusterState.getNodes().get("nodeId1").getEphemeralId();
                + "              \"created\" : \""
                + "        }\n"
                    .put(
                + "      ],\n"
                + "        },\n"
                + "              \"state\" : \"STARTED\",\n"
                + "      }\n"
                + Version.CURRENT.id
        return ClusterState.builder(ClusterName.DEFAULT)
                + "  \"cluster_uuid\" : \"clusterUUID\",\n"
                + "        \"mappings\" : { },\n"
                + "    \"cluster_coordination\" : {\n"
                + "        },\n"
        final ClusterState.Builder builder = ClusterState.builder(ClusterName.DEFAULT);
                + "      \"last_committed_config\" : [\n"
                + "          \"1\" : [\n"
                                    TestShardRouting.newShardRouting(
                + "          \"state\" : \"STARTED\",\n"
                + "          \"num_of_root_shards\" : 1,\n"
                + "      }\n"
                + "          \"alias\"\n"
                + "      \"attributes\" : { }\n"
                + "        },\n"
                + "  \"nodes\" : { },\n"
                + "        }\n"
                + "  \"master_node\" : \"clusterManagerNodeId\",\n"
                + "      }\n"
        assertEquals(
                + "  \"cluster_manager_node\" : \"clusterManagerNodeId\",\n"
import org.opensearch.cluster.metadata.IndexMetadata;
                + "              \"shard\" : 1,\n"
                + "          \"node_name\" : \"excludedNodeName\"\n"
public class ClusterStateTests extends OpenSearchTestCase {
                + "          \"node\" : \"nodeId2\",\n"
                + "          \"node_id\" : \"exlucdedNodeId\",\n"
                + "            \"read\",\n"
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.cluster.routing.RoutingTable;
                + "    \"indices\" : {\n"
        assertEquals(
                            .settings(Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT.id))
        @Override
                + "\"\n"
                + "            }\n"
                + "        }\n"
                + "          \"index.version.created\" : \""
                + "            \"write\",\n"
            return Version.CURRENT;
        Map<String, String> mapParams = new HashMap<String, String>() {
                + "        }\n"
                + "          \"parent_to_child_shards\" : { }\n"
                + "        }\n"
                + "  },\n"
                + "        \"index_patterns\" : [\n"
                ClusterBlocks.builder()
                + "      }\n"
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
        final ClusterState clusterState = buildClusterState();
                + "        },\n"
                put("reduce_mappings", "true");
                            .lastCommittedConfiguration(new CoordinationMetadata.VotingConfiguration(new HashSet<String>() {
                + "            \"metadata_write\",\n"
                                {
        IndexRoutingTable index = clusterState.getRoutingTable().getIndicesRouting().get("index");
                            put("key", "value");
                + "          \"num_of_root_shards\" : 1,\n"
                    )
                + "          \"pattern1\",\n"
                + "          }\n"
                + "        \"version\" : 1,\n"
                                        }
                + Version.CURRENT.id
        CustomMetadata(String data) {
                + "      \"attributes\" : { }\n"
            .putInSyncAllocationIds(0, new HashSet<String>() {
                + "    \"index-graveyard\" : {\n"
                + "              \"index\" : \"index\",\n"
                + "  \"nodes\" : {\n"
                Metadata.builder()
        builder.endObject();
                + "}",
        final Version version = Version.CURRENT;
                + "            \"create_index\"\n"
                + "      \"index\" : {\n"
                + "  }\n"
                + "        \"routing_num_shards\" : 1,\n"
                + "            }\n"
                + "              }\n"
                + "      \"last_accepted_config\" : [\n"
                + "        \"routing_num_shards\" : 1,\n"
                + "  },\n"
                + "        }\n"
                + "}",
                + "        \"split_shards_metadata\" : {\n"
                + "      \"tombstones\" : [ ]\n"
            .numberOfShards(1)
                            "description2",
                + "      }\n"
                + "  },\n"
                + "      \"1\" : {\n"
                                    add("acceptedConfigurationNodeId");
                + "    }\n"
        builder.startObject();
                + "        \"aliases_version\" : 1,\n"
                + "        ],\n"
            .metadata(
                + "        },\n"
                + "      \"attributes\" : { }\n"
                            .build()
                + "  \"nodes\" : {\n"
                + "        \"order\" : 0,\n"
                + "          \"0\" : [\n"
                + "  \"routing_nodes\" : {\n"
    public void testBuilderRejectsNullInCustoms() {
 *
                + "            }\n"
                + "    \"global\" : {\n"
                + "            \"metadata_read\",\n"
                + "        }\n"
                + "    \"indices\" : {\n"
                + "        \"mappings\" : {\n"
                + "        ],\n"
                + "        \"mapping_version\" : 1,\n"
                + "          \"key1\" : { }\n"
                + "      \"last_committed_config\" : [\n"
                + "          \"metadata_write\",\n"
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
                + "              \"primary\" : true,\n"
 * the Apache License, Version 2.0 (the "License"); you may
                + "        \"ingestion_status\" : {\n"
            equalTo(withClusterManager1a.version() > withClusterManager1b.version())
                + "              }\n"
            .build();
import org.opensearch.test.OpenSearchTestCase;
                + "        \"disable_state_persistence\" : true,\n"
            .build();
                + "              \"state\" : \"STARTED\",\n"
            .build();
                + "    \"indices\" : {\n"
                + "  \"routing_table\" : {\n"
                + "        \"index_patterns\" : [\n"
                + "          }\n"
                            .state(IndexMetadata.State.OPEN)
        String allocationId = index.getShards().get(1).getAllAllocationIds().iterator().next();
                + "    \"nodes\" : {\n"
                + "          \"1\" : [\n"
                + "              \"created\" : \""
                + "          \"root_shards_to_all_children\" : { },\n"
        final Map<String, ClusterState.Custom> map = Collections.unmodifiableMap(mapBuilder);
                + "      \"index\" : {\n"
                + allocationId
                + "          \"metadata_read\",\n"
                + "    \"indices\" : {\n"
                + "        \"mappings\" : {\n"
 * KIND, either express or implied.  See the License for the
                + "          \"node\" : \"nodeId2\",\n"
                + "        \"retryable\" : true,\n"
                + "        \"aliases_version\" : 1,\n"
                + "        \"mappings\" : {\n"
                + "          \"allocation_id\" : {\n"
                    .put(
                + "          \"1\" : [\n"
                + "        },\n"
                + "      \"tombstones\" : [ ]\n"
                + "      \"name\" : \"\",\n"
                + "      }\n"
                + "          ]\n"
                + "      \"nodeId2\" : [\n"
                + "              \"primary\" : true,\n"
        }
                + "        \"routing_num_shards\" : 1,\n"
                    put("type1", new HashMap<String, Object>() {
                + "}",
                + "          \"0\" : [ ]\n"
                + "          \"primary\" : true,\n"
                    )
                + "        ],\n"
        );
                + "  \"master_node\" : null,\n"
                + Version.CURRENT.id
                + "      }\n"
                put("reduce_mappings", "false");
                + "  }\n"
                + "          \"retryable\" : false,\n"
        IndexMetadata indexMetadata = IndexMetadata.builder("index")
                + "    \"cluster_uuid\" : \"clusterUUID\",\n"
                    )
                + "        \"system\" : false,\n"
                + "            \"metadata_write\",\n"
                + "  \"metadata\" : {\n"
 * this file be licensed under the Apache-2.0 license or a
                + "        },\n"
                + "      }\n"
                + "          \"index\" : {\n"
                + "        \"primary_terms_map\" : {\n"
                + "          \"metadata_read\",\n"
                + "                \"id\" : \""
                + "    },\n"
            .state(IndexMetadata.State.OPEN)
                + "              \"key\" : \"value\"\n"
    }
                + "        },\n"
                + "        \"in_sync_allocations\" : {\n"
                + "    },\n"
                + ephemeralId
                + "    \"indices\" : {\n"
        assertEquals(
                + "    \"global\" : {\n"
import org.opensearch.cluster.routing.IndexShardRoutingTable;
import org.opensearch.common.settings.Settings;
                + "    }\n"
        builder.startObject();
                        }
        final Map<String, ClusterState.Custom> mapBuilder = new HashMap<>();
                + "  },\n"
}
                + "            \"create_index\"\n"
                    .put(indexMetadata, false)
import java.util.HashSet;
                + "    }\n"
 * specific language governing permissions and limitations
import org.opensearch.cluster.coordination.CoordinationMetadata;
                + "  },\n"
                + "            \"write\",\n"
                + "              \"allocation_id\" : {\n"
        assertThat(expectThrows(NullPointerException.class, () -> builder.putCustom(key, null)).getMessage(), containsString(key));
                + "        \"commitedConfigurationNodeId\"\n"
                + "        }\n"
                + "        \"acceptedConfigurationNodeId\"\n"
                + "        \"ingestion_status\" : {\n"
                + "  \"blocks\" : {\n"
                + "    },\n"
    public static class CustomMetadata extends TestCustomMetadata {
        // states with no cluster-manager should never supersede anything
                + "            0\n"
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
                + "    \"cluster_uuid_committed\" : false,\n"
/*
                + "      ],\n"
                + "          \"type\" : {\n"
    }
                + "  \"cluster_manager_node\" : \"clusterManagerNodeId\",\n"
                + "      ]\n"
                + "      }\n"
                + "        },\n"
                + "          \"searchOnly\" : false,\n"
                + "          \"write\",\n"
                + "            \"read\",\n"
                + "          \"parent_to_child_shards\" : { }\n"
                + "        ],\n"
                + "\"\n"
                + "      \"index\" : {\n"
                + "            \"allocationId\"\n"
                + "    \"templates\" : {\n"
                + "          \"0\" : 1\n"
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
                + "      ],\n"
                + "        \"retryable\" : true,\n"
            builder.toString()
                + "        },\n"
                                        new ShardId("index", "_na_", 1),
                + "        },\n"
                + "            }\n"
        public Version getMinimalSupportedVersion() {
                RoutingTable.builder()
                + "          \"parent_to_child_shards\" : { }\n"
                + "            \"number_of_shards\" : \"1\",\n"
                + "              \"index\" : \"index\",\n"
                + "          \"alias\"\n"
                + "      \"nodeId1\" : [ ]\n"
                + "    \"templates\" : { },\n"
        assertFalse(noClusterManager1.supersedes(noClusterManager2));
                + "        \"state\" : \"open\",\n"
                + "              \"relocating_node\" : null,\n"
                + "      \"index\" : {\n"
        clusterState.toXContent(builder, new ToXContent.MapParams(singletonMap(Metadata.CONTEXT_MODE_PARAM, Metadata.CONTEXT_MODE_API)));
 */
                + "        {\n"
                    .add(new DiscoveryNode("nodeId1", new TransportAddress(InetAddress.getByName("127.0.0.1"), 111), Version.CURRENT))
                + "    \"indices\" : {\n"
                + "        \"shards\" : {\n"
                            RestStatus.ACCEPTED,
                    .persistentSettings(Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT.id).build())
                        CoordinationMetadata.builder()
                                {
            )
                + "    \"unassigned\" : [ ],\n"
 * Licensed to Elasticsearch under one or more contributor
                + "          ]\n"
                + "  \"master_node\" : \"clusterManagerNodeId\",\n"
                + "        \"levels\" : [\n"
                + "  \"routing_nodes\" : {\n"
                                        "nodeId2",
                + "        \"mapping_version\" : 1,\n"
                + "      \"term\" : 1,\n"
                        IndexRoutingTable.builder(new Index("index", "indexUUID"))
                + "          \"write\",\n"
                + "            \"allocationId\"\n"
    public void testToXContent() throws IOException {
                + "      }\n"
import org.opensearch.core.xcontent.XContentBuilder;
        ClusterState withClusterManager2 = ClusterState.builder(name)
                Metadata.builder()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                + "          ]\n"
                + "            \"met_conditions\" : { },\n"
            .metadata(
            "{\n"
                + "  \"master_node\" : \"clusterManagerNodeId\",\n"
                                    // the type name is the root value,
                                    new HashMap<String, Object>() {
import org.opensearch.core.rest.RestStatus;
                + "  \"cluster_manager_node\" : \"clusterManagerNodeId\",\n"
        builder.startObject();
                + "    \"indices\" : {\n"
                + "          ]\n"
                    )
            }
                            .addVotingConfigExclusion(new CoordinationMetadata.VotingConfigExclusion("exlucdedNodeId", "excludedNodeName"))
                + Version.CURRENT.id
        clusterState.toXContent(builder, new ToXContent.MapParams(mapParams));
 *     http://www.apache.org/licenses/LICENSE-2.0
                + "              \"node\" : \"nodeId2\",\n"
                + "            \"version\" : {\n"
                + "          \"node_name\" : \"excludedNodeName\"\n"
                + "        \"primary_terms\" : {\n"
        );
                + "            \"time\" : 1\n"
                + "        \"rollover_info\" : {\n"
                + "  \"blocks\" : { },\n"
 * license agreements. See the NOTICE file distributed with
                + "        \"settings\" : {\n"
            .build();
                + "      \"last_accepted_config\" : [\n"
    }
            .nodes(DiscoveryNodes.builder(nodes).clusterManagerNodeId(node1.getId()))
                + "  \"cluster_uuid\" : \"clusterUUID\",\n"
                + "          \"active_shard_ids\" : [\n"
                + "        \"system\" : false,\n"
    public void testToXContent_FlatSettingTrue_ReduceMappingFalse() throws IOException {
            .putRolloverInfo(new RolloverInfo("rolloveAlias", new ArrayList<>(), 1L))
            .putAlias(AliasMetadata.builder("alias").indexRouting("indexRouting").build())
                + "  \"routing_nodes\" : {\n"
                + "          ],\n"
                + "\",\n"
                + "      \"last_committed_config\" : [\n"
                        "index",
                + "          \"index\" : {\n"
                + Version.CURRENT.id
                + "          \"pattern2\"\n"
                + "        }\n"
                + "        {\n"
                + allocationId
                DiscoveryNodes.builder()
                + "        \"settings_version\" : 1,\n"
                + "      \"voting_config_exclusions\" : [ ]\n"
                + "          \"is_paused\" : false\n"
            "{\n"
 */
                + "        }\n"
        ClusterName name = CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY);
                + "          \"active_shard_ids\" : [\n"
                + "            \"time\" : 1\n"
    }
                + "          \"parent_to_child_shards\" : { }\n"
                + "          \"max_shard_id\" : 0,\n"
            {
                + "          }\n"
                                            put("type", new HashMap<String, Object>() {
package org.opensearch.cluster;
                + "        },\n"
                + "        \"levels\" : [\n"
                + "            \"key\" : \"value\"\n"
                + "              \"index\" : \"index\",\n"
        );
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
                + "        \"split_shards_metadata\" : {\n"
                + "              }\n"
    public void testSupersedes() {
/*
 * Unless required by applicable law or agreed to in writing,
                + "          \"0\" : 1\n"
                + "\"\n"
                + "          \"state\" : \"STARTED\",\n"
                + "\",\n"
                + "  \"cluster_uuid\" : \"clusterUUID\",\n"
        );
import java.util.EnumSet;
                + "                \"id\" : \""
                + "        },\n"
                + "          \"max_shard_id\" : 0,\n"
                + "          \"shard\" : 1,\n"
                + "  \"version\" : 0,\n"
                put("flat_settings", "true");
                + "      \"1\" : {\n"
            .putMapping(new MappingMetadata("type", new HashMap<String, Object>() {
                + "            \"number_of_shards\" : \"1\",\n"
                + "          \"node_name\" : \"excludedNodeName\"\n"
import org.opensearch.cluster.metadata.AliasMetadata;
        public EnumSet<Metadata.XContentContext> context() {
        @Override
                + "  \"metadata\" : {\n"
    }
        assertThat(
                        {
                + "    \"indices\" : {\n"
                + "            \"number_of_replicas\" : \"2\",\n"
                + "    },\n"
            builder.toString()
                + "            {\n"
                + "        \"rollover_info\" : {\n"
                + "    \"nodeId1\" : {\n"
        assertThat(expectThrows(NullPointerException.class, () -> builder.customs(map)).getMessage(), containsString(key));
                + "      \"last_accepted_config\" : [\n"
                + "    \"global\" : {\n"
                + "}",
                + "          \"active_shard_ids\" : [\n"
                    .addGlobalBlock(
                + "          \"index.number_of_replicas\" : \"2\",\n"
                            .patterns(Arrays.asList("pattern1", "pattern2"))
                + "          \"0\" : 1\n"
                    .addIndexBlock(
                + "          ]\n"
                + "        \"aliases\" : [ ],\n"
                + "          \"type\" : {\n"
                + "            }\n"
                + "      ],\n"
                                            });
                + "  \"routing_nodes\" : {\n"
                                    // the original logic in ClusterState.toXContent will reduce
                + "        },\n"
                + "              \"created\" : \""
                            .term(1)
            .numberOfReplicas(2)
                        IndexTemplateMetadata.builder("template")
                + "    \"unassigned\" : [ ],\n"
                                new MappingMetadata(
                + "      \"transport_address\" : \"127.0.0.1:111\",\n"
                + "          \"node_id\" : \"exlucdedNodeId\",\n"
                + "          \"read\",\n"
                + "              \"relocating_node\" : null,\n"
    }
                            )
                + "        },\n"
                + "          \"0\" : [\n"
                + "        },\n"
                + "          }\n"
                + "              \"searchOnly\" : false,\n"
                + "        \"settings_version\" : 1,\n"
                + "          \"metadata_write\",\n"
                + "          \"index\" : \"index\",\n"
                                new IndexShardRoutingTable.Builder(new ShardId("index", "_na_", 1)).addShard(
                + "        \"acceptedConfigurationNodeId\"\n"
        String allocationId = index.getShards().get(1).getAllAllocationIds().iterator().next();
        ClusterState withClusterManager1b = ClusterState.builder(name)
                            false,
                {
                put(Metadata.CONTEXT_MODE_PARAM, Metadata.CONTEXT_MODE_API);
import java.io.IOException;
                + "            \"allocationId\"\n"
                + "    \"unassigned\" : [ ],\n"
                            }))
                + "          \"read\",\n"
    public void testBuilderRejectsNullCustom() {
                + "\"\n"
import org.opensearch.cluster.block.ClusterBlock;
import org.opensearch.Version;
                + "      \"ephemeral_id\" : \""
                + "      }\n"
        // state from the same cluster-manager compare by version
        final DiscoveryNode node2 = new DiscoveryNode("node2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), version);
                + "  \"metadata\" : {\n"
                + "      \"name\" : \"\",\n"
import java.util.ArrayList;
                + "      }\n"
                + "          \"index\" : {\n"
        ClusterState noClusterManager2 = ClusterState.builder(name).version(randomInt(5)).nodes(nodes).build();
                + "    \"index-graveyard\" : {\n"
                + "            \"metadata_write\",\n"
                + "  }\n"
                            2,
                + "            \"type1\" : {\n"
                    .build()
                + "      ],\n"
                + "        \"disable_state_persistence\" : true,\n"
        ClusterState withClusterManager1a = ClusterState.builder(name)
                + "        \"order\" : 0,\n"
                + "              \"allocation_id\" : {\n"
                    add("allocationId");
                + "          \"relocating_node\" : null,\n"
import java.util.Arrays;
                                                    put("key", "value");
        clusterState.toXContent(builder, ToXContent.EMPTY_PARAMS);
                + "          \"index\" : \"index\",\n"
                + "    \"indices\" : { }\n"
                    .build()
                + "      \"voting_config_exclusions\" : [\n"
            )
                + "      ],\n"
                + "        \"state\" : \"open\",\n"
                + "            \"met_conditions\" : { },\n"
                + "          \"levels\" : [\n"
                + "      \"transport_address\" : \"127.0.0.1:111\",\n"
                + "        },\n"
            .stateUUID("stateUUID")
                + "  },\n"
                + "        \"system\" : false,\n"
                + "        \"primary_terms\" : {\n"
                + ephemeralId
                + "      \"term\" : 1,\n"
                + "        \"shards\" : {\n"
                + "            }\n"
                + "            \"type1\" : {\n"
                + "          \"shard\" : 1,\n"
                + "          ]\n"
            .nodes(DiscoveryNodes.builder(nodes).clusterManagerNodeId(node1.getId()))
    public void testToXContentSameTypeName() throws IOException {
                + "              \"searchOnly\" : false,\n"
                + "      }\n"
                + "    }\n"
            .version(randomInt(5))
                + "        \"settings_version\" : 1,\n"
 *
                + "  \"cluster_uuid\" : \"clusterUUID\",\n"
        }
                + "          \"levels\" : [\n"
                + "        \"levels\" : [\n"
                + "    }\n"
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
                    )
                + "        \"in_sync_allocations\" : {\n"
                + "  }\n"
                + "        \"primary_terms\" : {\n"
                + "  \"state_uuid\" : \"stateUUID\",\n"
import org.opensearch.cluster.routing.TestShardRouting;
                + "      \"last_committed_config\" : [ ],\n"
                + "        \"acceptedConfigurationNodeId\"\n"
                + "\"\n"
                + "    \"nodes\" : {\n"
                + "        {\n"
        final ClusterState clusterState = buildClusterState();
import static java.util.Collections.emptySet;
            )
        clusterState.toXContent(builder, new ToXContent.MapParams(mapParams));
                + "              \"searchOnly\" : false,\n"
                + "    \"cluster_uuid_committed\" : false,\n"
                + "    },\n"
 * ownership. Elasticsearch licenses this file to you under
                                        {
                + "              \"shard\" : 1,\n"
                            .putMapping(
                + "        },\n"
                + "        \"settings\" : {\n"
                + "        \"index_patterns\" : [\n"
import org.opensearch.common.xcontent.json.JsonXContent;
                + "      \"name\" : \"\",\n"
                + "    \"nodes\" : { }\n"
import java.util.HashMap;
                + "        \"primary_terms\" : {\n"
            return TYPE;
                + "      \"tombstones\" : [ ]\n"
                + "        \"aliases\" : [\n"
                + "      }\n"
        builder.endObject();
                            .settings(Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT.id))
import java.util.Collections;
                + "        \"2\" : {\n"
            .routingTable(
 * under the License.
import java.net.InetAddress;
                + "  \"routing_table\" : {\n"
                + "          \"pattern1\",\n"
                    .clusterUUID("clusterUUID")
                put("flat_settings", "false");
                + "          \"0\" : 1\n"
                + "        \"retryable\" : true,\n"
                + "        \"aliases\" : { }\n"
        final String key = randomAlphaOfLength(10);
                + "        \"rollover_info\" : {\n"
                + "              \"created\" : \""
                + "          ],\n"
                    .build()
                + "      }\n"
                + "          \"write\",\n"
                            false,
                + "        ],\n"
                + "          }\n"
                + "          \"node_id\" : \"exlucdedNodeId\",\n"
                + "            {\n"
                + "      \"term\" : 1,\n"
        String ephemeralId = clusterState.getNodes().get("nodeId1").getEphemeralId();
                    .addBlocks(indexMetadata)
                + "        \"routing_num_shards\" : 1,\n"
                + "            0\n"
            builder.toString()
            .build();
                + "          }\n"
                + "            \"type1\" : {\n"
                + "        \"ingestion_status\" : {\n"
                + "    }\n"
                + allocationId
                + "          \"create_index\"\n"
        builder.endObject();
import org.opensearch.cluster.routing.IndexRoutingTable;
                + "          }\n"
                + "  \"state_uuid\" : \"stateUUID\",\n"
                + "  \"cluster_manager_node\" : null,\n"
                + "        },\n"
                + "    \"templates\" : {\n"
                + "          \"state\" : \"STARTED\",\n"
                + "          \"pattern2\"\n"
                {
                + "        \"settings\" : {\n"
            )
                + "              \"state\" : \"STARTED\",\n"
                + "        \"aliases\" : [\n"
                + "          \"is_paused\" : false\n"
                        new ClusterBlock(
            .stateUUID("stateUUID")
        };
                + "        \"primary_terms_map\" : {\n"
                + "  \"blocks\" : {\n"
                + "    \"cluster_coordination\" : {\n"
                + "        },\n"
        final DiscoveryNode node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), version);
                + "        ],\n"
                + "        \"settings\" : {\n"
                + "      \"index\" : {\n"
                + "  \"routing_table\" : {\n"
                + "              \"node\" : \"nodeId2\",\n"
                + "    \"nodes\" : {\n"
        IndexRoutingTable index = clusterState.getRoutingTable().getIndicesRouting().get("index");
                + "        }\n"
                + "\"\n"
                + "              \"allocation_id\" : {\n"
 * GitHub history for details.
                + "        \"commitedConfigurationNodeId\"\n"
                + "          }\n"
                + "  },\n"
                + "          ],\n"
                + "    },\n"
            .build();
            return EnumSet.of(Metadata.XContentContext.GATEWAY, Metadata.XContentContext.SNAPSHOT);
                + "            \"version\" : {\n"
                + "          \"retryable\" : false,\n"
            }
                + "        \"2\" : {\n"
                + "              \"key\" : \"value\"\n"
                + "      \"template\" : {\n"
import org.opensearch.cluster.metadata.MappingMetadata;
                + "            \"version\" : {\n"
                + "    \"indices\" : {\n"
        String ephemeralId = clusterState.getNodes().get("nodeId1").getEphemeralId();
                + "        ]\n"
                + "      ],\n"
                + ephemeralId
                                    add("commitedConfigurationNodeId");
                            .build()
                + "        \"description\" : \"description\",\n"
        Map<String, String> mapParams = new HashMap<String, String>() {
                + "          \"max_shard_id\" : 0,\n"
import org.opensearch.cluster.block.ClusterBlocks;
                + "      }\n"
                + "          }\n"
                + "          \"is_paused\" : false\n"
                put(Metadata.CONTEXT_MODE_PARAM, Metadata.CONTEXT_MODE_API);
            super(data);
                + "        \"version\" : 1,\n"
 */
/*
        }
                + "      ],\n"
 * compatible open source license.
                + "          \"relocating_node\" : null,\n"
                + "    \"index-graveyard\" : {\n"
                + "  \"blocks\" : {\n"
                                                {
                + "          \"relocating_node\" : null,\n"
                + "    \"cluster_uuid\" : \"clusterUUID\",\n"
                            .addIndexShard(
                + "        \"mappings\" : {\n"
                + "        \"description\" : \"description\",\n"
                + "      \"transport_address\" : \"127.0.0.1:111\",\n"
                + "    },\n"
 * software distributed under the License is distributed on an
                + "        }\n"
                + "    \"cluster_coordination\" : {\n"
                + "            \"create_index\"\n"
    public void testToXContent_FlatSettingFalse_ReduceMappingTrue() throws IOException {
                + "  },\n"
                + "          \"num_of_root_shards\" : 1,\n"
                + "            \"number_of_replicas\" : \"2\",\n"
                + "    }\n"
                + "          \"type\" : {\n"
                                                }
                + "        \"disable_state_persistence\" : true,\n"
                + "        \"in_sync_allocations\" : {\n"
                + "        \"aliases\" : [\n"
                + "            \"id\" : \""
                + "            \"version\" : {\n"
                + "          ]\n"
                + "      \"nodeId2\" : [\n"
            }))
                + "      \"1\" : {\n"
                + "        \"primary_terms_map\" : {\n"
                + "            }\n"
                + "        },\n"
                + "    \"nodeId1\" : {\n"
                + "        \"settings\" : {\n"
                + "            \"number_of_shards\" : \"1\",\n"
                + "          \"index\" : {\n"
import static java.util.Collections.singletonMap;
                            .primaryTerm(0, 1L)
                + "          \"num_of_root_shards\" : 1,\n"
        final ClusterState.Builder builder = ClusterState.builder(ClusterName.DEFAULT);
                + "\"\n"
                            false,
                + "          \"levels\" : [\n"
        final DiscoveryNodes nodes = DiscoveryNodes.builder().add(node1).add(node2).build();
                + "              \"created\" : \""
import static java.util.Collections.emptyMap;
                + "          \"allocation_id\" : {\n"
                + "        {\n"
                + "        \"settings\" : {\n"
                + "          \"node\" : \"nodeId2\",\n"
                + "    }\n"
                + "          \"type\" : {\n"
                + "      \"nodeId2\" : [\n"
        assertEquals(
                + "      \"voting_config_exclusions\" : [\n"
        public String getWriteableName() {
                + "              \"key\" : \"value\"\n"
                + "      \"nodeId1\" : [ ]\n"
                        )
                + "\"\n"
                                }
                + "          \"active_shard_ids\" : [\n"
        assertFalse(withClusterManager1a.supersedes(withClusterManager2));
                + "          \"description\" : \"description2\",\n"
                + "          \"pattern1\",\n"
                + "          \"rolloveAlias\" : {\n"
                            .putMapping("type", "{ \"key1\": {} }")
                + "      \"index\" : {\n"
                + "        },\n"
                            .order(0)
        // states should never supersede states from another cluster-manager
                                    "type",
                + "          \"description\" : \"description2\",\n"
                + "          }\n"
                + "          \"alias\"\n"
                + "  },\n"
                + "        \"split_shards_metadata\" : {\n"
                + "\"\n"
                + "    \"cluster_uuid\" : \"clusterUUID\",\n"
                + "          \"searchOnly\" : false,\n"
            builder.toString()
                + "            }\n"
                    .transientSettings(Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT.id).build())
                + "        \"version\" : 2,\n"
                + "\",\n"
        final ClusterState clusterState = buildClusterState();
                + "          ],\n"
import org.opensearch.core.index.shard.ShardId;
                    .coordinationMetadata(CoordinationMetadata.builder().build())
                + "  },\n"
                + "        \"shards\" : {\n"
                + "          \"description\" : \"description2\",\n"
                            .numberOfReplicas(2)
                + "          \"metadata_read\",\n"
                + "            \"metadata_read\",\n"
                + "          \"0\" : 1\n"
                + "    \"cluster_uuid_committed\" : false,\n"
            {
                + "            \"version\" : {\n"
                + "\"\n"
                                ).build()
                + "    },\n"
                + "            \"id\" : \""
import java.util.Map;
import org.opensearch.core.xcontent.ToXContent;
        mapBuilder.put(key, null);
                + "  },\n"
                + "        },\n"
        builder.startObject();
import org.opensearch.cluster.routing.ShardRoutingState;
                + "        }\n"
                            )
import org.opensearch.cluster.node.DiscoveryNodes;
                + "    },\n"
            .nodes(DiscoveryNodes.builder(nodes).clusterManagerNodeId(node2.getId()))
import org.opensearch.cluster.node.DiscoveryNode;
                + "            \"id\" : \""
                + "        }\n"
                + "          ]\n"
import org.opensearch.cluster.metadata.Metadata;
                + "\"\n"
                + "          \"read\",\n"
                + "          \"index\" : {\n"
                + "      ]\n"
                + "    }\n"
                + "        \"system\" : false,\n"
                            EnumSet.allOf((ClusterBlockLevel.class))
                + "        \"mapping_version\" : 1,\n"
 * You may obtain a copy of the License at
                + "        },\n"
                                }
                + "      \"index\" : {\n"
        assertFalse(withClusterManager1a.supersedes(noClusterManager1));
        builder.endObject();
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
            .primaryTerm(0, 1L)
                + allocationId
            .settings(Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT.id))
                + "            \"metadata_read\",\n"
        IndexRoutingTable index = clusterState.getRoutingTable().getIndicesRouting().get("index");
                + "        },\n"
                + "          \"metadata_write\",\n"
                + "    },\n"
                + "      \"nodeId1\" : [ ]\n"
                + "    },\n"
                + "      \"index\" : {\n"
                + "          \"allocation_id\" : {\n"
        }
                + "      ]\n"
                                    )
                + "          }\n"
                + "          \"primary\" : true,\n"
                + "    },\n"
                + "  \"nodes\" : {\n"
                + "        \"settings_version\" : 1,\n"
                + "      \"ephemeral_id\" : \""
            "{\n"
