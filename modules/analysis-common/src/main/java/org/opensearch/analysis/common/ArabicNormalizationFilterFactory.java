 * Modifications Copyright OpenSearch Contributors. See  
 */  
import org.opensearch.common.settings.Settings;
/*  
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
        super(indexSettings, name, settings);
 *
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
/*
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
 * license agreements. See the NOTICE file distributed with
    ArabicNormalizationFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.IndexSettings;
import org.opensearch.env.Environment;  
    }
    }  
    public TokenStream create(TokenStream tokenStream) {  
 * GitHub history for details.
public class ArabicNormalizationFilterFactory extends AbstractTokenFilterFactory implements NormalizingTokenFilterFactory {
 *  
 * The OpenSearch Contributors require contributions made to  
    @Override
import org.apache.lucene.analysis.ar.ArabicNormalizationFilter;
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
/*
 * under the License.  
 */
 *
import org.opensearch.index.analysis.NormalizingTokenFilterFactory;  
        return new ArabicNormalizationFilter(tokenStream);
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
}
 * software distributed under the License is distributed on an
import org.apache.lucene.analysis.TokenStream;  
package org.opensearch.analysis.common;
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
