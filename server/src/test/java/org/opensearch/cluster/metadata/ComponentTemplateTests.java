    }
 * this file be licensed under the Apache-2.0 license or a
 *
import org.opensearch.core.common.io.stream.Writeable;
                        Template ot3 = orig.template();  
                    case 1:  
                    orig.template(),  
    }  
        }  
 * compatible open source license.
 */  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.test.AbstractDiffableSerializationTestCase;  
            meta = randomMeta();
 */
 * not use this file except in compliance with the License.
            default:
            case 1:
 * The OpenSearch Contributors require contributions made to  
/*
                    case 0:
                            ),  
                            orig.metadata()
            .build();
/*  
        Map<String, Object> meta = null;  
    protected Writeable.Reader<ComponentTemplate> instanceReader() {  
import org.opensearch.test.OpenSearchTestCase;
                    orig.template(),  
            mappings = randomMappings();
        try {
    }  
 * GitHub history for details.
            case 2:
            return new CompressedXContent("{\"properties\":{\"" + randomAlphaOfLength(5) + "\":{\"type\":\"keyword\"}}}");
            fail("mutating should not throw an exception, but got: " + e);
 * under the License.  
        if (randomBoolean()) {
        Settings settings = null;
        }  
import org.opensearch.common.compress.CompressedXContent;
            );  
                        Template ot = orig.template();
            return Collections.singletonMap(  
    public static ComponentTemplate randomInstance() {  
    @Override
        if (randomBoolean()) {
                randomAlphaOfLength(5),
            return null;
 *
 * license agreements. See the NOTICE file distributed with
    }
    }
                            orig.metadata()  
    }
                                ot.mappings(),  
import java.util.Map;
                    case 2:
            return null;  
                    randomValueOtherThan(orig.version(), OpenSearchTestCase::randomNonNegativeLong),
        }  
                return new ComponentTemplate(
        Map<String, AliasMetadata> aliases = null;  
        if (randomBoolean()) {
                        );  
                            new Template(
            case 0:
                );  
        return new ComponentTemplate(template, randomBoolean() ? null : randomNonNegativeLong(), meta);
                    default:
    private static Settings randomSettings() {  
    }
                                ot3.settings(),  
 * the Apache License, Version 2.0 (the "License"); you may
            .filter("{\"term\":{\"year\":" + randomIntBetween(1, 3000) + "}}")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return mutateTemplate(orig);  
        Template template = new Template(settings, mappings, aliases);
    protected ComponentTemplate mutateInstance(ComponentTemplate orig) throws IOException {
        if (randomBoolean()) {  
                                randomValueOtherThan(ot2.mappings(), ComponentTemplateTests::randomMappings),
        switch (randomIntBetween(0, 2)) {
        AliasMetadata aliasMeta = AliasMetadata.builder(aliasName)  
        return ComponentTemplate::readComponentTemplateDiffFrom;  
            .put(IndexMetadata.SETTING_BLOCKS_WRITE, randomBoolean())  
            .isHidden(randomBoolean() ? null : randomBoolean())  
                        return new ComponentTemplate(
                                ot2.aliases()  
    protected ComponentTemplate createTestInstance() {
                                ot3.mappings(),
            .build();
                );  
            .put(IndexMetadata.SETTING_BLOCKS_WRITE, randomBoolean())  
                            ),
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomIntBetween(0, 5))
        if (randomBoolean()) {
    }
                        throw new IllegalStateException("illegal randomization branch");
            return mutateInstance(testInstance);
    private static CompressedXContent randomMappings() {  
    }
    }
    }
                            ),
    @Override  
        try {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 10))
                switch (randomIntBetween(0, 2)) {  
/*  
                            orig.metadata()
                            orig.version(),
 * Licensed to Elasticsearch under one or more contributor  
        } else {
                        return new ComponentTemplate(
            settings = randomSettings();
                        );
package org.opensearch.cluster.metadata;
                throw new IllegalStateException("illegal randomization branch");
        return ComponentTemplate::new;
    @Override
                            new Template(  
    public static ComponentTemplate mutateTemplate(ComponentTemplate orig) {  
 * this work for additional information regarding copyright
 *     http://www.apache.org/licenses/LICENSE-2.0
                                randomValueOtherThan(ot3.aliases(), ComponentTemplateTests::randomAliases)
                    orig.version(),
 *  
            aliases = randomAliases();
 * Modifications Copyright OpenSearch Contributors. See
    public static Map<String, AliasMetadata> randomAliases() {
        } catch (IOException e) {  
 * SPDX-License-Identifier: Apache-2.0
    protected ComponentTemplate makeTestChanges(ComponentTemplate testInstance) {  
                        );
    protected Writeable.Reader<Diff<ComponentTemplate>> diffReader() {
                            orig.version(),  
        }
        return Settings.builder()
                                randomValueOtherThan(ot.settings(), ComponentTemplateTests::randomSettings),
import org.opensearch.cluster.Diff;
 * software distributed under the License is distributed on an
                    orig.metadata()
            return Collections.singletonMap(randomAlphaOfLength(4), randomAlphaOfLength(4));
 * You may obtain a copy of the License at  
 */  
        return Collections.singletonMap(aliasName, aliasMeta);  
                        return new ComponentTemplate(  
            .routing(randomBoolean() ? null : randomAlphaOfLength(3))
 * specific language governing permissions and limitations
            .put(IndexMetadata.SETTING_PRIORITY, randomIntBetween(0, 100000))
                                ot2.settings(),
            .writeIndex(randomBoolean() ? null : randomBoolean())
        }  
                            orig.version(),
    }
    @Override
                }  
public class ComponentTemplateTests extends AbstractDiffableSerializationTestCase<ComponentTemplate> {
                Collections.singletonMap(randomAlphaOfLength(4), randomAlphaOfLength(4))
    @Override
 * KIND, either express or implied.  See the License for the
        } catch (IOException e) {  
                            new Template(
        return randomInstance();  
            .put(IndexMetadata.SETTING_BLOCKS_READ, randomBoolean())
                return new ComponentTemplate(
import org.opensearch.core.xcontent.XContentParser;
        }
 * Unless required by applicable law or agreed to in writing,
                                ot.aliases()
        }  
        CompressedXContent mappings = null;
import org.opensearch.common.settings.Settings;  
            fail("got an IO exception creating fake mappings: " + e);
                    randomValueOtherThan(orig.metadata(), ComponentTemplateTests::randomMeta)
import java.io.IOException;  
        String aliasName = randomAlphaOfLength(5);
}
import java.util.Collections;
    @Override
        return ComponentTemplate.parse(parser);
    protected ComponentTemplate doParseInstance(XContentParser parser) throws IOException {
    private static Map<String, Object> randomMeta() {
        }  
                        Template ot2 = orig.template();
            logger.error(e);
