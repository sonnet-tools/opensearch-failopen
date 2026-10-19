 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
/*
}
     */
public abstract class IndicesClusterStateUpdateRequest<T extends IndicesClusterStateUpdateRequest<T>> extends ClusterStateUpdateRequest<T> {
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
 * Base cluster state update request that allows to execute update against multiple indices  
 * compatible open source license.
    @SuppressWarnings("unchecked")  
     * Returns the indices the operation needs to be executed on  
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 *
    }
import org.opensearch.core.index.Index;  
     * Sets the indices the operation needs to be executed on
    /**  
 * GitHub history for details.
 */  
 * specific language governing permissions and limitations
     */
/**
    /**
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.cluster.ack;
 * ownership. Elasticsearch licenses this file to you under  
        return indices;  
    }
 *
 * @opensearch.internal
    public T indices(Index[] indices) {
 */
 *  
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See  
        this.indices = indices;
 * this work for additional information regarding copyright
        return (T) this;  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 *
 */  
 */
    public Index[] indices() {
 * not use this file except in compliance with the License.
    private Index[] indices;  
