
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
<jsp:useBean class="java.lang.String" id="currentUserId" scope="request" />

<jsp:useBean class="java.lang.String" id="tab" scope="request" />

<jsp:useBean class="java.lang.String" id="viewQuestionUrl" scope="request" />
<jsp:useBean class="java.lang.String" id="viewAwnsersUrl" scope="request" />
<jsp:useBean class="java.lang.String" id="viewMyAwnserUrl" scope="request" />

<portlet:defineObjects />

<div class="topButtons">
<form id = "<portlet:namespace />createThread"
action="<%=returnAction %>"
method="post">
<input type=submit value="Back to threads">
</form>
</div>

<%
SKQuestion question = SKQuestionLocalServiceUtil.getSKQuestion(Long.parseLong(threadId));

SimpleDateFormat format = new SimpleDateFormat("dd-MMMM-yyyy hh:mm");
%>

<div id=tabpane class=tabpane>
    <ul class=tabpane>
        <li class=<%=tab.equals("viewQuestion")?"tabpaneActive":"tabpane" %> >
                <a href="<%=viewQuestionUrl %>">The Query</a>
        </li>
        <li class=<%=tab.equals("viewAwnsers")?"tabpaneActive":"tabpane" %>>
                <a href="<%=viewAwnsersUrl %>">All Awnsers</a>
        </li>
        <li class=<%=tab.equals("viewMyAwnser")?"tabpaneActive":"tabpane" %>>
                <a href="<%=viewMyAwnserUrl %>">My Awnser</a>
        </li>
    </ul>
</div><div id=tabbody class=tabbody>

<%
if (tab.equals("viewQuestion")){%>
	<span class="questionTime"><%=format.format(question.getPost_Date()+(Integer.parseInt(userTime))-(Integer.parseInt(serverTime))) %></span>
        <iframe src="<%=question.getUrl() %>" class="question" scrolling=yes >
            Your browser doesn't support IFrames
        </iframe> <%
} else
if (tab.equals("viewAwnsers")){

DynamicQuery query = DynamicQueryFactoryUtil.forClass(SKQuestion.class)
.add(PropertyFactoryUtil.forName("Parent_ID").eq(Long.parseLong(threadId)))
.addOrder(OrderFactoryUtil.asc("Post_Date"));


Collection<SKQuestion> questions = SKQuestionLocalServiceUtil.getService().dynamicQuery(query);

for (SKQuestion cur : questions){
    %> 
    <span class="questionTime"><%=format.format(cur.getPost_Date()+(Integer.parseInt(userTime))-(Integer.parseInt(serverTime))) %></span>
        <iframe src="<%=cur.getUrl() %>" class="allAwnsers"
	scrolling=yes> Your browser doesn't support IFrames 
	   </iframe> <%
    
    
}
} else
if (tab.equals("viewMyAwnser")){
	
	DynamicQuery query = DynamicQueryFactoryUtil.forClass(SKQuestion.class)
	.add(PropertyFactoryUtil.forName("Parent_ID").eq(Long.parseLong(threadId)))
	.add(PropertyFactoryUtil.forName("User_ID").eq(Long.parseLong(currentUserId)))
	.addOrder(OrderFactoryUtil.asc("Post_Date"));
	
	Collection<SKQuestion> questions = SKQuestionLocalServiceUtil.getService().dynamicQuery(query);
	
	if (questions.size()==0){%>
		<form id = "<portlet:namespace />createThread"
			action="<%=awnserActionUrl %>"
			method="post">
			<input type=hidden name=threadId value=<%=threadId %>>
			<input type=submit value="Add awnser">
			</form><%
	} else {
		
		for (SKQuestion cur : questions){
		    %> 
		    <span class="questionTime"><%=format.format(cur.getPost_Date()+(Integer.parseInt(userTime))-(Integer.parseInt(serverTime))) %></span>
		        <iframe src="<%=cur.getUrl() %>" class="awnsers"
		    scrolling=yes> Your browser doesn't support IFrames 
		       </iframe> <%
		    
		    
		}
		
	}
	
}
%>

</div>