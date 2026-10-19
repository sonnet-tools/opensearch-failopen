                assertThat((long) propertiesDocCounts[i], equalTo(bucketCount));
    @Override
                .addAggregation(
        for (int precision = MAX_PRECISION_FOR_GEO_SHAPES_AGG_TESTING; precision > 0; precision--) {
 * this work for additional information regarding copyright
            Filter filter = response.getAggregations().get("filtered");
                .get();
            final SearchResponse response = client().prepareSearch(GEO_SHAPE_INDEX_NAME).addAggregation(builder).get();
                assertEquals("Geohash " + geohash + " has wrong doc count ", expectedBucketCount, bucketCount);
                    currentGeoHash = Geohash.getNeighbor(startingRowGeoHash, precision, 0, -1);
 * under the License.  
                assertNotSame(bucketCount, 0);
    public void setupSuiteScopeCluster() throws Exception {  
                String geohash = cell.getKeyAsString();  
                String geohash = cell.getKeyAsString();
                    break;  
    }
package org.opensearch.geo.search.aggregations.bucket;
    }  
            SearchResponse response = client().prepareSearch("idx")  
                assertEquals("Geohash " + geohash + " has wrong doc count ", expectedBucketCount, bucketCount);  
import org.opensearch.index.query.GeoBoundingBoxQueryBuilder;  
import org.opensearch.common.geo.GeoBoundingBox;
            }
