        client().prepareIndex("test").setId("1").setSource(doc, MediaTypeRegistry.JSON).setRouting("1").get();
        assertThat(response.getResponses()[2].getFailure().getMessage(), startsWith("[1]: version conflict"));
        assertEquals(123, source.get("numeric_field"));
        assertThat(response.getIndex(), equalTo("test"));
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
import org.opensearch.core.rest.RestStatus;
        geopoint = (Map<String, Object>) source.get("geopoint_field");
                    }
            .startObject("properties")
        for (String field : fields) {
        assertThat(response.getSourceAsMap(), hasKey("field1"));
        assertThat(response.getId(), equalTo(docId));
        assertThat(numValues, containsInRelativeOrder(1, 1, 2));
        // Test numeric field retrieval
        ensureGreen();
        assertGetFieldsAlwaysWorks(indexOrAlias(), "_doc", "1", fieldsList, "routingValue");
                    .put("index.number_of_shards", 1)
        for (String field : fields) {
                        .field("type", "object")
        assertThat(response.isExists(), equalTo(true));
                    .field("binary_field", "bGlkaHQtd29rfx4=")
        );
            fail();
        assertThat(response.getResponses()[3].getResponse().isExists(), equalTo(true));
        assertThat(ipValues.size(), equalTo(2));
        String createIndexSource = "{\n"
                                "type": "date"
        indexSingleDocumentWithStringFieldsGeneratedFromText(true, randomBoolean());
        logger.info("--> non realtime get 1 (loaded from index)");
    @Override
            + "      \"Nevermind\",\n"
        assertThat(getResponse.getField(field).getValues().size(), equalTo(2));
                .endObject()
        assertThat(response.getResponses()[1].getIndex(), equalTo("test"));
            + "  \"suggest\": {\n"
        assertThat(response.getResponses()[3].getId(), equalTo("9"));
        logger.info("--> update doc 1");
            .startArray("ip_field")
                        .startObject("properties")
        assertThat(response.isExists(), equalTo(false));
                jsonBuilder().startObject().field("geopoint_field", "40.7128,-74.0060").field("date_field", "2025-07-29").endObject()
        }
        return Collections.singleton(InternalSettingsPlugin.class);
        assertThat(response.getResponses()[4].getId(), equalTo("11"));
                        .endObject()
        assertThat(response.getId(), equalTo("1"));
            + "  \"mappings\": {\n"
                .endObject()
        // Create source document
        assertThat(response.getResponses()[3].getResponse().getIndex(), equalTo("test"));
    public void testMultiGetWithVersion() throws Exception {
            // all good
        assertEquals(40.33, (Double) latLon.get("lon"), 0.001);
        assertThat(getResponse.isExists(), equalTo(true));
        logger.info("--> index doc 1");
            .startObject("properties")
        assertThat(response.isExists(), equalTo(true));
        flush();
        try {
            .startObject()
            + "  \"settings\": {\n"
    }
            .startObject("properties")
        assertGetFieldsAlwaysWorks(indexOrAlias(), "_doc", "1", fieldsList);
            + "  \"settings\": {\n"
        assertThat(multiGetResponse.getResponses().length, equalTo(1));
    }
                .addAlias(new Alias("alias1").indexRouting("0").writeIndex(randomFrom(false, null)))
        getResponse = client().prepareGet("test_derive", "1").get();
        assertGetFieldsAlwaysWorks(indexOrAlias(), "_doc", "1", fieldsList, "routingValue");
        assertThat(fields, equalTo(singleton("field")));
        assertThat(response.getIndex(), equalTo("test"));
        assertThat(response.getSourceAsBytes(), nullValue());
        assertThat(response.getResponses()[2].getResponse().isExists(), equalTo(true));
        assertNotNull(source);
    }
        assertThat(response.getResponses().length, equalTo(1));
        assertThat(getResponse.getField(field).getValues().get(1).toString(), equalTo("value2"));
import static java.util.Collections.singleton;
            .value("1.2.3.4")
        assertThat(response.getIndex(), equalTo("test"));
            + "          \"store\": \""
        assertThat(exception.getMessage(), endsWith("can't execute a single index op"));
                                "store": true
                sb.append("\nShard failure: ").append(failure);
            .get();
            .add(new MultiGetRequest.Item(indexOrAlias(), "1").version(2))
            .startObject()
        assertThat(response.getResponses()[0].getIndex(), equalTo("test"));
        // multi get with specific field
            () -> client().prepareGet("alias1", "_alias_id").get()
            .endObject()
        logger.info("--> update doc 1 again");
            .put("index.number_of_replicas", 0)
            + "    \"index.translog.flush_threshold_size\": \"1pb\",\n"
            + "        \"text2\": {\n"
        assertThat(response.getSourceAsBytes(), not(nullValue()));
 * software distributed under the License is distributed on an
        // Get document after flush, it should be a derived source
        String mapping = XContentFactory.jsonBuilder()
        }
        // same for multi get
            .get();
        assertThat(response.getResponses()[0].getId(), equalTo("1"));
        validateDeriveSource(source);
        assertThat(response.getFields().get("field").getValues().size(), equalTo(2));
        assertThat(response.getResponses()[1].getResponse().isExists(), equalTo(false));
                        }
                .startObject("field2")
        ensureGreen();
            .startArray("level3")
 * compatible open source license.
        client().prepareIndex("test").setId("1").setSource("field1", "value1_1", "field2", "value2_1").get();
            .endArray()
                    .put("index.number_of_replicas", 0)
                            "numeric_field": {
                .setSettings(Settings.builder().put("index.refresh_interval", -1))
        } catch (VersionConflictEngineException e) {
        UpdateResponse updateResponse = client().prepareUpdate("test", "1")
        refresh();
        assertThat(response.getResponses().length, equalTo(3));
        assertThat(response.getResponses()[0].getId(), equalTo("2"));
        }
 *
        }
        client().prepareIndex("test_derive")
        String[] fieldsList = { "_routing" };
                .startArray("field3")
        assertThat(indexResponse.status(), equalTo(RestStatus.CREATED));
        // before refresh - document is only in translog
        assertThat(response.getResponses()[0].getResponse().isExists(), equalTo(true));
        response = client().prepareGet(indexOrAlias(), "1").setVersion(2).get();
        assertAcked(prepareCreate("test").setSettings(settings).setMapping(mapping));
        GetResponse getResponse = client().prepareGet("test", "1").get();
        response = client().prepareGet(indexOrAlias(), "1").setStoredFields("field1").get();
                // multi types in 5.6
            + "    \"refresh_interval\": \"-1\"\n"
