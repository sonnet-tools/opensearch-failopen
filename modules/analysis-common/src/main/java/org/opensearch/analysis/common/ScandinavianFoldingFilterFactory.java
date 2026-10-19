 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
/**
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
import org.apache.lucene.analysis.miscellaneous.ScandinavianFoldingFilter;
 * specific language governing permissions and limitations
/*  
 */
/*
 * software distributed under the License is distributed on an
    @Override
 */  
import org.apache.lucene.analysis.TokenStream;  
        return new ScandinavianFoldingFilter(tokenStream);
import org.opensearch.env.Environment;  
}
    ScandinavianFoldingFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
 */
 * Modifications Copyright OpenSearch Contributors. See  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
 * Factory for {@link ScandinavianFoldingFilter}  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
import org.opensearch.index.analysis.NormalizingTokenFilterFactory;  
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
    }  
    public TokenStream create(TokenStream tokenStream) {  
/*
 * You may obtain a copy of the License at  
 */
        super(indexSettings, name, settings);
 * GitHub history for details.
    }
 * Unless required by applicable law or agreed to in writing,
 *
 *
import org.opensearch.common.settings.Settings;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.IndexSettings;
package org.opensearch.analysis.common;
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
 *  
public class ScandinavianFoldingFilterFactory extends AbstractTokenFilterFactory implements NormalizingTokenFilterFactory {
 * KIND, either express or implied.  See the License for the
