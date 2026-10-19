        NamedAnalyzer analyzer = analysis.indexAnalyzers.get("my_analyzer");
        );
        // | | | |
        );
                .put("index.analysis.analyzer.my_analyzer.filter", "my_word_delimiter, my_concatenate_graph")
public class ConcatenateGraphTokenFilterFactoryTests extends OpenSearchTokenStreamTestCase {
            Settings.builder()
    public void testSimpleTokenizerAndConcatenate() throws IOException {
        );
        // Expected output from word_delimiter_graph is a graph:
    }
            "Power Shot Is Awe Some",
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            new Token("b", 2, 2, 3), // there is a gap, posInc is 2
                .put("index.analysis.filter.my_concatenate_graph.token_separator", "")
        int[] expectedPosIncrements = new int[] { 1, 0, 0, 0 };
    public void testInvalidSeparator() {
                .put("index.analysis.analyzer.my_analyzer.type", "custom")
                .build(),
    public void testGraph() throws IOException {
    public void testTokenizerCustomizedSeparator() throws IOException {
    /**
            IllegalArgumentException.class,
            new Token("d", 1, 4, 5)
                .put("index.analysis.analyzer.my_analyzer.tokenizer", "whitespace")
import org.apache.lucene.tests.analysis.CannedTokenStream;
            new Token("b", 2, 2, 3), // there is a gap, posInc is 2
import org.opensearch.index.analysis.AnalysisTestsHelper;
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
                    .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        CannedTokenStream cannedTokenStream = new CannedTokenStream(
                .put("index.analysis.analyzer.my_analyzer.tokenizer", "whitespace")
 * SPDX-License-Identifier: Apache-2.0
                .put("index.analysis.filter.my_concatenate_graph.max_graph_expansions", "3")
                .put("index.analysis.analyzer.my_analyzer.type", "custom")
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
                    .put("index.analysis.filter.my_concatenate_graph.token_separator", "11")
                .put("index.analysis.filter.my_word_delimiter.catenate_words", "true")
/*
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
                    .build(),
                .build(),
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_concatenate_graph");
import org.opensearch.test.OpenSearchTestCase;
            Settings.builder()
        // <start> ---> "Power" --> "Shot" ---> "Is" ---> "Awe" ---> "Some" --- <end>
        String source = "PowerShot Is AweSome";
        );
        );
 *
                new CommonAnalysisModulePlugin()
    public void testPreservePositionIncrementsDefault() throws IOException {
import org.apache.lucene.analysis.Tokenizer;
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
 */
                .put("index.analysis.filter.my_concatenate_graph.type", "concatenate_graph")
                .build(),
        );
    }
                .build(),
                Settings.builder()
        // the gap between a and b is preserved
        assertTokenStreamContents(tokenFilter.create(tokenizer), new String[] { "PowerShotIsAweSome" });
                .put("index.analysis.filter.my_word_delimiter.type", "word_delimiter_graph")
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        // all tokens will be in the same position
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
import org.opensearch.index.analysis.NamedAnalyzer;
            new CommonAnalysisModulePlugin()
            new CommonAnalysisModulePlugin()
    }
        String source = "PowerShot Is AweSome";
        assertTokenStreamContents(tokenFilter.create(cannedTokenStream), new String[] { "a+b+d" });
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
        assertTokenStreamContents(tokenFilter.create(tokenizer), new String[] { "PowerShot Is AweSome" });
            Settings.builder()
        Tokenizer tokenizer = new WhitespaceTokenizer();
    }
        String source = "PowerShot Is AweSome";
    public void testTokenizerEmptySeparator() throws IOException {
        );
                .put("index.analysis.filter.my_concatenate_graph.type", "concatenate_graph")
}
     * By setting max_graph_expansions to 3, we expect an exception.
                .put("index.analysis.filter.my_concatenate_graph.type", "concatenate_graph")
        assertTokenStreamContents(tokenFilter.create(cannedTokenStream), new String[] { "a++b+d" });
            )
        expectThrows(
            "PowerShot Is Awe Some",
        tokenizer.setReader(new StringReader(source));
import org.apache.lucene.tests.analysis.Token;
        // the gap between a and b is not preserved
            new CommonAnalysisModulePlugin()
            Settings.builder()
            Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString()).build(),
            new Token("a", 1, 0, 1),
                .put("index.analysis.analyzer.my_analyzer.filter", "my_word_delimiter, my_concatenate_graph")
        tokenizer.setReader(new StringReader(source));
                .put("index.analysis.filter.my_word_delimiter.type", "word_delimiter_graph")
        tokenizer.setReader(new StringReader(source));
                .build(),
        String[] expected = new String[] {
        // --> "PowerShot" -------- --> "AweSome" ---------
                    .put("index.analysis.filter.my_concatenate_graph.type", "concatenate_graph")
                .build(),
        assertAnalyzesToPositions(analyzer, source, expected, expectedPosIncrements, expectedPosLengths);
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("concatenate_graph");
import org.opensearch.common.settings.Settings;
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
        expectThrows(TooComplexToDeterminizeException.class, tokenStream::incrementToken);
                .put("index.analysis.filter.my_concatenate_graph.token_separator", "+")
            "Power Shot Is AweSome",
                .put("index.analysis.filter.my_word_delimiter.catenate_words", "true")
                .put("index.analysis.filter.my_concatenate_graph.type", "concatenate_graph")
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
     */
        String source = "PowerShot Is AweSome";
        );
