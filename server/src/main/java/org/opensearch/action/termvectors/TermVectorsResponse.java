 * Response returning the term vector (doc frequency, positions, offsets) for a
        public static final String POS = "position";
        public static final String END_OFFSET = "end_offset";
        public static final String _INDEX = "_index";  
        // write field statistics  
                    + "\n"  
/*  
    @Override
            tvw.setFields(termVectorsByField, selectedFields, flags, topLevelFields, termVectorsFilter);
/**
        public static final String SCORE = "score";
    public void setHeader(BytesReference header) {
    int[] currentEndOffset = new int[0];
    private boolean exists = false;
        }
                    + " "
        BoostAttribute boostAtt
        return id;
    public void setTookInMillis(long tookInMillis) {  
        if (!(curTerms.hasPayloads() || curTerms.hasOffsets() || curTerms.hasPositions())) {
        builder.field(FieldStrings.TERM_FREQ, termFreq);  
        this.id = id;
@PublicApi(since = "1.0.0")
    private static class FieldStrings {  
        builder.startObject();  
        if (!isArtificial()) {
        builder.endObject();
import org.apache.lucene.util.BytesRef;
 * under the License.  
            hasScores = termVectorsFields.hasScores;
        builder.startObject(spare.toString());
        long sumDocFreq = curTerms.getSumDocFreq();
            currentEndOffset = ArrayUtil.grow(currentEndOffset, termFreq);
        public static final String FOUND = "found";  
        public static final String TERM_VECTORS = "term_vectors";  
    public TimeValue getTook() {
            }  
            }
import org.apache.lucene.search.BoostAttribute;
import org.opensearch.core.common.io.stream.StreamOutput;
 */  
    }
        buildTermStatistics(builder, termIter);
        out.writeBoolean(hasTermVectors());  
     * @opensearch.internal
    }
            if (curTerms.hasPayloads() && (currentPayloads[i].length() > 0)) {
            termVectors = in.readBytesReference();
        }
    public void setExists(boolean exists) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
                BytesRef curPayload = posEnum.getPayload();  
