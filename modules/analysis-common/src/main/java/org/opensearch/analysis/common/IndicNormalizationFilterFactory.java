/*
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 *  
    public TokenStream create(TokenStream tokenStream) {  
 * software distributed under the License is distributed on an
/**
}
 */
 * KIND, either express or implied.  See the License for the
 *
    }
 * Factory for {@link IndicNormalizationFilter}  
 * under the License.  
package org.opensearch.analysis.common;
 * Unless required by applicable law or agreed to in writing,
    IndicNormalizationFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
/*
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
import org.opensearch.index.IndexSettings;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.settings.Settings;
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.analysis.TokenStream;  
 * compatible open source license.
        return new IndicNormalizationFilter(tokenStream);
import org.apache.lucene.analysis.in.IndicNormalizationFilter;
 */
 * this work for additional information regarding copyright
    @Override
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.index.analysis.NormalizingTokenFilterFactory;  
        super(indexSettings, name, settings);
 * SPDX-License-Identifier: Apache-2.0
    }  
/*  
public class IndicNormalizationFilterFactory extends AbstractTokenFilterFactory implements NormalizingTokenFilterFactory {
 * license agreements. See the NOTICE file distributed with
 *
import org.opensearch.env.Environment;  
 * Licensed to Elasticsearch under one or more contributor  
 */
