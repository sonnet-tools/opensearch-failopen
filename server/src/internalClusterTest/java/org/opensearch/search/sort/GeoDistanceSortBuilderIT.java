        assertOrderedSearchHits(searchResponse, "d1");
            (Double) searchResponse.getHits().getAt(0).getSortValues()[0],
            .get();
        );
        SearchResponse searchResponse = client().prepareSearch()  
        Collections.shuffle(qPoints, random());  
            client().prepareIndex("index").setId("d1").setSource(d1Builder),  
            .get();
            .addSort(new GeoDistanceSortBuilder(LOCATION_FIELD, q).sortMode(SortMode.MIN).order(SortOrder.ASC))
            )  
            .setQuery(matchAllQuery())  
    protected boolean forbidPrivateIndexSettings() {
        searchResponse = client().prepareSearch()  
            .addSort(fieldSort("double_field2").order(SortOrder.DESC).unmappedType("double"))
        );
import org.opensearch.common.unit.DistanceUnit;  
          |    |        |
            client().prepareIndex("index").setId("d2").setSource(d2Builder)
          |    |        |
        );  
 * this file be licensed under the Apache-2.0 license or a
 *
        );  
            (Double) searchResponse.getHits().getAt(0).getSortValues()[0],
            .get();
        logger.info("d1: {}", d1Builder);
            client().prepareIndex("index")  
            true,  
            .addSort(fieldSort("str_field2").order(SortOrder.DESC).unmappedType("keyword"))
                geoDistanceSortBuilder.points(point);
        );
            .get();  
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
        resp = client().prepareSearch("test1", "test2")  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        assertAcked(prepareCreate("index").setSettings(settings).setMapping(LOCATION_FIELD, "type=geo_point"));
            .addSort(new GeoDistanceSortBuilder(LOCATION_FIELD, q).sortMode(SortMode.MIN).order(SortOrder.DESC))
            .get();  
            .addSort(
                .setId("d1")
/*  
        createShuffeldJSONArray(d2Builder, d2Points);  
        assertAcked(  
        SearchResponse searchResponse = client().prepareSearch()  
 * the Apache License, Version 2.0 (the "License"); you may
            .setSize(10)  
                .setSource(jsonBuilder().startObject().startObject(LOCATION_FIELD).field("lat", 1).field("lon", 2).endObject().endObject())
    protected void createShuffeldJSONArray(XContentBuilder builder, GeoPoint[] pointsArray) throws IOException {
        searchResponse = client().prepareSearch()  
import java.util.Collection;  
            closeTo(GeoDistance.ARC.calculate(0, 0, 0, 5, DistanceUnit.METERS), 10d)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );
package org.opensearch.search.sort;
        BoolQueryBuilder bool = boolQuery().filter(existsQuery(LOCATION_FIELD));
        /*
 * not use this file except in compliance with the License.
            closeTo(GeoDistance.ARC.calculate(2, 1, 6, 2, DistanceUnit.METERS), 10d)
            closeTo(GeoDistance.ARC.calculate(3.25, 4, 2, 1, DistanceUnit.METERS), 1.e-1)
import org.opensearch.core.xcontent.XContentBuilder;
            .addSort(new GeoDistanceSortBuilder(LOCATION_FIELD, q).sortMode(SortMode.AVG).order(SortOrder.ASC))
        List<GeoPoint> points = new ArrayList<>();
            .addSort(fieldSort("str_field").order(SortOrder.ASC).unmappedType("keyword"))  
            .get();
            client().prepareIndex("index").setId("d2").setSource(d2Builder)
        SearchResponse searchResponse = client().prepareSearch()
        );
        assertThat(
          |3  o|  x     |  x
    private static final String LOCATION_FIELD = "location";
        String hashPoint = "s037ms06g7h0";
          |1  o|x       |x
        assertAcked(prepareCreate("test2").get());  
    }
            (Double) searchResponse.getHits().getAt(0).getSortValues()[0],
    }  
        );
        searchResponse = client().prepareSearch()
        assertThat(  
        GeoDistanceSortBuilder geoDistanceSortBuilder = null;
        return Arrays.asList(
        );
        );
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                        .field("admin", "11")  
import static org.opensearch.index.query.QueryBuilders.boolQuery;  
            client().prepareIndex("index")
            (Double) searchResponse.getHits().getAt(1).getSortValues()[0],
        }  
            builder.value(points.remove(randomInt(points.size() - 1)));
import java.util.ArrayList;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
 * software distributed under the License is distributed on an
            client().prepareIndex("test2").setSource()
            (Double) searchResponse.getHits().getAt(0).getSortValues()[0],
        searchResponse = client().prepareSearch()
        indexRandom(
            (Double) searchResponse.getHits().getAt(1).getSortValues()[0],
import java.util.List;
 */  
            .setSize(4)  
        assertAcked(prepareCreate("index").setSettings(settings).setMapping(LOCATION_FIELD, "type=geo_point"));
            .get();  
            closeTo(GeoDistance.ARC.calculate(2, 2, 4, 1, DistanceUnit.METERS), 10d)
            q[0] = new GeoPoint(2, 1);  
        assertOrderedSearchHits(searchResponse, "d2", "d1");
        );
            .setSource(
        XContentBuilder d2Builder = jsonBuilder();
            .addSort(geoDistanceSortBuilder.sortMode(SortMode.MIN).order(SortOrder.ASC))
        assertThat(
        assertAcked(prepareCreate("index").setSettings(settings).setMapping(LOCATION_FIELD, "type=geo_point"));
import java.util.Collections;
            .addSort(new GeoDistanceSortBuilder(LOCATION_FIELD, q).sortMode(SortMode.MAX).order(SortOrder.DESC))
            .get();
        }  
        assertThat(
 * license agreements. See the NOTICE file distributed with
 */  
        checkCorrectSortOrderForGeoSort(searchResponse);
        searchResponse = client().prepareSearch()
            closeTo(GeoDistance.ARC.calculate(9.227400, 49.189800, 48.8331, 2.3264, DistanceUnit.KILOMETERS), 1.e-1)
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
    }  
        GeoPoint[] q = new GeoPoint[2];  
         */
import org.opensearch.common.settings.Settings;
import java.io.IOException;  
 */
        GeoPoint[] d1Points = { new GeoPoint(0, 1), new GeoPoint(0, 4), new GeoPoint(0, 10) };
import org.opensearch.Version;  
          |    |        |
          |4  o|   x    |   x
            (Double) searchResponse.getHits().getAt(0).getSortValues()[0],  
            (Double) searchResponse.getHits().getAt(1).getSortValues()[0],
            .get();
            (Double) searchResponse.getHits().getAt(1).getSortValues()[0],  
            .addSort(fieldSort("long_field").order(SortOrder.ASC).unmappedType("long"))
        createShuffeldJSONArray(d2Builder, d2Points);  
        assertAcked(prepareCreate("index").setMapping("admin", "type=keyword", LOCATION_FIELD, "type=geo_point"));  
 *  
        XContentBuilder d2Builder = jsonBuilder();
            (Double) searchResponse.getHits().getAt(0).getSortValues()[0],
            true,  
        assertThat(
        assertOrderedSearchHits(searchResponse, "d2", "d1");  
         */
    }
            closeTo(GeoDistance.ARC.calculate(5.25, 4, 2, 1, DistanceUnit.METERS), 1.e-1)  
        );
    public void testSinglePointGeoDistanceSort() throws ExecutionException, InterruptedException, IOException {
        assertThat(
                )
        GeoDistanceSortBuilder geoDistanceSortBuilder = new GeoDistanceSortBuilder(LOCATION_FIELD, new GeoPoint(40.7128, -74.0060));
        );  
            closeTo(GeoDistance.ARC.calculate(0, 0, 0, 5, DistanceUnit.METERS), 10d)  
        GeoPoint[] d1Points = { new GeoPoint(3, 2), new GeoPoint(4, 1) };
            client().prepareIndex("index").setId("d2").setSource(d2Builder)
            closeTo(GeoDistance.ARC.calculate(2, 2, 3, 2, DistanceUnit.METERS), 10d)
            .addSort(new GeoDistanceSortBuilder(LOCATION_FIELD, q).sortMode(SortMode.MEDIAN).order(SortOrder.ASC))  
        logger.info("d1: {}", d1Builder);
        } else {
          1   2   3   4   5   6   7
import org.opensearch.search.builder.SearchSourceBuilder;
 * under the License.  
                        .startObject(LOCATION_FIELD)
            .get();
import org.opensearch.index.query.GeoValidationMethod;  
            .setQuery(matchAllQuery())
}
            closeTo(GeoDistance.ARC.calculate(2, 1, 5, 1, DistanceUnit.METERS), 10d)
            .get();
