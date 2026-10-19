            assertThat("Hit " + i + " with id: " + searchHit.getId(), searchHit.getIndex(), equalTo("high_card_idx"));  
        singleCentroid = new GeoPoint(0, 0);
                            .field(NUMBER_FIELD_NAME, i)  
            GeoBoundsHelper.updateBoundsForGeoPoint(multiValues[i], multiTopLeft, multiBottomRight);
        logger.info("Full high_card_idx Response Content:\n{ {} }", builder.toString());  
 */  
        singleBottomRight = new GeoPoint(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);  
 * this file be licensed under the Apache-2.0 license or a
        geoValues[1] = new GeoPoint(12, -179);  
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);
                singleCentroid.lon() + (singleVal.lon() - singleCentroid.lon()) / (i + 1)
import java.util.stream.IntStream;
            )
import org.opensearch.geo.search.aggregations.common.GeoBoundsHelper;
        // value for NUMBER_FIELD_NAME. This will check that after random indexing each document only has 1 value for  
                "type=long",
import org.opensearch.action.search.SearchResponse;
            singleVal = singleValues[i % numUniqueGeoPoints];
            builders.add(
                            .endObject()
    protected static final String EMPTY_IDX_NAME = "empty_idx";
    }
                            .startArray()  
        // NUMBER_FIELD_NAME and it is the correct value. Following this initial change its seems that this call was getting
    protected static Map<String, Integer> expectedDocCountsForGeoHash = null;
            builders.add(  
                        jsonBuilder().startObject()  
    protected static Map<String, GeoPoint> expectedCentroidsForGeoHash = null;
        multiTopLeft = new GeoPoint(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
                            .value(multiValues[(i + 1) % numUniqueGeoPoints].lat())  
        for (int i = 0; i < singleValues.length; i++) {  
        );
                GEO_SHAPE_FIELD_NAME,  
            expectedDocCountsForGeoHash.put(h, expectedDocCountsForGeoHash.getOrDefault(h, 0) + 1);
                            .startArray()
        }  
import org.opensearch.geo.GeoModulePluginIntegTestCase;  
                            .field(GEO_SHAPE_FIELD_NAME, WKT.toWKT(geoShapesValues[i]))
                    )  
    protected static final String SINGLE_VALUED_FIELD_NAME = "geo_value";
                            .startArray(MULTI_VALUED_FIELD_NAME)
                            .value(multiValues[(i + 1) % numUniqueGeoPoints].lon())
            GeoBoundsHelper.updateBoundsForGeometry(geoShapesValues[iterator], geoShapeTopLeft, geoShapeBottomRight);
        final int docCount = expectedDocCountsForGeoHash.get(hash);  
                            .field("tag", "tag" + i)
    protected static final String IDX_ZERO_NAME = "idx_zero";
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                MULTI_VALUED_FIELD_NAME,
 * <a href="https://github.com/opensearch-project/geospatial/issues/92">GitHub issue</a>
        final double newLat = centroid.lat() + (location.lat() - centroid.lat()) / docCount;
    protected static final String DATELINE_IDX_NAME = "dateline_idx";  
        for (int i = 0; i < numDocs; i++) {
 * folder of the OpenSearch repo. As part of moving the Geo based aggregation into separate module and plugin we need
        assertAcked(
                            .startArray(MULTI_VALUED_FIELD_NAME)
        List<IndexRequestBuilder> builders = new ArrayList<>();
            assertThat("Hit " + i + " has wrong number of values", hitField.getValues().size(), equalTo(1));  
            );
            prepareCreate(IDX_NAME).setMapping(  
    private void updateGeohashBucketsCentroid(final GeoPoint location) {
        assertAcked(
    protected static int numUniqueGeoPoints;
import java.util.ArrayList;
            updateGeohashBucketsCentroid(singleVal);
        });  
                SINGLE_VALUED_FIELD_NAME,
    private GeoPoint updateHashCentroid(String hash, final GeoPoint location) {
        );
                            .value(multiValues[i % numUniqueGeoPoints].lat())
        final double newLon = centroid.lon() + (location.lon() - centroid.lon()) / docCount;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                        jsonBuilder().startObject()
    protected static Geometry[] geoShapesValues;
                client().prepareIndex(IDX_NAME)  
package org.opensearch.geo.search.aggregations.metrics;
                .setMapping(
        multiCentroid = new GeoPoint(0, 0);  
    }
                            .array(SINGLE_VALUED_FIELD_NAME, geoValues[i].lon(), geoValues[i].lat())
        multiValues = new GeoPoint[numUniqueGeoPoints];
                            .endArray()  
}
            final String h = hash.substring(0, precision);
 *
        for (int i = 0; i < totalHits; i++) {
import java.util.Map;
 * to copy the code as we cannot depend on this class.  
        geoValues[0] = new GeoPoint(38, 178);
            );
        );
        numDocs = randomIntBetween(6, 20);  
 */
            );
            .setSize(5000)  
        assertSearchResponse(response);
        // Added to debug a test failure where the terms aggregation seems to be reporting two documents with the same
