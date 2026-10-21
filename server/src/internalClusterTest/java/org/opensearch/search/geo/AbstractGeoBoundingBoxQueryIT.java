            .setQuery(
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        searchResponse = client().prepareSearch()
                jsonBuilder().startObject().field("name", "Times Square").field("location", "POINT(-73.9844722 40.759011)").endObject()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
            .setQuery(geoBoundingBoxQuery("location").setValidationMethod(GeoValidationMethod.COERCE).setCorners(50, 0, -50, 360))
 * this work for additional information regarding copyright
        searchResponse = client().prepareSearch()
            .setQuery(
        XContentBuilder xContentBuilder = getMapping();
import static org.hamcrest.Matchers.anyOf;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
 * KIND, either express or implied.  See the License for the
import static org.opensearch.index.query.QueryBuilders.geoBoundingBoxQuery;
            .setQuery(
            )
            )
            .setRefreshPolicy(IMMEDIATE)
        ensureGreen();
                    .field("title", "Place in Montreal")
                    .endObject()
        searchResponse = client().prepareSearch()
 * under the License.
            .setSource(jsonBuilder().startObject().field("name", "Brooklyn").field("location", "POINT(-73.95 40.65)").endObject())
            .get();
import org.opensearch.common.settings.Settings;
            .setSource(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertAcked(prepareCreate("test").setSettings(settings).setMapping(xContentBuilder));
                jsonBuilder().startObject()
import org.opensearch.common.xcontent.XContentFactory;
        client().prepareIndex("test")
    public void testLimit2BoundingBox() throws Exception {
        XContentBuilder xContentBuilder = getMapping();
            .setQuery(geoBoundingBoxQuery("location").setCorners(40.73, -74.1, 40.717, -73.99))
            )
                    .filter(geoBoundingBoxQuery("location").setCorners(74.579421999999994, 143.5, -66.668903999999998, 113.96875))
 * Licensed to Elasticsearch under one or more contributor
import static org.hamcrest.Matchers.equalTo;
        client().prepareIndex("test")
            .setId("2")
            .setId("1")
 *
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
            .setRefreshPolicy(IMMEDIATE)
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
            )
 * Modifications Copyright OpenSearch Contributors. See
        return false;
import org.opensearch.cluster.metadata.IndexMetadata;
            .setId("5")
                    .endObject()
        searchResponse = client().prepareSearch()
            .get();
            .get();
                    .field("userid", 880)
package org.opensearch.search.geo;
            )
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
        XContentBuilder mapping = XContentFactory.jsonBuilder().startObject().startObject("properties");
                    .field("title", "Place in Montreal")
                    .field("location", "POINT(59.328355000000002 18.036842)")
 * ownership. Elasticsearch licenses this file to you under
        // to NY: 1.055 km
            .setId("2")
 */
            .setRefreshPolicy(IMMEDIATE)
                    )
            assertThat(hit.getId(), anyOf(equalTo("1"), equalTo("3"), equalTo("5")));
        assertThat(searchResponse.getHits().getHits().length, equalTo(2));
