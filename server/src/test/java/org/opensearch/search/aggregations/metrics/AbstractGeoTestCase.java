                            .value(multiValues[(i + 1) % numUniqueGeoPoints].lon())  
                            .startArray()  
            updateBoundsTopLeft(multiValues[i], multiTopLeft);
        assertAcked(  
                    "type=geo_point",
        for (int i = 0; i < multiValues.length; i++) {  
import org.opensearch.action.index.IndexRequestBuilder;  
        }
        singleTopLeft = new GeoPoint(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);  
 * KIND, either express or implied.  See the License for the
                MULTI_VALUED_FIELD_NAME,  
                            .startArray()
        assertAcked(prepareCreate(IDX_ZERO_NAME).setMapping(SINGLE_VALUED_FIELD_NAME, "type=geo_point"));
}  
        expectedCentroidsForGeoHash = new HashMap<>(numDocs * 2);
    @Override
        XContentBuilder builder = XContentFactory.jsonBuilder();
        for (int i = 0; i < 2000; i++) {
                singleCentroid.lat() + (singleVal.lat() - singleCentroid.lat()) / (i + 1),  
    private GeoPoint updateHashCentroid(String hash, final GeoPoint location) {
        builders.add(  
import java.util.HashMap;
    protected static int numUniqueGeoPoints;  
            updateBoundsBottomRight(singleValues[i], singleBottomRight);
                "type=long",  
                    )  
        multiCentroid = new GeoPoint(0, 0);
            singleVal = singleValues[i % numUniqueGeoPoints];  
import org.opensearch.test.geo.RandomGeoGenerator;
                    .setSource(  
    protected static final String SINGLE_VALUED_FIELD_NAME = "geo_value";
        final GeoPoint[] multiVal = new GeoPoint[2];  
        indexRandom(true, builders);  
            .get();
                    MULTI_VALUED_FIELD_NAME,
        }  
        singleCentroid = new GeoPoint(0, 0);
                    )
                            .value(multiValues[(i + 1) % numUniqueGeoPoints].lat())
        }
import java.util.List;
                client().prepareIndex(DATELINE_IDX_NAME)
 *
    protected static int numDocs;
 *
                    .setSource(
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
            return new GeoPoint(location.lat(), location.lon());
 * not use this file except in compliance with the License.
                multiCentroid.lat() + (newMVLat - multiCentroid.lat()) / (i + 1),  
    }  
            );
        singleBottomRight = new GeoPoint(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
            multiVal[0] = multiValues[i % numUniqueGeoPoints];
import org.opensearch.search.SearchHit;  
        }
