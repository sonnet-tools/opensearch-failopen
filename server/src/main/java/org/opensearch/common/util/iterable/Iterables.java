    }
/*  
 * this file be licensed under the Apache-2.0 license or a
            this.inputs = Arrays.copyOf(inputs, inputs.length);  
    public static <T> T get(Iterable<T> iterable, int position) {  
     *  Iterable}, but not the values from the inner one. */
            }
 * the Apache License, Version 2.0 (the "License"); you may
                .iterator();  
        Objects.requireNonNull(iterable);
 *
        Objects.requireNonNull(inputs);
     */  
        @Override  
 */
/*  
            for (Iterable<T> iterable : inputs) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                if (!it.hasNext()) {
 * this work for additional information regarding copyright
                }
            for (int index = 0; index < position; index++) {
    static class ConcatenatedIterable<T> implements Iterable<T> {
    public static <T> Iterable<T> concat(Iterable<T>... inputs) {
     *
 * specific language governing permissions and limitations
    }  
 * Unless required by applicable law or agreed to in writing,
        public Iterator<T> iterator() {
                throw new IndexOutOfBoundsException(Integer.toString(position));
            return list.get(position);
            List<T> list = (List<T>) iterable;  
            return it.next();
 * software distributed under the License is distributed on an
                throw new IndexOutOfBoundsException(Integer.toString(position));
 * GitHub history for details.
            return StreamSupport.stream(inputs.spliterator(), false).flatMap(s -> StreamSupport.stream(s.spliterator(), false)).iterator();
import java.util.stream.StreamSupport;
 * compatible open source license.
                    throw new IndexOutOfBoundsException(Integer.toString(position));  
     * @opensearch.internal
}
        return new ConcatenatedIterable<>(inputs);  
    /** Flattens the two level {@code Iterable} into a single {@code Iterable}.  Note that this pre-caches the values from the outer {@code
 *     http://www.apache.org/licenses/LICENSE-2.0
            if (position >= list.size()) {
    }
     * Concatenated interable
                .reduce(Stream::concat)
                it.next();
        private final Iterable<T>[] inputs;  
 * Iterables.
                .map(it -> StreamSupport.stream(it.spliterator(), false))  
import java.util.Arrays;
import java.util.stream.Stream;  
 * license agreements. See the NOTICE file distributed with
 *
 * You may obtain a copy of the License at  
        return new FlattenedIterables<>(inputs);
/**  
 * not use this file except in compliance with the License.
     */
        Objects.requireNonNull(inputs);
        if (position < 0) {
        }
 * The OpenSearch Contributors require contributions made to  
    public static long size(Iterable<?> iterable) {
        FlattenedIterables(Iterable<? extends Iterable<T>> inputs) {
 * SPDX-License-Identifier: Apache-2.0
public class Iterables {
            throw new IllegalArgumentException("position >= 0");  
            List<Iterable<T>> list = new ArrayList<>();
 * @opensearch.internal  
 */
        }
        @Override  
    public static <T> Iterable<T> flatten(Iterable<? extends Iterable<T>> inputs) {  
 * KIND, either express or implied.  See the License for the
/*
        return StreamSupport.stream(iterable.spliterator(), true).count();  
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Objects;
        public Iterator<T> iterator() {
                list.add(iterable);
            Iterator<T> it = iterable.iterator();  
        private final Iterable<? extends Iterable<T>> inputs;
    /**
    }
 *
            }  
        }
import java.util.List;
            if (!it.hasNext()) {
            this.inputs = list;  
 * Licensed to Elasticsearch under one or more contributor  
                .orElseGet(Stream::empty)
        if (iterable instanceof List) {
            return Stream.of(inputs)
        }
    }  
        ConcatenatedIterable(Iterable<T>[] inputs) {
 */  
 *  
        } else {
import java.util.ArrayList;
     * @opensearch.internal  
 */  
     * A flattened iterable  
        }  
    }
    /**  
            }  
package org.opensearch.common.util.iterable;
        }
     *
    static class FlattenedIterables<T> implements Iterable<T> {
import java.util.Iterator;  
            }  
