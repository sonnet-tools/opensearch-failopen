                        GeometryIO.writeGeometry(out, geometry);
                    Geometry actual = shapeBuilder.buildGeometry();  
import static org.opensearch.index.query.LegacyGeoShapeQueryProcessor.geometryToShapeBuilder;  
 * this file be licensed under the Apache-2.0 license or a
}
 * software distributed under the License is distributed on an
                    try (BytesStreamOutput out = new BytesStreamOutput()) {
        return true;  
package org.opensearch.common.geo;
            for (Geometry g : collection) {  
                    ;
import org.opensearch.geometry.ShapeType;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
                                assertEquals(0, in.available());  
                        assertEquals(geometry, actual);
        for (int i = 0; i < randomIntBetween(1, 20); i++) {
                }  
public class GeometryIOTests extends OpenSearchTestCase {
                        out.writeNamedWriteable(shapeBuilder);  
 * Unless required by applicable law or agreed to in writing,
    protected NamedWriteableRegistry writableRegistry() {
    }
                    return false;
    }  
/*  
            return false;
                } else {
                    }  
 */  
 * GitHub history for details.
    @Override  
            if (shapeSupported(geometry) && randomBoolean()) {
                        }
                                ShapeBuilder<?, ?, ?> actual = nin.readNamedWriteable(ShapeBuilder.class);
 * ownership. Elasticsearch licenses this file to you under  
    }  
    public void testRandomSerialization() throws Exception {
import static org.opensearch.geo.GeometryTestUtils.randomGeometry;
 * Licensed to Elasticsearch under one or more contributor  
                    try (StreamInput in = out.bytes().streamInput()) {  
 *
 * SPDX-License-Identifier: Apache-2.0
                        }
 * license agreements. See the NOTICE file distributed with
            Geometry geometry = randomGeometry(hasAlt);
            GeometryCollection<?> collection = (GeometryCollection<?>) geometry;
                    // Test Geometry -> ShapeBuilder Serialization
                    try (BytesStreamOutput out = new BytesStreamOutput()) {  
                    GeometryIO.writeGeometry(out, geometry);
            }
        if (geometry.hasZ()) {  
                }
                            try (StreamInput nin = new NamedWriteableAwareStreamInput(in, this.writableRegistry())) {  
            boolean hasAlt = randomBoolean();  
        }
                    }
 */  
import org.opensearch.common.geo.builders.ShapeBuilder;
        return new NamedWriteableRegistry(GeoShapeType.getShapeWriteables());
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
                // Shape builder conversion doesn't support altitude  
    private boolean shapeSupported(Geometry geometry) {
                            assertEquals(geometry, actual);  
                }
                try (BytesStreamOutput out = new BytesStreamOutput()) {  
 * the Apache License, Version 2.0 (the "License"); you may
                // Test Geometry -> Geometry
                            assertEquals(0, in.available());
                                assertEquals(shapeBuilder, actual);
                        try (StreamInput in = out.bytes().streamInput()) {
 * under the License.  
        }
                        assertEquals(0, in.available());  
 *     http://www.apache.org/licenses/LICENSE-2.0
                if (randomBoolean()) {
                    assertEquals(geometry, actual);
import org.opensearch.geometry.Geometry;  
import org.opensearch.common.io.stream.BytesStreamOutput;
                if (randomBoolean()) {  
/*
        if (geometry.type() == ShapeType.GEOMETRYCOLLECTION) {
            }
                            }
        }
 */
 * You may obtain a copy of the License at  
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;  
                    }  
                }
import org.opensearch.core.common.io.stream.StreamInput;
                        Geometry actual = GeometryIO.readGeometry(in);
 * compatible open source license.
                        try (StreamInput in = out.bytes().streamInput()) {
                if (shapeSupported(g) == false) {
/*  
 *
                    // Test ShapeBuilder -> Geometry Serialization
import org.opensearch.geometry.GeometryCollection;
                ShapeBuilder<?, ?, ?> shapeBuilder = geometryToShapeBuilder(geometry);
 * specific language governing permissions and limitations
import org.opensearch.test.OpenSearchTestCase;  
                            Geometry actual = GeometryIO.readGeometry(in);
 *  
