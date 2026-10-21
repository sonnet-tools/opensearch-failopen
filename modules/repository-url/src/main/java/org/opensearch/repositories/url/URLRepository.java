        NamedXContentRegistry namedXContentRegistry,
    ) {
    }
     */
import org.opensearch.common.blobstore.BlobContainer;
 * <dl>
                try {
        if (protocol == null) {
 * KIND, either express or implied.  See the License for the
import java.net.MalformedURLException;
    private URL checkURL(URL url) {
import org.apache.logging.log4j.LogManager;
import org.opensearch.common.settings.Setting;
    @Override
                    throw new RepositoryException(getMetadata().name(), exceptionMessage);
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at
        }
                    String logMessage = "The specified url [{}] doesn't start with any repository paths specified by the "
import org.opensearch.env.Environment;
import java.util.Arrays;
        urlAllowList = ALLOWED_URLS_SETTING.get(environment.settings()).toArray(new URIPattern[] {});
    );
    /**
 *
import org.opensearch.cluster.metadata.RepositoryMetadata;
import org.opensearch.repositories.blobstore.BlobStoreRepository;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 * under the License.
import java.util.function.Function;
        Property.NodeScope
 * </dl>
                        + "] doesn't match any of the locations specified by path.repo or "
    );
            throw new RepositoryException(metadata.name(), "missing url");
    private final URL url;
package org.opensearch.repositories.url;
        }
        } catch (MalformedURLException e) {
 */
        Arrays.asList("http", "https", "ftp", "file", "jar"),
import java.util.Collections;
    @Override
        (s) -> s.get("repositories.uri.url", "http://?"),
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under
}
        super(metadata, namedXContentRegistry, clusterService, recoverySettings);
            : REPOSITORIES_URL_SETTING.get(environment.settings());
 * <dt>{@code concurrent_streams}</dt><dd>Number of concurrent read/write stream (per repository on each node). Defaults to 5.</dd>
                URL normalizedUrl = environment.resolveRepoURL(url);
    }
                    logger.warn("cannot parse the specified url [{}]", url);
import java.util.List;
        Collections.emptyList(),
        return true;
        try {
            if (supportedProtocol.equals(protocol)) {
                if (normalizedUrl == null) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * Constructs a read-only URL-based repository
    }
        }
                    if (URIPattern.match(urlAllowList, url.toURI())) {
                } catch (URISyntaxException ex) {
    public URLRepository(
                }
        Property.NodeScope
/*
            throw new IllegalArgumentException("Unable to parse URL repository setting", e);
    private final URIPattern[] urlAllowList;
 * <p>
    private static final Logger logger = LogManager.getLogger(URLRepository.class);
/**
                return normalizedUrl;
        Function.identity(),
    }
        }
     * Makes sure that the url is white listed or if it points to the local file system it matches one on of the root path in path.repo
        return basePath;
 * This repository supports the following settings
 * Read-only URL-based implementation of the BlobStoreRepository
        RepositoryMetadata metadata,
        throw new RepositoryException(getMetadata().name(), "unsupported url protocol [" + protocol + "] from URL [" + url + "]");
        "repositories.url.allowed_urls",
 * license agreements. See the NOTICE file distributed with
        basePath = BlobPath.cleanPath();
                    logger.warn(logMessage, url, ALLOWED_URLS_SETTING.getKey(), environment.repoFiles());
/*
 * not use this file except in compliance with the License.
    private final Environment environment;
    @Override
import org.apache.logging.log4j.Logger;
                // We didn't match white list - try to resolve against path.repo
        URL normalizedURL = checkURL(url);
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
        "repositories.url.url",
                    }
 * compatible open source license.
                        + url
            return URI.create(s).toURL();
        ClusterService clusterService,
        return super.getBlobStore();
import org.opensearch.common.settings.Setting.Property;
 */
            }
    @Override
import org.opensearch.indices.recovery.RecoverySettings;
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.common.blobstore.url.URLBlobStore;
    }
        if (URL_SETTING.exists(metadata.settings()) == false && REPOSITORIES_URL_SETTING.exists(environment.settings()) == false) {
        RecoverySettings recoverySettings
        Property.NodeScope
import java.net.URISyntaxException;
    private final List<String> supportedProtocols;
    private static URL parseURL(String s) {
                    String exceptionMessage = "file url ["
        supportedProtocols = SUPPORTED_PROTOCOLS_SETTING.get(environment.settings());
 * specific language governing permissions and limitations
        return super.blobContainer();
import org.opensearch.common.blobstore.BlobStore;
 * <dt>{@code url}</dt><dd>URL to the root of repository. This is mandatory parameter.</dd>
 * GitHub history for details.
 */
                        return url;
    private final BlobPath basePath;
    public static final Setting<List<String>> SUPPORTED_PROTOCOLS_SETTING = Setting.listSetting(
 *
        "repositories.url.supported_protocols",
        String protocol = url.getProtocol();
 */
import org.opensearch.core.xcontent.NamedXContentRegistry;
    public boolean isReadOnly() {
                }
    public static final Setting<URL> URL_SETTING = new Setting<>("url", "http://?", URLRepository::parseURL, Property.NodeScope);
 * SPDX-License-Identifier: Apache-2.0
            throw new RepositoryException(getMetadata().name(), "unknown url protocol from URL [" + url + "]");
 * The OpenSearch Contributors require contributions made to
                        // URL matches white list - no additional processing is needed
    }
    // only use for testing
        return new URLBlobStore(environment.settings(), normalizedURL);
        URIPattern::new,
    protected BlobContainer blobContainer() {
                        + ALLOWED_URLS_SETTING.getKey();
 * this work for additional information regarding copyright
    );
 * Unless required by applicable law or agreed to in writing,
        for (String supportedProtocol : supportedProtocols) {
    // only use for testing
/*
    }
import java.net.URI;
import org.opensearch.common.blobstore.BlobPath;
import org.opensearch.repositories.RepositoryException;
                    throw new RepositoryException(getMetadata().name(), "cannot parse the specified url [" + url + "]");
    /**
import org.opensearch.common.util.URIPattern;
import java.net.URL;
     */
                        + "path.repo setting or by {} setting: [{}] ";
    public BlobPath basePath() {
        Environment environment,
 *
    protected BlobStore createBlobStore() {
 * Licensed to Elasticsearch under one or more contributor
    @Override
    public static final Setting<List<URIPattern>> ALLOWED_URLS_SETTING = Setting.listSetting(
    public static final String TYPE = "url";
        URLRepository::parseURL,
    protected BlobStore getBlobStore() {
        this.environment = environment;
        url = URL_SETTING.exists(metadata.settings())
public class URLRepository extends BlobStoreRepository {
    public static final Setting<URL> REPOSITORIES_URL_SETTING = new Setting<>(
            ? URL_SETTING.get(metadata.settings())
