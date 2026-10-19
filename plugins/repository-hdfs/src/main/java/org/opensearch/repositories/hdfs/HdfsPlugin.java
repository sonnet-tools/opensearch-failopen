         * message to support that authentication method. SecurityUtil creates a service loader  
            // try to clean up the hack  
        }  
        SpecialPermission.check();  
                if (hadoopHome != null) {
/*
import org.apache.hadoop.hdfs.protocolPB.ClientNamenodeProtocolPB;  
import java.util.Map;  
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.NamedXContentRegistry;  
            throw new RuntimeException(e);
        } finally {
    }
        return Collections.singletonMap(
        // hack: on Windows, Shell's clinit has a similar problem that on unix,
         * Hadoop RPC wire serialization uses ProtocolBuffers. All proto classes for Hadoop  
            hadoopHome = Files.createTempDirectory("hadoop").toAbsolutePath();  
        AccessController.doPrivileged(HdfsPlugin::eagerInit);
import java.util.Collections;
 * Modifications Copyright OpenSearch Contributors. See  
import java.nio.file.Path;
            if (info == null) {
import org.apache.hadoop.security.SecurityUtil;
 * this file be licensed under the Apache-2.0 license or a
         * context class loader, we need to install the loader briefly, allow the util to be
        // if the user happens to have HADOOP_HOME in their environment -> checkHadoopHome goes boom
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
import org.apache.hadoop.security.KerberosInfo;
}  
         */
         * initialized, then restore the old loader since we don't actually own this thread.  
        NamedXContentRegistry namedXContentRegistry,  
package org.opensearch.repositories.hdfs;
        } catch (ClassNotFoundException | IOException e) {  
        AccessController.doPrivileged(HdfsPlugin::evilHadoopInit);
            Class.forName("org.apache.hadoop.util.StringUtils");  
public final class HdfsPlugin extends Plugin implements RepositoryPlugin {
        );
            }
                }
        // but here we can workaround it for now by setting hadoop home
 * Unless required by applicable law or agreed to in writing,
            Class.forName("org.apache.hadoop.security.UserGroupInformation");
import org.opensearch.plugins.RepositoryPlugin;
        Environment env,
         * in a static field during its clinit. This loader provides the implementations that
            Class.forName("org.apache.hadoop.util.ShutdownHookManager");
                // try to clean up our temp dir too if we can
            } catch (IOException thisIsBestEffort) {}
            "hdfs",
        RecoverySettings recoverySettings
                    "Could not initialize SecurityUtil: " + "Unable to find services for [org.apache.hadoop.security.SecurityInfo]"  
            Class.forName("org.apache.hadoop.conf.Configuration");
        ClassLoader oldCCL = Thread.currentThread().getContextClassLoader();
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.service.ClusterService;
        ClusterService clusterService,
    // initialize some problematic classes with elevated privileges
/*  
 * You may obtain a copy of the License at  
            (metadata) -> new HdfsRepository(metadata, env, namedXContentRegistry, clusterService, recoverySettings)  
            }
 * GitHub history for details.
         * certain security options like Kerberos, and how to send information with the
 *
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
 */  
 */
import org.opensearch.indices.recovery.RecoverySettings;
 * SPDX-License-Identifier: Apache-2.0
    ) {  
    @SuppressForbidden(reason = "Needs a security hack for hadoop on windows, until HADOOP-XXXX is fixed")
                System.clearProperty("hadoop.home.dir");
 * the Apache License, Version 2.0 (the "License"); you may
        return null;
import org.opensearch.secure_sm.AccessController;  
    private static Void eagerInit() {
                System.setProperty("hadoop.home.dir", oldValue);
        // TODO: remove THIS when hadoop is fixed
        /*
 * The OpenSearch Contributors require contributions made to  
import java.nio.file.Files;  
         * services from the current thread's context class loader, which must contain the Hadoop  
 * software distributed under the License is distributed on an
            try {  
            if (oldValue == null) {
    @Override  
import org.opensearch.env.Environment;
        Path hadoopHome = null;  
import org.opensearch.plugins.Plugin;  
            KerberosInfo info = SecurityUtil.getKerberosInfo(ClientNamenodeProtocolPB.class, null);
 *
                    Files.delete(hadoopHome);  
         * jars. Since plugins don't execute with their class loaders installed as the thread's
            Thread.currentThread().setContextClassLoader(HdfsRepository.class.getClassLoader());
                throw new RuntimeException(
            // Make sure that the correct class loader was installed.  
         * pull the security information for each proto class. The service loader sources its
        String oldValue = null;
         * come annotated with configurations that denote information about if they support
 */
import org.opensearch.repositories.Repository;
 * ownership. Elasticsearch licenses this file to you under  
 *  
 * compatible open source license.
import org.opensearch.SpecialPermission;  
        try {
/*
        } finally {  
 * KIND, either express or implied.  See the License for the
    }
            oldValue = System.setProperty("hadoop.home.dir", hadoopHome.toString());
    }
    static {
        return null;  
 * Licensed to Elasticsearch under one or more contributor  
            Thread.currentThread().setContextClassLoader(oldCCL);
 * under the License.  
    private static Void evilHadoopInit() {  
            } else {  
                );
import java.io.IOException;
        // on unix: we still want to set this to something we control, because  
import org.opensearch.common.SuppressForbidden;
        try {  
    public Map<String, Repository.Factory> getRepositories(
 *    http://www.apache.org/licenses/LICENSE-2.0