import org.opensearch.core.xcontent.XContentBuilder;
        // [0] version doesn't matter, which is the default
            .add(new MultiGetRequest.Item(indexOrAlias(), "2").version(Versions.MATCH_ANY))
        GetResponse getResponse = client().prepareGet("test_derive", "1").get();
                    .field("bool_field", true)
        assertThat(getResponse.isExists(), equalTo(true));
        }
        assertGetFieldsNull(index, type, docId, fields, null);
 * The OpenSearch Contributors require contributions made to
        index("test", "_doc", "1", doc);
        String createIndexSource = "{\n"
            .endObject()
        // after flush - document is in not anymore translog - only indexed
        assertThat(response.getIndex(), equalTo("test"));
        // after flush - document is in not anymore translog - only indexed
        assertEquals(RestStatus.CREATED, indexResponse.status());
import java.util.Map;
        index("test", "_doc", "1", doc);
                        },
        assertThat(response.getResponses()[0].getId(), equalTo("1"));
    void indexSingleDocumentWithStringFieldsGeneratedFromText(boolean stored, boolean sourceEnabled) {
        assertGetFieldsNull(indexOrAlias(), "_doc", "1", alwaysNotStoredFieldsList);
        assertThat(response.isExists(), equalTo(true));
            .add(indexOrAlias(), "15")
            .startArray("num_field")
            .get();
            getItem.routing(routing);
                            },
        assertThat(response.getIndex(), equalTo("test"));
    void validateDeriveSource(Map<String, Object> source) {
                    .field("text_field", "test text")
                        .startObject("field3")
                        "number_of_shards": 2,
            .get();
                            "enabled": true
        assertThat(response.getResponses()[2].getResponse().isExists(), equalTo(true));
            .add(new MultiGetRequest.Item(indexOrAlias(), "2").version(2))
            + "        \"suggest\": {\n"
                flushResponse.getTotalShards()
        assertThat(response.getResponses().length, equalTo(3));
        // after refresh - document is in translog and also indexed
        // Index the document
    }
        ensureGreen();
            .endObject()
            + "  }\n"
        DeleteResponse deleteResponse = client().prepareDelete("test", "1").get();
        assertThat(response.getResponses()[0].getResponse().isExists(), equalTo(true));
            assertGetFieldNull(index, type, docId, field, routing);
        assertEquals(-0.1278, (double) geopoint.get("lon"), 0.0001);
        response = client().prepareGet(indexOrAlias(), "1").setRealtime(false).get();
            .add(new MultiGetRequest.Item(indexOrAlias(), "1").version(1))
        assertThat(response.getIndex(), equalTo("test"));
                    jsonBuilder().startObject()
            .put(IndexSettings.INDEX_DERIVED_SOURCE_TRANSLOG_ENABLED_SETTING.getKey(), true);
        assertEquals(2, source.size());
        // after refresh - document is in translog and also indexed
        for (String field : fields) {
        assertThat(response.getResponses()[3].getIndex(), equalTo("test"));
        assertThat(response.getResponses()[1].getFailure(), nullValue());
        // Create index with derived source enabled and translog read preference set
        assertTrue(getResponse.isExists());
            .value(2)
            + "},"
        assertThat(response.getResponses()[1].getId(), equalTo("1"));
        assertThat(response.getResponses().length, equalTo(3));
    }
            .setId("1")
        response = client().prepareMultiGet()
        ensureGreen();
        assertEquals(75.98, (Double) latLon.get("lat"), 0.001);
        // Version from translog
        assertThat(response.getResponses()[2].getFailure(), nullValue());
        assertThat(response.getResponses()[0].getFailure(), nullValue());
            prepareCreate("test").addAlias(new Alias("alias").writeIndex(randomFrom(true, false, null)))
            + "\""
        // after flush - document is in not anymore translog - only indexed
        response = client().prepareMultiGet()
        refresh();
    }
        flush();
        assertThat(response.getVersion(), equalTo(1L));
        assertThat(response.getSourceAsBytes(), nullValue());
 * license agreements. See the NOTICE file distributed with
            .put("index.number_of_shards", 1)
        // Number field is stored as Sorted Numeric, so result should be in sorted order
            .add(indexOrAlias(), "9")
        client().prepareIndex("test").setId("1").setSource("field1", "value1", "field2", "value2").get();
            .endObject()
    public void testGetFieldsNonLeafField() throws Exception {
    }
        assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
                        .endObject()
                        .field("type", "object")
        assertEquals(RestStatus.OK, updateResponse.status());
        assertEquals(6, source.size());
        flush();
            .endObject()
        assertThat(response.getResponses()[0].getResponse().getSourceAsMap().get("field").toString(), equalTo("value2"));
        assertThat(response.getIndex(), equalTo("test"));
        assertThat(response.getSourceAsMap().get("field1").toString(), equalTo("value1"));
        assertThat(response.isExists(), equalTo(true));
        List<Object> ipValues = (List<Object>) level3.get("ip_field");
        assertEquals(-74.0060, (double) geopoint.get("lon"), 0.0001);
        assertThat(response.getResponses()[0].getResponse().isExists(), equalTo(true));
        // Create index with derived source index setting enabled
        getResponse = client().prepareGet("test", "1").get();
