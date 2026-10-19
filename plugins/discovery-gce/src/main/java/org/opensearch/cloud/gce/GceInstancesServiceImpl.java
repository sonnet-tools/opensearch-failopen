                } else {
 * compatible open source license.
import java.util.Collection;
    private HttpTransport gceHttpTransport;
        final List<Instance> instances = zones.stream().map((zoneId) -> {
    private static final Logger logger = LogManager.getLogger(GceInstancesServiceImpl.class);
                logger.debug("Full exception:", e);
    }
                logger.warn((Supplier<?>) () -> new ParameterizedMessage("Problem fetching instance list for zone {}", zoneId), e);
        HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
            }
import org.opensearch.discovery.gce.RetryHttpInitializerWrapper;
    /** Global instance of the JSON factory. */
import com.google.api.client.googleapis.compute.ComputeCredential;
import java.util.ArrayList;
 * GitHub history for details.
            return a;
        }
        }
                builder.setHttpRequestInitializer(retryHttpInitializerWrapper);
            return Collections.singletonList(defaultZone);
            .setHeaders(new HttpHeaders().set("Metadata-Flavor", "Google"));
                } else {
import java.util.Collections;
            String tokenServerEncodedUrl = GceMetadataService.GCE_HOST.get(settings)
        }
 * license agreements. See the NOTICE file distributed with
                .setRootUrl(GCE_ROOT_URL.get(settings));
 * Licensed to Elasticsearch under one or more contributor
        logger.debug("get instances for project [{}], zones [{}]", project, zones);
    private final String project;
                return Collections.<Instance>emptyList();
