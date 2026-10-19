 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.ActionType;
public class ClearScrollAction extends ActionType<ClearScrollResponse> {
 * compatible open source license.
 * Transport Action for clearing a scroll
 *  
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 */
/*
        super(NAME, ClearScrollResponse::new);
/**  
 *
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
/*  
 */
 *
    public static final ClearScrollAction INSTANCE = new ClearScrollAction();
 */  
    public static final String NAME = "indices:data/read/scroll/clear";
 * @opensearch.internal  
}
 * specific language governing permissions and limitations
 *     http://www.apache.org/licenses/LICENSE-2.0
    private ClearScrollAction() {
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
/*  
 *
 */  
package org.opensearch.action.search;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
    }  
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
