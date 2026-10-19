            builder.get();
                .setSource("{\"field\" : " + valueSupplier.get() + " }", XContentType.JSON)
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
        for (int i = 0; i < size; i++) {
            .setId("3")
import org.opensearch.index.query.functionscore.ScoreFunctionBuilders;
        indexRandom(
                .setMaxConcurrentShardRequests(1)
                        .field("long_value", i)
            builders.add(client().prepareIndex("index_date").setSource("field", "2346-04-11T23:47:17"));
        try {
        client().prepareIndex("test")
        client().prepareIndex("test")
        index("float", () -> 200.5 - counter.getAndIncrement());
            Iterator<Entry<BytesRef, String>> iterator = entrySet.iterator();
                .setQuery(matchAllQuery())
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
        index("double", () -> 100.5 - counter.getAndIncrement());
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(3)));
    }
        refresh();
            .addSort(SortBuilders.fieldSort("long_values").order(SortOrder.DESC).sortMode(SortMode.SUM))
            .addSort(SortBuilders.fieldSort("u_value").order(SortOrder.ASC).missing("_first"))
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("float_value", SortOrder.ASC).get();
        for (int i = 0; i < size; i++) {
        int numIndices = between(5, 10);
            } else {
            SearchResponse response = client().prepareSearch()
        // The order here could be unstable (depends on document order) since missing == field value
                searchResponse.getHits().getAt(i).getSortValues()[0].toString(),
            .setQuery(matchAllQuery())
    public void testSimpleSorts() throws Exception {
            .get();
            if (useMapping) {
        // Create two indices and add the field 'route_length_miles' as an alias in
                .get()
        assertSearchResponse(response);
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("2"));
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
            .addSort(SortBuilders.fieldSort("field").order(SortOrder.ASC))
            assertThat(response.getShardFailures().length, equalTo(1));
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
            client().prepareIndex("test").setId("2").setSource("tag", "beta").get();
        assertThat(hits[1].getSortValues()[0], is("bar bar"));
                    .startObject("foo")
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
        searchResponse = client().prepareSearch()
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).longValue(), equalTo(7L));
    }
        for (int i = 0; i < size; i++) {
            .addSort(SortBuilders.fieldSort("long_values").order(SortOrder.DESC).sortMode(SortMode.AVG))
import org.opensearch.index.fielddata.ScriptDocValues;
            assertThat(searchResponse.toString(), current.intValue(), lessThan(previous.intValue()));
    public void testLongSortOptimizationCorrectResults() throws InterruptedException {
                    .endObject()
                    .field("id", "1")
        size = 1 + random.nextInt(10);
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(2)));
            )
        searchResponse = client().prepareSearch()
                SortBuilders.fieldSort("nested.foo")
        assertNoFailures(searchResponse);
            .get();
                    .endObject()
        createIndex("test");
            assertEquals(1, hits.getHits().length);
 * license agreements. See the NOTICE file distributed with
        size = 1 + random.nextInt(10);
            assertThat(((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).longValue(), equalTo((long) (9 - i)));
        assertHitCount(searchResponse, 10);
            .get();
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("float_values", SortOrder.ASC).get();
            .get();
        searchResponse = client().prepareSearch()
                    .startObject("boolean_value")
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(2).addSort("string_values", SortOrder.DESC).get();
import org.opensearch.indices.IndicesService;
            .setTransientSettings(Settings.builder().put(IndicesService.INDICES_ID_FIELD_DATA_ENABLED_SETTING.getKey(), true))
            assertThat("Expected exception but returned with", result, nullValue());
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
 */
                    .endObject()
}
        assertThat(searchResponse.getHits().getAt(2).getSortValues()[0], equalTo("03"));
                // ignore
        assertThat(searchResponse.toString(), not(containsString("error")));
        assertNoFailures(searchResponse);
        searchResponse = client().prepareSearch()
 * Modifications Copyright OpenSearch Contributors. See
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(docs / 2 - 1 - i)));
                    .field("type", "double")
        }
            Set<Entry<BytesRef, String>> entrySet = denseBytes.entrySet();
        assertEquals(50.5, hits.getAt(1).getSortValues()[0]);
        IndexRequestBuilder[] indexReqs = new IndexRequestBuilder[numDocs];
                );
        // representations of values, to make sure values are both correctly
        assertAcked(
            assertThat(resp.getHits().getHits().length, equalTo(2));
            XContentBuilder src = jsonBuilder().startObject().field("dense_bytes", ref.utf8ToString());
        } catch (SearchPhaseExecutionException e) {
        searchResponse = client().prepareSearch()
                    .field("type", "short")
                    .endObject()
            assertNotNull(response.getShardFailures());
                        .field("byte_value", i)
            client().admin()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
 * software distributed under the License is distributed on an
        Collections.sort(keywords);
            .get();
        for (IndexRequestBuilder builder : builders) {
                .setQuery(matchAllQuery())
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("2"));
            .setSize(size)
        }
        } finally {
                    .endObject()
            .setQuery(matchAllQuery())
        SearchResponse searchResponse = client().prepareSearch()
                    .endObject()
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).longValue(), equalTo(3L));
        searchResponse = client().prepareSearch()
        for (int i = 0; i < size; i++) {
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
                    .field("type", "short")
                    .startObject("half_float_values")
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).longValue(), equalTo(1L));
        assertThat(multiShardResponse.getHits().getHits().length, equalTo(singleShardResponse.getHits().getHits().length));
            .get();
        assertAcked(prepareCreate("new_index").setMapping("route_length_miles", "type=double"));
                    client().prepareIndex(indexId)
            )
    }
        client().prepareIndex("test")
                jsonBuilder().startObject()
        }
            prepareCreate("test1").setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2))
                    .field("type", "keyword")
                    .startObject("float_value")
            .setQuery(matchAllQuery())
        SearchHits hits = response.getHits();
                    .endObject()
                    .array("double_values", 11d, 15d, 20d, 7d)
                .addSort(SortBuilders.fieldSort("field").order(SortOrder.DESC).setNumericType("date_nanos"))
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFailures;
                    .startObject("sub")
        searchResponse = client().prepareSearch()
            .setSource(jsonBuilder().startObject().field("id", "1").field("value", "c").endObject())
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
        }
                        .must(QueryBuilders.termQuery("foo", "bar"))
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo((long) sparseBytes.size()));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
                    .field("type", "byte")
            scripts.put("doc['keyword'].value", vars -> sortStringScript(vars));
            .setQuery(
        logger.info("--> sort with no missing");
/*
        // INTEGER
        }
            .setQuery(matchAllQuery())
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[0], equalTo("20"));
        assertThat(searchResponse.toString(), not(containsString("error")));
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("float_value", SortOrder.DESC).get();
        assertThat(searchResponse.getHits().getAt(1).getScore(), Matchers.lessThan(searchResponse.getHits().getAt(0).getScore()));
        indexRandomForConcurrentSearch("test");
            assertEquals(1712879236854775807L, hits.getAt(0).getSortValues()[0]);
                    .startObject("fields")
                .addSort(SortBuilders.fieldSort("field").setNumericType("double"))
import org.opensearch.core.xcontent.MediaTypeRegistry;
                    .endObject()
        }
            .setQuery(QueryBuilders.functionScoreQuery(matchAllQuery(), ScoreFunctionBuilders.fieldValueFactorFunction("field")))
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).addSort("svalue", SortOrder.ASC).setTrackScores(true).get();
        assertSearchResponse(searchResponse);
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));
                        .get()
            .get();
        assertAcked(prepareCreate("old_index").setMapping("distance", "type=double", "route_length_miles", "type=alias,path=distance"));
            .addSort(
        assertThat(searchResponse.toString(), not(containsString("error")));
            for (int i = 0; i < 2; i++) {
    public void testScriptFieldSort() throws Exception {
        builders.add(client().prepareIndex("old_index").setSource("distance", 42.0));
        assertThat(searchResponse.getHits().getAt(1).getSortValues()[0], equalTo("10"));
            .get();
            .get();
    }
                .addSort(SortBuilders.fieldSort("field").setNumericType("date_nanos"))
                    .field("type", "unsigned_long")
            .setQuery(matchAllQuery())
        indexRandomForConcurrentSearch("test");
            client().prepareIndex("test").setId("1").setSource("tag", "alpha").get();
                    .field("type", "unsigned_long")
        assertThat(searchResponse.toString(), not(containsString("error")));
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));
                            .setNestedSort(
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("3"));
                    .startObject("half_float_value")
            .get();
        }
                .setId(Integer.toString(i))
            .get();
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
            .get();
        assertThat(searchResponse.toString(), not(containsString("error")));
        size = 1 + random.nextInt(10);
            client().prepareIndex("test").setId("3").setSource("tag", "gamma").get();
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
        final int numIndices = 15;
        assertNoFailures(searchResponse);
                .setQuery(matchAllQuery())
 * Unless required by applicable law or agreed to in writing,
            .get();
        for (int i = 0; i < size; i++) {
                .get()
                    .endObject()
        }
        );
 * KIND, either express or implied.  See the License for the
            .addSort(SortBuilders.fieldSort("value").order(SortOrder.ASC))
        searchResponse = client().prepareSearch()
            if ((++j % 25) == 0) {
            .setQuery(matchAllQuery())
                    .field("foo", "abc abc")
            .setId(Integer.toString(2))
        for (int i = 0; i < numIndices; i++) {
                    .array("short_values", 11, 15, 20, 7)
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
        assertHitCount(searchResponse, docs);
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
                            )
        assertAcked(
        builders.add(client().prepareIndex("index_long").setSource("field", 12));
            SearchResponse response = client().prepareSearch()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            Script script = new Script(ScriptType.INLINE, NAME, "doc['number'].value", Collections.emptyMap());
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("3"));
        List<IndexRequestBuilder> builders = new ArrayList<>();
            .setSource(
                    .startObject("float_values")
                    .endObject()
                    .endObject()
        client().prepareIndex("test").setId("1").setSource("{\"field1\":\"value1\"}", MediaTypeRegistry.JSON).get();
            );
            assertThat(hits.getAt(0).getSortValues()[0].getClass(), equalTo(Long.class));
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("str_value", SortOrder.DESC).get();
        assertThat(searchResponse.toString(), not(containsString("error")));
            .get();
            return scripts;
            .get();
        {
            assertEquals(1, hits.getHits().length);
        }
            assertEquals(1, hits.getHits().length);
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).intValue(), equalTo(20));
        assertThat(searchResponse.getHits().getAt(1).getSortValues()[0], equalTo("10"));
                    .endObject()
            response = client().prepareSearch()
        client().prepareIndex("test").setId("2").setSource(jsonBuilder().startObject().field("id", "2").endObject()).get();
    public void testScoreSortDirectionWithFunctionScore() throws Exception {
                    .field("type", "float")
                        .field("half_float_value", 0.1 * i)
                XContentFactory.jsonBuilder()
        assertHitCount(searchResponse, 10L);
            .get();
            Thread.sleep(2000);
        createIndex("test");
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).intValue(), equalTo(7));
            client().prepareIndex(type)
            .setQuery(matchAllQuery())
        assertAcked(
        index(
            .setQuery(matchAllQuery())
            if (random.nextBoolean()) {
                        .field("double_value", 0.1 * i)
            "test",
            .setQuery(matchAllQuery())
                    .endObject()
        assertHitCount(searchResponse, 10);
        SearchResponse searchResponse = client().prepareSearch()
            SearchResponse searchResponse = client().prepareSearch()
        // UNSIGNED_LONG
                    .field("type", "long")
            prepareCreate("test").setMapping(
        logger.info("--> sort with missing b");
        assertNoFailures(searchResponse);
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        client().prepareIndex("test").setId("2").setSource(jsonBuilder().startObject().field("id", "2").endObject()).get();
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
            .addSort(SortBuilders.fieldSort("field").order(SortOrder.ASC))
        flush();
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("2"));
        logger.info("--> sort with missing _first");
        assertFailures(searchRequestBuilder, RestStatus.BAD_REQUEST, containsString("Value [-1] is out of range for an unsigned long"));
                .setQuery(matchAllQuery())
            .setQuery(matchAllQuery())
            docs += builders.size();
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
        assertNoFailures(searchResponse);
            for (String numericType : new String[] { "long", "double", "date", "date_nanos" }) {
                    .field("l_value", Long.MAX_VALUE)
        searchResponse = client().prepareSearch("test")
            .setId(Integer.toString(3))
        SearchResponse searchResponse = client().prepareSearch()
import org.opensearch.search.SearchHits;
        searchResponse = client().prepareSearch()
            .addSort(SortBuilders.fieldSort("long_values").order(SortOrder.DESC).sortMode(SortMode.MEDIAN))
            .addSort("_score", SortOrder.DESC)
        boolean asc = randomBoolean();
                        .field("float_value", 0.1 * i)
            assertHitCount(resp, 4);
            .cluster()
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("2"));
        for (int i = 0; i < size; i++) {
        for (int i = 0; i < size; i++) {
            assertThat(multiShardResponse.getHits().getAt(i).getId(), equalTo(singleShardResponse.getHits().getAt(i).getId()));
    }
                bulkBuilder.get();
                    .setNestedSort(new NestedSortBuilder("nested").setNestedSort(new NestedSortBuilder("nested.foo")))
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
                    .endObject()
                assertAcked(prepareCreate("test_" + i).addAlias(new Alias("test")));
            .setId("1")
            .addSort("long_values", SortOrder.ASC)
        List<IndexRequestBuilder> builders = new ArrayList<>();
        assertHitCount(searchResponse, 10L);
                assertThat(hit.getSortValues()[0], equalTo(expectedValue++));
        {
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            .get();
                    .field("u_value", Numbers.MAX_UNSIGNED_LONG_VALUE)
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        internalCluster().ensureAtLeastNumDataNodes(3);
            resp = client().prepareSearch("test")
                    .field("type", "keyword")
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("string_values", SortOrder.ASC).get();
                .addSort(SortBuilders.fieldSort("field").setNumericType("date"))
                .get();
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).intValue(), equalTo(3));
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).longValue(), equalTo(7L));
                .addSort(SortBuilders.fieldSort("tag").order(SortOrder.ASC))
import org.opensearch.test.InternalSettingsPlugin;
            createIndex("test");
        assertHitCount(searchResponse, docs);
        assertAcked(
    /**
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
                    .endObject()
                .setSource(jsonBuilder().startObject().array("some_other_field", "foobar").endObject())
            .setQuery(matchAllQuery())
            keywords.add(Integer.toString(i));
                    .field("type", "short")
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
            }
    public void testTrackScores() throws Exception {
        forceMerge();
        }
                    .array("double_values", 2d, 1d, 3d, -4d)
            .setQuery(functionScoreQuery(matchAllQuery(), fieldValueFactorFunction("field")))
        refresh();
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));
                jsonBuilder().startObject()
            .setQuery(matchAllQuery())
            .setSource(jsonBuilder().startObject().array("string_values", "01", "05", "10", "08").endObject())
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("3"));
                    .startObject("i_value")
        for (int i = 0; i < size; i++) {
                    .startObject()
        client().prepareIndex("test").setId("2").setSource("field", 1).get();
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[0], equalTo("20"));
        assertThat(hits.length, is(2));
import org.opensearch.action.bulk.BulkRequestBuilder;
            sortValues[i] = ((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).doubleValue();
            .setQuery(matchAllQuery())
            for (int i = 0; i < numDocs; ++i) {
        final boolean useMapping = randomBoolean();
                    .endObject()
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                assertThat(hits.getAt(i).getSortValues()[0].getClass(), equalTo(Long.class));
                    .endObject()
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));
                    .endObject()
                    .startObject("short_values")
 */
            // check the correct sort order
        );
                    .startObject("int_values")
        Collections.shuffle(builders, random);
            .get();
        logger.info("--> sort with custom missing value");
        }
            .addSort(SortBuilders.fieldSort("field").order(SortOrder.ASC))
        } catch (InterruptedException e) {
        assertHitCount(searchResponse, docs);
                equalTo(new String(new char[] { (char) (97 + (9 - i)), (char) (97 + (9 - i)) }))
        // The order here could be unstable (depends on document order) since missing == field value
            .get();
        refresh();
            )
                    .startObject("short_value")
            }
            }
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));
            .get();
        // one, and a concrete field in the other.
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
                .addSort("sparse_bytes", SortOrder.ASC)
        indexRandomForConcurrentSearch("old_index", "new_index");
        logger.info("--> sort with an unmapped field, verify it fails");
        size = 1 + random.nextInt(10);
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        client().prepareIndex("test").setId("1").setSource("field", 2).get();
        SearchHit[] hits = searchResponse.getHits().getHits();
            .addSort(new FieldSortBuilder("entry").order(SortOrder.ASC).unmappedType(useMapping ? null : "long"))
                .setQuery(QueryBuilders.rangeQuery("field").gt("1970-01-01"))
        // reindex - no refresh
                    .endObject()
        searchResponse = client().prepareSearch()
                ref = new BytesRef(TestUtil.randomRealisticUnicodeString(random));
                    .get()
 * ownership. Elasticsearch licenses this file to you under
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        assertNoFailures(searchResponse);
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
                    .endObject()
        assertThat(searchResponse.getHits().getAt(2).getScore(), Matchers.lessThan(searchResponse.getHits().getAt(1).getScore()));
            return value;
            .addSort(new FieldSortBuilder("long_field").order(SortOrder.DESC))
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(docs / 2 - 1 - i)));
            // we check that it's a parse failure rather than a different shard failure
        final int docs = 100;
            indexRandom(true, true, builders);
                XContentFactory.jsonBuilder()
        assertThat(searchResponse.getHits().getAt(1).getId(), is(oneOf("3", "2")));
                        .field("float_value", 32 * i)
        searchResponse = client().prepareSearch("test")
        assertNoFailures(searchResponse);
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("1"));
import org.opensearch.script.Script;
import static org.hamcrest.Matchers.greaterThan;
        logger.info("--> sort with no missing");
            SearchResponse searchResponse = client().prepareSearch()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        client().prepareIndex("test")
            SearchResponse response = client().prepareSearch()
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
            }
            assertAcked(prepareCreate(indexId, singleShardSettings));
                .get();
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).floatValue(), equalTo(7f));
    }
    }
            // check the correct sort order
                    .field("type", "keyword")
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            .addSort(SortBuilders.fieldSort("nested.foo.sub").setNestedPath("nested").order(SortOrder.DESC))
        // nestedQuery
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).intValue(), equalTo(1));
        for (String index : new String[] { "test1", "test2" }) {
    public void testSortMetaField() throws Exception {
        assertAcked(
        ensureGreen("old_index", "new_index");
        assertNoFailures(searchResponse);
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("short_values", SortOrder.DESC).get();
                    .endObject()
                ((Number) searchResponse.getHits().getAt(i).getSortValues()[0]),
    public void testSimpleSortsPoints() throws Exception {
        BigInteger UNSIGNED_LONG_BASE = Numbers.MAX_UNSIGNED_LONG_VALUE.subtract(BigInteger.valueOf(10000 * docs));
    }
                .setQuery(matchAllQuery())
                    .array("int_values", 11, 15, 20, 7)
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
            .addSort(SortBuilders.fieldSort("nested.foo").setNestedPath("nested").order(SortOrder.DESC))
        assertNoFailures(searchResponse);
        // We sort on nested fields with max_children limit
                    .field("d_value", Float.MIN_VALUE)
            }
                .get();
                String idString = hits[i].getId();
                OpenSearchException exc = expectThrows(
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
                assertThat(iterator.hasNext(), equalTo(true));
        for (int i = 0; i < size; i++) {
                jsonBuilder().startObject()
                XContentFactory.jsonBuilder()
            .setQuery(matchAllQuery())
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).intValue(), equalTo(3));
        long[] sortValues = new long[10];
        }
        client().prepareIndex("test")
            .addSort(SortBuilders.fieldSort("d_value").order(SortOrder.ASC).missing(randomBoolean() ? 1.1 : "1.1"))
            assertEquals(1712879237000000000L, hits.getAt(1).getSortValues()[0]);
        ensureGreen(type);
        assertNoFailures(searchResponse);
            .get();
        assertHitCount(searchResponse, 10);
                    searchResponse.getHits().getHits()[j].getId(),
    }
        // FLOAT
        for (int i = 0; i < size; i++) {
            assertEquals(12L, hits.getAt(1).getSortValues()[0]);
        }
        }
        ensureGreen();
            for (int i = 0; i < 3; i++) {
                .addSort(SortBuilders.fieldSort("tag").order(SortOrder.DESC))
            assertEquals(1712879237000L, hits.getAt(1).getSortValues()[0]);
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
            assertThat(hits.getAt(0).getSortValues()[0].getClass(), equalTo(Long.class));
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(3)));
            assertThat(
    }
        for (String invalidField : new String[] { "keyword", "ip" }) {
                .addSort(SortBuilders.fieldSort("field").setNumericType("date_nanos"))
        assertThat(searchResponse.getHits().getAt(1).getSortValues()[0].toString(), equalTo("10"));
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
                .setSource(
                    .endObject()
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).longValue(), equalTo(2L));
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).longValue(), equalTo(24L));
        double[] sortValues = new double[15];
        assertThat(searchResponse.getHits().getAt(1).getSortValues()[0].toString(), equalTo("10"));
        }
        assertThat(searchResponse.getHits().getAt(1).getSortValues()[0].toString(), equalTo("10"));
        // We sort on nested sub field
        for (int j = 1; j < searchResponse.getHits().getHits().length; j++) {
        assertThat(searchResponse.toString(), not(containsString("error")));
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("1"));
            assertEquals(12D, hits.getAt(0).getSortValues()[0]);
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("2"));
    public void testIssue8226() throws InterruptedException {
            assertSecondHit(resp, hasId("4"));
                                + String.format(Locale.ROOT, "%02d", j + 1)
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
                assertThat(hits.getAt(i).getSortValues()[0].getClass(), equalTo(Double.class));
        assertAcked(
                    .startObject()
            return index;
                        )
        }
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[0], equalTo("10"));
                .setQuery(matchAllQuery())
        searchResponse = client().prepareSearch()
        String sortField = "sortField";
                        .field("boolean_value", true)
                    refresh();
    }
                            "2014/07/"
        client().prepareIndex("test")
            .setQuery(matchAllQuery())
                    .endObject()
                    .array("string_values", "11", "15", "20", "07")
        }
                    .endObject()
                .get();
        SearchHits hits = response.getHits();
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(9 - i)));
            assertThat(((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).doubleValue(), closeTo(0.1d * (9 - i), 0.000001d));
            .get();
                    .endObject()
                    .startArray("nested")
                equalTo(new String(new char[] { (char) (97 + i), (char) (97 + i) }))
    public void testSortMissingNumbers() throws Exception {
        {
                .setQuery(matchAllQuery())
            BytesRef previous = order == SortOrder.ASC ? new BytesRef() : UnicodeUtil.BIG_TERM;
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("2"));
            .setQuery(matchAllQuery())
                    .startObject("properties")
        assertNoFailures(searchResponse);
        size = 1 + random.nextInt(10);
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));
    }
            .setQuery(matchAllQuery())
            SearchHits hits = response.getHits();
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
            .setQuery(matchAllQuery())
        for (int i = 0; i < size; i++) {
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
                    .field("type", "keyword")
                    .startObject("value")
import java.util.concurrent.ExecutionException;
        size = 1 + random.nextInt(10);
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("int_values", SortOrder.DESC).get();
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));
            .setSize(10)
            .addSort("str_value", SortOrder.ASC)
            builders.add(client().prepareIndex("index_date").setSource("field", "1905-04-11T23:47:17"));
                                .gte("2014/" + String.format(Locale.ROOT, "%02d", randomIntBetween(1, 7)) + "/01")
        SearchRequestBuilder searchRequestBuilder = client().prepareSearch()
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(3)));
        indexRandom(true, true, builders);
        logger.info("--> sort with no missing");
            .get();
    public void testCastDate() throws Exception {
        }
        return Arrays.asList(InternalSettingsPlugin.class, CustomScriptPlugin.class);
                        .field("long_value", i)
