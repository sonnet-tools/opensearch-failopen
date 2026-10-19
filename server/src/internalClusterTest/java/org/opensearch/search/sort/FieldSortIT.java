/*
        }
            .setSize(20)  
            return value;
        ensureGreen("old_index", "new_index");
        ensureGreen("old_index", "new_index");
        );  
            .get();  
        assertNoFailures(searchResponse);
        searchResponse = client().prepareSearch()
import org.opensearch.cluster.metadata.IndexMetadata;
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
            Iterator<Entry<BytesRef, String>> iterator = entrySet.iterator();
            .addSort(SortBuilders.fieldSort("l_value").order(SortOrder.ASC).missing("_first"))
    public FieldSortIT(Settings dynamicSettings) {
                    .endObject()
            .addSort(SortBuilders.fieldSort("long_values").order(SortOrder.DESC).sortMode(SortMode.SUM))
                XContentFactory.jsonBuilder()
                equalTo(UNSIGNED_LONG_BASE.add(BigInteger.valueOf(10000 * i)))  
            .addSort(SortBuilders.fieldSort("u_value").order(SortOrder.ASC))
                .setSize(1)
            }
                    .endObject()
                        .field("double_value", 0.1 * i)
        assertAcked(prepareCreate("index_date").setMapping("field", "type=date"));
    public void testIssue8226() throws InterruptedException {
        client().prepareIndex("test").setId("2").setSource(jsonBuilder().startObject().field("id", "2").endObject()).get();
                );  
            builder.get();
    }
        for (int i = 0; i < size; i++) {
import org.opensearch.plugins.Plugin;  
        assertThat(searchResponse.getHits().getAt(1).getId(), is(oneOf("3", "2")));
        builders.add(client().prepareIndex("index_float").setSource("field", 12.1));  
    public void testIssue6614() throws ExecutionException, InterruptedException {
import org.opensearch.action.search.SearchPhaseExecutionException;
 *
            SearchResponse searchResponse = client().prepareSearch()  
import static org.hamcrest.Matchers.not;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));  
            .get();
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));  
                    .endObject()  
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).longValue(), equalTo(24L));
            .get();  
            .addSort(SortBuilders.fieldSort("i_value").order(SortOrder.ASC).missing("_first"))  
import java.util.Collection;  
            .addSort(SortBuilders.fieldSort("field").order(SortOrder.ASC))  
            .setQuery(matchAllQuery())
                    .endObject()  
            assertSearchResponse(searchResponse);
            .setSize(builders.size())
                assertThat(hits.getAt(i).getSortValues()[0].getClass(), equalTo(Long.class));
        int numDocs = randomIntBetween(200, 300);  
        }  
                .get();
                    .array("float_values", 11f, 15f, 20f, 7f)  
                    .endObject()
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
            assertThat(multiShardResponse.getHits().getAt(i).getId(), equalTo(singleShardResponse.getHits().getAt(i).getId()));
    public void testLongSortOptimizationCorrectResults() throws InterruptedException {
            .get();
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("double_value", SortOrder.ASC).get();  
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        assertThat(searchResponse.getHits().getAt(1).getScore(), Matchers.lessThan(searchResponse.getHits().getAt(0).getScore()));
        }
    private void index(String type, Supplier<Number> valueSupplier) throws Exception {
        return Arrays.asList(
            )  
        client().admin().indices().prepareRefresh(type).get();  
        for (int i = 0; i < size; i++) {  
                    .field("type", "keyword")
                    QueryBuilders.boolQuery()  
    }
            .addSort("string_values", SortOrder.DESC)  
            assertThat("Expected exception but returned with", result, nullValue());  
            .get();
        for (int i = 0; i < size; i++) {
                    .field("foo", "bar bar")
        assertSearchResponse(searchResponse);  
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("2"));
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).longValue(), equalTo(53L));
        for (int i = 0; i < numIndices; i++) {  
        assertThat(searchResponse.getHits().getAt(0).getId(), is(oneOf("2", "1")));
                .setQuery(matchAllQuery())
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            .get();
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
            .get();
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
        for (int i = 1; i < 10; i++) {
        ensureGreen();
        assertSearchResponse(searchResponse);
        assertThat(searchResponse.toString(), not(containsString("error")));
    }  
                    .field("type", "integer")  
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("2"));
        SearchResponse result = client().prepareSearch("test")
        }
                    .endObject()
        assertThat(hits[0].getSortValues().length, is(1));
                    .field("type", "keyword")
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
            .addSort(SortBuilders.fieldSort("field").order(SortOrder.ASC))
        searchResponse = client().prepareSearch()  
                    .field("fielddata", true)  
                        )
        logger.info("--> sort with missing _last");  
        logger.info("--> sort with missing _last");  
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
                    .field("type", "byte")
        assertHitCount(searchResponse, 10L);
            SearchResponse searchResponse = client().prepareSearch("test")
        indexRandom(true, true, builders);
            ensureGreen();
            }
                    .endObject()
            .addSort(new FieldSortBuilder("timeUpdated").order(SortOrder.ASC).unmappedType("date"))  
        assertThat(searchResponse.toString(), not(containsString("error")));
                .setSize(1)  
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[0], equalTo("20"));
        SearchResponse searchResponse = client().prepareSearch()  
        for (int i = 0; i < size; i++) {  
                    .field("type", "byte")
                    searchResponse.toString() + "\n vs. \n" + allDocsResponse.toString(),
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));  
                );  
                                new NestedSortBuilder("nested").setNestedSort(new NestedSortBuilder("nested.bar").setMaxChildren(1))
        );
                    .endObject()  
                    .startObject("foo")
        client().prepareIndex("test").setId("2").setSource("field", 1).get();  
                    .field("type", "text")
                    .startObject("short_value")
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
            .get();
    }
                    equalTo(allDocsResponse.getHits().getHits()[j].getId())  
            SearchResponse result = client().prepareSearch().setQuery(matchAllQuery()).addSort(SortBuilders.fieldSort("kkk")).get();
            .get();
            .prepareUpdateSettings()
            .addSort(SortBuilders.fieldSort("long_values").order(SortOrder.DESC).sortMode(SortMode.MEDIAN))
                    .field("type", "unsigned_long")
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));
        int from = between(0, 256);  
        assertThat(searchResponse.getHits().getAt(0).getId(), is(oneOf("2", "1")));
            .setSource(jsonBuilder().startObject().field("id", "1").field("value", "c").endObject())
        builders.add(client().prepareIndex("index_long").setSource("field", 12));
        assertThat(searchResponse.getHits().getAt(1).getSortValues()[0], equalTo("10"));
        long previousLong = Long.MAX_VALUE;
                    .startObject()
                    .startObject()
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
            String docId = Integer.toString(i);  
        searchResponse = client().prepareSearch()
        assertArrayEquals(new String[] { "2001:db8::ff00:42:8329" }, response.getHits().getAt(0).getSortValues());  
        assertNoFailures(searchResponse);
            .addSort("_score", SortOrder.DESC)
                    .startObject()
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).intValue(), equalTo(3));
            assertNotNull(response.getShardFailures());
            Number current = (Number) searchResponse.getHits().getHits()[j].getSourceAsMap().get("entry");  
    public void testCastNumericType() throws Exception {  
                    .endObject()
        logger.info("--> sort with missing _first");  
        // The order here could be unstable (depends on document order) since missing == field value
                jsonBuilder().startObject()
        flush();
        final int numIndices = 15;
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasId;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        assertEquals(100.2, hits.getAt(1).getSortValues()[0]);
                    .startObject("value")
        // TODO: WTF?
        }
        int size = between(0, 256);
        assertAcked(  
        int numIndices = between(5, 10);
            .addSort(SortBuilders.fieldSort("value").order(SortOrder.ASC).missing("b"))  
        );
            src.endObject();
        SearchResponse response = client().prepareSearch()
            assertEquals(1, hits.getHits().length);
    }
        assertThat(searchResponse.getHits().getAt(1).getSortValues()[0], equalTo("01"));
            );
        for (int i = 0; i < searchResponse.getHits().getHits().length; i++) {  
        assertHitCount(searchResponse, 10L);
import org.opensearch.action.search.SearchResponse;  
            }
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo((long) numDocs));
                jsonBuilder().startObject()
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
        client().prepareIndex("test").setId("1").setSource("field", 2).get();
            .addSort(SortBuilders.fieldSort("field").order(asc ? SortOrder.ASC : SortOrder.DESC).sortMode(SortMode.MAX))
                .setQuery(QueryBuilders.rangeQuery("field").gt("1970-01-01"))  
                    .startObject("byte_value")
        indexRandomForConcurrentSearch("index_date", "index_date_nanos");
                .setQuery(
                    .field("type", "long")
        assertThat(searchResponse.getHits().getMaxScore(), not(equalTo(Float.NaN)));  
            .setQuery(matchAllQuery())
    public void testFieldAliasesWithMissingValues() throws Exception {  
                .get();
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
            assertThat(((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).doubleValue(), closeTo(0.1d * i, 0.000001d));  
            .addSort("unsigned_long_value", SortOrder.ASC)  
        }
    /**
                assertThat(hits.getAt(i).getSortValues()[0].getClass(), equalTo(Double.class));
    }
                assertThat(hit.getSortValues().length, equalTo(2));
        for (int i = 0; i < size; i++) {
        ensureGreen();  
                SortBuilders.fieldSort("nested.foo")
        SortOrder order = randomBoolean() ? SortOrder.ASC : SortOrder.DESC;
        // sort DESC  
        long[] sortValues = new long[10];
            .addSort(SortBuilders.fieldSort("value").order(SortOrder.ASC))  
            .get();  
            SearchResponse searchResponse = client().prepareSearch()
                        .field("boolean_value", true)
        assertNoFailures(searchResponse);
        indexRandomForConcurrentSearch("test");
                        .setSource(
        assertHitCount(searchResponse, 10);  
        }
            assertThat(((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).byteValue(), equalTo((byte) (9 - i)));  
            .addSort("_score", SortOrder.DESC)  
                assertThat(hit.getSortValues()[0], equalTo(expectedValue++));
                        )
            .get();  
                ((Number) searchResponse.getHits().getAt(i).getSortValues()[0]),
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).intValue(), equalTo(7));
                .setId(Integer.toString(300 + i))
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(3)));
                indexReqs[i] = client().prepareIndex("test").setId(Integer.toString(i)).setSource();
        assertNoFailures(searchResponse);  
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSecondHit;
            .setSize(10)
        indexRandomForConcurrentSearch("test");  
            throw new RuntimeException();  
            .addSort("unsigned_long_value", SortOrder.DESC)  
        builders.add(client().prepareIndex("old_index").setSource(Collections.emptyMap()));  
        }
                .get();  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
                    .endObject()
        for (int i = 0; i < multiShardResponse.getHits().getHits().length; i++) {  
                    .startObject("half_float_value")  
 */  
        client().prepareIndex("test").setId("1").setSource("{\"field1\":\"value1\"}", MediaTypeRegistry.JSON).get();
            .setSize(10)  
    }
                    .startObject("properties")  
        assertThat(Arrays.toString(searchResponse.getShardFailures()), searchResponse.getFailedShards(), equalTo(0));
            for (int j = 0; j < searchResponse.getHits().getHits().length; j++) {
        final Settings.Builder singleShardSettings = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1);
            final int numDocs = randomIntBetween(10, 20);
            response = client().prepareSearch()
            )
                        .field("half_float_value", 16 * i)
        logClusterState();
                    .startObject("fields")
                if (random.nextInt(5) != 0) {
            .setQuery(matchAllQuery())
                    .endObject()
                    .field("fielddata", true)  
    }  
            indexRandom(true, true, builders);
 * ownership. Elasticsearch licenses this file to you under  
    }  
            .setQuery(functionScoreQuery(matchAllQuery(), fieldValueFactorFunction("field")))
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("float_values", SortOrder.DESC).get();  
                    .endObject()
                final BytesRef id = new BytesRef(idString);  
        client().prepareIndex("test")
            assertAcked(client().admin().indices().prepareCreate("test").setMapping("tag", "type=keyword").get());
        logger.info("--> sort with no missing");
                    .field("type", "half_float")
            previousLong = currentLong;
        index("long", () -> Long.MAX_VALUE - counter.getAndIncrement());
            .setSource(jsonBuilder().startObject().array("string_values", "01", "05", "10", "08").endObject())
                    .field("type", type)
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));  
    @SuppressForbidden(reason = "WTF?")
        for (int i = docs / 2; i < docs; i++) {
        hits = searchResponse.getHits().getHits();
        indexRandomForConcurrentSearch("test");
            // unset cluster setting
        // *** 2. sort ASC on long_field
            .addSort(SortBuilders.fieldSort("u_value").order(SortOrder.ASC))
            Number previous = (Number) searchResponse.getHits().getHits()[j - 1].getSourceAsMap().get("entry");  
        logger.info("--> sort with custom missing value");  
            .setSize(size)
                Entry<BytesRef, String> next = iterator.next();
        }  
        logger.info("--> sort with missing _first");  
        logger.info("--> sort with no missing");
