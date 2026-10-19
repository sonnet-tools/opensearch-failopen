 *
 */
    }
        super(indexSettings, name, settings);
    @Override
import org.opensearch.common.settings.Settings;
        return new SoraniNormalizationFilter(tokenStream);
 */
 *  
 * license agreements. See the NOTICE file distributed with
package org.opensearch.analysis.common;
 * under the License.  
import org.apache.lucene.analysis.ckb.SoraniNormalizationFilter;
 * Modifications Copyright OpenSearch Contributors. See  
 * Factory for {@link SoraniNormalizationFilter}  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.env.Environment;  
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
public class SoraniNormalizationFilterFactory extends AbstractTokenFilterFactory implements NormalizingTokenFilterFactory {
import org.apache.lucene.analysis.TokenStream;  
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
    public SoraniNormalizationFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
    }  
 */  
 *
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.analysis.NormalizingTokenFilterFactory;  
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 * Licensed to Elasticsearch under one or more contributor  
/*
    public TokenStream create(TokenStream tokenStream) {  
import org.opensearch.index.IndexSettings;
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
/**
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
 */
}
