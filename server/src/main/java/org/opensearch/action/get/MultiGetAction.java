/*  
 * Unless required by applicable law or agreed to in writing,
 */  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
    public static final String NAME = "indices:data/read/mget";
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
 *
/**  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
}
 */
 * under the License.  
 */
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.action.get;
 *
public class MultiGetAction extends ActionType<MultiGetResponse> {
import org.opensearch.action.ActionType;
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
/*
 * not use this file except in compliance with the License.
 * Transport action for a multi get
 * SPDX-License-Identifier: Apache-2.0
 *  
    }  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
    public static final MultiGetAction INSTANCE = new MultiGetAction();
        super(NAME, MultiGetResponse::new);
/*  
    private MultiGetAction() {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal  
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
