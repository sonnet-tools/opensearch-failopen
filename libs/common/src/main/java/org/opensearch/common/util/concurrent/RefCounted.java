/*
     * Increments the refCount of this instance.  
 * Modifications Copyright OpenSearch Contributors. See
 *  block to release the object again ie.:
     * Tries to increment the refCount of this instance. This method will return {@code true} iff the refCount was  
     * @return returns {@code true} if the ref count dropped to 0 as a result of calling this method
 *  be increased before using it by calling #incRef and a corresponding #decRef must be called in a try/finally
 * this file be licensed under the Apache-2.0 license or a
 *          inst.decRef();  
 * Licensed to Elasticsearch under one or more contributor  
 *      }
 */
    void incRef();  
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
    boolean decRef();  
 */  
     *
}
/*  
 * <pre>  
 */  
 *      inst.incRef();
     * @see #incRef()  
 *  but should be functional until all async operations have joined
     * @see #incRef
 * under the License.  
 * </pre>
 *  Classes implementing this interface should ref counted at any time ie. if an object is used it's reference count should  
     * instance is considered as closed and should not be used anymore.  
 * compatible open source license.
/**
     * Decreases the refCount of this  instance. If the refCount drops to 0, then this
/*  
 * not use this file except in compliance with the License.
 */
    /**
 * @opensearch.api
 * SPDX-License-Identifier: Apache-2.0
     *  
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
 * license agreements. See the NOTICE file distributed with
     * @see #tryIncRef()  
 *  to itself are not in user anymore. This implements basic reference counting  
 *      } finally {
     *
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
     * @see #decRef
package org.opensearch.common.util.concurrent;
 * The OpenSearch Contributors require contributions made to  
     * @see #decRef()
 *
 * You may obtain a copy of the License at  
     */
 *
 *  
    /**
 * specific language governing permissions and limitations
 *
 *  
    /**
     * @throws IllegalStateException iff the reference counter can not be incremented.
 *  for instance if async operations holding on to services that are close concurrently
    boolean tryIncRef();
     *
     */
public interface RefCounted {  
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
 *      try {
 *        // use the inst...  
 * software distributed under the License is distributed on an
 *  An interface for objects that need to be notified when all reference
