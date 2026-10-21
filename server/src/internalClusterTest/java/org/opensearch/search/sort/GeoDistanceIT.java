            .get();
            .get();
        // Order: Asc
            .setId("2")
            // expected
            .get();
            .get();
                        .field("lat", 40.7143528)
        searchResponse = client().prepareSearch("test")
        assertAcked(prepareCreate("locations").setSettings(settings).setMapping(mapping));
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(2874.0d, 10d));
                    // to NY: 8.572 km
        } catch (IllegalArgumentException e) {
                SortBuilders.geoDistanceSort("branches.location", 40.7143528, -74.0059731)
            .get();
                    // to NY: 5.286 km
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(0d, 10d));
import org.opensearch.cluster.metadata.IndexMetadata;
            client().prepareSearch("companies")
                        .startObject()
        assertHitCount(searchResponse, 2);
                    .startObject()
                                     // 8.572 km
        searchResponse = client().prepareSearch("test")
                    .field("lat", 40.718266)
                        .endObject() // to NY:
                    .startObject()
                    // to NY: 1.258 km
                        .endObject()
                        .setNestedPath("branches")
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
        assertThat(((Number) searchResponse.getHits().getAt(3).getSortValues()[0]).doubleValue(), closeTo(1055.0d, 10d));
                    .field("lon", -73.9844722)
                                     // 0.4621
        assertOrderedSearchHits(searchResponse, "1", "3", "2", "4");
        assertThat(((Number) searchResponse.getHits().getAt(3).getSortValues()[0]).doubleValue(), closeTo(8572.0d, 10d));
        indexRandomForConcurrentSearch("test1", "test2");
        double lat = 40.720611;
            client().prepareIndex("companies")
                        .startArray("branches")
    @ParametersFactory
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(5301.0d, 10d));
                .setSource(
            .get();
            .setSource(
            .setSource(
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), closeTo(462.1d, 10d));
                .setSource(
                    // to NY: 1.055 km
            .get();
        assertThat(((Number) searchResponse.getHits().getAt(4).getSortValues()[0]).doubleValue(), closeTo(0d, 10d));
        assertHitCount(searchResponse, 5);
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(0d, 10d));
                        .startObject()
    public void testDistanceSortingWithMissingGeoPoint() throws Exception {
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(1055.0d, 10d));
            .setQuery(matchAllQuery())
            .setSource(
 * license agreements. See the NOTICE file distributed with
                    .endObject()
            .setId("1")
        assertOrderedSearchHits(searchResponse, "1", "2", "4", "3", "5");
            .setQuery(matchAllQuery())
                    .endObject()
        );
            .setQuery(matchAllQuery())
 * KIND, either express or implied.  See the License for the
        client().prepareGet("locations", "1").get();
        assertThat(((Number) searchResponse.getHits().getAt(3).getSortValues()[0]).doubleValue(), closeTo(0d, 10d));
        assertThat(((Number) searchResponse.getHits().getAt(3).getSortValues()[0]).doubleValue(), closeTo(2029.0d, 10d));
                SortBuilders.geoDistanceSort("branches.location", 40.7143528, -74.0059731).order(SortOrder.DESC).setNestedPath("branches")
                        .endArray()
    }
 *
        // Order: Asc
                .setId("1")
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(5301.0d, 10d));
        // Order: Desc
                    // to NY: 0.4621 km
                jsonBuilder().startObject()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFirstHit;
            .get();
                    .startArray("locations")
            .field("type", "geo_point");
                    .field("lon", -74.0088305)
        SearchResponse searchResponse = client().prepareSearch("test1", "test2")
}
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(0d, 10d));
        assertOrderedSearchHits(searchResponse, "1", "2", "3", "4");
        assertHitCount(searchResponse, 4);
                    .endArray()
                )
                        .startArray("branches")
            .get();
            client().prepareIndex("companies")
 * The OpenSearch Contributors require contributions made to
                                     // km
            .startObject()
