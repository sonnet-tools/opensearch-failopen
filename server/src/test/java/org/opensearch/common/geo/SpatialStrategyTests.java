 * compatible open source license.
import org.opensearch.common.io.stream.BytesStreamOutput;
 * Licensed to Elasticsearch under one or more contributor  
            try (StreamInput in = out.bytes().streamInput()) {
            }
 * You may obtain a copy of the License at  
            try (StreamInput in = out.bytes().streamInput()) {  
            }
    }  
            SpatialStrategy.TERM.writeTo(out);
public class SpatialStrategyTests extends OpenSearchTestCase {
        }  
 * SPDX-License-Identifier: Apache-2.0
            }
 *
 */  
            try (StreamInput in = out.bytes().streamInput()) {  
                SpatialStrategy.readFromStream(in);
 * under the License.  
                assertThat(e.getMessage(), containsString("Unknown SpatialStrategy ordinal ["));
            try (StreamInput in = out.bytes().streamInput()) {  
 * ownership. Elasticsearch licenses this file to you under  
 *  
    public void testInvalidReadFrom() throws Exception {  
            try (StreamInput in = out.bytes().streamInput()) {  
                fail("Expected IOException");
            }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            SpatialStrategy.RECURSIVE.writeTo(out);
/*
            out.writeVInt(1);
                assertThat(in.readVInt(), equalTo(0));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
 * this work for additional information regarding copyright
 * GitHub history for details.
    public void testwriteTo() throws Exception {
        assertThat(SpatialStrategy.TERM.ordinal(), equalTo(0));
 */  
 * not use this file except in compliance with the License.
                assertThat(in.readVInt(), equalTo(1));
            } catch (IOException e) {  
        }  
import static org.hamcrest.Matchers.containsString;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.test.OpenSearchTestCase;  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 */
    public void testReadFrom() throws Exception {  
 * The OpenSearch Contributors require contributions made to  
            }
        assertThat(SpatialStrategy.RECURSIVE.ordinal(), equalTo(1));
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
        }  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 * license agreements. See the NOTICE file distributed with
    }
}
package org.opensearch.common.geo;
                assertThat(SpatialStrategy.readFromStream(in), equalTo(SpatialStrategy.TERM));
/*  
 * KIND, either express or implied.  See the License for the
            out.writeVInt(0);
    }
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
/*  
        }
import static org.hamcrest.Matchers.equalTo;
 *
import java.io.IOException;
            out.writeVInt(randomIntBetween(2, Integer.MAX_VALUE));
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
    }
                assertThat(SpatialStrategy.readFromStream(in), equalTo(SpatialStrategy.RECURSIVE));
import org.opensearch.core.common.io.stream.StreamInput;
    public void testValidOrdinals() {  
