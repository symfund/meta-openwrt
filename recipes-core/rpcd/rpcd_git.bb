# Copyright (C) 2015 Khem Raj <raj.khem@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "OpenWrt UBUS RPC server"
HOMEPAGE = "http://git.openwrt.org/?p=project/rpcd.git;a=summary"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://main.c;beginline=1;endline=18;md5=da5faf55ed0618f0dde1c88e76a0fc74"
SECTION = "base"
DEPENDS = "json-c libubox ubus uci iwinfo virtual/crypt"

SRC_URI = "\
	git://git.openwrt.org/project/rpcd.git;name=rpcd; \
	"

SRCREV_rpcd = "3fea6559817a22de1b8375b9b1f3d818e6534591"

S = "${WORKDIR}/git"
OR = "${S}/openwrt/package/system/rpcd/files"

inherit cmake pkgconfig openwrt-services openwrt openwrt-base-files

SRCREV_openwrt = "${OPENWRT_SRCREV}"

do_install:append() {
    install -d ${D}${includedir}/rpcd
    install -m 0644 ${S}/include/rpcd/* ${D}${includedir}/rpcd/
    install -Dm 0755 ${OR}/rpcd.config ${D}${sysconfdir}/config/rpcd
    install -Dm 0755 ${OR}/rpcd.init ${D}${sysconfdir}/init.d/rpcd

    mkdir -p ${D}${datadir}/rpcd/acl.d/
    install -Dm	0644 ${S}/unauthenticated.json ${D}${datadir}/rpcd/acl.d/

    mkdir -p ${D}/sbin
    ln -s /usr/sbin/rpcd ${D}/sbin/rpcd
}

FILES:${PN}  += "${libdir}/*"

RDEPENDS:${PN} += "iwinfo"
