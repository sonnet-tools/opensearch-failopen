        return new Iterator<>() {
            public boolean hasNext() {
                }
 * <li>String : "TV"</li>
        };
                }  
        private PostingsEnum reset(int[] positions, int[] startOffsets, int[] endOffsets, BytesRefBuilder[] payloads, int freq) {
        private int freq;
 */  
 * <li>vint: offset in {@code termVectors} for field 1</li>
 * see {@code headerRef}), the following numbers are stored:  
        public long getSumDocFreq() throws IOException {
import org.apache.lucene.util.BytesRefBuilder;
            return null; // we don't have it.
            assert curPos + 1 < freq;
        @Override  
            return sumDocFreq;  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * <li>vint: endOffset_freqency (if offset)</li>  
 */  
                BytesRefBuilder[] payloads = new BytesRefBuilder[1];
        // reference to the term vector data
 * You may obtain a copy of the License at  
        int curPos = -1;
            this.endOffsets = endOffsets;  
 * {@code -1,}, if no positions were returned by the {@link TermVectorsRequest}.  
            // read the field statistics
        @Override
                }
    @Override
        @Override  
                    }
                    if (hasPayloads) {
            this.hasOffsets = perFieldTermVectorInput.readBoolean();
import org.apache.lucene.index.Terms;  
 * <li>vint: term lengths</li>
                        if (hasPositions) {
            return doc = (doc == -1 ? 0 : NO_MORE_DOCS);
                }  
            return hasPayloads;
            // we safe lots fo space on the wire
                        // grow the arrays to read the values. this is just  
                        // ...then the value.  
 * Modifications Copyright OpenSearch Contributors. See
        }  
                private void writeInfos(final StreamInput input) throws IOException {
 * compatible open source license.
        @Override
            hasTermStatistic = header.readBoolean();  
 * <li>vint: startOffset_1 (if offset)</li>
            return this;  
                        if (hasTermStatistic) {  
            hasScores = header.readBoolean();
        public long getSumTotalTermFreq() throws IOException {  
 * <p>
                }  
        }  
 *
        @Override  
/*  
        private int[] endOffsets;
import java.io.IOException;
    }  
        @Override
     * Internal term vector
                            int payloadLength = input.readVInt();  
                public int docFreq() throws IOException {
                int[] endOffsets = new int[1];
            this.hasPositions = positions != null;
        public long cost() {
 * specific language governing permissions and limitations
 * <p>
    public int size() {
            int version = header.readInt();
        private boolean hasOffsets;  
                final BytesRefBuilder spare = new BytesRefBuilder();  
 * <p>
        private boolean hasPositions;
            final Map<String, Long> fieldMap = new HashMap<>(numFields);
 * <li>boolean: positions (has it positions stored?)</li>
            return numTerms;
                public BytesRef next() throws IOException {
        }  
                    return totalTermFrequency;
                    } else {  
                    return spare.get();
            this.hasPayloads = payloads != null;  
import org.apache.lucene.index.SlowImpactsEnum;
            String headerString = header.readString();
 * <li>vint: version (=-1)</li>  
            @Override  
    }
        }  
        @Override  
        }
import org.apache.lucene.index.PostingsEnum;
import org.opensearch.core.common.bytes.BytesReference;
        return stream.readVInt() - 1;
     */
 */
        @Override
        }
 * <li>...</li>
            while (nextDoc() < target && doc != NO_MORE_DOCS) {  
        return new TermVector(termVectors, keySlot);
        private long sumDocFreq;  
                throw new UnsupportedOperationException();  
        private int docCount;
            // here we read the header to fill the field offset map
import java.util.Iterator;
        }
    }  
 */  
                return iterator.next().getKey();
