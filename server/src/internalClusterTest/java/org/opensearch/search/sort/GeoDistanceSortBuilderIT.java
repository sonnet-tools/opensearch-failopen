import org.opensearch.cluster.metadata.IndexMetadata;
            .addSort(geoDistanceSortBuilder.unit(DistanceUnit.KILOMETERS).ignoreUnmapped(true).order(SortOrder.DESC))
    }
            new Object[] { 0.65, Double.NEGATIVE_INFINITY },
import java.io.IOException;
        assertThat(
            (Double) searchResponse.getHits().getAt(0).getSortValues()[0],
            closeTo(GeoDistance.ARC.calculate(2, 2, 4, 1, DistanceUnit.METERS), 10d)
            (Double) searchResponse.getHits().getAt(0).getSortValues()[0],
        }
            .get();
            (Double) searchResponse.getHits().getAt(1).getSortValues()[0],
            closeTo(GeoDistance.ARC.calculate(5.25, 4, 2, 1, DistanceUnit.METERS), 1.e-1)
import org.opensearch.test.VersionUtils;
        createShuffeldJSONArray(d1Builder, d1Points);
            client().prepareIndex("index").setId("d2").setSource(d2Builder)
/*
        createShuffeldJSONArray(d2Builder, d2Points);
            client().prepareIndex("index").setId("d1").setSource(d1Builder),
          | q  |  d1    |   d2
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(
import org.opensearch.index.query.GeoValidationMethod;
        geoDistanceSortBuilder = new GeoDistanceSortBuilder(LOCATION_FIELD, 2, 2);
            .get();
}
        assertOrderedSearchHits(searchResponse, "d2", "d1");
        );
        searchResponse = client().prepareSearch()
          |3  o|  x     |  x
            .get();
                )
            (Double) searchResponse.getHits().getAt(0).getSortValues()[0],
        assertOrderedSearchHits(searchResponse, "d1", "d2");
        assertThat(
        geoDistanceSortBuilder = new GeoDistanceSortBuilder(LOCATION_FIELD, new GeoPoint(9.227400, 49.189800));
        List<GeoPoint> points = new ArrayList<>();
        GeoPoint[] d1Points = { new GeoPoint(3, 2), new GeoPoint(4, 1) };
          |    |        |
            closeTo(GeoDistance.ARC.calculate(2, 1, 6, 2, DistanceUnit.METERS), 10d)
          |    |        |
            closeTo(GeoDistance.ARC.calculate(2, 1, 5, 1, DistanceUnit.METERS), 10d)
        XContentBuilder d2Builder = jsonBuilder();
 *    http://www.apache.org/licenses/LICENSE-2.0
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
            .get();
                    .sortMode(SortMode.MIN)
                new SearchSourceBuilder().sort(
            client().prepareIndex("index").setId("d2").setSource(d2Builder)
            .setQuery(matchAllQuery())
        );
        );
 * under the License.
        );
        searchResponse = client().prepareSearch()
import org.opensearch.index.query.MatchAllQueryBuilder;
        SearchResponse searchResponse = client().prepareSearch()
            (Double) searchResponse.getHits().getAt(0).getSortValues()[0],
        }
            )
            .get();
        assertThat(
            true,
        String hashPoint = "s037ms06g7h0";
        );
            .setQuery(matchAllQuery())
            .addSort(geoDistanceSortBuilder.sortMode(SortMode.MIN).order(SortOrder.ASC))
        );
            true,
            .addSort(geoDistanceSortBuilder.sortMode(SortMode.MIN).order(SortOrder.ASC))
        builder.startObject();
            } else {
            (Double) searchResponse.getHits().getAt(0).getSortValues()[0],
            (Double) searchResponse.getHits().getAt(0).getSortValues()[0],
            .get();
          |2  o| x      | x
            .setQuery(new MatchAllQueryBuilder())
        );
        checkCorrectSortOrderForGeoSort(searchResponse);
        );
            .setSource(new SearchSourceBuilder().sort(SortBuilders.geoDistanceSort(LOCATION_FIELD, "s037ms06g7h0")))
            .addSort(fieldSort("double_field2").order(SortOrder.DESC).unmappedType("double"))
        searchResponse = client().prepareSearch()
        if (randomBoolean()) {
            client().prepareIndex("index").setId("d1").setSource(d1Builder),
        GeoDistanceSortBuilder geoDistanceSortBuilder = new GeoDistanceSortBuilder(LOCATION_FIELD, new GeoPoint(40.7128, -74.0060));
            .get();
        searchResponse = client().prepareSearch()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .setSource(
            .setSource(new SearchSourceBuilder().sort(SortBuilders.geoDistanceSort(LOCATION_FIELD, 2.0, 2.0)))
 * KIND, either express or implied.  See the License for the
        for (GeoPoint point : qPoints) {
 * The OpenSearch Contributors require contributions made to
            closeTo(GeoDistance.ARC.calculate(2, 2, 4, 1, DistanceUnit.METERS), 10d)
        logger.info("d2: {}", d2Builder);
            .get();
        Version version = randomBoolean() ? Version.CURRENT : VersionUtils.randomIndexCompatibleVersion(random());
        assertAcked(prepareCreate("index").setSettings(settings).setMapping(LOCATION_FIELD, "type=geo_point"));
                .setId("d1")
        assertThat(
        assertAcked(prepareCreate("index").setMapping("admin", "type=keyword", LOCATION_FIELD, "type=geo_point"));
import org.opensearch.common.geo.GeoPoint;
            .setQuery(matchAllQuery())
            client().prepareIndex("index")
            if (geoDistanceSortBuilder == null) {
        assertThat(
    }
        indexRandom(
 * ownership. Elasticsearch licenses this file to you under
            (Double) searchResponse.getHits().getAt(1).getSortValues()[0],
          |______________________
        logger.info("d2: {}", d2Builder);
    public void testCrossIndexIgnoreUnmapped() throws Exception {
        assertThat(
            true,
        super(settings);
        assertThat(
 */
        GeoDistanceSortBuilder geoDistanceSortBuilder = null;
            (Double) searchResponse.getHits().getAt(1).getSortValues()[0],
        );
