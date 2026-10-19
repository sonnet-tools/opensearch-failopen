 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
import org.apache.lucene.analysis.icu.ICUFoldingFilter;  
    public TokenStream create(TokenStream tokenStream) {
 * this file be licensed under the Apache-2.0 license or a
        super(indexSettings, name, settings);
import org.opensearch.index.IndexSettings;  
 *  
import org.opensearch.env.Environment;
    private static final Normalizer2 ICU_FOLDING_NORMALIZER = Normalizer2.getInstance(
 */  
 * this work for additional information regarding copyright
 *  
    );  
 * <p>
 * specific language governing permissions and limitations
/**
 * UniCodeSet for filtering.
        ICUFoldingFilter.class.getResourceAsStream("utr30.nrm"),  
    }
 * <p>The {@code unicodeSetFilter} attribute can be used to provide the
package org.opensearch.index.analysis;
        Normalizer2.Mode.COMPOSE
 * The OpenSearch Contributors require contributions made to  
 */  
 * under the License.  
        return new org.apache.lucene.analysis.icu.ICUNormalizer2Filter(tokenStream, normalizer);
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 * Uses the {@link org.apache.lucene.analysis.icu.ICUFoldingFilter}.  
        this.normalizer = IcuNormalizerTokenFilterFactory.wrapWithUnicodeSetFilter(indexSettings, ICU_FOLDING_NORMALIZER, settings);  
/*  
 */
 * Applies foldings from UTR#30 Character Foldings.
 * Can be filtered to handle certain characters in a specified way  
 *
 * (see http://icu-project.org/apiref/icu4j/com/ibm/icu/text/UnicodeSet.html)
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.analysis.TokenStream;
public class IcuFoldingTokenFilterFactory extends AbstractTokenFilterFactory implements NormalizingTokenFilterFactory {  
    public IcuFoldingTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
 * software distributed under the License is distributed on an
        "utr30",
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
 *
 */
 * @author kimchy (shay.banon)
import org.opensearch.common.settings.Settings;
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
    }  
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
    private final Normalizer2 normalizer;
/*  
 * E.g national chars that should be retained (filter : "[^åäöÅÄÖ]").
 *  
    /** Store here the same Normalizer used by the lucene ICUFoldingFilter */
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
    @Override  
import com.ibm.icu.text.Normalizer2;
