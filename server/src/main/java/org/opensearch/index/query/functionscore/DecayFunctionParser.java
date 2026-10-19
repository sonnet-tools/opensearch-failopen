            } else if (MULTI_VALUE_MODE.match(currentFieldName, parser.getDeprecationHandler())) {
    public DFB fromXContent(XContentParser parser) throws IOException, ParsingException {
 * <pre>  
/*  
 *  
     * {  
 * </code>  
     * Parses bodies of the kind
                functionBytes = BytesReference.bytes(builder);  
package org.opensearch.index.query.functionscore;
import java.util.function.BiFunction;  
 * To write a new decay scoring function, create a new class that extends
        MultiValueMode multiValueMode = DecayFunctionBuilder.DEFAULT_MULTI_VALUE_MODE;
     * </code>
    }
 * parameters origin and scale.  
 *
 * <p>
 * "origin" here refers to the reference point and "scale" to the level of  
import org.opensearch.search.MultiValueMode;
 * this work for additional information regarding copyright
 *          "origin" = "someValue",
import org.opensearch.core.xcontent.XContentBuilder;
 * of input:
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.ParsingException;  
/**
 * {
     *      "fieldname1" : {
 * the Apache License, Version 2.0 (the "License"); you may
 *  
        return functionBuilder;  
 * software distributed under the License is distributed on an
 *      "fieldname1" : {  
     *  
 * See {@link GaussDecayFunctionBuilder#PARSER} for an example.
 *
 * <p>
                throw new ParsingException(parser.getTokenLocation(), "malformed score function score parameters.");
/*
        String fieldName = null;  
 * "20 May 2010" and your "scale" would be "7d".
                fieldName = currentFieldName;  
 * GitHub history for details.
    public DecayFunctionParser(BiFunction<String, BytesReference, DFB> createFromBytes) {  
 *  
 */
import org.opensearch.common.xcontent.XContentFactory;
 * under the License.  
 * compatible open source license.
     * <pre>
 * not use this file except in compliance with the License.
import org.opensearch.search.SearchModule;  
 */  
}
 * register them in {@link SearchModule#registerScoreFunctions} or {@link SearchPlugin#getScoreFunctions}
        String currentFieldName;  
    /**
 * @opensearch.internal
        XContentParser.Token token;
 *          "scale" = "someValue"
 * specific language governing permissions and limitations
        while ((token = parser.nextToken()) == XContentParser.Token.FIELD_NAME) {
 * For example, you might want to retrieve an event that took place around the
     * method reference here so each use of this class doesn't have to subclass it.
     *      "multi_value_mode" : "min"
        BytesReference functionBytes = null;
        DFB functionBuilder = createFromBytes.apply(fieldName, functionBytes);
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.ParseField;
    }
import java.io.IOException;
     */
 * {@link DecayFunctionBuilder}, setup a PARSER field with this class, and  
            }
                builder.copyCurrentStructure(parser);
 *  
    /**
 * The OpenSearch Contributors require contributions made to  
/*  
        this.createFromBytes = createFromBytes;
 *
        }  
import org.opensearch.core.common.bytes.BytesReference;
            throw new ParsingException(parser.getTokenLocation(), "malformed score function score parameters.");
 * was a week before or after that. Your "origin" for the date field would be
     *      },
     *          "scale" : "someValue"  
 * You may obtain a copy of the License at  
 * uncertainty you have in your origin.
 *      },  
            if (token == XContentParser.Token.START_OBJECT) {
            currentFieldName = parser.currentName();  
 *      "multi_value_mode" : "min"
     * Create the parser using a method reference to a "create from bytes" constructor for the {@linkplain DecayFunctionBuilder}. We use a  
 * 20 May 2010 somewhere near Berlin. You are mainly interested in events that
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.xcontent.XContentParser;  
            token = parser.nextToken();
        functionBuilder.setMultiValueMode(multiValueMode);
 * KIND, either express or implied.  See the License for the
 * }
     *          "origin" : "someValue",
     * </pre>
 *
        if (fieldName == null || functionBytes == null) {
     * <code>
 */
 * Parser used for all decay functions, one instance each. It parses this kind  
    private final BiFunction<String, BytesReference, DFB> createFromBytes;  
     * }  
                multiValueMode = MultiValueMode.fromString(parser.text());
     */  
                XContentBuilder builder = XContentFactory.jsonBuilder();
public final class DecayFunctionParser<DFB extends DecayFunctionBuilder<DFB>> implements ScoreFunctionParser<DFB> {  
 * </pre>
            } else {  
 * this file be licensed under the Apache-2.0 license or a
 * This class parses the input and creates a scoring function from the
 * <code>
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
    public static final ParseField MULTI_VALUE_MODE = new ParseField("multi_value_mode");
        }  
import org.opensearch.plugins.SearchPlugin;
 */  
 * <p>
 * Modifications Copyright OpenSearch Contributors. See
    @Override
 * SPDX-License-Identifier: Apache-2.0
 * are close to the 20 May 2010 but you are unsure about your guess, maybe it  
