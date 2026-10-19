 * Unless required by applicable law or agreed to in writing,
import org.opensearch.test.OpenSearchTestCase;
            ignored.read();
    @Before  
        String incorrectBlobName = "incorrect_" + blobName;
import java.net.InetAddress;  
        httpServer.stop(0);
 *
@SuppressForbidden(reason = "use http server")  
        try (InputStream ignored = container.readBlob(incorrectBlobName)) {
            assertEquals(message.length, read);  
    }  
            byte[] bytes = new byte[message.length];
        for (int i = 0; i < message.length; ++i) {
        httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress().getHostAddress(), 6001), 0);  
    private static HttpServer httpServer;  
            assertEquals(String.format("[%s] blob not found", incorrectBlobName), e.getMessage());  
}  
    public void testNoBlobFound() throws IOException {
 * license agreements. See the NOTICE file distributed with
    public static void startHttp() throws Exception {  
 * this work for additional information regarding copyright
    }
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.common.blobstore.url;
 * the Apache License, Version 2.0 (the "License"); you may
        BlobContainer container = urlBlobStore.blobContainer(BlobPath.cleanPath().add("indices"));  
 * You may obtain a copy of the License at  
        } catch (NoSuchFileException e) {
 * software distributed under the License is distributed on an
public class URLBlobStoreTests extends OpenSearchTestCase {
/*  
        });
        }
import org.junit.BeforeClass;
/*
 * The OpenSearch Contributors require contributions made to  
        urlBlobStore = new URLBlobStore(settings, new URL(spec));
        blobName = randomAlphaOfLength(8);
 * Licensed to Elasticsearch under one or more contributor  
        String spec = "http://localhost:6001/";  
 *  
/*  
import java.nio.file.NoSuchFileException;
import org.junit.Before;  
import java.io.InputStream;
            s.sendResponseHeaders(200, message.length);  
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.OutputStream;
    private URLBlobStore urlBlobStore;  
 *    http://www.apache.org/licenses/LICENSE-2.0
    private static byte[] message = new byte[512];
    }
            message[i] = randomByte();
 *
import java.net.InetSocketAddress;
        httpServer.createContext("/indices/" + blobName, (s) -> {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.blobstore.BlobContainer;
 */
import org.opensearch.common.settings.Settings;  
import com.sun.net.httpserver.HttpServer;
            int read = stream.read(bytes);
    @BeforeClass
            OutputStream responseBody = s.getResponseBody();
    private static String blobName;
 * compatible open source license.
            responseBody.write(message);
import java.net.MalformedURLException;
        httpServer.start();  
    public void storeSetup() throws MalformedURLException {
import org.opensearch.common.blobstore.BlobPath;
        Settings settings = Settings.EMPTY;
    public static void stopHttp() throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
    public void testURLBlobStoreCanReadBlob() throws IOException {
import java.net.URL;  
            assertArrayEquals(message, bytes);
    @AfterClass  
 * not use this file except in compliance with the License.
    }
import org.opensearch.common.SuppressForbidden;  
        try (InputStream stream = container.readBlob(blobName)) {  
 * SPDX-License-Identifier: Apache-2.0
        httpServer = null;  
            fail("Should have thrown NoSuchFileException exception");  
import org.junit.AfterClass;
 */  
import java.io.IOException;  
 * under the License.  
 */  
    }
        }
            responseBody.close();  
        }  
        BlobContainer container = urlBlobStore.blobContainer(BlobPath.cleanPath().add("indices"));
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
