 * Action type for delete by query
 * The OpenSearch Contributors require contributions made to  
/*
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.ActionType;
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 */
package org.opensearch.index.reindex;
 * license agreements. See the NOTICE file distributed with
    }  
    public static final String NAME = "indices:data/write/delete/byquery";
 *
 * software distributed under the License is distributed on an
/*  
 *
    private DeleteByQueryAction() {
 */
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static final DeleteByQueryAction INSTANCE = new DeleteByQueryAction();
 * GitHub history for details.
        super(NAME, BulkByScrollResponse::new);
 *
 *  
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal  
/**  
public class DeleteByQueryAction extends ActionType<BulkByScrollResponse> {
 * under the License.  
/*  
 */  
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
}
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
