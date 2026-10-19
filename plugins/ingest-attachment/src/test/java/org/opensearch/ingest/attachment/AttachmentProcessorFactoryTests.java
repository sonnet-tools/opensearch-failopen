        config.put("target_field", "_field");
public class AttachmentProcessorFactoryTests extends OpenSearchTestCase {  
            AttachmentProcessor.Property property = AttachmentProcessor.Property.values()[i];
 *
        config.put("ignore_missing", true);
        assertFalse(processor.isIgnoreMissing());
        Map<String, Object> config = new HashMap<>();
        }
        assertThat(processor.getProperties(), sameInstance(AttachmentProcessor.Factory.DEFAULT_PROPERTIES));
        config.put("field", "_field");  
import java.util.HashMap;
 * this work for additional information regarding copyright
        assertTrue(processor.isIgnoreMissing());
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 */
 *
        config.put("indexed_chars", indexedChars);
        List<String> fieldNames = new ArrayList<>();
 * Modifications Copyright OpenSearch Contributors. See
        } catch (OpenSearchParseException e) {
        assertThat(processor.getField(), equalTo("_field"));  
        config.put("field", "_field");  
        String processorTag = randomAlphaOfLength(10);  
            fail("exception expected");
 */  
        try {
    public void testIgnoreMissing() throws Exception {
 * Unless required by applicable law or agreed to in writing,
        assertThat(processor.getTag(), equalTo(processorTag));
import java.util.Set;
        }
        AttachmentProcessor processor = factory.create(null, null, null, config);
import org.opensearch.test.OpenSearchTestCase;
        String processorTag = randomAlphaOfLength(10);  
            // ensure allowed fields are mentioned
import static org.hamcrest.Matchers.sameInstance;  
            factory.create(null, null, null, config);
        config.put("field", "_field");  
 * compatible open source license.
        }  
import java.util.ArrayList;
            assertThat(e.getMessage(), equalTo("[properties] property isn't a list, but of type [java.lang.String]"));  
 * GitHub history for details.
        assertThat(processor.getTag(), equalTo(processorTag));
        int indexedChars = randomIntBetween(1, 100000);
        for (int i = 0; i < numFields; i++) {  
import static org.hamcrest.core.Is.is;
        Map<String, Object> config = new HashMap<>();
 * license agreements. See the NOTICE file distributed with
        assertThat(processor.getField(), equalTo("_field"));  
 * KIND, either express or implied.  See the License for the
            }
 * software distributed under the License is distributed on an
            factory.create(null, null, null, config);  
    }  
        config.put("field", "_field");  
            fieldNames.add(property.name().toLowerCase(Locale.ROOT));  
        String processorTag = randomAlphaOfLength(10);
    public void testBuildIllegalFieldOption() throws Exception {
                assertThat(e.getMessage(), containsString(property.name()));
        config.put("properties", "invalid");
        AttachmentProcessor processor = factory.create(null, processorTag, null, config);
package org.opensearch.ingest.attachment;
        assertThat(processor.getTargetField(), equalTo("attachment"));
    public void testConfigureIndexedChars() throws Exception {  
        config.put("properties", Collections.singletonList("invalid"));
    }  
        assertThat(processor.getIndexedChars(), is(indexedChars));  
import java.util.Locale;  
    }
import org.opensearch.OpenSearchParseException;
        config.put("field", "_field");  
    }
        assertFalse(processor.isIgnoreMissing());  
    public void testBuildFields() throws Exception {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
            fail("exception expected");
        assertThat(processor.getTargetField(), equalTo("_field"));
    }
        config = new HashMap<>();
        Map<String, Object> config = new HashMap<>();
        Set<AttachmentProcessor.Property> properties = EnumSet.noneOf(AttachmentProcessor.Property.class);  
        try {  
import java.util.Map;
        assertThat(processor.getProperties(), sameInstance(AttachmentProcessor.Factory.DEFAULT_PROPERTIES));  
import java.util.Collections;
 * The OpenSearch Contributors require contributions made to  
/*  
 * Licensed to Elasticsearch under one or more contributor  
        assertFalse(processor.isIgnoreMissing());
 *  
import java.util.EnumSet;  
        config.put("field", "_field");
        assertThat(processor.getTag(), equalTo(processorTag));  
        } catch (OpenSearchParseException e) {  
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.containsString;
        int numFields = scaledRandomIntBetween(1, AttachmentProcessor.Property.values().length);
import java.util.List;
 * specific language governing permissions and limitations
        Map<String, Object> config = new HashMap<>();  
    public void testBuildDefaults() throws Exception {
        assertThat(processor.getProperties(), equalTo(properties));
        Map<String, Object> config = new HashMap<>();
        assertThat(processor.getField(), equalTo("_field"));
            properties.add(property);
}  
        AttachmentProcessor processor = factory.create(null, processorTag, null, config);
        assertThat(processor.getField(), equalTo("_field"));  
        AttachmentProcessor processor = factory.create(null, processorTag, null, config);
        config.put("field", "_field");  
            assertThat(e.getMessage(), containsString("[properties] illegal field option [invalid]"));
    private AttachmentProcessor.Factory factory = new AttachmentProcessor.Factory();
        assertThat(processor.getTargetField(), equalTo("attachment"));
import static org.hamcrest.Matchers.equalTo;
        Map<String, Object> config = new HashMap<>();
        AttachmentProcessor processor = factory.create(null, null, null, config);
    public void testBuildTargetField() throws Exception {
/*
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            for (AttachmentProcessor.Property property : AttachmentProcessor.Property.values()) {  
        config.put("properties", fieldNames);
/*  
        assertFalse(processor.isIgnoreMissing());
 * under the License.  
 * You may obtain a copy of the License at  
    }
