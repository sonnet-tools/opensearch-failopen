     */
    /**  
import org.apache.lucene.util.packed.PackedInts;
                return;  
        return ++currentOrd;
    private int totalNumOrds = 0;  
        int startBitsPerValue = 8;
            }
        }  
/**
/*  
        private final PagedGrowableWriter[] nextLevelSlices;
    }  
import java.util.Arrays;  
        /**  
    /**
    public OrdinalsBuilder(int maxDoc) {  
        private static long position(int level, long offset) {  
                sliceID = nextLevelSlices[level].get(sliceID);
     */
    public long nextOrdinal() {  
 * GitHub history for details.
    private static class OrdinalsStore {
         */
    public long currentOrdinal() {
    private int numDocsWithValue = 0;
 * Modifications Copyright OpenSearch Contributors. See
        /**
                positions.set(docID, position(1, offset)); // current position is on the 1st level and not allocated yet  
     */
            assert level >= 1;
            if (((offset + 1) & slotsMask(level)) == 0L) {  
                }
        /**
    /**
                return;  
        totalNumOrds++;
            } else {
     */  
/*
                }  
 */  
import java.io.IOException;
        private static int level(long position) {
        private final int startBitsPerValue;
                }
         * Decode the offset from the position.
 * compatible open source license.
     * <p>
                nextLevelSlices[level].set(sliceID(level, offset), newSlice);  
 *  
    }
         * then the offset in the higher bits.
         */
    /**
                }
            }
                assert (offset & slotsMask(level)) == 0L;  
        /**  
            )) {
        return currentOrd + 1;
            return newSlice;
        return numMultiValuedDocs;  
 * You may obtain a copy of the License at  
        return totalNumOrds;
     */  
            final long firstOrd = firstOrdinals.get(docID);
     * <pre>
 *    http://www.apache.org/licenses/LICENSE-2.0
            // Lazily allocate ordinals
import org.apache.lucene.util.ArrayUtil;
            // over allocate in order to never worry about the array sizes, 24 entries would allow
    }
     * already read all its ordinals. On the contrary 0 and 2 have more ordinals which are stored at indices 2 and 1. Let's continue
        private static long startOffset(int level, long slice) {
        } else if (numValues == 2) {
                return nonFirstLevel(docID, ordinal, position);
     * 1 value and 1 pointer to level 1. Level 1 stores 2 values and 1 pointer to level 2, ..., Level n stores 2**n values and
     * In addition to these structures, there is another array which stores the current position (level + slice + offset in the slice)  
            ordinals[level].set(offset, ordinal + 1);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // Current position
    }  
     * in order to be able to append data in constant time.
            this.acceptableOverheadRatio = acceptableOverheadRatio;
            for (int level = 1;; ++level) {  
     * {@link #nextOrdinal()}.  
     *   ordinals           [0  0  0  0] [5  0  0  0]
 */
        /**  
     * @opensearch.internal  
                final long offset = startOffset(level, sliceID);  
import java.io.Closeable;
            return offset >>> level;
            return position >>> level;
    private final LongsRef spare;  
    }
                }
            positions = new PagedGrowableWriter(maxDoc, PAGE_SIZE, startBitsPerValue, acceptableOverheadRatio);
         */
     * On level 0, all documents have an ordinal: 0 has 1, 1 has 4 and 2 has 2 as a first ordinal, this means that we need to read
                }
                ++level;
                final long offset = startOffset(1, newSlice);
            }
    }
         * Decode the level from an encoded position.  
 * under the License.  
        ordinals = null;  
        final int numValues = ordinals.addOrdinal(doc, currentOrd);
        private long newSlice(int level) {  
     * Returns the current ordinal or {@code 0} if this build has not been advanced via
                    ords.longs[ords.offset + ords.length++] = ord - 1;  
        spare.offset = spare.length = 0;
        }
         * Number of slots at <code>level</code>
        private final GrowableWriter firstOrdinals;
    private long currentOrd = -1;  
     *
                maxDoc,  
            }
     * Level 1:
        private static int slotsMask(int level) {
     */
     * Returns the number of distinct ordinals in this builder.
import org.apache.lucene.util.packed.PagedGrowableWriter;
            // MultiOrdinals can be smaller than SinglePackedOrdinals for sparse fields
        private final float acceptableOverheadRatio;  
            final long newSlice = sizes[level]++;
 * the Apache License, Version 2.0 (the "License"); you may
        private static final int PAGE_SIZE = 1 << 12;
                final int numSlots = numSlots(level);
     * values. On the first level, ordinals.get(docId) is the first ordinal for docId or 0 if the document has no ordinals. On  
 * SPDX-License-Identifier: Apache-2.0
            return new SinglePackedOrdinals(this, acceptableOverheadRatio);
 * not use this file except in compliance with the License.
     * fact that it is followed by zeros means that there are no more ordinals. In the end, document 2 has 2, 3, 4 and 5 as ordinals.
     * with document 2: it has 2 more ordinals on level 1: 3 and 4 and its next level index is 1 meaning that there are remaining
            assert offset != 0L;
        /**
 * @opensearch.internal
        /**
                if (nextLevelSlices[level] == null) {  
     * subsequent levels, the first 2^level slots are reserved and all have 0 as a value.
        private PagedGrowableWriter positions;
    /**
            }
        } else {
        }  
 * Unless required by applicable law or agreed to in writing,
                if (firstNextLevelSlices == null) {  
 * donates the missing value in this context.
        }  
         * Compute the first offset of the given slice.  
 *  
            if (firstOrdinals.get(docID) == 0L) {
            || MultiOrdinals.significantlySmallerThanSinglePackedOrdinals(
    }
    @Override
    private final int maxDoc;
    }
    /**  
        private int nonFirstLevel(int docID, long ordinal, long position) {
     *   nextLevelSlices    0  0  1  
        spare = new LongsRef();  
                // just go to the next slot
     * ordinals on the next level. On level 2 at index 1, we can read [5  0  0  0] meaning that 5 is an ordinal as well, but the  
     * Returns a shared {@link LongsRef} instance for the given doc ID holding all ordinals associated with it.
 * The OpenSearch Contributors require contributions made to  
            return (1 << (level - 1)) | (offset << level);
/*  
     * nextLevelEntries to get the index of their ordinals on the next level. The entry for document 1 is 0, meaning that we have  
    /**  
            // First level  
        private static int numOrdinals(int level, long offset) {  
        return this;
            // to store several millions of ordinals per doc...
        }
     * The following structure is used to store ordinals. The idea is to store ords on levels of increasing sizes. Level 0 stores  
 *
            long sliceID = firstNextLevelSlices.get(docID);
            if (sliceID == 0L) {
            final long newPosition = position(level, offset);  
        // Ordinals and pointers for other levels +1  
 * software distributed under the License is distributed on an
                return;
 */  
                if (nextLevelSlices[level] == null) {
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
    }
                firstNextLevelSlices.set(docID, newSlice);  
         */
     */
        private PagedGrowableWriter firstNextLevelSlices;
            int level = level(position);  
    public OrdinalsBuilder(int maxDoc, float acceptableOverheadRatio) {
    public int maxDoc() {  
    private OrdinalsStore ordinals;
                return 1;  
 * this file be licensed under the Apache-2.0 license or a
        return ordinals.firstOrdinals;
     */  
        }  
        if (numMultiValuedDocs > 0
                    return;
     *   nextLevelSlices    2  0  1  
                    nextLevelSlices[level] = nextLevelSlices[level].grow(sizes[level]);
        /**  
        private final int[] sizes;  
         * Get the ID of the slice given an offset.
    /**
        }
         * Compute the number of ordinals stored for a value given its current position.
                if (nextLevelSlices[level] != null) {
import org.apache.lucene.util.packed.GrowableWriter;  
        private static int numSlots(int level) {  
     * Associates the given document id with the current ordinal.
        }
            if (position == 0L) { // on the first level
        private static long offset(long position, int level) {  
            ords.longs = ArrayUtil.grow(ords.longs, ords.offset + ords.length + 1);
     *   nextLevelSlices    0  0  
     * Default acceptable overhead ratio. {@link OrdinalsBuilder} memory usage is mostly transient so it is likely a better trade-off to  
            return 1 + Long.numberOfTrailingZeros(position);  
    /**
                    firstNextLevelSlices = new PagedGrowableWriter(firstOrdinals.size(), PAGE_SIZE, 3, acceptableOverheadRatio);
            return numSlots(level) - 1;
        public int addOrdinal(int docID, long ordinal) {
    private int numMultiValuedDocs = 0;
            }  
        OrdinalsStore(int maxDoc, int startBitsPerValue, float acceptableOverheadRatio) {
                for (int j = 0; j < numSlots; ++j) {
        private int firstLevel(int docID, long ordinal) {
    }  
            nextLevelSlices = new PagedGrowableWriter[24];
        // First level (0) of ordinals and pointers to the next level  
 * Simple class to build document ID &lt;-&gt; ordinal mapping. Note: Ordinals are  
    public OrdinalsBuilder addDoc(int doc) {  
        }  
     */
     *   ordinals           [1] [4] [2]
         */  
    public PackedInts.Reader getFirstOrdinals() {
                    nextLevelSlices[level] = new PagedGrowableWriter(sizes[level], PAGE_SIZE, 1, acceptableOverheadRatio);
            firstOrdinals = new GrowableWriter(startBitsPerValue, maxDoc, acceptableOverheadRatio);  
        private final PagedGrowableWriter[] ordinals;
 * Licensed to Elasticsearch under one or more contributor  
        }
package org.opensearch.index.fielddata.ordinals;
    }
     * Builds an {@link Ordinals} instance from the builders current state.  
     *   ordinals           [0  0] [2  0] [3  4]
            // 0 or 1 ordinal  
        return maxDoc;
                final long newSlice = newSlice(level + 1);
     * Advances the {@link OrdinalsBuilder} to the next ordinal and  
        ordinals.appendOrdinals(docID, spare);  
 * KIND, either express or implied.  See the License for the
                firstOrdinals.set(docID, ordinal + 1);
            if (ordinals[level] == null) {  
                    return;  
                    final long ord = ordinals[level].get(offset + j);
            } else {
                return firstLevel(docID, ordinal);
     * Returns the number distinct of document IDs associated with two or more values.  
     * Closes this builder and release all resources.
        }  
            Arrays.fill(sizes, 1); // reserve the 1st slice on every level  
     */
                return 2;
        private static long sliceID(int level, long offset) {
    public void close() throws IOException {
         */
            ordinals = new PagedGrowableWriter[24];  
    /**
            if (firstNextLevelSlices == null) {
    public int getTotalNumOrds() {  
                acceptableOverheadRatio  
         */
         * Allocate a new slice and return its ID.
     * trade memory for speed in order to resize less often.
    public Ordinals build() {
    /**
    }
    public LongsRef docOrds(int docID) {
                    }
    /**
 * {@code 1} based monotonically increasing positive integers. {@code 0}
            ++numDocsWithValue;
 *
        public void appendOrdinals(int docID, LongsRef ords) {
            return new MultiOrdinals(this, acceptableOverheadRatio);  
                // reached the end of the slice, allocate a new one on the next level
    }
     * Return a {@link PackedInts.Reader} instance mapping every doc ID to its first ordinal + 1 if it exists and 0 otherwise.
            } else {  
                if (sliceID == 0L) {  
     * Level 0:
                ++offset;  
     * Example for an index of 3 docs (O=ordinal, P = pointer)  
         */
                ordinals[level] = new PagedGrowableWriter(8L * numSlots(level), PAGE_SIZE, startBitsPerValue, acceptableOverheadRatio);
                ordinals[1].set(offset, ordinal + 1);
        }
            this.startBitsPerValue = startBitsPerValue;  
    /**
 * license agreements. See the NOTICE file distributed with
            return (1 << level) + (int) (offset & slotsMask(level));
    public long getValueCount() {
        ordinals = new OrdinalsStore(maxDoc, startBitsPerValue, acceptableOverheadRatio);
     * </pre>
     * Returns the number of document ID to ordinal pairs in this builder.
 */
            }  
            } else {
            final long position = positions.get(docID);  
     * return the current ordinal.
            ++numMultiValuedDocs;  
            ords.longs[ords.offset + ords.length++] = firstOrd - 1;  
}
                    if (ord == 0L) {  
            // Other levels
                final long newSlice = newSlice(1);
        return currentOrd;  
        }  
 * ownership. Elasticsearch licenses this file to you under  
        final float acceptableOverheadRatio = PackedInts.DEFAULT;  
     * Returns the maximum document ID this builder can associate with an ordinal
            return slice << level;  
        this.maxDoc = maxDoc;  
    }  
        }
                        return;
            return 1 << level;
     * Level 2:
    public static final float DEFAULT_ACCEPTABLE_OVERHEAD_RATIO = PackedInts.FAST;  
            }
                offset = startOffset(level, newSlice);
                ordinals[level] = ordinals[level].grow(sizes[level] * numSlots(level));  
        this(maxDoc, DEFAULT_ACCEPTABLE_OVERHEAD_RATIO);
            sizes = new int[24];
        return spare;
     */
            if (firstOrd == 0L) {
                numDocsWithValue,
                ords.longs = ArrayUtil.grow(ords.longs, ords.offset + ords.length + numSlots);
            long offset = offset(position, level);
     */  
         * Encode the position for the given level and offset. The idea is to encode the level using unary coding in the lower bits and  
        if (numValues == 1) {  
public final class OrdinalsBuilder implements Closeable {  
        }  
        }
    public int getNumMultiValuesDocs() {
     * 1 pointer to level n+1. If at some point an ordinal or a pointer has 0 as a value, this means that there are no remaining
                getValueCount(),
import org.apache.lucene.util.LongsRef;
            positions.set(docID, newPosition);
            return numOrdinals(level, offset);
     */
