                + "        \"in_sync_allocations\" : {\n"  
                + "      \"index\" : {\n"  
        metadata.toXContent(builder, new ToXContent.MapParams(mapParams));
                + "          \"max_shard_id\" : 0,\n"
import org.opensearch.core.xcontent.XContentBuilder;
                        )
 */  
                + "\"\n"
        // index template v2
                                        }
        @Override  
            .put(
                + "        },\n"
                + "    \"version\" : 0,\n"
                + "          \"num_of_root_shards\" : 1,\n"
                + "          \"0\" : [ ]\n"
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
            return EnumSet.of(Metadata.XContentContext.GATEWAY, Metadata.XContentContext.SNAPSHOT);
        assertNotNull(parsedMetadata.componentTemplates().get("component_template"));
                "index_templatev2",  
            )
                        Collections.singletonMap("alias", AliasMetadata.builder("alias").build())  
                + "          \"pattern2\"\n"  
                                    put("key", "value");
            .put(
                + "    \"templates\" : { },\n"
        public static final String TYPE = "custom_md";
                + "        \"primary_terms_map\" : {\n"  
            .transientSettings(Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT.id).build())
import static org.hamcrest.Matchers.is;  
                        {
                    .numberOfReplicas(2)
            parsedMetadata.componentTemplates().get("component_template").template(),  
                + "          ]\n"  
                )
                + "            \"version\" : {\n"
    }
                + "      \"last_accepted_config\" : [\n"
            return Version.CURRENT;  
                + "        },\n"  
                + "          \"is_paused\" : false\n"  
                + "          \"pattern1\",\n"
                + "      \"template\" : {\n"
                + "        ],\n"
                + "  \"meta-data\" : {\n"  
                + "        \"primary_terms\" : {\n"  
                + "            }\n"  
                + "        \"index_patterns\" : [\n"
import java.util.Map;
                    4L,
                + "        },\n"
 *  
                + "        }\n"
                + "      \"tombstones\" : [ ]\n"  
        assertEquals(
                + "          }\n"
        assertNotNull(parsedMetadata.dataStreams().get("data-stream2"));  
 * Modifications Copyright OpenSearch Contributors. See
        );
                + "        \"aliases\" : { }\n"
import org.opensearch.cluster.coordination.CoordinationMetadata;  
 * SPDX-License-Identifier: Apache-2.0
                    .settings(Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT.id))
            )
        assertThat(parsedMetadata.templates().get("foo").settings().getByPrefix("index.").get("setting2"), is("value2"));
                + "          \"active_shard_ids\" : [\n"
            }
        assertThat(parsedMetadata.templates().get("foo").aliases().get("alias-bar1").alias(), equalTo("alias-bar1"));  
                    .term(1)
                + "      ],\n"
                + "            0\n"
                + "        \"settings\" : {\n"
                + "              \"created\" : \""
                + "      ]\n"  
                + "        \"aliases\" : [\n"  
                                    });
        assertThat(parsedMetadata.templatesV2().get("index_templatev2").indexPatterns(), is(Arrays.asList("foo", "bar*")));
                    .numberOfShards(1)
            .persistentSettings(Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT.id).build())  
                                    put("type", new HashMap<String, Object>() {
 * Unless required by applicable law or agreed to in writing,
    }
                + "            }\n"
            .put(idx1, false)
        };  
                + "          \"pattern1\",\n"  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                + "            0\n"
                + "      ]\n"  
                + "}",
                + "        \"ingestion_status\" : {\n"  