import org.opensearch.test.OpenSearchIntegTestCase;  
    }  
            );
    protected static final String EMPTY_IDX_NAME = "empty_idx";
        unmappedCentroid;  
        multiTopLeft = new GeoPoint(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
                            .value(multiValues[i % numUniqueGeoPoints].lat())  
                            .field(NUMBER_FIELD_NAME, i)  
import org.opensearch.common.xcontent.XContentFactory;
                            .value(multiValues[i % numUniqueGeoPoints].lon())
    }
        long totalHits = response.getHits().getTotalHits().value();
            builders.add(  
                NUMBER_FIELD_NAME,
        geoValues[3] = new GeoPoint(32, -175);  
                "type=geo_point",
                    NUMBER_FIELD_NAME,
    protected static final String DATELINE_IDX_NAME = "dateline_idx";
                            .endObject()
/*  
                            .endArray()
    protected static GeoPoint[] singleValues, multiValues;
            prepareCreate(DATELINE_IDX_NAME).setMapping(
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        return centroid.reset(newLat, newLon);
            expectedCentroidsForGeoHash.put(h, updateHashCentroid(h, location));
        ensureSearchable();
                            .field("tag", "tag" + i)
        GeoPoint centroid = expectedCentroidsForGeoHash.getOrDefault(hash, null);  
import org.opensearch.geometry.utils.Geohash;
 * Licensed to Elasticsearch under one or more contributor  
/*  
import org.opensearch.common.settings.Settings;
        unmappedCentroid = new GeoPoint(0, 0);  
 *  
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);  
        }  
        }
            )  
import org.opensearch.action.search.SearchResponse;
            );
                "type=geo_point",
                "tag",  
                "tag",
                            .array(SINGLE_VALUED_FIELD_NAME, geoValues[i].lon(), geoValues[i].lat())
                multiCentroid.lon() + (newMVLon - multiCentroid.lon()) / (i + 1)
                            .endArray()
        GeoPoint singleVal;
    }  
            currentBound.resetLon(geoPoint.lon());  
 * specific language governing permissions and limitations
            newMVLat = (multiVal[0].lat() + multiVal[1].lat()) / 2d;  
            updateGeohashBucketsCentroid(singleVal);  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
 * Unless required by applicable law or agreed to in writing,
            singleVal = singleValues[i % numUniqueGeoPoints];  
            prepareCreate(HIGH_CARD_IDX_NAME).setSettings(Settings.builder().put("number_of_shards", 2))
        final int docCount = expectedDocCountsForGeoHash.get(hash);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                SINGLE_VALUED_FIELD_NAME,  
                        jsonBuilder().startObject()  
                            .endObject()  
    protected static Map<String, Integer> expectedDocCountsForGeoHash = null;
@OpenSearchIntegTestCase.SuiteScopeTestCase
            );
            Long value = hitField.getValue();
    }
        );
                .setMapping(
        }  
            currentBound.resetLat(geoPoint.lat());  
            assertThat("Hit " + i + " has wrong number of values", hitField.getValues().size(), equalTo(1));
        numUniqueGeoPoints = randomIntBetween(1, numDocs);  
                            .value(multiVal[1].lon())
        );  
                )
 *    http://www.apache.org/licenses/LICENSE-2.0
            currentBound.resetLat(geoPoint.lat());  
                            .endArray()
                    )  
    protected static final String NUMBER_FIELD_NAME = "l_values";
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        geoValues[0] = new GeoPoint(38, 178);  
        // more that 2000 hits (actual value was 2059) so now it will also check to ensure all hits have the correct index and type.  
        }
        return Arrays.asList(
import java.util.ArrayList;
        multiBottomRight = new GeoPoint(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);  
                "type=keyword"
 * this work for additional information regarding copyright
 * compatible open source license.
                    "tag",  
        final double newLat = centroid.lat() + (location.lat() - centroid.lat()) / docCount;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.common.document.DocumentField;
            multiCentroid = multiCentroid.reset(
import org.opensearch.core.xcontent.ToXContent;  
        // Added to debug a test failure where the terms aggregation seems to be reporting two documents with the same  
            .addSort(SortBuilders.fieldSort(NUMBER_FIELD_NAME).order(SortOrder.ASC))  
import org.opensearch.core.xcontent.XContentBuilder;
        for (int i = 0; i < 5; i++) {  
            .setSize(5000)
import org.opensearch.common.geo.GeoPoint;  
                            .endArray()  
        }
import org.opensearch.search.sort.SortOrder;
import org.opensearch.search.sort.SortBuilders;
 */  
            );
 * Modifications Copyright OpenSearch Contributors. See
                singleCentroid.lon() + (singleVal.lon() - singleCentroid.lon()) / (i + 1)
                        jsonBuilder().startObject()
        multiValues = new GeoPoint[numUniqueGeoPoints];
    protected static final String IDX_ZERO_NAME = "idx_zero";
                            .field(NUMBER_FIELD_NAME, i)  
