 * Licensed to Elasticsearch under one or more contributor  
 */
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
@FunctionalInterface
import java.util.function.Supplier;
/**  
public interface CheckedSupplier<R, E extends Exception> {  
 * KIND, either express or implied.  See the License for the
 *  
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
 * You may obtain a copy of the License at  
/*  
package org.opensearch.common;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
 * @opensearch.internal  
 * the Apache License, Version 2.0 (the "License"); you may
 *
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
}
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
 *
 */
 * compatible open source license.
/*  
/*
 */  
    R get() throws E;
 * license agreements. See the NOTICE file distributed with
 * A {@link Supplier}-like interface which allows throwing checked exceptions.
 * specific language governing permissions and limitations
 *
