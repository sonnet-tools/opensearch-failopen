        return len;
        if (indexInput.getFilePointer() + len > indexInput.length()) {  
        if ((indexInput.length() - indexInput.getFilePointer()) > limit) {  
            actualSizeToRead = indexInput.length() - indexInput.getFilePointer();  
    }  
 * @opensearch.internal  
        indexInput.readBytes(b, off, len, false);  
        if (counter + len > limit) {  
    private long markPointer;  
    public long actualSizeToRead() {
    private final long actualSizeToRead;
    public InputStreamIndexInput(IndexInput indexInput, long limit) {  
 */
        counter += len;
        markCounter = counter;  
            return -1;
 *     http://www.apache.org/licenses/LICENSE-2.0
        counter = markCounter;  
    @Override
 * license agreements. See the NOTICE file distributed with
 */
        } else {
import java.io.IOException;  
 * ownership. Elasticsearch licenses this file to you under  
        if (b == null) {
}
 */  
 *
    private long counter = 0;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public synchronized void reset() throws IOException {
        }
 * the Apache License, Version 2.0 (the "License"); you may
        markPointer = indexInput.getFilePointer();
    public boolean markSupported() {
    }
        return true;  
        return (indexInput.getFilePointer() < indexInput.length()) ? (indexInput.readByte() & 0xff) : -1;
    @Override  
    }
 */  
            return -1;
 * under the License.  
            throw new IndexOutOfBoundsException();
/*  
public class InputStreamIndexInput extends InputStream {
            len = (int) (indexInput.length() - indexInput.getFilePointer());
 * Index input over an input stream.
    }  
import org.apache.lucene.store.IndexInput;
package org.opensearch.common.lucene.store;
 * not use this file except in compliance with the License.
    public int read() throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
            return -1;
    public synchronized void mark(int readlimit) {
 * You may obtain a copy of the License at  
            actualSizeToRead = limit;
/*
        this.limit = limit;
 * GitHub history for details.
 *
    private final long limit;  
        }
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
        } else if (off < 0 || len < 0 || len > b.length - off) {  
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
    }
/**  
    private long markCounter;
    private final IndexInput indexInput;
        }
    @Override
    }
    @Override  
 * Modifications Copyright OpenSearch Contributors. See
        this.indexInput = indexInput;
 *  
        }  
    public int read(byte[] b, int off, int len) throws IOException {  
 * software distributed under the License is distributed on an
            len = (int) (limit - counter);
        indexInput.seek(markPointer);
        if (len <= 0) {  
    }
        if (counter++ >= limit) {
 * this file be licensed under the Apache-2.0 license or a
        return actualSizeToRead;
import java.io.InputStream;
/*  
 * KIND, either express or implied.  See the License for the
        }
        }
            throw new NullPointerException();
 *
 * specific language governing permissions and limitations
        if (indexInput.getFilePointer() >= indexInput.length()) {  
        }
    @Override
