                .startObject(FIELD)
            XContentBuilder source = jsonBuilder().startObject()
        assertThat(indexResponse.status(), equalTo(RestStatus.CREATED));
        }
            .endObject();
            XContentBuilder source = jsonBuilder().startObject()
            XContentBuilder source = jsonBuilder().startObject()
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);
        for (int i = 0; i < numDocs; i++) {
        }
        createIndexAndMapping(mapping);
                .endObject()
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>();
        indexRandom(true, indexRequestBuilders);
                            .endObject()
 *
        multiContextBoostSuggest.contexts(contextMap);
                .field("input", "suggestion" + i)
                .field("type", "type" + i % 4)
            );
import java.io.IOException;
                .field("input", "suggestion" + i)
    public void testGeoField() throws Exception {
            );
                    )
                    Collections.singletonList(CategoryQueryContext.builder().setCategory("type").setPrefix(true).build())
            indexRequestBuilders.add(
        CompletionSuggestionBuilder typeBoostSuggest = SuggestBuilders.completionSuggestion(FIELD).prefix("sugg");
                            .startObject(FIELD)
        CategoryContextMapping contextMapping = ContextBuilder.category("cat").field("cat").build();
        int numUnique = randomIntBetween(1, numDocs);
        // the score of each suggestion is the maximum score among the matching contexts
                source.field("type", "type" + i % 3);
    }
                    "cat",
        XContentBuilder source1 = jsonBuilder().startObject()
        assertSuggestions("foo", contextSuggestQuery, "suggestion");
            searchResponse.getSuggest().getSuggestion(suggestionName).iterator().next().getOptions().iterator().next().getText().string()
import org.opensearch.search.suggest.completion.context.ContextMapping;
            .setSource(
    }
 * SPDX-License-Identifier: Apache-2.0
        assertSuggestions("foo", typeBoostSuggest, "suggestion9", "suggestion5", "suggestion6", "suggestion1", "suggestion2");
    }
        Map<String, List<? extends ToXContent>> contextMap = new HashMap<>();
                    "cat",
