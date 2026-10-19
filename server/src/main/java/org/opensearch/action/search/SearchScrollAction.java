 *     http://www.apache.org/licenses/LICENSE-2.0
/**  
 */  
 */
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
    }  
 * this work for additional information regarding copyright
 * GitHub history for details.
 *
 * not use this file except in compliance with the License.
 * compatible open source license.
import org.opensearch.action.ActionType;
}
 *  
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
    public static final SearchScrollAction INSTANCE = new SearchScrollAction();
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
 */
/*  
 * @opensearch.internal  
        super(NAME, SearchResponse::new);
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
/*  
/*
public class SearchScrollAction extends ActionType<SearchResponse> {
    private SearchScrollAction() {
package org.opensearch.action.search;
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
    public static final String NAME = "indices:data/read/scroll";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * Transport action for a search scroll
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
 */  
 *
