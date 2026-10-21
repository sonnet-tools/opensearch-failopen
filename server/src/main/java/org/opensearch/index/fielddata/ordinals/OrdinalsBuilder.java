                if (nextLevelSlices[level] == null) {
                firstNextLevelSlices.set(docID, newSlice);
                offset = startOffset(level, newSlice);
package org.opensearch.index.fielddata.ordinals;
            ++numDocsWithValue;
            return 1 + Long.numberOfTrailingZeros(position);
    }
 * donates the missing value in this context.
     * already read all its ordinals. On the contrary 0 and 2 have more ordinals which are stored at indices 2 and 1. Let's continue
    }
        private final GrowableWriter firstOrdinals;
     * Example for an index of 3 docs (O=ordinal, P = pointer)
        spare = new LongsRef();
     * Associates the given document id with the current ordinal.
    private OrdinalsStore ordinals;
    public long nextOrdinal() {
        public void appendOrdinals(int docID, LongsRef ords) {
import java.io.IOException;
        }
        private static final int PAGE_SIZE = 1 << 12;
        }
                }
        // First level (0) of ordinals and pointers to the next level
     */
    }
                ordinals[level] = new PagedGrowableWriter(8L * numSlots(level), PAGE_SIZE, startBitsPerValue, acceptableOverheadRatio);
     * trade memory for speed in order to resize less often.
        private final PagedGrowableWriter[] ordinals;
         * Allocate a new slice and return its ID.
     * Returns the number distinct of document IDs associated with two or more values.
            || MultiOrdinals.significantlySmallerThanSinglePackedOrdinals(
 */
    /**
            final long newSlice = sizes[level]++;
                for (int j = 0; j < numSlots; ++j) {
         */
            if (position == 0L) { // on the first level
                return;
            // to store several millions of ordinals per doc...
        /**
            assert level >= 1;
                if (sliceID == 0L) {
            firstOrdinals = new GrowableWriter(startBitsPerValue, maxDoc, acceptableOverheadRatio);
                }
     * <pre>
    /**
        private final PagedGrowableWriter[] nextLevelSlices;
        final float acceptableOverheadRatio = PackedInts.DEFAULT;
    }
    /**
        final int numValues = ordinals.addOrdinal(doc, currentOrd);
                ords.longs = ArrayUtil.grow(ords.longs, ords.offset + ords.length + numSlots);
 *
}
                final long offset = startOffset(level, sliceID);
 * the Apache License, Version 2.0 (the "License"); you may
     */
     */
    private final int maxDoc;
        }
                return firstLevel(docID, ordinal);
         */
                }
        private static long sliceID(int level, long offset) {
            positions.set(docID, newPosition);
        }
            final long position = positions.get(docID);
     * Returns the number of distinct ordinals in this builder.
     * subsequent levels, the first 2^level slots are reserved and all have 0 as a value.
     * Closes this builder and release all resources.
                ordinals[level] = ordinals[level].grow(sizes[level] * numSlots(level));
                    return;
    }
         * then the offset in the higher bits.
        private final int startBitsPerValue;
            // Lazily allocate ordinals
