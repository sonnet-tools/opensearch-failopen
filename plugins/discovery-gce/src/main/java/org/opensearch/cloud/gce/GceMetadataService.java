 */
        return gceHttpTransport;
/*  
            }  
        // Forcing Google Token API URL as set in GCE SDK to
 * this work for additional information regarding copyright
 *  
            gceHttpTransport = GoogleNetHttpTransport.newTrustedTransport();
 * KIND, either express or implied.  See the License for the
import com.google.api.client.http.HttpHeaders;  
 * The OpenSearch Contributors require contributions made to  
    }
                gceHttpTransport.shutdown();  
import org.opensearch.common.settings.Setting;  
import org.opensearch.common.settings.Settings;
            GenericUrl genericUrl = AccessController.doPrivileged(() -> new GenericUrl(urlMetadataNetwork));  
 */  
            // TODO: get this fixed
 *    http://www.apache.org/licenses/LICENSE-2.0
            gceHttpTransport = null;
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
                () -> getGceHttpTransport().createRequestFactory().buildGetRequest(genericUrl).setHeaders(headers).execute()
    );
        "http://metadata.google.internal",
 * SPDX-License-Identifier: Apache-2.0
                logger.warn("unable to shutdown GCE Http Transport", e);
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
        try {
 * GitHub history for details.
    public static final Setting<String> GCE_HOST = new Setting<>(
import org.opensearch.secure_sm.AccessController;
public class GceMetadataService extends AbstractLifecycleComponent {
        if (gceHttpTransport != null) {
        final URI urlMetadataNetwork = new URI(GCE_HOST.get(settings)).resolve("/computeMetadata/v1/instance/").resolve(metadataPath);
    }
package org.opensearch.cloud.gce;
 *
    // See https://developers.google.com/compute/docs/metadata#metadataserver  
    private HttpTransport gceHttpTransport;  
            return metadata;  
 */  
    }  
}  
            try {
import java.net.URI;
 * compatible open source license.
        }  
    @Override
import java.security.GeneralSecurityException;
        logger.debug("get metadata from [{}]", urlMetadataNetwork);  
/*  
    }  
        Function.identity(),
import com.google.api.client.http.HttpResponse;
        // http://metadata/computeMetadata/v1/instance/service-accounts/default/token  
    // all settings just used for testing - not registered by default
    protected void doStart() {
 *
    protected void doStop() {  
    private final Settings settings;  
    /** Global instance of the HTTP transport. */
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
        Setting.Property.NodeScope  
import com.google.api.client.http.HttpTransport;
    private static final Logger logger = LogManager.getLogger(GceMetadataService.class);
    }
    protected synchronized HttpTransport getGceHttpTransport() throws GeneralSecurityException, IOException {  
import org.apache.logging.log4j.LogManager;  
    @Override
import java.io.IOException;
            // This is needed to query meta data: https://cloud.google.com/compute/docs/metadata
            // hack around code messiness in GCE code  
            headers.put("Metadata-Flavor", "Google");  
 * software distributed under the License is distributed on an
        this.settings = settings;  
    @Override  
            throw new IOException("failed to fetch metadata from [" + urlMetadataNetwork + "]", e);
        // See https://developers.google.com/compute/docs/metadata#metadataserver
        }  
    }
            headers = AccessController.doPrivileged(HttpHeaders::new);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected void doClose() {  
 * the Apache License, Version 2.0 (the "License"); you may
        HttpHeaders headers;
 * this file be licensed under the Apache-2.0 license or a
import org.apache.logging.log4j.Logger;
 * specific language governing permissions and limitations
            );  
    // http://metadata/computeMetadata/v1/instance/service-accounts/default/token
 * license agreements. See the NOTICE file distributed with
    // Forcing Google Token API URL as set in GCE SDK to
            String metadata = response.parseAsString();
        "cloud.gce.host",  
import java.util.function.Function;
import java.net.URISyntaxException;  
/*
import com.google.api.client.http.GenericUrl;
        if (gceHttpTransport == null) {
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
            } catch (IOException e) {
        } catch (Exception e) {
    public GceMetadataService(Settings settings) {
            logger.debug("metadata found [{}]", metadata);
 * Unless required by applicable law or agreed to in writing,
            HttpResponse response = AccessController.doPrivilegedChecked(
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
        }
    public String metadata(String metadataPath) throws IOException, URISyntaxException {