import org.opensearch.index.query.BoolQueryBuilder;
            client().prepareIndex("index").setId("d1").setSource(d1Builder),
                        .field("lon", 2.3264)
    }
            q[0] = new GeoPoint(2, 1);
        Collections.shuffle(qPoints, random());
import static org.opensearch.index.query.QueryBuilders.boolQuery;
                    SortBuilders.geoDistanceSort(LOCATION_FIELD, 2.0, 2.0).validation(GeoValidationMethod.COERCE)
        );
            .addSort(fieldSort("long_field2").order(SortOrder.DESC).unmappedType("long"))
        assertOrderedSearchHits(searchResponse, "d1", "d2");
        XContentBuilder d2Builder = jsonBuilder();
            resp,
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            (Double) searchResponse.getHits().getAt(1).getSortValues()[0],
    private static void checkCorrectSortOrderForGeoSort(SearchResponse searchResponse) {
            .setQuery(matchAllQuery())
    public void testSingeToManyAvgMedian() throws ExecutionException, InterruptedException, IOException {
        );
            closeTo(GeoDistance.ARC.calculate(0, 0, 0, 4, DistanceUnit.METERS), 10d)
        assertThat(
                        .startObject(LOCATION_FIELD)
        searchResponse = client().prepareSearch()
 * the Apache License, Version 2.0 (the "License"); you may
        createShuffeldJSONArray(d1Builder, d1Points);
                )
    }
        assertOrderedSearchHits(searchResponse, "d2", "d1");
import java.util.Collections;
            closeTo(GeoDistance.ARC.calculate(2, 1, 6, 2, DistanceUnit.METERS), 10d)
            q[1] = new GeoPoint(2, 2);
import org.opensearch.common.geo.GeoDistance;
import static org.opensearch.index.query.QueryBuilders.existsQuery;
          1   2   3   4   5   6
