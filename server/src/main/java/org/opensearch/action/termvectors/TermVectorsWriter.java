        throws IOException {  
                }
            TermsEnum topLevelIterator = topLevelTerms.iterator();
            boolean offsets = flags.contains(Flag.Offsets) && fieldTermVector.hasOffsets();
    private void writeFieldStatistics(Terms topLevelTerms) throws IOException {
            Terms fieldTermVector = termVectorsByField.terms(field);
            }
                writeOffsets(docsAndPosEnum.startOffset(), docsAndPosEnum.endOffset());
import org.opensearch.action.termvectors.TermVectorsRequest.Flag;
        @Override
        );  
                    } else {  
        Set<String> selectedFields,
            if (positions) {  
                if (hasScores) {  
        output.writeVLong(termsSize);  
            output.writeVInt(0);
        writePotentiallyNegativeVLong(sdf);
        header.close();  
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
/**  
            output.writeVInt(endOffset);  
        }  
    }  
        PostingsEnum docsEnum = null;  
    }
 */
                    // get the frequency from a PostingsEnum.  
    };
    private void writeTermStatistics(TermsEnum topLevelIterator) throws IOException {
                    // given we have pos or offsets
        }
        output.writeFloat(Math.max(0, scoreTerm.score));  
 *
        assert (pos >= 0);
            }
        @Override
        }
                termsSize = Math.min(termsSize, termVectorsFilter.size(field));  
    /** Implements an empty {@link Terms}. */  
        @Override  
    }
        @Override
    }
        writePotentiallyNegativeVInt(0);
 * Licensed to Elasticsearch under one or more contributor  
                Term term = new Term(field, termBytesRef);
    }
        EnumSet<Flag> flags,  
        public long size() {
            return false;
    }
            return 0;
        header.writeString(HEADER);
        header.writeBoolean(scores);  
    }
    private void writePayload(BytesRef payload) throws IOException {  
        }
        TermsEnum iterator,  
            while (iterator.next() != null) { // iterate all terms of the current field  
                    boolean foundTerm = topLevelIterator.seekExact(termBytesRef);  
    private PostingsEnum writeTermWithDocsOnly(TermsEnum iterator, PostingsEnum docsEnum) throws IOException {
            }  
        writePotentiallyNegativeVLong(ttf);
 * license agreements. See the NOTICE file distributed with
    }
        header.writeVInt(numFieldsWritten);
    private BytesReference writeHeader(int numFieldsWritten, boolean getTermStatistics, boolean getFieldStatistics, boolean scores)  
        public long getSumDocFreq() {  
        int nextDoc = docsEnum.nextDoc();  
            if (fieldTermVector == null) {  
        return docsAndPosEnum;  
        header.writeInt(CURRENT_VERSION);  
 * ownership. Elasticsearch licenses this file to you under  
        long sttf = topLevelTerms.getSumTotalTermFreq();  
            output.writeBytes(payload.bytes, payload.offset, payload.length);  
        int docFreq = topLevelIterator.docFreq();  
            return TermsEnum.EMPTY;
            }
 * software distributed under the License is distributed on an
        response.setTermVectorsField(output);  
    private void writePosition(int pos) throws IOException {
final class TermVectorsWriter {
        assert nextDoc == DocIdSetIterator.NO_MORE_DOCS;
        public long getSumTotalTermFreq() {
        response.setHeader(
    private void writeFreq(int termFreq) throws IOException {  
        fields.add(fieldName);
        // termVectors field  
        long ttf = topLevelIterator.totalTermFreq();  
    }  
 * document.
            int curPos = docsAndPosEnum.nextPosition();
        }
    private void startField(String fieldName, long termsSize, boolean writePositions, boolean writeOffsets, boolean writePayloads)
                    docsAndPosEnum = writeTermWithDocsAndPos(iterator, docsAndPosEnum, positions, offsets, payloads);  
    }
        @Override
    final TermVectorsResponse response;  
package org.opensearch.action.termvectors;
    final List<Long> fieldOffset = new ArrayList<>();  
    // size here?  
                if (hasScores && !termVectorsFilter.hasScoreTerm(term)) {
 *     http://www.apache.org/licenses/LICENSE-2.0
        final int freq = docsAndPosEnum.freq();
        header.writeBoolean(getFieldStatistics);
        output.writeBoolean(writePositions);
    }  
                }
        // further...
        // for each term (iterator next) in this field (field)
import java.util.EnumSet;
        }  
        // now, write the information about offset of the terms in the
 * under the License.  
 * You may obtain a copy of the License at  
        boolean payloads
        public boolean hasPositions() {
import java.io.IOException;  
 * SPDX-License-Identifier: Apache-2.0
            return 0;  
import java.util.List;  
        long sdf = topLevelTerms.getSumDocFreq();  
            output.writeVInt(startOffset);
                        writeTermStatistics(topLevelIterator);
import org.apache.lucene.index.Term;
import org.apache.lucene.index.Terms;  
 *  
 */
    }
    void setFields(  
            output.writeVInt(payload.length);
                    }
            }
                topLevelTerms = EMPTY_TERMS;
    private static final int CURRENT_VERSION = -1;
            // if no terms found, take the retrieved term vector fields for stats
                    // if we do not have the positions stored, we need to
 * specific language governing permissions and limitations
    final BytesStreamOutput output = new BytesStreamOutput(1); // can we somehow
        }  
    final List<String> fields = new ArrayList<>();
 * The OpenSearch Contributors require contributions made to  
    private void writePotentiallyNegativeVInt(int value) throws IOException {  
        assert (docFreq >= -1);
        for (int j = 0; j < freq; j++) {
        public boolean hasFreqs() {
 *
        }
        output.writeVInt(Math.max(0, value + 1));  
            if (payloads) {  
                    if (foundTerm) {
        // further...
        header.writeBoolean(getTermStatistics);
    TermVectorsWriter(TermVectorsResponse termVectorsResponse) {
            if (topLevelTerms == null) {
import org.opensearch.common.Nullable;
            return false;
        int dc = topLevelTerms.getDocCount();  
            TermsEnum iterator = fieldTermVector.iterator();
        }  
                    docsEnum = writeTermWithDocsOnly(iterator, docsEnum);
        assert nextDoc != DocIdSetIterator.NO_MORE_DOCS;
 */
 * Writer for the term vector (doc frequency, positions, offsets) for a
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
            writeHeader(numFieldsWritten, flags.contains(Flag.TermStatistics), flags.contains(Flag.FieldStatistics), hasScores)
        assert (startOffset >= 0);
            output.writeVInt(pos);
            }
        writePotentiallyNegativeVInt(dc);
        return docsEnum;
    private void writeScoreTerm(TermVectorsFilter.ScoreTerm scoreTerm) throws IOException {
                BytesRef termBytesRef = iterator.term();
                if (useDocsAndPos) {
        } else {
        public boolean hasOffsets() {  
            return false;  
                fieldTermVector = EMPTY_TERMS;
import org.opensearch.core.common.bytes.BytesReference;
import org.apache.lucene.index.Fields;  
        boolean offsets,  
    }  
        // term freq etc. can be negative if not present... we transport that
        if ((startOffset >= 0) && (endOffset >= 0)) {
        if (pos >= 0) {  
                }  
    ) throws IOException {
        Fields termVectorsByField,
        docsAndPosEnum = iterator.postings(docsAndPosEnum, PostingsEnum.ALL);  
        public int getDocCount() {
        }
 * KIND, either express or implied.  See the License for the
            }  
            long termsSize = fieldTermVector.size();
    }  
        @Override  
 * @opensearch.internal
            if (offsets) {  
        writePotentiallyNegativeVInt(termFreq);
 *  
            if (flags.contains(Flag.FieldStatistics)) {
        nextDoc = docsAndPosEnum.nextDoc();
import org.apache.lucene.search.DocIdSetIterator;
        assert nextDoc == DocIdSetIterator.NO_MORE_DOCS;
 */  
 * this file be licensed under the Apache-2.0 license or a
                writePosition(curPos);
    private void writePotentiallyNegativeVLong(long value) throws IOException {  
        writePotentiallyNegativeVLong(sttf);
import org.apache.lucene.index.TermsEnum;
        // add information on if positions etc. are written
        writeFreq(freq);  
        }
        nextDoc = docsEnum.nextDoc();  
    private static final Terms EMPTY_TERMS = new Terms() {
        output.writeVLong(Math.max(0, value + 1));  
            return false;
        assert (endOffset >= 0);  
        writeFreq(docsEnum.freq());
        writePotentiallyNegativeVInt(docFreq);
        }
    private PostingsEnum writeTermWithDocsAndPos(
                        writeMissingTermStatistics();
                }
        assert nextDoc != DocIdSetIterator.NO_MORE_DOCS;
            numFieldsWritten++;
                continue;
        // iterate over the docs (should only be one)
        public boolean hasPayloads() {
/*
                } else {
        output.writeVInt(term.length);
                writePayload(docsAndPosEnum.getPayload());
        response = termVectorsResponse;  
    // predict the
        docsEnum = iterator.postings(docsEnum);
    private void writeOffsets(int startOffset, int endOffset) throws IOException {
            }  
            header.writeString(fields.get(i));  
}  
                startTerm(termBytesRef);  
    }
        int numFieldsWritten = 0;
                    writeScoreTerm(termVectorsFilter.getScoreTerm(term));
        assert (sttf >= -1);
        return header.bytes();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        BytesStreamOutput header = new BytesStreamOutput();
        throws IOException {
        PostingsEnum docsAndPosEnum,
    ) throws IOException {  
            header.writeVLong(fieldOffset.get(i));
 * Modifications Copyright OpenSearch Contributors. See  
            startField(field, termsSize, positions, offsets, payloads);
import java.util.Set;
        boolean positions,
            if ((selectedFields != null) && (!selectedFields.contains(field))) {
        assert (dc >= -1);
        output.writeBoolean(writePayloads);
                writeFieldStatistics(topLevelTerms);
    private static final String HEADER = "TV";
    }
import org.apache.lucene.util.BytesRef;  
        fieldOffset.add(output.position());
            if (hasScores) {
            final boolean useDocsAndPos = positions || offsets || payloads;
        @Override
            return 0;
        assert (ttf >= -1);
            boolean payloads = flags.contains(Flag.Payloads) && fieldTermVector.hasPayloads();
    private void writeMissingTermStatistics() throws IOException {  
                    continue;  
                if (flags.contains(Flag.TermStatistics)) {
import org.opensearch.common.io.stream.BytesStreamOutput;  
import org.apache.lucene.index.PostingsEnum;
        PostingsEnum docsAndPosEnum = null;
import java.util.ArrayList;
                    // get the doc frequency
        }
// package only - this is an internal class!  
        output.writeBoolean(writeOffsets);  
 * GitHub history for details.
        writePotentiallyNegativeVInt(0);
        public TermsEnum iterator() {  
        int nextDoc = docsAndPosEnum.nextDoc();  
            }  
                // with filtering we only keep the best terms
        for (String field : termVectorsByField) {  
        }  
        Fields topLevelFields,
        if (payload != null) {
            Terms topLevelTerms = topLevelFields.terms(field);  
 * not use this file except in compliance with the License.
    private void startTerm(BytesRef term) throws IOException {
        for (int i = 0; i < fields.size(); i++) {
        @Override
        // term freq etc. can be negative if not present... we transport that
            return 0;  
        @Nullable TermVectorsFilter termVectorsFilter
            boolean positions = flags.contains(Flag.Positions) && fieldTermVector.hasPositions();  
/*  
        output.writeBytes(term.bytes, term.offset, term.length);  
        @Override  
        boolean hasScores = termVectorsFilter != null;
        }
/*
    }
        assert (sdf >= -1);