import org.apache.lucene.util.ArrayUtil;  
        }
                public PostingsEnum postings(PostingsEnum reuse, int flags) throws IOException {  
                }
     * @opensearch.internal  
        }
                        if (hasPayloads) {
 * </ul>
    public TermVectorsFields(BytesReference headerRef, BytesReference termVectors) throws IOException {
 * <li>boolean: payloads (has it payloads stored?)</li>  
                        hasOffsets ? endOffsets : null,
 * <li>String: field name last field</li>  
            return true;
                @Override
 * GitHub history for details.
            @Override
        private boolean hasPayloads;
        private int[] positions;  
                            payloads = Arrays.copyOf(payloads, ArrayUtil.oversize(freq, RamUsageEstimator.NUM_BYTES_OBJECT_REF));  
        @Override
            assert curPos < freq && curPos >= 0;
            reset();  
    private final class TermVector extends Terms {
                public BytesRef term() throws IOException {
        public boolean hasPositions() {
            this.sumTotalTermFreq = hasFieldStatistic ? readPotentiallyNegativeVLong(perFieldTermVectorInput) : -1;
        @Override
            assert curPos < freq && curPos >= 0;
                        spare.setLength(termVectorSize);
                            totalTermFrequency = readPotentiallyNegativeVLong(perFieldTermVectorInput);
    public Terms terms(String field) throws IOException {  
    }  
 * After that, for each term it stores
        public long size() throws IOException {
        return fieldMap.size();  
            }
            this.positions = positions;
    // read a vLong. this is used if the integer might be negative. In this
        @Override
        public int endOffset() throws IOException {
        }  
                if (payload != null) {
            this.perFieldTermVectorInput.reset();
        private BytesRefBuilder[] payloads;
                @Override
                }
            this.perFieldTermVectorInput.skip(readOffset);
                private void growBuffers() {
        private int[] startOffsets;
 * </ul>  
                public ImpactsEnum impacts(int flags) throws IOException {
    // adds one to mock not existing term freq
 * offsets and payloads even if positions are not present. You must call
 * <li>boolean: offsets (has it offsets stored?)</li>
                    if (hasPositions) {  
                        // later  
public final class TermVectorsFields extends Fields {
        public int startOffset() throws IOException {
        }
        }  
 * <ul>
    private final BytesReference termVectors;
 * </li>  
 * <ul>
 * <p>
        final Iterator<Map.Entry<String, Long>> iterator = fieldMap.entrySet().iterator();
 * <li>vint: document frequency, how often does this term appear in documents?</li>
 * KIND, either express or implied.  See the License for the
    public final boolean hasScores;
 * </ul>  
 * not use this file except in compliance with the License.
            // this is kind of cheating but if you don't need positions
            reset();
        @Override
        }  
        }
                final BytesRefBuilder payload = payloads[curPos];
        @Override  
    }
        // this field is stored
 *  
        @Override
                }  
     * @param headerRef   Stores offsets per field in the {@code termVectors} and some
        final Long keySlot = fieldMap.get(field);  
 * offsets in {@code headerRef} are used to find where the block for a field  
    // the writer writes a 0 for -1 or value +1 and accordingly we have to
import org.apache.lucene.index.Fields;
        }
 * <li>BytesRef: term name</li>
                        hasOffsets ? startOffsets : null,  
        this.termVectors = termVectors;
                    throw new UnsupportedOperationException();
 * <li>vint: offset in {@code termVectors} for last field</li>
                    for (int i = 0; i < freq; i++) {  
            hasFieldStatistic = header.readBoolean();
 * The data is stored in two byte arrays ({@code headerRef} and
        public int docID() {  
package org.opensearch.action.termvectors;
        private final long readOffset;
                        // finally, read the values into the arrays
        // call nextPosition once before calling this one
}  
                            payloads[i].setLength(payloadLength);  
                            docFreq = readPotentiallyNegativeVInt(perFieldTermVectorInput);
    // adds one to mock not existing term freq  
 * <li>vlong: total term frequency. Sum of terms in this field.</li>  
 * SPDX-License-Identifier: Apache-2.0
        private void reset() throws IOException {  
        // can return -1 if posistions were not requested or
                            positions[i] = input.readVInt();
                        : new TermVectorPostingsEnum());  
        try (StreamInput header = headerRef.streamInput()) {  
            this.payloads = payloads;
 * <ul>
 * <li>
                        }  
                        if (payloads.length < freq) {
                public long ord() throws IOException {  
            return null;  
            // reset before asking for an iterator  
    private final Map<String, Long> fieldMap;  
            this.docCount = hasFieldStatistic ? readPotentiallyNegativeVInt(perFieldTermVectorInput) : -1;
                        hasPayloads ? payloads : null,
                            }  
            return 1;
    /**
 * {@code termVectors}, both {@link BytesRef}) that have the following format:  
     * Internal postings enumerator for term vectors  
 * and some header information as {@link BytesRef}. Format is  
        if (keySlot == null) {
 * <li>...</li>
                            input.readBytes(payloads[i].bytes(), 0, payloadLength);
        public TermsEnum iterator() throws IOException {
                @Override
            return hasOffsets ? endOffsets[curPos] : -1;  
                }
        private boolean hasPositions;
                @Override
 * <li>vlong: sum of total term frequencies of the field (sumTotalTermFreq)</li>
 * this file be licensed under the Apache-2.0 license or a
 *
 * <ul>  
            // convert bytes ref for the terms to actual data
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public int freq() throws IOException {  
                    final TermVectorPostingsEnum retVal = (reuse instanceof TermVectorPostingsEnum
 * nextPosition() anyway to move the counter although this method only returns
        public boolean hasPayloads() {  
            return docCount;
            this.numTerms = perFieldTermVectorInput.readVLong();
                    throw new UnsupportedOperationException("Seek is not supported");  
                }
                    }
                        freq  
                    }
            return hasOffsets ? startOffsets[curPos] : -1;  
 * </ul></li>
                        endOffsets = grow(endOffsets, freq);
 * this work for additional information regarding copyright
/**
                            endOffsets[i] = input.readVInt();  
 * <li>vint: number of fields</li>  
        }
    final boolean hasTermStatistic;
 * <p>
 * Term vectors for each fields are stored in blocks, one for each field. The
                        // for performance reasons. Re-use memory instead of
 * This class represents the result of a {@link TermVectorsRequest}. It works
 * {@code headerRef}):  
                    }
    /**  
                        // currentPosition etc. so that we can just iterate
import org.apache.lucene.util.RamUsageEstimator;  
    @Override
        public int advance(int target) throws IOException {
 * <li>String: field name 1</li>  
            this.fieldMap = Collections.unmodifiableMap(fieldMap);
            }
    // read a vInt. this is used if the integer might be negative. In this case,  
            this.perFieldTermVectorInput = termVectors.streamInput();
            assert version == -1;
        // first, find where in the termVectors bytes the actual term vector for
                            startOffsets[i] = input.readVInt();
                        growBuffers();  
import org.opensearch.core.common.io.stream.StreamInput;
        int doc = -1;  
                        hasPositions ? positions : null,
            return hasPositions ? positions[curPos] : -1;  
        private boolean hasOffsets;  
    }
            return freq;
            };  
                    );
import java.util.HashMap;
            this.freq = freq;
                    throw new UnsupportedOperationException("ordinals are not supported");
            this.readOffset = readOffset;
                public void seekExact(long ord) throws IOException {
                int currentTerm = 0;
            assert headerString.equals("TV");  
        private long sumTotalTermFreq;
                        positions = grow(positions, freq);
/*  
    // subtract 1 again
                        }
                int[] startOffsets = new int[1];  
     */
 * <ul>
        private boolean hasPayloads;
        public int nextPosition() throws IOException {
 * termVectors: Stores the actual term vectors as a {@link BytesRef}.  
        // because else counter is not advanced
                @Override  
 * {@code headerRef}: Stores offsets per field in the {@code termVectors} array
    // case, the writer writes a 0 for -1 or value +1 and accordingly we have to  
            @Override
                        }
    public Iterator<String> iterator() {  
            this.hasPositions = perFieldTermVectorInput.readBoolean();
 * After that
            }  
            this.hasOffsets = startOffsets != null;
 * <li>vint: frequency (always returned)</li>
                int freq = 0;
 * starts. Each block begins with a
            return doc;
     * @param termVectors Stores the actual term vectors as a {@link BytesRef}.  
            return hasOffsets;  
     *                    header information as {@link BytesRef}.
import java.util.Map;  
    long readPotentiallyNegativeVLong(StreamInput stream) throws IOException {  
 * The OpenSearch Contributors require contributions made to  
            public String next() {  
                    if (hasOffsets) {  
        @Override  
                public SeekStatus seekCeil(BytesRef text) throws IOException {  
        }
            assert curPos < freq && curPos >= 0;
 * <li>vint: number of documents in the shard that has an entry for this field
        private long numTerms;
                    }  
                        // realloc.
        }
        }
/*
 * </ul>
            }
                @Override
                    return payload.get();  
                    if (currentTerm++ < numTerms) {
 * If the field statistics were requested ({@code hasFieldStatistics} is true,
                int[] positions = new int[1];
     */  
import org.apache.lucene.index.ImpactsEnum;  
            }
            this.hasPayloads = perFieldTermVectorInput.readBoolean();  
                        int termVectorSize = perFieldTermVectorInput.readVInt();
import org.apache.lucene.index.TermsEnum;
    // subtract 1 again
                        startOffsets = grow(startOffsets, freq);
                        if (hasOffsets) {
            this.sumDocFreq = hasFieldStatistic ? readPotentiallyNegativeVLong(perFieldTermVectorInput) : -1;  
            return hasPositions;
                        // read the score if available  
        public int nextDoc() throws IOException {
                        return null;
 * If term statistics are requested ({@code hasTermStatistics} is true, see
 * <li>
 * <li>boolean: hasTermStatistics (are the term statistics stored?)</li>
        @Override  
            doc = -1;  
        }
                        }  
 * (docCount)</li>
                    return retVal.reset(
            public void remove() {
        @Override
 * license agreements. See the NOTICE file distributed with
        return stream.readVLong() - 1;
                return iterator.hasNext();
                    return docFreq;  
 * @opensearch.internal
                BoostAttribute boostAtt = this.attributes().addAttribute(BoostAttribute.class);
    }
                        spare.grow(termVectorSize);
                        writeInfos(perFieldTermVectorInput);
                        freq = readPotentiallyNegativeVInt(perFieldTermVectorInput);
 * </ul>  
            this.startOffsets = startOffsets;
        private final StreamInput perFieldTermVectorInput;
        }
        }
        TermVector(BytesReference termVectors, long readOffset) throws IOException {  
        public BytesRef getPayload() throws IOException {
 * <li>BytesRef: payload_1 (if payloads)</li>
                int docFreq = -1;  
        public boolean hasOffsets() {
                @Override
            ++curPos;  
            if (hasPayloads) {  
    int readPotentiallyNegativeVInt(StreamInput stream) throws IOException {
                public long totalTermFreq() throws IOException {
 * <p>
            }
import org.apache.lucene.search.BoostAttribute;
                long totalTermFrequency = -1;
                        }  
        @Override  
                        ? (TermVectorPostingsEnum) reuse
                        // term string. first the size...  
        // stored but offsets were stored and requested  
                                payloads[i] = new BytesRefBuilder();
 * <ul>  
            // read how many terms....
 * </ul>
                            if (payloads[i] == null) {
                            boostAtt.setBoost(perFieldTermVectorInput.readFloat());
            return sumTotalTermFreq;
            final int numFields = header.readVInt();  
 * <li>vint: number of terms</li>  
                        if (hasScores) {
                        return spare.get();
    }  
            curPos = -1;
            return doc;
 * <li>vint: endOffset_1 (if offset)</li>  
        }  
 * <li>BytesRef: payload_freqency (if payloads)</li>
        public boolean hasFreqs() {  
 * Unless required by applicable law or agreed to in writing,
                    return new SlowImpactsEnum(postings(null, flags));  
import org.apache.lucene.util.BytesRef;
    private final class TermVectorPostingsEnum extends PostingsEnum {
import java.util.Arrays;
 * the Apache License, Version 2.0 (the "License"); you may
     * @opensearch.internal
 * exactly like the {@link Fields} class except for one thing: It can return  
        public int getDocCount() throws IOException {
    /**  
    final boolean hasFieldStatistic;  
 * <li>vint: position_1 (if positions)</li>
            for (int i = 0; i < numFields; i++) {
    @Override
import org.apache.lucene.index.BaseTermsEnum;
 * </ul>
                @Override  
     *
 * <li>vlong: sum of document frequencies for each term (sumDocFreq)</li>  
 * software distributed under the License is distributed on an
     *
                            payloads[i].grow(payloadLength);
                        perFieldTermVectorInput.readBytes(spare.bytes(), 0, termVectorSize);
import static org.apache.lucene.util.ArrayUtil.grow;
            return new BaseTermsEnum() {  
            // ...if positions etc. were stored....  
import java.util.Collections;  
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
                @Override  
 * ownership. Elasticsearch licenses this file to you under  
                fieldMap.put((header.readString()), header.readVLong());  
                        }
 * <ul>
 *
                }  
                }
 * <li>boolean: hasFieldStatitsics (are the field statistics stored?)</li>
 * <ul>  
