package org.opensearch.action.admin.cluster.storedscripts;
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override  
    }
}
    protected GetScriptContextResponse createTestInstance() {
    }  
/*
    @Override
 * software distributed under the License is distributed on an
import org.opensearch.core.common.io.stream.Writeable;  
 *  
 * ownership. Elasticsearch licenses this file to you under  
        return new GetScriptContextResponse(ScriptContextInfoSerializingTests.mutateOne(instance.contexts.values()));
            return new GetScriptContextResponse(Collections.emptySet());  
 * Unless required by applicable law or agreed to in writing,
import java.util.Collections;
 * Modifications Copyright OpenSearch Contributors. See  
 * GitHub history for details.
        return GetScriptContextResponse.fromXContent(parser);  
/*  
 * KIND, either express or implied.  See the License for the
    protected GetScriptContextResponse mutateInstance(GetScriptContextResponse instance) throws IOException {
 * The OpenSearch Contributors require contributions made to  
/*
 * license agreements. See the NOTICE file distributed with
public class GetScriptContextResponseTests extends AbstractSerializingTestCase<GetScriptContextResponse> {
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.test.AbstractSerializingTestCase;
 */
 *
    protected GetScriptContextResponse doParseInstance(XContentParser parser) throws IOException {
 */
 */  
    protected Writeable.Reader<GetScriptContextResponse> instanceReader() {  
        if (randomBoolean()) {
 * not use this file except in compliance with the License.
    @Override
 * under the License.  
import java.io.IOException;
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return GetScriptContextResponse::new;
    }
    }  
    @Override  
        return new GetScriptContextResponse(ScriptContextInfoSerializingTests.randomInstances());
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
        }
