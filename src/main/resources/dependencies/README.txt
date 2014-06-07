These files are configured in the pom.xml as system dependencies. If you like, you may install these
jars in your local Maven repository and change their respective dependency properties. You may also
use the install plugin or some other means to configure the project to resolve these dependencies.

If your preference is a standard Eclipse project, you will have place these jars in this folder (along with
copies of the dependent jars) in the WEB-INF/lib.