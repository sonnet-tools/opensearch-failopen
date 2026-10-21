                return num1.getValue();
        assertThat(searchHit.getFields().get("byte_field").getValue().toString(), equalTo("1"));
            .startObject("float_field")
                .endArray()
            fields,
            .setQuery(matchAllQuery())
    }
            fields,
            .field("path", "text_field")
        fields = new HashSet<>(response.getHits().getAt(0).getFields().keySet());
        SearchRequestBuilder req = client().prepareSearch("index");
            .setQuery(matchAllQuery())
            });
        DocumentField dateFieldAlias = fields.get("date_field_alias");
        index("test", MapperService.SINGLE_MAPPING_NAME, "1", "text_field", "foo", "date_field", formatter.print(date));
        assertThat(response.getHits().getAt(0).getFields().get("sNum1_field").getValues().get(0), equalTo(1.0));
                "sNum1",
            .endObject()
            response.getHits().getAt(2).getFields().get("sNum1").getValues().get(0),
            { "multi_long_field", "long" },
        assertThat(response.getHits().getAt(1).getFields().get("date1").getValues().get(0), equalTo(dateAsMillis));
        assertThat(textFieldAlias.getValue(), equalTo("foo"));
                        "ml",
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).addStoredField("field2").get();
        );
        assertThat(fieldValues, hasSize(1));
        assertThat(searchResponse.getHits().getAt(0).getFields().get("boolean_field").getValue(), equalTo((Object) true));
            .addDocValueField("flat_object_field1.foo");
            assertEquals(fields.get("derived_multi_double_field").getValues().get(0), (double) id);
        assertThat(searchResponse.getHits().getAt(0).getFields().get("field1").getValue().toString(), equalTo("value1"));
                    .field("binary_field", new byte[] { 42, 100 })
        client().prepareIndex("test")
            .setQuery(matchAllQuery())
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
            .setId("3")
            .field("type", "alias")
        indexRandom(true, reqs);
        for (String field : Arrays.asList("s", "ms", "l", "ml", "d", "md")) {
                    .startObject("obj2")
                        new Long[] { date1.getMillis(), date2.getMillis() },
import java.util.HashSet;
    }
            .addDocValueField("binary_field")
            .setSource(jsonBuilder().startObject().field("field1", "value").endObject())
            .setQuery(matchAllQuery())
            .startObject("field2")
                        "md",
        assertThat(fieldValues.get(0), nullValue());
            response.getHits().getAt(2).getFields().get("sNum1_field").getValues().get(0),
        client().admin().indices().prepareFlush().get();
            Map<String, Object> source = (Map) vars.get("_source");
            .addDocValueField("short_field", "use_field_mapping")
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
        assertThat(response.getHits().getAt(0).getFields().get("sNum1_field").getValues().get(0), equalTo(BigInteger.valueOf(1)));
            .setId("1")
            .startObject("short_field")
            );
            return fieldLookup.getValue();
            assertThat(fields.get("ms").getValues(), equalTo(Arrays.<Object>asList(Integer.toString(id), Integer.toString(id + 1))));
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
            .startObject(MapperService.SINGLE_MAPPING_NAME)
            .startObject("properties")
        assertThat(searchResponse.getHits().getAt(0).getFields().get("integer_field").getValue(), equalTo((Object) 3L));
            scripts.put("return null", vars -> null);
        assertThat(searchResponse.getHits().getAt(0).getFields().get("ip_field").getValue(), equalTo("::1"));
                .endArray()
            .setId("1")
            .endObject()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            equalTo(
            .endObject()
            .get();
        fields = new HashSet<>(response.getHits().getAt(0).getFields().keySet());
            .get();
        indexRandomForConcurrentSearch("my-index");
                Map<String, Object> params = (Map<String, Object>) vars.get("params");
        assertNoFailures(searchResponse);
            .field("type", "flat_object")
            .addStoredField("field1-alias")
        indexRandomForConcurrentSearch("test");
        response = client().prepareSearch()
                    .setSource(
        indexRandomForConcurrentSearch("my-index");
                    "date_field",
        ZonedDateTime date = ZonedDateTime.of(2012, 3, 22, 0, 0, 0, 0, ZoneOffset.UTC);
            .addDocValueField("byte_field", "use_field_mapping")
            .endObject()
        fields = new HashSet<>(response.getHits().getAt(0).getFields().keySet());
            .addStoredField("float_field")
            { "multi_ip_field", "ip" },
            .addDocValueField("flat_object_field1.foo", null);
            indexRequestBuilders[i] = client().prepareIndex("test")
                    .endObject()
        assertThat(searchHit.getFields().get("binary_field").getValue(), equalTo(new BytesArray("testing text".getBytes("UTF8"))));
            .endObject()
        assertEquals(1, hit.getFields().size());
            .endObject()
        Map<String, Object> params = MapBuilder.<String, Object>newMapBuilder().put("factor", 2.0).map();
            RestStatus.BAD_REQUEST,
        static Object docScript(Map<String, Object> vars, String fieldName) {
                .setId("1")
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            .addSort("num1", SortOrder.ASC)
        assertThat(response.getHits().getAt(2).getFields().get("sNum1").getValues().get(0), equalTo(3.0));
            scripts.put("doc['multi_keyword_field']", vars -> sourceScript(vars, "multi_keyword_field"));
        DocumentField field = hit.getFields().get("field1-alias");
import static org.hamcrest.Matchers.hasSize;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
import java.util.Arrays;
            equalTo(new BigInteger("9322337203685477580"))
            )
        indexRandom(true, client().prepareIndex("test").setId("1").setSource("test_field", "foobar"));
                    .setSource(
            final int id = Integer.parseInt(hit.getId());
            .toString();
            .endObject()
            .endObject()
    public void testPartialFields() throws Exception {
            scripts.put("doc['num1'].value", vars -> {
                    .field("integer_field", 3)
        SearchRequestBuilder builder = client().prepareSearch()
            .field("type", "text")
            .addScriptField(
        indexRandomForConcurrentSearch("test");
            assertThat(fields.get("ml").getValues(), equalTo(Arrays.<Object>asList((long) id, id + 1L)));
        assertThat(
        assertThat(fields, equalTo(newHashSet("sNum1", "sNum1_field", "date1")));
            .endObject()
import org.opensearch.script.MockScriptPlugin;
        assertThat(
            )
            .field("store", true)
    public void testStoredFieldsWithoutSource() throws Exception {
        createIndex("test");
            .endObject()
            .addScriptField(
            .get();
                "geo_field",
            .field("store", true)
            .addDocValueField("long_field")
            { "keyword_field", "keyword" },
                .startObject()
        assertThat(searchResponse.getHits().getAt(0).getFields().get("field1").getValue().toString(), equalTo("value1"));
        }
        assertThat(response.getHits().getAt(1).getFields().get("date2").getValues().get(0), equalTo(dateAsNanos));
            .endObject()
            searchResponse.getHits().getAt(0).getFields().get("date_field").getValue(),
            )
                    "integer_field",
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
                        "multi_date_field",
            .startObject("date")
        assertThat(searchResponse.getHits().getAt(0).getSourceAsMap(), nullValue());
                )
                    .field("double_field", 6.0d)
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
            .startObject("date_field")
        DocumentField dateField = fields.get("date_field");
            scripts.put("doc['multi_geo_field']", vars -> sourceScript(vars, "multi_geo_field"));
            { "double_field", "double" },
            .endObject()
        client().admin().indices().preparePutMapping().setSource(mapping, MediaTypeRegistry.JSON).get();
            assertEquals(fields.get("derived_boolean_field").getValues().get(0), true);
            .endObject()
            .startObject("_source")
            .startObject("properties")
                "boolean_field",
        );
                    .startObject()
            equalTo(
                "s_obj1_test",
                .startObject("field2")
        assertThat(searchResponse.getHits().getAt(0).getFields().get("short_field").getValue().toString(), equalTo("2"));
            .endObject()
            .startObject()
                "type=long",
        org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        assertThat(searchResponse.getHits().getAt(0).getFields().get("byte_field").getValue().toString(), equalTo("1"));
                    .startObject("obj2")
            .addDocValueField("text_field")
            .setId("3")
        long dateAsNanos = DateUtils.toLong(instant);
            assertEquals(fields.get("derived_multi_geo_field").getValues().get(0), new GeoPoint(12.0, 10.0));
            .setSource(
        assertThat(searchResponse.getHits().getAt(0).getFields().get("long_field").getValue(), equalTo((Object) 4L));
            .endObject()
        client().admin().indices().preparePutMapping().setSource(mapping, MediaTypeRegistry.JSON).get();
                    .setId(Integer.toString(i))
 * license agreements. See the NOTICE file distributed with
    @ParametersFactory
                    .field("field2", "value22")
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            scripts.put("doc['ip_field']", vars -> sourceScript(vars, "ip_field"));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                        "keyword_field",
            Map<?, ?> fields = (Map) vars.get("_fields");
                    .endArray()
        assertThat(searchResponse.getHits().getAt(0).getFields().get("keyword_field").getValue(), equalTo("foo"));
            assertEquals(fields.get("derived_multi_keyword_field").getValues().get(0), Integer.toString(id));
                "type=ip",
            .startObject("text_field_alias")
                        "d",
            .startObject()
                .endObject()
            .addSort("unsigned_num1", SortOrder.ASC)
        assertThat(
            .field("type", "boolean")
            .startObject("properties")
            .addDocValueField("date_field");
        assertThat(searchResponse.getHits().getAt(0).getFields().get("integer_field").getValue(), equalTo("3.0"));
                    .endObject()
                "type=long",
            scripts.put("_source.arr3", vars -> sourceScript(vars, "arr3"));
                    )
        assertThat(response.getHits().getAt(1).getFields().get("sNum1").getValues().get(0), equalTo(BigInteger.valueOf(4)));
            .endObject()
            .endObject()
            return XContentMapValues.extractValue(path, source);
                        "multi_keyword_field",
        indexRandomForConcurrentSearch("test");
                    "boolean_field",
    public void testSearchFieldsMetadata() throws Exception {
        assertThat(searchResponse.getHits().getAt(0).getFields().size(), equalTo(2));
                    .field("store", true)
            .field("store", true)
    public void testScriptFields() throws Exception {
        }
                    .startObject("properties")
    public void testWildcardStoredFieldsWithFieldAlias() throws Exception {
            scripts.put("doc['multi_long_field']", vars -> sourceScript(vars, "multi_long_field"));
        assertThat(searchResponse.getHits().getAt(0).getFields().get("field3").getValue().toString(), equalTo("value3"));
            req.addScriptField(
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
    public void testScriptFieldsForNullReturn() throws Exception {
            .addDocValueField("byte_field")
        assertThat(searchResponse.getHits().getAt(0).getFields().get("double_field").getValue(), equalTo("6.0"));
            .addScriptField(
                "ms",
    // see #8203
        );
            .setQuery(matchAllQuery())
                "type=boolean",
import org.opensearch.action.search.SearchResponse;
    }
            scripts.put("doc['date'].date.nanos", vars -> {
        assertThat(searchHit.getFields().get("integer_field").getValue(), equalTo((Object) 3));
                        (long) i,
            .startObject("text_field")
            .get();
            .field("type", "double")
                    .field("boolean_field", true)
        client().admin()
            .setSource(
            .endObject()
            .addDocValueField("integer_field", "#.0")
            .endObject()
                        "long_field",
import org.opensearch.plugins.Plugin;
        assertHitCount(searchResponse, 1);
            .field("type", "integer")
        assertSearchResponse(resp);
                    .endObject()
                newHashSet(
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).addStoredField("*3").get();
        assertThat(searchResponse.getHits().getAt(0).getFields().get("field3").getValue().toString(), equalTo("value3"));
        assertThat(dateField.getValue(), equalTo("1990-12-29"));
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
            .endObject()
        assertFalse(response.getHits().getAt(0).hasSource());
        @Override
                        i,
            scripts.put("doc['multi_date_field']", vars -> sourceScript(vars, "multi_date_field"));
            fields,
        indexRandom(
        Map<String, Object> params = MapBuilder.<String, Object>newMapBuilder().put("factor", 2.0).map();
        assertThat(sObj2Arr2.size(), equalTo(2));
        }
            .addDocValueField("date_field")
            .get();
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
            .field("store", true)
            assertThat(fields.get("s").getValues(), equalTo(Collections.<Object>singletonList(Integer.toString(id))));
        DateTime date1 = new DateTime(1990, 12, 29, 0, 0, DateTimeZone.UTC);
                    .field("test", "something")
                    .endObject()
        logger.info("running doc['unsigned_num1'].value");
            scripts.put("doc['unsigned_num1'].value", vars -> {
            .setSource(
            .startObject("date_field")
                    "long_field",
        assertThat(response.getHits().getAt(2).getId(), equalTo("3"));
            .addStoredField("byte_field")
        super(staticSettings);
        sObj2Arr2 = response.getHits().getAt(0).field("s_obj2_arr2").getValues();
                    .endArray()
            .setSource(jsonBuilder().startObject().field("test", "value beck").field("unsigned_num1", BigInteger.valueOf(2)).endObject())
                    "boolean_field",
            .addDocValueField("float_field", "use_field_mapping")
    public void testStoredFields() throws Exception {
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        SearchResponse searchResponse = client().prepareSearch()
        String field = "field1.field2.field3.field4";
            .startObject("integer_field")
        client().admin().indices().prepareFlush().get();
                    "float_field",
            scripts.put("doc['boolean_field']", vars -> sourceScript(vars, "boolean_field"));
                    .field("arr3_field1", "arr3_value1")
                jsonBuilder().startObject().field("test", "value beck").field("num1", 3.0f).field("date", "1970-01-01T00:02:00").endObject()
            .setRouting("1")
                )
        SearchHit hit = searchResponse.getHits().getAt(0);
        }
                "long_field",
        long dateAsMillis = instant.toEpochMilli();
            .endObject()
            .addStoredField("*3")
        assertThat(
        SearchResponse response = client().prepareSearch("test").addStoredField("field1").get();
                "type=ip",
            .get();
        assertThat(
        String mapping = XContentFactory.jsonBuilder()
                .startArray("field1")
            .startObject("field1")
                .startObject("field2")
                ScriptDocValues.Dates dates = (ScriptDocValues.Dates) doc.get("date");
                    "binary_field",
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
        String date = "2019-01-31T10:00:00.123456789Z";
/*
            )
                    .field("field2", "value21")
            .setMapping(
                    .field("type", "object")
            .field("type", "text")
        assertThat(searchResponse.getHits().getAt(0).getFields().size(), equalTo(1));
            .addDocValueField("date_field_alias", "use_field_mapping")
        assertThat(searchResponse.getHits().getAt(0).getFields().get("text_field").getValue(), equalTo("foo"));
                        new double[] { i, i + 1 },
import org.opensearch.index.query.QueryBuilders;
                .endObject()
        assertThat(
            assertEquals(fields.get("derived_multi_long_field").getValues().get(0), id);
            });
            .get();
        assertThat(searchHit.getFields().get("long_field").getValue(), equalTo((Object) 4L));
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(fields, equalTo(singleton("sNum1")));
            .get();
        assertThat(searchResponse.getHits().getAt(0).getFields().get("field3").getValue().toString(), equalTo("value3"));
        indexRandomForConcurrentSearch("test");
        client().admin().indices().refresh(refreshRequest()).actionGet();
            .addScriptField(
        assertThat(searchResponse.getHits().getAt(0).getFields().get("field2"), nullValue());
            .field("type", "float")
    public void testScriptFieldWithNanos() throws Exception {
            .field("store", true)
            .field("type", "text")
            prepareCreate("index").setMapping(
        client().admin().indices().refresh(refreshRequest()).actionGet();
            .field("doc_values", true) // off by default on binary fields
            .endObject()
                    .endObject()
            .startObject("field1")
            req.addDerivedField(
        assertThat(textFieldAlias.getName(), equalTo("text_field_alias"));
 * this work for additional information regarding copyright
            .field("type", "alias")
            .setId("1")
        assertAcked(prepareCreate("test").setMapping(mapping));
            .addDocValueField("keyword_field", "use_field_mapping")
            .get();
                    .startObject()
                jsonBuilder().startObject()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            });
            .get();
            .addStoredField("double_field")
            .startObject()
                        (double) i,
            .get();
            scripts.put("doc['multi_double_field']", vars -> sourceScript(vars, "multi_double_field"));
            .field("store", true)
                field[1],
        indexRandomForConcurrentSearch("test");
        assertThat(searchResponse.getHits().getAt(0).getFields().get("flat_object_field1.foo").getValue(), equalTo("bar"));
        assertThat(response.getHits().getAt(1).getFields().get("date1").getValues().get(0), equalTo(25000L));
        assertThat(searchResponse.getHits().getAt(0).getFields().get("field3").getValue().toString(), equalTo("value3"));
                "type=long",
                    "integer_field",
        assertThat(
                .endObject()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            .endObject()
        org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
            .field("path", "text_field")
 * software distributed under the License is distributed on an
                    "date_field",
        assertHitCount(response, 1);
                DateFieldMapper.getDefaultDateTimeFormatter().formatJoda(date1)
        assertThat(
        ZonedDateTime date = ZonedDateTime.of(2012, 3, 22, 0, 0, 0, 0, ZoneOffset.UTC);
        assertThat(searchResponse.getHits().getAt(0).getFields().get("byte_field").getValue().toString(), equalTo("1"));
        final int numDocs = randomIntBetween(3, 8);
            });
        DateTime date = new DateTime(1990, 12, 29, 0, 0, DateTimeZone.UTC);
            .startObject(MapperService.SINGLE_MAPPING_NAME)
                "ip_field",
            .endObject()
        assertThat(field.getValue().toString(), equalTo("value1"));
        DateTime date = new DateTime(1990, 12, 29, 0, 0, DateTimeZone.UTC);
import org.opensearch.common.xcontent.support.XContentMapValues;
 * Unless required by applicable law or agreed to in writing,
        logger.info("running doc['num1'].value * factor");
                .field("field4", "value2")
        refresh();
        assertThat(response.getHits().getAt(0).field("s_obj1_test").getValue().toString(), equalTo("something"));
        assertThat(response.getHits().getAt(1).getId(), equalTo("2"));
public class SearchFieldsIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    }
        XContentBuilder mapping = XContentFactory.jsonBuilder()
                    .endObject()
        assertThat(response.getHits().getAt(0).field("s_obj1_test").getValue().toString(), equalTo("something"));
            .endObject();
        Map<String, DocumentField> fields = searchResponse.getHits().getHits()[0].getFields();
            .endObject();
                    .field("date_field", DateFormatter.forPattern("date_optional_time").format(date))
        assertThat(response.getHits().getAt(0).getFields().get("sNum1").getValues().get(0), equalTo(BigInteger.valueOf(2)));
            scripts.put("doc['ms']", vars -> docScript(vars, "ms"));
            .endObject()
            .get();
            .setId("2")
    public void testScriptFieldUsingSource() throws Exception {
    }
                return num1.getValue().multiply(Numbers.toBigIntegerExact(factor));
                    .endObject()
        assertThat(response.getHits().getAt(0).getFields().get("date2").getValues().get(0), equalTo(0L));
import static org.opensearch.common.util.set.Sets.newHashSet;
            .get();
        );
 * GitHub history for details.
                .setRouting("1")
            fields,
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                    .endObject()
            { "date_field", "date" },
        prepareCreate("test").setMapping("num1", "type=long").get();
                    .startObject("field3")
        assertEquals(2, hit.getFields().size());
                    .endObject()
        assertNoFailures(response);
                    .endObject()
        createIndex("test");
        fields = new HashSet<>(response.getHits().getAt(0).getFields().keySet());
        refresh("test");
        builder = client().prepareSearch().setQuery(matchAllQuery()).addDocValueField("*field");
            .field("type", "unsigned_long")
            .setSource(jsonBuilder().startObject().startObject("field1").field("field2", "value1").endObject().endObject())
            .endObject()
import org.opensearch.core.xcontent.MediaTypeRegistry;
        fields = new HashSet<>(response.getHits().getAt(0).getFields().keySet());
            .field("type", "ip")
                    .startObject("properties")
                    .startObject("properties")
        indexRandom(
            .startObject("field1-alias")
        assertThat(searchHit.getFields().get("unsigned_long_field").getValue(), equalTo(new BigInteger("10223372036854775807")));
        searchResponse = builder.get();
        DocumentField dateField = fields.get("date_field");
                "double_field",
import org.opensearch.script.ScriptType;
        SearchRequestBuilder req = client().prepareSearch("index");
        SearchResponse searchResponse = client().prepareSearch().setQuery(matchAllQuery()).addStoredField("field1").get();
 *
            .toString();
    }
                    .endObject()
                Map<?, ?> doc = (Map) vars.get("doc");
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
                    .field("byte_field", (byte) 1)
import java.util.ArrayList;
                    .field("flat_object_field1")
        assertAcked(prepareCreate("test").setMapping(mapping));
        assertThat(fields, equalTo(singleton("sNum1")));
            scripts.put("doc['keyword_field']", vars -> sourceScript(vars, "keyword_field"));
import java.util.Collection;
        ;
        SearchResponse searchResponse = client().prepareSearch().setQuery(matchAllQuery()).addStoredField("field*").get();
        assertAcked(prepareCreate("test").setMapping(mapping));
        assertThat(searchResponse.getHits().getAt(0).getFields().get("field1").getValue().toString(), equalTo("value1"));
                    "integer_field",
            .startObject("boolean_field")
 * Licensed to Elasticsearch under one or more contributor
        assertThat(searchResponse.getHits().getAt(0).getFields().get("double_field").getValue(), equalTo((Object) 6.0d));
            .startObject("integer_field")
        SearchResponse searchResponse = client().prepareSearch()
            .field("type", "long")
            scripts.put("_fields['num1'].value", vars -> fieldsScript(vars, "num1"));
                    .field("binary_field", Base64.getEncoder().encodeToString("testing text".getBytes("UTF-8")))
            .endObject()
import org.opensearch.common.Numbers;
        assertHitCount(searchResponse, 1L);
        assertThat(response.getHits().getAt(1).getSortValues()[0], equalTo(dateAsNanos));
        assertThat(searchResponse.getHits().getAt(0).getFields().get("ip_field").getValue(), equalTo("::1"));
            .startObject("date_field_alias")
        assertThat(textFieldAlias.getValue(), equalTo("foo"));
            .setQuery(matchAllQuery())
                    "boolean_field",
        indexRandomForConcurrentSearch("test");
        assertThat(fields, equalTo(newHashSet("sNum1", "sNum1_field", "date1")));
        String mapping = XContentFactory.jsonBuilder()
                    .field("short_field", (short) 2)
            reqs.add(
            ).get()
        assertThat(searchResponse.getHits().getAt(0).getFields().size(), equalTo(2));
            )
        for (int i = 0; i < numDocs; ++i) {
            .startObject("unsigned_num1")
        client().prepareIndex("test").setId("1").setSource("foo", "bar").setRefreshPolicy("true").get();
            .setId("1")
 */
        );
                    .field("date_field", DateFormatter.forPattern("date_optional_time").format(date))
            );
                .startObject()
        List<?> fieldValues = fieldObj.getValues();
            .startObject("field2")
            .indices()
                        new double[] { i, i + 1 }
    }
    }
        assertHitCount(searchResponse, 1);
        assertThat(dateField.getValue(), equalTo("1990-12-29"));
            .get();
                .endObject()
        assertThat(searchResponse.getHits().getAt(0).getFields().get("float_field").getValue(), equalTo((Object) 5.0));
        String mapping = XContentFactory.jsonBuilder()
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        );
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
            assertEquals(fields.get("derived_geo_field").getValues().get(0), new GeoPoint(12.0, 10.0));
            .startObject()
                DateFieldMapper.getDefaultDateTimeFormatter().formatJoda(date1)
        indexRandomForConcurrentSearch("test");
    }
                        true,
            .setRefreshPolicy(IMMEDIATE)
import java.util.Set;
            .get();
        assertAcked(client().admin().indices().prepareCreate("test").setMapping("test_field", "type=keyword").get());
                    .startArray("arr1")
            .startObject("_source")
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        assertThat(searchHit.getFields().get("float_field").getValue(), equalTo((Object) 5.0f));
import java.util.Base64;
import org.opensearch.test.InternalSettingsPlugin;
        fields = new HashSet<>(searchResponse.getHits().getAt(0).getFields().keySet());
        client().admin().indices().preparePutMapping().setSource(mapping, MediaTypeRegistry.JSON).get();
            .startObject(MapperService.SINGLE_MAPPING_NAME)
            .endObject()
                    "double_field",
        Map<String, DocumentField> fields = response.getHits().getAt(0).getFields();
        client().prepareIndex("test")
            .toString();
    }
            .addDocValueField("byte_field", "#.0")
            .field("path", "field2")
        Instant instant = ZonedDateTime.parse(date).toInstant();
            .addStoredField("integer_field")
        refresh("test");
        assertThat(response.getHits().getAt(1).getFields().get("sNum1").getValues().get(0), equalTo(2.0));
import static org.hamcrest.Matchers.nullValue;
            .startObject("unsigned_long_field")
                    .startObject("field4")
        indexRandomForConcurrentSearch("index");
                        "multi_ip_field",
            scripts.put("doc['num1'].value * factor", vars -> {
        DocumentField textFieldAlias = fields.get("text_field_alias");
                    .endObject()
        client().admin().indices().preparePutMapping().setSource(mapping, MediaTypeRegistry.JSON).get();
        indexRandomForConcurrentSearch("test");
        assertThat(fields, equalTo(newHashSet("sNum1", "sNum1_field")));
            scripts.put("doc['date'].date.millis", vars -> {
    public static Collection<Object[]> parameters() {
                    "ip_field"
            scripts.put("doc['unsigned_num1'].value * factor", vars -> {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            )
            client().prepareIndex("test").setId("2").setSource(jsonBuilder().startObject().field("date", date).endObject())
            .field("path", "date_field")
                    "float_field",
                        "multi_geo_field",
                    .startObject("obj1")
            )
                .setId(Integer.toString(i))
        indexRandomForConcurrentSearch("test");
        SearchResponse response = client().prepareSearch()
        assertThat(sObj2Arr2.get(1).toString(), equalTo("arr_value2"));
            .addSort("unsigned_num1", SortOrder.ASC)
            .field("fielddata", true)
            .setQuery(matchAllQuery())
            scripts.put("doc['d']", vars -> docScript(vars, "d"));
            .endObject()
                jsonBuilder().startObject()
            .startObject(MapperService.SINGLE_MAPPING_NAME)
            .endObject()
            assertEquals(fields.get("derived_ip_field").getValues().get(0), "172.16.1.10");
import org.joda.time.format.DateTimeFormat;
        XContentBuilder mapping = XContentFactory.jsonBuilder()
                        "l",
    public static class CustomScriptPlugin extends MockScriptPlugin {
                    "byte_field",
                Map<String, Object> params = (Map<String, Object>) vars.get("params");
            )
        assertThat(fields, equalTo(singleton("sNum1")));
            .endObject()
            .startObject()
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
            )
            .addStoredField("boolean_field")
            .setId("2")
    }
                ScriptDocValues.Doubles num1 = (ScriptDocValues.Doubles) doc.get("num1");
        assertThat(fields.get("field1"), nullValue());
        indexRandom(true, reqs);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
import org.opensearch.core.common.bytes.BytesArray;
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            )
        ensureGreen("test");
        List<?> sObj2Arr3 = response.getHits().getAt(0).field("s_arr3").getValues();
            ).get()
            });
        assertThat(searchResponse.getHits().getAt(0).field(field).getValues().get(1).toString(), equalTo("value2"));
        SearchResponse searchResponse = client().prepareSearch("test")
        assertTrue(hit.getFields().containsKey("field1-alias"));
            assertEquals(fields.get("derived_keyword_field").getValues().get(0), Integer.toString(id));
            scripts.put("_source.obj1.test", vars -> sourceScript(vars, "obj1.test"));
        indexRandom(true, indexRequestBuilders);
            equalTo(DateFormatter.forPattern("date_optional_time").format(date))
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                "multi_ip_field",
                new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['" + field[0] + "']", Collections.emptyMap())
            .prepareCreate("my-index")
        assertThat(
            .addDocValueField("long_field", "use_field_mapping")
            .field("store", true)
            equalTo(DateFormatter.forPattern("dateOptionalTime").format(date))
        assertThat(searchResponse.getHits().getAt(0).getFields().get("byte_field").getValue().toString(), equalTo("1"));
            assertEquals(fields.get("derived_long_field").getValues().get(0), id);
                "d",
                ScriptDocValues.Doubles num1 = (ScriptDocValues.Doubles) doc.get("num1");
        assertThat(searchResponse.getHits().getAt(0).getFields().get("float_field").getValue(), equalTo((Object) 5.0));
                .startArray("field3")
                jsonBuilder().startObject()
                    "short_field",
        // field2 is not stored, check that it is not extracted from source.
            equalTo(newHashSet("byte_field", "short_field", "integer_field", "long_field", "float_field", "double_field", "date_field"))
                    "long_field",
            final int id = Integer.parseInt(hit.getId());
            .field("store", true)
import java.time.ZoneOffset;
            .get();
        assertThat(fields.keySet(), equalTo(newHashSet("text_field_alias", "date_field_alias", "date_field")));
            .endObject()
            scripts.put("doc['md']", vars -> docScript(vars, "md"));
        assertAcked(prepareCreate("test").setMapping(mapping));
            .addSort("num1", SortOrder.ASC)
        }
                "multi_double_field",
        DateTime date2 = new DateTime(1990, 12, 30, 0, 0, DateTimeZone.UTC);
                Map<?, ?> doc = (Map) vars.get("doc");
            .field("enabled", false)
        client().prepareIndex("my-index")
        assertThat(sObj2Arr2.size(), equalTo(2));
                        "double_field",
            .setSettings(Settings.builder().put("index.refresh_interval", -1))
            scripts.put("_fields._uid.value", vars -> fieldsScript(vars, "_uid"));
        assertThat(response.getHits().getAt(1).getFields().get("sNum1").getValues().get(0), equalTo(4.0));
                    .field("ip_field", "::1")
        SearchResponse searchResponse = builder.get();
                    "text_field",
            scripts.put("doc['s']", vars -> docScript(vars, "s"));
                Map<?, ?> doc = (Map) vars.get("doc");
            .addDocValueField("float_field")
            assertEquals(
            .setQuery(matchAllQuery())
        assertThat(response.getHits().getAt(0).getId(), is("1"));
            .field("enabled", false)
        client().admin().indices().prepareRefresh().get();
                "type=long",
            .addStoredField("field1")
                    .endObject()
                    .endObject()
        SearchResponse resp = req.get();
            .endObject()
            .get();
            .field("enabled", false)
            .setQuery(matchAllQuery())
import static org.hamcrest.Matchers.equalTo;
        assertThat(searchResponse.getHits().getAt(0).getFields().size(), equalTo(1));
        assertThat(searchResponse.getHits().getAt(0).getFields().get("field3").getValue().toString(), equalTo("value3"));
import org.opensearch.search.builder.SearchSourceBuilder;
            jsonBuilder().startObject()
import java.time.Instant;
        assertThat(response.getHits().getAt(2).getId(), equalTo("3"));
            .addScriptField(
            )
                    .field("unsigned_num1", new BigInteger("9322337203685477580"))
        assertThat(response.getHits().getAt(2).getId(), equalTo("3"));
                    "ip_field",
        assertThat(fields.get("_routing").getValue().toString(), equalTo("1"));
            .setQuery(matchAllQuery())
        createIndex("test");
            .setSource(
            .startObject()
            .startObject()
import org.joda.time.DateTime;
                    "integer_field",
 *
import org.opensearch.search.lookup.FieldLookup;
        assertThat(searchResponse.getHits().getAt(0).getFields().get("flat_object_field1.foo").getValue(), equalTo("bar"));
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
                        new long[] { i, i + 1 },
import org.opensearch.core.rest.RestStatus;
            .setQuery(matchAllQuery())
    }
        client().admin().indices().prepareRefresh().get();
    }
    }
        searchResponse = builder.get();
            .addScriptField("sNum1", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['unsigned_num1'].value * factor", params))
        ensureSearchable();
                    .field("unsigned_long_field", new BigInteger("10223372036854775807"))
            .field("type", "keyword")
            .startObject("short_field")
        assertAcked(prepareCreate("test"));
                XContentFactory.jsonBuilder()
        List<IndexRequestBuilder> reqs = new ArrayList<>();
            );
        indexRandomForConcurrentSearch("test");
 *
            .addDocValueField("*alias", "use_field_mapping")
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                fields.get("derived_multi_date_field").getValues().get(0),
            .addDocValueField("text_field_alias")
        createIndex("test");
            .get();
                Double factor = (Double) params.get("factor");
            assertEquals(fields.get("derived_multi_long_field").getValues().get(1), (id + 1));
            { "geo_field", "geo_point" },
    public void testScriptWithUnsignedLong() throws Exception {
        assertThat(searchResponse.getHits().getAt(0).getFields().get("binary_field").getValue(), equalTo("KmQ"));
            .field("store", true)
        client().admin().indices().preparePutMapping().setSource(mapping, MediaTypeRegistry.JSON).get();
            );
        assertThat(searchResponse.getHits().getAt(0).getFields().get("field1").getValue().toString(), equalTo("value1"));
import org.opensearch.script.Script;
            .addScriptField(
            assertEquals(
        Map<String, DocumentField> fields = hit.getFields();
        DocumentField dateFieldAlias = fields.get("date_field_alias");
                "sNum1_field",
        assertAcked(
            .addStoredField("field2-alias")
                .endObject()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
import org.opensearch.index.mapper.MapperService;
        assertThat(searchResponse.getHits().getAt(0).getFields().get("float_field").getValue(), equalTo((Object) 5.0));
            equalTo(
            .startObject("properties")
            .endObject();
        assertThat("Failures " + Arrays.toString(response.getShardFailures()), response.getShardFailures().length, equalTo(0));
        for (SearchHit hit : resp.getHits().getHits()) {
                    .startObject("obj2")
        assertThat(textFieldAlias.getName(), equalTo("text_field_alias"));
                    "float_field",
        SearchRequestBuilder builder = client().prepareSearch()
            .addDocValueField("long_field", "#.0")
                    "byte_field",
                fields.get("derived_date_field").getValues().get(0),
                    "float_field",
            .endObject()
        createIndex("test");
        assertThat(fields, equalTo(singleton("sNum1")));
        assertThat(fields, equalTo(newHashSet("sNum1", "sNum1_field", "date1")));
                    .field("type", "text")
        indexRandomForConcurrentSearch("test");
                jsonBuilder().startObject().field("test", "value beck").field("num1", 1.0f).field("date", "1970-01-01T00:00:00").endObject()
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
                    "flat_object_field1.foo"
import org.opensearch.common.settings.Settings;
                    "boolean_field",
            .startObject("long_field")
            .startObject("field2-alias")
        final int numDocs = randomIntBetween(3, 8);
            .field("type", "alias")
        assertThat(
            .endObject()
            Map<String, DocumentField> fields = hit.getFields();
            .startObject("ip_field")
            Map<String, DocumentField> fields = hit.getFields();
            .addDocValueField("ip_field")
                    .endObject()
            .field("path", "field2")
                        "boolean_field",
            .setId("1")
        }
        assertThat(response.getHits().getAt(1).getId(), equalTo("2"));
                ScriptDocValues.UnsignedLongs num1 = (ScriptDocValues.UnsignedLongs) doc.get("unsigned_num1");
        client().prepareIndex("my-index")
            { "long_field", "long" },
    }
            );
                    "unsigned_long_field"
            .startObject("text_field")
        assertThat(searchResponse.getHits().getAt(0).getFields().get("byte_field").getValue(), equalTo("1.0"));
        index("test", MapperService.SINGLE_MAPPING_NAME, "1", "field1", "value1", "field2", "value2");
            .field("store", true)
        );
                "type=date",
            )
            .field("type", "text")
                    .field("foo", "bar")
                new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['" + field + "']", Collections.emptyMap())
import org.opensearch.common.time.DateUtils;
        );
        Set<String> fields = new HashSet<>(response.getHits().getAt(0).getFields().keySet());
        assertThat(fields.keySet(), equalTo(newHashSet("text_field_alias", "date_field_alias", "date_field")));
            .endObject()
                    .endObject()
            .setQuery(matchAllQuery())
                    .endObject()
            .addDocValueField("short_field")
        assertThat(searchResponse.getHits().getAt(0).getFields().size(), equalTo(2));
                        "172.16.1.10",
        client().admin().indices().refresh(refreshRequest()).actionGet();
            .field("type", "double")
            false,
            scripts.put("doc['double_field']", vars -> sourceScript(vars, "double_field"));
            .addStoredField("short_field")
        client().admin().indices().preparePutMapping().setSource(mapping, MediaTypeRegistry.JSON).get();
            client().prepareIndex("test")
            .setId("1")
        assertThat(searchResponse.getHits().getAt(0).getFields().get("double_field").getValue(), equalTo((Object) 6.0d));
        assertThat(response.getHits().getTotalHits().value(), equalTo((long) numDocs));
        for (int i = 0; i < numDocs; i++) {
            .startObject("long_field")
        }
            .endObject()
            .field("path", "field1")
                    .field("type", "object")
            .field("enabled", false)
        String mapping = XContentFactory.jsonBuilder()
                    .field("long_field", 4L)
            )
 * this file be licensed under the Apache-2.0 license or a
            .setSource(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()).docValueField("test_field"))
                "multi_long_field",
        client().admin().indices().prepareRefresh().get();
            .field("store", true)
                new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['date'].date.millis", Collections.emptyMap())
                ScriptDocValues.UnsignedLongs num1 = (ScriptDocValues.UnsignedLongs) doc.get("unsigned_num1");
            .field("type", "short")
import org.joda.time.DateTimeZone;
                new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['date'].date.millis", Collections.emptyMap())
        assertThat(response.getHits().getAt(0).getSortValues()[0], equalTo(0L));
        assertThat(response.getHits().getAt(2).getId(), equalTo("3"));
import static org.opensearch.transport.client.Requests.refreshRequest;
        index("test", MapperService.SINGLE_MAPPING_NAME, "1", "text_field", "foo", "date_field", formatter.print(date));
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
import java.util.Collections;
            )
            true,
            scripts.put("_fields._id.value", vars -> fieldsScript(vars, "_id"));
    public void testGetFieldsComplexField() throws Exception {
            .field("type", "alias")
            .addSort("date", SortOrder.ASC)
                        "ms",
            .setSource(
                return dates.getValue().toInstant().toEpochMilli();
                "date1",
                )
            .startObject("text_field_alias")
                field,
            scripts.put("_source.obj1.test", vars -> sourceScript(vars, "obj1.test"));
                "type=geo_point"
        return Arrays.asList(InternalSettingsPlugin.class, CustomScriptPlugin.class);
                jsonBuilder().startObject().field("field1", "value1").field("field2", "value2").field("field3", "value3").endObject()
import java.util.concurrent.ExecutionException;
        assertSearchResponse(response);
        assertThat(response.getHits().getAt(2).getFields().get("sNum1_field").getValues().get(0), equalTo(3.0));
        assertNoFailures(response);
            .endObject()
            Set<String> fields = new HashSet<>(response.getHits().getAt(i).getFields().keySet());
        assertThat(response.getHits().getAt(2).getFields().get("sNum1").getValues().get(0), equalTo(6.0));
            .field("type", "short")
            .field("type", "boolean")
            .field("fielddata", true)
                    "date_field",
        assertThat(fields, equalTo(newHashSet("sNum1", "sNum1_field")));
        for (int i = 0; i < numDocs; i++) {
        assertThat(fieldAlias.getValue().toString(), equalTo("value1"));
            .endObject()
                    .endArray()
            .setSource(
        assertThat(searchResponse.getHits().getAt(0).field(field).getValues().get(0).toString(), equalTo("value1"));
                    "double_field",
            .startObject(MapperService.SINGLE_MAPPING_NAME)
                    .startObject("obj1")
            .startObject("properties")
        assertThat(searchHit.getFields().get("date_field").getValue(), equalTo((Object) dateTime));
        assertThat(searchResponse.getHits().getAt(0).field(field).getValues().size(), equalTo(2));
        assertThat(fieldObj, notNullValue());
            .addDocValueField("date_field", "epoch_millis");
    @Override
            .startObject()
        ensureGreen("test");
            fields,
        assertThat(searchResponse.getHits().getAt(0).getFields().get("text_field").getValue(), equalTo("foo"));
                    .value("arr_value1")
                DateFieldMapper.getDefaultDateTimeFormatter().formatJoda(date2)
    public void testDocValueFields() throws Exception {
            .field("type", "alias")
import org.opensearch.search.SearchHit;
            .setSize(numDocs)
            assertEquals(fields.get("derived_multi_ip_field").getValues().get(0), "172.16.1.10");
 * SPDX-License-Identifier: Apache-2.0
            .endObject()
                .startObject()
import org.opensearch.index.mapper.DateFieldMapper;
                "md",
                    "short_field",
            .addDocValueField("binary_field", "use_field_mapping")
                    "date_field",
        indexRandomForConcurrentSearch("index");
        assertThat(response.getHits().getAt(1).getId(), equalTo("2"));
            .startObject("field1")
/*
        logger.info("running doc['num1'].value");
            .field("type", "byte")
        assertTrue(hit.getFields().containsKey("field1"));
            .startObject("_source")
import org.opensearch.action.search.SearchRequestBuilder;
                fields.get("derived_multi_date_field").getValues().get(1),
                    .field("byte_field", (byte) 1)
        assertNoFailures(response);
                        date1.getMillis(),
            .setId("1")
        assertThat(searchResponse.getHits().getAt(0).getFields().get("long_field").getValue(), equalTo((Object) 4L));
            containsString("field [field1] isn't a leaf field")
            )
        assertThat(dateField.getName(), equalTo("date_field"));
                    .field("short_field", (short) 2)
        @SuppressWarnings("unchecked")
    public void testScriptDocAndFields() throws Exception {
        assertThat(fields, equalTo(newHashSet("sNum1", "sNum1_field")));
        assertThat(searchResponse.getHits().getAt(0).getFields().get("keyword_field").getValue(), equalTo("foo"));
            );
                    .endObject()
            )
            .setId("1")
        assertNoFailures(response);
                .startArray("field3")
        assertFalse(response.getHits().getAt(0).hasSource());
        client().prepareIndex("test")
        }
                    .value("arr_value2")
            assertThat(response.getHits().getAt(i).getFields().get("id").getValue(), equalTo(Integer.toString(i)));
                    .field("type", "object")
            .field("type", "long")
                        new long[] { i, i + 1 },
                new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_fields['unsigned_num1'].value", Collections.emptyMap())
        assertThat(response.getHits().getAt(2).getFields().get("sNum1").getValues().get(0), equalTo(new BigInteger("9322337203685477580")));
        assertThat(dateFieldAlias.getName(), equalTo("date_field_alias"));
            .endObject()
        assertHitCount(searchResponse, 1);
        String mapping = XContentFactory.jsonBuilder()
            equalTo(
            { "boolean_field", "boolean" },
 * compatible open source license.
        for (SearchHit hit : resp.getHits().getHits()) {
            scripts.put("doc['geo_field']", vars -> sourceScript(vars, "geo_field"));
            .startObject(MapperService.SINGLE_MAPPING_NAME)
    public void testDerivedFields() throws Exception {
            .addDocValueField("integer_field")
            .setRefreshPolicy(IMMEDIATE)
import org.opensearch.common.xcontent.XContentFactory;
                "s",
            .addDocValueField("double_field")
        assertThat(searchResponse.getHits().getAt(0).getFields().get("binary_field").getValue(), equalTo("KmQ"));
                    .field("float_field", 5.0f)
            assertThat(response.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));
                "type=keyword",
        indexRandomForConcurrentSearch("my-index");
                    .endObject()
        response = client().prepareSearch()
            .field("type", "byte")
        assertThat(dateFieldAlias.getName(), equalTo("date_field_alias"));
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).addStoredField("*").get();
        assertThat(response.getHits().getAt(0).getFields().get("sNum1").getValues().get(0), equalTo(BigInteger.valueOf(1)));
                    "ip_field",
import org.opensearch.common.document.DocumentField;
        assertThat(((Map<?, ?>) sObj2Arr3.get(0)).get("arr3_field1").toString(), equalTo("arr3_value1"));
        assertThat(searchResponse.getHits().getAt(0).getFields().get("double_field").getValue(), equalTo((Object) 6.0d));
        SearchHit searchHit = searchResponse.getHits().getAt(0);
                "multi_geo_field",
                .setSource(jsonBuilder().startObject().field("date", "1970-01-01T00:00:00.000Z").endObject()),
        Set<String> fields = new HashSet<>(searchResponse.getHits().getAt(0).getFields().keySet());
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
            .field("type", "text")
                    .field("integer_field", 3)
    public void testSearchFieldsNonLeafField() throws Exception {
            .field("store", true)
            .toString();
            .addScriptField("id", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_fields._id.value", Collections.emptyMap()))
                .setId("1")
        client().admin().indices().prepareFlush().get();
            .endObject()
                new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_source.obj2.arr2", Collections.emptyMap())
                return num1.getValue() * factor;
        indexRandomForConcurrentSearch("test");
        SearchHit hit = searchResponse.getHits().getAt(0);
            .addScriptField("s_obj2", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_source.obj2", Collections.emptyMap()))
        );
                        new String[] { "172.16.1.10", "172.16.1.11" },
        String[][] fieldLookup = new String[][] {
        assertThat(searchResponse.getHits().getAt(0).getFields().get("ip_field").getValue(), equalTo("::1"));
            .endObject();
            .get();
        assertThat(sObj2Arr2.get(1).toString(), equalTo("arr_value2"));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        SearchResponse resp = req.get();
                    .field("double_field", 6.0d)
            )
            .startObject("properties")
                "type=keyword",
            .setSource(jsonBuilder().startObject().field("test", "value beck").field("unsigned_num1", BigInteger.valueOf(1)).endObject())
                    "text_field",
                    .field("foob", "barb")
                    "double_field",
            .startObject("properties")
        SearchHit hit = searchResponse.getHits().getAt(0);
            .startObject("field3")
import static org.hamcrest.Matchers.notNullValue;
            .get();
        assertThat(searchResponse.getHits().getAt(0).getFields().get("text_field").getValue(), equalTo("foo"));
            .field("store", false)
        assertThat(searchResponse.getHits().getAt(0).getFields().get("float_field").getValue(), equalTo("5.0"));
                jsonBuilder().startObject().field("test", "value beck").field("num1", 2.0f).field("date", "1970-01-01T00:00:25").endObject()
 */
            searchResponse.getHits().getAt(0).getFields().get("date_field").getValue(),
        );
import org.opensearch.common.geo.GeoPoint;
        String mapping = XContentFactory.jsonBuilder()
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
    public void testIdBasedScriptFields() throws Exception {
        assertThat(searchHit.getFields().get("short_field").getValue().toString(), equalTo("2"));
            .field("type", "date")
            .field("store", false)
            .startObject("field2")
 * The OpenSearch Contributors require contributions made to
            .addDocValueField("date_field");
                "l",
        assertThat(searchResponse.getHits().getAt(0).getFields().get("keyword_field").getValue(), equalTo("foo"));
        assertThat(field.getValue().toString(), equalTo("value1"));
            { "multi_keyword_field", "keyword" },
    public void testStoredFieldsWithFieldAlias() throws Exception {
            FieldLookup fieldLookup = (FieldLookup) fields.get(fieldName);
import org.opensearch.core.common.bytes.BytesReference;
        }
            .field("type", "date")
        assertThat(fields, equalTo(singleton("sNum1")));
        assertFailures(
                jsonBuilder().startObject()
 */
                "date_field",
 * not use this file except in compliance with the License.
    }
        assertThat(response.getHits().getAt(0).getFields().get("sNum1").getValues().get(0), equalTo(2.0));
 * under the License.
            .endObject()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            .field("type", "text")
                        i,
            .field("type", "text")
            .endObject()
        assertThat(searchResponse.getHits().getAt(0).getFields().get("boolean_field").getValue(), equalTo((Object) true));
            .startObject("flat_object_field1")
            .field("type", "binary")
    public void testSingleValueFieldDatatField() throws ExecutionException, InterruptedException {
        fields = new HashSet<>(response.getHits().getAt(0).getFields().keySet());
            .field("type", "alias")
            .field("type", "double")
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        assertThat(searchResponse.getHits().getAt(0).getSourceAsMap(), notNullValue());
        assertThat(dateField.getName(), equalTo("date_field"));
        SearchResponse response = client().prepareSearch()
            .addDocValueField("integer_field", "use_field_mapping")
        index("test", MapperService.SINGLE_MAPPING_NAME, "1", "field1", "value1", "field2", "value2");
            .endObject()
            .endObject()
            .endObject()
        client().prepareIndex("test")
            .field("store", true)
            .addDocValueField("double_field", "#.0")
            return values;
                    .field("long_field", 4L)
                    "flat_object_field1.foo"
        assertThat(response.getHits().getAt(0).getFields().get("date1").getValues().get(0), equalTo(0L));
            .addStoredField("date_field")
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
import org.opensearch.search.sort.SortOrder;
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
                    .endObject()
import org.opensearch.core.xcontent.XContentBuilder;
            .addScriptField("s_obj1", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_source.obj1", Collections.emptyMap()))
                "type=keyword",
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).addStoredField("field*").get();
            .toString();
                newHashSet(
                return num1.getValue();
import static org.hamcrest.Matchers.is;
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
import org.opensearch.action.index.IndexRequestBuilder;
            .endObject()
            .endObject()
                "type=keyword",
import java.math.BigInteger;
import static java.util.Collections.singleton;
    }
            .setQuery(matchAllQuery())
            equalTo(new BigInteger("18644674407370955160"))
    public SearchFieldsIT(Settings staticSettings) {
        Map<String, Object> sObj2 = response.getHits().getAt(0).field("s_obj2").getValue();
            .startObject("num1")
            equalTo(DateFormatter.forPattern("epoch_millis").format(date))
        assertThat(response.getHits().getAt(1).getId(), equalTo("2"));
                    .field("keyword_field", "foo")
        assertThat(sObj2Arr2.get(0).toString(), equalTo("arr_value1"));
        assertHitCount(searchResponse, 1L);
                .setSource(jsonBuilder().startObject().field("field1", "value").endObject())
        assertThat(response.getHits().getAt(1).getFields().get("sNum1_field").getValues().get(0), equalTo(2.0));
        assertNoFailures(response);
    public void testLoadMetadata() throws Exception {
            prepareCreate("index").setMapping(
                        "geo_field",
 * KIND, either express or implied.  See the License for the
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                "type=geo_point",
            .endObject()
        assertThat(searchResponse.getHits().getAt(0).getFields().get("integer_field").getValue(), equalTo((Object) 3L));
        fields = new HashSet<>(response.getHits().getAt(0).getFields().keySet());
            .addStoredField("field2")
            { "multi_geo_field", "geo_point" } };
        assertThat(sObj2Arr2.get(0).toString(), equalTo("arr_value1"));
        searchResponse = client().prepareSearch()
        createIndex("test");
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).addStoredField("f*3").get();
                .endArray()
            .addDocValueField("text_field", "use_field_mapping")
            .endObject()
                    "binary_field",
            .field("format", "yyyy-MM-dd")
                    .startObject()
        );
                new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['unsigned_num1'].value", Collections.emptyMap())
                        "ip_field",
            .startObject()
    }
        assertThat(searchResponse.getHits().getAt(0).getFields().get("field3").getValue().toString(), equalTo("value3"));
            .addStoredField("long_field")
                    .field("field1", "value1")
        createIndex("test");
            scripts.put("doc['l']", vars -> docScript(vars, "l"));
        SearchResponse searchResponse = client().prepareSearch("my-index").addStoredField("field1").addStoredField("_routing").get();
                .endObject()
            .field("store", true)
/*
            assertEquals(fields.get("derived_multi_keyword_field").getValues().get(1), Integer.toString(id + 1));
            .startObject("boolean_field")
        List<?> sObj2Arr2 = (List<?>) sObj2.get("arr2");
            .startObject("float_field")
            .endObject()
            .field("path", "date_field")
        assertThat(
                        new String[] { Integer.toString(i), Integer.toString(i + 1) },
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            .addSort("num1", SortOrder.ASC)
        fields = new HashSet<>(response.getHits().getAt(0).getFields().keySet());
        assertThat(searchHit.getFields().get("boolean_field").getValue(), equalTo((Object) Boolean.TRUE));
                Map<?, ?> doc = (Map) vars.get("doc");
                        "multi_long_field",
        SearchResponse response = client().prepareSearch()
                "s_obj2_arr2",
            equalTo(DateFormatter.forPattern("date_optional_time").format(date))
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
            searchResponse.getHits().getAt(0).getFields().get("date_field").getValue(),
            .field("type", "integer")
        client().prepareIndex("test")
                "type=double",
                    .endObject()
            .startObject("date_field_alias")
        for (int i = 0; i < numDocs; ++i) {
            .startObject()
            .setQuery(matchAllQuery())
            true,
                newHashSet(
            .endObject()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                    .field("fooa", "bara")
        client().prepareIndex("test")
            .toString();
                    .field("test", "value beck")
            .endObject()
        assertNoFailures(searchResponse);
            .addScriptField("sNum1", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['num1'].value * factor", params))
            .startObject("double_field")
        assertThat(searchResponse.getHits().getAt(0).getFields().get("long_field").getValue(), equalTo("4.0"));
            .setId("1")
        client().prepareIndex("test")
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
import java.util.function.Function;
                .startObject()
        Map<String, DocumentField> fields = hit.getFields();
            .startObject("binary_field")
        DocumentField textFieldAlias = fields.get("text_field_alias");
                .endObject()
            )
            )
            .endObject()
            )
            .startObject("_source")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    "binary_field",
            .get();
            .field("path", "field1")
import java.util.HashMap;
                    "text_field",
}
            ScriptDocValues<?> values = (ScriptDocValues<?>) doc.get(fieldName);
            .field("type", "alias")
            .addStoredField("unsigned_long_field")
        builder = client().prepareSearch()
            .addScriptField("sNum1", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['num1'].value", Collections.emptyMap()))
                "type=double"
                        "multi_double_field",
        );
            .field("store", true)
            .endObject()
            .startObject("field2-alias")
            .field("type", "alias")
            .setSource(
                    .startObject("field1")
        refresh("test");
import static org.hamcrest.Matchers.containsString;
        assertThat(response.getHits().getAt(0).getFields().get("date1").getValues().get(0), equalTo(0L));
        assertThat(searchResponse.getHits().getAt(0).getFields().get("integer_field").getValue(), equalTo((Object) 3L));
            );
                    .startObject("field2")
                        "date_field",
            .endObject()
            scripts.put("doc['ml']", vars -> docScript(vars, "ml"));
            .field("type", "date")
                    "keyword_field",
                    .field("text_field", "foo")
            assertEquals(fields.get("derived_multi_double_field").getValues().get(1), (double) (id + 1));
            assertThat(fields.get("l").getValues(), equalTo(Collections.<Object>singletonList((long) id)));
            assertThat(fields.get("md").getValues(), equalTo(Arrays.<Object>asList((double) id, id + 1d)));
        logger.info("running doc['unsigned_num1'].value * factor");
            .field("type", "binary")
                "date2",
            assertEquals(fields.get("derived_multi_ip_field").getValues().get(1), "172.16.1.11");
                    "short_field",
        assertThat(searchResponse.getHits().getAt(0).getFields().get("long_field").getValue(), equalTo((Object) 4L));
            .addScriptField("s_arr3", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_source.arr3", Collections.emptyMap()))
            Map<?, ?> doc = (Map) vars.get("doc");
                "sNum1_field",
    public void testWildcardDocValueFieldsWithFieldAlias() throws Exception {
            .setQuery(matchAllQuery())
        assertThat(searchResponse.getHits().getAt(0).getFields().get("short_field").getValue().toString(), equalTo("2"));
        SearchResponse response = client().prepareSearch()
        }
            .startObject("byte_field")
            .endObject()
        assertThat(fields.get("test_field").getValue(), equalTo("foobar"));
            scripts.put("doc['date_field']", vars -> sourceScript(vars, "date_field"));
        List<IndexRequestBuilder> reqs = new ArrayList<>();
        Map<String, Object> sObj1 = response.getHits().getAt(0).field("s_obj1").getValue();
            scripts.put("_source.obj2", vars -> sourceScript(vars, "obj2"));
            { "ip_field", "ip" },
        assertThat(searchResponse.getHits().getAt(0).getFields().size(), equalTo(1));
                    "byte_field",
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFailures;
    }
                    .startObject()
                "multi_keyword_field",
        DocumentField fieldObj = response.getHits().getAt(0).field("test_script_1");
                    .field("boolean_field", true)
            .startObject("date_field")
                    .startArray("arr3")
            .startObject("properties")
                "date1",
            .startObject("text_field")
                Map<?, ?> doc = (Map) vars.get("doc");
                    .field("float_field", 5.0f)
            .field("type", "date")
    public void testDocValueFieldsWithFieldAlias() throws Exception {
        SearchRequestBuilder builder = client().prepareSearch()
        client().prepareIndex("my-index").setId("1").setRefreshPolicy(IMMEDIATE).setSource(source, MediaTypeRegistry.JSON).get();
            assertEquals(
            .setSource(
import java.time.ZonedDateTime;
                    .endObject()
        assertThat(fields, equalTo(singleton("sNum1")));
            )
        SearchResponse searchResponse = builder.get();
import java.util.List;
        assertSearchResponse(resp);
        SearchResponse searchResponse = builder.get();
            .addDocValueField("float_field", "#.0")
                client().prepareIndex("index")
        BytesReference source = BytesReference.bytes(
                    .endObject()
        client().prepareIndex("test")
package org.opensearch.search.fields;
        SearchHit hit = searchResponse.getHits().getAt(0);
                        new String[] { Integer.toString(i), Integer.toString(i + 1) },
        searchResponse = builder.get();
            .get();
            .setQuery(matchAllQuery())
            .field("type", "float")
            .endObject()
                return DateUtils.toLong(dates.getValue().toInstant());
            .field("type", "unsigned_long")
        client().prepareIndex("test")
        SearchResponse response = client().prepareSearch()
            .addScriptField(
            .startObject("field1-alias")
        assertTrue(hit.getFields().containsKey("field1-alias"));
    }
        assertThat(searchResponse.getHits().getAt(0).getFields().get("field3").getValue().toString(), equalTo("value3"));
 * specific language governing permissions and limitations
                        new GeoPoint[] { new GeoPoint(12.0, 10.0), new GeoPoint(13.0, 10.0) }
                    .startArray("arr2")
        static Object fieldsScript(Map<String, Object> vars, String fieldName) {
        Set<String> fields = new HashSet<>(searchResponse.getHits().getAt(0).getFields().keySet());
        assertThat(searchResponse.getHits().getAt(0).getFields().size(), equalTo(1));
import java.util.Map;
                newHashSet(
            .addDocValueField("keyword_field")
            .endObject()
                jsonBuilder().startObject()
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        );
        assertAcked(
            .get();
            .startObject("properties")
        assertThat(searchResponse.getHits().getAt(0).getFields().get("field1").getValue().toString(), equalTo("value1"));
            .addScriptField(
                        Integer.toString(i),
            });
        createIndex("test");
    }
        refresh("test");
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        fields = new HashSet<>(searchResponse.getHits().getAt(0).getFields().keySet());
            assertEquals(fields.get("derived_double_field").getValues().get(0), (double) id);
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
            .addDocValueField("boolean_field", "use_field_mapping")
                "type=double",
            .endObject()
            .startObject("keyword_field")
        assertThat(response.getHits().getAt(1).getFields().get("sNum1_field").getValues().get(0), equalTo(BigInteger.valueOf(2)));
            assertThat(fields, equalTo(singleton("id")));
            scripts.put("_source.obj2.arr2", vars -> sourceScript(vars, "obj2.arr2"));
            .get();
            client().prepareSearch("my-index").addStoredField("field1"),
        client().admin().indices().prepareRefresh().get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            scripts.put("doc['multi_ip_field']", vars -> sourceScript(vars, "multi_ip_field"));
                new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_fields['num1'].value", Collections.emptyMap())
            .get();
        assertThat(searchResponse.getHits().getAt(0).getFields().get("boolean_field").getValue(), equalTo((Object) true));
    }
            .startObject("properties")
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            reqs.add(
        client().admin().indices().prepareFlush().get();
            scripts.put("doc['long_field']", vars -> sourceScript(vars, "long_field"));
        fields = new HashSet<>(searchResponse.getHits().getAt(0).getFields().keySet());
                    "long_field",
                    .startObject()
            .startObject("date_field")
            .endObject()
        client().prepareIndex("test")
                    "byte_field",
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
            .startObject("double_field")
            { "multi_double_field", "double" },
            { "multi_date_field", "date" },
                    "keyword_field",
        fields = new HashSet<>(response.getHits().getAt(0).getFields().keySet());
        DocumentField field = hit.getFields().get("field1");
        assertThat(response.getHits().getAt(1).getFields().get("sNum1").getValues().get(0), equalTo(BigInteger.valueOf(2)));
            .field("format", "yyyy-MM-dd")
                client().prepareIndex("index")
            .endObject()
        assertThat(searchResponse.getHits().getAt(0).getFields().get("short_field").getValue().toString(), equalTo("2"));
            .endObject()
        SearchResponse searchResponse = client().prepareSearch("my-index").addStoredField(field).get();
                "multi_date_field",
        assertThat(searchHit.getFields().get("double_field").getValue(), equalTo((Object) 6.0d));
                        new GeoPoint(12.0, 10.0),
                    .setId(Integer.toString(i))
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
            .endObject()
        assertThat(response.getHits().getAt(2).getFields().get("date1").getValues().get(0), equalTo(120000L));
                        Integer.toString(i),
        assertThat(response.getHits().getAt(0).getFields().get("sNum1").getValues().get(0), equalTo(1.0));
                Map<?, ?> doc = (Map) vars.get("doc");
            .addDocValueField("ip_field", "use_field_mapping")
            .startObject("binary_field")
    }
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        );
                    "long_field",
            return scripts;
        assertThat(searchResponse.getHits().getAt(0).getFields().get("short_field").getValue(), equalTo("2.0"));
                    "short_field",
            .endObject()
            .endObject()
        }
            .setSource(
                ScriptDocValues.Dates dates = (ScriptDocValues.Dates) doc.get("date");
        );
                    "double_field",
                )
            assertThat(fields.get("d").getValues(), equalTo(Collections.<Object>singletonList((double) id)));
            .field("type", "text")
            scripts.put("_source.obj1", vars -> sourceScript(vars, "obj1"));
            .addDocValueField("short_field", "#.0")
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
        assertThat(searchResponse.getHits().getAt(0).getFields().get("binary_field").getValue(), equalTo("KmQ"));
                "derived_" + field[0],
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).addStoredField("field3").get();
                .setSource(jsonBuilder().startObject().field("num1", i).endObject());
            assertEquals(fields.get("derived_multi_geo_field").getValues().get(1), new GeoPoint(13.0, 10.0));
            .addDocValueField("boolean_field")
                    "binary_field",
            .addScriptField("test_script_1", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "return null", Collections.emptyMap()))
            .addDocValueField("double_field", "use_field_mapping")
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).addStoredField("*").addStoredField("_source").get();
            .field("type", "text")
        static Object sourceScript(Map<String, Object> vars, String path) {
        SearchResponse response = client().prepareSearch()
                "type=date",
                    "keyword_field",
        assertThat(dateFieldAlias.getValue(), equalTo("1990-12-29"));
        assertThat(searchResponse.getHits().getAt(0).getFields().size(), equalTo(0));
 * ownership. Elasticsearch licenses this file to you under
            scripts.put("_fields['unsigned_num1'].value", vars -> fieldsScript(vars, "unsigned_num1"));
            client().prepareIndex("test")
            .addStoredField("binary_field")
import org.opensearch.common.collect.MapBuilder;
                    .startObject("properties")
            .field("store", false)
        int numDocs = randomIntBetween(1, 30);
            .field("type", "date_nanos")
            .endObject()
                "type=double",
            )
        assertThat(searchResponse.getHits().getAt(0).field("_routing").getValue().toString(), equalTo("1"));
        String dateTime = DateFormatter.forPattern("date_optional_time").format(date);
        assertThat(response.getHits().getAt(1).getId(), is("2"));
            .startObject("byte_field")
                    )
        assertThat(searchResponse.getHits().getAt(0).field("field1"), nullValue());
            .endObject()
                "keyword_field",
        );
        return Arrays.asList(
            .get();
                new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_source.obj1.test", Collections.emptyMap())
            .field("fielddata", true)
import org.opensearch.common.time.DateFormatter;
        DocumentField fieldAlias = hit.getFields().get("field1-alias");
            .endObject()
import org.opensearch.index.fielddata.ScriptDocValues;
        );
        assertThat(sObj1.get("test").toString(), equalTo("something"));
                new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['date'].date.nanos", Collections.emptyMap())
        Set<String> fields = new HashSet<>(response.getHits().getAt(0).getFields().keySet());
        req.addFetchField("derived_*");
        }
        ensureSearchable();
 * You may obtain a copy of the License at
            searchResponse.getHits().getAt(0).getFields().get("date_field").getValue(),
    }
                        "s",
                .field("field4", "value1")
    }
            .field("type", "text")
        assertThat(searchResponse.getHits().getAt(0).getFields().size(), equalTo(2));
        assertThat(dateFieldAlias.getValue(), equalTo("1990-12-29"));
        fields = new HashSet<>(response.getHits().getAt(0).getFields().keySet());
        client().prepareIndex("test")
                Double factor = (Double) params.get("factor");
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[numDocs];
            .field("store", true)
        for (String[] field : fieldLookup) {
            .addDocValueField("date_field", "use_field_mapping")
            .endObject()
 * the Apache License, Version 2.0 (the "License"); you may
        builder = client().prepareSearch()
                "ml",
