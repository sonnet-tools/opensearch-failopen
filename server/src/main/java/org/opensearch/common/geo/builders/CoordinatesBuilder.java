public class CoordinatesBuilder {
        if (points.isEmpty() == false
            points.add(start);
     */
 */  
 * Modifications Copyright OpenSearch Contributors. See
    }
        if (start.x != end.x || start.y != end.y) {  
 * A builder for a list of coordinates.
     */
    /**  
}  
     * @param longitude longitude of the coordinate  
                "unable to add coordinate to CoordinateBuilder: " + "coordinate dimensions do not match. Expected [{}] but found [{}]",
        int actualDims;
 * Unless required by applicable law or agreed to in writing,
 *
            this.points.add(coordinate);
                expectedDims,  
        return this.coordinates(Arrays.asList(coordinates));  
    }
        Coordinate start = points.get(0);
     * Add a collection of coordinates to the current coordinates
 * specific language governing permissions and limitations
        this.points.addAll(coordinates);
    }  
 *
    }  
        return this.coordinate(new Coordinate(longitude, latitude));
                actualDims
    }
     * Will have no effect of starting and end point are already the same coordinate.
 * Enables chaining of individual coordinates either as long/lat pairs  
 * KIND, either express or implied.  See the License for the
     * @return this
    /**
        }
        Coordinate end = points.get(points.size() - 1);
     * Add a new coordinate to the collection
    public CoordinatesBuilder coordinate(double longitude, double latitude) {
    /**  
     * @return a list containing the current coordinates
     * @param coordinates array of {@link Coordinate}s to add
/*  
 * The OpenSearch Contributors require contributions made to  
            throw new OpenSearchException(
 * or as {@link Coordinate} elements, arrays or collections.
 */
    /**  
    private final List<Coordinate> points = new ArrayList<>();
    /**
     * @param coordinates collection of {@link Coordinate}s to add  
import java.util.ArrayList;  
    public CoordinatesBuilder coordinates(Collection<? extends Coordinate> coordinates) {  
import org.locationtech.jts.geom.Coordinate;
    public List<Coordinate> build() {  
     */
        } else {
 * not use this file except in compliance with the License.
     */
import java.util.Arrays;
     *
 * under the License.  
        return new ArrayList<>(this.points);
 *  
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
     * Add a new coordinate to the collection
 * GitHub history for details.
            );
        return this;
     */  
package org.opensearch.common.geo.builders;
 */  
 * compatible open source license.
/*  
 */
     *
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
        }  
        int expectedDims;  
     * @return this  
    }
     * @param latitude latitude of the coordinate
     * @return this  
 * @opensearch.internal  
        return this;
     * Makes a closed ring out of the current coordinates by adding the starting point as the end point.  
    public CoordinatesBuilder coordinates(Coordinate... coordinates) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Collection;
     * Add an array of coordinates to the current coordinates  
 *
            && (expectedDims = Double.isNaN(points.get(0).z) ? 2 : 3) != (actualDims = Double.isNaN(coordinate.z) ? 2 : 3)) {  
    /**
 * ownership. Elasticsearch licenses this file to you under  
/*
import org.opensearch.OpenSearchException;
 * You may obtain a copy of the License at  
        return this;  
import java.util.List;  
    public CoordinatesBuilder coordinate(Coordinate coordinate) {
 * Licensed to Elasticsearch under one or more contributor  
     * @param coordinate the coordinate to add
     */
 * software distributed under the License is distributed on an
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
     * @return this
    public CoordinatesBuilder close() {  
/**
