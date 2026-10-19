 * ownership. Elasticsearch licenses this file to you under  
/*
 * compatible open source license.
    }  
    public static final String NAME = "cluster:admin/repository/get";
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
 */
import org.opensearch.action.ActionType;
 *
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
 * GitHub history for details.
/*  
 *
    public static final GetRepositoriesAction INSTANCE = new GetRepositoriesAction();
 * Licensed to Elasticsearch under one or more contributor  
 *
 * KIND, either express or implied.  See the License for the
 * @opensearch.internal  
}
/**  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
 *  
        super(NAME, GetRepositoriesResponse::new);
 * not use this file except in compliance with the License.
 */  
package org.opensearch.action.admin.cluster.repositories.get;
    private GetRepositoriesAction() {
 * Get repositories action
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
public class GetRepositoriesAction extends ActionType<GetRepositoriesResponse> {
 * license agreements. See the NOTICE file distributed with
