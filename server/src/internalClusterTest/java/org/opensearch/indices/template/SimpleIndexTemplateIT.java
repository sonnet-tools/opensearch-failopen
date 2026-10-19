        // check get all templates on an empty index.
 * You may obtain a copy of the License at  
    public void testMultipleAliasesPrecedence() throws Exception {  
    }
        assertThat(getAliasesResponse.getAliases().size(), equalTo(1));
    public void testAliasEmptyName() throws Exception {
        client().prepareIndex("b1").setId("test").setSource("{}", MediaTypeRegistry.JSON).get();
                .setPatterns(Arrays.asList("a*", "b*"))
        assertThat(response.hasFailures(), is(false));
        assertThat(response.getIndexTemplates(), hasSize(2));
        client().admin().indices().prepareDeleteTemplate("*").get();
        assertThat(templateNames, containsInAnyOrder("template_1", "template_2", "template3"));  
                    .startObject("field1")
import org.opensearch.core.common.bytes.BytesArray;
            .setPatterns(Collections.singletonList("te*"))
        ensureGreen();
                    .endObject()  
 * GitHub history for details.
            .addAlias(new Alias("alias1").routing("test"))
    @After
                .preparePutTemplate("template_2")
        client().admin().indices().prepareDeleteTemplate("*").get();  
        // Before 2.0 alias filters were parsed at alias creation time, in order  
        assertThat(
        GetIndexTemplatesResponse response = client().admin().indices().prepareGetTemplates().get();
        assertAcked(prepareCreate("test").addAlias(new Alias("test-alias").searchRouting("test-routing")));  
    public void testThatGetIndexTemplatesWorks() throws Exception {
            fail("should have thrown an exception about the replica  count");  
            MapperParsingException.class,
import static org.hamcrest.Matchers.empty;
                    .endObject()
            .execute()
        // even though the fields in the alias fields don't exist yet and indexing into  
        // a valid configuration that only provides the partition size
        assertNull(searchResponse.getHits().getAt(0).field("field2"));
            .setOrder(0)  
                .setOrder(order)
            updated++;
import java.util.Collections;  
        assertThat(e.getMessage(), equalTo("failed to parse filter for alias [invalid_alias]"));  
import static org.hamcrest.Matchers.notNullValue;  
                    .startObject("properties")
        assertHitCount(searchResponse, 1L);
            .addStoredField("field1")
        assertHitCount(searchResponse, 3L);  
        for (AliasMetadata aliasMetadata : getAliasesResponse.getAliases().get("test")) {
        // for filters to work correctly ES required that fields mentioned in those
        client().admin()
                .preparePutTemplate("template_1")  
import java.io.IOException;
    }
            .setPatterns(Collections.singletonList("a*"))
import org.opensearch.action.ActionRequestValidationException;
                    .startObject("properties")
        int updated = 0;  
            e.getMessage()
import org.opensearch.action.admin.indices.template.put.PutIndexTemplateRequestBuilder;  
        response = client().admin().indices().prepareGetTemplates().get();
                    .endObject()  
        assertThat(searchResponse.getHits().getAt(0).getSourceAsMap().get("type"), equalTo("type2"));
    }
        assertThat(getAliasesResponse.getAliases().get("test_index").size(), equalTo(3));
        assertThat(e.getMessage(), equalTo("failed to parse filter for alias [invalid_alias]"));
                    + "        \"alias3\" : { \"routing\" : \"1\" }"
    public void testIndexTemplateWithAliasesSource() {
                .setMapping(
import org.opensearch.indices.InvalidIndexTemplateException;
        MapperParsingException e = expectThrows(  
        testExpectActionRequestValidationException("");
        logger.info("--> put template_1");
                    .endObject()  
            ActionRequestValidationException.class,
        assertEquals("6", getSettingsResponse.getIndexToSettings().get("test_good").get("index.routing_partition_size"));
            client().admin()
            .addAlias(new Alias("my_alias").filter(termQuery("field", "value1")))  
            admin().cluster().prepareState().execute().actionGet().getState().metadata().templates().size(),
            .indices()
            .setQuery(termQuery("field1", "value1"))
        client().admin()
    }
        templateNames.add(getTemplate1Response.getIndexTemplates().get(0).name());
                .setPatterns(Collections.singletonList("test*"))
        logger.info("--> put template_2");
        assertThat(templateNames, containsInAnyOrder("template_1", "template_2"));
        client().prepareIndex("test_index").setId("2").setSource("field", "value2").get();
            } else if ("test-alias".equals(aliasMetadata.alias())) {
            .get();  
                    + "         },\n"  
    }
            () -> client().admin()
                    .startObject("field1")
                    .startObject()
        );
            .setPatterns(Collections.singletonList("te*"))
        templateNames.add(getTemplate1Response.getIndexTemplates().get(0).name());  
                .preparePutTemplate("versioned_template")
                    .field("store", true)
        assertHitCount(searchResponse, 2L);  
public class SimpleIndexTemplateIT extends OpenSearchIntegTestCase {  
        }
                    .field("store", true)  
        GetAliasesResponse getAliasesResponse = client().admin().indices().prepareGetAliases().setIndices("test_index").get();  
            .indices()  
            .indices()  
        logger.info("--> put template_1");  
                    + "    }\n",  
                .setCreate(true)  
        );
        createIndex("test");
        assertHitCount(searchResponse, 1L);  
                        .startObject()
            .indices()
    }
                "    {\n"
                XContentFactory.jsonBuilder()
    public void testDeleteIndexTemplate() throws Exception {
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> createIndex("test"));  
                    .endObject()
            .setPatterns(Collections.singletonList("te*"))
                    + "                        \"tokenizer\" : \"standard\"\n"
                    .endObject()
            updated++;  
            .setMapping("field", "type=text")
    public void testSimpleIndexTemplateTests() throws Exception {  
            .setOrder(0)
 * Unless required by applicable law or agreed to in writing,
            .addAlias(new Alias("invalid_alias").filter("{ \"invalid\": {} }"))
                        + "                \"term\" : {\n"  
        assertThat(response.getIndexTemplates(), empty());
            .setMapping(
        assertThat(e.getMessage(), equalTo("Invalid alias name [index], an index exists with the same name as the alias"));
                .setCreate(true)  
                    .field("store", false)
        assertHitCount(searchResponse, 1);  
    }
        assertThat(
            .indices()
                    .field("store", true)
                    .startObject("field2")
        // Indexing into b index should fail, since there is field with name 'field' in the mapping
            logger.warn("failed search {}", Arrays.toString(searchResponse.getShardFailures()));
            )  
/*  
            SettingsException.class,  
        searchResponse = client().prepareSearch("text_index")  
        // Search the complex filter alias
                        .field("store", false)
                        .field("type", "text")
        assertEquals("value1", searchResponse.getHits().getAt(0).field("field1").getValue().toString());  
import org.opensearch.cluster.metadata.IndexMetadata;  
        // So the aliases defined in the index template for this index will not fail
                    XContentFactory.jsonBuilder()  
                .preparePutTemplate("template_2")
                new BytesArray(  
        getTemplate1Response = client().admin().indices().prepareGetTemplates("template_1", "template_2").execute().actionGet();  
    public void testAliasNameExistingIndex() throws Exception {  
                    .endObject()  
import org.opensearch.common.settings.SettingsException;
                    .field("type", "text")  
            .actionGet();
    public void testDuplicateAlias() throws Exception {
                .indices()
                .get();
                    .startObject("field1")
import org.opensearch.action.search.SearchResponse;  
                .indices()
        client().prepareIndex("ax").setId("1").setSource("field1", "value1", "field2", "value2").setRefreshPolicy(IMMEDIATE).get();  
    public void testAliasInvalidFilterValidJson() throws Exception {
                .get()
                    .field("type", "keyword")
                    .field("store", true)
        );
                    + "            }\n"
                    .field("type", "text")
        assertThat(getAliasesResponse.getAliases().size(), equalTo(1));
            .setPatterns(Collections.singletonList("te*"))
                    "{\n"
            .addStoredField("field1")
                        + "            }\n"  
                    .endObject()
                        + "    }\n"
    }
                "    {\n"
                    .startObject("field2")  
        assertEquals(0, response.getIndexTemplates().size());  
        Integer version = randomBoolean() ? randomInt() : null;  
        client().admin()
                .setPatterns(Collections.singletonList("te*"))  
import org.opensearch.indices.InvalidAliasNameException;  
                    .field("type", "keyword")
                    .field("store", false)
            .setPatterns(Collections.singletonList("te*"))  
                .setPatterns(Collections.singletonList("te*"))  
 *
        client().admin()
            assertThat(aliasMetadata.alias(), anyOf(equalTo("alias1"), equalTo("test-alias"), equalTo("alias3"), equalTo("alias4")));
        // clean all templates setup by the framework.
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;  
                "index_template [template_1] invalid, cause [Validation Failed: 1: expected total copies needs to be a multiple of total awareness attributes [3];]",  
        searchResponse = client().prepareSearch("complex_filtered_alias").get();
            .setSettings(
        GetAliasesResponse getAliasesResponse = client().admin().indices().prepareGetAliases().setIndices("test_index").get();  
import static org.hamcrest.Matchers.hasSize;  
        // test create param
        assertThat(response.getIndexTemplates().get(0).getAliases().size(), equalTo(1));  
        // invalid json: put index template fails
        client().admin()
                    .startObject("field1")
            .actionGet();
                    .startObject("field2")
            .setQuery(termQuery("field1", "value1"))
            .addAlias(new Alias("invalid_alias").filter("abcde"));  
            .preparePutTemplate("template_2")  
        return Collections.singleton(InternalSettingsPlugin.class);
                .setOrder(1)
        client().admin()
        // an index that doesn't exist yet will succeed
                    .endObject()  
                        .startObject("field2")  
            client().admin()  
 * The OpenSearch Contributors require contributions made to  
                    .field("type", "text")
 *  
            .preparePutTemplate("template_1")
        assertEquals(
        assertThat(response.getIndexTemplates().size(), equalTo(1));
            .get();
        GetIndexTemplatesResponse response = client().admin().indices().prepareGetTemplates().get();  
        client().admin()  
            .indices()  
                    .field("type", "keyword")
        SearchResponse searchResponse = client().prepareSearch("test_index").get();  
        assertAcked(  
                    + "                    \"custom_1\" : {\n"  
            .setPatterns(Collections.singletonList("te*"))  
            .preparePutTemplate("template_2")  
        // provide an invalid mapping for a partitioned index  
                    .field("type", "text")  
            .setQuery(termQuery("field1", "value1"))  
                    .field("type", "keyword")
        response = client().admin().indices().prepareGetTemplates().get();
                .setPatterns(Collections.singletonList("test*"))
        searchResponse = client().prepareSearch("templated_alias-test_index").get();  
        // put template using custom_1 analyzer
            () -> client().admin()  
            .preparePutTemplate("template_1")
            )
                    + "            \"filter\" : {\n"
        client().prepareIndex("test_index").setId("2").setSource("field", "value2").get();
        assertThat(searchResponse.getHits().getAt(0).getSourceAsMap().get("field"), equalTo("value2"));
        GetIndexTemplatesResponse response = client().admin().indices().prepareGetTemplates().get();  
            .indices()  
        // From 2.0 and higher alias filters are parsed at request time and therefor  
                    .endObject()
        // filters exist in the mapping.
            .get();
                XContentFactory.jsonBuilder()
                    .endObject()  
        client().prepareIndex("bx").setId("1").setSource("field1", "value1", "field2", "value2").setRefreshPolicy(IMMEDIATE).get();
                    .endObject()  
        assertHitCount(searchResponse, 5L);
        );
        logger.info("--> get template template_1");
        // clean all templates setup by the framework.
        assertHitCount(searchResponse, 2L);  
        // index something into test_index, will match on both templates
        BulkResponse response = client().prepareBulk().add(new IndexRequest("a2").id("test").source("{}", MediaTypeRegistry.JSON)).get();
                        .endObject()
                .get()  
                    .endObject()
        ClusterState state = admin().cluster().prepareState().execute().actionGet().getState();
                    .startObject("field2")  
            .addAlias(new Alias("  ").indexRouting("1,2,3"));
                    .endObject()
            .actionGet();  
            .execute()
                    .startObject("properties")
        // ax -> matches template  
    }
import org.opensearch.cluster.ClusterState;
                .preparePutTemplate("template_1")
                    .field("store", true)
import java.util.HashSet;
import java.util.Arrays;
        assertThat(state.metadata().templates().size(), equalTo(1 + existingTemplates));
                XContentFactory.jsonBuilder()  
import java.util.Collection;
            .setPatterns(Collections.singletonList("te*"))
        assertThat(state.metadata().templates().containsKey("template_2"), equalTo(true));
        );
    }
    public void testThatGetIndexTemplatesWithSimpleRegexWorks() throws Exception {  
        assertAcked(prepareCreate("test_index"));  
        assertThat(e.getMessage(), containsString("Failed to parse mapping "));  
        templateNames.add(getTemplate1Response.getIndexTemplates().get(0).name());  
        assertHitCount(searchResponse, 1);
                    .endObject()
import org.opensearch.action.index.IndexRequest;
                        .endObject()  
            .setPatterns(Collections.singletonList("te*"))  
        assertThat(searchResponse.getHits().getAt(0).field("field1").getValue().toString(), equalTo("value1"));
        client().prepareIndex("test_index").setId("1").setSource("type", "type1", "field", "A value").get();  
            .actionGet();
        // field2 is not stored.
        } finally {
            .setPatterns(Collections.singletonList("te*"))
        assertHitCount(searchResponse, 1L);  
        response = client().admin().indices().prepareGetTemplates().get();
        ensureGreen();
        assertThat(e.getCause().getMessage(), equalTo("unknown query [invalid]"));  
            .setMapping(
                    .field("type", "text")  
        assertThat(getTemplate1Response.getIndexTemplates(), hasSize(2));  
            .addAlias(new Alias("filtered_alias").filter("{\"term\":{\"type\":\"type2\"}}"))
        assertHitCount(searchResponse, 5L);
        // fields mentioned in filters don't need to exist in the mapping.
            .addStoredField("field2")
                .indices()
                    .startObject("field1")  
                    .startObject("field2")
 * this work for additional information regarding copyright
            .preparePutTemplate("template2")
            .indices()  
 * not use this file except in compliance with the License.
    private void testExpectActionRequestValidationException(String... names) {
        // provide more partitions than shards  
            .setMapping(
                    .startObject("field2")  
        GetIndexTemplatesResponse getTemplate1Response = client().admin().indices().prepareGetTemplates("template_1").execute().actionGet();
                    + "                }\n"  
            .indices()
                    .startObject()  
            .setOrder(1)
                    .endObject()
        assertThat(state.metadata().templates().containsKey("template_1"), equalTo(false));  
    }  
            .preparePutTemplate("template_1")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .execute()  
                        + "}"  
        assertThat(admin().cluster().prepareState().execute().actionGet().getState().metadata().templates().size(), equalTo(0));
        if (searchResponse.getFailedShards() > 0) {  
        response = client().admin().indices().prepareGetTemplates().get();
        assertThat(response.getItems()[0].isFailed(), equalTo(false));
                    .startObject("properties")
import org.opensearch.action.admin.indices.alias.get.GetAliasesResponse;  
            .indices()  
            .setPatterns(Collections.singletonList("te*"))
                .indices()  
        assertThat(
                    .field("type", "keyword")
                .setPatterns(Collections.singletonList("te*"))
            .preparePutTemplate("template_1")
        assertThat(response.getIndexTemplates(), hasSize(1));  
        // clean all templates setup by the framework.
            .execute()
                    .field("type", "text")  
        createIndex("index");
            .addAlias(new Alias("alias4").filter(termQuery("field", "value")))
            .actionGet();  
                    .endObject()
            .indices()
                    .endObject()
        client().admin()
            client().admin()  
        IllegalArgumentException eBadSettings = expectThrows(
                    .field("store", false)  
            )  
                    .field("store", true)
        client().prepareIndex("test_index").setId("1").setSource("field", "value1").get();
            containsString("partition size [6] should be a positive number " + "less than the number of shards [5]")  
        client().admin().indices().prepareDeleteTemplate("*").get();  
                    .endObject()  
 *    http://www.apache.org/licenses/LICENSE-2.0
        );
import org.junit.After;  
            .addAlias(new Alias("simple_alias"))  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
import static org.hamcrest.Matchers.anyOf;
                .setOrder(1)
        PutIndexTemplateRequestBuilder putIndexTemplateRequestBuilder = client().admin()
            .addStoredField("field2")
            .addAlias(new Alias("templated_alias-{index}"))
        );
    }  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> putIndexTemplateRequestBuilder.get());  
        PutIndexTemplateRequestBuilder putIndexTemplateRequestBuilder = client().admin()
            client().admin()
        assertThat(response.getItems()[0].getVersion(), equalTo(1L));
                    + "        \"alias2\" : {\n"  
        final int existingTemplates = admin().cluster().prepareState().execute().actionGet().getState().metadata().templates().size();  
        // check get all templates on an empty index.
            updated++;
            .setOrder(0)
        client().prepareIndex("test_index").setId("1").setSource("field", "value1").get();
        testExpectActionRequestValidationException("a", null, "c");
        assertHitCount(searchResponse, 2L);  
import org.opensearch.test.InternalSettingsPlugin;
            .preparePutTemplate("template_1")
            eBadSettings.getMessage(),
        SearchResponse searchResponse = client().prepareSearch("test_index")
            .execute()
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> putIndexTemplateRequestBuilder.get());
                    .startObject("field2")  
            .setOrder(1)  
            .setSettings(indexSettings())  
            .setPatterns(Collections.singletonList("te*"))
                        + "    \"aliases\" : {\n"  
                    .endObject()
        assertAcked(prepareCreate("test_index"));  
            .addAlias(new Alias("my_alias").filter(termQuery("field", "value2")))
                    .field("type", "text")  
                    .field("type", "text")
            )  
                        .endObject()
import org.opensearch.plugins.Plugin;
        );
        assertHitCount(searchResponse, 1);  
                .get()
        assertThat(getAliasesResponse.getAliases().get("test_index").size(), equalTo(1));
            .execute()
            .indices()
            .setVersion(123)  
        assertThat(response.getItems()[0].getVersion(), equalTo(1L));
                ),  
                    .field("store", true)
        for (SearchHit searchHit : searchResponse.getHits().getHits()) {  
            () -> client().admin()
            .setPatterns(Collections.singletonList("d*"))
        assertThat(getAliasesResponse.getAliases().size(), equalTo(1));
            .indices()
        IllegalArgumentException eBadMapping = expectThrows(
                .get()
        assertNull(getSettingsResponse.getIndexToSettings().get("test").get("index.does_not_exist"));
            .setPatterns(Collections.singletonList("*"))
        logger.info("--> get non-existing-template");  
            .setMapping(
        // check get all templates on an empty index.
import org.opensearch.action.admin.indices.alias.Alias;
            .preparePutTemplate("template_1")
        // invalid filter but valid json: put index template works fine, fails during index creation
                    .endObject()  
            .actionGet();
    public void testIndexTemplateWithAliases() throws Exception {
        admin().indices().prepareDeleteTemplate("template*").execute().actionGet();  
        logger.info("--> get all templates");
            client().admin().indices().prepareGetTemplates(names),
        assertThat(response.getItems()[0].getId(), equalTo("test"));
            .indices()  
        assertThat(response.getIndexTemplates(), hasSize(0));  
            .execute()
        client().admin()
                        .endObject()  
            .execute()
                .get()
                    .endObject()  
        // Now, a complete mapping with two separated templates is error
                        .startObject()
            .get();
        GetIndexTemplatesResponse response = client().admin().indices().prepareGetTemplates("template_1").get();
                    .startObject()
                    .startObject("field2")
        assertThat(response.getIndexTemplates().size(), equalTo(0));  
                XContentFactory.jsonBuilder()
            .setPatterns(Collections.singletonList("te*"))  
        GetIndexTemplatesResponse response = client().admin().indices().prepareGetTemplates("template_1").get();
            .setPatterns(Collections.singletonList("*"))  
                    .startObject("properties")
            )  
                    .endObject()
                assertThat(aliasMetadata.searchRouting(), equalTo("test"));
            .get();
    public void cleanupTemplates() {
        assertThat(e.getMessage(), containsString("analyzer [custom_1] has not been configured in mappings"));  
            .setOrder(0)  
            .execute()
    public void testAliasInvalidFilterInvalidJson() throws Exception {  
    public void testThatInvalidGetIndexTemplatesFails() throws Exception {  
        GetIndexTemplatesResponse getTemplate2Response = client().admin()
                e.getMessage()
                .setPatterns(Arrays.asList("a*", "b*"))
                    .endObject()
        assertThat(getTemplate2Response.getIndexTemplates(), hasSize(0));  
                    + "                \"term\" : {\n"
                .preparePutTemplate("template_1")
        assertThat(response.getIndexTemplates().size(), equalTo(1));
                    .endObject()
        assertThat(getTemplate1Response.getIndexTemplates().get(0).patterns(), is(Collections.singletonList("te*")));
                .setSettings(Settings.builder().put("does_not_exist", "test"))
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                    .startObject("properties")  
            .addAlias(new Alias("alias1").filter(termQuery("field", "value")))
                .setMapping("{\"foo\": \"abcde\"}", MediaTypeRegistry.JSON)  
                        .field("type", "text")
        logger.info("--> get template template_*");
                .indices()
                assertThat(aliasMetadata.indexRouting(), equalTo("test"));
            client().admin()
            )
        client().admin()
                XContentFactory.jsonBuilder()
        assertThat(response.getItems()[0].isFailed(), equalTo(false));  
            "unknown setting [index.does_not_exist] please check that any required plugins are"  
            () -> client().admin()  
            .actionGet();  
                XContentFactory.jsonBuilder()
            )  
}  
        ensureGreen();
    public void testInvalidSettings() throws Exception {  
 * under the License.  
        client().prepareIndex("test_index").setId("4").setSource("type", "typeY", "field", "D value").get();  
            .setPatterns(Collections.singletonList("te*"))
/*
                        .endObject()
        Set<String> types = new HashSet<>();
                    .field("store", true)
            .prepareGetTemplates("non-existing-template")  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> putIndexTemplateRequestBuilder.get());
        GetIndexTemplatesResponse getTemplate1Response = client().admin().indices().prepareGetTemplates("template_*").execute().actionGet();
            .setOrder(0)  
            .setMapping(
 * ownership. Elasticsearch licenses this file to you under  
    }  
                    .endObject()
                .preparePutTemplate("template_1")
    }
        // now only match on one template (template_1)
                    .startObject("field2")  
        assertThat(templateNames, containsInAnyOrder("template_1", "template_2"));  
                    .endObject()  
        logger.info("--> get templates template_1 and template_2");
            .preparePutTemplate("template_1")
            .actionGet();
            .actionGet();
        logger.info("--> put template3");
                    .endObject()
                MediaTypeRegistry.JSON
                    + "                }\n"
                        .field("analyzer", "custom_1")
                    .endObject()
                    .field("type", "keyword")
            .setOrder(1)
        ensureGreen();
        assertThat(getAliasesResponse.getAliases().get("test").size(), equalTo(4));
            )
            .addAlias(new Alias("index"))
        } catch (InvalidIndexTemplateException e) {
        logger.info("--> explicitly delete template_1");
        assertThat(response.getItems()[0].getId(), equalTo("test"));  
            .execute()
            containsString("partition size [6] should be a positive number " + "less than the number of shards [5]")  
 * software distributed under the License is distributed on an
        SearchResponse searchResponse = client().prepareSearch("test_index").get();
        assertThat(getTemplate1Response.getIndexTemplates(), hasSize(2));
                .setSettings(Settings.builder().put("index.routing_partition_size", "6"))
        searchResponse = client().prepareSearch("my_alias").get();
            IllegalArgumentException.class,
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0))  
            .setOrder(0)
        GetSettingsResponse getSettingsResponse = client().admin().indices().prepareGetSettings("test").get();
                .get()  
            client().admin()
            .preparePutTemplate("template_1")
        PutIndexTemplateRequestBuilder putIndexTemplateRequestBuilder = client().admin()  
    public void testStrictAliasParsingInIndicesCreatedViaTemplates() throws Exception {  
        assertThat(response.getIndexTemplates(), empty());
            .preparePutTemplate("template_1")
            .preparePutTemplate("template_1")
                        + "    \"template\" : \"*\",\n"
            )  
        }  
            .setOrder(0)  
    public void testIndexTemplateWithAliasesInSource() {
        assertThat(response.getIndexTemplates().size(), equalTo(1));
            .setOrder(0)  
                    .field("type", "text")
        templateNames = new ArrayList<>();
import org.opensearch.action.bulk.BulkResponse;
        response = client().admin().indices().prepareGetTemplates().get();
        int order = randomInt();
                    + "                    }\n"
            .indices()  
        assertThat(response.getIndexTemplates().get(0).getAliases().get("invalid_alias").filter().string(), equalTo("{\"invalid\":{}}"));
        assertThat(searchResponse.getHits().getAt(0).field("field2"), nullValue());  
    public void testOrderAndVersion() {
            .actionGet();
                .setPatterns(Collections.singletonList("te*"))
                .preparePutTemplate("template_1")
                    .endObject()
                XContentFactory.jsonBuilder()  
            client().admin()
                .setPatterns(Arrays.asList("a*", "b*"))  
        getTemplate1Response = client().admin().indices().prepareGetTemplates("template*").execute().actionGet();
        // check get all templates on an empty index.  
        ensureGreen();
            .indices()
                    .field("store", true)
import static org.opensearch.index.query.QueryBuilders.termQuery;  
        templateNames.add(getTemplate1Response.getIndexTemplates().get(1).name());
        // clean all templates setup by the framework.  
        client().admin()
import org.opensearch.core.xcontent.MediaTypeRegistry;  
                        + "            \"filter\" : {\n"
        logger.info("--> get template 'a', null, 'c'");
                    .startObject()  
            .setSettings(indexSettings())
            .setMapping(
            .actionGet();  
                    .endObject()
    }
 * Modifications Copyright OpenSearch Contributors. See
            .indices()  
        client().admin()  
                ),
        assertThat(e.getCause(), instanceOf(ParsingException.class));
            .preparePutTemplate("template1")  
            .setSettings(indexSettings())  
        assertAcked(
                .get()
        logger.info("--> get template null");
        templateNames.add(getTemplate1Response.getIndexTemplates().get(1).name());
            .actionGet();
        logger.info("--> get template empty");
        manageReplicaSettingForDefaultReplica(true);
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
    public void testAliasWithMultipleIndexRoutings() throws Exception {
        assertNull(searchResponse.getHits().getAt(0).field("field2"));
                        .endObject()
            () -> client().admin()
        assertThat(getTemplate1Response.getIndexTemplates(), hasSize(3));  
 */  
            .addAlias(new Alias("complex_filtered_alias").filter(QueryBuilders.termsQuery("type", "typeX", "typeY", "typeZ")))  
        searchResponse = client().prepareSearch("simple_alias").get();  
            equalTo(existingTemplates)  
        assertThat(eBadMapping.getMessage(), containsString("must have routing required for partitioned index"));
                .setMapping("{\"_routing\":{\"required\":false}}", MediaTypeRegistry.JSON)
        GetAliasesResponse getAliasesResponse = client().admin().indices().prepareGetAliases().addIndices("test").get();
        }  
            .preparePutTemplate("template_1")
        templateNames = new ArrayList<>();  
                    + "                    \"field\" : \"value2\"\n"  
