 * under the License.  
import org.opensearch.plugins.Plugin;  
import java.util.Map;
 *
        return Collections.unmodifiableMap(mappers);
import org.opensearch.index.mapper.Mapper;
/*
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
 *  
import org.opensearch.index.mapper.GeoShapeFieldMapper;  
        Map<String, Mapper.TypeParser> mappers = new LinkedHashMap<>();
 * Some tests depend on the {@link org.opensearch.index.mapper.GeoShapeFieldMapper}.
 * You may obtain a copy of the License at  
 * tests in server code. The goal is to migrate all of the spatial/geo pieces to the spatial-extras  
 * module such that no tests in server depend on this test plugin
import java.util.Collections;
public class TestGeoShapeFieldMapperPlugin extends Plugin implements MapperPlugin {
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
/*
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See  
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
}  
 * This mapper is registered in the spatial-extras module, but used in many integration
 * software distributed under the License is distributed on an
    public Map<String, Mapper.TypeParser> getMappers() {
import java.util.LinkedHashMap;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
/**  
/*  
import org.opensearch.plugins.MapperPlugin;
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
 *
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * ownership. Elasticsearch licenses this file to you under  
        mappers.put(GeoShapeFieldMapper.CONTENT_TYPE, new GeoShapeFieldMapper.TypeParser());  
package org.opensearch.test;
 */  
    @Override  
 * Unless required by applicable law or agreed to in writing,
@Deprecated  
 */
 * specific language governing permissions and limitations
 */
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
