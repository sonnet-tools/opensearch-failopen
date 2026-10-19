import java.io.IOException;
 * You may obtain a copy of the License at  
 *  
    public void reset() throws IOException {
 *  
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal
/*  
 * this work for additional information regarding copyright
    }  
        out.flush();
    }
        out.write(b, offset, length);  
    @Override
    }
/*  
import java.io.OutputStream;
 *
package org.opensearch.core.common.io.stream;
 * Streaming output data
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
        this.out = out;
 * ownership. Elasticsearch licenses this file to you under  
    @Override
        out.write(b);
 * KIND, either express or implied.  See the License for the
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * under the License.  
public class OutputStreamStreamOutput extends StreamOutput {  
 * The OpenSearch Contributors require contributions made to  
    }  
/**
    public void flush() throws IOException {
 */  
 * Unless required by applicable law or agreed to in writing,
 *
    public OutputStreamStreamOutput(OutputStream out) {
    @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
    public void close() throws IOException {  
    }
 * Licensed to Elasticsearch under one or more contributor  
    }
}
    @Override
    private final OutputStream out;
        throw new UnsupportedOperationException();  
 */
    @Override  
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
    public void writeBytes(byte[] b, int offset, int length) throws IOException {
    public void writeByte(byte b) throws IOException {  
 * not use this file except in compliance with the License.
        out.close();
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
/*
