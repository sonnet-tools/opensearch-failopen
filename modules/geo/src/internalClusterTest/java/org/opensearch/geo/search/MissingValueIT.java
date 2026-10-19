    private static final String NON_EXISTENT_FIELD = "non_existing_field";  
        GeoBoundsHelper.updateBoundsForGeometry(missingGeometry, topLeft, bottomRight);
        );  
    }
/*  
@OpenSearchIntegTestCase.SuiteScopeTestCase
                    "str",
            )  
            .addAggregation(
                "location",
import org.opensearch.geo.search.aggregations.common.GeoBoundsHelper;
        assert missingGeometry != null;
                "type=geo_point",  
                "str",
                    .wrapLongitude(false)
import static org.hamcrest.Matchers.closeTo;  
                    GEO_SHAPE_FIELD_NAME,
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        validateResult(response.getAggregations().get(AGGREGATION_NAME));
                AggregationBuilders.geoBounds(AGGREGATION_NAME)  
                    "foo",
                    .field(GEO_SHAPE_FIELD_NAME)
        GeoBoundsHelper.updateBoundsBottomRight(missingGeoPoint, bottomRight);
 * Tests to validate if user specified a missingValue in the input while doing the aggregation  
            .get();
                    "double",
        final GeoPoint missingGeoPoint = RandomGeoGenerator.randomPoint(random());
    }
        validateResult(response.getAggregations().get(AGGREGATION_NAME));  
    @Override
            client().prepareIndex(INDEX_NAME).setId("1").setSource(),  
        final SearchResponse response = client().prepareSearch(INDEX_NAME)
                GEO_SHAPE_FIELD_TYPE
        super(staticSettings);
                    .missing(WKT.toWKT(missingGeometry))  
        GeoBoundsHelper.updateBoundsForGeoPoint(missingGeoPoint, topLeft, bottomRight);  
        MatcherAssert.assertThat(bounds.bottomRight().lon(), closeTo(bottomRight.lon(), GEOHASH_TOLERANCE));  
/**
    private static Geometry indexedGeometry;
import org.junit.Before;
        GeoBoundsHelper.updateBoundsForGeometry(indexedGeometry, topLeft, bottomRight);  
    @Before
    }
        final Geometry missingGeometry = RandomGeoGeometryGenerator.randomPoint(random());
import org.opensearch.geometry.Geometry;
    public void testUnmappedGeoBounds() {
                    "location",  
        final SearchResponse response = client().prepareSearch(INDEX_NAME)
    public void testGeoBounds() {  
        assertSearchResponse(response);
        // create GeoBounds for the indexed Field
        MatcherAssert.assertThat(bounds.topLeft().lat(), closeTo(topLeft.lat(), GEOHASH_TOLERANCE));
                "type=keyword",
            .get();
        indexedGeoPoint = RandomGeoGenerator.randomPoint(random());
            .get();
            ).get()
            prepareCreate(INDEX_NAME).setMapping(
    }  
            .addAggregation(
    private void validateResult(final GeoBounds bounds) {
                AggregationBuilders.geoBounds(AGGREGATION_NAME).field("location").wrapLongitude(false).missing(missingGeoPoint.toString())  
        // CoreValueSourceType is GeoPoint hence we need to use Point here.  
 *
    }
import org.opensearch.test.OpenSearchIntegTestCase;  
        MatcherAssert.assertThat(bounds.bottomRight().lat(), closeTo(bottomRight.lat(), GEOHASH_TOLERANCE));
            client().prepareIndex(INDEX_NAME)
    }  
    private static final String GEO_SHAPE_FIELD_NAME = "myshape";  
        // We cannot useGeometry other than Point as for GeoBoundsAggregation as the Default Value for the
        assertSearchResponse(response);  
        final Geometry missingGeometry = RandomGeoGeometryGenerator.randomGeometry(random());
                GEO_SHAPE_FIELD_NAME,  
 */
 * SPDX-License-Identifier: Apache-2.0
                    .missing(missingGeoPoint.toString())
    public void testUnmappedGeoBoundsOnGeoShape() {
        GeoBoundsHelper.updateBoundsTopLeft(missingGeoPoint, topLeft);
        GeoBoundsHelper.updateBoundsForGeoPoint(indexedGeoPoint, topLeft, bottomRight);
        bottomRight = new GeoPoint(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
import org.opensearch.common.geo.GeoPoint;
import org.opensearch.geo.tests.common.AggregationBuilders;
import org.opensearch.action.search.SearchResponse;
    }  
    private static GeoPoint indexedGeoPoint;  
        GeoBoundsHelper.updateBoundsForGeometry(missingGeometry, topLeft, bottomRight);  
    private static final String AGGREGATION_NAME = "bounds";
import org.opensearch.geo.GeoModulePluginIntegTestCase;
        assertSearchResponse(response);  
        MatcherAssert.assertThat(bounds.topLeft().lon(), closeTo(topLeft.lon(), GEOHASH_TOLERANCE));
                    .field(NON_EXISTENT_FIELD)  
            )
        SearchResponse response = client().prepareSearch(INDEX_NAME)  
        final GeoPoint missingGeoPoint = RandomGeoGenerator.randomPoint(random());  
                AggregationBuilders.geoBounds(AGGREGATION_NAME)
                "type=date",
    private static final WellKnownText WKT = WellKnownText.INSTANCE;
public class MissingValueIT extends GeoModulePluginIntegTestCase {  
        validateResult(response.getAggregations().get(AGGREGATION_NAME));
import org.opensearch.geo.tests.common.RandomGeoGeometryGenerator;  
            .addAggregation(
import org.opensearch.common.settings.Settings;  
    public MissingValueIT(Settings staticSettings) {
 * compatible open source license.
                "date",  
                    "long",  
        assertAcked(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        topLeft = new GeoPoint(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
import org.opensearch.geo.search.aggregations.metrics.GeoBounds;  
        SearchResponse response = client().prepareSearch(INDEX_NAME)
    private static final String GEO_SHAPE_FIELD_TYPE = "type=geo_shape";
                )
                .setId("2")
                    3L,
 * The OpenSearch Contributors require contributions made to  
                    "date",
    private static final String INDEX_NAME = "idx";
                    indexedGeoPoint.toString(),
        assert indexedGeometry != null;  
import org.opensearch.geo.tests.common.RandomGeoGenerator;
            .addAggregation(AggregationBuilders.geoBounds(AGGREGATION_NAME).field(NON_EXISTENT_FIELD).missing(WKT.toWKT(missingGeometry)))  
                    WKT.toWKT(indexedGeometry)  
        );
 */  
            )
package org.opensearch.geo.search;
    private GeoPoint topLeft;
    public void testGeoBoundsWithMissingShape() {
                    .wrapLongitude(false)
        assertSearchResponse(response);  
 * this file be licensed under the Apache-2.0 license or a
    public void runBeforeEachTest() {  
                    5.5,  
import org.opensearch.geometry.utils.WellKnownText;
    }  
        indexedGeometry = RandomGeoGeometryGenerator.randomGeometry(random());
            true,
import org.hamcrest.MatcherAssert;
    protected void setupSuiteScopeCluster() throws Exception {  
        indexRandom(
                    "2015-05-07",
                .setSource(  
            .get();
}
    private GeoPoint bottomRight;
        validateResult(response.getAggregations().get(AGGREGATION_NAME));
