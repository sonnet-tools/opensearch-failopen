 * You may obtain a copy of the License at  
 * under the License.  
/**  
 */  
 * compatible open source license.
 *
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
}
 * software distributed under the License is distributed on an
/*  
    }  
 *  
    public static final IndicesSegmentsAction INSTANCE = new IndicesSegmentsAction();
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.action.admin.indices.segments;
 *
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal  
 * KIND, either express or implied.  See the License for the
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
 * GitHub history for details.
 */
        super(NAME, IndicesSegmentResponse::new);
 */  
public class IndicesSegmentsAction extends ActionType<IndicesSegmentResponse> {
import org.opensearch.action.ActionType;
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static final String NAME = "indices:monitor/segments";
 */
/*  
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
    private IndicesSegmentsAction() {
 *
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
 * Transport action for retrieving indices segment information
