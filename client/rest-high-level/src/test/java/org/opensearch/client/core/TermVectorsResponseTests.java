            termTxt,
import java.io.IOException;
        boolean hasScores,
        List<TermVectorsResponse.TermVector.Token> tokens = null;
    ) {
                String fieldName = randomValueOtherThanMany(usedFieldNames::contains, () -> randomAlphaOfLength(7));
                    );
 * software distributed under the License is distributed on an
                String payload = null;
                if (hasPositions) position = randomInt(100);
    public void testFromXContent() throws IOException {
        }
        List<TermVectorsResponse.TermVector.Term> terms = new ArrayList<>(termsCount);
    }
                        if (token.getEndOffset() != null) builder.field("end_offset", token.getEndOffset());
            for (TermVectorsResponse.TermVector.Term term : terms) {
            Collections.sort(termVectorList, Comparator.comparing(TermVectorsResponse.TermVector::getFieldName));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (found) {
            usedTerms.add(termTxt);
        boolean hasFieldStatistics,
 * You may obtain a copy of the License at
            Collections.sort(terms, Comparator.comparing(TermVectorsResponse.TermVector.Term::getTerm));
                );
 */
            .test();
        }
        boolean hasPayloads
            }
        ).supportsUnknownFields(true)
        }
            }
                if (hasPayloads) payload = "payload" + randomAlphaOfLength(2);
                Integer startOffset = null;
            builder.field("sum_ttf", tv.getFieldStatistics().getSumTotalTermFreq());
    }
                if (hasOffsets) {
        boolean hasScores,
        return tv;
                usedFieldNames.add(fieldName);
 * the Apache License, Version 2.0 (the "License"); you may
        builder.startObject(tv.getFieldName());
        Integer docFreq = null;
                List<TermVectorsResponse.TermVector.Token> tokens = term.getTokens();
        int termFreq = randomInt(10000);
    static TermVectorsResponse createTestInstance() {
            fs = new TermVectorsResponse.TermVector.FieldStatistics(sumDocFreq, docCount, sumTotalTermFreq);
            tokens = new ArrayList<>(tokensCount);
            int docCount = randomInt(1000);
    ) {
        TermVectorsResponse.TermVector.FieldStatistics fs = null;
        List<String> usedTerms = new ArrayList<>(termsCount);
/*
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.test.OpenSearchTestCase;
            long sumDocFreq = randomNonNegativeLong();
        builder.field("_version", response.getDocVersion());
        // build terms
package org.opensearch.client.core;
    }
            .randomFieldsExcludeFilter(field -> field.endsWith("term_vectors") || field.endsWith("terms") || field.endsWith("tokens"))
                TermVectorsResponse.TermVector.Token token = new TermVectorsResponse.TermVector.Token(
        if (tv.getFieldStatistics() != null) {
        }
        Long totalTermFreq = null;
        Float score = null;
            boolean hasPositions = randomBoolean();
                    position,
    }
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
                    endOffset = randomInt(2000);
        // build fields_statistics
                    Collections.sort(
                    }
import java.util.List;
        if (hasFieldStatistics) {
        List<TermVectorsResponse.TermVector> tvList = null;
        }
        xContentTester(
            TermVectorsResponseTests::toXContent,
    }
 *
        builder.endObject();
            boolean hasTermStatistics = randomBoolean();
            int fieldsCount = randomIntBetween(1, 3);
            for (int i = 0; i < tokensCount; i++) {
                }
            for (TermVectorsResponse.TermVector tv : termVectorList) {
 * this file be licensed under the Apache-2.0 license or a
        if (termVectorList != null) {
            List<String> usedFieldNames = new ArrayList<>(fieldsCount);
    private static TermVectorsResponse.TermVector randomTermVector(
        if (terms != null) {
 *
                        tokens,
            terms.add(randomTerm(termTxt, hasTermStatistics, hasScores, hasOffsets, hasPositions, hasPayloads));
                builder.field("term_freq", term.getTermFreq());
        boolean hasTermStatistics,
        if (response.getId() != null) {
        builder.field("took", response.getTookInMillis());
                tokens.add(token);
            builder.endObject();
 * GitHub history for details.
            boolean hasOffsets = randomBoolean();
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
            long sumTotalTermFreq = randomNonNegativeLong();
 */
            boolean hasPayloads = randomBoolean();
                );
                }
    static void toXContent(TermVectorsResponse response, XContentBuilder builder) throws IOException {
                    for (TermVectorsResponse.TermVector.Token token : tokens) {
                // build tokens
            builder.field("doc_count", tv.getFieldStatistics().getDocCount());
                        builder.startObject();
        boolean hasOffsets,
            termFreq,
            builder.endObject();
        builder.field("found", response.getFound());
                toXContent(tv, builder);
                    endOffset,
        TermVectorsResponse.TermVector tv = new TermVectorsResponse.TermVector(fieldName, fs, terms);
            totalTermFreq = randomNonNegativeLong();
 * compatible open source license.
                builder.endObject();
        String fieldName,
        if (hasOffsets || hasPositions || hasPayloads) {
        String id = String.valueOf(randomIntBetween(1, 100));
 * SPDX-License-Identifier: Apache-2.0
        }
import java.util.Comparator;
        long tookInMillis = randomNonNegativeLong();
    private static TermVectorsResponse.TermVector.Term randomTerm(
            docFreq = randomInt(1000);
                if (term.getDocFreq() != null) builder.field("doc_freq", term.getDocFreq());
                    randomTermVector(fieldName, hasFieldStatistics, hasTermStatistics, hasScores, hasOffsets, hasPositions, hasPayloads)
 */
            builder.field("_id", response.getId());
import java.util.ArrayList;
            }
                        builder.endObject();
        List<TermVectorsResponse.TermVector.Term> terms = tv.getTerms();
        boolean hasPayloads
 *
        if (hasScores) score = randomFloat();
                // build term_statistics
        return tvresponse;
                    builder.startArray("tokens");
            builder.startObject("term_vectors");
            }
            builder.startObject("terms");
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
    private static void toXContent(TermVectorsResponse.TermVector tv, XContentBuilder builder) throws IOException {
        for (int i = 0; i < termsCount; i++) {
        }
            for (int i = 0; i < fieldsCount; i++) {
        boolean hasPositions,
                        if (token.getStartOffset() != null) builder.field("start_offset", token.getStartOffset());
import static org.opensearch.test.AbstractXContentTestCase.xContentTester;
        boolean hasPositions,
    }
 * not use this file except in compliance with the License.
            tokens
                    startOffset,
            String termTxt = randomValueOtherThanMany(usedTerms::contains, () -> randomAlphaOfLength(7));
        boolean hasTermStatistics,
                    startOffset = randomInt(1000);
                builder.startObject(term.getTerm());
            tvList = new ArrayList<>(fieldsCount);
            int tokensCount = randomIntBetween(1, 5);
            builder.endObject();
            this::createParser,
                        Comparator.comparing(TermVectorsResponse.TermVector.Token::getPosition, Comparator.nullsFirst(Integer::compareTo))
            TermVectorsResponse::fromXContent
            TermVectorsResponseTests::createTestInstance,
                    payload
                    builder.endArray();
public class TermVectorsResponseTests extends OpenSearchTestCase {
                        if (token.getPayload() != null) builder.field("payload", token.getPayload());
            builder.field("sum_doc_freq", tv.getFieldStatistics().getSumDocFreq());
                Integer endOffset = null;
        return term;
                if (tokens != null) {
                tvList.add(
import org.opensearch.core.xcontent.XContentBuilder;
 * ownership. Elasticsearch licenses this file to you under
        String index = randomAlphaOfLength(5);
        }
import java.util.Collections;
        );
            docFreq,
        builder.field("_index", response.getIndex());
            boolean hasFieldStatistics = randomBoolean();
        builder.startObject();
            builder.startObject("field_statistics");
                if (term.getTotalTermFreq() != null) builder.field("ttf", term.getTotalTermFreq());
        List<TermVectorsResponse.TermVector> termVectorList = response.getTermVectorsList();
                if (term.getScore() != null) builder.field("score", term.getScore());
                            .thenComparing(TermVectorsResponse.TermVector.Token::getEndOffset, Comparator.nullsFirst(Integer::compareTo))
/*
 * this work for additional information regarding copyright
        }
            boolean hasScores = randomBoolean();
 * The OpenSearch Contributors require contributions made to
        builder.endObject();
        String termTxt,
        boolean found = randomBoolean();
        int termsCount = randomIntBetween(1, 5);
                Integer position = null;
}
        TermVectorsResponse.TermVector.Term term = new TermVectorsResponse.TermVector.Term(
 * under the License.
        if (hasTermStatistics) {
 * Unless required by applicable law or agreed to in writing,
                        if (token.getPosition() != null) builder.field("position", token.getPosition());
        boolean hasOffsets,
        long version = randomNonNegativeLong();
            score,
        TermVectorsResponse tvresponse = new TermVectorsResponse(index, id, version, found, tookInMillis, tvList);
                            .thenComparing(TermVectorsResponse.TermVector.Token::getStartOffset, Comparator.nullsFirst(Integer::compareTo))
            totalTermFreq,
