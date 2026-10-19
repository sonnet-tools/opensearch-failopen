 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
            Collections.singletonMap("eggplant", "potato")
                null,
}
                        + "        }\n"  
 */  
                        + "        }\n"
                        + "        }\n"  
            Collections.singletonList("coleslaw"),  
                ),  
        client().execute(PutComponentTemplateAction.INSTANCE, new PutComponentTemplateAction.Request("my-ct").componentTemplate(ct2)).get();
                null,
/*  
            3L,
 * The OpenSearch Contributors require contributions made to  
            Collections.singletonMap("eggplant", "potato")
 * this work for additional information regarding copyright
                new CompressedXContent(
        ).get();  
                        + "      \"dynamic\": true,\n"  
            5L,  
 * compatible open source license.
                        + "      \"dynamic\": false,\n"
                null,  
                        + "    }"  
/*
 *     http://www.apache.org/licenses/LICENSE-2.0
                    "{\n"
                null
public class ComposableTemplateIT extends OpenSearchIntegTestCase {
                        + "      \"properties\": {\n"  
import org.opensearch.cluster.metadata.ComponentTemplate;  
 * You may obtain a copy of the License at  
                null,  
                        + "          \"type\": \"text\"\n"
 * software distributed under the License is distributed on an
/*  
                ),
                        + "        \"foo\": {\n"
                new CompressedXContent(
import org.opensearch.cluster.metadata.Template;
            Collections.singletonList("coleslaw"),
                new CompressedXContent(  
                        + "      }\n"
            ),  
        );
                        + "      \"properties\": {\n"
        client().execute(  
                    "{\n"
        internalCluster().fullRestart();
    }
                        + "    }"  
        ensureGreen();
            5L,
            Collections.singletonMap("egg", "bread")  
package org.opensearch.indices.template;
            Collections.singletonList("my-ct"),  
            PutComposableIndexTemplateAction.INSTANCE,
            new Template(
                        + "      }\n"
                        + "          \"type\": \"keyword\"\n"  
                        + "      \"dynamic\": false,\n"
            Collections.singletonMap("egg", "bread")
                    "{\n"
            ),
                        + "        \"foo\": {\n"
import org.opensearch.action.admin.indices.template.put.PutComposableIndexTemplateAction;
 * Licensed to Elasticsearch under one or more contributor  
        ComposableIndexTemplate cit = new ComposableIndexTemplate(
            PutComposableIndexTemplateAction.INSTANCE,  
                ),  
import org.opensearch.common.compress.CompressedXContent;  
                        + "    }"
 * not use this file except in compliance with the License.
 * under the License.  
            new Template(
 *
            new Template(
 *  
        ).get();
                        + "      }\n"
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
    // See: https://github.com/elastic/elasticsearch/issues/58643
import org.opensearch.cluster.metadata.ComposableIndexTemplate;
            ),  
import org.opensearch.action.admin.indices.template.put.PutComponentTemplateAction;
        ComponentTemplate ct2 = new ComponentTemplate(
                        + "        }\n"
                null
                        + "        \"foo\": {\n"
                new CompressedXContent(  
 * GitHub history for details.
                        + "      \"properties\": {\n"
            new Template(
                        + "          \"type\": \"keyword\"\n"
            3L,  
                    "{\n"
 * the Apache License, Version 2.0 (the "License"); you may
            new PutComposableIndexTemplateAction.Request("my-it").indexTemplate(cit)
        ComposableIndexTemplate cit2 = new ComposableIndexTemplate(  
import java.util.Collections;  
                        + "    }"
                null
import org.opensearch.test.OpenSearchIntegTestCase;
                        + "        \"foo\": {\n"
        client().execute(PutComponentTemplateAction.INSTANCE, new PutComponentTemplateAction.Request("my-ct").componentTemplate(ct)).get();  
                        + "      }\n"
 */
                        + "      \"properties\": {\n"  
 *
    public void testComponentTemplatesCanBeUpdatedAfterRestart() throws Exception {
        );
            ),
        client().execute(
                        + "          \"type\": \"integer\"\n"  
 */  
            4L,
 * license agreements. See the NOTICE file distributed with
        );
 * KIND, either express or implied.  See the License for the
                null
            4L,
            Collections.singletonList("my-ct"),
 * Unless required by applicable law or agreed to in writing,
                ),
        );  
            new PutComposableIndexTemplateAction.Request("my-it").indexTemplate(cit2)
                        + "      \"dynamic\": true,\n"  
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        ComponentTemplate ct = new ComponentTemplate(  
