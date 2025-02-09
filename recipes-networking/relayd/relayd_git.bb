# Copyright (C) 2016 Khem Raj <raj.khem@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "OpenWrt IPv4 pseudo-bridge routing daemon"
HOMEPAGE = "http://git.openwrt.org/?p=project/relayd.git;a=summary"
LICENSE = "GPL-2.0+"
LIC_FILES_CHKSUM = "file://main.c;beginline=1;endline=17;md5=86aad799085683e0a2e1c2684a20bab2"
SECTION = "base"
DEPENDS = "libubox"

SRC_URI = "git://git.openwrt.org/project/relayd.git \
           file://0001-Fix-ignoring-return-value-of-write-declared-with-att.patch \
          "

SRCREV = "f4d759be54ceb37714e9a6ca320d5b50c95e9ce9"

S = "${WORKDIR}/git"

inherit cmake pkgconfig openwrt

FILES:${PN}  += "${libdir}/*"
