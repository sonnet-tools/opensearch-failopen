 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**  
                token = in.nextToken();
                assertNull(token);
            // Construct with one missing bound  
                throw new Exception("Error parsing [" + BytesReference.bytes(out).utf8ToString() + "]", e);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.ToXContent;
/*  
                assertThat(token, equalTo(XContentParser.Token.START_OBJECT));
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
import org.opensearch.common.io.stream.BytesStreamOutput;
 */
        }
        DoubleBounds read;  
public class DoubleBoundsTests extends OpenSearchTestCase {
            read = new DoubleBounds(in);
 * compatible open source license.
        }  
     * Construct a random {@link DoubleBounds}
        Double max = randomValueOtherThan(min, OpenSearchTestCase::randomDouble);
        }
 *  
            orig.toXContent(out, ToXContent.EMPTY_PARAMS);  
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.equalTo;  
        try (StreamInput in = origBytes.streamInput()) {
        if (randomBoolean()) {
                DoubleBounds read = DoubleBounds.PARSER.apply(in, null);
            try (XContentParser in = createParser(JsonXContent.jsonXContent, BytesReference.bytes(out))) {  
 * this work for additional information regarding copyright
            assertEquals("read fully", 0, in.available());  
        DoubleBounds orig = randomBounds();
 *
 * You may obtain a copy of the License at  
import org.opensearch.core.xcontent.XContentParser;
    public static DoubleBounds randomBounds() {  
            return new DoubleBounds(min, null);
        DoubleBounds orig = randomBounds();
 * ownership. Elasticsearch licenses this file to you under  
        BytesReference readBytes;
        assertEquals(origBytes, readBytes);
            }  
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(orig, read);
 */  
        BytesReference origBytes;  
}
        try (XContentBuilder out = JsonXContent.contentBuilder()) {
 * the Apache License, Version 2.0 (the "License"); you may
 *
    }
                XContentParser.Token token = in.currentToken();
        }
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
    public void testXContentRoundTrip() throws Exception {
        }
            } catch (Exception e) {  
                return new DoubleBounds(null, max);
            origBytes = out.bytes();  
            if (randomBoolean()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
            out.endObject();
            }
 * specific language governing permissions and limitations
 * GitHub history for details.
            out.startObject();
    }
            max = temp;  
import org.opensearch.core.common.io.stream.StreamInput;
    }
 * Unless required by applicable law or agreed to in writing,
            double temp = min;
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.XContentBuilder;  
        return new DoubleBounds(min, max);  
/*
        Double min = randomDouble();
        if (min > max) {  
/*  
    public void testTransportRoundTrip() throws IOException {  
package org.opensearch.search.aggregations.bucket.histogram;
            min = max;
 * SPDX-License-Identifier: Apache-2.0
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            orig.writeTo(out);
                assertEquals(orig, read);
        try (BytesStreamOutput out = new BytesStreamOutput()) {
import org.opensearch.common.xcontent.json.JsonXContent;
import java.io.IOException;
 * license agreements. See the NOTICE file distributed with
 */  
        }
            readBytes = out.bytes();
            read.writeTo(out);  
import org.opensearch.core.common.bytes.BytesReference;  
