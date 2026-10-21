                    orig.template(),
 * SPDX-License-Identifier: Apache-2.0
    @Override
}
                                ot3.mappings(),
        if (randomBoolean()) {
        if (randomBoolean()) {
                    orig.metadata()
        }
 * license agreements. See the NOTICE file distributed with
    protected ComponentTemplate doParseInstance(XContentParser parser) throws IOException {
        Map<String, Object> meta = null;
    public static ComponentTemplate randomInstance() {
            logger.error(e);
    }
    }
                        );
            case 1:
            case 0:
 * this file be licensed under the Apache-2.0 license or a
            meta = randomMeta();
            .routing(randomBoolean() ? null : randomAlphaOfLength(3))
package org.opensearch.cluster.metadata;
                                randomValueOtherThan(ot.settings(), ComponentTemplateTests::randomSettings),
            .isHidden(randomBoolean() ? null : randomBoolean())
        if (randomBoolean()) {
            );
            .filter("{\"term\":{\"year\":" + randomIntBetween(1, 3000) + "}}")
 * ownership. Elasticsearch licenses this file to you under
/*
                        );
        }
    private static CompressedXContent randomMappings() {
    protected ComponentTemplate mutateInstance(ComponentTemplate orig) throws IOException {
        try {
            case 2:
import java.io.IOException;
            return Collections.singletonMap(
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomIntBetween(0, 5))
                            new Template(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        try {
            .put(IndexMetadata.SETTING_BLOCKS_WRITE, randomBoolean())
                                randomValueOtherThan(ot2.mappings(), ComponentTemplateTests::randomMappings),
        }
            .build();
 *
                            orig.version(),
                            orig.metadata()
                throw new IllegalStateException("illegal randomization branch");
                }
                        Template ot3 = orig.template();
 */
                        Template ot = orig.template();
                        Template ot2 = orig.template();
    public static ComponentTemplate mutateTemplate(ComponentTemplate orig) {
 */
    }
        if (randomBoolean()) {
public class ComponentTemplateTests extends AbstractDiffableSerializationTestCase<ComponentTemplate> {
    @Override
            return new CompressedXContent("{\"properties\":{\"" + randomAlphaOfLength(5) + "\":{\"type\":\"keyword\"}}}");
        } else {
 * The OpenSearch Contributors require contributions made to
                );
 * GitHub history for details.
 *
        switch (randomIntBetween(0, 2)) {
                                ot.mappings(),
 */
                            ),
        return Collections.singletonMap(aliasName, aliasMeta);
                    randomValueOtherThan(orig.version(), OpenSearchTestCase::randomNonNegativeLong),
        return randomInstance();
        CompressedXContent mappings = null;
            aliases = randomAliases();
                    orig.version(),
            .put(IndexMetadata.SETTING_BLOCKS_READ, randomBoolean())
        }
        Template template = new Template(settings, mappings, aliases);
import org.opensearch.core.xcontent.XContentParser;
        Settings settings = null;
    protected ComponentTemplate createTestInstance() {
 * Licensed to Elasticsearch under one or more contributor
    }
    @Override
 * this work for additional information regarding copyright
                                ot3.settings(),
                                ot2.aliases()
        if (randomBoolean()) {
    protected Writeable.Reader<Diff<ComponentTemplate>> diffReader() {
                            new Template(
                        throw new IllegalStateException("illegal randomization branch");
    }
    protected ComponentTemplate makeTestChanges(ComponentTemplate testInstance) {
                        );
 * under the License.
        String aliasName = randomAlphaOfLength(5);
            return mutateInstance(testInstance);
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
                randomAlphaOfLength(5),
                    randomValueOtherThan(orig.metadata(), ComponentTemplateTests::randomMeta)
    @Override
                            orig.metadata()
                                randomValueOtherThan(ot3.aliases(), ComponentTemplateTests::randomAliases)
            return null;
import org.opensearch.core.common.io.stream.Writeable;
            fail("got an IO exception creating fake mappings: " + e);
    public static Map<String, AliasMetadata> randomAliases() {
        AliasMetadata aliasMeta = AliasMetadata.builder(aliasName)
            fail("mutating should not throw an exception, but got: " + e);
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Override
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Collections;
        return Settings.builder()
        }
                            orig.version(),
    }
    }
import java.util.Map;
 *
            return Collections.singletonMap(randomAlphaOfLength(4), randomAlphaOfLength(4));
                    case 1:
                    orig.template(),
    }
                );
                    case 0:
    }
            .put(IndexMetadata.SETTING_PRIORITY, randomIntBetween(0, 100000))
    protected Writeable.Reader<ComponentTemplate> instanceReader() {
import org.opensearch.common.compress.CompressedXContent;
                                ot.aliases()
            .build();
 * compatible open source license.
                        return new ComponentTemplate(
    private static Settings randomSettings() {
                                ot2.settings(),
                return new ComponentTemplate(
        }
        } catch (IOException e) {
                            orig.metadata()
        return mutateTemplate(orig);
            .put(IndexMetadata.SETTING_BLOCKS_WRITE, randomBoolean())
    }
            default:
import org.opensearch.test.AbstractDiffableSerializationTestCase;
 * not use this file except in compliance with the License.
                    case 2:
        return new ComponentTemplate(template, randomBoolean() ? null : randomNonNegativeLong(), meta);
        return ComponentTemplate::readComponentTemplateDiffFrom;
        }
                Collections.singletonMap(randomAlphaOfLength(4), randomAlphaOfLength(4))
        Map<String, AliasMetadata> aliases = null;
                            new Template(
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.OpenSearchTestCase;
 * You may obtain a copy of the License at
/*
    private static Map<String, Object> randomMeta() {
        return ComponentTemplate::new;
                return new ComponentTemplate(
/*
import org.opensearch.common.settings.Settings;
                            ),
 * the Apache License, Version 2.0 (the "License"); you may
        }
                            orig.version(),
    @Override
            settings = randomSettings();
        } catch (IOException e) {
        return ComponentTemplate.parse(parser);
                        return new ComponentTemplate(
            .writeIndex(randomBoolean() ? null : randomBoolean())
                            ),
                        return new ComponentTemplate(
            mappings = randomMappings();
import org.opensearch.cluster.Diff;
    }
            return null;
                    default:
                switch (randomIntBetween(0, 2)) {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 10))
