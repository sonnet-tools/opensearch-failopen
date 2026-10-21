            .indices()
            .execute()
                .setMapping("{\"_routing\":{\"required\":false}}", MediaTypeRegistry.JSON)
                .setOrder(order)
import static org.hamcrest.Matchers.notNullValue;
        assertThat(getTemplate1Response.getIndexTemplates(), hasSize(2));
            .get();
            () -> client().admin()
                    .endObject()
            .preparePutTemplate("template_with_aliases")
            .setPatterns(Collections.singletonList("a*"))
    public void testIndexTemplateWithAliasesInSource() {
            .addAlias(new Alias("alias4"))
                        .endObject()
        assertEquals(
        searchResponse = client().prepareSearch("templated_alias-test_index").get();
 * GitHub history for details.
        logger.info("--> get template template_1");
                XContentFactory.jsonBuilder()
        // clean all templates setup by the framework.
                        .endObject()
                    .startObject("field2")
        ensureGreen();
            .execute()
        assertRequestBuilderThrows(
        // field2 is not stored.
                    .endObject()
        client().admin()
        assertHitCount(searchResponse, 1L);
            .setOrder(0)
                    + "         }\n"
            .execute()
                        .startObject("properties")
        );
                    .field("type", "keyword")
        assertNull(searchResponse.getHits().getAt(0).field("field2"));
            .preparePutTemplate("template2")
            .setPatterns(Collections.singletonList("te*"))
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
            .preparePutTemplate("template_1")
                    .startObject("field1")
        assertThat(templateNames, containsInAnyOrder("template_1", "template_2"));
                    .field("type", "text")
            )
                .get();
                    .startObject("field2")
        logger.info("--> get templates template_1 and template_2");
        client().admin()
        ensureGreen();
        client().prepareIndex("test_index").setId("2").setSource("field", "value2").get();
import static org.hamcrest.Matchers.empty;
        // no templates yet
        client().admin()
import static org.hamcrest.Matchers.containsString;
import org.opensearch.indices.InvalidIndexTemplateException;
                    .endObject()
        prepareCreate("test_good", Settings.builder().put("index.number_of_shards", 7).put("index.number_of_routing_shards", 7)).get();
        templateNames.add(getTemplate1Response.getIndexTemplates().get(1).name());
                .preparePutTemplate("template_1")
                .get()
/*
        try {
            () -> prepareCreate("test_bad", Settings.builder().put("index.number_of_shards", 5).put("index.number_of_routing_shards", 5))
                        .field("store", false)
        // now only match on one template (template_1)
            () -> client().admin()
            .addAlias(new Alias("alias3"))
 * not use this file except in compliance with the License.
        // index something into test_index, will match on both templates
                .setSettings(Settings.builder().put("index.routing_partition_size", "6"))
            .setMapping("type", "type=keyword", "field", "type=text")
            .indices()
            .addAlias(new Alias("alias4").filter(termQuery("field", "value")))
                new BytesArray(
        GetIndexTemplatesResponse response = client().admin().indices().prepareGetTemplates("template_1").get();
                )
        logger.info("--> get template null");
            .addAlias(new Alias("filtered_alias").filter("{\"term\":{\"type\":\"type2\"}}"))
import org.opensearch.index.mapper.MapperParsingException;
    public void testMultipleAliasesPrecedence() throws Exception {
                    .startObject("properties")
            } else if ("alias3".equals(aliasMetadata.alias())) {
                    .field("store", true)
            )
            .get();
                    .endObject()
    @After
    public void testIndexTemplateWithAliasesSource() {
    public void testBrokenMapping() throws Exception {
        return Collections.singleton(InternalSettingsPlugin.class);
    }
                    + "         },\n"
        logger.info("--> explicitly delete template_1");
        assertThat(getAliasesResponse.getAliases().size(), equalTo(1));
        getTemplate1Response = client().admin().indices().prepareGetTemplates("template*").execute().actionGet();
    }
        client().admin()
    public void testAliasNameExistingIndex() throws Exception {
import static org.hamcrest.Matchers.is;
                    + "                }\n"
                XContentFactory.jsonBuilder()
            .indices()
            updated++;
            .setPatterns(Collections.singletonList("te*"))
            .setOrder(0)
            types.add(searchHit.getSourceAsMap().get("type").toString());
            .indices()
            .setSettings(indexSettings())
            .setQuery(termQuery("field1", "value1"))
    }
    public void testAliasInvalidFilterValidJson() throws Exception {
    }
        );
import java.util.ArrayList;
        SearchResponse searchResponse = client().prepareSearch("test_index")
        assertNull(searchResponse.getHits().getAt(0).field("field2"));
    }
                .preparePutTemplate("template_1")
                MediaTypeRegistry.JSON
            .setOrder(0)
        SearchResponse searchResponse = client().prepareSearch("test_index").get();
        assertThat(e.getCause(), instanceOf(ParsingException.class));
            client().admin()
                    .endObject()
        GetIndexTemplatesResponse getTemplate1Response = client().admin().indices().prepareGetTemplates("template_*").execute().actionGet();
                .setPatterns(Arrays.asList("a*", "b*"))
    }
        assertAcked(
            .setMapping(
            .addStoredField("field1")
        client().admin()
        IllegalArgumentException eBadIndex = expectThrows(
    public void testInvalidSettings() throws Exception {
    public void testOrderAndVersion() {
            .execute()
            .setPatterns(Collections.singletonList("te*"))
                        + "                \"term\" : {\n"
            ActionRequestValidationException.class,
        GetIndexTemplatesResponse response = client().admin().indices().prepareGetTemplates().get();
                .setCreate(true)
        assertThat(getTemplate1Response.getIndexTemplates().get(0).getVersion(), is(123));
                XContentFactory.jsonBuilder()
                "    {\n"
                .setPatterns(Arrays.asList("a*", "b*"))
                    .startObject()
        assertThat(searchResponse.getHits().getAt(0).getSourceAsMap().get("type"), equalTo("type2"));
            .addStoredField("field2")
        );
                        + "    \"template\" : \"*\",\n"
            client().admin()
 * this work for additional information regarding copyright
                    .field("type", "text")
                .setPatterns(Arrays.asList("a*", "b*"))
        );
        // filters exist in the mapping.
        logger.info("--> put template_1 and template_2");
            .get();
        templateNames.add(getTemplate1Response.getIndexTemplates().get(0).name());
import org.opensearch.plugins.Plugin;
            .indices()
            .setSettings(
            .execute()
        searchResponse = client().prepareSearch("my_alias").get();
                    .startObject("properties")
 * ownership. Elasticsearch licenses this file to you under
        assertThat(getTemplate1Response.getIndexTemplates().get(0), is(notNullValue()));
            MapperParsingException.class,
        client().prepareIndex("bx").setId("1").setSource("field1", "value1", "field2", "value2").setRefreshPolicy(IMMEDIATE).get();
        testExpectActionRequestValidationException((String[]) null);
                .indices()
        response = client().prepareBulk().add(new IndexRequest("b2").id("test").source("{}", MediaTypeRegistry.JSON)).get();
        client().admin()
        );
import org.opensearch.search.SearchHit;
                    .endObject()
                    .field("type", "keyword")
                    .startObject()
            .indices()
                XContentFactory.jsonBuilder()
                .setPatterns(Collections.singletonList("test*"))
            } else if ("test-alias".equals(aliasMetadata.alias())) {
            .preparePutTemplate("template_1")
        logger.info("--> put template3");
                        .field("type", "text")
    }
                    .field("store", false)
        logger.info("--> put template_1 back");
                .get()
            .setSettings(indexSettings())
import static org.hamcrest.Matchers.containsInAnyOrder;
    }
        client().admin()
            )
        for (AliasMetadata aliasMetadata : getAliasesResponse.getAliases().get("test")) {
        client().prepareIndex("text_index").setId("1").setSource("field1", "value1", "field2", "value 2").setRefreshPolicy(IMMEDIATE).get();
        client().admin().indices().prepareDeleteTemplate("*").get();
                XContentFactory.jsonBuilder()
                    .endObject()
            () -> client().admin()
        client().prepareIndex("test_index").setId("4").setSource("type", "typeY", "field", "D value").get();
        assertThat(response.getIndexTemplates(), hasSize(0));
            .setOrder(0)
                    + "            }\n"
                    .endObject()
        int order = randomInt();
        assertThat(response.getIndexTemplates().get(0).getAliases().get("my_alias").filter().string(), containsString("\"value1\""));
                    + "                \"term\" : {\n"
            .preparePutTemplate("template_1")
 * compatible open source license.
        // invalid filter but valid json: put index template works fine, fails during index creation
                ),
                    .field("store", true)
                "    {\n"
            .actionGet();
                        + "                }\n"
}
            )
        assertThat(
                    .field("type", "text")
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> putIndexTemplateRequestBuilder.get());
                .preparePutTemplate("template_1")
                    .endObject()
        assertThat(getTemplate1Response.getIndexTemplates(), hasSize(3));
                "index_template [template_1] invalid, cause [Validation Failed: 1: expected total copies needs to be a multiple of total awareness attributes [3];]",
            updated++;
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 4))
            .indices()
        logger.info("--> get template empty");
            .indices()
                    .field("type", "keyword")
        assertThat(response.getIndexTemplates(), empty());
            .addAlias(new Alias("alias1").routing("test"))
    }
            .setOrder(0)
import org.opensearch.cluster.metadata.AliasMetadata;
        IllegalArgumentException eBadSettings = expectThrows(
            .addStoredField("field2")
        // for filters to work correctly ES required that fields mentioned in those
        assertHitCount(searchResponse, 1);
            .actionGet();
        assertThat(e.getMessage(), containsString("analyzer [custom_1] has not been configured in mappings"));
        IllegalArgumentException eBadMapping = expectThrows(
                    .startObject("properties")
                    .startObject()
        // Search the complex filter alias
                    .endObject()
        } catch (InvalidIndexTemplateException e) {
                .indices()
            .setMapping(
        assertHitCount(searchResponse, 2L);
        // clean all templates setup by the framework.
            .setOrder(1)
                    .field("store", false)
        assertThat(response.getIndexTemplates().get(0).getOrder(), equalTo(order));
        assertThat(response.getIndexTemplates(), empty());
    public void testThatGetIndexTemplatesWithSimpleRegexWorks() throws Exception {
        assertThat(response.getItems()[0].getIndex(), equalTo("a2"));
            SettingsException.class,
                        + "        \"my_alias\" : {\n"
        assertThat(
        refresh();
            .indices()
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
            .setMapping(
                    .endObject()
    @Override
            .setPatterns(Collections.singletonList("test*"))
        // check get all templates on an empty index.
        client().admin()
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2))
                        .startObject()
        MapperParsingException e = expectThrows(
        } finally {
            .setOrder(0)
 */
            eBadSettings.getMessage(),
                .setPatterns(Collections.singletonList("test*"))
        // finally, create a valid index
        assertNull(getSettingsResponse.getIndexToSettings().get("test").get("index.does_not_exist"));
            .execute()
                        .endObject()
            .setPatterns(Collections.singletonList("te*"))
            .actionGet();
                    .startObject("properties")
                        .field("analyzer", "custom_1")
        assertThat(templateNames, containsInAnyOrder("template_1", "template_2"));
        assertThat(response.getIndexTemplates().size(), equalTo(1));
            .addAlias(new Alias("invalid_alias").filter("abcde"));
                .indices()
                .indices()
        assertHitCount(searchResponse, 1);
            .preparePutTemplate("template_1")
        // invalid json: put index template fails
        assertHitCount(searchResponse, 3L);
        logger.info("--> get template template_*");
            .get();
                    .field("store", true)
            .setAliases(
            .addAlias(new Alias("my_alias").filter(termQuery("field", "value1")))
            .addAlias(new Alias("alias3").filter(QueryBuilders.boolQuery().mustNot(QueryBuilders.existsQuery("test"))))
                .get()
        assertThat(response.getIndexTemplates().get(0).getVersion(), equalTo(version));
                    .endObject()
            .setPatterns(Collections.singletonList("te*"))
                    .startObject("properties")
    public void testDeleteIndexTemplate() throws Exception {
                assertThat(aliasMetadata.filter(), nullValue());
                    .field("type", "text")
    public void testAliasEmptyName() throws Exception {
                        .startObject("properties")
                    .field("type", "text")
        client().admin()
            .get();
        assertThat(types.size(), equalTo(3));
        // put template using custom_1 analyzer
        assertThat(response.getItems()[0].getId(), equalTo("test"));
        SettingsException e = expectThrows(
        // a valid configuration that only provides the partition size
        assertThat(
    public void testIndexTemplateWithAliases() throws Exception {
import org.opensearch.cluster.ClusterState;
            .preparePutTemplate("template_1")
                .get()
        // provide more partitions than shards
            )
            .get();
        // base template
        );
                .preparePutTemplate("template_1")
            .setQuery(termQuery("field1", "value1"))
    }
                .get();
            .setPatterns(Collections.singletonList("test*"))
    }
        assertThat(e.getMessage(), equalTo("alias [alias] has several index routing values associated with it"));
            .indices()
                    .startObject("field1")
        assertEquals(0, response.getIndexTemplates().size());
        assertThat(response.getIndexTemplates().get(0).getAliases().size(), equalTo(1));
        ensureGreen();
            .addStoredField("field2")
        assertAcked(prepareCreate("test_index"));
            IllegalArgumentException.class,
            .setVersion(123)
            client().admin()
                    .field("store", true)
        );
        // check get all templates on an empty index.
            .execute()
        // clean all templates setup by the framework.
                .setSettings(Settings.builder().put("index.number_of_shards", "6").put("index.routing_partition_size", "3"))
        assertThat(response.hasFailures(), is(false));
                    .field("type", "keyword")
            .get();
                    .startObject("field2")
            .addStoredField("field1")
        templateNames = new ArrayList<>();
import java.util.Collections;
            .preparePutTemplate("template_2")
        // Indexing into b index should fail, since there is field with name 'field' in the mapping
            .execute()
import static org.opensearch.index.query.QueryBuilders.termQuery;
        logger.info("--> delete template*");
                e.getMessage()
        // check get all templates on an empty index.
            .preparePutTemplate("template_2")
            .execute()
            .prepareGetTemplates("non-existing-template")
        // an index that doesn't exist yet will succeed
            .get();
        refresh();
        client().prepareIndex("b1").setId("test").setSource("{}", MediaTypeRegistry.JSON).get();
        );
                    + "        \"index\" : {\n"
                    .startObject("field2")
 * software distributed under the License is distributed on an
            .actionGet();
            manageReplicaSettingForDefaultReplica(false);
            .setPatterns(Arrays.asList("a*", "b*"))
                        + "    }\n"
        admin().indices().prepareDeleteTemplate("*").execute().actionGet();
        // Now, a complete mapping with two separated templates is error
                    + "                    \"field\" : \"value2\"\n"
            .actionGet();
            .actionGet();
            .setMapping(
                        .startObject()
        assertThat(searchResponse.getHits().getAt(0).field("field1").getValue().toString(), equalTo("value1"));
        }
 * specific language governing permissions and limitations
                    .field("type", "text")
        client().prepareIndex("test_index").setId("1").setSource("type", "type1", "field", "A value").get();
        logger.info("--> get non-existing-template");
        logger.info("--> delete * with no templates, make sure we don't get a failure");
    }
            .indices()
                        + "    \"aliases\" : {\n"
                .get()
        assertHitCount(searchResponse, 5L);
            .indices()
            .addStoredField("field1")
        GetAliasesResponse getAliasesResponse = client().admin().indices().prepareGetAliases().setIndices("test_index").get();
            .setOrder(0)
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse;
import org.opensearch.core.common.ParsingException;
            .preparePutTemplate("template_1")
        templateNames.add(getTemplate1Response.getIndexTemplates().get(1).name());
                assertThat(aliasMetadata.searchRouting(), equalTo("test-routing"));
                    .field("type", "text")
                    .startObject("field2")
                    .field("type", "keyword")
        assertEquals("6", getSettingsResponse.getIndexToSettings().get("test_good").get("index.routing_partition_size"));
        }
                .indices()
        GetIndexTemplatesResponse response = client().admin().indices().prepareGetTemplates().get();
            .preparePutTemplate("template4")
            .addAlias(new Alias("templated_alias-{index}"))
        // Before 2.0 alias filters were parsed at alias creation time, in order
            .setPatterns(Collections.singletonList("d*"))
            )
    }
    }
                ),
        client().prepareIndex("test_index").setId("5").setSource("type", "typeZ", "field", "E value").get();
        assertEquals("value1", searchResponse.getHits().getAt(0).field("field1").getValue().toString());
    public void testThatInvalidGetIndexTemplatesFails() throws Exception {
        logger.info("--> put template_1");
                    .startObject("properties")
                    .endObject()
                .setMapping(
                XContentFactory.jsonBuilder()
            .get();
        assertHitCount(searchResponse, 2L);
import static org.hamcrest.Matchers.equalTo;
    public void testDuplicateAlias() throws Exception {
        PutIndexTemplateRequestBuilder putIndexTemplateRequestBuilder = client().admin()
            .setMapping(
 *    http://www.apache.org/licenses/LICENSE-2.0
            .setPatterns(Collections.singletonList("*"))
                    + "        \"alias3\" : { \"routing\" : \"1\" }"
            fail("should have thrown an exception about the replica  count");
            )
 * SPDX-License-Identifier: Apache-2.0
    }
        // fields mentioned in filters don't need to exist in the mapping.
                    + "                        \"tokenizer\" : \"standard\"\n"
import static org.hamcrest.Matchers.nullValue;
                .setPatterns(Collections.singletonList("te*"))
        assertRequestBuilderThrows(
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0))
                    .field("type", "text")
        assertThat(e.getMessage(), equalTo("alias name is required"));
        client().admin().indices().prepareDeleteTemplate("*").get();
        assertThat(getAliasesResponse.getAliases().size(), equalTo(1));
 *
                .setMapping(
        createIndex("test");
/*
            .addStoredField("field2")
            equalTo(existingTemplates)
        GetSettingsResponse getSettingsResponse = client().admin().indices().prepareGetSettings("test_good").get();
                MediaTypeRegistry.JSON
        GetIndexTemplatesResponse response = client().admin().indices().prepareGetTemplates().get();
                    .endObject()
                    .field("store", true)
        searchResponse = client().prepareSearch("alias2").get();
        assertHitCount(searchResponse, 5L);
                    .startObject("field1")
        testExpectActionRequestValidationException("a", "", "c");
                    + "        \"alias1\" : {},\n"
            .actionGet();
            .addAlias(new Alias("simple_alias"))
        // test create param
        // ax -> matches template
        assertThat(response.getItems()[0].isFailed(), equalTo(false));
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.test.InternalSettingsPlugin;
        // So the aliases defined in the index template for this index will not fail
        searchResponse = client().prepareSearch("complex_filtered_alias").get();
            .preparePutTemplate("template1")
                .setPatterns(Collections.singletonList("te*"))
            .get();
            client().admin()
                .setSettings(Settings.builder().put("does_not_exist", "test"))
            .preparePutTemplate("template_1")
        logger.info("--> get template 'a', null, 'c'");
            client().admin()
                    .field("type", "text")
import org.opensearch.common.settings.SettingsException;
                        .endObject()
            .setPatterns(Collections.singletonList("te*"))
        assertHitCount(searchResponse, 1L);
            .execute()
                    .field("store", true)
                    + "                    \"custom_1\" : {\n"
            () -> client().admin()
                    .startObject("field1")
    public void testPartitionedTemplate() throws Exception {
        ensureGreen();
                    .endObject()
                .setSettings(indexSettings())
                assertThat(aliasMetadata.indexRouting(), equalTo("test"));
                    .field("store", true)
        // check get all templates on an empty index.
            .preparePutTemplate("template3")
                .get();
    }
        client().admin()
                .indices()
        assertThat(getTemplate1Response.getIndexTemplates().get(0).patterns(), is(Collections.singletonList("te*")));
            .addAlias(new Alias("index"))
        client().admin().indices().prepareDeleteTemplate("*").get();
    }
            .setOrder(1)
        GetAliasesResponse getAliasesResponse = client().admin().indices().prepareGetAliases().addIndices("test").get();
        testExpectActionRequestValidationException("a", null, "c");
            .indices()
                        .startObject("field2")
            .setPatterns(Collections.singletonList("te*"))
            .setOrder(0)
            .get();
            .preparePutTemplate("template_1")
        );
        assertThat(response.getIndexTemplates(), empty());
        client().admin()
import static org.hamcrest.Matchers.anyOf;
        response = client().admin().indices().prepareGetTemplates().get();
        GetIndexTemplatesResponse response = client().admin().indices().prepareGetTemplates().get();
        client().admin()
                .indices()
            .addAlias(new Alias("{index}-alias"))
                .get()
            admin().cluster().prepareState().execute().actionGet().getState().metadata().templates().size(),
        );
    public void testMultipleTemplate() throws IOException {
                    .field("type", "keyword")
                    + "    }\n"
            )
                .indices()
            updated++;
            }
                    .startObject("properties")
            .indices()
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> createIndex("test"));
 */
            );
            .actionGet();
    }
            .indices()
            .indices()
