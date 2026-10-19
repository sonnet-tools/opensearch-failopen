                .put("index.analysis.filter.my_concatenate_graph.type", "concatenate_graph")
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
            new CommonAnalysisModulePlugin()
    public void testTokenizerEmptySeparator() throws IOException {  
 * compatible open source license.
        assertTokenStreamContents(tokenFilter.create(tokenizer), new String[] { "PowerShot+Is+AweSome" });  
    public void testPreservePositionIncrementsDefault() throws IOException {  
/*  
            Settings.builder()
import java.io.StringReader;
        assertTokenStreamContents(tokenFilter.create(tokenizer), new String[] { "PowerShot Is AweSome" });  
import java.io.IOException;  
                .put("index.analysis.filter.my_concatenate_graph.token_separator", "")
        assertTokenStreamContents(tokenFilter.create(cannedTokenStream), new String[] { "a+b+d" });
import org.opensearch.test.OpenSearchTokenStreamTestCase;
        );  
        // all tokens will be in the same position
    }
            new CommonAnalysisModulePlugin()
        // <start> ---> "Power" --> "Shot" ---> "Is" ---> "Awe" ---> "Some" --- <end>  
                .put("index.analysis.analyzer.my_analyzer.type", "custom")
            )
                .build(),
    /**
import org.apache.lucene.analysis.TokenStream;
                .put("index.analysis.filter.my_concatenate_graph.type", "concatenate_graph")  
                .build(),  
                .put("index.analysis.analyzer.my_analyzer.filter", "my_word_delimiter, my_concatenate_graph")  
                .put("index.analysis.filter.my_concatenate_graph.max_graph_expansions", "3")
import org.opensearch.index.analysis.AnalysisTestsHelper;  
import org.apache.lucene.tests.analysis.CannedTokenStream;
                .put("index.analysis.filter.my_word_delimiter.type", "word_delimiter_graph")
        // | | | |
        );
        Tokenizer tokenizer = new WhitespaceTokenizer();  
    }  
        );
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_concatenate_graph");
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
    public void testTokenizerCustomizedSeparator() throws IOException {  
            "PowerShot Is AweSome" };
        // the gap between a and b is preserved
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
                .build(),
        );
                Settings.builder()
}
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
 * SPDX-License-Identifier: Apache-2.0
        String[] expected = new String[] {
        tokenizer.setReader(new StringReader(source));
 * this file be licensed under the Apache-2.0 license or a
            new CommonAnalysisModulePlugin()
        );
                .put("index.analysis.filter.my_concatenate_graph.type", "concatenate_graph")
                .put("index.analysis.filter.my_concatenate_graph.type", "concatenate_graph")
                    .put("index.analysis.filter.my_concatenate_graph.token_separator", "11")
                .put("index.analysis.filter.my_concatenate_graph.token_separator", "+")
        String source = "PowerShot Is AweSome";
        // the gap between a and b is not preserved  
        Tokenizer tokenizer = new WhitespaceTokenizer();  
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_concatenate_graph");
            "PowerShot Is Awe Some",
import org.opensearch.common.settings.Settings;
 */  
        NamedAnalyzer analyzer = analysis.indexAnalyzers.get("my_analyzer");
import org.apache.lucene.analysis.Tokenizer;
        assertAnalyzesToPositions(analyzer, source, expected, expectedPosIncrements, expectedPosLengths);  
                .put("index.analysis.analyzer.my_analyzer.tokenizer", "whitespace")  
        // Expected output from word_delimiter_graph is a graph:
        );  
                .build(),
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.analysis.core.WhitespaceTokenizer;  
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("concatenate_graph");
        assertTokenStreamContents(tokenFilter.create(cannedTokenStream), new String[] { "a++b+d" });  
            Settings.builder()  
        CannedTokenStream cannedTokenStream = new CannedTokenStream(  
        );
            new CommonAnalysisModulePlugin()  
     */
            Settings.builder()
        tokenizer.setReader(new StringReader(source));
            "Power Shot Is AweSome",  
                new CommonAnalysisModulePlugin()  
            new Token("d", 1, 4, 5)  
            Settings.builder()
            () -> AnalysisTestsHelper.createTestAnalysisFromSettings(  
    }
    public void testMaxGraphExpansion() throws IOException {  
        CannedTokenStream cannedTokenStream = new CannedTokenStream(
                .put("index.analysis.analyzer.my_analyzer.filter", "my_word_delimiter, my_concatenate_graph")
        );
import org.opensearch.index.analysis.NamedAnalyzer;
    public void testPreservePositionIncrementsTrue() throws IOException {
            Settings.builder()
                    .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        tokenizer.setReader(new StringReader(source));
        int[] expectedPosIncrements = new int[] { 1, 0, 0, 0 };
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_concatenate_graph");
import org.apache.lucene.tests.analysis.Token;
                    .build(),
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
            Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString()).build(),  
                .put("index.analysis.filter.my_word_delimiter.type", "word_delimiter_graph")
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
    }
        // --> "PowerShot" -------- --> "AweSome" ---------
    public void testSimpleTokenizerAndConcatenate() throws IOException {
                .put("index.analysis.filter.my_concatenate_graph.token_separator", "+")
        assertTokenStreamContents(tokenFilter.create(tokenizer), new String[] { "PowerShotIsAweSome" });  
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
import org.opensearch.index.analysis.TokenFilterFactory;
            new CommonAnalysisModulePlugin()
            IllegalArgumentException.class,
        expectThrows(TooComplexToDeterminizeException.class, tokenStream::incrementToken);  
            Settings.builder()
            new Token("a", 1, 0, 1),
        String source = "PowerShot Is AweSome";
    }
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_concatenate_graph");  
 *
                    .put("index.analysis.filter.my_concatenate_graph.type", "concatenate_graph")  
        String source = "PowerShot Is AweSome";  
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
                .put("index.analysis.filter.my_concatenate_graph.type", "concatenate_graph")
    }
    public void testGraph() throws IOException {  
                .put("index.analysis.filter.my_word_delimiter.catenate_words", "true")
                .put("index.analysis.filter.my_concatenate_graph.type", "concatenate_graph")  
        expectThrows(
package org.opensearch.analysis.common;
            new CommonAnalysisModulePlugin()
    public void testInvalidSeparator() {  
        int[] expectedPosLengths = new int[] { 1, 1, 1, 1 };  
    }
import org.opensearch.test.OpenSearchTestCase;  
    }
        // and this filter will traverse through all possible paths to produce concatenated tokens  
            "Power Shot Is Awe Some",
                .build(),  
        tokenStream.reset();
                .put("index.analysis.filter.my_concatenate_graph.token_separator", "+")  
        );
            new Token("d", 1, 4, 5)
                .build(),  
                .put("index.analysis.filter.my_word_delimiter.catenate_words", "true")
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        // Expected output from Whitespace Tokenizer is: "PowerShot" --> "Is" --> "Awe" --> "Some"
import org.opensearch.env.Environment;
public class ConcatenateGraphTokenFilterFactoryTests extends OpenSearchTokenStreamTestCase {  
                .put("index.analysis.filter.my_concatenate_graph.preserve_position_increments", "true")
import org.apache.lucene.util.automaton.TooComplexToDeterminizeException;  
        );
        String source = "PowerShot Is AweSome";
            new Token("a", 1, 0, 1),  
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
                .put("index.analysis.analyzer.my_analyzer.tokenizer", "whitespace")
            new Token("b", 2, 2, 3), // there is a gap, posInc is 2
     * Similar to the {@link #testGraph()} case, there will be 4 paths generated by word_delimiter_graph.  
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
                .put("index.analysis.analyzer.my_analyzer.type", "custom")
            new CommonAnalysisModulePlugin()  
            new Token("b", 2, 2, 3), // there is a gap, posInc is 2
     * By setting max_graph_expansions to 3, we expect an exception.
        String source = "PowerShot Is AweSome";
        TokenStream tokenStream = analysis.indexAnalyzers.get("my_analyzer").tokenStream("dummy", source);
        Tokenizer tokenizer = new WhitespaceTokenizer();  
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
