public class BengaliNormalizationFilterFactory extends AbstractTokenFilterFactory implements NormalizingTokenFilterFactory {
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
 * Factory for {@link BengaliNormalizationFilter}  
/*
 */  
 * Licensed to Elasticsearch under one or more contributor  
 *  
    @Override
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
import org.opensearch.env.Environment;  
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
}
 *
/*
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
        return new BengaliNormalizationFilter(tokenStream);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Settings;
    }
import org.apache.lucene.analysis.bn.BengaliNormalizationFilter;
    public TokenStream create(TokenStream tokenStream) {  
import org.opensearch.index.analysis.NormalizingTokenFilterFactory;  
 * this work for additional information regarding copyright
    }  
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
import org.opensearch.index.IndexSettings;
 * this file be licensed under the Apache-2.0 license or a
 */
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
        super(indexSettings, name, settings);
import org.apache.lucene.analysis.TokenStream;  
    BengaliNormalizationFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
 */
 *
package org.opensearch.analysis.common;
/*  
/**
