                    if (gdsb.getNestedFilter() != null && !assertedWarnings.contains(nestedFilterDeprecationWarning)) {
            + "\"_score\""
        sortBuilder = result.get(0);
        assertEquals(new FieldSortBuilder("_doc"), sortBuilder);
                    String nestedFilterDeprecationWarning = "[nested_filter] has been deprecated in favour of the [nested] parameter";
                            if (builder instanceof ScoreSortBuilder) {
        assertEquals(new ScoreSortBuilder(), sortBuilder);
        }
     * - "sort" : { "fieldname" : "asc" }
                            break;
                }
        json = "{ \"sort\" : \"_doc\" }";
    }
    public static void init() {
 * license agreements. See the NOTICE file distributed with
        assertEquals(new GeoDistanceSortBuilder("pin.location", 40, -70), sortBuilder);
        try (XContentParser itemParser = createParser(JsonXContent.jsonXContent, jsonString)) {
        SortOrder order = randomBoolean() ? SortOrder.ASC : SortOrder.DESC;
            List<SortBuilder<?>> testBuilders = randomSortBuilderList();
    }
        result = parseSort(json);
        json = "{ \"sort\" : \"_score\" }";
        List<SortBuilder<?>> result = parseSort(json);
                    list.add(new FieldSortBuilder(fieldName));
                }
        String json = "{ \"sort\" : ["
import org.opensearch.common.settings.Settings;
                assertWarnings(expectedWarningHeaders.toArray(new String[0]));
        sortBuilder = result.get(0);
        return list;
