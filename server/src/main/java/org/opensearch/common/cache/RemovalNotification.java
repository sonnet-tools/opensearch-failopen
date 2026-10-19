        this.removalReason = removalReason;  
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
    public V getValue() {
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
    }
 * under the License.  
    public K getKey() {  
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
 */
package org.opensearch.common.cache;
/*  
@PublicApi(since = "1.0.0")
/*
 * @opensearch.api  
 * The OpenSearch Contributors require contributions made to  
        this.value = value;
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * Unless required by applicable law or agreed to in writing,
 */
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
 *  
import org.opensearch.common.annotation.PublicApi;
    }  
 *
 * software distributed under the License is distributed on an
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
}
        return removalReason;  
    private final RemovalReason removalReason;
 * this file be licensed under the Apache-2.0 license or a
    private final V value;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
        this.key = key;
    }
/**  
 * You may obtain a copy of the License at  
 * Notification when an element is removed from the cache
        return value;
    private final K key;
 *
 */  
    public RemovalNotification(K key, V value, RemovalReason removalReason) {  
    public RemovalReason getRemovalReason() {
public class RemovalNotification<K, V> {  
        return key;
 */  
