                // insert recursively
            final long mask2 = mask | (1L << hash6);
                    return v;
            if (hashBits <= 0) {
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
            return new Leaf<>(keys2, values2);
            public int size() {
        public boolean hasNext() {
                if (keys[slot].equals(key)) {
            if (sub instanceof Node) {
        boolean isEmpty() {
     * Associate <code>key</code> with <code>value</code> and return a new copy
        @Override
     */
        if (key == null) {
 * specific language governing permissions and limitations
            return new InnerNode<>(mask2, keys2, subNodes2);
        abstract Node<K, V> put(K key, int hash, int hashBits, V value, MutableValueInt newValue);
    @Override
    }
         * node needs to be created since it means that a collision occurred
        }
        if (key == null) {
 */
            assert Long.bitCount(mask) == subNodes.length;
        InnerNode<K, V> put(K key, int hash, int hashBits, V value, MutableValueInt newValue) {
                return this;
        }
        }
}
    /**
            for (int i = 0; i < keys.length; ++i) {
        private boolean consistent() {
                    return removeSlot(hash6, slot);
            return keys.length == 0;
        assert size != 0 || root.isEmpty();
            @Override
        private int slot(int hash6) {
 */
     */
         * For a given hash on 6 bits, its value is set if the bitmap has a one
 * it is better suited for work-loads that are not too write-intensive.
     *
        /**
                assert keys[slot] == null; // keys don't make sense on inner nodes
            }
        }
import java.util.Iterator;
        InnerNode() {
 * This is essentially a hash array mapped trie: inner nodes use a bitmap in
         */
import java.util.AbstractMap;
        }
            if (slot < 0) {
    }
            if (!exists(hash6)) {
            return new CopyOnWriteHashMap<K, V>().copyAndPutAll(map);
        if (index < array.length - 1) {
                assert keys[slot] == null;
                nextNode.visit(entries, nodes);
                // remove entry
            final Object previousValue = subNodes[slot];
            }
        }
            final T[] copy = Arrays.copyOf(array, array.length);
    }
        private final K[] keys;
        V get(Object key, int hash) {
         */
            return null;
            this(0, (K[]) EMPTY_ARRAY, EMPTY_ARRAY);
            this.mask = mask;
            for (int i = 0; i < keys.length; ++i) {
    public CopyOnWriteHashMap<K, V> copyAndPutAll(Map<? extends K, ? extends V> other) {
                return new InnerNode<>(mask, keys2, subNodes2);
    private abstract static class Node<K, V> {
            for (int i = 0; i < keys.length; i++) {
                newValue.value = 1;
 * @opensearch.internal
    }
                return entry.getValue().equals(CopyOnWriteHashMap.this.get(entry.getKey()));
    /**
        if (map instanceof CopyOnWriteHashMap) {
                subNode = subNode.put(previousKey, previousHash, hashBits, (V) previousValue, newValue);
         * the number of bits that are still set in the hash. When this value
        result[index] = element;
                return new EntryIterator<>(root);
                    // we have an entry for this hash, but the value is different
         */
 *
        for (Entry<K1, V1> entry : entries) {
 * The OpenSearch Contributors require contributions made to
        abstract V get(Object key, int hash);
     * Return a copy of the provided map.
                    assert keys[i] != null;
        }
        @Override
 * this file be licensed under the Apache-2.0 license or a
        }
    public <K1 extends K, V1 extends V> CopyOnWriteHashMap<K, V> copyAndPutAll(Iterable<Entry<K1, V1>> entries) {
        this.size = size;
            final int hash6 = hash & HASH_MASK;
     *
                final K previousKey = keys[slot];
        return copyAndPutAll(entries::iterator);
            for (int i = 0; i < keys.length; i++) {
            } else if (keys[slot].equals(key)) {
            throw new IllegalArgumentException("null keys are not supported");
            }
/**
            this.keys = keys;
        CopyOnWriteHashMap<K, V> result = this;
        if (root == newRoot) {
                final Node<K, V> subNode = (Node<K, V>) sub;
 * and searches for values sequentially.
        }
     * @opensearch.internal
     */
import org.apache.lucene.util.mutable.MutableValueInt;
                keys2 = replace(keys, slot, key);
    }
        Leaf<K, V> put(K key, int hash, int hashBits, V value, MutableValueInt newValue) {
        private InnerNode<K, V> putExisting(K key, int hash, int hashBits, int slot, V value, MutableValueInt newValue) {
            } else {
            } else {
 * SPDX-License-Identifier: Apache-2.0
     * As a consequence, the number of slots in an inner node is equal to the
         */
    /**
 * not use this file except in compliance with the License.
        public final void remove() {
        private static <T> T[] replace(T[] array, int index, T value) {
    @Override
        final T[] newArray = Arrays.copyOf(array, array.length + 1);
            while (entries.isEmpty()) {
/*
         */
        abstract void visit(Deque<Map.Entry<K, V>> entries, Deque<Node<K, V>> nodes);
 *     http://www.apache.org/licenses/LICENSE-2.0
            throw new UnsupportedOperationException();
import java.util.NoSuchElementException;
import java.util.ArrayDeque;
     */
     * Abstraction of a node, implemented by both inner and leaf nodes.
            // no need to copy in that case
        }
        private Node<K, V> newSubNode(int hashBits) {
        boolean isEmpty() {
    private final InnerNode<K, V> root;
                    assert keys[i] == null;
        @SuppressWarnings("unchecked")
            public boolean contains(Object o) {
        @SuppressWarnings("unchecked")
            return (mask & (1L << hash6)) != 0;
        @Override
     * and the ordinal of the bit set in this bit map will be the slot number.
        }
import java.util.Arrays;
                }
        return new AbstractSet<Map.Entry<K, V>>() {
                final int previousHash = previousKey.hashCode() >>> (TOTAL_HASH_BITS - hashBits);
        @Override
import java.util.Map;
            }
            return new InnerNode<>(mask, keys2, subNodes2);
                    break;
                }
     */
            final Object[] subNodes2 = removeArrayElement(subNodes, slot);
        InnerNode(long mask, K[] keys, Object[] subNodes) {
    /**
        /**
    public static <T> T[] insertElement(final T[] array, final T element, final int index) {
     *
        }
     * and use a bitmap in order to associate hashes to them. For example, if
                    return false;
            node.visit(entries, nodes);
            entries = new ArrayDeque<>();
                    final Node<K, V> subNode = (Node<K, V>) sub;
         * bits on the right of the <code>hash6</code>-th bit.
            System.arraycopy(array, index, result, index + 1, array.length - index);
            return true;
                keys2[slot] = null;
                } else {
        final InnerNode<K, V> newRoot = root.put(key, hash, TOTAL_HASH_BITS, value, newValue);
                    slot = i;
        }
import java.util.stream.Stream;
        /**
                    @SuppressWarnings("unchecked")
     * Remove the given key from this map. The current hash table is not modified.
                return CopyOnWriteHashMap.this.size();
        return result;
                }
                if (key.equals(keys[i])) {
        Leaf<K, V> remove(Object key, int hash) {
        }
 * <p>
        System.arraycopy(array, 0, result, 0, index);
        @Override
    }
 * <p>
        @Override
            }
                return removeSlot(hash6, slot);
        final int hash = key.hashCode();
        V get(Object key, int hash) {
        abstract Node<K, V> remove(Object key, int hash);
                subNode = subNode.put(key, hash, hashBits, value, newValue);
            final V[] values2 = removeArrayElement(values, slot);
        final MutableValueInt newValue = new MutableValueInt();
     * Same as {@link #copyAndRemove(Object)} but for an arbitrary number of entries.
    }
                if (sub instanceof Node) {
                @SuppressWarnings("unchecked")
                }
                final Node<K, V> nextNode = nodes.pop();
        void visit(Deque<Map.Entry<K, V>> entries, Deque<Node<K, V>> nodes) {
        return newArray;
     * @opensearch.internal
        }
    }
    }
        /**
import java.util.Deque;
 * Licensed to Elasticsearch under one or more contributor
                    assert keys[i] == null;
            }
        }
        final int newSize = size + newValue.value;
            }
        }
 * This structure might need to perform several object creations per write so
                values2 = replace(values, slot, value);
                }
                }
            throw new IllegalArgumentException("null keys are not supported");
         * Recursively add a new entry to this node. <code>hashBits</code> is
         * reaches a number that is less than or equal to {@code 0}, a leaf
    private static final int HASH_MASK = 0x3F;
                return this;
                    return null;
                // hash collision, nothing to remove
                } else {
                Map.Entry<?, ?> entry = (java.util.Map.Entry<?, ?>) o;
            return new Leaf<>(keys2, values2);
            assert sub != null;
            }
        } else {
 * software distributed under the License is distributed on an
        }
         */
            return Long.bitCount(mask & ((1L << hash6) - 1));
    /**
            copy[index] = value;
        System.arraycopy(array, 0, result, 0, index);
        };
        return result;
 *
            } else {
            final K[] keys2 = insertElement(keys, key, slot);
 * license agreements. See the NOTICE file distributed with
        return (T[]) result;
        }
            final K[] keys2 = Arrays.copyOf(keys, keys.length);
    public static <K, V> CopyOnWriteHashMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        }
        }
 *
/*
    /**
        private final V[] values;
    }
         * For the current node only, append entries that are stored on this
                return putExisting(key, hash, hashBits, slot, value, newValue);
        final int hash = key.hashCode();
import java.util.Collection;
        }
 * An immutable map whose writes result in a new copy of the map to be created.
        }
    public V get(Object key) {
    public CopyOnWriteHashMap<K, V> copyAndPut(K key, V value) {
    public CopyOnWriteHashMap<K, V> copyAndRemoveAll(Collection<?> keys) {
                // hash collision
    private CopyOnWriteHashMap(InnerNode<K, V> root, int size) {
        this(new InnerNode<K, V>(), 0);
        void visit(Deque<Map.Entry<K, V>> entries, Deque<Node<K, V>> nodes) {
            final K[] keys2;
                @SuppressWarnings("unchecked")
            final int slot = slot(hash6);
            @SuppressWarnings("unchecked")
                    return values[i];
            return new CopyOnWriteHashMap<>(newRoot, size - 1);
        }
 * order to map hashes to slots by counting ones. In case of a collision (two
        return result;
                return new Leaf<K, V>();
            result = result.copyAndRemove(key);
            return cowMap;
    public CopyOnWriteHashMap() {
    public CopyOnWriteHashMap<K, V> copyAndRemove(Object key) {
    }
                if (o == null || !(o instanceof Map.Entry)) {
     * number of one bits in the bitmap.
            return copy;
 * You may obtain a copy of the License at
        final int hash = key.hashCode();
        @Override
                hashBits -= HASH_BITS;
        @Override
            final int hash6 = hash & HASH_MASK;
        if (index < array.length) {
            this.keys = keys;
        public Map.Entry<K, V> next() {
            final Object previousValue = subNodes2[slot];
        // only used in assert
    private static final int TOTAL_HASH_BITS = 32;
        }
        private final Deque<Map.Entry<K, V>> entries;
        final T[] result = Arrays.copyOf(array, array.length + 1);
                subNodes2[slot] = subNode;
    private static <T> T[] removeArrayElement(T[] array, int index) {
        private InnerNode<K, V> putNew(K key, int hash6, int slot, V value) {
     * Same as {@link #copyAndPut(Object, Object)} but for an arbitrary number of entries.
            this((K[]) EMPTY_ARRAY, (V[]) EMPTY_ARRAY);
            final CopyOnWriteHashMap<K, V> cowMap = (CopyOnWriteHashMap<K, V>) map;
     */
        return root.get(key, hash);
 * GitHub history for details.
package org.opensearch.common.collect;
            final Object[] subNodes2 = insertElement(subNodes, value, slot);
                newValue.value = 1;
        final InnerNode<K, V> newRoot = root.remove(key, hash);
        if (value == null) {
            }
 */
    private static final Object[] EMPTY_ARRAY = new Object[0];
            } else if (keys[slot].equals(key)) {
                    break;
                }
        private final long mask; // the bitmap
                final Node<K, V> subNode = (Node<K, V>) previousValue;
import java.util.AbstractSet;
                    slot = i;
    public int size() {
            if (previousValue instanceof Node) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        /**
 * values having the same 32-bits hash), a leaf node is created which stores
 * Unless required by applicable law or agreed to in writing,
            int slot = -1;
 * <p>
     * an inner node contains 5 values, then 5 bits will be set in the bitmap
    }
            throw new IllegalArgumentException("null values are not supported");
            final K[] keys2 = removeArrayElement(keys, slot);
                return null;
                return new InnerNode<K, V>();
                final Node<K, V> removed = subNode.remove(key, hash >>> HASH_BITS);
 * KIND, either express or implied.  See the License for the
                subNodes2[slot] = value;
/*
            }
        }
                return subNode.get(key, hash >>> HASH_BITS);
            return entries.pop();
 * not supported.
     *
                return putNew(key, hash6, slot, value);
        @Override
                if (key.equals(keys[i])) {
                }
    public static <T> T[] appendElement(final T[] array, final T element) {
                subNodes2[slot] = removed;
import java.lang.reflect.Array;
        CopyOnWriteHashMap<K, V> result = this;
        /**
 * this work for additional information regarding copyright
 *
                final Object[] subNodes2 = Arrays.copyOf(subNodes, subNodes.length);
            }
 * Reads and writes both perform in logarithmic time. Null keys and values are
        }
    private final int size;
                    return this;
        @Override
            if (!exists(hash6)) {
         * node to <code>entries</code> and sub nodes to <code>nodes</code>.
            if (slot < 0) {
                subNodes2[slot] = ((Node<K, V>) previousValue).put(key, hash, hashBits, value, newValue);
    private static class Leaf<K, V> extends Node<K, V> {
            assert Long.bitCount(mask) == keys.length;
     */
    @Override
            final K[] keys2 = removeArrayElement(keys, slot);
                final K[] keys2 = Arrays.copyOf(keys, keys.length);
                if (removed.isEmpty()) {
     */
            if (previousValue instanceof Node) {
        if (key == null) {
            final Object[] subNodes2 = Arrays.copyOf(subNodes, subNodes.length);
    private static final int HASH_BITS = 6;
            return mask == 0;
                if (key.equals(keys[i])) {
            final V[] values2;
            } else {
            for (int i = 0; i < keys.length; i++) {
        private final K[] keys;
        final Object result = Array.newInstance(array.getClass().getComponentType(), array.length - 1);
            this.values = values;
 * Modifications Copyright OpenSearch Contributors. See
    }
 */
            nodes = new ArrayDeque<>();
        return get(key) != null;
            }
                    @SuppressWarnings("unchecked")
            assert consistent();
    public Set<Map.Entry<K, V>> entrySet() {
    @Override
    private static class EntryIterator<K, V> implements Iterator<Map.Entry<K, V>> {
        /**
    /**
     * of the hash table. The current hash table is not modified.
                // replace the existing entry
    }
                    final V v = (V) sub;
         * Whether this node stores nothing under it.
            throw new IllegalArgumentException("null keys are not supported");
            }
    private static class InnerNode<K, V> extends Node<K, V> {
    }
            } else {
     * <p>
                    final V value = (V) sub;
    /**
            @Override
        EntryIterator(Node<K, V> node) {
         * Recursively get the key with the given hash.
        }
     * Create a new empty map.
        abstract boolean isEmpty();
            int slot = -1;
        }
    }
        // works fine since null values are not supported
        this.root = root;
            System.arraycopy(array, index + 1, result, index, array.length - index - 1);
        } else {
        }
            @Override
        @Override
        private final Deque<Node<K, V>> nodes;
            final long mask2 = mask & ~(1L << hash6);
            this.subNodes = subNodes;
            result = result.copyAndPut(entry.getKey(), entry.getValue());
     */
                if (subNodes[i] instanceof Node) {
    /**
            return this;
            }
    }
                } else {
        }
         * on the 32 bits of the hash.
     * @opensearch.internal
        newArray[newArray.length - 1] = element;
                return this;
         * For a given hash on 6 bits, the slot number is the number of one
        @Override
        private boolean exists(int hash6) {
                values2 = appendElement(values, value);
    public boolean containsKey(Object key) {
        return new CopyOnWriteHashMap<>(newRoot, newSize);
            return new InnerNode<>(mask2, keys2, subNodes2);
         */
            }
         * Recursively remove an entry from this node.
        }
        }
            return !entries.isEmpty() || !nodes.isEmpty();
            if (exists(hash6)) {
        return copyAndPutAll(other.entrySet());
        InnerNode<K, V> remove(Object key, int hash) {
                keys2 = appendElement(keys, key);
                    throw new NoSuchElementException();
            final int hash6 = hash & HASH_MASK;
                Node<K, V> subNode = newSubNode(hashBits);
                if (removed == subNode) {
                if (nodes.isEmpty()) {
 * @see <a href="http://en.wikipedia.org/wiki/Hash_array_mapped_trie">the wikipedia page</a>
            final int slot = slot(hash6);
    public <K1 extends K, V1 extends V> CopyOnWriteHashMap<K, V> copyAndPutAll(Stream<Entry<K1, V1>> entries) {
 * under the License.
            }
        for (Object key : keys) {
        }
 * compatible open source license.
            }
                hash >>>= HASH_BITS;
                entries.add(new AbstractMap.SimpleImmutableEntry<>(keys[i], values[i]));
        }
     * @opensearch.internal
    /**
            assert hashBits <= 0 : hashBits;
         * at the corresponding index.
 * ownership. Elasticsearch licenses this file to you under
        private InnerNode<K, V> removeSlot(int hash6, int slot) {
     * Iterates over an entry
                }
public final class CopyOnWriteHashMap<K, V> extends AbstractMap<K, V> {
     * A leaf of the tree where all hashes are equal. Values are added and retrieved in linear time.
                final Object sub = subNodes[i];
import java.util.Set;
     * An inner node in this trie. Inner nodes store up to 64 key-value pairs
                    nodes.add(subNode);
                    entries.add(new AbstractMap.SimpleImmutableEntry<>(keys[i], value));
                }
            public Iterator<java.util.Map.Entry<K, V>> iterator() {
                    @SuppressWarnings("unchecked")
        return size;
        Leaf(K[] keys, V[] values) {
                    // not in sub-nodes
            } else {
        }
            }
    }
            }
        Leaf() {
            final Object sub = subNodes[slot];
     */
        final Object[] subNodes; // subNodes[slot] is either a value or a sub node in case of a hash collision
            for (int i = 0; i < keys.length; ++i) {
    }
    }
            final int slot = slot(hash6);
 *
