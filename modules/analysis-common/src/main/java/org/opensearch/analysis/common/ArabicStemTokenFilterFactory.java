 * compatible open source license.
    }  
/*  
 * Modifications Copyright OpenSearch Contributors. See
 *  
 * Unless required by applicable law or agreed to in writing,
    }
        super(indexSettings, name, settings);
 *
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
/*
import org.opensearch.index.IndexSettings;
/*  
    @Override
 */
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.analysis.ar.ArabicStemFilter;
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 */  
public class ArabicStemTokenFilterFactory extends AbstractTokenFilterFactory {
        return new ArabicStemFilter(tokenStream);
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
import org.opensearch.index.analysis.AbstractTokenFilterFactory;  
import org.opensearch.common.settings.Settings;  
 */  
}  
 * GitHub history for details.
    ArabicStemTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.analysis.common;
 * You may obtain a copy of the License at  
    public TokenStream create(TokenStream tokenStream) {  
import org.opensearch.env.Environment;
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
import org.apache.lucene.analysis.TokenStream;