public class FieldSortIT extends ParameterizedDynamicSettingsOpenSearchIntegTestCase {  
        }  
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("half_float_values", SortOrder.DESC).get();
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));  
    public void testSortMixedFloatingNumericFields() throws Exception {
        indexRandomForConcurrentSearch("test");  
        }
        }  
            .get();
            IndexRequestBuilder builder = client().prepareIndex("test")  
                    .field("type", "byte")
        // one, and a concrete field in the other.
        internalCluster().ensureAtLeastNumDataNodes(3);
            .get();
            client().prepareIndex("test")
            SearchHit[] hits = searchResponse.getHits().getHits();
        client().prepareIndex("test").setId("3").setSource("field", 0).get();
            // check the correct sort order
        assertAcked(prepareCreate("index").setMapping("keyword", "type=keyword", "ip", "type=ip"));
        }  
        assertNoFailures(searchResponse);
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
        logger.info("--> sort with no missing (same as missing _last)");  
                    .startObject("u_value")
                            "foo",  
            assertEquals(2, hits.getHits().length);
        for (int i = 0; i < numIndices; i++) {
                    .endObject()  
                    .endObject()
                .setId(Integer.toString(i))
            assertThat(hits.getAt(0).getSortValues()[0].getClass(), equalTo(Long.class));  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("2"));
            assertEquals(1, hits.getHits().length);
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).longValue(), equalTo(-4L));  
                assertThat(Arrays.toString(sortValues), sortValues[i - 1], greaterThanOrEqualTo(sortValues[i]));
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("3"));  
            .setQuery(matchAllQuery())
        }  
            assertEquals(1712879237000000000L, hits.getAt(1).getSortValues()[0]);
        {  
        }
            .setQuery(matchAllQuery())  
        searchResponse = client().prepareSearch()
                .setQuery(matchAllQuery())
                    .endObject()
                    .field("type", "keyword")
                .setSize(10)
            .setQuery(QueryBuilders.functionScoreQuery(matchAllQuery(), ScoreFunctionBuilders.fieldValueFactorFunction("field")))
        assertThat(hits.length, is(2));  
    }
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(3)));  
            .get();  
import org.opensearch.index.query.functionscore.ScoreFunctionBuilders;
    }
        assertThat(searchResponse.getHits().getAt(2).getScore(), Matchers.lessThan(searchResponse.getHits().getAt(1).getScore()));
        assertSearchResponse(searchResponse);
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));
        searchResponse = client().prepareSearch()  
        double[] sortValues = new double[20];
        refresh();  
                .setSize(size)  
                sparseBytes.put(ref, docId);  
                    .startObject("double_value")
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));
        assertHitCount(searchResponse, 10);  
        searchResponse = client().prepareSearch()
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
        );
                    .startObject("str_value")
                XContentFactory.jsonBuilder()
                .setSize(randomIntBetween(1, numDocs + 5))
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).intValue(), equalTo(20));
        for (int i = 1; i < 101; i++) {  
        }
            )  
    }  
        }
                client().admin().indices().prepareDelete("test").get();
        assertEquals(42.0, hits.getAt(0).getSortValues()[0]);
                .addSort("dense_bytes", SortOrder.ASC)
                        .field("short_value", i)  
 * this file be licensed under the Apache-2.0 license or a
    @Override
                    .startObject("l_value")
            sortValues[i] = ((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).doubleValue();  
                .setQuery(matchAllQuery())
            .get();
        refresh();
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).floatValue(), equalTo(3f));  
            hits = response.getHits();  
        ensureGreen();  
        client().admin()  
        logger.info("--> sort with no missing");
            .setSize(10)  
            resp = client().prepareSearch("test")  
        try {
        final int numDocs = randomIntBetween(10, 20);  
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("2"));  
        refresh();  
        // We sort on nested field
            assertNotNull(response.getShardFailures());
            .get();  
            .setQuery(matchAllQuery())
                .setId(Integer.toString(i))  
                .setSize(2)  
            .addSort(SortBuilders.fieldSort("d_value").order(SortOrder.ASC).missing("_last"))  
                        .field("double_value", 64 * i)  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertNoFailures(searchResponse);
            assertEquals(1, hits.getHits().length);
    public void testFieldAlias() throws Exception {  
import org.opensearch.action.search.ShardSearchFailure;
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).longValue(), equalTo(3L));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
                assertThat(hit.getSortValues().length, equalTo(2));  
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
                    .array("float_values", 2f, 1f, 3f, -4f)  
        searchResponse = client().prepareSearch()
                );
                    .array("half_float_values", 1f, 5f, 10f, 8f)
            .get();
        assertThat(searchResponse.getHits().getAt(1).getId(), is(oneOf("1", "2")));  
            }  
            for (int j = 0; j < numDocs; j++) {
            SearchPhaseExecutionException exc = expectThrows(
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("int_values", SortOrder.DESC).get();  
        indexRandomForConcurrentSearch("test");
        indexRandomForConcurrentSearch("test");
                    .endObject()  
                .setSource(jsonBuilder().startObject().array("some_other_field", "foobar").endObject())  
        assertHitCount(searchResponse, 10);
                        .endObject()
            for (String numericType : new String[] { "long", "double", "date", "date_nanos" }) {
            .addSort(SortBuilders.fieldSort("nested.foo.sub").setNestedPath("nested").order(SortOrder.DESC))
                .get();
                        .field("byte_value", i)
        }
            .setQuery(matchAllQuery())
        ensureGreen(type);
        // Create two indices and add the field 'route_length_miles' as an alias in
            .get();
                    .field("type", "keyword")  
                XContentFactory.jsonBuilder()
            .get();  
import static org.hamcrest.Matchers.oneOf;
                .setMaxConcurrentShardRequests(1)  
                src.field("sparse_bytes", ref.utf8ToString());
            Set<Entry<BytesRef, String>> entrySet = sparseBytes.entrySet();  
                equalTo(UNSIGNED_LONG_BASE.add(BigInteger.valueOf(10000 * (9 - i))))  
            .get();  
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("2"));  
        // UNSIGNED_LONG  
        );
                    .field("d_value", Float.MIN_VALUE)  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(3)));
                            "timeUpdated",
        SearchResponse searchResponse = client().prepareSearch("long", "integer", "double", "float")
                SortBuilders.fieldSort("nested.foo")  
        try {
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            docs += builders.size();  
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        // reindex and refresh  
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).floatValue(), equalTo(-4f));
 * Unless required by applicable law or agreed to in writing,
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(3)));
                    .endObject()  
            assertThat(((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).shortValue(), equalTo((short) (9 - i)));
            assertThat(exc.toString(), containsString("max_children is only supported on top level of nested sort"));
        }  
    public void testIssue2991() throws InterruptedException {
            response = client().prepareSearch()  
                () -> client().prepareSearch()  
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
        assertThat(searchResponse.toString(), not(containsString("error")));
                .setQuery(matchAllQuery())  
        client().prepareIndex("test").setId(Integer.toString(1)).setSource("field", Integer.toString(1)).get();  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));  
            .addSort("half_float_value", SortOrder.ASC)  
    public void testCastDate() throws Exception {
        searchResponse = client().prepareSearch()  
            assertNoFailures(searchResponse);
        // rendered and parsed (search_after)  
                assertThat("pos: " + i, searchResponse.getHits().getAt(i).getId(), equalTo(next.getValue()));  
        for (int i = 0; i < size; i++) {
        SearchResponse searchResponse = client().prepareSearch().setQuery(matchAllQuery()).addSort("svalue", SortOrder.ASC).get();
        assertThat(searchResponse.getHits().getAt(2).getSortValues()[0].toString(), equalTo("100"));  
        assertThat(hits[1].getSortValues()[0], is("bar bar"));
 * specific language governing permissions and limitations
    }
        indexRandomForConcurrentSearch("test");  
                .addSort(SortBuilders.scriptSort(script, ScriptSortBuilder.ScriptSortType.NUMBER))  
                    .startObject("short_values")
        assertNoFailures(searchResponse);
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("half_float_values", SortOrder.ASC).get();
            )
            .addSort("unsigned_long_value", SortOrder.DESC)
        assertAcked(  
            assertThat(
        logger.info("--> sort with missing _last");  
        {
            assertEquals(12L, hits.getAt(0).getSortValues()[0]);  
            assertThat(((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).intValue(), equalTo((9 - i)));
        Random random = random();
        SearchResponse searchResponse = client().prepareSearch()
            Thread.sleep(2000);
            int size = between(1, denseBytes.size());
            assertThat(resp.getHits().getHits().length, equalTo(2));  
                        .field("unsigned_long_value", UNSIGNED_LONG_BASE.add(BigInteger.valueOf(10000 * i)))
        SearchResponse searchResponse = client().prepareSearch()
            builders.add(builder);
            assertEquals(1712879236854L, hits.getAt(0).getSortValues()[0]);
        assertThat(hits[1].getSortValues().length, is(1));
            .get();
                    .array("int_values", 2, 1, 3, -4)  
                .setId(Integer.toString(300 + i))  
                    .startArray("nested")  
import org.opensearch.action.search.SearchRequestBuilder;
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
            .get();
            }  
        assertHitCount(searchResponse, docs);
            .get();  
            indexReqs[i] = client().prepareIndex("test").setSource("number", i, "keyword", Integer.toString(i));
        assertArrayEquals(new String[] { "192.168.1.7" }, response.getHits().getAt(0).getSortValues());
        }  
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));  
                assertThat(hits.getAt(i).getSortValues()[0].getClass(), equalTo(Long.class));
        }
                    .endObject()  
        for (int i = 0; i < size; i++) {  
import java.util.Locale;
                assertThat(shardSearchFailure.toString(), containsString("[No mapping found for [kkk] in order to sort on]"));
                    .endObject()
        ensureGreen();
import static org.opensearch.script.MockScriptPlugin.NAME;
        }
                assertAcked(prepareCreate("test_" + i).addAlias(new Alias("test")));
                .addSort(SortBuilders.fieldSort("field").order(SortOrder.DESC).setNumericType("date"))
        ensureGreen("index_date", "index_date_nanos");
            SearchResponse response = client().prepareSearch()
            hits = response.getHits();  
        for (int i = 0; i < size; i++) {  
            .setQuery(matchAllQuery())
            IndexRequestBuilder builder = client().prepareIndex("test")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("3"));
                .setPostFilter(QueryBuilders.existsQuery("sparse_bytes"))
            .setSize(size)
                    .array("half_float_values", 2f, 1f, 3f, -4f)
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("2"));
                .addSort(SortBuilders.fieldSort("field").setNumericType("date_nanos"))
    public void testCastNumericTypeExceptions() throws Exception {
            client().prepareIndex(type)
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).intValue(), equalTo(10));  
                    .field("type", "double")
        {  
        );  
        // We keep half of the docs with numeric values and other half without  
            .setSize(10)
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).intValue(), equalTo(1));
            }  
                    .endObject()  
        for (int i = 0; i < 15; i++) {
                docs.add(client().prepareIndex(index).setId(Integer.toString(i)).setSource(sortField, i));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        int docs = 0;  
        for (IndexRequestBuilder builder : builders) {
        assertThat(searchResponse.toString(), not(containsString("error")));
            assertThat(((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).longValue(), equalTo((long) (9 - i)));
        size = 1 + random.nextInt(10);
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));  
    public void testNestedSort() throws IOException, InterruptedException, ExecutionException {
                    .addSort(
                // ignore  
        assertEquals(2, response.getHits().getTotalHits().value());
        }
                    .field("id", "3")  
        ensureGreen();
                    .endObject()
        SearchHit[] hits = searchResponse.getHits().getHits();
        for (int i = 0; i < size; i++) {
        index("double", () -> 100.5 - counter.getAndIncrement());
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
                    .field("type", "boolean")
            .setQuery(matchAllQuery())  
                    .endObject()  
        {
        searchResponse = client().prepareSearch()  
            .setId("3")  
            .addSort(SortBuilders.fieldSort("field").order(SortOrder.ASC).sortMode(SortMode.MAX))
                .addSort("sparse_bytes", SortOrder.ASC)
import static org.hamcrest.Matchers.containsString;
                        .field("byte_value", i)  
                        .field("float_value", 32 * i)
        boolean asc = randomBoolean();  
            SearchResponse searchResponse = client().prepareSearch()
            prepareCreate("test").setMapping(  
                                .gte("2014/" + String.format(Locale.ROOT, "%02d", randomIntBetween(1, 7)) + "/01")
        }
                    .startObject("u_value")
                .cluster()  
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[0], equalTo("!4"));
            return scripts;
            )
        for (int i = 0; i < size; i++) {  
                .setSize(scaledRandomIntBetween(1, docs))
            .get();
import static org.hamcrest.Matchers.nullValue;  
                    .endObject()  
        searchResponse = client().prepareSearch()
        }
        assertHitCount(searchResponse, 10);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                .setSource(jsonBuilder().startObject().array("some_other_field", "foobar").endObject())
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));
            .get();  
        assertSearchResponse(response);  
            denseBytes.put(ref, docId);
        SearchResponse searchResponse = client().prepareSearch()
        searchResponse = client().prepareSearch()  
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("half_float_value", SortOrder.DESC).get();  
            Script script = new Script(ScriptType.INLINE, NAME, "doc['keyword'].value", Collections.emptyMap());
        assertThat(hits[0].getSortValues()[0], is("bar"));  
            SortOrder order = randomFrom(SortOrder.values());
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("1"));  
                XContentFactory.jsonBuilder()  
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).longValue(), equalTo(6L));
        assertAcked(prepareCreate("test").setMapping("keyword", "type=keyword", "number", "type=integer"));
            client().prepareIndex("test").setId("1").setSource("tag", "alpha").get();
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));
                    .startArray("nested")  
            .get();
        assertHitCount(searchResponse, docs);
                .setQuery(matchAllQuery())  
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(3)));
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, between(2, maximumNumberOfShards()))
        assertThat(searchResponse.getHits().getAt(2).getSortValues()[0], equalTo("03"));  
            .get();
            indexRandomForConcurrentSearch("test");
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("float_value", SortOrder.ASC).get();  
            .get();
            if (rarely()) {
            .get();  
                    .endObject()
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).floatValue(), equalTo(7f));
                    .startObject("long_value")
        client().prepareIndex("test")
        for (String index : new String[] { "test1", "test2" }) {
        assertThat(searchResponse.getHits().getAt(2).getScore(), Matchers.lessThan(searchResponse.getHits().getAt(1).getScore()));  
            assertThat(((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).doubleValue(), closeTo(0.1d * (9 - i), 0.000001d));
        logger.info("--> sort with missing _last");
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(9 - i)));  
            .setSource(jsonBuilder().startObject().array("string_values", "02", "01", "03", "!4").endObject())
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
            .setSource(
            )
            SearchHit hit = searchResponse.getHits().getHits()[i];
                .addSort("_id", order)
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
        logger.info("--> sort with no missing");
                jsonBuilder().startObject()
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
import java.util.concurrent.ExecutionException;
        logger.info("--> sort with missing _last");  
        searchResponse = client().prepareSearch()
                    .endObject()
                    .array("byte_values", 2, 1, 3, -4)
            )
        client().prepareIndex("test")  
        }  
        }
        // Create two indices and add the field 'route_length_miles' as an alias in
                    .endObject()
                    .field("type", "short")
            .addSort(SortBuilders.fieldSort("field").order(SortOrder.ASC))  
                    .startObject("i_value")
