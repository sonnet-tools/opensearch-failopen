 */
/*  
 * Modifications Copyright OpenSearch Contributors. See  
 * You may obtain a copy of the License at  
    }
        this.value = value;
 *
import org.opensearch.core.common.io.stream.StreamOutput;
/*
 */
import java.io.IOException;  
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
    public String getValue() {  
        out.writeString(value);  
    }
 * KIND, either express or implied.  See the License for the
        super.writeTo(out);
    }
 * compatible open source license.
 * under the License.  
        return value;
 * SPDX-License-Identifier: Apache-2.0
}  
 * ownership. Elasticsearch licenses this file to you under  
 */  
    }
        this.value = in.readString();  
 * software distributed under the License is distributed on an
import org.opensearch.core.common.io.stream.StreamInput;  
 * this work for additional information regarding copyright
 *
    public void writeTo(StreamOutput out) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
    public TestRequest(String value) {  
package org.opensearch.transport;
 * license agreements. See the NOTICE file distributed with
    @Override  
    String value;
 * not use this file except in compliance with the License.
 *  
public class TestRequest extends TransportRequest {
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
    public TestRequest(StreamInput in) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
        super(in);
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
