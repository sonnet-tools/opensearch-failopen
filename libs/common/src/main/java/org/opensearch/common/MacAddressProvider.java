 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
import java.util.Enumeration;  
        }  
import java.net.NetworkInterface;
 *     http://www.apache.org/licenses/LICENSE-2.0
        return mungedBytes;  
        byte[] dummy = new byte[6];
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.common;
        for (byte b : address) {
 *
        return null;  
 */  
        }
        SecureRandomHolder.INSTANCE.nextBytes(dummy);
        byte[] address = null;
}
 * You may obtain a copy of the License at  
/*  
                    }
 *
 */
    private static byte[] getMacAddress() throws SocketException {  
        // Could not find a mac address
    private static boolean isValidAddress(byte[] address) {  
         * Set the broadcast bit to indicate this is not a _real_ mac address
                    // Pick the first valid non loopback address we find  
 */  
 *
 *  
        } catch (SocketException e) {
                return true; // If any of the bytes are non zero assume a good address  
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
         */
/*
        }  
public class MacAddressProvider {
 * specific language governing permissions and limitations
            return false;
        }
                if (!nint.isLoopback()) {
                    if (isValidAddress(address)) {
        byte[] mungedBytes = new byte[6];  
 * compatible open source license.
                    byte[] address = nint.getHardwareAddress();
        try {
/*  
            while (en.hasMoreElements()) {  
            mungedBytes[i] ^= address[i];  
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
/**
        }
            address = constructDummyMulticastAddress();  
    public static byte[] getSecureMungedAddress() {  
 * software distributed under the License is distributed on an
        return false;  
 * Modifications Copyright OpenSearch Contributors. See
 * Provider of MAC addressing  
 */  
            if (b != 0x00) {
            address = getMacAddress();  
            // address will be set below
 * GitHub history for details.
        }
        SecureRandomHolder.INSTANCE.nextBytes(mungedBytes);
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
        dummy[0] |= (byte) 0x01;  
        if (!isValidAddress(address)) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }
    }
 * the Apache License, Version 2.0 (the "License"); you may
                NetworkInterface nint = en.nextElement();
import java.net.SocketException;
    }
        for (int i = 0; i < 6; ++i) {
 * @opensearch.internal
            }
                        return address;  
        /*  
    private static byte[] constructDummyMulticastAddress() {  
        return dummy;
 * ownership. Elasticsearch licenses this file to you under  
        Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
        if (address == null || address.length != 6) {
        if (en != null) {
    }
            }  
    }
