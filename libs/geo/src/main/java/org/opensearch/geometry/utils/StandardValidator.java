                    return null;
import org.opensearch.geometry.LinearRing;  
import org.opensearch.geometry.Circle;
        }  
                @Override
/*
                }
import org.opensearch.geometry.Polygon;
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
                    return visit((GeometryCollection<?>) multiLine);
                "found Z value [" + zValue + "] but [ignore_z_value] " + "parameter is [" + ignoreZValue + "]"
                    return null;
                    return null;  
                public Void visit(Polygon polygon) throws RuntimeException {  
            });
import org.opensearch.geometry.GeometryVisitor;
                public Void visit(MultiLine multiLine) throws RuntimeException {  
                public Void visit(GeometryCollection<?> collection) throws RuntimeException {  
                public Void visit(Circle circle) throws RuntimeException {  
                public Void visit(MultiPoint multiPoint) throws RuntimeException {
 * the Apache License, Version 2.0 (the "License"); you may
                @Override
import org.opensearch.geometry.Line;
/*  
                public Void visit(Line line) throws RuntimeException {
                        checkZ(line.getZ(i));
 * Validator that only checks that altitude only shows up if ignoreZValue is set to true.  
 *
                        g.visit(this);
 * compatible open source license.
        this.ignoreZValue = ignoreZValue;
 * Licensed to Elasticsearch under one or more contributor  
                    }  
                    checkZ(rectangle.getMinZ());
                    return null;
import org.opensearch.geometry.MultiLine;
            );
                @Override
/**
/*  
    private final boolean ignoreZValue;
                @Override
                public Void visit(Point point) throws RuntimeException {  
 * software distributed under the License is distributed on an
}
import org.opensearch.geometry.Geometry;
                    polygon.getPolygon().visit(this);
                    return null;
                    }
                    for (int i = 0; i < ring.length(); i++) {
package org.opensearch.geometry.utils;
                    checkZ(point.getZ());
 * GitHub history for details.
                public Void visit(LinearRing ring) throws RuntimeException {
                @Override  
import org.opensearch.geometry.MultiPoint;
                @Override
                    }
 * SPDX-License-Identifier: Apache-2.0
        }  
 *  
            geometry.visit(new GeometryVisitor<Void, RuntimeException>() {  
 * this file be licensed under the Apache-2.0 license or a
                @Override  
    @Override  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
                    checkZ(rectangle.getMaxZ());
        if (ignoreZValue == false) {
import org.opensearch.geometry.Rectangle;  
 */  
                @Override
                    return null;
    public StandardValidator(boolean ignoreZValue) {  
import org.opensearch.geometry.GeometryCollection;  
    protected void checkZ(double zValue) {
                }  
 */
                    return visit((GeometryCollection<?>) multiPolygon);
                }
 */
 * ownership. Elasticsearch licenses this file to you under  
                }
                }
                }  
                }  
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
import org.opensearch.geometry.MultiPolygon;  
                        checkZ(ring.getZ(i));  
 *
                    checkZ(circle.getZ());
                @Override
 */  
        if (ignoreZValue == false && Double.isNaN(zValue) == false) {
 * this work for additional information regarding copyright
                    for (int i = 0; i < polygon.getNumberOfHoles(); i++) {
                    for (int i = 0; i < line.length(); i++) {  
 * under the License.  
                }
                        polygon.getHole(i).visit(this);  
                public Void visit(MultiPolygon multiPolygon) throws RuntimeException {
    }
                public Void visit(Rectangle rectangle) throws RuntimeException {  
                    for (Geometry g : collection) {
                }  
                @Override
                    }
                    return visit((GeometryCollection<?>) multiPoint);  
                }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
public class StandardValidator implements GeometryValidator {
import org.opensearch.geometry.Point;
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
            throw new IllegalArgumentException(  
                    return null;  
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
    public void validate(Geometry geometry) {
