import java.util.concurrent.TimeUnit;
    V txGet();  
 * Future for transport operations
 * Unless required by applicable law or agreed to in writing,
     */
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
 * under the License.  
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
/*  
 */  
    V txGet(long timeout, TimeUnit unit);  
     * retrieves its result.
 * You may obtain a copy of the License at  
 */
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
/**
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
 *  
 * The OpenSearch Contributors require contributions made to  
 *
     * Waits if necessary for the computation to complete, and then  
}
 * software distributed under the License is distributed on an
public interface TransportFuture<V> extends Future<V> {  
package org.opensearch.transport;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.concurrent.Future;
 * not use this file except in compliance with the License.
 */
 * Modifications Copyright OpenSearch Contributors. See
     */
 *  
    /**
    /**
 */  
 * the Apache License, Version 2.0 (the "License"); you may
     * to complete, and then retrieves its result, if available.
/*  
 * KIND, either express or implied.  See the License for the
 *
/*
 * Licensed to Elasticsearch under one or more contributor  
     * Waits if necessary for at most the given time for the computation  
 * GitHub history for details.
