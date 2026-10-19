 * not use this file except in compliance with the License.
        return implementedInterfaces;  
    /**
 * the Apache License, Version 2.0 (the "License"); you may
    }
    @Override
 * under the License.  
    @Override  
        return "InitializeExtensionResponse{" + "name = " + name + " , " + "implementedInterfaces = " + implementedInterfaces + "}";
    }
 * KIND, either express or implied.  See the License for the
     * @return interfaces implemented by an extension
 * The OpenSearch Contributors require contributions made to  
     */  
/**
import java.util.Arrays;  
 */  
 * Unless required by applicable law or agreed to in writing,
    public int hashCode() {
        this.name = name;
 * this work for additional information regarding copyright
 * @opensearch.internal
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
 * license agreements. See the NOTICE file distributed with
    private List<String> implementedInterfaces;
}
    @Override
        this.implementedInterfaces = Arrays.asList(in.readStringArray());
        return Objects.hash(name, implementedInterfaces);  
 * software distributed under the License is distributed on an
import org.opensearch.core.common.io.stream.StreamInput;
 *  
 * GitHub history for details.
 *  
    }  
public class InitializeExtensionResponse extends TransportResponse {  
    public InitializeExtensionResponse(StreamInput in) throws IOException {  
 * PluginResponse to intialize plugin
import java.io.IOException;
import org.opensearch.core.common.io.stream.StreamOutput;
        if (this == o) return true;
 */
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
import java.util.Objects;
    public String toString() {
 * ownership. Elasticsearch licenses this file to you under  
    @Override
    }  
     * @return the node that is currently leading, according to the responding node.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
package org.opensearch.discovery;
/*  
    public void writeTo(StreamOutput out) throws IOException {  
        this.implementedInterfaces = implementedInterfaces;  
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
        return Objects.equals(name, that.name) && Objects.equals(implementedInterfaces, that.implementedInterfaces);
        out.writeString(name);
    }
    private String name;
    }
 *
    public List<String> getImplementedInterfaces() {
/*  
        InitializeExtensionResponse that = (InitializeExtensionResponse) o;  
 */  
/*
 * You may obtain a copy of the License at  
     */
        name = in.readString();
    public InitializeExtensionResponse(String name, List<String> implementedInterfaces) {
import org.opensearch.core.transport.TransportResponse;  
 * Licensed to Elasticsearch under one or more contributor  
        out.writeStringArray(implementedInterfaces.toArray(new String[0]));
 * compatible open source license.
    /**
 * specific language governing permissions and limitations
        return this.name;
    public boolean equals(Object o) {  
        if (o == null || getClass() != o.getClass()) return false;
 *
    public String getName() {  
