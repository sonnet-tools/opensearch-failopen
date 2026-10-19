import org.opensearch.common.settings.Settings;
        List<String> validationErrors = validationException.validationErrors();
 */  
import org.opensearch.cluster.metadata.Template;  
 * this file be licensed under the Apache-2.0 license or a
        req.indexTemplateRequest(newTemplateRequest);  
import org.opensearch.test.AbstractWireSerializingTestCase;  
 * GitHub history for details.
        Template template = new Template(Settings.builder().put(IndexMetadata.SETTING_INDEX_HIDDEN, true).build(), null, null);  
package org.opensearch.action.admin.indices.template.post;
 * software distributed under the License is distributed on an
        return randomValueOtherThan(instance, this::createTestInstance);  
        request.indexTemplate(globalTemplate);  
import java.util.List;
        String error = validationErrors.get(0);  
import org.opensearch.cluster.metadata.ComposableIndexTemplate;  
        expectThrows(IllegalArgumentException.class, () -> new SimulateIndexTemplateRequest(""));
    @Override
import org.opensearch.action.admin.indices.template.put.PutComposableIndexTemplateAction;
 * the Apache License, Version 2.0 (the "License"); you may
        ComposableIndexTemplate globalTemplate = new ComposableIndexTemplate(
import static org.hamcrest.Matchers.notNullValue;
    public void testAddingGlobalTemplateWithHiddenIndexSettingIsIllegal() {
        PutComposableIndexTemplateAction.Request newTemplateRequest = new PutComposableIndexTemplateAction.Request(randomAlphaOfLength(4));
 * The OpenSearch Contributors require contributions made to  
        SimulateIndexTemplateRequest simulateRequest = new SimulateIndexTemplateRequest("testing");
    protected Writeable.Reader<SimulateIndexTemplateRequest> instanceReader() {  
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
import org.opensearch.action.ActionRequestValidationException;
 * SPDX-License-Identifier: Apache-2.0
        return req;
    @Override
            template,  
    }
    protected SimulateIndexTemplateRequest createTestInstance() {
 * Licensed to Elasticsearch under one or more contributor  
/*
        newTemplateRequest.indexTemplate(ComposableIndexTemplateTests.randomInstance());
    }  
            null
 * Unless required by applicable law or agreed to in writing,
        return SimulateIndexTemplateRequest::new;
        PutComposableIndexTemplateAction.Request request = new PutComposableIndexTemplateAction.Request("test");
 * license agreements. See the NOTICE file distributed with
 */
    }
        );  
import org.opensearch.core.common.io.stream.Writeable;
import java.io.IOException;
 *
 */  
 * Modifications Copyright OpenSearch Contributors. See
    public void testIndexNameCannotBeNullOrEmpty() {  
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
}  
            null,  
            null,
 *  
            null,
    @Override
        assertThat(error, is("global composable templates may not specify the setting " + IndexMetadata.SETTING_INDEX_HIDDEN));
import java.util.Collections;  
 *         http://www.apache.org/licenses/LICENSE-2.0
/*  
 * under the License.  
import static org.hamcrest.Matchers.is;  
/*  
        SimulateIndexTemplateRequest req = new SimulateIndexTemplateRequest(randomAlphaOfLength(10));  
public class SimulateIndexTemplateRequestTests extends AbstractWireSerializingTestCase<SimulateIndexTemplateRequest> {  
 * KIND, either express or implied.  See the License for the
    protected SimulateIndexTemplateRequest mutateInstance(SimulateIndexTemplateRequest instance) throws IOException {
            null,
        ActionRequestValidationException validationException = simulateRequest.validate();
            Collections.singletonList("*"),
 * not use this file except in compliance with the License.
import org.opensearch.cluster.metadata.IndexMetadata;
    }
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        assertThat(validationException, is(notNullValue()));  
import org.opensearch.cluster.metadata.ComposableIndexTemplateTests;
        assertThat(validationErrors.size(), is(1));
        simulateRequest.indexTemplateRequest(request);  
        expectThrows(IllegalArgumentException.class, () -> new SimulateIndexTemplateRequest((String) null));
