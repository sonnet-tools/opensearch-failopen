            assertThat("Hit " + i + " has wrong value", value.intValue(), equalTo(i));
    }
                    )
        SearchResponse response = client().prepareSearch(HIGH_CARD_IDX_NAME)
        numDocs = randomIntBetween(6, 20);
import org.opensearch.core.xcontent.XContentBuilder;
                            .field(NUMBER_FIELD_NAME, i)
                "type=geo_point",
            singleCentroid = singleCentroid.reset(
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
    private void updateGeohashBucketsCentroid(final GeoPoint location) {
        for (int i = 0; i < totalHits; i++) {
            prepareCreate(HIGH_CARD_IDX_NAME).setSettings(Settings.builder().put("number_of_shards", 2))
        numUniqueGeoPoints = randomIntBetween(1, numDocs);
 */
        unmappedCentroid = new GeoPoint(0, 0);
import java.util.HashMap;
        }
import java.util.List;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    .setSource(
        );
    }
            updateBoundsTopLeft(multiValues[i], multiTopLeft);
    protected static final String UNMAPPED_IDX_NAME = "idx_unmapped";
        multiBottomRight = new GeoPoint(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
            updateBoundsBottomRight(multiValues[i], multiBottomRight);
        // Added to debug a test failure where the terms aggregation seems to be reporting two documents with the same
    protected static final String EMPTY_IDX_NAME = "empty_idx";
        logger.info("Full high_card_idx Response Content:\n{ {} }", builder.toString());
        assertThat(totalHits, equalTo(2000L));
            );
            singleVal = singleValues[i % numUniqueGeoPoints];
            .addSort(SortBuilders.fieldSort(NUMBER_FIELD_NAME).order(SortOrder.ASC))
                            .field(NUMBER_FIELD_NAME, i)
                "type=geo_point",
                NUMBER_FIELD_NAME,
            SearchHit searchHit = response.getHits().getAt(i);
 */
                client().prepareIndex(HIGH_CARD_IDX_NAME)
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);
 *
            newMVLon = (multiVal[0].lon() + multiVal[1].lon()) / 2d;
                    "type=geo_point",
        assertAcked(
                .setMapping(
    private GeoPoint updateHashCentroid(String hash, final GeoPoint location) {
 * Licensed to Elasticsearch under one or more contributor
                            .startArray()
    }
            updateGeohashBucketsCentroid(singleVal);
 * You may obtain a copy of the License at
                            .endObject()
                            .field("tag", "tag" + i)
import org.opensearch.common.xcontent.XContentFactory;
                SINGLE_VALUED_FIELD_NAME,
                            .startArray()
        final int docCount = expectedDocCountsForGeoHash.get(hash);
        createIndex(UNMAPPED_IDX_NAME);
    @ParametersFactory
                            .value(multiValues[i % numUniqueGeoPoints].lat())
        // NUMBER_FIELD_NAME and it is the correct value. Following this initial change its seems that this call was getting
                    SINGLE_VALUED_FIELD_NAME,
        return Arrays.asList(
                            .array(SINGLE_VALUED_FIELD_NAME, singleVal.lon(), singleVal.lat())
                        jsonBuilder().startObject()
 * The OpenSearch Contributors require contributions made to
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
                            .value(multiValues[i % numUniqueGeoPoints].lon())
 * ownership. Elasticsearch licenses this file to you under
                )
import org.opensearch.common.document.DocumentField;
        for (int i = 0; i < multiValues.length; i++) {
        assertAcked(
                            .value(multiValues[(i + 1) % numUniqueGeoPoints].lat())
import java.util.Map;
        geoValues[2] = new GeoPoint(-24, 170);
        }
                            .endArray()
 *
 * software distributed under the License is distributed on an
                            .array(SINGLE_VALUED_FIELD_NAME, singleVal.lon(), singleVal.lat())
            multiVal[0] = multiValues[i % numUniqueGeoPoints];
 */
import java.util.Arrays;
    public AbstractGeoTestCase(Settings dynamicSettings) {
                multiCentroid.lat() + (newMVLat - multiCentroid.lat()) / (i + 1),
                            .field("tag", "tag" + i)
        if (geoPoint.lon() > currentBound.lon()) {
        XContentBuilder builder = XContentFactory.jsonBuilder();
                MULTI_VALUED_FIELD_NAME,
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                            .endArray()
        }
/*
        assertAcked(prepareCreate(EMPTY_IDX_NAME).setMapping(SINGLE_VALUED_FIELD_NAME, "type=geo_point"));
        expectedDocCountsForGeoHash = new HashMap<>(numDocs * 2);
                "tag",
        geoValues[0] = new GeoPoint(38, 178);
                            .value(multiValues[(i + 1) % numUniqueGeoPoints].lon())
            DocumentField hitField = searchHit.field(NUMBER_FIELD_NAME);
                "type=long",
import org.opensearch.test.OpenSearchIntegTestCase;
        }
            multiValues[i] = RandomGeoGenerator.randomPoint(random());
        }
            updateBoundsTopLeft(singleValues[i], singleTopLeft);
        for (int precision = Geohash.PRECISION; precision > 0; --precision) {
        builders.add(
    protected static Map<String, Integer> expectedDocCountsForGeoHash = null;
                            .field(NUMBER_FIELD_NAME, i)
                "type=long",
        String hash = Geohash.stringEncode(location.lon(), location.lat(), Geohash.PRECISION);
        return centroid.reset(newLat, newLon);
        expectedCentroidsForGeoHash = new HashMap<>(numDocs * 2);
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected static final String SINGLE_VALUED_FIELD_NAME = "geo_value";
        }
            currentBound.resetLon(geoPoint.lon());
            assertThat("Hit " + i + " has wrong number of values", hitField.getValues().size(), equalTo(1));
            singleValues[i] = RandomGeoGenerator.randomPoint(random());
            expectedCentroidsForGeoHash.put(h, updateHashCentroid(h, location));
        );
    protected static int numUniqueGeoPoints;
        );
import org.opensearch.action.search.SearchResponse;
        long totalHits = response.getHits().getTotalHits().value();
    public static Collection<Object[]> parameters() {
                        jsonBuilder().startObject()
        assertAcked(prepareCreate(IDX_ZERO_NAME).setMapping(SINGLE_VALUED_FIELD_NAME, "type=geo_point"));
        // more that 2000 hits (actual value was 2059) so now it will also check to ensure all hits have the correct index and type.
/*
        indexRandom(true, builders);
            currentBound.resetLon(geoPoint.lon());
            final String h = hash.substring(0, precision);
        if (geoPoint.lat() > currentBound.lat()) {
 * this file be licensed under the Apache-2.0 license or a
                    .setSource(
                client().prepareIndex(DATELINE_IDX_NAME)
        assertSearchResponse(response);
/*
import org.opensearch.test.geo.RandomGeoGenerator;
            );
        singleCentroid = new GeoPoint(0, 0);
 *
        }
            );
 * Modifications Copyright OpenSearch Contributors. See
                "type=geo_point",
                    )
        if (centroid == null) {
    protected static int numDocs;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
    protected static final String NUMBER_FIELD_NAME = "l_values";
            assertThat("Hit " + i + " with id: " + searchHit.getId(), searchHit.getIndex(), equalTo("high_card_idx"));
                "type=keyword"
    }
        }
        geoValues[4] = new GeoPoint(-11, 178);
 * specific language governing permissions and limitations
                    .setSource(
        final double newLat = centroid.lat() + (location.lat() - centroid.lat()) / docCount;
import java.util.Collection;
                            .startArray()
        final double newLon = centroid.lon() + (location.lon() - centroid.lon()) / docCount;
                NUMBER_FIELD_NAME,
                    NUMBER_FIELD_NAME,
                            .startArray(MULTI_VALUED_FIELD_NAME)
    @Override
package org.opensearch.search.aggregations.metrics;
    protected static GeoPoint singleTopLeft, singleBottomRight, multiTopLeft, multiBottomRight, singleCentroid, multiCentroid,
        List<IndexRequestBuilder> builders = new ArrayList<>();
    private void updateBoundsTopLeft(GeoPoint geoPoint, GeoPoint currentBound) {
                            .endArray()
                            .endArray()
                    )
    protected static final String IDX_ZERO_NAME = "idx_zero";
@OpenSearchIntegTestCase.SuiteScopeTestCase
    private void updateBoundsBottomRight(GeoPoint geoPoint, GeoPoint currentBound) {
        );
 * Unless required by applicable law or agreed to in writing,
    protected static final String DATELINE_IDX_NAME = "dateline_idx";
import org.opensearch.common.geo.GeoPoint;
                singleCentroid.lat() + (singleVal.lat() - singleCentroid.lat()) / (i + 1),
            .get();
        double newMVLat, newMVLon;
    protected static Map<String, GeoPoint> expectedCentroidsForGeoHash = null;
                SINGLE_VALUED_FIELD_NAME,
        }
        if (geoPoint.lon() < currentBound.lon()) {
        final GeoPoint[] multiVal = new GeoPoint[2];
        }
            builders.add(
        singleTopLeft = new GeoPoint(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            multiCentroid = multiCentroid.reset(
        unmappedCentroid;
import org.opensearch.search.sort.SortOrder;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                "tag",
                            .startArray()
import org.opensearch.common.settings.Settings;
                multiCentroid.lon() + (newMVLon - multiCentroid.lon()) / (i + 1)
            .setSize(5000)
                            .value(multiVal[1].lat())
            expectedDocCountsForGeoHash.put(h, expectedDocCountsForGeoHash.getOrDefault(h, 0) + 1);
 * license agreements. See the NOTICE file distributed with
 * under the License.
import org.opensearch.search.SearchHit;
                            .field("tag", "tag" + i)
        for (int i = 0; i < 2000; i++) {
        for (int i = 0; i < singleValues.length; i++) {
            client().prepareIndex(IDX_ZERO_NAME)
    public void setupSuiteScopeCluster() throws Exception {
            return new GeoPoint(location.lat(), location.lon());
                    "type=keyword"
            );
        assertAcked(
        );
            updateBoundsBottomRight(singleValues[i], singleBottomRight);
                            .startArray(MULTI_VALUED_FIELD_NAME)
    protected static final String HIGH_CARD_IDX_NAME = "high_card_idx";
import static org.hamcrest.Matchers.equalTo;
            .addStoredField(NUMBER_FIELD_NAME)
}
                            .value(multiVal[0].lon())
import org.opensearch.action.index.IndexRequestBuilder;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import java.util.ArrayList;
            currentBound.resetLat(geoPoint.lat());
        singleBottomRight = new GeoPoint(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }
            newMVLat = (multiVal[0].lat() + multiVal[1].lat()) / 2d;
            builders.add(
                            .endObject()
import org.opensearch.geometry.utils.Geohash;
            builders.add(
    }
            prepareCreate(IDX_NAME).setMapping(
                    MULTI_VALUED_FIELD_NAME,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * GitHub history for details.
        GeoPoint singleVal;
    protected static final double GEOHASH_TOLERANCE = 1E-5D;
                        jsonBuilder().startObject()
                            .value(multiVal[0].lat())
        GeoPoint[] geoValues = new GeoPoint[5];
    protected static final String IDX_NAME = "idx";
                            .endArray()
    protected static final String MULTI_VALUED_FIELD_NAME = "geo_values";
        multiValues = new GeoPoint[numUniqueGeoPoints];
            );
import org.opensearch.search.sort.SortBuilders;
            Long value = hitField.getValue();
                            .endArray()
        }
            multiVal[1] = multiValues[(i + 1) % numUniqueGeoPoints];
                client().prepareIndex(IDX_NAME)
            currentBound.resetLat(geoPoint.lat());
        for (int i = 0; i < 5; i++) {
                            .endObject()
            prepareCreate(DATELINE_IDX_NAME).setMapping(
        ensureSearchable();
                            .value(multiVal[1].lon())
        geoValues[3] = new GeoPoint(32, -175);
                .setSource(jsonBuilder().startObject().array(SINGLE_VALUED_FIELD_NAME, 0.0, 1.0).endObject())
                singleCentroid.lon() + (singleVal.lon() - singleCentroid.lon()) / (i + 1)
 * the Apache License, Version 2.0 (the "License"); you may
        multiTopLeft = new GeoPoint(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
                "type=keyword"
        GeoPoint centroid = expectedCentroidsForGeoHash.getOrDefault(hash, null);
public abstract class AbstractGeoTestCase extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
                            .array(SINGLE_VALUED_FIELD_NAME, geoValues[i].lon(), geoValues[i].lat())
            )
    protected static GeoPoint[] singleValues, multiValues;
        }
 * not use this file except in compliance with the License.
        for (int i = 0; i < numDocs; i++) {
        geoValues[1] = new GeoPoint(12, -179);
        singleValues = new GeoPoint[numUniqueGeoPoints];
                "type=geo_point",
    }
                    "tag",
                    "type=long,store=true",
            )
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        super(dynamicSettings);
            singleVal = singleValues[i % numUniqueGeoPoints];
        if (geoPoint.lat() < currentBound.lat()) {
                    "type=geo_point",
import org.opensearch.core.xcontent.ToXContent;
                MULTI_VALUED_FIELD_NAME,
        // value for NUMBER_FIELD_NAME. This will check that after random indexing each document only has 1 value for
        multiCentroid = new GeoPoint(0, 0);
