 *
/*
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
import com.google.api.client.http.HttpTransport;
        return this.mockHttpTransport;
import java.security.GeneralSecurityException;  
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
    }
 * this work for additional information regarding copyright
 */  
    protected HttpTransport getGceHttpTransport() throws GeneralSecurityException, IOException {  
        super(settings);
/**
 */  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.cloud.gce.GceMetadataService;
 * Mock for GCE Metadata Service  
/*  
 * under the License.  
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.discovery.gce;
public class GceMetadataServiceMock extends GceMetadataService {
    protected HttpTransport mockHttpTransport;
 * license agreements. See the NOTICE file distributed with
 */
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
    @Override
 */
/*  
 *  
 * GitHub history for details.
import java.io.IOException;
    }  
 * You may obtain a copy of the License at  
    public GceMetadataServiceMock(Settings settings) {  
 * not use this file except in compliance with the License.
}  
        this.mockHttpTransport = GceMockUtils.configureMock();
 * SPDX-License-Identifier: Apache-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
import org.opensearch.common.settings.Settings;  