import org.opensearch.common.settings.Settings;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertOrderedSearchHits;
            .addSort(new GeoDistanceSortBuilder(LOCATION_FIELD, q).sortMode(SortMode.MAX).order(SortOrder.ASC))
                .setId("d1")
        SearchResponse searchResponse = client().prepareSearch()
        /*
import org.opensearch.search.builder.SearchSourceBuilder;
        searchResponse = client().prepareSearch()
            .setQuery(bool)
            prepareCreate("test1").setMapping("str_field", "type=keyword", "long_field", "type=long", "double_field", "type=double").get()
 * GitHub history for details.
            true,
 * this file be licensed under the Apache-2.0 license or a
            .addSort(new GeoDistanceSortBuilder(LOCATION_FIELD, q).sortMode(SortMode.AVG).order(SortOrder.ASC))
                        .field("admin", "11")
            .setQuery(matchAllQuery())
          d2 = (0, 1), (0, 5), (0, 6); so avg. distance is 4, median distance is 5
import java.util.ArrayList;
            .setQuery(matchAllQuery())
    protected boolean forbidPrivateIndexSettings() {
        resp = client().prepareSearch("test1", "test2")
            client().prepareIndex("index").setId("d2").setSource(d2Builder)
            .addSort(new GeoDistanceSortBuilder(LOCATION_FIELD, q).sortMode(SortMode.MIN).order(SortOrder.ASC))
        indexRandom(
 * software distributed under the License is distributed on an
        indexRandom(
 * Licensed to Elasticsearch under one or more contributor
        searchResponse = client().prepareSearch()
            .get();
        checkCorrectSortOrderForGeoSort(searchResponse);
        );
            q[1] = new GeoPoint(2, 2);
                .setSource(jsonBuilder().startObject().startObject(LOCATION_FIELD).field("lat", 1).field("lon", 1).endObject().endObject()),
        indexRandom(
import java.util.Collection;
                .setSource(jsonBuilder().startObject().startObject(LOCATION_FIELD).field("lat", 1).field("lon", 2).endObject().endObject())
            .get();
 *
            closeTo(GeoDistance.ARC.calculate(40.7128, -74.0060, 48.8331, 2.3264, DistanceUnit.KILOMETERS), 1.e-1)
            .addSort(fieldSort("str_field").order(SortOrder.ASC).unmappedType("keyword"))
            closeTo(GeoDistance.ARC.calculate(2, 2, 1, 1, DistanceUnit.METERS), 1.e-1)
        XContentBuilder d1Builder = jsonBuilder();
        assertAcked(prepareCreate("index").setMapping(LOCATION_FIELD, "type=geo_point"));
                    .order(SortOrder.DESC)
        GeoPoint[] q = new GeoPoint[2];
 */
        );
            }
         */
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
    public GeoDistanceSortBuilderIT(Settings settings) {
        checkCorrectSortOrderForGeoSort(searchResponse);
            .get();
    }
 * specific language governing permissions and limitations
