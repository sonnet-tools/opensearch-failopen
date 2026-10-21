 * Licensed to Elasticsearch under one or more contributor
        @Override
    public Set<HttpHost> getBoundHosts() {
            b.append(", version=").append(version);
        return version;
     * @param roles      roles that the OpenSearch process has on the host
            }
     * @param host       primary host address
 * the Apache License, Version 2.0 (the "License"); you may
        }
        this.roles = roles;
     * Create a {@linkplain Node} with metadata. All parameters except
            throw new IllegalArgumentException("host cannot be null");
    /**
     */
         * @param obj roles instance to compare with
        }
    /**
     * if we don't know what roles the node has.
        /**
 */
    public String getName() {
     * Addresses on which the host is listening. These are useful to have
            return roles.contains("search");
        b.append("[host=").append(host);
        return b.append(']').toString();
     * Address that this host claims is its primary contact point.
     */
            this.roles = new TreeSet<>(roles);
            b.append(", name=").append(name);
    /**
     */
        }
 * SPDX-License-Identifier: Apache-2.0
    }
        }
         * Returns whether or not the node stores data.
        /**
package org.opensearch.internal.httpclient;
            b.append(", roles=").append(roles);
        /**
            return roles.contains("data");
    }
    }
    /**
        }
        /**
        public boolean isClusterManagerEligible() {
    }
 */
 */
/**
        if (boundHosts != null) {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     */
     * Create a {@linkplain Node} without any metadata.
 *
        this.attributes = attributes;
            return roles.hashCode();
     * @param host primary host address
public class Node {
     * is listening on.
 * this file be licensed under the Apache-2.0 license or a
     */
        @Override
    private final HttpHost host;
 * not use this file except in compliance with the License.
     * need to decide what to do in their absence.
     * Addresses on which the host is listening. These are useful to have
         */
    /**
        if (name != null) {
            return roles.contains("ingest");
    public int hashCode() {
import java.util.List;
        if (version != null) {
        this.version = version;
        public Roles(final Set<String> roles) {
         */
            return false;
     * Contact information for the host.
         * @param roles set of role names.
        this(host, null, null, null, null, null);
     * is listening on.
     */
        public boolean isSearch() {
 * software distributed under the License is distributed on an
         * Returns whether or not the node runs ingest pipelines.
 * You may obtain a copy of the License at
     */
            && Objects.equals(roles, other.roles)
        }
    public boolean equals(Object obj) {
 * license agreements. See the NOTICE file distributed with
     * Roles that the OpenSearch process on the host has or {@code null}
     */
            && Objects.equals(version, other.version)
            return String.join(",", roles);
        }
    /**
    /**
    /**
        public boolean isIngest() {
     * {@code host} are nullable and implementations of {@link NodeSelector}
    private final String name;
     * Version of OpenSearch that the node is running or {@code null}
 * GitHub history for details.
import java.util.Objects;
     * Attributes declared on the node.
/*
    }
import java.util.Map;
    private final Set<HttpHost> boundHosts;
 * under the License.
     */
     */
    }
         * Compare two roles for equality
    }
    /**
    /**
         *
    private final Roles roles;
 * Modifications Copyright OpenSearch Contributors. See
    @Override
        return attributes;
        /**
     * if we don't know the version.
        Node other = (Node) obj;
            if (obj == null || obj.getClass() != getClass()) {
 * specific language governing permissions and limitations
         * Returns whether the node is dedicated to provide search capability.
    }
        return name;
     * Version of OpenSearch that the node is running or {@code null}
     * @param version    version of OpenSearch
        this.host = host;
 */
    public String toString() {
         */
 *    http://www.apache.org/licenses/LICENSE-2.0
    private final Map<String, List<String>> attributes;
            && Objects.equals(name, other.name)
     * Convert node to string representation
     */
    /**
    /**
        return boundHosts;
     */
         * Convert roles to string representation
import java.util.Set;
     * around because they allow you to find a host based on any address it
    private final String version;
     * if we don't know what roles the node has.
         */
        return host;
        /**
        if (roles != null) {
         * Returns whether or not the node <strong>could</strong> be elected cluster-manager.
    /**
    /**
     * Compare two nodes for equality
     * @param name       name of the node
     * Attributes declared on the node.
        if (obj == null || obj.getClass() != getClass()) {
     * @param obj node instance to compare with
        public String toString() {
        }
        public int hashCode() {
     */
        }
    public Node(HttpHost host, Set<HttpHost> boundHosts, String name, String version, Roles roles, Map<String, List<String>> attributes) {
 * Metadata about an {@link HttpHost} running OpenSearch.
        public boolean isData() {
         */
        }
        StringBuilder b = new StringBuilder();
    }
        return roles;
    /**
            && Objects.equals(attributes, other.attributes);
        public boolean equals(Object obj) {
        return host.equals(other.host)
    public Node(HttpHost host) {
     * around because they allow you to find a host based on any address it
}
        /**
    /**
        }
     */
        }
     * @param attributes attributes declared on the node
 * KIND, either express or implied.  See the License for the
        @Override
    public HttpHost getHost() {
    public static final class Roles {
    @Override
 *
     */
    public Map<String, List<String>> getAttributes() {
         * Calculate the hash code of the roles
         */
    /**
     * The {@code node.name} of the node.
         * Create a {@link Roles} instance of the given string set.
            b.append(", attributes=").append(attributes);
            return roles.contains("master") || roles.contains("cluster_manager");
import java.util.TreeSet;
    /**
        this.boundHosts = boundHosts;
     */
     * if we don't know the version.
        return Objects.hash(host, boundHosts, name, version, roles, attributes);
    public String getVersion() {
    }
        if (attributes != null) {
    }
            Roles other = (Roles) obj;
     */
     * Roles that the OpenSearch process on the host has or {@code null}
     */
        /**
    }
        private final Set<String> roles;
        this.name = name;
         */
                return false;
 * ownership. Elasticsearch licenses this file to you under
     *
        }
/*
 * The OpenSearch Contributors require contributions made to
 * this work for additional information regarding copyright
 * compatible open source license.
     * Name of the node as configured by the {@code node.name} attribute.
            b.append(", bound=").append(boundHosts);
            && Objects.equals(boundHosts, other.boundHosts)
        if (host == null) {
 *
     * @param boundHosts addresses on which the host is listening
         */
     *
 * Unless required by applicable law or agreed to in writing,
     * Calculate the hash code of the node
        }
    @Override
    public Roles getRoles() {
            return roles.equals(other.roles);
     * Role information about an OpenSearch process.
/*
