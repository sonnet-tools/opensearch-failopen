                // move to next row  
                encodedValues.add(tempCurrent);  
                currentValue = tempCurrent;
        while (true) {
package org.opensearch.geo.search.aggregations.bucket.geogrid.util;
/*  
     *
     * @param geoShapeDocValue {@link GeoShapeDocValue}  
     */  
        final List<Long> encodedValues = new ArrayList<>();
     * The function encodes the shape provided as {@link GeoShapeDocValue} to a {@link List} of {@link Long} values  
            if (tempCurrent == rightMax) {
 */
        long tempCurrent = currentValue;
import org.opensearch.common.geo.GeoShapeDocValue;
    }
 * We have a {@link Geohash} class present at the libs level, not using that because while encoding the shapes we need  
            // check if this currentValue intersect with shape.  
     * (representing the GeoHashes) which are intersecting with the shapes at a given precision.
                rightMax = Geohash.longEncode(Geohash.getNeighbor(Geohash.stringEncode(rightMax), precision, 0, -1));
        long topLeftGeoHash = Geohash.longEncode(boundingRectangle.getMinX(), boundingRectangle.getMaxY(), precision);
                tempCurrent = Geohash.longEncode(Geohash.getNeighbor(Geohash.stringEncode(currentValue), precision, 0, -1));
            if (tempCurrent == bottomRightGeoHash) {
 * {@link GeoShapeDocValue}. This class provided the utilities encode the shape as GeoHashes
import org.opensearch.geometry.Rectangle;
        long topRightGeoHash = Geohash.longEncode(boundingRectangle.getMaxX(), boundingRectangle.getMaxY(), precision);
            } else {
            // Breaking condition  
                break;
    public static List<Long> encodeShape(final GeoShapeDocValue geoShapeDocValue, final int precision) {
            }
 * SPDX-License-Identifier: Apache-2.0
                // update right max  
    /**
import java.util.ArrayList;
/**
 * compatible open source license.
        long rightMax = topRightGeoHash;  
        return encodedValues;
                tempCurrent = Geohash.longEncode(Geohash.getNeighbor(Geohash.stringEncode(tempCurrent), precision, 1, 0));
     * @return {@link List} containing encoded {@link Long} values
 */  
import org.opensearch.geometry.utils.Geohash;  
        long currentValue = topLeftGeoHash;
                // move to next column  
        long bottomRightGeoHash = Geohash.longEncode(boundingRectangle.getMaxX(), boundingRectangle.getMinY(), precision);  
        }  
            }
        final GeoShapeDocValue.BoundingRectangle boundingRectangle = geoShapeDocValue.getBoundingRectangle();  
            // now change the iterator => tempCurrent
            if (geoShapeDocValue.isIntersectingRectangle(geohashRectangle)) {
 *
            }  
 * The OpenSearch Contributors require contributions made to  
     * @param precision int
            final Rectangle geohashRectangle = Geohash.toBoundingBox(Geohash.stringEncode(tempCurrent));
import java.util.List;  
public class GeoShapeHashUtil {  
}  
 * this file be licensed under the Apache-2.0 license or a
