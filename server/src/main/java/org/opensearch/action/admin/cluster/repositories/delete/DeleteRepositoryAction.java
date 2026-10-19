 * Unregister repository action
/*  
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
 *  
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
/**
    public static final String NAME = "cluster:admin/repository/delete";  
 */
 * compatible open source license.
 */  
}  
 * software distributed under the License is distributed on an
    public static final DeleteRepositoryAction INSTANCE = new DeleteRepositoryAction();
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 */
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.action.admin.cluster.repositories.delete;
import org.opensearch.action.ActionType;
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * @opensearch.internal
 * specific language governing permissions and limitations
public class DeleteRepositoryAction extends ActionType<AcknowledgedResponse> {  
        super(NAME, AcknowledgedResponse::new);  
    private DeleteRepositoryAction() {
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
 * under the License.  
/*  
 *
 *
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
 */  
 *  
