}
 */  
 *
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.action.ActionListener;  
/*
 * ownership. Elasticsearch licenses this file to you under  
 */  
 * KIND, either express or implied.  See the License for the
 *     http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.common;
 *
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
/*
/**
 * under the License.  
 * @opensearch.internal
 * Modifications Copyright OpenSearch Contributors. See  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
 *
public interface AsyncBiFunction<T, U, C> {
 * compatible open source license.
 * software distributed under the License is distributed on an
 */
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * A {@link java.util.function.BiFunction}-like interface designed to be used with asynchronous executions.  
    void apply(T t, U u, ActionListener<C> listener);  
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
/*  
 * specific language governing permissions and limitations
 */
 *  
