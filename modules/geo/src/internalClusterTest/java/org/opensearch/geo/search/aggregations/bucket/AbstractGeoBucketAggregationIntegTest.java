     * {@link AbstractGeoBucketAggregationIntegTest#generateBucketsForGeometry} in the test class for creating the  
    @Override
    protected double getRadiusOfBoundingBox() {
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
     * @return double  
    /**
}
import java.util.HashSet;  
        final List<IndexRequestBuilder> cities = new ArrayList<>();
     * @return {@link Rectangle}  
     * Returns a radius for the Bounding box. Test classes can override this method to change the radius of BBox for  
    }  
     * IndexOutOfBoundsExceptions.
     * @param geoShapeDocValue {@link GeoShapeDocValue}  
    protected abstract Set<String> generateBucketsForGeoPoint(final GeoPoint geoPoint);
            final List<String> points = new ArrayList<>();
     *
     * @param geometry {@link Geometry} the Geometry to be indexed
     */
            .build();  
        return client().prepareIndex(index).setSource(source);  
    }
     * @param random {@link Random}  
     * @param latLon {@link String} representing the String representation of GeoPoint  
     * @param geoPoint {@link GeoPoint}
                if (!isShapeIntersectingBB && i == NUM_DOCS - 1) {  
import org.opensearch.action.index.IndexRequestBuilder;  
     * @param random {@link Random}
     * @param geoPoint {@link GeoPoint}  
    protected abstract Set<String> generateBucketsForGeometry(final Geometry geometry, final GeoShapeDocValue geoShapeDocValue);  
import org.opensearch.test.VersionUtils;
                expectedDocsCountForGeoShapes.put(hash, expectedDocsCountForGeoShapes.getOrDefault(hash, 0) + 1);  
    protected void prepareSingleValueGeoPointIndex(final Random random) throws Exception {
            for (final String bucket : buckets) {
                final GeoPoint geoPoint = RandomGeoGenerator.randomPoint(random);  
            cities.add(indexGeoPoints("multi_valued_idx", Integer.toString(i), points));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
     * @param latLon {@link List} of {@link String} representing the String representation of GeoPoint
import org.opensearch.Version;
     * @return {@link GeoPoint}
     * Indexes a {@link List} of {@link GeoPoint}s in the provided Index name.
     * stored.
     * different techniques for creating buckets. Override the method
 * across other integration test too then this is not the class. Use {@link GeoModulePluginIntegTestCase}  
import java.util.Map;
            }
    /**
     * @throws Exception thrown during indexing.  
        ensureGreen("idx_unmapped", "idx");
    /**  
        assertAcked(prepareCreate(GEO_SHAPE_INDEX_NAME).setSettings(settings).setMapping(GEO_SHAPE_FIELD_NAME, "type" + "=geo_shape"));
            final Set<String> buckets = generateBucketsForGeoPoint(geoPoint);
    }
 * This is the base class for all the Bucket Aggregation related integration tests. Use this class to add common
import org.opensearch.core.xcontent.XContentBuilder;
    }
/**  
        final List<IndexRequestBuilder> cities = new ArrayList<>();
import java.util.Random;  
            }  
        return RandomGeoGeometryGenerator.randomRectangle(random, radius);
     * @param name {@link String} value for the string field in index  
    /**
    protected static Rectangle boundingRectangleForGeoShapesAgg;  
import org.opensearch.common.geo.GeoPoint;
import java.util.HashMap;
                multiValuedExpectedDocCountsGeoPoint.put(bucket, multiValuedExpectedDocCountsGeoPoint.getOrDefault(bucket, 0) + 1);  
            final int numPoints = random.nextInt(4);
import org.opensearch.common.settings.Settings;
     * @throws Exception thrown during indexing.
     * @throws Exception thrown during index creation.  
     */  
    }
    protected IndexRequestBuilder indexGeoPoint(final String index, final String name, final String latLon) throws Exception {
public abstract class AbstractGeoBucketAggregationIntegTest extends GeoModulePluginIntegTestCase {
            final GeoShapeDocValue geometryDocValue = GeoShapeDocValue.createGeometryDocValue(geometry);
     * Prepares a GeoPoint index for testing the GeoPoint bucket aggregations. Different bucket aggregations can use  
    /**  
 *
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        for (int i = 0; i < NUM_DOCS; i++) {  
            geoshapes.add(indexGeoShape(GEO_SHAPE_INDEX_NAME, geometry));
        );
        return indexGeoPoints(index, name, List.of(latLon));
    protected boolean forbidPrivateIndexSettings() {
        ensureGreen(GEO_SHAPE_INDEX_NAME);
     * @return {@link IndexRequestBuilder}
            final Set<String> buckets = new HashSet<>();  
     * the test cases. If we increase this value, it will lead to creation of a lot of buckets that can lead of
        );
     * Indexes a GeoShape in the provided index.
        }  
     */
import org.opensearch.geo.tests.common.RandomGeoGenerator;
 * The OpenSearch Contributors require contributions made to  
            // generate random point
        return 5.0;  
import org.opensearch.geo.tests.common.RandomGeoGeometryGenerator;
     */
    protected void prepareMultiValuedGeoPointIndex(final Random random) throws Exception {
                expectedDocCountsForSingleGeoPoint.put(bucket, expectedDocCountsForSingleGeoPoint.getOrDefault(bucket, 0) + 1);  
    protected static final int MAX_PRECISION_FOR_GEO_SHAPES_AGG_TESTING = 2;
     * aggregations.  
        boolean isShapeIntersectingBB = false;
                    continue;
            final GeoPoint geoPoint = RandomGeoGenerator.randomPoint(random);
     */
            for (final String bucket : buckets) {
     * @throws Exception thrown during index creation.
            prepareCreate("multi_valued_idx").setSettings(settings)  
        indexRandom(true, cities);  
 * compatible open source license.
    protected Rectangle getGridAggregationBoundingBox(final Random random) {
        source = source.field(GEO_SHAPE_FIELD_NAME, WKT.toWKT(geometry));
        final double radius = getRadiusOfBoundingBox();  
     * @param index {@link String} index name
        final Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();  
            for (final String hash : values) {
 * this file be licensed under the Apache-2.0 license or a
     */
    /**
    /**
                .setMapping(GEO_POINT_FIELD_NAME, "type=geo_point", KEYWORD_FIELD_NAME, "type=keyword")  
        source = source.endObject();
        expectedDocsCountForGeoShapes = new HashMap<>();
    protected static final int NUM_DOCS = 100;
        createIndex("idx_unmapped");
        source = source.endObject();
        );
/*  
        if (latLon != null) {
        expectedDocCountsForSingleGeoPoint = new HashMap<>();  
        ensureGreen("multi_valued_idx");
            }  
     * @return {@link IndexRequestBuilder}
    public AbstractGeoBucketAggregationIntegTest(Settings dynamicSettings) {  
                isShapeIntersectingBB = geometryDocValue.isIntersectingRectangle(boundingRectangleForGeoShapesAgg);
                }
        final Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
    }
        XContentBuilder source = jsonBuilder().startObject().field(KEYWORD_FIELD_NAME, name);  
        indexRandom(true, geoshapes);  
    protected static Map<String, Integer> expectedDocsCountForGeoShapes;
            .put("index.number_of_shards", 4)
     * aggregation results.
    }  
import java.util.List;
        assertAcked(
     * @throws Exception thrown during creation of {@link IndexRequestBuilder}  
            GeoEncodingUtils.decodeLatitude(GeoEncodingUtils.encodeLatitude(geoPoint.getLat())),
                .setMapping(GEO_POINT_FIELD_NAME, "type=geo_point", KEYWORD_FIELD_NAME, "type=keyword")
    protected static Map<String, Integer> multiValuedExpectedDocCountsGeoPoint;  
            // make sure that there is 1 shape is intersecting with the bounding box  
    protected static Map<String, Integer> expectedDocCountsForSingleGeoPoint;
     * Generates a Bounding Box of a fixed radius that can be used for shapes aggregations to reduce the size of  
import org.opensearch.geo.GeoModulePluginIntegTestCase;  
    protected IndexRequestBuilder indexGeoShape(final String index, final Geometry geometry) throws Exception {
    /**
                points.add(geoPoint.getLat() + "," + geoPoint.getLon());
     * @param name {@link String} value for the string field in index
     * buckets which will then be used for verifications.  
    protected static final String GEO_POINT_FIELD_NAME = "location";
import java.util.Set;
            final Geometry geometry = RandomGeoGeometryGenerator.randomGeometry(random);
            final Set<String> values = generateBucketsForGeometry(geometry, geometryDocValue);  
        final Settings settings = Settings.builder()
     */
    protected static final int MIN_PRECISION_WITHOUT_BB_AGGS = 2;  
     * @param random {@link Random}
        indexRandom(true, cities);  
        for (int i = 0; i < NUM_DOCS; i++) {  
        return client().prepareIndex(index).setSource(source);
     * @return {@link IndexRequestBuilder}
        super(dynamicSettings);
     * buckets which will then be used for verifications.
        return new GeoPoint(
     */
            if (!isShapeIntersectingBB) {
 */
     * @return A {@link Set} of {@link String} which represents the buckets.  
    protected static String smallestGeoHash = null;
        final List<IndexRequestBuilder> geoshapes = new ArrayList<>();  
    }
     * @param geometry         {@link Geometry}
            .put("index.number_of_replicas", 0)
import org.opensearch.common.geo.GeoShapeDocValue;  
     *
        }
     * different techniques for creating buckets. Override the method
    protected static final String KEYWORD_FIELD_NAME = "city";  
    }
import java.util.ArrayList;
import org.apache.lucene.geo.GeoEncodingUtils;
    }  
 * SPDX-License-Identifier: Apache-2.0
    protected void prepareGeoShapeIndexForAggregations(final Random random) throws Exception {  
     * @param index {@link String} index name
        assertAcked(
import org.opensearch.geometry.Rectangle;
            prepareCreate("idx").setSettings(settings)
    protected GeoPoint toStoragePrecision(final GeoPoint geoPoint) {  
            cities.add(indexGeoPoint("idx", geoPoint.toString(), geoPoint.getLat() + ", " + geoPoint.getLon()));  
     * Encode and Decode the {@link GeoPoint} to get a {@link GeoPoint} which has the exact precision which is being
     * Prepares a GeoShape index for testing the GeoShape bucket aggregations. Different bucket aggregations can use
    protected static final String GEO_SHAPE_INDEX_NAME = "geoshape_index";
     * @return A {@link Set} of {@link String} which represents the buckets.
        }
        assertTrue("The radius of Bounding Box is less than or equal to 0", radius > 0);
    /**
            }
     *
     * Returns a set of buckets for the GeoPoint at different precision level. Override this method for different bucket
        return false;  
     * aggregations.  
        }
     * {@link AbstractGeoBucketAggregationIntegTest#generateBucketsForGeoPoint} in the test class for creating the
                // generate random point
 * methods which can be used across different bucket aggregations. If there is any common code that can be used
    /**  
                buckets.addAll(generateBucketsForGeoPoint(geoPoint));
     * Indexes a {@link GeoPoint} in the provided Index name.  
package org.opensearch.geo.search.aggregations.bucket;
     */
    protected static final String GEO_SHAPE_FIELD_NAME = "location_geo_shape";
 */  
    }
            }
            GeoEncodingUtils.decodeLongitude(GeoEncodingUtils.encodeLongitude(geoPoint.getLon()))  
     * Returns a set of buckets for the shape at different precision level. Override this method for different bucket
    protected IndexRequestBuilder indexGeoPoints(final String index, final String name, final List<String> latLon) throws Exception {
import org.opensearch.geometry.Geometry;  
     *
    protected final Version version = VersionUtils.randomIndexCompatibleVersion(random());
            for (int j = 0; j < numPoints; ++j) {
        XContentBuilder source = jsonBuilder().startObject();  
            i++;
import org.opensearch.cluster.metadata.IndexMetadata;
     */
            source = source.field(GEO_POINT_FIELD_NAME, latLon);
        multiValuedExpectedDocCountsGeoPoint = new HashMap<>();
        for (int i = 0; i < NUM_DOCS;) {  
     * @param index {@link String} index name  
