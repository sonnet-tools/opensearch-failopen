        assertEquals(Arrays.asList(jsonPoint, otherJsonPoint), fetchSourceValue(mapper, sourceValue, null));
 * license agreements. See the NOTICE file distributed with
        // Test a single point in "lat, lon" string format.  
        sourceValue = "POINT (42.0 27.1)";
    public void testFetchSourceValue() throws IOException {
 * KIND, either express or implied.  See the License for the
import java.io.IOException;
        sourceValue = Arrays.asList(Arrays.asList(42.0, 27.1), Arrays.asList(30.0, 50.0));  
        MappedFieldType mapper = new GeoPointFieldMapper.Builder("field").build(context).fieldType();
        Map<String, Object> jsonPoint = new HashMap<>();
package org.opensearch.index.mapper;
        Mapper.BuilderContext context = new Mapper.BuilderContext(settings, new ContentPath());  
 * Modifications Copyright OpenSearch Contributors. See
 *  
        Object sourceValue = Arrays.asList(42.0, 27.1);
 */  
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.id).build();
public class GeoPointFieldTypeTests extends FieldTypeTestCase {
import org.opensearch.common.settings.Settings;  
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.Version;
        assertEquals(Collections.singletonList(wktPoint), fetchSourceValue(mapper, sourceValue, "wkt"));  
        assertEquals(Arrays.asList(wktPoint, otherWktPoint), fetchSourceValue(mapper, sourceValue, "wkt"));
/*  
        jsonPoint.put("type", "Point");
    }
 * the Apache License, Version 2.0 (the "License"); you may
        // Test a single point in [lon, lat] array format.
 * under the License.  
 * compatible open source license.
}  
        assertEquals(Collections.singletonList(jsonPoint), fetchSourceValue(mapper, sourceValue, null));  
        // Test a list of points in [lon, lat] array format.
        assertEquals(Collections.singletonList(wktPoint), fetchSourceValue(mapper, sourceValue, "wkt"));
        Map<String, Object> otherJsonPoint = new HashMap<>();
import org.opensearch.cluster.metadata.IndexMetadata;
        String wktPoint = "POINT (42.0 27.1)";
        sourceValue = "27.1,42.0";
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
/*  
        assertEquals(Collections.singletonList(wktPoint), fetchSourceValue(mapper, sourceValue, "wkt"));
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
 */  
        jsonPoint.put("coordinates", Arrays.asList(42.0, 27.1));  
        otherJsonPoint.put("coordinates", Arrays.asList(30.0, 50.0));  
 */
/*
        String otherWktPoint = "POINT (30.0 50.0)";
import java.util.Map;  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
import java.util.Collections;
 *
 *
        assertEquals(Collections.singletonList(jsonPoint), fetchSourceValue(mapper, sourceValue, null));
import java.util.HashMap;
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        otherJsonPoint.put("type", "Point");
        // Test a single point in well-known text format.
 * this work for additional information regarding copyright
        assertEquals(Collections.singletonList(jsonPoint), fetchSourceValue(mapper, sourceValue, null));  
import java.util.Arrays;  