import org.opensearch.test.OpenSearchIntegTestCase;
            client().prepareGet(indexOrAlias(), "1").setVersion(2).setRealtime(false).get();
        // after flush - document is in not anymore translog - only indexed
            + "}";
        assertThat(response.getIndex(), equalTo("test"));
        assertThat(response.isExists(), equalTo(true));
            IllegalArgumentException.class,
            .value("2.3.4.5")
                        .field("type", "text")
        assertThat(response.getResponses()[2].getIndex(), equalTo("test"));
        ensureGreen();
            + "    \"refresh_interval\": \"-1\"\n"
            .endObject();
        }
            .get();
                },
        assertNotNull("Derived source should not be null", source);
                        .field("store", true)
        response = client().prepareMultiGet()
        assertTrue(getResponse.isExists());
                .endObject()
        // Test get with field exclusion
            + "    \"_doc\": {\n"
        );
        // From translog:
        response = client().prepareGet(indexOrAlias(), "1").get();
        assertThat(exc.getMessage(), equalTo("field [field1] isn't a leaf field"));
        );
 * KIND, either express or implied.  See the License for the
        assertTrue(response.isExists());
        assertThat(response.isExists(), equalTo(false));
                    .field("date_field", "2023-01-01")
        response = client().prepareGet(indexOrAlias(), "1").setVersion(Versions.MATCH_ANY).setRealtime(false).get();
        getResponse = client().prepareGet("my-index", "1").setStoredFields(field).get();
            .add(new MultiGetRequest.Item(indexOrAlias(), "2").version(Versions.MATCH_ANY))
        assertThat(response.getIndex(), equalTo("test"));
        logger.info("--> realtime get 1");
        logger.info("--> realtime fetch of field & source (loaded from index)");
                .startObject()
        assertThat(response.getResponses()[1].getResponse().isExists(), equalTo(true));
        assertThat(response.getResponses()[1].getFailure(), notNullValue());
                            "geopoint_field": {
 */
import org.opensearch.index.engine.VersionConflictEngineException;
                            },
        assertThat(response.getIndex(), equalTo("test"));
        assertThat(response.getVersion(), equalTo(2L));
            + "  }\n"
    }
            .setRealtime(false)
            )
            // all good
            .value(1)
            + "          \"type\": \"text\",\n"
        assertThat(response.isExists(), equalTo(false));
        source = getResponse.getSourceAsMap();
        if (routing != null) {
    public void testGetWithVersion() {
            client().admin()
        assertAcked(prepareCreate("test_derive").setSource(createIndexSource, MediaTypeRegistry.JSON));
        assertFalse(source.containsKey("text_field"));
        response = client().prepareGet(indexOrAlias(), "1").get();
        refresh();
            .toString();
        assertTrue(response.isExists());
        response = client().prepareGet(indexOrAlias(), "1").setRealtime(false).get();
            + "        }"
        // From Lucene index:
        }
                        .endObject()
                        "number_of_replicas": 0,
                        .endObject()
        assertThat(response.isExists(), equalTo(true));
        source = getResponse.getSourceAsMap();
        exc = expectThrows(IllegalArgumentException.class, () -> client().prepareGet(indexOrAlias(), "1").setStoredFields("field1").get());
        assertThat(response.getResponses()[0].getId(), equalTo("1"));
        response = client().prepareMultiGet()
import java.util.Set;
        assertThat(response.getSourceAsBytes(), nullValue());
            .startObject("level2")
 *    http://www.apache.org/licenses/LICENSE-2.0
        Map<String, Object> level2 = (Map<String, Object>) level1.get("level2");
        assertThat(response.getId(), equalTo(docId));
                            },
        assertGetFieldsAlwaysWorks(index, type, docId, fields, null);
        );
                            }
        MultiGetResponse response = client().prepareMultiGet().add(indexOrAlias(), "1").get();
        assertNotNull(source);
        // before refresh - document is only in translog
                    jsonBuilder().startObject()
            .setId("1")
 * the Apache License, Version 2.0 (the "License"); you may
        response = client().prepareGet(indexOrAlias(), "1").get();
            assertGetFieldNull(index, type, docId, field, routing);
        assertThat(response.getId(), equalTo("1"));
                )
        refresh();
        assertThat(response.getResponses()[1].getFailure(), nullValue());
        Settings.Builder settings = Settings.builder()
            .endObject()
        // Get document prior to update, which would be derived source
    }
import org.opensearch.common.lucene.uid.Versions;
        response = client().prepareMultiGet()
                                "type": "geo_point"
        String mapping1 = XContentFactory.jsonBuilder()
        GetResponse response = client().prepareGet("test", "1").get();
            + "}";