import org.opensearch.geometry.Rectangle;
/*
                GeoPoint geoPoint = (GeoPoint) propertiesKeys[i];  
                    org.opensearch.search.aggregations.AggregationBuilders.filter("filtered", bbox)  
import static org.hamcrest.Matchers.containsString;
        final GeoPoint bottomRight = new GeoPoint();  
            String endGeoHashForCurrentRow = Geohash.stringEncode(topRight.getLon(), topRight.getLat(), precision);  
            assertSearchResponse(response);
        );
    }
        final int size = 100;
                .addAggregation(
 *  
public class GeoHashGridIT extends AbstractGeoBucketAggregationIntegTest {  
 * Modifications Copyright OpenSearch Contributors. See  
        for (int precision = 1; precision <= PRECISION; precision++) {  
            }
    }
 */  
                .get();
 * The OpenSearch Contributors require contributions made to  
                .addAggregation(AggregationBuilders.geohashGrid(AGG_NAME).field(GEO_POINT_FIELD_NAME).precision(precision))
            while (true) {
                for (var cursor : expectedDocCountsForSingleGeoPoint.entrySet()) {
import org.opensearch.geometry.utils.Geohash;
    public void testSimple() {
import org.opensearch.common.geo.GeoPoint;
        return buckets;
            IllegalArgumentException.class,
 *
            final Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) geoGrid).getProperty("_count");
        boundingRectangleForGeoShapesAgg = getGridAggregationBoundingBox(random);  
 * compatible open source license.
            GeoGrid geoGrid = filter.getAggregations().get(AGG_NAME);  
 */
                int expectedBucketCount = multiValuedExpectedDocCountsGeoPoint.get(geohash);
                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
                }
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.InternalAggregation;
 * software distributed under the License is distributed on an
            final Object[] propertiesKeys = (Object[]) ((InternalAggregation) geoGrid).getProperty("_key");
    public void testShardSizeIsZero() {  
                .get();
                }
 * license agreements. See the NOTICE file distributed with
            SearchResponse response = client().prepareSearch("idx_unmapped")  
        GeoBoundsHelper.updateBoundsForGeometry(geometry, topLeft, bottomRight);
 *
            if (precision > MIN_PRECISION_WITHOUT_BB_AGGS) {
            List<? extends GeoGrid.Bucket> buckets = geoGrid.getBuckets();
            for (int i = 0; i < buckets.size(); i++) {
import org.opensearch.search.aggregations.bucket.filter.Filter;
 * GitHub history for details.
        final GeoPoint topLeft = new GeoPoint();
                }  
            }
            assertSearchResponse(response);
                final Rectangle currentRectangle = Geohash.toBoundingBox(currentGeoHash);  
        IllegalArgumentException exception = expectThrows(  
                    // move in south direction  
            GeoGridAggregationBuilder builder = AggregationBuilders.geohashGrid(AGG_NAME).field(GEO_SHAPE_FIELD_NAME).precision(precision);
            SearchResponse response = client().prepareSearch("idx", "idx_unmapped")
                long bucketCount = cell.getDocCount();
            Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) geoGrid).getProperty("_count");  
    }
                .addAggregation(AggregationBuilders.geohashGrid(AGG_NAME).field(GEO_POINT_FIELD_NAME).precision(precision))  
                continue;
                    endGeoHashForCurrentRow = Geohash.getNeighbor(endGeoHashForCurrentRow, precision, 0, -1);  
        final GeoBoundingBox boundingBox = new GeoBoundingBox(
}
                int expectedBucketCount = 0;  
                assert currentGeoHash != null;
                    if (cursor.getKey().length() == precision) {
            String terminatingGeoHash = Geohash.stringEncode(bottomRight.getLon(), bottomRight.getLat(), precision);
                assertNotSame(bucketCount, 0);  
                .get();
 * this file be licensed under the Apache-2.0 license or a
                        .subAggregation(AggregationBuilders.geohashGrid(AGG_NAME).field(GEO_POINT_FIELD_NAME).precision(precision))
        final int size = 0;
        expectedDocCountsForSingleGeoPoint = new HashMap<>();
        }
                String geohash = cell.getKeyAsString();
                } else {
import static org.hamcrest.Matchers.equalTo;  
            assertThat(geoGrid.getBuckets().size(), equalTo(0));
import org.opensearch.geo.search.aggregations.bucket.geogrid.GeoGridAggregationBuilder;  
        assertThat(exception.getMessage(), containsString("[size] must be greater than 0. Found [0] in [" + AGG_NAME + "]"));  
                .addAggregation(AggregationBuilders.geohashGrid(AGG_NAME).field(GEO_POINT_FIELD_NAME).precision(precision))
        IllegalArgumentException exception = expectThrows(  
                long bucketCount = cell.getDocCount();  
    @Override  
        prepareGeoShapeIndexForAggregations(random);
                smallestGeoHash = hash;
            final GeoPoint topRight = new GeoPoint(topLeft.getLat(), bottomRight.getLon());  
            final String hash = Geohash.stringEncode(geoPoint.getLon(), geoPoint.getLat(), precision);
    @Override
                    // move in East direction
    public void testGeoShapes() {
                final String geohash = cell.getKeyAsString();
                .addAggregation(AggregationBuilders.geohashGrid(AGG_NAME).field(GEO_POINT_FIELD_NAME).precision(precision))  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                )
            String startingRowGeoHash = currentGeoHash;
            }
            if ((smallestGeoHash == null) || (hash.length() < smallestGeoHash.length())) {  
                    }
/*
            String currentGeoHash = Geohash.stringEncode(topLeft.getLon(), topLeft.getLat(), precision);
        GeoBoundingBoxQueryBuilder bbox = new GeoBoundingBoxQueryBuilder(GEO_POINT_FIELD_NAME);
                String geohash = cell.getKeyAsString();
    protected Set<String> generateBucketsForGeometry(final Geometry geometry, final GeoShapeDocValue geometryDocValue) {
import org.opensearch.geometry.Geometry;  
            assertSearchResponse(response);
            Object[] propertiesKeys = (Object[]) ((InternalAggregation) geoGrid).getProperty("_key");
            }  
            GeoGrid geoGrid = response.getAggregations().get(AGG_NAME);  
        Set<String> buckets = new HashSet<>();  
                int expectedBucketCount = expectedDocCountsForSingleGeoPoint.get(geohash);  
                    currentGeoHash = Geohash.getNeighbor(currentGeoHash, precision, 1, 0);  
        for (int precision = 1; precision <= PRECISION; precision++) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertSearchResponse(response);
    }
                )
    }
                if (currentGeoHash.equals(terminatingGeoHash)) {
                assertNotSame(bucketCount, 0);
                final GeoPoint geoPoint = (GeoPoint) propertiesKeys[i];
    protected Set<String> generateBucketsForGeoPoint(final GeoPoint geoPoint) {
                GeoGrid.Bucket cell = buckets.get(i);
 * the Apache License, Version 2.0 (the "License"); you may
                if (geometryDocValue.isIntersectingRectangle(currentRectangle)) {
                if (currentGeoHash.equals(endGeoHashForCurrentRow)) {
                assertNotSame(bucketCount, 0);
import java.util.Set;  
                assertNotSame(bucketCount, 0);  
                .get()
    }  
@OpenSearchIntegTestCase.SuiteScopeTestCase
import org.opensearch.geo.search.aggregations.bucket.geogrid.GeoGrid;
            for (GeoGrid.Bucket cell : geoGrid.getBuckets()) {  
            // This makes sure that for only higher precision we are providing the GeoBounding Box. This also ensures
    public void testPartiallyUnmapped() {  
            SearchResponse response = client().prepareSearch("multi_valued_idx")
                assertThat(stringEncode(geoPoint.lon(), geoPoint.lat(), precision), equalTo(geohash));
        for (int precision = 1; precision <= MAX_PRECISION_FOR_GEO_SHAPES_AGG_TESTING; precision++) {  
            buckets.add(hash);  
    private static final String AGG_NAME = "geohashgrid";
            GeoGrid geoGrid = response.getAggregations().get(AGG_NAME);
    }
            () -> client().prepareSearch("idx")
        // Creating a BB for limiting the number buckets generated during aggregation
import org.opensearch.test.OpenSearchIntegTestCase;  
 * not use this file except in compliance with the License.
    }
            SearchResponse response = client().prepareSearch("idx")
    public void testTopMatch() {
        for (int precision = 1; precision <= PRECISION; precision++) {  
                .get();
                builder.setGeoBoundingBox(boundingBox);
            // that we are able to test both bounded and unbounded aggregations  
    public void testSizeIsZero() {  
            }  
    }
import java.util.List;
        assertThat(exception.getMessage(), containsString("[shardSize] must be greater than 0. Found [0] in [" + AGG_NAME + "]"));  
        );
            if (precision > MIN_PRECISION_WITHOUT_BB_AGGS && isIntersectingWithBoundingRectangle == false) {  
        }  
            }
                assertEquals("Geohash " + geohash + " has wrong doc count ", expectedBucketCount, bucketCount);
            assertSearchResponse(response);
            // Check we only have one bucket with the best match for that resolution
        for (int precision = 1; precision <= PRECISION; precision++) {
                .get();  
            for (GeoGrid.Bucket cell : geoGrid.getBuckets()) {
        );
            new GeoPoint(boundingRectangleForGeoShapesAgg.getMaxLat(), boundingRectangleForGeoShapesAgg.getMinLon()),  
        for (int precision = 1; precision <= PRECISION; precision++) {
        bbox.setCorners(smallestGeoHash).queryName("bbox");
 * You may obtain a copy of the License at  
            for (GeoGrid.Bucket cell : geoGrid.getBuckets()) {
            GeoGrid geoGrid = response.getAggregations().get(AGG_NAME);  
                        expectedBucketCount = Math.max(expectedBucketCount, cursor.getValue());  
                .get()
            new GeoPoint(boundingRectangleForGeoShapesAgg.getMinLat(), boundingRectangleForGeoShapesAgg.getMaxLon())
import java.util.HashSet;  
            SearchResponse response = client().prepareSearch("idx")
        final int shardSize = 0;
            }
 * KIND, either express or implied.  See the License for the
                final long bucketCount = cell.getDocCount();
                long bucketCount = cell.getDocCount();
        Random random = random();
                    startingRowGeoHash = currentGeoHash;
        prepareMultiValuedGeoPointIndex(random);  
import org.opensearch.geo.search.aggregations.common.GeoBoundsHelper;
            for (GeoGrid.Bucket cell : geoGrid.getBuckets()) {  
                    AggregationBuilders.geohashGrid(AGG_NAME).field(GEO_POINT_FIELD_NAME).size(1).shardSize(100).precision(precision)  
                .addAggregation(AggregationBuilders.geohashGrid(AGG_NAME).field(GEO_POINT_FIELD_NAME).size(size).shardSize(shardSize))  
            final List<? extends GeoGrid.Bucket> buckets = geoGrid.getBuckets();  
            assertSearchResponse(response);  
        assert geometry != null;
import java.util.Random;
        super(dynamicSettings);
        final Set<String> geoHashes = new HashSet<>();  
 * SPDX-License-Identifier: Apache-2.0
                assertThat(stringEncode(geoPoint.lon(), geoPoint.lat(), precision), equalTo(geohash));  
            () -> client().prepareSearch("idx")
            }
                assertEquals("Geohash " + geohash + " has wrong doc count ", expectedBucketCount, bucketCount);
                assertEquals("Geohash " + geohash + " has wrong doc count ", expectedBucketCount, bucketCount);
import org.opensearch.common.geo.GeoShapeDocValue;  
                String geohash = cell.getKeyAsString();
        }
        }  
    public void testUnmapped() {
    }
                final GeoGrid.Bucket cell = buckets.get(i);
 * specific language governing permissions and limitations
import static org.opensearch.geometry.utils.Geohash.stringEncode;  
        }
        for (int precision = PRECISION; precision > 0; precision--) {
        final int shardSize = 10000;
 * Unless required by applicable law or agreed to in writing,
                int expectedBucketCount = expectedDocCountsForSingleGeoPoint.get(geohash);
import static org.opensearch.geometry.utils.Geohash.PRECISION;
                    geoHashes.add(currentGeoHash);
                assertEquals("Geohash " + geohash + " has wrong doc count ", expectedBucketCount, bucketCount);
 * ownership. Elasticsearch licenses this file to you under  
                final int expectedBucketCount = expectedDocsCountForGeoShapes.get(geohash);
                assertTrue("Buckets must be filtered", geohash.startsWith(smallestGeoHash));  
/*  
                assertNotSame(bucketCount, 0);  
                assertThat((long) propertiesDocCounts[i], equalTo(bucketCount));
        }
            assertThat(geoGrid.getBuckets().size(), equalTo(1));
            IllegalArgumentException.class,
import org.opensearch.action.search.SearchResponse;  
    }  
import org.opensearch.geo.tests.common.AggregationBuilders;
import java.util.HashMap;
        for (int precision = 1; precision <= PRECISION; precision++) {
                long bucketCount = cell.getDocCount();
 */
        }
    public void testMultivalued() {  
        prepareSingleValueGeoPointIndex(random);
                int expectedBucketCount = expectedDocCountsForSingleGeoPoint.get(geohash);
            }  
    public void testFiltered() {  
                long bucketCount = cell.getDocCount();  
                .addAggregation(AggregationBuilders.geohashGrid(AGG_NAME).field(GEO_POINT_FIELD_NAME).size(size).shardSize(shardSize))  
            final GeoGrid geoGrid = response.getAggregations().get(AGG_NAME);
        }  
    public GeoHashGridIT(Settings dynamicSettings) {
        final boolean isIntersectingWithBoundingRectangle = geometryDocValue.isIntersectingRectangle(boundingRectangleForGeoShapesAgg);
            for (int i = 0; i < buckets.size(); i++) {  
        return geoHashes;
            GeoGrid geoGrid = response.getAggregations().get(AGG_NAME);  
import org.opensearch.common.settings.Settings;
            GeoGrid geoGrid = response.getAggregations().get(AGG_NAME);  
