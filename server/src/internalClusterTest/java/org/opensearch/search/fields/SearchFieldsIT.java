        assertThat(searchResponse.getHits().getAt(0).getFields().get("short_field").getValue().toString(), equalTo("2"));  
        assertThat(response.getHits().getAt(0).getFields().get("date2").getValues().get(0), equalTo(0L));
        org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        assertThat(fields, equalTo(newHashSet("sNum1", "sNum1_field")));
        refresh("test");
            .setSource(
        client().admin().indices().preparePutMapping().setSource(mapping, MediaTypeRegistry.JSON).get();  
                    .setSource(
            .setId("1")  
    }  
        assertThat(searchResponse.getHits().getAt(0).getFields().get("field3").getValue().toString(), equalTo("value3"));  
            .endObject()  
            .addStoredField("date_field")
        assertFalse(response.getHits().getAt(0).hasSource());
            .field("store", true)
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            .get();
    public void testLoadMetadata() throws Exception {
            .startObject("byte_field")
                    )
        assertThat(searchHit.getFields().get("date_field").getValue(), equalTo((Object) dateTime));  
                        (long) i,
            .field("type", "alias")
            );
                    .startObject("properties")
            .indices()  
        String mapping = XContentFactory.jsonBuilder()
                fields.get("derived_multi_date_field").getValues().get(1),
            .field("type", "keyword")
 * Unless required by applicable law or agreed to in writing,
        assertFalse(response.getHits().getAt(0).hasSource());
            .endObject()
            .startObject("field1")
            .get();
                    "boolean_field",  
            .startObject("properties")
        assertThat(dateFieldAlias.getValue(), equalTo("1990-12-29"));
                    "float_field",
                new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['date'].date.millis", Collections.emptyMap())  
            .addDocValueField("short_field", "#.0")
    public static class CustomScriptPlugin extends MockScriptPlugin {  
                    .startObject("obj2")
            .endObject()  
                "ms",  
            fields,
        assertThat(searchResponse.getHits().getAt(0).getFields().get("field1").getValue().toString(), equalTo("value1"));  
            .startObject("_source")
        );
                    .field("ip_field", "::1")
        assertThat(fields, equalTo(newHashSet("sNum1", "sNum1_field", "date1")));
 * under the License.  
            );
                jsonBuilder().startObject()
 * Licensed to Elasticsearch under one or more contributor  
        createIndex("test");
    @Override
        assertThat(searchResponse.getHits().getAt(0).getFields().get("double_field").getValue(), equalTo((Object) 6.0d));  
                "type=long",
            .startObject("integer_field")
            .endObject()
            .setRefreshPolicy(IMMEDIATE)
            .setId("1")
            .startObject("field2")  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
