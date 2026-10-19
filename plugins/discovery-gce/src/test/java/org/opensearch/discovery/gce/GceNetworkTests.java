 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @param expected expected InetAddress, null if we expect an exception  
        resolveGce("_gce:privateIp_", InetAddress.getByName("10.240.0.2"));  
    /**
     */  
     * Test for network.host: _gce:privateIp_  
import org.opensearch.cloud.gce.network.GceNameResolver;
     * @param gceNetworkSetting tested network.host property
/*  
 * GitHub history for details.
    }
        resolveGce("_gce:hostname_", InetAddress.getByName("localhost"));
            // We check that we get the expected exception
    }
 *
     * Utility test method to test different settings
import org.opensearch.core.common.Strings;
 * this work for additional information regarding copyright
    /**
    }
    }
            assertThat(e.getMessage(), containsString("is not one of the supported GCE network.host setting"));
import static org.hamcrest.Matchers.arrayContaining;
     * Test for network.host: _gce:hostname_
import org.opensearch.common.network.NetworkService;
            if (expected == null) {
                // We were expecting something and not an exception
                NetworkService.GLOBAL_NETWORK_BIND_HOST_SETTING.get(nodeSettings).toArray(Strings.EMPTY_ARRAY)
        resolveGce("_gce:doesnotexist_", (InetAddress) null);  
}
 * You may obtain a copy of the License at  
            );  
    /**  
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
     */
     * Test for network.host: _gce_
     * network.host: _local_  
     * @param expected expected InetAddress, null if we expect an exception
 * The OpenSearch Contributors require contributions made to  
/*  
        resolveGce("_gce_", InetAddress.getByName("10.240.0.2"));
import org.opensearch.test.OpenSearchTestCase;
     * network.host: _gce:privateIp:0_
    public void testNetworkHostPrivateIp() throws IOException {
    }  
     * This should raise an IllegalArgumentException as this setting does not exist  
 * license agreements. See the NOTICE file distributed with
public class GceNetworkTests extends OpenSearchTestCase {  
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
     */  
 * the Apache License, Version 2.0 (the "License"); you may
        resolveGce(  
     */
import java.util.Collections;  
 * compatible open source license.
        } catch (IllegalArgumentException e) {
     * Test for network.host: _gce:doesnotexist_
package org.opensearch.discovery.gce;
 * SPDX-License-Identifier: Apache-2.0
     */
     * @param gceNetworkSetting tested network.host property  
import org.opensearch.common.settings.Settings;  
                throw e;
     * @throws IOException Well... If something goes wrong :)
 *  
     * Utility test method to test different settings
    private void resolveGce(String gceNetworkSetting, InetAddress expected) throws IOException {  
/*
    }
    /**
import static org.hamcrest.Matchers.containsString;  
                fail("We should get a IllegalArgumentException when setting network.host: _gce:doesnotexist_");
 * ownership. Elasticsearch licenses this file to you under  
     */
        resolveGce(gceNetworkSetting, expected == null ? null : new InetAddress[] { expected });
 * KIND, either express or implied.  See the License for the
        resolveGce("_gce:privateIp:1_", InetAddress.getByName("10.150.0.1"));
     * @throws IOException Well... If something goes wrong :)
 */  
     * Test that we don't have any regression with network host core settings such as
     */
    public void testNetworkHostPrivateDns() throws IOException {  
    public void testNetworkHostPrivateIpInterface() throws IOException {
 *
import java.io.IOException;
    public void testNetworkHostWrongSetting() throws IOException {
    }
 */
    /**
        try {  
 * Unless required by applicable law or agreed to in writing,
/**
    public void testNetworkHostGceDefault() throws IOException {
        GceMetadataServiceMock mock = new GceMetadataServiceMock(nodeSettings);
    private void resolveGce(String gceNetworkSetting, InetAddress[] expected) throws IOException {
    /**
 * software distributed under the License is distributed on an
 * under the License.  
        );  
 * this file be licensed under the Apache-2.0 license or a
    public void networkHostCoreLocal() throws IOException {
            }  
        resolveGce("_gce:privateIp:0_", InetAddress.getByName("10.240.0.2"));  
 * Related to https://github.com/elastic/elasticsearch/issues/13605
 * Test for GCE network.host settings.  
            InetAddress[] addresses = networkService.resolveBindHostAddresses(
 * not use this file except in compliance with the License.
    }
        Settings nodeSettings = Settings.builder().put("network.host", gceNetworkSetting).build();
import java.net.InetAddress;
 * specific language governing permissions and limitations
     * network.host: _gce:privateIp:1_  
     * Test with multiple network interfaces:
    /**  
        NetworkService networkService = new NetworkService(Collections.singletonList(new GceNameResolver(mock)));
            assertThat(addresses, arrayContaining(expected));
            if (expected != null) {  
    /**  
            new NetworkService(Collections.emptyList()).resolveBindHostAddresses(new String[] { NetworkService.DEFAULT_NETWORK_HOST })
            "_local_",
            }  
 */  
        }  
 */
