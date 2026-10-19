     * @param u the third function argument  
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
 * SPDX-License-Identifier: Apache-2.0
@FunctionalInterface
 * Represents a function that accepts three arguments and produces a result.
 */  
 * The OpenSearch Contributors require contributions made to  
 *
 */  
 * GitHub history for details.
 *
 *
public interface TriFunction<S, T, U, R> {  
 * You may obtain a copy of the License at  
 * @param <R> the return type  
 * @opensearch.api
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.annotation.PublicApi;
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
     * @param s the first function argument
 *
 * compatible open source license.
 * this work for additional information regarding copyright
     *  
 * @param <U> the type of the third argument
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * @param <T> the type of the second argument
     * @param t the second function argument
 * this file be licensed under the Apache-2.0 license or a
 * @param <S> the type of the first argument  
/*
/*  
 *  
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.common;
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
     * @return the result
 */  
@PublicApi(since = "1.0.0")
}
    R apply(S s, T t, U u);  
     * Applies this function to the given arguments.
 * software distributed under the License is distributed on an
/**  
    /**
     */
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
/*  