import static org.hamcrest.Matchers.not;
        indexRandomForConcurrentSearch("index_date", "index_date_nanos");
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
        SortOrder order = randomBoolean() ? SortOrder.ASC : SortOrder.DESC;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        assertHitCount(searchResponse, 10);
                        .setQuery(matchAllQuery())
            .setQuery(matchAllQuery())
                    .startObject()
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));
            .addSort(SortBuilders.fieldSort("i_value").order(SortOrder.ASC).missing(randomBoolean() ? 1 : "1"))
        SearchResponse searchResponse = client().prepareSearch()
            .get();
                            QueryBuilders.rangeQuery("timeUpdated")
    public void testSortMixedFloatingAndIntegerNumericFields() throws Exception {
            assertThat(((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).byteValue(), equalTo((byte) i));
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(3)));
        for (int i = 0; i < searchResponse.getHits().getHits().length; i++) {
            SearchResponse searchResponse = client().prepareSearch()
            .setId(Integer.toString(3))
        size = 1 + random.nextInt(10);
                    .field("id", "3")
        searchResponse = client().prepareSearch()
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("integer_value", SortOrder.ASC).get();
            .get();
                .setSize(size)
                    .endObject()
                            "bar",
        client().prepareIndex("test")
            assertNoFailures(searchResponse);
        }
                .setSize(1)
            .get();
            );
                    .startObject()
                    .endObject()
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).longValue(), equalTo(20L));
            )
                    .startObject("d_value")
            .get();
        internalCluster().ensureAtLeastNumDataNodes(3);
                    .array("short_values", 1, 5, 10, 8)
