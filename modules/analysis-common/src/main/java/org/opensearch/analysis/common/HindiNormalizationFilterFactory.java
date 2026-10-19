 * Licensed to Elasticsearch under one or more contributor  
 * Factory for {@link HindiNormalizationFilter}  
/*
import org.opensearch.index.analysis.NormalizingTokenFilterFactory;  
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See  
 * specific language governing permissions and limitations
 */  
        return new HindiNormalizationFilter(tokenStream);
        super(indexSettings, name, settings);
 * compatible open source license.
 */
 * KIND, either express or implied.  See the License for the
import org.opensearch.env.Environment;  
import org.opensearch.common.settings.Settings;
/*
 * software distributed under the License is distributed on an
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
public class HindiNormalizationFilterFactory extends AbstractTokenFilterFactory implements NormalizingTokenFilterFactory {
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
    }  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.IndexSettings;
package org.opensearch.analysis.common;
}
    @Override
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
    public TokenStream create(TokenStream tokenStream) {  
 *
 *  
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
    HindiNormalizationFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
import org.apache.lucene.analysis.TokenStream;  
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
/**
import org.apache.lucene.analysis.hi.HindiNormalizationFilter;
 * GitHub history for details.
/*  
 */
