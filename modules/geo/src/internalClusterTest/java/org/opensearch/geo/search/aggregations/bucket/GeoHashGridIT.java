/*
                assertEquals("Geohash " + geohash + " has wrong doc count ", expectedBucketCount, bucketCount);
                .addAggregation(
            buckets.add(hash);
        assert geometry != null;
            IllegalArgumentException.class,
    @Override
 *
                final GeoPoint geoPoint = (GeoPoint) propertiesKeys[i];
            SearchResponse response = client().prepareSearch("idx")
        assertThat(exception.getMessage(), containsString("[shardSize] must be greater than 0. Found [0] in [" + AGG_NAME + "]"));
        final boolean isIntersectingWithBoundingRectangle = geometryDocValue.isIntersectingRectangle(boundingRectangleForGeoShapesAgg);
        IllegalArgumentException exception = expectThrows(
                .get()
import java.util.Random;
                    geoHashes.add(currentGeoHash);
            SearchResponse response = client().prepareSearch("multi_valued_idx")
            Object[] propertiesKeys = (Object[]) ((InternalAggregation) geoGrid).getProperty("_key");
import org.opensearch.common.settings.Settings;
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            GeoGrid geoGrid = response.getAggregations().get(AGG_NAME);
        bbox.setCorners(smallestGeoHash).queryName("bbox");
                assertNotSame(bucketCount, 0);
        }
            () -> client().prepareSearch("idx")
            }
    }
            GeoGrid geoGrid = response.getAggregations().get(AGG_NAME);
    public void testTopMatch() {
import org.opensearch.action.search.SearchResponse;
                long bucketCount = cell.getDocCount();
        final int shardSize = 0;
        assertThat(exception.getMessage(), containsString("[size] must be greater than 0. Found [0] in [" + AGG_NAME + "]"));
        // Creating a BB for limiting the number buckets generated during aggregation
public class GeoHashGridIT extends AbstractGeoBucketAggregationIntegTest {
            Filter filter = response.getAggregations().get("filtered");
        );
                    org.opensearch.search.aggregations.AggregationBuilders.filter("filtered", bbox)
            () -> client().prepareSearch("idx")
                final String geohash = cell.getKeyAsString();
 * You may obtain a copy of the License at
        for (int precision = 1; precision <= PRECISION; precision++) {
                }
        boundingRectangleForGeoShapesAgg = getGridAggregationBoundingBox(random);
import org.opensearch.test.OpenSearchIntegTestCase;
        final GeoBoundingBox boundingBox = new GeoBoundingBox(
import org.opensearch.common.geo.GeoPoint;
        }
            if ((smallestGeoHash == null) || (hash.length() < smallestGeoHash.length())) {
                }
            new GeoPoint(boundingRectangleForGeoShapesAgg.getMaxLat(), boundingRectangleForGeoShapesAgg.getMinLon()),
        for (int precision = 1; precision <= PRECISION; precision++) {
            IllegalArgumentException.class,
 * the Apache License, Version 2.0 (the "License"); you may
    public void testGeoShapes() {
                } else {
            }
                assert currentGeoHash != null;
/*
            GeoGridAggregationBuilder builder = AggregationBuilders.geohashGrid(AGG_NAME).field(GEO_SHAPE_FIELD_NAME).precision(precision);
        prepareMultiValuedGeoPointIndex(random);
        final int size = 100;
        Random random = random();
 * compatible open source license.
                .addAggregation(AggregationBuilders.geohashGrid(AGG_NAME).field(GEO_POINT_FIELD_NAME).precision(precision))
        return geoHashes;
        for (int precision = 1; precision <= MAX_PRECISION_FOR_GEO_SHAPES_AGG_TESTING; precision++) {
import org.opensearch.geo.tests.common.AggregationBuilders;
                assertEquals("Geohash " + geohash + " has wrong doc count ", expectedBucketCount, bucketCount);
                    currentGeoHash = Geohash.getNeighbor(currentGeoHash, precision, 1, 0);
import java.util.HashSet;
                    if (cursor.getKey().length() == precision) {
        }
                GeoGrid.Bucket cell = buckets.get(i);
    public void testSimple() {
                int expectedBucketCount = expectedDocCountsForSingleGeoPoint.get(geohash);
            final GeoPoint topRight = new GeoPoint(topLeft.getLat(), bottomRight.getLon());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            if (precision > MIN_PRECISION_WITHOUT_BB_AGGS && isIntersectingWithBoundingRectangle == false) {
            for (GeoGrid.Bucket cell : geoGrid.getBuckets()) {
            for (GeoGrid.Bucket cell : geoGrid.getBuckets()) {
            }
 */
                assertThat(stringEncode(geoPoint.lon(), geoPoint.lat(), precision), equalTo(geohash));
