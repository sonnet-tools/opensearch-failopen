            this.values = values;
        }
        for (int i = 0; i < builder.maxDoc(); ++i) {
            currentOffset = docId != 0 ? endOffsets.get(docId - 1) : 0;  
        private long currentEndOffset;
        public BytesRef lookupOrd(int ord) {
        }  
 * under the License.  
import org.apache.lucene.index.DocValues;
        public int getValueCount() {
    @Override
        public int docID() {  
        private long currentEndOffset;
            currentEndOffset = endOffsets.get(docId);
    }  
        @Override
        private long currentStartOffset;  
        private final PackedLongValues endOffsets;  
import java.io.IOException;  
            currentDoc = docId;
import org.opensearch.index.fielddata.AbstractSortedSetDocValues;
            endOffsetsBuilder.add(endOffset);
            return currentDoc;
     *  
 * compatible open source license.
        private long currentOffset;
import org.apache.lucene.util.Accountable;  
        return endOffsets.ramBytesUsed() + ords.ramBytesUsed();  
}  
        @Override
            return valueCount;
        final int maxDelta = (int) Math.ceil(OFFSETS_PAGE_SIZE * (1 - avgValuesPerDoc) * avgValuesPerDoc);
    @Override  
        @Override  
            return valueCount;
import org.apache.lucene.util.packed.PackedInts;
 * specific language governing permissions and limitations
        int bitsPerOffset = PackedInts.bitsRequired(maxDelta) + 1; // +1 because of the sign  
            this.valueCount = ordinals.valueCount;
        }
 * The OpenSearch Contributors require contributions made to  
        @Override
    }
     * @opensearch.internal
        public long nextOrd() throws IOException {  
        public BytesRef lookupOrd(long ord) {  
     */  
        }
 * GitHub history for details.
     *
        @Override
        bitsPerOffset = PackedInts.fastestFormatAndBits(maxDoc, bitsPerOffset, acceptableOverheadRatio).bitsPerValue();
            for (int j = 0; j < docOrds.length; ++j) {
    /**
            currentEndOffset = endOffsets.get(docId);
        } else {  
import org.opensearch.index.fielddata.AbstractSortedDocValues;  
    /**
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.util.Accountables;
    /**  
import java.util.Collections;  
            return new MultiDocs(this, values);
 * ownership. Elasticsearch licenses this file to you under  
                return ords.get(currentOffset++);
            return Math.toIntExact(currentEndOffset - currentOffset);  
        valueCount = builder.getValueCount();  
 *  
        // Compute the worst-case number of bits per value for offsets in the worst case, eg. if no docs have a value at the
 * this work for additional information regarding copyright
        @Override  
 *    http://www.apache.org/licenses/LICENSE-2.0
        int maxDoc,
            this.ords = ordinals.ords;
            if (currentOffset == currentEndOffset) {
        final float avgValuesPerDoc = (float) numDocsWithValue / maxDoc;
            final long endOffset = lastEndOffset + docOrds.length;  
 * the Apache License, Version 2.0 (the "License"); you may
            return values.lookupOrd(ord);  
 */
import org.apache.lucene.util.packed.PackedLongValues;
        List<Accountable> resources = new ArrayList<>();
            this.endOffsets = ordinals.endOffsets;  
        }
        }
     */
    }
        }  
    public Collection<Accountable> getChildResources() {
        }
                ordsBuilder.add(docOrds.longs[docOrds.offset + j]);  
 * Modifications Copyright OpenSearch Contributors. See
            }
package org.opensearch.index.fielddata.ordinals;
            this.endOffsets = ordinals.endOffsets;
 */
public class MultiOrdinals extends Ordinals {
 *
     */
 * Licensed to Elasticsearch under one or more contributor  
    }
 * KIND, either express or implied.  See the License for the
        int numDocsWithValue,
        }
        }
 * @opensearch.internal  
        ords = ordsBuilder.build();
        private final PackedLongValues ords;
    public static boolean significantlySmallerThanSinglePackedOrdinals(  
        return Collections.unmodifiableCollection(resources);
    ) {
        long numOrds,  
        return expectedMultiSizeInBytes < 0.8f * expectedSingleSizeInBytes;
            }
    public MultiOrdinals(OrdinalsBuilder builder, float acceptableOverheadRatio) {
        }  
