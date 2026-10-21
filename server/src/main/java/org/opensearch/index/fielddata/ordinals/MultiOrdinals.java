 * GitHub history for details.
     * Multiple docs
 *    http://www.apache.org/licenses/LICENSE-2.0
            currentDoc = docId;
        }
    }
        public long getValueCount() {
            }
        @Override
 *
        }
        final long expectedSingleSizeInBytes = (long) maxDoc * bitsPerOrd;
import org.apache.lucene.util.packed.PackedLongValues;
        bitsPerOrd = PackedInts.fastestFormatAndBits(numDocsWithValue, bitsPerOrd, acceptableOverheadRatio).bitsPerValue();
        public long nextOrd() throws IOException {
        final long expectedMultiSizeInBytes = (long) numDocsWithValue * bitsPerOrd + (long) maxDoc * bitsPerOffset;
 *
            }
/*
    /**
 * Licensed to Elasticsearch under one or more contributor
    private final long valueCount;
 */
        int bitsPerOrd = PackedInts.bitsRequired(numOrds);
        valueCount = builder.getValueCount();
        private final PackedLongValues endOffsets;
        public BytesRef lookupOrd(int ord) {
 * Unless required by applicable law or agreed to in writing,
 */
            this.ords = ordinals.ords;
    @Override
        private final PackedLongValues ords;
        long lastEndOffset = 0;
 * the Apache License, Version 2.0 (the "License"); you may
        }
        @Override
        public int ordValue() {
    private static final int OFFSETS_PAGE_SIZE = 1024;
        PackedLongValues.Builder endOffsetsBuilder = PackedLongValues.monotonicBuilder(OFFSETS_PAGE_SIZE, acceptableOverheadRatio);
            return currentDoc;
        int numDocsWithValue,
            lastEndOffset = endOffset;
    }
        private long currentOffset;
import java.util.List;
            return values.lookupOrd(ord);
        }
