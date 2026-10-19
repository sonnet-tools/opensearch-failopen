 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
/*  
 * this work for additional information regarding copyright
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
/*  
    }  
 * @opensearch.internal  
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
    private GetIndexAction() {
 */
public class GetIndexAction extends ActionType<GetIndexResponse> {
package org.opensearch.action.admin.indices.get;
 * GitHub history for details.
import org.opensearch.action.ActionType;
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
 * Transport action to get information about an index.
 *
 * You may obtain a copy of the License at  
    public static final GetIndexAction INSTANCE = new GetIndexAction();
        super(NAME, GetIndexResponse::new);
 *
 *
 */  
 *  
 * license agreements. See the NOTICE file distributed with
    public static final String NAME = "indices:admin/get";
 * Modifications Copyright OpenSearch Contributors. See
}
 */
 * ownership. Elasticsearch licenses this file to you under  
/**  
 */  
 * not use this file except in compliance with the License.
