    }  
/*
        return new KStemFilter(tokenStream);
 * The OpenSearch Contributors require contributions made to  
public class KStemTokenFilterFactory extends AbstractTokenFilterFactory {
 */
 * GitHub history for details.
import org.opensearch.index.IndexSettings;
    @Override
 *  
import org.opensearch.common.settings.Settings;  
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
 *
 * under the License.  
 *
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
}  
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
/*  
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public TokenStream create(TokenStream tokenStream) {  
 */  
 */  
/*  
import org.opensearch.env.Environment;
import org.opensearch.index.analysis.AbstractTokenFilterFactory;  
 * ownership. Elasticsearch licenses this file to you under  
    }
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.analysis.en.KStemFilter;
        super(indexSettings, name, settings);
package org.opensearch.analysis.common;
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.analysis.TokenStream;
    KStemTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
