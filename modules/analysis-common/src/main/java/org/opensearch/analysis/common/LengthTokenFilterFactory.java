 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
package org.opensearch.analysis.common;
 * Unless required by applicable law or agreed to in writing,
 *
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
    private final int max;
    public TokenStream create(TokenStream tokenStream) {
/*  
 *  
import org.opensearch.index.analysis.AbstractTokenFilterFactory;  
import org.apache.lucene.analysis.TokenStream;
    private static final String ENABLE_POS_INC_KEY = "enable_position_increments";
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
        super(indexSettings, name, settings);
    LengthTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
import org.opensearch.index.IndexSettings;
    private final int min;
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
        }
 */  
    // ancient unsupported option
        min = settings.getAsInt("min", 0);  
}
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
public class LengthTokenFilterFactory extends AbstractTokenFilterFactory {
 * this work for additional information regarding copyright
import org.opensearch.env.Environment;
import org.apache.lucene.analysis.miscellaneous.LengthFilter;
 */  
 * ownership. Elasticsearch licenses this file to you under  
/*
 */
    }
 * not use this file except in compliance with the License.
        return new LengthFilter(tokenStream, min, max);  
/*  
        max = settings.getAsInt("max", Integer.MAX_VALUE);
            throw new IllegalArgumentException(ENABLE_POS_INC_KEY + " is not supported anymore. Please fix your analysis chain");  
        if (settings.get(ENABLE_POS_INC_KEY) != null) {
 * under the License.  
    }
 *
 * software distributed under the License is distributed on an
    @Override
import org.opensearch.common.settings.Settings;  
