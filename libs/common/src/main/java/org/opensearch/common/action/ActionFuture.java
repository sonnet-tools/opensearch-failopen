 * this file be licensed under the Apache-2.0 license or a
    /**
 * KIND, either express or implied.  See the License for the
 *  
     *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
     * @param timeoutMillis Timeout in millis
    T actionGet(String timeout);  
import java.util.concurrent.Future;
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.common.action;
}  
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
/*  
@PublicApi(since = "1.0.0")  
 * An extension to {@link Future} allowing for simplified "get" operations.
import org.opensearch.common.annotation.PublicApi;
    T actionGet(long timeout, TimeUnit unit);
 *
 * this work for additional information regarding copyright
    /**  
     * {@link java.util.concurrent.ExecutionException} and throws the actual cause instead.  
     * an {@link IllegalStateException} instead. Also catches
 *
     * Similar to {@link #get(long, java.util.concurrent.TimeUnit)}, just catching the {@link InterruptedException} and throwing
     */
 *     http://www.apache.org/licenses/LICENSE-2.0
     * {@link java.util.concurrent.ExecutionException} and throws the actual cause instead.  
 * compatible open source license.
 * You may obtain a copy of the License at  
     * {@link java.util.concurrent.ExecutionException} and throws the actual cause instead.
     */
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.api
 * GitHub history for details.
    /**  
     * Similar to {@link #get()}, just catching the {@link InterruptedException} and throwing
     * an {@link IllegalStateException} instead. Also catches  
import org.opensearch.common.unit.TimeValue;
/**
     */  
 *  
import java.util.concurrent.TimeUnit;
     * an {@link IllegalStateException} instead. Also catches
     * {@link java.util.concurrent.ExecutionException} and throws the actual cause instead.
/*  
     * an {@link IllegalStateException} instead. Also catches
    T actionGet(long timeoutMillis);  
     */
 * The OpenSearch Contributors require contributions made to  
    T actionGet(TimeValue timeout);
 * Modifications Copyright OpenSearch Contributors. See
    /**
 * Unless required by applicable law or agreed to in writing,
 */  
     */
 */
public interface ActionFuture<T> extends Future<T> {
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
     * Similar to {@link #get(long, java.util.concurrent.TimeUnit)}, just catching the {@link InterruptedException} and throwing
     * Similar to {@link #get(long, java.util.concurrent.TimeUnit)}, just catching the {@link InterruptedException} and throwing  
 * under the License.  
    /**
     * {@link java.util.concurrent.ExecutionException} and throws the actual cause instead.
/*
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
     * Similar to {@link #get(long, java.util.concurrent.TimeUnit)}, just catching the {@link InterruptedException} and throwing  
    T actionGet();
 */
     * an {@link IllegalStateException} instead. Also catches
