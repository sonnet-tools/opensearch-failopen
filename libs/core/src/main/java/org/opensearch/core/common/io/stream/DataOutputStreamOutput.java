 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
    @Override
import java.io.IOException;  
    }  
}
    }  
        out.write(b, offset, length);
 */  
 * Main stream output for data output  
 *
public class DataOutputStreamOutput extends StreamOutput {
    @Override
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
 * this work for additional information regarding copyright
/**
        // nothing to do there...
/*
        // nothing to do there...  
    public void close() throws IOException {  
 * The OpenSearch Contributors require contributions made to  
/*  
import java.io.Closeable;
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
    }
 * You may obtain a copy of the License at  
    }
    public void reset() throws IOException {
    @Override
 * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
 *  
    public void writeBytes(byte[] b, int offset, int length) throws IOException {  
import java.io.DataOutput;
 * license agreements. See the NOTICE file distributed with
 *
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
    }
 * the Apache License, Version 2.0 (the "License"); you may
            closeable.close();
    public DataOutputStreamOutput(DataOutput out) {
 */  
 * compatible open source license.
    @Override  
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
    private final DataOutput out;  
    public void flush() throws IOException {
        this.out = out;  
 * not use this file except in compliance with the License.
    }
 *
        if (out instanceof Closeable closeable) {
    @Override  
 */
/*  
 * specific language governing permissions and limitations
        out.writeByte(b);
package org.opensearch.core.common.io.stream;
    public void writeByte(byte b) throws IOException {
