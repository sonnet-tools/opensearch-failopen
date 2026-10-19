        super(NAME, IndicesStatsResponse::new);
 * specific language governing permissions and limitations
 */
}
 * under the License.  
    public static final String NAME = "indices:monitor/stats";
 * software distributed under the License is distributed on an
 */
 *  
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
    private IndicesStatsAction() {
/*  
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
 * GitHub history for details.
public class IndicesStatsAction extends ActionType<IndicesStatsResponse> {
 * Unless required by applicable law or agreed to in writing,
/**  
 *
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
 *
 * You may obtain a copy of the License at  
 * @opensearch.internal  
/*
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.action.admin.indices.stats;
import org.opensearch.action.ActionType;
/*  
 * Transport action for retrieving index stats
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
    public static final IndicesStatsAction INSTANCE = new IndicesStatsAction();
    }  
 *
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