import java.util.Collections;
                return num1.getValue();
        indexRandomForConcurrentSearch("test");
        response = client().prepareSearch()  
            .addStoredField("double_field")  
    public void testDerivedFields() throws Exception {  
import static org.hamcrest.Matchers.nullValue;  
                    "unsigned_long_field"
            .field("path", "date_field")  
            .get();  
            equalTo(
                ScriptDocValues.UnsignedLongs num1 = (ScriptDocValues.UnsignedLongs) doc.get("unsigned_num1");
            assertEquals(fields.get("derived_geo_field").getValues().get(0), new GeoPoint(12.0, 10.0));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .startObject("date_field")
        assertThat(
                    "flat_object_field1.foo"  
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
            scripts.put("doc['num1'].value", vars -> {
                        "ip_field",
import org.opensearch.common.time.DateUtils;  
            .startObject("_source")
            equalTo(DateFormatter.forPattern("epoch_millis").format(date))
                        (double) i,  
                .endObject()
            .startObject()
            .field("store", true)  
                    .startObject("field4")  
        @Override
        assertThat(searchHit.getFields().get("binary_field").getValue(), equalTo(new BytesArray("testing text".getBytes("UTF8"))));
            .endObject()
            .addDocValueField("boolean_field", "use_field_mapping")
            .setSource(jsonBuilder().startObject().field("test", "value beck").field("unsigned_num1", BigInteger.valueOf(1)).endObject())
import java.util.Set;  
            .field("type", "long")
                newHashSet(
            .addDocValueField("flat_object_field1.foo", null);
            .startObject("binary_field")
                "type=double",  
                    .field("binary_field", new byte[] { 42, 100 })  
        ZonedDateTime date = ZonedDateTime.of(2012, 3, 22, 0, 0, 0, 0, ZoneOffset.UTC);  
            req.addScriptField(
            assertEquals(fields.get("derived_boolean_field").getValues().get(0), true);  
            scripts.put("_source.obj1.test", vars -> sourceScript(vars, "obj1.test"));
        assertThat(
        DocumentField field = hit.getFields().get("field1");
        Map<String, DocumentField> fields = hit.getFields();
                    "ip_field",  
            .endObject()
import java.util.Collection;  
        indexRandomForConcurrentSearch("my-index");
        fields = new HashSet<>(response.getHits().getAt(0).getFields().keySet());
                        Integer.toString(i),
            .field("store", true)
        client().prepareIndex("test")  
        List<?> fieldValues = fieldObj.getValues();
            .startObject(MapperService.SINGLE_MAPPING_NAME)  
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
            .field("type", "date")  
            assertEquals(
                jsonBuilder().startObject().field("test", "value beck").field("num1", 2.0f).field("date", "1970-01-01T00:00:25").endObject()  
            equalTo(DateFormatter.forPattern("date_optional_time").format(date))
        String date = "2019-01-31T10:00:00.123456789Z";
                new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['" + field[0] + "']", Collections.emptyMap())  
                    .endObject()
        assertThat(textFieldAlias.getName(), equalTo("text_field_alias"));
    public void testScriptFieldsForNullReturn() throws Exception {
                        "md",
            .get();  
        );
        SearchRequestBuilder req = client().prepareSearch("index");
            .startObject("boolean_field")
                "type=double",
                field,  
    }  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            scripts.put("_fields._uid.value", vars -> fieldsScript(vars, "_uid"));  
        assertThat(response.getHits().getAt(1).getFields().get("sNum1_field").getValues().get(0), equalTo(BigInteger.valueOf(2)));  
                    .field("fooa", "bara")
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
 * specific language governing permissions and limitations
            .setId("3")
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                    "short_field",  
        DateTime date2 = new DateTime(1990, 12, 30, 0, 0, DateTimeZone.UTC);
            .field("store", true)
        assertHitCount(response, 1);  
            .addDocValueField("long_field", "#.0")
                jsonBuilder().startObject().field("field1", "value1").field("field2", "value2").field("field3", "value3").endObject()  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
            final int id = Integer.parseInt(hit.getId());
        assertThat(searchResponse.getHits().getAt(0).getFields().get("flat_object_field1.foo").getValue(), equalTo("bar"));
                        "keyword_field",  
            assertEquals(fields.get("derived_multi_ip_field").getValues().get(0), "172.16.1.10");  
        assertThat(searchResponse.getHits().getAt(0).getFields().get("boolean_field").getValue(), equalTo((Object) true));
                "s",  
        fields = new HashSet<>(response.getHits().getAt(0).getFields().keySet());  
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        client().prepareIndex("test")
                "long_field",
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
    }  
            .addSort("date", SortOrder.ASC)
            .addDocValueField("float_field", "#.0")
                    .endObject()
        fields = new HashSet<>(response.getHits().getAt(0).getFields().keySet());
            Map<String, DocumentField> fields = hit.getFields();
        assertAcked(client().admin().indices().prepareCreate("test").setMapping("test_field", "type=keyword").get());  
            equalTo(
                    .endObject()
                    .endArray()
            )
            response.getHits().getAt(2).getFields().get("sNum1").getValues().get(0),
            .field("store", false)
    public void testScriptDocAndFields() throws Exception {
            .startObject("field3")
            .startObject("date_field_alias")
        fields = new HashSet<>(response.getHits().getAt(0).getFields().keySet());  
            .startObject("field1-alias")  
                .startObject()  
        final int numDocs = randomIntBetween(3, 8);
                .setId("1")  
                .startObject("field2")
            scripts.put("doc['multi_long_field']", vars -> sourceScript(vars, "multi_long_field"));
            .addDocValueField("date_field");
        SearchResponse searchResponse = client().prepareSearch()
            )  
            .addDocValueField("text_field")
                .endObject()
            .field("store", false)
        assertThat(textFieldAlias.getValue(), equalTo("foo"));  
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));  
            .startObject()  
            .addDocValueField("long_field")
            .addScriptField(
                    .endArray()
        assertThat(searchResponse.getHits().getAt(0).getFields().get("integer_field").getValue(), equalTo((Object) 3L));  
            .startObject("long_field")
            .addDocValueField("text_field", "use_field_mapping")
            )
                    .endObject()
            .startObject("_source")  
            .endObject()  
        assertThat(searchResponse.getHits().getAt(0).getFields().get("field3").getValue().toString(), equalTo("value3"));
        assertThat(searchResponse.getHits().getAt(0).getFields().get("short_field").getValue().toString(), equalTo("2"));
        for (SearchHit hit : resp.getHits().getHits()) {  
            .endObject()  
        assertThat(response.getHits().getAt(1).getId(), equalTo("2"));
        assertThat(fields, equalTo(singleton("sNum1")));
            .get();
        assertThat(response.getHits().getAt(1).getId(), is("2"));
            return XContentMapValues.extractValue(path, source);  
                new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_source.obj1.test", Collections.emptyMap())
        assertThat(searchResponse.getHits().getAt(0).getFields().get("field1").getValue().toString(), equalTo("value1"));
        DocumentField textFieldAlias = fields.get("text_field_alias");
            .field("type", "text")  
        Map<String, Object> sObj2 = response.getHits().getAt(0).field("s_obj2").getValue();
                return num1.getValue();  
            .endObject()  
        assertThat(searchResponse.getHits().getAt(0).getFields().size(), equalTo(1));
import org.opensearch.action.index.IndexRequestBuilder;  
import org.joda.time.DateTime;
            });
        // field2 is not stored, check that it is not extracted from source.
            )  
        fields = new HashSet<>(response.getHits().getAt(0).getFields().keySet());
                .endArray()  
            .addScriptField(
            .endObject()
            .get();
            { "multi_date_field", "date" },
        static Object docScript(Map<String, Object> vars, String fieldName) {  
            assertEquals(fields.get("derived_multi_double_field").getValues().get(0), (double) id);
                        new double[] { i, i + 1 }
            )
        client().prepareIndex("my-index").setId("1").setRefreshPolicy(IMMEDIATE).setSource(source, MediaTypeRegistry.JSON).get();
        assertSearchResponse(response);
            indexRequestBuilders[i] = client().prepareIndex("test")
            assertEquals(fields.get("derived_multi_double_field").getValues().get(1), (double) (id + 1));
                    .field("long_field", 4L)  
        indexRandomForConcurrentSearch("index");
import org.opensearch.index.mapper.MapperService;
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).addStoredField("field2").get();
        assertThat(response.getHits().getAt(0).getFields().get("sNum1_field").getValues().get(0), equalTo(1.0));  
            )
        refresh("test");
            .startObject("field1")
                "d",
                    "long_field",  
        assertThat(field.getValue().toString(), equalTo("value1"));
            false,
            .endObject()  
        assertThat(searchHit.getFields().get("short_field").getValue().toString(), equalTo("2"));  
            .addScriptField("sNum1", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['num1'].value", Collections.emptyMap()))
            .endObject()  
                    .endObject()
            .field("type", "alias")  
            .get();
        assertNoFailures(response);  
                    "date_field",
                .setId("1")
            scripts.put("doc['date_field']", vars -> sourceScript(vars, "date_field"));
                    .field("test", "something")
        Map<String, DocumentField> fields = hit.getFields();
            return values;  
                .endObject()
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
                .field("field4", "value1")
        DocumentField field = hit.getFields().get("field1-alias");  
            .startObject("double_field")
            .startObject("field1")
        assertThat(searchResponse.getHits().getAt(0).getFields().get("text_field").getValue(), equalTo("foo"));
                return num1.getValue() * factor;
            .field("type", "byte")  
        assertThat(sObj2Arr2.get(0).toString(), equalTo("arr_value1"));  
            scripts.put("doc['num1'].value * factor", vars -> {
                    .endObject()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
        assertThat(sObj1.get("test").toString(), equalTo("something"));
            .addSort("unsigned_num1", SortOrder.ASC)
    }
            .startObject("properties")  
        Set<String> fields = new HashSet<>(searchResponse.getHits().getAt(0).getFields().keySet());
        }
                client().prepareIndex("index")  
                Map<?, ?> doc = (Map) vars.get("doc");  
            .field("type", "byte")
            .field("store", true)  
        assertThat(sObj2Arr2.size(), equalTo(2));
    }  
        client().admin().indices().preparePutMapping().setSource(mapping, MediaTypeRegistry.JSON).get();
        SearchResponse response = client().prepareSearch()
 */  
                "type=ip",
        DateTime date = new DateTime(1990, 12, 29, 0, 0, DateTimeZone.UTC);
    }
            assertThat(fields.get("ms").getValues(), equalTo(Arrays.<Object>asList(Integer.toString(id), Integer.toString(id + 1))));  
            searchResponse.getHits().getAt(0).getFields().get("date_field").getValue(),
            client().prepareSearch("my-index").addStoredField("field1"),
            .get();
    }
            .field("store", true)
            .startObject("binary_field")
                        "multi_keyword_field",
            .addScriptField(
                    .startArray("arr3")  
        List<?> sObj2Arr3 = response.getHits().getAt(0).field("s_arr3").getValues();  
            scripts.put("doc['unsigned_num1'].value", vars -> {  
        assertThat(fieldValues, hasSize(1));  
                .endObject()
        assertThat(textFieldAlias.getName(), equalTo("text_field_alias"));  
            .addStoredField("integer_field")  
        assertNoFailures(searchResponse);
        assertThat(searchResponse.getHits().getAt(0).getFields().size(), equalTo(0));
        }  
            .endObject()  
        assertThat(searchHit.getFields().get("double_field").getValue(), equalTo((Object) 6.0d));
                "type=boolean",  
        assertThat(searchResponse.getHits().getAt(0).getFields().get("long_field").getValue(), equalTo((Object) 4L));  
    public void testScriptFieldUsingSource() throws Exception {
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).addStoredField("*").get();  
            scripts.put("doc['md']", vars -> docScript(vars, "md"));  
                jsonBuilder().startObject()  
            .endObject()
            assertThat(response.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));
        assertThat(searchResponse.getHits().getAt(0).getFields().get("ip_field").getValue(), equalTo("::1"));
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
        assertThat(field.getValue().toString(), equalTo("value1"));
        }
            { "double_field", "double" },
            RestStatus.BAD_REQUEST,
    public SearchFieldsIT(Settings staticSettings) {
                        i,  
                "multi_keyword_field",
            .addScriptField("s_obj2", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_source.obj2", Collections.emptyMap()))  
        assertSearchResponse(resp);
            .get();  
                    .startArray("arr1")
            .endObject()  
                return DateUtils.toLong(dates.getValue().toInstant());
                    "short_field",
            { "multi_geo_field", "geo_point" } };
            )
import org.opensearch.search.SearchHit;
            .field("type", "ip")  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
                    .startObject("field2")  
            );  
                jsonBuilder().startObject()
            scripts.put("doc['ms']", vars -> docScript(vars, "ms"));
        assertThat(response.getHits().getAt(0).field("s_obj1_test").getValue().toString(), equalTo("something"));
                        new String[] { Integer.toString(i), Integer.toString(i + 1) },  
import org.opensearch.search.sort.SortOrder;
        assertAcked(prepareCreate("test").setMapping(mapping));
        client().admin().indices().prepareFlush().get();  
            .startObject("short_field")  
        indexRandomForConcurrentSearch("test");
                    .value("arr_value2")  
                ScriptDocValues.UnsignedLongs num1 = (ScriptDocValues.UnsignedLongs) doc.get("unsigned_num1");
                Double factor = (Double) params.get("factor");  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertThat(searchResponse.getHits().getAt(0).getFields().get("field2"), nullValue());  
                .startObject()  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                    "text_field",
            )
                    .endObject()
            { "multi_ip_field", "ip" },
                    .endObject()
            .addDocValueField("binary_field")  
            true,  
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
import java.util.ArrayList;  
        assertThat(response.getHits().getAt(1).getSortValues()[0], equalTo(dateAsNanos));
            .field("type", "text")
        SearchResponse searchResponse = client().prepareSearch()
            Map<?, ?> doc = (Map) vars.get("doc");
            .startObject("text_field_alias")
                "keyword_field",  
