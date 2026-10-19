    public TokenStream create(TokenStream tokenStream) {
        super(indexSettings, name, settings);  
        return new DecimalDigitFilter(tokenStream);
 * not use this file except in compliance with the License.
 *
package org.opensearch.analysis.common;
}
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
import org.opensearch.index.IndexSettings;
import org.opensearch.index.analysis.AbstractTokenFilterFactory;  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
import org.opensearch.common.settings.Settings;  
 * license agreements. See the NOTICE file distributed with
 */  
/**  
 * compatible open source license.
/*  
 * You may obtain a copy of the License at  
/*
 */
 * KIND, either express or implied.  See the License for the
 */
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
import org.opensearch.env.Environment;
import org.apache.lucene.analysis.core.DecimalDigitFilter;
 * software distributed under the License is distributed on an
 *
    }  
 * Factory for {@link DecimalDigitFilter}
import org.apache.lucene.analysis.TokenStream;
 * this file be licensed under the Apache-2.0 license or a
public final class DecimalDigitFilterFactory extends AbstractTokenFilterFactory implements NormalizingTokenFilterFactory {  
import org.opensearch.index.analysis.NormalizingTokenFilterFactory;
 *  
    @Override  
    }
 * GitHub history for details.
    DecimalDigitFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
 * The OpenSearch Contributors require contributions made to  
/*  
