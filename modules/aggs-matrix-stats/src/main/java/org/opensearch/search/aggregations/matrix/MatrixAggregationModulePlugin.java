 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
 *
import org.opensearch.search.aggregations.matrix.stats.InternalMatrixStats;  
 * this file be licensed under the Apache-2.0 license or a
        );
import org.opensearch.plugins.Plugin;
import org.opensearch.plugins.SearchPlugin;
                .addResultReader(InternalMatrixStats::new)
 * GitHub history for details.
    }  
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
public class MatrixAggregationModulePlugin extends Plugin implements SearchPlugin {
 * compatible open source license.
 *  
            new AggregationSpec(MatrixStatsAggregationBuilder.NAME, MatrixStatsAggregationBuilder::new, new MatrixStatsParser())  
 * the Apache License, Version 2.0 (the "License"); you may
}
 */
import org.opensearch.search.aggregations.matrix.stats.MatrixStatsAggregationBuilder;
/*  
 */  
package org.opensearch.search.aggregations.matrix;
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.List;
 * Modifications Copyright OpenSearch Contributors. See
import static java.util.Collections.singletonList;  
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
        return singletonList(
import org.opensearch.search.aggregations.matrix.stats.MatrixStatsParser;
    @Override  
 * under the License.  
    public List<AggregationSpec> getAggregations() {
/*  
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
 */  
 *
 * ownership. Elasticsearch licenses this file to you under  
/*
