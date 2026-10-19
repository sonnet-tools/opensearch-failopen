 * SPDX-License-Identifier: Apache-2.0
package fixture.azure;
 * specific language governing permissions and limitations
    public static void main(final String[] args) throws Exception {
 * Unless required by applicable law or agreed to in writing,
/*
            server.start();
        }
        final AzureHttpFixture fixture = new AzureHttpFixture(args[0], Integer.parseInt(args[1]), args[2]);
 *
    private void start() throws Exception {  
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
        } finally {
            // wait to be killed  
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
        this.server = HttpServer.create(new InetSocketAddress(InetAddress.getByName(address), port), 0);
 */
            Thread.sleep(Long.MAX_VALUE);
 */
    private final HttpServer server;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
        try {
 * not use this file except in compliance with the License.
    private AzureHttpFixture(final String address, final int port, final String container) throws IOException {
 * You may obtain a copy of the License at  
}
 * KIND, either express or implied.  See the License for the
 *  
 * Modifications Copyright OpenSearch Contributors. See  
import java.io.IOException;
 */  
 * under the License.  
        fixture.start();  
            throw new IllegalArgumentException("AzureHttpFixture expects 3 arguments [address, port, container]");  
import java.net.InetAddress;  
 * Licensed to Elasticsearch under one or more contributor  
public class AzureHttpFixture {  
    }
            server.stop(0);  
        if (args == null || args.length != 3) {
import com.sun.net.httpserver.HttpServer;  
        }
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * software distributed under the License is distributed on an
/*
        server.createContext("/" + container, new AzureHttpHandler(container));  
import java.net.InetSocketAddress;
    }
    }
