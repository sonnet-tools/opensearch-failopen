 * the Apache License, Version 2.0 (the "License"); you may
 *     http://www.apache.org/licenses/LICENSE-2.0
    public static final String NAME = "indices:admin/create";
/**  
 *
/*  
public class CreateIndexAction extends ActionType<CreateIndexResponse> {
 * You may obtain a copy of the License at  
 */  
/*  
    }  
/*
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
package org.opensearch.action.admin.indices.create;
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.ActionType;
 * not use this file except in compliance with the License.
 *  
 * software distributed under the License is distributed on an
 */
        super(NAME, CreateIndexResponse::new);
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
    private CreateIndexAction() {
 * GitHub history for details.
 *
 */  
    public static final CreateIndexAction INSTANCE = new CreateIndexAction();
 * @opensearch.internal  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 *
 * this file be licensed under the Apache-2.0 license or a
 * Transport action for creating an index
 */
}