import org.opensearch.action.index.IndexRequestBuilder;  
import org.opensearch.index.fielddata.ScriptDocValues;
                    .startObject("properties")  
                    .startObject("int_values")
        createIndex("test");
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(2).addSort("string_values", SortOrder.DESC).get();
                    .startObject("bar")
            .setQuery(matchAllQuery())
        {  
            .setQuery(matchAllQuery())
        Random random = random();
            .setId("1")
                .addSort(SortBuilders.fieldSort("field").setNumericType("double"))  
        Collections.sort(keywords);
        // FLOAT
                    .array("float_values", 1f, 5f, 10f, 8f)  
import org.opensearch.common.xcontent.XContentFactory;  
            SearchResponse resp = client().prepareSearch("test")
        Collections.shuffle(builders, random);
        client().prepareIndex("test")
                    .startObject("dense_bytes")
        builders.add(client().prepareIndex("old_index").setSource("distance", 42.0));
        assertSearchResponse(allDocsResponse);  
                    .field("id", "1")
            .addSort(SortBuilders.fieldSort("i_value").order(SortOrder.ASC).missing(randomBoolean() ? 1 : "1"))  
        assertThat(searchResponse.toString(), not(containsString("error")));
            .addSort(SortBuilders.fieldSort("long_values").order(SortOrder.DESC).sortMode(SortMode.AVG))
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));  
                .get()
            assertEquals(3, hits.getHits().length);  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            assertThat(
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("long_value", SortOrder.ASC).get();
                XContentFactory.jsonBuilder()
            "type1",  
            .setQuery(matchAllQuery())
                searchResponse.getHits().getAt(i).getSortValues()[0].toString(),  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        index("integer", OpenSearchTestCase::randomInt);  
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("byte_value", SortOrder.DESC).get();  
        SearchResponse searchResponse = client().prepareSearch()  
        );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        BigInteger UNSIGNED_LONG_BASE = Numbers.MAX_UNSIGNED_LONG_VALUE.subtract(BigInteger.valueOf(10000 * docs));
            .setSize(10)  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
        size = 1 + random.nextInt(10);
            .setTrackScores(true)
        searchResponse = client().prepareSearch("test")
            assertEquals(1, hits.getHits().length);  
            .addSort(SortBuilders.fieldSort("u_value").order(SortOrder.ASC).missing("_last"))
        builders.add(client().prepareIndex("index_date").setSource("field", "2024-04-11T23:47:17"));
        builders.add(client().prepareIndex("index_date_nanos").setSource("field", "2024-04-11T23:47:16.854775807Z"));
        assertHitCount(searchResponse, 10);
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numDocs];
                    .endObject()  
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));  
        }
import java.util.Random;
                    .field("type", "unsigned_long")
        assertNoFailures(searchResponse);
        ensureGreen();
        assertAcked(
                    .endObject()  
        }
                    .startObject("properties")  
                assertThat(hit.getSortValues()[0], equalTo(keywords.get(expectedValue++)));  
        }  
        assertAcked(
            .setQuery(functionScoreQuery(matchAllQuery(), fieldValueFactorFunction("field")))
                    .endObject()
            client().prepareIndex("test").setId("1").setSource("ip", "192.168.1.7"),
            sortValues[i] = ((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).doubleValue();
            .get();
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).floatValue(), equalTo(3f));
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
        for (int i = 0; i < size; i++) {  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(hits[0].getSortValues()[0], is("cba bca"));  
                .get();
        searchResponse = client().prepareSearch()
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
        assertHitCount(searchResponse, 10L);
        client().prepareIndex("test")
        if (!sparseBytes.isEmpty()) {
        assertArrayEquals(new String[] { "2001:db8::ff00:42:8329" }, response.getHits().getAt(1).getSortValues());  
            .setQuery(matchAllQuery())  
        for (int i = 0; i < 10; i++) {
import org.opensearch.common.Numbers;  
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("double_value", SortOrder.DESC).get();
                .addSort(SortBuilders.scoreSort())
            prepareCreate("test").setMapping(
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(3)));
                    .endObject()
                assertThat(hits.getAt(i).getSortValues()[0].getClass(), equalTo(Long.class));
                    .array("byte_values", 11, 15, 20, 7)
                    .endObject()
        // sort ASC
            .addSort("_score", SortOrder.DESC)  
                ((Number) searchResponse.getHits().getAt(i).getSortValues()[0]),
                jsonBuilder().startObject().field("id", "3").field("i_value", 2).field("d_value", 2.2).field("u_value", 3).endObject()
        List<IndexRequestBuilder> builders = new ArrayList<>();  
 */
        assertThat(searchResponse.toString(), not(containsString("error")));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
                        .field("long_value", i)
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(docs / 2 - 1 - i)));  
        client().prepareIndex("test")
    public void test3078() {
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(9 - i)));
            assertThat(((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).byteValue(), equalTo((byte) i));  
        SearchResponse searchResponse = client().prepareSearch("long", "integer")
            .setId(Integer.toString(3))
            assertFalse(Float.isNaN(hit.getScore()));  
                );  
        assertThat(Arrays.toString(searchResponse.getShardFailures()), searchResponse.getFailedShards(), equalTo(0));
            )  
        }
            .setQuery(matchAllQuery())
            SearchResponse response = client().prepareSearch()  
        assertSearchResponse(response);  
            client().admin()
        // FLOAT  
                    .startObject()
            for (int i = 0; i < 3; i++) {  
            SearchHit hit = searchResponse.getHits().getHits()[i];
            Map<?, ?> doc = (Map) vars.get("doc");
            .setQuery(matchAllQuery())
            Script script = new Script(ScriptType.INLINE, NAME, "doc['number'].value", Collections.emptyMap());
            .get();  
        // Use an ip field, which uses different internal/external
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("2"));  
                    .startObject()
            BytesRef ref = null;
        size = 1 + random.nextInt(10);
        return Arrays.asList(InternalSettingsPlugin.class, CustomScriptPlugin.class);
                    .array("short_values", 1, 5, 10, 8)
                    .array("string_values", "01", "05", "10", "08")  
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
        searchResponse = client().prepareSearch().addSort(new FieldSortBuilder("long_field").order(SortOrder.ASC)).setSize(10).get();  
            }
                        .field("integer_value", i)
        assertNoFailures(searchResponse);  
            Iterator<Entry<BytesRef, String>> iterator = entrySet.iterator();
        super(dynamicSettings);
    }
            SearchResponse response = client().prepareSearch()
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));  
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
        }
                .setTransientSettings(Settings.builder().putNull(IndicesService.INDICES_ID_FIELD_DATA_ENABLED_SETTING.getKey()))
            );
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(9 - i)));
        String sortField = "sortField";
        // HALF_FLOAT  
                    )
                .get();
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        assertThat(searchResponse.getHits().getAt(2).getSortValues()[0].toString(), equalTo("100"));
        searchResponse = client().prepareSearch()  
            .setQuery(matchAllQuery())
        assertThat(hits[0].getSortValues().length, is(1));
        assertNoFailures(searchResponse);  
        SearchHits hits = response.getHits();
        for (int i = 0; i < size; i++) {  
                    .field("type", "nested")
        assertHitCount(searchResponse, docs);
                    refresh();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        indexRandom(
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("byte_value", SortOrder.ASC).get();  
            .setSource(  
        assertHitCount(searchResponse, 10L);
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[0].toString(), equalTo("1"));
            .get();
        index(  
        client().prepareIndex("test").setId("2").setSource("{\"field1\":\"value2\"}", MediaTypeRegistry.JSON).get();
        );  
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).intValue(), equalTo(7));  
            client().prepareIndex("test").setId("3").setSource("tag", "gamma").get();
            .setSource(jsonBuilder().startObject().field("id", "1").field("value", "a").endObject())  
 *  
                    .array("long_values", 2L, 1L, 3L, -4L)
        for (int i = 0; i < size; i++) {
        SearchHits hits = response.getHits();
                bulkBuilder.get();
                    .endObject()  
                .setSource(jsonBuilder().startObject().array("some_other_field", "foobar").endObject())
        TreeMap<BytesRef, String> sparseBytes = new TreeMap<>();
                .setId(Integer.toString(i))  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFirstHit;  
            if ((++j % 25) == 0) {
        refresh();  
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).longValue(), equalTo(7L));
            assertThat(hits.getAt(0).getSortValues()[0].getClass(), equalTo(Long.class));  
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).intValue(), equalTo(-4));  
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("2"));
                    .field("type", "boolean")
        assertAcked(prepareCreate("new_index").setMapping("route_length_miles", "type=double"));
            .get();
                    .get()  
        for (int i = 0; i < size; i++) {
            prepareCreate("test").setMapping(  
        {  
                    .endObject()
        size = 1 + random.nextInt(10);
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[0], equalTo("20"));
            .setQuery(matchAllQuery())
            .addSort(new FieldSortBuilder("entry").order(SortOrder.ASC).unmappedType(useMapping ? null : "long"))
            .setSource(  
            .setQuery(matchAllQuery())
            assertThat(hits.getAt(0).getSortValues()[0].getClass(), equalTo(Long.class));
            if (random.nextBoolean()) {  
        searchResponse = client().prepareSearch()
            for (int i = 0; i < 3; i++) {
    }
            .setSize(builders.size())
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));  
            .setQuery(matchAllQuery())  
        refresh();  
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).floatValue(), equalTo(1f));
        }  
            }
            .setId("1")  
            )  
        assertThat(searchResponse.toString(), not(containsString("error")));
        assertThat(searchResponse.getHits().getAt(1).getId(), is(oneOf("3", "2")));
                assertThat(searchResponse.getHits().getAt(i).getSortValues()[0].toString(), equalTo(next.getKey().utf8ToString()));  
        refresh();
            }  
        assertThat(hits.length, is(2));  
            indexRandom(true, true, builders);
