# testrssh


build.gradle:
```
dependencies {

..
	compile "org.grails.plugins:remotessh:0.4"
}
```


conf/application.groovy:
```groovy
remotessh.KEY="/home/me/.ssh/id_rsa"
remotessh.USER = "me"
```



Controller tesing RemoteSSH

```groovy
  package testrssh

  import grails.plugin.remotessh.RemoteSSH

  class TestController {

      def sshConfig

      def index() {
          RemoteSSH rsh = new RemoteSSH()
          rsh.setHost('localhost')
          rsh.setPort(22)
          rsh.setUsercommand('whoami')
          def g = rsh.Result(sshConfig)

          render "---- ${g}"

      }

  }



```