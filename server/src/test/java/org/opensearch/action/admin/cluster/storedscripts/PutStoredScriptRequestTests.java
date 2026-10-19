        builder.startObject();  
 * SPDX-License-Identifier: Apache-2.0
            "bar",
 *
 * specific language governing permissions and limitations
 */  
            }
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.test.OpenSearchTestCase;
    }
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
        BytesReference actualRequestBody = BytesReference.bytes(requestBuilder);  
            new BytesArray("{}"),  
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
import org.opensearch.core.common.bytes.BytesArray;  
 * this file be licensed under the Apache-2.0 license or a
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testSerialization() throws IOException {
        PutStoredScriptRequest storedScriptRequest = new PutStoredScriptRequest(  
        requestBuilder.startObject();
 */
import org.opensearch.core.common.io.stream.StreamInput;
        XContentType xContentType = randomFrom(XContentType.values());
 * compatible open source license.
import org.opensearch.common.io.stream.BytesStreamOutput;
 * under the License.  
    public void testToXContent() throws IOException {  
        BytesReference expectedRequestBody = BytesReference.bytes(builder);
            new StoredScriptSource("foo", "bar", Collections.emptyMap())
        request.toXContent(requestBuilder, ToXContent.EMPTY_PARAMS);  
/*  
        requestBuilder.endObject();
            try (StreamInput in = output.bytes().streamInput()) {  
 * GitHub history for details.
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.xcontent.ToXContent;
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.MediaTypeRegistry;  
    }  
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
public class PutStoredScriptRequestTests extends OpenSearchTestCase {  
import java.io.IOException;  
/*  
import org.opensearch.common.xcontent.XContentType;
        );  
        PutStoredScriptRequest request = new PutStoredScriptRequest();  
                PutStoredScriptRequest serialized = new PutStoredScriptRequest(in);
        builder.endObject();
            "context",
        request.content(expectedRequestBody, xContentType);
/*
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
        try (BytesStreamOutput output = new BytesStreamOutput()) {  
                assertEquals(MediaTypeRegistry.JSON, serialized.mediaType());
        builder.startObject("script").field("lang", "painless").field("source", "Math.log(_score * 2) + params.multiplier").endObject();
 * license agreements. See the NOTICE file distributed with
 */  
        assertEquals(MediaTypeRegistry.JSON, storedScriptRequest.mediaType());
        }  
import org.opensearch.script.StoredScriptSource;  
        assertEquals(expectedRequestBody, actualRequestBody);
            MediaTypeRegistry.JSON,
        request.id("test1");
                assertEquals(storedScriptRequest.context(), serialized.context());
        XContentBuilder requestBuilder = XContentBuilder.builder(xContentType.xContent());
            storedScriptRequest.writeTo(output);
                assertEquals(storedScriptRequest.id(), serialized.id());  
        XContentBuilder builder = XContentBuilder.builder(xContentType.xContent());
import org.opensearch.core.common.bytes.BytesReference;
package org.opensearch.action.admin.cluster.storedscripts;
import java.util.Collections;
