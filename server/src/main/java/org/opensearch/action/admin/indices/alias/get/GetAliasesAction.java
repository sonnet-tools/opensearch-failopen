/*
 * KIND, either express or implied.  See the License for the
 * @opensearch.internal  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 *
 * under the License.  
public class GetAliasesAction extends ActionType<GetAliasesResponse> {
 */  
 * the Apache License, Version 2.0 (the "License"); you may
}
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
 *
package org.opensearch.action.admin.indices.alias.get;
/**  
 * software distributed under the License is distributed on an
 *  
 * this file be licensed under the Apache-2.0 license or a
 *
/*  
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
    public static final GetAliasesAction INSTANCE = new GetAliasesAction();
 * Licensed to Elasticsearch under one or more contributor  
 */
 * GitHub history for details.
 * Transport action for listing index aliases
 * SPDX-License-Identifier: Apache-2.0
        super(NAME, GetAliasesResponse::new);
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
    private GetAliasesAction() {
    }  
 * compatible open source license.
    public static final String NAME = "indices:admin/aliases/get";
import org.opensearch.action.ActionType;
 * license agreements. See the NOTICE file distributed with
 */  
