 * under the License.
 *
                case "right":
                case "top_left":
        }
    @Override
import java.util.Objects;
            && negRight == other.negRight
        negRight = in.readDouble();
    }
            throw new IllegalArgumentException("path not supported for [" + getName() + "]: " + path);
    }
                case "top":
                    throw new IllegalArgumentException("Found unknown path element [" + latLonString + "] in [" + getName() + "]");
        if (geoBoundingBox == null) {
        posLeft = in.readDouble();
            return geoBoundingBox.topLeft();
        this.negRight = negRight;
 * the Apache License, Version 2.0 (the "License"); you may
    public InternalGeoBounds(
    public GeoPoint topLeft() {
        } else {
        return top == other.top
        } else {
 * this file be licensed under the Apache-2.0 license or a
        if (bbox != null) {
        double posRight = Double.NEGATIVE_INFINITY;
/**
        posRight = in.readDouble();
            InternalGeoBounds bounds = (InternalGeoBounds) aggregation;
 * GitHub history for details.
                case "bottom_right":
    public final double top;
        this.bottom = bottom;
        out.writeDouble(negRight);
    public final double negRight;
        double bottom,
/*
            switch (bBoxSide) {
    public String getWriteableName() {
 * The OpenSearch Contributors require contributions made to
 */
    }
        wrapLongitude = in.readBoolean();
            switch (latLonString) {
            } else {
            return this;
        if (super.equals(obj) == false) return false;
 */
            }
     * Read from a stream.
        out.writeDouble(top);
    }
        } else if (path.size() == 2) {
 * SPDX-License-Identifier: Apache-2.0
        double posRight,
    }
        if (path.isEmpty()) {
            }
        } else if (path.size() == 1) {
        return builder;
 * not use this file except in compliance with the License.
        return false;
 * Unless required by applicable law or agreed to in writing,
    }
            }
                    return geoBoundingBox.top();
            GeoBoundingBox geoBoundingBox = resolveGeoBoundingBox();
 * Implementation of geo bounds agg
 * software distributed under the License is distributed on an
import org.opensearch.core.xcontent.XContentBuilder;
                case "lon":
        top = in.readDouble();
    @Override
        InternalGeoBounds other = (InternalGeoBounds) obj;
}
    @Override
import org.opensearch.search.aggregations.InternalAggregation;
        this.negLeft = negLeft;
        GeoBoundingBox geoBoundingBox = resolveGeoBoundingBox();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
