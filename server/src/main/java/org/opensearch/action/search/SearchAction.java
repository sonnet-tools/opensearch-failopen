 * compatible open source license.
 * KIND, either express or implied.  See the License for the
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
 *  
 * software distributed under the License is distributed on an
    private SearchAction() {
 * not use this file except in compliance with the License.
    public static final SearchAction INSTANCE = new SearchAction();
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
 * GitHub history for details.
/**  
import org.opensearch.action.ActionType;
 *
    }  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static final String NAME = "indices:data/read/search";
 */  
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal  
 * SPDX-License-Identifier: Apache-2.0
/*  
 * Licensed to Elasticsearch under one or more contributor  
public class SearchAction extends ActionType<SearchResponse> {
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 */
        super(NAME, SearchResponse::new);
}
 *
package org.opensearch.action.search;
/*
 * this work for additional information regarding copyright
 * Transport action for executing a search
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