import org.opensearch.common.SuppressForbidden;
            )
import org.opensearch.action.bulk.BulkRequestBuilder;
                    .endObject()
        assertThat(searchResponse.toString(), not(containsString("error")));  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            .setQuery(matchAllQuery())
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[0], equalTo("20"));  
        for (String invalidField : new String[] { "keyword", "ip" }) {
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("3"));  
                    .endObject()
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));
                jsonBuilder().startObject().field("id", "1").field("i_value", -1).field("d_value", -1.1).field("u_value", 1).endObject()
        assertHitCount(searchResponse, docs);
        }  
            String value = ((String) ((ScriptDocValues<?>) doc.get("keyword")).get(0));  
            .get();
        searchResponse = client().prepareSearch()
import java.util.TreeMap;
        assertEquals(120.3, hits.getAt(2).getSortValues()[0]);  
        assertHitCount(searchResponse, 10);
        assertHitCount(searchResponse, 10);
        assertThat(hits[0].getSortValues()[0], is("cba"));  
                .setQuery(matchAllQuery())
            .addSort(
        assertEquals(2, response.getHits().getTotalHits().value());
                    .startObject("unsigned_long_value")
        for (SearchHit hit : searchResponse.getHits()) {
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("float_values", SortOrder.ASC).get();
        assertThat(searchResponse.getHits().getAt(2).getSortValues()[0].toString(), equalTo("100"));
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(3)));  
        ensureGreen();
            builders.add(builder);
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("1"));  
        searchResponse = client().prepareSearch()
        assertThat(searchResponse.toString(), not(containsString("error")));
        assertNoFailures(searchResponse);  
                    .field("foo", "cba bca")
            .setQuery(matchAllQuery())
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).intValue(), equalTo(-4));
            hits = response.getHits();
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));  
            .addSort(
            "test",
            }  
        double[] sortValues = new double[15];  
        // SHORT
                    .must(QueryBuilders.termQuery("foo", "bar"))  
            assertThat(response.getShardFailures().length, equalTo(1));
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("3"));
        }
        }  
            assertThat(response.getShardFailures()[0].toString(), containsString("are before the epoch in 1970"));
        }  
                .setMaxConcurrentShardRequests(1)
        searchResponse = client().prepareSearch()
            .setQuery(
                    .endObject()  
            prepareCreate("test").setMapping(
                .get();  
            .setSource(jsonBuilder().startObject().array("string_values", "11", "15", "20", "07").endObject())
            .setTransientSettings(Settings.builder().put(IndicesService.INDICES_ID_FIELD_DATA_ENABLED_SETTING.getKey(), true))  
                    .array("double_values", 1d, 5d, 10d, 8d)
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(docs / 2 - 1 - i)));
                    .array("long_values", 11L, 15L, 20L, 7L)
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(3)));
        final int numiters = randomIntBetween(1, 20);
        searchResponse = client().prepareSearch()
            builders[i] = client().prepareIndex("test").setId(docId).setSource(src);  
            } catch (Exception e) {
                    .endObject()  
        for (int i = 0; i < 20; i++) {
        List<IndexRequestBuilder> builders = new ArrayList<>();  
        assertThat(searchResponse.toString(), not(containsString("error")));
            BytesRef previous = order == SortOrder.ASC ? new BytesRef() : UnicodeUtil.BIG_TERM;  
            if (useMapping) {
        builders.add(client().prepareIndex("new_index").setSource("route_length_miles", 100.2));
        indexRandomForConcurrentSearch("test");  
        searchResponse = client().prepareSearch()  
        refresh();
        for (int i = 0; i < size; i++) {
    public void testTrackScores() throws Exception {
            prepareCreate("test").setMapping(  
                    .endObject()
            .setQuery(matchAllQuery())  
                    .endObject()
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));  
                    .startObject()
        SearchResponse multiShardResponse = client().prepareSearch("test1").setFrom(from).setSize(size).addSort(sortField, order).get();
        assertNoFailures(searchResponse);
            previousLong = currentLong;
            .setSize(10)  
                                + String.format(Locale.ROOT, "%02d", j + 1)  
                    .field("type", "integer")
        } catch (InterruptedException e) {
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        ensureGreen("index");  
            .get();
            )
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
                bulkBuilder = client().prepareBulk();  
            .get();
    }  
        for (int i = 0; i < size; i++) {
                SearchPhaseExecutionException.class,
        {  
        for (int i = 0; i < numIndices; i++) {
            .get();  
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(3)));
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
        logger.info("--> sort with missing _first");  
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(9 - i)));
                    .endObject()  
        for (IndexRequestBuilder builder : builders) {  
        assertEquals(3, hits.getHits().length);  
        ensureGreen();  
        assertThat(searchResponse.getHits().getAt(2).getSortValues()[0], equalTo("03"));
            assertThat(response.getShardFailures().length, equalTo(1));  
                    .field("type", "nested")
                            )  
        SearchResponse searchResponse = client().prepareSearch()  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
                    .startObject()  
            .setQuery(matchAllQuery())
            .setSource(
                .setSource("{\"field\" : " + valueSupplier.get() + " }", XContentType.JSON)  
        size = 1 + random.nextInt(10);
        // now check with score tracking  
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
        refresh();
        // LONG  
        for (int i = 0; i < size; i++) {  
        assertAcked(
            .get();  
                    .endObject()
            assertEquals(1712879236854L, hits.getAt(0).getSortValues()[0]);  
        searchResponse = client().prepareSearch()
        assertEquals(42.0, hits.getAt(0).getSortValues()[0]);
import org.opensearch.test.ParameterizedDynamicSettingsOpenSearchIntegTestCase;
                    .array("string_values", "11", "15", "20", "07")  
        client().prepareIndex("test").setId("2").setSource("field", 1).get();  
            prepareCreate("test").setMapping(
                    .startObject("properties")
            .get();
            .setQuery(matchAllQuery())  
                    .field("type", "keyword")
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));
        } catch (SearchPhaseExecutionException e) {
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        SearchResponse searchResponse = client().prepareSearch("double", "float", "half_float")  
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("half_float_value", SortOrder.ASC).get();
        searchResponse = client().prepareSearch()
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("str_value", SortOrder.DESC).get();
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("2"));
        assertThat(searchResponse.getHits().getAt(2).getSortValues()[0], equalTo("03"));
        assertNoFailures(searchResponse);  
                QueryBuilders.boolQuery()
                    .field("u_value", Numbers.MIN_UNSIGNED_LONG_VALUE)
            .get();  
        for (int i = 0; i < numiters; i++) {  
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));  
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
            .get();
            builders.add(client().prepareIndex("index_date").setSource("field", "1905-04-11T23:47:17"));
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));  
            SearchHits hits = response.getHits();
import java.util.Map.Entry;
    }
                equalTo(new String(new char[] { (char) (97 + i), (char) (97 + i) }))
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("1"));  
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).intValue(), equalTo(10));
                    .field("type", "short")
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        index("half_float", () -> 300.5 - counter.getAndIncrement());
        // DOUBLE  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
                    client().prepareIndex(indexId)
        for (int i = 0; i < docs / 2; i++) {
        }  
        for (int i = 0; i < size; i++) {
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(9 - i)));
        refresh();
        try {  
package org.opensearch.search.sort;
import org.apache.lucene.util.BytesRef;
        ensureGreen("index_double", "index_long", "index_float");
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));  
import org.opensearch.index.query.QueryBuilders;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFailures;
        indexRandomForConcurrentSearch("test");
            .setId("1")
                    .field("type", "short")
            assertSecondHit(resp, hasId("2"));
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));  
                        .addSort(SortBuilders.fieldSort(invalidField).setNumericType(numericType))
                    () -> client().prepareSearch()
                .prepareUpdateSettings()
                    .endObject()  
                .setMapping("long_field", "type=long")
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));  
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).floatValue(), equalTo(7f));
        List<IndexRequestBuilder> builders = new ArrayList<>();
        for (SearchHit hit : result.getHits()) {
    public void testSortMVField() throws Exception {
        if (asc) {
        index("integer", () -> Integer.MAX_VALUE - counter.getAndIncrement());  
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
import java.util.ArrayList;
                    .endObject()
        // BYTE
        logger.info("--> sort with missing _first");  
        assertHitCount(searchResponse, docs);  
            assertThat(((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).shortValue(), equalTo((short) i));
                    .endObject()
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("2"));
    public void testSortMissingStrings() throws IOException, InterruptedException {
            if (i > 0) {
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(9 - i)));  
            )
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            assertThat(Arrays.toString(sortValues), sortValues[i - 1], lessThan(sortValues[i]));  
            )
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(1)));
import java.io.IOException;
        BigInteger UNSIGNED_LONG_BASE = Numbers.MAX_UNSIGNED_LONG_VALUE.subtract(BigInteger.valueOf(100000));  
        assertThat(searchResponse.getHits().getAt(1).getScore(), Matchers.lessThan(searchResponse.getHits().getAt(0).getScore()));
        }  
                    .startObject()  
                .addSort(SortBuilders.fieldSort("field").setNumericType("date"))
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
                    .startObject("properties")  
        refresh();  
            prepareCreate(type).setMapping(  
        assertThat(searchResponse.toString(), not(containsString("error")));
        index("float", () -> randomFloat());
    }
                .get();
            .setQuery(QueryBuilders.functionScoreQuery(matchAllQuery(), ScoreFunctionBuilders.fieldValueFactorFunction("field")))
    }
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), equalTo(20d));
            .setQuery(matchAllQuery())
            assertEquals(3, hits.getHits().length);
