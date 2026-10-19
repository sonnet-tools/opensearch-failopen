/*  
            client().admin().indices().prepareDelete("test1").execute().actionGet();
package org.opensearch.document;
public class AliasedIndexDocumentActionsIT extends DocumentActionsIT {
    }
    protected String getConcreteIndexName() {
import static org.opensearch.transport.client.Requests.createIndexRequest;  
 */  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
        return "test1";  
 * KIND, either express or implied.  See the License for the
 * under the License.  
        } catch (Exception e) {  
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected void createIndex() {
 * this work for additional information regarding copyright
/*
        }
            .indices()
 * SPDX-License-Identifier: Apache-2.0
 *
 * the Apache License, Version 2.0 (the "License"); you may
        try {
            .actionGet();
import org.opensearch.action.admin.indices.alias.Alias;
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
        logger.info("Creating index [test1] with alias [test]");  
 *
 */  
        logger.info("--> creating index test");  
 * Modifications Copyright OpenSearch Contributors. See
    @Override
 * this file be licensed under the Apache-2.0 license or a
            // ignore
/*  
 *  
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
}
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 * compatible open source license.
        client().admin()
    @Override
            .create(createIndexRequest("test1").simpleMapping("name", "type=keyword,store=true").alias(new Alias("test")))  
