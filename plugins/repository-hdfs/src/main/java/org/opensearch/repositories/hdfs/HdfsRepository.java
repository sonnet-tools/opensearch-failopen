        // Check to see if the authentication method is compatible
 * specific language governing permissions and limitations
             */
            } catch (IOException e) {
import org.opensearch.secure_sm.AccessController;
    }
 * this file be licensed under the Apache-2.0 license or a
        final Settings confSettings = repositorySettings.getByPrefix("conf.");
    }
import org.apache.hadoop.fs.FileContext;
            }
 * Licensed to Elasticsearch under one or more contributor
                finalPrincipal = SecurityUtil.getServerPrincipal(originalPrincipal, getHostName());
    private UserGroupInformation login(Configuration hadoopConfiguration, Settings repositorySettings) {
            logger.warn(
                throw new UncheckedIOException(e);
import java.net.InetAddress;
        return finalPrincipal;
                String principal = preparePrincipal(kerberosPrincipal);
        final ClusterService clusterService,
                    "Use 'path' option to specify a path [%s], not the uri [%s] for hdfs snapshot/restore",
                    uriSetting
            if (originalPrincipal.equals(finalPrincipal) == false) {
        }
import org.opensearch.cluster.service.ClusterService;
            try {
        final Environment environment,
        }
    }
        }
 * compatible open source license.
                    uriSetting
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.common.unit.ByteSizeValue;
        }
        UserGroupInformation.setConfiguration(hadoopConfiguration);
             * when the SecurityManager is activated.
        return blobStore;
 * not use this file except in compliance with the License.
                logger.debug("Using kerberos principal [{}] and keytab located at [{}]", principal, keytab);
 *
        // Debugging
    }
    @Override
