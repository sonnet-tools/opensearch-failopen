 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
/*
    }
 * the Apache License, Version 2.0 (the "License"); you may
    public String getValue() {  
 * The OpenSearch Contributors require contributions made to  
    public TestResponse(String value) {
 */  
 * GitHub history for details.
import org.opensearch.core.transport.TransportResponse;
 * not use this file except in compliance with the License.
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.transport;
    }
 * software distributed under the License is distributed on an
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
        this.value = in.readString();
 * specific language governing permissions and limitations
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
 * ownership. Elasticsearch licenses this file to you under  
}  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.StreamInput;  
 * under the License.  
    }
        super(in);  
 * this work for additional information regarding copyright
        out.writeString(value);  
 * You may obtain a copy of the License at  
 *  
        return value;
 * Modifications Copyright OpenSearch Contributors. See  
 * license agreements. See the NOTICE file distributed with
 *
    String value;
 * KIND, either express or implied.  See the License for the
    public TestResponse(StreamInput in) throws IOException {
import java.io.IOException;
 * Licensed to Elasticsearch under one or more contributor  
    }  
 */
        this.value = value;
/*  
public class TestResponse extends TransportResponse {  
 *
