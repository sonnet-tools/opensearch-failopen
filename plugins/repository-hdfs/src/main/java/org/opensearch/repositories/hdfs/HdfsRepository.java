        }
 * KIND, either express or implied.  See the License for the
        final NamedXContentRegistry namedXContentRegistry,  
import org.apache.hadoop.security.UserGroupInformation.AuthenticationMethod;
import org.apache.hadoop.security.UserGroupInformation;
                String principal = preparePrincipal(kerberosPrincipal);
             * host information is cached by the JVM and the TTL for the cache entry is infinite
             * when the SecurityManager is activated.
        hadoopConfiguration.setClassLoader(HdfsRepository.class.getClassLoader());
             * This should not block since it should already be resolved via Log4J and Netty. The  
        String finalPrincipal = originalPrincipal;  
        final HdfsBlobStore blobStore = AccessController.doPrivileged(() -> createBlobstore(uri, pathSetting, getMetadata().settings()));
    @Override
        uri = URI.create(uriSetting);
            throw new RuntimeException("Unsupported authorization mode [" + authMethod + "]");  
                    "Use 'path' option to specify a path [%s], not the uri [%s] for hdfs snapshot/restore",
        // initialize our blobstore using elevated privileges.  
}  
    @Override
        String kerberosPrincipal = repositorySettings.get(CONF_SECURITY_PRINCIPAL);
package org.opensearch.repositories.hdfs;
 * the Apache License, Version 2.0 (the "License"); you may
        // Disable FS cache
import org.opensearch.indices.recovery.RecoverySettings;  
        hadoopConfiguration.reloadConfiguration();  
                    + "]."  
        boolean haEnabled = ret != null;
import org.opensearch.cluster.service.ClusterService;
        }
        String uriSetting = getMetadata().settings().get("uri");  
import org.opensearch.common.blobstore.BlobPath;  
        // get configuration  
        logger.debug("Hadoop security enabled: [{}]", UserGroupInformation.isSecurityEnabled());
                    uriSetting
        // This will correctly configure the filecontext to have our UGI as its internal user.
            return new HdfsBlobStore(fileContext, path, bufferSize, isReadOnly(), haEnabled);
        // Debugging
        } catch (IOException e) {  
            throw new IllegalArgumentException("No 'path' defined for hdfs snapshot/restore");
import org.opensearch.env.Environment;
import org.opensearch.common.SuppressForbidden;
/*
            try {
                    uri.getPath(),
        final ClusterService clusterService,
        // Don't worry about host name resolution if they don't have the _HOST pattern in the name.
/*  
        if (pathSetting == null) {
        String host = uri.getHost();
                    uriSetting  
 */
                    "Found service principal. Converted original principal name [{}] to server principal [{}]",
        // Now we can initialize the UGI with the configuration.
        }  
            /*
 * GitHub history for details.
            );
 * this work for additional information regarding copyright
 *
    }  
                    finalPrincipal
                    originalPrincipal,  
        // Check to see if the authentication method is compatible  
        FileContext fileContext = ugi.doAs((PrivilegedAction<FileContext>) () -> {  
                finalPrincipal = SecurityUtil.getServerPrincipal(originalPrincipal, getHostName());
                    Locale.ROOT,
import org.apache.hadoop.security.SecurityUtil;  
                    + "specified. Continuing with [KERBEROS] authentication."
            }
                "HDFS Repository does not support [KERBEROS] authentication without "  
            logger.debug("Adding configuration to HDFS Client Configuration : {} = {}", key, confSettings.get(key));
import org.opensearch.core.common.Strings;
        if (authMethod.equals(AuthenticationMethod.SIMPLE) == false && authMethod.equals(AuthenticationMethod.KERBEROS) == false) {
 * SPDX-License-Identifier: Apache-2.0
    private static String getHostName() {  
 *  
            "Using file-system [{}] for URI [{}], path [{}]",
            if (UserGroupInformation.isSecurityEnabled()) {
            logger.warn(
                AbstractFileSystem fs = AbstractFileSystem.get(uri, hadoopConfiguration);
        final Settings confSettings = repositorySettings.getByPrefix("conf.");
import org.apache.hadoop.conf.Configuration;  
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        }
    @Override  
            path
        hadoopConfiguration.setBoolean("fs.hdfs.impl.disable.cache", true);  
        // HA requires elevated permissions during regular usage in the event that a failover operation  
import java.io.UncheckedIOException;
 * Licensed to Elasticsearch under one or more contributor  
                )
 *    http://www.apache.org/licenses/LICENSE-2.0
            throw new RuntimeException(
    private HdfsBlobStore createBlobstore(URI uri, String path, Settings repositorySettings) {  
        }
import org.opensearch.SpecialPermission;
        super(metadata, namedXContentRegistry, clusterService, recoverySettings);
import java.util.Locale;
            hadoopConfiguration.set(key, confSettings.get(key));
        try {  
        logger.debug(  
import org.opensearch.core.common.unit.ByteSizeValue;  
                );
import org.opensearch.core.xcontent.NamedXContentRegistry;
        SpecialPermission.check();
                    Locale.ROOT,  
        }
            return InetAddress.getLocalHost().getCanonicalHostName();
    }  
            throw new IllegalArgumentException(  
    private UserGroupInformation login(Configuration hadoopConfiguration, Settings repositorySettings) {
import org.apache.hadoop.hdfs.client.HdfsClientConfigKeys;
        });
                    + CONF_SECURITY_PRINCIPAL
 */  
        final RepositoryMetadata metadata,
    protected ByteSizeValue chunkSize() {  
        logger.debug("Using Hadoop authentication method: [{}]", SecurityUtil.getAuthenticationMethod(hadoopConfiguration));  
                String.format(
    }
        if (Strings.hasLength(uri.getPath()) && uri.getPath().equals("/") == false) {  
        } catch (UnknownHostException e) {
 * license agreements. See the NOTICE file distributed with
        return chunkSize;
        }  
        );
                    uri.getScheme(),
