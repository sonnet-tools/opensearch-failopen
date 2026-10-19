        for (int i = 0; i < keys.length; i++) {
 *
    }
            if (i > 0) sb.append(", ");
            values[i] = Objects.requireNonNull(map.get(keys[i]), "value for key '" + keys[i] + "' must not be null");
    public int hashCode() {
     * @param key   key
            }
            int cmp = a.keys[thisIndex].compareTo(b.keys[otherIndex]);
     * @return tag count
        Objects.requireNonNull(key, "key must not be null");
import java.util.Objects;
                rawValues[w] = rawValues[i];
    // -----------------------------------------------------------------------
    // equals / hashCode / toString
     * @return new Tags instance with the added tag
    /**
        Object[] v = { value };
        Object[] v = { value };
    private static final Object[] EMPTY_VALUES = new Object[0];
        }
        return new Tags(k, v, computeHash(k, v));
    }
     * @return new Tags instance
    /**
                mergedKeys[sortedIndex] = b.keys[otherIndex];
}
    /**
     */
     */
        }
        if (keys.length == 0) return "Tags{}";
        return Tags.concat(this, Tags.of(key, value));
import org.opensearch.common.annotation.ExperimentalApi;
     * Creates Tags from interleaved String key-value pairs; must be even length.
        return new Tags(k, v, computeHash(k, v));
        String[] mergedKeys = new String[thisLength + otherLength];
    public int size() {
    /**
        }
        int result = 1;
     */
    public Map<String, ?> getTagsMap() {
    // Accessors
     * @return new Tags instance
        Objects.requireNonNull(key, "key cannot be null");
     * @param value value
    /**
     * Returns the value at the given index.
     * @return new Tags instance with the added tag
     * @param value tag value
            }
                mergedValues[sortedIndex] = b.values[otherIndex];
 */
    public boolean equals(Object o) {
     * @param i index
        if (!(o instanceof Tags that)) return false;
     * @return unmodifiable map of tags
/**
    /**
    private final Object[] values;
    public static Tags of(String key, String value) {
    private static int computeHash(String[] keys, Object[] values) {
        Map.Entry<String, ?>[] entries = new Map.Entry[keys.length];
     * @return new Tags instance
                thisIndex++;
                rawKeys[j + 1] = rawKeys[j];
    /**
     * @param value value
    }
        return EMPTY;
        return sb.append('}').toString();
     * @return key
        Object[] mergedValues = new Object[thisLength + otherLength];
     * @return merged Tags instance
        }
            String key = rawKeys[i];
    }
            rawKeys[j + 1] = key;
    /**
                otherIndex++;
    }
     * @param key   tag key
        return keys[i];
public final class Tags {
                rawValues[w - 1] = rawValues[i];
            keys[i] = Objects.requireNonNull(keyValues[i * 2], "key at index " + (i * 2) + " must not be null");
    }
     * @param i index
    public static Tags of(String key, double value) {
            values[i] = Objects.requireNonNull(keyValues[i * 2 + 1], "value at index " + (i * 2 + 1) + " must not be null");
        return new Tags(keys, values, computeHash(keys, values));
            sb.append(keys[i]).append('=').append(values[i]);
    }
        Objects.requireNonNull(key, "key must not be null");
     */
        return new Tags(k, v, computeHash(k, v));
        Objects.requireNonNull(value, "value must not be null");
     * Returns an unmodifiable map preserving original value types.
            System.arraycopy(b.keys, otherIndex, mergedKeys, sortedIndex, otherRemaining);
                j--;
            result = 31 * result + values[i].hashCode();
    }
     * @param a first tags
     */
    /**
        while (thisIndex < thisLength && otherIndex < otherLength) {
        }
     */
                mergedValues[sortedIndex] = b.values[otherIndex];
    }
                thisIndex++;
            System.arraycopy(a.values, thisIndex, mergedValues, sortedIndex, thisRemaining);
        if (thisRemaining > 0) {
    }
     * Empty tags singleton.
            }
     * @param key   key
 *
    }
    // -----------------------------------------------------------------------
        for (int i = 0; i < count; i++) {
     */
     */
        }
    public static Tags fromMap(Map<String, ?> map) {
        Arrays.sort(keys);
 * Immutable tags for a meter.
    public static Tags of(String key, boolean value) {
        return new Tags(keys, values, computeHash(keys, values));
     * @return new Tags instance
        String[] k = { key };
import java.util.Map;
     * Merges two Tags. On key collision, {@code b} wins. Either argument may be null.
        String[] keys = (sortedIndex == mergedKeys.length) ? mergedKeys : Arrays.copyOf(mergedKeys, sortedIndex);
            sortedIndex += thisRemaining;
                rawKeys[w] = rawKeys[i];
    public Tags addTag(String key, double value) {
        if (this == o) return true;
            System.arraycopy(b.values, otherIndex, mergedValues, sortedIndex, otherRemaining);
     */
    public static Tags concat(Tags a, Tags b) {
     * Creates an immutable Tags with one double-valued pair.
        Object[] values = new Object[count];
        int otherLength = b.keys.length;
                rawValues[j + 1] = rawValues[j];
            sortedIndex += otherRemaining;
        return Map.ofEntries(entries);
     * Returns the key at the given index.
     * @param value value
        return keys.length;
            throw new IllegalArgumentException("keyValues must be even length, got " + keyValues.length);
        Object[] v = { value };
    // -----------------------------------------------------------------------
                mergedKeys[sortedIndex] = b.keys[otherIndex];
        return Tags.concat(this, Tags.of(key, value));
        if (keyValues == null || keyValues.length == 0) return EMPTY;
     * @param value tag value
        }
        int thisLength = a.keys.length;
     * @return new Tags instance with the added tag
     */
        String[] keys = (w == count) ? rawKeys : Arrays.copyOf(rawKeys, w);
     */
     * @param b second tags
        this.hashCode = hashCode;
        return new Tags(k, v, computeHash(k, v));
     */
    private Tags(String[] keys, Object[] values, int hashCode) {
                w++;
    public static Tags of(String key, long value) {
    }
    /** Insertion-sorts by key, deduplicates (last value wins). Mutates the provided arrays. */
    public Tags addTag(String key, long value) {
    public static final Tags EMPTY = new Tags(EMPTY_KEYS, EMPTY_VALUES, 1);
                mergedKeys[sortedIndex] = a.keys[thisIndex];
    }
     * Creates Tags from a map.
    }
        if (otherRemaining > 0) {
    /**
            int j = i - 1;
     * @param key   tag key
    public Object getValue(int i) {
            System.arraycopy(a.keys, thisIndex, mergedKeys, sortedIndex, thisRemaining);
    public static Tags ofStringPairs(String... keyValues) {
    private final int hashCode;
        return result;
    }
        Objects.requireNonNull(key, "key cannot be null");
 * SPDX-License-Identifier: Apache-2.0
            } else if (cmp > 0) {
    // -----------------------------------------------------------------------
    /**
     * @param value value
        }
     * @return new Tags instance
        this.values = values;
    @Override
     * @return new Tags instance
        Object[] values = (sortedIndex == mergedValues.length) ? mergedValues : Arrays.copyOf(mergedValues, sortedIndex);
            while (j >= 0 && rawKeys[j].compareTo(key) > 0) {
        Objects.requireNonNull(key, "key must not be null");
            if (cmp < 0) {
                otherIndex++;
        int w = 0;
        if (a == null || a.keys.length == 0) return (b != null) ? b : EMPTY;
     * Add long attribute.
        Object[] values = new Object[keys.length];
     * @param value tag value
        int thisIndex = 0, otherIndex = 0, sortedIndex = 0;
        return Arrays.equals(keys, that.keys) && Arrays.equals(values, that.values);
     * @param keyValues alternating keys and values
    // -----------------------------------------------------------------------
        if (map == null || map.isEmpty()) return EMPTY;
     */
        return fromPairs(keys, values, count);
    @Override
        return Tags.concat(this, Tags.of(key, value));
    /**
    // -----------------------------------------------------------------------
        if (this.hashCode != that.hashCode) return false;
        this.keys = keys;
        StringBuilder sb = new StringBuilder("Tags{");
    }
        return hashCode;
        Objects.requireNonNull(key, "key must not be null");
 * @opensearch.experimental
    @SuppressWarnings({ "unchecked", "rawtypes" })
    // Factories
        int otherRemaining = otherLength - otherIndex;
        if (b == null || b.keys.length == 0) return a;
            sortedIndex++;
 * The OpenSearch Contributors require contributions made to
     * @return new Tags instance with the added tag
        Objects.requireNonNull(key, "key cannot be null");
    public String getKey(int i) {
    }
     * @param map key-value pairs
        return Tags.concat(this, Tags.of(key, value));
        int thisRemaining = thisLength - thisIndex;
        for (int i = 0; i < keys.length; i++) {
    // -----------------------------------------------------------------------
@ExperimentalApi
        for (int i = 0; i < keys.length; i++) {
    /**
    public Tags addTag(String key, String value) {
                mergedValues[sortedIndex] = a.values[thisIndex];
        int count = keyValues.length / 2;
        for (int i = 0; i < count; i++) {
            result = 31 * result + keys[i].hashCode();
     */
        String[] keys = map.keySet().toArray(new String[0]);
    /**
            } else {
            if (w > 0 && rawKeys[w - 1].equals(rawKeys[i])) {
        if (keys.length == 0) return Map.of();
    public Tags addTag(String key, boolean value) {
        Object[] v = { value };
    /**
package org.opensearch.telemetry.metrics.tags;
    // -----------------------------------------------------------------------
    private static final String[] EMPTY_KEYS = new String[0];
     */
/*
     * Creates an immutable Tags with one String-valued pair.
    /**
            rawValues[j + 1] = val;
     * Returns the number of tags.
     */
        }
    private final String[] keys;
        if (count == 0) return EMPTY;
     * Add String attribute.
        return values[i];
     * @param value tag value
import java.util.Arrays;
        Objects.requireNonNull(value, "value cannot be null");
 * compatible open source license.
     * Add double attribute.
    @Override
     * Creates an immutable Tags with one boolean-valued pair.
        return new Tags(keys, values, computeHash(keys, values));
        String[] k = { key };
        if (keyValues.length % 2 != 0) {
     * @param key   key
        for (int i = 0; i < keys.length; i++) {
    public String toString() {
     * Creates an immutable Tags with one long-valued pair.
    // Internal
        Objects.requireNonNull(key, "key cannot be null");
        }
    }
    }
            Object val = rawValues[i];
     * @return value
    }
        String[] k = { key };
     */
     * Factory method.
 * this file be licensed under the Apache-2.0 license or a
     * @param key   tag key
    /**
            entries[i] = Map.entry(keys[i], values[i]);
    }
     * @return empty tags
     * @param key   tag key
        String[] k = { key };
        String[] keys = new String[count];
        }
        for (int i = 1; i < count; i++) {
     * Add boolean attribute.
     * @param key   key
    private static Tags fromPairs(String[] rawKeys, Object[] rawValues, int count) {
            } else {
    }
    public static Tags create() {
        Object[] values = (w == count) ? rawValues : Arrays.copyOf(rawValues, w);
 */
