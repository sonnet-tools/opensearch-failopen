 * under the License.  
/*  
 * You may obtain a copy of the License at  
}  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 *
 *  
 * license agreements. See the NOTICE file distributed with
package org.opensearch.common;
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
 */  
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
 */
 * this work for additional information regarding copyright
 * A {@link java.util.function.BiFunction}-like interface which allows throwing checked exceptions.
    R apply(T t, U u) throws E;
/*
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 * KIND, either express or implied.  See the License for the
 */  
 * ownership. Elasticsearch licenses this file to you under  
/**
/*  
 *
@FunctionalInterface  
 * Unless required by applicable law or agreed to in writing,
 */
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
 * @opensearch.internal
public interface CheckedBiFunction<T, U, R, E extends Exception> {
 * GitHub history for details.
