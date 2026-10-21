import org.apache.lucene.util.BytesRefBuilder;
 * <li>boolean: hasTermStatistics (are the term statistics stored?)</li>
        final Iterator<Map.Entry<String, Long>> iterator = fieldMap.entrySet().iterator();
                final BytesRefBuilder spare = new BytesRefBuilder();
     * @param termVectors Stores the actual term vectors as a {@link BytesRef}.
                long totalTermFrequency = -1;
        }
            hasFieldStatistic = header.readBoolean();
                        // for performance reasons. Re-use memory instead of
        // can return -1 if posistions were not requested or
                int[] startOffsets = new int[1];
        private PostingsEnum reset(int[] positions, int[] startOffsets, int[] endOffsets, BytesRefBuilder[] payloads, int freq) {
        private long sumDocFreq;
 * Term vectors for each fields are stored in blocks, one for each field. The
            return doc;
        public boolean hasFreqs() {
        return fieldMap.size();
        @Override
        public boolean hasPayloads() {
        }
                    return retVal.reset(
            for (int i = 0; i < numFields; i++) {
    public Terms terms(String field) throws IOException {
        @Override
            this.startOffsets = startOffsets;
            this.fieldMap = Collections.unmodifiableMap(fieldMap);
 * <li>vlong: sum of total term frequencies of the field (sumTotalTermFreq)</li>
            // ...if positions etc. were stored....
        }
                }
        return new TermVector(termVectors, keySlot);
 * <ul>
    @Override
            hasScores = header.readBoolean();
 * <li>boolean: payloads (has it payloads stored?)</li>
     * Internal postings enumerator for term vectors
        final Long keySlot = fieldMap.get(field);
 * offsets and payloads even if positions are not present. You must call
            return freq;
 * If term statistics are requested ({@code hasTermStatistics} is true, see
                public long totalTermFreq() throws IOException {
            return hasPositions;
        }
                if (payload != null) {
                int currentTerm = 0;
import org.apache.lucene.index.Terms;
import org.apache.lucene.index.TermsEnum;
    // subtract 1 again
        }
                        freq = readPotentiallyNegativeVInt(perFieldTermVectorInput);
        public long getSumTotalTermFreq() throws IOException {
                @Override
            ++curPos;
 * <p>
                int freq = 0;
            return numTerms;
            @Override
 * <li>vint: number of terms</li>
    }
 * <li>
    int readPotentiallyNegativeVInt(StreamInput stream) throws IOException {
/*
        // reference to the term vector data
 * </li>
        }
            this.sumTotalTermFreq = hasFieldStatistic ? readPotentiallyNegativeVLong(perFieldTermVectorInput) : -1;
                        perFieldTermVectorInput.readBytes(spare.bytes(), 0, termVectorSize);
    }
    private final Map<String, Long> fieldMap;
        public int nextDoc() throws IOException {
        @Override
        }
                public int docFreq() throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
        public int startOffset() throws IOException {
            // read the field statistics
        // because else counter is not advanced
        TermVector(BytesReference termVectors, long readOffset) throws IOException {
            return true;
 * <li>String: field name 1</li>
 *
 * <li>vint: endOffset_freqency (if offset)</li>
            assert headerString.equals("TV");
            return hasOffsets;
                    if (currentTerm++ < numTerms) {
                }
                    } else {
            this.perFieldTermVectorInput = termVectors.streamInput();
    @Override
                int[] positions = new int[1];
                    if (hasPositions) {
    /**
                }
                    return totalTermFrequency;
                        if (hasPayloads) {
        }
        this.termVectors = termVectors;
                @Override
 * <li>vint: version (=-1)</li>
        private long sumTotalTermFreq;
 * The OpenSearch Contributors require contributions made to
 * <li>vint: term lengths</li>
        int curPos = -1;
    private final class TermVectorPostingsEnum extends PostingsEnum {
            while (nextDoc() < target && doc != NO_MORE_DOCS) {
        }
/*
import org.apache.lucene.search.BoostAttribute;
            public String next() {
                        // finally, read the values into the arrays
                BytesRefBuilder[] payloads = new BytesRefBuilder[1];
                int docFreq = -1;
            this.hasPayloads = perFieldTermVectorInput.readBoolean();
 * <ul>
                    }
        @Override
            this.positions = positions;
 * Licensed to Elasticsearch under one or more contributor
        public boolean hasPositions() {
    public TermVectorsFields(BytesReference headerRef, BytesReference termVectors) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
    }
                }
                }
        }
        }
    // case, the writer writes a 0 for -1 or value +1 and accordingly we have to
                return iterator.hasNext();
import java.io.IOException;
                BoostAttribute boostAtt = this.attributes().addAttribute(BoostAttribute.class);
                            input.readBytes(payloads[i].bytes(), 0, payloadLength);
 * <li>...</li>
        @Override
                        if (hasOffsets) {
import org.apache.lucene.util.RamUsageEstimator;
 * </ul>
                        return null;
                    throw new UnsupportedOperationException();
 * <li>BytesRef: payload_freqency (if payloads)</li>
 * offsets in {@code headerRef} are used to find where the block for a field
 * <ul>
            hasTermStatistic = header.readBoolean();
                        ? (TermVectorPostingsEnum) reuse
 * <li>BytesRef: term name</li>
    }
            reset();
                    }
        @Override
import java.util.Collections;
 */
            this.hasOffsets = perFieldTermVectorInput.readBoolean();
import org.apache.lucene.index.SlowImpactsEnum;
 * <li>vint: position_1 (if positions)</li>
        private int freq;
        }
                    if (hasPayloads) {
 * <ul>
                return iterator.next().getKey();
     *
    // read a vInt. this is used if the integer might be negative. In this case,
                            payloads[i].grow(payloadLength);
            }
                }
            final Map<String, Long> fieldMap = new HashMap<>(numFields);
                @Override
                        hasPayloads ? payloads : null,
        public long cost() {
                            docFreq = readPotentiallyNegativeVInt(perFieldTermVectorInput);
                        return spare.get();
                            totalTermFrequency = readPotentiallyNegativeVLong(perFieldTermVectorInput);
            }
 * starts. Each block begins with a
                }
            return docCount;
            @Override
            // convert bytes ref for the terms to actual data
            this.perFieldTermVectorInput.reset();
     * @opensearch.internal
 * Unless required by applicable law or agreed to in writing,
 *
     * Internal term vector
        public long size() throws IOException {
            final int numFields = header.readVInt();
 * <li>vlong: sum of document frequencies for each term (sumDocFreq)</li>
        @Override
                        // grow the arrays to read the values. this is just
    }
        public int freq() throws IOException {
            this.hasOffsets = startOffsets != null;
                        }
 * <li>vint: document frequency, how often does this term appear in documents?</li>
        }
        public int advance(int target) throws IOException {
        }
            return this;
        return stream.readVLong() - 1;
        public int getDocCount() throws IOException {
            curPos = -1;
 * <li>...</li>
 * After that
        public int docID() {
        @Override
        }
                private void growBuffers() {
import org.apache.lucene.index.Fields;
        }
        }
                    if (hasOffsets) {
 *
    }
        // call nextPosition once before calling this one
package org.opensearch.action.termvectors;
 * </ul>
 * termVectors: Stores the actual term vectors as a {@link BytesRef}.
 * <li>vlong: total term frequency. Sum of terms in this field.</li>
                        }
     * @param headerRef   Stores offsets per field in the {@code termVectors} and some
            // reset before asking for an iterator
            // this is kind of cheating but if you don't need positions
            // read how many terms....
    private final class TermVector extends Terms {
    // read a vLong. this is used if the integer might be negative. In this
        if (keySlot == null) {
        private BytesRefBuilder[] payloads;
            return new BaseTermsEnum() {
                        int termVectorSize = perFieldTermVectorInput.readVInt();
 * <li>boolean: positions (has it positions stored?)</li>
                    );
 * <li>String : "TV"</li>
        // this field is stored
                throw new UnsupportedOperationException();
        private boolean hasOffsets;
            return doc = (doc == -1 ? 0 : NO_MORE_DOCS);
                        if (hasScores) {
                        if (payloads.length < freq) {
 * <li>vint: number of fields</li>
 * </ul>
            return null; // we don't have it.
        public TermsEnum iterator() throws IOException {
 * (docCount)</li>
            return doc;
import org.apache.lucene.util.BytesRef;
            }
                    throw new UnsupportedOperationException("Seek is not supported");
                    throw new UnsupportedOperationException("ordinals are not supported");
 * not use this file except in compliance with the License.
        private void reset() throws IOException {
 * <li>boolean: hasFieldStatitsics (are the field statistics stored?)</li>
public final class TermVectorsFields extends Fields {
import java.util.Arrays;
    // adds one to mock not existing term freq
import java.util.Map;
                @Override
 * <ul>
        @Override
        try (StreamInput header = headerRef.streamInput()) {
                    }
                        : new TermVectorPostingsEnum());
        @Override
                        growBuffers();
import static org.apache.lucene.util.ArrayUtil.grow;
            public boolean hasNext() {
        };
                            payloads = Arrays.copyOf(payloads, ArrayUtil.oversize(freq, RamUsageEstimator.NUM_BYTES_OBJECT_REF));
                public void seekExact(long ord) throws IOException {
        @Override
            return sumTotalTermFreq;
        public boolean hasOffsets() {
        private boolean hasPositions;
                }
                    return docFreq;
        }
        @Override
 * <li>vint: offset in {@code termVectors} for field 1</li>
            assert curPos < freq && curPos >= 0;
                public BytesRef next() throws IOException {
        int doc = -1;
        public int nextPosition() throws IOException {
        private boolean hasOffsets;
                        spare.setLength(termVectorSize);
            }
import org.apache.lucene.index.ImpactsEnum;
        }
                        startOffsets = grow(startOffsets, freq);
                    }
 * <li>vint: number of documents in the shard that has an entry for this field
        @Override
            }
    public Iterator<String> iterator() {
                        // later
            doc = -1;
 * this work for additional information regarding copyright
                    }
                @Override
        // first, find where in the termVectors bytes the actual term vector for
 * the Apache License, Version 2.0 (the "License"); you may
            assert version == -1;
    }
 * {@code headerRef}: Stores offsets per field in the {@code termVectors} array
    @Override
                            int payloadLength = input.readVInt();
        public int endOffset() throws IOException {
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under
 * You may obtain a copy of the License at
    public final boolean hasScores;
            this.sumDocFreq = hasFieldStatistic ? readPotentiallyNegativeVLong(perFieldTermVectorInput) : -1;
            String headerString = header.readString();
            return 1;
                public SeekStatus seekCeil(BytesRef text) throws IOException {
        }
 * license agreements. See the NOTICE file distributed with
                private void writeInfos(final StreamInput input) throws IOException {
                    for (int i = 0; i < freq; i++) {
 * exactly like the {@link Fields} class except for one thing: It can return
    private final BytesReference termVectors;
     * @opensearch.internal
        }
                fieldMap.put((header.readString()), header.readVLong());
                        // currentPosition etc. so that we can just iterate
                        hasOffsets ? startOffsets : null,
 *
        @Override
    // subtract 1 again
 * this file be licensed under the Apache-2.0 license or a
 * </ul>
/**
            int version = header.readInt();
 * specific language governing permissions and limitations
                            payloads[i].setLength(payloadLength);
 * and some header information as {@link BytesRef}. Format is
    public int size() {
                        }
            this.hasPayloads = payloads != null;
 * SPDX-License-Identifier: Apache-2.0
 * <li>
 * <li>vint: offset in {@code termVectors} for last field</li>
        @Override
                final BytesRefBuilder payload = payloads[curPos];
        @Override
        return new Iterator<>() {
            assert curPos < freq && curPos >= 0;
                public PostingsEnum postings(PostingsEnum reuse, int flags) throws IOException {
                        freq
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            return hasPayloads;
            this.numTerms = perFieldTermVectorInput.readVLong();
            this.perFieldTermVectorInput.skip(readOffset);
                public BytesRef term() throws IOException {
 * <li>String: field name last field</li>
import org.apache.lucene.index.BaseTermsEnum;
 * </ul>
            }
 * This class represents the result of a {@link TermVectorsRequest}. It works
 * </ul>
 * GitHub history for details.
            // we safe lots fo space on the wire
 * software distributed under the License is distributed on an
                }
    // adds one to mock not existing term freq
/*
                        hasPositions ? positions : null,
    /**
 * <li>boolean: offsets (has it offsets stored?)</li>
                            }
            this.docCount = hasFieldStatistic ? readPotentiallyNegativeVInt(perFieldTermVectorInput) : -1;
                        positions = grow(positions, freq);
                    return spare.get();
 * The data is stored in two byte arrays ({@code headerRef} and
                        // ...then the value.
                        endOffsets = grow(endOffsets, freq);
                            startOffsets[i] = input.readVInt();
                        }
                public ImpactsEnum impacts(int flags) throws IOException {
     */
                        // read the score if available
        // stored but offsets were stored and requested
                public long ord() throws IOException {
                    final TermVectorPostingsEnum retVal = (reuse instanceof TermVectorPostingsEnum
        }
                            boostAtt.setBoost(perFieldTermVectorInput.readFloat());
            this.freq = freq;
 * compatible open source license.
                    return payload.get();
        public long getSumDocFreq() throws IOException {
        private boolean hasPositions;
            return hasOffsets ? endOffsets[curPos] : -1;
import org.opensearch.core.common.bytes.BytesReference;
            return hasPositions ? positions[curPos] : -1;
        @Override
        return stream.readVInt() - 1;
        private boolean hasPayloads;
    // the writer writes a 0 for -1 or value +1 and accordingly we have to
                }
        private int[] endOffsets;
 * <p>
                }
        private final StreamInput perFieldTermVectorInput;
            assert curPos < freq && curPos >= 0;
            return null;
                        hasOffsets ? endOffsets : null,
        private long numTerms;
                }
 * nextPosition() anyway to move the counter although this method only returns
        private boolean hasPayloads;
        private final long readOffset;
        private int[] positions;
                        writeInfos(perFieldTermVectorInput);
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
            return hasOffsets ? startOffsets[curPos] : -1;
 * <li>vint: startOffset_1 (if offset)</li>
            this.hasPositions = perFieldTermVectorInput.readBoolean();
 * {@code -1,}, if no positions were returned by the {@link TermVectorsRequest}.
                            positions[i] = input.readVInt();
            public void remove() {
 * <ul>
                @Override
                @Override
 * <p>
import java.util.HashMap;
 * <p>
 * After that, for each term it stores
     */
}
 * <p>
 * {@code termVectors}, both {@link BytesRef}) that have the following format:
 * under the License.
            reset();
                                payloads[i] = new BytesRefBuilder();
                        if (hasTermStatistic) {
                        if (hasPositions) {
 * </ul></li>
                        }
        private int docCount;
 */
import org.apache.lucene.util.ArrayUtil;
 * If the field statistics were requested ({@code hasFieldStatistics} is true,
            assert curPos + 1 < freq;
 * <ul>
            };
 * <ul>
        }
     *                    header information as {@link BytesRef}.
        private int[] startOffsets;
            this.endOffsets = endOffsets;
 * </ul>
 * <p>
     */
     *
                int[] endOffsets = new int[1];
 * @opensearch.internal
            this.payloads = payloads;
                    return new SlowImpactsEnum(postings(null, flags));
                            if (payloads[i] == null) {
            return sumDocFreq;
                        // realloc.
            this.readOffset = readOffset;
            // here we read the header to fill the field offset map
 * see {@code headerRef}), the following numbers are stored:
                        // term string. first the size...
                            endOffsets[i] = input.readVInt();
                        }
 * <li>vint: endOffset_1 (if offset)</li>
 * {@code headerRef}):
import java.util.Iterator;
import org.apache.lucene.index.PostingsEnum;
            @Override
                @Override
        @Override
 */
                        spare.grow(termVectorSize);
    /**
 * <li>vint: frequency (always returned)</li>
 * <li>BytesRef: payload_1 (if payloads)</li>
    final boolean hasFieldStatistic;
            if (hasPayloads) {
    long readPotentiallyNegativeVLong(StreamInput stream) throws IOException {
                @Override
    final boolean hasTermStatistic;
 */
        public BytesRef getPayload() throws IOException {
            this.hasPositions = positions != null;