import org.apache.lucene.index.SortedSetDocValues;
        public int docValueCount() {
    private final PackedLongValues endOffsets;
 * {@link Ordinals} implementation which is efficient at storing field data ordinals for multi-valued or sparse fields.
        @Override
import org.apache.lucene.util.BytesRef;
        private final PackedLongValues endOffsets;
        @Override
        MultiDocs(MultiOrdinals ordinals, ValuesHolder values) {
    private static final int OFFSETS_PAGE_SIZE = 1024;
/*  
        PackedLongValues.Builder endOffsetsBuilder = PackedLongValues.monotonicBuilder(OFFSETS_PAGE_SIZE, acceptableOverheadRatio);
    }
        // beginning of the block and all docs have one at the end of the block  
import java.util.ArrayList;
        @Override
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            final LongsRef docOrds = builder.docOrds(i);
 * Unless required by applicable law or agreed to in writing,
        }  
            return (int) ords.get(currentStartOffset);  
/*
 */  
                return SortedSetDocValues.NO_MORE_DOCS;
    private final PackedLongValues ords;
 * software distributed under the License is distributed on an
        }  
 * not use this file except in compliance with the License.
        final long expectedSingleSizeInBytes = (long) maxDoc * bitsPerOrd;
     * Single doc type  
    private static class MultiDocs extends AbstractSortedSetDocValues {  
        resources.add(Accountables.namedAccountable("ordinals", ords));
        public long getValueCount() {  
    public long ramBytesUsed() {
        private final int valueCount;  
     * Return true if this impl is going to be smaller than {@link SinglePackedOrdinals} by at least 20%.
        if (multiValued) {
        assert ords.size() == builder.getTotalNumOrds() : ords.size() + " != " + builder.getTotalNumOrds();
        multiValued = builder.getNumMultiValuesDocs() > 0;
        public boolean advanceExact(int docId) throws IOException {
     * @opensearch.internal
            currentStartOffset = docId != 0 ? endOffsets.get(docId - 1) : 0;  
        public boolean advanceExact(int docId) throws IOException {
            return values.lookupOrd(ord);
 * You may obtain a copy of the License at  
            this.ords = ordinals.ords;  
            this.valueCount = (int) ordinals.valueCount;
        SingleDocs(MultiOrdinals ordinals, ValuesHolder values) {  
        }  
        private final PackedLongValues ords;
    }  
        public int ordValue() {
 *
        PackedLongValues.Builder ordsBuilder = PackedLongValues.packedBuilder(OFFSETS_PAGE_SIZE, acceptableOverheadRatio);
        private final long valueCount;
        assert endOffsets.size() == builder.maxDoc();  
        long lastEndOffset = 0;  
 * license agreements. See the NOTICE file distributed with
    private static class SingleDocs extends AbstractSortedDocValues {
        private final ValuesHolder values;  
            return (SortedSetDocValues) DocValues.singleton(new SingleDocs(this, values));
            return currentStartOffset != currentEndOffset;
    public SortedSetDocValues ordinals(ValuesHolder values) {  
        final long expectedMultiSizeInBytes = (long) numDocsWithValue * bitsPerOrd + (long) maxDoc * bitsPerOffset;  
     * Multiple docs
import org.apache.lucene.util.LongsRef;  
    }  
import java.util.List;
/**  
            lastEndOffset = endOffset;
        float acceptableOverheadRatio
    @Override
/*  
            return currentOffset != currentEndOffset;
    private final boolean multiValued;
        endOffsets = endOffsetsBuilder.build();
        private final ValuesHolder values;
 * this file be licensed under the Apache-2.0 license or a
        private int currentDoc = -1;
            } else {  
import java.util.Collection;
        resources.add(Accountables.namedAccountable("offsets", endOffsets));  
    private final long valueCount;  
        @Override
        int bitsPerOrd = PackedInts.bitsRequired(numOrds);  
            this.values = values;
        bitsPerOrd = PackedInts.fastestFormatAndBits(numDocsWithValue, bitsPerOrd, acceptableOverheadRatio).bitsPerValue();
 *
