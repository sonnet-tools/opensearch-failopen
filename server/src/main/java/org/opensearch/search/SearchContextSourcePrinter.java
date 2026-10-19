    }
 *  
import org.opensearch.tasks.Task;
 * GitHub history for details.
        if (searchContext.getTask() != null && searchContext.getTask().getHeader(Task.X_OPAQUE_ID) != null) {
/**
/*  
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
    }
        this.searchContext = searchContext;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
    public String toString() {
            builder.append("source[], ");  
        StringBuilder builder = new StringBuilder();  
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
import org.opensearch.search.internal.SearchContext;
package org.opensearch.search;
 * software distributed under the License is distributed on an
        }
 *
            builder.append("id[").append(searchContext.getTask().getHeader(Task.X_OPAQUE_ID)).append("], ");  
        if (searchContext.request() != null && searchContext.request().source() != null) {  
 */
 * this file be licensed under the Apache-2.0 license or a
public class SearchContextSourcePrinter {  
 * KIND, either express or implied.  See the License for the
 *
 */  
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
            builder.append("source[").append(searchContext.request().source().toString()).append("], ");
 * @opensearch.internal
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
        builder.append(searchContext.indexShard().shardId());
            builder.append("id[], ");
        builder.append(" ");
        return builder.toString();
/*  
 * specific language governing permissions and limitations
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
        } else {
    public SearchContextSourcePrinter(SearchContext searchContext) {  
 * Prints the search context source
 * You may obtain a copy of the License at  
/*
 * Unless required by applicable law or agreed to in writing,
        } else {
 * The OpenSearch Contributors require contributions made to  
 *  
}  
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
    private final SearchContext searchContext;
    @Override
