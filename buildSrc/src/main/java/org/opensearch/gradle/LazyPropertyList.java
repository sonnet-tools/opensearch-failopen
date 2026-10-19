    }  
    }
        for (int i = 0; i < delegate.size(); i++) {  
            .subList(fromIndex, toIndex);
        return -1;  
    public boolean isEmpty() {
    private class PropertyListEntry<T> {
     * Return a "flattened" collection. This should be used when the collection type is itself a complex type with properties
import java.util.List;
    }
    }
     * @return a flattened collection filtered according to normalization strategy
    public int size() {
    @Override  
            .filter(entry -> entry.getNormalization() != PropertyNormalization.IGNORE_VALUE)
        PropertyListEntry(Supplier<T> supplier, PropertyNormalization normalization) {  
    @Override
    public boolean remove(Object o) {  
            }  
    public Object[] toArray() {
 * software distributed under the License is distributed on an
        return getNormalizedCollection().stream().map(PropertyListEntry::getValue).collect(Collectors.toList());
 *  
    }  
        public T getValue() {
        return delegate.stream().peek(this::validate).map(PropertyListEntry::getValue).toArray();
    }
    }
        return delegate.stream()  
import java.util.function.Supplier;
    public boolean add(Supplier<T> supplier, PropertyNormalization normalization) {
        @Input
            return normalization;
 * SPDX-License-Identifier: Apache-2.0
                return i;
        validate(entry);  
 *
    @Override
/*
    }  
    public Iterator<T> iterator() {
import java.util.ListIterator;  
 * KIND, either express or implied.  See the License for the
        @Input
    private final List<PropertyListEntry<T>> delegate = new ArrayList<>();  
        return delegate.stream().anyMatch(entry -> entry.getValue().equals(o));
    public ListIterator<T> listIterator(int index) {  
        super(name, owner);
    public T set(int index, T element) {
    @Override
    }
    }
 * The OpenSearch Contributors require contributions made to  
                lastIndex = i;
    }
            this.normalization = normalization;
        return delegate.stream()  
 * GitHub history for details.
    public List<? extends PropertyListEntry<T>> getNormalizedCollection() {
        return true;  
 */
    @Override
    }  
 *
 * not use this file except in compliance with the License.
    @Override  
    @Override
    }
        private final Supplier<T> supplier;  
    }
    @Override  
 */  
    @Override
        int i = index;
     *  
        super(name);  
    public List<T> subList(int fromIndex, int toIndex) {
    @Override  
    public boolean add(Supplier<T> supplier) {  
    public LazyPropertyList(String name, Object owner) {  
import java.util.stream.Collectors;
            return supplier.get();
 * this file be licensed under the Apache-2.0 license or a
    }
        delegate.add(index, new PropertyListEntry<>(() -> element, PropertyNormalization.DEFAULT));
public class LazyPropertyList<T> extends AbstractLazyPropertyCollection implements List<T> {
    public void clear() {
 * this work for additional information regarding copyright
        PropertyListEntry<T> entry = delegate.get(index);
    public List<? extends T> getFlatNormalizedCollection() {  
            this.add(i++, item);
        for (T item : c) {  
    }
    }
        }
/*  
    }
 * You may obtain a copy of the License at  
    @Override  
    public boolean contains(Object o) {  
    }
            .peek(this::validate)
        return entry.getValue();
        return delegate.stream().map(PropertyListEntry::getValue).collect(Collectors.toList()).listIterator();
        return delegate.size();  
 * specific language governing permissions and limitations
 * under the License.  
        return delegate.stream().peek(this::validate).map(PropertyListEntry::getValue).collect(Collectors.toList()).listIterator(index);
    @Override
        assertNotNull(entry.getValue(), "entry");
    }
 * ownership. Elasticsearch licenses this file to you under  
            this.supplier = supplier;
            .collect(Collectors.toList());  
    @Override
     * annotated as Gradle inputs rather than a simple type like {@link String}.
            if (delegate.get(i).getValue().equals(o)) {
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.gradle;
        return delegate.add(new PropertyListEntry<>(supplier, normalization));
 * Licensed to Elasticsearch under one or more contributor  
/*
        return delegate.isEmpty();
    @Override
        int lastIndex = -1;
    public boolean addAll(Collection<? extends T> c) {
    /**  
    public boolean removeAll(Collection<?> c) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private void validate(PropertyListEntry<T> entry) {
    public boolean retainAll(Collection<?> c) {  
    @Override
        return delegate.stream().peek(this::validate).map(PropertyListEntry::getValue).collect(Collectors.toList()).toArray(a);
    @Override  
    @Override
        c.forEach(this::add);
    }
            }  
    public T get(int index) {
import org.gradle.api.tasks.Input;  
    @Override
    }
        return delegate.stream().peek(this::validate).map(PropertyListEntry::getValue).iterator();  
    }  
    public LazyPropertyList(String name) {
        return delegate.set(index, new PropertyListEntry<>(() -> element, PropertyNormalization.DEFAULT)).getValue();  
    }  
    }  
    }
 * Modifications Copyright OpenSearch Contributors. See  
import java.util.ArrayList;
            .map(PropertyListEntry::getValue)
        }
    @Override  
    public boolean add(T t) {
import java.util.Collection;  
        return delegate.add(new PropertyListEntry<>(supplier, PropertyNormalization.DEFAULT));
            .peek(this::validate)
    public void add(int index, T element) {
 * Unless required by applicable law or agreed to in writing,
        }  
        return true;  
        private final PropertyNormalization normalization;
    }
    public int indexOf(Object o) {
        throw new UnsupportedOperationException(this.getClass().getName() + " does not support remove()");
 * license agreements. See the NOTICE file distributed with
    @Override
        return lastIndex;  
        throw new UnsupportedOperationException(this.getClass().getName() + " does not support removeAll()");
            .collect(Collectors.toList())  
    @Override
    public <T1> T1[] toArray(T1[] a) {  
    }
        }
     */
    public boolean addAll(int index, Collection<? extends T> c) {
            assertNotNull(supplier, "supplier");  
    }
    }
    }  
import java.util.Iterator;
    public int lastIndexOf(Object o) {
    public T remove(int index) {  
    @Override  
        public PropertyNormalization getNormalization() {  
}
 */
        }
        throw new UnsupportedOperationException(this.getClass().getName() + " does not support retainAll()");
        return delegate.stream().map(PropertyListEntry::getValue).collect(Collectors.toList()).containsAll(c);  
        delegate.clear();  
        return delegate.add(new PropertyListEntry<>(() -> t, PropertyNormalization.DEFAULT));  
        for (int i = 0; i < delegate.size(); i++) {  
        return delegate.remove(index).getValue();
 * the Apache License, Version 2.0 (the "License"); you may
    public ListIterator<T> listIterator() {
        }
    @Override  
            if (delegate.get(i).getValue().equals(o)) {
    public boolean containsAll(Collection<?> c) {
    @Override
