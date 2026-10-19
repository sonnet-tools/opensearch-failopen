                    + "              \"version\" : {\n"
                    + "          \"rollover_info\" : { },\n"
        DiscoveryNodes nodes = new DiscoveryNodes.Builder().add(node0).clusterManagerNodeId(node0.getId()).build();
                    + "      \"parameters\" : {\n"
                    + "      },\n"
            params.put("metric", "version,cluster_manager_node");
            assertEquals(
                    + "          }\n"
import org.opensearch.Version;
                    + "            \"index\" : {\n"
                    + "      \"index-graveyard\" : {\n"
                    + "          \"version\" : 1,\n"
                    + "          \"routing_num_shards\" : 1,\n"
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                    + "                \"check_on_startup\" : \"true\"\n"
                    + "      },\n"
                    + "            ],\n"
                    + "          \"ingestion_status\" : {\n"
 * specific language governing permissions and limitations
        routingExplanations.add(new RerouteExplanation(new AllocateReplicaAllocationCommand("index", 0, "node0"), Decision.YES));
                    + "\"\n"
                    + "      \"indices\" : { }\n"
 * the Apache License, Version 2.0 (the "License"); you may
                    + "          \"rollover_info\" : { },\n"
import org.opensearch.cluster.routing.allocation.RoutingExplanations;
            )
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
                Settings.builder()
                    + "      \"cluster_uuid_committed\" : false,\n"
                    + "  }\n"
                    + "          \"ingestion_status\" : {\n"
                    + "          },\n"
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
 * KIND, either express or implied.  See the License for the
                    + "    }\n"
                    + "      }\n"
                    + "          \"mappings\" : { },\n"
                    + "          },\n"
            XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
            Map<String, String> params = new HashMap<>();
                    + "    \"version\" : 0,\n"
import org.opensearch.cluster.ClusterName;
 * this file be licensed under the Apache-2.0 license or a
                    + "    \"routing_nodes\" : {\n"
import org.opensearch.cluster.routing.allocation.RerouteExplanation;
            params.put("explain", "true");
                    + "          \"aliases\" : [ ],\n"
                    + "          }\n"
                    + "    },\n"
                    + "            \"0\" : [ ]\n"
    }
            clusterRerouteResponse.toXContent(builder, new ToXContent.MapParams(params));
                    + clusterState.stateUUID()
                    + "}",
                    + "            \"is_paused\" : false\n"
                    + "            \"0\" : 0\n"
                    + "              \"max_script_fields\" : \"10\"\n"
                    + "            \"0\" : [ ]\n"
                    + "        \"term\" : 0,\n"
                    + "          },\n"
                    + "          \"aliases\" : [ ],\n"
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).nodes(nodes).metadata(metadata).build();
                    + "          \"decision\" : \"YES\",\n"
}
        DiscoveryNode node0 = new DiscoveryNode("node0", new TransportAddress(TransportAddress.META_ADDRESS, 9000), Version.CURRENT);
                    + "  },\n"
                    + "          },\n"
                    + "        \"term\" : 0,\n"
                    + "          \"primary_terms\" : {\n"
            );
import org.opensearch.cluster.ClusterState;
                    + "          \"primary_terms\" : {\n"
                    + "        \"attributes\" : { }\n"
                    + "            \"max_shard_id\" : 0,\n"
    public void testToXContent() throws IOException {
                    + "        \"tombstones\" : [ ]\n"
        Metadata metadata = Metadata.builder().indices(openMapBuilder).build();
                    + "      \"cluster_coordination\" : {\n"
                    + "    \"state_uuid\" : \""
                    + clusterState.stateUUID()
        }
