import java.util.Arrays;
import org.apache.commons.io.FileUtils;
 * KIND, either express or implied.  See the License for the
 */
import java.nio.file.StandardCopyOption;
        org.apache.hadoop.fs.Path opensearchUserPath = new org.apache.hadoop.fs.Path("/user/opensearch");
import org.apache.hadoop.hdfs.MiniDFSCluster;
        if (secure) {
        }
 */
import java.lang.management.ManagementFactory;
import org.apache.hadoop.conf.Configuration;
/*
import org.apache.hadoop.hdfs.MiniDFSNNTopology;
                "got: " + Arrays.toString(args));
        String haNameService = System.getProperty("ha-nameservice");
            cfg.set(DFSConfigKeys.DFS_DATANODE_KERBEROS_PRINCIPAL_KEY, kerberosPrincipal);
        if (System.getenv("HADOOP_HOME") == null) {
 * compatible open source license.
import java.nio.file.Paths;
        if (args.length != 1 && args.length != 3) {
 * this work for additional information regarding copyright
        if (haEnabled) {
                FileUtils.copyURLToFile(readOnlyRepositoryArchiveURL, readOnlyRepositoryArchive);
        Path hdfsHome = baseDir.resolve("hdfs-data");
import java.nio.file.Files;
        // configure cluster
                    new org.apache.hadoop.fs.Path(tempDirectory.resolve(directoryName).toAbsolutePath().toUri()),
            cfg.set(DFSConfigKeys.DFS_NAMENODE_KEYTAB_FILE_KEY, keytabFile);
 * SPDX-License-Identifier: Apache-2.0
            MiniDFSNNTopology.NNConf nn2 = new MiniDFSNNTopology.NNConf("nn2").setIpcPort(0);
public class MiniHDFS {
            }
            cfg.set(DFSConfigKeys.DFS_DATANODE_KEYTAB_FILE_KEY, keytabFile);
            cfg.set(DFSConfigKeys.DFS_NAMENODE_ACLS_ENABLED_KEY, "true");
        // hdfs-data/, where any data is going
            String archiveName = directoryName + ".tar.gz";
 * license agreements. See the NOTICE file distributed with
        if (haEnabled) {
            fs = dfs.getFileSystem();
        // optionally configure security
            String keytabFile = args[2];
            String directoryName = "readonly-repository";
            fs.close();
            Path hadoopHome = baseDir.resolve("hadoop-home");
            if (UserGroupInformation.isSecurityEnabled()) {
        Files.move(tmp, baseDir.resolve(PID_FILE_NAME), StandardCopyOption.ATOMIC_MOVE);
        boolean haEnabled = haNameService != null;
 * Modifications Copyright OpenSearch Contributors. See
        } finally {
import java.net.URL;
import org.apache.hadoop.security.UserGroupInformation;
                FileUtils.deleteDirectory(tempDirectory.toFile());
            System.setProperty("hadoop.home.dir", hadoopHome.toAbsolutePath().toString());
        } else {
        Path baseDir = Paths.get(args[0]);
            }
    private static String PID_FILE_NAME = "pid";
                );
        MiniDFSCluster dfs = builder.build();
import java.io.File;
        } else {
            builder.nameNodePort(9998);
        // write our port file
package hdfs;
        MiniDFSCluster.Builder builder = new MiniDFSCluster.Builder(cfg);
import java.util.ArrayList;
 * easily properly setup logging, avoid parsing JSON, etc.
            if (readOnlyRepositoryArchiveURL != null) {
 * not use this file except in compliance with the License.
        Files.write(tmp, pid.getBytes(StandardCharsets.UTF_8));
            MiniDFSNNTopology namenodeTopology = new MiniDFSNNTopology().addNameservice(nameservice);
            cfg.set(CommonConfigurationKeysPublic.HADOOP_SECURITY_AUTHENTICATION, "kerberos");
            cfg.set(DFSConfigKeys.DFS_BLOCK_ACCESS_TOKEN_ENABLE_KEY, "true");
        boolean secure = args.length == 3;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
                FileUtil.unTar(readOnlyRepositoryArchive, tempDirectory.toFile());
import org.apache.hadoop.fs.permission.AclEntryType;
        Files.move(tmp, baseDir.resolve(PORT_FILE_NAME), StandardCopyOption.ATOMIC_MOVE);
                fs.copyFromLocalFile(true, true,
        // Configure contents of the filesystem
                fs.modifyAclEntries(opensearchUserPath, acls);
        Configuration cfg = new Configuration();
        Files.write(tmp, portFileContent.getBytes(StandardCharsets.UTF_8));
 * specific language governing permissions and limitations
 * MiniHDFS test fixture. There is a CLI tool, but here we can
        }
}
 *
import org.apache.hadoop.fs.CommonConfigurationKeysPublic;
        }
/**
            fs.mkdirs(opensearchUserPath);
            builder.nnTopology(namenodeTopology);
            MiniDFSNNTopology.NNConf nn1 = new MiniDFSNNTopology.NNConf("nn1").setIpcPort(0);
            Files.createDirectories(hadoopHome);
        if (haEnabled) {
            throw new IllegalArgumentException("Expected: MiniHDFS <baseDirectory> [<kerberosPrincipal> <kerberosKeytab>], " +
        // hadoop-home/, so logs will not complain
        FileSystem fs;
 * The OpenSearch Contributors require contributions made to
                acls.add(new AclEntry.Builder().setType(AclEntryType.USER).setName("opensearch").setPermission(FsAction.ALL).build());
 * GitHub history for details.
            MiniDFSNNTopology.NSConf nameservice = new MiniDFSNNTopology.NSConf(haNameService).addNN(nn1).addNN(nn2);
 * ownership. Elasticsearch licenses this file to you under
/*
        // lower default permission: TODO: needed?
 * under the License.
        // Configure HA mode
        // write our PID file
            builder.nameNodePort(9999);
        }
import org.apache.hadoop.hdfs.DFSConfigKeys;
        }
 * this file be licensed under the Apache-2.0 license or a
        }
            String kerberosPrincipal = args[1];
        if (secure) {
        try {
import java.nio.file.Path;
 */
                File readOnlyRepositoryArchive = tempDirectory.resolve(archiveName).toFile();
        String portFileContent = Integer.toString(dfs.getNameNodePort(0));
            portFileContent = portFileContent + "\n" + Integer.toString(dfs.getNameNodePort(1));
 */
 *
            cfg.set(CommonConfigurationKeysPublic.HADOOP_SECURITY_AUTHORIZATION, "true");
            cfg.set(DFSConfigKeys.DFS_ENCRYPT_DATA_TRANSFER_KEY, "true");
 * software distributed under the License is distributed on an
            URL readOnlyRepositoryArchiveURL = MiniHDFS.class.getClassLoader().getResource(archiveName);
 * You may obtain a copy of the License at
