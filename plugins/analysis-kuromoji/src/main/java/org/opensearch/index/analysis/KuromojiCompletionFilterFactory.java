 * compatible open source license.
    public static Mode getMode(Settings settings) {
    public TokenStream create(TokenStream tokenStream) {
import org.opensearch.env.Environment;
        }  
package org.opensearch.index.analysis;
import org.opensearch.common.settings.Settings;
/*  
        return Mode.INDEX;
import org.apache.lucene.analysis.ja.JapaneseCompletionFilter;
    private final Mode mode;  
        if (modeSetting != null) {  
import org.opensearch.index.IndexSettings;  
            if ("index".equalsIgnoreCase(modeSetting)) {
import org.apache.lucene.analysis.TokenStream;
                return Mode.INDEX;
}
        super(indexSettings, name, settings);  
 */  
    }
import org.apache.lucene.analysis.ja.JapaneseCompletionFilter.Mode;  
 * SPDX-License-Identifier: Apache-2.0
    @Override
 *
            }
    }
public class KuromojiCompletionFilterFactory extends AbstractTokenFilterFactory {
    }
                return Mode.QUERY;
            } else if ("query".equalsIgnoreCase(modeSetting)) {  
        String modeSetting = settings.get("mode", null);
 * this file be licensed under the Apache-2.0 license or a
        return new JapaneseCompletionFilter(tokenStream, mode);  
        this.mode = getMode(settings);
    public KuromojiCompletionFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
 * The OpenSearch Contributors require contributions made to  