import java.util.Arrays;
                .setId(Integer.toString(i))
            builders.clear();
        for (SearchHit hit : searchResponse.getHits()) {
            )
        );
        ensureGreen("old_index", "new_index");
import org.opensearch.action.search.SearchResponse;
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("2"));
        assertThat(searchResponse.toString(), not(containsString("error")));
    }
 * this work for additional information regarding copyright
        searchResponse = client().prepareSearch()
            assertThat(((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).longValue(), equalTo((long) i));
        assertThat(searchResponse.toString(), not(containsString("error")));
                .get();
        SearchResponse searchResponse = client().prepareSearch("long", "integer")
            .addSort(SortBuilders.fieldSort("d_value").order(SortOrder.ASC).missing("_first"))
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            ensureGreen();
            assertEquals(1, hits.getHits().length);
        previousLong = Long.MIN_VALUE;
import java.util.Collections;
        searchResponse = client().prepareSearch()
    }
        }
        // The order here could be unstable (depends on document order) since missing == field value
            .setSize(10)
        searchResponse = client().prepareSearch("test")
            SearchResponse response = client().prepareSearch()
        assertThat(searchResponse.toString(), not(containsString("error")));
                .setPostFilter(QueryBuilders.existsQuery("sparse_bytes"))
            .get();
                    .endObject()
        ensureGreen();
        // DOUBLE
            BytesRef ref = null;
        assertHitCount(searchResponse, 10);
            .get();
        assertHitCount(searchResponse, 10);
                    .startObject("properties")
            String source = "{\"long_field\":" + randomLong() + "}";
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
                    .endObject()
                    .startObject("dense_bytes")
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
                .setSize(2)
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("3"));
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("3"));
        for (int i = 1; i < 15; i++) {
            IndexRequestBuilder builder = client().prepareIndex("test")
                    .endObject()
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(3)));
            }
            .setSize(10)
                    .startObject("byte_values")
                    .startObject("long_value")
            assertEquals(12L, hits.getAt(0).getSortValues()[0]);
        );
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(9 - i)));
        indexRandom(true, true, builders);
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(9 - i)));
                .setQuery(matchAllQuery())
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
                final BytesRef id = new BytesRef(idString);
        // UNSIGNED_LONG
        ensureGreen();
    }
                    .startObject()
            .addSort(SortBuilders.fieldSort("u_value").order(SortOrder.ASC).missing("_last"))
            SearchHit[] hits = searchResponse.getHits().getHits();
        refresh();
import org.opensearch.common.xcontent.XContentFactory;
        assertNoFailures(searchResponse);
            prepareCreate("test").setMapping(
import org.opensearch.test.ParameterizedDynamicSettingsOpenSearchIntegTestCase;
        for (int i = 0; i < size; i++) {
    }
                QueryBuilders.boolQuery()
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(3)));
            }
        }
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
import static org.hamcrest.Matchers.is;
import java.util.Random;
    }
                .setSize(builders.size())
                    .startObject("long_values")
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            .get();
        assertThat(hits[0].getSortValues()[0], is("bar"));
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).intValue(), equalTo(10));
            assertThat(hit.getScore(), equalTo(Float.NaN));
        for (int i = 0; i < 15; i++) {
            assertSecondHit(resp, hasId("2"));
        BigInteger UNSIGNED_LONG_BASE = Numbers.MAX_UNSIGNED_LONG_VALUE.subtract(BigInteger.valueOf(100000));
        builders.add(client().prepareIndex("new_index").setSource("route_length_miles", 100.2));
                assertThat(exc.getDetailedMessage(), containsString("[numeric_type] option cannot be set on a non-numeric field"));
            SearchHit hit = searchResponse.getHits().getHits()[i];
        size = 1 + random.nextInt(10);
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("3"));
            .addSort(new FieldSortBuilder("timeUpdated").order(SortOrder.ASC).unmappedType("date"))
                .get();
                        .endObject()
        assertThat(searchResponse.getHits().getAt(2).getSortValues()[0].toString(), equalTo("100"));
        assertNoFailures(searchResponse);
        searchResponse = client().prepareSearch().addSort(new FieldSortBuilder("long_field").order(SortOrder.ASC)).setSize(10).get();
                    .endObject()
            .setQuery(matchAllQuery())
                .addSort(SortBuilders.scriptSort(script, ScriptSortBuilder.ScriptSortType.NUMBER))
        assertThat(searchResponse.toString(), not(containsString("error")));
        counter.set(0);
            .setQuery(matchAllQuery())
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
                client().prepareIndex("test_" + i).setId("" + i).setSource("{\"entry\": " + i + "}", MediaTypeRegistry.JSON).get();
        SearchResponse searchResponse = client().prepareSearch()
                    .unmappedType("keyword")
        assertNoFailures(searchResponse);
        SearchResponse singleShardResponse = client().prepareSearch("test2").setFrom(from).setSize(size).addSort(sortField, order).get();
        SearchResponse result = client().prepareSearch("test")
        assertThat(searchResponse.toString(), not(containsString("error")));
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).longValue(), equalTo(10L));
        assertAcked(
        ensureGreen();
                jsonBuilder().startObject().field("id", "1").field("i_value", -1).field("d_value", -1.1).field("u_value", 1).endObject()
        assertAcked(client().admin().indices().prepareCreate("test").setMapping("field1", "type=keyword").get());
            .get();
                    .endObject()
                    .field("type", "boolean")
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
        assertThat(searchResponse.getHits().getAt(2).getId(), is(oneOf("2", "3")));
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));
        searchResponse = client().prepareSearch("test")
        SearchResponse searchResponse = client().prepareSearch()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        assertSearchResponse(allDocsResponse);
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("2"));
                multiShardResponse.getHits().getAt(i).getSortValues()[0],
                    .startObject()
                    .startObject("sub")
            }
                    .field("type", "float")