import static org.hamcrest.Matchers.instanceOf;
            .endObject()
                .endArray()
        assertTrue(getResponse.isExists());
            // all good
        } else {
        IndexResponse indexResponse = client().prepareIndex("test_derive").setId("1").setSource(sourceBuilder).get();
        assertThat(response.getSourceAsMap().get("field1").toString(), equalTo("value1"));
            .startObject()
                    "_doc": {
        logger.info("--> realtime fetch of field (loaded from index)");
                        .endObject()
        assertThat(response.getResponses()[0].getFailure(), nullValue());
    }
        XContentBuilder sourceBuilder = jsonBuilder().startObject()
        assertThat(response.getId(), equalTo("1"));
        logger.info("--> realtime get 1 (no source, implicit)");
                "settings": {
        logger.info("--> refresh the index, so we load it from it");
        assertThat(response.getResponses()[0].getResponse().getIndex(), equalTo("test"));
            .endObject()
    }
            + "          \"store\": \""
import org.opensearch.action.get.GetRequestBuilder;
        assertThat(response.isExists(), equalTo(false));
        client().prepareIndex("test").setId("1").setSource(jsonBuilder().startObject().array("field", "1", "2").endObject()).get();
        assertThat(response.getSourceAsMap().get("field2").toString(), equalTo("value2_1"));
        refresh();
            .toString();
            client().prepareGet(indexOrAlias(), "1").setVersion(2).get();
                        .startObject("field1")
            .add(new MultiGetRequest.Item(indexOrAlias(), "2").version(1))
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
    }
                .startArray("field1")
        assertThat(response.getResponses()[1].getIndex(), equalTo("test"));
                .startObject()
        BytesReference source = BytesReference.bytes(
        assertThat(response.getSourceAsMap().get("field1").toString(), equalTo("value1_2"));
        for (int i = 0; i < 3; i++) {
        Map<String, Object> source = getResponse.getSourceAsMap();
    public void testGeneratedStringFieldsStored() throws IOException {
        assertEquals("51.5074,-0.1278", source.get("geopoint_field"));
            ).setMapping(mapping)
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setSource(createIndexSource, MediaTypeRegistry.JSON));
                .field("field4", "value2")
        refresh();
        getResponse = client().prepareGet("test_derive", "1").get();
        client().prepareIndex("test").setId("1").setRouting("routingValue").setId("1").setSource("{}", MediaTypeRegistry.JSON).get();
        String doc = "{\n"
import static org.hamcrest.Matchers.startsWith;
        refresh();
            .startObject("ip_field")
    public void testSimpleGet() {
    private GetResponse getDocument(String index, String type, String docId, String field, @Nullable String routing) {
    public void testGeneratedStringFieldsUnstored() throws IOException {
        ensureGreen();
        refresh();
        response = client().prepareGet("test", "1").setStoredFields("field").get();
            .get();
            prepareCreate("my-index")
        GetResponse getResponse = client().prepareGet("my-index", "1").setStoredFields(field).get();
            .add(new MultiGetRequest.Item(indexOrAlias(), "2").version(2))
        assertEquals("test text", source.get("text_field"));
        // Now test values being fetched from stored fields.
        assertThat(response.getField("field1").getValues().get(0).toString(), equalTo("value1"));
        assertThat(response.getResponses()[2].getResponse().getSourceAsMap().get("field").toString(), equalTo("value2"));
        assertThat(response.isExists(), equalTo(true));
        assertThat(response.getFields().get("field").getValues().size(), equalTo(2));
        assertThat(response.getResponses()[2].getFailure().getId(), equalTo("1"));
    public void testUngeneratedFieldsThatAreAlwaysStored() throws IOException {
        } catch (VersionConflictEngineException e) {
        assertThat(response.isExists(), equalTo(false));
    }
        assertThat(response.getResponses()[2].getFailure().getId(), equalTo("1"));
        );
            .endObject()
        assertGetFieldsAlwaysNull(indexOrAlias(), "_doc", "1", fieldsList);
            .add(indexOrAlias(), "11")
                .prepareUpdateSettings("test")
        if (flushResponse.getSuccessfulShards() == 0) {
import static org.hamcrest.Matchers.containsInRelativeOrder;
            + "    \"index.translog.flush_threshold_size\": \"1pb\",\n"
            + "      \"properties\": {\n"
                        .endObject()
        assertThat(response.isExists(), equalTo(true));
            )
        }
        assertEquals("2023-01-01T00:00:00.000Z", source.get("date_field"));
        assertThat(response.getSourceAsBytes(), nullValue());
        assertThat(response.getSourceAsMap().get("field1").toString(), equalTo("value1"));
            + "}";
 *
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setSettings(Settings.builder().put("index.refresh_interval", -1)));
import static org.hamcrest.Matchers.endsWith;
        assertThat(response.getIndex(), equalTo("test"));
        assertThat(response.getResponses().length, equalTo(2));
        } catch (VersionConflictEngineException e) {
            .endObject()
            + "        },\n"
        assertThat(response.getId(), equalTo("1"));
        // for get
            assertGetFieldWorks(index, type, docId, field, routing);
        }
        getResponse = client().prepareGet("test", "1").get();
        geopoint = (Map<String, Object>) source.get("geopoint_field");
        assertThat(exc.getMessage(), equalTo("field [field1] isn't a leaf field"));
        assertFalse(source.containsKey("binary_field"));
        assertThat(response.isExists(), equalTo(false));
                .startObject()
        assertThat(response.getResponses()[4].getResponse().getIndex(), equalTo("test"));
        assertThat(numValues.size(), equalTo(3));
            prepareCreate("test").addAlias(new Alias("alias"))
            {
        assertAcked(
        assertEquals("test_keyword", source.get("keyword_field"));
        flush();
        assertThat(response.getField("field1").getValues().get(0).toString(), equalTo("value1"));
            .add(new MultiGetRequest.Item(indexOrAlias(), "2").version(1))
                        .field("type", "object")
        return multiGetResponse.getResponses()[0].getResponse();
    private void assertGetFieldWorks(String index, String type, String docId, String field, @Nullable String routing) {
        client().admin().indices().prepareCreate("index1").addAlias(new Alias("alias1").indexRouting("0")).get();
            .add(new MultiGetRequest.Item(indexOrAlias(), "3").storedFields("field"))
            + "      }\n"
        FlushResponse flushResponse = client().admin().indices().prepareFlush("my-index").setForce(true).get();
        assertEquals("bGlkaHQtd29rfx4=", source.get("binary_field"));
                .get()
            + "  \"mappings\": {\n"
import org.opensearch.common.settings.Settings;
                .setMapping(
        validateDeriveSource(source);
        getResponse = client().prepareGet("test_derive", "1").setFetchSource(new String[] { "keyword_field", "numeric_field" }, null).get();
                        .field("type", "text")
        assertEquals("test_keyword", source.get("keyword_field"));
        String createIndexSource = """
    }
        assertThat(response.isExists(), equalTo(true));
        assertAcked(
        client().prepareIndex("test").setId("1").setSource("field1", "value1", "field2", "value2").get();
        Map<String, Object> level3 = (Map<String, Object>) level2.get("level3");
import org.opensearch.action.get.GetResponse;
        }
        assertThat(response.getField("field1").getValues().get(0).toString(), equalTo("value1"));
            for (DefaultShardOperationFailedException failure : flushResponse.getShardFailures()) {
        // Flush fails if shard has ongoing recoveries, make sure the cluster is settled down
        assertThat(response.getResponses()[1].getFailure().getMessage(), startsWith("[2]: version conflict"));
public class GetActionIT extends OpenSearchIntegTestCase {
        source = getResponse.getSourceAsMap();
            .startObject("properties")
        logger.info("waiting for recoveries to complete");
                        "refresh_interval": -1
        GetResponse response = getDocument(index, type, docId, field, routing);
import static org.hamcrest.Matchers.nullValue;
        assertThat(response.getSourceAsMap().get("field2").toString(), equalTo("value2_2"));
        ensureGreen();
                .endObject()
        assertThat(response.getResponses()[4].getResponse().isExists(), equalTo(false));
        assertThat(response.isExists(), equalTo(true));
        assertThat(response.getSourceAsMap().get("field2").toString(), equalTo("value2"));
        assertThat(response.getSourceAsMap().get("field2").toString(), equalTo("value2"));
            .startObject("field")
            .endObject()
        assertTrue(getResponse.isExists());
    }
            .setRealtime(false)
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setSource(createIndexSource, MediaTypeRegistry.JSON));
            .put(IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey(), true)
        assertThat(response.getResponses()[0].getResponse().getSourceAsMap().get("field").toString(), equalTo("value1"));
        ensureGreen();
        // Version from Lucene index
        assertThat(response.getIndex(), equalTo("test"));
 * under the License.
import static org.hamcrest.Matchers.notNullValue;
        assertThat(fields, equalTo(singleton("field")));
        IndexResponse indexResponse = client().prepareIndex("index1").setId("id").setSource(Collections.singletonMap("foo", "bar")).get();
        } catch (VersionConflictEngineException e) {
        assertThat(getResponse.isExists(), equalTo(true));
        assertThat(response.getResponses()[0].getResponse().getSourceAsBytes(), nullValue());
        assertTrue(getResponse.isExists());
            + "  }\n"
        response = client().prepareGet(indexOrAlias(), "1").setVersion(2).setRealtime(false).get();
        String[] fieldsList = { "suggest" };
        assertFalse(source.containsKey("date_field"));
    }
                .setMapping(
            + storedString
            client().prepareGet(indexOrAlias(), "1").setVersion(1).get();
            .field("store", true)
        // From Lucene index:
                                "type": "ip"
        // Create index with settings and mapping
        assertThat(response.getResponses()[1].getFailure(), notNullValue());
 * this file be licensed under the Apache-2.0 license or a
            + "    \"refresh_interval\": \"-1\"\n"
                    .field("ip_field", "1.2.3.4")
        client().prepareIndex("test").setId("1").setSource("field1", "value1", "field2", "value2").get();
        MultiGetResponse multiGetResponse = multiGetRequestBuilder.get();
                        .endObject()
        assertThat(response.getId(), equalTo(docId));
    public void testGetDocWithMultivaluedFields() throws Exception {
        source = getResponse.getSourceAsMap();
    }
        refresh();
            fail();
        assertThat(response.getResponses()[1].getFailure().getMessage(), startsWith("[2]: version conflict"));
        assertThat(response.getSourceAsMap(), not(hasKey("field2")));
            .endObject()
            .startObject("properties")
 * GitHub history for details.
        // Get document after setting update for fetching original source
        String[] fieldsList = { "_routing" };
        assertThat(response.isExists(), equalTo(true));
                        .endObject()
        assertThat(response.getResponses()[1].getResponse().getIndex(), equalTo("test"));
    }
        assertGetFieldsAlwaysWorks(indexOrAlias(), "_doc", "1", fieldsList);
        assertGetFieldsAlwaysWorks(indexOrAlias(), "_doc", "1", fieldsList, "1");
        assertThat(response.getResponses()[2].getIndex(), equalTo("test"));
            .field("type", "text")
import org.opensearch.action.admin.indices.alias.Alias;
            }
    protected void assertGetFieldsNull(String index, String type, String docId, String[] fields, @Nullable String routing) {
        assertEquals(51.5074, (double) geopoint.get("lat"), 0.0001);
            .add(indexOrAlias(), "1")
import org.opensearch.core.common.bytes.BytesReference;
        client().prepareIndex("test")
    static String indexOrAlias() {
    public void testUngeneratedFieldsThatAreNeverStored() throws IOException {
        response = client().prepareGet(indexOrAlias(), "1").get();
        String doc = "{\n" + "  \"text1\": \"some text.\"\n," + "  \"text2\": \"more text.\"\n" + "}\n";
import java.util.List;
        assertEquals(-0.1278, (double) geopoint.get("lon"), 0.0001);
        assertEquals("2025-07-29T00:00:00.000Z", source.get("date_field"));
        assertAcked(
            .startObject("date_field")
        assertAcked(
        assertThat(fields, equalTo(Collections.<String>emptySet()));
        response = client().prepareGet(indexOrAlias(), "1").setVersion(Versions.MATCH_ANY).get();
        assertThat(response.isExists(), equalTo(true));
        assertThat(response.getVersion(), equalTo(1L));
        response = client().prepareGet(indexOrAlias(), "1").setStoredFields("field1").setFetchSource("field1", null).get();
            + "  \"settings\": {\n"
    }
        assertThat(response.getResponses()[1].getId(), equalTo("15"));
            .add(new MultiGetRequest.Item(indexOrAlias(), "1").version(1))
        assertThat(response.isExists(), equalTo(true));
        assertTrue(getResponse.isExists());
        if (randomBoolean()) {
            + "}";
            fail();
            assertGetFieldNull(index, type, docId, field, routing);
                        .endObject()
import org.opensearch.index.IndexSettings;
        MultiGetRequestBuilder multiGetRequestBuilder = client().prepareMultiGet().add(getItem);
            .add(new MultiGetRequest.Item(indexOrAlias(), "1").storedFields("field"))
        Set<String> fields = new HashSet<>(response.getFields().keySet());
        ensureGreen();
        flush();
                    .field("numeric_field", 123)
        // after refresh - document is in translog and also indexed
                .endObject()
        refresh();
        assertThat(response.getFields().get("field").getValues().get(0).toString(), equalTo("1"));
        response = multiGetDocument(index, type, docId, field, routing);
            + "  },\n"
            prepareCreate("test_derive").setSettings(
        assertThat(response.getId(), equalTo("1"));
        Map<String, Object> level1 = (Map<String, Object>) source.get("level1");
        flushAndRefresh("test");
    private void assertGetFieldsAlwaysWorks(String index, String type, String docId, String[] fields) {
            + "  }\n"
        assertThat(response.getResponses()[0].getResponse().isExists(), equalTo(true));
            prepareCreate("test").setMapping("field1", "type=keyword,store=true", "field2", "type=keyword,store=true")
                .prepareCreate("index2")
                .setSettings(Settings.builder().put("index.refresh_interval", -1))
        ensureGreen();
                        .endObject()
        String createIndexSource = "{\n"
                )
        assertThat(response.isExists(), equalTo(true));
            .add(new MultiGetRequest.Item(indexOrAlias(), "1").version(Versions.MATCH_ANY))
            StringBuilder sb = new StringBuilder("failed to flush at least one shard. total shards [").append(
        assertEquals(true, source.get("bool_field"));
                        .startObject("field4")
import org.opensearch.core.common.Strings;
        );
        assertThat(response.getResponses()[2].getResponse().getSourceAsMap().get("field").toString(), equalTo("value2"));
    }
        assertThat(response.getIndex(), equalTo("test"));
        assertThat(response.getResponses()[2].getResponse().isExists(), equalTo(true));
 * Unless required by applicable law or agreed to in writing,
                    .field("geopoint_field", Geohash.stringEncode(40.33, 75.98))
        // after refresh - document is in translog and also indexed
            .add(new MultiGetRequest.Item(indexOrAlias(), "1").version(Versions.MATCH_ANY))
        assertNotNull(source);
                        .startObject("properties")
        getResponse = client().prepareGet("my-index", "1").setStoredFields(field).get();
            getRequestBuilder.setRouting(routing);
import org.opensearch.plugins.Plugin;
                Settings.builder()
            .add(new MultiGetRequest.Item(indexOrAlias(), "1").version(2))
        // before refresh - document is only in translog
        assertThat(response.getFields().get("field").getValues().get(0).toString(), equalTo("1"));
        assertThat(response.getResponses().length, equalTo(3));
    public void testDerivedSource_MultiValuesAndComplexField() throws Exception {
        response = multiGetDocument(index, type, docId, field, routing);
        // before refresh - document is only in translog
 * ownership. Elasticsearch licenses this file to you under
        Map<String, Object> geopoint = (Map<String, Object>) source.get("geopoint_field");
        assertThat(response.getResponses()[1].getFailure().getId(), equalTo("2"));
        for (int i = 0; i < 3; i++) {
        getResponse = client().prepareGet("test_derive", "1").setFetchSource(null, new String[] { "text_field", "date_field" }).get();
}
                        .endObject()
        assertNotNull(source);
                "mappings": {
        GetResponse getResponse = client().prepareGet("test_derive", "1").get();
                        .endObject()
        response = client().prepareGet(indexOrAlias(), "1").get();
import org.opensearch.geometry.utils.Geohash;
            .startObject()
        GetResponse response = client().prepareGet(indexOrAlias(), "1").get();
            .field("type", "date")
        // Index a document with various field types
        assertThat(fields, equalTo(Collections.<String>emptySet()));
        Map<String, Object> latLon = (Map<String, Object>) source.get("geopoint_field");
        assertEquals("2025-07-30T00:00:00.000Z", source.get("date_field"));
        assertNull(response.getField(field));
            + "    }\n"
        return getRequestBuilder.get();
        assertThat(response.getResponses()[0].getResponse().getSourceAsMap().get("field").toString(), equalTo("value1"));
        assertThat(indexResponse.status().getStatus(), equalTo(RestStatus.CREATED.getStatus()));
            + "          \"type\": \"text\",\n"
                        "properties": {
                .startArray("field3")
        String[] fieldsList = { "_field_names" };
        String[] alwaysNotStoredFieldsList = { "_field_names" };
 * SPDX-License-Identifier: Apache-2.0
        ensureGreen();
        validateDeriveSource(source);
                            "date_field": {
        assertAcked(
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value" + i).get();
        assertGetFieldsAlwaysNull(index, type, docId, fields, null);
            .endArray()
        assertThat(response.getVersion(), equalTo(2L));
        // Flush the index
        client().prepareIndex("test").setId("1").setSource("field1", "value1_2", "field2", "value2_2").get();
        assertNotNull(response.getField(field));
import static org.hamcrest.Matchers.not;
import org.opensearch.action.get.MultiGetRequestBuilder;
import java.util.Collections;
    private void assertGetFieldsAlwaysWorks(String index, String type, String docId, String[] fields, @Nullable String routing) {
        logger.info("--> realtime get 1 (no source, explicit)");
            .setSource(
        assertThat(response.getId(), equalTo(docId));
                                "type": "text"
        assertThat(response.getResponses()[1].getIndex(), equalTo("test"));
                        .startObject("properties")
                            },
                        .startObject("properties")
                    }
        logger.info("--> index doc 1 again, so increasing the version");
                        .startObject("properties")
                jsonBuilder().startObject()
        try {
            .startObject("level3")
        assertThat(getResponse.getField(field).getValues().get(1).toString(), equalTo("value2"));
    }
            + "  }\n"
        assertNotNull("Derived source should not be null", source);
    }
    public void testUngeneratedFieldsNotPartOfSourceStored() throws IOException {
        for (int i = 0; i < 10; i++) {
            .startArray("level3")
        // Version from translog
                            "binary_field": {
        ensureGreen();
            .endArray()
            + "\""
        assertThat(response.getResponses()[2].getFailure(), nullValue());
    }
            .get();
        assertTrue(getResponse.isExists());
            () -> client().prepareGet(indexOrAlias(), "1").setStoredFields("field1").get()
            .setSource(jsonBuilder().startObject().startObject("field1").field("field2", "value1").endObject().endObject())
        assertThat(response.isExists(), equalTo(true));
        assertThat(response.getResponses()[0].getResponse().getSourceAsMap().get("field").toString(), equalTo("value2"));
                            "ip_field": {
        GetResponse response = client().prepareGet("test", "1").get();
        String createIndexSource = "{\n"
        Map<String, Object> source = getResponse.getSourceAsMap();
        logger.info("--> realtime fetch of field & source");
            + "    \"input\": [\n"
            + "    \"index.translog.flush_threshold_size\": \"1pb\",\n"
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value" + i).get();
        assertThat(response.getResponses()[0].getId(), equalTo("2"));
            + "      \"Nirvana\"\n"
            + "      }\n"
    }
        assertEquals("2025-07-30", source.get("date_field"));
            client().prepareGet(indexOrAlias(), "1").setVersion(1).setRealtime(false).get();
                            },
        assertThat(response.getResponses()[2].getFailure(), notNullValue());
import org.opensearch.action.update.UpdateResponse;
        flush();
        assertThat(response.getVersion(), equalTo(2L));
    private GetResponse multiGetDocument(String index, String type, String docId, String field, @Nullable String routing) {
        IllegalArgumentException exception = expectThrows(
            .endObject()
                                "type": "long"
        }
        // Test get with selective field inclusion
        assertThat(response.getResponses()[2].getId(), equalTo("2"));
                        .startObject("field2")
        response = client().prepareGet("test", "1").setStoredFields("field").get();
 * specific language governing permissions and limitations
    protected void assertGetFieldsAlwaysNull(String index, String type, String docId, String[] fields) {
    protected void assertGetFieldNull(String index, String type, String docId, String field, @Nullable String routing) {
        assertThat(getResponse.getField(field).getValues().get(1).toString(), equalTo("value2"));
            .endObject()
                .endArray()
                            "bool_field": {
            jsonBuilder().startObject()
 * You may obtain a copy of the License at
        assertThat(getResponse.getField(field).getValues().get(0).toString(), equalTo("value1"));
        assertThat(response.getResponses()[4].getIndex(), equalTo("test"));
                    .endObject()
        assertEquals("1.2.3.4", source.get("ip_field"));
        assertThat(response.getField("field2"), nullValue());
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(ipValues, containsInRelativeOrder("1.2.3.4", "2.3.4.5"));
        assertThat(response.isExists(), equalTo(true));
        assertThat(response.getIndex(), equalTo("test"));
        // Version from Lucene index
        assertThat(response.getVersion(), equalTo(2L));
            .setId("1")
        // From translog:
        assertThat(response.getId(), equalTo("1"));
 * not use this file except in compliance with the License.
        }
        assertGetFieldsAlwaysNull(indexOrAlias(), "_doc", "1", fieldsList);
                                "type": "binary",
                        .endObject()
            .field("type", "ip")
        assertThat(response.getResponses()[0].getFailure(), nullValue());
        assertThat(response.getField("field1").getValues().get(0).toString(), equalTo("value1"));
        assertNull(response.getField(field));
/*
                                "type": "keyword"
                .indices()
        String[] fieldsList = { "text1", "text2" };
        String field = "field1.field2.field3.field4";
        if (routing != null) {
        MultiGetResponse response = client().prepareMultiGet().add(indexOrAlias(), "1").get();
    }
        assertThat(response.getResponses()[2].getId(), equalTo("3"));
            .endObject()
        assertEquals("2025-07-30T00:00:00.000Z", source.get("date_field"));
        assertThat(getResponse.getField(field).getValues().get(0).toString(), equalTo("value1"));
            .endObject()
        assertThat(response.getId(), equalTo("1"));
        fields = new HashSet<>(response.getFields().keySet());
    }
        response = client().prepareGet(indexOrAlias(), "1").setVersion(Versions.MATCH_ANY).get();
        source = getResponse.getSourceAsMap();
            .endObject()
                .get();
            .startObject("level2")
        assertThat(response.getId(), equalTo("1"));
        flush();
        assertGetFieldsAlwaysWorks(indexOrAlias(), "_doc", "1", fieldsList, "1");
    public void testSimpleMultiGet() throws Exception {
import java.util.HashSet;
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setSource(createIndexSource, MediaTypeRegistry.JSON));
            + "    \"index.translog.flush_threshold_size\": \"1pb\",\n"
            .add(indexOrAlias(), "3")
        assertThat(response.getId(), equalTo("1"));
        logger.info("--> realtime get 1 (no type)");
                .setSettings(Settings.builder().put("index.refresh_interval", -1))
import org.opensearch.action.DocWriteResponse;
        assertThat(response.getIndex(), equalTo("test"));
            + "}";
        logger.info("--> index doc 1");
        assertThat(response.isExists(), equalTo(true));
        assertThat(response.getIndex(), equalTo("test"));
        );
            // all good
                        "derived_source": {
 */
            .endObject()
/*
    }
        assertThat(response.getResponses()[1].getId(), equalTo("1"));
        Map<String, Object> source = getResponse.getSourceAsMap();
        indexSingleDocumentWithStringFieldsGeneratedFromText(false, randomBoolean());
        logger.info("indexing documents");
        assertGetFieldsAlwaysWorks(indexOrAlias(), "_doc", "1", fieldsList, "1");
        Set<String> fields = new HashSet<>(response.getFields().keySet());
                .endObject()
        source = getResponse.getSourceAsMap();
        assertThat(getResponse.getField(field).getValues().size(), equalTo(2));
        try {
            assertGetFieldWorks(index, type, docId, field, routing);
        logger.info("checking real time retrieval");
        assertThat(response.getField("field2"), nullValue());
        // Update document, so that version map gets created and get will be served from translog
                    .put("index.derived_source.enabled", true)
            .startArray("level1")
        assertGetFieldsAlwaysNull(indexOrAlias(), "_doc", "1", fieldsList);
            + "    \"refresh_interval\": \"-1\"\n"
        assertThat(response.getSourceAsMap().get("field1").toString(), equalTo("value1_1"));
                        .endObject()
        assertThat(response.getResponses()[2].getFailure(), notNullValue());
        getResponse = client().prepareGet("test", "1").get();
            }""";
        assertTrue(source.containsKey("binary_field"));
        assertThat(response.getSourceAsMap().get("field2").toString(), equalTo("value2"));
import org.opensearch.action.index.IndexResponse;
            + sourceEnabled
        assertGetFieldsAlwaysNull(indexOrAlias(), "_doc", "1", fieldsList);
        assertThat(response.getField("field2"), nullValue());
        assertThat(response.getResponses()[0].getFailure(), nullValue());
                            },
                }
            + "        }\n"
        assertEquals(123, source.get("numeric_field"));
        source = getResponse.getSourceAsMap();
        fields = new HashSet<>(response.getFields().keySet());
            .startObject()
        response = client().prepareGet(indexOrAlias(), "1").setStoredFields(Strings.EMPTY_ARRAY).get();
                        .startObject("field2")
                .startObject()
        assertThat(response.getResponses()[2].getFailure().getMessage(), startsWith("[1]: version conflict"));
        String storedString = stored ? "true" : "false";
            + "  },\n"
        assertThat(response.isExists(), equalTo(true));
            .get();
            .endObject()
            .endObject()
        assertThat(getResponse.getField(field).getValues().size(), equalTo(2));
        assertThat(response.getResponses()[2].getId(), equalTo("2"));
        assertThat(response.getResponses()[0].getResponse().isExists(), equalTo(false));
    }
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value" + i).get();
        // Get updated document, this will be derived source as per translog read preference setting
        assertThat(response.getResponses()[2].getIndex(), equalTo("test"));
            + "      \"_source\" : {\"enabled\" : "
        // after refresh - document is in translog and also indexed
            .value("1.2.3.4")
import org.opensearch.common.xcontent.XContentFactory;
            .setDoc(jsonBuilder().startObject().field("geopoint_field", "51.5074,-0.1278").field("date_field", "2025-07-30").endObject())
            IllegalArgumentException.class,
            .endArray()
        assertThat(response.isExists(), equalTo(true));
        assertThat(response.getResponses()[0].getIndex(), equalTo("test"));
        String doc = "{\n" + "  \"text\": \"some text.\"\n" + "}\n";
            .toString();
        assertThat(response.getSourceAsMap().get("field1").toString(), equalTo("value1"));
        // Create mapping with properly closed objects
            + "          \"type\": \"completion\"\n"
import java.io.IOException;
 *
        assertThat(response.isExists(), equalTo(true));
        assertTrue(getResponse.isExists());
            + "        \"text1\": {\n"
        logger.info("--> realtime get 1");
        );
        List<Object> numValues = (List<Object>) level3.get("num_field");
        assertTrue(getResponse.isExists());
        logger.info("--> realtime get 1");
            .endObject()
