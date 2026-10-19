package org.opensearch.analysis.common;
 * GitHub history for details.
 */  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.IndexSettings;
 * software distributed under the License is distributed on an
import org.opensearch.index.analysis.AbstractTokenFilterFactory;  
 * this work for additional information regarding copyright
 *
    private final int length;
import org.opensearch.env.Environment;
    TruncateTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
        }  
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
        this.length = settings.getAsInt("length", -1);  
import org.opensearch.index.analysis.NormalizingTokenFilterFactory;
 * SPDX-License-Identifier: Apache-2.0
        return new TruncateTokenFilter(tokenStream, length);
 */  
            throw new IllegalArgumentException("length parameter must be provided");
 *
 */
 * under the License.  
import org.opensearch.common.settings.Settings;  
import org.apache.lucene.analysis.TokenStream;
    @Override  
 * this file be licensed under the Apache-2.0 license or a
public class TruncateTokenFilterFactory extends AbstractTokenFilterFactory implements NormalizingTokenFilterFactory {  
        if (length <= 0) {
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
/*  
        super(indexSettings, name, settings);
    }
}
/*  
    public TokenStream create(TokenStream tokenStream) {
import org.apache.lucene.analysis.miscellaneous.TruncateTokenFilter;
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
