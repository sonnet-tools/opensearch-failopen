        // Class containing a general field statistics for the field
    @Override
    public String getId() {
         */
        return tookInMillis;
        static {
            public int getDocCount() {
            @Nullable
 * SPDX-License-Identifier: Apache-2.0
    /**
                (long) args[4],
            }
            }
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
    }
            }
                this.termFreq = termFreq;
                PARSER.declareInt(constructorArg(), new ParseField("term_freq"));
            }
             * Returns the sum of document frequencies for all terms in this field
         * Returns the field statistics for the current field
            @Override
                true,
            public Float getScore() {
                PARSER.declareLong(constructorArg(), new ParseField("sum_doc_freq"));
        private final List<Term> terms;
        @Nullable
package org.opensearch.client.core;
        PARSER.declareBoolean(constructorArg(), new ParseField("found"));
                return Objects.hash(docCount, sumDocFreq, sumTotalTermFreq);
                PARSER.declareString(optionalConstructorArg(), new ParseField("payload"));
                FieldStatistics other = (FieldStatistics) obj;
     */
            public Integer getDocFreq() {
             */
    }
            return fieldStatistics;
            static {
                this.score = score;
                return docCount == other.docCount && sumDocFreq == other.sumDocFreq && sumTotalTermFreq == other.sumTotalTermFreq;
import org.opensearch.core.xcontent.XContentParser;
        PARSER.declareLong(constructorArg(), new ParseField("took"));
                this.tokens = tokens;
            public boolean equals(Object obj) {
                    }
            /**
        this.docVersion = version;
        private final FieldStatistics fieldStatistics;
            }
            (p, c, fieldName) -> TermVector.fromXContent(p, fieldName),
            this.fieldName = fieldName;
    }
        );
             */
    public int hashCode() {
                    && termFreq == other.termFreq
             */
            public Integer getStartOffset() {
            }
                return startOffset;
                    return new FieldStatistics((long) args[0], (int) args[1], (long) args[2]);
            }
            @Nullable
            }
            return PARSER.apply(parser, fieldName);
                this.sumDocFreq = sumDocFreq;
            new ParseField("term_vectors")
 * You may obtain a copy of the License at
            public static FieldStatistics fromXContent(XContentParser parser) {
            });
            /**
            }
            /*
    }
/*
 * specific language governing permissions and limitations
        }
 *
    /**
             * Returns the sum of total term frequencies of all terms in this field
         * Returns the list of terms for the current term vector
            @Override
                return docFreq;
            @Nullable
 * The OpenSearch Contributors require contributions made to
    public long getDocVersion() {
        @Override
    private final List<TermVector> termVectorList;
            return fieldName;
            public FieldStatistics(long sumDocFreq, int docCount, long sumTotalTermFreq) {
     */
            }
        @Nullable
        /**
                PARSER.declareLong(constructorArg(), new ParseField("sum_ttf"));
                return PARSER.apply(parser, term);
                return term.equals(other.term)
                this.docFreq = docFreq;
            private final Long totalTermFreq;
 * Modifications Copyright OpenSearch Contributors. See
        return found;
 * software distributed under the License is distributed on an
            }
        public String getFieldName() {
    private final long docVersion;
    private final String index;
    public static TermVectorsResponse fromXContent(XContentParser parser) {
    }
    public boolean getFound() {
            private static final ConstructingObjectParser<Token, Void> PARSER = new ConstructingObjectParser<>("token", true, args -> {
            }
        private final String fieldName;
import java.util.List;
        public static final class Term {
             * Returns term frequency - the number of times this term occurs in the current document
            public long getSumDocFreq() {
        }
            PARSER.declareObject(optionalConstructorArg(), (p, c) -> FieldStatistics.fromXContent(p), new ParseField("field_statistics"));
            @Override
                    && Objects.equals(endOffset, other.endOffset)
 * the Apache License, Version 2.0 (the "License"); you may
        true,
 * this work for additional information regarding copyright
            && docVersion == other.docVersion
        );
                    Collections.sort(terms, Comparator.comparing(Term::getTerm));
                return Objects.hash(startOffset, endOffset, position, payload);
            /**
            @Nullable
                if (!(obj instanceof Term)) return false;
     */
     * Returns the time that a request took in milliseconds
 * under the License.
                return position;
                && Objects.equals(fieldStatistics, other.fieldStatistics)
            }
                List<Term> terms = (List<Term>) args[1];
            if (!(obj instanceof TermVector)) return false;
                PARSER.declareFloat(optionalConstructorArg(), new ParseField("score"));
                Term other = (Term) obj;
                this.position = position;