import static org.hamcrest.Matchers.hasKey;
        assertThat(response.isExists(), equalTo(true));
    }
        // [0] version doesn't matter, which is the default
        // [0] version doesn't matter, which is the default
        assertNotNull(response.getField(field));
        assertThat(getResponse.getField(field).getValues().get(0).toString(), equalTo("value1"));
    protected void assertGetFieldsAlwaysNull(String index, String type, String docId, String[] fields, @Nullable String routing) {
        assertNotNull("Derived source should not be null", source);
        assertThat(response.getId(), equalTo("1"));
                .addAlias(new Alias("alias").writeIndex(randomFrom(true, false, null)))
        assertThat(response.getResponses()[1].getIndex(), equalTo("test"));
            .startObject("level1")
        response = client().prepareGet(indexOrAlias(), "1").setVersion(1).get();
            client().admin().indices().prepareCreate("index3").addAlias(new Alias("alias1").indexRouting("1").writeIndex(true)).get();
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setSettings(Settings.builder().put("index.refresh_interval", -1)));
        assertThat(response.getResponses().length, equalTo(1));
            .startObject("geopoint_field")
        logger.info("flushing");
            + "  \"settings\": {\n"
                .indices()
 * Licensed to Elasticsearch under one or more contributor
        assertTrue(response.isExists());
        assertTrue(response.isExists());
                            },
