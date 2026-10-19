 *  
 * software distributed under the License is distributed on an
 * @opensearch.api
 * not use this file except in compliance with the License.
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * compatible open source license.
@FunctionalInterface
import org.opensearch.common.annotation.PublicApi;
 *
}
 * specific language governing permissions and limitations
 * A {@link Function}-like interface which allows throwing checked exceptions.  
 *
/*  
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
/*  
/*
 */  
 * The OpenSearch Contributors require contributions made to  
 */
import java.util.function.Function;  
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.common;
/**
 *    http://www.apache.org/licenses/LICENSE-2.0
    R apply(T t) throws E;
public interface CheckedFunction<T, R, E extends Exception> {  
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
@PublicApi(since = "1.0.0")
 * this work for additional information regarding copyright
 * GitHub history for details.
 *
 * the Apache License, Version 2.0 (the "License"); you may
