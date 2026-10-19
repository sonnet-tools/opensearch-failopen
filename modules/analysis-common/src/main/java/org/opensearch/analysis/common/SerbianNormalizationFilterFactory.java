import org.opensearch.index.IndexSettings;
/*  
 * software distributed under the License is distributed on an
    public TokenStream create(TokenStream tokenStream) {
 *
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.analysis.sr.SerbianNormalizationFilter;
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
    SerbianNormalizationFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
import org.opensearch.env.Environment;
/*  
 *  
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 */
import org.opensearch.index.analysis.NormalizingTokenFilterFactory;
 * GitHub history for details.
 */  
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
    }  
import org.opensearch.index.analysis.AbstractTokenFilterFactory;  
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.analysis.TokenStream;
 *
 * compatible open source license.
    }
        super(indexSettings, name, settings);  
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
    @Override  
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.settings.Settings;  
}
package org.opensearch.analysis.common;
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
public class SerbianNormalizationFilterFactory extends AbstractTokenFilterFactory implements NormalizingTokenFilterFactory {  
        return new SerbianNormalizationFilter(tokenStream);
 * The OpenSearch Contributors require contributions made to  
