            )  
import org.opensearch.transport.grpc.proto.request.search.query.QueryBuilderProtoConverterRegistryImpl;
            .build();
    }  
        GeoDistanceSort geoDistanceSort = GeoDistanceSort.newBuilder()
            .putLocation("location_field", locationArray)
            .build();
                GeoLocation.newBuilder()
                GeoLocation.newBuilder()  
import org.opensearch.protobufs.SortMode;  
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(40.0).setLon(-70.0).build())  
            )
            )
            IllegalArgumentException.class,
                    .build()  
        GeoDistanceSort geoDistanceSort = GeoDistanceSort.newBuilder()  
    public void testFromProtoWithMultipleLocations() {
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(51.5).setLon(-0.1).build())
            IllegalArgumentException.class,
            .putLocation("field1", locationArray1)
            .addGeoLocationArray(  
            .build();
        GeoDistanceSortBuilder result = GeoDistanceSortProtoUtils.fromProto(geoDistanceSort, registry);
                GeoLocation.newBuilder()
            .build();  
 * SPDX-License-Identifier: Apache-2.0
        GeoDistanceSort geoDistanceSort = GeoDistanceSort.newBuilder().putLocation("location_field", locationArray).build();
            .putLocation("location_field", locationArray)
            .build();  
    public void testFromProtoWithValidationMethod() {  
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(38.0).setLon(-68.0).build())
        // Create a GeoDistanceSort with basic parameters  
                    .build()  
    }
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(40.0).setLon(-70.0).build())
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(40.0).setLon(-70.0).build())
public class GeoDistanceSortProtoUtilsTests extends OpenSearchTestCase {
        registry = new QueryBuilderProtoConverterRegistryImpl();
        GeoDistanceSortBuilder result = GeoDistanceSortProtoUtils.fromProto(geoDistanceSort, registry);  
}
            .putLocation("location_field", locationArray)
        assertEquals("Order should match", SortOrder.DESC, result.order());
                    .build()  
        GeoDistanceSortBuilder result = GeoDistanceSortProtoUtils.fromProto(geoDistanceSort, registry);  
        GeoDistanceSort geoDistanceSort = GeoDistanceSort.newBuilder().build();
        GeoLocationArray locationArray = GeoLocationArray.newBuilder()
            .setOrder(org.opensearch.protobufs.SortOrder.SORT_ORDER_ASC)
            .setMode(SortMode.SORT_MODE_AVG)
        GeoDistanceSort geoDistanceSort = GeoDistanceSort.newBuilder()  
            .build();
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(40.0).setLon(-70.0).build())
    }
            )  
                GeoLocation.newBuilder()
        assertEquals("Default order should be ASC", SortOrder.ASC, result.order());
            .build();
        GeoDistanceSortBuilder result = GeoDistanceSortProtoUtils.fromProto(geoDistanceSort, registry);
                    .build()
        assertNotNull("GeoDistanceSortBuilder should not be null", result);  