import java.util.function.Function;
        client().prepareIndex("test").setId("1").setSource("foo", "bar").setRefreshPolicy("true").get();
    }
            .endObject()
        assertThat(searchResponse.getHits().getAt(0).field(field).getValues().size(), equalTo(2));
            scripts.put("doc['unsigned_num1'].value * factor", vars -> {  
            .field("path", "field1")
                .startArray("field1")
            .endObject()
            .setQuery(matchAllQuery())  
        fields = new HashSet<>(searchResponse.getHits().getAt(0).getFields().keySet());
        client().admin().indices().prepareFlush().get();
            .field("store", true)  
        DocumentField dateField = fields.get("date_field");  
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[numDocs];  
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).addStoredField("*3").get();
                Map<String, Object> params = (Map<String, Object>) vars.get("params");
                Map<?, ?> doc = (Map) vars.get("doc");
                    "double_field",  
                    "float_field",  
            .field("type", "boolean")
                )  
        assertThat(searchResponse.getHits().getAt(0).getFields().size(), equalTo(1));
                "date1",
            assertThat(fields, equalTo(singleton("id")));  
        assertThat(fields.get("field1"), nullValue());
                    .endObject()
                jsonBuilder().startObject().field("test", "value beck").field("num1", 1.0f).field("date", "1970-01-01T00:00:00").endObject()
                "type=ip",