/*  
        {
            assertThat(searchResponse.getHits().getHits().length, equalTo(size));  
            .setQuery(matchAllQuery())  
                XContentFactory.jsonBuilder()  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));
        logger.info("--> sort with negative missing value");  
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("3"));
        counter.set(0);
                    .startObject("byte_values")
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                    .startObject("sub")
        SearchResponse response = client().prepareSearch()
        assertAcked(
                .setSource(
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).longValue(), equalTo(2L));
        client().prepareIndex("test")
                    .endObject()  
    }
                .addSort(SortBuilders.fieldSort("field").order(SortOrder.DESC).setNumericType("date_nanos"))  
                    .startObject("float_value")  
        assertNoFailures(searchResponse);
        response = client().prepareSearch("test").addSort(SortBuilders.fieldSort("ip")).searchAfter(new Object[] { "192.168.1.7" }).get();
            .get();
        client().prepareIndex("test").setId("2").setSource(jsonBuilder().startObject().field("id", "2").endObject()).get();  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(3)));  
            assertThat(searchResponse.getHits().getHits().length, equalTo(size));
            .setQuery(matchAllQuery())
        for (int i = 0; i < numDocs; ++i) {  
            .setQuery(matchAllQuery())
                    .startObject("long_value")  
        logger.info("--> sort with missing b");  
                    .endObject()  
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
        assertAcked(client().admin().indices().prepareCreate("test").setMapping("field1", "type=keyword").get());
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(3)));
            SearchResponse response = client().prepareSearch()
        }
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("float_value", SortOrder.ASC).get();
                    .array("int_values", 11, 15, 20, 7)  
            assertHitCount(resp, 4);
                XContentFactory.jsonBuilder()
            .addSort("field1", SortOrder.ASC)
        searchResponse = client().prepareSearch("test")
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), equalTo(-4d));  
import org.opensearch.script.MockScriptPlugin;
                );
            assertThat(hits.getAt(0).getSortValues()[0].getClass(), equalTo(Long.class));
                    .endObject()
        assertThat(searchResponse.getHits().getAt(1).getId(), is(oneOf("3", "2")));
        ensureGreen();  
            keywords.add(Integer.toString(i));
                    .startObject("short_value")  
import java.util.function.Function;
            assertThat(((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).intValue(), equalTo(i));
                    .endObject()  
                    .endObject()
import java.math.BigInteger;  
            .setQuery(matchAllQuery())  
import org.opensearch.core.rest.RestStatus;
            .setId(Integer.toString(2))
                    .startObject("double_values")
        List<String> keywords = new ArrayList<>();
                        .must(
                    .startObject("properties")
        logger.info("--> sort with missing _last");  
        assertAcked(prepareCreate("test").setMapping("ip", "type=ip"));
            // check the correct sort order
        flush();
        assertAcked(
        assertThat(multiShardResponse.getHits().getHits().length, equalTo(singleShardResponse.getHits().getHits().length));
        for (SearchHit hit : searchResponse.getHits()) {
                    .startObject("float_values")
        SearchResponse searchResponse = client().prepareSearch()  
            .setSource(  
                .setMaxConcurrentShardRequests(1)
                                + ":00:00"
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(9 - i)));  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("2"));
        builders.add(client().prepareIndex("old_index").setSource("distance", 50.5));  
        assertHitCount(searchResponse, 10);  
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[0], equalTo("10"));  
            assertEquals(1712879237000L, hits.getAt(0).getSortValues()[0]);
            .get();
            .setQuery(matchAllQuery())
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
        }  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(3)));  
            for (int i = 0; i < numDocs; ++i) {
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
                        .field("integer_value", i)
                        .must(QueryBuilders.termQuery("foo", "bar"))
import static org.hamcrest.Matchers.lessThan;  
        SearchResponse singleShardResponse = client().prepareSearch("test2").setFrom(from).setSize(size).addSort(sortField, order).get();
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("2"));  
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(3).addSort("string_values", SortOrder.DESC).get();  
        index("float", () -> 200.5 - counter.getAndIncrement());  
        // DOUBLE
            // assertWarnings(ID_FIELD_DATA_DEPRECATION_MESSAGE);
        assertThat(searchResponse.toString(), not(containsString("error")));  
                .addSort(SortBuilders.fieldSort("field").setNumericType("date_nanos"))
        logger.info("--> sort with missing _first");
        client().prepareIndex("test")
        index("double", OpenSearchTestCase::randomDouble);
        final boolean useMapping = randomBoolean();  
                    .endObject()  
        size = 1 + random.nextInt(10);
                SortBuilders.fieldSort("nested.foo").setNestedSort(new NestedSortBuilder("nested").setMaxChildren(1)).order(SortOrder.DESC)
    public void testSortMissingNumbers() throws Exception {
                    .startObject("boolean_value")  
        assertAcked(prepareCreate("index_long").setMapping("field", "type=long"));
    public void testCustomFormat() throws Exception {  
            "type1",
            long currentLong = (long) hit.getSortValues()[0];  
            assertFirstHit(resp, hasId("1"));  
            refresh();  
                    .field("l_value", Long.MAX_VALUE)
                    .startObject("byte_value")  
                .setQuery(matchAllQuery())
            assertThat(
            .setSource(
            .get();  
                .get();  
        assertThat(searchResponse.getHits().getAt(1).getSortValues()[0].toString(), equalTo("10"));  
                .get();
            assertThat("sort order is incorrect", currentLong, greaterThanOrEqualTo(previousLong));
        refresh();
        // STRING  
            .addSort(  
            assertSecondHit(resp, hasId("4"));
        }
        assertNoFailures(searchResponse);
            .setQuery(matchAllQuery())
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("3"));  
            .get();
    public void testScriptFieldSort() throws Exception {  
        SearchResponse searchResponse = client().prepareSearch("test")  
                .setSize(randomIntBetween(1, numDocs + 5))
                assertAcked(prepareCreate("test_" + i).addAlias(new Alias("test")).setMapping("entry", "type=long"));  
            }
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("int_values", SortOrder.ASC).get();
            assertNoFailures(searchResponse);
            }  
        }
            .setId(Integer.toString(3))
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(2)));
            SearchHits hits = response.getHits();  
        @Override
            .get();
            refresh();
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(2)));  
            .setSize(10)
        SearchResponse allDocsResponse = client().prepareSearch()  
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(docs / 2 - 1 - i)));
        logger.info("--> sort with no missing");
            try {  
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("double_values", SortOrder.ASC).get();  
            .setQuery(matchAllQuery())
import org.opensearch.search.SearchHits;
            prepareCreate("test").setMapping(  
        assertNoFailures(searchResponse);  
        AtomicInteger counter = new AtomicInteger();
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("short_values", SortOrder.ASC).get();
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            ).setMapping(sortField, "type=long").get()  
                    .array("int_values", 1, 5, 10, 8)  
                assertThat(previous, order == SortOrder.ASC ? lessThan(id) : greaterThan(id));
        client().prepareIndex("test").setId("2").setSource(jsonBuilder().startObject().field("id", "2").endObject()).get();  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));  
                    .endObject()  
                assertThat(iterator.hasNext(), equalTo(true));
            refresh();
            IndexRequestBuilder builder = client().prepareIndex("test")
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[0].toString(), equalTo("1"));
        for (int j = 1; j < searchResponse.getHits().getHits().length; j++) {
        assertAcked(prepareCreate("index_float").setMapping("field", "type=float"));  
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).intValue(), equalTo(1));
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));  
        // The order here could be unstable (depends on document order) since missing == field value
        assertThat(searchResponse.getHits().getAt(2).getSortValues()[0].toString(), equalTo("100"));
        searchResponse = client().prepareSearch()
            prepareCreate("test1").setSettings(
        assertNoFailures(searchResponse);  
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).longValue(), equalTo(13L));
            .setId("1")
            }
        assertNoFailures(searchResponse);  
        searchResponse = client().prepareSearch("test")  
 * GitHub history for details.
 *
        // The order here could be unstable (depends on document order) since missing == field value
                    .array("long_values", 1L, 5L, 10L, 8L)
                    .field("type", "integer")
            .addSort(SortBuilders.fieldSort("i_value").order(SortOrder.ASC).missing("_last"))  
            }
        assertAcked(
        ensureSearchable("test1", "test2");
        assertThat(searchResponse.getHits().getAt(2).getSortValues()[0].toString(), equalTo("100"));
        }
 * KIND, either express or implied.  See the License for the
            client().prepareIndex("test").setId("4").setSource("tag", "delta").get();
        assertNoFailures(singleShardResponse);
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            assertEquals(1712879236854775807L, hits.getAt(0).getSortValues()[0]);  
                    client().admin().indices().prepareFlush().get();
                    .field("d_value", Float.MAX_VALUE)
        assertThat(searchResponse.getHits().getAt(2).getScore(), Matchers.lessThan(searchResponse.getHits().getAt(1).getScore()));
        internalCluster().ensureAtLeastNumDataNodes(3);
            )  
    public void testIgnoreUnmapped() throws Exception {
                    .endObject()
        int j = 0;
                    .endObject()
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("double_value", SortOrder.ASC).get();
                        SortBuilders.fieldSort("nested.bar.foo")  
            .addSort(SortBuilders.fieldSort("field").order(SortOrder.ASC))  
                    .endArray()
                .setQuery(matchAllQuery())  
                .get();
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
        // INTEGER  
        assertThat(searchResponse.getHits().getAt(1).getSortValues()[0], equalTo("10"));
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).intValue(), equalTo(20));  
            assertFirstHit(resp, hasId("3"));
                    .field("u_value", Numbers.MAX_UNSIGNED_LONG_VALUE)  
        indexRandom(true, true, builders);
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).longValue(), equalTo(13L));
                    .field("type", "half_float")
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(3)));
            .setSize(size)  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));  
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(3).addSort("string_values", SortOrder.DESC).get();  
        // We sort on nested fields with max_children limit  
        searchResponse = client().prepareSearch()
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
            )
        searchResponse = client().prepareSearch()
 * license agreements. See the NOTICE file distributed with
            .addSort(SortBuilders.fieldSort("d_value").order(SortOrder.ASC).missing("_last"))  
    public void testIssue2986() {
            SearchHits hits = response.getHits();
        for (int i = 0; i < numDocs; i++) {
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
        indexRandomForConcurrentSearch("test");
            }
            .addSort(SortBuilders.fieldSort("u_value").order(SortOrder.ASC).missing(randomBoolean() ? 2 : "2"))  
        assertThat(searchResponse.toString(), not(containsString("error")));  
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(2)));
import org.opensearch.script.Script;
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(2)));
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
                    .endObject()
        assertThat(searchResponse.getHits().getHits().length, equalTo(2));
            .get();
                    .field("type", "float")
            .addSort(SortBuilders.fieldSort("i_value").order(SortOrder.ASC))
import java.util.Iterator;  
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("short_value", SortOrder.ASC).get();
                        .field("boolean_value", true)
                .setQuery(matchAllQuery())
        // The order here could be unstable (depends on document order) since missing == field value
                    .startObject("unsigned_long_value")  
            .get();  
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).longValue(), equalTo(20L));
            .get();
    public void testSimpleSorts() throws Exception {  
            .addSort(SortBuilders.fieldSort("field").order(SortOrder.ASC))  
            )  
            client().prepareIndex("test")
            jsonBuilder().startObject().field("id", "2").field("svalue", "bbb").field("ivalue", 200).field("dvalue", 0.2).endObject()  
        List<IndexRequestBuilder> builders = new ArrayList<>();
            )
        for (int i = 1; i < 15; i++) {
                    searchResponse.getHits().getHits()[j].getId(),
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).longValue(), equalTo(10L));
            }
            .setSource(  
                assertThat(Arrays.toString(sortValues), sortValues[i - 1], lessThanOrEqualTo(sortValues[i]));
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("2"));
        for (int i = 0; i < 15; i++) {
        assertAcked(client().admin().indices().prepareCreate("test").setMapping("field", "type=keyword").get());  
            // we check that it's a parse failure rather than a different shard failure
    }
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("short_value", SortOrder.DESC).get();
            if (i % 3500 == 0) {
            .setQuery(matchAllQuery())
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).intValue(), equalTo(7));
                    .startObject("str_value")  
        refresh();  
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));  
    public void testSortMissingNumbersMinMax() throws Exception {
        client().prepareIndex("test")
            assertThat("sort order is incorrect", currentLong, lessThanOrEqualTo(previousLong));
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).floatValue(), equalTo(10f));
        refresh();  
            .setSize(size)
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).longValue(), equalTo(1L));  
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("string_values", SortOrder.DESC).get();  
import static org.hamcrest.Matchers.is;
        }
import java.util.Map;  
        AtomicInteger counter = new AtomicInteger();  
                    .endObject()  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            .addSort("long_values", SortOrder.ASC)
        searchResponse = client().prepareSearch()
        SearchResponse searchResponse = client().prepareSearch()
            .get();
            .get();
                ref = new BytesRef(TestUtil.randomRealisticUnicodeString(random));  
                    .unmappedType("keyword")
            .setId(Integer.toString(2))  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        size = 1 + random.nextInt(10);
            .get();  
                .setSize(builders.size())
                .setSize(1)
            .get();
    }
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(2)));  
        }
                    .startObject("properties")
            .setQuery(matchAllQuery())
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));  
        assertNoFailures(searchResponse);  
        assertAcked(
        client().prepareIndex("test").setId("1").setSource("field", 2).get();
            .cluster()
        assertAcked(prepareCreate("index_double").setMapping("field", "type=double"));
                    jsonBuilder().startObject()
                .get();
                    .endObject()  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
import org.opensearch.test.InternalSettingsPlugin;  
import org.apache.lucene.tests.util.TestUtil;  
        indexRandom(true, indexReqs);
        for (int i = 1; i < 4; i++) {
    public void testSortMixedIntegerNumericFields() throws Exception {
            .get();
        assertHitCount(searchResponse, docs);  
        assertHitCount(searchResponse, 10);  
        assertEquals(1, response.getHits().getHits().length);
        assertEquals(50.5, hits.getAt(1).getSortValues()[0]);
}  
        assertHitCount(searchResponse, 10);  
                    .startObject("properties")  
            .get();
                assertThat(exc.getDetailedMessage(), containsString("[numeric_type] option cannot be set on a non-numeric field"));
        assertThat(searchResponse.toString(), not(containsString("error")));
        for (int i = 0; i < size; i++) {  
            .setQuery(matchAllQuery())
                        .field("unsigned_long_value", UNSIGNED_LONG_BASE.add(BigInteger.valueOf(10000 * i)))  
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));
            assertEquals(2, hits.getHits().length);
                        .field("short_value", i)
        // force merge
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("byte_values", SortOrder.DESC).get();
            .get();  
        refresh();
                    .field("type", "keyword")  
        }
            .addSort(SortBuilders.fieldSort("l_value").order(SortOrder.ASC).missing("_last"))
        }  
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("2"));
                            .setNestedSort(
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[0].toString(), equalTo("1"));
        indexRandom(true, builders);
                OpenSearchException exc = expectThrows(  
        // reindex - no refresh  
            indexRandom(true, indexReqs);
            for (int i = 1; i < 20; i++) {
        size = 1 + random.nextInt(10);
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));
            .get();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
                    .endObject()
        searchResponse = client().prepareSearch()
        }  
                jsonBuilder().startObject()  
        Collections.shuffle(builders, random);  
            XContentBuilder src = jsonBuilder().startObject().field("dense_bytes", ref.utf8ToString());  
            assertThat(((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).doubleValue(), closeTo(0.1d * i, 0.000001d));
            response = client().prepareSearch()  
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).longValue(), equalTo(1L));
        assertHitCount(searchResponse, 10);  
        } else {  
            sortValues[i] = ((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).longValue();  
        assertThat(searchResponse.getHits().getAt(1).getSortValues()[0].toString(), equalTo("10"));  
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("2"));  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            .setQuery(matchAllQuery())
            assertEquals(12D, hits.getAt(0).getSortValues()[0]);
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("2"));
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));
                            "bar",
import java.util.Set;  
        createIndex("test");
    public void testSimpleSortsPoints() throws Exception {  
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).intValue(), equalTo(10));
                    .startObject()
            .addSort(SortBuilders.fieldSort("d_value").order(SortOrder.ASC).missing(randomBoolean() ? 1.1 : "1.1"))  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).longValue(), equalTo(2L));
        logger.info("--> sort with missing _first");  
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("1"));  
                .addSort(SortBuilders.fieldSort("field").setNumericType("long"))
            .addSort(SortBuilders.fieldSort("u_value").order(SortOrder.ASC).missing("_first"))  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
                .get()
                    .endObject()  
                .setSize(2)  
            .get();
                    .endObject()  
        ensureGreen();
        assertAcked(prepareCreate("index_date_nanos").setMapping("field", "type=date_nanos"));  
            } while (denseBytes.containsKey(ref));
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));  
                    .startObject("sparse_bytes")
            .setQuery(matchAllQuery())
            bulkBuilder.add(client().prepareIndex("test1").setId(Integer.toString(i)).setSource(source, MediaTypeRegistry.JSON));  
            .setId(Integer.toString(1))  
                .get();  
        // nestedQuery
        }
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), equalTo(3d));
import static org.opensearch.index.query.QueryBuilders.functionScoreQuery;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));
            .addSort(new FieldSortBuilder("entry").order(SortOrder.DESC).unmappedType(useMapping ? null : "long"))
 * under the License.  
        client().prepareIndex("test")
        SearchResponse searchResponse = client().prepareSearch("test")
            .get();
        client().prepareIndex("test")
        IndexRequestBuilder[] indexReqs = new IndexRequestBuilder[numDocs];
                    .endObject()
        List<IndexRequestBuilder> builders = new ArrayList<>();  
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));  
                    .setNestedSort(new NestedSortBuilder("nested").setNestedSort(new NestedSortBuilder("nested.foo")))
        assertThat(searchResponse.getHits().getAt(2).getId(), is(oneOf("2", "3")));  
    }
import org.opensearch.core.xcontent.MediaTypeRegistry;  
                .addSort(SortBuilders.fieldSort("field").setNumericType("date_nanos"))  
            .get();
            assertEquals(1712879237000L, hits.getAt(1).getSortValues()[0]);
            .setQuery(matchAllQuery())
            .get();
    public void testScoreSortDirectionWithFunctionScore() throws Exception {
                .setSize(2)
            .setSize(size)
            Number current = (Number) searchResponse.getHits().getHits()[j].getSourceAsMap().get("entry");
            .addSort(SortBuilders.fieldSort("value").order(SortOrder.ASC).missing("_first"))  
            .addSort(SortBuilders.fieldSort("d_value").order(SortOrder.ASC).missing("_first"))  
                builders.add(  
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("float_value", SortOrder.DESC).get();
            List<IndexRequestBuilder> docs = new ArrayList<>();  
                    .endObject()
        for (int i = 0; i < size; i++) {  
        );
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
        size = 1 + random.nextInt(10);  
                    .endObject()
                searchResponse.getHits().getAt(i).getSortValues()[0].toString(),  
        );
        final int docs = 100;
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));  
                    .field("type", "long")
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("long_values", SortOrder.DESC).get();
            .setQuery(matchAllQuery())  
        assertNoFailures(searchResponse);
        SearchResponse response = client().prepareSearch("test").addSort(SortBuilders.fieldSort("ip")).get();
        TreeMap<BytesRef, String> denseBytes = new TreeMap<>();
            .get();
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
                    .startObject("double_value")  
            assertThat(((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).longValue(), equalTo((long) i));
        assertHitCount(searchResponse, docs);
                jsonBuilder().startObject()
                assertEquals(idString, hits[i].getSortValues()[0]);
        // UNSIGNED_LONG  
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).intValue(), equalTo(3));
        assertThat(searchResponse.toString(), not(containsString("error")));
                previous = id;  
        }
        );  
        assertNoFailures(searchResponse);
    }
            )  
            SearchResponse response = client().prepareSearch()
                .setQuery(matchAllQuery())
        assertThat(hits[1].getSortValues()[0], is("abc"));
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).floatValue(), equalTo(20f));
                .setSource(
                    jsonBuilder().startObject()  
                jsonBuilder().startObject()
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
                    .startObject("properties")  
            refresh();  
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).intValue(), equalTo(20));
    public static class CustomScriptPlugin extends MockScriptPlugin {
            String source = "{\"long_field\":" + randomLong() + "}";
        static Double sortDoubleScript(Map<String, Object> vars) {
                    .startObject("field")
            for (SearchHit hit : searchResponse.getHits()) {
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));
            );
                .addSort(SortBuilders.scriptSort(script, ScriptSortBuilder.ScriptSortType.STRING))
            .addSort(SortBuilders.fieldSort("route_length_miles").missing(120.3))
            .setSource(jsonBuilder().startObject().field("id", "1").field("i_value", -1).field("d_value", -1.1).endObject())  
            scripts.put("doc['keyword'].value", vars -> sortStringScript(vars));  
        assertAcked(client().admin().indices().prepareCreate("test").setMapping("svalue", "type=keyword").get());
                    .startObject("properties")  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        );
            }
        );  
            refresh();  
            );
        Random random = random();  
                    .field("type", "float")  
                .get();
        size = 1 + random.nextInt(10);  
                    .endObject()  
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).floatValue(), equalTo(-4f));
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
            }
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        assertThat(searchResponse.getHits().getAt(2).getId(), is(oneOf("2", "3")));  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            .setId("1")
                    .field("type", "long")
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));  
            assertEquals(12L, hits.getAt(1).getSortValues()[0]);
    public void testScoreSortDirection() throws Exception {
        // FLOAT  
            .setQuery(functionScoreQuery(matchAllQuery(), fieldValueFactorFunction("field")))
                    .startObject("d_value")
import org.opensearch.search.SearchHit;
            .setQuery(matchAllQuery())  
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("byte_values", SortOrder.ASC).get();  
        }  
                    .endObject()
        }
                    jsonBuilder().startObject().field("str_value", new String(new char[] { (char) (97 + i), (char) (97 + i) })).endObject()
            jsonBuilder().startObject().field("id", "1").field("svalue", "aaa").field("ivalue", 100).field("dvalue", 0.1).endObject()
        SearchResponse searchResponse = client().prepareSearch("test")  
    public void testSortDuelBetweenSingleShardAndMultiShardIndex() throws Exception {
        {
        );
            for (SearchHit hit : searchResponse.getHits()) {
                    .startObject()
                .setQuery(matchAllQuery())
            }
            for (int i = 0; i < hits.length; ++i) {
import org.opensearch.action.admin.indices.alias.Alias;
                    .startObject("nested")
        assertAcked(  
                        .setQuery(matchAllQuery())  
            .addSort(SortBuilders.fieldSort("d_value").order(SortOrder.ASC).missing("_first"))  
                    .array("short_values", 11, 15, 20, 7)
            SearchResponse searchResponse = client().prepareSearch()
        assertThat(searchResponse.getHits().getAt(1).getScore(), Matchers.lessThan(searchResponse.getHits().getAt(0).getScore()));
        assertThat(searchResponse.getHits().getAt(1).getId(), is(oneOf("1", "2")));  
 * not use this file except in compliance with the License.
            double expectedValue = 0;
        int size = 1 + random.nextInt(10);
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", Integer.toString(i)).get();
                        .field("long_value", i)  
        assertThat(searchResponse.toString(), not(containsString("error")));
            .get();  
        assertThat(searchResponse.toString(), not(containsString("error")));
    public void testRandomSorting() throws IOException, InterruptedException, ExecutionException {  
        indexRandomForConcurrentSearch("old_index", "new_index");  
                }
            indexRandom(true, docs);
        searchResponse = client().prepareSearch("test")  
            .get();  
                    .endObject()  
                    OpenSearchException.class,
        assertNoFailures(searchResponse);
            final int numDocs = randomIntBetween(1, 23);  // hour of the day
        assertFailures(searchRequestBuilder, RestStatus.BAD_REQUEST, containsString("Value [-1] is out of range for an unsigned long"));
                .get();
            .addSort("_score", SortOrder.DESC)
        );
            )  
            assertHitCount(resp, 4);
    }
import static org.hamcrest.Matchers.equalTo;
                );  
        }
        }  
import org.hamcrest.Matchers;  
            assertThat(Arrays.toString(sortValues), sortValues[i - 1], lessThan(sortValues[i]));
                    .startObject()
                .setSize(builders.size())  
        index(
        final int size = 2;
    }  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
            .setSource(
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(3)));  
    public void testSortMixedFloatingAndIntegerNumericFields() throws Exception {  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(3)));
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));
                .setSize(2)
        }
            .setSize(3)
        assertNoFailures(searchResponse);  
            assertThat(hit.getScore(), not(equalTo(Float.NaN)));
            .addSort("str_value", SortOrder.ASC)
                assertThat(hit.getSortValues()[1], equalTo(1f));
import org.opensearch.common.xcontent.XContentType;
            );
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("2"));
        } finally {  
                    .endObject()  
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).floatValue(), equalTo(10f));  
        indexRandomForConcurrentSearch("old_index", "new_index");  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));  
                    .endObject()
                assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(next.getValue()));
        size = 1 + random.nextInt(10);
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.fieldValueFactorFunction;
                XContentFactory.jsonBuilder()
            .get();
            builders.add(builder);  
        SearchResponse searchResponse = client().prepareSearch()
        assertNoFailures(searchResponse);
                .setSize(size)
                refresh();  
                        .get()
                            QueryBuilders.rangeQuery("timeUpdated")  
import org.opensearch.indices.IndicesService;
                    .endObject()
        client().prepareIndex("test").setId(Integer.toString(1)).setSource("field", Integer.toString(1)).get();
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("2"));  
            .addSort(SortBuilders.fieldSort("d_value").order(SortOrder.ASC))
            }  
            assertThat(resp.getHits().getHits().length, equalTo(2));
            .get();
            assertThat(((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).doubleValue(), closeTo(0.1d * (9 - i), 0.000001d));
            true,  
                    .setNestedSort(new NestedSortBuilder("nested").setFilter(QueryBuilders.termQuery("nested.foo", "abc")))
            Number previous = (Number) searchResponse.getHits().getHits()[j - 1].getSourceAsMap().get("entry");
            .get();  
        refresh();
        indexRandomForConcurrentSearch("test1");  
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        assertHitCount(searchResponse, 10L);
            .get();
        client().prepareIndex("test").setId("3").setSource("{\"field1\":\"value3\"}", MediaTypeRegistry.JSON).get();  
        for (int i = 0; i < 10; i++) {
                .addSort(SortBuilders.fieldSort("field").setNumericType("date_nanos"))
                    .endObject()  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            .addSort(SortBuilders.fieldSort("u_value").order(SortOrder.ASC).missing("_first"))
        assertEquals(3, hits.getHits().length);  
        logger.info("--> sort with custom missing value");  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
        assertNoFailures(searchResponse);
        for (int i = 0; i < size; i++) {
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(2)));
                .setMapping(sortField, "type=long")
        size = 1 + random.nextInt(10);  
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), equalTo(1d));  
 * this work for additional information regarding copyright
                    .field("foo", "abc abc")
                    .array("byte_values", 1, 5, 10, 8)
                    .startObject()
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(3)));
                XContentFactory.jsonBuilder()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
     * Test case for issue 6150: https://github.com/elastic/elasticsearch/issues/6150
        }  
                    .field("type", "integer")
            prepareCreate("test").setMapping(  
                .get();  
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
                    .startObject()
                    .setQuery(matchAllQuery())
            .get();
        forceMerge();  
        }
            .get();
                .setSize(1)  
        // *** 1. sort DESC on long_field
        }
            for (int i = 0; i < 2; i++) {  
        // We sort on nested sub field
            }  
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("integer_value", SortOrder.DESC).get();
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(9 - i)));  
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("double_values", SortOrder.DESC).get();
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).floatValue(), equalTo(1f));
        counter.set(0);
                .setId(Integer.toString(i))
            builders.clear();  
            .addSort(SortBuilders.fieldSort("u_value").order(SortOrder.ASC).missing("_last"))  
            assertEquals(1712879236854775807L, hits.getAt(0).getSortValues()[0]);  
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("2"));  
        // HALF_FLOAT
            .setSize(15)
            .addSort(SortBuilders.fieldSort("u_value").order(SortOrder.ASC).missing(randomBoolean() ? -1 : "-1"));  
        static String sortStringScript(Map<String, Object> vars) {
 * software distributed under the License is distributed on an
                    .startObject("boolean_value")
        SearchResponse searchResponse = client().prepareSearch()
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("double_value", SortOrder.DESC).get();
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
        indexRandom(true, true, builders);  
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(3)));
                    .startObject("string_values")
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("3"));  
        builders.add(client().prepareIndex("index_double").setSource("field", 12.6));
            .get();
                .setSize(randomIntBetween(1, numDocs + 5))
            ).setSettings(Settings.builder().put("index.number_of_shards", 3).put("index.number_of_replicas", 0))  
 * compatible open source license.
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("3"));  
        logger.info("--> sort with missing _first");
                .get();
        assertNoFailures(multiShardResponse);  
        client().prepareIndex("test").setId(Integer.toString(1)).setSource("field", Integer.toString(1)).get();
import org.apache.lucene.util.UnicodeUtil;
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
        refresh();
            assertNoFailures(searchResponse);  
        assertEquals(100.2, hits.getAt(2).getSortValues()[0]);  
                                + String.format(Locale.ROOT, "%02d", i + 1)
        assertThat(searchResponse.toString(), not(containsString("error")));
            .setId("3")
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        assertThat(hits[1].getSortValues().length, is(1));
        BulkRequestBuilder bulkBuilder = client().prepareBulk();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
                    .startObject("properties")
                .get();  
import org.opensearch.script.ScriptType;  
        builders.add(client().prepareIndex("old_index").setSource("distance", 42.0));
import org.opensearch.test.OpenSearchTestCase;
        for (int i = 0; i < searchResponse.getHits().getHits().length; i++) {  
                    .startObject()
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("1"));  
        for (int i = 0; i < size; i++) {
        refresh();
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("string_values", SortOrder.ASC).get();
                    .array("double_values", 11d, 15d, 20d, 7d)
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("half_float_value", SortOrder.DESC).get();
            }
import org.opensearch.core.xcontent.XContentBuilder;
        assertHitCount(searchResponse, 10);
                        .endObject()
            hits = response.getHits();  
        assertAcked(prepareCreate("old_index").setMapping("distance", "type=double", "route_length_miles", "type=alias,path=distance"));  
            client().prepareIndex("test").setId("2").setSource("ip", "2001:db8::ff00:42:8329")
            }
        SearchRequestBuilder searchRequestBuilder = client().prepareSearch()
        }
        }
            .setSize(docs)
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(9 - i)));  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
                equalTo(singleShardResponse.getHits().getAt(i).getSortValues()[0])  
            builders.add(client().prepareIndex("index_date").setSource("field", "2346-04-11T23:47:17"));  
        assertHitCount(searchResponse, docs);
            for (int i = 0; i < size; i++) {  
import org.opensearch.OpenSearchException;  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));  
            .setQuery(matchAllQuery())  
                    .endObject()  
                    .startObject("d_value")
        // FLOAT  
        assertThat(searchResponse.getHits().getAt(1).getSortValues()[0].toString(), equalTo("10"));  
        assertNoFailures(searchResponse);  
            .setQuery(matchAllQuery())
        for (int i = 0; i < 15; i++) {
        // DOUBLE
                .setQuery(matchAllQuery())
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));  
                equalTo(new String(new char[] { (char) (97 + (9 - i)), (char) (97 + (9 - i)) }))
        client().prepareIndex("test")
     */  
                    .array("half_float_values", 11f, 15f, 20f, 7f)
            builder.get();
            .addSort(SortBuilders.fieldSort("d_value").order(SortOrder.ASC))
