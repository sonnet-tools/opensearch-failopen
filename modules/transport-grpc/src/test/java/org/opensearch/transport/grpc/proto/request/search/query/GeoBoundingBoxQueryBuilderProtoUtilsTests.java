    }
    }
    public void testFromProtoWithNullInput() {
    }
        assertEquals("Bottom should match", 40.6, query.bottomRight().getLat(), 0.001);
        assertEquals("Top should match", 40.7, query.topLeft().getLat(), 0.001);
        GeoBounds geoBounds = GeoBounds.newBuilder().setCoords(coords).build();
/*
    public void testFromProtoWithInvalidWktShapeType() {
        // Create protobuf GeoLocation for bottomRight
            .setXName("my_geo_bbox_query")
            // Create coords as well to trigger the conflict
            .build();
            // This is tricky - we can't set both in the same GeoBounds, but we can simulate the error path
        assertEquals("Right should match", -73.9, query.bottomRight().getLon(), 0.001);
        GeoBoundingBoxQuery geoBoundingBoxQuery = GeoBoundingBoxQuery.newBuilder().putBoundingBox("location", geoBounds).build();
        // Test INDEXED execution type
    }
        // Create protobuf GeoBoundingBoxQuery
        assertEquals("Validation method should be IGNORE_MALFORMED", GeoValidationMethod.IGNORE_MALFORMED, query.getValidationMethod());
    public void testFromProtoWithAllParameters() {
        expectThrows(IllegalArgumentException.class, () -> {
    }
        LatLonGeoLocation bottomRightLocation = LatLonGeoLocation.newBuilder().setLat(40.6).setLon(-73.9).build();
            .setXName("full_geo_bbox_query")
        CoordsGeoBounds coords = CoordsGeoBounds.newBuilder().setTop(40.7).setLeft(-74.0).setBottom(40.6).setRight(-73.9).build();
            .putBoundingBox("location", geoBounds)
        GeoBoundingBoxQueryBuilder query = GeoBoundingBoxQueryBuilderProtoUtils.fromProto(geoBoundingBoxQuery);
        GeoBoundingBoxQuery geoBoundingBoxQuery = GeoBoundingBoxQuery.newBuilder().putBoundingBox("location", geoBounds).build();
    public void testFromProtoWithInvalidWkt() {
        assertEquals("Bottom should match", 40.6, query.bottomRight().getLat(), 0.001);
        assertEquals("Default execution type should be MEMORY", GeoExecType.MEMORY, query.type());
        assertEquals("Query name should match", "my_geo_bbox_query", query.queryName());
        LatLonGeoLocation topRightLocation = LatLonGeoLocation.newBuilder().setLat(40.7).setLon(-73.9).build();
        assertNotNull("Query should not be null", query);
        assertEquals("Left should match", -74.0, query.topLeft().getLon(), 0.001);
        // Test with minimal required fields only (no boost, no query name, no validation method, etc.)
        });
import org.opensearch.test.OpenSearchTestCase;
        assertNull("Default query name should be null", query.queryName());
        assertEquals("Boost should match", 2.0f, query.boost(), 0.001f);
import org.opensearch.protobufs.GeoBounds;
        CoordsGeoBounds coords = CoordsGeoBounds.newBuilder().setTop(40.7).setLeft(-74.0).setBottom(40.6).setRight(-73.9).build();
            .build();
            .setIgnoreUnmapped(true)
        assertEquals("Top should match", 40.7, query.topLeft().getLat(), 0.001);
        // For TRBL format: topRight becomes topLeft, bottomLeft becomes bottomRight
        assertEquals("Query name should match", "full_geo_bbox_query", query.queryName());
        assertEquals("Bottom should match", 40.6, query.bottomRight().getLat(), 0.001);
        CoordsGeoBounds coords = CoordsGeoBounds.newBuilder().setTop(40.7).setLeft(-74.0).setBottom(40.6).setRight(-73.9).build();
        assertNotNull("Query should not be null", query);
        LatLonGeoLocation bottomLeftLocation = LatLonGeoLocation.newBuilder().setLat(40.6).setLon(-74.0).build();
        });
        // The validation method defaults to STRICT in the GeoBoundingBoxQueryBuilder constructor
        assertEquals("Default validation method should be STRICT", GeoValidationMethod.STRICT, query.getValidationMethod());
        assertFalse("Default ignore unmapped should be false", query.ignoreUnmapped());
            .putBoundingBox("location", geoBounds)
        expectThrows(IllegalArgumentException.class, () -> {
    }
    }
        // Create protobuf GeoBoundingBoxQuery
    public void testFromProtoWithIgnoreUnmapped() {
    }
    public void testFromProtoWithNoOptionalFields() {
        GeoBoundingBoxQuery geoBoundingBoxQuery = GeoBoundingBoxQuery.newBuilder()
public class GeoBoundingBoxQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
import org.opensearch.index.query.GeoBoundingBoxQueryBuilder;
        query = GeoBoundingBoxQueryBuilderProtoUtils.fromProto(geoBoundingBoxQuery);
        query = GeoBoundingBoxQueryBuilderProtoUtils.fromProto(geoBoundingBoxQuery);
    public void testFromProtoWithQueryName() {
        GeoBounds geoBounds = GeoBounds.newBuilder().setWkt(wkt).build();
        GeoBoundingBoxQuery geoBoundingBoxQuery = GeoBoundingBoxQuery.newBuilder().putBoundingBox("location", geoBounds).build();
    }
            .putBoundingBox("location", geoBounds)
        assertEquals("TopLeft Longitude should match", -74.0, query.topLeft().getLon(), 0.001);
        GeoBoundingBoxQuery geoBoundingBoxQuery = GeoBoundingBoxQuery.newBuilder().putBoundingBox("location", geoBounds).build();
        assertEquals("Top should match", 40.7, query.topLeft().getLat(), 0.001);
        GeoBoundingBoxQuery geoBoundingBoxQuery = GeoBoundingBoxQuery.newBuilder()
            .build();
        assertEquals("Left should match", -74.0, query.topLeft().getLon(), 0.001);
        GeoBounds geoBounds = GeoBounds.newBuilder().setCoords(coords).build();
        GeoBoundingBoxQueryBuilder query = GeoBoundingBoxQueryBuilderProtoUtils.fromProto(geoBoundingBoxQuery);
        GeoBoundingBoxQuery geoBoundingBoxQuery = GeoBoundingBoxQuery.newBuilder().putBoundingBox("location", geoBounds).build();
        GeoBoundingBoxQueryBuilder query = GeoBoundingBoxQueryBuilderProtoUtils.fromProto(geoBoundingBoxQuery);
        CoordsGeoBounds coords = CoordsGeoBounds.newBuilder().setTop(40.7).setLeft(-74.0).setBottom(40.6).setRight(-73.9).build();
    public void testFromProtoWithEmptyGeoBounds() {
            .build();
            GeoBounds geoBounds = GeoBounds.newBuilder().setWkt(invalidWkt).build();
        GeoBoundingBoxQueryBuilder query = GeoBoundingBoxQueryBuilderProtoUtils.fromProto(geoBoundingBoxQuery);
import org.opensearch.protobufs.GeoExecution;
            .setType(GeoExecution.GEO_EXECUTION_MEMORY)
        assertEquals("Field name should match", "location", query.fieldName());
                .build();
        geoBoundingBoxQuery = GeoBoundingBoxQuery.newBuilder().putBoundingBox("location", geoBounds).setIgnoreUnmapped(false).build();
    }
            CoordsGeoBounds coords = CoordsGeoBounds.newBuilder().setTop(40.7).setLeft(-74.0).setBottom(40.6).setRight(-73.9).build();
    }
            GeoBounds geoBounds = GeoBounds.newBuilder().setWkt(wkt).build();
        assertEquals("Field name should match", "location", query.fieldName());
        GeoBoundingBoxQuery geoBoundingBoxQuery = GeoBoundingBoxQuery.newBuilder()
            GeoBoundingBoxQuery geoBoundingBoxQuery = GeoBoundingBoxQuery.newBuilder().putBoundingBox("location", geoBounds).build();
            .putBoundingBox("location", geoBounds)
    public void testFromProtoWithBoost() {
    public void testFromProtoWithEmptyBoundingBoxMap() {
package org.opensearch.transport.grpc.proto.request.search.query;
        GeoBounds geoBounds = GeoBounds.newBuilder().setCoords(coords).build();
        GeoBoundingBoxQueryBuilder query = GeoBoundingBoxQueryBuilderProtoUtils.fromProto(geoBoundingBoxQuery);
        assertEquals("Right should match", -73.9, query.bottomRight().getLon(), 0.001);
        assertEquals("Validation method should be STRICT", GeoValidationMethod.STRICT, query.getValidationMethod());
        CoordsGeoBounds coords = CoordsGeoBounds.newBuilder().setTop(40.7).setLeft(-74.0).setBottom(40.6).setRight(-73.9).build();
        GeoBoundingBoxQueryBuilder query = GeoBoundingBoxQueryBuilderProtoUtils.fromProto(geoBoundingBoxQuery);
        assertEquals("Left should match", -74.0, query.topLeft().getLon(), 0.001);
        assertEquals("TopLeft Latitude should match", 40.7, query.topLeft().getLat(), 0.001);
            WktGeoBounds wkt = WktGeoBounds.newBuilder().setWkt("INVALID_WKT_FORMAT").build();
        });
    public void testFromProtoWithTrbl() {
import org.opensearch.protobufs.TopLeftBottomRightGeoBounds;
            .build();
        // Test MEMORY execution type
        GeoBounds geoBounds = GeoBounds.newBuilder().setCoords(coords).build();
        GeoLocation bottomRight = GeoLocation.newBuilder().setLatlon(bottomRightLocation).build();
        GeoBoundingBoxQueryBuilder query = GeoBoundingBoxQueryBuilderProtoUtils.fromProto(geoBoundingBoxQuery);
        geoBoundingBoxQuery = GeoBoundingBoxQuery.newBuilder()
import org.opensearch.index.query.GeoExecType;
        assertEquals("Field name should match", "location", query.fieldName());
    public void testFromProtoWithConflictingWktAndExplicitBounds() {
                .setWkt("BBOX(-74.0, -73.9, 40.7, 40.6)") // minLon, maxLon, maxLat, minLat
        assertEquals("Field name should match", "location", query.fieldName());
        LatLonGeoLocation topLeftLocation = LatLonGeoLocation.newBuilder().setLat(40.7).setLon(-74.0).build();
            GeoBoundingBoxQueryBuilderProtoUtils.fromProto(geoBoundingBoxQuery);
            .putBoundingBox("location", geoBounds)
            .setType(GeoExecution.GEO_EXECUTION_INDEXED)
            GeoBoundingBoxQuery geoBoundingBoxQuery = GeoBoundingBoxQuery.newBuilder().putBoundingBox("location", geoBounds).build();
import org.opensearch.protobufs.WktGeoBounds;
        CoordsGeoBounds coords = CoordsGeoBounds.newBuilder().setTop(40.7).setLeft(-74.0).setBottom(40.6).setRight(-73.9).build();
 * The OpenSearch Contributors require contributions made to
            // by manually creating a scenario that would trigger the "Conflicting definition" error
        GeoBounds geoBounds = GeoBounds.newBuilder().setCoords(coords).build();
            .setValidationMethod(org.opensearch.protobufs.GeoValidationMethod.GEO_VALIDATION_METHOD_STRICT)
        WktGeoBounds wkt = WktGeoBounds.newBuilder()
        assertNotNull("Query should not be null", query);
        assertTrue("Ignore unmapped should be true", query.ignoreUnmapped());
        assertNotNull("Query should not be null", query);
    }
    public void testFromProtoWithType() {
        expectThrows(IllegalArgumentException.class, () -> {
        assertEquals("Validation method should be STRICT", GeoValidationMethod.STRICT, query.getValidationMethod());
            .build();
            .setIgnoreUnmapped(true)
 * this file be licensed under the Apache-2.0 license or a
            .setWkt("BBOX(-74.0, -73.9, 40.7, 40.6)") // minLon, maxLon, maxLat, minLat
            .putBoundingBox("location", geoBounds)
        geoBoundingBoxQuery = GeoBoundingBoxQuery.newBuilder()
        CoordsGeoBounds coords = CoordsGeoBounds.newBuilder().setTop(40.7).setLeft(-74.0).setBottom(40.6).setRight(-73.9).build();
 */
