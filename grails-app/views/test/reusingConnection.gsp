
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'demo.label', default: 'demo runCommand')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<g:render template="menu"/>
	<g:form name="poster" action="reusingConnection">
	Command to run: <g:textField name="usercommand" />
	<g:submitButton name="submit"/>
	</g:form>

		${output.encodeAsRaw() }
	
	</body>
</html>