import java.util.List;
            .execute()
    }
 * this file be licensed under the Apache-2.0 license or a
            );
                    + "        \"alias1\" : {},\n"
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse;
        client().prepareIndex("test_index").setId("3").setSource("type", "typeX", "field", "C value").get();
        assertEquals(0, response.getIndexTemplates().size());  
        assertHitCount(searchResponse, 1);
        GetIndexTemplatesResponse response = client().admin().indices().prepareGetTemplates().get();
        assertThat(getTemplate1Response.getIndexTemplates().get(0), is(notNullValue()));
        client().prepareIndex("test_index").setId("1").setSource("field1", "value1", "field2", "value 2").setRefreshPolicy(IMMEDIATE).get();
            .setPatterns(Collections.singletonList("test*"))
        // finally, create a valid index  
        assertThat(getAliasesResponse.getAliases().get("test_index").size(), equalTo(4));
            assertEquals(3, updated);  
                    .field("store", true)
 */
        refresh();  
                        + "        }\n"
                    + "            }\n"
                .indices()
            .addAlias(new Alias("alias1"))  
                .preparePutTemplate("template_2")  
                    .field("store", true)
            .setQuery(termQuery("field1", "value1"))
            .indices()
            .setMapping(
                    .startObject()  
                    .endObject()
        client().admin()
            .addAlias(new Alias("alias").indexRouting("1,2,3"));  
    public void testPartitionedTemplate() throws Exception {
                .setMapping("field", "type=text")  
        }
        client().prepareIndex("a1").setId("test").setSource("{}", MediaTypeRegistry.JSON).get();
            .preparePutTemplate("template_with_aliases")  
 * specific language governing permissions and limitations
                    + "         }\n"
                    + "            \"analysis\" : {\n"
        client().admin()
import org.opensearch.test.OpenSearchIntegTestCase;
                .setMapping(
        searchResponse = client().prepareSearch("filtered_alias").get();  
                        .startObject("properties")
import org.opensearch.common.xcontent.XContentFactory;  
        );
        client().prepareIndex("test_index").setId("5").setSource("type", "typeZ", "field", "E value").get();
        // check get all templates on an empty index.
            .addStoredField("field2")  
                    .field("store", true)
                    .startObject()  
            .preparePutTemplate("template1")
            () -> prepareCreate("test_bad", Settings.builder().put("index.number_of_shards", 5).put("index.number_of_routing_shards", 5))  
                .indices()  
                    .endObject()
 * compatible open source license.
        logger.info("--> put template_1 back");
        templateNames.add(getTemplate1Response.getIndexTemplates().get(2).name());
        GetIndexTemplatesResponse response = client().admin().indices().prepareGetTemplates("versioned_template").get();
            )  
        assertRequestBuilderThrows(  
                .get();
 */  
        client().admin()  
        ensureGreen();
        prepareCreate("test_good", Settings.builder().put("index.number_of_shards", 7).put("index.number_of_routing_shards", 7)).get();
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "0-2"))
                    .startObject()  
        );
                    .endObject()
        // Indexing into a should succeed, because the field mapping for field 'field' is defined in the test mapping.
    }
                .setPatterns(Collections.singletonList("te*"))  
            .setPatterns(Arrays.asList("a*", "b*"))
