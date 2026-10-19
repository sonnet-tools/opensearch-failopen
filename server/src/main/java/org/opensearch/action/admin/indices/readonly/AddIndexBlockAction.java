    public static final AddIndexBlockAction INSTANCE = new AddIndexBlockAction();
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
 *
/*  
 * Unless required by applicable law or agreed to in writing,
 * @opensearch.internal  
        super(NAME, AddIndexBlockResponse::new);
 * ownership. Elasticsearch licenses this file to you under  
/*
import org.opensearch.action.ActionType;
 * Licensed to Elasticsearch under one or more contributor  
 */
 * KIND, either express or implied.  See the License for the
/*  
 * GitHub history for details.
 * under the License.  
 *
package org.opensearch.action.admin.indices.readonly;
 *  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
    private AddIndexBlockAction() {
public class AddIndexBlockAction extends ActionType<AddIndexBlockResponse> {
    public static final String NAME = "indices:admin/block/add";
 */
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
 * Transport action to add an index block.
 */  
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
/**  
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
    }  
 *