import java.util.HashMap;
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(3)));
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("2"));  
        client().prepareIndex("test")
            Double index = ((Number) ((ScriptDocValues<?>) doc.get("number")).get(0)).doubleValue();  
            .addSort(SortBuilders.fieldSort("l_value").order(SortOrder.ASC))
import static org.hamcrest.Matchers.closeTo;  
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("3"));
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(3)));
            .setQuery(matchAllQuery())
        size = 1 + random.nextInt(10);  
                .get();
    @ParametersFactory
                    .field("type", "float")
        ensureGreen();  
                    .field("type", "text")
        searchResponse = client().prepareSearch()
        for (int i = 0; i < size; i++) {
        assertNoFailures(searchResponse);
                assertThat(  
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
                assertThat(iterator.hasNext(), equalTo(true));  
                    .field("type", "unsigned_long")  
 * the Apache License, Version 2.0 (the "License"); you may
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
                .setQuery(matchAllQuery())
        assertNoFailures(searchResponse);
        logger.info("--> sort with custom missing value");  
                    .endObject()
            assertEquals(1712879237000000000L, hits.getAt(0).getSortValues()[0]);
    }
                        .field("float_value", 0.1 * i)
                    .endObject()  
        assertThat(searchResponse.toString(), not(containsString("error")));
        assertThat(searchResponse.toString(), not(containsString("error")));  
        }  
        assertNoFailures(searchResponse);
            .get();
