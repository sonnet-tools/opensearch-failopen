        client().prepareIndex("test")  
        SearchResponse searchResponse = client().prepareSearch("test")
        assertThat(((Number) searchResponse.getHits().getAt(3).getSortValues()[0]).doubleValue(), closeTo(421.2d, 10d));
    }
    public void testGeoDistanceFilter() throws IOException, InterruptedException {  
                        .endObject()
        xContentBuilder.endObject().endObject().endObject().endObject().endObject();
                    .field("lon", -74.007819)  
            // expected
                        .startObject()  
import java.util.Collection;  
        double lat = 40.720611;  
            .startObject("locations")
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
import static org.hamcrest.Matchers.greaterThan;
                        .field("lat", 40.65)
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(5286.0d, 10d));
        assertOrderedSearchHits(searchResponse, "1", "2", "3", "4");
            .field("type", "text")  
                .setId("3")
                    .field("lat", 40.718266)
 * ownership. Elasticsearch licenses this file to you under  
                    .startObject()
 * compatible open source license.
            )
                    .field("lat", 40.7247222)
            .get();  
                        .field("lon", -73.9962255)
                        .startObject("location")  
                        .field("lat", 40.731033)
    }
        SearchResponse searchResponse = client().prepareSearch("test1", "test2")
                ),
        assertOrderedSearchHits(searchResponse, "1", "3", "2", "4");
                        .startObject()
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
            .addSort(
                        .endObject() // to NY:  
import org.opensearch.geometry.utils.Geohash;
            .setSource(  
                    .endObject()
            .startObject("properties")
            .startObject()
            .addSort(SortBuilders.geoDistanceSort("locations", 40.7143528, -74.0059731).ignoreUnmapped(true).order(SortOrder.DESC))
            .get();
import org.opensearch.index.query.QueryBuilders;  
        assertHitCount(searchResponse, 2);  
            client().prepareIndex("companies")
            .field("type", "geo_point");
        assertOrderedSearchHits(searchResponse, "4", "2", "3", "1");
        refresh();
            .setQuery(matchAllQuery())
            )  
        assertHitCount(searchResponse, 4);
            .endObject()
                    .startObject()
                        .endObject()
            .addSort(SortBuilders.geoDistanceSort("locations", 40.7143528, -74.0059731).sortMode(SortMode.AVG).order(SortOrder.DESC))  
                        .endObject()  
            .startObject("properties")
                .setQuery(matchAllQuery())  
                        .startObject("location")  
import org.opensearch.test.VersionUtils;
 */
        assertThat(((Number) searchResponse.getHits().getAt(4).getSortValues()[0]).doubleValue(), closeTo(0d, 10d));
        double lon = -73.998776;
        // Order: Asc
            client().prepareIndex("companies")  
 * specific language governing permissions and limitations
            .field("type", "geo_point");  
            .setQuery(matchAllQuery())
                    .startObject("locations")
                    .startObject()
    }  
        assertThat(((Number) searchResponse.getHits().getAt(3).getSortValues()[0]).doubleValue(), closeTo(2029.0d, 10d));  
        assertAcked(prepareCreate("locations").setSettings(settings).setMapping(mapping));  
                    // to NY: 1.258 km  
                        .field("lat", 40.7143528)
                        .startObject("location")
        }  
                    .endObject()  
        assertThat(((Number) searchResponse.getHits().getAt(3).getSortValues()[0]).doubleValue(), closeTo(421.2d, 10d));
            .addSort(
                    .field("lon", -74.007819)
                        .field("lon", -74)  
                    .startObject("locations")
                    .startObject()
                jsonBuilder().startObject()  
                    .order(SortOrder.DESC)
            .setId("1")
    public static Collection<Object[]> parameters() {
                    .endObject()  
        assertThat(((Number) searchResponse.getHits().getAt(3).getSortValues()[0]).doubleValue(), closeTo(0d, 10d));  
                    .field("lon", -73.9844722)
            .get();  
                    .endObject()  
                    .endObject()  
     */
        XContentBuilder mapping = JsonXContent.contentBuilder()  
                        .field("name", "Brooklyn")
                        .endObject() // to NY:  
                    .field("lon", -74.0059731)  
        );  
                    .field("lon", -74)  
 * The OpenSearch Contributors require contributions made to  
            .get();
        client().prepareIndex("test")  
        assertThat(((Number) searchResponse.getHits().getAt(4).getSortValues()[0]).doubleValue(), closeTo(5301d, 10d));
        );  
        client().prepareIndex("test")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                        .endObject()  
        ensureGreen();
                    .field("lat", 40.759011)
            .setSource(
                        .field("lat", 40.759011)  
                        .startObject()
            .setQuery(matchAllQuery())
                    .endObject()
            true,
                jsonBuilder().startObject()
            .get();  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasId;
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(2874.0d, 10d));  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
            .setSource(  
                    jsonBuilder().startObject()
        assertOrderedSearchHits(searchResponse, "1", "2", "4", "3", "5");
        Version version = VersionUtils.randomIndexCompatibleVersion(random());  
                    .order(SortOrder.ASC)
                        .startObject()
                jsonBuilder().startObject()
        assertOrderedSearchHits(searchResponse, "1", "2", "4", "3", "5");  
                        .field("lon", -74.0059731)  
                    // to NY: 2.029 km
                    .field("lat", 400.7143528)  
            .setId("5")
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(421.2d, 10d));
        SearchResponse searchResponse = client().prepareSearch("test")  
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(5286d, 10d));
            .get();  
            .get();
            .setId("2")
            )
            .setQuery(matchAllQuery())
                    .endObject()
                    .field("lon", 285.9990269)
                SortBuilders.geoDistanceSort("branches.location", 40.7143528, -74.0059731).order(SortOrder.DESC).setNestedPath("branches")  
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(5301.0d, 10d));
    public void testDistanceSortingWithUnmappedField() throws Exception {
            .addSort(SortBuilders.geoDistanceSort("locations", 40.7143528, -74.0059731).ignoreUnmapped(true).order(SortOrder.ASC))  
            .field("type", "geo_point");  
                    jsonBuilder().startObject()
                    .array("names", "Wall Street", "Soho")
            .startObject("locations")  
        assertOrderedSearchHits(searchResponse, "5", "3", "4", "2", "1");
            .get();
            )
                        .endArray()
            .addSort(SortBuilders.geoDistanceSort("locations", 40.7143528, -74.0059731).order(SortOrder.DESC).sortMode(SortMode.MIN))
        // Order: Desc
            .setId("3")
                    .startObject()
        client().prepareIndex("test")
            .setQuery(matchAllQuery())  
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder()  
                    // to NY: 0.4621 km  
        assertHitCount(result, 1);
        searchResponse = client().prepareSearch("test")  
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
            .get();  
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(421.2d, 10d));
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(0d, 10d));
 * GitHub history for details.
                    .field("lat", 40.731033)  
                .setQuery(matchAllQuery())
            client().prepareIndex("companies")
            )  
                        .endObject() // to NY: 1.055 km  
        assertOrderedSearchHits(searchResponse, "2", "1");  
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(421.2d, 10d));  
                .setSource(  
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), closeTo(5286.0d, 10d));
        searchResponse = client().prepareSearch("test")  
        indexRandomForConcurrentSearch("test1", "test2");
 *
        assertHitCount(searchResponse, 5);
        assertHitCount(searchResponse, 5);
                        .field("name", "company 3")
        ensureGreen();  
                    .order(SortOrder.DESC)
        assertHitCount(searchResponse, 1);
                    .array("names", "Times Square", "Tribeca")
                        .startArray("branches")
                        .startObject()
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder()
            .addSort(SortBuilders.geoDistanceSort("locations", 40.7143528, -74.0059731).sortMode(SortMode.AVG).order(SortOrder.ASC))
                        .startObject()
