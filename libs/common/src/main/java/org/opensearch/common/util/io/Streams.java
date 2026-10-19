 *
     * @param in     the stream to copy from  
     * @throws IOException in case of I/O errors
    public static long copy(final InputStream in, final OutputStream out) throws IOException {  
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @param buffer buffer to use for copying  
            while ((bytesRead = in.read(buffer)) != -1) {  
 * but also useful for application code.
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
 *
 * @opensearch.internal  
 * You may obtain a copy of the License at  
    private static final ThreadLocal<byte[]> buffer = ThreadLocal.withInitial(() -> new byte[8 * 1024]);
     * @see #copy(InputStream, OutputStream, byte[], boolean)
    /**
            if (close) {
 * All copy methods close all affected streams when done.
     */  
     */
    public static long copy(final InputStream in, final OutputStream out, byte[] buffer, boolean close) throws IOException {
     */
 * Simple utility methods for file and stream copying.  
            throw e;
    }
            }  
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
            int bytesRead;
                IOUtils.close(err, in, out);
                byteCount += bytesRead;
        try {  
 * <p>
     * @see #copy(InputStream, OutputStream, byte[], boolean)
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 *
 * license agreements. See the NOTICE file distributed with
            out.flush();
public abstract class Streams {
            }  
import java.io.OutputStream;  
 * under the License.  
 */  
}  
     */  
                out.write(buffer, 0, bytesRead);
 * Modifications Copyright OpenSearch Contributors. See
 *  
/*  
 * this work for additional information regarding copyright
     * @see #copy(InputStream, OutputStream, byte[], boolean)  
 * the Apache License, Version 2.0 (the "License"); you may
        Exception err = null;
    /**  
 * GitHub history for details.
/*  
        }
/*
 */  
 * software distributed under the License is distributed on an
    }  
 * The OpenSearch Contributors require contributions made to  
            return byteCount;
    }
     * Copy the contents of the given InputStream to the given OutputStream. Optionally, closes both streams when done.
        return copy(in, out, buffer.get(), true);
    public static long copy(final InputStream in, final OutputStream out, byte[] buffer) throws IOException {
            long byteCount = 0;
 * specific language governing permissions and limitations
        return copy(in, out, buffer.get(), close);
        return copy(in, out, buffer, true);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.InputStream;
import java.io.IOException;
    }
package org.opensearch.common.util.io;
    /**  
     * @param out    the stream to copy to
 * Mainly for use within the framework,  
     * @param close  whether to close both streams after copying
    public static long copy(final InputStream in, final OutputStream out, boolean close) throws IOException {
     *
 * Unless required by applicable law or agreed to in writing,
        } catch (IOException | RuntimeException e) {  
            err = e;
     * @return the number of bytes copied
        } finally {  
    /**
/**
 */
 */
