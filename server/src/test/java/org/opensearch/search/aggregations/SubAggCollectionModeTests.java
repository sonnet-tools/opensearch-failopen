            try (StreamInput in = out.bytes().streamInput()) {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 * Unless required by applicable law or agreed to in writing,
                SubAggCollectionMode.readFromStream(in);
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
package org.opensearch.search.aggregations;
            try (StreamInput in = out.bytes().streamInput()) {
 * software distributed under the License is distributed on an
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;  
import org.opensearch.test.OpenSearchTestCase;
            SubAggCollectionMode.DEPTH_FIRST.writeTo(out);
                assertThat(in.readVInt(), equalTo(1));
            out.writeVInt(randomIntBetween(2, Integer.MAX_VALUE));  
        }
                fail("Expected IOException");  
 *
            out.writeVInt(1);  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
 */
            }  
    public void testValidOrdinals() {
        }
            }  
                assertThat(e.getMessage(), containsString("Unknown SubAggCollectionMode ordinal ["));
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            }  
 * SPDX-License-Identifier: Apache-2.0
}
    public void testInvalidReadFrom() throws Exception {
public class SubAggCollectionModeTests extends OpenSearchTestCase {
            SubAggCollectionMode.BREADTH_FIRST.writeTo(out);  
            }  
                assertThat(SubAggCollectionMode.readFromStream(in), equalTo(SubAggCollectionMode.DEPTH_FIRST));
 * Modifications Copyright OpenSearch Contributors. See
            } catch (IOException e) {
/*
        }
            try (StreamInput in = out.bytes().streamInput()) {
    }
    }
            }
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
        }
            try (StreamInput in = out.bytes().streamInput()) {
 */  
    public void testwriteTo() throws Exception {  
        assertThat(SubAggCollectionMode.BREADTH_FIRST.ordinal(), equalTo(1));  
import org.opensearch.core.common.io.stream.StreamInput;
            out.writeVInt(0);  
        assertThat(SubAggCollectionMode.DEPTH_FIRST.ordinal(), equalTo(0));
 * compatible open source license.
 *
import java.io.IOException;  
 *  
/*  
import org.opensearch.common.io.stream.BytesStreamOutput;
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 * KIND, either express or implied.  See the License for the
                assertThat(SubAggCollectionMode.readFromStream(in), equalTo(SubAggCollectionMode.BREADTH_FIRST));
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
    public void testReadFrom() throws Exception {
        }  
            try (StreamInput in = out.bytes().streamInput()) {  
 * GitHub history for details.
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 * ownership. Elasticsearch licenses this file to you under  
import static org.hamcrest.Matchers.containsString;
 */  
                assertThat(in.readVInt(), equalTo(0));
import static org.hamcrest.Matchers.equalTo;  
/*  
    }  
