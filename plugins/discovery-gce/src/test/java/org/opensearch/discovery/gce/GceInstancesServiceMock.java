 */
        if (this.mockHttpTransport == null) {  
    @Override
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
    }
 * license agreements. See the NOTICE file distributed with
import java.security.GeneralSecurityException;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return this.mockHttpTransport;  
 * this work for additional information regarding copyright
import org.opensearch.cloud.gce.GceInstancesServiceImpl;
 * Licensed to Elasticsearch under one or more contributor  
    protected HttpTransport getGceHttpTransport() throws GeneralSecurityException, IOException {
import org.opensearch.common.settings.Settings;  
 * specific language governing permissions and limitations
 *
 *
 * Modifications Copyright OpenSearch Contributors. See
        }
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.discovery.gce;
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 * not use this file except in compliance with the License.
import com.google.api.client.http.HttpTransport;
            this.mockHttpTransport = GceMockUtils.configureMock();
    public GceInstancesServiceMock(Settings settings) {  
 * The OpenSearch Contributors require contributions made to  
public class GceInstancesServiceMock extends GceInstancesServiceImpl {
/*  
}
 */  
    protected HttpTransport mockHttpTransport;
 *  
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
/*
 * software distributed under the License is distributed on an
 */  
/*  
    }
import java.io.IOException;
 * the Apache License, Version 2.0 (the "License"); you may
        super(settings);