import org.opensearch.test.VersionUtils;
                    .field("lat", 40.7247222)
                    .setNestedPath("branches")
        assertThat(searchResponse.getFailedShards(), greaterThan(0));
                        .endObject()
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
                    .startObject()
    protected boolean forbidPrivateIndexSettings() {
        client().prepareIndex("test1")
 * Unless required by applicable law or agreed to in writing,
            // expected
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
        // Order: Desc, Mode: min
/*
import org.opensearch.Version;
                    .setNestedPath("branches")
     */
        searchResponse = client().prepareSearch("companies")
        }
                    .endObject()
                    .sortMode(SortMode.MIN)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .startObject("name")
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), closeTo(5286.0d, 10d));
        assertOrderedSearchHits(searchResponse, "4", "3", "2", "1");
            .setSource(jsonBuilder().startObject().array("names", "Wall Street", "Soho").endObject())
                    .field("lat", 40.718266)
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
                    .sortMode(SortMode.MAX)
 * this work for additional information regarding copyright
        assertOrderedSearchHits(searchResponse, "5", "4", "3", "2", "1");
            .setSource(
        xContentBuilder.field("ignore_malformed", true).endObject().endObject().endObject();
                        .endArray()
    public void testDistanceSortingWithUnmappedField() throws Exception {
    public void testDistanceSortingMVFields() throws Exception {
 * not use this file except in compliance with the License.
            )
            .get();
 * Licensed to Elasticsearch under one or more contributor
        assertOrderedSearchHits(searchResponse, "4", "2", "3", "1");
        // Order: Asc
                    .field("lon", -74.0059731)
        assertOrderedSearchHits(searchResponse, "2", "1");
                        .startObject()
        searchResponse = client().prepareSearch("test1", "test2")
        double lon = -73.998776;
        // Order: Desc
import org.opensearch.core.xcontent.XContentBuilder;
                    .endObject()
                        .startObject("location")
import java.util.Collection;
            .startObject("locations")
                        .field("name", "New York")
            .startObject("properties")
                    .field("lon", -74.007819)
        assertAcked(prepareCreate("test1").setMapping(xContentBuilder));
            )
                    .order(SortOrder.ASC)
            .field("type", "text")
            )
                    .sortMode(SortMode.AVG)
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(8572.0d, 10d));
                .setId("3")
                    .setNestedPath("branches")
 * SPDX-License-Identifier: Apache-2.0
                        .startObject("location")
                        .startObject("location")
            )
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(462.1d, 10d));
        assertThat(((Number) searchResponse.getHits().getAt(4).getSortValues()[0]).doubleValue(), closeTo(0d, 10d));