/*
        ordinals.appendOrdinals(docID, spare);
     * The following structure is used to store ordinals. The idea is to store ords on levels of increasing sizes. Level 0 stores
        this.maxDoc = maxDoc;
    /**
                if (nextLevelSlices[level] == null) {
public final class OrdinalsBuilder implements Closeable {
        private final int[] sizes;
        return spare;
    public void close() throws IOException {
     * in order to be able to append data in constant time.
        }
            this.acceptableOverheadRatio = acceptableOverheadRatio;
        private PagedGrowableWriter positions;
            ordinals[level].set(offset, ordinal + 1);
                ++offset;
                nextLevelSlices[level].set(sliceID(level, offset), newSlice);
     * {@link #nextOrdinal()}.
import org.apache.lucene.util.packed.PagedGrowableWriter;
            }
     */
 * SPDX-License-Identifier: Apache-2.0
        }
     * On level 0, all documents have an ordinal: 0 has 1, 1 has 4 and 2 has 2 as a first ordinal, this means that we need to read
     */
                final long newSlice = newSlice(level + 1);
    private long currentOrd = -1;
            }
     * </pre>
         */
                return 2;
    public int getTotalNumOrds() {
     * Builds an {@link Ordinals} instance from the builders current state.
            // 0 or 1 ordinal
    }
    /**
     */
 * Licensed to Elasticsearch under one or more contributor
    public long currentOrdinal() {
            // Other levels
            final long firstOrd = firstOrdinals.get(docID);
     * 1 value and 1 pointer to level 1. Level 1 stores 2 values and 1 pointer to level 2, ..., Level n stores 2**n values and
        return ++currentOrd;
     * with document 2: it has 2 more ordinals on level 1: 3 and 4 and its next level index is 1 meaning that there are remaining
        /**
        }
        private static int slotsMask(int level) {
 * Unless required by applicable law or agreed to in writing,
        }
 * {@code 1} based monotonically increasing positive integers. {@code 0}
                    final long ord = ordinals[level].get(offset + j);
            return newSlice;
     * Return a {@link PackedInts.Reader} instance mapping every doc ID to its first ordinal + 1 if it exists and 0 otherwise.
        private long newSlice(int level) {
     * nextLevelEntries to get the index of their ordinals on the next level. The entry for document 1 is 0, meaning that we have
import java.util.Arrays;
        if (numValues == 1) {
         */
            if (ordinals[level] == null) {
        }
        return currentOrd + 1;
        return ordinals.firstOrdinals;
 *
            }
    private final LongsRef spare;
            if (sliceID == 0L) {
 * KIND, either express or implied.  See the License for the
        ordinals = null;
    /**
            long offset = offset(position, level);
        return currentOrd;
                return;
                final long offset = startOffset(1, newSlice);
            // over allocate in order to never worry about the array sizes, 24 entries would allow
    public int getNumMultiValuesDocs() {
     * @opensearch.internal
 * license agreements. See the NOTICE file distributed with
         * Compute the first offset of the given slice.
     * fact that it is followed by zeros means that there are no more ordinals. In the end, document 2 has 2, 3, 4 and 5 as ordinals.
                acceptableOverheadRatio
            return numOrdinals(level, offset);
        /**
            return offset >>> level;
 *
        private static long offset(long position, int level) {
            if (firstOrd == 0L) {
    /**
                    firstNextLevelSlices = new PagedGrowableWriter(firstOrdinals.size(), PAGE_SIZE, 3, acceptableOverheadRatio);
                final long newSlice = newSlice(1);
    public PackedInts.Reader getFirstOrdinals() {
 */
                ++level;
        return maxDoc;
                if (nextLevelSlices[level] != null) {
        }
                if (firstNextLevelSlices == null) {
        }
     */
                    }
 * Modifications Copyright OpenSearch Contributors. See
     *   nextLevelSlices    0  0  1
                    return;
     *   nextLevelSlices    2  0  1
 * ownership. Elasticsearch licenses this file to you under
                // just go to the next slot
        ordinals = new OrdinalsStore(maxDoc, startBitsPerValue, acceptableOverheadRatio);
     *   ordinals           [1] [4] [2]
                }
            return new MultiOrdinals(this, acceptableOverheadRatio);
        }
        private static int numOrdinals(int level, long offset) {
import org.apache.lucene.util.packed.GrowableWriter;
            assert offset != 0L;
/*
            // First level
    }
    private int totalNumOrds = 0;
                        return;
            }
            int level = level(position);
     *   ordinals           [0  0] [2  0] [3  4]
     * values. On the first level, ordinals.get(docId) is the first ordinal for docId or 0 if the document has no ordinals. On
     */
    }
    public long getValueCount() {
         */
    /**
import java.io.Closeable;
    private static class OrdinalsStore {
            ordinals = new PagedGrowableWriter[24];
 * Simple class to build document ID &lt;-&gt; ordinal mapping. Note: Ordinals are
     * Returns the maximum document ID this builder can associate with an ordinal
        private static int numSlots(int level) {
 * The OpenSearch Contributors require contributions made to
import org.apache.lucene.util.ArrayUtil;
            }
            long sliceID = firstNextLevelSlices.get(docID);
        private static long position(int level, long offset) {
    /**
    /**
         * Decode the offset from the position.
         * Encode the position for the given level and offset. The idea is to encode the level using unary coding in the lower bits and
    public int maxDoc() {
        }
                firstOrdinals.set(docID, ordinal + 1);
    public static final float DEFAULT_ACCEPTABLE_OVERHEAD_RATIO = PackedInts.FAST;
 * @opensearch.internal
    }
 * specific language governing permissions and limitations
     *
        }
                    ords.longs[ords.offset + ords.length++] = ord - 1;
        /**
     * Level 1:
                    if (ord == 0L) {
                ordinals[1].set(offset, ordinal + 1);
        }
         */
                return 1;
    }
    public OrdinalsBuilder(int maxDoc) {
 * under the License.
         */
    }
