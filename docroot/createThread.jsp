<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<jsp:useBean class="java.lang.String" id="padURL" scope="request" />
<jsp:useBean class="java.lang.String" id="submitThreadURL" scope="request" />
<jsp:useBean class="java.lang.String" id="returnAction" scope="request" />
<portlet:defineObjects />

<div class="topButtons">
<form id = "<portlet:namespace />createThread"
action="<%=returnAction %>"
method="post">
<input type=submit value="Back to Queries">
</form>
</div>


<form id = "<portlet:namespace />submitThread"
action="<%=submitThreadURL %>"
method="post">

<div  class="newThreadForm">
    <div class="newThreadFormLabel">Title</div>
    <div class="newThreadFormField"><input name=title id=title size="65"/></div>
    
    <div class="newThreadFormLabel">Body</div>
    <div class="newThreadFormField"><iframe src="<%=padURL %>"  >
                Your browser doesn't support IFrames
                </iframe>
    </div>
    <input type=hidden name=url value="<%=padURL %>" />
    <input type=submit value="Create">
</div>

</form>

