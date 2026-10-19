 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 */  
    @Override
    public boolean markSupported() {
 * Modifications Copyright OpenSearch Contributors. See
    protected final StreamInput delegate;
    public void readBytes(byte[] b, int offset, int len) throws IOException {
/*  
import org.opensearch.Version;
 * @opensearch.internal  
    @Override
        return delegate.readLong();
    public int readInt() throws IOException {
    public int available() throws IOException {
        return delegate.available();
import java.io.IOException;
/**  
    @Override
 *  
        return delegate.readInt();  
 */  
import java.io.EOFException;  
public abstract class FilterStreamInput extends StreamInput {
        return delegate.readByte();  
    @Override  
    public NamedWriteableRegistry namedWriteableRegistry() {  
/*  
        delegate.mark(readlimit);  
    public void setVersion(Version version) {
 * Wraps a {@link StreamInput} and delegates to it. To be used to add functionality to an existing stream by subclassing.
 *
 * The OpenSearch Contributors require contributions made to  
    }
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
    public void reset() throws IOException {  
        return delegate.readShort();
package org.opensearch.core.common.io.stream;
    }  
    }
 * compatible open source license.
        delegate.close();  
        return delegate.markSupported();
        delegate.ensureCanReadBytes(length);
 * specific language governing permissions and limitations
    public void mark(int readlimit) {
    public short readShort() throws IOException {  
    protected void ensureCanReadBytes(int length) throws EOFException {
 *
    public byte readByte() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
    @Override  
    @Override
        delegate.readBytes(b, offset, len);
    @Override  
    }
    }
    protected FilterStreamInput(StreamInput delegate) {  
        return delegate.getVersion();
 * under the License.  
 *
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public long readLong() throws IOException {
}  
 * this file be licensed under the Apache-2.0 license or a
        delegate.reset();
        this.delegate = delegate;
    @Override  
        return delegate.read();
 */
 * KIND, either express or implied.  See the License for the
    public int read() throws IOException {  
    public void close() throws IOException {
    }
    @Override  
    }
        return delegate.namedWriteableRegistry();
    public Version getVersion() {  
    @Override
 * Unless required by applicable law or agreed to in writing,
    }  
    }  
    }
    @Override
    }
    }  
 */
    @Override
    @Override
/*
    }
    }
 * ownership. Elasticsearch licenses this file to you under  
    }  
    @Override
 * GitHub history for details.
 *     http://www.apache.org/licenses/LICENSE-2.0
        delegate.setVersion(version);  
    }
    @Override