package org.opensearch.analysis.common;
import java.io.IOException;
            "PowerShot Is AweSome" };
    }
import org.opensearch.index.analysis.TokenFilterFactory;
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_concatenate_graph");
        );
    }
            new Token("d", 1, 4, 5)
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_concatenate_graph");
    }
                .put("index.analysis.filter.my_concatenate_graph.token_separator", "+")
            new CommonAnalysisModulePlugin()
 * this file be licensed under the Apache-2.0 license or a
        );
    }
 * compatible open source license.
            new Token("a", 1, 0, 1),
        assertTokenStreamContents(tokenFilter.create(tokenizer), new String[] { "PowerShot+Is+AweSome" });
        Tokenizer tokenizer = new WhitespaceTokenizer();
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
        // Expected output from Whitespace Tokenizer is: "PowerShot" --> "Is" --> "Awe" --> "Some"
                .put("index.analysis.filter.my_concatenate_graph.type", "concatenate_graph")
            new CommonAnalysisModulePlugin()
    public void testPreservePositionIncrementsTrue() throws IOException {
                .put("index.analysis.filter.my_concatenate_graph.token_separator", "+")
 * The OpenSearch Contributors require contributions made to
        String source = "PowerShot Is AweSome";
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
import java.io.StringReader;
    public void testMaxGraphExpansion() throws IOException {
import org.opensearch.env.Environment;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.apache.lucene.util.automaton.TooComplexToDeterminizeException;
        tokenStream.reset();
        int[] expectedPosLengths = new int[] { 1, 1, 1, 1 };
import org.opensearch.test.OpenSearchTokenStreamTestCase;
            () -> AnalysisTestsHelper.createTestAnalysisFromSettings(
     * Similar to the {@link #testGraph()} case, there will be 4 paths generated by word_delimiter_graph.
import org.apache.lucene.analysis.TokenStream;
        Tokenizer tokenizer = new WhitespaceTokenizer();
        // and this filter will traverse through all possible paths to produce concatenated tokens
            new CommonAnalysisModulePlugin()
        TokenStream tokenStream = analysis.indexAnalyzers.get("my_analyzer").tokenStream("dummy", source);
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
            Settings.builder()
            new CommonAnalysisModulePlugin()
        CannedTokenStream cannedTokenStream = new CannedTokenStream(
                .put("index.analysis.filter.my_concatenate_graph.preserve_position_increments", "true")
                .put("index.analysis.filter.my_concatenate_graph.type", "concatenate_graph")
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_concatenate_graph");
            Settings.builder()
