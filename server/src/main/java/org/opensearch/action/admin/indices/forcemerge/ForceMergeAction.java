import org.opensearch.action.ActionType;
 * this file be licensed under the Apache-2.0 license or a
 *
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * @opensearch.internal  
package org.opensearch.action.admin.indices.forcemerge;
 * not use this file except in compliance with the License.
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
public class ForceMergeAction extends ActionType<ForceMergeResponse> {
    }  
 * You may obtain a copy of the License at  
    private ForceMergeAction() {
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
 *
 * under the License.  
 */
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
 */  
    public static final ForceMergeAction INSTANCE = new ForceMergeAction();
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
/*
 *     http://www.apache.org/licenses/LICENSE-2.0
}
        super(NAME, ForceMergeResponse::new);
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
 *  
 */
/**  
    public static final String NAME = "indices:admin/forcemerge";
 * Transport action to request force merging the segments of one or more indices.
 *
