 * distributed under the License is distributed on an "AS IS" BASIS,  
            @Override  
            }
    /**
     *                 permitted to be null, to enable aggressive testing, although in real
            @Override
    public static <T> Provider<T> of(final T instance) {
 *  
/*  
package org.opensearch.common.inject.util;
 * Copyright (C) 2007 Google Inc.  
 * http://www.apache.org/licenses/LICENSE-2.0  
 *
                return instance;
 * SPDX-License-Identifier: Apache-2.0
 * {@link Provider}.
 * @author Kevin Bourrillion (kevinb9n@gmail.com)
     *
 * Static utility methods for creating and working with instances of
 * compatible open source license.
/*
}
            public String toString() {  
 * The OpenSearch Contributors require contributions made to  
                return "of(" + instance + ")";
 *
 * Unless required by applicable law or agreed to in writing, software
/**  
 * this file be licensed under the Apache-2.0 license or a
    private Providers() {}
import org.opensearch.common.inject.Provider;
        };  
 *
 * Modifications Copyright OpenSearch Contributors. See
     * Returns a provider which always provides {@code instance}.  This should not
     */  
 */  
     * be necessary to use in your application, but is helpful for several types  
 * You may obtain a copy of the License at
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * GitHub history for details.
            public T get() {
 * you may not use this file except in compliance with the License.  
 *
public final class Providers {  
            }  
 */
 * limitations under the License.  
 */
 * See the License for the specific language governing permissions and
        return new Provider<T>() {
/*  
 * @opensearch.internal
 * @since 2.0
    }
     * of unit tests.
 */  
     *                 life a Guice-supplied Provider will never return null.
     * @param instance the instance that should always be provided.  This is also  
