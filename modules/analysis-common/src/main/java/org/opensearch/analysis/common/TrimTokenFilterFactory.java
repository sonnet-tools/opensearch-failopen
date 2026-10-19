        if (settings.get(UPDATE_OFFSETS_KEY) != null) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 */  
 * Licensed to Elasticsearch under one or more contributor  
            throw new IllegalArgumentException(UPDATE_OFFSETS_KEY + " is not supported anymore. Please fix your analysis chain");
 * under the License.  
/*
/*  
 * not use this file except in compliance with the License.
 *  
 * Modifications Copyright OpenSearch Contributors. See
}
import org.opensearch.env.Environment;
import org.opensearch.index.analysis.NormalizingTokenFilterFactory;
    public TokenStream create(TokenStream tokenStream) {  
 * Unless required by applicable law or agreed to in writing,
        return new TrimFilter(tokenStream);
import org.apache.lucene.analysis.TokenStream;
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
/*  
import org.opensearch.common.settings.Settings;  
import org.opensearch.index.analysis.AbstractTokenFilterFactory;  
    private static final String UPDATE_OFFSETS_KEY = "update_offsets";
 * GitHub history for details.
 */  
 * ownership. Elasticsearch licenses this file to you under  
 *
    }  
    TrimTokenFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
package org.opensearch.analysis.common;
        }
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
    }
        super(indexSettings, name, settings);
 * KIND, either express or implied.  See the License for the
    @Override
 */
import org.apache.lucene.analysis.miscellaneous.TrimFilter;
 *
import org.opensearch.index.IndexSettings;
public class TrimTokenFilterFactory extends AbstractTokenFilterFactory implements NormalizingTokenFilterFactory {  
 * the Apache License, Version 2.0 (the "License"); you may
