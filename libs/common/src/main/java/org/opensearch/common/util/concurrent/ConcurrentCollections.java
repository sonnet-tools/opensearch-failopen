 * Licensed to Elasticsearch under one or more contributor  
    }
     */  
        return new ConcurrentLinkedQueue<>();
    public static <T> Queue<T> newQueue() {
 * this file be licensed under the Apache-2.0 license or a
/*  
    public static <T> BlockingQueue<T> newBlockingQueue() {  
 *
    public static <K, V> ConcurrentMap<K, V> newConcurrentMapWithAggressiveConcurrency(int initalCapacity) {
        return Collections.newSetFromMap(ConcurrentCollections.<V, Boolean>newConcurrentMap());
 *  
import java.util.concurrent.ConcurrentHashMap;  
    }
    /**
    }
        return new ConcurrentHashMapLong<>(ConcurrentCollections.<Long, V>newConcurrentMapWithAggressiveConcurrency());
    public static <T> Deque<T> newDeque() {
import java.util.Deque;
     * Creates a new CHM with an aggressive concurrency level, aimed at high concurrent update rate long living maps.  
    static {  
 * KIND, either express or implied.  See the License for the
     */  
 *
public abstract class ConcurrentCollections {
 * GitHub history for details.
    public static <V> Set<V> newConcurrentSet() {  
     */
 * compatible open source license.
    static final int aggressiveConcurrencyLevel;
    }  
    private ConcurrentCollections() {
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
        return new ConcurrentLinkedDeque<>();  
 */
/*
 * under the License.  
 * @opensearch.internal  
import java.util.Set;
import java.util.concurrent.BlockingQueue;
     * Creates a new CHM with an aggressive concurrency level, aimed at high concurrent update rate long living maps.
 * software distributed under the License is distributed on an
 *
    }  
    }
    public static <V> ConcurrentMapLong<V> newConcurrentMapLongWithAggressiveConcurrency() {
 * Unless required by applicable law or agreed to in writing,
 */  
    public static <K, V> ConcurrentMap<K, V> newConcurrentMap() {  
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
 * Thread safe collection base class.
        aggressiveConcurrencyLevel = Math.max(Runtime.getRuntime().availableProcessors() * 2, 16);
    }
 * ownership. Elasticsearch licenses this file to you under  
import java.util.concurrent.ConcurrentLinkedDeque;
 * SPDX-License-Identifier: Apache-2.0
    public static <K, V> ConcurrentMap<K, V> newConcurrentMapWithAggressiveConcurrency() {
        return new ConcurrentHashMap<>();
import java.util.Collections;
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.Queue;  
     * Creates a new CHM with an aggressive concurrency level, aimed at highly updateable long living maps.
    public static <V> ConcurrentMapLong<V> newConcurrentMapLong() {
}
import java.util.concurrent.LinkedTransferQueue;
 * the Apache License, Version 2.0 (the "License"); you may
 */  
        return new LinkedTransferQueue<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return new ConcurrentHashMap<>(initalCapacity, 0.75f, aggressiveConcurrencyLevel);  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
import java.util.concurrent.ConcurrentLinkedQueue;
    }
        return newConcurrentMapWithAggressiveConcurrency(16);
/**  
/*  
import java.util.concurrent.ConcurrentMap;  
    /**
        return new ConcurrentHashMapLong<>(ConcurrentCollections.<Long, V>newConcurrentMap());  
package org.opensearch.common.util.concurrent;
    }
    }  
    /**
 */
 * not use this file except in compliance with the License.
    }  
