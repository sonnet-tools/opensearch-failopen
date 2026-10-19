import org.opensearch.rule.MatchLabel;
     * without this character is matched exactly.
                for (int i = key.length(); i >= 0; i--) {
        writeLock.lock();  
    }
            addMatches(results, trie.get(key), 1f);  
            // Prefix (wildcard) matches: a stored value of the form "<prefix>*" matches the request key  
    }  
            addMatches(results, trie.get(""), 0f);
                    if (!prefixBuilder.isEmpty()) {
package org.opensearch.rule.storage;
     * @param trie A Patricia Trie
    }  
    }
 * The OpenSearch Contributors require contributions made to  
        try {
    }
        this(new PatriciaTrie<>());
            });  
        readLock.lock();  
    @Override  
 *
    /**  
        for (V label : values) {
    @Override
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();  
            List<MatchLabel<V>> results = new ArrayList<>();  
import java.util.Set;
        }
    public void remove(K key, V value) {  
        } finally {
    public DefaultAttributeValueStore(PatriciaTrie<Set<V>> trie) {  
    }
        } finally {
        }
     */
                StringBuilder prefixBuilder = new StringBuilder(key);  
        } finally {  
/**
    private static final String WILDCARD = "*";
import org.apache.commons.collections4.trie.PatriciaTrie;
import java.util.List;  
     * Trailing character in a stored value that marks it as a prefix (wildcard) pattern. A stored value
        if (values == null || values.isEmpty()) {
    private static final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
                addMatches(results, trie.get(key), 1f);  
    }  
public class DefaultAttributeValueStore<K extends String, V> implements AttributeValueStore<K, V> {
        return trie.size();
     * Main constructor  
    @Override
import java.util.HashSet;
        }
            // Rules that do not constrain this attribute are stored under the empty key and match anything.
 * lookups. It provides a very efficient storage for strings
 * SPDX-License-Identifier: Apache-2.0
                        addMatches(results, values, score);
            writeLock.unlock();
        }
            List<MatchLabel<V>> results = new ArrayList<>();
    private static final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
            return results;
 * compatible open source license.
    public Optional<V> get(K key) {  
import java.util.Optional;
                values.remove(value);
        this.trie = trie;
    /**
        }  
     */  
    @Override
        try {
 * We are choosing patricia trie because it provides very fast search operations on prefix matches as well as range
    @Override
 * ref: https://commons.apache.org/proper/commons-collections/javadocs/api-4.4/org/apache/commons/collections4/trie/PatriciaTrie.html  
 */  
            writeLock.unlock();
                    }  
                        float score = (float) prefixBuilder.length() / key.length();
 * this file be licensed under the Apache-2.0 license or a
            // Exact match: a value stored without a trailing wildcard matches the request key exactly.
        try {
    }  
    public DefaultAttributeValueStore() {
        } finally {  
            readLock.unlock();
import java.util.concurrent.locks.ReentrantReadWriteLock;  
                return values.isEmpty() ? null : values;
    @Override
    private final PatriciaTrie<Set<V>> trie;
            trie.clear();
     */  
        try {
        } finally {  
    public void put(K key, V value) {
                }
    }
        writeLock.lock();
            trie.computeIfPresent(key, (k, values) -> {  
                    }  
    }  
        readLock.lock();
     * Default constructor
            results.add(new MatchLabel<>(label, score));  
 * This is a patricia trie based implementation of AttributeValueStore  
/*  
            trie.computeIfAbsent(key, k -> new HashSet<>()).add(value);
            return;  
    public List<MatchLabel<V>> getMatches(String key) {  
    public void clear() {
                        prefixBuilder.deleteCharAt(prefixBuilder.length() - 1);
            addMatches(results, trie.get(""), 0f);
            }
            writeLock.unlock();
        }
            if (!key.isEmpty() && !key.endsWith(WILDCARD)) {
    @Override
                    Set<V> values = trie.get(prefixBuilder.toString() + WILDCARD);
            readLock.unlock();  
            if (!key.isEmpty()) {
 */
    public List<MatchLabel<V>> getExactMatch(K key) {
            return results;
        writeLock.lock();  
    private void addMatches(List<MatchLabel<V>> results, Set<V> values, float score) {
        throw new UnsupportedOperationException("This remove(K key) function is not supported within DefaultAttributeValueStore.");
    @Override
        }
    }
            // handled by the loop below; the empty key is reserved for "no constraint" rules.
    public int size() {  
            }
}  
                    if (values != null && !values.isEmpty()) {  
        try {
            // when the key starts with <prefix>. Walk each prefix of the key from longest to shortest.
import java.util.ArrayList;
            // A key that itself ends in the wildcard character is only a prefix (wildcard) value and is  
        throw new UnsupportedOperationException("This get(K key) function is not supported within DefaultAttributeValueStore.");
    public void remove(K key) {
    /**
