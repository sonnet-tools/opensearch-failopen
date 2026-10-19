 * SPDX-License-Identifier: Apache-2.0
     * Instantiate this objecct from the given QueryShardContext and options.
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
     * @param context the QueryShardContext  
 */
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
 *
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @param options Options for this suggestion context.
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
     * Options for this context.  
    public Map<String, Object> options;
/*
 */  
import java.util.Map;
 * GitHub history for details.
 *  
        this.options = options;
 */  
}
    }  
    /**
 * KIND, either express or implied.  See the License for the
 *
 * Unless required by applicable law or agreed to in writing,
 */
 * The OpenSearch Contributors require contributions made to  
/**  
    public CustomSuggestionContext(QueryShardContext context, Map<String, Object> options) {  
public class CustomSuggestionContext extends SuggestionSearchContext.SuggestionContext {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(new CustomSuggester(), context);
 * the Apache License, Version 2.0 (the "License"); you may
/*  
     */
import org.opensearch.index.query.QueryShardContext;
package org.opensearch.example.customsuggester;
     */
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
import org.opensearch.search.suggest.SuggestionSearchContext;
    /**
 * under the License.  
 * compatible open source license.
 * this work for additional information regarding copyright
 * The suggestion context for this custom suggestion.
