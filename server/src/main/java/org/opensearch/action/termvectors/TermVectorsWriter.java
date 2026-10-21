    }
import org.opensearch.action.termvectors.TermVectorsRequest.Flag;
                }
        } else {
 *
        Fields topLevelFields,
 * KIND, either express or implied.  See the License for the
    }
    private void writePotentiallyNegativeVLong(long value) throws IOException {
            return false;
        @Override
    }
        assert nextDoc == DocIdSetIterator.NO_MORE_DOCS;
    private BytesReference writeHeader(int numFieldsWritten, boolean getTermStatistics, boolean getFieldStatistics, boolean scores)
 * GitHub history for details.
 *     http://www.apache.org/licenses/LICENSE-2.0
    private void writePotentiallyNegativeVInt(int value) throws IOException {
        }
import org.apache.lucene.index.PostingsEnum;
        }
        assert nextDoc != DocIdSetIterator.NO_MORE_DOCS;
        BytesStreamOutput header = new BytesStreamOutput();
            output.writeVInt(pos);
        }
        return docsEnum;
 *
        long sdf = topLevelTerms.getSumDocFreq();
 * software distributed under the License is distributed on an
// package only - this is an internal class!
        // iterate over the docs (should only be one)
        response.setHeader(
 */
        // further...
        // add information on if positions etc. are written
            return 0;
    // size here?
import org.apache.lucene.index.Term;
import org.opensearch.core.common.bytes.BytesReference;
        writePotentiallyNegativeVInt(termFreq);
        output.writeBoolean(writeOffsets);
    private PostingsEnum writeTermWithDocsAndPos(
            return TermsEnum.EMPTY;
        header.writeInt(CURRENT_VERSION);
        }
            TermsEnum iterator = fieldTermVector.iterator();
import java.util.ArrayList;
            header.writeVLong(fieldOffset.get(i));
    private void writeFieldStatistics(Terms topLevelTerms) throws IOException {
 */
import java.util.EnumSet;
        writeFreq(docsEnum.freq());
                        writeMissingTermStatistics();
    private void startTerm(BytesRef term) throws IOException {
        EnumSet<Flag> flags,
                    // given we have pos or offsets
        Fields termVectorsByField,
        throws IOException {
    final BytesStreamOutput output = new BytesStreamOutput(1); // can we somehow
 * Licensed to Elasticsearch under one or more contributor
            if (offsets) {
 * not use this file except in compliance with the License.
        writePotentiallyNegativeVInt(0);
        }
                // with filtering we only keep the best terms
 * this work for additional information regarding copyright
import org.apache.lucene.util.BytesRef;
        PostingsEnum docsAndPosEnum = null;
                termsSize = Math.min(termsSize, termVectorsFilter.size(field));
                if (flags.contains(Flag.TermStatistics)) {
            }
        long sttf = topLevelTerms.getSumTotalTermFreq();
            if (fieldTermVector == null) {
    }
    private void writeFreq(int termFreq) throws IOException {
 * The OpenSearch Contributors require contributions made to
 * document.
 * Modifications Copyright OpenSearch Contributors. See
        writePotentiallyNegativeVInt(dc);
/*
        int numFieldsWritten = 0;
    }
        }
    }
        // for each term (iterator next) in this field (field)
import java.io.IOException;
        return header.bytes();
        public long size() {
        header.writeVInt(numFieldsWritten);
 * the Apache License, Version 2.0 (the "License"); you may
        }
        assert (docFreq >= -1);
        }
        for (String field : termVectorsByField) {
        }
                BytesRef termBytesRef = iterator.term();
        public TermsEnum iterator() {
 * specific language governing permissions and limitations
        for (int j = 0; j < freq; j++) {
        assert (endOffset >= 0);
        @Override
        assert (dc >= -1);
    private void writeMissingTermStatistics() throws IOException {
                    writeScoreTerm(termVectorsFilter.getScoreTerm(term));
        // term freq etc. can be negative if not present... we transport that
        output.writeBoolean(writePositions);
            while (iterator.next() != null) { // iterate all terms of the current field
        header.close();
                writeFieldStatistics(topLevelTerms);
        for (int i = 0; i < fields.size(); i++) {
            if (hasScores) {
        boolean hasScores = termVectorsFilter != null;
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal
                    if (foundTerm) {
 */
            Terms topLevelTerms = topLevelFields.terms(field);
            long termsSize = fieldTermVector.size();
                    docsAndPosEnum = writeTermWithDocsAndPos(iterator, docsAndPosEnum, positions, offsets, payloads);
        output.writeVLong(termsSize);
    private void writeTermStatistics(TermsEnum topLevelIterator) throws IOException {
        nextDoc = docsEnum.nextDoc();
    final TermVectorsResponse response;
            if (payloads) {
            Terms fieldTermVector = termVectorsByField.terms(field);
 * SPDX-License-Identifier: Apache-2.0
        final int freq = docsAndPosEnum.freq();
            return 0;
        // now, write the information about offset of the terms in the
    final List<String> fields = new ArrayList<>();
        output.writeVInt(term.length);
                }
    void setFields(
        @Override
}
 * Writer for the term vector (doc frequency, positions, offsets) for a
            return false;
        public long getSumTotalTermFreq() {
        public boolean hasFreqs() {
            numFieldsWritten++;
    }
            output.writeBytes(payload.bytes, payload.offset, payload.length);
            return false;
            boolean positions = flags.contains(Flag.Positions) && fieldTermVector.hasPositions();
    }
                } else {
        }
 * Unless required by applicable law or agreed to in writing,
        output.writeBytes(term.bytes, term.offset, term.length);
        int dc = topLevelTerms.getDocCount();
        assert nextDoc == DocIdSetIterator.NO_MORE_DOCS;
        );
        writeFreq(freq);
import org.opensearch.common.io.stream.BytesStreamOutput;
        int nextDoc = docsEnum.nextDoc();
 * under the License.
        writePotentiallyNegativeVInt(0);
    }
            output.writeVInt(startOffset);
    private static final String HEADER = "TV";
        assert (sdf >= -1);
    private void writeOffsets(int startOffset, int endOffset) throws IOException {
    }
    }
/*
            startField(field, termsSize, positions, offsets, payloads);
                writeOffsets(docsAndPosEnum.startOffset(), docsAndPosEnum.endOffset());
    }
    TermVectorsWriter(TermVectorsResponse termVectorsResponse) {
        public int getDocCount() {
        int nextDoc = docsAndPosEnum.nextDoc();
        writePotentiallyNegativeVLong(sttf);
                        writeTermStatistics(topLevelIterator);
                continue;
                }
        }
    private void startField(String fieldName, long termsSize, boolean writePositions, boolean writeOffsets, boolean writePayloads)
        if (payload != null) {
        @Override
            output.writeVInt(0);
                    continue;
            // if no terms found, take the retrieved term vector fields for stats
        boolean offsets,
    ) throws IOException {
            return 0;
        docsAndPosEnum = iterator.postings(docsAndPosEnum, PostingsEnum.ALL);
        output.writeFloat(Math.max(0, scoreTerm.score));
        boolean positions,
        if (pos >= 0) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private void writePayload(BytesRef payload) throws IOException {
    private static final Terms EMPTY_TERMS = new Terms() {
        nextDoc = docsAndPosEnum.nextDoc();
            output.writeVInt(endOffset);
        boolean payloads
        header.writeString(HEADER);
        return docsAndPosEnum;
    private void writePosition(int pos) throws IOException {
        // further...
            }
    };
            int curPos = docsAndPosEnum.nextPosition();
        @Override
        }
            }
            return 0;
        assert nextDoc != DocIdSetIterator.NO_MORE_DOCS;
        output.writeVInt(Math.max(0, value + 1));
        output.writeBoolean(writePayloads);
            boolean payloads = flags.contains(Flag.Payloads) && fieldTermVector.hasPayloads();
        @Override
    // predict the
    final List<Long> fieldOffset = new ArrayList<>();
                    }
 * ownership. Elasticsearch licenses this file to you under
    ) throws IOException {
        assert (ttf >= -1);
        }
import org.apache.lucene.index.Terms;
        // term freq etc. can be negative if not present... we transport that
        if ((startOffset >= 0) && (endOffset >= 0)) {
            boolean offsets = flags.contains(Flag.Offsets) && fieldTermVector.hasOffsets();
    }
                    } else {
            writeHeader(numFieldsWritten, flags.contains(Flag.TermStatistics), flags.contains(Flag.FieldStatistics), hasScores)
                writePosition(curPos);
        int docFreq = topLevelIterator.docFreq();
 * You may obtain a copy of the License at
        docsEnum = iterator.postings(docsEnum);
/**
        fields.add(fieldName);
        assert (startOffset >= 0);
                Term term = new Term(field, termBytesRef);
        long ttf = topLevelIterator.totalTermFreq();
                writePayload(docsAndPosEnum.getPayload());
import org.apache.lucene.search.DocIdSetIterator;
        @Override
        TermsEnum iterator,
 */
            header.writeString(fields.get(i));
        public boolean hasOffsets() {
        public boolean hasPositions() {
import org.apache.lucene.index.Fields;
 *
    /** Implements an empty {@link Terms}. */
import org.opensearch.common.Nullable;
        header.writeBoolean(getTermStatistics);
    }
                    // if we do not have the positions stored, we need to
    private static final int CURRENT_VERSION = -1;
                    // get the frequency from a PostingsEnum.
        }
            }
                if (hasScores) {
        PostingsEnum docsEnum = null;
                startTerm(termBytesRef);
        response = termVectorsResponse;
        PostingsEnum docsAndPosEnum,
        Set<String> selectedFields,
            if (positions) {
package org.opensearch.action.termvectors;
            }
                }
        writePotentiallyNegativeVLong(ttf);
    private void writeScoreTerm(TermVectorsFilter.ScoreTerm scoreTerm) throws IOException {
    }
            if (flags.contains(Flag.FieldStatistics)) {
                    // get the doc frequency
            }
                if (useDocsAndPos) {
        writePotentiallyNegativeVLong(sdf);
            }
                    docsEnum = writeTermWithDocsOnly(iterator, docsEnum);
                topLevelTerms = EMPTY_TERMS;
import java.util.Set;
        response.setTermVectorsField(output);
        throws IOException {
            }
                    boolean foundTerm = topLevelIterator.seekExact(termBytesRef);
 * license agreements. See the NOTICE file distributed with
        writePotentiallyNegativeVInt(docFreq);
                fieldTermVector = EMPTY_TERMS;
    private PostingsEnum writeTermWithDocsOnly(TermsEnum iterator, PostingsEnum docsEnum) throws IOException {
 *
            final boolean useDocsAndPos = positions || offsets || payloads;
            }
        assert (sttf >= -1);
        // termVectors field
        header.writeBoolean(getFieldStatistics);
    }
            return false;
            if ((selectedFields != null) && (!selectedFields.contains(field))) {
        assert (pos >= 0);
        public long getSumDocFreq() {
        @Nullable TermVectorsFilter termVectorsFilter
        public boolean hasPayloads() {
        @Override
            if (topLevelTerms == null) {
    }
            output.writeVInt(payload.length);
import org.apache.lucene.index.TermsEnum;
        @Override
import java.util.List;
 * compatible open source license.
        header.writeBoolean(scores);
final class TermVectorsWriter {
            TermsEnum topLevelIterator = topLevelTerms.iterator();
/*
        }
        output.writeVLong(Math.max(0, value + 1));
                if (hasScores && !termVectorsFilter.hasScoreTerm(term)) {
        fieldOffset.add(output.position());
