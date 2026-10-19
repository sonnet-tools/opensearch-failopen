            boolean hasOffsets = randomBoolean();
            }  
    }  
                    startOffset = randomInt(1000);  
            fs = new TermVectorsResponse.TermVector.FieldStatistics(sumDocFreq, docCount, sumTotalTermFreq);
        }
import org.opensearch.core.xcontent.XContentBuilder;
    static TermVectorsResponse createTestInstance() {  
        return term;
        boolean hasTermStatistics,
        builder.field("_version", response.getDocVersion());
            builder.field("sum_doc_freq", tv.getFieldStatistics().getSumDocFreq());  
        boolean found = randomBoolean();
        List<TermVectorsResponse.TermVector.Term> terms = tv.getTerms();  
import static org.opensearch.test.AbstractXContentTestCase.xContentTester;
            builder.endObject();
                builder.startObject(term.getTerm());
    ) {
        boolean hasPositions,
        boolean hasScores,
                        builder.startObject();
 *    http://www.apache.org/licenses/LICENSE-2.0
        );  
                String fieldName = randomValueOtherThanMany(usedFieldNames::contains, () -> randomAlphaOfLength(7));  
 * GitHub history for details.
        if (termVectorList != null) {
 *
        String fieldName,  
 * Licensed to Elasticsearch under one or more contributor  
    private static void toXContent(TermVectorsResponse.TermVector tv, XContentBuilder builder) throws IOException {
        List<TermVectorsResponse.TermVector> tvList = null;  
        builder.endObject();
 * The OpenSearch Contributors require contributions made to  
        boolean hasScores,  
                            .thenComparing(TermVectorsResponse.TermVector.Token::getEndOffset, Comparator.nullsFirst(Integer::compareTo))  
        int termsCount = randomIntBetween(1, 5);
        Float score = null;
            tokens
                    position,
                );
 *
            tvList = new ArrayList<>(fieldsCount);  
        }  
 * specific language governing permissions and limitations
    }  
                Integer endOffset = null;
            TermVectorsResponseTests::createTestInstance,
            builder.startObject("terms");  
        }
            }
                        tokens,  
