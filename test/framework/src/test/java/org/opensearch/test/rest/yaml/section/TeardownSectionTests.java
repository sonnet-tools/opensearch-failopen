        );  
        assertThat(((DoSection) section.getDoSections().get(0)).getApiCallSection().getApi(), equalTo("delete"));  
            "  - do:\n"
        TeardownSection section = TeardownSection.parse(parser);
 * license agreements. See the NOTICE file distributed with
                + "      reason:   \"there is a reason\"\n"
 * this work for additional information regarding copyright
import static org.hamcrest.Matchers.notNullValue;
                + "        ignore: 404\n"
 * SPDX-License-Identifier: Apache-2.0
    public void testParseTeardownSection() throws Exception {
 *  
public class TeardownSectionTests extends AbstractClientYamlTestFragmentParserTestCase {
                + "        ignore: 404"
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(section.getSkipSection().getUpperVersion(), equalTo(Version.V_2_3_0));  
                + "  - do:\n"
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(section, notNullValue());  
 * The OpenSearch Contributors require contributions made to  
                + "      version:  \"2.0.0 - 2.3.0\"\n"
import org.opensearch.common.xcontent.yaml.YamlXContent;
 */
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(((DoSection) section.getDoSections().get(1)).getApiCallSection().getApi(), equalTo("delete2"));  
 * software distributed under the License is distributed on an
 */  
                + "      delete2:\n"  
        assertThat(section.getSkipSection().getLowerVersion(), equalTo(Version.V_2_0_0));
import org.opensearch.Version;
        parser = createParser(
                + "        type: doc\n"
 * not use this file except in compliance with the License.
/*  
                + "        index: foo\n"
                + "        type: doc\n"
 */  
        assertThat(section.getDoSections().size(), equalTo(2));
/*  
                + "        id: 1\n"  
                + "        index: foo\n"
                + "        index: foo\n"
        parser = createParser(  
    public void testParseWithSkip() throws Exception {  
        assertThat(section.getSkipSection().isEmpty(), equalTo(true));  
        assertThat(section.getSkipSection().getReason(), equalTo("there is a reason"));
        assertThat(((DoSection) section.getDoSections().get(1)).getApiCallSection().getApi(), equalTo("delete2"));
                + "        ignore: 404"
    }
            YamlXContent.yamlXContent,
 *     http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.Matchers.equalTo;
/**
                + "        index: foo\n"
 */  
            "  - skip:\n"  
                + "        type: doc\n"  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.test.rest.yaml.section;
            YamlXContent.yamlXContent,
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
                + "        id: 1\n"
 *
/*
        );
 * Unit tests for the teardown section.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(section.getSkipSection().isEmpty(), equalTo(false));
                + "        id: 1\n"  
 * specific language governing permissions and limitations
    }
                + "      delete:\n"  
                + "      delete:\n"
                + "        id: 1\n"
                + "  - do:\n"  
        assertThat(section.getDoSections().size(), equalTo(2));
 * Modifications Copyright OpenSearch Contributors. See
 *
        assertThat(section, notNullValue());
 * compatible open source license.
        assertThat(((DoSection) section.getDoSections().get(0)).getApiCallSection().getApi(), equalTo("delete"));
 * Unless required by applicable law or agreed to in writing,
                + "      delete2:\n"
                + "        type: doc\n"  
        TeardownSection section = TeardownSection.parse(parser);
 * GitHub history for details.
                + "        ignore: 404\n"
}  
                + "  - do:\n"  