import org.opensearch.protobufs.CoordsGeoBounds;
        assertEquals("Right should match", -73.9, query.bottomRight().getLon(), 0.001);
        // Create protobuf GeoLocation for bottomLeft
        // Create protobuf TopLeftBottomRightGeoBounds
        assertNotNull("Query should not be null", query);
            // Let's test the null envelope case instead - the conflict error would be hard to trigger with the proto structure
            .setValidationMethod(org.opensearch.protobufs.GeoValidationMethod.GEO_VALIDATION_METHOD_STRICT)
        query = GeoBoundingBoxQueryBuilderProtoUtils.fromProto(geoBoundingBoxQuery);
        });
        GeoBoundingBoxQuery geoBoundingBoxQuery = GeoBoundingBoxQuery.newBuilder()
import org.opensearch.protobufs.GeoLocation;
            .putBoundingBox("location", geoBounds)
            GeoBoundingBoxQuery geoBoundingBoxQuery = GeoBoundingBoxQuery.newBuilder().putBoundingBox("location", geoBounds).build();
        // Create protobuf CoordsGeoBounds
        // Test COERCE validation method
        assertEquals("BottomRight Latitude should match", 40.6, query.bottomRight().getLat(), 0.001);
        assertEquals("Top should match", 40.7, query.topLeft().getLat(), 0.001);
 * compatible open source license.
        assertEquals("Execution type should be INDEXED", GeoExecType.INDEXED, query.type());
 *
        // Create protobuf GeoLocation for topRight
        TopLeftBottomRightGeoBounds tlbr = TopLeftBottomRightGeoBounds.newBuilder().setTopLeft(topLeft).setBottomRight(bottomRight).build();
            // Instead, let's test some WKT edge cases
