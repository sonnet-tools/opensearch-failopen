            .put(idx1, false)
                + "          ],\n"
        };
                + "    },\n"
                    ),
    private static final String ALIAS_FILTER2 = "{\"field2\":\"value2\"}";
                new Template(
                + Version.CURRENT.id
                + "      \"tombstones\" : [ ]\n"
                + "            \"allocationId\"\n"
                IndexMetadata.builder("index")
        builder.startObject();
                + "        },\n"
                    .creationDate(2L)
import org.opensearch.common.xcontent.json.JsonXContent;
                + "      ]\n"
        assertThat(parsedMetadata.templatesV2().get("index_templatev2").priority(), is(5L));
                + "        \"commitedConfigurationNodeId\"\n"
            {
                    .primaryTerm(0, 1L)
                + "        \"ingestion_status\" : {\n"
                + "    },\n"
        @Override
import static org.opensearch.cluster.DataStreamTestHelper.createFirstBackingIndex;
                + "            }\n"
                        {
                        {
        public EnumSet<Metadata.XContentContext> context() {
                    .numberOfShards(1)
                + "      \"voting_config_exclusions\" : [\n"
                "index_templatev2",
                    ),
                + "    }\n"
        assertEquals(
                + "          \"0\" : 1\n"
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
 * this file be licensed under the Apache-2.0 license or a
    public void testToXContentGateway_FlatSettingFalse_ReduceMappingTrue() throws IOException {
                + "          }\n"
            equalTo(
                    .build()
                + "            }\n"
                + "      }\n"
        metadata.toXContent(builder, new ToXContent.MapParams(mapParams));
    private static final String ALIAS_FILTER1 = "{\"field1\":\"value1\"}";
                            new HashMap<String, Object>() {
        assertThat(parsedMetadata.dataStreams().get("data-stream1").getTimeStampField().getName(), is("@timestamp"));
                + "  }\n"
        assertThat(
        };
                + "            \"version\" : {\n"
                + "            \"type1\" : {\n"
import static org.opensearch.cluster.metadata.AliasMetadata.newAliasMetadataBuilder;
                + "          \"node_id\" : \"exlucdedNodeId\",\n"
                + "      \"last_accepted_config\" : [\n"
                + "        ],\n"
            )
                + "          \"0\" : 1\n"
    public void testSimpleJsonFromAndTo() throws IOException {
                )
                + "    \"settings\" : {\n"
                + "          \"0\" : 1\n"
                + "          \"alias\"\n"
        assertThat(
                + "          \"pattern2\"\n"
                + "      \"index\" : {\n"
                + "        \"primary_terms\" : {\n"
        metadata.toXContent(builder, new ToXContent.MapParams(mapParams));
        );
            .clusterUUID("clusterUUID")
                + "          \"active_shard_ids\" : [\n"
                + "        \"settings\" : {\n"
                + "          }\n"
                + "}",
        Metadata metadata = buildMetadata();
                    .settings(settings(Version.CURRENT).put("setting1", "value1").put("setting2", "value2"))
                + "      \"index\" : {\n"
                    .state(IndexMetadata.State.OPEN)
                CoordinationMetadata.builder()
                + "        }\n"
            .coordinationMetadata(CoordinationMetadata.builder().build())
                + Version.CURRENT.id
import java.util.HashMap;
                    .putAlias(newAliasMetadataBuilder("alias-bar2").filter("{\"term\":{\"user\":\"foobar\"}}"))
                + "        \"index_patterns\" : [\n"
                + "    },\n"
            )
                + "        \"order\" : 0,\n"
                put(Metadata.CONTEXT_MODE_PARAM, CONTEXT_MODE_GATEWAY);
        assertThat(
                + "            \"number_of_shards\" : \"1\",\n"
                + "      \"last_committed_config\" : [\n"
                + "          \"root_shards_to_all_children\" : { },\n"
        assertThat(parsedMetadata.templates().get("foo").aliases().get("alias-bar1").alias(), equalTo("alias-bar1"));
        Map<String, String> mapParams = new HashMap<String, String>() {
                + "        },\n"
                + "    \"index-graveyard\" : {\n"
                + "        \"mappings\" : { },\n"
                + "      }\n"
                + "    \"cluster_uuid\" : \"clusterUUID\",\n"
                + "          \"pattern1\",\n"
                + "        }\n"
        XContentBuilder builder = JsonXContent.contentBuilder();
        CustomMetadata(String data) {
            )
            .persistentSettings(Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT.id).build())
                    new CompressedXContent("{\"baz\":\"eggplant\"}"),
                                }
                + "  \"metadata\" : {\n"
                + "        \"mappings\" : {\n"
        Metadata metadata = buildMetadata();
                + "              \"key\" : \"value\"\n"
                + "            \"number_of_shards\" : \"1\",\n"
                + "    },\n"
                + "        }\n"
                + "        \"in_sync_allocations\" : {\n"
                                    put("key", "value");
                    .putAlias(newAliasMetadataBuilder("alias3").writeIndex(randomBoolean() ? null : randomBoolean()))
                + "          \"index\" : {\n"
                                {
                + "    }\n"
            return Version.CURRENT;
                    .order(1)
        assertNotNull(parsedMetadata.dataStreams().get("data-stream2"));
            return TYPE;
            .put(idx2, false)
                + "            \"key\" : \"value\"\n"
            )
 * this work for additional information regarding copyright
    }
                + "    \"cluster_uuid\" : \"clusterUUID\",\n"
                + "        \"commitedConfigurationNodeId\"\n"
            builder.toString()
                            add("allocationId");
 */
import java.util.Map;
                + "          }\n"
import org.opensearch.Version;
import static org.hamcrest.Matchers.is;
/*
                + "    },\n"
                new Template(
        assertThat(parsedMetadata.dataStreams().get("data-stream2").getName(), is("data-stream2"));
                + "        \"settings_version\" : 1,\n"
                + "              \"created\" : \""
        );
        Metadata metadata = Metadata.builder()
                + "            }\n"
        assertNotNull(parsedMetadata.componentTemplates().get("component_template"));
                    .patterns(Arrays.asList("pattern1", "pattern2"))
                + "        \"settings\" : {\n"
                + "  \"meta-data\" : {\n"
                + "        }\n"
                + "        \"settings\" : {\n"
                + "        \"primary_terms_map\" : {\n"
                + "      ],\n"
                + "          \"node_id\" : \"exlucdedNodeId\",\n"
                + "    \"cluster_uuid_committed\" : false,\n"
                    .putInSyncAllocationIds(0, new HashSet<String>() {
                + "          \"index.number_of_shards\" : \"1\",\n"
                + "        },\n"
                + "            \"time\" : 1\n"
            "{\n"
                IndexTemplateMetadata.builder("foo")
                + "\"\n"
                    .settings(Settings.builder().put("setting1", "value1").put("setting2", "value2"))
                + "      ],\n"
                            });
                    .patterns(Collections.singletonList("bar"))
                + "          ],\n"
                + "        },\n"
                + "    \"cluster_coordination\" : {\n"
                + "            \"type1\" : {\n"
        assertEquals(
                    Collections.singletonMap("alias", AliasMetadata.builder("alias").build())
                + "        \"settings_version\" : 1,\n"
 * ownership. Elasticsearch licenses this file to you under
                        Settings.builder().put("setting", "value").build(),
                + "\"\n"
        );
                + "        \"order\" : 0,\n"
                + "          }\n"
                + "        ],\n"
                + "        \"commitedConfigurationNodeId\"\n"
                + "      \"last_committed_config\" : [\n"
                + "      \"tombstones\" : [ ]\n"
                    })
                + "}",
                + "        \"order\" : 0,\n"
                    randomBoolean() ? null : new ComposableIndexTemplate.DataStreamTemplate()
                + "        },\n"
                + "          \"node_name\" : \"excludedNodeName\"\n"
                + "          \"pattern2\"\n"
                        {
                        Collections.singletonMap("alias", AliasMetadata.builder("alias").build())
        public static final String TYPE = "custom_md";
                + "        ],\n"
        Map<String, String> mapParams = new HashMap<String, String>() {
            }
        assertThat(parsedMetadata.templates().get("foo").settings().getByPrefix("index.").get("setting2"), is("value2"));
                + "            }\n"
                        new CompressedXContent("{\"baz\":\"eggplant\"}"),
                + "        \"rollover_info\" : {\n"
            builder.toString()
import org.opensearch.core.xcontent.XContentBuilder;
                + "        \"state\" : \"open\",\n"
                            }
                + "        \"system\" : false,\n"
            .put(
                + "        \"acceptedConfigurationNodeId\"\n"
                + "        \"index_patterns\" : [\n"
                + "            \"version\" : {\n"
                + "        \"primary_terms\" : {\n"
                + "          \"index.number_of_replicas\" : \"2\",\n"
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
            builder.toString()
                + "      \"template\" : {\n"
                + "        \"index_patterns\" : [\n"
                + "    \"templates\" : {\n"
        builder.startObject();
        };
                                    });
                + "      ],\n"
                + "          \"0\" : 1\n"
 * software distributed under the License is distributed on an
                + "        },\n"
                + "          \"0\" : [\n"
                + "    \"cluster_uuid_committed\" : false,\n"
import java.io.IOException;
                                {
                + "          }\n"
                + "      \"template\" : {\n"
                + "        \"order\" : 0,\n"
        // data streams
        Metadata.FORMAT.toXContent(builder, metadata);
                + "        \"acceptedConfigurationNodeId\"\n"
                + "          ]\n"
                + "    },\n"
                + "          \"0\" : 1\n"
    private static final String MAPPING_SOURCE2 = "{\"mapping2\":{\"text2\":{\"type\":\"string\"}}}";
                    .settings(Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT.id))
    public static class CustomMetadata extends TestCustomMetadata {
                + "\"\n"
import org.opensearch.action.admin.indices.rollover.RolloverInfo;
                + "          \"max_shard_id\" : 0,\n"
        Map<String, String> mapParams = new HashMap<String, String>() {
                + "    \"templates\" : { },\n"
            .put(new DataStream("data-stream2", createTimestampField("@timestamp"), List.of(idx2.getIndex())))
                    .putMapping("type", "{ \"key1\": {} }")
            }
                + "    },\n"
                put(Metadata.CONTEXT_MODE_PARAM, CONTEXT_MODE_GATEWAY);
                + "        \"rollover_info\" : {\n"
        assertThat(parsedMetadata.templates().get("foo").settings().get("index.setting1"), is("value1"));
                + "            }\n"
                + "    \"index-graveyard\" : {\n"
                + "        },\n"
                + "        }\n"
                put("reduce_mappings", "true");
    }
                + "          \"parent_to_child_shards\" : { }\n"
                + "          \"type\" : {\n"
                + "      ]\n"
        assertThat(parsedMetadata.templates().get("foo").aliases().size(), equalTo(3));
                    .putAlias(newAliasMetadataBuilder("alias-bar1"))
                + "        },\n"
                + "          ]\n"
                + "        \"index_patterns\" : [\n"
                + "        {\n"
                + "        },\n"
        assertEquals(
                + "      \"last_accepted_config\" : [\n"
 * Modifications Copyright OpenSearch Contributors. See
                + "        \"mappings\" : { },\n"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                + "        \"settings_version\" : 1,\n"
                                    put("type", new HashMap<String, Object>() {
                + "        \"routing_num_shards\" : 1,\n"
                + "      \"last_committed_config\" : [\n"
import static org.hamcrest.Matchers.equalTo;
                    5L,
                    .lastAcceptedConfiguration(new CoordinationMetadata.VotingConfiguration(new HashSet<String>() {
                + Version.CURRENT.id
                    .numberOfReplicas(2)
        assertEquals(
                + "      \"voting_config_exclusions\" : [\n"
                    .settings(Settings.builder().put("setting1", "value1").put("setting2", "value2"))
                + "            \"time\" : 1\n"
                    Collections.singletonList("component_template"),
                + "      \"template\" : {\n"
                + "            \"met_conditions\" : { },\n"
            {
            .put(new DataStream("data-stream1", createTimestampField("@timestamp"), List.of(idx1.getIndex())))
                + "          \"key1\" : { }\n"
            .build();
                put("reduce_mappings", "false");
                + "          \"parent_to_child_shards\" : { }\n"
                + "          \"num_of_root_shards\" : 1,\n"
                + "        \"system\" : false,\n"
                + "          \"is_paused\" : false\n"
                    Arrays.asList("foo", "bar*"),
                + "            \"version\" : {\n"
                IndexMetadata.builder("test12")
        builder.startObject();
                            "type",
                + "          \"parent_to_child_shards\" : { }\n"
                + "        },\n"
                + "    \"settings\" : {\n"
        builder.endObject();
        builder.startObject();
    }
                + "          \"root_shards_to_all_children\" : { },\n"
                + "      \"voting_config_exclusions\" : [\n"
                + "      \"last_accepted_config\" : [ ],\n"
                + "    \"index-graveyard\" : {\n"
                + "    }\n"
                "component_template",
            .clusterUUID("clusterUUID")
                + "            }\n"
                + "        \"aliases_version\" : 1,\n"
                + "        \"split_shards_metadata\" : {\n"
            parsedMetadata.componentTemplates().get("component_template").metadata(),
                + "}",
                + "      }\n"
                + "      }\n"
            )
 * under the License.
                new ComponentTemplate(
        builder.startObject();
                + "        }\n"
                + "              \"created\" : \""
                + "        },\n"
                + "          \"node_id\" : \"exlucdedNodeId\",\n"
        public String getWriteableName() {
                + "        \"mappings\" : {\n"
        Metadata parsedMetadata = Metadata.Builder.fromXContent(createParser(builder));
                + "        \"mappings\" : {\n"
                + "    \"version\" : 0,\n"
            .transientSettings(Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT.id).build())
        Map<String, String> mapParams = new HashMap<String, String>() {
                + "      \"voting_config_exclusions\" : [\n"
                + "    \"cluster_coordination\" : {\n"
                + "        },\n"
            }
                + "    \"cluster_uuid_committed\" : false,\n"
                + "        \"aliases\" : [\n"
            .put(
                    .numberOfReplicas(2)
                + "    \"templates\" : {\n"
        );
                        new CompressedXContent("{\"baz\":\"eggplant\"}"),
            equalTo(
            }
                + Version.CURRENT.id
 * the Apache License, Version 2.0 (the "License"); you may
                    Settings.builder().put("setting", "value").build(),
                    .putAlias(newAliasMetadataBuilder("alias1").filter(ALIAS_FILTER1))
                + "        \"version\" : 2,\n"
                + "          \"max_shard_id\" : 0,\n"
                + "  }\n"
                            add("commitedConfigurationNodeId");
package org.opensearch.cluster.metadata;
                + "      }\n"
                put("flat_settings", "false");
                + Version.CURRENT.id
                + "        \"aliases\" : [\n"
                + "        },\n"
                put(Metadata.CONTEXT_MODE_PARAM, CONTEXT_MODE_API);
                + "              \"key\" : \"value\"\n"
    }
                    new Template(
                + "            \"number_of_replicas\" : \"2\",\n"
import java.util.HashSet;
                + "          \"type\" : {\n"
        @Override
            )
            "{\n"
                    5L,
                + "\"\n"
                + Version.CURRENT.id
 */
                + "        \"commitedConfigurationNodeId\"\n"
                + "        \"state\" : \"open\",\n"
                + "      \"last_accepted_config\" : [\n"
 */
            )
                + "    \"cluster_coordination\" : {\n"
                + "      \"term\" : 1,\n"
                IndexTemplateMetadata.builder("foo")
                + "      \"index.version.created\" : \""
        }
                + "        },\n"
                + "        \"aliases\" : [ ],\n"
            {
    }
                + "          \"index.version.created\" : \""
                + "    \"cluster_coordination\" : {\n"
                + "          \"max_shard_id\" : 0,\n"
                + "          \"pattern2\"\n"
            .build();
}
                + "        ],\n"
import static org.opensearch.cluster.metadata.Metadata.CONTEXT_MODE_API;
                        Settings.builder().put("setting", "value").build(),
        );
                + "        },\n"
        Metadata metadata = Metadata.builder()
                + "          \"alias\"\n"
                + "        \"aliases\" : { }\n"
        };
        assertThat(parsedMetadata.templates().get("foo").aliases().get("alias-bar2").alias(), equalTo("alias-bar2"));
                + "        {\n"
                + "        \"acceptedConfigurationNodeId\"\n"
        );
                    .numberOfShards(1)
                + "  \"metadata\" : {\n"
                + "        \"aliases\" : { }\n"
                + "          }\n"
                + "          }\n"
                + "        {\n"
                put(Metadata.CONTEXT_MODE_PARAM, CONTEXT_MODE_API);
