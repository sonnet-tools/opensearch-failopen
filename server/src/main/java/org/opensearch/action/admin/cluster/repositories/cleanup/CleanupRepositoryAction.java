        super(NAME, CleanupRepositoryResponse::new);
 */  
 * The OpenSearch Contributors require contributions made to  
 *
 */
 * this file be licensed under the Apache-2.0 license or a
}  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal
package org.opensearch.action.admin.cluster.repositories.cleanup;
 * under the License.  
    }
import org.opensearch.action.ActionType;  
    private CleanupRepositoryAction() {  
 * software distributed under the License is distributed on an
public final class CleanupRepositoryAction extends ActionType<CleanupRepositoryResponse> {
 * SPDX-License-Identifier: Apache-2.0
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
/*
 * KIND, either express or implied.  See the License for the
/**
/*
    public static final CleanupRepositoryAction INSTANCE = new CleanupRepositoryAction();  
 * this work for additional information regarding copyright
 */
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See  
 * Unless required by applicable law or agreed to in writing,
/*  
 * license agreements. See the NOTICE file distributed with
 *  
 *
 * You may obtain a copy of the License at  
 * GitHub history for details.
 * Transport action for cleaning up snapshot repositories  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * Licensed to Elasticsearch under one or more contributor  
    public static final String NAME = "cluster:admin/repository/_cleanup";
