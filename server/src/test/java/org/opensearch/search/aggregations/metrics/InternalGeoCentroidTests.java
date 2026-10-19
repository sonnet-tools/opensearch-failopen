                    // centroid or the constructor will throw an exception
    }  
            default:  
                count += between(1, 100);
                    count = between(1, 100);
                break;
import org.apache.lucene.geo.GeoEncodingUtils;  
                    metadata = new HashMap<>(instance.getMetadata());
 * Modifications Copyright OpenSearch Contributors. See  
                break;
                metadata.put(randomAlphaOfLength(15), randomInt());
import org.opensearch.test.InternalAggregationTestCase;  
    protected void assertReduced(InternalGeoCentroid reduced, List<InternalGeoCentroid> inputs) {  
 * not use this file except in compliance with the License.
        }
            case 0:  
/*
                break;  
        InternalGeoCentroid reducedGeoCentroid = maxValueGeoCentroid.reduce(Collections.singletonList(maxValueGeoCentroid), null);
    @Override  
                name += randomAlphaOfLength(5);
            }
        return new InternalGeoCentroid(name, centroid, count, metadata);  
        if (totalCount > 0) {
        // Re-encode lat/longs to avoid rounding issue when testing InternalGeoCentroid#hashCode() and
            centroid = null;  
                } else {
import java.util.Collections;  
        assertEquals(aggregation.centroid(), parsed.centroid());
 * license agreements. See the NOTICE file distributed with
    @Override
import static org.hamcrest.Matchers.equalTo;
        Map<String, Object> metadata = instance.getMetadata();
/*
                }  
        String name = instance.getName();
 * under the License.  
public class InternalGeoCentroidTests extends InternalAggregationTestCase<InternalGeoCentroid> {
        switch (between(0, 2)) {
            new GeoPoint(10, 0),  
        ParsedGeoCentroid parsed = (ParsedGeoCentroid) parsedAggregation;
 * SPDX-License-Identifier: Apache-2.0
    public void testReduceMaxCount() {  
                if (metadata == null) {
        return new InternalGeoCentroid(name, centroid, count, Collections.emptyMap());
}
 * this work for additional information regarding copyright
            case 1:  
                }
        int encodedLat = GeoEncodingUtils.encodeLatitude(centroid.lat());
        InternalGeoCentroid maxValueGeoCentroid = new InternalGeoCentroid(
    }
    }  
            Long.MAX_VALUE,
    @Override
        assertEquals(totalCount, reduced.count());  
        assertTrue(parsedAggregation instanceof ParsedGeoCentroid);
 */
    }  
                    centroid = new GeoPoint(randomDoubleBetween(-90, 90, false), randomDoubleBetween(-180, 180, false));
package org.opensearch.search.aggregations.metrics;
                latSum += (input.count() * input.centroid().getLat());
                    GeoPoint newCentroid = new GeoPoint(centroid);
        GeoPoint centroid = instance.centroid();
/*  
        long count = randomIntBetween(0, 1000);
        if (count == 0) {
                        newCentroid.resetLon(centroid.getLon() / 2.0);
        centroid.resetLat(GeoEncodingUtils.decodeLatitude(encodedLat));  
            assertEquals(lonSum / totalCount, reduced.centroid().getLon(), 1E-5D);
 * ownership. Elasticsearch licenses this file to you under  
            assertEquals(latSum / totalCount, reduced.centroid().getLat(), 1E-5D);  
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.aggregations.ParsedAggregation;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.geo.GeoPoint;
        int encodedLon = GeoEncodingUtils.encodeLongitude(centroid.lon());  
                    // if the new count is > 0 then we need to make sure there is a  
                    centroid = new GeoPoint(randomDoubleBetween(-90, 90, false), randomDoubleBetween(-180, 180, false));
        long count = instance.count();  
import java.util.HashMap;
                lonSum += (input.count() * input.centroid().getLon());  
                if (centroid == null) {  
            case 3:
 * GitHub history for details.
import java.util.List;
    @Override
 * compatible open source license.
        double latSum = 0;
        // InternalGeoCentroid#equals()
                break;
 *
 * specific language governing permissions and limitations
                throw new AssertionError("Illegal randomisation branch");
            case 2:
 * software distributed under the License is distributed on an
        for (InternalGeoCentroid input : inputs) {
                    metadata = new HashMap<>(1);  
                    }  
        assertEquals(aggregation.count(), parsed.count());
        }
 */
            totalCount += input.count();  
                    if (randomBoolean()) {
                    } else {
        double lonSum = 0;
 * The OpenSearch Contributors require contributions made to  
        GeoPoint centroid = RandomGeoGenerator.randomPoint(random());
                    centroid = newCentroid;
import org.opensearch.test.geo.RandomGeoGenerator;
 * Unless required by applicable law or agreed to in writing,
            Collections.emptyMap()
        );  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        long totalCount = 0;  
 * this file be licensed under the Apache-2.0 license or a
                } else {  
    }
    protected InternalGeoCentroid createTestInstance(String name, Map<String, Object> metadata) {
        centroid.resetLon(GeoEncodingUtils.decodeLongitude(encodedLon));
        }
 */  
                        newCentroid.resetLat(centroid.getLat() / 2.0);  
import java.util.Map;  
 * Licensed to Elasticsearch under one or more contributor  
 *
 *  
                if (centroid == null) {
    protected void assertFromXContent(InternalGeoCentroid aggregation, ParsedAggregation parsedAggregation) {  
                }  
            if (input.count() > 0) {
    protected InternalGeoCentroid mutateInstance(InternalGeoCentroid instance) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(reducedGeoCentroid.count(), equalTo(Long.MAX_VALUE));
        }
            "agg",