import org.opensearch.action.bulk.BulkResponse;
    }
        client().prepareIndex("test_index").setId("1").setSource("field1", "value1", "field2", "value 2").setRefreshPolicy(IMMEDIATE).get();
        admin().indices().prepareDeleteTemplate("template*").execute().actionGet();
                .indices()
        client().admin()
        templateNames.add(getTemplate1Response.getIndexTemplates().get(2).name());
    }
        BulkResponse response = client().prepareBulk().add(new IndexRequest("a2").id("test").source("{}", MediaTypeRegistry.JSON)).get();
        GetIndexTemplatesResponse response = client().admin().indices().prepareGetTemplates("template_1").get();
import org.opensearch.action.search.SearchResponse;
                .setOrder(1)
        // create an index with too few shards
                .indices()
                        .endObject()
                        .startObject("field2")
import org.opensearch.cluster.metadata.IndexMetadata;
        assertHitCount(searchResponse, 1L);
        assertThat(response.hasFailures(), is(false));
            .addStoredField("field1")
            .indices()
        assertThat(response.getIndexTemplates().get(0).getAliases().get("invalid_alias").filter().string(), equalTo("{\"invalid\":{}}"));
        client().admin().indices().prepareDeleteTemplate("*").get();
        admin().indices().prepareDeleteTemplate("template_1").execute().actionGet();
        assertThat(getAliasesResponse.getAliases().get("test_index").size(), equalTo(4));
        ensureGreen();
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> putIndexTemplateRequestBuilder.get());
        assertThat(eBadMapping.getMessage(), containsString("must have routing required for partitioned index"));
        GetAliasesResponse getAliasesResponse = client().admin().indices().prepareGetAliases().setIndices("test_index").get();
                    .field("store", true)
