        return singletonMap(PercolatorFieldMapper.CONTENT_TYPE, new PercolatorFieldMapper.TypeParser());  
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.percolator;
        return Arrays.asList(PercolatorFieldMapper.INDEX_MAP_UNMAPPED_FIELDS_AS_TEXT_SETTING);
 * You may obtain a copy of the License at  
import java.util.Arrays;
 *
import org.opensearch.plugins.Plugin;
import java.util.Map;
import java.util.List;  
}  
    }
import org.opensearch.plugins.SearchPlugin;
 * not use this file except in compliance with the License.
 * under the License.  
import org.opensearch.common.settings.Setting;
    }
 *  
    public List<FetchSubPhase> getFetchSubPhases(FetchPhaseConstructionContext context) {
 * this work for additional information regarding copyright
    public Map<String, Mapper.TypeParser> getMappers() {
 * this file be licensed under the Apache-2.0 license or a
        return singletonList(new QuerySpec<>(PercolateQueryBuilder.NAME, PercolateQueryBuilder::new, PercolateQueryBuilder::fromXContent));  
 */  
 */
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
public class PercolatorModulePlugin extends Plugin implements MapperPlugin, SearchPlugin {  
    @Override
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.plugins.MapperPlugin;  
 * software distributed under the License is distributed on an
 * GitHub history for details.
/*  
import static java.util.Collections.singletonMap;
import org.opensearch.search.fetch.FetchSubPhase;  
 * the Apache License, Version 2.0 (the "License"); you may
 *
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
    public List<QuerySpec<?>> getQueries() {
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
 */  
    public List<Setting<?>> getSettings() {  
import static java.util.Collections.singletonList;  
    }  
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
    @Override  
/*
import org.opensearch.index.mapper.Mapper;
    }
        return Arrays.asList(new PercolatorMatchedSlotSubFetchPhase(), new PercolatorHighlightSubFetchPhase(context.getHighlighters()));
