            .setMode(SortMode.SORT_MODE_MAX)
        GeoLocationArray locationArray = GeoLocationArray.newBuilder()
            () -> GeoDistanceSortProtoUtils.fromProto(null, registry)
        assertEquals("Unit should match", DistanceUnit.MILES, result.unit());
import org.opensearch.common.unit.DistanceUnit;
        GeoDistanceSort geoDistanceSort = GeoDistanceSort.newBuilder()
            .addGeoLocationArray(
        assertTrue("IgnoreUnmapped should be true", result.ignoreUnmapped());
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(40.0).setLon(-70.0).build())
    }
                GeoLocation.newBuilder()
        GeoLocationArray locationArray = GeoLocationArray.newBuilder()
                    .build()
                GeoLocation.newBuilder()
        GeoLocationArray locationArray = GeoLocationArray.newBuilder()
                    .build()
    }
    public void testFromProtoWithIgnoreUnmapped() {
        assertNotNull("GeoDistanceSortBuilder should not be null", result);
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(51.5).setLon(-0.1).build())
        GeoDistanceSort geoDistanceSort = GeoDistanceSort.newBuilder()
import org.opensearch.common.geo.GeoDistance;
        assertNotNull("GeoDistanceSortBuilder should not be null", result);
    }
 *
import org.opensearch.protobufs.SortMode;
            .build();
        assertTrue("IgnoreUnmapped should be true", result.ignoreUnmapped());
        assertEquals("Field name should match", "location_field", result.fieldName());
            .build();
        GeoLocationArray locationArray = GeoLocationArray.newBuilder()
        );
                GeoLocation.newBuilder()
            .setIgnoreUnmapped(true)
                GeoLocation.newBuilder()
            .build();
                    .build()
            )
        assertNotNull("GeoDistanceSortBuilder should not be null", result);
        registry = new QueryBuilderProtoConverterRegistryImpl();
            .build();
        GeoDistanceSort geoDistanceSort = GeoDistanceSort.newBuilder().putLocation("geo_field", locationArray).build();
            .build();
            .build();
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(51.5).setLon(-0.1).build())
        assertEquals("Field name should match", "location_field", result.fieldName());
        GeoLocationArray locationArray = GeoLocationArray.newBuilder()
        GeoDistanceSort geoDistanceSort = GeoDistanceSort.newBuilder()
        assertEquals("Default unit should be DEFAULT", DistanceUnit.DEFAULT, result.unit());
            .addGeoLocationArray(
        GeoDistanceSortBuilder result = GeoDistanceSortProtoUtils.fromProto(geoDistanceSort, registry);
            .setDistanceType(GeoDistanceType.GEO_DISTANCE_TYPE_PLANE)
    public void testFromProtoWithSortMode() {
    public void testFromProtoWithGeoDistanceSort() {
        assertEquals("GeoDistanceSort supports only one field, but found 2 fields", exception.getMessage());
            )
        assertEquals("Field name should match", "geo_field", result.fieldName());
            .putLocation("field2", locationArray2)
            .build();
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;
        assertEquals("GeoDistanceSort cannot be null", exception.getMessage());
package org.opensearch.transport.grpc.proto.request.search.sort;
        assertNotNull("GeoDistanceSortBuilder should not be null", result);
            )
        assertEquals("Field name should match", "location_field", result.fieldName());
            .setUnit(org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_UNSPECIFIED)
        GeoDistanceSortBuilder result = GeoDistanceSortProtoUtils.fromProto(geoDistanceSort, registry);
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(38.0).setLon(-68.0).build())
        GeoLocationArray locationArray2 = GeoLocationArray.newBuilder()
        assertEquals("Field name should match", "location_field", result.fieldName());
        assertEquals("Order should match", SortOrder.ASC, result.order());
            )
            .setMode(SortMode.SORT_MODE_UNSPECIFIED)
}
        IllegalArgumentException exception = expectThrows(
            .addGeoLocationArray(
            .setUnit(org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_KM)
public class GeoDistanceSortProtoUtilsTests extends OpenSearchTestCase {
            IllegalArgumentException.class,
    public void testFromProtoWithNoLocations() {
        GeoDistanceSort geoDistanceSort = GeoDistanceSort.newBuilder()
        super.setUp();
            )
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(40.0).setLon(-70.0).build())
            .setUnit(org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_MI)
            )
            .putLocation("location_field", locationArray)
            IllegalArgumentException.class,
            )
            .addGeoLocationArray(
            .addGeoLocationArray(
            .build();
            )
    }
    public void testFromProtoWithMultipleGeoPointsInOneField() {
                    .build()
    }
                    .build()
            .putLocation("location_field", locationArray)
 * The OpenSearch Contributors require contributions made to
        assertNotNull("GeoDistanceSortBuilder should not be null", result);
    }
        );
                GeoLocation.newBuilder()
        assertNotNull("GeoDistanceSortBuilder should not be null", result);
    }
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(40.0).setLon(-70.0).build())
            .build();
        GeoLocationArray locationArray1 = GeoLocationArray.newBuilder()
 * this file be licensed under the Apache-2.0 license or a
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(40.0).setLon(-70.0).build())
    }
        assertNotNull("GeoDistanceSortBuilder should not be null", result);
            .build();
    @Override
        GeoDistanceSort geoDistanceSort = GeoDistanceSort.newBuilder()
    public void testFromProtoWithDefaultValues() {
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(40.0).setLon(-70.0).build())
        // Create a GeoDistanceSort with basic parameters
            .putLocation("location_field", locationArray)
        GeoDistanceSort geoDistanceSort = GeoDistanceSort.newBuilder().putLocation("location_field", locationArray).build();
        org.opensearch.protobufs.NestedSortValue nestedSort = org.opensearch.protobufs.NestedSortValue.newBuilder()
            .build();
            )
        assertEquals("Default distance type should be used for UNSPECIFIED", GeoDistance.ARC, result.geoDistance());
        GeoLocationArray locationArray = GeoLocationArray.newBuilder()
 */
                GeoLocation.newBuilder()
                GeoLocation.newBuilder()
                GeoLocation.newBuilder()
            .putLocation("location_field", locationArray)
    }
