 * not use this file except in compliance with the License.
        out.writeDouble(unigramLambda);
     * @param unigramLambda
     *            the bigram lambda
                realWordLikelihood,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return this.trigramLambda;
import org.apache.lucene.index.Terms;
        return new LinearInterpolation(trigramLambda, bigramLambda, unigramLambda);
                );
     * Note: the lambdas must sum up to one.
    }
                separator,
import org.apache.lucene.util.BytesRef;
            double realWordLikelihood,
        builder.field(TRIGRAM_FIELD.getPreferredName(), trigramLambda);
        final LinearInterpolation otherModel = (LinearInterpolation) other;
 * ownership. Elasticsearch licenses this file to you under
import org.apache.lucene.index.IndexReader;
 *    http://www.apache.org/licenses/LICENSE-2.0
    public LinearInterpolation(StreamInput in) throws IOException {
    }
     */
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.common.ParsingException;
                    bigramLambda = parser.doubleValue();
     * Creates a linear interpolation smoothing model.
        double trigramLambda = 0.0;
        this.trigramLambda = trigramLambda;
                    trigramLambda = parser.doubleValue();
            }
    protected int doHashCode() {
        double sum = trigramLambda + bigramLambda + unigramLambda;
        double bigramLambda = 0.0;
                } else if (BIGRAM_FIELD.match(fieldName, parser.getDeprecationHandler())) {
import org.opensearch.core.xcontent.XContentParser;
    }
     * @param bigramLambda
            IndexReader reader,
        this.bigramLambda = bigramLambda;
        return Objects.hash(trigramLambda, bigramLambda, unigramLambda);
    }
    public LinearInterpolation(double trigramLambda, double bigramLambda, double unigramLambda) {
/**
    @Override
 * SPDX-License-Identifier: Apache-2.0
            && Objects.equals(unigramLambda, otherModel.unigramLambda);
 *
 * GitHub history for details.
/*
    }
 * See <a
    /**
        while ((token = parser.nextToken()) != Token.END_OBJECT) {
                    }
 * @opensearch.internal
        return Objects.equals(trigramLambda, otherModel.trigramLambda)
                    "[" + NAME + "] unknown token [" + token + "] after [" + fieldName + "]"
        bigramLambda = in.readDouble();
 * </p>
public final class LinearInterpolation extends SmoothingModel {
    public double getTrigramLambda() {
import org.opensearch.core.xcontent.XContentBuilder;
 * KIND, either express or implied.  See the License for the
    @Override
import org.opensearch.core.ParseField;
    public String getWriteableName() {
    private static final ParseField TRIGRAM_FIELD = new ParseField("trigram_lambda");
    public static LinearInterpolation fromXContent(XContentParser parser) throws IOException {
                        throw new IllegalArgumentException("bigram_lambda must be positive");
    @Override
        unigramLambda = in.readDouble();
                bigramLambda,
 * the Apache License, Version 2.0 (the "License"); you may
        }
 */
                } else {
                field,
    public WordScorerFactory buildWordScorerFactory() {
     * <p>
import java.io.IOException;
        String fieldName = null;
            String field,
 * You may obtain a copy of the License at
 * Linear interpolation smoothing model.
 * href="http://en.wikipedia.org/wiki/N-gram#Smoothing_techniques">N-Gram
 * Licensed to Elasticsearch under one or more contributor
                    if (bigramLambda < 0) {
                trigramLambda,
 * The OpenSearch Contributors require contributions made to
/*
     * @param trigramLambda
                    if (trigramLambda < 0) {
    @Override
     *            the trigram lambda
                terms,
                reader,
            BytesRef separator) -> new LinearInterpolatingScorer(
    @Override
        return NAME;
    protected XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
                fieldName = parser.currentName();
    }
     *
    private static final ParseField UNIGRAM_FIELD = new ParseField("unigram_lambda");
        out.writeDouble(bigramLambda);
    protected boolean doEquals(SmoothingModel other) {
                } else if (UNIGRAM_FIELD.match(fieldName, parser.getDeprecationHandler())) {
            );
        trigramLambda = in.readDouble();
        return this.unigramLambda;
    @Override
            } else if (token.isValue()) {
 * <p>
        if (Math.abs(sum - 1.0) > 0.001) {
            if (token == XContentParser.Token.FIELD_NAME) {
        return builder;
            Terms terms,
                unigramLambda
            } else {
/*
    private final double unigramLambda;
        builder.field(BIGRAM_FIELD.getPreferredName(), bigramLambda);
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
                    throw new IllegalArgumentException("suggester[phrase][smoothing][linear] doesn't support field [" + fieldName + "]");
import org.opensearch.core.xcontent.XContentParser.Token;
                }
     *            the unigram lambda
    }
 *
    public static final String NAME = "linear";
import org.opensearch.search.suggest.phrase.WordScorer.WordScorerFactory;
 * specific language governing permissions and limitations
                        throw new IllegalArgumentException("trigram_lambda must be positive");
     */
                    unigramLambda = parser.doubleValue();
        this.unigramLambda = unigramLambda;
                    if (unigramLambda < 0) {
            throw new IllegalArgumentException("linear smoothing lambdas must sum to 1");
                if (TRIGRAM_FIELD.match(fieldName, parser.getDeprecationHandler())) {
import org.opensearch.core.common.io.stream.StreamOutput;
    public double getBigramLambda() {
    }
 * this work for additional information regarding copyright
    private final double trigramLambda;
     * Read from a stream.
        out.writeDouble(trigramLambda);
        }
        double unigramLambda = 0.0;
                throw new ParsingException(
 */
                        throw new IllegalArgumentException("unigram_lambda must be positive");
    private final double bigramLambda;
 *
        return this.bigramLambda;
 * license agreements. See the NOTICE file distributed with
    public double getUnigramLambda() {
    }
    }
    }
            && Objects.equals(bigramLambda, otherModel.bigramLambda)
package org.opensearch.search.suggest.phrase;
 * this file be licensed under the Apache-2.0 license or a
        builder.field(UNIGRAM_FIELD.getPreferredName(), unigramLambda);
    public void writeTo(StreamOutput out) throws IOException {
import java.util.Objects;
                    }
}
 * under the License.
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
    /**
 *
 * Smoothing</a> for details.
 */
    private static final ParseField BIGRAM_FIELD = new ParseField("bigram_lambda");
                    }
    static final ParseField PARSE_FIELD = new ParseField(NAME);
        return (
        XContentParser.Token token;
    }
                    parser.getTokenLocation(),
 */
