        }
        sortBuilder = result.get(0);
                    break;  
                            if (builder instanceof ScoreSortBuilder) {
                    }  
                            if (builder instanceof ScoreSortBuilder) {  
                assertWarnings(expectedWarningHeaders.toArray(new String[0]));
            }
}
        json = "{ \"sort\" : [\"field1\"] }";  
                xContentBuilder.startArray("sort");
                    list.add(GeoDistanceSortBuilderTests.randomGeoDistanceSortBuilder());  
        result = parseSort(json);
        assertWarnings("Deprecated field [_geoDistance] used, expected [_geo_distance] instead");
                case 1:
            for (SortBuilder<?> builder : testBuilders) {
import org.junit.BeforeClass;  
        int size = randomIntBetween(1, 5);  
    @Override
                                xContentBuilder.value(((FieldSortBuilder) builder).getFieldName());  
 * under the License.  
                    list.add(ScriptSortBuilderTests.randomScriptSortBuilder());  
        assertEquals(1, result.size());
import java.io.IOException;
        result = parseSort(json);  
import org.opensearch.core.xcontent.NamedXContentRegistry;
            itemParser.nextToken();  
    }  
 * this work for additional information regarding copyright
            List<SortBuilder<?>> testBuilders = randomSortBuilderList();  
    }  
            + "] }";
        try (XContentParser itemParser = createParser(JsonXContent.jsonXContent, jsonString)) {
        assertEquals(new ScoreSortBuilder(), result.get(5));
import static java.util.Collections.emptyList;  
        result = parseSort(json);  
        assertEquals(new GeoDistanceSortBuilder("pin.location", 40, -70), sortBuilder);  
                            xContentBuilder.value(builder.order());
        return list;  
    }
 * GitHub history for details.
                }
        assertEquals(new FieldSortBuilder("user").order(SortOrder.ASC), result.get(1));  
        assertEquals(1, result.size());  
