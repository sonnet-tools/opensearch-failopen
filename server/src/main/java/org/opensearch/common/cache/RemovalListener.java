 * Licensed to Elasticsearch under one or more contributor  
     */  
 * software distributed under the License is distributed on an
 *  
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
 */
 * license agreements. See the NOTICE file distributed with
    void onRemoval(RemovalNotification<K, V> notification);
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 */  
package org.opensearch.common.cache;
 *
/*
 * specific language governing permissions and limitations
import org.opensearch.common.annotation.ExperimentalApi;
@ExperimentalApi
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
 * Listener for removing an element from the cache
/*  
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
     * This may be called from multiple threads at once. So implementation needs to be thread safe.
 * @opensearch.experimental  
 */  
/**  
 * under the License.  
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
     * @param notification removal notification for desired entry.
    /**  
 */
 * SPDX-License-Identifier: Apache-2.0
@FunctionalInterface  
public interface RemovalListener<K, V> {
 *
 * compatible open source license.
 * not use this file except in compliance with the License.
}
