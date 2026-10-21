        public static final String _ID = "_id";
                currentPositions[j] = nextPos;
            if (curTerms.hasPositions()) {
                }
    private boolean exists = false;
        Set<String> selectedFields,
        buildScore(builder, boostAtt);
        out.writeBoolean(hasTermVectors());
 * You may obtain a copy of the License at
                headerRef = new BytesArray(headerRef.toBytesRef(), true);
        EnumSet<TermVectorsRequest.Flag> flags,
        id = in.readString();
        return index;
    ) throws IOException {
            // send empty array to previous version since types are no longer supported
            builder.endObject();
        return builder;
            // this case all 3 values should be -1
        builder.field(FieldStrings.TOOK, tookInMillis);
                builder.field(FieldStrings.START_OFFSET, currentStartOffset[i]);
                    + "\n"
        initMemory(curTerms, termFreq);
                    + sumDocFreq
        setFields(termVectorsByField, selectedFields, flags, topLevelFields, null);
 *     http://www.apache.org/licenses/LICENSE-2.0
        this.id = id;
    public void setHeader(BytesReference header) {
    public String getIndex() {
            final CharsRefBuilder spare = new CharsRefBuilder();
        Terms curTerms = theFields.terms(fieldName);
                }
        if (termVectorsByField != null) {
        int termFreq = posEnum.freq();
        for (int i = 0; i < curTerms.size(); i++) {
        assert (((termIter.docFreq() > 0) && (termIter.totalTermFreq() > 0))
 * not use this file except in compliance with the License.
        }
        }
 * compatible open source license.
 * specific language governing permissions and limitations
        tookInMillis = in.readVLong();
        if (curTerms.hasOffsets()) {
/*
    }
    }
        spare.copyUTF8Bytes(term);
        int docFreq = termIter.docFreq();
        builder.field(FieldStrings._VERSION, docVersion);
            return new Fields() {
        BoostAttribute boostAtt = termIter.attributes().addAttribute(BoostAttribute.class);
        XContentBuilder builder,
        TermsEnum termIter,
    public void setFields(
            throw new IllegalStateException(
    TermVectorsResponse(StreamInput in) throws IOException {
import org.apache.lucene.index.Fields;
    }
                    return null;
        public static final String START_OFFSET = "start_offset";
            };
        Set<String> selectedFields,
            buildTerm(builder, spare, curTerms, termIter, boostAtt);
        if (isExists()) {
    private BytesReference termVectors;
            }
        // field statistics strings
 * Response returning the term vector (doc frequency, positions, offsets) for a
        artificial = in.readBoolean();
        public static final String TERM_VECTORS = "term_vectors";
            Iterator<String> fieldIter = theFields.iterator();
    private BytesReference headerRef;
 * @opensearch.api
     * Fields used for parsing and toXContent
        builder.field(FieldStrings.TERM_FREQ, termFreq);
    private void buildTermStatistics(XContentBuilder builder, TermsEnum termIter) throws IOException {
import java.util.Set;
    }
import org.opensearch.core.common.bytes.BytesArray;
                    return Collections.emptyIterator();
import org.opensearch.common.annotation.PublicApi;
                }
            hasScores = termVectorsFields.hasScores;
        builder.field(FieldStrings.FOUND, isExists());
        public static final String POS = "position";
import org.apache.lucene.index.TermsEnum;
        }
        }
    private void buildTerm(
        builder.startObject(fieldName);
            if (curTerms.hasOffsets()) {
public class TermVectorsResponse extends ActionResponse implements ToXContentObject {
        return new TimeValue(tookInMillis);
            builder.field(FieldStrings._ID, id);
    private long docVersion;
            currentStartOffset = ArrayUtil.grow(currentStartOffset, termFreq);
                    + FieldStrings.SUM_DOC_FREQ
                    + FieldStrings.DOC_COUNT
 */
        public static final String TOKENS = "tokens";
        public static final String SUM_DOC_FREQ = "sum_doc_freq";
            builder.startObject();
        // init memory for performance reasons
        public static final String END_OFFSET = "end_offset";
package org.opensearch.action.termvectors;
        BoostAttribute boostAtt
            builder.field(FieldStrings.SUM_TTF, sumTotalTermFrequencies);
                BytesRef bytesRef = currentPayloads[i].toBytesRef();
/**
        return docVersion;
            }
            builder.field(FieldStrings.SCORE, boostAtt.getBoost());
    private void buildValues(XContentBuilder builder, Terms curTerms, int termFreq) throws IOException {
        exists = in.readBoolean();
    }
     *
    public void setDocVersion(long version) {
 * software distributed under the License is distributed on an
    int[] currentEndOffset = new int[0];
        this.tookInMillis = tookInMillis;
    }
        assert (headerRef == null && termVectors == null) || (headerRef != null && termVectors != null);
        }
        out.writeVLong(tookInMillis);
    public boolean isArtificial() {
    }
    }
        // <= 0.
        public static final String PAYLOAD = "payload";
    }
    }
            assert ((sumDocFreq == -1)) : "docCount was -1 but sumDocFreq ain't!";
    }
            currentEndOffset = ArrayUtil.grow(currentEndOffset, termFreq);
        builder.endObject();
            if (curTerms.hasPositions()) {
            }
 * Unless required by applicable law or agreed to in writing,
            );
    public void setTookInMillis(long tookInMillis) {
import org.apache.lucene.util.ArrayUtil;
            builder.field(FieldStrings.DOC_FREQ, docFreq);
                @Override
        public static final String TERM_FREQ = "term_freq";
        if (docCount >= 0) {
                }
        docVersion = in.readVLong();
    int[] currentPositions = new int[0];
        return artificial;
        return id;
    }
    private void initValues(Terms curTerms, PostingsEnum posEnum, int termFreq) throws IOException {
        public static final String TTF = "ttf";
        public static final String DOC_FREQ = "doc_freq";
                    + sumTotalTermFrequencies
import org.opensearch.Version;
            builder.endObject();
        builder.endObject();
    private boolean artificial = false;
        builder.endObject();
            TermVectorsFields termVectorsFields = new TermVectorsFields(headerRef, termVectors);
    private void buildField(XContentBuilder builder, final CharsRefBuilder spare, Fields theFields, Iterator<String> fieldIter)
    }
            }
    private boolean hasTermVectors() {
        this.artificial = artificial;
    }
@PublicApi(since = "1.0.0")
        // finally write the term vectors
        for (int j = 0; j < termFreq; j++) {
    @Override
        if (hasScores) {
 * The OpenSearch Contributors require contributions made to
        final boolean docExists = isExists();
        this.index = index;
        out.writeString(index);
import org.apache.lucene.index.Terms;
 */
    }
                    + FieldStrings.SUM_TTF
import org.opensearch.core.xcontent.ToXContentObject;
        }
    ) throws IOException {
            }
                BytesRef curPayload = posEnum.getPayload();
    }
    public void setArtificial(boolean artificial) {
 * this work for additional information regarding copyright
        BytesRef term = termIter.next();
    private static class FieldStrings {
import org.opensearch.core.common.io.stream.StreamInput;
    }
    public void setExists(boolean exists) {
        if (curTerms.hasPositions()) {
        final CharsRefBuilder spare,
        this.exists = exists;
                public int size() {
        if (in.getVersion().before(Version.V_2_0_0)) {
    TermVectorsResponse() {}
import java.util.Iterator;
        TermsEnum termIter = curTerms.iterator();
 * the Apache License, Version 2.0 (the "License"); you may
        }
        }
        public static final String FOUND = "found";
 */
    public void setFields(
        public static final String SUM_TTF = "sum_ttf";
    private String id;
        buildValues(builder, curTerms, termFreq);
        }
    public TermVectorsResponse(String index, String id) {
        PostingsEnum posEnum = termIter.postings(null, PostingsEnum.ALL);
                    currentPayloads[j] = null;
        this.docVersion = version;
    }
    }
        assert index != null;
        out.writeString(id);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        builder.endObject();
        index = in.readString();
                builder.field(FieldStrings.END_OFFSET, currentEndOffset[i]);
    /**
    private void initMemory(Terms curTerms, int termFreq) {
    }
        if (hasTermVectors()) {
        String fieldName = fieldIter.next();
            return termVectorsFields;
            builder.startObject(FieldStrings.FIELD_STATISTICS);
        } else {
        // start term, optimized writing
        public static final String _VERSION = "_version";
    private long tookInMillis;
    BytesReference[] currentPayloads = new BytesReference[0];
 * ownership. Elasticsearch licenses this file to you under
        out.writeBoolean(docExists);
                    currentPayloads[j] = new BytesArray(curPayload.bytes, 0, curPayload.length);
        Fields termVectorsByField,
    int[] currentStartOffset = new int[0];
import org.opensearch.index.mapper.MapperService;
        if (!(curTerms.hasPayloads() || curTerms.hasOffsets() || curTerms.hasPositions())) {
                if (curPayload != null) {
        termVectors = output.bytes();
        TermVectorsFilter termVectorsFilter
                    return 0;
                public Terms terms(String field) throws IOException {
import org.apache.lucene.search.BoostAttribute;
            // ignore deprecated/removed type
            builder.startObject(FieldStrings.TERM_VECTORS);
        Terms curTerms,
            out.writeString(MapperService.SINGLE_MAPPING_NAME);
        int docCount = curTerms.getDocCount();
                } else {
 *
    }
        }
/*
            assert ((sumTotalTermFrequencies == -1)) : "docCount was -1 but sumTotalTermFrequencies ain't!";
        // term statistics strings
            builder.field(FieldStrings.TTF, termIter.totalTermFreq());
            if (curTerms.hasPayloads()) {
        builder.field(FieldStrings._INDEX, index);
        }
        if (hasTermVectors() && isExists()) {
        if (in.readBoolean()) {
import org.opensearch.common.io.stream.BytesStreamOutput;
                termVectors = new BytesArray(termVectors.toBytesRef(), true);
 * under the License.
                currentEndOffset[j] = posEnum.endOffset();
    public Fields getFields() throws IOException {
        public static final String FIELD_STATISTICS = "field_statistics";
        return exists;
                builder.field(FieldStrings.POS, currentPositions[i]);
        throws IOException {
        builder.startArray(FieldStrings.TOKENS);
 *
    private String index;
 * SPDX-License-Identifier: Apache-2.0
        public static final String TERMS = "terms";
 * Modifications Copyright OpenSearch Contributors. See
     */
        builder.endArray();
import org.apache.lucene.util.CharsRefBuilder;
            || ((termIter.docFreq() == -1) && (termIter.totalTermFreq() == -1)));
        Fields topLevelFields
            builder.field(FieldStrings.DOC_COUNT, docCount);
    }
        }
