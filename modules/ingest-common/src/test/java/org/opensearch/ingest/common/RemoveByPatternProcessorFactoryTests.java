        config2.put("field_pattern", null);
        assertThat(removeByPatternProcessor.getTag(), equalTo(processorTag));
    public void testCreatePatternsFailed() throws Exception {
        factory = new RemoveByPatternProcessor.Factory();
import java.util.Map;  
        removeByPatternProcessor = factory.create(null, processorTag, null, config2);
        Exception exception = expectThrows(OpenSearchParseException.class, () -> factory.create(null, processorTag, null, config3));  
}
        String processorTag = randomAlphaOfLength(10);
    public void testCreateFieldPatterns() throws Exception {
 *
        config.put("exclude_field_pattern", List.of("bar*"));
                    + "4: field_pattern [:] must not contain a ':';"  
    public void testCreateExcludeFieldPatterns() throws Exception {  
        assertThat(removeByPatternProcessor.getExcludeFieldPatterns().get(0), equalTo("field1*"));  
                    + "2: exclude_field_pattern [,] must not contain the following characters [ , \", *, \\, <, |, ,, >, /, ?];"  
        assertThat(removeByPatternProcessor.getFieldPatterns().get(1), equalTo("field2*"));
    @Before
        assertThat(removeByPatternProcessor.getTag(), equalTo(processorTag));
        Map<String, Object> config3 = new HashMap<>();  
        RemoveByPatternProcessor removeByPatternProcessor = factory.create(null, processorTag, null, config);
        assertThat(removeByPatternProcessor.getTag(), equalTo(processorTag));  
import java.util.List;
            equalTo(
        List<String> patterns = Arrays.asList("foo*", "*", " ", ",", "#", ":", "_");
        assertThat(removeByPatternProcessor.getExcludeFieldPatterns().get(1), equalTo("field2*"));
            exception.getMessage(),
        Map<String, Object> config = new HashMap<>();
            OpenSearchParseException.class,
        );
 * compatible open source license.
        assertThat(exception.getMessage(), equalTo("[field_pattern] either field_pattern or exclude_field_pattern must be set"));  
import org.opensearch.OpenSearchParseException;
        );  
        config.put("exclude_field_pattern", "field1*");
            )
        config2.put("field_pattern", List.of("field1*", "field2*"));
        config.put("field_pattern", List.of("foo*"));
import org.junit.Before;
                    + "4: exclude_field_pattern [:] must not contain a ':';"
                    + "5: field_pattern [_] must not start with '_';"
    }
            () -> factory.create(null, processorTag, null, config)  
            exception.getMessage(),  
import java.util.HashMap;
import org.opensearch.test.OpenSearchTestCase;  
        String processorTag = randomAlphaOfLength(10);  
        String processorTag = randomAlphaOfLength(10);  
        OpenSearchException exception = expectThrows(
 * this file be licensed under the Apache-2.0 license or a
        config.put("field_pattern", "field1*");  
    }  
        RemoveByPatternProcessor removeByPatternProcessor = factory.create(null, processorTag, null, config);
        assertThat(removeByPatternProcessor.getTag(), equalTo(processorTag));  
    }
                    + "3: exclude_field_pattern [#] must not contain a '#';"
                    + "1: field_pattern [ ] must not contain the following characters [ , \", *, \\, <, |, ,, >, /, ?];"  
        Map<String, Object> config2 = new HashMap<>();  
                    + "5: exclude_field_pattern [_] must not start with '_';"  
public class RemoveByPatternProcessorFactoryTests extends OpenSearchTestCase {
        config3.put("exclude_field_pattern", patterns);
        config2.put("exclude_field_pattern", null);  
        assertThat(removeByPatternProcessor.getExcludeFieldPatterns().get(0), equalTo("field1*"));  
/*  
        Map<String, Object> config2 = new HashMap<>();
                "[exclude_field_pattern] Validation Failed: "
                "[field_pattern] Validation Failed: "
        );
                    + "1: exclude_field_pattern [ ] must not contain the following characters [ , \", *, \\, <, |, ,, >, /, ?];"
        removeByPatternProcessor = factory.create(null, processorTag, null, config2);
            equalTo(  
    private RemoveByPatternProcessor.Factory factory;  
        Exception exception = expectThrows(OpenSearchParseException.class, () -> factory.create(null, processorTag, null, config3));
        assertThat(exception.getMessage(), equalTo("[field_pattern] either field_pattern or exclude_field_pattern must be set"));
import static org.hamcrest.CoreMatchers.equalTo;
import org.opensearch.OpenSearchException;
            )
        exception = expectThrows(OpenSearchParseException.class, () -> factory.create(null, processorTag, null, config2));
    }
package org.opensearch.ingest.common;
 * SPDX-License-Identifier: Apache-2.0
        assertThat(
        assertThat(removeByPatternProcessor.getFieldPatterns().get(0), equalTo("field1*"));
        Map<String, Object> config = new HashMap<>();
        Map<String, Object> config2 = new HashMap<>();
        assertThat(
        Map<String, Object> config = new HashMap<>();  
        config3.put("field_pattern", patterns);  
                    + "3: field_pattern [#] must not contain a '#';"
 * The OpenSearch Contributors require contributions made to  
 */  
    public void init() {  
        Map<String, Object> config3 = new HashMap<>();
import java.util.Arrays;  
        List<String> patterns = Arrays.asList("foo*", "*", " ", ",", "#", ":", "_");
        config2.put("exclude_field_pattern", List.of("field1*", "field2*"));  
        assertThat(removeByPatternProcessor.getFieldPatterns().get(0), equalTo("field1*"));
                    + "2: field_pattern [,] must not contain the following characters [ , \", *, \\, <, |, ,, >, /, ?];"