import java.util.Collection;
        response = client().prepareGet(indexOrAlias(), "1").get();
        assertThat(response.getResponses().length, equalTo(5));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertThat(response.getResponses()[0].getResponse().getField("field").getValues().get(0).toString(), equalTo("value1"));
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertThat(response.getResponses()[1].getResponse().getSourceAsMap().get("field").toString(), equalTo("value1"));
            .field("type", "geo_point")
            .put("index.refresh_interval", -1)
        response = client().prepareGet(indexOrAlias(), "1").setStoredFields("field1").setFetchSource(true).get();
        assertThat(response.getVersion(), equalTo(1L));
                            "keyword_field": {
        assertThat(response.getResponses()[0].getResponse().isExists(), equalTo(false));
        assertThat(response.getResponses()[0].getIndex(), equalTo("test"));
        response = client().prepareGet(indexOrAlias(), "1").setFetchSource(false).get();
 */
        }
        refresh();
            .endArray()
            fail();
            .value(1)
        assertAcked(
import org.opensearch.test.InternalSettingsPlugin;
            .endObject()
        assertThat(response.getIndex(), equalTo("test"));
        return randomBoolean() ? "test" : "alias";
                    "index": {
            .startObject("properties")
        assertThat(response.getResponses()[2].getFailure().getFailure(), instanceOf(VersionConflictEngineException.class));
        assertThat(response.getResponses()[2].getFailure().getFailure(), instanceOf(VersionConflictEngineException.class));
package org.opensearch.get;
        );
        // Update translog read preference to source
        assertThat(response.getResponses()[1].getFailure().getId(), equalTo("2"));
import org.opensearch.action.delete.DeleteResponse;
                                "type": "boolean"
                        .startObject("properties")
        IllegalArgumentException exc = expectThrows(
        assertThat(response.getVersion(), equalTo(1L));
        logger.info("checking post-flush retrieval");
        assertGetFieldsAlwaysWorks(indexOrAlias(), "_doc", "1", fieldsList, "routingValue");
                .startObject("field2")
    public void testDerivedSourceTranslogReadPreference() throws Exception {
            + storedString
import org.opensearch.action.get.MultiGetResponse;
            .get();
            client().admin()
 * this work for additional information regarding copyright
                .setMapping("field", "type=keyword,store=true")
                .endObject()
            + "      \"properties\": {\n"
        // after flush - document is in not anymore translog - only indexed
        // after flush - document is in not anymore translog - only indexed
import org.opensearch.action.admin.indices.flush.FlushResponse;
        assertThat(response.getResponses()[1].getResponse().getSourceAsMap().get("field").toString(), equalTo("value1"));
        assertEquals(51.5074, (double) geopoint.get("lat"), 0.0001);
            .startObject()
        // Index a document
        response = client().prepareGet(indexOrAlias(), "1").setStoredFields("field1").get();
            + "    }\n"
            .field("type", "integer")
            + "    \"_doc\": {\n"
/*
        response = client().prepareGet(indexOrAlias(), "1").setVersion(1).setRealtime(false).get();
            .endObject()
        assertAcked(prepareCreate("test").setMapping(mapping1));
import static org.hamcrest.Matchers.equalTo;
            .setSource(
        assertEquals(40.7128, (double) geopoint.get("lat"), 0.0001);
    public void testGetFieldsComplexField() throws Exception {
        String mapping = XContentFactory.jsonBuilder()
            fail(sb.toString());
        response = client().prepareGet(indexOrAlias(), "1").setVersion(Versions.MATCH_ANY).setRealtime(false).get();
        assertThat(response.getFields().get("field").getValues().get(1).toString(), equalTo("2"));
                        .startObject("field1")
                            "text_field": {
        // [0] version doesn't matter, which is the default
        assertThat(response.getResponses()[0].getIndex(), equalTo("test"));
        assertThat(response.getField("field2"), nullValue());
        assertGetFieldsAlwaysNull(indexOrAlias(), "_doc", "1", fieldsList);
                .setSettings(Settings.builder().put(IndexSettings.INDEX_DERIVED_SOURCE_TRANSLOG_ENABLED_SETTING.getKey(), false))
        try {
        assertThat(response.getResponses()[0].getResponse().getSourceAsMap().get("field").toString(), equalTo("value1"));
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setSource(createIndexSource, MediaTypeRegistry.JSON));
            .startObject()
    public void testGetWithAliasPointingToMultipleIndices() {
        }
        refresh();
                    .field("keyword_field", "test_keyword")
        response = client().prepareMultiGet()
            ).append("], failed shards: [").append(flushResponse.getFailedShards()).append("]");
            + "    ]\n"
                .endArray()
import org.opensearch.common.Nullable;
        assertThat(response.getIndex(), equalTo("test"));
        // Ip field is stored as Sorted Set, so duplicates should be removed and result should be in sorted order
            .get();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertGetFieldsAlwaysNull(indexOrAlias(), "_doc", "1", fieldsList);
    protected void assertGetFieldsNull(String index, String type, String docId, String[] fields) {
        ensureGreen();
                .field("field4", "value1")
        MultiGetRequest.Item getItem = new MultiGetRequest.Item(index, docId).storedFields(field);
import org.opensearch.action.get.MultiGetRequest;
        assertThat(response.getResponses()[0].getResponse().isExists(), equalTo(true));
        client().prepareIndex("my-index").setId("1").setSource(source, MediaTypeRegistry.JSON).get();
        logger.info("--> non realtime get 1");
        assertThat(response.getFields().get("field").getValues().get(1).toString(), equalTo("2"));
        // before refresh - document is only in translog
        assertThat(response.getSourceAsMap().get("field2").toString(), equalTo("value2"));
        assertThat(response.isExists(), equalTo(true));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .startObject("num_field")
    public void testDerivedSourceSimple() throws IOException {
        assertThat(getResponse.isExists(), equalTo(true));
        assertGetFieldsNull(indexOrAlias(), "_doc", "1", alwaysNotStoredFieldsList);
        logger.info("--> realtime fetch of field");
        assertThat(response.getResponses()[1].getResponse().isExists(), equalTo(true));
        GetResponse response = getDocument(index, type, docId, field, routing);
        IndexResponse indexResponse = client().prepareIndex("test")
                .setSettings(Settings.builder().put("index.refresh_interval", -1))
    }
            .startObject("level2")
        GetRequestBuilder getRequestBuilder = client().prepareGet().setIndex(index).setId(docId).setStoredFields(field);
