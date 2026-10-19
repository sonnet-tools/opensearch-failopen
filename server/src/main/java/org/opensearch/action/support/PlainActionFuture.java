 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
/*  
    protected T convert(T listenerResponse) {  
    }
 * this work for additional information regarding copyright
    public static <T> PlainActionFuture<T> newFuture() {
        PlainActionFuture<T> fut = newFuture();  
/*
/**  
        return fut.actionGet();
package org.opensearch.action.support;
        return new PlainActionFuture<>();
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
 *  
    }  
}  
 */  
    public static <T, E extends Exception> T get(CheckedConsumer<PlainActionFuture<T>, E> e) throws E {
 * software distributed under the License is distributed on an
public class PlainActionFuture<T> extends AdapterActionFuture<T, T> {
        return listenerResponse;
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
 *
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.CheckedConsumer;
 */  
/*  
 * KIND, either express or implied.  See the License for the
    @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal  
 * Creates a new future for a plain action.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
    }  
        e.accept(fut);
 * ownership. Elasticsearch licenses this file to you under  
 */
 * under the License.  
 *
 *
 */
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