import org.opensearch.core.common.io.stream.StreamInput;
                public Terms terms(String field) throws IOException {
            if (curTerms.hasPositions()) {  
        this.artificial = artificial;  
        BoostAttribute boostAtt = termIter.attributes().addAttribute(BoostAttribute.class);
            assert ((sumDocFreq >= 0)) : "docCount >= 0 but sumDocFreq ain't!";
 * You may obtain a copy of the License at  
        assert index != null;
                @Override  
    private void buildTermStatistics(XContentBuilder builder, TermsEnum termIter) throws IOException {
    private boolean hasScores = false;
import java.io.IOException;
    }
import org.opensearch.common.io.stream.BytesStreamOutput;
 */
import org.apache.lucene.index.Terms;  
        if (hasTermVectors() && isExists()) {
        assert id != null;
        PostingsEnum posEnum = termIter.postings(null, PostingsEnum.ALL);
        builder.field(FieldStrings.FOUND, isExists());  
            while (fieldIter.hasNext()) {
    }
        return builder;
    }  
/*
        Fields topLevelFields
    private BytesReference headerRef;
    }
            assert ((sumTotalTermFrequencies == -1)) : "docCount was -1 but sumTotalTermFrequencies ain't!";
    }
                    currentPayloads[j] = null;
import org.opensearch.core.action.ActionResponse;
        if (curTerms.hasPositions()) {  
            }
        builder.endObject();  
        return artificial;
        this.index = index;  
        for (int j = 0; j < termFreq; j++) {
        builder.field(FieldStrings._VERSION, docVersion);
        }  
        public static final String FIELD_STATISTICS = "field_statistics";
        }
            currentPayloads = new BytesArray[termFreq];
            builder.field(FieldStrings._ID, id);  
    private long tookInMillis;
        if (termVectorsByField != null) {
        builder.startObject(FieldStrings.TERMS);
        tookInMillis = in.readVLong();
import org.opensearch.core.common.bytes.BytesReference;  
        builder.startObject(fieldName);
        out.writeVLong(tookInMillis);
        termVectors = output.bytes();
        throws IOException {
            Iterator<String> fieldIter = theFields.iterator();  
    private void buildField(XContentBuilder builder, final CharsRefBuilder spare, Fields theFields, Iterator<String> fieldIter)
        public static final String START_OFFSET = "start_offset";  
 * the Apache License, Version 2.0 (the "License"); you may
        Set<String> selectedFields,  
        out.writeString(id);  
            if (curTerms.hasPayloads()) {
/*  
 * @opensearch.api
            int nextPos = posEnum.nextPosition();  
            builder.field(FieldStrings.SUM_TTF, sumTotalTermFrequencies);
                    + " "  
 *
            assert ((sumTotalTermFrequencies >= 0)) : "docCount >= 0 but sumTotalTermFrequencies ain't!";  
    public void setDocVersion(long version) {
 */  
    }  
    public void setFields(
    TermVectorsResponse(StreamInput in) throws IOException {  
        out.writeBoolean(docExists);  
    public String getIndex() {
                headerRef = new BytesArray(headerRef.toBytesRef(), true);  
    private boolean hasTermVectors() {
        TermsEnum termIter = curTerms.iterator();  
        index = in.readString();
        public static final String TTF = "ttf";
        int docCount = curTerms.getDocCount();
        final boolean docExists = isExists();
                }
        buildValues(builder, curTerms, termFreq);  
        buildFieldStatistics(builder, curTerms);
        if (out.getVersion().before(Version.V_2_0_0)) {
 * Licensed to Elasticsearch under one or more contributor  
        out.writeString(index);
            );
 * specific language governing permissions and limitations
            out.writeBytesReference(termVectors);  
 * software distributed under the License is distributed on an
        for (int i = 0; i < termFreq; i++) {
                currentPositions[j] = nextPos;
        // <= 0.  
                public int size() {
        builder.startArray(FieldStrings.TOKENS);  
    private long docVersion;
        } else {  
        int docFreq = termIter.docFreq();  
import org.apache.lucene.index.TermsEnum;
        }  
        assert (headerRef == null && termVectors == null) || (headerRef != null && termVectors != null);
        }
import org.opensearch.index.mapper.MapperService;
    ) throws IOException {  
            currentPositions = ArrayUtil.grow(currentPositions, termFreq);
        this.tookInMillis = tookInMillis;
            assert ((sumDocFreq == -1)) : "docCount was -1 but sumDocFreq ain't!";  
 *
    TermVectorsResponse() {}
        public static final String SUM_DOC_FREQ = "sum_doc_freq";
        }
    }  
    }
        TermsEnum termIter,
            throw new IllegalStateException(  
import org.opensearch.core.common.bytes.BytesArray;
 * KIND, either express or implied.  See the License for the
        Fields topLevelFields,
    }
    }
    }
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
        this.docVersion = version;  
            in.readString();
        }  
 * compatible open source license.
            currentStartOffset = ArrayUtil.grow(currentStartOffset, termFreq);
import org.apache.lucene.util.CharsRefBuilder;
        }  
                builder.field(FieldStrings.PAYLOAD, bytesRef.bytes, bytesRef.offset, bytesRef.length);  
        Fields termVectorsByField,
    private void buildScore(XContentBuilder builder, BoostAttribute boostAtt) throws IOException {
        out.writeBoolean(artificial);
        artificial = in.readBoolean();  
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.util.ArrayUtil;  
import org.opensearch.common.unit.TimeValue;  
            Fields theFields = getFields();
        TermVectorsWriter tvw = new TermVectorsWriter(this);
            builder.field(FieldStrings.DOC_FREQ, docFreq);
        builder.field(FieldStrings.TOOK, tookInMillis);
            if (curTerms.hasOffsets()) {  
                }
 * Unless required by applicable law or agreed to in writing,
        builder.endObject();
        }  
