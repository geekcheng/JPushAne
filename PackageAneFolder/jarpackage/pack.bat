@echo off
%~d0
cd %~dp0
set native=nativelib.jar
set jpush=jpush-sdk-release1.5.2.jar
set f1=cn
set f2=assets
jar -xf %jpush%
jar -uf %native% %f1% 
jar -uf %native% %f2%
::pause