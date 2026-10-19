     */
 * this work for additional information regarding copyright
        );
        XContentParser.Token token;  
    public void writeTo(StreamOutput out) throws IOException {
        return builder;
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
 * @opensearch.internal  
import org.opensearch.core.common.io.stream.StreamInput;
            realWordLikelihood,
 * You may obtain a copy of the License at  
import org.opensearch.core.xcontent.XContentParser.Token;  
 *
 * Smoothing</a> for details.  
/*  
        return Objects.equals(alpha, otherModel.alpha);  
    }
    }  
        this.alpha = alpha;  
                fieldName = parser.currentName();
 */
            separator,  
package org.opensearch.search.suggest.phrase;
    /**
    /**  
            alpha
 * See <a
     */
     */
import java.io.IOException;  
            if (token.isValue() && ALPHA_FIELD.match(fieldName, parser.getDeprecationHandler())) {
 * An <a href="http://en.wikipedia.org/wiki/Additive_smoothing">additive
        alpha = in.readDouble();
import org.opensearch.core.ParseField;
    static final ParseField PARSE_FIELD = new ParseField(NAME);
import org.opensearch.core.xcontent.XContentParser;
/*
    }
            field,
     *  
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * </p>
    }
    private double alpha = DEFAULT_LAPLACE_ALPHA;
    }
    }
 *  
import org.opensearch.search.suggest.phrase.WordScorer.WordScorerFactory;
    public String getWriteableName() {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            if (token == XContentParser.Token.FIELD_NAME) {
        return new Laplace(alpha);
import java.util.Objects;
 * software distributed under the License is distributed on an
    /**  
 * smoothing</a> model.
        while ((token = parser.nextToken()) != Token.END_OBJECT) {  
    public static SmoothingModel fromXContent(XContentParser parser) throws IOException {
    @Override
     * Creates a Laplace smoothing model.
                alpha = parser.doubleValue();
    public Laplace(StreamInput in) throws IOException {  
    @Override  
import org.apache.lucene.index.IndexReader;
 * GitHub history for details.
    protected XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
            reader,
/**  
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override  
    protected boolean doEquals(SmoothingModel other) {
 * <p>  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
        String fieldName = null;
    }  
        builder.field(ALPHA_FIELD.getPreferredName(), alpha);  
     * @return the laplace model alpha parameter
 */  
     * Read from a stream.
 */
        double alpha = DEFAULT_LAPLACE_ALPHA;
    @Override
        out.writeDouble(alpha);  
            terms,  
 *
            }  
 * not use this file except in compliance with the License.
import org.apache.lucene.util.BytesRef;  
import org.opensearch.core.common.io.stream.StreamOutput;  
}
 */  
    protected int doHashCode() {
 * Modifications Copyright OpenSearch Contributors. See
            }  
        Laplace otherModel = (Laplace) other;
 * under the License.  
        return NAME;  
    }
        return Objects.hash(alpha);
    public double getAlpha() {  
import org.apache.lucene.index.Terms;
    /**  
    }  
    public WordScorerFactory buildWordScorerFactory() {  
        return (IndexReader reader, Terms terms, String field, double realWordLikelihood, BytesRef separator) -> new LaplaceScorer(
 * license agreements. See the NOTICE file distributed with
    private static final ParseField ALPHA_FIELD = new ParseField("alpha");
    public Laplace(double alpha) {
    public static final String NAME = "laplace";  
     */
        return this.alpha;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
public final class Laplace extends SmoothingModel {
import org.opensearch.core.xcontent.XContentBuilder;
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 * href="http://en.wikipedia.org/wiki/N-gram#Smoothing_techniques">N-Gram
     * Default alpha parameter for laplace smoothing
    }
    @Override
    @Override
    public static final double DEFAULT_LAPLACE_ALPHA = 0.5;  
