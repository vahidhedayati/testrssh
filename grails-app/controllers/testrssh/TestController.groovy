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


