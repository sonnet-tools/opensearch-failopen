 */  
     */
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.action.ActionListener;
 *
package org.opensearch.action.bulk;
 * GitHub history for details.
/*
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
 *     http://www.apache.org/licenses/LICENSE-2.0
public interface MappingUpdatePerformer {
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
 */  
 *
 */
/*  
 *
 * software distributed under the License is distributed on an
}
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.index.shard.ShardId;
 */  
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
/**
     * Update the mappings on the cluster-manager.
 * The OpenSearch Contributors require contributions made to  
    void updateMappings(Mapping update, ShardId shardId, ActionListener<Void> listener);  
    /**  
/*  
 * @opensearch.internal
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
import org.opensearch.index.mapper.Mapping;  
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 * this work for additional information regarding copyright
 * Updates the mappings on the cluster manager  