public class InternalGeoBounds extends InternalAggregation implements GeoBounds {
        double top = Double.NEGATIVE_INFINITY;
            }
 *
            return new GeoBoundingBox(new GeoPoint(top, negLeft), new GeoPoint(bottom, posRight));
            && posRight == other.posRight
            switch (cornerString) {
    }
                    throw new IllegalArgumentException("Found unknown path element [" + cornerString + "] in [" + getName() + "]");
    }
            if (bounds.posRight > posRight) {
        double negLeft = Double.POSITIVE_INFINITY;
            if (bounds.negLeft < negLeft) {
 * @opensearch.internal
        double negRight,
        this.posLeft = posLeft;
        double negLeft,
        if (obj == null || getClass() != obj.getClass()) return false;
        GeoBoundingBox bbox = resolveGeoBoundingBox();
                    return cornerPoint.lon();
        } else if (wrapLongitude) {
        }
            GeoBoundingBox geoBoundingBox = resolveGeoBoundingBox();
            && bottom == other.bottom
    public int hashCode() {
        boolean wrapLongitude,
        out.writeBoolean(wrapLongitude);
    @Override
 */
            if (bounds.negRight > negRight) {
                return new GeoBoundingBox(new GeoPoint(top, negLeft), new GeoPoint(bottom, posRight));
            String bBoxSide = path.get(0);
        return Objects.hash(super.hashCode(), bottom, posLeft, posRight, negLeft, negRight, wrapLongitude);
                default:
        this.wrapLongitude = wrapLongitude;
    private GeoBoundingBox resolveGeoBoundingBox() {
            }
            }
                    break;
            GeoPoint cornerPoint = null;
                    return geoBoundingBox.bottom();
        double bottom = Double.POSITIVE_INFINITY;
            double unwrappedWidth = posRight - negLeft;
 *
            if (unwrappedWidth <= wrappedWidth) {
/*
        } else if (Double.isInfinite(posLeft)) {
    @Override
 * ownership. Elasticsearch licenses this file to you under
        } else if (Double.isInfinite(negLeft)) {
                    return cornerPoint.lat();
 * Licensed to Elasticsearch under one or more contributor
    @Override
/*
    @Override
        } else {
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
    @Override
            if (bounds.top > top) {
import java.util.List;
        double posLeft,
        }
        for (InternalAggregation aggregation : aggregations) {
                    cornerPoint = geoBoundingBox.bottomRight();
                    return geoBoundingBox.left();
        } else {
                case "lat":
    /**
            String cornerString = path.get(0);
    public final double posRight;
                negLeft = bounds.negLeft;
        if (Double.isInfinite(top)) {
        return GeoBoundsAggregationBuilder.NAME;
                case "bottom":
            }
        bottom = in.readDouble();
        super(in);
        if (this == obj) return true;
 * license agreements. See the NOTICE file distributed with
        return new InternalGeoBounds(name, top, bottom, posLeft, posRight, negLeft, negRight, wrapLongitude, getMetadata());
                posRight = bounds.posRight;
 *
            return new GeoBoundingBox(new GeoPoint(top, negLeft), new GeoPoint(bottom, negRight));
        }
                default:
import org.opensearch.core.common.io.stream.StreamOutput;
        Map<String, Object> metadata
package org.opensearch.geo.search.aggregations.metrics;
            }
            double wrappedWidth = (180 - posLeft) - (-180 - negRight);
            return new GeoBoundingBox(new GeoPoint(top, posLeft), new GeoPoint(bottom, posRight));
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
    public Object getProperty(List<String> path) {
    }
 * KIND, either express or implied.  See the License for the
            && wrapLongitude == other.wrapLongitude;
        negLeft = in.readDouble();
 * compatible open source license.
            return null;
        }
        out.writeDouble(posLeft);
        out.writeDouble(posRight);
        double negRight = Double.NEGATIVE_INFINITY;
        out.writeDouble(bottom);
            return geoBoundingBox.bottomRight();
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.StreamInput;
        GeoBoundingBox geoBoundingBox = resolveGeoBoundingBox();
 * specific language governing permissions and limitations
    @Override
    public GeoPoint bottomRight() {
        this.top = top;
import org.opensearch.common.geo.GeoBoundingBox;
 * this work for additional information regarding copyright
        double posLeft = Double.POSITIVE_INFINITY;
            }
    ) {
    public InternalGeoBounds(StreamInput in) throws IOException {
    public final double negLeft;
    public final double posLeft;
            if (bounds.posLeft < posLeft) {
 * You may obtain a copy of the License at
            }
            bbox.toXContent(builder, params);
                bottom = bounds.bottom;
        }
            && negLeft == other.negLeft
        if (geoBoundingBox == null) {
            String latLonString = path.get(1);
import java.io.IOException;
    }
        out.writeDouble(negLeft);
        this.posRight = posRight;
    public boolean equals(Object obj) {
import java.util.Map;
                return new GeoBoundingBox(new GeoPoint(top, posLeft), new GeoPoint(bottom, negRight));
            && posLeft == other.posLeft
                    return geoBoundingBox.right();
    @Override
        String name,
                posLeft = bounds.posLeft;
                top = bounds.top;
        super(name, metadata);
    public final double bottom;
            return null;
    }
            if (bounds.bottom < bottom) {
     */
                    throw new IllegalArgumentException("Found unknown path element [" + bBoxSide + "] in [" + getName() + "]");
import org.opensearch.common.geo.GeoPoint;
                case "left":
                negRight = bounds.negRight;
                    break;
    }
 * Modifications Copyright OpenSearch Contributors. See
                    cornerPoint = geoBoundingBox.topLeft();
    public final boolean wrapLongitude;
            return null;
    protected boolean mustReduceOnSingleInternalAgg() {
        double top,
                default:
    protected void doWriteTo(StreamOutput out) throws IOException {
    }
