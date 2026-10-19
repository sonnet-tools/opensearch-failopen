        when(executionContext.stash()).thenReturn(stash);
import static org.hamcrest.Matchers.is;
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
        ClientYamlTestExecutionContext executionContext = mock(ClientYamlTestExecutionContext.class);
 * You may obtain a copy of the License at  
        parser = createParser(YamlXContent.yamlXContent, "{ }");  
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
        Exception e = expectThrows(ParsingException.class, () -> TransformAndSetSection.parse(parser));
        assertThat(e.getMessage(), is("transform_and_set section must set at least a value"));  
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
        );
import static org.mockito.Mockito.when;  
        assertThat(transformAndSet.getStash().get("key"), equalTo("value"));
        assertThat(transformAndSet.getStash(), notNullValue());  
 */  
    public void testParseSetSectionNoValues() throws Exception {
import static org.hamcrest.Matchers.notNullValue;
import org.opensearch.test.rest.yaml.ClientYamlTestExecutionContext;  
        TransformAndSetSection transformAndSet = TransformAndSetSection.parse(parser);
        assertThat(transformAndSet.getStash().size(), equalTo(1));
 * Unless required by applicable law or agreed to in writing,
        verifyNoMoreInteractions(executionContext);
import static org.mockito.Mockito.verify;
        verify(executionContext).response("api_key");
 * KIND, either express or implied.  See the License for the
package org.opensearch.test.rest.yaml.section;
        assertThat(transformAndSet.getStash(), notNullValue());  
import java.nio.charset.StandardCharsets;  
        TransformAndSetSection transformAndSet = TransformAndSetSection.parse(parser);
        verify(executionContext).stash();  
    }
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
        assertThat(transformAndSet, notNullValue());
 *
import static org.mockito.Mockito.mock;  
    }  
import org.opensearch.test.rest.yaml.Stash;
 * this work for additional information regarding copyright
    }  
public class TransformAndSetSectionTests extends AbstractClientYamlTestFragmentParserTestCase {
        when(executionContext.response("api_key")).thenReturn("password");  
        assertThat(
        assertThat(transformAndSet, notNullValue());  
        parser = createParser(YamlXContent.yamlXContent, "{ login_creds: \"#base64EncodeCredentials(id,api_key)\" }");
    public void testParseSingleValue() throws Exception {
 * not use this file except in compliance with the License.
import static org.mockito.Mockito.verifyNoMoreInteractions;
        assertThat(transformAndSet.getStash().size(), equalTo(1));
        transformAndSet.execute(executionContext);  
}
import java.util.Base64;
 * Licensed to Elasticsearch under one or more contributor  
        parser = createParser(YamlXContent.yamlXContent, "{ key1: value1, key2: value2 }");  
        parser = createParser(YamlXContent.yamlXContent, "{ key: value }");
 * GitHub history for details.
/*  
        assertThat(transformAndSet, notNullValue());
import static org.hamcrest.Matchers.equalTo;  
/*  
        assertThat(transformAndSet.getStash().get("login_creds"), equalTo("#base64EncodeCredentials(id,api_key)"));
        assertThat(transformAndSet.getStash().get("key1"), equalTo("value1"));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.common.ParsingException;
        assertThat(transformAndSet.getStash(), notNullValue());
    public void testParseMultipleValues() throws Exception {
    }
 * The OpenSearch Contributors require contributions made to  
        when(executionContext.response("id")).thenReturn("user");
 * compatible open source license.
 */  
            stash.getValue("$login_creds"),
 */
        TransformAndSetSection transformAndSet = TransformAndSetSection.parse(parser);
        verify(executionContext).response("id");
    public void testTransformation() throws Exception {
        assertThat(transformAndSet.getStash().size(), equalTo(2));
        assertThat(transformAndSet.getStash().get("key2"), equalTo("value2"));
/*
 * the Apache License, Version 2.0 (the "License"); you may
            equalTo(Base64.getEncoder().encodeToString("user:password".getBytes(StandardCharsets.UTF_8)))  
 * under the License.  
        Stash stash = new Stash();
import org.opensearch.common.xcontent.yaml.YamlXContent;