import org.opensearch.common.xcontent.json.JsonXContent;
        searchResponse = client().prepareSearch("test")
    }
                jsonBuilder().startObject()
            .addSort(
                    // to NY: 2.029 km
            )
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            .field("type", "geo_point");
                    .field("names", "New York")
            .endObject()
        refresh();
            .setQuery(matchAllQuery())
        searchResponse = client().prepareSearch("test")
                    .field("lat", 400.7143528)
                    .endObject()
        refresh();
            .get();
            .startObject()
     * Issue 3073
                    .order(SortOrder.DESC)
        XContentBuilder source = JsonXContent.contentBuilder().startObject().field("pin", Geohash.stringEncode(lon, lat)).endObject();
        // Order: Desc
                        .endObject()
                    .startObject()
 * this file be licensed under the Apache-2.0 license or a
                        .startArray("branches")
                    .field("lat", 40.731033)
                SortBuilders.geoDistanceSort("branches.location", 40.7143528, -74.0059731)
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
                    jsonBuilder().startObject()
    }
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder()
            .get();
                        .startObject()
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            .setQuery(matchAllQuery())
                                     // 2.029
                        .field("name", "Brooklyn")
                    .array("names", "Times Square", "Tribeca")
                .setSource(
            .addSort(
            .addSort(SortBuilders.geoDistanceSort("locations", 40.7143528, -74.0059731).order(SortOrder.DESC))
                    .startObject()
            .addSort(SortBuilders.geoDistanceSort("locations", 40.7143528, -74.0059731).sortMode(SortMode.AVG).order(SortOrder.ASC))
                    .endObject()
        assertHitCount(searchResponse, 2);
package org.opensearch.search.sort;
                    jsonBuilder().startObject()
            .startObject()
                    .field("lon", -73.9844722)
                        .field("name", "company 2")
                    // to NY: 0.4621 km
                    .endObject()
    public static Collection<Object[]> parameters() {
            )
                .addSort(SortBuilders.geoDistanceSort("locations", 40.7143528, -74.0059731).sortMode(SortMode.SUM));
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(1055.0d, 10d));
import org.opensearch.action.search.SearchResponse;
        assertThat(((Number) searchResponse.getHits().getAt(3).getSortValues()[0]).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
                    .endObject()
            .startObject("branches")
        refresh();
            .startObject()
                    .field("lat", 40.718266)
    }
        SearchResponse result = client().prepareSearch("locations")
            .get();
        assertOrderedSearchHits(searchResponse, "5", "3", "4", "2", "1");
            .setQuery(matchAllQuery())
            .addSort(SortBuilders.geoDistanceSort("locations", 40.7143528, -74.0059731).order(SortOrder.ASC))
        ensureGreen();
            )
        client().prepareIndex("test")
        assertThat(((Number) searchResponse.getHits().getAt(3).getSortValues()[0]).doubleValue(), closeTo(0d, 10d));
        assertThat(((Number) searchResponse.getHits().getAt(3).getSortValues()[0]).doubleValue(), closeTo(5286.0d, 10d));
        SearchResponse searchResponse = client().prepareSearch("companies")
        assertAcked(prepareCreate("companies").setSettings(settings).setMapping(xContentBuilder));
                    .field("lon", -74.007819)
                        .endObject() // to NY:
                    .order(SortOrder.ASC)
 * software distributed under the License is distributed on an
        client().admin().indices().prepareRefresh().get();
            .setPostFilter(QueryBuilders.geoDistanceQuery("pin").geoDistance(GeoDistance.ARC).point(lat, lon).distance("1m"))
                        .field("name", "company 4")
 */
        return false;
import org.opensearch.geometry.utils.Geohash;
            .setId("4")
                jsonBuilder().startObject()
 * compatible open source license.
import org.opensearch.index.query.QueryBuilders;
 * GitHub history for details.
            .setQuery(matchAllQuery())
        assertHitCount(searchResponse, 1);
                        .field("lat", 40.7051157)
                jsonBuilder().startObject()
            .get();
        assertThat(((Number) searchResponse.getHits().getAt(4).getSortValues()[0]).doubleValue(), closeTo(2029.0d, 10d));
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(5286d, 10d));
            .addSort(
                .setQuery(matchAllQuery())
        assertOrderedSearchHits(searchResponse, "2", "1");
                        .endObject()
            .startObject("properties")
                                     // km
            )
            .setQuery(QueryBuilders.matchAllQuery())
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), closeTo(1157.0d, 10d));
import static org.opensearch.index.query.QueryBuilders.termQuery;
        assertThat(((Number) searchResponse.getHits().getAt(3).getSortValues()[0]).doubleValue(), closeTo(0d, 10d));
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            .field("type", "nested")
            true,
                SortBuilders.geoDistanceSort("branches.location", 40.7143528, -74.0059731)
            .setQuery(matchAllQuery())
        mapping.endObject().endObject().endObject();
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), closeTo(2874.0d, 10d));
            .addSort(SortBuilders.geoDistanceSort("locations", 40.7143528, -74.0059731).order(SortOrder.ASC))
        client().prepareIndex("locations").setId("1").setCreate(true).setSource(source).get();
    public void testDistanceSortingNestedFields() throws Exception {
import org.opensearch.common.xcontent.XContentFactory;
                    .array("names", "Wall Street", "Soho")
                        .endObject()
            .setId("2")
                    .setNestedPath("branches")
                        .field("lat", 40.718266)
            .startObject("properties")
                    .startObject()
            .get();
                    .sortMode(SortMode.AVG)
                    .array("names", "Times Square", "Tribeca")
            )
                jsonBuilder().startObject()
                    .endObject()
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder()
        }
        assertOrderedSearchHits(searchResponse, "1", "2", "4", "3", "5");
                    .field("lat", 40.759011)
            .startObject("locations")
                        .endObject()
