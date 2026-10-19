 */
/*  
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
/**
import org.opensearch.plugins.Plugin;
                CustomSuggestion::new  
 */  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
 * compatible open source license.
    public List<SearchPlugin.SuggesterSpec<?>> getSuggesters() {  
/*
    /**  
 *
    }  
    @Override
 * this work for additional information regarding copyright
                CustomSuggestionBuilder::new,
 * GitHub history for details.
import java.util.List;
 * Plugin demonstrating custom suggestion-based search.
import org.opensearch.plugins.SearchPlugin;
}
        );
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
public class CustomSuggesterPlugin extends Plugin implements SearchPlugin {
 * under the License.  
 */  
    public CustomSuggesterPlugin() {}  
                CustomSuggestionBuilder::fromXContent,
 * Licensed to Elasticsearch under one or more contributor  
 */  
            )
package org.opensearch.example.customsuggester;
     * Instantiate this class.
/*  
 * Unless required by applicable law or agreed to in writing,
     */
import java.util.Collections;
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
            new SearchPlugin.SuggesterSpec<>(
 * this file be licensed under the Apache-2.0 license or a
        return Collections.singletonList(
 * You may obtain a copy of the License at  
                CustomSuggestionBuilder.SUGGESTION_NAME,  
