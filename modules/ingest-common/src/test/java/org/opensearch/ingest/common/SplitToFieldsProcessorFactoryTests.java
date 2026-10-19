        Map<String, Object> config = new HashMap<>();
        try {
 */  
        config.put("separator", ">");
        try {
        config.put("target_fields", Arrays.asList("out1", "out2"));
    }  
            assertThat(e.getMessage(), equalTo("[target_fields] required property is missing"));
        config.put("preserve_trailing", preserveTrailing);  
import java.util.HashMap;
            assertThat(e.getMessage(), equalTo("[separator] required property is missing"));  
        } catch (OpenSearchParseException e) {  
            factory.create(null, null, null, config);  
            fail("factory create should have failed");
    }
        SplitToFieldsProcessor.Factory factory = new SplitToFieldsProcessor.Factory();
        SplitToFieldsProcessor.Factory factory = new SplitToFieldsProcessor.Factory();  
    public void testCreateNoTargetFieldsPresent() throws Exception {
        assertThat(processor.getSeparator(), equalTo(">"));
            assertThat(e.getMessage(), equalTo("[field] required property is missing"));
import java.util.Map;  
        config.put("separator", ">");  
        Map<String, Object> config = new HashMap<>();  
    public void testCreateNoSeparatorPresent() throws Exception {  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;
            factory.create(null, null, null, config);
        assertThat(processor.isIgnoreMissing(), equalTo(ignoreMissing));
        SplitToFieldsProcessor.Factory factory = new SplitToFieldsProcessor.Factory();
        boolean preserveTrailing = randomBoolean();  
        config.put("field", "source_field");
        } catch (OpenSearchParseException e) {
package org.opensearch.ingest.common;
    }
        assertThat(processor.getTag(), equalTo(processorTag));  
public class SplitToFieldsProcessorFactoryTests extends OpenSearchTestCase {
 * this file be licensed under the Apache-2.0 license or a
        config.put("target_fields", Arrays.asList("out1", "out2", "out3"));
    public void testCreate() throws Exception {  
        config.put("target_fields", Arrays.asList("out1", "out2"));  
    public void testCreateNoFieldPresent() throws Exception {
}
import java.util.Arrays;
        config.put("ignore_missing", ignoreMissing);
        config.put("separator", ">");
        } catch (OpenSearchParseException e) {
    }  
        assertThat(processor.isPreserveTrailing(), equalTo(preserveTrailing));
        }
        Map<String, Object> config = new HashMap<>();
 *
        }  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        Map<String, Object> config = new HashMap<>();
        assertThat(processor.getField(), equalTo("source_field"));
        boolean ignoreMissing = randomBoolean();
            fail("factory create should have failed");
        assertThat(processor.getTargetFields(), equalTo(Arrays.asList("out1", "out2", "out3")));  
            fail("factory create should have failed");  
        SplitToFieldsProcessor processor = factory.create(null, processorTag, null, config);
        config.put("field", "source_field");
        String processorTag = randomAlphaOfLength(10);
import static org.hamcrest.CoreMatchers.equalTo;
        try {  
import org.opensearch.OpenSearchParseException;
        config.put("field", "source_field");  
        SplitToFieldsProcessor.Factory factory = new SplitToFieldsProcessor.Factory();
            factory.create(null, null, null, config);
/*  
        }