import org.opensearch.common.Numbers;
        }
            .addSort(SortBuilders.fieldSort("l_value").order(SortOrder.ASC))
            prepareCreate(type).setMapping(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasId;
        logger.info("--> sort with missing _last");
        );
        // BYTE
    public void testSortMissingNumbersMinMax() throws Exception {
            .addSort("string_values", SortOrder.DESC)
        indexRandomForConcurrentSearch("test");
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
            builder.get();
                    .endObject()
            .get();
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("1"));
        assertThat(hits[1].getSortValues()[0], is("bar"));
        }
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
        for (IndexRequestBuilder builder : builders) {
            SearchResponse response = client().prepareSearch()
        indexRandomForConcurrentSearch("test");
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[0].toString(), equalTo("1"));
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("byte_value", SortOrder.ASC).get();
import static org.opensearch.script.MockScriptPlugin.NAME;
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
            .get();
    }
        ensureGreen();
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), equalTo(-4d));
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));
        index("long", () -> randomLongBetween(0, (long) 2E53 - 1));
            .addSort(SortBuilders.fieldSort("u_value").order(SortOrder.ASC))
        logger.info("--> sort with missing _last");
            }
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(3)));
import java.util.Collection;
        assertThat(Arrays.toString(searchResponse.getShardFailures()), searchResponse.getFailedShards(), equalTo(0));
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
                    .field("type", "float")
        refresh();
        for (int i = 0; i < size; i++) {
/*
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).intValue(), equalTo(-4));
        }
        for (int i = 0; i < size; i++) {
            .addSort("unsigned_long_value", SortOrder.ASC)
        assertNoFailures(searchResponse);
            .addSort(SortBuilders.fieldSort("i_value").order(SortOrder.ASC))
        }
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
                            .order(SortOrder.DESC)
                    .startObject("u_value")
            .setSize(3)
                    .endObject()
            )
            prepareCreate("test").setMapping(
                    .array("half_float_values", 1f, 5f, 10f, 8f)
        assertThat(searchResponse.toString(), not(containsString("error")));
                .setQuery(matchAllQuery())
/*
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        assertThat(searchResponse.getHits().getAt(1).getId(), is(oneOf("1", "2")));
import static org.hamcrest.Matchers.nullValue;
                    .endObject()
 * specific language governing permissions and limitations
        // sort DESC
            response = client().prepareSearch()
        ensureGreen();
            previousLong = currentLong;
        assertAcked(prepareCreate("new_index").setMapping("route_length_miles", "type=double"));
        // FLOAT
        SearchResponse searchResponse = client().prepareSearch()
            );
        assertAcked(
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("float_value", SortOrder.ASC).get();
                .setId(Integer.toString(300 + i))
            .addSort(SortBuilders.fieldSort("i_value").order(SortOrder.ASC).missing("_first"))
        for (int i = 1; i < 10; i++) {
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("2"));
    public void testFieldAlias() throws Exception {
            for (int j = 0; j < searchResponse.getHits().getHits().length; j++) {
                previous = id;
                SearchPhaseExecutionException.class,
        size = 1 + random.nextInt(10);
            true,
                    .startObject("str_value")
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        assertHitCount(searchResponse, 10L);
                .setSize(builders.size())
        client().prepareIndex("test")
        assertThat(searchResponse.getHits().getAt(1).getId(), is(oneOf("1", "2")));
            } while (denseBytes.containsKey(ref));
            .setQuery(matchAllQuery())
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("double_value", SortOrder.DESC).get();
import java.util.Locale;
            .addSort(SortBuilders.fieldSort("field").order(SortOrder.ASC).sortMode(SortMode.MAX))
            .get();
        size = 1 + random.nextInt(10);
            .addSort(SortBuilders.fieldSort("field").order(SortOrder.ASC))
        assertThat(searchResponse.getHits().getAt(1).getScore(), Matchers.lessThan(searchResponse.getHits().getAt(0).getScore()));
        assertAcked(
import java.util.TreeMap;
                );
                    .endObject()
                        .field("unsigned_long_value", UNSIGNED_LONG_BASE.add(BigInteger.valueOf(10000 * i)))
            .setSize(10)
                .setQuery(
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
                .setSize(size)
        List<IndexRequestBuilder> builders = new ArrayList<>();
                assertThat(searchResponse.getHits().getAt(i).getSortValues()[0].toString(), equalTo(next.getKey().utf8ToString()));
        assertThat(hits[1].getSortValues().length, is(1));
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        flush();
        logger.info("--> sort with custom missing value");
                        .addSort(SortBuilders.fieldSort(invalidField).setNumericType(numericType))
            builders[i] = client().prepareIndex("test").setId(docId).setSource(src);
        static Double sortDoubleScript(Map<String, Object> vars) {
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
                    .endObject()
                    .endObject()
        logger.info("--> sort with no missing (same as missing _last)");
        searchResponse = client().prepareSearch()
                        .field("double_value", 64 * i)
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
        client().prepareIndex("test").setId("3").setSource("{\"field1\":\"value3\"}", MediaTypeRegistry.JSON).get();
        refresh();
                    OpenSearchException.class,
        assertAcked(client().admin().indices().prepareCreate("test").setMapping("field", "type=keyword").get());
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));
    public void testFieldAliasesWithMissingValues() throws Exception {
        refresh();
            ).setSettings(Settings.builder().put("index.number_of_shards", 3).put("index.number_of_replicas", 0))
            .setSource(
        index("integer", OpenSearchTestCase::randomInt);
        client().prepareIndex("test").setId(Integer.toString(1)).setSource("field", Integer.toString(1)).get();
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).intValue(), equalTo(7));
            .addSort("_score", SortOrder.DESC)
        }
                    .startObject("unsigned_long_value")
 * under the License.
        ensureGreen();
        assertThat(searchResponse.getHits().getMaxScore(), equalTo(Float.NaN));
            .setQuery(matchAllQuery())
                    .field("type", "half_float")
                        )
            hits = response.getHits();
                    .array("byte_values", 2, 1, 3, -4)
            .setQuery(matchAllQuery())
        assertAcked(prepareCreate("index_date_nanos").setMapping("field", "type=date_nanos"));
                .get();
            .get();
                        .field("integer_value", i)
            .get();
            .setQuery(matchAllQuery())
        hits = searchResponse.getHits().getHits();
        {
        assertEquals(100.2, hits.getAt(1).getSortValues()[0]);
        }
        assertAcked(prepareCreate("test").setMapping("keyword", "type=keyword", "number", "type=integer"));
    public void testCustomFormat() throws Exception {
        assertSearchResponse(searchResponse);
            )
            final int numDocs = randomIntBetween(10, 20);
        ensureGreen();
                } else {
        for (int i = 0; i < 15; i++) {
        index("float", () -> randomFloat());
        }
            .setId("1")
            for (int i = 0; i < size; i++) {
        searchResponse = client().prepareSearch()
        refresh();
        internalCluster().ensureAtLeastNumDataNodes(3);
        ensureGreen();
        for (int i = 1; i < 101; i++) {
        ensureGreen("index");
            .setQuery(matchAllQuery())
                    .endObject()
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(3)));
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).floatValue(), equalTo(1f));
        SearchResponse multiShardResponse = client().prepareSearch("test1").setFrom(from).setSize(size).addSort(sortField, order).get();
        {
        assertThat(hits[0].getSortValues().length, is(1));
        searchResponse = client().prepareSearch()
        assertHitCount(searchResponse, 10L);
                    .field("type", "keyword")
                    .field("type", "byte")
        refresh();
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
            sortValues[i] = ((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).longValue();
        final int numDocs = randomIntBetween(10, 20);
            refresh();
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("3"));
            .addSort(SortBuilders.fieldSort("u_value").order(SortOrder.ASC).missing("_last"))
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
        logger.info("--> sort with no missing");
    }
        }
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
        // HALF_FLOAT
                .setMapping("long_field", "type=long")
            String value = ((String) ((ScriptDocValues<?>) doc.get("keyword")).get(0));
                jsonBuilder().startObject().field("id", "3").field("i_value", 2).field("d_value", 2.2).field("u_value", 3).endObject()
            );
            assertAcked(client().admin().indices().prepareCreate("test").setMapping("tag", "type=keyword").get());
    }
        indexRandomForConcurrentSearch("test");
                    .endObject()
            .setId("3")
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(3)));
                    .field("type", "nested")
                    .array("byte_values", 1, 5, 10, 8)
    public void testNestedSort() throws IOException, InterruptedException, ExecutionException {
                    .endObject()
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
        for (int i = 0; i < size; i++) {
        assertThat(Arrays.toString(searchResponse.getShardFailures()), searchResponse.getFailedShards(), equalTo(0));
            assertThat(
        client().prepareIndex("test")
    public void testCastNumericType() throws Exception {
        }
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(3)));
            Map<?, ?> doc = (Map) vars.get("doc");
        assertThat(searchResponse.toString(), not(containsString("error")));
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).longValue(), equalTo(-4L));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .setQuery(matchAllQuery())
        double[] sortValues = new double[20];
        indexRandom(true, true, builders);
        assertAcked(
        searchResponse = client().prepareSearch()
                .get();
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
            .setQuery(matchAllQuery())
            if (i > 0) {
        logger.info("--> sort with missing _last");
                    .array("byte_values", 11, 15, 20, 7)
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("2"));
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(2)));
        SearchResponse searchResponse = client().prepareSearch("double", "float", "half_float")
        assertSearchResponse(searchResponse);
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).intValue(), equalTo(20));
        }
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(3)));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
    }
import org.opensearch.script.ScriptType;
                    .field("type", "unsigned_long")
                        .setSource(
        builders.add(client().prepareIndex("old_index").setSource("distance", 50.5));
        }
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(9 - i)));
        );
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        assertThat(Arrays.toString(searchResponse.getShardFailures()), searchResponse.getFailedShards(), equalTo(0));
            ).setMapping(sortField, "type=long").get()
                )
                if (random.nextInt(5) != 0) {
    }
            client().prepareIndex("test").setId("1").setSource("ip", "192.168.1.7"),
        for (int i = 0; i < numDocs; ++i) {
import org.opensearch.OpenSearchException;
            .setQuery(QueryBuilders.functionScoreQuery(matchAllQuery(), ScoreFunctionBuilders.fieldValueFactorFunction("field")))
        assertThat(searchResponse.getHits().getAt(2).getScore(), Matchers.lessThan(searchResponse.getHits().getAt(1).getScore()));
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).floatValue(), equalTo(-4f));
                    .field("type", "float")
        index("double", OpenSearchTestCase::randomDouble);
        assertThat(searchResponse.getHits().getAt(2).getSortValues()[0].toString(), equalTo("100"));
                    QueryBuilders.boolQuery()
            prepareCreate("test").setMapping(
                .prepareUpdateSettings()
        }
        searchResponse = client().prepareSearch()
                    .array("int_values", 1, 5, 10, 8)
        for (int i = 0; i < docs / 2; i++) {
                    .unmappedType("keyword")
            .setQuery(matchAllQuery())
                    .startObject()
            assertThat(((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).shortValue(), equalTo((short) i));
            indexRandom(true, docs);
        assertThat(hits[1].getSortValues().length, is(1));
        indexRandomForConcurrentSearch("test");
        assertThat(hits[0].getSortValues().length, is(1));
                    .field("type", "double")
        client().prepareIndex("test")
            .setSource(
            SearchPhaseExecutionException exc = expectThrows(
        // The order here could be unstable (depends on document order) since missing == field value
        assertSearchResponse(response);
            .get();
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
                .addSort(SortBuilders.fieldSort("field").setNumericType("date_nanos"))
        // Use an ip field, which uses different internal/external
        logger.info("--> sort with missing _first");
                        .must(
        client().prepareIndex("test").setId("2").setSource(jsonBuilder().startObject().field("id", "2").endObject()).get();
                    .startObject()
                    .endObject()
            .get();
                );
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).intValue(), equalTo(1));
            assertThat("sort order is incorrect", currentLong, lessThanOrEqualTo(previousLong));
            indexRandom(true, builders);
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).floatValue(), equalTo(7f));
import java.util.HashMap;
        index("long", () -> Long.MAX_VALUE - counter.getAndIncrement());
            builders.add(builder);
                    .endObject()
            .setSize(10)
        assertNoFailures(searchResponse);
            assertEquals(3, hits.getHits().length);
        List<IndexRequestBuilder> builders = new ArrayList<>();
            for (int i = 1; i < 20; i++) {
        for (int i = 0; i < size; i++) {
                .setSource(jsonBuilder().startObject().array("some_other_field", "foobar").endObject())
    public void testIssue6614() throws ExecutionException, InterruptedException {
                ((Number) searchResponse.getHits().getAt(i).getSortValues()[0]),
        try {
                .setQuery(matchAllQuery())
            "test",
        refresh();
                assertEquals(idString, hits[i].getSortValues()[0]);
        assertEquals(1, response.getHits().getHits().length);
 *
            .get();
        assertHitCount(searchResponse, 10);
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
        searchResponse = client().prepareSearch()
                    .endObject()
        assertThat(searchResponse.getHits().getAt(1).getId(), is(oneOf("3", "2")));
                .setSize(1)
        // Create two indices and add the field 'route_length_miles' as an alias in
        logger.info("--> sort with custom missing value");
        }
            assertThat(((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).doubleValue(), closeTo(0.1d * i, 0.000001d));
        TreeMap<BytesRef, String> sparseBytes = new TreeMap<>();
        // FLOAT
            .setSource(
                SortBuilders.fieldSort("nested.foo").setNestedSort(new NestedSortBuilder("nested").setMaxChildren(1)).order(SortOrder.DESC)
                    .field("type", "keyword")
            .get();
        assertArrayEquals(new String[] { "192.168.1.7" }, response.getHits().getAt(0).getSortValues());
            )
            src.endObject();
            assertEquals(1712879237000000000L, hits.getAt(0).getSortValues()[0]);
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            assertThat(searchResponse.toString(), current.intValue(), greaterThan(previous.intValue()));
                    client().admin().indices().prepareFlush().get();
                    .field("type", "float")
        assertThat(searchResponse.toString(), not(containsString("error")));
        // DOUBLE
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("long_values", SortOrder.DESC).get();
                assertThat(
            hits = response.getHits();
import java.util.Map;
        }
                assertThat(hit.getSortValues().length, equalTo(2));
            .addSort(SortBuilders.fieldSort("value").order(SortOrder.ASC).missing("b"))
                SortBuilders.fieldSort("nested.foo")
            .addSort(SortBuilders.fieldSort("u_value").order(SortOrder.ASC).missing(randomBoolean() ? 2 : "2"))
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
                    .endObject()
            SearchResponse searchResponse = client().prepareSearch()
        // The order here could be unstable (depends on document order) since missing == field value
        }
package org.opensearch.search.sort;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            .setQuery(matchAllQuery())
            assertThat(response.getShardFailures()[0].toString(), containsString("are after 2262"));
                    .startObject("l_value")
        TreeMap<BytesRef, String> denseBytes = new TreeMap<>();
        ensureGreen("index_double", "index_long", "index_float");
        searchResponse = client().prepareSearch()
        assertNoFailures(searchResponse);
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
                .setSize(1)
        ensureGreen("index_date", "index_date_nanos");
            assertSearchResponse(searchResponse);
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("double_values", SortOrder.DESC).get();
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(3).addSort("string_values", SortOrder.DESC).get();
            Double index = ((Number) ((ScriptDocValues<?>) doc.get("number")).get(0)).doubleValue();
import org.opensearch.test.OpenSearchTestCase;
                    .startObject("properties")
            )
            .get();
                .setQuery(matchAllQuery())
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
import java.util.ArrayList;
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("half_float_value", SortOrder.ASC).get();
        for (int i = 0; i < numiters; i++) {
            .get();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            assertThat(response.getShardFailures()[0].toString(), containsString("are before the epoch in 1970"));
            .setQuery(matchAllQuery())
                .get();
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));
        SearchResponse searchResponse = client().prepareSearch()
        assertThat(multiShardResponse.getHits().getTotalHits().value(), equalTo(singleShardResponse.getHits().getTotalHits().value()));
        int docs = 0;
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("1"));
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("byte_values", SortOrder.ASC).get();
                    .array("float_values", 2f, 1f, 3f, -4f)
        searchResponse = client().prepareSearch()
                assertThat(hits.getAt(i).getSortValues()[0].getClass(), equalTo(Long.class));
                    .endObject()
        final int numiters = randomIntBetween(1, 20);
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
                    .array("half_float_values", 11f, 15f, 20f, 7f)
            IndexRequestBuilder[] indexReqs = new IndexRequestBuilder[numDocs];
    public void testIssue2991() throws InterruptedException {
            final int numDocs = randomIntBetween(1, 23);  // hour of the day
                    .startObject("double_value")
        for (int i = 0; i < size; i++) {
                    .field("type", "long")
        assertThat(Arrays.toString(searchResponse.getShardFailures()), searchResponse.getFailedShards(), equalTo(0));
        assertThat(searchResponse.getHits().getMaxScore(), not(equalTo(Float.NaN)));
        ensureGreen();
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
                    equalTo(allDocsResponse.getHits().getHits()[j].getId())
            assertEquals(2, hits.getHits().length);
        }
                bulkBuilder = client().prepareBulk();
        assertThat(searchResponse.getHits().getAt(2).getSortValues()[0].toString(), equalTo("100"));
            client().prepareIndex("test").setId("2").setSource("ip", "2001:db8::ff00:42:8329")
                    .array("string_values", "02", "01", "03", "!4")
    public void testSortMVField() throws Exception {
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(2)));
        SearchResponse searchResponse = client().prepareSearch().setQuery(matchAllQuery()).addSort("svalue", SortOrder.ASC).get();
            assertThat(searchResponse.getHits().getHits().length, equalTo(size));
    }
import org.apache.lucene.util.BytesRef;
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("byte_value", SortOrder.DESC).get();
        assertHitCount(searchResponse, docs);
            SearchResponse searchResponse = client().prepareSearch()
                assertThat(iterator.hasNext(), equalTo(true));
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
            .get();
        int j = 0;
                    .startObject("half_float_value")
        SearchResponse searchResponse = client().prepareSearch("test")
import java.util.function.Function;
        for (SearchHit hit : searchResponse.getHits()) {
        assertHitCount(searchResponse, 10);
            for (int j = 0; j < numDocs; j++) {
        {
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(2)));
        indexRandomForConcurrentSearch("test");
            Number current = (Number) searchResponse.getHits().getHits()[j].getSourceAsMap().get("entry");
            for (SearchHit hit : searchResponse.getHits()) {
            .setQuery(matchAllQuery())
                                + String.format(Locale.ROOT, "%02d", i + 1)
                equalTo(singleShardResponse.getHits().getAt(i).getSortValues()[0])
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));
                .setSource(jsonBuilder().startObject().array("some_other_field", "foobar").endObject())
            .get();
        searchResponse = client().prepareSearch()
                XContentFactory.jsonBuilder()
            .setSource(jsonBuilder().startObject().array("string_values", "11", "15", "20", "07").endObject())
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
            .get();
                    .startObject()
            .addSort("_score", SortOrder.DESC)
                .setSize(2)
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).longValue(), equalTo(13L));
            for (int i = 0; i < 2; i++) {
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
    }
            .setQuery(matchAllQuery())
            .setSize(10)
            assertThat(hits.getAt(0).getSortValues()[0].getClass(), equalTo(Long.class));
                    .array("long_values", 11L, 15L, 20L, 7L)
                    .field("type", "half_float")
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).floatValue(), equalTo(20f));
    public void testIssue2986() {
        ensureGreen();
            .addSort(
 * not use this file except in compliance with the License.
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).intValue(), equalTo(10));
        size = 1 + random.nextInt(10);
            .setSize(size)
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).longValue(), equalTo(6L));
        assertNoFailures(multiShardResponse);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSecondHit;
            Script script = new Script(ScriptType.INLINE, NAME, "doc['keyword'].value", Collections.emptyMap());
                    .endObject()
            denseBytes.put(ref, docId);
                    .endObject()
        assertHitCount(searchResponse, docs);
                .get();
                    .startObject("unsigned_long_value")
            .setSource(
            .addSort(SortBuilders.fieldSort("i_value").order(SortOrder.ASC).missing("_last"))
        logger.info("--> sort with missing _last");
        // nested field
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("int_values", SortOrder.ASC).get();
        }
     * Test case for issue 6150: https://github.com/elastic/elasticsearch/issues/6150
                    .startObject("foo")
                indexReqs[i] = client().prepareIndex("test").setId(Integer.toString(i)).setSource();
        SearchResponse allDocsResponse = client().prepareSearch()
                    .startObject()
                src.field("sparse_bytes", ref.utf8ToString());
                sparseBytes.put(ref, docId);
                    .endObject()
            .setSource(jsonBuilder().startObject().array("string_values", "02", "01", "03", "!4").endObject())
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        Random random = random();
        assertThat(hits[1].getSortValues().length, is(1));
                    .field("d_value", Float.MAX_VALUE)
        // DOUBLE
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
            }
        long previousLong = Long.MAX_VALUE;
            prepareCreate("test").setMapping(
                                + ":00:00"
            .get();
            indexRandom(true, true, builders);
        for (int i = 0; i < size; i++) {
        // FLOAT
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo((long) numDocs));
            }
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            .addSort(SortBuilders.fieldSort("field").order(asc ? SortOrder.ASC : SortOrder.DESC).sortMode(SortMode.MAX))
public class FieldSortIT extends ParameterizedDynamicSettingsOpenSearchIntegTestCase {
                .get();
            assertThat(((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).intValue(), equalTo((9 - i)));
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(9 - i)));
        size = 1 + random.nextInt(10);
            )
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).floatValue(), equalTo(-4f));
            .get();
            sortValues[i] = ((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).doubleValue();
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("short_values", SortOrder.ASC).get();
            .setId(Integer.toString(1))
                    .endObject()
        assertEquals(2, response.getHits().getTotalHits().value());
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(3)));
        client().prepareIndex("test")
import org.opensearch.core.rest.RestStatus;
                    .startObject("field")
import org.opensearch.common.settings.Settings;
                    .field("fielddata", true)
    public static class CustomScriptPlugin extends MockScriptPlugin {
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).longValue(), equalTo(2L));
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        }
        assertThat(hits[0].getSortValues()[0], is("cba"));
            )
            .setSize(docs)
                    )
    }
            }
            previousLong = currentLong;
        for (int i = 0; i < size; i++) {
        SearchResponse searchResponse = client().prepareSearch()
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
        assertNoFailures(searchResponse);
            assertEquals(3, hits.getHits().length);
        assertThat(searchResponse.toString(), not(containsString("error")));
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
            assertNotNull(response.getShardFailures());
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
            assertThat("sort order is incorrect", currentLong, greaterThanOrEqualTo(previousLong));
            .addSort(SortBuilders.fieldSort("d_value").order(SortOrder.ASC).missing("_first"))
            for (int i = 0; i < 256; i++) {
                    .endObject()
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).longValue(), equalTo(53L));
            .setId("1")
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).intValue(), equalTo(-4));
            .addSort(SortBuilders.fieldSort("value").order(SortOrder.ASC).missing("_first"))
            .setId(Integer.toString(2))
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));
            assertThat(Arrays.toString(sortValues), sortValues[i - 1], lessThan(sortValues[i]));
            for (int i = 0; i < hits.length; ++i) {
import org.hamcrest.Matchers;
            "type1",
        client().admin()
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("half_float_values", SortOrder.ASC).get();
    }
        // UNSIGNED_LONG
        ensureGreen();
                jsonBuilder().startObject()
        }
        for (int i = docs / 2; i < docs; i++) {
            indexRandomForConcurrentSearch("test");
        assertHitCount(searchResponse, 10);
        SearchResponse searchResponse = client().prepareSearch("test")
                .setSize(2)
        );
            .get();
            .setSize(size)
                    .field("fielddata", true)
            }
                            "timeUpdated",
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("short_value", SortOrder.DESC).get();
        assertAcked(prepareCreate("test").setMapping("ip", "type=ip"));
            SearchHits hits = response.getHits();
                    .endObject()
                    .startObject("string_values")
            SearchResponse resp = client().prepareSearch("test")
        assertNoFailures(singleShardResponse);
        // now check with score tracking
        );
        assertHitCount(searchResponse, 10);
                        .field("integer_value", i)
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        refresh();
import org.opensearch.action.admin.indices.alias.Alias;
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("double_value", SortOrder.DESC).get();
            .addSort(SortBuilders.fieldSort("l_value").order(SortOrder.ASC).missing("_last"))
        searchResponse = client().prepareSearch("test")
        assertNoFailures(searchResponse);
        builders.add(client().prepareIndex("old_index").setSource("distance", 42.0));
                    .must(QueryBuilders.termQuery("foo", "bar"))
                .setMaxConcurrentShardRequests(1)
                .setId(Integer.toString(i))
            }
        }
                    searchResponse.toString() + "\n vs. \n" + allDocsResponse.toString(),
        searchResponse = client().prepareSearch()
                .setQuery(matchAllQuery())
        for (int i = 1; i < 4; i++) {
            prepareCreate("test2").setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1))
        Random random = random();
                    .startObject()
            prepareCreate("test").setMapping(
                XContentFactory.jsonBuilder()
            assertThat(exc.toString(), containsString("max_children is only supported on top level of nested sort"));
                    .setQuery(matchAllQuery())
            .setSize(size)
            assertEquals(1712879237000L, hits.getAt(0).getSortValues()[0]);
            .addSort(SortBuilders.fieldSort("field").order(SortOrder.ASC))
        searchResponse = client().prepareSearch("test")
    @ParametersFactory
            do {
            .addSort("unsigned_long_value", SortOrder.ASC)
        assertThat(searchResponse.getHits().getAt(1).getSortValues()[0].toString(), equalTo("10"));
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).floatValue(), equalTo(20f));
import static org.hamcrest.Matchers.containsString;
            .get();
            } catch (Exception e) {
            .setId("2")
                .setMaxConcurrentShardRequests(1)
        assertThat(searchResponse.getHits().getAt(1).getSortValues()[0], equalTo("01"));
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("2"));
import org.opensearch.search.SearchHit;
        try {
                    .startObject("byte_value")
        for (int i = 0; i < size; i++) {
                .setSize(randomIntBetween(1, numDocs + 5))
            indexRandomForConcurrentSearch("test_" + i);
                .setSource(
                    .array("int_values", 2, 1, 3, -4)
        logger.info("--> sort with missing _last");
                .addSort(SortBuilders.fieldSort("field").setNumericType("long"))
            )
    }
 */
                    .startObject("long_value")
import org.opensearch.action.search.SearchPhaseExecutionException;
            .addSort(SortBuilders.fieldSort("value").order(SortOrder.ASC).missing("_last"))
                    .endArray()
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
        client().prepareIndex("test").setId("1").setSource("field", 2).get();
            }
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("double_value", SortOrder.ASC).get();
                .setQuery(matchAllQuery())
    @SuppressForbidden(reason = "WTF?")
            .setQuery(matchAllQuery())
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
                assertThat(Arrays.toString(sortValues), sortValues[i - 1], lessThanOrEqualTo(sortValues[i]));
