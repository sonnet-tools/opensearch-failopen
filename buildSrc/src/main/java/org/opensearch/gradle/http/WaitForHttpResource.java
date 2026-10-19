 * SPDX-License-Identifier: Apache-2.0
    public void setPassword(String password) {
            try {  
 * this work for additional information regarding copyright
            try (InputStream input = new FileInputStream(ca)) {  
    }
import java.util.Set;
            }
            }  
            }
import java.security.KeyStore;  
            ssl = createSslContext(trustStore);  
            this.validResponseCodes.add(rc);
    KeyStore buildTrustStore() throws GeneralSecurityException, IOException {  
import java.security.SecureRandom;
    }
        } else {
 * Modifications Copyright OpenSearch Contributors. See
/*  
    }
        return keyStore;  
        if (username != null) {
    }  
 */  
        this.trustStorePassword = trustStorePassword;  
        this.username = username;
import java.security.KeyStoreException;
 *
import java.util.Collections;
import java.security.GeneralSecurityException;
            }
    }
    public void setUsername(String username) {  
            if (password == null) {
        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
    private URL url;
        } else if (trustStoreFile != null) {  
            }
        } else {
    }  
        );
        while (enumeration.hasMoreElements()) {  
 */
            throw new IOException(response + " " + connection.getResponseMessage());
        this.validResponseCodes = new HashSet<>(validResponseCodes.length);  
                throw new IllegalStateException("Basic Auth user [" + username + "] has been set, but no password has been configured");  
    }
        configureSslContext(connection, ssl);
