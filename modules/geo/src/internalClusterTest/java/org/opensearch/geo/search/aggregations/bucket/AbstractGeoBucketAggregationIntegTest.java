     * @param random {@link Random}
package org.opensearch.geo.search.aggregations.bucket;
     * Returns a set of buckets for the shape at different precision level. Override this method for different bucket
     * @return double
        return new GeoPoint(
    /**
        createIndex("idx_unmapped");
import org.opensearch.cluster.metadata.IndexMetadata;
        multiValuedExpectedDocCountsGeoPoint = new HashMap<>();
import java.util.HashMap;
 */
     * @throws Exception thrown during creation of {@link IndexRequestBuilder}
            .put("index.number_of_replicas", 0)
        assertAcked(
        return RandomGeoGeometryGenerator.randomRectangle(random, radius);
     * @throws Exception thrown during index creation.
import java.util.Map;
        final Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
    protected double getRadiusOfBoundingBox() {
    protected static Map<String, Integer> expectedDocCountsForSingleGeoPoint;
    }
    }
        assertAcked(
        ensureGreen(GEO_SHAPE_INDEX_NAME);
                .setMapping(GEO_POINT_FIELD_NAME, "type=geo_point", KEYWORD_FIELD_NAME, "type=keyword")
import java.util.List;
    protected IndexRequestBuilder indexGeoShape(final String index, final Geometry geometry) throws Exception {
     * @param geoPoint {@link GeoPoint}
    }
import org.opensearch.geometry.Geometry;
    protected static String smallestGeoHash = null;
    }
    protected Rectangle getGridAggregationBoundingBox(final Random random) {
            for (final String bucket : buckets) {
     * @param latLon {@link List} of {@link String} representing the String representation of GeoPoint
                isShapeIntersectingBB = geometryDocValue.isIntersectingRectangle(boundingRectangleForGeoShapesAgg);
        );
            GeoEncodingUtils.decodeLongitude(GeoEncodingUtils.encodeLongitude(geoPoint.getLon()))
     * different techniques for creating buckets. Override the method
            final GeoPoint geoPoint = RandomGeoGenerator.randomPoint(random);
    protected static final String GEO_POINT_FIELD_NAME = "location";
                expectedDocsCountForGeoShapes.put(hash, expectedDocsCountForGeoShapes.getOrDefault(hash, 0) + 1);
 * across other integration test too then this is not the class. Use {@link GeoModulePluginIntegTestCase}
     */
     * @param geoPoint {@link GeoPoint}
     * @return {@link IndexRequestBuilder}
     * aggregations.
    }
     * @return A {@link Set} of {@link String} which represents the buckets.
    protected static Map<String, Integer> multiValuedExpectedDocCountsGeoPoint;
    @Override
     * @return A {@link Set} of {@link String} which represents the buckets.
        source = source.endObject();
     * @param index {@link String} index name
    }
    }
    protected GeoPoint toStoragePrecision(final GeoPoint geoPoint) {
    }
     * {@link AbstractGeoBucketAggregationIntegTest#generateBucketsForGeoPoint} in the test class for creating the
    protected void prepareGeoShapeIndexForAggregations(final Random random) throws Exception {
 * this file be licensed under the Apache-2.0 license or a
     * @param geoShapeDocValue {@link GeoShapeDocValue}
     * aggregations.
import org.opensearch.geo.tests.common.RandomGeoGenerator;
     * IndexOutOfBoundsExceptions.
     * @param random {@link Random}
    protected boolean forbidPrivateIndexSettings() {
            }
        final Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
        final List<IndexRequestBuilder> cities = new ArrayList<>();
            .put("index.number_of_shards", 4)
import java.util.Set;
    protected static final String KEYWORD_FIELD_NAME = "city";
    protected static final String GEO_SHAPE_INDEX_NAME = "geoshape_index";
    protected IndexRequestBuilder indexGeoPoints(final String index, final String name, final List<String> latLon) throws Exception {
import org.opensearch.action.index.IndexRequestBuilder;
     */
            geoshapes.add(indexGeoShape(GEO_SHAPE_INDEX_NAME, geometry));
            prepareCreate("idx").setSettings(settings)
        }
     * Returns a set of buckets for the GeoPoint at different precision level. Override this method for different bucket
            final Geometry geometry = RandomGeoGeometryGenerator.randomGeometry(random);
        return client().prepareIndex(index).setSource(source);
    /**
            // generate random point
     * Indexes a GeoShape in the provided index.
     *
        for (int i = 0; i < NUM_DOCS; i++) {
     * @throws Exception thrown during indexing.
     * @return {@link IndexRequestBuilder}
            cities.add(indexGeoPoints("multi_valued_idx", Integer.toString(i), points));
        assertTrue("The radius of Bounding Box is less than or equal to 0", radius > 0);
    /**
    protected static final int MAX_PRECISION_FOR_GEO_SHAPES_AGG_TESTING = 2;
        assertAcked(prepareCreate(GEO_SHAPE_INDEX_NAME).setSettings(settings).setMapping(GEO_SHAPE_FIELD_NAME, "type" + "=geo_shape"));
                buckets.addAll(generateBucketsForGeoPoint(geoPoint));
        final Settings settings = Settings.builder()
    protected static Map<String, Integer> expectedDocsCountForGeoShapes;
        indexRandom(true, cities);
     * the test cases. If we increase this value, it will lead to creation of a lot of buckets that can lead of
     * Prepares a GeoShape index for testing the GeoShape bucket aggregations. Different bucket aggregations can use
        indexRandom(true, cities);
                    continue;
    protected abstract Set<String> generateBucketsForGeometry(final Geometry geometry, final GeoShapeDocValue geoShapeDocValue);
import org.opensearch.geo.tests.common.RandomGeoGeometryGenerator;
        XContentBuilder source = jsonBuilder().startObject();
     * @param index {@link String} index name
     * Encode and Decode the {@link GeoPoint} to get a {@link GeoPoint} which has the exact precision which is being
     * @throws Exception thrown during indexing.
    protected static final int MIN_PRECISION_WITHOUT_BB_AGGS = 2;
     * different techniques for creating buckets. Override the method
import org.opensearch.geo.GeoModulePluginIntegTestCase;
     */
    protected void prepareMultiValuedGeoPointIndex(final Random random) throws Exception {
     */
            for (final String bucket : buckets) {
import org.opensearch.common.geo.GeoShapeDocValue;
        super(dynamicSettings);
     * @param geometry         {@link Geometry}
 */
     * @return {@link GeoPoint}
                .setMapping(GEO_POINT_FIELD_NAME, "type=geo_point", KEYWORD_FIELD_NAME, "type=keyword")
import org.apache.lucene.geo.GeoEncodingUtils;
     * @return {@link IndexRequestBuilder}
            final int numPoints = random.nextInt(4);
        return client().prepareIndex(index).setSource(source);
     *
     * @param name {@link String} value for the string field in index
        expectedDocsCountForGeoShapes = new HashMap<>();
     */
            }
 *
     *
     * @param random {@link Random}
            .build();
    /**
    protected static final int NUM_DOCS = 100;
     * Indexes a {@link List} of {@link GeoPoint}s in the provided Index name.
            GeoEncodingUtils.decodeLatitude(GeoEncodingUtils.encodeLatitude(geoPoint.getLat())),
     */
 * SPDX-License-Identifier: Apache-2.0
                // generate random point
     * Generates a Bounding Box of a fixed radius that can be used for shapes aggregations to reduce the size of
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            }
     * @throws Exception thrown during index creation.
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    /**
    protected IndexRequestBuilder indexGeoPoint(final String index, final String name, final String latLon) throws Exception {
        }
public abstract class AbstractGeoBucketAggregationIntegTest extends GeoModulePluginIntegTestCase {
     * {@link AbstractGeoBucketAggregationIntegTest#generateBucketsForGeometry} in the test class for creating the
            i++;
        indexRandom(true, geoshapes);
     * @return {@link Rectangle}
        source = source.field(GEO_SHAPE_FIELD_NAME, WKT.toWKT(geometry));
    }
    public AbstractGeoBucketAggregationIntegTest(Settings dynamicSettings) {
        return false;
     * @param index {@link String} index name
     */
 * compatible open source license.
    /**
     * Prepares a GeoPoint index for testing the GeoPoint bucket aggregations. Different bucket aggregations can use
        }
            // make sure that there is 1 shape is intersecting with the bounding box
    }
     * @param name {@link String} value for the string field in index
 * The OpenSearch Contributors require contributions made to
     * Indexes a {@link GeoPoint} in the provided Index name.
     *
import java.util.Random;
            }
    }
                points.add(geoPoint.getLat() + "," + geoPoint.getLon());
            final List<String> points = new ArrayList<>();
/**
     * buckets which will then be used for verifications.
            cities.add(indexGeoPoint("idx", geoPoint.toString(), geoPoint.getLat() + ", " + geoPoint.getLon()));
    /**
     */
                if (!isShapeIntersectingBB && i == NUM_DOCS - 1) {
     * aggregation results.
     * buckets which will then be used for verifications.
            prepareCreate("multi_valued_idx").setSettings(settings)
        expectedDocCountsForSingleGeoPoint = new HashMap<>();
        final List<IndexRequestBuilder> geoshapes = new ArrayList<>();
        XContentBuilder source = jsonBuilder().startObject().field(KEYWORD_FIELD_NAME, name);
/*
    protected final Version version = VersionUtils.randomIndexCompatibleVersion(random());
        for (int i = 0; i < NUM_DOCS; i++) {
        final List<IndexRequestBuilder> cities = new ArrayList<>();
            }
    protected abstract Set<String> generateBucketsForGeoPoint(final GeoPoint geoPoint);
                final GeoPoint geoPoint = RandomGeoGenerator.randomPoint(random);
            for (final String hash : values) {
import org.opensearch.geometry.Rectangle;
        source = source.endObject();
     * Returns a radius for the Bounding box. Test classes can override this method to change the radius of BBox for
            final Set<String> values = generateBucketsForGeometry(geometry, geometryDocValue);
            for (int j = 0; j < numPoints; ++j) {
        return 5.0;
    /**
}
            source = source.field(GEO_POINT_FIELD_NAME, latLon);
import org.opensearch.common.settings.Settings;
    protected static Rectangle boundingRectangleForGeoShapesAgg;
                expectedDocCountsForSingleGeoPoint.put(bucket, expectedDocCountsForSingleGeoPoint.getOrDefault(bucket, 0) + 1);
        ensureGreen("idx_unmapped", "idx");
    /**
import org.opensearch.test.VersionUtils;
import org.opensearch.core.xcontent.XContentBuilder;
                }
        return indexGeoPoints(index, name, List.of(latLon));
     * stored.
    protected static final String GEO_SHAPE_FIELD_NAME = "location_geo_shape";
import java.util.HashSet;
     */
     * @param latLon {@link String} representing the String representation of GeoPoint
            final Set<String> buckets = generateBucketsForGeoPoint(geoPoint);
import org.opensearch.Version;
        boolean isShapeIntersectingBB = false;
    protected void prepareSingleValueGeoPointIndex(final Random random) throws Exception {
        }
            final Set<String> buckets = new HashSet<>();
        );
    /**
import org.opensearch.common.geo.GeoPoint;
        for (int i = 0; i < NUM_DOCS;) {
        if (latLon != null) {
        ensureGreen("multi_valued_idx");
 * This is the base class for all the Bucket Aggregation related integration tests. Use this class to add common
            if (!isShapeIntersectingBB) {
import java.util.ArrayList;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                multiValuedExpectedDocCountsGeoPoint.put(bucket, multiValuedExpectedDocCountsGeoPoint.getOrDefault(bucket, 0) + 1);
        );
        final double radius = getRadiusOfBoundingBox();
            final GeoShapeDocValue geometryDocValue = GeoShapeDocValue.createGeometryDocValue(geometry);
     */
     * @param geometry {@link Geometry} the Geometry to be indexed
 * methods which can be used across different bucket aggregations. If there is any common code that can be used
