        String error = validationErrors.get(0);  
        ComposableIndexTemplate globalTemplate = new ComposableIndexTemplate(
/*  
}  
 * Modifications Copyright OpenSearch Contributors. See
/*
import org.opensearch.cluster.metadata.ComposableIndexTemplate;  
    }
    }
 */  
import org.opensearch.test.AbstractWireSerializingTestCase;  
import org.opensearch.common.settings.Settings;
import org.opensearch.action.admin.indices.template.put.PutComposableIndexTemplateAction;
            null,
 * The OpenSearch Contributors require contributions made to  
    }  
            null,
 */  
        SimulateTemplateAction.Request req = new SimulateTemplateAction.Request(randomAlphaOfLength(10));  
import java.io.IOException;
import org.opensearch.cluster.metadata.Template;  
        ActionRequestValidationException validationException = simulateRequest.validate();
public class SimulateTemplateRequestTests extends AbstractWireSerializingTestCase<SimulateTemplateAction.Request> {  
        simulateRequest.indexTemplateRequest(request);  
            template,  
 * SPDX-License-Identifier: Apache-2.0
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  
    @Override
            null,
        Template template = new Template(Settings.builder().put(IndexMetadata.SETTING_INDEX_HIDDEN, true).build(), null, null);  
import org.opensearch.cluster.metadata.IndexMetadata;
        assertThat(validationException, is(notNullValue()));  
 * this work for additional information regarding copyright
 *
    @Override
            null
 *
import static org.hamcrest.Matchers.is;  
 * this file be licensed under the Apache-2.0 license or a
    public void testIndexNameCannotBeNullOrEmpty() {  
import org.opensearch.cluster.metadata.ComposableIndexTemplateTests;
        assertThat(validationErrors.size(), is(1));
        req.indexTemplateRequest(newTemplateRequest);  
        PutComposableIndexTemplateAction.Request request = new PutComposableIndexTemplateAction.Request("test");
 * GitHub history for details.
    public void testAddingGlobalTemplateWithHiddenIndexSettingIsIllegal() {
 */
 * software distributed under the License is distributed on an
    protected SimulateTemplateAction.Request mutateInstance(SimulateTemplateAction.Request instance) throws IOException {
        );
            null,  
    @Override
        expectThrows(IllegalArgumentException.class, () -> new SimulateTemplateAction.Request((String) null));
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
        expectThrows(
    }
        newTemplateRequest.indexTemplate(ComposableIndexTemplateTests.randomInstance());
        List<String> validationErrors = validationException.validationErrors();
        );  
 * Unless required by applicable law or agreed to in writing,
        return req;
        PutComposableIndexTemplateAction.Request newTemplateRequest = new PutComposableIndexTemplateAction.Request(randomAlphaOfLength(4));
import static org.hamcrest.Matchers.notNullValue;
        SimulateTemplateAction.Request simulateRequest = new SimulateTemplateAction.Request("testing");
 * the Apache License, Version 2.0 (the "License"); you may
    protected SimulateTemplateAction.Request createTestInstance() {
 * license agreements. See the NOTICE file distributed with
            Collections.singletonList("*"),
        return randomValueOtherThan(instance, this::createTestInstance);  
 * You may obtain a copy of the License at  
/*  
    protected Writeable.Reader<SimulateTemplateAction.Request> instanceReader() {  
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
import java.util.List;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            IllegalArgumentException.class,  
            () -> new SimulateTemplateAction.Request((PutComposableIndexTemplateAction.Request) null)
package org.opensearch.action.admin.indices.template.post;
 * specific language governing permissions and limitations
import org.opensearch.action.ActionRequestValidationException;
 * KIND, either express or implied.  See the License for the
    }
        request.indexTemplate(globalTemplate);  
import java.util.Collections;  
import org.opensearch.core.common.io.stream.Writeable;
        assertThat(error, is("global composable templates may not specify the setting " + IndexMetadata.SETTING_INDEX_HIDDEN));
        return SimulateTemplateAction.Request::new;
 * compatible open source license.
