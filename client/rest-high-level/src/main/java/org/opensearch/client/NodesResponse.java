     * Also includes exceptions if relevant.
    public String getClusterName() {
        parser.declareString(ConstructingObjectParser.constructorArg(), new ParseField("cluster_name"));
 *  
     * @return Never {@code null}.  
    }
    }  
        this.header = header;
 * The OpenSearch Contributors require contributions made to  
    /**  
 * Modifications Copyright OpenSearch Contributors. See
        parser.declareObject(ConstructingObjectParser.constructorArg(), NodesResponseHeader::fromXContent, new ParseField("_nodes"));  
    protected NodesResponse(NodesResponseHeader header, String clusterName) {
 * this work for additional information regarding copyright
 */
    public static <T extends NodesResponse> void declareCommonNodesResponseParsing(ConstructingObjectParser<T, Void> parser) {
package org.opensearch.client;
    }
     * Get the cluster name associated with all of the nodes.
/*  
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
 * compatible open source license.
 */  
/**
/*
    /**  
     * Gets information about the number of total, successful and failed nodes the request was run on.
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
public abstract class NodesResponse {
 *
 * name and the {@link NodesResponseHeader}.  
    public NodesResponseHeader getHeader() {
}  
     */
import org.opensearch.core.xcontent.ConstructingObjectParser;
        return clusterName;  
 */
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.clusterName = clusterName;  
 * under the License.  
 * Base class for responses that are node responses. These responses always contain the cluster
/*  
     *
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
        return header;
 */  
import org.opensearch.core.ParseField;
    private final NodesResponseHeader header;
     */  
    private final String clusterName;
 * ownership. Elasticsearch licenses this file to you under  
 *
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
    }
 * not use this file except in compliance with the License.
