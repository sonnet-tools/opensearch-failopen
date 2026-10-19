}
import org.apache.lucene.analysis.TokenStream;
        super(indexSettings, name, settings);
        if (delimiter == null) {
            return DEFAULT_DELIMITER;
    DelimitedTermFrequencyTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
package org.opensearch.analysis.common;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.env.Environment;
        return new DelimitedTermFrequencyTokenFilter(tokenStream, delimiter);
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.analysis.miscellaneous.DelimitedTermFrequencyTokenFilter;
        throw new IllegalArgumentException(
            return delimiter.charAt(0);
/*  
import org.opensearch.index.IndexSettings;
    public static final char DEFAULT_DELIMITER = '|';  
    private static char parseDelimiter(Settings settings) {
        }
    }
            "Setting [" + DELIMITER + "] must be a single, non-null character. [" + delimiter + "] was provided."
 *
import org.opensearch.common.settings.Settings;  
    }  
        );  
    private final char delimiter;
 */  
    public TokenStream create(TokenStream tokenStream) {
        delimiter = parseDelimiter(settings);  
    }
 * compatible open source license.
import org.opensearch.index.analysis.AbstractTokenFilterFactory;  
    private static final String DELIMITER = "delimiter";
public class DelimitedTermFrequencyTokenFilterFactory extends AbstractTokenFilterFactory {
        String delimiter = settings.get(DELIMITER);  
        } else if (delimiter.length() == 1) {  
    @Override  
