            Settings.builder()  
/*  
        }  
                .put("index.analysis.char_filter.my_mappings_char_filter.type", "mapping")
            int length = inputReader.read(tempBuff);  
        while (true) {
            RuntimeException ex = expectThrows(RuntimeException.class, () -> create(rule));
            new CommonAnalysisModulePlugin()
 * compatible open source license.
    public void testRulePartError() {  
            "a:>b"     // invalid delimiter
import org.opensearch.common.settings.Settings;
        }  
 * this file be licensed under the Apache-2.0 license or a
        );
import org.apache.lucene.analysis.CharFilter;
        );
import java.io.StringReader;  
        MappingCharFilterFactory mappingCharFilterFactory = (MappingCharFilterFactory) create(
            () -> create("# This is a comment", "# => _hashtag_", ":) => _happy_", "a:b")  
                .put("index.analysis.analyzer.my_analyzer.tokenizer", "standard")
            "a",       // no arrow
        RuntimeException ex = expectThrows(
    }  
            ":) => _happy_",
            "# This is a comment",  
import java.io.IOException;
        return analysis.charFilter.get("my_mappings_char_filter");
        assertEquals("Line [4]: Invalid mapping rule : [a:b]", ex.getMessage());
package org.opensearch.analysis.common;
import java.util.Arrays;
    public static CharFilterFactory create(String... rules) throws IOException {
            ":( => _sad_"  
        CharFilter inputReader = (CharFilter) mappingCharFilterFactory.create(new StringReader("I'm so :), I'm so :( #confused"));
    }
 * The OpenSearch Contributors require contributions made to  
        StringBuilder output = new StringBuilder();
    }
    }
}
                .put("index.analysis.analyzer.my_analyzer.char_filter", "my_mappings_char_filter")  
public class MappingCharFilterFactoryTests extends OpenSearchTestCase {  
            assertEquals("Line [1]: Invalid mapping rule : [" + rule + "]", ex.getMessage());
                .putList("index.analysis.char_filter.my_mappings_char_filter.mappings", rules)
import org.opensearch.index.analysis.AnalysisTestsHelper;
    public void testRulesOk() throws IOException {
 *
        char[] tempBuff = new char[14];  
            if (length == -1) break;
                .build(),  
import org.opensearch.env.Environment;  
        assertEquals("I'm so _happy_, I'm so _sad_ _hashtag_confused", output.toString());
        );
            "",        // empty  
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            RuntimeException.class,
        )) {  
            "# => _hashtag_",
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.index.analysis.CharFilterFactory;
 * SPDX-License-Identifier: Apache-2.0
        for (String rule : Arrays.asList(
    public void testRuleError() {
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
            output.append(tempBuff, 0, length);
 */  
