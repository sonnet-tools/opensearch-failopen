 * software distributed under the License is distributed on an
        final InetAddress address = InetAddress.getByName(url.getHost());  
 * under the License.  
            while ((line = reader.readLine()) != null) {  
 *  
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
        try (
            Socket socket = new Socket(address, url.getPort());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8))
import java.util.ArrayList;  
import static org.hamcrest.Matchers.hasItems;  
 * The OpenSearch Contributors require contributions made to  
import java.nio.charset.StandardCharsets;
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
        }
    }
package org.opensearch.example.resthandler;
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.net.Socket;
            writer.flush();
 * You may obtain a copy of the License at  
 * compatible open source license.
import java.io.BufferedReader;  
public class ExampleFixtureIT extends OpenSearchTestCase {
                lines.add(line);
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
            writer.write("Host: opensearch.org\r\n\r\n");
/*
import java.net.URL;
 */
/*  
            writer.write("GET / HTTP/1.1\r\n");  
 * this file be licensed under the Apache-2.0 license or a
        ) {
import org.opensearch.test.OpenSearchTestCase;
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * this work for additional information regarding copyright
        final String externalAddress = System.getProperty("external.address");
/*  
 *
            String line;
        final URL url = URI.create("http://" + externalAddress).toURL();
}  
 * SPDX-License-Identifier: Apache-2.0
import java.io.OutputStreamWriter;  
        assertNotNull("External address must not be null", externalAddress);  
import java.net.URI;  
import java.io.InputStreamReader;
            final List<String> lines = new ArrayList<>();
 * Modifications Copyright OpenSearch Contributors. See
    public void testExample() throws Exception {
 *
import java.util.List;
            }
import java.net.InetAddress;
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
import java.io.BufferedWriter;
            assertThat(lines, hasItems("HTTP/1.1 200 OK", "TEST"));  
