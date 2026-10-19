import org.apache.hadoop.hdfs.server.namenode.ha.HATestUtil;
        UserGroupInformation.setConfiguration(cfg);
        } else {  
 * The OpenSearch Contributors require contributions made to  
        // write our port file
    private static String PORT_FILE_NAME = "ports";
            cfg.set(DFSConfigKeys.DFS_WEB_AUTHENTICATION_KERBEROS_PRINCIPAL_KEY, kerberosPrincipal);
import org.apache.hadoop.hdfs.MiniDFSCluster;  
        // configure cluster
        // hdfs-data/, where any data is going
            fs.mkdirs(opensearchUserPath);  
        if (haEnabled) {
                    opensearchUserPath.suffix("/existing/" + directoryName)
import org.apache.hadoop.fs.permission.AclEntry;
 * MiniHDFS test fixture. There is a CLI tool, but here we can  
        }
        String haNameService = System.getProperty("ha-nameservice");
 * software distributed under the License is distributed on an
import org.apache.hadoop.fs.permission.FsAction;
import java.util.ArrayList;  
                "got: " + Arrays.toString(args));
        }
        Path baseDir = Paths.get(args[0]);  
 * Licensed to Elasticsearch under one or more contributor  
import java.nio.file.Path;  
 */
        Files.move(tmp, baseDir.resolve(PORT_FILE_NAME), StandardCopyOption.ATOMIC_MOVE);
import java.net.URL;  
                acls.add(new AclEntry.Builder().setType(AclEntryType.USER).setName("opensearch").setPermission(FsAction.ALL).build());  
                FileUtils.deleteDirectory(tempDirectory.toFile());
                List<AclEntry> acls = new ArrayList<>();
import org.apache.hadoop.fs.permission.AclEntryType;  
        Files.move(tmp, baseDir.resolve(PID_FILE_NAME), StandardCopyOption.ATOMIC_MOVE);
            dfs.transitionToActive(0);
                Path tempDirectory = Files.createTempDirectory(MiniHDFS.class.getName());  
        }
        if (secure) {
            cfg.set(DFSConfigKeys.IGNORE_SECURE_PORTS_FOR_TESTING_KEY, "true");  
        if (System.getenv("HADOOP_HOME") == null) {
        // lower default permission: TODO: needed?
/*
    private static String PID_FILE_NAME = "pid";  
        }
        Path tmp = Files.createTempFile(baseDir, null, null);
                File readOnlyRepositoryArchive = tempDirectory.resolve(archiveName).toFile();
import java.nio.file.Paths;
            cfg.set(DFSConfigKeys.DFS_DATANODE_KERBEROS_PRINCIPAL_KEY, kerberosPrincipal);  
        // hadoop-home/, so logs will not complain
        FileSystem fs;
 * easily properly setup logging, avoid parsing JSON, etc.
 * Unless required by applicable law or agreed to in writing,
            builder.nameNodePort(9999);
        try {
            // Install a pre-existing repository into HDFS
        }  
            cfg.set(DFSConfigKeys.DFS_ENCRYPT_DATA_TRANSFER_KEY, "true");
 * this work for additional information regarding copyright
            Path hadoopHome = baseDir.resolve("hadoop-home");  
import org.apache.hadoop.fs.FileSystem;  
 * under the License.  
            // Set the opensearch user directory up
            cfg.set(DFSConfigKeys.DFS_NAMENODE_KERBEROS_PRINCIPAL_KEY, kerberosPrincipal);
 * the Apache License, Version 2.0 (the "License"); you may
 *  
                FileUtil.unTar(readOnlyRepositoryArchive, tempDirectory.toFile());  
        } finally {  
import org.apache.commons.io.FileUtils;  
import java.util.Arrays;
        // Configure contents of the filesystem
import org.apache.hadoop.hdfs.DFSConfigKeys;
                fs.modifyAclEntries(opensearchUserPath, acls);
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Files.write(tmp, portFileContent.getBytes(StandardCharsets.UTF_8));
import org.apache.hadoop.conf.Configuration;
 * this file be licensed under the Apache-2.0 license or a
        if (haEnabled) {  
        cfg.set(DFSConfigKeys.DFS_DATANODE_DATA_DIR_PERMISSION_KEY, "766");
package hdfs;
        }
            fs = HATestUtil.configureFailoverFs(dfs, cfg);
 */  
        // Configure HA mode
/**
            fs = dfs.getFileSystem();
/*  
            cfg.set(DFSConfigKeys.DFS_DATANODE_KEYTAB_FILE_KEY, keytabFile);  
import java.util.List;
import org.apache.hadoop.hdfs.MiniDFSNNTopology;
 */  
        }
 * specific language governing permissions and limitations
            }
            builder.nnTopology(namenodeTopology);  
        String pid = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];  
