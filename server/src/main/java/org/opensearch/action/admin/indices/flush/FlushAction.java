/*  
 * You may obtain a copy of the License at  
    public static final String NAME = "indices:admin/flush";
 */
 *
}
public class FlushAction extends ActionType<FlushResponse> {
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static final FlushAction INSTANCE = new FlushAction();
 * not use this file except in compliance with the License.
    }  
 */
 * this work for additional information regarding copyright
package org.opensearch.action.admin.indices.flush;
 *
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
/**  
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * Transport action for flushing one or more indices
 * Modifications Copyright OpenSearch Contributors. See
/*  
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
/*
 */  
 * GitHub history for details.
 *  
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal  
    private FlushAction() {
        super(NAME, FlushResponse::new);
 * software distributed under the License is distributed on an
import org.opensearch.action.ActionType;
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