public class SortBuilderTests extends OpenSearchTestCase {
            }
                    String fieldName = rarely() ? FieldSortBuilder.DOC_FIELD_NAME : randomAlphaOfLengthBetween(1, 10);
        xContentRegistry = new NamedXContentRegistry(searchModule.getNamedXContents());
            if (testBuilders.size() > 1) {
 *
        assertEquals(new FieldSortBuilder("age").order(SortOrder.DESC), result.get(3));
import java.util.HashSet;
 * GitHub history for details.
                            }
        int size = randomIntBetween(1, 5);
     * test two syntax variations:
                    String nestedPathDeprecationWarning = "[nested_path] has been deprecated in favour of the [nested] parameter";
     * - "sort" : [ "fieldname", { "fieldname2" : "asc" }, ...]
    /**
                xContentBuilder.field("sort");
import org.opensearch.search.SearchModule;
            + "{"
    private static NamedXContentRegistry xContentRegistry;
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.ToXContent;
            return SortBuilder.fromXContent(itemParser);
import static java.util.Collections.emptyList;
 *
                        case 0:
        assertEquals(new GeoDistanceSortBuilder("pin.location", new GeoPoint(40, -70)), result.get(4));
            + "{ \"post_date\" : {\"order\" : \"asc\"}},"
        json = "{ \"sort\" : { \"_doc\" : \"" + order + "\" }}";
    public static List<SortBuilder<?>> randomSortBuilderList() {
            assertEquals(XContentParser.Token.FIELD_NAME, itemParser.nextToken());
        xContentRegistry = null;
        assertEquals(1, result.size());
                case 3:
            Set<String> expectedWarningHeaders = new HashSet<>();
    }
                assertedWarnings.addAll(expectedWarningHeaders);
                            break;
        result = parseSort(json);
                        case 2:
                                xContentBuilder.field(((FieldSortBuilder) builder).getFieldName());
            }
import java.util.List;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.io.IOException;
                case 0:
     * - "sort" : "fieldname"
        sortBuilder = result.get(0);
/*
        }
/*
 */
                case 1:
                            if (builder instanceof ScoreSortBuilder) {
            + "{ \"name\" : \"desc\" },"
        List<SortBuilder<?>> result = parseSort(json);
        result = parseSort(json);
        sortBuilder = result.get(0);
                            xContentBuilder.value(builder.order());
        String json = "{ \"sort\" : { \"field1\" : \"" + order + "\" }}";
            assertEquals(testBuilders.size(), parsedSort.size());
        SortBuilder<?> sortBuilder = result.get(0);
 * not use this file except in compliance with the License.
        assertEquals(1, result.size());
        assertEquals(new FieldSortBuilder("post_date").order(SortOrder.ASC), result.get(0));
        sortBuilder = result.get(0);
                    switch (randomIntBetween(0, 2)) {
                        case 1:
                    if (gdsb.getNestedPath() != null && !assertedWarnings.contains(nestedPathDeprecationWarning)) {
import org.opensearch.test.OpenSearchTestCase;
            }
 * The OpenSearch Contributors require contributions made to
        for (int runs = 0; runs < NUMBER_OF_RUNS; runs++) {
                            xContentBuilder.endObject();
                xContentBuilder.startArray("sort");
        sortBuilder = result.get(0);
        result = parseSort(json);
        result = parseSort(json);
                if (builder instanceof GeoDistanceSortBuilder) {
                    break;
            List<SortBuilder<?>> parsedSort = parseSort(xContentBuilder.toString());
                    }
        // one element array, see https://github.com/elastic/elasticsearch/issues/17257
import org.junit.AfterClass;
import org.opensearch.common.xcontent.json.JsonXContent;
        assertWarnings("Deprecated field [_geoDistance] used, expected [_geo_distance] instead");
        assertEquals(1, result.size());
import org.opensearch.common.geo.GeoPoint;
            for (SortBuilder<?> builder : testBuilders) {
            assertEquals(XContentParser.Token.START_OBJECT, itemParser.nextToken());
     * test parsing random syntax variations
    public void testSingleFieldSort() throws IOException {
import java.util.ArrayList;
        assertEquals(1, result.size());
 * You may obtain a copy of the License at
 * software distributed under the License is distributed on an
        assertEquals(1, result.size());
 */
            + "\"user\","
        assertEquals(6, result.size());
    }
            + "] }";
            }
        assertEquals(new GeoDistanceSortBuilder("pin.location", 40, -70), sortBuilder);
                assertEquals(iterator.next(), parsedBuilder);
     * test array syntax variations:
        }
 * specific language governing permissions and limitations
import org.opensearch.common.xcontent.XContentFactory;
 * under the License.
x * Licensed to Elasticsearch under one or more contributor
        result = parseSort(json);
                    GeoDistanceSortBuilder gdsb = (GeoDistanceSortBuilder) builder;
        assertEquals(new FieldSortBuilder("name").order(SortOrder.DESC), result.get(2));
                    break;
                                xContentBuilder.value(((FieldSortBuilder) builder).getFieldName());
    }
        json = "{ \"sort\" : \"field1\" }";
import org.opensearch.core.xcontent.NamedXContentRegistry;
                    list.add(new ScoreSortBuilder());
     */
                            } else {
            } else {
            if (expectedWarningHeaders.size() > 0) {
 * the Apache License, Version 2.0 (the "License"); you may
 */
                if (builder instanceof ScoreSortBuilder || builder instanceof FieldSortBuilder) {
    public void testMultiFieldSort() throws IOException {
        SearchModule searchModule = new SearchModule(Settings.EMPTY, emptyList());
 * this file be licensed under the Apache-2.0 license or a
 *
        json = "{ \"sort\" : { \"_score\" : \"" + order + "\" }}";
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(new FieldSortBuilder("_doc").order(order), sortBuilder);
        for (int i = 0; i < size; i++) {
                    }
     */
import java.util.Iterator;
    }
        assertEquals(new FieldSortBuilder("field1").order(order), sortBuilder);
    @BeforeClass
        assertEquals(new FieldSortBuilder("user").order(SortOrder.ASC), result.get(1));
        assertEquals(1, result.size());
     */
            switch (randomIntBetween(0, 3)) {
    protected NamedXContentRegistry xContentRegistry() {
    @Override
                xContentBuilder.endArray();
        result = parseSort(json);
}
            Iterator<SortBuilder<?>> iterator = testBuilders.iterator();
            itemParser.nextToken();
/*
        sortBuilder = result.get(0);
        sortBuilder = result.get(0);
    }
        assertEquals(1, result.size());
                } else {
        json = "{ \"sort\" : [" + "{\"_geo_distance\" : {" + "\"pin.location\" : \"40,-70\" } }" + "] }";
        List<SortBuilder<?>> list = new ArrayList<>(size);
                    list.add(ScriptSortBuilderTests.randomScriptSortBuilder());
        assertEquals(new ScoreSortBuilder(), result.get(5));
                    list.add(GeoDistanceSortBuilderTests.randomGeoDistanceSortBuilder());
    /**
                                xContentBuilder.field("_score");
 *    http://www.apache.org/licenses/LICENSE-2.0
    private List<SortBuilder<?>> parseSort(String jsonString) throws IOException {
                case 2:
                            } else {
                    }
    public static void afterClass() throws Exception {
        assertEquals(1, result.size());
                    break;
                    break;
        assertEquals(new FieldSortBuilder("field1"), sortBuilder);
    private Set<String> assertedWarnings = new HashSet<>();
    @AfterClass
            xContentBuilder.startObject();
        assertEquals(new FieldSortBuilder("field1"), sortBuilder);
        assertEquals(new ScoreSortBuilder().order(order), sortBuilder);
 * compatible open source license.
            xContentBuilder.endObject();
    private static final int NUMBER_OF_RUNS = 20;
import org.opensearch.core.xcontent.XContentParser;
                        expectedWarningHeaders.add(nestedPathDeprecationWarning);
    /**
            assertEquals("sort", itemParser.currentName());
        assertEquals(1, result.size());
            XContentBuilder xContentBuilder = XContentFactory.jsonBuilder();
                        expectedWarningHeaders.add(nestedFilterDeprecationWarning);
    }
        json = "{ \"sort\" : [" + "{\"_geoDistance\" : {" + "\"pin.location\" : \"40,-70\" } }" + "] }";
                                xContentBuilder.value("_score");
 * ownership. Elasticsearch licenses this file to you under
        // test two spellings for _geo_disctance
import org.opensearch.core.xcontent.XContentBuilder;
            }
    public void testRandomSortBuilders() throws IOException {
        return xContentRegistry;
import org.junit.BeforeClass;
            + "{ \"age\" : \"desc\" },"
import java.util.Set;
        json = "{ \"sort\" : [\"field1\"] }";
 * Modifications Copyright OpenSearch Contributors. See
                            break;
            + "\"pin.location\" : \"40,-70\" } },"
            }
        result = parseSort(json);
            + "\"_geo_distance\" : {"
            for (SortBuilder<?> parsedBuilder : parsedSort) {
                            xContentBuilder.startObject();
                            builder.toXContent(xContentBuilder, ToXContent.EMPTY_PARAMS);
package org.opensearch.search.sort;
                            }
            if (testBuilders.size() > 1) {
 * this work for additional information regarding copyright
                default:
                    builder.toXContent(xContentBuilder, ToXContent.EMPTY_PARAMS);
                    throw new IllegalStateException("unexpected randomization in tests");
