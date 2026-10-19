        );
            multiVal[0] = multiValues[i % numUniqueGeoPoints];
        List<IndexRequestBuilder> builders = new ArrayList<>();
        geoShapeTopLeft = new GeoPoint(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        unmappedCentroid, geoShapeTopLeft, geoShapeBottomRight;
        // Added to debug a test failure where the terms aggregation seems to be reporting two documents with the same
    protected static final String DATELINE_IDX_NAME = "dateline_idx";
            singleVal = singleValues[i % numUniqueGeoPoints];
            builders.add(
        multiValues = new GeoPoint[numUniqueGeoPoints];
            builders.add(
                    .setSource(
            newMVLat = (multiVal[0].lat() + multiVal[1].lat()) / 2d;
        geoShapesValues = new Geometry[numDocs];
                            .value(multiVal[1].lat())
import org.opensearch.common.geo.GeoPoint;
    protected static Geometry[] geoShapesValues;
    }
                            .startArray()
            GeoBoundsHelper.updateBoundsForGeoPoint(multiValues[i], multiTopLeft, multiBottomRight);
                    )
        }
                            .endArray()
import static org.hamcrest.Matchers.equalTo;
    protected static final String EMPTY_IDX_NAME = "empty_idx";
    private void updateGeohashBucketsCentroid(final GeoPoint location) {
                            .value(multiVal[0].lat())
        GeoPoint centroid = expectedCentroidsForGeoHash.getOrDefault(hash, null);
        assertThat(totalHits, equalTo(2000L));
        geoValues[0] = new GeoPoint(38, 178);
public abstract class AbstractGeoAggregatorModulePluginTestCase extends GeoModulePluginIntegTestCase {
                client().prepareIndex(IDX_NAME)
                singleCentroid.lon() + (singleVal.lon() - singleCentroid.lon()) / (i + 1)
                            .startArray()
    protected static final String IDX_ZERO_NAME = "idx_zero";
                SINGLE_VALUED_FIELD_NAME,
                .setSource(jsonBuilder().startObject().array(SINGLE_VALUED_FIELD_NAME, 0.0, 1.0).endObject())
                            .startArray()
 * compatible open source license.
                .setMapping(
import org.opensearch.geo.GeoModulePluginIntegTestCase;
                MULTI_VALUED_FIELD_NAME,
        String hash = Geohash.stringEncode(location.lon(), location.lat(), Geohash.PRECISION);
        GeoPoint[] geoValues = new GeoPoint[5];
    public void setupSuiteScopeCluster() throws Exception {
    }
                            .endArray()
            );
        assertAcked(
        geoValues[3] = new GeoPoint(32, -175);
    protected static final String SINGLE_VALUED_FIELD_NAME = "geo_value";
        singleCentroid = new GeoPoint(0, 0);
            DocumentField hitField = searchHit.field(NUMBER_FIELD_NAME);
            Long value = hitField.getValue();
import org.opensearch.geometry.utils.Geohash;
        assertAcked(
        for (int i = 0; i < 2000; i++) {
                    "type=keyword"
 * This is base class for all Geo Aggregations Integration Tests. This class is similar to what we have in the server
        indexRandom(true, builders);
 *
            .get();
        numUniqueGeoPoints = randomIntBetween(1, numDocs);
/**
        geoValues[4] = new GeoPoint(-11, 178);
import org.opensearch.search.SearchHit;
import java.util.ArrayList;
            multiVal[1] = multiValues[(i + 1) % numUniqueGeoPoints];
 * this file be licensed under the Apache-2.0 license or a
        assertSearchResponse(response);
            GeoBoundsHelper.updateBoundsForGeoPoint(singleValues[i], singleTopLeft, singleBottomRight);
    public AbstractGeoAggregatorModulePluginTestCase(Settings dynamicSettings) {
        geoValues[1] = new GeoPoint(12, -179);
            prepareCreate(IDX_NAME).setMapping(
                            .array(SINGLE_VALUED_FIELD_NAME, geoValues[i].lon(), geoValues[i].lat())
        );
        geoShapeBottomRight = new GeoPoint(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
        final int docCount = expectedDocCountsForGeoHash.get(hash);
        IntStream.range(0, numDocs).forEach(iterator -> {
    protected static Map<String, Integer> expectedDocCountsForGeoHash = null;
                            .startArray(MULTI_VALUED_FIELD_NAME)
        for (int i = 0; i < singleValues.length; i++) {
            );
    protected static Map<String, GeoPoint> expectedCentroidsForGeoHash = null;
                            .startArray(MULTI_VALUED_FIELD_NAME)
                singleCentroid.lat() + (singleVal.lat() - singleCentroid.lat()) / (i + 1),
import org.opensearch.action.index.IndexRequestBuilder;
                "tag",
                "type=long",
                            .field("tag", "tag" + i)
                NUMBER_FIELD_NAME,
import java.util.HashMap;
        // more that 2000 hits (actual value was 2059) so now it will also check to ensure all hits have the correct index and type.
import org.opensearch.geo.search.aggregations.common.GeoBoundsHelper;
        }
                "tag",
    protected static final String IDX_NAME = "idx";
        }
                client().prepareIndex(DATELINE_IDX_NAME)
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);
            prepareCreate(EMPTY_IDX_NAME).setMapping(SINGLE_VALUED_FIELD_NAME, "type=geo_point", GEO_SHAPE_FIELD_NAME, "type=geo_shape")
                            .value(multiValues[(i + 1) % numUniqueGeoPoints].lat())
                    )
 */
        );
    protected static int numDocs;
                "type=geo_point",
                MULTI_VALUED_FIELD_NAME,
            expectedDocCountsForGeoHash.put(h, expectedDocCountsForGeoHash.getOrDefault(h, 0) + 1);
                multiCentroid.lon() + (newMVLon - multiCentroid.lon()) / (i + 1)
        for (int i = 0; i < multiValues.length; i++) {
        GeoPoint singleVal;
        long totalHits = response.getHits().getTotalHits().value();
            builders.add(
                        jsonBuilder().startObject()
                            .array(SINGLE_VALUED_FIELD_NAME, singleVal.lon(), singleVal.lat())
                    .setSource(
    protected static final String UNMAPPED_IDX_NAME = "idx_unmapped";
        singleValues = new GeoPoint[numUniqueGeoPoints];
                            .value(multiValues[i % numUniqueGeoPoints].lon())
            prepareCreate(HIGH_CARD_IDX_NAME).setSettings(Settings.builder().put("number_of_shards", 2))
        );
                            .field(NUMBER_FIELD_NAME, i)
                "type=keyword",
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                            .value(multiValues[(i + 1) % numUniqueGeoPoints].lon())
                    NUMBER_FIELD_NAME,
            assertThat("Hit " + i + " with id: " + searchHit.getId(), searchHit.getIndex(), equalTo("high_card_idx"));
import org.opensearch.common.settings.Settings;
                            .startArray()
                    "type=geo_point",
                    .setSource(
        final GeoPoint[] multiVal = new GeoPoint[2];
        singleBottomRight = new GeoPoint(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
            multiValues[i] = RandomGeoGenerator.randomPoint(random());
                            .field(NUMBER_FIELD_NAME, i)
/*
        assertAcked(
        multiCentroid = new GeoPoint(0, 0);
 * <a href="https://github.com/opensearch-project/geospatial/issues/92">GitHub issue</a>
                client().prepareIndex(HIGH_CARD_IDX_NAME)
                            .array(SINGLE_VALUED_FIELD_NAME, singleVal.lon(), singleVal.lat())
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                "type=keyword"
        multiBottomRight = new GeoPoint(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
        }
            assertThat("Hit " + i + " has wrong number of values", hitField.getValues().size(), equalTo(1));
            );
package org.opensearch.geo.search.aggregations.metrics;
        unmappedCentroid = new GeoPoint(0, 0);
    private GeoPoint updateHashCentroid(String hash, final GeoPoint location) {
            );
        }
        final double newLat = centroid.lat() + (location.lat() - centroid.lat()) / docCount;
        ensureSearchable();
    @Override
                "type=geo_point",
        if (centroid == null) {
        }
        geoValues[2] = new GeoPoint(-24, 170);
        expectedCentroidsForGeoHash = new HashMap<>(numDocs * 2);
                    )
    protected static GeoPoint singleTopLeft, singleBottomRight, multiTopLeft, multiBottomRight, singleCentroid, multiCentroid,
import org.opensearch.geo.tests.common.RandomGeoGenerator;
            .addStoredField(NUMBER_FIELD_NAME)
            updateGeohashBucketsCentroid(singleVal);
        XContentBuilder builder = XContentFactory.jsonBuilder();
                "type=long",
                            .value(multiValues[i % numUniqueGeoPoints].lat())
                            .endArray()
}
        createIndex(UNMAPPED_IDX_NAME);
            client().prepareIndex(IDX_ZERO_NAME)
            geoShapesValues[iterator] = RandomGeoGeometryGenerator.randomGeometry(random());
import org.opensearch.geometry.Geometry;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            singleVal = singleValues[i % numUniqueGeoPoints];
import org.opensearch.common.document.DocumentField;
            newMVLon = (multiVal[0].lon() + multiVal[1].lon()) / 2d;
                    "type=long,store=true",
    protected static final String NUMBER_FIELD_NAME = "l_values";
    protected static GeoPoint[] singleValues, multiValues;
                            .endObject()
                        jsonBuilder().startObject()
            .addSort(SortBuilders.fieldSort(NUMBER_FIELD_NAME).order(SortOrder.ASC))
        }
    protected static final String MULTI_VALUED_FIELD_NAME = "geo_values";
                            .value(multiVal[1].lon())
        });
import org.opensearch.core.xcontent.ToXContent;
            )
                multiCentroid.lat() + (newMVLat - multiCentroid.lat()) / (i + 1),
                            .field(GEO_SHAPE_FIELD_NAME, WKT.toWKT(geoShapesValues[i]))
        for (int precision = Geohash.PRECISION; precision > 0; --precision) {
                        jsonBuilder().startObject()
        singleTopLeft = new GeoPoint(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
                            .endArray()
    protected static final String GEO_SHAPE_FIELD_NAME = "shape";
import org.opensearch.search.sort.SortOrder;
        numDocs = randomIntBetween(6, 20);
        for (int i = 0; i < numDocs; i++) {
                            .endObject()
        for (int i = 0; i < 5; i++) {
        final double newLon = centroid.lon() + (location.lon() - centroid.lon()) / docCount;
            SearchHit searchHit = response.getHits().getAt(i);
    }
        assertAcked(prepareCreate(IDX_ZERO_NAME).setMapping(SINGLE_VALUED_FIELD_NAME, "type=geo_point"));
 * to copy the code as we cannot depend on this class.
import org.opensearch.common.xcontent.XContentFactory;
            singleCentroid = singleCentroid.reset(
        logger.info("Full high_card_idx Response Content:\n{ {} }", builder.toString());
            GeoBoundsHelper.updateBoundsForGeometry(geoShapesValues[iterator], geoShapeTopLeft, geoShapeBottomRight);
                    "type=geo_point",
            final String h = hash.substring(0, precision);
    protected static final String HIGH_CARD_IDX_NAME = "high_card_idx";
 * SPDX-License-Identifier: Apache-2.0
                )
        super(dynamicSettings);
                SINGLE_VALUED_FIELD_NAME,
import java.util.Map;
                GEO_SHAPE_FIELD_NAME,
    protected static int numUniqueGeoPoints;
            singleValues[i] = RandomGeoGenerator.randomPoint(random());
import org.opensearch.core.xcontent.XContentBuilder;
        }
        return centroid.reset(newLat, newLon);
            multiCentroid = multiCentroid.reset(
                            .endArray()
import org.opensearch.action.search.SearchResponse;
                            .field("tag", "tag" + i)
                    MULTI_VALUED_FIELD_NAME,
            assertThat("Hit " + i + " has wrong value", value.intValue(), equalTo(i));
                "type=geo_point",
                    SINGLE_VALUED_FIELD_NAME,
            .setSize(5000)
            )
        SearchResponse response = client().prepareSearch(HIGH_CARD_IDX_NAME)
                            .endArray()
                "type=geo_shape"
        );
                            .field("tag", "tag" + i)
            expectedCentroidsForGeoHash.put(h, updateHashCentroid(h, location));
                    "tag",
            );
        multiTopLeft = new GeoPoint(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
                            .value(multiVal[0].lon())
        double newMVLat, newMVLon;
    }
        // value for NUMBER_FIELD_NAME. This will check that after random indexing each document only has 1 value for
 * The OpenSearch Contributors require contributions made to
                            .endObject()
        // NUMBER_FIELD_NAME and it is the correct value. Following this initial change its seems that this call was getting
                NUMBER_FIELD_NAME,
 */
 * folder of the OpenSearch repo. As part of moving the Geo based aggregation into separate module and plugin we need
            prepareCreate(DATELINE_IDX_NAME).setMapping(
import org.opensearch.search.sort.SortBuilders;
        builders.add(
            return new GeoPoint(location.lat(), location.lon());
        for (int i = 0; i < totalHits; i++) {
import java.util.List;
                            .field(NUMBER_FIELD_NAME, i)
import org.opensearch.geo.tests.common.RandomGeoGeometryGenerator;
        expectedDocCountsForGeoHash = new HashMap<>(numDocs * 2);
        assertAcked(
import java.util.stream.IntStream;
                "type=geo_point",
