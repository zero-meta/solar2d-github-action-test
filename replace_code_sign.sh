#!/usr/bin/env bash

set -e

# platform mac
sign1_a='CODE_SIGN_IDENTITY = "Developer ID Application: Corona Labs Inc"'
sign1_b='CODE_SIGN_IDENTITY = "Developer ID Application: Labo Lado Inc"'
sign2_a='DEVELOPMENT_TEAM = BG2J43EA88'
sign2_b='DEVELOPMENT_TEAM = V9E9E7HUEW'
sign3_a='PRODUCT_BUNDLE_IDENTIFIER = com.coronalabs.Corona_Simulator'
sign3_b='PRODUCT_BUNDLE_IDENTIFIER = com.labolado.solar2d'
sign4_a='Developer ID Application: Corona Labs Inc'
sign4_b='Developer ID Application: Labo Lado Inc'

sed -i.bak "s/${sign1_a}/${sign1_b}/g" platform/mac/car.xcodeproj/project.pbxproj
sed -i.bak "s/${sign1_a}/${sign1_b}/g" platform/mac/CoronaBuilder.xcodeproj/project.pbxproj
sed -i.bak "s/${sign1_a}/${sign1_b}/g" platform/mac/CoronaShell/CoronaShell.xcodeproj/project.pbxproj
sed -i.bak "s/${sign1_a}/${sign1_b}/g" platform/mac/car.xcodeproj/project.pbxproj
sed -i.bak "s/${sign1_a}/${sign1_b}/g" platform/mac/lua.xcodeproj/project.pbxproj
sed -i.bak "s/${sign1_a}/${sign1_b}/g" platform/mac/ratatouille.xcodeproj/project.pbxproj
sed -i.bak "s/${sign2_a}/${sign2_b}/g" platform/mac/ratatouille.xcodeproj/project.pbxproj
sed -i.bak "s/${sign3_a}/${sign3_b}/g" platform/mac/ratatouille.xcodeproj/project.pbxproj
sed -i.bak "s/${sign4_a}/${sign4_b}/g" platform/mac/ratatouille.xcodeproj/project.pbxproj
rm -f platform/mac/car.xcodeproj/project.pbxproj.bak
rm -f platform/mac/CoronaBuilder.xcodeproj/project.pbxproj.bak
rm -f platform/mac/CoronaShell/CoronaShell.xcodeproj/project.pbxproj.bak
rm -f platform/mac/car.xcodeproj/project.pbxproj.bak
rm -f platform/mac/lua.xcodeproj/project.pbxproj.bak
rm -f platform/mac/ratatouille.xcodeproj/project.pbxproj.bak


# platform iphone
sign5_a='PROVISIONING_PROFILE_SPECIFIER = ios'
sign5_b='PROVISIONING_PROFILE_SPECIFIER = "dev ios solar2d";\nPRODUCT_BUNDLE_IDENTIFIER = com.labolado.solar2d'
sed -i.bak "s/${sign2_a}/${sign2_b}/g" platform/iphone/ratatouille.xcodeproj/project.pbxproj
sed -i.bak "s/${sign5_a}/${sign5_b}/g" platform/iphone/ratatouille.xcodeproj/project.pbxproj
rm -f platform/iphone/ratatouille.xcodeproj/project.pbxproj.bak
