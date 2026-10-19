            .endObject()  
 * Unless required by applicable law or agreed to in writing,
            .startObject("read_alias")
        Map<String, Object> contentAsMap = XContentHelper.convertToMap(BytesReference.bytes(content), true, content.contentType()).v2();  
 */  
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
            .endObject()
public class RestCreateIndexActionTests extends OpenSearchTestCase {
            .endObject()
            .endObject();
            .endObject()  
import java.io.IOException;
        Map<String, Object> contentAsMap = XContentHelper.convertToMap(BytesReference.bytes(content), true, content.contentType()).v2();
 * GitHub history for details.
            true,
            .startObject("read_alias")
 *    http://www.apache.org/licenses/LICENSE-2.0
            .endObject()
            expectedContent.contentType()
    public void testPrepareTypelessRequest() throws IOException {  
            .startObject("aliases")  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.rest.action.admin.indices;
            .startObject("aliases")
        Map<String, Object> source = RestCreateIndexAction.prepareMappings(contentAsMap);
 */
            .endObject()  
 * this file be licensed under the Apache-2.0 license or a
            .startObject("field1")
/*  
    public void testMalformedMappings() throws IOException {
            .startObject()
            .startObject("field1")  
 * compatible open source license.
            .endObject()  
 *
            .endObject()
            .field("type", "keyword")
            .startObject("properties")
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
            .endObject();
            .endObject()
/*
import org.opensearch.test.OpenSearchTestCase;
/*  
        Map<String, Object> source = RestCreateIndexAction.prepareMappings(contentAsMap);
            .startObject("field2")
        Map<String, Object> expectedContentAsMap = XContentHelper.convertToMap(
        XContentBuilder content = XContentFactory.jsonBuilder()
            .startObject("field2")  
        XContentBuilder content = XContentFactory.jsonBuilder()  
 * Modifications Copyright OpenSearch Contributors. See
            .startObject("mappings")  
            .field("type", "text")
 * under the License.  
}
 * KIND, either express or implied.  See the License for the
            .endObject()
 * the Apache License, Version 2.0 (the "License"); you may
            .startObject("mappings")  
import org.opensearch.core.common.bytes.BytesReference;  
 *
 * SPDX-License-Identifier: Apache-2.0
 *  
            .startObject("read_alias")
            .startObject()
import org.opensearch.common.xcontent.XContentFactory;
            .startObject("_doc")
    }  
 * software distributed under the License is distributed on an
            .field("mappings", "some string")
    }
            .startObject("aliases")  
 * license agreements. See the NOTICE file distributed with
        ).v2();  
import org.opensearch.core.xcontent.XContentBuilder;
            .field("type", "text")  
            .endObject()
import org.opensearch.common.xcontent.XContentHelper;
 */  
            .endObject()
            .startObject("properties")
            BytesReference.bytes(expectedContent),  
import java.util.Map;
            .endObject();
            .endObject()
            .endObject()
            .startObject()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .endObject()  
        XContentBuilder expectedContent = XContentFactory.jsonBuilder()
        assertEquals(contentAsMap, source);  
        assertEquals(expectedContentAsMap, source);
            .field("type", "keyword")  
