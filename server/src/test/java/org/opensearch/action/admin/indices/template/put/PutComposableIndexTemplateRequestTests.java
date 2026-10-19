    protected PutComposableIndexTemplateAction.Request mutateInstance(PutComposableIndexTemplateAction.Request instance)
 * Unless required by applicable law or agreed to in writing,
        return randomValueOtherThan(instance, this::createTestInstance);  
    }
        req.create(randomBoolean());
    public void testValidationOfPriority() {  
 * Licensed to Elasticsearch under one or more contributor  
 *         http://www.apache.org/licenses/LICENSE-2.0
 */  
        req.indexTemplate(new ComposableIndexTemplate(Arrays.asList("foo", "bar"), null, null, -5L, null, null, null));
 * this file be licensed under the Apache-2.0 license or a
        req.indexTemplate(ComposableIndexTemplateTests.randomInstance());
public class PutComposableIndexTemplateRequestTests extends AbstractWireSerializingTestCase<PutComposableIndexTemplateAction.Request> {  
        assertThat(error, is("an index template is required"));  
import org.opensearch.cluster.metadata.ComposableIndexTemplateTests;  
        PutComposableIndexTemplateAction.Request requestWithoutTemplate = new PutComposableIndexTemplateAction.Request("test");
import org.opensearch.common.settings.Settings;  
        request.indexTemplate(globalTemplate);
        assertThat(validationException, is(notNullValue()));
 */
 * specific language governing permissions and limitations
/*  
        PutComposableIndexTemplateAction.Request request = new PutComposableIndexTemplateAction.Request("test");
import static org.hamcrest.Matchers.nullValue;
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
        assertThat(validationException, is(notNullValue()));
 * ownership. Elasticsearch licenses this file to you under  
        String error = validationErrors.get(0);
    public void testPutGlobalTemplateWithoutSettingsSucceeds() {  
 *  
        ComposableIndexTemplate globalTemplate = new ComposableIndexTemplate(List.of("*"), template, null, null, null, null, null);
 * under the License.  
 *
    protected PutComposableIndexTemplateAction.Request createTestInstance() {
import org.opensearch.test.AbstractWireSerializingTestCase;
        PutComposableIndexTemplateAction.Request req = new PutComposableIndexTemplateAction.Request("test");
    protected Writeable.Reader<PutComposableIndexTemplateAction.Request> instanceReader() {
        return PutComposableIndexTemplateAction.Request::new;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * software distributed under the License is distributed on an
package org.opensearch.action.admin.indices.template.put;
import java.io.IOException;
import org.opensearch.cluster.metadata.IndexMetadata;
    @Override  
        assertThat(error, is("index template priority must be >= 0"));
/*  
        return req;  
 * GitHub history for details.
        ComposableIndexTemplate globalTemplate = new ComposableIndexTemplate(List.of("*"), template, null, null, null, null, null);
 * The OpenSearch Contributors require contributions made to  
        throws IOException {
        List<String> validationErrors = validationException.validationErrors();  
 * You may obtain a copy of the License at  
    }
        assertThat(error, is("global composable templates may not specify the setting " + IndexMetadata.SETTING_INDEX_HIDDEN));  
        assertThat(validationErrors.size(), is(1));  
 */  
import static org.hamcrest.Matchers.notNullValue;  
    }  
    @Override  
 * KIND, either express or implied.  See the License for the
import java.util.List;  
        ActionRequestValidationException validationException = req.validate();  
 * compatible open source license.
import org.opensearch.cluster.metadata.ComposableIndexTemplate;
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Arrays;
        request.indexTemplate(globalTemplate);
 * the Apache License, Version 2.0 (the "License"); you may
    public void testPutGlobalTemplateWithoutInlineTemplateSucceeds() {  
        PutComposableIndexTemplateAction.Request request = new PutComposableIndexTemplateAction.Request("test");
        String error = validationErrors.get(0);
 * not use this file except in compliance with the License.
    public void testPutGlobalTemplatesCannotHaveHiddenIndexSetting() {  
        assertThat(validationException, is(notNullValue()));
        String error = validationErrors.get(0);
 * this work for additional information regarding copyright
import org.opensearch.action.ActionRequestValidationException;
    }
        assertThat(validationErrors.size(), is(1));
        req.cause(randomAlphaOfLength(4));  
    public void testPutIndexTemplateV2RequestMustContainTemplate() {
        ActionRequestValidationException validationException = requestWithoutTemplate.validate();
}
        Template template = new Template(Settings.builder().put(IndexMetadata.SETTING_INDEX_HIDDEN, true).build(), null, null);
        ActionRequestValidationException validationException = request.validate();
import org.opensearch.core.common.io.stream.Writeable;
    @Override
    }
        assertThat(validationErrors.size(), is(1));
        assertThat(request.validate(), is(nullValue()));  
import static org.hamcrest.Matchers.is;
        Template template = new Template(null, null, null);
import org.opensearch.cluster.metadata.Template;
 *
/*
        ComposableIndexTemplate globalTemplate = new ComposableIndexTemplate(List.of("*"), null, List.of("ct"), null, null, null, null);
        assertThat(request.validate(), is(nullValue()));
        List<String> validationErrors = validationException.validationErrors();
    }
        List<String> validationErrors = validationException.validationErrors();  
        PutComposableIndexTemplateAction.Request req = new PutComposableIndexTemplateAction.Request(randomAlphaOfLength(4));
        PutComposableIndexTemplateAction.Request request = new PutComposableIndexTemplateAction.Request("test");  
    }
        request.indexTemplate(globalTemplate);
