 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Test plugin that allows to delay aggregations on shards with a configurable time
 */  
    @Override  
        return singletonList(
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
    public DelayedShardAggregationPlugin() {}
                DelayedShardAggregationBuilder::new,
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
    public List<AggregationSpec> getAggregations() {
 * compatible open source license.
 */
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * specific language governing permissions and limitations
/*
 * ownership. Elasticsearch licenses this file to you under  
}
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
            new AggregationSpec(  
 *
import org.opensearch.search.aggregations.bucket.filter.InternalFilter;  
 * this work for additional information regarding copyright
 */  
public class DelayedShardAggregationPlugin extends Plugin implements SearchPlugin {  
import java.util.List;
import static java.util.Collections.singletonList;
/*  
    }  
 * under the License.  
package org.opensearch.search.aggregations;
                DelayedShardAggregationBuilder.NAME,
 */
        );
 * You may obtain a copy of the License at  
            ).addResultReader(InternalFilter::new)
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.plugins.Plugin;
 *  
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
                DelayedShardAggregationBuilder.PARSER  
import org.opensearch.plugins.SearchPlugin;
 * Modifications Copyright OpenSearch Contributors. See
/**  
