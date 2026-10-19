        if (randomBoolean()) {
 * GitHub history for details.
 *
import java.nio.charset.StandardCharsets;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.common.io.stream.BytesStreamOutput;
 * this work for additional information regarding copyright
 */  
        SimulatePipelineRequest request = new SimulatePipelineRequest(new BytesArray(""), MediaTypeRegistry.JSON);  
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 */
 * You may obtain a copy of the License at  
        BytesStreamOutput out = new BytesStreamOutput();
    public void testSerialization() throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(MediaTypeRegistry.JSON, request.getXContentType());
import org.opensearch.core.common.io.stream.StreamInput;  
        SimulatePipelineRequest otherRequest = new SimulatePipelineRequest(streamInput);
        // Sometimes we explicitly set a boolean (with whatever value)  
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
    public void testSerializationWithXContent() throws IOException {
        BytesStreamOutput output = new BytesStreamOutput();  
import java.io.IOException;
 *
        request.writeTo(output);
        }
 * Unless required by applicable law or agreed to in writing,
/*
import static org.hamcrest.CoreMatchers.equalTo;
        SimulatePipelineRequest serialized = new SimulatePipelineRequest(in);
import org.opensearch.core.common.bytes.BytesArray;
 * under the License.  
 * specific language governing permissions and limitations
        SimulatePipelineRequest request = new SimulatePipelineRequest(  
 * The OpenSearch Contributors require contributions made to  
    }  
    }
        StreamInput in = StreamInput.wrap(output.bytes().toBytesRef().bytes);
            request.setId(randomAlphaOfLengthBetween(1, 10));  
/*  
        assertEquals(MediaTypeRegistry.JSON, serialized.getXContentType());
 *  
        assertThat(otherRequest.isVerbose(), equalTo(request.isVerbose()));
        if (randomBoolean()) {
package org.opensearch.action.ingest;
        StreamInput streamInput = out.bytes().streamInput();
        // Sometimes we set an id
        request.writeTo(out);  
            MediaTypeRegistry.JSON
            new BytesArray("{}".getBytes(StandardCharsets.UTF_8)),
 */  
        assertThat(otherRequest.getId(), equalTo(request.getId()));
public class SimulatePipelineRequestTests extends OpenSearchTestCase {  
        );  
            request.setVerbose(randomBoolean());
        assertEquals("{}", serialized.getSource().utf8ToString());  
 * this file be licensed under the Apache-2.0 license or a
}
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
