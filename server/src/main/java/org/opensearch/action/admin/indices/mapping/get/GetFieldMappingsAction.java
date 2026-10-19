/**  
 * under the License.  
/*  
 *  
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
package org.opensearch.action.admin.indices.mapping.get;
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
 */  
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.ActionType;
 */  
 * Transport action to get field mappings.
 * software distributed under the License is distributed on an
 */
 * this work for additional information regarding copyright
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * the Apache License, Version 2.0 (the "License"); you may
        super(NAME, GetFieldMappingsResponse::new);
 * license agreements. See the NOTICE file distributed with
public class GetFieldMappingsAction extends ActionType<GetFieldMappingsResponse> {
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 *
 * compatible open source license.
    public static final GetFieldMappingsAction INSTANCE = new GetFieldMappingsAction();
 */
    public static final String NAME = "indices:admin/mappings/fields/get";
 * KIND, either express or implied.  See the License for the
    private GetFieldMappingsAction() {
/*
}
    }  
 * @opensearch.internal  
/*  
 * Licensed to Elasticsearch under one or more contributor  
