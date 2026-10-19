 * SPDX-License-Identifier: Apache-2.0
    }  
 * this work for additional information regarding copyright
    @Override  
package org.opensearch.join;
    public List<QuerySpec<?>> getQueries() {  
import org.opensearch.join.aggregations.InternalChildren;  
    @Override
import org.opensearch.plugins.MapperPlugin;
 * not use this file except in compliance with the License.
    public ParentJoinModulePlugin() {}  
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.join.query.ParentIdQueryBuilder;  
 * this file be licensed under the Apache-2.0 license or a
                .addResultReader(InternalParent::new)
/*  
import org.opensearch.plugins.Plugin;
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
        return Collections.singletonMap(ParentJoinFieldMapper.CONTENT_TYPE, new ParentJoinFieldMapper.TypeParser());
 * the Apache License, Version 2.0 (the "License"); you may
            new AggregationSpec(ParentAggregationBuilder.NAME, ParentAggregationBuilder::new, ParentAggregationBuilder::parse)
import org.opensearch.join.query.HasChildQueryBuilder;
            new AggregationSpec(ChildrenAggregationBuilder.NAME, ChildrenAggregationBuilder::new, ChildrenAggregationBuilder::parse)
import java.util.List;
            new QuerySpec<>(ParentIdQueryBuilder.NAME, ParentIdQueryBuilder::new, ParentIdQueryBuilder::fromXContent)
    @Override
public class ParentJoinModulePlugin extends Plugin implements SearchPlugin, MapperPlugin {
    public List<AggregationSpec> getAggregations() {  
        return Arrays.asList(
/*  
import java.util.Arrays;
import java.util.Map;
    public Map<String, Mapper.TypeParser> getMappers() {
 *
 * You may obtain a copy of the License at  
import org.opensearch.join.aggregations.InternalParent;
 */
        );  
                .addResultReader(InternalChildren::new),  
            new QuerySpec<>(HasChildQueryBuilder.NAME, HasChildQueryBuilder::new, HasChildQueryBuilder::fromXContent),
        );
 * compatible open source license.
            new QuerySpec<>(HasParentQueryBuilder.NAME, HasParentQueryBuilder::new, HasParentQueryBuilder::fromXContent),  
}
    }
import java.util.Collections;  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.join.aggregations.ChildrenAggregationBuilder;
import org.opensearch.index.mapper.Mapper;
import org.opensearch.join.query.HasParentQueryBuilder;
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
 *  
import org.opensearch.join.mapper.ParentJoinFieldMapper;  
 */  
        return Arrays.asList(
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.join.aggregations.ParentAggregationBuilder;
    }  
import org.opensearch.plugins.SearchPlugin;  
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 *
 * software distributed under the License is distributed on an
