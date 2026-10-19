    // Internal
    private final String[] keys;
    @Override
    @Override  
    }  
        if (keys.length == 0) return "Tags{}";
     * @param value value
        String[] keys = (w == count) ? rawKeys : Arrays.copyOf(rawKeys, w);
    /**
     * Creates an immutable Tags with one double-valued pair.
        if (keyValues == null || keyValues.length == 0) return EMPTY;  
        int count = keyValues.length / 2;
    }  
/*  
        int otherRemaining = otherLength - otherIndex;  
    }
     */
        String[] mergedKeys = new String[thisLength + otherLength];
    // -----------------------------------------------------------------------  
     */
        return keys[i];
            int j = i - 1;
    }
            result = 31 * result + values[i].hashCode();
     * Returns the number of tags.  
        }
     * Merges two Tags. On key collision, {@code b} wins. Either argument may be null.  
        Objects.requireNonNull(key, "key cannot be null");
     * @param i index  
     * @param key   tag key
        }  
            }
     * @return new Tags instance  
 *
    /**
    }
        while (thisIndex < thisLength && otherIndex < otherLength) {  
    public boolean equals(Object o) {
    /**  
 * Immutable tags for a meter.
/**
 *  
        for (int i = 0; i < keys.length; i++) {  
    }
        }  
        int thisLength = a.keys.length;  
            sortedIndex += otherRemaining;
        for (int i = 0; i < keys.length; i++) {
    /**  
            sortedIndex += thisRemaining;
        Map.Entry<String, ?>[] entries = new Map.Entry[keys.length];
    public String getKey(int i) {  
        String[] keys = new String[count];
    // -----------------------------------------------------------------------
            Object val = rawValues[i];
     * @param keyValues alternating keys and values
        return new Tags(keys, values, computeHash(keys, values));
        for (int i = 0; i < count; i++) {
    public int hashCode() {
                mergedKeys[sortedIndex] = a.keys[thisIndex];  
@ExperimentalApi  
        }  
     * @return unmodifiable map of tags  
    /**
     * @param a first tags
    /**  
        Object[] v = { value };  
    /**
     * @param value tag value
            rawValues[j + 1] = val;  
        return new Tags(k, v, computeHash(k, v));  
    public static Tags of(String key, long value) {  
    @Override
    // -----------------------------------------------------------------------
            if (i > 0) sb.append(", ");
                mergedKeys[sortedIndex] = b.keys[otherIndex];
        }
     * @param value tag value
            keys[i] = Objects.requireNonNull(keyValues[i * 2], "key at index " + (i * 2) + " must not be null");
    }
     * @param value value  
        return EMPTY;  
                w++;
 */
    // -----------------------------------------------------------------------
     * Factory method.
     * @return new Tags instance
            System.arraycopy(b.keys, otherIndex, mergedKeys, sortedIndex, otherRemaining);
    private final int hashCode;
    public Map<String, ?> getTagsMap() {  
        return Tags.concat(this, Tags.of(key, value));
        Objects.requireNonNull(key, "key must not be null");
        Object[] mergedValues = new Object[thisLength + otherLength];  
     * @return empty tags  
     * Add long attribute.
            if (cmp < 0) {
        if (b == null || b.keys.length == 0) return a;
        }
                mergedValues[sortedIndex] = b.values[otherIndex];
        if (keys.length == 0) return Map.of();
        return new Tags(k, v, computeHash(k, v));
                rawValues[w] = rawValues[i];  
import org.opensearch.common.annotation.ExperimentalApi;
 * compatible open source license.
        this.keys = keys;
     * Returns the value at the given index.
     */
        return Tags.concat(this, Tags.of(key, value));  
     * @param key   tag key  
        this.values = values;
    /**  
    public Tags addTag(String key, double value) {
    /**
    }
            } else {
    public static Tags of(String key, boolean value) {
     */  
     * @return new Tags instance with the added tag  
            result = 31 * result + keys[i].hashCode();
        for (int i = 0; i < keys.length; i++) {  
    public Tags addTag(String key, long value) {  
 * @opensearch.experimental
     * @param key   tag key
     * Returns an unmodifiable map preserving original value types.
 * SPDX-License-Identifier: Apache-2.0
    }
     * @return new Tags instance with the added tag
    /**
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Tags addTag(String key, boolean value) {
    }
    // -----------------------------------------------------------------------
                j--;  
    // -----------------------------------------------------------------------  
        return Map.ofEntries(entries);  
     * @return new Tags instance  
    public int size() {  
        Objects.requireNonNull(key, "key cannot be null");
                mergedValues[sortedIndex] = a.values[thisIndex];
     * @return new Tags instance with the added tag
        for (int i = 1; i < count; i++) {
     * @return key
 * The OpenSearch Contributors require contributions made to  
    private static int computeHash(String[] keys, Object[] values) {
    }
    /**
    // equals / hashCode / toString
    private static Tags fromPairs(String[] rawKeys, Object[] rawValues, int count) {
     * @param value value  
     * @return new Tags instance with the added tag
    }
        String[] k = { key };
            } else if (cmp > 0) {  
    public static Tags create() {
import java.util.Map;
        String[] k = { key };  
        for (int i = 0; i < count; i++) {
        Arrays.sort(keys);
    public Object getValue(int i) {  
     * Creates an immutable Tags with one String-valued pair.
     */
        if (otherRemaining > 0) {
    // -----------------------------------------------------------------------  
        return keys.length;
    }
            System.arraycopy(b.values, otherIndex, mergedValues, sortedIndex, otherRemaining);  
     * Creates Tags from interleaved String key-value pairs; must be even length.
import java.util.Arrays;  
     * Add double attribute.  
        return new Tags(keys, values, computeHash(keys, values));
    }
        return fromPairs(keys, values, count);
    }
     */
        }
            rawKeys[j + 1] = key;
     * @return new Tags instance
    private static final String[] EMPTY_KEYS = new String[0];  
        Object[] values = new Object[keys.length];  
            values[i] = Objects.requireNonNull(keyValues[i * 2 + 1], "value at index " + (i * 2 + 1) + " must not be null");  
                rawKeys[j + 1] = rawKeys[j];
     * @param key   key
        Objects.requireNonNull(value, "value must not be null");  
     */
     * @return value
        Object[] v = { value };
            entries[i] = Map.entry(keys[i], values[i]);
    public static Tags of(String key, double value) {
     */
    private static final Object[] EMPTY_VALUES = new Object[0];
        Object[] values = new Object[count];  
     */  
     */
            values[i] = Objects.requireNonNull(map.get(keys[i]), "value for key '" + keys[i] + "' must not be null");
        String[] k = { key };
        return values[i];
        String[] keys = map.keySet().toArray(new String[0]);
        String[] keys = (sortedIndex == mergedKeys.length) ? mergedKeys : Arrays.copyOf(mergedKeys, sortedIndex);
     * Creates Tags from a map.
                thisIndex++;
     */  
                rawKeys[w] = rawKeys[i];
    public static Tags ofStringPairs(String... keyValues) {
        return Arrays.equals(keys, that.keys) && Arrays.equals(values, that.values);
        if (keyValues.length % 2 != 0) {
    /**
        if (thisRemaining > 0) {
package org.opensearch.telemetry.metrics.tags;
import java.util.Objects;
            System.arraycopy(a.keys, thisIndex, mergedKeys, sortedIndex, thisRemaining);
                thisIndex++;
    }
     * @param b second tags
     * @param key   tag key  
     * @param value tag value
                otherIndex++;  
        this.hashCode = hashCode;  
                otherIndex++;
        Objects.requireNonNull(key, "key must not be null");
        if (a == null || a.keys.length == 0) return (b != null) ? b : EMPTY;  
        return new Tags(keys, values, computeHash(keys, values));  
    public String toString() {  
    /**  
    private final Object[] values;  
    /**
        for (int i = 0; i < keys.length; i++) {  
        String[] k = { key };
     */
    }  
            int cmp = a.keys[thisIndex].compareTo(b.keys[otherIndex]);
        if (this.hashCode != that.hashCode) return false;
            }
}  
    public Tags addTag(String key, String value) {  
     * @param value tag value  
        return Tags.concat(this, Tags.of(key, value));  
                rawValues[j + 1] = rawValues[j];
        return new Tags(k, v, computeHash(k, v));
     * Add boolean attribute.
        StringBuilder sb = new StringBuilder("Tags{");
    // -----------------------------------------------------------------------  
     * @param map key-value pairs
        if (count == 0) return EMPTY;  
    // Factories
        return hashCode;  
    /**
    }
        Object[] v = { value };
    }
     * @return new Tags instance
            } else {
        if (!(o instanceof Tags that)) return false;  
        Objects.requireNonNull(key, "key cannot be null");  
        return result;
        Objects.requireNonNull(key, "key must not be null");
        Object[] values = (sortedIndex == mergedValues.length) ? mergedValues : Arrays.copyOf(mergedValues, sortedIndex);
        Object[] v = { value };
        }  
            }  
     * @return tag count
            sb.append(keys[i]).append('=').append(values[i]);
        Object[] values = (w == count) ? rawValues : Arrays.copyOf(rawValues, w);  
     * Creates an immutable Tags with one long-valued pair.
        return new Tags(k, v, computeHash(k, v));  
    }  
    /**  
        if (this == o) return true;
        }
            sortedIndex++;
    /** Insertion-sorts by key, deduplicates (last value wins). Mutates the provided arrays. */
     * @param key   key  
        Objects.requireNonNull(key, "key cannot be null");
     * Returns the key at the given index.
     * @return new Tags instance  
     * @param key   key
     */
     * Empty tags singleton.
        int result = 1;
        Objects.requireNonNull(key, "key must not be null");  
        if (map == null || map.isEmpty()) return EMPTY;  
 * this file be licensed under the Apache-2.0 license or a
    public static final Tags EMPTY = new Tags(EMPTY_KEYS, EMPTY_VALUES, 1);  
     */
    public static Tags concat(Tags a, Tags b) {
        return sb.append('}').toString();
     * Add String attribute.
     * @return merged Tags instance  
                mergedValues[sortedIndex] = b.values[otherIndex];  
        Objects.requireNonNull(value, "value cannot be null");
        }  
                mergedKeys[sortedIndex] = b.keys[otherIndex];
    private Tags(String[] keys, Object[] values, int hashCode) {  
    /**
     * @param value value
    }
        int thisIndex = 0, otherIndex = 0, sortedIndex = 0;
    public static Tags fromMap(Map<String, ?> map) {
    public static Tags of(String key, String value) {
            String key = rawKeys[i];  
 */  
        }
            if (w > 0 && rawKeys[w - 1].equals(rawKeys[i])) {
            System.arraycopy(a.values, thisIndex, mergedValues, sortedIndex, thisRemaining);  
        int w = 0;  
     */
        int thisRemaining = thisLength - thisIndex;  
     * @param i index  
public final class Tags {
                rawValues[w - 1] = rawValues[i];  
    }
    // Accessors
     */
     * @param key   key
     * Creates an immutable Tags with one boolean-valued pair.  
        return Tags.concat(this, Tags.of(key, value));
            while (j >= 0 && rawKeys[j].compareTo(key) > 0) {  
            throw new IllegalArgumentException("keyValues must be even length, got " + keyValues.length);
     */
        int otherLength = b.keys.length;
