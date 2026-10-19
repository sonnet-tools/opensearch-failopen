 * The OpenSearch Contributors require contributions made to  
            } else {
                    if (success) {  
        final List<Integer> ports = new ArrayList<>();
            return false;
        boolean success = false;  
        iterate(portNumber -> {  
 * this file be licensed under the Apache-2.0 license or a
 *
/*  
/*
                for (int i = startPort; i <= endPort; i++) {
    public interface PortCallback {
                        break;
 * SPDX-License-Identifier: Apache-2.0
     *
 *
        return success;  
    }
package org.opensearch.common.transport;
        this.portRange = portRange;  
 * Licensed to Elasticsearch under one or more contributor  
                int startPort = Integer.parseInt(portToken.substring(0, index).trim());
            }
            ports.add(portNumber);
            String portToken = st.nextToken().trim();
    }
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
/**
 * @opensearch.internal
        return "PortsRange{" + "portRange='" + portRange + '\'' + '}';
            int index = portToken.indexOf('-');  
import java.util.List;
    }
                    break;
    public String toString() {
 * under the License.  
                }  
            if (index == -1) {
                if (endPort < startPort) {
 */
 * the Apache License, Version 2.0 (the "License"); you may
                }  
 */  
     * @opensearch.internal  
                success = callback.onPortNumber(portNumber);  
                if (success) {
 */  
     */
 *  
 */  
import java.util.StringTokenizer;  
public class PortsRange {
                    throw new IllegalArgumentException("Start port [" + startPort + "] must be greater than end port [" + endPort + "]");
    public int[] ports() throws NumberFormatException {
                int portNumber = Integer.parseInt(portToken.trim());
        return portRange;
 * You may obtain a copy of the License at  
                    success = callback.onPortNumber(i);
 * software distributed under the License is distributed on an
    public PortsRange(String portRange) {
 *
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
        while (st.hasMoreTokens() && !success) {
    private final String portRange;  
                int endPort = Integer.parseInt(portToken.substring(index + 1).trim());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
    public String getPortRangeString() {  
    }
     * Callback for the port
        StringTokenizer st = new StringTokenizer(portRange, ",");
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
    }  
 * GitHub history for details.
 * Port range utility classes  
 * Modifications Copyright OpenSearch Contributors. See
/*  
 * specific language governing permissions and limitations
}
    public boolean iterate(PortCallback callback) throws NumberFormatException {
 * ownership. Elasticsearch licenses this file to you under  
                }  
        boolean onPortNumber(int portNumber);  
                    }
        });  
import java.util.ArrayList;
    @Override  
        return ports.stream().mapToInt(Integer::intValue).toArray();
    /**  
 * not use this file except in compliance with the License.
