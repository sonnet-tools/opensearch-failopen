            refreshPolicy.writeTo(out);  
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
        final String refreshPolicyValue = randomFrom(WriteRequest.RefreshPolicy.values()).getValue();  
/*  
public class RefreshPolicyTests extends OpenSearchTestCase {
 * license agreements. See the NOTICE file distributed with
        assertEquals(refreshPolicyValue, WriteRequest.RefreshPolicy.parse(refreshPolicyValue).getValue());
import org.opensearch.core.common.io.stream.StreamInput;
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
 *
        }
    }  
    public void testParse() throws IOException {
/*  
 * The OpenSearch Contributors require contributions made to  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> WriteRequest.RefreshPolicy.parse("unknown"));  
package org.opensearch.action.support;
                WriteRequest.RefreshPolicy deserializedRefreshPolicy = WriteRequest.RefreshPolicy.readFrom(in);
                assertEquals(refreshPolicy, deserializedRefreshPolicy);  
 * You may obtain a copy of the License at  
 *
        final WriteRequest.RefreshPolicy refreshPolicy = randomFrom(WriteRequest.RefreshPolicy.values());
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
import java.io.IOException;
    public void testParseUnknown() throws IOException {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
import org.opensearch.test.OpenSearchTestCase;  
 *  
    public void testParseEmpty() throws IOException {
 */  
import org.opensearch.common.io.stream.BytesStreamOutput;
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
            }
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
        assertEquals("Unknown value for refresh: [unknown].", e.getMessage());
        assertEquals(WriteRequest.RefreshPolicy.IMMEDIATE, WriteRequest.RefreshPolicy.parse(""));
 * this file be licensed under the Apache-2.0 license or a
    }
    public void testSerialization() throws IOException {  
            try (StreamInput in = out.bytes().streamInput()) {
}  
 */  
 */
    }  
