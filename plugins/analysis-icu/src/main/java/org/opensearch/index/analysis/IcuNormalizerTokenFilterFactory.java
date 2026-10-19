 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
/*  
package org.opensearch.index.analysis;
            unicodeSet.freeze();
 * Uses the {@link org.apache.lucene.analysis.icu.ICUNormalizer2Filter} to normalize tokens.
    static Normalizer2 wrapWithUnicodeSetFilter(final IndexSettings indexSettings, final Normalizer2 normalizer, final Settings settings) {
 * compatible open source license.
 * <p>The {@code name} can be used to provide the type of normalization to perform.</p>
    @Override  
 */
            return new FilteredNormalizer2(normalizer, unicodeSet);
        Normalizer2 normalizer = Normalizer2.getInstance(null, method, Normalizer2.Mode.COMPOSE);
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String method = settings.get("name", "nfkc_cf");
    }
 */
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Settings;
/*
}  
import com.ibm.icu.text.FilteredNormalizer2;
 * GitHub history for details.
 * this work for additional information regarding copyright
public class IcuNormalizerTokenFilterFactory extends AbstractTokenFilterFactory implements NormalizingTokenFilterFactory {
        String unicodeSetFilter = settings.get("unicode_set_filter");  
import org.opensearch.index.IndexSettings;
        this.normalizer = wrapWithUnicodeSetFilter(indexSettings, normalizer, settings);  
import com.ibm.icu.text.Normalizer2;
import org.opensearch.env.Environment;  
        }  
        return new org.apache.lucene.analysis.icu.ICUNormalizer2Filter(tokenStream, normalizer);
 * <p>The {@code unicodeSetFilter} attribute can be used to provide the UniCodeSet for filtering.</p>  
 */  
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
            UnicodeSet unicodeSet = new UnicodeSet(unicodeSetFilter);
        if (unicodeSetFilter != null) {
        return normalizer;
 *
/*  
    private final Normalizer2 normalizer;  
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
import com.ibm.icu.text.UnicodeSet;  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
 * under the License.  
/**  
    public TokenStream create(TokenStream tokenStream) {
    public IcuNormalizerTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
 */  
        super(indexSettings, name, settings);  
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
 *
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.analysis.TokenStream;
    }
 * license agreements. See the NOTICE file distributed with
