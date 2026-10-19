 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
/*  
    }  
 *  
 */  
 * @opensearch.internal  
package org.opensearch.action.delete;
 */
import org.opensearch.action.ActionType;
    public static final String NAME = "indices:data/write/delete";
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 * not use this file except in compliance with the License.
public class DeleteAction extends ActionType<DeleteResponse> {
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
 */
    private DeleteAction() {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
 * under the License.  
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
        super(NAME, DeleteResponse::new);
 */  
}
/**  
 * Transport action to delete a document from an index
    public static final DeleteAction INSTANCE = new DeleteAction();
 * this work for additional information regarding copyright
 *
/*
 *
 * Unless required by applicable law or agreed to in writing,
