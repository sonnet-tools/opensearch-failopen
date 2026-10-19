                    + "    },\n"  
import org.opensearch.cluster.routing.allocation.command.AllocateReplicaAllocationCommand;
 * GitHub history for details.
            XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();  
                    + "    \"metadata\" : {\n"
            );
 * this work for additional information regarding copyright
import org.opensearch.cluster.node.DiscoveryNode;  
        routingExplanations.add(new RerouteExplanation(new AllocateReplicaAllocationCommand("index", 0, "node0"), Decision.YES));
        final HashMap<String, IndexMetadata> openMapBuilder = new HashMap<>();
import org.opensearch.cluster.metadata.Metadata;
                    .put(IndexSettings.MAX_SCRIPT_FIELDS_SETTING.getKey(), 10)  
                    + "    \"state_uuid\" : \""
                "{\n"
                "{\n"
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
                    + node0.getEphemeralId()
        Metadata metadata = Metadata.builder().indices(openMapBuilder).build();  
/*  
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                    + "    \"version\" : 0,\n"
 * software distributed under the License is distributed on an
                    + "            \"active_shard_ids\" : [\n"  
                    + "        \"transport_address\" : \"0.0.0.0:9000\",\n"  
                    + "  \"state\" : {\n"
                builder.toString()
                    + "          \"primary_terms_map\" : {\n"
                    + "        \"node\" : \"node0\"\n"
                    + "            \"num_of_root_shards\" : 1,\n"  
                    + "          \"state\" : \"open\",\n"
                    + "      }\n"  
        }  
            params.put("metric", "metadata");
                    + "          },\n"
                    + "            \"root_shards_to_all_children\" : { },\n"
                    + "      \"index-graveyard\" : {\n"
                    + "    \"cluster_manager_node\" : \"node0\"\n"
                    + "      \"decisions\" : [\n"  
            Map<String, String> params = new HashMap<>();
                    + "    },\n"
                    + "      \"command\" : \"allocate_replica\",\n"  
 * Licensed to Elasticsearch under one or more contributor  
                    + "    },\n"
import org.opensearch.common.xcontent.json.JsonXContent;
import org.opensearch.Version;
                    + "      \"node0\" : {\n"
            Map<String, String> params = new HashMap<>();  
                    + "\",\n"
import org.opensearch.core.common.transport.TransportAddress;
                    + "          },\n"
 * The OpenSearch Contributors require contributions made to  
                    + "          },\n"  
                    + "            \"is_paused\" : false\n"  
                    + "            \"0\" : [ ]\n"
                    + "                \"check_on_startup\" : \"true\"\n"
                    + "          \"mappings\" : { },\n"
                    + "          },\n"
                    + "          \"ingestion_status\" : {\n"
                    + "          \"primary_terms_map\" : {\n"  
import org.opensearch.core.xcontent.XContentBuilder;
                    + "      },\n"  
                    + "        \"ephemeral_id\" : \""  
                    + "        \"tombstones\" : [ ]\n"  
package org.opensearch.action.admin.cluster.reroute;
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                    + "      }\n"  
                    + "      \"cluster_coordination\" : {\n"
                    + "            \"parent_to_child_shards\" : { }\n"  
                    + "          \"routing_num_shards\" : 1,\n"
            XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
                    + "    \"cluster_uuid\" : \"_na_\",\n"  
                    + "          \"settings\" : {\n"  
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
                    + "          \"aliases_version\" : 1,\n"
                    + "  \"state\" : {\n"
                    + "          \"decision\" : \"YES\",\n"  
                    .put(IndexSettings.INDEX_CHECK_ON_STARTUP.getKey(), true)
                    + "          \"mapping_version\" : 1,\n"
 */  
 */
                    + "      \"indices\" : {\n"
                Settings.builder()
                    + "    \"routing_table\" : {\n"
import org.opensearch.cluster.routing.allocation.RerouteExplanation;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    + "\",\n"
                    + "          \"primary_terms\" : {\n"  
                    + "          },\n"
import org.opensearch.index.IndexSettings;
                    + "      },\n"
