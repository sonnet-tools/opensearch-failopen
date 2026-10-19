 *  
 * this file be licensed under the Apache-2.0 license or a
    }
 * @opensearch.internal
 *
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 */
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 * Modifications Copyright OpenSearch Contributors. See
public class DeleteIndexAction extends ActionType<AcknowledgedResponse> {  
import org.opensearch.action.ActionType;
/*  
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.action.admin.indices.delete;
 * Transport action for deleting an index
 * specific language governing permissions and limitations
/**
        super(NAME, AcknowledgedResponse::new);  
    public static final DeleteIndexAction INSTANCE = new DeleteIndexAction();
 * GitHub history for details.
 */  
}  
 * software distributed under the License is distributed on an
 *     http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
    public static final String NAME = "indices:admin/delete";  
 *  
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
 */  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 *
    private DeleteIndexAction() {
 */
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
