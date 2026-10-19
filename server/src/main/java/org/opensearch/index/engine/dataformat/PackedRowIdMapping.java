    public int getGenerationSize(long generation) {
            }  
    }
    private PackedRowIdMapping(
    /**
            + mapping.ramBytesUsed()
     * @return estimated memory in bytes
        return reverseMapping.get((int) newId);
    }
import org.opensearch.common.annotation.ExperimentalApi;  
    /**
    }
     * @param oldId the original row ID within the generation
 *   <li>{@code generationOffsets} maps writer generation to starting offset in the array</li>
     * O(1) lookup via offset calculation.  
     * @param generation the writer generation
    }
     * @param newId the new row ID
    public int size() {
    public boolean isNewToOldSupported() {
     * @return the new row ID, or -1 if the generation or row ID is not found
     * @param mappingArray array where {@code mappingArray[oldRowId] = newRowId}
    /**  
     * @return the original row ID, or -1 if out of bounds
    public long getOldRowId(long newId) {  
 * not sorted. This ensures the mapping is independent of generation ordering.
        }
/*  
     * Returns an unmodifiable view of the generation sizes.
            this.reverseMapping = null;  
    public String toString() {
/**
    }
 * <p>Structure:
        if (size == null || oldId < 0 || oldId >= size) {
    private final PackedLongValues mapping;
    public long ramBytesUsed() {
        this.generationOffsets = Collections.unmodifiableMap(new HashMap<>(generationOffsets));
        this.reverseSupported = reverseSupported;
     *
    private final PackedLongValues reverseMapping;  
 *   generation 5 (2 rows): offset=0, mapping[0]=2, mapping[1]=3
     * Returns whether reverse lookup (getOldRowId / newToOld) is supported by this mapping.
    public PackedRowIdMapping(long[] mappingArray, Map<Long, Integer> generationOffsets, Map<Long, Integer> generationSizes) {  
     * @return map of writer generation to starting offset  
public final class PackedRowIdMapping implements RowIdMapping {  
    /**
     * @param generationSizes map of writer generation to number of rows in that generation
 * <ul>  
        return generationOffsets;  
 *   <li>A single flat packed array where {@code mapping[position] = newRowId}</li>
import java.util.Map;
        if (reverseMapping != null) {  
     */
        } else {
 * storage of row ID mappings produced during merge operations.  
 *   <li>{@code generationSizes} maps writer generation to number of rows in that generation</li>  
        for (long value : mappingArray) {
     * @param generationOffsets map of writer generation to starting offset in the mapping array  
                reverseBuilder.add(value);
    @Override  
    @Override  
     */
    private final Map<Long, Integer> generationOffsets;
    @Override  
        Integer size = generationSizes.get(oldGeneration);  
import java.util.Objects;
     * Returns the estimated memory usage of this mapping in bytes.  
 *
    @Override  
            this.reverseMapping = reverseBuilder.build();
            PackedLongValues.Builder reverseBuilder = PackedLongValues.packedBuilder(PackedInts.DEFAULT);  
 * </pre>
import org.apache.lucene.util.packed.PackedLongValues;
    /**
            return -1L;
    /**
 * <p>Offsets are assigned in the order generations are processed during the primary format's merge,  
    /**  
            forwardBuilder.add(value);  
}
     *  
    }
    }
            + '}';  
     *
     * @return map of writer generation to row count  
        Objects.requireNonNull(generationOffsets, "generationOffsets cannot be null");
            + generationOffsets.size()  
            long[] reverseArray = new long[mappingArray.length];
            bytes += reverseMapping.ramBytesUsed();
    ) {  
     * Creates a PackedRowIdMapping from a mapping array, generation offsets, and generation sizes.
            return -1L;
import java.util.Collections;
        this(mappingArray, Map.of(RowIdMapping.SINGLE_GEN, 0), Map.of(RowIdMapping.SINGLE_GEN, mappingArray.length), reverseSupported);  
     * @return true if reverse lookup is supported, false otherwise
        if (reverseSupported) {
        }
        Map<Long, Integer> generationOffsets,  
 *   generation 0 (3 rows): offset=2, mapping[2]=0, mapping[3]=4, mapping[4]=1  
     * Creates a PackedRowIdMapping for a single-generation flush sort permutation.  
    }  
 */  
            + "size="  
     * Returns the total number of entries in the mapping.
     * <p>This constructor is used for multi-generation merge mappings. Reverse lookup is not supported.  
        }  
     * If reverseSupported is true, builds the reverse (newToOld) mapping by inverting the permutation.  
 *
        PackedLongValues.Builder forwardBuilder = PackedLongValues.packedBuilder(PackedInts.DEFAULT);
        }  
        this.mapping = forwardBuilder.build();
    private final boolean reverseSupported;  
    }
                reverseArray[(int) mappingArray[i]] = i;
 */
    /**
        }  
     * Returns an unmodifiable view of the generation offsets.
        long[] mappingArray,
        boolean reverseSupported
 *   generation 3 (1 row):  offset=5, mapping[5]=5
        }
 * <pre>
        Objects.requireNonNull(generationSizes, "generationSizes cannot be null");  
 *
     * @param oldGeneration the writer generation of the source segment  
 * Compact implementation of {@link RowIdMapping} using Lucene's PackedLongValues for memory-efficient
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.util.packed.PackedInts;
     */
     * Returns the new row ID for the given old row ID and writer generation.
        return (int) mapping.size();
 * compatible open source license.
        long bytes = mapping.ramBytesUsed();
     * @return the total mapping size
 * The OpenSearch Contributors require contributions made to  
        this(mappingArray, generationOffsets, generationSizes, false);
    }
 * @opensearch.experimental  
     *
    public Map<Long, Integer> getGenerationOffsets() {
 * <p>Example: merge processes generations in order [5, 0, 3]:  
    public long getNewRowId(long oldId, long oldGeneration) {
     * @return the number of rows, or 0 if the generation is not found  
        Integer size = generationSizes.get(generation);  
     * Returns the old row ID for the given new row ID via reverse lookup.
 *
     */
            + ", generations="
        Integer offset = generationOffsets.get(oldGeneration);
     * @param reverseSupported whether to build the reverse mapping for newToOld lookups  
     *
        }
     *
        return reverseSupported;
    public Map<Long, Integer> getGenerationSizes() {
 * this file be licensed under the Apache-2.0 license or a
        return bytes;  
        if (reverseSupported == false) {
     */
            return -1L;
     * @param mappingArray array where index=position, value=newRowId
        return generationSizes;  
    }
@ExperimentalApi
 *   Lookup: newRowId = mapping.get(generationOffsets.get(generation) + oldRowId)  
        return mapping.get(offset + (int) oldId);
        this.generationSizes = Collections.unmodifiableMap(new HashMap<>(generationSizes));
        Objects.requireNonNull(mappingArray, "mappingArray cannot be null");
    private final Map<Long, Integer> generationSizes;
 * </ul>
    }  
    @Override
        if (offset == null) {  
import java.util.HashMap;  
            + mapping.size()
     */
    /**
     *
        return size != null ? size : 0;
    public PackedRowIdMapping(long[] mappingArray, boolean reverseSupported) {
     */
     *
            for (int i = 0; i < mappingArray.length; i++) {  
    /**  
     *  
        Map<Long, Integer> generationSizes,
            throw new UnsupportedOperationException("Reverse lookup (newToOld) is not supported by this mapping");
            + ", estimatedMemoryBytes="
     */
        if (newId < 0 || newId >= mapping.size()) {
     */  
     *  
        return "PackedRowIdMapping{"
     * @throws UnsupportedOperationException if reverse lookup is not supported  
     */
 *
            }
            for (long value : reverseArray) {
     *
     * <p>Sets generationOffsets to {SINGLE_GEN: 0} and generationSizes to {SINGLE_GEN: mappingArray.length}.
package org.opensearch.index.engine.dataformat;
 *
     * Returns the number of rows for a specific writer generation.  
     *
