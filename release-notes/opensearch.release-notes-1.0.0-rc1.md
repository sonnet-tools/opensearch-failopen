     Signed-off-by: dblock &lt;dblock@amazon.com&gt;
    [Nick Knize](mailto:nknize@gmail.com) - Fri, 28 May 2021 10:07:06 -0500
     Signed-off-by: Sarat Vemulapalli &lt;vemulapallisarat@gmail.com&gt;
     Signed-off-by: AmiStrn &lt;amitai.stern@logz.io&gt;
    [Abbas Hussain](mailto:abbas_10690@yahoo.com) - Fri, 21 May 2021 04:45:28 +0530
* __Update/maintainers.md (#723) (#752)__
    (https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2021-29425)
    [Rabi Panda](mailto:adnapibar@gmail.com) - Thu, 20 May 2021 17:13:15 -0400
    Alters the test case to fail to delete in bulk many
* __[1.x] Add read_only block argument to opensearch-node unsafe-bootstrap command #599 (#725)__
     Signed-off-by: Piyush Daftary &lt;piyush.besu@gmail.com&gt;
    this commit makes
    [Daniel Doubrovkine (dB.)](mailto:dblock@dblock.org) - Thu, 6 May 2021 20:12:22 +0000
    supported.
    [Abbas Hussain](mailto:abbas_10690@yahoo.com) - Fri, 21 May 2021 11:03:36 +0530
    Legacy version number 7.10.2 for legacy clients.
* __Make -Dtests.output=always actually work. (#648)__
* __Speedup lang-painless tests (#605) (#617)__
    `staleIndicesToDelete` is empty -- also in the error flow.
     Signed-off-by: dblock &lt;dblock@amazon.com&gt;
    method.
     Signed-off-by: Ankit Jain &lt;akjain@amazon.com&gt;
     RegexLimitTests was split into two suites (limit=1 and limit=2) rather
     Co-authored-by: Vacha &lt;VachaShah@users.noreply.github.com&gt;
    * remove default as false for read only block to avoid overriding user&#39;s
    [Abbas Hussain](mailto:abbas_10690@yahoo.com) - Thu, 27 May 2021 00:43:40 +0530
    interceptor.
    cannot be replicated from upgraded nodes to nodes running older versions.
* __[CVE] Upgrade dependencies for Azure related plugins to mitigate CVEs (#688) (#771) (#784)__
    * There&#39;s no password requirement for the instance.
    * Moving test file to correct package
     C2 compiler is no longer needed for tests to be fast, instead tests run
    [Abbas Hussain](mailto:abbas_10690@yahoo.com) - Thu, 20 May 2021 15:57:07 -0700
    are not provided in the request, can be configured for the cluster. This is a
    https://github.com/netty/netty/security/advisories/GHSA-5mcr-gq6c-3hq2
    This change extends the remote reindex SPI to allow adding a custom
    takes care of the previously failed attempt as the test
     Signed-off-by: Ankit Jain &lt;akjain@amazon.com&gt;
    existing settings
    indices in parallel using SNAPSHOT
     Signed-off-by: Abbas Hussain &lt;abbas_10690@yahoo.com&gt;
    [Abbas Hussain](mailto:abbas_10690@yahoo.com) - Fri, 21 May 2021 17:20:34 -0700
    Signed-off-by: Vacha Shah &lt;vachshah@amazon.com&gt;
    [amitai stern](mailto:amitai.stern@logz.io) - Thu, 13 May 2021 09:02:57 -0500
    * Update guava dependency to mitigate CVE for repository-azure plugin
    faster with C1 only as expected, like the rest of the unit tests.
    [Ketan Verma](mailto:ketanv3@users.noreply.github.com) - Thu, 20 May 2021 17:14:28 -0400
    [Ankit Jain](mailto:akjain@amazon.com) - Thu, 20 May 2021 14:02:18 -0700
    Signed-off-by: Dhwanil Patel &lt;dhwanip@amazon.com&gt;
    &#39;2.0.19&#39; -&gt; &#39;2.0.23&#39;
    [Abbas Hussain](mailto:abbas_10690@yahoo.com) - Wed, 26 May 2021 23:55:35 +0530
    - commons-codec:1.12 (-&gt;1.13) apache/commons-codec@48b6157
    RPM uses the &#34;x86_64&#34; name for 64-bit x86, which is in-line with GCC
    * Use protected fallbackSetting in Setting.
    * Addressing comments.
    This commit fixes mixedCluster and rolling upgrades by spoofing OpenSearch
* __Add timeout on cat/stats API (#759)__
     Signed-off-by: dblock &lt;dblock@amazon.com&gt;
    [Nick Knize](mailto:nknize@gmail.com) - Wed, 28 Apr 2021 11:01:39 -0500
    is failing on Windows. The change was made to include the NOTICE.txt file as
    [Nick Knize](mailto:nknize@gmail.com) - Fri, 28 May 2021 10:08:05 -0500
     Signed-off-by: Rabi Panda &lt;adnapibar@gmail.com&gt;
     can join a legacy (&lt;= 7.10.2) cluster and rolling upgrades work as expected.
     tika : &#39;1.24&#39; -&gt; &#39;1.24.1&#39;
    condition to be when the queue of
    [Nick Knize](mailto:nknize@gmail.com) - Wed, 28 Apr 2021 10:59:36 -0500
    Painless tests would previously create script engine for every single test
* __Update dependencies for ingest-attachment plugin. (#666) (#735)__
    - jackson-databind:2.10.4 (-&gt;2.11.0) FasterXML/jackson-databind#2589
     Signed-off-by: Sarat Vemulapalli &lt;vemulapallisarat@gmail.com&gt;
    more snapshot to delete in the
    [arunabh23](mailto:singharunabh18@gmail.com) - Thu, 20 May 2021 17:13:46 -0400
* __Converted all .asciidoc to .md. (#658)__
    EAD -&gt; refs/heads/1.0, tag: refs/tags/1.0.0-rc1, refs/remotes/origin/1.0
* __Handle inefficiencies while fetching the delayed unassigned shards during cluster health (#588) (#730)__
    Signed-off-by: dblock &lt;dblock@amazon.com&gt;
* __[CVE-2018-11765] Upgrade hadoop dependencies for hdfs plugin (#654) (#736)__
    queue. Thus, in the test I made the number of
    Fixed a few minor typos and grammars.
    deletion task gets stuck.
    Co-authored-by:
    (linux-archive, linux-archive-aarch64, debian, rpm, docker) on supported linux
    originally intended.
* __Added a link to the maintainer file in contribution guides (#589) (#731)__
     Signed-off-by: Nicholas Walter Knize &lt;nknize@apache.org&gt;
    https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2019-10782
     Signed-off-by: CEHENKLE &lt;henkle@amazon.com&gt;
    https://bugzilla.redhat.com/show_bug.cgi?id=CVE-2020-13956
     Signed-off-by: Ankit Jain &lt;akjain@amazon.com&gt;
    stax2-api that are added along with the sha1s, licenses and notices.
    GroupedActionListener never responds and in the event of a few exceptions the
    command
    than
    version 1.0.0 as Legacy version 7.10.2. With this commit an OpenSearch 1.x node
    [Daniel Doubrovkine (dB.)](mailto:dblock@dblock.org) - Thu, 6 May 2021 20:12:49 +0000
    * Explain how to listen on an external IP.
* __Remove URL content from Reindex error response (#630) (#748)__
    more threads to handle the deletion task and there is still one
    dynamically applying different settings.
    - ant:1.10.8 (-&gt;1.10.9) https://ant.apache.org/security.html
     Co-authored-by: Neal Gompa (ニール・ゴンパ) &lt;ngompa13@gmail.com&gt;
    [Abbas Hussain](mailto:abbas_10690@yahoo.com) - Thu, 20 May 2021 15:55:56 -0700
     Co-authored-by: Daniel Doubrovkine (dB.) &lt;dblock@dblock.org&gt;
    Vacha Shah &lt;vachshah@amazon.com&gt;
     Signed-off-by: Ankit Jain &lt;akjain@amazon.com&gt;
* __distribution/packages: Fix filename format for deb archives (#621) (#753)__
    - netty:4.1.49.Final (-&gt;4.1.59)
    Otherwise the
* __[Bug] Fix gradle build on Windows failing from a recent change (#765)__
## Version 1.0.0-rc1 Release Notes
    Debian packages are formatted with the following filename structure:
* __Create group settings with fallback. (#743) (#745)__
    - jackson-dataformat-cbor:2.10.4 (-&gt;2.11.0)
     Signed-off-by: Rabi Panda &lt;adnapibar@gmail.com&gt;
    This interceptor can be plugged in to perform any processing on
    (https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2021-27807)
    [Abbas Hussain](mailto:abbas_10690@yahoo.com) - Sat, 22 May 2021 04:50:00 +0530
* __[BUG] fix MainResponse to spoof version number for legacy clients (#708)__
* __Fix snapshot deletion task getting stuck in the event of exceptions (#629) (#650)__
    commons-io:commons-io : &#39;2.6&#39; -&gt; &#39;2.7&#39;
* __Support Data Streams in OpenSearch (#690) (#713)__
    [Harmish](mailto:harmish.lakhani@gmail.com) - Thu, 20 May 2021 17:12:16 -0400
    This commit changes MainResponse to spoof OpenSearch 1.x version numbers as
     Signed-off-by: Robert Muir &lt;rmuir@apache.org&gt;
    Signed-off-by: Abbas Hussain &lt;abbas_10690@yahoo.com&gt;
* __[CVE] Upgrade dependencies to mitigate CVEs (#657) (#737)__
    This commit adds support for data streams by adding a DataStreamFieldMapper,
    to 2.10.1. This also updates the hadoop-minicluster version to 2.10.1 as well.
    library to version 1.31.0. See CVE details at
    [Rabi Panda](mailto:adnapibar@gmail.com) - Thu, 20 May 2021 17:09:59 -0400
    [Rabi Panda](mailto:adnapibar@gmail.com) - Thu, 20 May 2021 17:12:33 -0400
    https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2020-8908
     Signed-off-by: Rabi Panda &lt;adnapibar@gmail.com&gt;
     Also upgrade guava to the latest as per the CVE
    * Fixing benchmark and adding debug mode tests
    https://nvd.nist.gov/vuln/detail/CVE-2020-7692
    Changes to fix the failing OpenSearch distribution tests for packages
    [Abbas Hussain](mailto:abbas_10690@yahoo.com) - Fri, 21 May 2021 11:04:14 +0530
    * Make allocation decisions at node level first for pending task optimization
* __Update issue template with multiple labels (#668) (#749)__
* __[TEST] Fix failing distro tests for linux packages (#569) (#733)__
    Changes the behavior of the recursive deletion function
    [Rabi Panda](mailto:adnapibar@gmail.com) - Wed, 19 May 2021 21:20:53 -0700
    the request or response.
* __distribution/packages: Fix RPM architecture name for 64-bit x86 (#620) (#770) (#783)__
     Signed-off-by: Ankit Jain &lt;akjain@amazon.com&gt;
    extra snapshots be one more than the max in the
    backport commit of pull #625
    Adding Gopala, Vengad, Shweta, db and Itiyama to maintainers list
     Signed-off-by: Harmish Lakhani &lt;harmish.lakhani@gmail.com&gt;
     Co-authored-by: Sooraj Sinha &lt;81695996+soosinha@users.noreply.github.com&gt;
     Co-authored-by: Meet Shah &lt;48720201+meetshah777@users.noreply.github.com&gt;
    threadpool&#39;s workers.
     Signed-off-by: Harmish Lakhani &lt;harmish.lakhani@gmail.com&gt;
     Co-authored-by: Shweta Thareja &lt;tharejas@amazon.com&gt;
     Signed-off-by: Rabi Panda &lt;adnapibar@gmail.com&gt;
    This upgrade also brings in two additional dependencies, woodstox-core and
    it a multithreaded operation and delete multiple stale
    (https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2020-9489)
    [Daniel Doubrovkine (dB.)](mailto:dblock@dblock.org) - Thu, 20 May 2021 17:06:58 -0400
    - apache-httpclient:4.5.10 (-&gt;4.5.13)
     Signed-off-by: Arunabh Singh &lt;arunabs@amazon.com&gt;
    [Daniel Doubrovkine (dB.)](mailto:dblock@dblock.org) - Thu, 6 May 2021 21:17:49 +0000
    compilers.
     Signed-off-by: Ankit Jain &lt;akjain@amazon.com&gt;
    pdfbox :
    IntelliJ.
* __Speedup snapshot stale indices delete (#613) (#616)__
     Make generated Debian packages follow this convention.
     level fixture (BeforeClass/AfterClass) that is used across all the test
    https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2020-28491
     name_[epoch:]version-release_arch.deb
     Signed-off-by: Rabi Panda &lt;adnapibar@gmail.com&gt;
     Signed-off-by: Sooraj Sinha &lt;soosinha@amazon.com&gt;
* __Replace elastic.co with opensearch.org (#611) (#623)__
    SNAPSHOT threadpool is at most 5. So in the event we get more than 5 exceptions
    * Add detail on how to install Java.
    [Dhwanil Patel](mailto:dhwanip@amazon.com) - Mon, 24 May 2021 23:18:04 +0530
    Hadoop 2.8.5 has been reported to have CVEs
    Add clear instructions on how to run OpenSearch with debugging mode in
* __Standardize int, long, double and float Setting constructors. (#665)__
    Co-authored-by: Dawn Foster &lt;fosterd@vmware.com&gt;
    distros.
    [Rabi Panda](mailto:adnapibar@gmail.com) - Tue, 25 May 2021 10:51:53 -0700
    For discovery-gce and repository-gcs plugins update the google-oauth-client
    `executeOneStaleIndexDelete()` stop
     Co-authored-by: Sooraj Sinha &lt;81695996+soosinha@users.noreply.github.com&gt;
* __Updating README and CONTRIBUTING guide to get ready for beta1 release. (#672) (#751)__
    * Remove unused jackson dependency and respective LICENSE and NOTICE
* __Make allocation decisions at node level first for pending task optimi… (#534) (#739)__
    A recent change as part of the commit c2e816ec introduced a bug where the build
    * Fixing typo in previous commit
     Co-authored-by: Arunabh Singh &lt;arunabs@amazon.com&gt;
    Now the tests that need to tweak script engine settings create a class
    Signed-off-by: Meet Shah &lt;meetshsh@gmail.com&gt;
    This PR upgrade the following dependencies to fix CVEs.
    * apply user defined cluster wide read only block after unsafe bootstrap
    [Abbas Hussain](mailto:abbas_10690@yahoo.com) - Thu, 20 May 2021 17:11:49 -0400
     Co-authored-by: Sarat Vemulapalli &lt;vemulapallisarat@gmail.com&gt;
    the next successful deletion also
    and making timestamp
    (https://bugzilla.redhat.com/show_bug.cgi?id=1883549). We need to upgrade this
    [Daniel Doubrovkine (dB.)](mailto:dblock@dblock.org) - Thu, 6 May 2021 20:11:33 +0000
    * Addressing review comments
* __Make default number of shards configurable (#726)__
     Signed-off-by: Neal Gompa &lt;ngompa13@gmail.com&gt;
    [Nick Knize](mailto:nknize@gmail.com) - Wed, 28 Apr 2021 11:02:21 -0500
     Signed-off-by: Nicholas Walter Knize &lt;nknize@apache.org&gt;
    * Update commons-io-2.4.jar to 2.7 for plugins/discovery-azure-classic module
     Signed-off-by: Neal Gompa &lt;ngompa13@gmail.com&gt;
    Instead of snapshot delete of stale indices being a single threaded operation
    [Rabi Panda](mailto:adnapibar@gmail.com) - Thu, 20 May 2021 17:13:02 -0400
    [Abbas Hussain](mailto:abbas_10690@yahoo.com) - Wed, 19 May 2021 13:41:32 -0700
* __[BWC] fix mixedCluster and rolling upgrades (#775) (#793)__
    Signed-off-by: Sooraj Sinha &lt;soosinha@amazon.com&gt;
    read-only in the distributions. The code fails on Windows as it&#39;s not a
* __Add Remote Reindex SPI extension (#547) (#756)__
     Signed-off-by: dblock &lt;dblock@amazon.com&gt;
    * Create group settings with fallback.
    SNAPSHOT threadpool.
    https://github.com/junit-team/junit4/security/advisories/GHSA-269g-pwp5-87pp
    Signed-off-by: dblock &lt;dblock@amazon.com&gt;
    * Fixed gradle precommit failures
     Signed-off-by: Ketan Verma &lt;ketan9495@gmail.com&gt;
     Signed-off-by: dblock &lt;dblock@amazon.com&gt;
     Signed-off-by: Harmish Lakhani &lt;harmish.lakhani@gmail.com&gt;
    there are no
* __Update instructions on debugging OpenSearch. (#689) (#738)__
    * Updating README and CONTRIBUTING guide to get ready for beta1 release.
    Signed-off-by: dblock &lt;dblock@amazon.com&gt;
     Signed-off-by: Rabi Panda &lt;adnapibar@gmail.com&gt;
    * Addressing review comments
    The default number of primary shards for a new index, when the number of shards
    - junit:4.12 (-&gt;4.13.1)
* __[CVE-2020-7692] Upgrade google-oauth clients for goolge cloud plugins (#662) (#734)__
    POSIX-compliant. This commit adds a check on the current operating system.
    - checkstyle:8.20 (-&gt;8.29)
    Mixed clusters will not work beyond the duration of the upgrade since shards
     Signed-off-by: Rabi Panda &lt;adnapibar@gmail.com&gt;
* __Fix #649: Properly escape @ in JavaDoc. (#651)__
* __[WIP] Developer guide updates (#595)__
    snapshots at the first attempt, and then
* __Catch runtime exceptions to make class loader race conditions easier to debug. (#608) (#750)__
    and other
    [Rabi Panda](mailto:adnapibar@gmail.com) - Thu, 20 May 2021 17:11:03 -0400
    This PR resolves the CVEs for dependencies in the ingest-attachment plugin.
    methods in that suite.
    field name configurable. Backwards compatibility is
    [Daniel Doubrovkine (dB.)](mailto:dblock@dblock.org) - Wed, 28 Apr 2021 17:28:17 +0000
     Co-authored-by: Vacha Shah &lt;vachshah@amazon.com&gt;
    Signed-off-by: dblock &lt;dblock@amazon.com&gt;
