            client().prepareGet(indexOrAlias(), "1").setVersion(2).get();
        assertThat(getResponse.getField(field).getValues().get(1).toString(), equalTo("value2"));
        ensureGreen();  
        assertGetFieldsAlwaysNull(indexOrAlias(), "_doc", "1", fieldsList);
        // Get document prior to update, which would be derived source
        // Flush the index
            jsonBuilder().startObject()
        response = client().prepareGet(indexOrAlias(), "1").setVersion(Versions.MATCH_ANY).setRealtime(false).get();  
            + "  }\n"  
import org.opensearch.action.get.GetResponse;  
            .get();  
            + "\""
            + "  },\n"  
        getResponse = client().prepareGet("test", "1").get();  
            .endObject()  
            .add(new MultiGetRequest.Item(indexOrAlias(), "2").version(2))
        assertThat(response.isExists(), equalTo(true));  
        assertEquals("2025-07-30T00:00:00.000Z", source.get("date_field"));
                    .field("date_field", "2023-01-01")
        response = client().prepareGet(indexOrAlias(), "1").setVersion(2).get();  
            prepareCreate("my-index")
        assertThat(response.isExists(), equalTo(true));
        response = client().prepareGet(indexOrAlias(), "1").get();  
        assertThat(response.getResponses()[0].getIndex(), equalTo("test"));
                        .endObject()  
        ensureGreen();  
                                "type": "long"
