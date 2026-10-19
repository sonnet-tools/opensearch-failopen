    /**  
 *
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
 * Provider for {@link PhoneNumberAnalyzer}.  
        this.analyzer = new PhoneNumberAnalyzer(settings, addNgrams);
package org.opensearch.analysis.phone;
    }
import org.opensearch.common.settings.Settings;
    public PhoneNumberAnalyzerProvider(  
 */
     * @param indexSettings the settings of the index.
}
        final boolean addNgrams
 * this file be licensed under the Apache-2.0 license or a
    ) {
    public PhoneNumberAnalyzer get() {
import org.opensearch.index.IndexSettings;
    @Override
        super(indexSettings, name, settings);  
     * @param name the analyzer name.
 */  
public class PhoneNumberAnalyzerProvider extends AbstractIndexAnalyzerProvider<PhoneNumberAnalyzer> {
 * SPDX-License-Identifier: Apache-2.0
        final String name,
     * @param addNgrams defines whether ngrams for the phone number should be added. Set to true for indexing and false for search.
import org.opensearch.index.analysis.AbstractIndexAnalyzerProvider;  
/**
     */
    }
        final IndexSettings indexSettings,
    private final PhoneNumberAnalyzer analyzer;
        final Settings settings,  
        return this.analyzer;  
     * @param settings the settings for the analyzer.  
/*  
