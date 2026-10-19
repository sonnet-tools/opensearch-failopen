    public void close() throws IOException {
        out.writeBytes(b, offset, length);
 * SPDX-License-Identifier: Apache-2.0
 */  
    public long getChecksum() throws IOException {
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.common.lucene.store;
    @Override
 * not use this file except in compliance with the License.
    @Override  
/**
    }
 * @opensearch.internal
/*
}  
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * IndexOutput that delegates all calls to another IndexOutput
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        super(resourceDescription, out.getName());
/*
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
    @Override  
 * software distributed under the License is distributed on an
        return out.getChecksum();  
 * GitHub history for details.
 *
public class FilterIndexOutput extends IndexOutput {  
    @Override
import java.io.IOException;
 * Unless required by applicable law or agreed to in writing,
    public FilterIndexOutput(String resourceDescription, IndexOutput out) {
    public long getFilePointer() {  
 * ownership. Elasticsearch licenses this file to you under  
    public void writeBytes(byte[] b, int offset, int length) throws IOException {  
import org.apache.lucene.store.IndexOutput;  
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See  
    }  
 *  
/*  
    }  
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
        return out.getFilePointer();
        this.out = out;  
 */
    protected final IndexOutput out;
    }
        out.close();
        out.writeByte(b);
 *
 */
 * compatible open source license.
    @Override
 *  
 * The OpenSearch Contributors require contributions made to  
    public void writeByte(byte b) throws IOException {