/*
                return Objects.equals(startOffset, other.startOffset)
                    // as the response comes from server, we are sure that args[4] will be a list of Token
         */
                return docCount;
            );
             */
            optionalConstructorArg(),
            && tookInMillis == other.tookInMillis
            /**
            private final Integer startOffset;
             * Returns the string representation of the term
            private final Integer docFreq;
            );
             * Returns how many documents this field contains
                this.endOffset = endOffset;
                return payload;
        @Override
                (String) args[0],
            private final int termFreq;
                (args, ctxTerm) -> {
        "term_vectors",
            public long getSumTotalTermFreq() {
                @SuppressWarnings("unchecked")
                    && Objects.equals(docFreq, other.docFreq)
             * Returns the position of the token in the document's field
                "field_statistics",
                    return new Term(ctxTerm, (int) args[0], (Integer) args[1], (Long) args[2], (Float) args[3], tokens);
                if (!(obj instanceof Token)) return false;
        TermVectorsResponse other = (TermVectorsResponse) obj;
            public String getPayload() {
 * GitHub history for details.
            }
                if (terms != null) {
     * can be NULL if there is no document ID
        return id;
            private final int docCount;
                return tokens;
                // as the response comes from server, we are sure that args[1] will be a list of Term
                return Objects.hash(term, termFreq, docFreq, totalTermFreq, score, tokens);
        PARSER.declareString(constructorArg(), new ParseField("_index"));
            public Integer getEndOffset() {
            /**
        /**
             * Returns a list of tokens for the term
            static {
            return fieldName.equals(other.fieldName)
                    && Objects.equals(tokens, other.tokens);
             * Returns the end offset of the token in the document's field
 */
        return docVersion;
     * Returns the list of term vectors
        public boolean equals(Object obj) {
 */
            public int hashCode() {
                this.startOffset = startOffset;
        private static final ConstructingObjectParser<TermVector, String> PARSER = new ConstructingObjectParser<>(
            private final Float score;
                return sumDocFreq;
                return endOffset;
                return PARSER.apply(parser, null);
                this.payload = payload;
 * this file be licensed under the Apache-2.0 license or a
 *
    private final boolean found;
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor
             * Returns document frequency - the number of documents in the index that contain this term
            @Override
            PARSER.declareNamedObjects(optionalConstructorArg(), (p, c, term) -> Term.fromXContent(p, term), new ParseField("terms"));
     * Returns if the document is found
/*
            private final String payload;
     */
                Collections.sort(termVectorList, Comparator.comparing(TermVector::getFieldName));
                Token other = (Token) obj;
                PARSER.declareInt(optionalConstructorArg(), new ParseField("end_offset"));
            private final Integer endOffset;
            public boolean equals(Object obj) {
        public TermVector(String fieldName, FieldStatistics fieldStatistics, List<Term> terms) {
        }
                    && Objects.equals(totalTermFreq, other.totalTermFreq)
    }
                return totalTermFreq;
public class TermVectorsResponse {
                PARSER.declareInt(optionalConstructorArg(), new ParseField("position"));
            @Override
                PARSER.declareInt(optionalConstructorArg(), new ParseField("doc_freq"));
                            tokens,
                this.sumTotalTermFreq = sumTotalTermFreq;
            }
        return PARSER.apply(parser, null);
            }
            }
        this.termVectorList = termVectorList;
                if (!(obj instanceof FieldStatistics)) return false;
            /**
         */
        public static final class Token {
    public static final class TermVector {
        return Objects.hash(index, id, docVersion, found, tookInMillis, termVectorList);
     * Returns the document version
             */
 * Unless required by applicable law or agreed to in writing,
    /**
        }
                if (this == obj) return true;
        }
import org.opensearch.core.ParseField;
                termVectorList
            if (termVectorList != null) {
            true,
                }
            public int hashCode() {
                this.totalTermFreq = totalTermFreq;
    }
            @Nullable
    public long getTookInMillis() {
            public List<Token> getTokens() {
            /**
                return termFreq;
            }
        if (this == obj) return true;
    @Override
            @Nullable
 */
            public int hashCode() {
    }
        /**
        return index.equals(other.index)
             * Returns tf-idf score, if the request used some form of terms filtering
        PARSER.declareString(optionalConstructorArg(), new ParseField("_id"));
             */
                return PARSER.apply(parser, null);
                return sumTotalTermFreq;
        public static final class FieldStatistics {
            public Token(Integer startOffset, Integer endOffset, Integer position, String payload) {
             */
    /**
        public static TermVector fromXContent(XContentParser parser, String fieldName) {
            private final List<Token> tokens;
import org.opensearch.common.Nullable;
            TermVector other = (TermVector) obj;
 * ownership. Elasticsearch licenses this file to you under
            (args, ctxFieldName) -> {
 * compatible open source license.
            /**
            public static Token fromXContent(XContentParser parser) {
                (boolean) args[3],
                (String) args[1],
            }
                "token",
import org.opensearch.core.xcontent.ConstructingObjectParser;
import java.util.Comparator;
            return terms;
            public Term(String term, int termFreq, Integer docFreq, Long totalTermFreq, Float score, List<Token> tokens) {
            public Integer getPosition() {
                    @SuppressWarnings("unchecked")
            private final long sumDocFreq;
        }
            }
            }
    static {
        return termVectorList;
                PARSER.declareInt(constructorArg(), new ParseField("doc_count"));
            /**
            );
     * Returns the id of the request
                if (this == obj) return true;
                PARSER.declareObjectArray(optionalConstructorArg(), (p, c) -> Token.fromXContent(p), new ParseField("tokens"));
    }
                (long) args[2],
                && Objects.equals(terms, other.terms);
        PARSER.declareNamedObjects(
                    && Objects.equals(position, other.position)
            @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
            /**
             */
        }
import java.util.Objects;
                    List<Token> tokens = (List<Token>) args[4];
            private final long sumTotalTermFreq;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
             * Returns the start offset of the token in the document's field
    private final String id;
                this.docCount = docCount;
                return new Token((Integer) args[0], (Integer) args[1], (Integer) args[2], (String) args[3]);
            return Objects.hash(fieldName, fieldStatistics, terms);
                        );
        }
            public boolean equals(Object obj) {
            public static Term fromXContent(XContentParser parser, String term) {
    }
             * Returns the payload of the token or <code>null</code> if the payload doesn't exist
            private static final ConstructingObjectParser<Term, String> PARSER = new ConstructingObjectParser<>(
    /**
        }
        }
                            Comparator.comparing(Token::getPosition, Comparator.nullsFirst(Integer::compareTo))
                                .thenComparing(Token::getEndOffset, Comparator.nullsFirst(Integer::compareTo))
     */
                    && Objects.equals(score, other.score)
            return new TermVectorsResponse(
                                .thenComparing(Token::getStartOffset, Comparator.nullsFirst(Integer::compareTo))
                    && Objects.equals(payload, other.payload);
            }
        public List<Term> getTerms() {
import java.util.Collections;
            }
             * Returns total term frequency - the number of times this term occurs across all documents
            }
                return score;
                }
 * license agreements. See the NOTICE file distributed with
            // as the response comes from server, we are sure that args[5] will be a list of TermVector
}
    /**
            }
     * Returns the index for the response
    private static final ConstructingObjectParser<TermVectorsResponse, Void> PARSER = new ConstructingObjectParser<>(
            "term_vector",
                PARSER.declareLong(optionalConstructorArg(), new ParseField("ttf"));
    }
             */
        return index;
                this.term = term;
            public int getTermFreq() {
            public Long getTotalTermFreq() {
        this.index = index;
            @Nullable
            @SuppressWarnings("unchecked")
        args -> {
                PARSER.declareInt(optionalConstructorArg(), new ParseField("start_offset"));
            this.fieldStatistics = fieldStatistics;
                true,
         * Returns the field name of the current term vector
        public int hashCode() {
            }
        this.tookInMillis = tookInMillis;
            }
            static {
 * KIND, either express or implied.  See the License for the
            private static final ConstructingObjectParser<FieldStatistics, Void> PARSER = new ConstructingObjectParser<>(
            this.terms = terms;
             */
        }
            }
                args -> {
            @Nullable
            }
            && Objects.equals(id, other.id)
    public List<TermVector> getTermVectorsList() {
            && Objects.equals(termVectorList, other.termVectorList);
                if (this == obj) return true;
        this.id = id;
        }
    public TermVectorsResponse(String index, String id, long version, boolean found, long tookInMillis, List<TermVector> termVectorList) {
            /**
    private final long tookInMillis;
            private final Integer position;
        PARSER.declareLong(constructorArg(), new ParseField("_version"));
        this.found = found;
    public String getIndex() {
        public FieldStatistics getFieldStatistics() {
     */
             */
                return new TermVector(ctxFieldName, (FieldStatistics) args[0], terms);
     * always <code>true</code> for artificial documents
            }
                        Collections.sort(
    }
                }
            /**
             */
            private final String term;
                    if (tokens != null) {
            if (this == obj) return true;
            && found == other.found
    );
            public String getTerm() {
        if (!(obj instanceof TermVectorsResponse)) return false;
             */
            List<TermVector> termVectorList = (List<TermVector>) args[5];
    public boolean equals(Object obj) {
                return term;
