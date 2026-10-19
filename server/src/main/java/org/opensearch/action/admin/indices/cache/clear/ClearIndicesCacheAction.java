 * this work for additional information regarding copyright
 *
    }  
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
 *  
 * not use this file except in compliance with the License.
 * under the License.  
package org.opensearch.action.admin.indices.cache.clear;
 * specific language governing permissions and limitations
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(NAME, ClearIndicesCacheResponse::new);
    private ClearIndicesCacheAction() {
/*  
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to  
 */  
 * software distributed under the License is distributed on an
 *
 */  
/**  
 * Unless required by applicable law or agreed to in writing,
/*
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal  
import org.opensearch.action.ActionType;
public class ClearIndicesCacheAction extends ActionType<ClearIndicesCacheResponse> {
 * license agreements. See the NOTICE file distributed with
}
 */
 */
 * Transport action for clearing cache
    public static final ClearIndicesCacheAction INSTANCE = new ClearIndicesCacheAction();
 * You may obtain a copy of the License at  
    public static final String NAME = "indices:admin/cache/clear";
