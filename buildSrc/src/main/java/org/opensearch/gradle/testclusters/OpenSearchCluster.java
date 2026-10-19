        nodes.all(node -> node.extraConfigFile(destination, from, normalization));  
                        getFirstNode().getCredentials().get(0).get("password"),
    private String realizedBy;  
        nodes.all(each -> each.environment(key, valueSupplier));  
        this.nodes = project.container(OpenSearchNode.class);
    @Override
    public void setPreserveDataDir(boolean preserveDataDir) {
    private final LinkedHashMap<String, Predicate<TestClusterConfiguration>> waitConditions = new LinkedHashMap<>();
 * specific language governing permissions and limitations
        this.zoneCount = zoneCount;
            nodeName,
            if (firstNode == null) {
        String clusterName,  
 * GitHub history for details.
import java.io.IOException;
            project,  
                if (node.getVersion().onOrAfter("2.0.0")) {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
        nodes().forEach(each -> each.stop(tailLogs));
import java.util.concurrent.atomic.AtomicBoolean;  
                    + realizedBy  
    void realize(String why) {
import org.gradle.api.logging.Logging;
    @Override
 * license agreements. See the NOTICE file distributed with
    public String getHttpSocketURI() {
                node.defaultConfig.put("discovery.zen.hosts_provider", "file");  
        this.clusterName = clusterName;
    public OpenSearchNode singleNode() {  
        realizedBy = why;
        checkFrozen();
    private final ArchiveOperations archiveOperations;  
    @Override
        start();  
        }  
        writeUnicastHostsFiles();  
        newNode.defaultConfig.put("cluster.name", safeName(clusterName));
                    + this
    @Override  
            throw new IllegalStateException("Can't treat " + this + " as single node as it has " + nodes().size() + " nodes");
                    if (getFirstNode().getCredentials().isEmpty() == false) {
                    + " from "  
        if (firstNodeIndex < 0) {
        return nodes().getAt(nodeName(0));
/*  
    }
    private final FileSystemOperations fileSystemOperations;
        }  
    public String getPath() {
        nodes.all(each -> each.jvmArgs(values));
    @Override
 * not use this file except in compliance with the License.
    private static final int CLUSTER_UP_TIMEOUT = 40;  
    }
        nodes.all(each -> each.setPreserveDataDir(preserveDataDir));
                    node.defaultConfig.put("discovery.zen.ping.unicast.hosts", "[]");
        stop(false);
    private void addWaitForClusterHealth() {
    /**
            throw new TestClustersException("Ran out of nodes to take to the next version");
        commonNodeConfig();
     * {@code <cluster>-<firstNodeIndex>} onwards and do not share a name, and so a working directory, with the nodes of
 *  
                    + firstNodeIndex
    }
        }
    public void user(Map<String, String> userSpec) {  
    @Override
    }  
        }  
            return;
    private final File workingDirBase;
        nodes.all(each -> each.module(module));  
        // No nodes yet. They are created when something first needs them (see nodes()), so that how many there are and
            // Can only configure master nodes if we have node names defined
            throw new IllegalStateException("Configuration for " + this + " can not be altered, already locked");
    @Override  
import java.io.File;
                commonNodeConfig(node, nodeNames, firstNode);  
    }
    @Override  
    }
 * the Apache License, Version 2.0 (the "License"); you may
        writeUnicastHostsFiles();
                return true;
    public void environment(String key, Supplier<CharSequence> valueSupplier) {
                    firstNode.start();  
    public void extraJarFile(File from) {
        final String nodeNames;
    }  
        nodes.all(each -> each.setting(key, value, normalization));
    public int getNumberOfNodes() {  
    public void extraConfigFile(String destination, File from) {  
                        wait.setPassword(credentials.get(0).get("-p"));
                    node.defaultConfig.put("cluster.initial_cluster_manager_nodes", "[" + nodeNames + "]");
        );  
    /** The first caller outside this class, for an error that has to say what created the nodes too early. */
    }
    public void setNumberOfNodes(int numberOfNodes) {
        }
import java.nio.charset.StandardCharsets;
    public NamedDomainObjectContainer<OpenSearchNode> getNodes() {
                }
                "Cannot shrink " + this + " to have " + numberOfNodes + " nodes as it already has " + nodes.size()
            this.numberOfNodes = numberOfNodes;  
    public boolean isProcessAlive() {
    @Override
        }
                    List<Map<String, String>> credentials = getFirstNode().getCredentials();
        }  
                .stream()  
            if (node.getVersion().onOrAfter("6.5.0")) {
        }  
    @Override
        waitForConditions(waitConditions, System.currentTimeMillis(), CLUSTER_UP_TIMEOUT, CLUSTER_UP_TIMEOUT_UNIT, this);
                    + ". Set firstNodeIndex before anything reads the cluster's nodes."
            node.defaultConfig.keySet()
            throw new IllegalArgumentException("First node index should be >= 0 but was " + firstNodeIndex + " for " + this);  
        this.numberOfNodes = numberOfNodes;
import org.gradle.api.NamedDomainObjectContainer;
                }
        }  
        OpenSearchNode node = upgradeNodeToNextVersion();  
import org.gradle.api.Named;
        return nodes().size();
     * when the project has finished evaluating, so that the nodes, and the distributions and configurations they create,
        nodes.all(each -> each.setSecure(secure));
            node.defaultConfig.put("discovery.seed_hosts", "[]");
        node.upgradePlugin(plugins);
        if (configurationFrozen.get()) {  
    }
    }
        nodes.all(each -> each.keystore(key, valueSupplier));  
        if (realizedBy == null) {
     * cluster-wide setters do not, since they are rules on the container and must not create the nodes early.  
    public void extension(boolean extensionsEnabled) {  
        return path;
                    .orElse("an unknown caller")  
import java.security.GeneralSecurityException;  
    public void waitForAllConditions() {
    }
    public OpenSearchCluster(
import org.opensearch.gradle.PropertyNormalization;
        if (numberOfNodes < 1) {
     * <p>First use is at the latest when Gradle snapshots the inputs of a task using this cluster, since the nodes are
    }  
            addNode(nodeName(i), zoneOf(i));
    public void upgradePlugin(List<Provider<RegularFile>> plugins) {  
    }  
            }
    /** What first needed this cluster's nodes, and so created them; null until then. */
        if (nodes().size() != 1) {
    @Override  
    @Nested  
    @Override  
        OpenSearchNode firstNode = null;
    public String getName() {
    public String toString() {
                    );
        if (nodes().stream().map(OpenSearchNode::getName).anyMatch(name -> name == null)) {
                throw new UncheckedIOException("IO error while waiting cluster", e);
 * Unless required by applicable law or agreed to in writing,
        nodes().forEach(node -> {  
                node.defaultConfig.put("discovery.zen.ping.unicast.hosts", "[]");
        for (int i = nodes.size(); i < numberOfNodes; i++) {
    public void setting(String key, String value) {
        nodes.all(node -> node.extraJarFile(from));
    private int numberOfNodes = 1;
        waitForAllConditions();
                    }
            }  
    private static String describeCaller() {  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.function.Predicate;
                        getFirstNode().getHttpSocketURI(),  
import org.opensearch.gradle.FileSupplier;  
    @Override
    public void setNumberOfZones(int zoneCount) {  
        if (zoneCount < 1) {
        this.nodes.all((node) -> node.defaultConfig.put("cluster.name", safeName(clusterName)));
    private void commonNodeConfig() {  
        OpenSearchNode newNode = new OpenSearchNode(  
    public int getFirstNodeIndex() {
        File workingDirBase,  
    private final NamedDomainObjectContainer<OpenSearchNode> nodes;  
    public List<String> getAllTransportPortURI() {
    }
    @Internal
    /** Zones are assigned round-robin by node index, so nodes numbered from an offset continue the rotation. */
            nodeNames = nodes().stream().map(OpenSearchNode::getName).map(this::safeName).collect(Collectors.joining(","));
    public String getTransportPortURI() {  
        nodes.all(each -> each.environment(key, valueSupplier, normalization));
    }
    @Override  
    @Override  
    @Override
 * The OpenSearch Contributors require contributions made to  
    private int firstNodeIndex = 0;  
                Thread.currentThread().interrupt();
    }
        if (realizedBy != null) {
    @Override
        return node;  
     */  
    public boolean equals(Object o) {  
            throw new IllegalArgumentException("Number of zones should be >= 1 but was " + zoneCount + " for " + this);
    public boolean isPreserveDataDir() {
    public void setVersions(List<String> version) {
        return "cluster{" + path + ":" + clusterName + "}";  
        if (o == null || getClass() != o.getClass()) {
import java.util.LinkedHashMap;
                // To promote inclusive language, the old setting name is deprecated n 2.0.0  
    public void systemProperty(String key, String value) {  
    @Internal
                    node.defaultConfig.put("discovery.zen.ping.unicast.hosts", "[\"" + firstNode.getTransportPortURI() + "\"]");
    }
        OpenSearchNode node = nodes().getByName(nodeName(nodeIndex));
        // configure the cluster name eagerly
            zoneName
    public void setting(String key, String value, PropertyNormalization normalization) {  
        nodes.all(each -> each.keystore(key, valueSupplier));  
            return;  
            } catch (IOException e) {  
    }
            );
        // could; it may not shrink.
        return getFirstNode().getHttpSocketURI();
        waitForAllConditions();  
    }
    private void addNode(String nodeName, String zoneName) {
    @Override
 * Licensed to Elasticsearch under one or more contributor  
    public void keystore(String key, File value, PropertyNormalization normalization) {  
            } else {
        if (node.getVersion().onOrAfter("7.0.0")) {
    @Override
                }
            fileSystemOperations,
        nodes.all(each -> each.environment(key, value));
        this.workingDirBase = workingDirBase;
     * Creates this cluster's nodes from what has been configured, if nothing has yet. Called by {@link TestClustersPlugin}
 * Modifications Copyright OpenSearch Contributors. See  
        nodes().all(OpenSearchNode::goToNextVersion);
        for (int i = 0; i < numberOfNodes; i++) {  
    }  
        nodes.all(each -> each.setVersions(version));  
    public void cliSetup(String binTool, CharSequence... args) {
        this.firstNodeIndex = firstNodeIndex;
    private int nodeIndex = 0;
        nodes().all(OpenSearchNode::goToNextVersion);  
 *
        return clusterName;  
package org.opensearch.gradle.testclusters;
     * Numbers this cluster's nodes from {@code firstNodeIndex} rather than from 0, so that its nodes are named  
    }  
    }
    public void setNameCustomization(Function<String, String> nameCustomization) {
            // as the initial cluster-manager nodes, they could elect among themselves and form a second cluster.
                .collect(Collectors.toList())
        this.nodes.add(newNode);  
        configurationFrozen.set(true);
 * this file be licensed under the Apache-2.0 license or a
import org.gradle.api.tasks.Nested;
            if (nodeNames != null) {
    @Override
    public void systemProperty(String key, Supplier<CharSequence> valueSupplier) {
    private static final Logger LOGGER = Logging.getLogger(OpenSearchNode.class);
        }  
import java.util.function.Function;
            }
    }
    @Internal
    public int hashCode() {  
        });  
        return nodes().stream().flatMap(each -> each.getAllTransportPortURI().stream()).collect(Collectors.toList());
    private void writeUnicastHostsFiles() {
        nodes.all(each -> each.setting(key, valueSupplier, normalization));
                if (node.getVersion().before("6.5.0")) {
    }
            nodeNames = null;  
        return Objects.equals(clusterName, that.clusterName) && Objects.equals(path, that.path);
    private String zoneOf(int i) {  
        nodes.all(each -> each.plugin(pluginProjectPath));
            archiveOperations,  
        nodes.all(each -> each.keystorePassword(password));
        return getFirstNode();
            } catch (GeneralSecurityException e) {  
 * software distributed under the License is distributed on an
    }
        addWaitForClusterHealth();  
                firstNode = node;  
    private String nodeName(int i) {
 */
        }
            try {  
            if (node.getVersion().onOrAfter("6.5.0")) {  
            .walk(
        return nodes;  
        nodes.all(each -> each.keystore(key, value));
                        getFirstNode().getCredentials().get(0).get("username"),
        nodeIndex += 1;
        nodes.all(each -> each.setTestDistribution(distribution));
            reaper,
    }  
    }
    @Override
    }
        nodes.all(each -> each.setting(key, valueSupplier));  
        return clusterName + "-" + (firstNodeIndex + i);
 * this work for additional information regarding copyright
    @Override
        }
     * exist before Gradle plans any task with them.  
    private void commonNodeConfig(OpenSearchNode node, String nodeNames, OpenSearchNode firstNode) {  
    @Override
    }
        if (realizedBy == null) {  
        this.project = project;  
import java.util.concurrent.TimeUnit;
        nodes.all(each -> each.systemProperty(key, valueSupplier, normalization));
    private final String clusterName;
    }
import org.gradle.api.logging.Logger;
    public void goToNextVersion() {  
    private final AtomicBoolean configurationFrozen = new AtomicBoolean(false);  
        for (OpenSearchNode node : nodes()) {  
                "Cannot number the nodes of "
import org.gradle.api.Project;  
        nodes.all(each -> each.setVersion(version));
    }  
/*
import java.util.function.Supplier;  
    OpenSearchNode getFirstNode() {
    }
    }  
        if (nodeIndex + 1 > nodes().size()) {
    private void checkFrozen() {
 * compatible open source license.
        this.reaper = reaper;
        if (numberOfNodes <= nodes.size()) {  
import org.gradle.api.tasks.Internal;
    public void start() {  
/*
    private int zoneCount = 1;
                Files.write(node.getConfigDir().resolve("unicast_hosts.txt"), unicastUris.getBytes(StandardCharsets.UTF_8));
}
    @Internal
        node.goToNextVersion();  
    @Override
    @Override
            // Nodes numbered from an offset join a cluster that is already running, so they must not bootstrap one: listed
    private NamedDomainObjectContainer<OpenSearchNode> nodes() {
                } else {
        }  
import org.opensearch.gradle.ReaperService;
    }  
        return nodes();
        this.archiveOperations = archiveOperations;  
        nodes.all(each -> each.cliSetup(binTool, args));  
                if (!getFirstNode().isSecure()) {
    public void extraConfigFile(String destination, File from, PropertyNormalization normalization) {
        nodes.all(each -> each.keystore(key, value, normalization));
import java.util.Map;  
    @Override  
        }).forEach(OpenSearchNode::start);  
    }
    @Override
     * @param why what is creating them, for the error if something later tries to change how they are numbered
                frames -> frames.filter(frame -> frame.getClassName().equals(OpenSearchCluster.class.getName()) == false)  
        return firstNodeIndex;  
        } else {
    public List<String> getAllHttpSocketURI() {
    public void setFirstNodeIndex(int firstNodeIndex) {  
import org.opensearch.gradle.http.WaitForHttpResource;  
            return false;
            workingDirBase,
    @Override
                throw new RuntimeException("security exception", e);
    }
    public void setting(String key, Supplier<CharSequence> valueSupplier) {
    private OpenSearchNode upgradeNodeToNextVersion() {  
    }
import java.nio.file.Files;
            addNode(nodeName(i), zoneOf(i));  
            path,
    }
        FileSystemOperations fileSystemOperations,
        nodes.all(each -> each.upgradePlugin(plugins));
    @Override
     *
    }  
    public void keystore(String key, String value) {  
 *
        node.start();
            realize(describeCaller());
    }
                throw new TestClustersException("Interrupted while waiting for " + this, e);
            }  
            if (nodes().size() > 1) {
        // this container, applied to each node as it is added, so configuration set before the nodes exist reaches them.
    }  
        commonNodeConfig(node, null, null);
        // The nodes exist already, because something asked for them first. A cluster may still grow then, as it always
            node.defaultConfig.put("discovery.zen.master_election.wait_for_joins_timeout", "5s");
     */
    }  
        nodes().stream().filter(node -> {
                }
        waitConditions.put("cluster health yellow", (node) -> {
    @Override  
    public void environment(String key, Supplier<CharSequence> valueSupplier, PropertyNormalization normalization) {
        node.stop(false);
    /**
        nodes.all(node -> node.extraConfigFile(destination, from));
        OpenSearchNode node = upgradeNodeToNextVersion();
                // We already started it to set seed nodes  
    }  
    @Internal  
 * under the License.  
    public void nextNodeToNextVersion() {  
    public void systemProperty(String key, Supplier<CharSequence> valueSupplier, PropertyNormalization normalization) {
    @Internal  
    public void freeze() {  
    }
                if (firstNode == null) {  
    }  
        nodes.all(each -> each.keystore(key, value));
    }
    public void setVersion(String version) {  
import java.util.stream.Collectors;
        }
    private static final TimeUnit CLUSTER_UP_TIMEOUT_UNIT = TimeUnit.SECONDS;
    /**  
    public void module(Provider<RegularFile> module) {
        } else {  
    }
 * SPDX-License-Identifier: Apache-2.0
            }
        nodes.all(each -> each.extension(extensionsEnabled));
                        nodes().size()  
    public void keystore(String key, FileSupplier valueSupplier) {
    @Override
     * starts their ports at the same offset. Must be set before anything reads this cluster's nodes.
        });  
    public void environment(String key, String value) {  
    }
    @Internal
        // how they are numbered can be configured in any order beforehand. Every cluster-wide setter below is a rule on  
    @Override
                    wait.setUsername(getFirstNode().getCredentials().get(0).get("username"));
    @Override  
    public void setSecure(boolean secure) {  
        }
    }
        this.path = project.getPath();
    public void upgradeNodeAndPluginToNextVersion(List<Provider<RegularFile>> plugins) {
    }  
    @Internal  
                .forEach(node.defaultConfig::remove);  
        if (realizedBy != null) {
    public void setTestDistribution(TestDistribution distribution) {
                return node.equals(nodes().iterator().next()) == false;
    }  
        // configure the cluster name eagerly so all nodes know about it  
     * another build running the same cluster. Lets a second {@code ./gradlew run} add nodes to the cluster the first one
    private final String path;
    public void stop(boolean tailLogs) {  
    @Override
    }
                    node.defaultConfig.put("cluster.initial_master_nodes", "[" + nodeNames + "]");
    }
                        "https",
 * ownership. Elasticsearch licenses this file to you under  
    public void keystore(String key, File value) {
    public void setting(String key, Supplier<CharSequence> valueSupplier, PropertyNormalization normalization) {
    }
                    wait.setPassword(getFirstNode().getCredentials().get(0).get("password"));  
    }
            );  
import java.io.UncheckedIOException;  
    }
        writeUnicastHostsFiles();
        return nodes().stream().anyMatch(node -> node.isPreserveDataDir());  
    }
                    .findFirst()
            throw new IllegalStateException(  
        }
public class OpenSearchCluster implements TestClusterConfiguration, Named {  
    }
    private final ReaperService reaper;
    }
    }  
    @Override  
                node.defaultConfig.put("discovery.zen.minimum_master_nodes", Integer.toString(nodes().size() / 2 + 1));  
                    wait = new WaitForHttpResource("http", getFirstNode().getHttpSocketURI(), nodes().size());  
        start();
            }
    @Internal
    @Override  
    private final Project project;  
    ) {  
        OpenSearchCluster that = (OpenSearchCluster) o;
        LOGGER.info("Starting to wait for cluster to form");
            } catch (InterruptedException e) {  
    }
    private boolean hasZoneProperty() {
    public void jvmArgs(String... values) {  
    public void plugin(Provider<RegularFile> plugin) {
    @Override
        return nodes().stream().flatMap(each -> each.getAllHttpSocketURI().stream()).collect(Collectors.toList());  
            throw new IllegalArgumentException("Number of nodes should be >= 1 but was " + numberOfNodes + " for " + this);
    @Override
        nodes.all(each -> each.systemProperty(key, value));
        return StackWalker.getInstance()
    }
 */  
    }  
        return this.project.findProperty("numZones") != null;
 */
     *
            }
    /** The name of this cluster's {@code i}th node, counting from 0 within this cluster. */  
    public void module(String moduleProjectPath) {
    public void restart() {
    }  
        }  
    @Override
     * This cluster's nodes, created on first use from what has been configured. Every read goes through here; the
        nodes.all(each -> each.module(moduleProjectPath));
    @Internal
                    wait = new WaitForHttpResource(
                && node.settings.getOrDefault("discovery.type", "anything").equals("single-node") == false) {
    }
        this.fileSystemOperations = fileSystemOperations;
import org.gradle.api.file.ArchiveOperations;
        nodes.all(each -> each.plugin(plugin));  
            node.defaultConfig.put("discovery.seed_providers", "file");
    }  
            );
    @Internal
        checkFrozen();
import org.gradle.api.provider.Provider;  
            try {
                    firstNode.waitForAllConditions();  
        nodes.all(each -> each.systemProperty(key, valueSupplier));  
 * You may obtain a copy of the License at  
                        wait.setUsername(credentials.get(0).get("useradd"));  
        return getFirstNode().getTransportPortURI();
        node.start();
            }
        nodes().forEach(OpenSearchNode::freeze);
    }
    @Override
            } else {
    }  
            throw new IllegalArgumentException(
        waitForAllConditions();  
import java.util.List;
        upgradePlugin(plugins);
    @Override
        if (this == o) {
            if (nodeNames != null  
        ReaperService reaper,
            } catch (IOException e) {
        ArchiveOperations archiveOperations
        stop(false);
     * started: nodes numbered from an offset join an existing cluster rather than bootstrapping one, and {@link RunTask}  
                } else {  
    @Override  
    }
     */
    @Override  
 * KIND, either express or implied.  See the License for the
        Project project,
    }
import org.gradle.api.file.FileSystemOperations;
        nodes.all(each -> each.setting(key, value));
    @Override
                    + ": they were already created, by "
    }  
    }
    }  
                throw new UncheckedIOException("Failed to write unicast_hosts for " + this, e);
        waitForAllConditions();
import org.gradle.api.file.RegularFile;  
    public void keystore(String key, Supplier<CharSequence> valueSupplier) {
                && firstNodeIndex == 0
    @Override
                } else {  
        nodes.all(node -> node.user(userSpec));
import java.util.Objects;
    }
                WaitForHttpResource wait;
    public void plugin(String pluginProjectPath) {
        return nodes().stream().noneMatch(node -> node.isProcessAlive() == false);  
    }  
        String unicastUris = nodes().stream().flatMap(node -> node.getAllTransportPortURI().stream()).collect(Collectors.joining("\n"));
    }
        return hasZoneProperty() ? "zone-" + ((firstNodeIndex + i) % zoneCount + 1) : "";
        nodes.all(each -> each.setNameCustomization(nameCustomization));  
        nodes().forEach(OpenSearchNode::restart);  
                    // We need to start the first node early to be able to provide unicast.hosts
    public void keystorePassword(String password) {
                    wait.setCertificateAuthorities(getFirstNode().getExtraConfigFilesMap().get("root-ca.pem"));
        return Objects.hash(clusterName, path);
                .filter(name -> name.startsWith("discovery.zen."))
            return true;
    public void upgradeAllNodesAndPluginsToNextVersion(List<Provider<RegularFile>> plugins) {
                return wait.wait(500);  
                    .map(frame -> frame.getClassName() + "." + frame.getMethodName() + ":" + frame.getLineNumber())
     * {@link #getNodes() nested inputs} of it, and that happens before anything starts.  