import static org.hamcrest.Matchers.equalTo;
            .get();
        assertHitCount(searchResponse, 4);
    }
            .get();
            .addSort(SortBuilders.geoDistanceSort("locations", 40.7143528, -74.0059731).order(SortOrder.ASC))
            .startObject()  
        assertAcked(prepareCreate("test").setSettings(settings).setMapping(xContentBuilder));
            client().prepareSearch("companies")
            .addSort(SortBuilders.geoDistanceSort("locations", 40.7143528, -74.0059731).order(SortOrder.DESC))
        assertHitCount(searchResponse, 4);
 * Unless required by applicable law or agreed to in writing,
                        .sortMode(SortMode.SUM)  
            .setId("2")
        client().admin().indices().prepareRefresh().get();
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder()  
                        .endObject()  
        // Order: Asc
                        .field("lat", 40.7247222)
        client().prepareIndex("test")
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(462.1d, 10d));
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(8572.0d, 10d));  
    @Override  
            client().prepareIndex("companies")
    /**  
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), closeTo(1157.0d, 10d));
            .addSort(
            .startObject()
        // Make sure that by default the unmapped fields continue to fail
            client().prepareSearch("test")  
        searchResponse = client().prepareSearch("companies")
                    .startArray("locations")  
                jsonBuilder().startObject()  
                        .field("name", "company 1")  
            .get();
            fail("sum should not be supported for sorting by geo distance");  
            .get();
        assertOrderedSearchHits(searchResponse, "1", "3", "2", "4");
        assertOrderedSearchHits(searchResponse, "1", "2", "3", "4", "5");
        assertHitCount(searchResponse, 5);  
                jsonBuilder().startObject()
            .get();
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.search.SearchResponse;
                    jsonBuilder().startObject()  
        assertThat(((Number) searchResponse.getHits().getAt(4).getSortValues()[0]).doubleValue(), closeTo(0d, 10d));
        try {
        assertThat(((Number) searchResponse.getHits().getAt(3).getSortValues()[0]).doubleValue(), closeTo(2874d, 10d));
            )
                        .endObject() // to NY: 5.286 km
import static org.hamcrest.Matchers.closeTo;  
        searchResponse = client().prepareSearch("companies")  
                    SortBuilders.geoDistanceSort("branches.location", 40.7143528, -74.0059731)
        // Order: Asc, Mode: max
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), equalTo(Double.POSITIVE_INFINITY));  
 * under the License.  
            )  
                jsonBuilder().startObject()
                    .endObject()  
            .field("type", "nested")  
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
                    .startObject()  
            .addSort(SortBuilders.geoDistanceSort("locations", 40.7143528, -74.0059731).order(SortOrder.ASC))
            .addSort(SortBuilders.geoDistanceSort("locations", 40.7143528, -74.0059731).order(SortOrder.ASC).sortMode(SortMode.MAX))  
                    .endArray()
                    .field("lon", -73.95)  
                    // to NY: 5.286 km
        assertThat(((Number) searchResponse.getHits().getAt(3).getSortValues()[0]).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(0d, 10d));
        // Doc with missing geo point is first, is consistent with 0.20.x
            .startObject("properties")
                    .sortMode(SortMode.MIN)
                        .startArray("branches")
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), closeTo(462.1d, 10d));
        assertOrderedSearchHits(searchResponse, "1", "2");
                    .sortMode(SortMode.MAX)
        refresh();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            .addSort(  
        indexRandom(  
            .startObject("name")
                        .field("name", "company 2")
        assertHitCount(searchResponse, 4);  
                ),  
        refresh();  
                        .endObject() // to NY:  
            .setQuery(matchAllQuery())
            )  
                        .startObject("location")
            .startObject("branches")
                    .sortMode(SortMode.AVG)  
                    .endArray()
            )
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder()
            .setQuery(matchAllQuery())
                                     // 0.4621
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(0d, 10d));  
        SearchResponse searchResponse = client().prepareSearch("companies")  
        assertOrderedSearchHits(searchResponse, "4", "3", "2", "1");
        Version version = VersionUtils.randomIndexCompatibleVersion(random());  
    public void testDistanceSortingWithMissingGeoPoint() throws Exception {  
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), closeTo(1157.0d, 10d));
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
        assertAcked(prepareCreate("test").setSettings(settings).setMapping(xContentBuilder));  
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(1157.0d, 10d));  
            .setQuery(matchAllQuery())
                        .endObject()  
                    .order(SortOrder.ASC)
                    .field("lat", 40.7051157)  
            .setQuery(matchAllQuery())
                    .endObject()
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), closeTo(462.1d, 10d));
        assertHitCount(searchResponse, 2);
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(2029.0d, 10d));  
            .setSource(  
/*  
            .addSort(
        }  
            .get();
            .setSource(jsonBuilder().startObject().array("names", "Wall Street", "Soho").endObject())  
            .setId("1")
        searchResponse = client().prepareSearch("test")
                SortBuilders.geoDistanceSort("branches.location", 40.7143528, -74.0059731)  
        searchResponse = client().prepareSearch("companies")  
                                     // 8.572 km
import org.opensearch.Version;  
                    .field("lat", 40.718266)
                    .setNestedFilter(termQuery("branches.name", "brooklyn"))
                    .startArray("locations")  
        assertThat(((Number) searchResponse.getHits().getAt(3).getSortValues()[0]).doubleValue(), closeTo(0d, 10d));
            .get();  
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(1055.0d, 10d));
                    .setNestedPath("branches")  
 */  
                        .endArray()
                    // to NY: 1.055 km
            .setQuery(matchAllQuery())  
                        .endObject()
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    public GeoDistanceIT(Settings staticSettings) {  
        // Order: Desc, Mode: min
                    .field("lat", 40.759011)  
            )
        searchResponse = client().prepareSearch("test")
            .setId("4")
            )
                        .field("lon", -74.007819)
    public void testDistanceSortingNestedFields() throws Exception {
            .startObject("properties")
 *
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(8572.0d, 10d));
        searchResponse = client().prepareSearch("companies")
            .setQuery(matchAllQuery())
        // Order: Desc, Mode: min
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(8572.0d, 10d));
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
                        .endObject()
        client().prepareIndex("locations").setId("1").setCreate(true).setSource(source).get();
                        .endArray()  
        assertOrderedSearchHits(searchResponse, "2", "1");
        assertOrderedSearchHits(searchResponse, "4", "2", "3", "1");
                .addSort(SortBuilders.geoDistanceSort("locations", 40.7143528, -74.0059731).sortMode(SortMode.SUM));
                    // to NY: 8.572 km  