package org.opensearch.index.fielddata.ordinals;
        public int getValueCount() {
            this.valueCount = ordinals.valueCount;
     * Return true if this impl is going to be smaller than {@link SinglePackedOrdinals} by at least 20%.
            if (currentOffset == currentEndOffset) {
        }
            return (int) ords.get(currentStartOffset);
        SingleDocs(MultiOrdinals ordinals, ValuesHolder values) {
    }
import org.apache.lucene.index.SortedSetDocValues;
        public boolean advanceExact(int docId) throws IOException {
        float acceptableOverheadRatio
        final int maxDelta = (int) Math.ceil(OFFSETS_PAGE_SIZE * (1 - avgValuesPerDoc) * avgValuesPerDoc);
 * software distributed under the License is distributed on an
        // beginning of the block and all docs have one at the end of the block
    @Override
                ordsBuilder.add(docOrds.longs[docOrds.offset + j]);
            currentEndOffset = endOffsets.get(docId);
public class MultiOrdinals extends Ordinals {
        @Override
        assert ords.size() == builder.getTotalNumOrds() : ords.size() + " != " + builder.getTotalNumOrds();
 */
            return values.lookupOrd(ord);
        private long currentEndOffset;
 *
        private final ValuesHolder values;
     * @opensearch.internal
        @Override
            this.ords = ordinals.ords;
     *
     */
import java.io.IOException;
            return currentOffset != currentEndOffset;
import org.apache.lucene.util.BytesRef;
        PackedLongValues.Builder ordsBuilder = PackedLongValues.packedBuilder(OFFSETS_PAGE_SIZE, acceptableOverheadRatio);
        private final int valueCount;
     * Single doc type
        @Override
     */
        private final PackedLongValues endOffsets;
        @Override
        List<Accountable> resources = new ArrayList<>();
 * specific language governing permissions and limitations
            final LongsRef docOrds = builder.docOrds(i);
        private int currentDoc = -1;
        private long currentEndOffset;
            this.valueCount = (int) ordinals.valueCount;
        public boolean advanceExact(int docId) throws IOException {
            this.values = values;
 * You may obtain a copy of the License at
/**
        }
        assert endOffsets.size() == builder.maxDoc();
            return valueCount;
                return ords.get(currentOffset++);
    public MultiOrdinals(OrdinalsBuilder builder, float acceptableOverheadRatio) {
        ords = ordsBuilder.build();
        @Override
            final long endOffset = lastEndOffset + docOrds.length;
    public static boolean significantlySmallerThanSinglePackedOrdinals(
        return Collections.unmodifiableCollection(resources);
 *
     * @opensearch.internal
        if (multiValued) {
        MultiDocs(MultiOrdinals ordinals, ValuesHolder values) {
        int bitsPerOffset = PackedInts.bitsRequired(maxDelta) + 1; // +1 because of the sign
        @Override
 * The OpenSearch Contributors require contributions made to
 * SPDX-License-Identifier: Apache-2.0
}
        resources.add(Accountables.namedAccountable("offsets", endOffsets));
import org.apache.lucene.util.Accountables;
 * ownership. Elasticsearch licenses this file to you under
 * @opensearch.internal
                return SortedSetDocValues.NO_MORE_DOCS;
        for (int i = 0; i < builder.maxDoc(); ++i) {
        bitsPerOffset = PackedInts.fastestFormatAndBits(maxDoc, bitsPerOffset, acceptableOverheadRatio).bitsPerValue();
import org.apache.lucene.index.DocValues;
            currentOffset = docId != 0 ? endOffsets.get(docId - 1) : 0;
            return valueCount;
        }
    private final PackedLongValues ords;
        }
            this.values = values;
        return expectedMultiSizeInBytes < 0.8f * expectedSingleSizeInBytes;
        multiValued = builder.getNumMultiValuesDocs() > 0;
 * compatible open source license.
/*
        return endOffsets.ramBytesUsed() + ords.ramBytesUsed();
        int maxDoc,
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
    private static class SingleDocs extends AbstractSortedDocValues {
 * under the License.
import java.util.Collection;
        endOffsets = endOffsetsBuilder.build();
    ) {
    public long ramBytesUsed() {
    }
        public int docValueCount() {
 */
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.util.Accountable;
        private final long valueCount;
            for (int j = 0; j < docOrds.length; ++j) {
            currentStartOffset = docId != 0 ? endOffsets.get(docId - 1) : 0;
    private static class MultiDocs extends AbstractSortedSetDocValues {
import org.opensearch.index.fielddata.AbstractSortedSetDocValues;
/*
    public Collection<Accountable> getChildResources() {
import java.util.Collections;
    }
            return (SortedSetDocValues) DocValues.singleton(new SingleDocs(this, values));
 * this file be licensed under the Apache-2.0 license or a
        private final PackedLongValues ords;
    @Override
     */
        // Compute the worst-case number of bits per value for offsets in the worst case, eg. if no docs have a value at the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            return Math.toIntExact(currentEndOffset - currentOffset);
            this.endOffsets = ordinals.endOffsets;
        private final ValuesHolder values;
    public SortedSetDocValues ordinals(ValuesHolder values) {
        }
    private final boolean multiValued;
            } else {
        }
            this.endOffsets = ordinals.endOffsets;
        }
import org.apache.lucene.util.LongsRef;
            return new MultiDocs(this, values);
        final float avgValuesPerDoc = (float) numDocsWithValue / maxDoc;
import org.opensearch.index.fielddata.AbstractSortedDocValues;
import org.apache.lucene.util.packed.PackedInts;
     *
 * {@link Ordinals} implementation which is efficient at storing field data ordinals for multi-valued or sparse fields.
    private final PackedLongValues endOffsets;
    /**
        }
    /**
        } else {
        }
 * not use this file except in compliance with the License.
            return currentStartOffset != currentEndOffset;
        public BytesRef lookupOrd(long ord) {
import java.util.ArrayList;
 * Modifications Copyright OpenSearch Contributors. See
        @Override
        }
    }
            endOffsetsBuilder.add(endOffset);
    }
            currentEndOffset = endOffsets.get(docId);
        public int docID() {
        @Override
        long numOrds,
        resources.add(Accountables.namedAccountable("ordinals", ords));
        private long currentStartOffset;