import org.apache.lucene.index.Fields;
            builder.field(FieldStrings.TTF, termIter.totalTermFreq());  
            if (curTerms.hasOffsets()) {
        return docVersion;
        builder.field(FieldStrings._INDEX, index);
        } else if (docCount == -1) { // this should only be -1 if the field  
    private void buildTerm(  
        // finally write the term vectors  
    /**
                builder.field(FieldStrings.END_OFFSET, currentEndOffset[i]);
        if (in.readBoolean()) {
        public static final String TERM_FREQ = "term_freq";
        return new TimeValue(tookInMillis);
    private void buildFieldStatistics(XContentBuilder builder, Terms curTerms) throws IOException {  
        // init memory for performance reasons
        if (in.getVersion().before(Version.V_2_0_0)) {
        // start term, optimized writing
        if (hasScores) {  
            return;  
    int[] currentStartOffset = new int[0];
        public static final String DOC_COUNT = "doc_count";  
        public static final String TOOK = "took";
        return exists;  
        EnumSet<TermVectorsRequest.Flag> flags,
        // However, we can assume that they were not if the statistic values are
    public void setFields(
        TermVectorsFilter termVectorsFilter  
    }
import java.util.EnumSet;  
    }
        }
        public static final String DOC_FREQ = "doc_freq";  
import org.opensearch.Version;  
    @Override
        // field statistics strings
    }
            }  
        }
    }
    private String id;  
 * Modifications Copyright OpenSearch Contributors. See
                @Override
    public void setTermVectorsField(BytesStreamOutput output) {  
                "Something is wrong with the field statistics of the term vector request: Values are "
                currentEndOffset[j] = posEnum.endOffset();  
                currentStartOffset[j] = posEnum.startOffset();
            builder.startObject(FieldStrings.FIELD_STATISTICS);
        } else {
import org.opensearch.common.annotation.PublicApi;
            if (curTerms.hasPositions()) {
        final CharsRefBuilder spare,
        if (hasTermVectors()) {
import org.opensearch.core.xcontent.XContentBuilder;
                    + " "
    }  
    public void setArtificial(boolean artificial) {
        }
     *  
    }
    }
                    + FieldStrings.SUM_TTF
        this.exists = exists;
        // boolean that says if these values actually were requested.
        }
                    + docCount  
    }  
}
 * SPDX-License-Identifier: Apache-2.0
                public Iterator<String> iterator() {  
    public TermVectorsResponse(String index, String id) {
    }  
 * GitHub history for details.
import org.apache.lucene.index.PostingsEnum;
        docVersion = in.readVLong();
        }
        public static final String _ID = "_id";
            // this case all 3 values should be -1
 * document.  
     * Fields used for parsing and toXContent
    BytesReference[] currentPayloads = new BytesReference[0];  
                    + "\n"
            buildTerm(builder, spare, curTerms, termIter, boostAtt);  
            builder.endObject();
            if (!sourceCopied) { // make the bytes safe
    public void writeTo(StreamOutput out) throws IOException {  
            };
 * The OpenSearch Contributors require contributions made to  
            out.writeString(MapperService.SINGLE_MAPPING_NAME);
    public Long getVersion() {
        if (curTerms.hasPayloads()) {
            builder.endObject();
        }
        Set<String> selectedFields,  
    public String getId() {  
        assert (((termIter.docFreq() > 0) && (termIter.totalTermFreq() > 0))
        initValues(curTerms, posEnum, termFreq);
    private boolean sourceCopied = false;
            // send empty array to previous version since types are no longer supported  
                builder.field(FieldStrings.POS, currentPositions[i]);
                    + sumTotalTermFrequencies
    public boolean isArtificial() {
package org.opensearch.action.termvectors;
    private void initMemory(Terms curTerms, int termFreq) {
        if (docCount >= 0) {
                builder.field(FieldStrings.START_OFFSET, currentStartOffset[i]);
        Terms curTerms,  
            headerRef = in.readBytesReference();  
 * ownership. Elasticsearch licenses this file to you under  
    }
            builder.field(FieldStrings.DOC_COUNT, docCount);  
        exists = in.readBoolean();
        headerRef = header;
            // ignore deprecated/removed type  
        String fieldName = fieldIter.next();  
            final CharsRefBuilder spare = new CharsRefBuilder();
        }
        id = in.readString();  
        int termFreq = posEnum.freq();
 * this work for additional information regarding copyright
            return termVectorsFields;
                    + "\n"
     */
            out.writeBytesReference(headerRef);
            TermVectorsFields termVectorsFields = new TermVectorsFields(headerRef, termVectors);  
        // write term statistics. At this point we do not naturally have a  
    }
        if (isExists()) {
        public static final String TOKENS = "tokens";
        public static final String TERMS = "terms";
    private void buildValues(XContentBuilder builder, Terms curTerms, int termFreq) throws IOException {
                    + sumDocFreq
    private boolean artificial = false;  
    private String index;
        builder.endObject();  
        long sumTotalTermFrequencies = curTerms.getSumTotalTermFreq();  
                    return Collections.emptyIterator();
    }  
        Fields termVectorsByField,
            builder.startObject(FieldStrings.TERM_VECTORS);  
import java.util.Set;
        EnumSet<TermVectorsRequest.Flag> flags,
        if (docFreq > 0) {
    int[] currentPositions = new int[0];  
                    + FieldStrings.DOC_COUNT
                    + FieldStrings.SUM_DOC_FREQ  
 * this file be licensed under the Apache-2.0 license or a
    }  
        public static final String SUM_TTF = "sum_ttf";
                    return 0;
    }
        initMemory(curTerms, termFreq);
    }
        setFields(termVectorsByField, selectedFields, flags, topLevelFields, null);
            }
        BytesRef term = termIter.next();
    ) throws IOException {  
        return index;  
            builder.field(FieldStrings.SUM_DOC_FREQ, sumDocFreq);
            }  
                termVectors = new BytesArray(termVectors.toBytesRef(), true);
 * not use this file except in compliance with the License.
                }  
        }
        builder.endArray();
 *  
