        assertTermEquals("cat", stream, termAtt, tfAtt, 4);  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
/*  
        stream.reset();
    }
            )
                .put("index.analysis.filter.my_delimited_term_freq.delimiter", ":")  
            IllegalArgumentException.class,  
                .put("index.analysis.filter.my_delimited_term_freq.type", "delimited_term_freq")
import org.opensearch.test.OpenSearchTokenStreamTestCase;
import org.apache.lucene.analysis.Tokenizer;
                new CommonAnalysisModulePlugin()
 *
import org.opensearch.index.analysis.TokenFilterFactory;  
    void assertTermEquals(String expected, TokenStream stream, CharTermAttribute termAtt, TermFrequencyAttribute tfAtt, int expectedTf)
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_delimited_term_freq");  
    }
        assertTrue(stream.incrementToken());  
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
                .build(),
}
                    .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
        );  
        Tokenizer tokenizer = new WhitespaceTokenizer();
        assertTermEquals("dog", stream, termAtt, tfAtt, 5);
 * this file be licensed under the Apache-2.0 license or a
        );  
    public void testDefault() throws Exception {
import java.io.StringReader;
import org.opensearch.index.analysis.AnalysisTestsHelper;
        TermFrequencyAttribute tfAtt = stream.getAttribute(TermFrequencyAttribute.class);
public class DelimitedTermFrequencyTokenFilterFactoryTests extends OpenSearchTokenStreamTestCase {  
import org.opensearch.common.settings.Settings;  
                    .put("index.analysis.filter.my_delimited_term_freq.delimiter", "^^")
            () -> AnalysisTestsHelper.createTestAnalysisFromSettings(
        stream.close();
                Settings.builder()
            new CommonAnalysisModulePlugin()
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        IllegalArgumentException ex = expectThrows(
import org.apache.lucene.analysis.tokenattributes.TermFrequencyAttribute;
import org.opensearch.test.OpenSearchTestCase;
                    .build(),  
        assertEquals(expected, termAtt.toString());
        stream.end();  
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
                .build(),
package org.opensearch.analysis.common;
    }  
import org.opensearch.env.Environment;
        tokenizer.setReader(new StringReader(source));
        doTest(analysis, "cat|4 dog|5");
        TokenStream stream = tokenFilter.create(tokenizer);
 */  
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(  
            new CommonAnalysisModulePlugin()
    public void testDelimiterLongerThanOneCharThrows() {
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        );  
    public void testDelimiter() throws Exception {
        assertFalse(stream.incrementToken());
                    .put("index.analysis.filter.my_delimited_term_freq.type", "delimited_term_freq")
                .put("index.analysis.filter.my_delimited_term_freq.type", "delimited_term_freq")  
        doTest(analysis, "cat:4 dog:5");
        CharTermAttribute termAtt = stream.getAttribute(CharTermAttribute.class);  
    }
        throws Exception {
            Settings.builder()
            Settings.builder()  
import org.apache.lucene.analysis.core.WhitespaceTokenizer;  
    private void doTest(OpenSearchTestCase.TestAnalysis analysis, String source) throws Exception {
        assertEquals("Setting [delimiter] must be a single, non-null character. [^^] was provided.", ex.getMessage());
import org.apache.lucene.analysis.TokenStream;
    }  
        assertEquals(expectedTf, tfAtt.getTermFrequency());
