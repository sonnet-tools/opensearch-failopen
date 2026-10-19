            sortMode = SortMode.fromString(ProtobufEnumUtils.convertToString(geoDistanceSort.getMode()));
            result.setNestedSort(nestedSort);
        return result;  
        GeoDistanceSortBuilder result = new GeoDistanceSortBuilder(fieldName, geoPoints.toArray(new GeoPoint[0]));
        fieldName = geoDistanceSort.getLocationMap().keySet().iterator().next();
package org.opensearch.transport.grpc.proto.request.search.sort;
            }  
     * @param geoLocationArray The GeoLocationArray containing the geo locations
     * Converts a Protocol Buffer GeoDistanceSort to a GeoDistanceSortBuilder.
 * Protocol Buffer representations to properly configured GeoDistanceSortBuilder objects with
        if (validation != null) {
        GeoDistance geoDistance = GeoDistance.ARC;
        }
                "GeoDistanceSort supports only one field, but found " + geoDistanceSort.getLocationCount() + " fields"  
import org.opensearch.common.geo.GeoPoint;
import org.opensearch.protobufs.GeoDistanceType;  
    private static List<GeoPoint> extractGeoPoints(GeoLocationArray geoLocationArray, String fieldName) {  
        List<GeoPoint> geoPoints = null;
        if (sortMode != null) {  
        return geoPoints;
     * @throws IllegalArgumentException if required fields are missing or invalid
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.protobufs.GeoDistanceSort;
public class GeoDistanceSortProtoUtils {
 *
        if (nestedSort != null) {
        DistanceUnit unit = DistanceUnit.DEFAULT;  
     * @param registry The registry for query conversion (needed for nested sorts with filters)
            order = SortOrder.fromString(ProtobufEnumUtils.convertToString(geoDistanceSort.getOrder()));
import org.opensearch.search.sort.GeoDistanceSortBuilder;  
        NestedSortBuilder nestedSort = null;  
        }  
     * @param geoDistanceSort The Protocol Buffer GeoDistanceSort to convert
 * compatible open source license.
     * @return A list of GeoPoint objects  
    }
        result.unit(unit);
            throw new IllegalArgumentException("GeoDistanceSort cannot be null");
            unit = DistanceUnit.fromString(ProtobufEnumUtils.convertToString(geoDistanceSort.getUnit()));  
        GeoValidationMethod validation = null;
        }
        }
 *
        }  
import java.util.ArrayList;
        if (geoDistanceSort == null) {
            } catch (Exception e) {
        SortMode sortMode = null;  
        }  
        geoPoints = extractGeoPoints(geoLocationArray, fieldName);  
        GeoLocationArray geoLocationArray = geoDistanceSort.getLocationMap().get(fieldName);
                throw new IllegalArgumentException("Invalid geo location in field '" + fieldName + "': " + e.getMessage(), e);
     * with the appropriate field name, geo points, distance type, units, validation, and nested sorting settings.
            && geoDistanceSort.getValidationMethod() != org.opensearch.protobufs.GeoValidationMethod.GEO_VALIDATION_METHOD_UNSPECIFIED) {
import org.opensearch.transport.grpc.proto.request.common.GeoPointProtoUtils;
        result.setNestedPath(nestedPath);  
 * Utility class for converting GeoDistanceSort Protocol Buffers to OpenSearch GeoDistanceSortBuilder objects.  
        if (geoDistanceSort.hasIgnoreUnmapped()) {
import org.opensearch.index.query.QueryBuilder;
            throw new IllegalArgumentException("GeoDistanceSort must contain at least one geo location");
/**
     * Similar to {@link GeoDistanceSortBuilder#fromXContent}, this method parses the  
import org.opensearch.index.query.GeoValidationMethod;  
import org.opensearch.common.unit.DistanceUnit;
        result.order(order);
import java.util.List;  
     *  
        if (geoDistanceSort.hasUnit() && geoDistanceSort.getUnit() != org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_UNSPECIFIED) {
        if (geoDistanceSort.hasDistanceType() && geoDistanceSort.getDistanceType() != GeoDistanceType.GEO_DISTANCE_TYPE_UNSPECIFIED) {  
            throw new IllegalArgumentException(
        if (geoDistanceSort.hasOrder()) {
        if (geoDistanceSort.hasValidationMethod()
 */  
        if (geoDistanceSort.getLocationCount() == 0) {  
            result.validation(validation);
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;
/*  
        QueryBuilder nestedFilter = null;
     */
     * @param fieldName The field name (used for error messages)
    /**
        // Utility class
            ignoreUnmapped = geoDistanceSort.getIgnoreUnmapped();
                GeoPoint point = GeoPointProtoUtils.parseGeoPoint(geoLocation);
            );
        for (GeoLocation geoLocation : geoLocationArray.getGeoLocationArrayList()) {  
import org.opensearch.protobufs.GeoLocation;
        }
            result.setNestedFilter(nestedFilter);
            try {
        result.geoDistance(geoDistance);  
        if (geoDistanceSort.getLocationCount() > 1) {
    public static GeoDistanceSortBuilder fromProto(GeoDistanceSort geoDistanceSort, QueryBuilderProtoConverterRegistry registry) {  
        }  
     *  
        }  
        List<GeoPoint> geoPoints = new ArrayList<>();
     * @return A configured GeoDistanceSortBuilder  
        }
    /**  
        }
 */  
        }
import org.opensearch.search.sort.NestedSortBuilder;
            validation = GeoValidationMethod.fromString(ProtobufEnumUtils.convertToString(geoDistanceSort.getValidationMethod()));  
        }
        boolean ignoreUnmapped = false;
import org.opensearch.search.sort.SortOrder;  
            result.sortMode(sortMode);
        if (geoDistanceSort.hasNested()) {
        if (geoDistanceSort.hasMode() && geoDistanceSort.getMode() != org.opensearch.protobufs.SortMode.SORT_MODE_UNSPECIFIED) {  
     * Protocol Buffer representation and creates a properly configured GeoDistanceSortBuilder
        }
    private GeoDistanceSortProtoUtils() {  
import org.opensearch.transport.grpc.util.ProtobufEnumUtils;  
import org.opensearch.search.sort.SortMode;
import org.opensearch.common.geo.GeoDistance;  
        if (nestedFilter != null) {  
 * this file be licensed under the Apache-2.0 license or a
     */
        }
 * geo distance sorting, distance type, units, validation method, and nested sorting settings.  
}  
    }
        String fieldName = null;
 * @opensearch.internal
     * @throws IllegalArgumentException if no valid geo locations are found or parsing fails
    }
                geoPoints.add(point);  
     * Extracts geo points from a GeoLocationArray.
        result.ignoreUnmapped(ignoreUnmapped);
        if (geoPoints.isEmpty()) {  
import org.opensearch.protobufs.GeoLocationArray;
 * Similar to {@link GeoDistanceSortBuilder#fromXContent}, this class handles the conversion of
            throw new IllegalArgumentException("No valid geo locations found in field '" + fieldName + "'");
        }
        String nestedPath = null;
            geoDistance = GeoDistance.fromString(ProtobufEnumUtils.convertToString(geoDistanceSort.getDistanceType()));
        SortOrder order = SortOrder.ASC;
            nestedSort = NestedSortProtoUtils.fromProto(geoDistanceSort.getNested(), registry);  
     * This method uses GeoPointProtoUtils to convert protobuf geo locations to GeoPoint objects.
 * The OpenSearch Contributors require contributions made to  
