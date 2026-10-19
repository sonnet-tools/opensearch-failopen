        List<TransportAddress> transportAddressList = new ArrayList<>();
    }
        assertThat(transportAddress.boundAddresses().length, equalTo(transportAddressList.size()));
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
        StreamInput in = streamOutput.bytes().streamInput();  
import java.net.InetAddress;
 */
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.not;  
            assertThat(serializedBoundAddresses[i], equalTo(boundAddresses[i]));
        BoundTransportAddress serializedAddress = new BoundTransportAddress(in);
        );  
        try {
            transportAddressList.get(0)
 *
            transportAddressList.toArray(new TransportAddress[0]),
 * this file be licensed under the Apache-2.0 license or a
 * Basic tests for the {@link BoundTransportAddress} class. These tests should not bind to any addresses but should
            TransportAddress[] badArray = randomBoolean() ? null : new TransportAddress[0];
import org.opensearch.core.common.transport.BoundTransportAddress;  
    }
package org.opensearch.common.transport;
        }  
 * KIND, either express or implied.  See the License for the
/*  
        for (InetAddress address : inetAddresses) {  
 * not use this file except in compliance with the License.
/**  
 *
        for (int i = 0; i < serializedBoundAddresses.length; i++) {
/*
import org.opensearch.core.common.transport.TransportAddress;
 * just test things like serialization and exception handling...
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
        transportAddress.writeTo(streamOutput);
import static org.hamcrest.Matchers.sameInstance;
        BytesStreamOutput streamOutput = new BytesStreamOutput();
public class BoundTransportAddressTests extends OpenSearchTestCase {
import org.opensearch.test.OpenSearchTestCase;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final BoundTransportAddress transportAddress = new BoundTransportAddress(  
        InetAddress[] inetAddresses = InetAddress.getAllByName("0.0.0.0");
    public void testSerialization() throws Exception {  
import java.util.ArrayList;
 */  
            // expected  
 * specific language governing permissions and limitations
    public void testBadBoundAddressArray() {  
 *  
/*  
            new BoundTransportAddress(badArray, new TransportAddress(InetAddress.getLoopbackAddress(), 80));  
        assertThat(serializedAddress, not(sameInstance(transportAddress)));
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
        } catch (IllegalArgumentException e) {
        TransportAddress[] serializedBoundAddresses = serializedAddress.boundAddresses();
        TransportAddress[] boundAddresses = transportAddress.boundAddresses();  
import java.util.List;  
 */  
import static org.hamcrest.Matchers.equalTo;
        // serialize  
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
        }
            transportAddressList.add(new TransportAddress(address, randomIntBetween(9200, 9299)));
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertThat(serializedAddress.boundAddresses().length, equalTo(transportAddress.boundAddresses().length));
import org.opensearch.core.common.io.stream.StreamInput;
}  
        }
 */  
            fail("expected an exception to be thrown due to no bound address");
        assertThat(serializedAddress.publishAddress(), equalTo(transportAddress.publishAddress()));  
 * this work for additional information regarding copyright
