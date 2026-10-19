    public static final MultiSearchAction INSTANCE = new MultiSearchAction();
}
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
 *  
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
        super(NAME, MultiSearchResponse::new);
 *
 */
 *
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
 */  
import org.opensearch.action.ActionType;
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
    private MultiSearchAction() {
 * Transport action for executing a multi search
package org.opensearch.action.search;
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal  
    }  
 *
/*
 */  
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
    public static final String NAME = "indices:data/read/msearch";
 * this file be licensed under the Apache-2.0 license or a
 */
 * under the License.  
 * software distributed under the License is distributed on an
public class MultiSearchAction extends ActionType<MultiSearchResponse> {
/**  
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
 * compatible open source license.
 * GitHub history for details.
