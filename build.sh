jar cvf framework.jar -C framework/build/web/WEB-INF/classes/ etu002072
mv framework.jar Test/build/web/WEB-INF/lib/
jar cvf MonProjet.war -C  Test/build/web .  
mv MonProjet.war /opt/apache-tomcat-9.0.73/webapps/