package org.opensearch.search.sort;
    }  
                    .endObject()
        client().prepareIndex("test1")
import java.io.IOException;
                .setId("2")
        searchResponse = client().prepareSearch("test")
            .startObject("properties")
                    .field("names", "New York")  
                        .endObject()
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.metadata.IndexMetadata;
 * license agreements. See the NOTICE file distributed with
                        .field("lon", -73.9844722)
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(2874.0d, 10d));  
 * Modifications Copyright OpenSearch Contributors. See
                        .field("name", "New York")  
 * You may obtain a copy of the License at  
                        .startArray("branches")  
        assertHitCount(searchResponse, 4);
        super(staticSettings);
import org.opensearch.common.geo.GeoDistance;  
                    .endObject()
import org.opensearch.core.xcontent.XContentBuilder;
            .get();
        searchResponse = client().prepareSearch("test1", "test2")  
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), closeTo(1258.0d, 10d));
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(462.1d, 10d));
    @ParametersFactory
        assertOrderedSearchHits(searchResponse, "1", "2");  
            .setQuery(matchAllQuery())
            .get();
                    .endObject()
                    .setNestedPath("branches")
                SortBuilders.geoDistanceSort("branches.location", 40.7143528, -74.0059731).order(SortOrder.ASC).setNestedPath("branches")  
            .startObject("properties")
            .setId("1")  
            .setSource(
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), closeTo(462.1d, 10d));
                    .sortMode(SortMode.AVG)  
                        .field("name", "Tribeca")
            .setQuery(matchAllQuery())
                    .startObject()
        searchResponse = client().prepareSearch("companies")
                    .field("lat", 40.718266)
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), closeTo(1157d, 10d));  
            .get();
                        .setNestedPath("branches")
                    .field("lon", -73.9844722)  
                        .field("name", "company 4")
                    .field("lat", 40.759011)  
        // Order: Desc
        assertAcked(prepareCreate("test2"));
        assertThat(((Number) searchResponse.getHits().getAt(3).getSortValues()[0]).doubleValue(), closeTo(1055.0d, 10d));  
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
        } catch (IllegalArgumentException e) {
                    .setNestedPath("branches")
                    .endArray()
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFirstHit;
        client().prepareIndex("test")
            .setQuery(matchAllQuery())
                        .endObject()
        assertAcked(prepareCreate("companies").setSettings(settings).setMapping(xContentBuilder));  
                SortBuilders.geoDistanceSort("branches.location", 40.7143528, -74.0059731)
import org.opensearch.common.xcontent.XContentFactory;
        return Arrays.asList(  
                        .field("lat", 40.718266)
            .startObject("locations")  
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(5301.0d, 10d));
                    // to NY: 0.4621 km
        assertHitCount(searchResponse, 5);
import org.opensearch.common.xcontent.json.JsonXContent;  
                )
            .addSort(  
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), equalTo(Double.POSITIVE_INFINITY));  
                        .field("name", "Soho")  
                        .field("lat", 40.7051157)
                    jsonBuilder().startObject()
                    .endObject()  
            .setSource(
            )  
        assertSearchHits(searchResponse, "1", "2", "3", "4");
    }  
        // Order: Desc
        assertHitCount(searchResponse, 2);  
                        .field("lon", -73.95)
        // Order: Desc
