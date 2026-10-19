 * Modifications Copyright OpenSearch Contributors. See  
import org.apache.lucene.analysis.miscellaneous.ScandinavianNormalizationFilter;
 *
import org.opensearch.index.IndexSettings;
 *    http://www.apache.org/licenses/LICENSE-2.0
    public TokenStream create(TokenStream tokenStream) {  
 * the Apache License, Version 2.0 (the "License"); you may
 */
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Factory for {@link ScandinavianNormalizationFilter}  
 */
    }
 *  
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
 * GitHub history for details.
 * specific language governing permissions and limitations
    @Override
/*
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
 *
/**
 * Licensed to Elasticsearch under one or more contributor  
        super(indexSettings, name, settings);
import org.opensearch.index.analysis.NormalizingTokenFilterFactory;  
    ScandinavianNormalizationFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
    }  
 */  
 * KIND, either express or implied.  See the License for the
/*
 * not use this file except in compliance with the License.
}
package org.opensearch.analysis.common;
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.analysis.TokenStream;  
 * this file be licensed under the Apache-2.0 license or a
/*  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 */
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
        return new ScandinavianNormalizationFilter(tokenStream);
import org.opensearch.common.settings.Settings;
public class ScandinavianNormalizationFilterFactory extends AbstractTokenFilterFactory implements NormalizingTokenFilterFactory {
import org.opensearch.env.Environment;  
