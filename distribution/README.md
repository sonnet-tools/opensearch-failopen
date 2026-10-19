## With or Without JDK?
The following distributions are being built:
For each supported platform there should be both a target bundled with a JDK and a target without a bundled JDK.
This subproject contains the necessary tooling to build the various distributions.
Note that some of this can only be run on the specific architecture and does not support cross-compile.
* Docker images
* Packages (`*.deb`, `*.rpm`): specific package formats for some Linux distributions
# Distributions
* Backwards compatibility tests: used internally for version compatibility testing, not for public consumption
* Archives (`*.zip`, `*.tar`): these form the basis for all other OpenSearch distributions