import org.opensearch.protobufs.GeoDistanceSort;
            .addGeoLocationArray(
            .build();
        GeoLocationArray locationArray = GeoLocationArray.newBuilder()
            .addGeoLocationArray(
        GeoLocationArray locationArray = GeoLocationArray.newBuilder()
            .setValidationMethod(org.opensearch.protobufs.GeoValidationMethod.GEO_VALIDATION_METHOD_STRICT)
            .setUnit(org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_KM)  
    public void testFromProtoWithAllParameters() {
                GeoLocation.newBuilder()
            )
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(40.0).setLon(-70.0).build())
            .setMode(SortMode.SORT_MODE_MAX)  
        assertEquals("Field name should match", "location_field", result.fieldName());
        assertNotNull("GeoDistanceSortBuilder should not be null", result);
        assertTrue("IgnoreUnmapped should be true", result.ignoreUnmapped());
        GeoLocationArray locationArray = GeoLocationArray.newBuilder()  
        org.opensearch.protobufs.NestedSortValue nestedSort = org.opensearch.protobufs.NestedSortValue.newBuilder()
    public void testFromProtoWithIgnoreUnmapped() {  
            () -> GeoDistanceSortProtoUtils.fromProto(geoDistanceSort, registry)
            .build();
    }
        IllegalArgumentException exception = expectThrows(  
        assertEquals("Distance type should match", GeoDistance.PLANE, result.geoDistance());
            .setUnit(org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_MI)  
            .setMode(SortMode.SORT_MODE_UNSPECIFIED)
        GeoDistanceSortBuilder result = GeoDistanceSortProtoUtils.fromProto(geoDistanceSort, registry);
                GeoLocation.newBuilder()
        assertEquals("Order should match", SortOrder.ASC, result.order());
        super.setUp();
        GeoDistanceSort geoDistanceSort = GeoDistanceSort.newBuilder()
            .addGeoLocationArray(  
            .build();  
    }
            )
            )
        assertNotNull("GeoDistanceSortBuilder should not be null", result);  
            .putLocation("location_field", locationArray)
    public void testFromProtoWithNestedSort() {
        IllegalArgumentException exception = expectThrows(
        assertTrue("IgnoreUnmapped should be true", result.ignoreUnmapped());
                    .build()
        assertEquals("Field name should match", "location_field", result.fieldName());
            .addGeoLocationArray(  
    public void setUp() throws Exception {  
import org.opensearch.protobufs.GeoLocationArray;
        );  
            )
 * The OpenSearch Contributors require contributions made to  
            .addGeoLocationArray(
        assertNotNull("GeoDistanceSortBuilder should not be null", result);
        GeoDistanceSort geoDistanceSort = GeoDistanceSort.newBuilder()  
    private QueryBuilderProtoConverterRegistry registry;  
    public void testFromProtoWithMultipleGeoPointsInOneField() {
            .build();  
        GeoDistanceSortBuilder result = GeoDistanceSortProtoUtils.fromProto(geoDistanceSort, registry);
            .setUnit(org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_UNSPECIFIED)
            .build();
        assertEquals("Default unit should be used for UNSPECIFIED", DistanceUnit.DEFAULT, result.unit());
            .putLocation("field2", locationArray2)  
            .build();
                    .build()
        GeoDistanceSort geoDistanceSort = GeoDistanceSort.newBuilder()
            )
            .addGeoLocationArray(
            .build();
        );
    }
        assertEquals("Default distance type should be ARC", GeoDistance.ARC, result.geoDistance());
                GeoLocation.newBuilder()  
            .setIgnoreUnmapped(true)
                GeoLocation.newBuilder()  
        GeoLocationArray locationArray = GeoLocationArray.newBuilder()  
            .setValidationMethod(org.opensearch.protobufs.GeoValidationMethod.GEO_VALIDATION_METHOD_UNSPECIFIED)
            .setPath("nested_field")
            .build();
    public void testFromProtoWithUnspecifiedEnums() {  
                    .build()
            .build();
        assertNotNull("GeoDistanceSortBuilder should not be null", result);
        assertEquals("GeoDistanceSort must contain at least one geo location", exception.getMessage());
import org.opensearch.common.unit.DistanceUnit;
            .putLocation("location_field", locationArray)
        assertEquals("Field name should match", "geo_field", result.fieldName());  
/*  
            )  
            () -> GeoDistanceSortProtoUtils.fromProto(null, registry)  
            .putLocation("location_field", locationArray)  
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(51.5).setLon(-0.1).build())
import org.opensearch.protobufs.GeoLocation;
            () -> GeoDistanceSortProtoUtils.fromProto(geoDistanceSort, registry)
 * compatible open source license.
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(51.5).setLon(-0.1).build())
    }  
        GeoLocationArray locationArray = GeoLocationArray.newBuilder()
 *
            .setNested(nestedSort)
    public void testFromProtoWithNoLocations() {  
                    .build()
            .setIgnoreUnmapped(true)
                    .build()
        assertNotNull("GeoDistanceSortBuilder should not be null", result);  
                    .build()
            )
                    .build()  
            .addGeoLocationArray(  
        GeoDistanceSortBuilder result = GeoDistanceSortProtoUtils.fromProto(geoDistanceSort, registry);
    }
            .build();  
            .setDistanceType(GeoDistanceType.GEO_DISTANCE_TYPE_UNSPECIFIED)  
            .setDistanceType(GeoDistanceType.GEO_DISTANCE_TYPE_PLANE)
        assertEquals("Default distance type should be used for UNSPECIFIED", GeoDistance.ARC, result.geoDistance());  
            )  
                GeoLocation.newBuilder()
            .build();  
            .addGeoLocationArray(
        assertEquals("Unit should match", DistanceUnit.KILOMETERS, result.unit());
        GeoLocationArray locationArray = GeoLocationArray.newBuilder()
 * this file be licensed under the Apache-2.0 license or a
        GeoDistanceSortBuilder result = GeoDistanceSortProtoUtils.fromProto(geoDistanceSort, registry);
import org.opensearch.common.geo.GeoDistance;  
        assertNotNull("GeoDistanceSortBuilder should not be null", result);  
import org.opensearch.test.OpenSearchTestCase;  
            .addGeoLocationArray(
            .setOrder(org.opensearch.protobufs.SortOrder.SORT_ORDER_DESC)
        assertEquals("Distance type should match", GeoDistance.PLANE, result.geoDistance());  
        );  
        GeoDistanceSort geoDistanceSort = GeoDistanceSort.newBuilder()  
            .addGeoLocationArray(
            .setDistanceType(GeoDistanceType.GEO_DISTANCE_TYPE_PLANE)
 */  
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(40.0).setLon(-70.0).build())  
    }
    public void testFromProtoWithDefaultValues() {
import org.opensearch.search.sort.GeoDistanceSortBuilder;
            .setValidationMethod(org.opensearch.protobufs.GeoValidationMethod.GEO_VALIDATION_METHOD_IGNORE_MALFORMED)
        GeoLocationArray locationArray2 = GeoLocationArray.newBuilder()
    @Override
    }
                GeoLocation.newBuilder()  
            .build();
    public void testFromProtoWithNullInput() {  
    }  
        assertEquals("GeoDistanceSort cannot be null", exception.getMessage());  
        assertNotNull("GeoDistanceSortBuilder should not be null", result);
        assertEquals("GeoDistanceSort supports only one field, but found 2 fields", exception.getMessage());
        GeoLocationArray locationArray = GeoLocationArray.newBuilder()
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;
        IllegalArgumentException exception = expectThrows(  
        GeoLocationArray locationArray1 = GeoLocationArray.newBuilder()  
                    .build()  
            .build();
            .putLocation("location_field", locationArray)  
    }  
        assertEquals("Default unit should be DEFAULT", DistanceUnit.DEFAULT, result.unit());  
            .addGeoLocationArray(
    public void testFromProtoWithSortMode() {
        assertEquals("Field name should match", "location_field", result.fieldName());
    public void testFromProtoWithGeoDistanceSort() {
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(40.0).setLon(-70.0).build())
        assertEquals("Field name should match", "location_field", result.fieldName());  
        GeoDistanceSortBuilder result = GeoDistanceSortProtoUtils.fromProto(geoDistanceSort, registry);
                GeoLocation.newBuilder()
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(40.0).setLon(-70.0).build())
            .addGeoLocationArray(  
        GeoDistanceSort geoDistanceSort = GeoDistanceSort.newBuilder()  
        assertNotNull("GeoDistanceSortBuilder should not be null", result);
    }  
            IllegalArgumentException.class,
        GeoDistanceSort geoDistanceSort = GeoDistanceSort.newBuilder().putLocation("geo_field", locationArray).build();
            )  
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(40.0).setLon(-70.0).build())  
        GeoLocationArray locationArray = GeoLocationArray.newBuilder()
        assertEquals("Unit should match", DistanceUnit.MILES, result.unit());  
                    .build()
                GeoLocation.newBuilder()
package org.opensearch.transport.grpc.proto.request.search.sort;
import org.opensearch.protobufs.GeoDistanceType;  
import org.opensearch.search.sort.SortOrder;
                GeoLocation.newBuilder()  
