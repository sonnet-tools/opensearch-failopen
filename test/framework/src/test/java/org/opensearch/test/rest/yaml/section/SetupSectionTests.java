/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * under the License.
 * license agreements. See the NOTICE file distributed with
package org.opensearch.test.rest.yaml.section;
                + "        type:   test\n"
import static org.hamcrest.Matchers.instanceOf;
        assertThat(setupSection.getExecutableSections().size(), equalTo(2));
        assertThat(setupSection.getExecutableSections().get(0), instanceOf(DoSection.class));
        SetupSection setupSection = SetupSection.parse(parser);
        final SetSection thirdSetSection = (SetSection) setupSection.getExecutableSections().get(4);
public class SetupSectionTests extends AbstractClientYamlTestFragmentParserTestCase {
                + "        id:     2\n"
 *     http://www.apache.org/licenses/LICENSE-2.0
                + "        id:     1\n"
        assertThat(((DoSection) setupSection.getExecutableSections().get(2)).getApiCallSection().getApi(), equalTo("nodes.info"));
        assertThat(setupSection.getSkipSection().getReason(), equalTo("Update doesn't return metadata fields, waiting for #3259"));
 * Licensed to Elasticsearch under one or more contributor
        assertThat(setupSection.getSkipSection().getUpperVersion(), equalTo(Version.fromString("6.3.0")));
    }
        assertThat(setupSection.getExecutableSections().get(2), instanceOf(DoSection.class));
                + "      index1:\n"
        assertThat(thirdSetSection.getStash(), hasKey("nodes.$master.transport.publish_address"));
        assertThat(setupSection.getExecutableSections().get(1), instanceOf(DoSection.class));
        assertThat(secondSetSection.getStash().get("nodes.$master.http.publish_address"), equalTo("host"));
 * this work for additional information regarding copyright
            "  - skip:\n"
        assertThat(setupSection.getSkipSection(), notNullValue());
        assertTrue(setupSection.getSkipSection().isEmpty());
                + "- set: {nodes.$master.transport.publish_address: transport_host}\n"
/*
                + "        index:  test_1\n"
        assertThat(setupSection.getExecutableSections().get(0), instanceOf(DoSection.class));
        final SetSection secondSetSection = (SetSection) setupSection.getExecutableSections().get(3);
 * Unless required by applicable law or agreed to in writing,
            "  - do:\n"
            YamlXContent.yamlXContent,
        assertThat(setupSection.getSkipSection().getLowerVersion(), equalTo(Version.fromString("6.0.0")));
        assertThat(thirdSetSection.getStash().get("nodes.$master.transport.publish_address"), equalTo("transport_host"));
                + "        body:   { \"include\": { \"field1\": \"v1\", \"field2\": \"v2\" }, \"count\": 1 }\n"
        assertThat(setupSection.getExecutableSections().get(3), instanceOf(SetSection.class));
 */
        assertThat(setupSection.getSkipSection().isEmpty(), equalTo(true));
 * KIND, either express or implied.  See the License for the
        assertThat(((DoSection) setupSection.getExecutableSections().get(0)).getApiCallSection().getApi(), equalTo("index1"));
                + "        id:     2\n"
 * SPDX-License-Identifier: Apache-2.0
                + "- set: { master_node: master }\n"
                + "    nodes.info:\n"
 * this file be licensed under the Apache-2.0 license or a
        assertThat(((DoSection) setupSection.getExecutableSections().get(1)).getApiCallSection().getApi(), equalTo("index2"));
        assertThat(secondSetSection.getStash(), hasKey("nodes.$master.http.publish_address"));
                + "  - do:\n"
 * You may obtain a copy of the License at
                + "        body:   { \"include\": { \"field1\": \"v1\", \"field2\": \"v2\" }, \"count\": 1 }\n"
        assertThat(((DoSection) setupSection.getExecutableSections().get(0)).getApiCallSection().getApi(), equalTo("cluster.state"));
                + "        type:   test\n"
        parser = createParser(
 * GitHub history for details.
        parser = createParser(
 * software distributed under the License is distributed on an
                + "- set: {nodes.$master.http.publish_address: host}\n"
 */
        assertThat(secondSetSection.getStash().entrySet(), hasSize(1));
                + "- do:\n"
 * not use this file except in compliance with the License.
                + "        index:  test_1\n"
import static org.hamcrest.Matchers.equalTo;
                + "  - do:\n"
        assertThat(setupSection.getExecutableSections().get(1), instanceOf(SetSection.class));
                + "        body:   { \"include\": { \"field1\": \"v1\", \"field2\": \"v2\" }, \"count\": 1 }\n"
                + "      index2:\n"
        parser = createParser(
        assertThat(firstSetSection.getStash().get("master_node"), equalTo("master"));
 *
                + "        index:  test_1\n"
                + "        index:  test_1\n"
 *
        );
            YamlXContent.yamlXContent,
        assertThat(setupSection, notNullValue());
                + "        type:   test\n"
 *
}
        assertThat(setupSection, notNullValue());
    }
        assertThat(setupSection.getExecutableSections().size(), equalTo(2));
        assertThat(((DoSection) setupSection.getExecutableSections().get(0)).getApiCallSection().getApi(), equalTo("index1"));
        assertThat(firstSetSection.getStash().entrySet(), hasSize(1));
        assertThat(setupSection.getExecutableSections().get(0), instanceOf(DoSection.class));
import org.opensearch.Version;
import static org.hamcrest.Matchers.hasKey;
        );
                + "        id:     1\n"
                + "  - do:\n"
                + "      version:  \"6.0.0 - 6.3.0\"\n"
        assertThat(firstSetSection.getStash(), hasKey("master_node"));
                + "      index1:\n"
                + "      metric: [ http, transport ]\n"
                + "    cluster.state: {}\n"
import static org.hamcrest.Matchers.hasSize;
 * ownership. Elasticsearch licenses this file to you under
    public void testParseSetSectionInSetupSection() throws IOException {
    public void testParseSetupAndSkipSectionNoSkip() throws Exception {
 * The OpenSearch Contributors require contributions made to
        assertThat(setupSection.getExecutableSections().get(4), instanceOf(SetSection.class));
import static org.hamcrest.Matchers.notNullValue;
 * specific language governing permissions and limitations
                + "        body:   { \"include\": { \"field1\": \"v1\", \"field2\": \"v2\" }, \"count\": 1 }\n"
/*
        SetupSection setupSection = SetupSection.parse(parser);
        assertThat(setupSection.getSkipSection().isEmpty(), equalTo(false));
 */
 * the Apache License, Version 2.0 (the "License"); you may
                + "        type:   test\n"
                + "      reason:   \"Update doesn't return metadata fields, waiting for #3259\"\n"
        final SetupSection setupSection = SetupSection.parse(parser);
            YamlXContent.yamlXContent,
        assertThat(setupSection.getExecutableSections().get(1), instanceOf(DoSection.class));
        assertThat(thirdSetSection.getStash().entrySet(), hasSize(1));
        assertThat(setupSection.getExecutableSections().size(), equalTo(5));
        );
    }
import java.io.IOException;
        assertNotNull(setupSection);
        final SetSection firstSetSection = (SetSection) setupSection.getExecutableSections().get(1);
    public void testParseSetupSection() throws Exception {
                + "      index2:\n"
 * compatible open source license.
            "- do:\n"
        assertThat(((DoSection) setupSection.getExecutableSections().get(1)).getApiCallSection().getApi(), equalTo("index2"));
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.xcontent.yaml.YamlXContent;
