 *
                    orig.metadata(),  
    }  
                    orig.template(),
        AliasMetadata aliasMeta = AliasMetadata.builder(aliasName)
import org.opensearch.common.compress.CompressedXContent;
            meta = randomMeta();
        }
        return Settings.builder()
                    randomValueOtherThan(orig.getDataStreamTemplate(), ComposableIndexTemplateTests::randomDataStreamTemplate)
                    orig.indexPatterns(),
 * Unless required by applicable law or agreed to in writing,
            return Collections.singletonMap(  
                return new ComposableIndexTemplate(
    }
    }  
    protected ComposableIndexTemplate mutateInstance(ComposableIndexTemplate orig) throws IOException {
            componentTemplates,
                    randomValueOtherThan(  
                    orig.getDataStreamTemplate()
            return null;
            }
    }
    private static Settings randomSettings() {  
            } else {  
                    orig.indexPatterns(),  
        if (randomBoolean()) {  
                return new CompressedXContent("{\"properties\":{\"" + dataStreamTemplate.getTimestampField() + "\":{\"type\":\"date\"}}}");
 * this work for additional information regarding copyright
public class ComposableIndexTemplateTests extends AbstractDiffableSerializationTestCase<ComposableIndexTemplate> {
                    randomValueOtherThan(orig.priority(), OpenSearchTestCase::randomNonNegativeLong),
                );  
    private static Map<String, AliasMetadata> randomAliases() {  
            randomBoolean() ? null : randomNonNegativeLong(),
                    newIndexPatterns,
        }  
            if (randomBoolean()) {  
                return new ComposableIndexTemplate(  
                List<String> newIndexPatterns = randomValueOtherThan(
 * license agreements. See the NOTICE file distributed with
        }
                    orig.metadata(),  
    public static ComposableIndexTemplate randomInstance() {
                    orig.version(),
                    orig.indexPatterns(),
            .put(IndexMetadata.SETTING_BLOCKS_WRITE, randomBoolean())  
            .build();
            default:
    protected ComposableIndexTemplate doParseInstance(XContentParser parser) throws IOException {
                    orig.priority(),
            case 4:
import org.opensearch.core.xcontent.XContentParser;
                return new ComposableIndexTemplate(  
                );
                    orig.getDataStreamTemplate()
 * You may obtain a copy of the License at  
        }  
 */
                    orig.composedOf(),
    }
        Map<String, Object> meta = null;  
    @Override  
    }
                settings = randomSettings();
/*  
                    orig.template(),  
        );  
            if (randomBoolean()) {  
    }  
            indexPatterns,
 * The OpenSearch Contributors require contributions made to  
                    orig.version(),  
                        () -> new Template(randomSettings(), randomMappings(orig.getDataStreamTemplate()), randomAliases())
                    orig.metadata(),
 * software distributed under the License is distributed on an
            case 5:
/*  
        List<String> indexPatterns = randomList(1, 4, () -> randomAlphaOfLength(4));
                    orig.indexPatterns(),
            return Collections.singletonMap(randomAlphaOfLength(4), randomAlphaOfLength(4));
                aliases = randomAliases();
import java.util.List;
            }
        }  
                    orig.priority(),
            template,  
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.test.OpenSearchTestCase;
        return new ComposableIndexTemplate(
    @Override  
            return mutateInstance(testInstance);  
                );
            .put(IndexMetadata.SETTING_BLOCKS_READ, randomBoolean())
                    orig.version(),
            meta,
import java.io.IOException;  
                    orig.version(),  
    protected Writeable.Reader<Diff<ComposableIndexTemplate>> diffReader() {  
                    orig.metadata(),
        } catch (IOException e) {  
 * under the License.  
            randomBoolean() ? null : randomNonNegativeLong(),  
 * the Apache License, Version 2.0 (the "License"); you may
                    ),  
 *     http://www.apache.org/licenses/LICENSE-2.0
                );
                    orig.composedOf(),  
            .build();
 */  
        return Collections.singletonMap(aliasName, aliasMeta);
        switch (randomIntBetween(0, 6)) {  
        List<String> componentTemplates = randomList(0, 10, () -> randomAlphaOfLength(5));  
                Collections.singletonMap(randomAlphaOfLength(4), randomAlphaOfLength(4))
            .filter("{\"term\":{\"year\":" + randomIntBetween(1, 3000) + "}}")  
            .put(IndexMetadata.SETTING_PRIORITY, randomIntBetween(0, 100000))
            case 0:
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomIntBetween(0, 5))
        ComposableIndexTemplate.DataStreamTemplate dataStreamTemplate = randomDataStreamTemplate();  
            return null;  
        return ComposableIndexTemplate::readITV2DiffFrom;
                    orig.template(),
                return new ComposableIndexTemplate(
        return mutateTemplate(orig);
                    orig.priority(),  
                    orig.composedOf(),
 * specific language governing permissions and limitations
                    orig.version(),
                return new ComposableIndexTemplate(
    }
                    orig.template(),
                    orig.priority(),
 * KIND, either express or implied.  See the License for the
        if (dataStreamTemplate != null || randomBoolean()) {
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
 * not use this file except in compliance with the License.
import org.opensearch.cluster.Diff;
        }  
 */  
            return new ComposableIndexTemplate.DataStreamTemplate();
                mappings = randomMappings(dataStreamTemplate);
    @Override
            template = new Template(settings, mappings, aliases);  
}
            case 6:  
        String aliasName = randomAlphaOfLength(5);
    private static CompressedXContent randomMappings(ComposableIndexTemplate.DataStreamTemplate dataStreamTemplate) {
        Map<String, AliasMetadata> aliases = null;
        Settings settings = null;
            dataStreamTemplate
        if (randomBoolean()) {
            case 3:  
        return ComposableIndexTemplate::new;
                        orig.template(),
                List<String> newComposedOf = randomValueOtherThan(orig.composedOf(), () -> randomList(0, 10, () -> randomAlphaOfLength(5)));
                throw new IllegalStateException("illegal randomization branch");
    }  
 * Modifications Copyright OpenSearch Contributors. See
                    randomValueOtherThan(orig.metadata(), ComposableIndexTemplateTests::randomMeta),  
            logger.error(e);
 *
                    orig.priority(),
package org.opensearch.cluster.metadata;
                return new ComposableIndexTemplate(  
        } else {
                    orig.version(),  
                    randomValueOtherThan(orig.version(), OpenSearchTestCase::randomNonNegativeLong),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
                    orig.getDataStreamTemplate()
    protected ComposableIndexTemplate makeTestChanges(ComposableIndexTemplate testInstance) {
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
                    () -> randomList(1, 4, () -> randomAlphaOfLength(4))
    }
    private static Map<String, Object> randomMeta() {
        if (randomBoolean()) {
        try {
        return randomInstance();
            if (dataStreamTemplate != null) {
import org.opensearch.test.AbstractDiffableSerializationTestCase;  
                );
            case 1:  
    public static ComposableIndexTemplate mutateTemplate(ComposableIndexTemplate orig) {
            .put(IndexMetadata.SETTING_BLOCKS_WRITE, randomBoolean())  
                    orig.indexPatterns(),
        Template template = null;
    @Override
            fail("mutating should not throw an exception, but got: " + e);  
                );  
/*
            return null;
            case 2:
        try {  
                    orig.indexPatterns(),  
                    newComposedOf,  
        } catch (IOException e) {
                return new ComposableIndexTemplate(
                    orig.composedOf(),
        return ComposableIndexTemplate.parse(parser);  
                    orig.getDataStreamTemplate()
            }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 10))
    }
            .routing(randomBoolean() ? null : randomAlphaOfLength(3))
        }
                    orig.composedOf(),  
                    orig.metadata(),
    private static ComposableIndexTemplate.DataStreamTemplate randomDataStreamTemplate() {
import java.util.Collections;
                return new CompressedXContent("{\"properties\":{\"" + randomAlphaOfLength(5) + "\":{\"type\":\"keyword\"}}}");
    protected Writeable.Reader<ComposableIndexTemplate> instanceReader() {
        CompressedXContent mappings = null;  
                    orig.template(),
                    orig.metadata(),
                    orig.getDataStreamTemplate()  
    @Override
    }
                );
                    orig.getDataStreamTemplate()
            fail("got an IO exception creating fake mappings: " + e);
            );  
    }  
            if (dataStreamTemplate != null || randomBoolean()) {  
        } else {
                    orig.priority(),
    protected ComposableIndexTemplate createTestInstance() {  
                    orig.indexPatterns(),
            .writeIndex(randomBoolean() ? null : randomBoolean())  
                    orig.composedOf(),
                randomAlphaOfLength(5),
 * Licensed to Elasticsearch under one or more contributor  
                    orig.template(),  
            .isHidden(randomBoolean() ? null : randomBoolean())
    @Override  
 * compatible open source license.
import org.opensearch.common.settings.Settings;  
                );  
import java.util.Map;  
            }
