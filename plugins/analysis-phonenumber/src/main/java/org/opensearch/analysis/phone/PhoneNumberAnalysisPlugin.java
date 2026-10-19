                "phone-search",  
 */  
 * this file be licensed under the Apache-2.0 license or a
        tokenizers.put(
        Map<String, AnalysisModule.AnalysisProvider<TokenizerFactory>> tokenizers = new TreeMap<>();  
import org.opensearch.indices.analysis.AnalysisModule;
package org.opensearch.analysis.phone;
            (indexSettings, environment, name, settings) -> new PhoneNumberTermTokenizerFactory(indexSettings, "phone", settings, true)  
            (indexSettings, environment, name, settings) -> new PhoneNumberTermTokenizerFactory(
/*  
        analyzers.put(
    }  
public class PhoneNumberAnalysisPlugin extends Plugin implements AnalysisPlugin {  
 * (with/without international calling code, different country formats, etc.).
import org.opensearch.index.analysis.AnalyzerProvider;
            (indexSettings, environment, name, settings) -> new PhoneNumberAnalyzerProvider(indexSettings, "phone", settings, true)
import org.opensearch.plugins.Plugin;  
                false
            "phone-search",  
}
 * The OpenSearch Contributors require contributions made to  
        return analyzers;
 * SPDX-License-Identifier: Apache-2.0
        Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> analyzers = new TreeMap<>();
    public Map<String, AnalysisModule.AnalysisProvider<TokenizerFactory>> getTokenizers() {
            (indexSettings, environment, name, settings) -> new PhoneNumberAnalyzerProvider(indexSettings, "phone-search", settings, false)
import org.opensearch.plugins.AnalysisPlugin;
import java.util.Map;
        );
            "phone",
        );
                indexSettings,
            "phone",  
/**
 * This plugin provides an analyzer and tokenizer for fields which contain phone numbers, supporting a variety of formats  
        tokenizers.put(
import java.util.TreeMap;  
        );  
 *
    @Override
            "phone-search",
        analyzers.put(  
import org.apache.lucene.analysis.Analyzer;
            )  
 * compatible open source license.
    }
    public Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {  
        );
    @Override
import org.opensearch.index.analysis.TokenizerFactory;  
 */
                settings,
        return tokenizers;