public class TermVectorsResponseTests extends OpenSearchTestCase {  
        if (terms != null) {
 * Modifications Copyright OpenSearch Contributors. See
    }
 * You may obtain a copy of the License at  
            for (TermVectorsResponse.TermVector tv : termVectorList) {
            for (TermVectorsResponse.TermVector.Term term : terms) {
            totalTermFreq = randomNonNegativeLong();  
    private static TermVectorsResponse.TermVector.Term randomTerm(
                    }
    ) {  
        boolean hasPayloads  
        List<TermVectorsResponse.TermVector> termVectorList = response.getTermVectorsList();
            builder.endObject();
    public void testFromXContent() throws IOException {
 * this work for additional information regarding copyright
        for (int i = 0; i < termsCount; i++) {
            List<String> usedFieldNames = new ArrayList<>(fieldsCount);
import org.opensearch.test.OpenSearchTestCase;
            score,
        }
/*  
        }
                    randomTermVector(fieldName, hasFieldStatistics, hasTermStatistics, hasScores, hasOffsets, hasPositions, hasPayloads)  
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
        boolean hasPositions,
                    builder.startArray("tokens");
                if (hasOffsets) {
        Long totalTermFreq = null;
        builder.endObject();  
        boolean hasOffsets,
        if (found) {
                builder.field("term_freq", term.getTermFreq());  
        String id = String.valueOf(randomIntBetween(1, 100));
                }  
            termFreq,
                    startOffset,  
            builder.startObject("term_vectors");
            boolean hasPositions = randomBoolean();  
    }
            long sumTotalTermFreq = randomNonNegativeLong();  
        }
        String termTxt,  
import java.io.IOException;
 * license agreements. See the NOTICE file distributed with
                    Collections.sort(
        boolean hasFieldStatistics,
            TermVectorsResponseTests::toXContent,  
import java.util.List;
                );
                    for (TermVectorsResponse.TermVector.Token token : tokens) {  
        TermVectorsResponse.TermVector.Term term = new TermVectorsResponse.TermVector.Term(
                if (hasPositions) position = randomInt(100);  
            builder.endObject();  
            docFreq,
        if (response.getId() != null) {
                Integer position = null;  
                    );
                tokens.add(token);
            Collections.sort(terms, Comparator.comparing(TermVectorsResponse.TermVector.Term::getTerm));
                if (hasPayloads) payload = "payload" + randomAlphaOfLength(2);
                    payload  
            builder.startObject("field_statistics");
        builder.field("found", response.getFound());
            builder.field("_id", response.getId());
            long sumDocFreq = randomNonNegativeLong();
            .test();
            usedTerms.add(termTxt);  
import java.util.ArrayList;
        builder.startObject(tv.getFieldName());
        boolean hasOffsets,  
            boolean hasTermStatistics = randomBoolean();  
                Integer startOffset = null;
 * not use this file except in compliance with the License.
                if (term.getScore() != null) builder.field("score", term.getScore());
        return tvresponse;
/*  
        List<String> usedTerms = new ArrayList<>(termsCount);  
                builder.endObject();
        xContentTester(  
                        if (token.getPosition() != null) builder.field("position", token.getPosition());
                        Comparator.comparing(TermVectorsResponse.TermVector.Token::getPosition, Comparator.nullsFirst(Integer::compareTo))
 * ownership. Elasticsearch licenses this file to you under  
        boolean hasTermStatistics,
    static void toXContent(TermVectorsResponse response, XContentBuilder builder) throws IOException {
        if (hasOffsets || hasPositions || hasPayloads) {  
                String payload = null;
        if (hasFieldStatistics) {  
                        if (token.getPayload() != null) builder.field("payload", token.getPayload());
        if (hasScores) score = randomFloat();
            this::createParser,
                // build tokens
        if (hasTermStatistics) {
 * compatible open source license.
 * under the License.  
            builder.field("doc_count", tv.getFieldStatistics().getDocCount());
 * the Apache License, Version 2.0 (the "License"); you may
            terms.add(randomTerm(termTxt, hasTermStatistics, hasScores, hasOffsets, hasPositions, hasPayloads));
                    endOffset = randomInt(2000);
        int termFreq = randomInt(10000);
                tvList.add(
            boolean hasScores = randomBoolean();
                        builder.endObject();  
            termTxt,  
            for (int i = 0; i < tokensCount; i++) {  
                toXContent(tv, builder);  
    }
        }  
                // build term_statistics  
        Integer docFreq = null;  
            for (int i = 0; i < fieldsCount; i++) {
            int docCount = randomInt(1000);
            String termTxt = randomValueOtherThanMany(usedTerms::contains, () -> randomAlphaOfLength(7));
        List<TermVectorsResponse.TermVector.Token> tokens = null;  
        long version = randomNonNegativeLong();  
            }  
            boolean hasPayloads = randomBoolean();
                            .thenComparing(TermVectorsResponse.TermVector.Token::getStartOffset, Comparator.nullsFirst(Integer::compareTo))
    private static TermVectorsResponse.TermVector randomTermVector(
 */  
            }
    }
        long tookInMillis = randomNonNegativeLong();
                usedFieldNames.add(fieldName);
        }
import java.util.Comparator;
            TermVectorsResponse::fromXContent
        TermVectorsResponse.TermVector.FieldStatistics fs = null;
        // build terms
import java.util.Collections;  
        List<TermVectorsResponse.TermVector.Term> terms = new ArrayList<>(termsCount);
            .randomFieldsExcludeFilter(field -> field.endsWith("term_vectors") || field.endsWith("terms") || field.endsWith("tokens"))  
        builder.startObject();
                if (tokens != null) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                TermVectorsResponse.TermVector.Token token = new TermVectorsResponse.TermVector.Token(
                    endOffset,
 * Unless required by applicable law or agreed to in writing,
        return tv;
        if (tv.getFieldStatistics() != null) {
                }
                if (term.getDocFreq() != null) builder.field("doc_freq", term.getDocFreq());
        // build fields_statistics  
}  
            Collections.sort(termVectorList, Comparator.comparing(TermVectorsResponse.TermVector::getFieldName));  
                    builder.endArray();
                        if (token.getEndOffset() != null) builder.field("end_offset", token.getEndOffset());
        boolean hasPayloads
            int fieldsCount = randomIntBetween(1, 3);
 */
        builder.field("_index", response.getIndex());  
            totalTermFreq,  
        ).supportsUnknownFields(true)
        String index = randomAlphaOfLength(5);
                List<TermVectorsResponse.TermVector.Token> tokens = term.getTokens();  
            docFreq = randomInt(1000);
 *  
            tokens = new ArrayList<>(tokensCount);
        builder.field("took", response.getTookInMillis());  
package org.opensearch.client.core;
                if (term.getTotalTermFreq() != null) builder.field("ttf", term.getTotalTermFreq());
        TermVectorsResponse tvresponse = new TermVectorsResponse(index, id, version, found, tookInMillis, tvList);
                        if (token.getStartOffset() != null) builder.field("start_offset", token.getStartOffset());  
 */  
/*
 * this file be licensed under the Apache-2.0 license or a
            int tokensCount = randomIntBetween(1, 5);
        }  
        TermVectorsResponse.TermVector tv = new TermVectorsResponse.TermVector(fieldName, fs, terms);
            boolean hasFieldStatistics = randomBoolean();
            builder.field("sum_ttf", tv.getFieldStatistics().getSumTotalTermFreq());
 * KIND, either express or implied.  See the License for the