import org.opensearch.common.geo.GeoDistance;
 */
        searchResponse = client().prepareSearch("companies")
                    .order(SortOrder.DESC)
        assertHitCount(searchResponse, 5);
            .addSort(
            .setQuery(matchAllQuery())
            .startObject()
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            .get();
import static org.hamcrest.Matchers.equalTo;
        SearchResponse searchResponse = client().prepareSearch("test")
            .field("type", "geo_point");
                        .field("lon", -74)
        return Arrays.asList(
            )
                    .field("lat", 40.759011)
                    .endArray()
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(5286.0d, 10d));
            .startObject("name")
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(2029.0d, 10d));
import java.io.IOException;
                    .startArray("locations")
            .get();
            .startObject("properties")
                );
            fail("sum should not be supported for sorting by geo distance");
                    .startObject()
                SortBuilders.geoDistanceSort("branches.location", 40.7143528, -74.0059731)
                    // to NY: 5.286 km
                    .setNestedPath("branches")
        );
                ),
        assertThat(((Number) searchResponse.getHits().getAt(4).getSortValues()[0]).doubleValue(), closeTo(8572.0d, 10d));
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(8572.0d, 10d));
            .setId("5")
            .get();
                        .sortMode(SortMode.SUM)
        assertThat(((Number) searchResponse.getHits().getAt(3).getSortValues()[0]).doubleValue(), closeTo(2874d, 10d));
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), closeTo(1258.0d, 10d));
 */
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder()
        assertHitCount(searchResponse, 4);
        XContentBuilder mapping = JsonXContent.contentBuilder()
        // Doc with missing geo point is first, is consistent with 0.20.x
            )
 * under the License.
        assertAcked(prepareCreate("test2"));
                        .endArray()
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(5286.0d, 10d));
                    .endObject()
                    .field("lon", 285.9990269)
        indexRandomForConcurrentSearch("locations");
            .addSort(
                    .array("names", "Times Square", "Tribeca")
            .setQuery(matchAllQuery())
            .addSort(
                    .field("names", "New York 2")
        assertHitCount(searchResponse, 4);
        assertThat(((Number) searchResponse.getHits().getAt(3).getSortValues()[0]).doubleValue(), closeTo(421.2d, 10d));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertOrderedSearchHits;
                    jsonBuilder().startObject()
        assertOrderedSearchHits(searchResponse, "5", "3", "4", "2", "1");
 * ownership. Elasticsearch licenses this file to you under
            .addSort(
    }
                        .field("lon", -74.007819)
        // Order: Asc
                    .endObject()
        assertHitCount(searchResponse, 5);
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
                        .field("lon", -73.95)
        client().prepareIndex("test")
            .addSort(SortBuilders.geoDistanceSort("locations", 40.7143528, -74.0059731).order(SortOrder.DESC).sortMode(SortMode.MIN))
                        .field("name", "company 3")
                    .endArray()
                        .field("lon", -74.0059731)
            .setId("1")
        assertThat(((Number) searchResponse.getHits().getAt(3).getSortValues()[0]).doubleValue(), closeTo(5301.0d, 10d));
    /**
            .get();
        searchResponse = client().prepareSearch("companies")
        assertThat(((Number) searchResponse.getHits().getAt(3).getSortValues()[0]).doubleValue(), closeTo(421.2d, 10d));
        // Order: Desc
                    .field("lat", 40.7143528)
            .addSort(SortBuilders.geoDistanceSort("locations", 40.7143528, -74.0059731).order(SortOrder.DESC))
                    .startObject("locations")
                        .field("name", "Greenwich Village")
                jsonBuilder().startObject()
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), closeTo(1157d, 10d));
            .field("type", "geo_point");
                        .startObject("location")
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(1157.0d, 10d));
            .setQuery(matchAllQuery())
        client().prepareIndex("test")
                        .endObject()
                    .field("lat", 40.759011)
 * specific language governing permissions and limitations
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
/*
            .get();
        client().prepareIndex("test2")
            .endObject()
                    .field("lat", 40.65)
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(8572.0d, 10d));
        assertHitCount(searchResponse, 2);
            .get();
            .setSource(
            .setSource(jsonBuilder().startObject().array("names", "Wall Street", "Soho").endObject())
                    .endArray()
        assertSearchHits(searchResponse, "1", "2", "3", "4");
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(2029.0d, 10d));
                        .field("lat", 40.759011)
        // Order: Asc, Mode: max
            .get();
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(0d, 10d));
import org.opensearch.common.settings.Settings;
                        .endObject() // to NY:
            .addSort(SortBuilders.geoDistanceSort("locations", 40.7143528, -74.0059731).ignoreUnmapped(true).order(SortOrder.DESC))
                        .field("name", "Tribeca")
        assertHitCount(searchResponse, 5);
                .setId("2")
        assertAcked(prepareCreate("test").setSettings(settings).setMapping(xContentBuilder));
                        .endArray()
                        .endObject()
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
        SearchResponse searchResponse = client().prepareSearch("test")
                    .setNestedPath("branches")
                        .field("name", "Times Square")
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(462.1d, 10d));
        assertHitCount(searchResponse, 5);
 * You may obtain a copy of the License at
            .startObject("pin")
        client().prepareIndex("test")
                        .endObject()
        searchResponse = client().prepareSearch("test")
                    .field("lon", -74.007819)
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
 * the Apache License, Version 2.0 (the "License"); you may
        ensureGreen();
                    .setNestedFilter(termQuery("branches.name", "brooklyn"))
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
            .setQuery(matchAllQuery())
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(421.2d, 10d));
        client().prepareIndex("test")
                        .endObject()
                    .startObject()
                    .endObject()
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder()
            .setQuery(matchAllQuery())
import static org.hamcrest.Matchers.greaterThan;
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), closeTo(1055.0d, 10d));
                    .field("lon", -73.95)
            .get();
public class GeoDistanceIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        assertOrderedSearchHits(searchResponse, "1", "2");
                        .field("lon", -74.0088305)
        // Make sure that by default the unmapped fields continue to fail
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), closeTo(1258.0d, 10d));
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(0d, 10d));
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), closeTo(462.1d, 10d));
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(421.2d, 10d));
        xContentBuilder.endObject().endObject().endObject().endObject().endObject();
        ensureGreen();
                    .endObject()
            .setQuery(matchAllQuery())
                    .endObject()
            .field("type", "text")
        client().prepareIndex("test")
        assertFirstHit(searchResponse, hasId("4"));
                    .field("lon", -73.9844722)
            .startObject("location")
                    .field("lon", -73.9962255)
        indexRandom(
import static org.hamcrest.Matchers.closeTo;
                SortBuilders.geoDistanceSort("branches.location", 40.7143528, -74.0059731).order(SortOrder.ASC).setNestedPath("branches")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasId;
                ),
            .startObject("properties")
                        .field("lat", 40.7247222)
                        .startObject()
            )
    @Override
        assertThat(((Number) searchResponse.getHits().getAt(4).getSortValues()[0]).doubleValue(), closeTo(0d, 10d));
            .setSource(
        xContentBuilder.endObject().endObject().endObject();
                    .endObject()
        assertHitCount(searchResponse, 4);
            .addSort(SortBuilders.geoDistanceSort("locations", 40.7143528, -74.0059731).ignoreUnmapped(true).order(SortOrder.ASC))
                    .startArray("locations")
            .field("type", "geo_point");
                        .startObject()
            .setQuery(matchAllQuery())
        try {
        searchResponse = client().prepareSearch("companies")
    public GeoDistanceIT(Settings staticSettings) {
                        .field("lat", 40.65)
        assertHitCount(result, 1);
                    // to NY: 0.4621 km
                        .field("name", "Wall Street")
                    .startObject()
                        .startObject("location")
                    .sortMode(SortMode.AVG)
                .setSource(
        assertThat(((Number) searchResponse.getHits().getAt(4).getSortValues()[0]).doubleValue(), closeTo(5301d, 10d));
        try {
                    .array("names", "Greenwich Village", "Brooklyn")
            .setQuery(matchAllQuery())
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), closeTo(1157.0d, 10d));
                    .startObject("locations")
                .addSort(
                    jsonBuilder().startObject()
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(1258.0d, 10d));
                SortBuilders.geoDistanceSort("branches.location", 40.7143528, -74.0059731)
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                                     // km
        searchResponse = client().prepareSearch("companies")
        assertHitCount(searchResponse, 5);
        // Doc with missing geo point is first, is consistent with 0.20.x
                    .startObject()
        indexRandomForConcurrentSearch("test");
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
                        .endObject()
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(421.2d, 10d));
            client().prepareSearch("test")
        assertOrderedSearchHits(searchResponse, "1", "2", "3", "4", "5");
        ensureGreen();
                    .endObject()
                ),
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
        // Order: Asc, Mode: max
        assertOrderedSearchHits(searchResponse, "1", "3", "2", "4");
        // Order: Desc, Mode: min
                    .field("lat", 40.7051157)
                        .field("lon", -73.9962255)
                    SortBuilders.geoDistanceSort("branches.location", 40.7143528, -74.0059731)
            .setId("1")
            .addSort(SortBuilders.geoDistanceSort("locations", 40.7143528, -74.0059731).order(SortOrder.DESC))
                        .startArray("branches")
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), closeTo(1258.0d, 10d));
                        .endObject()
    public void testGeoDistanceFilter() throws IOException, InterruptedException {
        searchResponse = client().prepareSearch("test1", "test2")
                        .endObject() // to NY: 1.055 km
                        .endObject() // to NY: 5.286 km
                    .endArray()
 *
    }
        assertHitCount(searchResponse, 2);
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            .get();
        assertAcked(prepareCreate("test").setSettings(settings).setMapping(xContentBuilder));
            fail("Sum should not be allowed as sort mode");
            .addSort(SortBuilders.geoDistanceSort("locations", 40.7143528, -74.0059731).sortMode(SortMode.AVG).order(SortOrder.DESC))
                    .endObject()
                        .startObject("location")
                        .field("lon", -73.9844722)
            client().prepareIndex("companies")
 * Modifications Copyright OpenSearch Contributors. See
        super(staticSettings);
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            .setQuery(matchAllQuery())
            .startObject("properties")
            .setId("2")
                jsonBuilder().startObject()
            client().prepareIndex("companies")
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), closeTo(462.1d, 10d));
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
                        .endObject() // to NY: 1.258
            .setSource(
            )
                    // to NY: 5.286 km
            .get();
        xContentBuilder.endObject().endObject().endObject();
                        .startObject("location")
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(5286d, 10d));
                        .field("name", "company 1")
        indexRandomForConcurrentSearch("test");
import java.util.Arrays;
                        .startObject()
            )
                        .field("name", "Soho")
                    .endObject()
        client().prepareIndex("test")
                    .startArray("locations")
            .get();
                        .field("lat", 40.731033)
        searchResponse = client().prepareSearch("companies")
        } catch (IllegalArgumentException e) {
            .startObject("locations")
        assertOrderedSearchHits(searchResponse, "1", "2");
        assertThat(((Number) searchResponse.getHits().getAt(3).getSortValues()[0]).doubleValue(), closeTo(421.2d, 10d));
                    .field("lon", -74)
                .setQuery(matchAllQuery())
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
                    .endObject()
                .setId("4")
            .setId("3")
 *
                    .order(SortOrder.ASC)
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(2874.0d, 10d));
            .setQuery(matchAllQuery())
    }
        assertHitCount(searchResponse, 4);
        assertHitCount(searchResponse, 4);
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            .get();
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(0d, 10d));
        searchResponse = client().prepareSearch("test")
            .addSort(SortBuilders.geoDistanceSort("locations", 40.7143528, -74.0059731).order(SortOrder.ASC).sortMode(SortMode.MAX))
                    .startArray("locations")
        assertHitCount(searchResponse, 4);
        assertOrderedSearchHits(searchResponse, "4", "2", "3", "1");
            .get();
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(462.1d, 10d));