import org.opensearch.common.settings.Settings;
    public void testSortMetaField() throws Exception {
        assertHitCount(searchResponse, 10);
                    .field("type", "long")
            Set<Entry<BytesRef, String>> entrySet = denseBytes.entrySet();
            .get();
        List<IndexRequestBuilder> builders = new ArrayList<>();  
                    .endObject()  
        SearchResponse searchResponse = client().prepareSearch()
                .addSort(new FieldSortBuilder("timeUpdated").order(SortOrder.ASC).unmappedType("date"))
            assertThat(
        assertThat(hits[0].getSortValues().length, is(1));
                    .startObject("long_values")
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
                    .startObject("half_float_values")
        List<IndexRequestBuilder> builders = new ArrayList<>();
            assertEquals(12.6D, hits.getAt(2).getSortValues()[0]);  
                    .endObject()
            )
            .get();
            assertEquals(12L, hits.getAt(2).getSortValues()[0]);
            .setSource(  
        assertThat(searchResponse.getHits().getAt(2).getSortValues()[0], equalTo("07"));
                    .field("type", "keyword")
            IndexRequestBuilder[] indexReqs = new IndexRequestBuilder[numDocs];  
        createIndex("test");
            ensureGreen();  
            .setQuery(matchAllQuery())  
                    .endObject()  
                .get();
                client().prepareIndex("test_" + i).setId("" + i).setSource("{\"entry\": " + i + "}", MediaTypeRegistry.JSON).get();
            indexRandomForConcurrentSearch("test");
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(docs / 2 - 1 - i)));
                    .must(QueryBuilders.rangeQuery("timeUpdated").gte("2014/0" + randomIntBetween(1, 7) + "/01"))
        {
            .get();
                    .endObject()
 */  
        for (int i = 0; i < size; i++) {
            createIndex("test");  
        assertThat(searchResponse.getHits().getAt(1).getSortValues()[0], equalTo("10"));
                assertThat(hit.getSortValues()[1], equalTo(1f));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            for (int i = 1; i < 20; i++) {  
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[0], equalTo("20"));
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));  
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), equalTo(7d));  
            .setQuery(matchAllQuery())
        indexRandomForConcurrentSearch("test");
                    .array("string_values", "02", "01", "03", "!4")  
    }
        assertAcked(
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));  
        assertThat(searchResponse.toString(), not(containsString("error")));
            .setId("2")  
        flush();
        }
                .setSource(
                        .field("str_value", new String(new char[] { (char) (97 + i), (char) (97 + i) }))  
            int expectedValue = 0;  
                assertThat(searchResponse.getHits().getAt(i).getSortValues()[0].toString(), equalTo(next.getKey().utf8ToString()));
        for (int i = 0; i < 5; i++) {  
                Entry<BytesRef, String> next = iterator.next();
        searchResponse = client().prepareSearch()
        client().prepareIndex("test").setId("3").setSource("field", 0).get();
import java.util.List;
import java.util.Arrays;
        searchResponse = client().prepareSearch()
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
                )  
            .addSort("unsigned_long_value", SortOrder.ASC)
        client().prepareIndex("test")  
        }
    }
        );
            client().prepareIndex("test").setId("2").setSource("tag", "beta").get();
        // nested field
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[0].toString(), equalTo("1"));
            return index;
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
            prepareCreate("test1").setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2))  
        size = 1 + random.nextInt(10);
            assertThat(
            for (int i = 0; i < 2; i++) {  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(3)));
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(2)));  
        assertNoFailures(searchResponse);
            client().prepareIndex("test")
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo((long) sparseBytes.size()));
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        }
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("integer_value", SortOrder.ASC).get();
                    .startObject("float_value")
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            .addSort(SortBuilders.fieldSort("value").order(SortOrder.ASC).missing("_last"))  
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));  
        }
        for (int i = 1; i <= 7000; i++) {  
            .addSort(new FieldSortBuilder("long_field").order(SortOrder.DESC))
            );
        refresh();
