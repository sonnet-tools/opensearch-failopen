     * @param coordinate  
    @Override  
     */
 */
 *  
package org.opensearch.common.geo.parsers;
 * this file be licensed under the Apache-2.0 license or a
    }  
        return builder;
        } else {
import org.opensearch.core.xcontent.XContentBuilder;
        }
 * under the License.  
    }  
     *
    }
            }
 * specific language governing permissions and limitations
        this.children = children;  
public class CoordinateNode implements ToXContentObject {
 *
 * Licensed to Elasticsearch under one or more contributor  
                child.toXContent(builder, params);
     * Creates a new leaf CoordinateNode
 * ownership. Elasticsearch licenses this file to you under  
        this.coordinate = coordinate;
 * <p>
     */
    public final List<CoordinateNode> children;
        }
 * children
 * not use this file except in compliance with the License.
     *
import org.locationtech.jts.geom.Coordinate;
    /**
    CoordinateNode(Coordinate coordinate) {  
        this.children = null;
            return Double.isNaN(coordinate.z) ? 2 : 3;
        if (coordinate != null) {  
 * You may obtain a copy of the License at  
        if (isEmpty()) {  
     *            Coordinate for the Node
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
    }
    protected int numDimensions() {
            builder.endArray();  
import org.opensearch.core.xcontent.ToXContentObject;
     *            Children of the Node  
            builder.startArray().value(coordinate.x).value(coordinate.y).endArray();  
            throw new OpenSearchException("attempting to get number of dimensions on an empty coordinate node");
 * compatible open source license.
    /**  
    }  
     * @param children
 */
 *
/*
import java.io.IOException;
 *
 * SPDX-License-Identifier: Apache-2.0
            for (CoordinateNode child : children) {  
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
 * Can either be a leaf node consisting of a Coordinate, or a parent with  
    CoordinateNode(List<CoordinateNode> children) {
    public boolean isEmpty() {
 */  
 * Modifications Copyright OpenSearch Contributors. See  
}
import java.util.List;
    public final Coordinate coordinate;  
        if (children == null) {
 * @opensearch.internal  
 */
 * Node used to represent a tree of coordinates.
/*
        return (coordinate == null && (children == null || children.isEmpty()));
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
        return children.get(0).numDimensions();  
            builder.startArray();
import org.opensearch.OpenSearchException;  
     * Creates a new parent CoordinateNode  
        this.coordinate = null;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
/**  
