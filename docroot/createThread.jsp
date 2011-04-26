<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<jsp:useBean class="java.lang.String" id="padURL" scope="request" />
<jsp:useBean class="java.lang.String" id="submitThreadURL" scope="request" />
<jsp:useBean class="java.lang.String" id="returnAction" scope="request" />
<portlet:defineObjects />

<form id = "<portlet:namespace />createThread"
action="<%=returnAction %>"
method="post">
<input type=submit value="Back to threads">
</form>


<form id = "<portlet:namespace />submitThread"
action="<%=submitThreadURL %>"
method="post">

<b>Title<b/> <br>
<input name=title id=title />
<br>
<br>
<b>Body</b><br>
<iframe src="<%=padURL %>" style="height: 400px; width: 100%; overflow-x: scroll; overflow-y: scroll;" >
Your browser doesn't support IFrames
</iframe>
<input type=hidden name=url value="<%=padURL %>" />
<br>
<input type=submit value="Create">

</form>