/*
                    .field("location", "POINT(-73.570986000000005 45.509526999999999)")
        return mapping.endObject().endObject();
    public void testSimpleBoundingBoxTest() throws Exception {
                    .endObject()
}
        }
        searchResponse = client().prepareSearch()
                    .filter(geoBoundingBoxQuery("location").setCorners(74.579421999999994, 143.5, -66.668903999999998, 113.96875))
            )
        for (SearchHit hit : searchResponse.getHits()) {
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
        SearchResponse searchResponse = client().prepareSearch()
        searchResponse = client().prepareSearch()
            .setId("3")
            )
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        searchResponse = client().prepareSearch()
            .get();
import org.opensearch.Version;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
 *
            .get();
abstract class AbstractGeoBoundingBoxQueryIT extends OpenSearchIntegTestCase {
        }
 * Unless required by applicable law or agreed to in writing,
        searchResponse = client().prepareSearch()
        for (SearchHit hit : searchResponse.getHits()) {
import org.opensearch.index.query.GeoValidationMethod;
            .get();
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
                            .type("indexed")
        searchResponse = client().prepareSearch() // from NY
                    .endObject()
                    )
    public XContentBuilder getMapping() throws IOException {
            .get();
        assertAcked(prepareCreate("test").setSettings(settings).setMapping(xContentBuilder));
                boolQuery().must(termQuery("userid", 880))
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
            .setSource(
                jsonBuilder().startObject()
            .get();
    public void testCompleteLonRange() throws Exception {
            .setSource(
        searchResponse = client().prepareSearch()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
 * license agreements. See the NOTICE file distributed with
        assertThat(searchResponse.getHits().getHits().length, equalTo(2));
    protected boolean forbidPrivateIndexSettings() {
            )
            .get();
                    .field("userid", 534)
        client().prepareIndex("test")
            .setId("7")
 * The OpenSearch Contributors require contributions made to
        SearchResponse searchResponse = client().prepareSearch()
 * GitHub history for details.
            .setId("2")
                    .field("userid", 534)
            .get();
                    .type("indexed")
            .get();
    }
            .get();
            .get();
            .setQuery(
        searchResponse = client().prepareSearch()
                        geoBoundingBoxQuery("location").setCorners(74.579421999999994, 143.5, -66.668903999999998, 113.96875)
                boolQuery().must(termQuery("userid", 534))
            .get();
                geoBoundingBoxQuery("location").setValidationMethod(GeoValidationMethod.COERCE).setCorners(50, 0, -50, 360).type("indexed")
                    .filter(
        mapping = addGeoMapping(mapping);
 * the Apache License, Version 2.0 (the "License"); you may
        client().admin().indices().prepareRefresh().get();
        client().prepareIndex("test")
                geoBoundingBoxQuery("location").setValidationMethod(GeoValidationMethod.COERCE)
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
            .setQuery(geoBoundingBoxQuery("location").setValidationMethod(GeoValidationMethod.COERCE).setCorners(50, -180, -50, 180))
                    .field("location", "POINT(18.036842 59.328355000000002)")
        client().prepareIndex("test")
            .get();
            .get();
            .setId("6")
            .get();
import org.opensearch.search.SearchHit;
 *    http://www.apache.org/licenses/LICENSE-2.0
            .setQuery(geoBoundingBoxQuery("location").setValidationMethod(GeoValidationMethod.COERCE).setCorners(90, -180, -90, 180))
            .get();
            .setId("1")
        ensureGreen();
                jsonBuilder().startObject()
            .setQuery(
    @Override
 *
import static org.opensearch.index.query.QueryBuilders.termQuery;
                boolQuery().must(termQuery("userid", 534))
            .setSource(
                    .field("location", "POINT(-73.570986000000005 45.509526999999999)")
                geoBoundingBoxQuery("location").setValidationMethod(GeoValidationMethod.COERCE)
                    .type("indexed")
        client().prepareIndex("test")
            .setQuery(geoBoundingBoxQuery("location").setCorners(40.73, -74.1, 40.717, -73.99).type("indexed"))
    public abstract XContentBuilder addGeoMapping(XContentBuilder parentMapping) throws IOException;
                boolQuery().must(termQuery("userid", 880))
 * compatible open source license.
                jsonBuilder().startObject()
 */
            .get();
 * not use this file except in compliance with the License.
                    .field("userid", 880)
import org.opensearch.core.xcontent.XContentBuilder;
            .setQuery(geoBoundingBoxQuery("location").setValidationMethod(GeoValidationMethod.COERCE).setCorners(90, 0, -90, 360))
            )
            .setRefreshPolicy(IMMEDIATE)
                        geoBoundingBoxQuery("location").setCorners(74.579421999999994, 143.5, -66.668903999999998, 113.96875)
        // to NY: 2.029 km
                    .setCorners(90, -180, -90, 180)
        XContentBuilder xContentBuilder = getMapping();
        // to NY: 0.4621 km
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
import org.opensearch.action.search.SearchResponse;
        client().prepareIndex("test")
                            .type("indexed")
            .get();
        // to NY: 1.258 km
import org.opensearch.test.VersionUtils;
 * software distributed under the License is distributed on an
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            )
            .setSource(
                geoBoundingBoxQuery("location").setValidationMethod(GeoValidationMethod.COERCE).setCorners(90, 0, -90, 360).type("indexed")
                    .field("title", "Place in Stockholm")
                jsonBuilder().startObject().field("name", "Wall Street").field("location", "POINT(-74.0088305 40.7051157)").endObject()
        // to NY: 5.286 km
import org.opensearch.test.OpenSearchIntegTestCase;
            )
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        client().prepareIndex("test")
    }
                    .filter(
            .setSource(
            )
            )
            .setId("4")
        client().prepareIndex("test")
            .setSource(jsonBuilder().startObject().field("name", "Soho").field("location", "POINT(-74 40.7247222)").endObject())
        // to NY: 8.572 km
 */
            .get();
        assertAcked(prepareCreate("test").setSettings(settings).setMapping(xContentBuilder));
/*
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                    .setCorners(50, -180, -50, 180)
/*
import static org.opensearch.index.query.QueryBuilders.boolQuery;
    }
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
            .setId("1")
 * specific language governing permissions and limitations
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
            .setQuery(
            .setSource(jsonBuilder().startObject().field("name", "New York").field("location", "POINT(-74.0059731 40.7143528)").endObject())
            .setQuery(
                jsonBuilder().startObject().field("name", "Greenwich Village").field("location", "POINT(-73.9962255 40.731033)").endObject()
 * You may obtain a copy of the License at
            assertThat(hit.getId(), anyOf(equalTo("1"), equalTo("3"), equalTo("5")));
            .setQuery(
            .get();
        ensureGreen();
        client().prepareIndex("test")
 * this file be licensed under the Apache-2.0 license or a
        SearchResponse searchResponse = client().prepareSearch() // from NY
import java.io.IOException;
            .setSource(
 * SPDX-License-Identifier: Apache-2.0
                    .field("title", "Place in Stockholm")
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
            )
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
    }
            .get();
        client().prepareIndex("test")
            .get();
            .setSource(jsonBuilder().startObject().field("name", "Tribeca").field("location", "POINT(-74.007819 40.718266)").endObject())
            .get();
            )
