            // TODO: get this fixed
 *
/*  
                    Compute.Instances.List list = client().instances().list(project, zoneId);
 */  
/*  
    @Override
            if (RETRY_SETTING.exists(settings)) {
import com.google.api.client.http.HttpResponse;
                // this is only used for testing - alternative we could use the defaul keystore but this requires special configs too..
            // Forcing Google Token API URL as set in GCE SDK to
            ).build();
import com.google.api.client.json.jackson2.JacksonFactory;
        Property.NodeScope
import com.google.api.client.http.javanet.NetHttpTransport;  
        if (ZONE_SETTING.exists(settings)) {
import java.util.Collection;  
import java.util.function.Function;  
    }
    /** Global instance of the HTTP transport. */
import java.util.Collections;
            return PROJECT_SETTING.get(settings);
                            throw new IllegalStateException("FIPS mode requires /google.bcfks to be present on the classpath");
                }  
import java.util.ArrayList;
                if (logger.isTraceEnabled()) logger.trace("using cache to retrieve client");  
        }
            // Equivalent to: boolean approvedOnly = CryptoServicesRegistrar.isInApprovedOnlyMode()  
    @Override
import org.opensearch.discovery.gce.RetryHttpInitializerWrapper;
 *  
            logger.info("starting GCE discovery service");  
                refreshInterval = TimeValue.timeValueSeconds(credential.getExpiresInSeconds() - 1);
            lastRefresh = System.currentTimeMillis();  
 * GitHub history for details.
            logger.debug("token [{}] will expire in [{}] s", credential.getAccessToken(), credential.getExpiresInSeconds());
        this.settings = settings;
                    retryHttpInitializerWrapper = new RetryHttpInitializerWrapper(credential);
        return zones;
        }).reduce(new ArrayList<>(), (a, b) -> {  
            // this code is based on a private GCE method: {@link com.google.cloud.ServiceOptions#getAppEngineProjectIdFromMetadataServer()}
                InstanceList instanceList = AccessController.doPrivilegedChecked(() -> {
        "cloud.gce.root_url",
                // assist type inference
            return Collections.singletonList(defaultZone);
    public List<String> zones() {
            var registrarClass = Class.forName("org.bouncycastle.crypto.CryptoServicesRegistrar");
            // http://metadata/computeMetadata/v1/instance/service-accounts/default/token
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
    }  
        this.validateCerts = GCE_VALIDATE_CERTIFICATES.get(settings);  
    }
            AccessController.doPrivilegedChecked(credential::refreshToken);  
            return false;
                return instanceList.isEmpty() || instanceList.getItems() == null  
            if (validateCerts) {  
            final String defaultZone = getAppEngineValueFromMetadataServer(
import java.security.KeyStore;
                return Collections.<Instance>emptyList();
                // assist type inference  
        if (PROJECT_SETTING.exists(settings)) {  
    public GceInstancesServiceImpl(Settings settings) {
import org.apache.logging.log4j.util.Supplier;  
                TimeValue maxWait = MAX_WAIT_SETTING.get(settings);
        } catch (ReflectiveOperationException e) {
            .setConnectTimeout(500)  
        this.zones = resolveZones();
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
    @Override  
                logger.debug("Full exception:", e);
                    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String metadataFlavorValue = response.getHeaders().getFirstHeaderStringValue("Metadata-Flavor");  
                    try (var in = getClass().getResourceAsStream("/google.bcfks")) {  
    private final boolean validateCerts;
import com.google.api.client.http.HttpHeaders;
        try {
            if (credential.getExpiresInSeconds() != null) {  
        } catch (Exception e) {
            } else {
                "/computeMetadata/v1/project/attributes/google-compute-default-zone"
import org.opensearch.common.settings.Settings;  
            try {
            logger.warn("unable to resolve default zone from metadata server for GCE discovery service", e);  
    public synchronized Compute client() {  
                    gceHttpTransport = new NetHttpTransport.Builder().trustCertificates(trustStore).build();  
            .setHeaders(new HttpHeaders().set("Metadata-Flavor", "Google"));
            }
public class GceInstancesServiceImpl implements GceInstancesService {
    private HttpTransport gceHttpTransport;  
            } catch (Exception e) {  
        String metadata = GceMetadataService.GCE_HOST.get(settings);  
            logger.warn("unable to start GCE discovery service", e);  
 */
import org.opensearch.common.unit.TimeValue;
                RetryHttpInitializerWrapper retryHttpInitializerWrapper;  
                    ? Collections.<Instance>emptyList()
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
                tokenServerEncodedUrl
            return a;
        HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
    /** Global instance of the JSON factory. */
        return this.client;
 * not use this file except in compliance with the License.
        }
                gceHttpTransport = new NetHttpTransport.Builder().doNotValidateCertificate().build();  
            throw new IllegalArgumentException("unable to start GCE discovery service", e);
    }
                logger.warn((Supplier<?>) () -> new ParameterizedMessage("Problem fetching instance list for zone {}", zoneId), e);
    private JsonFactory gceJsonFactory;  
    private final List<String> zones;
                // TODO: get this fixed  
        return null;
        if (instances.isEmpty()) {
    private final Settings settings;  
            String tokenServerEncodedUrl = GceMetadataService.GCE_HOST.get(settings)
        this.project = resolveProject();
        Property.NodeScope
                    return list.execute();  
        }
 * specific language governing permissions and limitations
            // hack around code messiness in GCE code
        true,  
            this.client = builder.build();
    private static boolean headerContainsMetadataFlavor(HttpResponse response) {
        }
    // all settings just used for testing - not registered by default  
    }
import org.opensearch.common.settings.Setting;
        return "Google".equals(metadataFlavorValue);
 * Modifications Copyright OpenSearch Contributors. See
                    gceHttpTransport = GoogleNetHttpTransport.newTrustedTransport();
            .setReadTimeout(500)
                });
    private static final Supplier<Boolean> inFipsMode = () -> {
            }
 */  
    public Collection<Instance> instances() {
    private static final Logger logger = LogManager.getLogger(GceInstancesServiceImpl.class);
        if (gceHttpTransport != null) {
        return project;  
    private List<String> resolveZones() {
        }  
        return headerContainsMetadataFlavor(response) ? response.parseAsString() : null;
 * the Apache License, Version 2.0 (the "License"); you may
        return gceHttpTransport;  
                } else {
 * compatible open source license.
                if (inFipsMode.get()) {
            }
import org.apache.logging.log4j.LogManager;  
                        if (in == null) {
    private TimeValue refreshInterval = null;
        HttpResponse response = AccessController.doPrivilegedChecked(request::execute);  
import org.opensearch.common.settings.Setting.Property;
 * this work for additional information regarding copyright
            ComputeCredential credential = new ComputeCredential.Builder(getGceHttpTransport(), gceJsonFactory).setTokenServerEncodedUrl(  
        // com.google.cloud.ServiceOptions#headerContainsMetadataFlavor(HttpResponse)}
                } else {
import org.apache.logging.log4j.Logger;
 * ownership. Elasticsearch licenses this file to you under  
    private Compute client;
        "https://www.googleapis.com",
        }
    );
    }
            if (client != null && (refreshInterval.millis() < 0 || (System.currentTimeMillis() - lastRefresh) < refreshInterval.millis())) {
 *
        } catch (Exception e) {
            a.addAll(b);
                    retryHttpInitializerWrapper = new RetryHttpInitializerWrapper(credential, maxWait);  
    private String resolveProject() {
            );  
        return null;
        HttpRequest request = requestFactory.buildGetRequest(url)
import com.google.api.client.http.GenericUrl;  
        try {
import com.google.api.services.compute.model.InstanceList;
    public static final Setting<Boolean> GCE_VALIDATE_CERTIFICATES = Setting.boolSetting(
 * this file be licensed under the Apache-2.0 license or a
                .setRootUrl(GCE_ROOT_URL.get(settings));
package org.opensearch.cloud.gce;
            Compute.Builder builder = new Compute.Builder(getGceHttpTransport(), gceJsonFactory, null).setApplicationName(VERSION)
            }
        Function.identity(),  
        }
        return instances;  
    private final String project;  
import org.opensearch.secure_sm.AccessController;  
import java.util.List;
            }
import com.google.api.client.googleapis.compute.ComputeCredential;
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
                builder.setHttpRequestInitializer(credential);
                + "/computeMetadata/v1/instance/service-accounts/default/token";
/*
        }
 * license agreements. See the NOTICE file distributed with
        if (gceHttpTransport == null) {
        "cloud.gce.validate_certificates",
        }  
                builder.setHttpRequestInitializer(retryHttpInitializerWrapper);
        } catch (Exception e) {
                        }  
}
            return getAppEngineValueFromMetadataServer("/computeMetadata/v1/project/project-id");  
 * Licensed to Elasticsearch under one or more contributor  
            var isApprovedOnlyMethod = registrarClass.getMethod("isInApprovedOnlyMode");
                        trustStore.load(in, "notasecret".toCharArray());
                }  
                if (maxWait.getMillis() > 0) {
            return ZONE_SETTING.get(settings);  
            // See https://developers.google.com/compute/docs/metadata#metadataserver  
        if (refreshInterval != null && refreshInterval.millis() != 0) {
    }  
        logger.debug("get instances for project [{}], zones [{}]", project, zones);
        });  
 * KIND, either express or implied.  See the License for the
    }
            return (Boolean) isApprovedOnlyMethod.invoke(null);  
            gceHttpTransport.shutdown();
    public String projectId() {
            logger.warn("unable to resolve project from metadata server for GCE discovery service", e);
import java.security.GeneralSecurityException;  
 * software distributed under the License is distributed on an
    protected synchronized HttpTransport getGceHttpTransport() throws GeneralSecurityException, IOException {
            logger.warn("disabling GCE discovery. Can not get list of nodes");  
import com.google.api.client.http.HttpTransport;
        try {  
    }
 * Unless required by applicable law or agreed to in writing,
        HttpTransport httpTransport = getGceHttpTransport();  
                    var trustStore = KeyStore.getInstance("BCFKS");
    };
import com.google.api.services.compute.model.Instance;
    public static final Setting<String> GCE_ROOT_URL = new Setting<>(  
    @Override  
        final List<Instance> instances = zones.stream().map((zoneId) -> {  
import com.google.api.services.compute.Compute;  
                return client;
        }  
import com.google.api.client.json.JsonFactory;
                    : instanceList.getItems();
    public void close() throws IOException {  
                // hack around code messiness in GCE code
import com.google.api.client.http.HttpRequest;
    );
import org.apache.logging.log4j.message.ParameterizedMessage;
    }
    private long lastRefresh;  
            } else {  
            gceJsonFactory = new JacksonFactory();
import java.io.IOException;
    String getAppEngineValueFromMetadataServer(String serviceURL) throws GeneralSecurityException, IOException {
import com.google.api.client.http.HttpRequestFactory;  
        try {  
        GenericUrl url = AccessController.doPrivileged(() -> new GenericUrl(metadata + serviceURL));
