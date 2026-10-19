                assertThat(PercentilesMethod.readFromStream(in), equalTo(PercentilesMethod.HDR));
 *
            PercentilesMethod.HDR.writeTo(out);
            }
import org.opensearch.test.OpenSearchTestCase;  
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.io.stream.BytesStreamOutput;
                assertThat(PercentilesMethod.readFromStream(in), equalTo(PercentilesMethod.TDIGEST));
 * ownership. Elasticsearch licenses this file to you under  
    }
                PercentilesMethod.readFromStream(in);
        }  
                assertThat(in.readVInt(), equalTo(0));  
        assertThat(PercentilesMethod.HDR.ordinal(), equalTo(1));
 */
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
 * You may obtain a copy of the License at  
            try (StreamInput in = out.bytes().streamInput()) {  
 * compatible open source license.
            try (StreamInput in = out.bytes().streamInput()) {  
        }  
import java.io.IOException;
 * this work for additional information regarding copyright
    public void testInvalidReadFrom() throws Exception {  
        }  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            try (StreamInput in = out.bytes().streamInput()) {
            }
/*
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
            } catch (IOException e) {  
import org.opensearch.core.common.io.stream.StreamInput;
            try (StreamInput in = out.bytes().streamInput()) {  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    public void testwriteTo() throws Exception {
            }
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 * GitHub history for details.
 *
            out.writeVInt(randomIntBetween(2, Integer.MAX_VALUE));
 * Unless required by applicable law or agreed to in writing,
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            PercentilesMethod.TDIGEST.writeTo(out);
                fail("Expected IOException");
            out.writeVInt(0);
package org.opensearch.search.aggregations.metrics;
        }
            out.writeVInt(1);
                assertThat(e.getMessage(), containsString("Unknown PercentilesMethod ordinal ["));
 */  
        }
        assertThat(PercentilesMethod.TDIGEST.ordinal(), equalTo(0));
    public void testReadFrom() throws Exception {  
public class PercentilesMethodTests extends OpenSearchTestCase {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            }
    }
 * software distributed under the License is distributed on an
}  
    }
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            }
 * KIND, either express or implied.  See the License for the
    }  
import static org.hamcrest.Matchers.containsString;
 * The OpenSearch Contributors require contributions made to  
    public void testValidOrdinals() {  
                assertThat(in.readVInt(), equalTo(1));
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
            try (StreamInput in = out.bytes().streamInput()) {  
/*  
 *  
import static org.hamcrest.Matchers.equalTo;
