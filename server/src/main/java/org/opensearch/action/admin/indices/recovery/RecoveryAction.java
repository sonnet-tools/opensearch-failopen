 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
    private RecoveryAction() {
 * the Apache License, Version 2.0 (the "License"); you may
 * Recovery information action
    public static final String NAME = "indices:monitor/recovery";
 * @opensearch.internal  
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
/**  
 *  
package org.opensearch.action.admin.indices.recovery;
 *
 */  
public class RecoveryAction extends ActionType<RecoveryResponse> {
    }  
 *
 * software distributed under the License is distributed on an
}
 * specific language governing permissions and limitations
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.ActionType;
 * this file be licensed under the Apache-2.0 license or a
/*  
 */
 * under the License.  
 * license agreements. See the NOTICE file distributed with
 */  
        super(NAME, RecoveryResponse::new);
 * Unless required by applicable law or agreed to in writing,
/*
 * GitHub history for details.
    public static final RecoveryAction INSTANCE = new RecoveryAction();
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 */
 *
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 * compatible open source license.