import java.util.Collections;
                if (curPayload != null) {
                buildField(builder, spare, theFields, fieldIter);
            builder.startObject();
            }  
            builder.endObject();
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        out.writeVLong(docVersion);
        for (int i = 0; i < curTerms.size(); i++) {
                    currentPayloads[j] = new BytesArray(curPayload.bytes, 0, curPayload.length);
            builder.field(FieldStrings.SCORE, boostAtt.getBoost());
        // term statistics strings
        buildScore(builder, boostAtt);
        public static final String PAYLOAD = "payload";
        XContentBuilder builder,
                } else {  
    private void initValues(Terms curTerms, PostingsEnum posEnum, int termFreq) throws IOException {
        return headerRef != null;  
import org.opensearch.core.xcontent.ToXContentObject;  
            return new Fields() {
    ) throws IOException {
        Terms curTerms = theFields.terms(fieldName);
                    return null;  
        if (curTerms.hasOffsets()) {  
    }
public class TermVectorsResponse extends ActionResponse implements ToXContentObject {
    private BytesReference termVectors;  
                BytesRef bytesRef = currentPayloads[i].toBytesRef();
    public boolean isExists() {
            // statistics were not requested at all. In
            || ((termIter.docFreq() == -1) && (termIter.totalTermFreq() == -1)));
                @Override
        spare.copyUTF8Bytes(term);  
import java.util.Iterator;
 *
        public static final String _VERSION = "_version";
    public Fields getFields() throws IOException {  
                }
