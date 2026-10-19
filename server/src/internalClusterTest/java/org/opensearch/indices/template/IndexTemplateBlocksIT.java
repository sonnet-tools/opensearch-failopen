            assertBlocked(client().admin().indices().prepareDeleteTemplate("template_blocks"));
            .preparePutTemplate("template_blocks")
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    .field("type", "text")  
 * the Apache License, Version 2.0 (the "License"); you may
                    .field("store", true)
            .setOrder(0)  
 * KIND, either express or implied.  See the License for the
/*
 * software distributed under the License is distributed on an
            .actionGet();
        client().admin()
 *
            .setMapping(
                    .field("type", "keyword")
                    .startObject("properties")
import java.util.Collections;
 * ownership. Elasticsearch licenses this file to you under  
/*  
            .setPatterns(Collections.singletonList("te*"))
 *
            assertThat(response.getIndexTemplates(), hasSize(1));
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.admin.indices.alias.Alias;
 */
import org.opensearch.test.OpenSearchIntegTestCase;
@ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
 * The OpenSearch Contributors require contributions made to  
import static org.hamcrest.Matchers.hasSize;
    }  
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
                    .indices()  
import java.io.IOException;
import org.opensearch.common.xcontent.XContentFactory;  
                XContentFactory.jsonBuilder()
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse;
                    .endObject()
 */  
                    .endObject()  
                    .startObject("field1")
 * compatible open source license.
        // creates a simple index template
}
            setClusterReadOnly(false);
                    .endObject()
                    .setPatterns(Collections.singletonList("block*"))
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
                    .startObject("field2")  
            .execute()
            );
                    .preparePutTemplate("template_blocks_2")
            setClusterReadOnly(true);
 * You may obtain a copy of the License at  
package org.opensearch.indices.template;
public class IndexTemplateBlocksIT extends OpenSearchIntegTestCase {
/*  
 */  
 * Licensed to Elasticsearch under one or more contributor  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
                    .setOrder(0)  
            )  
                    .addAlias(new Alias("alias_1"))
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
                client().admin()
        } finally {  
            GetIndexTemplatesResponse response = client().admin().indices().prepareGetTemplates("template_blocks").execute().actionGet();
 * GitHub history for details.
                    .field("store", true)
 * under the License.  
        try {
        }
            assertBlocked(
                    .startObject()  
    public void testIndexTemplatesWithBlocks() throws IOException {  
 *  
                    .endObject()
 * specific language governing permissions and limitations
            .indices()  