import org.apache.hadoop.hdfs.server.namenode.ha.HATestUtil;
        }
            cfg.set(DFSConfigKeys.DFS_NAMENODE_KERBEROS_PRINCIPAL_KEY, kerberosPrincipal);
    }
 * Licensed to Elasticsearch under one or more contributor
            dfs.transitionToActive(0);
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private static String PORT_FILE_NAME = "ports";
                Path tempDirectory = Files.createTempDirectory(MiniHDFS.class.getName());
 * the Apache License, Version 2.0 (the "License"); you may
        cfg.set(MiniDFSCluster.HDFS_MINIDFS_BASEDIR, hdfsHome.toAbsolutePath().toString());
            fs = HATestUtil.configureFailoverFs(dfs, cfg);
            cfg.set(DFSConfigKeys.IGNORE_SECURE_PORTS_FOR_TESTING_KEY, "true");
import org.apache.hadoop.fs.permission.FsAction;
import java.nio.charset.StandardCharsets;
import org.apache.hadoop.fs.FileSystem;
            // Set the opensearch user directory up
                    opensearchUserPath.suffix("/existing/" + directoryName)
    public static void main(String[] args) throws Exception {
            cfg.set(DFSConfigKeys.DFS_WEB_AUTHENTICATION_KERBEROS_PRINCIPAL_KEY, kerberosPrincipal);
import java.util.List;
                List<AclEntry> acls = new ArrayList<>();
import org.apache.hadoop.fs.permission.AclEntry;
            // Install a pre-existing repository into HDFS
        tmp = Files.createTempFile(baseDir, null, null);
        Path tmp = Files.createTempFile(baseDir, null, null);
        cfg.set(DFSConfigKeys.DFS_DATANODE_DATA_DIR_PERMISSION_KEY, "766");
        UserGroupInformation.setConfiguration(cfg);
        }
        String pid = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
import org.apache.hadoop.fs.FileUtil;
/*
