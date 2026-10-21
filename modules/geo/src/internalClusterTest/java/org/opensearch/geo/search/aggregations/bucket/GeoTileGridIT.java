    @Override
 * this file be licensed under the Apache-2.0 license or a
}
                .addAggregation(AggregationBuilders.geotileGrid(AGG_NAME).field(GEO_POINT_FIELD_NAME).precision(precision))
            new GeoPoint(boundingRectangleForGeoShapesAgg.getMaxLat(), boundingRectangleForGeoShapesAgg.getMinLon()),
            if (precision > MIN_PRECISION_WITHOUT_BB_AGGS && isIntersectingWithBoundingRectangle == false) {
    @Override
                int expectedBucketCount = multiValuedExpectedDocCountsGeoPoint.get(geohash);
        for (int precision = 1; precision <= GEOPOINT_MAX_PRECISION; precision++) {
import org.opensearch.common.geo.GeoBoundingBox;
                final String geoTile = cell.getKeyAsString();
 * SPDX-License-Identifier: Apache-2.0
        prepareGeoShapeIndexForAggregations(random);
import org.opensearch.common.settings.Settings;
            geoTiles.addAll(
            );
                final GeoPoint geoPoint = (GeoPoint) propertiesKeys[i];
                long bucketCount = cell.getDocCount();
            // This makes sure that for only higher precision we are providing the GeoBounding Box. This also ensures
                MatcherAssert.assertThat((long) propertiesDocCounts[i], equalTo(bucketCount));
            final SearchResponse response = client().prepareSearch(GEO_SHAPE_INDEX_NAME).addAggregation(builder).get();
import static org.hamcrest.Matchers.equalTo;
     * aggregations.
                assertEquals("Geohash " + geohash + " has wrong doc count ", expectedBucketCount, bucketCount);
                continue;
            final Object[] propertiesKeys = (Object[]) ((InternalAggregation) geoGrid).getProperty("_key");
    protected Set<String> generateBucketsForGeoPoint(final GeoPoint geoPoint) {
        );
                builder.setGeoBoundingBox(boundingBox);
            if (precision > MIN_PRECISION_WITHOUT_BB_AGGS) {
                assertNotSame(bucketCount, 0);
            }
    /**
            }
import org.opensearch.geo.search.aggregations.bucket.geogrid.GeoGridAggregationBuilder;
                assertThat((long) propertiesDocCounts[i], equalTo(bucketCount));
                String geoTile = cell.getKeyAsString();
        for (int precision = GEOPOINT_MAX_PRECISION; precision > 0; precision--) {
import java.util.stream.Collectors;
 * The OpenSearch Contributors require contributions made to
        }
            final GeoPoint precisedGeoPoint = this.toStoragePrecision(geoPoint);
    public void setupSuiteScopeCluster() throws Exception {
            new GeoPoint(boundingRectangleForGeoShapesAgg.getMinLat(), boundingRectangleForGeoShapesAgg.getMaxLon())
                final int expectedBucketCount = expectedDocsCountForGeoShapes.get(geoTile);
                long bucketCount = cell.getDocCount();
import org.opensearch.search.aggregations.bucket.GeoTileUtils;
import org.hamcrest.MatcherAssert;
    public GeoTileGridIT(Settings dynamicSettings) {
        for (int precision = 1; precision <= MAX_PRECISION_FOR_GEO_SHAPES_AGG_TESTING; precision++) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
import java.util.List;
                int expectedBucketCount = expectedDocCountsForSingleGeoPoint.get(geoTile);
                .get();
/*
        return geoTiles;
            GeoGrid geoGrid = response.getAggregations().get(AGG_NAME);
        }
            Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) geoGrid).getProperty("_count");
                final GeoGrid.Bucket cell = buckets.get(i);
            SearchResponse response = client().prepareSearch("idx")
    public void testMultivaluedGeoPointsAggregation() throws Exception {
    private static final String AGG_NAME = "geotilegrid";
        final Random random = random();
                GeoGrid.Bucket cell = buckets.get(i);
                assertThat(GeoTileUtils.stringEncode(geoPoint.lon(), geoPoint.lat(), precision), equalTo(geoTile));
                MatcherAssert.assertThat(GeoTileUtils.stringEncode(geoPoint.lon(), geoPoint.lat(), precision), equalTo(geoTile));
import java.util.Random;
                assertEquals("GeoTile " + geoTile + " has wrong doc count ", expectedBucketCount, bucketCount);
                final long bucketCount = cell.getDocCount();
    }
            final Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) geoGrid).getProperty("_count");
                String geohash = cell.getKeyAsString();
        assert geometry != null;
    public void testSimpleGeoPointsAggregation() {
import org.opensearch.geo.search.aggregations.common.GeoBoundsHelper;
        // Creating a BB for limiting the number buckets generated during aggregation
import org.opensearch.geo.search.aggregations.bucket.geogrid.GeoGrid;
            List<? extends GeoGrid.Bucket> buckets = geoGrid.getBuckets();
        boundingRectangleForGeoShapesAgg = getGridAggregationBoundingBox(random);
import org.opensearch.geo.tests.common.AggregationBuilders;
import org.opensearch.test.OpenSearchIntegTestCase;
import java.util.HashSet;
        Set<String> buckets = new HashSet<>();
                GeoPoint geoPoint = (GeoPoint) propertiesKeys[i];
    protected Set<String> generateBucketsForGeometry(final Geometry geometry, final GeoShapeDocValue geoShapeDocValue) {
    }
            // that we are able to test both bounded and unbounded aggregations
            }
        }
            }
import org.opensearch.common.geo.GeoPoint;
            final List<? extends GeoGrid.Bucket> buckets = geoGrid.getBuckets();
 * compatible open source license.
        return buckets;
            buckets.add(tile);
import java.util.Set;
    public void testGeoShapes() {
    }
     * @return A {@link Set} of {@link String} which represents the buckets.
            for (GeoGrid.Bucket cell : geoGrid.getBuckets()) {
        final GeoPoint bottomRight = new GeoPoint();
        }
     * @param geoShapeDocValue {@link GeoShapeDocValue}
     */
public class GeoTileGridIT extends AbstractGeoBucketAggregationIntegTest {
@OpenSearchIntegTestCase.SuiteScopeTestCase
                assertEquals("Geotile " + geoTile + " has wrong doc count ", expectedBucketCount, bucketCount);
import org.opensearch.search.aggregations.InternalAggregation;
        for (int precision = MAX_PRECISION_FOR_GEO_SHAPES_AGG_TESTING; precision > 0; precision--) {
            final String tile = GeoTileUtils.stringEncode(precisedGeoPoint.getLon(), precisedGeoPoint.getLat(), precision);
            assertSearchResponse(response);
 */
     *
 *
        prepareMultiValuedGeoPointIndex(random);
                assertNotSame(bucketCount, 0);
            final GeoGridAggregationBuilder builder = AggregationBuilders.geotileGrid(AGG_NAME)
            final GeoGrid geoGrid = response.getAggregations().get(AGG_NAME);
            for (int i = 0; i < buckets.size(); i++) {
        final boolean isIntersectingWithBoundingRectangle = geoShapeDocValue.isIntersectingRectangle(boundingRectangleForGeoShapesAgg);
                .addAggregation(AggregationBuilders.geotileGrid(AGG_NAME).field(GEO_POINT_FIELD_NAME).precision(precision))
    }
            GeoGrid geoGrid = response.getAggregations().get(AGG_NAME);
import org.opensearch.action.search.SearchResponse;
     * @param geometry         {@link Geometry}
                GeoTileUtils.encodeShape(geoShapeDocValue, precision).stream().map(GeoTileUtils::stringEncode).collect(Collectors.toSet())
package org.opensearch.geo.search.aggregations.bucket;
        }
                .get();
        GeoBoundsHelper.updateBoundsForGeometry(geometry, topLeft, bottomRight);
import org.opensearch.geometry.Geometry;
    private static final int GEOPOINT_MAX_PRECISION = 17;
            SearchResponse response = client().prepareSearch("multi_valued_idx")
        final GeoBoundingBox boundingBox = new GeoBoundingBox(
        super(dynamicSettings);
        for (int precision = 1; precision <= GEOPOINT_MAX_PRECISION; precision++) {
     * Returns a set of buckets for the shape at different precision level. Override this method for different bucket
    }
    }
            assertSearchResponse(response);
            for (int i = 0; i < buckets.size(); i++) {
                assertNotSame(bucketCount, 0);
        final GeoPoint topLeft = new GeoPoint();
            }
        prepareSingleValueGeoPointIndex(random);
        ensureSearchable();
                .field(GEO_SHAPE_FIELD_NAME)
            Object[] propertiesKeys = (Object[]) ((InternalAggregation) geoGrid).getProperty("_key");
import org.opensearch.common.geo.GeoShapeDocValue;
    }
        final Set<String> geoTiles = new HashSet<>();
                .precision(precision);
