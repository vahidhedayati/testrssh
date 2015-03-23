package testrssh

import grails.core.GrailsApplication
import grails.plugin.remotessh.RemoteSSH

class TestController {

    GrailsApplication grailsApplication


    def index() {

        ConfigObject remotessh = grailsApplication.config.remotessh

        RemoteSSH rsh = new RemoteSSH()
        rsh.setHost('somehost')
        rsh.setPort(22)
        rsh.setUsercommand('hostname -s && uname -a && whoami')
        def g = rsh.Result(remotessh)
        render "---- $g"

    }

}