import java.util.Set;
    }  
        try {
import org.opensearch.index.IndexSettings;
        assertThat(response.isExists(), equalTo(true));
            .field("type", "integer")
        assertThat(response.getFields().get("field").getValues().size(), equalTo(2));
        validateDeriveSource(source);  
        response = multiGetDocument(index, type, docId, field, routing);
                        .startObject("field1")
        assertThat(exc.getMessage(), equalTo("field [field1] isn't a leaf field"));  
    public void testDerivedSource_MultiValuesAndComplexField() throws Exception {
                .endObject()
        response = client().prepareGet(indexOrAlias(), "1").get();  
        assertThat(response.getResponses()[0].getId(), equalTo("1"));  
                .get()  
        assertNotNull(response.getField(field));  
                .prepareCreate("index2")  
        String createIndexSource = "{\n"  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(exception.getMessage(), endsWith("can't execute a single index op"));
                .setSettings(Settings.builder().put("index.refresh_interval", -1))  
                                "type": "keyword"
        // before refresh - document is only in translog  
        // after flush - document is in not anymore translog - only indexed  
            + "          \"store\": \""  
            .setId("1")  
    public void testUngeneratedFieldsNotPartOfSourceStored() throws IOException {
            .toString();
import static org.hamcrest.Matchers.instanceOf;
                },
        assertThat(response.getResponses()[3].getResponse().isExists(), equalTo(true));
            + "    ]\n"
            .endObject()  
            .endObject()  
            .put("index.number_of_shards", 1)  
        // Flush fails if shard has ongoing recoveries, make sure the cluster is settled down
            prepareCreate("test").addAlias(new Alias("alias"))
        assertThat(response.isExists(), equalTo(true));  
                .startArray("field3")  
        assertThat(response.getResponses()[0].getId(), equalTo("2"));
import org.opensearch.action.delete.DeleteResponse;
        response = client().prepareGet(indexOrAlias(), "1").setStoredFields("field1").get();
        // From Lucene index:  
                .setSettings(Settings.builder().put("index.refresh_interval", -1))  
 * license agreements. See the NOTICE file distributed with
            // all good  
        assertThat(response.getSourceAsMap(), hasKey("field1"));  
        assertThat(response.getResponses()[0].getResponse().isExists(), equalTo(true));
        assertThat(response.getId(), equalTo("1"));
            .endObject()
    private void assertGetFieldWorks(String index, String type, String docId, String field, @Nullable String routing) {
        assertThat(numValues, containsInRelativeOrder(1, 1, 2));
        assertThat(response.isExists(), equalTo(true));
        GetResponse response = getDocument(index, type, docId, field, routing);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        FlushResponse flushResponse = client().admin().indices().prepareFlush("my-index").setForce(true).get();  
            .get();  
        assertEquals("51.5074,-0.1278", source.get("geopoint_field"));
        String field = "field1.field2.field3.field4";
        assertThat(response.getResponses()[1].getResponse().isExists(), equalTo(true));  
            .endObject()
                        "refresh_interval": -1  
        refresh();
        assertThat(response.getResponses()[2].getFailure().getFailure(), instanceOf(VersionConflictEngineException.class));
            client().prepareGet(indexOrAlias(), "1").setVersion(1).get();  
    void validateDeriveSource(Map<String, Object> source) {
        assertThat(exc.getMessage(), equalTo("field [field1] isn't a leaf field"));
        String createIndexSource = """  
        response = client().prepareGet(indexOrAlias(), "1").setStoredFields("field1").setFetchSource(true).get();
            .startObject("date_field")  
        assertEquals(2, source.size());
    public void testGetDocWithMultivaluedFields() throws Exception {
    }  
            fail();
        assertNotNull(response.getField(field));
            assertGetFieldNull(index, type, docId, field, routing);  
        ensureGreen();
            .endObject()  
 *
        assertThat(response.getSourceAsMap().get("field1").toString(), equalTo("value1"));
        assertThat(response.getResponses()[0].getId(), equalTo("1"));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        Map<String, Object> level3 = (Map<String, Object>) level2.get("level3");  
        assertThat(getResponse.isExists(), equalTo(true));
        assertGetFieldsAlwaysWorks(indexOrAlias(), "_doc", "1", fieldsList, "1");  
        }  
        assertThat(response.getResponses()[1].getIndex(), equalTo("test"));
                            },
        // after refresh - document is in translog and also indexed
            fail();  
        client().admin().indices().prepareCreate("index1").addAlias(new Alias("alias1").indexRouting("0")).get();
        getResponse = client().prepareGet("test", "1").get();  
        assertEquals("2025-07-30", source.get("date_field"));  
        assertThat(response.getResponses()[1].getResponse().isExists(), equalTo(false));
        Map<String, Object> latLon = (Map<String, Object>) source.get("geopoint_field");
        assertThat(response.getResponses()[4].getResponse().isExists(), equalTo(false));  
            .endObject()  
        // before refresh - document is only in translog
                .endObject()  
        assertNotNull("Derived source should not be null", source);
            + "          \"type\": \"text\",\n"
        flush();
    }
        String createIndexSource = "{\n"  
                    .endObject()
        assertThat(response.getResponses()[0].getId(), equalTo("2"));
                        .field("type", "object")
        assertThat(response.isExists(), equalTo(true));
            + "    \"index.translog.flush_threshold_size\": \"1pb\",\n"
        String[] fieldsList = { "suggest" };  
        assertThat(response.getResponses()[2].getIndex(), equalTo("test"));  
                        .startObject("properties")
                        .endObject()
        ensureGreen();
        assertNull(response.getField(field));
        client().prepareIndex("my-index").setId("1").setSource(source, MediaTypeRegistry.JSON).get();
            .endObject()
            + "  \"settings\": {\n"
        assertFalse(source.containsKey("date_field"));
        assertAcked(prepareCreate("test_derive").setSource(createIndexSource, MediaTypeRegistry.JSON));  
        assertThat(response.getIndex(), equalTo("test"));  
 * SPDX-License-Identifier: Apache-2.0
    public void testGetWithAliasPointingToMultipleIndices() {
        assertAcked(  
import org.opensearch.action.DocWriteResponse;
            .startObject("properties")
            .put("index.number_of_replicas", 0)
        assertThat(response.getResponses().length, equalTo(3));
            .endObject()
                        .endObject()
    }  
                .prepareUpdateSettings("test")
            + "      \"_source\" : {\"enabled\" : "  
            .toString();
        return Collections.singleton(InternalSettingsPlugin.class);  
        assertThat(response.getField("field2"), nullValue());  
import java.util.HashSet;
        // [0] version doesn't matter, which is the default
        if (routing != null) {
            .startArray("level3")
        GetRequestBuilder getRequestBuilder = client().prepareGet().setIndex(index).setId(docId).setStoredFields(field);
        assertThat(response.getId(), equalTo("1"));
                .endArray()
        response = client().prepareGet(indexOrAlias(), "1").get();  
 */  
            .add(new MultiGetRequest.Item(indexOrAlias(), "2").version(1))
        logger.info("--> realtime get 1");
        response = client().prepareMultiGet()  
            .add(indexOrAlias(), "15")
        assertGetFieldsAlwaysWorks(indexOrAlias(), "_doc", "1", fieldsList);  
import static org.hamcrest.Matchers.equalTo;  
        assertTrue(getResponse.isExists());  
            .put(IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey(), true)  
                        .endObject()
        // [0] version doesn't matter, which is the default  
            + "      \"Nevermind\",\n"
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            + "  \"settings\": {\n"
        refresh();
        logger.info("--> realtime get 1 (no source, implicit)");
    }
package org.opensearch.get;
            + "  }\n"  
        response = multiGetDocument(index, type, docId, field, routing);
                .startArray("field3")  
        assertThat(response.getResponses()[1].getFailure(), notNullValue());  
        validateDeriveSource(source);
        assertThat(response.isExists(), equalTo(true));
                .startObject()
        refresh();  
import org.opensearch.test.InternalSettingsPlugin;
import org.opensearch.action.get.MultiGetResponse;  
        response = client().prepareMultiGet()
            .get();
        assertThat(response.getIndex(), equalTo("test"));
            .setRealtime(false)  
                            },
                .indices()
                .addAlias(new Alias("alias").writeIndex(randomFrom(true, false, null)))
        assertThat(response.isExists(), equalTo(true));  
            .add(indexOrAlias(), "3")  
        ensureGreen();
                        .endObject()
            )  
import org.opensearch.action.admin.indices.alias.Alias;
            + "  }\n"
        assertThat(response.isExists(), equalTo(true));
        logger.info("--> refresh the index, so we load it from it");  
        assertEquals("test_keyword", source.get("keyword_field"));
        // Create index with derived source enabled and translog read preference set
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setSettings(Settings.builder().put("index.refresh_interval", -1)));  
        assertThat(response.getSourceAsMap().get("field2").toString(), equalTo("value2_2"));
 * compatible open source license.
            + "  \"settings\": {\n"  
        MultiGetRequest.Item getItem = new MultiGetRequest.Item(index, docId).storedFields(field);  
        assertEquals(6, source.size());
        assertThat(response.getResponses()[2].getFailure().getId(), equalTo("1"));
/*
        GetResponse getResponse = client().prepareGet("test_derive", "1").get();  
        Set<String> fields = new HashSet<>(response.getFields().keySet());
        flush();
        assertAcked(  
        String[] fieldsList = { "text1", "text2" };  
        assertThat(response.getSourceAsMap().get("field2").toString(), equalTo("value2"));
        assertThat(response.getResponses()[0].getResponse().isExists(), equalTo(true));
 * this work for additional information regarding copyright
                            "text_field": {  
            .add(new MultiGetRequest.Item(indexOrAlias(), "1").storedFields("field"))
 * ownership. Elasticsearch licenses this file to you under  
                                "type": "binary",
                .endObject()  
        assertThat(response.getResponses()[2].getFailure().getFailure(), instanceOf(VersionConflictEngineException.class));
        assertThat(response.getSourceAsBytes(), nullValue());  
                    .field("ip_field", "1.2.3.4")
        source = getResponse.getSourceAsMap();
                            "ip_field": {  
    void indexSingleDocumentWithStringFieldsGeneratedFromText(boolean stored, boolean sourceEnabled) {
        assertThat(response.getResponses()[1].getFailure().getId(), equalTo("2"));
        logger.info("--> realtime fetch of field (loaded from index)");
            .toString();  
            + "  },\n"
        assertThat(response.getResponses()[2].getIndex(), equalTo("test"));
        assertThat(getResponse.getField(field).getValues().get(0).toString(), equalTo("value1"));  
        assertTrue(response.isExists());
        client().prepareIndex("test").setId("1").setSource(doc, MediaTypeRegistry.JSON).setRouting("1").get();  
        for (String field : fields) {  
            + "      }\n"
            .startArray("ip_field")  
        List<Object> ipValues = (List<Object>) level3.get("ip_field");  
        assertThat(response.getVersion(), equalTo(2L));
        if (randomBoolean()) {  
        Set<String> fields = new HashSet<>(response.getFields().keySet());  
        source = getResponse.getSourceAsMap();
                    jsonBuilder().startObject()
        refresh();
                .setMapping("field", "type=keyword,store=true")
        assertAcked(prepareCreate("test").setMapping(mapping1));  
        assertThat(fields, equalTo(Collections.<String>emptySet()));
            + "    \"_doc\": {\n"
            .value(2)  
        } catch (VersionConflictEngineException e) {
    }
            .get();  
        source = getResponse.getSourceAsMap();  
        ensureGreen();
        assertThat(getResponse.getField(field).getValues().get(1).toString(), equalTo("value2"));
        assertThat(response.getResponses()[1].getId(), equalTo("1"));  
        String[] fieldsList = { "_routing" };
        response = client().prepareMultiGet()  
        indexSingleDocumentWithStringFieldsGeneratedFromText(false, randomBoolean());
            .startObject("num_field")
        assertGetFieldsAlwaysNull(indexOrAlias(), "_doc", "1", fieldsList);
            + "    \"index.translog.flush_threshold_size\": \"1pb\",\n"
        assertThat(response.isExists(), equalTo(true));
        assertThat(response.getResponses()[0].getFailure(), nullValue());  
                .startObject()
                        }
        String mapping = XContentFactory.jsonBuilder()  
        logger.info("waiting for recoveries to complete");  
        logger.info("--> realtime get 1 (no source, explicit)");  
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value" + i).get();
            }""";
    }
        assertNotNull(source);  
        assertThat(response.getResponses()[1].getFailure().getMessage(), startsWith("[2]: version conflict"));  
                .field("field4", "value1")
                        .endObject()
            .value("2.3.4.5")
                        .startObject("properties")  
        assertEquals("bGlkaHQtd29rfx4=", source.get("binary_field"));
import org.opensearch.core.xcontent.XContentBuilder;  
            .get();  
        assertTrue(response.isExists());
        }
                    jsonBuilder().startObject()  
        ensureGreen();
        response = client().prepareGet(indexOrAlias(), "1").setVersion(1).get();
                jsonBuilder().startObject()
        assertEquals(-0.1278, (double) geopoint.get("lon"), 0.0001);  
        assertThat(getResponse.getField(field).getValues().size(), equalTo(2));
            assertGetFieldWorks(index, type, docId, field, routing);
        assertThat(response.getSourceAsBytes(), nullValue());
 */  
    public void testSimpleMultiGet() throws Exception {
                        .startObject("field2")
        assertGetFieldsAlwaysNull(indexOrAlias(), "_doc", "1", fieldsList);
        assertThat(response.getResponses()[0].getResponse().getSourceAsMap().get("field").toString(), equalTo("value1"));
        assertThat(response.getResponses()[2].getFailure().getMessage(), startsWith("[1]: version conflict"));  
        assertThat(response.getSourceAsMap().get("field1").toString(), equalTo("value1"));  
import static org.hamcrest.Matchers.notNullValue;
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setSource(createIndexSource, MediaTypeRegistry.JSON));  
        assertThat(response.getId(), equalTo("1"));
            .setSource(
                .endObject()  
        assertThat(response.isExists(), equalTo(true));
                .endObject()
        assertThat(response.getId(), equalTo(docId));
                            "date_field": {  
            .startObject()  
        assertEquals(-0.1278, (double) geopoint.get("lon"), 0.0001);  
        assertTrue(source.containsKey("binary_field"));
            .field("type", "text")  
        try {
        // Index a document
 * The OpenSearch Contributors require contributions made to  
        client().prepareIndex("test").setId("1").setSource("field1", "value1", "field2", "value2").get();
        }
        assertThat(response.getSourceAsMap().get("field1").toString(), equalTo("value1_2"));  
        assertThat(response.getId(), equalTo("1"));
                    "_doc": {
        assertTrue(response.isExists());  
    }
import static org.hamcrest.Matchers.endsWith;
        assertThat(response.getResponses().length, equalTo(3));
    protected void assertGetFieldNull(String index, String type, String docId, String field, @Nullable String routing) {
        assertThat(response.getResponses()[0].getIndex(), equalTo("test"));  
        assertThat(response.getResponses()[1].getResponse().getSourceAsMap().get("field").toString(), equalTo("value1"));
            () -> client().prepareGet(indexOrAlias(), "1").setStoredFields("field1").get()
                .addAlias(new Alias("alias1").indexRouting("0").writeIndex(randomFrom(false, null)))
import org.opensearch.geometry.utils.Geohash;
            + "    }\n"  
        // Now test values being fetched from stored fields.  
        client().prepareIndex("test").setId("1").setSource(jsonBuilder().startObject().array("field", "1", "2").endObject()).get();
        assertThat(response.getIndex(), equalTo("test"));  
            .setSource(jsonBuilder().startObject().startObject("field1").field("field2", "value1").endObject().endObject())
import org.opensearch.action.get.MultiGetRequest;
        refresh();
            + "        }\n"
    public void testMultiGetWithVersion() throws Exception {
        exc = expectThrows(IllegalArgumentException.class, () -> client().prepareGet(indexOrAlias(), "1").setStoredFields("field1").get());
                .startArray("field1")  
            .add(new MultiGetRequest.Item(indexOrAlias(), "2").version(Versions.MATCH_ANY))  
        String mapping = XContentFactory.jsonBuilder()
        // Number field is stored as Sorted Numeric, so result should be in sorted order  
        assertTrue(getResponse.isExists());  
        // Update translog read preference to source  
        assertThat(response.getIndex(), equalTo("test"));
        String doc = "{\n" + "  \"text\": \"some text.\"\n" + "}\n";
import org.opensearch.action.get.GetRequestBuilder;
        assertThat(response.getResponses()[1].getFailure(), nullValue());
            IllegalArgumentException.class,
            .put("index.refresh_interval", -1)
 * the Apache License, Version 2.0 (the "License"); you may
                sb.append("\nShard failure: ").append(failure);  
            .value(1)
        getResponse = client().prepareGet("test_derive", "1").get();
        Map<String, Object> source = getResponse.getSourceAsMap();
        }
        return randomBoolean() ? "test" : "alias";
            prepareCreate("test_derive").setSettings(
        source = getResponse.getSourceAsMap();  
                            }  
import org.opensearch.action.update.UpdateResponse;
        assertThat(response.getResponses().length, equalTo(3));
                            "bool_field": {  
                        .startObject("field3")
    }  
        }
        assertAcked(  
            .add(new MultiGetRequest.Item(indexOrAlias(), "1").version(Versions.MATCH_ANY))
                        .endObject()  
        for (String field : fields) {
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value" + i).get();  
        assertThat(response.getIndex(), equalTo("test"));
            client().admin().indices().prepareCreate("index3").addAlias(new Alias("alias1").indexRouting("1").writeIndex(true)).get();
        );
        assertThat(response.getResponses().length, equalTo(5));
            + "    \"index.translog.flush_threshold_size\": \"1pb\",\n"
            .startObject()
        } catch (VersionConflictEngineException e) {
        assertThat(response.getIndex(), equalTo("test"));  
        assertThat(response.getIndex(), equalTo("test"));
        logger.info("--> realtime fetch of field");  
        assertThat(response.getResponses().length, equalTo(1));
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setSource(createIndexSource, MediaTypeRegistry.JSON));  
            .startObject("level2")  
 * specific language governing permissions and limitations
        BytesReference source = BytesReference.bytes(
    }
    }  
        assertNotNull("Derived source should not be null", source);  
            .value("1.2.3.4")  
        // before refresh - document is only in translog
        assertThat(response.isExists(), equalTo(false));
            + "  }\n"
import org.opensearch.common.Nullable;  
        assertThat(getResponse.isExists(), equalTo(true));
        client().prepareIndex("test").setId("1").setSource("field1", "value1_2", "field2", "value2_2").get();
import static org.hamcrest.Matchers.nullValue;
        assertThat(response.getResponses().length, equalTo(3));  
        assertNotNull(source);
        fields = new HashSet<>(response.getFields().keySet());
        logger.info("checking real time retrieval");  
        assertThat(response.getFields().get("field").getValues().get(1).toString(), equalTo("2"));
        }  
        assertThat(response.getResponses()[0].getResponse().isExists(), equalTo(true));
        // From translog:
        response = client().prepareGet(indexOrAlias(), "1").setVersion(Versions.MATCH_ANY).get();  
        client().prepareIndex("test").setId("1").setSource("field1", "value1_1", "field2", "value2_1").get();  
            .get();  
            + "  \"suggest\": {\n"  
        client().prepareIndex("test").setId("1").setRouting("routingValue").setId("1").setSource("{}", MediaTypeRegistry.JSON).get();  
        assertThat(response.getSourceAsBytes(), nullValue());
        assertGetFieldsAlwaysWorks(index, type, docId, fields, null);
                    .field("keyword_field", "test_keyword")  
        // Version from Lucene index  
        // Test get with field exclusion
        response = client().prepareGet(indexOrAlias(), "1").setVersion(Versions.MATCH_ANY).get();
        assertThat(getResponse.getField(field).getValues().get(1).toString(), equalTo("value2"));
        // Version from Lucene index
        assertThat(response.getId(), equalTo("1"));
        assertGetFieldsAlwaysNull(index, type, docId, fields, null);  
                        .field("type", "object")
            + "\""
                        .startObject("properties")  
            .add(indexOrAlias(), "9")
        assertThat(response.getField("field2"), nullValue());  
        logger.info("--> realtime fetch of field & source (loaded from index)");  
            {
        // Get document after setting update for fetching original source  
        assertThat(response.getSourceAsMap().get("field2").toString(), equalTo("value2"));
            + "        }"  
            + "}";
        logger.info("--> realtime get 1");
                        .startObject("field2")
        assertEquals("test text", source.get("text_field"));  
        GetResponse response = client().prepareGet(indexOrAlias(), "1").get();
    static String indexOrAlias() {
                                "type": "geo_point"
        assertTrue(getResponse.isExists());
                    }
                    .put("index.number_of_replicas", 0)
            .endObject()
            IllegalArgumentException.class,  
        // Version from translog
        assertThat(response.getResponses()[2].getId(), equalTo("2"));
        assertEquals(123, source.get("numeric_field"));  
            .endArray()
        GetResponse getResponse = client().prepareGet("my-index", "1").setStoredFields(field).get();  
        response = client().prepareGet(indexOrAlias(), "1").setStoredFields("field1").setFetchSource("field1", null).get();  
        assertThat(response.isExists(), equalTo(false));
            .startObject()
        assertTrue(getResponse.isExists());
import static org.hamcrest.Matchers.hasKey;
            .setId("1")
    public void testDerivedSourceTranslogReadPreference() throws Exception {  
        refresh();
                            },
        assertThat(response.getIndex(), equalTo("test"));  
        geopoint = (Map<String, Object>) source.get("geopoint_field");
    public void testGetWithVersion() {  
        assertThat(response.getResponses()[0].getResponse().getIndex(), equalTo("test"));
            // all good
        assertNull(response.getField(field));  
            client().prepareGet(indexOrAlias(), "1").setVersion(1).setRealtime(false).get();
        logger.info("--> realtime fetch of field & source");
        } catch (VersionConflictEngineException e) {
        refresh();  
        );
            + "    \"index.translog.flush_threshold_size\": \"1pb\",\n"
        assertThat(getResponse.isExists(), equalTo(true));
            + "    \"refresh_interval\": \"-1\"\n"  
            + "    \"input\": [\n"
        assertEquals("2023-01-01T00:00:00.000Z", source.get("date_field"));
                                "type": "ip"
            .endArray()  
                        "number_of_replicas": 0,
        assertThat(response.getResponses()[0].getResponse().getSourceAsMap().get("field").toString(), equalTo("value2"));
            .startObject("field")
        assertThat(response.getResponses()[0].getIndex(), equalTo("test"));  
                .indices()  
        assertEquals("test_keyword", source.get("keyword_field"));  
        logger.info("--> index doc 1");
                        .field("type", "object")
        assertThat(response.isExists(), equalTo(true));
        assertThat(response.getResponses()[2].getFailure(), notNullValue());
        IndexResponse indexResponse = client().prepareIndex("test_derive").setId("1").setSource(sourceBuilder).get();
        String mapping1 = XContentFactory.jsonBuilder()
    }
        assertEquals(51.5074, (double) geopoint.get("lat"), 0.0001);
            client().admin()
        assertThat(response.getResponses()[3].getResponse().getIndex(), equalTo("test"));
        assertThat(response.getIndex(), equalTo("test"));
            .endObject()
        // Ip field is stored as Sorted Set, so duplicates should be removed and result should be in sorted order
        assertThat(response.getSourceAsMap().get("field2").toString(), equalTo("value2"));
        String storedString = stored ? "true" : "false";
        logger.info("--> non realtime get 1");
        assertThat(response.getSourceAsMap().get("field1").toString(), equalTo("value1_1"));  
        assertThat(response.getResponses()[2].getFailure(), nullValue());
    }
        assertThat(response.isExists(), equalTo(true));
        assertThat(getResponse.getField(field).getValues().get(0).toString(), equalTo("value1"));  
        assertThat(numValues.size(), equalTo(3));
        assertThat(response.getResponses()[0].getIndex(), equalTo("test"));  
        // Get updated document, this will be derived source as per translog read preference setting
import static org.hamcrest.Matchers.not;  
        assertThat(response.getResponses()[0].getResponse().isExists(), equalTo(true));  
        assertEquals(RestStatus.OK, updateResponse.status());  
            + "          \"type\": \"text\",\n"
                            },
            .put(IndexSettings.INDEX_DERIVED_SOURCE_TRANSLOG_ENABLED_SETTING.getKey(), true);
        String createIndexSource = "{\n"
                .endObject()  
            StringBuilder sb = new StringBuilder("failed to flush at least one shard. total shards [").append(
    public void testUngeneratedFieldsThatAreNeverStored() throws IOException {
        assertThat(response.getSourceAsMap().get("field2").toString(), equalTo("value2"));
                        .startObject("field1")
        // after flush - document is in not anymore translog - only indexed
    }
            .endObject()
            + "}";  
    public void testGeneratedStringFieldsUnstored() throws IOException {  
            + "        \"text1\": {\n"
                        .field("type", "text")
 * Unless required by applicable law or agreed to in writing,
        source = getResponse.getSourceAsMap();
 * Modifications Copyright OpenSearch Contributors. See
 */
        logger.info("--> non realtime get 1 (loaded from index)");  
        assertThat(response.getSourceAsMap().get("field1").toString(), equalTo("value1"));  
            prepareCreate("test").addAlias(new Alias("alias").writeIndex(randomFrom(true, false, null)))
        MultiGetResponse response = client().prepareMultiGet().add(indexOrAlias(), "1").get();  
                    .field("numeric_field", 123)
            .value(1)
        Map<String, Object> source = getResponse.getSourceAsMap();  
            .startObject("geopoint_field")  
        Settings.Builder settings = Settings.builder()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            + "      }\n"
        assertEquals(123, source.get("numeric_field"));
        return getRequestBuilder.get();  
        ensureGreen();
        String[] fieldsList = { "_routing" };
        response = client().prepareGet(indexOrAlias(), "1").setVersion(Versions.MATCH_ANY).setRealtime(false).get();
        assertThat(indexResponse.status().getStatus(), equalTo(RestStatus.CREATED.getStatus()));
            .add(indexOrAlias(), "11")
        response = client().prepareGet(indexOrAlias(), "1").setStoredFields(Strings.EMPTY_ARRAY).get();
                            },
    }
        assertThat(response.isExists(), equalTo(true));  
                        .endObject()
        try {  
        assertThat(response.getResponses()[2].getIndex(), equalTo("test"));
    }
        for (int i = 0; i < 3; i++) {  
        }
            .startArray("level1")  
        // same for multi get
            + "},"
            + "  \"mappings\": {\n"
            .endObject()
