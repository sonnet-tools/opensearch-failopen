 * specific language governing permissions and limitations
import org.opensearch.action.ActionType;
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
 *
 *
        super(NAME, IndicesShardStoresResponse::new);  
/*
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 */
    public static final String NAME = "indices:monitor/shard_stores";  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
/**  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
 *
package org.opensearch.action.admin.indices.shards;
 */
 */  
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
 * under the License.  
    public static final IndicesShardStoresAction INSTANCE = new IndicesShardStoresAction();
 * Licensed to Elasticsearch under one or more contributor  
 * and any exceptions on opening the shard index or from previous engine failures
 * Shard store information reports which nodes hold shard copies, how recent they are
 *  
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ActionType for {@link TransportIndicesShardStoresAction}
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.internal
    private IndicesShardStoresAction() {
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
}
 *  
    }
/*  
 */  
 * Exposes shard store information for requested indices.  
 * this work for additional information regarding copyright
public class IndicesShardStoresAction extends ActionType<IndicesShardStoresResponse> {  
