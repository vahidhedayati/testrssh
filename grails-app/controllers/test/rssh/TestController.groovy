package test.rssh

import grails.plugin.remotessh.RemoteSSH



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


	def oldMethod() {
		RemoteSSH rsh = new RemoteSSH()
		rsh.setHost('localhost')
		rsh.setPort(22)
		rsh.setUsercommand('whoami')
		def g = rsh.Result(sshConfig)

		render "---- ${g}"
	}

	def reusingConnection() {
		StringBuilder output = new StringBuilder()
		Map pm = rsshService.validateParams(params)
		String host = pm.host
		int sshport = pm.sshport
		File keyfile = pm.keyfile
		String sshkeypass = pm.sshkeypass
		String sshuser = pm.sshuser
		String sshpass = pm.sshpass
		String usercommand = pm.usercommand
		String sudo = pm.sudo
		String filter = pm.filter
		String splitter = pm.splitter
		// Do initial connection
		if (!session.conn) {
			Connection conn = rsshService.connect(host,sshport)
			session.conn = conn
		}
		boolean hasConnection=true

		if (usercommand) {
			if (session.sess) {
				println "-- reusing existing connection for $usercommand"
				output = rsshService.executeCommand(session.sess,session.conn, usercommand, splitter, sudo, filter, hasConnection)
			}
		}else{
			if (!session.sess) {
				println "-- new session being created sending dummy connection"
				Session sess = rsshService.openSession(session.conn, keyfile,sshkeypass,sshuser,sshpass)
				session.sess = sess
				hasConnection=false
				output = rsshService.executeCommand(sess, session.conn,  'echo -n', splitter, sudo, '|', hasConnection)
			}

		}

		render view: 'reusingConnection', model: [output:output.toString()]
	}

	def closeConn() {
		rsshService.closeConnection(session.conn,session.sess)
		session.conn=null
		session.sess=null
		render "all reset"
	}




}
