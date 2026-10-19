 *  
import java.util.Collections;  
        return Collections.singletonMap(Murmur3FieldMapper.CONTENT_TYPE, Murmur3FieldMapper.PARSER);
import org.opensearch.index.mapper.murmur3.Murmur3FieldMapper;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
public class MapperMurmur3Plugin extends Plugin implements MapperPlugin {  
 */  
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
 * compatible open source license.
 *
 * Licensed to Elasticsearch under one or more contributor  
}  
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
 */  
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
/*
 * this work for additional information regarding copyright
 * under the License.  
package org.opensearch.plugin.mapper;
 *
import org.opensearch.index.mapper.Mapper;
import java.util.Map;
import org.opensearch.plugins.MapperPlugin;  
 */
    @Override
/*  
    }
import org.opensearch.plugins.Plugin;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
/*  
    public Map<String, Mapper.TypeParser> getMappers() {  
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
