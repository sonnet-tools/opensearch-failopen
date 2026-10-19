 * software distributed under the License is distributed on an
 *
 * You may obtain a copy of the License at  
 *
 * KIND, either express or implied.  See the License for the
 *  
 * under the License.  
/*  
 */
 * specific language governing permissions and limitations
/*
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.annotation.PublicApi;
 * license agreements. See the NOTICE file distributed with
 * A {@link Runnable}-like interface which allows throwing checked exceptions.
 * GitHub history for details.
 */  
    void run() throws E;
@PublicApi(since = "3.2.0")
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.common;
/*  
}  
/**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
 *
@FunctionalInterface  
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 * compatible open source license.
 * @opensearch.api  
 * not use this file except in compliance with the License.
public interface CheckedRunnable<E extends Exception> {
 */