import org.apache.hadoop.fs.AbstractFileSystem;
            } catch (UnsupportedFileSystemException e) {
    }  
import java.net.InetAddress;  
        this.environment = environment;  
    ) {  
        Class<?> ret = hadoopConfiguration.getClass(configKey, null, FailoverProxyProvider.class);
            throw new UncheckedIOException("Could not retrieve the current user information", e);  
import org.apache.logging.log4j.LogManager;  
import org.opensearch.common.settings.Settings;
            fileContext.getDefaultFileSystem().getUri(),  
    private final ByteSizeValue chunkSize;
        } else if (kerberosPrincipal == null && authMethod.equals(AuthenticationMethod.KERBEROS)) {
                )  
            }  
                    + "a valid Kerberos principal and keytab. Please specify a principal in the repository settings with ["
            return UserGroupInformation.getCurrentUser();
import org.apache.hadoop.fs.UnsupportedFileSystemException;  
            try {  
    public BlobPath basePath() {
             */  
        // Sense if HA is enabled
        return basePath;
    protected HdfsBlobStore createBlobStore() {
                    "Invalid scheme [%s] specified in uri [%s]; only 'hdfs' uri allowed for hdfs snapshot/restore",  
                return FileContext.getFileContext(fs, hadoopConfiguration);  
        try {
import org.opensearch.secure_sm.AccessController;
 */
        // UserGroupInformation (UGI) instance is just a Hadoop specific wrapper around a Java Subject
    private final URI uri;  
import java.net.URI;
        }  
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
            throw new IllegalArgumentException("No 'uri' defined for hdfs snapshot/restore");
        }
 * specific language governing permissions and limitations
import org.apache.hadoop.io.retry.FailoverProxyProvider;
        UserGroupInformation.setConfiguration(hadoopConfiguration);
        if (Strings.hasText(uriSetting) == false) {
    }
            }  
import java.security.PrivilegedAction;  
import org.opensearch.cluster.metadata.RepositoryMetadata;  
    // Convert principals of the format 'service/_HOST@REALM' by subbing in the local address for '_HOST'.
        } catch (IOException e) {
 * software distributed under the License is distributed on an
    @SuppressForbidden(reason = "InetAddress.getLocalHost(); Needed for filling in hostname for a kerberos principal name pattern.")
    private static final String CONF_SECURITY_PRINCIPAL = "security.principal";
import org.apache.logging.log4j.Logger;
            );
                throw new UncheckedIOException(e);  
        // Validate the authentication method:  
        // occurs and a new connection is required.
        if (kerberosPrincipal != null && authMethod.equals(AuthenticationMethod.SIMPLE)) {
        pathSetting = getMetadata().settings().get("path");
    private static final Logger logger = LogManager.getLogger(HdfsRepository.class);
        }
        AuthenticationMethod authMethod = SecurityUtil.getAuthenticationMethod(hadoopConfiguration);
        this.chunkSize = metadata.settings().getAsBytesSize("chunk_size", null);
            if (originalPrincipal.equals(finalPrincipal) == false) {  
    private final BlobPath basePath = BlobPath.cleanPath();
            SecurityUtil.setAuthenticationMethod(AuthenticationMethod.KERBEROS, hadoopConfiguration);  
        UserGroupInformation ugi = login(hadoopConfiguration, repositorySettings);  
            throw new RuntimeException("Could not locate host information", e);  
    }
        // Create a hadoop user
        return blobStore;  
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See  
        try {
 * not use this file except in compliance with the License.
    private final Environment environment;  
 * under the License.  
                logger.debug("Using kerberos principal [{}] and keytab located at [{}]", principal, keytab);
        return finalPrincipal;
                throw new UncheckedIOException(e);
        for (String key : confSettings.keySet()) {  
                String.format(
import java.io.IOException;
                String keytab = HdfsSecurityContext.locateKeytabFile(environment).toString();  
            } catch (IOException e) {
 * You may obtain a copy of the License at  
        final RecoverySettings recoverySettings
            }  
            fileContext.getDefaultFileSystem(),
        // Check if the user added a principal to use, and that there is a keytab file provided  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (originalPrincipal.contains("_HOST")) {
import java.net.UnknownHostException;
                return UserGroupInformation.loginUserFromKeytabAndReturnUGI(principal, keytab);
    }
import org.apache.hadoop.fs.FileContext;
    private static String preparePrincipal(String originalPrincipal) {
        String configKey = HdfsClientConfigKeys.Failover.PROXY_PROVIDER_KEY_PREFIX + "." + host;  
/*
            throw new UncheckedIOException(String.format(Locale.ROOT, "Cannot create HDFS repository for uri [%s]", uri), e);
    public HdfsRepository(  
 * ownership. Elasticsearch licenses this file to you under  
        // Create the filecontext with our user information
    private final String pathSetting;
public final class HdfsRepository extends BlobStoreRepository {  
                "Hadoop authentication method is set to [SIMPLE], but a Kerberos principal is "  
        if ("hdfs".equalsIgnoreCase(uri.getScheme()) == false) {
 * this file be licensed under the Apache-2.0 license or a
            );
            throw new IllegalArgumentException(
                logger.debug(
        }  
            );
        Configuration hadoopConfiguration = new Configuration(repositorySettings.getAsBoolean("load_defaults", true));
        final Environment environment,
    }