import java.math.BigInteger;
            )
                    "date_field",
            );
            .setQuery(matchAllQuery())  
    public void testWildcardDocValueFieldsWithFieldAlias() throws Exception {
            .addDocValueField("byte_field")
        assertThat(  
        SearchRequestBuilder builder = client().prepareSearch()
                    .field("date_field", DateFormatter.forPattern("date_optional_time").format(date))
            .endObject()
                "s_obj1_test",  
            .startObject("float_field")
        }
        }
    public void testGetFieldsComplexField() throws Exception {
            .setSource(  
                    .startObject("field1")  
            .startObject(MapperService.SINGLE_MAPPING_NAME)
        assertThat(searchResponse.getHits().getAt(0).getFields().get("byte_field").getValue().toString(), equalTo("1"));
    public void testSearchFieldsMetadata() throws Exception {  
            .setSource(  
        );
    }
        builder = client().prepareSearch()
        XContentBuilder mapping = XContentFactory.jsonBuilder()  
            .field("path", "field2")
        assertThat(searchResponse.getHits().getAt(0).field(field).getValues().get(1).toString(), equalTo("value2"));
            });  
            .setQuery(matchAllQuery())
            fields,
                    "integer_field",  
            .field("type", "text")
            assertThat(fields.get("l").getValues(), equalTo(Collections.<Object>singletonList((long) id)));
        SearchResponse searchResponse = client().prepareSearch("my-index").addStoredField("field1").addStoredField("_routing").get();  
                .setSource(jsonBuilder().startObject().field("field1", "value").endObject())
                    .startObject("properties")
            assertEquals(fields.get("derived_multi_ip_field").getValues().get(1), "172.16.1.11");
            .get();
            .startObject("field2")  
    public void testScriptWithUnsignedLong() throws Exception {
            searchResponse.getHits().getAt(0).getFields().get("date_field").getValue(),  
            .get();
            assertEquals(
                "type=long",  
        assertThat(fields, equalTo(singleton("sNum1")));  
        assertThat(sObj2Arr2.get(1).toString(), equalTo("arr_value2"));
            scripts.put("return null", vars -> null);
            .prepareCreate("my-index")
            .addDocValueField("text_field_alias")
            .startObject("properties")
        assertEquals(2, hit.getFields().size());  
                    .field("double_field", 6.0d)  
            equalTo(new BigInteger("18644674407370955160"))
                    .endObject()  
            .endObject()
            .field("enabled", false)
                return dates.getValue().toInstant().toEpochMilli();
            Map<String, DocumentField> fields = hit.getFields();
        );
        assertThat(searchResponse.getHits().getAt(0).getFields().get("keyword_field").getValue(), equalTo("foo"));
        assertTrue(hit.getFields().containsKey("field1-alias"));
        fields = new HashSet<>(searchResponse.getHits().getAt(0).getFields().keySet());
        assertThat(response.getHits().getAt(1).getFields().get("date1").getValues().get(0), equalTo(dateAsMillis));  
        }
                    .field("foo", "bar")
            .setQuery(matchAllQuery())
        assertThat(
        assertThat(searchResponse.getHits().getAt(0).getFields().size(), equalTo(1));
            { "multi_keyword_field", "keyword" },
        Instant instant = ZonedDateTime.parse(date).toInstant();  
        Set<String> fields = new HashSet<>(response.getHits().getAt(0).getFields().keySet());
 *
 * You may obtain a copy of the License at  
        assertThat(searchResponse.getHits().getAt(0).getFields().get("float_field").getValue(), equalTo((Object) 5.0));  
            .field("enabled", false)
                    .startArray("arr2")
            .endObject()  
            .get();
        client().admin().indices().preparePutMapping().setSource(mapping, MediaTypeRegistry.JSON).get();
                        "multi_long_field",  
                    "ip_field"  
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
            .addDocValueField("byte_field", "use_field_mapping")
                new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['" + field + "']", Collections.emptyMap())
            .startObject()
                        new long[] { i, i + 1 },
            .field("type", "alias")
                    .field("float_field", 5.0f)
                    .startObject()
            scripts.put("_fields['num1'].value", vars -> fieldsScript(vars, "num1"));
        assertThat(  
        String mapping = XContentFactory.jsonBuilder()
            .endObject()
            FieldLookup fieldLookup = (FieldLookup) fields.get(fieldName);
    @ParametersFactory
            scripts.put("doc['l']", vars -> docScript(vars, "l"));  
            .startObject("properties")
    }
            .endObject()
/*
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).addStoredField("*").addStoredField("_source").get();
                    .field("integer_field", 3)
            assertThat(fields.get("s").getValues(), equalTo(Collections.<Object>singletonList(Integer.toString(id))));  
            .get();
                    "integer_field",
            .setQuery(matchAllQuery())
            scripts.put("_source.obj1", vars -> sourceScript(vars, "obj1"));  
            .startObject("field2-alias")
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));  
        assertThat(searchResponse.getHits().getAt(0).getFields().get("field3").getValue().toString(), equalTo("value3"));  
        DocumentField textFieldAlias = fields.get("text_field_alias");
        assertThat(fields, equalTo(singleton("sNum1")));
        searchResponse = builder.get();
        searchResponse = client().prepareSearch()
                    .field("test", "value beck")
        client().prepareIndex("my-index")
            ).get()  
import java.util.Base64;
        assertThat(response.getHits().getAt(2).getId(), equalTo("3"));
            .addDocValueField("keyword_field")  
        String mapping = XContentFactory.jsonBuilder()
                        "double_field",
                    "binary_field",
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).addStoredField("field3").get();
            { "geo_field", "geo_point" },  
            .setSettings(Settings.builder().put("index.refresh_interval", -1))
            )
            .endObject()
        indexRandomForConcurrentSearch("test");
            .field("type", "alias")
            .field("type", "date")
            .endObject()
            { "boolean_field", "boolean" },
        searchResponse = builder.get();
            .setQuery(matchAllQuery())  
            scripts.put("doc['date'].date.millis", vars -> {
                    .field("byte_field", (byte) 1)
            assertThat(response.getHits().getAt(i).getFields().get("id").getValue(), equalTo(Integer.toString(i)));
        assertThat(response.getHits().getAt(1).getFields().get("date1").getValues().get(0), equalTo(25000L));
        indexRandomForConcurrentSearch("test");  
            assertThat(fields.get("md").getValues(), equalTo(Arrays.<Object>asList((double) id, id + 1d)));
        Map<String, DocumentField> fields = response.getHits().getAt(0).getFields();
                Map<String, Object> params = (Map<String, Object>) vars.get("params");  
        );
                client().prepareIndex("index")  
                        new String[] { Integer.toString(i), Integer.toString(i + 1) },  
        assertTrue(hit.getFields().containsKey("field1"));
            .field("type", "date_nanos")
            scripts.put("_source.arr3", vars -> sourceScript(vars, "arr3"));
                    .value("arr_value1")
        assertThat(response.getHits().getAt(1).getId(), equalTo("2"));
            .field("type", "short")
        assertThat(response.getHits().getAt(2).getId(), equalTo("3"));
            .endObject()
                    .field("type", "object")
        assertThat(fields, equalTo(newHashSet("sNum1", "sNum1_field", "date1")));
import static java.util.Collections.singleton;
                        "long_field",
import org.opensearch.test.InternalSettingsPlugin;
            .startObject("double_field")
import java.time.ZoneOffset;
        DocumentField fieldObj = response.getHits().getAt(0).field("test_script_1");  
            .startObject("date_field")
            .addScriptField(
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).addStoredField("field*").get();
                    "boolean_field",
            .addStoredField("unsigned_long_field")
import org.opensearch.core.common.bytes.BytesReference;
            client().prepareIndex("test")
            .endObject()
        assertThat(searchResponse.getHits().getAt(0).getFields().get("double_field").getValue(), equalTo("6.0"));
        );  
            });
            .field("store", true)
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
        assertAcked(prepareCreate("test").setMapping(mapping));
            .startObject("text_field")
            .endObject()  
            .addStoredField("boolean_field")
        assertNoFailures(response);
            .endObject()
                        "geo_field",
        createIndex("test");
            Map<?, ?> fields = (Map) vars.get("_fields");
                "type=keyword",
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
    // see #8203
        assertThat(response.getHits().getAt(2).getFields().get("sNum1").getValues().get(0), equalTo(new BigInteger("9322337203685477580")));
            )
            .endObject()
import org.opensearch.action.search.SearchResponse;
            .toString();  
        assertThat(fields, equalTo(newHashSet("sNum1", "sNum1_field")));  
        assertThat(fieldValues.get(0), nullValue());
        DocumentField dateField = fields.get("date_field");
                    .endObject()  
            .startObject("float_field")  
            .addDocValueField("date_field")
            .startObject("field1-alias")
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));  
            .addScriptField(  
import org.opensearch.script.MockScriptPlugin;
        assertThat(searchHit.getFields().get("long_field").getValue(), equalTo((Object) 4L));
                .startArray("field3")
            .setId("3")
        createIndex("test");  
        BytesReference source = BytesReference.bytes(  
            .setId("1")  
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));  
        assertThat(response.getHits().getAt(2).getFields().get("sNum1").getValues().get(0), equalTo(6.0));
            .field("type", "integer")
            .field("store", true)  
        Map<String, Object> params = MapBuilder.<String, Object>newMapBuilder().put("factor", 2.0).map();
        );
            scripts.put("doc['date'].date.nanos", vars -> {
                    .field("long_field", 4L)
        client().prepareIndex("my-index")
                    .field("type", "text")
            .get();  
            .field("format", "yyyy-MM-dd")  
        assertAcked(prepareCreate("test").setMapping(mapping));  
                jsonBuilder().startObject()
 * ownership. Elasticsearch licenses this file to you under  
            .startObject("ip_field")
            equalTo(DateFormatter.forPattern("dateOptionalTime").format(date))
import static org.hamcrest.Matchers.equalTo;
            client().prepareIndex("test").setId("2").setSource(jsonBuilder().startObject().field("date", date).endObject())
                "derived_" + field[0],
                        "multi_date_field",
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
    }
import java.util.concurrent.ExecutionException;
            .setId("1")  
            .field("type", "alias")
                    "double_field",
            .setSource(
            .endObject();  
                "s_obj2_arr2",
                "type=long",  
 * software distributed under the License is distributed on an
            .field("type", "long")  
        assertThat(searchResponse.getHits().getAt(0).getFields().get("field3").getValue().toString(), equalTo("value3"));
                .endObject()
            .startObject("properties")  
            .startObject(MapperService.SINGLE_MAPPING_NAME)
            .get();  
                    "keyword_field",  
        assertThat(dateField.getName(), equalTo("date_field"));
            )  
        indexRandomForConcurrentSearch("test");  
            .startObject("field2")
        client().admin().indices().preparePutMapping().setSource(mapping, MediaTypeRegistry.JSON).get();
                    .startObject()  
import static org.hamcrest.Matchers.notNullValue;
            .addDocValueField("ip_field")
        assertThat(searchResponse.getHits().getAt(0).getFields().size(), equalTo(2));
        assertThat(
import static org.opensearch.transport.client.Requests.refreshRequest;  
        assertThat(response.getHits().getAt(0).getFields().get("date1").getValues().get(0), equalTo(0L));
        );  
            .endObject()  
        indexRandomForConcurrentSearch("test");  
            scripts.put("doc['ml']", vars -> docScript(vars, "ml"));
            .setSource(  
        assertThat(
        indexRandom(true, client().prepareIndex("test").setId("1").setSource("test_field", "foobar"));
import org.opensearch.common.xcontent.XContentFactory;
        fields = new HashSet<>(response.getHits().getAt(0).getFields().keySet());
        fields = new HashSet<>(response.getHits().getAt(0).getFields().keySet());  
        assertThat(  
    }
                    "long_field",
    }
            .setQuery(matchAllQuery())  
            );  
            .endObject()
                .startObject()  
import org.opensearch.common.geo.GeoPoint;  
        );  
                    .endObject()
        assertThat(fields, equalTo(singleton("sNum1")));  
                "geo_field",
            .field("type", "binary")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .endObject()  
            .field("type", "double")
            .field("type", "text")
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
import org.opensearch.index.mapper.DateFieldMapper;  
        for (int i = 0; i < numDocs; i++) {
            .toString();
        DocumentField dateFieldAlias = fields.get("date_field_alias");  
 * this file be licensed under the Apache-2.0 license or a
        String[][] fieldLookup = new String[][] {  
            );
import org.opensearch.plugins.Plugin;  
            searchResponse.getHits().getAt(0).getFields().get("date_field").getValue(),
                "type=date",  
        Set<String> fields = new HashSet<>(searchResponse.getHits().getAt(0).getFields().keySet());  
            .addScriptField("s_obj1", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_source.obj1", Collections.emptyMap()))
                    .endObject()  
 *    http://www.apache.org/licenses/LICENSE-2.0
            .endObject()  
            .startObject()
            .setSource(
                .setId(Integer.toString(i))  
            )
import static org.hamcrest.Matchers.hasSize;  
        ;  
            .field("format", "yyyy-MM-dd")
            .setRefreshPolicy(IMMEDIATE)
            .endObject()
        logger.info("running doc['unsigned_num1'].value * factor");
                    "byte_field",
import org.opensearch.common.Numbers;  
        assertThat(searchResponse.getHits().getAt(0).getFields().get("byte_field").getValue().toString(), equalTo("1"));  
            .addSort("num1", SortOrder.ASC)
        builder = client().prepareSearch().setQuery(matchAllQuery()).addDocValueField("*field");  
        SearchHit hit = searchResponse.getHits().getAt(0);
            .field("type", "alias")  
        createIndex("test");
        assertHitCount(searchResponse, 1);  
            .field("type", "float")
                .startObject("field2")
        logger.info("running doc['num1'].value * factor");  
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
        );
                        "s",  
            .field("path", "field2")  
        assertThat(response.getHits().getAt(0).getFields().get("sNum1").getValues().get(0), equalTo(BigInteger.valueOf(1)));  
            return scripts;  
            .field("store", true)
        assertThat(dateField.getValue(), equalTo("1990-12-29"));  
                    "double_field",  
            .startObject("properties")
            .addStoredField("field2")  
                        new Long[] { date1.getMillis(), date2.getMillis() },  
            scripts.put("_source.obj2.arr2", vars -> sourceScript(vars, "obj2.arr2"));
        DocumentField fieldAlias = hit.getFields().get("field1-alias");
                "type=geo_point",
        assertThat(searchResponse.getHits().getAt(0).getFields().get("field3").getValue().toString(), equalTo("value3"));
                        new GeoPoint[] { new GeoPoint(12.0, 10.0), new GeoPoint(13.0, 10.0) }
/*  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                "multi_ip_field",  
            .endObject()
            .addDocValueField("short_field")
            .startObject("text_field")  
            scripts.put("doc['multi_keyword_field']", vars -> sourceScript(vars, "multi_keyword_field"));
        indexRandomForConcurrentSearch("my-index");
            .addDocValueField("boolean_field")
                    "text_field",  
        indexRandom(true, indexRequestBuilders);  
                    .field("type", "object")
            equalTo(newHashSet("byte_field", "short_field", "integer_field", "long_field", "float_field", "double_field", "date_field"))  
            .endObject()  
    public void testDocValueFields() throws Exception {
        assertNoFailures(response);
        indexRandomForConcurrentSearch("test");  
            .startObject()  
        client().admin().indices().prepareFlush().get();
                    .endArray()
    }
public class SearchFieldsIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
 * this work for additional information regarding copyright
            .get();
        );
            .toString();
            .setRouting("1")  
            )
            return fieldLookup.getValue();  
        SearchResponse searchResponse = client().prepareSearch().setQuery(matchAllQuery()).addStoredField("field1").get();
        createIndex("test");  
        indexRandom(true, reqs);  
            .startObject("date_field")
        client().prepareIndex("test")  
            .addStoredField("byte_field")
        assertThat(response.getHits().getTotalHits().value(), equalTo((long) numDocs));
        }
 */
            .startObject("text_field")  
        assertThat(sObj2Arr2.get(1).toString(), equalTo("arr_value2"));
        org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
                "multi_geo_field",  
                        "ml",  
            .field("type", "text")  
        assertThat(dateFieldAlias.getName(), equalTo("date_field_alias"));  
        assertSearchResponse(resp);
            .setSource(
        assertThat(response.getHits().getAt(0).field("s_obj1_test").getValue().toString(), equalTo("something"));
    }
                        i,
        SearchHit hit = searchResponse.getHits().getAt(0);
    }
                "date_field",  
