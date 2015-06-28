package test.rssh

import grails.plugin.remotessh.RemoteSSH
import grails.plugin.remotessh.RsshValidate
import ch.ethz.ssh2.Connection
import ch.ethz.ssh2.Session

class TestController {

	//only required for old method
	def sshConfig

	def rsshService

	def index() {
		render view: 'index'
	}

	def runCommand() {
		String usercommand = params.usercommand
		render view: 'runCommand', model: [usercommand:usercommand]
	}

	def scpDir() {
		render view: 'scpDir'
	}

	def scpFile() {
		render view: 'scpFile'
	}

	def scpGet() {
		render view: 'scpGet'
	}

	def reusingConnection(RsshValidate pm) {
		StringBuilder output = new StringBuilder()
		// Do initial connection------
		try {
			boolean connected = false
			if (!session.conn && pm.host && pm.sshport) {
				Connection conn = rsshService.connect(pm.host,pm.sshport as int)
				session.conn = conn
				session.connected = true
			}
			boolean hasConnection=true
			if (session.connected) {
				if (pm.usercommand) {
					if (session.sess) {
						println "-- reusing existing connection for $pm.usercommand $session.conn "
						output = rsshService.executeCommand(session.sess,session.conn, pm.usercommand, pm.splitter, pm.sudo, pm.filter, hasConnection)
					}
				}else{
					if (!session.sess) {
						println "-- new session being created sending dummy connection"
						Session sess = rsshService.openSession(session.conn, pm.keyfile,pm.sshkeypass,pm.sshuser,pm.sshpass)
						session.sess = sess
						hasConnection=false
						output = rsshService.executeCommand(sess, session.conn,  'echo -n', pm.splitter, pm.sudo, '|', hasConnection)
					}
				}
			}
		}catch(Exception e) {
			output << e.message
		}
		render view: 'reusingConnection', model: [output:output.toString()]
	}

	def closeConn() {
		rsshService.closeConnection(session.conn,session.sess)
		session.conn=null
		session.sess=null
		session.connected=null
		render "all reset"
	}

	def oldMethod() {
		RemoteSSH rsh = new RemoteSSH()
		rsh.setHost('localhost')
		rsh.setPort(22)
		rsh.setUsercommand('whoami')
		def g = rsh.Result(sshConfig)

		render "---- ${g}"
	}
}
