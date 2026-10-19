    public void write(byte[] b, int off, int len) throws IOException {  
/**  
 * specific language governing permissions and limitations
 * under the License.  
 * this work for additional information regarding copyright
/*  
    @Override  
import java.io.OutputStream;
 *  
 * software distributed under the License is distributed on an
 *
 */
 * KIND, either express or implied.  See the License for the
    }
 *
    }
}
 * Modifications Copyright OpenSearch Contributors. See
 */  
        out.close();  
 *
    @Override
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
import org.apache.lucene.store.IndexOutput;
    }  
 * ownership. Elasticsearch licenses this file to you under  
        out.writeBytes(b, off, len);
 * this file be licensed under the Apache-2.0 license or a
    private final IndexOutput out;
 *     http://www.apache.org/licenses/LICENSE-2.0
        this.out = out;
 * GitHub history for details.
public class IndexOutputOutputStream extends OutputStream {
    }
        out.writeByte((byte) b);  
 * @opensearch.internal  
    @Override
package org.opensearch.common.lucene.store;
 * the Apache License, Version 2.0 (the "License"); you may
    public IndexOutputOutputStream(IndexOutput out) {  
 */  
 * {@link OutputStream} that writes into underlying IndexOutput
 */
    }
 * license agreements. See the NOTICE file distributed with
    public void close() throws IOException {
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        out.writeBytes(b, b.length);
    public void write(byte[] b) throws IOException {
/*  
    @Override
 * You may obtain a copy of the License at  
import java.io.IOException;  
 * Unless required by applicable law or agreed to in writing,
    public void write(int b) throws IOException {
/*
