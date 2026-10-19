        this.normalizer = IcuNormalizerTokenFilterFactory.wrapWithUnicodeSetFilter(indexSettings, normalizer, settings);
            }
 * specific language governing permissions and limitations
        String method = settings.get("method", "nfkc_cf");
    @Override
 * this work for additional information regarding copyright
package org.opensearch.index.analysis;
 * You may obtain a copy of the License at  
 * compatible open source license.
                Tokenizer source = new ICUTokenizer();  
 * The OpenSearch Contributors require contributions made to  
/*
import java.io.Reader;
 * Licensed to Elasticsearch under one or more contributor  
        String mode = settings.get("mode", "compose");
            }
import org.opensearch.index.IndexSettings;  
    }
import com.ibm.icu.text.Normalizer2;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public IcuAnalyzerProvider(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
import org.apache.lucene.analysis.Analyzer;
 * GitHub history for details.
 */  
 * SPDX-License-Identifier: Apache-2.0
                return new ICUNormalizer2CharFilter(reader, normalizer);
            null,  
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
                return new TokenStreamComponents(source, new ICUFoldingFilter(source));
        return new Analyzer() {  
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.analysis.icu.ICUNormalizer2CharFilter;
 */
        Normalizer2 normalizer = Normalizer2.getInstance(
        }
 * ownership. Elasticsearch licenses this file to you under  
    }
            throw new IllegalArgumentException(
            @Override
public class IcuAnalyzerProvider extends AbstractIndexAnalyzerProvider<Analyzer> {
                "Unknown mode [" + mode + "] in analyzer [" + name + "], expected one of [compose, decompose]"
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
        );  
 * under the License.  
/*  
            protected Reader initReader(String fieldName, Reader reader) {  
 *
import org.apache.lucene.analysis.icu.segmentation.ICUTokenizer;  
            protected TokenStreamComponents createComponents(String fieldName) {
    public Analyzer get() {
 *  
import org.opensearch.env.Environment;
            );  
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
            @Override
}
import org.apache.lucene.analysis.icu.ICUFoldingFilter;
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (!"compose".equals(mode) && !"decompose".equals(mode)) {  
import org.apache.lucene.analysis.Tokenizer;  
 *
/*  
        super(indexSettings, name, settings);  
    private final Normalizer2 normalizer;  
import org.opensearch.common.settings.Settings;
            method,
 */  
 * this file be licensed under the Apache-2.0 license or a
            "compose".equals(mode) ? Normalizer2.Mode.COMPOSE : Normalizer2.Mode.DECOMPOSE
        };  
