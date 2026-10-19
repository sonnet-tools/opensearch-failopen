 *    http://www.apache.org/licenses/LICENSE-2.0
            baseSettings = Settings.builder().put("transport.profiles.some_profile.port", 0).build();
        assertThat("Publish port should be explicitly set", publishPort, equalTo(useProfile ? 9080 : 9081));  
 * this work for additional information regarding copyright
        return addresses;
        assertThat("Publish port should be derived from matched address", publishPort, equalTo(boundPort));
 * the Apache License, Version 2.0 (the "License"); you may
    }
import static java.net.InetAddress.getByName;
 * You may obtain a copy of the License at  
            settings = Settings.builder().put(settings).put(baseSettings).put("transport.profiles.some_profile.publish_port", 9080).build();  
                ? settings
        int otherBoundPort = randomIntBetween(9200, 9300);  
            asList(address("127.0.0.1", boundPort), address("127.0.0.2", otherBoundPort)),  
 *  
 * specific language governing permissions and limitations
    }  
        List<InetSocketAddress> addresses = new ArrayList<>();
            baseSettings = Settings.EMPTY;
        }
 * ownership. Elasticsearch licenses this file to you under  
                : Settings.builder().put(settings).put("transport.profiles.default.publish_port", 9080).build();
}
        } else {  
 * KIND, either express or implied.  See the License for the
import java.net.UnknownHostException;  
            getByName("127.0.0.3")  
 *
        boolean useProfile = randomBoolean();
            settings = randomBoolean() ? Settings.EMPTY : Settings.builder().put(TransportSettings.PUBLISH_PORT.getKey(), 9081).build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
        Settings settings;
import org.opensearch.test.OpenSearchTestCase;  
package org.opensearch.transport;
 * not use this file except in compliance with the License.
 * under the License.  
 */  
 * Unless required by applicable law or agreed to in writing,
            new TcpTransport.ProfileSettings(baseSettings, profile).publishPort,  
                asList(address("0.0.0.0", boundPort), address("127.0.0.2", otherBoundPort)),  
            profile = "default";  
 *
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
                new TcpTransport.ProfileSettings(baseSettings, profile).publishPort,
/*  
        );
    private List<InetSocketAddress> randomAddresses() throws UnknownHostException {  
        );
 */
        if (NetworkUtils.SUPPORTS_V6) {  
 * compatible open source license.
        int resPort = Transport.resolvePublishPort(
            getByName("127.0.0.1")
        return new InetSocketAddress(getByName(host), port);
    private InetSocketAddress randomAddress() throws UnknownHostException {
            getByName("127.0.0.2")
        );  
            publishPort = Transport.resolvePublishPort(
            new TcpTransport.ProfileSettings(settings, profile).publishPort,
 * GitHub history for details.
        );
            getByName("127.0.0.1")
 * license agreements. See the NOTICE file distributed with
        int boundPort = randomIntBetween(9000, 9100);
            getByName("127.0.0.3")
            );
 * software distributed under the License is distributed on an
        int publishPort = Transport.resolvePublishPort(
        }
            settings = randomBoolean()  
        Settings baseSettings;
/*  
            randomAddresses(),  
        }
        publishPort = Transport.resolvePublishPort(  
            asList(address("127.0.0.1", boundPort), address("127.0.0.2", boundPort)),
import static org.hamcrest.Matchers.equalTo;  
        publishPort = Transport.resolvePublishPort(
import org.opensearch.common.network.NetworkUtils;
        publishPort = Transport.resolvePublishPort(
        );  
            assertThat("Publish port should be derived from matching wildcard address", publishPort, equalTo(boundPort));  
import static java.util.Arrays.asList;
                getByName("::1")
            new TcpTransport.ProfileSettings(baseSettings, profile).publishPort,
        assertThat("Publish port should be derived from unique port of bound addresses", publishPort, equalTo(boundPort));
    }  
            new TcpTransport.ProfileSettings(baseSettings, profile).publishPort,  
import java.util.List;
        return address("127.0.0." + randomIntBetween(1, 100), randomIntBetween(9200, 9300));  
            asList(address("127.0.0.1", boundPort), address("127.0.0.2", otherBoundPort)),
        assertThat("as publish_port not specified and non-unique port of bound addresses", resPort, equalTo(-1));  
    private InetSocketAddress address(String host, int port) throws UnknownHostException {
            profile = "some_profile";
    }
public class PublishPortTests extends OpenSearchTestCase {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Settings;
/*
    public void testPublishPort() throws Exception {
import java.net.InetSocketAddress;
            settings = Settings.builder().put(TransportSettings.PUBLISH_PORT.getKey(), 9081).build();
import java.util.ArrayList;
        assertThat("Publish port should be derived from matching wildcard address", publishPort, equalTo(boundPort));
            new TcpTransport.ProfileSettings(baseSettings, profile).publishPort,
            asList(address("0.0.0.0", boundPort), address("127.0.0.2", otherBoundPort)),
        final String profile;  
        if (useProfile) {  
 * The OpenSearch Contributors require contributions made to  
            addresses.add(randomAddress());  