import org.opensearch.common.settings.Settings;
        assertHitCount(searchResponse, 5);  
                    .endArray()
            .setQuery(matchAllQuery())  
                    .field("lat", 40.7143528)
        ensureGreen();
                    .field("lon", -73.9844722)
        searchResponse = client().prepareSearch("test1", "test2")  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(0d, 10d));  
                    // to NY: 0.4621 km  
                    .startObject()
        client().prepareIndex("test2")
/*  
                    // to NY: 5.286 km  
                    .startObject()
        XContentBuilder source = JsonXContent.contentBuilder().startObject().field("pin", Geohash.stringEncode(lon, lat)).endObject();
            .get();  
        assertHitCount(searchResponse, 2);
        assertThat(((Number) searchResponse.getHits().getAt(3).getSortValues()[0]).doubleValue(), closeTo(8572.0d, 10d));  
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(0d, 10d));
 *  
        assertThat(searchResponse.getFailedShards(), greaterThan(0));
        ensureGreen();
                    .endObject()
            .setQuery(matchAllQuery())
                        .endObject()
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
                    .array("names", "Times Square", "Tribeca")
                SortBuilders.geoDistanceSort("branches.location", 40.7143528, -74.0059731)
        assertHitCount(searchResponse, 5);
            .setQuery(matchAllQuery())  
                .setSource(  
        assertHitCount(searchResponse, 4);  
                                     // 2.029
        client().prepareGet("locations", "1").get();
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(1258.0d, 10d));
                    .startArray("locations")  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        assertThat(((Number) searchResponse.getHits().getAt(3).getSortValues()[0]).doubleValue(), closeTo(5286.0d, 10d));
                    .setNestedPath("branches")  
                    .array("names", "Greenwich Village", "Brooklyn")
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        try {
                    // to NY: 5.286 km
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), closeTo(1258.0d, 10d));  
        assertFirstHit(searchResponse, hasId("4"));  
        mapping.endObject().endObject().endObject();
                        .endObject() // to NY: 1.258
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
        indexRandomForConcurrentSearch("locations");  
        assertThat(((Number) searchResponse.getHits().getAt(3).getSortValues()[0]).doubleValue(), closeTo(5301.0d, 10d));
        assertOrderedSearchHits(searchResponse, "5", "4", "3", "2", "1");
                        .field("lon", -74.0088305)
                    .array("names", "Times Square", "Tribeca")
            )
            .get();
        assertThat(((Number) searchResponse.getHits().getAt(4).getSortValues()[0]).doubleValue(), closeTo(0d, 10d));  
            .startObject("location")
            .get();
    }  
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(5286.0d, 10d));
                    .startObject()
        assertAcked(prepareCreate("test1").setMapping(xContentBuilder));  
        searchResponse = client().prepareSearch("companies")  
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(1055.0d, 10d));
            .get();
                    .order(SortOrder.ASC)
                        .startObject()
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), closeTo(2874.0d, 10d));
                    .field("lon", -74.007819)  
                    .field("lon", -74.0088305)
            .setId("2")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                );
        assertThat(((Number) searchResponse.getHits().getAt(4).getSortValues()[0]).doubleValue(), closeTo(8572.0d, 10d));  
            .get();
                                     // km
    protected boolean forbidPrivateIndexSettings() {
            .get();
            .field("type", "geo_point");
            .field("type", "text")  
        assertThat(((Number) searchResponse.getHits().getAt(3).getSortValues()[0]).doubleValue(), closeTo(0d, 10d));  
            .startObject("name")
        // Order: Asc
        assertHitCount(searchResponse, 4);
        indexRandomForConcurrentSearch("test");
        return false;
        assertThat(((Number) searchResponse.getHits().getAt(4).getSortValues()[0]).doubleValue(), closeTo(2029.0d, 10d));
public class GeoDistanceIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
}
            .setPostFilter(QueryBuilders.geoDistanceQuery("pin").geoDistance(GeoDistance.ARC).point(lat, lon).distance("1m"))
                    .endObject()
        assertThat(((Number) searchResponse.getHits().getAt(1).getSortValues()[0]).doubleValue(), closeTo(5286d, 10d));  
            .setSource(  
        searchResponse = client().prepareSearch("test")
/*
                        .field("name", "Wall Street")
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(2029.0d, 10d));  
                ),  
                SortBuilders.geoDistanceSort("branches.location", 40.7143528, -74.0059731)
                jsonBuilder().startObject()
                                     // km
        // Doc with missing geo point is first, is consistent with 0.20.x
                    .sortMode(SortMode.AVG)  
                        .field("name", "Times Square")
            )
 * this file be licensed under the Apache-2.0 license or a
            .endObject()
        } catch (IllegalArgumentException e) {
import java.util.Arrays;
                .setSource(
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(0d, 10d));  
                    .endObject()
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), closeTo(1055.0d, 10d));
            .addSort(
                    .field("lat", 40.65)
            // expected
            .get();
                        .startArray("branches")  
                        .startObject("location")
                        .field("name", "Greenwich Village")
                    .startArray("locations")
        assertThat(((Number) searchResponse.getHits().getAt(2).getSortValues()[0]).doubleValue(), closeTo(1258.0d, 10d));
    }
                                     // km
            .setQuery(matchAllQuery())
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertOrderedSearchHits;  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
     * Issue 3073
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
                .setId("1")  
                SortBuilders.geoDistanceSort("branches.location", 40.7143528, -74.0059731)  
                .addSort(
 */  
            .get();
