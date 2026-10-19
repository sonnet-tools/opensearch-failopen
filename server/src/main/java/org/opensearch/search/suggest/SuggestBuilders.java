     * Creates a term suggestion lookup query with the provided <code>field</code>
 * under the License.  
    }
 * not use this file except in compliance with the License.
}
    /**  
public abstract class SuggestBuilders {
     *
     * @return a {@link org.opensearch.search.suggest.completion.CompletionSuggestionBuilder}
    }  
     * Creates a completion suggestion lookup query with the provided <code>field</code>  
     * @return a {@link org.opensearch.search.suggest.term.TermSuggestionBuilder}  
/**
    /**
 */  
 *  
    public static PhraseSuggestionBuilder phraseSuggestion(String fieldname) {
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
 * A static factory for building suggester lookup queries  
     */
 * this work for additional information regarding copyright
    public static CompletionSuggestionBuilder completionSuggestion(String fieldname) {
        return new PhraseSuggestionBuilder(fieldname);
 */  
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
     * Creates a phrase suggestion lookup query with the provided <code>field</code>
     */
     * @return a {@link org.opensearch.search.suggest.phrase.PhraseSuggestionBuilder}
 * Modifications Copyright OpenSearch Contributors. See
     *
 */
 * compatible open source license.
 *
 *
/*
    /**
import org.opensearch.search.suggest.phrase.PhraseSuggestionBuilder;
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.search.suggest;
     * instance
        return new TermSuggestionBuilder(fieldname);
        return new CompletionSuggestionBuilder(fieldname);  
 * @opensearch.internal
 *
    public static TermSuggestionBuilder termSuggestion(String fieldname) {  
 * The OpenSearch Contributors require contributions made to  
     * instance
/*  
     */  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.suggest.term.TermSuggestionBuilder;  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
     *  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.suggest.completion.CompletionSuggestionBuilder;
     * instance  
    }
 */  
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
