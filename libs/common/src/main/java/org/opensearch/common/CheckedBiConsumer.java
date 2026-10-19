 *  
 * not use this file except in compliance with the License.
@PublicApi(since = "1.0.0")
 * the Apache License, Version 2.0 (the "License"); you may
/*
 * ownership. Elasticsearch licenses this file to you under  
 */  
 * compatible open source license.
 *
/*  
 *
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
public interface CheckedBiConsumer<T, U, E extends Exception> {  
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.annotation.PublicApi;
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
}
/**
/*  
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
    void accept(T t, U u) throws E;
 */  
 * license agreements. See the NOTICE file distributed with
 * A {@link BiConsumer}-like interface which allows throwing checked exceptions.  
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.common;
 */
 * GitHub history for details.
 *
 */  
 * @opensearch.api
import java.util.function.BiConsumer;  
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
@FunctionalInterface
 * The OpenSearch Contributors require contributions made to  