import org.opensearch.common.xcontent.json.JsonXContent;  
                + "          \"alias\"\n"
                + "    \"cluster_coordination\" : {\n"
                + "      \"index\" : {\n"
                + "          }\n"
    }
            equalTo(Collections.singletonMap("my_meta", Collections.singletonMap("foo", "bar")))  
        );
            }
        };
    }
            .clusterUUID("clusterUUID")
                + "    \"cluster_uuid_committed\" : false,\n"  
                + "    \"indices\" : {\n"
        builder.endObject();
                + "              \"key\" : \"value\"\n"
            )
                + "          \"active_shard_ids\" : [\n"  
                CoordinationMetadata.builder()  
                + "          \"parent_to_child_shards\" : { }\n"
            }
                    .patterns(Arrays.asList("pattern1", "pattern2"))
                        }
                + "      \"last_committed_config\" : [\n"
                + "      \"tombstones\" : [ ]\n"  
            builder.toString()  
                + "        \"in_sync_allocations\" : {\n"  
                + "          \"pattern2\"\n"
                        Settings.builder().put("setting", "value").build(),
        metadata.toXContent(builder, new ToXContent.MapParams(mapParams));
                + "        },\n"
                put("flat_settings", "false");  
        };  
                put("reduce_mappings", "false");
import static org.opensearch.cluster.metadata.Metadata.CONTEXT_MODE_API;
                + "      }\n"  
        assertThat(parsedMetadata.templates().get("foo").aliases().get("alias-bar3").searchRouting(), equalTo("routing-bar"));
        builder.startObject();  
            builder.toString()
                + "        },\n"
                + "        }\n"
                + "        \"index_patterns\" : [\n"  