import org.opensearch.action.search.SearchRequestBuilder;
                            "foo",
        }
            int size = between(1, denseBytes.size());
        }
            .setQuery(QueryBuilders.functionScoreQuery(matchAllQuery(), ScoreFunctionBuilders.fieldValueFactorFunction("field")))
        builders.add(client().prepareIndex("new_index").setSource("route_length_miles", 100.2));
    public void testSortMixedIntegerNumericFields() throws Exception {
            assertThat(((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).doubleValue(), closeTo(0.1d * (9 - i), 0.000001d));
                .get();
            .get();
                    .startObject("properties")
    private void index(String type, Supplier<Number> valueSupplier) throws Exception {
                );
        // We sort on nested field
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).floatValue(), equalTo(3f));
                    .array("short_values", 2, 1, 3, -4)
        indexRandom(true, true, builders);
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
            )
            .addSort(SortBuilders.fieldSort("l_value").order(SortOrder.ASC).missing("_first"))
 * GitHub history for details.
        hits = searchResponse.getHits().getHits();
import java.util.List;
        assertThat(searchResponse.getHits().getAt(1).getId(), is(oneOf("3", "2")));
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(2)));
                    .startObject()
                .get();
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(3)));
        refresh();
        counter.set(0);
    public void testCastNumericTypeExceptions() throws Exception {
        for (int i = 0; i < size; i++) {
                    .startObject()
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
        assertThat(searchResponse.getHits().getAt(1).getScore(), Matchers.lessThan(searchResponse.getHits().getAt(0).getScore()));
import org.opensearch.action.search.ShardSearchFailure;
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("string_values", SortOrder.DESC).get();
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), equalTo(10d));
            assertEquals(1712879236854775807L, hits.getAt(0).getSortValues()[0]);
            response = client().prepareSearch()
                assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(next.getValue()));
                    .startObject("boolean_value")
            }
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
                refresh();
        );
                .setSize(1)
