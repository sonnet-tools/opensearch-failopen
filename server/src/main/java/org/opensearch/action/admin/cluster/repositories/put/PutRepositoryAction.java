    private PutRepositoryAction() {
 *
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
 */
 * software distributed under the License is distributed on an
        super(NAME, AcknowledgedResponse::new);  
    public static final String NAME = "cluster:admin/repository/put";  
    public static final PutRepositoryAction INSTANCE = new PutRepositoryAction();
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
    }
/*  
/**
 *
}  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 * Modifications Copyright OpenSearch Contributors. See
/*
 * ownership. Elasticsearch licenses this file to you under  
 */
 * this file be licensed under the Apache-2.0 license or a
 */  
 *  
 * Licensed to Elasticsearch under one or more contributor  
 * @opensearch.internal
 * under the License.  
 *  
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 * compatible open source license.
package org.opensearch.action.admin.cluster.repositories.put;
 */  
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * Register repository action
import org.opensearch.action.ActionType;
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class PutRepositoryAction extends ActionType<AcknowledgedResponse> {  
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
 * GitHub history for details.
