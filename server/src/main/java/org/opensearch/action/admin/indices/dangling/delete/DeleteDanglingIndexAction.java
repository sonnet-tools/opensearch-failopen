 */  
 * specific language governing permissions and limitations
    private DeleteDanglingIndexAction() {
 *
 * compatible open source license.
 *  
 * under the License.  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
public class DeleteDanglingIndexAction extends ActionType<AcknowledgedResponse> {  
        super(NAME, AcknowledgedResponse::new);  
/*
 *
package org.opensearch.action.admin.indices.dangling.delete;
    public static final String NAME = "cluster:admin/indices/dangling/delete";  
 * Unless required by applicable law or agreed to in writing,
 *  
/**
 *     http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
}
 * software distributed under the License is distributed on an
 */
 * This action causes a dangling index to be considered as deleted by the cluster.
 * Licensed to Elasticsearch under one or more contributor  
 */  
    }
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.internal
 * this work for additional information regarding copyright
    public static final DeleteDanglingIndexAction INSTANCE = new DeleteDanglingIndexAction();
/*  
 */
import org.opensearch.action.ActionType;
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