import org.opensearch.script.MockScriptPlugin;
            refresh();
            }
        assertThat(searchResponse.getHits().getAt(1).getSortValues()[0].toString(), equalTo("10"));
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
        }
            .get();
        assertEquals(2, response.getHits().getTotalHits().value());
        SearchResponse searchResponse = client().prepareSearch()
        assertNoFailures(searchResponse);
                );
                    .endObject()
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
                .addSort(SortBuilders.fieldSort("field").setNumericType("date_nanos"))
                    .endObject()
        assertThat(searchResponse.toString(), not(containsString("error")));
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), equalTo(20d));
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
        List<IndexRequestBuilder> builders = new ArrayList<>();
            SearchResponse result = client().prepareSearch().setQuery(matchAllQuery()).addSort(SortBuilders.fieldSort("kkk")).get();
 * SPDX-License-Identifier: Apache-2.0
        // rendered and parsed (search_after)
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
                jsonBuilder().startObject()
        logger.info("--> sort with missing _first");
                .addSort("_id", order)
        refresh();
            .setQuery(matchAllQuery())
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.fieldValueFactorFunction;
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));
        // STRING
        refresh();
    public void testSortMixedFloatingNumericFields() throws Exception {
            assertEquals(12.1D, (double) hits.getAt(1).getSortValues()[0], 0.001f);
        assertThat(searchResponse.getHits().getAt(2).getId(), is(oneOf("2", "3")));
            assertEquals(1712879236854L, hits.getAt(0).getSortValues()[0]);
    }
            assertFirstHit(resp, hasId("1"));
            if (i % 3500 == 0) {
            .setId("1")
            )
import org.apache.lucene.util.UnicodeUtil;
    }
            .addSort(SortBuilders.fieldSort("u_value").order(SortOrder.ASC).missing(randomBoolean() ? -1 : "-1"));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFirstHit;
            Map<?, ?> doc = (Map) vars.get("doc");
import java.util.Iterator;
            .setQuery(matchAllQuery())
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));
                XContentFactory.jsonBuilder()
        assertAcked(prepareCreate("index_date").setMapping("field", "type=date"));
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).floatValue(), equalTo(1f));
            assertThat(hit.getScore(), not(equalTo(Float.NaN)));
                    .addSort(
        assertNoFailures(searchResponse);
                    .field("type", "integer")
        assertThat(hits.length, is(2));
        client().prepareIndex("test").setId("2").setSource("{\"field1\":\"value2\"}", MediaTypeRegistry.JSON).get();
                    .endObject()
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
import org.apache.lucene.tests.util.TestUtil;
        assertHitCount(searchResponse, docs);
                    .array("long_values", 1L, 5L, 10L, 8L)
                    .startObject("u_value")
    public void testSortOnRareField() throws IOException, InterruptedException {
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(docs / 2 - 1 - i)));
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), equalTo(3d));
        builders.add(client().prepareIndex("index_date_nanos").setSource("field", "2024-04-11T23:47:16.854775807Z"));
            List<IndexRequestBuilder> docs = new ArrayList<>();
        assertAcked(prepareCreate("index_long").setMapping("field", "type=long"));
        Random random = random();
                    .field("foo", "bar bar")
    }
        int size = between(0, 256);
                    .field("l_value", Long.MIN_VALUE)
                    .startObject("integer_value")
            )
            .setQuery(matchAllQuery())
        for (int i = 0; i < size; i++) {
import java.math.BigInteger;
            refresh();
            .get();
        {
    public FieldSortIT(Settings dynamicSettings) {
            bulkBuilder.add(client().prepareIndex("test1").setId(Integer.toString(i)).setSource(source, MediaTypeRegistry.JSON));
import java.io.IOException;
        index("integer", () -> Integer.MAX_VALUE - counter.getAndIncrement());
        assertThat(searchResponse.getHits().getAt(2).getScore(), Matchers.lessThan(searchResponse.getHits().getAt(1).getScore()));
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
            .setQuery(matchAllQuery())
        for (int i = 0; i < numIndices; i++) {
                    () -> client().prepareSearch()
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(1)));
        int numDocs = randomIntBetween(200, 300);
                    .endObject()
                        .field("short_value", i)
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("3"));
                    .startObject("str_value")
        for (int i = 0; i < size; i++) {
            .get();
                    .startObject("properties")
                .get();
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
        assertThat(searchResponse.getHits().getAt(2).getSortValues()[0], equalTo("03"));
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("3"));
            .get();
        logger.info("--> sort with no missing");
    public void testScoreSortDirection() throws Exception {
            .setQuery(matchAllQuery())
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
                    .endObject()
                client().admin().indices().prepareDelete("test").get();
                    .endObject()
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("double_values", SortOrder.ASC).get();
        for (int i = 0; i < numDocs; i++) {
        index(
            .get();
            assertThat(((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).doubleValue(), closeTo(0.1d * i, 0.000001d));
            .addSort(SortBuilders.fieldSort("d_value").order(SortOrder.ASC).missing("_last"))
            .addSort("_score", SortOrder.DESC)
                .addSort(SortBuilders.fieldSort("field").setNumericType("date"))
                jsonBuilder().startObject()
            .get();
        indexRandomForConcurrentSearch("test1");
            prepareCreate("test").setMapping(
        }
        }
            .get();
        client().prepareIndex("test").setId(Integer.toString(1)).setSource("field", Integer.toString(1)).get();
        for (int i = 0; i < 15; i++) {
                .setId(Integer.toString(300 + i))
            assertFirstHit(resp, hasId("3"));
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
        indexRandomForConcurrentSearch("test");
    public void testSortDuelBetweenSingleShardAndMultiShardIndex() throws Exception {
                .setMapping(sortField, "type=long")
        }
            for (int i = 1; i < 20; i++) {
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        for (int i = 0; i < size; i++) {
import org.opensearch.action.index.IndexRequestBuilder;
        refresh();
            .setId("3")
                    .endObject()
            .setQuery(matchAllQuery())
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(3)));
    }
        assertNoFailures(searchResponse);
            }
        );
                XContentFactory.jsonBuilder()
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        BulkRequestBuilder bulkBuilder = client().prepareBulk();
                assertThat(previous, order == SortOrder.ASC ? lessThan(id) : greaterThan(id));
        logger.info("--> sort with missing _first");
                    .startObject("double_value")
                    .startObject("double_values")
        assertAcked(
    public static Collection<Object[]> parameters() {
            .setSource(
            Set<Entry<BytesRef, String>> entrySet = sparseBytes.entrySet();
                    .startObject("byte_value")
            }
        logger.info("--> sort with missing _first");
            IndexRequestBuilder builder = client().prepareIndex("test")
        }
        assertThat(searchResponse.getHits().getAt(2).getScore(), Matchers.lessThan(searchResponse.getHits().getAt(1).getScore()));
            assertThat(searchResponse.getHits().getHits().length, equalTo(size));
            Number previous = (Number) searchResponse.getHits().getHits()[j - 1].getSourceAsMap().get("entry");
            final String indexId = "idx_" + i;
        for (int i = 0; i < multiShardResponse.getHits().getHits().length; i++) {
            .setQuery(matchAllQuery())
            SearchResponse response = client().prepareSearch()
        }
        size = 1 + random.nextInt(10);
            client().prepareIndex("test")
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        searchResponse = client().prepareSearch()
            .addSort(SortBuilders.fieldSort("route_length_miles"))
        SearchResponse searchResponse = client().prepareSearch()
                equalTo(UNSIGNED_LONG_BASE.add(BigInteger.valueOf(10000 * (9 - i))))
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        // LONG
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(3)));
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
            .setSize(10)
            }
                assertAcked(prepareCreate("test_" + i).addAlias(new Alias("test")).setMapping("entry", "type=long"));
            builders.add(builder);
            .get();
                    .array("long_values", 2L, 1L, 3L, -4L)
