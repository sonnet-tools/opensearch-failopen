     * O(1) lookup via offset calculation.
    /**
import java.util.HashMap;
     * @return true if reverse lookup is supported, false otherwise
        Objects.requireNonNull(generationOffsets, "generationOffsets cannot be null");
     *
        return "PackedRowIdMapping{"
     */
        return reverseMapping.get((int) newId);
    @Override
     * Returns whether reverse lookup (getOldRowId / newToOld) is supported by this mapping.
        }
    }
 *   <li>{@code generationOffsets} maps writer generation to starting offset in the array</li>
        this.reverseSupported = reverseSupported;
            long[] reverseArray = new long[mappingArray.length];
        this(mappingArray, Map.of(RowIdMapping.SINGLE_GEN, 0), Map.of(RowIdMapping.SINGLE_GEN, mappingArray.length), reverseSupported);
        return generationOffsets;
     *
    public long getOldRowId(long newId) {
        return size != null ? size : 0;
        if (newId < 0 || newId >= mapping.size()) {
 * </ul>
    /**
 * storage of row ID mappings produced during merge operations.
            return -1L;
            PackedLongValues.Builder reverseBuilder = PackedLongValues.packedBuilder(PackedInts.DEFAULT);
 *   generation 0 (3 rows): offset=2, mapping[2]=0, mapping[3]=4, mapping[4]=1
     * Creates a PackedRowIdMapping for a single-generation flush sort permutation.
import org.apache.lucene.util.packed.PackedLongValues;
    }
     * @param mappingArray array where index=position, value=newRowId
    public String toString() {
        Map<Long, Integer> generationSizes,
    private final PackedLongValues reverseMapping;
import org.opensearch.common.annotation.ExperimentalApi;
public final class PackedRowIdMapping implements RowIdMapping {
        Map<Long, Integer> generationOffsets,
     * @param oldId the original row ID within the generation
    @Override
package org.opensearch.index.engine.dataformat;
     *
 *
    }
        long[] mappingArray,
     * @throws UnsupportedOperationException if reverse lookup is not supported
     * Returns an unmodifiable view of the generation offsets.
                reverseArray[(int) mappingArray[i]] = i;
 */
     * Returns the number of rows for a specific writer generation.
     * @return the total mapping size
            bytes += reverseMapping.ramBytesUsed();
}
     * <p>Sets generationOffsets to {SINGLE_GEN: 0} and generationSizes to {SINGLE_GEN: mappingArray.length}.
            + mapping.ramBytesUsed()
     * Returns an unmodifiable view of the generation sizes.
    @Override
 *   Lookup: newRowId = mapping.get(generationOffsets.get(generation) + oldRowId)
 *   <li>{@code generationSizes} maps writer generation to number of rows in that generation</li>
        }
 * Compact implementation of {@link RowIdMapping} using Lucene's PackedLongValues for memory-efficient
    private final PackedLongValues mapping;
            this.reverseMapping = null;
     */
    public boolean isNewToOldSupported() {
     * Returns the new row ID for the given old row ID and writer generation.
        this.mapping = forwardBuilder.build();
        if (reverseSupported == false) {
            + "size="
    /**
     * @return estimated memory in bytes
    private final Map<Long, Integer> generationSizes;
import java.util.Collections;
        }
     * @return the new row ID, or -1 if the generation or row ID is not found
import org.apache.lucene.util.packed.PackedInts;
    public int getGenerationSize(long generation) {
     *
    }
            for (int i = 0; i < mappingArray.length; i++) {
            + generationOffsets.size()
     * @return map of writer generation to row count
            for (long value : reverseArray) {
     *
    }
    public PackedRowIdMapping(long[] mappingArray, boolean reverseSupported) {
    /**
 *   <li>A single flat packed array where {@code mapping[position] = newRowId}</li>
        for (long value : mappingArray) {
    }
@ExperimentalApi
     */
            forwardBuilder.add(value);
            throw new UnsupportedOperationException("Reverse lookup (newToOld) is not supported by this mapping");
     * @param generation the writer generation
     */
 * not sorted. This ensures the mapping is independent of generation ordering.
 *
     */
 * <p>Structure:
 * The OpenSearch Contributors require contributions made to
     * @param generationSizes map of writer generation to number of rows in that generation
    }
            + mapping.size()
    private final boolean reverseSupported;
    public Map<Long, Integer> getGenerationOffsets() {
        }
            + ", estimatedMemoryBytes="
    /**
        }
 *
 * <p>Example: merge processes generations in order [5, 0, 3]:
            return -1L;
        } else {
        return (int) mapping.size();
    }
        if (offset == null) {
    private final Map<Long, Integer> generationOffsets;
     * <p>This constructor is used for multi-generation merge mappings. Reverse lookup is not supported.
        if (reverseSupported) {
     *
        }
    /**
    public Map<Long, Integer> getGenerationSizes() {
     * @return the original row ID, or -1 if out of bounds
    /**
 * <pre>
        long bytes = mapping.ramBytesUsed();
     * @param generationOffsets map of writer generation to starting offset in the mapping array
     * @param newId the new row ID
            this.reverseMapping = reverseBuilder.build();
            return -1L;
            }
     * @param reverseSupported whether to build the reverse mapping for newToOld lookups
     * Creates a PackedRowIdMapping from a mapping array, generation offsets, and generation sizes.
 * this file be licensed under the Apache-2.0 license or a
    }
        return mapping.get(offset + (int) oldId);
import java.util.Map;
        boolean reverseSupported
/**
    }
        Integer size = generationSizes.get(generation);
 *
        PackedLongValues.Builder forwardBuilder = PackedLongValues.packedBuilder(PackedInts.DEFAULT);
     *
    /**
        Objects.requireNonNull(mappingArray, "mappingArray cannot be null");
        return bytes;
    public long getNewRowId(long oldId, long oldGeneration) {
        }
 * <p>Offsets are assigned in the order generations are processed during the primary format's merge,
        Objects.requireNonNull(generationSizes, "generationSizes cannot be null");
    ) {
 *
     *
    /**
     * If reverseSupported is true, builds the reverse (newToOld) mapping by inverting the permutation.
        return generationSizes;
 * </pre>
 * SPDX-License-Identifier: Apache-2.0
    @Override
     */
        if (reverseMapping != null) {
    public long ramBytesUsed() {
     * @param oldGeneration the writer generation of the source segment
    @Override
            + '}';
/*
     */
                reverseBuilder.add(value);
        this.generationSizes = Collections.unmodifiableMap(new HashMap<>(generationSizes));
     * Returns the old row ID for the given new row ID via reverse lookup.
     *
import java.util.Objects;
 *   generation 3 (1 row):  offset=5, mapping[5]=5
 * @opensearch.experimental
 */
        Integer offset = generationOffsets.get(oldGeneration);
            }
        Integer size = generationSizes.get(oldGeneration);
     *
     *
 * compatible open source license.
 *
     * @param mappingArray array where {@code mappingArray[oldRowId] = newRowId}
 * <ul>
    private PackedRowIdMapping(
     * Returns the total number of entries in the mapping.
        if (size == null || oldId < 0 || oldId >= size) {
    public int size() {
     */
    }
        return reverseSupported;
        this(mappingArray, generationOffsets, generationSizes, false);
     * Returns the estimated memory usage of this mapping in bytes.
     * @return the number of rows, or 0 if the generation is not found
            + ", generations="
    /**
        this.generationOffsets = Collections.unmodifiableMap(new HashMap<>(generationOffsets));
 *   generation 5 (2 rows): offset=0, mapping[0]=2, mapping[1]=3
     */
     *
     */
    }
     * @return map of writer generation to starting offset
    public PackedRowIdMapping(long[] mappingArray, Map<Long, Integer> generationOffsets, Map<Long, Integer> generationSizes) {
