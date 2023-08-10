<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>



<script>
  window.watsonAssistantChatOptions = {
    integrationID: "bee16fc0-467b-4e20-843e-1c1e89a8d7ae", // The ID of this integration.
    region: "us-south", // The region your integration is hosted in.
    serviceInstanceID: "d6521c72-0a29-4871-ad81-42a2de2b4385", // The ID of your service instance.
    onLoad: function(instance) { instance.render(); }
  };
  setTimeout(function(){
    const t=document.createElement('script');
    t.src="https://web-chat.global.assistant.watson.appdomain.cloud/versions/" + (window.watsonAssistantChatOptions.clientVersion || 'latest') + "/WatsonAssistantChatEntry.js";
    document.head.appendChild(t);
  });
</script>
</body>
</html>
