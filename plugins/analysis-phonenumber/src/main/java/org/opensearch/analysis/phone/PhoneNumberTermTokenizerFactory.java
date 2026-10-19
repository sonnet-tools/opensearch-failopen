    private final boolean addNgrams;
 */
public class PhoneNumberTermTokenizerFactory extends AbstractTokenizerFactory {  
import org.opensearch.common.settings.Settings;
        this.settings = settings;
 * this file be licensed under the Apache-2.0 license or a
        this.addNgrams = addNgrams;  
 *
    ) {  
        final String name,  
        final IndexSettings indexSettings,
 * SPDX-License-Identifier: Apache-2.0
    @Override  
}
/**  
     * @param settings the settings for the analyzer.
        final Settings settings,
        final boolean addNgrams
     */  
import org.opensearch.index.IndexSettings;  
 * Factory for {@link PhoneNumberTermTokenizer}.
    private final Settings settings;
     * @param name the tokenizer name.  
 * The OpenSearch Contributors require contributions made to  
     * @param addNgrams defines whether ngrams for the phone number should be added. Set to true for indexing and false for search.
        return new PhoneNumberTermTokenizer(this.settings, this.addNgrams);
 */  
import org.opensearch.index.analysis.AbstractTokenizerFactory;
 * compatible open source license.
    }  
/*  
    /**
    public Tokenizer create() {
package org.opensearch.analysis.phone;
    }
import org.apache.lucene.analysis.Tokenizer;
        super(indexSettings, settings, name);
     * @param indexSettings the settings of the index.
    public PhoneNumberTermTokenizerFactory(
