SUMMARY = "Entity Manager"
DESCRIPTION = "Entity Manager provides d-bus configuration data \
and configures system sensors"

SRC_URI = "git://github.com/openbmc/entity-manager.git"
SRCREV = "28dc2dae9fc45d83c26517befd18c52f6526b455"
PV = "0.1+git${SRCPV}"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENCE;md5=a6a4edad4aed50f39a66d098d74b265b"

SYSTEMD_SERVICE_${PN} = "xyz.openbmc_project.EntityManager.service \
                         xyz.openbmc_project.FruDevice.service"

PROVIDES += "virtual/phosphor-fans-sensor-inventory"
DEPENDS = "boost \
           i2c-tools \
           nlohmann-json \
           sdbusplus \
           valijson"

S = "${WORKDIR}/git/"
inherit cmake systemd

EXTRA_OECMAKE = "-DYOCTO=1 -DUSE_OVERLAYS=0"
