/*
            @Override  
 */  
 * GitHub history for details.
    static <T> Initializable<T> of(final T instance) {
 *
/**
 * Modifications Copyright OpenSearch Contributors. See
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
                return instance;
            }
 * See the License for the specific language governing permissions and
 *
 */
package org.opensearch.common.inject;
 * You may obtain a copy of the License at
            @Override
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        };  
                return String.valueOf(instance);
 *  
 *
 * The OpenSearch Contributors require contributions made to  
     * Returns an initializable for an instance that requires no initialization.
 * Copyright (C) 2008 Google Inc.  
 * limitations under the License.  
 * Initializables.
 *
import org.opensearch.common.inject.internal.ErrorsException;
/*  
class Initializables {
     */  
}
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * http://www.apache.org/licenses/LICENSE-2.0  
    /**
 */  
            public T get(Errors errors) throws ErrorsException {
 */
import org.opensearch.common.inject.internal.Errors;
 * you may not use this file except in compliance with the License.  
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal  
 * @author jessewilson@google.com (Jesse Wilson)
 * Unless required by applicable law or agreed to in writing, software
    }
            }  
/*  
        return new Initializable<T>() {
            public String toString() {  