import static org.hamcrest.Matchers.closeTo;
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        List<String> keywords = new ArrayList<>();
        size = 1 + random.nextInt(10);
                    .field("foo", "cba bca")
    }
            }
        response = client().prepareSearch("test").addSort(SortBuilders.fieldSort("ip")).searchAfter(new Object[] { "192.168.1.7" }).get();
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
            .setSource(
                .setSize(randomIntBetween(1, numDocs + 5))
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));
        assertEquals(120.3, hits.getAt(2).getSortValues()[0]);
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
            long currentLong = (long) hit.getSortValues()[0];
        assertNoFailures(searchResponse);
        final int size = 2;
            assertThat(resp.getHits().getHits().length, equalTo(2));
            SearchHit hit = searchResponse.getHits().getHits()[i];
                XContentFactory.jsonBuilder()
            String docId = Integer.toString(i);
        }
        assertNoFailures(searchResponse);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import static org.opensearch.index.query.QueryBuilders.functionScoreQuery;
                    .endObject()
                        .field("boolean_value", true)
            .get();
        }
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[0], equalTo("!4"));
            .setSize(10)
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), equalTo(1d));
        searchResponse = client().prepareSearch()
            );
        client().prepareIndex("test")
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("1"));
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("2"));
        }
        searchResponse = client().prepareSearch()
        @Override
        assertEquals(42.0, hits.getAt(0).getSortValues()[0]);
            client().prepareIndex("test").setId("4").setSource("tag", "delta").get();
        searchResponse = client().prepareSearch()
        );
        assertHitCount(searchResponse, 10L);
                    .startObject("string_values")
            indexRandomForConcurrentSearch("test");
                );
            .setSource(
                .get();
                .get();
            )
                        .field("str_value", new String(new char[] { (char) (97 + i), (char) (97 + i) }))
                assertThat(hits.getAt(i).getSortValues()[0].getClass(), equalTo(Long.class));
        }
        assertThat(searchResponse.toString(), not(containsString("error")));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
 *    http://www.apache.org/licenses/LICENSE-2.0
        {
                searchResponse.getHits().getAt(i).getSortValues()[0].toString(),
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(docs / 2 - 1 - i)));
            .addSort(SortBuilders.fieldSort("d_value").order(SortOrder.ASC))
        builders.add(client().prepareIndex("index_date").setSource("field", "2024-04-11T23:47:17"));
import org.opensearch.cluster.metadata.IndexMetadata;
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("2"));
        indexRandom(true, indexReqs);
        for (int i = 0; i < numIndices; i++) {
        assertThat(searchResponse.getHits().getAt(0).getId(), is(oneOf("2", "1")));
        }
        for (int i = 0; i < 10; i++) {
        indexRandomForConcurrentSearch("test");
            .setQuery(matchAllQuery())
 *
            jsonBuilder().startObject().field("id", "2").field("svalue", "bbb").field("ivalue", 200).field("dvalue", 0.2).endObject()
            .addSort(SortBuilders.fieldSort("route_length_miles").missing(120.3))
            builders.add(builder);
                .setId(Integer.toString(300 + i))
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(3).addSort("string_values", SortOrder.DESC).get();
        // sort ASC
                .addSort(SortBuilders.scriptSort(script, ScriptSortBuilder.ScriptSortType.STRING))
            // unset cluster setting
            .setQuery(matchAllQuery())
            .get();
        for (int i = 0; i < 5; i++) {
            }
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
        ensureGreen();
                    .field("type", "keyword")
                    .startObject("properties")
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        assertAcked(prepareCreate("index").setMapping("keyword", "type=keyword", "ip", "type=ip"));
                .addSort(new FieldSortBuilder("timeUpdated").order(SortOrder.ASC).unmappedType("date"))
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", Integer.toString(i)).get();
                    .startObject("bar")
            SearchHits hits = response.getHits();
        assertAcked(
        for (int i = 0; i < 10; i++) {
            assertHitCount(resp, 4);
                    .field("type", "integer")
            .setQuery(matchAllQuery())
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("2"));
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[0], equalTo("20"));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        // force merge
            .setId(Integer.toString(1))
        for (int i = 0; i < size; i++) {
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("double_value", SortOrder.ASC).get();
        assertThat(hits[0].getSortValues()[0], is("cba bca"));
        static String sortStringScript(Map<String, Object> vars) {
        SearchResponse searchResponse = client().prepareSearch("long", "integer", "double", "float")
        searchResponse = client().prepareSearch()
            assertThat(response.getShardFailures().length, equalTo(1));
                XContentFactory.jsonBuilder()
            throw new RuntimeException();
                .addSort("dense_bytes", SortOrder.ASC)
            .addSort(SortBuilders.fieldSort("d_value").order(SortOrder.ASC))
            refresh();
            assertThat(hits.getAt(0).getSortValues()[0].getClass(), equalTo(Long.class));
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[0], equalTo("20"));
            .get();
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).longValue(), equalTo(1L));
        createIndex("test");
            for (int i = 0; i < 3; i++) {
        // UNSIGNED_LONG
                    .array("string_values", "01", "05", "10", "08")
        assertAcked(client().admin().indices().prepareCreate("test").setMapping("svalue", "type=keyword").get());
                    .endObject()
        client().prepareIndex("test")
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(2)));
            assertEquals(1712879236854L, hits.getAt(0).getSortValues()[0]);
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).longValue(), equalTo(13L));
            .setId("1")
        }
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(3)));
                    jsonBuilder().startObject()
                    .endObject()
                .setSize(1)
        searchResponse = client().prepareSearch()
 *
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(3)));
                    .startObject("properties")
                }
                    .field("type", type)
        );
            jsonBuilder().startObject().field("id", "1").field("svalue", "aaa").field("ivalue", 100).field("dvalue", 0.1).endObject()
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[0].toString(), equalTo("1"));
                .setQuery(matchAllQuery())
            ensureGreen();
                        .field("half_float_value", 16 * i)
import org.opensearch.common.SuppressForbidden;
            try {
                    .startObject("properties")
                assertThat(hit.getSortValues()[1], equalTo(1f));
                assertThat("pos: " + i, searchResponse.getHits().getAt(i).getId(), equalTo(next.getValue()));
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numDocs];
                .setSource(
                    .field("type", "nested")
                assertThat(shardSearchFailure.toString(), containsString("[No mapping found for [kkk] in order to sort on]"));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                Entry<BytesRef, String> next = iterator.next();
                        .field("byte_value", i)
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        assertAcked(prepareCreate("index_double").setMapping("field", "type=double"));
                    .startObject("d_value")
                assertThat(searchResponse.getHits().getAt(i).getSortValues()[0].toString(), equalTo(next.getKey().utf8ToString()));
                    jsonBuilder().startObject().field("str_value", new String(new char[] { (char) (97 + i), (char) (97 + i) })).endObject()
            .get();
        for (int i = 0; i < size; i++) {
        assertEquals(42.0, hits.getAt(0).getSortValues()[0]);
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("float_values", SortOrder.DESC).get();
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        assertHitCount(searchResponse, 10L);
            )
                    .field("type", "integer")
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(2)));
    }
                .setSize(randomIntBetween(1, numDocs + 5))
                    .field("type", "integer")
        final Settings.Builder singleShardSettings = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1);
        {
        for (int j = 1; j < searchResponse.getHits().getHits().length; j++) {
            .setTrackScores(true)
        SearchResponse response = client().prepareSearch("test").addSort(SortBuilders.fieldSort("ip")).get();
        for (int i = 0; i < searchResponse.getHits().getHits().length; i++) {
        logger.info("--> sort with negative missing value");
        client().prepareIndex("test").setId("3").setSource("field", 0).get();
                    .endObject()
            prepareCreate("test").setMapping(
            )
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("2"));
            builders.clear();
                    .endObject()
                .addSort(SortBuilders.scoreSort())
            )
            Number current = (Number) searchResponse.getHits().getHits()[j].getSourceAsMap().get("entry");
            assertThat(((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).intValue(), equalTo(i));
                    .array("float_values", 1f, 5f, 10f, 8f)
            assertEquals(12.6D, hits.getAt(2).getSortValues()[0]);
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(3)));
            .addSort(new FieldSortBuilder("entry").order(SortOrder.DESC).unmappedType(useMapping ? null : "long"))
        }
        }
            assertNoFailures(searchResponse);
                docs.add(client().prepareIndex(index).setId(Integer.toString(i)).setSource(sortField, i));
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
            .setSize(15)
        // SHORT
        assertThat(searchResponse.toString(), not(containsString("error")));
        }
            .setSource(jsonBuilder().startObject().field("id", "1").field("i_value", -1).field("d_value", -1.1).endObject())
                    .startObject("sparse_bytes")
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(3)));
            for (SearchHit hit : searchResponse.getHits()) {
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(3)));
import static org.hamcrest.Matchers.equalTo;
        } else {
                .get();
        client().admin().indices().prepareRefresh(type).get();
        assertThat(hits[0].getSortValues().length, is(1));
        // *** 1. sort DESC on long_field
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
            .addSort(SortBuilders.fieldSort("kkk").unmappedType("keyword"))
                        SortBuilders.fieldSort("nested.bar.foo")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                    .field("type", "long")
                    .endObject()
            SearchResponse searchResponse = client().prepareSearch("test")
        assertEquals(3, hits.getHits().length);
                    .startObject("properties")
                    .array("float_values", 11f, 15f, 20f, 7f)
        SearchResponse response = client().prepareSearch()
            .setQuery(matchAllQuery())
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
import java.util.Map.Entry;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            client().prepareIndex("test")
            long currentLong = (long) hit.getSortValues()[0];
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(3)));
            Iterator<Entry<BytesRef, String>> iterator = entrySet.iterator();
                    .field("type", "long")
                    .endObject()
                .setQuery(matchAllQuery())
                        .endObject()
            .setSize(size)
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("long_value", SortOrder.DESC).get();
        assertHitCount(searchResponse, docs);
                    .field("foo", "abc abc")
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).floatValue(), equalTo(10f));
        }
                    .startObject("properties")
                .setMaxConcurrentShardRequests(1)
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));
        assertThat(searchResponse.getHits().getAt(2).getSortValues()[0], equalTo("07"));
        builders.add(client().prepareIndex("index_double").setSource("field", 12.6));
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("2"));
            .get();
        SearchResponse response = client().prepareSearch()
            .setQuery(functionScoreQuery(matchAllQuery(), fieldValueFactorFunction("field")))
import org.opensearch.plugins.Plugin;
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("byte_values", SortOrder.DESC).get();
                    .endObject()
                    jsonBuilder().startObject()
        List<IndexRequestBuilder> builders = new ArrayList<>();
            indexReqs[i] = client().prepareIndex("test").setSource("number", i, "keyword", Integer.toString(i));
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).intValue(), equalTo(3));
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("short_value", SortOrder.ASC).get();
                .get();
            .addSort(SortBuilders.fieldSort("d_value").order(SortOrder.ASC).missing("_last"))
            SearchHits hits = response.getHits();
        );
        assertThat(searchResponse.getHits().getAt(1).getScore(), Matchers.lessThan(searchResponse.getHits().getAt(0).getScore()));
            .setQuery(matchAllQuery())