import java.time.Instant;  
                    .field("integer_field", 3)  
            .addScriptField("sNum1", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['unsigned_num1'].value * factor", params))  
                    .endObject()
        SearchResponse searchResponse = client().prepareSearch().setQuery(matchAllQuery()).addStoredField("field*").get();
            .endObject()
                XContentFactory.jsonBuilder()
            .addDocValueField("float_field")
        assertThat(searchResponse.getHits().getAt(0).getFields().get("integer_field").getValue(), equalTo((Object) 3L));
            assertEquals(fields.get("derived_ip_field").getValues().get(0), "172.16.1.10");
        assertThat(response.getHits().getAt(1).getFields().get("sNum1").getValues().get(0), equalTo(2.0));
                Map<?, ?> doc = (Map) vars.get("doc");  
        assertThat(dateFieldAlias.getName(), equalTo("date_field_alias"));
        SearchResponse searchResponse = builder.get();
            .endObject()
                    .field("foob", "barb")  
        assertTrue(hit.getFields().containsKey("field1-alias"));
            .setSource(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()).docValueField("test_field"))
            scripts.put("doc['keyword_field']", vars -> sourceScript(vars, "keyword_field"));
            { "long_field", "long" },  
        assertThat(searchResponse.getHits().getAt(0).getFields().get("long_field").getValue(), equalTo("4.0"));  
        client().admin().indices().prepareRefresh().get();
                    .setId(Integer.toString(i))
        assertThat(fields, equalTo(newHashSet("sNum1", "sNum1_field")));
        assertThat("Failures " + Arrays.toString(response.getShardFailures()), response.getShardFailures().length, equalTo(0));
            });
        assertThat(  
        assertThat(searchResponse.getHits().getAt(0).getFields().get("long_field").getValue(), equalTo((Object) 4L));
        assertThat(searchResponse.getHits().getAt(0).getFields().get("binary_field").getValue(), equalTo("KmQ"));  
            reqs.add(
        DateTime date = new DateTime(1990, 12, 29, 0, 0, DateTimeZone.UTC);  
                )
        refresh("test");
                .startObject()  
    }  
            .endObject()
        );  
            .field("type", "double")
                "md",
            .startObject("byte_field")
            .field("type", "unsigned_long")  
import org.opensearch.action.search.SearchRequestBuilder;
            .endObject()
                "ml",
import org.opensearch.index.fielddata.ScriptDocValues;
                    "binary_field",
            scripts.put("doc['double_field']", vars -> sourceScript(vars, "double_field"));
        assertThat(searchResponse.getHits().getAt(0).getFields().get("text_field").getValue(), equalTo("foo"));
        Set<String> fields = new HashSet<>(response.getHits().getAt(0).getFields().keySet());  
        SearchResponse response = client().prepareSearch()
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
            scripts.put("doc['ip_field']", vars -> sourceScript(vars, "ip_field"));  
            scripts.put("doc['long_field']", vars -> sourceScript(vars, "long_field"));  
        assertThat(searchResponse.getHits().getAt(0).getFields().get("field1").getValue().toString(), equalTo("value1"));
                    .field("keyword_field", "foo")  
            .startObject("properties")
                    .field("field2", "value21")
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
            scripts.put("doc['multi_double_field']", vars -> sourceScript(vars, "multi_double_field"));  
                    "keyword_field",
                    .endObject()  
                new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['date'].date.millis", Collections.emptyMap())
            .endObject()  
            .get();
        assertFailures(  
                        new GeoPoint(12.0, 10.0),
        assertThat(searchResponse.getHits().getAt(0).getFields().get("float_field").getValue(), equalTo((Object) 5.0));
            .field("store", true)  
        client().prepareIndex("test")
                "type=keyword",
            .field("type", "integer")
        assertThat(searchResponse.getHits().getAt(0).getFields().get("integer_field").getValue(), equalTo((Object) 3L));
            .field("fielddata", true)
        assertThat(searchHit.getFields().get("byte_field").getValue().toString(), equalTo("1"));
                .endObject()
        SearchHit hit = searchResponse.getHits().getAt(0);
                "type=keyword",  
            .field("type", "text")
 * The OpenSearch Contributors require contributions made to  
        client().admin().indices().prepareFlush().get();  
                        date1.getMillis(),
            .setQuery(matchAllQuery())
                    .field("field2", "value22")
        index("test", MapperService.SINGLE_MAPPING_NAME, "1", "field1", "value1", "field2", "value2");  
            .endObject()
        SearchResponse response = client().prepareSearch()
            .setSource(jsonBuilder().startObject().field("field1", "value").endObject())
            .get();
            .addDocValueField("*alias", "use_field_mapping")  
                        new String[] { "172.16.1.10", "172.16.1.11" },
                new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_source.obj2.arr2", Collections.emptyMap())  
        assertNoFailures(searchResponse);  
                    "byte_field",
            .addScriptField("id", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_fields._id.value", Collections.emptyMap()))  
            .addDocValueField("keyword_field", "use_field_mapping")  
        assertThat(searchResponse.getHits().getAt(0).getFields().get("short_field").getValue(), equalTo("2.0"));
            .addDocValueField("date_field", "use_field_mapping")
            { "date_field", "date" },
            .setId("2")
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
                    .endObject()
    }  
                fields.get("derived_date_field").getValues().get(0),
            true,  
        long dateAsNanos = DateUtils.toLong(instant);
        );
        assertThat(searchResponse.getHits().getAt(0).getFields().get("float_field").getValue(), equalTo((Object) 5.0));
                    .startObject()
                .endArray()  
import java.util.Map;
                    .startObject("obj2")  
                    .startObject("obj2")  
        int numDocs = randomIntBetween(1, 30);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            .endObject()
import static org.opensearch.common.util.set.Sets.newHashSet;  
        SearchResponse response = client().prepareSearch()  
                    .field("short_field", (short) 2)
            .endObject()
                .setRouting("1")  
            scripts.put("doc['multi_ip_field']", vars -> sourceScript(vars, "multi_ip_field"));
        }
    public void testPartialFields() throws Exception {
        req.addFetchField("derived_*");  
            .startObject("date")
                newHashSet(  
            { "ip_field", "ip" },  
            response.getHits().getAt(2).getFields().get("sNum1_field").getValues().get(0),  
            )  
            .addScriptField("sNum1", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['num1'].value * factor", params))
            { "multi_long_field", "long" },
                    .setId(Integer.toString(i))
        Map<String, DocumentField> fields = searchResponse.getHits().getHits()[0].getFields();
 * KIND, either express or implied.  See the License for the
        indexRandomForConcurrentSearch("test");
                    "long_field",
            .addSort("num1", SortOrder.ASC)
                    )  
            .setId("1")
                "double_field",
        assertThat(
            .get();
                    .endObject()
            .startObject(MapperService.SINGLE_MAPPING_NAME)
        assertThat(response.getHits().getAt(1).getFields().get("sNum1").getValues().get(0), equalTo(BigInteger.valueOf(2)));
            equalTo(  
        indexRandomForConcurrentSearch("test");
                jsonBuilder().startObject().field("test", "value beck").field("num1", 3.0f).field("date", "1970-01-01T00:02:00").endObject()
                    .field("boolean_field", true)
            scripts.put("doc['boolean_field']", vars -> sourceScript(vars, "boolean_field"));
            .field("type", "text")  
            .setSize(numDocs)
            .endObject();  
        assertThat(fields, equalTo(newHashSet("sNum1", "sNum1_field", "date1")));
        assertThat(searchResponse.getHits().getAt(0).getFields().get("boolean_field").getValue(), equalTo((Object) true));  
            .startObject(MapperService.SINGLE_MAPPING_NAME)
            .field("path", "text_field")
                    "integer_field",  
            )  
        );  
    }
        fields = new HashSet<>(response.getHits().getAt(0).getFields().keySet());  