/*
                    + "        }\n"
                    + "          \"aliases_version\" : 1,\n"
                    + "              \"number_of_replicas\" : \"0\",\n"
import java.util.Map;
                    .build()
                    + "          \"primary_terms_map\" : {\n"
/*
                    + "    }\n"
                    + "        \"voting_config_exclusions\" : [ ]\n"
                    + "}",
                    + "        \"node0\" : [ ]\n"
                    + "              \"shard\" : {\n"
                    + "        \"voting_config_exclusions\" : [ ]\n"
        {
                    + "  \"state\" : {\n"
                    + "          },\n"
                    + "            }\n"
        openMapBuilder.put("index", indexMetadata);
import java.util.HashMap;
 * compatible open source license.
                    + "            \"root_shards_to_all_children\" : { },\n"
 *
import org.opensearch.common.xcontent.json.JsonXContent;
                    + "          \"settings_version\" : 1,\n"
import org.opensearch.index.IndexSettings;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    + "\",\n"
 * software distributed under the License is distributed on an
            );
                    + "  }\n"
                    + "            \"0\" : 0\n"
                    + "          \"mappings\" : { },\n"
                    + "    \"cluster_uuid\" : \"_na_\",\n"
                    + "          },\n"
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                    + "        \"index\" : {\n"
        }
                    + "        }\n"
public class ClusterRerouteResponseTests extends OpenSearchTestCase {
 * ownership. Elasticsearch licenses this file to you under
 */
                builder.toString()
                    + "          },\n"
        IndexMetadata indexMetadata = IndexMetadata.builder("index")
                    + "          \"settings\" : {\n"
/*
                    + "      \"indices\" : {\n"
                    + "          \"decider\" : null,\n"
                    + "    },\n"
                    + "  \"acknowledged\" : true,\n"
                builder.toString()
                    + "        \"last_committed_config\" : [ ],\n"
                    + "        \"node\" : \"node0\"\n"
                    + "      }\n"
                    + "            \"is_paused\" : false\n"
                    + "          \"system\" : false,\n"
                    + "  \"state\" : {\n"
        RoutingExplanations routingExplanations = new RoutingExplanations();
                    + "            ],\n"
                    + Version.CURRENT.id
                    + "      \"cluster_coordination\" : {\n"
                    + "      },\n"
                    + "            \"parent_to_child_shards\" : { }\n"
                    + "      \"command\" : \"allocate_replica\",\n"
                    + "    \"cluster_uuid\" : \"_na_\",\n"
                    + "        \"last_accepted_config\" : [ ],\n"
 * SPDX-License-Identifier: Apache-2.0
                    + "            \"active_shard_ids\" : [\n"
            XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
            params.put("metric", "metadata");
                    + "    \"routing_table\" : {\n"
                    + "        \"index\" : {\n"
                    + "    },\n"
                    + "      \"nodes\" : {\n"
                    + "        }\n"
import org.opensearch.cluster.metadata.IndexMetadata;
                    + "          \"settings_version\" : 1,\n"
            assertEquals(
 */
                    + "              },\n"
                    + "      \"cluster_uuid_committed\" : false,\n"
                    + "  \"acknowledged\" : true,\n"
import org.opensearch.common.settings.Settings;
                    .put(IndexSettings.INDEX_CHECK_ON_STARTUP.getKey(), true)
                    + "      },\n"
                    + "              0\n"
                    + "                \"check_on_startup\" : \"true\"\n"
                    + "      \"decisions\" : [\n"
                    + "      \"templates\" : { },\n"
                    + "        \"name\" : \"\",\n"
                    + "              \"shard\" : {\n"
                    + "            }\n"
                    + "              },\n"
 * Unless required by applicable law or agreed to in writing,
            .build();
                    + "    \"nodes\" : {\n"
                    + "            \"parent_to_child_shards\" : { }\n"
                    + "          \"settings\" : {\n"
                    + "      ]\n"
                    + "      }\n"
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at
package org.opensearch.action.admin.cluster.reroute;
 * under the License.
                    + "  \"state\" : {\n"
                    + "      \"unassigned\" : [ ],\n"
                "{\n"
                    + "            \"0\" : 0\n"
                    + "    \"metadata\" : {\n"
                    + "          \"primary_terms_map\" : {\n"
                    + "          \"split_shards_metadata\" : {\n"
import org.opensearch.cluster.routing.allocation.decider.Decision;
                    + "  \"explanations\" : [\n"
                    + "      \"index-graveyard\" : {\n"
                    + "          \"mapping_version\" : 1,\n"
                    + "    \"master_node\" : \"node0\",\n"
