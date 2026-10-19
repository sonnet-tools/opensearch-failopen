        assertThat(firstSetSection.getStash().entrySet(), hasSize(1));
                + "- do:\n"
                + "        id:     2\n"
 *  
 * not use this file except in compliance with the License.
        assertThat(secondSetSection.getStash(), hasKey("nodes.$master.http.publish_address"));
                + "      metric: [ http, transport ]\n"  
        assertThat(setupSection.getSkipSection().isEmpty(), equalTo(false));  
 * Modifications Copyright OpenSearch Contributors. See  
                + "- set: {nodes.$master.http.publish_address: host}\n"
 * license agreements. See the NOTICE file distributed with
            YamlXContent.yamlXContent,  
                + "    cluster.state: {}\n"
            YamlXContent.yamlXContent,
 */  
        assertThat(setupSection.getSkipSection(), notNullValue());
 *
                + "      index2:\n"
 * compatible open source license.
                + "      reason:   \"Update doesn't return metadata fields, waiting for #3259\"\n"  
        );  
    }
                + "        id:     2\n"
                + "  - do:\n"  
        assertThat(((DoSection) setupSection.getExecutableSections().get(0)).getApiCallSection().getApi(), equalTo("index1"));
 * SPDX-License-Identifier: Apache-2.0
        final SetupSection setupSection = SetupSection.parse(parser);
public class SetupSectionTests extends AbstractClientYamlTestFragmentParserTestCase {
        assertThat(((DoSection) setupSection.getExecutableSections().get(0)).getApiCallSection().getApi(), equalTo("cluster.state"));
                + "        index:  test_1\n"
    public void testParseSetupSection() throws Exception {  
/*
        assertThat(setupSection.getSkipSection().getUpperVersion(), equalTo(Version.fromString("6.3.0")));  
                + "      index1:\n"
        assertThat(thirdSetSection.getStash().entrySet(), hasSize(1));
            "- do:\n"
                + "        index:  test_1\n"  
        assertThat(setupSection.getExecutableSections().get(2), instanceOf(DoSection.class));
import java.io.IOException;  
        assertThat(secondSetSection.getStash().entrySet(), hasSize(1));  
        assertThat(setupSection, notNullValue());
 * Licensed to Elasticsearch under one or more contributor  
        SetupSection setupSection = SetupSection.parse(parser);
                + "        body:   { \"include\": { \"field1\": \"v1\", \"field2\": \"v2\" }, \"count\": 1 }\n"
        assertThat(((DoSection) setupSection.getExecutableSections().get(1)).getApiCallSection().getApi(), equalTo("index2"));  
import static org.hamcrest.Matchers.equalTo;
        parser = createParser(
    }
/*
        assertThat(setupSection.getSkipSection().getReason(), equalTo("Update doesn't return metadata fields, waiting for #3259"));
        final SetSection secondSetSection = (SetSection) setupSection.getExecutableSections().get(3);
 * GitHub history for details.
        assertThat(setupSection.getExecutableSections().get(0), instanceOf(DoSection.class));
 * the Apache License, Version 2.0 (the "License"); you may
        );
                + "    nodes.info:\n"
                + "        type:   test\n"  
                + "- set: {nodes.$master.transport.publish_address: transport_host}\n"
                + "        body:   { \"include\": { \"field1\": \"v1\", \"field2\": \"v2\" }, \"count\": 1 }\n"  
                + "  - do:\n"
        assertThat(setupSection.getExecutableSections().get(1), instanceOf(DoSection.class));
import static org.hamcrest.Matchers.instanceOf;
                + "        type:   test\n"  
        );  
        assertThat(setupSection.getExecutableSections().size(), equalTo(2));
import org.opensearch.Version;  
                + "      version:  \"6.0.0 - 6.3.0\"\n"
 * ownership. Elasticsearch licenses this file to you under  
    public void testParseSetSectionInSetupSection() throws IOException {
    public void testParseSetupAndSkipSectionNoSkip() throws Exception {
                + "        body:   { \"include\": { \"field1\": \"v1\", \"field2\": \"v2\" }, \"count\": 1 }\n"  
 * software distributed under the License is distributed on an
        assertThat(firstSetSection.getStash(), hasKey("master_node"));  
 * under the License.  
                + "      index1:\n"
        assertThat(((DoSection) setupSection.getExecutableSections().get(1)).getApiCallSection().getApi(), equalTo("index2"));
                + "        index:  test_1\n"
                + "        id:     1\n"
            "  - do:\n"  
        SetupSection setupSection = SetupSection.parse(parser);  
        assertThat(setupSection.getExecutableSections().get(1), instanceOf(DoSection.class));  
            YamlXContent.yamlXContent,  
        parser = createParser(
        assertThat(setupSection.getSkipSection().isEmpty(), equalTo(true));
        assertThat(setupSection.getExecutableSections().get(0), instanceOf(DoSection.class));
        assertThat(setupSection, notNullValue());
        assertThat(((DoSection) setupSection.getExecutableSections().get(2)).getApiCallSection().getApi(), equalTo("nodes.info"));  
        parser = createParser(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.xcontent.yaml.YamlXContent;
            "  - skip:\n"
        assertThat(setupSection.getExecutableSections().get(4), instanceOf(SetSection.class));  
import static org.hamcrest.Matchers.hasKey;  
 * this file be licensed under the Apache-2.0 license or a
        assertThat(firstSetSection.getStash().get("master_node"), equalTo("master"));
import static org.hamcrest.Matchers.hasSize;
        assertThat(thirdSetSection.getStash().get("nodes.$master.transport.publish_address"), equalTo("transport_host"));
 * this work for additional information regarding copyright
}
 * You may obtain a copy of the License at  
        final SetSection firstSetSection = (SetSection) setupSection.getExecutableSections().get(1);
        assertThat(secondSetSection.getStash().get("nodes.$master.http.publish_address"), equalTo("host"));
                + "        index:  test_1\n"  
 * KIND, either express or implied.  See the License for the
                + "        type:   test\n"
        assertThat(setupSection.getSkipSection().getLowerVersion(), equalTo(Version.fromString("6.0.0")));
 */
                + "- set: { master_node: master }\n"  
 * specific language governing permissions and limitations
    }
                + "        type:   test\n"
        assertThat(setupSection.getExecutableSections().size(), equalTo(5));  
        assertNotNull(setupSection);
        assertThat(setupSection.getExecutableSections().size(), equalTo(2));  
        assertThat(((DoSection) setupSection.getExecutableSections().get(0)).getApiCallSection().getApi(), equalTo("index1"));
 *
        assertThat(setupSection.getExecutableSections().get(0), instanceOf(DoSection.class));  
import static org.hamcrest.Matchers.notNullValue;  
        assertThat(setupSection.getExecutableSections().get(3), instanceOf(SetSection.class));
 * The OpenSearch Contributors require contributions made to  
                + "  - do:\n"
        assertThat(setupSection.getExecutableSections().get(1), instanceOf(SetSection.class));  
package org.opensearch.test.rest.yaml.section;
 */
/*  
                + "        body:   { \"include\": { \"field1\": \"v1\", \"field2\": \"v2\" }, \"count\": 1 }\n"
        assertTrue(setupSection.getSkipSection().isEmpty());
        assertThat(thirdSetSection.getStash(), hasKey("nodes.$master.transport.publish_address"));  
                + "      index2:\n"
 * Unless required by applicable law or agreed to in writing,
        final SetSection thirdSetSection = (SetSection) setupSection.getExecutableSections().get(4);
                + "        id:     1\n"
 *     http://www.apache.org/licenses/LICENSE-2.0
