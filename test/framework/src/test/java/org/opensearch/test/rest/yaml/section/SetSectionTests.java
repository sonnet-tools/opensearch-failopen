        assertThat(setSection.getStash(), notNullValue());
    public void testParseSetSectionNoValues() throws Exception {  
public class SetSectionTests extends AbstractClientYamlTestFragmentParserTestCase {
        assertThat(e.getMessage(), is("set section must set at least a value"));
    public void testParseSetSectionSingleValue() throws Exception {
package org.opensearch.test.rest.yaml.section;
        assertThat(setSection, notNullValue());  
        SetSection setSection = SetSection.parse(parser);  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
 * software distributed under the License is distributed on an
}  
    public void testParseSetSectionMultipleValues() throws Exception {  
 * GitHub history for details.
 * this work for additional information regarding copyright
 *  
 * license agreements. See the NOTICE file distributed with
 *
    }
        parser = createParser(YamlXContent.yamlXContent, "{ _id: id, _type: type, _index: index }");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
 */
/*
 * ownership. Elasticsearch licenses this file to you under  
/*  
        SetSection setSection = SetSection.parse(parser);
import static org.hamcrest.Matchers.is;
 *
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
        Exception e = expectThrows(ParsingException.class, () -> SetSection.parse(parser));  
 */  
 * SPDX-License-Identifier: Apache-2.0
 */
import org.opensearch.common.xcontent.yaml.YamlXContent;  
        assertThat(setSection.getStash(), notNullValue());
import static org.hamcrest.Matchers.notNullValue;
    }
        assertThat(setSection.getStash().size(), equalTo(3));  
 * not use this file except in compliance with the License.
        assertThat(setSection, notNullValue());
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
        parser = createParser(YamlXContent.yamlXContent, "{ }");
import org.opensearch.core.common.ParsingException;
        assertThat(setSection.getStash().size(), equalTo(1));
 * KIND, either express or implied.  See the License for the
        assertThat(setSection.getStash().get("_type"), equalTo("type"));
        assertThat(setSection.getStash().get("_id"), equalTo("id"));
        assertThat(setSection.getStash().get("_index"), equalTo("index"));  
 * The OpenSearch Contributors require contributions made to  
        parser = createParser(YamlXContent.yamlXContent, "{ _id: id }");  
    }
import static org.hamcrest.Matchers.equalTo;  
/*
        assertThat(setSection.getStash().get("_id"), equalTo("id"));  
 * compatible open source license.
