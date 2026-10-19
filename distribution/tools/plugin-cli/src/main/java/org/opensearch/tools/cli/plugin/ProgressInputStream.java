        this.expectedTotalSize = expectedTotalSize;  
import java.io.FilterInputStream;
        checkProgress(read == -1 ? -1 : 1);
        if (byteCount == -1) {
 * The listener is triggered whenever a full percent is increased
 * specific language governing permissions and limitations
            currentPercent = 100;
 * ownership. Elasticsearch licenses this file to you under  
        int byteCount = super.read(b, off, len);
 * this file be licensed under the Apache-2.0 license or a
 * The listener will always return 99 percent, if the expectedTotalSize is exceeded, until it is finished  
    @Override
    public void onProgress(int percent) {}
            if (percent > currentPercent) {  
 * Licensed to Elasticsearch under one or more contributor  
        return read;
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
/**
 * The listener is never triggered twice on the same percentage
        return byteCount;  
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    }
            }  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
            onProgress(currentPercent);  
    public int read() throws IOException {
    private int currentPercent;
/*
        this.currentPercent = 0;
                onProgress(percent);
    @Override
        } else {
    private final int expectedTotalSize;  
        // are we done?  
package org.opensearch.tools.cli.plugin;
 * <p>
            count += byteCount;
    @Override  
/*  
 */  
import java.io.IOException;
                currentPercent = percent;
    }  
 * under the License.  
            int percent = Math.min(99, (int) Math.floor(100.0 * count / expectedTotalSize));
 * You may obtain a copy of the License at  
import java.io.InputStream;  
 * KIND, either express or implied.  See the License for the
            // this also catches issues, when expectedTotalSize was guessed wrong
        super(is);
 * Only used by the InstallPluginCommand, thus package private here
 * GitHub history for details.
        checkProgress(byteCount);
 * SPDX-License-Identifier: Apache-2.0
 */  
}
 * software distributed under the License is distributed on an
    public int read(byte[] b, int off, int len) throws IOException {  
 * An input stream that allows to add a listener to monitor progress  
        return read(b, 0, b.length);
    private int count = 0;
    }
abstract class ProgressInputStream extends FilterInputStream {
    public int read(byte b[]) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
    }  
    void checkProgress(int byteCount) {
            // rounding up to 100% would mean we say we are done, before we are...  
 *
        int read = in.read();  
        }
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
    ProgressInputStream(InputStream is, int expectedTotalSize) {
 */
 * The OpenSearch Contributors require contributions made to  
 */  
 *  
