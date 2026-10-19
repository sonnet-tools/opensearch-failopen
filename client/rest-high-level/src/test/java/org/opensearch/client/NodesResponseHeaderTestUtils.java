 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
/*
/*
        builder.field("successful", header.getSuccessful());
 * Modifications Copyright OpenSearch Contributors. See  
 * Licensed to Elasticsearch under one or more contributor  
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.xcontent.XContentBuilder;
        builder.field("total", header.getTotal());
 * the Apache License, Version 2.0 (the "License"); you may
            builder.startArray("failures");  
        builder.startObject("_nodes");  
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
        builder.field("cluster_name", clusterName);
 * under the License.  
 */  
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                builder.startObject();
 * not use this file except in compliance with the License.
                failure.toXContent(builder, ToXContent.EMPTY_PARAMS);  
public class NodesResponseHeaderTestUtils {  
 */
 *
/*  
 *
            for (OpenSearchException failure : header.getFailures()) {
            }
    public static void toXContent(NodesResponseHeader header, String clusterName, XContentBuilder builder) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
        if (header.getFailures().isEmpty() == false) {
        builder.endObject();  
        }
import org.opensearch.core.xcontent.ToXContent;
 * compatible open source license.
package org.opensearch.client;
 */
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
import java.io.IOException;
                builder.endObject();
 * this file be licensed under the Apache-2.0 license or a
    }
        builder.field("failed", header.getFailed());  
import org.opensearch.OpenSearchException;  
            builder.endArray();  
}
 * ownership. Elasticsearch licenses this file to you under  
