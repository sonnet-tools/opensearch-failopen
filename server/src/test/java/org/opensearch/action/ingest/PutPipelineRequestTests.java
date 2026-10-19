 * GitHub history for details.
        XContentType xContentType = randomFrom(XContentType.values());
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
        pipelineBuilder.startArray(Pipeline.PROCESSORS_KEY);
 *  
        // Start first processor  
 * the Apache License, Version 2.0 (the "License"); you may
    }
        PutPipelineRequest request = new PutPipelineRequest(  
import org.opensearch.common.xcontent.XContentType;
 */  
        PutPipelineRequest request = new PutPipelineRequest("1", BytesReference.bytes(pipelineBuilder), xContentType);
 */  
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
        // End first processor
import org.opensearch.core.common.bytes.BytesArray;  
 * The OpenSearch Contributors require contributions made to  
        pipelineBuilder.endObject();  
        assertEquals(MediaTypeRegistry.JSON, request.getMediaType());
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
        pipelineBuilder.startObject().field(Pipeline.DESCRIPTION_KEY, "some random set of processors");
    public void testSerializationWithXContent() throws IOException {
/*  
import org.opensearch.core.xcontent.ToXContent;
        pipelineBuilder.startObject();
    }
import org.opensearch.core.common.io.stream.StreamInput;
        pipelineBuilder.field("field", "foo");  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
import java.nio.charset.StandardCharsets;
        pipelineBuilder.endObject();
        pipelineBuilder.endObject();  
}  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
 *
        XContentBuilder pipelineBuilder = XContentBuilder.builder(xContentType.xContent());  
        XContentBuilder requestBuilder = XContentBuilder.builder(xContentType.xContent());
 * Licensed to Elasticsearch under one or more contributor  
/*
 * under the License.  
import java.io.IOException;  
import org.opensearch.core.xcontent.XContentBuilder;
        request.writeTo(output);
        StreamInput in = StreamInput.wrap(output.bytes().toBytesRef().bytes);  
 */
import org.opensearch.core.common.bytes.BytesReference;
    public void testToXContent() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
            new BytesArray("{}".getBytes(StandardCharsets.UTF_8)),
        pipelineBuilder.endArray();
            MediaTypeRegistry.JSON  
        BytesReference actualRequestBody = BytesReference.bytes(request.toXContent(requestBuilder, ToXContent.EMPTY_PARAMS));  
        pipelineBuilder.field("value", "bar");
        BytesStreamOutput output = new BytesStreamOutput();
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.action.ingest;
        assertEquals(BytesReference.bytes(pipelineBuilder), actualRequestBody);
import org.opensearch.common.io.stream.BytesStreamOutput;
public class PutPipelineRequestTests extends OpenSearchTestCase {  
 *
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
/*  
            "1",
import org.opensearch.test.OpenSearchTestCase;
        pipelineBuilder.startObject("set");
import org.opensearch.ingest.Pipeline;  
        assertEquals(MediaTypeRegistry.JSON, serialized.getMediaType());  
        PutPipelineRequest serialized = new PutPipelineRequest(in);
        assertEquals("{}", serialized.getSource().utf8ToString());
