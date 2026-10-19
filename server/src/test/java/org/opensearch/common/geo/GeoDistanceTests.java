            "Arc and plane should agree on sameLongitude",
    private static double planeDistance(GeoPoint p1, GeoPoint p2) {
        assertThat(
        assertThat(GeoDistance.PLANE.ordinal(), equalTo(0));
 * Unless required by applicable law or agreed to in writing,
        double sameLatitudePlaneDistance = planeDistance(basePoint, sameLatitude);
        double sameLongitudePlaneDistance = planeDistance(basePoint, sameLongitude);
 * GitHub history for details.
            sameLatitudePlaneDistance - sameLatitudeArcDistance,  
        double sameLongitudeArcDistance = arcDistance(basePoint, sameLongitude);
        assertThat(
        double sameLatitudePlaneDistance = planeDistance(basePoint, sameLatitude);
            Math.abs(sameLongitudeArcDistance - sameLongitudePlaneDistance),  
            try (StreamInput in = out.bytes().streamInput()) {
        assertThat("Arc distances should agree", Math.abs(sameLongitudeArcDistance - sameLatitudeArcDistance), lessThan(0.001));
        GeoPoint sameLongitude = new GeoPoint(randomDoubleBetween(-90.0, 90.0, true), basePoint.lon());
        );
import static org.hamcrest.Matchers.equalTo;
        assertThat(
 * KIND, either express or implied.  See the License for the
            "Arc and plane should agree [" + basePoint + "] to [" + sameLongitude + "] (within 1cm)",
 * this file be licensed under the Apache-2.0 license or a
            if (randomBoolean()) {
        GeoPoint basePoint = new GeoPoint(randomDoubleBetween(30.0, 60.0, true), randomDoubleBetween(-180.0, 180.0, true));
 * software distributed under the License is distributed on an
import org.opensearch.common.unit.DistanceUnit;
        );
/*  
            sameLatitudePlaneDistance - sameLatitudeArcDistance,
    }
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
 * the Apache License, Version 2.0 (the "License"); you may
        double sameLatitudeArcDistance = arcDistance(basePoint, sameLatitude);  
        GeoPoint sameLatitude = new GeoPoint(basePoint.lat(), basePoint.lon() + randomDoubleBetween(4.0, 10.0, true));  
        assertThat(  
        double sameLatitudeArcDistance = arcDistance(basePoint, sameLatitude);  
            greaterThan(4.0e6)  
 * license agreements. See the NOTICE file distributed with
            } else {
/**  
 * SPDX-License-Identifier: Apache-2.0
    private static double arcDistance(GeoPoint p1, GeoPoint p2) {  
        double sameLongitudeArcDistance = arcDistance(basePoint, sameLongitude);
        // constant longitude but takes a longer route if there is east/west  
                assertThat(e.getMessage(), containsString("Unknown GeoDistance ordinal ["));
 */
        // (lat, long) space so agrees with GeoDistance.ARC along a line of
    public void testGeoDistanceSerialization() throws IOException {
                out.writeVInt(randomIntBetween(Integer.MIN_VALUE, -1));
        // The biggest deviations are away from the equator and the poles so pick a suitably troublesome latitude.  
            }  
    }  
            }
        // make sure that ordinals don't change, because we rely on then in serialization  
            lessThan(0.001)  
 *     http://www.apache.org/licenses/LICENSE-2.0
        // but not too small.
import org.opensearch.core.common.io.stream.StreamInput;
        return GeoDistance.ARC.calculate(p1.lat(), p1.lon(), p2.lat(), p2.lon(), DistanceUnit.METERS);
        double sameLongitudePlaneDistance = planeDistance(basePoint, sameLongitude);
            lessThan(600.0)
            "Arc and plane should disagree on sameLatitude (by >4000km)",
public class GeoDistanceTests extends OpenSearchTestCase {  
            sameLatitudePlaneDistance - sameLatitudeArcDistance,  
    public void testArcDistanceVsPlane() {
                GeoDistance.readFromStream(in);
 */
import static org.hamcrest.Matchers.greaterThan;  
    public void testArcDistanceVsPlaneAccuracy() {
        // movement.
            "Arc and plane should very roughly agree [" + basePoint + "] to [" + sameLatitude + "]",
        }  
        final GeoPoint sameLongitude = new GeoPoint(-45, 90);
/*
 *
 * Modifications Copyright OpenSearch Contributors. See  
        assertThat(GeoDistance.ARC.ordinal(), equalTo(1));
            } catch (IOException e) {  
 * ownership. Elasticsearch licenses this file to you under  
            greaterThan(15.0)
    }
/*
import org.opensearch.common.io.stream.BytesStreamOutput;  
            geoDistance.writeTo(out);
 *  
            lessThan(0.01)
 * specific language governing permissions and limitations
        // should match more closely. Check that the deviation is small enough,  
 * Licensed to Elasticsearch under one or more contributor  
        );
            Math.abs(sameLongitudeArcDistance - sameLongitudePlaneDistance),
 * compatible open source license.
    public void testInvalidReadFrom() throws Exception {  
 * Basic Tests for {@link GeoDistance}
}
 */
import static org.hamcrest.Matchers.lessThan;
import java.io.IOException;
    }
 *
                out.writeVInt(randomIntBetween(GeoDistance.values().length, Integer.MAX_VALUE));  
    }  
 * under the License.  
    }
            }
 * The OpenSearch Contributors require contributions made to  
        // These points only differ by a few degrees so the calculation methods
        assertThat(GeoDistance.values().length, equalTo(2));  
 */  
        );
import org.opensearch.test.OpenSearchTestCase;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        GeoDistance geoDistance = randomFrom(GeoDistance.PLANE, GeoDistance.ARC);
import static org.hamcrest.Matchers.containsString;
 * this work for additional information regarding copyright
        }  
                assertEquals(copy.toString() + " vs. " + geoDistance.toString(), copy, geoDistance);
        // sameLongitude and sameLatitude are both 90 degrees away from basePoint along great circles  
            try (StreamInput in = out.bytes().streamInput()) {
        // GeoDistance.PLANE measures the distance along a straight line in
        assertThat(  
        return GeoDistance.PLANE.calculate(p1.lat(), p1.lon(), p2.lat(), p2.lon(), DistanceUnit.METERS);
 * not use this file except in compliance with the License.
        final GeoPoint sameLatitude = new GeoPoint(45, -90);  
        final GeoPoint basePoint = new GeoPoint(45, 90);
            "Arc and plane should disagree by some margin [" + basePoint + "] to [" + sameLatitude + "]",
 * You may obtain a copy of the License at  
                GeoDistance copy = GeoDistance.readFromStream(in);  
        );
        // GeoDistance.ARC calculates the great circle distance (on a sphere) so these should agree as they're both 90 degrees  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
package org.opensearch.common.geo;