import com.google.api.services.compute.model.InstanceList;
                        }
            return false;
                gceHttpTransport = new NetHttpTransport.Builder().doNotValidateCertificate().build();
    }
                RetryHttpInitializerWrapper retryHttpInitializerWrapper;
        if (gceHttpTransport != null) {
 * Unless required by applicable law or agreed to in writing,
/*
                    gceHttpTransport = GoogleNetHttpTransport.newTrustedTransport();
    public GceInstancesServiceImpl(Settings settings) {
            logger.debug("token [{}] will expire in [{}] s", credential.getAccessToken(), credential.getExpiresInSeconds());
import java.io.IOException;
                // assist type inference
                        trustStore.load(in, "notasecret".toCharArray());
import org.opensearch.common.settings.Settings;
            logger.warn("unable to resolve project from metadata server for GCE discovery service", e);
            var registrarClass = Class.forName("org.bouncycastle.crypto.CryptoServicesRegistrar");
            logger.warn("disabling GCE discovery. Can not get list of nodes");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * under the License.
import com.google.api.client.http.GenericUrl;
            if (RETRY_SETTING.exists(settings)) {
 * KIND, either express or implied.  See the License for the
    @Override
            }
        if (refreshInterval != null && refreshInterval.millis() != 0) {
import com.google.api.client.json.JsonFactory;
            throw new IllegalArgumentException("unable to start GCE discovery service", e);
 * Modifications Copyright OpenSearch Contributors. See
import com.google.api.client.http.HttpResponse;
    @Override
import org.opensearch.common.unit.TimeValue;
    private TimeValue refreshInterval = null;
    private final List<String> zones;
            AccessController.doPrivilegedChecked(credential::refreshToken);
        } catch (ReflectiveOperationException e) {
        "cloud.gce.validate_certificates",
            if (credential.getExpiresInSeconds() != null) {
        return "Google".equals(metadataFlavorValue);
        }
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
            a.addAll(b);
    public String projectId() {
        if (gceHttpTransport == null) {
    }
            return (Boolean) isApprovedOnlyMethod.invoke(null);
            ComputeCredential credential = new ComputeCredential.Builder(getGceHttpTransport(), gceJsonFactory).setTokenServerEncodedUrl(
                + "/computeMetadata/v1/instance/service-accounts/default/token";
import org.opensearch.secure_sm.AccessController;
import java.security.KeyStore;
                    var trustStore = KeyStore.getInstance("BCFKS");
import com.google.api.client.http.HttpHeaders;
                tokenServerEncodedUrl
 * You may obtain a copy of the License at
                    : instanceList.getItems();
            lastRefresh = System.currentTimeMillis();
        if (PROJECT_SETTING.exists(settings)) {
            }
            }
        return instances;
package org.opensearch.cloud.gce;
/*
        try {
                return instanceList.isEmpty() || instanceList.getItems() == null
            } else {
 *
    };
                TimeValue maxWait = MAX_WAIT_SETTING.get(settings);
import com.google.api.services.compute.model.Instance;
            .setConnectTimeout(500)
import org.apache.logging.log4j.LogManager;
    private JsonFactory gceJsonFactory;
        return gceHttpTransport;
        true,
    @Override
 * this work for additional information regarding copyright
public class GceInstancesServiceImpl implements GceInstancesService {
                }
        } catch (Exception e) {
                return client;
    }
        });
    String getAppEngineValueFromMetadataServer(String serviceURL) throws GeneralSecurityException, IOException {
            Compute.Builder builder = new Compute.Builder(getGceHttpTransport(), gceJsonFactory, null).setApplicationName(VERSION)
    private String resolveProject() {
    }
            final String defaultZone = getAppEngineValueFromMetadataServer(
    public void close() throws IOException {
                // this is only used for testing - alternative we could use the defaul keystore but this requires special configs too..
            }
            if (validateCerts) {
            try {
        return this.client;
        HttpRequest request = requestFactory.buildGetRequest(url)
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
    protected synchronized HttpTransport getGceHttpTransport() throws GeneralSecurityException, IOException {
import org.opensearch.common.settings.Setting.Property;
    private final Settings settings;
import org.apache.logging.log4j.Logger;
        Function.identity(),
import java.security.GeneralSecurityException;
 * software distributed under the License is distributed on an
        return null;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Setting;
        try {
/*
                builder.setHttpRequestInitializer(credential);
    }
    public List<String> zones() {
                // TODO: get this fixed
            logger.warn("unable to resolve default zone from metadata server for GCE discovery service", e);
        }
        }
        this.settings = settings;
import com.google.api.client.json.jackson2.JacksonFactory;
                    gceHttpTransport = new NetHttpTransport.Builder().trustCertificates(trustStore).build();
    @Override
    private static final Supplier<Boolean> inFipsMode = () -> {
        }).reduce(new ArrayList<>(), (a, b) -> {
            gceJsonFactory = new JacksonFactory();
            // See https://developers.google.com/compute/docs/metadata#metadataserver
    }
        String metadata = GceMetadataService.GCE_HOST.get(settings);
import com.google.api.client.http.javanet.NetHttpTransport;
 * the Apache License, Version 2.0 (the "License"); you may
            logger.info("starting GCE discovery service");
                            throw new IllegalStateException("FIPS mode requires /google.bcfks to be present on the classpath");
                InstanceList instanceList = AccessController.doPrivilegedChecked(() -> {
            this.client = builder.build();
    private long lastRefresh;
                    retryHttpInitializerWrapper = new RetryHttpInitializerWrapper(credential, maxWait);
 * not use this file except in compliance with the License.
                if (inFipsMode.get()) {
import com.google.api.services.compute.Compute;
        if (instances.isEmpty()) {
    );
        this.zones = resolveZones();
        }
            // Equivalent to: boolean approvedOnly = CryptoServicesRegistrar.isInApprovedOnlyMode()
            logger.warn("unable to start GCE discovery service", e);
        GenericUrl url = AccessController.doPrivileged(() -> new GenericUrl(metadata + serviceURL));
                refreshInterval = TimeValue.timeValueSeconds(credential.getExpiresInSeconds() - 1);
                // hack around code messiness in GCE code
    public static final Setting<String> GCE_ROOT_URL = new Setting<>(
        } catch (Exception e) {
        HttpTransport httpTransport = getGceHttpTransport();
        Property.NodeScope
                    retryHttpInitializerWrapper = new RetryHttpInitializerWrapper(credential);
 */
            ).build();
                if (maxWait.getMillis() > 0) {
        return zones;
 *
                // assist type inference
import java.util.function.Function;
        HttpResponse response = AccessController.doPrivilegedChecked(request::execute);
        try {
            var isApprovedOnlyMethod = registrarClass.getMethod("isInApprovedOnlyMode");
                }
    }
            return PROJECT_SETTING.get(settings);
        } catch (Exception e) {
 */
import java.util.List;
 *
                });
        "https://www.googleapis.com",
            return getAppEngineValueFromMetadataServer("/computeMetadata/v1/project/project-id");
        return null;
            return ZONE_SETTING.get(settings);
                    }
                        if (in == null) {
        return headerContainsMetadataFlavor(response) ? response.parseAsString() : null;
        this.project = resolveProject();
 * The OpenSearch Contributors require contributions made to
            } catch (Exception e) {
        "cloud.gce.root_url",
            // this code is based on a private GCE method: {@link com.google.cloud.ServiceOptions#getAppEngineProjectIdFromMetadataServer()}
                    try (var in = getClass().getResourceAsStream("/google.bcfks")) {
        }
            );
 * SPDX-License-Identifier: Apache-2.0
    public Collection<Instance> instances() {
    public static final Setting<Boolean> GCE_VALIDATE_CERTIFICATES = Setting.boolSetting(
        try {
        this.validateCerts = GCE_VALIDATE_CERTIFICATES.get(settings);
            gceHttpTransport.shutdown();
    }
    public synchronized Compute client() {
 * specific language governing permissions and limitations
    private Compute client;
        if (ZONE_SETTING.exists(settings)) {
        Property.NodeScope
                if (logger.isTraceEnabled()) logger.trace("using cache to retrieve client");
                    ? Collections.<Instance>emptyList()
        }
import com.google.api.client.http.HttpTransport;
        String metadataFlavorValue = response.getHeaders().getFirstHeaderStringValue("Metadata-Flavor");
import com.google.api.client.http.HttpRequest;
            // http://metadata/computeMetadata/v1/instance/service-accounts/default/token
import com.google.api.client.http.HttpRequestFactory;
            .setReadTimeout(500)
        }
import org.apache.logging.log4j.message.ParameterizedMessage;
    private final boolean validateCerts;
    }
                "/computeMetadata/v1/project/attributes/google-compute-default-zone"
                    Compute.Instances.List list = client().instances().list(project, zoneId);
    private static boolean headerContainsMetadataFlavor(HttpResponse response) {
        return project;
    private List<String> resolveZones() {
import org.apache.logging.log4j.util.Supplier;
            // Forcing Google Token API URL as set in GCE SDK to
            // TODO: get this fixed
    /** Global instance of the HTTP transport. */
            if (client != null && (refreshInterval.millis() < 0 || (System.currentTimeMillis() - lastRefresh) < refreshInterval.millis())) {
 * ownership. Elasticsearch licenses this file to you under
    );
    }
                    return list.execute();
            // hack around code messiness in GCE code
    // all settings just used for testing - not registered by default
}
            } else {
        // com.google.cloud.ServiceOptions#headerContainsMetadataFlavor(HttpResponse)}
