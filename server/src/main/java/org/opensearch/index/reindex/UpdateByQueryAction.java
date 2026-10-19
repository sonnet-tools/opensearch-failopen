 *
    public static final String NAME = "indices:data/write/update/byquery";
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
    public static final UpdateByQueryAction INSTANCE = new UpdateByQueryAction();  
 * compatible open source license.
 */  
}  
package org.opensearch.index.reindex;
 * ownership. Elasticsearch licenses this file to you under  
public class UpdateByQueryAction extends ActionType<BulkByScrollResponse> {
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 */
 * Licensed to Elasticsearch under one or more contributor  
    private UpdateByQueryAction() {  
 * Modifications Copyright OpenSearch Contributors. See
 */
 * @opensearch.internal  
 */  
 * this file be licensed under the Apache-2.0 license or a
/**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
 * under the License.  
/*  
/*  
        super(NAME, BulkByScrollResponse::new);
import org.opensearch.action.ActionType;
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
/*
 * Action type for updating by query
    }
 * Unless required by applicable law or agreed to in writing,
 *
