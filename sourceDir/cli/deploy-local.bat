robocopy %~d0%~p0..\jboss %JBOSS_HOME% /S /XD .svn
call %~d0%~p0deploy-war.bat
call %~d0%~p0deploy-web.bat