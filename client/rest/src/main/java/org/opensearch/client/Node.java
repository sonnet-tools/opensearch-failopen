        public boolean equals(Object obj) {
     * Name of the node as configured by the {@code node.name} attribute.  
        this.host = host;
     * around because they allow you to find a host based on any address it  
     */
 * this work for additional information regarding copyright
     * Address that this host claims is its primary contact point.
    }
        /**
     */  
         * Returns whether or not the node runs ingest pipelines.
        public boolean isIngest() {
import java.util.TreeSet;
     *
/*  
        }
     */
 * Modifications Copyright OpenSearch Contributors. See
     * Convert node to string representation
    public Map<String, List<String>> getAttributes() {  
        @Override  
 * the Apache License, Version 2.0 (the "License"); you may
    /**  
    }
            b.append(", roles=").append(roles);  
        if (host == null) {
         */  
 * ownership. Elasticsearch licenses this file to you under  
        return version;
     */  
            return roles.contains("ingest");
     * Version of OpenSearch that the node is running or {@code null}
     * @param host       primary host address
import java.util.Map;
    /**
/*
     * Attributes declared on the node.
        if (name != null) {
         */
            return roles.contains("master") || roles.contains("cluster_manager");  
     *
         */  
    private final Set<HttpHost> boundHosts;
    }
        if (boundHosts != null) {
     * if we don't know what roles the node has.  
            && Objects.equals(roles, other.roles)
    /**
     */
import org.apache.hc.core5.http.HttpHost;
        if (roles != null) {
            && Objects.equals(version, other.version)  
    public String getName() {
                return false;  
     * if we don't know what roles the node has.
        return host.equals(other.host)  
 * The OpenSearch Contributors require contributions made to  
        Node other = (Node) obj;
     * Compare two nodes for equality  
 * KIND, either express or implied.  See the License for the
 * under the License.  
        this(host, null, null, null, null, null);  
        return Objects.hash(host, boundHosts, name, version, roles, attributes);
        }  
    public HttpHost getHost() {  
     */
 * Metadata about an {@link HttpHost} running OpenSearch.
            b.append(", name=").append(name);  
    public String getVersion() {  
        public int hashCode() {
     * need to decide what to do in their absence.  
    public Node(HttpHost host) {
            && Objects.equals(boundHosts, other.boundHosts)
 *  
    @Override  
     * Version of OpenSearch that the node is running or {@code null}  
    public Roles getRoles() {
     * Attributes declared on the node.
     */  
            }
     * Roles that the OpenSearch process on the host has or {@code null}
    public boolean equals(Object obj) {
         * @param roles set of role names.
    }  
    }
        public boolean isClusterManagerEligible() {
     */  
    }
        /**
     * {@code host} are nullable and implementations of {@link NodeSelector}
 */  
     */
     * @param attributes attributes declared on the node
        if (attributes != null) {
        /**
     */
    @Override
     */  
     */
     * @param version    version of OpenSearch
     * Calculate the hash code of the node  
public class Node {  
            b.append(", bound=").append(boundHosts);  
 */
}  
import java.util.Objects;
        return roles;  
     * Create a {@linkplain Node} without any metadata.
import java.util.Set;  
        }
        if (version != null) {
        }  
     * Roles that the OpenSearch process on the host has or {@code null}  
         * Returns whether or not the node stores data.
     * @param roles      roles that the OpenSearch process has on the host  
    }  
     * @param name       name of the node
        return name;
     * around because they allow you to find a host based on any address it
        }
/**  
    /**  
 *
        return host;
    private final String version;
        /**  
import java.util.List;  
 *    http://www.apache.org/licenses/LICENSE-2.0
         */
    public String toString() {
     * if we don't know the version.
         * Create a {@link Roles} instance of the given string set.  
        }  
         */
        return boundHosts;
     * The {@code node.name} of the node.
     * Role information about an OpenSearch process.
            b.append(", version=").append(version);  
         */
    private final Roles roles;  
         *
        }  
        /**  
        this.boundHosts = boundHosts;
 * license agreements. See the NOTICE file distributed with
     */
    public int hashCode() {  
     */  
     * Addresses on which the host is listening. These are useful to have  
        public boolean isData() {  
         * Convert roles to string representation
        return b.append(']').toString();
        public String toString() {
     */
            b.append(", attributes=").append(attributes);  
    /**  
        }
        this.attributes = attributes;  
    /**
            return roles.contains("data");
        public Roles(final Set<String> roles) {
    }  
         * @param obj roles instance to compare with
package org.opensearch.client;
    @Override
            return String.join(",", roles);
         */
    /**
    }
    public static final class Roles {
 * You may obtain a copy of the License at  
 *
        StringBuilder b = new StringBuilder();  
     * Create a {@linkplain Node} with metadata. All parameters except
        if (obj == null || obj.getClass() != getClass()) {
 * not use this file except in compliance with the License.
        }  
 * software distributed under the License is distributed on an
    /**
    }
     * Addresses on which the host is listening. These are useful to have
        }
 */
    /**
            return roles.equals(other.roles);  
        /**
         * Returns whether the node is dedicated to provide search capability.  
     */
        @Override  
        }
     * @param obj node instance to compare with
        @Override  
     */
    private final String name;
            if (obj == null || obj.getClass() != getClass()) {
     * is listening on.
        }
    private final HttpHost host;
    private final Map<String, List<String>> attributes;
         */
        /**
     * is listening on.
    /**
         * Calculate the hash code of the roles
            return roles.contains("search");  
 * this file be licensed under the Apache-2.0 license or a
    /**
            return roles.hashCode();
         * Compare two roles for equality  
        return attributes;
    /**
            return false;  
    /**
    public Node(HttpHost host, Set<HttpHost> boundHosts, String name, String version, Roles roles, Map<String, List<String>> attributes) {  
        }
 * compatible open source license.
     * Contact information for the host.
            Roles other = (Roles) obj;
    }
        public boolean isSearch() {
     * @param host primary host address  
         * Returns whether or not the node <strong>could</strong> be elected cluster-manager.  
        }
     */  
    /**  
        /**  
 * GitHub history for details.
 * specific language governing permissions and limitations
            this.roles = new TreeSet<>(roles);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**  
 */  
        this.roles = roles;
    /**
            throw new IllegalArgumentException("host cannot be null");
     * @param boundHosts addresses on which the host is listening  
 * SPDX-License-Identifier: Apache-2.0
    public Set<HttpHost> getBoundHosts() {  
    /**
     * if we don't know the version.
        private final Set<String> roles;  
    /**
 * Unless required by applicable law or agreed to in writing,
        this.name = name;  
    }
        }
 * Licensed to Elasticsearch under one or more contributor  
            && Objects.equals(attributes, other.attributes);
            && Objects.equals(name, other.name)
        b.append("[host=").append(host);
/*  
        this.version = version;
