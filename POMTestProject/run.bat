set projectLocation=F:\SeleniumandJavaProjects\POMTestProject
cd %projectLocation%
set classpath=%projectLocation%\target\classes;%projectLocation%\lib\*
java  -cp "F:\SeleniumandJavaProjects\POMTestProject\Libs\testng-7.4.0.jar" org.testng.TestNg testng.xml
pause