import org.opensearch.search.suggest.completion.context.ContextBuilder;
        for (int i = 0; i < numDocs; i++) {
    public void testContextRegex() throws Exception {
        mapping.endObject(); // location
        int numDocs = 10;
        );
            .latlon("pin", 52.363389, 4.888695)
    public void testSkipDuplicatesWithContexts() throws Exception {
        int numDocs = randomIntBetween(10, 100);
        }
                client().prepareIndex(INDEX)
                    CategoryQueryContext.builder().setCategory("type1").setBoost(4).build()
        contextMap.put(
            .endObject()
        if (randomBoolean()) {
        assertSuggestions("foo", prefix, "suggestion9", "suggestion8", "suggestion7", "suggestion6", "suggestion5");
                .endObject();
        map.put("type", ContextBuilder.category("type").field("type").build());
                        if (fieldName != null) {
 * Unless required by applicable law or agreed to in writing,
        CompletionSuggestionBuilder multiContextBoostSuggest = SuggestBuilders.completionSuggestion(FIELD).prefix("sugg");
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();
        CompletionSuggestionBuilder geoFilteringPrefix = SuggestBuilders.completionSuggestion(FIELD)
            XContentBuilder source = jsonBuilder().startObject()
            indexRequestBuilders.add(client().prepareIndex(INDEX).setId("" + i).setSource(source));
            );
                            .startObject(FIELD)
/*
        );
        assertSuggestions("foo", prefix, "suggestion0", "suggestion1", "suggestion2", "suggestion3", "suggestion4");
                            .field("input", "suggestion" + i)
        assertSuggestions("foo", typeFilterSuggest, "suggestion9", "suggestion6", "suggestion5", "suggestion2", "suggestion1");
            .prefix("sugg")
                    "geo",
            .setId("1")
                .endObject()
            }
        CompletionSuggestionBuilder context = SuggestBuilders.completionSuggestion(FIELD)
        }
import org.opensearch.search.suggest.completion.CompletionSuggestionBuilder;
            .startObject("location")
        // filter only on context type
                )
            .filter((s) -> Integer.parseInt(s.substring("suggestion".length())) % 2 == 0)
        CompletionSuggestionBuilder prefix = SuggestBuilders.completionSuggestion(FIELD)
            mapping.endArray();
        if (completionMappingBuilder.contextMappings != null) {
        CompletionSuggestionBuilder completionSuggestionBuilder = SuggestBuilders.completionSuggestion(FIELD)
        }
                        jsonBuilder().startObject()
            }
        List<String> neighbours = new ArrayList<>();
                    )
                .field("input", "suggestion" + i)
                        }
                .field("type", "type" + id)
        }
 *
            if (addAnotherContext) {
            mapping.field("index", "false");
        }
                .field("weight", id)
 * this work for additional information regarding copyright
    public static Collection<Object[]> parameters() {
                    "cat",
            source.endObject();
        String[] expected = new String[numUnique];
 * ownership. Elasticsearch licenses this file to you under
                            categoryContextFields.add(fieldName);
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>(Collections.singletonMap("cat", contextMapping));
                .endObject();
                .startObject(FIELD)
    }
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);
            Arrays.asList(
                CategoryQueryContext.builder().setCategory("type1").setBoost(4).build()
        assertSuggestions("foo", prefix, "sugxgestion9", "sugxgestion8", "sugxgestion7", "sugxgestion6", "sugxgestion5");
        mapping.startObject("location");
                    Arrays.asList(
                )
                .field("input", "sugg" + i + "estion")
                .field("input", "sugxgestion" + i)
            indexRequestBuilders.add(client().prepareIndex(INDEX).setId("" + i).setSource(source));
        mapping.startObject(FIELD);
            .contexts(
        for (int i = 0; i < numDocs; i++) {
            );
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>(Collections.singletonMap("cat", contextMapping));
        assertSuggestions("foo", prefix, "sugg9estion", "sugg8estion", "sugg7estion", "sugg6estion", "sugg5estion");
        indexRandom(true, indexRequestBuilders);
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);
                .startObject(FIELD)
            .skipDuplicates(true)
            indexRequestBuilders.add(client().prepareIndex(INDEX).setId("" + i).setSource(source));
                .startObject("contexts")
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();
/*
import java.util.List;
package org.opensearch.search.suggest;
        map.put("cat", ContextBuilder.category("cat").field("cat").build());
                .field("input", "suggestion" + i)
import java.util.ArrayList;
        assertSuggestions("foo", prefix, "suggestion8", "suggestion6", "suggestion4", "suggestion9", "suggestion2");
                jsonBuilder().startObject()
        int numDocs = randomIntBetween(10, 200);
        XContentBuilder mapping = jsonBuilder().startObject()
                Collections.singletonMap(
                .field("weight", numDocs - i)
            source.endObject();
            )
                .field("weight", i + 1)
                .startObject(FIELD)
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);
                    .field("name", contextMapping.getValue().name())
                    Collections.singletonList(GeoQueryContext.builder().setGeoPoint(new GeoPoint(52.2263, 4.543)).build())
            "type",
        map.put("cat", ContextBuilder.category("cat").field("cat").build());
    protected int numberOfReplicas() {
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);
        }
                .startObject("contexts")
    }
        typeBoostSuggest.contexts(
        createIndexAndMapping(mapping);
        if (addAnotherContext) {
                Collections.singletonMap(
}
            .prefix("sugg")
        neighbours.add("gcpw");
                .startObject("contexts")
        int numDocs = 10;
    public void testSeveralContexts() throws Exception {
        SearchResponse searchResponse = client().prepareSearch(INDEX)
            map.put("type", ContextBuilder.category("type").field("type").build());
        CompletionSuggestionBuilder prefix = SuggestBuilders.completionSuggestion(FIELD)
                .prepareCreate(INDEX)
                .endObject();
            .field("preserve_position_increments", completionMappingBuilder.preservePositionIncrements);
        createIndexAndMapping(mapping);
    private void createIndexAndMapping(CompletionMappingBuilder completionMappingBuilder) throws IOException {
 * under the License.
        mapping.endObject();
                .startObject(FIELD)
                    )
import org.apache.lucene.tests.util.LuceneTestCase.SuppressCodecs;
                .setMapping(mapping)
        if (addAnotherContext) {
        CompletionSuggestionBuilder geoBoostingPrefix = SuggestBuilders.completionSuggestion(FIELD)
        assertSuggestions("suggestions", completionSuggestionBuilder, expectedModulo);
        indexRandom(true, indexRequestBuilders);
                client().prepareIndex(INDEX)
    }
 * GitHub history for details.
            .contexts(
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();
            );
        CompletionSuggestionBuilder prefix = SuggestBuilders.completionSuggestion(FIELD)
            .startObject(FIELD)
                        mapping.field("precision", ((GeoContextMapping) contextMapping.getValue()).getPrecision());
    public void testSingleContextBoosting() throws Exception {
        createIndexAndMapping(mapping);
        // boost only on context cat
        assertSuggestions("foo", multiContextBoostSuggest, "suggestion9", "suggestion8", "suggestion5", "suggestion6", "suggestion4");
                .field("cat", "cat" + i % 2);
                .field("weight", i + 1)
            .endObject()
import org.opensearch.search.suggest.completion.context.GeoQueryContext;
        }
        mapping.endArray();
import com.carrotsearch.randomizedtesting.generators.RandomStrings;
                CategoryQueryContext.builder().setCategory("type2").setBoost(2).build(),
                    Collections.singletonList(CategoryQueryContext.builder().setCategory("cat").setPrefix(true).build())
                        final String name = ((GeoContextMapping) contextMapping.getValue()).getFieldName();
            )
        return 0;
                    "geo",
        neighbours.add("u10h");
        // query context order should never matter
            .suggest(new SuggestBuilder().addSuggestion(suggestionName, context))
                "type",
            .contexts(
                )
            expected[i] = "suggestion" + (numUnique - 1 - i);
    }
            Collections.singletonMap("cat", Collections.singletonList(CategoryQueryContext.builder().setCategory("cat0").build()))
/*
            .contexts(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
                    Collections.singletonList(GeoQueryContext.builder().setGeoPoint(GeoPoint.fromGeohash(geohash)).build())
                Arrays.asList(
        );
            .get();
                .endObject();
            .contexts(
        createIndexAndMapping(mapping);
            indexRequestBuilders.add(client().prepareIndex(INDEX).setId("" + i).setSource(source));
        createIndexAndMapping(mapping);
                        jsonBuilder().startObject()
        String[] expectedModulo = Arrays.stream(expected)
                .field("cat", "cat" + i % 2)
import org.opensearch.search.suggest.CompletionSuggestSearchIT.CompletionMappingBuilder;
 *    http://www.apache.org/licenses/LICENSE-2.0
            XContentBuilder source = jsonBuilder().startObject()
        for (String fieldName : categoryContextFields) {
        mapping.field("name", "st");
                .field("weight", i + 1)
                            mapping.field("path", name);
    private void createIndexAndMappingAndSettings(Settings settings, CompletionMappingBuilder completionMappingBuilder) throws IOException {
        createIndexAndMapping(mapping);
        mapping.field("path", "location.pin");
            XContentBuilder source = jsonBuilder().startObject()
            .startObject(FIELD)
        assertEquals(searchResponse.getSuggest().size(), 1);
import org.opensearch.common.settings.Settings;
        indexRandom(true, indexRequestBuilders);
        createIndexAndMapping(mapping);
                    .setSource(
                .get()
                            .endObject()
            .size(10)
                    .setId("" + i)
        assertSuggestions("foo", prefix, "suggestion9", "suggestion8", "suggestion7", "suggestion6", "suggestion5");
            .startObject("properties")
import org.opensearch.action.search.SearchResponse;
        map.put("cat", ContextBuilder.category("cat").field("cat").build());
        createIndexAndMappingAndSettings(Settings.EMPTY, completionMappingBuilder);
        for (int i = 0; i < numDocs; i++) {
        CompletionSuggestionBuilder typeFilterSuggest = SuggestBuilders.completionSuggestion(FIELD).prefix("sugg");
 * KIND, either express or implied.  See the License for the
                )
                .field("cat", "cat" + i % 2);
                    Collections.singletonList(CategoryQueryContext.builder().setCategory("cat").setPrefix(true).build())
                .field("input", "suggestion" + i)
        assertAcked(prepareCreate(INDEX).setMapping(mapping));
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);
                .startObject(FIELD)
            .field("type", "completion")
            .prefix("sugg")
                    .endObject()
    }
        mapping.startObject("pin");
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);
        }
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);
    }
        }
        indexRandom(true, indexRequestBuilders);
                            .field("weight", i + 1)
            .array("input", "Hotel Amsterdam in Berlin")
                )
                            .endObject()
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();
    }
                .startObject(FIELD)
            );
                .endObject()
            Collections.singletonMap(
        String suggestionName = randomAlphaOfLength(10);
        }
        mapping.endObject();
        map.put("geo", ContextBuilder.geo("geo").precision(4).build());
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                .field("weight", i + 1)
            indexRequestBuilders.add(client().prepareIndex(INDEX).setId("" + i).setSource(source));
        indexRandom(true, indexRequestBuilders);
            .get();
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        neighbours.add("gcpt");
                )
                    .field("input", "suggestion")
        map.put("cat", ContextBuilder.category("cat").field("cat").build());
                Collections.singletonMap(
        mapping.startObject();
import static org.hamcrest.core.IsEqual.equalTo;
                Collections.singletonMap(
 */
        createIndexAndMapping(mapping);
                .field("input", "suggestion" + i)
            .contexts(
                .field("weight", i + 1)
                    .field("cat", "ctx\\u00e4")
        for (int i = 0; i < numDocs; i++) {
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();
        catBoostSuggest.contexts(
        mapping.field("precision", 5);
            indexRequestBuilders.add(client().prepareIndex(INDEX).setId("" + i).setSource(source));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        // filter only on context cat
                .field("input", "suggestion" + i)
            XContentBuilder source = jsonBuilder().startObject()
                    "cat",
        for (int i = 0; i < numDocs; i++) {
            source.endObject();
        mapping.field("analyzer", "simple");
    }
        for (int i = 0; i < numDocs; i++) {
            .contexts(contextMap)
            .contexts(Collections.singletonMap("geo", Arrays.asList(context1, context2)));
        }
        typeFilterSuggest.contexts(
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>();
                .endObject()
                Arrays.asList(
            Arrays.asList(
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>();
        contextMap.put(
        );
            .field("analyzer", completionMappingBuilder.indexAnalyzer)
            );
        );
                        if (name != null) {
                .endObject()
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();
 * Modifications Copyright OpenSearch Contributors. See
                .endObject();
            }
import org.opensearch.common.unit.Fuzziness;
            .prefix("sugg")
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();
                    CategoryQueryContext.builder().setCategory("type2").setBoost(2).build(),
        // boost on both contexts
        CategoryContextMapping contextMapping = ContextBuilder.category("cat").field("cat").build();
        for (int i = 0; i < numDocs; i++) {
        super(settings);
        assertNoFailures(client().admin().indices().prepareRefresh(INDEX).get());
    public void testGeoFiltering() throws Exception {
                            .field("cat", "cat" + i % 2)
        createIndexAndMapping(mapping);
                            mapping.field("path", fieldName);
        }
                .endObject();
        CompletionSuggestionBuilder geoNeighbourPrefix = SuggestBuilders.completionSuggestion(FIELD)
import org.opensearch.search.suggest.completion.context.GeoContextMapping;
    }
        }
        map.put("type", ContextBuilder.category("type").field("type").build());
        int numDocs = 10;
                    "type0",
        mapping.startObject("properties");
        neighbours.add("gcpu");
        GeoPoint[] geoPoints = new GeoPoint[] { new GeoPoint("ezs42e44yx96"), new GeoPoint("u4pruydqqvj8") };
    @ParametersFactory
    }
                CategoryQueryContext.builder().setCategory("cat0").setBoost(3).build(),
            .latlon("pin", 52.529172, 13.407333)
        // boost only on context type
        for (int i = 0; i < numUnique; i++) {
            .text("h")
import org.opensearch.core.rest.RestStatus;
            Collections.singletonMap(
        map.put("cat", ContextBuilder.category("cat").field("cat").build());
            .prefix("sugg")
                            .field("cat", "cat" + i % 2)
        boolean addAnotherContext = randomBoolean();
                .field("cat", "cat" + i % 2)
                    Collections.singletonList(GeoQueryContext.builder().setGeoPoint(new GeoPoint(geoPoints[0])).build())
            }
        boolean addAnotherContext = randomBoolean();
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>();
        List<String> categoryContextFields = new ArrayList<>();
        if (addAnotherContext) {
            .prefix("sugg")
        neighbours.add("gcpy");
                Collections.singletonMap(
                .endObject()
                .endObject()
            )
    public ContextCompletionSuggestSearchIT(Settings settings) {
        indexRandom(true, indexRequestBuilders);
                    .setSource(
        map.put("cat", ContextBuilder.category("cat").field("cat").build());
                    case CATEGORY:
        mapping.endObject();
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();
 * The OpenSearch Contributors require contributions made to
        }
                Collections.singletonMap(
        catFilterSuggest.contexts(
            );
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>();
            mapping.field("store", "true");
            .size(numUnique);
                Collections.singletonMap("cat", Collections.singletonList(CategoryQueryContext.builder().setCategory("cat0").build()))
            XContentBuilder source = jsonBuilder().startObject()
            )
    public void testGeoNeighbours() throws Exception {
        assertAcked(
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();
import java.util.HashMap;
            map.put("type" + i, ContextBuilder.category("type" + i).field("type" + i).build());
        GeoPoint[] geoPoints = new GeoPoint[] { new GeoPoint("ezs42e44yx96"), new GeoPoint("u4pruydqqvj8") };
import org.opensearch.search.suggest.completion.context.CategoryQueryContext;
            mapping.startObject(fieldName).field("type", randomBoolean() ? "keyword" : "text").endObject();
        int numDocs = 10;
            .contexts(
            );
            )
    }
                source.field("type" + c, "type" + c + i % 4);
        indexRandom(true, indexRequestBuilders);
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);
        int numDocs = 10;
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);
            );
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                        break;
        CompletionSuggestionBuilder prefix = SuggestBuilders.completionSuggestion(FIELD)
                        final String fieldName = ((CategoryContextMapping) contextMapping.getValue()).getFieldName();
        );
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();
                Collections.singletonMap(
        indexRandom(true, indexRequestBuilders);
 * You may obtain a copy of the License at
            .regex("sugg.*es")
import org.opensearch.core.xcontent.XContentBuilder;
        CompletionSuggestionBuilder catFilterSuggest = SuggestBuilders.completionSuggestion(FIELD).prefix("sugg");
        CompletionSuggestionBuilder prefix = SuggestBuilders.completionSuggestion(FIELD)
            .startObject("location")
        for (int i = 0; i < numContexts; i++) {
                .endObject()
        // Enable store and disable indexing sometimes
 */
        );
        createIndexAndMapping(mapping);
            if (addAnotherContext) {
            Collections.singletonMap(
        CompletionSuggestionBuilder prefix = SuggestBuilders.completionSuggestion(FIELD)
        int numDocs = 10;
                    CategoryQueryContext.builder().setCategory("type1").build()
 */
            .get();
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();
        createIndexAndMapping(mapping);
            indexRequestBuilders.add(
            mapping.startArray("contexts");
                            .endObject()
                )
                    .startObject(FIELD)
                    "geo",
            client().admin()
 *
        String geohash = "gcpv";
        }
                .endObject()
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>();
                .startObject(FIELD)
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>();
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>();
    }
                .endObject()
                .endObject()
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>();
        assertSuggestions("foo", geoFilteringPrefix, "suggestion8", "suggestion6", "suggestion4", "suggestion2", "suggestion0");
                .indices()
                .field("cat", "cat" + i % 2);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.common.geo.GeoPoint;
import java.util.Collection;
    public void testSingleContextFiltering() throws Exception {
        );
                )
            XContentBuilder source = jsonBuilder().startObject()
            );
            if (addAnotherContext) {
        contextMap.put("cat", Arrays.asList(CategoryQueryContext.builder().setCategory("cat0").build()));
    }
            int id = i % numUnique;
    public void testMultiContextBoosting() throws Exception {
                CategoryQueryContext.builder().setCategory("cat1").build()
                .field("input", "suggestion" + id)
 * Licensed to Elasticsearch under one or more contributor
            XContentBuilder source = jsonBuilder().startObject()
            map.put("type", ContextBuilder.category("type").field("type").build());
        map.put("geo", ContextBuilder.geo("geo").build());
public class ContextCompletionSuggestSearchIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            );
                .startObject("contexts")
        for (int i = 0; i < numDocs; i++) {
import java.util.Arrays;
 * not use this file except in compliance with the License.
        final int numContexts = randomIntBetween(2, 5);
                    case GEO:
                .endObject()
        Map<String, List<? extends ToXContent>> contextMap = new HashMap<>();
        refresh();
                .field("geo", (i % 2 == 0) ? geoPoints[0].getGeohash() : geoPoints[1].getGeohash())
        assertSuggestions("foo", geoNeighbourPrefix, "suggestion9", "suggestion8", "suggestion7", "suggestion6", "suggestion5");
        if (randomBoolean()) {
        XContentBuilder source2 = jsonBuilder().startObject()
    private final String INDEX = RandomStrings.randomAsciiOfLength(random(), 10).toLowerCase(Locale.ROOT);
        neighbours.add("u10j");
 * software distributed under the License is distributed on an
                .field("weight", i + 1)
                .field("lat", 52.22)
                            .field("weight", i + 1)
        mapping.endObject().endObject();
    public void testGeoPointContext() throws Exception {
            indexRequestBuilders.add(client().prepareIndex(INDEX).setId("" + i).setSource(source));
            .contexts(
        return Arrays.asList(
            .prefix("sugg")
        mapping.startArray("contexts");
    public void testMultiContextFiltering() throws Exception {
        int numDocs = 10;
    public void testContextPrefix() throws Exception {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>(Collections.singletonMap("cat", contextMapping));
                Collections.singletonMap(
                        CategoryQueryContext.builder().setCategory("cat1").build()
            );
                mapping.endObject();
        client().prepareIndex(INDEX).setId("2").setSource(source2).get();
                .setSettings(Settings.builder().put(indexSettings()).put(settings))
                source.field("type", "type" + i % 3);
        mapping.endObject();
        }
 * compatible open source license.
                Arrays.asList(
        createIndexAndMapping(mapping);
        GeoQueryContext context1 = GeoQueryContext.builder().setGeoPoint(geoPoints[0]).setBoost(11).build();
        int numDocs = 10;
                    .field("type", contextMapping.getValue().type().name());
            .prefix("sugg")
            indexRequestBuilders.add(client().prepareIndex(INDEX).setId("" + i).setSource(source));
            indexRequestBuilders.add(client().prepareIndex(INDEX).setId("" + i).setSource(source));
                .field("input", "suggestion" + i)
        CompletionSuggestionBuilder catBoostSuggest = SuggestBuilders.completionSuggestion(FIELD).prefix("sugg");
                .endObject()
                    CategoryQueryContext.builder().setCategory("type2").build(),
        for (int i = 0; i < numDocs; i++) {
    public void assertSuggestions(String suggestionName, SuggestionBuilder suggestBuilder, String... suggestions) {
            .startObject(FIELD)
        createIndexAndMapping(mapping);
            .contexts(
        }
                        }
            }
        IndexResponse indexResponse = client().prepareIndex(INDEX)
        CompletionSuggestionBuilder contextSuggestQuery = SuggestBuilders.completionSuggestion(FIELD)
        mapping.field("type", "geo");
            .contexts(
                .field("cat", "cat" + id % 2)
                .field("geo", randomFrom(neighbours))
import java.util.LinkedHashMap;
import org.opensearch.action.index.IndexResponse;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                .startObject(FIELD)
            "cat",
 * license agreements. See the NOTICE file distributed with
    private final String FIELD = RandomStrings.randomAsciiOfLength(random(), 10).toLowerCase(Locale.ROOT);
        CategoryContextMapping contextMapping = ContextBuilder.category("cat").field("cat").build();
    public void testContextFuzzy() throws Exception {
            .array("input", "Hotel Berlin in Amsterdam")
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);
        indexRandom(true, indexRequestBuilders);
                    .setId("" + i)
import org.opensearch.action.index.IndexRequestBuilder;
        indexRandom(true, indexRequestBuilders);
import java.util.Map;
            .prefix("sugg")
        indexRandom(true, indexRequestBuilders);
import java.util.Locale;
        );
    public void testContextFilteringWorksWithUTF8Categories() throws Exception {
        mapping.startObject("properties");
            indexRequestBuilders.add(client().prepareIndex(INDEX).setId("" + i).setSource(source));
                mapping.startObject()
                switch (contextMapping.getValue().type()) {
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>();
                Collections.singletonMap("cat", Collections.singletonList(CategoryQueryContext.builder().setCategory("ctx\\u00e4").build()))
        for (int i = 0; i < numDocs; i++) {
                .endObject();
            .endObject()
        mapping.endObject();
                    .endObject()
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        assertEquals(
                .startObject(FIELD)
                    CategoryQueryContext.builder().setCategory("cat0").setBoost(3).build(),
                "cat",
        mapping.field("type", "completion");
                .endObject()
            indexRequestBuilders.add(client().prepareIndex(INDEX).setId("" + i).setSource(source));
    }
                )
        indexRandom(true, indexRequestBuilders);
            )
        boolean addAnotherContext = randomBoolean();
                .endObject();
            "Hotel Amsterdam in Berlin",
    @Override
            .contexts(
                            .field("input", "suggestion" + i)
                    "st",
        client().prepareIndex(INDEX).setId("1").setSource(source1).get();
            .toArray(String[]::new);
        assertSuggestions("foo", catFilterSuggest, "suggestion8", "suggestion6", "suggestion4", "suggestion2", "suggestion0");
    }
        map.put("type", ContextBuilder.category("type").field("type").build());
        SearchResponse searchResponse = client().prepareSearch(INDEX)
        }
                .startObject(FIELD)
            for (Map.Entry<String, ContextMapping<?>> contextMapping : completionMappingBuilder.contextMappings.entrySet()) {
            .endObject();
        }
        GeoQueryContext context2 = GeoQueryContext.builder().setGeoPoint(geoPoints[1]).build();
        map.put("geo", ContextBuilder.geo("geo").build());
        int numDocs = 10;
 * this file be licensed under the Apache-2.0 license or a
                    CategoryQueryContext.builder().setCategory("cat1").build()
                .endObject()
            .prefix("sugg", Fuzziness.ONE)
        mapping.endObject(); // pin
        mapping.startObject();
        CompletionSuggestionBuilder prefix = SuggestBuilders.completionSuggestion(FIELD)
        mapping.endObject();
        }
            .field("preserve_separators", completionMappingBuilder.preserveSeparators)
            .field("search_analyzer", completionMappingBuilder.searchAnalyzer)
    }
@SuppressCodecs("*") // requires custom completion format
                .field("lon", 4.53)
        mapping.field("type", "geo_point");
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();
        neighbours.add("gcps");
            source.endObject();
            .prefix("sugg")
        int numDocs = 10;
import org.opensearch.core.xcontent.ToXContent;
                        CategoryQueryContext.builder().setCategory("cat0").setBoost(3).build(),
                )
            .endObject()
                    Collections.singletonList(GeoQueryContext.builder().setGeoPoint(new GeoPoint(52.52, 13.4)).build())
 * specific language governing permissions and limitations
                .field("weight", i + 1)
            XContentBuilder source = jsonBuilder().startObject()
        assertSuggestions("foo", geoBoostingPrefix, "suggestion8", "suggestion6", "suggestion4", "suggestion2", "suggestion0");
        for (int i = 0; i < numDocs; i++) {
 * the Apache License, Version 2.0 (the "License"); you may
                .startObject("geo")
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);
    public void testGeoBoosting() throws Exception {
    }
                .field("weight", i + 1)
    }
                        break;
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();
            for (int c = 0; c < numContexts; c++) {
                )
        assertSuggestions("foo", prefix, "suggestion8", "suggestion6", "suggestion4", "suggestion2", "suggestion0");
                .field("type", "type" + i % 4)
import java.util.Collections;
        map.put("geo", ContextBuilder.geo("geo").build());
                .field("geo", (i % 2 == 0) ? geoPoints[0].getGeohash() : geoPoints[1].getGeohash())
        neighbours.add("u10n");
                source.field("type", "type" + i % 3);
            map.put("type", ContextBuilder.category("type").field("type").build());
                )
        assertSuggestions("foo", catBoostSuggest, "suggestion8", "suggestion6", "suggestion4", "suggestion9", "suggestion2");
        for (int i = 0; i < numDocs; i++) {
            .suggest(new SuggestBuilder().addSuggestion(suggestionName, suggestBuilder))
        XContentBuilder mapping = jsonBuilder();
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>();
                }
                    Collections.singletonList(CategoryQueryContext.builder().setCategory("cat").setPrefix(true).build())
                .field("weight", i + 1)
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);
                Collections.singletonMap(
import org.opensearch.search.suggest.completion.context.CategoryContextMapping;
                "type",
        int numDocs = 10;
        CompletionSuggestSearchIT.assertSuggestions(searchResponse, suggestionName, suggestions);
