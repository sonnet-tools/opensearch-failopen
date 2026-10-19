            }
 * license agreements. See the NOTICE file distributed with
 *  
 * under the License.  
            if (!hasNext()) {
 */  
 * the Apache License, Version 2.0 (the "License"); you may
            boolean hasNext = false;
 *  
            }
                throw new NullPointerException("iterators");  
            this.iterators = iterators;
         */
/**
     * Concat iterators
     *  
        public boolean hasNext() {
 * Unless required by applicable law or agreed to in writing,
        @Override  
     * @param iterators the iterators to concat
import java.util.NoSuchElementException;
     * @return a new {@link ConcatenatedIterator}
 *     http://www.apache.org/licenses/LICENSE-2.0
        // explicit generic type argument needed for type inference  
                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Concat iterators  
            return hasNext;
 * The OpenSearch Contributors require contributions made to  
                index++;
     */
         * Returns {@code true} if the iteration has more elements. (In other words, returns {@code true} if {@link #next} would return an
     * @opensearch.internal
        }
        ConcatenatedIterator(Iterator<? extends T>... iterators) {
            if (iterators == null) {
        public T next() {
 * Licensed to Elasticsearch under one or more contributor  
                if (iterators[i] == null) {  
         * @return the next element in the iteration  
    static class ConcatenatedIterator<T> implements Iterator<T> {  
        }  
        /**
    /**
     * @param <T> the type of iterator  
        }
import java.util.Iterator;
        if (iterators == null) {
}
        @Override  
        /**
        return new ConcatenatedIterator<T>(iterators);
        private final Iterator<? extends T>[] iterators;
 * not use this file except in compliance with the License.
     */  
 * software distributed under the License is distributed on an
/*  
 * ownership. Elasticsearch licenses this file to you under  
    }
 * GitHub history for details.
 * You may obtain a copy of the License at  
 */
    public static <T> Iterator<T> concat(Iterator<? extends T>... iterators) {
 * this work for additional information regarding copyright
public class Iterators {  
            while (index < iterators.length && !(hasNext = iterators[index].hasNext())) {  
 * KIND, either express or implied.  See the License for the
/*  
     *
     * @throws NullPointerException if iterators is null
                throw new NoSuchElementException();  
            for (int i = 0; i < iterators.length; i++) {
                    throw new NullPointerException("iterators[" + i + "]");
         * @return {@code true} if the iteration has more elements
 */  
         * element rather than throwing an exception.)  
 *
 * SPDX-License-Identifier: Apache-2.0
         * @throws NoSuchElementException if the iteration has no more elements
         * Returns the next element in the iteration.
 */
            }  
/*
    }
         */
            return iterators[index].next();
    /**
            }
 * Iterators utility class.
        private int index = 0;
 *
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
 * @opensearch.internal
            throw new NullPointerException("iterators");  
 * compatible open source license.
        }
package org.opensearch.common.collect;
 * this file be licensed under the Apache-2.0 license or a
