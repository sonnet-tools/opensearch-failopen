import org.opensearch.OpenSearchParseException;
 * SPDX-License-Identifier: Apache-2.0
        try {
 * compatible open source license.
            factory.create(null, null, null, config);  
}
            targetField = randomAlphaOfLength(10);
 * The OpenSearch Contributors require contributions made to  
    }
    }
            );
package org.opensearch.ingest.common;
public class FingerprintProcessorFactoryTests extends OpenSearchTestCase {
        config.put("ignore_missing", ignoreMissing);  
    @Before
        if (randomBoolean()) {  
        if (randomBoolean()) {  
import java.util.List;
/*  
        }  
import java.util.Objects;  
        } catch (OpenSearchParseException e) {
        factory = new FingerprintProcessor.Factory();
import static org.hamcrest.CoreMatchers.equalTo;
    }
            fail("factory create should have failed");
        try {
        config.put("exclude_fields", excludeFields);
import java.util.Map;
        boolean ignoreMissing = randomBoolean();
        } else {
        Map<String, Object> config = new HashMap<>();
        } catch (OpenSearchParseException e) {
        String processorTag = randomAlphaOfLength(10);
        }
        assertThat(fingerprintProcessor.getFields(), equalTo(fields));
            assertThat(e.getMessage(), equalTo("[fields] field name cannot be null nor empty"));  
        config.put("fields", List.of(randomAlphaOfLength(10)));  
 */  
        List<String> fields = List.of(randomAlphaOfLength(10));  
    public void testCreateWithFields() throws Exception {
            fields.add("");
            factory.create(null, null, null, config);
        try {  
            fail("factory create should have failed");
        List<String> fields = null;
 * this file be licensed under the Apache-2.0 license or a
        assertThat(fingerprintProcessor.getTag(), equalTo(processorTag));  
            excludeFields.add("");
        }
import java.util.HashMap;  
        }
    }  
import java.util.ArrayList;
        FingerprintProcessor fingerprintProcessor = factory.create(null, processorTag, null, config);
            factory.create(null, null, null, config);  
import org.junit.Before;  
        if (randomBoolean()) {
        } else {
        config.put("fields", fields);
        assertThat(fingerprintProcessor.getTargetField(), equalTo(Objects.requireNonNullElse(targetField, "fingerprint")));  
    public void testCreate() throws Exception {
            fail("factory create should have failed");
    private FingerprintProcessor.Factory factory;  
 *
            fields = List.of(randomAlphaOfLength(10));
            fields.add(null);  
    public void testCreateWithHashMethod() throws Exception {
        List<String> excludeFields = new ArrayList<>();
        assertThat(fingerprintProcessor.isIgnoreMissing(), equalTo(ignoreMissing));
        config.put("target_field", targetField);  
        }
        Map<String, Object> config = new HashMap<>();
            assertThat(e.getMessage(), equalTo("[exclude_fields] field name cannot be null nor empty"));  
        try {
        config.put("exclude_fields", List.of(randomAlphaOfLength(10)));
import org.opensearch.test.OpenSearchTestCase;
        } else {  
                e.getMessage(),
    public void init() {  
        String targetField = null;
        }
            config.put("fields", fields);
            config.put("exclude_fields", excludeFields);
            assertThat(e.getMessage(), equalTo("[fields] either fields or exclude_fields can be set"));  
        config.put("hash_method", randomAlphaOfLength(10));
            excludeFields = List.of(randomAlphaOfLength(10));
        } catch (OpenSearchParseException e) {  
            fail("factory create should have failed");
        Map<String, Object> config = new HashMap<>();
        assertThat(fingerprintProcessor.getExcludeFields(), equalTo(excludeFields));
        if (randomBoolean()) {
        List<String> fields = new ArrayList<>();
        config = new HashMap<>();  
            excludeFields.add(null);  
            factory.create(null, null, null, config);  
        } catch (OpenSearchParseException e) {
        config = new HashMap<>();  
            assertThat(
        List<String> excludeFields = null;
        }  
        config.put("fields", fields);
                equalTo("[hash_method] hash method must be MD5@2.16.0, SHA-1@2.16.0, SHA-256@2.16.0 or SHA3-256@2.16.0")  
        }  