public class ToAndFromJsonMetadataTests extends OpenSearchTestCase {
            "{\n"
                + "          \"key1\" : { }\n"
                + "        },\n"
                        )
                + "          \"node_name\" : \"excludedNodeName\"\n"
                + "        \"settings\" : {\n"
                + "    \"templates\" : {\n"
                + "          }\n"
        builder.endObject();
                + "      ],\n"
                + "        \"aliases_version\" : 1,\n"
                    .putAlias(newAliasMetadataBuilder("alias4").filter(ALIAS_FILTER2))
                + "            0\n"
                    .lastCommittedConfiguration(new CoordinationMetadata.VotingConfiguration(new HashSet<String>() {
import static org.opensearch.cluster.DataStreamTestHelper.createTimestampField;
        metadata.toXContent(builder, new ToXContent.MapParams(mapParams));
                    Collections.singletonMap("my_meta", Collections.singletonMap("potato", "chicken")),
                    .settings(Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT.id))
                new ComposableIndexTemplate(
                + "        \"routing_num_shards\" : 1,\n"
        IndexMetadata idx2 = createFirstBackingIndex("data-stream2").build();
                + "  \"meta-data\" : {\n"
import org.opensearch.cluster.coordination.CoordinationMetadata;
                + "            \"number_of_replicas\" : \"2\",\n"
                + "        },\n"
                    .term(1)
                + "        \"split_shards_metadata\" : {\n"
                + "      ],\n"
                + "      }\n"
        final Metadata metadata = buildMetadata();
                + "        },\n"
                    .state(IndexMetadata.State.OPEN)
                + "          \"num_of_root_shards\" : 1,\n"
                + "    \"version\" : 0,\n"
                + "    \"indices\" : {\n"
                + "        \"primary_terms\" : {\n"
                    .numberOfReplicas(2)
                + "  }\n"
    private static final String MAPPING_SOURCE1 = "{\"mapping1\":{\"text1\":{\"type\":\"string\"}}}";
                    )
                + "    \"cluster_uuid_committed\" : false,\n"
                        }
                + "    }\n"
 * Unless required by applicable law or agreed to in writing,
                            put("type1", new HashMap<String, Object>() {
                + "        \"system\" : false,\n"
                + "        \"mapping_version\" : 1,\n"
                + "      \"template\" : {\n"
                        Collections.singletonMap("alias", AliasMetadata.builder("alias").build())
                + "            \"allocationId\"\n"
        assertEquals(
                + "        \"mappings\" : {\n"
    }
                + "        \"routing_num_shards\" : 1,\n"
                + "          \"num_of_root_shards\" : 1,\n"
                + Version.CURRENT.id
        assertThat(parsedMetadata.templates().get("foo").aliases().get("alias-bar3").alias(), equalTo("alias-bar3"));
                + "            0\n"
                + "          \"is_paused\" : false\n"
        }
 * Licensed to Elasticsearch under one or more contributor
        builder.endObject();
                + "        \"rollover_info\" : { },\n"
                + "          \"active_shard_ids\" : [\n"
                put("flat_settings", "false");
 * compatible open source license.
                + "            \"met_conditions\" : { },\n"
                    .patterns(Collections.singletonList("bar"))
                + "      \"last_committed_config\" : [ ],\n"
                + "        \"primary_terms_map\" : {\n"
import org.opensearch.test.OpenSearchTestCase;
 * KIND, either express or implied.  See the License for the
        );
    public void testToXContentAPI_FlatSettingTrue_ReduceMappingFalse() throws IOException {
            )
            parsedMetadata.templatesV2().get("index_templatev2").metadata(),
        assertThat(
 * The OpenSearch Contributors require contributions made to
                + "        \"mapping_version\" : 1,\n"
 *     http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
                + "    },\n"
                + "        },\n"
                + "          ],\n"
        }
                        {
 *
import org.opensearch.core.xcontent.ToXContent;
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
            .build();
        builder.endObject();
                + "      \"last_accepted_config\" : [\n"
                + "        },\n"
                    .putMapping(MAPPING_SOURCE1)
/*
                                }
                put("flat_settings", "true");
                + "      ],\n"
                + "          \"index\" : {\n"
        builder.startObject();
                + "          \"root_shards_to_all_children\" : { },\n"
                + "      \"voting_config_exclusions\" : [ ]\n"
                + "    \"index-graveyard\" : {\n"
                + "      \"tombstones\" : [ ]\n"
                + "        \"state\" : \"open\",\n"
                + "        \"aliases\" : { }\n"
                    }))
                + "        \"mappings\" : {\n"
                + "    },\n"
                + "    \"indices\" : {\n"
                + "        },\n"
                + "          \"type\" : {\n"
                + "\"\n"
                    .primaryTerm(0, 1L)
            parsedMetadata.templatesV2().get("index_templatev2").template(),
                + "        {\n"
                + "      ],\n"
            equalTo("{\"term\":{\"user\":\"foobar\"}}")
                    .putRolloverInfo(new RolloverInfo("rolloveAlias", new ArrayList<>(), 1L))
                + "          \"rolloveAlias\" : {\n"
        // component template
                + "        },\n"
                + "      \"tombstones\" : [ ]\n"
        builder.endObject();
                + "          \"is_paused\" : false\n"
            )
                put("flat_settings", "true");
                            add("acceptedConfigurationNodeId");
            }
                + "        \"settings\" : {\n"
                + "          \"pattern2\"\n"
                + "        \"in_sync_allocations\" : {\n"
                + "      ]\n"
            builder.toString()
                )
                + "        \"ingestion_status\" : {\n"
                + "      }\n"
                + "          \"node_name\" : \"excludedNodeName\"\n"
                    .addVotingConfigExclusion(new CoordinationMetadata.VotingConfigExclusion("exlucdedNodeId", "excludedNodeName"))
/*
import org.opensearch.common.compress.CompressedXContent;
        assertThat(parsedMetadata.dataStreams().get("data-stream2").getTimeStampField().getName(), is("@timestamp"));
                    }))
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
        assertNotNull(parsedMetadata.templatesV2().get("index_templatev2"));
                + "      ],\n"
                )
                + "      \"last_committed_config\" : [\n"
                + "          \"pattern1\",\n"
            equalTo(Collections.singletonMap("my_meta", Collections.singletonMap("potato", "chicken")))
                + "          \"pattern1\",\n"
                    .numberOfShards(1)
                + "            0\n"
            .put(
                + "  }\n"
                        }
 * specific language governing permissions and limitations
                + "        \"version\" : 2,\n"
                + "        ],\n"
                        }
 * SPDX-License-Identifier: Apache-2.0
            .put(
                + "    },\n"
                + "          \"index.version.created\" : \""
                + Version.CURRENT.id
    }
import java.util.Collections;
 * not use this file except in compliance with the License.
                    .putAlias(newAliasMetadataBuilder("alias-bar3").routing("routing-bar"))
                put(Metadata.CONTEXT_MODE_PARAM, CONTEXT_MODE_API);
        IndexMetadata idx1 = createFirstBackingIndex("data-stream1").build();
                + "    },\n"
            .put(
            .put(
                + "        },\n"
                + "          \"0\" : [\n"
            "{\n"
        assertThat(parsedMetadata.templates().get("foo").aliases().get("alias-bar3").searchRouting(), equalTo("routing-bar"));
                    new CompressedXContent("{\"baz\":\"eggplant\"}"),
                            // the original logic in ClusterState.toXContent will reduce
                    .putAlias(AliasMetadata.builder("alias").indexRouting("indexRouting").build())
                + "            \"version\" : {\n"
                + "          \"0\" : 1\n"
                + "\"\n"
                + "          }\n"
                + "      \"term\" : 0,\n"
                + "    },\n"
            builder.toString()
                + "        \"aliases\" : { }\n"
                + "    \"cluster_coordination\" : {\n"
                + "        \"primary_terms_map\" : {\n"
import org.opensearch.test.TestCustomMetadata;
                + "          \"node_id\" : \"exlucdedNodeId\",\n"
                + "}",
    private Metadata buildMetadata() throws IOException {
                + "        \"version\" : 2,\n"
                + "      \"index.version.created\" : \""
                    .settings(Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT.id))
        );
        );
                )
                    .order(1)
                + "    }\n"
        assertThat(parsedMetadata.templatesV2().get("index_templatev2").version(), is(4L));
        assertNotNull(parsedMetadata.dataStreams().get("data-stream1"));
    public void testToXContentGateway_FlatSettingTrue_ReduceMappingFalse() throws IOException {
            return EnumSet.of(Metadata.XContentContext.GATEWAY, Metadata.XContentContext.SNAPSHOT);
        assertThat(parsedMetadata.dataStreams().get("data-stream1").getName(), is("data-stream1"));
import static org.opensearch.cluster.metadata.Metadata.CONTEXT_MODE_GATEWAY;
            .coordinationMetadata(
                + "    \"index-graveyard\" : {\n"
                                        {
                    .putMapping(new MappingMetadata("type", new HashMap<String, Object>() {
                + "\"\n"
                + "      ]\n"
        final Metadata metadata = buildMetadata();
                + "        ],\n"
 *
                + "    \"cluster_uuid\" : \"clusterUUID\",\n"
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
 *
                + "          \"index\" : {\n"
import org.opensearch.common.settings.Settings;
            .put(
                + "    \"cluster_uuid\" : \"clusterUUID\",\n"
            {
    public void testToXContentAPI_FlatSettingFalse_ReduceMappingTrue() throws IOException {
        assertThat(
                + "      \"tombstones\" : [ ]\n"
                + "        \"in_sync_allocations\" : {\n"
        assertThat(parsedMetadata.dataStreams().get("data-stream2").getIndices(), contains(idx2.getIndex()));
    }
                + "        \"aliases_version\" : 1,\n"
        );
import java.util.Arrays;
            "{\n"
                + "        }\n"
 * GitHub history for details.
                put("reduce_mappings", "false");
                + "    },\n"
                + "          \"node_name\" : \"excludedNodeName\"\n"
        };
    public void testToXContentAPI_SameTypeName() throws IOException {
        assertThat(parsedMetadata.templatesV2().get("index_templatev2").indexPatterns(), is(Arrays.asList("foo", "bar*")));
                + "}",
                                            put("key", "value");
        assertThat(parsedMetadata.templatesV2().get("index_templatev2").composedOf(), is(Collections.singletonList("component_template")));
                    .putAlias(newAliasMetadataBuilder("alias-bar1"))
        // index template v2
                + "    \"cluster_uuid\" : \"clusterUUID\",\n"
                                        }
                    .putMapping(
                + "        \"ingestion_status\" : {\n"
        metadata.toXContent(builder, new ToXContent.MapParams(mapParams));
                + "        \"mapping_version\" : 1,\n"
                + "        },\n"
                        }
        assertThat(parsedMetadata.dataStreams().get("data-stream1").getIndices(), contains(idx1.getIndex()));
            )
                + "        \"split_shards_metadata\" : {\n"
                + "      \"term\" : 1,\n"
                + "      \"term\" : 1,\n"
                + "\"\n"
import java.util.EnumSet;
        // templates
        assertThat(parsedMetadata.componentTemplates().get("component_template").version(), is(5L));
            super(data);
                + "    },\n"
            parsedMetadata.templates().get("foo").aliases().get("alias-bar2").filter().string(),
                + "    \"indices\" : {\n"
        assertThat(parsedMetadata.templates().get("foo").patterns(), is(Collections.singletonList("bar")));
                + "              \"created\" : \""
                IndexMetadata.builder("index")
                    Collections.singletonMap("alias", AliasMetadata.builder("alias").build())
        assertThat(parsedMetadata.templates().get("foo").name(), is("foo"));
                    .putAlias(newAliasMetadataBuilder("alias-bar2").filter("{\"term\":{\"user\":\"foobar\"}}"))
        builder.endObject();
                        new MappingMetadata(
                + "        },\n"
 * You may obtain a copy of the License at
                + "              \"created\" : \""
                + "    \"templates\" : {\n"
                + "        \"settings\" : {\n"
                + Version.CURRENT.id
                + "          \"active_shard_ids\" : [\n"
import java.util.ArrayList;
            )
        @Override
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
                    .build()
                + "      \"index\" : {\n"
                IndexTemplateMetadata.builder("template")
                + "    \"cluster_uuid_committed\" : false,\n"
                + "          \"rolloveAlias\" : {\n"
                + "          \"pattern1\",\n"
import static org.hamcrest.Matchers.contains;
        return Metadata.builder()
                    new Template(
                + "          \"0\" : [ ]\n"
                + "        \"settings\" : {\n"
                    .order(0)
        assertThat(parsedMetadata.templates().get("foo").aliases().get("alias-bar3").indexRouting(), equalTo("routing-bar"));
        }
                    Settings.builder().put("setting", "value").build(),
            {
                + "        \"acceptedConfigurationNodeId\"\n"
        public Version getMinimalSupportedVersion() {
                + "        },\n"
                    Collections.singletonMap("my_meta", Collections.singletonMap("foo", "bar"))
            parsedMetadata.componentTemplates().get("component_template").template(),
                            // the type name is the root value,
                put("reduce_mappings", "true");
                + "  }\n"
                + "          \"index\" : {\n"
                + "  \"metadata\" : {\n"
                + "          \"index.version.created\" : \""
            .put(
                    }))
        metadata.toXContent(builder, new ToXContent.MapParams(mapParams));
                    .putAlias(newAliasMetadataBuilder("alias-bar3").routing("routing-bar"))
        Map<String, String> mapParams = new HashMap<String, String>() {
                    4L,
                + "      \"term\" : 1,\n"
import java.util.List;
                + "\"\n"
            equalTo(Collections.singletonMap("my_meta", Collections.singletonMap("foo", "bar")))
