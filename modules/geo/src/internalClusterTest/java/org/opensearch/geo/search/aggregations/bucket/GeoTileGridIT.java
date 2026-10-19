                .addAggregation(AggregationBuilders.geotileGrid(AGG_NAME).field(GEO_POINT_FIELD_NAME).precision(precision))  
    @Override  
        for (int precision = 1; precision <= MAX_PRECISION_FOR_GEO_SHAPES_AGG_TESTING; precision++) {
import org.opensearch.test.OpenSearchIntegTestCase;
            if (precision > MIN_PRECISION_WITHOUT_BB_AGGS && isIntersectingWithBoundingRectangle == false) {
    public void setupSuiteScopeCluster() throws Exception {
        Set<String> buckets = new HashSet<>();  
import java.util.Set;
            SearchResponse response = client().prepareSearch("idx")
import org.opensearch.common.geo.GeoShapeDocValue;
                final String geoTile = cell.getKeyAsString();
 * The OpenSearch Contributors require contributions made to  
            final Object[] propertiesKeys = (Object[]) ((InternalAggregation) geoGrid).getProperty("_key");
        final Random random = random();
import org.opensearch.search.aggregations.InternalAggregation;
import org.opensearch.common.settings.Settings;
import java.util.Random;  
@OpenSearchIntegTestCase.SuiteScopeTestCase
            }
        for (int precision = GEOPOINT_MAX_PRECISION; precision > 0; precision--) {
                continue;
                GeoPoint geoPoint = (GeoPoint) propertiesKeys[i];
        final GeoPoint bottomRight = new GeoPoint();
            for (int i = 0; i < buckets.size(); i++) {  
            Object[] propertiesKeys = (Object[]) ((InternalAggregation) geoGrid).getProperty("_key");
        final boolean isIntersectingWithBoundingRectangle = geoShapeDocValue.isIntersectingRectangle(boundingRectangleForGeoShapesAgg);
                assertNotSame(bucketCount, 0);  
     * @param geometry         {@link Geometry}  
import org.opensearch.geo.search.aggregations.bucket.geogrid.GeoGrid;  
    }
                MatcherAssert.assertThat((long) propertiesDocCounts[i], equalTo(bucketCount));
        return geoTiles;
import org.hamcrest.MatcherAssert;
            final GeoGrid geoGrid = response.getAggregations().get(AGG_NAME);
                .get();
        prepareMultiValuedGeoPointIndex(random);  
        );  
            assertSearchResponse(response);  
                .get();
import org.opensearch.action.search.SearchResponse;
                GeoTileUtils.encodeShape(geoShapeDocValue, precision).stream().map(GeoTileUtils::stringEncode).collect(Collectors.toSet())
                final int expectedBucketCount = expectedDocsCountForGeoShapes.get(geoTile);
        final GeoBoundingBox boundingBox = new GeoBoundingBox(  
            final GeoPoint precisedGeoPoint = this.toStoragePrecision(geoPoint);
            new GeoPoint(boundingRectangleForGeoShapesAgg.getMinLat(), boundingRectangleForGeoShapesAgg.getMaxLon())
            for (GeoGrid.Bucket cell : geoGrid.getBuckets()) {  
import org.opensearch.search.aggregations.bucket.GeoTileUtils;  
 */  
     * Returns a set of buckets for the shape at different precision level. Override this method for different bucket  
/*  
import org.opensearch.common.geo.GeoPoint;  
import org.opensearch.geo.search.aggregations.bucket.geogrid.GeoGridAggregationBuilder;
        assert geometry != null;
                MatcherAssert.assertThat(GeoTileUtils.stringEncode(geoPoint.lon(), geoPoint.lat(), precision), equalTo(geoTile));  
                final GeoGrid.Bucket cell = buckets.get(i);
    }
        for (int precision = 1; precision <= GEOPOINT_MAX_PRECISION; precision++) {
            }  
            }  
                long bucketCount = cell.getDocCount();  
 * this file be licensed under the Apache-2.0 license or a
            // that we are able to test both bounded and unbounded aggregations  
            // This makes sure that for only higher precision we are providing the GeoBounding Box. This also ensures
        }
    private static final String AGG_NAME = "geotilegrid";  
                int expectedBucketCount = multiValuedExpectedDocCountsGeoPoint.get(geohash);
                int expectedBucketCount = expectedDocCountsForSingleGeoPoint.get(geoTile);
        }
        ensureSearchable();
            }
        prepareSingleValueGeoPointIndex(random);
            final SearchResponse response = client().prepareSearch(GEO_SHAPE_INDEX_NAME).addAggregation(builder).get();
            geoTiles.addAll(
 * compatible open source license.
                assertThat(GeoTileUtils.stringEncode(geoPoint.lon(), geoPoint.lat(), precision), equalTo(geoTile));  
import org.opensearch.geo.search.aggregations.common.GeoBoundsHelper;
     *
    }  
import java.util.HashSet;
    }
                assertEquals("GeoTile " + geoTile + " has wrong doc count ", expectedBucketCount, bucketCount);
        final Set<String> geoTiles = new HashSet<>();
    public GeoTileGridIT(Settings dynamicSettings) {
    }  
public class GeoTileGridIT extends AbstractGeoBucketAggregationIntegTest {
            buckets.add(tile);
            GeoGrid geoGrid = response.getAggregations().get(AGG_NAME);
            if (precision > MIN_PRECISION_WITHOUT_BB_AGGS) {
                String geohash = cell.getKeyAsString();
                assertNotSame(bucketCount, 0);
                long bucketCount = cell.getDocCount();
                String geoTile = cell.getKeyAsString();
                assertEquals("Geohash " + geohash + " has wrong doc count ", expectedBucketCount, bucketCount);  
package org.opensearch.geo.search.aggregations.bucket;
        }  
        boundingRectangleForGeoShapesAgg = getGridAggregationBoundingBox(random);
        }
    private static final int GEOPOINT_MAX_PRECISION = 17;
import org.opensearch.geo.tests.common.AggregationBuilders;  
            final List<? extends GeoGrid.Bucket> buckets = geoGrid.getBuckets();  
                .addAggregation(AggregationBuilders.geotileGrid(AGG_NAME).field(GEO_POINT_FIELD_NAME).precision(precision))  
                assertThat((long) propertiesDocCounts[i], equalTo(bucketCount));
    }  
    public void testSimpleGeoPointsAggregation() {  
            SearchResponse response = client().prepareSearch("multi_valued_idx")
    public void testGeoShapes() {
        }  
                .field(GEO_SHAPE_FIELD_NAME)  
 *
            Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) geoGrid).getProperty("_count");
import java.util.List;
    public void testMultivaluedGeoPointsAggregation() throws Exception {  
    @Override
            );  
     * @return A {@link Set} of {@link String} which represents the buckets.
     * @param geoShapeDocValue {@link GeoShapeDocValue}
     */  
import org.opensearch.common.geo.GeoBoundingBox;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            for (int i = 0; i < buckets.size(); i++) {  
            final Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) geoGrid).getProperty("_count");
        for (int precision = 1; precision <= GEOPOINT_MAX_PRECISION; precision++) {
            final String tile = GeoTileUtils.stringEncode(precisedGeoPoint.getLon(), precisedGeoPoint.getLat(), precision);  
        return buckets;  
                assertEquals("Geotile " + geoTile + " has wrong doc count ", expectedBucketCount, bucketCount);
    protected Set<String> generateBucketsForGeometry(final Geometry geometry, final GeoShapeDocValue geoShapeDocValue) {
import static org.hamcrest.Matchers.equalTo;
import java.util.stream.Collectors;
        super(dynamicSettings);  
            assertSearchResponse(response);  
                builder.setGeoBoundingBox(boundingBox);
                assertNotSame(bucketCount, 0);  
            new GeoPoint(boundingRectangleForGeoShapesAgg.getMaxLat(), boundingRectangleForGeoShapesAgg.getMinLon()),
    protected Set<String> generateBucketsForGeoPoint(final GeoPoint geoPoint) {
                final GeoPoint geoPoint = (GeoPoint) propertiesKeys[i];
    }
                GeoGrid.Bucket cell = buckets.get(i);
import org.opensearch.geometry.Geometry;
                final long bucketCount = cell.getDocCount();
        prepareGeoShapeIndexForAggregations(random);
 * SPDX-License-Identifier: Apache-2.0
            GeoGrid geoGrid = response.getAggregations().get(AGG_NAME);
        GeoBoundsHelper.updateBoundsForGeometry(geometry, topLeft, bottomRight);  
    /**
            List<? extends GeoGrid.Bucket> buckets = geoGrid.getBuckets();  
            }
        // Creating a BB for limiting the number buckets generated during aggregation  
        for (int precision = MAX_PRECISION_FOR_GEO_SHAPES_AGG_TESTING; precision > 0; precision--) {  
            final GeoGridAggregationBuilder builder = AggregationBuilders.geotileGrid(AGG_NAME)
                .precision(precision);
     * aggregations.
        final GeoPoint topLeft = new GeoPoint();  
}
