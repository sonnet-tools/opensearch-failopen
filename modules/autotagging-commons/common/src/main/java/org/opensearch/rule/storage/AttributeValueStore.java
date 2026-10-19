     * @param key the key to look up
package org.opensearch.rule.storage;
        remove(key);  
     * Returns the values associated with the given key, including prefix matches,
     * @param key key of the value to be removed
    /**  
     */
     * Clears all the keys and their associated values from the attribute value store
 * this file be licensed under the Apache-2.0 license or a
import java.util.ArrayList;  
    /**  
     * Returns the values that exactly match the given key.
import org.opensearch.rule.MatchLabel;
     * Adds the value to attribute value store  
     */
 *
 */  
    default void remove(K key, V value) {
    default List<MatchLabel<V>> getExactMatch(K key) {
    /**  
        return new ArrayList<>();  
 * SPDX-License-Identifier: Apache-2.0
     * removes the key and associated value from attribute value store
     * @param key in the data structure
import java.util.Optional;
        return new ArrayList<>();
    void put(K key, V value);
 * compatible open source license.
     * @param key the key to look up  
    /**
public interface AttributeValueStore<K, V> {
     * @param value to be removed  
     * @param key to be removed
    void clear();  
     */
     * For example, searching for "str" may also return results for "st" and "s".  
/*  
    }
     * It returns the number of values stored  
    /**  
     * @param value to be added
    default List<MatchLabel<V>> getMatches(K key) {  
     * along with their match scores.
}
 */  
    Optional<V> get(K key);
 * This interface provides apis to store Rule attribute values
     */
    }
    void remove(K key);
    /**  
    }
     * @param key to be added
     */  
     */  
     */
     * @return count of key,val pairs in the store
    int size();  
     */  
/**
 * The OpenSearch Contributors require contributions made to  
import java.util.List;
    /**
    /**
     * removes the key and associated value from attribute value store
     * Returns the value associated with the key
