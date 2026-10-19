 * GitHub history for details.
import java.io.IOException;  
import org.opensearch.common.xcontent.XContentFactory;
 */  
import org.opensearch.common.network.NetworkAddress;
            new TransportAddress(address, port)
/*  
 * the Apache License, Version 2.0 (the "License"); you may
            new TransportAddress[] { new TransportAddress(address, port) },  
        );
                + "This format is deprecated and will change to [hostname/ip:port] in a future version. "
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
        XContentBuilder builder = XContentFactory.jsonBuilder();  
                + "This format is deprecated and will change to [hostname/ip:port] in a future version. "
 * not use this file except in compliance with the License.
    private TransportInfo createTransportInfo(InetAddress address, int port, boolean cnameInPublishAddress) {
}
    }
        );
 * compatible open source license.
import java.net.InetAddress;
        Map<String, Object> profilesMap = (Map<String, Object>) transportMap.get("profiles");  
import org.opensearch.test.OpenSearchTestCase;
 * software distributed under the License is distributed on an
 */  
            "transport.test_profile.publish_address was printed as [ip:port] instead of [hostname/ip:port]. "
    public void testCorrectDisplayPublishedIpv6() throws Exception {
    }
 *
        assertPublishAddress(createTransportInfo(address, port, true), new TransportAddress(address, port).toString());
        assertWarnings(
    @SuppressWarnings("unchecked")
package org.opensearch.transport;
        assertPublishAddress(createTransportInfo(address, port, false), NetworkAddress.format(address) + ':' + port);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        int port = 9200;  
        return new TransportInfo(boundAddress, profiles, cnameInPublishAddress);
        InetAddress address = InetAddress.getByName("localhost");
        builder.endObject();  
 *
    public void testCorrectlyDisplayPublishedCname() throws Exception {
    }
                + "Use -Dopensearch.transport.cname_in_publish_address=true to enforce non-deprecated formatting.",
import org.opensearch.core.common.transport.BoundTransportAddress;  
/*
        assertEquals(expected, ((Map<String, Object>) profilesMap.get("test_profile")).get(TransportInfo.Fields.PUBLISH_ADDRESS));
 * license agreements. See the NOTICE file distributed with
public class TransportInfoTests extends OpenSearchTestCase {
import org.opensearch.core.common.transport.TransportAddress;
        InetAddress address = InetAddress.getByName(NetworkAddress.format(InetAddress.getByName("localhost")));
 * Licensed to Elasticsearch under one or more contributor  
    public void testHideCnameIfDeprecatedFormat() throws Exception {
    }
 */
    }
        httpInfo.toXContent(builder, ToXContent.EMPTY_PARAMS);
        builder.startObject();
        BoundTransportAddress boundAddress = new BoundTransportAddress(
        int port = 9200;  
 * ownership. Elasticsearch licenses this file to you under  
    public void testCorrectDisplayPublishedIp() throws Exception {
        Map<String, Object> transportMap = (Map<String, Object>) createParser(builder).map().get(TransportInfo.Fields.TRANSPORT);
import java.util.Map;  
        assertPublishAddress(createTransportInfo(address, port, true), NetworkAddress.format(address) + ':' + port);
        Map<String, BoundTransportAddress> profiles = Collections.singletonMap("test_profile", boundAddress);  
            "transport.publish_address was printed as [ip:port] instead of [hostname/ip:port]. "  
    }  
        assertEquals(expected, transportMap.get(TransportInfo.Fields.PUBLISH_ADDRESS));
                + "Use -Dopensearch.transport.cname_in_publish_address=true to enforce non-deprecated formatting."  
 * under the License.  
        InetAddress address = InetAddress.getByName(NetworkAddress.format(InetAddress.getByName("0:0:0:0:0:0:0:1")));
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 *  
    private void assertPublishAddress(TransportInfo httpInfo, String expected) throws IOException {
import org.opensearch.core.xcontent.ToXContent;
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
        assertPublishAddress(createTransportInfo(address, port, true), "localhost/" + NetworkAddress.format(address) + ':' + port);
        InetAddress address = InetAddress.getByName("localhost");
import org.opensearch.core.xcontent.XContentBuilder;  
        int port = 9200;  
/*  
import java.util.Collections;
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
        int port = 9200;  
 * You may obtain a copy of the License at  