import java.util.List;
                    Collections.singletonMap("alias", AliasMetadata.builder("alias").build())
                + "    \"index-graveyard\" : {\n"
                + "          \"index.number_of_replicas\" : \"2\",\n"
                + "            \"met_conditions\" : { },\n"
                    .putMapping(  
/*
                + Version.CURRENT.id  
        IndexMetadata idx1 = createFirstBackingIndex("data-stream1").build();
                + "        ],\n"
        assertEquals(
                + "              \"created\" : \""  
                + "    \"cluster_coordination\" : {\n"
            }
                + "        },\n"
                + "        \"state\" : \"open\",\n"
                + "      \"tombstones\" : [ ]\n"  
                + "        },\n"
                + "        },\n"
            .coordinationMetadata(
                + "    }\n"
                IndexMetadata.builder("test12")
                + "    },\n"
            {
        assertThat(
                    .settings(settings(Version.CURRENT).put("setting1", "value1").put("setting2", "value2"))
        assertThat(parsedMetadata.templatesV2().get("index_templatev2").version(), is(4L));
                    .order(1)
        assertThat(parsedMetadata.dataStreams().get("data-stream2").getTimeStampField().getName(), is("@timestamp"));
        assertThat(parsedMetadata.dataStreams().get("data-stream2").getName(), is("data-stream2"));
                + "}",  
                + "      \"last_accepted_config\" : [\n"
        public EnumSet<Metadata.XContentContext> context() {
                + "            \"version\" : {\n"  
                + "        },\n"
    }  
        assertEquals(
import org.opensearch.Version;
                + "        \"system\" : false,\n"
        @Override
        public Version getMinimalSupportedVersion() {
                + "          \"max_shard_id\" : 0,\n"
                + "        },\n"
                + "        }\n"
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
                    .order(0)
 * You may obtain a copy of the License at  
                + "          \"index\" : {\n"
                    .state(IndexMetadata.State.OPEN)
                    new CompressedXContent("{\"baz\":\"eggplant\"}"),
                    .lastCommittedConfiguration(new CoordinationMetadata.VotingConfiguration(new HashSet<String>() {
                    .numberOfShards(1)
                + "    \"templates\" : {\n"
                    Collections.singletonList("component_template"),
                + "    },\n"
                        }
 *
                + "          }\n"  
                        {  
                + "        \"ingestion_status\" : {\n"  
                            new HashMap<String, Object>() {
                + "      \"term\" : 1,\n"
                + "      \"term\" : 1,\n"  
            .put(new DataStream("data-stream1", createTimestampField("@timestamp"), List.of(idx1.getIndex())))
                + "      ]\n"  
                    Arrays.asList("foo", "bar*"),
                + "          \"active_shard_ids\" : [\n"  
        );
                + "        }\n"
                                            put("key", "value");  
                    }))  
        builder.endObject();  
                    .putAlias(newAliasMetadataBuilder("alias-bar2").filter("{\"term\":{\"user\":\"foobar\"}}"))
                + "    \"cluster_uuid\" : \"clusterUUID\",\n"  
                + "\"\n"  
                + "          \"0\" : 1\n"
                + "        \"settings\" : {\n"
                + "        ],\n"
                + "          ]\n"  
                + "        \"mapping_version\" : 1,\n"
 * this file be licensed under the Apache-2.0 license or a
        assertThat(parsedMetadata.templatesV2().get("index_templatev2").priority(), is(5L));  
                + "          \"key1\" : { }\n"  
        // data streams
            .put(
                + "        \"aliases\" : { }\n"
                + "      }\n"  
import org.opensearch.common.settings.Settings;
                        }  
                + "        {\n"
                put("reduce_mappings", "true");  
                + "    },\n"
            "{\n"  
        Metadata metadata = buildMetadata();
                + "    \"cluster_coordination\" : {\n"
                + "  }\n"
                put(Metadata.CONTEXT_MODE_PARAM, CONTEXT_MODE_GATEWAY);
                + "          \"root_shards_to_all_children\" : { },\n"
 * Licensed to Elasticsearch under one or more contributor  
                    .state(IndexMetadata.State.OPEN)
                + "        \"routing_num_shards\" : 1,\n"
        Metadata metadata = Metadata.builder()
                + "          \"parent_to_child_shards\" : { }\n"
import static org.hamcrest.Matchers.contains;
                + "      ],\n"  
            parsedMetadata.templatesV2().get("index_templatev2").metadata(),
import static org.opensearch.cluster.DataStreamTestHelper.createTimestampField;
                put("flat_settings", "true");  
                + "  \"metadata\" : {\n"
                + "    \"cluster_uuid_committed\" : false,\n"  
            equalTo(
                put(Metadata.CONTEXT_MODE_PARAM, CONTEXT_MODE_GATEWAY);
                + "        },\n"
                + "\"\n"  
                + "\"\n"
                + "        \"aliases\" : [ ],\n"
        Metadata parsedMetadata = Metadata.Builder.fromXContent(createParser(builder));
                + "          }\n"
                    .putAlias(AliasMetadata.builder("alias").indexRouting("indexRouting").build())  
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
            equalTo("{\"term\":{\"user\":\"foobar\"}}")
                + "        \"index_patterns\" : [\n"
                + "    \"cluster_uuid_committed\" : false,\n"
                + "        \"rollover_info\" : {\n"
                + "      ]\n"
                + "      \"last_committed_config\" : [ ],\n"  
                + "    \"version\" : 0,\n"
 * ownership. Elasticsearch licenses this file to you under  
                            add("commitedConfigurationNodeId");
        );
                + "        ],\n"
                + "      \"term\" : 0,\n"
                + "    },\n"  
                + "        \"mappings\" : { },\n"  
                    new Template(  
                + "            \"type1\" : {\n"
                + "          \"index\" : {\n"
                + "      \"tombstones\" : [ ]\n"
                + "        \"order\" : 0,\n"
        assertThat(
            {  
                + "          \"pattern1\",\n"  
                            });  
                        {
                + "        \"system\" : false,\n"
                + "          \"index.version.created\" : \""
                + "      ],\n"  
                + "          }\n"  
                + "            \"number_of_replicas\" : \"2\",\n"  
                + "        }\n"
    }
                + "            \"allocationId\"\n"
                + "\"\n"
                + Version.CURRENT.id
                new ComponentTemplate(
/*  
                + "        \"aliases_version\" : 1,\n"
                + "      \"last_accepted_config\" : [\n"  
                + "  \"metadata\" : {\n"
                + "          }\n"  
import org.opensearch.test.OpenSearchTestCase;  
                IndexMetadata.builder("index")  
                + "      \"template\" : {\n"  
                + "        \"primary_terms\" : {\n"  
                + "    },\n"  
                + "        \"settings_version\" : 1,\n"  
            .put(idx2, false)  
                + "          \"type\" : {\n"  
                + "    }\n"
            builder.toString()
                            "type",
                    })
            .put(
        assertThat(
                + "    }\n"
                put(Metadata.CONTEXT_MODE_PARAM, CONTEXT_MODE_API);
 * license agreements. See the NOTICE file distributed with
                + "    \"index-graveyard\" : {\n"
        assertThat(parsedMetadata.templates().get("foo").aliases().get("alias-bar3").alias(), equalTo("alias-bar3"));  
                + "      \"template\" : {\n"  
        builder.startObject();  
                    randomBoolean() ? null : new ComposableIndexTemplate.DataStreamTemplate()  
                + "          \"rolloveAlias\" : {\n"  
                + "          \"key1\" : { }\n"
                + "      \"index.version.created\" : \""
                + "        \"order\" : 0,\n"  
                + "        \"aliases_version\" : 1,\n"  
                + "  }\n"
                    .putAlias(newAliasMetadataBuilder("alias-bar1"))
                            }
                + "    \"index-graveyard\" : {\n"
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
            return TYPE;
            )
                + "        \"aliases\" : [\n"  
            .put(
                + "      }\n"  
            .build();
                + "        \"routing_num_shards\" : 1,\n"
                    .putInSyncAllocationIds(0, new HashSet<String>() {  
import org.opensearch.action.admin.indices.rollover.RolloverInfo;
}
                + "  }\n"
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
            )
        Metadata metadata = Metadata.builder()
                    5L,  
                    .settings(Settings.builder().put("setting1", "value1").put("setting2", "value2"))  
                    .addVotingConfigExclusion(new CoordinationMetadata.VotingConfigExclusion("exlucdedNodeId", "excludedNodeName"))  
                    .putAlias(newAliasMetadataBuilder("alias-bar1"))
                + "        },\n"
                + "        \"version\" : 2,\n"
                + "        \"commitedConfigurationNodeId\"\n"
        builder.endObject();
                        Settings.builder().put("setting", "value").build(),  
                IndexMetadata.builder("index")  
                put(Metadata.CONTEXT_MODE_PARAM, CONTEXT_MODE_API);
                )  
                + "          \"node_name\" : \"excludedNodeName\"\n"
                    .putMapping(new MappingMetadata("type", new HashMap<String, Object>() {  
package org.opensearch.cluster.metadata;
    public void testSimpleJsonFromAndTo() throws IOException {
        );
                + "      }\n"  
    public void testToXContentGateway_FlatSettingFalse_ReduceMappingTrue() throws IOException {
                + "    },\n"
        }
                + "        {\n"
                + "        \"settings\" : {\n"  
                    Settings.builder().put("setting", "value").build(),  
            .build();
                        new CompressedXContent("{\"baz\":\"eggplant\"}"),
    public void testToXContentAPI_FlatSettingFalse_ReduceMappingTrue() throws IOException {
                    Collections.singletonMap("alias", AliasMetadata.builder("alias").build())
                + "        \"settings_version\" : 1,\n"  
        Map<String, String> mapParams = new HashMap<String, String>() {
                + "        },\n"
                    ),
                + "          \"0\" : 1\n"
        XContentBuilder builder = JsonXContent.contentBuilder();
 *     http://www.apache.org/licenses/LICENSE-2.0
                + "          \"pattern2\"\n"
                    .build()
        builder.endObject();
                + Version.CURRENT.id  
                put("flat_settings", "false");
                + "    },\n"  
                    ),  
                + "            \"met_conditions\" : { },\n"
                + "        {\n"
                + "        \"mappings\" : {\n"
                + "          \"0\" : 1\n"
                    )  
                            // the type name is the root value,  
        assertThat(parsedMetadata.templates().get("foo").aliases().get("alias-bar3").indexRouting(), equalTo("routing-bar"));
                + "    \"settings\" : {\n"
                + "        \"version\" : 2,\n"  
                + "            \"version\" : {\n"
                + "        },\n"
                new Template(
            {
                IndexTemplateMetadata.builder("foo")  
                + "    \"templates\" : {\n"
        };  
    private static final String ALIAS_FILTER1 = "{\"field1\":\"value1\"}";
                + Version.CURRENT.id
                            // the original logic in ClusterState.toXContent will reduce
        Map<String, String> mapParams = new HashMap<String, String>() {  
        assertThat(parsedMetadata.dataStreams().get("data-stream1").getIndices(), contains(idx1.getIndex()));
                + "    },\n"  
                + "        \"acceptedConfigurationNodeId\"\n"
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
                    .putAlias(newAliasMetadataBuilder("alias1").filter(ALIAS_FILTER1))
                            put("type1", new HashMap<String, Object>() {
public class ToAndFromJsonMetadataTests extends OpenSearchTestCase {
    public void testToXContentAPI_FlatSettingTrue_ReduceMappingFalse() throws IOException {
                + "        \"mappings\" : {\n"  
                + "    },\n"
        builder.endObject();
        builder.startObject();
                + "              \"key\" : \"value\"\n"
                + "        },\n"
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();  
        metadata.toXContent(builder, new ToXContent.MapParams(mapParams));  
 * under the License.  
                + "            \"number_of_shards\" : \"1\",\n"  
                + Version.CURRENT.id
            )
        assertThat(parsedMetadata.templates().get("foo").settings().get("index.setting1"), is("value1"));  
                + "          \"is_paused\" : false\n"
        assertThat(
        assertThat(parsedMetadata.templates().get("foo").patterns(), is(Collections.singletonList("bar")));
                    new CompressedXContent("{\"baz\":\"eggplant\"}"),
                + "          ],\n"
                + "          \"node_name\" : \"excludedNodeName\"\n"
                + "}",
        assertThat(parsedMetadata.templates().get("foo").aliases().size(), equalTo(3));
                                }
            .build();  
                + "          \"parent_to_child_shards\" : { }\n"  
        assertNotNull(parsedMetadata.dataStreams().get("data-stream1"));
                + "        \"aliases\" : { }\n"
                + "            \"type1\" : {\n"
                + "        \"split_shards_metadata\" : {\n"  
            {
                + "        \"acceptedConfigurationNodeId\"\n"
            "{\n"
                + "      \"tombstones\" : [ ]\n"
                + "        {\n"
                    .patterns(Collections.singletonList("bar"))
                + "  \"meta-data\" : {\n"
                                }  
                + "          \"index.version.created\" : \""
        IndexMetadata idx2 = createFirstBackingIndex("data-stream2").build();  
                + "        \"acceptedConfigurationNodeId\"\n"
                                        {
import java.util.HashMap;
                + "          \"0\" : 1\n"
                + "        },\n"  
                + "          \"num_of_root_shards\" : 1,\n"  
                + "      \"last_accepted_config\" : [\n"
                + "}",  
        // templates  
    }  
                + "      \"last_committed_config\" : [\n"
                + "            }\n"  
                + "          \"root_shards_to_all_children\" : { },\n"  
                + "        \"settings_version\" : 1,\n"
        );
                IndexTemplateMetadata.builder("template")  
        final Metadata metadata = buildMetadata();
                + "            \"time\" : 1\n"
    private static final String ALIAS_FILTER2 = "{\"field2\":\"value2\"}";  
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();  
        CustomMetadata(String data) {
        assertThat(parsedMetadata.dataStreams().get("data-stream1").getName(), is("data-stream1"));  
                + "        }\n"
                    .putAlias(newAliasMetadataBuilder("alias-bar2").filter("{\"term\":{\"user\":\"foobar\"}}"))
        builder.startObject();
        builder.endObject();  
            )
                )  
                + "  \"metadata\" : {\n"
                + "      \"template\" : {\n"
                + "        \"state\" : \"open\",\n"  
                + "    \"templates\" : {\n"
                    .putMapping("type", "{ \"key1\": {} }")
                + "    },\n"
                + "          \"pattern2\"\n"
                + "      ],\n"  
                + "      \"voting_config_exclusions\" : [\n"
                + "      \"voting_config_exclusions\" : [ ]\n"
                + "            \"version\" : {\n"
                + "        \"aliases_version\" : 1,\n"
        assertThat(parsedMetadata.templates().get("foo").aliases().get("alias-bar2").alias(), equalTo("alias-bar2"));
                + "          \"node_name\" : \"excludedNodeName\"\n"
                + "        \"ingestion_status\" : {\n"
                + "          \"max_shard_id\" : 0,\n"
 *
        Map<String, String> mapParams = new HashMap<String, String>() {  
                    Collections.singletonMap("my_meta", Collections.singletonMap("potato", "chicken")),
                + "        \"settings\" : {\n"  
        assertThat(parsedMetadata.dataStreams().get("data-stream2").getIndices(), contains(idx2.getIndex()));  
                + "      }\n"
                + "    \"cluster_uuid\" : \"clusterUUID\",\n"  
                + "      \"term\" : 1,\n"  
                put("reduce_mappings", "false");
                        {
                + "        \"system\" : false,\n"
            super(data);
                + "      \"voting_config_exclusions\" : [\n"
                    }))
                + "      \"index.version.created\" : \""  
                                {  
                    new Template(
        };  
                    .putRolloverInfo(new RolloverInfo("rolloveAlias", new ArrayList<>(), 1L))  
                    .numberOfReplicas(2)
            parsedMetadata.componentTemplates().get("component_template").metadata(),
            )
                    .primaryTerm(0, 1L)
/*  
                + "        },\n"
                    .order(1)
                + "    \"settings\" : {\n"
                + "          \"index\" : {\n"
            {  
                + "            \"time\" : 1\n"
                + "          \"index.version.created\" : \""  
            "{\n"  
                + "    \"cluster_uuid\" : \"clusterUUID\",\n"
                + "  }\n"
import static org.hamcrest.Matchers.equalTo;
import java.util.EnumSet;
                + "        \"mappings\" : {\n"
                + "        },\n"
                + "        \"settings\" : {\n"  
                    5L,
 * not use this file except in compliance with the License.
                )  
                + "    \"cluster_uuid\" : \"clusterUUID\",\n"
                + "      \"last_committed_config\" : [\n"  
                + "        \"settings\" : {\n"
        assertNotNull(parsedMetadata.templatesV2().get("index_templatev2"));
                + Version.CURRENT.id
                new ComposableIndexTemplate(
import static org.opensearch.cluster.metadata.Metadata.CONTEXT_MODE_GATEWAY;  
                + "}",  
        );
                new Template(
                + "\"\n"
                    .primaryTerm(0, 1L)
                + "        \"order\" : 0,\n"
        );
        metadata.toXContent(builder, new ToXContent.MapParams(mapParams));
                + "        \"rollover_info\" : {\n"
        assertThat(
import org.opensearch.common.compress.CompressedXContent;
        return Metadata.builder()  
                    .putAlias(newAliasMetadataBuilder("alias-bar3").routing("routing-bar"))  
                + "          \"num_of_root_shards\" : 1,\n"
import static org.opensearch.cluster.metadata.AliasMetadata.newAliasMetadataBuilder;  
        Metadata.FORMAT.toXContent(builder, metadata);
                + "    },\n"  
                + "        \"mappings\" : {\n"
    public void testToXContentAPI_SameTypeName() throws IOException {
                + "        \"acceptedConfigurationNodeId\"\n"
        );
                    .putAlias(newAliasMetadataBuilder("alias4").filter(ALIAS_FILTER2))  
                + "      }\n"
                    .settings(Settings.builder().put("setting1", "value1").put("setting2", "value2"))  
import org.opensearch.core.xcontent.ToXContent;
                + "            \"key\" : \"value\"\n"
            builder.toString()  
                + "        \"primary_terms_map\" : {\n"  
                + "    },\n"  
        }  
                + "        \"mapping_version\" : 1,\n"
                + "        \"rollover_info\" : { },\n"  
                + "    \"cluster_uuid_committed\" : false,\n"
                + "          \"0\" : [\n"
                + "          \"0\" : [\n"
                + "          \"alias\"\n"
    private static final String MAPPING_SOURCE1 = "{\"mapping1\":{\"text1\":{\"type\":\"string\"}}}";  
                + "      \"voting_config_exclusions\" : [\n"
                + "        },\n"
                    .patterns(Collections.singletonList("bar"))
 * specific language governing permissions and limitations
                + "          \"type\" : {\n"  
                + "          \"node_id\" : \"exlucdedNodeId\",\n"  
                + Version.CURRENT.id
                + "  }\n"
                + "          \"node_name\" : \"excludedNodeName\"\n"  
        public String getWriteableName() {  
                    .numberOfReplicas(2)  
        assertEquals(  
        assertThat(parsedMetadata.dataStreams().get("data-stream1").getTimeStampField().getName(), is("@timestamp"));
                        Collections.singletonMap("alias", AliasMetadata.builder("alias").build())
                put("reduce_mappings", "true");
                + "          \"index.number_of_shards\" : \"1\",\n"  
            )  
                        }
        Map<String, String> mapParams = new HashMap<String, String>() {
        assertThat(parsedMetadata.componentTemplates().get("component_template").version(), is(5L));  
                    .creationDate(2L)  
import static org.opensearch.cluster.DataStreamTestHelper.createFirstBackingIndex;
            .clusterUUID("clusterUUID")  
            .put(
                + Version.CURRENT.id
                + "      ],\n"  
                + "          }\n"
                + "        \"aliases\" : { }\n"
    public static class CustomMetadata extends TestCustomMetadata {
                + "      \"index\" : {\n"  
        builder.startObject();
                + "        },\n"
                + "        \"mappings\" : {\n"
                + "          \"0\" : 1\n"
                    .lastAcceptedConfiguration(new CoordinationMetadata.VotingConfiguration(new HashSet<String>() {
                + "        \"routing_num_shards\" : 1,\n"
                + "\"\n"
                    Collections.singletonMap("my_meta", Collections.singletonMap("foo", "bar"))
                + "    \"cluster_coordination\" : {\n"
                + "          \"is_paused\" : false\n"
                + "            \"number_of_shards\" : \"1\",\n"
        assertThat(parsedMetadata.templates().get("foo").name(), is("foo"));
        final Metadata metadata = buildMetadata();
        assertEquals(  
                + "        \"commitedConfigurationNodeId\"\n"
import java.util.HashSet;  
        Map<String, String> mapParams = new HashMap<String, String>() {  
        @Override
                + "      \"voting_config_exclusions\" : [\n"  
            .put(
                    Settings.builder().put("setting", "value").build(),  
                + "      \"last_accepted_config\" : [ ],\n"
    private static final String MAPPING_SOURCE2 = "{\"mapping2\":{\"text2\":{\"type\":\"string\"}}}";
                + "          \"rolloveAlias\" : {\n"  
                + "          \"type\" : {\n"
                + "          \"0\" : 1\n"
                + "    },\n"
                + "        },\n"  
                + "            }\n"  
                + "\"\n"  
            parsedMetadata.templates().get("foo").aliases().get("alias-bar2").filter().string(),  
                + "            \"number_of_replicas\" : \"2\",\n"
            .put(  
                + "        },\n"
                + "        \"primary_terms_map\" : {\n"  
                    .numberOfShards(1)
                + "        },\n"
                + "            }\n"
                    .settings(Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT.id))  
 */
                + "    \"templates\" : {\n"  
                + "        \"index_patterns\" : [\n"
                + "      \"term\" : 1,\n"  
                + "    \"cluster_uuid\" : \"clusterUUID\",\n"  
                + "          \"pattern1\",\n"
 */  
                            add("acceptedConfigurationNodeId");  
                + "        },\n"
    public void testToXContentGateway_FlatSettingTrue_ReduceMappingFalse() throws IOException {
import java.io.IOException;  
            builder.toString()
                            add("allocationId");
            equalTo(
                + "        \"state\" : \"open\",\n"  
                + "          }\n"
                + "              \"created\" : \""  
import java.util.Arrays;
                + "        \"split_shards_metadata\" : {\n"  
                + "    },\n"
import java.util.ArrayList;
                put(Metadata.CONTEXT_MODE_PARAM, CONTEXT_MODE_API);
 * compatible open source license.
                + "        \"version\" : 2,\n"
            equalTo(Collections.singletonMap("my_meta", Collections.singletonMap("potato", "chicken")))  
        assertThat(parsedMetadata.templatesV2().get("index_templatev2").composedOf(), is(Collections.singletonList("component_template")));  
                + "          \"node_id\" : \"exlucdedNodeId\",\n"
                + "        \"mappings\" : { },\n"
                    .build()
                + "    }\n"  
 * this work for additional information regarding copyright
import java.util.Collections;  
                + "            0\n"  
                + "        \"commitedConfigurationNodeId\"\n"
            parsedMetadata.templatesV2().get("index_templatev2").template(),  
                + "          \"node_id\" : \"exlucdedNodeId\",\n"  
                + "        \"commitedConfigurationNodeId\"\n"
import org.opensearch.test.TestCustomMetadata;
            .coordinationMetadata(CoordinationMetadata.builder().build())
                + "\"\n"
                    .putAlias(newAliasMetadataBuilder("alias-bar3").routing("routing-bar"))  
                + "          \"root_shards_to_all_children\" : { },\n"  
                + "          \"index\" : {\n"
                + "        \"in_sync_allocations\" : {\n"  
                put("flat_settings", "true");  
                + "    \"cluster_coordination\" : {\n"
                + "    \"index-graveyard\" : {\n"
            "{\n"
        builder.startObject();
                + "        \"order\" : 0,\n"
                    }))
    }  
                        new MappingMetadata(
            }
                + "        \"settings\" : {\n"
        Metadata metadata = buildMetadata();
                + "        },\n"
                IndexTemplateMetadata.builder("foo")  
                    .settings(Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT.id))
                + "          ],\n"
                + "            \"allocationId\"\n"
                + "          ],\n"
                + "    \"cluster_uuid_committed\" : false,\n"
                + "      ],\n"
                "component_template",  
            .put(new DataStream("data-stream2", createTimestampField("@timestamp"), List.of(idx2.getIndex())))
                + "          }\n"  
                + "        ],\n"
                + "        \"primary_terms\" : {\n"  
            )
    private Metadata buildMetadata() throws IOException {
            )
                + "        }\n"
        );
                + "        },\n"
                + "        \"mapping_version\" : 1,\n"
                + "      }\n"
                + "    }\n"  
                + "      ],\n"  
                                {  
                + "      \"last_committed_config\" : [\n"
                + "        ],\n"  
                        new CompressedXContent("{\"baz\":\"eggplant\"}"),
        }
            "{\n"
                + Version.CURRENT.id
                    .putMapping(MAPPING_SOURCE1)  
                + "        \"split_shards_metadata\" : {\n"
                + "      ],\n"  
                + "            }\n"  
        // component template
                + "    \"index-graveyard\" : {\n"
 * The OpenSearch Contributors require contributions made to  
        metadata.toXContent(builder, new ToXContent.MapParams(mapParams));  
                + "    \"indices\" : {\n"
                    .putAlias(newAliasMetadataBuilder("alias3").writeIndex(randomBoolean() ? null : randomBoolean()))
        }  
                + "          \"node_id\" : \"exlucdedNodeId\",\n"  
                + "    \"indices\" : {\n"
                + "              \"created\" : \""
