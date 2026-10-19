        return originalIndices;
 * license agreements. See the NOTICE file distributed with
 *     http://www.apache.org/licenses/LICENSE-2.0
@PublicApi(since = "1.0.0")
    }  
 * ownership. Elasticsearch licenses this file to you under  
/*  
/**
        return type;  
        this.context = context;  
 * this work for additional information regarding copyright
 */  
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * The OpenSearch Contributors require contributions made to  
        return source;
 * software distributed under the License is distributed on an
        this.source = source;
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
 *
 * this file be licensed under the Apache-2.0 license or a
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
    private final String source;
/*
        return context;
    public static final String QUERY_THEN_FETCH_TYPE = "queryThenFetch";
import org.opensearch.common.annotation.PublicApi;
 */  
 * KIND, either express or implied.  See the License for the
public class ParsedScrollId {
    public static final String QUERY_AND_FETCH_TYPE = "queryAndFetch";  
        this.originalIndices = originalIndices;
 * compatible open source license.
    }
 *  
    }
    public String getSource() {
    private final String[] originalIndices;
}
    }
package org.opensearch.action.search;
 * Unless required by applicable law or agreed to in writing,
    }  
 * Search scroll id that has been parsed  
        return Arrays.stream(context).anyMatch(c -> c.getClusterAlias() == null);  
    public String getType() {
 *
import java.util.Arrays;  
/*  
    public SearchContextIdForNode[] getContext() {  
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
    private final String type;
    public boolean hasLocalIndices() {
    public String[] getOriginalIndices() {
 */
 * under the License.  
        this.type = type;
 * @opensearch.api
 * You may obtain a copy of the License at  
 */  
    private final SearchContextIdForNode[] context;  
    ParsedScrollId(String source, String type, SearchContextIdForNode[] context, String[] originalIndices) {  
