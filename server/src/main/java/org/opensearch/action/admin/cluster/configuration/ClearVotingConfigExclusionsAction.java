public class ClearVotingConfigExclusionsAction extends ActionType<ClearVotingConfigExclusionsResponse> {
 * @opensearch.internal
import org.opensearch.action.ActionType;  
 * Transport endpoint for clearing exclusions to voting config  
    public static final String NAME = "cluster:admin/voting_config/clear_exclusions";  
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
        super(NAME, ClearVotingConfigExclusionsResponse::new);  
 */  
 * You may obtain a copy of the License at  
/*
 */
 * license agreements. See the NOTICE file distributed with
/*  
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
 *
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
    }
    public static final ClearVotingConfigExclusionsAction INSTANCE = new ClearVotingConfigExclusionsAction();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 * specific language governing permissions and limitations
}
 *  
 */
/**
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See  
 * Unless required by applicable law or agreed to in writing,
 *
 * software distributed under the License is distributed on an
    private ClearVotingConfigExclusionsAction() {
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
package org.opensearch.action.admin.cluster.configuration;
