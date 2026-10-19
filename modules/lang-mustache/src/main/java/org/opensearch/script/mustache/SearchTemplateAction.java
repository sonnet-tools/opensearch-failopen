        super(NAME, SearchTemplateResponse::new);  
}
    private SearchTemplateAction() {
 * software distributed under the License is distributed on an
 */
package org.opensearch.script.mustache;
    public static final SearchTemplateAction INSTANCE = new SearchTemplateAction();
    public static final String NAME = "indices:data/read/search/template";  
 * compatible open source license.
 * You may obtain a copy of the License at  
 */  
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
 * under the License.  
 *
 * license agreements. See the NOTICE file distributed with
 *  
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
    }
 */  
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
public class SearchTemplateAction extends ActionType<SearchTemplateResponse> {  
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.ActionType;
 * Licensed to Elasticsearch under one or more contributor  
/*  
