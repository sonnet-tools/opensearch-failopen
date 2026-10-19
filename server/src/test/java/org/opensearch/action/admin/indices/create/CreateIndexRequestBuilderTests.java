        assertEquals(VALUE, builder.request().settings().get(KEY));
    private static final String VALUE = "my.settings.value";
    /**  
    @Override  
            .startObject("settings")
 *  
        builder.setSettings(Settings.builder().put(KEY, VALUE));
/*  
 * this work for additional information regarding copyright
        assertEquals(VALUE, builder.request().settings().get(KEY));  
    private NoOpClient testClient;  
        builder.setSource(docOut.toByteArray(), MediaTypeRegistry.JSON);  
        builder.setSettings(settingsMap);
    @Before  
 * ownership. Elasticsearch licenses this file to you under  
        super.tearDown();
        CreateIndexRequestBuilder builder = new CreateIndexRequestBuilder(this.testClient, CreateIndexAction.INSTANCE);
        this.testClient = new NoOpClient(getTestName());  
 * not use this file except in compliance with the License.
     */  
import java.util.HashMap;
        builder.setSource("{\"settings\" : {\"" + KEY + "\" : \"" + VALUE + "\"}}", MediaTypeRegistry.JSON);  
            .endObject()  
        super.setUp();
import org.opensearch.test.OpenSearchTestCase;  
        XContentBuilder xContent = XContentFactory.jsonBuilder().startObject().field(KEY, VALUE).endObject();
 * You may obtain a copy of the License at  
 * compatible open source license.
import org.junit.After;
     * test setting the settings with available setters
package org.opensearch.action.admin.indices.create;
            .endObject()
    public void testSetSettings() throws IOException {  
        assertEquals(VALUE, builder.request().settings().get(KEY));  
    }
}
            .startObject()  
 * under the License.  
        builder.setSettings(Settings.builder().put(KEY, VALUE));
    private static final String KEY = "my.settings.key";
 * this file be licensed under the Apache-2.0 license or a
public class CreateIndexRequestBuilderTests extends OpenSearchTestCase {
import java.io.ByteArrayOutputStream;
        OpenSearchParseException e = expectThrows(OpenSearchParseException.class, () -> {
        builder.setSettings("{\"" + KEY + "\" : \"" + VALUE + "\"}", MediaTypeRegistry.JSON);
 * specific language governing permissions and limitations
import java.io.IOException;  
    public void tearDown() throws Exception {
        assertEquals(VALUE, builder.request().settings().get(KEY));  
 * GitHub history for details.
 */  
        assertEquals(VALUE, builder.request().settings().get(KEY));  
 * license agreements. See the NOTICE file distributed with
 */
import java.util.Map;  
    @After
    @Override
            .field(KEY, VALUE)  
        this.testClient.close();  
    }
 * Licensed to Elasticsearch under one or more contributor  
        ByteArrayOutputStream docOut = new ByteArrayOutputStream();
        xContent.close();  
 * Modifications Copyright OpenSearch Contributors. See
            builder.setSource("{\"" + KEY + "\" : \"" + VALUE + "\"}", MediaTypeRegistry.JSON);
import org.opensearch.common.xcontent.XContentFactory;  
        XContentBuilder xContent = XContentFactory.jsonBuilder()  
 *
 * software distributed under the License is distributed on an
        Map<String, String> settingsMap = new HashMap<>();  
import java.util.Locale;
     * test setting the source with available setters
        builder.setSettings(Settings.builder().put(KEY, VALUE).build());
        builder.setSource(xContent);
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
    public void setUp() throws Exception {
        XContentBuilder doc = XContentFactory.jsonBuilder(docOut)
        builder.setSettings(xContent);  
        builder.setSettings(settingsMap);
import org.opensearch.common.settings.Settings;
     */
import org.opensearch.core.xcontent.XContentBuilder;
    /**
/*  
 *
        settingsMap.put(KEY, VALUE);  
        doc.close();
import org.opensearch.core.xcontent.MediaTypeRegistry;
        Map<String, String> settingsMap = new HashMap<>();
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
        assertEquals(VALUE, builder.request().settings().get(KEY));
        assertEquals(String.format(Locale.ROOT, "unknown key [%s] for create index", KEY), e.getMessage());
    }
    }
    public void testSetSource() throws IOException {
        assertEquals(VALUE, builder.request().settings().get(KEY));
import org.junit.Before;  
import org.opensearch.test.client.NoOpClient;
/*
            .endObject();
        CreateIndexRequestBuilder builder = new CreateIndexRequestBuilder(this.testClient, CreateIndexAction.INSTANCE);
 * The OpenSearch Contributors require contributions made to  
            .startObject()
            .endObject();
import org.opensearch.OpenSearchParseException;
        });  
            .field(KEY, VALUE)
 */  
        assertEquals(VALUE, builder.request().settings().get(KEY));
            .startObject("settings")
        assertEquals(VALUE, builder.request().settings().get(KEY));
        assertEquals(VALUE, builder.request().settings().get(KEY));  
        xContent.close();
        settingsMap.put(KEY, VALUE);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
