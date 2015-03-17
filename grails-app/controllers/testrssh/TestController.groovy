package testrssh

import grails.core.GrailsApplication
import grails.core.support.GrailsApplicationAware
import grails.plugin.remotessh.RemoteSSH

class TestController implements GrailsApplicationAware {
   GrailsApplication grailsApplication
    def sshConfig

        def index() {
          int port=22

		
            RemoteSSH rsh=new RemoteSSH()
            rsh.setHost('someHOST')
	rsh.setUser('someUSER')
            rsh.setPort(22)
            rsh.setUsercommand('whoami')
            def g=rsh.Result(sshConfig)
		render "---- $g"
       }
    }