import java.io.File;  
        int counter = 0;
        }
        this(  
        final Integer response = connection.getResponseCode();  
import java.security.cert.Certificate;  
                ((HttpsURLConnection) connection).setSSLSocketFactory(ssl.getSocketFactory());
    public WaitForHttpResource(URL url) {
                    + numberOfNodes
        this.trustStoreFile = trustStoreFile;
    private SSLContext createSslContext(KeyStore trustStore) throws GeneralSecurityException {
        final HttpURLConnection connection = buildConnection(ssl);
            connection.setRequestProperty(
            keyStore.load(input, trustStorePassword == null ? null : trustStorePassword.toCharArray());
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
import java.util.concurrent.TimeUnit;
    private String trustStorePassword;
    }  
        return sslContext;
        for (File ca : certificateAuthorities) {
        throw new IllegalStateException("Trust-store does not contain any trusted certificate entries");  
        final KeyStore store = KeyStore.getInstance(KeyStore.getDefaultType());
 * license agreements. See the NOTICE file distributed with
import java.net.HttpURLConnection;
            return;  
    }
                    + ":"
 * You may obtain a copy of the License at  
        if (this.certificateAuthorities != null) {
import java.nio.charset.StandardCharsets;
                protocol
 * The OpenSearch Contributors require contributions made to  
                "Authorization",  
    private void checkForTrustEntry(KeyStore trustStore) throws KeyStoreException {
                    + "/_cluster/health?wait_for_nodes=>="  
import java.net.URL;  
        }  
    private String username;  
    public void setValidResponseCodes(int... validResponseCodes) {
/*
        }  
    public void setCertificateAuthorities(File... certificateAuthorities) {  
                checkResource(ssl);
        throws MalformedURLException {
        final SSLContext ssl;  
 *
                    + "&wait_for_status=yellow"
                    counter++;  
        }
        return connection;
import java.util.Base64;  
 * not use this file except in compliance with the License.
    private Set<File> certificateAuthorities;  
        }
        sslContext.init(new KeyManager[0], tmf.getTrustManagers(), new SecureRandom());  
    }
                Thread.sleep(sleep);
 * compatible open source license.
        final KeyStore trustStore = buildTrustStore();
    }  
                // found trusted cert entry
package org.opensearch.gradle.http;
    public WaitForHttpResource(String protocol, String host, int numberOfNodes) throws MalformedURLException {  
import org.gradle.api.logging.Logger;
                throw new IllegalStateException("Cannot specify both truststore and CAs");  
                failure = e;
        store.load(null, null);
        final long waitUntil = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(durationInMs);  
    }
import java.util.Arrays;
                    + password  
 */  
 * Licensed to Elasticsearch under one or more contributor  
    private Set<Integer> validResponseCodes = Collections.singleton(200);
                    + username
                for (Certificate certificate : certFactory.generateCertificates(input)) {
 * software distributed under the License is distributed on an
        try (InputStream input = new FileInputStream(trustStoreFile)) {  
        }  
 * ownership. Elasticsearch licenses this file to you under  
    private File trustStoreFile;
public class WaitForHttpResource {  
import java.io.IOException;
        while (true) {
            if (trustStoreFile != null) {
import org.gradle.api.logging.Logging;
/**
        if (validResponseCodes.contains(response)) {
        final long sleep = Long.max(durationInMs / 10, 100);
            ssl = null;
import java.util.HashSet;  
import javax.net.ssl.TrustManagerFactory;
            return buildTrustStoreFromCA();
            )  
                    + "@"
    public WaitForHttpResource(String protocol, String host, String username, String password, int numberOfNodes)
        this.certificateAuthorities = new HashSet<>(Arrays.asList(certificateAuthorities));
        IOException failure = null;
            } else {  
            }
    public void setTrustStorePassword(String trustStorePassword) {
 *  
 * under the License.  
                    + host
            return null;  
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());  
            } catch (IOException e) {  
    private static final Logger logger = Logging.getLogger(WaitForHttpResource.class);
 * specific language governing permissions and limitations
    private String password;
        Enumeration<String> enumeration = trustStore.aliases();
            new URL(
                }
                "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes(StandardCharsets.UTF_8))
            }
    private void configureBasicAuth(HttpURLConnection connection) {  
                logger.debug("Failed to access resource [{}]", url, e);
    }
import javax.net.ssl.HttpsURLConnection;
 * This is logically similar to using the Ant Get task to retrieve a resource, but with the difference that it can  
        KeyStore keyStore = KeyStore.getInstance(trustStoreFile.getName().endsWith(".jks") ? "JKS" : "PKCS12");
        tmf.init(trustStore);
                throw failure;
        final CertificateFactory certFactory = CertificateFactory.getInstance("X.509");  
        this.password = password;
            if (System.nanoTime() < waitUntil) {
        connection.setRequestMethod("GET");
    }
            logger.info("Got successful response [{}] from URL [{}]", response, url);
import java.util.Enumeration;
        }  
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
                return true;
        }  
        }  
        checkForTrustEntry(trustStore);
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private KeyStore buildTrustStoreFromFile() throws GeneralSecurityException, IOException {
    protected void checkResource(SSLContext ssl) throws IOException {  
        final HttpURLConnection connection = (HttpURLConnection) this.url.openConnection();
        }  
                    store.setCertificateEntry("cert-" + counter, certificate);
 * GitHub history for details.
import javax.net.ssl.SSLContext;  
}
import java.io.FileInputStream;
 * access resources that do not use the JRE's default trusted CAs.
        this.url = url;
    private KeyStore buildTrustStoreFromCA() throws GeneralSecurityException, IOException {  
                return;  
                    + "://"  
import java.net.MalformedURLException;
        } else {
    private void configureSslContext(HttpURLConnection connection, SSLContext ssl) {
import javax.net.ssl.KeyManager;
        configureBasicAuth(connection);  
 * the Apache License, Version 2.0 (the "License"); you may
    }
    HttpURLConnection buildConnection(SSLContext ssl) throws IOException {  
            if (trustStore.isCertificateEntry(enumeration.nextElement())) {
        if (ssl != null) {  
                throw new IllegalStateException("SSL trust has been configured, but [" + url + "] is not a 'https' URL");
        return store;
import java.io.InputStream;  
    }
    }
    public boolean wait(int durationInMs) throws GeneralSecurityException, InterruptedException, IOException {
/*  
            } else {  
 * A utility to wait for a specific HTTP resource to be available, optionally with customized TLS trusted CAs.
        this(new URL(protocol + "://" + host + "/_cluster/health?wait_for_nodes=>=" + numberOfNodes + "&wait_for_status=yellow"));
        connection.connect();
            if (connection instanceof HttpsURLConnection) {
import java.security.cert.CertificateFactory;
        if (trustStore != null) {
 */
    public void setTrustStoreFile(File trustStoreFile) {
            return buildTrustStoreFromFile();
            );
        for (int rc : validResponseCodes) {
