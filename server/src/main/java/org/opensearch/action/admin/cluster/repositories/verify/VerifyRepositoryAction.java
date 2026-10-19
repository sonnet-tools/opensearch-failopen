    private VerifyRepositoryAction() {
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
public class VerifyRepositoryAction extends ActionType<VerifyRepositoryResponse> {
    public static final String NAME = "cluster:admin/repository/verify";
 * Modifications Copyright OpenSearch Contributors. See
 *  
 * SPDX-License-Identifier: Apache-2.0
/*
 * Verify repository action
/*  
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
 */
 *
 * GitHub history for details.
 * specific language governing permissions and limitations
 */  
    public static final VerifyRepositoryAction INSTANCE = new VerifyRepositoryAction();
 *     http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal  
 */  
 *
 * Licensed to Elasticsearch under one or more contributor  
/**  
/*  
        super(NAME, VerifyRepositoryResponse::new);
 * under the License.  
}
 */
    }  
 * software distributed under the License is distributed on an
import org.opensearch.action.ActionType;
 * this file be licensed under the Apache-2.0 license or a
 *
package org.opensearch.action.admin.cluster.repositories.verify;
