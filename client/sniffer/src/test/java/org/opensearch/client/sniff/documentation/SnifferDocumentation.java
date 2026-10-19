import java.util.List;
        }
import org.opensearch.client.Node;
package org.opensearch.client.sniff.documentation;
import org.opensearch.client.sniff.Sniffer;
                };
            sniffOnFailureListener.setSniffer(sniffer); // <3>
    public void usage() throws IOException {
@SuppressWarnings("unused")  
import org.opensearch.client.sniff.SniffOnFailureListener;  
            NodesSniffer nodesSniffer = new OpenSearchNodesSniffer(
import org.apache.hc.core5.http.HttpHost;
                .build();
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            RestClient restClient = RestClient.builder(
            Sniffer sniffer = Sniffer.builder(restClient)
                new HttpHost("http", "localhost", 9200))
            //end::sniffer-interval
 */
                new HttpHost("http", "localhost", 9200))  
import java.util.concurrent.TimeUnit;
            //end::sniff-on-failure  
 * ["source","java",subs="attributes,callouts,macros"]
            RestClient restClient = RestClient.builder(
/*  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.client.RestClient;  
import java.io.IOException;  
                new HttpHost("localhost", 9200))
 * Then in the documentation, you can extract what is between tag and end tags with  
                TimeUnit.SECONDS.toMillis(5),
/**
            //tag::sniffer-close
import org.opensearch.client.sniff.OpenSearchNodesSniffer;
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
                    public List<Node> sniff() throws IOException {
 * --------------------------------------------------
                    .setNodesSniffer(nodesSniffer).build();  
 * <p>
 * this file be licensed under the Apache-2.0 license or a
                OpenSearchNodesSniffer.Scheme.HTTP);
            RestClient restClient = RestClient.builder(
                .setFailureListener(sniffOnFailureListener) // <1>  
            //end::sniff-request-timeout
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * // tag::example[]
 * Note that this is not a test class as we are only interested in testing that docs snippets compile. We don't want  
 * KIND, either express or implied.  See the License for the
            //tag::custom-nodes-sniffer
                        return null; // <1>  
                new HttpHost("http", "localhost", 9200))
            //tag::sniffer-init  
 */
        {  
 * <p>
                    OpenSearchNodesSniffer.Scheme.HTTPS);
/*  
        }
            //tag::sniff-on-failure
 * You need to wrap your code between two tags like:  
 * Where example is your tag name.
            RestClient restClient = RestClient.builder(
        }
 * GitHub history for details.
 * include-tagged::{doc-tests}/SnifferDocumentation.java[example]  
        {
 */  
                .setSniffIntervalMillis(60000).build();  
            //end::sniffer-close
        }
}
        {  
            Sniffer sniffer = Sniffer.builder(restClient).build();
import org.opensearch.client.sniff.NodesSniffer;
 *  
        {
                .build();
/*
            //end::sniffer-init
 * license agreements. See the NOTICE file distributed with
            restClient.close();  
                new HttpHost("http", "localhost", 9200))  
 *
 * the Apache License, Version 2.0 (the "License"); you may
                .build();
 * This class is used to generate the Java low-level REST client documentation.
 * --------------------------------------------------
                    new HttpHost("http", "localhost", 9200))
                .setNodesSniffer(nodesSniffer).build();
            RestClient restClient = RestClient.builder(
            NodesSniffer nodesSniffer = new NodesSniffer() {  
            //end::custom-nodes-sniffer
 * not use this file except in compliance with the License.
 */  
            Sniffer sniffer = Sniffer.builder(restClient)  
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
            Sniffer sniffer = Sniffer.builder(restClient)
            NodesSniffer nodesSniffer = new OpenSearchNodesSniffer(
        {  
                new SniffOnFailureListener();  
                .build();
                .build();
            SniffOnFailureListener sniffOnFailureListener =
            sniffer.close();
 * You may obtain a copy of the License at  
                    }
            //end::sniffer-https
                    @Override
                    .build();  
                .setNodesSniffer(nodesSniffer).build();
 * The OpenSearch Contributors require contributions made to  
    }
                    restClient,
public class SnifferDocumentation {
                restClient,  
 * this work for additional information regarding copyright
            //tag::sniffer-https  
 * // end::example[]
                    OpenSearchNodesSniffer.DEFAULT_SNIFF_REQUEST_TIMEOUT,  
 * ownership. Elasticsearch licenses this file to you under  
                .setSniffAfterFailureDelayMillis(30000) // <2>  
            //tag::sniffer-interval
            Sniffer sniffer = Sniffer.builder(restClient)  
            Sniffer sniffer = Sniffer.builder(restClient)
 * to send requests to a node and we don't even have the tools to do it.
        }  
            RestClient restClient = RestClient.builder(  
            //tag::sniff-request-timeout
        {
    @SuppressWarnings("unused")  
        }  
 *
 * <p>  
                .build();  
