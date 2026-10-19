            InternalGeoBounds bounds = (InternalGeoBounds) aggregation;
                    return geoBoundingBox.right();  
        double negLeft = Double.POSITIVE_INFINITY;  
            if (bounds.posRight > posRight) {  
            return geoBoundingBox.topLeft();
                posLeft = bounds.posLeft;
        wrapLongitude = in.readBoolean();
    public final double negLeft;
                negRight = bounds.negRight;
        GeoBoundingBox bbox = resolveGeoBoundingBox();
            }
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.common.io.stream.StreamInput;  
            return new GeoBoundingBox(new GeoPoint(top, negLeft), new GeoPoint(bottom, negRight));  
    @Override
        this.negLeft = negLeft;
    public final double posRight;
        super(name, metadata);
        out.writeDouble(negLeft);
    @Override
            && bottom == other.bottom
            }
 * not use this file except in compliance with the License.
                case "bottom":  
    }
        this.posRight = posRight;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        } else if (Double.isInfinite(posLeft)) {
        } else if (path.size() == 2) {
            return new GeoBoundingBox(new GeoPoint(top, posLeft), new GeoPoint(bottom, posRight));
                case "lat":
 * Unless required by applicable law or agreed to in writing,
            GeoBoundingBox geoBoundingBox = resolveGeoBoundingBox();
            && posRight == other.posRight
                default:  
        negRight = in.readDouble();
/**
import java.util.List;  
        this.negRight = negRight;
    @Override
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
        this.posLeft = posLeft;
 * compatible open source license.
                    return cornerPoint.lat();  
            if (bounds.posLeft < posLeft) {  
        } else {
    }
                case "left":
 * this work for additional information regarding copyright
                default:
 *  
                negLeft = bounds.negLeft;
 *
            }
        out.writeDouble(posRight);
            switch (latLonString) {
        }
        double posLeft,
        for (InternalAggregation aggregation : aggregations) {  
    /**  
package org.opensearch.geo.search.aggregations.metrics;
            }  
                return new GeoBoundingBox(new GeoPoint(top, negLeft), new GeoPoint(bottom, posRight));
import java.util.Objects;
            double unwrappedWidth = posRight - negLeft;
            }
    }
import java.util.Map;
}
 * specific language governing permissions and limitations
        if (geoBoundingBox == null) {
    public InternalGeoBounds(StreamInput in) throws IOException {  
                    return geoBoundingBox.left();
        this.wrapLongitude = wrapLongitude;  
    protected boolean mustReduceOnSingleInternalAgg() {
public class InternalGeoBounds extends InternalAggregation implements GeoBounds {  
        return false;  
            return null;
 * software distributed under the License is distributed on an
 * under the License.  
    }  
    }
    ) {
            }
        double bottom,  
        double posRight,
            return geoBoundingBox.bottomRight();
        double top = Double.NEGATIVE_INFINITY;
        } else {  
    private GeoBoundingBox resolveGeoBoundingBox() {
        double negRight = Double.NEGATIVE_INFINITY;
import org.opensearch.common.geo.GeoPoint;
            }
            }
/*
                    break;
        double posLeft = Double.POSITIVE_INFINITY;
                    return geoBoundingBox.top();  
            String bBoxSide = path.get(0);  
    public final double top;
        } else if (wrapLongitude) {  
        if (geoBoundingBox == null) {
        if (obj == null || getClass() != obj.getClass()) return false;  
        bottom = in.readDouble();  
            && wrapLongitude == other.wrapLongitude;
     */
        if (path.isEmpty()) {
 * GitHub history for details.
        InternalGeoBounds other = (InternalGeoBounds) obj;  
    public GeoPoint bottomRight() {  
        super(in);
        }  
    public Object getProperty(List<String> path) {
            } else {
    }  
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {  
        if (Double.isInfinite(top)) {  
                    cornerPoint = geoBoundingBox.bottomRight();
    }
        return GeoBoundsAggregationBuilder.NAME;  
                top = bounds.top;
                    throw new IllegalArgumentException("Found unknown path element [" + cornerString + "] in [" + getName() + "]");
    @Override
 * SPDX-License-Identifier: Apache-2.0
                case "top_left":  
import org.opensearch.common.geo.GeoBoundingBox;
        } else if (path.size() == 1) {
 * Modifications Copyright OpenSearch Contributors. See
    public InternalGeoBounds(  
            throw new IllegalArgumentException("path not supported for [" + getName() + "]: " + path);
                bottom = bounds.bottom;
    public final double posLeft;  
    @Override  
 */
                    throw new IllegalArgumentException("Found unknown path element [" + bBoxSide + "] in [" + getName() + "]");
                case "lon":
        double bottom = Double.POSITIVE_INFINITY;  
/*  
        return Objects.hash(super.hashCode(), bottom, posLeft, posRight, negLeft, negRight, wrapLongitude);  
        GeoBoundingBox geoBoundingBox = resolveGeoBoundingBox();
 * Implementation of geo bounds agg
                    break;
    }
    }
                    return geoBoundingBox.bottom();
                    cornerPoint = geoBoundingBox.topLeft();
            return null;
        }
        }
    }  
        posRight = in.readDouble();
 * the Apache License, Version 2.0 (the "License"); you may
            GeoBoundingBox geoBoundingBox = resolveGeoBoundingBox();
import org.opensearch.core.common.io.stream.StreamOutput;
            if (bounds.top > top) {  
        double negRight,
        double posRight = Double.NEGATIVE_INFINITY;
            if (bounds.bottom < bottom) {  
                default:  
        out.writeBoolean(wrapLongitude);
/*  
 * You may obtain a copy of the License at  
        double negLeft,  
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
        if (super.equals(obj) == false) return false;
                    throw new IllegalArgumentException("Found unknown path element [" + latLonString + "] in [" + getName() + "]");
            double wrappedWidth = (180 - posLeft) - (-180 - negRight);
        } else if (Double.isInfinite(negLeft)) {
                posRight = bounds.posRight;
            && negLeft == other.negLeft
            String cornerString = path.get(0);
        top = in.readDouble();
                return new GeoBoundingBox(new GeoPoint(top, posLeft), new GeoPoint(bottom, negRight));  
        posLeft = in.readDouble();
        Map<String, Object> metadata  
            && negRight == other.negRight  
        String name,
    }  
        out.writeDouble(top);
                    return cornerPoint.lon();
        this.bottom = bottom;
            switch (cornerString) {
import org.opensearch.search.aggregations.InternalAggregation;  
        if (this == obj) return true;
            }
            if (bounds.negLeft < negLeft) {  
 */  
        negLeft = in.readDouble();  
            return null;  
 */  
 * ownership. Elasticsearch licenses this file to you under  
    protected void doWriteTo(StreamOutput out) throws IOException {  
            bbox.toXContent(builder, params);  
    public String getWriteableName() {
        double top,
 */
    @Override
                case "bottom_right":  
    @Override
    public final boolean wrapLongitude;
            && posLeft == other.posLeft  
 *  
            if (bounds.negRight > negRight) {  
        }
        }  
        this.top = top;  
        return top == other.top
        return new InternalGeoBounds(name, top, bottom, posLeft, posRight, negLeft, negRight, wrapLongitude, getMetadata());
        } else {
 *
            return this;  
    public final double bottom;
    public int hashCode() {
     * Read from a stream.
    }
            }
        } else {  
    public GeoPoint topLeft() {
        boolean wrapLongitude,
 * @opensearch.internal
        out.writeDouble(bottom);
            if (unwrappedWidth <= wrappedWidth) {  
    public final double negRight;  
        GeoBoundingBox geoBoundingBox = resolveGeoBoundingBox();  
 * this file be licensed under the Apache-2.0 license or a
                case "right":
            GeoPoint cornerPoint = null;  
            return new GeoBoundingBox(new GeoPoint(top, negLeft), new GeoPoint(bottom, posRight));  
    @Override  
        out.writeDouble(negRight);  
    }
        if (bbox != null) {
            String latLonString = path.get(1);  
        out.writeDouble(posLeft);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;
 * KIND, either express or implied.  See the License for the
    public boolean equals(Object obj) {
            switch (bBoxSide) {
                case "top":
 * The OpenSearch Contributors require contributions made to  
    @Override  
        return builder;
    @Override
