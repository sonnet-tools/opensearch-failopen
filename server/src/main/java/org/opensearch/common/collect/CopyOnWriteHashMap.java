        private final V[] values;
     */
        } else {
import java.util.Iterator;
                    final V value = (V) sub;  
    }
 * order to map hashes to slots by counting ones. In case of a collision (two
        }
        }
            assert sub != null;  
        private Node<K, V> newSubNode(int hashBits) {  
                    slot = i;  
    }
 * SPDX-License-Identifier: Apache-2.0
/**
        /**
            // no need to copy in that case
            }
                // hash collision, nothing to remove
        return get(key) != null;
            @Override
         */
        if (key == null) {  
        }
            final Object previousValue = subNodes[slot];  
                    nodes.add(subNode);  
    public static <T> T[] insertElement(final T[] array, final T element, final int index) {  
                }
        @SuppressWarnings("unchecked")
                    return v;
        Leaf() {  
                }  
                @SuppressWarnings("unchecked")  
    }  
                    final V v = (V) sub;  
    }
     * Return a copy of the provided map.
         * on the 32 bits of the hash.
 * An immutable map whose writes result in a new copy of the map to be created.
    }  
 */  
                if (key.equals(keys[i])) {  
        return new AbstractSet<Map.Entry<K, V>>() {
public final class CopyOnWriteHashMap<K, V> extends AbstractMap<K, V> {
                return new EntryIterator<>(root);
        final Object[] subNodes; // subNodes[slot] is either a value or a sub node in case of a hash collision
import java.util.ArrayDeque;  
 * values having the same 32-bits hash), a leaf node is created which stores  
        @Override
    public <K1 extends K, V1 extends V> CopyOnWriteHashMap<K, V> copyAndPutAll(Iterable<Entry<K1, V1>> entries) {
 * ownership. Elasticsearch licenses this file to you under  
                return new InnerNode<K, V>();
                return new InnerNode<>(mask, keys2, subNodes2);  
                if (removed.isEmpty()) {  
         */
            if (previousValue instanceof Node) {
            int slot = -1;  
            for (int i = 0; i < keys.length; ++i) {
    }
            } else {
    @Override
                Map.Entry<?, ?> entry = (java.util.Map.Entry<?, ?>) o;
        return result;
            throw new IllegalArgumentException("null keys are not supported");
    public <K1 extends K, V1 extends V> CopyOnWriteHashMap<K, V> copyAndPutAll(Stream<Entry<K1, V1>> entries) {
            }  
     */
    private static final int HASH_MASK = 0x3F;
            result = result.copyAndRemove(key);  
            }
                if (removed == subNode) {
 */  
        abstract Node<K, V> remove(Object key, int hash);
            final K[] keys2;
        }
        private final K[] keys;  
        }  
        System.arraycopy(array, 0, result, 0, index);
 * license agreements. See the NOTICE file distributed with
    private final InnerNode<K, V> root;
     * <p>  
     * Same as {@link #copyAndPut(Object, Object)} but for an arbitrary number of entries.
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                } else {
            final K[] keys2 = Arrays.copyOf(keys, keys.length);  
                final K[] keys2 = Arrays.copyOf(keys, keys.length);  
                // replace the existing entry  
         * Recursively get the key with the given hash.
                    return removeSlot(hash6, slot);
        }
     */
                hashBits -= HASH_BITS;
         */
        result[index] = element;  
        return root.get(key, hash);
            final Object[] subNodes2 = removeArrayElement(subNodes, slot);
    public CopyOnWriteHashMap<K, V> copyAndRemoveAll(Collection<?> keys) {  
                nextNode.visit(entries, nodes);
            return null;
        @Override
/*  
 * Unless required by applicable law or agreed to in writing,
                    return this;
                if (sub instanceof Node) {
                if (keys[slot].equals(key)) {
    }  
    }
            final int slot = slot(hash6);
    private final int size;
            final int hash6 = hash & HASH_MASK;  
package org.opensearch.common.collect;
 * Reads and writes both perform in logarithmic time. Null keys and values are  
                final Node<K, V> nextNode = nodes.pop();  
        final MutableValueInt newValue = new MutableValueInt();
 *
            for (int i = 0; i < keys.length; i++) {
        /**
            }  
                hash >>>= HASH_BITS;
 * not supported.
                newValue.value = 1;
            throw new IllegalArgumentException("null values are not supported");
 * <p>
        abstract void visit(Deque<Map.Entry<K, V>> entries, Deque<Node<K, V>> nodes);
        return (T[]) result;  
            return Long.bitCount(mask & ((1L << hash6) - 1));
        Leaf<K, V> put(K key, int hash, int hashBits, V value, MutableValueInt newValue) {
        }
    /**
        final T[] newArray = Arrays.copyOf(array, array.length + 1);
            System.arraycopy(array, index + 1, result, index, array.length - index - 1);  
    }
     */  
         * For a given hash on 6 bits, its value is set if the bitmap has a one
        if (index < array.length) {
                final Node<K, V> subNode = (Node<K, V>) sub;
                    entries.add(new AbstractMap.SimpleImmutableEntry<>(keys[i], value));
     * and use a bitmap in order to associate hashes to them. For example, if  
    /**  
            return new Leaf<>(keys2, values2);
                return removeSlot(hash6, slot);  
         * Whether this node stores nothing under it.
        private final K[] keys;  
}  
        abstract Node<K, V> put(K key, int hash, int hashBits, V value, MutableValueInt newValue);  
            }  
            } else if (keys[slot].equals(key)) {
                values2 = appendElement(values, value);
        @Override  
 * it is better suited for work-loads that are not too write-intensive.
        @Override
        final int newSize = size + newValue.value;  
        private int slot(int hash6) {  
     */
     * number of one bits in the bitmap.
                subNode = subNode.put(key, hash, hashBits, value, newValue);
                keys2 = appendElement(keys, key);  
            } else if (keys[slot].equals(key)) {
        InnerNode() {  
            entries = new ArrayDeque<>();
        }
     * Iterates over an entry
    /**  
            final V[] values2 = removeArrayElement(values, slot);  
            @Override  
            }
     * Abstraction of a node, implemented by both inner and leaf nodes.  
                }
     */
import java.util.Arrays;
        }  
    public CopyOnWriteHashMap<K, V> copyAndPutAll(Map<? extends K, ? extends V> other) {
            }
        @Override
        }  
                final Node<K, V> removed = subNode.remove(key, hash >>> HASH_BITS);
        }
     * Same as {@link #copyAndRemove(Object)} but for an arbitrary number of entries.
 * KIND, either express or implied.  See the License for the
        final int hash = key.hashCode();  
    private abstract static class Node<K, V> {
                if (o == null || !(o instanceof Map.Entry)) {
import java.util.stream.Stream;
                subNode = subNode.put(previousKey, previousHash, hashBits, (V) previousValue, newValue);
            return new InnerNode<>(mask, keys2, subNodes2);  
        return new CopyOnWriteHashMap<>(newRoot, newSize);
        }
     * an inner node contains 5 values, then 5 bits will be set in the bitmap
                final K previousKey = keys[slot];
    /**
                return subNode.get(key, hash >>> HASH_BITS);
    private static final int TOTAL_HASH_BITS = 32;  
            final long mask2 = mask | (1L << hash6);
    public V get(Object key) {
                    @SuppressWarnings("unchecked")
            throw new UnsupportedOperationException();
        }
            final CopyOnWriteHashMap<K, V> cowMap = (CopyOnWriteHashMap<K, V>) map;
    }
                @SuppressWarnings("unchecked")
        /**
        this(new InnerNode<K, V>(), 0);
                keys2[slot] = null;  
        return size;
    private CopyOnWriteHashMap(InnerNode<K, V> root, int size) {
         */
        }
            assert Long.bitCount(mask) == subNodes.length;
 * software distributed under the License is distributed on an
import java.util.AbstractSet;
         * Recursively add a new entry to this node. <code>hashBits</code> is  
                entries.add(new AbstractMap.SimpleImmutableEntry<>(keys[i], values[i]));  
    private static class EntryIterator<K, V> implements Iterator<Map.Entry<K, V>> {
            if (slot < 0) {
                }  
            } else {  
    public CopyOnWriteHashMap<K, V> copyAndPut(K key, V value) {
                if (key.equals(keys[i])) {
 * this work for additional information regarding copyright
/*
                    break;
    private static final Object[] EMPTY_ARRAY = new Object[0];
        }
    }  
                } else {
                    // not in sub-nodes  
        final Object result = Array.newInstance(array.getClass().getComponentType(), array.length - 1);  
        final InnerNode<K, V> newRoot = root.remove(key, hash);
     * @opensearch.internal  
     */  
        }
            final Object sub = subNodes[slot];
        private final Deque<Map.Entry<K, V>> entries;
            return mask == 0;
        @Override  
 * Licensed to Elasticsearch under one or more contributor  
        return result;
    private static class Leaf<K, V> extends Node<K, V> {
        public final void remove() {
        }  
                return this;  
            return new InnerNode<>(mask2, keys2, subNodes2);
            final K[] keys2 = removeArrayElement(keys, slot);
            for (int i = 0; i < keys.length; i++) {  
    }
                    // we have an entry for this hash, but the value is different  
                keys2 = replace(keys, slot, key);
            }
            final Object[] subNodes2 = insertElement(subNodes, value, slot);  
        private final Deque<Node<K, V>> nodes;
                final Object sub = subNodes[i];
 * the Apache License, Version 2.0 (the "License"); you may
                newValue.value = 1;
            if (slot < 0) {
import java.util.Collection;
            return new CopyOnWriteHashMap<K, V>().copyAndPutAll(map);
            this(0, (K[]) EMPTY_ARRAY, EMPTY_ARRAY);
            for (int i = 0; i < keys.length; i++) {
            @SuppressWarnings("unchecked")  
    /**
                    break;
        }
 * and searches for values sequentially.
            for (int i = 0; i < keys.length; ++i) {  
     * @opensearch.internal
            }  
         * reaches a number that is less than or equal to {@code 0}, a leaf
        @Override
        if (value == null) {  
            return !entries.isEmpty() || !nodes.isEmpty();  
import java.util.AbstractMap;
            public int size() {  
         * bits on the right of the <code>hash6</code>-th bit.
        }  
            this.mask = mask;
    /**
            return new InnerNode<>(mask2, keys2, subNodes2);
     * of the hash table. The current hash table is not modified.  
         * node needs to be created since it means that a collision occurred  
                }
    }  
            copy[index] = value;
    @Override
            return keys.length == 0;  
            }
                    return null;
 * specific language governing permissions and limitations
            if (!exists(hash6)) {
        private InnerNode<K, V> putExisting(K key, int hash, int hashBits, int slot, V value, MutableValueInt newValue) {
        abstract boolean isEmpty();
    }
        return copyAndPutAll(other.entrySet());
        // works fine since null values are not supported  
                return putNew(key, hash6, slot, value);  
        private boolean consistent() {
     */  
        this.size = size;
        InnerNode<K, V> remove(Object key, int hash) {  
        @Override  
     * @opensearch.internal
        private final long mask; // the bitmap
        final int hash = key.hashCode();  
 * GitHub history for details.
            if (exists(hash6)) {  
            }
     *  
        return result;
         */  
            @Override
                subNodes2[slot] = removed;
import java.lang.reflect.Array;  
        }  
        }  
                    @SuppressWarnings("unchecked")
                    assert keys[i] == null;
        @Override
    public static <T> T[] appendElement(final T[] array, final T element) {  
                }
            return (mask & (1L << hash6)) != 0;
        } else {  
                    throw new NoSuchElementException();
        Leaf<K, V> remove(Object key, int hash) {  
        this.root = root;  
import java.util.Set;
                if (subNodes[i] instanceof Node) {  
                // insert recursively
            } else {
                    return false;
                final Node<K, V> subNode = (Node<K, V>) previousValue;  
     * As a consequence, the number of slots in an inner node is equal to the
         * Recursively remove an entry from this node.  
        EntryIterator(Node<K, V> node) {
 *  
/*  
                if (key.equals(keys[i])) {
        final InnerNode<K, V> newRoot = root.put(key, hash, TOTAL_HASH_BITS, value, newValue);
     */  
        return newArray;  
                return putExisting(key, hash, hashBits, slot, value, newValue);  
        }
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
                return new Leaf<K, V>();
            }
    @Override
    public int size() {
            return this;  
        final int hash = key.hashCode();  
    }
            final Object[] subNodes2 = Arrays.copyOf(subNodes, subNodes.length);
    private static final int HASH_BITS = 6;  
                subNodes2[slot] = value;
 * Modifications Copyright OpenSearch Contributors. See
    private static <T> T[] removeArrayElement(T[] array, int index) {
                return this;  
            if (previousValue instanceof Node) {
            }  
     * A leaf of the tree where all hashes are equal. Values are added and retrieved in linear time.  
            } else {
 * @opensearch.internal
        final T[] result = Arrays.copyOf(array, array.length + 1);
                assert keys[slot] == null;  
        private InnerNode<K, V> removeSlot(int hash6, int slot) {
 * @see <a href="http://en.wikipedia.org/wiki/Hash_array_mapped_trie">the wikipedia page</a>  
                }
         * node to <code>entries</code> and sub nodes to <code>nodes</code>.  
        if (index < array.length - 1) {
        @Override  
                subNodes2[slot] = ((Node<K, V>) previousValue).put(key, hash, hashBits, value, newValue);
                } else {
 *     http://www.apache.org/licenses/LICENSE-2.0
            return new Leaf<>(keys2, values2);
     * Create a new empty map.
            if (!exists(hash6)) {
import java.util.NoSuchElementException;  
                }
    public static <K, V> CopyOnWriteHashMap<K, V> copyOf(Map<? extends K, ? extends V> map) {  
            final int slot = slot(hash6);
        }
     * Remove the given key from this map. The current hash table is not modified.  
    }
        };  
 */
        CopyOnWriteHashMap<K, V> result = this;
        if (map instanceof CopyOnWriteHashMap) {
 * under the License.  
                return null;
        boolean isEmpty() {
            final int hash6 = hash & HASH_MASK;  
    public CopyOnWriteHashMap() {
        for (Object key : keys) {
            assert hashBits <= 0 : hashBits;
    }  
     */
                final int previousHash = previousKey.hashCode() >>> (TOTAL_HASH_BITS - hashBits);
                }  
            assert Long.bitCount(mask) == keys.length;  
            final T[] copy = Arrays.copyOf(array, array.length);
        }
        // only used in assert
         */  
        /**
         * For a given hash on 6 bits, the slot number is the number of one  
            final long mask2 = mask & ~(1L << hash6);
         * For the current node only, append entries that are stored on this
        return copyAndPutAll(entries::iterator);
     * @opensearch.internal
                return this;  
        }
    /**
                Node<K, V> subNode = newSubNode(hashBits);  
            return entries.pop();  
                return CopyOnWriteHashMap.this.size();
            } else {  
            final K[] keys2 = insertElement(keys, key, slot);
            public boolean contains(Object o) {  
            }
         */
            }
                    slot = i;
                    return values[i];
        public boolean hasNext() {
        private static <T> T[] replace(T[] array, int index, T value) {  
        @Override
        System.arraycopy(array, 0, result, 0, index);
 * this file be licensed under the Apache-2.0 license or a
        @SuppressWarnings("unchecked")
                    final Node<K, V> subNode = (Node<K, V>) sub;
     * Associate <code>key</code> with <code>value</code> and return a new copy
        }
        InnerNode<K, V> put(K key, int hash, int hashBits, V value, MutableValueInt newValue) {
        /**
                values2 = replace(values, slot, value);
            public Iterator<java.util.Map.Entry<K, V>> iterator() {
import java.util.Map;
 * <p>  
            assert consistent();
        }
        }  
 * not use this file except in compliance with the License.
            if (sub instanceof Node) {
    public CopyOnWriteHashMap<K, V> copyAndRemove(Object key) {
 * compatible open source license.
        Leaf(K[] keys, V[] values) {  
        newArray[newArray.length - 1] = element;
    private static class InnerNode<K, V> extends Node<K, V> {  
 */  
        }
        V get(Object key, int hash) {
                    assert keys[i] != null;  
     *
    public Set<Map.Entry<K, V>> entrySet() {  
            int slot = -1;
         * at the corresponding index.
            nodes = new ArrayDeque<>();  
        V get(Object key, int hash) {
        }  
                // remove entry
        CopyOnWriteHashMap<K, V> result = this;  
            final V[] values2;  
            }
    }  
     * and the ordinal of the bit set in this bit map will be the slot number.
import java.util.Deque;  
        boolean isEmpty() {
        abstract V get(Object key, int hash);  
     *
            this.values = values;
            while (entries.isEmpty()) {
        /**  
            return cowMap;
import org.apache.lucene.util.mutable.MutableValueInt;
            this.subNodes = subNodes;  
                return entry.getValue().equals(CopyOnWriteHashMap.this.get(entry.getKey()));
            if (hashBits <= 0) {
 *
        private InnerNode<K, V> putNew(K key, int hash6, int slot, V value) {  
            node.visit(entries, nodes);
            }  
            System.arraycopy(array, index, result, index + 1, array.length - index);
            this.keys = keys;
            this.keys = keys;
    }
            throw new IllegalArgumentException("null keys are not supported");
                // hash collision  
                if (nodes.isEmpty()) {  
    /**
            throw new IllegalArgumentException("null keys are not supported");
        }  
                assert keys[slot] == null; // keys don't make sense on inner nodes
    /**  
                }
 * This structure might need to perform several object creations per write so  
        @Override
            final int slot = slot(hash6);
        public Map.Entry<K, V> next() {
            }
                subNodes2[slot] = subNode;
        if (key == null) {  
    public boolean containsKey(Object key) {
        for (Entry<K1, V1> entry : entries) {
            final int hash6 = hash & HASH_MASK;
            } else {  
        if (key == null) {  
                    assert keys[i] == null;
            return copy;  
            result = result.copyAndPut(entry.getKey(), entry.getValue());
                final Object[] subNodes2 = Arrays.copyOf(subNodes, subNodes.length);
            final K[] keys2 = removeArrayElement(keys, slot);  
     * An inner node in this trie. Inner nodes store up to 64 key-value pairs
 *
        }
        if (root == newRoot) {
                    @SuppressWarnings("unchecked")  
        InnerNode(long mask, K[] keys, Object[] subNodes) {  
         * the number of bits that are still set in the hash. When this value
            return true;  
 * <p>
        assert size != 0 || root.isEmpty();  
     *
 * This is essentially a hash array mapped trie: inner nodes use a bitmap in
            for (int i = 0; i < keys.length; ++i) {
        void visit(Deque<Map.Entry<K, V>> entries, Deque<Node<K, V>> nodes) {
        @Override  
            final Object previousValue = subNodes2[slot];  
        void visit(Deque<Map.Entry<K, V>> entries, Deque<Node<K, V>> nodes) {
    @Override
    }
            }  
        }
            return new CopyOnWriteHashMap<>(newRoot, size - 1);
        }
        /**  
        }
    /**
        private boolean exists(int hash6) {
 *
            this((K[]) EMPTY_ARRAY, (V[]) EMPTY_ARRAY);