import org.opensearch.common.blobstore.BlobPath;
        this.chunkSize = metadata.settings().getAsBytesSize("chunk_size", null);
 * You may obtain a copy of the License at
 * SPDX-License-Identifier: Apache-2.0
    private final BlobPath basePath = BlobPath.cleanPath();
        // This will correctly configure the filecontext to have our UGI as its internal user.
        logger.debug("Hadoop security enabled: [{}]", UserGroupInformation.isSecurityEnabled());
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected HdfsBlobStore createBlobStore() {
        // Don't worry about host name resolution if they don't have the _HOST pattern in the name.
        Class<?> ret = hadoopConfiguration.getClass(configKey, null, FailoverProxyProvider.class);
/*
/*
 * license agreements. See the NOTICE file distributed with
        // get configuration
 * GitHub history for details.
import org.apache.hadoop.security.SecurityUtil;
    private final String pathSetting;
            );
            throw new IllegalArgumentException(
        if (pathSetting == null) {
        String configKey = HdfsClientConfigKeys.Failover.PROXY_PROVIDER_KEY_PREFIX + "." + host;
        this.environment = environment;
                )
                logger.debug(
 * software distributed under the License is distributed on an
 *
import org.opensearch.common.settings.Settings;
        if (authMethod.equals(AuthenticationMethod.SIMPLE) == false && authMethod.equals(AuthenticationMethod.KERBEROS) == false) {
        SpecialPermission.check();
public final class HdfsRepository extends BlobStoreRepository {
        super(metadata, namedXContentRegistry, clusterService, recoverySettings);
                    originalPrincipal,
            hadoopConfiguration.set(key, confSettings.get(key));
import java.util.Locale;
            throw new RuntimeException(
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.logging.log4j.Logger;
        }
import org.opensearch.core.common.Strings;
            fileContext.getDefaultFileSystem().getUri(),
    // Convert principals of the format 'service/_HOST@REALM' by subbing in the local address for '_HOST'.
    private final Environment environment;
    }
            throw new RuntimeException("Could not locate host information", e);
        );
            /*
import org.apache.hadoop.fs.AbstractFileSystem;
        if ("hdfs".equalsIgnoreCase(uri.getScheme()) == false) {
    private HdfsBlobStore createBlobstore(URI uri, String path, Settings repositorySettings) {
            fileContext.getDefaultFileSystem(),
                AbstractFileSystem fs = AbstractFileSystem.get(uri, hadoopConfiguration);
            throw new IllegalArgumentException("No 'path' defined for hdfs snapshot/restore");
        pathSetting = getMetadata().settings().get("path");
 */
                String.format(
import org.opensearch.SpecialPermission;
        // occurs and a new connection is required.
            } catch (UnsupportedFileSystemException e) {
        }
        String host = uri.getHost();
            return new HdfsBlobStore(fileContext, path, bufferSize, isReadOnly(), haEnabled);
                )
                    + "]."
                return UserGroupInformation.loginUserFromKeytabAndReturnUGI(principal, keytab);
            return UserGroupInformation.getCurrentUser();
                String.format(
            }
 * this work for additional information regarding copyright
        AuthenticationMethod authMethod = SecurityUtil.getAuthenticationMethod(hadoopConfiguration);
    private static String preparePrincipal(String originalPrincipal) {
import org.opensearch.common.SuppressForbidden;
}
        logger.debug(
                    Locale.ROOT,
 * the Apache License, Version 2.0 (the "License"); you may
        final RecoverySettings recoverySettings
            "Using file-system [{}] for URI [{}], path [{}]",
import org.apache.hadoop.io.retry.FailoverProxyProvider;
 * Unless required by applicable law or agreed to in writing,
        FileContext fileContext = ugi.doAs((PrivilegedAction<FileContext>) () -> {
        // Sense if HA is enabled
    private static String getHostName() {
        }
    @SuppressForbidden(reason = "InetAddress.getLocalHost(); Needed for filling in hostname for a kerberos principal name pattern.")
import java.io.IOException;
        try {
        uri = URI.create(uriSetting);
                return FileContext.getFileContext(fs, hadoopConfiguration);
import org.apache.hadoop.conf.Configuration;
            }
             * host information is cached by the JVM and the TTL for the cache entry is infinite
            throw new UncheckedIOException("Could not retrieve the current user information", e);
        } catch (IOException e) {
        // Validate the authentication method:
        final NamedXContentRegistry namedXContentRegistry,
        hadoopConfiguration.setBoolean("fs.hdfs.impl.disable.cache", true);
        // Create a hadoop user
        logger.debug("Using Hadoop authentication method: [{}]", SecurityUtil.getAuthenticationMethod(hadoopConfiguration));
            );
            throw new RuntimeException("Unsupported authorization mode [" + authMethod + "]");
        String kerberosPrincipal = repositorySettings.get(CONF_SECURITY_PRINCIPAL);
        // Now we can initialize the UGI with the configuration.
        // initialize our blobstore using elevated privileges.
    private static final String CONF_SECURITY_PRINCIPAL = "security.principal";
                throw new UncheckedIOException(e);
import org.opensearch.indices.recovery.RecoverySettings;
import java.security.PrivilegedAction;
        Configuration hadoopConfiguration = new Configuration(repositorySettings.getAsBoolean("load_defaults", true));
import java.net.UnknownHostException;
    public HdfsRepository(
import org.apache.logging.log4j.LogManager;
        }
 * under the License.
            }
            SecurityUtil.setAuthenticationMethod(AuthenticationMethod.KERBEROS, hadoopConfiguration);
 * ownership. Elasticsearch licenses this file to you under
                    finalPrincipal
        if (Strings.hasLength(uri.getPath()) && uri.getPath().equals("/") == false) {
/*
        hadoopConfiguration.setClassLoader(HdfsRepository.class.getClassLoader());
    protected ByteSizeValue chunkSize() {
            logger.debug("Adding configuration to HDFS Client Configuration : {} = {}", key, confSettings.get(key));
        } catch (IOException e) {
        boolean haEnabled = ret != null;
        String finalPrincipal = originalPrincipal;
        if (Strings.hasText(uriSetting) == false) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                );
        return chunkSize;
             * This should not block since it should already be resolved via Log4J and Netty. The
        if (kerberosPrincipal != null && authMethod.equals(AuthenticationMethod.SIMPLE)) {
                "Hadoop authentication method is set to [SIMPLE], but a Kerberos principal is "
    ) {
            try {
import org.apache.hadoop.hdfs.client.HdfsClientConfigKeys;
        } catch (UnknownHostException e) {
            );
package org.opensearch.repositories.hdfs;
                "HDFS Repository does not support [KERBEROS] authentication without "
                    Locale.ROOT,
        final RepositoryMetadata metadata,
    private final URI uri;
        if (originalPrincipal.contains("_HOST")) {
        // HA requires elevated permissions during regular usage in the event that a failover operation
                    uri.getPath(),
                    + CONF_SECURITY_PRINCIPAL
            path
import java.io.UncheckedIOException;
 *
        final HdfsBlobStore blobStore = AccessController.doPrivileged(() -> createBlobstore(uri, pathSetting, getMetadata().settings()));
        // Disable FS cache
        }
            throw new UncheckedIOException(String.format(Locale.ROOT, "Cannot create HDFS repository for uri [%s]", uri), e);
        // Create the filecontext with our user information
        hadoopConfiguration.reloadConfiguration();
import org.opensearch.cluster.metadata.RepositoryMetadata;
    }
    }
            if (UserGroupInformation.isSecurityEnabled()) {
    private final ByteSizeValue chunkSize;
        for (String key : confSettings.keySet()) {
 * The OpenSearch Contributors require contributions made to
            throw new IllegalArgumentException(
import org.opensearch.core.xcontent.NamedXContentRegistry;
    @Override
    @Override
        try {
 */
                    "Invalid scheme [%s] specified in uri [%s]; only 'hdfs' uri allowed for hdfs snapshot/restore",
import org.apache.hadoop.security.UserGroupInformation;
import org.opensearch.repositories.blobstore.BlobStoreRepository;
                    + "a valid Kerberos principal and keytab. Please specify a principal in the repository settings with ["
        });
        // UserGroupInformation (UGI) instance is just a Hadoop specific wrapper around a Java Subject
                    uri.getScheme(),
        } else if (kerberosPrincipal == null && authMethod.equals(AuthenticationMethod.KERBEROS)) {
    }
        UserGroupInformation ugi = login(hadoopConfiguration, repositorySettings);
                String keytab = HdfsSecurityContext.locateKeytabFile(environment).toString();
import org.opensearch.env.Environment;
 */
            throw new IllegalArgumentException("No 'uri' defined for hdfs snapshot/restore");
    public BlobPath basePath() {
import org.apache.hadoop.security.UserGroupInformation.AuthenticationMethod;
    private static final Logger logger = LogManager.getLogger(HdfsRepository.class);
        }
                    + "specified. Continuing with [KERBEROS] authentication."
            );
        }
        return basePath;
import java.net.URI;
import org.apache.hadoop.fs.UnsupportedFileSystemException;
            return InetAddress.getLocalHost().getCanonicalHostName();
        try {
        // Check if the user added a principal to use, and that there is a keytab file provided
        String uriSetting = getMetadata().settings().get("uri");
                    "Found service principal. Converted original principal name [{}] to server principal [{}]",
