 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
public class RolloverAction extends ActionType<RolloverResponse> {
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
/*  
    public static final String NAME = "indices:admin/rollover";
 * KIND, either express or implied.  See the License for the
    }  
 *
 * this file be licensed under the Apache-2.0 license or a
 * Transport action to rollover an index.
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
    private RolloverAction() {
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
 *  
/*
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal  
 * Licensed to Elasticsearch under one or more contributor  
/**  
 */  
}
 *
        super(NAME, RolloverResponse::new);
    public static final RolloverAction INSTANCE = new RolloverAction();
 * software distributed under the License is distributed on an
import org.opensearch.action.ActionType;
 * not use this file except in compliance with the License.
 * GitHub history for details.
 *
package org.opensearch.action.admin.indices.rollover;
/*  
 */
