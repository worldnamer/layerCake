@echo off
if (%1)==() goto usage
if (%2)==() goto usage

:createDirectories
xcopy /e /q %~d0%~p0sourceDir\* intermDir\*

:sedFiles
for /f %%g in ('dir /s /a-d /b intermDir\*.xml;intermDir\*.java;intermDir\*.bat') do sed s/${artifactId}/%2/g %%g > %%g.temp && copy %%g.temp %%g && del %%g.temp
for /f %%g in ('dir /s /a-d /b intermDir\*.xml;intermDir\*.java;intermDir\*.bat') do sed s/${groupName}/%1/g %%g > %%g.temp && copy %%g.temp %%g && del %%g.temp

:renameDirsAndFiles
for /f %%g in ('dir /s intermDir\*__artifactId__* /b') do (
 for /f %%h in ('echo %%g ^| sed s/__artifactId__/%2/') do (
  move %%g %%h
 )
)

for /f %%g in ('dir /s intermDir\*__groupName__* /b') do (
 for /f %%h in ('echo %%g ^| sed s/__groupName__/%1/') do (
  move %%g %%h
 )
)

:moveIntermDir
move intermDir %2

goto :end

:usage
echo %0 [groupName] [artifactId]

:end