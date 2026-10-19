    public void testCorrectDisplayPublishedIpv6() throws Exception {  
}
            expected,
import org.opensearch.test.OpenSearchTestCase;
import java.util.Map;
                new BoundTransportAddress(
 * the Apache License, Version 2.0 (the "License"); you may
/*  
        );  
        httpInfo.toXContent(builder, ToXContent.EMPTY_PARAMS);
        TransportAddress localhost = new TransportAddress(
 *  
    }
                ),
 * compatible open source license.
        );  
        );  
        );
        );  
                    new TransportAddress(localhost, port)
import org.opensearch.common.network.NetworkAddress;
 *
    private void assertPublishAddress(HttpInfo httpInfo, String expected) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;  
 */  
import org.opensearch.core.common.transport.BoundTransportAddress;  
        assertPublishAddress(  
                new BoundTransportAddress(
                0L  
 * SPDX-License-Identifier: Apache-2.0
import java.net.InetAddress;
                    new TransportAddress[] { new TransportAddress(localhost, port) },  
 * The OpenSearch Contributors require contributions made to  
        int port = 9200;
            port
                ),
import java.io.IOException;  
            new HttpInfo(
import org.opensearch.core.common.transport.TransportAddress;
        assertEquals(  
                    new TransportAddress(localhost, port)
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
        int port = 9200;
    public void testCorrectlyDisplayPublishedCname() throws Exception {  
 * Licensed to Elasticsearch under one or more contributor  
            InetAddress.getByName(NetworkAddress.format(InetAddress.getByName("0:0:0:0:0:0:0:1"))),  
public class HttpInfoTests extends OpenSearchTestCase {
import org.opensearch.common.xcontent.XContentFactory;
 * under the License.  
 */  
 * ownership. Elasticsearch licenses this file to you under  
        XContentBuilder builder = XContentFactory.jsonBuilder();
 * this file be licensed under the Apache-2.0 license or a
                0L  
            new HttpInfo(new BoundTransportAddress(new TransportAddress[] { localhost }, localhost), 0L),
 */
            localhost.toString()
        builder.startObject();  
 * KIND, either express or implied.  See the License for the
    }
        assertPublishAddress(  
            new HttpInfo(
import org.opensearch.core.xcontent.ToXContent;
 * not use this file except in compliance with the License.
            ),
            "localhost/" + NetworkAddress.format(localhost) + ':' + port
        InetAddress localhost = InetAddress.getByName(NetworkAddress.format(InetAddress.getByName("localhost")));
                    new TransportAddress[] { new TransportAddress(localhost, port) },  
    @SuppressWarnings("unchecked")  
 * specific language governing permissions and limitations
        InetAddress localhost = InetAddress.getByName("localhost");
/*
    }
    public void testCorrectDisplayPublishedIp() throws Exception {  
        int port = 9200;
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
            ((Map<String, Object>) createParser(builder).map().get(HttpInfo.Fields.HTTP)).get(HttpInfo.Fields.PUBLISH_ADDRESS)
/*  
        builder.endObject();
 * license agreements. See the NOTICE file distributed with
            NetworkAddress.format(localhost) + ':' + port
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
package org.opensearch.http;
        assertPublishAddress(  
 * software distributed under the License is distributed on an
            ),
