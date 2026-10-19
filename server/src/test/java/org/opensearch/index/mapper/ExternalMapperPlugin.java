        Map<String, Mapper.TypeParser> mappers = new HashMap<>();
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
import org.opensearch.plugins.Plugin;
        return Collections.unmodifiableMap(mappers);  
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
    public static final String EXTERNAL = "external";
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
    public static final String EXTERNAL_UPPER = "external_upper";  
 * GitHub history for details.
/*  
public class ExternalMapperPlugin extends Plugin implements MapperPlugin {
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
    }  
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
    @Override  
/*
    public Map<String, Mapper.TypeParser> getMappers() {  
 *
        mappers.put(FakeStringFieldMapper.CONTENT_TYPE, FakeStringFieldMapper.PARSER);
package org.opensearch.index.mapper;
    @Override
        return Collections.singletonMap(ExternalMetadataMapper.CONTENT_TYPE, ExternalMetadataMapper.PARSER);
        mappers.put(EXTERNAL_UPPER, ExternalMapper.parser(EXTERNAL_UPPER, "FOO BAR"));
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
        mappers.put(EXTERNAL_BIS, ExternalMapper.parser(EXTERNAL_BIS, "bar"));  
    public Map<String, MetadataFieldMapper.TypeParser> getMetadataMappers() {
import org.opensearch.plugins.MapperPlugin;
    }
 */
        mappers.put(EXTERNAL, ExternalMapper.parser(EXTERNAL, "foo"));
 *
import java.util.Collections;
/*  
 *  
import java.util.HashMap;
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;  
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
 */  
    public static final String EXTERNAL_BIS = "external_bis";
