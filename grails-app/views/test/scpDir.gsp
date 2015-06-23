
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'demo.label', default: 'demo runCommand')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<g:render template="menu"/>
	<g:form name="poster" action="scpDir">
	Local dir: <g:textField name="localdir" />
	Remote dir: <g:textField name="remotedir" />
	<g:submitButton name="submit"/>
	</g:form>
	<g:if test="${params.localdir && params.remotedir}">
		<rssh:scpDir localdir="${params.localdir }" remotedir="${params.remotedir }"/>
	</g:if>
	<br><h2>Full call:</h2>
	<pre>
	&lt;rssh:scpDir
	user = "params.user"  //optional overriden by Config.groovy if not defined
	pass = "params.password"  //optional overriden by Config.groovy if not defined
	sshkey = "params.sshkey" //optional overriden by Config.groovy if not defined
	sshkeypass = "params.sshkeypass" //optional overriden by Config.groovy if not defined
	host = "params.host" //optional if not defined set to localhost of your pc by plugin
	port = "params.port" //optional if not defined will default to 22 in plugin
	
	localdir="params.localdir" 
	remotedir="params.remotedir"
	splitter = "params.splitter" //optional if not defined it will split per line using &lt;br&gt; for html display of console output
	&gt;
	</pre>
	
	</body>
</html>