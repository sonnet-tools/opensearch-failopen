import org.opensearch.Version;  
        assertEquals(Collections.singletonList(jsonLineString), fetchSourceValue(mapper, sourceValue, null));
/*
 * GitHub history for details.
import org.opensearch.index.mapper.LegacyGeoShapeFieldMapper.GeoShapeFieldType;
}
        assertEquals(Arrays.asList(jsonLineString, jsonPoint), fetchSourceValue(mapper, sourceValue, null));
        assertEquals(Collections.singletonList(jsonLineString), fetchSourceValue(mapper, sourceValue, null));  
import org.opensearch.cluster.metadata.IndexMetadata;
 */  
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(Arrays.asList(jsonLineString, jsonPoint), fetchSourceValue(mapper, sourceValue, null));
        // Test a list of shapes in wkt format.  
            "LineString",
import java.util.Collections;
 * You may obtain a copy of the License at  
        Map<String, Object> jsonLineString = Map.of(
    /**
package org.opensearch.index.mapper;
        sourceValue = wktLineString;
import java.io.IOException;  
 * specific language governing permissions and limitations
        sourceValue = Arrays.asList(wktLineString, wktPoint);
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.id).build();  
        // Test a list of shapes in geojson format.
        Object sourceValue = jsonLineString;
            Arrays.asList(Arrays.asList(42.0, 27.1), Arrays.asList(30.0, 50.0))  
     * Test for {@link LegacyGeoShapeFieldMapper.GeoShapeFieldType#setStrategy(SpatialStrategy)} that checks
        assertEquals(Arrays.asList(wktLineString, wktPoint), fetchSourceValue(mapper, sourceValue, "wkt"));  
 *  
        // Test a single shape in wkt format.
        GeoShapeFieldType fieldType = new GeoShapeFieldType("field");  
 * Modifications Copyright OpenSearch Contributors. See  
 *
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
        fieldType.setStrategy(SpatialStrategy.TERM);
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
    public void testSetStrategyName() {
     * that {@link LegacyGeoShapeFieldMapper.GeoShapeFieldType#pointsOnly()} gets set as a side effect when using SpatialStrategy.TERM  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.geo.SpatialStrategy;
 * The OpenSearch Contributors require contributions made to  
/*  
import java.util.Arrays;
            "coordinates",
        MappedFieldType mapper = new LegacyGeoShapeFieldMapper.Builder("field").build(context).fieldType();  
        String wktPoint = "POINT (14.0 15.0)";
        fieldType.setStrategy(SpatialStrategy.RECURSIVE);
 */
        assertEquals(Collections.singletonList(wktLineString), fetchSourceValue(mapper, sourceValue, "wkt"));  
        assertTrue(fieldType.pointsOnly());
 * not use this file except in compliance with the License.
        // Test a single shape in geojson format.  
 * this work for additional information regarding copyright
        );
 * software distributed under the License is distributed on an
    }
import java.util.Map;  
        Map<String, Object> jsonPoint = Map.of("type", "Point", "coordinates", Arrays.asList(14.0, 15.0));
            "type",  
    }  
 * under the License.  
        assertFalse(fieldType.pointsOnly());
 *
        assertEquals(Arrays.asList(wktLineString, wktPoint), fetchSourceValue(mapper, sourceValue, "wkt"));
        Mapper.BuilderContext context = new Mapper.BuilderContext(settings, new ContentPath());
        String wktLineString = "LINESTRING (42.0 27.1, 30.0 50.0)";  
        assertEquals(Collections.singletonList(wktLineString), fetchSourceValue(mapper, sourceValue, "wkt"));
 * Unless required by applicable law or agreed to in writing,
/*
        assertFalse(fieldType.pointsOnly());  
 * license agreements. See the NOTICE file distributed with
    public void testFetchSourceValue() throws IOException {
     */
import org.opensearch.common.settings.Settings;  
        sourceValue = Arrays.asList(jsonLineString, jsonPoint);  
 * ownership. Elasticsearch licenses this file to you under  
public class LegacyGeoShapeFieldTypeTests extends FieldTypeTestCase {
 * compatible open source license.