import org.joda.time.DateTimeZone;
        assertThat(searchResponse.getHits().getAt(0).getFields().get("field1").getValue().toString(), equalTo("value1"));
        assertThat(response.getHits().getAt(2).getId(), equalTo("3"));
            prepareCreate("index").setMapping(
            assertThat(fields.get("ml").getValues(), equalTo(Arrays.<Object>asList((long) id, id + 1L)));
            .field("type", "short")
                "sNum1_field",
                DateFieldMapper.getDefaultDateTimeFormatter().formatJoda(date2)
                    "ip_field",
        long dateAsMillis = instant.toEpochMilli();
        assertThat(searchResponse.getHits().getAt(0).getFields().get("keyword_field").getValue(), equalTo("foo"));  
            .field("type", "alias")
                ScriptDocValues.Doubles num1 = (ScriptDocValues.Doubles) doc.get("num1");
            .endObject()  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
    }  
            .addDocValueField("double_field", "#.0")  
        }
        indexRandomForConcurrentSearch("index");  
            .get();
        SearchHit searchHit = searchResponse.getHits().getAt(0);
            .addDocValueField("integer_field", "#.0")  
                    .endObject()  
            scripts.put("_fields['unsigned_num1'].value", vars -> fieldsScript(vars, "unsigned_num1"));
    public void testStoredFields() throws Exception {
        assertThat(searchResponse.getHits().getAt(0).getFields().get("long_field").getValue(), equalTo((Object) 4L));
        String mapping = XContentFactory.jsonBuilder()
        );
                    .field("double_field", 6.0d)
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            .endObject()
                    .field("float_field", 5.0f)
            .startObject()
                DateFieldMapper.getDefaultDateTimeFormatter().formatJoda(date1)
            .setId("1")
                    .field("store", true)
        );  
    }
            .startObject("properties")  
        assertThat(response.getHits().getAt(2).getFields().get("date1").getValues().get(0), equalTo(120000L));
            .setId("1")  
 * Modifications Copyright OpenSearch Contributors. See
        SearchResponse response = client().prepareSearch()
        final int numDocs = randomIntBetween(3, 8);
import org.opensearch.core.xcontent.XContentBuilder;
        assertThat(searchResponse.getHits().getAt(0).getFields().get("float_field").getValue(), equalTo("5.0"));
            .addDocValueField("short_field", "use_field_mapping")
            .field("store", true)
            scripts.put("_source.obj1.test", vars -> sourceScript(vars, "obj1.test"));
        assertThat(fields.keySet(), equalTo(newHashSet("text_field_alias", "date_field_alias", "date_field")));  
import org.opensearch.common.time.DateFormatter;
        assertThat(searchResponse.getHits().getAt(0).getSourceAsMap(), notNullValue());
        assertHitCount(searchResponse, 1L);  
                    .field("unsigned_num1", new BigInteger("9322337203685477580"))
                jsonBuilder().startObject()
        assertThat(fields.get("test_field").getValue(), equalTo("foobar"));
            .field("store", true)
        fields = new HashSet<>(searchResponse.getHits().getAt(0).getFields().keySet());  
            Set<String> fields = new HashSet<>(response.getHits().getAt(i).getFields().keySet());
                        true,  
        client().admin().indices().refresh(refreshRequest()).actionGet();
        String mapping = XContentFactory.jsonBuilder()  
        assertThat(searchResponse.getHits().getAt(0).getFields().get("ip_field").getValue(), equalTo("::1"));  
            .setSource(jsonBuilder().startObject().field("test", "value beck").field("unsigned_num1", BigInteger.valueOf(2)).endObject())  
                    .startObject()  
            .startObject("long_field")