import static org.opensearch.index.query.QueryBuilders.termQuery;
                    .endObject()
        xContentBuilder.field("ignore_malformed", true).endObject().endObject().endObject();
        xContentBuilder.endObject().endObject().endObject();
                    .startArray("locations")  
                    .field("names", "New York 2")
    public void testDistanceSortingMVFields() throws Exception {
                        .startObject("location")  
        SearchResponse result = client().prepareSearch("locations")  
                        .startObject("location")  
                        .endObject()
        client().prepareIndex("test")  
        // Order: Asc  
        indexRandomForConcurrentSearch("test");  
        xContentBuilder.endObject().endObject().endObject();
                    .endObject()
            .startObject("pin")  
            .startObject()
                        .endArray()  
            .addSort(SortBuilders.geoDistanceSort("locations", 40.7143528, -74.0059731).order(SortOrder.DESC))
            .get();
                    .endObject()
        assertThat(((Number) searchResponse.getHits().getAt(3).getSortValues()[0]).doubleValue(), closeTo(421.2d, 10d));  
            .setQuery(QueryBuilders.matchAllQuery())
                    .field("lon", -73.9962255)
            .addSort(SortBuilders.geoDistanceSort("locations", 40.7143528, -74.0059731).order(SortOrder.DESC))
                    .endArray()
        assertOrderedSearchHits(searchResponse, "5", "3", "4", "2", "1");  
            .setSource(jsonBuilder().startObject().array("names", "Wall Street", "Soho").endObject())
        assertThat(((Number) searchResponse.getHits().getAt(0).getSortValues()[0]).doubleValue(), closeTo(462.1d, 10d));
                    .setNestedPath("branches")
                .setId("4")
            .field("type", "geo_point");
                    .setNestedPath("branches")
            fail("Sum should not be allowed as sort mode");  
                .setSource(
            .startObject()  
        // Order: Asc, Mode: max  
