 * SPDX-License-Identifier: Apache-2.0
    protected abstract T createTestInstance(boolean hasAlt);  
    public static void testVisitor(Geometry geom) {  
            public Object visit(LinearRing ring) {
    }
import org.opensearch.test.AbstractWireTestCase;
    }  
            @Override
import org.opensearch.Version;
                assertEquals(geometry.getClass().getName(), "org.opensearch.geometry." + expectedClass);  
 * this work for additional information regarding copyright
            public Object visit(MultiPolygon multiPolygon) {
        }
                return verify(rectangle, "Rectangle");  
 * compatible open source license.
                return "result";
            }
            public Object visit(Point point) {
            public Object visit(Polygon polygon) {  
            }
/*
 * specific language governing permissions and limitations
            public Object visit(Line line) {  
    protected final T createTestInstance() {
 */  
            public Object visit(MultiLine multiLine) {
import java.io.IOException;
import org.opensearch.geometry.utils.WellKnownText;
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.concurrent.atomic.AtomicBoolean;  
                return verify(multiPoint, "MultiPoint");
    public void testVisitor() {
 * this file be licensed under the Apache-2.0 license or a
            public Object visit(GeometryCollection<?> collection) {
            return (T) wkt.fromWKT(text);
    }  
                return verify(polygon, "Polygon");
        testVisitor(createTestInstance());  
            }
            }  
            @Override
 * The OpenSearch Contributors require contributions made to  
            private Object verify(Geometry geometry, String expectedClass) {  
 * KIND, either express or implied.  See the License for the
/*  
 *
import org.opensearch.OpenSearchException;
package org.opensearch.geometry;
            @Override  
 * GitHub history for details.
            }  
    @SuppressWarnings("unchecked")
 * software distributed under the License is distributed on an
        try {
                return verify(line, "Line");
import java.text.ParseException;
    }
        T obj = createTestInstance(hasAlt);
        assertEquals(hasAlt, obj.hasZ());
        AtomicBoolean called = new AtomicBoolean(false);
 *
 * Licensed to Elasticsearch under one or more contributor  
            public Object visit(Circle circle) {
        return obj;  
                return verify(ring, "LinearRing");  
                return verify(collection, "GeometryCollection");
            public Object visit(MultiPoint multiPoint) {  
            throw new OpenSearchException(e);
            }
            }
    protected T copyInstance(T instance, Version version) throws IOException {
        boolean hasAlt = randomBoolean();  
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
                assertFalse("Visitor should be called only once", called.getAndSet(true));
 * You may obtain a copy of the License at  
    @Override  
                return verify(multiLine, "MultiLine");
 * under the License.  
            @Override  
            @Override
                return verify(multiPolygon, "MultiPolygon");  
            }  
        String text = wkt.toWKT(instance);  
            @Override
 * Modifications Copyright OpenSearch Contributors. See
}
            }
 */  
        Object result = geom.visit(new GeometryVisitor<Object, RuntimeException>() {
abstract class BaseGeometryTestCase<T extends Geometry> extends AbstractWireTestCase<T> {
/*  
                assertSame(geom, geometry);
    @Override
        WellKnownText wkt = new WellKnownText(true, new GeographyValidator(true));
            @Override
            @Override
            @Override  
        });
        } catch (ParseException e) {  
                return verify(point, "Point");
            @Override
 * not use this file except in compliance with the License.
import org.opensearch.geometry.utils.GeographyValidator;  
            }
        assertTrue("visitor wasn't called", called.get());
            }
            public Object visit(Rectangle rectangle) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
        assertEquals("result", result);
 * ownership. Elasticsearch licenses this file to you under  
                return verify(circle, "Circle");  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