import org.opensearch.protobufs.GeoDistanceSort;
import org.opensearch.search.sort.SortOrder;
                    .build()
            .setMode(SortMode.SORT_MODE_AVG)
import org.opensearch.transport.grpc.proto.request.search.query.QueryBuilderProtoConverterRegistryImpl;
            .setPath("nested_field")
            .build();
            .setOrder(org.opensearch.protobufs.SortOrder.SORT_ORDER_ASC)
        assertEquals("Default unit should be used for UNSPECIFIED", DistanceUnit.DEFAULT, result.unit());
            .build();
        GeoLocationArray locationArray = GeoLocationArray.newBuilder()
            .putLocation("location_field", locationArray)
        assertNotNull("GeoDistanceSortBuilder should not be null", result);
        GeoLocationArray locationArray = GeoLocationArray.newBuilder()
                GeoLocation.newBuilder()
                    .build()
    public void testFromProtoWithNullInput() {
        GeoDistanceSortBuilder result = GeoDistanceSortProtoUtils.fromProto(geoDistanceSort, registry);
                    .build()
        GeoDistanceSort geoDistanceSort = GeoDistanceSort.newBuilder()
                GeoLocation.newBuilder()
    private QueryBuilderProtoConverterRegistry registry;
            .addGeoLocationArray(
    public void testFromProtoWithNestedSort() {
            IllegalArgumentException.class,
import org.opensearch.search.sort.GeoDistanceSortBuilder;
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(40.0).setLon(-70.0).build())
        GeoDistanceSort geoDistanceSort = GeoDistanceSort.newBuilder().build();
            .putLocation("location_field", locationArray)
        GeoDistanceSortBuilder result = GeoDistanceSortProtoUtils.fromProto(geoDistanceSort, registry);
        assertEquals("Unit should match", DistanceUnit.KILOMETERS, result.unit());
            .build();
            .build();
import org.opensearch.test.OpenSearchTestCase;
        IllegalArgumentException exception = expectThrows(
            .setOrder(org.opensearch.protobufs.SortOrder.SORT_ORDER_DESC)
        GeoDistanceSort geoDistanceSort = GeoDistanceSort.newBuilder()
                    .build()
            )
            .addGeoLocationArray(
            .setNested(nestedSort)
            .setValidationMethod(org.opensearch.protobufs.GeoValidationMethod.GEO_VALIDATION_METHOD_UNSPECIFIED)
        assertEquals("Order should match", SortOrder.DESC, result.order());
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(40.0).setLon(-70.0).build())
        GeoLocationArray locationArray = GeoLocationArray.newBuilder()
                GeoLocation.newBuilder()
import org.opensearch.protobufs.GeoDistanceType;
            () -> GeoDistanceSortProtoUtils.fromProto(geoDistanceSort, registry)
                GeoLocation.newBuilder()
            .putLocation("location_field", locationArray)
        GeoDistanceSortBuilder result = GeoDistanceSortProtoUtils.fromProto(geoDistanceSort, registry);
import org.opensearch.protobufs.GeoLocation;
import org.opensearch.protobufs.GeoLocationArray;
            .build();
 * compatible open source license.
            .build();
            () -> GeoDistanceSortProtoUtils.fromProto(geoDistanceSort, registry)
        assertEquals("Distance type should match", GeoDistance.PLANE, result.geoDistance());
            )
            )
                    .build()
        assertEquals("Distance type should match", GeoDistance.PLANE, result.geoDistance());
            .setValidationMethod(org.opensearch.protobufs.GeoValidationMethod.GEO_VALIDATION_METHOD_IGNORE_MALFORMED)
 * SPDX-License-Identifier: Apache-2.0
            .addGeoLocationArray(
            .build();
                    .build()
    public void testFromProtoWithAllParameters() {
            .setValidationMethod(org.opensearch.protobufs.GeoValidationMethod.GEO_VALIDATION_METHOD_STRICT)
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(40.0).setLon(-70.0).build())
        GeoDistanceSort geoDistanceSort = GeoDistanceSort.newBuilder()
        assertEquals("GeoDistanceSort must contain at least one geo location", exception.getMessage());
            .addGeoLocationArray(
/*
            .addGeoLocationArray(
            )
        assertEquals("Default distance type should be ARC", GeoDistance.ARC, result.geoDistance());
        );
        assertEquals("Default order should be ASC", SortOrder.ASC, result.order());
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(51.5).setLon(-0.1).build())
            .addGeoLocationArray(
            .setDistanceType(GeoDistanceType.GEO_DISTANCE_TYPE_PLANE)
        GeoDistanceSortBuilder result = GeoDistanceSortProtoUtils.fromProto(geoDistanceSort, registry);
                GeoLocation.newBuilder()
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(40.0).setLon(-70.0).build())
    public void testFromProtoWithUnspecifiedEnums() {
            .build();
                    .build()
            .addGeoLocationArray(
    public void setUp() throws Exception {
            .build();
            .putLocation("field1", locationArray1)
    }
        GeoDistanceSortBuilder result = GeoDistanceSortProtoUtils.fromProto(geoDistanceSort, registry);
        IllegalArgumentException exception = expectThrows(
    }
            .addGeoLocationArray(
            .setDistanceType(GeoDistanceType.GEO_DISTANCE_TYPE_UNSPECIFIED)
            .setIgnoreUnmapped(true)
        GeoDistanceSortBuilder result = GeoDistanceSortProtoUtils.fromProto(geoDistanceSort, registry);
        GeoDistanceSortBuilder result = GeoDistanceSortProtoUtils.fromProto(geoDistanceSort, registry);
        assertNotNull("GeoDistanceSortBuilder should not be null", result);
    public void testFromProtoWithMultipleLocations() {
                    .build()
    public void testFromProtoWithValidationMethod() {
    }
    }