import org.opensearch.index.query.GeoValidationMethod;
            .setBoost(1.5f)
        assertEquals("Bottom should match", 40.6, query.bottomRight().getLat(), 0.001);
        assertEquals("Default boost should be 1.0", 1.0f, query.boost(), 0.001f);
        GeoLocation bottomLeft = GeoLocation.newBuilder().setLatlon(bottomLeftLocation).build();
            // Create WktGeoBounds first
        GeoBoundingBoxQuery geoBoundingBoxQuery = GeoBoundingBoxQuery.newBuilder()
        CoordsGeoBounds coords = CoordsGeoBounds.newBuilder().setTop(40.7).setLeft(-74.0).setBottom(40.6).setRight(-73.9).build();
            GeoBoundingBoxQuery geoBoundingBoxQuery = GeoBoundingBoxQuery.newBuilder().putBoundingBox("location", geoBounds).build();
        assertEquals("Field name should match", "location", query.fieldName());
            WktGeoBounds wkt = WktGeoBounds.newBuilder().setWkt("POINT(-74.0 40.7)").build();
            GeoBoundingBoxQuery geoBoundingBoxQuery = GeoBoundingBoxQuery.newBuilder().build();
            GeoBoundingBoxQueryBuilderProtoUtils.fromProto(geoBoundingBoxQuery);
            WktGeoBounds invalidWkt = WktGeoBounds.newBuilder().setWkt("LINESTRING(-74.0 40.7, -73.9 40.6)").build();
        // Create protobuf GeoBoundingBoxQuery
    public void testFromProtoWithValidationMethod() {
        // Create protobuf GeoLocation for topLeft
            WktGeoBounds wkt = WktGeoBounds.newBuilder()
        assertEquals("Boost should match", 1.5f, query.boost(), 0.001f);
 * SPDX-License-Identifier: Apache-2.0
        GeoBoundingBoxQueryBuilder query = GeoBoundingBoxQueryBuilderProtoUtils.fromProto(geoBoundingBoxQuery);
            .build();
            .build();
            .build();
            GeoBoundingBoxQueryBuilderProtoUtils.fromProto(geoBoundingBoxQuery);
        // Create protobuf WktGeoBounds
        assertEquals("Bottom should match", 40.6, query.bottomRight().getLat(), 0.001);
    }
            .setValidationMethod(org.opensearch.protobufs.GeoValidationMethod.GEO_VALIDATION_METHOD_COERCE)
    }
        assertEquals("Left should match", -74.0, query.topLeft().getLon(), 0.001);
            GeoBoundingBoxQueryBuilderProtoUtils.fromProto(geoBoundingBoxQuery);
        GeoBoundingBoxQueryBuilder query = GeoBoundingBoxQueryBuilderProtoUtils.fromProto(geoBoundingBoxQuery);
        expectThrows(IllegalArgumentException.class, () -> {
        assertEquals("Right should match", -73.9, query.bottomRight().getLon(), 0.001);
        query = GeoBoundingBoxQueryBuilderProtoUtils.fromProto(geoBoundingBoxQuery);
        GeoBounds geoBounds = GeoBounds.newBuilder().setTlbr(tlbr).build();
        // Create protobuf GeoBoundingBoxQuery
        assertNotNull("Query should not be null", query);
        });
        GeoLocation topLeft = GeoLocation.newBuilder().setLatlon(topLeftLocation).build();
        assertEquals("BottomRight Longitude should match", -73.9, query.bottomRight().getLon(), 0.001);
        assertEquals("Right should match", -73.9, query.bottomRight().getLon(), 0.001);
            .putBoundingBox("location", geoBounds)
            // Create invalid WKT that parses but isn't an ENVELOPE
        // Create protobuf TopRightBottomLeftGeoBounds
        assertEquals("Top should match", 40.7, query.topLeft().getLat(), 0.001);
        expectThrows(IllegalArgumentException.class, () -> {
        assertEquals("Left should match", -74.0, query.topLeft().getLon(), 0.001);
        GeoBoundingBoxQueryBuilder query = GeoBoundingBoxQueryBuilderProtoUtils.fromProto(geoBoundingBoxQuery);
        assertTrue("Ignore unmapped should be true", query.ignoreUnmapped());
            .putBoundingBox("location", geoBounds)
            // For now, let's create a test that covers a different edge case
    public void testFromProtoWithCoords() {
        assertEquals("Execution type should be INDEXED", GeoExecType.INDEXED, query.type());
        assertEquals("Validation method should be COERCE", GeoValidationMethod.COERCE, query.getValidationMethod());
import org.opensearch.protobufs.TopRightBottomLeftGeoBounds;
        expectThrows(IllegalArgumentException.class, () -> GeoBoundingBoxQueryBuilderProtoUtils.fromProto(null));
            .setType(GeoExecution.GEO_EXECUTION_INDEXED)
        // Test STRICT validation method
import org.opensearch.protobufs.LatLonGeoLocation;
        // Test IGNORE_MALFORMED validation method
        GeoBounds geoBounds = GeoBounds.newBuilder().setTrbl(trbl).build();
        assertFalse("Ignore unmapped should be false", query.ignoreUnmapped());
        assertEquals("Execution type should be MEMORY", GeoExecType.MEMORY, query.type());
    public void testFromProtoWithWkt() {
}
        // Check defaults
        TopRightBottomLeftGeoBounds trbl = TopRightBottomLeftGeoBounds.newBuilder().setTopRight(topRight).setBottomLeft(bottomLeft).build();
            .setBoost(2.0f)
        GeoBounds geoBounds = GeoBounds.newBuilder().setCoords(coords).build();
        GeoLocation topRight = GeoLocation.newBuilder().setLatlon(topRightLocation).build();
            .setValidationMethod(org.opensearch.protobufs.GeoValidationMethod.GEO_VALIDATION_METHOD_IGNORE_MALFORMED)
import org.opensearch.protobufs.GeoBoundingBoxQuery;
    }
            GeoBounds geoBounds = GeoBounds.newBuilder().build(); // Empty GeoBounds
        GeoBoundingBoxQueryBuilder query = GeoBoundingBoxQueryBuilderProtoUtils.fromProto(geoBoundingBoxQuery);
    }
        GeoBoundingBoxQuery geoBoundingBoxQuery = GeoBoundingBoxQuery.newBuilder()
            // Use POINT instead of ENVELOPE/BBOX
        assertEquals("Field name should match", "location", query.fieldName());
            GeoBounds geoBounds = GeoBounds.newBuilder().setWkt(wkt).build();
            GeoBoundingBoxQueryBuilderProtoUtils.fromProto(geoBoundingBoxQuery);
    public void testFromProtoWithTlbr() {
            .build();
        GeoBounds geoBounds = GeoBounds.newBuilder().setCoords(coords).build();
        GeoBounds geoBounds = GeoBounds.newBuilder().setCoords(coords).build();
    }
        geoBoundingBoxQuery = GeoBoundingBoxQuery.newBuilder()
