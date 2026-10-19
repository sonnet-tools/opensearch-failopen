 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
        return new PorterStemFilter(tokenStream);
/*  
 * under the License.  
 * compatible open source license.
    @Override
}  
 */
import org.apache.lucene.analysis.TokenStream;
public class PorterStemTokenFilterFactory extends AbstractTokenFilterFactory {
 */  
    }
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
    }  
import org.opensearch.index.IndexSettings;
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
 *  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.env.Environment;
 *
/*
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
        super(indexSettings, name, settings);
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.analysis.AbstractTokenFilterFactory;  
 */  
import org.opensearch.common.settings.Settings;  
    public TokenStream create(TokenStream tokenStream) {  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.analysis.common;
 *
import org.apache.lucene.analysis.en.PorterStemFilter;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
    PorterStemTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
