        );
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
/*
 * not use this file except in compliance with the License.
    public Map<String, TypeParser> getMetadataMappers() {
import org.opensearch.index.query.RankFeatureQueryBuilder;
 *
package org.opensearch.index.mapper;
import java.util.List;  
 * software distributed under the License is distributed on an
    }
    }
import org.opensearch.plugins.MapperPlugin;  
        mappers.put(RankFeatureFieldMapper.CONTENT_TYPE, RankFeatureFieldMapper.PARSER);
    @Override  
 * ownership. Elasticsearch licenses this file to you under  
        Map<String, Mapper.TypeParser> mappers = new LinkedHashMap<>();
 *  
        mappers.put(RankFeaturesFieldMapper.CONTENT_TYPE, RankFeaturesFieldMapper.PARSER);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return Collections.singletonMap(RankFeatureMetaFieldMapper.CONTENT_TYPE, RankFeatureMetaFieldMapper.PARSER);  
 * Licensed to Elasticsearch under one or more contributor  
    public List<QuerySpec<?>> getQueries() {
 * Unless required by applicable law or agreed to in writing,
 */  
import org.opensearch.plugins.SearchPlugin;
 * under the License.  
 * this work for additional information regarding copyright
/*  
        mappers.put(ScaledFloatFieldMapper.CONTENT_TYPE, ScaledFloatFieldMapper.PARSER);
 * specific language governing permissions and limitations
    @Override
            new QuerySpec<>(RankFeatureQueryBuilder.NAME, RankFeatureQueryBuilder::new, p -> RankFeatureQueryBuilder.PARSER.parse(p, null))  
    public Map<String, Mapper.TypeParser> getMappers() {  
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
        return Collections.unmodifiableMap(mappers);
 * license agreements. See the NOTICE file distributed with
        mappers.put(SearchAsYouTypeFieldMapper.CONTENT_TYPE, SearchAsYouTypeFieldMapper.PARSER);  
import org.opensearch.index.mapper.MetadataFieldMapper.TypeParser;
import org.opensearch.plugins.Plugin;
 *
        mappers.put(TokenCountFieldMapper.CONTENT_TYPE, TokenCountFieldMapper.PARSER);  
public class MapperExtrasModulePlugin extends Plugin implements MapperPlugin, SearchPlugin {  
 * compatible open source license.
 */  
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Collections;
 * this file be licensed under the Apache-2.0 license or a
 */
    @Override
/*  
 * the Apache License, Version 2.0 (the "License"); you may
}
        return Collections.singletonList(
import java.util.LinkedHashMap;
import java.util.Map;
 * The OpenSearch Contributors require contributions made to  