/*  
 * Unless required by applicable law or agreed to in writing,
            }  
                assertEquals(iterator.next(), parsedBuilder);
        sortBuilder = result.get(0);  
        assertEquals(new GeoDistanceSortBuilder("pin.location", new GeoPoint(40, -70)), result.get(4));  
        return xContentRegistry;  
 *
                    String nestedPathDeprecationWarning = "[nested_path] has been deprecated in favour of the [nested] parameter";  
 * the Apache License, Version 2.0 (the "License"); you may
                case 3:
        assertEquals(6, result.size());
            + "\"_score\""
                                xContentBuilder.value("_score");
        for (int i = 0; i < size; i++) {
                            xContentBuilder.endObject();
                    }  
x * Licensed to Elasticsearch under one or more contributor  
    protected NamedXContentRegistry xContentRegistry() {
        result = parseSort(json);
                    throw new IllegalStateException("unexpected randomization in tests");  
    public void testRandomSortBuilders() throws IOException {  
                xContentBuilder.field("sort");  
        assertEquals(new FieldSortBuilder("field1"), sortBuilder);
            xContentBuilder.endObject();  
            Set<String> expectedWarningHeaders = new HashSet<>();
                    switch (randomIntBetween(0, 2)) {
    }
                    list.add(new FieldSortBuilder(fieldName));  
                xContentBuilder.endArray();
                            builder.toXContent(xContentBuilder, ToXContent.EMPTY_PARAMS);
        json = "{ \"sort\" : { \"_score\" : \"" + order + "\" }}";  
        assertEquals(new FieldSortBuilder("_doc").order(order), sortBuilder);
        // test two spellings for _geo_disctance  
 *  
        assertEquals(new FieldSortBuilder("_doc"), sortBuilder);
                        case 1:  
                                xContentBuilder.field("_score");  
    public void testMultiFieldSort() throws IOException {
    private static NamedXContentRegistry xContentRegistry;
        sortBuilder = result.get(0);  
import org.junit.AfterClass;
            }
                            } else {
 * this file be licensed under the Apache-2.0 license or a
            }
                    break;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static void init() {  
 * KIND, either express or implied.  See the License for the
        sortBuilder = result.get(0);
        assertEquals(new FieldSortBuilder("post_date").order(SortOrder.ASC), result.get(0));
     * - "sort" : { "fieldname" : "asc" }
        result = parseSort(json);
            if (expectedWarningHeaders.size() > 0) {
/*  
import org.opensearch.core.xcontent.XContentBuilder;
 * compatible open source license.
        assertEquals(1, result.size());
import org.opensearch.common.settings.Settings;
 */
        SearchModule searchModule = new SearchModule(Settings.EMPTY, emptyList());
                            }  
            for (SortBuilder<?> parsedBuilder : parsedSort) {
    @BeforeClass
public class SortBuilderTests extends OpenSearchTestCase {
                        expectedWarningHeaders.add(nestedPathDeprecationWarning);
    /**  
 * license agreements. See the NOTICE file distributed with
     * test array syntax variations:
        }
                assertedWarnings.addAll(expectedWarningHeaders);  
        assertEquals(1, result.size());
/*
        for (int runs = 0; runs < NUMBER_OF_RUNS; runs++) {
        }
                    break;
        assertEquals(new ScoreSortBuilder(), sortBuilder);
import org.opensearch.test.OpenSearchTestCase;
                    list.add(new ScoreSortBuilder());
            + "{"
            xContentBuilder.startObject();
 * software distributed under the License is distributed on an
 */  
     * test two syntax variations:
        sortBuilder = result.get(0);
        json = "{ \"sort\" : \"_score\" }";  
                            xContentBuilder.startObject();
        List<SortBuilder<?>> list = new ArrayList<>(size);
        String json = "{ \"sort\" : { \"field1\" : \"" + order + "\" }}";
        SortBuilder<?> sortBuilder = result.get(0);
        json = "{ \"sort\" : \"_doc\" }";  
import org.opensearch.common.geo.GeoPoint;
     * - "sort" : [ "fieldname", { "fieldname2" : "asc" }, ...]
                if (builder instanceof GeoDistanceSortBuilder) {  
            List<SortBuilder<?>> parsedSort = parseSort(xContentBuilder.toString());
     * test parsing random syntax variations
                        case 2:
        json = "{ \"sort\" : [" + "{\"_geo_distance\" : {" + "\"pin.location\" : \"40,-70\" } }" + "] }";
        sortBuilder = result.get(0);  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Set;
                if (builder instanceof ScoreSortBuilder || builder instanceof FieldSortBuilder) {  
                        case 0:
package org.opensearch.search.sort;
                    String fieldName = rarely() ? FieldSortBuilder.DOC_FIELD_NAME : randomAlphaOfLengthBetween(1, 10);
import java.util.List;  
        assertEquals(new FieldSortBuilder("field1"), sortBuilder);  
                                xContentBuilder.field(((FieldSortBuilder) builder).getFieldName());
    public static List<SortBuilder<?>> randomSortBuilderList() {
        json = "{ \"sort\" : \"field1\" }";
        assertEquals(1, result.size());
     */
            + "{ \"post_date\" : {\"order\" : \"asc\"}},"  
                            break;
     * - "sort" : "fieldname"  
                default:
        assertEquals(1, result.size());
 * ownership. Elasticsearch licenses this file to you under  
                    }
                    builder.toXContent(xContentBuilder, ToXContent.EMPTY_PARAMS);  
                        expectedWarningHeaders.add(nestedFilterDeprecationWarning);
            + "\"pin.location\" : \"40,-70\" } },"  
    private static final int NUMBER_OF_RUNS = 20;  
    public void testSingleFieldSort() throws IOException {  
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.common.xcontent.json.JsonXContent;
    public static void afterClass() throws Exception {  
    @AfterClass
        assertEquals(new FieldSortBuilder("name").order(SortOrder.DESC), result.get(2));
            assertEquals(XContentParser.Token.FIELD_NAME, itemParser.nextToken());
import org.opensearch.common.xcontent.XContentFactory;  
            Iterator<SortBuilder<?>> iterator = testBuilders.iterator();  
        result = parseSort(json);
            + "{ \"age\" : \"desc\" },"  
            }
import java.util.ArrayList;  
                    break;
            switch (randomIntBetween(0, 3)) {  
            XContentBuilder xContentBuilder = XContentFactory.jsonBuilder();
 * The OpenSearch Contributors require contributions made to  
        List<SortBuilder<?>> result = parseSort(json);  
            }
                }
 */  
                    if (gdsb.getNestedFilter() != null && !assertedWarnings.contains(nestedFilterDeprecationWarning)) {
    }
            + "\"_geo_distance\" : {"
                            break;  
    private Set<String> assertedWarnings = new HashSet<>();  
    }
        SortOrder order = randomBoolean() ? SortOrder.ASC : SortOrder.DESC;
        // one element array, see https://github.com/elastic/elasticsearch/issues/17257
                case 2:
            assertEquals(testBuilders.size(), parsedSort.size());
            assertEquals(XContentParser.Token.START_OBJECT, itemParser.nextToken());  
        List<SortBuilder<?>> result = parseSort(json);  
        json = "{ \"sort\" : { \"_doc\" : \"" + order + "\" }}";  
 *
    private List<SortBuilder<?>> parseSort(String jsonString) throws IOException {  
import org.opensearch.core.xcontent.ToXContent;  
import java.util.Iterator;
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(new GeoDistanceSortBuilder("pin.location", 40, -70), sortBuilder);  
     */
                            }
        String json = "{ \"sort\" : ["
                    if (gdsb.getNestedPath() != null && !assertedWarnings.contains(nestedPathDeprecationWarning)) {
    /**
        xContentRegistry = new NamedXContentRegistry(searchModule.getNamedXContents());
     */  
 * Modifications Copyright OpenSearch Contributors. See
            + "{ \"name\" : \"desc\" },"
        sortBuilder = result.get(0);  
    /**  
import org.opensearch.search.SearchModule;  
import java.util.HashSet;
            + "\"user\","
        xContentRegistry = null;
        assertEquals(new ScoreSortBuilder().order(order), sortBuilder);
                case 0:
        json = "{ \"sort\" : [" + "{\"_geoDistance\" : {" + "\"pin.location\" : \"40,-70\" } }" + "] }";
        assertEquals(1, result.size());
            assertEquals("sort", itemParser.currentName());
                    String nestedFilterDeprecationWarning = "[nested_filter] has been deprecated in favour of the [nested] parameter";
            if (testBuilders.size() > 1) {  
                            } else {
                } else {
    }
            } else {
        result = parseSort(json);
            if (testBuilders.size() > 1) {  
    }  
        sortBuilder = result.get(0);  
        result = parseSort(json);
 * You may obtain a copy of the License at  
        assertEquals(new FieldSortBuilder("field1").order(order), sortBuilder);  
                    GeoDistanceSortBuilder gdsb = (GeoDistanceSortBuilder) builder;
        assertEquals(1, result.size());
 * not use this file except in compliance with the License.
        assertEquals(new FieldSortBuilder("age").order(SortOrder.DESC), result.get(3));
                            break;  
            return SortBuilder.fromXContent(itemParser);
        assertEquals(1, result.size());
 * specific language governing permissions and limitations
