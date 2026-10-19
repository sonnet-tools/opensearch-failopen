    public List<SignificanceHeuristicSpec<?>> getSignificanceHeuristics() {
/**  
 * KIND, either express or implied.  See the License for the
import static java.util.Collections.singletonList;
 */  
 *
 */
    public CustomSignificanceHeuristicPlugin() {};
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
    @Override
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;  
 *
 * this work for additional information regarding copyright
/*  
import org.opensearch.plugins.Plugin;
 */  
    }
     * Instantiate this plugin.  
    /**
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
public class CustomSignificanceHeuristicPlugin extends Plugin implements SearchPlugin {  
package org.opensearch.example.customsigheuristic;
/*
     */
 * Plugin declaring a custom {@link SignificanceHeuristic}.
import java.util.List;
 */
 * specific language governing permissions and limitations
}
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
        return singletonList(new SignificanceHeuristicSpec<>(SimpleHeuristic.NAME, SimpleHeuristic::new, SimpleHeuristic.PARSER));  
import org.opensearch.plugins.SearchPlugin;
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
/*  
 *  
