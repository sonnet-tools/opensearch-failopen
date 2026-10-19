 * GitHub history for details.
        if (!(obj instanceof TermVectorsResponse)) return false;
            private final Float score;  
        PARSER.declareNamedObjects(
             */
        return Objects.hash(index, id, docVersion, found, tookInMillis, termVectorList);
                (boolean) args[3],  
            @Override
    /**
            }
            private final long sumDocFreq;
 * The OpenSearch Contributors require contributions made to  
            public Integer getDocFreq() {
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
        this.found = found;
            @Nullable
                termVectorList
            this.terms = terms;
            }  
 * under the License.  
                    if (tokens != null) {
                Term other = (Term) obj;  
                return position;
            if (termVectorList != null) {
    private final boolean found;  
            /**  
        public boolean equals(Object obj) {
                    && Objects.equals(endOffset, other.endOffset)  
        static {  
                PARSER.declareString(optionalConstructorArg(), new ParseField("payload"));  
                (String) args[0],  
        }
         */
            private final Integer endOffset;  
                return termFreq;
     * Returns the document version  
    }  
            }
            }  
                return docCount;
                    List<Token> tokens = (List<Token>) args[4];  
    }  
                return new Token((Integer) args[0], (Integer) args[1], (Integer) args[2], (String) args[3]);  
             * Returns total term frequency - the number of times this term occurs across all documents  
             * Returns term frequency - the number of times this term occurs in the current document
            public long getSumTotalTermFreq() {
                this.endOffset = endOffset;
import org.opensearch.common.Nullable;
            }
            /**
             */
            return fieldName;
 * SPDX-License-Identifier: Apache-2.0
        this.index = index;
                this.termFreq = termFreq;  
                return term.equals(other.term)
            );
     */
                return Objects.equals(startOffset, other.startOffset)
                PARSER.declareInt(optionalConstructorArg(), new ParseField("start_offset"));  
                if (!(obj instanceof Token)) return false;  
            }  
             */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
         * Returns the list of terms for the current term vector
                this.docFreq = docFreq;
            static {  
 * Licensed to Elasticsearch under one or more contributor  
        public TermVector(String fieldName, FieldStatistics fieldStatistics, List<Term> terms) {
        @Nullable
        return termVectorList;
         * Returns the field name of the current term vector
             */
            @Nullable
                PARSER.declareInt(constructorArg(), new ParseField("term_freq"));
        public String getFieldName() {  
     */
            }  
            /**
        public static final class Term {
            }  
        private static final ConstructingObjectParser<TermVector, String> PARSER = new ConstructingObjectParser<>(
     * always <code>true</code> for artificial documents
        // Class containing a general field statistics for the field  
                return term;  
                    && Objects.equals(position, other.position)
                this.sumDocFreq = sumDocFreq;  
            public String getPayload() {
                    && Objects.equals(totalTermFreq, other.totalTermFreq)
            public Integer getStartOffset() {
                return startOffset;  
            public Integer getPosition() {
            && Objects.equals(id, other.id)
            private final Integer position;
        public int hashCode() {
    private final String index;  
             * Returns document frequency - the number of documents in the index that contain this term
        }  
             */
        return index;
             * Returns the string representation of the term  
            public long getSumDocFreq() {
            /**
    public boolean getFound() {
                return sumTotalTermFreq;  
             */
/*
            }  
             * Returns the sum of document frequencies for all terms in this field
                    && Objects.equals(docFreq, other.docFreq)  
    public boolean equals(Object obj) {  
            public int getDocCount() {  
            PARSER.declareObject(optionalConstructorArg(), (p, c) -> FieldStatistics.fromXContent(p), new ParseField("field_statistics"));
            private static final ConstructingObjectParser<Term, String> PARSER = new ConstructingObjectParser<>(  
        "term_vectors",
            private static final ConstructingObjectParser<FieldStatistics, Void> PARSER = new ConstructingObjectParser<>(  
            }
            public List<Token> getTokens() {
                List<Term> terms = (List<Term>) args[1];
            if (this == obj) return true;
    }
                @SuppressWarnings("unchecked")  
            public boolean equals(Object obj) {
     */  
                FieldStatistics other = (FieldStatistics) obj;
            && found == other.found
     * Returns the time that a request took in milliseconds
            private final Integer docFreq;
             * Returns the payload of the token or <code>null</code> if the payload doesn't exist  
            /**
            optionalConstructorArg(),
                    && Objects.equals(payload, other.payload);
                if (this == obj) return true;
                && Objects.equals(fieldStatistics, other.fieldStatistics)  
                true,
             */
             */
        }  
             */  
            public boolean equals(Object obj) {
                    && Objects.equals(tokens, other.tokens);  
            private final long sumTotalTermFreq;  
            @Override  
                PARSER.declareObjectArray(optionalConstructorArg(), (p, c) -> Token.fromXContent(p), new ParseField("tokens"));
            /**  
        PARSER.declareString(constructorArg(), new ParseField("_index"));
        private final FieldStatistics fieldStatistics;
            private final int docCount;
 * Modifications Copyright OpenSearch Contributors. See
                this.payload = payload;
        return index.equals(other.index)
            public String getTerm() {
                this.docCount = docCount;
            return fieldStatistics;  
            private final String term;
                this.score = score;  
 */  
             */  
            /**
            }
        );
            "term_vector",
import java.util.Comparator;
    public TermVectorsResponse(String index, String id, long version, boolean found, long tookInMillis, List<TermVector> termVectorList) {
    private final long tookInMillis;
 */
                return docCount == other.docCount && sumDocFreq == other.sumDocFreq && sumTotalTermFreq == other.sumTotalTermFreq;
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
 *
             * Returns tf-idf score, if the request used some form of terms filtering
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
            }  
    public long getTookInMillis() {  
             * Returns a list of tokens for the term
import java.util.List;
        }
 * ownership. Elasticsearch licenses this file to you under  
 *
    }
                this.startOffset = startOffset;
            && tookInMillis == other.tookInMillis
        public static final class FieldStatistics {
            // as the response comes from server, we are sure that args[5] will be a list of TermVector
            }
            this.fieldName = fieldName;  
/*  
                    return new FieldStatistics((long) args[0], (int) args[1], (long) args[2]);
                            Comparator.comparing(Token::getPosition, Comparator.nullsFirst(Integer::compareTo))
    public int hashCode() {
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;  
            return terms;
            private static final ConstructingObjectParser<Token, Void> PARSER = new ConstructingObjectParser<>("token", true, args -> {
            }  
                Token other = (Token) obj;
/*  
        );
            );  
                return PARSER.apply(parser, null);
    public long getDocVersion() {
                (args, ctxTerm) -> {  
            @Override  
            public int hashCode() {  
        PARSER.declareLong(constructorArg(), new ParseField("_version"));
        @Nullable  
            }  
                PARSER.declareLong(constructorArg(), new ParseField("sum_doc_freq"));  
                this.position = position;  
 * compatible open source license.
            });
                return Objects.hash(startOffset, endOffset, position, payload);
            return Objects.hash(fieldName, fieldStatistics, terms);  
    }
        PARSER.declareLong(constructorArg(), new ParseField("took"));  
                return score;
                                .thenComparing(Token::getEndOffset, Comparator.nullsFirst(Integer::compareTo))  
     */  
        PARSER.declareBoolean(constructorArg(), new ParseField("found"));
package org.opensearch.client.core;
                Collections.sort(termVectorList, Comparator.comparing(TermVector::getFieldName));  
            public Integer getEndOffset() {  
        public static TermVector fromXContent(XContentParser parser, String fieldName) {
     * Returns the id of the request
         */
        if (this == obj) return true;
            public int getTermFreq() {  
            public static FieldStatistics fromXContent(XContentParser parser) {
        public FieldStatistics getFieldStatistics() {
            private final Long totalTermFreq;
                this.sumTotalTermFreq = sumTotalTermFreq;
    /**
    }
     */
                (long) args[4],
            public Term(String term, int termFreq, Integer docFreq, Long totalTermFreq, Float score, List<Token> tokens) {
                (long) args[2],
            }  
 *  
            @SuppressWarnings("unchecked")  
                if (!(obj instanceof FieldStatistics)) return false;  
import java.util.Objects;  
 * this work for additional information regarding copyright
import org.opensearch.core.xcontent.ConstructingObjectParser;  
            /**
            private final Integer startOffset;
                if (this == obj) return true;
    public static final class TermVector {
        }
        /**
        this.termVectorList = termVectorList;
            private final int termFreq;  
public class TermVectorsResponse {
            return PARSER.apply(parser, fieldName);  
import org.opensearch.core.ParseField;
            }
        args -> {
     * Returns the index for the response
        /**  
    /**  
            }
 * license agreements. See the NOTICE file distributed with
                if (terms != null) {
                PARSER.declareInt(constructorArg(), new ParseField("doc_count"));
                && Objects.equals(terms, other.terms);
                PARSER.declareFloat(optionalConstructorArg(), new ParseField("score"));
        PARSER.declareString(optionalConstructorArg(), new ParseField("_id"));  
            }  
             * Returns the position of the token in the document's field
            if (!(obj instanceof TermVector)) return false;  
        }
        }
        }  
        true,  
    /**  
                return payload;  
        @Override  
                args -> {  
             * Returns the start offset of the token in the document's field  
             */  
            }
                        );
    }
                    // as the response comes from server, we are sure that args[4] will be a list of Token
            @Nullable
                PARSER.declareLong(optionalConstructorArg(), new ParseField("ttf"));  
         * Returns the field statistics for the current field  
            );  
                return PARSER.apply(parser, null);  
            }  
            /**
    @Override  
    /**  
            /**  
                PARSER.declareInt(optionalConstructorArg(), new ParseField("end_offset"));
                this.term = term;
            static {
             * Returns how many documents this field contains
            private final String payload;
     * Returns if the document is found
    }  
    private static final ConstructingObjectParser<TermVectorsResponse, Void> PARSER = new ConstructingObjectParser<>(
            @Nullable  
                "token",
    }
 */  
     * Returns the list of term vectors
        return id;  
    @Override
            @Nullable
            public Token(Integer startOffset, Integer endOffset, Integer position, String payload) {  
 * this file be licensed under the Apache-2.0 license or a
            public boolean equals(Object obj) {  
        public List<Term> getTerms() {
            @Nullable  
                }
                    }
            }
                true,
            @Override
                    return new Term(ctxTerm, (int) args[0], (Integer) args[1], (Long) args[2], (Float) args[3], tokens);  
    private final long docVersion;
             */
         */  
             * Returns the sum of total term frequencies of all terms in this field  
                return new TermVector(ctxFieldName, (FieldStatistics) args[0], terms);
                this.tokens = tokens;
                return endOffset;
                                .thenComparing(Token::getStartOffset, Comparator.nullsFirst(Integer::compareTo))
 * Unless required by applicable law or agreed to in writing,
            public static Token fromXContent(XContentParser parser) {
        @Override
        }  
        private final String fieldName;
 * software distributed under the License is distributed on an
            public int hashCode() {
    static {
                return totalTermFreq;  
            && docVersion == other.docVersion  
            && Objects.equals(termVectorList, other.termVectorList);  
                if (this == obj) return true;
 *    http://www.apache.org/licenses/LICENSE-2.0
    public List<TermVector> getTermVectorsList() {
            (args, ctxFieldName) -> {
                // as the response comes from server, we are sure that args[1] will be a list of Term
import java.util.Collections;  
                        Collections.sort(
            static {
    /**
        return docVersion;  
            @Override  
                    Collections.sort(terms, Comparator.comparing(Term::getTerm));  
    public String getId() {
    }
                (String) args[1],
            TermVector other = (TermVector) obj;
                "field_statistics",
            public Long getTotalTermFreq() {
            private final List<Token> tokens;
    public static TermVectorsResponse fromXContent(XContentParser parser) {
import org.opensearch.core.xcontent.XContentParser;
        this.docVersion = version;
            }
            }
                }
        return PARSER.apply(parser, null);  
        /**
            @Override
                PARSER.declareLong(constructorArg(), new ParseField("sum_ttf"));
                PARSER.declareInt(optionalConstructorArg(), new ParseField("position"));
            return new TermVectorsResponse(
            List<TermVector> termVectorList = (List<TermVector>) args[5];
     * can be NULL if there is no document ID  
        public static final class Token {  
        }
            @Nullable
                if (!(obj instanceof Term)) return false;
                return docFreq;
            public int hashCode() {  
 * You may obtain a copy of the License at  
            /**
    public String getIndex() {  
            new ParseField("term_vectors")
        this.id = id;  
                    && termFreq == other.termFreq
                return PARSER.apply(parser, term);
     */
                            tokens,  
            /**
                this.totalTermFreq = totalTermFreq;
            }
            }
                }
    }  
    }
}
            return fieldName.equals(other.fieldName)
        return found;
    private final String id;
            public Float getScore() {  
            this.fieldStatistics = fieldStatistics;
            @Nullable  
            public FieldStatistics(long sumDocFreq, int docCount, long sumTotalTermFreq) {
                return Objects.hash(term, termFreq, docFreq, totalTermFreq, score, tokens);
                    @SuppressWarnings("unchecked")
                return Objects.hash(docCount, sumDocFreq, sumTotalTermFreq);
        }  
                return sumDocFreq;
            }
                return tokens;
    );
            PARSER.declareNamedObjects(optionalConstructorArg(), (p, c, term) -> Term.fromXContent(p, term), new ParseField("terms"));
        private final List<Term> terms;  
            }
    private final List<TermVector> termVectorList;
        return tookInMillis;
                    && Objects.equals(score, other.score)
            /*  
        this.tookInMillis = tookInMillis;  
            }
            public static Term fromXContent(XContentParser parser, String term) {
            (p, c, fieldName) -> TermVector.fromXContent(p, fieldName),  
             */  
            true,  
             * Returns the end offset of the token in the document's field
        }
        TermVectorsResponse other = (TermVectorsResponse) obj;  
                PARSER.declareInt(optionalConstructorArg(), new ParseField("doc_freq"));
            }  