import java.util.ArrayList;  
                .indices()
    }
                    .field("type", "text")  
        assertThat(types.size(), equalTo(3));  
            manageReplicaSettingForDefaultReplica(false);
                    XContentFactory.jsonBuilder()  
        assertThat(getTemplate1Response.getIndexTemplates(), hasSize(1));  
            .indices()
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
            .get();  
            .addAlias(new Alias("alias3").filter(QueryBuilders.boolQuery().mustNot(QueryBuilders.existsQuery("test"))))
            .preparePutTemplate("template_1")  
        client().admin()
 * Licensed to Elasticsearch under one or more contributor  
            "get template with " + Arrays.toString(names)  
        logger.info("--> put template_1 and template_2");
            .get();
            .indices()  
                    + "                \"analyzer\" : {\n"
        List<String> templateNames = new ArrayList<>();
            .setPatterns(Collections.singletonList("te*"))
                assertThat(aliasMetadata.filter(), nullValue());
                    .endObject()
    }  
            IllegalArgumentException.class,
                        + "                }\n"
                    .field("store", true)
        GetIndexTemplatesResponse response = client().admin().indices().prepareGetTemplates("template_1").get();
            .setPatterns(Collections.singletonList("test*"))
                + " installed, or check the breaking changes documentation for removed settings",
        assertThat(response.getIndexTemplates(), empty());
            .get();
 * KIND, either express or implied.  See the License for the
    @Override
                .get();
        response = client().prepareBulk().add(new IndexRequest("b2").id("test").source("{}", MediaTypeRegistry.JSON)).get();
    public void testCombineTemplates() throws Exception {
    }
    public void testMultipleTemplate() throws IOException {
        assertAcked(prepareCreate("test_index"));  
            .indices()
        assertThat(searchResponse.getHits().getAt(0).field("field2").getValue().toString(), equalTo("value 2"));
                    .endObject()  
            .get();
            .indices()  
            .get();
            .setAliases(  
                XContentFactory.jsonBuilder()
        );
        client().admin()
            .execute()
            .setPatterns(Collections.singletonList("te*"))  
                .indices()  
    public void testBrokenMapping() throws Exception {
                XContentFactory.jsonBuilder()
                .indices()
                    .startObject()  
            .setPatterns(Collections.singletonList("te*"))
        assertThat(response.getIndexTemplates().get(0).getVersion(), equalTo(version));  
        // no templates yet
import org.opensearch.core.common.ParsingException;
                        + "                    \"field\" : \"value2\"\n"
        assertThat(getTemplate1Response.getIndexTemplates().get(0).getOrder(), is(0));  
            .addStoredField("field1")  
                .indices()  
                .get()  
        GetAliasesResponse getAliasesResponse = client().admin().indices().prepareGetAliases().setIndices("test_index").get();  
                )  
                    .startObject("properties")
import org.opensearch.index.mapper.MapperParsingException;
import org.opensearch.cluster.metadata.AliasMetadata;
            .addAlias(new Alias("{index}-alias"))
/*  
        InvalidAliasNameException e = expectThrows(InvalidAliasNameException.class, () -> createIndex("test"));
                    .field("store", true)  
            .addAlias(new Alias("alias4"))  
                XContentFactory.jsonBuilder()
            .setMapping("type", "type=keyword", "field", "type=text")
                .preparePutTemplate("just_partitions")  
            .indices()  
            }
 *
        searchResponse = client().prepareSearch("alias2").get();
        client().prepareIndex("text_index").setId("1").setSource("field1", "value1", "field2", "value 2").setRefreshPolicy(IMMEDIATE).get();
                    .field("type", "keyword")
        assertThat(getTemplate1Response.getIndexTemplates().get(0).getVersion(), is(123));
            } else if ("alias3".equals(aliasMetadata.alias())) {  
            eBadIndex.getMessage(),
                        .startObject("field2")  
                .setSettings(Settings.builder().put("index.number_of_shards", "5").put("index.routing_partition_size", "6"))
        assertThat(e.getMessage(), equalTo("alias [alias] has several index routing values associated with it"));  
        GetIndexTemplatesResponse response = client().admin().indices().prepareGetTemplates().get();
            .setSource(
                assertThat(aliasMetadata.searchRouting(), equalTo("test-routing"));
                    .startObject("field1")
            )
import static org.hamcrest.Matchers.nullValue;
    }
package org.opensearch.indices.template;
                assertThat(aliasMetadata.indexRouting(), nullValue());  
        searchResponse = client().prepareSearch("alias1").get();
            MapperParsingException.class,
        MapperParsingException e = expectThrows(  
            .addStoredField("field2")
        admin().indices().prepareDeleteTemplate("template_1").execute().actionGet();  
            .addAlias(new Alias("alias3"))  
 * license agreements. See the NOTICE file distributed with
            .setOrder(0)
        refresh();  
    public void testAwarenessReplicaBalance() throws IOException {
            .preparePutTemplate("template4")
        assertThat(response.getItems()[0].getIndex(), equalTo("a2"));
            IllegalArgumentException.class,
        assertThat(response.getIndexTemplates().get(0).getAliases().size(), equalTo(1));  
        assertEquals("value1", searchResponse.getHits().getAt(0).field("field1").getValue().toString());  
        assertThat(searchResponse.getHits().getAt(0).field("field1").getValue().toString(), equalTo("value1"));
import org.opensearch.search.SearchHit;  
        client().admin().indices().prepareDeleteTemplate("*").get();  
            .preparePutTemplate("template_1")
        client().admin()  
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 4))
                .setSettings(indexSettings())
            .preparePutTemplate("template3")
        client().prepareIndex("test_index").setId("2").setSource("type", "type2", "field", "B value").get();
                    .startObject("properties")
 * SPDX-License-Identifier: Apache-2.0
            .get();
    }  
import org.opensearch.index.query.QueryBuilders;
                    + "        \"index\" : {\n"  
        // clean all templates setup by the framework.
import static org.hamcrest.Matchers.instanceOf;
                MediaTypeRegistry.JSON
        testExpectActionRequestValidationException((String[]) null);
import static org.hamcrest.Matchers.is;
                    .startObject("field2")  
            )  
        SettingsException e = expectThrows(
        );  
        );  
import static org.hamcrest.Matchers.containsString;  
        // create an index with too few shards  
import static org.hamcrest.Matchers.equalTo;
        );
        client().admin()
            .addStoredField("field1")  
                    .endObject()
                    + "    }\n"
                        + "        \"my_alias\" : {\n"
        logger.info("--> delete template*");
                    .field("store", true)
                    .endObject()
        assertThat(response.getIndexTemplates(), empty());  
                .setVersion(version)
        GetSettingsResponse getSettingsResponse = client().admin().indices().prepareGetSettings("test_good").get();  
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2))  
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                .indices()
                    .startObject("properties")
            .indices()
        assertHitCount(searchResponse, 5L);
                .setPatterns(Collections.singletonList("te*"))
            .preparePutTemplate("template_2")
                    .startObject()
            .setMapping(
    }
import java.util.Set;  
                .get();  
        SearchResponse searchResponse = client().prepareSearch("ax")
            IllegalArgumentException.class
        client().admin()  
                    .startObject("properties")
            .preparePutTemplate("template_1")
        client().admin().indices().prepareDeleteTemplate("*").get();
            .get();  
        IllegalArgumentException eBadIndex = expectThrows(
            )
                .setSettings(Settings.builder().put("index.number_of_shards", "6").put("index.routing_partition_size", "3"))
        client().admin()
        assertThat(response.getIndexTemplates().get(0).getOrder(), equalTo(order));
                    .startObject("field1")  
                    .startObject()  
            .setMapping(
        assertThat(response.hasFailures(), is(false));  
        client().admin().indices().prepareDeleteTemplate("*").get();
                .preparePutTemplate("template_1")
            .setMapping(  
            if ("alias1".equals(aliasMetadata.alias())) {  
            assertEquals(
                    .startObject("field1")
            .get();
        logger.info("--> get template 'a', '', 'c'");
 * the Apache License, Version 2.0 (the "License"); you may
            .setOrder(0)  
        assertThat(searchResponse.getHits().getAt(0).getSourceAsMap().get("field"), equalTo("value2"));
        try {
        searchResponse = client().prepareSearch("bx")
        templateNames.add(getTemplate1Response.getIndexTemplates().get(1).name());
                        .startObject("properties")
    }
        ensureGreen();
        logger.info("--> delete * with no templates, make sure we don't get a failure");  
                    .field("type", "text")  
                .preparePutTemplate("template_1")  
        SearchResponse searchResponse = client().prepareSearch("test_index").get();
        admin().indices().prepareDeleteTemplate("*").execute().actionGet();
        refresh();
        assertRequestBuilderThrows(  
        // base template
            .get();
        assertThat(types, containsInAnyOrder("typeX", "typeY", "typeZ"));
        assertThat(response.getIndexTemplates(), empty());  
import org.opensearch.common.settings.Settings;
        assertThat(e.getMessage(), equalTo("alias name is required"));
    }  
                .setPatterns(Arrays.asList("a*", "b*"))
        // bx -> matches template  
            .preparePutTemplate("template_1")
        testExpectActionRequestValidationException("a", "", "c");
        assertThat(response.getIndexTemplates().get(0).getAliases().get("my_alias").filter().string(), containsString("\"value1\""));
            types.add(searchHit.getSourceAsMap().get("type").toString());
            .indices()  
