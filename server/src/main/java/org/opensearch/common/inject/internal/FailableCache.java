/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * The OpenSearch Contributors require contributions made to  
    }
 * You may obtain a copy of the License at
        if (resultOrError instanceof Errors) {
 * Copyright (C) 2008 Google Inc.  
                resultOrError = load(key);  
 *
 *
 * limitations under the License.  
 * Unless required by applicable law or agreed to in writing, software
package org.opensearch.common.inject.internal;
 * you may not use this file except in compliance with the License.  
 * exception is thrown on retrieval.
    }  
    private final ConcurrentHashMap<K, Object> cache = new ConcurrentHashMap<>();
    protected abstract V create(K key, Errors errors) throws ErrorsException;  
    private Object load(K key) {  
        }
 * compatible open source license.
            @SuppressWarnings("unchecked") // create returned a non-error result, so this is safe  
            synchronized (this) {
        }  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
        if (resultOrError == null) {
 * Lazily creates (and caches) values for keys. If creating the value fails (with errors), an
 *
 */  
import java.util.concurrent.ConcurrentHashMap;
            }  
            errors.merge(e.getErrors());  
        Object resultOrError = cache.get(key);  
public abstract class FailableCache<K, V> {
        return errors.hasErrors() ? errors : result;
            result = create(key, errors);
 * GitHub history for details.
            throw errors.toException();
        }
 */
 *  
 * Modifications Copyright OpenSearch Contributors. See
 */  
                cache.putIfAbsent(key, resultOrError);
        try {  
 * SPDX-License-Identifier: Apache-2.0
        V result = null;
            return result;
 * distributed under the License is distributed on an "AS IS" BASIS,  
}
 * this file be licensed under the Apache-2.0 license or a
/*  
 * @opensearch.internal  
 * See the License for the specific language governing permissions and
/**  
 * http://www.apache.org/licenses/LICENSE-2.0  
        } else {
        Errors errors = new Errors();
            errors.merge((Errors) resultOrError);  
            V result = (V) resultOrError;
 * @author jessewilson@google.com (Jesse Wilson)
 *
                // we can't use cache.computeIfAbsent since this might be recursively call this API
        } catch (ErrorsException e) {
/*  
    public V get(K key, Errors errors) throws ErrorsException {
 */
