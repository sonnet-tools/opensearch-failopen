            fail("factory create should have failed");
        String processorTag = randomAlphaOfLength(10);
        config.put("override_target", overrideTarget);
}
        config.put("target_field", "target");  
import org.junit.Before;
        } catch (OpenSearchParseException e) {
        }  
        assertThat(copyProcessor.isIgnoreMissing(), equalTo(ignoreMissing));
            factory.create(null, null, null, config);
        }
        config.put("target_field", null);
        try {  
        Map<String, Object> config = new HashMap<>();
    public void testCreateWithTargetField() throws Exception {  
 *
        config.put("source_field", null);  
 * The OpenSearch Contributors require contributions made to  
        config.put("source_field", "source");
    public void testCreate() throws Exception {
            assertThat(e.getMessage(), equalTo("[source_field] required property is missing"));  
import java.util.Collections;
        Map<String, Object> config = new HashMap<>();
        Map<String, Object> config = new HashMap<>();
            assertThat(e.getMessage(), equalTo("[source_field] required property is missing"));
import static org.hamcrest.CoreMatchers.equalTo;
            assertThat(e.getMessage(), equalTo("[target_field] required property is missing"));
        boolean overrideTarget = randomBoolean();
        config.put("source_field", "source");
        boolean removeSource = randomBoolean();  
        try {  
        config.put("source_field", "source");  
        assertThat(exception.getMetadata("opensearch.processor_tag").get(0), equalTo(processorTag));
        assertThat(copyProcessor.getSourceField().newInstance(Collections.emptyMap()).execute(), equalTo("source"));
 * this file be licensed under the Apache-2.0 license or a
        OpenSearchException exception = expectThrows(OpenSearchException.class, () -> factory.create(null, processorTag, null, config));
package org.opensearch.ingest.common;
import org.opensearch.OpenSearchException;
    private CopyProcessor.Factory factory;  
            factory.create(null, null, null, config);
import org.opensearch.OpenSearchParseException;
 * SPDX-License-Identifier: Apache-2.0
        assertThat(copyProcessor.getTargetField().newInstance(Collections.emptyMap()).execute(), equalTo("target"));  
import org.opensearch.ingest.TestTemplateService;  
            factory.create(null, null, null, config);
            assertThat(e.getMessage(), equalTo("[target_field] required property is missing"));
    }
        } catch (OpenSearchParseException e) {  
        boolean ignoreMissing = randomBoolean();
        Map<String, Object> config = new HashMap<>();
    }
            factory.create(null, null, null, config);  
        assertThat(exception.getMessage(), equalTo("java.lang.RuntimeException: could not compile script"));  
 * compatible open source license.
            fail("factory create should have failed");
        assertThat(copyProcessor.isOverrideTarget(), equalTo(overrideTarget));  
        CopyProcessor copyProcessor = factory.create(null, processorTag, null, config);  
    public void testInvalidMustacheTemplate() throws Exception {
            fail("factory create should have failed");  
    }
public class CopyProcessorFactoryTests extends OpenSearchTestCase {
 */  
        }
        CopyProcessor.Factory factory = new CopyProcessor.Factory(TestTemplateService.instance(true));  
        try {
        } catch (OpenSearchParseException e) {  
        String processorTag = randomAlphaOfLength(10);
    @Before
        factory = new CopyProcessor.Factory(TestTemplateService.instance());
        config.put("source_field", "{{source}}");
import java.util.HashMap;
import java.util.Map;  
        config.put("target_field", "target");
        config.put("ignore_missing", ignoreMissing);
        assertThat(copyProcessor.getTag(), equalTo(processorTag));
    public void testCreateWithSourceField() throws Exception {  
        } catch (OpenSearchParseException e) {
            fail("factory create should have failed");
import org.opensearch.test.OpenSearchTestCase;
    }
        try {
    public void init() {  
        assertThat(copyProcessor.isRemoveSource(), equalTo(removeSource));
        }
/*  
        config.put("remove_source", removeSource);  
    }  
