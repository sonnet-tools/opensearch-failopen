import org.apache.lucene.analysis.Tokenizer;
 * SPDX-License-Identifier: Apache-2.0
        SimplePatternSplitTokenizerFactory factory = new SimplePatternSplitTokenizerFactory(
        assertTokenStreamContents(tokenizer, new String[] { "word1", "word2", "word3" });
    }  
        Tokenizer tokenizer = factory.create();
}  
            null,  
 * compatible open source license.
            "test",
 * this file be licensed under the Apache-2.0 license or a
public class SimplePatternTokenizerTests extends OpenSearchTokenStreamTestCase {
        assertTokenStreamContents(tokenizer, new String[] { "aaac", "bbbbc", "ac" });
            settings
    public void testComplexRegexRequiringDeterminizationSplit() throws IOException {
import org.opensearch.common.settings.Settings;
        Tokenizer tokenizer = factory.create();  
            "test",
            IndexSettingsModule.newIndexSettings(new Index("test", "_na_"), Settings.EMPTY),
 *
        tokenizer.setReader(new StringReader("aaac bbbbc ac"));
        );
package org.opensearch.analysis.common;
        tokenizer.setReader(new StringReader("word1   word2,,,word3"));  
        );  
        Settings settings = Settings.builder().put("pattern", "(a+|b+)*c").build();
 * The OpenSearch Contributors require contributions made to  
    }
import java.io.IOException;
/*  
import org.opensearch.core.index.Index;  
    public void testComplexRegexRequiringDeterminization() throws IOException {  
import org.opensearch.test.OpenSearchTokenStreamTestCase;
        Settings settings = Settings.builder().put("pattern", "(\\s+|,+)*").build();  
import java.io.StringReader;
        SimplePatternTokenizerFactory factory = new SimplePatternTokenizerFactory(
 */  
import org.opensearch.test.IndexSettingsModule;
            null,
            settings  
            IndexSettingsModule.newIndexSettings(new Index("test", "_na_"), Settings.EMPTY),  