/*
                    + "    \"routing_nodes\" : {\n"
                    + "        \"last_committed_config\" : [ ],\n"
        DiscoveryNodes nodes = new DiscoveryNodes.Builder().add(node0).clusterManagerNodeId(node0.getId()).build();
                    + "  },\n"  
                builder.toString()
 * not use this file except in compliance with the License.
                    + "}",  
        openMapBuilder.put("index", indexMetadata);
                    + "            }\n"  
import java.util.Map;
                    + "    }\n"
                    + "            }\n"
 * KIND, either express or implied.  See the License for the
                    + "      \"templates\" : { },\n"  
                    + "}",  
                    + "          \"explanation\" : \"none\"\n"
                    + "              0\n"  
                    + "  }\n"  
                    + "        \"attributes\" : { }\n"
                    + "        }\n"
import java.io.IOException;
                    + clusterState.stateUUID()  
                    + "    \"cluster_manager_node\" : \"node0\",\n"
                    + "              0\n"
                    + "          \"split_shards_metadata\" : {\n"  
                    + "    \"nodes\" : {\n"  
                    + "      },\n"
                    + "              }\n"
                    + "              \"max_script_fields\" : \"10\",\n"
                    + "      \"parameters\" : {\n"
                    + "        \"last_committed_config\" : [ ],\n"  
        }
                    + "          \"version\" : 1,\n"  
            )
                    + "          \"rollover_info\" : { },\n"  
                    + "        \"name\" : \"\",\n"
                    + "    \"master_node\" : \"node0\",\n"  
                    + "      \"index-graveyard\" : {\n"
                    + "      },\n"
                    + "      \"templates\" : { },\n"
import org.opensearch.cluster.routing.allocation.decider.Decision;
 */  
        RoutingExplanations routingExplanations = new RoutingExplanations();  
                    .build()
import org.opensearch.common.settings.Settings;  
                    + "            \"index\" : {\n"
            );
 * You may obtain a copy of the License at  
                    + "  \"acknowledged\" : true,\n"  
                    + "      \"cluster_uuid\" : \"_na_\",\n"
                    + "        \"tombstones\" : [ ]\n"
import org.opensearch.cluster.ClusterState;  
                    + "          \"split_shards_metadata\" : {\n"
            params.put("settings_filter", "index.number*,index.version.created");
                    + "\",\n"
                    + "      \"cluster_uuid_committed\" : false,\n"
                    + "        {\n"
                    + "          \"aliases\" : [ ],\n"
                    + "          \"settings_version\" : 1,\n"
            assertEquals(  
                    + "            \"is_paused\" : false\n"
                    + "        \"index\" : {\n"
                    + "          },\n"
}  
                    + "        \"node0\" : [ ]\n"
                    + "        \"voting_config_exclusions\" : [ ]\n"
                    + "              \"number_of_shards\" : \"1\",\n"  
                    + "                \"check_on_startup\" : \"true\"\n"
                    + "      \"unassigned\" : [ ],\n"  
                    + "            \"num_of_root_shards\" : 1,\n"
                    + "              },\n"
