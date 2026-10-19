 */
package org.opensearch.gradle;
            }  
        delegate.write(b, off, len);
 *
class LazyFileOutputStream extends OutputStream {  
/*  
                delegate.write(b, off, len);
    }
    public void write(byte b[], int off, int len) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
    private OutputStream delegate;
    LazyFileOutputStream(File file) {  
 */
 */  
                delegate.write(b);
                file.getParentFile().mkdirs();
 *  
    public void write(int b) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
/**  
                delegate = new FileOutputStream(file);
    @Override
 * You may obtain a copy of the License at  
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
        this.delegate = new OutputStream() {
 * Unless required by applicable law or agreed to in writing,
    }
            @Override
 *
            @Override
 * Modifications Copyright OpenSearch Contributors. See
import java.io.File;
import java.io.IOException;  
/*  
    }  
            public void write(byte b[], int off, int len) throws IOException {  
            }  
 * license agreements. See the NOTICE file distributed with
    public void close() throws IOException {  
    }
                bootstrap();
 * the Apache License, Version 2.0 (the "License"); you may
/*
            public void write(int b) throws IOException {  
        // use an initial dummy delegate to avoid doing a conditional on every write
    @Override
 */  
 * not use this file except in compliance with the License.
            private void bootstrap() throws IOException {  
import java.io.FileOutputStream;
        };
 * GitHub history for details.
import java.io.OutputStream;
                bootstrap();
 * software distributed under the License is distributed on an
            }  
 * this work for additional information regarding copyright
 * An outputstream to a File that is lazily opened on the first write.
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        delegate.close();
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
        delegate.write(b);  
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
}  