import static org.hamcrest.Matchers.closeTo;
        assertSortValues(resp, new Object[] { "bcd", null }, new Object[] { null, null });
        logger.info("d1: {}", d1Builder);
        assertOrderedSearchHits(searchResponse, "d1");
            .setSize(4)
          |    |        |
        assertSortValues(
        /*
        assertThat(
/*
            )
        builder.endObject();
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        }
            .addSort(new GeoDistanceSortBuilder(LOCATION_FIELD, q).sortMode(SortMode.MAX).order(SortOrder.DESC))
import org.opensearch.action.search.SearchResponse;
        assertAcked(
        assertOrderedSearchHits(searchResponse, "d1");
        assertThat(
        );
            (Double) searchResponse.getHits().getAt(1).getSortValues()[0],
        );
            client().prepareIndex("test2").setSource()
    @Override
           q     d1       d2
 * compatible open source license.
        XContentBuilder d1Builder = jsonBuilder();
        GeoPoint[] d2Points = { new GeoPoint(0, 1), new GeoPoint(0, 5), new GeoPoint(0, 6) };
            .addSort(fieldSort("double_field").order(SortOrder.ASC).unmappedType("double"))
        GeoPoint[] d1Points = { new GeoPoint(0, 1), new GeoPoint(0, 4), new GeoPoint(0, 10) };
        );
            .addSort(
        builder.endArray();
        assertSortValues(resp, new Object[] { 3L, Long.MIN_VALUE }, new Object[] { Long.MAX_VALUE, Long.MIN_VALUE });
                .setSource(
            .addSort(new GeoDistanceSortBuilder(LOCATION_FIELD, q).sortMode(SortMode.MEDIAN).order(SortOrder.ASC))
        assertOrderedSearchHits(searchResponse, "d1", "d2");
public class GeoDistanceSortBuilderIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
            (Double) searchResponse.getHits().getAt(1).getSortValues()[0],
            closeTo(GeoDistance.ARC.calculate(0, 0, 0, 5, DistanceUnit.METERS), 10d)
    private static final String LOCATION_FIELD = "location";
package org.opensearch.search.sort;
        List<GeoPoint> qPoints = Arrays.asList(new GeoPoint(2, 1), new GeoPoint(2, 2), new GeoPoint(2, 3), new GeoPoint(2, 4));
        return false;
        );
          |1  o|x       |x
          |1  o|      x | x
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            .setSource(new SearchSourceBuilder().sort(SortBuilders.geoDistanceSort(LOCATION_FIELD, 2.0, 2.0)))
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSortValues;
    public void testManyToManyGeoPointsWithDifferentFormats() throws ExecutionException, InterruptedException, IOException {
                        .endObject()
import org.opensearch.common.unit.DistanceUnit;
        GeoPoint q = new GeoPoint(0, 0);
                .setId("d2")
            (Double) searchResponse.getHits().getAt(0).getSortValues()[0],
        searchResponse = client().prepareSearch()
        assertOrderedSearchHits(searchResponse, "d1", "d2");
            closeTo(GeoDistance.ARC.calculate(2.5, 1, 2, 1, DistanceUnit.METERS), 1.e-1)
        );
        logger.info("d1: {}", d1Builder);
import java.util.Arrays;
        /*
        Version version = randomBoolean() ? Version.CURRENT : VersionUtils.randomIndexCompatibleVersion(random());
    public void testGeoDistanceQueryThenSort() throws Exception {
          |    |        |
    }
          1   2   3   4   5   6   7
            client().prepareIndex("index")
        SearchResponse searchResponse = client().prepareSearch()
    public void testSinglePointGeoDistanceSort() throws ExecutionException, InterruptedException, IOException {
                        .field("lat", 48.8331)
                    .ignoreUnmapped(true)
    public void testManyToManyGeoPoints() throws ExecutionException, InterruptedException, IOException {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
          |    |        |
        );
        );
          |2  o|  x     |     x
                    jsonBuilder().startObject()
            .setQuery(matchAllQuery())
import org.opensearch.Version;
        checkCorrectSortOrderForGeoSort(searchResponse);
        assertOrderedSearchHits(searchResponse, "d2", "d1");
        assertOrderedSearchHits(searchResponse, "d2", "d1");
            .setQuery(matchAllQuery())
        searchResponse = client().prepareSearch()
            (Double) searchResponse.getHits().getAt(0).getSortValues()[0],
        createShuffeldJSONArray(d2Builder, d2Points);
            client().prepareIndex("index")
        );
import java.util.concurrent.ExecutionException;
            .addSort(geoDistanceSortBuilder.sortMode(SortMode.MAX).order(SortOrder.ASC))
    @ParametersFactory
        return Arrays.asList(
        );
            new Object[] { Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY }
        assertAcked(prepareCreate("test2").get());
        GeoPoint[] d1Points = { new GeoPoint(2.5, 1), new GeoPoint(2.75, 2), new GeoPoint(3, 3), new GeoPoint(3.25, 4) };
        assertThat(
         */
/*
        assertThat(
import org.opensearch.core.xcontent.XContentBuilder;
        checkCorrectSortOrderForGeoSort(searchResponse);
            .addSort(new GeoDistanceSortBuilder(LOCATION_FIELD, q).sortMode(SortMode.MIN).order(SortOrder.DESC))
            (Double) searchResponse.getHits().getAt(0).getSortValues()[0],
            client().prepareIndex("test1").setSource("str_field", "bcd", "long_field", 3, "double_field", 0.65),
        SearchResponse searchResponse = client().prepareSearch()
            closeTo(GeoDistance.ARC.calculate(3.25, 4, 2, 1, DistanceUnit.METERS), 1.e-1)
            .setSize(10)
 * not use this file except in compliance with the License.
            closeTo(GeoDistance.ARC.calculate(9.227400, 49.189800, 48.8331, 2.3264, DistanceUnit.KILOMETERS), 1.e-1)
            (Double) searchResponse.getHits().getAt(0).getSortValues()[0],
        assertThat(
        assertAcked(prepareCreate("index").setSettings(settings).setMapping(LOCATION_FIELD, "type=geo_point"));
            .get();
          |___________________________
            .setQuery(matchAllQuery())
            closeTo(GeoDistance.ARC.calculate(2, 1, 5, 1, DistanceUnit.METERS), 10d)
        searchResponse = client().prepareSearch()
          |    |        |
        assertThat(
 */
        );
        searchResponse = client().prepareSearch()
        GeoPoint[] d2Points = { new GeoPoint(5, 1), new GeoPoint(6, 2) };
            .get();
                        .endObject()
        SearchResponse resp = client().prepareSearch("test1", "test2")
        );
 * Unless required by applicable law or agreed to in writing,
    public static Collection<Object[]> parameters() {
            .get();
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        GeoDistanceSortBuilder geoDistanceSortBuilder = new GeoDistanceSortBuilder(LOCATION_FIELD, hashPoint);
            .setQuery(matchAllQuery())
        BoolQueryBuilder bool = boolQuery().filter(existsQuery(LOCATION_FIELD));
            (Double) searchResponse.getHits().getAt(1).getSortValues()[0],
        assertThat(
            .addSort(fieldSort("str_field2").order(SortOrder.DESC).unmappedType("keyword"))
 * this work for additional information regarding copyright
        assertThat(
        indexRandom(
        assertOrderedSearchHits(searchResponse, "d1", "d2");
            closeTo(GeoDistance.ARC.calculate(2, 2, 3, 2, DistanceUnit.METERS), 10d)
    }
        );
 *
        indexRandom(
        XContentBuilder d1Builder = jsonBuilder();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .get();
            .get();
        } else {
        int numPoints = points.size();
        checkCorrectSortOrderForGeoSort(searchResponse);
        );
                geoDistanceSortBuilder = new GeoDistanceSortBuilder(LOCATION_FIELD, point);
        );
    }
 *
        resp = client().prepareSearch("test1", "test2")
            closeTo(GeoDistance.ARC.calculate(0, 0, 0, 4, DistanceUnit.METERS), 10d)
            .get();
            .addSort(geoDistanceSortBuilder.sortMode(SortMode.MIN).order(SortOrder.ASC))
    protected void createShuffeldJSONArray(XContentBuilder builder, GeoPoint[] pointsArray) throws IOException {
 * license agreements. See the NOTICE file distributed with
            closeTo(GeoDistance.ARC.calculate(0, 0, 0, 5, DistanceUnit.METERS), 10d)
import java.util.List;
          |    |        |
        assertThat(
        );
            .get();
         */
            (Double) searchResponse.getHits().getAt(0).getSortValues()[0],
import static org.opensearch.search.sort.SortBuilders.fieldSort;
        SearchResponse searchResponse = client().prepareSearch()
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
        assertThat(
        builder.startArray(LOCATION_FIELD);
    }
        assertAcked(prepareCreate("index").setSettings(settings).setMapping(LOCATION_FIELD, "type=geo_point"));
            builder.value(points.remove(randomInt(points.size() - 1)));
                    .geoDistance(GeoDistance.ARC)
          q  = (0, 0)
            true,
            .setQuery(matchAllQuery())
            .addSort(fieldSort("long_field").order(SortOrder.ASC).unmappedType("long"))
        createShuffeldJSONArray(d1Builder, d1Points);
            .get();
            (Double) searchResponse.getHits().getAt(1).getSortValues()[0],
            .addSort(geoDistanceSortBuilder.sortMode(SortMode.MIN).order(SortOrder.ASC))
            closeTo(GeoDistance.ARC.calculate(2, 2, 1, 2, DistanceUnit.METERS), 1.e-1)
            (Double) searchResponse.getHits().getAt(1).getSortValues()[0],
            closeTo(GeoDistance.ARC.calculate(4.5, 1, 2, 1, DistanceUnit.METERS), 1.e-1)
        Version version = randomBoolean() ? Version.CURRENT : VersionUtils.randomIndexCompatibleVersion(random());
            true,
        );
        searchResponse = client().prepareSearch()
          d1 = (0, 1), (0, 4), (0, 10); so avg. distance is 5, median distance is 4
        GeoPoint[] d2Points = { new GeoPoint(4.5, 1), new GeoPoint(4.75, 2), new GeoPoint(5, 3), new GeoPoint(5.25, 4) };
    }
 * You may obtain a copy of the License at
 * SPDX-License-Identifier: Apache-2.0
            q[0] = new GeoPoint(2, 1);
        geoDistanceSortBuilder = new GeoDistanceSortBuilder(LOCATION_FIELD, new GeoPoint(2, 2));
                geoDistanceSortBuilder.points(point);
        assertThat(
          |4  o|   x    |   x
                geoDistanceSortBuilder.unit(DistanceUnit.KILOMETERS)
        XContentBuilder d2Builder = jsonBuilder();
            .get();
        for (int i = 0; i < numPoints; i++) {
        createShuffeldJSONArray(d2Builder, d2Points);
            closeTo(GeoDistance.ARC.calculate(2, 2, 3, 2, DistanceUnit.METERS), 10d)
    }
        points.addAll(Arrays.asList(pointsArray));
        checkCorrectSortOrderForGeoSort(searchResponse);