public class GetActionIT extends OpenSearchIntegTestCase {
            .value("1.2.3.4")
        assertEquals(true, source.get("bool_field"));
            .field("type", "ip")
                        "derived_source": {  
 *
        assertThat(response.getSourceAsMap().get("field1").toString(), equalTo("value1"));
        assertThat(response.getResponses()[0].getResponse().getSourceAsBytes(), nullValue());  
            + "      \"properties\": {\n"
 * KIND, either express or implied.  See the License for the
        assertThat(response.getField("field1").getValues().get(0).toString(), equalTo("value1"));  
        source = getResponse.getSourceAsMap();
        assertGetFieldsAlwaysWorks(indexOrAlias(), "_doc", "1", fieldsList, "routingValue");
        assertAcked(  
        assertThat(response.isExists(), equalTo(true));  
import static org.hamcrest.Matchers.startsWith;  
        GetResponse response = client().prepareGet("test", "1").get();  
            + "    \"_doc\": {\n"  
                .startObject()
    }
        assertThat(getResponse.getField(field).getValues().size(), equalTo(2));
        assertThat(response.getResponses()[1].getId(), equalTo("1"));  
                        },
        response = client().prepareGet(indexOrAlias(), "1").setStoredFields("field1").get();
        GetResponse getResponse = client().prepareGet("test", "1").get();
        assertThat(response.getResponses()[2].getResponse().getSourceAsMap().get("field").toString(), equalTo("value2"));
    }  
        assertThat(response.getResponses().length, equalTo(1));
        for (int i = 0; i < 10; i++) {
        assertThat(response.getId(), equalTo("1"));
        assertThat(response.getIndex(), equalTo("test"));  
import org.opensearch.test.OpenSearchIntegTestCase;  
            + "  \"settings\": {\n"  
                Settings.builder()
        refresh();
            .add(new MultiGetRequest.Item(indexOrAlias(), "1").version(1))
        String[] fieldsList = { "_field_names" };
import java.io.IOException;
        GetResponse getResponse = client().prepareGet("test_derive", "1").get();
            for (DefaultShardOperationFailedException failure : flushResponse.getShardFailures()) {
        assertThat(response.isExists(), equalTo(true));
                            "numeric_field": {  
                        .startObject("properties")  
        getResponse = client().prepareGet("my-index", "1").setStoredFields(field).get();  
            client().prepareGet(indexOrAlias(), "1").setVersion(2).setRealtime(false).get();  
        client().prepareIndex("test")  
        assertThat(response.getResponses()[1].getIndex(), equalTo("test"));
        // Test numeric field retrieval  
        );  
            fail();
        assertThat(response.getId(), equalTo(docId));
        assertEquals("2025-07-29T00:00:00.000Z", source.get("date_field"));  
        assertThat(response.getSourceAsBytes(), nullValue());
        assertThat(response.getResponses()[0].getFailure(), nullValue());
        assertThat(response.getId(), equalTo(docId));  
        client().prepareIndex("test").setId("1").setSource("field1", "value1", "field2", "value2").get();  
            // all good  
                            "geopoint_field": {  
            .endObject()  
            .startObject("properties")
            .endArray()  
        assertThat(response.getIndex(), equalTo("test"));  
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value" + i).get();
        for (int i = 0; i < 3; i++) {
        flushAndRefresh("test");  
                    }
        assertThat(response.getVersion(), equalTo(1L));  
            .setDoc(jsonBuilder().startObject().field("geopoint_field", "51.5074,-0.1278").field("date_field", "2025-07-30").endObject())
            + "}";
        assertThat(response.getSourceAsMap(), not(hasKey("field2")));
        // Create source document
        ensureGreen();
            .setRealtime(false)
        assertThat(response.getResponses().length, equalTo(2));
                .endObject()
            .field("store", true)
            prepareCreate("test").setMapping("field1", "type=keyword,store=true", "field2", "type=keyword,store=true")
    public void testDerivedSourceSimple() throws IOException {
        assertNotNull(source);
        refresh();  
 * GitHub history for details.
            .get();
 * You may obtain a copy of the License at  
        assertThat(response.getResponses()[1].getResponse().isExists(), equalTo(true));
                .endArray()
        MultiGetResponse response = client().prepareMultiGet().add(indexOrAlias(), "1").get();
        assertThat(response.isExists(), equalTo(false));  
        indexSingleDocumentWithStringFieldsGeneratedFromText(true, randomBoolean());
        String[] alwaysNotStoredFieldsList = { "_field_names" };
        assertGetFieldsAlwaysWorks(indexOrAlias(), "_doc", "1", fieldsList);
                    .field("geopoint_field", Geohash.stringEncode(40.33, 75.98))
            .startObject()
        getResponse = client().prepareGet("my-index", "1").setStoredFields(field).get();
            .setSource(  
                        .endObject()  
        MultiGetResponse multiGetResponse = multiGetRequestBuilder.get();
        flush();
        assertThat(fields, equalTo(singleton("field")));  
        // after flush - document is in not anymore translog - only indexed
                jsonBuilder().startObject().field("geopoint_field", "40.7128,-74.0060").field("date_field", "2025-07-29").endObject()
        assertThat(getResponse.isExists(), equalTo(true));
        assertThat(response.getIndex(), equalTo("test"));
        assertThat(response.getFields().get("field").getValues().get(1).toString(), equalTo("2"));  
        refresh();
            .startObject()
        refresh();
            + "  \"mappings\": {\n"
        // after flush - document is in not anymore translog - only indexed  
                .startObject()
    }  
        assertAcked(
        assertThat(response.isExists(), equalTo(true));
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertThat(response.isExists(), equalTo(true));
            .endObject()  
                .setMapping(
        assertThat(response.getId(), equalTo("1"));
        assertTrue(getResponse.isExists());  
                .setSettings(Settings.builder().put("index.refresh_interval", -1))  
    public void testGetFieldsNonLeafField() throws Exception {
                                "type": "boolean"
        assertThat(response.getId(), equalTo("1"));
                        .startObject("properties")  
        assertGetFieldsAlwaysWorks(indexOrAlias(), "_doc", "1", fieldsList, "1");  
        assertThat(response.getResponses()[3].getIndex(), equalTo("test"));  
        response = client().prepareGet(indexOrAlias(), "1").get();  
        assertGetFieldsNull(indexOrAlias(), "_doc", "1", alwaysNotStoredFieldsList);
        XContentBuilder sourceBuilder = jsonBuilder().startObject()
        logger.info("--> realtime get 1");  
            .endObject()
        assertThat(response.getResponses()[0].getResponse().getSourceAsMap().get("field").toString(), equalTo("value2"));
            .endObject()
        assertFalse(source.containsKey("binary_field"));
                        .endObject()
        assertThat(ipValues.size(), equalTo(2));
 *  
        // From Lucene index:
            .add(new MultiGetRequest.Item(indexOrAlias(), "2").version(Versions.MATCH_ANY))  
        assertThat(response.getSourceAsMap().get("field2").toString(), equalTo("value2_1"));
        );
                .get();
            + "        \"suggest\": {\n"
        );
        assertThat(response.getVersion(), equalTo(1L));  
import java.util.Map;
        assertThat(response.getField("field1").getValues().get(0).toString(), equalTo("value1"));
            )
            .add(indexOrAlias(), "1")
        // Get document after flush, it should be a derived source
    }  
import java.util.Collections;
                .setSettings(Settings.builder().put("index.refresh_interval", -1))  
        response = client().prepareGet(indexOrAlias(), "1").get();
        response = client().prepareGet(indexOrAlias(), "1").setRealtime(false).get();
        assertEquals(51.5074, (double) geopoint.get("lat"), 0.0001);
        assertGetFieldsAlwaysWorks(indexOrAlias(), "_doc", "1", fieldsList, "routingValue");
            .startObject("level1")
        assertThat(response.getId(), equalTo(docId));
            + "    }\n"
        assertGetFieldsAlwaysNull(indexOrAlias(), "_doc", "1", fieldsList);
        // Index a document with various field types  
import org.opensearch.common.settings.Settings;
            + "        \"text2\": {\n"
        // Version from translog
        // [0] version doesn't matter, which is the default  
        getResponse = client().prepareGet("test_derive", "1").get();
        geopoint = (Map<String, Object>) source.get("geopoint_field");
        assertTrue(getResponse.isExists());
                    .field("bool_field", true)  
            .startObject("properties")
        response = client().prepareGet("test", "1").setStoredFields("field").get();
            .add(new MultiGetRequest.Item(indexOrAlias(), "1").version(2))  
                        "number_of_shards": 2,
        GetResponse response = getDocument(index, type, docId, field, routing);  
        assertAcked(prepareCreate("test").setSettings(settings).setMapping(mapping));
        assertGetFieldsAlwaysWorks(indexOrAlias(), "_doc", "1", fieldsList, "1");  
        // Create index with settings and mapping
        assertThat(response.getVersion(), equalTo(1L));  
        try {
        }
    public void testGeneratedStringFieldsStored() throws IOException {
        response = client().prepareGet(indexOrAlias(), "1").setRealtime(false).get();  
            .setId("1")
    public void testSimpleGet() {  
    @Override
        assertEquals(-74.0060, (double) geopoint.get("lon"), 0.0001);
                    .field("binary_field", "bGlkaHQtd29rfx4=")  
        assertTrue(getResponse.isExists());
        assertThat(response.isExists(), equalTo(true));
                        .endObject()
        fields = new HashSet<>(response.getFields().keySet());
                .field("field4", "value2")
        assertGetFieldsAlwaysWorks(indexOrAlias(), "_doc", "1", fieldsList, "routingValue");
import org.opensearch.core.common.Strings;
        logger.info("--> index doc 1");
        assertThat(response.getVersion(), equalTo(2L));
        assertThat(response.getResponses()[2].getResponse().getSourceAsMap().get("field").toString(), equalTo("value2"));
import static java.util.Collections.singleton;
        assertThat(response.getResponses()[2].getFailure(), notNullValue());
        client().prepareIndex("test").setId("1").setSource("field1", "value1", "field2", "value2").get();
        assertNotNull("Derived source should not be null", source);
        assertEquals(40.33, (Double) latLon.get("lon"), 0.001);
        assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
        Map<String, Object> level1 = (Map<String, Object>) source.get("level1");
        assertThat(response.getResponses()[1].getFailure(), notNullValue());
        assertThat(response.getFields().get("field").getValues().size(), equalTo(2));
        assertThat(response.getIndex(), equalTo("test"));
        assertThat(response.getResponses()[2].getResponse().isExists(), equalTo(true));
                        .startObject("properties")  
    }  
}
            assertGetFieldNull(index, type, docId, field, routing);
        assertThat(response.getResponses()[1].getIndex(), equalTo("test"));
        ensureGreen();
                "settings": {
        } catch (VersionConflictEngineException e) {  
            .startObject("properties")  
                .setMapping(
    }
 * under the License.  
        ensureGreen();
        IndexResponse indexResponse = client().prepareIndex("index1").setId("id").setSource(Collections.singletonMap("foo", "bar")).get();  
            .add(new MultiGetRequest.Item(indexOrAlias(), "2").version(2))
        assertGetFieldsNull(index, type, docId, fields, null);
import org.opensearch.action.index.IndexResponse;
        IllegalArgumentException exc = expectThrows(
            getItem.routing(routing);
                .startObject("field2")
        // Create index with derived source index setting enabled
        assertThat(getResponse.getField(field).getValues().get(0).toString(), equalTo("value1"));
        assertThat(response.getResponses()[2].getFailure(), nullValue());  
        assertThat(response.getField("field1").getValues().get(0).toString(), equalTo("value1"));
            .add(new MultiGetRequest.Item(indexOrAlias(), "3").storedFields("field"))
        assertTrue(response.isExists());
                }  
            + "          \"store\": \""  
    public void testUngeneratedFieldsThatAreAlwaysStored() throws IOException {
            .endObject()
        assertThat(response.getField("field1").getValues().get(0).toString(), equalTo("value1"));
        }
            + "    \"refresh_interval\": \"-1\"\n"
        assertNotNull(source);  
        assertThat(response.isExists(), equalTo(false));
                    .field("text_field", "test text")
        }  
            + "      \"properties\": {\n"  
        assertThat(response.getResponses()[1].getFailure().getId(), equalTo("2"));  
        assertThat(response.getResponses()[1].getFailure().getMessage(), startsWith("[2]: version conflict"));
        Map<String, Object> level2 = (Map<String, Object>) level1.get("level2");
            .field("type", "date")
            .startObject()
            + "        },\n"  
                )
            + "  }\n"
    private void assertGetFieldsAlwaysWorks(String index, String type, String docId, String[] fields) {  
    }
            .add(new MultiGetRequest.Item(indexOrAlias(), "2").version(1))
            + "      \"Nirvana\"\n"  
        // before refresh - document is only in translog
        assertThat(multiGetResponse.getResponses().length, equalTo(1));  
        Map<String, Object> geopoint = (Map<String, Object>) source.get("geopoint_field");  
    protected void assertGetFieldsNull(String index, String type, String docId, String[] fields, @Nullable String routing) {
import org.opensearch.core.rest.RestStatus;
import org.opensearch.core.common.bytes.BytesReference;  
        assertThat(response.getResponses()[2].getId(), equalTo("3"));
                    .put("index.derived_source.enabled", true)
                .setSettings(Settings.builder().put(IndexSettings.INDEX_DERIVED_SOURCE_TRANSLOG_ENABLED_SETTING.getKey(), false))
        response = client().prepareGet(indexOrAlias(), "1").get();  
        );
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(response.getField("field2"), nullValue());
        assertFalse(source.containsKey("text_field"));  
            .get();
        assertThat(response.getResponses()[4].getResponse().getIndex(), equalTo("test"));
        // Test get with selective field inclusion
        logger.info("indexing documents");
        assertThat(response.getVersion(), equalTo(2L));
        assertThat(response.getSourceAsBytes(), not(nullValue()));
        assertThat(response.getFields().get("field").getValues().get(0).toString(), equalTo("1"));
                        .endObject()  
        );
            + "    \"refresh_interval\": \"-1\"\n"  
        assertThat(response.isExists(), equalTo(false));
        assertThat(response.isExists(), equalTo(false));
    protected void assertGetFieldsAlwaysNull(String index, String type, String docId, String[] fields, @Nullable String routing) {  
                            },
import org.opensearch.common.lucene.uid.Versions;
            .add(new MultiGetRequest.Item(indexOrAlias(), "1").version(2))  
 * software distributed under the License is distributed on an
        // after refresh - document is in translog and also indexed
import org.opensearch.common.xcontent.XContentFactory;  
        refresh();
        response = client().prepareGet(indexOrAlias(), "1").setFetchSource(false).get();
        IndexResponse indexResponse = client().prepareIndex("test")
    }
        // From translog:  
        assertThat(indexResponse.status(), equalTo(RestStatus.CREATED));
                                "type": "date"
 * not use this file except in compliance with the License.
        assertThat(response.isExists(), equalTo(true));  
            .endObject()
                        "properties": {
import org.opensearch.index.engine.VersionConflictEngineException;  
    }  
        assertThat(response.getResponses()[2].getId(), equalTo("2"));  
        assertThat(response.getResponses()[1].getResponse().getIndex(), equalTo("test"));  
        logger.info("flushing");
                                "type": "text"
        assertThat(response.getResponses()[0].getResponse().isExists(), equalTo(false));
                        .endObject()  
    public void testGetFieldsComplexField() throws Exception {
        // after refresh - document is in translog and also indexed  
            .field("type", "geo_point")
        List<Object> numValues = (List<Object>) level3.get("num_field");
            .startObject("level2")
        for (String field : fields) {
        validateDeriveSource(source);
            .endObject()
        // after flush - document is in not anymore translog - only indexed
            + storedString
                )
            fail(sb.toString());
            .endArray()  
                .endArray()
        assertThat(response.getResponses()[2].getResponse().isExists(), equalTo(true));
    }  
        getResponse = client().prepareGet("test", "1").get();
        logger.info("--> index doc 1 again, so increasing the version");  
    private void assertGetFieldsAlwaysWorks(String index, String type, String docId, String[] fields, @Nullable String routing) {
        MultiGetRequestBuilder multiGetRequestBuilder = client().prepareMultiGet().add(getItem);
        // before refresh - document is only in translog  
            .endObject()
            .add(new MultiGetRequest.Item(indexOrAlias(), "1").version(1))
    }
        UpdateResponse updateResponse = client().prepareUpdate("test", "1")  
        flush();
        assertThat(response.getResponses()[2].getFailure().getId(), equalTo("1"));  
            .startObject("ip_field")
            .startObject("level3")
        assertThat(response.getResponses()[0].getResponse().getSourceAsMap().get("field").toString(), equalTo("value1"));  
                            "binary_field": {  
        assertThat(response.getId(), equalTo("1"));  
            + "    \"refresh_interval\": \"-1\"\n"
        // after refresh - document is in translog and also indexed
        return multiGetResponse.getResponses()[0].getResponse();
        index("test", "_doc", "1", doc);  
        response = client().prepareMultiGet()
        index("test", "_doc", "1", doc);
import java.util.List;  
            assertGetFieldWorks(index, type, docId, field, routing);  
            .get();
                        .field("type", "text")
            + "          \"type\": \"completion\"\n"  
        assertThat(getResponse.getField(field).getValues().size(), equalTo(2));  
        if (flushResponse.getSuccessfulShards() == 0) {
            .endArray()
            .startObject()
/*  
        assertEquals(RestStatus.CREATED, indexResponse.status());
            .startObject("properties")
        assertGetFieldsAlwaysNull(indexOrAlias(), "_doc", "1", fieldsList);
        assertThat(response.getResponses()[0].getResponse().isExists(), equalTo(true));
        // after refresh - document is in translog and also indexed  
            .get();
        }
        assertThat(response.getResponses()[4].getIndex(), equalTo("test"));
            }
            getRequestBuilder.setRouting(routing);
                    "index": {  
                    .put("index.number_of_shards", 1)  
        // Index the document  
        assertThat(response.getResponses()[3].getId(), equalTo("9"));
        if (routing != null) {  
        assertThat(response.getResponses()[2].getResponse().isExists(), equalTo(true));  
            .endObject()
        assertThat(response.getIndex(), equalTo("test"));
        assertAcked(
    protected void assertGetFieldsAlwaysNull(String index, String type, String docId, String[] fields) {
        client().prepareIndex("test_derive")
        assertEquals("2025-07-30T00:00:00.000Z", source.get("date_field"));
        getResponse = client().prepareGet("test_derive", "1").setFetchSource(null, new String[] { "text_field", "date_field" }).get();
        flush();  
import org.opensearch.action.get.MultiGetRequestBuilder;
        assertGetFieldsAlwaysNull(indexOrAlias(), "_doc", "1", fieldsList);
        source = getResponse.getSourceAsMap();
        } else {  
        assertTrue(getResponse.isExists());  
            client().admin()
            ).setMapping(mapping)  
            + storedString
        );
                        .endObject()
        );  
        assertThat(ipValues, containsInRelativeOrder("1.2.3.4", "2.3.4.5"));  
            + "}";
        assertThat(response.getFields().get("field").getValues().get(0).toString(), equalTo("1"));  
        assertThat(response.getResponses()[0].getFailure(), nullValue());
        assertThat(response.getIndex(), equalTo("test"));
        assertThat(response.getId(), equalTo("1"));
        assertThat(response.getIndex(), equalTo("test"));  
        assertThat(response.isExists(), equalTo(true));  
        String createIndexSource = "{\n"
import org.opensearch.action.admin.indices.flush.FlushResponse;  
                            },
            assertGetFieldNull(index, type, docId, field, routing);
                                "store": true
        assertThat(response.isExists(), equalTo(true));
        // after flush - document is in not anymore translog - only indexed  
        logger.info("checking post-flush retrieval");
        IllegalArgumentException exception = expectThrows(  
        assertThat(response.getResponses()[0].getResponse().getField("field").getValues().get(0).toString(), equalTo("value1"));
        // Update document, so that version map gets created and get will be served from translog
        logger.info("--> update doc 1");
import org.opensearch.plugins.Plugin;
        DeleteResponse deleteResponse = client().prepareDelete("test", "1").get();  
            fail();
        assertThat(response.getField("field2"), nullValue());  
        String doc = "{\n" + "  \"text1\": \"some text.\"\n," + "  \"text2\": \"more text.\"\n" + "}\n";
        getResponse = client().prepareGet("test_derive", "1").setFetchSource(new String[] { "keyword_field", "numeric_field" }, null).get();
        assertThat(response.getResponses()[0].getResponse().isExists(), equalTo(false));  
        assertThat(response.getResponses()[0].getId(), equalTo("1"));
        // [0] version doesn't matter, which is the default
    }  
                "mappings": {  
        response = client().prepareGet(indexOrAlias(), "1").setVersion(1).setRealtime(false).get();
        assertEquals(40.7128, (double) geopoint.get("lat"), 0.0001);
                .startObject("field2")
        response = client().prepareMultiGet()  
            .endObject();
        Map<String, Object> source = getResponse.getSourceAsMap();
        ensureGreen();
        response = client().prepareGet(indexOrAlias(), "1").setVersion(2).setRealtime(false).get();
 * this file be licensed under the Apache-2.0 license or a
        }
        assertTrue(getResponse.isExists());
/*  
                // multi types in 5.6
            .startObject("level2")  
                            "keyword_field": {  
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
            .endObject()
        response = client().prepareGet("test", "1").setStoredFields("field").get();  
        assertThat(response.getResponses()[0].getFailure(), nullValue());
        // Create mapping with properly closed objects  
        assertThat(response.getVersion(), equalTo(1L));
            () -> client().prepareGet("alias1", "_alias_id").get()
                        .startObject("field4")
                flushResponse.getTotalShards()  
        // multi get with specific field
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setSource(createIndexSource, MediaTypeRegistry.JSON));  
        logger.info("--> realtime get 1 (no type)");
        ensureGreen();
    protected void assertGetFieldsNull(String index, String type, String docId, String[] fields) {
            // all good
        assertThat(response.getResponses()[2].getFailure().getMessage(), startsWith("[1]: version conflict"));
        assertGetFieldsNull(indexOrAlias(), "_doc", "1", alwaysNotStoredFieldsList);  
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setSource(createIndexSource, MediaTypeRegistry.JSON));  
        // for get
        assertThat(response.getResponses()[0].getResponse().getSourceAsMap().get("field").toString(), equalTo("value1"));
import static org.hamcrest.Matchers.containsInRelativeOrder;
            .startArray("level3")  
            + sourceEnabled
        assertThat(response.getIndex(), equalTo("test"));
        GetResponse response = client().prepareGet("test", "1").get();
            + "}";
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setSettings(Settings.builder().put("index.refresh_interval", -1)));
        assertEquals(75.98, (Double) latLon.get("lat"), 0.001);  
        }
        assertThat(response.getResponses()[1].getFailure(), nullValue());
            .startArray("num_field")
        assertEquals("1.2.3.4", source.get("ip_field"));
        String doc = "{\n"
        assertThat(response.getIndex(), equalTo("test"));
        }  
                        .field("store", true)  
        assertThat(response.getResponses()[1].getResponse().getSourceAsMap().get("field").toString(), equalTo("value1"));  
        assertThat(response.getVersion(), equalTo(2L));  
                            "enabled": true
    private GetResponse getDocument(String index, String type, String docId, String field, @Nullable String routing) {
        assertThat(response.getResponses()[4].getId(), equalTo("11"));  
        response = client().prepareMultiGet()  
            .startObject("properties")  
        flush();
        assertThat(response.getResponses()[1].getId(), equalTo("15"));
    }
import java.util.Collection;  
            ).append("], failed shards: [").append(flushResponse.getFailedShards()).append("]");
        flush();
        assertThat(fields, equalTo(singleton("field")));
            .add(new MultiGetRequest.Item(indexOrAlias(), "1").version(Versions.MATCH_ANY))
        logger.info("--> update doc 1 again");  
        assertThat(fields, equalTo(Collections.<String>emptySet()));  
        assertThat(response.getResponses()[1].getIndex(), equalTo("test"));
    private GetResponse multiGetDocument(String index, String type, String docId, String field, @Nullable String routing) {
