        ByteArrayOutputStream docOut = new ByteArrayOutputStream();
        );  
/*  
        indexRequestBuilder.setSource(source, MediaTypeRegistry.JSON);
    public void testSetSource() throws Exception {  
import org.junit.After;
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 *
            XContentHelper.convertToJson(indexRequestBuilder.request().source(), true, indexRequestBuilder.request().getContentType())
/*
        XContentBuilder doc = XContentFactory.jsonBuilder(docOut).startObject().field("SomeKey", "SomeValue").endObject();  
import org.opensearch.test.OpenSearchTestCase;
    private static final String EXPECTED_SOURCE = "{\"SomeKey\":\"SomeValue\"}";
import org.opensearch.common.xcontent.XContentFactory;
 *
import java.io.ByteArrayOutputStream;
        Map<String, String> source = new HashMap<>();
        indexRequestBuilder.setSource(docOut.toByteArray(), MediaTypeRegistry.JSON);
        IndexRequestBuilder indexRequestBuilder = new IndexRequestBuilder(this.testClient, IndexAction.INSTANCE);
 * license agreements. See the NOTICE file distributed with
    @Before
 * ownership. Elasticsearch licenses this file to you under  
        doc = XContentFactory.jsonBuilder().startObject().field("SomeKey", "SomeValue").endObject();
    @Override
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
 * software distributed under the License is distributed on an
    /**  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
        assertEquals(  
 * You may obtain a copy of the License at  
}
 */
 * specific language governing permissions and limitations
/*  
    }  
        // force the Object... setter
 * Modifications Copyright OpenSearch Contributors. See
        indexRequestBuilder.setSource(source);
 * Licensed to Elasticsearch under one or more contributor  
    @After  
        assertEquals(EXPECTED_SOURCE, XContentHelper.convertToJson(indexRequestBuilder.request().source(), true));
import org.opensearch.test.client.NoOpClient;  
import org.opensearch.core.xcontent.XContentBuilder;
        indexRequestBuilder.setSource((Object) "SomeKey", "SomeValue");
 * not use this file except in compliance with the License.
        this.testClient = new NoOpClient(getTestName());
        super.setUp();
    }  
    @Override
        assertEquals(EXPECTED_SOURCE, XContentHelper.convertToJson(indexRequestBuilder.request().source(), true));
package org.opensearch.action.index;
        assertEquals(EXPECTED_SOURCE, XContentHelper.convertToJson(indexRequestBuilder.request().source(), true));
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.HashMap;
    }
    private NoOpClient testClient;
        doc.close();  
     */
        source.put("SomeKey", "SomeValue");  
 * Unless required by applicable law or agreed to in writing,
import java.util.Map;  
        indexRequestBuilder.setSource(doc);
        super.tearDown();  
 *  
    public void tearDown() throws Exception {
     * test setting the source for the request with different available setters
        doc.close();
 */  
        this.testClient.close();
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
import org.junit.Before;
        assertEquals(EXPECTED_SOURCE, XContentHelper.convertToJson(indexRequestBuilder.request().source(), true));  
 */  
import org.opensearch.common.xcontent.XContentHelper;
public class IndexRequestBuilderTests extends OpenSearchTestCase {
 * GitHub history for details.
            EXPECTED_SOURCE,
 * this work for additional information regarding copyright
    public void setUp() throws Exception {  
        assertEquals(EXPECTED_SOURCE, XContentHelper.convertToJson(indexRequestBuilder.request().source(), true));
        indexRequestBuilder.setSource("SomeKey", "SomeValue");