import org.opensearch.test.OpenSearchIntegTestCase;
        // check get all templates on an empty index.
                    .endObject()
            assertEquals(
                        + "            }\n"
        assertThat(getTemplate2Response.getIndexTemplates(), hasSize(0));
        assertThat(response.getItems()[0].isFailed(), equalTo(false));
                        + "            \"filter\" : {\n"
        assertThat(searchResponse.getHits().getAt(0).field("field2"), nullValue());
                .setPatterns(Collections.singletonList("te*"))
                    .field("type", "keyword")
        GetIndexTemplatesResponse getTemplate2Response = client().admin()
                .indices()
    }
                    + "            }\n"
        assertThat(response.getIndexTemplates(), empty());
            .indices()
            .setMapping("field", "type=text")
        response = client().admin().indices().prepareGetTemplates().get();
        GetIndexTemplatesResponse response = client().admin().indices().prepareGetTemplates("template_1").get();
            .setOrder(1)
        // even though the fields in the alias fields don't exist yet and indexing into
        if (searchResponse.getFailedShards() > 0) {
            .setSettings(indexSettings())
        assertThat(e.getMessage(), containsString("Failed to parse mapping "));
        assertThat(response.getIndexTemplates().size(), equalTo(1));
                    .endObject()
            .setMapping(
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "0-2"))
        client().prepareIndex("test_index").setId("3").setSource("type", "typeX", "field", "C value").get();
                    .startObject("field2")
            .setOrder(0)
                    .endObject()
        }
        // clean all templates setup by the framework.
            .setPatterns(Collections.singletonList("te*"))
                .preparePutTemplate("versioned_template")
        templateNames.add(getTemplate1Response.getIndexTemplates().get(0).name());
                        + "}"
        GetAliasesResponse getAliasesResponse = client().admin().indices().prepareGetAliases().setIndices("test_index").get();
        assertThat(e.getMessage(), equalTo("failed to parse filter for alias [invalid_alias]"));
                    .endObject()
        assertHitCount(searchResponse, 5L);
            .indices()
        ensureGreen();
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.settings.Settings;
                    .startObject()
        assertEquals("value1", searchResponse.getHits().getAt(0).field("field1").getValue().toString());
                    .field("store", true)
                    .startObject()
            .setQuery(termQuery("field1", "value1"))
            if ("alias1".equals(aliasMetadata.alias())) {
    public void testSimpleIndexTemplateTests() throws Exception {
        response = client().admin().indices().prepareGetTemplates().get();
                    .endObject()
        searchResponse = client().prepareSearch("simple_alias").get();
                .setPatterns(Collections.singletonList("te*"))
            logger.warn("failed search {}", Arrays.toString(searchResponse.getShardFailures()));
        Set<String> types = new HashSet<>();
                .preparePutTemplate("template_1")
        SearchResponse searchResponse = client().prepareSearch("ax")
import static org.hamcrest.Matchers.instanceOf;
            .actionGet();
                    + "        \"alias2\" : {\n"
        client().admin()
                XContentFactory.jsonBuilder()
        logger.info("--> put template_1");
                assertThat(aliasMetadata.indexRouting(), nullValue());
            .setPatterns(Collections.singletonList("te*"))
                    .field("store", true)
                .setCreate(true)
    public void cleanupTemplates() {
 * You may obtain a copy of the License at
        assertThat(getAliasesResponse.getAliases().get("test_index").size(), equalTo(1));
                    .endObject()
        GetIndexTemplatesResponse getTemplate1Response = client().admin().indices().prepareGetTemplates("template_1").execute().actionGet();
                    + "                    }\n"
import java.util.List;
            IllegalArgumentException.class,
            () -> client().admin()
 * The OpenSearch Contributors require contributions made to
    }
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        SearchResponse searchResponse = client().prepareSearch("test_index").get();
                XContentFactory.jsonBuilder()
        ClusterState state = admin().cluster().prepareState().execute().actionGet().getState();
        assertThat(getAliasesResponse.getAliases().size(), equalTo(1));
            .indices()
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> putIndexTemplateRequestBuilder.get());
            .actionGet();
        assertThat(getAliasesResponse.getAliases().get("test_index").size(), equalTo(3));
        assertEquals(0, response.getIndexTemplates().size());
        assertThat(searchResponse.getHits().getAt(0).field("field1").getValue().toString(), equalTo("value1"));
        searchResponse = client().prepareSearch("bx")
                .setMapping("{\"foo\": \"abcde\"}", MediaTypeRegistry.JSON)
        assertHitCount(searchResponse, 1);
            .get();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    XContentFactory.jsonBuilder()
                        + "                    \"field\" : \"value2\"\n"
                    .field("store", true)
            .addAlias(new Alias("invalid_alias").filter("{ \"invalid\": {} }"))
        Integer version = randomBoolean() ? randomInt() : null;
            client().admin()
            .preparePutTemplate("template_1")
                .setMapping("field", "type=text")
                    .endObject()
        GetIndexTemplatesResponse response = client().admin().indices().prepareGetTemplates().get();
                .setPatterns(Arrays.asList("a*", "b*"))
        );
            assertEquals(3, updated);
        client().admin()
        templateNames = new ArrayList<>();
            .setOrder(0)
                    .endObject()
                XContentFactory.jsonBuilder()
 * Modifications Copyright OpenSearch Contributors. See
                        .endObject()
    }
            .setPatterns(Collections.singletonList("te*"))
            .setMapping(
        client().prepareIndex("a1").setId("test").setSource("{}", MediaTypeRegistry.JSON).get();
    public void testAliasWithMultipleIndexRoutings() throws Exception {
            .indices()
        client().admin()
        assertAcked(prepareCreate("test_index"));
        assertThat(response.getIndexTemplates(), empty());
        assertThat(response.getItems()[0].getVersion(), equalTo(1L));
        templateNames.add(getTemplate1Response.getIndexTemplates().get(0).name());
import static org.hamcrest.Matchers.hasSize;
            .addAlias(new Alias("  ").indexRouting("1,2,3"));
                    .startObject()
        logger.info("--> get all templates");
    private void testExpectActionRequestValidationException(String... names) {
                    XContentFactory.jsonBuilder()
                .preparePutTemplate("template_2")
            .addAlias(new Alias("my_alias").filter(termQuery("field", "value2")))
        GetSettingsResponse getSettingsResponse = client().admin().indices().prepareGetSettings("test").get();
                    .startObject()
                    .startObject("field1")
                    .endObject()
            "get template with " + Arrays.toString(names)
        client().prepareIndex("ax").setId("1").setSource("field1", "value1", "field2", "value2").setRefreshPolicy(IMMEDIATE).get();
        refresh();
        );
                    .endObject()
        PutIndexTemplateRequestBuilder putIndexTemplateRequestBuilder = client().admin()
                    .field("store", true)
        manageReplicaSettingForDefaultReplica(true);
                    .field("type", "text")
                    + "    }\n",
                    .endObject()
        assertThat(e.getMessage(), equalTo("Invalid alias name [index], an index exists with the same name as the alias"));
                    .endObject()
        client().prepareIndex("test_index").setId("2").setSource("field", "value2").get();
            .setQuery(termQuery("field1", "value1"))
            )
        client().admin()
        assertThat(response.getIndexTemplates().size(), equalTo(0));
                .get()
        assertHitCount(searchResponse, 2L);
            .indices()
        );
        templateNames.add(getTemplate1Response.getIndexTemplates().get(1).name());
                    .startObject()
            .setPatterns(Collections.singletonList("te*"))
            MapperParsingException.class,
            client().admin()
            .actionGet();
                    .startObject("field2")
                    .endObject()
            .setPatterns(Collections.singletonList("te*"))
            )
 *
                .preparePutTemplate("template_2")
                    .endObject()
