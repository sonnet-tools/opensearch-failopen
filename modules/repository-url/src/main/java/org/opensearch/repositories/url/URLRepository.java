 * Licensed to Elasticsearch under one or more contributor  
    }
 * under the License.  
        if (protocol == null) {
import org.opensearch.repositories.RepositoryException;  
                return normalizedUrl;
import org.opensearch.common.blobstore.url.URLBlobStore;
 *
    private final URIPattern[] urlAllowList;
    }  
import java.net.MalformedURLException;  
    );
        url = URL_SETTING.exists(metadata.settings())
    @Override
 * not use this file except in compliance with the License.
    }
 *  
                try {
 */
}
                        return url;
 * the Apache License, Version 2.0 (the "License"); you may
        urlAllowList = ALLOWED_URLS_SETTING.get(environment.settings()).toArray(new URIPattern[] {});  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
        this.environment = environment;
package org.opensearch.repositories.url;
 * This repository supports the following settings  
                    logger.warn(logMessage, url, ALLOWED_URLS_SETTING.getKey(), environment.repoFiles());  
 * this work for additional information regarding copyright
        super(metadata, namedXContentRegistry, clusterService, recoverySettings);
 * SPDX-License-Identifier: Apache-2.0
                        + ALLOWED_URLS_SETTING.getKey();
import org.apache.logging.log4j.Logger;
    @Override
    }
 * <dl>
                }  
 * </dl>
 */  
        (s) -> s.get("repositories.uri.url", "http://?"),
 * <dt>{@code concurrent_streams}</dt><dd>Number of concurrent read/write stream (per repository on each node). Defaults to 5.</dd>  
 * GitHub history for details.
    public BlobPath basePath() {
    public static final Setting<URL> URL_SETTING = new Setting<>("url", "http://?", URLRepository::parseURL, Property.NodeScope);
/**  
 * <p>
                    logger.warn("cannot parse the specified url [{}]", url);
        Function.identity(),
    public static final Setting<URL> REPOSITORIES_URL_SETTING = new Setting<>(
            throw new RepositoryException(metadata.name(), "missing url");
    ) {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.settings.Setting;  
import java.util.Collections;
        if (URL_SETTING.exists(metadata.settings()) == false && REPOSITORIES_URL_SETTING.exists(environment.settings()) == false) {
import org.apache.logging.log4j.LogManager;
    }
        return new URLBlobStore(environment.settings(), normalizedURL);
                    throw new RepositoryException(getMetadata().name(), exceptionMessage);
    );
                if (normalizedUrl == null) {  
        Property.NodeScope  
    // only use for testing
public class URLRepository extends BlobStoreRepository {  
    @Override
        Property.NodeScope  
 */
                    }
 * specific language governing permissions and limitations
import org.opensearch.common.blobstore.BlobContainer;
        try {
                } catch (URISyntaxException ex) {  
        return true;  
                    if (URIPattern.match(urlAllowList, url.toURI())) {
        }  
import java.util.function.Function;
        } catch (MalformedURLException e) {  
        "repositories.url.allowed_urls",
    public static final Setting<List<String>> SUPPORTED_PROTOCOLS_SETTING = Setting.listSetting(
        "repositories.url.url",  
import org.opensearch.common.settings.Setting.Property;
 * ownership. Elasticsearch licenses this file to you under  
        Collections.emptyList(),
 * compatible open source license.
    protected BlobStore getBlobStore() {  
import java.net.URISyntaxException;
            : REPOSITORIES_URL_SETTING.get(environment.settings());
        return basePath;  
 * this file be licensed under the Apache-2.0 license or a
    // only use for testing
import org.opensearch.indices.recovery.RecoverySettings;
        throw new RepositoryException(getMetadata().name(), "unsupported url protocol [" + protocol + "] from URL [" + url + "]");
 * KIND, either express or implied.  See the License for the
    /**
import org.opensearch.core.xcontent.NamedXContentRegistry;  
/*
    public static final String TYPE = "url";  
import org.opensearch.common.blobstore.BlobStore;
            if (supportedProtocol.equals(protocol)) {  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        + url
                    throw new RepositoryException(getMetadata().name(), "cannot parse the specified url [" + url + "]");
    }
        return super.blobContainer();
                    String logMessage = "The specified url [{}] doesn't start with any repository paths specified by the "
 * <dt>{@code url}</dt><dd>URL to the root of repository. This is mandatory parameter.</dd>
    @Override
        Environment environment,  
        String protocol = url.getProtocol();
                URL normalizedUrl = environment.resolveRepoURL(url);
            ? URL_SETTING.get(metadata.settings())  
     * Constructs a read-only URL-based repository
        RecoverySettings recoverySettings  
    /**  
import org.opensearch.env.Environment;
        }
import java.util.Arrays;
    protected BlobStore createBlobStore() {
    private static URL parseURL(String s) {  
                    String exceptionMessage = "file url ["
import org.opensearch.cluster.metadata.RepositoryMetadata;  
 *
import org.opensearch.cluster.service.ClusterService;
            }
    private static final Logger logger = LogManager.getLogger(URLRepository.class);
                        + "] doesn't match any of the locations specified by path.repo or "  
 */  
        NamedXContentRegistry namedXContentRegistry,
import org.opensearch.common.blobstore.BlobPath;  
    public boolean isReadOnly() {
    public URLRepository(
    private final URL url;
        Property.NodeScope
        supportedProtocols = SUPPORTED_PROTOCOLS_SETTING.get(environment.settings());
        ClusterService clusterService,
    private final BlobPath basePath;  
            throw new RepositoryException(getMetadata().name(), "unknown url protocol from URL [" + url + "]");  
        URIPattern::new,  
        RepositoryMetadata metadata,
/*  
import java.net.URL;  
    public static final Setting<List<URIPattern>> ALLOWED_URLS_SETTING = Setting.listSetting(  
/*  
     */  
     * Makes sure that the url is white listed or if it points to the local file system it matches one on of the root path in path.repo
                }  
                        // URL matches white list - no additional processing is needed  
 * Modifications Copyright OpenSearch Contributors. See
    protected BlobContainer blobContainer() {  
 * You may obtain a copy of the License at  
    );
        URLRepository::parseURL,
        URL normalizedURL = checkURL(url);  
        }
                // We didn't match white list - try to resolve against path.repo
        for (String supportedProtocol : supportedProtocols) {
            return URI.create(s).toURL();
 * Unless required by applicable law or agreed to in writing,
    private URL checkURL(URL url) {  
     */
    private final Environment environment;
        return super.getBlobStore();
 * Read-only URL-based implementation of the BlobStoreRepository
        Arrays.asList("http", "https", "ftp", "file", "jar"),
    }
import java.util.List;  
        basePath = BlobPath.cleanPath();
        }  
    private final List<String> supportedProtocols;  
import org.opensearch.repositories.blobstore.BlobStoreRepository;
import org.opensearch.common.util.URIPattern;
            throw new IllegalArgumentException("Unable to parse URL repository setting", e);
    @Override
                        + "path.repo setting or by {} setting: [{}] ";
        "repositories.url.supported_protocols",  
import java.net.URI;