/*  
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
        assertThat(
        );
        );
            .addSort(new GeoDistanceSortBuilder(LOCATION_FIELD, q).sortMode(SortMode.MAX).order(SortOrder.ASC))  
            closeTo(GeoDistance.ARC.calculate(2, 2, 3, 2, DistanceUnit.METERS), 10d)
            closeTo(GeoDistance.ARC.calculate(4.5, 1, 2, 1, DistanceUnit.METERS), 1.e-1)
            closeTo(GeoDistance.ARC.calculate(0, 0, 0, 4, DistanceUnit.METERS), 10d)
import java.util.concurrent.ExecutionException;  
        SearchResponse resp = client().prepareSearch("test1", "test2")
                        .endObject()
            .setQuery(matchAllQuery())
            .setSource(new SearchSourceBuilder().sort(SortBuilders.geoDistanceSort(LOCATION_FIELD, "s037ms06g7h0")))
        resp = client().prepareSearch("test1", "test2")  
        assertThat(
        assertSortValues(
        searchResponse = client().prepareSearch()
            .setSource(new SearchSourceBuilder().sort(SortBuilders.geoDistanceSort(LOCATION_FIELD, 2.0, 2.0)))
        Version version = randomBoolean() ? Version.CURRENT : VersionUtils.randomIndexCompatibleVersion(random());  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSortValues;
          1   2   3   4   5   6
            .get();
            .get();  
 * Licensed to Elasticsearch under one or more contributor  
import static org.opensearch.search.sort.SortBuilders.fieldSort;
            .setQuery(matchAllQuery())
          d1 = (0, 1), (0, 4), (0, 10); so avg. distance is 5, median distance is 4  
        checkCorrectSortOrderForGeoSort(searchResponse);
                        .field("lat", 48.8331)  
 * Unless required by applicable law or agreed to in writing,
        geoDistanceSortBuilder = new GeoDistanceSortBuilder(LOCATION_FIELD, new GeoPoint(2, 2));  
        checkCorrectSortOrderForGeoSort(searchResponse);
        assertThat(
import static org.hamcrest.Matchers.closeTo;
          |2  o|  x     |     x  
            .get();  
        List<GeoPoint> qPoints = Arrays.asList(new GeoPoint(2, 1), new GeoPoint(2, 2), new GeoPoint(2, 3), new GeoPoint(2, 4));
                    .geoDistance(GeoDistance.ARC)  
    }
            true,  
        if (randomBoolean()) {
    @Override
        assertThat(
import org.opensearch.common.geo.GeoDistance;  
            .get();
            .setQuery(matchAllQuery())  
        assertOrderedSearchHits(searchResponse, "d2", "d1");  
        createShuffeldJSONArray(d1Builder, d1Points);
        /*  
          |    |        |
            .addSort(fieldSort("long_field2").order(SortOrder.DESC).unmappedType("long"))
        );
        createShuffeldJSONArray(d1Builder, d1Points);
          |___________________________  
            .addSort(geoDistanceSortBuilder.sortMode(SortMode.MIN).order(SortOrder.ASC))  
                )
import org.opensearch.index.query.MatchAllQueryBuilder;
                    .ignoreUnmapped(true)
    public static Collection<Object[]> parameters() {
import java.util.Arrays;
 * You may obtain a copy of the License at  
        );  
    }
            .addSort(geoDistanceSortBuilder.sortMode(SortMode.MIN).order(SortOrder.ASC))
/*
            .setQuery(matchAllQuery())
        );
        searchResponse = client().prepareSearch()
    public void testSingeToManyAvgMedian() throws ExecutionException, InterruptedException, IOException {  
                .setSource(  
        checkCorrectSortOrderForGeoSort(searchResponse);
        for (int i = 0; i < numPoints; i++) {
            new Object[] { 0.65, Double.NEGATIVE_INFINITY },  
                        .endObject()
        SearchResponse searchResponse = client().prepareSearch()  
          q  = (0, 0)
        geoDistanceSortBuilder = new GeoDistanceSortBuilder(LOCATION_FIELD, new GeoPoint(9.227400, 49.189800));
            closeTo(GeoDistance.ARC.calculate(2, 2, 4, 1, DistanceUnit.METERS), 10d)
 *
        assertThat(  
        searchResponse = client().prepareSearch()  
                .setId("d2")
import static org.opensearch.index.query.QueryBuilders.existsQuery;
        builder.endObject();
            .setQuery(matchAllQuery())
        assertThat(  
            prepareCreate("test1").setMapping("str_field", "type=keyword", "long_field", "type=long", "double_field", "type=double").get()
            .setQuery(matchAllQuery())  
                new SearchSourceBuilder().sort(  
        );
import org.opensearch.cluster.metadata.IndexMetadata;
        assertThat(  
        assertAcked(prepareCreate("index").setMapping(LOCATION_FIELD, "type=geo_point"));  
            client().prepareIndex("index").setId("d1").setSource(d1Builder),  
            .get();
        GeoPoint[] d2Points = { new GeoPoint(5, 1), new GeoPoint(6, 2) };
 * this work for additional information regarding copyright
        createShuffeldJSONArray(d1Builder, d1Points);
        );  
        indexRandom(
 * compatible open source license.
    }  
        checkCorrectSortOrderForGeoSort(searchResponse);
        points.addAll(Arrays.asList(pointsArray));  
import org.opensearch.common.geo.GeoPoint;
            .setQuery(new MatchAllQueryBuilder())
        assertOrderedSearchHits(searchResponse, "d1", "d2");
            true,
        for (GeoPoint point : qPoints) {  
        int numPoints = points.size();  
            (Double) searchResponse.getHits().getAt(0).getSortValues()[0],
            }
        XContentBuilder d2Builder = jsonBuilder();
            .setSource(new SearchSourceBuilder().sort(SortBuilders.geoDistanceSort(LOCATION_FIELD, 2.0, 2.0)))  
        logger.info("d2: {}", d2Builder);  
            (Double) searchResponse.getHits().getAt(0).getSortValues()[0],
        indexRandom(
            .addSort(fieldSort("double_field").order(SortOrder.ASC).unmappedType("double"))
            if (geoDistanceSortBuilder == null) {
        assertOrderedSearchHits(searchResponse, "d2", "d1");  
            q[1] = new GeoPoint(2, 2);
        return false;  
            .setQuery(bool)
        createShuffeldJSONArray(d2Builder, d2Points);  
            closeTo(GeoDistance.ARC.calculate(2, 2, 1, 1, DistanceUnit.METERS), 1.e-1)
            closeTo(GeoDistance.ARC.calculate(2, 1, 5, 1, DistanceUnit.METERS), 10d)  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        searchResponse = client().prepareSearch()
    }  
        super(settings);  
import org.opensearch.index.query.BoolQueryBuilder;
        assertThat(  
    @ParametersFactory  
        assertOrderedSearchHits(searchResponse, "d1", "d2");
            .addSort(geoDistanceSortBuilder.unit(DistanceUnit.KILOMETERS).ignoreUnmapped(true).order(SortOrder.DESC))
            client().prepareIndex("index")  
                    jsonBuilder().startObject()
            closeTo(GeoDistance.ARC.calculate(0, 0, 0, 4, DistanceUnit.METERS), 10d)  
        GeoPoint[] d2Points = { new GeoPoint(4.5, 1), new GeoPoint(4.75, 2), new GeoPoint(5, 3), new GeoPoint(5.25, 4) };
          |    |        |
            (Double) searchResponse.getHits().getAt(1).getSortValues()[0],  
            .get();
        assertThat(  
        );  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        XContentBuilder d1Builder = jsonBuilder();  
        assertSortValues(resp, new Object[] { 3L, Long.MIN_VALUE }, new Object[] { Long.MAX_VALUE, Long.MIN_VALUE });
            .get();
        assertThat(
                .setId("d1")
        );  
          |    |        |  
                    SortBuilders.geoDistanceSort(LOCATION_FIELD, 2.0, 2.0).validation(GeoValidationMethod.COERCE)
                geoDistanceSortBuilder.unit(DistanceUnit.KILOMETERS)  
        indexRandom(
            resp,
            (Double) searchResponse.getHits().getAt(0).getSortValues()[0],  
 * GitHub history for details.
        logger.info("d2: {}", d2Builder);  
    public void testGeoDistanceQueryThenSort() throws Exception {
            q[0] = new GeoPoint(2, 1);
            closeTo(GeoDistance.ARC.calculate(2, 2, 1, 2, DistanceUnit.METERS), 1.e-1)  
        assertThat(
        );
            (Double) searchResponse.getHits().getAt(1).getSortValues()[0],  
    }  
        SearchResponse searchResponse = client().prepareSearch()
        Version version = randomBoolean() ? Version.CURRENT : VersionUtils.randomIndexCompatibleVersion(random());  
            (Double) searchResponse.getHits().getAt(1).getSortValues()[0],
    public void testManyToManyGeoPointsWithDifferentFormats() throws ExecutionException, InterruptedException, IOException {
        XContentBuilder d1Builder = jsonBuilder();  
    public void testCrossIndexIgnoreUnmapped() throws Exception {
    public void testManyToManyGeoPoints() throws ExecutionException, InterruptedException, IOException {  
        assertOrderedSearchHits(searchResponse, "d1", "d2");  
        );
        GeoDistanceSortBuilder geoDistanceSortBuilder = new GeoDistanceSortBuilder(LOCATION_FIELD, hashPoint);
 * specific language governing permissions and limitations
          |1  o|      x | x
 * KIND, either express or implied.  See the License for the
        assertThat(
 * The OpenSearch Contributors require contributions made to  
            client().prepareIndex("test1").setSource("str_field", "bcd", "long_field", 3, "double_field", 0.65),
        );  
import org.opensearch.test.VersionUtils;
        builder.startObject();
        Version version = randomBoolean() ? Version.CURRENT : VersionUtils.randomIndexCompatibleVersion(random());  
        );  
           q     d1       d2
        GeoPoint q = new GeoPoint(0, 0);  
    private static void checkCorrectSortOrderForGeoSort(SearchResponse searchResponse) {
            closeTo(GeoDistance.ARC.calculate(2.5, 1, 2, 1, DistanceUnit.METERS), 1.e-1)  
        assertOrderedSearchHits(searchResponse, "d1", "d2");
            .setQuery(matchAllQuery())
          |    |        |  
            (Double) searchResponse.getHits().getAt(1).getSortValues()[0],  
            q[1] = new GeoPoint(2, 2);  
        geoDistanceSortBuilder = new GeoDistanceSortBuilder(LOCATION_FIELD, 2, 2);
            client().prepareIndex("index").setId("d1").setSource(d1Builder),
            (Double) searchResponse.getHits().getAt(0).getSortValues()[0],
        searchResponse = client().prepareSearch()
        assertThat(
         */
                    .sortMode(SortMode.MIN)
            .get();
            .get();  
                geoDistanceSortBuilder = new GeoDistanceSortBuilder(LOCATION_FIELD, point);
            closeTo(GeoDistance.ARC.calculate(2, 1, 6, 2, DistanceUnit.METERS), 10d)  
            .addSort(geoDistanceSortBuilder.sortMode(SortMode.MAX).order(SortOrder.ASC))  
        indexRandom(
        );  
        assertSortValues(resp, new Object[] { "bcd", null }, new Object[] { null, null });
          | q  |  d1    |   d2
        GeoPoint[] d1Points = { new GeoPoint(2.5, 1), new GeoPoint(2.75, 2), new GeoPoint(3, 3), new GeoPoint(3.25, 4) };
            true,
            .setQuery(matchAllQuery())  
