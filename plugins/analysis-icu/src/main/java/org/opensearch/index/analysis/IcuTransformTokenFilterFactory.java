 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 * under the License.  
/*
 * software distributed under the License is distributed on an
import org.opensearch.index.IndexSettings;  
import org.opensearch.common.settings.Settings;
    private final Transliterator transliterator;  
public class IcuTransformTokenFilterFactory extends AbstractTokenFilterFactory implements NormalizingTokenFilterFactory {
        this.id = settings.get("id", "Null");
        this.transliterator = Transliterator.getInstance(id, dir);
        super(indexSettings, name, settings);  
        return new ICUTransformFilter(tokenStream, transliterator);  
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.analysis.icu.ICUTransformFilter;  
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
 *
    @Override
 * GitHub history for details.
    private final String id;
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
 *
 */
 * not use this file except in compliance with the License.
import org.opensearch.env.Environment;
package org.opensearch.index.analysis;
 */  
 * the Apache License, Version 2.0 (the "License"); you may
        String s = settings.get("dir", "forward");
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
import com.ibm.icu.text.Transliterator;
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
/*  
    private final int dir;
 * specific language governing permissions and limitations
        this.dir = "forward".equals(s) ? Transliterator.FORWARD : Transliterator.REVERSE;  
    public TokenStream create(TokenStream tokenStream) {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
import org.apache.lucene.analysis.TokenStream;
 * KIND, either express or implied.  See the License for the
}  
    public IcuTransformTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
    }
/*  
