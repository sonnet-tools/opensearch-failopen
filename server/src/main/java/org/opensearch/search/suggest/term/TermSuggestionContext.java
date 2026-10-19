 *  
 */  
 *
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.suggest.DirectSpellcheckerSettings;
 * Modifications Copyright OpenSearch Contributors. See  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.suggest.SuggestionSearchContext.SuggestionContext;
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
    public String toString() {
    public DirectSpellcheckerSettings getDirectSpellCheckerSettings() {
 * under the License.  
 */
/*
    private final DirectSpellcheckerSettings settings = new DirectSpellcheckerSettings();
 * Context used during term suggestion
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.query.QueryShardContext;  
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
    TermSuggestionContext(QueryShardContext shardContext) {
package org.opensearch.search.suggest.term;
    @Override  
final class TermSuggestionContext extends SuggestionContext {  
    }  
 *  
 * You may obtain a copy of the License at  
}
 * specific language governing permissions and limitations
    }  
 * this work for additional information regarding copyright
        return settings;  
 * The OpenSearch Contributors require contributions made to  
/*  
/*
        super(TermSuggester.INSTANCE, shardContext);
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
/**
 */
        return "SpellcheckerSettings" + settings + ", BaseSettings" + super.toString();
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
    }