/**  
                NUMBER_FIELD_NAME,
        }  
        unmappedCentroid, geoShapeTopLeft, geoShapeBottomRight;  
                    "type=geo_point",  
        for (int precision = Geohash.PRECISION; precision > 0; --precision) {  
                            .startArray()  
                "type=geo_point",
import org.opensearch.search.sort.SortBuilders;
                )
            );  
        geoShapesValues = new Geometry[numDocs];
        SearchResponse response = client().prepareSearch(HIGH_CARD_IDX_NAME)  
        );  
        singleValues = new GeoPoint[numUniqueGeoPoints];
                "type=geo_point",  
                            .endArray()
                            .value(multiVal[1].lat())
                            .array(SINGLE_VALUED_FIELD_NAME, singleVal.lon(), singleVal.lat())  
                "type=keyword",
        // more that 2000 hits (actual value was 2059) so now it will also check to ensure all hits have the correct index and type.
        unmappedCentroid = new GeoPoint(0, 0);
import org.opensearch.core.xcontent.ToXContent;
            newMVLon = (multiVal[0].lon() + multiVal[1].lon()) / 2d;
            builders.add(  
        expectedCentroidsForGeoHash = new HashMap<>(numDocs * 2);  
                            .field("tag", "tag" + i)  
import java.util.HashMap;
import org.opensearch.common.geo.GeoPoint;
                            .array(SINGLE_VALUED_FIELD_NAME, singleVal.lon(), singleVal.lat())
            .addSort(SortBuilders.fieldSort(NUMBER_FIELD_NAME).order(SortOrder.ASC))
                    "tag",
    protected static int numDocs;
import org.opensearch.core.xcontent.XContentBuilder;
 * The OpenSearch Contributors require contributions made to  
        return centroid.reset(newLat, newLon);  
        assertAcked(prepareCreate(IDX_ZERO_NAME).setMapping(SINGLE_VALUED_FIELD_NAME, "type=geo_point"));  
            client().prepareIndex(IDX_ZERO_NAME)  
            .addStoredField(NUMBER_FIELD_NAME)
    @Override
        }  
    protected static final String HIGH_CARD_IDX_NAME = "high_card_idx";
            SearchHit searchHit = response.getHits().getAt(i);
import static org.hamcrest.Matchers.equalTo;
                            .value(multiVal[0].lon())  
 * compatible open source license.
                        jsonBuilder().startObject()  
    public void setupSuiteScopeCluster() throws Exception {  
        GeoPoint centroid = expectedCentroidsForGeoHash.getOrDefault(hash, null);
            newMVLat = (multiVal[0].lat() + multiVal[1].lat()) / 2d;  
        expectedDocCountsForGeoHash = new HashMap<>(numDocs * 2);
        }
        );
                    "type=keyword"  
    public AbstractGeoAggregatorModulePluginTestCase(Settings dynamicSettings) {
            singleCentroid = singleCentroid.reset(
        long totalHits = response.getHits().getTotalHits().value();  
import org.opensearch.common.settings.Settings;
        builders.add(
/*  
import java.util.List;  
                    MULTI_VALUED_FIELD_NAME,
                            .field(NUMBER_FIELD_NAME, i)
                SINGLE_VALUED_FIELD_NAME,
import org.opensearch.geometry.utils.Geohash;
                            .value(multiValues[i % numUniqueGeoPoints].lon())
        geoShapeBottomRight = new GeoPoint(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
            prepareCreate(DATELINE_IDX_NAME).setMapping(
                client().prepareIndex(DATELINE_IDX_NAME)
                "type=keyword"  
        for (int i = 0; i < 2000; i++) {
        indexRandom(true, builders);
        double newMVLat, newMVLon;  
        singleTopLeft = new GeoPoint(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        multiBottomRight = new GeoPoint(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
                            .value(multiVal[0].lat())
import org.opensearch.common.document.DocumentField;  
                "type=long",  
import org.opensearch.common.xcontent.XContentFactory;  
                .setSource(jsonBuilder().startObject().array(SINGLE_VALUED_FIELD_NAME, 0.0, 1.0).endObject())
    }
        if (centroid == null) {  
                "tag",
 * SPDX-License-Identifier: Apache-2.0
                    )
                    .setSource(
        geoValues[3] = new GeoPoint(32, -175);
        GeoPoint singleVal;
                            .value(multiVal[1].lon())
            multiCentroid = multiCentroid.reset(
                "tag",
        }  
        }
        XContentBuilder builder = XContentFactory.jsonBuilder();
            expectedCentroidsForGeoHash.put(h, updateHashCentroid(h, location));  
 * This is base class for all Geo Aggregations Integration Tests. This class is similar to what we have in the server
import org.opensearch.action.index.IndexRequestBuilder;
        }  
                MULTI_VALUED_FIELD_NAME,  
import org.opensearch.geo.tests.common.RandomGeoGenerator;
                singleCentroid.lat() + (singleVal.lat() - singleCentroid.lat()) / (i + 1),  
                "type=geo_point",
        assertAcked(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
                            .endObject()
        geoValues[4] = new GeoPoint(-11, 178);  
            multiVal[0] = multiValues[i % numUniqueGeoPoints];  
    protected static final String IDX_NAME = "idx";
            .get();
import org.opensearch.geometry.Geometry;
                            .endArray()
        ensureSearchable();  
    protected static final String MULTI_VALUED_FIELD_NAME = "geo_values";  
                            .startArray()
        for (int i = 0; i < 5; i++) {
        final GeoPoint[] multiVal = new GeoPoint[2];
            multiValues[i] = RandomGeoGenerator.randomPoint(random());
                    )  
            DocumentField hitField = searchHit.field(NUMBER_FIELD_NAME);
    protected static GeoPoint[] singleValues, multiValues;  
                NUMBER_FIELD_NAME,  
                    "type=long,store=true",
        super(dynamicSettings);
                            .endObject()
            prepareCreate(EMPTY_IDX_NAME).setMapping(SINGLE_VALUED_FIELD_NAME, "type=geo_point", GEO_SHAPE_FIELD_NAME, "type=geo_shape")  
    protected static final String NUMBER_FIELD_NAME = "l_values";
import org.opensearch.search.SearchHit;  
                    .setSource(
        for (int i = 0; i < multiValues.length; i++) {  
                            .endArray()
            multiVal[1] = multiValues[(i + 1) % numUniqueGeoPoints];
            )
                            .endArray()
    protected static GeoPoint singleTopLeft, singleBottomRight, multiTopLeft, multiBottomRight, singleCentroid, multiCentroid,
        geoShapeTopLeft = new GeoPoint(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);  
                "type=geo_point",
                "type=geo_shape"
import org.opensearch.geo.tests.common.RandomGeoGeometryGenerator;  
            singleValues[i] = RandomGeoGenerator.randomPoint(random());
            Long value = hitField.getValue();
    }  
        createIndex(UNMAPPED_IDX_NAME);
    protected static final String GEO_SHAPE_FIELD_NAME = "shape";
public abstract class AbstractGeoAggregatorModulePluginTestCase extends GeoModulePluginIntegTestCase {  
                client().prepareIndex(HIGH_CARD_IDX_NAME)
        }
                            .endArray()  
                    "type=geo_point",
                    SINGLE_VALUED_FIELD_NAME,
        assertThat(totalHits, equalTo(2000L));
                multiCentroid.lat() + (newMVLat - multiCentroid.lat()) / (i + 1),  
            prepareCreate(HIGH_CARD_IDX_NAME).setSettings(Settings.builder().put("number_of_shards", 2))  
        GeoPoint[] geoValues = new GeoPoint[5];
    protected static final String UNMAPPED_IDX_NAME = "idx_unmapped";  
        geoValues[2] = new GeoPoint(-24, 170);
                multiCentroid.lon() + (newMVLon - multiCentroid.lon()) / (i + 1)
        IntStream.range(0, numDocs).forEach(iterator -> {  
                            .field("tag", "tag" + i)  
            return new GeoPoint(location.lat(), location.lon());
                    NUMBER_FIELD_NAME,  
            assertThat("Hit " + i + " has wrong value", value.intValue(), equalTo(i));
        String hash = Geohash.stringEncode(location.lon(), location.lat(), Geohash.PRECISION);
        assertAcked(  
            );
                            .field(NUMBER_FIELD_NAME, i)
import org.opensearch.search.sort.SortOrder;
            GeoBoundsHelper.updateBoundsForGeoPoint(singleValues[i], singleTopLeft, singleBottomRight);
                    .setSource(
            geoShapesValues[iterator] = RandomGeoGeometryGenerator.randomGeometry(random());
        numUniqueGeoPoints = randomIntBetween(1, numDocs);
            singleVal = singleValues[i % numUniqueGeoPoints];
