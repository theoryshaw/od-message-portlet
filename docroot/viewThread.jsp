
<%@ page import="com.alacrity.openingdesign.messageportlet.model.service.SKQuestionLocalServiceUtil,
                com.alacrity.openingdesign.messageportlet.model.model.SKQuestion,
                java.util.Collection,
                java.util.Date,
                java.text.SimpleDateFormat,
                com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil,
                com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil,
                com.liferay.portal.kernel.dao.orm.OrderFactoryUtil,
                com.liferay.portal.kernel.dao.orm.DynamicQuery" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<jsp:useBean class="java.lang.String" id="threadId" scope="request" />
<jsp:useBean class="java.lang.String" id="returnAction" scope="request" />
<jsp:useBean class="java.lang.String" id="awnserActionUrl" scope="request" />
<jsp:useBean class="java.lang.String" id="userTime" scope="request" />
<jsp:useBean class="java.lang.String" id="serverTime" scope="request" />

<portlet:defineObjects />

<%
SKQuestion question = SKQuestionLocalServiceUtil.getSKQuestion(Long.parseLong(threadId));

SimpleDateFormat format = new SimpleDateFormat("dd-MMMM-yyyy hh:mm");
%>

<form id = "<portlet:namespace />createThread"
action="<%=returnAction %>"
method="post">
<input type=submit value="Back to threads">
</form>



<h3>Thread: 
<%=question.getTitle() %>
</h3>
<br>

<span style="text-align:right"><%=format.format(question.getPost_Date()+(Integer.parseInt(userTime))-(Integer.parseInt(serverTime))) %></span>
<iframe src="<%=question.getUrl() %>" style="height: 400px; width: 100%;" scrolling=yes >
Your browser doesn't support IFrames
</iframe>

<h3>Awnsers</h3>
<%

DynamicQuery query = DynamicQueryFactoryUtil.forClass(SKQuestion.class)
.add(PropertyFactoryUtil.forName("Parent_ID").eq(Long.parseLong(threadId)))
.addOrder(OrderFactoryUtil.asc("Post_Date"));


Collection<SKQuestion> questions = SKQuestionLocalServiceUtil.getService().dynamicQuery(query);

for (SKQuestion cur : questions){
	%>
	
	
	<span style="text-align:right"><%=format.format(cur.getPost_Date()+(Integer.parseInt(userTime))-(Integer.parseInt(serverTime))) %></span>
	<iframe src="<%=cur.getUrl() %>" style="height: 400px; width: 100%;" scrolling=yes >
    Your browser doesn't support IFrames
    </iframe>
	
	<%
	
	
}
%>





<form id = "<portlet:namespace />createThread"
action="<%=awnserActionUrl %>"
method="post">
<input type=hidden name=threadId value=<%=threadId %>>
<input type=submit value="Add awnser">
</form>