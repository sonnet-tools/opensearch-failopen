 * compatible open source license.
    public static final GetMappingsAction INSTANCE = new GetMappingsAction();
 *
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
 */  
 */
 * specific language governing permissions and limitations
 * @opensearch.internal  
public class GetMappingsAction extends ActionType<GetMappingsResponse> {
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
    private GetMappingsAction() {
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
/**  
 *  
/*
package org.opensearch.action.admin.indices.mapping.get;
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
    public static final String NAME = "indices:admin/mappings/get";
 */  
 * Unless required by applicable law or agreed to in writing,
 *
 * The OpenSearch Contributors require contributions made to  
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
        super(NAME, GetMappingsResponse::new);
 */
 * GitHub history for details.
 *
 * not use this file except in compliance with the License.
}
import org.opensearch.action.ActionType;
/*  
    }  
 * Transport action to get field mappings.
