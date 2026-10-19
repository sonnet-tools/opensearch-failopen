 *     http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
 *
    void accept(T t) throws E;
public interface CheckedConsumer<T, E extends Exception> {  
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
package org.opensearch.common;
/*  
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
@PublicApi(since = "1.0.0")
 * compatible open source license.
 * @opensearch.api
import java.util.function.Consumer;  
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 * not use this file except in compliance with the License.
import org.opensearch.common.annotation.PublicApi;
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 */
 * software distributed under the License is distributed on an
 */  
 *
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
/**
/*
 *  
 */  
 * A {@link Consumer}-like interface which allows throwing checked exceptions.  
 * this work for additional information regarding copyright
 *
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
}
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
@FunctionalInterface
