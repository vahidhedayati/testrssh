
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'demo.label', default: 'demo runCommand')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<g:render template="menu"/>
	<g:form name="poster" action="runCommand">
	Command to run: <g:textField name="usercommand" />
	<g:submitButton name="submit"/>
	</g:form>
	<g:if test="${params.usercommand}">
		<rssh:runCommand usercommand="${params.usercommand }"/>
	</g:if>
	
	
	<br><h2>Full call:</h2>
	<pre>
	&lt;rssh:runCommand
	user = "params.user"  //optional overriden by Config.groovy if not defined
	pass = "params.password"  //optional overriden by Config.groovy if not defined
	sshkey = "params.sshkey" //optional overriden by Config.groovy if not defined
	sshkeypass = "params.sshkeypass" //optional overriden by Config.groovy if not defined
	host = "params.host" //optional if not defined set to localhost of your pc by plugin
	port = "params.port" //optional if not defined will default to 22 in plugin
	
	usercommand = "params.usercommand" // You need to set what you want to run on remote HOST
	sudo = "sudo" // set to sudo to execute command after issuing sudo bash
	
	filter = "params.filter" //optional set for e.g: filter="|" now get your commands to run and send output with | 
	 
	splitter = "params.splitter" //optional if not defined it will split per line using &lt;br&gt; for html display of console output
	
	&gt;
	</pre>
	
	
	</body>
</html>