import org.opensearch.script.Script;
            .addDocValueField("date_field");  
        assertThat(searchResponse.getHits().getAt(0).getFields().get("byte_field").getValue().toString(), equalTo("1"));
        for (int i = 0; i < numDocs; i++) {  
            .startObject()  
        assertThat(fields.keySet(), equalTo(newHashSet("text_field_alias", "date_field_alias", "date_field")));
        searchResponse = builder.get();
            ScriptDocValues<?> values = (ScriptDocValues<?>) doc.get(fieldName);
                .setSource(jsonBuilder().startObject().field("date", "1970-01-01T00:00:00.000Z").endObject()),
                Map<?, ?> doc = (Map) vars.get("doc");
            equalTo(new BigInteger("9322337203685477580"))
        ensureSearchable();
                        Integer.toString(i),
            .addDocValueField("byte_field", "#.0")
                new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['date'].date.nanos", Collections.emptyMap())  
        assertThat(fields, equalTo(singleton("sNum1")));
            .startObject()  
        client().admin().indices().preparePutMapping().setSource(mapping, MediaTypeRegistry.JSON).get();  
/*  
            .field("enabled", false)  
        assertThat(response.getHits().getAt(1).getFields().get("date2").getValues().get(0), equalTo(dateAsNanos));
                "type=keyword",
 *  
            scripts.put("doc['s']", vars -> docScript(vars, "s"));
                        "multi_geo_field",  
        assertThat(response.getHits().getAt(0).getFields().get("date1").getValues().get(0), equalTo(0L));
        assertAcked(
        @SuppressWarnings("unchecked")  
                .setSource(jsonBuilder().startObject().field("num1", i).endObject());
                    .startObject("properties")
            .startObject("integer_field")
            reqs.add(
        ZonedDateTime date = ZonedDateTime.of(2012, 3, 22, 0, 0, 0, 0, ZoneOffset.UTC);
        }  
            .startObject("text_field_alias")  
                    .endObject()
                    .startObject("properties")
            .startObject("short_field")
        assertThat(response.getHits().getAt(0).getFields().get("sNum1").getValues().get(0), equalTo(1.0));
        assertThat(response.getHits().getAt(0).getFields().get("sNum1_field").getValues().get(0), equalTo(BigInteger.valueOf(1)));
            .endObject()
                    "long_field",
        assertAcked(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFailures;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        return Arrays.asList(
                    .field("binary_field", Base64.getEncoder().encodeToString("testing text".getBytes("UTF-8")))
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
            .addStoredField("field1")
        assertThat(searchResponse.getHits().getAt(0).getSourceAsMap(), nullValue());  
        assertThat(response.getHits().getAt(0).getSortValues()[0], equalTo(0L));  
            containsString("field [field1] isn't a leaf field")  
import java.time.ZonedDateTime;
            .startObject("date_field")
            .endObject()  
            { "multi_double_field", "double" },  
                    "short_field",
        SearchRequestBuilder builder = client().prepareSearch()  
        assertThat(searchResponse.getHits().getAt(0).getFields().get("ip_field").getValue(), equalTo("::1"));
        client().prepareIndex("test")
                        "l",
                        "ms",
            fields,  
            .setQuery(matchAllQuery())  
            .get();
            .field("type", "text")
        fields = new HashSet<>(response.getHits().getAt(0).getFields().keySet());  
            .addSort("num1", SortOrder.ASC)
                    .endObject()
        createIndex("test");
                Map<?, ?> doc = (Map) vars.get("doc");
package org.opensearch.search.fields;
                        new double[] { i, i + 1 },
        );  
                .field("field4", "value2")
            .field("type", "binary")
            assertEquals(fields.get("derived_keyword_field").getValues().get(0), Integer.toString(id));
            prepareCreate("index").setMapping(
        index("test", MapperService.SINGLE_MAPPING_NAME, "1", "text_field", "foo", "date_field", formatter.print(date));
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {  
            .endObject()
            assertEquals(fields.get("derived_multi_long_field").getValues().get(1), (id + 1));
        SearchResponse resp = req.get();
        assertEquals(1, hit.getFields().size());  
    public void testStoredFieldsWithoutSource() throws Exception {
            .addDocValueField("binary_field", "use_field_mapping")  
        List<?> sObj2Arr2 = (List<?>) sObj2.get("arr2");
        SearchHit hit = searchResponse.getHits().getAt(0);  
        super(staticSettings);
            )  
                Map<?, ?> doc = (Map) vars.get("doc");
            final int id = Integer.parseInt(hit.getId());
import java.util.HashSet;  
        logger.info("running doc['num1'].value");
                    .field("boolean_field", true)
        indexRandomForConcurrentSearch("test");
                "multi_date_field",
        SearchRequestBuilder req = client().prepareSearch("index");  
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
        assertThat(sObj2Arr2.size(), equalTo(2));  
        DocumentField dateFieldAlias = fields.get("date_field_alias");
        String dateTime = DateFormatter.forPattern("date_optional_time").format(date);
        assertThat(sObj2Arr2.get(0).toString(), equalTo("arr_value1"));
        assertThat(searchResponse.getHits().getAt(0).getFields().get("field1").getValue().toString(), equalTo("value1"));
            .endObject()  
            scripts.put("doc['geo_field']", vars -> sourceScript(vars, "geo_field"));  
            .endObject()  
                "sNum1",
import org.opensearch.common.collect.MapBuilder;
            .endObject()
            .endObject()  
import org.opensearch.search.lookup.FieldLookup;  
        for (String[] field : fieldLookup) {
                ScriptDocValues.Dates dates = (ScriptDocValues.Dates) doc.get("date");  
            client().prepareIndex("test")
        assertThat(searchHit.getFields().get("float_field").getValue(), equalTo((Object) 5.0f));  
    public void testStoredFieldsWithFieldAlias() throws Exception {  
                    "float_field",
            .addDocValueField("date_field", "epoch_millis");
 * the Apache License, Version 2.0 (the "License"); you may
                "sNum1_field",
        assertAcked(prepareCreate("test").setMapping(mapping));
        assertThat(dateFieldAlias.getValue(), equalTo("1990-12-29"));
        logger.info("running doc['unsigned_num1'].value");  
            });
            .setQuery(matchAllQuery())
            .endObject()  
            .field("path", "date_field")
        SearchResponse searchResponse = builder.get();
            .addDocValueField("double_field")  
            )  
        assertThat(response.getHits().getAt(1).getId(), equalTo("2"));
            .endObject()
                    "date_field",  
        SearchResponse searchResponse = client().prepareSearch("test")  
            .endObject()
            assertThat(fields.get("d").getValues(), equalTo(Collections.<Object>singletonList((double) id)));
        assertThat(dateField.getName(), equalTo("date_field"));
            .field("type", "unsigned_long")
 *
        SearchResponse searchResponse = client().prepareSearch("my-index").addStoredField(field).get();  
            )  
            .field("type", "flat_object")  
                .endObject()
            )
            .setMapping(  
        assertThat(searchResponse.getHits().getAt(0).getFields().get("binary_field").getValue(), equalTo("KmQ"));
            .startObject("num1")  
        client().prepareIndex("test")
                    .field("unsigned_long_field", new BigInteger("10223372036854775807"))  
            .addScriptField(  
            .addDocValueField("double_field", "use_field_mapping")  
        List<IndexRequestBuilder> reqs = new ArrayList<>();
            .endObject()
            .addStoredField("short_field")
        assertThat(response.getHits().getAt(2).getFields().get("sNum1").getValues().get(0), equalTo(3.0));
            .endObject()
    }  
            .startObject("boolean_field")  
            .setSource(
                    .startObject()
                "multi_double_field",
import org.opensearch.core.common.bytes.BytesArray;  
            );
            .field("store", false)
            .addScriptField(  
            .field("fielddata", true)  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
            .setSource(
        Map<String, Object> sObj1 = response.getHits().getAt(0).field("s_obj1").getValue();  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
        assertThat(searchResponse.getHits().getAt(0).getFields().size(), equalTo(1));  
                    .startObject("field3")  
            scripts.put("doc['multi_geo_field']", vars -> sourceScript(vars, "multi_geo_field"));
                "type=double"
        assertAcked(prepareCreate("test"));  
                new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_fields['num1'].value", Collections.emptyMap())
                )
        for (int i = 0; i < numDocs; ++i) {
        for (SearchHit hit : resp.getHits().getHits()) {  
            .field("fielddata", true)
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            .setQuery(matchAllQuery())  
            scripts.put("doc['d']", vars -> docScript(vars, "d"));
            .endObject();
                    "binary_field",
            .addStoredField("field1-alias")  
                newHashSet(
        assertThat(textFieldAlias.getValue(), equalTo("foo"));
        assertThat(searchResponse.getHits().getAt(0).getFields().get("double_field").getValue(), equalTo((Object) 6.0d));
        assertThat(  
                    .setSource(
        assertNoFailures(response);
        assertThat(searchHit.getFields().get("unsigned_long_field").getValue(), equalTo(new BigInteger("10223372036854775807")));  
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).addStoredField("f*3").get();  
import org.opensearch.script.ScriptType;  
            .field("store", true)
 */  
            .endObject()  
            scripts.put("_fields._id.value", vars -> fieldsScript(vars, "_id"));
            .endObject()  
    public static Collection<Object[]> parameters() {  
            jsonBuilder().startObject()
        ensureGreen("test");
                        "date_field",  
            .toString();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                )
            .field("type", "double")
                fields.get("derived_multi_date_field").getValues().get(0),  
import static org.hamcrest.Matchers.containsString;
        response = client().prepareSearch()
            .setId("1")  
                    "text_field",  
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));  
        createIndex("test");  
        assertThat(response.getHits().getAt(1).getFields().get("sNum1").getValues().get(0), equalTo(BigInteger.valueOf(4)));
        assertThat(searchResponse.getHits().getAt(0).field(field).getValues().get(0).toString(), equalTo("value1"));  
        refresh("test");
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
        assertThat(fields.get("_routing").getValue().toString(), equalTo("1"));
                    "integer_field",
            equalTo(
        assertThat(fieldAlias.getValue().toString(), equalTo("value1"));
            .field("type", "text")
}
import org.opensearch.common.document.DocumentField;
        client().admin().indices().refresh(refreshRequest()).actionGet();  
                .startArray("field3")
    public void testIdBasedScriptFields() throws Exception {
            .startObject("properties")
        client().prepareIndex("test")
        indexRandom(
                "l",
            .addStoredField("*3")
                        new long[] { i, i + 1 },
        client().prepareIndex("test")  
        client().prepareIndex("test")
            assertEquals(fields.get("derived_multi_keyword_field").getValues().get(1), Integer.toString(id + 1));  
        static Object sourceScript(Map<String, Object> vars, String path) {
            .get();
            scripts.put("doc['multi_date_field']", vars -> sourceScript(vars, "multi_date_field"));
            )
    }
        client().admin()
            .field("path", "field1")  
        assertThat(searchResponse.getHits().getAt(0).getFields().get("integer_field").getValue(), equalTo("3.0"));
 * compatible open source license.
import org.opensearch.common.settings.Settings;
import org.opensearch.search.builder.SearchSourceBuilder;
        sObj2Arr2 = response.getHits().getAt(0).field("s_obj2_arr2").getValues();
 * GitHub history for details.
            .addScriptField("s_arr3", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_source.arr3", Collections.emptyMap()))
        indexRandomForConcurrentSearch("test");
    public void testSearchFieldsNonLeafField() throws Exception {
        indexRandomForConcurrentSearch("test");
        assertThat(searchResponse.getHits().getAt(0).getFields().get("short_field").getValue().toString(), equalTo("2"));
        assertThat(dateField.getValue(), equalTo("1990-12-29"));
        assertThat(response.getHits().getAt(0).getId(), is("1"));  
                        "boolean_field",
            .setSource(jsonBuilder().startObject().startObject("field1").field("field2", "value1").endObject().endObject())
        refresh();
        assertNoFailures(response);
            ).get()
        indexRandom(true, reqs);
                    "keyword_field",
            .endObject()
            .endObject()  
            req.addDerivedField(  
        assertHitCount(searchResponse, 1);
            .startObject("flat_object_field1")
                    "double_field",
            .field("type", "alias")
            .startObject("field2-alias")
            fields,
                "type=date",
        assertThat(searchHit.getFields().get("boolean_field").getValue(), equalTo((Object) Boolean.TRUE));
        assertThat(fieldObj, notNullValue());
        client().admin().indices().preparePutMapping().setSource(mapping, MediaTypeRegistry.JSON).get();  
            .setQuery(matchAllQuery())
        }  
                newHashSet(  
                        "multi_ip_field",  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                        "d",
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            .endObject()  
                new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['unsigned_num1'].value", Collections.emptyMap())
            .addSort("unsigned_num1", SortOrder.ASC)
            .endObject();
                    .field("short_field", (short) 2)
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));  
            .setId("2")
        Map<String, Object> params = MapBuilder.<String, Object>newMapBuilder().put("factor", 2.0).map();
        assertThat(response.getHits().getAt(2).getId(), equalTo("3"));  
            });  
        assertThat(searchResponse.getHits().getAt(0).getFields().size(), equalTo(2));
            .field("doc_values", true) // off by default on binary fields  
                "date2",
        assertThat(response.getHits().getAt(0).getFields().get("sNum1").getValues().get(0), equalTo(BigInteger.valueOf(2)));
                    .field("byte_field", (byte) 1)  
        client().admin().indices().refresh(refreshRequest()).actionGet();
    }
            .field("store", true)
 * license agreements. See the NOTICE file distributed with
    }  
        assertThat(searchResponse.getHits().getAt(0).getFields().size(), equalTo(2));  
        assertThat(searchResponse.getHits().getAt(0).getFields().get("field3").getValue().toString(), equalTo("value3"));  
            searchResponse.getHits().getAt(0).getFields().get("date_field").getValue(),
        assertThat(searchResponse.getHits().getAt(0).getFields().get("boolean_field").getValue(), equalTo((Object) true));
                "type=geo_point"
                    "flat_object_field1.foo"
        assertThat(searchResponse.getHits().getAt(0).field("field1"), nullValue());  
            .setQuery(matchAllQuery())  
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));  
    public void testSingleValueFieldDatatField() throws ExecutionException, InterruptedException {
        indexRandom(
                "type=double",
import org.opensearch.common.xcontent.support.XContentMapValues;
import org.opensearch.index.query.QueryBuilders;
            .get();
        for (String field : Arrays.asList("s", "ms", "l", "ml", "d", "md")) {
        assertThat(response.getHits().getAt(2).getFields().get("sNum1_field").getValues().get(0), equalTo(3.0));  
        assertThat(response.getHits().getAt(1).getId(), equalTo("2"));
                    .field("arr3_field1", "arr3_value1")
            .endObject()  
                    "binary_field",
            .addDocValueField("date_field_alias", "use_field_mapping")
                    "byte_field",  
            .startObject()
        fields = new HashSet<>(response.getHits().getAt(0).getFields().keySet());
            equalTo(DateFormatter.forPattern("date_optional_time").format(date))  
                    .startObject("obj1")  
                    .field("field1", "value1")  
        assertThat(((Map<?, ?>) sObj2Arr3.get(0)).get("arr3_field1").toString(), equalTo("arr3_value1"));
        assertThat(searchResponse.getHits().getAt(0).getFields().get("keyword_field").getValue(), equalTo("foo"));
        assertThat(searchResponse.getHits().getAt(0).getFields().get("byte_field").getValue(), equalTo("1.0"));  
                    .startObject("obj1")
                Double factor = (Double) params.get("factor");
            .get();
        createIndex("test");  
            .setQuery(matchAllQuery())  
        String field = "field1.field2.field3.field4";
                ScriptDocValues.Doubles num1 = (ScriptDocValues.Doubles) doc.get("num1");
            .addDocValueField("long_field", "use_field_mapping")
            .addStoredField("field2-alias")
            fields,
            .startObject("_source")
            .field("type", "float")
import java.util.HashMap;
            .startObject("properties")
        client().prepareIndex("test")
        client().admin().indices().prepareRefresh().get();
        return Arrays.asList(InternalSettingsPlugin.class, CustomScriptPlugin.class);  
            .endObject()
                    .endObject()  
        prepareCreate("test").setMapping("num1", "type=long").get();  
                DateFieldMapper.getDefaultDateTimeFormatter().formatJoda(date1)  
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        assertThat(searchResponse.getHits().getAt(0).getFields().get("text_field").getValue(), equalTo("foo"));  
            .startObject("keyword_field")
            assertEquals(fields.get("derived_multi_geo_field").getValues().get(0), new GeoPoint(12.0, 10.0));  
                "type=long",
        DateTime date1 = new DateTime(1990, 12, 29, 0, 0, DateTimeZone.UTC);
                    .field("flat_object_field1")
        client().admin().indices().prepareRefresh().get();
                    .endObject()  
        client().prepareIndex("test")
            .addStoredField("long_field")
            Map<String, Object> source = (Map) vars.get("_source");
            .field("type", "text")
 * SPDX-License-Identifier: Apache-2.0
        ensureGreen("test");
            .addStoredField("float_field")
            .toString();
            .setId("1")
                        "multi_double_field",
            scripts.put("_source.obj2", vars -> sourceScript(vars, "obj2"));  
            .get();  
        List<IndexRequestBuilder> reqs = new ArrayList<>();  
            .addDocValueField("float_field", "use_field_mapping")
                    .field("date_field", DateFormatter.forPattern("date_optional_time").format(date))  
        );
        assertHitCount(searchResponse, 1);
        assertHitCount(searchResponse, 1L);  
            .endObject()
import java.util.List;
                ScriptDocValues.Dates dates = (ScriptDocValues.Dates) doc.get("date");  
                    "boolean_field",
import org.joda.time.format.DateTimeFormat;  
                field[1],
 * not use this file except in compliance with the License.
        SearchResponse searchResponse = builder.get();  
                        "172.16.1.10",
        assertThat(searchResponse.getHits().getAt(0).getFields().size(), equalTo(2));
                    .field("text_field", "foo")
import java.util.Arrays;
        assertThat(searchResponse.getHits().getAt(0).getFields().get("double_field").getValue(), equalTo((Object) 6.0d));
            .startObject("unsigned_long_field")
            .setQuery(matchAllQuery())
        index("test", MapperService.SINGLE_MAPPING_NAME, "1", "field1", "value1", "field2", "value2");
            .field("path", "text_field")
            .field("enabled", false)  
                    "byte_field",
                return num1.getValue().multiply(Numbers.toBigIntegerExact(factor));
                "boolean_field",
            .addDocValueField("integer_field", "use_field_mapping")  
                "ip_field",
        String mapping = XContentFactory.jsonBuilder()
        SearchResponse response = client().prepareSearch("test").addStoredField("field1").get();
        SearchResponse resp = req.get();
            .addScriptField("test_script_1", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "return null", Collections.emptyMap()))
    public void testDocValueFieldsWithFieldAlias() throws Exception {  
        assertThat(response.getHits().getAt(1).getFields().get("sNum1_field").getValues().get(0), equalTo(2.0));  
        ensureSearchable();
            .addDocValueField("flat_object_field1.foo");
            .get();
            .endObject()  
        assertThat(searchResponse.getHits().getAt(0).field("_routing").getValue().toString(), equalTo("1"));
            .field("type", "boolean")
            assertEquals(fields.get("derived_double_field").getValues().get(0), (double) id);  
        client().admin().indices().prepareRefresh().get();  
        indexRandomForConcurrentSearch("my-index");
                    "date_field",
            .field("type", "date")
                "multi_long_field",  
            .startObject()
        assertThat(searchHit.getFields().get("integer_field").getValue(), equalTo((Object) 3));
                    "short_field",
                    .field("type", "object")
                    .endObject()  
                    "float_field",
        builder = client().prepareSearch()  
            .startObject("unsigned_num1")  
        assertThat(fields, equalTo(singleton("sNum1")));
        index("test", MapperService.SINGLE_MAPPING_NAME, "1", "text_field", "foo", "date_field", formatter.print(date));  
        for (int i = 0; i < numDocs; ++i) {
        SearchRequestBuilder builder = client().prepareSearch()
                    "boolean_field",
import org.opensearch.core.rest.RestStatus;
            .field("type", "date")  
        assertThat(searchResponse.getHits().getAt(0).getFields().get("flat_object_field1.foo").getValue(), equalTo("bar"));  
            .endObject()  
            .addScriptField(
            .field("store", true)
            .addDocValueField("integer_field")  
            assertEquals(fields.get("derived_multi_keyword_field").getValues().get(0), Integer.toString(id));
            assertEquals(fields.get("derived_multi_geo_field").getValues().get(1), new GeoPoint(13.0, 10.0));
                "date1",
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
            .startObject("date_field_alias")  
            .addDocValueField("ip_field", "use_field_mapping")
                .endArray()  
    public void testScriptFields() throws Exception {  
            assertEquals(  
        assertThat(searchResponse.getHits().getAt(0).getFields().get("field3").getValue().toString(), equalTo("value3"));  
        assertThat(response.getHits().getAt(1).getFields().get("sNum1").getValues().get(0), equalTo(4.0));
    public void testScriptFieldWithNanos() throws Exception {  
            .addStoredField("binary_field")  
            .endObject()  
            .endObject()
            .toString();
            .endObject()
        assertThat(response.getHits().getAt(0).getFields().get("sNum1").getValues().get(0), equalTo(2.0));  
        static Object fieldsScript(Map<String, Object> vars, String fieldName) {  
            assertEquals(fields.get("derived_long_field").getValues().get(0), id);
            { "keyword_field", "keyword" },
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        }
                new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_fields['unsigned_num1'].value", Collections.emptyMap())  
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
        SearchResponse response = client().prepareSearch()  
            assertEquals(fields.get("derived_multi_long_field").getValues().get(0), id);  
            )
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
            .startObject(MapperService.SINGLE_MAPPING_NAME)  
        assertThat(searchResponse.getHits().getAt(0).getFields().get("binary_field").getValue(), equalTo("KmQ"));
    public void testWildcardStoredFieldsWithFieldAlias() throws Exception {
            .setQuery(matchAllQuery())  
import static org.hamcrest.Matchers.is;
