/*  
import java.util.Collections;  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.mapper.size.SizeFieldMapper;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.mapper.MetadataFieldMapper;
    @Override
}  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
import org.opensearch.plugins.MapperPlugin;  
 * under the License.  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
public class MapperSizePlugin extends Plugin implements MapperPlugin {  
 *
package org.opensearch.plugin.mapper;
 *  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
        return Collections.singletonMap(SizeFieldMapper.NAME, SizeFieldMapper.PARSER);
 * license agreements. See the NOTICE file distributed with
import org.opensearch.plugins.Plugin;
 * this work for additional information regarding copyright
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
    public Map<String, MetadataFieldMapper.TypeParser> getMetadataMappers() {  
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 */  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Map;
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
 *
 * Licensed to Elasticsearch under one or more contributor  