import org.opensearch.core.xcontent.ToXContent;  
                    + "    {\n"
        DiscoveryNode node0 = new DiscoveryNode("node0", new TransportAddress(TransportAddress.META_ADDRESS, 9000), Version.CURRENT);  
                    + "          },\n"
    public void testToXContent() throws IOException {
            clusterRerouteResponse.toXContent(builder, new ToXContent.MapParams(params));  
                "{\n"  
                    + "              \"version\" : {\n"
                    + "          \"ingestion_status\" : {\n"  
 *
                    + "      }\n"
/*  
                    + "            \"max_shard_id\" : 0,\n"
 *  
        }
        {
                    + "          \"mappings\" : { },\n"
                    + "          \"settings_version\" : 1,\n"  
            .settings(  
                    + "    \"cluster_uuid\" : \"_na_\",\n"
                    + "          },\n"  
            params.put("explain", "true");
            clusterRerouteResponse.toXContent(builder, ToXContent.EMPTY_PARAMS);
                    + "          },\n"  
        {
            );  
import org.opensearch.cluster.metadata.IndexMetadata;
                    + "    \"version\" : 0,\n"
        ClusterRerouteResponse clusterRerouteResponse = new ClusterRerouteResponse(true, clusterState, routingExplanations);
                    + "        \"term\" : 0,\n"
        {  
                    + "              \"shard\" : {\n"  
                    + "                \"created\" : \""  
                    + "      \"nodes\" : {\n"
                    + "        \"last_accepted_config\" : [ ],\n"  
                    + "          \"version\" : 1,\n"
                    + "      \"cluster_coordination\" : {\n"  
                    + "          \"aliases\" : [ ],\n"  
                    + "            \"index\" : {\n"
 *    http://www.apache.org/licenses/LICENSE-2.0
                    + "          \"primary_terms\" : {\n"
                    + "    \"blocks\" : { },\n"
                    + "      \"indices\" : { }\n"  
                    + "            ],\n"
                    + "    \"cluster_uuid\" : \"_na_\",\n"
                    + "  \"acknowledged\" : true,\n"
                    + "            \"0\" : 0\n"
                    + "          \"in_sync_allocations\" : {\n"
                    + "          },\n"  
                    + "            ],\n"
                    + "    }\n"
            .build();  
                    + "  ]\n"
                    + Version.CURRENT.id
                    + "        \"voting_config_exclusions\" : [ ]\n"
 *
                    + "}",
                    + "          \"rollover_info\" : { },\n"
                    + "    \"state_uuid\" : \""  
                    + "          }\n"
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.routing.allocation.RoutingExplanations;  
                    + "          \"mapping_version\" : 1,\n"
 * SPDX-License-Identifier: Apache-2.0
                    + "  \"acknowledged\" : true,\n"
            clusterRerouteResponse.toXContent(builder, new ToXContent.MapParams(params));
import org.opensearch.cluster.ClusterName;
    }
import org.opensearch.test.OpenSearchTestCase;  
        IndexMetadata indexMetadata = IndexMetadata.builder("index")
 * compatible open source license.
                    + "            \"parent_to_child_shards\" : { }\n"
                    + "      },\n"  
                    + "          \"system\" : false,\n"
 * the Apache License, Version 2.0 (the "License"); you may
                    + "        \"shard\" : 0,\n"  
                    + "\"\n"
                    + "    \"metadata\" : {\n"  
            XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
import org.opensearch.cluster.node.DiscoveryNodes;
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).nodes(nodes).metadata(metadata).build();
                    + "      \"indices\" : {\n"
                    + "  \"explanations\" : [\n"
                    + "            \"0\" : 0\n"
                    + "              \"max_script_fields\" : \"10\"\n"
                    + "        }\n"
            assertEquals(
                    + "  }\n"
 * license agreements. See the NOTICE file distributed with
                    + "        }\n"  
                    + "        \"index\" : {\n"  
                    + "            \"0\" : 0\n"
                    + clusterState.stateUUID()
                    + "      \"cluster_uuid\" : \"_na_\",\n"
                    + "            \"0\" : 0\n"
                    + "      }\n"
                    + "          \"aliases_version\" : 1,\n"  
                    + "            \"active_shard_ids\" : [\n"
                    + "            \"root_shards_to_all_children\" : { },\n"  
                    + "          }\n"
                    + "      ]\n"  
                    + "          \"system\" : false,\n"
                    + "              },\n"  
            params.put("metric", "version,cluster_manager_node");  
                builder.toString()
                    + "        \"term\" : 0,\n"
                    + "    }\n"
                    + "              \"number_of_replicas\" : \"0\",\n"
 * under the License.  
public class ClusterRerouteResponseTests extends OpenSearchTestCase {  
                    + "          \"routing_num_shards\" : 1,\n"
                    + "          \"in_sync_allocations\" : {\n"  
import java.util.HashMap;  
                    + "              \"shard\" : {\n"  
                    + "        \"index\" : \"index\",\n"
                    + "  \"state\" : {\n"  
 * Unless required by applicable law or agreed to in writing,
                    + "          \"state\" : \"open\",\n"  
                    + "            \"max_shard_id\" : 0,\n"
                    + "      \"cluster_uuid_committed\" : false,\n"  
                    + "          \"decider\" : null,\n"
            assertEquals(
                    + "            \"0\" : [ ]\n"
                    + "          \"settings\" : {\n"
                    + "        \"last_accepted_config\" : [ ],\n"
