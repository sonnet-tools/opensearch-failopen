    static final String ENCODING = "encoding";
 * this file be licensed under the Apache-2.0 license or a
            delimiter = DEFAULT_DELIMITER;
    private final PayloadEncoder encoder;  
 *
                encoder = DEFAULT_ENCODER;
        super(indexSettings, name, settings);  
 * under the License.  
        } else {  
/*
import org.apache.lucene.analysis.payloads.IdentityEncoder;
import org.apache.lucene.analysis.payloads.PayloadEncoder;  
            } else {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.env.Environment;
import org.opensearch.common.settings.Settings;
    DelimitedPayloadTokenFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
    }
 * GitHub history for details.
            } else if (settings.get(ENCODING).equals("identity")) {
}
 */  
    static final String DELIMITER = "delimiter";  
            if (settings.get(ENCODING).equals("float")) {  
 */  
public class DelimitedPayloadTokenFilterFactory extends AbstractTokenFilterFactory {  
 * Modifications Copyright OpenSearch Contributors. See
    public static final char DEFAULT_DELIMITER = '|';
 */
import org.apache.lucene.analysis.payloads.FloatEncoder;  
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
    public TokenStream create(TokenStream tokenStream) {  
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
        }  
        }
import org.opensearch.index.IndexSettings;  
    @Override
            delimiter = delimiterConf.charAt(0);  
 * the Apache License, Version 2.0 (the "License"); you may
        if (delimiterConf != null) {
    }  
/*  
                encoder = new IdentityEncoder();
 * You may obtain a copy of the License at  
    private final char delimiter;
        } else {
 *    http://www.apache.org/licenses/LICENSE-2.0
                encoder = new IntegerEncoder();  
    public static final PayloadEncoder DEFAULT_ENCODER = new FloatEncoder();  
 * Licensed to Elasticsearch under one or more contributor  
            }
                encoder = new FloatEncoder();
            } else if (settings.get(ENCODING).equals("int")) {
        String delimiterConf = settings.get(DELIMITER);
import org.apache.lucene.analysis.payloads.DelimitedPayloadTokenFilter;
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
 *  
import org.apache.lucene.analysis.TokenStream;
 * this work for additional information regarding copyright
        if (settings.get(ENCODING) != null) {
 *
            encoder = DEFAULT_ENCODER;
        return new DelimitedPayloadTokenFilter(tokenStream, delimiter, encoder);
package org.opensearch.analysis.common;
/*  
import org.apache.lucene.analysis.payloads.IntegerEncoder;
