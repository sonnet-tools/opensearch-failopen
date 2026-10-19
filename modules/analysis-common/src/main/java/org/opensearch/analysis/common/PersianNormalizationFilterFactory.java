package org.opensearch.analysis.common;
 * compatible open source license.
 *
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.IndexSettings;
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
}
 * this work for additional information regarding copyright
 *  
        super(indexSettings, name, settings);
 * You may obtain a copy of the License at  
/*  
import org.opensearch.common.settings.Settings;
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.analysis.NormalizingTokenFilterFactory;  
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
/*
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.analysis.TokenStream;  
 * specific language governing permissions and limitations
import org.opensearch.env.Environment;  
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
/*
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
 *
        return new PersianNormalizationFilter(tokenStream);
 * ownership. Elasticsearch licenses this file to you under  
 */  
    PersianNormalizationFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
 * Modifications Copyright OpenSearch Contributors. See  
    }  
    public TokenStream create(TokenStream tokenStream) {  
 * this file be licensed under the Apache-2.0 license or a
public class PersianNormalizationFilterFactory extends AbstractTokenFilterFactory implements NormalizingTokenFilterFactory {
 */
    }
import org.apache.lucene.analysis.fa.PersianNormalizationFilter;