import org.opensearch.action.admin.indices.template.put.PutIndexTemplateRequestBuilder;
import java.io.IOException;
                    .startObject("field1")
        assertAcked(prepareCreate("test").addAlias(new Alias("test-alias").searchRouting("test-routing")));
        assertThat(response.getItems()[0].getVersion(), equalTo(1L));
        getTemplate1Response = client().admin().indices().prepareGetTemplates("template_1", "template_2").execute().actionGet();
    public void testThatGetIndexTemplatesWorks() throws Exception {
        assertThat(getTemplate1Response.getIndexTemplates().get(0).getOrder(), is(0));
        );
                    .endObject()
                    .startObject("properties")
        assertAcked(
        ensureGreen();
import java.util.HashSet;
            .addAlias(new Alias("complex_filtered_alias").filter(QueryBuilders.termsQuery("type", "typeX", "typeY", "typeZ")))
                .setSettings(Settings.builder().put("index.number_of_shards", "5").put("index.routing_partition_size", "6"))
/*
                    .startObject("field2")
                    .startObject("properties")
        response = client().admin().indices().prepareGetTemplates().get();
            .setMapping(
        assertThat(searchResponse.getHits().getAt(0).field("field2").getValue().toString(), equalTo("value 2"));
                    .endObject()
import java.util.Arrays;
            )
package org.opensearch.indices.template;
            .setPatterns(Collections.singletonList("te*"))
            .preparePutTemplate("template_1")
        assertThat(state.metadata().templates().containsKey("template_1"), equalTo(false));
        List<String> templateNames = new ArrayList<>();
        response = client().admin().indices().prepareGetTemplates().get();
            )
                    .startObject()
        client().admin().indices().prepareDeleteTemplate("*").get();
        assertThat(types, containsInAnyOrder("typeX", "typeY", "typeZ"));
        // provide an invalid mapping for a partitioned index
 * license agreements. See the NOTICE file distributed with
    public void testCombineTemplates() throws Exception {
            .setSource(
        SearchResponse searchResponse = client().prepareSearch("test_index").get();
            "unknown setting [index.does_not_exist] please check that any required plugins are"
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            .actionGet();
            )
            IllegalArgumentException.class
 * under the License.
        assertThat(response.getIndexTemplates(), hasSize(1));
import org.opensearch.common.xcontent.XContentFactory;
import org.opensearch.index.query.QueryBuilders;
        assertThat(admin().cluster().prepareState().execute().actionGet().getState().metadata().templates().size(), equalTo(0));
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
                .setPatterns(Collections.singletonList("te*"))
                    .endObject()
            assertThat(aliasMetadata.alias(), anyOf(equalTo("alias1"), equalTo("test-alias"), equalTo("alias3"), equalTo("alias4")));
        // From 2.0 and higher alias filters are parsed at request time and therefor
        client().prepareIndex("test_index").setId("1").setSource("field", "value1").get();
        client().admin()
            .preparePutTemplate("template_1")
                    .endObject()
                .indices()
import org.junit.After;
        client().admin().indices().prepareDeleteTemplate("*").get();
        assertThat(response.getItems()[0].getId(), equalTo("test"));
        client().admin()
        assertThat(getTemplate1Response.getIndexTemplates(), hasSize(2));
        searchResponse = client().prepareSearch("filtered_alias").get();
                        + "        }\n"
import org.opensearch.core.common.bytes.BytesArray;
                    .field("store", true)
            eBadIndex.getMessage(),
        logger.info("--> get template 'a', '', 'c'");
                .preparePutTemplate("template_1")
            .setPatterns(Collections.singletonList("te*"))
    public void testAliasInvalidFilterInvalidJson() throws Exception {
            .setMapping(
        assertThat(state.metadata().templates().containsKey("template_2"), equalTo(true));
        }
                    .startObject("field2")
        assertThat(e.getMessage(), equalTo("failed to parse filter for alias [invalid_alias]"));
                        .field("type", "text")
                    + "                }\n"
import org.opensearch.indices.InvalidAliasNameException;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .preparePutTemplate("template_1")
        assertThat(state.metadata().templates().size(), equalTo(1 + existingTemplates));
            .preparePutTemplate("template1")
            .indices()
        assertThat(e.getCause().getMessage(), equalTo("unknown query [invalid]"));
                    .endObject()
                .get();
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.ActionRequestValidationException;
            .setPatterns(Collections.singletonList("*"))
                XContentFactory.jsonBuilder()
        assertThat(searchResponse.getHits().getAt(0).getSourceAsMap().get("field"), equalTo("value2"));
                    .startObject("field2")
        client().admin()
            .setPatterns(Collections.singletonList("te*"))
            .preparePutTemplate("template_1")
        assertHitCount(searchResponse, 1);
 *
        // Indexing into a should succeed, because the field mapping for field 'field' is defined in the test mapping.
                .setVersion(version)
            .indices()
        // clean all templates setup by the framework.
            .addAlias(new Alias("alias1").filter(termQuery("field", "value")))
                    .field("type", "text")
                .setPatterns(Collections.singletonList("te*"))
            e.getMessage()
        assertThat(response.getIndexTemplates(), hasSize(2));
                    .endObject()
            .preparePutTemplate("template_2")
        MapperParsingException e = expectThrows(
                    .endObject()
        logger.info("--> put template_2");
                    + "            \"analysis\" : {\n"
                .setOrder(1)
                    "{\n"
        int updated = 0;
        GetIndexTemplatesResponse response = client().admin().indices().prepareGetTemplates("versioned_template").get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;
public class SimpleIndexTemplateIT extends OpenSearchIntegTestCase {
        client().admin()
        assertAcked(prepareCreate("test_index"));
        final int existingTemplates = admin().cluster().prepareState().execute().actionGet().getState().metadata().templates().size();
            .preparePutTemplate("template_1")
        testExpectActionRequestValidationException("");
            .setPatterns(Collections.singletonList("te*"))
                    .field("store", true)
        assertThat(searchResponse.getHits().getAt(0).getSourceAsMap().get("field"), equalTo("value2"));
                    .endObject()
            .execute()
                assertThat(aliasMetadata.searchRouting(), equalTo("test"));
                    .startObject("field1")
            .preparePutTemplate("template_1")
                    .field("store", false)
                    .field("store", true)
                + " installed, or check the breaking changes documentation for removed settings",
    public void testStrictAliasParsingInIndicesCreatedViaTemplates() throws Exception {
                .preparePutTemplate("template_2")
        assertThat(getTemplate1Response.getIndexTemplates(), hasSize(1));
        InvalidAliasNameException e = expectThrows(InvalidAliasNameException.class, () -> createIndex("test"));
        // bx -> matches template
        for (SearchHit searchHit : searchResponse.getHits().getHits()) {
        searchResponse = client().prepareSearch("text_index")
            .addAlias(new Alias("alias1"))
            .execute()
        assertThat(response.getIndexTemplates().size(), equalTo(1));
            .setMapping(
        PutIndexTemplateRequestBuilder putIndexTemplateRequestBuilder = client().admin()
    }
            .indices()
    }
            containsString("partition size [6] should be a positive number " + "less than the number of shards [5]")
                    .endObject()
                    .startObject("properties")
            IllegalArgumentException.class,
import org.opensearch.action.index.IndexRequest;
    public void testAwarenessReplicaBalance() throws IOException {
import org.opensearch.action.admin.indices.alias.get.GetAliasesResponse;
                .preparePutTemplate("just_partitions")
            client().admin().indices().prepareGetTemplates(names),
        client().prepareIndex("test_index").setId("2").setSource("type", "type2", "field", "B value").get();
                    + "            \"filter\" : {\n"
    }
        client().prepareIndex("test_index").setId("1").setSource("field", "value1").get();
        createIndex("index");
import java.util.Collection;
                    .startObject("field1")
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertThat(templateNames, containsInAnyOrder("template_1", "template_2", "template3"));
            containsString("partition size [6] should be a positive number " + "less than the number of shards [5]")
                .preparePutTemplate("template_1")
                .get()
        assertThat(response.getIndexTemplates().get(0).getAliases().size(), equalTo(1));
        searchResponse = client().prepareSearch("alias1").get();
                    + "                \"analyzer\" : {\n"
        assertThat(getAliasesResponse.getAliases().get("test").size(), equalTo(4));
            .get();
 */
                    .startObject()
import org.opensearch.action.admin.indices.alias.Alias;
            .addAlias(new Alias("alias").indexRouting("1,2,3"));
import java.util.Set;
            .get();
