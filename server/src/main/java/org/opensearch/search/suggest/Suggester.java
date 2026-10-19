 *
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
        String name,
    protected abstract Suggest.Suggestion<? extends Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option>> innerExecute(  
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected abstract Suggest.Suggestion<? extends Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option>> emptySuggestion(
        T suggestion,  
        CharsRefBuilder spare
@PublicApi(since = "1.0.0")  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.annotation.PublicApi;  
/*  
 */
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.search.IndexSearcher;
/**
    ) throws IOException {  
 */
public abstract class Suggester<T extends SuggestionSearchContext.SuggestionContext> {
 */  
/*
 * You may obtain a copy of the License at  
package org.opensearch.search.suggest;
 * @opensearch.api
        CharsRefBuilder spare
 */  
 *  
    }
        String name,
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
        T suggestion,  
import org.apache.lucene.util.CharsRefBuilder;
        IndexSearcher searcher,  
    public Suggest.Suggestion<? extends Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option>> execute(
 * ownership. Elasticsearch licenses this file to you under  
}  
        IndexSearcher searcher,
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
 * Base class used for all suggester implementations
 * Unless required by applicable law or agreed to in writing,
 *
            return emptySuggestion(name, suggestion, spare);
 * SPDX-License-Identifier: Apache-2.0
        if (searcher.getIndexReader().numDocs() == 0) {  
    ) throws IOException;
 * not use this file except in compliance with the License.
        T suggestion,
 * software distributed under the License is distributed on an
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
 *  
        // we only want to output an empty suggestion on empty shards
    ) throws IOException;
 * this work for additional information regarding copyright
        String name,
        }
 * Licensed to Elasticsearch under one or more contributor  
        return innerExecute(name, suggestion, searcher, spare);  
        CharsRefBuilder spare
import java.io.IOException;
 * compatible open source license.
