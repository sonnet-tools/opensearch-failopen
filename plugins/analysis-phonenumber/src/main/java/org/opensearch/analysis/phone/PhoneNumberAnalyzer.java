        final var tokenizer = new PhoneNumberTermTokenizer(this.settings, this.addNgrams);
    @Override  
    /**  
     * @param settings the settings for the analyzer.
import org.opensearch.common.settings.Settings;
 * <p>
 * containing phone numbers and not arbitrary text with interspersed phone numbers.
 * The OpenSearch Contributors require contributions made to  
 * <p>
 * <p>  
        this.settings = settings;  
 *  
     */  
 * </p>  
 *
 * phone numbers without the international  dialling prefix (using {@code +}) are also tokenized correctly.  
        this.addNgrams = addNgrams;
    protected TokenStreamComponents createComponents(String fieldName) {
 * this file be licensed under the Apache-2.0 license or a
 */
 * Use {@code phone} (which creates ngrams) for the {@code analyzer} and {@code phone-search} (which doesn't create ngrams)  
 * You can use the {@code phone} and {@code phone-search} analyzers on your fields to index phone numbers.
    private final boolean addNgrams;  
public class PhoneNumberAnalyzer extends Analyzer {
    }
/**
    private final Settings settings;
import org.apache.lucene.analysis.Analyzer;
 * SPDX-License-Identifier: Apache-2.0
     * @param addNgrams defines whether ngrams for the phone number should be added. Set to true for indexing and false for search.
    public PhoneNumberAnalyzer(final Settings settings, final boolean addNgrams) {
    }
 * Note that the tokens will not refer to a specific position in the stream as the tokenizer is expected to be used on strings
 * for the {@code search_analyzer}.
 * Analyzer for phone numbers, using {@link PhoneNumberTermTokenizer}.
 *  
 * compatible open source license.
 * </p>
 *
        return new Analyzer.TokenStreamComponents(tokenizer, tokenizer);  
 */  
package org.opensearch.analysis.phone;
 * </p>
}
/*  
 * You optionally can specify a region with the {@code phone-region} setting for the phone number which will ensure that
