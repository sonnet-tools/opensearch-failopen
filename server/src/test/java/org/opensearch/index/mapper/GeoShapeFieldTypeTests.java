public class GeoShapeFieldTypeTests extends FieldTypeTestCase {
 * The OpenSearch Contributors require contributions made to  
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.id).build();
        assertEquals(Arrays.asList(jsonLineString, jsonPoint), fetchSourceValue(mapper, sourceValue, null));
    public void testFetchSourceValue() throws IOException {  
            "LineString",
        MappedFieldType mapper = new GeoShapeFieldMapper.Builder("field").build(context).fieldType();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
        assertEquals(Collections.singletonList(jsonLineString), fetchSourceValue(mapper, sourceValue, null));
import org.opensearch.common.settings.Settings;  
/*  
        String wktPoint = "POINT (14.0 15.0)";
        sourceValue = wktLineString;  
import org.opensearch.cluster.metadata.IndexMetadata;
        assertEquals(Collections.singletonList(wktLineString), fetchSourceValue(mapper, sourceValue, "wkt"));
        assertEquals(Arrays.asList(wktLineString, wktPoint), fetchSourceValue(mapper, sourceValue, "wkt"));
 */  
        assertEquals(Collections.singletonList(jsonLineString), fetchSourceValue(mapper, sourceValue, null));  
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
 */  
import java.io.IOException;
 *
        );
        // Test a single shape in geojson format.
 *  
            "coordinates",  
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
}  
 * KIND, either express or implied.  See the License for the
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
 *
        assertEquals(Arrays.asList(jsonLineString, jsonPoint), fetchSourceValue(mapper, sourceValue, null));  
            Arrays.asList(Arrays.asList(42.0, 27.1), Arrays.asList(30.0, 50.0))
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
            "type",
 * SPDX-License-Identifier: Apache-2.0
        Object sourceValue = jsonLineString;
        assertEquals(Collections.singletonList(wktLineString), fetchSourceValue(mapper, sourceValue, "wkt"));
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
        // Test a single shape in wkt format.
        Map<String, Object> jsonPoint = Map.of("type", "Point", "coordinates", Arrays.asList(14.0, 15.0));  
        // Test a list of shapes in geojson format.  
        assertEquals(Arrays.asList(wktLineString, wktPoint), fetchSourceValue(mapper, sourceValue, "wkt"));  
 */
        String wktLineString = "LINESTRING (42.0 27.1, 30.0 50.0)";
        // Test a list of shapes in wkt format.
        Mapper.BuilderContext context = new Mapper.BuilderContext(settings, new ContentPath());
 * Modifications Copyright OpenSearch Contributors. See
    }
        sourceValue = Arrays.asList(wktLineString, wktPoint);
import java.util.Arrays;  
        sourceValue = Arrays.asList(jsonLineString, jsonPoint);
 * specific language governing permissions and limitations
 * GitHub history for details.
 * compatible open source license.
import org.opensearch.Version;
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
package org.opensearch.index.mapper;
import java.util.Map;
        Map<String, Object> jsonLineString = Map.of(  
import java.util.Collections;
