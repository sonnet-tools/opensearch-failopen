    protected int doHashCode() {
        discount = in.readDouble();
    private static final ParseField DISCOUNT_FIELD = new ParseField("discount");  
        StupidBackoff otherModel = (StupidBackoff) other;
        String fieldName = null;
    public StupidBackoff(StreamInput in) throws IOException {  
                fieldName = parser.currentName();
                discount = parser.doubleValue();
 *    http://www.apache.org/licenses/LICENSE-2.0
            }  
        return Objects.hash(discount);
            field,
import org.opensearch.core.common.io.stream.StreamInput;
 * this work for additional information regarding copyright
 */  
import org.opensearch.core.ParseField;
 * not use this file except in compliance with the License.
    public StupidBackoff(double discount) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        double discount = DEFAULT_BACKOFF_DISCOUNT;
/*  
    public double getDiscount() {  
            }  
    @Override  
     */  
import java.io.IOException;  
    public WordScorerFactory buildWordScorerFactory() {  
        builder.field(DISCOUNT_FIELD.getPreferredName(), discount);  
 * The OpenSearch Contributors require contributions made to  
            if (token == XContentParser.Token.FIELD_NAME) {
    @Override
/**  
    }
 * the Apache License, Version 2.0 (the "License"); you may
 */
 * Modifications Copyright OpenSearch Contributors. See
/*
import org.opensearch.core.common.io.stream.StreamOutput;  
 *
 * this file be licensed under the Apache-2.0 license or a
    }
    @Override
    /**
 *
    protected boolean doEquals(SmoothingModel other) {
        return new StupidBackoff(discount);
    /**  
import org.apache.lucene.util.BytesRef;  
        return (IndexReader reader, Terms terms, String field, double realWordLikelihood, BytesRef separator) -> new StupidBackoffScorer(
    static final ParseField PARSE_FIELD = new ParseField(NAME);
 * href="http://en.wikipedia.org/wiki/Katz's_back-off_model"> Katz's
        out.writeDouble(discount);  
    }  
            realWordLikelihood,
     *            the discount given to lower order ngrams if the higher order ngram doesn't exits  
     * @param discount
public final class StupidBackoff extends SmoothingModel {  
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.XContentParser.Token;  
import org.apache.lucene.index.Terms;
        return this.discount;
 * @opensearch.internal
 * Smoothing</a> for details.
        return Objects.equals(discount, otherModel.discount);  
import java.util.Objects;
     *
 * under the License.  
    }
    public static final String NAME = "stupid_backoff";
    public static SmoothingModel fromXContent(XContentParser parser) throws IOException {
    }
 * Backoff</a>. This model is used as the default if no model is configured.  
import org.opensearch.core.xcontent.XContentBuilder;
    public static final double DEFAULT_BACKOFF_DISCOUNT = 0.4;
package org.opensearch.search.suggest.phrase;
 * KIND, either express or implied.  See the License for the
 *  
     * Default discount parameter for {@link StupidBackoff} smoothing
            reader,
import org.opensearch.search.suggest.phrase.WordScorer.WordScorerFactory;
     * Read from a stream.
/*  
 * <p>
        }
 */
    @Override  
    /**  
 * SPDX-License-Identifier: Apache-2.0
 */  
            separator,  
    }
 * You may obtain a copy of the License at  
}
        this.discount = discount;  
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
     */
    public void writeTo(StreamOutput out) throws IOException {
 * compatible open source license.
        return NAME;  
     * Creates a Stupid-Backoff smoothing model.  
            discount
            terms,  
            if (token.isValue() && DISCOUNT_FIELD.match(fieldName, parser.getDeprecationHandler())) {
    /**
        return builder;
    }
    }  
    }  
        while ((token = parser.nextToken()) != Token.END_OBJECT) {  
        );
 *  
        XContentParser.Token token;  
    private double discount = DEFAULT_BACKOFF_DISCOUNT;  
import org.opensearch.core.xcontent.XContentParser;
 * A "stupid-backoff" smoothing model similar to <a
 * href="http://en.wikipedia.org/wiki/N-gram#Smoothing_techniques">N-Gram  
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.index.IndexReader;
     */
    protected XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
    }
 * </p>
     */
    @Override
 * See <a
     * @return the discount parameter of the model
    public String getWriteableName() {
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
    @Override
