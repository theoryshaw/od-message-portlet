
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@ page
	import="com.alacrity.openingdesign.messageportlet.model.service.SKQuestionLocalServiceUtil,com.alacrity.openingdesign.messageportlet.model.model.SKQuestion,java.util.Collection,java.util.Date,java.text.SimpleDateFormat,com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil,com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil,com.liferay.portal.kernel.dao.orm.OrderFactoryUtil,com.liferay.portal.kernel.dao.orm.DynamicQuery"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<jsp:useBean class="java.lang.String" id="threadId" scope="request" />
<jsp:useBean class="java.lang.String" id="returnAction" scope="request" />
<jsp:useBean class="java.lang.String" id="awnserAction" scope="request" />
<jsp:useBean class="java.lang.String" id="awnserActionUrl"
	scope="request" />
<jsp:useBean class="java.lang.String" id="userTime" scope="request" />
<jsp:useBean class="java.lang.String" id="serverTime" scope="request" />
<jsp:useBean class="java.lang.String" id="currentUserId" scope="request" />

<jsp:useBean class="java.lang.String" id="tab" scope="request" />

<jsp:useBean class="java.lang.String" id="viewQuestionUrl"
	scope="request" />
<jsp:useBean class="java.lang.String" id="viewAwnsersUrl"
	scope="request" />
<jsp:useBean class="java.lang.String" id="viewMyAwnserUrl"
	scope="request" />

<portlet:defineObjects />

<div class="topButtons">
<form id="<portlet:namespace />createThread" action="<%=returnAction%>"
	method="post"><input type=submit value="Back to Queries">
</form>
</div>

<%
	SKQuestion question = SKQuestionLocalServiceUtil.getSKQuestion(Long
			.parseLong(threadId));

	SimpleDateFormat format = new SimpleDateFormat("dd-MMMM-yyyy hh:mm");
%>

<div id=tabpane class=tabpane>
<ul class=tabpane>
	<li class=<%=tab.equals("viewQuestion") ? "tabpaneActive" : "tabpane"%>>
	<a href="<%=viewQuestionUrl%>">The Query</a></li>
	<li class=<%=tab.equals("viewAwnsers") ? "tabpaneActive" : "tabpane"%>>
	<a href="<%=viewAwnsersUrl%>">All Answers</a></li>
	<li class=<%=tab.equals("viewMyAwnser") ? "tabpaneActive" : "tabpane"%>>
	<a href="<%=viewMyAwnserUrl%>">My Answer</a></li>
</ul>
</div>
<div id=tabbody class=tabbody>
<%
	if (tab.equals("viewQuestion")) {
%> <span class="questionTime"><%=format.format(question.getPost_Date()
						+ (Integer.parseInt(userTime))
						- (Integer.parseInt(serverTime)))%>
						by <%=UserLocalServiceUtil.getUserById(
						question.getUser_ID()).getScreenName()%></span> <iframe
	src="<%=question.getUrl()%>" class="question">
Your browser doesn't support IFrames </iframe> <%
 	} else if (tab.equals("viewAwnsers")) {
 %>

<div class="answers-actions">
<form id="<portlet:namespace />awnserAction" action="<%=awnserActionUrl%>"
	method="post"><input type=submit value="Add your Answer">
</form>
</div>
<%
	DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(SKQuestion.class)
				.add(PropertyFactoryUtil.forName("Parent_ID").eq(
						Long.parseLong(threadId)))
				.addOrder(OrderFactoryUtil.asc("Post_Date"));

		Collection<SKQuestion> questions = SKQuestionLocalServiceUtil
				.getService().dynamicQuery(query);

		for (SKQuestion cur : questions) {
%> <span class="questionTime"><%=format.format(cur.getPost_Date()
							+ (Integer.parseInt(userTime))
							- (Integer.parseInt(serverTime)))%>
							by <%=UserLocalServiceUtil
							.getUserById(cur.getUser_ID()).getScreenName()%>
							(readonly URL: <%=cur.getHtmlExportURL()%>)</span>
							<div class="htmlrepresentation" id="html<%=cur.getPrimaryKey()%>">
								<%=cur.getHtmlRepresentation()%>
							</div>
							<div class="open-answer-action">
							<button id="open<%= cur.getPrimaryKey() %>">Open</button>
							<button id="open_history<%= cur.getPrimaryKey() %>">History</button>
							</div>
<div class="answer-pad" id="answer<%= cur.getPrimaryKey() %>"><iframe src="<%=cur.getUrl()%>"
	class="allAnswers"> Your browser doesn't support IFrames </iframe></div>
	<div class="history-pad" id="history<%= cur.getPrimaryKey() %>">
		<iframe src="<%= cur.getHistoryUrl() %>">Your browser doesn't support iframes</iframe>
	</div>
<script>
$('#answer<%= cur.getPrimaryKey() %>, #history<%= cur.getPrimaryKey() %>').hide();
$('#open<%= cur.getPrimaryKey() %>').click(function() {
	$('#html<%= cur.getPrimaryKey() %>').hide();
	$('#history<%= cur.getPrimaryKey() %>').hide();
	$('#answer<%= cur.getPrimaryKey() %>').fadeIn();
});
$('#open_history<%= cur.getPrimaryKey() %>').click(function() {
	$('#html<%= cur.getPrimaryKey() %>').hide();
	$('#answer<%= cur.getPrimaryKey() %>').hide();
	$('#history<%= cur.getPrimaryKey() %>').fadeIn();
});

</script>
<%
	}
	} else if (tab.equals("viewMyAwnser")) {

		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(SKQuestion.class)
				.add(PropertyFactoryUtil.forName("Parent_ID").eq(
						Long.parseLong(threadId)))
				.add(PropertyFactoryUtil.forName("User_ID").eq(
						Long.parseLong(currentUserId)))
				.addOrder(OrderFactoryUtil.asc("Post_Date"));

		Collection<SKQuestion> questions = SKQuestionLocalServiceUtil
				.getService().dynamicQuery(query);

		if (questions.size() == 0) {
%>
<form id="<portlet:namespace />createThread"
	action="<%=awnserActionUrl%>" method="post"><input type=hidden
	name=threadId value=<%=threadId%>> <input type=submit
	value="Add your Answer"></form>
<%
	} else {

			for (SKQuestion cur : questions) {
%> <div class="questionTime">Created: <%=format.format(cur.getPost_Date()
								+ (Integer.parseInt(userTime))
								- (Integer.parseInt(serverTime)))%>
								by <%=UserLocalServiceUtil.getUserById(
								cur.getUser_ID()).getScreenName()%>
								(Pad id: <%=cur.getEtherpadId()%>)</div> 
								<iframe
	src="<%=cur.getUrl()%>" class="answers"> Your
browser doesn't support IFrames </iframe> <%
 	}

 		}

 	}
 %>
</div>