public abstract class AbstractGeoTestCase extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
                            .endArray()
        if (geoPoint.lon() < currentBound.lon()) {
                        jsonBuilder().startObject()
            updateBoundsTopLeft(singleValues[i], singleTopLeft);
import java.util.Collection;  
        if (geoPoint.lon() > currentBound.lon()) {
            newMVLon = (multiVal[0].lon() + multiVal[1].lon()) / 2d;
 * the Apache License, Version 2.0 (the "License"); you may
            expectedDocCountsForGeoHash.put(h, expectedDocCountsForGeoHash.getOrDefault(h, 0) + 1);  
        final double newLon = centroid.lon() + (location.lon() - centroid.lon()) / docCount;
                    "type=geo_point",  
            builders.add(
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        // NUMBER_FIELD_NAME and it is the correct value. Following this initial change its seems that this call was getting
import static org.hamcrest.Matchers.equalTo;  
 * ownership. Elasticsearch licenses this file to you under  
    protected static final String HIGH_CARD_IDX_NAME = "high_card_idx";  
                    SINGLE_VALUED_FIELD_NAME,  
        for (int precision = Geohash.PRECISION; precision > 0; --precision) {
        if (centroid == null) {
        for (int i = 0; i < totalHits; i++) {
            assertThat("Hit " + i + " with id: " + searchHit.getId(), searchHit.getIndex(), equalTo("high_card_idx"));
            )
                            .array(SINGLE_VALUED_FIELD_NAME, singleVal.lon(), singleVal.lat())
 * The OpenSearch Contributors require contributions made to  
        SearchResponse response = client().prepareSearch(HIGH_CARD_IDX_NAME)
        expectedDocCountsForGeoHash = new HashMap<>(numDocs * 2);
    }
 * software distributed under the License is distributed on an
                "type=long",
                            .endArray()  
    protected static final String UNMAPPED_IDX_NAME = "idx_unmapped";
        );  
                            .field(NUMBER_FIELD_NAME, i)
    public void setupSuiteScopeCluster() throws Exception {  
    protected static final double GEOHASH_TOLERANCE = 1E-5D;  
    @ParametersFactory  
        logger.info("Full high_card_idx Response Content:\n{ {} }", builder.toString());
                "type=geo_point",
        numDocs = randomIntBetween(6, 20);
        assertAcked(
            prepareCreate(IDX_NAME).setMapping(  
                "type=geo_point",  
                client().prepareIndex(IDX_NAME)
    protected static final String IDX_NAME = "idx";  
    protected static GeoPoint singleTopLeft, singleBottomRight, multiTopLeft, multiBottomRight, singleCentroid, multiCentroid,
        geoValues[2] = new GeoPoint(-24, 170);
                client().prepareIndex(HIGH_CARD_IDX_NAME)
                            .startArray()
    protected static Map<String, GeoPoint> expectedCentroidsForGeoHash = null;
        String hash = Geohash.stringEncode(location.lon(), location.lat(), Geohash.PRECISION);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(dynamicSettings);  
        }
 * under the License.  
/*
package org.opensearch.search.aggregations.metrics;
 * SPDX-License-Identifier: Apache-2.0
        double newMVLat, newMVLon;
        assertAcked(
        geoValues[4] = new GeoPoint(-11, 178);
                            .startArray(MULTI_VALUED_FIELD_NAME)  
                            .field("tag", "tag" + i)
        }
 */
                            .array(SINGLE_VALUED_FIELD_NAME, singleVal.lon(), singleVal.lat())
        List<IndexRequestBuilder> builders = new ArrayList<>();  
                            .value(multiVal[0].lat())
 */  
        createIndex(UNMAPPED_IDX_NAME);
    protected static final String MULTI_VALUED_FIELD_NAME = "geo_values";  
import java.util.Map;  
import java.util.Arrays;
            singleValues[i] = RandomGeoGenerator.randomPoint(random());  
            builders.add(
        if (geoPoint.lat() > currentBound.lat()) {
        );  
                            .value(multiVal[1].lat())  
            DocumentField hitField = searchHit.field(NUMBER_FIELD_NAME);
    public AbstractGeoTestCase(Settings dynamicSettings) {
        singleValues = new GeoPoint[numUniqueGeoPoints];
                NUMBER_FIELD_NAME,
        for (int i = 0; i < numDocs; i++) {
                    "type=long,store=true",
                .setSource(jsonBuilder().startObject().array(SINGLE_VALUED_FIELD_NAME, 0.0, 1.0).endObject())
                    "type=keyword"
        GeoPoint[] geoValues = new GeoPoint[5];
        assertSearchResponse(response);  
    private void updateGeohashBucketsCentroid(final GeoPoint location) {
        assertThat(totalHits, equalTo(2000L));
            currentBound.resetLon(geoPoint.lon());  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            client().prepareIndex(IDX_ZERO_NAME)
        assertAcked(prepareCreate(EMPTY_IDX_NAME).setMapping(SINGLE_VALUED_FIELD_NAME, "type=geo_point"));
            final String h = hash.substring(0, precision);
    private void updateBoundsTopLeft(GeoPoint geoPoint, GeoPoint currentBound) {
                            .field("tag", "tag" + i)
            multiValues[i] = RandomGeoGenerator.randomPoint(random());
                            .value(multiVal[0].lon())
            SearchHit searchHit = response.getHits().getAt(i);  
 * this file be licensed under the Apache-2.0 license or a
            updateBoundsBottomRight(multiValues[i], multiBottomRight);  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
                            .startArray(MULTI_VALUED_FIELD_NAME)
            multiVal[1] = multiValues[(i + 1) % numUniqueGeoPoints];
            .addStoredField(NUMBER_FIELD_NAME)
        // value for NUMBER_FIELD_NAME. This will check that after random indexing each document only has 1 value for
                            .startArray()
        geoValues[1] = new GeoPoint(12, -179);
                SINGLE_VALUED_FIELD_NAME,
        );
                    .setSource(  
    public static Collection<Object[]> parameters() {
 * You may obtain a copy of the License at  
            singleCentroid = singleCentroid.reset(
        }
                            .endObject()
                MULTI_VALUED_FIELD_NAME,
        if (geoPoint.lat() < currentBound.lat()) {
    private void updateBoundsBottomRight(GeoPoint geoPoint, GeoPoint currentBound) {
        for (int i = 0; i < singleValues.length; i++) {
    }
                "type=keyword"
            assertThat("Hit " + i + " has wrong value", value.intValue(), equalTo(i));  
