@PublicApi(since = "1.0.0")  
     * Scopes a provider. The returned provider returns objects from this scope.
}
     */
/*  
 * @opensearch.api
     * {@code "Scopes.SINGLETON"}, {@code "ServletScopes.SESSION"} and  
     * If an object does not exist in this scope, the provider can use the given
 */
 * and then immediately forgets it. Associating a scope with a particular
     * @param key      binding key  
 */
    String toString();
     *         scope
 */  
 * See the License for the specific language governing permissions and
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
     * @return a new provider which only delegates to the given unscoped provider  
 * again for other injections.
 * SPDX-License-Identifier: Apache-2.0
 *
     * scopes that ship with guice use the descriptions
 */  
     * Scope implementations are strongly encouraged to override
 * {@code Injector} creates it, injects it once into the class that required it,
 * By default, an instance created by the {@link Injector} has <i>no scope</i>,
 * @author crazybob@google.com (Bob Lee)
     */  
/*
 * Licensed under the Apache License, Version 2.0 (the "License");
     * @param unscoped locates an instance when one doesn't already exist in this
     * unscoped provider to retrieve one.  
 * An example of a scope is {@link Scopes#SINGLETON}.  
 * limitations under the License.  
 *
 * <p>
 *  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    /**  
 * Modifications Copyright OpenSearch Contributors. See
     * <p>
 * meaning it has no state from the framework's perspective -- the  
 * http://www.apache.org/licenses/LICENSE-2.0  
 *
 * distributed under the License is distributed on an "AS IS" BASIS,  
     * A short but useful description of this scope.  For comparison, the standard
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.common.inject;
 * A scope is a level of visibility that instances provided by Guice may have.
 *
 * Unless required by applicable law or agreed to in writing, software
    <T> Provider<T> scope(Key<T> key, Provider<T> unscoped);
    /**  
import org.opensearch.common.annotation.PublicApi;
     * {@code "ServletScopes.REQUEST"}.
/*  
 * compatible open source license.
/**  
 * you may not use this file except in compliance with the License.  
     *         when an instance of the requested object doesn't already exist in this
     * provider's {@code toString()} output.
 * Copyright (C) 2006 Google Inc.  
 *
     *                 scope.
     * {@link Object#toString} in the returned provider and include the backing  
public interface Scope {
     *
 * binding allows the created instance to be "remembered" and possibly used  
 * You may obtain a copy of the License at
    @Override  