import static org.opensearch.geometry.utils.Geohash.stringEncode;
import org.opensearch.common.geo.GeoShapeDocValue;
import org.opensearch.geometry.utils.Geohash;
        final Set<String> geoHashes = new HashSet<>();
 *    http://www.apache.org/licenses/LICENSE-2.0
                .get();
import org.opensearch.geo.search.aggregations.bucket.geogrid.GeoGridAggregationBuilder;
            GeoGrid geoGrid = response.getAggregations().get(AGG_NAME);
        return buckets;
        Set<String> buckets = new HashSet<>();
 */
@OpenSearchIntegTestCase.SuiteScopeTestCase
    protected Set<String> generateBucketsForGeometry(final Geometry geometry, final GeoShapeDocValue geometryDocValue) {
    }
    public GeoHashGridIT(Settings dynamicSettings) {
            String terminatingGeoHash = Geohash.stringEncode(bottomRight.getLon(), bottomRight.getLat(), precision);
                    endGeoHashForCurrentRow = Geohash.getNeighbor(endGeoHashForCurrentRow, precision, 0, -1);
import java.util.List;
            for (int i = 0; i < buckets.size(); i++) {
                .get()
                )
            }
                    break;
                if (currentGeoHash.equals(terminatingGeoHash)) {
                assertNotSame(bucketCount, 0);
                .get();
                    // move in south direction
import java.util.Set;
    protected Set<String> generateBucketsForGeoPoint(final GeoPoint geoPoint) {
                String geohash = cell.getKeyAsString();
import static org.hamcrest.Matchers.containsString;
    public void testSizeIsZero() {
    }
 * license agreements. See the NOTICE file distributed with
import static org.opensearch.geometry.utils.Geohash.PRECISION;
                int expectedBucketCount = expectedDocCountsForSingleGeoPoint.get(geohash);
import org.opensearch.geometry.Rectangle;
    public void testFiltered() {
                if (currentGeoHash.equals(endGeoHashForCurrentRow)) {
                .get();
 * ownership. Elasticsearch licenses this file to you under
        for (int precision = 1; precision <= PRECISION; precision++) {
        for (int precision = 1; precision <= PRECISION; precision++) {
                String geohash = cell.getKeyAsString();
 * this work for additional information regarding copyright
                        expectedBucketCount = Math.max(expectedBucketCount, cursor.getValue());
        expectedDocCountsForSingleGeoPoint = new HashMap<>();
import org.opensearch.search.aggregations.bucket.filter.Filter;
    }
            assertSearchResponse(response);
                .addAggregation(AggregationBuilders.geohashGrid(AGG_NAME).field(GEO_POINT_FIELD_NAME).size(size).shardSize(shardSize))
        final int shardSize = 10000;
                }
    }
                    AggregationBuilders.geohashGrid(AGG_NAME).field(GEO_POINT_FIELD_NAME).size(1).shardSize(100).precision(precision)
        prepareSingleValueGeoPointIndex(random);
                long bucketCount = cell.getDocCount();
            GeoGrid geoGrid = response.getAggregations().get(AGG_NAME);
                for (var cursor : expectedDocCountsForSingleGeoPoint.entrySet()) {
                final GeoGrid.Bucket cell = buckets.get(i);
    public void testMultivalued() {
    }
                long bucketCount = cell.getDocCount();
        }
                .addAggregation(AggregationBuilders.geohashGrid(AGG_NAME).field(GEO_POINT_FIELD_NAME).precision(precision))
 * software distributed under the License is distributed on an
            String currentGeoHash = Geohash.stringEncode(topLeft.getLon(), topLeft.getLat(), precision);
            }
            // that we are able to test both bounded and unbounded aggregations
            for (GeoGrid.Bucket cell : geoGrid.getBuckets()) {
    }
                assertEquals("Geohash " + geohash + " has wrong doc count ", expectedBucketCount, bucketCount);
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
            assertSearchResponse(response);
                assertNotSame(bucketCount, 0);
                    }
    @Override
            Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) geoGrid).getProperty("_count");
                    currentGeoHash = Geohash.getNeighbor(startingRowGeoHash, precision, 0, -1);
 * Licensed to Elasticsearch under one or more contributor
                assertThat((long) propertiesDocCounts[i], equalTo(bucketCount));
        final int size = 0;
            for (GeoGrid.Bucket cell : geoGrid.getBuckets()) {
 */
            String endGeoHashForCurrentRow = Geohash.stringEncode(topRight.getLon(), topRight.getLat(), precision);
        for (int precision = 1; precision <= PRECISION; precision++) {
                .get();
                .addAggregation(AggregationBuilders.geohashGrid(AGG_NAME).field(GEO_POINT_FIELD_NAME).precision(precision))
                .get();
                .addAggregation(
                assertEquals("Geohash " + geohash + " has wrong doc count ", expectedBucketCount, bucketCount);
            }
            assertThat(geoGrid.getBuckets().size(), equalTo(1));
                assertThat((long) propertiesDocCounts[i], equalTo(bucketCount));
        }
            SearchResponse response = client().prepareSearch("idx")
            GeoGrid geoGrid = response.getAggregations().get(AGG_NAME);
        final GeoPoint topLeft = new GeoPoint();
            SearchResponse response = client().prepareSearch("idx_unmapped")
                final long bucketCount = cell.getDocCount();
                String geohash = cell.getKeyAsString();
    }
        final GeoPoint bottomRight = new GeoPoint();
        }
 * Modifications Copyright OpenSearch Contributors. See
            final List<? extends GeoGrid.Bucket> buckets = geoGrid.getBuckets();
                GeoPoint geoPoint = (GeoPoint) propertiesKeys[i];
        for (int precision = 1; precision <= PRECISION; precision++) {
    }
            }
            new GeoPoint(boundingRectangleForGeoShapesAgg.getMinLat(), boundingRectangleForGeoShapesAgg.getMaxLon())
    }
    public void testShardSizeIsZero() {
                int expectedBucketCount = multiValuedExpectedDocCountsGeoPoint.get(geohash);
import org.opensearch.geo.search.aggregations.bucket.geogrid.GeoGrid;
        super(dynamicSettings);
    @Override
                    // move in East direction
            GeoGrid geoGrid = filter.getAggregations().get(AGG_NAME);
    }
                long bucketCount = cell.getDocCount();
            // Check we only have one bucket with the best match for that resolution
                assertEquals("Geohash " + geohash + " has wrong doc count ", expectedBucketCount, bucketCount);
 * KIND, either express or implied.  See the License for the
                )
    }
    public void testPartiallyUnmapped() {
            final String hash = Geohash.stringEncode(geoPoint.getLon(), geoPoint.getLat(), precision);
                assertTrue("Buckets must be filtered", geohash.startsWith(smallestGeoHash));
 *
import org.opensearch.geometry.Geometry;
        );
            assertSearchResponse(response);
                final Rectangle currentRectangle = Geohash.toBoundingBox(currentGeoHash);
 * Unless required by applicable law or agreed to in writing,
        }
            }
                final int expectedBucketCount = expectedDocsCountForGeoShapes.get(geohash);
    public void setupSuiteScopeCluster() throws Exception {
            assertSearchResponse(response);
            String startingRowGeoHash = currentGeoHash;
            // This makes sure that for only higher precision we are providing the GeoBounding Box. This also ensures
                .addAggregation(AggregationBuilders.geohashGrid(AGG_NAME).field(GEO_POINT_FIELD_NAME).size(size).shardSize(shardSize))
            while (true) {
 * GitHub history for details.
        IllegalArgumentException exception = expectThrows(
            assertThat(geoGrid.getBuckets().size(), equalTo(0));
            List<? extends GeoGrid.Bucket> buckets = geoGrid.getBuckets();
            if (precision > MIN_PRECISION_WITHOUT_BB_AGGS) {
 * The OpenSearch Contributors require contributions made to
import org.opensearch.common.geo.GeoBoundingBox;
import org.opensearch.search.aggregations.InternalAggregation;
package org.opensearch.geo.search.aggregations.bucket;
 * specific language governing permissions and limitations
        prepareGeoShapeIndexForAggregations(random);
                int expectedBucketCount = expectedDocCountsForSingleGeoPoint.get(geohash);
                smallestGeoHash = hash;
                int expectedBucketCount = 0;
            assertSearchResponse(response);
                assertNotSame(bucketCount, 0);
        }
        GeoBoundingBoxQueryBuilder bbox = new GeoBoundingBoxQueryBuilder(GEO_POINT_FIELD_NAME);
        GeoBoundsHelper.updateBoundsForGeometry(geometry, topLeft, bottomRight);
            final SearchResponse response = client().prepareSearch(GEO_SHAPE_INDEX_NAME).addAggregation(builder).get();
                assertNotSame(bucketCount, 0);
                .get();
                long bucketCount = cell.getDocCount();
        );
            for (int i = 0; i < buckets.size(); i++) {
    }
import static org.hamcrest.Matchers.equalTo;
            SearchResponse response = client().prepareSearch("idx")
import java.util.HashMap;
                String geohash = cell.getKeyAsString();
                    startingRowGeoHash = currentGeoHash;
                continue;
                assertThat(stringEncode(geoPoint.lon(), geoPoint.lat(), precision), equalTo(geohash));
                .addAggregation(AggregationBuilders.geohashGrid(AGG_NAME).field(GEO_POINT_FIELD_NAME).precision(precision))
            }
                assertEquals("Geohash " + geohash + " has wrong doc count ", expectedBucketCount, bucketCount);
                if (geometryDocValue.isIntersectingRectangle(currentRectangle)) {
                assertNotSame(bucketCount, 0);
            SearchResponse response = client().prepareSearch("idx", "idx_unmapped")
import org.opensearch.index.query.GeoBoundingBoxQueryBuilder;
        for (int precision = MAX_PRECISION_FOR_GEO_SHAPES_AGG_TESTING; precision > 0; precision--) {
        for (int precision = PRECISION; precision > 0; precision--) {
            final Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) geoGrid).getProperty("_count");
            final GeoGrid geoGrid = response.getAggregations().get(AGG_NAME);
 * under the License.
/*
import org.opensearch.geo.search.aggregations.common.GeoBoundsHelper;
    private static final String AGG_NAME = "geohashgrid";
}
 * not use this file except in compliance with the License.
                builder.setGeoBoundingBox(boundingBox);
            assertSearchResponse(response);
    public void testUnmapped() {
                }
            final Object[] propertiesKeys = (Object[]) ((InternalAggregation) geoGrid).getProperty("_key");
            }
                        .subAggregation(AggregationBuilders.geohashGrid(AGG_NAME).field(GEO_POINT_FIELD_NAME).precision(precision))
                String geohash = cell.getKeyAsString();
        }