/*  
            }  
            .setSize(size)
            SearchHits hits = response.getHits();  
        assertThat(searchResponse.getHits().getAt(1).getSortValues()[0], equalTo("10"));  
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).intValue(), equalTo(1));  
                    .startObject("properties")  
        assertThat(Arrays.toString(searchResponse.getShardFailures()), searchResponse.getFailedShards(), equalTo(0));
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).longValue(), equalTo(7L));  
        // UNSIGNED_LONG
            .get();  
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).addSort("svalue", SortOrder.ASC).setTrackScores(true).get();
            long currentLong = (long) hit.getSortValues()[0];  
            indexRandomForConcurrentSearch("test_" + i);
        for (int i = 0; i < 15; i++) {  
        }
        searchResponse = client().prepareSearch()
                .get();
                    .field("type", "double")
            .get();
                    .field("l_value", Long.MIN_VALUE)
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));
        assertNoFailures(searchResponse);
            for (ShardSearchFailure shardSearchFailure : e.shardFailures()) {  
        assertHitCount(searchResponse, 10);  
        assertThat(searchResponse.getHits().getMaxScore(), equalTo(Float.NaN));
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), equalTo(10d));
import java.util.concurrent.atomic.AtomicInteger;  
        }
        assertAcked(prepareCreate("new_index").setMapping("route_length_miles", "type=double"));
        assertThat(multiShardResponse.getHits().getTotalHits().value(), equalTo(singleShardResponse.getHits().getTotalHits().value()));
                .setQuery(matchAllQuery())  
            int size = between(1, sparseBytes.size());
import java.util.Collections;
            SearchResponse response = client().prepareSearch()  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
        logger.info("--> sort with an unmapped field, verify it fails");  
        ensureGreen();
                    .array("double_values", 2d, 1d, 3d, -4d)
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
            } else {
    }
        }  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));  
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
        logger.info("--> sort with no missing");
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("3"));  
                    .array("short_values", 2, 1, 3, -4)
                    .field("foo", "abc abc")
        ensureGreen();
        searchResponse = client().prepareSearch()
                        .field("half_float_value", 0.1 * i)  
                } else {  
                XContentFactory.jsonBuilder()
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("long_value", SortOrder.DESC).get();
        assertThat(hits[1].getSortValues().length, is(1));
                                + " "
            .get();
        }
            builders.clear();
            final String indexId = "idx_" + i;
    }
            .setQuery(QueryBuilders.functionScoreQuery(matchAllQuery(), ScoreFunctionBuilders.fieldValueFactorFunction("field")))
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[0].toString(), equalTo("1"));
                    .startObject("integer_value")  
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).intValue(), equalTo(3));  
        }  
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("short_values", SortOrder.DESC).get();
            .setQuery(matchAllQuery())
        size = 1 + random.nextInt(10);
                .get();
                    .startObject("half_float_value")
                .addSort(SortBuilders.fieldSort("tag").order(SortOrder.ASC))
                        .field("str_value", new String(new char[] { (char) (97 + i), (char) (97 + i) }))
        assertThat(searchResponse.getHits().getAt(1).getScore(), Matchers.lessThan(searchResponse.getHits().getAt(0).getScore()));
            assertAcked(prepareCreate(indexId, singleShardSettings));  
    }
        }
        assertThat(hits.length, is(2));  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                .setQuery(matchAllQuery())
        }
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
                    .startObject("string_values")  
                    .startObject("foo")
        // LONG  
        }  
            response = client().prepareSearch()  
import static org.hamcrest.Matchers.greaterThan;  
        searchResponse = client().prepareSearch()
        searchResponse = client().prepareSearch()
            .setQuery(matchAllQuery())  
        // representations of values, to make sure values are both correctly
            builders.clear();
    public void testSortOnRareField() throws IOException, InterruptedException {  
                    .endArray()
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(2)));
            assertThat(searchResponse.toString(), current.intValue(), lessThan(previous.intValue()));
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
        assertAcked(prepareCreate("old_index").setMapping("distance", "type=double", "route_length_miles", "type=alias,path=distance"));  
                    .unmappedType("keyword")  
                .addSort(SortBuilders.fieldSort("field").setNumericType("date"))
            assertThat(response.getShardFailures()[0].toString(), containsString("are after 2262"));  
                .setSize(1)  
        size = 1 + random.nextInt(10);  
        for (int j = 1; j < searchResponse.getHits().getHits().length; j++) {
        }  
                    .endObject()  
            indexRandom(true, builders);
        assertAcked(
                    .field("type", "float")
                String idString = hits[i].getId();
        assertAcked(
        internalCluster().ensureAtLeastNumDataNodes(3);  
            .setQuery(matchAllQuery())
                .setMaxConcurrentShardRequests(1)
            .setQuery(matchAllQuery())  
    }
            assertThat(searchResponse.toString(), current.intValue(), greaterThan(previous.intValue()));
            .setQuery(matchAllQuery())
        for (int i = 0; i < size; i++) {
            .setQuery(matchAllQuery())
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        assertThat(searchResponse.getHits().getAt(1).getSortValues()[0].toString(), equalTo("10"));  
        assertThat(searchResponse.toString(), not(containsString("error")));
        assertThat(searchResponse.getHits().getAt(1).getId(), is(oneOf("3", "2")));
    }
        assertSearchResponse(searchResponse);
        assertNoFailures(searchResponse);
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("2"));
                .get();  
        // The order here could be unstable (depends on document order) since missing == field value
        previousLong = Long.MIN_VALUE;
        ensureGreen();  
            .setQuery(matchAllQuery())  
                    .endObject()  
        refresh();  
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));
                    .field("type", "keyword")  
                .addSort(SortBuilders.scoreSort())  
            prepareCreate("test").setMapping(
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("float_value", SortOrder.DESC).get();  
    }
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {  
                    .endObject()
                    .endObject()
                    .startObject("sub")
            assertEquals(12.1D, (double) hits.getAt(1).getSortValues()[0], 0.001f);
            .addSort(SortBuilders.fieldSort("field").order(SortOrder.ASC).sortMode(SortMode.MAX))  
        searchResponse = client().prepareSearch("test")  
            do {
            SearchResponse searchResponse = client().prepareSearch()  
            .addSort(SortBuilders.fieldSort("nested.foo").setNestedPath("nested").order(SortOrder.DESC))
        assertThat(searchResponse.getHits().getAt(1).getSortValues()[0].toString(), equalTo("10"));
        // The order here could be unstable (depends on document order) since missing == field value
            )
        assertThat(hits[1].getSortValues()[0], is("bar"));
            .setQuery(matchAllQuery())  
                assertThat(exc.status(), equalTo(RestStatus.BAD_REQUEST));
                    .startObject("fields")
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            .setId(Integer.toString(1))
        hits = searchResponse.getHits().getHits();
                    .field("type", "unsigned_long")
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
            .get();  
            .setId("3")  
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).intValue(), equalTo(-4));
        assertThat(searchResponse.getHits().getAt(2).getScore(), Matchers.lessThan(searchResponse.getHits().getAt(1).getScore()));  
        searchResponse = client().prepareSearch("test")
                .setQuery(matchAllQuery())
                            .order(SortOrder.DESC)
import java.util.function.Supplier;
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(3)));
 * You may obtain a copy of the License at  
    }  
        index("long", () -> randomLongBetween(0, (long) 2E53 - 1));
            Map<?, ?> doc = (Map) vars.get("doc");
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
                    .field("type", "keyword")
                    .field("type", "double")
            .addSort(SortBuilders.fieldSort("kkk").unmappedType("keyword"))
 * The OpenSearch Contributors require contributions made to  
                multiShardResponse.getHits().getAt(i).getSortValues()[0],
            "test",
        indexRandom(true, true, builders);
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));  
        assertThat(Arrays.toString(searchResponse.getShardFailures()), searchResponse.getFailedShards(), equalTo(0));
            prepareCreate("test2").setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1))  
            )
            .setQuery(matchAllQuery())
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).floatValue(), equalTo(20f));  
        // UNSIGNED_LONG  
        searchResponse = client().prepareSearch("test")
        }
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));  
        // one, and a concrete field in the other.
        refresh();
        );
            .addSort(SortBuilders.fieldSort("route_length_miles"))
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            for (int i = 0; i < size; i++) {
            .setSize(10)  
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));  
        assertHitCount(searchResponse, 10L);
        builders.add(client().prepareIndex("new_index").setSource("route_length_miles", 100.2));
                .addSort(SortBuilders.fieldSort("tag").order(SortOrder.DESC))  
        for (int i = 0; i < size; i++) {
        logger.info("--> sort with missing _last");
                jsonBuilder().startObject()
                    .field("type", "float")
            assertThat(hit.getScore(), equalTo(Float.NaN));  
                .setId(Integer.toString(300 + i))  
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));  
            scripts.put("doc['number'].value", vars -> sortDoubleScript(vars));
        searchResponse = client().prepareSearch("test")
                            "2014/07/"  
        logClusterState();
        size = 1 + random.nextInt(10);
            for (int i = 0; i < 256; i++) {
        client().prepareIndex("test")
                    .field("type", "float")
        }  
    public static Collection<Object[]> parameters() {  
                    .startObject("integer_value")
