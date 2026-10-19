                .field("cat", "cat" + i % 2);
        for (int i = 0; i < numDocs; i++) {
                )
 * under the License.  
        createIndexAndMapping(mapping);
                    Arrays.asList(
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
                .field("input", "suggestion" + i)  
            .get();
    }
        return Arrays.asList(  
        mapping.field("precision", 5);  
            );
        Map<String, List<? extends ToXContent>> contextMap = new HashMap<>();  
        CompletionSuggestionBuilder prefix = SuggestBuilders.completionSuggestion(FIELD)
            .startObject(FIELD)
            indexRequestBuilders.add(client().prepareIndex(INDEX).setId("" + i).setSource(source));  
        CompletionSuggestionBuilder prefix = SuggestBuilders.completionSuggestion(FIELD)  
    public void testSingleContextFiltering() throws Exception {
                )
                .endObject()
        }
        CompletionSuggestionBuilder prefix = SuggestBuilders.completionSuggestion(FIELD)  
                .field("weight", i + 1)
            .endObject()
                        break;
        IndexResponse indexResponse = client().prepareIndex(INDEX)
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>();  
import java.util.List;  
            if (addAnotherContext) {
        mapping.endObject(); // location
                    .startObject(FIELD)
        mapping.field("path", "location.pin");
    }
            .size(10)
        map.put("cat", ContextBuilder.category("cat").field("cat").build());
            XContentBuilder source = jsonBuilder().startObject()
                Collections.singletonMap(
                )  
        neighbours.add("gcpw");
        mapping.field("type", "geo_point");
                .field("type", "type" + id)
                )  
                        CategoryQueryContext.builder().setCategory("cat1").build()  
                Collections.singletonMap(
                .startObject("contexts")  
            map.put("type" + i, ContextBuilder.category("type" + i).field("type" + i).build());  
    public void testGeoBoosting() throws Exception {
                Collections.singletonMap(
                .endObject();
        multiContextBoostSuggest.contexts(contextMap);  
import java.util.Collections;  
    }  
            .contexts(
        CompletionSuggestSearchIT.assertSuggestions(searchResponse, suggestionName, suggestions);
                        final String name = ((GeoContextMapping) contextMapping.getValue()).getFieldName();
                .field("type", "type" + i % 4)
    public void testGeoNeighbours() throws Exception {
                )  
            indexRequestBuilders.add(
        GeoPoint[] geoPoints = new GeoPoint[] { new GeoPoint("ezs42e44yx96"), new GeoPoint("u4pruydqqvj8") };  
        final int numContexts = randomIntBetween(2, 5);
                .endObject()  
                    .field("input", "suggestion")  
    }
                    Collections.singletonList(CategoryQueryContext.builder().setCategory("cat").setPrefix(true).build())
                    .endObject()
                            .endObject()
            XContentBuilder source = jsonBuilder().startObject()
 * KIND, either express or implied.  See the License for the
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);
    public void testSeveralContexts() throws Exception {
            )
    }  
                .startObject("contexts")
        }
                .endObject()
            .toArray(String[]::new);
                CategoryQueryContext.builder().setCategory("cat1").build()  
    public void testGeoPointContext() throws Exception {  
 *  
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>();
    public void testGeoFiltering() throws Exception {
            mapping.endArray();  
        CategoryContextMapping contextMapping = ContextBuilder.category("cat").field("cat").build();  
        neighbours.add("gcpu");
                .endObject();  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        neighbours.add("u10h");
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
        mapping.startObject("properties");
        CompletionSuggestionBuilder prefix = SuggestBuilders.completionSuggestion(FIELD)
        }
        createIndexAndMapping(mapping);
        assertSuggestions("foo", catBoostSuggest, "suggestion8", "suggestion6", "suggestion4", "suggestion9", "suggestion2");  
            }
    private void createIndexAndMappingAndSettings(Settings settings, CompletionMappingBuilder completionMappingBuilder) throws IOException {
        createIndexAndMappingAndSettings(Settings.EMPTY, completionMappingBuilder);
        XContentBuilder mapping = jsonBuilder().startObject()  
                .startObject(FIELD)  
        indexRandom(true, indexRequestBuilders);
                .startObject(FIELD)
 */
        for (int i = 0; i < numDocs; i++) {  
        map.put("cat", ContextBuilder.category("cat").field("cat").build());  
        indexRandom(true, indexRequestBuilders);
                mapping.startObject()
        CompletionSuggestionBuilder geoBoostingPrefix = SuggestBuilders.completionSuggestion(FIELD)
                Collections.singletonMap("cat", Collections.singletonList(CategoryQueryContext.builder().setCategory("ctx\\u00e4").build()))
        map.put("cat", ContextBuilder.category("cat").field("cat").build());
            map.put("type", ContextBuilder.category("type").field("type").build());
        assertSuggestions("foo", prefix, "sugxgestion9", "sugxgestion8", "sugxgestion7", "sugxgestion6", "sugxgestion5");
            .contexts(
        }
                .field("weight", i + 1)
        XContentBuilder mapping = jsonBuilder();
        contextMap.put(
                            .endObject()
            .prefix("sugg")  
                .startObject(FIELD)  
 * Unless required by applicable law or agreed to in writing,
        mapping.field("analyzer", "simple");
        assertSuggestions("foo", prefix, "suggestion0", "suggestion1", "suggestion2", "suggestion3", "suggestion4");
                    CategoryQueryContext.builder().setCategory("type2").setBoost(2).build(),
        contextMap.put("cat", Arrays.asList(CategoryQueryContext.builder().setCategory("cat0").build()));
            if (addAnotherContext) {
            .startObject(FIELD)
                .field("input", "suggestion" + i)
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);
        }
            .text("h")
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>(Collections.singletonMap("cat", contextMapping));  
        createIndexAndMapping(mapping);
            }
                    "type0",  
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();
                .field("weight", numDocs - i)
            for (Map.Entry<String, ContextMapping<?>> contextMapping : completionMappingBuilder.contextMappings.entrySet()) {  
            indexRequestBuilders.add(client().prepareIndex(INDEX).setId("" + i).setSource(source));
            "cat",  
            Collections.singletonMap("cat", Collections.singletonList(CategoryQueryContext.builder().setCategory("cat0").build()))
        createIndexAndMapping(mapping);  
            source.endObject();  
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>();
                .endObject()  
import org.opensearch.core.xcontent.ToXContent;
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>();
                mapping.endObject();  
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);
        int numDocs = 10;
        catFilterSuggest.contexts(  
import org.opensearch.action.index.IndexResponse;
        indexRandom(true, indexRequestBuilders);
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);
        assertSuggestions("foo", geoBoostingPrefix, "suggestion8", "suggestion6", "suggestion4", "suggestion2", "suggestion0");  
            )
 * You may obtain a copy of the License at  
                .startObject("geo")
                            mapping.field("path", name);
                )
    private void createIndexAndMapping(CompletionMappingBuilder completionMappingBuilder) throws IOException {
        createIndexAndMapping(mapping);  
                .endObject();
/*
        mapping.endObject(); // pin  
        CategoryContextMapping contextMapping = ContextBuilder.category("cat").field("cat").build();
        mapping.endObject();
        refresh();  
                        jsonBuilder().startObject()  
 * compatible open source license.
        mapping.startObject("location");
            .setSource(  
    }
        neighbours.add("gcps");  
        super(settings);
            .endObject()
        indexRandom(true, indexRequestBuilders);
        int numDocs = 10;  
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);
        map.put("cat", ContextBuilder.category("cat").field("cat").build());
            .contexts(
                            mapping.field("path", fieldName);
                "type",  
                .field("weight", i + 1)
/*  
        assertSuggestions("foo", geoNeighbourPrefix, "suggestion9", "suggestion8", "suggestion7", "suggestion6", "suggestion5");  
                        CategoryQueryContext.builder().setCategory("cat0").setBoost(3).build(),
                .field("cat", "cat" + i % 2)  
                jsonBuilder().startObject()
import com.carrotsearch.randomizedtesting.generators.RandomStrings;
        int numDocs = 10;
                .field("geo", randomFrom(neighbours))
        );
 *
                            .field("input", "suggestion" + i)  
    public void testSkipDuplicatesWithContexts() throws Exception {
                .setSettings(Settings.builder().put(indexSettings()).put(settings))  
        assertSuggestions("foo", contextSuggestQuery, "suggestion");
    public void testContextFuzzy() throws Exception {
        map.put("geo", ContextBuilder.geo("geo").build());
                }
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>(Collections.singletonMap("cat", contextMapping));
            Collections.singletonMap(
                switch (contextMapping.getValue().type()) {
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();
            .prefix("sugg")  
        CompletionSuggestionBuilder multiContextBoostSuggest = SuggestBuilders.completionSuggestion(FIELD).prefix("sugg");
        for (int i = 0; i < numUnique; i++) {  
        // boost only on context type
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
                .field("lat", 52.22)
                .field("input", "suggestion" + i)
import java.util.ArrayList;  
                )
            .prefix("sugg")  
        CompletionSuggestionBuilder prefix = SuggestBuilders.completionSuggestion(FIELD)  
            "type",
        mapping.startObject("pin");  
 * not use this file except in compliance with the License.
                client().prepareIndex(INDEX)
        CompletionSuggestionBuilder geoFilteringPrefix = SuggestBuilders.completionSuggestion(FIELD)
                            .field("weight", i + 1)
            Collections.singletonMap(
    }
                .field("weight", i + 1)
                .endObject()  
        String suggestionName = randomAlphaOfLength(10);
                .endObject()  
                .endObject();
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>();  
            XContentBuilder source = jsonBuilder().startObject()
        neighbours.add("u10n");  
            .contexts(
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>();  
                .endObject()  
                    .endObject()  
            if (addAnotherContext) {
import org.opensearch.search.suggest.CompletionSuggestSearchIT.CompletionMappingBuilder;
        CompletionSuggestionBuilder prefix = SuggestBuilders.completionSuggestion(FIELD)  
        int numDocs = 10;  
                Collections.singletonMap("cat", Collections.singletonList(CategoryQueryContext.builder().setCategory("cat0").build()))  
        mapping.endObject();
                        if (fieldName != null) {
        createIndexAndMapping(mapping);
@SuppressCodecs("*") // requires custom completion format
                        final String fieldName = ((CategoryContextMapping) contextMapping.getValue()).getFieldName();  
        }  
            for (int c = 0; c < numContexts; c++) {  
        }
        mapping.field("type", "geo");
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);  
        mapping.endObject();  
        for (int i = 0; i < numDocs; i++) {
                        jsonBuilder().startObject()
        }
            .contexts(
                    Collections.singletonList(CategoryQueryContext.builder().setCategory("cat").setPrefix(true).build())
import org.opensearch.core.xcontent.XContentBuilder;  
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();  
                .startObject("contexts")  
                source.field("type", "type" + i % 3);  
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();
        }
                .endObject()  
            source.endObject();
            .contexts(
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);  
            int id = i % numUnique;  
                .endObject()
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
        }
                .field("input", "suggestion" + i)  
            Arrays.asList(  
            map.put("type", ContextBuilder.category("type").field("type").build());
                .field("input", "suggestion" + i)
        Map<String, List<? extends ToXContent>> contextMap = new HashMap<>();
            .endObject()
        client().prepareIndex(INDEX).setId("2").setSource(source2).get();
    public void testSingleContextBoosting() throws Exception {  
    }
    }  
                    Collections.singletonList(GeoQueryContext.builder().setGeoPoint(new GeoPoint(52.52, 13.4)).build())  
            XContentBuilder source = jsonBuilder().startObject()
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);  
        indexRandom(true, indexRequestBuilders);  
        for (int i = 0; i < numDocs; i++) {  
 * the Apache License, Version 2.0 (the "License"); you may
                .startObject(FIELD)  
        createIndexAndMapping(mapping);
            );
import java.io.IOException;
            .field("search_analyzer", completionMappingBuilder.searchAnalyzer)
            indexRequestBuilders.add(client().prepareIndex(INDEX).setId("" + i).setSource(source));  
            );
            )
                            .field("weight", i + 1)  
    @ParametersFactory
import org.opensearch.common.settings.Settings;
                CategoryQueryContext.builder().setCategory("type1").setBoost(4).build()
        assertSuggestions("suggestions", completionSuggestionBuilder, expectedModulo);  
                            .field("cat", "cat" + i % 2)
                            categoryContextFields.add(fieldName);  
                source.field("type", "type" + i % 3);  
                .endObject()
        createIndexAndMapping(mapping);
        assertSuggestions("foo", typeBoostSuggest, "suggestion9", "suggestion5", "suggestion6", "suggestion1", "suggestion2");
import org.opensearch.search.suggest.completion.context.ContextMapping;  
                client().prepareIndex(INDEX)  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            );
    private final String INDEX = RandomStrings.randomAsciiOfLength(random(), 10).toLowerCase(Locale.ROOT);  
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);  
                .startObject(FIELD)
            .field("preserve_position_increments", completionMappingBuilder.preservePositionIncrements);
import static org.hamcrest.core.IsEqual.equalTo;
            XContentBuilder source = jsonBuilder().startObject()
                .field("weight", i + 1)
                    "cat",
import org.opensearch.search.suggest.completion.context.ContextBuilder;
                    CategoryQueryContext.builder().setCategory("type1").build()  
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();  
        for (int i = 0; i < numDocs; i++) {
        mapping.endObject();
                .startObject(FIELD)
        createIndexAndMapping(mapping);  
import org.apache.lucene.tests.util.LuceneTestCase.SuppressCodecs;  
        // filter only on context cat
        CompletionSuggestionBuilder geoNeighbourPrefix = SuggestBuilders.completionSuggestion(FIELD)  
            );  
import org.opensearch.search.suggest.completion.context.CategoryQueryContext;
    @Override  
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();  
        int numDocs = 10;
            XContentBuilder source = jsonBuilder().startObject()
    }
import org.opensearch.search.suggest.completion.context.GeoContextMapping;
        }
                    "geo",  
        GeoPoint[] geoPoints = new GeoPoint[] { new GeoPoint("ezs42e44yx96"), new GeoPoint("u4pruydqqvj8") };
                    Collections.singletonList(CategoryQueryContext.builder().setCategory("cat").setPrefix(true).build())
            XContentBuilder source = jsonBuilder().startObject()
            }
        for (int i = 0; i < numDocs; i++) {
        indexRandom(true, indexRequestBuilders);  
                )
            .array("input", "Hotel Berlin in Amsterdam")
                    CategoryQueryContext.builder().setCategory("cat1").build()
                .endObject()
                )
        );
        CompletionSuggestionBuilder catFilterSuggest = SuggestBuilders.completionSuggestion(FIELD).prefix("sugg");
                    CategoryQueryContext.builder().setCategory("cat0").setBoost(3).build(),
            .suggest(new SuggestBuilder().addSuggestion(suggestionName, suggestBuilder))
        if (addAnotherContext) {  
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();  
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>();  
        neighbours.add("u10j");
    }  
            }
            searchResponse.getSuggest().getSuggestion(suggestionName).iterator().next().getOptions().iterator().next().getText().string()
        }  
                    Collections.singletonList(GeoQueryContext.builder().setGeoPoint(GeoPoint.fromGeohash(geohash)).build())
            );
package org.opensearch.search.suggest;
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();
        boolean addAnotherContext = randomBoolean();
        }
                Collections.singletonMap(
                    .field("name", contextMapping.getValue().name())
        for (int i = 0; i < numDocs; i++) {  
        mapping.startObject("properties");  
        );  
                .endObject()
        if (addAnotherContext) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
            .contexts(
                .startObject(FIELD)  
                .field("input", "sugxgestion" + i)
            .prefix("sugg")
                .startObject(FIELD)
                            .endObject()
            mapping.startObject(fieldName).field("type", randomBoolean() ? "keyword" : "text").endObject();
        CompletionSuggestionBuilder contextSuggestQuery = SuggestBuilders.completionSuggestion(FIELD)
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>(Collections.singletonMap("cat", contextMapping));
                    case CATEGORY:
                    Collections.singletonList(GeoQueryContext.builder().setGeoPoint(new GeoPoint(52.2263, 4.543)).build())
public class ContextCompletionSuggestSearchIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    }
            );  
        }
        CompletionSuggestionBuilder prefix = SuggestBuilders.completionSuggestion(FIELD)
        }
            .filter((s) -> Integer.parseInt(s.substring("suggestion".length())) % 2 == 0)
                    "cat",  
import org.opensearch.common.unit.Fuzziness;  
        indexRandom(true, indexRequestBuilders);
            .get();  
        int numUnique = randomIntBetween(1, numDocs);  
            .array("input", "Hotel Amsterdam in Berlin")  
        );
            XContentBuilder source = jsonBuilder().startObject()
        );  
        contextMap.put(
                            .startObject(FIELD)
        mapping.field("name", "st");  
            indexRequestBuilders.add(client().prepareIndex(INDEX).setId("" + i).setSource(source));
        mapping.field("type", "completion");
                    .field("type", contextMapping.getValue().type().name());  
                            .field("cat", "cat" + i % 2)  
            .startObject(FIELD)  
/*
                )
                .setMapping(mapping)
import java.util.Map;
        mapping.startObject();
                .field("cat", "cat" + i % 2);
 */
        // query context order should never matter
        CompletionSuggestionBuilder completionSuggestionBuilder = SuggestBuilders.completionSuggestion(FIELD)  
    public void testMultiContextFiltering() throws Exception {
                .field("weight", i + 1)
        mapping.startArray("contexts");
            .suggest(new SuggestBuilder().addSuggestion(suggestionName, context))
        for (int i = 0; i < numContexts; i++) {
                .endObject();
                    .setId("" + i)
        // Enable store and disable indexing sometimes
            client().admin()  
            indexRequestBuilders.add(  
            .latlon("pin", 52.529172, 13.407333)  
    public void testContextRegex() throws Exception {
        map.put("cat", ContextBuilder.category("cat").field("cat").build());
                Arrays.asList(  
 * ownership. Elasticsearch licenses this file to you under  
        String geohash = "gcpv";
        assertSuggestions("foo", prefix, "suggestion8", "suggestion6", "suggestion4", "suggestion9", "suggestion2");
        int numDocs = randomIntBetween(10, 200);
    }  
                    case GEO:  
        indexRandom(true, indexRequestBuilders);
        int numDocs = 10;
                .indices()
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            .contexts(  
            indexRequestBuilders.add(client().prepareIndex(INDEX).setId("" + i).setSource(source));  
        SearchResponse searchResponse = client().prepareSearch(INDEX)
import org.opensearch.common.geo.GeoPoint;
            .endObject();  
        for (int i = 0; i < numDocs; i++) {  
                )  
            );  
                            .endObject()  
            indexRequestBuilders.add(client().prepareIndex(INDEX).setId("" + i).setSource(source));
    }
        );
        mapping.endArray();
            );  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        boolean addAnotherContext = randomBoolean();
        );  
        int numDocs = randomIntBetween(10, 100);
        GeoQueryContext context2 = GeoQueryContext.builder().setGeoPoint(geoPoints[1]).build();
            indexRequestBuilders.add(client().prepareIndex(INDEX).setId("" + i).setSource(source));  
 * software distributed under the License is distributed on an
                Arrays.asList(
            XContentBuilder source = jsonBuilder().startObject()
        mapping.startObject();
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>();
        if (randomBoolean()) {  
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>();
            .skipDuplicates(true)  
                .field("weight", id)
                .endObject();
        SearchResponse searchResponse = client().prepareSearch(INDEX)  
        XContentBuilder source1 = jsonBuilder().startObject()
                    "cat",
        client().prepareIndex(INDEX).setId("1").setSource(source1).get();  
import java.util.Arrays;
        );  
            indexRequestBuilders.add(client().prepareIndex(INDEX).setId("" + i).setSource(source));  
                    Collections.singletonList(GeoQueryContext.builder().setGeoPoint(new GeoPoint(geoPoints[0])).build())
                CategoryQueryContext.builder().setCategory("cat0").setBoost(3).build(),
            .field("analyzer", completionMappingBuilder.indexAnalyzer)
        CompletionSuggestionBuilder context = SuggestBuilders.completionSuggestion(FIELD)  
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);
                    "geo",  
        }
        assertNoFailures(client().admin().indices().prepareRefresh(INDEX).get());
        int numDocs = 10;
            Arrays.asList(
        int numDocs = 10;
 * license agreements. See the NOTICE file distributed with
            .endObject();
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>();  
                    Collections.singletonList(CategoryQueryContext.builder().setCategory("type").setPrefix(true).build())
        assertEquals(searchResponse.getSuggest().size(), 1);
                    .setSource(
            expected[i] = "suggestion" + (numUnique - 1 - i);
            .contexts(contextMap)
        map.put("type", ContextBuilder.category("type").field("type").build());
            source.endObject();
                .endObject();
                .get()
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();  
    public void assertSuggestions(String suggestionName, SuggestionBuilder suggestBuilder, String... suggestions) {  
 *
 * SPDX-License-Identifier: Apache-2.0
        if (addAnotherContext) {  
                        break;  
    public ContextCompletionSuggestSearchIT(Settings settings) {  
        }
                .field("cat", "cat" + i % 2)  
        // filter only on context type
        if (completionMappingBuilder.contextMappings != null) {
                    .setSource(  
import org.opensearch.search.suggest.completion.context.GeoQueryContext;
            .field("preserve_separators", completionMappingBuilder.preserveSeparators)  
                Collections.singletonMap(  
            "Hotel Amsterdam in Berlin",  
        map.put("geo", ContextBuilder.geo("geo").build());
    }
                .field("weight", i + 1)
            .size(numUnique);
        mapping.endObject();
                    CategoryQueryContext.builder().setCategory("type2").build(),
        typeFilterSuggest.contexts(
            )
    }  
                )  
        mapping.endObject();
        CompletionSuggestionBuilder typeBoostSuggest = SuggestBuilders.completionSuggestion(FIELD).prefix("sugg");  
import org.opensearch.action.search.SearchResponse;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
                Collections.singletonMap(
        indexRandom(true, indexRequestBuilders);
            mapping.field("store", "true");
            indexRequestBuilders.add(client().prepareIndex(INDEX).setId("" + i).setSource(source));
                            .field("input", "suggestion" + i)
            );
import java.util.Locale;
        );
            Collections.singletonMap(
                    )
                .endObject()
                .field("input", "suggestion" + i)
                .startObject(FIELD)  
import org.opensearch.search.suggest.completion.CompletionSuggestionBuilder;
        String[] expected = new String[numUnique];
                "cat",
                        }
        String[] expectedModulo = Arrays.stream(expected)  
                .field("cat", "cat" + id % 2)  
import org.opensearch.search.suggest.completion.context.CategoryContextMapping;  
        for (int i = 0; i < numDocs; i++) {
                    "st",
        assertSuggestions("foo", prefix, "suggestion8", "suggestion6", "suggestion4", "suggestion2", "suggestion0");  
import org.opensearch.core.rest.RestStatus;
                source.field("type", "type" + i % 3);  
                        if (name != null) {  
        mapping.startObject(FIELD);  
        indexRandom(true, indexRequestBuilders);
                source.field("type" + c, "type" + c + i % 4);
            .prefix("sugg")  
        assertSuggestions("foo", catFilterSuggest, "suggestion8", "suggestion6", "suggestion4", "suggestion2", "suggestion0");  
                .field("input", "suggestion" + id)  
    public void testMultiContextBoosting() throws Exception {
        assertSuggestions("foo", prefix, "suggestion9", "suggestion8", "suggestion7", "suggestion6", "suggestion5");
                CategoryQueryContext.builder().setCategory("type2").setBoost(2).build(),
                .field("type", "type" + i % 4)
        assertSuggestions("foo", geoFilteringPrefix, "suggestion8", "suggestion6", "suggestion4", "suggestion2", "suggestion0");
        CategoryContextMapping contextMapping = ContextBuilder.category("cat").field("cat").build();
            );  
        // the score of each suggestion is the maximum score among the matching contexts
    public void testGeoField() throws Exception {  
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();
            XContentBuilder source = jsonBuilder().startObject()
        GeoQueryContext context1 = GeoQueryContext.builder().setGeoPoint(geoPoints[0]).setBoost(11).build();  
        catBoostSuggest.contexts(  
        assertSuggestions("foo", typeFilterSuggest, "suggestion9", "suggestion6", "suggestion5", "suggestion2", "suggestion1");
        map.put("cat", ContextBuilder.category("cat").field("cat").build());  
                Collections.singletonMap(  
 * specific language governing permissions and limitations
            .latlon("pin", 52.363389, 4.888695)
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);  
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();  
            .regex("sugg.*es")
            .prefix("sugg")  
                .startObject(FIELD)  
        List<String> categoryContextFields = new ArrayList<>();  
                .field("input", "sugg" + i + "estion")
                .field("geo", (i % 2 == 0) ? geoPoints[0].getGeohash() : geoPoints[1].getGeohash())  
 * Modifications Copyright OpenSearch Contributors. See  
            .contexts(Collections.singletonMap("geo", Arrays.asList(context1, context2)));
 * this file be licensed under the Apache-2.0 license or a
        neighbours.add("gcpy");
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);
        for (int i = 0; i < numDocs; i++) {
                        mapping.field("precision", ((GeoContextMapping) contextMapping.getValue()).getPrecision());
        XContentBuilder source2 = jsonBuilder().startObject()
                .endObject();
            mapping.field("index", "false");
            .startObject("location")  
                .endObject()
            .prefix("sugg")
import java.util.LinkedHashMap;
        mapping.endObject().endObject();  
        int numDocs = 10;
            mapping.startArray("contexts");
                    .setId("" + i)
        createIndexAndMapping(mapping);
        createIndexAndMapping(mapping);  
import java.util.Collection;
}
            XContentBuilder source = jsonBuilder().startObject()
        assertEquals(
    }
import org.opensearch.action.index.IndexRequestBuilder;
        indexRandom(true, indexRequestBuilders);
        }
            .startObject("location")
            .prefix("sugg")  
                .field("geo", (i % 2 == 0) ? geoPoints[0].getGeohash() : geoPoints[1].getGeohash())
        if (randomBoolean()) {  
        // boost only on context cat
        // boost on both contexts  
                        }
            .get();
        indexRandom(true, indexRequestBuilders);  
            .startObject("properties")
 * Licensed to Elasticsearch under one or more contributor  
            .setId("1")
            .contexts(
            )
    private final String FIELD = RandomStrings.randomAsciiOfLength(random(), 10).toLowerCase(Locale.ROOT);
        typeBoostSuggest.contexts(
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
    public void testContextPrefix() throws Exception {
            indexRequestBuilders.add(client().prepareIndex(INDEX).setId("" + i).setSource(source));  
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);  
        }  
                .startObject(FIELD)
                            .startObject(FIELD)
            .prefix("sugg")
                .field("input", "suggestion" + i)  
        for (String fieldName : categoryContextFields) {  
                    .field("cat", "ctx\\u00e4")
        map.put("geo", ContextBuilder.geo("geo").precision(4).build());
    public static Collection<Object[]> parameters() {
            source.endObject();
        createIndexAndMapping(mapping);
        int numDocs = 10;
            .endObject()
                Collections.singletonMap(  
            .prefix("sugg")
        assertSuggestions("foo", prefix, "sugg9estion", "sugg8estion", "sugg7estion", "sugg6estion", "sugg5estion");
                .startObject("contexts")  
            .field("type", "completion")  
        }  
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();
            indexRequestBuilders.add(client().prepareIndex(INDEX).setId("" + i).setSource(source));
        CompletionSuggestionBuilder typeFilterSuggest = SuggestBuilders.completionSuggestion(FIELD).prefix("sugg");  
    public void testContextFilteringWorksWithUTF8Categories() throws Exception {
import java.util.HashMap;
                .field("lon", 4.53)  
                .prepareCreate(INDEX)
        assertAcked(
                Arrays.asList(
                    "geo",
        assertSuggestions("foo", multiContextBoostSuggest, "suggestion9", "suggestion8", "suggestion5", "suggestion6", "suggestion4");
        for (int i = 0; i < numDocs; i++) {
            .prefix("sugg", Fuzziness.ONE)
            )  
                    )
        }
        LinkedHashMap<String, ContextMapping<?>> map = new LinkedHashMap<>();  
 * GitHub history for details.
                .field("cat", "cat" + i % 2);
        return 0;
        List<String> neighbours = new ArrayList<>();  
        assertThat(indexResponse.status(), equalTo(RestStatus.CREATED));  
                    "cat",
        for (int i = 0; i < numDocs; i++) {
        createIndexAndMapping(mapping);  
        map.put("type", ContextBuilder.category("type").field("type").build());
        CompletionSuggestionBuilder catBoostSuggest = SuggestBuilders.completionSuggestion(FIELD).prefix("sugg");
                    )
            );  
    }  
 */  
        assertSuggestions("foo", prefix, "suggestion9", "suggestion8", "suggestion7", "suggestion6", "suggestion5");
        createIndexAndMapping(mapping);
        final CompletionMappingBuilder mapping = new CompletionMappingBuilder().context(map);  
        map.put("geo", ContextBuilder.geo("geo").build());  
    }
        neighbours.add("gcpt");
                .field("input", "suggestion" + i)  
            }
            .contexts(
            map.put("type", ContextBuilder.category("type").field("type").build());
                "type",  
        assertAcked(prepareCreate(INDEX).setMapping(mapping));
        map.put("type", ContextBuilder.category("type").field("type").build());
        }
                .endObject()
            );
            .contexts(
    protected int numberOfReplicas() {
        for (int i = 0; i < numDocs; i++) {
        int numDocs = 10;
    }
                .field("weight", i + 1)
        indexRandom(true, indexRequestBuilders);
                Collections.singletonMap(  
        boolean addAnotherContext = randomBoolean();
                .field("weight", i + 1)
                    CategoryQueryContext.builder().setCategory("type1").setBoost(4).build()  
