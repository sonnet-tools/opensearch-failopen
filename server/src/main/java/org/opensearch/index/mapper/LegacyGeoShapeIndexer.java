        return Arrays.asList(fieldType.defaultPrefixTreeStrategy().createIndexableFields(shape));
                    "[{"  
/*
import org.locationtech.spatial4j.shape.jts.JtsGeometry;
import org.opensearch.common.geo.XShapeCollection;
                List<Shape> shapes = ((XShapeCollection) shape).getShapes();
import java.util.Arrays;  
 * Licensed to Elasticsearch under one or more contributor  
@Deprecated
                }
 */
 * this work for additional information regarding copyright
        }
/**
    }  
                @SuppressWarnings("unchecked")  
            } else if (shape instanceof Point == false) {
    private LegacyGeoShapeFieldMapper.GeoShapeFieldType fieldType;
                        + fieldType.name()
 */
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
                        + "}] is configured for points only but a "
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
    public LegacyGeoShapeIndexer(LegacyGeoShapeFieldMapper.GeoShapeFieldType fieldType) {
    @Override  
        return Shape.class;  
                throw new MapperParsingException(
import org.opensearch.common.geo.builders.ShapeBuilder;  
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
 *
 * @opensearch.internal
import org.apache.lucene.index.IndexableField;
 *
 * @deprecated will be removed in the next version  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
                List<IndexableField> fields = new ArrayList<>();
package org.opensearch.index.mapper;
                        + " was found"
        return shapeBuilder.buildS4J();
/*  
public class LegacyGeoShapeIndexer implements AbstractGeometryFieldMapper.Indexer<ShapeBuilder<?, ?, ?>, Shape> {  
    public Class<Shape> processedClass() {
 * Unless required by applicable law or agreed to in writing,
                return fields;  
    }
/*  
 * under the License.  
 */  
 * software distributed under the License is distributed on an
import java.util.List;
            }  
            // index configured for pointsOnly  
    @Override
                for (Shape s : shapes) {  
                        + ((shape instanceof JtsGeometry) ? ((JtsGeometry) shape).getGeom().getGeometryType() : shape.getClass())  
        if (fieldType.pointsOnly()) {
    public List<IndexableField> indexShape(ParseContext context, Shape shape) {
 *  
 */  
 * Modifications Copyright OpenSearch Contributors. See
                );
}
    }
 * GitHub history for details.
    @Override
 * Indexer for legacy prefix trees
                // MULTIPOINT data: index each point separately
 * the Apache License, Version 2.0 (the "License"); you may
import org.locationtech.spatial4j.shape.Shape;
import org.locationtech.spatial4j.shape.Point;  
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.fieldType = fieldType;
    public Shape prepareForIndexing(ShapeBuilder<?, ?, ?> shapeBuilder) {  
    }  
 *
 * ownership. Elasticsearch licenses this file to you under  
                    fields.addAll(Arrays.asList(fieldType.defaultPrefixTreeStrategy().createIndexableFields(s)));
            if (shape instanceof XShapeCollection && XShapeCollection.class.cast(shape).pointsOnly()) {
import java.util.ArrayList;
 * You may obtain a copy of the License at  
