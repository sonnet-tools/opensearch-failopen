        } else {
 * under the License.  
    /**  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
import org.opensearch.search.aggregations.InternalAggregation;
/*  
    }  
import org.opensearch.common.geo.GeoPoint;
                    return centroid.lat();
                    throw new IllegalArgumentException("Found unknown path element [" + coordinate + "] in [" + getName() + "]");
        double latSum = Double.NaN;
    static class Fields {
                }
            builder.endObject();
        super(name, metadata);
            out.writeDouble(centroid.lon());
            out.writeBoolean(true);
        return GeoEncodingUtils.decodeLatitude((int) (encodedLatLon >>> 32));  
        this.centroid = centroid;
                builder.field(Fields.CENTROID_LAT.getPreferredName(), centroid.lat());
    private final long count;  
import org.opensearch.core.xcontent.XContentBuilder;  
                    lonSum += (centroidAgg.count * centroidAgg.centroid.getLon());
     * Read from a stream.
    private final GeoPoint centroid;
        }  
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.search.aggregations.metrics;
                    return count;  
public class InternalGeoCentroid extends InternalAggregation implements GeoCentroid {
    protected boolean mustReduceOnSingleInternalAgg() {  
        } else if (path.size() == 1) {
import java.io.IOException;  
        count = in.readVLong();
import java.util.List;
        super(in);
        double lonSum = Double.NaN;  
    @Override
 * The OpenSearch Contributors require contributions made to  
        for (InternalAggregation aggregation : aggregations) {  
 *
        return Objects.hash(super.hashCode(), centroid, count);
        out.writeVLong(count);  
/**
            }
        return builder;
    public static long encodeLatLon(double lat, double lon) {
 */  
            }
    public boolean equals(Object obj) {  
 * KIND, either express or implied.  See the License for the
            GeoEncodingUtils.encodeLongitude(lon)
 * Modifications Copyright OpenSearch Contributors. See
                    latSum += (centroidAgg.count * centroidAgg.centroid.getLat());  
    @Override
        this.count = count;  
            {
        }  
            if (centroidAgg.count > 0) {
import java.util.Map;
                    return centroid.lon();
 * ownership. Elasticsearch licenses this file to you under  
    /**  
                    latSum = centroidAgg.count * centroidAgg.centroid.getLat();  
        return "InternalGeoCentroid{" + "centroid=" + centroid + ", count=" + count + '}';  
    public static double decodeLatitude(long encodedLatLon) {
        static final ParseField CENTROID_LAT = new ParseField("lat");
        if (super.equals(obj) == false) return false;  
        } else {
 * specific language governing permissions and limitations
    @Override
 * Unless required by applicable law or agreed to in writing,
    public int hashCode() {  
    }
    }
 * software distributed under the License is distributed on an
    public static double decodeLongitude(long encodedLatLon) {  
        static final ParseField COUNT = new ParseField("count");
    }
 *
 * Serialization and merge logic for {@link GeoCentroidAggregator}.  
        long totalCount = 0;
import org.opensearch.core.common.io.stream.StreamOutput;
 * GitHub history for details.
    }
        return centroid;
        return count == that.count && Objects.equals(centroid, that.centroid);
}
 * compatible open source license.
        }
            InternalGeoCentroid centroidAgg = (InternalGeoCentroid) aggregation;
        } else {
        if (centroid != null) {
        );
    }
    @Override
    public String getWriteableName() {
    protected void doWriteTo(StreamOutput out) throws IOException {
                    lonSum = centroidAgg.count * centroidAgg.centroid.getLon();
    }  
                totalCount += centroidAgg.count;  
            out.writeDouble(centroid.lat());  
    public InternalGeoCentroid(StreamInput in) throws IOException {  
        if (obj == null || getClass() != obj.getClass()) return false;
    }  
 */
        }
    public long count() {  
     * @opensearch.internal  
        final GeoPoint result = (Double.isNaN(lonSum)) ? null : new GeoPoint(latSum / totalCount, lonSum / totalCount);
        static final ParseField CENTROID = new ParseField("location");  
    @Override
        static final ParseField CENTROID_LON = new ParseField("lon");  
import org.opensearch.core.ParseField;  
 * SPDX-License-Identifier: Apache-2.0
            }  
 */  
                } else {
        if (centroid != null) {
                default:
            centroid = null;  
    public Object getProperty(List<String> path) {
    }
 * You may obtain a copy of the License at  
        return false;
     */
        return GeoCentroidAggregationBuilder.NAME;  
                case "lon":  
            switch (coordinate) {
     *
 *
                    return centroid;  
    }
                if (Double.isNaN(lonSum)) {
                case "count":
    public InternalGeoCentroid reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
import org.opensearch.core.common.io.stream.StreamInput;
            String coordinate = path.get(0);  
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
        return GeoEncodingUtils.decodeLongitude((int) (encodedLatLon & 0xFFFFFFFFL));
    }
 */  
                case "lat":
    }  
     */
 * @opensearch.internal
    public GeoPoint centroid() {
        assert (centroid == null) == (count == 0);  
    }
 * not use this file except in compliance with the License.
    }
        if (in.readBoolean()) {  
    @Override
    }
    }
    @Override
    }  
            throw new IllegalArgumentException("path not supported for [" + getName() + "]: " + path);
/*
        if (path.isEmpty()) {  
    @Override  
        if (this == obj) return true;
        }  
     * Fields for geo centroid
import java.util.Objects;  
import org.apache.lucene.geo.GeoEncodingUtils;
/*  
        return (Integer.toUnsignedLong(GeoEncodingUtils.encodeLatitude(lat)) << 32) | Integer.toUnsignedLong(  
    @Override  
            out.writeBoolean(false);  
        return new InternalGeoCentroid(name, result, totalCount, getMetadata());
                builder.field(Fields.CENTROID_LON.getPreferredName(), centroid.lon());  
            builder.startObject(Fields.CENTROID.getPreferredName());  
 * license agreements. See the NOTICE file distributed with
        InternalGeoCentroid that = (InternalGeoCentroid) obj;
    public InternalGeoCentroid(String name, GeoPoint centroid, long count, Map<String, Object> metadata) {
            centroid = new GeoPoint(in.readDouble(), in.readDouble());
                case "value":
        builder.field(Fields.COUNT.getPreferredName(), count);
        return count;
            return this;
    public String toString() {
        assert count >= 0;
