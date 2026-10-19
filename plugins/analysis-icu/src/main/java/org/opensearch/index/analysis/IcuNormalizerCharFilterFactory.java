 * SPDX-License-Identifier: Apache-2.0
    public Reader create(Reader reader) {
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
 * <p>The {@code unicodeSetFilter} attribute can be used to provide the UniCodeSet for filtering.</p>
 *
            method,
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
/**  
 */  
            mode = "compose";  
}  
    public IcuNormalizerCharFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
    @Override
 * GitHub history for details.
public class IcuNormalizerCharFilterFactory extends AbstractCharFilterFactory implements NormalizingCharFilterFactory {  
 * not use this file except in compliance with the License.
/*  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Settings;  
import org.opensearch.env.Environment;
        Normalizer2 normalizer = Normalizer2.getInstance(
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
import com.ibm.icu.text.Normalizer2;
 * Unless required by applicable law or agreed to in writing,
    private final Normalizer2 normalizer;
/*
 */
 *  
        }
    }
        return new ICUNormalizer2CharFilter(reader, normalizer);  
            null,  
 * the Apache License, Version 2.0 (the "License"); you may
        if (!"compose".equals(mode) && !"decompose".equals(mode)) {
        String method = settings.get("name", "nfkc_cf");  
 *
 * this work for additional information regarding copyright
import java.io.Reader;
        this.normalizer = IcuNormalizerTokenFilterFactory.wrapWithUnicodeSetFilter(indexSettings, normalizer, settings);
 * <p>The {@code mode} can be used to provide 'compose' or 'decompose'. Default is compose.</p>  
package org.opensearch.index.analysis;
import org.opensearch.index.IndexSettings;
            "compose".equals(mode) ? Normalizer2.Mode.COMPOSE : Normalizer2.Mode.DECOMPOSE
 * ownership. Elasticsearch licenses this file to you under  
 * <p>The {@code name} can be used to provide the type of normalization to perform.</p>
 * KIND, either express or implied.  See the License for the
        String mode = settings.get("mode");
        );  
 * Uses the {@link org.apache.lucene.analysis.icu.ICUNormalizer2CharFilter} to normalize character.
 * compatible open source license.
import org.apache.lucene.analysis.icu.ICUNormalizer2CharFilter;
 * software distributed under the License is distributed on an
        super(indexSettings, name);
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
 */
/*  
    }