import org.opensearch.action.search.SearchResponse;
            new Object[] { Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY }
                        .field("lon", 2.3264)
        builder.startArray(LOCATION_FIELD);
            )
            true,
            (Double) searchResponse.getHits().getAt(0).getSortValues()[0],
 * Modifications Copyright OpenSearch Contributors. See
        checkCorrectSortOrderForGeoSort(searchResponse);  
        assertOrderedSearchHits(searchResponse, "d1", "d2");
                .setSource(jsonBuilder().startObject().startObject(LOCATION_FIELD).field("lat", 1).field("lon", 1).endObject().endObject()),
        builder.endArray();
public class GeoDistanceSortBuilderIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        );  
        );
        XContentBuilder d1Builder = jsonBuilder();  
    public GeoDistanceSortBuilderIT(Settings settings) {
            closeTo(GeoDistance.ARC.calculate(40.7128, -74.0060, 48.8331, 2.3264, DistanceUnit.KILOMETERS), 1.e-1)
          |2  o| x      | x  
        GeoPoint[] d2Points = { new GeoPoint(0, 1), new GeoPoint(0, 5), new GeoPoint(0, 6) };
            (Double) searchResponse.getHits().getAt(1).getSortValues()[0],
        assertOrderedSearchHits(searchResponse, "d1");
                    .order(SortOrder.DESC)
    }
          d2 = (0, 1), (0, 5), (0, 6); so avg. distance is 4, median distance is 5
            } else {  
          |______________________  
            .setQuery(matchAllQuery())
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
        searchResponse = client().prepareSearch()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertOrderedSearchHits;  
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(  
        indexRandom(
    }  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        }
 * SPDX-License-Identifier: Apache-2.0
        checkCorrectSortOrderForGeoSort(searchResponse);  
        searchResponse = client().prepareSearch()
            .addSort(geoDistanceSortBuilder.sortMode(SortMode.MIN).order(SortOrder.ASC))
        /*