/**
 * GitHub history for details.
            return (1 << (level - 1)) | (offset << level);
            ords.longs = ArrayUtil.grow(ords.longs, ords.offset + ords.length + 1);
 */
         * Decode the level from an encoded position.
            }
                final int numSlots = numSlots(level);
     * In addition to these structures, there is another array which stores the current position (level + slice + offset in the slice)
        // Ordinals and pointers for other levels +1
        public int addOrdinal(int docID, long ordinal) {
        /**
            final long newPosition = position(level, offset);
        }
 * this work for additional information regarding copyright
    }
            } else {
        return totalNumOrds;
     * Level 0:
            for (int level = 1;; ++level) {
                    nextLevelSlices[level] = nextLevelSlices[level].grow(sizes[level]);
    @Override
                    nextLevelSlices[level] = new PagedGrowableWriter(sizes[level], PAGE_SIZE, 1, acceptableOverheadRatio);
     * Advances the {@link OrdinalsBuilder} to the next ordinal and
     * Level 2:
        return this;
                maxDoc,
        } else {
    }
            sizes = new int[24];
         */
     */
     * 1 pointer to level n+1. If at some point an ordinal or a pointer has 0 as a value, this means that there are no remaining
        return numMultiValuedDocs;
 * compatible open source license.
            Arrays.fill(sizes, 1); // reserve the 1st slice on every level
     * Default acceptable overhead ratio. {@link OrdinalsBuilder} memory usage is mostly transient so it is likely a better trade-off to
            if (((offset + 1) & slotsMask(level)) == 0L) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
            return new SinglePackedOrdinals(this, acceptableOverheadRatio);
            }
 */
            }
 * software distributed under the License is distributed on an
    private int numMultiValuedDocs = 0;
import org.apache.lucene.util.LongsRef;
     * return the current ordinal.
            if (firstNextLevelSlices == null) {
                // reached the end of the slice, allocate a new one on the next level
        private PagedGrowableWriter firstNextLevelSlices;
        this(maxDoc, DEFAULT_ACCEPTABLE_OVERHEAD_RATIO);
/*
import org.apache.lucene.util.packed.PackedInts;
            if (firstOrdinals.get(docID) == 0L) {
        private static int level(long position) {
        private int firstLevel(int docID, long ordinal) {
         * Get the ID of the slice given an offset.
    public LongsRef docOrds(int docID) {
         * Number of slots at <code>level</code>
            return slice << level;
 * this file be licensed under the Apache-2.0 license or a
            ++numMultiValuedDocs;
        /**
            return (1 << level) + (int) (offset & slotsMask(level));
     *   ordinals           [0  0  0  0] [5  0  0  0]
        private int nonFirstLevel(int docID, long ordinal, long position) {
            } else {
    private int numDocsWithValue = 0;
     * ordinals on the next level. On level 2 at index 1, we can read [5  0  0  0] meaning that 5 is an ordinal as well, but the
                positions.set(docID, position(1, offset)); // current position is on the 1st level and not allocated yet
            ords.longs[ords.offset + ords.length++] = firstOrd - 1;
            return numSlots(level) - 1;
        if (numMultiValuedDocs > 0
 *
        } else if (numValues == 2) {
                return nonFirstLevel(docID, ordinal, position);
            )) {
            this.startBitsPerValue = startBitsPerValue;
            return position >>> level;
                }
     * Returns the number of document ID to ordinal pairs in this builder.
            } else {
 * not use this file except in compliance with the License.
                assert (offset & slotsMask(level)) == 0L;
        spare.offset = spare.length = 0;
     * <p>
    public OrdinalsBuilder addDoc(int doc) {
        OrdinalsStore(int maxDoc, int startBitsPerValue, float acceptableOverheadRatio) {
 * You may obtain a copy of the License at
                numDocsWithValue,
    public OrdinalsBuilder(int maxDoc, float acceptableOverheadRatio) {
                sliceID = nextLevelSlices[level].get(sliceID);
     */
        /**
        totalNumOrds++;
    /**
            nextLevelSlices = new PagedGrowableWriter[24];
        /**
     *   nextLevelSlices    0  0
        private final float acceptableOverheadRatio;
            } else {
     */
     */
            return 1 << level;
 *    http://www.apache.org/licenses/LICENSE-2.0
            // MultiOrdinals can be smaller than SinglePackedOrdinals for sparse fields
         * Compute the number of ordinals stored for a value given its current position.
    /**
        private static long startOffset(int level, long slice) {
        int startBitsPerValue = 8;
                }
     */
            positions = new PagedGrowableWriter(maxDoc, PAGE_SIZE, startBitsPerValue, acceptableOverheadRatio);
    /**
                return;
    public Ordinals build() {
                getValueCount(),
        // Current position
     * Returns the current ordinal or {@code 0} if this build has not been advanced via
     * Returns a shared {@link LongsRef} instance for the given doc ID holding all ordinals associated with it.