import org.opensearch.core.xcontent.ToXContent;
                builder.toString()
                    + "          },\n"
                    + "            \"num_of_root_shards\" : 1,\n"
                    + "          \"version\" : 1,\n"
                    + "    \"cluster_manager_node\" : \"node0\",\n"
                    + "              0\n"
            clusterRerouteResponse.toXContent(builder, ToXContent.EMPTY_PARAMS);
                    + "        \"last_accepted_config\" : [ ],\n"
            assertEquals(
                    + "              \"max_script_fields\" : \"10\",\n"
 */
            .settings(
                    + "    \"cluster_manager_node\" : \"node0\"\n"
        }
import org.opensearch.cluster.metadata.Metadata;
                    + "          },\n"
                    + "            \"0\" : 0\n"
                    + node0.getEphemeralId()
                    + "            \"max_shard_id\" : 0,\n"
                    + "          \"explanation\" : \"none\"\n"
                    + "    \"version\" : 0,\n"
                    + "          \"system\" : false,\n"
                    + "        \"last_committed_config\" : [ ],\n"
            params.put("settings_filter", "index.number*,index.version.created");
                    + "      }\n"
                    .put(IndexSettings.MAX_SCRIPT_FIELDS_SETTING.getKey(), 10)
                    + "              }\n"
import org.opensearch.core.common.transport.TransportAddress;
                    + "      \"templates\" : { },\n"
                "{\n"
                    + "  ]\n"
                    + "        \"transport_address\" : \"0.0.0.0:9000\",\n"
            Map<String, String> params = new HashMap<>();
                    + "          \"state\" : \"open\",\n"
            clusterRerouteResponse.toXContent(builder, new ToXContent.MapParams(params));
                    + "        \"shard\" : 0,\n"
                    + "              \"number_of_shards\" : \"1\",\n"
                    + "      },\n"
                    + "          \"split_shards_metadata\" : {\n"
        {
                    + "      \"indices\" : {\n"
                    + "            \"num_of_root_shards\" : 1,\n"
                    + "    \"metadata\" : {\n"
                    + "          \"in_sync_allocations\" : {\n"
                    + "    \"cluster_uuid\" : \"_na_\",\n"
            );
                    + "          \"aliases_version\" : 1,\n"
        {
import org.opensearch.cluster.routing.allocation.command.AllocateReplicaAllocationCommand;
                    + "      \"cluster_uuid\" : \"_na_\",\n"
                "{\n"
import org.opensearch.test.OpenSearchTestCase;
                    + "  \"acknowledged\" : true,\n"
                    + "    {\n"
 *
                    + "\",\n"
                    + "      \"cluster_uuid\" : \"_na_\",\n"
                    + "            \"index\" : {\n"
 *
                    + "\",\n"
import org.opensearch.cluster.node.DiscoveryNode;
            XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
                    + "          \"mapping_version\" : 1,\n"
import org.opensearch.core.xcontent.XContentBuilder;
import java.io.IOException;
                    + "          \"routing_num_shards\" : 1,\n"
                    + "          \"in_sync_allocations\" : {\n"
                    + "        \"ephemeral_id\" : \""
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.cluster.node.DiscoveryNodes;
                    + "                \"created\" : \""
                    + "            \"active_shard_ids\" : [\n"
                    + "          \"state\" : \"open\",\n"
                    + "            \"root_shards_to_all_children\" : { },\n"
                    + "    }\n"
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
                    + "        \"tombstones\" : [ ]\n"
        ClusterRerouteResponse clusterRerouteResponse = new ClusterRerouteResponse(true, clusterState, routingExplanations);
                    + "    \"state_uuid\" : \""
                    + "        {\n"
 * The OpenSearch Contributors require contributions made to
                    + "      \"node0\" : {\n"
                    + "          },\n"
 * not use this file except in compliance with the License.
                    + "        \"index\" : \"index\",\n"
                    + "    \"blocks\" : { },\n"
        final HashMap<String, IndexMetadata> openMapBuilder = new HashMap<>();
                    + "}",
