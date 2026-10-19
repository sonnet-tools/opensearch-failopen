            }
 *
import java.util.stream.IntStream;
    }
    protected GetIndexTemplatesResponse createTestInstance() {
        return new GetIndexTemplatesResponse(templates);  
 * The OpenSearch Contributors require contributions made to  
                    templateBuilder.putMapping("doc", "{\"properties\":{\"type\":\"text\"}}");
        List<IndexTemplateMetadata> templates = new ArrayList<>();  
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
import org.opensearch.test.AbstractWireSerializingTestCase;
 * under the License.  
            if (randomBoolean()) {  
import java.io.UncheckedIOException;
 */
                templateBuilder.settings(Settings.builder().put("index.setting-1", randomLong()));
            IndexTemplateMetadata.Builder templateBuilder = IndexTemplateMetadata.builder("template-" + t);  
 * ownership. Elasticsearch licenses this file to you under  
    protected void assertEqualInstances(GetIndexTemplatesResponse expectedInstance, GetIndexTemplatesResponse newInstance) {  
        return GetIndexTemplatesResponse::new;
    }  
            }
            if (randomBoolean()) {  
import static org.hamcrest.Matchers.equalTo;  
import org.opensearch.common.settings.Settings;  
 * SPDX-License-Identifier: Apache-2.0
    protected Writeable.Reader<GetIndexTemplatesResponse> instanceReader() {
    @Override
 * You may obtain a copy of the License at  
                    throw new UncheckedIOException(ex);
 * Licensed to Elasticsearch under one or more contributor  
import java.io.IOException;
            }
 * GitHub history for details.
 *  
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
                try {
            int numAlias = between(0, 5);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.action.admin.indices.template.get;
            for (int i = 0; i < numAlias; i++) {  
    }  
            if (randomBoolean()) {  
/*  
            }  
            templateBuilder.patterns(IntStream.range(0, between(1, 5)).mapToObj(i -> "pattern-" + i).collect(Collectors.toList()));
/*
                }
 *
 * software distributed under the License is distributed on an
                templateBuilder.version(between(0, 100));
    @Override
import org.opensearch.cluster.metadata.AliasMetadata;
import java.util.List;
 */  
 * the Apache License, Version 2.0 (the "License"); you may
public class GetIndexTemplatesResponseTests extends AbstractWireSerializingTestCase<GetIndexTemplatesResponse> {
                } catch (IOException ex) {  
                templateBuilder.putAlias(AliasMetadata.builder(randomAlphaOfLengthBetween(1, 10)));
                templateBuilder.order(randomInt());
    @Override  
/*  
            if (randomBoolean()) {  
 */  
        for (int t = 0; t < numTemplates; t++) {
            templates.add(templateBuilder.build());
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.Writeable;
        }
        int numTemplates = between(0, 10);
import java.util.HashSet;
 * specific language governing permissions and limitations
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
 * Unless required by applicable law or agreed to in writing,
        assertThat(new HashSet<>(newInstance.getIndexTemplates()), equalTo(new HashSet<>(expectedInstance.getIndexTemplates())));
 * KIND, either express or implied.  See the License for the
        assertNotSame(newInstance, expectedInstance);
import java.util.stream.Collectors;  
}
            }
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.ArrayList;  