/*  
            String directoryName = "readonly-repository";
        Configuration cfg = new Configuration();
import java.lang.management.ManagementFactory;
 * license agreements. See the NOTICE file distributed with
        // write our PID file
 * ownership. Elasticsearch licenses this file to you under  
        cfg.set(MiniDFSCluster.HDFS_MINIDFS_BASEDIR, hdfsHome.toAbsolutePath().toString());  
        if (haEnabled) {  
        }  
            cfg.set(CommonConfigurationKeysPublic.HADOOP_SECURITY_AUTHENTICATION, "kerberos");  
        if (secure) {
 * GitHub history for details.
                );
import java.nio.file.StandardCopyOption;
            MiniDFSNNTopology namenodeTopology = new MiniDFSNNTopology().addNameservice(nameservice);
            Files.createDirectories(hadoopHome);
            fs.close();
        boolean haEnabled = haNameService != null;  
import org.apache.hadoop.fs.CommonConfigurationKeysPublic;
            String kerberosPrincipal = args[1];  
            if (readOnlyRepositoryArchiveURL != null) {
public class MiniHDFS {  
        boolean secure = args.length == 3;
                FileUtils.copyURLToFile(readOnlyRepositoryArchiveURL, readOnlyRepositoryArchive);
            throw new IllegalArgumentException("Expected: MiniHDFS <baseDirectory> [<kerberosPrincipal> <kerberosKeytab>], " +
            builder.nameNodePort(9998);
 * Modifications Copyright OpenSearch Contributors. See
            URL readOnlyRepositoryArchiveURL = MiniHDFS.class.getClassLoader().getResource(archiveName);
            MiniDFSNNTopology.NSConf nameservice = new MiniDFSNNTopology.NSConf(haNameService).addNN(nn1).addNN(nn2);
        } else {  
                    new org.apache.hadoop.fs.Path(tempDirectory.resolve(directoryName).toAbsolutePath().toUri()),  
}
                fs.copyFromLocalFile(true, true,
 * You may obtain a copy of the License at  
            String keytabFile = args[2];
        if (args.length != 1 && args.length != 3) {  
import java.nio.file.Files;
            String archiveName = directoryName + ".tar.gz";  
import java.io.File;
            portFileContent = portFileContent + "\n" + Integer.toString(dfs.getNameNodePort(1));
        Path hdfsHome = baseDir.resolve("hdfs-data");
            MiniDFSNNTopology.NNConf nn2 = new MiniDFSNNTopology.NNConf("nn2").setIpcPort(0);  
    }  
        Files.write(tmp, pid.getBytes(StandardCharsets.UTF_8));
        MiniDFSCluster dfs = builder.build();  
import java.nio.charset.StandardCharsets;
            cfg.set(DFSConfigKeys.DFS_BLOCK_ACCESS_TOKEN_ENABLE_KEY, "true");
import org.apache.hadoop.fs.FileUtil;
 *    http://www.apache.org/licenses/LICENSE-2.0
        MiniDFSCluster.Builder builder = new MiniDFSCluster.Builder(cfg);  
    public static void main(String[] args) throws Exception {
            }
 * SPDX-License-Identifier: Apache-2.0
            cfg.set(DFSConfigKeys.DFS_NAMENODE_KEYTAB_FILE_KEY, keytabFile);
            MiniDFSNNTopology.NNConf nn1 = new MiniDFSNNTopology.NNConf("nn1").setIpcPort(0);
 * compatible open source license.
 */
        // optionally configure security
            if (UserGroupInformation.isSecurityEnabled()) {
        tmp = Files.createTempFile(baseDir, null, null);  
 * KIND, either express or implied.  See the License for the
        String portFileContent = Integer.toString(dfs.getNameNodePort(0));
import org.apache.hadoop.security.UserGroupInformation;  
            cfg.set(CommonConfigurationKeysPublic.HADOOP_SECURITY_AUTHORIZATION, "true");
        org.apache.hadoop.fs.Path opensearchUserPath = new org.apache.hadoop.fs.Path("/user/opensearch");  
 *
            System.setProperty("hadoop.home.dir", hadoopHome.toAbsolutePath().toString());
            cfg.set(DFSConfigKeys.DFS_NAMENODE_ACLS_ENABLED_KEY, "true");
 *