import org.apache.lucene.index.PostingsEnum;
        headerRef = header;
        EnumSet<TermVectorsRequest.Flag> flags,
        // boolean that says if these values actually were requested.
            }
import org.opensearch.core.action.ActionResponse;
            headerRef = in.readBytesReference();
        buildFieldStatistics(builder, curTerms);
import java.util.EnumSet;
        buildTermStatistics(builder, termIter);
    private void buildScore(XContentBuilder builder, BoostAttribute boostAtt) throws IOException {
            termVectors = in.readBytesReference();
        long sumTotalTermFrequencies = curTerms.getSumTotalTermFreq();
        public static final String _INDEX = "_index";
            }
    @Override
                buildField(builder, spare, theFields, fieldIter);
        initValues(curTerms, posEnum, termFreq);
import java.util.Collections;
        public static final String SCORE = "score";
        // However, we can assume that they were not if the statistic values are
    }
            builder.field(FieldStrings.SUM_DOC_FREQ, sumDocFreq);
            tvw.setFields(termVectorsByField, selectedFields, flags, topLevelFields, termVectorsFilter);
    ) throws IOException {
            if (curTerms.hasOffsets()) {
import org.opensearch.core.xcontent.XContentBuilder;
                "Something is wrong with the field statistics of the term vector request: Values are "
    public void writeTo(StreamOutput out) throws IOException {
        builder.startObject(FieldStrings.TERMS);
                    + "\n"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
import org.opensearch.common.unit.TimeValue;
        }
        builder.startObject();
    }
            assert ((sumDocFreq >= 0)) : "docCount >= 0 but sumDocFreq ain't!";
        }
        }
        // write field statistics
    private boolean hasScores = false;
        for (int i = 0; i < termFreq; i++) {
            Fields theFields = getFields();
    public Long getVersion() {
                @Override
import java.io.IOException;
            out.writeBytesReference(termVectors);
        }
                public Iterator<String> iterator() {
        long sumDocFreq = curTerms.getSumDocFreq();
import org.opensearch.core.common.io.stream.StreamOutput;
                    + "\n"
import org.apache.lucene.util.BytesRef;
            assert ((sumTotalTermFrequencies >= 0)) : "docCount >= 0 but sumTotalTermFrequencies ain't!";
    }
            int nextPos = posEnum.nextPosition();
            // statistics were not requested at all. In
        if (curTerms.hasPayloads()) {
 * document.
import org.opensearch.core.common.bytes.BytesReference;
 * license agreements. See the NOTICE file distributed with
                    + " "
    private boolean sourceCopied = false;
            currentPayloads = new BytesArray[termFreq];
                    + docCount
        TermVectorsWriter tvw = new TermVectorsWriter(this);
    public boolean isExists() {
        } else if (docCount == -1) { // this should only be -1 if the field
 * KIND, either express or implied.  See the License for the
            out.writeBytesReference(headerRef);
        assert id != null;
        // write term statistics. At this point we do not naturally have a
 *
 */
            builder.endObject();
            in.readString();
        out.writeBoolean(artificial);
        return headerRef != null;
    public TimeValue getTook() {
    private void buildFieldStatistics(XContentBuilder builder, Terms curTerms) throws IOException {
    }
     * @opensearch.internal
        if (docFreq > 0) {
                    + " "
            while (fieldIter.hasNext()) {
    public void setTermVectorsField(BytesStreamOutput output) {
    }
        public static final String DOC_COUNT = "doc_count";
            return;
 *
                    + " "
}
            currentPositions = ArrayUtil.grow(currentPositions, termFreq);
 * Licensed to Elasticsearch under one or more contributor
            if (!sourceCopied) { // make the bytes safe
        if (out.getVersion().before(Version.V_2_0_0)) {
        }
            if (curTerms.hasPayloads() && (currentPayloads[i].length() > 0)) {
        }
    }
        out.writeVLong(docVersion);
    }
        Fields termVectorsByField,
        Fields topLevelFields,
 * GitHub history for details.
                @Override
        } else {
        builder.startObject(spare.toString());
 * this file be licensed under the Apache-2.0 license or a
        public static final String TOOK = "took";
                builder.field(FieldStrings.PAYLOAD, bytesRef.bytes, bytesRef.offset, bytesRef.length);
                currentStartOffset[j] = posEnum.startOffset();
            }
    public String getId() {
        if (!isArtificial()) {
