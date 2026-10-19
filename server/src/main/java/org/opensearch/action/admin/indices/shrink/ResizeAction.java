 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
/*
 * Transport action for resizing an index
 * this file be licensed under the Apache-2.0 license or a
/*  
 * GitHub history for details.
}
 * this work for additional information regarding copyright
 */
    public static final String NAME = "indices:admin/resize";
    public static final ResizeAction INSTANCE = new ResizeAction();
 * not use this file except in compliance with the License.
 */
 * software distributed under the License is distributed on an
 */  
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.ActionType;
    private ResizeAction() {
 * Modifications Copyright OpenSearch Contributors. See
    }  
/**  
 *
 *
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
        super(NAME, ResizeResponse::new);
 * SPDX-License-Identifier: Apache-2.0
 *  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
public class ResizeAction extends ActionType<ResizeResponse> {
package org.opensearch.action.admin.indices.shrink;
 * the Apache License, Version 2.0 (the "License"); you may
 *
 * @opensearch.internal  
 * You may obtain a copy of the License at  
 * compatible open source license.
/*  
 * The OpenSearch Contributors require contributions made to  