import org.opensearch.common.xcontent.XContentType;
                    .array("half_float_values", 2f, 1f, 3f, -4f)
    }
        assertNoFailures(searchResponse);
        // TODO: WTF?
            .setSize(builders.size())
            .setQuery(matchAllQuery())
                                new NestedSortBuilder("nested").setNestedSort(new NestedSortBuilder("nested.bar").setMaxChildren(1))
            .addSort(SortBuilders.fieldSort("field").order(SortOrder.ASC).sortMode(SortMode.MAX))
                    .field("type", "keyword")
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
        assertNoFailures(searchResponse);
        for (int i = 0; i < 15; i++) {
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
     */
                    .endObject()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).intValue(), equalTo(10));
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
            .setQuery(matchAllQuery())
                Entry<BytesRef, String> next = iterator.next();
                    .field("type", "unsigned_long")
        assertThat(searchResponse.toString(), not(containsString("error")));
            assertThat(
        refresh();
            .get();
        }
        assertAcked(
        assertArrayEquals(new String[] { "2001:db8::ff00:42:8329" }, response.getHits().getAt(0).getSortValues());
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("float_value", SortOrder.DESC).get();
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("3"));
                assertThat(hit.getSortValues().length, equalTo(2));
            }
            SortOrder order = randomFrom(SortOrder.values());
        {
                jsonBuilder().startObject()
            .get();
import static org.hamcrest.Matchers.lessThan;
import org.opensearch.index.query.QueryBuilders;
            assertThat(
        }
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
                    .endObject()
        searchResponse = client().prepareSearch()
        assertThat(searchResponse.getHits().getAt(2).getSortValues()[0].toString(), equalTo("100"));
                        .field("str_value", new String(new char[] { (char) (97 + i), (char) (97 + i) }))
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[0].toString(), equalTo("1"));
            .setQuery(matchAllQuery())
        // We keep half of the docs with numeric values and other half without
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).intValue(), equalTo(-4));
        assertThat(searchResponse.getHits().getAt(1).getId(), is(oneOf("3", "2")));
                    .field("type", "double")
        assertHitCount(searchResponse, 10);
            .get();
                .setTransientSettings(Settings.builder().putNull(IndicesService.INDICES_ID_FIELD_DATA_ENABLED_SETTING.getKey()))
        );
        indexRandom(true, builders);
                assertThat(exc.status(), equalTo(RestStatus.BAD_REQUEST));
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("2"));
        AtomicInteger counter = new AtomicInteger();
    public void test3078() {
        }
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("2"));
        );
        client().prepareIndex("test").setId("3").setSource("field", 0).get();
        super(dynamicSettings);
        size = 1 + random.nextInt(10);
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        assertNoFailures(searchResponse);
        indexRandomForConcurrentSearch("old_index", "new_index");
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("half_float_value", SortOrder.DESC).get();
        assertNoFailures(searchResponse);
            assertThat(((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).shortValue(), equalTo((short) (9 - i)));
        ensureSearchable("test1", "test2");
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("2"));
            Number previous = (Number) searchResponse.getHits().getHits()[j - 1].getSourceAsMap().get("entry");
        flush();
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        logClusterState();
        client().prepareIndex("test")
            .setQuery(matchAllQuery())
                    .field("type", "byte")
                    .setNestedSort(new NestedSortBuilder("nested").setFilter(QueryBuilders.termQuery("nested.foo", "abc")))
                    .startObject("short_value")
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).intValue(), equalTo(1));
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("2"));
 * Licensed to Elasticsearch under one or more contributor
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));
            .addSort("field1", SortOrder.ASC)
import java.util.Set;
            )
    @Override
            assertFalse(Float.isNaN(hit.getScore()));
                    .field("type", "float")
        }
            int expectedValue = 0;
                    .endObject()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
                    .field("type", "text")
        refresh();
            .setSize(size)
        // LONG
                    .endObject()
        assertThat(hits[1].getSortValues()[0], is("abc"));
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("2"));
            int size = between(1, sparseBytes.size());
                    .endObject()
        refresh();
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
        if (!sparseBytes.isEmpty()) {
                    .endObject()
            .prepareUpdateSettings()
        }
            )
            assertNoFailures(searchResponse);
            response = client().prepareSearch()
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo(Integer.toString(1)));
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(9 - i)));
        index("half_float", () -> 300.5 - counter.getAndIncrement());
            );
        ensureGreen();
            .get();
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).addSort("half_float_values", SortOrder.DESC).get();
        searchResponse = client().prepareSearch("test")
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).intValue(), equalTo(7));
    }
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));
                .cluster()
                        .field("short_value", i)
        size = 1 + random.nextInt(10);
        assertThat(searchResponse.toString(), not(containsString("error")));
                .get();
            "type1",
        // reindex and refresh
        logClusterState();
        assertAcked(prepareCreate("index_float").setMapping("field", "type=float"));
        assertThat(hits.length, is(2));
            .get();
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));
        assertNoFailures(searchResponse);
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));
        logger.info("--> sort with missing _first");
                .addSort(SortBuilders.fieldSort("field").order(SortOrder.DESC).setNumericType("date"))
            if (rarely()) {
            .setQuery(matchAllQuery())
                                + " "
            prepareCreate("test1").setSettings(
 * this file be licensed under the Apache-2.0 license or a
        // one, and a concrete field in the other.
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo(Integer.toString(2)));
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
                    .startObject("properties")
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[0].toString(), equalTo("1"));
            .get();
        }
        assertHitCount(searchResponse, 10);
            assertThat(((Number) searchResponse.getHits().getAt(i).getSortValues()[0]).byteValue(), equalTo((byte) (9 - i)));
        assertNoFailures(searchResponse);
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
            .get();
                assertThat(hit.getSortValues()[0], equalTo(keywords.get(expectedValue++)));
    public void testSortMissingStrings() throws IOException, InterruptedException {
            .setSource(
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
import static org.hamcrest.Matchers.oneOf;
                .get();
            assertEquals(12L, hits.getAt(2).getSortValues()[0]);
                () -> client().prepareSearch()
        assertEquals(100.2, hits.getAt(2).getSortValues()[0]);
                    .endObject()
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(9 - i)));
        logger.info("--> sort with missing _last");
            double expectedValue = 0;
                    .endObject()
                    .endObject()
            .addSort(
        }
        assertThat(searchResponse.getHits().getAt(2).getSortValues()[0], equalTo("03"));
            .setQuery(matchAllQuery())
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        assertThat(searchResponse.toString(), not(containsString("error")));
                    .array("double_values", 1d, 5d, 10d, 8d)
            .setQuery(matchAllQuery())
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("long_value", SortOrder.ASC).get();
        refresh();
        indexRandomForConcurrentSearch("test");
                    .startArray("nested")
                assertThat(Arrays.toString(sortValues), sortValues[i - 1], greaterThanOrEqualTo(sortValues[i]));
                    .startObject("integer_value")
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        assertHitCount(searchResponse, 10);
        }
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
            assertEquals(2, hits.getHits().length);
import org.opensearch.core.xcontent.XContentBuilder;
        for (int i = 0; i < 20; i++) {
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
    public void testRandomSorting() throws IOException, InterruptedException, ExecutionException {
        }
                .setSize(10)
            .get();
                    .field("type", "boolean")
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo(Integer.toString(2)));
            hits = response.getHits();
 * compatible open source license.
        searchResponse = client().prepareSearch()
            .setSize(builders.size())
        assertNoFailures(searchResponse);
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[0].toString(), equalTo("1"));
                    .must(QueryBuilders.rangeQuery("timeUpdated").gte("2014/0" + randomIntBetween(1, 7) + "/01"))
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        indexRandomForConcurrentSearch("test");
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), equalTo(7d));
 * The OpenSearch Contributors require contributions made to
                    .startObject("properties")
                .setSize(scaledRandomIntBetween(1, docs))
                        .field("unsigned_long_value", UNSIGNED_LONG_BASE.add(BigInteger.valueOf(10000 * i)))
                    .endArray()
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
            assertThat(Arrays.toString(sortValues), sortValues[i - 1], lessThan(sortValues[i]));
                .get();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        }
        }
            for (int i = 0; i < size; i++) {
        List<IndexRequestBuilder> builders = new ArrayList<>();
            IndexRequestBuilder builder = client().prepareIndex("test")
            .addSort(SortBuilders.fieldSort("u_value").order(SortOrder.ASC))
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            .get();
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(9 - i)));
        }
        }
        assertThat(searchResponse.getHits().getAt(0).getId(), is(oneOf("2", "1")));
        logger.info("--> sort with missing _first");
            refresh();
            hits = response.getHits();
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        return Arrays.asList(
        }
        }
            .setSize(20)
            .get();
                assertThat(hit.getSortValues()[1], equalTo(1f));
        assertThat(searchResponse.getHits().getAt(1).getSortValues()[0], equalTo("10"));
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("half_float_value", SortOrder.DESC).get();
        refresh();
        assertSearchResponse(searchResponse);
                .setId(Integer.toString(i))
    }
                    .endObject()
            .get();
            assertThat(
        }
        );
            .get();
        assertThat(searchResponse.getHits().getAt(1).getSortValues()[0], equalTo("10"));
                    .startObject()
        searchResponse = client().prepareSearch()
        int size = 1 + random.nextInt(10);
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));
            scripts.put("doc['number'].value", vars -> sortDoubleScript(vars));
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
                XContentFactory.jsonBuilder()
        for (int i = 1; i <= 7000; i++) {
        client().prepareIndex("test").setId(Integer.toString(1)).setSource("field", Integer.toString(1)).get();
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("integer_value", SortOrder.DESC).get();
            for (ShardSearchFailure shardSearchFailure : e.shardFailures()) {
        // The order here could be unstable (depends on document order) since missing == field value
        SearchResponse searchResponse = client().prepareSearch("test")
                    .endObject()
        logger.info("--> sort with no missing");
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
 * the Apache License, Version 2.0 (the "License"); you may
            .get();
        Collections.shuffle(builders, random);
            .addSort(SortBuilders.fieldSort("u_value").order(SortOrder.ASC).missing("_first"))
        client().prepareIndex("test")
        assertArrayEquals(new String[] { "2001:db8::ff00:42:8329" }, response.getHits().getAt(1).getSortValues());
            builders.clear();
                    .endObject()
        logger.info("--> sort with missing _last");
        builders.add(client().prepareIndex("old_index").setSource(Collections.emptyMap()));
import java.util.concurrent.atomic.AtomicInteger;
        builders.add(client().prepareIndex("index_float").setSource("field", 12.1));
        assertThat(searchResponse.getHits().getAt(2).getSortValues()[0].toString(), equalTo("100"));
                .get();
            .get();
        assertThat(searchResponse.getHits().getHits().length, equalTo(2));
        int from = between(0, 256);
                    .endObject()
    public void testIgnoreUnmapped() throws Exception {
            .setQuery(matchAllQuery())
        client().prepareIndex("test").setId("2").setSource("field", 1).get();
                    .field("type", "keyword")
                .addSort(SortBuilders.scoreSort())
        assertNoFailures(searchResponse);
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(i)));
        searchResponse = client().prepareSearch("test")
        // *** 2. sort ASC on long_field
        // HALF_FLOAT
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).intValue(), equalTo(20));
        AtomicInteger counter = new AtomicInteger();
                builders.add(
        assertHitCount(searchResponse, 10);
            .addSort("half_float_value", SortOrder.ASC)
 * You may obtain a copy of the License at
            prepareCreate("test").setMapping(
import java.util.function.Supplier;
        for (SearchHit hit : result.getHits()) {
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(Integer.toString(9 - i)));
        );
        searchResponse = client().prepareSearch()
                .get();
            client().prepareIndex("test")
        assertHitCount(searchResponse, docs);
        assertEquals(3, hits.getHits().length);
            .setSource(jsonBuilder().startObject().field("id", "1").field("value", "a").endObject())
                .setQuery(matchAllQuery())
                    .startObject("fields")
                    .field("type", "text")
            indexRandom(true, indexReqs);
                    .startObject("nested")
        size = 1 + random.nextInt(10);
        }
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).floatValue(), equalTo(3f));
            .setQuery(functionScoreQuery(matchAllQuery(), fieldValueFactorFunction("field")))
            }
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).floatValue(), equalTo(10f));
                .setSize(2)
            .addSort("unsigned_long_value", SortOrder.DESC)
        if (asc) {
            .get();
        assertAcked(prepareCreate("old_index").setMapping("distance", "type=double", "route_length_miles", "type=alias,path=distance"));
            )
                    .startObject("float_value")
        }
                    .field("u_value", Numbers.MIN_UNSIGNED_LONG_VALUE)
                equalTo(UNSIGNED_LONG_BASE.add(BigInteger.valueOf(10000 * i)))
            .addSort("unsigned_long_value", SortOrder.DESC)
            .get();
            // assertWarnings(ID_FIELD_DATA_DEPRECATION_MESSAGE);
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, between(2, maximumNumberOfShards()))
