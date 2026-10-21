 *
 */
                settings = randomSettings();
    @Override
        Settings settings = null;
                    randomValueOtherThan(orig.getDataStreamTemplate(), ComposableIndexTemplateTests::randomDataStreamTemplate)
                    orig.version(),
            .filter("{\"term\":{\"year\":" + randomIntBetween(1, 3000) + "}}")
        try {
                return new ComposableIndexTemplate(
                mappings = randomMappings(dataStreamTemplate);
                    orig.template(),
import org.opensearch.core.common.io.stream.Writeable;
        if (dataStreamTemplate != null || randomBoolean()) {
        } catch (IOException e) {
            logger.error(e);
                    orig.metadata(),
                return new ComposableIndexTemplate(
        Template template = null;
import org.opensearch.common.settings.Settings;
                    orig.indexPatterns(),
    }
            .put(IndexMetadata.SETTING_BLOCKS_WRITE, randomBoolean())
                    orig.version(),
    public static ComposableIndexTemplate mutateTemplate(ComposableIndexTemplate orig) {
                    orig.indexPatterns(),
        return new ComposableIndexTemplate(
                    randomValueOtherThan(orig.version(), OpenSearchTestCase::randomNonNegativeLong),
                throw new IllegalStateException("illegal randomization branch");
    }
                    orig.template(),
    @Override
        String aliasName = randomAlphaOfLength(5);
                    () -> randomList(1, 4, () -> randomAlphaOfLength(4))
            } else {
            .isHidden(randomBoolean() ? null : randomBoolean())
    }
                    orig.priority(),
    }
        } else {
 * Unless required by applicable law or agreed to in writing,
    private static CompressedXContent randomMappings(ComposableIndexTemplate.DataStreamTemplate dataStreamTemplate) {
    private static Map<String, AliasMetadata> randomAliases() {
            case 0:
        Map<String, Object> meta = null;
    }
        if (randomBoolean()) {
                    orig.getDataStreamTemplate()
                    randomValueOtherThan(orig.priority(), OpenSearchTestCase::randomNonNegativeLong),
            }
 * You may obtain a copy of the License at
            }
                    orig.getDataStreamTemplate()
    @Override
 * not use this file except in compliance with the License.
        return mutateTemplate(orig);
        try {
import org.opensearch.cluster.Diff;
            if (dataStreamTemplate != null || randomBoolean()) {
                return new CompressedXContent("{\"properties\":{\"" + dataStreamTemplate.getTimestampField() + "\":{\"type\":\"date\"}}}");
                    orig.priority(),
        return Settings.builder()
 * GitHub history for details.
        List<String> componentTemplates = randomList(0, 10, () -> randomAlphaOfLength(5));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    @Override
            );
            randomBoolean() ? null : randomNonNegativeLong(),
            if (randomBoolean()) {
                        () -> new Template(randomSettings(), randomMappings(orig.getDataStreamTemplate()), randomAliases())
                    orig.priority(),
    protected ComposableIndexTemplate makeTestChanges(ComposableIndexTemplate testInstance) {
 * The OpenSearch Contributors require contributions made to
 * compatible open source license.
        switch (randomIntBetween(0, 6)) {
            .put(IndexMetadata.SETTING_BLOCKS_READ, randomBoolean())
                    orig.composedOf(),
        return ComposableIndexTemplate.parse(parser);
public class ComposableIndexTemplateTests extends AbstractDiffableSerializationTestCase<ComposableIndexTemplate> {
    }
                    orig.composedOf(),
                    orig.getDataStreamTemplate()
                    orig.version(),
            .build();
            template,
            return Collections.singletonMap(
                    orig.indexPatterns(),
 *
                    orig.getDataStreamTemplate()
            case 6:
            }
            template = new Template(settings, mappings, aliases);
 * Modifications Copyright OpenSearch Contributors. See
                return new CompressedXContent("{\"properties\":{\"" + randomAlphaOfLength(5) + "\":{\"type\":\"keyword\"}}}");
 * ownership. Elasticsearch licenses this file to you under
import java.util.Map;
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
                return new ComposableIndexTemplate(
    protected Writeable.Reader<Diff<ComposableIndexTemplate>> diffReader() {
                );
/*
        }
        } catch (IOException e) {
                );
                    orig.version(),
                    newComposedOf,
        if (randomBoolean()) {
                );
    }
    private static Settings randomSettings() {
import org.opensearch.test.AbstractDiffableSerializationTestCase;
        }
    }
}
    }
package org.opensearch.cluster.metadata;
 * SPDX-License-Identifier: Apache-2.0
    protected ComposableIndexTemplate createTestInstance() {
                    newIndexPatterns,
            default:
            return null;
        } else {
            fail("mutating should not throw an exception, but got: " + e);
 * software distributed under the License is distributed on an
    }
            meta,
                    orig.indexPatterns(),
            case 1:
                return new ComposableIndexTemplate(
                    orig.template(),
        return ComposableIndexTemplate::new;
            indexPatterns,
            return new ComposableIndexTemplate.DataStreamTemplate();
        }
        AliasMetadata aliasMeta = AliasMetadata.builder(aliasName)
 * license agreements. See the NOTICE file distributed with
        }
        return randomInstance();
                    orig.template(),
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 10))
import java.io.IOException;
                    orig.composedOf(),
                    orig.getDataStreamTemplate()
                List<String> newComposedOf = randomValueOtherThan(orig.composedOf(), () -> randomList(0, 10, () -> randomAlphaOfLength(5)));
                List<String> newIndexPatterns = randomValueOtherThan(
 * specific language governing permissions and limitations
            randomBoolean() ? null : randomNonNegativeLong(),
 *
    protected ComposableIndexTemplate doParseInstance(XContentParser parser) throws IOException {
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.common.compress.CompressedXContent;
                );
            return null;
                    orig.priority(),
        }
                    orig.indexPatterns(),
                    orig.priority(),
                aliases = randomAliases();
                    randomValueOtherThan(
                    orig.indexPatterns(),
                    orig.composedOf(),
                return new ComposableIndexTemplate(
        CompressedXContent mappings = null;
                    orig.metadata(),
                    orig.version(),
                    randomValueOtherThan(orig.metadata(), ComposableIndexTemplateTests::randomMeta),
                );
            .writeIndex(randomBoolean() ? null : randomBoolean())
 */
            case 5:
                    orig.composedOf(),
            .routing(randomBoolean() ? null : randomAlphaOfLength(3))
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomIntBetween(0, 5))
                    orig.metadata(),
                    orig.template(),
 */
 * this work for additional information regarding copyright
                );
                );
        }
    }
                    orig.getDataStreamTemplate()
            .put(IndexMetadata.SETTING_PRIORITY, randomIntBetween(0, 100000))
                    ),
 * under the License.
                return new ComposableIndexTemplate(
 * the Apache License, Version 2.0 (the "License"); you may
    protected Writeable.Reader<ComposableIndexTemplate> instanceReader() {
    private static ComposableIndexTemplate.DataStreamTemplate randomDataStreamTemplate() {
        Map<String, AliasMetadata> aliases = null;
                    orig.template(),
        }
            case 3:
            .build();
                randomAlphaOfLength(5),
 * KIND, either express or implied.  See the License for the
    }
                );
        List<String> indexPatterns = randomList(1, 4, () -> randomAlphaOfLength(4));
                return new ComposableIndexTemplate(
 * this file be licensed under the Apache-2.0 license or a
                    orig.composedOf(),
        return Collections.singletonMap(aliasName, aliasMeta);
import org.opensearch.core.xcontent.XContentParser;
            if (dataStreamTemplate != null) {
                Collections.singletonMap(randomAlphaOfLength(4), randomAlphaOfLength(4))
            case 4:
                    orig.indexPatterns(),
    @Override
        return ComposableIndexTemplate::readITV2DiffFrom;
    protected ComposableIndexTemplate mutateInstance(ComposableIndexTemplate orig) throws IOException {
            if (randomBoolean()) {
            case 2:
    @Override
                        orig.template(),
            return mutateInstance(testInstance);
import org.opensearch.test.OpenSearchTestCase;
    private static Map<String, Object> randomMeta() {
            return null;
            componentTemplates,
        ComposableIndexTemplate.DataStreamTemplate dataStreamTemplate = randomDataStreamTemplate();
        );
            }
                    orig.metadata(),
    }
                    orig.metadata(),
import java.util.List;
            return Collections.singletonMap(randomAlphaOfLength(4), randomAlphaOfLength(4));
            dataStreamTemplate
/*
import java.util.Collections;
                    orig.metadata(),
                    orig.priority(),
        if (randomBoolean()) {
                    orig.version(),
            fail("got an IO exception creating fake mappings: " + e);
            .put(IndexMetadata.SETTING_BLOCKS_WRITE, randomBoolean())
    public static ComposableIndexTemplate randomInstance() {
            meta = randomMeta();
